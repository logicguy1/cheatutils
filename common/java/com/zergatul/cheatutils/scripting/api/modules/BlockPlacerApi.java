package com.zergatul.cheatutils.scripting.api.modules;

import com.zergatul.cheatutils.controllers.ScriptedBlockPlacerController;
import com.zergatul.cheatutils.scripting.api.ApiType;
import com.zergatul.cheatutils.scripting.api.ApiVisibility;
import com.zergatul.cheatutils.utils.BlockPlacingMethod;

public class BlockPlacerApi {

    public void placeOne() {
        ScriptedBlockPlacerController.instance.placeOne();
    }

    @ApiVisibility(ApiType.BLOCK_PLACER)
    public void setBlockId(String blockId) {
        ScriptedBlockPlacerController.instance.setBlock(blockId, BlockPlacingMethod.ANY);
    }

    @ApiVisibility(ApiType.BLOCK_PLACER)
    public void setBlockId(String blockId, String method) {
        ScriptedBlockPlacerController.instance.setBlock(blockId, parseMethod(method));
    }

    private BlockPlacingMethod parseMethod(String value) {
        return switch (value) {
            case "bottom-slab" -> BlockPlacingMethod.BOTTOM_SLAB;
            case "top-slab" -> BlockPlacingMethod.TOP_SLAB;
            case "facing-top" -> BlockPlacingMethod.FACING_TOP;
            case "facing-bottom" -> BlockPlacingMethod.FACING_BOTTOM;
            case "facing-north" -> BlockPlacingMethod.FACING_NORTH;
            case "facing-south" -> BlockPlacingMethod.FACING_SOUTH;
            case "facing-east" -> BlockPlacingMethod.FACING_EAST;
            case "facing-west" -> BlockPlacingMethod.FACING_WEST;
            default -> BlockPlacingMethod.ANY;
        };
    }
}