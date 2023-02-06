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

import dev.hoot.api.events.AutomatedMenu;
import java.awt.Polygon;
import java.awt.Shape;
import java.util.ArrayList;
import java.util.Arrays;

import eventbus.Events;
import eventbus.events.NPCMoved;
import eventbus.events.NameChangeEvent;
import eventbus.events.NpcChanged;
import eventbus.events.NpcDespawned;
import net.runelite.api.MenuAction;
import net.runelite.api.NPCComposition;
import net.runelite.api.Perspective;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.mixins.*;
import net.runelite.rs.api.*;

@Mixin(RSNPC.class)
public abstract class RSNPCMixin implements RSNPC
{
	@Shadow("client")
	private static RSClient client;

	@Inject
	private int npcIndex;

	@Inject
	@Override
	public int getId()
	{
		RSNPCComposition composition = getComposition();
		if (composition != null && composition.getConfigs() != null)
		{
			composition = composition.transform();
		}
		return composition == null ? -1 : composition.getId();
	}

	@Inject
	@Override
	public String getName()
	{
		RSNPCComposition composition = getComposition();
		if (composition != null && composition.getConfigs() != null)
		{
			composition = composition.transform();
		}
		return composition == null ? null : composition.getName().replace('\u00A0', ' ');
	}

	@Inject
	@Override
	public int getCombatLevel()
	{
		RSNPCComposition composition = getComposition();
		if (composition != null && composition.getConfigs() != null)
		{
			composition = composition.transform();
		}
		return composition == null ? -1 : composition.getCombatLevel();
	}

	@Inject
	@Override
	public int getIndex()
	{
		return npcIndex;
	}

	@Inject
	@Override
	public void setIndex(int id)
	{
		npcIndex = id;
	}

	@Inject
	@Override
	public void setComposition(NPCComposition composition)
	{
		setComposition((RSNPCComposition) composition);
	}

	@FieldHook(value = "definition", before = true)
	@Inject
	public void onDefinitionChanged(RSNPCComposition composition)
	{
		if (composition == null)
		{
			client.getCallbacks().post(Events.NPC_DESPAWNED, new NpcDespawned(this));
		}
		else if (this.getId() != -1)
		{
			RSNPCComposition oldComposition = getComposition();
			if (oldComposition == null)
			{
				return;
			}

			if (composition.getId() == oldComposition.getId())
			{
				return;
			}

			client.getCallbacks().postDeferred(Events.NPC_CHANGED, new NpcChanged(this, oldComposition));
		}
	}

	@Inject
	ArrayList<Integer> dontProcessNPCIds = new ArrayList<>(
			Arrays.asList(
					//Phantom Muspah
					12077, 12078, 12079, 12080, 12082
			));

	@Inject
	@Override
	public NPCComposition getTransformedComposition()
	{
		RSNPCComposition composition = getComposition();
		if (composition != null && composition.getConfigs() != null)
		{
			composition = composition.transform();
			setTransformedId(composition.getId());
			setTransformedLevel(composition.getCombatLevel());
			setTransformedName(composition.getName());
		} else {
			setTransformedId(getId());
			setTransformedLevel(getCombatLevel());
			setTransformedName(getName());
		}
		return composition;
	}

	@Inject
	public Integer transformedId;

	@Inject
	@Override
	public Integer getTransformedId() {
		return transformedId;
	}

	@Inject
	@Override
	public void setTransformedId(Integer id)
	{
		transformedId = id;
	}

	@Inject
	public Integer transformedLvl;

	@Inject
	@Override
	public Integer getTransformedLevel() {
		return transformedLvl;
	}

	@Inject
	@Override
	public void setTransformedLevel(Integer lvl)
	{
		transformedLvl = lvl;
	}

	@Inject
	public String transformedName;

	@Inject
	@Override
	public String getTransformedName() {
		return transformedName;
	}

	@Inject
	@Override
	public void setTransformedName(String name)
	{
		transformedName = name;
	}

	@Inject
	@Override
	public Polygon getCanvasTilePoly()
	{
		NPCComposition transformedComposition = this.getTransformedComposition();
		if (transformedComposition == null)
		{
			return null;
		}
		else
		{
			int size = transformedComposition.getSize();
			return Perspective.getCanvasTileAreaPoly(client, this.getLocalLocation(), size);
		}
	}

	@Inject
	@Override
	public Shape getConvexHull()
	{
		RSModel model = getModel();
		if (model == null)
		{
			return null;
		}

		int size = getComposition().getSize();
		LocalPoint tileHeightPoint = new LocalPoint(
			size * Perspective.LOCAL_HALF_TILE_SIZE - Perspective.LOCAL_HALF_TILE_SIZE + getX(),
			size * Perspective.LOCAL_HALF_TILE_SIZE - Perspective.LOCAL_HALF_TILE_SIZE + getY());

		int tileHeight = Perspective.getTileHeight(client, tileHeightPoint, client.getPlane());

		return model.getConvexHull(getX(), getY(), getOrientation(), tileHeight);
	}

	@Inject
	@Override
	public String[] getRawActions()
	{
		RSNPCComposition composition = (RSNPCComposition) getTransformedComposition();
		return composition == null ? null : composition.getActions();
	}

	@Override
	@Inject
	public int getActionOpcode(int action)
	{
		switch (action)
		{
			case 0:
				return MenuAction.NPC_FIRST_OPTION.getId();
			case 1:
				return MenuAction.NPC_SECOND_OPTION.getId();
			case 2:
				return MenuAction.NPC_THIRD_OPTION.getId();
			case 3:
				return MenuAction.NPC_FOURTH_OPTION.getId();
			case 4:
				return MenuAction.NPC_FIFTH_OPTION.getId();
			default:
				throw new IllegalArgumentException("action = " + action);
		}
	}

	@Override
	@Inject
	public void interact(int action)
	{
		interact(getIndex(), getActionOpcode(action));
	}

	@Override
	@Inject
	public void interact(int identifier, int opcode, int param0, int param1)
	{
		if (identifier == -1)
		{
			throw new IllegalStateException("Interacted NPC no longer exists " + getName() + ", cancelling " +
					"interaction.");
		}

		client.interact(getMenu(identifier, opcode, param0, param1));
	}

	@Inject
	@Override
	public void interact(int index, int opcode)
	{
		interact(getIndex(), opcode, 0, 0);
	}

	@Inject
	@Override
	public String toString()
	{
		return getIndex() + ": " + getName() + " (" + getId() + ") at " + getWorldLocation();
	}

	@Inject
	public long getTag()
	{
		return client.calculateTag(0, 0, 1, getComposition().isInteractible(), getIndex());
	}

	@Inject
	@Override
	public AutomatedMenu getMenu(int actionIndex)
	{
		return getMenu(getIndex(), getActionOpcode(actionIndex));
	}

	@Inject
	public AutomatedMenu getMenu(int actionIndex, int opcode)
	{
		return getMenu(getIndex(), opcode, 0, 0);
	}


	// Kris changes:
	@Inject
	@MethodHook(value = "move", end = true)
	public void onNPCMovement(int direction, RSMoveSpeed type) {
		int x = getPathX()[0];
		int y = getPathY()[0];
		client.getCallbacks().post(Events.NPC_MOVED, new NPCMoved(this, x, y, type.speed()));
	}


	@FieldHook("nameChange")
	@Inject
	public void nameChange(int idx) {
		if (getNameOverride() == null) return;
		NameChangeEvent event = new NameChangeEvent(this, getName(), getNameOverride());
		client.getCallbacks().post(Events.NAME_CHANGE_EVENT, event);
	}
}
