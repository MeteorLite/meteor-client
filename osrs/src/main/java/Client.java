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
import java.util.*;
import java.util.concurrent.Future;

@Implements("Client")
@ObfuscatedName("client")
public final class Client extends GameEngine implements Usernamed, OAuthApi, class311 {
	boolean shouldProcessClick() {
		return false;
	}
	@ObfuscatedName("vd")
	@Export("viewportOffsetX")
	static int viewportOffsetX;
	@ObfuscatedName("vc")
	@Export("viewportOffsetY")
	static int viewportOffsetY;
	@ObfuscatedName("wd")
	public static int field369;
	@ObfuscatedName("xy")
	static int[] field593;
	@ObfuscatedName("uh")
	static boolean field400;
	@ObfuscatedName("xf")
	static int[] field592;
	@ObfuscatedName("xm")
	@ObfuscatedSignature(
		descriptor = "Lcl;"
	)
	static final ApproximateRouteStrategy field652;
	@ObfuscatedName("vb")
	static int field542;
	@ObfuscatedName("vw")
	@Export("cameraShaking")
	static boolean[] cameraShaking;
	@ObfuscatedName("vy")
	@ObfuscatedSignature(
		descriptor = "Lmt;"
	)
	@Export("playerAppearance")
	static PlayerComposition playerAppearance;
	@ObfuscatedName("vs")
	static int field547;
	@ObfuscatedName("wx")
	@ObfuscatedSignature(
		descriptor = "Lle;"
	)
	@Export("Widget_cachedModels")
	static EvictingDualNodeHashTable Widget_cachedModels;
	@ObfuscatedName("wj")
	@ObfuscatedSignature(
		descriptor = "Lle;"
	)
	@Export("Widget_cachedFonts")
	static EvictingDualNodeHashTable Widget_cachedFonts;
	@ObfuscatedName("wv")
	@Export("archiveLoaders")
	static ArrayList archiveLoaders;
	@ObfuscatedName("wk")
	@Export("archiveLoadersDone")
	static int archiveLoadersDone;
	@ObfuscatedName("ws")
	@ObfuscatedSignature(
		descriptor = "Lqv;"
	)
	@Export("archive5")
	static class423 archive5;
	@ObfuscatedName("wo")
	@ObfuscatedSignature(
		descriptor = "Lsv;"
	)
	static class475 field645;
	@ObfuscatedName("vl")
	static short field638;
	@ObfuscatedName("vp")
	static short field640;
	@ObfuscatedName("vu")
	static short field641;
	@ObfuscatedName("vj")
	static short field637;
	@ObfuscatedName("ve")
	static short field634;
	@ObfuscatedName("vx")
	@Export("viewportZoom")
	static int viewportZoom;
	@ObfuscatedName("vf")
	static short field635;
	@ObfuscatedName("vo")
	@Export("viewportWidth")
	static int viewportWidth;
	@ObfuscatedName("we")
	static int field550;
	@ObfuscatedName("vn")
	@Export("viewportHeight")
	static int viewportHeight;
	@ObfuscatedName("vm")
	@Export("zoomHeight")
	static short zoomHeight;
	@ObfuscatedName("vi")
	@Export("zoomWidth")
	static short zoomWidth;
	@ObfuscatedName("vq")
	@Export("cameraMoveIntensity")
	static int[] cameraMoveIntensity;
	@ObfuscatedName("vh")
	@Export("cameraShakeIntensity")
	static int[] cameraShakeIntensity;
	@ObfuscatedName("vk")
	@Export("cameraShakeSpeed")
	static int[] cameraShakeSpeed;
	@ObfuscatedName("vz")
	@Export("cameraShakeCycle")
	static int[] cameraShakeCycle;
	@ObfuscatedName("wf")
	@ObfuscatedSignature(
		descriptor = "[Loh;"
	)
	@Export("grandExchangeOffers")
	static GrandExchangeOffer[] grandExchangeOffers;
	@ObfuscatedName("wy")
	@ObfuscatedSignature(
		descriptor = "Lcu;"
	)
	@Export("GrandExchangeEvents_worldComparator")
	static GrandExchangeOfferOwnWorldComparator GrandExchangeEvents_worldComparator;
	@ObfuscatedName("wa")
	static int field549;
	@ObfuscatedName("wt")
	static List field609;
	@ObfuscatedName("bc")
	@Export("lockMouseRecorder")
	static boolean lockMouseRecorder;
	@ObfuscatedName("bg")
	@Export("worldId")
	public static int worldId;
	@ObfuscatedName("cw")
	@Export("worldProperties")
	static int worldProperties;
	@ObfuscatedName("cm")
	@Export("gameBuild")
	static int gameBuild;
	@ObfuscatedName("cx")
	@Export("isMembersWorld")
	public static boolean isMembersWorld;
	@ObfuscatedName("cr")
	@Export("isLowDetail")
	static boolean isLowDetail;
	@ObfuscatedName("cv")
	@Export("param21")
	static int param21;
	@ObfuscatedName("co")
	@Export("clientType")
	static int clientType;
	@ObfuscatedName("cl")
	static int field424;
	@ObfuscatedName("cu")
	@Export("onMobile")
	static boolean onMobile;
	@ObfuscatedName("ch")
	@Export("param25")
	public static int param25;
	@ObfuscatedName("dj")
	@Export("gameState")
	static int gameState;
	@ObfuscatedName("di")
	@Export("reloadJS5")
	static boolean reloadJS5;
	@ObfuscatedName("ed")
	@Export("isLoading")
	static boolean isLoading;
	@ObfuscatedName("eh")
	@Export("cycle")
	static int cycle;
	@ObfuscatedName("ey")
	@Export("mouseLastLastPressedTimeMillis")
	static long mouseLastLastPressedTimeMillis;
	@ObfuscatedName("eq")
	@Export("lastMouseRecordX")
	static int lastMouseRecordX;
	@ObfuscatedName("ej")
	@Export("lastMouseRecordY")
	static int lastMouseRecordY;
	@ObfuscatedName("ea")
	static long field612;
	@ObfuscatedName("er")
	@Export("hadFocus")
	static boolean hadFocus;
	@ObfuscatedName("ev")
	@Export("rebootTimer")
	static int rebootTimer;
	@ObfuscatedName("ez")
	@Export("hintArrowType")
	static int hintArrowType;
	@ObfuscatedName("et")
	@Export("hintArrowNpcIndex")
	static int hintArrowNpcIndex;
	@ObfuscatedName("en")
	@Export("hintArrowPlayerIndex")
	static int hintArrowPlayerIndex;
	@ObfuscatedName("eb")
	@Export("hintArrowX")
	static int hintArrowX;
	@ObfuscatedName("ei")
	@Export("hintArrowY")
	static int hintArrowY;
	@ObfuscatedName("es")
	@Export("hintArrowHeight")
	static int hintArrowHeight;
	@ObfuscatedName("el")
	@Export("hintArrowSubX")
	static int hintArrowSubX;
	@ObfuscatedName("em")
	@Export("hintArrowSubY")
	static int hintArrowSubY;
	@ObfuscatedName("ek")
	@ObfuscatedSignature(
		descriptor = "Ldc;"
	)
	@Export("playerAttackOption")
	static AttackOption playerAttackOption;
	@ObfuscatedName("ec")
	@ObfuscatedSignature(
		descriptor = "Ldc;"
	)
	@Export("npcAttackOption")
	static AttackOption npcAttackOption;
	@ObfuscatedName("eu")
	@Export("renderSelf")
	static boolean renderSelf;
	@ObfuscatedName("fl")
	@ObfuscatedSignature(
		descriptor = "Ldz;"
	)
	static class92 field419;
	@ObfuscatedName("fj")
	@Export("js5ConnectState")
	static int js5ConnectState;
	@ObfuscatedName("fv")
	@Export("js5Cycles")
	static int js5Cycles;
	@ObfuscatedName("gg")
	@Export("js5Errors")
	static int js5Errors;
	@ObfuscatedName("gi")
	@Export("loginState")
	static int loginState;
	@ObfuscatedName("go")
	static int field448;
	@ObfuscatedName("gl")
	static int field447;
	@ObfuscatedName("gb")
	static int field444;
	@ObfuscatedName("gj")
	@ObfuscatedSignature(
		descriptor = "Lfr;"
	)
	static class139 field421;
	@ObfuscatedName("ge")
	@ObfuscatedSignature(
		descriptor = "Ltv;"
	)
	static class519 field648;
	@ObfuscatedName("hl")
	static final String field656;
	@ObfuscatedName("hg")
	static final String field655;
	@ObfuscatedName("hm")
	@Export("Login_isUsernameRemembered")
	static boolean Login_isUsernameRemembered;
	@ObfuscatedName("hv")
	@ObfuscatedSignature(
		descriptor = "Lcc;"
	)
	@Export("secureRandomFuture")
	static SecureRandomFuture secureRandomFuture;
	@ObfuscatedName("ie")
	@Export("randomDatData")
	static byte[] randomDatData;
	@ObfuscatedName("ij")
	@ObfuscatedSignature(
		descriptor = "[Ldx;"
	)
	@Export("npcs")
	static NPC[] npcs;
	@ObfuscatedName("in")
	@Export("npcCount")
	static int npcCount;
	@ObfuscatedName("ih")
	@Export("npcIndices")
	static int[] npcIndices;
	@ObfuscatedName("it")
	static String field599;
	@ObfuscatedName("ir")
	static int field451;
	@ObfuscatedName("ic")
	static int[] field552;
	@ObfuscatedName("ia")
	@ObfuscatedSignature(
		descriptor = "Ler;"
	)
	@Export("packetWriter")
	public static final PacketWriter packetWriter;
	@ObfuscatedName("im")
	@Export("logoutTimer")
	static int logoutTimer;
	@ObfuscatedName("id")
	@Export("hadNetworkError")
	static boolean hadNetworkError;
	@ObfuscatedName("iu")
	@ObfuscatedSignature(
		descriptor = "Lpy;"
	)
	@Export("timer")
	static Timer timer;
	@ObfuscatedName("jn")
	@Export("fontsMap")
	static HashMap fontsMap;
	@ObfuscatedName("jg")
	static int field452;
	@ObfuscatedName("ji")
	static int field453;
	@ObfuscatedName("jl")
	static int field455;
	@ObfuscatedName("jj")
	static int field454;
	@ObfuscatedName("jq")
	static int field456;
	@ObfuscatedName("jz")
	@ObfuscatedSignature(
		descriptor = "[Lis;"
	)
	@Export("collisionMaps")
	static CollisionMap[] collisionMaps;
	@ObfuscatedName("jp")
	@Export("isInInstance")
	static boolean isInInstance;
	@ObfuscatedName("jf")
	@Export("instanceChunkTemplates")
	static int[][][] instanceChunkTemplates;
	@ObfuscatedName("jm")
	static final int[] field653;
	@ObfuscatedName("kb")
	static int field457;
	@ObfuscatedName("kt")
	@ObfuscatedSignature(
		descriptor = "Lui;"
	)
	@Export("compass")
	static SpritePixels compass;
	@ObfuscatedName("kx")
	static int field462;
	@ObfuscatedName("ky")
	static int field463;
	@ObfuscatedName("kp")
	static int field459;
	@ObfuscatedName("kr")
	static int field460;
	@ObfuscatedName("kw")
	static boolean field382;
	@ObfuscatedName("kv")
	@Export("alternativeScrollbarWidth")
	static int alternativeScrollbarWidth;
	@ObfuscatedName("kg")
	@Export("camAngleX")
	static int camAngleX;
	@ObfuscatedName("lx")
	@Export("camAngleY")
	static int camAngleY;
	@ObfuscatedName("le")
	@Export("camAngleDY")
	static int camAngleDY;
	@ObfuscatedName("lu")
	@Export("camAngleDX")
	static int camAngleDX;
	@ObfuscatedName("lo")
	static int field473;
	@ObfuscatedName("ld")
	static int field465;
	@ObfuscatedName("lm")
	@Export("oculusOrbState")
	static int oculusOrbState;
	@ObfuscatedName("lp")
	@Export("camFollowHeight")
	static int camFollowHeight;
	@ObfuscatedName("ly")
	static int field480;
	@ObfuscatedName("lg")
	static int field468;
	@ObfuscatedName("lk")
	static int field471;
	@ObfuscatedName("lc")
	@Export("oculusOrbNormalSpeed")
	static int oculusOrbNormalSpeed;
	@ObfuscatedName("lv")
	@Export("oculusOrbSlowedSpeed")
	static int oculusOrbSlowedSpeed;
	@ObfuscatedName("lr")
	static int field476;
	@ObfuscatedName("lt")
	@Export("oculusOrbOnLocalPlayer")
	static boolean oculusOrbOnLocalPlayer;
	@ObfuscatedName("lj")
	@Export("packetIndicator")
	static int packetIndicator;
	@ObfuscatedName("lz")
	@Export("emitPackets")
	static boolean emitPackets;
	@ObfuscatedName("lf")
	static int field467;
	@ObfuscatedName("lq")
	@Export("overheadTextLimit")
	static int overheadTextLimit;
	@ObfuscatedName("lh")
	@Export("overheadTextCount")
	static int overheadTextCount;
	@ObfuscatedName("li")
	@Export("overheadTextXs")
	static int[] overheadTextXs;
	@ObfuscatedName("ll")
	@Export("overheadTextYs")
	static int[] overheadTextYs;
	@ObfuscatedName("lb")
	@Export("overheadTextAscents")
	static int[] overheadTextAscents;
	@ObfuscatedName("md")
	@Export("overheadTextXOffsets")
	static int[] overheadTextXOffsets;
	@ObfuscatedName("mh")
	@Export("overheadTextColors")
	static int[] overheadTextColors;
	@ObfuscatedName("mv")
	@Export("overheadTextEffects")
	static int[] overheadTextEffects;
	@ObfuscatedName("mg")
	static int[][] field594;
	@ObfuscatedName("mq")
	@Export("overheadTextCyclesRemaining")
	static int[] overheadTextCyclesRemaining;
	@ObfuscatedName("mu")
	static String[] field603;
	@ObfuscatedName("mk")
	@Export("tileLastDrawnActor")
	static int[][] tileLastDrawnActor;
	@ObfuscatedName("mr")
	@Export("viewportDrawCount")
	static int viewportDrawCount;
	@ObfuscatedName("me")
	@Export("viewportTempX")
	static int viewportTempX;
	@ObfuscatedName("mz")
	@Export("viewportTempY")
	static int viewportTempY;
	@ObfuscatedName("mc")
	@Export("mouseCrossX")
	static int mouseCrossX;
	@ObfuscatedName("mf")
	@Export("mouseCrossY")
	static int mouseCrossY;
	@ObfuscatedName("ml")
	@Export("mouseCrossState")
	static int mouseCrossState;
	@ObfuscatedName("mj")
	@Export("mouseCrossColor")
	static int mouseCrossColor;
	@ObfuscatedName("mw")
	@Export("showMouseCross")
	static boolean showMouseCross;
	@ObfuscatedName("mp")
	static int field486;
	@ObfuscatedName("mb")
	@Export("showLoadingMessages")
	static boolean showLoadingMessages;
	@ObfuscatedName("mi")
	@ObfuscatedSignature(
		descriptor = "[Ldf;"
	)
	@Export("players")
	static Player[] players;
	@ObfuscatedName("mx")
	@Export("localPlayerIndex")
	static int localPlayerIndex;
	@ObfuscatedName("my")
	@Export("isMembers")
	static int isMembers;
	@ObfuscatedName("ma")
	@Export("playerUUID")
	static long playerUUID;
	@ObfuscatedName("ms")
	static boolean field386;
	@ObfuscatedName("nd")
	@Export("drawPlayerNames")
	static int drawPlayerNames;
	@ObfuscatedName("ng")
	static int field492;
	@ObfuscatedName("nt")
	static int[] field564;
	@ObfuscatedName("nb")
	@Export("playerMenuOpcodes")
	static final int[] playerMenuOpcodes;
	@ObfuscatedName("ns")
	@Export("playerMenuActions")
	static String[] playerMenuActions;
	@ObfuscatedName("nz")
	@Export("playerOptionsPriorities")
	static boolean[] playerOptionsPriorities;
	@ObfuscatedName("ne")
	static int[] field561;
	@ObfuscatedName("ni")
	@Export("combatTargetPlayerIndex")
	static int combatTargetPlayerIndex;
	@ObfuscatedName("nr")
	@ObfuscatedSignature(
		descriptor = "[[[Low;"
	)
	@Export("groundItems")
	static NodeDeque[][][] groundItems;
	@ObfuscatedName("np")
	@ObfuscatedSignature(
		descriptor = "Low;"
	)
	@Export("pendingSpawns")
	static NodeDeque pendingSpawns;
	@ObfuscatedName("nn")
	@ObfuscatedSignature(
		descriptor = "Low;"
	)
	@Export("projectiles")
	static NodeDeque projectiles;
	@ObfuscatedName("nw")
	@ObfuscatedSignature(
		descriptor = "Low;"
	)
	@Export("graphicsObjects")
	static NodeDeque graphicsObjects;
	@ObfuscatedName("ny")
	@Export("currentLevels")
	static int[] currentLevels;
	@ObfuscatedName("nk")
	@Export("levels")
	static int[] levels;
	@ObfuscatedName("nj")
	@Export("experience")
	static int[] experience;
	@ObfuscatedName("nu")
	@Export("leftClickOpensMenu")
	static boolean leftClickOpensMenu;
	@ObfuscatedName("nf")
	@Export("isMenuOpen")
	static boolean isMenuOpen;
	@ObfuscatedName("om")
	@Export("menuOptionsCount")
	static int menuOptionsCount;
	@ObfuscatedName("oz")
	@Export("menuArguments1")
	static int[] menuArguments1;
	@ObfuscatedName("oh")
	@Export("menuArguments2")
	static int[] menuArguments2;
	@ObfuscatedName("oy")
	@Export("menuOpcodes")
	static int[] menuOpcodes;
	@ObfuscatedName("od")
	@Export("menuIdentifiers")
	static int[] menuIdentifiers;
	@ObfuscatedName("og")
	@Export("menuItemIds")
	static int[] menuItemIds;
	@ObfuscatedName("ob")
	@Export("menuActions")
	static String[] menuActions;
	@ObfuscatedName("ok")
	@Export("menuTargets")
	static String[] menuTargets;
	@ObfuscatedName("on")
	@Export("menuShiftClick")
	static boolean[] menuShiftClick;
	@ObfuscatedName("oe")
	@Export("followerOpsLowPriority")
	static boolean followerOpsLowPriority;
	@ObfuscatedName("os")
	@Export("tapToDrop")
	static boolean tapToDrop;
	@ObfuscatedName("ow")
	@Export("showMouseOverText")
	static boolean showMouseOverText;
	@ObfuscatedName("ot")
	@Export("viewportX")
	static int viewportX;
	@ObfuscatedName("oc")
	@Export("viewportY")
	static int viewportY;
	@ObfuscatedName("oi")
	static int field496;
	@ObfuscatedName("oq")
	static int field498;
	@ObfuscatedName("ov")
	@Export("isItemSelected")
	static int isItemSelected;
	@ObfuscatedName("or")
	@Export("isSpellSelected")
	static boolean isSpellSelected;
	@ObfuscatedName("of")
	@Export("selectedSpellChildIndex")
	static int selectedSpellChildIndex;
	@ObfuscatedName("ps")
	@Export("selectedSpellItemId")
	static int selectedSpellItemId;
	@ObfuscatedName("pa")
	static String field600;
	@ObfuscatedName("pi")
	static String field601;
	@ObfuscatedName("pj")
	@Export("rootInterface")
	static int rootInterface;
	@ObfuscatedName("pu")
	@ObfuscatedSignature(
		descriptor = "Lso;"
	)
	@Export("interfaceParents")
	static NodeHashTable interfaceParents;
	@ObfuscatedName("po")
	static int field505;
	@ObfuscatedName("pv")
	static int field508;
	@ObfuscatedName("pn")
	@Export("chatEffects")
	static int chatEffects;
	@ObfuscatedName("pd")
	@ObfuscatedSignature(
		descriptor = "Lmi;"
	)
	@Export("meslayerContinueWidget")
	static Widget meslayerContinueWidget;
	@ObfuscatedName("px")
	@Export("runEnergy")
	static int runEnergy;
	@ObfuscatedName("pt")
	@Export("weight")
	static int weight;
	@ObfuscatedName("pm")
	@Export("staffModLevel")
	public static int staffModLevel;
	@ObfuscatedName("pe")
	@Export("followerIndex")
	static int followerIndex;
	@ObfuscatedName("pp")
	@Export("playerMod")
	static boolean playerMod;
	@ObfuscatedName("pg")
	@ObfuscatedSignature(
		descriptor = "Lmi;"
	)
	@Export("viewportWidget")
	static Widget viewportWidget;
	@ObfuscatedName("ph")
	@ObfuscatedSignature(
		descriptor = "Lmi;"
	)
	@Export("clickedWidget")
	public static Widget clickedWidget;
	@ObfuscatedName("pb")
	@ObfuscatedSignature(
		descriptor = "Lmi;"
	)
	@Export("clickedWidgetParent")
	static Widget clickedWidgetParent;
	@ObfuscatedName("pc")
	@Export("widgetClickX")
	static int widgetClickX;
	@ObfuscatedName("py")
	@Export("widgetClickY")
	static int widgetClickY;
	@ObfuscatedName("pq")
	@ObfuscatedSignature(
		descriptor = "Lmi;"
	)
	@Export("draggedOnWidget")
	static Widget draggedOnWidget;
	@ObfuscatedName("pw")
	static boolean field395;
	@ObfuscatedName("qe")
	static int field514;
	@ObfuscatedName("qd")
	static int field513;
	@ObfuscatedName("qn")
	static boolean field397;
	@ObfuscatedName("qf")
	static int field515;
	@ObfuscatedName("qr")
	static int field521;
	@ObfuscatedName("qm")
	@Export("isDraggingWidget")
	static boolean isDraggingWidget;
	@ObfuscatedName("ql")
	@Export("cycleCntr")
	static int cycleCntr;
	@ObfuscatedName("qo")
	@Export("changedVarps")
	static int[] changedVarps;
	@ObfuscatedName("qg")
	@Export("changedVarpCount")
	static int changedVarpCount;
	@ObfuscatedName("qx")
	@Export("changedItemContainers")
	static int[] changedItemContainers;
	@ObfuscatedName("qs")
	@Export("changedItemContainersCount")
	static int changedItemContainersCount;
	@ObfuscatedName("qz")
	@Export("changedSkills")
	static int[] changedSkills;
	@ObfuscatedName("qt")
	@Export("changedSkillsCount")
	static int changedSkillsCount;
	@ObfuscatedName("qu")
	static int[] field572;
	@ObfuscatedName("qb")
	static int field512;
	@ObfuscatedName("qp")
	@Export("chatCycle")
	static int chatCycle;
	@ObfuscatedName("qi")
	static int field518;
	@ObfuscatedName("qy")
	static int field524;
	@ObfuscatedName("qa")
	static int field511;
	@ObfuscatedName("qh")
	static int field517;
	@ObfuscatedName("ru")
	static int field529;
	@ObfuscatedName("rh")
	static int field525;
	@ObfuscatedName("rr")
	static int field528;
	@ObfuscatedName("rz")
	@Export("mouseWheelRotation")
	static int mouseWheelRotation;
	@ObfuscatedName("rm")
	@ObfuscatedSignature(
		descriptor = "Luo;"
	)
	static class532 field651;
	@ObfuscatedName("rc")
	@ObfuscatedSignature(
		descriptor = "Low;"
	)
	@Export("scriptEvents")
	static NodeDeque scriptEvents;
	@ObfuscatedName("rq")
	@ObfuscatedSignature(
		descriptor = "Low;"
	)
	static NodeDeque field629;
	@ObfuscatedName("rs")
	@ObfuscatedSignature(
		descriptor = "Low;"
	)
	static NodeDeque field630;
	@ObfuscatedName("rp")
	@ObfuscatedSignature(
		descriptor = "Low;"
	)
	static NodeDeque field628;
	@ObfuscatedName("rg")
	@ObfuscatedSignature(
		descriptor = "Lso;"
	)
	@Export("widgetFlags")
	static NodeHashTable widgetFlags;
	@ObfuscatedName("ry")
	@Export("rootWidgetCount")
	static int rootWidgetCount;
	@ObfuscatedName("rk")
	static int field527;
	@ObfuscatedName("re")
	static boolean[] field407;
	@ObfuscatedName("rf")
	static boolean[] field408;
	@ObfuscatedName("rl")
	static boolean[] field409;
	@ObfuscatedName("rt")
	@Export("rootWidgetXs")
	static int[] rootWidgetXs;
	@ObfuscatedName("rx")
	@Export("rootWidgetYs")
	static int[] rootWidgetYs;
	@ObfuscatedName("rw")
	@Export("rootWidgetWidths")
	static int[] rootWidgetWidths;
	@ObfuscatedName("rn")
	@Export("rootWidgetHeights")
	static int[] rootWidgetHeights;
	@ObfuscatedName("ri")
	@Export("gameDrawingMode")
	static int gameDrawingMode;
	@ObfuscatedName("sq")
	static long field615;
	@ObfuscatedName("sd")
	@Export("isResizable")
	static boolean isResizable;
	@ObfuscatedName("se")
	static int[] field579;
	@ObfuscatedName("sk")
	@Export("publicChatMode")
	static int publicChatMode;
	@ObfuscatedName("sn")
	@Export("tradeChatMode")
	static int tradeChatMode;
	@ObfuscatedName("sc")
	static String field602;
	@ObfuscatedName("si")
	static long[] crossWorldMessageIds;
	@ObfuscatedName("sr")
	static int crossWorldMessageIdsIndex;
	@ObfuscatedName("sp")
	@ObfuscatedSignature(
		descriptor = "Liz;"
	)
	@Export("keyHandlerInstance")
	static class212 keyHandlerInstance;
	@ObfuscatedName("ss")
	@ObfuscatedSignature(
		descriptor = "Lig;"
	)
	static class210 field423;
	@ObfuscatedName("sf")
	static int field532;
	@ObfuscatedName("so")
	static int[] field580;
	@ObfuscatedName("su")
	static int[] field581;
	@ObfuscatedName("sx")
	@Export("timeOfPreviousKeyPress")
	static long timeOfPreviousKeyPress;
	@ObfuscatedName("tu")
	@ObfuscatedSignature(
		descriptor = "[Lfi;"
	)
	@Export("currentClanSettings")
	static ClanSettings[] currentClanSettings;
	@ObfuscatedName("tn")
	@ObfuscatedSignature(
		descriptor = "[Lgo;"
	)
	@Export("currentClanChannels")
	static ClanChannel[] currentClanChannels;
	@ObfuscatedName("tj")
	static int field538;
	@ObfuscatedName("tl")
	@Export("mapIconCount")
	static int mapIconCount;
	@ObfuscatedName("tq")
	@Export("mapIconXs")
	static int[] mapIconXs;
	@ObfuscatedName("tg")
	@Export("mapIconYs")
	static int[] mapIconYs;
	@ObfuscatedName("tb")
	@ObfuscatedSignature(
		descriptor = "[Lui;"
	)
	@Export("mapIcons")
	static SpritePixels[] mapIcons;
	@ObfuscatedName("tz")
	@Export("destinationX")
	static int destinationX;
	@ObfuscatedName("ti")
	@Export("destinationY")
	static int destinationY;
	@ObfuscatedName("ta")
	@Export("minimapState")
	static int minimapState;
	@ObfuscatedName("tp")
	@Export("playingJingle")
	static boolean playingJingle;
	@ObfuscatedName("tt")
	@Export("soundEffectCount")
	static int soundEffectCount;
	@ObfuscatedName("tf")
	@Export("soundEffectIds")
	static int[] soundEffectIds;
	@ObfuscatedName("tv")
	@Export("queuedSoundEffectLoops")
	static int[] queuedSoundEffectLoops;
	@ObfuscatedName("ua")
	@Export("queuedSoundEffectDelays")
	static int[] queuedSoundEffectDelays;
	@ObfuscatedName("uj")
	@Export("soundLocations")
	static int[] soundLocations;
	@ObfuscatedName("uu")
	@ObfuscatedSignature(
		descriptor = "[Lbp;"
	)
	@Export("soundEffects")
	static SoundEffect[] soundEffects;
	@ObfuscatedName("ut")
	@Export("isCameraLocked")
	static boolean isCameraLocked;
	@ObfuscatedName("ur")
	static boolean field402;
	@ObfuscatedName("ux")
	static boolean field404;
	@ObfuscatedName("uo")
	static boolean field401;
	@ObfuscatedName("uv")
	@ObfuscatedSignature(
		descriptor = "Lsn;"
	)
	static class479 field642;
	@ObfuscatedName("ue")
	@ObfuscatedSignature(
		descriptor = "Lsy;"
	)
	static class478 field646;
	@ObfuscatedName("uy")
	@ObfuscatedSignature(
		descriptor = "Lsy;"
	)
	static class478 field647;
	@ObfuscatedName("gz")
	String field665;
	@ObfuscatedName("gn")
	@ObfuscatedSignature(
		descriptor = "Lar;"
	)
	class14 field658;
	@ObfuscatedName("ht")
	@ObfuscatedSignature(
		descriptor = "Lax;"
	)
	class18 field660;
	@ObfuscatedName("ho")
	@ObfuscatedSignature(
		descriptor = "Lcom/jagex/oldscape/pub/OtlTokenRequester;"
	)
	OtlTokenRequester field662;
	@ObfuscatedName("hj")
	Future field666;
	@ObfuscatedName("hh")
	boolean field661;
	@ObfuscatedName("hi")
	int field664;
	@ObfuscatedName("hd")
	@ObfuscatedSignature(
		descriptor = "Lax;"
	)
	class18 field659;
	@ObfuscatedName("hk")
	@ObfuscatedSignature(
		descriptor = "Lcom/jagex/oldscape/pub/RefreshAccessTokenRequester;"
	)
	RefreshAccessTokenRequester field663;
	@ObfuscatedName("hz")
	Future field667;
	@ObfuscatedName("ib")
	@ObfuscatedSignature(
		descriptor = "Ltm;"
	)
	Buffer field669;
	@ObfuscatedName("il")
	@ObfuscatedSignature(
		descriptor = "Lap;"
	)
	class7 field657;
	@ObfuscatedName("ig")
	long field668;

	static {
		lockMouseRecorder = true;
		worldId = 1;
		worldProperties = 0;
		gameBuild = 0;
		isMembersWorld = false;
		isLowDetail = false;
		param21 = -1;
		clientType = -1;
		field424 = -1;
		onMobile = false;
		param25 = 216;
		gameState = 0;
		reloadJS5 = false;
		isLoading = true;
		cycle = 0;
		mouseLastLastPressedTimeMillis = -1L;
		lastMouseRecordX = -1;
		lastMouseRecordY = -1;
		field612 = -1L;
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
		field419 = class92.field940;
		js5ConnectState = 0;
		js5Cycles = 0;
		js5Errors = 0;
		loginState = 0;
		field448 = 0;
		field447 = 0;
		field444 = 0;
		field421 = class139.field1320;
		field648 = class519.field4205;
		int var2 = "com_jagex_auth_desktop_osrs:public".length();
		byte[] var3 = new byte[var2];

		int var4;
		char var5;
		for (var4 = 0; var4 < var2; ++var4) {
			var5 = "com_jagex_auth_desktop_osrs:public".charAt(var4);
			if (var5 > 127) {
				var3[var4] = 63;
			} else {
				var3[var4] = (byte)var5;
			}
		}

		String var0 = class11.method32(var3, 0, var3.length);
		field656 = var0;
		var2 = "com_jagex_auth_desktop_runelite:public".length();
		var3 = new byte[var2];

		for (var4 = 0; var4 < var2; ++var4) {
			var5 = "com_jagex_auth_desktop_runelite:public".charAt(var4);
			if (var5 > 127) {
				var3[var4] = 63;
			} else {
				var3[var4] = (byte)var5;
			}
		}

		var0 = class11.method32(var3, 0, var3.length);
		field655 = var0;
		Login_isUsernameRemembered = false;
		secureRandomFuture = new SecureRandomFuture();
		randomDatData = null;
		npcs = new NPC[65536];
		npcCount = 0;
		npcIndices = new int[65536];
		field451 = 0;
		field552 = new int[250];
		packetWriter = new PacketWriter();
		logoutTimer = 0;
		hadNetworkError = false;
		timer = new Timer();
		fontsMap = new HashMap();
		field452 = 0;
		field453 = 1;
		field455 = 0;
		field454 = 1;
		field456 = 0;
		collisionMaps = new CollisionMap[4];
		isInInstance = false;
		instanceChunkTemplates = new int[4][13][13];
		field653 = new int[]{0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3};
		field457 = 0;
		field462 = 2301979;
		field463 = 5063219;
		field459 = 3353893;
		field460 = 7759444;
		field382 = false;
		alternativeScrollbarWidth = 0;
		camAngleX = 128;
		camAngleY = 0;
		camAngleDY = 0;
		camAngleDX = 0;
		field473 = 0;
		field465 = 0;
		oculusOrbState = 0;
		camFollowHeight = 50;
		field480 = 0;
		field468 = 0;
		field471 = 0;
		oculusOrbNormalSpeed = 12;
		oculusOrbSlowedSpeed = 6;
		field476 = 0;
		oculusOrbOnLocalPlayer = false;
		packetIndicator = 0;
		emitPackets = false;
		field467 = 0;
		overheadTextLimit = 0;
		overheadTextCount = 50;
		overheadTextXs = new int[overheadTextCount];
		overheadTextYs = new int[overheadTextCount];
		overheadTextAscents = new int[overheadTextCount];
		overheadTextXOffsets = new int[overheadTextCount];
		overheadTextColors = new int[overheadTextCount];
		overheadTextEffects = new int[overheadTextCount];
		field594 = new int[overheadTextCount][];
		overheadTextCyclesRemaining = new int[overheadTextCount];
		field603 = new String[overheadTextCount];
		tileLastDrawnActor = new int[104][104];
		viewportDrawCount = 0;
		viewportTempX = -1;
		viewportTempY = -1;
		mouseCrossX = 0;
		mouseCrossY = 0;
		mouseCrossState = 0;
		mouseCrossColor = 0;
		showMouseCross = true;
		field486 = 0;
		showLoadingMessages = true;
		players = new Player[2048];
		localPlayerIndex = -1;
		isMembers = 0;
		playerUUID = -1L;
		field386 = true;
		drawPlayerNames = 0;
		field492 = 0;
		field564 = new int[1000];
		playerMenuOpcodes = new int[]{44, 45, 46, 47, 48, 49, 50, 51};
		playerMenuActions = new String[8];
		playerOptionsPriorities = new boolean[8];
		field561 = new int[]{768, 1024, 1280, 512, 1536, 256, 0, 1792};
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
		field496 = 0;
		field498 = 50;
		isItemSelected = 0;
		field599 = null;
		isSpellSelected = false;
		selectedSpellChildIndex = -1;
		selectedSpellItemId = -1;
		field600 = null;
		field601 = null;
		rootInterface = -1;
		interfaceParents = new NodeHashTable(8);
		field505 = 0;
		field508 = -1;
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
		field395 = false;
		field514 = -1;
		field513 = -1;
		field397 = false;
		field515 = -1;
		field521 = -1;
		isDraggingWidget = false;
		cycleCntr = 1;
		changedVarps = new int[32];
		changedVarpCount = 0;
		changedItemContainers = new int[32];
		changedItemContainersCount = 0;
		changedSkills = new int[32];
		changedSkillsCount = 0;
		field572 = new int[32];
		field512 = 0;
		chatCycle = 0;
		field518 = 0;
		field524 = 0;
		field511 = 0;
		field517 = 0;
		field529 = 0;
		field525 = 0;
		field528 = 0;
		mouseWheelRotation = 0;
		field651 = new class532();
		scriptEvents = new NodeDeque();
		field629 = new NodeDeque();
		field630 = new NodeDeque();
		field628 = new NodeDeque();
		widgetFlags = new NodeHashTable(512);
		rootWidgetCount = 0;
		field527 = -2;
		field407 = new boolean[100];
		field408 = new boolean[100];
		field409 = new boolean[100];
		rootWidgetXs = new int[100];
		rootWidgetYs = new int[100];
		rootWidgetWidths = new int[100];
		rootWidgetHeights = new int[100];
		gameDrawingMode = 0;
		field615 = 0L;
		isResizable = true;
		field579 = new int[]{16776960, 16711680, 65280, 65535, 16711935, 16777215};
		publicChatMode = 0;
		tradeChatMode = 0;
		field602 = "";
		crossWorldMessageIds = new long[100];
		crossWorldMessageIdsIndex = 0;
		keyHandlerInstance = new class212();
		field423 = new class210();
		field532 = 0;
		field580 = new int[128];
		field581 = new int[128];
		timeOfPreviousKeyPress = -1L;
		currentClanSettings = new ClanSettings[4];
		currentClanChannels = new ClanChannel[4];
		field538 = -1;
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
		field404 = false;
		field401 = false;
		field642 = null;
		field646 = null;
		field647 = null;
		field400 = false;
		cameraShaking = new boolean[5];
		cameraShakeIntensity = new int[5];
		cameraMoveIntensity = new int[5];
		cameraShakeSpeed = new int[5];
		cameraShakeCycle = new int[5];
		field638 = 256;
		field640 = 205;
		zoomHeight = 256;
		zoomWidth = 320;
		field635 = 1;
		field634 = 32767;
		field641 = 1;
		field637 = 32767;
		viewportOffsetX = 0;
		viewportOffsetY = 0;
		viewportWidth = 0;
		viewportHeight = 0;
		viewportZoom = 0;
		playerAppearance = new PlayerComposition();
		field542 = -1;
		field547 = -1;
		field645 = new DesktopPlatformInfoProvider();
		grandExchangeOffers = new GrandExchangeOffer[8];
		GrandExchangeEvents_worldComparator = new GrandExchangeOfferOwnWorldComparator();
		archive5 = new class423(8, class421.field3766);
		Widget_cachedModels = new EvictingDualNodeHashTable(64);
		Widget_cachedFonts = new EvictingDualNodeHashTable(64);
		field549 = -1;
		field369 = -1;
		field609 = new ArrayList();
		archiveLoaders = new ArrayList(10);
		archiveLoadersDone = 0;
		field550 = 0;
		field652 = new ApproximateRouteStrategy();
		field593 = new int[50];
		field592 = new int[50];
	}

	public Client() {
		this.field661 = false;
		this.field664 = 0;
		this.field668 = -1L;
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "59"
	)
	@Export("resizeGame")
	protected final void resizeGame() {
		field615 = GameEngine.clockNow() + 500L;
		this.resizeJS();
		if (rootInterface != -1) {
			this.resizeRoot(true);
		}

	}

	@ObfuscatedName("by")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "208117174"
	)
	@Export("setUp")
	protected final void setUp() {
		PacketBufferNode.method1611(new int[]{20, 260, 10000}, new int[]{1000, 100, 500});
		class480.worldPort = gameBuild == 0 ? 43594 : worldId + 40000;
		class129.js5Port = gameBuild == 0 ? 443 : worldId + 50000;
		class4.currentPort = class480.worldPort;
		UrlRequest.field1174 = class330.field2941;
		class140.field1328 = class330.field2942;
		PlayerComposition.field2904 = class330.field2940;
		PlayerComposition.field2905 = class330.field2943;
		FriendsChat.urlRequester = new class113(this.field661, 216);
		this.setUpKeyboard();
		this.method143();
		class12.mouseWheel = this.mouseWheel();
		this.method142(field423, 0);
		this.method142(keyHandlerInstance, 1);
		class6.masterDisk = new ArchiveDisk(255, JagexCache.JagexCache_dat2File, JagexCache.JagexCache_idx255File, 500000);
		AccessFile var2 = null;
		ClientPreferences var3 = new ClientPreferences();

		try {
			var2 = Decimator.getPreferencesFile("", WorldMapSectionType.field2417.name, false);
			byte[] var4 = new byte[(int)var2.length()];

			int var6;
			for (int var5 = 0; var5 < var4.length; var5 += var6) {
				var6 = var2.read(var4, var5, var4.length - var5);
				if (var6 == -1) {
					throw new IOException();
				}
			}

			var3 = new ClientPreferences(new Buffer(var4));
		} catch (Exception var8) {
		}

		try {
			if (var2 != null) {
				var2.close();
			}
		} catch (Exception var7) {
		}

		class449.clientPreferences = var3;
		this.setUpClipboard();
		KeyHandler.method85(this, class18.field50);
		class270.setWindowedMode(class449.clientPreferences.method566());
		class299.friendSystem = new FriendSystem(Language.loginType);
		this.field658 = new class14("tokenRequest", 1, 1);
		if (!class305.field2778.contains(this)) {
			class305.field2778.add(this);
		}

		class218.field1926 = new class216[1];
		class214 var9 = class214.field1898;
		class218.field1926[0] = new class216(var9.field1907, var9.field1908);
	}

	@ObfuscatedName("bs")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "1753601126"
	)
	@Export("doCycle")
	protected final void doCycle() {
		++cycle;
		this.doCycleJs5();

		while (true) {
			ArchiveDiskAction var1;
			synchronized(ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue) {
				var1 = (ArchiveDiskAction)ArchiveDiskActionHandler.ArchiveDiskActionHandler_responseQueue.removeLast();
			}

			if (var1 == null) {
				boolean var5 = WorldMapArea.method1425();
				if (var5 && playingJingle && AddRequestTask.pcmPlayer1 != null) {
					AddRequestTask.pcmPlayer1.tryDiscard();
				}

				class301.method1622();
				keyHandlerInstance.method1104();
				this.method141();
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

				if (class12.mouseWheel != null) {
					int var6 = class12.mouseWheel.useRotation();
					mouseWheelRotation = var6;
				}

				if (gameState == 0) {
					ParamComposition.method1017();
					PacketWriter.method645();
				} else if (gameState == 5) {
					GrandExchangeOfferWorldComparator.method1950(this, HealthBarUpdate.fontPlain11, SecureRandomCallable.fontPlain12);
					ParamComposition.method1017();
					PacketWriter.method645();
				} else if (gameState != 10 && gameState != 11) {
					if (gameState == 20) {
						GrandExchangeOfferWorldComparator.method1950(this, HealthBarUpdate.fontPlain11, SecureRandomCallable.fontPlain12);
						this.doCycleLoggedOut();
					} else if (gameState == 50) {
						GrandExchangeOfferWorldComparator.method1950(this, HealthBarUpdate.fontPlain11, SecureRandomCallable.fontPlain12);
						this.doCycleLoggedOut();
					} else if (gameState == 25) {
						class370.method1968();
					}
				} else {
					GrandExchangeOfferWorldComparator.method1950(this, HealthBarUpdate.fontPlain11, SecureRandomCallable.fontPlain12);
				}

				if (gameState == 30) {
					this.doCycleLoggedIn();
				} else if (gameState == 40 || gameState == 45) {
					this.doCycleLoggedOut();
				}

				return;
			}

			var1.archive.load(var1.archiveDisk, (int)var1.key, var1.data, false);
		}
	}

	@ObfuscatedName("bm")
	@ObfuscatedSignature(
		descriptor = "(ZI)V",
		garbageValue = "-1944984067"
	)
	@Export("draw")
	protected final void draw(boolean var1) {
		if ((gameState == 10 || gameState == 20 || gameState == 30) && 0L != field615 && GameEngine.clockNow() > field615) {
			class270.setWindowedMode(class218.getWindowedMode());
		}

		int var2;
		if (var1) {
			for (var2 = 0; var2 < 100; ++var2) {
				field407[var2] = true;
			}
		}

		if (gameState == 0) {
			this.drawInitial(Login.Login_loadingPercent, Login.Login_loadingText, var1);
		} else if (gameState == 5) {
			class105.drawTitle(class59.fontBold12, HealthBarUpdate.fontPlain11, SecureRandomCallable.fontPlain12);
		} else if (gameState != 10 && gameState != 11) {
			if (gameState == 20) {
				class105.drawTitle(class59.fontBold12, HealthBarUpdate.fontPlain11, SecureRandomCallable.fontPlain12);
			} else if (gameState == 50) {
				class105.drawTitle(class59.fontBold12, HealthBarUpdate.fontPlain11, SecureRandomCallable.fontPlain12);
			} else if (gameState == 25) {
				if (field456 == 1) {
					if (field452 > field453) {
						field453 = field452;
					}

					var2 = (field453 * 50 - field452 * 50) / field453;
					FadeInTask.drawLoadingMessage("Loading - please wait." + "<br>" + " (" + var2 + "%" + ")", false);
				} else if (field456 == 2) {
					if (field455 > field454) {
						field454 = field455;
					}

					var2 = (field454 * 50 - field455 * 50) / field454 + 50;
					FadeInTask.drawLoadingMessage("Loading - please wait." + "<br>" + " (" + var2 + "%" + ")", false);
				} else {
					FadeInTask.drawLoadingMessage("Loading - please wait.", false);
				}
			} else if (gameState == 30) {
				this.drawLoggedIn();
			} else if (gameState == 40) {
				FadeInTask.drawLoadingMessage("Connection lost" + "<br>" + "Please wait - attempting to reestablish", false);
			} else if (gameState == 45) {
				FadeInTask.drawLoadingMessage("Please wait...", false);
			}
		} else {
			class105.drawTitle(class59.fontBold12, HealthBarUpdate.fontPlain11, SecureRandomCallable.fontPlain12);
		}

		if (gameState == 30 && gameDrawingMode == 0 && !var1 && !isResizable) {
			for (var2 = 0; var2 < rootWidgetCount; ++var2) {
				if (field408[var2]) {
					AttackOption.rasterProvider.draw(rootWidgetXs[var2], rootWidgetYs[var2], rootWidgetWidths[var2], rootWidgetHeights[var2]);
					field408[var2] = false;
				}
			}
		} else if (gameState > 0) {
			AttackOption.rasterProvider.drawFull(0, 0);

			for (var2 = 0; var2 < rootWidgetCount; ++var2) {
				field408[var2] = false;
			}
		}

	}

	@ObfuscatedName("bf")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-1298916795"
	)
	@Export("kill0")
	protected final void kill0() {
		if (KeyHandler.varcs.hasUnwrittenChanges()) {
			KeyHandler.varcs.write();
		}

		if (class126.mouseRecorder != null) {
			class126.mouseRecorder.isRunning = false;
		}

		class126.mouseRecorder = null;
		packetWriter.close();
		if (MouseHandler.MouseHandler_instance != null) {
			synchronized(MouseHandler.MouseHandler_instance) {
				MouseHandler.MouseHandler_instance = null;
			}
		}

		class12.mouseWheel = null;
		if (AddRequestTask.pcmPlayer1 != null) {
			AddRequestTask.pcmPlayer1.shutdown();
		}

		class308.field2819.method1940();
		class214.method1124();
		if (FriendsChat.urlRequester != null) {
			FriendsChat.urlRequester.close();
			FriendsChat.urlRequester = null;
		}

		class510.method2513();
		this.field658.method40();
	}

	@ObfuscatedName("br")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "1929688897"
	)
	@Export("vmethod1485")
	protected final void vmethod1485() {
	}

	@ObfuscatedName("gx")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "920896355"
	)
	boolean method351() {
		return this.field664 == 1;
	}

	@ObfuscatedName("gq")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "-1597201922"
	)
	boolean method352() {
		return class27.field76 != null && !class27.field76.trim().isEmpty() && class9.field20 != null && !class9.field20.trim().isEmpty();
	}

	@ObfuscatedName("gt")
	@ObfuscatedSignature(
		descriptor = "(B)Z",
		garbageValue = "106"
	)
	boolean method353() {
		return class157.field1407 != null && !class157.field1407.trim().isEmpty() && Varcs.field1140 != null && !Varcs.field1140.trim().isEmpty();
	}

	@ObfuscatedName("gr")
	@ObfuscatedSignature(
		descriptor = "(B)Z",
		garbageValue = "13"
	)
	boolean method354() {
		return this.field662 != null;
	}

	@ObfuscatedName("gz")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;I)V",
		garbageValue = "1881627729"
	)
	void method355(String var1) throws IOException {
		HashMap var2 = new HashMap();
		var2.put("grant_type", "refresh_token");
		var2.put("scope", "gamesso.token.create");
		var2.put("refresh_token", var1);
		URL var3 = new URL(class510.field4133 + "shield/oauth/token" + (new class463(var2)).method2342());
		class419 var4 = new class419();
		if (this.method351()) {
			var4.method2169(field655);
		} else {
			var4.method2169(field656);
		}

		var4.method2166("Host", (new URL(class510.field4133)).getHost());
		var4.method2173(class460.field3901);
		class9 var5 = class9.field18;
		RefreshAccessTokenRequester var6 = this.field663;
		if (var6 != null) {
			this.field667 = var6.request(var5.method22(), var3, var4.method2165(), "");
		} else {
			class10 var7 = new class10(var3, var5, var4, this.field661);
			this.field659 = this.field658.method38(var7);
		}
	}

	@ObfuscatedName("gn")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;B)V",
		garbageValue = "1"
	)
	void method356(String var1) throws IOException {
		URL var2 = new URL(class510.field4133 + "public/v1/games/YCfdbvr2pM1zUYMxJRexZY/play");
		class419 var3 = new class419();
		var3.method2170(var1);
		class9 var4 = class9.field17;
		OtlTokenRequester var5 = this.field662;
		if (var5 != null) {
			this.field666 = var5.request(var4.method22(), var2, var3.method2165(), "");
		} else {
			class10 var6 = new class10(var2, var4, var3, this.field661);
			this.field660 = this.field658.method38(var6);
		}
	}

	@ObfuscatedName("ht")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;Ljava/lang/String;I)V",
		garbageValue = "1347426796"
	)
	void method358(String var1, String var2) throws IOException, JSONException {
		URL var3 = new URL(class510.field4133 + "game-session/v1/tokens");
		class10 var4 = new class10(var3, class9.field18, this.field661);
		var4.method27().method2170(var1);
		var4.method27().method2173(class460.field3901);
		JSONObject var5 = new JSONObject();
		var5.method2709("accountId", var2);
		var4.method28(new class462(var5));
		this.field660 = this.field658.method38(var4);
	}

	@ObfuscatedName("hd")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "286321361"
	)
	@Export("doCycleJs5")
	void doCycleJs5() {
		if (gameState != 1000) {
			boolean var1 = class308.field2819.method1930();
			if (!var1) {
				this.method364();
			}

		}
	}

	@ObfuscatedName("hk")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "375037576"
	)
	void method364() {
		if (class308.field2819.field3570 >= 4) {
			this.error("js5crc");
			MusicSong.updateGameState(1000);
		} else {
			if (class308.field2819.field3569 >= 4) {
				if (gameState <= 5) {
					this.error("js5io");
					MusicSong.updateGameState(1000);
					return;
				}

				js5Cycles = 3000;
				class308.field2819.field3569 = 3;
			}

			if (--js5Cycles + 1 <= 0) {
				try {
					if (js5ConnectState == 0) {
						class126.js5SocketTask = GameEngine.taskHandler.newSocketTask(class292.worldHost, class4.currentPort);
						++js5ConnectState;
					}

					if (js5ConnectState == 1) {
						if (class126.js5SocketTask.status == 2) {
							this.js5Error(-1);
							return;
						}

						if (class126.js5SocketTask.status == 1) {
							++js5ConnectState;
						}
					}

					if (js5ConnectState == 2) {
						Socket var2 = (Socket)class126.js5SocketTask.result;
						BufferedNetSocket var1 = new BufferedNetSocket(var2, 40000, 5000);
						class59.js5Socket = var1;
						Buffer var3 = new Buffer(5);
						var3.writeByte(15);
						var3.writeInt(216);
						class59.js5Socket.write(var3.array, 0, 5);
						++js5ConnectState;
						class270.field2451 = GameEngine.clockNow();
					}

					if (js5ConnectState == 3) {
						if (class59.js5Socket.available() > 0) {
							int var4 = class59.js5Socket.readUnsignedByte();
							if (var4 != 0) {
								this.js5Error(var4);
								return;
							}

							++js5ConnectState;
						} else if (GameEngine.clockNow() - class270.field2451 > 30000L) {
							this.js5Error(-2);
							return;
						}
					}

					if (js5ConnectState == 4) {
						class308.field2819.method1933(class59.js5Socket, gameState > 20);
						class126.js5SocketTask = null;
						class59.js5Socket = null;
						js5ConnectState = 0;
						js5Errors = 0;
					}
				} catch (IOException var5) {
					this.js5Error(-3);
				}

			}
		}
	}

	@ObfuscatedName("hz")
	@ObfuscatedSignature(
		descriptor = "(IB)V",
		garbageValue = "17"
	)
	@Export("js5Error")
	void js5Error(int var1) {
		class126.js5SocketTask = null;
		class59.js5Socket = null;
		js5ConnectState = 0;
		if (class4.currentPort == class480.worldPort) {
			class4.currentPort = class129.js5Port;
		} else {
			class4.currentPort = class480.worldPort;
		}

		++js5Errors;
		if (js5Errors < 2 || var1 != 7 && var1 != 9) {
			if (js5Errors >= 2 && var1 == 6) {
				this.error("js5connect_outofdate");
				MusicSong.updateGameState(1000);
			} else if (js5Errors >= 4) {
				if (gameState <= 5) {
					this.error("js5connect");
					MusicSong.updateGameState(1000);
				} else {
					js5Cycles = 3000;
				}
			}
		} else if (gameState <= 5) {
			this.error("js5connect_full");
			MusicSong.updateGameState(1000);
		} else {
			js5Cycles = 3000;
		}

	}

	@ObfuscatedName("hy")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "70"
	)
	@Export("doCycleLoggedOut")
	final void doCycleLoggedOut() {
		Object var1 = packetWriter.getSocket();
		PacketBuffer var2 = packetWriter.packetBuffer;

		try {
			if (loginState == 0) {
				if (GraphicsObject.secureRandom == null && (secureRandomFuture.isDone() || field448 > 250)) {
					GraphicsObject.secureRandom = secureRandomFuture.get();
					secureRandomFuture.shutdown();
					secureRandomFuture = null;
				}

				if (GraphicsObject.secureRandom != null) {
					if (var1 != null) {
						((AbstractSocket)var1).close();
						var1 = null;
					}

					VarcInt.socketTask = null;
					hadNetworkError = false;
					field448 = 0;
					if (field648.method2616()) {
						if (this.method352()) {
							try {
								this.method355(class9.field20);
								class316.method1700(21);
							} catch (Throwable var25) {
								Messages.RunException_sendStackTrace((String)null, var25);
								class387.getLoginError(65);
								return;
							}
						} else {
							if (!this.method353()) {
								class387.getLoginError(65);
								return;
							}

							try {
								this.method358(class157.field1407, Varcs.field1140);
								class316.method1700(20);
							} catch (Exception var24) {
								Messages.RunException_sendStackTrace((String)null, var24);
								class387.getLoginError(65);
								return;
							}
						}
					} else {
						class316.method1700(1);
					}
				}
			}

			class20 var27;
			if (loginState == 21) {
				if (this.field667 != null) {
					if (!this.field667.isDone()) {
						return;
					}

					if (this.field667.isCancelled()) {
						class387.getLoginError(65);
						this.field667 = null;
						return;
					}

					try {
						RefreshAccessTokenResponse var3 = (RefreshAccessTokenResponse)this.field667.get();
						if (!var3.isSuccess()) {
							class387.getLoginError(65);
							this.field667 = null;
							return;
						}

						class27.field76 = var3.getAccessToken();
						class9.field20 = var3.getRefreshToken();
						this.field667 = null;
					} catch (Exception var23) {
						Messages.RunException_sendStackTrace((String)null, var23);
						class387.getLoginError(65);
						this.field667 = null;
						return;
					}
				} else {
					if (this.field659 == null) {
						class387.getLoginError(65);
						return;
					}

					if (!this.field659.method54()) {
						return;
					}

					if (this.field659.method53()) {
						Messages.RunException_sendStackTrace(this.field659.method52(), (Throwable)null);
						class387.getLoginError(65);
						this.field659 = null;
						return;
					}

					var27 = this.field659.method55();
					if (var27.method63() != 200) {
						class387.getLoginError(65);
						this.field659 = null;
						return;
					}

					field448 = 0;
					class462 var4 = new class462(var27.method66());

					try {
						class27.field76 = var4.method2338().getString("access_token");
						class9.field20 = var4.method2338().getString("refresh_token");
					} catch (Exception var22) {
						Messages.RunException_sendStackTrace("Error parsing tokens", var22);
						class387.getLoginError(65);
						this.field659 = null;
						return;
					}
				}

				this.method356(class27.field76);
				class316.method1700(20);
			}

			if (loginState == 20) {
				if (this.field666 != null) {
					if (!this.field666.isDone()) {
						return;
					}

					if (this.field666.isCancelled()) {
						class387.getLoginError(65);
						this.field666 = null;
						return;
					}

					try {
						OtlTokenResponse var28 = (OtlTokenResponse)this.field666.get();
						if (!var28.isSuccess()) {
							class387.getLoginError(65);
							this.field666 = null;
							return;
						}

						this.field665 = var28.getToken();
						this.field666 = null;
					} catch (Exception var21) {
						Messages.RunException_sendStackTrace((String)null, var21);
						class387.getLoginError(65);
						this.field666 = null;
						return;
					}
				} else {
					if (this.field660 == null) {
						class387.getLoginError(65);
						return;
					}

					if (!this.field660.method54()) {
						return;
					}

					if (this.field660.method53()) {
						Messages.RunException_sendStackTrace(this.field660.method52(), (Throwable)null);
						class387.getLoginError(65);
						this.field660 = null;
						return;
					}

					var27 = this.field660.method55();
					if (var27.method63() != 200) {
						Messages.RunException_sendStackTrace("Response code: " + var27.method63() + "Response body: " + var27.method66(), (Throwable)null);
						class387.getLoginError(65);
						this.field660 = null;
						return;
					}

					List var30 = (List)var27.method65().get("Content-Type");
					if (var30 != null && var30.contains(class460.field3901.method2331())) {
						try {
							JSONObject var5 = new JSONObject(var27.method66());
							this.field665 = var5.getString("token");
						} catch (JSONException var20) {
							Messages.RunException_sendStackTrace((String)null, var20);
							class387.getLoginError(65);
							this.field660 = null;
							return;
						}
					} else {
						this.field665 = var27.method66();
					}

					this.field660 = null;
				}

				field448 = 0;
				class316.method1700(1);
			}

			if (loginState == 1) {
				if (VarcInt.socketTask == null) {
					VarcInt.socketTask = GameEngine.taskHandler.newSocketTask(class292.worldHost, class4.currentPort);
				}

				if (VarcInt.socketTask.status == 2) {
					throw new IOException();
				}

				if (VarcInt.socketTask.status == 1) {
					Socket var31 = (Socket)VarcInt.socketTask.result;
					BufferedNetSocket var29 = new BufferedNetSocket(var31, 40000, 5000);
					var1 = var29;
					packetWriter.setSocket(var29);
					VarcInt.socketTask = null;
					class316.method1700(2);
				}
			}

			PacketBufferNode var33;
			if (loginState == 2) {
				packetWriter.clearBuffer();
				var33 = class146.method779();
				var33.clientPacket = null;
				var33.clientPacketLength = 0;
				var33.packetBuffer = new PacketBuffer(5000);
				var33.packetBuffer.writeByte(LoginPacket.field2746.id);
				packetWriter.addNode(var33);
				packetWriter.flush();
				var2.offset = 0;
				class316.method1700(3);
			}

			int var13;
			if (loginState == 3) {
				if (AddRequestTask.pcmPlayer1 != null) {
					AddRequestTask.pcmPlayer1.method200();
				}

				if (((AbstractSocket)var1).isAvailable(1)) {
					var13 = ((AbstractSocket)var1).readUnsignedByte();
					if (AddRequestTask.pcmPlayer1 != null) {
						AddRequestTask.pcmPlayer1.method200();
					}

					if (var13 != 0) {
						class387.getLoginError(var13);
						return;
					}

					var2.offset = 0;
					class316.method1700(4);
				}
			}

			if (loginState == 4) {
				if (var2.offset < 8) {
					var13 = ((AbstractSocket)var1).available();
					if (var13 > 8 - var2.offset) {
						var13 = 8 - var2.offset;
					}

					if (var13 > 0) {
						((AbstractSocket)var1).read(var2.array, var2.offset, var13);
						var2.offset += var13;
					}
				}

				if (var2.offset == 8) {
					var2.offset = 0;
					class125.field1195 = var2.readLong();
					class316.method1700(5);
				}
			}

			if (loginState == 5) {
				packetWriter.packetBuffer.offset = 0;
				packetWriter.clearBuffer();
				PacketBuffer var32 = new PacketBuffer(500);
				int[] var35 = new int[]{GraphicsObject.secureRandom.nextInt(), GraphicsObject.secureRandom.nextInt(), GraphicsObject.secureRandom.nextInt(), GraphicsObject.secureRandom.nextInt()};
				var32.offset = 0;
				var32.writeByte(1);
				var32.writeInt(var35[0]);
				var32.writeInt(var35[1]);
				var32.writeInt(var35[2]);
				var32.writeInt(var35[3]);
				var32.writeLong(class125.field1195);
				if (gameState == 40) {
					var32.writeInt(NewShit.field1577[0]);
					var32.writeInt(NewShit.field1577[1]);
					var32.writeInt(NewShit.field1577[2]);
					var32.writeInt(NewShit.field1577[3]);
				} else {
					if (gameState == 50) {
						var32.writeByte(class139.field1318.rsOrdinal());
						var32.writeInt(class72.field730);
					} else {
						var32.writeByte(field421.rsOrdinal());
						switch(field421.field1327) {
						case 0:
							var32.writeInt(class449.clientPreferences.method569(Login.Login_username));
						case 1:
						default:
							break;
						case 2:
						case 4:
							var32.writeMedium(class503.field4107);
							++var32.offset;
							break;
						case 3:
							var32.offset += 4;
						}
					}

					if (field648.method2616()) {
						var32.writeByte(class519.field4204.rsOrdinal());
						var32.writeStringCp1252NullTerminated(this.field665);
					} else {
						var32.writeByte(class519.field4205.rsOrdinal());
						var32.writeStringCp1252NullTerminated(Login.Login_password);
					}
				}

				var32.encryptRsa(class74.field742, class74.field741);
				NewShit.field1577 = var35;
				PacketBufferNode var6 = class146.method779();
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
				var6.packetBuffer.writeInt(216);
				var6.packetBuffer.writeInt(1);
				var6.packetBuffer.writeByte(clientType);
				var6.packetBuffer.writeByte(field424);
				byte var8 = 0;
				var6.packetBuffer.writeByte(var8);
				var6.packetBuffer.writeBytes(var32.array, 0, var32.offset);
				int var9 = var6.packetBuffer.offset;
				var6.packetBuffer.writeStringCp1252NullTerminated(Login.Login_username);
				var6.packetBuffer.writeByte((isResizable ? 1 : 0) << 1 | (isLowDetail ? 1 : 0));
				var6.packetBuffer.writeShort(class113.canvasWidth);
				var6.packetBuffer.writeShort(class177.canvasHeight);
				class177.method919(var6.packetBuffer);
				var6.packetBuffer.writeStringCp1252NullTerminated(MusicPatchPcmStream.param9);
				var6.packetBuffer.writeInt(WorldMapSectionType.field2416);
				if (param25 > 213) {
					var6.packetBuffer.writeByte(0);
				}

				Buffer var10 = new Buffer(class18.field51.size());
				class18.field51.write(var10);
				var6.packetBuffer.writeBytes(var10.array, 0, var10.array.length);
				var6.packetBuffer.writeByte(clientType);
				var6.packetBuffer.writeInt(0);
				var6.packetBuffer.writeIntLE(class499.archive9.hash);
				var6.packetBuffer.writeIntLE(Tiles.field838.hash);
				var6.packetBuffer.writeIntLE(class106.field1107.hash);
				var6.packetBuffer.writeIntLE(class147.field1348.hash);
				var6.packetBuffer.writeIntLE(class388.field3655.hash);
				var6.packetBuffer.writeIntIME(ObjectSound.archive4.hash);
				var6.packetBuffer.writeInt(class227.field2040.hash);
				var6.packetBuffer.writeIntIME_(class28.field81.hash);
				var6.packetBuffer.writeInt(AttackOption.field1096.hash);
				var6.packetBuffer.writeIntLE(class10.field28.hash);
				var6.packetBuffer.writeIntLE(0);
				var6.packetBuffer.writeIntIME(ClanChannelMember.field1339.hash);
				var6.packetBuffer.writeIntLE(Player.archive13.hash);
				var6.packetBuffer.writeIntIME_(class141.archive10.hash);
				var6.packetBuffer.writeIntLE(class1.archive2.hash);
				var6.packetBuffer.writeIntIME(class318.archive7.hash);
				var6.packetBuffer.writeIntIME_(class385.archive6.hash);
				var6.packetBuffer.writeInt(WorldMapElement.field1509.hash);
				var6.packetBuffer.writeIntIME_(Message.archive11.hash);
				var6.packetBuffer.writeIntIME(PcmPlayer.archive8.hash);
				var6.packetBuffer.writeInt(GrandExchangeOffer.archive12.hash);
				var6.packetBuffer.xteaEncrypt(var35, var9, var6.packetBuffer.offset);
				var6.packetBuffer.writeLengthShort(var6.packetBuffer.offset - var7);
				packetWriter.addNode(var6);
				packetWriter.flush();
				packetWriter.isaacCipher = new IsaacCipher(var35);
				int[] var11 = new int[4];

				for (int var12 = 0; var12 < 4; ++var12) {
					var11[var12] = var35[var12] + 50;
				}

				var2.newIsaacCipher(var11);
				class316.method1700(6);
			}

			int var14;
			if (loginState == 6 && ((AbstractSocket)var1).available() > 0) {
				var13 = ((AbstractSocket)var1).readUnsignedByte();
				if (var13 == 61) {
					var14 = ((AbstractSocket)var1).available();
					ModeWhere.field3613 = var14 == 1 && ((AbstractSocket)var1).readUnsignedByte() == 1;
					class316.method1700(5);
				}

				if (var13 == 21 && gameState == 20) {
					class316.method1700(12);
				} else if (var13 == 2) {
					class316.method1700(14);
				} else if (var13 == 15 && gameState == 40) {
					packetWriter.serverPacketLength = -1;
					class316.method1700(19);
				} else if (var13 == 64) {
					class316.method1700(10);
				} else if (var13 == 23 && field447 < 1) {
					++field447;
					class316.method1700(0);
				} else if (var13 == 29) {
					class316.method1700(17);
				} else {
					if (var13 != 69) {
						class387.getLoginError(var13);
						return;
					}

					class316.method1700(7);
				}
			}

			if (loginState == 7 && ((AbstractSocket)var1).available() >= 2) {
				((AbstractSocket)var1).read(var2.array, 0, 2);
				var2.offset = 0;
				class12.field37 = var2.readUnsignedShort();
				class316.method1700(8);
			}

			if (loginState == 8 && ((AbstractSocket)var1).available() >= class12.field37) {
				var2.offset = 0;
				((AbstractSocket)var1).read(var2.array, var2.offset, class12.field37);
				class6 var34 = class303.method1624()[var2.readUnsignedByte()];

				try {
					switch(var34.field8) {
					case 0:
						class0 var38 = new class0();
						this.field657 = new class7(var2, var38);
						class316.method1700(9);
						break;
					default:
						throw new IllegalArgumentException();
					}
				} catch (Exception var19) {
					class387.getLoginError(22);
					return;
				}
			}

			if (loginState == 9 && this.field657.method14()) {
				this.field669 = this.field657.method16();
				this.field657.method15();
				this.field657 = null;
				if (this.field669 == null) {
					class387.getLoginError(22);
					return;
				}

				packetWriter.clearBuffer();
				var33 = class146.method779();
				var33.clientPacket = null;
				var33.clientPacketLength = 0;
				var33.packetBuffer = new PacketBuffer(5000);
				var33.packetBuffer.writeByte(LoginPacket.field2743.id);
				var33.packetBuffer.writeShort(this.field669.offset);
				var33.packetBuffer.method2537(this.field669);
				packetWriter.addNode(var33);
				packetWriter.flush();
				this.field669 = null;
				class316.method1700(6);
			}

			if (loginState == 10 && ((AbstractSocket)var1).available() > 0) {
				KeyHandler.field69 = ((AbstractSocket)var1).readUnsignedByte();
				class316.method1700(11);
			}

			if (loginState == 11 && ((AbstractSocket)var1).available() >= KeyHandler.field69) {
				((AbstractSocket)var1).read(var2.array, 0, KeyHandler.field69);
				var2.offset = 0;
				class316.method1700(6);
			}

			if (loginState == 12 && ((AbstractSocket)var1).available() > 0) {
				field444 = (((AbstractSocket)var1).readUnsignedByte() + 3) * 60;
				class316.method1700(13);
			}

			if (loginState == 13) {
				field448 = 0;
				class318.setLoginResponseString("You have only just left another world.", "Your profile will be transferred in:", field444 / 60 + " seconds.");
				if (--field444 <= 0) {
					class316.method1700(0);
				}

			} else {
				if (loginState == 14 && ((AbstractSocket)var1).available() >= 1) {
					class398.playerUUIDLength = ((AbstractSocket)var1).readUnsignedByte();
					class316.method1700(15);
				}

				if (loginState == 15 && ((AbstractSocket)var1).available() >= class398.playerUUIDLength) {
					boolean var44 = ((AbstractSocket)var1).readUnsignedByte() == 1;
					((AbstractSocket)var1).read(var2.array, 0, 4);
					var2.offset = 0;
					boolean var43 = false;
					if (var44) {
						var14 = var2.readByteIsaac() << 24;
						var14 |= var2.readByteIsaac() << 16;
						var14 |= var2.readByteIsaac() << 8;
						var14 |= var2.readByteIsaac();
						class449.clientPreferences.method567(Login.Login_username, var14);
					}

					if (Login_isUsernameRemembered) {
						class449.clientPreferences.setUsernameToRemember(Login.Login_username);
					} else {
						class449.clientPreferences.setUsernameToRemember((String)null);
					}

					class338.savePreferences();
					staffModLevel = ((AbstractSocket)var1).readUnsignedByte();
					playerMod = ((AbstractSocket)var1).readUnsignedByte() == 1;
					localPlayerIndex = ((AbstractSocket)var1).readUnsignedByte();
					localPlayerIndex <<= 8;
					localPlayerIndex += ((AbstractSocket)var1).readUnsignedByte();
					isMembers = ((AbstractSocket)var1).readUnsignedByte();
					((AbstractSocket)var1).read(var2.array, 0, 8);
					var2.offset = 0;
					this.field668 = var2.readLong();
					((AbstractSocket)var1).read(var2.array, 0, 8);
					var2.offset = 0;
					playerUUID = var2.readLong();
					if (param25 >= 214) {
						((AbstractSocket)var1).read(var2.array, 0, 8);
						var2.offset = 0;
						var2.readLong();
					}

					((AbstractSocket)var1).read(var2.array, 0, 1);
					var2.offset = 0;
					ServerPacket[] var36 = class176.method916();
					int var15 = var2.readSmartByteShortIsaac();
					if (var15 < 0 || var15 >= var36.length) {
						throw new IOException(var15 + " " + var2.offset);
					}

					packetWriter.serverPacket = var36[var15];
					packetWriter.serverPacketLength = packetWriter.serverPacket.length;
					((AbstractSocket)var1).read(var2.array, 0, 2);
					var2.offset = 0;
					packetWriter.serverPacketLength = var2.readUnsignedShort();

					try {
						Client var16 = class219.client;
						JSObject.getWindow(var16).call("zap", (Object[])null);
					} catch (Throwable var18) {
					}

					class316.method1700(16);
				}

				if (loginState != 16) {
					if (loginState == 17 && ((AbstractSocket)var1).available() >= 2) {
						var2.offset = 0;
						((AbstractSocket)var1).read(var2.array, 0, 2);
						var2.offset = 0;
						class342.field3146 = var2.readUnsignedShort();
						class316.method1700(18);
					}

					if (loginState == 18 && ((AbstractSocket)var1).available() >= class342.field3146) {
						var2.offset = 0;
						((AbstractSocket)var1).read(var2.array, 0, class342.field3146);
						var2.offset = 0;
						String var40 = var2.readStringCp1252NullTerminated();
						String var42 = var2.readStringCp1252NullTerminated();
						String var39 = var2.readStringCp1252NullTerminated();
						class318.setLoginResponseString(var40, var42, var39);
						MusicSong.updateGameState(10);
						if (field648.method2616()) {
							PcmPlayer.method212(9);
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
							var13 = packetWriter.serverPacketLength;
							timer.method2155();
							class105.method615();
							Actor.updatePlayer(var2);
							if (var13 != var2.offset) {
								throw new RuntimeException();
							}
						}
					} else {
						++field448;
						if (field448 > 2000) {
							if (field447 < 1) {
								if (class480.worldPort == class4.currentPort) {
									class4.currentPort = class129.js5Port;
								} else {
									class4.currentPort = class480.worldPort;
								}

								++field447;
								class316.method1700(0);
							} else {
								class387.getLoginError(-3);
							}
						}
					}
				} else {
					if (((AbstractSocket)var1).available() >= packetWriter.serverPacketLength) {
						var2.offset = 0;
						((AbstractSocket)var1).read(var2.array, 0, packetWriter.serverPacketLength);
						timer.method2153();
						mouseLastLastPressedTimeMillis = -1L;
						class126.mouseRecorder.index = 0;
						class370.hasFocus = true;
						hadFocus = true;
						timeOfPreviousKeyPress = -1L;
						GrandExchangeOfferTotalQuantityComparator.method1943();
						packetWriter.clearBuffer();
						packetWriter.packetBuffer.offset = 0;
						packetWriter.serverPacket = null;
						packetWriter.field1159 = null;
						packetWriter.field1157 = null;
						packetWriter.field1158 = null;
						packetWriter.serverPacketLength = 0;
						packetWriter.field1154 = 0;
						rebootTimer = 0;
						logoutTimer = 0;
						hintArrowType = 0;
						Frames.method1297();
						class20.method64(0);
						ChatChannel.method451();
						isItemSelected = 0;
						isSpellSelected = false;
						soundEffectCount = 0;
						camAngleY = 0;
						oculusOrbState = 0;
						class390.field3656 = null;
						minimapState = 0;
						field538 = -1;
						destinationX = 0;
						destinationY = 0;
						playerAttackOption = AttackOption.AttackOption_hidden;
						npcAttackOption = AttackOption.AttackOption_hidden;
						npcCount = 0;
						Players.Players_count = 0;

						for (var13 = 0; var13 < 2048; ++var13) {
							Players.cachedAppearanceBuffer[var13] = null;
							Players.playerMovementSpeeds[var13] = MoveSpeed.WALK;
						}

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
						class299.friendSystem.clear();

						for (var13 = 0; var13 < VarpDefinition.field1498; ++var13) {
							VarpDefinition var41 = ApproximateRouteStrategy.VarpDefinition_get(var13);
							if (var41 != null) {
								Varps.Varps_temp[var13] = 0;
								Varps.Varps_main[var13] = 0;
							}
						}

						KeyHandler.varcs.clearTransient();
						followerIndex = -1;
						if (rootInterface != -1) {
							Skeleton.method1232(rootInterface);
						}

						for (InterfaceParent var37 = (InterfaceParent)interfaceParents.first(); var37 != null; var37 = (InterfaceParent)interfaceParents.next()) {
							class92.closeInterface(var37, true);
						}

						rootInterface = -1;
						interfaceParents = new NodeHashTable(8);
						meslayerContinueWidget = null;
						Frames.method1297();
						playerAppearance.method1718((int[])null, (int[])null, new int[]{0, 0, 0, 0, 0}, 0, -1);

						for (var13 = 0; var13 < 8; ++var13) {
							playerMenuActions[var13] = null;
							playerOptionsPriorities[var13] = false;
						}

						LoginPacket.method1614();
						isLoading = true;

						for (var13 = 0; var13 < 100; ++var13) {
							field407[var13] = true;
						}

						Message.method341();
						ReflectionCheck.friendsChat = null;
						Players.guestClanSettings = null;
						Arrays.fill(currentClanSettings, (Object)null);
						VerticalAlignment.guestClanChannel = null;
						Arrays.fill(currentClanChannels, (Object)null);

						for (var13 = 0; var13 < 8; ++var13) {
							grandExchangeOffers[var13] = new GrandExchangeOffer();
						}

						class392.grandExchangeEvents = null;
						reloadJS5 = false;
						Actor.updatePlayer(var2);
						Tiles.timeOfPreviousKeyPress = -1;
						class271.loadRegions(false, var2);
						packetWriter.serverPacket = null;
					}

				}
			}
		} catch (IOException var26) {
			if (field447 < 1) {
				if (class480.worldPort == class4.currentPort) {
					class4.currentPort = class129.js5Port;
				} else {
					class4.currentPort = class480.worldPort;
				}

				++field447;
				class316.method1700(0);
			} else {
				class387.getLoginError(-2);
			}
		}
	}

	@ObfuscatedName("hv")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-1704146678"
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
			Renderable.method1291();
		} else {
			if (!isMenuOpen) {
				class349.addCancelMenuEntry();
			}

			int var1;
			for (var1 = 0; var1 < 100 && this.method374(packetWriter); ++var1) {
			}

			if (gameState == 30) {
				while (true) {
					ReflectionCheck var2 = (ReflectionCheck)class36.reflectionChecks.last();
					boolean var29;
					if (var2 == null) {
						var29 = false;
					} else {
						var29 = true;
					}

					int var3;
					PacketBufferNode var30;
					if (!var29) {
						PacketBufferNode var14;
						int var15;
						if (timer.field3756) {
							var14 = ApproximateRouteStrategy.getPacketBufferNode(ClientPacket.LOGIN_STATISTICS, packetWriter.isaacCipher);
							var14.packetBuffer.writeByte(0);
							var15 = var14.packetBuffer.offset;
							timer.write(var14.packetBuffer);
							var14.packetBuffer.method2540(var14.packetBuffer.offset - var15);
							packetWriter.addNode(var14);
							timer.method2154();
						}

						int var4;
						int var5;
						synchronized(class126.mouseRecorder.lock) {
							if (!lockMouseRecorder) {
								class126.mouseRecorder.index = 0;
							} else if (MouseHandler.MouseHandler_lastButton != 0 || class126.mouseRecorder.index >= 40) {
								var30 = null;
								var3 = 0;
								var4 = 0;
								var5 = 0;
								int var6 = 0;

								int var7;
								for (var7 = 0; var7 < class126.mouseRecorder.index && (var30 == null || var30.packetBuffer.offset - var3 < 246); ++var7) {
									var4 = var7;
									int var8 = class126.mouseRecorder.ys[var7];
									if (var8 < -1) {
										var8 = -1;
									} else if (var8 > 65534) {
										var8 = 65534;
									}

									int var9 = class126.mouseRecorder.xs[var7];
									if (var9 < -1) {
										var9 = -1;
									} else if (var9 > 65534) {
										var9 = 65534;
									}

									if (var9 != lastMouseRecordX || var8 != lastMouseRecordY) {
										if (var30 == null) {
											var30 = ApproximateRouteStrategy.getPacketBufferNode(ClientPacket.notsure, packetWriter.isaacCipher);
											var30.packetBuffer.writeByte(0);
											var3 = var30.packetBuffer.offset;
											PacketBuffer var10000 = var30.packetBuffer;
											var10000.offset += 2;
											var5 = 0;
											var6 = 0;
										}

										int var10;
										int var11;
										int var12;
										if (field612 != -1L) {
											var10 = var9 - lastMouseRecordX;
											var11 = var8 - lastMouseRecordY;
											var12 = (int)((class126.mouseRecorder.millis[var7] - field612) / 20L);
											var5 = (int)((long)var5 + (class126.mouseRecorder.millis[var7] - field612) % 20L);
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
											var30.packetBuffer.writeShort((var12 << 12) + var11 + (var10 << 6));
										} else if (var12 < 32 && var10 >= -128 && var10 <= 127 && var11 >= -128 && var11 <= 127) {
											var10 += 128;
											var11 += 128;
											var30.packetBuffer.writeByte(var12 + 128);
											var30.packetBuffer.writeShort(var11 + (var10 << 8));
										} else if (var12 < 32) {
											var30.packetBuffer.writeByte(var12 + 192);
											if (var9 != -1 && var8 != -1) {
												var30.packetBuffer.writeInt(var9 | var8 << 16);
											} else {
												var30.packetBuffer.writeInt(Integer.MIN_VALUE);
											}
										} else {
											var30.packetBuffer.writeShort((var12 & 8191) + 57344);
											if (var9 != -1 && var8 != -1) {
												var30.packetBuffer.writeInt(var9 | var8 << 16);
											} else {
												var30.packetBuffer.writeInt(Integer.MIN_VALUE);
											}
										}

										++var6;
										field612 = class126.mouseRecorder.millis[var7];
									}
								}

								if (var30 != null) {
									var30.packetBuffer.method2540(var30.packetBuffer.offset - var3);
									var7 = var30.packetBuffer.offset;
									var30.packetBuffer.offset = var3;
									var30.packetBuffer.writeByte(var5 / var6);
									var30.packetBuffer.writeByte(var5 % var6);
									var30.packetBuffer.offset = var7;
									packetWriter.addNode(var30);
								}

								if (var4 >= class126.mouseRecorder.index) {
									class126.mouseRecorder.index = 0;
								} else {
									MouseRecorder var43 = class126.mouseRecorder;
									var43.index -= var4;
									System.arraycopy(class126.mouseRecorder.xs, var4, class126.mouseRecorder.xs, 0, class126.mouseRecorder.index);
									System.arraycopy(class126.mouseRecorder.ys, var4, class126.mouseRecorder.ys, 0, class126.mouseRecorder.index);
									System.arraycopy(class126.mouseRecorder.millis, var4, class126.mouseRecorder.millis, 0, class126.mouseRecorder.index);
								}
							}
						}

						PacketBufferNode var18;
						if (MouseHandler.MouseHandler_lastButton == 1 || !ObjTypeCustomisation.mouseCam && MouseHandler.MouseHandler_lastButton == 4 || MouseHandler.MouseHandler_lastButton == 2) {
							long var16 = MouseHandler.MouseHandler_lastPressedTimeMillis - mouseLastLastPressedTimeMillis;
							if (var16 > 32767L) {
								var16 = 32767L;
							}

							mouseLastLastPressedTimeMillis = MouseHandler.MouseHandler_lastPressedTimeMillis;
							var3 = MouseHandler.MouseHandler_lastPressedY;
							if (var3 < 0) {
								var3 = 0;
							} else if (var3 > class177.canvasHeight) {
								var3 = class177.canvasHeight;
							}

							var4 = MouseHandler.MouseHandler_lastPressedX;
							if (var4 < 0) {
								var4 = 0;
							} else if (var4 > class113.canvasWidth) {
								var4 = class113.canvasWidth;
							}

							var5 = (int)var16;
							if (shouldProcessClick()) {
								var18 = ApproximateRouteStrategy.getPacketBufferNode(ClientPacket.EVENT_MOUSE_CLICK, packetWriter.isaacCipher);
								var18.packetBuffer.writeShort((MouseHandler.MouseHandler_lastButton == 2 ? 1 : 0) + (var5 << 1));
								var18.packetBuffer.writeShort(var4);
								var18.packetBuffer.writeShort(var3);
								packetWriter.addNode(var18);
							}
						}

						if (mouseWheelRotation != 0) {
							var14 = ApproximateRouteStrategy.getPacketBufferNode(ClientPacket.EVENT_MOUSE_SCROLl, packetWriter.isaacCipher);
							var14.packetBuffer.writeShort(mouseWheelRotation);
							packetWriter.addNode(var14);
						}

						if (keyHandlerInstance.pressedKeysCount > 0) {
							var14 = ApproximateRouteStrategy.getPacketBufferNode(ClientPacket.EVENT_KEYBOARD, packetWriter.isaacCipher);
							var14.packetBuffer.writeShort(0);
							var15 = var14.packetBuffer.offset;
							long var19 = GameEngine.clockNow();

							for (var5 = 0; var5 < keyHandlerInstance.pressedKeysCount; ++var5) {
								long var21 = var19 - timeOfPreviousKeyPress;
								if (var21 > 16777215L) {
									var21 = 16777215L;
								}

								timeOfPreviousKeyPress = var19;
								var14.packetBuffer.writeByteNeg(keyHandlerInstance.field1892[var5]);
								var14.packetBuffer.writeMediumLE((int)var21);
							}

							var14.packetBuffer.writeLengthShort(var14.packetBuffer.offset - var15);
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
							var14 = ApproximateRouteStrategy.getPacketBufferNode(ClientPacket.EVENT_CAMERA_POSITION, packetWriter.isaacCipher);
							var14.packetBuffer.writeShort(camAngleY);
							var14.packetBuffer.writeShortAddLE(camAngleX);
							packetWriter.addNode(var14);
						}

						if (class370.hasFocus && !hadFocus) {
							hadFocus = true;
							var14 = ApproximateRouteStrategy.getPacketBufferNode(ClientPacket.EVENT_APPLET_FOCUS, packetWriter.isaacCipher);
							var14.packetBuffer.writeByte(1);
							packetWriter.addNode(var14);
						}

						if (!class370.hasFocus && hadFocus) {
							hadFocus = false;
							var14 = ApproximateRouteStrategy.getPacketBufferNode(ClientPacket.EVENT_APPLET_FOCUS, packetWriter.isaacCipher);
							var14.packetBuffer.writeByte(0);
							packetWriter.addNode(var14);
						}

						if (Canvas.worldMap != null) {
							Canvas.worldMap.method2384();
						}

						if (SpotAnimationDefinition.ClanChat_inClanChat) {
							if (ReflectionCheck.friendsChat != null) {
								ReflectionCheck.friendsChat.sort();
							}

							for (var1 = 0; var1 < Players.Players_count; ++var1) {
								Player var31 = players[Players.Players_indices[var1]];
								var31.clearIsInFriendsChat();
							}

							SpotAnimationDefinition.ClanChat_inClanChat = false;
						}

						AddRequestTask.method2124();
						class164.method864();
						if (gameState != 30) {
							return;
						}

						Ignored.method2249();
						Canvas.method77();
						++packetWriter.field1154;
						if (packetWriter.field1154 > 750) {
							Renderable.method1291();
							return;
						}

						var1 = Players.Players_count;
						int[] var32 = Players.Players_indices;

						for (var3 = 0; var3 < var1; ++var3) {
							Player var23 = players[var32[var3]];
							if (var23 != null) {
								class318.updateActorSequence(var23, 1);
							}
						}

						for (var1 = 0; var1 < npcCount; ++var1) {
							var15 = npcIndices[var1];
							NPC var24 = npcs[var15];
							if (var24 != null) {
								class318.updateActorSequence(var24, var24.definition.size);
							}
						}

						WorldMapManager.method1482();
						++field457;
						if (mouseCrossColor != 0) {
							mouseCrossState += 20;
							if (mouseCrossState >= 400) {
								mouseCrossColor = 0;
							}
						}

						Widget var35 = class146.mousedOverWidgetIf1;
						Widget var33 = class343.field3147;
						class146.mousedOverWidgetIf1 = null;
						class343.field3147 = null;
						draggedOnWidget = null;
						field397 = false;
						field395 = false;
						field532 = 0;

						while (keyHandlerInstance.method1105() && field532 < 128) {
							if (staffModLevel >= 2 && keyHandlerInstance.getKeyPressed(82) && keyHandlerInstance.field1890 == 66) {
								StringBuilder var38 = new StringBuilder();

								Message var36;
								for (Iterator var25 = Messages.Messages_hashTable.iterator(); var25.hasNext(); var38.append(var36.text).append('\n')) {
									var36 = (Message)var25.next();
									if (var36.sender != null && !var36.sender.isEmpty()) {
										var38.append(var36.sender).append(':');
									}
								}

								String var40 = var38.toString();
								class219.client.method138(var40);
							} else if (oculusOrbState != 1 || keyHandlerInstance.field1889 <= 0) {
								field581[field532] = keyHandlerInstance.field1890;
								field580[field532] = keyHandlerInstance.field1889;
								++field532;
							}
						}

						boolean var34 = staffModLevel >= 2;
						if (var34 && keyHandlerInstance.getKeyPressed(82) && keyHandlerInstance.getKeyPressed(81) && mouseWheelRotation != 0) {
							var4 = VarbitComposition.localPlayer.plane - mouseWheelRotation;
							if (var4 < 0) {
								var4 = 0;
							} else if (var4 > 3) {
								var4 = 3;
							}

							if (var4 != VarbitComposition.localPlayer.plane) {
								NPC.method597(VarbitComposition.localPlayer.pathX[0] + UrlRequester.baseX, VarbitComposition.localPlayer.pathY[0] + class47.baseY, var4, false);
							}

							mouseWheelRotation = 0;
						}

						if (MouseHandler.MouseHandler_lastButton == 1) {
							field423.method1090();
						}

						if (rootInterface != -1) {
							LoginScreenAnimation.updateRootInterface(rootInterface, 0, 0, class113.canvasWidth, class177.canvasHeight, 0, 0);
						}

						++cycleCntr;

						while (true) {
							Widget var37;
							ScriptEvent var39;
							Widget var42;
							do {
								var39 = (ScriptEvent)field629.removeLast();
								if (var39 == null) {
									while (true) {
										do {
											var39 = (ScriptEvent)field630.removeLast();
											if (var39 == null) {
												while (true) {
													do {
														var39 = (ScriptEvent)scriptEvents.removeLast();
														if (var39 == null) {
															while (true) {
																class211 var41 = (class211)field628.removeLast();
																if (var41 == null) {
																	this.menu();
																	WorldMapRectangle.method1529();
																	if (clickedWidget != null) {
																		this.method380();
																	}

																	if (Scene.shouldSendWalk()) {
																		var4 = Scene.Scene_selectedX;
																		var5 = Scene.Scene_selectedY;
																		var18 = ApproximateRouteStrategy.getPacketBufferNode(ClientPacket.MOVE_GAMECLICK, packetWriter.isaacCipher);
																		var18.packetBuffer.writeByte(5);
																		var18.packetBuffer.writeShortAddLE(var4 + UrlRequester.baseX);
																		var18.packetBuffer.writeShortAdd(var5 + class47.baseY);
																		var18.packetBuffer.writeByteSub(keyHandlerInstance.getKeyPressed(82) ? (keyHandlerInstance.getKeyPressed(81) ? 2 : 1) : 0);
																		packetWriter.addNode(var18);
																		Scene.method1275();
																		mouseCrossX = MouseHandler.MouseHandler_lastPressedX;
																		mouseCrossY = MouseHandler.MouseHandler_lastPressedY;
																		mouseCrossColor = 1;
																		mouseCrossState = 0;
																		destinationX = var4;
																		destinationY = var5;
																	}

																	if (var35 != class146.mousedOverWidgetIf1) {
																		if (var35 != null) {
																			class218.invalidateWidget(var35);
																		}

																		if (class146.mousedOverWidgetIf1 != null) {
																			class218.invalidateWidget(class146.mousedOverWidgetIf1);
																		}
																	}

																	if (var33 != class343.field3147 && field496 == field498) {
																		if (var33 != null) {
																			class218.invalidateWidget(var33);
																		}

																		if (class343.field3147 != null) {
																			class218.invalidateWidget(class343.field3147);
																		}
																	}

																	if (class343.field3147 != null) {
																		if (field496 < field498) {
																			++field496;
																			if (field496 == field498) {
																				class218.invalidateWidget(class343.field3147);
																			}
																		}
																	} else if (field496 > 0) {
																		--field496;
																	}

																	class415.method2159();
																	if (field400) {
																		class126.method702(FontName.field4045, KeyHandler.field70, class31.field84);
																		class416.method2161(UserComparator4.field1180, VertexNormal.field2255);
																		if (NPCComposition.cameraX == FontName.field4045 && class133.cameraY == KeyHandler.field70 && class139.cameraZ == class31.field84 && class129.cameraPitch == UserComparator4.field1180 && UserComparator10.cameraYaw == VertexNormal.field2255) {
																			field400 = false;
																			isCameraLocked = false;
																			field402 = false;
																			field404 = false;
																			PendingSpawn.cameraLookAtX = 0;
																			VarbitComposition.cameraLookAtY = 0;
																			MusicPatchNode2.cameraLookAtHeight = 0;
																			class33.cameraLookAtSpeed = 0;
																			WorldMapElement.cameraLookAtAcceleration = 0;
																			MouseHandler.cameraMoveToAcceleration = 0;
																			class344.cameraMoveToSpeed = 0;
																			Players.cameraMoveToX = 0;
																			class33.cameraMoveToY = 0;
																			VarpDefinition.cameraMoveToHeight = 0;
																			field642 = null;
																			field647 = null;
																			field646 = null;
																		}
																	} else if (isCameraLocked) {
																		class140.method762();
																	}

																	for (var4 = 0; var4 < 5; ++var4) {
																		int var10002 = cameraShakeCycle[var4]++;
																	}

																	KeyHandler.varcs.tryWrite();
																	var4 = MusicPatchPcmStream.method1690();
																	var5 = GameEngine.keyHandler.getIdleCycles();
																	PacketBufferNode var26;
																	if (var4 > 15000 && var5 > 15000) {
																		logoutTimer = 250;
																		class20.method64(14500);
																		var26 = ApproximateRouteStrategy.getPacketBufferNode(ClientPacket.IDLE_LOGOUT, packetWriter.isaacCipher);
																		packetWriter.addNode(var26);
																	}

																	class299.friendSystem.processFriendUpdates();
																	FileSystem.method915();
																	++packetWriter.pendingWrites;
																	if (packetWriter.pendingWrites > 50) {
																		var26 = ApproximateRouteStrategy.getPacketBufferNode(ClientPacket.NO_TIMEOUT, packetWriter.isaacCipher);
																		packetWriter.addNode(var26);
																	}

																	try {
																		packetWriter.flush();
																	} catch (IOException var27) {
																		Renderable.method1291();
																	}

																	return;
																}

																ClanChannel.method862(var41);
															}
														}

														var42 = var39.widget;
														if (var42.childIndex < 0) {
															break;
														}

														var37 = class92.getWidget(var42.parentId);
													} while(var37 == null || var37.children == null || var42.childIndex >= var37.children.length || var42 != var37.children[var42.childIndex]);

													WorldMapSection1.runScriptEvent(var39);
												}
											}

											var42 = var39.widget;
											if (var42.childIndex < 0) {
												break;
											}

											var37 = class92.getWidget(var42.parentId);
										} while(var37 == null || var37.children == null || var42.childIndex >= var37.children.length || var42 != var37.children[var42.childIndex]);

										WorldMapSection1.runScriptEvent(var39);
									}
								}

								var42 = var39.widget;
								if (var42.childIndex < 0) {
									break;
								}

								var37 = class92.getWidget(var42.parentId);
							} while(var37 == null || var37.children == null || var42.childIndex >= var37.children.length || var42 != var37.children[var42.childIndex]);

							WorldMapSection1.runScriptEvent(var39);
						}
					}

					var30 = ApproximateRouteStrategy.getPacketBufferNode(ClientPacket.REFLECTION_CHECK_REPLY, packetWriter.isaacCipher);
					var30.packetBuffer.writeByte(0);
					var3 = var30.packetBuffer.offset;
					SceneTilePaint.performReflectionCheck(var30.packetBuffer);
					var30.packetBuffer.method2540(var30.packetBuffer.offset - var3);
					packetWriter.addNode(var30);
				}
			}
		}
	}

	@ObfuscatedName("iw")
	@ObfuscatedSignature(
		descriptor = "(IIS)V",
		garbageValue = "-9429"
	)
	@Export("vmethod1644")
	public void vmethod1644(int var1, int var2) {
		if (packetWriter != null && packetWriter.isaacCipher != null) {
			if (var1 > -1 && class449.clientPreferences.getCurrentMusicVolume() > 0 && !playingJingle) {
				PacketBufferNode var3 = ApproximateRouteStrategy.getPacketBufferNode(ClientPacket.SOUND_SONGEND, packetWriter.isaacCipher);
				var3.packetBuffer.writeInt(var1);
				packetWriter.addNode(var3);
			}

		}
	}

	@ObfuscatedName("jk")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "347895574"
	)
	@Export("resizeJS")
	void resizeJS() {
		int var1 = class113.canvasWidth;
		int var2 = class177.canvasHeight;
		if (super.contentWidth < var1) {
			var1 = super.contentWidth;
		}

		if (super.contentHeight < var2) {
			var2 = super.contentHeight;
		}

		if (class449.clientPreferences != null) {
			try {
				class26.method95(class219.client, "resize", new Object[]{class218.getWindowedMode()});
			} catch (Throwable var4) {
			}
		}

	}

	@ObfuscatedName("jv")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "1"
	)
	@Export("drawLoggedIn")
	final void drawLoggedIn() {
		if (rootInterface != -1) {
			class316.method1699(rootInterface);
		}

		int var1;
		for (var1 = 0; var1 < rootWidgetCount; ++var1) {
			if (field407[var1]) {
				field408[var1] = true;
			}

			field409[var1] = field407[var1];
			field407[var1] = false;
		}

		field527 = cycle;
		viewportX = -1;
		viewportY = -1;
		if (rootInterface != -1) {
			rootWidgetCount = 0;
			class36.drawWidgets(rootInterface, 0, 0, class113.canvasWidth, class177.canvasHeight, 0, 0, -1);
		}

		Rasterizer2D.Rasterizer2D_resetClip();
		if (showMouseCross) {
			if (mouseCrossColor == 1) {
				class152.crossSprites[mouseCrossState / 100].drawTransBgAt(mouseCrossX - 8, mouseCrossY - 8);
			}

			if (mouseCrossColor == 2) {
				class152.crossSprites[mouseCrossState / 100 + 4].drawTransBgAt(mouseCrossX - 8, mouseCrossY - 8);
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
						var5 = "Use" + " " + field599 + " " + "->";
					} else if (isSpellSelected && menuOptionsCount < 2) {
						var5 = field600 + " " + field601 + " " + "->";
					} else {
						var5 = class181.method928(var3);
					}

					if (menuOptionsCount > 2) {
						var5 = var5 + MoveSpeed.colorStartTag(16777215) + " " + '/' + " " + (menuOptionsCount - 2) + " more options";
					}

					class59.fontBold12.drawRandomAlphaAndSpacing(var5, var1 + 4, var2 + 15, 16777215, 0, cycle / 1000);
				}
			}
		} else {
			var1 = class12.menuX;
			var2 = class419.menuY;
			var3 = class316.menuWidth;
			int var4 = Occluder.menuHeight;
			int var13 = 6116423;
			Rasterizer2D.Rasterizer2D_fillRectangle(var1, var2, var3, var4, var13);
			Rasterizer2D.Rasterizer2D_fillRectangle(var1 + 1, var2 + 1, var3 - 2, 16, 0);
			Rasterizer2D.Rasterizer2D_drawRectangle(var1 + 1, var2 + 18, var3 - 2, var4 - 19, 0);
			class59.fontBold12.draw("Choose Option", var1 + 3, var2 + 14, var13, -1);
			int var6 = MouseHandler.MouseHandler_x;
			int var7 = MouseHandler.MouseHandler_y;

			int var8;
			int var9;
			int var10;
			for (var8 = 0; var8 < menuOptionsCount; ++var8) {
				var9 = var2 + (menuOptionsCount - 1 - var8) * 15 + 31;
				var10 = 16777215;
				if (var6 > var1 && var6 < var3 + var1 && var7 > var9 - 13 && var7 < var9 + 3) {
					var10 = 16776960;
				}

				class59.fontBold12.draw(class181.method928(var8), var1 + 3, var9, var10, 0);
			}

			var8 = class12.menuX;
			var9 = class419.menuY;
			var10 = class316.menuWidth;
			int var11 = Occluder.menuHeight;

			for (int var12 = 0; var12 < rootWidgetCount; ++var12) {
				if (rootWidgetXs[var12] + rootWidgetWidths[var12] > var8 && rootWidgetXs[var12] < var8 + var10 && rootWidgetYs[var12] + rootWidgetHeights[var12] > var9 && rootWidgetYs[var12] < var9 + var11) {
					field408[var12] = true;
				}
			}
		}

		if (gameDrawingMode == 3) {
			for (var1 = 0; var1 < rootWidgetCount; ++var1) {
				if (field409[var1]) {
					Rasterizer2D.Rasterizer2D_fillRectangleAlpha(rootWidgetXs[var1], rootWidgetYs[var1], rootWidgetWidths[var1], rootWidgetHeights[var1], 16711935, 128);
				} else if (field408[var1]) {
					Rasterizer2D.Rasterizer2D_fillRectangleAlpha(rootWidgetXs[var1], rootWidgetYs[var1], rootWidgetWidths[var1], rootWidgetHeights[var1], 16711680, 128);
				}
			}
		}

		class131.method729(HealthBar.Client_plane, VarbitComposition.localPlayer.x, VarbitComposition.localPlayer.y, field457);
		field457 = 0;
	}

	@ObfuscatedName("ks")
	@ObfuscatedSignature(
		descriptor = "(Ler;II)Z",
		garbageValue = "692591213"
	)
	boolean method372(PacketWriter var1, int var2) {
		if (var1.serverPacketLength == 0) {
			ReflectionCheck.friendsChat = null;
		} else {
			if (ReflectionCheck.friendsChat == null) {
				ReflectionCheck.friendsChat = new FriendsChat(Language.loginType, class219.client);
			}

			ReflectionCheck.friendsChat.method2201(var1.packetBuffer, var2);
		}

		field524 = cycleCntr;
		SpotAnimationDefinition.ClanChat_inClanChat = true;
		var1.serverPacket = null;
		return true;
	}

	@ObfuscatedName("kn")
	@ObfuscatedSignature(
		descriptor = "(Ler;I)Z",
		garbageValue = "-1865308830"
	)
	boolean method373(PacketWriter var1) {
		if (ReflectionCheck.friendsChat != null) {
			ReflectionCheck.friendsChat.method2202(var1.packetBuffer);
		}

		field524 = cycleCntr;
		SpotAnimationDefinition.ClanChat_inClanChat = true;
		var1.serverPacket = null;
		return true;
	}

	@ObfuscatedName("kd")
	@ObfuscatedSignature(
		descriptor = "(Ler;I)Z",
		garbageValue = "-1722622027"
	)
	final boolean method374(PacketWriter var1) {
		AbstractSocket var2 = var1.getSocket();
		PacketBuffer var3 = var1.packetBuffer;
		if (var2 == null) {
			return false;
		} else {
			int var6;
			String var21;
			try {
				int var5;
				if (var1.serverPacket == null) {
					if (var1.field1152) {
						if (!var2.isAvailable(1)) {
							return false;
						}

						var2.read(var1.packetBuffer.array, 0, 1);
						var1.field1154 = 0;
						var1.field1152 = false;
					}

					var3.offset = 0;
					if (var3.method2518()) {
						if (!var2.isAvailable(1)) {
							return false;
						}

						var2.read(var1.packetBuffer.array, 1, 1);
						var1.field1154 = 0;
					}

					var1.field1152 = true;
					ServerPacket[] var4 = class176.method916();
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
				var1.field1154 = 0;
				timer.method2150();
				var1.field1158 = var1.field1157;
				var1.field1157 = var1.field1159;
				var1.field1159 = var1.serverPacket;
				if (ServerPacket.UPDATE_UID192 == var1.serverPacket) {
					class128.privateChatMode = DevicePcmPlayerProvider.method74(var3.readUnsignedByte());
					var1.serverPacket = null;
					return true;
				}

				int var7;
				int var8;
				int var9;
				int var10;
				int var13;
				int var15;
				int var56;
				int var59;
				int var68;
				if (ServerPacket.IF_SETMODEL == var1.serverPacket) {
					var6 = var3.method2591();
					var68 = var6 >> 16;
					var5 = var6 >> 8 & 255;
					var7 = var68 + (var6 >> 4 & 7);
					var8 = var5 + (var6 & 7);
					var9 = var3.readUnsignedByteSub();
					var10 = var9 >> 2;
					var56 = var9 & 3;
					var59 = field653[var10];
					var13 = var3.readUnsignedShort();
					if (var7 >= 0 && var8 >= 0 && var7 < 103 && var8 < 103) {
						if (var59 == 0) {
							BoundaryObject var67 = class130.scene.method1255(HealthBar.Client_plane, var7, var8);
							if (var67 != null) {
								var15 = InvDefinition.Entity_unpackID(var67.tag);
								if (var10 == 2) {
									var67.renderable1 = new DynamicObject(var15, 2, var56 + 4, HealthBar.Client_plane, var7, var8, var13, false, var67.renderable1);
									var67.renderable2 = new DynamicObject(var15, 2, var56 + 1 & 3, HealthBar.Client_plane, var7, var8, var13, false, var67.renderable2);
								} else {
									var67.renderable1 = new DynamicObject(var15, var10, var56, HealthBar.Client_plane, var7, var8, var13, false, var67.renderable1);
								}
							}
						} else if (var59 == 1) {
							WallDecoration var66 = class130.scene.method1256(HealthBar.Client_plane, var7, var8);
							if (var66 != null) {
								var15 = InvDefinition.Entity_unpackID(var66.tag);
								if (var10 != 4 && var10 != 5) {
									if (var10 == 6) {
										var66.renderable1 = new DynamicObject(var15, 4, var56 + 4, HealthBar.Client_plane, var7, var8, var13, false, var66.renderable1);
									} else if (var10 == 7) {
										var66.renderable1 = new DynamicObject(var15, 4, (var56 + 2 & 3) + 4, HealthBar.Client_plane, var7, var8, var13, false, var66.renderable1);
									} else if (var10 == 8) {
										var66.renderable1 = new DynamicObject(var15, 4, var56 + 4, HealthBar.Client_plane, var7, var8, var13, false, var66.renderable1);
										var66.renderable2 = new DynamicObject(var15, 4, (var56 + 2 & 3) + 4, HealthBar.Client_plane, var7, var8, var13, false, var66.renderable2);
									}
								} else {
									var66.renderable1 = new DynamicObject(var15, 4, var56, HealthBar.Client_plane, var7, var8, var13, false, var66.renderable1);
								}
							}
						} else if (var59 == 2) {
							GameObject var64 = class130.scene.getGameObject(HealthBar.Client_plane, var7, var8);
							if (var10 == 11) {
								var10 = 10;
							}

							if (var64 != null) {
								var64.renderable = new DynamicObject(InvDefinition.Entity_unpackID(var64.tag), var10, var56, HealthBar.Client_plane, var7, var8, var13, false, var64.renderable);
							}
						} else if (var59 == 3) {
							FloorDecoration var65 = class130.scene.getFloorDecoration(HealthBar.Client_plane, var7, var8);
							if (var65 != null) {
								var65.renderable = new DynamicObject(InvDefinition.Entity_unpackID(var65.tag), 22, var56, HealthBar.Client_plane, var7, var8, var13, false, var65.renderable);
							}
						}
					}

					var1.serverPacket = null;
					return true;
				}

				Widget var76;
				if (ServerPacket.IF_SETANIM == var1.serverPacket) {
					var68 = var3.readInt();
					var76 = class92.getWidget(var68);
					var76.modelType = 3;
					var76.modelId = VarbitComposition.localPlayer.appearance.getChatHeadId();
					class218.invalidateWidget(var76);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.CAM_LOOKAT == var1.serverPacket) {
					field400 = false;
					isCameraLocked = false;
					field402 = false;
					field404 = false;
					PendingSpawn.cameraLookAtX = 0;
					VarbitComposition.cameraLookAtY = 0;
					MusicPatchNode2.cameraLookAtHeight = 0;
					field401 = false;
					class33.cameraLookAtSpeed = 0;
					WorldMapElement.cameraLookAtAcceleration = 0;
					MouseHandler.cameraMoveToAcceleration = 0;
					class344.cameraMoveToSpeed = 0;
					Players.cameraMoveToX = 0;
					class33.cameraMoveToY = 0;
					VarpDefinition.cameraMoveToHeight = 0;
					field642 = null;
					field647 = null;
					field646 = null;

					for (var68 = 0; var68 < 5; ++var68) {
						cameraShaking[var68] = false;
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.SET_PLAYER_OP == var1.serverPacket) {
					class139.varclan = null;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.LOC_DEL == var1.serverPacket) {
					var68 = var3.readInt();
					var5 = var3.readInt();
					var6 = WorldMapManager.getGcDuration();
					PacketBufferNode var79 = ApproximateRouteStrategy.getPacketBufferNode(ClientPacket.field2581, packetWriter.isaacCipher);
					var79.packetBuffer.writeByte(GameEngine.fps);
					var79.packetBuffer.writeIntLE(var68);
					var79.packetBuffer.writeIntIME(var5);
					var79.packetBuffer.writeByteAdd(var6);
					packetWriter.addNode(var79);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.VARCLAN_ENABLE == var1.serverPacket) {
					class113.process();
					weight = var3.readShort();
					field528 = cycleCntr;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.OBJ_COUNT == var1.serverPacket) {
					World.processZoneOperation(ZoneOperation.LOC_ANIM);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.OBJ_ADD == var1.serverPacket) {
					var68 = var3.readIntME();
					KeyHandler.method93(var68);
					changedItemContainers[++changedItemContainersCount - 1 & 31] = var68 & 32767;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.CAM_LOOKAT_EASED_ANGLE_RELATIVE == var1.serverPacket) {
					World.processZoneOperation(ZoneOperation.AREA_SOUND);
					var1.serverPacket = null;
					return true;
				}

				boolean var11;
				byte var20;
				long var23;
				long var25;
				long var27;
				String var30;
				int var85;
				if (ServerPacket.LOGOUT_FULL == var1.serverPacket) {
					var20 = var3.readByte();
					var23 = (long)var3.readUnsignedShort();
					var25 = (long)var3.readMedium();
					var27 = (var23 << 32) + var25;
					var11 = false;
					ClanChannel var81 = var20 >= 0 ? currentClanChannels[var20] : VerticalAlignment.guestClanChannel;
					if (var81 == null) {
						var11 = true;
					} else {
						for (var13 = 0; var13 < 100; ++var13) {
							if (crossWorldMessageIds[var13] == var27) {
								var11 = true;
								break;
							}
						}
					}

					if (!var11) {
						crossWorldMessageIds[crossWorldMessageIdsIndex] = var27;
						crossWorldMessageIdsIndex = (crossWorldMessageIdsIndex + 1) % 100;
						var30 = DirectByteArrayCopier.readString(var3);
						var85 = var20 >= 0 ? 43 : 46;
						class416.addChatMessage(var85, "", var30, var81.name);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.MAP_ANIM == var1.serverPacket) {
					UserComparator8.updatePlayers(var3, var1.serverPacketLength);
					class383.method2021();
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.SYNTH_SOUND == var1.serverPacket) {
					isCameraLocked = true;
					field400 = false;
					field404 = true;
					PendingSpawn.cameraLookAtX = var3.readUnsignedByte();
					VarbitComposition.cameraLookAtY = var3.readUnsignedByte();
					MusicPatchNode2.cameraLookAtHeight = var3.readUnsignedShort();
					var68 = var3.readUnsignedShort();
					var5 = var3.readUnsignedByte();
					var6 = PendingSpawn.cameraLookAtX * 128 + 64;
					var7 = VarbitComposition.cameraLookAtY * 128 + 64;
					var8 = class18.getTileHeight(var6, var7, HealthBar.Client_plane) - MusicPatchNode2.cameraLookAtHeight;
					var9 = var6 - NPCComposition.cameraX;
					var10 = var8 - class133.cameraY;
					var56 = var7 - class139.cameraZ;
					double var84 = Math.sqrt((double)(var56 * var56 + var9 * var9));
					var85 = UserComparator8.method674((int)(Math.atan2((double)var10, var84) * 325.9490051269531D) & 2047);
					var15 = class7.method18((int)(Math.atan2((double)var9, (double)var56) * -325.9490051269531D) & 2047);
					field647 = new class478(class129.cameraPitch, var85, var68, var5);
					field646 = new class478(UserComparator10.cameraYaw, var15, var68, var5);
					var1.serverPacket = null;
					return true;
				}

				long var32;
				InterfaceParent var74;
				if (ServerPacket.UPDATE_FRIENDCHAT_CHANNEL_FULL_V2 == var1.serverPacket) {
					var68 = var3.offset + var1.serverPacketLength;
					var5 = var3.readUnsignedShort();
					if (var5 == 65535) {
						var5 = -1;
					}

					var6 = var3.readUnsignedShort();
					if (var5 != rootInterface) {
						rootInterface = var5;
						this.resizeRoot(false);
						class19.Widget_resetModelFrames(rootInterface);
						MoveSpeed.runWidgetOnLoadListener(rootInterface);

						for (var7 = 0; var7 < 100; ++var7) {
							field407[var7] = true;
						}
					}

					InterfaceParent var88;
					for (; var6-- > 0; var88.field858 = true) {
						var7 = var3.readInt();
						var8 = var3.readUnsignedShort();
						var9 = var3.readUnsignedByte();
						var88 = (InterfaceParent)interfaceParents.get((long)var7);
						if (var88 != null && var8 != var88.group) {
							class92.closeInterface(var88, true);
							var88 = null;
						}

						if (var88 == null) {
							var88 = class339.ifOpenSub(var7, var8, var9);
						}
					}

					for (var74 = (InterfaceParent)interfaceParents.first(); var74 != null; var74 = (InterfaceParent)interfaceParents.next()) {
						if (var74.field858) {
							var74.field858 = false;
						} else {
							class92.closeInterface(var74, true);
						}
					}

					widgetFlags = new NodeHashTable(512);

					while (var3.offset < var68) {
						var7 = var3.readInt();
						var8 = var3.readUnsignedShort();
						var9 = var3.readUnsignedShort();
						var10 = var3.readInt();

						for (var56 = var8; var56 <= var9; ++var56) {
							var32 = ((long)var7 << 32) + (long)var56;
							widgetFlags.put(new IntegerNode(var10), var32);
						}
					}

					var1.serverPacket = null;
					return true;
				}

				Widget var93;
				if (ServerPacket.TOGGLE_OCULUS_ORB == var1.serverPacket) {
					var68 = var3.readInt();
					var5 = var3.method2598();
					InterfaceParent var97 = (InterfaceParent)interfaceParents.get((long)var5);
					var74 = (InterfaceParent)interfaceParents.get((long)var68);
					if (var74 != null) {
						class92.closeInterface(var74, var97 == null || var74.group != var97.group);
					}

					if (var97 != null) {
						var97.remove();
						interfaceParents.put(var97, (long)var68);
					}

					var93 = class92.getWidget(var5);
					if (var93 != null) {
						class218.invalidateWidget(var93);
					}

					var93 = class92.getWidget(var68);
					if (var93 != null) {
						class218.invalidateWidget(var93);
						Login.revalidateWidgetScroll(PacketBufferNode.Widget_interfaceComponents[var93.id >>> 16], var93, true);
					}

					if (rootInterface != -1) {
						class385.runIntfCloseListeners(rootInterface, 1);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.UPDATE_INV_FULL == var1.serverPacket) {
					WorldMapSection2.method1410();
					var20 = var3.readByte();
					if (var1.serverPacketLength == 1) {
						if (var20 >= 0) {
							currentClanSettings[var20] = null;
						} else {
							Players.guestClanSettings = null;
						}

						var1.serverPacket = null;
						return true;
					}

					if (var20 >= 0) {
						currentClanSettings[var20] = new ClanSettings(var3);
					} else {
						Players.guestClanSettings = new ClanSettings(var3);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.CHAT_FILTER_SETTINGS_PRIVATECHAT == var1.serverPacket) {
					var68 = var3.readInt();
					InterfaceParent var78 = (InterfaceParent)interfaceParents.get((long)var68);
					if (var78 != null) {
						class92.closeInterface(var78, true);
					}

					if (meslayerContinueWidget != null) {
						class218.invalidateWidget(meslayerContinueWidget);
						meslayerContinueWidget = null;
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.LOGOUT == var1.serverPacket) {
					var9 = var3.readUnsignedShort();
					var6 = var3.method2591();
					var68 = var6 >> 16;
					var5 = var6 >> 8 & 255;
					var7 = var68 + (var6 >> 4 & 7);
					var8 = var5 + (var6 & 7);
					var10 = var3.readUnsignedByteAdd();
					var56 = var3.readUnsignedShortLE();
					if (var7 >= 0 && var8 >= 0 && var7 < 104 && var8 < 104) {
						var7 = var7 * 128 + 64;
						var8 = var8 * 128 + 64;
						GraphicsObject var29 = new GraphicsObject(var9, HealthBar.Client_plane, var7, var8, class18.getTileHeight(var7, var8, HealthBar.Client_plane) - var10, var56, cycle);
						graphicsObjects.addFirst(var29);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.CAM_RESET == var1.serverPacket) {
					field517 = cycleCntr;
					var20 = var3.readByte();
					if (var1.serverPacketLength == 1) {
						if (var20 >= 0) {
							currentClanChannels[var20] = null;
						} else {
							VerticalAlignment.guestClanChannel = null;
						}

						var1.serverPacket = null;
						return true;
					}

					if (var20 >= 0) {
						currentClanChannels[var20] = new ClanChannel(var3);
					} else {
						VerticalAlignment.guestClanChannel = new ClanChannel(var3);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.UPDATE_INV_PARTIAL == var1.serverPacket) {
					World.processZoneOperation(ZoneOperation.PREFETCH_GAMEOBJECTS);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.RESET_CLIENT_VARCACHE == var1.serverPacket) {
					World.processZoneOperation(ZoneOperation.LOC_ADD_CHANGE);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.IF_SETPLAYERMODEL_SELF == var1.serverPacket) {
					var68 = var3.readIntME();
					var5 = var3.readUnsignedByteSub();
					if (var68 == 65535) {
						var68 = -1;
					}

					LoginType.performPlayerAnimation(VarbitComposition.localPlayer, var68, var5);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.MIDI_SWAP == var1.serverPacket) {
					class271.loadRegions(true, var1.packetBuffer);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.UPDATE_RUNWEIGHT == var1.serverPacket) {
					if (rootInterface != -1) {
						class385.runIntfCloseListeners(rootInterface, 0);
					}

					var1.serverPacket = null;
					return true;
				}

				Widget var71;
				if (ServerPacket.HEAT_MAP == var1.serverPacket) {
					var68 = var3.readIntIME();
					var5 = var3.method2587();
					var6 = var3.readUnsignedShortLE();
					var71 = class92.getWidget(var68);
					var71.rotationKey = var6 + (var5 << 16);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.CAM_MOVETO_EASED_CIRCULAR == var1.serverPacket) {
					minimapState = var3.readUnsignedByte();
					var1.serverPacket = null;
					return true;
				}

				int var16;
				String var43;
				if (ServerPacket.UPDATE_ZONE_PARTIAL_ENCLOSED == var1.serverPacket) {
					var20 = var3.readByte();
					var21 = var3.readStringCp1252NullTerminated();
					long var37 = (long)var3.readUnsignedShort();
					long var39 = (long)var3.readMedium();
					PlayerType var87 = (PlayerType)KeyHandler.findEnumerated(MidiPcmStream.PlayerType_values(), var3.readUnsignedByte());
					long var41 = (var37 << 32) + var39;
					boolean var63 = false;
					ClanChannel var14 = null;
					var14 = var20 >= 0 ? currentClanChannels[var20] : VerticalAlignment.guestClanChannel;
					if (var14 == null) {
						var63 = true;
					} else {
						var15 = 0;

						while (true) {
							if (var15 >= 100) {
								if (var87.isUser && class299.friendSystem.isIgnored(new Username(var21, Language.loginType))) {
									var63 = true;
								}
								break;
							}

							if (crossWorldMessageIds[var15] == var41) {
								var63 = true;
								break;
							}

							++var15;
						}
					}

					if (!var63) {
						crossWorldMessageIds[crossWorldMessageIdsIndex] = var41;
						crossWorldMessageIdsIndex = (crossWorldMessageIdsIndex + 1) % 100;
						var43 = AbstractFont.escapeBrackets(DirectByteArrayCopier.readString(var3));
						var16 = var20 >= 0 ? 41 : 44;
						if (var87.modIcon != -1) {
							class416.addChatMessage(var16, Tile.addImageTag(var87.modIcon) + var21, var43, var14.name);
						} else {
							class416.addChatMessage(var16, var21, var43, var14.name);
						}
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.VARCLAN == var1.serverPacket) {
					var3.offset += 28;
					if (var3.checkCrc()) {
						class27.method109(var3, var3.offset - 28);
					}

					var1.serverPacket = null;
					return true;
				}

				String var51;
				if (ServerPacket.CAM_MOVETO == var1.serverPacket) {
					var51 = var3.readStringCp1252NullTerminated();
					var5 = var3.readUnsignedByteAdd();
					var6 = var3.readUnsignedByteSub();
					if (var6 >= 1 && var6 <= 8) {
						if (var51.equalsIgnoreCase("null")) {
							var51 = null;
						}

						playerMenuActions[var6 - 1] = var51;
						playerOptionsPriorities[var6 - 1] = var5 == 0;
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.IF_SETPLAYERMODEL_BASECOLOUR == var1.serverPacket) {
					var68 = var3.readUnsignedShort();
					if (var68 == 65535) {
						var68 = -1;
					}

					WorldMapSection1.playSong(var68);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.NPC_ANIM_SPECIFIC == var1.serverPacket) {
					var68 = var3.method2587();
					if (var68 == 65535) {
						var68 = -1;
					}

					var5 = var3.method2592();
					Login.playJingle(var68, var5);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.UPDATE_STAT == var1.serverPacket) {
					ArchiveDisk.logOut();
					var1.serverPacket = null;
					return false;
				}

				if (ServerPacket.MIDI_SONG_WITH_SECONDARY == var1.serverPacket) {
					var68 = var3.readUnsignedIntIME();
					var5 = var3.readUnsignedByteSub();
					var6 = var3.method2587();
					var74 = (InterfaceParent)interfaceParents.get((long)var68);
					if (var74 != null) {
						class92.closeInterface(var74, var6 != var74.group);
					}

					class339.ifOpenSub(var68, var6, var5);
					var1.serverPacket = null;
					return true;
				}

				boolean var80;
				Widget var89;
				if (ServerPacket.LOC_ANIM_SPECIFIC == var1.serverPacket) {
					var80 = var3.readUnsignedByteNeg() == 1;
					var5 = var3.readInt();
					var89 = class92.getWidget(var5);
					if (var80 != var89.isHidden) {
						var89.isHidden = var80;
						class218.invalidateWidget(var89);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.IF_SETEVENTS == var1.serverPacket) {
					var68 = var3.method2587();
					var5 = var3.readUnsignedShort();
					var6 = var3.readIntIME();
					var7 = var3.readUnsignedShort();
					var93 = class92.getWidget(var6);
					if (var7 != var93.modelAngleX || var68 != var93.modelAngleY || var5 != var93.modelZoom) {
						var93.modelAngleX = var7;
						var93.modelAngleY = var68;
						var93.modelZoom = var5;
						class218.invalidateWidget(var93);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.REFLECTIONCHECK_FRIENDLIST == var1.serverPacket) {
					var68 = var3.readUnsignedShortLE();
					var5 = var3.readUnsignedIntIME();
					var89 = class92.getWidget(var5);
					if (var89.modelType != 1 || var68 != var89.modelId) {
						var89.modelType = 1;
						var89.modelId = var68;
						class218.invalidateWidget(var89);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.CLANSETTINGS_DELTA == var1.serverPacket) {
					World.processZoneOperation(ZoneOperation.MAPPROJ_ANIM);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.IF1_MODELROTATE == var1.serverPacket) {
					var8 = var3.readUnsignedShortLE();
					var6 = var3.readIntME();
					var7 = var3.readIntME();
					var68 = var3.method2587();
					var5 = var3.method2587();
					if (var68 == 65535) {
						var68 = -1;
					}

					ArrayList var98 = new ArrayList();
					var98.add(var68);
					class157.method836(var98, var5, var6, var7, var8);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.MAPPROJ_ANIM_SPECIFIC == var1.serverPacket) {
					World.processZoneOperation(ZoneOperation.LOC_DEL);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.RUN_CLIENTSCRIPT == var1.serverPacket) {
					class299.friendSystem.method399();
					field518 = cycleCntr;
					var1.serverPacket = null;
					return true;
				}

				String var94;
				if (ServerPacket.NPC_HEADICON_SPECIFIC == var1.serverPacket) {
					byte[] var54 = new byte[var1.serverPacketLength];
					var3.method2520(var54, 0, var54.length);
					Buffer var77 = new Buffer(var54);
					var94 = var77.readStringCp1252NullTerminated();
					class30.openURL(var94, true, false);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.IF_SETPLAYERMODEL_BODYTYPE == var1.serverPacket) {
					World var53 = new World();
					var53.host = var3.readStringCp1252NullTerminated();
					var53.id = var3.readUnsignedShort();
					var5 = var3.readInt();
					var53.properties = var5;
					if (var53.isDeadman()) {
						var53.field679 = "beta";
					}

					MusicSong.updateGameState(45);
					var2.close();
					var2 = null;
					ModeWhere.changeWorld(var53);
					var1.serverPacket = null;
					return false;
				}

				if (ServerPacket.MIDI_JINGLE == var1.serverPacket) {
					rebootTimer = var3.readUnsignedShortLE() * 30;
					field528 = cycleCntr;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.CHAT_FILTER_SETTINGS == var1.serverPacket) {
					var68 = var3.readUnsignedShort();
					if (var68 == 65535) {
						var68 = -1;
					}

					rootInterface = var68;
					this.resizeRoot(false);
					class19.Widget_resetModelFrames(var68);
					MoveSpeed.runWidgetOnLoadListener(rootInterface);

					for (var5 = 0; var5 < 100; ++var5) {
						field407[var5] = true;
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.IF_SETCOLOUR == var1.serverPacket) {
					isCameraLocked = true;
					field400 = false;
					field402 = true;
					Players.cameraMoveToX = var3.readUnsignedByte();
					class33.cameraMoveToY = var3.readUnsignedByte();
					var68 = var3.readUnsignedShort();
					var5 = var3.readUnsignedShort();
					field401 = var3.readBoolean();
					var6 = var3.readUnsignedByte();
					var7 = Players.cameraMoveToX * 128 + 64;
					var8 = class33.cameraMoveToY * 128 + 64;
					boolean var62 = false;
					boolean var60 = false;
					if (field401) {
						var9 = class133.cameraY;
						var10 = class18.getTileHeight(var7, var8, HealthBar.Client_plane) - var68;
					} else {
						var9 = class18.getTileHeight(NPCComposition.cameraX, class139.cameraZ, HealthBar.Client_plane) - class133.cameraY;
						var10 = var68;
					}

					field642 = new class477(NPCComposition.cameraX, class139.cameraZ, var9, var7, var8, var10, var5, var6);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.PLAYER_SPOTANIM_SPECIFIC == var1.serverPacket) {
					class271.loadRegions(false, var1.packetBuffer);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.IF_OPENTOP == var1.serverPacket) {
					var68 = var3.method2598();
					var76 = class92.getWidget(var68);

					for (var6 = 0; var6 < var76.itemIds.length; ++var6) {
						var76.itemIds[var6] = -1;
						var76.itemIds[var6] = 0;
					}

					class218.invalidateWidget(var76);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.MINIMAP_TOGGLE == var1.serverPacket) {
					var68 = var3.readIntME();
					var5 = var3.method2598();
					var89 = class92.getWidget(var5);
					if (var89 != null && var89.type == 0) {
						if (var68 > var89.scrollHeight - var89.height) {
							var68 = var89.scrollHeight - var89.height;
						}

						if (var68 < 0) {
							var68 = 0;
						}

						if (var68 != var89.scrollY) {
							var89.scrollY = var68;
							class218.invalidateWidget(var89);
						}
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.UPDATE_REBOOT_TIMER == var1.serverPacket) {
					tradeChatMode = var3.readUnsignedByte();
					publicChatMode = var3.readUnsignedByteAdd();
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.CLANCHANNEL_FULL == var1.serverPacket) {
					isCameraLocked = true;
					field400 = false;
					field404 = false;
					PendingSpawn.cameraLookAtX = var3.readUnsignedByte();
					VarbitComposition.cameraLookAtY = var3.readUnsignedByte();
					MusicPatchNode2.cameraLookAtHeight = var3.readUnsignedShort();
					class33.cameraLookAtSpeed = var3.readUnsignedByte();
					WorldMapElement.cameraLookAtAcceleration = var3.readUnsignedByte();
					if (WorldMapElement.cameraLookAtAcceleration >= 100) {
						var68 = PendingSpawn.cameraLookAtX * 128 + 64;
						var5 = VarbitComposition.cameraLookAtY * 128 + 64;
						var6 = class18.getTileHeight(var68, var5, HealthBar.Client_plane) - MusicPatchNode2.cameraLookAtHeight;
						var7 = var68 - NPCComposition.cameraX;
						var8 = var6 - class133.cameraY;
						var9 = var5 - class139.cameraZ;
						var10 = (int)Math.sqrt((double)(var9 * var9 + var7 * var7));
						class129.cameraPitch = (int)(Math.atan2((double)var8, (double)var10) * 325.9490051269531D) & 2047;
						UserComparator10.cameraYaw = (int)(Math.atan2((double)var7, (double)var9) * -325.9490051269531D) & 2047;
						if (class129.cameraPitch < 128) {
							class129.cameraPitch = 128;
						}

						if (class129.cameraPitch > 383) {
							class129.cameraPitch = 383;
						}
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.IF_SETANGLE == var1.serverPacket) {
					return this.method372(var1, 1);
				}

				if (ServerPacket.IF_OPENSUB == var1.serverPacket) {
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

				if (ServerPacket.GAMEFRAME_FULL == var1.serverPacket) {
					WorldMapSection2.method1410();
					var20 = var3.readByte();
					class146 var75 = new class146(var3);
					ClanSettings var96;
					if (var20 >= 0) {
						var96 = currentClanSettings[var20];
					} else {
						var96 = Players.guestClanSettings;
					}

					if (var96 == null) {
						this.method384(var20);
						var1.serverPacket = null;
						return true;
					}

					if (var75.field1347 > var96.field1388) {
						this.method384(var20);
						var1.serverPacket = null;
						return true;
					}

					if (var75.field1347 < var96.field1388) {
						var1.serverPacket = null;
						return true;
					}

					var75.method781(var96);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.LOC_ANIM == var1.serverPacket) {
					World.processZoneOperation(ZoneOperation.OBJ_DEL_LEGACY);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.CAM_LOOKAT_EASED_ANGLE_ABSOLUTE == var1.serverPacket) {
					var68 = var3.method2588();
					var5 = var3.readInt();
					var6 = var3.readShort();
					var71 = class92.getWidget(var5);
					if (var6 != var71.rawX || var68 != var71.rawY || var71.xAlignment != 0 || var71.yAlignment != 0) {
						var71.rawX = var6;
						var71.rawY = var68;
						var71.xAlignment = 0;
						var71.yAlignment = 0;
						class218.invalidateWidget(var71);
						this.alignWidget(var71);
						if (var71.type == 0) {
							Login.revalidateWidgetScroll(PacketBufferNode.Widget_interfaceComponents[var5 >> 16], var71, false);
						}
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.IF_SETPLAYERHEAD == var1.serverPacket) {
					var68 = var3.readIntIME();
					var5 = var3.readUnsignedIntIME();
					var89 = class92.getWidget(var5);
					ReflectionCheck.method174(var89, var68);
					class218.invalidateWidget(var89);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.NEW_PACKET_CAM_RESET_V2 == var1.serverPacket) {
					var68 = var3.readUnsignedShort();
					var5 = var3.method2598();
					var89 = class92.getWidget(var5);
					if (var89.modelType != 6 || var68 != var89.modelId) {
						var89.modelType = 6;
						var89.modelId = var68;
						class218.invalidateWidget(var89);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.SEND_PING == var1.serverPacket) {
					byte var58 = var3.readByteAdd();
					var85 = var3.readUnsignedByteNeg() * 4;
					byte var57 = var3.readByteAdd();
					var59 = var3.readUnsignedShortLE();
					var56 = var3.method2548();
					var16 = var3.readIntME();
					var13 = var3.readUnsignedByteAdd() * 4;
					var15 = var3.method2587();
					var6 = var3.method2591();
					var68 = var6 >> 16;
					var5 = var6 >> 8 & 255;
					var7 = var68 + (var6 >> 4 & 7);
					var8 = var5 + (var6 & 7);
					int var18 = var3.readUnsignedByte();
					int var17 = var3.readUnsignedByteSub();
					var9 = var58 + var7;
					var10 = var57 + var8;
					if (var7 >= 0 && var8 >= 0 && var7 < 104 && var8 < 104 && var9 >= 0 && var10 >= 0 && var9 < 104 && var10 < 104 && var59 != 65535) {
						var7 = var7 * 128 + 64;
						var8 = var8 * 128 + 64;
						var9 = var9 * 128 + 64;
						var10 = var10 * 128 + 64;
						Projectile var19 = new Projectile(var59, HealthBar.Client_plane, var7, var8, class18.getTileHeight(var7, var8, HealthBar.Client_plane) - var13, var15 + cycle, var16 + cycle, var17, var18, var56, var85);
						var19.setDestination(var9, var10, class18.getTileHeight(var9, var10, HealthBar.Client_plane) - var85, var15 + cycle);
						projectiles.addFirst(var19);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.VARCLAN_DISABLE == var1.serverPacket) {
					class139.varclan = new class454(SwapSongTask.HitSplatDefinition_cached);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.FRIENDLIST_LOADED == var1.serverPacket) {
					ObjectSound.field686 = var3.readUnsignedByteNeg();
					class125.field1193 = var3.readUnsignedByteSub();
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.MIDI_SONG_STOP == var1.serverPacket) {
					for (var68 = 0; var68 < players.length; ++var68) {
						if (players[var68] != null) {
							players[var68].sequence = -1;
						}
					}

					for (var68 = 0; var68 < npcs.length; ++var68) {
						if (npcs[var68] != null) {
							npcs[var68].sequence = -1;
						}
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.REBUILD_REGION == var1.serverPacket) {
					Frames.updateNpcs(false, var3);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.SPOTANIM_SPECIFIC == var1.serverPacket) {
					NPCComposition.readReflectionCheck(var3, var1.serverPacketLength);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.REFLECTION_CHECK == var1.serverPacket) {
					Frames.updateNpcs(true, var3);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.VARP_SMALL == var1.serverPacket) {
					var68 = var3.readUnsignedByteAdd();
					var5 = var3.readUnsignedByteAdd();
					var6 = var3.method2598();
					var71 = class92.getWidget(var6);
					Tiles.method460(var71, var5, var68);
					class218.invalidateWidget(var71);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.UPDATE_INV_CLEAR == var1.serverPacket) {
					var5 = var3.readUnsignedShort();
					var68 = var3.readIntME();
					Script.method445(var68, var5);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.SET_MAP_FLAG == var1.serverPacket) {
					var80 = var3.readBoolean();
					if (var80) {
						if (class390.field3656 == null) {
							class390.field3656 = new class369();
						}
					} else {
						class390.field3656 = null;
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.MIDI_SONG_LEGACY == var1.serverPacket) {
					isCameraLocked = true;
					field400 = false;
					field404 = true;
					var68 = class7.method18(var3.readShort() & 2027);
					var5 = UserComparator8.method674(var3.readShort() & 2027);
					var6 = var3.readUnsignedShort();
					var7 = var3.readUnsignedByte();
					field647 = new class478(class129.cameraPitch, var5, var6, var7);
					field646 = new class478(UserComparator10.cameraYaw, var68, var6, var7);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.TRADING_POST_RESULTS == var1.serverPacket) {
					return this.method373(var1);
				}

				if (ServerPacket.VARP_LARGE == var1.serverPacket) {
					World.processZoneOperation(ZoneOperation.OBJ_COUNT);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.IF_SETNPCHEAD == var1.serverPacket) {
					var68 = var3.readUnsignedIntIME();
					var5 = var3.readUnsignedShort();
					if (var5 == 65535) {
						var5 = -1;
					}

					var6 = var3.readIntIME();
					var7 = var3.method2587();
					if (var7 == 65535) {
						var7 = -1;
					}

					for (var8 = var7; var8 <= var5; ++var8) {
						var27 = ((long)var6 << 32) + (long)var8;
						Node var99 = widgetFlags.get(var27);
						if (var99 != null) {
							var99.remove();
						}

						widgetFlags.put(new IntegerNode(var68), var27);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.PREFETCH_GAMEOBJECTS == var1.serverPacket) {
					var7 = var3.readUnsignedShortLE();
					var5 = var3.method2587();
					if (var5 == 65535) {
						var5 = -1;
					}

					var8 = var3.method2587();
					var6 = var3.readIntME();
					var9 = var3.readIntME();
					var68 = var3.readUnsignedShortLE();
					if (var68 == 65535) {
						var68 = -1;
					}

					ArrayList var86 = new ArrayList();
					var86.add(var68);
					var86.add(var5);
					class157.method836(var86, var6, var7, var8, var9);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.HINT_ARROW == var1.serverPacket) {
					class113.process();
					var68 = var3.readUnsignedByteSub();
					var5 = var3.readUnsignedByteAdd();
					var6 = var3.method2598();
					experience[var5] = var6;
					currentLevels[var5] = var68;
					levels[var5] = 1;

					for (var7 = 0; var7 < 98; ++var7) {
						if (var6 >= Skills.Skills_experienceTable[var7]) {
							levels[var5] = var7 + 2;
						}
					}

					changedSkills[++changedSkillsCount - 1 & 31] = var5;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.UPDATE_SITESETTINGS == var1.serverPacket) {
					var68 = var3.readUnsignedShort();
					var5 = var3.readUnsignedByte();
					var6 = var3.readUnsignedShort();
					class27.queueSoundEffect(var68, var5, var6);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.CLANSETTINGS_FULL == var1.serverPacket) {
					var68 = var3.readUnsignedByte();
					var5 = var3.readIntIME();
					var89 = class92.getWidget(var5);
					class135.method742(var89, VarbitComposition.localPlayer.appearance.field2916, var68);
					class218.invalidateWidget(var89);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.NPC_SPOTANIM_SPECIFIC == var1.serverPacket) {
					var68 = var3.readIntIME();
					var5 = var3.readUnsignedShort();
					var89 = class92.getWidget(var68);
					if (var89.modelType != 2 || var5 != var89.modelId) {
						var89.modelType = 2;
						var89.modelId = var5;
						class218.invalidateWidget(var89);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.TRADING_POST_UPDATE == var1.serverPacket) {
					var68 = var3.readUnsignedByte();
					Script.forceDisconnect(var68);
					var1.serverPacket = null;
					return false;
				}

				if (ServerPacket.UPDATE_INV_STOP_TRANSMIT == var1.serverPacket) {
					class113.process();
					runEnergy = var3.readUnsignedShort();
					field528 = cycleCntr;
					var1.serverPacket = null;
					return true;
				}

				boolean var61;
				if (ServerPacket.LOGIN_SCREEN_PACKET == var1.serverPacket) {
					var68 = var3.readIntIME();
					var61 = var3.readUnsignedByte() == 1;
					var89 = class92.getWidget(var68);
					class160.method846(var89, VarbitComposition.localPlayer.appearance, var61);
					class218.invalidateWidget(var89);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.RESET_ANIMS == var1.serverPacket) {
					var20 = var3.readByteNeg();
					var5 = var3.readUnsignedShortLE();
					Varps.Varps_temp[var5] = var20;
					if (Varps.Varps_main[var5] != var20) {
						Varps.Varps_main[var5] = var20;
					}

					WorldMapDecoration.changeGameOptions(var5);
					changedVarps[++changedVarpCount - 1 & 31] = var5;
					var1.serverPacket = null;
					return true;
				}

				boolean var12;
				if (ServerPacket.CAM_SHAKE == var1.serverPacket) {
					var51 = var3.readStringCp1252NullTerminated();
					var23 = (long)var3.readUnsignedShort();
					var25 = (long)var3.readMedium();
					PlayerType var44 = (PlayerType)KeyHandler.findEnumerated(MidiPcmStream.PlayerType_values(), var3.readUnsignedByte());
					long var46 = (var23 << 32) + var25;
					var12 = false;

					for (var13 = 0; var13 < 100; ++var13) {
						if (var46 == crossWorldMessageIds[var13]) {
							var12 = true;
							break;
						}
					}

					if (class299.friendSystem.isIgnored(new Username(var51, Language.loginType))) {
						var12 = true;
					}

					if (!var12 && field486 == 0) {
						crossWorldMessageIds[crossWorldMessageIdsIndex] = var46;
						crossWorldMessageIdsIndex = (crossWorldMessageIdsIndex + 1) % 100;
						var30 = AbstractFont.escapeBrackets(World.method385(DirectByteArrayCopier.readString(var3)));
						byte var83;
						if (var44.isPrivileged) {
							var83 = 7;
						} else {
							var83 = 3;
						}

						if (var44.modIcon != -1) {
							MouseHandler.addGameMessage(var83, Tile.addImageTag(var44.modIcon) + var51, var30);
						} else {
							MouseHandler.addGameMessage(var83, var51, var30);
						}
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.NEW_PACK_215 == var1.serverPacket) {
					if (class139.varclan == null) {
						class139.varclan = new class454(SwapSongTask.HitSplatDefinition_cached);
					}

					class523 var52 = SwapSongTask.HitSplatDefinition_cached.method2324(var3);
					class139.varclan.field3899.vmethod8143(var52.field4216, var52.field4215);
					field572[++field512 - 1 & 31] = var52.field4216;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.SYNC_CLIENT_VARCACHE == var1.serverPacket) {
					var1.serverPacket = null;
					return true;
				}

				NPC var91;
				if (ServerPacket.IF_CLOSESUB == var1.serverPacket) {
					short var82 = (short)var3.method2588();
					var5 = var3.readUnsignedByte();
					var6 = var3.readUnsignedShort();
					var7 = var3.readUnsignedIntIME();
					var91 = npcs[var6];
					if (var91 != null) {
						var91.method589(var5, var7, var82);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.REBUILD_REGION_NORMAL == var1.serverPacket) {
					var68 = var3.readInt();
					if (var68 != field476) {
						field476 = var68;
						WorldMapSection2.method1411();
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.IF_SETPOSITION == var1.serverPacket) {
					for (var68 = 0; var68 < VarpDefinition.field1498; ++var68) {
						VarpDefinition var73 = ApproximateRouteStrategy.VarpDefinition_get(var68);
						if (var73 != null) {
							Varps.Varps_temp[var68] = 0;
							Varps.Varps_main[var68] = 0;
						}
					}

					class113.process();
					changedVarpCount += 32;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.UPDATE_ZONE_PARTIAL_FOLLOWS == var1.serverPacket) {
					var51 = var3.readStringCp1252NullTerminated();
					Object[] var72 = new Object[var51.length() + 1];

					for (var6 = var51.length() - 1; var6 >= 0; --var6) {
						if (var51.charAt(var6) == 's') {
							var72[var6 + 1] = var3.readStringCp1252NullTerminated();
						} else {
							var72[var6 + 1] = new Integer(var3.readInt());
						}
					}

					var72[0] = new Integer(var3.readInt());
					ScriptEvent var95 = new ScriptEvent();
					var95.args = var72;
					WorldMapSection1.runScriptEvent(var95);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.PLAYER_INFO == var1.serverPacket) {
					var51 = var3.readStringCp1252NullTerminated();
					var21 = AbstractFont.escapeBrackets(World.method385(DirectByteArrayCopier.readString(var3)));
					MouseHandler.addGameMessage(6, var51, var21);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.IF_SETHIDE == var1.serverPacket) {
					class299.friendSystem.ignoreList.read(var3, var1.serverPacketLength);
					AbstractSocket.FriendSystem_invalidateIgnoreds();
					field518 = cycleCntr;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.UPDATE_RUNENERGY == var1.serverPacket) {
					var68 = var3.readUShortSmart();
					var61 = var3.readUnsignedByte() == 1;
					var94 = "";
					boolean var55 = false;
					if (var61) {
						var94 = var3.readStringCp1252NullTerminated();
						if (class299.friendSystem.isIgnored(new Username(var94, Language.loginType))) {
							var55 = true;
						}
					}

					String var92 = var3.readStringCp1252NullTerminated();
					if (!var55) {
						MouseHandler.addGameMessage(var68, var94, var92);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.MAPPROJ_ANIM == var1.serverPacket) {
					var80 = var3.readUnsignedByte() == 1;
					if (var80) {
						class132.field1272 = GameEngine.clockNow() - var3.readLong();
						class392.grandExchangeEvents = new GrandExchangeEvents(var3, true);
					} else {
						class392.grandExchangeEvents = null;
					}

					field525 = cycleCntr;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.CAM_MOVETO_EASED == var1.serverPacket) {
					var68 = var3.readUnsignedShortLE();
					var91 = npcs[var68];
					var7 = var3.readUnsignedByteAdd();
					var6 = var3.readUnsignedShortLE();
					var5 = var3.readUnsignedIntIME();
					if (var91 != null) {
						var91.updateSpotAnimation(var7, var6, var5 >> 16, var5 & 65535);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.MESSAGE_PRIVATE_ECHO == var1.serverPacket) {
					var68 = var3.readIntME();
					if (var68 == 65535) {
						var68 = -1;
					}

					var5 = var3.readInt();
					var6 = var3.readIntIME();
					var71 = class92.getWidget(var5);
					ItemComposition var90;
					if (!var71.isIf3) {
						if (var68 == -1) {
							var71.modelType = 0;
							var1.serverPacket = null;
							return true;
						}

						var90 = InvDefinition.ItemDefinition_get(var68).getCountObj(var6);
						var71.modelType = 4;
						var71.modelId = var68;
						var71.modelAngleX = var90.xan2d;
						var71.modelAngleY = var90.yan2d;
						var71.modelZoom = var90.zoom2d * 100 / var6;
						class218.invalidateWidget(var71);
					} else {
						var71.itemId = var68;
						var71.itemQuantity = var6;
						var90 = InvDefinition.ItemDefinition_get(var68).getCountObj(var6);
						var71.modelAngleX = var90.xan2d;
						var71.modelAngleY = var90.yan2d;
						var71.modelAngleZ = var90.zan2d;
						var71.modelOffsetX = var90.offsetX2d;
						var71.modelOffsetY = var90.offsetY2d;
						var71.modelZoom = var90.zoom2d;
						if (var90.isStackable == 1) {
							var71.itemQuantityMode = 1;
						} else {
							var71.itemQuantityMode = 2;
						}

						if (var71.modelRotation > 0) {
							var71.modelZoom = var71.modelZoom * 32 / var71.modelRotation;
						} else if (var71.rawWidth > 0) {
							var71.modelZoom = var71.modelZoom * 32 / var71.rawWidth;
						}

						class218.invalidateWidget(var71);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.PLAYER_ANIM_SPECIFIC == var1.serverPacket) {
					var5 = var3.method2587();
					var6 = var3.readUnsignedByteAdd();
					var68 = var3.readIntME();
					if (var5 == 65535) {
						var5 = -1;
					}

					NPC var22 = npcs[var68];
					if (var22 != null) {
						if (var5 == var22.sequence && var5 != -1) {
							var8 = EnumComposition.SequenceDefinition_get(var5).replyMode;
							if (var8 == 1) {
								var22.sequenceFrame = 0;
								var22.sequenceFrameCycle = 0;
								var22.sequenceDelay = var6;
								var22.currentSequenceFrameIndex = 0;
							} else if (var8 == 2) {
								var22.currentSequenceFrameIndex = 0;
							}
						} else if (var5 == -1 || var22.sequence == -1 || EnumComposition.SequenceDefinition_get(var5).forcedPriority >= EnumComposition.SequenceDefinition_get(var22.sequence).forcedPriority) {
							var22.sequence = var5;
							var22.sequenceFrame = 0;
							var22.sequenceFrameCycle = 0;
							var22.sequenceDelay = var6;
							var22.currentSequenceFrameIndex = 0;
							var22.field1022 = var22.pathLength;
						}
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.IF_SETTEXT == var1.serverPacket) {
					var51 = var3.readStringCp1252NullTerminated();
					var23 = var3.readLong();
					var25 = (long)var3.readUnsignedShort();
					var27 = (long)var3.readMedium();
					PlayerType var45 = (PlayerType)KeyHandler.findEnumerated(MidiPcmStream.PlayerType_values(), var3.readUnsignedByte());
					var32 = var27 + (var25 << 32);
					boolean var31 = false;

					for (var15 = 0; var15 < 100; ++var15) {
						if (crossWorldMessageIds[var15] == var32) {
							var31 = true;
							break;
						}
					}

					if (var45.isUser && class299.friendSystem.isIgnored(new Username(var51, Language.loginType))) {
						var31 = true;
					}

					if (!var31 && field486 == 0) {
						crossWorldMessageIds[crossWorldMessageIdsIndex] = var32;
						crossWorldMessageIdsIndex = (crossWorldMessageIdsIndex + 1) % 100;
						var43 = AbstractFont.escapeBrackets(World.method385(DirectByteArrayCopier.readString(var3)));
						if (var45.modIcon != -1) {
							class416.addChatMessage(9, Tile.addImageTag(var45.modIcon) + var51, var43, class211.base37DecodeLong(var23));
						} else {
							class416.addChatMessage(9, var51, var43, class211.base37DecodeLong(var23));
						}
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.IF_SETPLAYERMODEL_OBJ == var1.serverPacket) {
					var68 = var3.readUnsignedByte();
					MusicPatchNode2.method1625(var68);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.CLANCHANNEL_DELTA == var1.serverPacket) {
					var68 = var3.readUnsignedByte();
					var5 = var3.readUnsignedByte();
					var6 = var3.readUnsignedByte();
					var7 = var3.readUnsignedByte();
					cameraShaking[var68] = true;
					cameraShakeIntensity[var68] = var5;
					cameraMoveIntensity[var68] = var6;
					cameraShakeSpeed[var68] = var7;
					cameraShakeCycle[var68] = 0;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.UPDATE_FRIENDLIST == var1.serverPacket) {
					var68 = var3.readInt();
					var5 = var3.readUnsignedShort();
					if (var68 < -70000) {
						var5 += 32768;
					}

					if (var68 >= 0) {
						var89 = class92.getWidget(var68);
					} else {
						var89 = null;
					}

					for (; var3.offset < var1.serverPacketLength; FriendsChat.itemContainerSetItem(var5, var7, var8 - 1, var9)) {
						var7 = var3.readUShortSmart();
						var8 = var3.readUnsignedShort();
						var9 = 0;
						if (var8 != 0) {
							var9 = var3.readUnsignedByte();
							if (var9 == 255) {
								var9 = var3.readInt();
							}
						}

						if (var89 != null && var7 >= 0 && var7 < var89.itemIds.length) {
							var89.itemIds[var7] = var8;
							var89.field3054[var7] = var9;
						}
					}

					if (var89 != null) {
						class218.invalidateWidget(var89);
					}

					class113.process();
					changedItemContainers[++changedItemContainersCount - 1 & 31] = var5 & 32767;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.IF_SETOBJECT == var1.serverPacket) {
					isCameraLocked = true;
					field400 = false;
					field404 = true;
					var68 = var3.readShort();
					var5 = var3.readShort();
					var6 = UserComparator8.method674(var5 + class129.cameraPitch & 2027);
					var7 = var68 + UserComparator10.cameraYaw;
					var8 = var3.readUnsignedShort();
					var9 = var3.readUnsignedByte();
					field647 = new class478(class129.cameraPitch, var6, var8, var9);
					field646 = new class478(UserComparator10.cameraYaw, var7, var8, var9);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.NPC_INFO_LARGE == var1.serverPacket) {
					var7 = var3.readUnsignedByteAdd();
					var6 = var3.readUnsignedIntIME();
					var5 = var3.readUnsignedShort();
					var68 = var3.readIntME();
					Player var36;
					if (var68 == localPlayerIndex) {
						var36 = VarbitComposition.localPlayer;
					} else {
						var36 = players[var68];
					}

					if (var36 != null) {
						var36.updateSpotAnimation(var7, var5, var6 >> 16, var6 & 65535);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.ENTER_FREECAM == var1.serverPacket) {
					for (var68 = 0; var68 < Varps.Varps_main.length; ++var68) {
						if (Varps.Varps_main[var68] != Varps.Varps_temp[var68]) {
							Varps.Varps_main[var68] = Varps.Varps_temp[var68];
							WorldMapDecoration.changeGameOptions(var68);
							changedVarps[++changedVarpCount - 1 & 31] = var68;
						}
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2725 == var1.serverPacket) {
					Interpreter.method421(var3.readStringCp1252NullTerminated());
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.AREA_SOUND == var1.serverPacket) {
					var68 = var3.readIntIME();
					var5 = var3.readSignedShortAdd();
					var89 = class92.getWidget(var68);
					if (var5 != var89.sequenceId || var5 == -1) {
						var89.sequenceId = var5;
						var89.modelFrame = 0;
						var89.modelFrameCycle = 0;
						class218.invalidateWidget(var89);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.TRIGGER_ONDIALOGABORT == var1.serverPacket) {
					ObjectSound.field686 = var3.readUnsignedByte();
					class125.field1193 = var3.readUnsignedByteSub();

					while (var3.offset < var1.serverPacketLength) {
						var68 = var3.readUnsignedByte();
						ZoneOperation var70 = WorldMapSection0.method1506()[var68];
						World.processZoneOperation(var70);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.IF_SETSCROLLPOS == var1.serverPacket) {
					var68 = var3.readUnsignedShortLE();
					var5 = var3.method2587();
					var7 = var3.method2587();
					var6 = var3.readIntME();
					PacketWriter.someMusicMethod(var68, var5, var6, var7);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.MESSAGE_PRIVATE == var1.serverPacket) {
					isCameraLocked = true;
					field400 = false;
					field402 = true;
					Players.cameraMoveToX = var3.readUnsignedByte();
					class33.cameraMoveToY = var3.readUnsignedByte();
					var68 = var3.readUnsignedShort();
					var5 = var3.readUnsignedByte() * 128 + 64;
					var6 = var3.readUnsignedByte() * 128 + 64;
					var7 = var3.readUnsignedShort();
					field401 = var3.readBoolean();
					var8 = var3.readUnsignedByte();
					var9 = Players.cameraMoveToX * 128 + 64;
					var10 = class33.cameraMoveToY * 128 + 64;
					var11 = false;
					var12 = false;
					if (field401) {
						var56 = class133.cameraY;
						var59 = class18.getTileHeight(var9, var10, HealthBar.Client_plane) - var68;
					} else {
						var56 = class18.getTileHeight(NPCComposition.cameraX, class139.cameraZ, HealthBar.Client_plane) - class133.cameraY;
						var59 = var68;
					}

					field642 = new class476(NPCComposition.cameraX, class139.cameraZ, var56, var9, var10, var59, var5, var6, var7, var8);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.OPEN_URL == var1.serverPacket) {
					class299.friendSystem.readUpdate(var3, var1.serverPacketLength);
					field518 = cycleCntr;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.NPC_INFO_SMALL == var1.serverPacket) {
					isCameraLocked = true;
					field400 = false;
					field402 = false;
					Players.cameraMoveToX = var3.readUnsignedByte();
					class33.cameraMoveToY = var3.readUnsignedByte();
					VarpDefinition.cameraMoveToHeight = var3.readUnsignedShort();
					class344.cameraMoveToSpeed = var3.readUnsignedByte();
					MouseHandler.cameraMoveToAcceleration = var3.readUnsignedByte();
					if (MouseHandler.cameraMoveToAcceleration >= 100) {
						NPCComposition.cameraX = Players.cameraMoveToX * 128 + 64;
						class139.cameraZ = class33.cameraMoveToY * 128 + 64;
						class133.cameraY = class18.getTileHeight(NPCComposition.cameraX, class139.cameraZ, HealthBar.Client_plane) - VarpDefinition.cameraMoveToHeight;
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.OBJ_DEL_LEGACY == var1.serverPacket) {
					var68 = var3.readIntIME();
					var5 = var3.readUnsignedShortLE();
					var6 = var5 >> 10 & 31;
					var7 = var5 >> 5 & 31;
					var8 = var5 & 31;
					var9 = (var7 << 11) + (var6 << 19) + (var8 << 3);
					Widget var34 = class92.getWidget(var68);
					if (var9 != var34.color) {
						var34.color = var9;
						class218.invalidateWidget(var34);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.MESSAGE_GAME == var1.serverPacket) {
					var51 = var3.readStringCp1252NullTerminated();
					var5 = var3.method2598();
					var89 = class92.getWidget(var5);
					if (!var51.equals(var89.text)) {
						var89.text = var51;
						class218.invalidateWidget(var89);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.MESSAGE_FRIENDCHANNEL == var1.serverPacket) {
					var68 = var3.readInt();
					var5 = var3.readUnsignedShort();
					if (var68 < -70000) {
						var5 += 32768;
					}

					if (var68 >= 0) {
						var89 = class92.getWidget(var68);
					} else {
						var89 = null;
					}

					if (var89 != null) {
						for (var7 = 0; var7 < var89.itemIds.length; ++var7) {
							var89.itemIds[var7] = 0;
							var89.field3054[var7] = 0;
						}
					}

					SoundCache.clearItemContainer(var5);
					var7 = var3.readUnsignedShort();

					for (var8 = 0; var8 < var7; ++var8) {
						var9 = var3.readUnsignedShort();
						var10 = var3.readUnsignedByteSub();
						if (var10 == 255) {
							var10 = var3.method2598();
						}

						if (var89 != null && var8 < var89.itemIds.length) {
							var89.itemIds[var8] = var9;
							var89.field3054[var8] = var10;
						}

						FriendsChat.itemContainerSetItem(var5, var8, var9 - 1, var10);
					}

					if (var89 != null) {
						class218.invalidateWidget(var89);
					}

					class113.process();
					changedItemContainers[++changedItemContainersCount - 1 & 31] = var5 & 32767;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.MESSAGE_CLANCHANNEL == var1.serverPacket) {
					var68 = var3.readIntME();
					var5 = var3.method2598();
					Varps.Varps_temp[var68] = var5;
					if (Varps.Varps_main[var68] != var5) {
						Varps.Varps_main[var68] = var5;
					}

					WorldMapDecoration.changeGameOptions(var68);
					changedVarps[++changedVarpCount - 1 & 31] = var68;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.UPDATE_IGNORELIST == var1.serverPacket) {
					World.processZoneOperation(ZoneOperation.field2607);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.UPDATE_FRIENDCHAT_CHANNEL_FULL == var1.serverPacket) {
					World.processZoneOperation(ZoneOperation.MAP_ANIM);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.UPDATE_ZONE_FULL_FOLLOWS == var1.serverPacket) {
					World.processZoneOperation(ZoneOperation.OBJ_ADD);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.EMPTY_PACKET == var1.serverPacket) {
					var68 = var3.readUnsignedByte();
					if (var3.readUnsignedByte() == 0) {
						grandExchangeOffers[var68] = new GrandExchangeOffer();
						var3.offset += 18;
					} else {
						--var3.offset;
						grandExchangeOffers[var68] = new GrandExchangeOffer(var3, false);
					}

					field529 = cycleCntr;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.OBJ_DEL == var1.serverPacket && isCameraLocked) {
					field400 = true;
					field404 = false;
					field402 = false;

					for (var68 = 0; var68 < 5; ++var68) {
						cameraShaking[var68] = false;
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.IF_MOVESUB == var1.serverPacket) {
					ObjectSound.field686 = var3.readUnsignedByteNeg();
					class125.field1193 = var3.readUnsignedByteSub();

					for (var68 = ObjectSound.field686; var68 < ObjectSound.field686 + 8; ++var68) {
						for (var5 = class125.field1193; var5 < class125.field1193 + 8; ++var5) {
							if (groundItems[HealthBar.Client_plane][var68][var5] != null) {
								groundItems[HealthBar.Client_plane][var68][var5] = null;
								class135.updateItemPile(var68, var5);
							}
						}
					}

					for (PendingSpawn var50 = (PendingSpawn)pendingSpawns.last(); var50 != null; var50 = (PendingSpawn)pendingSpawns.previous()) {
						if (var50.x >= ObjectSound.field686 && var50.x < ObjectSound.field686 + 8 && var50.y >= class125.field1193 && var50.y < class125.field1193 + 8 && var50.plane == HealthBar.Client_plane) {
							var50.endCycle = 0;
						}
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.LOC_ADD_CHANGE == var1.serverPacket) {
					return this.method372(var1, 2);
				}

				if (ServerPacket.CAM_LOOKAT_EASED_COORD == var1.serverPacket) {
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

				if (ServerPacket.MESSAGE_CLANCHANNEL_SYSTEM == var1.serverPacket) {
					field517 = cycleCntr;
					var20 = var3.readByte();
					class160 var69 = new class160(var3);
					ClanChannel var35;
					if (var20 >= 0) {
						var35 = currentClanChannels[var20];
					} else {
						var35 = VerticalAlignment.guestClanChannel;
					}

					if (var35 == null) {
						this.method383(var20);
						var1.serverPacket = null;
						return true;
					}

					if (var69.field1415 > var35.field1429) {
						this.method383(var20);
						var1.serverPacket = null;
						return true;
					}

					if (var69.field1415 < var35.field1429) {
						var1.serverPacket = null;
						return true;
					}

					var69.method844(var35);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2730 == var1.serverPacket) {
					World.processZoneOperation(ZoneOperation.OBJ_DEL);
					var1.serverPacket = null;
					return true;
				}

				Messages.RunException_sendStackTrace("" + (var1.serverPacket != null ? var1.serverPacket.id * -908169793 * 1400406591 : -1) + "," + (var1.field1157 != null ? var1.field1157.id * -908169793 * 1400406591 : -1) + "," + (var1.field1158 != null ? var1.field1158.id * -908169793 * 1400406591 : -1) + "," + var1.serverPacketLength, (Throwable)null);
				ArchiveDisk.logOut();
			} catch (IOException var48) {
				Renderable.method1291();
			} catch (Exception var49) {
				var21 = "" + (var1.serverPacket != null ? var1.serverPacket.id * -908169793 * 1400406591 : -1) + "," + (var1.field1157 != null ? var1.field1157.id * -908169793 * 1400406591 : -1) + "," + (var1.field1158 != null ? var1.field1158.id * -908169793 * 1400406591 : -1) + "," + var1.serverPacketLength + "," + (VarbitComposition.localPlayer.pathX[0] + UrlRequester.baseX) + "," + (VarbitComposition.localPlayer.pathY[0] + class47.baseY) + ",";

				for (var6 = 0; var6 < var1.serverPacketLength && var6 < 50; ++var6) {
					var21 = var21 + var3.array[var6] + ",";
				}

				Messages.RunException_sendStackTrace(var21, var49);
				ArchiveDisk.logOut();
			}

			return true;
		}
	}

	@ObfuscatedName("lx")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "-90"
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
			int var19 = MouseHandler.MouseHandler_lastButton;
			int var7;
			int var8;
			int var16;
			int var20;
			if (isMenuOpen) {
				int var15;
				if (var19 != 1 && (ObjTypeCustomisation.mouseCam || var19 != 4)) {
					var2 = MouseHandler.MouseHandler_x;
					var15 = MouseHandler.MouseHandler_y;
					if (var2 < class12.menuX - 10 || var2 > class12.menuX + class316.menuWidth + 10 || var15 < class419.menuY - 10 || var15 > class419.menuY + Occluder.menuHeight + 10) {
						isMenuOpen = false;
						var16 = class12.menuX;
						var5 = class419.menuY;
						var20 = class316.menuWidth;
						var7 = Occluder.menuHeight;

						for (var8 = 0; var8 < rootWidgetCount; ++var8) {
							if (rootWidgetWidths[var8] + rootWidgetXs[var8] > var16 && rootWidgetXs[var8] < var16 + var20 && rootWidgetYs[var8] + rootWidgetHeights[var8] > var5 && rootWidgetYs[var8] < var5 + var7) {
								field407[var8] = true;
							}
						}
					}
				}

				if (var19 == 1 || !ObjTypeCustomisation.mouseCam && var19 == 4) {
					var2 = class12.menuX;
					var15 = class419.menuY;
					var16 = class316.menuWidth;
					var5 = MouseHandler.MouseHandler_lastPressedX;
					var20 = MouseHandler.MouseHandler_lastPressedY;
					var7 = -1;

					int var9;
					for (var8 = 0; var8 < menuOptionsCount; ++var8) {
						var9 = (menuOptionsCount - 1 - var8) * 15 + var15 + 31;
						if (var5 > var2 && var5 < var16 + var2 && var20 > var9 - 13 && var20 < var9 + 3) {
							var7 = var8;
						}
					}

					int var10;
					int var11;
					int var12;
					if (var7 != -1 && var7 >= 0) {
						var8 = menuArguments1[var7];
						var9 = menuArguments2[var7];
						var10 = menuOpcodes[var7];
						var11 = menuIdentifiers[var7];
						var12 = menuItemIds[var7];
						String var13 = menuActions[var7];
						String var14 = menuTargets[var7];
						IgnoreList.menuAction(var8, var9, var10, var11, var12, var13, var14, MouseHandler.MouseHandler_lastPressedX, MouseHandler.MouseHandler_lastPressedY);
					}

					isMenuOpen = false;
					var8 = class12.menuX;
					var9 = class419.menuY;
					var10 = class316.menuWidth;
					var11 = Occluder.menuHeight;

					for (var12 = 0; var12 < rootWidgetCount; ++var12) {
						if (rootWidgetWidths[var12] + rootWidgetXs[var12] > var8 && rootWidgetXs[var12] < var8 + var10 && rootWidgetHeights[var12] + rootWidgetYs[var12] > var9 && rootWidgetYs[var12] < var9 + var11) {
							field407[var12] = true;
						}
					}
				}
			} else {
				var2 = menuOptionsCount - 1;
				if ((var19 == 1 || !ObjTypeCustomisation.mouseCam && var19 == 4) && this.shouldLeftClickOpenMenu()) {
					var19 = 2;
				}

				if ((var19 == 1 || !ObjTypeCustomisation.mouseCam && var19 == 4) && menuOptionsCount > 0 && var2 >= 0) {
					var16 = menuArguments1[var2];
					var5 = menuArguments2[var2];
					var20 = menuOpcodes[var2];
					var7 = menuIdentifiers[var2];
					var8 = menuItemIds[var2];
					String var17 = menuActions[var2];
					String var18 = menuTargets[var2];
					IgnoreList.menuAction(var16, var5, var20, var7, var8, var17, var18, MouseHandler.MouseHandler_lastPressedX, MouseHandler.MouseHandler_lastPressedY);
				}

				if (var19 == 2 && menuOptionsCount > 0) {
					this.openMenu(MouseHandler.MouseHandler_lastPressedX, MouseHandler.MouseHandler_lastPressedY);
				}
			}

		}
	}

	@ObfuscatedName("le")
	@ObfuscatedSignature(
		descriptor = "(B)Z",
		garbageValue = "-84"
	)
	@Export("shouldLeftClickOpenMenu")
	final boolean shouldLeftClickOpenMenu() {
		int var1 = menuOptionsCount - 1;
		return (leftClickOpensMenu && menuOptionsCount > 2 || class53.method298(var1)) && !menuShiftClick[var1];
	}

	@ObfuscatedName("lu")
	@ObfuscatedSignature(
		descriptor = "(III)V",
		garbageValue = "1301595463"
	)
	@Export("openMenu")
	final void openMenu(int var1, int var2) {
		class342.method1867(var1, var2);
		var1 -= viewportOffsetX;
		var2 -= viewportOffsetY;
		class130.scene.menuOpen(HealthBar.Client_plane, var1, var2, false);
		isMenuOpen = true;
	}

	@ObfuscatedName("li")
	@ObfuscatedSignature(
		descriptor = "(ZI)V",
		garbageValue = "571828087"
	)
	@Export("resizeRoot")
	final void resizeRoot(boolean var1) {
		int var2 = rootInterface;
		int var3 = class113.canvasWidth;
		int var4 = class177.canvasHeight;
		if (ModeWhere.loadInterface(var2)) {
			PcmPlayer.resizeInterface(PacketBufferNode.Widget_interfaceComponents[var2], -1, var3, var4, var1);
		}

	}

	@ObfuscatedName("ll")
	@ObfuscatedSignature(
		descriptor = "(Lmi;I)V",
		garbageValue = "649704501"
	)
	@Export("alignWidget")
	void alignWidget(Widget var1) {
		Widget var2 = var1.parentId == -1 ? null : class92.getWidget(var1.parentId);
		int var3;
		int var4;
		if (var2 == null) {
			var3 = class113.canvasWidth;
			var4 = class177.canvasHeight;
		} else {
			var3 = var2.width;
			var4 = var2.height;
		}

		class369.alignWidgetSize(var1, var3, var4, false);
		WorldMapArea.alignWidgetPosition(var1, var3, var4);
	}

	@ObfuscatedName("mb")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-332488970"
	)
	final void method380() {
		class218.invalidateWidget(clickedWidget);
		++class159.widgetDragDuration;
		int var1;
		int var2;
		if (field397 && field395) {
			var1 = MouseHandler.MouseHandler_x;
			var2 = MouseHandler.MouseHandler_y;
			var1 -= widgetClickX;
			var2 -= widgetClickY;
			if (var1 < field514) {
				var1 = field514;
			}

			if (var1 + clickedWidget.width > field514 + clickedWidgetParent.width) {
				var1 = field514 + clickedWidgetParent.width - clickedWidget.width;
			}

			if (var2 < field513) {
				var2 = field513;
			}

			if (var2 + clickedWidget.height > field513 + clickedWidgetParent.height) {
				var2 = field513 + clickedWidgetParent.height - clickedWidget.height;
			}

			int var3 = var1 - field515;
			int var4 = var2 - field521;
			int var5 = clickedWidget.dragZoneSize;
			if (class159.widgetDragDuration > clickedWidget.dragThreshold && (var3 > var5 || var3 < -var5 || var4 > var5 || var4 < -var5)) {
				isDraggingWidget = true;
			}

			int var6 = var1 - field514 + clickedWidgetParent.scrollX;
			int var7 = var2 - field513 + clickedWidgetParent.scrollY;
			ScriptEvent var8;
			if (clickedWidget.onDrag != null && isDraggingWidget) {
				var8 = new ScriptEvent();
				var8.widget = clickedWidget;
				var8.mouseX = var6;
				var8.mouseY = var7;
				var8.args = clickedWidget.onDrag;
				WorldMapSection1.runScriptEvent(var8);
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
						WorldMapSection1.runScriptEvent(var8);
					}

					if (draggedOnWidget != null && BuddyRankComparator.method691(clickedWidget) != null) {
						PacketBufferNode var10 = ApproximateRouteStrategy.getPacketBufferNode(ClientPacket.IF_BUTTOND, packetWriter.isaacCipher);
						var10.packetBuffer.writeIntIME_(clickedWidget.id);
						var10.packetBuffer.writeIntLE(draggedOnWidget.id);
						var10.packetBuffer.writeShort(clickedWidget.childIndex);
						var10.packetBuffer.writeShort(draggedOnWidget.itemId);
						var10.packetBuffer.writeShortAdd(draggedOnWidget.childIndex);
						var10.packetBuffer.writeShortAdd(clickedWidget.itemId);
						packetWriter.addNode(var10);
					}
				} else if (this.shouldLeftClickOpenMenu()) {
					this.openMenu(field515 + widgetClickX, field521 + widgetClickY);
				} else if (menuOptionsCount > 0) {
					method381(widgetClickX + field515, widgetClickY + field521);
				}

				clickedWidget = null;
			}

		} else {
			if (class159.widgetDragDuration > 1) {
				if (!isDraggingWidget && menuOptionsCount > 0) {
					var1 = widgetClickX + field515;
					var2 = widgetClickY + field521;
					MenuAction var9 = class9.tempMenuAction;
					if (var9 != null) {
						IgnoreList.menuAction(var9.param0, var9.param1, var9.opcode, var9.identifier, var9.itemId, var9.action, var9.target, var1, var2);
					}

					class9.tempMenuAction = null;
				}

				clickedWidget = null;
			}

		}
	}

	@ObfuscatedName("ok")
	@ObfuscatedSignature(
		descriptor = "(S)Luc;",
		garbageValue = "-775"
	)
	@Export("username")
	public Username username() {
		return VarbitComposition.localPlayer != null ? VarbitComposition.localPlayer.username : null;
	}

	@ObfuscatedName("of")
	@ObfuscatedSignature(
		descriptor = "(IS)V",
		garbageValue = "516"
	)
	void method383(int var1) {
		if (param25 >= 216) {
			PacketBufferNode var2 = ApproximateRouteStrategy.getPacketBufferNode(ClientPacket.field2582, packetWriter.isaacCipher);
			var2.packetBuffer.writeByte(var1);
			packetWriter.addNode(var2);
		}

	}

	@ObfuscatedName("ps")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "-1345860990"
	)
	void method384(int var1) {
		if (param25 >= 216) {
			PacketBufferNode var2 = ApproximateRouteStrategy.getPacketBufferNode(ClientPacket.field2572, packetWriter.isaacCipher);
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
							ClanChannelMember.clientLanguage = Language.method1976(Integer.parseInt(var2));
							break;
						case 7:
							int var4 = Integer.parseInt(var2);
							GameBuild[] var5 = UrlRequest.method664();
							int var6 = 0;

							GameBuild var13;
							while (true) {
								if (var6 >= var5.length) {
									var13 = null;
									break;
								}

								GameBuild var7 = var5[var6];
								if (var4 == var7.buildId) {
									var13 = var7;
									break;
								}

								++var6;
							}

							WorldMapLabelSize.field2323 = var13;
							break;
						case 8:
							if (var2.equalsIgnoreCase("true")) {
							}
							break;
						case 9:
							MusicPatchPcmStream.param9 = var2;
							break;
						case 10:
							StudioGame[] var3 = new StudioGame[]{StudioGame.stellardawn, StudioGame.game5, StudioGame.game4, StudioGame.runescape, StudioGame.game3, StudioGame.oldscape};
							WorldMapSectionType.field2417 = (StudioGame)KeyHandler.findEnumerated(var3, Integer.parseInt(var2));
							if (StudioGame.oldscape == WorldMapSectionType.field2417) {
								Language.loginType = LoginType.oldscape;
							} else {
								Language.loginType = LoginType.field4066;
							}
							break;
						case 11:
							class510.field4133 = var2;
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
							WorldMapSectionType.field2416 = Integer.parseInt(var2);
							break;
						case 15:
							gameBuild = Integer.parseInt(var2);
							break;
						case 17:
							class200.field1669 = var2;
							break;
						case 21:
							param21 = Integer.parseInt(var2);
							break;
						case 25:
							int var8 = var2.indexOf(".");
							if (var8 == -1) {
								param25 = Integer.parseInt(var2);
							} else {
								param25 = Integer.parseInt(var2.substring(0, var8));
								Integer.parseInt(var2.substring(var8 + 1));
							}
						}
					}
				}

				Scene.Scene_isLowDetail = false;
				isLowDetail = false;
				class292.worldHost = this.getCodeBase().getHost();
				class308.field2819 = new JagNetThread();
				String var9 = WorldMapLabelSize.field2323.name;
				byte var10 = 0;
				if ((worldProperties & class510.field4125.rsOrdinal()) != 0) {
					class30.field83 = "beta";
				}

				try {
					SecureRandomCallable.method462("oldschool", class30.field83, var9, var10, 22);
				} catch (Exception var11) {
					Messages.RunException_sendStackTrace((String)null, var11);
				}

				class219.client = this;
				RunException.field4285 = clientType;
				class18.method58();
				if (Boolean.parseBoolean(System.getProperty("jagex.disableBouncyCastle"))) {
					this.field661 = true;
				}

				if (field424 == -1) {
					if (!this.method352() && !this.method353()) {
						field424 = 0;
					} else {
						field424 = 5;
					}
				}

				this.startThread(765, 503, 216, 1);
			}
		} catch (RuntimeException var12) {
			throw SecureRandomFuture.method438(var12, "client.init(" + ')');
		}
	}

	@Export("finalize")
	@ObfuscatedName("finalize")
	protected void finalize() throws Throwable {
		HorizontalAlignment.method975(this);
		super.finalize();
	}

	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "(IIB)I",
		garbageValue = "24"
	)
	static final int method357(int var0, int var1) {
		if (var0 == -2) {
			return 12345678;
		} else if (var0 == -1) {
			if (var1 < 2) {
				var1 = 2;
			} else if (var1 > 126) {
				var1 = 126;
			}

			return var1;
		} else {
			var1 = (var0 & 127) * var1 / 128;
			if (var1 < 2) {
				var1 = 2;
			} else if (var1 > 126) {
				var1 = 126;
			}

			return (var0 & 65408) + var1;
		}
	}

	@ObfuscatedName("mm")
	@ObfuscatedSignature(
		descriptor = "(IIB)V",
		garbageValue = "18"
	)
	static void method381(int var0, int var1) {
		MenuAction var2 = class9.tempMenuAction;
		if (var2 != null) {
			IgnoreList.menuAction(var2.param0, var2.param1, var2.opcode, var2.identifier, var2.itemId, var2.action, var2.target, var0, var1);
		}

		class9.tempMenuAction = null;
	}
}