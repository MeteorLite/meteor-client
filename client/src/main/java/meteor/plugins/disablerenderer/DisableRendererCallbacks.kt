package meteor.plugins.disablerenderer
import net.runelite.api.*
import net.runelite.api.hooks.DrawCallbacks

class DisableRenderCallbacks : DrawCallbacks {
    override fun draw(renderable: Renderable?, orientation: Int, pitchSin: Int, pitchCos: Int, yawSin: Int, yawCos: Int, x: Int, y: Int, z: Int, hash: Long) {

    }

    override fun drawScenePaint(orientation: Int, pitchSin: Int, pitchCos: Int, yawSin: Int, yawCos: Int, x: Int, y: Int, z: Int, paint: SceneTilePaint?, tileZ: Int, tileX: Int, tileY: Int, zoom: Int, centerX: Int, centerY: Int) {

    }

    override fun drawSceneModel(orientation: Int, pitchSin: Int, pitchCos: Int, yawSin: Int, yawCos: Int, x: Int, y: Int, z: Int, model: SceneTileModel?, tileZ: Int, tileX: Int, tileY: Int, zoom: Int, centerX: Int, centerY: Int) {

    }

    override fun draw(overlayColor: Int) {

    }

    override fun drawFace(model: Model?, face: Int): Boolean {
        return false
    }

    override fun drawScene(cameraX: Int, cameraY: Int, cameraZ: Int, cameraPitch: Int, cameraYaw: Int, plane: Int) {

    }

    override fun postDrawScene() {

    }

    override fun animate(texture: Texture?, diff: Int) {

    }
}