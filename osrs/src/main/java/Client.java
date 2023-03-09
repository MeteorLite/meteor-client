import com.jagex.oldscape.pub.OAuthApi;
import com.jagex.oldscape.pub.OtlTokenRequester;
import com.jagex.oldscape.pub.RefreshAccessTokenRequester;
import com.jagex.oldscape.pub.RefreshAccessTokenResponse;
import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSClient;

@Implements("Client")
@ObfuscatedName("client")
public final class Client extends GameEngine implements Usernamed, OAuthApi {
   @ObfuscatedName("vk")
   @Export("viewportOffsetX")
   static int viewportOffsetX;
   @ObfuscatedName("tt")
   @Export("playingJingle")
   static boolean playingJingle;
   @ObfuscatedName("va")
   @Export("viewportOffsetY")
   static int viewportOffsetY;
   @ObfuscatedName("wq")
   public static int field447;
   @ObfuscatedName("wa")
   @ObfuscatedSignature(
      descriptor = "Lcy;"
   )
   static final ApproximateRouteStrategy field444;
   @ObfuscatedName("tc")
   @Export("isCameraLocked")
   static boolean isCameraLocked;
   @ObfuscatedName("uq")
   static boolean field609;
   @ObfuscatedName("wi")
   static int[] field416;
   @ObfuscatedName("wy")
   static int[] field645;
   @ObfuscatedName("ve")
   static int field628;
   @ObfuscatedName("vn")
   @ObfuscatedSignature(
      descriptor = "Llc;"
   )
   @Export("playerAppearance")
   static PlayerComposition playerAppearance;
   @ObfuscatedName("ts")
   @Export("soundEffectCount")
   static int soundEffectCount;
   @ObfuscatedName("tx")
   @Export("soundEffectIds")
   static int[] soundEffectIds;
   @ObfuscatedName("vv")
   static int field590;
   @ObfuscatedName("ta")
   @Export("queuedSoundEffectLoops")
   static int[] queuedSoundEffectLoops;
   @ObfuscatedName("tq")
   @Export("queuedSoundEffectDelays")
   static int[] queuedSoundEffectDelays;
   @ObfuscatedName("tb")
   @ObfuscatedSignature(
      descriptor = "[Lbt;"
   )
   @Export("soundEffects")
   static SoundEffect[] soundEffects;
   @ObfuscatedName("to")
   @Export("soundLocations")
   static int[] soundLocations;
   @ObfuscatedName("wk")
   @Export("archiveLoaders")
   static ArrayList archiveLoaders;
   @ObfuscatedName("wn")
   @Export("archiveLoadersDone")
   static int archiveLoadersDone;
   @ObfuscatedName("vx")
   @ObfuscatedSignature(
      descriptor = "Lkt;"
   )
   @Export("Widget_cachedModels")
   static EvictingDualNodeHashTable Widget_cachedModels;
   @ObfuscatedName("vt")
   @ObfuscatedSignature(
      descriptor = "Lkt;"
   )
   @Export("Widget_cachedFonts")
   static EvictingDualNodeHashTable Widget_cachedFonts;
   @ObfuscatedName("uz")
   @Export("cameraShaking")
   static boolean[] cameraShaking;
   @ObfuscatedName("vp")
   @ObfuscatedSignature(
      descriptor = "Lrb;"
   )
   @Export("platformInfoProvider")
   static PlatformInfoProvider platformInfoProvider;
   @ObfuscatedName("vz")
   @ObfuscatedSignature(
      descriptor = "Lpe;"
   )
   @Export("archive5")
   static class394 archive5;
   @ObfuscatedName("ur")
   @Export("cameraShakeIntensity")
   static int[] cameraShakeIntensity;
   @ObfuscatedName("um")
   @Export("cameraMoveIntensity")
   static int[] cameraMoveIntensity;
   @ObfuscatedName("ux")
   @Export("cameraShakeSpeed")
   static int[] cameraShakeSpeed;
   @ObfuscatedName("un")
   static short field418;
   @ObfuscatedName("up")
   static int[] cameraShakeCycle;
   @ObfuscatedName("ud")
   static short field616;
   @ObfuscatedName("vg")
   static short field621;
   @ObfuscatedName("vd")
   static short field622;
   @ObfuscatedName("vh")
   static short field620;
   @ObfuscatedName("vb")
   @Export("viewportZoom")
   static int viewportZoom;
   @ObfuscatedName("vl")
   static short field619;
   @ObfuscatedName("vr")
   @ObfuscatedSignature(
      descriptor = "[Lnd;"
   )
   @Export("grandExchangeOffers")
   static GrandExchangeOffer[] grandExchangeOffers;
   @ObfuscatedName("vq")
   @Export("viewportWidth")
   static int viewportWidth;
   @ObfuscatedName("vm")
   @Export("viewportHeight")
   static int viewportHeight;
   @ObfuscatedName("tf")
   @Export("currentTrackGroupId")
   static int currentTrackGroupId;
   @ObfuscatedName("we")
   static int field587;
   @ObfuscatedName("ut")
   @Export("zoomHeight")
   static short zoomHeight;
   @ObfuscatedName("ui")
   @Export("zoomWidth")
   static short zoomWidth;
   @ObfuscatedName("vw")
   @ObfuscatedSignature(
      descriptor = "Lck;"
   )
   @Export("GrandExchangeEvents_worldComparator")
   static GrandExchangeOfferOwnWorldComparator GrandExchangeEvents_worldComparator;
   @ObfuscatedName("wf")
   static int field637;
   @ObfuscatedName("wl")
   static List field617;
   @ObfuscatedName("bf")
   @Export("lockMouseRecorder")
   static boolean lockMouseRecorder = true;
   @ObfuscatedName("bw")
   @Export("worldId")
   public static int worldId = 1;
   @ObfuscatedName("bi")
   @Export("worldProperties")
   static int worldProperties = 0;
   @ObfuscatedName("ca")
   @Export("gameBuild")
   static int gameBuild = 0;
   @ObfuscatedName("cj")
   @Export("isMembersWorld")
   public static boolean isMembersWorld = false;
   @ObfuscatedName("cn")
   @Export("isLowDetail")
   static boolean isLowDetail = false;
   @ObfuscatedName("cy")
   @Export("param21")
   static int param21 = -1;
   @ObfuscatedName("ck")
   @Export("clientType")
   static int clientType = -1;
   @ObfuscatedName("cz")
   static int field363 = -1;
   @ObfuscatedName("cg")
   @Export("onMobile")
   static boolean onMobile = false;
   @ObfuscatedName("ch")
   @Export("param25")
   static int param25 = 212;
   @ObfuscatedName("du")
   @Export("gameState")
   static int gameState = 0;
   @ObfuscatedName("dn")
   @Export("isLoading")
   static boolean isLoading = true;
   @ObfuscatedName("di")
   @Export("cycle")
   static int cycle = 0;
   @ObfuscatedName("en")
   @Export("mouseLastLastPressedTimeMillis")
   static long mouseLastLastPressedTimeMillis = -1L;
   @ObfuscatedName("ee")
   @Export("lastMouseRecordX")
   static int lastMouseRecordX = -1;
   @ObfuscatedName("ex")
   @Export("lastMouseRecordY")
   static int lastMouseRecordY = -1;
   @ObfuscatedName("ep")
   @Export("lastMouseRecordTime")
   static long lastMouseRecordTime = -1L;
   @ObfuscatedName("eb")
   @Export("hadFocus")
   static boolean hadFocus = true;
   @ObfuscatedName("er")
   @Export("rebootTimer")
   static int rebootTimer = 0;
   @ObfuscatedName("eo")
   @Export("hintArrowType")
   static int hintArrowType = 0;
   @ObfuscatedName("ev")
   @Export("hintArrowNpcIndex")
   static int hintArrowNpcIndex = 0;
   @ObfuscatedName("ef")
   @Export("hintArrowPlayerIndex")
   static int hintArrowPlayerIndex = 0;
   @ObfuscatedName("et")
   @Export("hintArrowX")
   static int hintArrowX = 0;
   @ObfuscatedName("el")
   @Export("hintArrowY")
   static int hintArrowY = 0;
   @ObfuscatedName("ec")
   @Export("hintArrowHeight")
   static int hintArrowHeight = 0;
   @ObfuscatedName("eg")
   @Export("hintArrowSubX")
   static int hintArrowSubX = 0;
   @ObfuscatedName("es")
   @Export("hintArrowSubY")
   static int hintArrowSubY = 0;
   @ObfuscatedName("em")
   @ObfuscatedSignature(
      descriptor = "Ldy;"
   )
   @Export("playerAttackOption")
   static AttackOption playerAttackOption;
   @ObfuscatedName("ey")
   @ObfuscatedSignature(
      descriptor = "Ldy;"
   )
   @Export("npcAttackOption")
   static AttackOption npcAttackOption;
   @ObfuscatedName("fz")
   @Export("titleLoadingStage")
   static int titleLoadingStage;
   @ObfuscatedName("fe")
   @Export("js5ConnectState")
   static int js5ConnectState;
   @ObfuscatedName("fl")
   @Export("js5Cycles")
   static int js5Cycles;
   @ObfuscatedName("gk")
   @Export("js5Errors")
   static int js5Errors;
   @ObfuscatedName("go")
   @Export("loginState")
   static int loginState;
   @ObfuscatedName("gn")
   static int field423;
   @ObfuscatedName("ga")
   static int field390;
   @ObfuscatedName("gz")
   static int field362;
   @ObfuscatedName("gu")
   @ObfuscatedSignature(
      descriptor = "Lft;"
   )
   static class136 field392;
   @ObfuscatedName("gw")
   @ObfuscatedSignature(
      descriptor = "Lsg;"
   )
   static class482 field393;
   @ObfuscatedName("hv")
   static final String field374;
   @ObfuscatedName("hq")
   @Export("Login_isUsernameRemembered")
   static boolean Login_isUsernameRemembered;
   @ObfuscatedName("hp")
   @ObfuscatedSignature(
      descriptor = "Lcf;"
   )
   @Export("secureRandomFuture")
   static SecureRandomFuture secureRandomFuture;
   @ObfuscatedName("hz")
   @Export("randomDatData")
   static byte[] randomDatData;
   @ObfuscatedName("ic")
   @ObfuscatedSignature(
      descriptor = "[Ldz;"
   )
   @Export("npcs")
   static NPC[] npcs;
   @ObfuscatedName("ip")
   @Export("npcCount")
   static int npcCount;
   @ObfuscatedName("is")
   @Export("npcIndices")
   static int[] npcIndices;
   @ObfuscatedName("im")
   static int field413;
   @ObfuscatedName("ij")
   static int[] field535;
   @ObfuscatedName("ii")
   @ObfuscatedSignature(
      descriptor = "Lep;"
   )
   @Export("packetWriter")
   public static final PacketWriter packetWriter;
   @ObfuscatedName("id")
   @Export("logoutTimer")
   static int logoutTimer;
   @ObfuscatedName("ih")
   @Export("hadNetworkError")
   static boolean hadNetworkError;
   @ObfuscatedName("ik")
   @ObfuscatedSignature(
      descriptor = "Los;"
   )
   @Export("timer")
   static Timer timer;
   @ObfuscatedName("iw")
   @Export("fontsMap")
   static HashMap fontsMap;
   @ObfuscatedName("it")
   static String field513;
   @ObfuscatedName("jc")
   static int field500;
   @ObfuscatedName("jp")
   static int field354;
   @ObfuscatedName("jg")
   static int field422;
   @ObfuscatedName("jm")
   static int field647;
   @ObfuscatedName("jo")
   static int field376;
   @ObfuscatedName("je")
   @ObfuscatedSignature(
      descriptor = "[Liz;"
   )
   @Export("collisionMaps")
   static CollisionMap[] collisionMaps;
   @ObfuscatedName("jq")
   @Export("isInInstance")
   static boolean isInInstance;
   @ObfuscatedName("jh")
   @Export("instanceChunkTemplates")
   static int[][][] instanceChunkTemplates;
   @ObfuscatedName("jy")
   @Export("OBJECT_TYPE_TO_STUB_TYPE")
   static final int[] OBJECT_TYPE_TO_STUB_TYPE;
   @ObfuscatedName("js")
   static int field504;
   @ObfuscatedName("km")
   static int field430;
   @ObfuscatedName("kn")
   static int field429;
   @ObfuscatedName("kh")
   static int field432;
   @ObfuscatedName("kf")
   static int field433;
   @ObfuscatedName("kw")
   static boolean field434;
   @ObfuscatedName("kj")
   @Export("alternativeScrollbarWidth")
   static int alternativeScrollbarWidth;
   @ObfuscatedName("ks")
   @Export("camAngleX")
   static int camAngleX;
   @ObfuscatedName("kq")
   @Export("camAngleY")
   static int camAngleY;
   @ObfuscatedName("kv")
   @Export("camAngleDY")
   static int camAngleDY;
   @ObfuscatedName("kl")
   @Export("camAngleDX")
   static int camAngleDX;
   @ObfuscatedName("kb")
   @Export("mouseCamClickedX")
   static int mouseCamClickedX;
   @ObfuscatedName("kz")
   @Export("mouseCamClickedY")
   static int mouseCamClickedY;
   @ObfuscatedName("kp")
   @Export("oculusOrbState")
   static int oculusOrbState;
   @ObfuscatedName("ke")
   @Export("camFollowHeight")
   static int camFollowHeight;
   @ObfuscatedName("lg")
   static int field443;
   @ObfuscatedName("lr")
   static int field612;
   @ObfuscatedName("lq")
   static int field472;
   @ObfuscatedName("lf")
   @Export("oculusOrbNormalSpeed")
   static int oculusOrbNormalSpeed;
   @ObfuscatedName("lz")
   @Export("oculusOrbSlowedSpeed")
   static int oculusOrbSlowedSpeed;
   @ObfuscatedName("lm")
   static int field448;
   @ObfuscatedName("lb")
   @Export("oculusOrbOnLocalPlayer")
   static boolean oculusOrbOnLocalPlayer;
   @ObfuscatedName("ld")
   @Export("packetIndicator")
   static int packetIndicator;
   @ObfuscatedName("lh")
   @Export("emitPackets")
   static boolean emitPackets;
   @ObfuscatedName("lp")
   static int field375;
   @ObfuscatedName("lw")
   @Export("overheadTextCount")
   static int overheadTextCount;
   @ObfuscatedName("lx")
   @Export("overheadTextLimit")
   static int overheadTextLimit;
   @ObfuscatedName("li")
   @Export("overheadTextXs")
   static int[] overheadTextXs;
   @ObfuscatedName("lt")
   @Export("overheadTextYs")
   static int[] overheadTextYs;
   @ObfuscatedName("ll")
   @Export("overheadTextAscents")
   static int[] overheadTextAscents;
   @ObfuscatedName("le")
   @Export("overheadTextXOffsets")
   static int[] overheadTextXOffsets;
   @ObfuscatedName("lu")
   @Export("overheadTextColors")
   static int[] overheadTextColors;
   @ObfuscatedName("ls")
   @Export("overheadTextEffects")
   static int[] overheadTextEffects;
   @ObfuscatedName("la")
   @Export("overheadTextCyclesRemaining")
   static int[] overheadTextCyclesRemaining;
   @ObfuscatedName("lc")
   @Export("overheadText")
   static String[] overheadText;
   @ObfuscatedName("lo")
   @Export("tileLastDrawnActor")
   static int[][] tileLastDrawnActor;
   @ObfuscatedName("ly")
   @Export("viewportDrawCount")
   static int viewportDrawCount;
   @ObfuscatedName("my")
   @Export("viewportTempX")
   static int viewportTempX;
   @ObfuscatedName("ma")
   @Export("viewportTempY")
   static int viewportTempY;
   @ObfuscatedName("mg")
   @Export("mouseCrossX")
   static int mouseCrossX;
   @ObfuscatedName("mw")
   @Export("mouseCrossY")
   static int mouseCrossY;
   @ObfuscatedName("mh")
   @Export("mouseCrossState")
   static int mouseCrossState;
   @ObfuscatedName("mv")
   @Export("mouseCrossColor")
   static int mouseCrossColor;
   @ObfuscatedName("mo")
   @Export("showMouseCross")
   static boolean showMouseCross;
   @ObfuscatedName("mi")
   static int field540;
   @ObfuscatedName("ms")
   @Export("showLoadingMessages")
   static boolean showLoadingMessages;
   @ObfuscatedName("mb")
   @ObfuscatedSignature(
      descriptor = "[Ldh;"
   )
   @Export("players")
   static Player[] players;
   @ObfuscatedName("mj")
   @Export("localPlayerIndex")
   static int localPlayerIndex;
   @ObfuscatedName("mr")
   @Export("isMembers")
   static int isMembers;
   @ObfuscatedName("mf")
   @Export("playerUUID")
   static long playerUUID;
   @ObfuscatedName("mc")
   @Export("renderSelf")
   static boolean renderSelf;
   @ObfuscatedName("mn")
   @Export("drawPlayerNames")
   static int drawPlayerNames;
   @ObfuscatedName("mk")
   static int field480;
   @ObfuscatedName("mp")
   static int[] field481;
   @ObfuscatedName("ns")
   @Export("playerMenuOpcodes")
   static final int[] playerMenuOpcodes;
   @ObfuscatedName("ne")
   @Export("playerMenuActions")
   static String[] playerMenuActions;
   @ObfuscatedName("nk")
   @Export("playerOptionsPriorities")
   static boolean[] playerOptionsPriorities;
   @ObfuscatedName("nz")
   static int[] field485;
   @ObfuscatedName("ng")
   @Export("combatTargetPlayerIndex")
   static int combatTargetPlayerIndex;
   @ObfuscatedName("nr")
   @ObfuscatedSignature(
      descriptor = "[[[Lnj;"
   )
   @Export("groundItems")
   static NodeDeque[][][] groundItems;
   @ObfuscatedName("nf")
   @ObfuscatedSignature(
      descriptor = "Lnj;"
   )
   @Export("pendingSpawns")
   static NodeDeque pendingSpawns;
   @ObfuscatedName("na")
   @ObfuscatedSignature(
      descriptor = "Lnj;"
   )
   @Export("projectiles")
   static NodeDeque projectiles;
   @ObfuscatedName("nw")
   @ObfuscatedSignature(
      descriptor = "Lnj;"
   )
   @Export("graphicsObjects")
   static NodeDeque graphicsObjects;
   @ObfuscatedName("nv")
   @Export("currentLevels")
   static int[] currentLevels;
   @ObfuscatedName("nd")
   @Export("levels")
   static int[] levels;
   @ObfuscatedName("no")
   @Export("experience")
   static int[] experience;
   @ObfuscatedName("nb")
   @Export("leftClickOpensMenu")
   static boolean leftClickOpensMenu;
   @ObfuscatedName("nu")
   @Export("isMenuOpen")
   static boolean isMenuOpen;
   @ObfuscatedName("nl")
   @Export("menuOptionsCount")
   static int menuOptionsCount;
   @ObfuscatedName("nj")
   @Export("menuArguments1")
   static int[] menuArguments1;
   @ObfuscatedName("nc")
   @Export("menuArguments2")
   static int[] menuArguments2;
   @ObfuscatedName("ni")
   @Export("menuOpcodes")
   static int[] menuOpcodes;
   @ObfuscatedName("ny")
   @Export("menuIdentifiers")
   static int[] menuIdentifiers;
   @ObfuscatedName("nn")
   @Export("menuItemIds")
   static int[] menuItemIds;
   @ObfuscatedName("nh")
   @Export("menuActions")
   static String[] menuActions;
   @ObfuscatedName("om")
   @Export("menuTargets")
   static String[] menuTargets;
   @ObfuscatedName("oa")
   @Export("menuShiftClick")
   static boolean[] menuShiftClick;
   @ObfuscatedName("ok")
   @Export("followerOpsLowPriority")
   static boolean followerOpsLowPriority;
   @ObfuscatedName("ov")
   @Export("tapToDrop")
   static boolean tapToDrop;
   @ObfuscatedName("og")
   @Export("showMouseOverText")
   static boolean showMouseOverText;
   @ObfuscatedName("oh")
   @Export("viewportX")
   static int viewportX;
   @ObfuscatedName("ob")
   @Export("viewportY")
   static int viewportY;
   @ObfuscatedName("ow")
   static int field410;
   @ObfuscatedName("oj")
   static int field424;
   @ObfuscatedName("od")
   @Export("isItemSelected")
   static int isItemSelected;
   @ObfuscatedName("on")
   @Export("isSpellSelected")
   static boolean isSpellSelected;
   @ObfuscatedName("oc")
   @Export("selectedSpellChildIndex")
   static int selectedSpellChildIndex;
   @ObfuscatedName("ot")
   @Export("selectedSpellItemId")
   static int selectedSpellItemId;
   @ObfuscatedName("os")
   static String field583;
   @ObfuscatedName("ox")
   static String field518;
   @ObfuscatedName("oo")
   @Export("rootInterface")
   static int rootInterface;
   @ObfuscatedName("of")
   @ObfuscatedSignature(
      descriptor = "Lrh;"
   )
   @Export("interfaceParents")
   static NodeHashTable interfaceParents;
   @ObfuscatedName("pm")
   static int field521;
   @ObfuscatedName("ps")
   static int field635;
   @ObfuscatedName("pe")
   @Export("chatEffects")
   static int chatEffects;
   @ObfuscatedName("pn")
   @ObfuscatedSignature(
      descriptor = "Lmy;"
   )
   @Export("meslayerContinueWidget")
   static Widget meslayerContinueWidget;
   @ObfuscatedName("pq")
   @Export("runEnergy")
   static int runEnergy;
   @ObfuscatedName("pd")
   @Export("weight")
   static int weight;
   @ObfuscatedName("py")
   @Export("staffModLevel")
   static int staffModLevel;
   @ObfuscatedName("pa")
   @Export("followerIndex")
   static int followerIndex;
   @ObfuscatedName("pk")
   @Export("playerMod")
   static boolean playerMod;
   @ObfuscatedName("pz")
   @ObfuscatedSignature(
      descriptor = "Lmy;"
   )
   @Export("viewportWidget")
   static Widget viewportWidget;
   @ObfuscatedName("po")
   @ObfuscatedSignature(
      descriptor = "Lmy;"
   )
   @Export("clickedWidget")
   static Widget clickedWidget;
   @ObfuscatedName("pb")
   @ObfuscatedSignature(
      descriptor = "Lmy;"
   )
   @Export("clickedWidgetParent")
   static Widget clickedWidgetParent;
   @ObfuscatedName("pl")
   @Export("widgetClickX")
   static int widgetClickX;
   @ObfuscatedName("ph")
   @Export("widgetClickY")
   static int widgetClickY;
   @ObfuscatedName("pc")
   @ObfuscatedSignature(
      descriptor = "Lmy;"
   )
   @Export("draggedOnWidget")
   static Widget draggedOnWidget;
   @ObfuscatedName("pt")
   static boolean field536;
   @ObfuscatedName("pf")
   static int field537;
   @ObfuscatedName("pj")
   static int field470;
   @ObfuscatedName("pr")
   static boolean field643;
   @ObfuscatedName("px")
   static int field445;
   @ObfuscatedName("pg")
   static int field541;
   @ObfuscatedName("pv")
   @Export("isDraggingWidget")
   static boolean isDraggingWidget;
   @ObfuscatedName("qa")
   @Export("cycleCntr")
   static int cycleCntr;
   @ObfuscatedName("qt")
   static int[] changedVarps;
   @ObfuscatedName("qx")
   static int changedVarpCount;
   @ObfuscatedName("qo")
   static int[] changedItemContainers;
   @ObfuscatedName("qs")
   static int changedItemContainersCount;
   @ObfuscatedName("qv")
   static int[] changedSkills;
   @ObfuscatedName("ql")
   static int changedSkillsCount;
   @ObfuscatedName("qf")
   static int[] field550;
   @ObfuscatedName("qd")
   static int field551;
   @ObfuscatedName("qq")
   @Export("chatCycle")
   static int chatCycle;
   @ObfuscatedName("qw")
   static int field573;
   @ObfuscatedName("qn")
   static int field399;
   @ObfuscatedName("qb")
   static int field555;
   @ObfuscatedName("qg")
   static int field357;
   @ObfuscatedName("qm")
   static int field516;
   @ObfuscatedName("qr")
   static int field558;
   @ObfuscatedName("qz")
   static int field559;
   @ObfuscatedName("rx")
   @Export("mouseWheelRotation")
   static int mouseWheelRotation;
   @ObfuscatedName("ru")
   @ObfuscatedSignature(
      descriptor = "Ltl;"
   )
   static class495 field561;
   @ObfuscatedName("ra")
   @ObfuscatedSignature(
      descriptor = "Lnj;"
   )
   @Export("scriptEvents")
   static NodeDeque scriptEvents;
   @ObfuscatedName("rt")
   @ObfuscatedSignature(
      descriptor = "Lnj;"
   )
   static NodeDeque field563;
   @ObfuscatedName("rb")
   @ObfuscatedSignature(
      descriptor = "Lnj;"
   )
   static NodeDeque field403;
   @ObfuscatedName("rk")
   @ObfuscatedSignature(
      descriptor = "Lnj;"
   )
   static NodeDeque field565;
   @ObfuscatedName("rc")
   @ObfuscatedSignature(
      descriptor = "Lrh;"
   )
   @Export("widgetFlags")
   static NodeHashTable widgetFlags;
   @ObfuscatedName("ry")
   @Export("rootWidgetCount")
   static int rootWidgetCount;
   @ObfuscatedName("rv")
   static int field568;
   @ObfuscatedName("rp")
   static boolean[] field594;
   @ObfuscatedName("rz")
   static boolean[] field570;
   @ObfuscatedName("rh")
   static boolean[] field571;
   @ObfuscatedName("ri")
   @Export("rootWidgetXs")
   static int[] rootWidgetXs;
   @ObfuscatedName("rn")
   @Export("rootWidgetYs")
   static int[] rootWidgetYs;
   @ObfuscatedName("rm")
   @Export("rootWidgetWidths")
   static int[] rootWidgetWidths;
   @ObfuscatedName("rl")
   @Export("rootWidgetHeights")
   static int[] rootWidgetHeights;
   @ObfuscatedName("re")
   @Export("gameDrawingMode")
   static int gameDrawingMode;
   @ObfuscatedName("rq")
   static long field569;
   @ObfuscatedName("rr")
   @Export("isResizable")
   static boolean isResizable;
   @ObfuscatedName("sd")
   static int[] field578;
   @ObfuscatedName("sv")
   @Export("publicChatMode")
   static int publicChatMode;
   @ObfuscatedName("st")
   @Export("tradeChatMode")
   static int tradeChatMode;
   @ObfuscatedName("sh")
   static String field510;
   @ObfuscatedName("si")
   static long[] crossWorldMessageIds;
   @ObfuscatedName("se")
   static int crossWorldMessageIdsIndex;
   @ObfuscatedName("sq")
   @ObfuscatedSignature(
      descriptor = "Lic;"
   )
   @Export("keyHandlerInstance")
   static class208 keyHandlerInstance;
   @ObfuscatedName("sy")
   @ObfuscatedSignature(
      descriptor = "Lhi;"
   )
   static class206 field585;
   @ObfuscatedName("ss")
   static int field586;
   @ObfuscatedName("sw")
   static int[] field514;
   @ObfuscatedName("so")
   static int[] field588;
   @ObfuscatedName("sg")
   @Export("timeOfPreviousKeyPress")
   static long timeOfPreviousKeyPress;
   @ObfuscatedName("sj")
   @ObfuscatedSignature(
      descriptor = "[Lfi;"
   )
   @Export("currentClanSettings")
   static ClanSettings[] currentClanSettings;
   @ObfuscatedName("sm")
   @ObfuscatedSignature(
      descriptor = "[Lgn;"
   )
   @Export("currentClanChannels")
   static ClanChannel[] currentClanChannels;
   @ObfuscatedName("sp")
   static int field592;
   @ObfuscatedName("sn")
   @Export("mapIconCount")
   static int mapIconCount;
   @ObfuscatedName("sa")
   @Export("mapIconXs")
   static int[] mapIconXs;
   @ObfuscatedName("sr")
   @Export("mapIconYs")
   static int[] mapIconYs;
   @ObfuscatedName("tk")
   @ObfuscatedSignature(
      descriptor = "[Lsn;"
   )
   @Export("mapIcons")
   static SpritePixels[] mapIcons;
   @ObfuscatedName("tl")
   @Export("destinationX")
   static int destinationX;
   @ObfuscatedName("tg")
   @Export("destinationY")
   static int destinationY;
   @ObfuscatedName("tw")
   @Export("minimapState")
   static int minimapState;
   @ObfuscatedName("gf")
   String field394;
   @ObfuscatedName("gp")
   @ObfuscatedSignature(
      descriptor = "Lam;"
   )
   class14 field395;
   @ObfuscatedName("gj")
   @ObfuscatedSignature(
      descriptor = "Lag;"
   )
   class18 field396;
   @ObfuscatedName("gv")
   @ObfuscatedSignature(
      descriptor = "Lcom/jagex/oldscape/pub/OtlTokenRequester;"
   )
   OtlTokenRequester field397;
   @ObfuscatedName("gt")
   Future field398;
   @ObfuscatedName("hb")
   boolean field479 = false;
   @ObfuscatedName("hc")
   @ObfuscatedSignature(
      descriptor = "Lag;"
   )
   class18 field400;
   @ObfuscatedName("hd")
   @ObfuscatedSignature(
      descriptor = "Lcom/jagex/oldscape/pub/RefreshAccessTokenRequester;"
   )
   RefreshAccessTokenRequester field401;
   @ObfuscatedName("hr")
   Future field425;
   @ObfuscatedName("hf")
   @ObfuscatedSignature(
      descriptor = "Lsy;"
   )
   Buffer field507;
   @ObfuscatedName("hu")
   @ObfuscatedSignature(
      descriptor = "Laq;"
   )
   class7 field531;
   @ObfuscatedName("hh")
   @Export("accountHash")
   long accountHash = -1L;

   static {
      playerAttackOption = AttackOption.AttackOption_hidden;
      npcAttackOption = AttackOption.AttackOption_hidden;
      titleLoadingStage = 0;
      js5ConnectState = 0;
      js5Cycles = 0;
      js5Errors = 0;
      loginState = 0;
      field423 = 0;
      field390 = 0;
      field362 = 0;
      field392 = class136.field1282;
      field393 = class482.field4023;
      int var1 = "com_jagex_auth_desktop_osrs:public".length();
      byte[] var2 = new byte[var1];

      for(int var3 = 0; var3 < var1; ++var3) {
         char var4 = "com_jagex_auth_desktop_osrs:public".charAt(var3);
         if (var4 > 127) {
            var2[var3] = 63;
         } else {
            var2[var3] = (byte)var4;
         }
      }

      field374 = GrandExchangeEvents.method1856(var2);
      Login_isUsernameRemembered = false;
      secureRandomFuture = new SecureRandomFuture();
      randomDatData = null;
      npcs = new NPC[65536];
      npcCount = 0;
      npcIndices = new int[65536];
      field413 = 0;
      field535 = new int[250];
      packetWriter = new PacketWriter();
      logoutTimer = 0;
      hadNetworkError = false;
      timer = new Timer();
      fontsMap = new HashMap();
      field500 = 0;
      field354 = 1;
      field422 = 0;
      field647 = 1;
      field376 = 0;
      collisionMaps = new CollisionMap[4];
      isInInstance = false;
      instanceChunkTemplates = new int[4][13][13];
      OBJECT_TYPE_TO_STUB_TYPE = new int[]{0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3};
      field504 = 0;
      field430 = 2301979;
      field429 = 5063219;
      field432 = 3353893;
      field433 = 7759444;
      field434 = false;
      alternativeScrollbarWidth = 0;
      camAngleX = 128;
      camAngleY = 0;
      camAngleDY = 0;
      camAngleDX = 0;
      mouseCamClickedX = 0;
      mouseCamClickedY = 0;
      oculusOrbState = 0;
      camFollowHeight = 50;
      field443 = 0;
      field612 = 0;
      field472 = 0;
      oculusOrbNormalSpeed = 12;
      oculusOrbSlowedSpeed = 6;
      field448 = 0;
      oculusOrbOnLocalPlayer = false;
      packetIndicator = 0;
      emitPackets = false;
      field375 = 0;
      overheadTextCount = 0;
      overheadTextLimit = 50;
      overheadTextXs = new int[overheadTextLimit];
      overheadTextYs = new int[overheadTextLimit];
      overheadTextAscents = new int[overheadTextLimit];
      overheadTextXOffsets = new int[overheadTextLimit];
      overheadTextColors = new int[overheadTextLimit];
      overheadTextEffects = new int[overheadTextLimit];
      overheadTextCyclesRemaining = new int[overheadTextLimit];
      overheadText = new String[overheadTextLimit];
      tileLastDrawnActor = new int[104][104];
      viewportDrawCount = 0;
      viewportTempX = -1;
      viewportTempY = -1;
      mouseCrossX = 0;
      mouseCrossY = 0;
      mouseCrossState = 0;
      mouseCrossColor = 0;
      showMouseCross = true;
      field540 = 0;
      showLoadingMessages = true;
      players = new Player[2048];
      localPlayerIndex = -1;
      isMembers = 0;
      playerUUID = -1L;
      renderSelf = true;
      drawPlayerNames = 0;
      field480 = 0;
      field481 = new int[1000];
      playerMenuOpcodes = new int[]{44, 45, 46, 47, 48, 49, 50, 51};
      playerMenuActions = new String[8];
      playerOptionsPriorities = new boolean[8];
      field485 = new int[]{768, 1024, 1280, 512, 1536, 256, 0, 1792};
      combatTargetPlayerIndex = -1;
      groundItems = new NodeDeque[4][104][104];
      pendingSpawns = new NodeDeque();
      projectiles = new NodeDeque();
      graphicsObjects = new NodeDeque();
      currentLevels = new int[25];
      levels = new int[25];
      experience = new int[25];
      leftClickOpensMenu = false;
      isMenuOpen = false;
      menuOptionsCount = 0;
      menuArguments1 = new int[500];
      menuArguments2 = new int[500];
      menuOpcodes = new int[500];
      menuIdentifiers = new int[500];
      menuItemIds = new int[500];
      menuActions = new String[500];
      menuTargets = new String[500];
      menuShiftClick = new boolean[500];
      followerOpsLowPriority = false;
      tapToDrop = false;
      showMouseOverText = true;
      viewportX = -1;
      viewportY = -1;
      field410 = 0;
      field424 = 50;
      isItemSelected = 0;
      field513 = null;
      isSpellSelected = false;
      selectedSpellChildIndex = -1;
      selectedSpellItemId = -1;
      field583 = null;
      field518 = null;
      rootInterface = -1;
      interfaceParents = new NodeHashTable(8);
      field521 = 0;
      field635 = -1;
      chatEffects = 0;
      meslayerContinueWidget = null;
      runEnergy = 0;
      weight = 0;
      staffModLevel = 0;
      followerIndex = -1;
      playerMod = false;
      viewportWidget = null;
      clickedWidget = null;
      clickedWidgetParent = null;
      widgetClickX = 0;
      widgetClickY = 0;
      draggedOnWidget = null;
      field536 = false;
      field537 = -1;
      field470 = -1;
      field643 = false;
      field445 = -1;
      field541 = -1;
      isDraggingWidget = false;
      cycleCntr = 1;
      changedVarps = new int[32];
      changedVarpCount = 0;
      changedItemContainers = new int[32];
      changedItemContainersCount = 0;
      changedSkills = new int[32];
      changedSkillsCount = 0;
      field550 = new int[32];
      field551 = 0;
      chatCycle = 0;
      field573 = 0;
      field399 = 0;
      field555 = 0;
      field357 = 0;
      field516 = 0;
      field558 = 0;
      field559 = 0;
      mouseWheelRotation = 0;
      field561 = new class495();
      scriptEvents = new NodeDeque();
      field563 = new NodeDeque();
      field403 = new NodeDeque();
      field565 = new NodeDeque();
      widgetFlags = new NodeHashTable(512);
      rootWidgetCount = 0;
      field568 = -2;
      field594 = new boolean[100];
      field570 = new boolean[100];
      field571 = new boolean[100];
      rootWidgetXs = new int[100];
      rootWidgetYs = new int[100];
      rootWidgetWidths = new int[100];
      rootWidgetHeights = new int[100];
      gameDrawingMode = 0;
      field569 = 0L;
      isResizable = true;
      field578 = new int[]{16776960, 16711680, 65280, 65535, 16711935, 16777215};
      publicChatMode = 0;
      tradeChatMode = 0;
      field510 = "";
      crossWorldMessageIds = new long[100];
      crossWorldMessageIdsIndex = 0;
      keyHandlerInstance = new class208();
      field585 = new class206();
      field586 = 0;
      field514 = new int[128];
      field588 = new int[128];
      timeOfPreviousKeyPress = -1L;
      currentClanSettings = new ClanSettings[4];
      currentClanChannels = new ClanChannel[4];
      field592 = -1;
      mapIconCount = 0;
      mapIconXs = new int[1000];
      mapIconYs = new int[1000];
      mapIcons = new SpritePixels[1000];
      destinationX = 0;
      destinationY = 0;
      minimapState = 0;
      currentTrackGroupId = -1;
      playingJingle = false;
      soundEffectCount = 0;
      soundEffectIds = new int[50];
      queuedSoundEffectLoops = new int[50];
      queuedSoundEffectDelays = new int[50];
      soundLocations = new int[50];
      soundEffects = new SoundEffect[50];
      isCameraLocked = false;
      field609 = false;
      cameraShaking = new boolean[5];
      cameraShakeIntensity = new int[5];
      cameraMoveIntensity = new int[5];
      cameraShakeSpeed = new int[5];
      cameraShakeCycle = new int[5];
      field418 = 256;
      field616 = 205;
      zoomHeight = 256;
      zoomWidth = 320;
      field619 = 1;
      field620 = 32767;
      field621 = 1;
      field622 = 32767;
      viewportOffsetX = 0;
      viewportOffsetY = 0;
      viewportWidth = 0;
      viewportHeight = 0;
      viewportZoom = 0;
      playerAppearance = new PlayerComposition();
      field628 = -1;
      field590 = -1;
      platformInfoProvider = new DesktopPlatformInfoProvider();
      grandExchangeOffers = new GrandExchangeOffer[8];
      GrandExchangeEvents_worldComparator = new GrandExchangeOfferOwnWorldComparator();
      archive5 = new class394(8, class392.field3638);
      Widget_cachedModels = new EvictingDualNodeHashTable(64);
      Widget_cachedFonts = new EvictingDualNodeHashTable(64);
      field637 = -1;
      field447 = -1;
      field617 = new ArrayList();
      archiveLoaders = new ArrayList(10);
      archiveLoadersDone = 0;
      field587 = 0;
      field444 = new ApproximateRouteStrategy();
      field416 = new int[50];
      field645 = new int[50];
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "1315269031"
   )
   @Export("resizeGame")
   protected final void resizeGame() {
      field569 = WorldMapSection2.clockNow() + 500L;
      this.resizeJS();
      if (rootInterface != -1) {
         this.resizeRoot(true);
      }

   }

   @ObfuscatedName("bk")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "-1812622075"
   )
   @Export("setUp")
   protected final void setUp() {
      int[] var1 = new int[]{20, 260, 10000};
      int[] var2 = new int[]{1000, 100, 500};
      if (var1 != null && var2 != null) {
         class212.ByteArrayPool_alternativeSizes = var1;
         SoundSystem.ByteArrayPool_altSizeArrayCounts = new int[var1.length];
         InterfaceParent.ByteArrayPool_arrays = new byte[var1.length][][];

         for(int var3 = 0; var3 < class212.ByteArrayPool_alternativeSizes.length; ++var3) {
            InterfaceParent.ByteArrayPool_arrays[var3] = new byte[var2[var3]][];
            ByteArrayPool.field3616.add(var1[var3]);
         }

         Collections.sort(ByteArrayPool.field3616);
      } else {
         class212.ByteArrayPool_alternativeSizes = null;
         SoundSystem.ByteArrayPool_altSizeArrayCounts = null;
         InterfaceParent.ByteArrayPool_arrays = null;
         SpriteMask.method1629();
      }

      class290.worldPort = gameBuild == 0 ? 'ꩊ' : worldId + '鱀';
      Calendar.js5Port = gameBuild == 0 ? 443 : worldId + '썐';
      ClanSettings.currentPort = class290.worldPort;
      class308.field2783 = class311.field2821;
      CollisionMap.field1830 = class311.field2820;
      class128.field1231 = class311.field2823;
      class126.field1199 = class311.field2819;
      class345.urlRequester = new class110(this.field479, 212);
      this.setUpKeyboard();
      this.method146();
      class7.mouseWheel = this.mouseWheel();
      this.method139(field585, 0);
      this.method139(keyHandlerInstance, 1);
      MidiPcmStream.masterDisk = new ArchiveDisk(255, JagexCache.JagexCache_dat2File, JagexCache.JagexCache_idx255File, 500000);
      AccessFile var4 = null;
      ClientPreferences var5 = new ClientPreferences();

      try {
         var4 = class350.getPreferencesFile("", DbTableType.field3951.name, false);
         byte[] var6 = new byte[(int)var4.length()];

         int var8;
         for(int var7 = 0; var7 < var6.length; var7 += var8) {
            var8 = var4.read(var6, var7, var6.length - var7);
            if (var8 == -1) {
               throw new IOException();
            }
         }

         var5 = new ClientPreferences(new Buffer(var6));
      } catch (Exception var11) {
         ;
      }

      try {
         if (var4 != null) {
            var4.close();
         }
      } catch (Exception var10) {
         ;
      }

      WorldMapSectionType.clientPreferences = var5;
      this.setUpClipboard();
      String var12 = UserComparator3.field1151;
      class31.field88 = this;
      if (var12 != null) {
         class31.field86 = var12;
      }

      NPC.setWindowedMode(WorldMapSectionType.clientPreferences.method538());
      class6.friendSystem = new FriendSystem(Occluder.loginType);
      this.field395 = new class14("tokenRequest", 1, 1);
   }

   @ObfuscatedName("br")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "32"
   )
   @Export("doCycle")
   protected final void doCycle() {
      ++cycle;
      this.doCycleJs5();
      VerticalAlignment.method976();

      int var1;
      try {
         if (class293.musicPlayerStatus == 1) {
            var1 = class293.midiPcmStream.method1564();
            if (var1 > 0 && class293.midiPcmStream.isReady()) {
               var1 -= AbstractRasterProvider.pcmSampleLength;
               if (var1 < 0) {
                  var1 = 0;
               }

               class293.midiPcmStream.setPcmStreamVolume(var1);
            } else {
               class293.midiPcmStream.clear();
               class293.midiPcmStream.removeAll();
               if (class364.musicTrackArchive != null) {
                  class293.musicPlayerStatus = 2;
               } else {
                  class293.musicPlayerStatus = 0;
               }

               BufferedNetSocket.musicTrack = null;
               class293.soundCache = null;
            }
         }
      } catch (Exception var5) {
         var5.printStackTrace();
         class293.midiPcmStream.clear();
         class293.musicPlayerStatus = 0;
         BufferedNetSocket.musicTrack = null;
         class293.soundCache = null;
         class364.musicTrackArchive = null;
      }

      EnumComposition.playPcmPlayers();
      keyHandlerInstance.method1092();
      this.method145();
      MouseHandler var3 = MouseHandler.MouseHandler_instance;
      synchronized(MouseHandler.MouseHandler_instance) {
         MouseHandler.MouseHandler_currentButton = MouseHandler.MouseHandler_currentButtonVolatile;
         MouseHandler.MouseHandler_x = MouseHandler.MouseHandler_xVolatile;
         MouseHandler.MouseHandler_y = MouseHandler.MouseHandler_yVolatile;
         MouseHandler.MouseHandler_millis = MouseHandler.MouseHandler_lastMovedVolatile;
         MouseHandler.MouseHandler_lastButton = MouseHandler.MouseHandler_lastButtonVolatile;
         MouseHandler.MouseHandler_lastPressedX = MouseHandler.MouseHandler_lastPressedXVolatile;
         MouseHandler.MouseHandler_lastPressedY = MouseHandler.MouseHandler_lastPressedYVolatile;
         MouseHandler.MouseHandler_lastPressedTimeMillis = MouseHandler.MouseHandler_lastPressedTimeMillisVolatile;
         MouseHandler.MouseHandler_lastButtonVolatile = 0;
      }

      if (class7.mouseWheel != null) {
         var1 = class7.mouseWheel.useRotation();
         mouseWheelRotation = var1;
      }

      if (gameState == 0) {
         GrandExchangeOfferOwnWorldComparator.load();
         Strings.method1804();
      } else if (gameState == 5) {
         class288.method1552(this, Calendar.fontPlain11, class420.fontPlain12);
         GrandExchangeOfferOwnWorldComparator.load();
         Strings.method1804();
      } else if (gameState != 10 && gameState != 11) {
         if (gameState == 20) {
            class288.method1552(this, Calendar.fontPlain11, class420.fontPlain12);
            this.doCycleLoggedOut();
         } else if (gameState == 50) {
            class288.method1552(this, Calendar.fontPlain11, class420.fontPlain12);
            this.doCycleLoggedOut();
         } else if (gameState == 25) {
            SoundSystem.method224();
         }
      } else {
         class288.method1552(this, Calendar.fontPlain11, class420.fontPlain12);
      }

      if (gameState == 30) {
         this.doCycleLoggedIn();
      } else if (gameState == 40 || gameState == 45) {
         this.doCycleLoggedOut();
      }

   }

   @ObfuscatedName("ba")
   @ObfuscatedSignature(
      descriptor = "(ZS)V",
      garbageValue = "28303"
   )
   @Export("draw")
   protected final void draw(boolean var1) {
      boolean var2 = MusicPatchNode.method1625();
      if (var2 && playingJingle && Interpreter.pcmPlayer0 != null) {
         Interpreter.pcmPlayer0.tryDiscard();
      }

      if ((gameState == 10 || gameState == 20 || gameState == 30) && 0L != field569 && WorldMapSection2.clockNow() > field569) {
         NPC.setWindowedMode(class7.getWindowedMode());
      }

      int var3;
      if (var1) {
         for(var3 = 0; var3 < 100; ++var3) {
            field594[var3] = true;
         }
      }

      if (gameState == 0) {
         this.drawInitial(Login.Login_loadingPercent, Login.Login_loadingText, var1);
      } else if (gameState == 5) {
         class141.drawTitle(class7.fontBold12, Calendar.fontPlain11, class420.fontPlain12);
      } else if (gameState != 10 && gameState != 11) {
         if (gameState == 20) {
            class141.drawTitle(class7.fontBold12, Calendar.fontPlain11, class420.fontPlain12);
         } else if (gameState == 50) {
            class141.drawTitle(class7.fontBold12, Calendar.fontPlain11, class420.fontPlain12);
         } else if (gameState == 25) {
            if (field376 == 1) {
               if (field500 > field354) {
                  field354 = field500;
               }

               var3 = (field354 * 50 - field500 * 50) / field354;
               class16.drawLoadingMessage("Loading - please wait." + "<br>" + " (" + var3 + "%" + ")", false);
            } else if (field376 == 2) {
               if (field422 > field647) {
                  field647 = field422;
               }

               var3 = (field647 * 50 - field422 * 50) / field647 + 50;
               class16.drawLoadingMessage("Loading - please wait." + "<br>" + " (" + var3 + "%" + ")", false);
            } else {
               class16.drawLoadingMessage("Loading - please wait.", false);
            }
         } else if (gameState == 30) {
            this.drawLoggedIn();
         } else if (gameState == 40) {
            class16.drawLoadingMessage("Connection lost" + "<br>" + "Please wait - attempting to reestablish", false);
         } else if (gameState == 45) {
            class16.drawLoadingMessage("Please wait...", false);
         }
      } else {
         class141.drawTitle(class7.fontBold12, Calendar.fontPlain11, class420.fontPlain12);
      }

      if (gameState == 30 && gameDrawingMode == 0 && !var1 && !isResizable) {
         for(var3 = 0; var3 < rootWidgetCount; ++var3) {
            if (field570[var3]) {
               StudioGame.rasterProvider.draw(rootWidgetXs[var3], rootWidgetYs[var3], rootWidgetWidths[var3], rootWidgetHeights[var3]);
               field570[var3] = false;
            }
         }
      } else if (gameState > 0) {
         StudioGame.rasterProvider.drawFull(0, 0);

         for(var3 = 0; var3 < rootWidgetCount; ++var3) {
            field570[var3] = false;
         }
      }

   }

   @ObfuscatedName("bz")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "-78"
   )
   @Export("kill0")
   protected final void kill0() {
      if (class248.varcs.hasUnwrittenChanges()) {
         class248.varcs.write();
      }

      if (class212.mouseRecorder != null) {
         class212.mouseRecorder.isRunning = false;
      }

      class212.mouseRecorder = null;
      packetWriter.close();
      if (MouseHandler.MouseHandler_instance != null) {
         MouseHandler var1 = MouseHandler.MouseHandler_instance;
         synchronized(MouseHandler.MouseHandler_instance) {
            MouseHandler.MouseHandler_instance = null;
         }
      }

      class7.mouseWheel = null;
      if (Interpreter.pcmPlayer0 != null) {
         Interpreter.pcmPlayer0.shutdown();
      }

      if (ViewportMouse.pcmPlayer1 != null) {
         ViewportMouse.pcmPlayer1.shutdown();
      }

      if (NetCache.NetCache_socket != null) {
         NetCache.NetCache_socket.close();
      }

      TaskHandler.method894();
      if (class345.urlRequester != null) {
         class345.urlRequester.close();
         class345.urlRequester = null;
      }

      class248.method1422();
      this.field395.method55();
   }

   @ObfuscatedName("bp")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "-87"
   )
   @Export("vmethod1485")
   protected final void vmethod1485() {
   }

   @ObfuscatedName("fp")
   @ObfuscatedSignature(
      descriptor = "(B)Z",
      garbageValue = "-16"
   )
   boolean method349() {
      return class308.field2786 != null && !class308.field2786.trim().isEmpty() && class12.field39 != null && !class12.field39.trim().isEmpty();
   }

   @ObfuscatedName("fx")
   @ObfuscatedSignature(
      descriptor = "(I)Z",
      garbageValue = "1703203662"
   )
   boolean method350() {
      return class90.field912 != null && !class90.field912.trim().isEmpty() && class433.field3773 != null && !class433.field3773.trim().isEmpty();
   }

   @ObfuscatedName("gm")
   @ObfuscatedSignature(
      descriptor = "(B)Z",
      garbageValue = "25"
   )
   boolean method374() {
      return this.field397 != null;
   }

   @ObfuscatedName("gk")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;B)V",
      garbageValue = "3"
   )
   void method351(String var1) throws IOException {
      HashMap var2 = new HashMap();
      var2.put("grant_type", "refresh_token");
      var2.put("scope", "gamesso.token.create");
      var2.put("refresh_token", var1);
      URL var3 = new URL(MoveSpeed.field1841 + "shield/oauth/token" + (new class434(var2)).method2231());
      class390 var4 = new class390();
      var4.method2054(field374);
      var4.method2053("Host", (new URL(MoveSpeed.field1841)).getHost());
      var4.method2058(class431.field3770);
      class9 var5 = class9.field23;
      RefreshAccessTokenRequester var6 = this.field401;
      if (var6 != null) {
         this.field425 = var6.request(var5.method26(), var3, var4.method2050(), "");
      } else {
         class10 var7 = new class10(var3, var5, var4, this.field479);
         this.field400 = this.field395.method50(var7);
      }
   }

   @ObfuscatedName("gb")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;I)V",
      garbageValue = "193540774"
   )
   void method373(String var1) throws IOException {
      URL var2 = new URL(MoveSpeed.field1841 + "public/v1/games/YCfdbvr2pM1zUYMxJRexZY/play");
      class390 var3 = new class390();
      var3.method2051(var1);
      class9 var4 = class9.field19;
      OtlTokenRequester var5 = this.field397;
      if (var5 != null) {
         this.field398 = var5.request(var4.method26(), var2, var3.method2050(), "");
      } else {
         class10 var6 = new class10(var2, var4, var3, this.field479);
         this.field396 = this.field395.method50(var6);
      }
   }

   @ObfuscatedName("go")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "-195209311"
   )
   void method352(String var1, String var2) throws IOException, JSONException {
      URL var3 = new URL(MoveSpeed.field1841 + "/game-session/v1/tokens");
      class10 var4 = new class10(var3, class9.field23, this.field479);
      var4.method30().method2051(var1);
      var4.method30().method2058(class431.field3770);
      JSONObject var5 = new JSONObject();
      var5.method2575("accountId", var2);
      var4.method31(new class433(var5));
      this.field396 = this.field395.method50(var4);
   }

   @ObfuscatedName("gz")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "-1071068400"
   )
   @Export("doCycleJs5")
   void doCycleJs5() {
      if (gameState != 1000) {
         long var2 = WorldMapSection2.clockNow();
         int var4 = (int)(var2 - NetCache.field3445);
         NetCache.field3445 = var2;
         if (var4 > 200) {
            var4 = 200;
         }

         NetCache.NetCache_loadTime += var4;
         boolean var1;
         if (NetCache.NetCache_pendingResponsesCount == 0 && NetCache.NetCache_pendingPriorityResponsesCount == 0 && NetCache.NetCache_pendingWritesCount == 0 && NetCache.NetCache_pendingPriorityWritesCount == 0) {
            var1 = true;
         } else if (NetCache.NetCache_socket == null) {
            var1 = false;
         } else {
            try {
               label250: {
                  if (NetCache.NetCache_loadTime > 30000) {
                     throw new IOException();
                  }

                  NetFileRequest var5;
                  Buffer var6;
                  while(NetCache.NetCache_pendingPriorityResponsesCount < 200 && NetCache.NetCache_pendingPriorityWritesCount > 0) {
                     var5 = (NetFileRequest)NetCache.NetCache_pendingPriorityWrites.first();
                     var6 = new Buffer(4);
                     var6.writeByte(1);
                     var6.writeMedium((int)var5.key);
                     NetCache.NetCache_socket.write(var6.array, 0, 4);
                     NetCache.NetCache_pendingPriorityResponses.put(var5, var5.key);
                     --NetCache.NetCache_pendingPriorityWritesCount;
                     ++NetCache.NetCache_pendingPriorityResponsesCount;
                  }

                  while(NetCache.NetCache_pendingResponsesCount < 200 && NetCache.NetCache_pendingWritesCount > 0) {
                     var5 = (NetFileRequest)NetCache.NetCache_pendingWritesQueue.removeLast();
                     var6 = new Buffer(4);
                     var6.writeByte(0);
                     var6.writeMedium((int)var5.key);
                     NetCache.NetCache_socket.write(var6.array, 0, 4);
                     var5.removeDual();
                     NetCache.NetCache_pendingResponses.put(var5, var5.key);
                     --NetCache.NetCache_pendingWritesCount;
                     ++NetCache.NetCache_pendingResponsesCount;
                  }

                  for(int var17 = 0; var17 < 100; ++var17) {
                     int var18 = NetCache.NetCache_socket.available();
                     if (var18 < 0) {
                        throw new IOException();
                     }

                     if (var18 == 0) {
                        break;
                     }

                     NetCache.NetCache_loadTime = 0;
                     byte var7 = 0;
                     if (class133.NetCache_currentResponse == null) {
                        var7 = 8;
                     } else if (NetCache.field3457 == 0) {
                        var7 = 1;
                     }

                     int var8;
                     int var9;
                     int var10;
                     int var12;
                     if (var7 > 0) {
                        var8 = var7 - NetCache.NetCache_responseHeaderBuffer.offset;
                        if (var8 > var18) {
                           var8 = var18;
                        }

                        NetCache.NetCache_socket.read(NetCache.NetCache_responseHeaderBuffer.array, NetCache.NetCache_responseHeaderBuffer.offset, var8);
                        if (NetCache.field3454 != 0) {
                           for(var9 = 0; var9 < var8; ++var9) {
                              NetCache.NetCache_responseHeaderBuffer.array[NetCache.NetCache_responseHeaderBuffer.offset + var9] ^= NetCache.field3454;
                           }
                        }

                        NetCache.NetCache_responseHeaderBuffer.offset += var8;
                        if (NetCache.NetCache_responseHeaderBuffer.offset < var7) {
                           break;
                        }

                        if (class133.NetCache_currentResponse == null) {
                           NetCache.NetCache_responseHeaderBuffer.offset = 0;
                           var9 = NetCache.NetCache_responseHeaderBuffer.readUnsignedByte();
                           var10 = NetCache.NetCache_responseHeaderBuffer.readUnsignedShort();
                           int var11 = NetCache.NetCache_responseHeaderBuffer.readUnsignedByte();
                           var12 = NetCache.NetCache_responseHeaderBuffer.readInt();
                           long var13 = (long)(var10 + (var9 << 16));
                           NetFileRequest var15 = (NetFileRequest)NetCache.NetCache_pendingPriorityResponses.get(var13);
                           VarpDefinition.field1462 = true;
                           if (var15 == null) {
                              var15 = (NetFileRequest)NetCache.NetCache_pendingResponses.get(var13);
                              VarpDefinition.field1462 = false;
                           }

                           if (var15 == null) {
                              throw new IOException();
                           }

                           int var16 = var11 == 0 ? 5 : 9;
                           class133.NetCache_currentResponse = var15;
                           NetCache.NetCache_responseArchiveBuffer = new Buffer(var16 + var12 + class133.NetCache_currentResponse.padding);
                           NetCache.NetCache_responseArchiveBuffer.writeByte(var11);
                           NetCache.NetCache_responseArchiveBuffer.writeInt(var12);
                           NetCache.field3457 = 8;
                           NetCache.NetCache_responseHeaderBuffer.offset = 0;
                        } else if (NetCache.field3457 == 0) {
                           if (NetCache.NetCache_responseHeaderBuffer.array[0] == -1) {
                              NetCache.field3457 = 1;
                              NetCache.NetCache_responseHeaderBuffer.offset = 0;
                           } else {
                              class133.NetCache_currentResponse = null;
                           }
                        }
                     } else {
                        var8 = NetCache.NetCache_responseArchiveBuffer.array.length - class133.NetCache_currentResponse.padding;
                        var9 = 512 - NetCache.field3457;
                        if (var9 > var8 - NetCache.NetCache_responseArchiveBuffer.offset) {
                           var9 = var8 - NetCache.NetCache_responseArchiveBuffer.offset;
                        }

                        if (var9 > var18) {
                           var9 = var18;
                        }

                        NetCache.NetCache_socket.read(NetCache.NetCache_responseArchiveBuffer.array, NetCache.NetCache_responseArchiveBuffer.offset, var9);
                        if (NetCache.field3454 != 0) {
                           for(var10 = 0; var10 < var9; ++var10) {
                              NetCache.NetCache_responseArchiveBuffer.array[NetCache.NetCache_responseArchiveBuffer.offset + var10] ^= NetCache.field3454;
                           }
                        }

                        NetCache.NetCache_responseArchiveBuffer.offset += var9;
                        NetCache.field3457 += var9;
                        if (var8 == NetCache.NetCache_responseArchiveBuffer.offset) {
                           if (16711935L == class133.NetCache_currentResponse.key) {
                              HealthBarUpdate.field1010 = NetCache.NetCache_responseArchiveBuffer;

                              for(var10 = 0; var10 < 256; ++var10) {
                                 Archive var19 = NetCache.NetCache_archives[var10];
                                 if (var19 != null) {
                                    HealthBarUpdate.field1010.offset = var10 * 8 + 5;
                                    if (HealthBarUpdate.field1010.offset >= HealthBarUpdate.field1010.array.length) {
                                       if (!var19.field3421) {
                                          throw new RuntimeException("");
                                       }

                                       var19.method1814();
                                    } else {
                                       var12 = HealthBarUpdate.field1010.readInt();
                                       int var20 = HealthBarUpdate.field1010.readInt();
                                       var19.loadIndex(var12, var20);
                                    }
                                 }
                              }
                           } else {
                              NetCache.NetCache_crc.reset();
                              NetCache.NetCache_crc.update(NetCache.NetCache_responseArchiveBuffer.array, 0, var8);
                              var10 = (int)NetCache.NetCache_crc.getValue();
                              if (var10 != class133.NetCache_currentResponse.crc) {
                                 try {
                                    NetCache.NetCache_socket.close();
                                 } catch (Exception var23) {
                                    ;
                                 }

                                 ++NetCache.NetCache_crcMismatches;
                                 NetCache.NetCache_socket = null;
                                 NetCache.field3454 = (byte)((int)(Math.random() * 255.0D + 1.0D));
                                 var1 = false;
                                 break label250;
                              }

                              NetCache.NetCache_crcMismatches = 0;
                              NetCache.NetCache_ioExceptions = 0;
                              class133.NetCache_currentResponse.archive.write((int)(class133.NetCache_currentResponse.key & 65535L), NetCache.NetCache_responseArchiveBuffer.array, (class133.NetCache_currentResponse.key & 16711680L) == 16711680L, VarpDefinition.field1462);
                           }

                           class133.NetCache_currentResponse.remove();
                           if (VarpDefinition.field1462) {
                              --NetCache.NetCache_pendingPriorityResponsesCount;
                           } else {
                              --NetCache.NetCache_pendingResponsesCount;
                           }

                           NetCache.field3457 = 0;
                           class133.NetCache_currentResponse = null;
                           NetCache.NetCache_responseArchiveBuffer = null;
                        } else {
                           if (NetCache.field3457 != 512) {
                              break;
                           }

                           NetCache.field3457 = 0;
                        }
                     }
                  }

                  var1 = true;
               }
            } catch (IOException var24) {
               try {
                  NetCache.NetCache_socket.close();
               } catch (Exception var22) {
                  ;
               }

               ++NetCache.NetCache_ioExceptions;
               NetCache.NetCache_socket = null;
               var1 = false;
            }
         }

         if (!var1) {
            this.doCycleJs5Connect();
         }

      }
   }

   @ObfuscatedName("gu")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "8388607"
   )
   @Export("doCycleJs5Connect")
   void doCycleJs5Connect() {
      if (NetCache.NetCache_crcMismatches >= 4) {
         this.error("js5crc");
         class19.updateGameState(1000);
      } else {
         if (NetCache.NetCache_ioExceptions >= 4) {
            if (gameState <= 5) {
               this.error("js5io");
               class19.updateGameState(1000);
               return;
            }

            js5Cycles = 3000;
            NetCache.NetCache_ioExceptions = 3;
         }

         if (--js5Cycles + 1 <= 0) {
            try {
               if (js5ConnectState == 0) {
                  SequenceDefinition.js5SocketTask = GameEngine.taskHandler.newSocketTask(class188.worldHost, ClanSettings.currentPort);
                  ++js5ConnectState;
               }

               if (js5ConnectState == 1) {
                  if (SequenceDefinition.js5SocketTask.status == 2) {
                     this.js5Error(-1);
                     return;
                  }

                  if (SequenceDefinition.js5SocketTask.status == 1) {
                     ++js5ConnectState;
                  }
               }

               Buffer var3;
               if (js5ConnectState == 2) {
                  Socket var2 = (Socket)SequenceDefinition.js5SocketTask.result;
                  BufferedNetSocket var1 = new BufferedNetSocket(var2, 40000, 5000);
                  PcmPlayer.js5Socket = var1;
                  var3 = new Buffer(5);
                  var3.writeByte(15);
                  var3.writeInt(212);
                  PcmPlayer.js5Socket.write(var3.array, 0, 5);
                  ++js5ConnectState;
                  class305.field2770 = WorldMapSection2.clockNow();
               }

               if (js5ConnectState == 3) {
                  if (PcmPlayer.js5Socket.available() > 0) {
                     int var5 = PcmPlayer.js5Socket.readUnsignedByte();
                     if (var5 != 0) {
                        this.js5Error(var5);
                        return;
                     }

                     ++js5ConnectState;
                  } else if (WorldMapSection2.clockNow() - class305.field2770 > 30000L) {
                     this.js5Error(-2);
                     return;
                  }
               }

               if (js5ConnectState == 4) {
                  AbstractSocket var11 = PcmPlayer.js5Socket;
                  boolean var6 = gameState > 20;
                  if (NetCache.NetCache_socket != null) {
                     try {
                        NetCache.NetCache_socket.close();
                     } catch (Exception var9) {
                        ;
                     }

                     NetCache.NetCache_socket = null;
                  }

                  NetCache.NetCache_socket = var11;
                  class166.method865(var6);
                  NetCache.NetCache_responseHeaderBuffer.offset = 0;
                  class133.NetCache_currentResponse = null;
                  NetCache.NetCache_responseArchiveBuffer = null;
                  NetCache.field3457 = 0;

                  while(true) {
                     NetFileRequest var12 = (NetFileRequest)NetCache.NetCache_pendingPriorityResponses.first();
                     if (var12 == null) {
                        while(true) {
                           var12 = (NetFileRequest)NetCache.NetCache_pendingResponses.first();
                           if (var12 == null) {
                              if (NetCache.field3454 != 0) {
                                 try {
                                    var3 = new Buffer(4);
                                    var3.writeByte(4);
                                    var3.writeByte(NetCache.field3454);
                                    var3.writeShort(0);
                                    NetCache.NetCache_socket.write(var3.array, 0, 4);
                                 } catch (IOException var8) {
                                    try {
                                       NetCache.NetCache_socket.close();
                                    } catch (Exception var7) {
                                       ;
                                    }

                                    ++NetCache.NetCache_ioExceptions;
                                    NetCache.NetCache_socket = null;
                                 }
                              }

                              NetCache.NetCache_loadTime = 0;
                              NetCache.field3445 = WorldMapSection2.clockNow();
                              SequenceDefinition.js5SocketTask = null;
                              PcmPlayer.js5Socket = null;
                              js5ConnectState = 0;
                              js5Errors = 0;
                              return;
                           }

                           NetCache.NetCache_pendingWritesQueue.addLast(var12);
                           NetCache.NetCache_pendingWrites.put(var12, var12.key);
                           ++NetCache.NetCache_pendingWritesCount;
                           --NetCache.NetCache_pendingResponsesCount;
                        }
                     }

                     NetCache.NetCache_pendingPriorityWrites.put(var12, var12.key);
                     ++NetCache.NetCache_pendingPriorityWritesCount;
                     --NetCache.NetCache_pendingPriorityResponsesCount;
                  }
               }
            } catch (IOException var10) {
               this.js5Error(-3);
            }

         }
      }
   }

   @ObfuscatedName("gw")
   @ObfuscatedSignature(
      descriptor = "(II)V",
      garbageValue = "-605463704"
   )
   @Export("js5Error")
   void js5Error(int var1) {
      SequenceDefinition.js5SocketTask = null;
      PcmPlayer.js5Socket = null;
      js5ConnectState = 0;
      if (ClanSettings.currentPort == class290.worldPort) {
         ClanSettings.currentPort = Calendar.js5Port;
      } else {
         ClanSettings.currentPort = class290.worldPort;
      }

      ++js5Errors;
      if (js5Errors < 2 || var1 != 7 && var1 != 9) {
         if (js5Errors >= 2 && var1 == 6) {
            this.error("js5connect_outofdate");
            class19.updateGameState(1000);
         } else if (js5Errors >= 4) {
            if (gameState <= 5) {
               this.error("js5connect");
               class19.updateGameState(1000);
            } else {
               js5Cycles = 3000;
            }
         }
      } else if (gameState <= 5) {
         this.error("js5connect_full");
         class19.updateGameState(1000);
      } else {
         js5Cycles = 3000;
      }

   }

   @ObfuscatedName("gh")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "-44"
   )
   @Export("doCycleLoggedOut")
   final void doCycleLoggedOut() {
      Object var1 = packetWriter.getSocket();
      PacketBuffer var2 = packetWriter.packetBuffer;

      try {
         if (loginState == 0) {
            if (class133.secureRandom == null && (secureRandomFuture.isDone() || field423 > 250)) {
               class133.secureRandom = secureRandomFuture.get();
               secureRandomFuture.shutdown();
               secureRandomFuture = null;
            }

            if (class133.secureRandom != null) {
               if (var1 != null) {
                  ((AbstractSocket)var1).close();
                  var1 = null;
               }

               UserComparator3.socketTask = null;
               hadNetworkError = false;
               field423 = 0;
               if (field393.method2484()) {
                  if (this.method349()) {
                     try {
                        this.method351(class12.field39);
                        class60.method325(21);
                     } catch (Throwable var26) {
                        class364.RunException_sendStackTrace((String)null, var26);
                        class11.getLoginError(65);
                        return;
                     }
                  } else {
                     if (!this.method350()) {
                        class11.getLoginError(65);
                        return;
                     }

                     try {
                        this.method352(class90.field912, class433.field3773);
                        class60.method325(20);
                     } catch (Exception var25) {
                        class364.RunException_sendStackTrace((String)null, var25);
                        class11.getLoginError(65);
                        return;
                     }
                  }
               } else {
                  class60.method325(1);
               }
            }
         }

         class20 var29;
         if (loginState == 21) {
            if (this.field425 != null) {
               if (!this.field425.isDone()) {
                  return;
               }

               if (this.field425.isCancelled()) {
                  class11.getLoginError(65);
                  this.field425 = null;
                  return;
               }

               try {
                  RefreshAccessTokenResponse var3 = (RefreshAccessTokenResponse)this.field425.get();
                  if (!var3.isSuccess()) {
                     class11.getLoginError(65);
                     this.field425 = null;
                     return;
                  }

                  class308.field2786 = var3.getAccessToken();
                  class12.field39 = var3.getRefreshToken();
                  this.field425 = null;
               } catch (Exception var24) {
                  class364.RunException_sendStackTrace((String)null, var24);
                  class11.getLoginError(65);
                  this.field425 = null;
                  return;
               }
            } else {
               if (this.field400 == null) {
                  class11.getLoginError(65);
                  return;
               }

               if (!this.field400.method69()) {
                  return;
               }

               if (this.field400.method72()) {
                  class364.RunException_sendStackTrace(this.field400.method71(), (Throwable)null);
                  class11.getLoginError(65);
                  this.field400 = null;
                  return;
               }

               var29 = this.field400.method70();
               if (var29.method81() != 200) {
                  class11.getLoginError(65);
                  this.field400 = null;
                  return;
               }

               field423 = 0;
               class433 var4 = new class433(var29.method82());

               try {
                  class308.field2786 = var4.method2226().getString("access_token");
                  class12.field39 = var4.method2226().getString("refresh_token");
               } catch (Exception var23) {
                  class364.RunException_sendStackTrace("Error parsing tokens", var23);
                  class11.getLoginError(65);
                  this.field400 = null;
                  return;
               }
            }

            this.method373(class308.field2786);
            class60.method325(20);
         }

         if (loginState == 20) {
            if (this.field398 != null) {
               if (!this.field398.isDone()) {
                  return;
               }

               if (this.field398.isCancelled()) {
                  class11.getLoginError(65);
                  this.field398 = null;
                  return;
               }

               try {
                  OtlTokenResponse var30 = (OtlTokenResponse)this.field398.get();
                  if (!var30.isSuccess()) {
                     class11.getLoginError(65);
                     this.field398 = null;
                     return;
                  }

                  this.field394 = var30.getToken();
                  this.field398 = null;
               } catch (Exception var22) {
                  class364.RunException_sendStackTrace((String)null, var22);
                  class11.getLoginError(65);
                  this.field398 = null;
                  return;
               }
            } else {
               if (this.field396 == null) {
                  class11.getLoginError(65);
                  return;
               }

               if (!this.field396.method69()) {
                  return;
               }

               if (this.field396.method72()) {
                  class364.RunException_sendStackTrace(this.field396.method71(), (Throwable)null);
                  class11.getLoginError(65);
                  this.field396 = null;
                  return;
               }

               var29 = this.field396.method70();
               if (var29.method81() != 200) {
                  class364.RunException_sendStackTrace("Response code: " + var29.method81() + "Response body: " + var29.method82(), (Throwable)null);
                  class11.getLoginError(65);
                  this.field396 = null;
                  return;
               }

               List var32 = (List)var29.method80().get("Content-Type");
               if (var32 != null && var32.contains(class431.field3770.method2220())) {
                  try {
                     JSONObject var5 = new JSONObject(var29.method82());
                     this.field394 = var5.getString("token");
                  } catch (JSONException var21) {
                     class364.RunException_sendStackTrace((String)null, var21);
                     class11.getLoginError(65);
                     this.field396 = null;
                     return;
                  }
               } else {
                  this.field394 = var29.method82();
               }

               this.field396 = null;
            }

            field423 = 0;
            class60.method325(1);
         }

         if (loginState == 1) {
            if (UserComparator3.socketTask == null) {
               UserComparator3.socketTask = GameEngine.taskHandler.newSocketTask(class188.worldHost, ClanSettings.currentPort);
            }

            if (UserComparator3.socketTask.status == 2) {
               throw new IOException();
            }

            if (UserComparator3.socketTask.status == 1) {
               Socket var34 = (Socket)UserComparator3.socketTask.result;
               BufferedNetSocket var31 = new BufferedNetSocket(var34, 40000, 5000);
               var1 = var31;
               packetWriter.setSocket(var31);
               UserComparator3.socketTask = null;
               class60.method325(2);
            }
         }

         PacketBufferNode var33;
         if (loginState == 2) {
            packetWriter.clearBuffer();
            var33 = ViewportMouse.method1295();
            var33.packetBuffer.writeByte(LoginPacket.field2652.id);
            packetWriter.addNode(var33);
            packetWriter.flush();
            var2.offset = 0;
            class60.method325(3);
         }

         int var14;
         if (loginState == 3) {
            if (Interpreter.pcmPlayer0 != null) {
               Interpreter.pcmPlayer0.method218();
            }

            if (ViewportMouse.pcmPlayer1 != null) {
               ViewportMouse.pcmPlayer1.method218();
            }

            if (((AbstractSocket)var1).isAvailable(1)) {
               var14 = ((AbstractSocket)var1).readUnsignedByte();
               if (Interpreter.pcmPlayer0 != null) {
                  Interpreter.pcmPlayer0.method218();
               }

               if (ViewportMouse.pcmPlayer1 != null) {
                  ViewportMouse.pcmPlayer1.method218();
               }

               if (var14 != 0) {
                  class11.getLoginError(var14);
                  return;
               }

               var2.offset = 0;
               class60.method325(4);
            }
         }

         if (loginState == 4) {
            if (var2.offset < 8) {
               var14 = ((AbstractSocket)var1).available();
               if (var14 > 8 - var2.offset) {
                  var14 = 8 - var2.offset;
               }

               if (var14 > 0) {
                  ((AbstractSocket)var1).read(var2.array, var2.offset, var14);
                  var2.offset += var14;
               }
            }

            if (var2.offset == 8) {
               var2.offset = 0;
               Bounds.field3726 = var2.readLong();
               class60.method325(5);
            }
         }

         int var6;
         if (loginState == 5) {
            packetWriter.packetBuffer.offset = 0;
            packetWriter.clearBuffer();
            PacketBuffer var35 = new PacketBuffer(500);
            int[] var36 = new int[]{class133.secureRandom.nextInt(), class133.secureRandom.nextInt(), class133.secureRandom.nextInt(), class133.secureRandom.nextInt()};
            var35.offset = 0;
            var35.writeByte(1);
            var35.writeInt(var36[0]);
            var35.writeInt(var36[1]);
            var35.writeInt(var36[2]);
            var35.writeInt(var36[3]);
            var35.writeLong(Bounds.field3726);
            if (gameState == 40) {
               var35.writeInt(class18.field54[0]);
               var35.writeInt(class18.field54[1]);
               var35.writeInt(class18.field54[2]);
               var35.writeInt(class18.field54[3]);
            } else {
               if (gameState == 50) {
                  var35.writeByte(class136.field1284.rsOrdinal());
                  var35.writeInt(class31.field89);
               } else {
                  var35.writeByte(field392.rsOrdinal());
                  switch(field392.field1287) {
                  case 0:
                  case 3:
                     var35.writeMedium(FriendSystem.field663);
                     ++var35.offset;
                     break;
                  case 1:
                     var35.writeInt(WorldMapSectionType.clientPreferences.method540(Login.Login_username));
                     break;
                  case 2:
                     var35.offset += 4;
                  }
               }

               if (field393.method2484()) {
                  var35.writeByte(class482.field4017.rsOrdinal());
                  var35.writeStringCp1252NullTerminated(this.field394);
               } else {
                  var35.writeByte(class482.field4023.rsOrdinal());
                  var35.writeStringCp1252NullTerminated(Login.Login_password);
               }
            }

            var35.encryptRsa(class72.field722, class72.field720);
            class18.field54 = var36;
            PacketBufferNode var37 = ViewportMouse.method1295();
            var37.packetBuffer.offset = 0;
            if (gameState == 40) {
               var37.packetBuffer.writeByte(LoginPacket.RECONNECT_LOGIN_CONNECTION.id);
            } else {
               var37.packetBuffer.writeByte(LoginPacket.NEW_LOGIN_CONNECTION.id);
            }

            var37.packetBuffer.writeShort(0);
            var6 = var37.packetBuffer.offset;
            var37.packetBuffer.writeInt(212);
            var37.packetBuffer.writeInt(1);
            var37.packetBuffer.writeByte(clientType);
            var37.packetBuffer.writeByte(field363);
            byte var7 = 0;
            var37.packetBuffer.writeByte(var7);
            var37.packetBuffer.writeBytes(var35.array, 0, var35.offset);
            int var8 = var37.packetBuffer.offset;
            var37.packetBuffer.writeStringCp1252NullTerminated(Login.Login_username);
            var37.packetBuffer.writeByte((isResizable ? 1 : 0) << 1 | (isLowDetail ? 1 : 0));
            var37.packetBuffer.writeShort(GameEngine.canvasWidth);
            var37.packetBuffer.writeShort(class143.canvasHeight);
            PacketBuffer var9 = var37.packetBuffer;
            int var12;
            if (randomDatData != null) {
               var9.writeBytes(randomDatData, 0, randomDatData.length);
            } else {
               byte[] var11 = new byte[24];

               try {
                  JagexCache.JagexCache_randomDat.seek(0L);
                  JagexCache.JagexCache_randomDat.readFully(var11);

                  for(var12 = 0; var12 < 24 && var11[var12] == 0; ++var12) {
                     ;
                  }

                  if (var12 >= 24) {
                     throw new IOException();
                  }
               } catch (Exception var27) {
                  for(int var13 = 0; var13 < 24; ++var13) {
                     var11[var13] = -1;
                  }
               }

               var9.writeBytes(var11, 0, var11.length);
            }

            var37.packetBuffer.writeStringCp1252NullTerminated(FontName.param9);
            var37.packetBuffer.writeInt(RouteStrategy.field1837);
            Buffer var10 = new Buffer(HealthBarUpdate.platformInfo.size());
            HealthBarUpdate.platformInfo.write(var10);
            var37.packetBuffer.writeBytes(var10.array, 0, var10.array.length);
            var37.packetBuffer.writeByte(clientType);
            var37.packetBuffer.writeInt(0);
            var37.packetBuffer.writeIntME(class20.field63.hash);
            var37.packetBuffer.writeIntLE(class475.archive20.hash);
            var37.packetBuffer.writeIntME(class127.archive17.hash);
            var37.packetBuffer.writeIntME(AABB.archive10.hash);
            var37.packetBuffer.writeIntME(TextureProvider.archive13.hash);
            var37.packetBuffer.writeIntME(class308.archive6.hash);
            var37.packetBuffer.writeIntME(class167.archive12.hash);
            var37.packetBuffer.writeInt(class376.archive18.hash);
            var37.packetBuffer.writeIntLE(class36.field149.hash);
            var37.packetBuffer.writeIntME(ClientPreferences.archive9.hash);
            var37.packetBuffer.writeIntLE(class135.archive4.hash);
            var37.packetBuffer.writeInt(class175.field1434.hash);
            var37.packetBuffer.writeIntIME(UserComparator5.field1148.hash);
            var37.packetBuffer.writeIntIME(class258.archive2.hash);
            var37.packetBuffer.writeIntLE(0);
            var37.packetBuffer.writeIntIME(class90.archive14.hash);
            var37.packetBuffer.writeIntLE(MusicPatchPcmStream.archive15.hash);
            var37.packetBuffer.writeIntLE(MusicPatchNode.archive19.hash);
            var37.packetBuffer.writeIntME(class143.archive8.hash);
            var37.packetBuffer.writeIntME(class290.archive7.hash);
            var37.packetBuffer.writeInt(Clock.archive11.hash);
            var37.packetBuffer.xteaEncrypt(var36, var8, var37.packetBuffer.offset);
            var37.packetBuffer.writeLengthShort(var37.packetBuffer.offset - var6);
            packetWriter.addNode(var37);
            packetWriter.flush();
            packetWriter.isaacCipher = new IsaacCipher(var36);
            int[] var45 = new int[4];

            for(var12 = 0; var12 < 4; ++var12) {
               var45[var12] = var36[var12] + 50;
            }

            var2.newIsaacCipher(var45);
            class60.method325(6);
         }

         int var16;
         if (loginState == 6 && ((AbstractSocket)var1).available() > 0) {
            var14 = ((AbstractSocket)var1).readUnsignedByte();
            if (var14 == 61) {
               var16 = ((AbstractSocket)var1).available();
               class157.field1372 = var16 == 1 && ((AbstractSocket)var1).readUnsignedByte() == 1;
               class60.method325(5);
            }

            if (var14 == 21 && gameState == 20) {
               class60.method325(12);
            } else if (var14 == 2) {
               class60.method325(14);
            } else if (var14 == 15 && gameState == 40) {
               packetWriter.serverPacketLength = -1;
               class60.method325(19);
            } else if (var14 == 64) {
               class60.method325(10);
            } else if (var14 == 23 && field390 < 1) {
               ++field390;
               class60.method325(0);
            } else if (var14 == 29) {
               class60.method325(17);
            } else {
               if (var14 != 69) {
                  class11.getLoginError(var14);
                  return;
               }

               class60.method325(7);
            }
         }

         if (loginState == 7 && ((AbstractSocket)var1).available() >= 2) {
            ((AbstractSocket)var1).read(var2.array, 0, 2);
            var2.offset = 0;
            ReflectionCheck.field162 = var2.readUnsignedShort();
            class60.method325(8);
         }

         if (loginState == 8 && ((AbstractSocket)var1).available() >= ReflectionCheck.field162) {
            var2.offset = 0;
            ((AbstractSocket)var1).read(var2.array, var2.offset, ReflectionCheck.field162);
            class6[] var38 = new class6[]{class6.field8};
            class6 var39 = var38[var2.readUnsignedByte()];

            try {
               switch(var39.field5) {
               case 0:
                  class0 var40 = new class0();
                  this.field531 = new class7(var2, var40);
                  class60.method325(9);
                  break;
               default:
                  throw new IllegalArgumentException();
               }
            } catch (Exception var20) {
               class11.getLoginError(22);
               return;
            }
         }

         if (loginState == 9 && this.field531.method17()) {
            this.field507 = this.field531.method13();
            this.field531.method16();
            this.field531 = null;
            if (this.field507 == null) {
               class11.getLoginError(22);
               return;
            }

            packetWriter.clearBuffer();
            var33 = ViewportMouse.method1295();
            var33.packetBuffer.writeByte(LoginPacket.field2651.id);
            var33.packetBuffer.writeShort(this.field507.offset);
            var33.packetBuffer.method2404(this.field507);
            packetWriter.addNode(var33);
            packetWriter.flush();
            this.field507 = null;
            class60.method325(6);
         }

         if (loginState == 10 && ((AbstractSocket)var1).available() > 0) {
            class10.field35 = ((AbstractSocket)var1).readUnsignedByte();
            class60.method325(11);
         }

         if (loginState == 11 && ((AbstractSocket)var1).available() >= class10.field35) {
            ((AbstractSocket)var1).read(var2.array, 0, class10.field35);
            var2.offset = 0;
            class60.method325(6);
         }

         if (loginState == 12 && ((AbstractSocket)var1).available() > 0) {
            field362 = (((AbstractSocket)var1).readUnsignedByte() + 3) * 60;
            class60.method325(13);
         }

         if (loginState == 13) {
            field423 = 0;
            Tile.setLoginResponseString("You have only just left another world.", "Your profile will be transferred in:", field362 / 60 + " seconds.");
            if (--field362 <= 0) {
               class60.method325(0);
            }

         } else {
            if (loginState == 14 && ((AbstractSocket)var1).available() >= 1) {
               Messages.playerUUIDLength = ((AbstractSocket)var1).readUnsignedByte();
               class60.method325(15);
            }

            if (loginState == 15 && ((AbstractSocket)var1).available() >= Messages.playerUUIDLength) {
               boolean var46 = ((AbstractSocket)var1).readUnsignedByte() == 1;
               ((AbstractSocket)var1).read(var2.array, 0, 4);
               var2.offset = 0;
               boolean var47 = false;
               if (var46) {
                  var16 = var2.readByteIsaac() << 24;
                  var16 |= var2.readByteIsaac() << 16;
                  var16 |= var2.readByteIsaac() << 8;
                  var16 |= var2.readByteIsaac();
                  WorldMapSectionType.clientPreferences.method545(Login.Login_username, var16);
               }

               if (Login_isUsernameRemembered) {
                  WorldMapSectionType.clientPreferences.setUsernameToRemember(Login.Login_username);
               } else {
                  WorldMapSectionType.clientPreferences.setUsernameToRemember((String)null);
               }

               class146.savePreferences();
               staffModLevel = ((AbstractSocket)var1).readUnsignedByte();
               playerMod = ((AbstractSocket)var1).readUnsignedByte() == 1;
               localPlayerIndex = ((AbstractSocket)var1).readUnsignedByte();
               localPlayerIndex <<= 8;
               localPlayerIndex += ((AbstractSocket)var1).readUnsignedByte();
               isMembers = ((AbstractSocket)var1).readUnsignedByte();
               ((AbstractSocket)var1).read(var2.array, 0, 8);
               var2.offset = 0;
               this.accountHash = var2.readLong();
               if (Messages.playerUUIDLength >= 29) {
                  ((AbstractSocket)var1).read(var2.array, 0, 8);
                  var2.offset = 0;
                  playerUUID = var2.readLong();
               }

               ((AbstractSocket)var1).read(var2.array, 0, 1);
               var2.offset = 0;
               ServerPacket[] var43 = class258.ServerPacket_values();
               var6 = var2.readSmartByteShortIsaac();
               if (var6 < 0 || var6 >= var43.length) {
                  throw new IOException(var6 + " " + var2.offset);
               }

               packetWriter.serverPacket = var43[var6];
               packetWriter.serverPacketLength = packetWriter.serverPacket.length;
               ((AbstractSocket)var1).read(var2.array, 0, 2);
               var2.offset = 0;
               packetWriter.serverPacketLength = var2.readUnsignedShort();

               try {
                  class26.method105(class392.client, "zap");
               } catch (Throwable var19) {
                  ;
               }

               class60.method325(16);
            }

            if (loginState == 16) {
               if (((AbstractSocket)var1).available() >= packetWriter.serverPacketLength) {
                  var2.offset = 0;
                  ((AbstractSocket)var1).read(var2.array, 0, packetWriter.serverPacketLength);
                  timer.method2039();
                  class395.method2073();
                  DirectByteArrayCopier.updatePlayer(var2);
                  class124.timeOfPreviousKeyPress = -1;
                  Skeleton.loadRegions(false, var2);
                  packetWriter.serverPacket = null;
               }

            } else {
               if (loginState == 17 && ((AbstractSocket)var1).available() >= 2) {
                  var2.offset = 0;
                  ((AbstractSocket)var1).read(var2.array, 0, 2);
                  var2.offset = 0;
                  class495.field4082 = var2.readUnsignedShort();
                  class60.method325(18);
               }

               if (loginState == 18 && ((AbstractSocket)var1).available() >= class495.field4082) {
                  var2.offset = 0;
                  ((AbstractSocket)var1).read(var2.array, 0, class495.field4082);
                  var2.offset = 0;
                  String var42 = var2.readStringCp1252NullTerminated();
                  String var41 = var2.readStringCp1252NullTerminated();
                  String var44 = var2.readStringCp1252NullTerminated();
                  Tile.setLoginResponseString(var42, var41, var44);
                  class19.updateGameState(10);
                  if (field393.method2484()) {
                     class14.method52(9);
                  }
               }

               if (loginState == 19) {
                  if (packetWriter.serverPacketLength == -1) {
                     if (((AbstractSocket)var1).available() < 2) {
                        return;
                     }

                     ((AbstractSocket)var1).read(var2.array, 0, 2);
                     var2.offset = 0;
                     packetWriter.serverPacketLength = var2.readUnsignedShort();
                  }

                  if (((AbstractSocket)var1).available() >= packetWriter.serverPacketLength) {
                     ((AbstractSocket)var1).read(var2.array, 0, packetWriter.serverPacketLength);
                     var2.offset = 0;
                     var14 = packetWriter.serverPacketLength;
                     timer.method2037();
                     StudioGame.method1799();
                     DirectByteArrayCopier.updatePlayer(var2);
                     if (var14 != var2.offset) {
                        throw new RuntimeException();
                     }
                  }
               } else {
                  ++field423;
                  if (field423 > 2000) {
                     if (field390 < 1) {
                        if (class290.worldPort == ClanSettings.currentPort) {
                           ClanSettings.currentPort = Calendar.js5Port;
                        } else {
                           ClanSettings.currentPort = class290.worldPort;
                        }

                        ++field390;
                        class60.method325(0);
                     } else {
                        class11.getLoginError(-3);
                     }
                  }
               }
            }
         }
      } catch (IOException var28) {
         if (field390 < 1) {
            if (ClanSettings.currentPort == class290.worldPort) {
               ClanSettings.currentPort = Calendar.js5Port;
            } else {
               ClanSettings.currentPort = class290.worldPort;
            }

            ++field390;
            class60.method325(0);
         } else {
            class11.getLoginError(-2);
         }
      }
   }

   public boolean shouldProcessClick() {
      return true;
   }

   @ObfuscatedName("gt")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "-78458791"
   )
   @Export("doCycleLoggedIn")
   final void doCycleLoggedIn() {
      if (rebootTimer > 1) {
         --rebootTimer;
      }

      if (logoutTimer > 0) {
         --logoutTimer;
      }

      if (hadNetworkError) {
         hadNetworkError = false;
         PendingSpawn.method501();
      } else {
         if (!isMenuOpen) {
            ClanMate.addCancelMenuEntry();
         }

         int var1;
         for(var1 = 0; var1 < 100 && this.method377(packetWriter); ++var1) {
            ;
         }

         if (gameState == 30) {
            int var2;
            PacketBufferNode var14;
            while(WorldMapCacheName.method1487()) {
               var14 = UserComparator9.getPacketBufferNode(ClientPacket.field2471, packetWriter.isaacCipher);
               var14.packetBuffer.writeByte(0);
               var2 = var14.packetBuffer.offset;
               AttackOption.performReflectionCheck(var14.packetBuffer);
               var14.packetBuffer.method2425(var14.packetBuffer.offset - var2);
               packetWriter.addNode(var14);
            }

            if (timer.field3623) {
               var14 = UserComparator9.getPacketBufferNode(ClientPacket.field2486, packetWriter.isaacCipher);
               var14.packetBuffer.writeByte(0);
               var2 = var14.packetBuffer.offset;
               timer.write(var14.packetBuffer);
               var14.packetBuffer.method2425(var14.packetBuffer.offset - var2);
               packetWriter.addNode(var14);
               timer.method2036();
            }

            Object var32 = class212.mouseRecorder.lock;
            int var3;
            int var4;
            int var5;
            int var6;
            int var7;
            int var8;
            int var9;
            int var10;
            int var11;
            int var12;
            synchronized(class212.mouseRecorder.lock) {
               if (!lockMouseRecorder) {
                  class212.mouseRecorder.index = 0;
               } else if (MouseHandler.MouseHandler_lastButton != 0 || class212.mouseRecorder.index >= 40) {
                  PacketBufferNode var15 = null;
                  var3 = 0;
                  var4 = 0;
                  var5 = 0;
                  var6 = 0;

                  for(var7 = 0; var7 < class212.mouseRecorder.index && (var15 == null || var15.packetBuffer.offset - var3 < 246); ++var7) {
                     var4 = var7;
                     var8 = class212.mouseRecorder.ys[var7];
                     if (var8 < -1) {
                        var8 = -1;
                     } else if (var8 > 65534) {
                        var8 = 65534;
                     }

                     var9 = class212.mouseRecorder.xs[var7];
                     if (var9 < -1) {
                        var9 = -1;
                     } else if (var9 > 65534) {
                        var9 = 65534;
                     }

                     if (var9 != lastMouseRecordX || var8 != lastMouseRecordY) {
                        if (var15 == null) {
                           var15 = UserComparator9.getPacketBufferNode(ClientPacket.field2424, packetWriter.isaacCipher);
                           var15.packetBuffer.writeByte(0);
                           var3 = var15.packetBuffer.offset;
                           var15.packetBuffer.offset += 2;
                           var5 = 0;
                           var6 = 0;
                        }

                        if (-1L != lastMouseRecordTime) {
                           var10 = var9 - lastMouseRecordX;
                           var11 = var8 - lastMouseRecordY;
                           var12 = (int)((class212.mouseRecorder.millis[var7] - lastMouseRecordTime) / 20L);
                           var5 = (int)((long)var5 + (class212.mouseRecorder.millis[var7] - lastMouseRecordTime) % 20L);
                        } else {
                           var10 = var9;
                           var11 = var8;
                           var12 = Integer.MAX_VALUE;
                        }

                        lastMouseRecordX = var9;
                        lastMouseRecordY = var8;
                        if (var12 < 8 && var10 >= -32 && var10 <= 31 && var11 >= -32 && var11 <= 31) {
                           var10 += 32;
                           var11 += 32;
                           var15.packetBuffer.writeShort((var12 << 12) + var11 + (var10 << 6));
                        } else if (var12 < 32 && var10 >= -128 && var10 <= 127 && var11 >= -128 && var11 <= 127) {
                           var10 += 128;
                           var11 += 128;
                           var15.packetBuffer.writeByte(var12 + 128);
                           var15.packetBuffer.writeShort(var11 + (var10 << 8));
                        } else if (var12 < 32) {
                           var15.packetBuffer.writeByte(var12 + 192);
                           if (var9 != -1 && var8 != -1) {
                              var15.packetBuffer.writeInt(var9 | var8 << 16);
                           } else {
                              var15.packetBuffer.writeInt(Integer.MIN_VALUE);
                           }
                        } else {
                           var15.packetBuffer.writeShort((var12 & 8191) + '\ue000');
                           if (var9 != -1 && var8 != -1) {
                              var15.packetBuffer.writeInt(var9 | var8 << 16);
                           } else {
                              var15.packetBuffer.writeInt(Integer.MIN_VALUE);
                           }
                        }

                        ++var6;
                        lastMouseRecordTime = class212.mouseRecorder.millis[var7];
                     }
                  }

                  if (var15 != null) {
                     var15.packetBuffer.method2425(var15.packetBuffer.offset - var3);
                     var7 = var15.packetBuffer.offset;
                     var15.packetBuffer.offset = var3;
                     var15.packetBuffer.writeByte(var5 / var6);
                     var15.packetBuffer.writeByte(var5 % var6);
                     var15.packetBuffer.offset = var7;
                     packetWriter.addNode(var15);
                  }

                  if (var4 >= class212.mouseRecorder.index) {
                     class212.mouseRecorder.index = 0;
                  } else {
                     class212.mouseRecorder.index -= var4;
                     System.arraycopy(class212.mouseRecorder.xs, var4, class212.mouseRecorder.xs, 0, class212.mouseRecorder.index);
                     System.arraycopy(class212.mouseRecorder.ys, var4, class212.mouseRecorder.ys, 0, class212.mouseRecorder.index);
                     System.arraycopy(class212.mouseRecorder.millis, var4, class212.mouseRecorder.millis, 0, class212.mouseRecorder.index);
                  }
               }
            }

            PacketBufferNode var18;
            if (MouseHandler.MouseHandler_lastButton == 1 || !class319.mouseCam && MouseHandler.MouseHandler_lastButton == 4 || MouseHandler.MouseHandler_lastButton == 2) {
               long var16 = MouseHandler.MouseHandler_lastPressedTimeMillis - mouseLastLastPressedTimeMillis;
               if (var16 > 32767L) {
                  var16 = 32767L;
               }

               mouseLastLastPressedTimeMillis = MouseHandler.MouseHandler_lastPressedTimeMillis;
               var3 = MouseHandler.MouseHandler_lastPressedY;
               if (var3 < 0) {
                  var3 = 0;
               } else if (var3 > class143.canvasHeight) {
                  var3 = class143.canvasHeight;
               }

               var4 = MouseHandler.MouseHandler_lastPressedX;
               if (var4 < 0) {
                  var4 = 0;
               } else if (var4 > GameEngine.canvasWidth) {
                  var4 = GameEngine.canvasWidth;
               }

               var5 = (int)var16;
               if (shouldProcessClick()) {
                  var18 = UserComparator9.getPacketBufferNode(ClientPacket.CLICK, packetWriter.isaacCipher);
                  var18.packetBuffer.writeShort((MouseHandler.MouseHandler_lastButton == 2 ? 1 : 0) + (var5 << 1));
                  var18.packetBuffer.writeShort(var4);
                  var18.packetBuffer.writeShort(var3);
                  packetWriter.addNode(var18);
               }
            }

            if (keyHandlerInstance.pressedKeysCount > 0) {
               var14 = UserComparator9.getPacketBufferNode(ClientPacket.field2428, packetWriter.isaacCipher);
               var14.packetBuffer.writeShort(0);
               var2 = var14.packetBuffer.offset;
               long var19 = WorldMapSection2.clockNow();

               for(var5 = 0; var5 < keyHandlerInstance.pressedKeysCount; ++var5) {
                  long var21 = var19 - timeOfPreviousKeyPress;
                  if (var21 > 16777215L) {
                     var21 = 16777215L;
                  }

                  timeOfPreviousKeyPress = var19;
                  var14.packetBuffer.writeByteSub(keyHandlerInstance.field1814[var5]);
                  var14.packetBuffer.writeMedium1((int)var21);
               }

               var14.packetBuffer.writeLengthShort(var14.packetBuffer.offset - var2);
               packetWriter.addNode(var14);
            }

            if (packetIndicator > 0) {
               --packetIndicator;
            }

            if (keyHandlerInstance.getKeyPressed(96) || keyHandlerInstance.getKeyPressed(97) || keyHandlerInstance.getKeyPressed(98) || keyHandlerInstance.getKeyPressed(99)) {
               emitPackets = true;
            }

            if (emitPackets && packetIndicator <= 0) {
               packetIndicator = 20;
               emitPackets = false;
               var14 = UserComparator9.getPacketBufferNode(ClientPacket.field2485, packetWriter.isaacCipher);
               var14.packetBuffer.writeShortAddLE(camAngleY);
               var14.packetBuffer.writeShort(camAngleX);
               packetWriter.addNode(var14);
            }

            if (Varps.hasFocus && !hadFocus) {
               hadFocus = true;
               var14 = UserComparator9.getPacketBufferNode(ClientPacket.field2445, packetWriter.isaacCipher);
               var14.packetBuffer.writeByte(1);
               packetWriter.addNode(var14);
            }

            if (!Varps.hasFocus && hadFocus) {
               hadFocus = false;
               var14 = UserComparator9.getPacketBufferNode(ClientPacket.field2445, packetWriter.isaacCipher);
               var14.packetBuffer.writeByte(0);
               packetWriter.addNode(var14);
            }

            if (WorldMapData_1.worldMap != null) {
               WorldMapData_1.worldMap.method2250();
            }

            class133.method721();
            Decimator.method309();
            int[] var34;
            if (field592 != TaskHandler.Client_plane) {
               field592 = TaskHandler.Client_plane;
               var1 = TaskHandler.Client_plane;
               var34 = class188.sceneMinimapSprite.pixels;
               var3 = var34.length;

               for(var4 = 0; var4 < var3; ++var4) {
                  var34[var4] = 0;
               }

               for(var4 = 1; var4 < 103; ++var4) {
                  var5 = (103 - var4) * 2048 + 24628;

                  for(var6 = 1; var6 < 103; ++var6) {
                     if ((Tiles.Tiles_renderFlags[var1][var6][var4] & 24) == 0) {
                        class1.scene.drawTileMinimap(var34, var5, 512, var1, var6, var4);
                     }

                     if (var1 < 3 && (Tiles.Tiles_renderFlags[var1 + 1][var6][var4] & 8) != 0) {
                        class1.scene.drawTileMinimap(var34, var5, 512, var1 + 1, var6, var4);
                     }

                     var5 += 4;
                  }
               }

               var4 = (238 + (int)(Math.random() * 20.0D) - 10 << 16) + (238 + (int)(Math.random() * 20.0D) - 10 << 8) + (238 + (int)(Math.random() * 20.0D) - 10);
               var5 = 238 + (int)(Math.random() * 20.0D) - 10 << 16;
               class188.sceneMinimapSprite.setRaster();

               for(var6 = 1; var6 < 103; ++var6) {
                  for(var7 = 1; var7 < 103; ++var7) {
                     if ((Tiles.Tiles_renderFlags[var1][var7][var6] & 24) == 0) {
                        class16.drawObject(var1, var7, var6, var4, var5);
                     }

                     if (var1 < 3 && (Tiles.Tiles_renderFlags[var1 + 1][var7][var6] & 8) != 0) {
                        class16.drawObject(var1 + 1, var7, var6, var4, var5);
                     }
                  }
               }

               mapIconCount = 0;

               for(var6 = 0; var6 < 104; ++var6) {
                  for(var7 = 0; var7 < 104; ++var7) {
                     long var23 = class1.scene.getFloorDecorationTag(TaskHandler.Client_plane, var6, var7);
                     if (0L != var23) {
                        var10 = class279.Entity_unpackID(var23);
                        var11 = WallDecoration.getObjectDefinition(var10).mapIconId;
                        if (var11 >= 0 && class123.WorldMapElement_get(var11).field1487) {
                           mapIcons[mapIconCount] = class123.WorldMapElement_get(var11).getSpriteBool(false);
                           mapIconXs[mapIconCount] = var6;
                           mapIconYs[mapIconCount] = var7;
                           ++mapIconCount;
                        }
                     }
                  }
               }

               StudioGame.rasterProvider.apply();
            }

            if (gameState == 30) {
               class18.method75();
               EnumComposition.method953();
               ++packetWriter.field1124;
               if (packetWriter.field1124 > 750) {
                  PendingSpawn.method501();
               } else {
                  var1 = Players.Players_count;
                  var34 = Players.Players_indices;

                  for(var3 = 0; var3 < var1; ++var3) {
                     Player var25 = players[var34[var3]];
                     if (var25 != null) {
                        ScriptEvent.updateActorSequence(var25, 1);
                     }
                  }

                  for(var1 = 0; var1 < npcCount; ++var1) {
                     var2 = npcIndices[var1];
                     NPC var26 = npcs[var2];
                     if (var26 != null) {
                        ScriptEvent.updateActorSequence(var26, var26.definition.size);
                     }
                  }

                  class129.method712();
                  ++field504;
                  if (mouseCrossColor != 0) {
                     mouseCrossState += 20;
                     if (mouseCrossState >= 400) {
                        mouseCrossColor = 0;
                     }
                  }

                  Widget var33 = InvDefinition.mousedOverWidgetIf1;
                  Widget var35 = Script.field803;
                  InvDefinition.mousedOverWidgetIf1 = null;
                  Script.field803 = null;
                  draggedOnWidget = null;
                  field643 = false;
                  field536 = false;
                  field586 = 0;

                  while(keyHandlerInstance.method1090() && field586 < 128) {
                     if (staffModLevel >= 2 && keyHandlerInstance.getKeyPressed(82) && keyHandlerInstance.field1823 == 66) {
                        String var37 = BuddyRankComparator.method669();
                        class392.client.method142(var37);
                     } else if (oculusOrbState != 1 || keyHandlerInstance.field1824 <= 0) {
                        field588[field586] = keyHandlerInstance.field1823;
                        field514[field586] = keyHandlerInstance.field1824;
                        ++field586;
                     }
                  }

                  if (class72.method423() && keyHandlerInstance.getKeyPressed(82) && keyHandlerInstance.getKeyPressed(81) && mouseWheelRotation != 0) {
                     var3 = BuddyRankComparator.localPlayer.plane - mouseWheelRotation;
                     if (var3 < 0) {
                        var3 = 0;
                     } else if (var3 > 3) {
                        var3 = 3;
                     }

                     if (var3 != BuddyRankComparator.localPlayer.plane) {
                        class163.method857(BuddyRankComparator.localPlayer.pathX[0] + GameEngine.baseX, BuddyRankComparator.localPlayer.pathY[0] + class178.baseY, var3, false);
                     }

                     mouseWheelRotation = 0;
                  }

                  if (MouseHandler.MouseHandler_lastButton == 1) {
                     field585.method1082();
                  }

                  if (rootInterface != -1) {
                     AbstractWorldMapData.updateRootInterface(rootInterface, 0, 0, GameEngine.canvasWidth, class143.canvasHeight, 0, 0);
                  }

                  ++cycleCntr;

                  while(true) {
                     Widget var27;
                     Widget var36;
                     ScriptEvent var38;
                     do {
                        var38 = (ScriptEvent)field563.removeLast();
                        if (var38 == null) {
                           while(true) {
                              do {
                                 var38 = (ScriptEvent)field403.removeLast();
                                 if (var38 == null) {
                                    while(true) {
                                       do {
                                          var38 = (ScriptEvent)scriptEvents.removeLast();
                                          if (var38 == null) {
                                             while(true) {
                                                class207 var39 = (class207)field565.removeLast();
                                                if (var39 == null) {
                                                   this.menu();
                                                   if (WorldMapData_1.worldMap != null) {
                                                      WorldMapData_1.worldMap.method2255(TaskHandler.Client_plane, (BuddyRankComparator.localPlayer.x >> 7) + GameEngine.baseX, (BuddyRankComparator.localPlayer.y >> 7) + class178.baseY, false);
                                                      WorldMapData_1.worldMap.loadCache();
                                                   }

                                                   if (clickedWidget != null) {
                                                      this.method367();
                                                   }

                                                   if (Scene.shouldSendWalk()) {
                                                      var3 = Scene.Scene_selectedX;
                                                      var4 = Scene.Scene_selectedY;
                                                      PacketBufferNode var40 = UserComparator9.getPacketBufferNode(ClientPacket.WALK, packetWriter.isaacCipher);
                                                      var40.packetBuffer.writeByte(5);
                                                      var40.packetBuffer.writeShortAdd(var4 + class178.baseY);
                                                      var40.packetBuffer.writeShort(var3 + GameEngine.baseX);
                                                      var40.packetBuffer.writeByteAdd(keyHandlerInstance.getKeyPressed(82) ? (keyHandlerInstance.getKeyPressed(81) ? 2 : 1) : 0);
                                                      packetWriter.addNode(var40);
                                                      Scene.method1219();
                                                      mouseCrossX = MouseHandler.MouseHandler_lastPressedX;
                                                      mouseCrossY = MouseHandler.MouseHandler_lastPressedY;
                                                      mouseCrossColor = 1;
                                                      mouseCrossState = 0;
                                                      destinationX = var3;
                                                      destinationY = var4;
                                                   }

                                                   if (var33 != InvDefinition.mousedOverWidgetIf1) {
                                                      if (var33 != null) {
                                                         class69.invalidateWidget(var33);
                                                      }

                                                      if (InvDefinition.mousedOverWidgetIf1 != null) {
                                                         class69.invalidateWidget(InvDefinition.mousedOverWidgetIf1);
                                                      }
                                                   }

                                                   if (var35 != Script.field803 && field410 == field424) {
                                                      if (var35 != null) {
                                                         class69.invalidateWidget(var35);
                                                      }

                                                      if (Script.field803 != null) {
                                                         class69.invalidateWidget(Script.field803);
                                                      }
                                                   }

                                                   if (Script.field803 != null) {
                                                      if (field410 < field424) {
                                                         ++field410;
                                                         if (field424 == field410) {
                                                            class69.invalidateWidget(Script.field803);
                                                         }
                                                      }
                                                   } else if (field410 > 0) {
                                                      --field410;
                                                   }

                                                   if (oculusOrbState == 0) {
                                                      var3 = BuddyRankComparator.localPlayer.x;
                                                      var4 = BuddyRankComparator.localPlayer.y;
                                                      if (GrandExchangeOfferOwnWorldComparator.oculusOrbFocalPointX - var3 < -500 || GrandExchangeOfferOwnWorldComparator.oculusOrbFocalPointX - var3 > 500 || ReflectionCheck.oculusOrbFocalPointY - var4 < -500 || ReflectionCheck.oculusOrbFocalPointY - var4 > 500) {
                                                         GrandExchangeOfferOwnWorldComparator.oculusOrbFocalPointX = var3;
                                                         ReflectionCheck.oculusOrbFocalPointY = var4;
                                                      }

                                                      if (var3 != GrandExchangeOfferOwnWorldComparator.oculusOrbFocalPointX) {
                                                         GrandExchangeOfferOwnWorldComparator.oculusOrbFocalPointX += (var3 - GrandExchangeOfferOwnWorldComparator.oculusOrbFocalPointX) / 16;
                                                      }

                                                      if (var4 != ReflectionCheck.oculusOrbFocalPointY) {
                                                         ReflectionCheck.oculusOrbFocalPointY += (var4 - ReflectionCheck.oculusOrbFocalPointY) / 16;
                                                      }

                                                      var5 = GrandExchangeOfferOwnWorldComparator.oculusOrbFocalPointX >> 7;
                                                      var6 = ReflectionCheck.oculusOrbFocalPointY >> 7;
                                                      var7 = WorldMapDecorationType.getTileHeight(GrandExchangeOfferOwnWorldComparator.oculusOrbFocalPointX, ReflectionCheck.oculusOrbFocalPointY, TaskHandler.Client_plane);
                                                      var8 = 0;
                                                      if (var5 > 3 && var6 > 3 && var5 < 100 && var6 < 100) {
                                                         for(var9 = var5 - 4; var9 <= var5 + 4; ++var9) {
                                                            for(var10 = var6 - 4; var10 <= var6 + 4; ++var10) {
                                                               var11 = TaskHandler.Client_plane;
                                                               if (var11 < 3 && (Tiles.Tiles_renderFlags[1][var9][var10] & 2) == 2) {
                                                                  ++var11;
                                                               }

                                                               var12 = var7 - Tiles.Tiles_heights[var11][var9][var10];
                                                               if (var12 > var8) {
                                                                  var8 = var12;
                                                               }
                                                            }
                                                         }
                                                      }

                                                      var9 = var8 * 192;
                                                      if (var9 > 98048) {
                                                         var9 = 98048;
                                                      }

                                                      if (var9 < 32768) {
                                                         var9 = 32768;
                                                      }

                                                      if (var9 > field375) {
                                                         field375 += (var9 - field375) / 24;
                                                      } else if (var9 < field375) {
                                                         field375 += (var9 - field375) / 80;
                                                      }

                                                      class128.field1233 = WorldMapDecorationType.getTileHeight(BuddyRankComparator.localPlayer.x, BuddyRankComparator.localPlayer.y, TaskHandler.Client_plane) - camFollowHeight;
                                                   } else if (oculusOrbState == 1) {
                                                      if (oculusOrbOnLocalPlayer && BuddyRankComparator.localPlayer != null) {
                                                         var3 = BuddyRankComparator.localPlayer.pathX[0];
                                                         var4 = BuddyRankComparator.localPlayer.pathY[0];
                                                         if (var3 >= 0 && var4 >= 0 && var3 < 104 && var4 < 104) {
                                                            GrandExchangeOfferOwnWorldComparator.oculusOrbFocalPointX = BuddyRankComparator.localPlayer.x;
                                                            var5 = WorldMapDecorationType.getTileHeight(BuddyRankComparator.localPlayer.x, BuddyRankComparator.localPlayer.y, TaskHandler.Client_plane) - camFollowHeight;
                                                            if (var5 < class128.field1233) {
                                                               class128.field1233 = var5;
                                                            }

                                                            ReflectionCheck.oculusOrbFocalPointY = BuddyRankComparator.localPlayer.y;
                                                            oculusOrbOnLocalPlayer = false;
                                                         }
                                                      }

                                                      short var30 = -1;
                                                      if (keyHandlerInstance.getKeyPressed(33)) {
                                                         var30 = 0;
                                                      } else if (keyHandlerInstance.getKeyPressed(49)) {
                                                         var30 = 1024;
                                                      }

                                                      if (keyHandlerInstance.getKeyPressed(48)) {
                                                         if (var30 == 0) {
                                                            var30 = 1792;
                                                         } else if (var30 == 1024) {
                                                            var30 = 1280;
                                                         } else {
                                                            var30 = 1536;
                                                         }
                                                      } else if (keyHandlerInstance.getKeyPressed(50)) {
                                                         if (var30 == 0) {
                                                            var30 = 256;
                                                         } else if (var30 == 1024) {
                                                            var30 = 768;
                                                         } else {
                                                            var30 = 512;
                                                         }
                                                      }

                                                      byte var31 = 0;
                                                      if (keyHandlerInstance.getKeyPressed(35)) {
                                                         var31 = -1;
                                                      } else if (keyHandlerInstance.getKeyPressed(51)) {
                                                         var31 = 1;
                                                      }

                                                      var5 = 0;
                                                      if (var30 >= 0 || var31 != 0) {
                                                         var5 = keyHandlerInstance.getKeyPressed(81) ? oculusOrbSlowedSpeed * -711638791 * -670334647 : oculusOrbNormalSpeed * 1001880197 * -571511219;
                                                         var5 *= 16;
                                                         field612 = var30;
                                                         field472 = var31;
                                                      }

                                                      if (field443 < var5) {
                                                         field443 += var5 / 8;
                                                         if (field443 > var5) {
                                                            field443 = var5;
                                                         }
                                                      } else if (field443 > var5) {
                                                         field443 = field443 * 9 / 10;
                                                      }

                                                      if (field443 > 0) {
                                                         var6 = field443 / 16;
                                                         if (field612 >= 0) {
                                                            var3 = field612 - class110.cameraYaw & 2047;
                                                            var7 = Rasterizer3D.Rasterizer3D_sine[var3];
                                                            var8 = Rasterizer3D.Rasterizer3D_cosine[var3];
                                                            GrandExchangeOfferOwnWorldComparator.oculusOrbFocalPointX += var6 * var7 / 65536;
                                                            ReflectionCheck.oculusOrbFocalPointY += var8 * var6 / 65536;
                                                         }

                                                         if (field472 != 0) {
                                                            class128.field1233 += var6 * field472;
                                                            if (class128.field1233 > 0) {
                                                               class128.field1233 = 0;
                                                            }
                                                         }
                                                      } else {
                                                         field612 = -1;
                                                         field472 = -1;
                                                      }

                                                      if (keyHandlerInstance.getKeyPressed(13)) {
                                                         ClanSettings.method810();
                                                      }
                                                   }

                                                   if (MouseHandler.MouseHandler_currentButton == 4 && class319.mouseCam) {
                                                      var3 = MouseHandler.MouseHandler_y - mouseCamClickedY;
                                                      camAngleDX = var3 * 2;
                                                      mouseCamClickedY = var3 != -1 && var3 != 1 ? (mouseCamClickedY + MouseHandler.MouseHandler_y) / 2 : MouseHandler.MouseHandler_y * -1454192657 * 1904035599;
                                                      var4 = mouseCamClickedX - MouseHandler.MouseHandler_x;
                                                      camAngleDY = var4 * 2;
                                                      mouseCamClickedX = var4 != -1 && var4 != 1 ? (MouseHandler.MouseHandler_x + mouseCamClickedX) / 2 : MouseHandler.MouseHandler_x * 1955742727 * -1669207625;
                                                   } else {
                                                      if (keyHandlerInstance.getKeyPressed(96)) {
                                                         camAngleDY += (-24 - camAngleDY) / 2;
                                                      } else if (keyHandlerInstance.getKeyPressed(97)) {
                                                         camAngleDY += (24 - camAngleDY) / 2;
                                                      } else {
                                                         camAngleDY /= 2;
                                                      }

                                                      if (keyHandlerInstance.getKeyPressed(98)) {
                                                         camAngleDX += (12 - camAngleDX) / 2;
                                                      } else if (keyHandlerInstance.getKeyPressed(99)) {
                                                         camAngleDX += (-12 - camAngleDX) / 2;
                                                      } else {
                                                         camAngleDX /= 2;
                                                      }

                                                      mouseCamClickedY = MouseHandler.MouseHandler_y;
                                                      mouseCamClickedX = MouseHandler.MouseHandler_x;
                                                   }

                                                   camAngleY = camAngleDY / 2 + camAngleY & 2047;
                                                   camAngleX += camAngleDX / 2;
                                                   if (camAngleX < 128) {
                                                      camAngleX = 128;
                                                   }

                                                   if (camAngleX > 383) {
                                                      camAngleX = 383;
                                                   }

                                                   if (field609) {
                                                      class11.method37();
                                                   } else if (isCameraLocked) {
                                                      var3 = class4.cameraMoveToX * 128 + 64;
                                                      var4 = WorldMapSectionType.cameraMoveToY * 128 + 64;
                                                      var5 = WorldMapDecorationType.getTileHeight(var3, var4, TaskHandler.Client_plane) - class269.cameraMoveToHeight;
                                                      PendingSpawn.method502(var3, var5, var4);
                                                      var3 = class167.cameraLookAtX * 128 + 64;
                                                      var4 = Canvas.cameraLookAtY * 128 + 64;
                                                      var5 = WorldMapDecorationType.getTileHeight(var3, var4, TaskHandler.Client_plane) - MidiPcmStream.cameraLookAtHeight;
                                                      var6 = var3 - class381.cameraX;
                                                      var7 = var5 - class351.cameraY;
                                                      var8 = var4 - class471.cameraZ;
                                                      var9 = (int)Math.sqrt((double)(var8 * var8 + var6 * var6));
                                                      var10 = (int)(Math.atan2((double)var7, (double)var9) * 325.9490051269531D) & 2047;
                                                      var11 = (int)(Math.atan2((double)var6, (double)var8) * -325.9490051269531D) & 2047;
                                                      class278.method1536(var10, var11);
                                                   }

                                                   for(var3 = 0; var3 < 5; ++var3) {
                                                      ++cameraShakeCycle[var3];
                                                   }

                                                   class248.varcs.tryWrite();
                                                   var3 = ModeWhere.method1900();
                                                   var4 = GameEngine.keyHandler.getIdleCycles();
                                                   if (var3 > 15000 && var4 > 15000) {
                                                      logoutTimer = 250;
                                                      MouseHandler.MouseHandler_idleCycles = 14500;
                                                      var18 = UserComparator9.getPacketBufferNode(ClientPacket.field2421, packetWriter.isaacCipher);
                                                      packetWriter.addNode(var18);
                                                   }

                                                   class6.friendSystem.processFriendUpdates();
                                                   method383();
                                                   ++packetWriter.pendingWrites;
                                                   if (packetWriter.pendingWrites > 50) {
                                                      var18 = UserComparator9.getPacketBufferNode(ClientPacket.field2456, packetWriter.isaacCipher);
                                                      packetWriter.addNode(var18);
                                                   }

                                                   try {
                                                      packetWriter.flush();
                                                   } catch (IOException var28) {
                                                      PendingSpawn.method501();
                                                   }

                                                   return;
                                                }

                                                class16.method57(var39);
                                             }
                                          }

                                          var36 = var38.widget;
                                          if (var36.childIndex < 0) {
                                             break;
                                          }

                                          var27 = WorldMapSection1.getWidget(var36.parentId);
                                       } while(var27 == null || var27.children == null || var36.childIndex >= var27.children.length || var36 != var27.children[var36.childIndex]);

                                       class9.runScriptEvent(var38);
                                    }
                                 }

                                 var36 = var38.widget;
                                 if (var36.childIndex < 0) {
                                    break;
                                 }

                                 var27 = WorldMapSection1.getWidget(var36.parentId);
                              } while(var27 == null || var27.children == null || var36.childIndex >= var27.children.length || var36 != var27.children[var36.childIndex]);

                              class9.runScriptEvent(var38);
                           }
                        }

                        var36 = var38.widget;
                        if (var36.childIndex < 0) {
                           break;
                        }

                        var27 = WorldMapSection1.getWidget(var36.parentId);
                     } while(var27 == null || var27.children == null || var36.childIndex >= var27.children.length || var36 != var27.children[var36.childIndex]);

                     class9.runScriptEvent(var38);
                  }
               }
            }
         }
      }
   }

   @ObfuscatedName("hx")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "0"
   )
   @Export("resizeJS")
   void resizeJS() {
      int var1 = GameEngine.canvasWidth;
      int var2 = class143.canvasHeight;
      if (super.contentWidth < var1) {
         var1 = super.contentWidth;
      }

      if (super.contentHeight < var2) {
         var2 = super.contentHeight;
      }

      if (WorldMapSectionType.clientPreferences != null) {
         try {
            class26.method106(class392.client, "resize", new Object[]{class7.getWindowedMode()});
         } catch (Throwable var4) {
            ;
         }
      }

   }

   @ObfuscatedName("hi")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "-1404157217"
   )
   @Export("drawLoggedIn")
   final void drawLoggedIn() {
      int var1;
      if (rootInterface != -1) {
         var1 = rootInterface;
         if (GrandExchangeEvent.loadInterface(var1)) {
            class31.drawModelComponents(class155.Widget_interfaceComponents[var1], -1);
         }
      }

      for(var1 = 0; var1 < rootWidgetCount; ++var1) {
         if (field594[var1]) {
            field570[var1] = true;
         }

         field571[var1] = field594[var1];
         field594[var1] = false;
      }

      field568 = cycle;
      viewportX = -1;
      viewportY = -1;
      if (rootInterface != -1) {
         rootWidgetCount = 0;
         GrandExchangeOfferOwnWorldComparator.drawWidgets(rootInterface, 0, 0, GameEngine.canvasWidth, class143.canvasHeight, 0, 0, -1);
      }

      Rasterizer2D.Rasterizer2D_resetClip();
      if (showMouseCross) {
         if (mouseCrossColor == 1) {
            Friend.crossSprites[mouseCrossState / 100].drawTransBgAt(mouseCrossX - 8, mouseCrossY - 8);
         }

         if (mouseCrossColor == 2) {
            Friend.crossSprites[mouseCrossState / 100 + 4].drawTransBgAt(mouseCrossX - 8, mouseCrossY - 8);
         }
      }

      int var2;
      int var3;
      if (!isMenuOpen) {
         if (viewportX != -1) {
            var1 = viewportX;
            var2 = viewportY;
            if ((menuOptionsCount >= 2 || isItemSelected != 0 || isSpellSelected) && showMouseOverText) {
               var3 = menuOptionsCount - 1;
               String var5;
               if (isItemSelected == 1 && menuOptionsCount < 2) {
                  var5 = "Use" + " " + field513 + " " + "->";
               } else if (isSpellSelected && menuOptionsCount < 2) {
                  var5 = field583 + " " + field518 + " " + "->";
               } else {
                  var5 = SceneTilePaint.method1297(var3);
               }

               if (menuOptionsCount > 2) {
                  var5 = var5 + Canvas.colorStartTag(16777215) + " " + '/' + " " + (menuOptionsCount - 2) + " more options";
               }

               class7.fontBold12.drawRandomAlphaAndSpacing(var5, var1 + 4, var2 + 15, 16777215, 0, cycle / 1000);
            }
         }
      } else {
         UserComparator2.method2487();
      }

      if (gameDrawingMode == 3) {
         for(var1 = 0; var1 < rootWidgetCount; ++var1) {
            if (field571[var1]) {
               Rasterizer2D.Rasterizer2D_fillRectangleAlpha(rootWidgetXs[var1], rootWidgetYs[var1], rootWidgetWidths[var1], rootWidgetHeights[var1], 16711935, 128);
            } else if (field570[var1]) {
               Rasterizer2D.Rasterizer2D_fillRectangleAlpha(rootWidgetXs[var1], rootWidgetYs[var1], rootWidgetWidths[var1], rootWidgetHeights[var1], 16711680, 128);
            }
         }
      }

      var1 = TaskHandler.Client_plane;
      var2 = BuddyRankComparator.localPlayer.x;
      var3 = BuddyRankComparator.localPlayer.y;
      int var4 = field504;

      for(ObjectSound var13 = (ObjectSound)ObjectSound.objectSounds.last(); var13 != null; var13 = (ObjectSound)ObjectSound.objectSounds.previous()) {
         if (var13.soundEffectId != -1 || var13.soundEffectIds != null) {
            int var6 = 0;
            if (var2 > var13.maxX) {
               var6 += var2 - var13.maxX;
            } else if (var2 < var13.x) {
               var6 += var13.x - var2;
            }

            if (var3 > var13.maxY) {
               var6 += var3 - var13.maxY;
            } else if (var3 < var13.y) {
               var6 += var13.y - var3;
            }

            if (var6 - 64 <= var13.field672 && WorldMapSectionType.clientPreferences.getAreaSoundEffectsVolume() != 0 && var1 == var13.plane) {
               var6 -= 64;
               if (var6 < 0) {
                  var6 = 0;
               }

               int var7 = (var13.field672 - var6) * WorldMapSectionType.clientPreferences.getAreaSoundEffectsVolume() / var13.field672;
               Object var10000;
               if (var13.stream1 == null) {
                  if (var13.soundEffectId >= 0) {
                     var10000 = null;
                     SoundEffect var8 = SoundEffect.readSoundEffect(class175.field1434, var13.soundEffectId, 0);
                     if (var8 != null) {
                        RawSound var9 = var8.toRawSound().resample(TaskHandler.decimator);
                        RawPcmStream var10 = RawPcmStream.createRawPcmStream(var9, 100, var7);
                        var10.setNumLoops(-1);
                        class323.pcmStreamMixer.addSubStream(var10);
                        var13.stream1 = var10;
                     }
                  }
               } else {
                  var13.stream1.method279(var7);
               }

               if (var13.stream2 == null) {
                  if (var13.soundEffectIds != null && (var13.field678 -= var4) <= 0) {
                     int var12 = (int)(Math.random() * (double)var13.soundEffectIds.length);
                     var10000 = null;
                     SoundEffect var14 = SoundEffect.readSoundEffect(class175.field1434, var13.soundEffectIds[var12], 0);
                     if (var14 != null) {
                        RawSound var15 = var14.toRawSound().resample(TaskHandler.decimator);
                        RawPcmStream var11 = RawPcmStream.createRawPcmStream(var15, 100, var7);
                        var11.setNumLoops(0);
                        class323.pcmStreamMixer.addSubStream(var11);
                        var13.stream2 = var11;
                        var13.field678 = var13.field666 + (int)(Math.random() * (double)(var13.field668 - var13.field666));
                     }
                  }
               } else {
                  var13.stream2.method279(var7);
                  if (!var13.stream2.hasNext()) {
                     var13.stream2 = null;
                  }
               }
            } else {
               if (var13.stream1 != null) {
                  class323.pcmStreamMixer.removeSubStream(var13.stream1);
                  var13.stream1 = null;
               }

               if (var13.stream2 != null) {
                  class323.pcmStreamMixer.removeSubStream(var13.stream2);
                  var13.stream2 = null;
               }
            }
         }
      }

      field504 = 0;
   }

   @ObfuscatedName("it")
   @ObfuscatedSignature(
      descriptor = "(Lep;II)Z",
      garbageValue = "-468698834"
   )
   boolean method361(PacketWriter var1, int var2) {
      if (var1.serverPacketLength == 0) {
         ReflectionCheck.friendsChat = null;
      } else {
         if (ReflectionCheck.friendsChat == null) {
            ReflectionCheck.friendsChat = new FriendsChat(Occluder.loginType, class392.client);
         }

         ReflectionCheck.friendsChat.method2088(var1.packetBuffer, var2);
      }

      class31.method129();
      var1.serverPacket = null;
      return true;
   }

   @ObfuscatedName("ju")
   @ObfuscatedSignature(
      descriptor = "(Lep;S)Z",
      garbageValue = "30632"
   )
   boolean method362(PacketWriter var1) {
      if (ReflectionCheck.friendsChat != null) {
         ReflectionCheck.friendsChat.method2089(var1.packetBuffer);
      }

      class31.method129();
      var1.serverPacket = null;
      return true;
   }

   @ObfuscatedName("jc")
   @ObfuscatedSignature(
      descriptor = "(Lep;I)Z",
      garbageValue = "1828480042"
   )
   final boolean method377(PacketWriter var1) {
      AbstractSocket var2 = var1.getSocket();
      PacketBuffer var3 = var1.packetBuffer;
      if (var2 == null) {
         return false;
      } else {
         int var21;
         String var24;
         try {
            int var5;
            if (var1.serverPacket == null) {
               if (var1.field1126) {
                  if (!var2.isAvailable(1)) {
                     return false;
                  }

                  var2.read(var1.packetBuffer.array, 0, 1);
                  var1.field1124 = 0;
                  var1.field1126 = false;
               }

               var3.offset = 0;
               if (var3.method2384()) {
                  if (!var2.isAvailable(1)) {
                     return false;
                  }

                  var2.read(var1.packetBuffer.array, 1, 1);
                  var1.field1124 = 0;
               }

               var1.field1126 = true;
               ServerPacket[] var4 = class258.ServerPacket_values();
               var5 = var3.readSmartByteShortIsaac();
               if (var5 < 0 || var5 >= var4.length) {
                  throw new IOException(var5 + " " + var3.offset);
               }

               var1.serverPacket = var4[var5];
               var1.serverPacketLength = var1.serverPacket.length;
            }

            if (var1.serverPacketLength == -1) {
               if (!var2.isAvailable(1)) {
                  return false;
               }

               var1.getSocket().read(var3.array, 0, 1);
               var1.serverPacketLength = var3.array[0] & 255;
            }

            if (var1.serverPacketLength == -2) {
               if (!var2.isAvailable(2)) {
                  return false;
               }

               var1.getSocket().read(var3.array, 0, 2);
               var3.offset = 0;
               var1.serverPacketLength = var3.readUnsignedShort();
            }

            if (!var2.isAvailable(var1.serverPacketLength)) {
               return false;
            }

            var3.offset = 0;
            var2.read(var3.array, 0, var1.serverPacketLength);
            var1.field1124 = 0;
            timer.method2040();
            var1.field1131 = var1.field1130;
            var1.field1130 = var1.field1129;
            var1.field1129 = var1.serverPacket;
            if (ServerPacket.field2553 == var1.serverPacket) {
               class150.processZoneOperation(ZoneOperation.field2520);
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2563 == var1.serverPacket) {
               GrandExchangeOfferNameComparator.process();
               weight = var3.readShort();
               field559 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2543 == var1.serverPacket) {
               class150.processZoneOperation(ZoneOperation.field2526);
               var1.serverPacket = null;
               return true;
            }

            Widget var6;
            int var20;
            if (ServerPacket.field2538 == var1.serverPacket) {
               var20 = var3.readIntME();
               var5 = var3.readUnsignedShortAdd();
               var6 = WorldMapSection1.getWidget(var20);
               if (var6 != null && var6.type == 0) {
                  if (var5 > var6.scrollHeight - var6.height) {
                     var5 = var6.scrollHeight - var6.height;
                  }

                  if (var5 < 0) {
                     var5 = 0;
                  }

                  if (var5 != var6.scrollY) {
                     var6.scrollY = var5;
                     class69.invalidateWidget(var6);
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2623 == var1.serverPacket) {
               class150.processZoneOperation(ZoneOperation.field2524);
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2620 == var1.serverPacket) {
               class207.privateChatMode = class181.method924(var3.readUnsignedByte());
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2612 == var1.serverPacket) {
               isCameraLocked = true;
               field609 = false;
               class4.cameraMoveToX = var3.readUnsignedByte();
               WorldMapSectionType.cameraMoveToY = var3.readUnsignedByte();
               class269.cameraMoveToHeight = var3.readUnsignedShort();
               class19.cameraMoveToSpeed = var3.readUnsignedByte();
               class313.cameraMoveToAcceleration = var3.readUnsignedByte();
               if (class313.cameraMoveToAcceleration >= 100) {
                  class381.cameraX = class4.cameraMoveToX * 128 + 64;
                  class471.cameraZ = WorldMapSectionType.cameraMoveToY * 128 + 64;
                  class351.cameraY = WorldMapDecorationType.getTileHeight(class381.cameraX, class471.cameraZ, TaskHandler.Client_plane) - class269.cameraMoveToHeight;
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2637 == var1.serverPacket) {
               var20 = var3.readUnsignedShort();
               rootInterface = var20;
               this.resizeRoot(false);
               ApproximateRouteStrategy.Widget_resetModelFrames(var20);
               WorldMapSection1.runWidgetOnLoadListener(rootInterface);

               for(var5 = 0; var5 < 100; ++var5) {
                  field594[var5] = true;
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2584 == var1.serverPacket) {
               var20 = var3.readUnsignedByte();
               Player.forceDisconnect(var20);
               var1.serverPacket = null;
               return false;
            }

            if (ServerPacket.field2627 == var1.serverPacket) {
               hintArrowType = var3.readUnsignedByte();
               if (hintArrowType == 1) {
                  hintArrowNpcIndex = var3.readUnsignedShort();
               }

               if (hintArrowType >= 2 && hintArrowType <= 6) {
                  if (hintArrowType == 2) {
                     hintArrowSubX = 64;
                     hintArrowSubY = 64;
                  }

                  if (hintArrowType == 3) {
                     hintArrowSubX = 0;
                     hintArrowSubY = 64;
                  }

                  if (hintArrowType == 4) {
                     hintArrowSubX = 128;
                     hintArrowSubY = 64;
                  }

                  if (hintArrowType == 5) {
                     hintArrowSubX = 64;
                     hintArrowSubY = 0;
                  }

                  if (hintArrowType == 6) {
                     hintArrowSubX = 64;
                     hintArrowSubY = 128;
                  }

                  hintArrowType = 2;
                  hintArrowX = var3.readUnsignedShort();
                  hintArrowY = var3.readUnsignedShort();
                  hintArrowHeight = var3.readUnsignedByte();
               }

               if (hintArrowType == 10) {
                  hintArrowPlayerIndex = var3.readUnsignedShort();
               }

               var1.serverPacket = null;
               return true;
            }

            int var8;
            NPC var59;
            if (ServerPacket.field2548 == var1.serverPacket) {
               var21 = var3.readUnsignedByteNeg();
               var20 = var3.readUnsignedShortLE();
               var5 = var3.readUnsignedShortAddLE();
               if (var5 == 65535) {
                  var5 = -1;
               }

               var59 = npcs[var20];
               if (var59 != null) {
                  if (var5 == var59.sequence && var5 != -1) {
                     var8 = Coord.SequenceDefinition_get(var5).replyMode;
                     if (var8 == 1) {
                        var59.sequenceFrame = 0;
                        var59.sequenceFrameCycle = 0;
                        var59.sequenceDelay = var21;
                        var59.currentSequenceFrameIndex = 0;
                     } else if (var8 == 2) {
                        var59.currentSequenceFrameIndex = 0;
                     }
                  } else if (var5 == -1 || var59.sequence == -1 || Coord.SequenceDefinition_get(var5).forcedPriority >= Coord.SequenceDefinition_get(var59.sequence).forcedPriority) {
                     var59.sequence = var5;
                     var59.sequenceFrame = 0;
                     var59.sequenceFrameCycle = 0;
                     var59.sequenceDelay = var21;
                     var59.currentSequenceFrameIndex = 0;
                     var59.field1004 = var59.pathLength;
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2626 == var1.serverPacket) {
               class6.friendSystem.readUpdate(var3, var1.serverPacketLength);
               field573 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            int var22;
            if (ServerPacket.field2614 == var1.serverPacket) {
               GrandExchangeOfferNameComparator.process();
               var20 = var3.readUnsignedByteAdd();
               var5 = var3.readUnsignedByteAdd();
               var21 = var3.readIntME();
               experience[var20] = var21;
               currentLevels[var20] = var5;
               levels[var20] = 1;

               for(var22 = 0; var22 < 98; ++var22) {
                  if (var21 >= Skills.Skills_experienceTable[var22]) {
                     levels[var20] = var22 + 2;
                  }
               }

               changedSkills[++changedSkillsCount - 1 & 31] = var20;
               var1.serverPacket = null;
               return true;
            }

            byte var84;
            if (ServerPacket.field2539 == var1.serverPacket) {
               field357 = cycleCntr;
               var84 = var3.readByte();
               if (var1.serverPacketLength == 1) {
                  if (var84 >= 0) {
                     currentClanChannels[var84] = null;
                  } else {
                     class19.guestClanChannel = null;
                  }

                  var1.serverPacket = null;
                  return true;
               }

               if (var84 >= 0) {
                  currentClanChannels[var84] = new ClanChannel(var3);
               } else {
                  class19.guestClanChannel = new ClanChannel(var3);
               }

               var1.serverPacket = null;
               return true;
            }

            int var9;
            int var10;
            int var11;
            int var12;
            int var13;
            int var14;
            int var15;
            int var16;
            if (ServerPacket.field2607 == var1.serverPacket) {
               var15 = var3.readUnsignedShortAdd();
               var13 = var3.readUnsignedByteAdd() * 4;
               int var17 = var3._readUnsignedByteSub();
               byte var67 = var3.readByteAdd();
               byte var63 = var3.readUnsignedByteSub();
               var21 = var3.readMedium();
               var20 = var21 >> 16;
               var5 = var21 >> 8 & 255;
               var22 = var20 + (var21 >> 4 & 7);
               var8 = var5 + (var21 & 7);
               var12 = var3.readUnsignedShort();
               int var18 = var3.readUnsignedByteNeg();
               var14 = var3.readUnsignedByte() * 4;
               var11 = var3.readSignedMedium_1();
               var16 = var3.readUnsignedShortAddLE();
               var9 = var67 + var22;
               var10 = var63 + var8;
               if (var22 >= 0 && var8 >= 0 && var22 < 104 && var8 < 104 && var9 >= 0 && var10 >= 0 && var9 < 104 && var10 < 104 && var12 != 65535) {
                  var22 = var22 * 128 + 64;
                  var8 = var8 * 128 + 64;
                  var9 = var9 * 128 + 64;
                  var10 = var10 * 128 + 64;
                  Projectile var19 = new Projectile(var12, TaskHandler.Client_plane, var22, var8, WorldMapDecorationType.getTileHeight(var22, var8, TaskHandler.Client_plane) - var13, var15 + cycle, var16 + cycle, var17, var18, var11, var14);
                  var19.setDestination(var9, var10, WorldMapDecorationType.getTileHeight(var9, var10, TaskHandler.Client_plane) - var14, var15 + cycle);
                  projectiles.addFirst(var19);
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2619 == var1.serverPacket) {
               for(var20 = 0; var20 < Varps.Varps_main.length; ++var20) {
                  if (Varps.Varps_main[var20] != Varps.Varps_temp[var20]) {
                     Varps.Varps_main[var20] = Varps.Varps_temp[var20];
                     class159.changeGameOptions(var20);
                     changedVarps[++changedVarpCount - 1 & 31] = var20;
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2616 == var1.serverPacket) {
               destinationX = var3.readUnsignedByte();
               if (destinationX == 255) {
                  destinationX = 0;
               }

               destinationY = var3.readUnsignedByte();
               if (destinationY == 255) {
                  destinationY = 0;
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2639 == var1.serverPacket) {
               return this.method362(var1);
            }

            if (ServerPacket.field2635 == var1.serverPacket) {
               var20 = var3.readUnsignedShortLE();
               var5 = var3.readIntLE();
               var21 = var20 >> 10 & 31;
               var22 = var20 >> 5 & 31;
               var8 = var20 & 31;
               var9 = (var22 << 11) + (var21 << 19) + (var8 << 3);
               Widget var76 = WorldMapSection1.getWidget(var5);
               if (var9 != var76.color) {
                  var76.color = var9;
                  class69.invalidateWidget(var76);
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2570 == var1.serverPacket && isCameraLocked) {
               field609 = true;
               class19.cameraMoveToSpeed = var3.readUnsignedByte();
               class313.cameraMoveToAcceleration = var3.readUnsignedByte();
               GrandExchangeOfferUnitPriceComparator.cameraLookAtSpeed = var3.readUnsignedByte();
               Skeleton.cameraLookAtAcceleration = var3.readUnsignedByte();

               for(var20 = 0; var20 < 5; ++var20) {
                  cameraShaking[var20] = false;
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2605 == var1.serverPacket) {
               for(var20 = 0; var20 < VarpDefinition.field1461; ++var20) {
                  VarpDefinition var88 = GameEngine.VarpDefinition_get(var20);
                  if (var88 != null) {
                     Varps.Varps_temp[var20] = 0;
                     Varps.Varps_main[var20] = 0;
                  }
               }

               GrandExchangeOfferNameComparator.process();
               changedVarpCount += 32;
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2603 == var1.serverPacket) {
               var20 = var3.readUnsignedShortAddLE();
               var5 = var3.readIntIME();
               Varps.Varps_temp[var20] = var5;
               if (Varps.Varps_main[var20] != var5) {
                  Varps.Varps_main[var20] = var5;
               }

               class159.changeGameOptions(var20);
               changedVarps[++changedVarpCount - 1 & 31] = var20;
               var1.serverPacket = null;
               return true;
            }

            Widget var80;
            if (ServerPacket.field2644 == var1.serverPacket) {
               var20 = var3.readIntME();
               var80 = WorldMapSection1.getWidget(var20);
               var80.modelType = 3;
               var80.modelId = BuddyRankComparator.localPlayer.appearance.getChatHeadId();
               class69.invalidateWidget(var80);
               var1.serverPacket = null;
               return true;
            }

            String var62;
            if (ServerPacket.field2606 == var1.serverPacket) {
               byte[] var57 = new byte[var1.serverPacketLength];
               var3.method2386(var57, 0, var57.length);
               Buffer var87 = new Buffer(var57);
               var62 = var87.readStringCp1252NullTerminated();
               KeyHandler.openURL(var62, true, false);
               var1.serverPacket = null;
               return true;
            }

            Widget var79;
            if (ServerPacket.field2610 == var1.serverPacket) {
               var20 = var3.readUnsignedShort();
               var5 = var3.readUnsignedShort();
               var21 = var3.readIntIME();
               var22 = var3.readUnsignedShortLE();
               var79 = WorldMapSection1.getWidget(var21);
               if (var20 != var79.modelAngleX || var22 != var79.modelAngleY || var5 != var79.modelZoom) {
                  var79.modelAngleX = var20;
                  var79.modelAngleY = var22;
                  var79.modelZoom = var5;
                  class69.invalidateWidget(var79);
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2580 == var1.serverPacket) {
               class279.method1540();
               var84 = var3.readByte();
               if (var1.serverPacketLength == 1) {
                  if (var84 >= 0) {
                     currentClanSettings[var84] = null;
                  } else {
                     WorldMapCacheName.guestClanSettings = null;
                  }

                  var1.serverPacket = null;
                  return true;
               }

               if (var84 >= 0) {
                  currentClanSettings[var84] = new ClanSettings(var3);
               } else {
                  WorldMapCacheName.guestClanSettings = new ClanSettings(var3);
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2566 == var1.serverPacket) {
               class278.logOut();
               var1.serverPacket = null;
               return false;
            }

            boolean var73;
            if (ServerPacket.field2642 == var1.serverPacket) {
               var73 = var3.readUnsignedByteAdd() == 1;
               var5 = var3.readInt();
               var6 = WorldMapSection1.getWidget(var5);
               if (var73 != var6.isHidden) {
                  var6.isHidden = var73;
                  class69.invalidateWidget(var6);
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2541 == var1.serverPacket) {
               class150.processZoneOperation(ZoneOperation.field2528);
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2631 == var1.serverPacket) {
               var20 = var3.readUnsignedShortAdd();
               byte var72 = var3.readByte();
               Varps.Varps_temp[var20] = var72;
               if (Varps.Varps_main[var20] != var72) {
                  Varps.Varps_main[var20] = var72;
               }

               class159.changeGameOptions(var20);
               changedVarps[++changedVarpCount - 1 & 31] = var20;
               var1.serverPacket = null;
               return true;
            }

            String var52;
            if (ServerPacket.field2590 == var1.serverPacket) {
               var52 = var3.readStringCp1252NullTerminated();
               var5 = var3.readUnsignedByteAdd();
               var21 = var3.readUnsignedByte();
               if (var5 >= 1 && var5 <= 8) {
                  if (var52.equalsIgnoreCase("null")) {
                     var52 = null;
                  }

                  playerMenuActions[var5 - 1] = var52;
                  playerOptionsPriorities[var5 - 1] = var21 == 0;
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2596 == var1.serverPacket) {
               var20 = var3.readUnsignedShort();
               class377.method1990(var20);
               changedItemContainers[++changedItemContainersCount - 1 & 31] = var20 & 32767;
               var1.serverPacket = null;
               return true;
            }

            long var26;
            long var28;
            long var30;
            long var33;
            String var35;
            if (ServerPacket.field2621 == var1.serverPacket) {
               var52 = var3.readStringCp1252NullTerminated();
               var26 = var3.readLong();
               var28 = (long)var3.readUnsignedShort();
               var30 = (long)var3.readMedium();
               PlayerType var90 = (PlayerType)SpriteMask.findEnumerated(MoveSpeed.PlayerType_values(), var3.readUnsignedByte());
               var33 = (var28 << 32) + var30;
               boolean var71 = false;

               for(var15 = 0; var15 < 100; ++var15) {
                  if (crossWorldMessageIds[var15] == var33) {
                     var71 = true;
                     break;
                  }
               }

               if (var90.isUser && class6.friendSystem.isIgnored(new Username(var52, Occluder.loginType))) {
                  var71 = true;
               }

               if (!var71 && field540 == 0) {
                  crossWorldMessageIds[crossWorldMessageIdsIndex] = var33;
                  crossWorldMessageIdsIndex = (crossWorldMessageIdsIndex + 1) % 100;
                  var35 = AbstractFont.escapeBrackets(class33.method136(class279.readString(var3)));
                  if (var90.modIcon != -1) {
                     class12.addChatMessage(9, class7.addImageTag(var90.modIcon) + var52, var35, GrandExchangeOffer.base37DecodeLong(var26));
                  } else {
                     class12.addChatMessage(9, var52, var35, GrandExchangeOffer.base37DecodeLong(var26));
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2622 == var1.serverPacket) {
               var20 = var3.readUnsignedShortAdd();
               var5 = var3.readUnsignedByteAdd();
               var21 = var3.readIntME();
               short var89 = (short)var3.readSignedShortAdd();
               NPC var85 = npcs[var20];
               if (var85 != null) {
                  var85.method566(var5, var21, var89);
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.MESSAGE_PRIVATE_ECHO == var1.serverPacket) {
               var52 = var3.readStringCp1252NullTerminated();
               var24 = AbstractFont.escapeBrackets(class33.method136(class279.readString(var3)));
               MusicPatchNode.addGameMessage(6, var52, var24);
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.REBUILD_REGION_NORMAL == var1.serverPacket) {
               Skeleton.loadRegions(false, var1.packetBuffer);
               var1.serverPacket = null;
               return true;
            }

            GameObject var42;
            if (ServerPacket.field2608 == var1.serverPacket) {
               var84 = var3.readByte();
               var24 = var3.readStringCp1252NullTerminated();
               long var36 = (long)var3.readUnsignedShort();
               long var38 = (long)var3.readMedium();
               PlayerType var74 = (PlayerType)SpriteMask.findEnumerated(MoveSpeed.PlayerType_values(), var3.readUnsignedByte());
               long var40 = var38 + (var36 << 32);
               boolean var69 = false;
               var42 = null;
               ClanChannel var94 = var84 >= 0 ? currentClanChannels[var84] : class19.guestClanChannel;
               if (var94 == null) {
                  var69 = true;
               } else {
                  var15 = 0;

                  while(true) {
                     if (var15 >= 100) {
                        if (var74.isUser && class6.friendSystem.isIgnored(new Username(var24, Occluder.loginType))) {
                           var69 = true;
                        }
                        break;
                     }

                     if (var40 == crossWorldMessageIds[var15]) {
                        var69 = true;
                        break;
                     }

                     ++var15;
                  }
               }

               if (!var69) {
                  crossWorldMessageIds[crossWorldMessageIdsIndex] = var40;
                  crossWorldMessageIdsIndex = (crossWorldMessageIdsIndex + 1) % 100;
                  var35 = AbstractFont.escapeBrackets(class279.readString(var3));
                  var16 = var84 >= 0 ? 41 : 44;
                  if (var74.modIcon != -1) {
                     class12.addChatMessage(var16, class7.addImageTag(var74.modIcon) + var24, var35, var94.name);
                  } else {
                     class12.addChatMessage(var16, var24, var35, var94.name);
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2599 == var1.serverPacket) {
               class279.method1540();
               var84 = var3.readByte();
               class143 var82 = new class143(var3);
               ClanSettings var66;
               if (var84 >= 0) {
                  var66 = currentClanSettings[var84];
               } else {
                  var66 = WorldMapCacheName.guestClanSettings;
               }

               var82.method759(var66);
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.CAM_SHAKE == var1.serverPacket) {
               var20 = var3.readUnsignedByte();
               var5 = var3.readUnsignedByte();
               var21 = var3.readUnsignedByte();
               var22 = var3.readUnsignedByte();
               cameraShaking[var20] = true;
               cameraShakeIntensity[var20] = var5;
               cameraMoveIntensity[var20] = var21;
               cameraShakeSpeed[var20] = var22;
               cameraShakeCycle[var20] = 0;
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.TOGGLE_OCULUS_ORB == var1.serverPacket) {
               var20 = var3.readInt();
               if (var20 != field448) {
                  field448 = var20;
                  Varcs.method619();
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2640 == var1.serverPacket) {
               class188.varclan = null;
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2544 == var1.serverPacket) {
               class6.friendSystem.ignoreList.read(var3, var1.serverPacketLength);
               Message.FriendSystem_invalidateIgnoreds();
               field573 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2562 == var1.serverPacket) {
               minimapState = var3.readUnsignedByte();
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2600 == var1.serverPacket) {
               var20 = var3.readInt();
               InterfaceParent var81 = (InterfaceParent)interfaceParents.get((long)var20);
               if (var81 != null) {
                  class17.closeInterface(var81, true);
               }

               if (meslayerContinueWidget != null) {
                  class69.invalidateWidget(meslayerContinueWidget);
                  meslayerContinueWidget = null;
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2604 == var1.serverPacket) {
               var20 = var3.readUnsignedByte();
               if (var3.readUnsignedByte() == 0) {
                  grandExchangeOffers[var20] = new GrandExchangeOffer();
                  var3.offset += 18;
               } else {
                  --var3.offset;
                  grandExchangeOffers[var20] = new GrandExchangeOffer(var3, false);
               }

               field516 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2556 == var1.serverPacket) {
               ApproximateRouteStrategy.method340(var3.readStringCp1252NullTerminated());
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2615 == var1.serverPacket) {
               isCameraLocked = false;

               for(var20 = 0; var20 < 5; ++var20) {
                  cameraShaking[var20] = false;
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2611 == var1.serverPacket) {
               var20 = var3.readUnsignedShortLE();
               var5 = var3.readInt();
               var6 = WorldMapSection1.getWidget(var5);
               if (var6.modelType != 6 || var20 != var6.modelId) {
                  var6.modelType = 6;
                  var6.modelId = var20;
                  class69.invalidateWidget(var6);
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2633 == var1.serverPacket) {
               var20 = var3.readInt();
               var5 = var3.readInt();
               var21 = class105.getGcDuration();
               PacketBufferNode var60 = UserComparator9.getPacketBufferNode(ClientPacket.field2446, packetWriter.isaacCipher);
               var60.packetBuffer.writeIntME(var20);
               var60.packetBuffer.writeIntIME(var5);
               var60.packetBuffer.writeByte(var21);
               var60.packetBuffer.writeByteNeg(GameEngine.fps);
               packetWriter.addNode(var60);
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2547 == var1.serverPacket) {
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2540 == var1.serverPacket) {
               rebootTimer = var3.readUnsignedShortAddLE() * 30;
               field559 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2555 == var1.serverPacket) {
               var20 = var3.readInt();
               var5 = var3.readUnsignedShortAdd();
               var6 = WorldMapSection1.getWidget(var20);
               if (var6.modelType != 1 || var5 != var6.modelId) {
                  var6.modelType = 1;
                  var6.modelId = var5;
                  class69.invalidateWidget(var6);
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2552 == var1.serverPacket) {
               var21 = var3.readUnsignedShort();
               var5 = var3.readIntIME();
               var20 = var3.readUnsignedShortAdd();
               var59 = npcs[var20];
               if (var59 != null) {
                  var59.spotAnimation = var21;
                  var59.spotAnimHeight = var5 >> 16;
                  var59.spotAnimationStartCycle = (var5 & '\uffff') + cycle;
                  var59.spotAnimationFrame = 0;
                  var59.field964 = 0;
                  if (var59.spotAnimationStartCycle > cycle) {
                     var59.spotAnimationFrame = -1;
                  }

                  if (var59.spotAnimation == 65535) {
                     var59.spotAnimation = -1;
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2589 == var1.serverPacket) {
               var20 = var3.readUShortSmart();
               boolean var70 = var3.readUnsignedByte() == 1;
               var62 = "";
               boolean var86 = false;
               if (var70) {
                  var62 = var3.readStringCp1252NullTerminated();
                  if (class6.friendSystem.isIgnored(new Username(var62, Occluder.loginType))) {
                     var86 = true;
                  }
               }

               String var83 = var3.readStringCp1252NullTerminated();
               if (!var86) {
                  MusicPatchNode.addGameMessage(var20, var62, var83);
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.FRIENDLIST_LOADED == var1.serverPacket) {
               class6.friendSystem.FRIENDLIST_WAS_LOADED();
               field573 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.VARCLAN == var1.serverPacket) {
               if (class188.varclan == null) {
                  class188.varclan = new class425(Messages.HitSplatDefinition_cached);
               }

               class486 var53 = Messages.HitSplatDefinition_cached.method2213(var3);
               class188.varclan.field3768.vmethod8143(var53.field4027, var53.field4026);
               field550[++field551 - 1 & 31] = var53.field4027;
               var1.serverPacket = null;
               return true;
            }

            InterfaceParent var56;
            if (ServerPacket.IF_MOVESUB == var1.serverPacket) {
               var20 = var3.readIntLE();
               var5 = var3.readIntME();
               InterfaceParent var61 = (InterfaceParent)interfaceParents.get((long)var20);
               var56 = (InterfaceParent)interfaceParents.get((long)var5);
               if (var56 != null) {
                  class17.closeInterface(var56, var61 == null || var61.group != var56.group);
               }

               if (var61 != null) {
                  var61.remove();
                  interfaceParents.put(var61, (long)var5);
               }

               var79 = WorldMapSection1.getWidget(var20);
               if (var79 != null) {
                  class69.invalidateWidget(var79);
               }

               var79 = WorldMapSection1.getWidget(var5);
               if (var79 != null) {
                  class69.invalidateWidget(var79);
                  class278.revalidateWidgetScroll(class155.Widget_interfaceComponents[var79.id >>> 16], var79, true);
               }

               if (rootInterface != -1) {
                  NPCComposition.runIntfCloseListeners(rootInterface, 1);
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.NPC_INFO_SMALL == var1.serverPacket) {
               class148.updateNpcs(false, var3);
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.ENTER_FREECAM == var1.serverPacket) {
               var20 = var3.readUnsignedByte();
               StructComposition.setOculusOrbState(var20);
               var1.serverPacket = null;
               return true;
            }

            String var46;
            if (ServerPacket.MESSAGE_PRIVATE == var1.serverPacket) {
               var52 = var3.readStringCp1252NullTerminated();
               var26 = (long)var3.readUnsignedShort();
               var28 = (long)var3.readMedium();
               PlayerType var43 = (PlayerType)SpriteMask.findEnumerated(MoveSpeed.PlayerType_values(), var3.readUnsignedByte());
               long var44 = var28 + (var26 << 32);
               boolean var64 = false;

               for(var13 = 0; var13 < 100; ++var13) {
                  if (var44 == crossWorldMessageIds[var13]) {
                     var64 = true;
                     break;
                  }
               }

               if (class6.friendSystem.isIgnored(new Username(var52, Occluder.loginType))) {
                  var64 = true;
               }

               if (!var64 && field540 == 0) {
                  crossWorldMessageIds[crossWorldMessageIdsIndex] = var44;
                  crossWorldMessageIdsIndex = (crossWorldMessageIdsIndex + 1) % 100;
                  var46 = AbstractFont.escapeBrackets(class33.method136(class279.readString(var3)));
                  byte var68;
                  if (var43.isPrivileged) {
                     var68 = 7;
                  } else {
                     var68 = 3;
                  }

                  if (var43.modIcon != -1) {
                     MusicPatchNode.addGameMessage(var68, class7.addImageTag(var43.modIcon) + var52, var46);
                  } else {
                     MusicPatchNode.addGameMessage(var68, var52, var46);
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.CHAT_FILTER_SETTINGS == var1.serverPacket) {
               publicChatMode = var3.readUnsignedByteAdd();
               tradeChatMode = var3.readUnsignedByte();
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.TRIGGER_ONDIALOGABORT == var1.serverPacket) {
               if (rootInterface != -1) {
                  NPCComposition.runIntfCloseListeners(rootInterface, 0);
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.PLAYER_INFO == var1.serverPacket) {
               WorldMapSprite.updatePlayers(var3, var1.serverPacketLength);
               class462.method2351();
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.SYNTH_SOUND == var1.serverPacket) {
               var20 = var3.readUnsignedShort();
               var5 = var3.readUnsignedByte();
               var21 = var3.readUnsignedShort();
               Skills.queueSoundEffect(var20, var5, var21);
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.NPC_INFO_LARGE == var1.serverPacket) {
               class148.updateNpcs(true, var3);
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.IF_SETEVENTS == var1.serverPacket) {
               var20 = var3.readInt();
               var5 = var3.readIntLE();
               var21 = var3.readUnsignedShortAdd();
               if (var21 == 65535) {
                  var21 = -1;
               }

               var22 = var3.readUnsignedShortAddLE();
               if (var22 == 65535) {
                  var22 = -1;
               }

               for(var8 = var21; var8 <= var22; ++var8) {
                  var30 = ((long)var20 << 32) + (long)var8;
                  Node var32 = widgetFlags.get(var30);
                  if (var32 != null) {
                     var32.remove();
                  }

                  widgetFlags.put(new IntegerNode(var5), var30);
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.UPDATE_ZONE_PARTIAL_FOLLOWS == var1.serverPacket) {
               class149.ZONE_Y = var3._readUnsignedByteSub();
               ZoneOperation.Zone_X = var3._readUnsignedByteSub();
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.UPDATE_UID192 == var1.serverPacket) {
               var3.offset += 28;
               if (var3.checkCrc()) {
                  class17.method66(var3, var3.offset - 28);
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.UPDATE_INV_PARTIAL == var1.serverPacket) {
               var20 = var3.readInt();
               var5 = var3.readUnsignedShort();
               if (var20 < -70000) {
                  var5 += 32768;
               }

               if (var20 >= 0) {
                  var6 = WorldMapSection1.getWidget(var20);
               } else {
                  var6 = null;
               }

               for(; var3.offset < var1.serverPacketLength; UserComparator3.itemContainerSetItem(var5, var22, var8 - 1, var9)) {
                  var22 = var3.readUShortSmart();
                  var8 = var3.readUnsignedShort();
                  var9 = 0;
                  if (var8 != 0) {
                     var9 = var3.readUnsignedByte();
                     if (var9 == 255) {
                        var9 = var3.readInt();
                     }
                  }

                  if (var6 != null && var22 >= 0 && var22 < var6.itemIds.length) {
                     var6.itemIds[var22] = var8;
                     var6.field2963[var22] = var9;
                  }
               }

               if (var6 != null) {
                  class69.invalidateWidget(var6);
               }

               GrandExchangeOfferNameComparator.process();
               changedItemContainers[++changedItemContainersCount - 1 & 31] = var5 & 32767;
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.UPDATE_INV_CLEAR == var1.serverPacket) {
               var20 = var3.readIntME();
               var80 = WorldMapSection1.getWidget(var20);

               for(var21 = 0; var21 < var80.itemIds.length; ++var21) {
                  var80.itemIds[var21] = -1;
                  var80.itemIds[var21] = 0;
               }

               class69.invalidateWidget(var80);
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2617 == var1.serverPacket) {
               class150.processZoneOperation(ZoneOperation.field2518);
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.MESSAGE_CLANCHANNEL_SYSTEM == var1.serverPacket) {
               var84 = var3.readByte();
               var26 = (long)var3.readUnsignedShort();
               var28 = (long)var3.readMedium();
               var30 = var28 + (var26 << 32);
               boolean var65 = false;
               ClanChannel var95 = var84 >= 0 ? currentClanChannels[var84] : class19.guestClanChannel;
               if (var95 == null) {
                  var65 = true;
               } else {
                  for(var13 = 0; var13 < 100; ++var13) {
                     if (crossWorldMessageIds[var13] == var30) {
                        var65 = true;
                        break;
                     }
                  }
               }

               if (!var65) {
                  crossWorldMessageIds[crossWorldMessageIdsIndex] = var30;
                  crossWorldMessageIdsIndex = (crossWorldMessageIdsIndex + 1) % 100;
                  var46 = class279.readString(var3);
                  var14 = var84 >= 0 ? 43 : 46;
                  class12.addChatMessage(var14, "", var46, var95.name);
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2542 == var1.serverPacket) {
               class150.processZoneOperation(ZoneOperation.field2525);
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2554 == var1.serverPacket) {
               return this.method361(var1, 1);
            }

            if (ServerPacket.IF_SETANIM == var1.serverPacket) {
               var20 = var3.readIntIME();
               var5 = var3.readSignedShortAdd();
               var6 = WorldMapSection1.getWidget(var20);
               if (var5 != var6.sequenceId || var5 == -1) {
                  var6.sequenceId = var5;
                  var6.modelFrame = 0;
                  var6.modelFrameCycle = 0;
                  class69.invalidateWidget(var6);
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2624 == var1.serverPacket) {
               class150.processZoneOperation(ZoneOperation.field2523);
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.REFLECTION_CHECK == var1.serverPacket) {
               class154.readReflectionCheck(var3, var1.serverPacketLength);
               var1.serverPacket = null;
               return true;
            }

            Widget var7;
            if (ServerPacket.IF_SETOBJECT == var1.serverPacket) {
               var20 = var3.readIntME();
               var5 = var3.readIntIME();
               var21 = var3.readUnsignedShort();
               if (var21 == 65535) {
                  var21 = -1;
               }

               var7 = WorldMapSection1.getWidget(var20);
               ItemComposition var25;
               if (!var7.isIf3) {
                  if (var21 == -1) {
                     var7.modelType = 0;
                     var1.serverPacket = null;
                     return true;
                  }

                  var25 = ParamComposition.ItemDefinition_get(var21);
                  var7.modelType = 4;
                  var7.modelId = var21;
                  var7.modelAngleX = var25.xan2d;
                  var7.modelAngleY = var25.yan2d;
                  var7.modelZoom = var25.zoom2d * 100 / var5;
                  class69.invalidateWidget(var7);
               } else {
                  var7.itemId = var21;
                  var7.itemQuantity = var5;
                  var25 = ParamComposition.ItemDefinition_get(var21);
                  var7.modelAngleX = var25.xan2d;
                  var7.modelAngleY = var25.yan2d;
                  var7.modelAngleZ = var25.zan2d;
                  var7.modelOffsetX = var25.offsetX2d;
                  var7.modelOffsetY = var25.offsetY2d;
                  var7.modelZoom = var25.zoom2d;
                  if (var25.isStackable == 1) {
                     var7.itemQuantityMode = 1;
                  } else {
                     var7.itemQuantityMode = 2;
                  }

                  if (var7.modelRotation > 0) {
                     var7.modelZoom = var7.modelZoom * 32 / var7.modelRotation;
                  } else if (var7.rawWidth > 0) {
                     var7.modelZoom = var7.modelZoom * 32 / var7.rawWidth;
                  }

                  class69.invalidateWidget(var7);
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.TRADING_POST_RESULTS == var1.serverPacket) {
               var73 = var3.readUnsignedByte() == 1;
               if (var73) {
                  GrandExchangeOfferWorldComparator.field3473 = WorldMapSection2.clockNow() - var3.readLong();
                  Projectile.grandExchangeEvents = new GrandExchangeEvents(var3, true);
               } else {
                  Projectile.grandExchangeEvents = null;
               }

               field558 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.SPOTANIM_SPECIFIC == var1.serverPacket) {
               var10 = var3.readUnsignedByte();
               var11 = var3.readUnsignedShortLE();
               var21 = var3.readMedium();
               var20 = var21 >> 16;
               var5 = var21 >> 8 & 255;
               var22 = var20 + (var21 >> 4 & 7);
               var8 = var5 + (var21 & 7);
               var9 = var3.readUnsignedShortLE();
               if (var22 >= 0 && var8 >= 0 && var22 < 104 && var8 < 104) {
                  var22 = var22 * 128 + 64;
                  var8 = var8 * 128 + 64;
                  GraphicsObject var47 = new GraphicsObject(var9, TaskHandler.Client_plane, var22, var8, WorldMapDecorationType.getTileHeight(var22, var8, TaskHandler.Client_plane) - var10, var11, cycle);
                  graphicsObjects.addFirst(var47);
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.IF_SETNPCHEAD == var1.serverPacket) {
               var20 = var3.readUnsignedShortAddLE();
               var5 = var3.readIntME();
               var6 = WorldMapSection1.getWidget(var5);
               if (var6.modelType != 2 || var20 != var6.modelId) {
                  var6.modelType = 2;
                  var6.modelId = var20;
                  class69.invalidateWidget(var6);
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.IF_OPENSUB == var1.serverPacket) {
               var20 = var3.readUnsignedByteNeg();
               var5 = var3.readInt();
               var21 = var3.readUnsignedShortLE();
               var56 = (InterfaceParent)interfaceParents.get((long)var5);
               if (var56 != null) {
                  class17.closeInterface(var56, var21 != var56.group);
               }

               DynamicObject.ifOpenSub(var5, var21, var20);
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.CLANCHANNEL_DELTA == var1.serverPacket) {
               field357 = cycleCntr;
               var84 = var3.readByte();
               class157 var78 = new class157(var3);
               ClanChannel var55;
               if (var84 >= 0) {
                  var55 = currentClanChannels[var84];
               } else {
                  var55 = class19.guestClanChannel;
               }

               var78.method831(var55);
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2618 == var1.serverPacket) {
               var20 = var3.readUnsignedShortLE();
               if (var20 == 65535) {
                  var20 = -1;
               }

               Language.playSong(var20);
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2550 == var1.serverPacket) {
               var20 = var3.readMedium();
               var5 = var3.readUnsignedShortLE();
               if (var5 == 65535) {
                  var5 = -1;
               }

               class19.playJingle(var5, var20);
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2609 == var1.serverPacket) {
               ZoneOperation.Zone_X = var3.readUnsignedByteNeg();
               class149.ZONE_Y = var3.readUnsignedByte();

               while(var3.offset < var1.serverPacketLength) {
                  var20 = var3.readUnsignedByte();
                  ZoneOperation var77 = class208.method1097()[var20];
                  class150.processZoneOperation(var77);
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2630 == var1.serverPacket) {
               var52 = var3.readStringCp1252NullTerminated();
               Object[] var75 = new Object[var52.length() + 1];

               for(var21 = var52.length() - 1; var21 >= 0; --var21) {
                  if (var52.charAt(var21) == 's') {
                     var75[var21 + 1] = var3.readStringCp1252NullTerminated();
                  } else {
                     var75[var21 + 1] = new Integer(var3.readInt());
                  }
               }

               var75[0] = new Integer(var3.readInt());
               ScriptEvent var54 = new ScriptEvent();
               var54.args = var75;
               class9.runScriptEvent(var54);
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2559 == var1.serverPacket) {
               var20 = var3.readUnsignedShortAdd();
               Player var58;
               if (var20 == localPlayerIndex) {
                  var58 = BuddyRankComparator.localPlayer;
               } else {
                  var58 = players[var20];
               }

               var5 = var3.readUnsignedShort();
               var21 = var3.readIntLE();
               if (var58 != null) {
                  var58.spotAnimation = var5;
                  var58.spotAnimHeight = var21 >> 16;
                  var58.spotAnimationStartCycle = (var21 & '\uffff') + cycle;
                  var58.spotAnimationFrame = 0;
                  var58.field964 = 0;
                  if (var58.spotAnimationStartCycle > cycle) {
                     var58.spotAnimationFrame = -1;
                  }

                  if (var58.spotAnimation == 65535) {
                     var58.spotAnimation = -1;
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2551 == var1.serverPacket) {
               return this.method361(var1, 2);
            }

            if (ServerPacket.RESET_ANIMS == var1.serverPacket) {
               for(var20 = 0; var20 < players.length; ++var20) {
                  if (players[var20] != null) {
                     players[var20].sequence = -1;
                  }
               }

               for(var20 = 0; var20 < npcs.length; ++var20) {
                  if (npcs[var20] != null) {
                     npcs[var20].sequence = -1;
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.UPDATE_INV_FULL == var1.serverPacket) {
               var20 = var3.readInt();
               var5 = var3.readUnsignedShort();
               if (var20 < -70000) {
                  var5 += 32768;
               }

               if (var20 >= 0) {
                  var6 = WorldMapSection1.getWidget(var20);
               } else {
                  var6 = null;
               }

               if (var6 != null) {
                  for(var22 = 0; var22 < var6.itemIds.length; ++var22) {
                     var6.itemIds[var22] = 0;
                     var6.field2963[var22] = 0;
                  }
               }

               TileItem.clearItemContainer(var5);
               var22 = var3.readUnsignedShort();

               for(var8 = 0; var8 < var22; ++var8) {
                  var9 = var3.readUnsignedByte();
                  if (var9 == 255) {
                     var9 = var3.readIntLE();
                  }

                  var10 = var3.readUnsignedShortLE();
                  if (var6 != null && var8 < var6.itemIds.length) {
                     var6.itemIds[var8] = var10;
                     var6.field2963[var8] = var9;
                  }

                  UserComparator3.itemContainerSetItem(var5, var8, var10 - 1, var9);
               }

               if (var6 != null) {
                  class69.invalidateWidget(var6);
               }

               GrandExchangeOfferNameComparator.process();
               changedItemContainers[++changedItemContainersCount - 1 & 31] = var5 & 32767;
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2586 == var1.serverPacket) {
               class150.processZoneOperation(ZoneOperation.field2527);
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2545 == var1.serverPacket) {
               var13 = var3.readUnsignedShortAddLE();
               var9 = var3.readUnsignedByte();
               var10 = var9 >> 2;
               var11 = var9 & 3;
               var12 = OBJECT_TYPE_TO_STUB_TYPE[var10];
               var21 = var3.readMediumUnsigned_1();
               var20 = var21 >> 16;
               var5 = var21 >> 8 & 255;
               var22 = var20 + (var21 >> 4 & 7);
               var8 = var5 + (var21 & 7);
               if (var22 >= 0 && var8 >= 0 && var22 < 103 && var8 < 103) {
                  if (var12 == 0) {
                     BoundaryObject var93 = class1.scene.method1203(TaskHandler.Client_plane, var22, var8);
                     if (var93 != null) {
                        var15 = class279.Entity_unpackID(var93.tag);
                        if (var10 == 2) {
                           var93.renderable1 = new DynamicObject(var15, 2, var11 + 4, TaskHandler.Client_plane, var22, var8, var13, false, var93.renderable1);
                           var93.renderable2 = new DynamicObject(var15, 2, var11 + 1 & 3, TaskHandler.Client_plane, var22, var8, var13, false, var93.renderable2);
                        } else {
                           var93.renderable1 = new DynamicObject(var15, var10, var11, TaskHandler.Client_plane, var22, var8, var13, false, var93.renderable1);
                        }
                     }
                  } else if (var12 == 1) {
                     WallDecoration var92 = class1.scene.method1204(TaskHandler.Client_plane, var22, var8);
                     if (var92 != null) {
                        var15 = class279.Entity_unpackID(var92.tag);
                        if (var10 != 4 && var10 != 5) {
                           if (var10 == 6) {
                              var92.renderable1 = new DynamicObject(var15, 4, var11 + 4, TaskHandler.Client_plane, var22, var8, var13, false, var92.renderable1);
                           } else if (var10 == 7) {
                              var92.renderable1 = new DynamicObject(var15, 4, (var11 + 2 & 3) + 4, TaskHandler.Client_plane, var22, var8, var13, false, var92.renderable1);
                           } else if (var10 == 8) {
                              var92.renderable1 = new DynamicObject(var15, 4, var11 + 4, TaskHandler.Client_plane, var22, var8, var13, false, var92.renderable1);
                              var92.renderable2 = new DynamicObject(var15, 4, (var11 + 2 & 3) + 4, TaskHandler.Client_plane, var22, var8, var13, false, var92.renderable2);
                           }
                        } else {
                           var92.renderable1 = new DynamicObject(var15, 4, var11, TaskHandler.Client_plane, var22, var8, var13, false, var92.renderable1);
                        }
                     }
                  } else if (var12 == 2) {
                     var42 = class1.scene.getGameObject(TaskHandler.Client_plane, var22, var8);
                     if (var10 == 11) {
                        var10 = 10;
                     }

                     if (var42 != null) {
                        var42.renderable = new DynamicObject(class279.Entity_unpackID(var42.tag), var10, var11, TaskHandler.Client_plane, var22, var8, var13, false, var42.renderable);
                     }
                  } else if (var12 == 3) {
                     FloorDecoration var91 = class1.scene.getFloorDecoration(TaskHandler.Client_plane, var22, var8);
                     if (var91 != null) {
                        var91.renderable = new DynamicObject(class279.Entity_unpackID(var91.tag), 22, var11, TaskHandler.Client_plane, var22, var8, var13, false, var91.renderable);
                     }
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.REBUILD_REGION == var1.serverPacket) {
               Skeleton.loadRegions(true, var1.packetBuffer);
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.HEAT_MAP == var1.serverPacket) {
               var73 = var3.readBoolean();
               if (var73) {
                  if (Language.field3504 == null) {
                     Language.field3504 = new class350();
                  }
               } else {
                  Language.field3504 = null;
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.UPDATE_RUNENERGY == var1.serverPacket) {
               GrandExchangeOfferNameComparator.process();
               runEnergy = var3.readUnsignedShort();
               field559 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.IF_SETTEXT == var1.serverPacket) {
               var52 = var3.readStringCp1252NullTerminated();
               var5 = var3.readIntME();
               var6 = WorldMapSection1.getWidget(var5);
               if (!var52.equals(var6.text)) {
                  var6.text = var52;
                  class69.invalidateWidget(var6);
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.GAMEFRAME_FULL == var1.serverPacket) {
               var20 = var3.offset + var1.serverPacketLength;
               var5 = var3.readUnsignedShort();
               var21 = var3.readUnsignedShort();
               if (var5 != rootInterface) {
                  rootInterface = var5;
                  this.resizeRoot(false);
                  ApproximateRouteStrategy.Widget_resetModelFrames(rootInterface);
                  WorldMapSection1.runWidgetOnLoadListener(rootInterface);

                  for(var22 = 0; var22 < 100; ++var22) {
                     field594[var22] = true;
                  }
               }

               InterfaceParent var23;
               for(; var21-- > 0; var23.field845 = true) {
                  var22 = var3.readInt();
                  var8 = var3.readUnsignedShort();
                  var9 = var3.readUnsignedByte();
                  var23 = (InterfaceParent)interfaceParents.get((long)var22);
                  if (var23 != null && var8 != var23.group) {
                     class17.closeInterface(var23, true);
                     var23 = null;
                  }

                  if (var23 == null) {
                     var23 = DynamicObject.ifOpenSub(var22, var8, var9);
                  }
               }

               for(var56 = (InterfaceParent)interfaceParents.first(); var56 != null; var56 = (InterfaceParent)interfaceParents.next()) {
                  if (var56.field845) {
                     var56.field845 = false;
                  } else {
                     class17.closeInterface(var56, true);
                  }
               }

               widgetFlags = new NodeHashTable(512);

               while(var3.offset < var20) {
                  var22 = var3.readInt();
                  var8 = var3.readUnsignedShort();
                  var9 = var3.readUnsignedShort();
                  var10 = var3.readInt();

                  for(var11 = var8; var11 <= var9; ++var11) {
                     var33 = (long)var11 + ((long)var22 << 32);
                     widgetFlags.put(new IntegerNode(var10), var33);
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2576 == var1.serverPacket) {
               class150.processZoneOperation(ZoneOperation.field2522);
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.IF_SETPOSITION == var1.serverPacket) {
               var20 = var3.readIntLE();
               var5 = var3.readSignedShortAddLE();
               var21 = var3.readShort();
               var7 = WorldMapSection1.getWidget(var20);
               if (var5 != var7.rawX || var21 != var7.rawY || var7.xAlignment != 0 || var7.yAlignment != 0) {
                  var7.rawX = var5;
                  var7.rawY = var21;
                  var7.xAlignment = 0;
                  var7.yAlignment = 0;
                  class69.invalidateWidget(var7);
                  this.alignWidget(var7);
                  if (var7.type == 0) {
                     class278.revalidateWidgetScroll(class155.Widget_interfaceComponents[var20 >> 16], var7, false);
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2595 == var1.serverPacket) {
               class188.varclan = new class425(Messages.HitSplatDefinition_cached);
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2565 == var1.serverPacket) {
               class150.processZoneOperation(ZoneOperation.field2521);
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.LOGOUT_TRANSFER == var1.serverPacket) {
               World var51 = new World();
               var51.host = var3.readStringCp1252NullTerminated();
               var51.id = var3.readUnsignedShort();
               var5 = var3.readInt();
               var51.properties = var5;
               class19.updateGameState(45);
               var2.close();
               var2 = null;
               VarbitComposition.changeWorld(var51);
               var1.serverPacket = null;
               return false;
            }

            if (ServerPacket.CAM_LOOKAT == var1.serverPacket) {
               isCameraLocked = true;
               field609 = false;
               class167.cameraLookAtX = var3.readUnsignedByte();
               Canvas.cameraLookAtY = var3.readUnsignedByte();
               MidiPcmStream.cameraLookAtHeight = var3.readUnsignedShort();
               GrandExchangeOfferUnitPriceComparator.cameraLookAtSpeed = var3.readUnsignedByte();
               Skeleton.cameraLookAtAcceleration = var3.readUnsignedByte();
               if (Skeleton.cameraLookAtAcceleration >= 100) {
                  var20 = class167.cameraLookAtX * 128 + 64;
                  var5 = Canvas.cameraLookAtY * 128 + 64;
                  var21 = WorldMapDecorationType.getTileHeight(var20, var5, TaskHandler.Client_plane) - MidiPcmStream.cameraLookAtHeight;
                  var22 = var20 - class381.cameraX;
                  var8 = var21 - class351.cameraY;
                  var9 = var5 - class471.cameraZ;
                  var10 = (int)Math.sqrt((double)(var9 * var9 + var22 * var22));
                  class311.cameraPitch = (int)(Math.atan2((double)var8, (double)var10) * 325.9490051269531D) & 2047;
                  class110.cameraYaw = (int)(Math.atan2((double)var22, (double)var9) * -325.9490051269531D) & 2047;
                  if (class311.cameraPitch < 128) {
                     class311.cameraPitch = 128;
                  }

                  if (class311.cameraPitch > 383) {
                     class311.cameraPitch = 383;
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2632 == var1.serverPacket) {
               class150.processZoneOperation(ZoneOperation.field2519);
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2564 == var1.serverPacket) {
               ZoneOperation.Zone_X = var3.readUnsignedByteNeg();
               class149.ZONE_Y = var3.readUnsignedByte();

               for(var20 = ZoneOperation.Zone_X; var20 < ZoneOperation.Zone_X + 8; ++var20) {
                  for(var5 = class149.ZONE_Y; var5 < class149.ZONE_Y + 8; ++var5) {
                     if (groundItems[TaskHandler.Client_plane][var20][var5] != null) {
                        groundItems[TaskHandler.Client_plane][var20][var5] = null;
                        class148.updateItemPile(var20, var5);
                     }
                  }
               }

               for(PendingSpawn var50 = (PendingSpawn)pendingSpawns.last(); var50 != null; var50 = (PendingSpawn)pendingSpawns.previous()) {
                  if (var50.x >= ZoneOperation.Zone_X && var50.x < ZoneOperation.Zone_X + 8 && var50.y >= class149.ZONE_Y && var50.y < class149.ZONE_Y + 8 && var50.plane == TaskHandler.Client_plane) {
                     var50.endCycle = 0;
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2567 == var1.serverPacket) {
               var20 = var3.readUnsignedShortLE();
               var5 = var3.readUnsignedShortAdd();
               var21 = var3.readInt();
               var7 = WorldMapSection1.getWidget(var21);
               var7.rotationKey = var20 + (var5 << 16);
               var1.serverPacket = null;
               return true;
            }

            class364.RunException_sendStackTrace("" + (var1.serverPacket != null ? var1.serverPacket.id * 428235613 * -453259019 : -1) + "," + (var1.field1130 != null ? var1.field1130.id * 428235613 * -453259019 : -1) + "," + (var1.field1131 != null ? var1.field1131.id * 428235613 * -453259019 : -1) + "," + var1.serverPacketLength, (Throwable)null);
            class278.logOut();
         } catch (IOException var48) {
            PendingSpawn.method501();
         } catch (Exception var49) {
            var24 = "" + (var1.serverPacket != null ? var1.serverPacket.id * 428235613 * -453259019 : -1) + "," + (var1.field1130 != null ? var1.field1130.id * 428235613 * -453259019 : -1) + "," + (var1.field1131 != null ? var1.field1131.id * 428235613 * -453259019 : -1) + "," + var1.serverPacketLength + "," + (BuddyRankComparator.localPlayer.pathX[0] + GameEngine.baseX) + "," + (BuddyRankComparator.localPlayer.pathY[0] + class178.baseY) + ",";

            for(var21 = 0; var21 < var1.serverPacketLength && var21 < 50; ++var21) {
               var24 = var24 + var3.array[var21] + ",";
            }

            class364.RunException_sendStackTrace(var24, var49);
            class278.logOut();
         }

         return true;
      }
   }

   @ObfuscatedName("ji")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "-88"
   )
   @Export("menu")
   final void menu() {
      boolean var1 = false;

      int var2;
      int var5;
      while(!var1) {
         var1 = true;

         for(var2 = 0; var2 < menuOptionsCount - 1; ++var2) {
            if (menuOpcodes[var2] < 1000 && menuOpcodes[var2 + 1] > 1000) {
               String var3 = menuTargets[var2];
               menuTargets[var2] = menuTargets[var2 + 1];
               menuTargets[var2 + 1] = var3;
               String var4 = menuActions[var2];
               menuActions[var2] = menuActions[var2 + 1];
               menuActions[var2 + 1] = var4;
               var5 = menuOpcodes[var2];
               menuOpcodes[var2] = menuOpcodes[var2 + 1];
               menuOpcodes[var2 + 1] = var5;
               var5 = menuArguments1[var2];
               menuArguments1[var2] = menuArguments1[var2 + 1];
               menuArguments1[var2 + 1] = var5;
               var5 = menuArguments2[var2];
               menuArguments2[var2] = menuArguments2[var2 + 1];
               menuArguments2[var2 + 1] = var5;
               var5 = menuIdentifiers[var2];
               menuIdentifiers[var2] = menuIdentifiers[var2 + 1];
               menuIdentifiers[var2 + 1] = var5;
               var5 = menuItemIds[var2];
               menuItemIds[var2] = menuItemIds[var2 + 1];
               menuItemIds[var2 + 1] = var5;
               boolean var6 = menuShiftClick[var2];
               menuShiftClick[var2] = menuShiftClick[var2 + 1];
               menuShiftClick[var2 + 1] = var6;
               var1 = false;
            }
         }
      }

      if (clickedWidget == null) {
         int var12 = MouseHandler.MouseHandler_lastButton;
         if (isMenuOpen) {
            int var10;
            if (var12 != 1 && (class319.mouseCam || var12 != 4)) {
               var2 = MouseHandler.MouseHandler_x;
               var10 = MouseHandler.MouseHandler_y;
               if (var2 < class20.menuX - 10 || var2 > PacketWriter.menuWidth + class20.menuX + 10 || var10 < Login.menuY - 10 || var10 > class30.menuHeight + Login.menuY + 10) {
                  isMenuOpen = false;
                  class167.method886(class20.menuX, Login.menuY, PacketWriter.menuWidth, class30.menuHeight);
               }
            }

            if (var12 == 1 || !class319.mouseCam && var12 == 4) {
               var2 = class20.menuX;
               var10 = Login.menuY;
               int var11 = PacketWriter.menuWidth;
               var5 = MouseHandler.MouseHandler_lastPressedX;
               int var13 = MouseHandler.MouseHandler_lastPressedY;
               int var7 = -1;

               for(int var8 = 0; var8 < menuOptionsCount; ++var8) {
                  int var9 = var10 + (menuOptionsCount - 1 - var8) * 15 + 31;
                  if (var5 > var2 && var5 < var2 + var11 && var13 > var9 - 13 && var13 < var9 + 3) {
                     var7 = var8;
                  }
               }

               if (var7 != -1) {
                  ScriptFrame.method323(var7);
               }

               isMenuOpen = false;
               class167.method886(class20.menuX, Login.menuY, PacketWriter.menuWidth, class30.menuHeight);
            }
         } else {
            var2 = menuOptionsCount - 1;
            if ((var12 == 1 || !class319.mouseCam && var12 == 4) && this.shouldLeftClickOpenMenu()) {
               var12 = 2;
            }

            if ((var12 == 1 || !class319.mouseCam && var12 == 4) && menuOptionsCount > 0) {
               ScriptFrame.method323(var2);
            }

            if (var12 == 2 && menuOptionsCount > 0) {
               this.openMenu(MouseHandler.MouseHandler_lastPressedX, MouseHandler.MouseHandler_lastPressedY);
            }
         }

      }
   }

   @ObfuscatedName("jn")
   @ObfuscatedSignature(
      descriptor = "(I)Z",
      garbageValue = "-1492880114"
   )
   @Export("shouldLeftClickOpenMenu")
   final boolean shouldLeftClickOpenMenu() {
      int var1 = menuOptionsCount - 1;
      return (leftClickOpensMenu && menuOptionsCount > 2 || WorldMapData_0.method1310(var1)) && !menuShiftClick[var1];
   }

   @ObfuscatedName("jb")
   @ObfuscatedSignature(
      descriptor = "(III)V",
      garbageValue = "1260391802"
   )
   @Export("openMenu")
   final void openMenu(int var1, int var2) {
      class383.method2033(var1, var2);
      var1 -= viewportOffsetX;
      var2 -= viewportOffsetY;
      class1.scene.menuOpen(TaskHandler.Client_plane, var1, var2, false);
      isMenuOpen = true;
   }

   @ObfuscatedName("kl")
   @ObfuscatedSignature(
      descriptor = "(ZI)V",
      garbageValue = "-849310357"
   )
   @Export("resizeRoot")
   final void resizeRoot(boolean var1) {
      int var2 = rootInterface;
      int var3 = GameEngine.canvasWidth;
      int var4 = class143.canvasHeight;
      if (GrandExchangeEvent.loadInterface(var2)) {
         Script.resizeInterface(class155.Widget_interfaceComponents[var2], -1, var3, var4, var1);
      }

   }

   @ObfuscatedName("kb")
   @ObfuscatedSignature(
      descriptor = "(Lmy;I)V",
      garbageValue = "1931780261"
   )
   @Export("alignWidget")
   void alignWidget(Widget var1) {
      Widget var2 = var1.parentId == -1 ? null : WorldMapSection1.getWidget(var1.parentId);
      int var3;
      int var4;
      if (var2 == null) {
         var3 = GameEngine.canvasWidth;
         var4 = class143.canvasHeight;
      } else {
         var3 = var2.width;
         var4 = var2.height;
      }

      PcmPlayer.alignWidgetSize(var1, var3, var4, false);
      Tiles.alignWidgetPosition(var1, var3, var4);
   }

   @ObfuscatedName("lw")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "109"
   )
   final void method367() {
      class69.invalidateWidget(clickedWidget);
      ++class371.widgetDragDuration;
      int var1;
      int var2;
      if (field643 && field536) {
         var1 = MouseHandler.MouseHandler_x;
         var2 = MouseHandler.MouseHandler_y;
         var1 -= widgetClickX;
         var2 -= widgetClickY;
         if (var1 < field537) {
            var1 = field537;
         }

         if (var1 + clickedWidget.width > field537 + clickedWidgetParent.width) {
            var1 = field537 + clickedWidgetParent.width - clickedWidget.width;
         }

         if (var2 < field470) {
            var2 = field470;
         }

         if (var2 + clickedWidget.height > field470 + clickedWidgetParent.height) {
            var2 = field470 + clickedWidgetParent.height - clickedWidget.height;
         }

         int var3 = var1 - field445;
         int var4 = var2 - field541;
         int var5 = clickedWidget.dragZoneSize;
         if (class371.widgetDragDuration > clickedWidget.dragThreshold && (var3 > var5 || var3 < -var5 || var4 > var5 || var4 < -var5)) {
            isDraggingWidget = true;
         }

         int var6 = var1 - field537 + clickedWidgetParent.scrollX;
         int var7 = var2 - field470 + clickedWidgetParent.scrollY;
         ScriptEvent var8;
         if (clickedWidget.onDrag != null && isDraggingWidget) {
            var8 = new ScriptEvent();
            var8.widget = clickedWidget;
            var8.mouseX = var6;
            var8.mouseY = var7;
            var8.args = clickedWidget.onDrag;
            class9.runScriptEvent(var8);
         }

         if (MouseHandler.MouseHandler_currentButton == 0) {
            if (isDraggingWidget) {
               if (clickedWidget.onDragComplete != null) {
                  var8 = new ScriptEvent();
                  var8.widget = clickedWidget;
                  var8.mouseX = var6;
                  var8.mouseY = var7;
                  var8.dragTarget = draggedOnWidget;
                  var8.args = clickedWidget.onDragComplete;
                  class9.runScriptEvent(var8);
               }

               if (draggedOnWidget != null && class287.method1549(clickedWidget) != null) {
                  PacketBufferNode var11 = UserComparator9.getPacketBufferNode(ClientPacket.field2473, packetWriter.isaacCipher);
                  var11.packetBuffer.writeIntLE(draggedOnWidget.id);
                  var11.packetBuffer.writeShortAdd(clickedWidget.itemId);
                  var11.packetBuffer.writeIntLE(clickedWidget.id);
                  var11.packetBuffer.writeShortAddLE(draggedOnWidget.childIndex);
                  var11.packetBuffer.writeShortAddLE(draggedOnWidget.itemId);
                  var11.packetBuffer.writeShortLE(clickedWidget.childIndex);
                  packetWriter.addNode(var11);
               }
            } else if (this.shouldLeftClickOpenMenu()) {
               this.openMenu(field445 + widgetClickX, widgetClickY + field541);
            } else if (menuOptionsCount > 0) {
               int var10 = widgetClickX + field445;
               int var9 = widgetClickY + field541;
               UserComparator7.method654(ViewportMouse.tempMenuAction, var10, var9);
               ViewportMouse.tempMenuAction = null;
            }

            clickedWidget = null;
         }

      } else {
         if (class371.widgetDragDuration > 1) {
            if (!isDraggingWidget && menuOptionsCount > 0) {
               var1 = widgetClickX + field445;
               var2 = widgetClickY + field541;
               UserComparator7.method654(ViewportMouse.tempMenuAction, var1, var2);
               ViewportMouse.tempMenuAction = null;
            }

            clickedWidget = null;
         }

      }
   }

   @ObfuscatedName("nr")
   @ObfuscatedSignature(
      descriptor = "(B)Ltj;",
      garbageValue = "-45"
   )
   @Export("username")
   public Username username() {
      return BuddyRankComparator.localPlayer != null ? BuddyRankComparator.localPlayer.username : null;
   }

   @Export("init")
   @ObfuscatedName("init")
   public final void init() {
      if (this.checkHost()) {
         for(int var1 = 0; var1 <= 28; ++var1) {
            String var2 = this.getParameter(Integer.toString(var1));
            if (var2 != null) {
               switch(var1) {
               case 3:
                  if (var2.equalsIgnoreCase("true")) {
                     isMembersWorld = true;
                  } else {
                     isMembersWorld = false;
                  }
                  break;
               case 4:
                  if (clientType == -1) {
                     clientType = Integer.parseInt(var2);
                  }
                  break;
               case 5:
                  worldProperties = Integer.parseInt(var2);
                  break;
               case 6:
                  int var4 = Integer.parseInt(var2);
                  Language var3;
                  if (var4 >= 0 && var4 < Language.field3498.length) {
                     var3 = Language.field3498[var4];
                  } else {
                     var3 = null;
                  }

                  class69.clientLanguage = var3;
                  break;
               case 7:
                  class326.field3033 = class162.method851(Integer.parseInt(var2));
                  break;
               case 8:
                  if (var2.equalsIgnoreCase("true")) {
                     ;
                  }
                  break;
               case 9:
                  FontName.param9 = var2;
                  break;
               case 10:
                  DbTableType.field3951 = (StudioGame)SpriteMask.findEnumerated(SecureRandomFuture.method439(), Integer.parseInt(var2));
                  if (StudioGame.oldscape == DbTableType.field3951) {
                     Occluder.loginType = LoginType.oldscape;
                  } else {
                     Occluder.loginType = LoginType.field3913;
                  }
                  break;
               case 11:
                  MoveSpeed.field1841 = var2;
                  break;
               case 12:
                  worldId = Integer.parseInt(var2);
               case 13:
               case 16:
               case 18:
               case 19:
               case 20:
               case 22:
               case 23:
               case 24:
               default:
                  break;
               case 14:
                  RouteStrategy.field1837 = Integer.parseInt(var2);
                  break;
               case 15:
                  gameBuild = Integer.parseInt(var2);
                  break;
               case 17:
                  class199.field1632 = var2;
                  break;
               case 21:
                  param21 = Integer.parseInt(var2);
                  break;
               case 25:
                  int var5 = var2.indexOf(".");
                  if (var5 == -1) {
                     param25 = Integer.parseInt(var2);
                  } else {
                     param25 = Integer.parseInt(var2.substring(0, var5));
                     Integer.parseInt(var2.substring(var5 + 1));
                  }
               }
            }
         }

         Scene.Scene_isLowDetail = false;
         isLowDetail = false;
         class188.worldHost = this.getCodeBase().getHost();
         String var6 = class326.field3033.name;
         byte var7 = 0;

         try {
            class87.method475("oldschool", var6, var7, 22);
         } catch (Exception var8) {
            class364.RunException_sendStackTrace((String)null, var8);
         }

         class392.client = this;
         try {
         if (!_VanillaLauncher.isVanilla)
            RuneLiteMenuEntry.client = (RSClient) (Object) this;
         class458.field3923 = clientType;
         ObjectComposition.method1033();
         if (Boolean.parseBoolean(System.getProperty("jagex.disableBouncyCastle"))) {
            this.field479 = true;
         }
         } catch (Exception e) {
            System.out.println(e);
         }
         if (field363 == -1) {
            if (!this.method349() && !this.method350()) {
               field363 = 0;
            } else {
               field363 = 5;
            }
         }

         this.startThread(765, 503, 212, 1);
      }
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "(IIB)I",
      garbageValue = "-89"
   )
   public static int method385(int var0, int var1) {
      int var2;
      if (var1 > var0) {
         var2 = var0;
         var0 = var1;
         var1 = var2;
      }

      while(var1 != 0) {
         var2 = var0 % var1;
         var0 = var1;
         var1 = var2;
      }

      return var0;
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      descriptor = "(II)I",
      garbageValue = "-557966076"
   )
   @Export("iLog")
   public static int iLog(int var0) {
      int var1 = 0;
      if (var0 < 0 || var0 >= 65536) {
         var0 >>>= 16;
         var1 += 16;
      }

      if (var0 >= 256) {
         var0 >>>= 8;
         var1 += 8;
      }

      if (var0 >= 16) {
         var0 >>>= 4;
         var1 += 4;
      }

      if (var0 >= 4) {
         var0 >>>= 2;
         var1 += 2;
      }

      if (var0 >= 1) {
         var0 >>>= 1;
         ++var1;
      }

      return var0 + var1;
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      descriptor = "([FI)V",
      garbageValue = "-743757040"
   )
   static void method384(float[] var0) {
      if (class123.field1167 + var0[0] < 1.3333334F) {
         float var1 = var0[0] - 2.0F;
         float var2 = var0[0] - 1.0F;
         float var3 = (float)Math.sqrt((double)(var1 * var1 - var2 * var2 * 4.0F));
         float var4 = 0.5F * (var3 + -var1);
         if (var0[1] + class123.field1167 > var4) {
            var0[1] = var4 - class123.field1167;
         } else {
            var4 = (-var1 - var3) * 0.5F;
            if (var0[1] < var4 + class123.field1167) {
               var0[1] = var4 + class123.field1167;
            }
         }
      } else {
         var0[0] = 1.3333334F - class123.field1167;
         var0[1] = 0.33333334F - class123.field1167;
      }

   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      descriptor = "(IIB)V",
      garbageValue = "92"
   )
   public static final void method370(int var0, int var1) {
      ViewportMouse.ViewportMouse_x = var0;
      ViewportMouse.ViewportMouse_y = var1;
      ViewportMouse.ViewportMouse_isInViewport = true;
      ViewportMouse.ViewportMouse_entityCount = 0;
      ViewportMouse.ViewportMouse_false0 = false;
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "1744336849"
   )
   static void method381() {
      if (IgnoreList.loadWorlds()) {
         Login.worldSelectOpen = true;
         Login.worldSelectPage = 0;
         Login.worldSelectPagesCount = 0;
      }

   }

   @ObfuscatedName("bd")
   @ObfuscatedSignature(
      descriptor = "(ILcv;ZI)I",
      garbageValue = "367768395"
   )
   static int method372(int var0, Script var1, boolean var2) {
      if (var0 == 6500) {
         Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = IgnoreList.loadWorlds() ? 1 : 0;
         return 1;
      } else {
         World var3;
         if (var0 == 6501) {
            var3 = FontName.worldListStart();
            if (var3 != null) {
               Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.id;
               Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.properties;
               Interpreter.Interpreter_stringStack[++HealthBar.Interpreter_stringStackSize - 1] = var3.activity;
               Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.location;
               Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.population;
               Interpreter.Interpreter_stringStack[++HealthBar.Interpreter_stringStackSize - 1] = var3.host;
            } else {
               Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -1;
               Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
               Interpreter.Interpreter_stringStack[++HealthBar.Interpreter_stringStackSize - 1] = "";
               Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
               Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
               Interpreter.Interpreter_stringStack[++HealthBar.Interpreter_stringStackSize - 1] = "";
            }

            return 1;
         } else if (var0 == 6502) {
            var3 = class467.getNextWorldListWorld();
            if (var3 != null) {
               Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.id;
               Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.properties;
               Interpreter.Interpreter_stringStack[++HealthBar.Interpreter_stringStackSize - 1] = var3.activity;
               Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.location;
               Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.population;
               Interpreter.Interpreter_stringStack[++HealthBar.Interpreter_stringStackSize - 1] = var3.host;
            } else {
               Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -1;
               Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
               Interpreter.Interpreter_stringStack[++HealthBar.Interpreter_stringStackSize - 1] = "";
               Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
               Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
               Interpreter.Interpreter_stringStack[++HealthBar.Interpreter_stringStackSize - 1] = "";
            }

            return 1;
         } else {
            World var4;
            int var5;
            int var7;
            if (var0 == 6506) {
               var7 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
               var4 = null;

               for(var5 = 0; var5 < World.World_count; ++var5) {
                  if (var7 == class260.World_worlds[var5].id) {
                     var4 = class260.World_worlds[var5];
                     break;
                  }
               }

               if (var4 != null) {
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var4.id;
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var4.properties;
                  Interpreter.Interpreter_stringStack[++HealthBar.Interpreter_stringStackSize - 1] = var4.activity;
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var4.location;
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var4.population;
                  Interpreter.Interpreter_stringStack[++HealthBar.Interpreter_stringStackSize - 1] = var4.host;
               } else {
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -1;
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
                  Interpreter.Interpreter_stringStack[++HealthBar.Interpreter_stringStackSize - 1] = "";
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
                  Interpreter.Interpreter_stringStack[++HealthBar.Interpreter_stringStackSize - 1] = "";
               }

               return 1;
            } else if (var0 == 6507) {
               Interpreter.Interpreter_intStackSize -= 4;
               var7 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
               boolean var10 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1] == 1;
               var5 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 2];
               boolean var6 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 3] == 1;
               UrlRequest.sortWorldList(var7, var10, var5, var6);
               return 1;
            } else if (var0 != 6511) {
               if (var0 == 6512) {
                  followerOpsLowPriority = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
                  return 1;
               } else {
                  int var8;
                  ParamComposition var9;
                  if (var0 == 6513) {
                     Interpreter.Interpreter_intStackSize -= 2;
                     var7 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
                     var8 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
                     var9 = class153.getParamDefinition(var8);
                     if (var9.isString()) {
                        Interpreter.Interpreter_stringStack[++HealthBar.Interpreter_stringStackSize - 1] = class188.getNpcDefinition(var7).getStringParam(var8, var9.defaultStr);
                     } else {
                        Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class188.getNpcDefinition(var7).getIntParam(var8, var9.defaultInt);
                     }

                     return 1;
                  } else if (var0 == 6514) {
                     Interpreter.Interpreter_intStackSize -= 2;
                     var7 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
                     var8 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
                     var9 = class153.getParamDefinition(var8);
                     if (var9.isString()) {
                        Interpreter.Interpreter_stringStack[++HealthBar.Interpreter_stringStackSize - 1] = WallDecoration.getObjectDefinition(var7).getStringParam(var8, var9.defaultStr);
                     } else {
                        Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = WallDecoration.getObjectDefinition(var7).getIntParam(var8, var9.defaultInt);
                     }

                     return 1;
                  } else if (var0 == 6515) {
                     Interpreter.Interpreter_intStackSize -= 2;
                     var7 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
                     var8 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
                     var9 = class153.getParamDefinition(var8);
                     if (var9.isString()) {
                        Interpreter.Interpreter_stringStack[++HealthBar.Interpreter_stringStackSize - 1] = ParamComposition.ItemDefinition_get(var7).getStringParam(var8, var9.defaultStr);
                     } else {
                        Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = ParamComposition.ItemDefinition_get(var7).getIntParam(var8, var9.defaultInt);
                     }

                     return 1;
                  } else if (var0 == 6516) {
                     Interpreter.Interpreter_intStackSize -= 2;
                     var7 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
                     var8 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
                     var9 = class153.getParamDefinition(var8);
                     if (var9.isString()) {
                        Interpreter.Interpreter_stringStack[++HealthBar.Interpreter_stringStackSize - 1] = class269.StructDefinition_getStructDefinition(var7).getStringParam(var8, var9.defaultStr);
                     } else {
                        Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class269.StructDefinition_getStructDefinition(var7).getIntParam(var8, var9.defaultInt);
                     }

                     return 1;
                  } else if (var0 == 6518) {
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = onMobile ? 1 : 0;
                     return 1;
                  } else if (var0 == 6519) {
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = clientType;
                     return 1;
                  } else if (var0 == 6520) {
                     return 1;
                  } else if (var0 == 6521) {
                     return 1;
                  } else if (var0 == 6522) {
                     --HealthBar.Interpreter_stringStackSize;
                     --Interpreter.Interpreter_intStackSize;
                     return 1;
                  } else if (var0 == 6523) {
                     --HealthBar.Interpreter_stringStackSize;
                     --Interpreter.Interpreter_intStackSize;
                     return 1;
                  } else if (var0 == 6524) {
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -1;
                     return 1;
                  } else if (var0 == 6525) {
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 1;
                     return 1;
                  } else if (var0 == 6526) {
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 1;
                     return 1;
                  } else if (var0 == 6527) {
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = field363;
                     return 1;
                  } else {
                     return 2;
                  }
               }
            } else {
               var7 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
               if (var7 >= 0 && var7 < World.World_count) {
                  var4 = class260.World_worlds[var7];
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var4.id;
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var4.properties;
                  Interpreter.Interpreter_stringStack[++HealthBar.Interpreter_stringStackSize - 1] = var4.activity;
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var4.location;
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var4.population;
                  Interpreter.Interpreter_stringStack[++HealthBar.Interpreter_stringStackSize - 1] = var4.host;
               } else {
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -1;
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
                  Interpreter.Interpreter_stringStack[++HealthBar.Interpreter_stringStackSize - 1] = "";
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
                  Interpreter.Interpreter_stringStack[++HealthBar.Interpreter_stringStackSize - 1] = "";
               }

               return 1;
            }
         }
      }
   }

   @ObfuscatedName("lq")
   @ObfuscatedSignature(
      descriptor = "(Lmy;I)V",
      garbageValue = "775964682"
   )
   static final void method369(Widget var0) {
      if (var0.buttonType == 1) {
         class123.method680(var0.buttonText, "", 24, 0, 0, var0.id, var0.itemId);
      }

      String var1;
      if (var0.buttonType == 2 && !isSpellSelected) {
         var1 = Archive.Widget_getSpellActionName(var0);
         if (var1 != null) {
            class123.method680(var1, Canvas.colorStartTag(65280) + var0.field2960, 25, 0, -1, var0.id, var0.itemId);
         }
      }

      if (var0.buttonType == 3) {
         class110.insertMenuItemNoShift("Close", "", 26, 0, 0, var0.id);
      }

      if (var0.buttonType == 4) {
         class110.insertMenuItemNoShift(var0.buttonText, "", 28, 0, 0, var0.id);
      }

      if (var0.buttonType == 5) {
         class110.insertMenuItemNoShift(var0.buttonText, "", 29, 0, 0, var0.id);
      }

      if (var0.buttonType == 6 && meslayerContinueWidget == null) {
         class110.insertMenuItemNoShift(var0.buttonText, "", 30, 0, -1, var0.id);
      }

      if (var0.isIf3) {
         if (isSpellSelected) {
            if (Clock.method919(ParamComposition.getWidgetFlags(var0)) && (class90.selectedSpellFlags & 32) == 32) {
               class123.method680(field583, field518 + " " + "->" + " " + var0.dataText, 58, 0, var0.childIndex, var0.id, var0.itemId);
            }
         } else {
            for(int var4 = 9; var4 >= 5; --var4) {
               String var2 = WorldMapScaleHandler.method1511(var0, var4);
               if (var2 != null) {
                  class123.method680(var2, var0.dataText, 1007, var4 + 1, var0.childIndex, var0.id, var0.itemId);
               }
            }

            var1 = Archive.Widget_getSpellActionName(var0);
            if (var1 != null) {
               class123.method680(var1, var0.dataText, 25, 0, var0.childIndex, var0.id, var0.itemId);
            }

            for(int var5 = 4; var5 >= 0; --var5) {
               String var3 = WorldMapScaleHandler.method1511(var0, var5);
               if (var3 != null) {
                  class351.insertMenuItem(var3, var0.dataText, 57, var5 + 1, var0.childIndex, var0.id, var0.itemId, var0.prioritizeMenuEntry);
               }
            }

            int var6 = ParamComposition.getWidgetFlags(var0);
            boolean var7 = (var6 & 1) != 0;
            if (var7) {
               class110.insertMenuItemNoShift("Continue", "", 30, 0, var0.childIndex, var0.id);
            }
         }
      }

   }

   @ObfuscatedName("nl")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "-665812054"
   )
   static void method383() {
      for(int var0 = 0; var0 < field617.size(); ++var0) {
         int var2 = (Integer)field617.get(var0);
         class134 var4 = (class134)SequenceDefinition.SequenceDefinition_cachedModel.get((long)var2);
         class134 var3;
         if (var4 != null) {
            var3 = var4;
         } else {
            AbstractArchive var6 = SequenceDefinition.SequenceDefinition_animationsArchive;
            AbstractArchive var7 = SequenceDefinition.SequenceDefinition_skeletonsArchive;
            boolean var8 = true;
            byte[] var9 = var6.getFile(var2 >> 16 & '\uffff', var2 & '\uffff');
            class134 var5;
            if (var9 == null) {
               var8 = false;
               var5 = null;
            } else {
               int var10 = (var9[1] & 255) << 8 | var9[2] & 255;
               byte[] var11 = var7.getFile(var10, 0);
               if (var11 == null) {
                  var8 = false;
               }

               if (!var8) {
                  var5 = null;
               } else {
                  if (UserComparator7.field1146 == null) {
                     class134.field1263 = Runtime.getRuntime().availableProcessors();
                     UserComparator7.field1146 = new ThreadPoolExecutor(0, class134.field1263, 0L, TimeUnit.MILLISECONDS, new ArrayBlockingQueue(class134.field1263 * 100 + 100), new class69());
                  }

                  try {
                     var5 = new class134(var6, var7, var2, false);
                  } catch (Exception var13) {
                     var5 = null;
                  }
               }
            }

            if (var5 != null) {
               SequenceDefinition.SequenceDefinition_cachedModel.put(var5, (long)var2);
            }

            var3 = var5;
         }

         int var1;
         if (var3 == null) {
            var1 = 2;
         } else {
            var1 = var3.method725() ? 0 : 1;
         }

         if (var1 != 2) {
            field617.remove(var0);
            --var0;
         }
      }

   }
}
