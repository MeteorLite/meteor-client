/*
 * Copyright (c) 2018, Kamiel
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
package net.runelite.client.plugins.raids;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Joiner;
import eventbus.events.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import meteor.Main;
import meteor.api.Objects;
import meteor.chat.*;
import meteor.events.ChatInput;
import meteor.game.SpriteManager;
import meteor.input.KeyManager;
import meteor.plugins.Plugin;
import meteor.plugins.PluginDescriptor;
import meteor.rs.ClientThread;
import meteor.ui.overlay.OverlayManager;
import meteor.ui.overlay.infobox.InfoBoxManager;
import net.runelite.api.*;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.util.Text;
import net.runelite.client.plugins.raids.solver.Layout;
import net.runelite.client.plugins.raids.solver.LayoutSolver;
import net.runelite.http.api.chat.ChatClient;
import net.runelite.http.api.chat.LayoutRoom;

import java.io.IOException;
import java.text.DecimalFormat;
import java.time.Instant;
import java.util.*;
import java.util.concurrent.ScheduledExecutorService;
import java.util.stream.Collectors;

import static net.runelite.api.Perspective.SCENE_SIZE;
import static net.runelite.api.SpriteID.TAB_QUESTS_BROWN_RAIDING_PARTY;
@PluginDescriptor(
	name = "Chambers Of Xeric",
	description = "Show helpful information for the Chambers of Xeric raid",
	tags = {"combat", "raid", "overlay", "pve", "pvm", "bosses", "cox"}
)
@Slf4j
public class RaidsPlugin extends Plugin
{
	private static final int LOBBY_PLANE = 3;
	private static final int SECOND_FLOOR_PLANE = 2;
	private static final int ROOMS_PER_PLANE = 8;
	private static final int AMOUNT_OF_ROOMS_PER_X_AXIS_PER_PLANE = 4;
	private static final String RAID_START_MESSAGE = "The raid has begun!";
	private static final String LEVEL_COMPLETE_MESSAGE = "level complete!";
	private static final String RAID_COMPLETE_MESSAGE = "Congratulations - your raid is complete!";
	private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("###.##");
	private static final DecimalFormat POINTS_FORMAT = new DecimalFormat("#,###");
	private static final String LAYOUT_COMMAND = "!layout";
	private static final int MAX_LAYOUT_LEN = 300;
	// (x=3360, y=5152, plane=2) is the temp location the game puts the player on login into while it decides whether
	// to put the player into a raid or not.
	private static final WorldPoint TEMP_LOCATION = new WorldPoint(3360, 5152, 2);

	
	private ChatMessageManager chatMessageManager = Main.chatMessageManager;

	
	private InfoBoxManager infoBoxManager = InfoBoxManager.INSTANCE;

	
	private Client client = Main.client;

	
	private RaidsConfig config = configuration(RaidsConfig.class);

	
	private OverlayManager overlayManager = OverlayManager.INSTANCE;

	
	private RaidsOverlay overlay = new RaidsOverlay(this, config);

	
	private LayoutSolver layoutSolver = new LayoutSolver();

	
	private SpriteManager spriteManager = SpriteManager.INSTANCE;

	
	private ClientThread clientThread = ClientThread.INSTANCE;

	
	private ChatCommandManager chatCommandManager = Main.chatCommandManager;

	
	private ChatClient chatClient = Main.INSTANCE.getChatClient();

	
	private ScheduledExecutorService scheduledExecutorService = Main.INSTANCE.getExecutor();

	
	private KeyManager keyManager = KeyManager.INSTANCE;

	@Getter
	private final Set<String> roomWhitelist = new HashSet<>();

	@Getter
	private final Set<String> roomBlacklist = new HashSet<>();

	@Getter
	private final Set<String> rotationWhitelist = new HashSet<>();

	@Getter
	private final Set<String> layoutWhitelist = new HashSet<>();

	@Setter(AccessLevel.PACKAGE) // for the test
	@Getter
	private Raid raid;

	// if the player is inside of a raid or not
	@Getter
	private boolean inRaidChambers;

	/*
	 * if the player is in a raid party or not
	 * This will be set when someone in the friends chat clicks the "make party" button on the raids widget
	 * It will change again when someone from your friends chat enters the raid to generate it
	 * It will be reset when the raid starts but not if they leave the raid while it has not started yet
	 */
	@Getter
	private int raidPartyID;
	private RaidsTimer timer;
	boolean checkInRaid;
	private boolean loggedIn;

	@Override
	public void onStart()
	{
		overlayManager.add(overlay);
		updateLists();
		clientThread.invokeLater(() -> checkRaidPresence());
		chatCommandManager.registerCommandAsync(LAYOUT_COMMAND, this::lookupRaid, this::submitRaid);
	}

	@Override
	public void onStop()
	{
		chatCommandManager.unregisterCommand(LAYOUT_COMMAND);
		overlayManager.remove(overlay);
		infoBoxManager.removeInfoBox(timer);
		timer = null;
		inRaidChambers = false;
		reset();
	}

	@Override
	public void onConfigChanged(ConfigChanged event)
	{
		if (!event.getGroup().equals("raids"))
		{
			return;
		}

		if (event.getKey().equals("raidsTimer"))
		{
			updateInfoBoxState();
			return;
		}

		updateLists();
	}

	@Override
	public void onVarbitChanged(VarbitChanged event)
	{
		// if the player's party state has changed
		if (event.getVarpId() == VarPlayer.IN_RAID_PARTY.getId())
		{
			boolean tempInRaid = client.getVarbitValue(Varbits.IN_RAID) == 1;
			// if the player is outside of a raid when the party state changed
			if (loggedIn
				&& !tempInRaid)
			{
				reset();
			}

			raidPartyID = event.getValue();
		}

		// if the player's raid state has changed
		if (event.getVarbitId() == Varbits.IN_RAID)
		{
			boolean tempInRaid = event.getValue() == 1;
			// if the player is inside of a raid then check the raid
			if (tempInRaid && loggedIn)
			{
				checkRaidPresence();
			}

			inRaidChambers = tempInRaid;
		}
	}

	@Override
	public void onChatMessage(ChatMessage event)
	{
		if (inRaidChambers && event.getType() == ChatMessageType.FRIENDSCHATNOTIFICATION)
		{
			String message = Text.removeTags(event.getMessage());

			if (config.raidsTimer() && message.startsWith(RAID_START_MESSAGE))
			{
				timer = new RaidsTimer(this, Instant.now(), config);
				spriteManager.getSpriteAsync(TAB_QUESTS_BROWN_RAIDING_PARTY, 0, timer);
				infoBoxManager.addInfoBox(timer);
			}

			if (timer != null && message.contains(LEVEL_COMPLETE_MESSAGE))
			{
				timer.timeFloor();
			}

			if (message.startsWith(RAID_COMPLETE_MESSAGE))
			{
				if (timer != null)
				{
					timer.timeOlm();
					timer.setStopped(true);
				}

				if (config.pointsMessage())
				{
					int totalPoints = client.getVarbitValue(Varbits.TOTAL_POINTS);
					int personalPoints = client.getVarbitValue(Varbits.PERSONAL_POINTS);

					double percentage = personalPoints / (totalPoints / 100.0);

					String chatMessage = new ChatMessageBuilder()
						.append(ChatColorType.NORMAL)
						.append("Total points: ")
						.append(ChatColorType.HIGHLIGHT)
						.append(POINTS_FORMAT.format(totalPoints))
						.append(ChatColorType.NORMAL)
						.append(", Personal points: ")
						.append(ChatColorType.HIGHLIGHT)
						.append(POINTS_FORMAT.format(personalPoints))
						.append(ChatColorType.NORMAL)
						.append(" (")
						.append(ChatColorType.HIGHLIGHT)
						.append(DECIMAL_FORMAT.format(percentage))
						.append(ChatColorType.NORMAL)
						.append("%)")
						.build();

					chatMessageManager.queue(QueuedMessage.Companion.builder()
						.type(ChatMessageType.FRIENDSCHATNOTIFICATION)
						.runeLiteFormattedMessage(chatMessage));
				}
			}
		}
	}

	@Override
	public void onGameStateChanged(GameStateChanged event)
	{
		if (client.getGameState() == GameState.LOGGED_IN)
		{
			// skip event while the game decides if the player belongs in a raid or not
			if (client.getLocalPlayer() == null
				|| client.getLocalPlayer().getWorldLocation().equals(TEMP_LOCATION))
			{
				return;
			}

		}
		else if (client.getGameState() == GameState.LOGIN_SCREEN
			|| client.getGameState() == GameState.CONNECTION_LOST)
		{
			loggedIn = false;
		}
		else if (client.getGameState() == GameState.HOPPING)
		{
			reset();
		}
	}

	@Override
	public void onGameTick(GameTick event) {
		if (Objects.INSTANCE.getFirst(ObjectID.STEPS_29778) != null){
			checkInRaid = true;
		} else
			checkInRaid = false;
		if (checkInRaid) {
			checkRaidPresence();
		} else {
			if (raidPartyID == -1) {
				reset();
			}
		}
	}

	private void checkRaidPresence()
	{
		if (client.getGameState() != GameState.LOGGED_IN)
		{
			return;
		}

		inRaidChambers = client.getVarbitValue(Varbits.IN_RAID) == 1;

		if (!inRaidChambers)
		{
			return;
		}

		updateInfoBoxState();
		boolean firstSolve = (raid == null);
		raid = buildRaid(raid);

		if (raid == null)
		{
			log.debug("Failed to build raid");
			return;
		}

		if (raid.getLayout() == null)
		{
			Layout layout = layoutSolver.findLayout(raid.toCode());

			if (layout == null)
			{
				log.debug("Could not find layout match");
				raid = null;
				return;
			}

			raid.updateLayout(layout);
		}

		RaidRoom[] rooms = raid.getCombatRooms();
		RotationSolver.solve(rooms);
		raid.setCombatRooms(rooms);

		if (config.layoutMessage() && firstSolve)
		{
			sendRaidLayoutMessage();
		}

		//eventBus.post(new RaidScouted(raid, firstSolve));
	}

	private void sendRaidLayoutMessage()
	{
		final String layout = getRaid().getLayout().toCodeString();
		final String rooms = getRaid().toRoomString();
		final String raidData = "[" + layout + "]: " + rooms;

		final String layoutMessage = new ChatMessageBuilder()
			.append(ChatColorType.HIGHLIGHT)
			.append("Layout: ")
			.append(ChatColorType.NORMAL)
			.append(raidData)
			.build();

		chatMessageManager.queue(QueuedMessage.Companion.builder()
			.type(ChatMessageType.FRIENDSCHATNOTIFICATION)
			.runeLiteFormattedMessage(layoutMessage));

	}

	private void updateInfoBoxState()
	{
		if (timer != null && !inRaidChambers)
		{
			infoBoxManager.removeInfoBox(timer);
			timer = null;
		}
	}

	@VisibleForTesting
	void updateLists()
	{
		updateList(roomWhitelist, config.whitelistedRooms());
		updateList(roomBlacklist, config.blacklistedRooms());
		updateList(layoutWhitelist, config.whitelistedLayouts());

		// Update rotation whitelist
		rotationWhitelist.clear();
		for (String line : config.whitelistedRotations().split("\\n"))
		{
			rotationWhitelist.add(line.toLowerCase().replace(" ", ""));
		}
	}

	private void updateList(Collection<String> list, String input)
	{
		list.clear();
		for (String s : Text.fromCSV(input.toLowerCase()))
		{
			if (s.equals("unknown"))
			{
				list.add("unknown (combat)");
				list.add("unknown (puzzle)");
			}
			else
			{
				list.add(s);
			}
		}
	}

	boolean getRotationMatches()
	{
		RaidRoom[] combatRooms = raid.getCombatRooms();
		String rotation = Arrays.stream(combatRooms)
			.map(RaidRoom::getName)
			.map(String::toLowerCase)
			.collect(Collectors.joining(","));

		return rotationWhitelist.contains(rotation);
	}

	private Point findLobbyBase()
	{
		Tile[][] tiles = client.getScene().getTiles()[LOBBY_PLANE];

		for (int x = 0; x < SCENE_SIZE; x++)
		{
			for (int y = 0; y < SCENE_SIZE; y++)
			{
				if (tiles[x][y] == null || tiles[x][y].getWallObject() == null)
				{
					continue;
				}

				if (tiles[x][y].getWallObject().getId() == NullObjectID.NULL_12231)
				{
					return tiles[x][y].getSceneLocation();
				}
			}
		}

		return null;
	}

	private Raid buildRaid(Raid from)
	{
		Raid raid = from;

		if (raid == null)
		{
			// The south-west tile of the lobby room in the scene
			Point gridBase = findLobbyBase();

			if (gridBase == null)
			{
				return null;
			}

			Integer lobbyIndex = findLobbyIndex(gridBase);

			if (lobbyIndex == null)
			{
				return null;
			}

			raid = new Raid(
				new WorldPoint(client.getBaseX() + gridBase.getX(), client.getBaseY() + gridBase.getY(), LOBBY_PLANE),
				lobbyIndex
			);
		}

		/*
		 * The x position of the starting room relative to other rooms
		 * The west most room will have a value of 0 and the east most will have a value of 3
		 * The rooms have the following x values
		 *     0 1 2 3
		 *     0 1 2 3
		 */
		int baseX = raid.getLobbyIndex() % AMOUNT_OF_ROOMS_PER_X_AXIS_PER_PLANE;

		/*
		 * The y position of the starting room relative to other rooms
		 * The north rooms will have a y value of 0 and the south will have a value of 1
		 * The rooms have the following y values
		 *     0 0 0 0
		 *     1 1 1 1
 		 */
		int baseY = raid.getLobbyIndex() % ROOMS_PER_PLANE > (AMOUNT_OF_ROOMS_PER_X_AXIS_PER_PLANE - 1) ? 1 : 0;

		/*
		 * i is the position of the room in the raid room array, the raid rooms are in order of north to south,
		 * west to east, and plane 3 to plane 2. For example the 0th room is the north-west room on plane 3 and
		 * the 15th room is the south-east room of plane 2
		 *
		 * The indexes of the rooms of plane 3 (the first/lobby floor) will look like
		 *     0  1  2  3
		 *     4  5  6  7
		 *
		 * The indexes of the rooms of plane 2 (the second floor) will look like
		 *     8  9  10 11
		 *     12 13 14 15
		 */
		for (int i = 0; i < raid.getRooms().length; i++)
		{
			/*
			 * The x position of the current room relative to other rooms
			 * The west most room will have a value of 0 and the east most will have a value of 3
			 * The rooms have the following x values
			 *     0 1 2 3
			 *     0 1 2 3
			 */
			int x = i % AMOUNT_OF_ROOMS_PER_X_AXIS_PER_PLANE;

			/*
			 * The y position of the current room relative to other rooms
			 * The north rooms will have a y value of 0 and the south will have a value of 1
			 * The rooms have the following y values
			 *     0 0 0 0
			 *     1 1 1 1
			 */
			int y = i % ROOMS_PER_PLANE > (AMOUNT_OF_ROOMS_PER_X_AXIS_PER_PLANE - 1) ? 1 : 0;

			/*
			 * The plane of the current room
			 * The rooms on the lobby/first floor will have a plane of 3
			 * The rooms on the second floor will have a plane of 2
			 */
			int plane = i > (ROOMS_PER_PLANE - 1) ? SECOND_FLOOR_PLANE : LOBBY_PLANE;

			// The x position of the current room relative to starting room
			x = x - baseX;

			// The y position of the current room relative to starting room
			y = y - baseY;

			// The x coord (world point) of the south west tile of the current room
			x = raid.getGridBase().getX() + x * RaidRoom.ROOM_MAX_SIZE;

			// The y coord (world point) of the south west tile of the current room
			y = raid.getGridBase().getY() - y * RaidRoom.ROOM_MAX_SIZE;

			// The x coord (scene) of the south west tile of the current room
			x = x - client.getBaseX();

			// The y coord (scene) of the south west tile of the current room
			y = y - client.getBaseY();

			// If the west tile of the current room is not in the scene but the room itself has tiles in the scene
			// then make x a tile of the room that is actually in the scene
			if (x < (1 - RaidRoom.ROOM_MAX_SIZE) || x >= SCENE_SIZE)
			{
				continue;
			}
			else if (x < 1)
			{
				x = 1;
			}

			// If the south tile of the current room is not in the scene
			// then make y a tile of the room that is actually in the scene
			if (y < 1)
			{
				y = 1;
			}

			// The scene tile of the current room to check for
			Tile tile = client.getScene().getTiles()[plane][x][y];

			if (tile == null)
			{
				continue;
			}

			// scout the room
			RaidRoom room = determineRoom(tile);
			raid.setRoom(room, i);
		}

		return raid;
	}

	private RaidRoom determineRoom(Tile base)
	{
		int chunkData = client.getInstanceTemplateChunks()[base.getPlane()][(base.getSceneLocation().getX()) / 8][base.getSceneLocation().getY() / 8];
		InstanceTemplates template = InstanceTemplates.findMatch(chunkData);

		if (template == null)
		{
			return RaidRoom.EMPTY;
		}

		switch (template)
		{
			case RAIDS_LOBBY:
			case RAIDS_START:
				return RaidRoom.START;

			case RAIDS_END:
				return RaidRoom.END;

			case RAIDS_SCAVENGERS:
			case RAIDS_SCAVENGERS2:
				return RaidRoom.SCAVENGERS;

			case RAIDS_SHAMANS:
				return RaidRoom.SHAMANS;

			case RAIDS_VASA:
				return RaidRoom.VASA;

			case RAIDS_VANGUARDS:
				return RaidRoom.VANGUARDS;

			case RAIDS_ICE_DEMON:
				return RaidRoom.ICE_DEMON;

			case RAIDS_THIEVING:
				return RaidRoom.THIEVING;

			case RAIDS_FARMING:
			case RAIDS_FARMING2:
				return RaidRoom.FARMING;

			case RAIDS_MUTTADILES:
				return RaidRoom.MUTTADILES;

			case RAIDS_MYSTICS:
				return RaidRoom.MYSTICS;

			case RAIDS_TEKTON:
				return RaidRoom.TEKTON;

			case RAIDS_TIGHTROPE:
				return RaidRoom.TIGHTROPE;

			case RAIDS_GUARDIANS:
				return RaidRoom.GUARDIANS;

			case RAIDS_CRABS:
				return RaidRoom.CRABS;

			case RAIDS_VESPULA:
				return RaidRoom.VESPULA;

			default:
				return RaidRoom.EMPTY;
		}
	}

	private void lookupRaid(ChatMessage chatMessage, String s)
	{
		ChatMessageType type = chatMessage.getType();

		final String player;
		if (type.equals(ChatMessageType.PRIVATECHATOUT))
		{
			player = client.getLocalPlayer().getName();
		}
		else
		{
			player = Text.sanitize(chatMessage.getName());
		}

		LayoutRoom[] layout;
		try
		{
			layout = chatClient.getLayout(player);
		}
		catch (IOException ex)
		{
			log.debug("unable to lookup layout", ex);
			return;
		}

		if (layout == null || layout.length == 0)
		{
			return;
		}

		String layoutMessage = Joiner.on(", ").join(Arrays.stream(layout)
			.map(l -> RaidRoom.valueOf(l.name()))
			.filter(room -> room.getType() == RoomType.COMBAT || room.getType() == RoomType.PUZZLE)
			.map(RaidRoom::getName)
			.toArray());

		if (layoutMessage.length() > MAX_LAYOUT_LEN)
		{
			log.debug("layout message too long! {}", layoutMessage.length());
			return;
		}

		String response = new ChatMessageBuilder()
			.append(ChatColorType.HIGHLIGHT)
			.append("Layout: ")
			.append(ChatColorType.NORMAL)
			.append(layoutMessage)
			.build();

		log.debug("Setting response {}", response);
		final MessageNode messageNode = chatMessage.getMessageNode();
		messageNode.setRuneLiteFormatMessage(response);
		client.refreshChat();
	}

	private boolean submitRaid(ChatInput chatInput, String s)
	{
		if (raid == null)
		{
			return false;
		}

		final String playerName = client.getLocalPlayer().getName();
		List<RaidRoom> orderedRooms = raid.getOrderedRooms();

		LayoutRoom[] layoutRooms = orderedRooms.stream()
			.map(room -> LayoutRoom.valueOf(room.name()))
			.toArray(LayoutRoom[]::new);

		scheduledExecutorService.execute(() ->
		{
			try
			{
				chatClient.submitLayout(playerName, layoutRooms);
			}
			catch (Exception ex)
			{
				log.warn("unable to submit layout", ex);
			}
			finally
			{
				chatInput.resume();
			}
		});

		return true;
	}

	void screenshotScoutOverlay()
	{

	}

	/**
	 * Finds the lobby room index in the room array
	 * There are 8 rooms per floor in a 4 wide (x) and 2 high (y) rectangle
	 * The rooms on plane 3 (the lobby plane) have the following indexes
	 *     0 1 2 3
	 *     4 5 6 7
	 */
	private Integer findLobbyIndex(Point gridBase)
	{
		/*
		 * If the room to the right of the starting room can't be seen then return null
		 * This should only happen if the user turns on the raid plugin while already inside of a raid and not in the
		 * starting location
		 *
		 * The player should always be able to see both rows of rooms (on the y axis) so the second check is not needed
		 * but is included to be safe
		 */
		if (Constants.SCENE_SIZE <= gridBase.getX() + RaidRoom.ROOM_MAX_SIZE
			|| Constants.SCENE_SIZE <= gridBase.getY() + RaidRoom.ROOM_MAX_SIZE)
		{
			return null;
		}

		int x;
		int y;

		// the lobby will always be on the top/first floor (plane 3)
		Tile[][] tiles = client.getScene().getTiles()[LOBBY_PLANE];

		/*
		 * if there is no room north the lobby then it is the north most room
		 * The north rooms will have a y value of 0 and the south will have a value of 1
		 * The rooms have the following y values
		 *     0 0 0 0
		 *     1 1 1 1
		 */
		if (tiles[gridBase.getX()][gridBase.getY() + RaidRoom.ROOM_MAX_SIZE] == null)
		{
			y = 0;
		}
		else
		{
			y = 1;
		}

		/*
		 * if there is no room east of the lobby then it is the east most room
		 * The west most room will have a value of 0 and the east most will have a value of 3
		 * The rooms have the following x values
		 *     0 1 2 3
		 *     0 1 2 3
		 */
		if (tiles[gridBase.getX() + RaidRoom.ROOM_MAX_SIZE][gridBase.getY()] == null)
		{
			x = 3;
		}
		else
		{
			// determine x based on how many rooms are to the west of it.
			for (x = 0; x < 3; x++)
			{
				int sceneX = gridBase.getX() - 1 - RaidRoom.ROOM_MAX_SIZE * x;
				if (sceneX < 0 || tiles[sceneX][gridBase.getY()] == null)
				{
					break;
				}
			}
		}

		// the room index based on its x and y values
		return x + y * AMOUNT_OF_ROOMS_PER_X_AXIS_PER_PLANE;
	}

	private void reset()
	{
		raid = null;
		updateInfoBoxState();
		//eventBus.post(new RaidReset());
	}
}
