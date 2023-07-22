import com.jagex.oldscape.pub.OAuthApi;
import com.jagex.oldscape.pub.OtlTokenRequester;
import com.jagex.oldscape.pub.RefreshAccessTokenRequester;
import com.jagex.oldscape.pub.RefreshAccessTokenResponse;
import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Future;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@Implements("Client")
@ObfuscatedName("client")
public final class Client extends GameEngine implements Usernamed, OAuthApi, class312 {

	boolean shouldProcessClick() {
		return false;
	}
	@ObfuscatedName("vq")
	@Export("viewportOffsetX")
	static int viewportOffsetX;
	@ObfuscatedName("vu")
	@Export("viewportOffsetY")
	static int viewportOffsetY;
	@ObfuscatedName("wj")
	public static int field364;
	@ObfuscatedName("xm")
	@ObfuscatedSignature(
		descriptor = "Lco;"
	)
	static final ApproximateRouteStrategy field647;
	@ObfuscatedName("xk")
	static int[] field589;
	@ObfuscatedName("xz")
	static int[] field590;
	@ObfuscatedName("wc")
	@ObfuscatedSignature(
		descriptor = "Lld;"
	)
	@Export("Widget_cachedModels")
	static EvictingDualNodeHashTable Widget_cachedModels;
	@ObfuscatedName("vz")
	static int field545;
	@ObfuscatedName("wl")
	@ObfuscatedSignature(
		descriptor = "Lld;"
	)
	@Export("Widget_cachedFonts")
	static EvictingDualNodeHashTable Widget_cachedFonts;
	@ObfuscatedName("vi")
	@ObfuscatedSignature(
		descriptor = "Lmb;"
	)
	@Export("playerAppearance")
	static PlayerComposition playerAppearance;
	@ObfuscatedName("vt")
	static int field542;
	@ObfuscatedName("wv")
	@ObfuscatedSignature(
		descriptor = "Lql;"
	)
	@Export("archive5")
	static class424 archive5;
	@ObfuscatedName("wz")
	@Export("archiveLoaders")
	static ArrayList archiveLoaders;
	@ObfuscatedName("vf")
	static boolean[] field406;
	@ObfuscatedName("wb")
	@Export("archiveLoadersDone")
	static int archiveLoadersDone;
	@ObfuscatedName("vy")
	@ObfuscatedSignature(
		descriptor = "Lso;"
	)
	static class476 field641;
	@ObfuscatedName("vm")
	static short field634;
	@ObfuscatedName("vv")
	static short field637;
	@ObfuscatedName("vk")
	static short field633;
	@ObfuscatedName("vr")
	static short field636;
	@ObfuscatedName("va")
	static short field630;
	@ObfuscatedName("vg")
	@Export("viewportZoom")
	static int viewportZoom;
	@ObfuscatedName("vb")
	static short field631;
	@ObfuscatedName("wy")
	static int field548;
	@ObfuscatedName("vw")
	@Export("viewportWidth")
	static int viewportWidth;
	@ObfuscatedName("vh")
	@Export("viewportHeight")
	static int viewportHeight;
	@ObfuscatedName("vl")
	static int[] field586;
	@ObfuscatedName("vc")
	@Export("zoomWidth")
	static short zoomWidth;
	@ObfuscatedName("vo")
	@Export("zoomHeight")
	static short zoomHeight;
	@ObfuscatedName("wu")
	@ObfuscatedSignature(
		descriptor = "[Loc;"
	)
	@Export("grandExchangeOffers")
	static GrandExchangeOffer[] grandExchangeOffers;
	@ObfuscatedName("vn")
	static int[] field587;
	@ObfuscatedName("vs")
	static int[] field588;
	@ObfuscatedName("vj")
	static int[] cameraShakeCycle;
	@ObfuscatedName("we")
	@ObfuscatedSignature(
		descriptor = "Lcu;"
	)
	@Export("GrandExchangeEvents_worldComparator")
	static GrandExchangeOfferOwnWorldComparator GrandExchangeEvents_worldComparator;
	@ObfuscatedName("ws")
	static int field547;
	@ObfuscatedName("wh")
	static List field605;
	@ObfuscatedName("bg")
	@Export("lockMouseRecorder")
	static boolean lockMouseRecorder;
	@ObfuscatedName("bj")
	@Export("worldId")
	public static int worldId;
	@ObfuscatedName("ct")
	@Export("worldProperties")
	static int worldProperties;
	@ObfuscatedName("cz")
	@Export("gameBuild")
	static int gameBuild;
	@ObfuscatedName("cj")
	@Export("isMembersWorld")
	public static boolean isMembersWorld;
	@ObfuscatedName("cn")
	@Export("isLowDetail")
	static boolean isLowDetail;
	@ObfuscatedName("ca")
	@Export("param21")
	static int param21;
	@ObfuscatedName("cx")
	@Export("clientType")
	static int clientType;
	@ObfuscatedName("co")
	static int field421;
	@ObfuscatedName("cu")
	@Export("onMobile")
	static boolean onMobile;
	@ObfuscatedName("cr")
	@Export("param25")
	public static int param25;
	@ObfuscatedName("dq")
	@Export("gameState")
	static int gameState;
	@ObfuscatedName("dg")
	static boolean field371;
	@ObfuscatedName("et")
	@Export("isLoading")
	static boolean isLoading;
	@ObfuscatedName("em")
	@Export("cycle")
	static int cycle;
	@ObfuscatedName("ec")
	@Export("mouseLastLastPressedTimeMillis")
	static long mouseLastLastPressedTimeMillis;
	@ObfuscatedName("er")
	@Export("lastMouseRecordX")
	static int lastMouseRecordX;
	@ObfuscatedName("ew")
	@Export("lastMouseRecordY")
	static int lastMouseRecordY;
	@ObfuscatedName("eo")
	static long field609;
	@ObfuscatedName("eb")
	@Export("hadFocus")
	static boolean hadFocus;
	@ObfuscatedName("ej")
	@Export("rebootTimer")
	static int rebootTimer;
	@ObfuscatedName("eh")
	@Export("hintArrowType")
	static int hintArrowType;
	@ObfuscatedName("ei")
	@Export("hintArrowNpcIndex")
	static int hintArrowNpcIndex;
	@ObfuscatedName("en")
	@Export("hintArrowPlayerIndex")
	static int hintArrowPlayerIndex;
	@ObfuscatedName("es")
	static int hintArrowX;
	@ObfuscatedName("eq")
	static int hintArrowY;
	@ObfuscatedName("ee")
	static int hintArrowHeight;
	@ObfuscatedName("eg")
	static int hintArrowSubX;
	@ObfuscatedName("ey")
	static int hintArrowSubY;
	@ObfuscatedName("ea")
	@ObfuscatedSignature(
		descriptor = "Ldw;"
	)
	@Export("playerAttackOption")
	static AttackOption playerAttackOption;
	@ObfuscatedName("ex")
	@ObfuscatedSignature(
		descriptor = "Ldw;"
	)
	@Export("npcAttackOption")
	static AttackOption npcAttackOption;
	@ObfuscatedName("ef")
	@Export("renderSelf")
	static boolean renderSelf;
	@ObfuscatedName("fq")
	@ObfuscatedSignature(
		descriptor = "Ldm;"
	)
	static class92 field412;
	@ObfuscatedName("fp")
	@Export("js5ConnectState")
	static int js5ConnectState;
	@ObfuscatedName("fz")
	@Export("js5Cycles")
	static int js5Cycles;
	@ObfuscatedName("gs")
	@Export("js5Errors")
	static int js5Errors;
	@ObfuscatedName("go")
	@Export("loginState")
	static int loginState;
	@ObfuscatedName("gh")
	static int field440;
	@ObfuscatedName("gj")
	static int field441;
	@ObfuscatedName("gm")
	static int field442;
	@ObfuscatedName("gx")
	@ObfuscatedSignature(
		descriptor = "Lfb;"
	)
	static class139 field415;
	@ObfuscatedName("gr")
	@ObfuscatedSignature(
		descriptor = "Ltf;"
	)
	static class518 field644;
	@ObfuscatedName("hx")
	static final String field650;
	@ObfuscatedName("hq")
	@Export("Login_isUsernameRemembered")
	static boolean Login_isUsernameRemembered;
	@ObfuscatedName("hu")
	@ObfuscatedSignature(
		descriptor = "Lcc;"
	)
	@Export("secureRandomFuture")
	static SecureRandomFuture secureRandomFuture;
	@ObfuscatedName("ig")
	@Export("randomDatData")
	static byte[] randomDatData;
	@ObfuscatedName("ih")
	@ObfuscatedSignature(
		descriptor = "[Ldh;"
	)
	@Export("npcs")
	static NPC[] npcs;
	@ObfuscatedName("ij")
	@Export("npcCount")
	static int npcCount;
	@ObfuscatedName("ir")
	@Export("npcIndices")
	static int[] npcIndices;
	@ObfuscatedName("in")
	static int field446;
	@ObfuscatedName("iq")
	static int[] field549;
	@ObfuscatedName("id")
	@ObfuscatedSignature(
		descriptor = "Leb;"
	)
	@Export("packetWriter")
	public static final PacketWriter packetWriter;
	@ObfuscatedName("ip")
	@Export("logoutTimer")
	static int logoutTimer;
	@ObfuscatedName("ic")
	@Export("hadNetworkError")
	static boolean hadNetworkError;
	@ObfuscatedName("im")
	@ObfuscatedSignature(
		descriptor = "Lpm;"
	)
	@Export("timer")
	static Timer timer;
	@ObfuscatedName("if")
	@Export("fontsMap")
	static HashMap fontsMap;
	@ObfuscatedName("it")
	static String field595;
	@ObfuscatedName("jo")
	static int field450;
	@ObfuscatedName("jr")
	static int field451;
	@ObfuscatedName("jk")
	static int field448;
	@ObfuscatedName("jl")
	static int field449;
	@ObfuscatedName("jw")
	static int field453;
	@ObfuscatedName("jn")
	@ObfuscatedSignature(
		descriptor = "[Lij;"
	)
	@Export("collisionMaps")
	static CollisionMap[] collisionMaps;
	@ObfuscatedName("jz")
	@Export("isInInstance")
	static boolean isInInstance;
	@ObfuscatedName("jj")
	static int[][][] instanceChunkTemplates;
	@ObfuscatedName("jg")
	static final int[] field648;
	@ObfuscatedName("jv")
	static int field452;
	@ObfuscatedName("ka")
	static int field454;
	@ObfuscatedName("kx")
	static int field461;
	@ObfuscatedName("ku")
	static int field459;
	@ObfuscatedName("kq")
	static int field458;
	@ObfuscatedName("ky")
	static boolean field378;
	@ObfuscatedName("kv")
	@Export("alternativeScrollbarWidth")
	static int alternativeScrollbarWidth;
	@ObfuscatedName("kc")
	@Export("camAngleX")
	static int camAngleX;
	@ObfuscatedName("kb")
	@Export("camAngleY")
	static int camAngleY;
	@ObfuscatedName("kh")
	static int camAngleDY;
	@ObfuscatedName("lj")
	static int camAngleDX;
	@ObfuscatedName("lr")
	static int field471;
	@ObfuscatedName("ld")
	static int field463;
	@ObfuscatedName("li")
	@Export("oculusOrbState")
	static int oculusOrbState;
	@ObfuscatedName("la")
	@Export("camFollowHeight")
	static int camFollowHeight;
	@ObfuscatedName("lh")
	static int field464;
	@ObfuscatedName("lw")
	static int field473;
	@ObfuscatedName("lo")
	static int field468;
	@ObfuscatedName("ls")
	@Export("oculusOrbNormalSpeed")
	static int oculusOrbNormalSpeed;
	@ObfuscatedName("lx")
	@Export("oculusOrbSlowedSpeed")
	static int oculusOrbSlowedSpeed;
	@ObfuscatedName("ln")
	public static int field363;
	@ObfuscatedName("lt")
	@Export("oculusOrbOnLocalPlayer")
	static boolean oculusOrbOnLocalPlayer;
	@ObfuscatedName("lp")
	static int field469;
	@ObfuscatedName("lf")
	static boolean field379;
	@ObfuscatedName("ly")
	static int field475;
	@ObfuscatedName("lk")
	@Export("overheadTextLimit")
	static int overheadTextLimit;
	@ObfuscatedName("lq")
	@Export("overheadTextCount")
	static int overheadTextCount;
	@ObfuscatedName("lc")
	@Export("overheadTextXs")
	static int[] overheadTextXs;
	@ObfuscatedName("lb")
	@Export("overheadTextYs")
	static int[] overheadTextYs;
	@ObfuscatedName("lg")
	@Export("overheadTextAscents")
	static int[] overheadTextAscents;
	@ObfuscatedName("ll")
	@Export("overheadTextXOffsets")
	static int[] overheadTextXOffsets;
	@ObfuscatedName("lm")
	@Export("overheadTextColors")
	static int[] overheadTextColors;
	@ObfuscatedName("mn")
	@Export("overheadTextEffects")
	static int[] overheadTextEffects;
	@ObfuscatedName("mf")
	static int[][] field591;
	@ObfuscatedName("mm")
	@Export("overheadTextCyclesRemaining")
	static int[] overheadTextCyclesRemaining;
	@ObfuscatedName("mp")
	static String[] field599;
	@ObfuscatedName("mw")
	@Export("tileLastDrawnActor")
	static int[][] tileLastDrawnActor;
	@ObfuscatedName("mh")
	@Export("viewportDrawCount")
	static int viewportDrawCount;
	@ObfuscatedName("mj")
	@Export("viewportTempX")
	static int viewportTempX;
	@ObfuscatedName("mx")
	@Export("viewportTempY")
	static int viewportTempY;
	@ObfuscatedName("mu")
	@Export("mouseCrossX")
	static int mouseCrossX;
	@ObfuscatedName("mi")
	@Export("mouseCrossY")
	static int mouseCrossY;
	@ObfuscatedName("mq")
	@Export("mouseCrossState")
	static int mouseCrossState;
	@ObfuscatedName("mr")
	@Export("mouseCrossColor")
	static int mouseCrossColor;
	@ObfuscatedName("mv")
	@Export("showMouseCross")
	static boolean showMouseCross;
	@ObfuscatedName("my")
	static int field485;
	@ObfuscatedName("mc")
	@Export("showLoadingMessages")
	static boolean showLoadingMessages;
	@ObfuscatedName("mb")
	@ObfuscatedSignature(
		descriptor = "[Ldf;"
	)
	@Export("players")
	static Player[] players;
	@ObfuscatedName("mg")
	@Export("localPlayerIndex")
	static int localPlayerIndex;
	@ObfuscatedName("mt")
	@Export("isMembers")
	static int isMembers;
	@ObfuscatedName("mk")
	@Export("playerUUID")
	static long playerUUID;
	@ObfuscatedName("ml")
	static boolean field382;
	@ObfuscatedName("nb")
	@Export("drawPlayerNames")
	static int drawPlayerNames;
	@ObfuscatedName("no")
	static int field488;
	@ObfuscatedName("nh")
	static int[] field558;
	@ObfuscatedName("na")
	@Export("playerMenuOpcodes")
	static final int[] playerMenuOpcodes;
	@ObfuscatedName("ns")
	@Export("playerMenuActions")
	static String[] playerMenuActions;
	@ObfuscatedName("nc")
	@Export("playerOptionsPriorities")
	static boolean[] playerOptionsPriorities;
	@ObfuscatedName("ni")
	static int[] field559;
	@ObfuscatedName("nu")
	@Export("combatTargetPlayerIndex")
	static int combatTargetPlayerIndex;
	@ObfuscatedName("nk")
	@ObfuscatedSignature(
		descriptor = "[[[Lod;"
	)
	@Export("groundItems")
	static NodeDeque[][][] groundItems;
	@ObfuscatedName("nm")
	@ObfuscatedSignature(
		descriptor = "Lod;"
	)
	@Export("pendingSpawns")
	static NodeDeque pendingSpawns;
	@ObfuscatedName("nt")
	@ObfuscatedSignature(
		descriptor = "Lod;"
	)
	@Export("projectiles")
	static NodeDeque projectiles;
	@ObfuscatedName("nz")
	@ObfuscatedSignature(
		descriptor = "Lod;"
	)
	@Export("graphicsObjects")
	static NodeDeque graphicsObjects;
	@ObfuscatedName("nr")
	@Export("currentLevels")
	static int[] currentLevels;
	@ObfuscatedName("nw")
	@Export("levels")
	static int[] levels;
	@ObfuscatedName("nn")
	@Export("experience")
	static int[] experience;
	@ObfuscatedName("nl")
	@Export("leftClickOpensMenu")
	static boolean leftClickOpensMenu;
	@ObfuscatedName("ny")
	@Export("isMenuOpen")
	static boolean isMenuOpen;
	@ObfuscatedName("nj")
	@Export("menuOptionsCount")
	static int menuOptionsCount;
	@ObfuscatedName("ou")
	@Export("menuArguments1")
	static int[] menuArguments1;
	@ObfuscatedName("ow")
	@Export("menuArguments2")
	static int[] menuArguments2;
	@ObfuscatedName("ok")
	@Export("menuOpcodes")
	static int[] menuOpcodes;
	@ObfuscatedName("ol")
	@Export("menuIdentifiers")
	static int[] menuIdentifiers;
	@ObfuscatedName("oc")
	@Export("menuItemIds")
	static int[] menuItemIds;
	@ObfuscatedName("ov")
	@Export("menuActions")
	static String[] menuActions;
	@ObfuscatedName("oq")
	@Export("menuTargets")
	static String[] menuTargets;
	@ObfuscatedName("oe")
	@Export("menuShiftClick")
	static boolean[] menuShiftClick;
	@ObfuscatedName("os")
	@Export("followerOpsLowPriority")
	static boolean followerOpsLowPriority;
	@ObfuscatedName("ot")
	@Export("tapToDrop")
	static boolean tapToDrop;
	@ObfuscatedName("ox")
	@Export("showMouseOverText")
	static boolean showMouseOverText;
	@ObfuscatedName("og")
	@Export("viewportX")
	static int viewportX;
	@ObfuscatedName("ob")
	@Export("viewportY")
	static int viewportY;
	@ObfuscatedName("om")
	static int field494;
	@ObfuscatedName("oj")
	static int field493;
	@ObfuscatedName("oz")
	@Export("isItemSelected")
	static int isItemSelected;
	@ObfuscatedName("oy")
	@Export("isSpellSelected")
	static boolean isSpellSelected;
	@ObfuscatedName("op")
	@Export("selectedSpellChildIndex")
	static int selectedSpellChildIndex;
	@ObfuscatedName("of")
	@Export("selectedSpellItemId")
	static int selectedSpellItemId;
	@ObfuscatedName("pl")
	static String field597;
	@ObfuscatedName("pa")
	static String field596;
	@ObfuscatedName("pg")
	@Export("rootInterface")
	static int rootInterface;
	@ObfuscatedName("pd")
	@ObfuscatedSignature(
		descriptor = "Lsm;"
	)
	@Export("interfaceParents")
	static NodeHashTable interfaceParents;
	@ObfuscatedName("pq")
	static int field503;
	@ObfuscatedName("po")
	static int field502;
	@ObfuscatedName("pe")
	@Export("chatEffects")
	static int chatEffects;
	@ObfuscatedName("pj")
	@ObfuscatedSignature(
		descriptor = "Lmt;"
	)
	@Export("meslayerContinueWidget")
	static Widget meslayerContinueWidget;
	@ObfuscatedName("pu")
	@Export("runEnergy")
	static int runEnergy;
	@ObfuscatedName("pn")
	@Export("weight")
	static int weight;
	@ObfuscatedName("pi")
	@Export("staffModLevel")
	static int staffModLevel;
	@ObfuscatedName("px")
	@Export("followerIndex")
	static int followerIndex;
	@ObfuscatedName("pb")
	@Export("playerMod")
	static boolean playerMod;
	@ObfuscatedName("pp")
	@ObfuscatedSignature(
		descriptor = "Lmt;"
	)
	@Export("viewportWidget")
	static Widget viewportWidget;
	@ObfuscatedName("pf")
	@ObfuscatedSignature(
		descriptor = "Lmt;"
	)
	@Export("clickedWidget")
	public static Widget clickedWidget;
	@ObfuscatedName("ps")
	@ObfuscatedSignature(
		descriptor = "Lmt;"
	)
	@Export("clickedWidgetParent")
	static Widget clickedWidgetParent;
	@ObfuscatedName("py")
	@Export("widgetClickX")
	static int widgetClickX;
	@ObfuscatedName("pw")
	@Export("widgetClickY")
	static int widgetClickY;
	@ObfuscatedName("pk")
	@ObfuscatedSignature(
		descriptor = "Lmt;"
	)
	@Export("draggedOnWidget")
	static Widget draggedOnWidget;
	@ObfuscatedName("pv")
	static boolean field391;
	@ObfuscatedName("pm")
	static int field500;
	@ObfuscatedName("pr")
	static int field504;
	@ObfuscatedName("qx")
	static boolean field393;
	@ObfuscatedName("qw")
	static int field520;
	@ObfuscatedName("qf")
	static int field510;
	@ObfuscatedName("qc")
	@Export("isDraggingWidget")
	static boolean isDraggingWidget;
	@ObfuscatedName("ql")
	@Export("cycleCntr")
	static int cycleCntr;
	@ObfuscatedName("qv")
	@Export("changedVarps")
	static int[] changedVarps;
	@ObfuscatedName("qp")
	@Export("changedVarpCount")
	static int changedVarpCount;
	@ObfuscatedName("qk")
	@Export("changedItemContainers")
	static int[] changedItemContainers;
	@ObfuscatedName("qi")
	@Export("changedItemContainersCount")
	static int changedItemContainersCount;
	@ObfuscatedName("qt")
	@Export("changedSkills")
	static int[] changedSkills;
	@ObfuscatedName("qg")
	@Export("changedSkillsCount")
	static int changedSkillsCount;
	@ObfuscatedName("qe")
	static int[] field568;
	@ObfuscatedName("qz")
	static int field522;
	@ObfuscatedName("qs")
	@Export("chatCycle")
	static int chatCycle;
	@ObfuscatedName("qn")
	static int field516;
	@ObfuscatedName("qa")
	static int field509;
	@ObfuscatedName("qj")
	static int field514;
	@ObfuscatedName("qh")
	static int field512;
	@ObfuscatedName("qq")
	static int field518;
	@ObfuscatedName("qy")
	static int field521;
	@ObfuscatedName("rh")
	static int field524;
	@ObfuscatedName("ra")
	@Export("mouseWheelRotation")
	static int mouseWheelRotation;
	@ObfuscatedName("ri")
	@ObfuscatedSignature(
		descriptor = "Lum;"
	)
	static class531 field646;
	@ObfuscatedName("rj")
	@ObfuscatedSignature(
		descriptor = "Lod;"
	)
	@Export("scriptEvents")
	static NodeDeque scriptEvents;
	@ObfuscatedName("rm")
	@ObfuscatedSignature(
		descriptor = "Lod;"
	)
	static NodeDeque field624;
	@ObfuscatedName("rv")
	@ObfuscatedSignature(
		descriptor = "Lod;"
	)
	static NodeDeque field626;
	@ObfuscatedName("rp")
	@ObfuscatedSignature(
		descriptor = "Lod;"
	)
	static NodeDeque field625;
	@ObfuscatedName("rr")
	@ObfuscatedSignature(
		descriptor = "Lsm;"
	)
	@Export("widgetFlags")
	static NodeHashTable widgetFlags;
	@ObfuscatedName("rn")
	@Export("rootWidgetCount")
	static int rootWidgetCount;
	@ObfuscatedName("rl")
	static int field525;
	@ObfuscatedName("rc")
	static boolean[] field403;
	@ObfuscatedName("ro")
	static boolean[] field404;
	@ObfuscatedName("rw")
	static boolean[] field405;
	@ObfuscatedName("rs")
	@Export("rootWidgetXs")
	static int[] rootWidgetXs;
	@ObfuscatedName("rq")
	@Export("rootWidgetYs")
	static int[] rootWidgetYs;
	@ObfuscatedName("re")
	@Export("rootWidgetWidths")
	static int[] rootWidgetWidths;
	@ObfuscatedName("rx")
	@Export("rootWidgetHeights")
	static int[] rootWidgetHeights;
	@ObfuscatedName("ry")
	@Export("gameDrawingMode")
	static int gameDrawingMode;
	@ObfuscatedName("rd")
	static long field611;
	@ObfuscatedName("rz")
	@Export("isResizable")
	static boolean isResizable;
	@ObfuscatedName("su")
	static int[] field577;
	@ObfuscatedName("sy")
	@Export("publicChatMode")
	static int publicChatMode;
	@ObfuscatedName("sc")
	@Export("tradeChatMode")
	static int tradeChatMode;
	@ObfuscatedName("sd")
	static String field598;
	@ObfuscatedName("sl")
	static long[] field613;
	@ObfuscatedName("sk")
	static int field530;
	@ObfuscatedName("st")
	@ObfuscatedSignature(
		descriptor = "Lih;"
	)
	@Export("keyHandlerInstance")
	static class213 keyHandlerInstance;
	@ObfuscatedName("sq")
	@ObfuscatedSignature(
		descriptor = "Liw;"
	)
	static class211 field594;
	@ObfuscatedName("sg")
	static int field529;
	@ObfuscatedName("sf")
	static int[] field576;
	@ObfuscatedName("sw")
	static int[] field578;
	@ObfuscatedName("sa")
	@Export("timeOfPreviousKeyPress")
	static long timeOfPreviousKeyPress;
	@ObfuscatedName("sn")
	@ObfuscatedSignature(
		descriptor = "[Lfx;"
	)
	@Export("currentClanSettings")
	static ClanSettings[] currentClanSettings;
	@ObfuscatedName("ta")
	@ObfuscatedSignature(
		descriptor = "[Lgh;"
	)
	@Export("currentClanChannels")
	static ClanChannel[] currentClanChannels;
	@ObfuscatedName("ts")
	static int field535;
	@ObfuscatedName("tt")
	static int mapIconCount;
	@ObfuscatedName("tp")
	static int[] mapIconXs;
	@ObfuscatedName("td")
	static int[] mapIconYs;
	@ObfuscatedName("te")
	@ObfuscatedSignature(
		descriptor = "[Lud;"
	)
	static SpritePixels[] mapIcons;
	@ObfuscatedName("tv")
	@Export("destinationX")
	static int destinationX;
	@ObfuscatedName("ti")
	@Export("destinationY")
	static int destinationY;
	@ObfuscatedName("tq")
	@Export("minimapState")
	static int minimapState;
	@ObfuscatedName("th")
	@Export("playingJingle")
	static boolean playingJingle;
	@ObfuscatedName("tb")
	@Export("soundEffectCount")
	static int soundEffectCount;
	@ObfuscatedName("tj")
	@Export("soundEffectIds")
	static int[] soundEffectIds;
	@ObfuscatedName("tl")
	@Export("queuedSoundEffectLoops")
	static int[] queuedSoundEffectLoops;
	@ObfuscatedName("tf")
	@Export("queuedSoundEffectDelays")
	static int[] queuedSoundEffectDelays;
	@ObfuscatedName("tz")
	@Export("soundLocations")
	static int[] soundLocations;
	@ObfuscatedName("uw")
	@ObfuscatedSignature(
		descriptor = "[Lbc;"
	)
	@Export("soundEffects")
	static SoundEffect[] soundEffects;
	@ObfuscatedName("uh")
	@Export("isCameraLocked")
	static boolean isCameraLocked;
	@ObfuscatedName("uu")
	static int field538;
	@ObfuscatedName("uv")
	static boolean field398;
	@ObfuscatedName("uz")
	static boolean field400;
	@ObfuscatedName("uy")
	static boolean field399;
	@ObfuscatedName("ub")
	@ObfuscatedSignature(
		descriptor = "Lsl;"
	)
	static class480 field638;
	@ObfuscatedName("ui")
	@ObfuscatedSignature(
		descriptor = "Lss;"
	)
	static class479 field642;
	@ObfuscatedName("up")
	@ObfuscatedSignature(
		descriptor = "Lss;"
	)
	static class479 field643;
	@ObfuscatedName("uo")
	static boolean field397;
	@ObfuscatedName("gu")
	String field658;
	@ObfuscatedName("gw")
	@ObfuscatedSignature(
		descriptor = "Laa;"
	)
	class14 field651;
	@ObfuscatedName("hf")
	@ObfuscatedSignature(
		descriptor = "Lad;"
	)
	class18 field652;
	@ObfuscatedName("hv")
	OtlTokenRequester field656;
	@ObfuscatedName("hp")
	Future field660;
	@ObfuscatedName("hh")
	boolean field655;
	@ObfuscatedName("hg")
	@ObfuscatedSignature(
		descriptor = "Lad;"
	)
	class18 field653;
	@ObfuscatedName("ho")
	@ObfuscatedSignature(
		descriptor = "Lcom/jagex/oldscape/pub/RefreshAccessTokenRequester;"
	)
	RefreshAccessTokenRequester field657;
	@ObfuscatedName("he")
	Future field659;
	@ObfuscatedName("hb")
	@ObfuscatedSignature(
		descriptor = "Lty;"
	)
	Buffer field662;
	@ObfuscatedName("hc")
	@ObfuscatedSignature(
		descriptor = "Laz;"
	)
	class7 field654;
	@ObfuscatedName("ia")
	long field661;

	static {
		lockMouseRecorder = true;
		worldId = 1;
		worldProperties = 0;
		gameBuild = 0;
		isMembersWorld = false;
		isLowDetail = false;
		param21 = -1;
		clientType = -1;
		field421 = -1;
		onMobile = false;
		param25 = 215;
		gameState = 0;
		field371 = false;
		isLoading = true;
		cycle = 0;
		mouseLastLastPressedTimeMillis = -1L;
		lastMouseRecordX = -1;
		lastMouseRecordY = -1;
		field609 = -1L;
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
		field412 = class92.field937;
		js5ConnectState = 0;
		js5Cycles = 0;
		js5Errors = 0;
		loginState = 0;
		field440 = 0;
		field441 = 0;
		field442 = 0;
		field415 = class139.field1307;
		field644 = class518.field4159;
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

		field650 = class345.method1832(var2);
		Login_isUsernameRemembered = false;
		secureRandomFuture = new SecureRandomFuture();
		randomDatData = null;
		npcs = new NPC[65536];
		npcCount = 0;
		npcIndices = new int[65536];
		field446 = 0;
		field549 = new int[250];
		packetWriter = new PacketWriter();
		logoutTimer = 0;
		hadNetworkError = false;
		timer = new Timer();
		fontsMap = new HashMap();
		field450 = 0;
		field451 = 1;
		field448 = 0;
		field449 = 1;
		field453 = 0;
		collisionMaps = new CollisionMap[4];
		isInInstance = false;
		instanceChunkTemplates = new int[4][13][13];
		field648 = new int[]{0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3};
		field452 = 0;
		field454 = 2301979;
		field461 = 5063219;
		field459 = 3353893;
		field458 = 7759444;
		field378 = false;
		alternativeScrollbarWidth = 0;
		camAngleX = 128;
		camAngleY = 0;
		camAngleDY = 0;
		camAngleDX = 0;
		field471 = 0;
		field463 = 0;
		oculusOrbState = 0;
		camFollowHeight = 50;
		field464 = 0;
		field473 = 0;
		field468 = 0;
		oculusOrbNormalSpeed = 12;
		oculusOrbSlowedSpeed = 6;
		field363 = 0;
		oculusOrbOnLocalPlayer = false;
		field469 = 0;
		field379 = false;
		field475 = 0;
		overheadTextLimit = 0;
		overheadTextCount = 50;
		overheadTextXs = new int[overheadTextCount];
		overheadTextYs = new int[overheadTextCount];
		overheadTextAscents = new int[overheadTextCount];
		overheadTextXOffsets = new int[overheadTextCount];
		overheadTextColors = new int[overheadTextCount];
		overheadTextEffects = new int[overheadTextCount];
		field591 = new int[overheadTextCount][];
		overheadTextCyclesRemaining = new int[overheadTextCount];
		field599 = new String[overheadTextCount];
		tileLastDrawnActor = new int[104][104];
		viewportDrawCount = 0;
		viewportTempX = -1;
		viewportTempY = -1;
		mouseCrossX = 0;
		mouseCrossY = 0;
		mouseCrossState = 0;
		mouseCrossColor = 0;
		showMouseCross = true;
		field485 = 0;
		showLoadingMessages = true;
		players = new Player[2048];
		localPlayerIndex = -1;
		isMembers = 0;
		playerUUID = -1L;
		field382 = true;
		drawPlayerNames = 0;
		field488 = 0;
		field558 = new int[1000];
		playerMenuOpcodes = new int[]{44, 45, 46, 47, 48, 49, 50, 51};
		playerMenuActions = new String[8];
		playerOptionsPriorities = new boolean[8];
		field559 = new int[]{768, 1024, 1280, 512, 1536, 256, 0, 1792};
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
		field494 = 0;
		field493 = 50;
		isItemSelected = 0;
		field595 = null;
		isSpellSelected = false;
		selectedSpellChildIndex = -1;
		selectedSpellItemId = -1;
		field597 = null;
		field596 = null;
		rootInterface = -1;
		interfaceParents = new NodeHashTable(8);
		field503 = 0;
		field502 = -1;
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
		field391 = false;
		field500 = -1;
		field504 = -1;
		field393 = false;
		field520 = -1;
		field510 = -1;
		isDraggingWidget = false;
		cycleCntr = 1;
		changedVarps = new int[32];
		changedVarpCount = 0;
		changedItemContainers = new int[32];
		changedItemContainersCount = 0;
		changedSkills = new int[32];
		changedSkillsCount = 0;
		field568 = new int[32];
		field522 = 0;
		chatCycle = 0;
		field516 = 0;
		field509 = 0;
		field514 = 0;
		field512 = 0;
		field518 = 0;
		field521 = 0;
		field524 = 0;
		mouseWheelRotation = 0;
		field646 = new class531();
		scriptEvents = new NodeDeque();
		field624 = new NodeDeque();
		field626 = new NodeDeque();
		field625 = new NodeDeque();
		widgetFlags = new NodeHashTable(512);
		rootWidgetCount = 0;
		field525 = -2;
		field403 = new boolean[100];
		field404 = new boolean[100];
		field405 = new boolean[100];
		rootWidgetXs = new int[100];
		rootWidgetYs = new int[100];
		rootWidgetWidths = new int[100];
		rootWidgetHeights = new int[100];
		gameDrawingMode = 0;
		field611 = 0L;
		isResizable = true;
		field577 = new int[]{16776960, 16711680, 65280, 65535, 16711935, 16777215};
		publicChatMode = 0;
		tradeChatMode = 0;
		field598 = "";
		field613 = new long[100];
		field530 = 0;
		keyHandlerInstance = new class213();
		field594 = new class211();
		field529 = 0;
		field576 = new int[128];
		field578 = new int[128];
		timeOfPreviousKeyPress = -1L;
		currentClanSettings = new ClanSettings[4];
		currentClanChannels = new ClanChannel[4];
		field535 = -1;
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
		field398 = false;
		field400 = false;
		field399 = false;
		field638 = null;
		field642 = null;
		field643 = null;
		field397 = false;
		field406 = new boolean[5];
		field587 = new int[5];
		field586 = new int[5];
		field588 = new int[5];
		cameraShakeCycle = new int[5];
		field634 = 256;
		field637 = 205;
		zoomHeight = 256;
		zoomWidth = 320;
		field631 = 1;
		field630 = 32767;
		field633 = 1;
		field636 = 32767;
		viewportOffsetX = 0;
		viewportOffsetY = 0;
		viewportWidth = 0;
		viewportHeight = 0;
		viewportZoom = 0;
		playerAppearance = new PlayerComposition();
		field545 = -1;
		field542 = -1;
		field641 = new DesktopPlatformInfoProvider();
		grandExchangeOffers = new GrandExchangeOffer[8];
		GrandExchangeEvents_worldComparator = new GrandExchangeOfferOwnWorldComparator();
		archive5 = new class424(8, class422.field3754);
		Widget_cachedModels = new EvictingDualNodeHashTable(64);
		Widget_cachedFonts = new EvictingDualNodeHashTable(64);
		field547 = -1;
		field364 = -1;
		field605 = new ArrayList();
		archiveLoaders = new ArrayList(10);
		archiveLoadersDone = 0;
		field548 = 0;
		field647 = new ApproximateRouteStrategy();
		field589 = new int[50];
		field590 = new int[50];
	}

	public Client() {
		this.field655 = false;
		this.field661 = -1L;
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "-19"
	)
	@Export("resizeGame")
	protected final void resizeGame() {
		field611 = class113.clockNow() + 500L;
		this.resizeJS();
		if (rootInterface != -1) {
			this.resizeRoot(true);
		}

	}

	@ObfuscatedName("br")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "72"
	)
	@Export("setUp")
	protected final void setUp() {
		int[] var1 = new int[]{20, 260, 10000};
		int[] var2 = new int[]{1000, 100, 500};
		if (var1 != null && var2 != null) {
			ByteArrayPool.ByteArrayPool_alternativeSizes = var1;
			class125.ByteArrayPool_altSizeArrayCounts = new int[var1.length];
			class152.ByteArrayPool_arrays = new byte[var1.length][][];

			for (int var3 = 0; var3 < ByteArrayPool.ByteArrayPool_alternativeSizes.length; ++var3) {
				class152.ByteArrayPool_arrays[var3] = new byte[var2[var3]][];
				ByteArrayPool.field3724.add(var1[var3]);
			}

			Collections.sort(ByteArrayPool.field3724);
		} else {
			ByteArrayPool.ByteArrayPool_alternativeSizes = null;
			class125.ByteArrayPool_altSizeArrayCounts = null;
			class152.ByteArrayPool_arrays = null;
			ByteArrayPool.field3724.clear();
			ByteArrayPool.field3724.add(100);
			ByteArrayPool.field3724.add(5000);
			ByteArrayPool.field3724.add(10000);
			ByteArrayPool.field3724.add(30000);
		}

		Login.worldPort = gameBuild == 0 ? 43594 : worldId + 40000;
		class11.js5Port = gameBuild == 0 ? 443 : worldId + 50000;
		Varps.currentPort = Login.worldPort;
		class33.field89 = class331.field2923;
		ClanChannel.field1410 = class331.field2925;
		ViewportMouse.field2226 = class331.field2922;
		WorldMapSectionType.field2391 = class331.field2924;
		WorldMapLabel.urlRequester = new class113(this.field655, 215);
		this.setUpKeyboard();
		this.method146();
		MidiPcmStream.mouseWheel = this.mouseWheel();
		this.method145(field594, 0);
		this.method145(keyHandlerInstance, 1);
		class158.masterDisk = new ArchiveDisk(255, JagexCache.JagexCache_dat2File, JagexCache.JagexCache_idx255File, 500000);
		class150.clientPreferences = class126.method690();
		this.setUpClipboard();
		WorldMapSectionType.method1479(this, class326.field2877);
		RouteStrategy.setWindowedMode(class150.clientPreferences.method573());
		class177.friendSystem = new FriendSystem(class457.loginType);
		this.field651 = new class14("tokenRequest", 1, 1);
		class102.method605(this);
		class219.field1905 = new class217[1];
		class215 var4 = class215.field1877;
		class219.field1905[0] = new class217(var4.field1887, var4.field1886);
	}

	@ObfuscatedName("bw")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "443189499"
	)
	@Export("doCycle")
	protected final void doCycle() {
		++cycle;
		this.doCycleJs5();
		BufferedSink.method2247();
		boolean var1 = InterfaceParent.method470(cycle);
		if (var1 && playingJingle && VerticalAlignment.pcmPlayer1 != null) {
			VerticalAlignment.pcmPlayer1.tryDiscard();
		}

		class105.method618();
		keyHandlerInstance.method1084();
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

		if (MidiPcmStream.mouseWheel != null) {
			int var4 = MidiPcmStream.mouseWheel.useRotation();
			mouseWheelRotation = var4;
		}

		if (gameState == 0) {
			Skeleton.method1208();
			HealthBarDefinition.method953();
		} else if (gameState == 5) {
			FileSystem.method906(this, ItemComposition.fontPlain11, class113.fontPlain12);
			Skeleton.method1208();
			HealthBarDefinition.method953();
		} else if (gameState != 10 && gameState != 11) {
			if (gameState == 20) {
				FileSystem.method906(this, ItemComposition.fontPlain11, class113.fontPlain12);
				this.doCycleLoggedOut();
			} else if (gameState == 50) {
				FileSystem.method906(this, ItemComposition.fontPlain11, class113.fontPlain12);
				this.doCycleLoggedOut();
			} else if (gameState == 25) {
				class126.method692();
			}
		} else {
			FileSystem.method906(this, ItemComposition.fontPlain11, class113.fontPlain12);
		}

		if (gameState == 30) {
			this.doCycleLoggedIn();
		} else if (gameState == 40 || gameState == 45) {
			this.doCycleLoggedOut();
		}

	}

	@ObfuscatedName("be")
	@ObfuscatedSignature(
		descriptor = "(ZB)V",
		garbageValue = "-23"
	)
	@Export("draw")
	protected final void draw(boolean var1) {
		if ((gameState == 10 || gameState == 20 || gameState == 30) && 0L != field611 && class113.clockNow() > field611) {
			RouteStrategy.setWindowedMode(Huffman.getWindowedMode());
		}

		int var2;
		if (var1) {
			for (var2 = 0; var2 < 100; ++var2) {
				field403[var2] = true;
			}
		}

		if (gameState == 0) {
			this.drawInitial(Login.Login_loadingPercent, Login.Login_loadingText, var1);
		} else if (gameState == 5) {
			class395.drawTitle(Calendar.fontBold12, ItemComposition.fontPlain11, class113.fontPlain12);
		} else if (gameState != 10 && gameState != 11) {
			if (gameState == 20) {
				class395.drawTitle(Calendar.fontBold12, ItemComposition.fontPlain11, class113.fontPlain12);
			} else if (gameState == 50) {
				class395.drawTitle(Calendar.fontBold12, ItemComposition.fontPlain11, class113.fontPlain12);
			} else if (gameState == 25) {
				if (field453 == 1) {
					if (field450 > field451) {
						field451 = field450;
					}

					var2 = (field451 * 50 - field450 * 50) / field451;
					Actor.drawLoadingMessage("Loading - please wait." + "<br>" + " (" + var2 + "%" + ")", false);
				} else if (field453 == 2) {
					if (field448 > field449) {
						field449 = field448;
					}

					var2 = (field449 * 50 - field448 * 50) / field449 + 50;
					Actor.drawLoadingMessage("Loading - please wait." + "<br>" + " (" + var2 + "%" + ")", false);
				} else {
					Actor.drawLoadingMessage("Loading - please wait.", false);
				}
			} else if (gameState == 30) {
				this.drawLoggedIn();
			} else if (gameState == 40) {
				Actor.drawLoadingMessage("Connection lost" + "<br>" + "Please wait - attempting to reestablish", false);
			} else if (gameState == 45) {
				Actor.drawLoadingMessage("Please wait...", false);
			}
		} else {
			class395.drawTitle(Calendar.fontBold12, ItemComposition.fontPlain11, class113.fontPlain12);
		}

		if (gameState == 30 && gameDrawingMode == 0 && !var1 && !isResizable) {
			for (var2 = 0; var2 < rootWidgetCount; ++var2) {
				if (field404[var2]) {
					class156.rasterProvider.draw(rootWidgetXs[var2], rootWidgetYs[var2], rootWidgetWidths[var2], rootWidgetHeights[var2]);
					field404[var2] = false;
				}
			}
		} else if (gameState > 0) {
			class156.rasterProvider.drawFull(0, 0);

			for (var2 = 0; var2 < rootWidgetCount; ++var2) {
				field404[var2] = false;
			}
		}

	}

	@ObfuscatedName("bc")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "73"
	)
	@Export("kill0")
	protected final void kill0() {
		if (PendingSpawn.varcs.hasUnwrittenChanges()) {
			PendingSpawn.varcs.write();
		}

		if (class497.mouseRecorder != null) {
			class497.mouseRecorder.isRunning = false;
		}

		class497.mouseRecorder = null;
		packetWriter.close();
		if (MouseHandler.MouseHandler_instance != null) {
			synchronized(MouseHandler.MouseHandler_instance) {
				MouseHandler.MouseHandler_instance = null;
			}
		}

		MidiPcmStream.mouseWheel = null;
		if (VerticalAlignment.pcmPlayer1 != null) {
			VerticalAlignment.pcmPlayer1.shutdown();
		}

		class153.field1356.method1904();
		ArchiveDiskAction.method1847();
		if (WorldMapLabel.urlRequester != null) {
			WorldMapLabel.urlRequester.close();
			WorldMapLabel.urlRequester = null;
		}

		try {
			JagexCache.JagexCache_dat2File.close();

			for (int var3 = 0; var3 < JagexCache.field1450; ++var3) {
				class302.JagexCache_idxFiles[var3].close();
			}

			JagexCache.JagexCache_idx255File.close();
			JagexCache.JagexCache_randomDat.close();
		} catch (Exception var5) {
		}

		this.field651.method50();
	}

	@ObfuscatedName("bl")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "2050335898"
	)
	protected final void vmethod1485() {
	}

	@ObfuscatedName("gz")
	@ObfuscatedSignature(
		descriptor = "(B)Z",
		garbageValue = "-57"
	)
	boolean method361() {
		return class20.field58 != null && !class20.field58.trim().isEmpty() && Script.field807 != null && !Script.field807.trim().isEmpty();
	}

	@ObfuscatedName("gi")
	@ObfuscatedSignature(
		descriptor = "(B)Z",
		garbageValue = "7"
	)
	boolean method362() {
		return class11.field36 != null && !class11.field36.trim().isEmpty() && Login.field766 != null && !Login.field766.trim().isEmpty();
	}

	@ObfuscatedName("gb")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "1435710939"
	)
	boolean method363() {
		return this.field656 != null;
	}

	@ObfuscatedName("gn")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;I)V",
		garbageValue = "-1913894736"
	)
	void method364(String var1) throws IOException {
		HashMap var2 = new HashMap();
		var2.put("grant_type", "refresh_token");
		var2.put("scope", "gamesso.token.create");
		var2.put("refresh_token", var1);
		URL var3 = new URL(BuddyRankComparator.field1182 + "shield/oauth/token" + (new class464(var2)).method2319());
		class420 var4 = new class420();
		var4.method2130(field650);
		var4.method2127("Host", (new URL(BuddyRankComparator.field1182)).getHost());
		var4.method2134(class461.field3889);
		class9 var5 = class9.field17;
		RefreshAccessTokenRequester var6 = this.field657;
		if (var6 != null) {
			this.field659 = var6.request(var5.method25(), var3, var4.method2126(), "");
		} else {
			class10 var7 = new class10(var3, var5, var4, this.field655);
			this.field653 = this.field651.method49(var7);
		}
	}

	@ObfuscatedName("gu")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;I)V",
		garbageValue = "828576760"
	)
	void method365(String var1) throws IOException {
		URL var2 = new URL(BuddyRankComparator.field1182 + "public/v1/games/YCfdbvr2pM1zUYMxJRexZY/play");
		class420 var3 = new class420();
		var3.method2131(var1);
		class9 var4 = class9.field18;
		OtlTokenRequester var5 = this.field656;
		if (var5 != null) {
			this.field660 = var5.request(var4.method25(), var2, var3.method2126(), "");
		} else {
			class10 var6 = new class10(var2, var4, var3, this.field655);
			this.field652 = this.field651.method49(var6);
		}
	}

	@ObfuscatedName("gw")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;Ljava/lang/String;I)V",
		garbageValue = "-176461860"
	)
	void method366(String var1, String var2) throws IOException, JSONException {
		URL var3 = new URL(BuddyRankComparator.field1182 + "game-session/v1/tokens");
		class10 var4 = new class10(var3, class9.field17, this.field655);
		var4.method31().method2131(var1);
		var4.method31().method2134(class461.field3889);
		JSONObject var5 = new JSONObject();
		var5.method2691("accountId", var2);
		var4.method32(new class463(var5));
		this.field652 = this.field651.method49(var4);
	}

	@ObfuscatedName("hh")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "1086320458"
	)
	@Export("doCycleJs5")
	void doCycleJs5() {
		if (gameState != 1000) {
			boolean var1 = class153.field1356.method1895();
			if (!var1) {
				this.method372();
			}

		}
	}

	@ObfuscatedName("hg")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "1146125856"
	)
	void method372() {
		if (class153.field1356.field3560 >= 4) {
			this.error("js5crc");
			class129.updateGameState(1000);
		} else {
			if (class153.field1356.field3561 >= 4) {
				if (gameState <= 5) {
					this.error("js5io");
					class129.updateGameState(1000);
					return;
				}

				js5Cycles = 3000;
				class153.field1356.field3561 = 3;
			}

			if (--js5Cycles + 1 <= 0) {
				try {
					if (js5ConnectState == 0) {
						class303.js5SocketTask = GameEngine.taskHandler.newSocketTask(VarbitComposition.worldHost, Varps.currentPort);
						++js5ConnectState;
					}

					if (js5ConnectState == 1) {
						if (class303.js5SocketTask.status == 2) {
							this.js5Error(-1);
							return;
						}

						if (class303.js5SocketTask.status == 1) {
							++js5ConnectState;
						}
					}

					if (js5ConnectState == 2) {
						class147.js5Socket = class310.method1640((Socket)class303.js5SocketTask.result, 40000, 5000);
						Buffer var1 = new Buffer(5);
						var1.writeByte(15);
						var1.writeInt(215);
						class147.js5Socket.write(var1.array, 0, 5);
						++js5ConnectState;
						class197.field1620 = class113.clockNow();
					}

					if (js5ConnectState == 3) {
						if (class147.js5Socket.available() > 0) {
							int var2 = class147.js5Socket.readUnsignedByte();
							if (var2 != 0) {
								this.js5Error(var2);
								return;
							}

							++js5ConnectState;
						} else if (class113.clockNow() - class197.field1620 > 30000L) {
							this.js5Error(-2);
							return;
						}
					}

					if (js5ConnectState == 4) {
						class153.field1356.method1897(class147.js5Socket, gameState > 20);
						class303.js5SocketTask = null;
						class147.js5Socket = null;
						js5ConnectState = 0;
						js5Errors = 0;
					}
				} catch (IOException var3) {
					this.js5Error(-3);
				}

			}
		}
	}

	@ObfuscatedName("ho")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "-2121536022"
	)
	@Export("js5Error")
	void js5Error(int var1) {
		class303.js5SocketTask = null;
		class147.js5Socket = null;
		js5ConnectState = 0;
		if (Varps.currentPort == Login.worldPort) {
			Varps.currentPort = class11.js5Port;
		} else {
			Varps.currentPort = Login.worldPort;
		}

		++js5Errors;
		if (js5Errors < 2 || var1 != 7 && var1 != 9) {
			if (js5Errors >= 2 && var1 == 6) {
				this.error("js5connect_outofdate");
				class129.updateGameState(1000);
			} else if (js5Errors >= 4) {
				if (gameState <= 5) {
					this.error("js5connect");
					class129.updateGameState(1000);
				} else {
					js5Cycles = 3000;
				}
			}
		} else if (gameState <= 5) {
			this.error("js5connect_full");
			class129.updateGameState(1000);
		} else {
			js5Cycles = 3000;
		}

	}

	@ObfuscatedName("hi")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "-10"
	)
	@Export("doCycleLoggedOut")
	final void doCycleLoggedOut() {
		AbstractSocket var1 = packetWriter.getSocket();
		PacketBuffer var2 = packetWriter.packetBuffer;

		try {
			if (loginState == 0) {
				if (ObjTypeCustomisation.secureRandom == null && (secureRandomFuture.isDone() || field440 > 250)) {
					ObjTypeCustomisation.secureRandom = secureRandomFuture.get();
					secureRandomFuture.shutdown();
					secureRandomFuture = null;
				}

				if (ObjTypeCustomisation.secureRandom != null) {
					if (var1 != null) {
						var1.close();
						var1 = null;
					}

					class457.socketTask = null;
					hadNetworkError = false;
					field440 = 0;
					if (field644.method2597()) {
						if (this.method361()) {
							try {
								this.method364(Script.field807);
								BuddyRankComparator.method686(21);
							} catch (Throwable var25) {
								class317.RunException_sendStackTrace((String)null, var25);
								GrandExchangeOfferTotalQuantityComparator.getLoginError(65);
								return;
							}
						} else {
							if (!this.method362()) {
								GrandExchangeOfferTotalQuantityComparator.getLoginError(65);
								return;
							}

							try {
								this.method366(class11.field36, Login.field766);
								BuddyRankComparator.method686(20);
							} catch (Exception var24) {
								class317.RunException_sendStackTrace((String)null, var24);
								GrandExchangeOfferTotalQuantityComparator.getLoginError(65);
								return;
							}
						}
					} else {
						BuddyRankComparator.method686(1);
					}
				}
			}

			class20 var27;
			if (loginState == 21) {
				if (this.field659 != null) {
					if (!this.field659.isDone()) {
						return;
					}

					if (this.field659.isCancelled()) {
						GrandExchangeOfferTotalQuantityComparator.getLoginError(65);
						this.field659 = null;
						return;
					}

					try {
						RefreshAccessTokenResponse var3 = (RefreshAccessTokenResponse)this.field659.get();
						if (!var3.isSuccess()) {
							GrandExchangeOfferTotalQuantityComparator.getLoginError(65);
							this.field659 = null;
							return;
						}

						class20.field58 = var3.getAccessToken();
						Script.field807 = var3.getRefreshToken();
						this.field659 = null;
					} catch (Exception var23) {
						class317.RunException_sendStackTrace((String)null, var23);
						GrandExchangeOfferTotalQuantityComparator.getLoginError(65);
						this.field659 = null;
						return;
					}
				} else {
					if (this.field653 == null) {
						GrandExchangeOfferTotalQuantityComparator.getLoginError(65);
						return;
					}

					if (!this.field653.method62()) {
						return;
					}

					if (this.field653.method61()) {
						class317.RunException_sendStackTrace(this.field653.method59(), (Throwable)null);
						GrandExchangeOfferTotalQuantityComparator.getLoginError(65);
						this.field653 = null;
						return;
					}

					var27 = this.field653.method63();
					if (var27.method70() != 200) {
						GrandExchangeOfferTotalQuantityComparator.getLoginError(65);
						this.field653 = null;
						return;
					}

					field440 = 0;
					class463 var4 = new class463(var27.method72());

					try {
						class20.field58 = var4.method2315().getString("access_token");
						Script.field807 = var4.method2315().getString("refresh_token");
					} catch (Exception var22) {
						class317.RunException_sendStackTrace("Error parsing tokens", var22);
						GrandExchangeOfferTotalQuantityComparator.getLoginError(65);
						this.field653 = null;
						return;
					}
				}

				this.method365(class20.field58);
				BuddyRankComparator.method686(20);
			}

			if (loginState == 20) {
				if (this.field660 != null) {
					if (!this.field660.isDone()) {
						return;
					}

					if (this.field660.isCancelled()) {
						GrandExchangeOfferTotalQuantityComparator.getLoginError(65);
						this.field660 = null;
						return;
					}

					try {
						OtlTokenResponse var28 = (OtlTokenResponse)this.field660.get();
						if (!var28.isSuccess()) {
							GrandExchangeOfferTotalQuantityComparator.getLoginError(65);
							this.field660 = null;
							return;
						}

						this.field658 = var28.getToken();
						this.field660 = null;
					} catch (Exception var21) {
						class317.RunException_sendStackTrace((String)null, var21);
						GrandExchangeOfferTotalQuantityComparator.getLoginError(65);
						this.field660 = null;
						return;
					}
				} else {
					if (this.field652 == null) {
						GrandExchangeOfferTotalQuantityComparator.getLoginError(65);
						return;
					}

					if (!this.field652.method62()) {
						return;
					}

					if (this.field652.method61()) {
						class317.RunException_sendStackTrace(this.field652.method59(), (Throwable)null);
						GrandExchangeOfferTotalQuantityComparator.getLoginError(65);
						this.field652 = null;
						return;
					}

					var27 = this.field652.method63();
					if (var27.method70() != 200) {
						class317.RunException_sendStackTrace("Response code: " + var27.method70() + "Response body: " + var27.method72(), (Throwable)null);
						GrandExchangeOfferTotalQuantityComparator.getLoginError(65);
						this.field652 = null;
						return;
					}

					List var29 = (List)var27.method71().get("Content-Type");
					if (var29 != null && var29.contains(class461.field3889.method2309())) {
						try {
							JSONObject var5 = new JSONObject(var27.method72());
							this.field658 = var5.getString("token");
						} catch (JSONException var20) {
							class317.RunException_sendStackTrace((String)null, var20);
							GrandExchangeOfferTotalQuantityComparator.getLoginError(65);
							this.field652 = null;
							return;
						}
					} else {
						this.field658 = var27.method72();
					}

					this.field652 = null;
				}

				field440 = 0;
				BuddyRankComparator.method686(1);
			}

			if (loginState == 1) {
				if (class457.socketTask == null) {
					class457.socketTask = GameEngine.taskHandler.newSocketTask(VarbitComposition.worldHost, Varps.currentPort);
				}

				if (class457.socketTask.status == 2) {
					throw new IOException();
				}

				if (class457.socketTask.status == 1) {
					var1 = class310.method1640((Socket)class457.socketTask.result, 40000, 5000);
					packetWriter.setSocket(var1);
					class457.socketTask = null;
					BuddyRankComparator.method686(2);
				}
			}

			PacketBufferNode var31;
			if (loginState == 2) {
				packetWriter.clearBuffer();
				var31 = class130.method708();
				var31.clientPacket = null;
				var31.clientPacketLength = 0;
				var31.packetBuffer = new PacketBuffer(5000);
				var31.packetBuffer.writeByte(LoginPacket.field2725.id);
				packetWriter.addNode(var31);
				packetWriter.flush();
				var2.offset = 0;
				BuddyRankComparator.method686(3);
			}

			int var13;
			if (loginState == 3) {
				if (VerticalAlignment.pcmPlayer1 != null) {
					VerticalAlignment.pcmPlayer1.method201();
				}

				if (var1.isAvailable(1)) {
					var13 = var1.readUnsignedByte();
					if (VerticalAlignment.pcmPlayer1 != null) {
						VerticalAlignment.pcmPlayer1.method201();
					}

					if (var13 != 0) {
						GrandExchangeOfferTotalQuantityComparator.getLoginError(var13);
						return;
					}

					var2.offset = 0;
					BuddyRankComparator.method686(4);
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
					class313.field2820 = var2.readLong();
					BuddyRankComparator.method686(5);
				}
			}

			if (loginState == 5) {
				packetWriter.packetBuffer.offset = 0;
				packetWriter.clearBuffer();
				PacketBuffer var30 = new PacketBuffer(500);
				int[] var33 = new int[]{ObjTypeCustomisation.secureRandom.nextInt(), ObjTypeCustomisation.secureRandom.nextInt(), ObjTypeCustomisation.secureRandom.nextInt(), ObjTypeCustomisation.secureRandom.nextInt()};
				var30.offset = 0;
				var30.writeByte(1);
				var30.writeInt(var33[0]);
				var30.writeInt(var33[1]);
				var30.writeInt(var33[2]);
				var30.writeInt(var33[3]);
				var30.writeLong(class313.field2820);
				if (gameState == 40) {
					var30.writeInt(GrandExchangeOfferWorldComparator.field3568[0]);
					var30.writeInt(GrandExchangeOfferWorldComparator.field3568[1]);
					var30.writeInt(GrandExchangeOfferWorldComparator.field3568[2]);
					var30.writeInt(GrandExchangeOfferWorldComparator.field3568[3]);
				} else {
					if (gameState == 50) {
						var30.writeByte(class139.field1308.rsOrdinal());
						var30.writeInt(World.field666);
					} else {
						var30.writeByte(field415.rsOrdinal());
						switch(field415.field1313) {
						case 1:
						case 4:
							var30.writeMedium(class424.field3758);
							++var30.offset;
							break;
						case 2:
							var30.offset += 4;
							break;
						case 3:
							var30.writeInt(class150.clientPreferences.method576(Login.Login_username));
						}
					}

					if (field644.method2597()) {
						var30.writeByte(class518.field4160.rsOrdinal());
						var30.writeStringCp1252NullTerminated(this.field658);
					} else {
						var30.writeByte(class518.field4159.rsOrdinal());
						var30.writeStringCp1252NullTerminated(Login.Login_password);
					}
				}

				var30.encryptRsa(class74.field736, class74.field737);
				GrandExchangeOfferWorldComparator.field3568 = var33;
				PacketBufferNode var6 = class130.method708();
				var6.clientPacket = null;
				var6.clientPacketLength = 0;
				var6.packetBuffer = new PacketBuffer(5000);
				var6.packetBuffer.offset = 0;
				if (gameState == 40) {
					var6.packetBuffer.writeByte(LoginPacket.RECONNECT_LOGIN_CONNECTION.id);
				} else {
					var6.packetBuffer.writeByte(LoginPacket.NEW_LOGIN_CONNECTION.id);
				}

				var6.packetBuffer.writeShort(0);
				int var7 = var6.packetBuffer.offset;
				var6.packetBuffer.writeInt(215);
				var6.packetBuffer.writeInt(1);
				var6.packetBuffer.writeByte(clientType);
				var6.packetBuffer.writeByte(field421);
				byte var8 = 0;
				var6.packetBuffer.writeByte(var8);
				var6.packetBuffer.writeBytes(var30.array, 0, var30.offset);
				int var9 = var6.packetBuffer.offset;
				var6.packetBuffer.writeStringCp1252NullTerminated(Login.Login_username);
				var6.packetBuffer.writeByte((isResizable ? 1 : 0) << 1 | (isLowDetail ? 1 : 0));
				var6.packetBuffer.writeShort(GrandExchangeOfferTotalQuantityComparator.canvasWidth);
				var6.packetBuffer.writeShort(WorldMapArchiveLoader.canvasHeight);
				VertexNormal.method1323(var6.packetBuffer);
				var6.packetBuffer.writeStringCp1252NullTerminated(class36.param9);
				var6.packetBuffer.writeInt(PcmPlayer.field182);
				if (param25 > 213) {
					var6.packetBuffer.writeByte(0);
				}

				Buffer var10 = new Buffer(NPCComposition.field1570.size());
				NPCComposition.field1570.write(var10);
				var6.packetBuffer.writeBytes(var10.array, 0, var10.array.length);
				var6.packetBuffer.writeByte(clientType);
				var6.packetBuffer.writeInt(0);
				var6.packetBuffer.writeIntME(class197.archive2.hash);
				var6.packetBuffer.writeIntLE(Interpreter.field713.hash);
				var6.packetBuffer.writeIntME(class151.field1352.hash);
				var6.packetBuffer.writeIntLE(0);
				var6.packetBuffer.writeIntME(class253.archive4.hash);
				var6.packetBuffer.writeIntIME(World.field670.hash);
				var6.packetBuffer.writeInt(class131.archive10.hash);
				var6.packetBuffer.writeIntIME(class7.archive11.hash);
				var6.packetBuffer.writeIntLE(class126.archive12.hash);
				var6.packetBuffer.writeIntLE(Canvas.archive9.hash);
				var6.packetBuffer.writeIntME(TileItem.archive7.hash);
				var6.packetBuffer.writeIntME(class191.field1546.hash);
				var6.packetBuffer.writeIntIME(Varcs.field1130.hash);
				var6.packetBuffer.writeIntLE(class386.archive8.hash);
				var6.packetBuffer.writeInt(GrandExchangeOfferOwnWorldComparator.field358.hash);
				var6.packetBuffer.writeIntIME(FontName.archive13.hash);
				var6.packetBuffer.writeInt(class106.field1099.hash);
				var6.packetBuffer.writeIntME(ReflectionCheck.field151.hash);
				var6.packetBuffer.writeIntIME(class148.field1335.hash);
				var6.packetBuffer.writeIntME(class149.field1340.hash);
				var6.packetBuffer.writeIntIME(class13.archive6.hash);
				var6.packetBuffer.xteaEncrypt(var33, var9, var6.packetBuffer.offset);
				var6.packetBuffer.writeLengthShort(var6.packetBuffer.offset - var7);
				packetWriter.addNode(var6);
				packetWriter.flush();
				packetWriter.isaacCipher = new IsaacCipher(var33);
				int[] var11 = new int[4];

				for (int var12 = 0; var12 < 4; ++var12) {
					var11[var12] = var33[var12] + 50;
				}

				var2.newIsaacCipher(var11);
				BuddyRankComparator.method686(6);
			}

			int var14;
			if (loginState == 6 && var1.available() > 0) {
				var13 = var1.readUnsignedByte();
				if (var13 == 61) {
					var14 = var1.available();
					Message.field347 = var14 == 1 && var1.readUnsignedByte() == 1;
					BuddyRankComparator.method686(5);
				}

				if (var13 == 21 && gameState == 20) {
					BuddyRankComparator.method686(12);
				} else if (var13 == 2) {
					BuddyRankComparator.method686(14);
				} else if (var13 == 15 && gameState == 40) {
					packetWriter.serverPacketLength = -1;
					BuddyRankComparator.method686(19);
				} else if (var13 == 64) {
					BuddyRankComparator.method686(10);
				} else if (var13 == 23 && field441 < 1) {
					++field441;
					BuddyRankComparator.method686(0);
				} else if (var13 == 29) {
					BuddyRankComparator.method686(17);
				} else {
					if (var13 != 69) {
						GrandExchangeOfferTotalQuantityComparator.getLoginError(var13);
						return;
					}

					BuddyRankComparator.method686(7);
				}
			}

			if (loginState == 7 && var1.available() >= 2) {
				var1.read(var2.array, 0, 2);
				var2.offset = 0;
				class386.field3640 = var2.readUnsignedShort();
				BuddyRankComparator.method686(8);
			}

			if (loginState == 8 && var1.available() >= class386.field3640) {
				var2.offset = 0;
				var1.read(var2.array, var2.offset, class386.field3640);
				class6 var32 = class304.method1581()[var2.readUnsignedByte()];

				try {
					class3 var35 = Interpreter.method424(var32);
					this.field654 = new class7(var2, var35);
					BuddyRankComparator.method686(9);
				} catch (Exception var19) {
					GrandExchangeOfferTotalQuantityComparator.getLoginError(22);
					return;
				}
			}

			if (loginState == 9 && this.field654.method14()) {
				this.field662 = this.field654.method16();
				this.field654.method15();
				this.field654 = null;
				if (this.field662 == null) {
					GrandExchangeOfferTotalQuantityComparator.getLoginError(22);
					return;
				}

				packetWriter.clearBuffer();
				var31 = class130.method708();
				var31.clientPacket = null;
				var31.clientPacketLength = 0;
				var31.packetBuffer = new PacketBuffer(5000);
				var31.packetBuffer.writeByte(LoginPacket.field2724.id);
				var31.packetBuffer.writeShort(this.field662.offset);
				var31.packetBuffer.method2517(this.field662);
				packetWriter.addNode(var31);
				packetWriter.flush();
				this.field662 = null;
				BuddyRankComparator.method686(6);
			}

			if (loginState == 10 && var1.available() > 0) {
				class293.field2480 = var1.readUnsignedByte();
				BuddyRankComparator.method686(11);
			}

			if (loginState == 11 && var1.available() >= class293.field2480) {
				var1.read(var2.array, 0, class293.field2480);
				var2.offset = 0;
				BuddyRankComparator.method686(6);
			}

			if (loginState == 12 && var1.available() > 0) {
				field442 = (var1.readUnsignedByte() + 3) * 60;
				BuddyRankComparator.method686(13);
			}

			if (loginState == 13) {
				field440 = 0;
				Actor.setLoginResponseString("You have only just left another world.", "Your profile will be transferred in:", field442 / 60 + " seconds.");
				if (--field442 <= 0) {
					BuddyRankComparator.method686(0);
				}

			} else {
				if (loginState == 14 && var1.available() >= 1) {
					class28.playerUUIDLength = var1.readUnsignedByte();
					BuddyRankComparator.method686(15);
				}

				if (loginState == 15 && var1.available() >= class28.playerUUIDLength) {
					boolean var43 = var1.readUnsignedByte() == 1;
					var1.read(var2.array, 0, 4);
					var2.offset = 0;
					boolean var42 = false;
					if (var43) {
						var14 = var2.readByteIsaac() << 24;
						var14 |= var2.readByteIsaac() << 16;
						var14 |= var2.readByteIsaac() << 8;
						var14 |= var2.readByteIsaac();
						class150.clientPreferences.method574(Login.Login_username, var14);
					}

					if (Login_isUsernameRemembered) {
						class150.clientPreferences.setUsernameToRemember(Login.Login_username);
					} else {
						class150.clientPreferences.setUsernameToRemember((String)null);
					}

					GrandExchangeEvents.savePreferences();
					staffModLevel = var1.readUnsignedByte();
					playerMod = var1.readUnsignedByte() == 1;
					localPlayerIndex = var1.readUnsignedByte();
					localPlayerIndex <<= 8;
					localPlayerIndex += var1.readUnsignedByte();
					isMembers = var1.readUnsignedByte();
					var1.read(var2.array, 0, 8);
					var2.offset = 0;
					this.field661 = var2.readLong();
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
					ServerPacket[] var36 = Messages.method635();
					int var15 = var2.readSmartByteShortIsaac();
					if (var15 < 0 || var15 >= var36.length) {
						throw new IOException(var15 + " " + var2.offset);
					}

					packetWriter.serverPacket = var36[var15];
					packetWriter.serverPacketLength = packetWriter.serverPacket.length;
					var1.read(var2.array, 0, 2);
					var2.offset = 0;
					packetWriter.serverPacketLength = var2.readUnsignedShort();

					try {
						Client var16 = TileItem.client;
						//JSObject.getWindow(var16).call("zap", (Object[])null);
					} catch (Throwable var18) {
					}

					BuddyRankComparator.method686(16);
				}

				if (loginState == 16) {
					if (var1.available() >= packetWriter.serverPacketLength) {
						var2.offset = 0;
						var1.read(var2.array, 0, packetWriter.serverPacketLength);
						timer.method2116();
						mouseLastLastPressedTimeMillis = -1L;
						class497.mouseRecorder.index = 0;
						class326.hasFocus = true;
						hadFocus = true;
						timeOfPreviousKeyPress = -1L;
						class19.method66();
						packetWriter.clearBuffer();
						packetWriter.packetBuffer.offset = 0;
						packetWriter.serverPacket = null;
						packetWriter.field1147 = null;
						packetWriter.field1146 = null;
						packetWriter.field1148 = null;
						packetWriter.serverPacketLength = 0;
						packetWriter.field1141 = 0;
						rebootTimer = 0;
						logoutTimer = 0;
						hintArrowType = 0;
						menuOptionsCount = 0;
						isMenuOpen = false;
						ApproximateRouteStrategy.method349(0);
						SoundCache.method224();
						isItemSelected = 0;
						isSpellSelected = false;
						soundEffectCount = 0;
						camAngleY = 0;
						oculusOrbState = 0;
						UserComparator7.field1171 = null;
						minimapState = 0;
						field535 = -1;
						destinationX = 0;
						destinationY = 0;
						playerAttackOption = AttackOption.AttackOption_hidden;
						npcAttackOption = AttackOption.AttackOption_hidden;
						npcCount = 0;
						CollisionMap.method1102();

						for (var13 = 0; var13 < 2048; ++var13) {
							players[var13] = null;
						}

						for (var13 = 0; var13 < 65536; ++var13) {
							npcs[var13] = null;
						}

						combatTargetPlayerIndex = -1;
						projectiles.clear();
						graphicsObjects.clear();

						for (var13 = 0; var13 < 4; ++var13) {
							for (var14 = 0; var14 < 104; ++var14) {
								for (int var17 = 0; var17 < 104; ++var17) {
									groundItems[var13][var14][var17] = null;
								}
							}
						}

						pendingSpawns = new NodeDeque();
						class177.friendSystem.clear();

						for (var13 = 0; var13 < VarpDefinition.field1491; ++var13) {
							VarpDefinition var41 = class158.VarpDefinition_get(var13);
							if (var41 != null) {
								Varps.Varps_temp[var13] = 0;
								Varps.Varps_main[var13] = 0;
							}
						}

						PendingSpawn.varcs.clearTransient();
						followerIndex = -1;
						if (rootInterface != -1) {
							var13 = rootInterface;
							if (var13 != -1 && Widget.Widget_loadedInterfaces[var13]) {
								ArchiveLoader.Widget_archive.clearFilesGroup(var13);
								if (ArchiveLoader.Widget_interfaceComponents[var13] != null) {
									for (var14 = 0; var14 < ArchiveLoader.Widget_interfaceComponents[var13].length; ++var14) {
										if (ArchiveLoader.Widget_interfaceComponents[var13][var14] != null) {
											ArchiveLoader.Widget_interfaceComponents[var13][var14] = null;
										}
									}

									ArchiveLoader.Widget_interfaceComponents[var13] = null;
									Widget.Widget_loadedInterfaces[var13] = false;
								}
							}
						}

						for (InterfaceParent var37 = (InterfaceParent)interfaceParents.first(); var37 != null; var37 = (InterfaceParent)interfaceParents.next()) {
							Actor.closeInterface(var37, true);
						}

						rootInterface = -1;
						interfaceParents = new NodeHashTable(8);
						meslayerContinueWidget = null;
						menuOptionsCount = 0;
						isMenuOpen = false;
						playerAppearance.method1680((int[])null, (int[])null, new int[]{0, 0, 0, 0, 0}, 0, -1);

						for (var13 = 0; var13 < 8; ++var13) {
							playerMenuActions[var13] = null;
							playerOptionsPriorities[var13] = false;
						}

						ItemContainer.itemContainers = new NodeHashTable(32);
						isLoading = true;

						for (var13 = 0; var13 < 100; ++var13) {
							field403[var13] = true;
						}

						class409.method2108();
						Canvas.friendsChat = null;
						class11.guestClanSettings = null;
						Arrays.fill(currentClanSettings, (Object)null);
						WorldMapLabelSize.guestClanChannel = null;
						Arrays.fill(currentClanChannels, (Object)null);

						for (var13 = 0; var13 < 8; ++var13) {
							grandExchangeOffers[var13] = new GrandExchangeOffer();
						}

						class28.grandExchangeEvents = null;
						field371 = false;
						class164.updatePlayer(var2);
						class309.timeOfPreviousKeyPress = -1;
						class303.loadRegions(false, var2);
						packetWriter.serverPacket = null;
					}

				} else {
					if (loginState == 17 && var1.available() >= 2) {
						var2.offset = 0;
						var1.read(var2.array, 0, 2);
						var2.offset = 0;
						WorldMapSectionType.field2392 = var2.readUnsignedShort();
						BuddyRankComparator.method686(18);
					}

					if (loginState == 18 && var1.available() >= WorldMapSectionType.field2392) {
						var2.offset = 0;
						var1.read(var2.array, 0, WorldMapSectionType.field2392);
						var2.offset = 0;
						String var34 = var2.readStringCp1252NullTerminated();
						String var39 = var2.readStringCp1252NullTerminated();
						String var38 = var2.readStringCp1252NullTerminated();
						Actor.setLoginResponseString(var34, var39, var38);
						class129.updateGameState(10);
						if (field644.method2597()) {
							class328.method1678(9);
						}
					}

					if (loginState != 19) {
						++field440;
						if (field440 > 2000) {
							if (field441 < 1) {
								if (Login.worldPort == Varps.currentPort) {
									Varps.currentPort = class11.js5Port;
								} else {
									Varps.currentPort = Login.worldPort;
								}

								++field441;
								BuddyRankComparator.method686(0);
							} else {
								GrandExchangeOfferTotalQuantityComparator.getLoginError(-3);
							}
						}
					} else {
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
							timer.method2118();
							packetWriter.clearBuffer();
							packetWriter.packetBuffer.offset = 0;
							packetWriter.serverPacket = null;
							packetWriter.field1147 = null;
							packetWriter.field1146 = null;
							packetWriter.field1148 = null;
							packetWriter.serverPacketLength = 0;
							packetWriter.field1141 = 0;
							rebootTimer = 0;
							menuOptionsCount = 0;
							isMenuOpen = false;
							minimapState = 0;
							destinationX = 0;

							for (var14 = 0; var14 < 2048; ++var14) {
								players[var14] = null;
							}

							class136.localPlayer = null;

							for (var14 = 0; var14 < npcs.length; ++var14) {
								NPC var40 = npcs[var14];
								if (var40 != null) {
									var40.targetIndex = -1;
									var40.false0 = false;
								}
							}

							ItemContainer.itemContainers = new NodeHashTable(32);
							class129.updateGameState(30);

							for (var14 = 0; var14 < 100; ++var14) {
								field403[var14] = true;
							}

							class409.method2108();
							class164.updatePlayer(var2);
							if (var13 != var2.offset) {
								throw new RuntimeException();
							}
						}
					}
				}
			}
		} catch (IOException var26) {
			if (field441 < 1) {
				if (Login.worldPort == Varps.currentPort) {
					Varps.currentPort = class11.js5Port;
				} else {
					Varps.currentPort = Login.worldPort;
				}

				++field441;
				BuddyRankComparator.method686(0);
			} else {
				GrandExchangeOfferTotalQuantityComparator.getLoginError(-2);
			}
		}
	}

	@ObfuscatedName("hu")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "2055696363"
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
			class93.method508();
		} else {
			if (!isMenuOpen) {
				class89.addCancelMenuEntry();
			}

			int var1;
			for (var1 = 0; var1 < 100 && this.method382(packetWriter); ++var1) {
			}

			if (gameState == 30) {
				int var2;
				PacketBufferNode var14;
				while (GraphicsObject.method430()) {
					var14 = class503.getPacketBufferNode(ClientPacket.field2538, packetWriter.isaacCipher);
					var14.packetBuffer.writeByte(0);
					var2 = var14.packetBuffer.offset;
					ArchiveDiskAction.performReflectionCheck(var14.packetBuffer);
					var14.packetBuffer.method2520(var14.packetBuffer.offset - var2);
					packetWriter.addNode(var14);
				}

				if (timer.field3747) {
					var14 = class503.getPacketBufferNode(ClientPacket.field2539, packetWriter.isaacCipher);
					var14.packetBuffer.writeByte(0);
					var2 = var14.packetBuffer.offset;
					timer.write(var14.packetBuffer);
					var14.packetBuffer.method2520(var14.packetBuffer.offset - var2);
					packetWriter.addNode(var14);
					timer.method2117();
				}

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
				PacketBuffer var10000;
				synchronized(class497.mouseRecorder.lock) {
					if (!lockMouseRecorder) {
						class497.mouseRecorder.index = 0;
					} else if (MouseHandler.MouseHandler_lastButton != 0 || class497.mouseRecorder.index >= 40) {
						PacketBufferNode var15 = null;
						var3 = 0;
						var4 = 0;
						var5 = 0;
						var6 = 0;

						for (var7 = 0; var7 < class497.mouseRecorder.index && (var15 == null || var15.packetBuffer.offset - var3 < 246); ++var7) {
							var4 = var7;
							var8 = class497.mouseRecorder.ys[var7];
							if (var8 < -1) {
								var8 = -1;
							} else if (var8 > 65534) {
								var8 = 65534;
							}

							var9 = class497.mouseRecorder.xs[var7];
							if (var9 < -1) {
								var9 = -1;
							} else if (var9 > 65534) {
								var9 = 65534;
							}

							if (var9 != lastMouseRecordX || var8 != lastMouseRecordY) {
								if (var15 == null) {
									var15 = class503.getPacketBufferNode(ClientPacket.field2483, packetWriter.isaacCipher);
									var15.packetBuffer.writeByte(0);
									var3 = var15.packetBuffer.offset;
									var10000 = var15.packetBuffer;
									var10000.offset += 2;
									var5 = 0;
									var6 = 0;
								}

								if (-1L != field609) {
									var10 = var9 - lastMouseRecordX;
									var11 = var8 - lastMouseRecordY;
									var12 = (int)((class497.mouseRecorder.millis[var7] - field609) / 20L);
									var5 = (int)((long)var5 + (class497.mouseRecorder.millis[var7] - field609) % 20L);
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
									var15.packetBuffer.writeShort((var12 & 8191) + 57344);
									if (var9 != -1 && var8 != -1) {
										var15.packetBuffer.writeInt(var9 | var8 << 16);
									} else {
										var15.packetBuffer.writeInt(Integer.MIN_VALUE);
									}
								}

								++var6;
								field609 = class497.mouseRecorder.millis[var7];
							}
						}

						if (var15 != null) {
							var15.packetBuffer.method2520(var15.packetBuffer.offset - var3);
							var7 = var15.packetBuffer.offset;
							var15.packetBuffer.offset = var3;
							var15.packetBuffer.writeByte(var5 / var6);
							var15.packetBuffer.writeByte(var5 % var6);
							var15.packetBuffer.offset = var7;
							packetWriter.addNode(var15);
						}

						if (var4 >= class497.mouseRecorder.index) {
							class497.mouseRecorder.index = 0;
						} else {
							MouseRecorder var50 = class497.mouseRecorder;
							var50.index -= var4;
							System.arraycopy(class497.mouseRecorder.xs, var4, class497.mouseRecorder.xs, 0, class497.mouseRecorder.index);
							System.arraycopy(class497.mouseRecorder.ys, var4, class497.mouseRecorder.ys, 0, class497.mouseRecorder.index);
							System.arraycopy(class497.mouseRecorder.millis, var4, class497.mouseRecorder.millis, 0, class497.mouseRecorder.index);
						}
					}
				}

				PacketBufferNode var18;
				if (MouseHandler.MouseHandler_lastButton == 1 || !class28.mouseCam && MouseHandler.MouseHandler_lastButton == 4 || MouseHandler.MouseHandler_lastButton == 2) {
					long var16 = MouseHandler.MouseHandler_lastPressedTimeMillis - mouseLastLastPressedTimeMillis;
					if (var16 > 32767L) {
						var16 = 32767L;
					}

					mouseLastLastPressedTimeMillis = MouseHandler.MouseHandler_lastPressedTimeMillis;
					var3 = MouseHandler.MouseHandler_lastPressedY;
					if (var3 < 0) {
						var3 = 0;
					} else if (var3 > WorldMapArchiveLoader.canvasHeight) {
						var3 = WorldMapArchiveLoader.canvasHeight;
					}

					var4 = MouseHandler.MouseHandler_lastPressedX;
					if (var4 < 0) {
						var4 = 0;
					} else if (var4 > GrandExchangeOfferTotalQuantityComparator.canvasWidth) {
						var4 = GrandExchangeOfferTotalQuantityComparator.canvasWidth;
					}

					var5 = (int)var16;
					var18 = class503.getPacketBufferNode(ClientPacket.field2485, packetWriter.isaacCipher);
					var18.packetBuffer.writeShort((var5 << 1) + (MouseHandler.MouseHandler_lastButton == 2 ? 1 : 0));
					var18.packetBuffer.writeShort(var4);
					var18.packetBuffer.writeShort(var3);
					packetWriter.addNode(var18);
				}

				if (mouseWheelRotation != 0) {
					var14 = class503.getPacketBufferNode(ClientPacket.field2570, packetWriter.isaacCipher);
					var14.packetBuffer.writeShort(mouseWheelRotation);
					packetWriter.addNode(var14);
				}

				if (keyHandlerInstance.pressedKeysCount > 0) {
					var14 = class503.getPacketBufferNode(ClientPacket.field2494, packetWriter.isaacCipher);
					var14.packetBuffer.writeShort(0);
					var2 = var14.packetBuffer.offset;
					long var19 = class113.clockNow();

					for (var5 = 0; var5 < keyHandlerInstance.pressedKeysCount; ++var5) {
						long var21 = var19 - timeOfPreviousKeyPress;
						if (var21 > 16777215L) {
							var21 = 16777215L;
						}

						timeOfPreviousKeyPress = var19;
						var14.packetBuffer.writeMed0((int)var21);
						var14.packetBuffer.writeByteAdd(keyHandlerInstance.field1870[var5]);
					}

					var14.packetBuffer.writeLengthShort(var14.packetBuffer.offset - var2);
					packetWriter.addNode(var14);
				}

				if (field469 > 0) {
					--field469;
				}

				if (keyHandlerInstance.getKeyPressed(96) || keyHandlerInstance.getKeyPressed(97) || keyHandlerInstance.getKeyPressed(98) || keyHandlerInstance.getKeyPressed(99)) {
					field379 = true;
				}

				if (field379 && field469 <= 0) {
					field469 = 20;
					field379 = false;
					var14 = class503.getPacketBufferNode(ClientPacket.field2559, packetWriter.isaacCipher);
					var14.packetBuffer.writeShort(camAngleY);
					var14.packetBuffer.writeShort(camAngleX);
					packetWriter.addNode(var14);
				}

				if (class326.hasFocus && !hadFocus) {
					hadFocus = true;
					var14 = class503.getPacketBufferNode(ClientPacket.field2505, packetWriter.isaacCipher);
					var14.packetBuffer.writeByte(1);
					packetWriter.addNode(var14);
				}

				if (!class326.hasFocus && hadFocus) {
					hadFocus = false;
					var14 = class503.getPacketBufferNode(ClientPacket.field2505, packetWriter.isaacCipher);
					var14.packetBuffer.writeByte(0);
					packetWriter.addNode(var14);
				}

				if (class127.worldMap != null) {
					class127.worldMap.method2359();
				}

				Player var31;
				if (DynamicObject.ClanChat_inClanChat) {
					if (Canvas.friendsChat != null) {
						Canvas.friendsChat.sort();
					}

					for (var1 = 0; var1 < Players.Players_count; ++var1) {
						var31 = players[Players.Players_indices[var1]];
						var31.clearIsInFriendsChat();
					}

					DynamicObject.ClanChat_inClanChat = false;
				}

				if (class458.field3887) {
					for (var1 = 0; var1 < Players.Players_count; ++var1) {
						var31 = players[Players.Players_indices[var1]];
						var31.clearIsInClanChat();
					}

					class458.field3887 = false;
				}

				if (class36.Client_plane != field535) {
					field535 = class36.Client_plane;
					class12.method43(class36.Client_plane);
				}

				if (gameState == 30) {
					for (PendingSpawn var30 = (PendingSpawn)pendingSpawns.last(); var30 != null; var30 = (PendingSpawn)pendingSpawns.previous()) {
						if (var30.endCycle > 0) {
							--var30.endCycle;
						}

						if (var30.endCycle == 0) {
							if (var30.objectId < 0 || DevicePcmPlayerProvider.method80(var30.objectId, var30.field943)) {
								ObjTypeCustomisation.addPendingSpawnToScene(var30.plane, var30.type, var30.x, var30.y, var30.objectId, var30.field945, var30.field943, var30.field948);
								var30.remove();
							}
						} else {
							if (var30.startCycle > 0) {
								--var30.startCycle;
							}

							if (var30.startCycle == 0 && var30.x >= 1 && var30.y >= 1 && var30.x <= 102 && var30.y <= 102 && (var30.id < 0 || DevicePcmPlayerProvider.method80(var30.id, var30.objectType))) {
								ObjTypeCustomisation.addPendingSpawnToScene(var30.plane, var30.type, var30.x, var30.y, var30.id, var30.rotation, var30.objectType, var30.field948);
								var30.startCycle = -1;
								if (var30.objectId == var30.id && var30.objectId == -1) {
									var30.remove();
								} else if (var30.objectId == var30.id && var30.field945 == var30.rotation && var30.objectType == var30.field943) {
									var30.remove();
								}
							}
						}
					}

					int var10002;
					for (var1 = 0; var1 < soundEffectCount; ++var1) {
						var10002 = queuedSoundEffectDelays[var1]--;
						if (queuedSoundEffectDelays[var1] >= -10) {
							SoundEffect var34 = soundEffects[var1];
							if (var34 == null) {
								var10000 = null;
								var34 = SoundEffect.readSoundEffect(class149.field1340, soundEffectIds[var1], 0);
								if (var34 == null) {
									continue;
								}

								int[] var51 = queuedSoundEffectDelays;
								var51[var1] += var34.calculateDelay();
								soundEffects[var1] = var34;
							}

							if (queuedSoundEffectDelays[var1] < 0) {
								if (soundLocations[var1] != 0) {
									var4 = (soundLocations[var1] & 255) * 128;
									var5 = soundLocations[var1] >> 16 & 255;
									var6 = var5 * 128 + 64 - class136.localPlayer.x;
									if (var6 < 0) {
										var6 = -var6;
									}

									var7 = soundLocations[var1] >> 8 & 255;
									var8 = var7 * 128 + 64 - class136.localPlayer.y;
									if (var8 < 0) {
										var8 = -var8;
									}

									var9 = var8 + var6 - 128;
									if (var9 > var4) {
										queuedSoundEffectDelays[var1] = -100;
										continue;
									}

									if (var9 < 0) {
										var9 = 0;
									}

									var3 = (var4 - var9) * class150.clientPreferences.getAreaSoundEffectsVolume() / var4;
								} else {
									var3 = class150.clientPreferences.getCurrentSoundEffectsVolume();
								}

								if (var3 > 0) {
									RawSound var23 = var34.toRawSound().resample(SoundCache.decimator);
									RawPcmStream var24 = RawPcmStream.createRawPcmStream(var23, 100, var3);
									var24.setNumLoops(queuedSoundEffectLoops[var1] - 1);
									SecureRandomCallable.pcmStreamMixer.addSubStream(var24);
								}

								queuedSoundEffectDelays[var1] = -100;
							}
						} else {
							--soundEffectCount;

							for (var2 = var1; var2 < soundEffectCount; ++var2) {
								soundEffectIds[var2] = soundEffectIds[var2 + 1];
								soundEffects[var2] = soundEffects[var2 + 1];
								queuedSoundEffectLoops[var2] = queuedSoundEffectLoops[var2 + 1];
								queuedSoundEffectDelays[var2] = queuedSoundEffectDelays[var2 + 1];
								soundLocations[var2] = soundLocations[var2 + 1];
							}

							--var1;
						}
					}

					if (playingJingle && !ItemContainer.method466()) {
						if (class150.clientPreferences.getCurrentMusicVolume() != 0 && HorizontalAlignment.method960()) {
							Archive var32 = class13.archive6;
							var2 = class150.clientPreferences.getCurrentMusicVolume();
							if (!class306.field2755.isEmpty()) {
								ArrayList var25 = new ArrayList();
								Iterator var38 = class306.field2755.iterator();

								while (var38.hasNext()) {
									class318 var41 = (class318)var38.next();
									var41.field2852 = false;
									var41.field2849 = false;
									var41.field2851 = false;
									var41.field2859 = var32;
									var41.field2854 = var2;
									var41.field2853 = 0.0F;
									var25.add(var41);
								}

								UserComparator4.method663(var25, class306.musicPlayerStatus, class306.field2753, class306.field2754, class306.field2751, false);
							}
						}

						playingJingle = false;
					}

					++packetWriter.field1141;
					if (packetWriter.field1141 > 750) {
						class93.method508();
					} else {
						class27.method115();
						class132.method725();
						int[] var33 = Players.Players_indices;

						for (var2 = 0; var2 < Players.Players_count; ++var2) {
							Player var45 = players[var33[var2]];
							if (var45 != null && var45.overheadTextCyclesRemaining > 0) {
								--var45.overheadTextCyclesRemaining;
								if (var45.overheadTextCyclesRemaining == 0) {
									var45.overheadText = null;
								}
							}
						}

						for (var2 = 0; var2 < npcCount; ++var2) {
							var3 = npcIndices[var2];
							NPC var39 = npcs[var3];
							if (var39 != null && var39.overheadTextCyclesRemaining > 0) {
								--var39.overheadTextCyclesRemaining;
								if (var39.overheadTextCyclesRemaining == 0) {
									var39.overheadText = null;
								}
							}
						}

						++field452;
						if (mouseCrossColor != 0) {
							mouseCrossState += 20;
							if (mouseCrossState >= 400) {
								mouseCrossColor = 0;
							}
						}

						Widget var35 = WorldMapScaleHandler.mousedOverWidgetIf1;
						Widget var37 = class403.field3700;
						WorldMapScaleHandler.mousedOverWidgetIf1 = null;
						class403.field3700 = null;
						draggedOnWidget = null;
						field393 = false;
						field391 = false;
						field529 = 0;

						while (keyHandlerInstance.method1085() && field529 < 128) {
							if (staffModLevel >= 2 && keyHandlerInstance.getKeyPressed(82) && keyHandlerInstance.field1869 == 66) {
								StringBuilder var40 = new StringBuilder();

								Message var36;
								for (Iterator var43 = Messages.Messages_hashTable.iterator(); var43.hasNext(); var40.append(var36.text).append('\n')) {
									var36 = (Message)var43.next();
									if (var36.sender != null && !var36.sender.isEmpty()) {
										var40.append(var36.sender).append(':');
									}
								}

								String var46 = var40.toString();
								TileItem.client.method141(var46);
							} else if (oculusOrbState != 1 || keyHandlerInstance.field1867 <= 0) {
								field578[field529] = keyHandlerInstance.field1869;
								field576[field529] = keyHandlerInstance.field1867;
								++field529;
							}
						}

						if (class158.method835() && keyHandlerInstance.getKeyPressed(82) && keyHandlerInstance.getKeyPressed(81) && mouseWheelRotation != 0) {
							var3 = class136.localPlayer.plane - mouseWheelRotation;
							if (var3 < 0) {
								var3 = 0;
							} else if (var3 > 3) {
								var3 = 3;
							}

							if (var3 != class136.localPlayer.plane) {
								var4 = class136.localPlayer.pathX[0] + AbstractArchive.baseX;
								var5 = class136.localPlayer.pathY[0] + class148.baseY;
								var18 = class503.getPacketBufferNode(ClientPacket.field2498, packetWriter.isaacCipher);
								var18.packetBuffer.writeIntME(0);
								var18.packetBuffer.writeShortAddLE(var4);
								var18.packetBuffer.writeByteAdd(var3);
								var18.packetBuffer.writeShortAdd(var5);
								packetWriter.addNode(var18);
							}

							mouseWheelRotation = 0;
						}

						if (MouseHandler.MouseHandler_lastButton == 1) {
							field594.method1071();
						}

						if (rootInterface != -1) {
							class10.updateRootInterface(rootInterface, 0, 0, GrandExchangeOfferTotalQuantityComparator.canvasWidth, WorldMapArchiveLoader.canvasHeight, 0, 0);
						}

						++cycleCntr;

						while (true) {
							Widget var42;
							Widget var44;
							ScriptEvent var47;
							do {
								var47 = (ScriptEvent)field624.removeLast();
								if (var47 == null) {
									while (true) {
										do {
											var47 = (ScriptEvent)field626.removeLast();
											if (var47 == null) {
												while (true) {
													do {
														var47 = (ScriptEvent)scriptEvents.removeLast();
														if (var47 == null) {
															while (true) {
																class212 var49 = (class212)field625.removeLast();
																if (var49 == null) {
																	this.menu();
																	if (class127.worldMap != null) {
																		class127.worldMap.method2369(class36.Client_plane, (class136.localPlayer.x >> 7) + AbstractArchive.baseX, (class136.localPlayer.y >> 7) + class148.baseY, false);
																		class127.worldMap.loadCache();
																	}

																	if (clickedWidget != null) {
																		this.method389();
																	}

																	if (Scene.shouldSendWalk()) {
																		var3 = Scene.Scene_selectedX;
																		var4 = Scene.Scene_selectedY;
																		PacketBufferNode var48 = class503.getPacketBufferNode(ClientPacket.field2569, packetWriter.isaacCipher);
																		var48.packetBuffer.writeByte(5);
																		var48.packetBuffer.writeShort(var3 + AbstractArchive.baseX);
																		var48.packetBuffer.writeByteAdd(keyHandlerInstance.getKeyPressed(82) ? (keyHandlerInstance.getKeyPressed(81) ? 2 : 1) : 0);
																		var48.packetBuffer.writeShortLE(var4 + class148.baseY);
																		packetWriter.addNode(var48);
																		Scene.method1253();
																		mouseCrossX = MouseHandler.MouseHandler_lastPressedX;
																		mouseCrossY = MouseHandler.MouseHandler_lastPressedY;
																		mouseCrossColor = 1;
																		mouseCrossState = 0;
																		destinationX = var3;
																		destinationY = var4;
																	}

																	if (var35 != WorldMapScaleHandler.mousedOverWidgetIf1) {
																		if (var35 != null) {
																			class200.invalidateWidget(var35);
																		}

																		if (WorldMapScaleHandler.mousedOverWidgetIf1 != null) {
																			class200.invalidateWidget(WorldMapScaleHandler.mousedOverWidgetIf1);
																		}
																	}

																	if (var37 != class403.field3700 && field493 == field494) {
																		if (var37 != null) {
																			class200.invalidateWidget(var37);
																		}

																		if (class403.field3700 != null) {
																			class200.invalidateWidget(class403.field3700);
																		}
																	}

																	if (class403.field3700 != null) {
																		if (field494 < field493) {
																			++field494;
																			if (field493 == field494) {
																				class200.invalidateWidget(class403.field3700);
																			}
																		}
																	} else if (field494 > 0) {
																		--field494;
																	}

																	if (oculusOrbState == 0) {
																		var3 = class136.localPlayer.x;
																		var4 = class136.localPlayer.y;
																		if (class467.oculusOrbFocalPointX - var3 < -500 || class467.oculusOrbFocalPointX - var3 > 500 || class36.oculusOrbFocalPointY - var4 < -500 || class36.oculusOrbFocalPointY - var4 > 500) {
																			class467.oculusOrbFocalPointX = var3;
																			class36.oculusOrbFocalPointY = var4;
																		}

																		if (var3 != class467.oculusOrbFocalPointX) {
																			class467.oculusOrbFocalPointX += (var3 - class467.oculusOrbFocalPointX) / 16;
																		}

																		if (var4 != class36.oculusOrbFocalPointY) {
																			class36.oculusOrbFocalPointY += (var4 - class36.oculusOrbFocalPointY) / 16;
																		}

																		var5 = class467.oculusOrbFocalPointX >> 7;
																		var6 = class36.oculusOrbFocalPointY >> 7;
																		var7 = class306.getTileHeight(class467.oculusOrbFocalPointX, class36.oculusOrbFocalPointY, class36.Client_plane);
																		var8 = 0;
																		if (var5 > 3 && var6 > 3 && var5 < 100 && var6 < 100) {
																			for (var9 = var5 - 4; var9 <= var5 + 4; ++var9) {
																				for (var10 = var6 - 4; var10 <= var6 + 4; ++var10) {
																					var11 = class36.Client_plane;
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

																		if (var9 > field475) {
																			field475 += (var9 - field475) / 24;
																		} else if (var9 < field475) {
																			field475 += (var9 - field475) / 80;
																		}

																		class90.field887 = class306.getTileHeight(class136.localPlayer.x, class136.localPlayer.y, class36.Client_plane) - camFollowHeight;
																	} else if (oculusOrbState == 1) {
																		Bounds.method2263();
																		short var29 = -1;
																		if (keyHandlerInstance.getKeyPressed(33)) {
																			var29 = 0;
																		} else if (keyHandlerInstance.getKeyPressed(49)) {
																			var29 = 1024;
																		}

																		if (keyHandlerInstance.getKeyPressed(48)) {
																			if (var29 == 0) {
																				var29 = 1792;
																			} else if (var29 == 1024) {
																				var29 = 1280;
																			} else {
																				var29 = 1536;
																			}
																		} else if (keyHandlerInstance.getKeyPressed(50)) {
																			if (var29 == 0) {
																				var29 = 256;
																			} else if (var29 == 1024) {
																				var29 = 768;
																			} else {
																				var29 = 512;
																			}
																		}

																		byte var28 = 0;
																		if (keyHandlerInstance.getKeyPressed(35)) {
																			var28 = -1;
																		} else if (keyHandlerInstance.getKeyPressed(51)) {
																			var28 = 1;
																		}

																		var5 = 0;
																		if (var29 >= 0 || var28 != 0) {
																			var5 = keyHandlerInstance.getKeyPressed(81) ? oculusOrbSlowedSpeed * 1568461633 * -427705151 : oculusOrbNormalSpeed * 1667775323 * 1739947219;
																			var5 *= 16;
																			field473 = var29;
																			field468 = var28;
																		}

																		if (field464 < var5) {
																			field464 += var5 / 8;
																			if (field464 > var5) {
																				field464 = var5;
																			}
																		} else if (field464 > var5) {
																			field464 = field464 * 9 / 10;
																		}

																		if (field464 > 0) {
																			var6 = field464 / 16;
																			if (field473 >= 0) {
																				var3 = field473 - class456.cameraYaw & 2047;
																				var7 = Rasterizer3D.Rasterizer3D_sine[var3];
																				var8 = Rasterizer3D.Rasterizer3D_cosine[var3];
																				class467.oculusOrbFocalPointX += var6 * var7 / 65536;
																				class36.oculusOrbFocalPointY += var8 * var6 / 65536;
																			}

																			if (field468 != 0) {
																				class90.field887 += var6 * field468;
																				if (class90.field887 > 0) {
																					class90.field887 = 0;
																				}
																			}
																		} else {
																			field473 = -1;
																			field468 = -1;
																		}

																		if (keyHandlerInstance.getKeyPressed(13)) {
																			packetWriter.addNode(class503.getPacketBufferNode(ClientPacket.field2555, packetWriter.isaacCipher));
																			oculusOrbState = 0;
																		}
																	}

																	if (MouseHandler.MouseHandler_currentButton == 4 && class28.mouseCam) {
																		var3 = MouseHandler.MouseHandler_y - field463;
																		camAngleDX = var3 * 2;
																		field463 = var3 != -1 && var3 != 1 ? (field463 + MouseHandler.MouseHandler_y) / 2 : MouseHandler.MouseHandler_y * -1733330503 * 1549057161;
																		var4 = field471 - MouseHandler.MouseHandler_x;
																		camAngleDY = var4 * 2;
																		field471 = var4 != -1 && var4 != 1 ? (field471 + MouseHandler.MouseHandler_x) / 2 : MouseHandler.MouseHandler_x * -88003869 * -964990261;
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

																		field463 = MouseHandler.MouseHandler_y;
																		field471 = MouseHandler.MouseHandler_x;
																	}

																	camAngleY = camAngleDY / 2 + camAngleY & 2047;
																	camAngleX += camAngleDX / 2;
																	if (camAngleX < 128) {
																		camAngleX = 128;
																	}

																	if (camAngleX > 383) {
																		camAngleX = 383;
																	}

																	if (field397) {
																		class89.method482(class422.field3755, class406.field3706, ModeWhere.field3604);
																		class184.method926(class165.field1420, class4.field3);
																		if (class157.cameraX == class422.field3755 && class406.field3706 == class384.cameraY && ModeWhere.field3604 == SoundSystem.cameraZ && class165.field1420 == class19.cameraPitch && class456.cameraYaw == class4.field3) {
																			field397 = false;
																			isCameraLocked = false;
																			field398 = false;
																			field400 = false;
																			Canvas.field64 = 0;
																			ObjTypeCustomisation.field1483 = 0;
																			FontName.field4032 = 0;
																			class18.field51 = 0;
																			class157.field1395 = 0;
																			SecureRandomFuture.field803 = 0;
																			field538 = 0;
																			WorldMapIcon_1.field2301 = 0;
																			class132.field1260 = 0;
																			ModeWhere.field3603 = 0;
																			field638 = null;
																			field643 = null;
																			field642 = null;
																		}
																	} else if (isCameraLocked) {
																		if (!field398) {
																			var3 = WorldMapIcon_1.field2301 * 128 + 64;
																			var4 = class132.field1260 * 128 + 64;
																			var5 = class306.getTileHeight(var3, var4, class36.Client_plane) - ModeWhere.field3603;
																			class89.method482(var3, var5, var4);
																		} else if (field638 != null) {
																			class157.cameraX = field638.vmethod2349();
																			SoundSystem.cameraZ = field638.vmethod2347();
																			if (field399) {
																				class384.cameraY = field638.vmethod2320();
																			} else {
																				class384.cameraY = class306.getTileHeight(class157.cameraX, SoundSystem.cameraZ, class36.Client_plane) - field638.vmethod2320();
																			}

																			field638.method2351();
																		}

																		if (!field400) {
																			var3 = Canvas.field64 * 128 + 64;
																			var4 = ObjTypeCustomisation.field1483 * 128 + 64;
																			var5 = class306.getTileHeight(var3, var4, class36.Client_plane) - FontName.field4032;
																			var6 = var3 - class157.cameraX;
																			var7 = var5 - class384.cameraY;
																			var8 = var4 - SoundSystem.cameraZ;
																			var9 = (int)Math.sqrt((double)(var8 * var8 + var6 * var6));
																			var10 = (int)(Math.atan2((double)var7, (double)var9) * 325.9490051269531D) & 2047;
																			var11 = (int)(Math.atan2((double)var6, (double)var8) * -325.9490051269531D) & 2047;
																			class184.method926(var10, var11);
																		} else {
																			if (field643 != null) {
																				class19.cameraPitch = field643.method2346();
																				class19.cameraPitch = Math.min(Math.max(class19.cameraPitch, 128), 383);
																				field643.method2351();
																			}

																			if (field642 != null) {
																				class456.cameraYaw = field642.method2346() & 2047;
																				field642.method2351();
																			}
																		}
																	}

																	for (var3 = 0; var3 < 5; ++var3) {
																		var10002 = cameraShakeCycle[var3]++;
																	}

																	PendingSpawn.varcs.tryWrite();
																	var3 = ++MouseHandler.MouseHandler_idleCycles - 1;
																	var5 = class1.method3();
																	if (var3 > 15000 && var5 > 15000) {
																		logoutTimer = 250;
																		ApproximateRouteStrategy.method349(14500);
																		var18 = class503.getPacketBufferNode(ClientPacket.IF_BUTTON2, packetWriter.isaacCipher);
																		packetWriter.addNode(var18);
																	}

																	class177.friendSystem.processFriendUpdates();
																	class146.method776();
																	++packetWriter.pendingWrites;
																	if (packetWriter.pendingWrites > 50) {
																		var18 = class503.getPacketBufferNode(ClientPacket.field2519, packetWriter.isaacCipher);
																		packetWriter.addNode(var18);
																	}

																	try {
																		packetWriter.flush();
																	} catch (IOException var26) {
																		class93.method508();
																	}

																	return;
																}

																PacketWriter.method643(var49);
															}
														}

														var42 = var47.widget;
														if (var42.childIndex < 0) {
															break;
														}

														var44 = VarbitComposition.getWidget(var42.parentId);
													} while(var44 == null || var44.children == null || var42.childIndex >= var44.children.length || var42 != var44.children[var42.childIndex]);

													GrandExchangeOfferOwnWorldComparator.runScriptEvent(var47);
												}
											}

											var42 = var47.widget;
											if (var42.childIndex < 0) {
												break;
											}

											var44 = VarbitComposition.getWidget(var42.parentId);
										} while(var44 == null || var44.children == null || var42.childIndex >= var44.children.length || var42 != var44.children[var42.childIndex]);

										GrandExchangeOfferOwnWorldComparator.runScriptEvent(var47);
									}
								}

								var42 = var47.widget;
								if (var42.childIndex < 0) {
									break;
								}

								var44 = VarbitComposition.getWidget(var42.parentId);
							} while(var44 == null || var44.children == null || var42.childIndex >= var44.children.length || var42 != var44.children[var42.childIndex]);

							GrandExchangeOfferOwnWorldComparator.runScriptEvent(var47);
						}
					}
				}
			}
		}
	}

	@ObfuscatedName("iy")
	@ObfuscatedSignature(
		descriptor = "(IIB)V",
		garbageValue = "57"
	)
	public void vmethod1644(int var1, int var2) {
		if (packetWriter != null && packetWriter.isaacCipher != null) {
			if (var1 > -1 && class150.clientPreferences.getCurrentMusicVolume() > 0 && !playingJingle) {
				PacketBufferNode var3 = class503.getPacketBufferNode(ClientPacket.field2561, packetWriter.isaacCipher);
				var3.packetBuffer.writeInt(var1);
				packetWriter.addNode(var3);
			}

		}
	}

	@ObfuscatedName("iv")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "2120321682"
	)
	@Export("resizeJS")
	void resizeJS() {
		int var1 = GrandExchangeOfferTotalQuantityComparator.canvasWidth;
		int var2 = WorldMapArchiveLoader.canvasHeight;
		if (super.contentWidth < var1) {
			var1 = super.contentWidth;
		}

		if (super.contentHeight < var2) {
			var2 = super.contentHeight;
		}

		if (class150.clientPreferences != null) {
			try {
				class26.method101(TileItem.client, "resize", new Object[]{Huffman.getWindowedMode()});
			} catch (Throwable var4) {
			}
		}

	}

	@ObfuscatedName("ii")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "1641979157"
	)
	@Export("drawLoggedIn")
	final void drawLoggedIn() {
		int var1;
		if (rootInterface != -1) {
			var1 = rootInterface;
			if (Login.loadInterface(var1)) {
				class142.drawModelComponents(ArchiveLoader.Widget_interfaceComponents[var1], -1);
			}
		}

		for (var1 = 0; var1 < rootWidgetCount; ++var1) {
			if (field403[var1]) {
				field404[var1] = true;
			}

			field405[var1] = field403[var1];
			field403[var1] = false;
		}

		field525 = cycle;
		viewportX = -1;
		viewportY = -1;
		if (rootInterface != -1) {
			rootWidgetCount = 0;
			class7.drawWidgets(rootInterface, 0, 0, GrandExchangeOfferTotalQuantityComparator.canvasWidth, WorldMapArchiveLoader.canvasHeight, 0, 0, -1);
		}

		Rasterizer2D.Rasterizer2D_resetClip();
		if (showMouseCross) {
			if (mouseCrossColor == 1) {
				class211.crossSprites[mouseCrossState / 100].drawTransBgAt(mouseCrossX - 8, mouseCrossY - 8);
			}

			if (mouseCrossColor == 2) {
				class211.crossSprites[mouseCrossState / 100 + 4].drawTransBgAt(mouseCrossX - 8, mouseCrossY - 8);
			}
		}

		if (!isMenuOpen) {
			if (viewportX != -1) {
				class335.method1816(viewportX, viewportY);
			}
		} else {
			var1 = Canvas.menuX;
			int var2 = UserComparator6.menuY;
			int var3 = UserComparator5.menuWidth;
			int var4 = ModeWhere.menuHeight;
			int var5 = 6116423;
			Rasterizer2D.Rasterizer2D_fillRectangle(var1, var2, var3, var4, var5);
			Rasterizer2D.Rasterizer2D_fillRectangle(var1 + 1, var2 + 1, var3 - 2, 16, 0);
			Rasterizer2D.Rasterizer2D_drawRectangle(var1 + 1, var2 + 18, var3 - 2, var4 - 19, 0);
			Calendar.fontBold12.draw("Choose Option", var1 + 3, var2 + 14, var5, -1);
			int var6 = MouseHandler.MouseHandler_x;
			int var7 = MouseHandler.MouseHandler_y;

			int var8;
			int var9;
			int var10;
			for (var8 = 0; var8 < menuOptionsCount; ++var8) {
				var9 = (menuOptionsCount - 1 - var8) * 15 + var2 + 31;
				var10 = 16777215;
				if (var6 > var1 && var6 < var3 + var1 && var7 > var9 - 13 && var7 < var9 + 3) {
					var10 = 16776960;
				}

				Font var13 = Calendar.fontBold12;
				String var14;
				if (var8 < 0) {
					var14 = "";
				} else if (menuTargets[var8].length() > 0) {
					var14 = menuActions[var8] + " " + menuTargets[var8];
				} else {
					var14 = menuActions[var8];
				}

				var13.draw(var14, var1 + 3, var9, var10, 0);
			}

			var8 = Canvas.menuX;
			var9 = UserComparator6.menuY;
			var10 = UserComparator5.menuWidth;
			int var11 = ModeWhere.menuHeight;

			for (int var12 = 0; var12 < rootWidgetCount; ++var12) {
				if (rootWidgetWidths[var12] + rootWidgetXs[var12] > var8 && rootWidgetXs[var12] < var8 + var10 && rootWidgetYs[var12] + rootWidgetHeights[var12] > var9 && rootWidgetYs[var12] < var11 + var9) {
					field404[var12] = true;
				}
			}
		}

		if (gameDrawingMode == 3) {
			for (var1 = 0; var1 < rootWidgetCount; ++var1) {
				if (field405[var1]) {
					Rasterizer2D.Rasterizer2D_fillRectangleAlpha(rootWidgetXs[var1], rootWidgetYs[var1], rootWidgetWidths[var1], rootWidgetHeights[var1], 16711935, 128);
				} else if (field404[var1]) {
					Rasterizer2D.Rasterizer2D_fillRectangleAlpha(rootWidgetXs[var1], rootWidgetYs[var1], rootWidgetWidths[var1], rootWidgetHeights[var1], 16711680, 128);
				}
			}
		}

		class456.method2301(class36.Client_plane, class136.localPlayer.x, class136.localPlayer.y, field452);
		field452 = 0;
	}

	@ObfuscatedName("jf")
	@ObfuscatedSignature(
		descriptor = "(Leb;IB)Z",
		garbageValue = "84"
	)
	boolean method380(PacketWriter var1, int var2) {
		if (var1.serverPacketLength == 0) {
			Canvas.friendsChat = null;
		} else {
			if (Canvas.friendsChat == null) {
				Canvas.friendsChat = new FriendsChat(class457.loginType, TileItem.client);
			}

			Canvas.friendsChat.method2168(var1.packetBuffer, var2);
		}

		field509 = cycleCntr;
		DynamicObject.ClanChat_inClanChat = true;
		var1.serverPacket = null;
		return true;
	}

	@ObfuscatedName("kt")
	@ObfuscatedSignature(
		descriptor = "(Leb;B)Z",
		garbageValue = "46"
	)
	boolean method381(PacketWriter var1) {
		if (Canvas.friendsChat != null) {
			Canvas.friendsChat.method2169(var1.packetBuffer);
		}

		field509 = cycleCntr;
		DynamicObject.ClanChat_inClanChat = true;
		var1.serverPacket = null;
		return true;
	}

	@ObfuscatedName("kd")
	@ObfuscatedSignature(
		descriptor = "(Leb;I)Z",
		garbageValue = "1827422343"
	)
	final boolean method382(PacketWriter var1) {
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
					if (var1.field1140) {
						if (!var2.isAvailable(1)) {
							return false;
						}

						var2.read(var1.packetBuffer.array, 0, 1);
						var1.field1141 = 0;
						var1.field1140 = false;
					}

					var3.offset = 0;
					if (var3.method2498()) {
						if (!var2.isAvailable(1)) {
							return false;
						}

						var2.read(var1.packetBuffer.array, 1, 1);
						var1.field1141 = 0;
					}

					var1.field1140 = true;
					ServerPacket[] var4 = Messages.method635();
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
				var1.field1141 = 0;
				timer.method2112();
				var1.field1148 = var1.field1146;
				var1.field1146 = var1.field1147;
				var1.field1147 = var1.serverPacket;
				Widget var6;
				int var20;
				if (ServerPacket.field2598 == var1.serverPacket) {
					var20 = var3.readIntME();
					var21 = var3.readStringCp1252NullTerminated();
					var6 = VarbitComposition.getWidget(var20);
					if (!var21.equals(var6.text)) {
						var6.text = var21;
						class200.invalidateWidget(var6);
					}

					var1.serverPacket = null;
					return true;
				}

				int var7;
				int var8;
				int var11;
				int var57;
				int var59;
				if (ServerPacket.IF_SETOBJECT == var1.serverPacket) {
					var59 = var3.readUnsignedByteNeg();
					var22 = var3.readUMed1();
					var20 = var22 >> 16;
					var5 = var22 >> 8 & 255;
					var7 = var20 + (var22 >> 4 & 7);
					var8 = var5 + (var22 & 7);
					var57 = var3.readUnsignedShort();
					var11 = var3.readUnsignedShort();
					if (var7 >= 0 && var8 >= 0 && var7 < 104 && var8 < 104) {
						var7 = var7 * 128 + 64;
						var8 = var8 * 128 + 64;
						GraphicsObject var61 = new GraphicsObject(var57, class36.Client_plane, var7, var8, class306.getTileHeight(var7, var8, class36.Client_plane) - var59, var11, cycle);
						graphicsObjects.addFirst(var61);
					}

					var1.serverPacket = null;
					return true;
				}

				boolean var23;
				boolean var62;
				int var79;
				if (ServerPacket.field2621 == var1.serverPacket) {
					isCameraLocked = true;
					field397 = false;
					field398 = true;
					WorldMapIcon_1.field2301 = var3.readUnsignedByte();
					class132.field1260 = var3.readUnsignedByte();
					var20 = var3.readUnsignedShort();
					var5 = var3.readUnsignedByte() * 128 + 64;
					var22 = var3.readUnsignedByte() * 128 + 64;
					var7 = var3.readUnsignedShort();
					field399 = var3.readBoolean();
					var8 = var3.readUnsignedByte();
					var57 = WorldMapIcon_1.field2301 * 128 + 64;
					var59 = class132.field1260 * 128 + 64;
					var62 = false;
					var23 = false;
					if (field399) {
						var11 = class384.cameraY;
						var79 = class306.getTileHeight(var57, var59, class36.Client_plane) - var20;
					} else {
						var11 = class306.getTileHeight(class157.cameraX, SoundSystem.cameraZ, class36.Client_plane) - class384.cameraY;
						var79 = var20;
					}

					field638 = new class477(class157.cameraX, SoundSystem.cameraZ, var11, var57, var59, var79, var5, var22, var7, var8);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2620 == var1.serverPacket) {
					var22 = var3.readUnsignedByteAdd();
					var20 = var3.readUnsignedShortLE();
					var5 = var3.readUnsignedShortLE();
					if (var5 == 65535) {
						var5 = -1;
					}

					NPC var86 = npcs[var20];
					if (var86 != null) {
						if (var5 == var86.sequence && var5 != -1) {
							var8 = class135.SequenceDefinition_get(var5).replyMode;
							if (var8 == 1) {
								var86.sequenceFrame = 0;
								var86.sequenceFrameCycle = 0;
								var86.sequenceDelay = var22;
								var86.currentSequenceFrameIndex = 0;
							} else if (var8 == 2) {
								var86.currentSequenceFrameIndex = 0;
							}
						} else if (var5 == -1 || var86.sequence == -1 || class135.SequenceDefinition_get(var5).forcedPriority >= class135.SequenceDefinition_get(var86.sequence).forcedPriority) {
							var86.sequence = var5;
							var86.sequenceFrame = 0;
							var86.sequenceFrameCycle = 0;
							var86.sequenceDelay = var22;
							var86.currentSequenceFrameIndex = 0;
							var86.field1018 = var86.pathLength;
						}
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2637 == var1.serverPacket) {
					DbRowType.process();
					var20 = var3.readIntIME();
					var5 = var3.readUnsignedByte();
					var22 = var3.readUnsignedByteNeg();
					experience[var22] = var20;
					currentLevels[var22] = var5;
					levels[var22] = 1;

					for (var7 = 0; var7 < 98; ++var7) {
						if (var20 >= Skills.Skills_experienceTable[var7]) {
							levels[var22] = var7 + 2;
						}
					}

					changedSkills[++changedSkillsCount - 1 & 31] = var22;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2649 == var1.serverPacket) {
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

				if (ServerPacket.field2683 == var1.serverPacket) {
					var20 = var3.readUnsignedByte();
					GrandExchangeEvents.forceDisconnect(var20);
					var1.serverPacket = null;
					return false;
				}

				String var64;
				if (ServerPacket.CHAT_FILTER_SETTINGS == var1.serverPacket) {
					byte[] var54 = new byte[var1.serverPacketLength];
					var3.method2500(var54, 0, var54.length);
					Buffer var83 = new Buffer(var54);
					var64 = var83.readStringCp1252NullTerminated();
					NPC.openURL(var64, true, false);
					var1.serverPacket = null;
					return true;
				}

				Widget var78;
				if (ServerPacket.IF_SETPLAYERHEAD == var1.serverPacket) {
					var20 = var3.readIntIME();
					var78 = VarbitComposition.getWidget(var20);
					var78.modelType = 3;
					var78.modelId = class136.localPlayer.appearance.getChatHeadId();
					class200.invalidateWidget(var78);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2602 == var1.serverPacket) {
					class27.processZoneOperation(ZoneOperation.field2584);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2705 == var1.serverPacket) {
					var7 = var3.readUnsignedShortAddLE();
					var5 = var3.readUnsignedShortAddLE();
					var8 = var3.readUnsignedShort();
					var22 = var3.readUnsignedShortAdd();
					var20 = var3.readUnsignedShortAdd();
					if (var20 == 65535) {
						var20 = -1;
					}

					ArrayList var84 = new ArrayList();
					var84.add(var20);
					ObjectComposition.method1031(var84, var5, var22, var7, var8);
					var1.serverPacket = null;
					return true;
				}

				int var15;
				int var69;
				if (ServerPacket.field2698 == var1.serverPacket) {
					isCameraLocked = true;
					field397 = false;
					field400 = true;
					Canvas.field64 = var3.readUnsignedByte();
					ObjTypeCustomisation.field1483 = var3.readUnsignedByte();
					FontName.field4032 = var3.readUnsignedShort();
					var20 = var3.readUnsignedShort();
					var5 = var3.readUnsignedByte();
					var22 = Canvas.field64 * 128 + 64;
					var7 = ObjTypeCustomisation.field1483 * 128 + 64;
					var8 = class306.getTileHeight(var22, var7, class36.Client_plane) - FontName.field4032;
					var57 = var22 - class157.cameraX;
					var59 = var8 - class384.cameraY;
					var11 = var7 - SoundSystem.cameraZ;
					double var85 = Math.sqrt((double)(var11 * var11 + var57 * var57));
					var69 = class74.method440((int)(Math.atan2((double)var59, var85) * 325.9490051269531D) & 2047);
					var15 = class4.method5((int)(Math.atan2((double)var57, (double)var11) * -325.9490051269531D) & 2047);
					field643 = new class479(class19.cameraPitch, var69, var20, var5);
					field642 = new class479(class456.cameraYaw, var15, var20, var5);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2676 == var1.serverPacket) {
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2716 == var1.serverPacket) {
					isCameraLocked = true;
					field397 = false;
					field400 = true;
					var20 = var3.readShort();
					var5 = var3.readShort();
					var22 = class74.method440(var5 + class19.cameraPitch & 2027);
					var7 = var20 + class456.cameraYaw;
					var8 = var3.readUnsignedShort();
					var57 = var3.readUnsignedByte();
					field643 = new class479(class19.cameraPitch, var22, var8, var57);
					field642 = new class479(class456.cameraYaw, var7, var8, var57);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.REBUILD_REGION == var1.serverPacket) {
					isCameraLocked = true;
					field397 = false;
					field400 = false;
					Canvas.field64 = var3.readUnsignedByte();
					ObjTypeCustomisation.field1483 = var3.readUnsignedByte();
					FontName.field4032 = var3.readUnsignedShort();
					class18.field51 = var3.readUnsignedByte();
					class157.field1395 = var3.readUnsignedByte();
					if (class157.field1395 >= 100) {
						var20 = Canvas.field64 * 128 + 64;
						var5 = ObjTypeCustomisation.field1483 * 128 + 64;
						var22 = class306.getTileHeight(var20, var5, class36.Client_plane) - FontName.field4032;
						var7 = var20 - class157.cameraX;
						var8 = var22 - class384.cameraY;
						var57 = var5 - SoundSystem.cameraZ;
						var59 = (int)Math.sqrt((double)(var7 * var7 + var57 * var57));
						class19.cameraPitch = (int)(Math.atan2((double)var8, (double)var59) * 325.9490051269531D) & 2047;
						class456.cameraYaw = (int)(Math.atan2((double)var7, (double)var57) * -325.9490051269531D) & 2047;
						if (class19.cameraPitch < 128) {
							class19.cameraPitch = 128;
						}

						if (class19.cameraPitch > 383) {
							class19.cameraPitch = 383;
						}
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2629 == var1.serverPacket) {
					var20 = var3.readUnsignedShortLE();
					var5 = var3.readInt();
					var22 = var20 >> 10 & 31;
					var7 = var20 >> 5 & 31;
					var8 = var20 & 31;
					var57 = (var7 << 11) + (var22 << 19) + (var8 << 3);
					Widget var90 = VarbitComposition.getWidget(var5);
					if (var57 != var90.color) {
						var90.color = var57;
						class200.invalidateWidget(var90);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2644 == var1.serverPacket) {
					DbRowType.process();
					weight = var3.readShort();
					field524 = cycleCntr;
					var1.serverPacket = null;
					return true;
				}

				boolean var87;
				if (ServerPacket.field2646 == var1.serverPacket) {
					var87 = var3.readUnsignedByte() == 1;
					if (var87) {
						VerticalAlignment.field1614 = class113.clockNow() - var3.readLong();
						class28.grandExchangeEvents = new GrandExchangeEvents(var3, true);
					} else {
						class28.grandExchangeEvents = null;
					}

					field521 = cycleCntr;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2713 == var1.serverPacket) {
					return this.method380(var1, 1);
				}

				if (ServerPacket.field2685 == var1.serverPacket) {
					var20 = var3.readInt();
					if (var20 != field363) {
						field363 = var20;
						UserComparator7.method670();
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.REFLECTION_CHECK == var1.serverPacket && isCameraLocked) {
					field397 = true;
					field400 = false;
					field398 = false;

					for (var20 = 0; var20 < 5; ++var20) {
						field406[var20] = false;
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2663 == var1.serverPacket) {
					var20 = var3.readSignedShortAdd();
					var5 = var3.readInt();
					var6 = VarbitComposition.getWidget(var5);
					if (var20 != var6.sequenceId || var20 == -1) {
						var6.sequenceId = var20;
						var6.modelFrame = 0;
						var6.modelFrameCycle = 0;
						class200.invalidateWidget(var6);
					}

					var1.serverPacket = null;
					return true;
				}

				long var26;
				long var29;
				long var31;
				long var33;
				String var36;
				String var52;
				if (ServerPacket.LOGOUT_TRANSFER == var1.serverPacket) {
					var52 = var3.readStringCp1252NullTerminated();
					var29 = var3.readLong();
					var31 = (long)var3.readUnsignedShort();
					var33 = (long)var3.readMedium();
					PlayerType var91 = (PlayerType)ClientPreferences.findEnumerated(PendingSpawn.PlayerType_values(), var3.readUnsignedByte());
					var26 = (var31 << 32) + var33;
					boolean var70 = false;

					for (var15 = 0; var15 < 100; ++var15) {
						if (field613[var15] == var26) {
							var70 = true;
							break;
						}
					}

					if (var91.isUser && class177.friendSystem.isIgnored(new Username(var52, class457.loginType))) {
						var70 = true;
					}

					if (!var70 && field485 == 0) {
						field613[field530] = var26;
						field530 = (field530 + 1) % 100;
						var36 = AbstractFont.escapeBrackets(class153.method797(class292.readString(var3)));
						if (var91.modIcon != -1) {
							class213.addChatMessage(9, SecureRandomCallable.addImageTag(var91.modIcon) + var52, var36, class170.base37DecodeLong(var29));
						} else {
							class213.addChatMessage(9, var52, var36, class170.base37DecodeLong(var29));
						}
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2706 == var1.serverPacket) {
					var5 = var3.readUnsignedShortAddLE();
					var20 = var3.readUnsignedShortAddLE();
					RouteStrategy.method1107(var20, var5);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2687 == var1.serverPacket) {
					WorldMapScaleHandler.logOut();
					var1.serverPacket = null;
					return false;
				}

				if (ServerPacket.UPDATE_ZONE_PARTIAL_FOLLOWS == var1.serverPacket) {
					var20 = var3.readUShortSmart();
					boolean var81 = var3.readUnsignedByte() == 1;
					var64 = "";
					boolean var66 = false;
					if (var81) {
						var64 = var3.readStringCp1252NullTerminated();
						if (class177.friendSystem.isIgnored(new Username(var64, class457.loginType))) {
							var66 = true;
						}
					}

					String var97 = var3.readStringCp1252NullTerminated();
					if (!var66) {
						class415.addGameMessage(var20, var64, var97);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2655 == var1.serverPacket) {
					var20 = var3.readIntLE();
					var5 = var3.readUnsignedShort();
					var6 = VarbitComposition.getWidget(var20);
					if (var6 != null && var6.type == 0) {
						if (var5 > var6.scrollHeight - var6.height) {
							var5 = var6.scrollHeight - var6.height;
						}

						if (var5 < 0) {
							var5 = 0;
						}

						if (var5 != var6.scrollY) {
							var6.scrollY = var5;
							class200.invalidateWidget(var6);
						}
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.MESSAGE_PRIVATE_ECHO == var1.serverPacket) {
					field397 = false;
					isCameraLocked = false;
					field398 = false;
					field400 = false;
					Canvas.field64 = 0;
					ObjTypeCustomisation.field1483 = 0;
					FontName.field4032 = 0;
					field399 = false;
					class18.field51 = 0;
					class157.field1395 = 0;
					SecureRandomFuture.field803 = 0;
					field538 = 0;
					WorldMapIcon_1.field2301 = 0;
					class132.field1260 = 0;
					ModeWhere.field3603 = 0;
					field638 = null;
					field643 = null;
					field642 = null;

					for (var20 = 0; var20 < 5; ++var20) {
						field406[var20] = false;
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2688 == var1.serverPacket) {
					class27.processZoneOperation(ZoneOperation.field2588);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2690 == var1.serverPacket) {
					class27.processZoneOperation(ZoneOperation.field2580);
					var1.serverPacket = null;
					return true;
				}

				int var13;
				String var38;
				byte var72;
				if (ServerPacket.field2681 == var1.serverPacket) {
					var72 = var3.readByte();
					var29 = (long)var3.readUnsignedShort();
					var31 = (long)var3.readMedium();
					var33 = var31 + (var29 << 32);
					var62 = false;
					ClanChannel var12 = var72 >= 0 ? currentClanChannels[var72] : WorldMapLabelSize.guestClanChannel;
					if (var12 == null) {
						var62 = true;
					} else {
						for (var13 = 0; var13 < 100; ++var13) {
							if (var33 == field613[var13]) {
								var62 = true;
								break;
							}
						}
					}

					if (!var62) {
						field613[field530] = var33;
						field530 = (field530 + 1) % 100;
						var38 = class292.readString(var3);
						var69 = var72 >= 0 ? 43 : 46;
						class213.addChatMessage(var69, "", var38, var12.name);
					}

					var1.serverPacket = null;
					return true;
				}

				int var16;
				if (ServerPacket.field2611 == var1.serverPacket) {
					byte var68 = var3.readByte();
					int var18 = var3.readUnsignedByteAdd();
					int var17 = var3.readUnsignedByte();
					var69 = var3.readUnsignedByte() * 4;
					byte var63 = var3.readByteAdd();
					var13 = var3.readUnsignedByteNeg() * 4;
					var22 = var3.readUMed1();
					var20 = var22 >> 16;
					var5 = var22 >> 8 & 255;
					var7 = var20 + (var22 >> 4 & 7);
					var8 = var5 + (var22 & 7);
					var11 = var3.method2528();
					var79 = var3.readUnsignedShortAddLE();
					var16 = var3.readUnsignedShortAdd();
					var15 = var3.readUnsignedShortAddLE();
					var57 = var68 + var7;
					var59 = var63 + var8;
					if (var7 >= 0 && var8 >= 0 && var7 < 104 && var8 < 104 && var57 >= 0 && var59 >= 0 && var57 < 104 && var59 < 104 && var79 != 65535) {
						var7 = var7 * 128 + 64;
						var8 = var8 * 128 + 64;
						var57 = var57 * 128 + 64;
						var59 = var59 * 128 + 64;
						Projectile var19 = new Projectile(var79, class36.Client_plane, var7, var8, class306.getTileHeight(var7, var8, class36.Client_plane) - var13, var15 + cycle, var16 + cycle, var17, var18, var11, var69);
						var19.setDestination(var57, var59, class306.getTileHeight(var57, var59, class36.Client_plane) - var69, var15 + cycle);
						projectiles.addFirst(var19);
					}

					var1.serverPacket = null;
					return true;
				}

				InterfaceParent var82;
				if (ServerPacket.field2599 == var1.serverPacket) {
					var20 = var3.offset + var1.serverPacketLength;
					var5 = var3.readUnsignedShort();
					if (var5 == 65535) {
						var5 = -1;
					}

					var22 = var3.readUnsignedShort();
					if (var5 != rootInterface) {
						rootInterface = var5;
						this.resizeRoot(false);
						class92.Widget_resetModelFrames(rootInterface);
						ScriptFrame.runWidgetOnLoadListener(rootInterface);

						for (var7 = 0; var7 < 100; ++var7) {
							field403[var7] = true;
						}
					}

					InterfaceParent var89;
					for (; var22-- > 0; var89.field856 = true) {
						var7 = var3.readInt();
						var8 = var3.readUnsignedShort();
						var57 = var3.readUnsignedByte();
						var89 = (InterfaceParent)interfaceParents.get((long)var7);
						if (var89 != null && var8 != var89.group) {
							Actor.closeInterface(var89, true);
							var89 = null;
						}

						if (var89 == null) {
							var89 = WorldMapLabelSize.ifOpenSub(var7, var8, var57);
						}
					}

					for (var82 = (InterfaceParent)interfaceParents.first(); var82 != null; var82 = (InterfaceParent)interfaceParents.next()) {
						if (var82.field856) {
							var82.field856 = false;
						} else {
							Actor.closeInterface(var82, true);
						}
					}

					widgetFlags = new NodeHashTable(512);

					while (var3.offset < var20) {
						var7 = var3.readInt();
						var8 = var3.readUnsignedShort();
						var57 = var3.readUnsignedShort();
						var59 = var3.readInt();

						for (var11 = var8; var11 <= var57; ++var11) {
							var26 = ((long)var7 << 32) + (long)var11;
							widgetFlags.put(new IntegerNode(var59), var26);
						}
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2710 == var1.serverPacket) {
					return this.method380(var1, 2);
				}

				if (ServerPacket.field2699 == var1.serverPacket) {
					var20 = var3.readInt();
					var78 = VarbitComposition.getWidget(var20);

					for (var22 = 0; var22 < var78.itemIds.length; ++var22) {
						var78.itemIds[var22] = -1;
						var78.itemIds[var22] = 0;
					}

					class200.invalidateWidget(var78);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.MESSAGE_PRIVATE == var1.serverPacket) {
					class450.method2270(var3.readStringCp1252NullTerminated());
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2660 == var1.serverPacket) {
					var20 = var3.readUnsignedShortLE();
					Player var94;
					if (var20 == localPlayerIndex) {
						var94 = class136.localPlayer;
					} else {
						var94 = players[var20];
					}

					var7 = var3.readUnsignedByte();
					var5 = var3.readUnsignedShortAddLE();
					var22 = var3.readIntIME();
					if (var94 != null) {
						var94.updateSpotAnimation(var7, var5, var22 >> 16, var22 & 65535);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.IF_OPENSUB == var1.serverPacket) {
					var3.offset += 28;
					if (var3.checkCrc()) {
						class403.method2091(var3, var3.offset - 28);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2600 == var1.serverPacket) {
					var52 = var3.readStringCp1252NullTerminated();
					Object[] var77 = new Object[var52.length() + 1];

					for (var22 = var52.length() - 1; var22 >= 0; --var22) {
						if (var52.charAt(var22) == 's') {
							var77[var22 + 1] = var3.readStringCp1252NullTerminated();
						} else {
							var77[var22 + 1] = new Integer(var3.readInt());
						}
					}

					var77[0] = new Integer(var3.readInt());
					ScriptEvent var67 = new ScriptEvent();
					var67.args = var77;
					GrandExchangeOfferOwnWorldComparator.runScriptEvent(var67);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.UPDATE_INV_PARTIAL == var1.serverPacket) {
					var87 = var3.readBoolean();
					if (var87) {
						if (UserComparator7.field1171 == null) {
							UserComparator7.field1171 = new class370();
						}
					} else {
						UserComparator7.field1171 = null;
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2653 == var1.serverPacket) {
					if (rootInterface != -1) {
						ChatChannel.runIntfCloseListeners(rootInterface, 0);
					}

					var1.serverPacket = null;
					return true;
				}

				Widget var80;
				if (ServerPacket.field2613 == var1.serverPacket) {
					var20 = var3.readUnsignedShortLE();
					if (var20 == 65535) {
						var20 = -1;
					}

					var5 = var3.readIntLE();
					var22 = var3.readIntLE();
					var80 = VarbitComposition.getWidget(var5);
					ItemComposition var93;
					if (!var80.isIf3) {
						if (var20 == -1) {
							var80.modelType = 0;
							var1.serverPacket = null;
							return true;
						}

						var93 = class125.ItemDefinition_get(var20).getCountObj(var22);
						var80.modelType = 4;
						var80.modelId = var20;
						var80.modelAngleX = var93.xan2d;
						var80.modelAngleY = var93.yan2d;
						var80.modelZoom = var93.zoom2d * 100 / var22;
						class200.invalidateWidget(var80);
					} else {
						var80.itemId = var20;
						var80.itemQuantity = var22;
						var93 = class125.ItemDefinition_get(var20).getCountObj(var22);
						var80.modelAngleX = var93.xan2d;
						var80.modelAngleY = var93.yan2d;
						var80.modelAngleZ = var93.zan2d;
						var80.modelOffsetX = var93.offsetX2d;
						var80.modelOffsetY = var93.offsetY2d;
						var80.modelZoom = var93.zoom2d;
						if (var93.isStackable == 1) {
							var80.itemQuantityMode = 1;
						} else {
							var80.itemQuantityMode = 2;
						}

						if (var80.modelRotation > 0) {
							var80.modelZoom = var80.modelZoom * 32 / var80.modelRotation;
						} else if (var80.rawWidth > 0) {
							var80.modelZoom = var80.modelZoom * 32 / var80.rawWidth;
						}

						class200.invalidateWidget(var80);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.MESSAGE_CLANCHANNEL_SYSTEM == var1.serverPacket) {
					var20 = var3.readUnsignedShortLE();
					var5 = var3.readIntLE();
					var22 = var3.readUnsignedShortLE();
					var80 = VarbitComposition.getWidget(var5);
					var80.rotationKey = var20 + (var22 << 16);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2635 == var1.serverPacket) {
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

				if (ServerPacket.IF_SETPOSITION == var1.serverPacket) {
					var20 = var3.readInt();
					InterfaceParent var76 = (InterfaceParent)interfaceParents.get((long)var20);
					if (var76 != null) {
						Actor.closeInterface(var76, true);
					}

					if (meslayerContinueWidget != null) {
						class200.invalidateWidget(meslayerContinueWidget);
						meslayerContinueWidget = null;
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.SPOTANIM_SPECIFIC == var1.serverPacket) {
					class135.varclan = new class455(class344.HitSplatDefinition_cached);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.RESET_ANIMS == var1.serverPacket) {
					class387.field3646 = var3.readUnsignedByte();
					WorldMapSectionType.field2393 = var3.readUnsignedByte();
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2605 == var1.serverPacket) {
					isCameraLocked = true;
					field397 = false;
					field400 = true;
					var20 = class4.method5(var3.readShort() & 2027);
					var5 = class74.method440(var3.readShort() & 2027);
					var22 = var3.readUnsignedShort();
					var7 = var3.readUnsignedByte();
					field643 = new class479(class19.cameraPitch, var5, var22, var7);
					field642 = new class479(class456.cameraYaw, var20, var22, var7);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2693 == var1.serverPacket) {
					if (class135.varclan == null) {
						class135.varclan = new class455(class344.HitSplatDefinition_cached);
					}

					class522 var53 = class344.HitSplatDefinition_cached.method2300(var3);
					class135.varclan.field3883.vmethod8143(var53.field4170, var53.field4169);
					field568[++field522 - 1 & 31] = var53.field4170;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2651 == var1.serverPacket) {
					var57 = var3.readUnsignedByteSub();
					var59 = var57 >> 2;
					var11 = var57 & 3;
					var79 = field648[var59];
					var13 = var3.readUnsignedShort();
					var22 = var3.readMedium();
					var20 = var22 >> 16;
					var5 = var22 >> 8 & 255;
					var7 = var20 + (var22 >> 4 & 7);
					var8 = var5 + (var22 & 7);
					if (var7 >= 0 && var8 >= 0 && var7 < 103 && var8 < 103) {
						if (var79 == 0) {
							BoundaryObject var99 = UserComparator5.scene.method1233(class36.Client_plane, var7, var8);
							if (var99 != null) {
								var15 = class458.Entity_unpackID(var99.tag);
								if (var59 == 2) {
									var99.renderable1 = new DynamicObject(var15, 2, var11 + 4, class36.Client_plane, var7, var8, var13, false, var99.renderable1);
									var99.renderable2 = new DynamicObject(var15, 2, var11 + 1 & 3, class36.Client_plane, var7, var8, var13, false, var99.renderable2);
								} else {
									var99.renderable1 = new DynamicObject(var15, var59, var11, class36.Client_plane, var7, var8, var13, false, var99.renderable1);
								}
							}
						} else if (var79 == 1) {
							WallDecoration var98 = UserComparator5.scene.method1234(class36.Client_plane, var7, var8);
							if (var98 != null) {
								var15 = class458.Entity_unpackID(var98.tag);
								if (var59 != 4 && var59 != 5) {
									if (var59 == 6) {
										var98.renderable1 = new DynamicObject(var15, 4, var11 + 4, class36.Client_plane, var7, var8, var13, false, var98.renderable1);
									} else if (var59 == 7) {
										var98.renderable1 = new DynamicObject(var15, 4, (var11 + 2 & 3) + 4, class36.Client_plane, var7, var8, var13, false, var98.renderable1);
									} else if (var59 == 8) {
										var98.renderable1 = new DynamicObject(var15, 4, var11 + 4, class36.Client_plane, var7, var8, var13, false, var98.renderable1);
										var98.renderable2 = new DynamicObject(var15, 4, (var11 + 2 & 3) + 4, class36.Client_plane, var7, var8, var13, false, var98.renderable2);
									}
								} else {
									var98.renderable1 = new DynamicObject(var15, 4, var11, class36.Client_plane, var7, var8, var13, false, var98.renderable1);
								}
							}
						} else if (var79 == 2) {
							GameObject var95 = UserComparator5.scene.getGameObject(class36.Client_plane, var7, var8);
							if (var59 == 11) {
								var59 = 10;
							}

							if (var95 != null) {
								var95.renderable = new DynamicObject(class458.Entity_unpackID(var95.tag), var59, var11, class36.Client_plane, var7, var8, var13, false, var95.renderable);
							}
						} else if (var79 == 3) {
							FloorDecoration var96 = UserComparator5.scene.getFloorDecoration(class36.Client_plane, var7, var8);
							if (var96 != null) {
								var96.renderable = new DynamicObject(class458.Entity_unpackID(var96.tag), 22, var11, class36.Client_plane, var7, var8, var13, false, var96.renderable);
							}
						}
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2704 == var1.serverPacket) {
					var5 = var3.readUnsignedShort();
					var7 = var3.readUnsignedShort();
					var20 = var3.readUnsignedShortLE();
					var22 = var3.readUnsignedShortLE();
					class452.method2293(var20, var5, var22, var7);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2623 == var1.serverPacket) {
					var20 = var3.readUnsignedByteNeg();
					var5 = var3.readUnsignedByteNeg();
					var64 = var3.readStringCp1252NullTerminated();
					if (var20 >= 1 && var20 <= 8) {
						if (var64.equalsIgnoreCase("null")) {
							var64 = null;
						}

						playerMenuActions[var20 - 1] = var64;
						playerOptionsPriorities[var20 - 1] = var5 == 0;
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2638 == var1.serverPacket) {
					var20 = var3.readUnsignedByteNeg();
					var5 = var3.readUnsignedShortAdd();
					if (var5 == 65535) {
						var5 = -1;
					}

					WorldMapSectionType.performPlayerAnimation(class136.localPlayer, var5, var20);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.PLAYER_INFO == var1.serverPacket) {
					class27.processZoneOperation(ZoneOperation.field2589);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2708 == var1.serverPacket) {
					var20 = var3.readUnsignedShort();
					var5 = var3.readIntME();
					var6 = VarbitComposition.getWidget(var5);
					if (var6.modelType != 6 || var20 != var6.modelId) {
						var6.modelType = 6;
						var6.modelId = var20;
						class200.invalidateWidget(var6);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2664 == var1.serverPacket) {
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

				if (ServerPacket.TRADING_POST_RESULTS == var1.serverPacket) {
					field512 = cycleCntr;
					var72 = var3.readByte();
					class160 var75 = new class160(var3);
					ClanChannel var60;
					if (var72 >= 0) {
						var60 = currentClanChannels[var72];
					} else {
						var60 = WorldMapLabelSize.guestClanChannel;
					}

					var75.method842(var60);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2718 == var1.serverPacket) {
					var8 = var3.readUnsignedShortAddLE();
					var5 = var3.readUnsignedShort();
					if (var5 == 65535) {
						var5 = -1;
					}

					var20 = var3.readUnsignedShortAdd();
					if (var20 == 65535) {
						var20 = -1;
					}

					var57 = var3.readUnsignedShort();
					var7 = var3.readUnsignedShortAdd();
					var22 = var3.readUnsignedShortAddLE();
					ArrayList var88 = new ArrayList();
					var88.add(var20);
					var88.add(var5);
					ObjectComposition.method1031(var88, var22, var7, var8, var57);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.IF_SETNPCHEAD == var1.serverPacket) {
					var20 = var3.readInt();
					var5 = var3.readUnsignedShort();
					if (var20 < -70000) {
						var5 += 32768;
					}

					if (var20 >= 0) {
						var6 = VarbitComposition.getWidget(var20);
					} else {
						var6 = null;
					}

					if (var6 != null) {
						for (var7 = 0; var7 < var6.itemIds.length; ++var7) {
							var6.itemIds[var7] = 0;
							var6.field3036[var7] = 0;
						}
					}

					GrandExchangeOfferNameComparator.clearItemContainer(var5);
					var7 = var3.readUnsignedShort();

					for (var8 = 0; var8 < var7; ++var8) {
						var57 = var3.readUnsignedByteSub();
						if (var57 == 255) {
							var57 = var3.readInt();
						}

						var59 = var3.readUnsignedShortLE();
						if (var6 != null && var8 < var6.itemIds.length) {
							var6.itemIds[var8] = var59;
							var6.field3036[var8] = var57;
						}

						ObjectComposition.itemContainerSetItem(var5, var8, var59 - 1, var57);
					}

					if (var6 != null) {
						class200.invalidateWidget(var6);
					}

					DbRowType.process();
					changedItemContainers[++changedItemContainersCount - 1 & 31] = var5 & 32767;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2692 == var1.serverPacket) {
					var87 = this.username() == null;
					class85.updatePlayers(var3, var1.serverPacketLength);
					WorldMapSectionType.method1485();
					if (var87 && this.username() != null && this.username().method2682().equalsIgnoreCase("nin")) {
						class415.addGameMessage(4, "", "$jmod_luck = true");
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.ENTER_FREECAM == var1.serverPacket) {
					var72 = var3.readByte();
					var21 = var3.readStringCp1252NullTerminated();
					long var40 = (long)var3.readUnsignedShort();
					long var42 = (long)var3.readMedium();
					PlayerType var28 = (PlayerType)ClientPreferences.findEnumerated(PendingSpawn.PlayerType_values(), var3.readUnsignedByte());
					long var44 = var42 + (var40 << 32);
					boolean var65 = false;
					ClanChannel var39 = null;
					var39 = var72 >= 0 ? currentClanChannels[var72] : WorldMapLabelSize.guestClanChannel;
					if (var39 == null) {
						var65 = true;
					} else {
						var15 = 0;

						while (true) {
							if (var15 >= 100) {
								if (var28.isUser && class177.friendSystem.isIgnored(new Username(var21, class457.loginType))) {
									var65 = true;
								}
								break;
							}

							if (var44 == field613[var15]) {
								var65 = true;
								break;
							}

							++var15;
						}
					}

					if (!var65) {
						field613[field530] = var44;
						field530 = (field530 + 1) % 100;
						var36 = AbstractFont.escapeBrackets(class292.readString(var3));
						var16 = var72 >= 0 ? 41 : 44;
						if (var28.modIcon != -1) {
							class213.addChatMessage(var16, SecureRandomCallable.addImageTag(var28.modIcon) + var21, var36, var39.name);
						} else {
							class213.addChatMessage(var16, var21, var36, var39.name);
						}
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2607 == var1.serverPacket) {
					var20 = var3.readUnsignedShortAddLE();
					if (var20 == 65535) {
						var20 = -1;
					}

					var5 = var3.readIntIME();
					var22 = var3.readUnsignedShortLE();
					if (var22 == 65535) {
						var22 = -1;
					}

					var7 = var3.readIntIME();

					for (var8 = var20; var8 <= var22; ++var8) {
						var33 = (long)var8 + ((long)var7 << 32);
						Node var35 = widgetFlags.get(var33);
						if (var35 != null) {
							var35.remove();
						}

						widgetFlags.put(new IntegerNode(var5), var33);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2674 == var1.serverPacket) {
					var20 = var3.readIntME();
					var5 = var3.readInt();
					var6 = VarbitComposition.getWidget(var20);
					UserComparator9.method679(var6, var5);
					class200.invalidateWidget(var6);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.TRIGGER_ONDIALOGABORT == var1.serverPacket) {
					var20 = var3.readIntLE();
					var5 = var3.readUnsignedShortAdd();
					var6 = VarbitComposition.getWidget(var20);
					if (var6.modelType != 1 || var5 != var6.modelId) {
						var6.modelType = 1;
						var6.modelId = var5;
						class200.invalidateWidget(var6);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2667 == var1.serverPacket) {
					class177.friendSystem.readUpdate(var3, var1.serverPacketLength);
					field516 = cycleCntr;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.HEAT_MAP == var1.serverPacket) {
					var20 = var3.readInt();
					var5 = var3.readUnsignedByte();
					var22 = var3.readUnsignedShortAddLE();
					var82 = (InterfaceParent)interfaceParents.get((long)var20);
					if (var82 != null) {
						Actor.closeInterface(var82, var22 != var82.group);
					}

					WorldMapLabelSize.ifOpenSub(var20, var22, var5);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2632 == var1.serverPacket) {
					tradeChatMode = var3.readUnsignedByteAdd();
					publicChatMode = var3.readUnsignedByteNeg();
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.GAMEFRAME_FULL == var1.serverPacket) {
					for (var20 = 0; var20 < VarpDefinition.field1491; ++var20) {
						VarpDefinition var74 = class158.VarpDefinition_get(var20);
						if (var74 != null) {
							Varps.Varps_temp[var20] = 0;
							Varps.Varps_main[var20] = 0;
						}
					}

					DbRowType.process();
					changedVarpCount += 32;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2715 == var1.serverPacket) {
					var87 = var3.readUnsignedByteAdd() == 1;
					var5 = var3.readIntLE();
					var6 = VarbitComposition.getWidget(var5);
					WorldMapManager.method1453(var6, class136.localPlayer.appearance, var87);
					class200.invalidateWidget(var6);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2648 == var1.serverPacket) {
					var20 = var3.readUnsignedByteAdd();
					var5 = var3.readUnsignedByteSub();
					var22 = var3.readIntME();
					var80 = VarbitComposition.getWidget(var22);
					class310.method1641(var80, var5, var20);
					class200.invalidateWidget(var80);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2682 == var1.serverPacket) {
					var20 = var3.readInt();
					var5 = var3.readUnsignedByteSub();
					var6 = VarbitComposition.getWidget(var20);
					TaskHandler.method898(var6, class136.localPlayer.appearance.field2900, var5);
					class200.invalidateWidget(var6);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2679 == var1.serverPacket) {
					var20 = var3.readUnsignedShort();
					if (var20 == 65535) {
						var20 = -1;
					}

					WorldMapSectionType.playSong(var20);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.UPDATE_INV_FULL == var1.serverPacket) {
					var20 = var3.readUMed2();
					var5 = var3.readUnsignedShortAddLE();
					if (var5 == 65535) {
						var5 = -1;
					}

					Interpreter.playJingle(var5, var20);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2678 == var1.serverPacket) {
					class14.privateChatMode = class228.method1187(var3.readUnsignedByte());
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.NPC_INFO_SMALL == var1.serverPacket) {
					field512 = cycleCntr;
					var72 = var3.readByte();
					if (var1.serverPacketLength == 1) {
						if (var72 >= 0) {
							currentClanChannels[var72] = null;
						} else {
							WorldMapLabelSize.guestClanChannel = null;
						}

						var1.serverPacket = null;
						return true;
					}

					if (var72 >= 0) {
						currentClanChannels[var72] = new ClanChannel(var3);
					} else {
						WorldMapLabelSize.guestClanChannel = new ClanChannel(var3);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2615 == var1.serverPacket) {
					var20 = var3.readUnsignedByte();
					if (var3.readUnsignedByte() == 0) {
						grandExchangeOffers[var20] = new GrandExchangeOffer();
						var3.offset += 18;
					} else {
						--var3.offset;
						grandExchangeOffers[var20] = new GrandExchangeOffer(var3, false);
					}

					field518 = cycleCntr;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2640 == var1.serverPacket) {
					class27.processZoneOperation(ZoneOperation.field2590);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2709 == var1.serverPacket) {
					class27.processZoneOperation(ZoneOperation.field2582);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2696 == var1.serverPacket) {
					Tile.method1161();
					var72 = var3.readByte();
					class146 var73 = new class146(var3);
					ClanSettings var56;
					if (var72 >= 0) {
						var56 = currentClanSettings[var72];
					} else {
						var56 = class11.guestClanSettings;
					}

					var73.method774(var56);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2695 == var1.serverPacket) {
					var87 = var3.readUnsignedByteSub() == 1;
					var5 = var3.readIntLE();
					var6 = VarbitComposition.getWidget(var5);
					if (var87 != var6.isHidden) {
						var6.isHidden = var87;
						class200.invalidateWidget(var6);
					}

					var1.serverPacket = null;
					return true;
				}

				Widget var37;
				if (ServerPacket.field2617 == var1.serverPacket) {
					var20 = var3.readIntIME();
					var5 = var3.readIntLE();
					InterfaceParent var55 = (InterfaceParent)interfaceParents.get((long)var5);
					var82 = (InterfaceParent)interfaceParents.get((long)var20);
					if (var82 != null) {
						Actor.closeInterface(var82, var55 == null || var82.group != var55.group);
					}

					if (var55 != null) {
						var55.remove();
						interfaceParents.put(var55, (long)var20);
					}

					var37 = VarbitComposition.getWidget(var5);
					if (var37 != null) {
						class200.invalidateWidget(var37);
					}

					var37 = VarbitComposition.getWidget(var20);
					if (var37 != null) {
						class200.invalidateWidget(var37);
						SoundCache.revalidateWidgetScroll(ArchiveLoader.Widget_interfaceComponents[var37.id >>> 16], var37, true);
					}

					if (rootInterface != -1) {
						ChatChannel.runIntfCloseListeners(rootInterface, 1);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2665 == var1.serverPacket) {
					var20 = var3.readSignedShortAdd();
					var5 = var3.readIntIME();
					var22 = var3.readSignedShortLE();
					var80 = VarbitComposition.getWidget(var5);
					if (var20 != var80.rawX || var22 != var80.rawY || var80.xAlignment != 0 || var80.yAlignment != 0) {
						var80.rawX = var20;
						var80.rawY = var22;
						var80.xAlignment = 0;
						var80.yAlignment = 0;
						class200.invalidateWidget(var80);
						this.alignWidget(var80);
						if (var80.type == 0) {
							SoundCache.revalidateWidgetScroll(ArchiveLoader.Widget_interfaceComponents[var5 >> 16], var80, false);
						}
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2662 == var1.serverPacket) {
					for (var20 = 0; var20 < Varps.Varps_main.length; ++var20) {
						if (Varps.Varps_temp[var20] != Varps.Varps_main[var20]) {
							Varps.Varps_main[var20] = Varps.Varps_temp[var20];
							MenuAction.changeGameOptions(var20);
							changedVarps[++changedVarpCount - 1 & 31] = var20;
						}
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2689 == var1.serverPacket) {
					class135.varclan = null;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2647 == var1.serverPacket) {
					var20 = var3.readUnsignedShort();
					var5 = var3.readUnsignedByte();
					var22 = var3.readUnsignedShort();
					class17.queueSoundEffect(var20, var5, var22);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2711 == var1.serverPacket) {
					class358.updateNpcs(true, var3);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2684 == var1.serverPacket) {
					var20 = var3.readUnsignedByte();
					FriendsChat.method2173(var20);
					var1.serverPacket = null;
					return true;
				}

				NPC var92;
				if (ServerPacket.field2639 == var1.serverPacket) {
					var5 = var3.readIntME();
					var22 = var3.readUnsignedShortAdd();
					var20 = var3.readUnsignedShortAddLE();
					var92 = npcs[var20];
					var7 = var3.readUnsignedByte();
					if (var92 != null) {
						var92.updateSpotAnimation(var7, var22, var5 >> 16, var5 & 65535);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2622 == var1.serverPacket) {
					class27.processZoneOperation(ZoneOperation.field2585);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.CAM_LOOKAT == var1.serverPacket) {
					minimapState = var3.readUnsignedByte();
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2618 == var1.serverPacket) {
					return this.method381(var1);
				}

				if (ServerPacket.field2612 == var1.serverPacket) {
					var52 = var3.readStringCp1252NullTerminated();
					var21 = AbstractFont.escapeBrackets(class153.method797(class292.readString(var3)));
					class415.addGameMessage(6, var52, var21);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.CLANCHANNEL_DELTA == var1.serverPacket) {
					var20 = var3.readInt();
					var5 = var3.readInt();
					var22 = class27.getGcDuration();
					PacketBufferNode var24 = class503.getPacketBufferNode(ClientPacket.field2527, packetWriter.isaacCipher);
					var24.packetBuffer.writeByteNeg(var22);
					var24.packetBuffer.writeByteAdd(GameEngine.fps);
					var24.packetBuffer.writeIntLE(var20);
					var24.packetBuffer.writeInt(var5);
					packetWriter.addNode(var24);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2650 == var1.serverPacket) {
					Tile.method1161();
					var72 = var3.readByte();
					if (var1.serverPacketLength == 1) {
						if (var72 >= 0) {
							currentClanSettings[var72] = null;
						} else {
							class11.guestClanSettings = null;
						}

						var1.serverPacket = null;
						return true;
					}

					if (var72 >= 0) {
						currentClanSettings[var72] = new ClanSettings(var3);
					} else {
						class11.guestClanSettings = new ClanSettings(var3);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2686 == var1.serverPacket) {
					AABB.readReflectionCheck(var3, var1.serverPacketLength);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2697 == var1.serverPacket) {
					class303.loadRegions(false, var1.packetBuffer);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2675 == var1.serverPacket) {
					class303.loadRegions(true, var1.packetBuffer);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.UPDATE_UID192 == var1.serverPacket) {
					var52 = var3.readStringCp1252NullTerminated();
					var29 = (long)var3.readUnsignedShort();
					var31 = (long)var3.readMedium();
					PlayerType var25 = (PlayerType)ClientPreferences.findEnumerated(PendingSpawn.PlayerType_values(), var3.readUnsignedByte());
					long var46 = (var29 << 32) + var31;
					var23 = false;

					for (var13 = 0; var13 < 100; ++var13) {
						if (var46 == field613[var13]) {
							var23 = true;
							break;
						}
					}

					if (class177.friendSystem.isIgnored(new Username(var52, class457.loginType))) {
						var23 = true;
					}

					if (!var23 && field485 == 0) {
						field613[field530] = var46;
						field530 = (field530 + 1) % 100;
						var38 = AbstractFont.escapeBrackets(class153.method797(class292.readString(var3)));
						byte var14;
						if (var25.isPrivileged) {
							var14 = 7;
						} else {
							var14 = 3;
						}

						if (var25.modIcon != -1) {
							class415.addGameMessage(var14, SecureRandomCallable.addImageTag(var25.modIcon) + var52, var38);
						} else {
							class415.addGameMessage(var14, var52, var38);
						}
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2643 == var1.serverPacket) {
					World var51 = new World();
					var51.host = var3.readStringCp1252NullTerminated();
					var51.id = var3.readUnsignedShort();
					var5 = var3.readInt();
					var51.properties = var5;
					if (var51.isDeadman()) {
						var51.field677 = "beta";
					}

					class129.updateGameState(45);
					var2.close();
					var2 = null;
					class137.changeWorld(var51);
					var1.serverPacket = null;
					return false;
				}

				if (ServerPacket.NPC_INFO_LARGE == var1.serverPacket) {
					DbRowType.process();
					runEnergy = var3.readUnsignedShort();
					field524 = cycleCntr;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2633 == var1.serverPacket) {
					var20 = var3.readIntIME();
					short var58 = (short)var3.readSignedShortLE();
					var22 = var3.readUnsignedByteAdd();
					var7 = var3.readUnsignedShortLE();
					var92 = npcs[var7];
					if (var92 != null) {
						var92.method593(var22, var20, var58);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2703 == var1.serverPacket) {
					var20 = var3.readUnsignedShortAddLE();
					if (var20 == 65535) {
						var20 = -1;
					}

					rootInterface = var20;
					this.resizeRoot(false);
					class92.Widget_resetModelFrames(var20);
					ScriptFrame.runWidgetOnLoadListener(rootInterface);

					for (var5 = 0; var5 < 100; ++var5) {
						field403[var5] = true;
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2601 == var1.serverPacket) {
					var20 = var3.readUnsignedShortLE();
					class59.method320(var20);
					changedItemContainers[++changedItemContainersCount - 1 & 31] = var20 & 32767;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.VARCLAN == var1.serverPacket) {
					class177.friendSystem.method407();
					field516 = cycleCntr;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2661 == var1.serverPacket) {
					class27.processZoneOperation(ZoneOperation.field2586);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2642 == var1.serverPacket) {
					class27.processZoneOperation(ZoneOperation.field2583);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.REBUILD_REGION_NORMAL == var1.serverPacket) {
					class27.processZoneOperation(ZoneOperation.field2587);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2677 == var1.serverPacket) {
					class387.field3646 = var3.readUnsignedByteSub();
					WorldMapSectionType.field2393 = var3.readUnsignedByteNeg();

					while (var3.offset < var1.serverPacketLength) {
						var20 = var3.readUnsignedByte();
						ZoneOperation var71 = ViewportMouse.method1320()[var20];
						class27.processZoneOperation(var71);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2624 == var1.serverPacket) {
					class177.friendSystem.ignoreList.read(var3, var1.serverPacketLength);
					GameBuild.FriendSystem_invalidateIgnoreds();
					field516 = cycleCntr;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.IF_SETTEXT == var1.serverPacket) {
					rebootTimer = var3.readUnsignedShortAdd() * 30;
					field524 = cycleCntr;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2630 == var1.serverPacket) {
					var20 = var3.readUnsignedShortAdd();
					var5 = var3.readInt();
					var22 = var3.readUnsignedShortAdd();
					var7 = var3.readUnsignedShortAdd();
					var37 = VarbitComposition.getWidget(var5);
					if (var7 != var37.modelAngleX || var20 != var37.modelAngleY || var22 != var37.modelZoom) {
						var37.modelAngleX = var7;
						var37.modelAngleY = var20;
						var37.modelZoom = var22;
						class200.invalidateWidget(var37);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2657 == var1.serverPacket) {
					var20 = var3.readInt();
					var5 = var3.readUnsignedShort();
					if (var20 < -70000) {
						var5 += 32768;
					}

					if (var20 >= 0) {
						var6 = VarbitComposition.getWidget(var20);
					} else {
						var6 = null;
					}

					for (; var3.offset < var1.serverPacketLength; ObjectComposition.itemContainerSetItem(var5, var7, var8 - 1, var57)) {
						var7 = var3.readUShortSmart();
						var8 = var3.readUnsignedShort();
						var57 = 0;
						if (var8 != 0) {
							var57 = var3.readUnsignedByte();
							if (var57 == 255) {
								var57 = var3.readInt();
							}
						}

						if (var6 != null && var7 >= 0 && var7 < var6.itemIds.length) {
							var6.itemIds[var7] = var8;
							var6.field3036[var7] = var57;
						}
					}

					if (var6 != null) {
						class200.invalidateWidget(var6);
					}

					DbRowType.process();
					changedItemContainers[++changedItemContainersCount - 1 & 31] = var5 & 32767;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2626 == var1.serverPacket) {
					var72 = var3.readSignedByteSub();
					var5 = var3.readUnsignedShort();
					Varps.Varps_temp[var5] = var72;
					if (Varps.Varps_main[var5] != var72) {
						Varps.Varps_main[var5] = var72;
					}

					MenuAction.changeGameOptions(var5);
					changedVarps[++changedVarpCount - 1 & 31] = var5;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2712 == var1.serverPacket) {
					class27.processZoneOperation(ZoneOperation.field2581);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.UPDATE_INV_CLEAR == var1.serverPacket) {
					class387.field3646 = var3.readUnsignedByte();
					WorldMapSectionType.field2393 = var3.readUnsignedByte();

					for (var20 = WorldMapSectionType.field2393; var20 < WorldMapSectionType.field2393 + 8; ++var20) {
						for (var5 = class387.field3646; var5 < class387.field3646 + 8; ++var5) {
							if (groundItems[class36.Client_plane][var20][var5] != null) {
								groundItems[class36.Client_plane][var20][var5] = null;
								class344.updateItemPile(var20, var5);
							}
						}
					}

					for (PendingSpawn var50 = (PendingSpawn)pendingSpawns.last(); var50 != null; var50 = (PendingSpawn)pendingSpawns.previous()) {
						if (var50.x >= WorldMapSectionType.field2393 && var50.x < WorldMapSectionType.field2393 + 8 && var50.y >= class387.field3646 && var50.y < class387.field3646 + 8 && var50.plane == class36.Client_plane) {
							var50.endCycle = 0;
						}
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2627 == var1.serverPacket) {
					var20 = var3.readUnsignedShortLE();
					var5 = var3.readIntIME();
					var6 = VarbitComposition.getWidget(var5);
					if (var6.modelType != 2 || var20 != var6.modelId) {
						var6.modelType = 2;
						var6.modelId = var20;
						class200.invalidateWidget(var6);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2606 == var1.serverPacket) {
					var20 = var3.readUnsignedByte();
					var5 = var3.readUnsignedByte();
					var22 = var3.readUnsignedByte();
					var7 = var3.readUnsignedByte();
					field406[var20] = true;
					field587[var20] = var5;
					field586[var20] = var22;
					field588[var20] = var7;
					cameraShakeCycle[var20] = 0;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2671 == var1.serverPacket) {
					class358.updateNpcs(false, var3);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.UPDATE_RUNENERGY == var1.serverPacket) {
					isCameraLocked = true;
					field397 = false;
					field398 = false;
					WorldMapIcon_1.field2301 = var3.readUnsignedByte();
					class132.field1260 = var3.readUnsignedByte();
					ModeWhere.field3603 = var3.readUnsignedShort();
					field538 = var3.readUnsignedByte();
					SecureRandomFuture.field803 = var3.readUnsignedByte();
					if (SecureRandomFuture.field803 >= 100) {
						class157.cameraX = WorldMapIcon_1.field2301 * 128 + 64;
						SoundSystem.cameraZ = class132.field1260 * 128 + 64;
						class384.cameraY = class306.getTileHeight(class157.cameraX, SoundSystem.cameraZ, class36.Client_plane) - ModeWhere.field3603;
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2619 == var1.serverPacket) {
					var20 = var3.readUnsignedShortAddLE();
					var5 = var3.readIntIME();
					Varps.Varps_temp[var20] = var5;
					if (Varps.Varps_main[var20] != var5) {
						Varps.Varps_main[var20] = var5;
					}

					MenuAction.changeGameOptions(var20);
					changedVarps[++changedVarpCount - 1 & 31] = var20;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2700 == var1.serverPacket) {
					isCameraLocked = true;
					field397 = false;
					field398 = true;
					WorldMapIcon_1.field2301 = var3.readUnsignedByte();
					class132.field1260 = var3.readUnsignedByte();
					var20 = var3.readUnsignedShort();
					var5 = var3.readUnsignedShort();
					field399 = var3.readBoolean();
					var22 = var3.readUnsignedByte();
					var7 = WorldMapIcon_1.field2301 * 128 + 64;
					var8 = class132.field1260 * 128 + 64;
					boolean var9 = false;
					boolean var10 = false;
					if (field399) {
						var57 = class384.cameraY;
						var59 = class306.getTileHeight(var7, var8, class36.Client_plane) - var20;
					} else {
						var57 = class306.getTileHeight(class157.cameraX, SoundSystem.cameraZ, class36.Client_plane) - class384.cameraY;
						var59 = var20;
					}

					field638 = new class478(class157.cameraX, SoundSystem.cameraZ, var57, var7, var8, var59, var5, var22);
					var1.serverPacket = null;
					return true;
				}

				class317.RunException_sendStackTrace("" + (var1.serverPacket != null ? var1.serverPacket.id * -1448898935 * 1217808313 : -1) + "," + (var1.field1146 != null ? var1.field1146.id * -1448898935 * 1217808313 : -1) + "," + (var1.field1148 != null ? var1.field1148.id * -1448898935 * 1217808313 : -1) + "," + var1.serverPacketLength, (Throwable)null);
				WorldMapScaleHandler.logOut();
			} catch (IOException var48) {
				class93.method508();
			} catch (Exception var49) {
				var21 = "" + (var1.serverPacket != null ? var1.serverPacket.id * -1448898935 * 1217808313 : -1) + "," + (var1.field1146 != null ? var1.field1146.id * -1448898935 * 1217808313 : -1) + "," + (var1.field1148 != null ? var1.field1148.id * -1448898935 * 1217808313 : -1) + "," + var1.serverPacketLength + "," + (class136.localPlayer.pathX[0] + AbstractArchive.baseX) + "," + (class136.localPlayer.pathY[0] + class148.baseY) + ",";

				for (var22 = 0; var22 < var1.serverPacketLength && var22 < 50; ++var22) {
					var21 = var21 + var3.array[var22] + ",";
				}

				class317.RunException_sendStackTrace(var21, var49);
				WorldMapScaleHandler.logOut();
			}

			return true;
		}
	}

	@ObfuscatedName("kz")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "1663377203"
	)
	@Export("menu")
	final void menu() {
		class143.method760();
		if (clickedWidget == null) {
			int var1 = MouseHandler.MouseHandler_lastButton;
			int var2;
			if (isMenuOpen) {
				int var3;
				if (var1 != 1 && (class28.mouseCam || var1 != 4)) {
					var2 = MouseHandler.MouseHandler_x;
					var3 = MouseHandler.MouseHandler_y;
					if (var2 < Canvas.menuX - 10 || var2 > Canvas.menuX + UserComparator5.menuWidth + 10 || var3 < UserComparator6.menuY - 10 || var3 > UserComparator6.menuY + ModeWhere.menuHeight + 10) {
						isMenuOpen = false;
						Skeleton.method1209(Canvas.menuX, UserComparator6.menuY, UserComparator5.menuWidth, ModeWhere.menuHeight);
					}
				}

				if (var1 == 1 || !class28.mouseCam && var1 == 4) {
					var2 = Canvas.menuX;
					var3 = UserComparator6.menuY;
					int var4 = UserComparator5.menuWidth;
					int var5 = MouseHandler.MouseHandler_lastPressedX;
					int var6 = MouseHandler.MouseHandler_lastPressedY;
					int var7 = -1;

					for (int var8 = 0; var8 < menuOptionsCount; ++var8) {
						int var9 = (menuOptionsCount - 1 - var8) * 15 + var3 + 31;
						if (var5 > var2 && var5 < var2 + var4 && var6 > var9 - 13 && var6 < var9 + 3) {
							var7 = var8;
						}
					}

					if (var7 != -1) {
						SoundCache.method229(var7);
					}

					isMenuOpen = false;
					Skeleton.method1209(Canvas.menuX, UserComparator6.menuY, UserComparator5.menuWidth, ModeWhere.menuHeight);
				}
			} else {
				var2 = class59.method323();
				if ((var1 == 1 || !class28.mouseCam && var1 == 4) && this.shouldLeftClickOpenMenu()) {
					var1 = 2;
				}

				if ((var1 == 1 || !class28.mouseCam && var1 == 4) && menuOptionsCount > 0) {
					SoundCache.method229(var2);
				}

				if (var1 == 2 && menuOptionsCount > 0) {
					this.openMenu(MouseHandler.MouseHandler_lastPressedX, MouseHandler.MouseHandler_lastPressedY);
				}
			}

		}
	}

	@ObfuscatedName("ko")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "1989304759"
	)
	@Export("shouldLeftClickOpenMenu")
	final boolean shouldLeftClickOpenMenu() {
		int var1 = class59.method323();
		return (leftClickOpensMenu && menuOptionsCount > 2 || class127.method704(var1)) && !menuShiftClick[var1];
	}

	@ObfuscatedName("ki")
	@ObfuscatedSignature(
		descriptor = "(IIB)V",
		garbageValue = "14"
	)
	@Export("openMenu")
	final void openMenu(int var1, int var2) {
		ClanSettings.method823(var1, var2);
		var1 -= viewportOffsetX;
		var2 -= viewportOffsetY;
		UserComparator5.scene.menuOpen(class36.Client_plane, var1, var2, false);
		isMenuOpen = true;
	}

	@ObfuscatedName("lp")
	@ObfuscatedSignature(
		descriptor = "(ZI)V",
		garbageValue = "-657989898"
	)
	@Export("resizeRoot")
	final void resizeRoot(boolean var1) {
		int var2 = rootInterface;
		int var3 = GrandExchangeOfferTotalQuantityComparator.canvasWidth;
		int var4 = WorldMapArchiveLoader.canvasHeight;
		if (Login.loadInterface(var2)) {
			class36.resizeInterface(ArchiveLoader.Widget_interfaceComponents[var2], -1, var3, var4, var1);
		}

	}

	@ObfuscatedName("lf")
	@ObfuscatedSignature(
		descriptor = "(Lmt;I)V",
		garbageValue = "1861901325"
	)
	@Export("alignWidget")
	void alignWidget(Widget var1) {
		Widget var2 = var1.parentId == -1 ? null : VarbitComposition.getWidget(var1.parentId);
		int var3;
		int var4;
		if (var2 == null) {
			var3 = GrandExchangeOfferTotalQuantityComparator.canvasWidth;
			var4 = WorldMapArchiveLoader.canvasHeight;
		} else {
			var3 = var2.width;
			var4 = var2.height;
		}

		FriendSystem.alignWidgetSize(var1, var3, var4, false);
		class17.alignWidgetPosition(var1, var3, var4);
	}

	@ObfuscatedName("mi")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "-36"
	)
	final void method389() {
		class200.invalidateWidget(clickedWidget);
		++class130.widgetDragDuration;
		int var1;
		int var2;
		if (field393 && field391) {
			var1 = MouseHandler.MouseHandler_x;
			var2 = MouseHandler.MouseHandler_y;
			var1 -= widgetClickX;
			var2 -= widgetClickY;
			if (var1 < field500) {
				var1 = field500;
			}

			if (var1 + clickedWidget.width > field500 + clickedWidgetParent.width) {
				var1 = field500 + clickedWidgetParent.width - clickedWidget.width;
			}

			if (var2 < field504) {
				var2 = field504;
			}

			if (var2 + clickedWidget.height > field504 + clickedWidgetParent.height) {
				var2 = field504 + clickedWidgetParent.height - clickedWidget.height;
			}

			int var3 = var1 - field520;
			int var4 = var2 - field510;
			int var5 = clickedWidget.dragZoneSize;
			if (class130.widgetDragDuration > clickedWidget.dragThreshold && (var3 > var5 || var3 < -var5 || var4 > var5 || var4 < -var5)) {
				isDraggingWidget = true;
			}

			int var6 = var1 - field500 + clickedWidgetParent.scrollX;
			int var7 = var2 - field504 + clickedWidgetParent.scrollY;
			ScriptEvent var8;
			if (clickedWidget.onDrag != null && isDraggingWidget) {
				var8 = new ScriptEvent();
				var8.widget = clickedWidget;
				var8.mouseX = var6;
				var8.mouseY = var7;
				var8.args = clickedWidget.onDrag;
				GrandExchangeOfferOwnWorldComparator.runScriptEvent(var8);
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
						GrandExchangeOfferOwnWorldComparator.runScriptEvent(var8);
					}

					if (draggedOnWidget != null && WorldMapEvent.method1547(clickedWidget) != null) {
						PacketBufferNode var13 = class503.getPacketBufferNode(ClientPacket.field2558, packetWriter.isaacCipher);
						var13.packetBuffer.writeShort(clickedWidget.itemId);
						var13.packetBuffer.writeShortLE(clickedWidget.childIndex);
						var13.packetBuffer.writeShort(draggedOnWidget.childIndex);
						var13.packetBuffer.writeShortAddLE(draggedOnWidget.itemId);
						var13.packetBuffer.writeIntLE(clickedWidget.id);
						var13.packetBuffer.writeIntME(draggedOnWidget.id);
						packetWriter.addNode(var13);
					}
				} else if (this.shouldLeftClickOpenMenu()) {
					this.openMenu(widgetClickX + field520, widgetClickY + field510);
				} else if (menuOptionsCount > 0) {
					int var11 = widgetClickX + field520;
					int var9 = widgetClickY + field510;
					MenuAction var10 = WorldMapRegion.tempMenuAction;
					if (var10 != null) {
						class60.menuAction(var10.param0, var10.param1, var10.opcode, var10.identifier, var10.itemId, var10.action, var10.target, var11, var9);
					}

					WorldMapRegion.tempMenuAction = null;
				}

				clickedWidget = null;
			}

		} else {
			if (class130.widgetDragDuration > 1) {
				if (!isDraggingWidget && menuOptionsCount > 0) {
					var1 = widgetClickX + field520;
					var2 = field510 + widgetClickY;
					MenuAction var12 = WorldMapRegion.tempMenuAction;
					if (var12 != null) {
						class60.menuAction(var12.param0, var12.param1, var12.opcode, var12.identifier, var12.itemId, var12.action, var12.target, var1, var2);
					}

					WorldMapRegion.tempMenuAction = null;
				}

				clickedWidget = null;
			}

		}
	}

	@ObfuscatedName("ne")
	@ObfuscatedSignature(
		descriptor = "(I)Lui;",
		garbageValue = "466420447"
	)
	@Export("username")
	public Username username() {
		return class136.localPlayer != null ? class136.localPlayer.username : null;
	}

	@Export("init")
	@ObfuscatedName("init")
	public final void init() {
		if (this.checkHost()) {
			for (int var1 = 0; var1 <= 28; ++var1) {
				String var2 = this.getParameter(Integer.toString(var1));
				if (var2 != null) {
					int var4;
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
						var4 = Integer.parseInt(var2);
						Language var14;
						if (var4 >= 0 && var4 < Language.field3593.length) {
							var14 = Language.field3593[var4];
						} else {
							var14 = null;
						}

						Interpreter.clientLanguage = var14;
						break;
					case 7:
						var4 = Integer.parseInt(var2);
						GameBuild[] var5 = new GameBuild[]{GameBuild.WIP, GameBuild.RC, GameBuild.LIVE, GameBuild.BUILDLIVE};
						GameBuild[] var6 = var5;
						int var7 = 0;

						GameBuild var13;
						while (true) {
							if (var7 >= var6.length) {
								var13 = null;
								break;
							}

							GameBuild var8 = var6[var7];
							if (var4 == var8.buildId) {
								var13 = var8;
								break;
							}

							++var7;
						}

						ArchiveLoader.field849 = var13;
						break;
					case 8:
						if (var2.equalsIgnoreCase("true")) {
						}
						break;
					case 9:
						class36.param9 = var2;
						break;
					case 10:
						StudioGame[] var9 = new StudioGame[]{StudioGame.game5, StudioGame.oldscape, StudioGame.stellardawn, StudioGame.game4, StudioGame.runescape, StudioGame.game3};
						KeyHandler.field72 = (StudioGame)ClientPreferences.findEnumerated(var9, Integer.parseInt(var2));
						if (StudioGame.oldscape == KeyHandler.field72) {
							class457.loginType = LoginType.oldscape;
						} else {
							class457.loginType = LoginType.field4055;
						}
						break;
					case 11:
						BuddyRankComparator.field1182 = var2;
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
						PcmPlayer.field182 = Integer.parseInt(var2);
						break;
					case 15:
						gameBuild = Integer.parseInt(var2);
						break;
					case 17:
						class292.field2478 = var2;
						break;
					case 21:
						param21 = Integer.parseInt(var2);
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

			class92.method504();
			VarbitComposition.worldHost = this.getCodeBase().getHost();
			class153.field1356 = new JagNetThread();
			String var10 = ArchiveLoader.field849.name;
			byte var11 = 0;
			if ((worldProperties & 65536) != 0) {
				VarpDefinition.field1494 = "beta";
			}

			try {
				ObjTypeCustomisation.method923("oldschool", VarpDefinition.field1494, var10, var11, 22);
			} catch (Exception var12) {
				class317.RunException_sendStackTrace((String)null, var12);
			}

			TileItem.client = this;
			RunException.field4246 = clientType;
			Actor.method527();
			if (Boolean.parseBoolean(System.getProperty("jagex.disableBouncyCastle"))) {
				this.field655 = true;
			}

			if (field421 == -1) {
				if (!this.method361() && !this.method362()) {
					field421 = 0;
				} else {
					field421 = 5;
				}
			}

			this.startThread(765, 503, 215, 1);
		}
	}

	protected void finalize() throws Throwable {
		class306.field2759.remove(this);
		super.finalize();
	}

	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		descriptor = "(IB)J",
		garbageValue = "-71"
	)
	public static long method359(int var0) {
		if (var0 > 63) {
			throw new class390("Cannot generate max unsigned value for more than 63 bits as this is greater than the boundaries of a java long. Value provided: %d", new Object[]{var0});
		} else {
			return (long)Math.pow(2.0D, (double)var0) - 1L;
		}
	}

	@ObfuscatedName("kx")
	@ObfuscatedSignature(
		descriptor = "(Ldh;B)V",
		garbageValue = "2"
	)
	static void method383(NPC var0) {
		var0.field976 = var0.definition.size;
		var0.field1005 = var0.definition.rotation;
		var0.walkSequence = var0.definition.walkSequence;
		var0.walkBackSequence = var0.definition.walkBackSequence;
		var0.walkLeftSequence = var0.definition.walkLeftSequence;
		var0.walkRightSequence = var0.definition.walkRightSequence;
		var0.idleSequence = var0.definition.idleSequence;
		var0.turnLeftSequence = var0.definition.turnLeftSequence;
		var0.turnRightSequence = var0.definition.turnRightSequence;
		var0.runSequence = var0.definition.runSequence;
		var0.runBackSequence = var0.definition.runBackSequence;
		var0.runLeftSequence = var0.definition.runLeftSequence;
		var0.runRightSequence = var0.definition.runRightSequence;
		var0.crawlSequence = var0.definition.crawlSequence;
		var0.crawlBackSequence = var0.definition.crawlBackSequence;
		var0.crawlLeftSequence = var0.definition.crawlLeftSequence;
		var0.crawlRightSequence = var0.definition.crawlRightSequence;
	}

	@ObfuscatedName("nu")
	@ObfuscatedSignature(
		descriptor = "(III)V",
		garbageValue = "2022659709"
	)
	static final void method390(int var0, int var1) {
		ClanChannel var2 = var0 >= 0 ? currentClanChannels[var0] : WorldMapLabelSize.guestClanChannel;
		if (var2 != null && var1 >= 0 && var1 < var2.method851()) {
			ClanChannelMember var3 = (ClanChannelMember)var2.members.get(var1);
			if (var3.rank == -1) {
				String var4 = var3.username.getName();
				PacketBufferNode var5 = class503.getPacketBufferNode(ClientPacket.field2515, packetWriter.isaacCipher);
				var5.packetBuffer.writeByte(3 + class501.stringCp1252NullTerminatedByteSize(var4));
				var5.packetBuffer.writeByte(var0);
				var5.packetBuffer.writeShort(var1);
				var5.packetBuffer.writeStringCp1252NullTerminated(var4);
				packetWriter.addNode(var5);
			}
		}
	}
}
