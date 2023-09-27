import com.jagex.oldscape.pub.OAuthApi;
import com.jagex.oldscape.pub.OtlTokenRequester;
import com.jagex.oldscape.pub.RefreshAccessTokenRequester;
import com.jagex.oldscape.pub.RefreshAccessTokenResponse;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import netscape.js.JSObject;
import org.json.JSONException;
import org.json.JSONObject;

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

@Implements("Client")
@ObfuscatedName("client")
public final class Client extends GameEngine implements Usernamed, OAuthApi, class325 {

	boolean shouldProcessClick(){
		return false;
	}
	@ObfuscatedName("vg")
	@Export("viewportOffsetX")
	static int viewportOffsetX;
	@ObfuscatedName("vp")
	@Export("viewportOffsetY")
	static int viewportOffsetY;
	@ObfuscatedName("wp")
	public static int field368;
	@ObfuscatedName("wk")
	@ObfuscatedSignature(
		descriptor = "Lia;"
	)
	static final class232 field651;
	@ObfuscatedName("xx")
	@ObfuscatedSignature(
		descriptor = "Lcs;"
	)
	static final ApproximateRouteStrategy field650;
	@ObfuscatedName("xo")
	static int[] field592;
	@ObfuscatedName("xu")
	static int[] field593;
	@ObfuscatedName("wu")
	static int field548;
	@ObfuscatedName("vi")
	@ObfuscatedSignature(
		descriptor = "Lni;"
	)
	@Export("playerAppearance")
	static PlayerComposition playerAppearance;
	@ObfuscatedName("ww")
	static int field549;
	@ObfuscatedName("wc")
	@Export("archiveLoaders")
	static ArrayList archiveLoaders;
	@ObfuscatedName("xp")
	@Export("archiveLoadersDone")
	static int archiveLoadersDone;
	@ObfuscatedName("vt")
	@Export("cameraShakeCycle")
	static int[] cameraShakeCycle;
	@ObfuscatedName("wa")
	@ObfuscatedSignature(
		descriptor = "[Log;"
	)
	@Export("grandExchangeOffers")
	static GrandExchangeOffer[] grandExchangeOffers;
	@ObfuscatedName("xy")
	static int field551;
	@ObfuscatedName("wy")
	@ObfuscatedSignature(
		descriptor = "Lsk;"
	)
	static class490 field641;
	@ObfuscatedName("vm")
	static short field634;
	@ObfuscatedName("vc")
	static short field633;
	@ObfuscatedName("vv")
	static short field638;
	@ObfuscatedName("vo")
	static short field635;
	@ObfuscatedName("vy")
	static short field640;
	@ObfuscatedName("vx")
	@Export("viewportZoom")
	static int viewportZoom;
	@ObfuscatedName("vw")
	static short field639;
	@ObfuscatedName("vn")
	@Export("viewportWidth")
	static int viewportWidth;
	@ObfuscatedName("vl")
	@Export("viewportHeight")
	static int viewportHeight;
	@ObfuscatedName("vq")
	@Export("zoomWidth")
	static short zoomWidth;
	@ObfuscatedName("vs")
	@Export("zoomHeight")
	static short zoomHeight;
	@ObfuscatedName("wg")
	@ObfuscatedSignature(
		descriptor = "Lcm;"
	)
	@Export("GrandExchangeEvents_worldComparator")
	static GrandExchangeOfferOwnWorldComparator GrandExchangeEvents_worldComparator;
	@ObfuscatedName("wq")
	@ObfuscatedSignature(
		descriptor = "Llr;"
	)
	@Export("archive11")
	static EvictingDualNodeHashTable archive11;
	@ObfuscatedName("wt")
	@ObfuscatedSignature(
		descriptor = "Llr;"
	)
	@Export("Widget_cachedModels")
	static EvictingDualNodeHashTable Widget_cachedModels;
	@ObfuscatedName("ws")
	static int field547;
	@ObfuscatedName("wz")
	static List field608;
	@ObfuscatedName("wi")
	@ObfuscatedSignature(
		descriptor = "Lqe;"
	)
	static class438 field631;
	@ObfuscatedName("bq")
	@Export("lockMouseRecorder")
	static boolean lockMouseRecorder;
	@ObfuscatedName("bw")
	@Export("worldId")
	public static int worldId;
	@ObfuscatedName("ce")
	@Export("worldProperties")
	static int worldProperties;
	@ObfuscatedName("cw")
	@Export("gameBuild")
	static int gameBuild;
	@ObfuscatedName("cg")
	@Export("isMembersWorld")
	public static boolean isMembersWorld;
	@ObfuscatedName("cq")
	@Export("isLowDetail")
	static boolean isLowDetail;
	@ObfuscatedName("cn")
	@Export("param21")
	static int param21;
	@ObfuscatedName("ck")
	@Export("clientType")
	static int clientType;
	@ObfuscatedName("cr")
	static int field427;
	@ObfuscatedName("cs")
	@Export("onMobile")
	static boolean onMobile;
	@ObfuscatedName("cm")
	@Export("param25")
	public static int param25;
	@ObfuscatedName("dm")
	@Export("gameState")
	static int gameState;
	@ObfuscatedName("ds")
	@Export("reloadJS5")
	static boolean reloadJS5;
	@ObfuscatedName("eo")
	@Export("isLoading")
	static boolean isLoading;
	@ObfuscatedName("em")
	@Export("cycle")
	static int cycle;
	@ObfuscatedName("el")
	@Export("mouseLastLastPressedTimeMillis")
	static long mouseLastLastPressedTimeMillis;
	@ObfuscatedName("eg")
	@Export("lastMouseRecordX")
	static int lastMouseRecordX;
	@ObfuscatedName("ei")
	@Export("lastMouseRecordY")
	static int lastMouseRecordY;
	@ObfuscatedName("ex")
	static long field610;
	@ObfuscatedName("ek")
	@Export("hadFocus")
	static boolean hadFocus;
	@ObfuscatedName("er")
	@Export("rebootTimer")
	static int rebootTimer;
	@ObfuscatedName("ez")
	@Export("hintArrowType")
	static int hintArrowType;
	@ObfuscatedName("en")
	@Export("hintArrowNpcIndex")
	static int hintArrowNpcIndex;
	@ObfuscatedName("es")
	@Export("hintArrowPlayerIndex")
	static int hintArrowPlayerIndex;
	@ObfuscatedName("eq")
	@Export("hintArrowX")
	static int hintArrowX;
	@ObfuscatedName("ej")
	@Export("hintArrowY")
	static int hintArrowY;
	@ObfuscatedName("et")
	@Export("hintArrowHeight")
	static int hintArrowHeight;
	@ObfuscatedName("eh")
	@Export("hintArrowSubX")
	static int hintArrowSubX;
	@ObfuscatedName("eb")
	@Export("hintArrowSubY")
	static int hintArrowSubY;
	@ObfuscatedName("ee")
	@ObfuscatedSignature(
		descriptor = "Lem;"
	)
	@Export("playerAttackOption")
	static AttackOption playerAttackOption;
	@ObfuscatedName("ea")
	@ObfuscatedSignature(
		descriptor = "Lem;"
	)
	@Export("npcAttackOption")
	static AttackOption npcAttackOption;
	@ObfuscatedName("ey")
	@Export("renderSelf")
	static boolean renderSelf;
	@ObfuscatedName("fl")
	@ObfuscatedSignature(
		descriptor = "Ldu;"
	)
	static class94 field416;
	@ObfuscatedName("fd")
	@Export("js5ConnectState")
	static int js5ConnectState;
	@ObfuscatedName("fi")
	@Export("js5Cycles")
	static int js5Cycles;
	@ObfuscatedName("gf")
	@Export("js5Errors")
	static int js5Errors;
	@ObfuscatedName("gm")
	@Export("loginState")
	static int loginState;
	@ObfuscatedName("gb")
	static int field444;
	@ObfuscatedName("gx")
	static int field448;
	@ObfuscatedName("gp")
	static int field447;
	@ObfuscatedName("gd")
	@ObfuscatedSignature(
		descriptor = "Lfn;"
	)
	static class141 field419;
	@ObfuscatedName("gz")
	@ObfuscatedSignature(
		descriptor = "Luh;"
	)
	static class534 field648;
	@ObfuscatedName("ha")
	static final String field654;
	@ObfuscatedName("hh")
	static final String field655;
	@ObfuscatedName("hr")
	@Export("Login_isUsernameRemembered")
	static boolean Login_isUsernameRemembered;
	@ObfuscatedName("iv")
	@ObfuscatedSignature(
		descriptor = "Ldm;"
	)
	@Export("secureRandomFuture")
	static SecureRandomFuture secureRandomFuture;
	@ObfuscatedName("im")
	@Export("randomDatData")
	static byte[] randomDatData;
	@ObfuscatedName("iy")
	@ObfuscatedSignature(
		descriptor = "[Ldc;"
	)
	@Export("npcs")
	static NPC[] npcs;
	@ObfuscatedName("io")
	@Export("npcCount")
	static int npcCount;
	@ObfuscatedName("if")
	@Export("npcIndices")
	static int[] npcIndices;
	@ObfuscatedName("ij")
	static int field450;
	@ObfuscatedName("ib")
	static int[] field552;
	@ObfuscatedName("it")
	static String field598;
	@ObfuscatedName("ic")
	@ObfuscatedSignature(
		descriptor = "Lez;"
	)
	@Export("packetWriter")
	public static final PacketWriter packetWriter;
	@ObfuscatedName("ig")
	@Export("logoutTimer")
	static int logoutTimer;
	@ObfuscatedName("ip")
	@Export("hadNetworkError")
	static boolean hadNetworkError;
	@ObfuscatedName("ia")
	@ObfuscatedSignature(
		descriptor = "Lqq;"
	)
	@Export("timer")
	static Timer timer;
	@ObfuscatedName("ji")
	@Export("fontsMap")
	static HashMap fontsMap;
	@ObfuscatedName("jl")
	static int field454;
	@ObfuscatedName("jy")
	static int field456;
	@ObfuscatedName("jv")
	static int field455;
	@ObfuscatedName("ja")
	static int field452;
	@ObfuscatedName("je")
	static int field453;
	@ObfuscatedName("jm")
	@ObfuscatedSignature(
		descriptor = "[Lih;"
	)
	@Export("collisionMaps")
	static CollisionMap[] collisionMaps;
	@ObfuscatedName("jb")
	@Export("isInInstance")
	static boolean isInInstance;
	@ObfuscatedName("jg")
	@Export("instanceChunkTemplates")
	static int[][][] instanceChunkTemplates;
	@ObfuscatedName("km")
	static final int[] field652;
	@ObfuscatedName("kq")
	static int field460;
	@ObfuscatedName("kp")
	static int field459;
	@ObfuscatedName("kf")
	static int field458;
	@ObfuscatedName("kw")
	static int field461;
	@ObfuscatedName("ky")
	static int field463;
	@ObfuscatedName("kv")
	static boolean field381;
	@ObfuscatedName("kx")
	@Export("alternativeScrollbarWidth")
	static int alternativeScrollbarWidth;
	@ObfuscatedName("kd")
	@Export("cameraX")
	static int cameraX;
	@ObfuscatedName("ll")
	@Export("camAngleX")
	static int camAngleX;
	@ObfuscatedName("lh")
	@Export("camAngleY")
	static int camAngleY;
	@ObfuscatedName("lm")
	@Export("camAngleDY")
	static int camAngleDY;
	@ObfuscatedName("lj")
	@Export("camAngleDX")
	static int camAngleDX;
	@ObfuscatedName("lf")
	static int field467;
	@ObfuscatedName("li")
	static int field470;
	@ObfuscatedName("lc")
	@Export("oculusOrbState")
	static int oculusOrbState;
	@ObfuscatedName("lk")
	@Export("camFollowHeight")
	static int camFollowHeight;
	@ObfuscatedName("ls")
	static int field478;
	@ObfuscatedName("ld")
	static int field466;
	@ObfuscatedName("lr")
	static int field477;
	@ObfuscatedName("lb")
	@Export("oculusOrbNormalSpeed")
	static int oculusOrbNormalSpeed;
	@ObfuscatedName("lp")
	@Export("oculusOrbSlowedSpeed")
	static int oculusOrbSlowedSpeed;
	@ObfuscatedName("lt")
	public static int field366;
	@ObfuscatedName("le")
	@Export("oculusOrbOnLocalPlayer")
	static boolean oculusOrbOnLocalPlayer;
	@ObfuscatedName("lg")
	@Export("packetIndicator")
	static int packetIndicator;
	@ObfuscatedName("ln")
	@Export("emitPackets")
	static boolean emitPackets;
	@ObfuscatedName("lq")
	static int field476;
	@ObfuscatedName("lx")
	@Export("overheadTextLimit")
	static int overheadTextLimit;
	@ObfuscatedName("lu")
	@Export("overheadTextCount")
	static int overheadTextCount;
	@ObfuscatedName("mi")
	@Export("overheadTextXs")
	static int[] overheadTextXs;
	@ObfuscatedName("ma")
	@Export("overheadTextYs")
	static int[] overheadTextYs;
	@ObfuscatedName("mj")
	@Export("overheadTextAscents")
	static int[] overheadTextAscents;
	@ObfuscatedName("mm")
	@Export("overheadTextXOffsets")
	static int[] overheadTextXOffsets;
	@ObfuscatedName("mc")
	@Export("overheadTextColors")
	static int[] overheadTextColors;
	@ObfuscatedName("mw")
	@Export("overheadTextEffects")
	static int[] overheadTextEffects;
	@ObfuscatedName("mx")
	static int[][] field595;
	@ObfuscatedName("mr")
	@Export("overheadTextCyclesRemaining")
	static int[] overheadTextCyclesRemaining;
	@ObfuscatedName("mt")
	static String[] field602;
	@ObfuscatedName("mf")
	@Export("tileLastDrawnActor")
	static int[][] tileLastDrawnActor;
	@ObfuscatedName("mz")
	@Export("viewportDrawCount")
	static int viewportDrawCount;
	@ObfuscatedName("mu")
	@Export("viewportTempX")
	static int viewportTempX;
	@ObfuscatedName("mq")
	@Export("viewportTempY")
	static int viewportTempY;
	@ObfuscatedName("mh")
	@Export("mouseCrossX")
	static int mouseCrossX;
	@ObfuscatedName("ml")
	@Export("mouseCrossY")
	static int mouseCrossY;
	@ObfuscatedName("mn")
	@Export("mouseCrossState")
	static int mouseCrossState;
	@ObfuscatedName("mk")
	@Export("mouseCrossColor")
	static int mouseCrossColor;
	@ObfuscatedName("ms")
	@Export("showMouseCross")
	static boolean showMouseCross;
	@ObfuscatedName("me")
	static int field481;
	@ObfuscatedName("my")
	@Export("showLoadingMessages")
	static boolean showLoadingMessages;
	@ObfuscatedName("mp")
	@ObfuscatedSignature(
		descriptor = "[Ldj;"
	)
	@Export("players")
	static Player[] players;
	@ObfuscatedName("mo")
	@Export("localPlayerIndex")
	static int localPlayerIndex;
	@ObfuscatedName("mg")
	@Export("isMembers")
	static int isMembers;
	@ObfuscatedName("nt")
	@Export("playerUUID")
	static long playerUUID;
	@ObfuscatedName("nv")
	static boolean field388;
	@ObfuscatedName("nb")
	@Export("drawPlayerNames")
	static int drawPlayerNames;
	@ObfuscatedName("nm")
	static int field492;
	@ObfuscatedName("nc")
	static int[] field561;
	@ObfuscatedName("nk")
	@Export("playerMenuOpcodes")
	static final int[] playerMenuOpcodes;
	@ObfuscatedName("nn")
	@Export("playerMenuActions")
	static String[] playerMenuActions;
	@ObfuscatedName("na")
	@Export("playerOptionsPriorities")
	static boolean[] playerOptionsPriorities;
	@ObfuscatedName("nh")
	static int[] field563;
	@ObfuscatedName("nw")
	@Export("combatTargetPlayerIndex")
	static int combatTargetPlayerIndex;
	@ObfuscatedName("ny")
	@ObfuscatedSignature(
		descriptor = "[[[Lpf;"
	)
	@Export("groundItems")
	static NodeDeque[][][] groundItems;
	@ObfuscatedName("nl")
	@ObfuscatedSignature(
		descriptor = "Lpf;"
	)
	@Export("pendingSpawns")
	static NodeDeque pendingSpawns;
	@ObfuscatedName("nu")
	@ObfuscatedSignature(
		descriptor = "Lpf;"
	)
	@Export("projectiles")
	static NodeDeque projectiles;
	@ObfuscatedName("nj")
	@ObfuscatedSignature(
		descriptor = "Lpf;"
	)
	@Export("graphicsObjects")
	static NodeDeque graphicsObjects;
	@ObfuscatedName("nr")
	@Export("currentLevels")
	static int[] currentLevels;
	@ObfuscatedName("ne")
	@Export("levels")
	static int[] levels;
	@ObfuscatedName("nq")
	@Export("experience")
	static int[] experience;
	@ObfuscatedName("ng")
	@Export("leftClickOpensMenu")
	static boolean leftClickOpensMenu;
	@ObfuscatedName("np")
	@Export("isMenuOpen")
	static boolean isMenuOpen;
	@ObfuscatedName("ol")
	@Export("menuOptionsCount")
	static int menuOptionsCount;
	@ObfuscatedName("oe")
	@Export("menuArguments1")
	static int[] menuArguments1;
	@ObfuscatedName("ob")
	@Export("menuArguments2")
	static int[] menuArguments2;
	@ObfuscatedName("ok")
	@Export("menuOpcodes")
	static int[] menuOpcodes;
	@ObfuscatedName("ou")
	@Export("menuIdentifiers")
	static int[] menuIdentifiers;
	@ObfuscatedName("om")
	@Export("menuItemIds")
	static int[] menuItemIds;
	@ObfuscatedName("oo")
	@Export("menuActions")
	static String[] menuActions;
	@ObfuscatedName("ox")
	@Export("menuTargets")
	static String[] menuTargets;
	@ObfuscatedName("oc")
	@Export("menuShiftClick")
	static boolean[] menuShiftClick;
	@ObfuscatedName("oz")
	@Export("followerOpsLowPriority")
	static boolean followerOpsLowPriority;
	@ObfuscatedName("op")
	@Export("tapToDrop")
	static boolean tapToDrop;
	@ObfuscatedName("ov")
	@Export("showMouseOverText")
	static boolean showMouseOverText;
	@ObfuscatedName("od")
	@Export("viewportX")
	static int viewportX;
	@ObfuscatedName("og")
	@Export("viewportY")
	static int viewportY;
	@ObfuscatedName("on")
	static int field498;
	@ObfuscatedName("ot")
	static int field499;
	@ObfuscatedName("oa")
	@Export("isItemSelected")
	static int isItemSelected;
	@ObfuscatedName("pc")
	@Export("isSpellSelected")
	static boolean isSpellSelected;
	@ObfuscatedName("pf")
	@Export("selectedSpellChildIndex")
	static int selectedSpellChildIndex;
	@ObfuscatedName("pj")
	static int field503;
	@ObfuscatedName("ph")
	static String field599;
	@ObfuscatedName("ps")
	static String field600;
	@ObfuscatedName("pt")
	@Export("rootInterface")
	static int rootInterface;
	@ObfuscatedName("pw")
	@ObfuscatedSignature(
		descriptor = "Ltf;"
	)
	@Export("interfaceParents")
	static NodeHashTable interfaceParents;
	@ObfuscatedName("px")
	static int field508;
	@ObfuscatedName("pq")
	static int field505;
	@ObfuscatedName("pd")
	@Export("chatEffects")
	static int chatEffects;
	@ObfuscatedName("pm")
	@ObfuscatedSignature(
		descriptor = "Lnm;"
	)
	@Export("meslayerContinueWidget")
	static Widget meslayerContinueWidget;
	@ObfuscatedName("pn")
	@Export("runEnergy")
	static int runEnergy;
	@ObfuscatedName("pu")
	@Export("weight")
	static int weight;
	@ObfuscatedName("pp")
	@Export("staffModLevel")
	public static int staffModLevel;
	@ObfuscatedName("pb")
	@Export("followerIndex")
	static int followerIndex;
	@ObfuscatedName("pe")
	@Export("playerMod")
	static boolean playerMod;
	@ObfuscatedName("pk")
	@ObfuscatedSignature(
		descriptor = "Lnm;"
	)
	@Export("viewportWidget")
	static Widget viewportWidget;
	@ObfuscatedName("pr")
	@ObfuscatedSignature(
		descriptor = "Lnm;"
	)
	@Export("clickedWidget")
	public static Widget clickedWidget;
	@ObfuscatedName("pi")
	@ObfuscatedSignature(
		descriptor = "Lnm;"
	)
	@Export("clickedWidgetParent")
	static Widget clickedWidgetParent;
	@ObfuscatedName("pz")
	@Export("widgetClickX")
	static int widgetClickX;
	@ObfuscatedName("qi")
	@Export("widgetClickY")
	static int widgetClickY;
	@ObfuscatedName("qb")
	@ObfuscatedSignature(
		descriptor = "Lnm;"
	)
	@Export("draggedOnWidget")
	static Widget draggedOnWidget;
	@ObfuscatedName("qw")
	static boolean field396;
	@ObfuscatedName("qk")
	static int field516;
	@ObfuscatedName("qg")
	static int field514;
	@ObfuscatedName("qm")
	static boolean field394;
	@ObfuscatedName("qz")
	static int field521;
	@ObfuscatedName("ql")
	static int field517;
	@ObfuscatedName("qn")
	@Export("isDraggingWidget")
	static boolean isDraggingWidget;
	@ObfuscatedName("qr")
	@Export("cycleCntr")
	static int cycleCntr;
	@ObfuscatedName("qy")
	@Export("changedVarps")
	static int[] changedVarps;
	@ObfuscatedName("qf")
	@Export("changedVarpCount")
	static int changedVarpCount;
	@ObfuscatedName("qv")
	@Export("changedItemContainers")
	static int[] changedItemContainers;
	@ObfuscatedName("qa")
	@Export("changedItemContainersCount")
	static int changedItemContainersCount;
	@ObfuscatedName("qs")
	@Export("changedSkills")
	static int[] changedSkills;
	@ObfuscatedName("qp")
	@Export("changedSkillsCount")
	static int changedSkillsCount;
	@ObfuscatedName("qe")
	static int[] field571;
	@ObfuscatedName("qd")
	static int field512;
	@ObfuscatedName("qu")
	@Export("chatCycle")
	static int chatCycle;
	@ObfuscatedName("qc")
	static int field511;
	@ObfuscatedName("rt")
	static int field530;
	@ObfuscatedName("rl")
	static int field525;
	@ObfuscatedName("rq")
	static int field528;
	@ObfuscatedName("rr")
	static int field529;
	@ObfuscatedName("rm")
	static int field526;
	@ObfuscatedName("rp")
	static int field527;
	@ObfuscatedName("re")
	@Export("mouseWheelRotation")
	static int mouseWheelRotation;
	@ObfuscatedName("rc")
	@ObfuscatedSignature(
		descriptor = "Lvz;"
	)
	static class547 field649;
	@ObfuscatedName("rj")
	@ObfuscatedSignature(
		descriptor = "Lpf;"
	)
	@Export("scriptEvents")
	static NodeDeque scriptEvents;
	@ObfuscatedName("net/runelite/rs")
	@ObfuscatedSignature(
		descriptor = "Lpf;"
	)
	static NodeDeque field628;
	@ObfuscatedName("rw")
	@ObfuscatedSignature(
		descriptor = "Lpf;"
	)
	static NodeDeque field629;
	@ObfuscatedName("rh")
	@ObfuscatedSignature(
		descriptor = "Lpf;"
	)
	static NodeDeque field626;
	@ObfuscatedName("ru")
	@ObfuscatedSignature(
		descriptor = "Ltf;"
	)
	@Export("widgetFlags")
	static NodeHashTable widgetFlags;
	@ObfuscatedName("rk")
	@Export("rootWidgetCount")
	static int rootWidgetCount;
	@ObfuscatedName("rf")
	static int field523;
	@ObfuscatedName("ro")
	static boolean[] field408;
	@ObfuscatedName("rd")
	static boolean[] field407;
	@ObfuscatedName("rb")
	static boolean[] field406;
	@ObfuscatedName("rz")
	@Export("rootWidgetXs")
	static int[] rootWidgetXs;
	@ObfuscatedName("rg")
	@Export("rootWidgetYs")
	static int[] rootWidgetYs;
	@ObfuscatedName("sz")
	@Export("rootWidgetWidths")
	static int[] rootWidgetWidths;
	@ObfuscatedName("sr")
	@Export("rootWidgetHeights")
	static int[] rootWidgetHeights;
	@ObfuscatedName("sm")
	@Export("gameDrawingMode")
	static int gameDrawingMode;
	@ObfuscatedName("sw")
	static long field613;
	@ObfuscatedName("sl")
	@Export("isResizable")
	static boolean isResizable;
	@ObfuscatedName("sy")
	static int[] field580;
	@ObfuscatedName("sf")
	@Export("publicChatMode")
	static int publicChatMode;
	@ObfuscatedName("sg")
	@Export("tradeChatMode")
	static int tradeChatMode;
	@ObfuscatedName("sb")
	static String field601;
	@ObfuscatedName("se")
	@Export("crossWorldMessageIds")
	static long[] crossWorldMessageIds;
	@ObfuscatedName("ss")
	@Export("crossWorldMessageIdsIndex")
	static int crossWorldMessageIdsIndex;
	@ObfuscatedName("sj")
	@ObfuscatedSignature(
		descriptor = "Lit;"
	)
	@Export("keyHandlerInstance")
	static class226 keyHandlerInstance;
	@ObfuscatedName("sn")
	@ObfuscatedSignature(
		descriptor = "Lib;"
	)
	static class224 field422;
	@ObfuscatedName("sk")
	static int field533;
	@ObfuscatedName("so")
	static int[] field578;
	@ObfuscatedName("sc")
	static int[] field577;
	@ObfuscatedName("sp")
	@Export("timeOfPreviousKeyPress")
	static long timeOfPreviousKeyPress;
	@ObfuscatedName("tu")
	@ObfuscatedSignature(
		descriptor = "[Lgi;"
	)
	@Export("currentClanSettings")
	static ClanSettings[] currentClanSettings;
	@ObfuscatedName("tc")
	@ObfuscatedSignature(
		descriptor = "[Lgb;"
	)
	@Export("currentClanChannels")
	static ClanChannel[] currentClanChannels;
	@ObfuscatedName("tm")
	static int field539;
	@ObfuscatedName("tp")
	@Export("mapIconCount")
	static int mapIconCount;
	@ObfuscatedName("tf")
	@Export("mapIconXs")
	static int[] mapIconXs;
	@ObfuscatedName("ts")
	@Export("mapIconYs")
	static int[] mapIconYs;
	@ObfuscatedName("ty")
	@ObfuscatedSignature(
		descriptor = "[Lud;"
	)
	@Export("mapIcons")
	static SpritePixels[] mapIcons;
	@ObfuscatedName("ta")
	@Export("destinationX")
	static int destinationX;
	@ObfuscatedName("te")
	@Export("destinationY")
	static int destinationY;
	@ObfuscatedName("tg")
	@Export("minimapState")
	static int minimapState;
	@ObfuscatedName("tk")
	@Export("playingJingle")
	static boolean playingJingle;
	@ObfuscatedName("uz")
	@Export("soundEffectCount")
	static int soundEffectCount;
	@ObfuscatedName("uq")
	@Export("soundEffectIds")
	static int[] soundEffectIds;
	@ObfuscatedName("ug")
	@Export("queuedSoundEffectLoops")
	static int[] queuedSoundEffectLoops;
	@ObfuscatedName("uu")
	@Export("queuedSoundEffectDelays")
	static int[] queuedSoundEffectDelays;
	@ObfuscatedName("ua")
	@Export("soundLocations")
	static int[] soundLocations;
	@ObfuscatedName("um")
	@ObfuscatedSignature(
		descriptor = "[Lbr;"
	)
	@Export("soundEffects")
	static SoundEffect[] soundEffects;
	@ObfuscatedName("ub")
	@Export("isCameraLocked")
	static boolean isCameraLocked;
	@ObfuscatedName("uk")
	static boolean field402;
	@ObfuscatedName("uh")
	static boolean field401;
	@ObfuscatedName("uw")
	static boolean field403;
	@ObfuscatedName("uf")
	@ObfuscatedSignature(
		descriptor = "Lth;"
	)
	static class494 field646;
	@ObfuscatedName("un")
	@ObfuscatedSignature(
		descriptor = "Lsp;"
	)
	static class493 field643;
	@ObfuscatedName("ud")
	@ObfuscatedSignature(
		descriptor = "Lsp;"
	)
	static class493 field642;
	@ObfuscatedName("ue")
	static boolean field400;
	@ObfuscatedName("vf")
	@Export("cameraShaking")
	static boolean[] cameraShaking;
	@ObfuscatedName("vj")
	@Export("cameraShakeIntensity")
	static int[] cameraShakeIntensity;
	@ObfuscatedName("vu")
	@Export("cameraMoveIntensity")
	static int[] cameraMoveIntensity;
	@ObfuscatedName("ve")
	@Export("cameraShakeSpeed")
	static int[] cameraShakeSpeed;
	@ObfuscatedName("hi")
	String field664;
	@ObfuscatedName("hf")
	@ObfuscatedSignature(
		descriptor = "Las;"
	)
	class14 field659;
	@ObfuscatedName("hu")
	@ObfuscatedSignature(
		descriptor = "Lai;"
	)
	class18 field658;
	@ObfuscatedName("hy")
	@ObfuscatedSignature(
		descriptor = "Lcom/jagex/oldscape/pub/OtlTokenRequester;"
	)
	OtlTokenRequester field661;
	@ObfuscatedName("hl")
	Future field665;
	@ObfuscatedName("hm")
	boolean field660;
	@ObfuscatedName("hd")
	int field663;
	@ObfuscatedName("hs")
	@ObfuscatedSignature(
		descriptor = "Lai;"
	)
	class18 field657;
	@ObfuscatedName("hk")
	@ObfuscatedSignature(
		descriptor = "Lcom/jagex/oldscape/pub/RefreshAccessTokenRequester;"
	)
	RefreshAccessTokenRequester field662;
	@ObfuscatedName("hn")
	Future field666;
	@ObfuscatedName("ie")
	@ObfuscatedSignature(
		descriptor = "Lul;"
	)
	Buffer field668;
	@ObfuscatedName("in")
	@ObfuscatedSignature(
		descriptor = "Lab;"
	)
	class7 field656;
	@ObfuscatedName("is")
	long field667;

	static {
		lockMouseRecorder = true;
		worldId = 1;
		worldProperties = 0;
		gameBuild = 0;
		isMembersWorld = false;
		isLowDetail = false;
		param21 = -1;
		clientType = -1;
		field427 = -1;
		onMobile = false;
		param25 = 217;
		gameState = 0;
		reloadJS5 = false;
		isLoading = true;
		cycle = 0;
		mouseLastLastPressedTimeMillis = -1L;
		lastMouseRecordX = -1;
		lastMouseRecordY = -1;
		field610 = -1L;
		hadFocus = true;
		rebootTimer = 0;
		hintArrowType = 0;
		hintArrowNpcIndex = 0;
		hintArrowPlayerIndex = 0;
		hintArrowX = 0;
		hintArrowY = 0;
		hintArrowHeight = 0;
		hintArrowSubX = 0;
		hintArrowSubY = 0;
		playerAttackOption = AttackOption.AttackOption_hidden;
		npcAttackOption = AttackOption.AttackOption_hidden;
		renderSelf = false;
		field416 = class94.field929;
		js5ConnectState = 0;
		js5Cycles = 0;
		js5Errors = 0;
		loginState = 0;
		field444 = 0;
		field448 = 0;
		field447 = 0;
		field419 = class141.field1312;
		field648 = class534.field4231;
		int var1 = "com_jagex_auth_desktop_osrs:public".length();
		byte[] var2 = new byte[var1];

		for (int var3 = 0; var3 < var1; ++var3) {
			char var4 = "com_jagex_auth_desktop_osrs:public".charAt(var3);
			if (var4 > 127) {
				var2[var3] = 63;
			} else {
				var2[var3] = (byte)var4;
			}
		}

		field654 = class233.method1199(var2);
		field655 = class233.method1199(FriendSystem.method399("com_jagex_auth_desktop_runelite:public"));
		Login_isUsernameRemembered = false;
		secureRandomFuture = new SecureRandomFuture();
		randomDatData = null;
		npcs = new NPC[65536];
		npcCount = 0;
		npcIndices = new int[65536];
		field450 = 0;
		field552 = new int[250];
		packetWriter = new PacketWriter();
		logoutTimer = 0;
		hadNetworkError = false;
		timer = new Timer();
		fontsMap = new HashMap();
		field454 = 0;
		field456 = 1;
		field455 = 0;
		field452 = 1;
		field453 = 0;
		collisionMaps = new CollisionMap[4];
		isInInstance = false;
		instanceChunkTemplates = new int[4][13][13];
		field652 = new int[]{0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3};
		field460 = 0;
		field459 = 2301979;
		field458 = 5063219;
		field461 = 3353893;
		field463 = 7759444;
		field381 = false;
		alternativeScrollbarWidth = 0;
		camAngleX = 128;
		camAngleY = 0;
		camAngleDY = 0;
		camAngleDX = 0;
		field467 = 0;
		field470 = 0;
		oculusOrbState = 0;
		camFollowHeight = 50;
		field478 = 0;
		field466 = 0;
		field477 = 0;
		oculusOrbNormalSpeed = 12;
		oculusOrbSlowedSpeed = 6;
		field366 = 0;
		oculusOrbOnLocalPlayer = false;
		packetIndicator = 0;
		emitPackets = false;
		field476 = 0;
		overheadTextLimit = 0;
		overheadTextCount = 50;
		overheadTextXs = new int[overheadTextCount];
		overheadTextYs = new int[overheadTextCount];
		overheadTextAscents = new int[overheadTextCount];
		overheadTextXOffsets = new int[overheadTextCount];
		overheadTextColors = new int[overheadTextCount];
		overheadTextEffects = new int[overheadTextCount];
		field595 = new int[overheadTextCount][];
		overheadTextCyclesRemaining = new int[overheadTextCount];
		field602 = new String[overheadTextCount];
		tileLastDrawnActor = new int[104][104];
		viewportDrawCount = 0;
		viewportTempX = -1;
		viewportTempY = -1;
		mouseCrossX = 0;
		mouseCrossY = 0;
		mouseCrossState = 0;
		mouseCrossColor = 0;
		showMouseCross = true;
		field481 = 0;
		showLoadingMessages = true;
		players = new Player[2048];
		localPlayerIndex = -1;
		isMembers = 0;
		playerUUID = -1L;
		field388 = true;
		drawPlayerNames = 0;
		field492 = 0;
		field561 = new int[1000];
		playerMenuOpcodes = new int[]{44, 45, 46, 47, 48, 49, 50, 51};
		playerMenuActions = new String[8];
		playerOptionsPriorities = new boolean[8];
		field563 = new int[]{768, 1024, 1280, 512, 1536, 256, 0, 1792};
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
		field498 = 0;
		field499 = 50;
		isItemSelected = 0;
		field598 = null;
		isSpellSelected = false;
		selectedSpellChildIndex = -1;
		field503 = -1;
		field599 = null;
		field600 = null;
		rootInterface = -1;
		interfaceParents = new NodeHashTable(8);
		field508 = 0;
		field505 = -1;
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
		field396 = false;
		field516 = -1;
		field514 = -1;
		field394 = false;
		field521 = -1;
		field517 = -1;
		isDraggingWidget = false;
		cycleCntr = 1;
		changedVarps = new int[32];
		changedVarpCount = 0;
		changedItemContainers = new int[32];
		changedItemContainersCount = 0;
		changedSkills = new int[32];
		changedSkillsCount = 0;
		field571 = new int[32];
		field512 = 0;
		chatCycle = 0;
		field511 = 0;
		field530 = 0;
		field525 = 0;
		field528 = 0;
		field529 = 0;
		field526 = 0;
		field527 = 0;
		mouseWheelRotation = 0;
		field649 = new class547();
		scriptEvents = new NodeDeque();
		field628 = new NodeDeque();
		field629 = new NodeDeque();
		field626 = new NodeDeque();
		widgetFlags = new NodeHashTable(512);
		rootWidgetCount = 0;
		field523 = -2;
		field408 = new boolean[100];
		field407 = new boolean[100];
		field406 = new boolean[100];
		rootWidgetXs = new int[100];
		rootWidgetYs = new int[100];
		rootWidgetWidths = new int[100];
		rootWidgetHeights = new int[100];
		gameDrawingMode = 0;
		field613 = 0L;
		isResizable = true;
		field580 = new int[]{16776960, 16711680, 65280, 65535, 16711935, 16777215};
		publicChatMode = 0;
		tradeChatMode = 0;
		field601 = "";
		crossWorldMessageIds = new long[100];
		crossWorldMessageIdsIndex = 0;
		keyHandlerInstance = new class226();
		field422 = new class224();
		field533 = 0;
		field578 = new int[128];
		field577 = new int[128];
		timeOfPreviousKeyPress = -1L;
		currentClanSettings = new ClanSettings[4];
		currentClanChannels = new ClanChannel[4];
		field539 = -1;
		mapIconCount = 0;
		mapIconXs = new int[1000];
		mapIconYs = new int[1000];
		mapIcons = new SpritePixels[1000];
		destinationX = 0;
		destinationY = 0;
		minimapState = 0;
		playingJingle = false;
		soundEffectCount = 0;
		soundEffectIds = new int[50];
		queuedSoundEffectLoops = new int[50];
		queuedSoundEffectDelays = new int[50];
		soundLocations = new int[50];
		soundEffects = new SoundEffect[50];
		isCameraLocked = false;
		field402 = false;
		field401 = false;
		field403 = false;
		field646 = null;
		field643 = null;
		field642 = null;
		field400 = false;
		cameraShaking = new boolean[5];
		cameraShakeIntensity = new int[5];
		cameraMoveIntensity = new int[5];
		cameraShakeSpeed = new int[5];
		cameraShakeCycle = new int[5];
		field634 = 256;
		field633 = 205;
		zoomHeight = 256;
		zoomWidth = 320;
		field639 = 1;
		field640 = 32767;
		field638 = 1;
		field635 = 32767;
		viewportOffsetX = 0;
		viewportOffsetY = 0;
		viewportWidth = 0;
		viewportHeight = 0;
		viewportZoom = 0;
		playerAppearance = new PlayerComposition();
		field548 = -1;
		field549 = -1;
		field641 = new DesktopPlatformInfoProvider();
		grandExchangeOffers = new GrandExchangeOffer[8];
		GrandExchangeEvents_worldComparator = new GrandExchangeOfferOwnWorldComparator();
		field631 = new class438(8, class436.field3797);
		Widget_cachedModels = new EvictingDualNodeHashTable(64);
		archive11 = new EvictingDualNodeHashTable(64);
		field547 = -1;
		field368 = -1;
		field608 = new ArrayList();
		field651 = new class232();
		archiveLoaders = new ArrayList(10);
		archiveLoadersDone = 0;
		field551 = 0;
		field650 = new ApproximateRouteStrategy();
		field592 = new int[50];
		field593 = new int[50];
	}

	public Client() {
		this.field660 = false;
		this.field663 = 0;
		this.field667 = -1L;
	}

	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-953371865"
	)
	@Export("resizeGame")
	protected final void resizeGame() {
		field613 = GrandExchangeOfferTotalQuantityComparator.method1971() + 500L;
		this.resizeJS();
		if (rootInterface != -1) {
			this.method382(true);
		}

	}

	@ObfuscatedName("bb")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "-84"
	)
	@Export("setUp")
	protected final void setUp() {
		int[] var1 = new int[]{20, 260, 10000};
		int[] var2 = new int[]{1000, 100, 500};
		if (var1 != null && var2 != null) {
			ByteArrayPool.ByteArrayPool_alternativeSizes = var1;
			class425.ByteArrayPool_altSizeArrayCounts = new int[var1.length];
			class28.ByteArrayPool_arrays = new byte[var1.length][][];

			for (int var3 = 0; var3 < ByteArrayPool.ByteArrayPool_alternativeSizes.length; ++var3) {
				class28.ByteArrayPool_arrays[var3] = new byte[var2[var3]][];
				ByteArrayPool.field3766.add(var1[var3]);
			}

			Collections.sort(ByteArrayPool.field3766);
		} else {
			ByteArrayPool.ByteArrayPool_alternativeSizes = null;
			class425.ByteArrayPool_altSizeArrayCounts = null;
			class28.ByteArrayPool_arrays = null;
			ByteArrayPool.field3766.clear();
			ByteArrayPool.field3766.add(100);
			ByteArrayPool.field3766.add(5000);
			ByteArrayPool.field3766.add(10000);
			ByteArrayPool.field3766.add(30000);
		}

		ObjectComposition.worldPort = gameBuild == 0 ? 43594 : worldId + 40000;
		class363.js5Port = gameBuild == 0 ? 443 : worldId + 50000;
		class164.currentPort = ObjectComposition.worldPort;
		PlayerComposition.field2940 = class345.field2973;
		class104.field1093 = class345.field2975;
		Coord.field2906 = class345.field2974;
		class33.field87 = class345.field2976;
		AbstractWorldMapIcon.urlRequester = new class115(this.field660, 217);
		this.setUpKeyboard();
		this.method146();
		class493.mouseWheel = this.mouseWheel();
		this.method145(field422, 0);
		this.method145(keyHandlerInstance, 1);
		this.setUpClipboard();
		UserComparator10.field1188 = new ArchiveDisk(255, JagexCache.JagexCache_dat2File, JagexCache.JagexCache_idx255File, 500000);
		class91.clientPreferences = FadeInTask.method2164();
		class416.method2159(this, GraphicsObject.field717);
		NPCComposition.setWindowedMode(class91.clientPreferences.method562());
		InvDefinition.friendSystem = new FriendSystem(class166.loginType);
		this.field659 = new class14("tokenRequest", 1, 1);
		WorldMapIcon_1.method1439(this);
		field651.method1189();
	}

	@ObfuscatedName("bo")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-800201684"
	)
	@Export("doCycle")
	protected final void doCycle() {
		++cycle;
		this.doCycleJs5();
		Skills.method1899();
		boolean var1 = CollisionMap.method1157();
		if (var1 && playingJingle && class171.pcmPlayer1 != null) {
			class171.pcmPlayer1.tryDiscard();
		}

		class313.method1648();
		keyHandlerInstance.method1147();
		this.method144();
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

		if (class493.mouseWheel != null) {
			int var4 = class493.mouseWheel.useRotation();
			mouseWheelRotation = var4;
		}

		if (gameState == 0) {
			class314.method1653();
			class19.method66();
		} else if (gameState == 5) {
			WorldMapManager.method1521(this, class14.fontPlain11, UserComparator6.fontPlain12);
			class314.method1653();
			class19.method66();
		} else if (gameState != 10 && gameState != 11) {
			if (gameState == 20) {
				WorldMapManager.method1521(this, class14.fontPlain11, UserComparator6.fontPlain12);
				this.doCycleLoggedOut();
			} else if (gameState == 50) {
				WorldMapManager.method1521(this, class14.fontPlain11, UserComparator6.fontPlain12);
				this.doCycleLoggedOut();
			} else if (gameState == 25) {
				Occluder.method1341();
			}
		} else {
			WorldMapManager.method1521(this, class14.fontPlain11, UserComparator6.fontPlain12);
		}

		if (gameState == 30) {
			this.doCycleLoggedIn();
		} else if (gameState == 40 || gameState == 45) {
			this.doCycleLoggedOut();
		}

	}

	@ObfuscatedName("bp")
	@ObfuscatedSignature(
		descriptor = "(ZB)V",
		garbageValue = "40"
	)
	@Export("draw")
	protected final void draw(boolean var1) {
		if ((gameState == 10 || gameState == 20 || gameState == 30) && field613 != 0L && GrandExchangeOfferTotalQuantityComparator.method1971() > field613) {
			NPCComposition.setWindowedMode(class178.getWindowedMode());
		}

		int var2;
		if (var1) {
			for (var2 = 0; var2 < 100; ++var2) {
				field408[var2] = true;
			}
		}

		if (gameState == 0) {
			this.drawInitial(Login.Login_loadingPercent, Login.Login_loadingText, var1);
		} else if (gameState == 5) {
			class367.drawTitle(SoundCache.fontBold12, class14.fontPlain11, UserComparator6.fontPlain12);
		} else if (gameState != 10 && gameState != 11) {
			if (gameState == 20) {
				class367.drawTitle(SoundCache.fontBold12, class14.fontPlain11, UserComparator6.fontPlain12);
			} else if (gameState == 50) {
				class367.drawTitle(SoundCache.fontBold12, class14.fontPlain11, UserComparator6.fontPlain12);
			} else if (gameState == 25) {
				if (field453 == 1) {
					if (field454 > field456) {
						field456 = field454;
					}

					var2 = (field456 * 50 - field454 * 50) / field456;
					class427.drawLoadingMessage("Loading - please wait." + "<br>" + " (" + var2 + "%" + ")", false);
				} else if (field453 == 2) {
					if (field455 > field452) {
						field452 = field455;
					}

					var2 = (field452 * 50 - field455 * 50) / field452 + 50;
					class427.drawLoadingMessage("Loading - please wait." + "<br>" + " (" + var2 + "%" + ")", false);
				} else {
					class427.drawLoadingMessage("Loading - please wait.", false);
				}
			} else if (gameState == 30) {
				this.drawLoggedIn();
			} else if (gameState == 40) {
				class427.drawLoadingMessage("Connection lost" + "<br>" + "Please wait - attempting to reestablish", false);
			} else if (gameState == 45) {
				class427.drawLoadingMessage("Please wait...", false);
			}
		} else {
			class367.drawTitle(SoundCache.fontBold12, class14.fontPlain11, UserComparator6.fontPlain12);
		}

		if (gameState == 30 && gameDrawingMode == 0 && !var1 && !isResizable) {
			for (var2 = 0; var2 < rootWidgetCount; ++var2) {
				if (field407[var2]) {
					class223.rasterProvider.draw(rootWidgetXs[var2], rootWidgetYs[var2], rootWidgetWidths[var2], rootWidgetHeights[var2]);
					field407[var2] = false;
				}
			}
		} else if (gameState > 0) {
			class223.rasterProvider.drawFull(0, 0);

			for (var2 = 0; var2 < rootWidgetCount; ++var2) {
				field407[var2] = false;
			}
		}

	}

	@ObfuscatedName("bt")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "1875481219"
	)
	@Export("kill0")
	protected final void kill0() {
		if (class33.varcs.hasUnwrittenChanges()) {
			class33.varcs.write();
		}

		if (class233.mouseRecorder != null) {
			class233.mouseRecorder.isRunning = false;
		}

		class233.mouseRecorder = null;
		packetWriter.close();
		BufferedSink.method2304();
		class493.mouseWheel = null;
		if (class171.pcmPlayer1 != null) {
			class171.pcmPlayer1.shutdown();
		}

		class59.field309.method1969();
		WorldMapDecorationType.method1898();
		if (AbstractWorldMapIcon.urlRequester != null) {
			AbstractWorldMapIcon.urlRequester.close();
			AbstractWorldMapIcon.urlRequester = null;
		}

		HealthBar.method577();
		this.field659.method48();
	}

	@ObfuscatedName("bl")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "390692392"
	)
	@Export("vmethod1485")
	protected final void vmethod1485() {
	}

	@ObfuscatedName("gc")
	@ObfuscatedSignature(
		descriptor = "(S)Z",
		garbageValue = "28669"
	)
	boolean method356() {
		return this.field663 == 1;
	}

	@ObfuscatedName("ga")
	@ObfuscatedSignature(
		descriptor = "(B)Z",
		garbageValue = "-83"
	)
	boolean method357() {
		return class467.field3921 != null && !class467.field3921.trim().isEmpty() && class191.field1499 != null && !class191.field1499.trim().isEmpty();
	}

	@ObfuscatedName("gh")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "-1137874919"
	)
	boolean method358() {
		return LoginScreenAnimation.field1042 != null && !LoginScreenAnimation.field1042.trim().isEmpty() && class155.field1355 != null && !class155.field1355.trim().isEmpty();
	}

	@ObfuscatedName("gg")
	@ObfuscatedSignature(
		descriptor = "(B)Z",
		garbageValue = "2"
	)
	boolean method359() {
		return this.field661 != null;
	}

	@ObfuscatedName("gu")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;B)V",
		garbageValue = "-10"
	)
	void method360(String var1) throws IOException {
		HashMap var2 = new HashMap();
		var2.put("grant_type", "refresh_token");
		var2.put("scope", "gamesso.token.create");
		var2.put("refresh_token", var1);
		URL var3 = new URL(class59.field308 + "shield/oauth/token" + (new class478(var2)).method2383());
		class434 var4 = new class434();
		if (this.method356()) {
			var4.method2201(field655);
		} else {
			var4.method2201(field654);
		}

		var4.method2198("Host", (new URL(class59.field308)).getHost());
		var4.method2205(class475.field3933);
		class9 var5 = class9.field14;
		RefreshAccessTokenRequester var6 = this.field662;
		if (var6 != null) {
			this.field666 = var6.request(var5.method27(), var3, var4.method2197(), "");
		} else {
			class10 var7 = new class10(var3, var5, var4, this.field660);
			this.field657 = this.field659.method47(var7);
		}
	}

	@ObfuscatedName("go")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;I)V",
		garbageValue = "-2007713791"
	)
	void method361(String var1) throws IOException {
		URL var2 = new URL(class59.field308 + "public/v1/games/YCfdbvr2pM1zUYMxJRexZY/play");
		class434 var3 = new class434();
		var3.method2202(var1);
		class9 var4 = class9.field15;
		OtlTokenRequester var5 = this.field661;
		if (var5 != null) {
			this.field665 = var5.request(var4.method27(), var2, var3.method2197(), "");
		} else {
			class10 var6 = new class10(var2, var4, var3, this.field660);
			this.field658 = this.field659.method47(var6);
		}
	}

	@ObfuscatedName("hi")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;Ljava/lang/String;I)V",
		garbageValue = "-259118253"
	)
	void method362(String var1, String var2) throws IOException, JSONException {
		URL var3 = new URL(Actor.field959 + "game-session/v1/tokens");
		class10 var4 = new class10(var3, class9.field14, this.field660);
		var4.method31().method2202(var1);
		var4.method31().method2205(class475.field3933);
		JSONObject var5 = new JSONObject();
		var5.method2750("accountId", var2);
		var4.method32(new class477(var5));
		this.field658 = this.field659.method47(var4);
	}

	@ObfuscatedName("hm")
	@ObfuscatedSignature(
		descriptor = "(S)V",
		garbageValue = "-19583"
	)
	@Export("doCycleJs5")
	void doCycleJs5() {
		if (gameState != 1000) {
			boolean var1 = class59.field309.method1960();
			if (!var1) {
				this.method368();
			}

		}
	}

	@ObfuscatedName("hd")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "1822852781"
	)
	void method368() {
		if (class59.field309.field3607 >= 4) {
			this.error("js5crc");
			DefaultsGroup.updateGameState(1000);
		} else {
			if (class59.field309.field3606 >= 4) {
				if (gameState <= 5) {
					this.error("js5io");
					DefaultsGroup.updateGameState(1000);
					return;
				}

				js5Cycles = 3000;
				class59.field309.field3606 = 3;
			}

			if (--js5Cycles + 1 <= 0) {
				try {
					if (js5ConnectState == 0) {
						class199.js5SocketTask = GameEngine.taskHandler.newSocketTask(MouseHandler.worldHost, class164.currentPort);
						++js5ConnectState;
					}

					if (js5ConnectState == 1) {
						if (class199.js5SocketTask.status == 2) {
							this.js5Error(-1);
							return;
						}

						if (class199.js5SocketTask.status == 1) {
							++js5ConnectState;
						}
					}

					if (js5ConnectState == 2) {
						class162.js5Socket = WorldMapData_1.method1522((Socket)class199.js5SocketTask.result, 40000, 5000);
						Buffer var1 = new Buffer(5);
						var1.writeByte(15);
						var1.writeInt(217);
						class162.js5Socket.write(var1.array, 0, 5);
						++js5ConnectState;
						FloorDecoration.field1991 = GrandExchangeOfferTotalQuantityComparator.method1971();
					}

					if (js5ConnectState == 3) {
						if (class162.js5Socket.available() > 0) {
							int var2 = class162.js5Socket.readUnsignedByte();
							if (var2 != 0) {
								this.js5Error(var2);
								return;
							}

							++js5ConnectState;
						} else if (GrandExchangeOfferTotalQuantityComparator.method1971() - FloorDecoration.field1991 > 30000L) {
							this.js5Error(-2);
							return;
						}
					}

					if (js5ConnectState == 4) {
						class59.field309.method1962(class162.js5Socket, gameState > 20);
						class199.js5SocketTask = null;
						class162.js5Socket = null;
						js5ConnectState = 0;
						js5Errors = 0;
					}
				} catch (IOException var3) {
					this.js5Error(-3);
				}

			}
		}
	}

	@ObfuscatedName("hs")
	@ObfuscatedSignature(
		descriptor = "(IB)V",
		garbageValue = "5"
	)
	@Export("js5Error")
	void js5Error(int var1) {
		class199.js5SocketTask = null;
		class162.js5Socket = null;
		js5ConnectState = 0;
		if (class164.currentPort == ObjectComposition.worldPort) {
			class164.currentPort = class363.js5Port;
		} else {
			class164.currentPort = ObjectComposition.worldPort;
		}

		++js5Errors;
		if (js5Errors < 2 || var1 != 7 && var1 != 9) {
			if (js5Errors >= 2 && var1 == 6) {
				this.error("js5connect_outofdate");
				DefaultsGroup.updateGameState(1000);
			} else if (js5Errors >= 4) {
				if (gameState <= 5) {
					this.error("js5connect");
					DefaultsGroup.updateGameState(1000);
				} else {
					js5Cycles = 3000;
				}
			}
		} else if (gameState <= 5) {
			this.error("js5connect_full");
			DefaultsGroup.updateGameState(1000);
		} else {
			js5Cycles = 3000;
		}

	}

	@ObfuscatedName("hg")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "1"
	)
	@Export("doCycleLoggedOut")
	final void doCycleLoggedOut() {
		AbstractSocket var1 = packetWriter.getSocket();
		PacketBuffer var2 = packetWriter.packetBuffer;

		try {
			if (loginState == 0) {
				if (class224.secureRandom == null && (secureRandomFuture.isDone() || field444 > 250)) {
					class224.secureRandom = secureRandomFuture.get();
					secureRandomFuture.shutdown();
					secureRandomFuture = null;
				}

				if (class224.secureRandom != null) {
					if (var1 != null) {
						var1.close();
						var1 = null;
					}

					MouseHandler.socketTask = null;
					hadNetworkError = false;
					field444 = 0;
					if (field648.method2654()) {
						if (this.method357()) {
							try {
								this.method360(class191.field1499);
								class409.method2106(21);
							} catch (Throwable var24) {
								class190.RunException_sendStackTrace((String)null, var24);
								class198.getLoginError(65);
								return;
							}
						} else {
							if (!this.method358()) {
								class198.getLoginError(65);
								return;
							}

							try {
								this.method362(LoginScreenAnimation.field1042, class155.field1355);
								class409.method2106(20);
							} catch (Exception var23) {
								class190.RunException_sendStackTrace((String)null, var23);
								class198.getLoginError(65);
								return;
							}
						}
					} else {
						class409.method2106(1);
					}
				}
			}

			class20 var26;
			if (loginState == 21) {
				if (this.field666 != null) {
					if (!this.field666.isDone()) {
						return;
					}

					if (this.field666.isCancelled()) {
						class198.getLoginError(65);
						this.field666 = null;
						return;
					}

					try {
						RefreshAccessTokenResponse var3 = (RefreshAccessTokenResponse)this.field666.get();
						if (!var3.isSuccess()) {
							class198.getLoginError(65);
							this.field666 = null;
							return;
						}

						class467.field3921 = var3.getAccessToken();
						class191.field1499 = var3.getRefreshToken();
						this.field666 = null;
					} catch (Exception var22) {
						class190.RunException_sendStackTrace((String)null, var22);
						class198.getLoginError(65);
						this.field666 = null;
						return;
					}
				} else {
					if (this.field657 == null) {
						class198.getLoginError(65);
						return;
					}

					if (!this.field657.method61()) {
						return;
					}

					if (this.field657.method60()) {
						class190.RunException_sendStackTrace(this.field657.method59(), (Throwable)null);
						class198.getLoginError(65);
						this.field657 = null;
						return;
					}

					var26 = this.field657.method62();
					if (var26.method71() != 200) {
						class198.getLoginError(65);
						this.field657 = null;
						return;
					}

					field444 = 0;
					class477 var4 = new class477(var26.method73());

					try {
						class467.field3921 = var4.method2379().getString("access_token");
						class191.field1499 = var4.method2379().getString("refresh_token");
					} catch (Exception var21) {
						class190.RunException_sendStackTrace("Error parsing tokens", var21);
						class198.getLoginError(65);
						this.field657 = null;
						return;
					}
				}

				this.method361(class467.field3921);
				class409.method2106(20);
			}

			if (loginState == 20) {
				if (this.field665 != null) {
					if (!this.field665.isDone()) {
						return;
					}

					if (this.field665.isCancelled()) {
						class198.getLoginError(65);
						this.field665 = null;
						return;
					}

					try {
						OtlTokenResponse var27 = (OtlTokenResponse)this.field665.get();
						if (!var27.isSuccess()) {
							class198.getLoginError(65);
							this.field665 = null;
							return;
						}

						this.field664 = var27.getToken();
						this.field665 = null;
					} catch (Exception var20) {
						class190.RunException_sendStackTrace((String)null, var20);
						class198.getLoginError(65);
						this.field665 = null;
						return;
					}
				} else {
					if (this.field658 == null) {
						class198.getLoginError(65);
						return;
					}

					if (!this.field658.method61()) {
						return;
					}

					if (this.field658.method60()) {
						class190.RunException_sendStackTrace(this.field658.method59(), (Throwable)null);
						class198.getLoginError(65);
						this.field658 = null;
						return;
					}

					var26 = this.field658.method62();
					if (var26.method71() != 200) {
						class190.RunException_sendStackTrace("Response code: " + var26.method71() + "Response body: " + var26.method73(), (Throwable)null);
						class198.getLoginError(65);
						this.field658 = null;
						return;
					}

					List var29 = (List)var26.method72().get("Content-Type");
					if (var29 != null && var29.contains(class475.field3933.method2373())) {
						try {
							JSONObject var5 = new JSONObject(var26.method73());
							this.field664 = var5.getString("token");
						} catch (JSONException var19) {
							class190.RunException_sendStackTrace((String)null, var19);
							class198.getLoginError(65);
							this.field658 = null;
							return;
						}
					} else {
						this.field664 = var26.method73();
					}

					this.field658 = null;
				}

				field444 = 0;
				class409.method2106(1);
			}

			if (loginState == 1) {
				if (MouseHandler.socketTask == null) {
					MouseHandler.socketTask = GameEngine.taskHandler.newSocketTask(MouseHandler.worldHost, class164.currentPort);
				}

				if (MouseHandler.socketTask.status == 2) {
					throw new IOException();
				}

				if (MouseHandler.socketTask.status == 1) {
					var1 = WorldMapData_1.method1522((Socket)MouseHandler.socketTask.result, 40000, 5000);
					packetWriter.setSocket(var1);
					MouseHandler.socketTask = null;
					class409.method2106(2);
				}
			}

			PacketBufferNode var28;
			if (loginState == 2) {
				packetWriter.clearBuffer();
				var28 = class103.method599();
				var28.packetBuffer.writeByte(LoginPacket.field2762.id);
				packetWriter.addNode(var28);
				packetWriter.flush();
				var2.offset = 0;
				class409.method2106(3);
			}

			int var13;
			if (loginState == 3) {
				if (class171.pcmPlayer1 != null) {
					class171.pcmPlayer1.method209();
				}

				if (var1.isAvailable(1)) {
					var13 = var1.readUnsignedByte();
					if (class171.pcmPlayer1 != null) {
						class171.pcmPlayer1.method209();
					}

					if (var13 != 0) {
						class198.getLoginError(var13);
						return;
					}

					var2.offset = 0;
					class409.method2106(4);
				}
			}

			if (loginState == 4) {
				if (var2.offset < 8) {
					var13 = var1.available();
					if (var13 > 8 - var2.offset) {
						var13 = 8 - var2.offset;
					}

					if (var13 > 0) {
						var1.read(var2.array, var2.offset, var13);
						var2.offset += var13;
					}
				}

				if (var2.offset == 8) {
					var2.offset = 0;
					AttackOption.field1098 = var2.readLong();
					class409.method2106(5);
				}
			}

			int var6;
			if (loginState == 5) {
				packetWriter.packetBuffer.offset = 0;
				packetWriter.clearBuffer();
				PacketBuffer var30 = new PacketBuffer(500);
				int[] var31 = new int[]{class224.secureRandom.nextInt(), class224.secureRandom.nextInt(), class224.secureRandom.nextInt(), class224.secureRandom.nextInt()};
				var30.offset = 0;
				var30.writeByte(1);
				var30.writeInt(var31[0]);
				var30.writeInt(var31[1]);
				var30.writeInt(var31[2]);
				var30.writeInt(var31[3]);
				var30.writeLong(AttackOption.field1098);
				if (gameState == 40) {
					var30.writeInt(SecureRandomFuture.field809[0]);
					var30.writeInt(SecureRandomFuture.field809[1]);
					var30.writeInt(SecureRandomFuture.field809[2]);
					var30.writeInt(SecureRandomFuture.field809[3]);
				} else {
					if (gameState == 50) {
						var30.writeByte(class141.field1314.rsOrdinal());
						var30.writeInt(class153.field1352);
					} else {
						var30.writeByte(field419.rsOrdinal());
						switch(field419.field1317) {
						case 1:
							var30.offset += 4;
							break;
						case 2:
							var30.writeInt(class91.clientPreferences.method565(Login.Login_username));
							break;
						case 3:
						case 4:
							var30.writeMedium(ClientPreferences.field1059);
							++var30.offset;
						}
					}

					if (field648.method2654()) {
						var30.writeByte(class534.field4232.rsOrdinal());
						var30.writeStringCp1252NullTerminated(this.field664);
					} else {
						var30.writeByte(class534.field4231.rsOrdinal());
						var30.writeStringCp1252NullTerminated(Login.Login_password);
					}
				}

				var30.encryptRsa(class76.field738, class76.field739);
				SecureRandomFuture.field809 = var31;
				PacketBufferNode var34 = class103.method599();
				var34.packetBuffer.offset = 0;
				if (gameState == 40) {
					var34.packetBuffer.writeByte(LoginPacket.RECONNECT_LOGIN_CONNECTION.id);
				} else {
					var34.packetBuffer.writeByte(LoginPacket.NEW_LOGIN_CONNECTION.id);
				}

				var34.packetBuffer.writeShort(0);
				var6 = var34.packetBuffer.offset;
				var34.packetBuffer.writeInt(217);
				var34.packetBuffer.writeInt(1);
				var34.packetBuffer.writeByte(clientType);
				var34.packetBuffer.writeByte(field427);
				byte var7 = 0;
				var34.packetBuffer.writeByte(var7);
				var34.packetBuffer.writeBytes(var30.array, 0, var30.offset);
				int var8 = var34.packetBuffer.offset;
				var34.packetBuffer.writeStringCp1252NullTerminated(Login.Login_username);
				var34.packetBuffer.writeByte((isResizable ? 1 : 0) << 1 | (isLowDetail ? 1 : 0));
				var34.packetBuffer.writeShort(class340.canvasWidth);
				var34.packetBuffer.writeShort(class491.canvasHeight);
				PacketBuffer var9 = var34.packetBuffer;
				if (randomDatData != null) {
					var9.writeBytes(randomDatData, 0, randomDatData.length);
				} else {
					byte[] var10 = class131.method706();
					var9.writeBytes(var10, 0, var10.length);
				}

				var34.packetBuffer.writeStringCp1252NullTerminated(HealthBarDefinition.param9);
				var34.packetBuffer.writeInt(WorldMapIcon_1.field2337);
				if (param25 > 213) {
					var34.packetBuffer.writeByte(0);
				}

				Buffer var40 = new Buffer(Skeleton.field2060.size());
				Skeleton.field2060.write(var40);
				var34.packetBuffer.writeBytes(var40.array, 0, var40.array.length);
				var34.packetBuffer.writeByte(clientType);
				var34.packetBuffer.writeInt(0);
				var34.packetBuffer.writeInt(WorldMapDecorationType.field3154.hash);
				var34.packetBuffer.writeInt(class199.field1567.hash);
				var34.packetBuffer.writeIntIME(class199.archive8.hash);
				var34.packetBuffer.writeIntME(class241.field2052.hash);
				var34.packetBuffer.writeIntLE(class27.archive13.hash);
				var34.packetBuffer.writeIntLE(class469.field3930.hash);
				var34.packetBuffer.writeIntLE(SoundSystem.archive2.hash);
				var34.packetBuffer.writeIntME(class190.archive10.hash);
				var34.packetBuffer.writeIntIME(HorizontalAlignment.field1584.hash);
				var34.packetBuffer.writeIntME(GrandExchangeOfferOwnWorldComparator.field361.hash);
				var34.packetBuffer.writeInt(class358.field3177.hash);
				var34.packetBuffer.writeIntME(Language.field3643.hash);
				var34.packetBuffer.writeIntME(0);
				var34.packetBuffer.writeIntLE(AbstractByteArrayCopier.field3136.hash);
				var34.packetBuffer.writeIntLE(class198.archive9.hash);
				var34.packetBuffer.writeIntLE(AABB.field2123.hash);
				var34.packetBuffer.writeInt(ArchiveDiskAction.field3538.hash);
				var34.packetBuffer.writeIntLE(CollisionMap.archive6.hash);
				var34.packetBuffer.writeInt(SongTask.archive12.hash);
				var34.packetBuffer.writeIntLE(class317.field2776.hash);
				var34.packetBuffer.writeIntIME(class92.field888.hash);
				var34.packetBuffer.xteaEncrypt(var31, var8, var34.packetBuffer.offset);
				var34.packetBuffer.writeLengthShort(var34.packetBuffer.offset - var6);
				packetWriter.addNode(var34);
				packetWriter.flush();
				packetWriter.isaacCipher = new IsaacCipher(var31);
				int[] var11 = new int[4];

				for (int var12 = 0; var12 < 4; ++var12) {
					var11[var12] = var31[var12] + 50;
				}

				var2.newIsaacCipher(var11);
				class409.method2106(6);
			}

			int var14;
			if (loginState == 6 && var1.available() > 0) {
				var13 = var1.readUnsignedByte();
				if (var13 == 61) {
					var14 = var1.available();
					MusicPatchNode2.field2778 = var14 == 1 && var1.readUnsignedByte() == 1;
					class409.method2106(5);
				}

				if (var13 == 21 && gameState == 20) {
					class409.method2106(12);
				} else if (var13 == 2) {
					class409.method2106(14);
				} else if (var13 == 15 && gameState == 40) {
					packetWriter.serverPacketLength = -1;
					class409.method2106(19);
				} else if (var13 == 64) {
					class409.method2106(10);
				} else if (var13 == 23 && field448 < 1) {
					++field448;
					class409.method2106(0);
				} else if (var13 == 29) {
					class409.method2106(17);
				} else {
					if (var13 != 69) {
						class198.getLoginError(var13);
						return;
					}

					class409.method2106(7);
				}
			}

			if (loginState == 7 && var1.available() >= 2) {
				var1.read(var2.array, 0, 2);
				var2.offset = 0;
				class13.field35 = var2.readUnsignedShort();
				class409.method2106(8);
			}

			if (loginState == 8 && var1.available() >= class13.field35) {
				var2.offset = 0;
				var1.read(var2.array, var2.offset, class13.field35);
				class6[] var32 = new class6[]{class6.field4};
				class6 var33 = var32[var2.readUnsignedByte()];

				try {
					switch(var33.field6) {
					case 0:
						class0 var36 = new class0();
						this.field656 = new class7(var2, var36);
						class409.method2106(9);
						break;
					default:
						throw new IllegalArgumentException();
					}
				} catch (Exception var18) {
					class198.getLoginError(22);
					return;
				}
			}

			if (loginState == 9 && this.field656.method17()) {
				this.field668 = this.field656.method19();
				this.field656.method18();
				this.field656 = null;
				if (this.field668 == null) {
					class198.getLoginError(22);
					return;
				}

				packetWriter.clearBuffer();
				var28 = class103.method599();
				var28.packetBuffer.writeByte(LoginPacket.field2764.id);
				var28.packetBuffer.writeShort(this.field668.offset);
				var28.packetBuffer.writeBuffer(this.field668);
				packetWriter.addNode(var28);
				packetWriter.flush();
				this.field668 = null;
				class409.method2106(6);
			}

			if (loginState == 10 && var1.available() > 0) {
				class174.field1446 = var1.readUnsignedByte();
				class409.method2106(11);
			}

			if (loginState == 11 && var1.available() >= class174.field1446) {
				var1.read(var2.array, 0, class174.field1446);
				var2.offset = 0;
				class409.method2106(6);
			}

			if (loginState == 12 && var1.available() > 0) {
				field447 = (var1.readUnsignedByte() + 3) * 60;
				class409.method2106(13);
			}

			if (loginState == 13) {
				field444 = 0;
				AbstractWorldMapIcon.setLoginResponseString("You have only just left another world.", "Your profile will be transferred in:", field447 / 60 + " seconds.");
				if (--field447 <= 0) {
					class409.method2106(0);
				}

			} else {
				if (loginState == 14 && var1.available() >= 1) {
					Tiles.playerUUIDLength = var1.readUnsignedByte();
					class409.method2106(15);
				}

				if (loginState == 15 && var1.available() >= Tiles.playerUUIDLength) {
					boolean var42 = var1.readUnsignedByte() == 1;
					var1.read(var2.array, 0, 4);
					var2.offset = 0;
					boolean var41 = false;
					if (var42) {
						var14 = var2.readByteIsaac() << 24;
						var14 |= var2.readByteIsaac() << 16;
						var14 |= var2.readByteIsaac() << 8;
						var14 |= var2.readByteIsaac();
						class91.clientPreferences.method563(Login.Login_username, var14);
					}

					if (Login_isUsernameRemembered) {
						class91.clientPreferences.setUsernameToRemember(Login.Login_username);
					} else {
						class91.clientPreferences.setUsernameToRemember((String)null);
					}

					class144.savePreferences();
					staffModLevel = var1.readUnsignedByte();
					playerMod = var1.readUnsignedByte() == 1;
					localPlayerIndex = var1.readUnsignedByte();
					localPlayerIndex <<= 8;
					localPlayerIndex += var1.readUnsignedByte();
					isMembers = var1.readUnsignedByte();
					var1.read(var2.array, 0, 8);
					var2.offset = 0;
					this.field667 = var2.readLong();
					var1.read(var2.array, 0, 8);
					var2.offset = 0;
					playerUUID = var2.readLong();
					if (param25 >= 214) {
						var1.read(var2.array, 0, 8);
						var2.offset = 0;
						var2.readLong();
					}

					var1.read(var2.array, 0, 1);
					var2.offset = 0;
					ServerPacket[] var38 = class209.method1033();
					var6 = var2.readSmartByteShortIsaac();
					if (var6 < 0 || var6 >= var38.length) {
						throw new IOException(var6 + " " + var2.offset);
					}

					packetWriter.serverPacket = var38[var6];
					packetWriter.serverPacketLength = packetWriter.serverPacket.length;
					var1.read(var2.array, 0, 2);
					var2.offset = 0;
					packetWriter.serverPacketLength = var2.readUnsignedShort();

					try {
						Client var16 = class159.client;
						JSObject.getWindow(var16).call("zap", (Object[])null);
					} catch (Throwable var17) {
					}

					class409.method2106(16);
				}

				if (loginState == 16) {
					if (var1.available() >= packetWriter.serverPacketLength) {
						var2.offset = 0;
						var1.read(var2.array, 0, packetWriter.serverPacketLength);
						timer.method2185();
						MusicPatchNode2.method1658();
						class180.updatePlayer(var2);
						class94.timeOfPreviousKeyPress = -1;
						class151.loadRegions(false, var2);
						packetWriter.serverPacket = null;
					}

				} else {
					if (loginState == 17 && var1.available() >= 2) {
						var2.offset = 0;
						var1.read(var2.array, 0, 2);
						var2.offset = 0;
						ApproximateRouteStrategy.field359 = var2.readUnsignedShort();
						class409.method2106(18);
					}

					if (loginState == 18 && var1.available() >= ApproximateRouteStrategy.field359) {
						var2.offset = 0;
						var1.read(var2.array, 0, ApproximateRouteStrategy.field359);
						var2.offset = 0;
						String var37 = var2.readStringCp1252NullTerminated();
						String var35 = var2.readStringCp1252NullTerminated();
						String var39 = var2.readStringCp1252NullTerminated();
						AbstractWorldMapIcon.setLoginResponseString(var37, var35, var39);
						DefaultsGroup.updateGameState(10);
						if (field648.method2654()) {
							GameEngine.method166(9);
						}
					}

					if (loginState == 19) {
						if (packetWriter.serverPacketLength == -1) {
							if (var1.available() < 2) {
								return;
							}

							var1.read(var2.array, 0, 2);
							var2.offset = 0;
							packetWriter.serverPacketLength = var2.readUnsignedShort();
						}

						if (var1.available() >= packetWriter.serverPacketLength) {
							var1.read(var2.array, 0, packetWriter.serverPacketLength);
							var2.offset = 0;
							var13 = packetWriter.serverPacketLength;
							timer.method2187();
							MouseHandler.method178();
							class180.updatePlayer(var2);
							if (var13 != var2.offset) {
								throw new RuntimeException();
							}
						}
					} else {
						++field444;
						if (field444 > 2000) {
							if (field448 < 1) {
								if (ObjectComposition.worldPort == class164.currentPort) {
									class164.currentPort = class363.js5Port;
								} else {
									class164.currentPort = ObjectComposition.worldPort;
								}

								++field448;
								class409.method2106(0);
							} else {
								class198.getLoginError(-3);
							}
						}
					}
				}
			}
		} catch (IOException var25) {
			if (field448 < 1) {
				if (ObjectComposition.worldPort == class164.currentPort) {
					class164.currentPort = class363.js5Port;
				} else {
					class164.currentPort = ObjectComposition.worldPort;
				}

				++field448;
				class409.method2106(0);
			} else {
				class198.getLoginError(-2);
			}
		}
	}

	@ObfuscatedName("hw")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "1"
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
			class148.method781();
		} else {
			if (!isMenuOpen) {
				StudioGame.addCancelMenuEntry();
			}

			int var1;
			for (var1 = 0; var1 < 100 && this.method378(packetWriter); ++var1) {
			}

			if (gameState == 30) {
				while (true) {
					ReflectionCheck var2 = (ReflectionCheck)class36.reflectionChecks.last();
					boolean var41;
					if (var2 == null) {
						var41 = false;
					} else {
						var41 = true;
					}

					int var3;
					PacketBufferNode var42;
					if (!var41) {
						PacketBufferNode var20;
						int var21;
						if (timer.field3788) {
							var20 = ClanChannelMember.getPacketBufferNode(ClientPacket.LOGIN_TIMINGS, packetWriter.isaacCipher);
							var20.packetBuffer.writeByte(0);
							var21 = var20.packetBuffer.offset;
							timer.write(var20.packetBuffer);
							var20.packetBuffer.WriteLengthByte(var20.packetBuffer.offset - var21);
							packetWriter.addNode(var20);
							timer.method2186();
						}

						int var4;
						int var5;
						int var6;
						int var7;
						int var8;
						int var9;
						int var10;
						int var11;
						int var12;
						synchronized(class233.mouseRecorder.lock) {
							if (!lockMouseRecorder) {
								class233.mouseRecorder.index = 0;
							} else if (MouseHandler.MouseHandler_lastButton != 0 || class233.mouseRecorder.index >= 40) {
								var42 = null;
								var3 = 0;
								var4 = 0;
								var5 = 0;
								var6 = 0;

								for (var7 = 0; var7 < class233.mouseRecorder.index && (var42 == null || var42.packetBuffer.offset - var3 < 246); ++var7) {
									var4 = var7;
									var8 = class233.mouseRecorder.ys[var7];
									if (var8 < -1) {
										var8 = -1;
									} else if (var8 > 65534) {
										var8 = 65534;
									}

									var9 = class233.mouseRecorder.xs[var7];
									if (var9 < -1) {
										var9 = -1;
									} else if (var9 > 65534) {
										var9 = 65534;
									}

									if (var9 != lastMouseRecordX || var8 != lastMouseRecordY) {
										if (var42 == null) {
											var42 = ClanChannelMember.getPacketBufferNode(ClientPacket.f52, packetWriter.isaacCipher);
											var42.packetBuffer.writeByte(0);
											var3 = var42.packetBuffer.offset;
											PacketBuffer var10000 = var42.packetBuffer;
											var10000.offset += 2;
											var5 = 0;
											var6 = 0;
										}

										if (-1L != field610) {
											var10 = var9 - lastMouseRecordX;
											var11 = var8 - lastMouseRecordY;
											var12 = (int)((class233.mouseRecorder.millis[var7] - field610) / 20L);
											var5 = (int)((long)var5 + (class233.mouseRecorder.millis[var7] - field610) % 20L);
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
											var42.packetBuffer.writeShort((var12 << 12) + var11 + (var10 << 6));
										} else if (var12 < 32 && var10 >= -128 && var10 <= 127 && var11 >= -128 && var11 <= 127) {
											var10 += 128;
											var11 += 128;
											var42.packetBuffer.writeByte(var12 + 128);
											var42.packetBuffer.writeShort(var11 + (var10 << 8));
										} else if (var12 < 32) {
											var42.packetBuffer.writeByte(var12 + 192);
											if (var9 != -1 && var8 != -1) {
												var42.packetBuffer.writeInt(var9 | var8 << 16);
											} else {
												var42.packetBuffer.writeInt(Integer.MIN_VALUE);
											}
										} else {
											var42.packetBuffer.writeShort((var12 & 8191) + 57344);
											if (var9 != -1 && var8 != -1) {
												var42.packetBuffer.writeInt(var9 | var8 << 16);
											} else {
												var42.packetBuffer.writeInt(Integer.MIN_VALUE);
											}
										}

										++var6;
										field610 = class233.mouseRecorder.millis[var7];
									}
								}

								if (var42 != null) {
									var42.packetBuffer.WriteLengthByte(var42.packetBuffer.offset - var3);
									var7 = var42.packetBuffer.offset;
									var42.packetBuffer.offset = var3;
									var42.packetBuffer.writeByte(var5 / var6);
									var42.packetBuffer.writeByte(var5 % var6);
									var42.packetBuffer.offset = var7;
									packetWriter.addNode(var42);
								}

								if (var4 >= class233.mouseRecorder.index) {
									class233.mouseRecorder.index = 0;
								} else {
									MouseRecorder var58 = class233.mouseRecorder;
									var58.index -= var4;
									System.arraycopy(class233.mouseRecorder.xs, var4, class233.mouseRecorder.xs, 0, class233.mouseRecorder.index);
									System.arraycopy(class233.mouseRecorder.ys, var4, class233.mouseRecorder.ys, 0, class233.mouseRecorder.index);
									System.arraycopy(class233.mouseRecorder.millis, var4, class233.mouseRecorder.millis, 0, class233.mouseRecorder.index);
								}
							}
						}

						PacketBufferNode var24;
						if (MouseHandler.MouseHandler_lastButton == 1 || !UserComparator8.mouseCam && MouseHandler.MouseHandler_lastButton == 4 || MouseHandler.MouseHandler_lastButton == 2) {
							long var22 = MouseHandler.MouseHandler_lastPressedTimeMillis - mouseLastLastPressedTimeMillis;
							if (var22 > 32767L) {
								var22 = 32767L;
							}

							mouseLastLastPressedTimeMillis = MouseHandler.MouseHandler_lastPressedTimeMillis;
							var3 = MouseHandler.MouseHandler_lastPressedY;
							if (var3 < 0) {
								var3 = 0;
							} else if (var3 > class491.canvasHeight) {
								var3 = class491.canvasHeight;
							}

							var4 = MouseHandler.MouseHandler_lastPressedX;
							if (var4 < 0) {
								var4 = 0;
							} else if (var4 > class340.canvasWidth) {
								var4 = class340.canvasWidth;
							}

							var5 = (int)var22;
							if(shouldProcessClick()) {
								var24 = ClanChannelMember.getPacketBufferNode(ClientPacket.EVENT_MOUSE_CLICK, packetWriter.isaacCipher);
								var24.packetBuffer.writeShort((var5 << 1) + (MouseHandler.MouseHandler_lastButton == 2 ? 1 : 0));
								var24.packetBuffer.writeShort(var4);
								var24.packetBuffer.writeShort(var3);
								packetWriter.addNode(var24);
							}
						}

						if (mouseWheelRotation != 0) {
							var20 = ClanChannelMember.getPacketBufferNode(ClientPacket.f17, packetWriter.isaacCipher);
							var20.packetBuffer.writeShort(mouseWheelRotation);
							packetWriter.addNode(var20);
						}

						if (keyHandlerInstance.pressedKeysCount > 0) {
							var20 = ClanChannelMember.getPacketBufferNode(ClientPacket.EVENT_KEYBOARD, packetWriter.isaacCipher);
							var20.packetBuffer.writeShort(0);
							var21 = var20.packetBuffer.offset;
							long var25 = GrandExchangeOfferTotalQuantityComparator.method1971();

							for (var5 = 0; var5 < keyHandlerInstance.pressedKeysCount; ++var5) {
								long var27 = var25 - timeOfPreviousKeyPress;
								if (var27 > 16777215L) {
									var27 = 16777215L;
								}

								timeOfPreviousKeyPress = var25;
								var20.packetBuffer.writeByte(keyHandlerInstance.field1902[var5]);
								var20.packetBuffer.writeMediumLE((int)var27);
							}

							var20.packetBuffer.writeLengthShort(var20.packetBuffer.offset - var21);
							packetWriter.addNode(var20);
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
							var20 = ClanChannelMember.getPacketBufferNode(ClientPacket.EVENT_CAMERA_FOCUS, packetWriter.isaacCipher);
							var20.packetBuffer.writeShortLE(camAngleY);
							var20.packetBuffer.writeShortAddLE(camAngleX);
							packetWriter.addNode(var20);
						}

						if (KeyHandler.hasFocus && !hadFocus) {
							hadFocus = true;
							var20 = ClanChannelMember.getPacketBufferNode(ClientPacket.EVENT_APPLET_FOCUS, packetWriter.isaacCipher);
							var20.packetBuffer.writeByte(1);
							packetWriter.addNode(var20);
						}

						if (!KeyHandler.hasFocus && hadFocus) {
							hadFocus = false;
							var20 = ClanChannelMember.getPacketBufferNode(ClientPacket.EVENT_APPLET_FOCUS, packetWriter.isaacCipher);
							var20.packetBuffer.writeByte(0);
							packetWriter.addNode(var20);
						}

						if (class434.worldMap != null) {
							class434.worldMap.method2422();
						}

						class143.method759();
						if (PcmPlayer.field180) {
							for (var1 = 0; var1 < Players.Players_count; ++var1) {
								Player var43 = players[Players.Players_indices[var1]];
								var43.clearIsInClanChat();
							}

							PcmPlayer.field180 = false;
						}

						if (field539 != class87.Client_plane) {
							field539 = class87.Client_plane;
							class87.method463(class87.Client_plane);
						}

						if (gameState != 30) {
							return;
						}

						UserComparator8.method669();
						class73.method423();
						++packetWriter.field1152;
						if (packetWriter.field1152 > 750) {
							class148.method781();
							return;
						}

						class139.method745();

						for (var1 = 0; var1 < npcCount; ++var1) {
							var21 = npcIndices[var1];
							NPC var29 = npcs[var21];
							if (var29 != null) {
								class6.updateActorSequence(var29, var29.definition.size);
							}
						}

						int[] var49 = Players.Players_indices;

						for (var21 = 0; var21 < Players.Players_count; ++var21) {
							Player var52 = players[var49[var21]];
							if (var52 != null && var52.overheadTextCyclesRemaining > 0) {
								--var52.overheadTextCyclesRemaining;
								if (var52.overheadTextCyclesRemaining == 0) {
									var52.overheadText = null;
								}
							}
						}

						for (var21 = 0; var21 < npcCount; ++var21) {
							var3 = npcIndices[var21];
							NPC var30 = npcs[var3];
							if (var30 != null && var30.overheadTextCyclesRemaining > 0) {
								--var30.overheadTextCyclesRemaining;
								if (var30.overheadTextCyclesRemaining == 0) {
									var30.overheadText = null;
								}
							}
						}

						++field460;
						if (mouseCrossColor != 0) {
							mouseCrossState += 20;
							if (mouseCrossState >= 400) {
								mouseCrossColor = 0;
							}
						}

						Widget var50 = class64.mousedOverWidgetIf1;
						Widget var44 = GrandExchangeOfferNameComparator.field3615;
						class64.mousedOverWidgetIf1 = null;
						GrandExchangeOfferNameComparator.field3615 = null;
						draggedOnWidget = null;
						field394 = false;
						field396 = false;
						field533 = 0;

						while (keyHandlerInstance.method1148() && field533 < 128) {
							if (staffModLevel >= 2 && keyHandlerInstance.getKeyPressed(82) && keyHandlerInstance.field1901 == 66) {
								String var53 = RouteStrategy.method1170();
								class159.client.method141(var53);
							} else if (oculusOrbState != 1 || keyHandlerInstance.field1899 <= 0) {
								field577[field533] = keyHandlerInstance.field1901;
								field578[field533] = keyHandlerInstance.field1899;
								++field533;
							}
						}

						boolean var45 = staffModLevel >= 2;
						PacketBufferNode var31;
						if (var45 && keyHandlerInstance.getKeyPressed(82) && keyHandlerInstance.getKeyPressed(81) && mouseWheelRotation != 0) {
							var4 = TextureProvider.localPlayer.plane - mouseWheelRotation;
							if (var4 < 0) {
								var4 = 0;
							} else if (var4 > 3) {
								var4 = 3;
							}

							if (var4 != TextureProvider.localPlayer.plane) {
								var5 = TextureProvider.localPlayer.pathX[0] + class20.baseX;
								var6 = TextureProvider.localPlayer.pathY[0] + class19.baseY;
								var31 = ClanChannelMember.getPacketBufferNode(ClientPacket.f20, packetWriter.isaacCipher);
								var31.packetBuffer.writeShortAddLE(var5);
								var31.packetBuffer.writeShortLE(var6);
								var31.packetBuffer.writeInt(0);
								var31.packetBuffer.writeByteAdd(var4);
								packetWriter.addNode(var31);
							}

							mouseWheelRotation = 0;
						}

						if (MouseHandler.MouseHandler_lastButton == 1) {
							field422.method1134();
						}

						if (rootInterface != -1) {
							class511.updateRootInterface(rootInterface, 0, 0, class340.canvasWidth, class491.canvasHeight, 0, 0);
						}

						++cycleCntr;

						while (true) {
							Widget var32;
							Widget var51;
							ScriptEvent var54;
							do {
								var54 = (ScriptEvent)field628.removeLast();
								if (var54 == null) {
									while (true) {
										do {
											var54 = (ScriptEvent)field629.removeLast();
											if (var54 == null) {
												while (true) {
													do {
														var54 = (ScriptEvent)scriptEvents.removeLast();
														if (var54 == null) {
															while (true) {
																while (true) {
																	class225 var55;
																	do {
																		do {
																			do {
																				var55 = (class225)field626.removeLast();
																				if (var55 == null) {
																					this.menu();
																					class30.method124();
																					if (clickedWidget != null) {
																						this.method384();
																					}

																					if (Scene.shouldSendWalk()) {
																						var4 = Scene.Scene_selectedX;
																						var5 = Scene.Scene_selectedY;
																						var24 = ClanChannelMember.getPacketBufferNode(ClientPacket.MOVE_GAMECLICK, packetWriter.isaacCipher);
																						var24.packetBuffer.writeByte(5);
																						var24.packetBuffer.writeShortAdd(var5 + class19.baseY);
																						var24.packetBuffer.writeByte(keyHandlerInstance.getKeyPressed(82) ? (keyHandlerInstance.getKeyPressed(81) ? 2 : 1) : 0);
																						var24.packetBuffer.writeShortAdd(var4 + class20.baseX);
																						packetWriter.addNode(var24);
																						Scene.method1319();
																						mouseCrossX = MouseHandler.MouseHandler_lastPressedX;
																						mouseCrossY = MouseHandler.MouseHandler_lastPressedY;
																						mouseCrossColor = 1;
																						mouseCrossState = 0;
																						destinationX = var4;
																						destinationY = var5;
																					}

																					if (var50 != class64.mousedOverWidgetIf1) {
																						if (var50 != null) {
																							ClanChannelMember.invalidateWidget(var50);
																						}

																						if (class64.mousedOverWidgetIf1 != null) {
																							ClanChannelMember.invalidateWidget(class64.mousedOverWidgetIf1);
																						}
																					}

																					if (var44 != GrandExchangeOfferNameComparator.field3615 && field498 == field499) {
																						if (var44 != null) {
																							ClanChannelMember.invalidateWidget(var44);
																						}

																						if (GrandExchangeOfferNameComparator.field3615 != null) {
																							ClanChannelMember.invalidateWidget(GrandExchangeOfferNameComparator.field3615);
																						}
																					}

																					if (GrandExchangeOfferNameComparator.field3615 != null) {
																						if (field498 < field499) {
																							++field498;
																							if (field498 == field499) {
																								ClanChannelMember.invalidateWidget(GrandExchangeOfferNameComparator.field3615);
																							}
																						}
																					} else if (field498 > 0) {
																						--field498;
																					}

																					if (oculusOrbState == 0) {
																						var4 = TextureProvider.localPlayer.x;
																						var5 = TextureProvider.localPlayer.y;
																						if (ChatChannel.oculusOrbFocalPointX - var4 < -500 || ChatChannel.oculusOrbFocalPointX - var4 > 500 || AbstractWorldMapData.oculusOrbFocalPointY - var5 < -500 || AbstractWorldMapData.oculusOrbFocalPointY - var5 > 500) {
																							ChatChannel.oculusOrbFocalPointX = var4;
																							AbstractWorldMapData.oculusOrbFocalPointY = var5;
																						}

																						if (var4 != ChatChannel.oculusOrbFocalPointX) {
																							ChatChannel.oculusOrbFocalPointX += (var4 - ChatChannel.oculusOrbFocalPointX) / 16;
																						}

																						if (var5 != AbstractWorldMapData.oculusOrbFocalPointY) {
																							AbstractWorldMapData.oculusOrbFocalPointY += (var5 - AbstractWorldMapData.oculusOrbFocalPointY) / 16;
																						}

																						var6 = ChatChannel.oculusOrbFocalPointX >> 7;
																						var7 = AbstractWorldMapData.oculusOrbFocalPointY >> 7;
																						var8 = class115.getTileHeight(ChatChannel.oculusOrbFocalPointX, AbstractWorldMapData.oculusOrbFocalPointY, class87.Client_plane);
																						var9 = 0;
																						if (var6 > 3 && var7 > 3 && var6 < 100 && var7 < 100) {
																							for (var10 = var6 - 4; var10 <= var6 + 4; ++var10) {
																								for (var11 = var7 - 4; var11 <= var7 + 4; ++var11) {
																									var12 = class87.Client_plane;
																									if (var12 < 3 && (Tiles.Tiles_renderFlags[1][var10][var11] & 2) == 2) {
																										++var12;
																									}

																									int var34 = var8 - Tiles.Tiles_heights[var12][var10][var11];
																									if (var34 > var9) {
																										var9 = var34;
																									}
																								}
																							}
																						}

																						var10 = var9 * 192;
																						if (var10 > 98048) {
																							var10 = 98048;
																						}

																						if (var10 < 32768) {
																							var10 = 32768;
																						}

																						if (var10 > field476) {
																							field476 += (var10 - field476) / 24;
																						} else if (var10 < field476) {
																							field476 += (var10 - field476) / 80;
																						}

																						class433.field3789 = class115.getTileHeight(TextureProvider.localPlayer.x, TextureProvider.localPlayer.y, class87.Client_plane) - camFollowHeight;
																					} else if (oculusOrbState == 1) {
																						if (oculusOrbOnLocalPlayer && TextureProvider.localPlayer != null) {
																							var4 = TextureProvider.localPlayer.pathX[0];
																							var5 = TextureProvider.localPlayer.pathY[0];
																							if (var4 >= 0 && var5 >= 0 && var4 < 104 && var5 < 104) {
																								ChatChannel.oculusOrbFocalPointX = TextureProvider.localPlayer.x;
																								var6 = class115.getTileHeight(TextureProvider.localPlayer.x, TextureProvider.localPlayer.y, class87.Client_plane) - camFollowHeight;
																								if (var6 < class433.field3789) {
																									class433.field3789 = var6;
																								}

																								AbstractWorldMapData.oculusOrbFocalPointY = TextureProvider.localPlayer.y;
																								oculusOrbOnLocalPlayer = false;
																							}
																						}

																						short var47 = -1;
																						if (keyHandlerInstance.getKeyPressed(33)) {
																							var47 = 0;
																						} else if (keyHandlerInstance.getKeyPressed(49)) {
																							var47 = 1024;
																						}

																						if (keyHandlerInstance.getKeyPressed(48)) {
																							if (var47 == 0) {
																								var47 = 1792;
																							} else if (var47 == 1024) {
																								var47 = 1280;
																							} else {
																								var47 = 1536;
																							}
																						} else if (keyHandlerInstance.getKeyPressed(50)) {
																							if (var47 == 0) {
																								var47 = 256;
																							} else if (var47 == 1024) {
																								var47 = 768;
																							} else {
																								var47 = 512;
																							}
																						}

																						byte var48 = 0;
																						if (keyHandlerInstance.getKeyPressed(35)) {
																							var48 = -1;
																						} else if (keyHandlerInstance.getKeyPressed(51)) {
																							var48 = 1;
																						}

																						var6 = 0;
																						if (var47 >= 0 || var48 != 0) {
																							var6 = keyHandlerInstance.getKeyPressed(81) ? oculusOrbSlowedSpeed * -872637063 * -4178743 : oculusOrbNormalSpeed * -199987921 * -2029520433;
																							var6 *= 16;
																							field466 = var47;
																							field477 = var48;
																						}

																						if (field478 < var6) {
																							field478 += var6 / 8;
																							if (field478 > var6) {
																								field478 = var6;
																							}
																						} else if (field478 > var6) {
																							field478 = field478 * 9 / 10;
																						}

																						if (field478 > 0) {
																							var7 = field478 / 16;
																							if (field466 >= 0) {
																								var4 = field466 - WallDecoration.cameraYaw & 2047;
																								var8 = Rasterizer3D.Rasterizer3D_sine[var4];
																								var9 = Rasterizer3D.Rasterizer3D_cosine[var4];
																								ChatChannel.oculusOrbFocalPointX += var7 * var8 / 65536;
																								AbstractWorldMapData.oculusOrbFocalPointY += var9 * var7 / 65536;
																							}

																							if (field477 != 0) {
																								class433.field3789 += var7 * field477;
																								if (class433.field3789 > 0) {
																									class433.field3789 = 0;
																								}
																							}
																						} else {
																							field466 = -1;
																							field477 = -1;
																						}

																						if (keyHandlerInstance.getKeyPressed(13)) {
																							class425.method2178();
																						}
																					}

																					if (MouseHandler.MouseHandler_currentButton == 4 && UserComparator8.mouseCam) {
																						var4 = MouseHandler.MouseHandler_y - field470;
																						camAngleDX = var4 * 2;
																						field470 = var4 != -1 && var4 != 1 ? (MouseHandler.MouseHandler_y + field470) / 2 : MouseHandler.MouseHandler_y * 397181729 * -167198495;
																						var5 = field467 - MouseHandler.MouseHandler_x;
																						camAngleDY = var5 * 2;
																						field467 = var5 != -1 && var5 != 1 ? (field467 + MouseHandler.MouseHandler_x) / 2 : MouseHandler.MouseHandler_x * -963425685 * 44569155;
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

																						field470 = MouseHandler.MouseHandler_y;
																						field467 = MouseHandler.MouseHandler_x;
																					}

																					camAngleY = camAngleDY / 2 + camAngleY & 2047;
																					camAngleX += camAngleDX / 2;
																					if (camAngleX < 128) {
																						camAngleX = 128;
																					}

																					if (camAngleX > 383) {
																						camAngleX = 383;
																					}

																					if (field400) {
																						WorldMapSectionType.method1555(AbstractUserComparator.field3834, TriBool.field3849, JagexCache.field1450);
																						Projectile.method438(class14.field36, GrandExchangeOfferOwnWorldComparator.field360);
																						if (AbstractUserComparator.field3834 == cameraX && class17.cameraY == TriBool.field3849 && JagexCache.field1450 == WorldMapArea.cameraZ && class14.field36 == class365.cameraPitch && WallDecoration.cameraYaw == GrandExchangeOfferOwnWorldComparator.field360) {
																							field400 = false;
																							isCameraLocked = false;
																							field402 = false;
																							field401 = false;
																							class148.cameraLookAtX = 0;
																							BufferedNetSocket.cameraLookAtY = 0;
																							class161.cameraLookAtHeight = 0;
																							class232.cameraLookAtSpeed = 0;
																							class465.cameraLookAtAcceleration = 0;
																							class131.cameraMoveToAcceleration = 0;
																							SecureRandomCallable.cameraMoveToSpeed = 0;
																							class191.cameraMoveToX = 0;
																							MouseHandler.cameraMoveToY = 0;
																							SoundSystem.cameraMoveToHeight = 0;
																							field646 = null;
																							field642 = null;
																							field643 = null;
																						}
																					} else if (isCameraLocked) {
																						PcmPlayer.method221();
																					}

																					for (var4 = 0; var4 < 5; ++var4) {
																						int var10002 = cameraShakeCycle[var4]++;
																					}

																					class33.varcs.tryWrite();
																					var4 = ++MouseHandler.MouseHandler_idleCycles - 1;
																					var6 = BuddyRankComparator.method688();
																					if (var4 > 15000 && var6 > 15000) {
																						logoutTimer = 250;
																						class138.method733(14500);
																						var31 = ClanChannelMember.getPacketBufferNode(ClientPacket.EVENT_MOUSE_IDLE, packetWriter.isaacCipher);
																						packetWriter.addNode(var31);
																					}

																					InvDefinition.friendSystem.processFriendUpdates();

																					for (var7 = 0; var7 < field608.size(); ++var7) {
																						var9 = (Integer)field608.get(var7);
																						class139 var35 = (class139)SequenceDefinition.SequenceDefinition_cachedModel.get((long)var9);
																						class139 var36;
																						if (var35 != null) {
																							var36 = var35;
																						} else {
																							AbstractArchive var13 = SequenceDefinition.SequenceDefinition_animationsArchive;
																							AbstractArchive var14 = SequenceDefinition.SequenceDefinition_skeletonsArchive;
																							boolean var15 = true;
																							byte[] var16 = var13.getFile(var9 >> 16 & 65535, var9 & 65535);
																							class139 var37;
																							if (var16 == null) {
																								var15 = false;
																								var37 = null;
																							} else {
																								int var17 = (var16[1] & 255) << 8 | var16[2] & 255;
																								byte[] var18 = var14.getFile(var17, 0);
																								if (var18 == null) {
																									var15 = false;
																								}

																								if (!var15) {
																									var37 = null;
																								} else {
																									if (SoundCache.field214 == null) {
																										MusicPatchPcmStream.field2855 = Runtime.getRuntime().availableProcessors();
																										SoundCache.field214 = new ThreadPoolExecutor(0, MusicPatchPcmStream.field2855, 0L, TimeUnit.MILLISECONDS, new ArrayBlockingQueue(MusicPatchPcmStream.field2855 * 100 + 100), new class64(this));
																									}

																									try {
																										var37 = new class139(var13, var14, var9, false);
																									} catch (Exception var39) {
																										var37 = null;
																									}
																								}
																							}

																							if (var37 != null) {
																								SequenceDefinition.SequenceDefinition_cachedModel.put(var37, (long)var9);
																							}

																							var36 = var37;
																						}

																						if (var36 == null) {
																							var8 = 2;
																						} else {
																							var8 = var36.method738() ? 0 : 1;
																						}

																						if (var8 != 2) {
																							field608.remove(var7);
																							--var7;
																						}
																					}

																					++packetWriter.pendingWrites;
																					if (packetWriter.pendingWrites > 50) {
																						var31 = ClanChannelMember.getPacketBufferNode(ClientPacket.NO_TIMEOUT, packetWriter.isaacCipher);
																						packetWriter.addNode(var31);
																					}

																					try {
																						packetWriter.flush();
																					} catch (IOException var38) {
																						class148.method781();
																					}

																					return;
																				}
																			} while(var55 == null);
																		} while(var55.field1888 == null);

																		if (var55.field1888.childIndex < 0) {
																			break;
																		}

																		var32 = class33.widgetDefinition.method1740(var55.field1888.parentId);
																	} while(var32 == null || var32.children == null || var32.children.length == 0 || var55.field1888.childIndex >= var32.children.length || var55.field1888 != var32.children[var55.field1888.childIndex]);

																	if (var55.field1888.type == 11 && var55.field1886 == 0) {
																		if (var55.field1888.method1866(var55.field1885, var55.field1887, 0, 0)) {
																			switch(var55.field1888.method1870()) {
																			case 0:
																				VertexNormal.openURL(var55.field1888.method1872(), true, false);
																				break;
																			case 1:
																				var6 = MouseRecorder.getWidgetFlags(var55.field1888);
																				boolean var46 = (var6 >> 22 & 1) != 0;
																				if (var46) {
																					int[] var56 = var55.field1888.method1873();
																					if (var56 != null) {
																						PacketBufferNode var33 = ClanChannelMember.getPacketBufferNode(ClientPacket.f11, packetWriter.isaacCipher);
																						var33.packetBuffer.writeShortLE(var55.field1888.childIndex);
																						var33.packetBuffer.writeInt(var55.field1888.method1871());
																						var33.packetBuffer.writeIntLE(var55.field1888.id);
																						var33.packetBuffer.writeIntIME(var56[1]);
																						var33.packetBuffer.writeIntME(var56[0]);
																						var33.packetBuffer.writeIntME(var56[2]);
																						packetWriter.addNode(var33);
																					}
																				}
																			}
																		}
																	} else if (var55.field1888.type == 12) {
																		class344 var57 = var55.field1888.method1877();
																		if (var57 != null && var57.method1815()) {
																			switch(var55.field1886) {
																			case 0:
																				field422.method1132(var55.field1888);
																				var57.method1763(true);
																				var57.method1802(var55.field1885, var55.field1887, keyHandlerInstance.getKeyPressed(82), keyHandlerInstance.getKeyPressed(81));
																				break;
																			case 1:
																				var57.method1803(var55.field1885, var55.field1887);
																			}
																		}
																	}
																}
															}
														}

														var32 = var54.widget;
														if (var32.childIndex < 0) {
															break;
														}

														var51 = class33.widgetDefinition.method1740(var32.parentId);
													} while(var51 == null || var51.children == null || var32.childIndex >= var51.children.length || var32 != var51.children[var32.childIndex]);

													Interpreter.runScriptEvent(var54);
												}
											}

											var32 = var54.widget;
											if (var32.childIndex < 0) {
												break;
											}

											var51 = class33.widgetDefinition.method1740(var32.parentId);
										} while(var51 == null || var51.children == null || var32.childIndex >= var51.children.length || var32 != var51.children[var32.childIndex]);

										Interpreter.runScriptEvent(var54);
									}
								}

								var32 = var54.widget;
								if (var32.childIndex < 0) {
									break;
								}

								var51 = class33.widgetDefinition.method1740(var32.parentId);
							} while(var51 == null || var51.children == null || var32.childIndex >= var51.children.length || var32 != var51.children[var32.childIndex]);

							Interpreter.runScriptEvent(var54);
						}
					}

					var42 = ClanChannelMember.getPacketBufferNode(ClientPacket.REFLECTION_CHECK_REPLY, packetWriter.isaacCipher);
					var42.packetBuffer.writeByte(0);
					var3 = var42.packetBuffer.offset;
					class305.performReflectionCheck(var42.packetBuffer);
					var42.packetBuffer.WriteLengthByte(var42.packetBuffer.offset - var3);
					packetWriter.addNode(var42);
				}
			}
		}
	}

	@ObfuscatedName("ix")
	@ObfuscatedSignature(
		descriptor = "(III)V",
		garbageValue = "328818380"
	)
	@Export("vmethod1644")
	public void vmethod1644(int var1, int var2) {
		if (packetWriter != null && packetWriter.isaacCipher != null) {
			if (var1 > -1 && class91.clientPreferences.getCurrentMusicVolume() > 0 && !playingJingle) {
				PacketBufferNode var3 = ClanChannelMember.getPacketBufferNode(ClientPacket.SOUND_SONGEND, packetWriter.isaacCipher);
				var3.packetBuffer.writeInt(var1);
				packetWriter.addNode(var3);
			}

		}
	}

	@ObfuscatedName("ia")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-1844765006"
	)
	@Export("resizeJS")
	void resizeJS() {
		int var1 = class340.canvasWidth;
		int var2 = class491.canvasHeight;
		if (super.contentWidth < var1) {
			var1 = super.contentWidth;
		}

		if (super.contentHeight < var2) {
			var2 = super.contentHeight;
		}

		if (class91.clientPreferences != null) {
			try {
				Client var3 = class159.client;
				Object[] var4 = new Object[]{class178.getWindowedMode()};
				JSObject.getWindow(var3).call("resize", var4);
			} catch (Throwable var5) {
			}
		}

	}

	@ObfuscatedName("id")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "4"
	)
	@Export("drawLoggedIn")
	final void drawLoggedIn() {
		if (rootInterface != -1) {
			class178.method926(rootInterface);
		}

		int var1;
		for (var1 = 0; var1 < rootWidgetCount; ++var1) {
			if (field408[var1]) {
				field407[var1] = true;
			}

			field406[var1] = field408[var1];
			field408[var1] = false;
		}

		field523 = cycle;
		viewportX = -1;
		viewportY = -1;
		if (rootInterface != -1) {
			rootWidgetCount = 0;
			class410.drawWidgets(rootInterface, 0, 0, class340.canvasWidth, class491.canvasHeight, 0, 0, -1);
		}

		Rasterizer2D.Rasterizer2D_resetClip();
		if (showMouseCross) {
			if (mouseCrossColor == 1) {
				EnumComposition.crossSprites[mouseCrossState / 100].drawTransBgAt(mouseCrossX - 8, mouseCrossY - 8);
			}

			if (mouseCrossColor == 2) {
				EnumComposition.crossSprites[mouseCrossState / 100 + 4].drawTransBgAt(mouseCrossX - 8, mouseCrossY - 8);
			}
		}

		int var2;
		int var3;
		int var4;
		int var6;
		int var7;
		int var8;
		if (!isMenuOpen) {
			if (viewportX != -1) {
				class135.method730(viewportX, viewportY);
			}
		} else {
			var1 = class28.menuX;
			var2 = class463.menuY;
			var3 = class341.menuWidth;
			var4 = Language.menuHeight;
			int var5 = 6116423;
			Rasterizer2D.Rasterizer2D_fillRectangle(var1, var2, var3, var4, var5);
			Rasterizer2D.Rasterizer2D_fillRectangle(var1 + 1, var2 + 1, var3 - 2, 16, 0);
			Rasterizer2D.Rasterizer2D_drawRectangle(var1 + 1, var2 + 18, var3 - 2, var4 - 19, 0);
			SoundCache.fontBold12.draw("Choose Option", var1 + 3, var2 + 14, var5, -1);
			var6 = MouseHandler.MouseHandler_x;
			var7 = MouseHandler.MouseHandler_y;

			int var9;
			int var10;
			for (var8 = 0; var8 < menuOptionsCount; ++var8) {
				var9 = (menuOptionsCount - 1 - var8) * 15 + var2 + 31;
				var10 = 16777215;
				if (var6 > var1 && var6 < var3 + var1 && var7 > var9 - 13 && var7 < var9 + 3) {
					var10 = 16776960;
				}

				SoundCache.fontBold12.draw(class169.method882(var8), var1 + 3, var9, var10, 0);
			}

			var8 = class28.menuX;
			var9 = class463.menuY;
			var10 = class341.menuWidth;
			int var11 = Language.menuHeight;

			for (int var12 = 0; var12 < rootWidgetCount; ++var12) {
				if (rootWidgetWidths[var12] + rootWidgetXs[var12] > var8 && rootWidgetXs[var12] < var10 + var8 && rootWidgetHeights[var12] + rootWidgetYs[var12] > var9 && rootWidgetYs[var12] < var9 + var11) {
					field407[var12] = true;
				}
			}
		}

		if (gameDrawingMode == 3) {
			for (var1 = 0; var1 < rootWidgetCount; ++var1) {
				if (field406[var1]) {
					Rasterizer2D.Rasterizer2D_fillRectangleAlpha(rootWidgetXs[var1], rootWidgetYs[var1], rootWidgetWidths[var1], rootWidgetHeights[var1], 16711935, 128);
				} else if (field407[var1]) {
					Rasterizer2D.Rasterizer2D_fillRectangleAlpha(rootWidgetXs[var1], rootWidgetYs[var1], rootWidgetWidths[var1], rootWidgetHeights[var1], 16711680, 128);
				}
			}
		}

		var1 = class87.Client_plane;
		var2 = TextureProvider.localPlayer.x;
		var3 = TextureProvider.localPlayer.y;
		var4 = field460;

		for (ObjectSound var13 = (ObjectSound)ObjectSound.objectSounds.last(); var13 != null; var13 = (ObjectSound)ObjectSound.objectSounds.previous()) {
			if (var13.soundEffectId != -1 || var13.soundEffectIds != null) {
				var6 = 0;
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

				if (var6 - 64 <= var13.field696 && class91.clientPreferences.getAreaSoundEffectsVolume() != 0 && var1 == var13.plane) {
					var6 -= 64;
					if (var6 < 0) {
						var6 = 0;
					}

					var7 = (var13.field696 - var6) * class91.clientPreferences.getAreaSoundEffectsVolume() / var13.field696;
					Object var10000;
					if (var13.stream1 == null) {
						if (var13.soundEffectId >= 0) {
							var10000 = null;
							SoundEffect var14 = SoundEffect.readSoundEffect(class469.field3930, var13.soundEffectId, 0);
							if (var14 != null) {
								RawSound var15 = var14.toRawSound().resample(class136.decimator);
								RawPcmStream var16 = RawPcmStream.createRawPcmStream(var15, 100, var7);
								var16.setNumLoops(-1);
								class140.pcmStreamMixer.addSubStream(var16);
								var13.stream1 = var16;
							}
						}
					} else {
						var13.stream1.method247(var7);
					}

					if (var13.stream2 == null) {
						if (var13.soundEffectIds != null && (var13.field695 -= var4) <= 0) {
							var8 = (int)(Math.random() * (double)var13.soundEffectIds.length);
							var10000 = null;
							SoundEffect var18 = SoundEffect.readSoundEffect(class469.field3930, var13.soundEffectIds[var8], 0);
							if (var18 != null) {
								RawSound var19 = var18.toRawSound().resample(class136.decimator);
								RawPcmStream var17 = RawPcmStream.createRawPcmStream(var19, 100, var7);
								var17.setNumLoops(0);
								class140.pcmStreamMixer.addSubStream(var17);
								var13.stream2 = var17;
								var13.field695 = var13.field697 + (int)(Math.random() * (double)(var13.field690 - var13.field697));
							}
						}
					} else {
						var13.stream2.method247(var7);
						if (!var13.stream2.hasNext()) {
							var13.stream2 = null;
						}
					}
				} else {
					if (var13.stream1 != null) {
						class140.pcmStreamMixer.removeSubStream(var13.stream1);
						var13.stream1 = null;
					}

					if (var13.stream2 != null) {
						class140.pcmStreamMixer.removeSubStream(var13.stream2);
						var13.stream2 = null;
					}
				}
			}
		}

		field460 = 0;
	}

	@ObfuscatedName("kr")
	@ObfuscatedSignature(
		descriptor = "(Lez;IS)Z",
		garbageValue = "-3136"
	)
	boolean method376(PacketWriter var1, int var2) {
		if (var1.serverPacketLength == 0) {
			class358.friendsChat = null;
		} else {
			if (class358.friendsChat == null) {
				class358.friendsChat = new FriendsChat(class166.loginType, class159.client);
			}

			class358.friendsChat.method2234(var1.packetBuffer, var2);
		}

		UserComparator10.method685();
		var1.serverPacket = null;
		return true;
	}

	@ObfuscatedName("kg")
	@ObfuscatedSignature(
		descriptor = "(Lez;I)Z",
		garbageValue = "-1216543487"
	)
	boolean method377(PacketWriter var1) {
		if (class358.friendsChat != null) {
			class358.friendsChat.method2235(var1.packetBuffer);
		}

		UserComparator10.method685();
		var1.serverPacket = null;
		return true;
	}

	@ObfuscatedName("kq")
	@ObfuscatedSignature(
		descriptor = "(Lez;I)Z",
		garbageValue = "1463612350"
	)
	final boolean method378(PacketWriter var1) {
		AbstractSocket var2 = var1.getSocket();
		PacketBuffer var3 = var1.packetBuffer;
		if (var2 == null) {
			return false;
		} else {
			String var21;
			int var22;
			try {
				int var5;
				if (var1.serverPacket == null) {
					if (var1.field1148) {
						if (!var2.isAvailable(1)) {
							return false;
						}

						var2.read(var1.packetBuffer.array, 0, 1);
						var1.field1152 = 0;
						var1.field1148 = false;
					}

					var3.offset = 0;
					if (var3.method2552()) {
						if (!var2.isAvailable(1)) {
							return false;
						}

						var2.read(var1.packetBuffer.array, 1, 1);
						var1.field1152 = 0;
					}

					var1.field1148 = true;
					ServerPacket[] var4 = class209.method1033();
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
				var1.field1152 = 0;
				timer.method2182();
				var1.field1156 = var1.field1154;
				var1.field1154 = var1.field1153;
				var1.field1153 = var1.serverPacket;
				if (ServerPacket.UPDATE_UID192 == var1.serverPacket) {
					return this.method376(var1, 1);
				}

				byte var72;
				if (ServerPacket.IF_SETMODEL == var1.serverPacket) {
					class172.method908();
					var72 = var3.readByte();
					class148 var83 = new class148(var3);
					ClanSettings var67;
					if (var72 >= 0) {
						var67 = currentClanSettings[var72];
					} else {
						var67 = VerticalAlignment.guestClanSettings;
					}

					if (var67 == null) {
						this.method387(var72);
						var1.serverPacket = null;
						return true;
					}

					if (var83.field1335 > var67.field1375) {
						this.method387(var72);
						var1.serverPacket = null;
						return true;
					}

					if (var83.field1335 < var67.field1375) {
						var1.serverPacket = null;
						return true;
					}

					var83.method777(var67);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.IF_SETANIM == var1.serverPacket) {
					class172.method908();
					var72 = var3.readByte();
					if (var1.serverPacketLength == 1) {
						if (var72 >= 0) {
							currentClanSettings[var72] = null;
						} else {
							VerticalAlignment.guestClanSettings = null;
						}

						var1.serverPacket = null;
						return true;
					}

					if (var72 >= 0) {
						currentClanSettings[var72] = new ClanSettings(var3);
					} else {
						VerticalAlignment.guestClanSettings = new ClanSettings(var3);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.MESSAGE_CLANCHANNEL_SYSTEM == var1.serverPacket) {
					UrlRequest.processZoneOperation(ZoneOperation.field2623);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2675 == var1.serverPacket) {
					class332.updateNpcs(true, var3);
					var1.serverPacket = null;
					return true;
				}

				int var7;
				int var8;
				int var20;
				if (ServerPacket.LOC_DEL == var1.serverPacket) {
					var22 = var3.readUnsignedShortAdd();
					var7 = var3.readIntME();
					var8 = var3.readUnsignedShortAdd();
					var5 = var3.readUnsignedShort();
					var20 = var3.readUnsignedShortAdd();
					if (var20 == 65535) {
						var20 = -1;
					}

					ArrayList var56 = new ArrayList();
					var56.add(var20);
					class202.method1006(var56, var5, var22, var7, var8);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2649 == var1.serverPacket) {
					isCameraLocked = true;
					field400 = false;
					field401 = true;
					var20 = NPC.method597(var3.readShort() & 2027);
					var5 = class153.method800(var3.readShort() & 2027);
					var22 = var3.readUnsignedShort();
					var7 = var3.readUnsignedByte();
					field642 = new class493(class365.cameraPitch, var5, var22, var7);
					field643 = new class493(WallDecoration.cameraYaw, var20, var22, var7);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.OBJ_COUNT == var1.serverPacket) {
					UrlRequest.processZoneOperation(ZoneOperation.LOC_ANIM);
					var1.serverPacket = null;
					return true;
				}

				Widget var6;
				if (ServerPacket.RESET_CLIENT_VARCACHE == var1.serverPacket) {
					var20 = var3.readInt();
					var21 = var3.readStringCp1252NullTerminated();
					var6 = class33.widgetDefinition.method1740(var20);
					if (!var21.equals(var6.text)) {
						var6.text = var21;
						ClanChannelMember.invalidateWidget(var6);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.CAM_LOOKAT_EASED_ANGLE_RELATIVE == var1.serverPacket) {
					var22 = var3.readUnsignedByteNeg();
					var5 = var3.readIntME();
					var20 = var3.readUnsignedShortAdd();
					if (var5 == 65535) {
						var5 = -1;
					}

					NPC var86 = npcs[var20];
					if (var86 != null) {
						if (var5 == var86.sequence && var5 != -1) {
							var8 = class36.SequenceDefinition_get(var5).replyMode;
							if (var8 == 1) {
								var86.sequenceFrame = 0;
								var86.sequenceFrameCycle = 0;
								var86.sequenceDelay = var22;
								var86.currentSequenceFrameIndex = 0;
							} else if (var8 == 2) {
								var86.currentSequenceFrameIndex = 0;
							}
						} else if (var5 == -1 || var86.sequence == -1 || class36.SequenceDefinition_get(var5).forcedPriority >= class36.SequenceDefinition_get(var86.sequence).forcedPriority) {
							var86.sequence = var5;
							var86.sequenceFrame = 0;
							var86.sequenceFrameCycle = 0;
							var86.sequenceDelay = var22;
							var86.currentSequenceFrameIndex = 0;
							var86.field1023 = var86.pathLength;
						}
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.LOGOUT_FULL == var1.serverPacket) {
					var20 = var3.readIntME();
					GrandExchangeOfferUnitPriceComparator.method1994(var20);
					changedItemContainers[++changedItemContainersCount - 1 & 31] = var20 & 32767;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.CAM_MOVETO_EASED == var1.serverPacket) {
					for (var20 = 0; var20 < VarpDefinition.field1501; ++var20) {
						VarpDefinition var82 = class150.VarpDefinition_get(var20);
						if (var82 != null) {
							Varps.Varps_temp[var20] = 0;
							Varps.Varps_main[var20] = 0;
						}
					}

					class304.method1636();
					changedVarpCount += 32;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.SYNTH_SOUND == var1.serverPacket) {
					UrlRequest.processZoneOperation(ZoneOperation.field2619);
					var1.serverPacket = null;
					return true;
				}

				String var55;
				if (ServerPacket.UPDATE_FRIENDCHAT_CHANNEL_FULL_V2 == var1.serverPacket) {
					byte[] var54 = new byte[var1.serverPacketLength];
					var3.method2554(var54, 0, var54.length);
					Buffer var80 = new Buffer(var54);
					var55 = var80.readStringCp1252NullTerminated();
					VertexNormal.openURL(var55, true, false);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.TOGGLE_OCULUS_ORB == var1.serverPacket) {
					var20 = var3.readUnsignedByteSub();
					var5 = var3.readUnsignedShortAddLE();
					if (var5 == 65535) {
						var5 = -1;
					}

					WorldMapEvent.performPlayerAnimation(TextureProvider.localPlayer, var5, var20);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.CAM_MOVETO == var1.serverPacket) {
					var20 = var3.readUnsignedIntME();
					var5 = var3.readIntME();
					var6 = class33.widgetDefinition.method1740(var20);
					if (var6.modelType != 1 || var5 != var6.modelId) {
						var6.modelType = 1;
						var6.modelId = var5;
						ClanChannelMember.invalidateWidget(var6);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.CHAT_FILTER_SETTINGS_PRIVATECHAT == var1.serverPacket) {
					var20 = var3.readUnsignedByte();
					var5 = var3.readUnsignedByte();
					var22 = var3.readUnsignedByte();
					var7 = var3.readUnsignedByte();
					cameraShaking[var20] = true;
					cameraShakeIntensity[var20] = var5;
					cameraMoveIntensity[var20] = var22;
					cameraShakeSpeed[var20] = var7;
					cameraShakeCycle[var20] = 0;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.LOGOUT == var1.serverPacket) {
					field400 = false;
					isCameraLocked = false;
					field402 = false;
					field401 = false;
					class148.cameraLookAtX = 0;
					BufferedNetSocket.cameraLookAtY = 0;
					class161.cameraLookAtHeight = 0;
					field403 = false;
					class232.cameraLookAtSpeed = 0;
					class465.cameraLookAtAcceleration = 0;
					class131.cameraMoveToAcceleration = 0;
					SecureRandomCallable.cameraMoveToSpeed = 0;
					class191.cameraMoveToX = 0;
					MouseHandler.cameraMoveToY = 0;
					SoundSystem.cameraMoveToHeight = 0;
					field646 = null;
					field642 = null;
					field643 = null;

					for (var20 = 0; var20 < 5; ++var20) {
						cameraShaking[var20] = false;
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.CAM_RESET == var1.serverPacket) {
					if (rootInterface != -1) {
						Interpreter.method418(rootInterface, 0);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.IF_SETPLAYERHEAD == var1.serverPacket) {
					class304.method1636();
					runEnergy = var3.readUnsignedShort();
					field527 = cycleCntr;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.OBJ_DEL == var1.serverPacket) {
					var20 = var3.readUnsignedIntLE();
					var5 = var3.readUnsignedByteAdd();
					var6 = class33.widgetDefinition.method1740(var20);
					UrlRequester.method653(var6, TextureProvider.localPlayer.appearance.field2950, var5);
					ClanChannelMember.invalidateWidget(var6);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.IF_SETPLAYERMODEL_SELF == var1.serverPacket) {
					var20 = var3.readInt();
					var5 = var3.readInt();
					var22 = TileItem.getGcDuration();
					PacketBufferNode var84 = ClanChannelMember.getPacketBufferNode(ClientPacket.PING_STATS, packetWriter.isaacCipher);
					var84.packetBuffer.writeIntME(var20);
					var84.packetBuffer.writeIntIME(var5);
					var84.packetBuffer.writeByte(var22);
					var84.packetBuffer.writeByteNeg(GameEngine.fps);
					packetWriter.addNode(var84);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.NPC_ANIM_SPECIFIC == var1.serverPacket) {
					UrlRequest.processZoneOperation(ZoneOperation.PREFETCH_GAMEOBJECTS);
					var1.serverPacket = null;
					return true;
				}

				int var10;
				int var24;
				if (ServerPacket.field2744 == var1.serverPacket) {
					isCameraLocked = true;
					field400 = false;
					field401 = false;
					class148.cameraLookAtX = var3.readUnsignedByte();
					BufferedNetSocket.cameraLookAtY = var3.readUnsignedByte();
					class161.cameraLookAtHeight = var3.readUnsignedShort();
					class232.cameraLookAtSpeed = var3.readUnsignedByte();
					class465.cameraLookAtAcceleration = var3.readUnsignedByte();
					if (class465.cameraLookAtAcceleration >= 100) {
						var20 = class148.cameraLookAtX * 128 + 64;
						var5 = BufferedNetSocket.cameraLookAtY * 128 + 64;
						var22 = class115.getTileHeight(var20, var5, class87.Client_plane) - class161.cameraLookAtHeight;
						var7 = var20 - cameraX;
						var8 = var22 - class17.cameraY;
						var24 = var5 - WorldMapArea.cameraZ;
						var10 = (int)Math.sqrt((double)(var24 * var24 + var7 * var7));
						class365.cameraPitch = (int)(Math.atan2((double)var8, (double)var10) * 325.9490051269531D) & 2047;
						WallDecoration.cameraYaw = (int)(Math.atan2((double)var7, (double)var24) * -325.9490051269531D) & 2047;
						if (class365.cameraPitch < 128) {
							class365.cameraPitch = 128;
						}

						if (class365.cameraPitch > 383) {
							class365.cameraPitch = 383;
						}
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.HEAT_MAP == var1.serverPacket) {
					var20 = var3.readUnsignedShortAdd();
					var5 = var3.readUnsignedIntIME();
					var6 = class33.widgetDefinition.method1740(var5);
					if (var6.modelType != 6 || var20 != var6.modelId) {
						var6.modelType = 6;
						var6.modelId = var20;
						ClanChannelMember.invalidateWidget(var6);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.CAM_MOVETO_EASED_CIRCULAR == var1.serverPacket) {
					var20 = var3.readUnsignedByte();
					if (var3.readUnsignedByte() == 0) {
						grandExchangeOffers[var20] = new GrandExchangeOffer();
						var3.offset += 18;
					} else {
						--var3.offset;
						grandExchangeOffers[var20] = new GrandExchangeOffer(var3, false);
					}

					field529 = cycleCntr;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.UPDATE_ZONE_PARTIAL_ENCLOSED == var1.serverPacket) {
					class304.method1636();
					weight = var3.readShort();
					field527 = cycleCntr;
					var1.serverPacket = null;
					return true;
				}

				Widget var79;
				if (ServerPacket.VARCLAN == var1.serverPacket) {
					var20 = var3.readUnsignedIntLE();
					var79 = class33.widgetDefinition.method1740(var20);
					var79.modelType = 3;
					var79.modelId = TextureProvider.localPlayer.appearance.getChatHeadId();
					ClanChannelMember.invalidateWidget(var79);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.MIDI_SWAP == var1.serverPacket) {
					tradeChatMode = var3.readUnsignedByte();
					publicChatMode = var3.readUnsignedByteNeg();
					var1.serverPacket = null;
					return true;
				}

				boolean var11;
				long var25;
				long var27;
				long var29;
				String var31;
				int var68;
				int var69;
				if (ServerPacket.IF_SETPLAYERMODEL_BASECOLOUR == var1.serverPacket) {
					var72 = var3.readByte();
					var25 = (long)var3.readUnsignedShort();
					var27 = (long)var3.readMedium();
					var29 = var27 + (var25 << 32);
					var11 = false;
					ClanChannel var63 = var72 >= 0 ? currentClanChannels[var72] : ClanChannelMember.guestClanChannel;
					if (var63 == null) {
						var11 = true;
					} else {
						for (var68 = 0; var68 < 100; ++var68) {
							if (crossWorldMessageIds[var68] == var29) {
								var11 = true;
								break;
							}
						}
					}

					if (!var11) {
						crossWorldMessageIds[crossWorldMessageIdsIndex] = var29;
						crossWorldMessageIdsIndex = (crossWorldMessageIdsIndex + 1) % 100;
						var31 = class172.readString(var3);
						var69 = var72 >= 0 ? 43 : 46;
						class164.addChatMessage(var69, "", var31, var63.name);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.UPDATE_FRIENDLIST == var1.serverPacket) {
					var1.serverPacket = null;
					return true;
				}

				int var15;
				int var16;
				int var17;
				int var18;
				Projectile var19;
				int var60;
				byte var62;
				byte var85;
				int var87;
				if (ServerPacket.field2730 == var1.serverPacket) {
					var17 = var3.readUnsignedByte();
					var60 = var3.method2629();
					var62 = var3.readByte();
					var69 = var3.readUnsignedByteAdd() * 4;
					var18 = var3.readUnsignedByte();
					var68 = var3.readUnsignedByteNeg() * 4;
					var87 = var3.readUnsignedShortAddLE();
					var22 = var3.method2628();
					var20 = var22 >> 16;
					var5 = var22 >> 8 & 255;
					var7 = var20 + (var22 >> 4 & 7);
					var8 = var5 + (var22 & 7);
					var16 = var3.readIntME();
					var15 = var3.readUnsignedShortAddLE();
					var85 = var3.readByte();
					var24 = var85 + var7;
					var10 = var62 + var8;
					if (var7 >= 0 && var8 >= 0 && var7 < 104 && var8 < 104 && var24 >= 0 && var10 >= 0 && var24 < 104 && var10 < 104 && var87 != 65535) {
						var7 = var7 * 128 + 64;
						var8 = var8 * 128 + 64;
						var24 = var24 * 128 + 64;
						var10 = var10 * 128 + 64;
						var19 = new Projectile(var87, class87.Client_plane, var7, var8, class115.getTileHeight(var7, var8, class87.Client_plane) - var68, var15 + cycle, var16 + cycle, var17, var18, var60, var69);
						var19.setDestination(var24, var10, class115.getTileHeight(var24, var10, class87.Client_plane) - var69, var15 + cycle);
						projectiles.addFirst(var19);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.MIDI_SONG_WITH_SECONDARY == var1.serverPacket) {
					class151.loadRegions(true, var1.packetBuffer);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.LOC_ANIM_SPECIFIC == var1.serverPacket) {
					InvDefinition.friendSystem.ignoreList.read(var3, var1.serverPacketLength);
					class492.FriendSystem_invalidateIgnoreds();
					field511 = cycleCntr;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.IF_SETEVENTS == var1.serverPacket) {
					UrlRequest.processZoneOperation(ZoneOperation.OBJ_COUNT);
					var1.serverPacket = null;
					return true;
				}

				Widget var23;
				if (ServerPacket.REFLECTIONCHECK_FRIENDLIST == var1.serverPacket) {
					var20 = var3.readInt();
					var5 = var3.readIntME();
					if (var5 == 65535) {
						var5 = -1;
					}

					var22 = var3.readUnsignedIntIME();
					var23 = class33.widgetDefinition.method1740(var22);
					ItemComposition var92;
					if (!var23.isIf3) {
						if (var5 == -1) {
							var23.modelType = 0;
							var1.serverPacket = null;
							return true;
						}

						var92 = class214.ItemDefinition_get(var5).getCountObj(var20);
						var23.modelType = 4;
						var23.modelId = var5;
						var23.modelAngleX = var92.xan2d;
						var23.modelAngleY = var92.yan2d;
						var23.modelZoom = var92.zoom2d * 100 / var20;
						ClanChannelMember.invalidateWidget(var23);
					} else {
						var23.itemId = var5;
						var23.itemQuantity = var20;
						var92 = class214.ItemDefinition_get(var5).getCountObj(var20);
						var23.modelAngleX = var92.xan2d;
						var23.modelAngleY = var92.yan2d;
						var23.modelAngleZ = var92.zan2d;
						var23.modelOffsetX = var92.offsetX2d;
						var23.modelOffsetY = var92.offsetY2d;
						var23.modelZoom = var92.zoom2d;
						if (var92.isStackable == 1) {
							var23.itemQuantityMode = 1;
						} else {
							var23.itemQuantityMode = 2;
						}

						if (var23.modelRotation > 0) {
							var23.modelZoom = var23.modelZoom * 32 / var23.modelRotation;
						} else if (var23.rawWidth > 0) {
							var23.modelZoom = var23.modelZoom * 32 / var23.rawWidth;
						}

						ClanChannelMember.invalidateWidget(var23);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2755 == var1.serverPacket) {
					UrlRequest.processZoneOperation(ZoneOperation.MAPPROJ_ANIM);
					var1.serverPacket = null;
					return true;
				}

				Widget var33;
				InterfaceParent var78;
				if (ServerPacket.MIDI_SONG == var1.serverPacket) {
					var20 = var3.readInt();
					var5 = var3.readUnsignedIntIME();
					InterfaceParent var65 = (InterfaceParent)interfaceParents.get((long)var20);
					var78 = (InterfaceParent)interfaceParents.get((long)var5);
					if (var78 != null) {
						ArchiveDisk.closeInterface(var78, var65 == null || var65.group != var78.group);
					}

					if (var65 != null) {
						var65.remove();
						interfaceParents.put(var65, (long)var5);
					}

					var33 = class33.widgetDefinition.method1740(var20);
					if (var33 != null) {
						ClanChannelMember.invalidateWidget(var33);
					}

					var33 = class33.widgetDefinition.method1740(var5);
					if (var33 != null) {
						ClanChannelMember.invalidateWidget(var33);
						PendingSpawn.revalidateWidgetScroll(class33.widgetDefinition.Widget_interfaceComponents[var33.id >>> 16], var33, true);
					}

					if (rootInterface != -1) {
						Interpreter.method418(rootInterface, 1);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.MESSAGE_PRIVATE == var1.serverPacket) {
					field528 = cycleCntr;
					var72 = var3.readByte();
					if (var1.serverPacketLength == 1) {
						if (var72 >= 0) {
							currentClanChannels[var72] = null;
						} else {
							ClanChannelMember.guestClanChannel = null;
						}

						var1.serverPacket = null;
						return true;
					}

					if (var72 >= 0) {
						currentClanChannels[var72] = new ClanChannel(var3);
					} else {
						ClanChannelMember.guestClanChannel = new ClanChannel(var3);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.RUN_CLIENTSCRIPT == var1.serverPacket) {
					var20 = var3.readUnsignedShortAdd();
					var5 = var3.readUnsignedByteNeg();
					var22 = var3.readUnsignedIntLE();
					var78 = (InterfaceParent)interfaceParents.get((long)var22);
					if (var78 != null) {
						ArchiveDisk.closeInterface(var78, var20 != var78.group);
					}

					ClanChannel.ifOpenSub(var22, var20, var5);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.NPC_HEADICON_SPECIFIC == var1.serverPacket) {
					minimapState = var3.readUnsignedByte();
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.IF_SETPLAYERMODEL_BODYTYPE == var1.serverPacket) {
					SequenceDefinition.varclan = new class469(class53.Widget_cachedFonts);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.MIDI_JINGLE == var1.serverPacket) {
					var20 = var3.readUnsignedIntIME();
					var79 = class33.widgetDefinition.method1740(var20);

					for (var22 = 0; var22 < var79.field3082.length; ++var22) {
						var79.field3082[var22] = -1;
						var79.field3082[var22] = 0;
					}

					ClanChannelMember.invalidateWidget(var79);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.SET_PLAYER_OP == var1.serverPacket) {
					isCameraLocked = true;
					field400 = false;
					field401 = true;
					class148.cameraLookAtX = var3.readUnsignedByte();
					BufferedNetSocket.cameraLookAtY = var3.readUnsignedByte();
					class161.cameraLookAtHeight = var3.readUnsignedShort();
					var20 = var3.readUnsignedShort();
					var5 = var3.readUnsignedByte();
					var22 = class148.cameraLookAtX * 128 + 64;
					var7 = BufferedNetSocket.cameraLookAtY * 128 + 64;
					var8 = class115.getTileHeight(var22, var7, class87.Client_plane) - class161.cameraLookAtHeight;
					var24 = var22 - cameraX;
					var10 = var8 - class17.cameraY;
					var60 = var7 - WorldMapArea.cameraZ;
					double var91 = Math.sqrt((double)(var60 * var60 + var24 * var24));
					var69 = class153.method800((int)(Math.atan2((double)var10, var91) * 325.9490051269531D) & 2047);
					var15 = NPC.method597((int)(Math.atan2((double)var24, (double)var60) * -325.9490051269531D) & 2047);
					field642 = new class493(class365.cameraPitch, var69, var20, var5);
					field643 = new class493(WallDecoration.cameraYaw, var15, var20, var5);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.LOGIN_SCREEN_PACKET == var1.serverPacket) {
					var5 = var3.readUnsignedShortAddLE();
					var20 = var3.readIntME();
					ItemComposition.method1088(var20, var5);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.PLAYER_SPOTANIM_SPECIFIC == var1.serverPacket) {
					class332.updateNpcs(false, var3);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.IF_OPENTOP == var1.serverPacket) {
					var24 = var3.readUnsignedShortAddLE();
					var10 = var3.readUnsignedByteNeg();
					var22 = var3.method2628();
					var20 = var22 >> 16;
					var5 = var22 >> 8 & 255;
					var7 = var20 + (var22 >> 4 & 7);
					var8 = var5 + (var22 & 7);
					var60 = var3.readUnsignedShortAdd();
					if (var7 >= 0 && var8 >= 0 && var7 < 104 && var8 < 104) {
						var7 = var7 * 128 + 64;
						var8 = var8 * 128 + 64;
						GraphicsObject var12 = new GraphicsObject(var24, class87.Client_plane, var7, var8, class115.getTileHeight(var7, var8, class87.Client_plane) - var10, var60, cycle);
						graphicsObjects.addFirst(var12);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.VARCLAN_ENABLE == var1.serverPacket) {
					var20 = var3.readUnsignedByte();
					class180.method934(var20);
					var1.serverPacket = null;
					return true;
				}

				String var50;
				if (ServerPacket.UPDATE_REBOOT_TIMER == var1.serverPacket) {
					var50 = var3.readStringCp1252NullTerminated();
					Object[] var77 = new Object[var50.length() + 1];

					for (var22 = var50.length() - 1; var22 >= 0; --var22) {
						if (var50.charAt(var22) == 's') {
							var77[var22 + 1] = var3.readStringCp1252NullTerminated();
						} else {
							var77[var22 + 1] = new Integer(var3.readInt());
						}
					}

					var77[0] = new Integer(var3.readInt());
					ScriptEvent var64 = new ScriptEvent();
					var64.args = var77;
					Interpreter.runScriptEvent(var64);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.SET_MAP_FLAG == var1.serverPacket) {
					field528 = cycleCntr;
					var72 = var3.readByte();
					class162 var76 = new class162(var3);
					ClanChannel var59;
					if (var72 >= 0) {
						var59 = currentClanChannels[var72];
					} else {
						var59 = ClanChannelMember.guestClanChannel;
					}

					if (var59 == null) {
						this.method386(var72);
						var1.serverPacket = null;
						return true;
					}

					if (var76.field1404 > var59.field1417) {
						this.method386(var72);
						var1.serverPacket = null;
						return true;
					}

					if (var76.field1404 < var59.field1417) {
						var1.serverPacket = null;
						return true;
					}

					var76.method851(var59);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.IF_SETANGLE == var1.serverPacket) {
					var20 = var3.readUnsignedShortAdd();
					if (var20 == 65535) {
						var20 = -1;
					}

					rootInterface = var20;
					this.method382(false);
					class357.method1901(var20);
					VerticalAlignment.runWidgetOnLoadListener(rootInterface);

					for (var5 = 0; var5 < 100; ++var5) {
						field408[var5] = true;
					}

					var1.serverPacket = null;
					return true;
				}

				boolean var32;
				if (ServerPacket.UPDATE_IGNORELIST == var1.serverPacket) {
					var50 = var3.readStringCp1252NullTerminated();
					var25 = (long)var3.readUnsignedShort();
					var27 = (long)var3.readMedium();
					PlayerType var9 = (PlayerType)SequenceDefinition.findEnumerated(class183.PlayerType_values(), var3.readUnsignedByte());
					long var36 = var27 + (var25 << 32);
					var32 = false;

					for (var68 = 0; var68 < 100; ++var68) {
						if (var36 == crossWorldMessageIds[var68]) {
							var32 = true;
							break;
						}
					}

					if (InvDefinition.friendSystem.isIgnored(new Username(var50, class166.loginType))) {
						var32 = true;
					}

					if (!var32 && field481 == 0) {
						crossWorldMessageIds[crossWorldMessageIdsIndex] = var36;
						crossWorldMessageIdsIndex = (crossWorldMessageIdsIndex + 1) % 100;
						var31 = AbstractFont.escapeBrackets(HealthBarUpdate.method523(class172.readString(var3)));
						byte var70;
						if (var9.isPrivileged) {
							var70 = 7;
						} else {
							var70 = 3;
						}

						if (var9.modIcon != -1) {
							class411.addGameMessage(var70, class436.addImageTag(var9.modIcon) + var50, var31);
						} else {
							class411.addGameMessage(var70, var50, var31);
						}
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.HINT_ARROW == var1.serverPacket) {
					var20 = var3.readShort();
					var5 = var3.readUnsignedIntLE();
					var22 = var3.method2625();
					var23 = class33.widgetDefinition.method1740(var5);
					if (var20 != var23.rawX || var22 != var23.rawY || var23.xAlignment != 0 || var23.yAlignment != 0) {
						var23.rawX = var20;
						var23.rawY = var22;
						var23.xAlignment = 0;
						var23.yAlignment = 0;
						ClanChannelMember.invalidateWidget(var23);
						this.alignWidget(var23);
						if (var23.type == 0) {
							PendingSpawn.revalidateWidgetScroll(class33.widgetDefinition.Widget_interfaceComponents[var5 >> 16], var23, false);
						}
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.MESSAGE_FRIENDCHANNEL == var1.serverPacket) {
					var20 = var3.readInt();
					var5 = var3.readUnsignedByteSub();
					var22 = var3.readUnsignedByte();
					var23 = class33.widgetDefinition.method1740(var20);
					UrlRequest.method664(var23, var22, var5);
					ClanChannelMember.invalidateWidget(var23);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.NEW_PACK_215 == var1.serverPacket) {
					var20 = var3.readUnsignedShortAdd();
					var5 = var3.readInt();
					var22 = var20 >> 10 & 31;
					var7 = var20 >> 5 & 31;
					var8 = var20 & 31;
					var24 = (var7 << 11) + (var22 << 19) + (var8 << 3);
					Widget var97 = class33.widgetDefinition.method1740(var5);
					if (var24 != var97.color) {
						var97.color = var24;
						ClanChannelMember.invalidateWidget(var97);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2683 == var1.serverPacket) {
					var20 = var3.readIntME();
					byte var71 = var3.readByte();
					Varps.Varps_temp[var20] = var71;
					if (Varps.Varps_main[var20] != var71) {
						Varps.Varps_main[var20] = var71;
					}

					ScriptEvent.changeGameOptions(var20);
					changedVarps[++changedVarpCount - 1 & 31] = var20;
					var1.serverPacket = null;
					return true;
				}

				boolean var61;
				if (ServerPacket.NEW_PACKET_CAM_RESET_V2 == var1.serverPacket) {
					var20 = var3.readUnsignedIntIME();
					var61 = var3.readUnsignedByte() == 1;
					var6 = class33.widgetDefinition.method1740(var20);
					Strings.method1908(var6, TextureProvider.localPlayer.appearance, var61);
					ClanChannelMember.invalidateWidget(var6);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2720 == var1.serverPacket) {
					var20 = var3.readUnsignedShortAdd();
					if (var20 == 65535) {
						var20 = -1;
					}

					var24 = var3.readUnsignedShort();
					var7 = var3.readUnsignedShortAdd();
					var8 = var3.readUnsignedShortAddLE();
					var22 = var3.readUnsignedShortAdd();
					var5 = var3.readUnsignedShortAddLE();
					if (var5 == 65535) {
						var5 = -1;
					}

					ArrayList var95 = new ArrayList();
					var95.add(var20);
					var95.add(var5);
					class202.method1006(var95, var22, var7, var8, var24);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2714 == var1.serverPacket) {
					return this.method377(var1);
				}

				if (ServerPacket.OBJ_ADD == var1.serverPacket) {
					UrlRequest.processZoneOperation(ZoneOperation.OBJ_ADD);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.MIDI_SONG_STOP == var1.serverPacket) {
					UrlRequest.processZoneOperation(ZoneOperation.LOC_DEL);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.REBUILD_REGION == var1.serverPacket) {
					SequenceDefinition.varclan = null;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.SPOTANIM_SPECIFIC == var1.serverPacket) {
					UrlRequest.processZoneOperation(ZoneOperation.field2624);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.REFLECTION_CHECK == var1.serverPacket) {
					var20 = var3.readUnsignedShort();
					var5 = var3.readUnsignedByte();
					var22 = var3.readUnsignedShort();
					GraphicsDefaults.queueSoundEffect(var20, var5, var22);
					var1.serverPacket = null;
					return true;
				}

				long var34;
				if (ServerPacket.VARP_SMALL == var1.serverPacket) {
					var20 = var3.offset + var1.serverPacketLength;
					var5 = var3.readUnsignedShort();
					if (var5 == 65535) {
						var5 = -1;
					}

					var22 = var3.readUnsignedShort();
					if (var5 != rootInterface) {
						rootInterface = var5;
						this.method382(false);
						class357.method1901(rootInterface);
						VerticalAlignment.runWidgetOnLoadListener(rootInterface);

						for (var7 = 0; var7 < 100; ++var7) {
							field408[var7] = true;
						}
					}

					InterfaceParent var93;
					for (; var22-- > 0; var93.field858 = true) {
						var7 = var3.readInt();
						var8 = var3.readUnsignedShort();
						var24 = var3.readUnsignedByte();
						var93 = (InterfaceParent)interfaceParents.get((long)var7);
						if (var93 != null && var8 != var93.group) {
							ArchiveDisk.closeInterface(var93, true);
							var93 = null;
						}

						if (var93 == null) {
							var93 = ClanChannel.ifOpenSub(var7, var8, var24);
						}
					}

					for (var78 = (InterfaceParent)interfaceParents.first(); var78 != null; var78 = (InterfaceParent)interfaceParents.next()) {
						if (var78.field858) {
							var78.field858 = false;
						} else {
							ArchiveDisk.closeInterface(var78, true);
						}
					}

					widgetFlags = new NodeHashTable(512);

					while (var3.offset < var20) {
						var7 = var3.readInt();
						var8 = var3.readUnsignedShort();
						var24 = var3.readUnsignedShort();
						var10 = var3.readInt();

						for (var60 = var8; var60 <= var24; ++var60) {
							var34 = ((long)var7 << 32) + (long)var60;
							widgetFlags.put(new IntegerNode(var10), var34);
						}
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.UPDATE_INV_CLEAR == var1.serverPacket) {
					Tiles.updatePlayers(var3, var1.serverPacketLength);
					SecureRandomCallable.method458();
					var1.serverPacket = null;
					return true;
				}

				boolean var74;
				if (ServerPacket.UPDATE_INV_FULL == var1.serverPacket) {
					var74 = var3.readUnsignedByte() == 1;
					if (var74) {
						class411.field3712 = GrandExchangeOfferTotalQuantityComparator.method1971() - var3.readLong();
						Varps.grandExchangeEvents = new GrandExchangeEvents(var3, true);
					} else {
						Varps.grandExchangeEvents = null;
					}

					field526 = cycleCntr;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.MIDI_SONG_LEGACY == var1.serverPacket) {
					Clock.field1484 = var3.readUnsignedByte();
					class354.field3144 = var3.readUnsignedByte();
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.TRADING_POST_RESULTS == var1.serverPacket) {
					var20 = var3.readInt();
					var5 = var3.readInt();
					var6 = class33.widgetDefinition.method1740(var5);
					ZoneOperation.method1645(var6, var20);
					ClanChannelMember.invalidateWidget(var6);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.VARP_LARGE == var1.serverPacket) {
					var24 = var3.readUnsignedByteNeg();
					var10 = var24 >> 2;
					var60 = var24 & 3;
					var87 = field652[var10];
					var22 = var3.method2627();
					var20 = var22 >> 16;
					var5 = var22 >> 8 & 255;
					var7 = var20 + (var22 >> 4 & 7);
					var8 = var5 + (var22 & 7);
					var68 = var3.readUnsignedShortAddLE();
					if (var7 >= 0 && var8 >= 0 && var7 < 103 && var8 < 103) {
						if (var87 == 0) {
							BoundaryObject var100 = class10.scene.method1299(class87.Client_plane, var7, var8);
							if (var100 != null) {
								var15 = SecureRandomFuture.Entity_unpackID(var100.tag);
								if (var10 == 2) {
									var100.renderable1 = new DynamicObject(var15, 2, var60 + 4, class87.Client_plane, var7, var8, var68, false, var100.renderable1);
									var100.renderable2 = new DynamicObject(var15, 2, var60 + 1 & 3, class87.Client_plane, var7, var8, var68, false, var100.renderable2);
								} else {
									var100.renderable1 = new DynamicObject(var15, var10, var60, class87.Client_plane, var7, var8, var68, false, var100.renderable1);
								}
							}
						} else if (var87 == 1) {
							WallDecoration var98 = class10.scene.method1300(class87.Client_plane, var7, var8);
							if (var98 != null) {
								var15 = SecureRandomFuture.Entity_unpackID(var98.tag);
								if (var10 != 4 && var10 != 5) {
									if (var10 == 6) {
										var98.renderable1 = new DynamicObject(var15, 4, var60 + 4, class87.Client_plane, var7, var8, var68, false, var98.renderable1);
									} else if (var10 == 7) {
										var98.renderable1 = new DynamicObject(var15, 4, (var60 + 2 & 3) + 4, class87.Client_plane, var7, var8, var68, false, var98.renderable1);
									} else if (var10 == 8) {
										var98.renderable1 = new DynamicObject(var15, 4, var60 + 4, class87.Client_plane, var7, var8, var68, false, var98.renderable1);
										var98.renderable2 = new DynamicObject(var15, 4, (var60 + 2 & 3) + 4, class87.Client_plane, var7, var8, var68, false, var98.renderable2);
									}
								} else {
									var98.renderable1 = new DynamicObject(var15, 4, var60, class87.Client_plane, var7, var8, var68, false, var98.renderable1);
								}
							}
						} else if (var87 == 2) {
							GameObject var94 = class10.scene.getGameObject(class87.Client_plane, var7, var8);
							if (var10 == 11) {
								var10 = 10;
							}

							if (var94 != null) {
								var94.renderable = new DynamicObject(SecureRandomFuture.Entity_unpackID(var94.tag), var10, var60, class87.Client_plane, var7, var8, var68, false, var94.renderable);
							}
						} else if (var87 == 3) {
							FloorDecoration var96 = class10.scene.getFloorDecoration(class87.Client_plane, var7, var8);
							if (var96 != null) {
								var96.renderable = new DynamicObject(SecureRandomFuture.Entity_unpackID(var96.tag), 22, var60, class87.Client_plane, var7, var8, var68, false, var96.renderable);
							}
						}
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.IF_SETNPCHEAD == var1.serverPacket) {
					var5 = var3.readIntME();
					var7 = var3.readUnsignedByteNeg();
					var20 = var3.readUnsignedShortAdd();
					Player var90;
					if (var20 == localPlayerIndex) {
						var90 = TextureProvider.localPlayer;
					} else {
						var90 = players[var20];
					}

					var22 = var3.readInt();
					if (var90 != null) {
						var90.updateSpotAnimation(var7, var5, var22 >> 16, var22 & 65535);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.PREFETCH_GAMEOBJECTS == var1.serverPacket) {
					var20 = var3.readInt();
					var61 = var3.readUnsignedByte() == 1;
					var6 = class33.widgetDefinition.method1740(var20);
					if (var61 != var6.isHidden) {
						var6.isHidden = var61;
						ClanChannelMember.invalidateWidget(var6);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.IF1_MODELROTATE == var1.serverPacket) {
					var20 = var3.readUnsignedShortAdd();
					var5 = var3.readUnsignedShort();
					var22 = var3.readUnsignedShortAddLE();
					var7 = var3.readUnsignedShortAdd();
					class206.someMusicMethod(var20, var5, var22, var7);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.UPDATE_SITESETTINGS == var1.serverPacket) {
					rebootTimer = var3.readIntME() * 30;
					field527 = cycleCntr;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.VARCLAN_DISABLE == var1.serverPacket) {
					var20 = var3.readUnsignedIntLE();
					var5 = var3.readUnsignedShortAddLE();
					var6 = class33.widgetDefinition.method1740(var20);
					if (var6 != null && var6.type == 0) {
						if (var5 > var6.scrollHeight - var6.height) {
							var5 = var6.scrollHeight - var6.height;
						}

						if (var5 < 0) {
							var5 = 0;
						}

						if (var5 != var6.scrollY) {
							var6.scrollY = var5;
							ClanChannelMember.invalidateWidget(var6);
						}
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.NPC_SPOTANIM_SPECIFIC == var1.serverPacket) {
					var20 = var3.readUnsignedIntLE();
					var5 = var3.readUnsignedShortAddLE();
					if (var5 == 65535) {
						var5 = -1;
					}

					var22 = var3.readUnsignedShort();
					if (var22 == 65535) {
						var22 = -1;
					}

					var7 = var3.readUnsignedIntIME();

					for (var8 = var22; var8 <= var5; ++var8) {
						var29 = ((long)var7 << 32) + (long)var8;
						Node var99 = widgetFlags.get(var29);
						if (var99 != null) {
							var99.remove();
						}

						widgetFlags.put(new IntegerNode(var20), var29);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2652 == var1.serverPacket) {
					var20 = var3.readIntME();
					if (var20 == 65535) {
						var20 = -1;
					}

					MusicPatch.playSong(var20);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.UPDATE_INV_STOP_TRANSMIT == var1.serverPacket) {
					var20 = var3.readUnsignedShortAdd();
					if (var20 == 65535) {
						var20 = -1;
					}

					var5 = var3.method2627();
					class437.playJingle(var20, var5);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.MESSAGE_CLANCHANNEL == var1.serverPacket) {
					World var53 = new World();
					var53.host = var3.readStringCp1252NullTerminated();
					var53.id = var3.readUnsignedShort();
					var5 = var3.readInt();
					var53.properties = var5;
					if (var53.isDeadman()) {
						var53.field680 = "beta";
					}

					DefaultsGroup.updateGameState(45);
					var2.close();
					var2 = null;
					Language.changeWorld(var53);
					var1.serverPacket = null;
					return false;
				}

				NPC var89;
				if (ServerPacket.RESET_ANIMS == var1.serverPacket) {
					var20 = var3.readUnsignedShortAdd();
					short var66 = (short)var3.readShortLE();
					var22 = var3.readUnsignedIntLE();
					var7 = var3.readUnsignedByteNeg();
					var89 = npcs[var20];
					if (var89 != null) {
						var89.method589(var7, var22, var66);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.CAM_SHAKE == var1.serverPacket) {
					var50 = var3.readStringCp1252NullTerminated();
					var5 = var3.readUnsignedByte();
					var22 = var3.readUnsignedByteNeg();
					if (var5 >= 1 && var5 <= 8) {
						if (var50.equalsIgnoreCase("null")) {
							var50 = null;
						}

						playerMenuActions[var5 - 1] = var50;
						playerOptionsPriorities[var5 - 1] = var22 == 0;
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.UPDATE_RUNWEIGHT == var1.serverPacket) {
					var5 = var3.readUnsignedIntLE();
					var22 = var3.readIntME();
					var7 = var3.readUnsignedByte();
					var20 = var3.readUnsignedShort();
					var89 = npcs[var20];
					if (var89 != null) {
						var89.updateSpotAnimation(var7, var22, var5 >> 16, var5 & 65535);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.SYNC_CLIENT_VARCACHE == var1.serverPacket) {
					for (var20 = 0; var20 < players.length; ++var20) {
						if (players[var20] != null) {
							players[var20].sequence = -1;
						}
					}

					for (var20 = 0; var20 < npcs.length; ++var20) {
						if (npcs[var20] != null) {
							npcs[var20].sequence = -1;
						}
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.IF_CLOSESUB == var1.serverPacket) {
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

				if (ServerPacket.REBUILD_REGION_NORMAL == var1.serverPacket) {
					if (SequenceDefinition.varclan == null) {
						SequenceDefinition.varclan = new class469(class53.Widget_cachedFonts);
					}

					class538 var52 = class53.Widget_cachedFonts.method2361(var3);
					SequenceDefinition.varclan.field3931.vmethod8143(var52.field4243, var52.field4242);
					field571[++field512 - 1 & 31] = var52.field4243;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.IF_SETPOSITION == var1.serverPacket) {
					var20 = var3.readUShortSmart();
					var61 = var3.readUnsignedByte() == 1;
					var55 = "";
					boolean var58 = false;
					if (var61) {
						var55 = var3.readStringCp1252NullTerminated();
						if (InvDefinition.friendSystem.isIgnored(new Username(var55, class166.loginType))) {
							var58 = true;
						}
					}

					String var88 = var3.readStringCp1252NullTerminated();
					if (!var58) {
						class411.addGameMessage(var20, var55, var88);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.UPDATE_ZONE_PARTIAL_FOLLOWS == var1.serverPacket) {
					Clock.field1484 = var3.readUnsignedByte();
					class354.field3144 = var3.readUnsignedByteSub();

					while (var3.offset < var1.serverPacketLength) {
						var20 = var3.readUnsignedByte();
						ZoneOperation var75 = JSException.method2055()[var20];
						UrlRequest.processZoneOperation(var75);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.PLAYER_INFO == var1.serverPacket) {
					var20 = var3.readInt();
					var5 = var3.readUnsignedShort();
					if (var20 < -70000) {
						var5 += 32768;
					}

					if (var20 >= 0) {
						var6 = class33.widgetDefinition.method1740(var20);
					} else {
						var6 = null;
					}

					for (; var3.offset < var1.serverPacketLength; SecureRandomFuture.itemContainerSetItem(var5, var7, var8 - 1, var24)) {
						var7 = var3.readUShortSmart();
						var8 = var3.readUnsignedShort();
						var24 = 0;
						if (var8 != 0) {
							var24 = var3.readUnsignedByte();
							if (var24 == 255) {
								var24 = var3.readInt();
							}
						}

						if (var6 != null && var7 >= 0 && var7 < var6.field3082.length) {
							var6.field3082[var7] = var8;
							var6.field3079[var7] = var24;
						}
					}

					if (var6 != null) {
						ClanChannelMember.invalidateWidget(var6);
					}

					class304.method1636();
					changedItemContainers[++changedItemContainersCount - 1 & 31] = var5 & 32767;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.CLANSETTINGS_FULL == var1.serverPacket) {
					InvDefinition.friendSystem.method401();
					field511 = cycleCntr;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.UPDATE_RUNENERGY == var1.serverPacket) {
					UrlRequest.processZoneOperation(ZoneOperation.AREA_SOUND);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.TRADING_POST_UPDATE == var1.serverPacket) {
					var3.offset += 28;
					if (var3.checkCrc()) {
						NPC.method598(var3, var3.offset - 28);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.IF_OPENSUB == var1.serverPacket) {
					var20 = var3.readInt();
					var5 = var3.readUnsignedShortAdd();
					var6 = class33.widgetDefinition.method1740(var20);
					if (var6.modelType != 2 || var5 != var6.modelId) {
						var6.modelType = 2;
						var6.modelId = var5;
						ClanChannelMember.invalidateWidget(var6);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.MESSAGE_PRIVATE_ECHO == var1.serverPacket) {
					var20 = var3.readUnsignedIntME();
					var5 = var3.readIntME();
					var22 = var3.readUnsignedShort();
					var23 = class33.widgetDefinition.method1740(var20);
					var23.rotationKey = var5 + (var22 << 16);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.PLAYER_ANIM_SPECIFIC == var1.serverPacket) {
					var20 = var3.readInt();
					if (var20 != field366) {
						field366 = var20;
						class174.method917();
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.IF_SETTEXT == var1.serverPacket) {
					class357.readReflectionCheck(var3, var1.serverPacketLength);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.IF_SETPLAYERMODEL_OBJ == var1.serverPacket) {
					var20 = var3.readInt();
					InterfaceParent var73 = (InterfaceParent)interfaceParents.get((long)var20);
					if (var73 != null) {
						ArchiveDisk.closeInterface(var73, true);
					}

					if (meslayerContinueWidget != null) {
						ClanChannelMember.invalidateWidget(meslayerContinueWidget);
						meslayerContinueWidget = null;
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.CLANCHANNEL_DELTA == var1.serverPacket) {
					var20 = var3.readInt();
					var5 = var3.readUnsignedShort();
					if (var20 < -70000) {
						var5 += 32768;
					}

					if (var20 >= 0) {
						var6 = class33.widgetDefinition.method1740(var20);
					} else {
						var6 = null;
					}

					if (var6 != null) {
						for (var7 = 0; var7 < var6.field3082.length; ++var7) {
							var6.field3082[var7] = 0;
							var6.field3079[var7] = 0;
						}
					}

					class155.clearItemContainer(var5);
					var7 = var3.readUnsignedShort();

					for (var8 = 0; var8 < var7; ++var8) {
						var24 = var3.readUnsignedByte();
						if (var24 == 255) {
							var24 = var3.readUnsignedIntIME();
						}

						var10 = var3.readUnsignedShort();
						if (var6 != null && var8 < var6.field3082.length) {
							var6.field3082[var8] = var10;
							var6.field3079[var8] = var24;
						}

						SecureRandomFuture.itemContainerSetItem(var5, var8, var10 - 1, var24);
					}

					if (var6 != null) {
						ClanChannelMember.invalidateWidget(var6);
					}

					class304.method1636();
					changedItemContainers[++changedItemContainersCount - 1 & 31] = var5 & 32767;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.UPDATE_STAT == var1.serverPacket) {
					class304.method1636();
					var20 = var3.readUnsignedByte();
					var5 = var3.readUnsignedByteSub();
					var22 = var3.readUnsignedIntIME();
					experience[var20] = var22;
					currentLevels[var20] = var5;
					levels[var20] = 1;

					for (var7 = 0; var7 < 98; ++var7) {
						if (var22 >= Skills.Skills_experienceTable[var7]) {
							levels[var20] = var7 + 2;
						}
					}

					changedSkills[++changedSkillsCount - 1 & 31] = var20;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.IF_SETOBJECT == var1.serverPacket) {
					return this.method376(var1, 2);
				}

				if (ServerPacket.NPC_INFO_LARGE == var1.serverPacket) {
					UrlRequest.processZoneOperation(ZoneOperation.OBJ_DEL);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.ENTER_FREECAM == var1.serverPacket) {
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

				if (ServerPacket.field2672 == var1.serverPacket) {
					InvDefinition.friendSystem.readUpdate(var3, var1.serverPacketLength);
					field511 = cycleCntr;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.FRIENDLIST_LOADED == var1.serverPacket) {
					var20 = var3.readUnsignedIntIME();
					var5 = var3.readIntME();
					Varps.Varps_temp[var5] = var20;
					if (Varps.Varps_main[var5] != var20) {
						Varps.Varps_main[var5] = var20;
					}

					ScriptEvent.changeGameOptions(var5);
					changedVarps[++changedVarpCount - 1 & 31] = var5;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.UPDATE_INV_PARTIAL == var1.serverPacket) {
					class151.loadRegions(false, var1.packetBuffer);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.IF_SETSCROLLPOS == var1.serverPacket) {
					Clock.field1484 = var3.readUnsignedByte();
					class354.field3144 = var3.readUnsignedByteNeg();

					for (var20 = Clock.field1484; var20 < Clock.field1484 + 8; ++var20) {
						for (var5 = class354.field3144; var5 < class354.field3144 + 8; ++var5) {
							if (groundItems[class87.Client_plane][var20][var5] != null) {
								groundItems[class87.Client_plane][var20][var5] = null;
								class30.updateItemPile(var20, var5);
							}
						}
					}

					for (PendingSpawn var51 = (PendingSpawn)pendingSpawns.last(); var51 != null; var51 = (PendingSpawn)pendingSpawns.previous()) {
						if (var51.x >= Clock.field1484 && var51.x < Clock.field1484 + 8 && var51.y >= class354.field3144 && var51.y < class354.field3144 + 8 && var51.plane == class87.Client_plane) {
							var51.endCycle = 0;
						}
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.MINIMAP_TOGGLE == var1.serverPacket) {
					isCameraLocked = true;
					field400 = false;
					field401 = true;
					var20 = var3.readShort();
					var5 = var3.readShort();
					var22 = class153.method800(var5 + class365.cameraPitch & 2027);
					var7 = var20 + WallDecoration.cameraYaw;
					var8 = var3.readUnsignedShort();
					var24 = var3.readUnsignedByte();
					field642 = new class493(class365.cameraPitch, var22, var8, var24);
					field643 = new class493(WallDecoration.cameraYaw, var7, var8, var24);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.OPEN_URL == var1.serverPacket) {
					Canvas.privateChatMode = UserComparator9.method679(var3.readUnsignedByte());
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2738 == var1.serverPacket) {
					var87 = var3.readUnsignedShortAdd();
					var22 = var3.method2627();
					var20 = var22 >> 16;
					var5 = var22 >> 8 & 255;
					var7 = var20 + (var22 >> 4 & 7);
					var8 = var5 + (var22 & 7);
					var18 = var3.readUnsignedShortAddLE();
					var68 = var3.readUnsignedByteNeg() * 4;
					var85 = var3.readByteNeg();
					var62 = var3.readByteAdd();
					var16 = var3.readUnsignedShortAdd();
					var15 = var3.readUnsignedShortAddLE();
					var60 = var3.method2583();
					var17 = var3.readUnsignedByteSub();
					var69 = var3.readUnsignedByteAdd() * 4;
					var24 = var85 + var7;
					var10 = var62 + var8;
					if (var7 >= 0 && var8 >= 0 && var7 < 104 && var8 < 104 && var24 >= 0 && var10 >= 0 && var24 < 104 && var10 < 104 && var87 != 65535) {
						var7 = var7 * 128 + 64;
						var8 = var8 * 128 + 64;
						var24 = var24 * 128 + 64;
						var10 = var10 * 128 + 64;
						var19 = new Projectile(var87, class87.Client_plane, var7, var8, class115.getTileHeight(var7, var8, class87.Client_plane) - var68, var15 + cycle, var16 + cycle, var17, var18, var60, var69);
						var19.setDestination(var24, var10, class115.getTileHeight(var24, var10, class87.Client_plane) - var69, var15 + cycle);
						projectiles.addFirst(var19);
					}

					var1.serverPacket = null;
					return true;
				}

				String var41;
				if (ServerPacket.OBJ_DEL_LEGACY == var1.serverPacket) {
					var50 = var3.readStringCp1252NullTerminated();
					var25 = var3.readLong();
					var27 = (long)var3.readUnsignedShort();
					var29 = (long)var3.readMedium();
					PlayerType var40 = (PlayerType)SequenceDefinition.findEnumerated(class183.PlayerType_values(), var3.readUnsignedByte());
					var34 = (var27 << 32) + var29;
					boolean var14 = false;

					for (var15 = 0; var15 < 100; ++var15) {
						if (var34 == crossWorldMessageIds[var15]) {
							var14 = true;
							break;
						}
					}

					if (var40.isUser && InvDefinition.friendSystem.isIgnored(new Username(var50, class166.loginType))) {
						var14 = true;
					}

					if (!var14 && field481 == 0) {
						crossWorldMessageIds[crossWorldMessageIdsIndex] = var34;
						crossWorldMessageIdsIndex = (crossWorldMessageIdsIndex + 1) % 100;
						var41 = AbstractFont.escapeBrackets(HealthBarUpdate.method523(class172.readString(var3)));
						if (var40.modIcon != -1) {
							class164.addChatMessage(9, class436.addImageTag(var40.modIcon) + var50, var41, class163.base37DecodeLong(var25));
						} else {
							class164.addChatMessage(9, var50, var41, class163.base37DecodeLong(var25));
						}
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.MESSAGE_GAME == var1.serverPacket && isCameraLocked) {
					field400 = true;
					field401 = false;
					field402 = false;

					for (var20 = 0; var20 < 5; ++var20) {
						cameraShaking[var20] = false;
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.LOC_ADD_CHANGE == var1.serverPacket) {
					var20 = var3.method2623();
					var5 = var3.readUnsignedIntIME();
					var6 = class33.widgetDefinition.method1740(var5);
					if (var20 != var6.sequenceId || var20 == -1) {
						var6.sequenceId = var20;
						var6.modelFrame = 0;
						var6.modelFrameCycle = 0;
						ClanChannelMember.invalidateWidget(var6);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2643 == var1.serverPacket) {
					var74 = var3.readBoolean();
					if (var74) {
						if (WallDecoration.field2303 == null) {
							WallDecoration.field2303 = new class384();
						}
					} else {
						WallDecoration.field2303 = null;
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.NPC_INFO_SMALL == var1.serverPacket) {
					var72 = var3.readByte();
					var21 = var3.readStringCp1252NullTerminated();
					long var42 = (long)var3.readUnsignedShort();
					long var44 = (long)var3.readMedium();
					PlayerType var38 = (PlayerType)SequenceDefinition.findEnumerated(class183.PlayerType_values(), var3.readUnsignedByte());
					long var46 = (var42 << 32) + var44;
					boolean var13 = false;
					ClanChannel var39 = null;
					var39 = var72 >= 0 ? currentClanChannels[var72] : ClanChannelMember.guestClanChannel;
					if (var39 == null) {
						var13 = true;
					} else {
						var15 = 0;

						while (true) {
							if (var15 >= 100) {
								if (var38.isUser && InvDefinition.friendSystem.isIgnored(new Username(var21, class166.loginType))) {
									var13 = true;
								}
								break;
							}

							if (crossWorldMessageIds[var15] == var46) {
								var13 = true;
								break;
							}

							++var15;
						}
					}

					if (!var13) {
						crossWorldMessageIds[crossWorldMessageIdsIndex] = var46;
						crossWorldMessageIdsIndex = (crossWorldMessageIdsIndex + 1) % 100;
						var41 = AbstractFont.escapeBrackets(class172.readString(var3));
						var16 = var72 >= 0 ? 41 : 44;
						if (var38.modIcon != -1) {
							class164.addChatMessage(var16, class436.addImageTag(var38.modIcon) + var21, var41, var39.name);
						} else {
							class164.addChatMessage(var16, var21, var41, var39.name);
						}
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.UPDATE_FRIENDCHAT_CHANNEL_FULL == var1.serverPacket) {
					isCameraLocked = true;
					field400 = false;
					field402 = true;
					class191.cameraMoveToX = var3.readUnsignedByte();
					MouseHandler.cameraMoveToY = var3.readUnsignedByte();
					var20 = var3.readUnsignedShort();
					var5 = var3.readUnsignedShort();
					field403 = var3.readBoolean();
					var22 = var3.readUnsignedByte();
					var7 = class191.cameraMoveToX * 128 + 64;
					var8 = MouseHandler.cameraMoveToY * 128 + 64;
					boolean var81 = false;
					boolean var57 = false;
					if (field403) {
						var24 = class17.cameraY;
						var10 = class115.getTileHeight(var7, var8, class87.Client_plane) - var20;
					} else {
						var24 = class115.getTileHeight(cameraX, WorldMapArea.cameraZ, class87.Client_plane) - class17.cameraY;
						var10 = var20;
					}

					field646 = new class492(cameraX, WorldMapArea.cameraZ, var24, var7, var8, var10, var5, var22);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.UPDATE_ZONE_FULL_FOLLOWS == var1.serverPacket) {
					for (var20 = 0; var20 < Varps.Varps_main.length; ++var20) {
						if (Varps.Varps_temp[var20] != Varps.Varps_main[var20]) {
							Varps.Varps_main[var20] = Varps.Varps_temp[var20];
							ScriptEvent.changeGameOptions(var20);
							changedVarps[++changedVarpCount - 1 & 31] = var20;
						}
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.MAP_ANIM == var1.serverPacket) {
					var20 = var3.readUnsignedByte();
					class7.forceDisconnect(var20);
					var1.serverPacket = null;
					return false;
				}

				if (ServerPacket.TRIGGER_ONDIALOGABORT == var1.serverPacket) {
					isCameraLocked = true;
					field400 = false;
					field402 = true;
					class191.cameraMoveToX = var3.readUnsignedByte();
					MouseHandler.cameraMoveToY = var3.readUnsignedByte();
					var20 = var3.readUnsignedShort();
					var5 = var3.readUnsignedByte() * 128 + 64;
					var22 = var3.readUnsignedByte() * 128 + 64;
					var7 = var3.readUnsignedShort();
					field403 = var3.readBoolean();
					var8 = var3.readUnsignedByte();
					var24 = class191.cameraMoveToX * 128 + 64;
					var10 = MouseHandler.cameraMoveToY * 128 + 64;
					var11 = false;
					var32 = false;
					if (field403) {
						var60 = class17.cameraY;
						var87 = class115.getTileHeight(var24, var10, class87.Client_plane) - var20;
					} else {
						var60 = class115.getTileHeight(cameraX, WorldMapArea.cameraZ, class87.Client_plane) - class17.cameraY;
						var87 = var20;
					}

					field646 = new class491(cameraX, WorldMapArea.cameraZ, var60, var24, var10, var87, var5, var22, var7, var8);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.SEND_PING == var1.serverPacket) {
					CollisionMap.method1166();
					var1.serverPacket = null;
					return false;
				}

				if (ServerPacket.IF_SETHIDE == var1.serverPacket) {
					isCameraLocked = true;
					field400 = false;
					field402 = false;
					class191.cameraMoveToX = var3.readUnsignedByte();
					MouseHandler.cameraMoveToY = var3.readUnsignedByte();
					SoundSystem.cameraMoveToHeight = var3.readUnsignedShort();
					SecureRandomCallable.cameraMoveToSpeed = var3.readUnsignedByte();
					class131.cameraMoveToAcceleration = var3.readUnsignedByte();
					if (class131.cameraMoveToAcceleration >= 100) {
						cameraX = class191.cameraMoveToX * 128 + 64;
						WorldMapArea.cameraZ = MouseHandler.cameraMoveToY * 128 + 64;
						class17.cameraY = class115.getTileHeight(cameraX, WorldMapArea.cameraZ, class87.Client_plane) - SoundSystem.cameraMoveToHeight;
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.CAM_LOOKAT_EASED_COORD == var1.serverPacket) {
					var50 = var3.readStringCp1252NullTerminated();
					var21 = AbstractFont.escapeBrackets(HealthBarUpdate.method523(class172.readString(var3)));
					class411.addGameMessage(6, var50, var21);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.EMPTY_PACKET == var1.serverPacket) {
					World.method398(var3.readStringCp1252NullTerminated());
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2715 == var1.serverPacket) {
					var20 = var3.readUnsignedShort();
					var5 = var3.readUnsignedIntLE();
					var22 = var3.readUnsignedShort();
					var7 = var3.readUnsignedShortAddLE();
					var33 = class33.widgetDefinition.method1740(var5);
					if (var20 != var33.modelAngleX || var7 != var33.modelAngleY || var22 != var33.modelZoom) {
						var33.modelAngleX = var20;
						var33.modelAngleY = var7;
						var33.modelZoom = var22;
						ClanChannelMember.invalidateWidget(var33);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2736 == var1.serverPacket) {
					UrlRequest.processZoneOperation(ZoneOperation.field2617);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.MAPPROJ_ANIM == var1.serverPacket) {
					UrlRequest.processZoneOperation(ZoneOperation.LOC_ADD_CHANGE);
					var1.serverPacket = null;
					return true;
				}

				class190.RunException_sendStackTrace("" + (var1.serverPacket != null ? var1.serverPacket.id * 1495788863 * -800816449 : -1) + "," + (var1.field1154 != null ? var1.field1154.id * 1495788863 * -800816449 : -1) + "," + (var1.field1156 != null ? var1.field1156.id * 1495788863 * -800816449 : -1) + "," + var1.serverPacketLength, (Throwable)null);
				CollisionMap.method1166();
			} catch (IOException var48) {
				class148.method781();
			} catch (Exception var49) {
				var21 = "" + (var1.serverPacket != null ? var1.serverPacket.id * 1495788863 * -800816449 : -1) + "," + (var1.field1154 != null ? var1.field1154.id * 1495788863 * -800816449 : -1) + "," + (var1.field1156 != null ? var1.field1156.id * 1495788863 * -800816449 : -1) + "," + var1.serverPacketLength + "," + (TextureProvider.localPlayer.pathX[0] + class20.baseX) + "," + (TextureProvider.localPlayer.pathY[0] + class19.baseY) + ",";

				for (var22 = 0; var22 < var1.serverPacketLength && var22 < 50; ++var22) {
					var21 = var21 + var3.array[var22] + ",";
				}

				class190.RunException_sendStackTrace(var21, var49);
				CollisionMap.method1166();
			}

			return true;
		}
	}

	@ObfuscatedName("kt")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "33"
	)
	@Export("menu")
	final void menu() {
		boolean var1 = false;

		int var2;
		int var5;
		while (!var1) {
			var1 = true;

			for (var2 = 0; var2 < menuOptionsCount - 1; ++var2) {
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
				if (var12 != 1 && (UserComparator8.mouseCam || var12 != 4)) {
					var2 = MouseHandler.MouseHandler_x;
					var10 = MouseHandler.MouseHandler_y;
					if (var2 < class28.menuX - 10 || var2 > class341.menuWidth + class28.menuX + 10 || var10 < class463.menuY - 10 || var10 > class463.menuY + Language.menuHeight + 10) {
						isMenuOpen = false;
						class19.method69(class28.menuX, class463.menuY, class341.menuWidth, Language.menuHeight);
					}
				}

				if (var12 == 1 || !UserComparator8.mouseCam && var12 == 4) {
					var2 = class28.menuX;
					var10 = class463.menuY;
					int var11 = class341.menuWidth;
					var5 = MouseHandler.MouseHandler_lastPressedX;
					int var13 = MouseHandler.MouseHandler_lastPressedY;
					int var7 = -1;

					for (int var8 = 0; var8 < menuOptionsCount; ++var8) {
						int var9 = var10 + (menuOptionsCount - 1 - var8) * 15 + 31;
						if (var5 > var2 && var5 < var2 + var11 && var13 > var9 - 13 && var13 < var9 + 3) {
							var7 = var8;
						}
					}

					if (var7 != -1) {
						AddRequestTask.method2156(var7);
					}

					isMenuOpen = false;
					class19.method69(class28.menuX, class463.menuY, class341.menuWidth, Language.menuHeight);
				}
			} else {
				var2 = AttackOption.method609();
				if ((var12 == 1 || !UserComparator8.mouseCam && var12 == 4) && this.shouldLeftClickOpenMenu()) {
					var12 = 2;
				}

				if ((var12 == 1 || !UserComparator8.mouseCam && var12 == 4) && menuOptionsCount > 0) {
					AddRequestTask.method2156(var2);
				}

				if (var12 == 2 && menuOptionsCount > 0) {
					this.openMenu(MouseHandler.MouseHandler_lastPressedX, MouseHandler.MouseHandler_lastPressedY);
				}
			}

		}
	}

	@ObfuscatedName("kc")
	@ObfuscatedSignature(
		descriptor = "(S)Z",
		garbageValue = "29401"
	)
	@Export("shouldLeftClickOpenMenu")
	final boolean shouldLeftClickOpenMenu() {
		int var1 = AttackOption.method609();
		return (leftClickOpensMenu && menuOptionsCount > 2 || WallDecoration.method1425(var1)) && !menuShiftClick[var1];
	}

	@ObfuscatedName("kd")
	@ObfuscatedSignature(
		descriptor = "(IIS)V",
		garbageValue = "-2675"
	)
	@Export("openMenu")
	final void openMenu(int var1, int var2) {
		class481.method2390(var1, var2);
		var1 -= viewportOffsetX;
		var2 -= viewportOffsetY;
		class10.scene.menuOpen(class87.Client_plane, var1, var2, false);
		isMenuOpen = true;
	}

	@ObfuscatedName("lg")
	@ObfuscatedSignature(
		descriptor = "(ZI)V",
		garbageValue = "-758466559"
	)
	final void method382(boolean var1) {
		int var2 = rootInterface;
		int var3 = class340.canvasWidth;
		int var4 = class491.canvasHeight;
		if (class33.widgetDefinition.loadInterface(var2)) {
			class360.resizeInterface(class33.widgetDefinition.Widget_interfaceComponents[var2], -1, var3, var4, var1);
		}

	}

	@ObfuscatedName("ln")
	@ObfuscatedSignature(
		descriptor = "(Lnm;B)V",
		garbageValue = "0"
	)
	@Export("alignWidget")
	void alignWidget(Widget var1) {
		Widget var2 = var1.parentId == -1 ? null : class33.widgetDefinition.method1740(var1.parentId);
		int var3;
		int var4;
		if (var2 == null) {
			var3 = class340.canvasWidth;
			var4 = class491.canvasHeight;
		} else {
			var3 = var2.width;
			var4 = var2.height;
		}

		class140.alignWidgetSize(var1, var3, var4, false);
		Username.alignWidgetPosition(var1, var3, var4);
	}

	@ObfuscatedName("mn")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-2017777407"
	)
	final void method384() {
		ClanChannelMember.invalidateWidget(clickedWidget);
		++FriendsChat.widgetDragDuration;
		if (field394 && field396) {
			int var1 = MouseHandler.MouseHandler_x;
			int var2 = MouseHandler.MouseHandler_y;
			var1 -= widgetClickX;
			var2 -= widgetClickY;
			if (var1 < field516) {
				var1 = field516;
			}

			if (var1 + clickedWidget.width > field516 + clickedWidgetParent.width) {
				var1 = field516 + clickedWidgetParent.width - clickedWidget.width;
			}

			if (var2 < field514) {
				var2 = field514;
			}

			if (var2 + clickedWidget.height > field514 + clickedWidgetParent.height) {
				var2 = field514 + clickedWidgetParent.height - clickedWidget.height;
			}

			int var3 = var1 - field521;
			int var4 = var2 - field517;
			int var5 = clickedWidget.dragZoneSize;
			if (FriendsChat.widgetDragDuration > clickedWidget.dragThreshold && (var3 > var5 || var3 < -var5 || var4 > var5 || var4 < -var5)) {
				isDraggingWidget = true;
			}

			int var6 = var1 - field516 + clickedWidgetParent.scrollX;
			int var7 = var2 - field514 + clickedWidgetParent.scrollY;
			ScriptEvent var8;
			if (clickedWidget.onDrag != null && isDraggingWidget) {
				var8 = new ScriptEvent();
				var8.widget = clickedWidget;
				var8.mouseX = var6;
				var8.mouseY = var7;
				var8.args = clickedWidget.onDrag;
				Interpreter.runScriptEvent(var8);
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
						Interpreter.runScriptEvent(var8);
					}

					if (draggedOnWidget != null && class212.method1045(clickedWidget) != null) {
						PacketBufferNode var9 = ClanChannelMember.getPacketBufferNode(ClientPacket.OPHELDD, packetWriter.isaacCipher);
						var9.packetBuffer.writeIntLE(clickedWidget.id);
						var9.packetBuffer.writeShort(draggedOnWidget.childIndex);
						var9.packetBuffer.writeShort(clickedWidget.childIndex);
						var9.packetBuffer.writeInt(draggedOnWidget.id);
						var9.packetBuffer.writeShortAddLE(clickedWidget.itemId);
						var9.packetBuffer.writeShort(draggedOnWidget.itemId);
						packetWriter.addNode(var9);
					}
				} else if (this.shouldLeftClickOpenMenu()) {
					this.openMenu(field521 + widgetClickX, field517 + widgetClickY);
				} else if (menuOptionsCount > 0) {
					VarbitComposition.method1049(widgetClickX + field521, widgetClickY + field517);
				}

				clickedWidget = null;
			}

		} else {
			if (FriendsChat.widgetDragDuration > 1) {
				if (!isDraggingWidget && menuOptionsCount > 0) {
					VarbitComposition.method1049(field521 + widgetClickX, field517 + widgetClickY);
				}

				clickedWidget = null;
			}

		}
	}

	@ObfuscatedName("ou")
	@ObfuscatedSignature(
		descriptor = "(I)Lvf;",
		garbageValue = "-1440888763"
	)
	@Export("username")
	public Username username() {
		return TextureProvider.localPlayer != null ? TextureProvider.localPlayer.username : null;
	}

	@ObfuscatedName("on")
	@ObfuscatedSignature(
		descriptor = "(IB)V",
		garbageValue = "95"
	)
	void method386(int var1) {
		if (param25 >= 216) {
			PacketBufferNode var2 = ClanChannelMember.getPacketBufferNode(ClientPacket.f3, packetWriter.isaacCipher);
			var2.packetBuffer.writeByte(var1);
			packetWriter.addNode(var2);
		}

	}

	@ObfuscatedName("ot")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "-859215777"
	)
	void method387(int var1) {
		if (param25 >= 216) {
			PacketBufferNode var2 = ClanChannelMember.getPacketBufferNode(ClientPacket.f50, packetWriter.isaacCipher);
			var2.packetBuffer.writeByte(var1);
			packetWriter.addNode(var2);
		}

	}

	@Export("init")
	@ObfuscatedName("init")
	public final void init() {
		try {
			if (this.checkHost()) {
				for (int var1 = 0; var1 <= 28; ++var1) {
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
							WorldMapLabelSize.clientLanguage = Language.method2007(Integer.parseInt(var2));
							break;
						case 7:
							SoundSystem.field211 = class432.method2191(Integer.parseInt(var2));
							break;
						case 8:
							if (var2.equalsIgnoreCase("true")) {
							}
							break;
						case 9:
							HealthBarDefinition.param9 = var2;
							break;
						case 10:
							UrlRequester.field1163 = (StudioGame)SequenceDefinition.findEnumerated(Calendar.method1889(), Integer.parseInt(var2));
							if (UrlRequester.field1163 == StudioGame.oldscape) {
								class166.loginType = LoginType.oldscape;
							} else {
								class166.loginType = LoginType.field4098;
							}
							break;
						case 11:
							class59.field308 = var2;
							break;
						case 12:
							worldId = Integer.parseInt(var2);
						case 13:
						case 16:
						case 18:
						case 19:
						case 20:
						case 23:
						case 24:
						default:
							break;
						case 14:
							WorldMapIcon_1.field2337 = Integer.parseInt(var2);
							break;
						case 15:
							gameBuild = Integer.parseInt(var2);
							break;
						case 17:
							class59.field307 = var2;
							break;
						case 21:
							param21 = Integer.parseInt(var2);
							break;
						case 22:
							Actor.field959 = var2;
							break;
						case 25:
							int var3 = var2.indexOf(".");
							if (var3 == -1) {
								param25 = Integer.parseInt(var2);
							} else {
								param25 = Integer.parseInt(var2.substring(0, var3));
								Integer.parseInt(var2.substring(var3 + 1));
							}
						}
					}
				}

				AddRequestTask.method2155();
				MouseHandler.worldHost = this.getCodeBase().getHost();
				class59.field309 = new JagNetThread();
				String var4 = SoundSystem.field211.name;
				byte var5 = 0;
				if ((worldProperties & class525.field4156.rsOrdinal()) != 0) {
					UserComparator3.field1184 = "beta";
				}

				try {
					class139.method735("oldschool", UserComparator3.field1184, var4, var5, 23);
				} catch (Exception var7) {
					class190.RunException_sendStackTrace((String)null, var7);
				}

				class159.client = this;
				class189.field1493 = clientType;
				class223.method1129();
				if (Boolean.parseBoolean(System.getProperty("jagex.disableBouncyCastle"))) {
					this.field660 = true;
				}

				if (field427 == -1) {
					if (!this.method357() && !this.method358()) {
						field427 = 0;
					} else {
						field427 = 5;
					}
				}

				this.startThread(765, 503, 217, 1);
			}
		} catch (RuntimeException var8) {
			throw GrandExchangeOfferTotalQuantityComparator.method1973(var8, "client.init(" + ')');
		}
	}

	@Export("finalize")
	@ObfuscatedName("finalize")
	protected void finalize() throws Throwable {
		class319.field2792.remove(this);
		super.finalize();
	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "(II)Lhg;",
		garbageValue = "-1459620271"
	)
	public static VarcInt method353(int var0) {
		VarcInt var1 = (VarcInt)VarcInt.VarcInt_cached.get((long)var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = VarcInt.VarcInt_archive.takeFile(19, var0);
			var1 = new VarcInt();
			if (var2 != null) {
				var1.method972(new Buffer(var2));
			}

			VarcInt.VarcInt_cached.put(var1, (long)var0);
			return var1;
		}
	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "(II)Ljava/lang/String;",
		garbageValue = "1915022124"
	)
	@Export("colorStartTag")
	static String colorStartTag(int var0) {
		return "<col=" + Integer.toHexString(var0) + ">";
	}
}