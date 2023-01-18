package tictac7x.tithe;

import meteor.ui.components.LineComponent;
import meteor.ui.overlay.OverlayPosition;
import meteor.ui.overlay.OverlayPriority;
import meteor.ui.overlay.PanelComponent;
import tictac7x.Overlay;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;

public class TitheOverlayWater extends Overlay {
    private final TithePlugin plugin;
    private final TitheConfig config;
    private final WateringCansRegular watering_cans;
    private final WateringCanGricollers gricollers_can;

    private final PanelComponent panel = new PanelComponent();

    private static final int WATER_HIGH = 80;
    private static final int WATER_LOW = 10;

    public TitheOverlayWater(final TithePlugin plugin, final TitheConfig config, final WateringCansRegular watering_cans, final WateringCanGricollers gricollers_can) {
        this.plugin = plugin;
        this.config = config;
        this.watering_cans = watering_cans;
        this.gricollers_can = gricollers_can;

        setPosition(OverlayPosition.ABOVE_CHATBOX_RIGHT);
        setPriority(OverlayPriority.HIGH);
        makePanelResizeable(getPanelComponent(), panel);
    }

    @Override
    public Dimension render(final Graphics2D graphics) {
        if (plugin.inTitheFarm() && config.showWaterAmount()) {
            final int water_remaining = getWaterRemaining();
            final int water_total = getWaterTotal();

            final int water_remaining_percentage = water_total > 0 ? water_remaining * 100 / water_total : 0;
            final Color color =
                water_remaining_percentage >= WATER_HIGH || water_remaining > config.getGricollersCanHighChargesAmount() ? color_blue :
                water_remaining_percentage >= WATER_LOW ? color_yellow :
                color_red;

            panel.getChildren().clear();
            panel.getChildren().add(
                    new LineComponent.Builder()
                    .left("Water:")
                    .right(water_remaining + "/" + water_total)
                    .build()
            );

            panel.setBackgroundColor(getColor(color, panel_background_alpha));

            getPanelComponent().getChildren().clear();
            getPanelComponent().getChildren().add(panel);

            return super.render(graphics);
        }

        return null;
    }

    public int getWaterRemaining() {
        return watering_cans.getWaterRemaining() + gricollers_can.getWaterRemaining();
    }

    private int getWaterTotal() {
        return watering_cans.getWaterTotal() + gricollers_can.getWaterTotal();
    }
}
