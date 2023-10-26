package meteor.plugins.thieving

import meteor.game.SkillIconManager
import meteor.ui.overlay.Overlay
import meteor.util.SkillColor
import net.runelite.api.Perspective
import net.runelite.api.Skill
import net.runelite.api.coords.LocalPoint
import openrsc.constants.ObjectID
import java.awt.Color
import java.awt.Dimension
import java.awt.Graphics2D
import java.awt.Point
import java.awt.image.BufferedImage
import java.text.DecimalFormat
import kotlin.math.floor
import kotlin.math.log10
import kotlin.math.pow


class ThievingOverlay(val config: ThievingConfig) : Overlay() {
    val tileItemPiles = HashMap<Point, Int>()

    fun init() {

    }
    override fun render(graphics: Graphics2D): Dimension? {
        graphics.color = SkillColor.THIEVING.color
        if (config.stallIcon()) {
            for (bakerStall in client.getScene().getModels().filterNotNull().filter { it.objectID == ObjectID.STALL_BAKERS.id() }) {
                SkillIconManager.getSkillImage(Skill.THIEVING).let { icon ->
                    Perspective.getCanvasImageLocation(client, bakerStall.centerLocation, icon, -300)?.let {
                        graphics.drawImage(icon, null, it.x, it.y)
                    }
                }
            }
        }
        if (config.stallTilePoly()) {
            for (bakerStall in client.getScene().getModels().filterNotNull().filter { it.objectID == ObjectID.STALL_BAKERS.id() }) {
                val p = Perspective.getCanvasTileAreaPoly(client, bakerStall.getLocalLocation(), bakerStall.getSize())
                if (p != null) {
                    graphics.draw(p)
                }
            }
        }
        return null
    }

    fun prettyCount(number: Number): String {
        val suffix = charArrayOf(' ', 'k', 'M', 'B', 'T', 'P', 'E')
        val numValue = number.toLong()
        val value = floor(log10(numValue.toDouble())).toInt()
        val base = value / 3
        return if (value >= 3 && base < suffix.size) {
            DecimalFormat("#0.0").format(numValue / 10.toDouble().pow((base * 3).toDouble())) + suffix[base]
        } else {
            DecimalFormat("#,##0").format(numValue)
        }
    }
    fun lowValuePrice(): Int {
        return 10000
    }

    fun lowValueColor(): Color {
        return Color.decode("#66B2FF")
    }

    fun mediumValuePrice(): Int {
        return 50000
    }

    fun mediumValueColor(): Color {
        return Color.decode("#99FF99")
    }

    fun highValuePrice(): Int {
        return 350000
    }

    fun highValueColor(): Color {
        return Color.decode("#FF9600")
    }

    fun insaneValuePrice(): Int {
        return 2000000
    }

    fun insaneValueColor(): Color {
        return Color.decode("#FF66B2")
    }
}