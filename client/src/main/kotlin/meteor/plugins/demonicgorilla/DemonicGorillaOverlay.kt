package meteor.plugins.demonicgorilla

import meteor.game.SkillIconManager
import meteor.ui.overlay.Overlay
import net.runelite.api.Perspective
import net.runelite.api.Point
import net.runelite.api.Skill
import net.runelite.api.coords.LocalPoint
import java.awt.BasicStroke
import java.awt.Color
import java.awt.Dimension
import java.awt.Graphics2D
import java.awt.geom.Arc2D
import java.awt.image.BufferedImage
import java.awt.image.ImageObserver

class DemonicGorillaOverlay (var plugin: DemonicGorillaPlugin) : Overlay() {
    private fun getIcon(attackStyle: DemonicGorilla.AttackStyle?): BufferedImage? {
        return when (attackStyle) {
            DemonicGorilla.AttackStyle.MELEE -> SkillIconManager.getSkillImage(Skill.ATTACK)
            DemonicGorilla.AttackStyle.RANGED -> SkillIconManager.getSkillImage(Skill.RANGED)
            DemonicGorilla.AttackStyle.MAGIC -> SkillIconManager.getSkillImage(Skill.MAGIC)
            else -> {
                null
            }
        }
    }

    override fun render(graphics: Graphics2D): Dimension? {
        for (gorilla in plugin.gorillas.values) {
            if (gorilla.npc.interacting == null) continue
            val lp: LocalPoint? = gorilla.npc.localLocation
            if (lp != null) {
                var point: Point? = Perspective.localToCanvas(
                    client, lp, client.plane, gorilla
                        .npc.logicalHeight + 16
                )
                if (point != null) {
                    point = Point(point.x, point.y)
                    val attackStyles = gorilla.nextPossibleAttackStyles
                    val icons: MutableList<BufferedImage?> = ArrayList()
                    var totalWidth = (attackStyles.size - 1) * 8
                    for (attackStyle in attackStyles) {
                        val icon: BufferedImage? = getIcon(attackStyle)
                        icons.add(icon)
                        if (icon != null) totalWidth += icon.width
                    }
                    val bgPadding = 4
                    var currentPosX = 0
                    for (icon in icons) {
                        setProgressIcon(
                            graphics,
                            point,
                            icon!!,
                            totalWidth,
                            bgPadding,
                            currentPosX,
                            COLOR_ICON_BACKGROUND,
                            50,
                            COLOR_ICON_BORDER,
                            COLOR_ICON_BORDER_FILL
                        )
                        val arc: Arc2D.Double = Arc2D.Double(
                            (point.x - totalWidth / 2 + currentPosX - bgPadding).toDouble(),
                            (point.y - icon.height / 2 - 50.0f - bgPadding).toDouble(),
                            (icon.width + bgPadding * 2).toDouble(),
                            (icon.height + bgPadding * 2).toDouble(),
                            90.0,
                            -360.0 * (3 - gorilla.attacksUntilSwitch) / 3.0,
                            0
                        )
                        graphics.draw(arc)
                        currentPosX += icon.width + 8
                    }
                }
            }
        }
        return null
    }

    companion object {
        private val COLOR_ICON_BACKGROUND = Color(0, 0, 0, 128)
        private val COLOR_ICON_BORDER = Color(0, 0, 0, 255)
        private val COLOR_ICON_BORDER_FILL = Color(219, 175, 0, 255)
        fun setProgressIcon(
            graphics: Graphics2D,
            point: Point,
            currentPhaseIcon: BufferedImage,
            totalWidth: Int,
            bgPadding: Int,
            currentPosX: Int,
            colorIconBackground: Color?,
            overlayIconDistance: Int,
            colorIconBorder: Color?,
            colorIconBorderFill: Color?
        ) {
            graphics.stroke = BasicStroke(2.0f)
            graphics.color = colorIconBackground
            graphics.fillOval(
                point
                    .x - totalWidth / 2 + currentPosX - bgPadding, point
                    .y - currentPhaseIcon.height / 2 - overlayIconDistance - bgPadding, currentPhaseIcon
                    .width + bgPadding * 2, currentPhaseIcon
                    .height + bgPadding * 2
            )
            graphics.color = colorIconBorder
            graphics.drawOval(
                point
                    .x - totalWidth / 2 + currentPosX - bgPadding, point
                    .y - currentPhaseIcon.height / 2 - overlayIconDistance - bgPadding, currentPhaseIcon
                    .width + bgPadding * 2, currentPhaseIcon
                    .height + bgPadding * 2
            )
            graphics.drawImage(
                currentPhaseIcon, point
                    .x - totalWidth / 2 + currentPosX, point
                    .y - currentPhaseIcon.height / 2 - overlayIconDistance, null as ImageObserver?
            )
            graphics.color = colorIconBorderFill
        }
    }
}