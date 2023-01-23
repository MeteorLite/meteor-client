/*
 * Copyright (c) 2019 Hydrox6 <ikada@protonmail.ch>
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
package net.runelite.client.plugins.kourendlibrary;

import meteor.Main;
import meteor.ui.components.LineComponent;
import meteor.ui.overlay.OverlayPanel;
import meteor.ui.overlay.OverlayPosition;
import meteor.ui.overlay.OverlayPriority;
import net.runelite.api.Client;
import net.runelite.api.Player;
import net.runelite.api.coords.WorldPoint;

import javax.inject.Inject;
import java.awt.*;

class KourendLibraryTutorialOverlay extends OverlayPanel
{
	private final Client client = Main.client;
	private final KourendLibraryConfig config;
	private final Library library;

	private final LineComponent noDataMessageComponent;
	private final LineComponent incompleteMessageComponent;
	private final LineComponent completeMessageComponent;
	private final LineComponent sidebarMessageComponent;

	KourendLibraryTutorialOverlay(KourendLibraryConfig config, Library library)
	{
		this.config = config;
		this.library = library;

		getPanelComponent().setPreferredSize(new Dimension(177, 0));

		noDataMessageComponent = new LineComponent.Builder().left("Click on the white squares to start finding books.").build();
		incompleteMessageComponent = new LineComponent.Builder().left("Some books have been found. Keep checking marked bookcases to find more.").build();
		completeMessageComponent = new LineComponent.Builder().left("All books found.").build();
		sidebarMessageComponent = new LineComponent.Builder().left("Locations are in the sidebar.").build();

		setPriority(OverlayPriority.LOW);
		setPosition(OverlayPosition.TOP_LEFT);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (!config.showTutorialOverlay())
		{
			return null;
		}

		Player player = client.getLocalPlayer();
		if (player == null)
		{
			return null;
		}

		WorldPoint playerLoc = player.getWorldLocation();
		if (playerLoc.getRegionID() != KourendLibraryPlugin.REGION)
		{
			return null;
		}

		switch (library.getState())
		{
			case NO_DATA:
				getPanelComponent().getChildren().add(noDataMessageComponent);
				break;
			case INCOMPLETE:
				getPanelComponent().getChildren().add(incompleteMessageComponent);
				getPanelComponent().getChildren().add(sidebarMessageComponent);
				break;
			case COMPLETE:
				getPanelComponent().getChildren().add(completeMessageComponent);
				getPanelComponent().getChildren().add(sidebarMessageComponent);
				break;
		}

		return super.render(graphics);
	}
}
