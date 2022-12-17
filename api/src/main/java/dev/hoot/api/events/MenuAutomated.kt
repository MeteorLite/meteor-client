package dev.hoot.api.events

import dev.hoot.api.SceneEntity
import lombok.Builder
import lombok.Getter
import lombok.Setter
import net.runelite.api.Client
import net.runelite.api.MenuAction
import net.runelite.api.MenuEntry
import java.util.function.Consumer

@Getter
@Setter
@Builder
class MenuAutomated {
    companion object {
        lateinit var menu: MenuAutomated

        fun builder() : MenuAutomated {
            menu = MenuAutomated()
            return menu
        }


    }

    fun identifier(id: Int) : MenuAutomated {
        menu.identifier = id
        return menu
    }

    fun opcode(menuAction: MenuAction) : MenuAutomated {
        menu.opcode = menuAction
        return menu
    }

    fun param0(param0: Int) : MenuAutomated {
        menu.param0 = param0
        return menu
    }

    fun param1(param1: Int) : MenuAutomated {
        menu.param1 = param1
        return menu
    }

    fun itemId(itemId: Int) : MenuAutomated {
        menu.itemId = itemId
        return menu
    }

    fun entity(entity: SceneEntity) : MenuAutomated {
        menu.entity = entity
        return menu
    }

    fun clickX(clickX: Int) : MenuAutomated {
        menu.clickX = clickX
        return menu
    }

    fun clickY(clickY: Int) : MenuAutomated {
        menu.clickY = clickY
        return menu
    }

    @Builder.Default
    val option = "Automated"

    @Builder.Default
    val target = ""
    var identifier = 0
    var opcode: MenuAction? = null
    var param0 = 0
    var param1 = 0

    @Builder.Default
    var clickX = -1

    @Builder.Default
    var clickY = -1

    @Builder.Default
    var itemId = -1
    var entity: SceneEntity? = null
    @JvmOverloads
    fun toEntry(client: Client, idx: Int, consumer: Consumer<MenuEntry?>? = null): MenuEntry {
        return toEntry(client, idx, option, target, consumer)
    }

    @JvmOverloads
    fun toEntry(
        client: Client,
        idx: Int,
        option: String?,
        target: String?,
        consumer: Consumer<MenuEntry?>? = null
    ): MenuEntry {
        return client.createMenuEntry(idx)
            .setOption(option)
            .setTarget(target)
            .setIdentifier(identifier)
            .setType(opcode)
            .setParam0(param0)
            .setParam1(param1)
            .onClick(consumer)
    }

    @JvmOverloads
    fun toEntry(client: Client, consumer: Consumer<MenuEntry?>? = null): MenuEntry {
        return toEntry(client, option, target, consumer)
    }

    @JvmOverloads
    fun toEntry(client: Client, option: String?, target: String?, consumer: Consumer<MenuEntry?>? = null): MenuEntry {
        return toEntry(client, -1, option, target, consumer)
    }

    fun toBareEntry(client: Client): MenuEntry {
        return client.createMenuEntry(
            option,
            target,
            identifier,
            opcode!!.id,
            param0,
            param1,
            itemId,
            false
        )
    }
}