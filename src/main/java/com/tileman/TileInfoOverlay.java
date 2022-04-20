/*
 * Copyright (c) 2016-2017, Adam <Adam@sigterm.info>
 * Copyright (c) 2020, ConorLeckey <https://github.com/ConorLeckey>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.tileman;

import meteor.Main;
import meteor.ui.components.LineComponent;
import meteor.ui.overlay.OverlayMenuEntry;
import meteor.ui.overlay.OverlayPanel;
import meteor.ui.overlay.OverlayPosition;
import meteor.ui.overlay.OverlayPriority;
import net.runelite.api.Client;
import org.jetbrains.annotations.NotNull;
import org.rationalityfrontline.kevent.KEvent;

import java.awt.*;

import static meteor.plugins.xptracker.XpInfoBoxOverlay.OPTION_CONFIGURE;
import static net.runelite.api.MenuAction.RUNELITE_OVERLAY_CONFIG;

class TileInfoOverlay extends OverlayPanel {
    private final Client client = Main.INSTANCE.getClient();
    private final TilemanModeConfig config;
    private final TilemanModePlugin plugin;

    private final static String UNSPENT_TILES_STRING = "Available Tiles:";
    private final static String XP_UNTIL_NEXT_TILE = "XP Until Next Tile:";
    private final static String UNLOCKED_TILES = "Tiles Unlocked:";
    private final static String[] STRINGS = new String[] {
        UNSPENT_TILES_STRING,
        XP_UNTIL_NEXT_TILE,
        UNLOCKED_TILES,
    };

    public TileInfoOverlay(TilemanModeConfig config, TilemanModePlugin plugin) {
        this.plugin = plugin;
        this.config = config;
        setPosition(OverlayPosition.TOP_LEFT);
        setPriority(OverlayPriority.MED);
        getMenuEntries().add(new OverlayMenuEntry(RUNELITE_OVERLAY_CONFIG, OPTION_CONFIGURE, "Tileman Mode overlay"));
    }

    @Override
    public Dimension render(Graphics2D graphics) {
        String unspentTiles = addCommasToNumber(plugin.getRemainingTiles());
        String unlockedTiles = addCommasToNumber(plugin.getTotalTiles());
        String xpUntilNextTile = addCommasToNumber(plugin.getXpUntilNextTile());

        getPanelComponent().getChildren().add(new LineComponent.Builder()
                .left(UNSPENT_TILES_STRING)
                .leftColor(getTextColor())
                .right(unspentTiles)
                .rightColor(getTextColor())
                .build());

        if(!(config.enableCustomGameMode() && config.excludeExp())) {
            getPanelComponent().getChildren().add(new LineComponent.Builder()
                    .left(XP_UNTIL_NEXT_TILE)
                    .right(xpUntilNextTile)
                    .build());
        }

        getPanelComponent().getChildren().add(new LineComponent.Builder()
                .left(UNLOCKED_TILES)
                .right(unlockedTiles)
                .build());

        getPanelComponent().setPreferredSize(new Dimension(
                getLongestStringWidth(STRINGS, graphics)
                        + getLongestStringWidth(new String[] {unlockedTiles, unspentTiles}, graphics),
                0));

        return super.render(graphics);
    }

    private Color getTextColor() {
        if(config.enableTileWarnings()) {
            if (plugin.getRemainingTiles() <= 0) {
                return Color.RED;
            } else if (plugin.getRemainingTiles() <= config.warningLimit()) {
                return Color.ORANGE;
            }
        }
        return Color.WHITE;
    }

    private int getLongestStringWidth(String[] strings, Graphics2D graphics) {
        int longest = graphics.getFontMetrics().stringWidth("000000");
        for(String i: strings) {
            int currentItemWidth = graphics.getFontMetrics().stringWidth(i);
            if(currentItemWidth > longest) {
                longest = currentItemWidth;
            }
        }
        return longest;
    }

    private String addCommasToNumber(int number) {
        String input = Integer.toString(number);
        StringBuilder output = new StringBuilder();
        for(int x = input.length() - 1; x >= 0; x--) {
            int lastPosition = input.length() - x - 1;
            if(lastPosition != 0 && lastPosition % 3 == 0) {
                output.append(",");
            }
            output.append(input.charAt(x));
        }
        return output.reverse().toString();
    }
}
