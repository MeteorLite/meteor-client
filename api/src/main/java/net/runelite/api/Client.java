/*
 * Copyright (c) 2016-2017, Adam <Adam@sigterm.info>
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
package net.runelite.api;

import net.runelite.api.hooks.Callbacks;
import net.runelite.mapping.Import;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public interface Client
{
	Callbacks getCallbacks();

	void setCallbacks(Callbacks callbacks);

	void main$api();

	ArrayList<InventoryItem> getInventoryItems();

	void setInventoryItems(ArrayList<InventoryItem> inventoryItems);

	int getInventorySize();

	int[] getInventoryItemsIDs();

	int[] getInventoryItemsEquipped();

	int[] getInventoryItemsStackable();

	int[] getInventoryItemsQuantities();

	boolean isStretchedEnabled();

	Dimension getStretchedDimensions();

	boolean isStretchedFast();

	Canvas getCanvas();

	void setCanvas(Canvas canvas);

	JPanel getGamePanel();

	void setGamePanel(JPanel gamePanel);

	void setMaxCanvasWidth(int width);

	void setMaxCanvasHeight(int height);

	Dimension getRealDimensions();

	double getScalingFactor();

	void setScalingFactor(int factor);

	void setStretchedKeepAspectRatio(boolean state);

	void setStretchedIntegerScaling(boolean state);

	void setStretchedFast(boolean state);

	void setStretchedEnabled(boolean state);

	void invalidateStretching(boolean resize);

	boolean isResized();

	void setResized(boolean resized);

	boolean isResizeCanvasNextFrame();

	void setResizeCanvasNextFrame(boolean resizeCanvasNextFrame);

	void resizeCanvas();

	boolean isLoggedIn();

	boolean isClientThread();
}
