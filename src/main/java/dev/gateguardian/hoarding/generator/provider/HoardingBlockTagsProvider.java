package dev.gateguardian.hoarding.generator.provider;

import dev.gateguardian.hoarding.Hoarding;
import dev.gateguardian.hoarding.common.registry.HoardingBlocks;
import dev.gateguardian.hoarding.generator.data.StorageBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;

import java.util.Objects;
import java.util.concurrent.CompletableFuture;

public class HoardingBlockTagsProvider extends BlockTagsProvider {

    public HoardingBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, Hoarding.MOD_ID);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        var storageBlocks = tag(Tags.Blocks.STORAGE_BLOCKS);
        for (var entry : StorageBlocks.getEntries()) {
            Block block = entry.getBlock();
            Item item = entry.getItem();
            TagKey<Block> subTag = createStorageBlockSubTag(item);
            if (entry.modId() != null) {
                tag(subTag).addOptional(block);
                storageBlocks.addOptionalTag(subTag);
            } else {
                tag(subTag).add(block);
                storageBlocks.addTag(subTag);
            }
        }
        tag(BlockTags.ENCHANTMENT_POWER_PROVIDER).add(HoardingBlocks.BOOK_PILE.get());
    }

    private TagKey<Block> createStorageBlockSubTag(Item item) {
        Identifier itemKey = Objects.requireNonNull(
                BuiltInRegistries.ITEM.getKey(item), "Item is not registered!"
        );
        return TagKey.create(
                Registries.BLOCK,
                Identifier.fromNamespaceAndPath("c", "storage_blocks/" + itemKey.getPath())
        );
    }
}
