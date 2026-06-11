package dev.gateguardian.hoarding.client.particle;

/*
 * TODO: MC 26.1.2 — 粒子系统完全变更
 * =====================================================
 * net.minecraft.client.particle.TextureSheetParticle 已在 MC 26.1.2 中移除。
 * 粒子系统已迁移至新的 API（基于 net.minecraft.client.particle.ParticleEngine 或
 * 新的 ParticleProvider 机制），旧版 SpriteSet / ParticleRenderType 等接口同样已移除。
 *
 * 重写方案（待完成）：
 * 1. 参考新版 Particle API：
 *    - net.minecraft.client.particle.ParticleProvider （新签名）
 *    - ParticleType / ParticleOptions 相关变更
 * 2. SteamParticle 应继承新的基类 Particle（如果存在）或实现新 Provider 接口
 * 3. 注册方式：Client 端使用 ParticleEngine.register 或等效方法
 * 4. HoardingClient.java 中的 registerParticleProviders 方法也需要对应更新
 *
 * 原始实现保留如下供参考，待重写完成后删除此注释块。
 */

//import net.minecraft.client.multiplayer.ClientLevel;
//import net.minecraft.client.particle.*;
//import net.minecraft.core.particles.SimpleParticleType;
//
//public class SteamParticle extends TextureSheetParticle {
//
//    protected SteamParticle(ClientLevel level, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
//        super(level, x, y, z, xSpeed, ySpeed, zSpeed);
//        this.scale(3.0F);
//        this.setSize(0.25F, 0.25F);
//        this.alpha = 0.8F;
//        this.lifetime = this.random.nextInt(15) + 20;
//        this.gravity = 3.0E-6F;
//        this.xd = xSpeed;
//        this.yd = ySpeed + this.random.nextFloat() * 0.002F;
//        this.zd = zSpeed;
//    }
//
//    @Override
//    public void tick() {
//        this.xo = this.x;
//        this.yo = this.y;
//        this.zo = this.z;
//        if (this.age++ < this.lifetime && this.alpha > 0.0F) {
//            this.xd += this.random.nextFloat() * 0.0002F * (this.random.nextBoolean() ? 1 : -1);
//            this.zd += this.random.nextFloat() * 0.0002F * (this.random.nextBoolean() ? 1 : -1);
//            this.yd -= this.gravity;
//            this.move(this.xd, this.yd, this.zd);
//            if (this.alpha > 0.01F) {
//                this.alpha -= 0.015F;
//            }
//        } else {
//            this.remove();
//        }
//    }
//
//    @Override
//    public ParticleRenderType getRenderType() {
//        return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
//    }
//
//    public static class Provider implements ParticleProvider<SimpleParticleType> {
//
//        private final SpriteSet sprites;
//
//        public Provider(SpriteSet sprites) {
//            this.sprites = sprites;
//        }
//
//        @Override
//        public Particle createParticle(SimpleParticleType type, ClientLevel level, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
//            SteamParticle steamParticle = new SteamParticle(level, x, y, z, xSpeed, ySpeed, zSpeed);
//            steamParticle.pickSprite(this.sprites);
//            return steamParticle;
//        }
//    }
//}
