package net.runelite.client.plugins.titheextended;

import java.util.Map;
import java.util.Set;

import eventbus.events.*;
import meteor.Main;
import meteor.game.ItemManager;
import meteor.plugins.Plugin;
import meteor.plugins.PluginDescriptor;
import meteor.rs.ClientThread;
import meteor.ui.overlay.OverlayManager;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.widgets.WidgetInfo;
import com.google.common.collect.ImmutableSet;

@PluginDescriptor(
	name = "Tithe Farm Improved",
	description = "Improve overall experience for Tithe farm",
	tags = { "tithe", "farm", "farmer", "golovanova", "bologano", "logavano", "gricoller" }
)
public class TithePlugin extends Plugin {
	private final Set<Integer> REGIONS = ImmutableSet.of(6966, 6967, 7222, 7223);
	private boolean in_tithe_farm;

	private TitheConfig config = configuration(TitheConfig.class);
	private Client client = Main.client;
	private ClientThread client_thread = ClientThread.INSTANCE;
	private OverlayManager overlays = OverlayManager.INSTANCE;
	private ItemManager items = ItemManager.INSTANCE;

	private WateringCansRegular   watering_cans;
	private WateringCanGricollers gricollers_can;
	private TitheOverlayWater     overlay_water;
	private TitheOverlayPlants    overlay_plants;
	private TitheOverlayPoints    overlay_points;
	private TitheOverlayPatches   overlay_patches;

	private TitheOverlayInventory overlay_inventory;

	@Override
	public void onStart() {
		//This plugin was coded kind of poorly. We need to hold off on subscribing until onStart is done
		setEventListening(false);

		if (watering_cans == null) {
			watering_cans     = new WateringCansRegular();
			gricollers_can    = new WateringCanGricollers(this, config, watering_cans);
			overlay_water     = new TitheOverlayWater(this, config, watering_cans, gricollers_can);
			overlay_plants    = new TitheOverlayPlants(this, config);
			overlay_points    = new TitheOverlayPoints(this, config);
			overlay_patches   = new TitheOverlayPatches(this, config);
			overlay_inventory = new TitheOverlayInventory(this, config, gricollers_can);
		}

		overlays.add(overlay_water);
		overlays.add(overlay_plants);
		overlays.add(overlay_points);
		overlays.add(overlay_patches);
		overlays.add(overlay_inventory);

		setEventListening(true);
	}

	@Override
	public void onStop() {
		overlays.remove(overlay_water);
		overlays.remove(overlay_plants);
		overlays.remove(overlay_points);
		overlays.remove(overlay_patches);
		overlays.remove(overlay_inventory);
		if (overlay_points != null)
			client_thread.invokeLater(() -> overlay_points.shutDown());
	}

	@Override
	public void onGameObjectSpawned(final GameObjectSpawned event) {
		overlay_plants.onGameObjectSpawned(event.getGameObject());
		gricollers_can.onGameObjectSpawned(event.getGameObject());
	}

	@Override
	public void onItemContainerChanged(final ItemContainerChanged event) {
		watering_cans.onItemContainerChanged(event);
		gricollers_can.onItemContainerChanged(event);
		overlay_points.onItemContainerChanged(event);
	}

	@Override
	public void onGameTick(final GameTick event) {
		overlay_plants.onGameTick();
	}

	@Override
	public void onChatMessage(final ChatMessage event) {
		gricollers_can.onChatMessage(event);
	}

	@Override
	public void onVarbitChanged(final VarbitChanged event) {
		overlay_points.onVarbitChanged();
	}

	@Override
	public void onWidgetLoaded(final WidgetLoaded event) {
		if (event.getGroupId() == WidgetInfo.TITHE_FARM.getGroupId()) {
			if (config.showCustomPoints()) {
				overlay_points.hideNativePoints();
			} else {
				overlay_points.showNativePoints();
			}
		}
	}

	@Override
	public void onConfigChanged(final ConfigChanged event) {
		if (event.getGroup().equals(config.group) && event.getKey().equals(config.points)) {
			client_thread.invokeLater(() -> {
				if (config.showCustomPoints()) {
					overlay_points.hideNativePoints();
				} else {
					overlay_points.showNativePoints();
				}
			});
		}
	}

	@Override
	public void onGameStateChanged(final GameStateChanged event) {
		if (event.getGameState() == GameState.LOADING) {
			updateInTitheFarm();
		}
	}

	public boolean inTitheFarm() {
		return in_tithe_farm;
	}

	private void updateInTitheFarm() {
		final int[] regions = client.getMapRegions();

		for (final int region : regions) {
			if (REGIONS.contains(region)) {
				in_tithe_farm = true;
				return;
			}
		}

		in_tithe_farm = false;
	}

	public Map<LocalPoint, TithePlant> getPlayerPlants() {
		return overlay_plants.plants;
	}

	public int countPlayerPlantsNotBlighted() {
		return (int) getPlayerPlants().values().stream().filter(plant ->
			plant.cycle_state != TithePlant.State.BLIGHTED &&
			plant.cycle_state != TithePlant.State.EMPTY
		).count();
	}
}
