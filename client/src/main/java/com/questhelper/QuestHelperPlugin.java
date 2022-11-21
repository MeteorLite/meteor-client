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
import com.google.common.primitives.Ints;
import com.google.common.reflect.ClassPath;
import com.google.gson.Gson;
import com.questhelper.banktab.QuestBankTab;
import com.questhelper.banktab.QuestHelperBankTagService;
import com.questhelper.overlays.*;
import com.questhelper.questhelpers.Quest;
import com.questhelper.questhelpers.QuestHelper;
import com.questhelper.steps.QuestStep;
import eventbus.events.*;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import meteor.Main;
import meteor.config.ConfigManager;
import meteor.game.ItemManager;
import meteor.game.SpriteManager;
import meteor.plugins.Plugin;
import meteor.plugins.PluginDescriptor;
import meteor.plugins.bank.BankSearch;
import meteor.rs.ClientThread;
import meteor.ui.composables.toolbar.ToolbarButton;
import meteor.ui.overlay.OverlayManager;
import net.runelite.api.*;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.util.Text;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.chat.ChatMessageManager;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

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
	private QuestHelperPluginPanel pluginPanel;
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

	private static final Zone PHOENIX_START_ZONE = new Zone(new WorldPoint(3204, 3488, 0), new WorldPoint(3221, 3501, 0));

	@Getter
	private QuestHelperBankTagService bankTagService;

	private QuestBankTab bankTagsMain;

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
	ChatMessageManager chatMessageManager = Main.INSTANCE.getChatMessageManager();

	private QuestHelperDebugOverlay questHelperDebugOverlay = new QuestHelperDebugOverlay(this);

	@Getter
	private QuestHelperConfig config = (QuestHelperConfig) javaConfiguration(QuestHelperConfig.class);

	@Getter
	private QuestHelper selectedQuest = null;

	@Setter
	private QuestHelper sidebarSelectedQuest = null;

	private QuestStep lastStep = null;

	private Map<String, QuestHelper> quests;

	SpriteManager spriteManager = SpriteManager.INSTANCE;

	@Getter
	ConfigManager configManager = ConfigManager.INSTANCE;


	public QuestBank questBank = new QuestBank(getClient(), configManager, new Gson());

	private boolean loadQuestList;

	private boolean displayNameKnown;

	private int lastActiveVar = -1;

	private ToolbarButton toolbarButton = new ToolbarButton("Quest Helper", "quest_helper.png",
			"Shows info for quest",
			Alignment.Companion.getTopCenter(), false, togglePanel());

	@Override
	public void onStart()
	{
		bankTagService = new QuestHelperBankTagService(this, questBank);
		bankTagsMain = new QuestBankTab(this);
		bankTagsMain.startUp();

		try {
			quests = scanAndInstantiate(getClass().getClassLoader());
		} catch (Exception e) {
			e.printStackTrace();
		}
		overlayManager.add(questHelperOverlay);
		overlayManager.add(questHelperWorldOverlay);
		overlayManager.add(questHelperWorldArrowOverlay);
		overlayManager.add(questHelperWorldLineOverlay);
		overlayManager.add(questHelperWidgetOverlay);

		if (getClient().getGameState() == GameState.LOGGED_IN)
		{
			loadQuestList = true;
		}

		addButton(toolbarButton);
	}

	@Override
	public void onStop()
	{
/*		eventBus.unregister(bankTagsMain);*/
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

	@Override
	public void onGameTick(GameTick event)
	{
		if (!displayNameKnown)
		{
			Player localPlayer = getClient().getLocalPlayer();
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
				QuestStep currentStep = selectedQuest.getCurrentStep().getSidePanelStep();
				if (currentStep != null && currentStep != lastStep)
				{
					lastStep = currentStep;
				}
			}
		}
		if (loadQuestList)
		{
			updateQuestList();
			loadQuestList = false;
		}

		//Required because god knows why
		if (selectedQuest != null) {
			selectedQuest.shutDown();
			selectedQuest.startUp(config);
		}
	}

	@Override
	public void onItemContainerChanged(ItemContainerChanged event)
	{
		if (event.getItemContainer() == getClient().getItemContainer(InventoryID.BANK))
		{
			questBank.updateLocalBank(event.getItemContainer().getItems());
		}
	}

	@Override
	public void onGameStateChanged(final GameStateChanged event)
	{
		final GameState state = event.getGameState();

		if (state == GameState.LOGIN_SCREEN)
		{
			questBank.saveBankToConfig();
			questBank.emptyState();
			if (selectedQuest != null && selectedQuest.getCurrentStep() != null)
			{
				shutDownQuest(true);
			}
		}

		if (state == GameState.LOGGED_IN)
		{
			loadQuestList = true;
			displayNameKnown = false;
		}
	}

	@Override
	public void onVarbitChanged(VarbitChanged event)
	{
		if (!(getClient().getGameState() == GameState.LOGGED_IN))
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

	@Override
	public void onConfigChanged(ConfigChanged event)
	{
		if (event.getGroup().equals("questhelper") && configEvents.contains(event.getKey()))
		{
			clientThread.invokeLater(this::updateQuestList);
		}
	}

	public void updateQuestList()
	{
		if (getClient().getGameState() == GameState.LOGGED_IN)
		{
			List<QuestHelper> filteredQuests = quests.values()
					.stream()
					.filter(Quest::showCompletedQuests).toList();
			Map<QuestHelperQuest, QuestState> completedQuests = quests.values()
				.stream()
				.collect(Collectors.toMap(QuestHelper::getQuest, q -> q.getState(getClient())));
		}
	}

	@Override
	public void onMenuOptionClicked(MenuOptionClicked event)
	{
		if (event.getMenuAction() != MenuAction.RUNELITE)
		{
			return;
		}

		switch (event.getMenuOption()) {
			case MENUOP_STARTHELPER, MENUOP_STARTGENERICHELPER -> {
				event.consume();
				String quest = Text.removeTags(event.getMenuTarget());
				startUpQuest(quests.get(quest));
				if (config.autoOpenSidebar()) {
					getPluginPanel().setValue(pluginPanel);
					openPluginPanel();
				}
			}
			case MENUOP_STOPHELPER, MENUOP_STOPGENERICHELPER -> {
				event.consume();
				shutDownQuest(true);
			}
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

	@Override
	public void onMenuEntryAdded(MenuEntryAdded event)
	{
		int widgetIndex = event.getParam0();
		int widgetID = event.getParam1();
		MenuEntry[] menuEntries = getClient().getMenuEntries();
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

	@Override
	public void onChatMessage(ChatMessage chatMessage)
	{
		if (config.autoStartQuests() && chatMessage.getType() == ChatMessageType.GAMEMESSAGE)
		{
			if (selectedQuest == null && chatMessage.getMessage().contains("You've started a new quest"))
			{
				String questName = chatMessage.getMessage().substring(chatMessage.getMessage().indexOf(">") + 1);
				questName = questName.substring(0, questName.indexOf("<"));

				// Prompt for starting Shield of Arrav is the same for both routes. Display actual route started
				if (questName.equals("Shield of Arrav"))
				{
					Player player = getClient().getLocalPlayer();
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

	private MenuEntry[] addNewEntry(MenuEntry[] menuEntries, String newEntry, String target, int widgetIndex, int widgetID)
	{
		menuEntries = Arrays.copyOf(menuEntries, menuEntries.length + 1);

		getClient().createMenuEntry(menuEntries.length - 1)
			.setOption(newEntry)
			.setTarget(target)
			.setType(MenuAction.RUNELITE)
			.setParam0(widgetIndex)
			.setParam1(widgetID);

		return menuEntries;
	}

	public void startUpQuest(QuestHelper questHelper)
	{
		if (getClient().getGameState() != GameState.LOGGED_IN)
		{
			return;
		}

		if (selectedQuest != questHelper)
			shutDownQuest(true);

		if (!questHelper.isCompleted())
		{
			selectedQuest = questHelper;
			selectedQuest.subscribe();
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
		}
		else
		{
			selectedQuest = null;
		}
	}

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

	public void shutDownQuestFromSidebar()
	{
		if (selectedQuest != null)
		{
			selectedQuest.shutDown();
			bankTagsMain.shutDown();
			selectedQuest.unsubscribe();
			selectedQuest = null;
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
			}
			if (bankTagsMain != null)
			{
				bankTagsMain.shutDown();
			}
			selectedQuest.unsubscribe();
			selectedQuest = null;
			pluginPanel.unsubscribe();
			pluginPanel = null;
			getPluginPanel().setValue(pluginPanel);
		}
	}

	private Map<String, QuestHelper> scanAndInstantiate(ClassLoader classLoader) throws IOException
	{

		Map<String, QuestHelper> scannedQuests = new HashMap<>();
		ClassPath classPath = ClassPath.from(classLoader);

		scannedQuests.putAll(instantiate(classPath, QuestHelperPlugin.QUEST_PACKAGE));
		scannedQuests.putAll(instantiate(classPath, QuestHelperPlugin.ACHIEVEMENT_PACKAGE));

		return scannedQuests;
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
		}
		catch (Exception ex)
		{
			throw new QuestInstantiationException(ex);
		}

		log.debug("Loaded quest helper {}", clazz.getSimpleName());
		return questHelper;
	}
}
