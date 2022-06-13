package meteor.plugins.xptracker.worldmapwalker;

import com.google.inject.Provides;
import dev.hoot.api.entities.Players;
import dev.hoot.api.movement.Movement;
import meteor.config.ConfigManager;
import meteor.eventbus.Subscribe;
import meteor.input.KeyListener;
import meteor.input.KeyManager;
import meteor.plugins.Plugin;
import meteor.plugins.PluginDescriptor;
import meteor.ui.overlay.OverlayManager;
import meteor.ui.overlay.worldmap.WorldMapOverlay;
import net.runelite.api.*;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.MenuOpened;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static net.runelite.api.widgets.WidgetInfo.MINIMAP_WORLDMAP_OPTIONS;

@PluginDescriptor(
        name = "World Map Walker",
        description = "Right click anywhere within the World Map to walk there",
        enabledByDefault = false
)
@Singleton
public class WorldMapWalkerPlugin extends Plugin {

    private static final String DESTINATION_MENU_TARGET = "<col=00ff00>Destination";
    @Inject
    WorldMapWalkerConfig config;
    WorldPoint mapPoint;
    @Inject
    private WorldMapOverlay worldMapOverlay;
    @Inject
    private KeyManager keyManager;
    @Inject
    private OverlayManager overlayManager;
    @Inject
    private WorldMapWalkerOverlay overlay;
    private boolean hotKeyPressed;
    private Point lastMenuOpenedPoint;

    @Override
    public void startup() {
        keyManager.registerKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                hotKeyPressed = e.isShiftDown();
            }

            @Override
            public void keyReleased(KeyEvent e) {
                hotKeyPressed = e.isShiftDown();
            }
        }, WorldMapWalkerPlugin.class);
        overlayManager.add(overlay);
    }

    @Override
    public void shutdown() {
        overlayManager.remove(overlay);
    }

    @Provides
    public WorldMapWalkerConfig getConfig(ConfigManager configManager) {
        return configManager.getConfig(WorldMapWalkerConfig.class);
    }

    @Subscribe
    public void onGameTick(GameTick event) {
        if (Movement.isWalking()) {
            return;
        }

        if (mapPoint == null || mapPoint.equals(Players.getLocal().getWorldLocation())) {
            mapPoint = null;
            return;
        }

        logger.debug("Destination is {} {}", mapPoint.getX(), mapPoint.getY());
        Movement.walkTo(mapPoint);
    }

    @Subscribe
    public void onMenuOpened(MenuOpened event) { //TODO: Event doesn't work
        lastMenuOpenedPoint = client.getMouseCanvasPosition();
    }

    //Check if menu options have already been added
    private boolean menuContainsEntries() {
        MenuEntry[] entries = client.getMenuEntries();
        if (entries != null) {
            for (MenuEntry entry : entries) {
                if (entry == null) {
                    continue;
                }
                if (entry.getTarget().equals(DESTINATION_MENU_TARGET)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isUserShiftClicking() {
        return config.shiftClickToWalk() && hotKeyPressed;
    }

    @Subscribe
    public void onClientTick(ClientTick event) {

        final Widget map = client.getWidget(WidgetInfo.WORLD_MAP_VIEW);

        // If user clicks on map
        if (map != null && map.getBounds().contains(client.getMouseCanvasPosition().getX(), client.getMouseCanvasPosition().getY())) {
            if (!menuContainsEntries()) {
                if (isUserShiftClicking()) {
                    addMenuEntryFront("Walk to");
                    addMenuEntry("Clear", 0);
                }
            }
        }
        // If user clicks on globe icon on minimap
        for (var menuEntry : client.getMenuEntries()) {
            if (menuEntry.getActionParam1() == MINIMAP_WORLDMAP_OPTIONS.getId()) {
                if (!menuContainsEntries()) {
                    addMenuEntry("Clear", 1);
                    return;
                }
            }
            if (mapPoint != null && menuEntry.getOption().equals("Walk here")) {
                if (!menuContainsEntries()) {
                    addMenuEntry("Clear", 1);
                    return;
                }
            }
        }
    }

    @Subscribe
    public void onMenuEntryAdded(MenuEntryAdded event) {
        final Widget map = client.getWidget(WidgetInfo.WORLD_MAP_VIEW);

        // If user clicks on map
        if (map != null && map.getBounds().contains(client.getMouseCanvasPosition().getX(), client.getMouseCanvasPosition().getY())) {
            if (!menuContainsEntries()) {
                if (!isUserShiftClicking()) {
                    addMenuEntry("Walk to", 0);
                    addMenuEntry("Clear", 0);
                }
            }
        }
    }

    @Subscribe
    public void onMenuOptionClicked(MenuOptionClicked e) {
        if (e.getMenuTarget().equals(DESTINATION_MENU_TARGET)) {
            if (e.getMenuOption().equals("Walk to")) {
                mapPoint = calculateMapPoint(client.isMenuOpen() ? lastMenuOpenedPoint : client.getMouseCanvasPosition());
                logger.debug("Walking to: {}", mapPoint.toString());
            }

            if (e.getMenuOption().equals("Clear")) {
                logger.info("Stopping walking");
                mapPoint = null;
            }
        }
    }

    @Subscribe
    public void onGameStateChanged(GameStateChanged e) {
        if (e.getGameState() == GameState.LOGIN_SCREEN) {
            client.setUsername("");
            client.setPassword("");
        }
    }

    private WorldPoint calculateMapPoint(Point point) {
        float zoom = client.getRenderOverview().getWorldMapZoom();
        RenderOverview renderOverview = client.getRenderOverview();
        final WorldPoint mapPoint = new WorldPoint(renderOverview.getWorldMapPosition().getX(), renderOverview.getWorldMapPosition().getY(), 0);
        final Point middle = worldMapOverlay.mapWorldPointToGraphicsPoint(mapPoint);

        final int dx = (int) ((point.getX() - middle.getX()) / zoom);
        final int dy = (int) ((-(point.getY() - middle.getY())) / zoom);

        return mapPoint.dx(dx).dy(dy);
    }

    private void addMenuEntry(String option, int index) {
        List<MenuEntry> entries = new ArrayList<>(Arrays.asList(client.getMenuEntries()));

        MenuEntry entry = new MenuEntry();
        entry.setOption(option);
        entry.setTarget(DESTINATION_MENU_TARGET);
        entry.setOpcode(MenuAction.RUNELITE.getId());
        entries.add(index, entry);

        client.setMenuEntries(entries.toArray(new MenuEntry[0]));
    }

    private void addMenuEntryFront(String option) {
        client.insertMenuItem(option, DESTINATION_MENU_TARGET, MenuAction.UNKNOWN.getId(), 0, 0, 0, false);
    }

    @Subscribe
    private void onFocusChanged(FocusChanged focusChanged) {
        if (!focusChanged.isFocused()) {
            hotKeyPressed = false;
        }
    }

}
