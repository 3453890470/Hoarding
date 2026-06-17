package dev.gateguardian.hoarding.generator.provider;

import com.google.gson.JsonParser;
import dev.gateguardian.hoarding.Hoarding;
import dev.gateguardian.hoarding.common.block.HorizontalFacingBlock;
import dev.gateguardian.hoarding.common.registry.HoardingBlocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

/**
 * Generates blockstate JSON ({@code assets/hoarding/blockstates/}) and block model JSON
 * ({@code assets/hoarding/models/block/}) for all Hoarding blocks.
 *
 * <p>NeoForge 26.1.2 removed {@code BlockStateProvider}; this provider writes variant-based
 * blockstate files and standard model files directly via {@link DataProvider#saveStable}.
 *
 * <p>The classification and texture logic mirrors what was previously in
 * {@link HoardingModelProvider}, but only the blockstate and block model portion — item
 * definitions and item models are left to the other providers.
 */
public class HoardingBlockStateProvider implements DataProvider {

    private final PackOutput output;

    // Blocks whose models are hand-crafted in src/main/resources/ — skip model generation
    private static final Set<Block> SKIP_MODEL_GENERATION = Set.of(
        HoardingBlocks.MAGMA_CREAM_BLOCK.get(),
        HoardingBlocks.NAUTILUS_SHELL_BLOCK.get()
    );

    public HoardingBlockStateProvider(PackOutput output) {
        this.output = output;
    }

    @Override
    public CompletableFuture<?> run(CachedOutput cache) {
        var assets = output.getOutputFolder(PackOutput.Target.RESOURCE_PACK).resolve(Hoarding.MOD_ID);
        var bsDir = assets.resolve("blockstates");
        var mbDir = assets.resolve("models").resolve("block");
        var list = new ArrayList<CompletableFuture<?>>();

        HoardingBlocks.BLOCKS.getEntries().forEach(entry -> {
            var block = entry.get();
            var id = BuiltInRegistries.BLOCK.getKey(block);
            if (id == null || !id.getNamespace().equals(Hoarding.MOD_ID)) return;
            gen(cache, list, bsDir, mbDir, block, id.getPath());
        });

        return CompletableFuture.allOf(list.toArray(CompletableFuture[]::new));
    }

    // --------------------------------------------------------------
    // Classification & generation dispatch
    // --------------------------------------------------------------

    private void gen(CachedOutput cache, ArrayList<CompletableFuture<?>> list,
                      Path bsDir, Path mbDir, Block block, String name) {
        // Racks: cube_column with rack_top + <name>_side
        if (name.endsWith("_rack")) {
            emit(cache, list, bsDir, mbDir, name, "s",
                    "minecraft:block/cube_column",
                    "\"end\":\"hoarding:block/rack/rack_top\",\"side\":\"hoarding:block/rack/" + name + "_side\"");
            return;
        }
        // RotatedPillarBlock: cube_column with _end + _side textures, plus _horizontal variant
        if (block instanceof RotatedPillarBlock) {
            var tex = "\"end\":\"hoarding:block/" + name + "_end\",\"side\":\"hoarding:block/" + name + "_side\"";
            emit(cache, list, bsDir, mbDir, name, "p", "minecraft:block/cube_column", tex);
            save(cache, list, mbDir.resolve(name + "_horizontal.json"),
                    "{\"parent\":\"minecraft:block/cube_column_horizontal\",\"textures\":{" + tex + "}}");
            return;
        }
        // Crates: cube_bottom_top, texture varies by content type
        if (name.endsWith("_crate")) {
            crate(cache, list, bsDir, mbDir, name);
            return;
        }
        // Barrels: cube_bottom_top with barrel textures
        if (name.endsWith("_barrel")) {
            emit(cache, list, bsDir, mbDir, name, "s",
                    "minecraft:block/cube_bottom_top",
                    "\"bottom\":\"hoarding:block/barrel/barrel_bottom\",\"side\":\"hoarding:block/barrel/barrel_side\",\"top\":\"hoarding:block/barrel/" + name + "_top\"");
            return;
        }
        // Buckets: cube_bottom_top with bucket textures
        if (name.endsWith("_bucket")) {
            emit(cache, list, bsDir, mbDir, name, "s",
                    "minecraft:block/cube_bottom_top",
                    "\"bottom\":\"hoarding:block/bucket/bucket_bottom\",\"side\":\"hoarding:block/bucket/bucket_side\",\"top\":\"hoarding:block/bucket/" + name + "_top\"");
            return;
        }
        // Simple full blocks (no directional logic)
        if (name.equals("nether_star_block") || name.equals("flint_block")) {
            emit(cache, list, bsDir, mbDir, name, "s",
                    "minecraft:block/cube_all", "\"all\":\"hoarding:block/" + name + "\"");
            return;
        }
        // Bags / Seed Bags: horizontal facing, custom cube_symmetry_north_west parent
        if (name.endsWith("_bag") || name.endsWith("_seeds_bag")) {
            bag(cache, list, bsDir, mbDir, name);
            return;
        }
        // book_pile / paper_stack: custom cube_symmetry_north_west parent
        if (name.equals("book_pile") || name.equals("paper_stack")) {
            stackBlock(cache, list, bsDir, mbDir, name);
            return;
        }
        // scute_block / phantom_membrane_block: custom cube_symmetry_west parent
        if (name.equals("scute_block") || name.equals("phantom_membrane_block")) {
            membraneBlock(cache, list, bsDir, mbDir, name);
            return;
        }
        // Remaining HorizontalFacingBlock instances (nautilus_shell_block, magma_cream_block, etc.)
        if (block instanceof HorizontalFacingBlock) {
            // Blocks with hand-crafted models under src/main/resources/ — blockstate only
            if (SKIP_MODEL_GENERATION.contains(block)) {
                save(cache, list, bsDir.resolve(name + ".json"), blockstate(name, "h"));
                return;
            }
            emit(cache, list, bsDir, mbDir, name, "h",
                    "minecraft:block/cube_all", "\"all\":\"hoarding:block/" + name + "\"");
            return;
        }
        // Default: simple block, all faces same texture
        emit(cache, list, bsDir, mbDir, name, "s",
                "minecraft:block/cube_all", "\"all\":\"hoarding:block/" + name + "\"");
    }

    // --------------------------------------------------------------
    // Crate dispatch
    // --------------------------------------------------------------

    private void crate(CachedOutput cache, ArrayList<CompletableFuture<?>> list,
                        Path bsDir, Path mbDir, String name) {
        String b, s, t;
        var P = "block/crate/";

        if (List.of("allium", "azure_bluet", "blue_orchid", "cornflower", "dandelion", "lily", "oxeye_daisy", "poppy",
                "orange_tulip", "pink_tulip", "red_tulip", "white_tulip", "torchflower").stream().anyMatch(name::startsWith)) {
            // Birch crates — flowers
            b = P + "birch/bottom_birch";
            s = P + "birch/" + name + "_side";
            t = P + "birch/" + name + "_top";
        } else if (List.of("apple", "golden_apple", "potato", "baked_potato", "poisonous_potato", "beetroot",
                "brown_mushroom", "red_mushroom", "carrot", "golden_carrot", "sweet_berries", "glow_berries",
                "cookie", "bread").stream().anyMatch(name::startsWith)) {
            // Oak crates — food / ingredients
            b = P + "oak/bottom_oak";
            s = P + "oak/" + name + "_side";
            t = P + "oak/" + name + "_top";
        } else if (List.of("beef", "cooked_beef", "chicken", "cooked_chicken", "mutton", "cooked_mutton",
                "rabbit", "cooked_rabbit", "rabbit_foot", "porkchop", "cooked_porkchop").stream().anyMatch(name::startsWith)) {
            // Spruce crates — meats
            b = P + "spruce/bottom_spruce";
            s = P + "spruce/" + name + "_side";
            t = P + "spruce/" + name + "_top";
        } else if (name.startsWith("nether_wart") || name.startsWith("crimson_") || name.startsWith("warped_") || name.startsWith("wither_")) {
            // Crimson crates — nether
            b = P + "others/bottom_crimson";
            s = P + "others/" + name + "_side";
            t = P + "others/" + name + "_top";
        } else if (name.startsWith("chorus_") || name.startsWith("popped_")) {
            // End stone crates — end
            b = P + "others/bottom_end_stone";
            s = P + "others/" + name + "_side";
            t = P + "others/" + name + "_top";
        // Botania mystical flower crates
        } else if (name.endsWith("_mystical_flower_crate")) {
            b = P + "botania/bottom_livingwood";
            s = P + "botania/" + name + "_side";
            t = P + "botania/" + name + "_top";
        // Ars Nouveau crates
        } else if (name.equals("magebloom_crate") || name.equals("sourceberry_crate")) {
            b = P + "ars_nouveau/bottom_archwood";
            s = P + "ars_nouveau/" + name + "_side";
            t = P + "ars_nouveau/" + name + "_top";
        } else {
            // Iron crates — default
            b = P + "iron/bottom_iron";
            s = P + "iron/" + name + "_side";
            t = P + "iron/" + name + "_top";
        }

        emit(cache, list, bsDir, mbDir, name, "s",
                "minecraft:block/cube_bottom_top",
                "\"bottom\":\"hoarding:" + b + "\",\"side\":\"hoarding:" + s + "\",\"top\":\"hoarding:" + t + "\"");
    }

    // --------------------------------------------------------------
    // Bag / Seed Bag (cube_symmetry_north_west)
    // --------------------------------------------------------------

    private void bag(CachedOutput cache, ArrayList<CompletableFuture<?>> list,
                      Path bsDir, Path mbDir, String name) {
        var seed = name.endsWith("_seeds_bag");
        var crm = name.equals("blaze_powder_bag");
        var p = seed ? "block/bag/seed_bag/" : "block/bag/sack/";
        var btm = p + (seed ? "seed_bag_bottom" : crm ? "crimson_bag_bottom" : "sack_bottom");
        var n = p + (seed ? "seed_bag_side" : crm ? "crimson_bag_side" : "sack_side");
        var w = p + (seed ? "seed_bag_side_tied" : crm ? "crimson_bag_side_tied" : "sack_side_tied");

        emitCustom(cache, list, bsDir, mbDir, name, "h",
                "hoarding:block/cube_symmetry_north_west",
                "\"bottom\":\"hoarding:" + btm + "\",\"north\":\"hoarding:" + n + "\",\"top\":\"hoarding:" + p + name + "_top\",\"west\":\"hoarding:" + w + "\"");
    }

    // --------------------------------------------------------------
    // book_pile / paper_stack (cube_symmetry_north_west)
    // --------------------------------------------------------------

    private void stackBlock(CachedOutput cache, ArrayList<CompletableFuture<?>> list,
                             Path bsDir, Path mbDir, String name) {
        var p = "block/" + name + "_";
        if (name.equals("book_pile")) {
            emitCustom(cache, list, bsDir, mbDir, name, "h",
                    "hoarding:block/cube_symmetry_north_west",
                    "\"bottom\":\"hoarding:" + p + "bottom\",\"north\":\"hoarding:" + p + "side\",\"top\":\"hoarding:" + p + "top\",\"west\":\"hoarding:" + p + "side_2\"");
        } else {
            emitCustom(cache, list, bsDir, mbDir, name, "h",
                    "hoarding:block/cube_symmetry_north_west",
                    "\"bottom\":\"hoarding:" + p + "top\",\"north\":\"hoarding:" + p + "front\",\"top\":\"hoarding:" + p + "top\",\"west\":\"hoarding:" + p + "side\"");
        }
    }

    // --------------------------------------------------------------
    // scute_block / phantom_membrane_block (cube_symmetry_west)
    // --------------------------------------------------------------

    private void membraneBlock(CachedOutput cache, ArrayList<CompletableFuture<?>> list,
                                Path bsDir, Path mbDir, String name) {
        var p = "block/" + name + "_";
        emitCustom(cache, list, bsDir, mbDir, name, "h",
                "hoarding:block/cube_symmetry_west",
                "\"bottom\":\"hoarding:" + p + "bottom\",\"north\":\"hoarding:" + p + "front\",\"south\":\"hoarding:" + p + "back\",\"top\":\"hoarding:" + p + "top\",\"west\":\"hoarding:" + p + "side\"");
    }

    // --------------------------------------------------------------
    // emit helpers
    // --------------------------------------------------------------

    /**
     * Emit both a blockstate and a block model. The {@code parent} is used as-is
     * (e.g. {@code "minecraft:block/cube_all"} or {@code "hoarding:block/cube_symmetry_north_west"}).
     */
    private void emit(CachedOutput cache, ArrayList<CompletableFuture<?>> list,
                       Path bsDir, Path mbDir, String name, String type, String parent, String textures) {
        var bs = blockstate(name, type);
        var model = "{\"parent\":\"" + parent + "\",\"textures\":{" + textures + "}}";
        save(cache, list, bsDir.resolve(name + ".json"), bs);
        save(cache, list, mbDir.resolve(name + ".json"), model);
    }

    /** Alias for {@link #emit} — kept for clarity when passing custom parents. */
    private void emitCustom(CachedOutput cache, ArrayList<CompletableFuture<?>> list,
                              Path bsDir, Path mbDir, String name, String type, String parent, String textures) {
        emit(cache, list, bsDir, mbDir, name, type, parent, textures);
    }

    // --------------------------------------------------------------
    // Blockstate JSON builder
    // --------------------------------------------------------------

    /**
     * Build the variant-based blockstate JSON string.
     *
     * @param type {@code "h"} = horizontal facing (4 rotations),
     *             {@code "p"} = pillar/axis (3 axis variants),
     *             anything else = simple (single variant).
     */
    private static String blockstate(String name, String type) {
        return switch (type) {
            case "h" -> "{\"variants\":{"
                    + "\"facing=north\":{\"model\":\"hoarding:block/" + name + "\"},"
                    + "\"facing=east\":{\"model\":\"hoarding:block/" + name + "\",\"y\":90},"
                    + "\"facing=south\":{\"model\":\"hoarding:block/" + name + "\",\"y\":180},"
                    + "\"facing=west\":{\"model\":\"hoarding:block/" + name + "\",\"y\":270}}}";
            case "p" -> "{\"variants\":{"
                    + "\"axis=y\":{\"model\":\"hoarding:block/" + name + "\"},"
                    + "\"axis=z\":{\"model\":\"hoarding:block/" + name + "_horizontal\",\"x\":90},"
                    + "\"axis=x\":{\"model\":\"hoarding:block/" + name + "_horizontal\",\"x\":90,\"y\":90}}}";
            default -> "{\"variants\":{\"\":{\"model\":\"hoarding:block/" + name + "\"}}}";
        };
    }

    // --------------------------------------------------------------
    // Persistence
    // --------------------------------------------------------------

    private void save(CachedOutput cache, ArrayList<CompletableFuture<?>> list, Path path, String json) {
        list.add(DataProvider.saveStable(cache, JsonParser.parseString(json), path));
    }

    @Override
    public String getName() {
        return "Hoarding Blockstates & Block Models";
    }
}
