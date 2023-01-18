package tictac7x.tithe;

import meteor.Main;
import meteor.ui.overlay.OverlayLayer;
import meteor.ui.overlay.OverlayPosition;
import tictac7x.Overlay;
import java.util.Map;
import java.util.HashMap;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.util.function.Supplier;

import net.runelite.api.Client;
import net.runelite.api.ItemID;
import net.runelite.api.InventoryID;
import net.runelite.api.ItemContainer;

public class TitheOverlayInventory extends Overlay {
    private final Client client = Main.client;
    private final TithePlugin plugin;
    private final TitheConfig config;
    private final WateringCanGricollers gricollers_can;

    private final Map<Integer, Supplier<Color>> seeds = new HashMap<>();
    private final Map<Integer, Supplier<Color>> watering_cans = new HashMap<>();
    private final Map<Integer, Supplier<Color>> farmers_outfit = new HashMap<>();

    public TitheOverlayInventory(final TithePlugin plugin, final TitheConfig config, final WateringCanGricollers gricollers_can) {
        this.plugin = plugin;
        this.config = config;
        this.gricollers_can = gricollers_can;

        setPosition(OverlayPosition.DYNAMIC);
        setLayer(OverlayLayer.ABOVE_WIDGETS);

        seeds.put(ItemID.GOLOVANOVA_SEED, config::getHighlightSeedsColor);
        seeds.put(ItemID.BOLOGANO_SEED,   config::getHighlightSeedsColor);
        seeds.put(ItemID.LOGAVANO_SEED,   config::getHighlightSeedsColor);

        watering_cans.put(ItemID.WATERING_CAN8, () -> getColor(color_blue, alpha_normal));
        watering_cans.put(ItemID.WATERING_CAN7, () -> getColor(color_yellow, alpha_normal));
        watering_cans.put(ItemID.WATERING_CAN6, () -> getColor(color_yellow, alpha_normal));
        watering_cans.put(ItemID.WATERING_CAN5, () -> getColor(color_yellow, alpha_normal));
        watering_cans.put(ItemID.WATERING_CAN4, () -> getColor(color_yellow, alpha_normal));
        watering_cans.put(ItemID.WATERING_CAN3, () -> getColor(color_yellow, alpha_normal));
        watering_cans.put(ItemID.WATERING_CAN2, () -> getColor(color_yellow, alpha_normal));
        watering_cans.put(ItemID.WATERING_CAN1, () -> getColor(color_yellow, alpha_normal));
        watering_cans.put(ItemID.WATERING_CAN,  () -> getColor(color_red, alpha_normal));

        farmers_outfit.put(ItemID.FARMERS_STRAWHAT, config::getHighlightFarmersOutfitColor);
        farmers_outfit.put(ItemID.FARMERS_JACKET, config::getHighlightFarmersOutfitColor);
        farmers_outfit.put(ItemID.FARMERS_BORO_TROUSERS, config::getHighlightFarmersOutfitColor);
        farmers_outfit.put(ItemID.FARMERS_BOOTS, config::getHighlightFarmersOutfitColor);
    }

    @Override
    public Dimension render(final Graphics2D graphics) {
        if (plugin.inTitheFarm()) {
            // Highlight seeds.
            for (final int seed_id : seeds.keySet()) {
                highlightInventoryItem(client, graphics, seed_id, seeds.get(seed_id).get());
            }

            // Highlight watering cans.
            if (config.highlightWateringCans()) {

                // Highlight regular watering cans.
                for (final int watering_can_id : watering_cans.keySet()) {
                    highlightInventoryItem(client, graphics, watering_can_id, watering_cans.get(watering_can_id).get());
                }

                // Gricoller's can empty.
                if (gricollers_can.getWaterRemaining() == 0) {
                    highlightInventoryItem(client, graphics, ItemID.GRICOLLERS_CAN, getColor(color_red, alpha_normal));

                // Gricoller's can doesn't have enough charges for 1 run (25 plants).
                } else if (gricollers_can.getWaterRemaining() < 75) {
                    highlightInventoryItem(client, graphics, ItemID.GRICOLLERS_CAN, getColor(color_yellow, alpha_normal));

                // Gricoller's can has charges for multiple runs.
                } else {
                    highlightInventoryItem(client, graphics, ItemID.GRICOLLERS_CAN, getColor(color_blue, alpha_normal));
                }
            }

            // Highlight farmers outfit.
            final ItemContainer inventory = client.getItemContainer(InventoryID.INVENTORY);

            if (
                plugin.countPlayerPlantsNotBlighted() == 0 && inventory != null
                && inventory.count(ItemID.GOLOVANOVA_SEED) == 0
                && inventory.count(ItemID.BOLOGANO_SEED) == 0
                && inventory.count(ItemID.LOGAVANO_SEED) == 0
            ) {
                for (final int farmers_outfit_id : farmers_outfit.keySet()) {
                    highlightInventoryItem(client, graphics, farmers_outfit_id, farmers_outfit.get(farmers_outfit_id).get());
                }
            }
        }

        return null;
    }
}
