package net.runelite.client.plugins.titheextended;

import meteor.Main;
import meteor.ui.overlay.OverlayLayer;
import meteor.ui.overlay.OverlayPosition;

import java.util.Map;
import java.util.HashMap;
import java.awt.Dimension;
import java.awt.Graphics2D;
import net.runelite.api.Client;
import net.runelite.api.GameObject;
import net.runelite.api.AnimationID;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;

public class TitheOverlayPlants extends Overlay {
    private final Client client = Main.client;
    private final TithePlugin plugin;
    private final TitheConfig config;

    private WorldPoint location_player_planting_seed;
    public final Map<LocalPoint, TithePlant> plants = new HashMap<>();

    public TitheOverlayPlants(final TithePlugin plugin, final TitheConfig config) {
        this.plugin = plugin;
        this.config = config;

        setPosition(OverlayPosition.DYNAMIC);
        setLayer(OverlayLayer.UNDER_WIDGETS);
    }

    public void onGameObjectSpawned(final GameObject game_object) {
        // Game object is some sort of tithe patch.
        if (TithePlant.isPatch(game_object)) {
            final LocalPoint location_patch = game_object.getLocalLocation();

            // Empty patch, plant completed.
            if (game_object.getId() == TithePlant.TITHE_EMPTY_PATCH) {
                plants.remove(location_patch);

            // Update plant state.
            } else if (plants.containsKey(location_patch)) {
                plants.get(location_patch).setCyclePatch(game_object);
            }

            // GameObject is seedling and player is next to the seedling.
            if (TithePlant.isSeedling(game_object) && TithePlant.isPlayerNear(game_object, location_player_planting_seed)) {
                plants.put(location_patch, new TithePlant(game_object, config));
            }
        }
    }

    public void onGameTick() {
        // Save local point where player did seed planting animation.
        if (client.getLocalPlayer() != null && client.getLocalPlayer().getAnimation() == AnimationID.FARMING_PLANT_SEED) {
            location_player_planting_seed = client.getLocalPlayer().getWorldLocation();
        }

        // Update plants progress.
        for (final TithePlant plant : plants.values()) {
            plant.onGameTick();
        }
    }

    @Override
    public Dimension render(final Graphics2D graphics) {
        if (plugin.inTitheFarm()) {
            for (TithePlant plant : plants.values()) {
                plant.render(graphics);
            }
        }

        return null;
    }
}
