/*
 * Copyright (c) 2019, Benjamin <https://github.com/genetic-soybean>
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
import meteor.ui.overlay.Overlay;
import meteor.ui.overlay.OverlayLayer;
import meteor.ui.overlay.OverlayPosition;
import meteor.ui.overlay.OverlayPriority;
import meteor.util.OverlayUtil;
import net.runelite.api.Client;
import net.runelite.api.Perspective;
import net.runelite.api.Point;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import org.jetbrains.annotations.NotNull;
import org.rationalityfrontline.kevent.KEvent;

import java.awt.*;
import java.util.Collection;

class TilemanModeMinimapOverlay extends Overlay
{
	private static final int MAX_DRAW_DISTANCE = 16;
	private static final int TILE_WIDTH = 4;
	private static final int TILE_HEIGHT = 4;

	private final Client client = Main.INSTANCE.getClient();
	private final TilemanModeConfig config;
	private final TilemanModePlugin plugin;

	public TilemanModeMinimapOverlay(TilemanModeConfig config, TilemanModePlugin plugin)
	{
		this.config = config;
		this.plugin = plugin;
		setPosition(OverlayPosition.DYNAMIC);
		setPriority(OverlayPriority.LOW);
		setLayer(OverlayLayer.ABOVE_WIDGETS);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (!config.drawTilesOnMinimap())
		{
			return null;
		}

		final Collection<WorldPoint> points = plugin.getPoints();
		for (final WorldPoint point : points)
		{
			WorldPoint worldPoint = point;
			if (worldPoint.getPlane() != client.getPlane())
			{
				continue;
			}

			drawOnMinimap(graphics, worldPoint);
		}

		return null;
	}

	private void drawOnMinimap(Graphics2D graphics, WorldPoint point)
	{
		WorldPoint playerLocation = client.getLocalPlayer().getWorldLocation();

		if (point.distanceTo(playerLocation) >= MAX_DRAW_DISTANCE)
		{
			return;
		}

		LocalPoint lp = LocalPoint.fromWorld(client, point);
		if (lp == null)
		{
			return;
		}

		Point posOnMinimap = Perspective.localToMinimap(client, lp);
		if (posOnMinimap == null)
		{
			return;
		}

		OverlayUtil.INSTANCE.renderMinimapRect(graphics, posOnMinimap, TILE_WIDTH, TILE_HEIGHT, getTileColor());
	}

	private Color getTileColor() {
		if(config.enableTileWarnings()) {
			if (plugin.getRemainingTiles() <= 0) {
				return Color.RED;
			} else if (plugin.getRemainingTiles() <= config.warningLimit()) {
				return new Color(255, 153, 0);
			}
		}
		return config.markerColor();
	}
}
