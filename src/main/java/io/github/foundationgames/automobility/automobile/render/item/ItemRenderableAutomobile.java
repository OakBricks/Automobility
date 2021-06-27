package io.github.foundationgames.automobility.automobile.render.item;

import io.github.foundationgames.automobility.automobile.AutomobileDataReader;
import io.github.foundationgames.automobility.automobile.render.RenderableAutomobile;
import io.github.foundationgames.automobility.util.EntityRenderHelper;
import net.minecraft.client.model.Model;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;

import java.util.HashMap;
import java.util.Map;

public class ItemRenderableAutomobile implements RenderableAutomobile {
    private final AutomobileDataReader reader;
    private final Map<Identifier, Model> frameModelCache = new HashMap<>();
    private final Map<Identifier, Model> wheelModelCache = new HashMap<>();
    private final Map<Identifier, Model> engineModelCache = new HashMap<>();

    public ItemRenderableAutomobile(AutomobileDataReader reader) {
        this.reader = reader;
        EntityRenderHelper.registerContextListener(ctx -> {
            frameModelCache.clear();
            wheelModelCache.clear();
            engineModelCache.clear();
        });
    }

    @Override
    public Model getFrameModel(EntityRendererFactory.Context ctx) {
        if (!frameModelCache.containsKey(reader.getFrame().getId())) frameModelCache.put(reader.getFrame().getId(), reader.getFrame().model().model().apply(ctx));
        return frameModelCache.get(reader.getFrame().getId());
    }

    @Override
    public Model getWheelModel(EntityRendererFactory.Context ctx) {
        if (!wheelModelCache.containsKey(reader.getWheel().getId())) wheelModelCache.put(reader.getWheel().getId(), reader.getWheel().model().model().apply(ctx));
        return wheelModelCache.get(reader.getWheel().getId());
    }

    @Override
    public Model getEngineModel(EntityRendererFactory.Context ctx) {
        if (!engineModelCache.containsKey(reader.getEngine().getId())) engineModelCache.put(reader.getEngine().getId(), reader.getEngine().model().model().apply(ctx));
        return engineModelCache.get(reader.getEngine().getId());
    }

    @Override
    public float getYaw(float tickDelta) {
        return 0;
    }

    @Override
    public float getVerticalTravelPitch(float tickDelta) {
        return 0;
    }

    @Override
    public float getWheelAngle(float tickDelta) {
        return 0;
    }

    @Override
    public float getSteering(float tickDelta) {
        return 0;
    }

    @Override
    public boolean hasPassengers() {
        return false;
    }

    @Override
    public int getBoostTimer() {
        return 0;
    }

    @Override
    public int getDriftTimer() {
        return 0;
    }

    @Override
    public long getWorldTime() {
        return 0;
    }

    @Override
    public boolean automobileOnGround() {
        return true;
    }
}
