/*
 * Copyright (c) 2017, Tyler <https://github.com/tylerthardy>
 * Copyright (c) 2020, dekvall <https://github.com/dekvall>
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

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import eventbus.events.*;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import meteor.plugins.Plugin;
import meteor.plugins.PluginDescriptor;
import meteor.rs.ClientThread;
import net.runelite.api.*;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.util.Text;
import org.apache.commons.lang3.ArrayUtils;

import java.util.*;

import static net.runelite.api.ObjectID.*;

@PluginDescriptor(
	name = "Herbiboar",
	description = "Highlight starting rocks, trails, and the objects to search at the end of each trail",
	tags = {"herblore", "hunter", "skilling", "overlay"}
)
@Slf4j
@Getter
public class HerbiboarPlugin extends Plugin
{
	private ClientThread clientThread = ClientThread.INSTANCE;
	private HerbiboarConfig config = configuration(HerbiboarConfig.class);
	private HerbiboarOverlay overlay = new HerbiboarOverlay(this, config);
	private HerbiboarMinimapOverlay minimapOverlay = new HerbiboarMinimapOverlay(this, config);

	private static final List<WorldPoint> END_LOCATIONS = ImmutableList.of(
		new WorldPoint(3693, 3798, 0),
		new WorldPoint(3702, 3808, 0),
		new WorldPoint(3703, 3826, 0),
		new WorldPoint(3710, 3881, 0),
		new WorldPoint(3700, 3877, 0),
		new WorldPoint(3715, 3840, 0),
		new WorldPoint(3751, 3849, 0),
		new WorldPoint(3685, 3869, 0),
		new WorldPoint(3681, 3863, 0)
	);

	private static final Set<Integer> START_OBJECT_IDS = ImmutableSet.of(
		ROCK_30519,
		MUSHROOM_30520,
		ROCK_30521,
		ROCK_30522,
		DRIFTWOOD_30523
	);

	private static final List<Integer> HERBIBOAR_REGIONS = ImmutableList.of(
		14652,
		14651,
		14908,
		14907
	);

	/**
	 * Objects which appear at the beginning of Herbiboar hunting trails
	 */
	private final Map<WorldPoint, TileObject> starts = new HashMap<>();
	/**
	 * Herbiboar hunting "footstep" trail objects
	 */
	private final Map<WorldPoint, TileObject> trails = new HashMap<>();
	/**
	 * Objects which trigger next trail (mushrooms, mud, seaweed, etc)
	 */
	private final Map<WorldPoint, TileObject> trailObjects = new HashMap<>();
	/**
	 * Tunnel where the Herbiboar is hiding at the end of a trail
	 */
	private final Map<WorldPoint, TileObject> tunnels = new HashMap<>();
	/**
	 * Trail object IDs which should be highlighted
	 */
	private final Set<Integer> shownTrails = new HashSet<>();
	/**
	 * Sequence of herbiboar spots searched along the current trail
	 */
	private final List<HerbiboarSearchSpot> currentPath = Lists.newArrayList();

	private boolean inHerbiboarArea;
	private TrailToSpot nextTrail;
	private HerbiboarSearchSpot.Group currentGroup;
	private int finishId;

	private boolean started;
	private WorldPoint startPoint;
	private HerbiboarStart startSpot;
	private boolean ruleApplicable;

	@Override
	public void onStart()
	{
		getOverlayManager().add(overlay);
		getOverlayManager().add(minimapOverlay);

		if (getClient().getGameState() == GameState.LOGGED_IN)
		{
			clientThread.invokeLater(() ->
			{
				inHerbiboarArea = checkArea();
				updateTrailData();
			});
		}
	}

	@Override
	public void onStop()
	{
		getOverlayManager().remove(overlay);
		getOverlayManager().remove(minimapOverlay);
		resetTrailData();
		clearCache();
		inHerbiboarArea = false;
	}

	private void updateTrailData()
	{
		if (!isInHerbiboarArea())
		{
			return;
		}

		boolean pathActive = false;
		boolean wasStarted = started;

		// Get trail data
		for (HerbiboarSearchSpot spot : HerbiboarSearchSpot.values())
		{
			for (TrailToSpot trail : spot.getTrails())
			{
				int value = getClient().getVarbitValue(trail.getVarbit());

				if (value == trail.getValue())
				{
					// The trail after you have searched the spot
					currentGroup = spot.getGroup();
					nextTrail = trail;

					// You never visit the same spot twice
					if (!currentPath.contains(spot))
					{
						currentPath.add(spot);
					}
				}
				else if (value > 0)
				{
					// The current trail
					shownTrails.addAll(trail.getFootprintIds());
					pathActive = true;
				}
			}
		}

		finishId = getClient().getVarbitValue(Varbits.HB_FINISH);

		// The started varbit doesn't get set until the first spot of the rotation has been searched
		// so we need to use the current group as an indicator of the rotation being started
		started = getClient().getVarbitValue(Varbits.HB_STARTED) > 0 || currentGroup != null;
		boolean finished = !pathActive && started;

		if (!wasStarted && started)
		{
			startSpot = HerbiboarStart.from(startPoint);
		}

		ruleApplicable = HerbiboarRule.canApplyRule(startSpot, currentPath);

		if (finished)
		{
			resetTrailData();
		}
	}

	@Override
	public void onMenuOptionClicked(MenuOptionClicked menuOpt)
	{
		if (!inHerbiboarArea || started || MenuAction.GAME_OBJECT_FIRST_OPTION != menuOpt.getMenuAction())
		{
			return;
		}

		switch (Text.removeTags(menuOpt.getMenuTarget()))
		{
			case "Rock":
			case "Mushroom":
			case "Driftwood":
				startPoint = WorldPoint.fromScene(getClient(), menuOpt.getParam0(), menuOpt.getParam1(), getClient().getPlane());
		}
	}

	private void resetTrailData()
	{
		log.debug("Reset trail data");
		shownTrails.clear();
		currentPath.clear();
		nextTrail = null;
		currentGroup = null;
		finishId = 0;
		started = false;
		startPoint = null;
		startSpot = null;
		ruleApplicable = false;
	}

	private void clearCache()
	{
		starts.clear();
		trails.clear();
		trailObjects.clear();
		tunnels.clear();
	}

	@Override
	public void onGameStateChanged(GameStateChanged event)
	{
		switch (event.getGameState())
		{
			case HOPPING:
			case LOGGING_IN:
				resetTrailData();
				break;
			case LOADING:
				clearCache();
				inHerbiboarArea = checkArea();
				break;
			default:
				break;
		}
	}

	@Override
	public void onVarbitChanged(VarbitChanged event)
	{
		updateTrailData();
	}

	@Override
	public void onGameObjectSpawned(GameObjectSpawned event)
	{
		onTileObject(null, event.getGameObject());
	}

	@Override
	public void onGameObjectChanged(GameObjectChanged event)
	{
		onTileObject(event.getOldObject(), event.getNewObject());
	}

	@Override
	public void onGameObjectDespawned(GameObjectDespawned event)
	{
		onTileObject(event.getGameObject(), null);
	}

	@Override
	public void onGroundObjectSpawned(GroundObjectSpawned event)
	{
		onTileObject(null, event.getGroundObject());
	}

	@Override
	public void onGroundObjectChanged(GroundObjectChanged event)
	{
		onTileObject(event.getPrevious(), event.getGroundObject());
	}

	@Override
	public void onGroundObjectDespawned(GroundObjectDespawned event)
	{
		onTileObject(event.getGroundObject(), null);
	}

	// Store relevant GameObjects (starts, tracks on trails, objects used to trigger next trails, and tunnels)
	private void onTileObject(TileObject oldObject, TileObject newObject)
	{
		if (oldObject != null)
		{
			WorldPoint oldLocation = oldObject.getWorldLocation();
			starts.remove(oldLocation);
			trails.remove(oldLocation);
			trailObjects.remove(oldLocation);
			tunnels.remove(oldLocation);
		}

		if (newObject == null)
		{
			return;
		}

		// Starts
		if (START_OBJECT_IDS.contains(newObject.getId()))
		{
			starts.put(newObject.getWorldLocation(), newObject);
			return;
		}

		// Trails
		if (HerbiboarSearchSpot.isTrail(newObject.getId()))
		{
			trails.put(newObject.getWorldLocation(), newObject);
			return;
		}

		// GameObject to trigger next trail (mushrooms, mud, seaweed, etc)
		if (HerbiboarSearchSpot.isSearchSpot(newObject.getWorldLocation()))
		{
			trailObjects.put(newObject.getWorldLocation(), newObject);
			return;
		}

		// Herbiboar tunnel
		if (END_LOCATIONS.contains(newObject.getWorldLocation()))
		{
			tunnels.put(newObject.getWorldLocation(), newObject);
		}
	}

	private boolean checkArea()
	{
		final int[] mapRegions = getClient().getMapRegions();
		for (int region : HERBIBOAR_REGIONS)
		{
			if (ArrayUtils.contains(mapRegions, region))
			{
				return true;
			}
		}
		return false;
	}

	List<WorldPoint> getEndLocations()
	{
		return END_LOCATIONS;
	}
}
