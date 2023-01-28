/*
 * Copyright (c) 2019, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.mining;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import javax.annotation.Nullable;

import eventbus.events.*;
import lombok.AccessLevel;
import lombok.Getter;
import meteor.plugins.Plugin;
import meteor.plugins.PluginDependency;
import meteor.plugins.PluginDescriptor;
import meteor.plugins.xptracker.XpTrackerPlugin;
import meteor.ui.overlay.OverlayManager;
import net.runelite.api.AnimationID;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameObject;
import net.runelite.api.GameState;
import static net.runelite.api.HintArrowType.WORLD_POSITION;
import net.runelite.api.MenuAction;
import static net.runelite.api.ObjectID.DEPLETED_VEIN;
import static net.runelite.api.ObjectID.DEPLETED_VEIN_26665;
import static net.runelite.api.ObjectID.DEPLETED_VEIN_26666;
import static net.runelite.api.ObjectID.DEPLETED_VEIN_26667;
import static net.runelite.api.ObjectID.DEPLETED_VEIN_26668;
import static net.runelite.api.ObjectID.EMPTY_WALL;
import static net.runelite.api.ObjectID.MINERAL_VEIN;
import static net.runelite.api.ObjectID.MINERAL_VEIN_5990;
import static net.runelite.api.ObjectID.MINERAL_VEIN_5991;
import static net.runelite.api.ObjectID.ORE_VEIN_26661;
import static net.runelite.api.ObjectID.ORE_VEIN_26662;
import static net.runelite.api.ObjectID.ORE_VEIN_26663;
import static net.runelite.api.ObjectID.ORE_VEIN_26664;
import static net.runelite.api.ObjectID.ROCKS_41547;
import static net.runelite.api.ObjectID.ROCKS_41548;
import static net.runelite.api.ObjectID.ROCKS_41549;
import static net.runelite.api.ObjectID.ROCKS_41550;
import net.runelite.api.Player;
import net.runelite.api.WallObject;
import net.runelite.api.coords.WorldPoint;

@PluginDescriptor(
	name = "Mining",
	description = "Show mining statistics and ore respawn timers",
	tags = {"overlay", "skilling", "timers"},
	enabledByDefault = false
)
@PluginDependency(XpTrackerPlugin.class)
public class MiningPlugin extends Plugin
{
	private static final Pattern MINING_PATTERN = Pattern.compile(
		"You " +
			"(?:manage to|just)" +
			" (?:mined?|quarry) " +
			"(?:some|an?) " +
			"(?:copper|tin|clay|iron|silver|coal|gold|mithril|adamantite|runeite|amethyst|sandstone|granite|barronite shards|barronite deposit|Opal|piece of Jade|Red Topaz|Emerald|Sapphire|Ruby|Diamond)" +
			"(?:\\.|!)");
	private MiningConfig config = configuration(MiningConfig.class);
	private OverlayManager overlayManager = OverlayManager.INSTANCE;
	private MiningOverlay overlay = new MiningOverlay(this, config);
	private MiningRocksOverlay rocksOverlay = new MiningRocksOverlay(this);


	@Getter
	@Nullable
	private MiningSession session;

	@Getter(AccessLevel.PACKAGE)
	private final List<RockRespawn> respawns = new ArrayList<>();
	private boolean recentlyLoggedIn;

	@Getter
	@Nullable
	private Pickaxe pickaxe;

	@Override
	public void onStart()
	{
		overlayManager.add(overlay);
		overlayManager.add(rocksOverlay);
	}

	@Override
	public void onStop()
	{
		session = null;
		pickaxe = null;
		overlayManager.remove(overlay);
		overlayManager.remove(rocksOverlay);
		respawns.forEach(respawn -> clearHintArrowAt(respawn.getWorldPoint()));
		respawns.clear();
	}

	@Override
	public void onGameStateChanged(GameStateChanged event)
	{
		switch (event.getGameState())
		{
			case HOPPING:
				respawns.clear();
				break;
			case LOGGED_IN:
				// After login rocks that are depleted will be changed,
				// so wait for the next game tick before watching for
				// rocks to deplete
				recentlyLoggedIn = true;
				break;
		}
	}

	@Override
	public void onAnimationChanged(final AnimationChanged event)
	{
		Player local = getClient().getLocalPlayer();

		if (event.getActor() != local)
		{
			return;
		}

		int animId = local.getAnimation();
		if (animId == AnimationID.DENSE_ESSENCE_CHIPPING)
		{
			// Can't use chat messages to start mining session on Dense Essence as they don't have a chat message when mined,
			// so we track the session here instead.
			if (session == null)
			{
				session = new MiningSession();
			}

			session.setLastMined();
		}
		else
		{
			Pickaxe pickaxe = Pickaxe.fromAnimation(animId);
			if (pickaxe != null)
			{
				this.pickaxe = pickaxe;
			}
		}
	}

	@Override
	public void onGameTick(GameTick gameTick)
	{
		clearExpiredRespawns();
		recentlyLoggedIn = false;

		if (session == null || session.getLastMined() == null)
		{
			return;
		}

		if (pickaxe != null && pickaxe.matchesMiningAnimation(getClient().getLocalPlayer()))
		{
			session.setLastMined();
			return;
		}

		Duration statTimeout = Duration.ofMinutes(config.statTimeout());
		Duration sinceMined = Duration.between(session.getLastMined(), Instant.now());

		if (sinceMined.compareTo(statTimeout) >= 0)
		{
			resetSession();
		}
	}

	/**
	 * Clears expired respawns and removes the hint arrow from expired Daeyalt essence rocks.
	 */
	private void clearExpiredRespawns()
	{
		respawns.removeIf(rockRespawn ->
		{
			final boolean expired = rockRespawn.isExpired();

			if (expired && rockRespawn.getRock() == Rock.DAEYALT_ESSENCE)
			{
				clearHintArrowAt(rockRespawn.getWorldPoint());
			}

			return expired;
		});
	}

	public void resetSession()
	{
		session = null;
		pickaxe = null;
	}

	@Override
	public void onGameObjectDespawned(GameObjectDespawned event)
	{
		if (getClient().getGameState() != GameState.LOGGED_IN || recentlyLoggedIn)
		{
			return;
		}

		final GameObject object = event.getGameObject();
		final int region = getClient().getLocalPlayer().getWorldLocation().getRegionID();

		Rock rock = Rock.getRock(object.getId());
		if (rock != null)
		{
			final WorldPoint point = object.getWorldLocation();

			if (rock == Rock.DAEYALT_ESSENCE)
			{
				respawns.removeIf(rockRespawn -> rockRespawn.getWorldPoint().equals(point));
				clearHintArrowAt(point);
			}
			else
			{
				RockRespawn rockRespawn = new RockRespawn(rock, point, Instant.now(), (int) rock.getRespawnTime(region).toMillis(), rock.getZOffset());
				respawns.add(rockRespawn);
			}
		}
	}

	private void clearHintArrowAt(WorldPoint worldPoint)
	{
		if (getClient().getHintArrowType() == WORLD_POSITION && getClient().getHintArrowPoint().equals(worldPoint))
		{
			getClient().clearHintArrow();
		}
	}

	@Override
	public void onGameObjectSpawned(GameObjectSpawned event)
	{
		if (getClient().getGameState() != GameState.LOGGED_IN || recentlyLoggedIn)
		{
			return;
		}

		GameObject object = event.getGameObject();
		Rock rock = Rock.getRock(object.getId());

		// Inverse timer to track daeyalt essence active duration
		if (rock == Rock.DAEYALT_ESSENCE)
		{
			final int region = getClient().getLocalPlayer().getWorldLocation().getRegionID();
			RockRespawn rockRespawn = new RockRespawn(rock, object.getWorldLocation(), Instant.now(), (int) rock.getRespawnTime(region).toMillis(), rock.getZOffset());
			respawns.add(rockRespawn);
			getClient().setHintArrow(object.getWorldLocation());
		}
		// If the Lovakite ore respawns before the timer is up, remove it
		else if (rock == Rock.LOVAKITE)
		{
			final WorldPoint point = object.getWorldLocation();
			respawns.removeIf(rockRespawn -> rockRespawn.getWorldPoint().equals(point));
		}
	}

	@Override
	public void onWallObjectSpawned(WallObjectSpawned event)
	{
		if (getClient().getGameState() != GameState.LOGGED_IN)
		{
			return;
		}

		final WallObject object = event.getWallObject();
		final int region = getClient().getLocalPlayer().getWorldLocation().getRegionID();

		switch (object.getId()) {
			case EMPTY_WALL -> {
				Rock rock = Rock.AMETHYST;
				RockRespawn rockRespawn = new RockRespawn(rock, object.getWorldLocation(), Instant.now(), (int) rock.getRespawnTime(region).toMillis(), rock.getZOffset());
				respawns.add(rockRespawn);
			}
			// Depleted motherlode vein
			// Depleted motherlode vein
			// Depleted motherlode vein
			case DEPLETED_VEIN_26665, DEPLETED_VEIN_26666, DEPLETED_VEIN_26667, DEPLETED_VEIN_26668 -> // Depleted motherlode vein
			{
				Rock rock = Rock.ORE_VEIN;
				RockRespawn rockRespawn = new RockRespawn(rock, object.getWorldLocation(), Instant.now(), (int) rock.getRespawnTime(region).toMillis(), rock.getZOffset());
				respawns.add(rockRespawn);
			}
			// Depleted barronite vein
			case ROCKS_41549, ROCKS_41550 -> // Depleted barronite vein
			{
				Rock rock = Rock.BARRONITE;
				RockRespawn rockRespawn = new RockRespawn(rock, object.getWorldLocation(), Instant.now(), (int) rock.getRespawnTime(region).toMillis(), rock.getZOffset());
				respawns.add(rockRespawn);
			}
			case DEPLETED_VEIN -> // Depleted gold vein
			{
				Rock rock = Rock.MINERAL_VEIN;
				RockRespawn rockRespawn = new RockRespawn(rock, object.getWorldLocation(), Instant.now(), (int) rock.getRespawnTime(region).toMillis(), rock.getZOffset());
				respawns.add(rockRespawn);
			}
			// Motherlode vein
			// Motherlode vein
			// Motherlode vein
			// Motherlode vein
			// Barronite vein
			// Barronite vein
			// Arzinian gold vein
			// Gold vein
			case ORE_VEIN_26661, ORE_VEIN_26662, ORE_VEIN_26663, ORE_VEIN_26664, ROCKS_41547, ROCKS_41548, MINERAL_VEIN, MINERAL_VEIN_5990, MINERAL_VEIN_5991 -> // Gold vein
			{
				// If the vein respawns before the timer is up, remove it
				final WorldPoint point = object.getWorldLocation();
				respawns.removeIf(rockRespawn -> rockRespawn.getWorldPoint().equals(point));
			}
		}
	}

	@Override
	public void onChatMessage(ChatMessage event)
	{
		if (event.getType() == ChatMessageType.SPAM || event.getType() == ChatMessageType.GAMEMESSAGE)
		{
			if (MINING_PATTERN.matcher(event.getMessage()).matches())
			{
				if (session == null)
				{
					session = new MiningSession();
				}

				session.setLastMined();
			}
		}
	}
}