package net.runelite.client.plugins.titheextended;

import eventbus.events.ChatMessage;
import eventbus.events.ItemContainerChanged;
import meteor.Main;
import meteor.config.ConfigManager;
import net.runelite.api.Client;
import net.runelite.api.ItemID;
import net.runelite.api.GameObject;
import net.runelite.api.InventoryID;
import net.runelite.api.ChatMessageType;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WateringCanGricollers {
    private final int CHARGES_TOTAL = 1000;
    private final Pattern regex_check = Pattern.compile("Watering can charges remaining: (.*)%");
    private final String can_filled = "You fill the watering can from the water barrel.";
    private final String can_full = "Gricoller's can is already full.";

    private final TithePlugin plugin;
    private final TitheConfig config;
    private final WateringCansRegular watering_cans;
    private final Client client = Main.client;

    private int inventory_water_remaining = 0;
    private int water_remaining = 0;
    private boolean can_in_inventory = false;

    public WateringCanGricollers(final TithePlugin plugin, final TitheConfig config, final WateringCansRegular watering_cans) {
        this.plugin = plugin;
        this.config = config;
        this.watering_cans = watering_cans;

        this.water_remaining = config.getGricollersCanCharges();
    }

    public int getWaterRemaining() {
        return can_in_inventory ? water_remaining : 0;
    }

    public int getWaterTotal() {
        return can_in_inventory ? CHARGES_TOTAL : 0;
    }

    public void onChatMessage(final ChatMessage event) {
        if (!plugin.inTitheFarm()) return;
        final Matcher matches;

        // Player checked Gricollers can charges.
        if (event.getType() == ChatMessageType.GAMEMESSAGE && (matches = regex_check.matcher(event.getMessage())).matches() && inventory_water_remaining == watering_cans.getWaterRemaining()) {
            updateGricollersCanCharges(Double.parseDouble(matches.group(1)));

        // Gricoller's can full.
        } else if (event.getType() == ChatMessageType.GAMEMESSAGE && event.getMessage().equals(can_full)) {
            updateGricollersCanCharges(CHARGES_TOTAL);

        // Gricoller's can filled.
        } else if (
            event.getType() == ChatMessageType.SPAM && event.getMessage().equals(can_filled)
        ) {
            // Game message arrives before inventory is changed, so we need to wait 100ms to check if inventory didn't change in the meantime.
            new Thread(() -> {
                try {
                    final int inventory_water_remaining = this.inventory_water_remaining;
                    Thread.sleep(100);

                    // Regular cans amount of water didn't change, which means Gricoller's can was filled.
                    if (watering_cans.getWaterRemaining() == inventory_water_remaining) {
                        updateGricollersCanCharges(CHARGES_TOTAL);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

    public void onItemContainerChanged(final ItemContainerChanged event) {
        if (plugin.inTitheFarm() && event.getContainerId() == InventoryID.INVENTORY.getId()) {
            this.can_in_inventory = event.getItemContainer().count(ItemID.GRICOLLERS_CAN) == 1;
            this.inventory_water_remaining = this.watering_cans.getWaterRemaining();
        }
    }

    public void onGameObjectSpawned(final GameObject game_object) {
        // Game object is some sort of tithe patch.
        if (plugin.inTitheFarm() && TithePlant.isWatered(game_object)) {
            final LocalPoint location_plant = game_object.getLocalLocation();
            final WorldPoint location_player = client.getLocalPlayer() != null ? client.getLocalPlayer().getWorldLocation() : null;

            // Watered plant is player owned and player is near it.
            if (plugin.getPlayerPlants().containsKey(location_plant) && TithePlant.isPlayerNear(game_object, location_player)) {

                // If remaining water charges didn't change, Gricollers can was used.
                if (watering_cans.getWaterRemaining() == inventory_water_remaining) {
                    updateGricollersCanCharges(water_remaining - 1);
                }
            }
        }
    }

    private void updateGricollersCanCharges(final double percentage) {
        updateGricollersCanCharges((int) (percentage * CHARGES_TOTAL / 100));
    }

    private void updateGricollersCanCharges(final int charges) {
        ConfigManager.INSTANCE.setConfiguration(config.group, config.gricollers_can_charges, charges);
        water_remaining = charges;
    }
}
