/*
 * Copyright (c) 2017, Tyler <https://github.com/tylerthardy>
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
package net.runelite.client.plugins.herbiboars;

import com.google.common.collect.Iterables;
import meteor.Main;
import meteor.ui.overlay.Overlay;
import meteor.ui.overlay.OverlayLayer;
import meteor.ui.overlay.OverlayPosition;
import meteor.util.ColorUtil;
import meteor.util.OverlayUtil;
import net.runelite.api.TileObject;
import net.runelite.api.coords.WorldPoint;
import org.jetbrains.annotations.NotNull;
import org.rationalityfrontline.kevent.KEvent;

import java.awt.*;
import java.util.Set;

class HerbiboarOverlay extends Overlay
{
	private final HerbiboarPlugin plugin;
	private final HerbiboarConfig config;

	public HerbiboarOverlay(HerbiboarPlugin plugin, HerbiboarConfig config)
	{
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_SCENE);
		this.plugin = plugin;
		this.config = config;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (!plugin.isInHerbiboarArea())
		{
			return null;
		}

		HerbiboarSearchSpot.Group currentGroup = plugin.getCurrentGroup();
		TrailToSpot nextTrail = plugin.getNextTrail();
		int finishId = plugin.getFinishId();

		// Draw start objects
		if (config.isStartShown() && (currentGroup == null && finishId == 0))
		{
			plugin.getStarts().values().forEach((obj) -> OverlayUtil.INSTANCE.renderTileOverlay(graphics, obj, "", config.getStartColor()));
		}

		// Draw trails
		if (config.isTrailShown())
		{
			Set<Integer> shownTrailIds = plugin.getShownTrails();
			plugin.getTrails().values().forEach((x) ->
			{
				int id = x.getId();
				if (shownTrailIds.contains(id) && (finishId > 0 || nextTrail != null && !nextTrail.getFootprintIds().contains(id)))
				{
					OverlayUtil.INSTANCE.renderTileOverlay(graphics, x, "", config.getTrailColor());
				}
			});
		}

		// Draw trail objects (mushrooms, mud, etc)
		if (config.isObjectShown() && !(finishId > 0 || currentGroup == null))
		{
			if (plugin.isRuleApplicable())
			{
				WorldPoint correct = Iterables.getLast(plugin.getCurrentPath()).getLocation();
				TileObject object = plugin.getTrailObjects().get(correct);
				drawObjectLocation(graphics, object, config.getObjectColor());
			}
			else
			{
				for (WorldPoint trailLoc : HerbiboarSearchSpot.getGroupLocations(plugin.getCurrentGroup()))
				{
					TileObject object = plugin.getTrailObjects().get(trailLoc);
					drawObjectLocation(graphics, object, config.getObjectColor());
				}
			}
		}

		// Draw finish tunnels
		if (config.isTunnelShown() && finishId > 0)
		{
			WorldPoint finishLoc = plugin.getEndLocations().get(finishId - 1);
			TileObject object = plugin.getTunnels().get(finishLoc);
			drawObjectLocation(graphics, object, config.getTunnelColor());
		}

		return null;
	}

	private void drawObjectLocation(Graphics2D graphics, TileObject object, Color color)
	{
		if (object == null)
		{
			return;
		}

		if (config.showClickBoxes())
		{
			Shape clickbox = object.getClickbox();
			if (clickbox != null)
			{
				Color clickBoxColor = ColorUtil.colorWithAlpha(color, color.getAlpha() / 12);

				graphics.setColor(color);
				graphics.draw(clickbox);
				graphics.setColor(clickBoxColor);
				graphics.fill(clickbox);
			}
		}
		else
		{
			OverlayUtil.INSTANCE.renderTileOverlay(graphics, object, "", color);
		}
	}

	@NotNull
	@Override
	public KEvent getKEVENT_INSTANCE() {
		return Main.INSTANCE.getEventBus();
	}

	@NotNull
	@Override
	public String getSUBSCRIBER_TAG() {
		return "herbiboar";
	}
}
