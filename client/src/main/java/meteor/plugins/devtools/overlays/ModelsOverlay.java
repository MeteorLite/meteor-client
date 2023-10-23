/*
 * Copyright (c) 2018, Seth <https://github.com/sethtroll>
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
package meteor.plugins.devtools.overlays;


import meteor.Main;
import meteor.plugins.devtools.DevToolsConfig;
import meteor.ui.components.LineComponent;
import meteor.ui.overlay.Overlay;
import meteor.ui.overlay.OverlayLayer;
import meteor.ui.overlay.OverlayPanel;
import meteor.ui.overlay.OverlayPosition;
import net.runelite.api.Client;
import net.runelite.api.Model;
import net.runelite.api.Perspective;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import openrsc.constants.ObjectID;
import org.jetbrains.annotations.NotNull;

import java.awt.*;

public class ModelsOverlay extends Overlay
{
	private final Client client = Main.client;

	private final DevToolsConfig config;

	public ModelsOverlay(DevToolsConfig config)
	{
		this.config = config;
		setLayer(OverlayLayer.ABOVE_SCENE);
	}

	@Override
	public Dimension render(@NotNull Graphics2D graphics)
	{
		if (config.models()) {
			graphics.setColor(Color.MAGENTA);
			for (Model m : client.getScene().getModels()) {
				if (m != null) {
					if (m.getLocalX() > 0 && m.getLocalY() > 0) {
						Polygon p = Perspective.getCanvasTileAreaPoly(client, m.getLocalLocation(), m.getWidth());
						if (p != null) {
							graphics.draw(p);
						}
						drawTextAboveBoundsShadowed(m.getLocalX(), m.getLocalY(), graphics, m.getObjectID() + ":" + ObjectID.Companion.forID(m.getObjectID()).name());
					}
				}
			}
		}
		return null;
	}

	public void drawTextAboveBoundsShadowed(int x, int y, Graphics2D graphics, String text) {
		Color originalColor = graphics.getColor();
		int textWidth = getTextWidth(graphics, text);
		Point p = Perspective.localToCanvas(client, x, y, client.getPlane());
		if (p != null) {
			graphics.setColor(Color.BLACK);
			graphics.drawString(text, p.x - (textWidth / 2) + 1, p.y + 1);
			graphics.setColor(originalColor);
			graphics.drawString(text, p.x - (textWidth / 2), p.y);
		}
	}

	public int getTextWidth(Graphics2D graphics, String text) {
		return (int) graphics.getFontMetrics().getStringBounds(text, graphics).getWidth();
	}
}
