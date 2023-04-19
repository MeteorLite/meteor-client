/*
 * Copyright (c) 2016-2017, Adam <Adam@sigterm.info>
 * Copyright (c) 2020, ThatGamerBlue <thatgamerblue@gmail.com>
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

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.primitives.Doubles;
import dev.hoot.api.events.AutomatedMenu;
import dev.hoot.api.events.ResumePauseSent;
import dev.hoot.api.widgets.DialogOption;

import java.math.BigInteger;
import java.time.Instant;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import eventbus.Events;
import eventbus.events.*;
import meteor.Logger;
import net.runelite.api.*;

import static net.runelite.api.MenuAction.CANCEL;
import static net.runelite.api.MenuAction.PLAYER_EIGTH_OPTION;
import static net.runelite.api.MenuAction.PLAYER_FIFTH_OPTION;
import static net.runelite.api.MenuAction.PLAYER_FIRST_OPTION;
import static net.runelite.api.MenuAction.PLAYER_FOURTH_OPTION;
import static net.runelite.api.MenuAction.PLAYER_SECOND_OPTION;
import static net.runelite.api.MenuAction.PLAYER_SEVENTH_OPTION;
import static net.runelite.api.MenuAction.PLAYER_SIXTH_OPTION;
import static net.runelite.api.MenuAction.PLAYER_THIRD_OPTION;
import static net.runelite.api.MenuAction.UNKNOWN;
import static net.runelite.api.Perspective.LOCAL_TILE_SIZE;

import net.runelite.api.Deque;
import net.runelite.api.clan.ClanChannel;
import net.runelite.api.clan.ClanRank;
import net.runelite.api.clan.ClanSettings;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.MenuOpened;
import net.runelite.api.hooks.Callbacks;
import net.runelite.api.hooks.DrawCallbacks;
import net.runelite.api.mixins.Copy;
import net.runelite.api.mixins.FieldHook;
import net.runelite.api.mixins.Inject;
import net.runelite.api.mixins.MethodHook;
import net.runelite.api.mixins.Mixin;
import net.runelite.api.mixins.Replace;
import net.runelite.api.mixins.Shadow;
import net.runelite.api.overlay.OverlayIndex;
import net.runelite.api.vars.AccountType;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetConfig;
import net.runelite.api.widgets.WidgetID;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.api.widgets.WidgetItem;
import net.runelite.api.widgets.WidgetType;

import static mixins.CameraMixin.NEW_PITCH_MAX;
import static mixins.CameraMixin.STANDARD_PITCH_MAX;
import static mixins.CameraMixin.STANDARD_PITCH_MIN;

import net.runelite.rs.api.*;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

@Mixin(RSClient.class)
public abstract class RSClientMixin implements RSClient {
    @Shadow("client")
    private static RSClient client;

    @Inject
    private static RSClient instance;

    @Inject
    public static Logger rl$logger = new Logger("");

    @Inject
    @javax.inject.Inject
    private Callbacks callbacks;

    @Inject
    @Override
    public void setCallbacks(Callbacks callbacks) {
        this.callbacks = callbacks;
    }

    @Inject
    private DrawCallbacks drawCallbacks;

    @Inject
    private static int tickCount;

    @Inject
    private static RSPlayer[] oldPlayers = new RSPlayer[2048];

    @Inject
    private static int itemPressedDurationBuffer;

    @Inject
    private static int inventoryDragDelay;

    @Inject
    private static int oldMenuEntryCount;

    @Inject
    private static RSTileItem lastItemDespawn;

    @Inject
    private static boolean invertPitch;

    @Inject
    private static boolean invertYaw;

    @Inject
    private boolean gpu;

    @Inject
    private static boolean oldIsResized;

    @Inject
    static int skyboxColor;

    @Inject
    private final Cache<Integer, RSEnumComposition> enumCache = CacheBuilder.newBuilder().maximumSize(64).build();

    @Inject
    private static boolean printMenuActions;

    @Inject
    private static boolean hideDisconnect = false;

    @Inject
    private static boolean hideFriendAttackOptions = false;

    @Inject
    private static boolean hideClanmateAttackOptions = false;

    @Inject
    private static boolean hideFriendCastOptions = false;

    @Inject
    private static boolean hideClanmateCastOptions = false;

    @Inject
    private static boolean allWidgetsAreOpTargetable = false;

    @Inject
    public static int viewportColor;

    @Inject
    private static Set<String> unhiddenCasts = new HashSet<String>();

    @Inject
    private boolean isMirrored = false;

    @Inject
    private Integer comparingAppearance = 0;

    @Inject
    private static boolean hdMinimapEnabled;

    @Inject
    public static boolean unlockedFps;

    @Inject
    public static double tmpCamAngleY;

    @Inject
    public static double tmpCamAngleX;

    @Inject
    public long lastNanoTime;

    @Inject
    public long delayNanoTime;

    @Inject
    public RSEvictingDualNodeHashTable tmpModelDataCache = newEvictingDualNodeHashTable(16);

    @Inject
    private List<String> outdatedScripts = new ArrayList<>();

    @Inject
    private static ArrayList<WidgetItem> widgetItems = new ArrayList<>();

    @Inject
    private static ArrayList<Widget> hiddenWidgets = new ArrayList<>();

    @Inject
    private static final RSRuneLiteMenuEntry[] rl$menuEntries = new RSRuneLiteMenuEntry[500];

    @Inject
    private static int tmpMenuOptionsCount;

    @Inject
    private static final Map<Integer, byte[]> customClientScripts = new HashMap<>();

    @Inject
    @Override
    public int getTmpMenuOptionsCount() {
        return tmpMenuOptionsCount;
    }

    @Inject
    @Override
    public void setTmpMenuOptionsCount(int count) {
        tmpMenuOptionsCount = count;
    }

    @Inject
    @Override
    public void setPrintMenuActions(boolean yes) {
        printMenuActions = yes;
    }

    @Inject
    @Override
    public void setHideDisconnect(boolean dontShow) {
        hideDisconnect = dontShow;
    }

    @Inject
    @Override
    public void setHideFriendAttackOptions(boolean yes) {
        hideFriendAttackOptions = yes;
    }

    @Inject
    @Override
    public void setHideFriendCastOptions(boolean yes) {
        hideFriendCastOptions = yes;
    }

    @Inject
    @Override
    public void setHideClanmateAttackOptions(boolean yes) {
        hideClanmateAttackOptions = yes;
    }

    @Inject
    @Override
    public void setHideClanmateCastOptions(boolean yes) {
        hideClanmateCastOptions = yes;
    }

    @Inject
    @Override
    public void setAllWidgetsAreOpTargetable(boolean yes) {
        allWidgetsAreOpTargetable = yes;
    }

    @Inject
    @Override
    public void setUnhiddenCasts(Set<String> casts) {
        unhiddenCasts = casts;
    }

    @Inject
    public RSClientMixin() {
    }

    @Inject
    @Override
    public String getBuildID() {
        return "OpenOSRS";
    }

    @Inject
    @Override
    public Callbacks getCallbacks() {
        return callbacks;
    }

    @Inject
    @Override
    public DrawCallbacks getDrawCallbacks() {
        return drawCallbacks;
    }

    @Inject
    @Override
    public void setDrawCallbacks(DrawCallbacks drawCallbacks) {
        this.drawCallbacks = drawCallbacks;
    }

    @Inject
    @Override
    public Logger getLogger() {
        return rl$logger;
    }

    @Inject
    @Override
    public void setInventoryDragDelay(int delay) {
        inventoryDragDelay = delay;
    }

    @Inject
    @Override
    public boolean isHdMinimapEnabled() {
        return hdMinimapEnabled;
    }

    @Inject
    @Override
    public void setHdMinimapEnabled(boolean enabled) {
        hdMinimapEnabled = enabled;
    }

    @Inject
    @Override
    public AccountType getAccountType() {
        int varbit = getVarbitValue(Varbits.ACCOUNT_TYPE);

        switch (varbit) {
            case 1:
                return AccountType.IRONMAN;
            case 2:
                return AccountType.ULTIMATE_IRONMAN;
            case 3:
                return AccountType.HARDCORE_IRONMAN;
            case 4:
                return AccountType.GROUP_IRONMAN;
            case 5:
                return AccountType.HARDCORE_GROUP_IRONMAN;
        }

        return AccountType.NORMAL;
    }

    @Inject
    @Override
    public Tile getSelectedSceneTile() {
        int tileX = getSelectedSceneTileX();
        int tileY = getSelectedSceneTileY();

        if (tileX == -1 || tileY == -1) {
            return null;
        }

        return getScene().getTiles()[getPlane()][tileX][tileY];
    }

    @Inject
    @Override
    public List<Player> getPlayers() {
        int validPlayerIndexes = getPlayerIndexesCount();
        int[] playerIndexes = getPlayerIndices();
        Player[] cachedPlayers = getCachedPlayers();
        List<Player> players = new ArrayList<Player>(validPlayerIndexes);

        for (int i = 0; i < validPlayerIndexes; ++i) {
            players.add(cachedPlayers[playerIndexes[i]]);
        }

        return players;
    }

    @Inject
    @Override
    public List<NPC> getNpcs() {
        int validNpcIndexes = getNpcIndexesCount();
        int[] npcIndexes = getNpcIndices();
        NPC[] cachedNpcs = getCachedNPCs();
        List<NPC> npcs = new ArrayList<NPC>(validNpcIndexes);

        for (int i = 0; i < validNpcIndexes; ++i) {
            npcs.add(cachedNpcs[npcIndexes[i]]);
        }

        return npcs;
    }

    @Inject
    @Override
    public int getBoostedSkillLevel(Skill skill) {
        int[] boostedLevels = getBoostedSkillLevels();
        return boostedLevels[skill.ordinal()];
    }

    @Inject
    @Override
    public int getRealSkillLevel(Skill skill) {
        int[] realLevels = getRealSkillLevels();
        return realLevels[skill.ordinal()];
    }

    @Inject
    @Override
    public int getTotalLevel() {
        int totalLevel = 0;

        int[] realLevels = client.getRealSkillLevels();
        int lastSkillIdx = Skill.CONSTRUCTION.ordinal();

        for (int i = 0; i < realLevels.length; i++) {
            if (i <= lastSkillIdx) {
                totalLevel += realLevels[i];
            }
        }

        return totalLevel;
    }

    @Inject
    public MessageNode addChatMessage(ChatMessageType type, String name, String message, String sender,
                                      boolean postEvent) {
        assert this.isClientThread() : "addChatMessage must be called on client thread";

        ChatMessageType tmpType = type;
        String tmpMessage = message;

        if (type == ChatMessageType.CLAN_GIM_CHAT) {
            tmpType = ChatMessageType.CLAN_CHAT;
            tmpMessage = "|" + message;
        } else if (type == ChatMessageType.CLAN_GIM_MESSAGE) {
            tmpType = ChatMessageType.CLAN_MESSAGE;
            tmpMessage = "|" + message;
        }

        copy$addChatMessage(tmpType.getType(), name, tmpMessage, sender);

        Logger logger = client.getLogger();

        // Get the message node which was added
        @SuppressWarnings("unchecked") Map<Integer, RSChatChannel> chatLineMap = client.getChatLineMap();
        RSChatChannel chatLineBuffer = chatLineMap.get(type.getType());
        MessageNode messageNode = chatLineBuffer.getLines()[0];

        if (postEvent) {
            final ChatMessage chatMessage = new ChatMessage(messageNode, type, name, message, sender,
                    messageNode.getTimestamp());
            client.getCallbacks().post(Events.CHAT_MESSAGE, chatMessage);
        }

        return messageNode;
    }

    @Copy("doCheat")
    @Replace("doCheat")
    public static void rl$doCheat(String cheat) {
        CheatEntered event = new CheatEntered(cheat);
        client.getCallbacks().post(Events.CHEAT_ENTERED, event);
        if (!event.getConsumed()) rl$doCheat(cheat);
    }

    @Inject
    @Override
    public MessageNode addChatMessage(ChatMessageType type, String name, String message, String sender) {
        return addChatMessage(type, name, message, sender, true);
    }

    @Inject
    @Override
    public GameState getGameState() {
        return GameState.of(getRSGameState());
    }

    @Inject
    @Override
    public void setGameState(int state) {
        assert this.isClientThread() : "setGameState must be called on client thread";
        client.setRSGameState(state);
    }

    @Inject
    @Override
    public void setGameState(GameState gameState) {
        assert this.isClientThread() : "setGameState must be called on client thread";
        setGameState(gameState.getState());
    }

    @Inject
    @Override
    public Point getMouseCanvasPosition() {
        return new Point(getMouseX(), getMouseY());
    }

    @Inject
    @Override
    public Widget[] getWidgetRoots() {
        int topGroup = getTopLevelInterfaceId();
        if (topGroup == -1) {
            return new Widget[]{};
        }
        List<Widget> widgets = new ArrayList<Widget>();
        for (RSWidget widget : getWidgets()[topGroup]) {
            if (widget != null && widget.getRSParentId() == -1) {
                widgets.add(widget);
            }
        }
        return widgets.toArray(new Widget[widgets.size()]);
    }

    @Inject
    @Override
    public Widget getWidget(WidgetInfo widget) {
        int groupId = widget.getGroupId();
        int childId = widget.getChildId();

        return getWidget(groupId, childId);
    }

    @Inject
    @Override
    public Widget getWidget(int id) {
        return getWidget(WidgetInfo.TO_GROUP(id), WidgetInfo.TO_CHILD(id));
    }

    @Inject
    @Override
    public RSWidget[] getGroup(int groupId) {
        RSWidget[][] widgets = getWidgets();

        if (widgets == null || groupId < 0 || groupId >= widgets.length || widgets[groupId] == null) {
            return null;
        }

        return widgets[groupId];
    }

    @Inject
    @Override
    public Widget getWidget(int groupId, int childId) {
        RSWidget[][] widgets = getWidgets();

        if (widgets == null || widgets.length <= groupId) {
            return null;
        }

        RSWidget[] childWidgets = widgets[groupId];
        if (childWidgets == null || childWidgets.length <= childId) {
            return null;
        }

        return childWidgets[childId];
    }

    @Inject
    @Override
    public int getVar(VarPlayer varPlayer) {
        int[] varps = getVarps();
        return varps[varPlayer.getId()];
    }

    @Inject
    @Override
    public int getVarpValue(int[] varps, int varpId) {
        return varps[varpId];
    }

    @Inject
    @Override
    public int getVarpValue(int varpId) {
        return getVarpValue(getVarps(), varpId);
    }

    @Inject
    @Override
    public int getVarpValue(VarPlayer varp) {
        return getVarpValue(varp.getId());
    }

    @Inject
    @Override
    public boolean isPrayerActive(Prayer prayer) {
        return getVarbitValue(prayer.getVarbit()) == 1;
    }

    /**
     * Returns the local player's current experience in the specified
     * {@link Skill}.
     *
     * @param skill the {@link Skill} to retrieve the experience for
     * @return the local player's current experience in the specified
     * {@link Skill}, or -1 if the {@link Skill} isn't valid
     */
    @Inject
    @Override
    public int getSkillExperience(Skill skill) {
        int[] experiences = getSkillExperiences();

        if (skill == Skill.OVERALL) {
            return (int) getOverallExperience();
        }

        int idx = skill.ordinal();

        // I'm not certain exactly how needed this is, but if the Skill enum is updated in the future
        // to hold something else that's not reported it'll save us from an ArrayIndexOutOfBoundsException.
        if (idx >= experiences.length) {
            return -1;
        }

        return experiences[idx];
    }

    @Inject
    @Override
    public long getOverallExperience() {
        int[] experiences = getSkillExperiences();

        long totalExperience = 0L;

        for (int experience : experiences) {
            totalExperience += experience;
        }

        return totalExperience;
    }

    @Inject
    @Override
    public void refreshChat() {
        setChatCycle(getCycleCntr());
    }

    @Inject
    public static RSRuneLiteMenuEntry newBareRuneliteMenuEntry() {
        throw new NotImplementedException();
    }

    @Inject
    public static RSRuneLiteMenuEntry newRuneliteMenuEntry(int idx) {
        throw new NotImplementedException();
    }

    @Inject
    @Override
    public MenuEntry createMenuEntry(String option, String target, int identifier, int opcode, int param1, int param2,
                                     int itemId, boolean forceLeftClick) {
        RSRuneLiteMenuEntry menuEntry = newBareRuneliteMenuEntry();

        menuEntry.setOption(option);
        menuEntry.setTarget(target);
        menuEntry.setIdentifier(identifier);
        menuEntry.setType(MenuAction.of(opcode));
        menuEntry.setParam0(param1);
        menuEntry.setParam1(param2);
        menuEntry.setConsumer(null);
        menuEntry.setForceLeftClick(forceLeftClick);
        menuEntry.setItemId(itemId);

        return menuEntry;
    }

    @Inject
    @Override
    public MenuEntry createMenuEntry(int idx)
    {
        if (client.getMenuOptionCount() >= 500)
        {
            throw new IllegalStateException();
        }
        else
        {
            if (idx < 0)
            {
                idx = client.getMenuOptionCount() + idx + 1;
                if (idx < 0)
                {
                    throw new IllegalArgumentException();
                }
            }

            RSRuneLiteMenuEntry menuEntry;
            if (idx < client.getMenuOptionCount())
            {
                RSRuneLiteMenuEntry tmpEntry = rl$menuEntries[client.getMenuOptionCount()];
                if (tmpEntry == null)
                {
                    tmpEntry = rl$menuEntries[client.getMenuOptionCount()] = newRuneliteMenuEntry(client.getMenuOptionCount());
                }

                for (int i = client.getMenuOptionCount(); i > idx; rl$menuEntries[i].setIdx(i--))
                {
                    client.getMenuOptions()[i] = client.getMenuOptions()[i - 1];
                    client.getMenuTargets()[i] = client.getMenuTargets()[i - 1];
                    client.getMenuIdentifiers()[i] = client.getMenuIdentifiers()[i - 1];
                    client.getMenuOpcodes()[i] = client.getMenuOpcodes()[i - 1];
                    client.getMenuArguments1()[i] = client.getMenuArguments1()[i - 1];
                    client.getMenuArguments2()[i] = client.getMenuArguments2()[i - 1];
                    client.getMenuItemIds()[i] = client.getMenuItemIds()[i - 1];
                    client.getMenuForceLeftClick()[i] = client.getMenuForceLeftClick()[i - 1];

                    rl$menuEntries[i] = rl$menuEntries[i - 1];
                }

                client.setMenuOptionCount(client.getMenuOptionCount() + 1);
                tmpMenuOptionsCount = client.getMenuOptionCount();

                menuEntry = tmpEntry;
                rl$menuEntries[idx] = tmpEntry;

                tmpEntry.setIdx(idx);
            }
            else
            {
                if (idx != client.getMenuOptionCount())
                {
                    throw new IllegalArgumentException();
                }

                menuEntry = rl$menuEntries[client.getMenuOptionCount()];

                if (menuEntry == null)
                {
                    menuEntry = rl$menuEntries[client.getMenuOptionCount()] = newRuneliteMenuEntry(client.getMenuOptionCount());
                }

                client.setMenuOptionCount(client.getMenuOptionCount() + 1);
                tmpMenuOptionsCount = client.getMenuOptionCount();
            }

            menuEntry.setOption("");
            menuEntry.setTarget("");
            menuEntry.setIdentifier(0);
            menuEntry.setType(MenuAction.RUNELITE);
            menuEntry.setParam0(0);
            menuEntry.setParam1(0);
            menuEntry.setItemId(-1);
            menuEntry.setConsumer(null);

            return menuEntry;
        }
    }

    @Inject
    @Override
    public MenuEntry[] getMenuEntries() {
        RSRuneLiteMenuEntry[] menuEntries = Arrays.copyOf(rl$menuEntries, client.getMenuOptionCount());

        for (RSRuneLiteMenuEntry menuEntry : menuEntries) {
            if (menuEntry.getOption() == null) {
                menuEntry.setOption("null");
            }

            if (menuEntry.getTarget() == null) {
                menuEntry.setTarget("null");
            }
        }

        return menuEntries;
    }

    @Inject
    @Override
    public void setMenuEntries(MenuEntry[] menuEntries) {
        boolean var2 = false;

        if (client.getTempMenuAction() != null && client.getMenuOptionCount() > 0) {
            var2 = client.getTempMenuAction()
                    .getParam0() == client.getMenuArguments1()[client.getMenuOptionCount() - 1] && client.getTempMenuAction()
                    .getParam1() == client.getMenuArguments2()[client.getMenuOptionCount() - 1] && client.getTempMenuAction()
                    .getOption()
                    .equals(client.getMenuOptions()[client.getMenuOptionCount() - 1]) && client.getTempMenuAction()
                    .getIdentifier() == client.getMenuIdentifiers()[client.getMenuOptionCount() - 1] && client.getTempMenuAction()
                    .getOpcode() == client.getMenuOpcodes()[client.getMenuOptionCount() - 1] && client.getTempMenuAction()
                    .getItemId() == client.getMenuItemIds()[client.getMenuOptionCount() - 1];
        }

        for (int i = 0; i < menuEntries.length; ++i) {
            RSRuneLiteMenuEntry menuEntry = (RSRuneLiteMenuEntry) menuEntries[i];
            if (menuEntry.getIdx() != i) {
                sortMenuEntries(menuEntry.getIdx(), i);
            }
        }

        client.setMenuOptionCount(menuEntries.length);
        tmpMenuOptionsCount = menuEntries.length;

        if (var2 && client.getMenuOptionCount() > 0) {
            client.getTempMenuAction().setParam0(client.getMenuArguments1()[client.getMenuOptionCount() - 1]);
            client.getTempMenuAction().setParam1(client.getMenuArguments2()[client.getMenuOptionCount() - 1]);
            client.getTempMenuAction().setOption(client.getMenuOptions()[client.getMenuOptionCount() - 1]);
            client.getTempMenuAction().setIdentifier(client.getMenuIdentifiers()[client.getMenuOptionCount() - 1]);
            client.getTempMenuAction().setOpcode(client.getMenuOpcodes()[client.getMenuOptionCount() - 1]);
            client.getTempMenuAction().setItemId(client.getMenuItemIds()[client.getMenuOptionCount() - 1]);
        }
    }

    @Inject
    public static void sortMenuEntries(int left, int right) {
        String menuOption = client.getMenuOptions()[left];
        client.getMenuOptions()[left] = client.getMenuOptions()[right];
        client.getMenuOptions()[right] = menuOption;

        String menuTarget = client.getMenuTargets()[left];
        client.getMenuTargets()[left] = client.getMenuTargets()[right];
        client.getMenuTargets()[right] = menuTarget;

        int menuIdentifier = client.getMenuIdentifiers()[left];
        client.getMenuIdentifiers()[left] = client.getMenuIdentifiers()[right];
        client.getMenuIdentifiers()[right] = menuIdentifier;

        int menuOpcode = client.getMenuOpcodes()[left];
        client.getMenuOpcodes()[left] = client.getMenuOpcodes()[right];
        client.getMenuOpcodes()[right] = menuOpcode;

        int menuArguments1 = client.getMenuArguments1()[left];
        client.getMenuArguments1()[left] = client.getMenuArguments1()[right];
        client.getMenuArguments1()[right] = menuArguments1;

        int menuArgument2 = client.getMenuArguments2()[left];
        client.getMenuArguments2()[left] = client.getMenuArguments2()[right];
        client.getMenuArguments2()[right] = menuArgument2;

        boolean menuForceLeftClick = client.getMenuForceLeftClick()[left];
        client.getMenuForceLeftClick()[left] = client.getMenuForceLeftClick()[right];
        client.getMenuForceLeftClick()[right] = menuForceLeftClick;

        RSRuneLiteMenuEntry var2 = rl$menuEntries[left];
        rl$menuEntries[left] = rl$menuEntries[right];
        rl$menuEntries[right] = var2;

        rl$menuEntries[left].setIdx(left);
        rl$menuEntries[right].setIdx(right);
    }

    @Inject
    public static void swapMenuEntries(int var0) {
        if (var0 == -1)
            return;

        if (var0 > 500) {
            rl$logger.error("Invalid menu idx swap");
            return;
        }

        RSRuneLiteMenuEntry var1 = rl$menuEntries[var0];
        RSRuneLiteMenuEntry var2 = rl$menuEntries[var0 + 1];

        if (var1 == null || var2 == null)
            return;

        rl$menuEntries[var0] = var2;
        rl$menuEntries[var0 + 1] = var1;

        var1.setIdx(var0 + 1);
        var2.setIdx(var0);
    }

    @FieldHook("menuOptionsCount")
    @Inject
    public static void onMenuOptionsChanged(int idx)
    {
        int tmpOptionsCount = tmpMenuOptionsCount;
        int optionCount = client.getMenuOptionCount();

        tmpMenuOptionsCount = optionCount;

        if (optionCount < tmpOptionsCount)
        {
            for (int i = optionCount; i < tmpOptionsCount; ++i)
            {
                RSRuneLiteMenuEntry entry = rl$menuEntries[i];
                if (entry == null)
                {
                    rl$logger.error("about to crash: opcnt:{} tmpopcnt:{} i:{}", optionCount, tmpOptionsCount, i);
                }
                rl$menuEntries[i].setConsumer(null);
            }
        }
        else if (optionCount == tmpOptionsCount + 1)
        {
            if (client.getMenuOptions()[tmpOptionsCount] == null)
            {
                client.getMenuOptions()[tmpOptionsCount] = "null";
            }

            if (client.getMenuTargets()[tmpOptionsCount] == null)
            {
                client.getMenuTargets()[tmpOptionsCount] = "null";
            }

            if (rl$menuEntries[tmpOptionsCount] == null)
            {
                rl$menuEntries[tmpOptionsCount] = newRuneliteMenuEntry(tmpOptionsCount);
            }
            else
            {
                rl$menuEntries[tmpOptionsCount].setConsumer(null);
            }

            MenuEntryAdded menuEntryAdded = new MenuEntryAdded(
                    rl$menuEntries[tmpOptionsCount]
            );

            client.getCallbacks().post(Events.MENU_ENTRY_ADDED, menuEntryAdded);

            if (menuEntryAdded.getModified() && client.getMenuOptionCount() == optionCount)
            {
                client.getMenuOptions()[tmpOptionsCount] = menuEntryAdded.getOption();
                client.getMenuTargets()[tmpOptionsCount] = menuEntryAdded.getTarget();
                client.getMenuIdentifiers()[tmpOptionsCount] = menuEntryAdded.getIdentifier();
                client.getMenuOpcodes()[tmpOptionsCount] = menuEntryAdded.getOpcode();
                client.getMenuArguments1()[tmpOptionsCount] = menuEntryAdded.getParam0();
                client.getMenuArguments2()[tmpOptionsCount] = menuEntryAdded.getParam1();
                client.getMenuForceLeftClick()[tmpOptionsCount] = menuEntryAdded.getForceLeftClick();
                client.getMenuItemIds()[tmpOptionsCount] = menuEntryAdded.getItemId();
            }
        }
    }

    @Inject
    @Override
    public Projectile createProjectile(int id, int plane, int startX, int startY, int startZ, int startCycle,
                                       int endCycle, int slope, int startHeight, int endHeight, Actor target,
                                       int targetX, int targetY) {
        int targetIndex = 0;
        if (target instanceof NPC) {
            targetIndex = ((NPC) target).getIndex() + 1;
        } else if (target instanceof Player) {
            targetIndex = -(((Player) target).getPlayerId() + 1);
        }

        RSProjectile projectile = client.newProjectile(id, plane, startX, startY, startZ, startCycle, endCycle, slope,
                startHeight, targetIndex, endHeight);
        projectile.setDestination$api(targetX, targetY,
                Perspective.getTileHeight(client, new LocalPoint(targetX, targetY), client.getPlane()),
                startCycle + client.getGameCycle());

        return projectile;
    }

    @Inject
    @Override
    public Deque<Projectile> getProjectiles() {
        return this.getProjectilesDeque();
    }

    @Inject
    @Override
    public Deque<GraphicsObject> getGraphicsObjects() {
        return this.getGraphicsObjectDeque();
    }

    @Inject
    @Override
    public void setModIcons(IndexedSprite[] modIcons) {
        setRSModIcons((RSIndexedSprite[]) modIcons);
    }

    @Inject
    @Override
    @Nullable
    public LocalPoint getLocalDestinationLocation() {
        int sceneX = getDestinationX();
        int sceneY = getDestinationY();
        if (sceneX != 0 && sceneY != 0) {
            return LocalPoint.fromScene(sceneX, sceneY);
        }
        return null;
    }

    @Inject
    @Override
    public void changeMemoryMode(boolean lowMemory) {
        setLowMemory(lowMemory);
        setSceneLowMemory(lowMemory);
        setAudioHighMemory(true);
        setObjectDefinitionLowDetail(lowMemory);
        if (getGameState() == GameState.LOGGED_IN) {
            setGameState(GameState.LOADING);
        }
    }

    @Inject
    @Override
    public RSItemContainer getItemContainer(InventoryID inventory) {
        RSNodeHashTable itemContainers = getItemContainers();
        return (RSItemContainer) itemContainers.get(inventory.getId());
    }

    @Inject
    @Override
    public RSItemContainer getItemContainer(int id) {
        RSNodeHashTable itemContainers = getItemContainers();

        for (Object itemContainer : itemContainers) {
            RSItemContainer container = ((RSItemContainer) itemContainer);

            if (((RSItemContainer) itemContainer).getId() == id) {
                return container;
            }
        }

        return null;
    }

    @Inject
    @Override
    public boolean isFriended(String name, boolean mustBeLoggedIn) {
        RSUsername rsName = createName(name, getLoginType());
        return getFriendManager().isFriended(rsName, mustBeLoggedIn);
    }

    @Inject
    @Override
    public FriendContainer getFriendContainer() {
        return getFriendManager().getFriendContainer();
    }

    @Inject
    @Override
    public NameableContainer<Ignore> getIgnoreContainer() {
        return getFriendManager().getIgnoreContainer();
    }

    @FieldHook("isDraggingWidget")
    @Inject
    public static void draggingWidgetChanged(int idx) {
        DraggingWidgetChanged draggingWidgetChanged = new DraggingWidgetChanged(client.isDraggingWidget());
        client.getCallbacks().post(Events.DRAGGING_WIDGET_CHANGED, draggingWidgetChanged);
    }

    @Inject
    public RSSpritePixels createItemSprite(int itemId, int quantity, int border, int shadowColor, int stackable,
                                           boolean noted) {
        assert isClientThread() : "createItemSprite must be called on client thread";
        return createRSItemSprite(itemId, quantity, border, shadowColor, stackable, noted);
    }


    @Inject
    @Override
    public SpritePixels createItemSprite(int itemId, int quantity, int border, int shadowColor, int stackable,
                                         boolean noted, int scale) {
        assert isClientThread() : "createItemSprite must be called on client thread";

        int zoom = get3dZoom$api();
        set3dZoom(scale);
        try {
            return createItemSprite(itemId, quantity, border, shadowColor, stackable, noted);
        } finally {
            set3dZoom(zoom);
        }
    }

    @Copy("runWidgetOnLoadListener")
    @Replace("runWidgetOnLoadListener")
    @SuppressWarnings("InfiniteRecursion")
    public static void copy$runWidgetOnLoadListener(int groupId) {
        copy$runWidgetOnLoadListener(groupId);

        RSWidget[][] widgets = client.getWidgets();
        boolean loaded = widgets != null && widgets[groupId] != null;

        if (loaded) {
            WidgetLoaded event = new WidgetLoaded(groupId);
            client.getCallbacks().post(Events.WIDGET_LOADED, event);
        }
    }

/*    @FieldHook("itemDragDuration")
    @Inject
    public static void itemPressedDurationChanged(int idx) {
        if (client.getItemPressedDuration() > 0) {
            itemPressedDurationBuffer++;
            if (itemPressedDurationBuffer >= inventoryDragDelay) {
                client.setItemPressedDuration(itemPressedDurationBuffer);
            } else {
                client.setItemPressedDuration(0);
            }
        } else {
            itemPressedDurationBuffer = 0;
        }
    }*/

    @FieldHook("changedSkills")
    @Inject
    public static void boostedSkillLevelsChanged(int idx) {
        if (idx == -1) {
            return;
        }

        int changedSkillIdx = idx - 1 & 31;
        int skillIdx = client.getChangedSkillLevels()[changedSkillIdx];
        Skill[] skills = Skill.values();
        if (skillIdx >= 0 && skillIdx < skills.length - 1) {
            StatChanged statChanged = new StatChanged(skills[skillIdx], client.getSkillExperiences()[skillIdx],
                    client.getRealSkillLevels()[skillIdx], client.getBoostedSkillLevels()[skillIdx]);
            client.getCallbacks().post(Events.STAT_CHANGED, statChanged);
        }
    }

    @FieldHook("playerMenuActions")
    @Inject
    public static void playerOptionsChanged(int idx) {
        // Reset the menu opcode
        MenuAction[] playerActions = {PLAYER_FIRST_OPTION, PLAYER_SECOND_OPTION, PLAYER_THIRD_OPTION, PLAYER_FOURTH_OPTION, PLAYER_FIFTH_OPTION, PLAYER_SIXTH_OPTION, PLAYER_SEVENTH_OPTION, PLAYER_EIGTH_OPTION};
        if (idx >= 0 && idx < playerActions.length) {
            MenuAction playerAction = playerActions[idx];
            client.getPlayerMenuTypes()[idx] = playerAction.getId();
        }

        PlayerMenuOptionsChanged optionsChanged = new PlayerMenuOptionsChanged(idx, client.getPlayerOptions()[idx],
                !client.getPlayerOptionsPriorities()[idx]);
        client.getCallbacks().post(Events.PLAYER_MENU_OPTIONS_CHANGED, optionsChanged);
    }

    @Inject
    private static GameState lastState;

    @FieldHook("gameState")
    @Inject
    public static void gameStateChanged(int idx) {
        GameState gameState = client.getGameState();
        if (lastState == gameState) {
            return;
        }
        GameStateChanged gameStateChange = new GameStateChanged(gameState, lastState);
        client.getCallbacks().post(Events.GAME_STATE_CHANGED, gameStateChange);

        if (lastState != null) {
            lastState = gameState;
        }

        if (gameState == GameState.LOGGED_IN) {
            if (client.getLocalPlayer() == null) {
                return;
            }

            lastState = gameState;


            int plane = client.getPlane();
            RSScene scene = client.getScene();
            RSTile[][][] tiles = scene.getTiles();
            RSNodeDeque[][][] allItemDeque = client.getGroundItemDeque();
            RSNodeDeque[][] planeItems = allItemDeque[plane];

            for (int x = 0; x < 104; x++) {
                for (int y = 0; y < 104; y++) {
                    RSNodeDeque itemDeque = planeItems[x][y];
                    if (itemDeque != null) {
                        RSTile tile = tiles[plane][x][y];
                        RSNode head = itemDeque.getSentinel();

                        for (RSNode current = head.getNext(); current != head; current = current.getNext()) {
                            RSTileItem item = (RSTileItem) current;
                            item.setX(x);
                            item.setY(y);
                            ItemSpawned event = new ItemSpawned(tile, item);
                            client.getCallbacks().post(Events.ITEM_SPAWNED, event);
                        }
                    }
                }
            }
        } else if (gameState == GameState.LOADING) {
            loadVarbits();
        }
    }


    @FieldHook("npcs")
    @Inject
    public static void cachedNPCsChanged(int idx) {
        RSNPC[] cachedNPCs = client.getCachedNPCs();
        if (idx < 0 || idx >= cachedNPCs.length) {
            return;
        }

        RSNPC npc = cachedNPCs[idx];
        if (npc != null) {
            npc.setIndex(idx);

            client.getCallbacks().postDeferred(Events.NPC_SPAWNED, new NpcSpawned(npc));
        }
    }

    @FieldHook("players")
    @Inject
    public static void cachedPlayersChanged(int idx) {
        RSPlayer[] cachedPlayers = client.getCachedPlayers();
        if (idx < 0 || idx >= cachedPlayers.length) {
            return;
        }

        RSPlayer player = cachedPlayers[idx];
        RSPlayer oldPlayer = oldPlayers[idx];
        oldPlayers[idx] = player;

        if (oldPlayer != null) {
            client.getCallbacks().post(Events.PLAYER_DESPAWNED, new PlayerDespawned(oldPlayer));
        }
        if (player != null) {
            client.getCallbacks().postDeferred(Events.PLAYER_SPAWNED, new PlayerSpawned(player));
        }
    }

    @Copy("findItemDefinitions")
    @Replace("findItemDefinitions")
    public static void copy$findItemDefinitions(String var0, boolean var1) {
        GrandExchangeSearched event = new GrandExchangeSearched();
        client.getCallbacks().post(Events.GRAND_EXCHANGE_SEARCHED, event);
        if (!event.getConsumed()) {
            copy$findItemDefinitions(var0, var1);
        }
    }

    @Inject
    @FieldHook("grandExchangeOffers")
    public static void onGrandExchangeOffersChanged(int idx) {
        if (idx == -1) {
            return;
        }

        GrandExchangeOffer internalOffer = client.getGrandExchangeOffers()[idx];

        if (internalOffer == null) {
            return;
        }

        GrandExchangeOfferChanged offerChangedEvent = new GrandExchangeOfferChanged(internalOffer, idx);
        client.getCallbacks().post(Events.GRAND_EXCHANGE_OFFER_CHANGED, offerChangedEvent);
    }

    @Inject
    private static Map<Integer, ArrayList<Integer>> varbitsMap;

    @Inject
    private static int[] baseVarData;

    @Inject
    private static int[] varbitData;


    private static final int VARBIT_GROUP_ID = 14;

    @Inject
    public static void loadVarbits() {
        // Load varbits into map<index, varbitIds>
        if (varbitsMap == null) {
            varbitsMap = new HashMap<>();
            RSArchive archive = client.getIndexConfig();
            int[] fileIds = archive.getFileIds(14);

            for (int i = 0; i < fileIds.length; i++) {
                VarbitComposition varbitComposition = client.getVarbit(i);
                if (varbitComposition != null) {
                    int idx = varbitComposition.getIndex();
                    if (varbitsMap.containsKey(idx)) {
                        varbitsMap.get(idx).add(i);
                    } else {
                        ArrayList<Integer> varbitIds = new ArrayList<>();
                        varbitIds.add(i);
                        varbitsMap.put(idx, varbitIds);
                    }
                }
            }
        }

        if (baseVarData == null) {
            RSArchive configs = client.getIndexConfig();
            int count = configs.getGroupFileCount$api(VARBIT_GROUP_ID);
            int[] ids = configs.getFileIds(VARBIT_GROUP_ID);

            baseVarData = new int[ids.length];
            varbitData = new int[count];

            int idx = 0;
            for (int varbitId : ids) {
                VarbitComposition var8 = client.getVarbit(varbitId);
                baseVarData[idx++] = var8.getIndex() << 16 | varbitId;
                varbitData[varbitId] = var8.getIndex() << 16 | var8.getMostSignificantBit() << 8 | var8.getLeastSignificantBit();
            }

            Arrays.sort(baseVarData);
        }
    }

    @Inject
    private static int[] oldVarps;

    @Shadow("Varps_masks")
    private static int[] varpsMasks;

    @FieldHook("Varps_main")
    @Inject
    public static void settingsChanged(int idx) {
        VarbitChanged varpChanged = new VarbitChanged();
        varpChanged.setVarpId(idx);
        varpChanged.setValue(client.getVarpValue(idx));
        client.getCallbacks().post(Events.VARBIT_CHANGED, varpChanged);

        if (oldVarps == null) {
            oldVarps = new int[client.getVarps().length];
        }

        if (!Arrays.equals(oldVarps, client.getVarps())) {
            ArrayList<Integer> varbitIds = varbitsMap.get(idx);

            if (varbitIds == null || varbitIds.isEmpty()) {
                return;
            }

            for (int varbitId : varbitIds) {
                int oldValue = client.getVarbitValue(oldVarps, varbitId);
                int newValue = client.getVarbitValue(client.getVarps(), varbitId);

                int changedBits = oldValue ^ newValue;
                int varbitIndex = Arrays.binarySearch(baseVarData, idx << 16);
                if (varbitIndex < 0) {
                    varbitIndex = -varbitIndex - 1;
                }

                for (; varbitIndex < baseVarData.length; ++varbitIndex) {
                    int baseVar = baseVarData[varbitIndex] >> 16;
                    if (baseVar != idx) {
                        break;
                    }

                    int varbit = baseVarData[varbitIndex] & 0xFFFF;
                    int endBit = varbitData[varbit] >> 8 & 255;
                    int startBit = varbitData[varbit] & 255;
                    int maxValue = varpsMasks[endBit - startBit] << startBit;
                    if (((oldValue ^ newValue) & maxValue) != 0) {
                        changedBits &= ~maxValue;
                        int varbitValue = (newValue & maxValue) >>> startBit;
                        VarbitChanged varbitChanged = new VarbitChanged();
                        varbitChanged.setVarpId(-1);
                        varbitChanged.setVarbitId(varbit);
                        varbitChanged.setValue(varbitValue);
                        client.getCallbacks().post(Events.VARBIT_CHANGED, varbitChanged);
                    }
                }
            }

            System.arraycopy(client.getVarps(), 0, oldVarps, 0, oldVarps.length);
        }
    }

    @FieldHook("isResizable")
    @Inject
    public static void resizeChanged(int idx) {
        //maybe couple with varbitChanged. resizeable may not be a varbit but it would fit with the other client settings.
        boolean isResized = client.isResized();

        if (oldIsResized != isResized) {
            ResizeableChanged resizeableChanged = new ResizeableChanged(isResized);
            client.getCallbacks().post(Events.RESIZEABLE_CHANGED, resizeableChanged);

            oldIsResized = isResized;
        }
    }

    @Inject
    public static RSRuneLiteClanMember runeLiteClanMember() {
        throw new NotImplementedException();
    }

    @FieldHook("friendsChat")
    @Inject
    public static void clanMemberManagerChanged(int idx) {
        client.getCallbacks()
                .post(Events.FRIENDS_CHAT_CHANGED, new FriendsChatChanged(client.getFriendsChatManager() != null));
    }

    @FieldHook("canvasWidth")
    @Inject
    public static void canvasWidthChanged(int idx) {
        //This can be called before callbacks are realized, so we do a null check
        if (client.getCallbacks() != null) {
            client.getCallbacks().post(Events.CANVAS_SIZE_CHANGED, CanvasSizeChanged.INSTANCE);
        }
    }

    @FieldHook("canvasHeight")
    @Inject
    public static void canvasHeightChanged(int idx) {
        //This can be called before callbacks are realized, so we do a null check
        if (client.getCallbacks() != null) {
            client.getCallbacks().post(Events.CANVAS_SIZE_CHANGED, CanvasSizeChanged.INSTANCE);
        }
    }

    @FieldHook("hintArrowPlayerIndex")
    @Inject
    public static void hintPlayerChanged(int ignored) {
        // Setting the localInteractingIndex (aka player target index, it only applies to players)
        // causes that player to get priority over others when rendering/menus are added
        if (client.getVar(VarPlayer.ATTACKING_PLAYER) == -1) {
            client.setLocalInteractingIndex(client.getHintArrowPlayerTargetIdx() & 2047);
        }
        client.getCallbacks().post(Events.HINT_ARROW_EVENT,
                new HintArrowEvent(client.getHintArrowPlayerTargetIdx(), -1, -1, -1, -1));
    }

    @FieldHook("combatTargetPlayerIndex")
    @Inject
    public static void combatPlayerTargetChanged(int ignored) {
        if (client.getLocalInteractingIndex() == -1) {
            final Player p = client.getHintArrowPlayer();
            if (p != null) {
                client.setLocalInteractingIndex(p.getPlayerId() & 2047);
            }
        }
    }

    @Inject
    @Override
    public boolean hasHintArrow() {
        return client.getHintArrowTargetType() != HintArrowType.NONE.getValue();
    }

    @Inject
    @Override
    public HintArrowType getHintArrowType() {
        int type = client.getHintArrowTargetType();
        if (type == HintArrowType.NPC.getValue()) {
            return HintArrowType.NPC;
        } else if (type == HintArrowType.PLAYER.getValue()) {
            return HintArrowType.PLAYER;
        } else if (type == HintArrowType.WORLD_POSITION.getValue()) {
            return HintArrowType.WORLD_POSITION;
        } else {
            return HintArrowType.NONE;
        }
    }

    @Inject
    @Override
    public void clearHintArrow() {
        client.setHintArrowTargetType(HintArrowType.NONE.getValue());
    }

    @Inject
    @Override
    public void setHintArrow(NPC npc) {
        client.setHintArrowTargetType(HintArrowType.NPC.getValue());
        client.setHintArrowNpcTargetIdx(npc.getIndex());
    }

    @Inject
    @Override
    public void setHintArrow(Player player) {
        client.setHintArrowTargetType(HintArrowType.PLAYER.getValue());
        client.setHintArrowPlayerTargetIdx(((RSPlayer) player).getPlayerId());
        hintPlayerChanged(-1);
    }

    @Inject
    @Override
    public void setHintArrow(WorldPoint point) {
        client.setHintArrowTargetType(HintArrowType.WORLD_POSITION.getValue());
        client.setHintArrowX(point.getX());
        client.setHintArrowY(point.getY());
        // position the arrow in center of the tile
        client.setHintArrowOffsetX(LOCAL_TILE_SIZE / 2);
        client.setHintArrowOffsetY(LOCAL_TILE_SIZE / 2);
    }

    @Inject
    @Override
    public WorldPoint getHintArrowPoint() {
        if (getHintArrowType() == HintArrowType.WORLD_POSITION) {
            int x = client.getHintArrowX();
            int y = client.getHintArrowY();
            return new WorldPoint(x, y, client.getPlane());
        }

        return null;
    }

    @Inject
    @Override
    public Player getHintArrowPlayer() {
        if (getHintArrowType() == HintArrowType.PLAYER) {
            int idx = client.getHintArrowPlayerTargetIdx();
            RSPlayer[] players = client.getCachedPlayers();

            if (idx < 0 || idx >= players.length) {
                return null;
            }

            return players[idx];
        }

        return null;
    }

    @Inject
    @Override
    public NPC getHintArrowNpc() {
        if (getHintArrowType() == HintArrowType.NPC) {
            int idx = client.getHintArrowNpcTargetIdx();
            RSNPC[] npcs = client.getCachedNPCs();

            if (idx < 0 || idx >= npcs.length) {
                return null;
            }

            return npcs[idx];
        }

        return null;
    }

    @FieldHook("Login_username")
    @Inject
    public static void onUsernameChanged(int idx) {
        client.getCallbacks().post(Events.USERNAME_CHANGED, UsernameChanged.INSTANCE);
    }

    @Override
    @Inject
    public int getTickCount() {
        return tickCount;
    }

    @Override
    @Inject
    public void setTickCount(int tick) {
        tickCount = tick;
    }

    @Inject
    @Override
    public EnumSet<WorldType> getWorldType() {
        int flags = getFlags();
        return WorldType.fromMask(flags);
    }

    @Copy("openMenu")
    @Replace("openMenu")
    public void copy$openMenu(int x, int y) {
        final MenuOpened event = new MenuOpened(getMenuEntries());
        callbacks.post(Events.MENU_OPENED, event);

        if (event.getModified()) {
            setMenuEntries(event.getMenuEntries());
        }

        copy$openMenu(x, y);

        client.getScene()
                .menuOpen$api(client.getPlane(), x - client.getViewportXOffset(), y - client.getViewportYOffset(), false);
    }

/*    @Copy("addWidgetItemMenuItem")
    @Replace("addWidgetItemMenuItem")
    static void copy$addWidgetItemMenuItem(RSWidget var0, RSItemComposition var1, int var2, int var3, boolean var4) {
        String[] var5 = var1.getInventoryActions();

        if (var5.length > var3) {
            copy$addWidgetItemMenuItem(var0, var1, var2, var3, var4);
        }
    }*/

    @Inject
    @MethodHook("updateNpcs")
    public static void updateNpcs(boolean var0, RSPacketBuffer var1) {
        client.getCallbacks().updateNpcs();
    }

    @SuppressWarnings("InfiniteRecursion")
    @Copy("addChatMessage")
    @Replace("addChatMessage")
    public static void copy$addChatMessage(int type, String name, String message, String sender) {
        copy$addChatMessage(type, name, message, sender);

        // Get the message node which was added
        @SuppressWarnings("unchecked") Map<Integer, RSChatChannel> chatLineMap = client.getChatLineMap();
        RSChatChannel chatLineBuffer = chatLineMap.get(type);
        MessageNode messageNode = chatLineBuffer.getLines()[0];

        ChatMessageType tmpType = ChatMessageType.of(type);

        if (tmpType == ChatMessageType.CLAN_CHAT && message != null && message.startsWith("|")) {
            tmpType = ChatMessageType.CLAN_GIM_CHAT;
            message = message.substring(1);
        }

        if (tmpType == ChatMessageType.CLAN_MESSAGE && message != null && message.startsWith("|")) {
            tmpType = ChatMessageType.CLAN_GIM_MESSAGE;
            message = message.substring(1);
        }

        Logger logger = client.getLogger();

        final ChatMessage chatMessage = new ChatMessage(messageNode, tmpType, name, message, sender,
                messageNode.getTimestamp());
        client.getCallbacks().post(Events.CHAT_MESSAGE, chatMessage);
    }

    @Copy("draw")
    @Replace("draw")
    public void copy$draw(boolean var1) {
        callbacks.frame();
        updateCamera();

        copy$draw(var1);

        checkResize();
    }

    @Inject
    public static int cachedX = -1;

    @Inject
    public static int cachedY = -1;

    @MethodHook("drawInterface")
    @Inject
    public static void preRenderWidgetLayer(Widget[] widgets, int parentId, int minX, int minY, int maxX, int maxY,
                                            int x, int y, int var8) {
        for (Widget value : widgets) {
            RSWidget widget = (RSWidget) value;
            if (widget == null || widget.getRSParentId() != parentId || widget.isSelfHidden()) {
                continue;
            }

            int renderX = x + widget.getRelativeX();
            int renderY = y + widget.getRelativeY();
            Widget parent = client.getWidget(parentId);
            if (parent != null) {
                if (!parent.getBounds().contains(new java.awt.Point(renderX, renderY))) {
                    renderX = parent.getCanvasLocation().x + widget.getRelativeX();
                    renderY = parent.getCanvasLocation().y + widget.getRelativeY();
                }
            }
            widget.setRenderX(renderX);
            widget.setRenderY(renderY);

            if (widget.getType() == WidgetType.RECTANGLE && renderX == client.getViewportXOffset() && renderY == client.getViewportYOffset() && widget.getWidth() == client.getViewportWidth() && widget.getHeight() == client.getViewportHeight() && widget.getOpacity() > 0 && widget.isFilled() && widget.getFillMode()
                    .getOrdinal() == 0 && client.isGpu()) {
                int tc = widget.getTextColor();
                int alpha = widget.getOpacity() & 0xFF;
                int inverseAlpha = 256 - alpha;
                int vpc = viewportColor;
                int c1 = (inverseAlpha * (tc & 0xFF00FF) >> 8 & 0xFF00FF) + (inverseAlpha * (tc & 0x00FF00) >> 8 & 0x00FF00);
                int c2 = (alpha * (vpc & 0xFF00FF) >> 8 & 0xFF00FF) + (alpha * (vpc & 0x00FF00) >> 8 & 0x00FF00);
                int outAlpha = inverseAlpha + ((vpc >>> 24) * (255 - inverseAlpha) * 0x8081 >>> 23);
                viewportColor = outAlpha << 24 | c1 + c2;
                widget.setHidden(true);
                hiddenWidgets.add(widget);
            }
        }
    }

    @Inject
    @MethodHook(value = "drawInterface", end = true)
    public static void postRenderWidgetLayer(Widget[] widgets, int parentId, int minX, int minY, int maxX, int maxY,
                                             int x, int y, int var8) {
        Callbacks callbacks = client.getCallbacks();
        int oldSize = widgetItems.size();

        for (Widget rlWidget : widgets) {
            RSWidget widget = (RSWidget) rlWidget;
            if (widget == null || widget.getRSParentId() != parentId || widget.isSelfHidden()) {
                continue;
            }

            int type = widget.getType();
            if (type == WidgetType.GRAPHIC && widget.getItemId() != -1) {
                final int renderX = x + widget.getRelativeX();
                final int renderY = y + widget.getRelativeY();
                if (renderX >= minX && renderX <= maxX && renderY >= minY && renderY <= maxY) {
                    WidgetItem widgetItem = new WidgetItem(widget.getItemId(), widget.getItemQuantity(), -1,
                            widget.getBounds(), widget, null);
                    widgetItems.add(widgetItem);
                }
            } else if (type == WidgetType.INVENTORY) {
                widgetItems.addAll(widget.getWidgetItems());
            }
        }

        List<WidgetItem> subList = Collections.emptyList();
        if (oldSize < widgetItems.size()) {
            if (oldSize > 0) {
                subList = widgetItems.subList(oldSize, widgetItems.size());
            } else {
                subList = widgetItems;
            }
        }

        if (parentId == 0xabcdabcd) {
            widgetItems.clear();
        } else if (parentId != -1) {
            Widget widget = client.getWidget(parentId);
            Widget[] children = widget.getChildren();
            if (children == null || children == widgets) {
                callbacks.drawLayer(widget, subList);
            }
        } else {
            int group = -1;
            for (Widget widget : widgets) {
                if (widget != null) {
                    group = WidgetInfo.TO_GROUP(widget.getId());
                    break;
                }
            }

            if (group == -1) {
                return;
            }

            callbacks.drawInterface(group, widgetItems);
            widgetItems.clear();
            for (int i = hiddenWidgets.size() - 1; i >= 0; i--) {
                Widget widget = hiddenWidgets.get(i);
                if (WidgetInfo.TO_GROUP(widget.getId()) == group) {
                    widget.setHidden(false);
                    hiddenWidgets.remove(i);
                }
            }
        }
    }


    @Inject
    @Override
    public RSTileItem getLastItemDespawn() {
        return lastItemDespawn;
    }

    @Inject
    @Override
    public void setLastItemDespawn(RSTileItem lastItemDespawn) {
        RSClientMixin.lastItemDespawn = lastItemDespawn;
    }

    @Inject
    @Override
    public boolean isGpu() {
        return gpu;
    }

    @Inject
    @Override
    public void setGpu(boolean gpu) {
        this.gpu = gpu;
    }

    @Inject
    @Override
    public void queueChangedSkill(Skill skill) {
        int[] skills = client.getChangedSkills();
        int count = client.getChangedSkillsCount();
        skills[++count - 1 & 31] = skill.ordinal();
        client.setChangedSkillsCount(count);
    }

    @Inject
    @Override
    public RSSpritePixels[] getSprites(IndexDataBase source, int archiveId, int fileId) {
        RSAbstractArchive rsSource = (RSAbstractArchive) source;
        byte[] configData = rsSource.getConfigData(archiveId, fileId);
        if (configData == null) {
            return null;
        }

        decodeSprite(configData);

        int indexedSpriteCount = getIndexedSpriteCount();
        int maxWidth = getIndexedSpriteWidth();
        int maxHeight = getIndexedSpriteHeight();
        int[] offsetX = getIndexedSpriteOffsetXs();
        int[] offsetY = getIndexedSpriteOffsetYs();
        int[] widths = getIndexedSpriteWidths();
        int[] heights = getIndexedSpriteHeights();
        byte[][] spritePixelsArray = getSpritePixels();
        int[] indexedSpritePalette = getIndexedSpritePalette();

        RSSpritePixels[] array = new RSSpritePixels[indexedSpriteCount];

        for (int i = 0; i < indexedSpriteCount; ++i) {
            int width = widths[i];
            int height = heights[i];

            byte[] pixelArray = spritePixelsArray[i];
            int[] pixels = new int[width * height];

            RSSpritePixels spritePixels = createSpritePixels(pixels, width, height);
            spritePixels.setMaxHeight(maxHeight);
            spritePixels.setMaxWidth(maxWidth);
            spritePixels.setOffsetX(offsetX[i]);
            spritePixels.setOffsetY(offsetY[i]);

            for (int j = 0; j < width * height; ++j) {
                pixels[j] = indexedSpritePalette[pixelArray[j] & 0xff];
            }

            array[i] = spritePixels;
        }

        setIndexedSpriteOffsetXs(null);
        setIndexedSpriteOffsetYs(null);
        setIndexedSpriteWidths(null);
        setIndexedSpriteHeights(null);
        setIndexedSpritePalette(null);
        setSpritePixels(null);

        return array;
    }

    @Inject
    @Override
    public void setSkyboxColor(int newSkyboxColor) {
        skyboxColor = newSkyboxColor;
    }

    @Inject
    @Override
    public int getSkyboxColor() {
        return skyboxColor;
    }

    @Inject
    @FieldHook("cycleCntr")
    public static void onCycleCntrChanged(int idx) {
        client.getCallbacks().post(Events.CLIENT_TICK, ClientTick.INSTANCE);
    }

    @Copy("shouldLeftClickOpenMenu")
    @Replace("shouldLeftClickOpenMenu")
    @SuppressWarnings("InfiniteRecursion")
    boolean copy$shouldLeftClickOpenMenu() {
        if (copy$shouldLeftClickOpenMenu()) {
            return true;
        }

        MenuShouldLeftClick menuShouldLeftClick = new MenuShouldLeftClick();
        client.getCallbacks().post(Events.MENU_SHOULD_LEFT_CLICK, menuShouldLeftClick);

        if (menuShouldLeftClick.isForceRightClick()) {
            return true;
        }

        int len = getMenuOptionCount();
        if (len > 0) {
            int type = getMenuOpcodes()[len - 1];
            return type == MenuAction.RUNELITE_OVERLAY.getId() || type == MenuAction.RUNELITE_OVERLAY_CONFIG.getId() || type == MenuAction.RUNELITE_INFOBOX.getId();
        }

        return false;
    }

    @Inject
    @Override
    public EnumComposition getEnum(int id) {
        assert isClientThread() : "getEnum must be called on client thread";

        RSEnumComposition rsEnumDefinition = enumCache.getIfPresent(id);
        if (rsEnumDefinition != null) {
            return rsEnumDefinition;
        }

        rsEnumDefinition = getRsEnum(id);
        enumCache.put(id, rsEnumDefinition);
        return rsEnumDefinition;
    }

    @Inject
    @Override
    public void resetHealthBarCaches() {
        getHealthBarCache().reset();
        getHealthBarSpriteCache().reset();
    }

    @Inject
    static boolean shouldHideAttackOptionFor(RSPlayer p) {
/*        if (client.getSpellSelected()) {
            return ((hideFriendCastOptions && p.isFriended()) || (hideClanmateCastOptions && p.isFriendsChatMember$api())) && !unhiddenCasts.contains(
                    client.getSelectedSpellName().replaceAll("<[^>]*>", "").toLowerCase());
        }*/

        return ((hideFriendAttackOptions && p.isFriended()) || (hideClanmateAttackOptions && p.isFriendsChatMember$api()));
    }

    @Inject
    @Override
    public void addFriend(String friend) {
        RSFriendSystem friendSystem = getFriendManager();
        friendSystem.addFriend$api(friend);
    }

    @Inject
    @Override
    public void removeFriend(String friend) {
        RSFriendSystem friendSystem = getFriendManager();
        friendSystem.removeFriend$api(friend);
    }

    @Inject
    @Override
    public void addIgnore(String friend) {
        RSFriendSystem friendSystem = getFriendManager();
        friendSystem.addIgnore$api(friend);
    }

    @Inject
    @Override
    public void removeIgnore(String friend, boolean confirmToJagex) {
        RSFriendSystem friendSystem = getFriendManager();
        friendSystem.removeIgnore$api(friend, confirmToJagex);
    }

    @Inject
    private static BigInteger modulus;

    @Inject
    @Override
    public void setModulus(BigInteger modulus) {
        this.modulus = modulus;
    }

    @Inject
    @Override
    public BigInteger getModulus() {
        return modulus;
    }

    @Copy("forceDisconnect")
    @Replace("forceDisconnect")
    @SuppressWarnings("InfiniteRecursion")
    static void copy$forceDisconnect(int reason) {
        copy$forceDisconnect(reason);

        if (hideDisconnect && reason == 1) {
            client.promptCredentials(true);
        }
    }

    @Copy("changeGameOptions")
    @Replace("changeGameOptions")
    @SuppressWarnings("InfiniteRecursion")
    public static void copy$changeGameOptions(int var0) {
        copy$changeGameOptions(var0);

        int type = client.getVarpDefinition(var0).getType();
        if (type == 3 || type == 4 || type == 10) {
            VolumeChanged volumeChanged = new VolumeChanged(
                    type == 3 ? VolumeChanged.Type.MUSIC : type == 4 ? VolumeChanged.Type.EFFECTS : VolumeChanged.Type.AREA);
            client.getCallbacks().post(Events.VOLUME_CHANGED, volumeChanged);
        }
    }

    @Replace("getWidgetFlags")
    public static int getWidgetFlags(Widget widget) {
        IntegerNode integerNode = (IntegerNode) client.getWidgetFlags()
                .get(((long) widget.getId() << 32) + (long) widget.getIndex());

        int widgetClickMask;

        if (integerNode == null) {
            widgetClickMask = widget.getClickMask();
        } else {
            widgetClickMask = integerNode.getValue();
        }

        if (allWidgetsAreOpTargetable) {
            widgetClickMask |= WidgetConfig.WIDGET_USE_TARGET;
        }

        return widgetClickMask;
    }

    @Inject
    @FieldHook("camAngleDX")
    private static void onCamAngleDXChange(int index) {
        if (invertPitch && client.getMouseCurrentButton() == 4 && client.isMouseCam()) {
            client.setCamAngleDX(-client.getCamAngleDX());
        }
    }

    @Inject
    @FieldHook("camAngleDY")
    private static void onCamAngleDYChange(int index) {
        if (invertYaw && client.getMouseCurrentButton() == 4 && client.isMouseCam()) {
            client.setCamAngleDY(-client.getCamAngleDY());
        }
    }

    @Inject
    @Override
    public void setInvertPitch(boolean state) {
        invertPitch = state;
    }

    @Inject
    @Override
    public void setInvertYaw(boolean state) {
        invertYaw = state;
    }

    @Inject
    @Override
    public void stopNow() {
        setStopTimeMs(1);
    }

    @Inject
    @Override
    public boolean isMirrored() {
        return isMirrored;
    }

    @Inject
    @Override
    public void setMirrored(boolean isMirrored) {
        this.isMirrored = isMirrored;
    }

    @Inject
    @Override
    public boolean isComparingAppearance() {
        return comparingAppearance > 0;
    }

    @Inject
    @Override
    public void setComparingAppearance(boolean comparingAppearance) {
        this.comparingAppearance += comparingAppearance ? 1 : -1;
    }

    @Inject
    @Override
    public ObjectComposition getObjectDefinition(int objectId) {
        assert this.isClientThread() : "getObjectDefinition must be called on client thread";
        return getRSObjectComposition(objectId);
    }

    @Inject
    @Override
    @Nonnull
    public ItemComposition getItemDefinition(int id) {
        return getItemComposition(id);
    }

    @Inject
    @Override
    public NPCComposition getNpcDefinition(int id) {
        assert this.isClientThread() : "getNpcDefinition must be called on client thread";
        return getRSNpcComposition(id);
    }

    // this exists because the original got inlined
    @Inject
    public void playMusicTrack(int var0, RSAbstractArchive var1, int var2, int var3, int var4, boolean var5) {
        client.setMusicPlayerStatus(1);
        client.setMusicTrackArchive(var1);
        client.setMusicTrackGroupId(var2);
        client.setMusicTrackFileId(var3);
        client.setMusicTrackVolume(var4);
        client.setMusicTrackBoolean(var5);
        client.setPcmSampleLength(var0);
    }

    @Inject
    @Override
    public void setOutdatedScript(String outdatedScript) {
        if (!outdatedScripts.contains(outdatedScript)) {
            outdatedScripts.add(outdatedScript);
        }
    }

    @Inject
    @Override
    public List<String> getOutdatedScripts() {
        return this.outdatedScripts;
    }

    @Inject
    @MethodHook(value = "changeWorld", end = true)
    public static void postChangeWorld(RSWorld world) {
        client.getCallbacks().post(Events.WORLD_CHANGED, WorldChanged.INSTANCE);
    }

    @Inject
    @Override
    public void queueChangedVarp(int varp) {
        assert client.isClientThread() : "queueChangedVarp must be called on client thread";

        int[] changedVarps = client.getChangedVarps();
        int changedVarpCount = client.getChangedVarpCount();
        changedVarps[changedVarpCount & 31] = varp;
        client.setChangedVarpCount(changedVarpCount + 1);
    }

    @Inject
    @Override
    public ScriptEvent createScriptEvent(Object... args) {
        return createRSScriptEvent(args);
    }

    @Inject
    @Override
    public RSScriptEvent createRSScriptEvent(Object... args) {
        RSScriptEvent event = createScriptEvent();
        event.setArguments(args);
        return event;
    }

    @Inject
    @Override
    public NodeCache getStructCompositionCache() {
        assert client.isClientThread() : "getStructCompositionCache must be called on client thread";

        return getRSStructCompositionCache();
    }

    @Inject
    @Override
    public StructComposition getStructComposition(int structID) {
        assert client.isClientThread() : "getStructComposition must be called on client thread";

        return getRSStructComposition(structID);
    }

    @Copy("StructDefinition_getStructDefinition")
    @Replace("StructDefinition_getStructDefinition")
    @SuppressWarnings("InfiniteRecursion")
    static RSStructComposition copy$getStructComposition(int id) {
        RSStructComposition comp = copy$getStructComposition(id);

        if (comp.getId() == -1) {
            comp.setId(id);
            PostStructComposition event = new PostStructComposition(comp);
            client.getCallbacks().post(Events.POST_STRUCT_COMPOSITION, event);
        }

        return comp;
    }

    @Inject
    @Override
    public int getMusicVolume() {
        return client.getPreferences().getMusicVolume();
    }

    @Inject
    @Override
    public void setMusicVolume(int volume) {
        if (volume > 0 && client.getPreferences().getMusicVolume() <= 0 && client.getCurrentTrackGroupId() != -1) {
            client.playMusicTrack(1000, client.getMusicTracks(), client.getCurrentTrackGroupId(), 0, volume, false);
        }

        client.getPreferences().setMusicVolume(volume);
        client.setMusicTrackVolume(volume);
        if (client.getMidiPcmStream() != null) {
            client.getMidiPcmStream().setPcmStreamVolume$api(volume);
        }
    }

    @Inject
    @MethodHook("closeInterface")
    public static void preCloseInterface(RSInterfaceParent iface, boolean willUnload) {
        client.getCallbacks()
                .post(Events.WIDGET_CLOSED, new WidgetClosed(iface.getId(), iface.getModalMode(), willUnload));
    }

    @Inject
    @Override
    public ClanChannel getClanChannel() {
        return getCurrentClanChannels()[0];
    }

    @Inject
    @Override
    public ClanChannel getClanChannel(int clanId) {
        ClanChannel[] clanChannels = client.getCurrentClanChannels();

        if (clanId >= 0 && clanId < clanChannels.length) {
            return clanChannels[clanId];
        }

        return null;
    }

    @Inject
    @Override
    public ClanSettings getClanSettings() {
        return getCurrentClanSettingsAry()[0];
    }

    @Inject
    @Override
    public ClanSettings getClanSettings(int clanId) {
        ClanSettings[] clanSettings = getCurrentClanSettingsAry();

        if (clanId >= 0 && clanId < clanSettings.length) {
            return clanSettings[clanId];
        }

        return null;
    }

    @Inject
    @Override
    public ClanRank getClanRankFromRs(int rank) {
        switch (rank) {
            case -1:
                return ClanRank.GUEST;
            case 10:
                return ClanRank.CLAN_RANK_2;
            case 20:
                return ClanRank.CLAN_RANK_3;
            case 30:
                return ClanRank.CLAN_RANK_4;
            case 40:
                return ClanRank.CLAN_RANK_5;
            case 50:
                return ClanRank.CLAN_RANK_6;
            case 60:
                return ClanRank.CLAN_RANK_7;
            case 70:
                return ClanRank.CLAN_RANK_8;
            case 80:
                return ClanRank.CLAN_RANK_9;
            case 90:
                return ClanRank.CLAN_RANK_10;
            case 100:
                return ClanRank.ADMINISTRATOR;
            case 105:
                return ClanRank.CLAN_RANK_11;
            case 110:
                return ClanRank.CLAN_RANK_12;
            case 115:
                return ClanRank.CLAN_RANK_13;
            case 120:
                return ClanRank.CLAN_RANK_14;
            case 125:
                return ClanRank.DEPUTY_OWNER;
            case 126:
                return ClanRank.OWNER;
            case 127:
                return ClanRank.JMOD;
            default:
                return ClanRank.CLAN_RANK_1;
        }
    }

    @Inject
    @FieldHook("guestClanChannel")
    public static void onGuestClanChannelChanged(int idx) {
        client.getCallbacks()
                .post(Events.CLAN_CHANNEL_CHANGED, new ClanChannelChanged(client.getGuestClanChannel(), -1, true));
    }

    @Inject
    @FieldHook("currentClanChannels")
    public static void onCurrentClanChannelsChanged(int idx) {
        RSClanChannel[] clanChannels = client.getCurrentClanChannels();

        if (idx >= 0 && idx < clanChannels.length) {
            RSClanChannel clanChannel = clanChannels[idx];
            client.getCallbacks().post(Events.CLAN_CHANNEL_CHANGED, new ClanChannelChanged(clanChannel, idx, false));
        }
    }


    @Inject
    public static RSArchive[] archives = new RSArchive[21];

    @Inject
    @FieldHook("rndHue")
    public static void rndHue(int idx) {
        int rndHue = client.getRndHue();

        if (rndHue >= -8 && rndHue <= 8) {
            RSScene scene = client.getScene();

            short[][][] underlays = client.getTileUnderlays();
            short[][][] overlays = client.getTileOverlays();
            byte[][][] tileShapes = client.getTileShapes();

            scene.setUnderlayIds(Arrays.copyOf(underlays, underlays.length));
            scene.setOverlayIds(Arrays.copyOf(overlays, overlays.length));
            scene.setTileShapes(Arrays.copyOf(tileShapes, tileShapes.length));
        }
    }

    @Inject
    public Model loadModel(int id) {
        return loadModel(id, null, null);
    }

    @Inject
    public Model loadModel(int id, short[] colorToFind, short[] colorToReplace) {
        RSModelData modeldata = client.getModelData(client.getObjectDefinition_modelsArchive(), id, 0);

        if (colorToFind != null) {
            for (int i = 0; i < colorToFind.length; ++i) {
                modeldata.rs$recolor(colorToFind[i], colorToReplace[i]);
            }
        }

        return modeldata.toModel(modeldata.getAmbient() + 64, modeldata.getContrast() + 850, -30, -50, -30);
    }

    @Inject
    public Animation loadAnimation(int id) {
        return client.getSequenceDefinition(id);
    }

    @Inject
    @Override
    public boolean isUnlockedFps() {
        return unlockedFps;
    }

    @Inject
    public void setUnlockedFps(boolean unlocked) {
        unlockedFps = unlocked;

        if (unlocked) {
            posToCameraAngle(client.getMapAngle(), client.getCameraPitch());
        } else {
            delayNanoTime = 0L;
        }
    }

    @Inject
    public void setUnlockedFpsTarget(int var1) {
        if (var1 <= 0) {
            delayNanoTime = 0L;
        } else {
            delayNanoTime = 1000000000L / (long) var1;
        }
    }

    @Inject
    @Override
    public long getUnlockedFpsTarget() {
        return delayNanoTime;
    }

    @Inject
    public void updateCamera() {
        if (unlockedFps) {
            long nanoTime = System.nanoTime();
            long diff = nanoTime - this.lastNanoTime;
            this.lastNanoTime = nanoTime;

            if (this.getGameState() == GameState.LOGGED_IN) {
                this.interpolateCamera(diff);
            }
        }
    }

    @Inject
    public void interpolateCamera(long var1) {
        double angleDX = diffToDangle(client.getCamAngleDY(), var1);
        double angleDY = diffToDangle(client.getCamAngleDX(), var1);

        tmpCamAngleY += angleDX / 2;
        tmpCamAngleX += angleDY / 2;
        tmpCamAngleX = Doubles.constrainToRange(tmpCamAngleX, Perspective.UNIT * STANDARD_PITCH_MIN,
                client.getCameraPitchRelaxerEnabled() ? Perspective.UNIT * NEW_PITCH_MAX : Perspective.UNIT * STANDARD_PITCH_MAX);

        int yaw = toCameraPos(tmpCamAngleY);
        int pitch = toCameraPos(tmpCamAngleX);

        client.setCameraYawTarget(yaw);
        client.setCameraPitchTarget(pitch);
    }

    @Inject
    public static double diffToDangle(int var0, long var1) {
        double var2 = var0 * Perspective.UNIT;
        double var3 = (double) var1 / 2.0E7D;

        return var2 * var3;
    }

    @Inject
    @Override
    public void posToCameraAngle(int var0, int var1) {
        tmpCamAngleY = var0 * Perspective.UNIT;
        tmpCamAngleX = var1 * Perspective.UNIT;
    }

    @Inject
    public static int toCameraPos(double var0) {
        return (int) (var0 / Perspective.UNIT) & 2047;
    }

    @Inject
    @MethodHook("doCycle")
    protected final void doCycle$pre() {
        client.getCallbacks().tick();
    }

    @Inject
    public static void check(String name, RSEvictingDualNodeHashTable dualNodeHashTable) {
        boolean var3 = dualNodeHashTable.isTrashing();
        dualNodeHashTable.setThreshold(dualNodeHashTable.getThreshold() * 0.92F + (var3 ? 0.07999998F : 0.0F));
        if (var3) {
            if (dualNodeHashTable.getThreshold() > 0.9F && dualNodeHashTable.getCapacity() < dualNodeHashTable.getTmpCapacity() * 8) {
                dualNodeHashTable.increaseCapacity(dualNodeHashTable.getCapacity() * 2);
                client.getLogger()
                        .info("cache {} thrashing, enlarging to {} entries", name, dualNodeHashTable.getCapacity());
            }
        }

        dualNodeHashTable.getDeque().add(dualNodeHashTable.getDualNode());
    }

    @Inject
    public static void checkResize() {
        check("Script_cached", client.getScriptCache());
        check("StructDefinition_cached", client.getRSStructCompositionCache());
        check("HealthBarDefinition_cached", client.getHealthBarCache());
        check("HealthBarDefinition_cachedSprites", client.getHealthBarSpriteCache());
        check("ObjectDefinition_cachedModels", client.getObjectDefinitionModelsCache());
        check("Widget_cachedSprites", client.getWidgetSpriteCache());
        check("ItemDefinition_cached", client.getItemCompositionCache());
        check("VarbitDefinition_cached", client.getVarbitCache());
        check("EnumDefinition_cached", client.getEnumDefinitionCache());
        check("FloorUnderlayDefinition_cached", client.getFloorUnderlayDefinitionCache());
        check("FloorOverlayDefinition_cached", client.getFloorOverlayDefinitionCache());
        check("HitSplatDefinition_cached", client.getHitSplatDefinitionCache());
        check("HitSplatDefinition_cachedSprites", client.getHitSplatDefinitionSpritesCache());
        check("HitSplatDefinition_cachedFonts", client.getHitSplatDefinitionDontsCache());
        check("InvDefinition_cached", client.getInvDefinitionCache());
        check("ItemDefinition_cachedModels", client.getItemDefinitionModelsCache());
        check("ItemDefinition_cachedSprites", client.getItemDefinitionSpritesCache());
        check("KitDefinition_cached", client.getKitDefinitionCache());
        check("NpcDefinition_cached", client.getNpcDefinitionCache());
        check("NpcDefinition_cachedModels", client.getNpcDefinitionModelsCache());
        check("ObjectDefinition_cached", client.getObjectDefinitionCache());
        check("ObjectDefinition_cachedModelData", client.getObjectDefinitionModelDataCache());
        check("ObjectDefinition_cachedEntities", client.getObjectDefinitionEntitiesCache());
        check("ParamDefinition_cached", client.getParamDefinitionCache());
        check("PlayerAppearance_cachedModels", client.getPlayerAppearanceModelsCache());
        check("SequenceDefinition_cached", client.getSequenceDefinitionCache());
        check("SequenceDefinition_cachedFrames", client.getSequenceDefinitionFramesCache());
        check("SequenceDefinition_cachedModel", client.getSequenceDefinitionModelsCache());
        check("SpotAnimationDefinition_cached", client.getSpotAnimationDefinitionCache());
        check("SpotAnimationDefinition_cachedModels", client.getSpotAnimationDefinitionModlesCache());
        check("VarcInt_cached", client.getVarcIntCache());
        check("VarpDefinition_cached", client.getVarpDefinitionCache());
        check("Widget_cachedModels", client.getModelsCache());
        check("Widget_cachedFonts", client.getFontsCache());
        check("Widget_cachedSpriteMasks", client.getSpriteMasksCache());
        check("WorldMapElement_cachedSprites", client.getSpritesCache());
    }

    @Inject
    @Override
    public RSModelData mergeModels(ModelData[] var0, int var1) {
        return newModelData(var0, var1);
    }

    @Inject
    @Override
    public RSModelData mergeModels(ModelData... var0) {
        return newModelData(var0, var0.length);
    }

    @Inject
    public IndexDataBase getIndex(int id) {
        return RSClientMixin.archives[id];
    }

    @Inject
    @Override
    public RSModelData loadModelData(int var0) {
        RSModelData modelData = (RSModelData) this.tmpModelDataCache.get(var0);

        if (modelData == null) {
            modelData = getModelData(RSClientMixin.archives[7], var0, 0);
            if (modelData == null) {
                return null;
            }

            this.tmpModelDataCache.put((RSDualNode) modelData, (long) var0);
        }

        return modelData.newModelData(modelData, true, true, true, true);
    }

    @Inject
    public static RSFloorOverlayDefinition loadFloorOverlay(int var0) {
        RSFloorOverlayDefinition var1 = (RSFloorOverlayDefinition) client.getFloorOverlayDefinitionCache().get(var0);

        if (var1 == null) {
            byte[] var2 = client.getFloorOverlayDefinitionArchive().loadData(4, var0);
            var1 = client.newFloorOverlayDefinition();
            if (var2 != null) {
                RSBuffer var3 = client.newBuffer(var2);
                var1.decode(var3, var0);
            }

            var1.postDecode$api();
            client.getFloorOverlayDefinitionCache().put((RSDualNode) var1, (long) var0);
        }

        return var1;
    }

    @Copy("addObjects")
    @Replace("addObjects")
    @SuppressWarnings("InfiniteRecursion")
    public static void copy$addObjects(int var0, int var1, int var2, int var3, int var4, int var5, RSScene var6,
                                       RSCollisionMap var7) {
        boolean resetLowMemory = false;

        byte tileSetting = client.getTileSettings()[var0][var1][var2];

        if (client.isLowMemory()) {
            byte[] var10000 = client.getTileSettings()[var0][var1];
            var10000[var2] &= -17;
            if (var5 == 22) {
                int TileOverlay = client.getTileOverlays()[var0][var1][var2] & 255;

                if (TileOverlay > 0) {
                    RSFloorOverlayDefinition floorOverlayDefinition = loadFloorOverlay(TileOverlay - 1);
                    if (floorOverlayDefinition.getTexture() < 0 && floorOverlayDefinition.getPrimaryRgb() == 16711935) {
                        client.setLowMemory(false);
                        resetLowMemory = true;
                    }
                }
            }
        }

        copy$addObjects(var0, var1, var2, var3, var4, var5, var6, var7);

        client.getTileSettings()[var0][var1][var2] = tileSetting;

        if (resetLowMemory) {
            client.setLowMemory(true);
        }
    }

    @Inject
    @Override
    public Widget getSelectedWidget() {
        int selectedSpellWidget = client.getSelectedSpellWidget();
        int selectedSpellChildIndex = client.getSelectedSpellChildIndex();

        Widget widget = client.getWidget(selectedSpellWidget);

        if (widget != null && selectedSpellChildIndex > -1) {
            return widget.getChild(selectedSpellChildIndex);
        }

        return null;
    }

    @Inject
    @Override
    public int addClientScript(byte[] script) {
        assert this.isClientThread() : "addClientScript must be called on client thread";

        int highestUsedScript = -1;
        for (int index : OverlayIndex.getOverlays()) {
            if ((index >> 16) != 12) {
                continue;
            }

            int scriptId = index & 0xFFFF;
            if (scriptId > highestUsedScript) {
                highestUsedScript = scriptId;
            }
        }

        if (highestUsedScript == -1) {
            highestUsedScript = 10000;
        }

        int newScriptId = highestUsedScript + 1;
        OverlayIndex.getOverlays().add((12 << 16) | newScriptId);
        customClientScripts.put((12 << 16) | newScriptId, script);
        return newScriptId;
    }

    @Inject
    public static boolean drawMenu() {
        BeforeMenuRender event = new BeforeMenuRender();
        client.getCallbacks().post(Events.BEFORE_MENU_RENDER, event);
        return event.getConsumed();
    }

    @Override
    @Inject
    public void invokeMenuAction(String option, String target, int identifier, int opcode, int param0, int param1,
                                 int itemId, int x, int y) {
        assert isClientThread() : "invokeMenuAction must be called on client thread";

        client.sendMenuAction(param0, param1, opcode, identifier, itemId, option, target, x, y);
    }

    @Inject
    @Override
    public void insertMenuItem(String action, String target, int opcode, int identifier, int argument1, int argument2,
                               boolean forceLeftClick) {
        insertMenuItem(action, target, opcode, identifier, argument1, argument2, getItemId(argument1, argument2, -1),
                forceLeftClick);
    }

    @Inject
    private static int getItemId(int identifier, int opcode, int param0, int param1, int currentItemId) {
        switch (opcode) {
            case 1006:
                currentItemId = 0;
                break;
            case 25:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 58:
            case 1005:
                currentItemId = getItemId(param0, param1, currentItemId);
                break;

            case 57:
            case 1007:
                if (identifier >= 1 && identifier <= 10) {
                    currentItemId = getItemId(param0, param1, currentItemId);
                }

                break;
        }

        return currentItemId;
    }

    @Inject
    private static int getItemId(int param0, int param1, int currentItemId) {
        Widget widget = client.getWidget(param1);
        if (widget != null) {
            int group = param1 >>> 16;
            Widget[] children = widget.getChildren();
            if (children != null && children.length >= 2 && group == WidgetID.EQUIPMENT_GROUP_ID) {
                param0 = 1;
            }

            if (param0 < 0) param0 = 0;

            Widget child = widget.getChild(param0);
            if (child != null) {
                if (currentItemId != child.getItemId()) {
                    return child.getItemId();
                }
            }
        }

        return currentItemId;
    }

    @Inject
    private static final AtomicReference<AutomatedMenu> automatedMenu = new AtomicReference<>(null);

    @Copy("menuAction")
    @Replace("menuAction")
    static void copy$menuAction(int param0, int param1, int opcode, int id, int itemId, String option, String target,
                                int canvasX, int canvasY) {
        RSRuneLiteMenuEntry menuEntry = null;
        for (int i = client.getMenuOptionCount() - 1; i >= 0; --i) {
            if (client.getMenuOpcodes()[i] == opcode && client.getMenuIdentifiers()[i] == id && client.getMenuArguments1()[i] == param0 && client.getMenuArguments2()[i] == param1 && client.getMenuItemIds()[i] == itemId && option.equals(
                    client.getMenuOptions()[i]) && target.equals(client.getMenuTargets()[i])) {
                menuEntry = rl$menuEntries[i];
                break;
            }
        }

        boolean isTemp = false;
        if (client.getTempMenuAction() != null) {
            isTemp = client.getTempMenuAction().getOpcode() == opcode && client.getTempMenuAction()
                    .getIdentifier() == id && client.getTempMenuAction().getOption()
                    .equals(option) && client.getTempMenuAction().getTarget()
                    .equals(target) && client.getTempMenuAction().getParam0() == param0 && client.getTempMenuAction()
                    .getParam1() == param1 && client.getTempMenuAction().getItemId() == itemId;
        }

        if (menuEntry == null && isTemp) {
            int i;
            if (client.getMenuOptionCount() < 500) {
                i = client.getMenuOptionCount();
                client.setMenuOptionCount(client.getMenuOptionCount() + 1);
            } else {
                i = 0;
            }

            client.getMenuOpcodes()[i] = opcode;
            client.getMenuIdentifiers()[i] = id;
            client.getMenuOptions()[i] = option;
            client.getMenuTargets()[i] = target;
            client.getMenuArguments1()[i] = param0;
            client.getMenuArguments2()[i] = param1;
            client.getMenuItemIds()[i] = itemId;
            client.getMenuForceLeftClick()[i] = false;
            menuEntry = rl$menuEntries[i];

            if (menuEntry == null) {
                menuEntry = rl$menuEntries[i] = newRuneliteMenuEntry(i);
            }
        }

        MenuOptionClicked event;
        if (menuEntry == null) {
            MenuEntry tmpEntry = client.createMenuEntry(option, target, id, opcode, param0, param1, itemId, false);
            event = new MenuOptionClicked(tmpEntry);

            if (canvasX != -1 || canvasY != -1) {
                client.getLogger()
                        .warn("Unable to find clicked menu op {} targ {} action {} id {} p0 {} p1 {} item {}", option,
                                target, opcode, id, param0, param1, itemId);
            }
        } else {
            AutomatedMenu menu = automatedMenu.getAndSet(null);
            if (menu != null) {
                menuEntry.setIdentifier(menu.getIdentifier());
                menuEntry.setType(menu.getOpcode());
                menuEntry.setParam0(menu.getParam0());
                menuEntry.setParam1(menu.getParam1());
                menuEntry.setItemId(menu.getItemId());
                menuEntry.setOption(menu.getOption());
                menuEntry.setTarget(menu.getTarget());
            }

            event = new MenuOptionClicked(menuEntry);
            client.getCallbacks().post(Events.MENU_OPTION_CLICKED, event);

            // Set new item id here in case event is modified
            int newItemId = getItemId(event.getId(), event.getMenuAction().getId(), event.getParam0(),
                    event.getParam1(), event.getItemId());
            event.setItemId(newItemId);

            if (menuEntry.getConsumer() != null) {
                try {
                    menuEntry.getConsumer().accept(menuEntry);
                } catch (Exception ex) {
                    client.getLogger().warn("exception in menu callback", ex);
                }
            }

            if (event.getConsumed()) {
                return;
            }
        }

        if ("Automated".equals(event.getMenuOption()) && event.getMenuAction() == MenuAction.WALK) {
            client.setSelectedSceneTileX(event.getParam0());
            client.setSelectedSceneTileY(event.getParam1());
            client.setViewportWalking(true);

            copy$menuAction(0, 0, CANCEL.getId(), 0, 0, "Automated", "", canvasX, canvasY);
            return;
        }

        if ("Automated".equals(
                event.getMenuOption()) && (event.getMenuAction() == MenuAction.CC_OP || event.getMenuAction() == MenuAction.CC_OP_LOW_PRIORITY) && event.getItemId() > -1) {
            client.invokeWidgetAction(event.getId(), event.getParam1(), event.getParam0(), event.getItemId(),
                    event.getMenuTarget());
        } else {
            copy$menuAction(event.getParam0(), event.getParam1(),
                    event.getMenuAction() == UNKNOWN ? opcode : event.getMenuAction().getId(), event.getId(),
                    event.getItemId(), event.getMenuOption(), event.getMenuTarget(), canvasX, canvasY);
        }
    }

    @Inject
    @Override
    public MenuEntry createMenuEntry(String option, String target, int identifier, int opcode, int param1, int param2,
                                     boolean forceLeftClick) {
        return createMenuEntry(option, target, identifier, opcode, param1, param2,
                getItemId(identifier, opcode, param1, param2, -1), forceLeftClick);
    }


    @Inject
    public static HashMap<Integer, RSItemComposition> itemDefCache = new HashMap<>();

    @Inject
    private static boolean lowCpu;

    @Inject
    private static final int[] previousExp = new int[23];

    @Inject
    private static long lastMenuChange = -1;

    @Inject
    private static Instant lastInteractionTime = Instant.ofEpochMilli(0);

    @Inject
    public void interact(AutomatedMenu automatedMenu) {
        client.getCallbacks().post(Events.AUTOMATED_MENU, automatedMenu);
    }

    @Inject
    @Override
    public String getLoginMessage() {
        if (getLoginIndex() == 14) {

        }

        if (getLoginIndex() == 3) {
            return "Invalid credentials.";
        }

        return getLoginResponse1() + " " + getLoginResponse2() + " " + getLoginResponse3();
    }

    @Override
    @Inject
    public boolean isTileObjectValid(Tile tile, TileObject t) {
        if (!(t instanceof RSGameObject)) {
            return true;
        }

        // actors, projectiles, and graphics objects are added and removed from the scene each frame as GameObjects,
        // so ignore them.
        RSGameObject gameObject = (RSGameObject) t;
        RSRenderable renderable = gameObject.getRenderable();
        boolean invalid = renderable instanceof RSActor || renderable instanceof RSProjectile || renderable instanceof RSGraphicsObject;
        invalid |= gameObject.getStartX() != ((RSTile) tile).getX() || gameObject.getStartY() != ((RSTile) tile).getY();
        return !invalid;
    }

    @Inject
    @Override
    public boolean isItemDefinitionCached(int id) {
        return itemDefCache.containsKey(id);
    }

    @Inject
    @Override
    public boolean isLowCpu() {
        return lowCpu;
    }

    @Inject
    @Override
    public void setLowCpu(boolean enabled) {
        lowCpu = enabled;
    }

    @Copy("drawWidgets")
    @Replace("drawWidgets")
    static final void copy$drawWidgets(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
        if (!lowCpu) {
            copy$drawWidgets(var0, var1, var2, var3, var4, var5, var6, var7);
        }
    }

    @Copy("drawModelComponents")
    @Replace("drawModelComponents")
    static void copy$drawModelComponents(Widget[] var0, int var1) {
        if (!lowCpu) {
            copy$drawModelComponents(var0, var1);
        }
    }

    @Inject
    @Override
    public void uncacheItem(int id) {
        itemDefCache.remove(id);
    }

    @Inject
    @Override
    public void cacheItem(int id, ItemComposition item) {
        itemDefCache.put(id, (RSItemComposition) item);
    }

    @Inject
    @Override
    public void clearItemCache() {
        itemDefCache.clear();
    }

    @Inject
    @MethodHook("resumePauseWidget")
    public static void onDialogProcessed(int widgetUid, int menuIndex) {
        client.getCallbacks().post(Events.RESUME_PAUSE_SENT, new ResumePauseSent(widgetUid, menuIndex));
        DialogOption dialogOption = DialogOption.of(widgetUid, menuIndex);
        if (dialogOption != null) {
            client.getCallbacks().post(Events.DIALOG_PROCESSED, new DialogProcessed(dialogOption));
        }
    }

    @Inject
    @Override
    @Nonnull
    public ItemComposition getItemComposition(int id) {
        if (itemDefCache.containsKey(id)) {
            return itemDefCache.get(id);
        }

        assert this.isClientThread() : "getItemComposition must be called on client thread";
        RSItemComposition def = getRSItemDefinition(id);
        itemDefCache.put(id, def);
        return def;
    }

    @Inject
    @FieldHook("loginIndex")
    public static void loginIndex(int idx) {
        client.getCallbacks().post(Events.LOGIN_STATE_CHANGED, new LoginStateChanged(client.getLoginIndex()));
    }

    @FieldHook("experience")
    @Inject
    public static void experiencedChanged(int idx) {
        Skill[] possibleSkills = Skill.values();

        // We subtract one here because 'Overall' isn't considered a skill that's updated.
        if (idx < possibleSkills.length - 1) {
            Skill updatedSkill = possibleSkills[idx];
            StatChanged statChanged = new StatChanged(updatedSkill, client.getSkillExperience(updatedSkill),
                    client.getRealSkillLevel(updatedSkill), client.getBoostedSkillLevel(updatedSkill));
            if (previousExp[idx] == 0 && client.getSkillExperience(updatedSkill) > 0) {
                previousExp[idx] = client.getSkillExperience(updatedSkill);
            }

            experienceGained(idx, client.getSkillExperience(updatedSkill), client.getRealSkillLevel(updatedSkill),
                    updatedSkill);
            client.getCallbacks().post(Events.STAT_CHANGED, statChanged);
        }
    }

    @Inject
    public static void experienceGained(int idx, int exp, int skillLevel, Skill updatedSkill) {
        if (exp > previousExp[idx]) {
            int gained = exp - previousExp[idx];

            ExperienceGained experienceGained = new ExperienceGained(updatedSkill, gained, exp, skillLevel);

            client.getCallbacks().post(Events.EXPERIENCE_GAINED, experienceGained);
            previousExp[idx] = exp;
        }
    }

    @Inject
    @FieldHook("Client_plane")
    public static void clientPlaneChanged(int idx) {
        client.getCallbacks().post(Events.PLANE_CHANGED, new PlaneChanged(client.getPlane()));
    }

    @Inject
    public static RSRuneLiteMenuEntry newBareRuneliteMenuEntryTwo() {
        throw new NotImplementedException();
    }

    @Inject
    public static RSRuneLiteMenuEntry newRuneliteMenuEntryTwo(int idx) {
        throw new NotImplementedException();
    }

    @Inject
    @Override
    public void setPendingAutomation(AutomatedMenu replacement) {
        if (lastMenuChange + 20 > System.currentTimeMillis() && replacement != null) {
            return;
        }

        lastMenuChange = System.currentTimeMillis();
        automatedMenu.set(replacement);
    }

    @Inject
    @Override
    public AutomatedMenu getPendingAutomation() {
        if (lastMenuChange + 100 < System.currentTimeMillis() && automatedMenu.get() != null) {
            automatedMenu.set(null);
        }

        return automatedMenu.get();
    }

    @Inject
    public Instant getLastInteractionTime() {
        return lastInteractionTime;
    }

    @Inject
    @Override
    public void setKeyboardIdleTicks(int i) {
        getKeyHandler().setIdleCycles(i);
    }

    @Inject
    @Override
    public int getKeyboardIdleTicks() {
        return getKeyHandler().getIdleCycles$api();
    }

    @Inject
    @Override
    public boolean[] getPressedKeys() {
        return getKeyHandler().getPressedKeys();
    }

    // Kris's events

/*    @FieldHook("cameraShakeSpeed")
    @Inject
    public static void cameraShakeSpeedChange(int idx) {
        client.getCallbacks().post(Events.CAMERA_SHAKE_EVENT,
                new CameraShakeEvent(idx, client.cameraShakeIntensity()[idx], client.cameraMoveIntensity()[idx],
                        client.cameraShakeSpeed()[idx]));
    }*/

/*    @FieldHook("cameraShaking")
    @Inject
    public static void cameraShakingChange(int idx) {
        client.getCallbacks().post(Events.CAMERA_RESET_EVENT, new CameraResetEvent(idx));
    }*/

/*    @FieldHook("cameraMoveToAcceleration")
    @Inject
    public static void cameraMoveTo(int idx) {
        client.getCallbacks().post(Events.CAMERA_MOVE_TO_EVENT,
                new CameraMoveToEvent(client.cameraMoveToX(), client.cameraMoveToY(), client.cameraMoveToHeight(),
                        client.cameraMoveToSpeed(), client.cameraMoveToAcceleration()));
    }

    @FieldHook("cameraLookAtAcceleration")
    @Inject
    public static void cameraLookAt(int idx) {
        client.getCallbacks().post(Events.CAMERA_LOOK_AT_EVENT,
                new CameraLookAtEvent(client.cameraLookAtX(), client.cameraLookAtY(), client.cameraLookAtHeight(),
                        client.cameraLookAtSpeed(), client.cameraLookAtAcceleration()));
    }*/

    @Shadow("clips")
    static RSClips clips;

    @Inject
    @Override
    public int getRasterizer3D_clipNegativeMidX() {
        return clips.getClipNegativeMidX();
    }

    @Inject
    @Override
    public int getRasterizer3D_clipNegativeMidY() {
        return clips.getClipNegativeMidY();
    }

    @Inject
    @Override
    public void set3dZoom(int zoom) {
        clips.setViewportZoom(zoom);
        client.setScale(zoom);
    }

    @FieldHook("minimapState")
    @Inject
    public static void changeMinimapState(int idx) {
        client.getCallbacks().post(Events.MINIMAP_STATE_CHANGE, new MinimapStateChange(client.getMinimapState()));
    }


    @Inject
    @MethodHook("playJingle")
    public static void playJingle(int jingleId, int unused) {
        client.getCallbacks().post(Events.JINGLE_PLAYED, new JinglePlayed(jingleId));
    }

    @Inject
    @MethodHook(value = "performPlayerAnimation", end = true)
    public static void performPlayerAnimation(Player var0, int var1, int var2) {
        client.getCallbacks().post(Events.PLAYER_ANIMATION_PLAYED, new PlayerAnimationPlayed(var0, var1, var2));
    }

    @Copy("updatePendingSpawn")
    @Replace("updatePendingSpawn")
    @SuppressWarnings("InfiniteRecursion")
    public static void copy$updatePendingSpawn(int plane, int x, int y, int type, int id, int var5, int orientation,
                                               int opflags, int delay, int hitpoints) {
        copy$updatePendingSpawn(plane, x, y, type, id, var5, orientation, opflags, delay, hitpoints);
        client.getCallbacks().post(Events.PENDING_SPAWN_UPDATED,
                new PendingSpawnUpdated(plane, x, y, type, id, var5, orientation, opflags, delay, hitpoints));
    }

    @FieldHook("hintArrowNpcIndex")
    @Inject
    public static void hintNpcChanged(int idx) {
        client.getCallbacks()
                .post(Events.HINT_ARROW_EVENT, new HintArrowEvent(-1, client.getHintArrowNpcTargetIdx(), -1, -1, -1));
    }

    @FieldHook("hintArrowHeight")
    @Inject
    public static void tileHintArrowChanged(int idx) {
        client.getCallbacks().post(Events.HINT_ARROW_EVENT,
                new HintArrowEvent(-1, -1, client.getHintArrowX(), client.getHintArrowY(),
                        client.getHintArrowHeight()));
    }


    @Copy("itemContainerSetItem")
    @Replace("itemContainerSetItem")
    @SuppressWarnings("InfiniteRecursion")
    static void copy$setItemTableSlot(int invId, int slotId, int itemId, int quantity) {
        copy$setItemTableSlot(invId, slotId, itemId, quantity);
        client.getCallbacks()
                .post(Events.CONTAINER_ITEM_CHANGE, new ContainerItemChange(invId, slotId, itemId, quantity));
    }

    @Inject
    @MethodHook("getWidget")
    public static void postGetWidgetCall(int packedWidget) {
        latestWidgetCall = packedWidget;
    }

    @Inject
    static int latestWidgetCall;

    @Override
    @Inject
    public int getLatestWidgetCall() {
        return latestWidgetCall;
    }

    @Override
    @Inject
    public void setLatestWidgetCall(int value) {
        latestWidgetCall = value;
    }


    @Inject
    @FieldHook("rootInterface")
    public static void onRootInterfaceChange(int idx) {
        client.getCallbacks().post(Events.IF_OPEN_TOP_EVENT, new IfOpenTopEvent(client.getTopLevelInterfaceId()));
    }

    @Inject
    @FieldHook("runEnergy")
    public static void onRunEnergyChanged(int idx) {
        client.getCallbacks().post(Events.RUN_ENERGY_CHANGED_EVENT, new RunEnergyChangedEvent(client.getEnergy()));
    }

    @Inject
    @MethodHook(value = "ifOpenSub", end = true)
    public static void onSubInterfaceChange(int targetComponent, int interfaceId, int walkType) {
        client.getCallbacks()
                .post(Events.IF_OPEN_SUB_EVENT, new IfOpenSubEvent(targetComponent, interfaceId, walkType));
    }

    @Inject
    @MethodHook(value = "loadRegions", end = true)
    public static void onRegionLoad(boolean instanced, RSPacketBuffer buffer) {
        if (!instanced) {
            return;
        }
        client.getCallbacks().post(Events.REBUILD_REGION_EVENT, new RebuildRegionEvent());
    }

    @Inject
    @FieldHook("playerOptionsPriorities")
    public static void onPlayerMenuOptionChanged(int idx) {
        client.getCallbacks().post(Events.PLAYER_MENU_OPTIONS_CHANGED,
                new PlayerMenuOptionsChanged(idx, client.getPlayerOptions()[idx],
                        !client.getPlayerOptionsPriorities()[idx]));
    }

    @Inject
    public HashMap<Quest, QuestState> questStates = new HashMap<>();

    @Inject
    @Override
    public void setQuestState(Quest quest, QuestState questState) {
        questStates.put(quest, questState);
    }

    @Inject
    @Override
    public QuestState getQuestState(Quest quest) {
        return questStates.get(quest);
    }

    @Inject
    @Override
    public Object getDBTableField(int rowID, int column, int tupleIndex, int fieldIndex)
    {
        RSDbRowType dbRowType = client.getDbRowType(rowID);
        RSDbTableType dbTableType = client.getDbTableType(dbRowType.getTableId());

        Object[] columnType = dbRowType.getColumnType$api(column);
        int[] type = dbTableType.getTypes()[column];

        if (columnType == null)
        {
            columnType = dbTableType.getDefaultValues()[column];
        }

        if (columnType == null)
        {
            return null;
        }
        else if (tupleIndex >= type.length)
        {
            throw new IllegalArgumentException("tuple index too large");
        }
        else
        {
            if (fieldIndex > columnType.length / type.length)
            {
                throw new IllegalArgumentException("field index too large");
            }
            else
            {
                return columnType[tupleIndex * type.length + fieldIndex];
            }
        }
    }

    @Inject
    @Override
    public int getEnergy() {
        return getServerEnergy() / 100;
    }

    @Inject
    @Override
    public void sendClickPacket(java.awt.Point clickPoint) {
        callbacks.post(Events.SEND_CLICK_PACKET, new ClickPacket(clickPoint));
    }

    @Copy("shouldProcessClick")
    @Replace("shouldProcessClick")
    public boolean shouldProcessClick$mixin() {
        CheckClick checkClick = new CheckClick();
        client.getCallbacks().post(Events.CHECK_CLICK, checkClick);
        if (checkClick.getClickPoint() != null)
            sendClickPacket(checkClick.getClickPoint());
        return checkClick.getClickPoint() == null;
    }
}
