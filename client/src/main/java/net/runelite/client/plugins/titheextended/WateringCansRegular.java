package net.runelite.client.plugins.titheextended;

import eventbus.events.ItemContainerChanged;
import net.runelite.api.ItemID;
import net.runelite.api.InventoryID;
import net.runelite.api.ItemContainer;

public class WateringCansRegular {
    private int water_remaining = 0;
    private int water_total = 0;

    public int getWaterRemaining() {
        return water_remaining;
    }

    public int getWaterTotal() {
        return water_total;
    }

    public void onItemContainerChanged(final ItemContainerChanged event) {
        if (event.getContainerId() == InventoryID.INVENTORY.getId()) {
            updateWaterCharges(event.getItemContainer());
        }
    }

    private void updateWaterCharges(final ItemContainer inventory) {
        int water_remaining = 0;

        final int water_0 = inventory.count(ItemID.WATERING_CAN);
        final int water_1 = inventory.count(ItemID.WATERING_CAN1);
        final int water_2 = inventory.count(ItemID.WATERING_CAN2);
        final int water_3 = inventory.count(ItemID.WATERING_CAN3);
        final int water_4 = inventory.count(ItemID.WATERING_CAN4);
        final int water_5 = inventory.count(ItemID.WATERING_CAN5);
        final int water_6 = inventory.count(ItemID.WATERING_CAN6);
        final int water_7 = inventory.count(ItemID.WATERING_CAN7);
        final int water_8 = inventory.count(ItemID.WATERING_CAN8);

        water_remaining += 1 * water_1;
        water_remaining += 2 * water_2;
        water_remaining += 3 * water_3;
        water_remaining += 4 * water_4;
        water_remaining += 5 * water_5;
        water_remaining += 6 * water_6;
        water_remaining += 7 * water_7;
        water_remaining += 8 * water_8;

        this.water_remaining = water_remaining;
        this.water_total = 8 * (water_0 + water_1 + water_2 + water_3 + water_4 + water_5 + water_6 + water_7 + water_8);
    }
}
