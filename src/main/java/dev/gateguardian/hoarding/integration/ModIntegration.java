/**
 * 整合模块入口 — 管理 Botania / Ars Nouveau 等可选 mod 的联动加载
 *
 * == 迁移状态 ==
 * 当前 init() 为空。由于 26.1.2 下 Botania/Ars 的兼容版本尚未确认，
 * 所有联动注册代码已注释，用 [TODO-BOTANIA] / [TODO-ARS] 标记。
 *
 * == 恢复步骤（请按顺序执行）==
 * 1. 确认 Botania 和 Ars Nouveau 已发布 26.1.2 的 NeoForge 版本
 * 2. 更新 gradle/libs.versions.toml 中的对应版本号
 * 3. 取消 build.gradle 中 compileOnly/localRuntime 的注释
 * 4. 搜索下方 [TODO-BOTANIA] 和 [TODO-ARS]，取消对应代码的注释
 * 5. 同样处理 StorageBlocks.java 中的 TODO 标记
 */
package dev.gateguardian.hoarding.integration;

import dev.gateguardian.hoarding.Hoarding;
// TODO: 26.1.2 兼容后恢复
// import dev.gateguardian.hoarding.integration.arsnouveau.HoardingArsNouveauBlocks;
// import dev.gateguardian.hoarding.integration.botania.HoardingBotaniaBlocks;
// import net.neoforged.fml.ModList;

public final class ModIntegration {

    public static final String BOTANIA_MOD_ID = "botania";
    public static final String ARS_NOUVEAU_MOD_ID = "ars_nouveau";

    private ModIntegration() {}

    public static void init() {
        // TODO: 26.1.2 兼容后恢复
        // if (isBotaniaLoaded()) {
        //     Hoarding.LOGGER.info("Botania detected - registering integration blocks");
        //     HoardingBotaniaBlocks.init();
        // }
        //
        // if (isArsNouveauLoaded()) {
        //     Hoarding.LOGGER.info("Ars Nouveau detected - registering integration blocks");
        //     HoardingArsNouveauBlocks.init();
        // }
    }

    // TODO: 26.1.2 兼容后恢复
    // public static boolean isBotaniaLoaded() {
    //     return ModList.get().isLoaded(BOTANIA_MOD_ID);
    // }
    //
    // public static boolean isArsNouveauLoaded() {
    //     return ModList.get().isLoaded(ARS_NOUVEAU_MOD_ID);
    // }
}
