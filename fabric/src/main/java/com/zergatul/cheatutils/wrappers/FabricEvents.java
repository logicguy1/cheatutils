package com.zergatul.cheatutils.wrappers;

import com.zergatul.cheatutils.common.Events;
import com.zergatul.cheatutils.common.events.RenderWorldLastEvent;
import net.fabricmc.fabric.api.client.rendering.v1.WorldRenderEvents;

public class FabricEvents {

    public static void setup() {
        WorldRenderEvents.LAST.register(context -> {
            Events.RenderWorldLast.trigger(new RenderWorldLastEvent(context.matrixStack(), context.tickDelta(), context.projectionMatrix()));
        });
    }
}