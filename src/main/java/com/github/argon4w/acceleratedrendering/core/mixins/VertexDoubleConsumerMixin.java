package com.github.argon4w.acceleratedrendering.core.mixins;

import com.github.argon4w.acceleratedrendering.core.buffers.accelerated.builders.IAcceleratedDecalBufferGenerator;
import com.github.argon4w.acceleratedrendering.core.buffers.accelerated.builders.IAcceleratedVertexConsumer;
import com.github.argon4w.acceleratedrendering.core.buffers.accelerated.renderers.IAcceleratedRenderer;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.VertexMultiConsumer;
import net.minecraft.client.renderer.RenderType;
import org.joml.Matrix3f;
import org.joml.Matrix4f;
import org.joml.Vector2f;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;

import java.nio.ByteBuffer;

@Mixin(VertexMultiConsumer.Double.class)
public class VertexDoubleConsumerMixin implements IAcceleratedVertexConsumer {

    @Shadow @Final private VertexConsumer first;
    @Shadow @Final private VertexConsumer second;

    @Unique
    @Override
    public void beginTransform(Matrix4f transformMatrix, Matrix3f normalMatrix) {
        throw new UnsupportedOperationException("Unsupported Operation.");
    }

    @Unique
    @Override
    public void endTransform() {
        throw new UnsupportedOperationException("Unsupported Operation.");
    }

    @Unique
    @Override
    public boolean isAccelerated() {
        return ((IAcceleratedVertexConsumer) first).isAccelerated() && ((IAcceleratedVertexConsumer) second).isAccelerated();
    }

    @Unique
    @Override
    public RenderType getRenderType() {
        throw new UnsupportedOperationException("Unsupported Operation.");
    }

    @Unique
    @Override
    public void addClientMesh(
            ByteBuffer meshBuffer,
            int size,
            int color,
            int light,
            int overlay,
            int decal
    ) {
        throw new UnsupportedOperationException("Unsupported Operation.");
    }

    @Unique
    @Override
    public void addServerMesh(
            int offset,
            int size,
            int color,
            int light,
            int overlay,
            int decal
    ) {
        throw new UnsupportedOperationException("Unsupported Operation.");
    }

    @Unique
    @Override
    public VertexConsumer getDecal(
            Matrix4f transformMatrix,
            Matrix3f normalMatrix,
            float scale,
            int color,
            Vector2f uv0,
            Vector2f uv1,
            IAcceleratedDecalBufferGenerator generator
    ) {
        throw new UnsupportedOperationException("Unsupported Operation.");
    }

    @Unique
    @Override
    public VertexConsumer addVertex(
            float pX,
            float pY,
            float pZ,
            int decal
    ) {
        throw new UnsupportedOperationException("Unsupported Operation.");
    }

    @Unique
    @Override
    public VertexConsumer addVertex(
            PoseStack.Pose pPose,
            float pX,
            float pY,
            float pZ,
            int decal
    ) {
        throw new UnsupportedOperationException("Unsupported Operation.");
    }

    @Unique
    @Override
    public void addVertex(
            float pX,
            float pY,
            float pZ,
            int pColor,
            float pU,
            float pV,
            int pPackedOverlay,
            int pPackedLight,
            float pNormalX,
            float pNormalY,
            float pNormalZ,
            int decal
    ) {
        throw new UnsupportedOperationException("Unsupported Operation.");
    }

    @Unique
    @Override
    public <T>  void doRender(
            IAcceleratedRenderer<T> renderer,
            T context,
            Matrix4f transformMatrix,
            Matrix3f normalMatrix,
            int light,
            int overlay,
            int color
    ) {
        ((IAcceleratedVertexConsumer) first).doRender(
                renderer,
                context,
                transformMatrix,
                normalMatrix,
                light,
                overlay,
                color
        );
        ((IAcceleratedVertexConsumer) second).doRender(
                renderer,
                context,
                transformMatrix,
                normalMatrix,
                light,
                overlay,
                color
        );
    }
}
