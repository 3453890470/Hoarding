package dev.gateguardian.hoarding.generator.provider;

import com.google.gson.JsonParser;
import dev.gateguardian.hoarding.Hoarding;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;

import java.util.concurrent.CompletableFuture;

/**
 * Generates item model JSON for {@code pumpkin_slice}.
 *
 * <p>NeoForge 26.1.2 removed {@code ItemModelProvider}; the block-item models are
 * handled by {@link HoardingModelProvider}, but the standalone item
 * ({@code pumpkin_slice}) still needs a {@code models/item/pumpkin_slice.json}.
 */
public class HoardingItemModelProvider implements DataProvider {

    private final PackOutput output;

    public HoardingItemModelProvider(PackOutput output) {
        this.output = output;
    }

    @Override
    public CompletableFuture<?> run(CachedOutput cache) {
        var modelDir = output.getOutputFolder(PackOutput.Target.RESOURCE_PACK)
                .resolve(Hoarding.MOD_ID).resolve("models").resolve("item");
        var json = "{\"parent\":\"minecraft:item/generated\",\"textures\":{\"layer0\":\"hoarding:item/pumpkin_slice\"}}";
        return DataProvider.saveStable(cache, JsonParser.parseString(json), modelDir.resolve("pumpkin_slice.json"));
    }

    @Override
    public String getName() {
        return "Hoarding Item Models";
    }
}
