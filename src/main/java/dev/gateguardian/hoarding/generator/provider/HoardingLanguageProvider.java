package dev.gateguardian.hoarding.generator.provider;

import com.google.gson.JsonObject;
import dev.gateguardian.hoarding.Hoarding;
import dev.gateguardian.hoarding.common.registry.HoardingItems;
import dev.gateguardian.hoarding.generator.data.StorageBlocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;

import java.util.concurrent.CompletableFuture;

/**
 * Generates {@code assets/hoarding/lang/en_us.json}.
 *
 * <p>NeoForge 26.1.2 removed {@code LanguageProvider}; this is a vanilla
 * {@link DataProvider} that writes the language JSON directly.
 */
public class HoardingLanguageProvider implements DataProvider {

    private final PackOutput output;

    public HoardingLanguageProvider(PackOutput output) {
        this.output = output;
    }

    @Override
    public CompletableFuture<?> run(CachedOutput cache) {
        var json = new JsonObject();

        // Creative mode tab
        json.addProperty("itemGroup.hoarding.main", "Hoarding");

        // Items
        json.addProperty(HoardingItems.PUMPKIN_SLICE.get().getDescriptionId(), "Pumpkin Slice");

        // Blocks — iterate all StorageBlocks entries and derive English names
        for (var entry : StorageBlocks.getEntries()) {
            var block = entry.storageBlock().get();
            var id = BuiltInRegistries.BLOCK.getKey(block);
            if (id != null && id.getNamespace().equals(Hoarding.MOD_ID)) {
                json.addProperty(block.getDescriptionId(), toEnglishName(id.getPath()));
            }
        }

        // Config translations for NeoForge ConfigurationScreen
        json.addProperty("hoarding.config.integration", "Integration");
        json.addProperty("hoarding.config.enableBotaniaIntegration", "Enable Botania Integration");
        json.addProperty("hoarding.config.enableBotaniaIntegration.tooltip", "Show Botania integration blocks and recipes in creative tab and JEI");
        json.addProperty("hoarding.config.enableArsNouveauIntegration", "Enable Ars Nouveau Integration");
        json.addProperty("hoarding.config.enableArsNouveauIntegration.tooltip", "Show Ars Nouveau integration blocks and recipes in creative tab and JEI");

        // Configuration screen translations (screen title, section headers)
        json.addProperty("hoarding.configuration.title", "Hoarding Configuration");
        json.addProperty("hoarding.configuration.section.hoarding.client.toml", "Hoarding");
        json.addProperty("hoarding.configuration.integration", "Integration Settings");
        json.addProperty("hoarding.configuration.integration.tooltip", "Configure integration mod features");

        var path = output.getOutputFolder(PackOutput.Target.RESOURCE_PACK)
                .resolve(Hoarding.MOD_ID).resolve("lang").resolve("en_us.json");
        return DataProvider.saveStable(cache, json, path);
    }

    /** Converts a registry path like {@code "allium_crate"} to {@code "Allium Crate"}. */
    private static String toEnglishName(String path) {
        var parts = path.split("_");
        var sb = new StringBuilder();
        for (var part : parts) {
            if (part.isEmpty()) continue;
            if (!sb.isEmpty()) sb.append(" ");
            sb.append(Character.toUpperCase(part.charAt(0)));
            sb.append(part.substring(1));
        }
        return sb.toString();
    }

    @Override
    public String getName() {
        return "Hoarding Language: en_us";
    }
}
