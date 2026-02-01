package dev.gateguardian.hoarding.generator.data;

import lombok.experimental.UtilityClass;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;

@UtilityClass
public class StorageBlockRegistry {

    private final List<Entry> ENTRIES = new ArrayList<>();

    public void register(Entry entry) {
        ENTRIES.add(entry);
    }

    public Builder builder(Supplier<? extends Block> storageBlock, Supplier<? extends Item> sourceItem) {
        return new Builder(storageBlock, sourceItem);
    }

    public Builder builder(Supplier<? extends Block> storageBlock, Item sourceItem) {
        return new Builder(storageBlock, () -> sourceItem);
    }

    public Builder builder(Block storageBlock, Supplier<? extends Item> sourceItem) {
        return new Builder(() -> storageBlock, sourceItem);
    }

    public List<Entry> getEntries() {
        return Collections.unmodifiableList(ENTRIES);
    }

    public record Entry(
            Supplier<? extends Block> storageBlock,
            Supplier<? extends Item> sourceItem,
            RecipeCategory unpackedCategory,
            RecipeCategory packedCategory,
            @Nullable String modId
    ) {

        public Block getBlock() {
            return storageBlock.get();
        }

        public Item getItem() {
            return sourceItem.get();
        }
    }

    public class Builder {
        private final Supplier<? extends Block> storageBlock;
        private final Supplier<? extends Item> sourceItem;
        private RecipeCategory unpackedCategory = RecipeCategory.MISC;
        private RecipeCategory packedCategory = RecipeCategory.BUILDING_BLOCKS;
        @Nullable
        private String modId = null;

        private Builder(Supplier<? extends Block> storageBlock, Supplier<? extends Item> sourceItem) {
            this.storageBlock = storageBlock;
            this.sourceItem = sourceItem;
        }

        public Builder unpackedCategory(RecipeCategory category) {
            this.unpackedCategory = category;
            return this;
        }

        public Builder packedCategory(RecipeCategory category) {
            this.packedCategory = category;
            return this;
        }

        public Builder modId(String modId) {
            this.modId = modId;
            return this;
        }

        public void build() {
            StorageBlockRegistry.register(new Entry(
                    storageBlock,
                    sourceItem,
                    unpackedCategory,
                    packedCategory,
                    modId
            ));
        }
    }
}
