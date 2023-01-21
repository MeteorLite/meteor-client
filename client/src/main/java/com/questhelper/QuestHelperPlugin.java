/*
 * Copyright (c) 2020, Zoinkwiz <https://github.com/Zoinkwiz>
 * Copyright (c) 2019, Trevor <https://github.com/Trevor159>
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
package com.questhelper;

import androidx.compose.ui.Alignment;
import com.google.common.collect.ImmutableSet;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import com.google.common.primitives.Ints;
import com.google.common.reflect.ClassPath;
import com.google.inject.Binder;
import com.google.inject.CreationException;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.Provides;
import com.questhelper.banktab.QuestBankTab;
import com.questhelper.banktab.QuestHelperBankTagService;
import com.questhelper.overlays.QuestHelperDebugOverlay;
import com.questhelper.overlays.QuestHelperOverlay;
import com.questhelper.overlays.QuestHelperWidgetOverlay;
import com.questhelper.overlays.QuestHelperWorldArrowOverlay;
import com.questhelper.overlays.QuestHelperWorldLineOverlay;
import com.questhelper.overlays.QuestHelperWorldOverlay;
import com.questhelper.questhelpers.QuestDetails;
import com.questhelper.questhelpers.QuestHelper;
import com.questhelper.requirements.item.ItemRequirement;
import com.questhelper.steps.QuestStep;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import javax.inject.Inject;
import javax.inject.Named;
import javax.swing.SwingUtilities;

import eventbus.events.*;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import meteor.Main;
import meteor.chat.QueuedMessage;
import meteor.config.ConfigManager;
import meteor.game.ItemManager;
import meteor.game.SpriteManager;
import meteor.plugins.Plugin;
import meteor.plugins.PluginDescriptor;
import meteor.plugins.bank.BankSearch;
import meteor.rs.ClientThread;
import meteor.ui.composables.toolbar.ToolbarButton;
import meteor.ui.overlay.OverlayManager;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.InventoryID;
import net.runelite.api.MenuAction;
import net.runelite.api.MenuEntry;
import net.runelite.api.Perspective;
import net.runelite.api.Player;
import net.runelite.api.Point;
import net.runelite.api.QuestState;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.util.Text;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.chat.ChatColorType;
import net.runelite.client.chat.ChatMessageBuilder;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.events.CommandExecuted;

import static meteor.ui.composables.preferences.UiPrefrencesKt.getPluginPanel;
import static meteor.ui.composables.preferences.UiPrefrencesKt.getPluginPanelIsOpen;
import static meteor.ui.composables.toolbar.ToolbarKt.addButton;
import static meteor.ui.composables.toolbar.ToolbarKt.removeButton;

@PluginDescriptor(
	name = "Quest Helper",
	description = "Helps you with questing",
	tags = { "quest", "helper", "overlay" }
)
@Slf4j
public class QuestHelperPlugin extends Plugin
{
	private static final int[] QUESTLIST_WIDGET_IDS = new int[]
		{
			QuestWidgets.QUEST_CONTAINER.getId()
		};

	private static final String[] RFD_NAMES = new String[]
		{
			QuestHelperQuest.RECIPE_FOR_DISASTER_FINALE.getName(),
			QuestHelperQuest.RECIPE_FOR_DISASTER_MONKEY_AMBASSADOR.getName(),
			QuestHelperQuest.RECIPE_FOR_DISASTER_SIR_AMIK_VARZE.getName(),
			QuestHelperQuest.RECIPE_FOR_DISASTER_DWARF.getName(),
			QuestHelperQuest.RECIPE_FOR_DISASTER_EVIL_DAVE.getName(),
			QuestHelperQuest.RECIPE_FOR_DISASTER_WARTFACE_AND_BENTNOZE.getName(),
			QuestHelperQuest.RECIPE_FOR_DISASTER_SKRACH_UGLOGWEE.getName(),
			QuestHelperQuest.RECIPE_FOR_DISASTER_PIRATE_PETE.getName(),
			QuestHelperQuest.RECIPE_FOR_DISASTER_LUMBRIDGE_GUIDE.getName(),
			QuestHelperQuest.RECIPE_FOR_DISASTER_START.getName()
		};

	private static final int[] ACHIEVEMENTLIST_WIDGET_IDS = new int[]
		{
			WidgetInfo.ACHIEVEMENT_DIARY_CONTAINER.getId()
		};

	private static final String[] achievementTiers = new String[]
		{
			"Elite",
			"Hard",
			"Medium",
			"Easy"
		};

	private static final String QUEST_PACKAGE = "com.questhelper.quests";
	private static final String ACHIEVEMENT_PACKAGE = "com.questhelper.achievementdiaries";

	private static final String MENUOP_STARTHELPER = "Start Quest Helper";
	private static final String MENUOP_STOPHELPER = "Stop Quest Helper";
	private static final String MENUOP_QUESTHELPER = "Quest Helper";

	private static final String MENUOP_STARTGENERICHELPER = "Start Helper";
	private static final String MENUOP_STOPGENERICHELPER = "Stop Helper";
	private static final String MENUOP_GENERICHELPER = "Helper";
	private static final String MENUOP_EXAMINE_PLAYER = "Examine";

	private static final Zone PHOENIX_START_ZONE = new Zone(new WorldPoint(3204, 3488, 0), new WorldPoint(3221, 3501, 0));

	private QuestBank questBank = QuestBank.INSTANCE;

	@Getter
	private QuestHelperBankTagService bankTagService;

	private QuestBankTab bankTagsMain;

	@Getter
	private Client client = Main.client;

	@Getter
	private ClientThread clientThread = ClientThread.INSTANCE;

	private OverlayManager overlayManager = OverlayManager.INSTANCE;

	private QuestHelperOverlay questHelperOverlay = new QuestHelperOverlay(this);

	private QuestHelperWidgetOverlay questHelperWidgetOverlay = new QuestHelperWidgetOverlay(this);

	private QuestHelperWorldOverlay questHelperWorldOverlay = new QuestHelperWorldOverlay(this);

	private QuestHelperWorldArrowOverlay questHelperWorldArrowOverlay = new QuestHelperWorldArrowOverlay(this);

	private QuestHelperWorldLineOverlay questHelperWorldLineOverlay = new QuestHelperWorldLineOverlay(this);

	@Getter
	private BankSearch bankSearch = BankSearch.INSTANCE;

	@Getter
	private ItemManager itemManager = ItemManager.INSTANCE;

	@Getter
	ChatMessageManager chatMessageManager = Main.chatMessageManager;


	private QuestHelperDebugOverlay questHelperDebugOverlay = new QuestHelperDebugOverlay(this);

	@Getter
	private QuestHelperConfig config = (QuestHelperConfig) javaConfiguration(QuestHelperConfig.class);

	@Getter
	private QuestHelper selectedQuest = null;

	@Setter
	private QuestHelper sidebarSelectedQuest = null;

	private QuestStep lastStep = null;

	private Map<String, QuestHelper> quests;

	@Inject
	SpriteManager spriteManager = SpriteManager.INSTANCE;

	@Getter
	ConfigManager configManager = ConfigManager.INSTANCE;

	@Getter
	GameStateManager gameStateManager;

	private boolean loadQuestList;

	private boolean displayNameKnown;

	private ToolbarButton toolbarButton = new ToolbarButton("Quest Helper", "quest_helper.png",
			"Shows info for quest",
			Alignment.Companion.getTopCenter(), false, togglePanel());

	public Map<String, QuestHelper> backgroundHelpers = new HashMap<>();
	public SortedMap<QuestHelperQuest, List<ItemRequirement>> itemRequirements = new TreeMap<>();
	public SortedMap<QuestHelperQuest, List<ItemRequirement>> itemRecommended = new TreeMap<>();

	@Getter
	private Cheerer cheerer;

	private int tickAddedCheerer = -1;

	@Getter
	private int lastTickInventoryUpdated = -1;

	@Getter
	private int lastTickBankUpdated = -1;

	@Override
	public void onStart()
	{
		bankTagService = new QuestHelperBankTagService(this, questBank);
		bankTagsMain = new QuestBankTab();
		bankTagsMain.startUp();
		bankTagsMain.subscribe();
		bankTagsMain.setEventListening(true);

		gameStateManager = new GameStateManager();
		gameStateManager.subscribe();
		gameStateManager.setEventListening(true);
		gameStateManager.startUp();

		try {
			quests = scanAndInstantiate(getClass().getClassLoader());
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		overlayManager.add(questHelperOverlay);
		overlayManager.add(questHelperWorldOverlay);
		overlayManager.add(questHelperWorldArrowOverlay);
		overlayManager.add(questHelperWorldLineOverlay);
		overlayManager.add(questHelperWidgetOverlay);

		final BufferedImage icon = Icon.QUEST_ICON.getImage();
		addButton(toolbarButton);
	}

	@Override
	public void onStop()
	{
		bankTagsMain.unsubscribe();
		bankTagsMain.shutDown();

		gameStateManager.unsubscribe();

		overlayManager.remove(questHelperOverlay);
		overlayManager.remove(questHelperWorldOverlay);
		overlayManager.remove(questHelperWorldArrowOverlay);
		overlayManager.remove(questHelperWorldLineOverlay);
		overlayManager.remove(questHelperWidgetOverlay);
		overlayManager.remove(questHelperDebugOverlay);

		shutDownQuest(false);
		bankTagService = null;
		bankTagsMain = null;
		quests = null;

		removeButton(toolbarButton);
	}

	private QuestHelperPluginPanel pluginPanel;

	public Function0<Unit> togglePanel() {
		return () -> {
			getPluginPanel().setValue(pluginPanel);
			togglePluginPanel(toolbarButton);
			return null;
		};
	}

	public void openPluginPanel() {
		getPluginPanelIsOpen().setValue(true);
	}

	public void closePluginPanel() {
		getPluginPanelIsOpen().setValue(false);
	}

	boolean hasSetup = false;

	@Override
	public void onGameTick(GameTick event)
	{
		if (!hasSetup) {
			clientThread.invokeLater(() -> {
				quests.forEach((name, questHelper) -> {
					questHelper.subscribe();
					questHelper.setEventListening(true);
					questHelper.setupRequirements();
					questHelper.unsubscribe();
				});
				if (client.getGameState() == GameState.LOGGED_IN)
				{
					// Update with new items
					quests.get(QuestHelperQuest.CHECK_ITEMS.getName()).init();
					getAllItemRequirements();
					loadQuestList = true;
				}
			});
			hasSetup = true;
		}
		if (tickAddedCheerer != -1 && tickAddedCheerer < client.getTickCount() - 20)
		{
			tickAddedCheerer = -1;
			removeCheerer();
		}

		if (!displayNameKnown)
		{
			Player localPlayer = client.getLocalPlayer();
			if (localPlayer != null && localPlayer.getName() != null)
			{
				displayNameKnown = true;
				questBank.loadState();
			}
		}
		if (sidebarSelectedQuest != null)
		{
			startUpQuest(sidebarSelectedQuest);
			sidebarSelectedQuest = null;
		}
		else if (selectedQuest != null)
		{
			if (selectedQuest.getCurrentStep() != null)
			{
				//panel.updateSteps();
				QuestStep currentStep = selectedQuest.getCurrentStep().getSidePanelStep();
				if (currentStep != null && currentStep != lastStep)
				{
					lastStep = currentStep;
					//panel.updateHighlight(client, currentStep);
				}
/*				if (panel.questActive)
				{
					//clientThread.invokeLater(() -> panel.updateItemRequirements(client, questBank.getBankItems()));
				}*/
				//panel.updateLocks();
			}
		}
		if (loadQuestList)
		{
			loadQuestList = false;
			updateQuestList();
			getAllItemRequirements();
		}
	}

	@Override
	public void onItemContainerChanged(ItemContainerChanged event)
	{
		if (event.getItemContainer() == client.getItemContainer(InventoryID.BANK))
		{
			lastTickBankUpdated = client.getTickCount();
			questBank.updateLocalBank(event.getItemContainer().getItems());
		}

		if (event.getItemContainer() == client.getItemContainer(InventoryID.INVENTORY))
		{
			lastTickInventoryUpdated = client.getTickCount();
		}
	}

	@Override
	public void onGameStateChanged(final GameStateChanged event)
	{
		final GameState state = event.getGameState();

		if (state == GameState.LOGIN_SCREEN)
		{
			if (questBank.getBankItems().size() > 0) {
				questBank.saveBankToConfig();
				//SwingUtilities.invokeLater(() -> panel.refresh(Collections.emptyList(), true, new HashMap<>()));
				questBank.emptyState();
			}

			if (selectedQuest != null && selectedQuest.getCurrentStep() != null)
			{
				shutDownQuest(true);
			}
		}

		if (state == GameState.LOGGED_IN)
		{
			loadQuestList = true;
			displayNameKnown = false;
			clientThread.invokeLater(() -> {
				quests.forEach((name, questHelper) -> {
					questHelper.subscribe();
					questHelper.setEventListening(true);
					questHelper.init();
					questHelper.unsubscribe();
				});
				quests.get(QuestHelperQuest.CHECK_ITEMS.getName()).init();
				getAllItemRequirements();
			});
		}
	}

	@Override
	public void onVarbitChanged(VarbitChanged event)
	{
		if (!(client.getGameState() == GameState.LOGGED_IN))
		{
			return;
		}

		if (selectedQuest == null)
		{
			return;
		}

		if (selectedQuest.updateQuest() && selectedQuest.getCurrentStep() == null)
		{
			shutDownQuest(true);
		}

		clientThread.invokeLater(() -> {
			if ((selectedQuest != null) && selectedQuest.isCompleted())
			{
				shutDownQuest(true);
			}
		});
	}

	private final Collection<String> configEvents = Arrays.asList("orderListBy", "filterListBy", "questDifficulty", "showCompletedQuests");
	private final Collection<String> configItemEvents = Arrays.asList("highlightNeededQuestItems", "highlightNeededMiniquestItems", "highlightNeededAchievementDiaryItems");

	@Override
	public void onConfigChanged(ConfigChanged event)
	{
		if (!event.getGroup().equals("questhelper"))
		{
			return;
		}

		if (configEvents.contains(event.getKey()))
		{
			clientThread.invokeLater(this::updateQuestList);
		}

		if (configItemEvents.contains(event.getKey()))
		{
			getAllItemRequirements();
			if (selectedQuest != null && selectedQuest.getQuest() == QuestHelperQuest.CHECK_ITEMS)
			{
				clientThread.invokeLater(() -> {
					startUpQuest(quests.get(QuestHelperQuest.CHECK_ITEMS.getName()), false);
				});
			}
		}

		if ("highlightItemsBackground".equals(event.getKey()))
		{
			// If shouldn't highlight, shut down highlights
			if (Objects.equals(event.getNewValue(), "false"))
			{
				shutDownBackgroundQuest(backgroundHelpers.get(QuestHelperQuest.CHECK_ITEMS.getName()));
			}
			else
			{
				startUpBackgroundQuest(QuestHelperQuest.CHECK_ITEMS.getName());
			}
		}
	}

/*	@Override
	public void onCommandExecuted(CommandExecuted commandExecuted)
	{
		if (commandExecuted.getCommand().equals("questhelperdebug"))
		{
			if (commandExecuted.getArguments().length == 0 ||
				(Arrays.stream(commandExecuted.getArguments()).toArray()[0]).equals("disable"))
			{
				overlayManager.remove(questHelperDebugOverlay);
			}
			else if ((Arrays.stream(commandExecuted.getArguments()).toArray()[0]).equals("enable"))
				overlayManager.add(questHelperDebugOverlay);
		}
	}*/

/*
	@Subscribe()
	private void onClientShutdown(ClientShutdown e)
	{
		questBank.saveBankToConfig();
	}
*/

	public void updateQuestList()
	{
		if (client.getGameState() == GameState.LOGGED_IN)
		{
			List<QuestHelper> filteredQuests = quests.values()
				.stream()
				.filter(config.filterListBy())
				.filter(config.difficulty())
				.filter(QuestDetails::showCompletedQuests)
				.sorted(config.orderListBy())
				.collect(Collectors.toList());
			Map<QuestHelperQuest, QuestState> completedQuests = quests.values()
				.stream()
				.collect(Collectors.toMap(QuestHelper::getQuest, q -> q.getState(client)));
/*			SwingUtilities.invokeLater(() -> {
				panel.refresh(filteredQuests, false, completedQuests, config.orderListBy().getSections());
			});*/
		}
	}

	@Override
	public void onMenuOptionClicked(MenuOptionClicked event)
	{
		if (event.getMenuAction() != MenuAction.RUNELITE)
		{
			return;
		}

		switch (event.getMenuOption())
		{
			case MENUOP_STARTHELPER:
			case MENUOP_STARTGENERICHELPER:
				event.consume();
				String quest = Text.removeTags(event.getMenuTarget());
				startUpQuest(quests.get(quest));
				if (config.autoOpenSidebar()) {
					getPluginPanel().setValue(pluginPanel);
					openPluginPanel();
				}
				break;
			case MENUOP_STOPHELPER:
			case MENUOP_STOPGENERICHELPER:
				event.consume();
				shutDownQuest(true);
				break;
			case MENUOP_EXAMINE_PLAYER:
				if (!event.getMenuTarget().equals("<col=ffff00>" + cheerer.getStyle().getDisplayName() + "</col>")) break;
				event.consume();
				String chatMessage = new ChatMessageBuilder()
					.append(ChatColorType.NORMAL)
					.append(cheerer.getStyle().getExamine())
					.build();

				chatMessageManager.queue(QueuedMessage.Companion.builder()
					.type(ChatMessageType.NPC_EXAMINE)
					.runeLiteFormattedMessage(chatMessage)
					.timestamp((int) (System.currentTimeMillis() / 1000)));
				break;
		}
	}

	private MenuEntry[] addRightClickMenuOptions(String helperName, String entryName, String target,
												 MenuEntry[] menuEntries,
												 int widgetIndex, int widgetID)
	{
		QuestHelper questHelper = quests.get(helperName);
		if (questHelper != null && !questHelper.isCompleted())
		{
			if (selectedQuest != null && selectedQuest.getQuest().getName().equals(helperName))
			{
				return addNewEntry(menuEntries, "Stop " + entryName, target, widgetIndex, widgetID);
			}
			else
			{
				return addNewEntry(menuEntries, "Start " + entryName, target, widgetIndex, widgetID);
			}
		}

		return menuEntries;
	}

	private void addCheerer()
	{
		WorldPoint worldPoint = client.getLocalPlayer().getWorldLocation();
		WorldPoint wpUp = new WorldPoint(worldPoint.getX(), worldPoint.getY() + 1, worldPoint.getPlane());
		if (cheerer == null)
		{
			cheerer = new Cheerer(client, clientThread, wpUp, Cheerer.Style.randomCheerer(), chatMessageManager,
				"Congratz on completing the quest!");
		}

		tickAddedCheerer = client.getTickCount();
	}

	private void removeCheerer()
	{
		if (cheerer != null)
		{
			cheerer.remove();
			cheerer = null;
		}
	}

	public MenuEntry[] addCheererExamine(MenuEntry[] menuEntries, int widgetIndex, int widgetID)
	{
		LocalPoint lp = LocalPoint.fromWorld(client, cheerer.worldPoint);

		if (lp == null) return menuEntries;

		Point p = Perspective.localToCanvas(client, lp, client.getPlane(),
			cheerer.runeLiteObject.getModelHeight() / 2);
		if (p == null) return menuEntries;


		if (p.distanceTo(client.getMouseCanvasPosition()) > 100) return menuEntries;

		menuEntries = Arrays.copyOf(menuEntries, menuEntries.length + 1);

		client.createMenuEntry(menuEntries.length - 1)
			.setOption("Examine")
			.setTarget("<col=ffff00>" + cheerer.getStyle().getDisplayName() + "</col>")
			.setType(MenuAction.RUNELITE)
			.setParam0(widgetIndex)
			.setParam1(widgetID);

		return menuEntries;
	}

	@Subscribe
	public void onMenuEntryAdded(MenuEntryAdded event)
	{
		int widgetIndex = event.getParam0();
		int widgetID = event.getParam1();
		MenuEntry[] menuEntries = client.getMenuEntries();

		if (cheerer != null && cheerer.runeLiteObject != null && cheerer.runeLiteObject.getModel() != null &&
			event.getOption().equals("Walk here"))
		{
			menuEntries = addCheererExamine(menuEntries, widgetIndex, widgetID);
		}

		String target = Text.removeTags(event.getTarget());

		if (Ints.contains(ACHIEVEMENTLIST_WIDGET_IDS, widgetID) && event.getOption().contains("Open "))
		{
			String diary = event.getOption().replace("Journal", "");
			diary = diary.replace("Open ", "");
			diary = Text.removeTags(diary);
			for (String achievementTier : achievementTiers)
			{
				menuEntries = addRightClickMenuOptions(diary + achievementTier + " Diary", MENUOP_GENERICHELPER,
					"<col=ff9040>" + diary + achievementTier + " Diary</col>", menuEntries, widgetIndex, widgetID);
			}
		}

		if (Ints.contains(QUESTLIST_WIDGET_IDS, widgetID) && "Read journal:".equals(event.getOption()))
		{
			if (target.equals("Shield of Arrav"))
			{
				if (selectedQuest != null &&
					(selectedQuest.getQuest().getId() == QuestHelperQuest.SHIELD_OF_ARRAV_PHOENIX_GANG.getId()))
				{
					addNewEntry(menuEntries, MENUOP_STOPHELPER, event.getTarget(), widgetIndex, widgetID);
				}
				else
				{
					String phoenixName = QuestHelperQuest.SHIELD_OF_ARRAV_PHOENIX_GANG.getName();
					String blackArmName = QuestHelperQuest.SHIELD_OF_ARRAV_BLACK_ARM_GANG.getName();
					QuestHelper questHelperPhoenix = quests.get(phoenixName);
					QuestHelper questHelperBlackArm = quests.get(blackArmName);
					if (!questHelperPhoenix.isCompleted())
					{
						menuEntries = addRightClickMenuOptions(phoenixName, MENUOP_QUESTHELPER,
							"<col=ff9040>" + phoenixName + "</col>", menuEntries, widgetIndex, widgetID);
					}
					if (!questHelperBlackArm.isCompleted())
					{
						addRightClickMenuOptions(blackArmName, MENUOP_QUESTHELPER,
							"<col=ff9040>" + blackArmName + "</col>", menuEntries, widgetIndex, widgetID);
					}
				}
			}
			else if (target.equals("Recipe for Disaster"))
			{
				if (selectedQuest != null &&
					(selectedQuest.getQuest().getId() == QuestHelperQuest.RECIPE_FOR_DISASTER.getId()))
				{
					addRightClickMenuOptions(QuestHelperQuest.RECIPE_FOR_DISASTER.getName(), MENUOP_QUESTHELPER,
						event.getTarget(), menuEntries, widgetIndex, widgetID);
				}
				else
				{
					for (String rfdName : RFD_NAMES)
					{
						menuEntries = addRightClickMenuOptions(rfdName, MENUOP_QUESTHELPER,
							"<col=ff9040>" + rfdName + "</col>", menuEntries, widgetIndex, widgetID);
					}
				}
			}
			else
			{
				QuestHelper questHelper = quests.get(target);
				if (questHelper != null && !questHelper.isCompleted())
				{
					if (selectedQuest != null && selectedQuest.getQuest().getName().equals(target))
					{
						addNewEntry(menuEntries, MENUOP_STOPHELPER, event.getTarget(), widgetIndex, widgetID);
					}
					else
					{
						addNewEntry(menuEntries, MENUOP_STARTHELPER, event.getTarget(), widgetIndex, widgetID);
					}
				}
			}
		}
	}

	@Subscribe
	public void onChatMessage(ChatMessage chatMessage)
	{
		if (config.showFan() && chatMessage.getType() == ChatMessageType.GAMEMESSAGE) {
			if (chatMessage.getMessage().contains("Congratulations! Quest complete!") ||
			chatMessage.getMessage().contains("you've completed a quest"))
			{
				addCheerer();
			}
		}
		if (config.autoStartQuests() && chatMessage.getType() == ChatMessageType.GAMEMESSAGE)
		{
			if (selectedQuest == null && chatMessage.getMessage().contains("You've started a new quest"))
			{
				String questName = chatMessage.getMessage().substring(chatMessage.getMessage().indexOf(">") + 1);
				questName = questName.substring(0, questName.indexOf("<"));

				// Prompt for starting Shield of Arrav is the same for both routes. Display actual route started
				if (questName.equals("Shield of Arrav"))
				{
					Player player = client.getLocalPlayer();
					if (player == null)
					{
						return;
					}
					WorldPoint location = player.getWorldLocation();

					if (PHOENIX_START_ZONE.contains(location))
					{
						startUpQuest(quests.get(QuestHelperQuest.SHIELD_OF_ARRAV_PHOENIX_GANG.getName()));
					}
					else
					{
						startUpQuest(quests.get(QuestHelperQuest.SHIELD_OF_ARRAV_BLACK_ARM_GANG.getName()));
					}
				}
				else if (questName.equals("Recipe for Disaster"))
				{
					startUpQuest(quests.get(QuestHelperQuest.RECIPE_FOR_DISASTER_START.getName()));
				}
				else
				{
					QuestHelper questHelper = quests.get(questName);
					if (questHelper != null)
					{
						startUpQuest(questHelper);
					}
				}
			}
		}
	}

	private void displayPanel()
	{
/*		SwingUtilities.invokeLater(() -> {
			if (!navButton.isSelected())
			{
				navButton.getOnSelect().run();
			}
		});*/
	}

	private MenuEntry[] addNewEntry(MenuEntry[] menuEntries, String newEntry, String target, int widgetIndex, int widgetID)
	{
		menuEntries = Arrays.copyOf(menuEntries, menuEntries.length + 1);

		client.createMenuEntry(menuEntries.length - 1)
			.setOption(newEntry)
			.setTarget(target)
			.setType(MenuAction.RUNELITE)
			.setParam0(widgetIndex)
			.setParam1(widgetID);

		return menuEntries;
	}

	public void startUpQuest(QuestHelper questHelper)
	{
		startUpQuest(questHelper, true);
	}

	public void startUpQuest(QuestHelper questHelper, boolean shouldOpenSidebarIfConfig)
	{
		if (!(client.getGameState() == GameState.LOGGED_IN))
		{
			return;
		}

		shutDownQuest(true);

		if (!questHelper.isCompleted())
		{
			// If running in background, close it
			if (backgroundHelpers.containsValue(questHelper))
			{
				shutDownBackgroundQuest(questHelper);
			}

			if (shouldOpenSidebarIfConfig && config.autoOpenSidebar())
			{
				displayPanel();
			}
			selectedQuest = questHelper;
			selectedQuest.subscribe();
			selectedQuest.setEventListening(true);
			selectedQuest.startUp(config);
			if (selectedQuest.getCurrentStep() == null)
			{
				shutDownQuest(false);
				return;
			}
			bankTagsMain.startUp();
			pluginPanel = new QuestHelperPluginPanel(selectedQuest);
			getPluginPanel().setValue(pluginPanel);
			pluginPanel.subscribe();
/*			SwingUtilities.invokeLater(() -> {
				panel.removeQuest();
				panel.addQuest(questHelper, true);
			});*/
		}
		else
		{
			//panel.removeQuest();
			selectedQuest = null;
		}
	}

	public void shutDownQuestFromSidebar()
	{
		if (selectedQuest != null)
		{
			selectedQuest.shutDown();
			bankTagsMain.shutDown();
			//SwingUtilities.invokeLater(() -> panel.removeQuest());
			selectedQuest.unsubscribe();

			// If closing the item checking helper and should still check in background, start it back up in background
			if (selectedQuest.getQuest() == QuestHelperQuest.CHECK_ITEMS && config.highlightItemsBackground())
			{
				selectedQuest = null;
				startUpBackgroundQuest(QuestHelperQuest.CHECK_ITEMS.getName());
			}
			else
			{
				selectedQuest = null;
			}
		}
	}

	private void shutDownQuest(boolean shouldUpdateList)
	{
		if (selectedQuest != null)
		{
			selectedQuest.shutDown();
			if (shouldUpdateList)
			{
				updateQuestList();
				getAllItemRequirements();
			}
			if (bankTagsMain != null)
			{
				bankTagsMain.shutDown();
			}
			//SwingUtilities.invokeLater(() -> panel.removeQuest());
			selectedQuest.unsubscribe();
			selectedQuest = null;
			pluginPanel.unsubscribe();
			pluginPanel = null;
			getPluginPanel().setValue(pluginPanel);
		}
	}

	// Helpers to run in the background without UI
	public void startUpBackgroundQuest(String questHelperName)
	{
		if (!config.highlightItemsBackground())
		{
			return;
		}

		if (!(client.getGameState() == GameState.LOGGED_IN))
		{
			return;
		}

		if (backgroundHelpers.containsKey(questHelperName))
		{
			return;
		}

		if (selectedQuest != null && selectedQuest.getQuest().getName().equals(questHelperName))
		{
			return;
		}

		QuestHelper questHelper = quests.get(questHelperName);

		if (questHelper == null)
		{
			return;
		}
		clientThread.invokeLater(() -> {
			if (!questHelper.isCompleted())
			{

				questHelper.subscribe();
				questHelper.setEventListening(true);
				questHelper.startUp(config);
				backgroundHelpers.put(questHelperName, questHelper);
				if (questHelper.getCurrentStep() == null)
				{
					questHelper.shutDown();
					questHelper.unsubscribe();
					backgroundHelpers.remove(questHelperName);
				}

			}
		});
	}

	private void shutDownBackgroundQuest(QuestHelper questHelper)
	{
		if (questHelper == null)
		{
			return;
		}

		if (!backgroundHelpers.containsKey(questHelper.getQuest().getName()))
		{
			return;
		}

		if (questHelper == selectedQuest)
		{
			// Is active quest, so don't close it
			return;
		}

		questHelper.shutDown();
		questHelper.unsubscribe();
		backgroundHelpers.remove(questHelper.getQuest().getName());

	}

	private Map<String, QuestHelper> scanAndInstantiate(ClassLoader classLoader) throws IOException
	{
		Map<String, QuestHelper> scannedQuests = new HashMap<>();
		ClassPath classPath = ClassPath.from(classLoader);

		scannedQuests.putAll(instantiate(classPath, QuestHelperPlugin.QUEST_PACKAGE));

		scannedQuests.putAll(instantiate(classPath, QuestHelperPlugin.ACHIEVEMENT_PACKAGE));

		return scannedQuests;
	}

	private void getAllItemRequirements()
	{
		clientThread.invokeLater(() -> {
			Predicate<QuestHelper> pred = (questHelper) -> false;
			if (config.highlightNeededQuestItems())
			{
				pred = pred.or(QuestHelperConfig.QuestFilter.QUEST);
			}
			if (config.highlightNeededMiniquestItems())
			{
				pred = pred.or(QuestHelperConfig.QuestFilter.MINIQUEST);
			}
			if (config.highlightNeededAchievementDiaryItems())
			{
				pred = pred.or(QuestHelperConfig.QuestFilter.ACHIEVEMENT_DIARY);
			}

			List<QuestHelper> filteredQuests = quests.values()
				.stream()
				.filter(pred)
				.filter(QuestDetails::isNotCompleted)
				.sorted(config.orderListBy())
				.collect(Collectors.toList());

			clientThread.invokeLater(() -> {
				SortedMap<QuestHelperQuest, List<ItemRequirement>> newReqs = new TreeMap<>();
				SortedMap<QuestHelperQuest, List<ItemRequirement>> newRecommended = new TreeMap<>();
				filteredQuests.forEach((QuestHelper questHelper) -> {
					if (questHelper.getItemRequirements() != null)
					{
						newReqs.put(questHelper.getQuest(), questHelper.getItemRequirements());
					}
					if (questHelper.getItemRecommended() != null)
					{
						newRecommended.put(questHelper.getQuest(), questHelper.getItemRecommended());
					}
				});
				itemRequirements = newReqs;
				itemRecommended = newRecommended;

				String checkItemsName = QuestHelperQuest.CHECK_ITEMS.getName();
				if (config.highlightItemsBackground())
				{
					shutDownBackgroundQuest(backgroundHelpers.get(checkItemsName));
					startUpBackgroundQuest(checkItemsName);
				}
			});
		});
	}

	private Map<String, QuestHelper> instantiate(ClassPath classPath, String packageName)
	{
		Map<String, QuestHelper> scannedQuests = new HashMap<>();
		Map<QuestHelperQuest, Class<? extends QuestHelper>> tmpQuests = new HashMap<>();

		ImmutableSet<ClassPath.ClassInfo> classes = classPath.getTopLevelClassesRecursive(packageName);
		for (ClassPath.ClassInfo classInfo : classes)
		{
			Class<?> clazz = classInfo.load();
			QuestDescriptor questDescriptor = clazz.getAnnotation(QuestDescriptor.class);

			if (questDescriptor == null)
			{
				if (clazz.getSuperclass() == QuestHelper.class)
				{
					log.warn("Class {} is a quest helper, but has no quest descriptor",
						clazz);
				}
				continue;
			}

			if (clazz.isAssignableFrom(QuestHelper.class))
			{
				log.warn("Class {} has quest descriptor, but is not a quest helper",
					clazz);
				continue;
			}

			Class<QuestHelper> questClass = (Class<QuestHelper>) clazz;
			tmpQuests.put(questDescriptor.quest(), questClass);
		}

		for (Map.Entry<QuestHelperQuest, Class<? extends QuestHelper>> questClazz : tmpQuests.entrySet())
		{
			QuestHelper questHelper;
			try
			{
				questHelper = instantiate((Class<QuestHelper>) questClazz.getValue(), questClazz.getKey());
			}
			catch (QuestInstantiationException ex)
			{
				log.warn("Error instantiating quest helper!", ex);
				continue;
			}

			scannedQuests.put(questClazz.getKey().getName(), questHelper);
		}

		return scannedQuests;
	}

	private QuestHelper instantiate(Class<QuestHelper> clazz, QuestHelperQuest quest) throws QuestInstantiationException
	{
		QuestHelper questHelper;
		try
		{
			questHelper = clazz.newInstance();
			questHelper.setQuest(quest);
			questHelper.setConfig(config);
			questHelper.setQuestHelperPlugin(this);
		}
		catch (InstantiationException | IllegalAccessException | CreationException ex)
		{
			throw new QuestInstantiationException(ex);
		}

		log.debug("Loaded quest helper {}", clazz.getSimpleName());
		return questHelper;
	}
}
