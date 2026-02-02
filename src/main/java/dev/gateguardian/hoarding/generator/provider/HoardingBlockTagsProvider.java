package dev.gateguardian.hoarding.generator.provider;

import dev.gateguardian.hoarding.common.Hoarding;
import dev.gateguardian.hoarding.common.registry.HoardingBlocks;
import dev.gateguardian.hoarding.generator.data.StorageBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;
import java.util.concurrent.CompletableFuture;

public class HoardingBlockTagsProvider extends BlockTagsProvider {

    public HoardingBlockTagsProvider(
            PackOutput output,
            CompletableFuture<HolderLookup.Provider> lookupProvider,
            @Nullable ExistingFileHelper existingFileHelper
    ) {
        super(output, lookupProvider, Hoarding.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        var storageBlocks = tag(Tags.Blocks.STORAGE_BLOCKS);
        for (var entry : StorageBlocks.getEntries()) {
            Block block = entry.getBlock();
            Item item = entry.getItem();
            TagKey<Block> subTag = createStorageBlockSubTag(item);
            String modId = entry.modId();
            if (modId != null) {
                ResourceLocation blockKey = Objects.requireNonNull(
                        ForgeRegistries.BLOCKS.getKey(block), "Block is not registered!"
                );
                tag(subTag).addOptional(blockKey);
                storageBlocks.addOptional(subTag.location());
            } else {
                tag(subTag).add(block);
                storageBlocks.addTag(subTag);
            }
        }
        tag(BlockTags.ENCHANTMENT_POWER_PROVIDER).add(HoardingBlocks.BOOK_PILE.get());
    }

    private TagKey<Block> createStorageBlockSubTag(Item item) {
        ResourceLocation itemKey = Objects.requireNonNull(
                ForgeRegistries.ITEMS.getKey(item), "Item is not registered!"
        );
        return TagKey.create(
                Registries.BLOCK,
                ResourceLocation.fromNamespaceAndPath("forge", "storage_blocks/" + itemKey.getPath())
        );
    }
}
