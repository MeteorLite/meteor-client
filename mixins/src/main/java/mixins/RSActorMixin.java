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
package mixins;

import dev.hoot.api.util.Randomizer;
import eventbus.Events;
import eventbus.events.*;
import java.awt.Rectangle;
import java.awt.Shape;
import net.runelite.api.Actor;
import net.runelite.api.Hitsplat;
import net.runelite.api.NPC;
import net.runelite.api.NPCComposition;
import net.runelite.api.Perspective;
import net.runelite.api.Player;
import net.runelite.api.Point;
import net.runelite.api.SpritePixels;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldArea;
import net.runelite.api.coords.WorldPoint;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.image.BufferedImage;
import java.util.Random;

import net.runelite.api.mixins.FieldHook;
import net.runelite.api.mixins.Inject;
import net.runelite.api.mixins.MethodHook;
import net.runelite.api.mixins.Mixin;
import net.runelite.api.mixins.Shadow;
import net.runelite.rs.api.RSActor;
import net.runelite.rs.api.RSClient;
import net.runelite.rs.api.RSHealthBar;
import net.runelite.rs.api.RSHealthBarDefinition;
import net.runelite.rs.api.RSHealthBarUpdate;
import net.runelite.rs.api.RSIterableNodeDeque;
import net.runelite.rs.api.RSNode;

@Mixin(RSActor.class)
public abstract class RSActorMixin implements RSActor
{
	@Shadow("client")
	private static RSClient client;

	@Inject
	private boolean dead;

	@Inject
	@Override
	public Actor getInteracting()
	{
		try
		{
			int index = getRSInteracting();
			if (index == -1 || index == 65535 || index == 16777215)
			{
				return null;
			}

			int var2 = 65536;
			if (index < var2)
			{
				NPC[] npcs = client.getCachedNPCs();
				return npcs[index];
			}

			index -= var2;
			Player[] players = client.getCachedPlayers();
			return players[index];
		}
		catch (ArrayIndexOutOfBoundsException e)
		{
			e.printStackTrace();
			return null;
		}
	}

	@Inject
	@Override
	public int getHealthRatio()
	{
		RSIterableNodeDeque healthBars = getHealthBars();
		if (healthBars != null)
		{
			RSNode current = healthBars.getCurrent();
			RSNode next = current.getNext();
			if (next instanceof RSHealthBar)
			{
				RSHealthBar wrapper = (RSHealthBar) next;
				RSIterableNodeDeque updates = wrapper.getUpdates();

				RSNode currentUpdate = updates.getCurrent();
				RSNode nextUpdate = currentUpdate.getNext();
				if (nextUpdate instanceof RSHealthBarUpdate)
				{
					RSHealthBarUpdate update = (RSHealthBarUpdate) nextUpdate;
					return update.getHealthRatio();
				}
			}
		}
		return -1;
	}

	@Inject
	@Override
	public int getHealthScale()
	{
		RSIterableNodeDeque healthBars = getHealthBars();
		if (healthBars != null)
		{
			RSNode current = healthBars.getCurrent();
			RSNode next = current.getNext();
			if (next instanceof RSHealthBar)
			{
				RSHealthBar wrapper = (RSHealthBar) next;
				RSHealthBarDefinition definition = wrapper.getDefinition();
				return definition.getHealthScale();
			}
		}
		return -1;
	}

	@Inject
	@Override
	public WorldPoint getWorldLocation()
	{
		return WorldPoint.fromLocal(client,
			this.getPathX()[0] * Perspective.LOCAL_TILE_SIZE + Perspective.LOCAL_TILE_SIZE / 2,
			this.getPathY()[0] * Perspective.LOCAL_TILE_SIZE + Perspective.LOCAL_TILE_SIZE / 2,
			client.getPlane());
	}

	@Inject
	@Override
	public LocalPoint getLocalLocation()
	{
		return new LocalPoint(getX(), getY());
	}

	@Inject
	@Override
	public Polygon getCanvasTilePoly()
	{
		return Perspective.getCanvasTilePoly(client, getLocalLocation());
	}

	@Inject
	@Override
	public Point getCanvasTextLocation(Graphics2D graphics, String text, int zOffset)
	{
		return Perspective.getCanvasTextLocation(client, graphics, getLocalLocation(), text, zOffset);
	}

	@Inject
	@Override
	public Point getCanvasImageLocation(BufferedImage image, int zOffset)
	{
		return Perspective.getCanvasImageLocation(client, getLocalLocation(), image, zOffset);
	}

	@Inject
	@Override
	public Point getCanvasSpriteLocation(SpritePixels spritePixels, int zOffset)
	{
		return Perspective.getCanvasSpriteLocation(client, getLocalLocation(), spritePixels, zOffset);
	}

	@Inject
	@Override
	public Point getMinimapLocation()
	{
		return Perspective.localToMinimap(client, getLocalLocation());
	}

	@FieldHook("sequence")
	@Inject
	public void animationChanged(int idx)
	{
		AnimationChanged animationChange = new AnimationChanged(this);
		client.getCallbacks().post(Events.ANIMATION_CHANGED, animationChange);
	}

	@MethodHook(value = "updateSpotAnimation", end = true)
	@Inject
	public void onGraphicChanged(int idx, int graphicID, int graphicHeight, int graphicStartCycle)
	{
		GraphicChanged graphicChanged = new GraphicChanged(this);
		client.getCallbacks().post(Events.GRAPHIC_CHANGED, graphicChanged);
	}

	@FieldHook("targetIndex")
	@Inject
	public void interactingChanged(int idx)
	{
		InteractingChanged interactingChanged = new InteractingChanged(this, getInteracting(), getRSInteracting());
		client.getCallbacks().post(Events.INTERACTING_CHANGED, interactingChanged);
	}

	@FieldHook("overheadText")
	@Inject
	public void overheadTextChanged(int idx)
	{
		String overheadText = getOverheadText();
		if (overheadText != null)
		{
			OverheadTextChanged overheadTextChanged = new OverheadTextChanged(this, overheadText);
			client.getCallbacks().post(Events.OVERHEAD_TEXT_CHANGED, overheadTextChanged);
		}
	}

	@Inject
	@Override
	public WorldArea getWorldArea()
	{
		int size = 1;
		if (this instanceof NPC)
		{
			NPCComposition composition = ((NPC)this).getComposition();
			if (composition != null && composition.getConfigs() != null)
			{
				composition = composition.transform();
			}
			if (composition != null)
			{
				size = composition.getSize();
			}
		}

		return new WorldArea(this.getWorldLocation(), size, size);
	}

	@Inject
	@Override
	public boolean isDead()
	{
		return dead;
	}

	@Inject
	@Override
	public void setDead(boolean dead)
	{
		this.dead = dead;
	}

	@Inject
	@MethodHook("addHealthBar")
	public void setCombatInfo(int combatInfoId, int gameCycle, int var3, int var4, int healthRatio, int health)
	{
		if (healthRatio == 0)
		{
			final ActorDeath event = new ActorDeath(this);
			client.getCallbacks().post(Events.ACTOR_DEATH, event);

			this.setDead(true);
		}

		final HealthBarUpdated event = new HealthBarUpdated(this, healthRatio);
		client.getCallbacks().post(Events.HEALTH_BAR_UPDATED, event);
	}

	/**
	 * Called after a hitsplat has been processed on an actor.
	 * Note that this event runs even if the hitsplat didn't show up,
	 * i.e. the actor already had 4 visible hitsplats.
	 *
	 * @param type The hitsplat type (i.e. color)
	 * @param value The value of the hitsplat (i.e. how high the hit was)
	 * @param var3 unknown
	 * @param var4 unknown
	 * @param gameCycle The gamecycle the hitsplat was applied on
	 * @param duration The amount of gamecycles the hitsplat will last for
	 */
	@Inject
	@MethodHook(value = "addHitSplat", end = true)
	public void applyActorHitsplat(int type, int value, int var3, int var4, int gameCycle, int duration)
	{
		final Hitsplat hitsplat = new Hitsplat(type, value, gameCycle + duration);
		final HitsplatApplied event = new HitsplatApplied(this, hitsplat);
		client.getCallbacks().post(Events.HITSPLAT_APPLIED, event);
	}

	@Inject
	@Override
	public boolean isMoving()
	{
		return getPathLength() > 0;
	}

	@Inject
	public boolean isInCombat()
	{
		return getInteracting() != null;
	}

	@Inject
	@Override
	public java.awt.Point getClickPoint()
	{
		Random rand = new Random();
		java.awt.Point point = Randomizer.getHumanizedRandomPointIn(getBounds());
		if (point.x < 0)
			point.x = rand.nextInt(client.getStretchedDimensions().width);
		if (point.x > client.getStretchedDimensions().width)
			point.x = rand.nextInt(client.getStretchedDimensions().width);
		if (point.y < 0)
			point.y = rand.nextInt(client.getStretchedDimensions().height);
		if (point.y > client.getStretchedDimensions().height)
			point.y = rand.nextInt(client.getStretchedDimensions().height);
		return new java.awt.Point(point.x, point.y);
	}

	@Inject
	private Rectangle getBounds()
	{
		Shape shape = Perspective.getClickbox(client, getModel(), 0, getLocalLocation());
		if (shape != null)
		{
			return shape.getBounds();
		}
		else
		{
			return getCanvasTilePoly().getBounds();
		}
	}

	// Kris changes

	//TODO: Fix
/*	@FieldHook("movingOrientation")
	@Inject
	public void facedDirectionChanged(int idx)
	{
		FacedDirectionChanged facedDirectionChanged = new FacedDirectionChanged(this, getFacedDirection(), instantTurn());
		client.getCallbacks().post(Events.FACED_DIRECTION_CHANGED, facedDirectionChanged);
	}*/

/*	@FieldHook("exactMoveDirection")
	@Inject
	public void exactMoveReceived(int idx)
	{
		ExactMoveEvent exactMoveEvent = new ExactMoveEvent(this, exactMoveDeltaX1(), exactMoveDeltaX2(), exactMoveDeltaY1(), exactMoveDeltaY2(),
				exactMoveArrive1Cycle(), exactMoveArrive2Cycle(), exactMoveDirection(), client.getGameCycle());
		client.getCallbacks().post(Events.EXACT_MOVE_EVENT, exactMoveEvent);
	}*/

	@FieldHook("recolourAmount")
	@Inject
	public void recolourReceived(int idx) {
		RecolourEvent event = new RecolourEvent(this, recolourStartCycle(), recolourEndCycle(), recolourHue(), recolourSaturation(), recolourLuminance(),
				recolourAmount(), client.getGameCycle());
		client.getCallbacks().post(Events.RECOLOUR_EVENT, event);
	}


	@FieldHook("combatLevelChange")
	@Inject
	public void combatLevelChange(int idx) {
		if (getCombatLevelOverride() == -1) return;
		CombatLevelChangeEvent event = new CombatLevelChangeEvent(this, getCombatLevel(), getCombatLevelOverride());
		client.getCallbacks().post(Events.COMBAT_LEVEL_CHANGE_EVENT, event);
	}

	@FieldHook("currentSequenceFrameIndex")
	@Inject
	public void animationFrameIndexChanged(int idx)
	{
		AnimationFrameIndexChanged animationChange = new AnimationFrameIndexChanged(this);
		client.getCallbacks().post(Events.ANIMATION_FRAME_INDEX_CHANGED, animationChange);
	}

	@Inject
	public int graphicHeight = -1;

	@Inject
	@Override
	public int getGraphicHeight() {
		return graphicHeight;
	}

	@Inject
	@Override
	public void setGraphicHeight(int height) {
		graphicHeight = height;
	}
}
