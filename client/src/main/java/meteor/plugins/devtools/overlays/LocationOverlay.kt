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
package meteor.plugins.devtools.overlays

import meteor.Main
import meteor.plugins.devtools.DevToolsConfig
import meteor.ui.components.LineComponent
import meteor.ui.overlay.OverlayPanel
import meteor.ui.overlay.OverlayPosition
import net.runelite.api.Client
import java.awt.Dimension
import java.awt.Graphics2D


class LocationOverlay(private val config: DevToolsConfig) : OverlayPanel() {
    init {
        position = OverlayPosition.TOP_LEFT
    }

    override fun render(graphics: Graphics2D): Dimension? {
        if (!client.isLoggedIn() || !config.location()) return null
        val localWorld = client.getLocalPlayer().getWorldLocation()
        val localPoint = client.getLocalPlayer().getLocalLocation()

        /*		int regionID = localWorld.getRegionID();*/

        /*		if (client.isInInstancedRegion())
		{
			regionID = WorldPoint.fromLocalInstance(client, localPoint).getRegionID();

			getPanelComponent().getChildren().add(new LineComponent.Builder()
                    .left("Instance")
				.build());

			int[][][] instanceTemplateChunks = client.getInstanceTemplateChunks();
			int z = client.getPlane();
			int chunkData = instanceTemplateChunks[z][localPoint.getSceneX() / CHUNK_SIZE][localPoint.getSceneY() / CHUNK_SIZE];

			int rotation = chunkData >> 1 & 0x3;
			int chunkY = (chunkData >> 3 & 0x7FF) * CHUNK_SIZE;
			int chunkX = (chunkData >> 14 & 0x3FF) * CHUNK_SIZE;

			getPanelComponent().getChildren().add(new LineComponent.Builder()
				.left("Chunk " + localPoint.getSceneX() / CHUNK_SIZE + "," + localPoint.getSceneY() / CHUNK_SIZE)
				.right(rotation + " " + chunkX + " " + chunkY)
				.build());
		}*/
        panelComponent.children.add(LineComponent.Builder()
                .left("Base")
                .right(client.getBaseX().toString() + ", " + client.getBaseY())
                .build())

        panelComponent.children.add(LineComponent.Builder()
                .left("Local")
                .right(localPoint.getX().toString() + ", " + localPoint.getY())
                .build())

        panelComponent.children.add(LineComponent.Builder()
                .left("Scene")
                .right(localPoint.sceneX.toString() + ", " + localPoint.sceneY)
                .build())

        panelComponent.children.add(LineComponent.Builder()
                .left("Tile")
                .right(localWorld.getX().toString() + ", " + localWorld.getY() + ", " + client.getPlane())
                .build())

        /*		for (int i = 0; i < client.getMapRegions().length; i++)
		{
			int region = client.getMapRegions()[i];

			getPanelComponent().getChildren().add(new LineComponent.Builder()
				.left((i == 0) ? "Map regions" : " ")
				.right(String.valueOf(region))
				.rightColor((region == regionID) ? Color.GREEN : Color.WHITE)
				.build());
		}*/
        return super.render(graphics)
    }
}
