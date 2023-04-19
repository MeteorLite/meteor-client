package net.runelite.client.plugins.devtools;

import com.google.common.base.Preconditions;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Multimap;
import eventbus.events.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import meteor.Configuration;
import meteor.game.FontManager;
import meteor.rs.ClientThread;
import meteor.ui.ColorScheme;
import meteor.ui.components.DynamicGridLayout;
import net.runelite.api.*;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldArea;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.widgets.WidgetModalMode;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.commons.lang3.tuple.Triple;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import java.awt.*;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.io.*;
import java.lang.reflect.Field;
import java.nio.file.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Stream;

import static net.runelite.api.GameState.LOGGED_IN;

/**
 * @author Kris | 22/10/2021
 */
@SuppressWarnings({"DuplicatedCode", "SimplifyOptionalCallChains"})
@Slf4j
public class EventInspector extends EventInspectorSubscriber {

    private static final int VARBITS_ARCHIVE_ID = 14;
    private final Client client;
    private final ProjectileTracker projectileTracker;
    private final JPanel tracker = new JPanel();
    private int lastTick = 0;
    private final Map<Skill, Integer> cachedExperienceMap = new HashMap<>();
    private final Map<Skill, Integer> cachedBoostedLevelsMap = new HashMap<>();
    private final Map<Skill, Integer> cachedBaseLevelsMap = new HashMap<>();
    private final List<OverheadTextChanged> overheadChatList = new ArrayList<>();
    private final ClientThread clientThread;
    private int[] oldVarps = null;
    private int[] oldVarps2 = null;
    private boolean accessedObjectForAnimation = false;
    private Multimap<Integer, Integer> varbits;
    private final Set<Actor> facedActors = new HashSet<>();
    private final List<ProjectileSpawned> projectileSpawnedList = new ArrayList<>();
    private final Map<Actor, FaceTile> facedDirectionActors = new HashMap<>();
    private final Map<Player, Integer> playerTransformations = new HashMap<>();
    private final Map<Long, Set<Integer>> updatedIfEvents = new HashMap<>();
    private final Map<Actor, ExactMoveEvent> exactMoves = new HashMap<>();
    private final List<PendingSpawnUpdated> pendingSpawnList = new ArrayList<>();
    private final Map<WidgetNode, Pair<Long, Long>> ifMoveSubs = new HashMap<>();
    private final Map<Player, PlayerAppearance> appearances = new HashMap<>();
    private final Map<Integer, Integer> inventoryDiffs = new HashMap<>();
    private final Map<Actor, CombatLevelChangeEvent> combatLevelChanges = new HashMap<>();
    private final Map<NPC, NameChangeEvent> nameChanges = new HashMap<>();
    private final Map<Actor, RecolourEvent> tintingChanges = new HashMap<>();
    private final Map<Player, Pair<Integer, WorldPoint>> playerMovements = new HashMap<>();
    private final Map<Player, Pair<PlayerMoved, WorldPoint>> movementEvents = new HashMap<>();
    private final Map<NPC, Pair<NPCMoved, WorldPoint>> npcMovementEvents = new HashMap<>();
    private final Map<NPC, WorldPoint> previousNPCLocations = new HashMap<>();
    private final Set<Player> movementTrackedPlayers = new HashSet<>();
    private final Set<NPC> movementTrackedNpcs = new HashSet<>();
    private final Map<Integer, String> soundEffectNames = new HashMap<>(5000);
    private WidgetNode lastMoveSub;
    private long hashTableNodeGet1 = -1;
    private long hashTableNodeGet2 = -1;
    private int latestInventoryId = -1;

    private int widgetScrollY = -1;
    private String widgetText = null;
    private int widgetSequence = -1;
    private int widgetColor = -1;

    private int widgetZoom = -1;
    private int widgetAngleX = -1;
    private int widgetAngleY = -1;

    private int widgetPositionX = -1;
    private int widgetPositionY = -1;

    private int widgetModelId = -1;

    private int widgetItemId = -1;
    private int widgetItemQuantityOrModelId = -1;
    private boolean widgetObjectType;

    private boolean widgetSetPlayerHead = false;

    private int widgetModelRotation = -1;

    private Boolean widgetHidden = null;

    private boolean dirty = false;

    private int widgetNpcId = -1;
    private int previousRunEnergy = -1;

    private int latestServerTick;
    /* A set for ignored scripts. There are some plugins which invoke procs through the client which we ignore. */
    private final Set<Integer> ignoredClientScripts = ImmutableSet.<Integer>builder().add(4029).build();

    private final JCheckBox projectiles = new JCheckBox("Projectiles", true);
    private final JCheckBox spotanims = new JCheckBox("Spotanims", true);
    private final JCheckBox sequences = new JCheckBox("Sequences", true);
    private final JCheckBox soundEffects = new JCheckBox("Sound Effects", true);
    private final JCheckBox areaSoundEffects = new JCheckBox("Area Sound Effects", true);
    private final JCheckBox say = new JCheckBox("Say", true);
    private final JCheckBox experience = new JCheckBox("Experience", true);
    private final JCheckBox stats = new JCheckBox("Stats", true);
    private final JCheckBox runEnergy = new JCheckBox("Run Energy", true);
    private final JCheckBox instances = new JCheckBox("Instances", true);
    private final JCheckBox messages = new JCheckBox("Messages", true);
    private final JCheckBox varbitsCheckBox = new JCheckBox("Varbits", false);
    private final JCheckBox varpsCheckBox = new JCheckBox("Varps", false);
    private final JCheckBox hitsCheckBox = new JCheckBox("Hits", false);
    private final JCheckBox interacting = new JCheckBox("Entity Facing", false);
    private final JCheckBox tileFacing = new JCheckBox("Tile Facing", false);
    private final JCheckBox clientScripts = new JCheckBox("Clientscripts", false);
    private final JCheckBox exactMove = new JCheckBox("Exact Move", true);
    private final JCheckBox tinting = new JCheckBox("Tinting", true);
    private final JCheckBox combatChange = new JCheckBox("Combat Level Change", true);
    private final JCheckBox nameChange = new JCheckBox("Name", true);
    private final JCheckBox combinedObjects = new JCheckBox("Combined Objects", true);
    private final JCheckBox transformations = new JCheckBox("Transformations", true);
    private final JCheckBox appearancesCheckbox = new JCheckBox("Appearances", true);
    private final JCheckBox ifEvents = new JCheckBox("Interface Events", true);
    private final JCheckBox inventoryChanges = new JCheckBox("Inventories", false);
    private final JCheckBox graphicsObjectChanges = new JCheckBox("Spotanim Specific", true);
    private final JCheckBox jingles = new JCheckBox("Jingles", true);
    private final JCheckBox hintArrows = new JCheckBox("Hint Arrows", true);
    private final JCheckBox camera = new JCheckBox("Camera", true);
    private final JCheckBox minimapState = new JCheckBox("Minimap State", true);
    private final JCheckBox mapObjectAdd = new JCheckBox("Map Object Add", false);
    private final JCheckBox mapObjectDel = new JCheckBox("Map Object Del", false);
    private final JCheckBox mapObjectAnim = new JCheckBox("Map Object Anim", true);
    private final JCheckBox groundItemAdd = new JCheckBox("Ground Item Add", false);
    private final JCheckBox groundItemDel = new JCheckBox("Ground Item Del", false);
    private final JCheckBox groundItemUpdate = new JCheckBox("Ground Item Update", false);
    private final JCheckBox ifOpenTop = new JCheckBox("Top Interfaces", false);
    private final JCheckBox ifOpenSub = new JCheckBox("Sub Interfaces", false);
    private final JCheckBox ifCloseSub = new JCheckBox("Close Sub Interfaces", false);
    private final JCheckBox ifMoveSub = new JCheckBox("Move Sub Interfaces", false);
    private final JCheckBox miscInterfacePackets = new JCheckBox("Misc. Interface Packets", true);
    private final JCheckBox playerMenuOptions = new JCheckBox("Player Menu Options", true);

    private final JCheckBox movement = new JCheckBox("Player Walk, Run and Crawl", true);
    private final JCheckBox teleportation = new JCheckBox("Player Teleportation", true);
    private final JCheckBox npcMovement = new JCheckBox("NPC Walk, Run, Crawl and Teleport", true);
    private final JCheckBox playerCount = new JCheckBox("Player Count", true);
    private final JCheckBox npcCount = new JCheckBox("NPC Count", true);

    private final List<JCheckBox> allSettings = new ArrayList<>();

    private final JCheckBox localPlayerOnly = new JCheckBox("Local Player Only", false);
    private final JCheckBox pauseButton = new JCheckBox("Pause", false);
    private final JCheckBox rsCoordFormat = new JCheckBox("RS Coordinate Format", false);
    private final JCheckBox translateCoordsInInstance = new JCheckBox("Translate Instance Coords");
    private final JSlider intervalSlider;
    private final JSlider maxLogEntriesSlider;

    private int maxEventDistance = 104;
    private int writeInterval = 100;
    private int maxLogEntries = 1_000;

    private File outputFile;
    private int scrollSpeed = 15;

    private final File settingsFile = new File(Configuration.INSTANCE.getMETEOR_DIR().getAbsolutePath() + "/event-inspector-settings.txt");
    private final List<String> eventBuffer = new ArrayList<>(500);

    EventInspector(Client client, ClientThread clientThread, ProjectileTracker projectileTracker) {
        this.client = client;
        this.clientThread = clientThread;
        this.projectileTracker = projectileTracker;

        setTitle("Event Inspector");
        setLayout(new BorderLayout());
        tracker.setLayout(new DynamicGridLayout(0, 1, 0, 3));
        final JPanel trackerWrapper = new JPanel();
        trackerWrapper.setLayout(new BorderLayout());
        trackerWrapper.add(tracker, BorderLayout.NORTH);

        final JScrollPane trackerScroller = new JScrollPane(trackerWrapper);
        trackerScroller.setPreferredSize(new Dimension(1400, 300));

        trackerScroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        trackerScroller.getVerticalScrollBar().setUnitIncrement(scrollSpeed);
        trackerScroller.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        trackerScroller.getHorizontalScrollBar().setUnitIncrement(scrollSpeed);

        final JScrollBar vertical = trackerScroller.getVerticalScrollBar();
        vertical.addAdjustmentListener(new AdjustmentListener() {
            int lastMaximum = actualMax();

            private int actualMax() {
                return vertical.getMaximum() - vertical.getModel().getExtent();
            }

            @Override
            public void adjustmentValueChanged(AdjustmentEvent e) {
                if (vertical.getValue() >= lastMaximum) {
                    vertical.setValue(actualMax());
                }
                lastMaximum = actualMax();
            }
        });

        add(trackerScroller, BorderLayout.CENTER);


        final JPanel trackerOpts = new JPanel(new DynamicGridLayout(0, 1, 0, 3));
        trackerOpts.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 0, Color.BLACK));


        addZonePacketsPanel(trackerOpts);
        addMasksPanel(trackerOpts);
        addInterfacesPanel(trackerOpts);
        addMiscPanel(trackerOpts);

        trackerOpts.add(pauseButton);
        trackerOpts.add(localPlayerOnly);
        trackerOpts.add(rsCoordFormat);
        trackerOpts.add(translateCoordsInInstance);
        translateCoordsInInstance.setToolTipText("<html>When an event happens inside an instanced zone, the coordinates<br>" + "will be translated to where " +
                "they would be on the static game map.</html>");


        final JPanel sliderPanel = new JPanel(new BorderLayout());
        sliderPanel.setPreferredSize(new Dimension(230, 30));
        /* Manual spacing for string, cba messing around with layouts. */
        final JLabel distanceLabel = new JLabel("  Distance  ∞");
        sliderPanel.add(distanceLabel, BorderLayout.WEST);
        final JSlider slider = new JSlider(0, 15, 15);
        slider.setUI(new SliderUI(slider));
        slider.setPreferredSize(new Dimension(100, 30));
        sliderPanel.add(slider, BorderLayout.EAST);
        slider.addChangeListener(e -> {
            distanceLabel.setText("  Distance  " + (slider.getValue() == 15 ? "∞" : slider.getValue()));
            maxEventDistance = slider.getValue();
            if (maxEventDistance == 15) maxEventDistance = 104;
            writeSettingsFile();
        });
        trackerOpts.add(sliderPanel);

        final JPanel intervalSliderPanel = new JPanel(new BorderLayout());
        intervalSliderPanel.setPreferredSize(new Dimension(230, 30));
        /* Manual spacing for string, cba messing around with layouts. */
        final JLabel intervalLabel = new JLabel("  Interval  " + writeInterval);
        intervalSliderPanel.add(intervalLabel, BorderLayout.WEST);
        intervalSlider = new JSlider(0, 99, 99);
        intervalSlider.setUI(new SliderUI(intervalSlider));
        intervalSlider.setPreferredSize(new Dimension(100, 30));
        intervalSliderPanel.add(intervalSlider, BorderLayout.EAST);
        intervalSlider.addChangeListener(e -> {
            writeInterval = intervalSlider.getValue() + 1;
            intervalLabel.setText("  Interval  " + writeInterval);
            writeSettingsFile();
        });
        intervalSliderPanel.setToolTipText("<html>The interval slider defines how frequently, in server ticks(0.6 seconds each),<br>" + "the logs will be " +
                "written to the file</html>.");
        trackerOpts.add(intervalSliderPanel);

        final JPanel maxLogEntriesPanel = new JPanel(new BorderLayout());
        maxLogEntriesPanel.setPreferredSize(new Dimension(230, 30));
        /* Manual spacing for string, cba messing around with layouts. */
        final JLabel maxLogEntriesLabel = new JLabel("  Max Logs  " + maxLogEntries);
        maxLogEntriesPanel.add(maxLogEntriesLabel, BorderLayout.WEST);
        maxLogEntriesSlider = new JSlider(-1, 10_000, 1_000);
        maxLogEntriesSlider.setUI(new SliderUI(maxLogEntriesSlider));
        maxLogEntriesSlider.setPreferredSize(new Dimension(100, 30));
        maxLogEntriesPanel.add(maxLogEntriesSlider, BorderLayout.EAST);
        maxLogEntriesSlider.addChangeListener(e -> {
            maxLogEntries = maxLogEntriesSlider.getValue();
            maxLogEntriesLabel.setText("  Max Logs  " + maxLogEntries);
            writeSettingsFile();
        });
        maxLogEntriesPanel.setToolTipText("<html>The maximum log entries slider defines the maximum number of logs you would like to show.<br>" +
                "Set to -1 for no limit.</html>.");
        trackerOpts.add(maxLogEntriesPanel);

        final JPanel enableButtonPanel = new JPanel(new GridLayout());

        final JButton enabledAllButton = new JButton("Enable all");
        enabledAllButton.addActionListener(e -> changeJCheckBoxStatus(trackerOpts, true));
        enableButtonPanel.add(enabledAllButton);

        final JButton disableAllButton = new JButton("Disable all");
        disableAllButton.addActionListener(e -> changeJCheckBoxStatus(trackerOpts, false));
        enableButtonPanel.add(disableAllButton);
        trackerOpts.add(enableButtonPanel);

        final JPanel splitAndClearPanel = new JPanel(new GridLayout());

        final JButton splitButton = new JButton("Split logs");
        splitButton.addActionListener(e -> {
            synchronized (eventBuffer) {
                if (outputFile == null) return;
                writeToFile();
                resetOutputFile();
            }
        });

        final JButton clearBtn = new JButton("Clear");
        clearBtn.addActionListener(e -> {
            tracker.removeAll();
            tracker.revalidate();
        });
        splitAndClearPanel.add(splitButton);
        splitAndClearPanel.add(clearBtn);

        trackerOpts.add(splitAndClearPanel);

        final JButton openLogs = new JButton("Open Logs");
        openLogs.addActionListener(e -> {
            try {
                Path path = Paths.get(Configuration.INSTANCE.getMETEOR_DIR() + "/event-inspector-logs/");
                Desktop.getDesktop().open(path.toFile());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        trackerOpts.add(openLogs);

        add(trackerOpts, BorderLayout.EAST);

        for (Component component : trackerOpts.getComponents()) {
            if (!(component instanceof JCheckBox)) continue;
            if (component == pauseButton) continue;
            allSettings.add((JCheckBox) component);
            ((JCheckBox) component).addActionListener(e -> writeSettingsFile());
        }

        final JScrollPane scrollPane = new JScrollPane(trackerOpts);

        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.getVerticalScrollBar().setUnitIncrement(scrollSpeed);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        add(scrollPane, BorderLayout.EAST);

        pack();
    }

    private void changeJCheckBoxStatus(JPanel parent, boolean value) {
        for (Component component : parent.getComponents()) {
            if (component == pauseButton || component == localPlayerOnly || component == rsCoordFormat || component == translateCoordsInInstance) continue;
            if (component instanceof JCheckBox) {
                ((JCheckBox) component).setSelected(value);
            } else if (component instanceof JPanel) {
                changeJCheckBoxStatus((JPanel) component, value);
            }
        }
        writeSettingsFile();
    }

    private void addZonePacketsPanel(JPanel panel) {
        JLabel title = new JLabel("Zone Packets");
        title.setFont(new Font("Helvetica", Font.PLAIN, 14));
        panel.add(title);

        panel.add(projectiles);
        panel.add(areaSoundEffects);
        panel.add(combinedObjects);
        panel.add(graphicsObjectChanges);
        panel.add(mapObjectAdd);
        panel.add(mapObjectDel);
        panel.add(mapObjectAnim);
        panel.add(groundItemAdd);
        panel.add(groundItemDel);
        panel.add(groundItemUpdate);

        projectiles.setToolTipText("<html>" +
                "Projectile tracking works best from different distances with non-moving entities.<br>" +
                "Due to projectiles being pid-dependent, it is impossible to accurately decode their original values.<br>" +
                "There are simple heuristics used to determine the source of the projectile, which mostly comes down to<br>" +
                "ensuring the projectile's starting position collides with the given creature and that the creature us playing<br>" +
                "an animation at the time. There are other conditions at play.<br>" +
                "When a projectile is shot from a npc towards a player, the player's previous position is used to determine the distance<br>." +
                "For npc -> npc, or player -> player, it assumes the target has the higher pid(as in is processed first).<br>" +
                "The inspector uses most recent projectile data when decoding projectile's original values, so even if it messes up,<br>" +
                "it will simply need new data from different positions to give it another shot.<br>" +
                "With NPCs, it is unclear where the projectile calculations are done server-side, as it is often times from the south-western<br>" +
                "corner of the npc, but it can also be based on the actual difference between the two creatures, keeping their size in mind.<br>" +
                "With all these criteria in mind, the data provided by the tool should be taken with a grain of salt, as there are several things<br>" +
                "that can go wrong when decoding the original projectile values.<br>" +
                "It should be kept in mind however, that only the 'lengthAdjustment' and 'stepMultiplier' values could be off. Everything<br>" +
                "else provided by this tool will be accurate based on the packet's original values." +
                "</html>");
        combinedObjects.setToolTipText("<html>Combined Objects refer to objects which have their models merged with the players' model" + " to fix model " +
                "priority issues.<br>This is commonly used for agility shortcuts and obstacles, such as pipes.</html>");
    }

    private void addMasksPanel(JPanel panel) {
        JLabel title = new JLabel("Masks");
        title.setFont(new Font("Helvetica", Font.PLAIN, 14));
        panel.add(title);

        panel.add(appearancesCheckbox);
        panel.add(nameChange);
        panel.add(spotanims);
        panel.add(sequences);
        panel.add(say);
        panel.add(hitsCheckBox);
        panel.add(interacting);
        panel.add(tileFacing);
        panel.add(exactMove);
        panel.add(tinting);
        panel.add(combatChange);
        panel.add(transformations);
        appearancesCheckbox.setToolTipText("<html>Appearances will only track changes done to a player's appearance.<br>" + "Therefore, on initial " +
                "login/render of a character, everything about their appearance is logged, however,<br>" + "if they then equip an item for example, it'll " +
                "only display differences in the equipment/body, as nothing else would be different.</html>");
        tileFacing.setToolTipText("<html>Tile facing will only display the direction that the character is facing, not the precise coordinate<br>" + "they " +
                "were sent to face. This is because it is impossible to accurately determine which coordinate they're facing,<br>" + "as for example, facing " +
                "south sends a direction of 0 - this could mean a coordinate 1 tile south of the character, or 10 tiles.</html>");
        tinting.setToolTipText("<html>Tinting is used for Nex during the blood phase, to display the targeted player. It is also used for the " +
                "ancient godsword special attack.</html>");
        say.setToolTipText("<html>Say will only display actual \"forced chat\" messages, not player-invoked public chat.</html>");
    }

    private void addInterfacesPanel(JPanel panel) {
        JLabel title = new JLabel("Interface Packets");
        title.setFont(new Font("Helvetica", Font.PLAIN, 14));
        panel.add(title);

        panel.add(messages);
        panel.add(clientScripts);
        panel.add(ifEvents);
        panel.add(ifOpenTop);
        panel.add(ifOpenSub);
        panel.add(ifCloseSub);
        panel.add(ifMoveSub);
        panel.add(miscInterfacePackets);
        miscInterfacePackets.setToolTipText("<html>Miscellaneous interface packets refer to the following packets:<br>" + "IfSetHide<br>" + "IfSetPosition<br" +
                ">" + "IfSetScrollPos<br>" + "IfSetText<br>" + "IfSetAngle<br>" + "IfSetAnim<br>" + "IfSetColor<br>" + "IfSetModel<br>" + "IfSetObject<br>" + "IfModelRotate<br>" + "IfSetPlayerHead<br>" + "IfSetNpcHead</html>");
        messages.setToolTipText("<html>Messages may include plugin-created messages, and messages which plugins alter.</html>");
    }

    private void addMiscPanel(JPanel panel) {
        JLabel title = new JLabel("Misc Packets");
        title.setFont(new Font("Helvetica", Font.PLAIN, 14));
        panel.add(title);
        panel.add(instances);
        panel.add(inventoryChanges);
        panel.add(soundEffects);
        panel.add(jingles);
        panel.add(experience);
        panel.add(stats);
        panel.add(runEnergy);
        panel.add(varpsCheckBox);
        panel.add(varbitsCheckBox);
        panel.add(hintArrows);
        panel.add(camera);
        panel.add(minimapState);
        panel.add(playerMenuOptions);
        panel.add(movement);
        panel.add(teleportation);
        panel.add(npcMovement);
        panel.add(playerCount);
        panel.add(npcCount);
        panel.add(new JSeparator());
        instances.setToolTipText("<html>Instances will show each individual copied zone as a separate line below the header.<br>" +
                "It should be noted that the coordinates shown for instances are zone coordinates in X-Y-Z format,<br>" +
                "to get the absolute coordinates one has to multiply the X and Y values by 8.</html>");
        camera.setToolTipText("<html>Camera packets include:<br>" + "CamReset<br>" + "CamShake<br>" + "CamLookAt<br>" + "CamMoveTo<br></html>");
        playerMenuOptions.setToolTipText("<html>Player menu option's index is 0-indexed, therefore the first option will have an index of 0.</html>");
        inventoryChanges.setToolTipText("<html>Inventories will only send differences compared to the cached version of the inventory<br>" + "due to how " +
                "spammy the packet itself is in the events it transmits.</html>");
        movement.setToolTipText("<html>Movement will only record walking, running and crawling, and only within 15 tile radius around the local player" +
                ".</html>");
        teleportation.setToolTipText("<html>Teleportation will only record teleports that happen within 15 tile radius of the local player.</html>");
        playerCount.setToolTipText("<html>Shows the total number of players and the distance to the farthest one after each tick.</html>");
        npcCount.setToolTipText("<html>Shows the total number of NPCs and the distance to the farthest one after each tick.</html>");
    }

    private void addLine(String prefix, String text, boolean addToConsole, final JCheckBox checkBox) {
        addLine(prefix, text, client.getTickCount(), addToConsole, checkBox);
    }

    private void writeToFile() {
        if (outputFile == null) return;
        try {
            synchronized (eventBuffer) {
                if (eventBuffer.isEmpty()) return;
                BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile, true));
                for (String line : eventBuffer) {
                    writer.write(line);
                    writer.newLine();
                }
                writer.flush();
                writer.close();
                eventBuffer.clear();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onGameTick(GameTick event) {
        if (client.getTickCount() % writeInterval == 0) {
            ForkJoinPool.commonPool().submit(this::writeToFile);
        }
        final Player localPlayer = client.getLocalPlayer();
        if (localPlayer == null) return;
        List<Player> players = client.getPlayers();
        int farthestDistance = 0;
        final WorldArea localPlayerArea = localPlayer.getWorldArea();
        for (Player player : players) {
            final int distance = player.getWorldLocation().distanceTo(localPlayerArea);
            if (distance > farthestDistance) farthestDistance = distance;
        }
        addLine("Player count", "Count: " + players.size() + ", farthest distance: " + farthestDistance, client.getTickCount(), true, playerCount,
                playerCount.isSelected());

        List<NPC> npcs = client.getNpcs();
        farthestDistance = 0;
        for (NPC npc : npcs) {
            final int distance = npc.getWorldLocation().distanceTo(localPlayerArea);
            if (distance > farthestDistance) farthestDistance = distance;
        }
        addLine("NPC count", "Count: " + npcs.size() + ", farthest distance: " + farthestDistance, client.getTickCount(), true, npcCount,
                npcCount.isSelected());
    }

    private void addLine(String prefix, String text, int tick, boolean addToConsole, final JCheckBox checkBox) {
        addLine(prefix, text, tick, addToConsole, checkBox, true);
    }

    private void addLine(String prefix, String text, int tick, boolean addToConsole, final JCheckBox checkBox, final boolean logToFile) {
        final Date date = new Date();

        SwingUtilities.invokeLater(() -> {
            if (logToFile) {
                synchronized (eventBuffer) {
                    eventBuffer.add(String.format(rsCoordFormat.isSelected() ? "%-125s" : "%-100s", "[" + tick + "] " + new SimpleDateFormat("yyyy-MM-dd " + "HH:mm:ss").format(date) + " " + prefix) + text);
                    if (eventBuffer.size() >= 500) {
                        writeToFile();
                    }
                }
            }
            /* Log it externally here anyways */
            if (!addToConsole || (checkBox != null && !checkBox.isSelected()) || pauseButton.isSelected()) return;
            if (tick != lastTick) {
                lastTick = tick;
                JLabel header = new JLabel("Tick " + tick);
                header.setFont(FontManager.INSTANCE.getRunescapeSmallFont());
                header.setBorder(
                        new CompoundBorder(
                                BorderFactory.createMatteBorder(0, 0, 1, 0, ColorScheme.INSTANCE.getLIGHT_GRAY_COLOR()),
                                BorderFactory.createEmptyBorder(3, 6, 0, 0)
                        )
                );
                tracker.add(header);
            }

            JPanel labelPanel = new JPanel();
            labelPanel.setLayout(new BorderLayout());
            JTextField prefixLabel = new JTextField(prefix);
            prefixLabel.setEditable(false);
            prefixLabel.setCaretPosition(0);
            prefixLabel.setBackground(null);
            prefixLabel.setToolTipText(prefix);
            prefixLabel.setBorder(
                    new CompoundBorder(
                            BorderFactory.createMatteBorder(0, 0, 0, 1, ColorScheme.INSTANCE.getLIGHT_GRAY_COLOR()),
                            BorderFactory.createEmptyBorder(0, 5, 0, 0)
                    )
            );
            prefixLabel.setPreferredSize(new Dimension(rsCoordFormat.isSelected() ? 850 : 650, 14));
            prefixLabel.setMaximumSize(new Dimension(rsCoordFormat.isSelected() ? 850 : 650, 14));

            JTextField textLabel = new JTextField(text);
            textLabel.setEditable(false);
            textLabel.setCaretPosition(0);
            textLabel.setBackground(null);
            textLabel.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 0));

            labelPanel.add(prefixLabel, BorderLayout.WEST);
            labelPanel.add(textLabel);
            tracker.add(labelPanel);
            dirty = true;
        });
    }

    private int getDistance(LocalPoint localPoint) {
        return getDistance(fromLocal(client, localPoint));
    }

    private int getDistance(WorldPoint worldPoint) {
        final Player localPlayer = client.getLocalPlayer();
        if (localPlayer == null) return 0;
        return localPlayer.getWorldLocation().distanceTo2D(worldPoint);
    }

    private boolean isActorConsoleLogged(Actor actor) {
        if (actor instanceof Player) {
            if (localPlayerOnly.isSelected()) {
                if (actor != client.getLocalPlayer()) return false;
            }
        }
        if (actor == null) return true;
        return getDistance(actor.getWorldLocation()) <= maxEventDistance;
    }

    private boolean inEventDistance(LocalPoint localPoint) {
        return getDistance(localPoint) <= maxEventDistance;
    }

    private boolean inEventDistance(WorldPoint worldPoint) {
        return getDistance(worldPoint) <= maxEventDistance;
    }

    @Override
    public void onProjectileSpawned(ProjectileSpawned event) {
        projectileSpawnedList.add(event);
    }

    @Override
    public void onGraphicChanged(GraphicChanged event) {
        Actor actor = event.getActor();
        String actorLabel = formatActor(actor);
        StringBuilder graphicsLabelBuilder = new StringBuilder();
        graphicsLabelBuilder.append("Graphics(");
        String name = getName(NamedVariableType.Graphics, actor.getGraphic() == 65535 ? -1 : actor.getGraphic());
        if (name != null) {
            graphicsLabelBuilder.append("name = ").append(name);
        } else {
            graphicsLabelBuilder.append("id = ").append(actor.getGraphic() == 65535 ? -1 : actor.getGraphic());
        }
/*        final int delay = actor.getGraphicStartCycle() - client.getGameCycle();
        if (delay != 0) graphicsLabelBuilder.append(", delay = ").append(delay);*/
        if (actor.getGraphicHeight() != 0) graphicsLabelBuilder.append(", height = ").append(actor.getGraphicHeight());
        graphicsLabelBuilder.append(")");
        addLine(actorLabel, graphicsLabelBuilder.toString(), isActorConsoleLogged(actor), spotanims);
    }

    /**
     * Npc sequence changes need to be tracked through this method which is almost perfect, but there are
     * edge cases where if the animation matches the already-playing animation, the field hook may not get invoked.
     * For players, as the mask calls another function, we run this through another, always-executed function.
     */
    @Override
    public void onAnimationFrameIndexChanged(AnimationFrameIndexChanged event) {
        Actor actor = event.getActor();
        if (actor == null || actor instanceof Player || actor.getAnimationFrameIndex() != 0 || actor.getName() == null || isActorPositionUninitialized(actor))
            return;
        postSequenceUpdate(actor, actor.getAnimation() == 65535 ? -1 : actor.getAnimation(), actor.getAnimationDelay());
    }

    @Override
    public void onPlayerAnimationPlayed(PlayerAnimationPlayed event) {
        Actor actor = event.getPlayer();
        if (actor == null || actor.getName() == null || isActorPositionUninitialized(actor)) return;
        postSequenceUpdate(event.getPlayer(), event.getId(), event.getDelay());
    }

    private void postSequenceUpdate(Actor actor, int id, int delay) {
        String actorLabel = formatActor(actor);
        StringBuilder animationLabelBuilder = new StringBuilder();
        animationLabelBuilder.append("Animation(");
        String name = getName(NamedVariableType.Animation, id);
        if (name != null) {
            animationLabelBuilder.append("name = ").append(name);
        } else {
            animationLabelBuilder.append("id = ").append(id);
        }
        if (delay != 0) animationLabelBuilder.append(", delay = ").append(delay);
        animationLabelBuilder.append(")");
        addLine(actorLabel, animationLabelBuilder.toString(), isActorConsoleLogged(actor), sequences);
    }

    private String formatLocation(WorldPoint point) {
        return formatLocation(point.getX(), point.getY(), point.getPlane(), false);
    }

    private String formatLocationOmitDecorations(WorldPoint point) {
        return formatLocation(point.getX(), point.getY(), point.getPlane(), true);
    }

    private WorldPoint fromLocal(Client client, LocalPoint localPoint) {
        WorldPoint point = WorldPoint.fromLocal(client, localPoint);
        /* The above function seems to return invalid coordinates during teleportations, therefore let's sanitize the values. */
        int x = point.getX() & 0x3FFF;
        int y = point.getY() & 0x3FFF;
        int z = point.getPlane() & 0x3;
        return new WorldPoint(x, y, z);
    }

    private String formatLocation(final int dirtyX, final int dirtyY, final int z, boolean omitDecorations) {
        /* The RL functions for getting coordinates can return invalid values during map reload, therefore sanitize these. */
        final int x = dirtyX & 0x3FFF;
        final int y = dirtyY & 0x3FFF;
        LocalPoint localPoint = LocalPoint.fromWorld(client, x, y);
        final boolean isInInstance = x >= 6400;
        final WorldPoint baseMapPoint = localPoint == null ? null : WorldPoint.fromLocalInstance(client, localPoint, z);
        if (rsCoordFormat.isSelected()) {
            final StringBuilder builder = new StringBuilder();
            if (!omitDecorations) builder.append("Location(");
            if (isInInstance && baseMapPoint != null && translateCoordsInInstance.isSelected()) {
                final int msqx = (baseMapPoint.getX() & 0x3FFF) >> 6;
                final int msqz = (baseMapPoint.getY() & 0x3FFF) >> 6;
                final int tx = baseMapPoint.getX() & 0x3F;
                final int tz = baseMapPoint.getY() & 0x3F;
                builder.append("level = ").append(z).append(", msqx = ").append(msqx).append(", msqz = ").append(msqz).append(", tx = ").append(tx).append("," +
                        " tz = ").append(tz);
                builder.append(", instanced = true");
            } else {
                final int msqx = x >> 6;
                final int msqz = y >> 6;
                final int tx = x & 0x3F;
                final int tz = y & 0x3F;
                builder.append("level = ").append(z).append(", msqx = ").append(msqx).append(", msqz = ").append(msqz).append(", tx = ").append(tx).append("," +
                        " tz = ").append(tz);
            }
            if (!omitDecorations) builder.append(")");
            return builder.toString();
        } else {
            final StringBuilder builder = new StringBuilder();
            if (!omitDecorations) builder.append("Location(");
            if (isInInstance && baseMapPoint != null && translateCoordsInInstance.isSelected()) {
                builder.append("x = ").append(baseMapPoint.getX()).append(", y = ").append(baseMapPoint.getY()).append(", z = ").append(baseMapPoint.getPlane());
                builder.append(", instanced = true");
            } else {
                builder.append("x = ").append(x).append(", y = ").append(y).append(", z = ").append(z);
            }
            if (!omitDecorations) builder.append(")");
            return builder.toString();
        }
    }

    @Override
    public void onHintArrowEvent(HintArrowEvent event) {
        final int type = client.getHintArrowTargetType();
        switch (type) {
            /* Type 1 is for npc hint arrows */
            case 1:
                final NPC npc = client.getHintArrowNpc();
                addLine(npc == null ? "Out of boundaries hint arrow" : formatActor(npc),
                        "HintArrow(type = Npc, index = " + client.getHintArrowNpcTargetIdx() + ")", isActorConsoleLogged(npc), hintArrows);
                break;
            /* Type 1 is for player hint arrows */
            case 10:
                final Player player = client.getHintArrowPlayer();
                addLine(player == null ? "Out of boundaries hint arrow" : formatActor(player),
                        "HintArrow(type = Player, index = " + client.getHintArrowPlayerTargetIdx() + ")", isActorConsoleLogged(player), hintArrows);
                break;
            default:
                final LocalPoint localPoint = LocalPoint.fromScene(event.getHintArrowX(), event.getHintArrowY());
                final WorldPoint worldPoint = fromLocal(client, localPoint);
                addLine("Hint arrow" + type, "HintArrow(type = " + type + ", " + formatLocation(worldPoint) + ")", inEventDistance(localPoint), hintArrows);
                break;
        }
    }

    @Override
    public void onCameraResetEvent(CameraResetEvent event) {
        /* Since only the packet resets camera shaking, and because it is done in a loop, only accept the first one. */
        if (event.getId() != 0) return;
        addLine("Camera reset", "CamReset", true, camera);
    }

    @Override
    public void onCameraShakeEvent(CameraShakeEvent event) {
        addLine("Camera shake",
                "CamShake(type = " + event.getType() + ", shakeIntensity = " + event.getShakeIntensity() + ", movementIntensity = " + event.getMovementIntensity() + ", speed = " + event.getSpeed() + ")", true, camera);
    }

    @Override
    public void onCameraLookAtEvent(CameraLookAtEvent event) {
        final LocalPoint localPoint = LocalPoint.fromScene(event.getCameraLookAtX() & 0xFF, event.getCameraLookAtY() & 0xFF);
        final WorldPoint worldPoint = fromLocal(client, localPoint);
        addLine("Camera look at",
                "CamLookAt(" + formatLocation(worldPoint) + ", " + "height = " + event.getCameraLookAtHeight() + ", speed = " + event.getCameraLookAtSpeed() + ", " + "acceleration = " + event.getCameraLookAtAcceleration() + ")", true, camera);
    }

    @Override
    public void onCameraMoveToEvent(CameraMoveToEvent event) {
        final LocalPoint localPoint = LocalPoint.fromScene(event.getCameraMoveToX() & 0xFF, event.getCameraMoveToY() & 0xFF);
        final WorldPoint worldPoint = fromLocal(client, localPoint);
        addLine("Camera move to",
                "CamMoveTo(" + formatLocation(worldPoint) + ", " + "height = " + event.getCameraMoveToHeight() + ", speed = " + event.getCameraMoveToSpeed() + ", " + "acceleration = " + event.getCameraMoveToAcceleration() + ")", true, camera);
    }

    @Override
    public void onMinimapStateChange(MinimapStateChange event) {
        final MinimapState state = MinimapState.getState(event.getState());
        addLine("Minimap status change", "MinimapToggle(state = " + (state == null ? event.getState() : state) + ")", true, minimapState);
    }

    @Override
    public void onSoundEffectReceived(SoundEffectReceived event) {
        final int soundId = event.getId();
        final int delay = event.getDelay();
        final int loops = event.getRepetitions();
        StringBuilder soundEffectBuilder = new StringBuilder();
        soundEffectBuilder.append("SoundEffect(");
        String mappedName = getName(NamedVariableType.Sound, soundId);
        String prefix;
        if (mappedName != null) {
            prefix = "Local sound";
            soundEffectBuilder.append("name = ").append(mappedName);
        } else {
            String name = soundEffectNames.get(soundId);
            if (name == null) {
                prefix = "Local sound";
                soundEffectBuilder.append("id = ").append(soundId);
            } else {
                prefix = "Local sound(id = " + soundId + ")";
                soundEffectBuilder.append("name = \"").append(name).append('"');
            }
        }
        if (delay != 0) soundEffectBuilder.append(", delay = ").append(delay);
        if (loops != 1) soundEffectBuilder.append(", repetitions = ").append(loops);
        soundEffectBuilder.append(")");
        addLine(prefix, soundEffectBuilder.toString(), true, soundEffects);
    }

    @Override
    public void onAreaSoundEffectPlayed(AreaSoundEffectPlayed event) {
        /* Animation-driven sounds will always have the source set to non-null, however that information is useless to us so skip it. */
        if (event.getSource() != null) return;
        final int soundId = event.getSoundId();
        final int delay = event.getDelay();
        final int loops = event.getLoops();
        final int radius = event.getRange();
        StringBuilder soundEffectBuilder = new StringBuilder();
        soundEffectBuilder.append("SoundEffect(");
        String prefix;
        String mappedName = getName(NamedVariableType.Sound, soundId);
        if (mappedName != null) {
            prefix = "Area sound";
            soundEffectBuilder.append("name = ").append(mappedName);
        } else {
            String name = soundEffectNames.get(soundId);
            if (name == null) {
                prefix = "Area sound";
                soundEffectBuilder.append("id = ").append(soundId);
            } else {
                prefix = "Area sound(id = " + soundId + ")";
                soundEffectBuilder.append("name = \"").append(name).append('"');
            }
        }
        if (radius != 0) soundEffectBuilder.append(", radius = ").append(radius);
        if (delay != 0) soundEffectBuilder.append(", delay = ").append(delay);
        if (loops != 1) soundEffectBuilder.append(", repetitions = ").append(loops);
        soundEffectBuilder.append(")");
        WorldPoint location = fromLocal(client, LocalPoint.fromScene(event.getSceneX(), event.getSceneY()));
        Optional<Player> sourcePlayer = client.getPlayers().stream().filter(player -> player.getWorldLocation().distanceTo(location) == 0).findAny();
        Optional<NPC> sourceNpc = client.getNpcs().stream().filter(npc -> npc.getWorldLocation().distanceTo(location) == 0).findAny();
        if (sourcePlayer.isPresent() && !sourceNpc.isPresent()) {
            addLine(prefix + ", " + formatActor(sourcePlayer.get()), soundEffectBuilder.toString(), isActorConsoleLogged(sourcePlayer.get()), areaSoundEffects);
        } else if (sourceNpc.isPresent() && !sourcePlayer.isPresent()) {
            addLine(prefix + ", " + formatActor(sourceNpc.get()), soundEffectBuilder.toString(), isActorConsoleLogged(sourceNpc.get()), areaSoundEffects);
        } else {
            addLine(prefix + ", " + "Unknown(" + formatLocation(location) + ")", soundEffectBuilder.toString(), inEventDistance(location), areaSoundEffects);
        }
    }

    @Override
    public void onOverheadTextChanged(OverheadTextChanged event) {
        Actor actor = event.getActor();
        if (actor == null) return;
        overheadChatList.add(event);
        latestServerTick = client.getTickCount();
    }

    @Override
    public void onRebuildRegionEvent(RebuildRegionEvent event) {
        final String formattedLocation = this.formatLocation(new WorldPoint(client.getBaseX(), client.getBaseY(), client.getPlane()));
        addLine("Local", "RebuildRegion(base = " + formattedLocation + ")", true, instances);
        final int[][][] templates = client.getInstanceTemplateChunks();
        final int baseZoneX = client.getBaseX() >> 3;
        final int baseZoneY = client.getBaseY() >> 3;
        for (int z = 0; z < 4; ++z) {
            for (int x = 0; x < 13; ++x) {
                for (int y = 0; y < 13; ++y) {
                    int toX = baseZoneX + x;
                    int toY = baseZoneY + y;
                    final int copiedZone = templates[z][x][y];
                    if (copiedZone == -1) continue;
                    final int rotation = copiedZone >> 1 & 0x3;
                    final int copiedZ = copiedZone >> 24 & 0x3;
                    final int copiedX = copiedZone >> 14 & 0x3FF;
                    final int copiedY = copiedZone >> 3 & 0x7FF;
                    addLine("Local", "Zone(toZone = Zone(zoneX = " + toX + ", zoneY = " + toY + ", z = " + z + "), " +
                            "fromZone = Zone(zoneX = " + copiedX + ", zoneY = " + copiedY + ", z = " + copiedZ + "), rotation = " + rotation + ")", true, instances);
                }
            }
        }
    }

    @Override
    public void onRunEnergyChangedEvent(RunEnergyChangedEvent event) {
        if (this.previousRunEnergy == -1) {
            this.previousRunEnergy = event.getNewEnergy();
            return;
        }
        addLine("Local(previous = " + this.previousRunEnergy + ")", "RunEnergy(value = " + event.getNewEnergy() + ")", true, runEnergy);
        this.previousRunEnergy = event.getNewEnergy();
    }

    /**
     * Due to the annoying nature of how overhead chat is handled by the client, the only way we can detect if a message was actually server-driven
     * or player-driven is to see if another field was changed shortly after. This strictly applies for player public chat, therefore it
     * works great as a means to detect overhead chat messages.
     */
    @Override
    public void onShowPublicPlayerChatChanged(ShowPublicPlayerChatChanged event) {
        if (!overheadChatList.isEmpty()) {
            OverheadTextChanged element = overheadChatList.get(overheadChatList.size() - 1);
            overheadChatList.remove(element);
        }
    }

    @Override
    public void onStatChanged(StatChanged event) {
        final int previousExperience = cachedExperienceMap.getOrDefault(event.getSkill(), -1);
        cachedExperienceMap.put(event.getSkill(), event.getXp());
        final int previousBoostedLevel = cachedBoostedLevelsMap.getOrDefault(event.getSkill(), -1);
        cachedBoostedLevelsMap.put(event.getSkill(), event.getBoostedLevel());
        final int previousBaseLevel = cachedBaseLevelsMap.getOrDefault(event.getSkill(), -1);
        cachedBaseLevelsMap.put(event.getSkill(), event.getLevel());
        if (previousExperience != -1) {
            final int experienceDiff = event.getXp() - previousExperience;
            if (experienceDiff != 0) {
                addLine("Local", "Experience(skill = " + event.getSkill().getName() + ", xp = " + experienceDiff + ")", true, experience);
            }
        }
        if (previousBoostedLevel != event.getBoostedLevel() || previousBaseLevel != event.getLevel()) {
            addLine("Stat(previous = " + previousBoostedLevel + "/" + previousBaseLevel + ")", "StatChange(skill = " + event.getSkill().getName() + ", level = " + event.getBoostedLevel() + "/" + event.getLevel() + ")", true, stats);
        }
    }

    @Override
    public void onChatMessage(ChatMessage event) {
        ChatMessageType type = event.getType();
        String name = event.getName();
        if (name != null && !name.isEmpty()) {
            return;
        }
        addLine("Local", "Message(type = " + type + ", text = \"" + event.getMessage() + "\")", true, messages);
    }

    @SuppressWarnings("StringBufferReplaceableByString")
    @Override
    public void onClientTick(ClientTick event) {
        if (dirty) {
            dirty = false;
            SwingUtilities.invokeLater(() -> {
                // Cull very old stuff
                while (maxLogEntries > 0 && tracker.getComponentCount() > maxLogEntries) {
                    tracker.remove(0);
                }

                tracker.revalidate();
            });
        }
        latestInventoryId = -1;
        /* Reset animation access as it may not have been reset manually due to a null check in the function. */
        accessedObjectForAnimation = false;
        if (!facedActors.isEmpty()) facedActors.clear();
        if (!facedDirectionActors.isEmpty()) {
            facedDirectionActors.forEach((faceDirectionActor, value) -> {
                if (faceDirectionActor == null || isActorPositionUninitialized(faceDirectionActor)) return;
                addLine(formatActor(faceDirectionActor), "FaceCoordinate(direction = " + value.direction + ", instant = " + value.instant + ")",
                        latestServerTick, isActorConsoleLogged(faceDirectionActor), tileFacing);
            });
            facedDirectionActors.clear();
        }
        if (!overheadChatList.isEmpty()) {
            for (OverheadTextChanged message : overheadChatList) {
                String text = message.getOverheadText();
                addLine(formatActor(message.getActor()), "Say(text = \"" + text + "\")", latestServerTick, isActorConsoleLogged(message.getActor()), say);
            }
            overheadChatList.clear();
        }
        if (!combatLevelChanges.isEmpty()) {
            combatLevelChanges.forEach((actor, change) -> {
                if (actor == null || isActorPositionUninitialized(actor) || change.getOldCombatLevel() == change.getNewCombatLevel()) return;
                String combatChange = "CombatLevelChange(previousLevel = " + change.getOldCombatLevel() + ", newLevel = " + change.getNewCombatLevel() + ")";
                addLine(formatActor(actor), combatChange, isActorConsoleLogged(actor), this.combatChange);
            });
            combatLevelChanges.clear();
        }

        if (!nameChanges.isEmpty()) {
            nameChanges.forEach((actor, change) -> {
                if (actor == null || isActorPositionUninitialized(actor)) return;
                String nameChange = "Name(previousName = " + change.getOldName() + ", newName = " + change.getNewName() + ")";
                addLine(formatActor(actor), nameChange, isActorConsoleLogged(actor), this.nameChange);
            });
            nameChanges.clear();
        }

        if (!tintingChanges.isEmpty()) {
            tintingChanges.forEach((actor, change) -> {
                if (actor == null || isActorPositionUninitialized(actor)) return;
                final int currentCycle = change.getCurrentCycle();
                final int delay = change.getRecolourStartCycle() - currentCycle;
                final int duration = (change.getRecolourEndCycle() - currentCycle) - delay;
                String recolourBuilder = "Tinting(" + "hue = " + change.getRecolourHue() + ", " + "saturation = " + change.getRecolourSaturation() + ", "
                        + "luminance = " + change.getRecolourLuminance() + ", "
                        + "opacity = " + change.getRecolourAmount() + ", "
                        + "delay = " + delay + ", "
                        + "duration = " + duration + ")";
                addLine(formatActor(actor), recolourBuilder, isActorConsoleLogged(actor), tinting);
            });
            tintingChanges.clear();
        }
        if (!updatedIfEvents.isEmpty()) {
            updatedIfEvents.forEach((packedKey, slots) -> {
                final int events = packedKey.intValue();

                final int interfaceId = (int) ((packedKey >> 48) & 0xFFFF);
                final int componentId = (int) ((packedKey >> 32) & 0xFFFF);

                for (Pair<Integer, Integer> range : getSlotRanges(new ArrayList<>(slots))) {
                    final StringBuilder eventBuilder = new StringBuilder();
                    eventBuilder.append("IfSetEvents(");
                    String name = getName(NamedVariableType.Interface, interfaceId);
                    if (name != null) {
                        eventBuilder.append("interface = ").append(name).append(", ");
                    } else {
                        eventBuilder.append("interfaceId = ").append(interfaceId).append(", ");
                    }
                    eventBuilder.append("componentId = ").append(componentId).append(", ");
                    eventBuilder.append("startIndex = ").append(range.getLeft()).append(", ");
                    eventBuilder.append("endIndex = ").append(range.getRight()).append(", ");
                    eventBuilder.append("events = ").append(InterfaceEvent.sanitize(events)).append(")");
                    addLine("Interface event", eventBuilder.toString(), latestServerTick, true, ifEvents);
                }
            });
            updatedIfEvents.clear();
        }
        if (!pendingSpawnList.isEmpty()) {
            for (PendingSpawnUpdated update : pendingSpawnList) {
                final LocalPoint localPoint = LocalPoint.fromScene(update.getX(), update.getY());
                final WorldPoint location = fromLocal(client, localPoint);
                /* Object id -1 implies an object removal. */
                if (update.getId() == -1) {
                    if (mapObjectDel.isSelected()) {
                        final StringBuilder locDelBuilder = new StringBuilder();
                        locDelBuilder.append("LocDel(");
                        locDelBuilder.append("slot = ").append(update.getType()).append(", ");
                        locDelBuilder.append("rotation = ").append(update.getOrientation()).append(", ");
                        locDelBuilder.append(formatLocation(location)).append(")");
                        addLine("Delete map object", locDelBuilder.toString(), latestServerTick, inEventDistance(localPoint), mapObjectDel);
                    }
                } else if (mapObjectAdd.isSelected()) {
                    final StringBuilder locAddBuilder = new StringBuilder();
                    locAddBuilder.append("LocAdd(");
                    String name = getName(NamedVariableType.Object, update.getId());
                    if (name != null) {
                        locAddBuilder.append("name = ").append(name).append(", ");
                    } else {
                        locAddBuilder.append("id = ").append(update.getId()).append(", ");
                    }
                    locAddBuilder.append("slot = ").append(update.getType()).append(", ");
                    locAddBuilder.append("rotation = ").append(update.getOrientation()).append(", ");
                    locAddBuilder.append("opflags = ").append(update.getOpflags()).append(", ");
                    locAddBuilder.append(formatLocation(location)).append(")");
                    addLine("Add map object", locAddBuilder.toString(), latestServerTick, inEventDistance(localPoint), mapObjectAdd);
                }
            }
            pendingSpawnList.clear();
        }
        if (!ifMoveSubs.isEmpty()) {
            if (ifMoveSub.isSelected()) {
                ifMoveSubs.forEach((node, value) -> {
                    final long fromTopInterfacePacked = value.getLeft();
                    final long packedInterface = value.getRight();
                    String interfaceName = getName(NamedVariableType.Interface, node.getId());
                    if (interfaceName == null) interfaceName = "" + node.getId();
                    String fromTopInterface = getName(NamedVariableType.Interface, (int) (fromTopInterfacePacked >> 16));
                    if (fromTopInterface == null) fromTopInterface = "" + (fromTopInterfacePacked >> 16);
                    String toTopInterface = getName(NamedVariableType.Interface, (int) (packedInterface >> 16));
                    if (toTopInterface == null) toTopInterface = "" + (packedInterface >> 16);
                    addLine("Move interface (id = " + interfaceName + ", modal = " + (node.getModalMode() == WidgetModalMode.MODAL_NOCLICKTHROUGH) + ")",
                            "IfMoveSub(" + "fromTopInterface = " + fromTopInterface + ", "
                                    + "fromTopComponent = " + (fromTopInterfacePacked & 0xFFFF) + ", "
                                    + "toTopInterface = " + toTopInterface + ", "
                                    + "toTopComponent = " + (packedInterface & 0xFFFF) + ")", latestServerTick, true, ifMoveSub);
                });
            }
            ifMoveSubs.clear();
        }
        if (!movementEvents.isEmpty()) {
            movementTrackedPlayers.removeIf(player -> getDistance(player.getWorldLocation()) > 15);
            for (Pair<PlayerMoved, WorldPoint> pair : movementEvents.values()) {
                final PlayerMoved movementEvent = pair.getLeft();
                final WorldPoint previousLocation = pair.getRight();
                final LocalPoint localDestination = LocalPoint.fromScene(movementEvent.getX(), movementEvent.getY());
                final WorldPoint destination = fromLocal(client, localDestination);
                playerMovements.put(movementEvent.getPlayer(), Pair.of(client.getTickCount(), previousLocation));
                final int distance = getDistance(localDestination);
                final boolean isLocalPlayer = movementEvent.getPlayer() == client.getLocalPlayer();
                if (!isLocalPlayer && (distance > 15 || movementEvent.getPlayer().getPlane() != client.getPlane())) continue;
                /* Any players that were just added to the tracked players list can't be relied on for valid info. */
                if (!isLocalPlayer && movementTrackedPlayers.add(movementEvent.getPlayer())) continue;
                if (movementEvent.getType() == 127) {
                    addLine(formatActor(movementEvent.getPlayer(), previousLocation), "Teleport(" + formatLocation(destination) + ")",
                            isActorConsoleLogged(movementEvent.getPlayer()), teleportation);
                } else {
                    String type = movementEvent.getType() == 0 ? "Crawl" : movementEvent.getType() == 1 ? "Walk" : movementEvent.getType() == 2 ? "Run" :
                            "Teleport";
                    addLine(formatActor(movementEvent.getPlayer(), previousLocation), "Movement(type = " + (type) +
                            ", " + formatLocation(destination) + ")", isActorConsoleLogged(movementEvent.getPlayer()), movement);
                }
            }
            movementEvents.clear();
        }
        if (!npcMovementEvents.isEmpty()) {
            movementTrackedNpcs.removeIf(player -> getDistance(player.getWorldLocation()) > 15);
            for (Pair<NPCMoved, WorldPoint> pair : npcMovementEvents.values()) {
                final NPCMoved movementEvent = pair.getLeft();
                final WorldPoint previousLocation = previousNPCLocations.get(movementEvent.getNpc());
                final LocalPoint localDestination = LocalPoint.fromScene(movementEvent.getX(), movementEvent.getY());
                final WorldPoint destination = fromLocal(client, localDestination);
                previousNPCLocations.put(movementEvent.getNpc(), destination);
                if (previousLocation == null) continue;
                final int distance = getDistance(localDestination);
                if ((distance > 15 || movementEvent.getNpc().getWorldLocation().getPlane() != client.getPlane())) continue;
                /* Any players that were just added to the tracked players list can't be relied on for valid info. */
                if (movementTrackedNpcs.add(movementEvent.getNpc())) continue;
                if (movementEvent.getType() == 127) {
                    addLine(formatActor(movementEvent.getNpc(), previousLocation), "Teleport(" + formatLocation(destination) + ")",
                            isActorConsoleLogged(movementEvent.getNpc()), npcMovement);
                } else {
                    String type = movementEvent.getType() == 0 ? "Crawl" : movementEvent.getType() == 1 ? "Walk" : movementEvent.getType() == 2 ? "Run" :
                            "Teleport";
                    addLine(
                            formatActor(movementEvent.getNpc(), previousLocation),
                            "Movement(type = " + (type) + ", " + formatLocation(destination) + ")",
                            client.getTickCount(),
                            isActorConsoleLogged(movementEvent.getNpc()),
                            npcMovement,
                            npcMovement.isSelected()
                    );
                }
            }
            npcMovementEvents.clear();
        }
        if (!projectileSpawnedList.isEmpty()) {
            projectileSpawnedList.forEach(projectileSpawned -> {
                Triple<ProjectileTracker.StaticProjectileInfo, ProjectileTracker.DynamicProjectileInfo, List<ProjectileTracker.DynamicProjectileInfo>> info  =
                        projectileTracker.addEvent(projectileSpawned, playerMovements);
                final List<ProjectileTracker.DynamicProjectileInfo> comparisonPoints = info.getRight();
                final ProjectileTracker.DynamicProjectileInfo dynamicInfo = info.getMiddle();
                final ProjectileTracker.StaticProjectileInfo staticInfo = info.getLeft();
                final StringBuilder productBuilder = new StringBuilder();
                if (!comparisonPoints.isEmpty()) {
                    final ProjectileTracker.DynamicProjectileInfo comparisonPoint = comparisonPoints.get(0);
                    final int durDiff = dynamicInfo.getFlightDuration() - comparisonPoint.getFlightDuration();
                    int distDiff;
                    if (comparisonPoints.size() == 1) {
                        // If we only have one entry, we cannot really tell if this is a sw-based or real distance based projectile, so let's assume based on size.
                        if (dynamicInfo.getStartActor() != null) {
                            final int size = dynamicInfo.getStartActor() instanceof NPC ? ((NPC) dynamicInfo.getStartActor()).getComposition().getSize() : 1;
                            final boolean southWestBased = size >= 3;
                            if (southWestBased) {
                                distDiff = dynamicInfo.getSwDistance() - comparisonPoint.getSwDistance();
                            } else {
                                distDiff = dynamicInfo.getDistance() - comparisonPoint.getDistance();
                            }
                        } else {
                            distDiff = dynamicInfo.getDistance() - comparisonPoint.getDistance();
                        }
                    } else {
                        final int distanceDiff = dynamicInfo.getSwDistance() - comparisonPoint.getSwDistance();
                        final int durationDiff = dynamicInfo.getFlightDuration() - comparisonPoint.getFlightDuration();
                        final int durationPerTileDistance = Math.abs(durationDiff / distanceDiff);
                        final boolean swBased = comparisonPoints.stream().allMatch(entry -> {
                            final int otherDisDiff = dynamicInfo.getSwDistance() - comparisonPoint.getSwDistance();
                            final int otherDurDiff = dynamicInfo.getFlightDuration() - comparisonPoint.getFlightDuration();
                            return Math.abs(otherDurDiff / otherDisDiff) == durationPerTileDistance;
                        });
                        if (swBased) {
                            distDiff = distanceDiff;
                        } else {
                            distDiff = dynamicInfo.getDistance() - comparisonPoint.getDistance();
                        }
                    }
                    final int durationPerTileDistance = Math.abs(durDiff / distDiff);
                    final int duration = dynamicInfo.getFlightDuration();
                    final int distance = dynamicInfo.getDistance();
                    final int lengthAdjustment = duration - (distance * durationPerTileDistance);
                    productBuilder.append("Projectile(");
                    String name = getName(NamedVariableType.Graphics, staticInfo.getId());
                    if (name != null) {
                        productBuilder.append("name = ").append(name).append(", ");
                    } else {
                        productBuilder.append("id = ").append(staticInfo.getId()).append(", ");
                    }
                    productBuilder.append("startHeight = ").append(staticInfo.getStartHeight()).append(", ");
                    productBuilder.append("endHeight = ").append(staticInfo.getEndHeight()).append(", ");
                    productBuilder.append("delay = ").append(staticInfo.getDelay()).append(", ");
                    productBuilder.append("angle = ").append(staticInfo.getAngle()).append(", ");
                    productBuilder.append("lengthAdjustment = ").append(lengthAdjustment).append(", ");
                    productBuilder.append("distOffset = ").append(staticInfo.getDistanceOffset()).append(", ");
                    productBuilder.append("stepMultiplier = ").append(durationPerTileDistance).append(")");
                } else {
                    productBuilder.append("IncompleteProjectile(");
                    String name = getName(NamedVariableType.Graphics, staticInfo.getId());
                    if (name != null) {
                        productBuilder.append("name = ").append(name).append(", ");
                    } else {
                        productBuilder.append("id = ").append(staticInfo.getId()).append(", ");
                    }
                    productBuilder.append("startHeight = ").append(staticInfo.getStartHeight()).append(", ");
                    productBuilder.append("endHeight = ").append(staticInfo.getEndHeight()).append(", ");
                    productBuilder.append("delay = ").append(staticInfo.getDelay()).append(", ");
                    productBuilder.append("angle = ").append(staticInfo.getAngle()).append(", ");
                    productBuilder.append("distOffset = ").append(staticInfo.getDistanceOffset()).append(")");
                }
                productBuilder.append("\t| ").append("distance = ").append(dynamicInfo.getDistance()).append(", ");
                productBuilder.append("flightDuration = ").append(dynamicInfo.getFlightDuration()).append(", ");
                productBuilder.append("visualStart = ").append(formatLocation(dynamicInfo.getVisualStart()));

                final String from = formatActor(dynamicInfo.getStartActor(), dynamicInfo.getStartPoint().toWorldPoint());
                final String to = formatActor(dynamicInfo.getEndActor(), dynamicInfo.getEndPoint().toWorldPoint());
                final boolean console = isActorConsoleLogged(dynamicInfo.getStartActor()) || isActorConsoleLogged(dynamicInfo.getEndActor());
                addLine(from + " -> " + to, productBuilder.toString(), console, projectiles);
            });
            projectileSpawnedList.clear();
        }
        if (!exactMoves.isEmpty()) {
            exactMoves.forEach((actor, exactMove) -> {
                final int currentCycle = exactMove.getCycle();
                final StringBuilder exactMoveBuilder = new StringBuilder();
                final WorldPoint actorWorldLocation = actor.getWorldLocation();
                exactMoveBuilder.append("ExactMove(");
                exactMoveBuilder.append("firstLocation = ").append(formatLocation(actorWorldLocation.getX() + exactMove.getExactMoveDeltaX1(),
                        actorWorldLocation.getY() + exactMove.getExactMoveDeltaY1(), client.getPlane(), false));
                exactMoveBuilder.append(", ");
                final int firstDuration = exactMove.getExactMoveArrive1Cycle() - currentCycle;
                exactMoveBuilder.append("firstDuration = ").append(firstDuration).append(", ");
                exactMoveBuilder.append("secondLocation = ").append(formatLocation(actorWorldLocation.getX() + exactMove.getExactMoveDeltaX2(),
                        actorWorldLocation.getY() + exactMove.getExactMoveDeltaY2(), client.getPlane(), false));
                exactMoveBuilder.append(", ");
                final int secondDuration = (exactMove.getExactMoveArrive2Cycle() - currentCycle) - firstDuration;
                exactMoveBuilder.append("secondDuration = ").append(secondDuration).append(", ");
                exactMoveBuilder.append("direction = ").append(exactMove.getExactMoveDirection()).append(")");
                addLine(formatActor(actor), exactMoveBuilder.toString(), isActorConsoleLogged(actor), this.exactMove);
            });
            exactMoves.clear();
        }
    }

    @Override
    public void onHashTableNodePut(HashTableNodePut event) {
        HashTable<? extends Node> table = event.getHashTable();
        if (table == client.getWidgetFlags()) {
            if (!(event.getNode() instanceof IntegerNode)) return;
            final int events = ((IntegerNode) event.getNode()).getValue();
            final long value = event.getValue();
            final int packedIf = (int) (value >> 32L);
            final int slot = (int) value;
            final long mapKey = (long) events | ((long) packedIf << 32);
            final Set<Integer> slots = updatedIfEvents.computeIfAbsent(mapKey, k -> new HashSet<>());
            latestServerTick = client.getTickCount();
            slots.add(slot);
        } else if (table == client.getComponentTable()) {
            if (!(event.getNode() instanceof WidgetNode)) return;
            final WidgetNode node = ((WidgetNode) event.getNode());
            final long value = event.getValue();
            ifMoveSubs.put(node, Pair.of(hashTableNodeGet1, value));
            lastMoveSub = node;
            latestServerTick = client.getTickCount();
            resetTrackedVariables();
        }
    }

    @Override
    public void onHashTableNodeGetCall(HashTableNodeGetCall event) {
        hashTableNodeGet1 = hashTableNodeGet2;
        hashTableNodeGet2 = event.getKey();
    }

    @Override
    public void onIfOpenTopEvent(IfOpenTopEvent event) {
        resetTrackedVariables();
        if (event.getRootInterface() == -1) return;
        String name = getName(NamedVariableType.Interface, event.getRootInterface());
        if (name != null) {
            addLine("Top interface", "IfOpenTop(name = " + name + ")", true, ifOpenTop);
        } else {
            addLine("Top interface", "IfOpenTop(id = " + event.getRootInterface() + ")", true, ifOpenTop);
        }
    }

    @Override
    public void onIfOpenSubEvent(IfOpenSubEvent event) {
        resetTrackedVariables();
        /* Because open sub and move sub are quite similar in nature, we have to keep track of its state to filter out moves. */
        if (lastMoveSub != null) {
            ifMoveSubs.remove(lastMoveSub);
            lastMoveSub = null;
        }
        String name = getName(NamedVariableType.Interface, event.getInterfaceId());
        String topName = getName(NamedVariableType.Interface, event.getTargetComponent() >> 16);
        String id;
        if (name != null) {
            id = "name = " + name;
        } else {
            id = "id = " + event.getInterfaceId();
        }
        String topId;
        if (topName != null) {
            topId = "" + topName;
        } else {
            topId = "" + (event.getTargetComponent() >> 16);
        }
        addLine("Sub interface",
                "IfOpenSub(" + id + ", topInterface = " + topId
                        + ", topComponent = " + (event.getTargetComponent() & 0xFFFF)
                        + ", modal = " + (event.getWalkType() == WidgetModalMode.MODAL_NOCLICKTHROUGH) + ")", true, ifOpenSub);
    }

    @Override
    public void onWidgetClosed(WidgetClosed event) {
        resetTrackedVariables();
        if (!event.getUnload()) return;
        String name = getName(NamedVariableType.Interface, event.getGroupId());
        String topName = getName(NamedVariableType.Interface, (int) (hashTableNodeGet2 >> 16));
        String id;
        if (name != null) {
            id = "name = " + name;
        } else {
            id = "id = " + event.getGroupId();
        }
        String topId;
        if (topName != null) {
            topId = topName;
        } else {
            topId = "" + (hashTableNodeGet2 >> 16);
        }
        addLine("Close Sub Interface(" + id + ", modal = " + (event.getModalMode() == WidgetModalMode.MODAL_NOCLICKTHROUGH) + ")",
                "IfCloseSub(topInterface = " + topId + ", topComponent = " + (hashTableNodeGet2 & 0xFFFF) + ")", true, ifCloseSub);
    }

    private void resetTrackedVariables() {
        widgetScrollY = -1;
        widgetText = null;
        widgetSequence = -1;
        widgetColor = -1;
        widgetZoom = -1;
        widgetAngleX = -1;
        widgetAngleY = -1;
        widgetPositionX = -1;
        widgetPositionY = -1;
        widgetModelId = -1;
        widgetItemId = -1;
        widgetItemQuantityOrModelId = -1;
        widgetSetPlayerHead = false;
        widgetModelRotation = -1;
        widgetHidden = null;
        widgetNpcId = -1;
    }

    @Override
    public void onPostWidgetConstructed(PostWidgetConstructed event) {
        resetTrackedVariables();
    }

    @Override
    public void onServerPacketReadStartedEvent(ServerPacketReadStartedEvent event) {
        client.setLatestWidgetCall(-1);
        resetTrackedVariables();
    }

    @Override
    public void onServerPacketReadCompleteEvent(ServerPacketReadCompleteEvent event) {
        if (widgetScrollY != -1) {
            addLine("Interface Scroll Position", "IfSetScrollPos(" + formatLatestWidgetCall() + ", scrollHeight = " + widgetScrollY + ")", true,
                    miscInterfacePackets);
        } else if (widgetText != null) {
            addLine("Interface Text", "IfSetText(" + formatLatestWidgetCall() + ", text = \"" + widgetText + "\")", true, miscInterfacePackets);
        } else if (widgetSequence != -1) {
            String name = getName(NamedVariableType.Animation, widgetSequence);
            String seq;
            if (name != null) {
                seq = "animation = " + name;
            } else {
                seq = "animationId = " + widgetSequence;
            }
            addLine("Interface Sequence", "IfSetAnim(" + formatLatestWidgetCall() + ", " + seq + ")", true, miscInterfacePackets);
        } else if (widgetColor != -1) {
            final int red = (widgetColor >> 19) & 0x1F;
            final int green = (widgetColor >> 11) & 0x1F;
            final int blue = (widgetColor >> 3) & 0x1F;
            addLine("Interface Text Colour", "IfSetColor(" + formatLatestWidgetCall() + ", red = " + red + ", green = " + green + ", blue = " + blue + ")",
                    true, miscInterfacePackets);
        } else if (widgetItemId != -1 && widgetItemQuantityOrModelId != -1) {
            String name = getName(NamedVariableType.Item, widgetItemId);
            String itemName;
            if (name != null) {
                itemName = "item = " + name;
            } else {
                itemName = "itemId = " + widgetItemId;
            }
            if (widgetObjectType) {
                addLine("Interface Object",
                        "IfSetObject(" + formatLatestWidgetCall() + ", " + itemName + ", modelZoom = " + widgetItemQuantityOrModelId + ")", true
                        , miscInterfacePackets);
            } else {
                addLine("Interface Object",
                        "IfSetObject(" + formatLatestWidgetCall() + ", " + itemName + ", itemQuantity = " + widgetItemQuantityOrModelId + ")",
                        true, miscInterfacePackets);
            }
        } else if (widgetZoom != -1 && widgetAngleX != -1 && widgetAngleY != -1) {
            addLine("Interface Angle",
                    "IfSetAngle(" + formatLatestWidgetCall() + ", zoom = " + widgetZoom + ", angleX = " + widgetAngleX + ", angleY = " + widgetAngleY + ")",
                    true, miscInterfacePackets);
        } else if (widgetModelId != -1) {
            String name = getName(NamedVariableType.Model, widgetModelId);
            String modelName;
            if (name != null) {
                modelName = "model = " + name;
            } else {
                modelName = "modelId = " + widgetModelId;
            }
            addLine("Interface Model", "IfSetModel(" + formatLatestWidgetCall() + ", " + modelName + ")", true, miscInterfacePackets);
        } else if (widgetSetPlayerHead) {
            addLine("Interface Player Head", "IfSetPlayerHead(" + formatLatestWidgetCall() + ")", true, miscInterfacePackets);
        } else if (widgetModelRotation != -1) {
            addLine("Interface Model Rotation",
                    "IfModelRotate(" + formatLatestWidgetCall() + ", pitch = " + (widgetModelRotation >> 16) + ", roll = " + (widgetModelRotation & 0xFFFF) + ")", true, miscInterfacePackets);
        } else if (widgetHidden != null) {
            addLine("Interface Visibility", "IfSetHide(" + formatLatestWidgetCall() + ", hidden = " + widgetHidden + ")", true, miscInterfacePackets);
        } else if (widgetNpcId != -1) {
            String name = getName(NamedVariableType.Npc, widgetNpcId);
            String npcName;
            if (name != null) {
                npcName = "npc = " + name;
            } else {
                npcName = "npcId = " + widgetNpcId;
            }
            addLine("Interface Npc Head", "IfSetNpcHead(" + formatLatestWidgetCall() + ", " + npcName + ")", true, miscInterfacePackets);
        } else if (widgetPositionX != -1 && widgetPositionY != -1) {
            addLine("Interface Position", "IfSetPosition(" + formatLatestWidgetCall() + ", x = " + widgetPositionX + ", y = " + widgetPositionY + ")", true,
                    miscInterfacePackets);
        }
    }

    private String formatLatestWidgetCall() {
        final int latestWidgetCall = client.getLatestWidgetCall();
        String name = getName(NamedVariableType.Interface, (latestWidgetCall >> 16));
        if (name != null) {
            return "interface = " + name + ", componentId = " + (latestWidgetCall & 0xFFFF);
        }
        return "interfaceId = " + (latestWidgetCall >> 16) + ", componentId = " + (latestWidgetCall & 0xFFFF);
    }

    @Override
    public void onWidgetScrollHeightChanged(WidgetScrollHeightChanged event) {
        widgetScrollY = event.getScrollY();
    }

    @Override
    public void onWidgetTextChanged(WidgetTextChanged event) {
        widgetText = event.getText();
    }

    @Override
    public void onWidgetSequenceChanged(WidgetSequenceChanged event) {
        widgetSequence = event.getAnimationId();
    }

    @Override
    public void onWidgetColorChanged(WidgetColorChanged event) {
        widgetColor = event.getColor();
    }

    @Override
    public void onWidgetZoomChanged(WidgetZoomChanged event) {
        widgetZoom = event.getZoom();
        widgetAngleX = event.getAngleX();
        widgetAngleY = event.getAngleY();
    }

    @Override
    public void onWidgetPositionChanged(WidgetPositionChanged event) {
        widgetPositionX = event.getX();
        widgetPositionY = event.getY();
    }

    @Override
    public void onWidgetModelChanged(WidgetModelChanged event) {
        widgetModelId = event.getModelId();
    }

    @Override
    public void onWidgetSetObject(WidgetSetObject event) {
        widgetItemId = event.getItemId();
        widgetItemQuantityOrModelId = event.getItemQuantityOrModelZoom();
        widgetObjectType = event.getNewType();
    }

    @Override
    public void onWidgetSetPlayerHead(WidgetSetPlayerHead event) {
        widgetSetPlayerHead = true;
    }

    @Override
    public void onWidgetModelRotate(WidgetModelRotate event) {
        widgetModelRotation = event.getRotation();
    }

    @Override
    public void onWidgetVisibilityChange(WidgetVisibilityChange event) {
        widgetHidden = event.getHidden();
    }

    @Override
    public void onWidgetSetNpcHead(WidgetSetNpcHead event) {
        widgetNpcId = event.getNpcId();
    }

    private static final Map<Integer, String> VARBIT_NAMES;

    static
    {
        ImmutableMap.Builder<Integer, String> builder = new ImmutableMap.Builder<>();

        try
        {
            for (Field f : Varbits.class.getDeclaredFields())
            {
                builder.put(f.getInt(null), f.getName());
            }
        }
        catch (IllegalAccessException ex)
        {
            log.error("error setting up varbit names", ex);
        }

        VARBIT_NAMES = builder.build();
    }

    @Override
    public void onVarbitChanged(VarbitChanged varbitChanged) {
        int index = varbitChanged.getVarpId();
        int[] varps = client.getVarps();
        for (int i : varbits.get(index)) {
            int old = client.getVarbitValue(oldVarps, i);
            int newValue = client.getVarbitValue(varps, i);
            if (old != newValue) {
                client.setVarbitValue(oldVarps2, i, newValue);
                String varpName = getName(NamedVariableType.Varp, index);
                String varp;
                if (varpName != null) {
                    varp = "varp = " + varpName;
                } else {
                    varp = "varpId: " + index;
                }
                String varbitName;
                String vName = getName(NamedVariableType.Varbit, i);
                if (vName != null) {
                    varbitName = "name = " + vName;
                } else {
                    varbitName = "id = " + i;
                }
                String name = VARBIT_NAMES.get(i);
                String prefix = varbitName.startsWith("name") ? "Varbit"
                        : name == null ? "Varbit" : ("Varbit \"" + name + "\"");
                addLine(prefix + " (" + varp + ", oldValue: " + old + ")", "Varbit(" + varbitName + ", value = " + newValue + ")", true, varbitsCheckBox);
            }
        }

        int old = oldVarps2[index];
        int newValue = varps[index];
        if (old != newValue) {
            String name = null;
            for (VarPlayer varp : VarPlayer.values()) {
                if (varp.getId() == index) {
                    name = varp.name();
                    break;
                }
            }
            String varpName = getName(NamedVariableType.Varp, index);
            String varp;
            if (varpName != null) {
                varp = "name = " + varpName;
            } else {
                varp = "id: " + index;
            }
            String prefix = varp.startsWith("name") ? "Varp" : name == null ? "Varp" : ("Varp \"" + name + "\"");
            addLine(prefix + " (oldValue: " + old + ")", "Varp(" + varp + ", value = " + newValue + ")", true, varpsCheckBox);
        }

        System.arraycopy(client.getVarps(), 0, oldVarps, 0, oldVarps.length);
        System.arraycopy(client.getVarps(), 0, oldVarps2, 0, oldVarps2.length);
    }

    @Override
    public void onHitsplatApplied(HitsplatApplied event) {
        Actor actor = event.getActor();
        if (actor == null || isActorPositionUninitialized(actor)) return;
        Hitsplat hitsplat = event.getHitsplat();
        addLine(formatActor(actor), "Hit(type = " + hitsplat.getHitsplatType() + ", amount = " + hitsplat.getAmount() + ")", isActorConsoleLogged(actor),
                hitsCheckBox);
    }

    @Override
    public void onInteractingChanged(InteractingChanged event) {
        Actor sourceActor = event.getSource();
        if (!facedActors.add(sourceActor)) return;
        latestServerTick = client.getTickCount();
        Actor targetActor = event.getTarget();
        if (sourceActor == null || isActorPositionUninitialized(sourceActor)) return;
        boolean log = sourceActor instanceof Player ? isActorConsoleLogged(sourceActor) : targetActor instanceof Player ? isActorConsoleLogged(sourceActor) :
                (isActorConsoleLogged(sourceActor) && isActorConsoleLogged(targetActor));
        addLine(formatActor(sourceActor), "FaceEntity(" + (targetActor == null ? "null" : formatActor(targetActor)) + ", index: " + event.getIndex() + ")", log, interacting);
    }

    @Override
    public void onFacedDirectionChanged(FacedDirectionChanged event) {
        if (event.getDirection() == -1) return;
        Actor sourceActor = event.getSource();
        latestServerTick = client.getTickCount();
        if (!facedDirectionActors.containsKey(sourceActor)) facedDirectionActors.put(sourceActor, new FaceTile(event.getDirection(), event.getInstant()));
    }

    @Override
    public void onScriptPreFired(ScriptPreFired event) {
        resetTrackedVariables();
        ScriptEvent scriptEvent = event.getScriptEvent();
        /* Filter out the non-server created scripts. Do note that other plugins may call CS2s, such as the quest helper plugin. */
        if (scriptEvent == null || scriptEvent.getSource() != null || scriptEvent.type() != 76) return;
        final Object[] arguments = scriptEvent.getArguments();
        final int scriptId = Integer.parseInt(arguments[0].toString());
        if (ignoredClientScripts.contains(scriptId)) return;
        final StringBuilder args = new StringBuilder();
        for (int i = 1; i < arguments.length; i++) {
            final Object argument = arguments[i];
            if (argument instanceof String) {
                args.append('"').append(argument).append('"');
            } else {
                args.append(arguments[i]);
            }
            if (i < arguments.length - 1) args.append(", ");
        }
        String scriptName = getName(NamedVariableType.Clientscript, scriptId);
        if (scriptName != null) {
            addLine("Local", "ClientScript(name = " + scriptName + ", arguments = [" + args + "])", true, clientScripts);
        } else {
            addLine("Local", "ClientScript(id = " + scriptId + ", arguments = [" + args + "])", true, clientScripts);
        }
    }

    @Override
    public void onScriptPostFired(ScriptPostFired event) {
        resetTrackedVariables();
    }

    @Override
    public void onScriptCallbackEvent(ScriptCallbackEvent event) {
        resetTrackedVariables();
    }

    @Override
    public void onPlayerMoved(PlayerMoved event) {
        movementEvents.put(event.getPlayer(), Pair.of(event, event.getPlayer().getWorldLocation()));
        this.latestServerTick = client.getTickCount();
    }

    @Override
    public void onNPCMoved(NPCMoved event) {
        npcMovementEvents.put(event.getNpc(), Pair.of(event, event.getNpc().getWorldLocation()));
    }

    @Override
    public void onItemSpawned(ItemSpawned event) {
        final Tile tile = event.getTile();
        final TileItem item = event.getItem();
        final WorldPoint location = tile.getWorldLocation();
        final StringBuilder builder = new StringBuilder();
        builder.append("ObjAdd(item = Item(");
        String name = getName(NamedVariableType.Item, item.getId());
        if (name != null) {
            builder.append("name = ").append(name);
        } else {
            builder.append("id = ").append(item.getId());
        }
        if (item.getQuantity() != 1) builder.append(", quantity = ").append(item.getQuantity());
        builder.append("), ").append(formatLocation(location)).append(")");
        addLine("Ground item add", builder.toString(), inEventDistance(location), groundItemAdd);
    }

    @Override
    public void onItemDespawned(ItemDespawned event) {
        final Tile tile = event.getTile();
        final TileItem item = event.getItem();
        final WorldPoint location = tile.getWorldLocation();
        final StringBuilder builder = new StringBuilder();
        builder.append("ObjDel(item = Item(");
        String name = getName(NamedVariableType.Item, item.getId());
        if (name != null) {
            builder.append("name = ").append(name);
        } else {
            builder.append("id = ").append(item.getId());
        }
        if (item.getQuantity() != 1) builder.append(", quantity = ").append(item.getQuantity());
        builder.append("), ").append(formatLocation(location)).append(")");
        addLine("Ground item delete", builder.toString(), inEventDistance(location), groundItemDel);
    }

    @Override
    public void onItemQuantityChanged(ItemQuantityChanged event) {
        final Tile tile = event.getTile();
        final TileItem item = event.getItem();
        final WorldPoint location = tile.getWorldLocation();
        final StringBuilder builder = new StringBuilder();
        builder.append("ObjUpdate(");
        builder.append("updatedQuantity = ").append(event.getNewQuantity()).append(", ");
        builder.append("item = Item(");
        String name = getName(NamedVariableType.Item, item.getId());
        if (name != null) {
            builder.append("name = ").append(name);
        } else {
            builder.append("id = ").append(item.getId());
        }
        if (item.getQuantity() != 1) builder.append(", quantity = ").append(event.getOldQuantity());
        builder.append("), ").append(formatLocation(location)).append(")");
        addLine("Ground item quantity update", builder.toString(), inEventDistance(location), groundItemUpdate);
    }

    @Override
    public void onGetDynamicObjectForAnimationEvent(GetDynamicObjectForAnimationEvent event) {
        accessedObjectForAnimation = true;
    }

    @Override
    public void onDynamicObjectAnimationChanged(DynamicObjectAnimationChanged event) {
        if (!accessedObjectForAnimation) return;
        accessedObjectForAnimation = false;
        final int id = event.getObject();
        Scene scene = client.getScene();
        Tile[][][] tiles = scene.getTiles();
        Tile localTile = tiles[client.getPlane()][event.getX()][event.getY()];
        if (localTile == null) return;
        if (submitObjectAnimationIfMatches(localTile.getWallObject(), event, id)) return;
        if (submitObjectAnimationIfMatches(localTile.getDecorativeObject(), event, id)) return;
        if (submitObjectAnimationIfMatches(localTile.getGroundObject(), event, id)) return;
        Optional<GameObject> gameObject =
                Arrays.stream(localTile.getGameObjects()).filter(obj -> obj != null && (obj.getHash() >>> 17 & 4294967295L) == event.getObject()).findAny();
        gameObject.ifPresent(object -> submitObjectAnimation(event, object));
    }

    private boolean submitObjectAnimationIfMatches(TileObject object, DynamicObjectAnimationChanged event, int id) {
        if (object == null) return false;
        if ((object.getHash() >>> 17 & 4294967295L) == id) {
            submitObjectAnimation(event, object);
            return true;
        }
        return false;
    }

    private void submitObjectAnimation(DynamicObjectAnimationChanged event, TileObject object) {
        final int modelRotation = object.getModelOrientation();
        final int type = object.getConfig() & 0x1F;
        int rotation = modelRotation;
        if (type == 2 || type == 6 || type == 8) {
            rotation -= 4;
        } else if (type == 7) {
            rotation = (rotation - 2 & 0x3);
        }
        final LocalPoint localPoint = LocalPoint.fromScene(event.getX(), event.getY());
        final WorldPoint location = fromLocal(client, localPoint);
        String animName = getName(NamedVariableType.Animation, event.getAnimation());
        String anim;
        if (animName != null) {
            anim = "animation = " + animName;
        } else {
            anim = "animation = " + event.getAnimation();
        }

        String objName = getName(NamedVariableType.Object, object.getId());
        String obj;
        if (animName != null) {
            obj = "name = " + objName;
        } else {
            obj = "id = " + object.getId();
        }
        addLine("Map Object Animation", "LocAnim(" + anim + ", object = MapObject(" + obj + ", type = " + type +
                ", rotation = " + rotation + ", " + formatLocation(location) + ")", inEventDistance(localPoint), mapObjectAnim);
    }

    @Override
    public void onGraphicsObjectCreated(GraphicsObjectCreated event) {
        final GraphicsObject obj = event.getGraphicsObject();
        final WorldPoint location = fromLocal(client, obj.getLocation());
        final int delay = obj.getStartCycle() - client.getGameCycle();
        final int tileHeight = Perspective.getTileHeight(client, obj.getLocation(), client.getPlane());
        final StringBuilder builder = new StringBuilder();
        final int height = -(obj.getZ() - tileHeight);
        builder.append("SpotanimSpecific(");
        String name = getName(NamedVariableType.Graphics, obj.getId());
        if (name != null) {
            builder.append("name = ").append(name).append(", ");
        } else {
            builder.append("id = ").append(obj.getId()).append(", ");
        }
        if (delay != 0) builder.append("delay = ").append(delay).append(", ");
        if (height != 0) builder.append("height = ").append(height).append(", ");
        builder.append(formatLocation(location)).append(")");
        addLine("Spotanim Specific", builder.toString(), inEventDistance(location), graphicsObjectChanges);
    }

    @Override
    public void onJinglePlayed(JinglePlayed event) {
        String name = getName(NamedVariableType.Jingle, event.getJingleId());
        if (name != null) {
            addLine("Jingle", "Jingle(name = " + name + ")", true, jingles);
        } else {
            addLine("Jingle", "Jingle(id = " + event.getJingleId() + ")", true, jingles);
        }
    }

    @Override
    public void onPlayerMenuOptionsChanged(PlayerMenuOptionsChanged event) {
        addLine("Player Context Menu",
                "PlayerOption(index = " + event.getIndex() + ", priority = " + event.getPriority() + ", option = " + "\"" + event.getOption() + "\")", true,
                playerMenuOptions);
    }

    @Override
    public void onExactMoveEvent(ExactMoveEvent event) {
        final Actor actor = event.getActor();
        if (actor == null || isActorPositionUninitialized(actor)) return;
        exactMoves.put(actor, event);
    }

    @Override
    public void onRecolourEvent(RecolourEvent event) {
        tintingChanges.put(event.getActor(), event);
    }

    @Override
    public void onCombatLevelChangeEvent(CombatLevelChangeEvent event) {
        combatLevelChanges.put(event.getActor(), event);
    }

    @Override
    public void onNpcChanged(NpcChanged event) {
        final NPC npc = event.getNpc();
        final NPCComposition oldComposition = event.getOld();
        final WorldPoint actorWorldLocation = npc.getWorldLocation();
        final String coordinateString = formatLocation(actorWorldLocation);
        String oldName = getName(NamedVariableType.Npc, oldComposition.getId());
        if (oldName != null) {
            oldName = "name: " + oldName;
        } else {
            oldName = "id: " + oldComposition.getId();
        }
        String newName = getName(NamedVariableType.Npc, npc.getComposition().getId());
        if (newName != null) {
            newName = "name: " + newName;
        } else {
            newName = "id: " + npc.getComposition().getId();
        }
        final String actorName = "Npc(" + npc.getName() + ", idx: " + npc.getIndex() + ", " + oldName + ", " + coordinateString + ")";
        addLine(actorName, "Transformation(" + newName + ")", isActorConsoleLogged(npc), transformations);
    }

    @Override
    public void onPlayerChanged(PlayerChanged event) {
        final Player player = event.getPlayer();
        final PlayerAppearance appearance = appearances.get(player);
        final PlayerAppearance newAppearance = getPlayerAppearance(player);
        appearances.put(player, newAppearance);
        final String appearanceDifferences = newAppearance.getDifferences(appearance);
        if (!appearanceDifferences.isEmpty()) {
            addLine(formatActor(player), "Appearance(" + appearanceDifferences + ")", isActorConsoleLogged(player), appearancesCheckbox);
        }
        final PlayerComposition composition = player.getPlayerComposition();
        final int transformedToNpc = composition == null ? -1 : composition.getTransformedNpcId();
        final int sanitizedTransformedId = transformedToNpc == 65535 ? -1 : transformedToNpc;
        final int latestNpcId = playerTransformations.getOrDefault(player, -1);
        /* If the cached value matches the "new" version, transformation did not occur. */
        if (latestNpcId == sanitizedTransformedId) {
            return;
        }
        playerTransformations.put(player, sanitizedTransformedId);
        String name = getName(NamedVariableType.Npc, sanitizedTransformedId);
        if (name == null) {
            name = "" + sanitizedTransformedId;
        }
        addLine(formatActor(player), "Transformation(" + name + ")", isActorConsoleLogged(player), transformations);
    }

    @Override
    public void onContainerItemChange(ContainerItemChange event) {
        final int key = ((event.getInventoryId() & 0xFFFF) << 16) | (event.getSlotId() & 0xFFFF);
        final int value = ((event.getItemId() & 0xFFFF) << 16) | (event.getQuantity() & 0xFFFF);
        if (latestInventoryId != event.getInventoryId()) {
            final int latestWidgetCall = client.getLatestWidgetCall();
            final int interfaceId = latestWidgetCall == -1 ? -1 : (latestWidgetCall >> 16);
            String name = getName(NamedVariableType.Interface, interfaceId);
            if (name != null) {
                name = "interface = " + name;
            } else {
                name = "interfaceId = " + interfaceId;
            }
            String invName = getName(NamedVariableType.Inventory, event.getInventoryId());
            if (invName != null) {
                invName = "inventory = " + invName;
            } else {
                invName = "inventoryId = " + event.getInventoryId();
            }
            final int componentId = latestWidgetCall == -1 ? -1 : (latestWidgetCall & 0xFFFF);
            if (interfaceId != -1 || componentId != -1) {
                addLine("Inventory update",
                        "InvComponent(" + name + ", componentId = " + componentId + ", " + invName + ")", true,
                        inventoryChanges);
            } else {
                addLine("Inventory update", "InvComponent(" + invName + ")", true, inventoryChanges);
            }
            latestInventoryId = event.getInventoryId();
        }
        if (Objects.equals(inventoryDiffs.get(key), value)) return;
        inventoryDiffs.put(key, value);
        String name = getName(NamedVariableType.Item, event.getItemId());
        if (name != null) {
            name = "item = " + name;
        } else {
            name = "itemId = " + event.getItemId();
        }
        addLine("Inventory change",
                "Inv(slotId = " + event.getSlotId() + ", " + "" + name + ", " + "amount = " + event.getQuantity() + ")", true,
                inventoryChanges);
    }

    @Override
    public void onPendingSpawnUpdated(PendingSpawnUpdated event) {
        /* To get the model clip packet to function, we need to combine multiple plugins into what is essentially a state machine. */
        pendingSpawnList.add(event);
        latestServerTick = client.getTickCount();
    }

    @Override
    public void onAttachedModelEvent(AttachedModelEvent event) {
        /* Always remove the combined objects to ensure valid object add/remove detection. */
        final PendingSpawnUpdated latestPendingSpawn = pendingSpawnList.isEmpty() ? null : pendingSpawnList.remove(pendingSpawnList.size() - 1);
        if (latestPendingSpawn == null) {
            log.info("Latest pending spawn is null!");
            return;
        }

        Scene scene = client.getScene();
        Tile[][][] tiles = scene.getTiles();
        Tile localTile = tiles[client.getPlane()][latestPendingSpawn.getX()][latestPendingSpawn.getY()];
        Stream<TileObject> objects = Stream.of(localTile.getGroundObject(), localTile.getDecorativeObject(), localTile.getWallObject());
        Stream<TileObject> fullStream = Stream.concat(Arrays.stream(localTile.getGameObjects()), objects);
        Optional<TileObject> attachedObject = fullStream.filter(obj -> {
            if (obj == null) return false;
            final int rotation = obj.getTileObjectAngle().getAngle() >> 9;
            final int type = obj.getConfig() & 0x1F;
            final Model a = event.getAttachedModel();
            final Model b = getModel(obj, type, rotation, latestPendingSpawn.getX(), latestPendingSpawn.getY());
            if (b == null) return false;
            return a == b || (a.getFaceCount() == b.getFaceCount() && a.getVerticesCount() == b.getVerticesCount() && Arrays.equals(a.getFaceColors1(),
                    b.getFaceColors1()) && Arrays.equals(a.getFaceColors2(), b.getFaceColors2()) && Arrays.equals(a.getFaceColors3(), b.getFaceColors3())
                    && Arrays.equals(a.getFaceIndices1(), b.getFaceIndices1()) && Arrays.equals(a.getFaceIndices2(), b.getFaceIndices2())
                    && Arrays.equals(a.getFaceIndices3(), b.getFaceIndices3()) && Arrays.equals(a.getVerticesX(), b.getVerticesX())
                    && Arrays.equals(a.getVerticesY(), b.getVerticesY()) && Arrays.equals(a.getVerticesZ(), b.getVerticesZ()));
        }).findAny();

        if (!attachedObject.isPresent()) {
            addLine(formatActor(event.getPlayer()), "LocCombine(unable to locate object)", isActorConsoleLogged(event.getPlayer()), combinedObjects);
            log.info("Unable to find a matching game object for object combine on " + localTile.getWorldLocation());
            return;
        }


        TileObject obj = attachedObject.get();
        WorldPoint objectLocation = obj.getWorldLocation();
        final int clientTime = client.getGameCycle();
        final int rotation = obj.getTileObjectAngle().getAngle() >> 9;
        final int type = obj.getConfig() & 0x1F;
        final int minX = event.getMinX() - latestPendingSpawn.getX();
        final int minY = event.getMinY() - latestPendingSpawn.getY();
        final int maxX = event.getMaxX() - latestPendingSpawn.getX();
        final int maxY = event.getMaxY() - latestPendingSpawn.getY();
        final int delay = event.getAnimationCycleStart() - clientTime;
        final int duration = (event.getAnimationCycleEnd() - clientTime) - delay;
        final StringBuilder locCombineBuilder = new StringBuilder();
        locCombineBuilder.append("LocCombine(");
        String name = getName(NamedVariableType.Object, obj.getId());
        if (name != null) {
            name = "name = " + name;
        } else {
            name = "id = " + obj.getId();
        }
        locCombineBuilder.append("mapObject = MapObject(").append(name)
                .append(", type = ").append(type).append(", rotation = ").append(rotation).append(", ").append(formatLocation(objectLocation)).append("), ");
        locCombineBuilder.append("delay = ").append(delay).append(", ");
        locCombineBuilder.append("duration = ").append(duration).append(", ");
        if (rsCoordFormat.isSelected()) {
            locCombineBuilder.append("minXOffset = ").append(minX).append(", ");
            locCombineBuilder.append("maxXOffset = ").append(maxX).append(", ");
            locCombineBuilder.append("minZOffset = ").append(minY).append(", ");
            locCombineBuilder.append("maxZOffset = ").append(maxY);
        } else {
            locCombineBuilder.append("minXOffset = ").append(minX).append(", ");
            locCombineBuilder.append("maxXOffset = ").append(maxX).append(", ");
            locCombineBuilder.append("minYOffset = ").append(minY).append(", ");
            locCombineBuilder.append("maxYOffset = ").append(maxY);
        }
        locCombineBuilder.append(")");
        addLine(formatActor(event.getPlayer()), locCombineBuilder.toString(), isActorConsoleLogged(event.getPlayer()), combinedObjects);
    }

    private Model getModel(final TileObject obj, final int type, final int rotation, final int x, final int y) {
        ObjectComposition def = client.getObjectDefinition(obj.getId());
        int width;
        int length;

        if (rotation == 1 || rotation == 3) {
            width = def.getSizeY();
            length = def.getSizeX();
        } else {
            width = def.getSizeX();
            length = def.getSizeY();
        }

        int x1 = x + (width >> 1);
        int x2 = x + (width + 1 >> 1);
        int y1 = y + (length >> 1);
        int y2 = y + (length + 1 >> 1);

        int[][] heights = client.getTileHeights()[obj.getPlane()];
        int averageHeight = heights[x2][y2] + heights[x1][y2] + heights[x2][y1] + heights[x1][y1] >> 2;
        int preciseX = (x << 7) + (width << 6);
        int preciseY = (y << 7) + (length << 6);
        return def.getObjectModel(type, rotation, heights, preciseX, averageHeight, preciseY);
    }


    /**
     * Transforms a list of slots into a list of slot ranges.
     * A list of [1, 2, 3, 8, 9, 11] would get transformed to [(1, 3), (8, 9), (11, 11)].
     */
    private List<Pair<Integer, Integer>> getSlotRanges(List<Integer> slots) {
        final List<Pair<Integer, Integer>> slotRanges = new ArrayList<>();
        int start = -1;
        int last = -1;
        Collections.sort(slots);
        for (int slot : slots) {
            if (start == -1) {
                start = slot;
                last = slot;
                continue;
            }
            if (slot == last + 1) {
                last++;
                continue;
            }
            slotRanges.add(Pair.of(start, last));
            start = -1;
            last = -1;
        }
        if (start != -1) slotRanges.add(Pair.of(start, last));
        return slotRanges;
    }

    /**
     * It is possible for some variables to be uninitialized on login, so as an uber cheap fix, let's try-catch validate if the actor is fully initialized.
     */
    private boolean isActorPositionUninitialized(Actor actor) {
        try {
            return actor.getWorldLocation() == null;
        } catch (NullPointerException ignored) {
            return true;
        }
    }

    private String formatActor(Actor actor) {
        WorldPoint actorWorldLocation = actor.getWorldLocation();
        return formatActor(actor, actorWorldLocation);
    }

    private String formatActor(Actor actor, final WorldPoint actorWorldLocation) {
        String coordinateString = formatLocationOmitDecorations(actorWorldLocation);
        if (actor instanceof Player) {
            return ("Player(" + (actor.getName() + ", idx: " + ((Player) actor).getId() + ", " + coordinateString + ")"));
        } else if (actor instanceof NPC) {
            NPCComposition composition = ((NPC) actor).getComposition();
            String id = composition == null ? "unidentified" : composition.getId() + "";
            String name = composition == null ? null : getName(NamedVariableType.Npc, composition.getId());
            if (name != null) {
                name = "name: " + name;
            } else {
                name = "id: " + id;
            }
            return ("Npc(" + (actor.getName() + ", idx: " + ((NPC) actor).getIndex() + ", " + name + ", " + coordinateString + ")"));
        }
        return ("UnknownActor(" + coordinateString + ")");
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    private void resetOutputFile() {
        File folder = new File(Configuration.INSTANCE.getMETEOR_DIR() + "/event-inspector-logs/");
        folder.mkdirs();
        outputFile = new File(folder, new SimpleDateFormat("yyyy-MM-dd HH-mm-sss").format(new Date()) + ".txt");
    }

    @Override
    public void onGameStateChanged(GameStateChanged event) {
        if (event.getGameState() == GameState.LOGIN_SCREEN && !eventBuffer.isEmpty()) {
            writeToFile();
        } else if (event.getGameState() == LOGGED_IN) {
            addInitializationLine();
        }
    }

    private void writeSettingsFile() {
        try {
            synchronized (settingsFile) {
                BufferedWriter writer = new BufferedWriter(new FileWriter(settingsFile));
                for (JCheckBox setting : allSettings) {
                    writer.write(setting.getText() + "=" + setting.isSelected());
                    writer.newLine();
                }
                final Dimension size = this.getSize();
                writer.write("height=" + size.getHeight());
                writer.newLine();
                writer.write("width=" + size.getWidth());
                writer.newLine();
                writer.write("interval=" + writeInterval);
                writer.newLine();
                writer.write("maxLogEntries=" + maxLogEntries);
                writer.newLine();
                writer.flush();
                writer.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void readSettingsFile() {
        try {
            synchronized (settingsFile) {
                BufferedReader reader = new BufferedReader(new FileReader(settingsFile));
                String line;
                double height = -1;
                double width = -1;
                while ((line = reader.readLine()) != null) {
                    String[] split = line.split("=");
                    String label = split[0];
                    switch (label) {
                        case "height":
                            height = Double.parseDouble(split[1]);
                            continue;
                        case "width":
                            width = Double.parseDouble(split[1]);
                            continue;
                        case "interval":
                            writeInterval = Integer.parseInt(split[1]);
                            continue;
                        case "maxLogEntries":
                            maxLogEntries = Integer.parseInt(split[1]);
                            continue;
                    }
                    boolean value = Boolean.parseBoolean(split[1]);
                    for (JCheckBox checkBox : allSettings) {
                        if (checkBox.getText().equals(label)) {
                            checkBox.setSelected(value);
                        }
                    }
                }
                /* Just in case, if necessary, can restore the panel's original size by making it tiny and restarting the plugin. */
                if (height > 300 && width > 500) {
                    setSize(new Dimension((int) width, (int) height));
                }
                /* Add the listener only after the saved size has been read from the file, otherwise we will override it before it gets the chance to load. */
                addComponentListener(new ComponentListener() {
                    @Override
                    public void componentResized(ComponentEvent e) {
                        writeSettingsFile();
                    }

                    @Override
                    public void componentMoved(ComponentEvent e) {
                    }

                    @Override
                    public void componentShown(ComponentEvent e) {
                    }

                    @Override
                    public void componentHidden(ComponentEvent e) {
                    }
                });
                if (intervalSlider != null) {
                    intervalSlider.setValue(writeInterval);
                }
                if (maxLogEntriesSlider != null) {
                    maxLogEntriesSlider.setValue(maxLogEntries);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void open() {
        if (isVisible()) return;

        resetOutputFile();
        if (settingsFile.exists()) {
            readSettingsFile();
        }
        openDictionary();
        try {
            InputStream soundsInput = EventInspector.class.getResourceAsStream("/sound_effects.txt");
            if (soundsInput != null) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(soundsInput));
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] split = line.split(":");
                    if (split.length == 2) {
                        try {
                            String name = split[0];
                            int id = Integer.parseInt(split[1]);
                            soundEffectNames.put(id, name);
                        } catch (Exception e) {
                            log.error("Error reading sound name: " + Arrays.toString(split), e);
                        }
                    }
                }
            }
        } catch (Exception e) {
            log.error("Error loading sound names", e);
        }

        subscribe();
        for (Skill skill : Skill.values()) {
            int xp = client.getSkillExperience(skill);
            cachedExperienceMap.put(skill, xp);
            cachedBaseLevelsMap.put(skill, client.getRealSkillLevel(skill));
            cachedBoostedLevelsMap.put(skill, client.getBoostedSkillLevel(skill));
        }
        previousRunEnergy = client.getEnergy();
        if (oldVarps == null) {
            oldVarps = new int[client.getVarps().length];
            oldVarps2 = new int[client.getVarps().length];
        }
        varbits = HashMultimap.create();

        clientThread.invoke(() -> {
            IndexDataBase indexVarbits = client.getIndexConfig();
            final int[] varbitIds = indexVarbits.getFileIds(VARBITS_ARCHIVE_ID);
            for (int id : varbitIds) {
                VarbitComposition varbit = client.getVarbit(id);
                if (varbit != null) {
                    varbits.put(varbit.getIndex(), id);
                }
            }
        });
        addInitializationLine();
        super.open();
    }

    private final File dictionaryFile = new File(Configuration.INSTANCE.getMETEOR_DIR().getAbsolutePath() + "/event-inspector-mappings.txt");
    private static final Map<NamedVariableType, Map<Integer, String>> dictionaries = new HashMap<>();
    private final List<WatchService> watchServices = new ArrayList<>();
    private void openDictionary() {
        try {
            synchronized (dictionaryFile) {
                executor = Executors.newSingleThreadScheduledExecutor();
                BufferedReader reader = new BufferedReader(new FileReader(dictionaryFile));
                String line;
                String path = null;
                String suffix = null;
                while ((line = reader.readLine()) != null) {
                    String[] split = line.split("=");
                    String label = split[0];
                    switch (label) {
                        case "path":
                            path = split[1];
                            continue;
                        case "suffix":
                            suffix = split[1];
                            continue;
                    }
                }
                Preconditions.checkNotNull(path);
                Preconditions.checkNotNull(suffix);
                File folder = new File(path);
                File[] files = folder.listFiles();
                if (files != null) {
                    final String suf = suffix;
                    for (NamedVariableType type : NamedVariableType.values()) {
                        String lowercase = type.toString().toLowerCase();
                        Optional<File> matchingFile = Arrays.stream(files)
                                .filter((file) -> file.getName().equalsIgnoreCase(lowercase + "." + suf))
                                .findFirst();
                        if (matchingFile.isPresent()) {
                            File file = matchingFile.get();
                            if (!file.exists()) continue;
                            readFile(type, file, false);
                        }
                    }
                }
                reader.close();
                launchWatcher(suffix, Path.of(path).toFile());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void closeDictionary() throws IOException {
        dictionaries.clear();
        if (executor != null) {
            executor.shutdown();
        }
        for (WatchService service : watchServices) {
            service.close();
        }
        watchServices.clear();
    }

    private ScheduledExecutorService executor;

    private void readFile(NamedVariableType type, File file, boolean reload) throws IOException {
        Map<Integer, String> dictionary = new HashMap<>();
        dictionaries.put(type, dictionary);
        BufferedReader dictionaryReader = new BufferedReader(new FileReader(file));
        int count = 0;
        String line;
        while ((line = dictionaryReader.readLine()) != null) {
            count++;
            try {
                String[] split = line.split(":");
                if (split.length < 2) continue;
                String name = split[0];
                int id = Integer.parseInt(split[1]);
                dictionary.put(id, name);
            } catch (Exception e) {
                log.info("Error parsing line " + (count - 1) + ": " + line);
            }
        }
        dictionaryReader.close();
        log.info((reload ? "Reloaded " : "Loaded ") + count + " " + type + " namings.");
    }

    private void launchWatcher(String suffix, File file) throws IOException {
        WatchService watchService = FileSystems.getDefault().newWatchService();
        watchServices.add(watchService);
        file.toPath().register(watchService, StandardWatchEventKinds.ENTRY_MODIFY);
        executor.scheduleWithFixedDelay(() -> {
            WatchKey key;
            while ((key = watchService.poll()) != null) {
                for (WatchEvent<?> event : key.pollEvents()) {
                    if (event.kind() == StandardWatchEventKinds.ENTRY_MODIFY) {
                        Object context = event.context();
                        if (context != null) {
                            String str = context.toString();
                            Optional<NamedVariableType> varType = Arrays.stream(NamedVariableType.values())
                                    .filter((type) -> str.equalsIgnoreCase(type.toString().toLowerCase() + "." + suffix))
                                    .findFirst();
                            if (varType.isPresent()) {
                                NamedVariableType type = varType.get();
                                try {
                                    dictionaries.remove(type);
                                    readFile(type, Paths.get(file.getPath(), str).toFile(), true);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                }
                key.reset();
            }
        }, 5, 5, TimeUnit.SECONDS);
    }

    private void addInitializationLine() {
        //noinspection deprecation
        addLine(
                "Initialization",
                "Logged into account " + client.getUsername() + ".",
                client.getTickCount(),
                true,
                null,
                false
        );
    }

    @Override
    public void close() {
        if (!isVisible()) return;

        super.close();
        tracker.removeAll();
        writeToFile();
        outputFile = null;
        try {
            closeDictionary();
        } catch (IOException e) {
            e.printStackTrace();
        }
        unsubscribe();
    }

    private PlayerAppearance getPlayerAppearance(Player player) {
        final PlayerComposition composition = player.getPlayerComposition();
        return new PlayerAppearance(player.getCombatLevel(), composition == null ? null : composition.isFemale(), composition == null ? null :
                composition.getColors(), composition == null ? null : composition.getEquipmentIds(), composition == null ? null :
                composition.getTransformedNpcId(), player.getOverheadIcon(), player.getSkullIcon(), player.getTotalLevel(), player.isHidden(),
                player.getRunAnimation(), player.getWalkAnimation(), player.getWalkRotate180(), player.getWalkRotateLeft(), player.getWalkRotateRight(),
                player.getIdlePoseAnimation(), player.getIdleRotateLeft(), composition == null ? null : composition.getColorTextureOverrides());
    }

    @Data
    @AllArgsConstructor
    private static class FaceTile {
        private int direction;
        private boolean instant;
    }

    @Data
    private static class PlayerAppearance {
        private final int combatLevel;
        private final Boolean female;
        private final int[] colors;
        private final int[] equipmentIds;
        private final Integer transformedNpcId;
        private final HeadIcon headIcon;
        private final SkullIcon skullIcon;
        private final int skillLevel;
        private final boolean hidden;
        private final int runAnim;
        private final int walkForwardAnim;
        private final int walkBackwardsAnim;
        private final int walkLeftAnim;
        private final int walkRightAnim;
        private final int standAnim;
        private final int turnOnSpotAnim;
        private final ObjTypeCustomisation[] recolouredEquipmentItems;

        private String getNameOrId(NamedVariableType type, int id) {
            String name = getName(type, id);
            if (name == null) return "" + id;
            return name;
        }

        public String getDifferences(PlayerAppearance previous) {
            final StringBuilder builder = new StringBuilder();
            if (previous == null || combatLevel != previous.combatLevel) {
                builder.append("combatLevel = ").append(combatLevel).append(", ");
            }
            if (previous == null || getFemale() != previous.getFemale()) {
                builder.append("female = ").append(getFemale()).append(", ");
            }
            if (previous == null || !Objects.equals(transformedNpcId, previous.transformedNpcId)) {
                String name = getName(NamedVariableType.Npc, getTransformedNpcId());
                if (name != null) {
                    builder.append("npcTransform = ").append(name).append(", ");
                } else {
                    builder.append("npcTransform = ").append(getTransformedNpcId()).append(", ");
                }
            }
            if (previous == null || headIcon != previous.headIcon) {
                builder.append("headIcon = ").append(headIcon).append(", ");
            }
            if (previous == null || skullIcon != previous.skullIcon) {
                builder.append("skullIcon = ").append(skullIcon).append(", ");
            }
            if (previous == null || skillLevel != previous.skillLevel) {
                builder.append("skillLevel = ").append(skillLevel).append(", ");
            }
            if (previous == null || hidden != previous.hidden) {
                builder.append("hidden = ").append(hidden).append(", ");
            }
            if (previous == null || runAnim != previous.runAnim) builder.append("runAnim = ").append(getNameOrId(NamedVariableType.Animation, runAnim)).append(", ");
            if (previous == null || walkForwardAnim != previous.walkForwardAnim) builder.append("walkForwardAnim = ").append(getNameOrId(NamedVariableType.Animation, walkForwardAnim)).append(", ");
            if (previous == null || walkBackwardsAnim != previous.walkBackwardsAnim)
                builder.append("walkBackwardsAnim = ").append(getNameOrId(NamedVariableType.Animation, walkBackwardsAnim)).append(", ");
            if (previous == null || walkLeftAnim != previous.walkLeftAnim) builder.append("walkLeftAnim = ").append(getNameOrId(NamedVariableType.Animation, walkLeftAnim)).append(", ");
            if (previous == null || walkRightAnim != previous.walkRightAnim) builder.append("walkRightAnim = ").append(getNameOrId(NamedVariableType.Animation, walkRightAnim)).append(", ");
            if (previous == null || standAnim != previous.standAnim) builder.append("standAnim = ").append(getNameOrId(NamedVariableType.Animation, standAnim)).append(", ");
            if (previous == null || turnOnSpotAnim != previous.turnOnSpotAnim) builder.append("turnOnSpotAnim = ").append(getNameOrId(NamedVariableType.Animation, turnOnSpotAnim)).append(", ");
            if (previous == null || !Arrays.equals(getColors(), previous.getColors())) {
                builder.append("colours = ").append(Arrays.toString(getColors())).append(", ");
            }
            if (previous == null || !Arrays.equals(getEquipmentIds(), previous.getEquipmentIds())) {
                int[] body = new int[getEquipmentIds().length];
                int[] oldBody = new int[getEquipmentIds().length];
                int[] equipment = new int[getEquipmentIds().length];
                int[] oldEquipment = new int[getEquipmentIds().length];
                for (int i = 0; i < body.length; i++) {
                    int value = equipmentIds[i];
                    int oldValue = previous == null ? 0 : previous.equipmentIds == null ? 0 : previous.equipmentIds[i];
                    if (value < 512) {
                        body[i] = value == 0 ? 0 : (value - 256);
                    } else {
                        equipment[i] = value - 512;
                    }
                    if (oldValue < 512) {
                        oldBody[i] = oldValue == 0 ? 0 : (oldValue - 256);
                    } else {
                        oldEquipment[i] = oldValue - 512;
                    }
                }
                if (!Arrays.equals(body, oldBody)) {
                    builder.append("body = ").append(Arrays.toString(body)).append(", ");
                }
                if (!Arrays.equals(equipment, oldEquipment)) {
                    builder.append("equipment = ").append(Arrays.toString(equipment)).append(", ");
                }
            }
            if (shouldFormatEquipmentColours(previous)) {
                builder.append("itemAppearance = [").append(formatEquipmentRecolours()).append("], ");
            }

            if (builder.length() >= 2) builder.delete(builder.length() - 2, builder.length());
            return builder.toString();
        }

        private boolean shouldFormatEquipmentColours(PlayerAppearance previous) {
            if (previous == null || (recolouredEquipmentItems == null && previous.recolouredEquipmentItems != null) || (recolouredEquipmentItems != null && previous.recolouredEquipmentItems == null)) {
                return true;
            }
            if (recolouredEquipmentItems != null) {
                for (int i = 0; i < recolouredEquipmentItems.length; i++) {
                    final ObjTypeCustomisation current = recolouredEquipmentItems[i];
                    final ObjTypeCustomisation prev = previous.recolouredEquipmentItems[i];
                    if ((current == null && prev != null) || (current != null && prev == null)) return true;
                    if (current == null) continue;
                    if (!Arrays.equals(current.getColorToReplaceWith(), prev.getColorToReplaceWith()) || !Arrays.equals(current.getTextureToReplaceWith(), prev.getTextureToReplaceWith())) {
                        return true;
                    }
                }
            }
            return false;
        }

        private String formatEquipmentRecolours() {
            if (recolouredEquipmentItems == null) return "null";
            final StringBuilder recolourBuilder = new StringBuilder();
            final StringBuilder retextureBuilder = new StringBuilder();
            for (int i = 0; i < recolouredEquipmentItems.length; i++) {
                if (recolouredEquipmentItems[i] != null && recolouredEquipmentItems[i].getColorToReplaceWith() != null) {
                    recolourBuilder.append(i).append(" = ").append(Arrays.toString(recolouredEquipmentItems[i].getColorToReplaceWith())).append(", ");
                }
                if (recolouredEquipmentItems[i] != null && recolouredEquipmentItems[i].getTextureToReplaceWith() != null) {
                    retextureBuilder.append(i).append(" = ").append(Arrays.toString(recolouredEquipmentItems[i].getTextureToReplaceWith())).append(", ");
                }
            }
            if (recolourBuilder.length() == 0 && retextureBuilder.length() == 0) return "null";
            if (recolourBuilder.length() >= 2) recolourBuilder.delete(recolourBuilder.length() - 2, recolourBuilder.length());
            if (retextureBuilder.length() >= 2) retextureBuilder.delete(retextureBuilder.length() - 2, retextureBuilder.length());
            final StringBuilder produce = new StringBuilder();
            if (recolourBuilder.length() != 0) {
                produce.append("recolour = {").append(recolourBuilder).append("}, ");
            }
            if (retextureBuilder.length() != 0) {
                produce.append("retexture = {").append(retextureBuilder).append("}, ");
            }
            if (produce.length() >= 2) produce.delete(produce.length() - 2, produce.length());
            return produce.toString();
        }
    }

    @AllArgsConstructor
    private enum MinimapState {
        Enabled(0),
        MapUnclickable(1),
        HideMap(2),
        HideCompass(3),
        HideCompassMapUnclickable(4),
        Disabled(5);
        private final int state;

        public static MinimapState getState(int state) {
            for (MinimapState minimapState : values()) {
                if (minimapState.state == state) return minimapState;
            }
            return null;
        }
    }

    public static String getName(NamedVariableType type, int id) {
        final Map<Integer, String> dictionary = dictionaries.get(type);
        if (dictionary == null) return null;
        String name = dictionary.get(id);
        if (name == null) {
            return null;
        }
        return "\"" + name + "\", id = " + id;
    }

    private enum NamedVariableType {
        Animation,
        Graphics,
        Sound,
        Object,
        Npc,
        Item,
        Clientscript,
        Interface,
        Inventory,
        Jingle,
        Varp,
        Varbit,
        Model,
    }

    @SuppressWarnings("PointlessBitwiseExpression")
    @AllArgsConstructor
    private enum InterfaceEvent {
        Continue(1 << 0),
        ClickOp1(1 << 1),
        ClickOp2(1 << 2),
        ClickOp3(1 << 3),
        ClickOp4(1 << 4),
        ClickOp5(1 << 5),
        ClickOp6(1 << 6),
        ClickOp7(1 << 7),
        ClickOp8(1 << 8),
        ClickOp9(1 << 9),
        ClickOp10(1 << 10),
        UseOnGroundItem(1 << 11),
        UseOnNpc(1 << 12),
        UseOnObject(1 << 13),
        UseOnPlayer(1 << 14),
        UseOnInventory(1 << 15),
        UseOnComponent(1 << 16),
        DragDepth1(1 << 17),
        DragDepth2(2 << 17),
        DragDepth3(3 << 17),
        DragDepth4(4 << 17),
        DragDepth5(5 << 17),
        DragDepth6(6 << 17),
        DragDepth7(7 << 17),
        DragTargetable(1 << 20),
        ComponentTargetable(1 << 21);

        private final int value;

        private static String sanitize(final int packedEvents) {
            final StringBuilder events = new StringBuilder();
            for (InterfaceEvent event : values()) {
                if ((packedEvents & event.value) != event.value) continue;
                events.append(event).append(", ");
            }
            if (events.length() >= 2) {
                events.delete(events.length() - 2, events.length());
            }
            return events.toString();
        }
    }
}
