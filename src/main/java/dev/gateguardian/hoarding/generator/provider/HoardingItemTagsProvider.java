package dev.gateguardian.hoarding.generator.provider;

import dev.gateguardian.hoarding.common.Hoarding;
import dev.gateguardian.hoarding.generator.data.StorageBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;
import java.util.concurrent.CompletableFuture;

public class HoardingItemTagsProvider extends ItemTagsProvider {

    public HoardingItemTagsProvider(
            PackOutput output,
            CompletableFuture<HolderLookup.Provider> lookupProvider,
            CompletableFuture<TagLookup<Block>> blockTags,
            @Nullable ExistingFileHelper existingFileHelper
    ) {
        super(output, lookupProvider, blockTags, Hoarding.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        var storageBlocks = tag(Tags.Items.STORAGE_BLOCKS);
        for (var entry : StorageBlocks.getEntries()) {
            Item block = entry.getBlock().asItem();
            Item item = entry.getItem();
            TagKey<Item> subTag = createStorageBlockSubTag(item);
            String modId = entry.modId();
            if (modId != null) {
                ResourceLocation blockKey = Objects.requireNonNull(
                        ForgeRegistries.ITEMS.getKey(block), "Item is not registered!"
                );
                tag(subTag).addOptional(blockKey);
                storageBlocks.addOptional(subTag.location());
            } else {
                tag(subTag).add(block);
                storageBlocks.addTag(subTag);
            }
        }
    }

    private TagKey<Item> createStorageBlockSubTag(Item item) {
        ResourceLocation itemKey = Objects.requireNonNull(
                ForgeRegistries.ITEMS.getKey(item), "Item is not registered!"
        );
        return TagKey.create(
                Registries.ITEM,
                ResourceLocation.fromNamespaceAndPath("forge", "storage_blocks/" + itemKey.getPath())
        );
    }
}
