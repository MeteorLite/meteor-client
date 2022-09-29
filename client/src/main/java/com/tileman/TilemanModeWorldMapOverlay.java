/*
 * Copyright (c) 2019, Benjamin <https://github.com/genetic-soybean>
 * Copyright (c) 2020, Bram91 <https://github.com/Bram91>
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

import java.awt.*;

import meteor.Main;
import meteor.ui.overlay.Overlay;
import meteor.ui.overlay.OverlayLayer;
import meteor.ui.overlay.OverlayPosition;
import meteor.ui.overlay.OverlayPriority;
import net.runelite.api.Client;
import net.runelite.api.Point;
import net.runelite.api.RenderOverview;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import org.jetbrains.annotations.NotNull;
import org.rationalityfrontline.kevent.KEvent;

class TilemanModeWorldMapOverlay extends Overlay {
    private static final int REGION_SIZE = 1 << 6;
    // Bitmask to return first coordinate in region
    private static final int REGION_TRUNCATE = ~((1 << 6) - 1);

    private final Client client = Main.INSTANCE.getClient();
    private final TilemanModeConfig config;
    private final TilemanModePlugin plugin;

    public TilemanModeWorldMapOverlay(TilemanModeConfig config, TilemanModePlugin plugin) {
        this.config = config;
        this.plugin = plugin;
        setPosition(OverlayPosition.DYNAMIC);
        setPriority(OverlayPriority.HIGH);
        setLayer(OverlayLayer.ALWAYS_ON_TOP);
    }

    @Override
    public Dimension render(Graphics2D graphics) {
        if (!config.drawTilesOnWorldMap()) {
            return null;
        }

        drawOnWorldMap(graphics);

        return null;
    }

    private void drawOnWorldMap(Graphics2D graphics) {
        RenderOverview ro = client.getRenderOverview();
        Widget map = client.getWidget(WidgetInfo.WORLD_MAP_VIEW);
        Float pixelsPerTile = ro.getWorldMapZoom();
        if (map == null) {
            return;
        }
        Rectangle worldMapRect = map.getBounds();
        graphics.setClip(worldMapRect);


        int widthInTiles = (int) Math.ceil(worldMapRect.getWidth() / pixelsPerTile);
        int heightInTiles = (int) Math.ceil(worldMapRect.getHeight() / pixelsPerTile);

        Point worldMapPosition = ro.getWorldMapPosition();

        // Offset in tiles from anchor sides
        int yTileMin = worldMapPosition.getY() - heightInTiles / 2;
        int xRegionMin = (worldMapPosition.getX() - widthInTiles / 2) & REGION_TRUNCATE;
        int xRegionMax = ((worldMapPosition.getX() + widthInTiles / 2) & REGION_TRUNCATE) + REGION_SIZE;
        int yRegionMin = (yTileMin & REGION_TRUNCATE);
        int yRegionMax = ((worldMapPosition.getY() + heightInTiles / 2) & REGION_TRUNCATE) + REGION_SIZE;
        int regionPixelSize = (int) Math.ceil(REGION_SIZE * pixelsPerTile);

        for (int x = xRegionMin; x < xRegionMax; x += REGION_SIZE) {
            for (int y = yRegionMin; y < yRegionMax; y += REGION_SIZE) {
                int regionId = ((x >> 6) << 8) | (y >> 6);
                for (final TilemanModeTile tile : plugin.getTiles(regionId)) {
                    if(tile.getZ() != client.getPlane()) {
                        continue;
                    }
                    int yTileOffset = -(yTileMin - y) + 2; // Added offset of 2 as tiles were misaligned
                    int xTileOffset = x + widthInTiles / 2 - worldMapPosition.getX();
                    int xPos = ((int) (xTileOffset * pixelsPerTile)) + (int) worldMapRect.getX();
                    int yPos = (worldMapRect.height - (int) (yTileOffset * pixelsPerTile)) + (int) worldMapRect.getY();
                    int size = (regionPixelSize / (64 - Math.round(48f * ((8f - pixelsPerTile) / 7f))));
                    int tileSize = regionPixelSize / 64;

                    graphics.setColor(new Color(config.markerColor().getRGB()));
                    graphics.fillRect(xPos + (tile.getRegionX() * tileSize), yPos - (tile.getRegionY() * tileSize) + tileSize, size - 1, size - 1);
                    graphics.drawRect(xPos + (tile.getRegionX() * tileSize), yPos - (tile.getRegionY() * tileSize) + tileSize, size - 1, size - 1);
                }
            }
        }
    }
}
