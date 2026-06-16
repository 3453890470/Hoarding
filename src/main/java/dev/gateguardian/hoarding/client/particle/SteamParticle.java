package dev.gateguardian.hoarding.client.particle;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.RandomSource;

public class SteamParticle extends SingleQuadParticle {

    protected SteamParticle(ClientLevel level, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed, TextureAtlasSprite sprite) {
        super(level, x, y, z, sprite);
        this.scale(3.0F);
        this.setSize(0.25F, 0.25F);
        this.alpha = 0.8F;
        this.lifetime = this.random.nextInt(15) + 20;
        this.gravity = 3.0E-6F;
        this.xd = xSpeed;
        this.yd = ySpeed + this.random.nextFloat() * 0.002F;
        this.zd = zSpeed;
    }

    @Override
    public SingleQuadParticle.Layer getLayer() {
        return SingleQuadParticle.Layer.TRANSLUCENT;
    }

    @Override
    public void tick() {
        this.xo = this.x;
        this.yo = this.y;
        this.zo = this.z;
        if (this.age++ < this.lifetime && this.alpha > 0.0F) {
            this.xd += this.random.nextFloat() * 0.0002F * (this.random.nextBoolean() ? 1 : -1);
            this.zd += this.random.nextFloat() * 0.0002F * (this.random.nextBoolean() ? 1 : -1);
            this.yd -= this.gravity;
            this.move(this.xd, this.yd, this.zd);
            if (this.alpha > 0.01F) {
                this.alpha -= 0.015F;
            }
        } else {
            this.remove();
        }
    }

    public static class Provider implements ParticleProvider<SimpleParticleType> {

        private final SpriteSet sprites;

        public Provider(SpriteSet sprites) {
            this.sprites = sprites;
        }

        @Override
        public Particle createParticle(SimpleParticleType type, ClientLevel level, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed, RandomSource random) {
            return new SteamParticle(level, x, y, z, xSpeed, ySpeed, zSpeed, this.sprites.get(random));
        }
    }
}
