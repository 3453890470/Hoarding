package dev.gateguardian.hoarding.generator.provider;

import dev.gateguardian.hoarding.Hoarding;
import dev.gateguardian.hoarding.generator.data.StorageBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ItemTagsProvider;

import java.util.Objects;
import java.util.concurrent.CompletableFuture;

public class HoardingItemTagsProvider extends ItemTagsProvider {

    public HoardingItemTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, Hoarding.MOD_ID);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        var storageBlocks = tag(Tags.Items.STORAGE_BLOCKS);
        for (var entry : StorageBlocks.getEntries()) {
            Item block = entry.getBlock().asItem();
            Item item = entry.getItem();
            TagKey<Item> subTag = createStorageBlockSubTag(item);
            if (entry.modId() != null) {
                tag(subTag).addOptional(block);
                storageBlocks.addOptionalTag(subTag);
            } else {
                tag(subTag).add(block);
                storageBlocks.addTag(subTag);
            }
        }
    }

    private TagKey<Item> createStorageBlockSubTag(Item item) {
        Identifier itemKey = Objects.requireNonNull(
                BuiltInRegistries.ITEM.getKey(item), "Item is not registered!"
        );
        return TagKey.create(
                Registries.ITEM,
                Identifier.fromNamespaceAndPath("c", "storage_blocks/" + itemKey.getPath())
        );
    }
}
