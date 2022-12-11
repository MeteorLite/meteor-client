package meteor.plugins.alchemicalhydra

import meteor.game.SpriteManager
import meteor.ui.overlay.ComponentOrientation
import meteor.ui.overlay.Overlay
import meteor.ui.overlay.OverlayPosition
import meteor.ui.overlay.PanelComponent
import meteor.ui.overlay.components.InfoBoxComponent
import net.runelite.api.Client
import net.runelite.api.SpritePixels
import java.awt.Color
import java.awt.Dimension
import java.awt.Graphics2D
import java.awt.Rectangle
import java.awt.image.BufferedImage

internal class HydraOverlay(
    private val plugin: AlchemicalHydraPlugin,
    private val spriteManager: SpriteManager,
    private val config: HydraConfig
) : Overlay() {
    private val panelComponent = PanelComponent()
    private var stunImg: BufferedImage? = null
        get() {
            if (field == null) {
                field = createStunImage(client)
            }
            return field
        }

    var safeCol: Color? = null

    var medCol: Color? = null

    var badCol: Color? = null

    var stunTicks = 0

    init {
        position = OverlayPosition.BOTTOM_RIGHT
        panelComponent.orientation = ComponentOrientation.VERTICAL
    }

    override fun render(graphics: Graphics2D): Dimension? {
        val hydra = plugin.hydra
        panelComponent.children.clear()
        if (hydra != null) {
            if (stunTicks > 0) {
                addStunOverlay()
            }
            if (config.counting()) {
                addSpecOverlay(hydra)
                addPrayOverlay(hydra)
            }
            panelComponent.setPreferredSize(Dimension(40, 0))
            panelComponent.border = Rectangle(0, 0, 0, 0)
        }
        return panelComponent.render(graphics)
    }

    private fun addStunOverlay() {
        val stunComponent = InfoBoxComponent()
        stunComponent.backgroundColor = badCol!!
        stunComponent.image = stunImg
        stunComponent.text = "        $stunTicks"
        stunComponent.setPreferredSize(Dimension(40, 40))
        panelComponent.children.add(stunComponent)
    }

    private fun addSpecOverlay(hydra: Hydra) {
        val phase = hydra.phase
        val nextSpec = hydra.nextSpecialRelative
        if (nextSpec > 3) {
            return
        }
        val specComponent = InfoBoxComponent()
        if (nextSpec == 0) {
            specComponent.backgroundColor = badCol!!
        } else if (nextSpec == 1) {
            specComponent.backgroundColor = medCol!!
        }
        specComponent.image = phase.getSpecImage(spriteManager)
        specComponent.text = "        $nextSpec" // hacky way to not have to figure out how to move text
        specComponent.setPreferredSize(Dimension(40, 40))
        panelComponent.children.add(specComponent)
    }

    private fun addPrayOverlay(hydra: Hydra) {
        val nextPrayer = hydra.nextAttack.prayer
        val nextSwitch = hydra.nextSwitch
        val prayComponent = InfoBoxComponent()
        if (nextSwitch == 1) {
            prayComponent.backgroundColor = if (client.isPrayerActive(nextPrayer)) medCol!! else badCol!!
        } else {
            prayComponent.backgroundColor = if (client.isPrayerActive(nextPrayer)) safeCol!! else badCol!!
        }
        prayComponent.image = hydra.nextAttack.getImage(spriteManager)
        prayComponent.text = "        $nextSwitch"
        prayComponent.color = Color.white
        prayComponent.setPreferredSize(Dimension(40, 40))
        panelComponent.children.add(prayComponent)
    }

    companion object {
        const val IMGSIZE = 36
        private fun createStunImage(client: Client): BufferedImage? {
            val root = getSprite(client, 1788) ?: return null
            return root.toBufferedImage()
        }

        private fun getSprite(client: Client, id: Int): SpritePixels? {
            val spriteDb = client.indexSprites
            if (spriteDb != null) {
                val sprites = client.getSprites(spriteDb, id, 0)
                if (sprites != null) {
                    return sprites[0]
                }
            }
            return null
        }
    }
}