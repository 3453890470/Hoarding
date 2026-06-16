package dev.gateguardian.hoarding.generator;

import dev.gateguardian.hoarding.Hoarding;
import dev.gateguardian.hoarding.generator.data.StorageBlocks;
import net.neoforged.fml.common.EventBusSubscriber;

/**
 * 数据生成器
 *
 * == 迁移状态 ==
 * 核心 mod 代码已适配 MC 26.1.2，编译通过。
 * DataGen 的 API 在 MC 26.1.2 中有重大变更（DataGenerator、RecipeProvider、LootProvider 等原生 Minecraft 类），
 * 当前暂时注释掉所有 Provider 的注册，等后续补充 MC 26.1.2 DataGen 实现。
 *
 * == TODO: 恢复步骤 ==
 * 1. 查阅 MC 26.1.2 的 DataGenerator API（net.minecraft.data.DataGenerator）
 *    - addProvider(DataProvider) 不再接受 boolean 参数
 *    - DataProvider 构造器签名可能已变
 * 2. 查阅 NeoForge 26.1.2 的 LootTableProvider 和 RecipeProvider
 * 3. 逐个恢复以下 Provider 的注册
 * 4. 模型提供者（BlockStateProvider/ItemModelProvider）需用 MC 26.1.2 的 net.minecraft.client.data.models.*
 * 5. GatherDataEvent 为抽象类，需改为 GatherDataEvent.Server 或 GatherDataEvent.Client
 */
@EventBusSubscriber(modid = Hoarding.MOD_ID)
public class DataGenerator {

    // TODO: 26.1.2 恢复 DataGen — GatherDataEvent 为抽象类，需监听其子类
    // @SubscribeEvent
    // public static void bootstrap(GatherDataEvent event) {
    //     StorageBlocks.init();
    //     //
    //     // var generator = event.getGenerator();
    //     // PackOutput output = generator.getPackOutput();
    //     // CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
    //     //
    //     // // 客户端侧 DataGen
    //     // if (event instanceof GatherDataEvent.Client) {
    //     //     generator.addProvider(new HoardingLanguageProvider(output));
    //     // }
    //     //
    //     // // 服务端侧 DataGen
    //     // if (event instanceof GatherDataEvent.Server) {
    //     //     generator.addProvider(new HoardingLootProvider(output, lookupProvider));
    //     //     generator.addProvider(new HoardingRecipeProvider(output, lookupProvider));
    //     //     BlockTagsProvider blockTagsProvider = new HoardingBlockTagsProvider(output, lookupProvider, Hoarding.MOD_ID);
    //     //     generator.addProvider(blockTagsProvider);
    //     //     generator.addProvider(
    //     //             new HoardingItemTagsProvider(output, lookupProvider, blockTagsProvider.contentsGetter(), Hoarding.MOD_ID)
    //     //     );
    //     // }
    // }
}
