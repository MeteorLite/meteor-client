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

import eventbus.Events;
import eventbus.events.*;
import net.runelite.api.HeadIcon;
import net.runelite.api.MenuAction;
import net.runelite.api.Model;
import net.runelite.api.Perspective;
import net.runelite.api.SkullIcon;
import static net.runelite.api.SkullIcon.DEAD_MAN_FIVE;
import static net.runelite.api.SkullIcon.DEAD_MAN_FOUR;
import static net.runelite.api.SkullIcon.DEAD_MAN_ONE;
import static net.runelite.api.SkullIcon.DEAD_MAN_THREE;
import static net.runelite.api.SkullIcon.DEAD_MAN_TWO;
import static net.runelite.api.SkullIcon.SKULL;
import static net.runelite.api.SkullIcon.SKULL_FIGHT_PIT;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.mixins.Copy;
import net.runelite.api.mixins.FieldHook;
import net.runelite.api.mixins.Inject;
import net.runelite.api.mixins.MethodHook;
import net.runelite.api.mixins.Mixin;
import net.runelite.api.mixins.Replace;
import net.runelite.api.mixins.Shadow;
import net.runelite.rs.api.*;

@Mixin(RSPlayer.class)
public abstract class RSPlayerMixin implements RSPlayer
{
	@Shadow("client")
	private static RSClient client;

	@Inject
	private boolean friended;

	@Inject
	private int oldHeadIcon = -2;

	@Inject
	private int oldSkullIcon = -2;

	@Inject
	@Override
	public String getName()
	{
		final RSUsername rsName = getRsName();

		if (rsName == null)
		{
			return null;
		}

		String name = rsName.getName$api();

		if (name == null)
		{
			return null;
		}

		return name.replace('\u00A0', ' ');
	}

	@Inject
	@FieldHook("headIconPrayer")
	public void prayerChanged(int idx)
	{
		if (getRsOverheadIcon() != oldHeadIcon)
		{
			final HeadIcon headIcon = getHeadIcon(getRsOverheadIcon());
			client.getCallbacks().post(Events.OVERHEAD_PRAYER_CHANGED,
				new OverheadPrayerChanged(this, getHeadIcon(oldHeadIcon), headIcon));
		}
		oldHeadIcon = getRsOverheadIcon();
	}

	@Inject
	@Override
	public HeadIcon getOverheadIcon()
	{
		return getHeadIcon(getRsOverheadIcon());
	}

	@Inject
	@FieldHook("headIconPk")
	public void skullChanged(int idx)
	{
		final SkullIcon skullIcon = skullFromInt(getRsSkullIcon());
		if (getRsSkullIcon() != oldSkullIcon)
		{
			client.getCallbacks().post(Events.PLAYER_SKULL_CHANGED,
				new PlayerSkullChanged(this, skullFromInt(getRsSkullIcon()), skullIcon));
		}
		oldSkullIcon = getRsSkullIcon();
	}

	@Inject
	@Override
	public SkullIcon getSkullIcon()
	{
		return skullFromInt(getRsSkullIcon());
	}

	@Inject
	private HeadIcon getHeadIcon(int overheadIcon)
	{
		if (overheadIcon == -1)
		{
			return null;
		}

		return HeadIcon.values()[overheadIcon];
	}

	@Inject
	private SkullIcon skullFromInt(int skull)
	{
		switch (skull)
		{
			case 0:
				return SKULL;
			case 1:
				return SKULL_FIGHT_PIT;
			case 8:
				return DEAD_MAN_FIVE;
			case 9:
				return DEAD_MAN_FOUR;
			case 10:
				return DEAD_MAN_THREE;
			case 11:
				return DEAD_MAN_TWO;
			case 12:
				return DEAD_MAN_ONE;
			default:
				return null;
		}
	}

	@Inject
	@Override
	public Polygon[] getPolygons()
	{
		Model model = getModel();

		if (model == null)
		{
			return null;
		}

		int[] x2d = new int[model.getVerticesCount()];
		int[] y2d = new int[model.getVerticesCount()];

		int localX = getX();
		int localY = getY();

		final int tileHeight = Perspective.getTileHeight(client, new LocalPoint(localX, localY), client.getPlane());

		Perspective.modelToCanvas(client, model.getVerticesCount(), localX, localY, tileHeight, getOrientation(), model.getVerticesX(), model.getVerticesZ(), model.getVerticesY(), x2d, y2d);
		ArrayList polys = new ArrayList(model.getFaceCount());

		int[] trianglesX = model.getFaceIndices1();
		int[] trianglesY = model.getFaceIndices2();
		int[] trianglesZ = model.getFaceIndices3();

		for (int triangle = 0; triangle < model.getFaceCount(); ++triangle)
		{
			int[] xx =
				{
					x2d[trianglesX[triangle]], x2d[trianglesY[triangle]], x2d[trianglesZ[triangle]]
				};

			int[] yy =
				{
					y2d[trianglesX[triangle]], y2d[trianglesY[triangle]], y2d[trianglesZ[triangle]]
				};

			polys.add(new Polygon(xx, yy, 3));
		}

		return (Polygon[]) polys.toArray(new Polygon[0]);
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

		int tileHeight = Perspective.getTileHeight(client, new LocalPoint(getX(), getY()), client.getPlane());

		return model.getConvexHull(getX(), getY(), getOrientation(), tileHeight);
	}

	@SuppressWarnings("InfiniteRecursion")
	@Copy("getModel")
	@Replace("getModel")
	public RSModel copy$getModel()
	{
		if (!client.isInterpolatePlayerAnimations())
		{
			return copy$getModel();
		}
		int actionFrame = getActionFrame();
		int poseFrame = getPoseFrame();
		int spotAnimFrame = getSpotAnimFrame();
		try
		{
			// combine the frames with the frame cycle so we can access this information in the sequence methods
			// without having to change method calls
			setActionFrame(Integer.MIN_VALUE | getActionFrameCycle() << 16 | actionFrame);
			setPoseFrame(Integer.MIN_VALUE | getPoseFrameCycle() << 16 | poseFrame);
			setSpotAnimFrame(Integer.MIN_VALUE | getSpotAnimationFrameCycle() << 16 | spotAnimFrame);
			return copy$getModel();
		}
		finally
		{
			// reset frames
			setActionFrame(actionFrame);
			setPoseFrame(poseFrame);
			setSpotAnimFrame(spotAnimFrame);
		}
	}

	@Inject
	public boolean isFriended()
	{
		return isFriend$api() || friended;
	}

	@Inject
	@MethodHook(value = "checkIsFriend", end = true)
	void updateFriended()
	{
		friended = client.getFriendManager().isFriended(getRsName(), false);
	}

	@Inject
	@MethodHook(value = "read", end = true)
	void postRead(RSBuffer var1)
	{
		client.getCallbacks().post(Events.PLAYER_CHANGED, new PlayerChanged(this));
	}

	@Copy("read")
	@Replace("read")
	@SuppressWarnings("InfiniteRecursion")
	public void copy$read(RSBuffer buffer)
	{
		final long appearanceHash = getPlayerComposition() == null ? 0 : getPlayerComposition().getHash();

		this.copy$read(buffer);

		if (client.isComparingAppearance() && getPlayerComposition().getHash() != appearanceHash)
		{
			client.getCallbacks().post(Events.PLAYER_COMPOSITION_CHANGED, new PlayerCompositionChanged(this));
		}
	}


	@Inject
	@Override
	public int getIndex()
	{
		for (int i = 0; i < client.getCachedPlayers().length; i++)
		{
			RSPlayer player = client.getCachedPlayers()[i];
			if (player != null && player.equals(this))
			{
				return i;
			}
		}

		return -1;
	}

	@Inject
	@Override
	public int getActionOpcode(int action)
	{
		switch (action)
		{
			case 0:
				return MenuAction.PLAYER_FIRST_OPTION.getId();
			case 1:
				return MenuAction.PLAYER_SECOND_OPTION.getId();
			case 2:
				return MenuAction.PLAYER_THIRD_OPTION.getId();
			case 3:
				return MenuAction.PLAYER_FOURTH_OPTION.getId();
			case 4:
				return MenuAction.PLAYER_FIFTH_OPTION.getId();
			case 5:
				return MenuAction.PLAYER_SIXTH_OPTION.getId();
			case 6:
				return MenuAction.PLAYER_SEVENTH_OPTION.getId();
			case 7:
				return MenuAction.PLAYER_EIGTH_OPTION.getId();
			default:
				throw new IllegalArgumentException("action = " + action);
		}
	}

	@Inject
	@Override
	public String[] getRawActions()
	{
		return client.getPlayerOptions();
	}

	@Override
	@Inject
	public void interact(int action)
	{
		interact(getIndex(), getActionOpcode(action));
	}

	@Inject
	@Override
	public void interact(int index, int opcode)
	{
		interact(getIndex(), opcode, 0, 0);
	}

	@Inject
	@Override
	public void interact(int identifier, int opcode, int param0, int param1)
	{
		client.interact(getMenu(identifier, opcode, param0, param1));
	}

	@Inject
	@Override
	public boolean isIdle()
	{
		return (getIdlePoseAnimation() == getPoseAnimation() && getAnimation() == -1)
				&& (getInteracting() == null || getInteracting().isDead());
	}

	@Inject
	@Override
	public long getTag()
	{
		return client.calculateTag(0, 0, 0, false, getIndex());
	}

	@Inject
	public AutomatedMenu getMenu(int actionIndex)
	{
		return getMenu(getIndex(), getActionOpcode(actionIndex));
	}

	@Inject
	public AutomatedMenu getMenu(int actionIndex, int opcode)
	{
		return getMenu(actionIndex, opcode, 0, 0);
	}

	// Kris changes:
	@Inject
	@FieldHook("maxY")
	public void attachedModel(int idx) {
		client.getCallbacks().post(Events.ATTACHED_MODEL_EVENT, new AttachedModelEvent(this, minX(), minY(), maxX(), maxY(), animationCycleStart(), animationCycleEnd(), getAttachedModel()));
	}

	@Inject
	@MethodHook("move")
	public void onPlayerMovement(int x, int y, RSMoveSpeed type) {
		client.getCallbacks().post(Events.PLAYER_MOVED, new PlayerMoved(this, x, y, type.speed()));
	}

	@Inject
	@MethodHook("resetPath")
	public void onPlayerPathReset(int x, int y) {
		client.getCallbacks().post(Events.PLAYER_MOVED,new PlayerMoved(this, x, y, 127));
	}
}
