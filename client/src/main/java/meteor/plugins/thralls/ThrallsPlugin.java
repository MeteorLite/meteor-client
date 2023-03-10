package meteor.plugins.thralls;

import dev.hoot.api.game.Game;
import dev.hoot.api.game.Skills;
import dev.hoot.api.magic.Magic;
import dev.hoot.api.magic.Necromancy;
import dev.hoot.api.packets.WidgetPackets;
import dev.hoot.api.widgets.Widgets;
import eventbus.events.GameTick;
import lombok.extern.slf4j.Slf4j;
import meteor.api.Items;
import meteor.input.KeyListener;
import meteor.input.KeyManager;
import meteor.plugins.Plugin;
import meteor.plugins.PluginDescriptor;
import meteor.rs.ClientThread;
import net.runelite.api.Skill;
import net.runelite.api.widgets.Widget;
import org.jetbrains.annotations.NotNull;

import java.awt.event.KeyEvent;

/**
 * @author Hayden#7709
 */
@Slf4j
@PluginDescriptor(name="Thralls", description = "Automatically summons Thralls for you")
public class ThrallsPlugin extends Plugin implements KeyListener {

    private final ThrallsConfig config = configuration(ThrallsConfig.class);
    private static final int THRAWL_SPAWNED_VARBIT = 12413;
    private static final int SPAWN_DELAY = 10_000;
    private long lastTimeCasted = System.currentTimeMillis() - SPAWN_DELAY;

    @Override
    public void onStart() {
        KeyManager.INSTANCE.registerKeyListener(this, getClass());
    }

    @Override
    public void onStop() {
        KeyManager.INSTANCE.unregisterKeyListener(this);
    }

    @Override
    public void onGameTick(@NotNull GameTick gameTickEvent) {
        if(!config.autoCastThralls()) {
            return;
        }
        long now = System.currentTimeMillis();
        if(now <= lastTimeCasted + SPAWN_DELAY) {
            return;
        }
        attemptSpawnThralls();
    }

    public void attemptSpawnThralls() {
        if(!Game.isLoggedIn()) {
            return;
        }
        if(Magic.SpellBook.getCurrent() != Magic.SpellBook.NECROMANCY) {
            return;
        }
        if(!Items.INSTANCE.inventoryContains("Book of the dead")) {
            return;
        }
        final boolean isThrallSpawned = getClient().getVarbitValue(THRAWL_SPAWNED_VARBIT) == 1;
        if(isThrallSpawned) {
            return;
        }
        Necromancy spell = config.getThrallType().getSpellToCast();
        if (Skills.getBoostedLevel(Skill.MAGIC) < spell.getLevel()) {
            return;
        }
        Widget spellWidget = Widgets.fromId(spell.getWidget().getPackedId());
        WidgetPackets.widgetFirstOption(spellWidget);
        lastTimeCasted = System.currentTimeMillis();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(config.getManualTrigger().matches(e)) {
            ClientThread.INSTANCE.invokeLater(this::attemptSpawnThralls);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}
}
