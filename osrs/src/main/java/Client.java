import com.jagex.oldscape.pub.OAuthApi;
import com.jagex.oldscape.pub.OtlTokenRequester;
import com.jagex.oldscape.pub.RefreshAccessTokenRequester;
import com.jagex.oldscape.pub.RefreshAccessTokenResponse;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSClient;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Future;

@Implements("Client")
@ObfuscatedName("client")
public final class Client extends GameEngine implements Usernamed, OAuthApi, class322 {

	boolean shouldProcessClick(){
		return false;
	}
	@ObfuscatedName("vg")
	@Export("viewportOffsetX")
	static int viewportOffsetX;
	@ObfuscatedName("vr")
	@Export("viewportOffsetY")
	static int viewportOffsetY;
	@ObfuscatedName("wi")
	public static int field369;
	@ObfuscatedName("wv")
	@ObfuscatedSignature(
		descriptor = "Liy;"
	)
	static final class229 field654;
	@ObfuscatedName("xl")
	@ObfuscatedSignature(
		descriptor = "Lcm;"
	)
	static final ApproximateRouteStrategy field651;
	@ObfuscatedName("xn")
	static int[] field592;
	@ObfuscatedName("xf")
	static int[] field591;
	@ObfuscatedName("wl")
	static int field546;
	@ObfuscatedName("wk")
	@ObfuscatedSignature(
		descriptor = "[Low;"
	)
	@Export("grandExchangeOffers")
	static GrandExchangeOffer[] grandExchangeOffers;
	@ObfuscatedName("wq")
	@ObfuscatedSignature(
		descriptor = "Lnb;"
	)
	@Export("playerAppearance")
	static PlayerComposition playerAppearance;
	@ObfuscatedName("ww")
	static int field547;
	@ObfuscatedName("xe")
	@Export("archiveLoaders")
	static ArrayList archiveLoaders;
	@ObfuscatedName("xd")
	@Export("archiveLoadersDone")
	static int archiveLoadersDone;
	@ObfuscatedName("xi")
	static int field549;
	@ObfuscatedName("wr")
	@ObfuscatedSignature(
		descriptor = "Lsz;"
	)
	static class487 field645;
	@ObfuscatedName("vt")
	static short field640;
	@ObfuscatedName("vd")
	static short field636;
	@ObfuscatedName("vp")
	static short field638;
	@ObfuscatedName("vb")
	static short field634;
	@ObfuscatedName("vk")
	static short field637;
	@ObfuscatedName("vn")
	@Export("viewportZoom")
	static int viewportZoom;
	@ObfuscatedName("vs")
	static short field639;
	@ObfuscatedName("vu")
	@Export("viewportWidth")
	static int viewportWidth;
	@ObfuscatedName("vm")
	@Export("viewportHeight")
	static int viewportHeight;
	@ObfuscatedName("vi")
	@Export("cameraShaking")
	static boolean[] cameraShaking;
	@ObfuscatedName("vo")
	@Export("cameraShakeIntensity")
	static int[] cameraShakeIntensity;
	@ObfuscatedName("va")
	@Export("cameraMoveIntensity")
	static int[] cameraMoveIntensity;
	@ObfuscatedName("vy")
	@Export("cameraShakeSpeed")
	static int[] cameraShakeSpeed;
	@ObfuscatedName("vw")
	static int[] field589;
	@ObfuscatedName("vc")
	@Export("zoomHeight")
	static short zoomHeight;
	@ObfuscatedName("vx")
	@Export("zoomWidth")
	static short zoomWidth;
	@ObfuscatedName("wf")
	static List field607;
	@ObfuscatedName("wc")
	@ObfuscatedSignature(
		descriptor = "Lcn;"
	)
	@Export("GrandExchangeEvents_worldComparator")
	static GrandExchangeOfferOwnWorldComparator GrandExchangeEvents_worldComparator;
	@ObfuscatedName("wb")
	@ObfuscatedSignature(
		descriptor = "Llk;"
	)
	@Export("archive11")
	static EvictingDualNodeHashTable archive11;
	@ObfuscatedName("wm")
	@ObfuscatedSignature(
		descriptor = "Llk;"
	)
	@Export("Widget_cachedModels")
	static EvictingDualNodeHashTable Widget_cachedModels;
	@ObfuscatedName("wh")
	static int field545;
	@ObfuscatedName("wo")
	@ObfuscatedSignature(
		descriptor = "Lqc;"
	)
	static class435 field631;
	@ObfuscatedName("br")
	@Export("lockMouseRecorder")
	static boolean lockMouseRecorder;
	@ObfuscatedName("bq")
	@Export("worldId")
	public static int worldId;
	@ObfuscatedName("cf")
	@Export("worldProperties")
	static int worldProperties;
	@ObfuscatedName("cv")
	@Export("gameBuild")
	static int gameBuild;
	@ObfuscatedName("ce")
	@Export("isMembersWorld")
	public static boolean isMembersWorld;
	@ObfuscatedName("ci")
	@Export("isLowDetail")
	static boolean isLowDetail;
	@ObfuscatedName("cs")
	@Export("param21")
	static int param21;
	@ObfuscatedName("co")
	@Export("clientType")
	static int clientType;
	@ObfuscatedName("cm")
	static int field424;
	@ObfuscatedName("cn")
	@Export("onMobile")
	static boolean onMobile;
	@ObfuscatedName("cr")
	@Export("param25")
	public static int param25;
	@ObfuscatedName("di")
	@Export("gameState")
	static int gameState;
	@ObfuscatedName("dk")
	@Export("reloadJS5")
	static boolean reloadJS5;
	@ObfuscatedName("ec")
	@Export("isLoading")
	static boolean isLoading;
	@ObfuscatedName("ew")
	@Export("cycle")
	static int cycle;
	@ObfuscatedName("ex")
	@Export("mouseLastLastPressedTimeMillis")
	static long mouseLastLastPressedTimeMillis;
	@ObfuscatedName("ek")
	@Export("lastMouseRecordX")
	static int lastMouseRecordX;
	@ObfuscatedName("em")
	@Export("lastMouseRecordY")
	static int lastMouseRecordY;
	@ObfuscatedName("eo")
	static long field610;
	@ObfuscatedName("ef")
	@Export("hadFocus")
	static boolean hadFocus;
	@ObfuscatedName("el")
	@Export("rebootTimer")
	static int rebootTimer;
	@ObfuscatedName("es")
	@Export("hintArrowType")
	static int hintArrowType;
	@ObfuscatedName("ea")
	@Export("hintArrowNpcIndex")
	static int hintArrowNpcIndex;
	@ObfuscatedName("en")
	@Export("hintArrowPlayerIndex")
	static int hintArrowPlayerIndex;
	@ObfuscatedName("eh")
	@Export("hintArrowX")
	static int hintArrowX;
	@ObfuscatedName("ei")
	@Export("hintArrowY")
	static int hintArrowY;
	@ObfuscatedName("et")
	@Export("hintArrowHeight")
	static int hintArrowHeight;
	@ObfuscatedName("er")
	@Export("hintArrowSubX")
	static int hintArrowSubX;
	@ObfuscatedName("ez")
	@Export("hintArrowSubY")
	static int hintArrowSubY;
	@ObfuscatedName("eg")
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
	@ObfuscatedName("ed")
	@Export("renderSelf")
	static boolean renderSelf;
	@ObfuscatedName("fe")
	@ObfuscatedSignature(
		descriptor = "Lda;"
	)
	static class92 field414;
	@ObfuscatedName("fr")
	@Export("js5ConnectState")
	static int js5ConnectState;
	@ObfuscatedName("fi")
	@Export("js5Cycles")
	static int js5Cycles;
	@ObfuscatedName("gp")
	@Export("js5Errors")
	static int js5Errors;
	@ObfuscatedName("gn")
	@Export("loginState")
	static int loginState;
	@ObfuscatedName("gb")
	static int field444;
	@ObfuscatedName("gu")
	static int field447;
	@ObfuscatedName("ga")
	static int field443;
	@ObfuscatedName("gf")
	@ObfuscatedSignature(
		descriptor = "Leb;"
	)
	static class124 field419;
	@ObfuscatedName("gx")
	@ObfuscatedSignature(
		descriptor = "Lus;"
	)
	static class531 field648;
	@ObfuscatedName("hc")
	static final String field656;
	@ObfuscatedName("ha")
	static final String field655;
	@ObfuscatedName("hn")
	@Export("Login_isUsernameRemembered")
	static boolean Login_isUsernameRemembered;
	@ObfuscatedName("ic")
	@ObfuscatedSignature(
		descriptor = "Lcd;"
	)
	@Export("secureRandomFuture")
	static SecureRandomFuture secureRandomFuture;
	@ObfuscatedName("ib")
	@Export("randomDatData")
	static byte[] randomDatData;
	@ObfuscatedName("iq")
	@ObfuscatedSignature(
		descriptor = "[Ldn;"
	)
	@Export("npcs")
	static NPC[] npcs;
	@ObfuscatedName("ia")
	@Export("npcCount")
	static int npcCount;
	@ObfuscatedName("iu")
	@Export("npcIndices")
	static int[] npcIndices;
	@ObfuscatedName("ij")
	static int field449;
	@ObfuscatedName("il")
	static int[] field550;
	@ObfuscatedName("it")
	static String field597;
	@ObfuscatedName("ig")
	@ObfuscatedSignature(
		descriptor = "Lef;"
	)
	@Export("packetWriter")
	public static final PacketWriter packetWriter;
	@ObfuscatedName("ip")
	@Export("logoutTimer")
	static int logoutTimer;
	@ObfuscatedName("ii")
	@Export("hadNetworkError")
	static boolean hadNetworkError;
	@ObfuscatedName("ik")
	@ObfuscatedSignature(
		descriptor = "Lqn;"
	)
	@Export("timer")
	static Timer timer;
	@ObfuscatedName("jf")
	@Export("fontsMap")
	static HashMap fontsMap;
	@ObfuscatedName("jm")
	static int field452;
	@ObfuscatedName("jy")
	static int field455;
	@ObfuscatedName("js")
	static int field453;
	@ObfuscatedName("ju")
	static int field454;
	@ObfuscatedName("jk")
	static int field451;
	@ObfuscatedName("jx")
	@ObfuscatedSignature(
		descriptor = "[Liw;"
	)
	@Export("collisionMaps")
	static CollisionMap[] collisionMaps;
	@ObfuscatedName("ja")
	@Export("isInInstance")
	static boolean isInInstance;
	@ObfuscatedName("jt")
	@Export("instanceChunkTemplates")
	static int[][][] instanceChunkTemplates;
	@ObfuscatedName("kj")
	static final int[] field652;
	@ObfuscatedName("ks")
	static int field460;
	@ObfuscatedName("kw")
	static int field461;
	@ObfuscatedName("kg")
	static int field458;
	@ObfuscatedName("kl")
	static int field459;
	@ObfuscatedName("kc")
	static int field457;
	@ObfuscatedName("ka")
	static boolean field382;
	@ObfuscatedName("kb")
	@Export("alternativeScrollbarWidth")
	static int alternativeScrollbarWidth;
	@ObfuscatedName("lw")
	@Export("camAngleX")
	static int camAngleX;
	@ObfuscatedName("lj")
	@Export("camAngleY")
	static int camAngleY;
	@ObfuscatedName("le")
	@Export("camAngleDY")
	static int camAngleDY;
	@ObfuscatedName("lm")
	@Export("camAngleDX")
	static int camAngleDX;
	@ObfuscatedName("lz")
	static int field478;
	@ObfuscatedName("lc")
	static int field464;
	@ObfuscatedName("lb")
	@Export("oculusOrbState")
	static int oculusOrbState;
	@ObfuscatedName("lr")
	@Export("camFollowHeight")
	static int camFollowHeight;
	@ObfuscatedName("ll")
	static int field471;
	@ObfuscatedName("la")
	static int field462;
	@ObfuscatedName("lx")
	static int field477;
	@ObfuscatedName("lh")
	@Export("oculusOrbNormalSpeed")
	static int oculusOrbNormalSpeed;
	@ObfuscatedName("li")
	@Export("oculusOrbSlowedSpeed")
	static int oculusOrbSlowedSpeed;
	@ObfuscatedName("lq")
	public static int field367;
	@ObfuscatedName("ly")
	@Export("oculusOrbOnLocalPlayer")
	static boolean oculusOrbOnLocalPlayer;
	@ObfuscatedName("ld")
	@Export("packetIndicator")
	static int packetIndicator;
	@ObfuscatedName("lu")
	@Export("emitPackets")
	static boolean emitPackets;
	@ObfuscatedName("lo")
	static int field473;
	@ObfuscatedName("lg")
	@Export("overheadTextLimit")
	static int overheadTextLimit;
	@ObfuscatedName("lt")
	@Export("overheadTextCount")
	static int overheadTextCount;
	@ObfuscatedName("mb")
	@Export("overheadTextXs")
	static int[] overheadTextXs;
	@ObfuscatedName("md")
	@Export("overheadTextYs")
	static int[] overheadTextYs;
	@ObfuscatedName("my")
	@Export("overheadTextAscents")
	static int[] overheadTextAscents;
	@ObfuscatedName("mk")
	@Export("overheadTextXOffsets")
	static int[] overheadTextXOffsets;
	@ObfuscatedName("mi")
	@Export("overheadTextColors")
	static int[] overheadTextColors;
	@ObfuscatedName("mn")
	@Export("overheadTextEffects")
	static int[] overheadTextEffects;
	@ObfuscatedName("mx")
	static int[][] field594;
	@ObfuscatedName("mv")
	@Export("overheadTextCyclesRemaining")
	static int[] overheadTextCyclesRemaining;
	@ObfuscatedName("mm")
	static String[] field601;
	@ObfuscatedName("mq")
	@Export("tileLastDrawnActor")
	static int[][] tileLastDrawnActor;
	@ObfuscatedName("mf")
	@Export("viewportDrawCount")
	static int viewportDrawCount;
	@ObfuscatedName("mo")
	@Export("viewportTempX")
	static int viewportTempX;
	@ObfuscatedName("mj")
	@Export("viewportTempY")
	static int viewportTempY;
	@ObfuscatedName("ms")
	@Export("mouseCrossX")
	static int mouseCrossX;
	@ObfuscatedName("mw")
	@Export("mouseCrossY")
	static int mouseCrossY;
	@ObfuscatedName("mu")
	@Export("mouseCrossState")
	static int mouseCrossState;
	@ObfuscatedName("mt")
	@Export("mouseCrossColor")
	static int mouseCrossColor;
	@ObfuscatedName("ml")
	@Export("showMouseCross")
	static boolean showMouseCross;
	@ObfuscatedName("ma")
	static int field479;
	@ObfuscatedName("mg")
	@Export("showLoadingMessages")
	static boolean showLoadingMessages;
	@ObfuscatedName("mc")
	@ObfuscatedSignature(
		descriptor = "[Lds;"
	)
	@Export("players")
	static Player[] players;
	@ObfuscatedName("mp")
	@Export("localPlayerIndex")
	static int localPlayerIndex;
	@ObfuscatedName("mz")
	@Export("isMembers")
	static int isMembers;
	@ObfuscatedName("nd")
	@Export("playerUUID")
	static long playerUUID;
	@ObfuscatedName("nb")
	static boolean field387;
	@ObfuscatedName("np")
	@Export("drawPlayerNames")
	static int drawPlayerNames;
	@ObfuscatedName("nc")
	static int field489;
	@ObfuscatedName("na")
	static int[] field559;
	@ObfuscatedName("nh")
	@Export("playerMenuOpcodes")
	static final int[] playerMenuOpcodes;
	@ObfuscatedName("ny")
	@Export("playerMenuActions")
	static String[] playerMenuActions;
	@ObfuscatedName("nu")
	@Export("playerOptionsPriorities")
	static boolean[] playerOptionsPriorities;
	@ObfuscatedName("nx")
	static int[] field563;
	@ObfuscatedName("nj")
	@Export("combatTargetPlayerIndex")
	static int combatTargetPlayerIndex;
	@ObfuscatedName("nf")
	@ObfuscatedSignature(
		descriptor = "[[[Lon;"
	)
	@Export("groundItems")
	static NodeDeque[][][] groundItems;
	@ObfuscatedName("nk")
	@ObfuscatedSignature(
		descriptor = "Lon;"
	)
	@Export("pendingSpawns")
	static NodeDeque pendingSpawns;
	@ObfuscatedName("ns")
	@ObfuscatedSignature(
		descriptor = "Lon;"
	)
	@Export("projectiles")
	static NodeDeque projectiles;
	@ObfuscatedName("nm")
	@ObfuscatedSignature(
		descriptor = "Lon;"
	)
	@Export("graphicsObjects")
	static NodeDeque graphicsObjects;
	@ObfuscatedName("nv")
	@Export("currentLevels")
	static int[] currentLevels;
	@ObfuscatedName("nt")
	@Export("levels")
	static int[] levels;
	@ObfuscatedName("ne")
	@Export("experience")
	static int[] experience;
	@ObfuscatedName("nz")
	static int[] field564;
	@ObfuscatedName("nl")
	@Export("leftClickOpensMenu")
	static boolean leftClickOpensMenu;
	@ObfuscatedName("nr")
	@Export("isMenuOpen")
	static boolean isMenuOpen;
	@ObfuscatedName("oy")
	@Export("menuOptionsCount")
	static int menuOptionsCount;
	@ObfuscatedName("ol")
	@Export("menuArguments1")
	static int[] menuArguments1;
	@ObfuscatedName("oz")
	@Export("menuArguments2")
	static int[] menuArguments2;
	@ObfuscatedName("ov")
	@Export("menuOpcodes")
	static int[] menuOpcodes;
	@ObfuscatedName("oq")
	@Export("menuIdentifiers")
	static int[] menuIdentifiers;
	@ObfuscatedName("oo")
	@Export("menuItemIds")
	static int[] menuItemIds;
	@ObfuscatedName("oa")
	@Export("menuActions")
	static String[] menuActions;
	@ObfuscatedName("ou")
	@Export("menuTargets")
	static String[] menuTargets;
	@ObfuscatedName("om")
	@Export("menuShiftClick")
	static boolean[] menuShiftClick;
	@ObfuscatedName("og")
	@Export("followerOpsLowPriority")
	static boolean followerOpsLowPriority;
	@ObfuscatedName("ob")
	@Export("tapToDrop")
	static boolean tapToDrop;
	@ObfuscatedName("os")
	@Export("showMouseOverText")
	static boolean showMouseOverText;
	@ObfuscatedName("ot")
	@Export("viewportX")
	static int viewportX;
	@ObfuscatedName("oj")
	@Export("viewportY")
	static int viewportY;
	@ObfuscatedName("oe")
	static int field493;
	@ObfuscatedName("od")
	static int field492;
	@ObfuscatedName("on")
	@Export("isItemSelected")
	static int isItemSelected;
	@ObfuscatedName("pm")
	@Export("isSpellSelected")
	static boolean isSpellSelected;
	@ObfuscatedName("ph")
	@Export("selectedSpellChildIndex")
	static int selectedSpellChildIndex;
	@ObfuscatedName("po")
	@Export("selectedSpellItemId")
	static int selectedSpellItemId;
	@ObfuscatedName("pp")
	static String field599;
	@ObfuscatedName("pb")
	static String field598;
	@ObfuscatedName("pl")
	@Export("rootInterface")
	static int rootInterface;
	@ObfuscatedName("pz")
	@ObfuscatedSignature(
		descriptor = "Ltw;"
	)
	@Export("interfaceParents")
	static NodeHashTable interfaceParents;
	@ObfuscatedName("ps")
	static int field505;
	@ObfuscatedName("pf")
	static int field499;
	@ObfuscatedName("pv")
	@Export("chatEffects")
	static int chatEffects;
	@ObfuscatedName("px")
	@ObfuscatedSignature(
		descriptor = "Lnn;"
	)
	@Export("meslayerContinueWidget")
	static Widget meslayerContinueWidget;
	@ObfuscatedName("pn")
	@Export("runEnergy")
	static int runEnergy;
	@ObfuscatedName("pa")
	@Export("weight")
	static int weight;
	@ObfuscatedName("pd")
	@Export("staffModLevel")
	public static int staffModLevel;
	@ObfuscatedName("pj")
	@Export("followerIndex")
	static int followerIndex;
	@ObfuscatedName("pi")
	@Export("playerMod")
	static boolean playerMod;
	@ObfuscatedName("pq")
	@ObfuscatedSignature(
		descriptor = "Lnn;"
	)
	@Export("viewportWidget")
	static Widget viewportWidget;
	@ObfuscatedName("pt")
	@ObfuscatedSignature(
		descriptor = "Lnn;"
	)
	@Export("clickedWidget")
	static Widget clickedWidget;
	@ObfuscatedName("py")
	@ObfuscatedSignature(
		descriptor = "Lnn;"
	)
	@Export("clickedWidgetParent")
	static Widget clickedWidgetParent;
	@ObfuscatedName("qb")
	@Export("widgetClickX")
	static int widgetClickX;
	@ObfuscatedName("qt")
	@Export("widgetClickY")
	static int widgetClickY;
	@ObfuscatedName("ql")
	@ObfuscatedSignature(
		descriptor = "Lnn;"
	)
	@Export("draggedOnWidget")
	static Widget draggedOnWidget;
	@ObfuscatedName("qu")
	static boolean field396;
	@ObfuscatedName("qo")
	static int field512;
	@ObfuscatedName("qp")
	static int field513;
	@ObfuscatedName("qy")
	static boolean field397;
	@ObfuscatedName("qq")
	static int field514;
	@ObfuscatedName("qd")
	static int field508;
	@ObfuscatedName("qn")
	@Export("isDraggingWidget")
	static boolean isDraggingWidget;
	@ObfuscatedName("qr")
	@Export("cycleCntr")
	static int cycleCntr;
	@ObfuscatedName("qm")
	@Export("changedVarps")
	static int[] changedVarps;
	@ObfuscatedName("qv")
	@Export("changedVarpCount")
	static int changedVarpCount;
	@ObfuscatedName("qc")
	@Export("changedItemContainers")
	static int[] changedItemContainers;
	@ObfuscatedName("qe")
	@Export("changedItemContainersCount")
	static int changedItemContainersCount;
	@ObfuscatedName("qs")
	@Export("changedSkills")
	static int[] changedSkills;
	@ObfuscatedName("qz")
	@Export("changedSkillsCount")
	static int changedSkillsCount;
	@ObfuscatedName("qh")
	static int[] field571;
	@ObfuscatedName("qi")
	static int field510;
	@ObfuscatedName("qk")
	@Export("chatCycle")
	static int chatCycle;
	@ObfuscatedName("rm")
	static int field524;
	@ObfuscatedName("rp")
	static int field526;
	@ObfuscatedName("rf")
	static int field520;
	@ObfuscatedName("rn")
	static int field525;
	@ObfuscatedName("rc")
	static int field519;
	@ObfuscatedName("rr")
	static int field527;
	@ObfuscatedName("rh")
	static int field522;
	@ObfuscatedName("ra")
	@ObfuscatedSignature(
		descriptor = "Lrx;"
	)
	@Export("varclan")
	static class466 varclan;
	@ObfuscatedName("rg")
	@Export("mouseWheelRotation")
	static int mouseWheelRotation;
	@ObfuscatedName("rk")
	@ObfuscatedSignature(
		descriptor = "Lut;"
	)
	static class544 field649;
	@ObfuscatedName("rl")
	@ObfuscatedSignature(
		descriptor = "Lon;"
	)
	@Export("scriptEvents")
	static NodeDeque scriptEvents;
	@ObfuscatedName("rv")
	@ObfuscatedSignature(
		descriptor = "Lon;"
	)
	static NodeDeque field627;
	@ObfuscatedName("ry")
	@ObfuscatedSignature(
		descriptor = "Lon;"
	)
	static NodeDeque field628;
	@ObfuscatedName("rd")
	@ObfuscatedSignature(
		descriptor = "Lon;"
	)
	static NodeDeque field625;
	@ObfuscatedName("rb")
	@ObfuscatedSignature(
		descriptor = "Ltw;"
	)
	@Export("widgetFlags")
	static NodeHashTable widgetFlags;
	@ObfuscatedName("rz")
	@Export("rootWidgetCount")
	static int rootWidgetCount;
	@ObfuscatedName("rj")
	static int field523;
	@ObfuscatedName("ri")
	static boolean[] field407;
	@ObfuscatedName("ru")
	static boolean[] field408;
	@ObfuscatedName("rx")
	static boolean[] field409;
	@ObfuscatedName("rt")
	@Export("rootWidgetXs")
	static int[] rootWidgetXs;
	@ObfuscatedName("sg")
	@Export("rootWidgetYs")
	static int[] rootWidgetYs;
	@ObfuscatedName("sj")
	@Export("rootWidgetWidths")
	static int[] rootWidgetWidths;
	@ObfuscatedName("sr")
	@Export("rootWidgetHeights")
	static int[] rootWidgetHeights;
	@ObfuscatedName("sa")
	@Export("gameDrawingMode")
	static int gameDrawingMode;
	@ObfuscatedName("si")
	static long field613;
	@ObfuscatedName("sd")
	@Export("isResizable")
	static boolean isResizable;
	@ObfuscatedName("sn")
	static int[] field578;
	@ObfuscatedName("sw")
	@Export("publicChatMode")
	static int publicChatMode;
	@ObfuscatedName("sy")
	@Export("tradeChatMode")
	static int tradeChatMode;
	@ObfuscatedName("sh")
	static String field600;
	@ObfuscatedName("sb")
	static long[] field615;
	@ObfuscatedName("sz")
	static int field533;
	@ObfuscatedName("sp")
	@ObfuscatedSignature(
		descriptor = "Lil;"
	)
	@Export("keyHandlerInstance")
	public static class223 keyHandlerInstance;
	@ObfuscatedName("sf")
	@ObfuscatedSignature(
		descriptor = "Lij;"
	)
	static class221 field422;
	@ObfuscatedName("sq")
	static int field530;
	@ObfuscatedName("so")
	static int[] field579;
	@ObfuscatedName("sl")
	static int[] field577;
	@ObfuscatedName("tn")
	@Export("timeOfPreviousKeyPress")
	static long timeOfPreviousKeyPress;
	@ObfuscatedName("tp")
	@ObfuscatedSignature(
		descriptor = "[Lfc;"
	)
	@Export("currentClanSettings")
	static ClanSettings[] currentClanSettings;
	@ObfuscatedName("tw")
	@ObfuscatedSignature(
		descriptor = "[Lgn;"
	)
	@Export("currentClanChannels")
	static ClanChannel[] currentClanChannels;
	@ObfuscatedName("tq")
	static int field535;
	@ObfuscatedName("ts")
	@Export("mapIconCount")
	static int mapIconCount;
	@ObfuscatedName("tt")
	@Export("mapIconXs")
	static int[] mapIconXs;
	@ObfuscatedName("tg")
	@Export("mapIconYs")
	static int[] mapIconYs;
	@ObfuscatedName("to")
	@ObfuscatedSignature(
		descriptor = "[Luz;"
	)
	@Export("mapIcons")
	static SpritePixels[] mapIcons;
	@ObfuscatedName("tr")
	@Export("destinationX")
	static int destinationX;
	@ObfuscatedName("tx")
	@Export("destinationY")
	static int destinationY;
	@ObfuscatedName("ta")
	@Export("minimapState")
	static int minimapState;
	@ObfuscatedName("tj")
	@Export("playingJingle")
	static boolean playingJingle;
	@ObfuscatedName("ue")
	@Export("soundEffectCount")
	static int soundEffectCount;
	@ObfuscatedName("ug")
	@Export("soundEffectIds")
	static int[] soundEffectIds;
	@ObfuscatedName("ui")
	@Export("queuedSoundEffectLoops")
	static int[] queuedSoundEffectLoops;
	@ObfuscatedName("uv")
	@Export("queuedSoundEffectDelays")
	static int[] queuedSoundEffectDelays;
	@ObfuscatedName("uo")
	@Export("soundLocations")
	static int[] soundLocations;
	@ObfuscatedName("uj")
	@ObfuscatedSignature(
		descriptor = "[Lbo;"
	)
	@Export("soundEffects")
	static SoundEffect[] soundEffects;
	@ObfuscatedName("uq")
	@Export("isCameraLocked")
	static boolean isCameraLocked;
	@ObfuscatedName("ur")
	static boolean field402;
	@ObfuscatedName("ux")
	static boolean field404;
	@ObfuscatedName("uw")
	static boolean field403;
	@ObfuscatedName("ub")
	@ObfuscatedSignature(
		descriptor = "Lsq;"
	)
	static class491 field644;
	@ObfuscatedName("uy")
	@ObfuscatedSignature(
		descriptor = "Lsm;"
	)
	static class490 field643;
	@ObfuscatedName("ut")
	@ObfuscatedSignature(
		descriptor = "Lsm;"
	)
	static class490 field642;
	@ObfuscatedName("un")
	static boolean field400;
	@ObfuscatedName("hb")
	String field665;
	@ObfuscatedName("hp")
	@ObfuscatedSignature(
		descriptor = "Lay;"
	)
	class14 field660;
	@ObfuscatedName("hl")
	@ObfuscatedSignature(
		descriptor = "Laq;"
	)
	class18 field659;
	@ObfuscatedName("hi")
	@ObfuscatedSignature(
		descriptor = "Lcom/jagex/oldscape/pub/OtlTokenRequester;"
	)
	OtlTokenRequester field662;
	@ObfuscatedName("hq")
	Future field667;
	@ObfuscatedName("hf")
	boolean field661;
	@ObfuscatedName("hw")
	int field664;
	@ObfuscatedName("hj")
	@ObfuscatedSignature(
		descriptor = "Laq;"
	)
	class18 field658;
	@ObfuscatedName("hg")
	@ObfuscatedSignature(
		descriptor = "Lcom/jagex/oldscape/pub/RefreshAccessTokenRequester;"
	)
	RefreshAccessTokenRequester field663;
	@ObfuscatedName("hk")
	Future field666;
	@ObfuscatedName("if")
	@ObfuscatedSignature(
		descriptor = "Luj;"
	)
	Buffer field669;
	@ObfuscatedName("is")
	@ObfuscatedSignature(
		descriptor = "Lac;"
	)
	class7 field657;
	@ObfuscatedName("im")
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
		param25 = 218;
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
		field414 = class92.field942;
		js5ConnectState = 0;
		js5Cycles = 0;
		js5Errors = 0;
		loginState = 0;
		field444 = 0;
		field447 = 0;
		field443 = 0;
		field419 = class124.field1207;
		field648 = class531.field4234;
		int var1 = "com_jagex_auth_desktop_osrs:public".length();
		byte[] var2 = new byte[var1];

		int var3;
		char var4;
		for (var3 = 0; var3 < var1; ++var3) {
			var4 = "com_jagex_auth_desktop_osrs:public".charAt(var3);
			if (var4 > 127) {
				var2[var3] = 63;
			} else {
				var2[var3] = (byte)var4;
			}
		}

		field656 = class415.method2150(var2);
		var1 = "com_jagex_auth_desktop_runelite:public".length();
		var2 = new byte[var1];

		for (var3 = 0; var3 < var1; ++var3) {
			var4 = "com_jagex_auth_desktop_runelite:public".charAt(var3);
			if (var4 > 127) {
				var2[var3] = 63;
			} else {
				var2[var3] = (byte)var4;
			}
		}

		field655 = class415.method2150(var2);
		Login_isUsernameRemembered = false;
		secureRandomFuture = new SecureRandomFuture();
		randomDatData = null;
		npcs = new NPC[65536];
		npcCount = 0;
		npcIndices = new int[65536];
		field449 = 0;
		field550 = new int[250];
		packetWriter = new PacketWriter();
		logoutTimer = 0;
		hadNetworkError = false;
		timer = new Timer();
		fontsMap = new HashMap();
		field452 = 0;
		field455 = 1;
		field453 = 0;
		field454 = 1;
		field451 = 0;
		collisionMaps = new CollisionMap[4];
		isInInstance = false;
		instanceChunkTemplates = new int[4][13][13];
		field652 = new int[]{0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3};
		field460 = 0;
		field461 = 2301979;
		field458 = 5063219;
		field459 = 3353893;
		field457 = 7759444;
		field382 = false;
		alternativeScrollbarWidth = 0;
		camAngleX = 128;
		camAngleY = 0;
		camAngleDY = 0;
		camAngleDX = 0;
		field478 = 0;
		field464 = 0;
		oculusOrbState = 0;
		camFollowHeight = 50;
		field471 = 0;
		field462 = 0;
		field477 = 0;
		oculusOrbNormalSpeed = 12;
		oculusOrbSlowedSpeed = 6;
		field367 = 0;
		oculusOrbOnLocalPlayer = false;
		packetIndicator = 0;
		emitPackets = false;
		field473 = 0;
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
		field601 = new String[overheadTextCount];
		tileLastDrawnActor = new int[104][104];
		viewportDrawCount = 0;
		viewportTempX = -1;
		viewportTempY = -1;
		mouseCrossX = 0;
		mouseCrossY = 0;
		mouseCrossState = 0;
		mouseCrossColor = 0;
		showMouseCross = true;
		field479 = 0;
		showLoadingMessages = true;
		players = new Player[2048];
		localPlayerIndex = -1;
		isMembers = 0;
		playerUUID = -1L;
		field387 = true;
		drawPlayerNames = 0;
		field489 = 0;
		field559 = new int[1000];
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
		field564 = new int[25];
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
		field493 = 0;
		field492 = 50;
		isItemSelected = 0;
		field597 = null;
		isSpellSelected = false;
		selectedSpellChildIndex = -1;
		selectedSpellItemId = -1;
		field599 = null;
		field598 = null;
		rootInterface = -1;
		interfaceParents = new NodeHashTable(8);
		field505 = 0;
		field499 = -1;
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
		field512 = -1;
		field513 = -1;
		field397 = false;
		field514 = -1;
		field508 = -1;
		isDraggingWidget = false;
		cycleCntr = 1;
		changedVarps = new int[32];
		changedVarpCount = 0;
		changedItemContainers = new int[32];
		changedItemContainersCount = 0;
		changedSkills = new int[32];
		changedSkillsCount = 0;
		field571 = new int[32];
		field510 = 0;
		chatCycle = 0;
		field524 = 0;
		field526 = 0;
		field520 = 0;
		field525 = 0;
		field519 = 0;
		field527 = 0;
		field522 = 0;
		mouseWheelRotation = 0;
		field649 = new class544();
		scriptEvents = new NodeDeque();
		field627 = new NodeDeque();
		field628 = new NodeDeque();
		field625 = new NodeDeque();
		widgetFlags = new NodeHashTable(512);
		rootWidgetCount = 0;
		field523 = -2;
		field407 = new boolean[100];
		field408 = new boolean[100];
		field409 = new boolean[100];
		rootWidgetXs = new int[100];
		rootWidgetYs = new int[100];
		rootWidgetWidths = new int[100];
		rootWidgetHeights = new int[100];
		gameDrawingMode = 0;
		field613 = 0L;
		isResizable = true;
		field578 = new int[]{16776960, 16711680, 65280, 65535, 16711935, 16777215};
		publicChatMode = 0;
		tradeChatMode = 0;
		field600 = "";
		field615 = new long[100];
		field533 = 0;
		keyHandlerInstance = new class223();
		field422 = new class221();
		field530 = 0;
		field579 = new int[128];
		field577 = new int[128];
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
		field402 = false;
		field404 = false;
		field403 = false;
		field644 = null;
		field643 = null;
		field642 = null;
		field400 = false;
		cameraShaking = new boolean[5];
		cameraShakeIntensity = new int[5];
		cameraMoveIntensity = new int[5];
		cameraShakeSpeed = new int[5];
		field589 = new int[5];
		field640 = 256;
		field636 = 205;
		zoomHeight = 256;
		zoomWidth = 320;
		field639 = 1;
		field637 = 32767;
		field638 = 1;
		field634 = 32767;
		viewportOffsetX = 0;
		viewportOffsetY = 0;
		viewportWidth = 0;
		viewportHeight = 0;
		viewportZoom = 0;
		playerAppearance = new PlayerComposition();
		field546 = -1;
		field547 = -1;
		field645 = new DesktopPlatformInfoProvider();
		grandExchangeOffers = new GrandExchangeOffer[8];
		GrandExchangeEvents_worldComparator = new GrandExchangeOfferOwnWorldComparator();
		field631 = new class435(8, class433.field3801);
		Widget_cachedModels = new EvictingDualNodeHashTable(64);
		archive11 = new EvictingDualNodeHashTable(64);
		field545 = -1;
		field369 = -1;
		field607 = new ArrayList();
		field654 = new class229();
		archiveLoaders = new ArrayList(10);
		archiveLoadersDone = 0;
		field549 = 0;
		field651 = new ApproximateRouteStrategy();
		field592 = new int[50];
		field591 = new int[50];
	}

	public Client() {
		this.field661 = false;
		this.field664 = 0;
		this.field668 = -1L;
	}

	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "101"
	)
	@Export("resizeGame")
	protected final void resizeGame() {
		field613 = SpotAnimationDefinition.method962() + 500L;
		this.resizeJS();
		if (rootInterface != -1) {
			this.method389(true);
		}

	}

	@ObfuscatedName("bm")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-550390769"
	)
	@Export("setUp")
	protected final void setUp() {
		class4.method5(new int[]{20, 260, 10000}, new int[]{1000, 100, 500});
		WorldMapCacheName.worldPort = gameBuild == 0 ? 43594 : worldId + 40000;
		AbstractSocket.js5Port = gameBuild == 0 ? 443 : worldId + 50000;
		class252.currentPort = WorldMapCacheName.worldPort;
		WorldMapLabelSize.field1939 = class342.field2973;
		class90.field892 = class342.field2974;
		class503.field4091 = class342.field2972;
		PlayerComposition.field2935 = class342.field2975;
		class60.urlRequester = new class113(this.field661, 218);
		this.setUpKeyboard();
		this.method155();
		class396.mouseWheel = this.mouseWheel();
		this.method154(field422, 0);
		this.method154(keyHandlerInstance, 1);
		this.setUpClipboard();
		class302.field2511 = new ArchiveDisk(255, JagexCache.JagexCache_dat2File, JagexCache.JagexCache_idx255File, 500000);
		AccessFile var2 = null;
		ClientPreferences var3 = new ClientPreferences();

		try {
			var2 = class131.getPreferencesFile("", Messages.field1156.name, false);
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

		WorldMapIcon_1.clientPreferences = var3;
		class27.method112(this, class14.field44);
		class9.setWindowedMode(WorldMapIcon_1.clientPreferences.method563());
		class12.friendSystem = new FriendSystem(class89.loginType);
		this.field660 = new class14("tokenRequest", 1, 1);
		if (!class316.field2793.contains(this)) {
			class316.field2793.add(this);
		}

		field654.method1169();
	}

	@ObfuscatedName("bp")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "564244601"
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
				boolean var5 = class516.method2513();
				if (var5 && playingJingle && MusicPatchPcmStream.pcmPlayer1 != null) {
					MusicPatchPcmStream.pcmPlayer1.tryDiscard();
				}

				class102.method604();
				keyHandlerInstance.method1127();
				this.method153();
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

				if (class396.mouseWheel != null) {
					int var6 = class396.mouseWheel.useRotation();
					mouseWheelRotation = var6;
				}

				if (gameState == 0) {
					WorldMapCacheName.method1354();
					WorldMapManager.method1277();
				} else if (gameState == 5) {
					Actor.method516(this, class369.fontPlain11, ItemLayer.fontPlain12);
					WorldMapCacheName.method1354();
					WorldMapManager.method1277();
				} else if (gameState != 10 && gameState != 11) {
					if (gameState == 20) {
						Actor.method516(this, class369.fontPlain11, ItemLayer.fontPlain12);
						this.doCycleLoggedOut();
					} else if (gameState == 50) {
						Actor.method516(this, class369.fontPlain11, ItemLayer.fontPlain12);
						this.doCycleLoggedOut();
					} else if (gameState == 25) {
						ModeWhere.method2002();
					}
				} else {
					Actor.method516(this, class369.fontPlain11, ItemLayer.fontPlain12);
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

	@ObfuscatedName("bw")
	@ObfuscatedSignature(
		descriptor = "(ZI)V",
		garbageValue = "-851092167"
	)
	@Export("draw")
	protected final void draw(boolean var1) {
		if ((gameState == 10 || gameState == 20 || gameState == 30) && field613 != 0L && SpotAnimationDefinition.method962() > field613) {
			class9.setWindowedMode(ApproximateRouteStrategy.getWindowedMode());
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
			UrlRequest.drawTitle(GrandExchangeOfferTotalQuantityComparator.fontBold12, class369.fontPlain11, ItemLayer.fontPlain12);
		} else if (gameState != 10 && gameState != 11) {
			if (gameState == 20) {
				UrlRequest.drawTitle(GrandExchangeOfferTotalQuantityComparator.fontBold12, class369.fontPlain11, ItemLayer.fontPlain12);
			} else if (gameState == 50) {
				UrlRequest.drawTitle(GrandExchangeOfferTotalQuantityComparator.fontBold12, class369.fontPlain11, ItemLayer.fontPlain12);
			} else if (gameState == 25) {
				if (field451 == 1) {
					if (field452 > field455) {
						field455 = field452;
					}

					var2 = (field455 * 50 - field452 * 50) / field455;
					LoginPacket.drawLoadingMessage("Loading - please wait." + "<br>" + " (" + var2 + "%" + ")", false);
				} else if (field451 == 2) {
					if (field453 > field454) {
						field454 = field453;
					}

					var2 = (field454 * 50 - field453 * 50) / field454 + 50;
					LoginPacket.drawLoadingMessage("Loading - please wait." + "<br>" + " (" + var2 + "%" + ")", false);
				} else {
					LoginPacket.drawLoadingMessage("Loading - please wait.", false);
				}
			} else if (gameState == 30) {
				this.drawLoggedIn();
			} else if (gameState == 40) {
				LoginPacket.drawLoadingMessage("Connection lost" + "<br>" + "Please wait - attempting to reestablish", false);
			} else if (gameState == 45) {
				LoginPacket.drawLoadingMessage("Please wait...", false);
			}
		} else {
			UrlRequest.drawTitle(GrandExchangeOfferTotalQuantityComparator.fontBold12, class369.fontPlain11, ItemLayer.fontPlain12);
		}

		if (gameState == 30 && gameDrawingMode == 0 && !var1 && !isResizable) {
			for (var2 = 0; var2 < rootWidgetCount; ++var2) {
				if (field408[var2]) {
					class338.rasterProvider.draw(rootWidgetXs[var2], rootWidgetYs[var2], rootWidgetWidths[var2], rootWidgetHeights[var2]);
					field408[var2] = false;
				}
			}
		} else if (gameState > 0) {
			class338.rasterProvider.drawFull(0, 0);

			for (var2 = 0; var2 < rootWidgetCount; ++var2) {
				field408[var2] = false;
			}
		}

	}

	@ObfuscatedName("bj")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "1863199463"
	)
	@Export("kill0")
	protected final void kill0() {
		if (class176.varcs.hasUnwrittenChanges()) {
			class176.varcs.write();
		}

		if (Message.mouseRecorder != null) {
			Message.mouseRecorder.isRunning = false;
		}

		Message.mouseRecorder = null;
		packetWriter.close();
		if (MouseHandler.MouseHandler_instance != null) {
			synchronized(MouseHandler.MouseHandler_instance) {
				MouseHandler.MouseHandler_instance = null;
			}
		}

		class396.mouseWheel = null;
		if (MusicPatchPcmStream.pcmPlayer1 != null) {
			MusicPatchPcmStream.pcmPlayer1.shutdown();
		}

		WorldMapSectionType.field2038.method1962();
		class227.method1164();
		if (class60.urlRequester != null) {
			class60.urlRequester.close();
			class60.urlRequester = null;
		}

		HealthBarDefinition.method916();
		this.field660.method56();
	}

	@ObfuscatedName("bc")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "-94"
	)
	@Export("vmethod1485")
	protected final void vmethod1485() {
	}

	@ObfuscatedName("gv")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "2071645038"
	)
	boolean method363() {
		return this.field664 == 1;
	}

	@ObfuscatedName("gc")
	@ObfuscatedSignature(
		descriptor = "(S)Z",
		garbageValue = "-22117"
	)
	boolean method364() {
		return Messages.field1155 != null && !Messages.field1155.trim().isEmpty() && ObjectComposition.field1664 != null && !ObjectComposition.field1664.trim().isEmpty();
	}

	@ObfuscatedName("gr")
	@ObfuscatedSignature(
		descriptor = "(B)Z",
		garbageValue = "74"
	)
	boolean method365() {
		return class369.field3560 != null && !class369.field3560.trim().isEmpty() && InterfaceParent.field862 != null && !InterfaceParent.field862.trim().isEmpty();
	}

	@ObfuscatedName("gk")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "-1304458364"
	)
	boolean method366() {
		return this.field662 != null;
	}

	@ObfuscatedName("go")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;I)V",
		garbageValue = "-191398087"
	)
	void method367(String var1) throws IOException {
		HashMap var2 = new HashMap();
		var2.put("grant_type", "refresh_token");
		var2.put("scope", "gamesso.token.create");
		var2.put("refresh_token", var1);
		URL var3 = new URL(class314.field2776 + "shield/oauth/token" + (new class475(var2)).method2361());
		class431 var4 = new class431();
		if (this.method363()) {
			var4.method2185(field655);
		} else {
			var4.method2185(field656);
		}

		var4.method2182("Host", (new URL(class314.field2776)).getHost());
		var4.method2189(class472.field3931);
		class9 var5 = class9.field22;
		RefreshAccessTokenRequester var6 = this.field663;
		if (var6 != null) {
			this.field666 = var6.request(var5.method24(), var3, var4.method2181(), "");
		} else {
			class10 var7 = new class10(var3, var5, var4, this.field661);
			this.field658 = this.field660.method54(var7);
		}
	}

	@ObfuscatedName("gh")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;B)V",
		garbageValue = "-43"
	)
	void method368(String var1) throws IOException {
		URL var2 = new URL(class314.field2776 + "public/v1/games/YCfdbvr2pM1zUYMxJRexZY/play");
		class431 var3 = new class431();
		var3.method2186(var1);
		class9 var4 = class9.field21;
		OtlTokenRequester var5 = this.field662;
		if (var5 != null) {
			this.field667 = var5.request(var4.method24(), var2, var3.method2181(), "");
		} else {
			class10 var6 = new class10(var2, var4, var3, this.field661);
			this.field659 = this.field660.method54(var6);
		}
	}

	@ObfuscatedName("gd")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;Ljava/lang/String;I)V",
		garbageValue = "169401816"
	)
	void method369(String var1, String var2) throws IOException, JSONException {
		URL var3 = new URL(FriendsChat.field3821 + "game-session/v1/tokens");
		class10 var4 = new class10(var3, class9.field22, this.field661);
		var4.method34().method2186(var1);
		var4.method34().method2189(class472.field3931);
		JSONObject var5 = new JSONObject();
		var5.method2727("accountId", var2);
		var4.method35(new class474(var5));
		this.field659 = this.field660.method54(var4);
	}

	@ObfuscatedName("hi")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "121204254"
	)
	@Export("doCycleJs5")
	void doCycleJs5() {
		if (gameState != 1000) {
			boolean var1 = WorldMapSectionType.field2038.method1953();
			if (!var1) {
				this.method375();
			}

		}
	}

	@ObfuscatedName("hq")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-1703369019"
	)
	void method375() {
		if (WorldMapSectionType.field2038.field3605 >= 4) {
			this.error("js5crc");
			WorldMapSection2.updateGameState(1000);
		} else {
			if (WorldMapSectionType.field2038.field3606 >= 4) {
				if (gameState <= 5) {
					this.error("js5io");
					WorldMapSection2.updateGameState(1000);
					return;
				}

				js5Cycles = 3000;
				WorldMapSectionType.field2038.field3606 = 3;
			}

			if (--js5Cycles + 1 <= 0) {
				try {
					if (js5ConnectState == 0) {
						class101.js5SocketTask = GameEngine.taskHandler.newSocketTask(Friend.worldHost, class252.currentPort);
						++js5ConnectState;
					}

					if (js5ConnectState == 1) {
						if (class101.js5SocketTask.status == 2) {
							this.js5Error(-1);
							return;
						}

						if (class101.js5SocketTask.status == 1) {
							++js5ConnectState;
						}
					}

					if (js5ConnectState == 2) {
						class167.js5Socket = WorldMapData_0.method1178((Socket)class101.js5SocketTask.result, 40000, 5000);
						Buffer var1 = new Buffer(5);
						var1.writeByte(15);
						var1.writeInt(218);
						class167.js5Socket.write(var1.array, 0, 5);
						++js5ConnectState;
						class310.field2769 = SpotAnimationDefinition.method962();
					}

					if (js5ConnectState == 3) {
						if (class167.js5Socket.available() > 0) {
							int var2 = class167.js5Socket.readUnsignedByte();
							if (var2 != 0) {
								this.js5Error(var2);
								return;
							}

							++js5ConnectState;
						} else if (SpotAnimationDefinition.method962() - class310.field2769 > 30000L) {
							this.js5Error(-2);
							return;
						}
					}

					if (js5ConnectState == 4) {
						WorldMapSectionType.field2038.method1955(class167.js5Socket, gameState > 20);
						class101.js5SocketTask = null;
						class167.js5Socket = null;
						js5ConnectState = 0;
						js5Errors = 0;
					}
				} catch (IOException var3) {
					this.js5Error(-3);
				}

			}
		}
	}

	@ObfuscatedName("hf")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "-383870339"
	)
	@Export("js5Error")
	void js5Error(int var1) {
		class101.js5SocketTask = null;
		class167.js5Socket = null;
		js5ConnectState = 0;
		if (class252.currentPort == WorldMapCacheName.worldPort) {
			class252.currentPort = AbstractSocket.js5Port;
		} else {
			class252.currentPort = WorldMapCacheName.worldPort;
		}

		++js5Errors;
		if (js5Errors < 2 || var1 != 7 && var1 != 9) {
			if (js5Errors >= 2 && var1 == 6) {
				this.error("js5connect_outofdate");
				WorldMapSection2.updateGameState(1000);
			} else if (js5Errors >= 4) {
				if (gameState <= 5) {
					this.error("js5connect");
					WorldMapSection2.updateGameState(1000);
				} else {
					js5Cycles = 3000;
				}
			}
		} else if (gameState <= 5) {
			this.error("js5connect_full");
			WorldMapSection2.updateGameState(1000);
		} else {
			js5Cycles = 3000;
		}

	}

	@ObfuscatedName("hh")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-1040776320"
	)
	@Export("doCycleLoggedOut")
	final void doCycleLoggedOut() {
		AbstractSocket var1 = packetWriter.getSocket();
		PacketBuffer var2 = packetWriter.packetBuffer;

		try {
			if (loginState == 0) {
				if (EnumComposition.secureRandom == null && (secureRandomFuture.isDone() || field444 > 250)) {
					EnumComposition.secureRandom = secureRandomFuture.get();
					secureRandomFuture.shutdown();
					secureRandomFuture = null;
				}

				if (EnumComposition.secureRandom != null) {
					if (var1 != null) {
						var1.close();
						var1 = null;
					}

					Player.socketTask = null;
					hadNetworkError = false;
					field444 = 0;
					if (field648.method2633()) {
						if (this.method364()) {
							try {
								this.method367(ObjectComposition.field1664);
								class19.method73(21);
							} catch (Throwable var22) {
								GrandExchangeOfferWorldComparator.RunException_sendStackTrace((String)null, var22);
								class149.getLoginError(65);
								return;
							}
						} else {
							if (!this.method365()) {
								class149.getLoginError(65);
								return;
							}

							try {
								this.method369(class369.field3560, InterfaceParent.field862);
								class19.method73(20);
							} catch (Exception var21) {
								GrandExchangeOfferWorldComparator.RunException_sendStackTrace((String)null, var21);
								class149.getLoginError(65);
								return;
							}
						}
					} else {
						class19.method73(1);
					}
				}
			}

			class20 var24;
			if (loginState == 21) {
				if (this.field666 != null) {
					if (!this.field666.isDone()) {
						return;
					}

					if (this.field666.isCancelled()) {
						class149.getLoginError(65);
						this.field666 = null;
						return;
					}

					try {
						RefreshAccessTokenResponse var3 = (RefreshAccessTokenResponse)this.field666.get();
						if (!var3.isSuccess()) {
							class149.getLoginError(65);
							this.field666 = null;
							return;
						}

						Messages.field1155 = var3.getAccessToken();
						ObjectComposition.field1664 = var3.getRefreshToken();
						this.field666 = null;
					} catch (Exception var20) {
						GrandExchangeOfferWorldComparator.RunException_sendStackTrace((String)null, var20);
						class149.getLoginError(65);
						this.field666 = null;
						return;
					}
				} else {
					if (this.field658 == null) {
						class149.getLoginError(65);
						return;
					}

					if (!this.field658.method68()) {
						return;
					}

					if (this.field658.method67()) {
						GrandExchangeOfferWorldComparator.RunException_sendStackTrace(this.field658.method66(), (Throwable)null);
						class149.getLoginError(65);
						this.field658 = null;
						return;
					}

					var24 = this.field658.method69();
					if (var24.method74() != 200) {
						class149.getLoginError(65);
						this.field658 = null;
						return;
					}

					field444 = 0;
					class474 var4 = new class474(var24.method76());

					try {
						Messages.field1155 = var4.method2357().getString("access_token");
						ObjectComposition.field1664 = var4.method2357().getString("refresh_token");
					} catch (Exception var19) {
						GrandExchangeOfferWorldComparator.RunException_sendStackTrace("Error parsing tokens", var19);
						class149.getLoginError(65);
						this.field658 = null;
						return;
					}
				}

				this.method368(Messages.field1155);
				class19.method73(20);
			}

			if (loginState == 20) {
				if (this.field667 != null) {
					if (!this.field667.isDone()) {
						return;
					}

					if (this.field667.isCancelled()) {
						class149.getLoginError(65);
						this.field667 = null;
						return;
					}

					try {
						OtlTokenResponse var25 = (OtlTokenResponse)this.field667.get();
						if (!var25.isSuccess()) {
							class149.getLoginError(65);
							this.field667 = null;
							return;
						}

						this.field665 = var25.getToken();
						this.field667 = null;
					} catch (Exception var18) {
						GrandExchangeOfferWorldComparator.RunException_sendStackTrace((String)null, var18);
						class149.getLoginError(65);
						this.field667 = null;
						return;
					}
				} else {
					if (this.field659 == null) {
						class149.getLoginError(65);
						return;
					}

					if (!this.field659.method68()) {
						return;
					}

					if (this.field659.method67()) {
						GrandExchangeOfferWorldComparator.RunException_sendStackTrace(this.field659.method66(), (Throwable)null);
						class149.getLoginError(65);
						this.field659 = null;
						return;
					}

					var24 = this.field659.method69();
					if (var24.method74() != 200) {
						GrandExchangeOfferWorldComparator.RunException_sendStackTrace("Response code: " + var24.method74() + "Response body: " + var24.method76(), (Throwable)null);
						class149.getLoginError(65);
						this.field659 = null;
						return;
					}

					List var27 = (List)var24.method75().get("Content-Type");
					if (var27 != null && var27.contains(class472.field3931.method2348())) {
						try {
							JSONObject var5 = new JSONObject(var24.method76());
							this.field665 = var5.getString("token");
						} catch (JSONException var17) {
							GrandExchangeOfferWorldComparator.RunException_sendStackTrace((String)null, var17);
							class149.getLoginError(65);
							this.field659 = null;
							return;
						}
					} else {
						this.field665 = var24.method76();
					}

					this.field659 = null;
				}

				field444 = 0;
				class19.method73(1);
			}

			if (loginState == 1) {
				if (Player.socketTask == null) {
					Player.socketTask = GameEngine.taskHandler.newSocketTask(Friend.worldHost, class252.currentPort);
				}

				if (Player.socketTask.status == 2) {
					throw new IOException();
				}

				if (Player.socketTask.status == 1) {
					var1 = WorldMapData_0.method1178((Socket)Player.socketTask.result, 40000, 5000);
					packetWriter.setSocket(var1);
					Player.socketTask = null;
					class19.method73(2);
				}
			}

			PacketBufferNode var26;
			if (loginState == 2) {
				packetWriter.clearBuffer();
				var26 = HorizontalAlignment.method931();
				var26.packetBuffer.writeByte(LoginPacket.field2764.id);
				packetWriter.addNode(var26);
				packetWriter.flush();
				var2.offset = 0;
				class19.method73(3);
			}

			int var12;
			if (loginState == 3) {
				if (MusicPatchPcmStream.pcmPlayer1 != null) {
					MusicPatchPcmStream.pcmPlayer1.method213();
				}

				if (var1.isAvailable(1)) {
					var12 = var1.readUnsignedByte();
					if (MusicPatchPcmStream.pcmPlayer1 != null) {
						MusicPatchPcmStream.pcmPlayer1.method213();
					}

					if (var12 != 0) {
						class149.getLoginError(var12);
						return;
					}

					var2.offset = 0;
					class19.method73(4);
				}
			}

			if (loginState == 4) {
				if (var2.offset < 8) {
					var12 = var1.available();
					if (var12 > 8 - var2.offset) {
						var12 = 8 - var2.offset;
					}

					if (var12 > 0) {
						var1.read(var2.array, var2.offset, var12);
						var2.offset += var12;
					}
				}

				if (var2.offset == 8) {
					var2.offset = 0;
					Clock.field1876 = var2.readLong();
					class19.method73(5);
				}
			}

			int var6;
			if (loginState == 5) {
				packetWriter.packetBuffer.offset = 0;
				packetWriter.clearBuffer();
				PacketBuffer var28 = new PacketBuffer(500);
				int[] var29 = new int[]{EnumComposition.secureRandom.nextInt(), EnumComposition.secureRandom.nextInt(), EnumComposition.secureRandom.nextInt(), EnumComposition.secureRandom.nextInt()};
				var28.offset = 0;
				var28.writeByte(1);
				var28.writeInt(var29[0]);
				var28.writeInt(var29[1]);
				var28.writeInt(var29[2]);
				var28.writeInt(var29[3]);
				var28.writeLong(Clock.field1876);
				if (gameState == 40) {
					var28.writeInt(class215.field1854[0]);
					var28.writeInt(class215.field1854[1]);
					var28.writeInt(class215.field1854[2]);
					var28.writeInt(class215.field1854[3]);
				} else {
					if (gameState == 50) {
						var28.writeByte(class124.field1204.rsOrdinal());
						var28.writeInt(class160.field1406);
					} else {
						var28.writeByte(field419.rsOrdinal());
						switch(field419.field1210) {
						case 0:
						case 1:
							var28.writeMedium(class53.field256);
							++var28.offset;
							break;
						case 2:
							var28.offset += 4;
							break;
						case 3:
							var28.writeInt(WorldMapIcon_1.clientPreferences.method566(Login.Login_username));
						}
					}

					if (field648.method2633()) {
						var28.writeByte(class531.field4233.rsOrdinal());
						var28.writeStringCp1252NullTerminated(this.field665);
					} else {
						var28.writeByte(class531.field4234.rsOrdinal());
						var28.writeStringCp1252NullTerminated(Login.Login_password);
					}
				}

				var28.encryptRsa(class74.field742, class74.field741);
				class215.field1854 = var29;
				PacketBufferNode var32 = HorizontalAlignment.method931();
				var32.packetBuffer.offset = 0;
				if (gameState == 40) {
					var32.packetBuffer.writeByte(LoginPacket.RECONNECT_LOGIN_CONNECTION.id);
				} else {
					var32.packetBuffer.writeByte(LoginPacket.NEW_LOGIN_CONNECTION.id);
				}

				var32.packetBuffer.writeShort(0);
				var6 = var32.packetBuffer.offset;
				var32.packetBuffer.writeInt(218);
				var32.packetBuffer.writeInt(1);
				var32.packetBuffer.writeByte(clientType);
				var32.packetBuffer.writeByte(field424);
				byte var7 = 0;
				var32.packetBuffer.writeByte(var7);
				var32.packetBuffer.writeBytes(var28.array, 0, var28.offset);
				int var8 = var32.packetBuffer.offset;
				var32.packetBuffer.writeStringCp1252NullTerminated(Login.Login_username);
				var32.packetBuffer.writeByte((isResizable ? 1 : 0) << 1 | (isLowDetail ? 1 : 0));
				var32.packetBuffer.writeShort(Language.canvasWidth);
				var32.packetBuffer.writeShort(class47.canvasHeight);
				class354.method1897(var32.packetBuffer);
				var32.packetBuffer.writeStringCp1252NullTerminated(MenuAction.param9);
				var32.packetBuffer.writeInt(DevicePcmPlayerProvider.field66);
				if (param25 > 213) {
					var32.packetBuffer.writeByte(0);
				}

				Buffer var9 = new Buffer(class60.field312.size());
				class60.field312.write(var9);
				var32.packetBuffer.writeBytes(var9.array, 0, var9.array.length);
				var32.packetBuffer.writeByte(clientType);
				var32.packetBuffer.writeInt(0);
				var32.packetBuffer.writeIntIME(PcmPlayer.field181.hash);
				var32.packetBuffer.method2613(SoundSystem.field209.hash);
				var32.packetBuffer.writeIntLE(class145.field1338.hash);
				var32.packetBuffer.method2613(class7.field12.hash);
				var32.packetBuffer.writeIntLE(class514.archive6.hash);
				var32.packetBuffer.writeIntLE(StructComposition.field1637.hash);
				var32.packetBuffer.method2613(class313.archive4.hash);
				var32.packetBuffer.writeIntIME(UserComparator7.field1190.hash);
				var32.packetBuffer.writeIntLE(WorldMapDecorationType.archive10.hash);
				var32.packetBuffer.writeIntIME(SpotAnimationDefinition.field1597.hash);
				var32.packetBuffer.method2613(Canvas.field68.hash);
				var32.packetBuffer.writeIntIME(VarbitComposition.archive13.hash);
				var32.packetBuffer.writeInt(WorldMapData_0.field1938.hash);
				var32.packetBuffer.method2613(0);
				var32.packetBuffer.writeIntLE(class47.archive12.hash);
				var32.packetBuffer.writeIntLE(GrandExchangeOfferOwnWorldComparator.archive8.hash);
				var32.packetBuffer.writeIntLE(Language.field3643.hash);
				var32.packetBuffer.writeInt(WorldMapSection0.archive9.hash);
				var32.packetBuffer.writeIntLE(class19.field59.hash);
				var32.packetBuffer.writeIntIME(class344.archive2.hash);
				var32.packetBuffer.writeIntIME(BuddyRankComparator.field1200.hash);
				var32.packetBuffer.xteaEncrypt(var29, var8, var32.packetBuffer.offset);
				var32.packetBuffer.writeLengthShort(var32.packetBuffer.offset - var6);
				packetWriter.addNode(var32);
				packetWriter.flush();
				packetWriter.isaacCipher = new IsaacCipher(var29);
				int[] var10 = new int[4];

				for (int var11 = 0; var11 < 4; ++var11) {
					var10[var11] = var29[var11] + 50;
				}

				var2.newIsaacCipher(var10);
				class19.method73(6);
			}

			int var13;
			if (loginState == 6 && var1.available() > 0) {
				var12 = var1.readUnsignedByte();
				if (var12 == 61) {
					var13 = var1.available();
					PendingSpawn.field949 = var13 == 1 && var1.readUnsignedByte() == 1;
					class19.method73(5);
				}

				if (var12 == 21 && gameState == 20) {
					class19.method73(12);
				} else if (var12 == 2) {
					class19.method73(14);
				} else if (var12 == 15 && gameState == 40) {
					packetWriter.serverPacketLength = -1;
					class19.method73(19);
				} else if (var12 == 64) {
					class19.method73(10);
				} else if (var12 == 23 && field447 < 1) {
					++field447;
					class19.method73(0);
				} else if (var12 == 29) {
					class19.method73(17);
				} else {
					if (var12 != 69) {
						class149.getLoginError(var12);
						return;
					}

					class19.method73(7);
				}
			}

			if (loginState == 7 && var1.available() >= 2) {
				var1.read(var2.array, 0, 2);
				var2.offset = 0;
				Language.field3642 = var2.readUnsignedShort();
				class19.method73(8);
			}

			if (loginState == 8 && var1.available() >= Language.field3642) {
				var2.offset = 0;
				var1.read(var2.array, var2.offset, Language.field3642);
				class6 var30 = class221.method1111()[var2.readUnsignedByte()];

				try {
					class3 var31 = WorldMapElement.method890(var30);
					this.field657 = new class7(var2, var31);
					class19.method73(9);
				} catch (Exception var16) {
					class149.getLoginError(22);
					return;
				}
			}

			if (loginState == 9 && this.field657.method17()) {
				this.field669 = this.field657.method19();
				this.field657.method18();
				this.field657 = null;
				if (this.field669 == null) {
					class149.getLoginError(22);
					return;
				}

				packetWriter.clearBuffer();
				var26 = HorizontalAlignment.method931();
				var26.packetBuffer.writeByte(LoginPacket.field2761.id);
				var26.packetBuffer.writeShort(this.field669.offset);
				var26.packetBuffer.writeBuffer(this.field669);
				packetWriter.addNode(var26);
				packetWriter.flush();
				this.field669 = null;
				class19.method73(6);
			}

			if (loginState == 10 && var1.available() > 0) {
				class223.field1885 = var1.readUnsignedByte();
				class19.method73(11);
			}

			if (loginState == 11 && var1.available() >= class223.field1885) {
				var1.read(var2.array, 0, class223.field1885);
				var2.offset = 0;
				class19.method73(6);
			}

			if (loginState == 12 && var1.available() > 0) {
				field443 = (var1.readUnsignedByte() + 3) * 60;
				class19.method73(13);
			}

			if (loginState == 13) {
				field444 = 0;
				class139.setLoginResponseString("You have only just left another world.", "Your profile will be transferred in:", field443 / 60 + " seconds.");
				if (--field443 <= 0) {
					class19.method73(0);
				}

			} else {
				if (loginState == 14 && var1.available() >= 1) {
					SoundCache.playerUUIDLength = var1.readUnsignedByte();
					class19.method73(15);
				}

				if (loginState == 15 && var1.available() >= SoundCache.playerUUIDLength) {
					boolean var38 = var1.readUnsignedByte() == 1;
					var1.read(var2.array, 0, 4);
					var2.offset = 0;
					boolean var37 = false;
					if (var38) {
						var13 = var2.readByteIsaac() << 24;
						var13 |= var2.readByteIsaac() << 16;
						var13 |= var2.readByteIsaac() << 8;
						var13 |= var2.readByteIsaac();
						WorldMapIcon_1.clientPreferences.method564(Login.Login_username, var13);
					}

					if (Login_isUsernameRemembered) {
						WorldMapIcon_1.clientPreferences.setUsernameToRemember(Login.Login_username);
					} else {
						WorldMapIcon_1.clientPreferences.setUsernameToRemember((String)null);
					}

					TextureProvider.savePreferences();
					staffModLevel = var1.readUnsignedByte();
					playerMod = var1.readUnsignedByte() == 1;
					localPlayerIndex = var1.readUnsignedByte();
					localPlayerIndex <<= 8;
					localPlayerIndex += var1.readUnsignedByte();
					isMembers = var1.readUnsignedByte();
					var1.read(var2.array, 0, 8);
					var2.offset = 0;
					this.field668 = var2.readLong();
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
					ServerPacket[] var35 = class12.method46();
					var6 = var2.readSmartByteShortIsaac();
					if (var6 < 0 || var6 >= var35.length) {
						throw new IOException(var6 + " " + var2.offset);
					}

					packetWriter.serverPacket = var35[var6];
					packetWriter.serverPacketLength = packetWriter.serverPacket.length;
					var1.read(var2.array, 0, 2);
					var2.offset = 0;
					packetWriter.serverPacketLength = var2.readUnsignedShort();

					try {
						class26.method108(SpriteMask.client, "zap");
					} catch (Throwable var15) {
					}

					class19.method73(16);
				}

				if (loginState == 16) {
					if (var1.available() >= packetWriter.serverPacketLength) {
						var2.offset = 0;
						var1.read(var2.array, 0, packetWriter.serverPacketLength);
						timer.method2173();
						class53.method307();
						Players.updatePlayer(var2);
						DefaultsGroup.timeOfPreviousKeyPress = -1;
						GrandExchangeOfferUnitPriceComparator.loadRegions(false, var2, param25 >= 218);
						packetWriter.serverPacket = null;
					}

				} else {
					if (loginState == 17 && var1.available() >= 2) {
						var2.offset = 0;
						var1.read(var2.array, 0, 2);
						var2.offset = 0;
						GrandExchangeOfferOwnWorldComparator.field360 = var2.readUnsignedShort();
						class19.method73(18);
					}

					if (loginState == 18 && var1.available() >= GrandExchangeOfferOwnWorldComparator.field360) {
						var2.offset = 0;
						var1.read(var2.array, 0, GrandExchangeOfferOwnWorldComparator.field360);
						var2.offset = 0;
						String var34 = var2.readStringCp1252NullTerminated();
						String var33 = var2.readStringCp1252NullTerminated();
						String var36 = var2.readStringCp1252NullTerminated();
						class139.setLoginResponseString(var34, var33, var36);
						WorldMapSection2.updateGameState(10);
						if (field648.method2633()) {
							UserComparator7.method674(9);
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
							var12 = packetWriter.serverPacketLength;
							timer.method2175();
							class17.method61();
							Players.updatePlayer(var2);
							if (var12 != var2.offset) {
								throw new RuntimeException();
							}
						}
					} else {
						++field444;
						if (field444 > 2000) {
							if (field447 < 1) {
								if (WorldMapCacheName.worldPort == class252.currentPort) {
									class252.currentPort = AbstractSocket.js5Port;
								} else {
									class252.currentPort = WorldMapCacheName.worldPort;
								}

								++field447;
								class19.method73(0);
							} else {
								class149.getLoginError(-3);
							}
						}
					}
				}
			}
		} catch (IOException var23) {
			if (field447 < 1) {
				if (WorldMapCacheName.worldPort == class252.currentPort) {
					class252.currentPort = AbstractSocket.js5Port;
				} else {
					class252.currentPort = WorldMapCacheName.worldPort;
				}

				++field447;
				class19.method73(0);
			} else {
				class149.getLoginError(-2);
			}
		}
	}

	@ObfuscatedName("hm")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-614967617"
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
			class9.method29();
		} else {
			if (!isMenuOpen) {
				UserComparator10.addCancelMenuEntry();
			}

			int var1;
			for (var1 = 0; var1 < 100 && this.method385(packetWriter); ++var1) {
			}

			if (gameState == 30) {
				int var2;
				PacketBufferNode var14;
				while (class216.method1096()) {
					var14 = class113.getPacketBufferNode(ClientPacket.REFLECTION_CHECK_REPLY, packetWriter.isaacCipher);
					var14.packetBuffer.writeByte(0);
					var2 = var14.packetBuffer.offset;
					class415.performReflectionCheck(var14.packetBuffer);
					var14.packetBuffer.writeLengthByte(var14.packetBuffer.offset - var2);
					packetWriter.addNode(var14);
				}

				if (timer.field3792) {
					var14 = class113.getPacketBufferNode(ClientPacket.LOGIN_TIMINGS, packetWriter.isaacCipher);
					var14.packetBuffer.writeByte(0);
					var2 = var14.packetBuffer.offset;
					timer.write(var14.packetBuffer);
					var14.packetBuffer.writeLengthByte(var14.packetBuffer.offset - var2);
					packetWriter.addNode(var14);
					timer.method2174();
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
				synchronized(Message.mouseRecorder.lock) {
					if (!lockMouseRecorder) {
						Message.mouseRecorder.index = 0;
					} else if (MouseHandler.MouseHandler_lastButton != 0 || Message.mouseRecorder.index >= 40) {
						PacketBufferNode var15 = null;
						var3 = 0;
						var4 = 0;
						var5 = 0;
						var6 = 0;

						for (var7 = 0; var7 < Message.mouseRecorder.index && (var15 == null || var15.packetBuffer.offset - var3 < 246); ++var7) {
							var4 = var7;
							var8 = Message.mouseRecorder.ys[var7];
							if (var8 < -1) {
								var8 = -1;
							} else if (var8 > 65534) {
								var8 = 65534;
							}

							var9 = Message.mouseRecorder.xs[var7];
							if (var9 < -1) {
								var9 = -1;
							} else if (var9 > 65534) {
								var9 = 65534;
							}

							if (var9 != lastMouseRecordX || var8 != lastMouseRecordY) {
								if (var15 == null) {
									var15 = class113.getPacketBufferNode(ClientPacket.f52, packetWriter.isaacCipher);
									var15.packetBuffer.writeByte(0);
									var3 = var15.packetBuffer.offset;
									var10000 = var15.packetBuffer;
									var10000.offset += 2;
									var5 = 0;
									var6 = 0;
								}

								if (-1L != field610) {
									var10 = var9 - lastMouseRecordX;
									var11 = var8 - lastMouseRecordY;
									var12 = (int)((Message.mouseRecorder.millis[var7] - field610) / 20L);
									var5 = (int)((long)var5 + (Message.mouseRecorder.millis[var7] - field610) % 20L);
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
								field610 = Message.mouseRecorder.millis[var7];
							}
						}

						if (var15 != null) {
							var15.packetBuffer.writeLengthByte(var15.packetBuffer.offset - var3);
							var7 = var15.packetBuffer.offset;
							var15.packetBuffer.offset = var3;
							var15.packetBuffer.writeByte(var5 / var6);
							var15.packetBuffer.writeByte(var5 % var6);
							var15.packetBuffer.offset = var7;
							packetWriter.addNode(var15);
						}

						if (var4 >= Message.mouseRecorder.index) {
							Message.mouseRecorder.index = 0;
						} else {
							MouseRecorder var52 = Message.mouseRecorder;
							var52.index -= var4;
							System.arraycopy(Message.mouseRecorder.xs, var4, Message.mouseRecorder.xs, 0, Message.mouseRecorder.index);
							System.arraycopy(Message.mouseRecorder.ys, var4, Message.mouseRecorder.ys, 0, Message.mouseRecorder.index);
							System.arraycopy(Message.mouseRecorder.millis, var4, Message.mouseRecorder.millis, 0, Message.mouseRecorder.index);
						}
					}
				}

				if (MouseHandler.MouseHandler_lastButton == 1 || !class19.mouseCam && MouseHandler.MouseHandler_lastButton == 4 || MouseHandler.MouseHandler_lastButton == 2) {
					long var16 = MouseHandler.MouseHandler_lastPressedTimeMillis - mouseLastLastPressedTimeMillis;
					if (var16 > 32767L) {
						var16 = 32767L;
					}

					mouseLastLastPressedTimeMillis = MouseHandler.MouseHandler_lastPressedTimeMillis;
					var3 = MouseHandler.MouseHandler_lastPressedY;
					if (var3 < 0) {
						var3 = 0;
					} else if (var3 > class47.canvasHeight) {
						var3 = class47.canvasHeight;
					}

					var4 = MouseHandler.MouseHandler_lastPressedX;
					if (var4 < 0) {
						var4 = 0;
					} else if (var4 > Language.canvasWidth) {
						var4 = Language.canvasWidth;
					}

					var5 = (int)var16;
					if(shouldProcessClick()) {
						PacketBufferNode var18 = class113.getPacketBufferNode(ClientPacket.CLICK, packetWriter.isaacCipher);
						var18.packetBuffer.writeShort((var5 << 1) + (MouseHandler.MouseHandler_lastButton == 2 ? 1 : 0));
						var18.packetBuffer.writeShort(var4);
						var18.packetBuffer.writeShort(var3);
						packetWriter.addNode(var18);
					}
				}

				if (mouseWheelRotation != 0) {
					var14 = class113.getPacketBufferNode(ClientPacket.MIDDLE_MOUSE, packetWriter.isaacCipher);
					var14.packetBuffer.writeShort(mouseWheelRotation);
					packetWriter.addNode(var14);
				}

				if (keyHandlerInstance.pressedKeysCount > 0) {
					var14 = class113.getPacketBufferNode(ClientPacket.IF_BUTTONT, packetWriter.isaacCipher);
					var14.packetBuffer.writeShort(0);
					var2 = var14.packetBuffer.offset;
					long var19 = SpotAnimationDefinition.method962();

					for (var5 = 0; var5 < keyHandlerInstance.pressedKeysCount; ++var5) {
						long var21 = var19 - timeOfPreviousKeyPress;
						if (var21 > 16777215L) {
							var21 = 16777215L;
						}

						timeOfPreviousKeyPress = var19;
						var14.packetBuffer.method2605((int)var21);
						var14.packetBuffer.writeByteNeg(keyHandlerInstance.field1900[var5]);
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
					var14 = class113.getPacketBufferNode(ClientPacket.EVENT_CAMERA_FOCUS, packetWriter.isaacCipher);
					var14.packetBuffer.writeShortAdd(camAngleX);
					var14.packetBuffer.writeShortAdd(camAngleY);
					packetWriter.addNode(var14);
				}

				if (class357.hasFocus && !hadFocus) {
					hadFocus = true;
					var14 = class113.getPacketBufferNode(ClientPacket.EVENT_APPLET_FOCUS, packetWriter.isaacCipher);
					var14.packetBuffer.writeByte(1);
					packetWriter.addNode(var14);
				}

				if (!class357.hasFocus && hadFocus) {
					hadFocus = false;
					var14 = class113.getPacketBufferNode(ClientPacket.EVENT_APPLET_FOCUS, packetWriter.isaacCipher);
					var14.packetBuffer.writeByte(0);
					packetWriter.addNode(var14);
				}

				if (NewShit.worldMap != null) {
					NewShit.worldMap.method2398();
				}

				if (class344.ClanChat_inClanChat) {
					if (class20.friendsChat != null) {
						class20.friendsChat.sort();
					}

					for (var1 = 0; var1 < Players.Players_count; ++var1) {
						Player var35 = players[Players.Players_indices[var1]];
						var35.clearIsInFriendsChat();
					}

					class344.ClanChat_inClanChat = false;
				}

				class153.method794();
				class435.method2201();
				if (gameState == 30) {
					for (PendingSpawn var34 = (PendingSpawn)pendingSpawns.last(); var34 != null; var34 = (PendingSpawn)pendingSpawns.previous()) {
						if (var34.endCycle > 0) {
							--var34.endCycle;
						}

						if (var34.endCycle == 0) {
							if (var34.objectId >= 0) {
								var3 = var34.objectId;
								var4 = var34.field951;
								ObjectComposition var23 = WorldMapSection2.getObjectDefinition(var3);
								if (var4 == 11) {
									var4 = 10;
								}

								if (var4 >= 5 && var4 <= 8) {
									var4 = 4;
								}

								boolean var30 = var23.method1003(var4);
								if (!var30) {
									continue;
								}
							}

							WorldMapAreaData.addPendingSpawnToScene(var34.plane, var34.type, var34.x, var34.y, var34.objectId, var34.field961, var34.field951, var34.field957);
							var34.remove();
						} else {
							if (var34.startCycle > 0) {
								--var34.startCycle;
							}

							if (var34.startCycle == 0 && var34.x >= 1 && var34.y >= 1 && var34.x <= 102 && var34.y <= 102 && (var34.id < 0 || class141.method755(var34.id, var34.objectType))) {
								WorldMapAreaData.addPendingSpawnToScene(var34.plane, var34.type, var34.x, var34.y, var34.id, var34.rotation, var34.objectType, var34.field957);
								var34.startCycle = -1;
								if (var34.id == var34.objectId && var34.objectId == -1) {
									var34.remove();
								} else if (var34.id == var34.objectId && var34.field961 == var34.rotation && var34.objectType == var34.field951) {
									var34.remove();
								}
							}
						}
					}

					int var10002;
					for (var1 = 0; var1 < soundEffectCount; ++var1) {
						var10002 = queuedSoundEffectDelays[var1]--;
						if (queuedSoundEffectDelays[var1] >= -10) {
							SoundEffect var37 = soundEffects[var1];
							if (var37 == null) {
								var10000 = null;
								var37 = SoundEffect.readSoundEffect(Language.field3643, soundEffectIds[var1], 0);
								if (var37 == null) {
									continue;
								}

								int[] var53 = queuedSoundEffectDelays;
								var53[var1] += var37.calculateDelay();
								soundEffects[var1] = var37;
							}

							if (queuedSoundEffectDelays[var1] < 0) {
								if (soundLocations[var1] != 0) {
									var4 = (soundLocations[var1] & 255) * 128;
									var5 = soundLocations[var1] >> 16 & 255;
									var6 = var5 * 128 + 64 - class229.localPlayer.x;
									if (var6 < 0) {
										var6 = -var6;
									}

									var7 = soundLocations[var1] >> 8 & 255;
									var8 = var7 * 128 + 64 - class229.localPlayer.y;
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

									var3 = (var4 - var9) * WorldMapIcon_1.clientPreferences.getAreaSoundEffectsVolume() / var4;
								} else {
									var3 = WorldMapIcon_1.clientPreferences.getCurrentSoundEffectsVolume();
								}

								if (var3 > 0) {
									RawSound var24 = var37.toRawSound().resample(class521.decimator);
									RawPcmStream var44 = RawPcmStream.createRawPcmStream(var24, 100, var3);
									var44.setNumLoops(queuedSoundEffectLoops[var1] - 1);
									LoginScreenAnimation.pcmStreamMixer.addSubStream(var44);
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

					if (playingJingle && !BuddyRankComparator.method687()) {
						if (WorldMapIcon_1.clientPreferences.getCurrentMusicVolume() != 0) {
							boolean var31 = !class316.field2787.isEmpty();
							if (var31) {
								class72.method433(class514.archive6, WorldMapIcon_1.clientPreferences.getCurrentMusicVolume());
							}
						}

						playingJingle = false;
					}

					++packetWriter.field1164;
					if (packetWriter.field1164 > 750) {
						class9.method29();
					} else {
						var1 = Players.Players_count;
						int[] var39 = Players.Players_indices;

						for (var3 = 0; var3 < var1; ++var3) {
							Player var46 = players[var39[var3]];
							if (var46 != null) {
								MoveSpeed.updateActorSequence(var46, 1);
							}
						}

						for (var1 = 0; var1 < npcCount; ++var1) {
							var2 = npcIndices[var1];
							NPC var25 = npcs[var2];
							if (var25 != null) {
								MoveSpeed.updateActorSequence(var25, var25.definition.size);
							}
						}

						int[] var36 = Players.Players_indices;

						for (var2 = 0; var2 < Players.Players_count; ++var2) {
							Player var50 = players[var36[var2]];
							if (var50 != null && var50.overheadTextCyclesRemaining > 0) {
								--var50.overheadTextCyclesRemaining;
								if (var50.overheadTextCyclesRemaining == 0) {
									var50.overheadText = null;
								}
							}
						}

						for (var2 = 0; var2 < npcCount; ++var2) {
							var3 = npcIndices[var2];
							NPC var47 = npcs[var3];
							if (var47 != null && var47.overheadTextCyclesRemaining > 0) {
								--var47.overheadTextCyclesRemaining;
								if (var47.overheadTextCyclesRemaining == 0) {
									var47.overheadText = null;
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

						Widget var38 = Interpreter.mousedOverWidgetIf1;
						Widget var41 = SwapSongTask.field3744;
						Interpreter.mousedOverWidgetIf1 = null;
						SwapSongTask.field3744 = null;
						draggedOnWidget = null;
						field397 = false;
						field396 = false;
						field530 = 0;

						while (keyHandlerInstance.method1128() && field530 < 128) {
							if (staffModLevel >= 2 && keyHandlerInstance.getKeyPressed(82) && keyHandlerInstance.field1899 == 66) {
								String var51 = class250.method1332();
								SpriteMask.client.method150(var51);
							} else if (oculusOrbState != 1 || keyHandlerInstance.field1897 <= 0) {
								field577[field530] = keyHandlerInstance.field1899;
								field579[field530] = keyHandlerInstance.field1897;
								++field530;
							}
						}

						boolean var32 = staffModLevel >= 2;
						PacketBufferNode var26;
						if (var32 && keyHandlerInstance.getKeyPressed(82) && keyHandlerInstance.getKeyPressed(81) && mouseWheelRotation != 0) {
							var4 = class229.localPlayer.plane - mouseWheelRotation;
							if (var4 < 0) {
								var4 = 0;
							} else if (var4 > 3) {
								var4 = 3;
							}

							if (var4 != class229.localPlayer.plane) {
								var5 = class229.localPlayer.pathX[0] + NewShit.baseX;
								var6 = class229.localPlayer.pathY[0] + class101.baseY;
								var26 = class113.getPacketBufferNode(ClientPacket.f20, packetWriter.isaacCipher);
								var26.packetBuffer.writeInt(0);
								var26.packetBuffer.writeIntME(var5);
								var26.packetBuffer.writeIntME(var6);
								var26.packetBuffer.writeByte(var4);
								packetWriter.addNode(var26);
							}

							mouseWheelRotation = 0;
						}

						if (rootInterface != -1) {
							class406.updateRootInterface(rootInterface, 0, 0, Language.canvasWidth, class47.canvasHeight, 0, 0);
						}

						++cycleCntr;

						while (true) {
							Widget var40;
							Widget var45;
							ScriptEvent var49;
							do {
								var49 = (ScriptEvent)field627.removeLast();
								if (var49 == null) {
									while (true) {
										do {
											var49 = (ScriptEvent)field628.removeLast();
											if (var49 == null) {
												while (true) {
													do {
														var49 = (ScriptEvent)scriptEvents.removeLast();
														if (var49 == null) {
															boolean var33 = false;

															while (true) {
																class222 var48 = (class222)field625.removeLast();
																if (var48 == null) {
																	if (!var33 && MouseHandler.MouseHandler_lastButton == 1) {
																		field422.method1114();
																	}

																	this.menu();
																	class127.method692();
																	if (clickedWidget != null) {
																		this.method391();
																	}

																	if (Scene.shouldSendWalk()) {
																		var5 = Scene.Scene_selectedX;
																		var6 = Scene.Scene_selectedY;
																		var26 = class113.getPacketBufferNode(ClientPacket.MOVE_GAMECLICK, packetWriter.isaacCipher);
																		var26.packetBuffer.writeByte(5);
																		var26.packetBuffer.writeShort(var5 + NewShit.baseX);
																		var26.packetBuffer.writeShortAdd(var6 + class101.baseY);
																		var26.packetBuffer.writeByteSub(keyHandlerInstance.getKeyPressed(82) ? (keyHandlerInstance.getKeyPressed(81) ? 2 : 1) : 0);
																		packetWriter.addNode(var26);
																		Scene.method1499();
																		mouseCrossX = MouseHandler.MouseHandler_lastPressedX;
																		mouseCrossY = MouseHandler.MouseHandler_lastPressedY;
																		mouseCrossColor = 1;
																		mouseCrossState = 0;
																		destinationX = var5;
																		destinationY = var6;
																	}

																	if (var38 != Interpreter.mousedOverWidgetIf1) {
																		if (var38 != null) {
																			class159.invalidateWidget(var38);
																		}

																		if (Interpreter.mousedOverWidgetIf1 != null) {
																			class159.invalidateWidget(Interpreter.mousedOverWidgetIf1);
																		}

																	}

																	if (var41 != SwapSongTask.field3744 && field493 == field492) {
																		if (var41 != null) {
																			class159.invalidateWidget(var41);
																		}

																		if (SwapSongTask.field3744 != null) {
																			class159.invalidateWidget(SwapSongTask.field3744);
																		}
																	}

																	if (SwapSongTask.field3744 != null) {
																		if (field493 < field492) {
																			++field493;
																			if (field492 == field493) {
																				class159.invalidateWidget(SwapSongTask.field3744);
																			}
																		}
																	} else if (field493 > 0) {
																		--field493;
																	}

																	class336.method1740();
																	if (field400) {
																		TextureProvider.method1529();
																	} else if (isCameraLocked) {
																		if (!field402) {
																			var5 = ScriptFrame.cameraLookAtX * 128 + 64;
																			var6 = class216.cameraLookAtY * 128 + 64;
																			var7 = WorldMapDecorationType.getTileHeight(var5, var6, ItemLayer.Client_plane) - class127.cameraLookAtHeight;
																			class314.method1649(var5, var7, var6);
																		} else if (field644 != null) {
																			ViewportMouse.cameraX = field644.vmethod2386();
																			class36.cameraZ = field644.vmethod2387();
																			if (field403) {
																				SecureRandomFuture.cameraY = field644.vmethod2320();
																			} else {
																				SecureRandomFuture.cameraY = WorldMapDecorationType.getTileHeight(ViewportMouse.cameraX, class36.cameraZ, ItemLayer.Client_plane) - field644.vmethod2320();
																			}

																			field644.method2389();
																		}

																		if (!field404) {
																			var5 = Messages.field1154 * 128 + 64;
																			var6 = AbstractWorldMapData.field2045 * 128 + 64;
																			var7 = WorldMapDecorationType.getTileHeight(var5, var6, ItemLayer.Client_plane) - class302.field2510;
																			var8 = var5 - ViewportMouse.cameraX;
																			var9 = var7 - SecureRandomFuture.cameraY;
																			var10 = var6 - class36.cameraZ;
																			var11 = (int)Math.sqrt((double)(var10 * var10 + var8 * var8));
																			var12 = (int)(Math.atan2((double)var9, (double)var11) * 325.9490051269531D) & 2047;
																			int var27 = (int)(Math.atan2((double)var8, (double)var10) * -325.9490051269531D) & 2047;
																			class303.method1628(var12, var27);
																		} else {
																			if (field642 != null) {
																				Varcs.cameraPitch = field642.method2385();
																				Varcs.cameraPitch = Math.min(Math.max(Varcs.cameraPitch, 128), 383);
																				field642.method2389();
																			}

																			if (field643 != null) {
																				class192.cameraYaw = field643.method2385() & 2047;
																				field643.method2389();
																			}
																		}
																	}

																	for (var5 = 0; var5 < 5; ++var5) {
																		var10002 = field589[var5]++;
																	}

																	class176.varcs.tryWrite();
																	var5 = InterfaceParent.method463();
																	var6 = class181.method919();
																	if (var5 > 15000 && var6 > 15000) {
																		logoutTimer = 250;
																		WorldMapEvent.method1382(14500);
																		var26 = class113.getPacketBufferNode(ClientPacket.field2515, packetWriter.isaacCipher);
																		packetWriter.addNode(var26);
																	}

																	class12.friendSystem.processFriendUpdates();

																	for (var7 = 0; var7 < field607.size(); ++var7) {
																		if (MouseRecorder.method469((Integer)field607.get(var7)) != 2) {
																			field607.remove(var7);
																			--var7;
																		}
																	}

																	++packetWriter.pendingWrites;
																	if (packetWriter.pendingWrites > 50) {
																		var26 = class113.getPacketBufferNode(ClientPacket.NO_TIMEOUT, packetWriter.isaacCipher);
																		packetWriter.addNode(var26);
																	}

																	try {
																		packetWriter.flush();
																	} catch (IOException var28) {
																		class9.method29();
																	}

																	return;
																}

																if (var48.field1884.type == 12) {
																	var33 = true;
																}

																if (var48 != null && var48.field1884 != null) {
																	if (var48.field1884.childIndex >= 0) {
																		var40 = HealthBarDefinition.widgetDefinition.method1733(var48.field1884.parentId);
																		if (var40 == null || var40.children == null || var40.children.length == 0 || var48.field1884.childIndex >= var40.children.length || var48.field1884 != var40.children[var48.field1884.childIndex]) {
																			continue;
																		}
																	}

																	if (var48.field1884.type == 11 && var48.field1881 == 0) {
																		if (var48.field1884.method1860(var48.field1883, var48.field1882, 0, 0)) {
																			switch(var48.field1884.method1864()) {
																			case 0:
																				HealthBar.openURL(var48.field1884.method1866(), true, false);
																				break;
																			case 1:
																				if (ClanChannel.method853(class361.getWidgetFlags(var48.field1884))) {
																					int[] var43 = var48.field1884.method1867();
																					if (var43 != null) {
																						var26 = class113.getPacketBufferNode(ClientPacket.f97, packetWriter.isaacCipher);
																						var26.packetBuffer.writeIntIME(var43[1]);
																						var26.packetBuffer.writeInt(var43[0]);
																						var26.packetBuffer.writeShortLE(var48.field1884.childIndex);
																						var26.packetBuffer.writeInt(var43[2]);
																						var26.packetBuffer.writeIntIME(var48.field1884.id);
																						var26.packetBuffer.writeIntLE(var48.field1884.method1865());
																						packetWriter.addNode(var26);
																					}
																				}
																			}
																		}
																	} else if (var48.field1884.type == 12) {
																		class341 var42 = var48.field1884.method1871();
																		if (var42 != null && var42.method1811()) {
																			switch(var48.field1881) {
																			case 0:
																				field422.method1112(var48.field1884);
																				var42.method1759(true);
																				var42.method1798(var48.field1883, var48.field1882, keyHandlerInstance.getKeyPressed(82), keyHandlerInstance.getKeyPressed(81));
																				break;
																			case 1:
																				var42.method1799(var48.field1883, var48.field1882);
																			}
																		}
																	}
																}
															}
														}

														var45 = var49.widget;
														if (var45.childIndex < 0) {
															break;
														}

														var40 = HealthBarDefinition.widgetDefinition.method1733(var45.parentId);
													} while(var40 == null || var40.children == null || var45.childIndex >= var40.children.length || var45 != var40.children[var45.childIndex]);

													class157.runScriptEvent(var49);
												}
											}

											var45 = var49.widget;
											if (var45.childIndex < 0) {
												break;
											}

											var40 = HealthBarDefinition.widgetDefinition.method1733(var45.parentId);
										} while(var40 == null || var40.children == null || var45.childIndex >= var40.children.length || var45 != var40.children[var45.childIndex]);

										class157.runScriptEvent(var49);
									}
								}

								var45 = var49.widget;
								if (var45.childIndex < 0) {
									break;
								}

								var40 = HealthBarDefinition.widgetDefinition.method1733(var45.parentId);
							} while(var40 == null || var40.children == null || var45.childIndex >= var40.children.length || var45 != var40.children[var45.childIndex]);

							class157.runScriptEvent(var49);
						}
					}
				}
			}
		}
	}

	@ObfuscatedName("im")
	@ObfuscatedSignature(
		descriptor = "(III)V",
		garbageValue = "-1786579284"
	)
	@Export("vmethod1644")
	public void vmethod1644(int var1, int var2) {
		if (packetWriter != null && packetWriter.isaacCipher != null) {
			if (var1 > -1 && WorldMapIcon_1.clientPreferences.getCurrentMusicVolume() > 0 && !playingJingle) {
				PacketBufferNode var3 = class113.getPacketBufferNode(ClientPacket.SOUND_SONGEND, packetWriter.isaacCipher);
				var3.packetBuffer.writeInt(var1);
				packetWriter.addNode(var3);
			}

		}
	}

	@ObfuscatedName("ii")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "58"
	)
	@Export("resizeJS")
	void resizeJS() {
		int var1 = Language.canvasWidth;
		int var2 = class47.canvasHeight;
		if (super.contentWidth < var1) {
			var1 = super.contentWidth;
		}

		if (super.contentHeight < var2) {
			var2 = super.contentHeight;
		}

		if (WorldMapIcon_1.clientPreferences != null) {
			try {
				class26.invoke(SpriteMask.client, "resize", new Object[]{ApproximateRouteStrategy.getWindowedMode()});
			} catch (Throwable var4) {
			}
		}

	}

	@ObfuscatedName("ik")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "-37"
	)
	@Export("drawLoggedIn")
	final void drawLoggedIn() {
		if (rootInterface != -1) {
			ClanChannel.method862(rootInterface);
		}

		int var1;
		for (var1 = 0; var1 < rootWidgetCount; ++var1) {
			if (field407[var1]) {
				field408[var1] = true;
			}

			field409[var1] = field407[var1];
			field407[var1] = false;
		}

		field523 = cycle;
		viewportX = -1;
		viewportY = -1;
		if (rootInterface != -1) {
			rootWidgetCount = 0;
			Canvas.drawWidgets(rootInterface, 0, 0, Language.canvasWidth, class47.canvasHeight, 0, 0, -1);
		}

		Rasterizer2D.Rasterizer2D_resetClip();
		if (showMouseCross) {
			if (mouseCrossColor == 1) {
				VarpDefinition.crossSprites[mouseCrossState / 100].drawTransBgAt(mouseCrossX - 8, mouseCrossY - 8);
			}

			if (mouseCrossColor == 2) {
				VarpDefinition.crossSprites[mouseCrossState / 100 + 4].drawTransBgAt(mouseCrossX - 8, mouseCrossY - 8);
			}
		}

		if (!isMenuOpen) {
			if (viewportX != -1) {
				class478.method2366(viewportX, viewportY);
			}
		} else {
			ClanSettings.method820();
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

		IgnoreList.method2206(ItemLayer.Client_plane, class229.localPlayer.x, class229.localPlayer.y, field460);
		field460 = 0;
	}

	@ObfuscatedName("jx")
	@ObfuscatedSignature(
		descriptor = "(Lef;II)Z",
		garbageValue = "-2137639716"
	)
	boolean method383(PacketWriter var1, int var2) {
		if (var1.serverPacketLength == 0) {
			class20.friendsChat = null;
		} else {
			if (class20.friendsChat == null) {
				class20.friendsChat = new FriendsChat(class89.loginType, SpriteMask.client);
			}

			class20.friendsChat.method2218(var1.packetBuffer, var2);
		}

		field526 = cycleCntr;
		class344.ClanChat_inClanChat = true;
		var1.serverPacket = null;
		return true;
	}

	@ObfuscatedName("ja")
	@ObfuscatedSignature(
		descriptor = "(Lef;B)Z",
		garbageValue = "-16"
	)
	boolean method384(PacketWriter var1) {
		if (class20.friendsChat != null) {
			class20.friendsChat.method2220(var1.packetBuffer);
		}

		field526 = cycleCntr;
		class344.ClanChat_inClanChat = true;
		var1.serverPacket = null;
		return true;
	}

	@ObfuscatedName("jt")
	@ObfuscatedSignature(
		descriptor = "(Lef;B)Z",
		garbageValue = "1"
	)
	final boolean method385(PacketWriter var1) {
		AbstractSocket var2 = var1.getSocket();
		PacketBuffer var3 = var1.packetBuffer;
		if (var2 == null) {
			return false;
		} else {
			int var6;
			String var20;
			try {
				int var5;
				if (var1.serverPacket == null) {
					if (var1.field1160) {
						if (!var2.isAvailable(1)) {
							return false;
						}

						var2.read(var1.packetBuffer.array, 0, 1);
						var1.field1164 = 0;
						var1.field1160 = false;
					}

					var3.offset = 0;
					if (var3.method2532()) {
						if (!var2.isAvailable(1)) {
							return false;
						}

						var2.read(var1.packetBuffer.array, 1, 1);
						var1.field1164 = 0;
					}

					var1.field1160 = true;
					ServerPacket[] var4 = class12.method46();
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
				var1.field1164 = 0;
				timer.method2170();
				var1.field1166 = var1.field1168;
				var1.field1168 = var1.field1167;
				var1.field1167 = var1.serverPacket;
				String var52;
				if (ServerPacket.TRADING_POST_RESULTS == var1.serverPacket) {
					var52 = var3.readStringCp1252NullTerminated();
					var20 = AbstractFont.escapeBrackets(class20.method77(class128.readString(var3)));
					GrandExchangeOfferUnitPriceComparator.addGameMessage(6, var52, var20);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.VARP_SMALL == var1.serverPacket) {
					class106.processZoneOperation(ZoneOperation.LOC_ADD_CHANGE);
					var1.serverPacket = null;
					return true;
				}

				byte var76;
				if (ServerPacket.SET_MAP_FLAG == var1.serverPacket) {
					class316.method1650();
					var76 = var3.readByte();
					if (var1.serverPacketLength == 1) {
						if (var76 >= 0) {
							currentClanSettings[var76] = null;
						} else {
							class478.guestClanSettings = null;
						}

						var1.serverPacket = null;
						return true;
					}

					if (var76 >= 0) {
						currentClanSettings[var76] = new ClanSettings(var3);
					} else {
						class478.guestClanSettings = new ClanSettings(var3);
					}

					var1.serverPacket = null;
					return true;
				}

				int var7;
				int var8;
				int var9;
				int var11;
				int var21;
				int var23;
				long var63;
				InterfaceParent var75;
				if (ServerPacket.NPC_SPOTANIM_SPECIFIC == var1.serverPacket) {
					var21 = var3.offset + var1.serverPacketLength;
					var5 = var3.readUnsignedShort();
					if (var5 == 65535) {
						var5 = -1;
					}

					var6 = var3.readUnsignedShort();
					if (var5 != rootInterface) {
						rootInterface = var5;
						this.method389(false);
						class130.method713(rootInterface);
						class106.runWidgetOnLoadListener(rootInterface);

						for (var7 = 0; var7 < 100; ++var7) {
							field407[var7] = true;
						}
					}

					InterfaceParent var59;
					for (; var6-- > 0; var59.field863 = true) {
						var7 = var3.readInt();
						var8 = var3.readUnsignedShort();
						var9 = var3.readUnsignedByte();
						var59 = (InterfaceParent)interfaceParents.get((long)var7);
						if (var59 != null && var8 != var59.group) {
							class302.closeInterface(var59, true);
							var59 = null;
						}

						if (var59 == null) {
							var59 = UserComparator8.ifOpenSub(var7, var8, var9);
						}
					}

					for (var75 = (InterfaceParent)interfaceParents.first(); var75 != null; var75 = (InterfaceParent)interfaceParents.next()) {
						if (var75.field863) {
							var75.field863 = false;
						} else {
							class302.closeInterface(var75, true);
						}
					}

					widgetFlags = new NodeHashTable(512);

					while (var3.offset < var21) {
						var7 = var3.readInt();
						var8 = var3.readUnsignedShort();
						var9 = var3.readUnsignedShort();
						var23 = var3.readInt();

						for (var11 = var8; var11 <= var9; ++var11) {
							var63 = ((long)var7 << 32) + (long)var11;
							widgetFlags.put(new IntegerNode(var23), var63);
						}
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.LOGOUT_FULL == var1.serverPacket) {
					var21 = var3.readUnsignedShort();
					var5 = var3.readUnsignedByte();
					var6 = var3.readUnsignedShort();
					class460.queueSoundEffect(var21, var5, var6);
					var1.serverPacket = null;
					return true;
				}

				int var24;
				boolean var62;
				boolean var82;
				if (ServerPacket.VARP_LARGE == var1.serverPacket) {
					isCameraLocked = true;
					field400 = false;
					field402 = true;
					ScriptFrame.cameraLookAtX = var3.readUnsignedByte();
					class216.cameraLookAtY = var3.readUnsignedByte();
					var21 = var3.readUnsignedShort();
					var5 = var3.readUnsignedByte() * 128 + 64;
					var6 = var3.readUnsignedByte() * 128 + 64;
					var7 = var3.readUnsignedShort();
					field403 = var3.readBoolean();
					var8 = var3.readUnsignedByte();
					var9 = ScriptFrame.cameraLookAtX * 128 + 64;
					var23 = class216.cameraLookAtY * 128 + 64;
					var62 = false;
					var82 = false;
					if (field403) {
						var11 = SecureRandomFuture.cameraY;
						var24 = WorldMapDecorationType.getTileHeight(var9, var23, ItemLayer.Client_plane) - var21;
					} else {
						var11 = WorldMapDecorationType.getTileHeight(ViewportMouse.cameraX, class36.cameraZ, ItemLayer.Client_plane) - SecureRandomFuture.cameraY;
						var24 = var21;
					}

					field644 = new class488(ViewportMouse.cameraX, class36.cameraZ, var11, var9, var23, var24, var5, var6, var7, var8);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2648 == var1.serverPacket) {
					publicChatMode = var3.readUnsignedByteNeg();
					tradeChatMode = var3.readUnsignedShortAdd();
					var1.serverPacket = null;
					return true;
				}

				Widget var25;
				if (ServerPacket.SEND_PING == var1.serverPacket) {
					var21 = var3.readUnsignedIntIME();
					var5 = var3.readUnsignedIntME();
					var25 = HealthBarDefinition.widgetDefinition.method1733(var5);
					if (var25 != null && var25.type == 0) {
						if (var21 > var25.scrollHeight - var25.height) {
							var21 = var25.scrollHeight - var25.height;
						}

						if (var21 < 0) {
							var21 = 0;
						}

						if (var21 != var25.scrollY) {
							var25.scrollY = var21;
							class159.invalidateWidget(var25);
						}
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2651 == var1.serverPacket) {
					class90.updateNpcs(true, var3);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.CAM_LOOKAT_EASED_ANGLE_RELATIVE == var1.serverPacket) {
					varclan = null;
					var1.serverPacket = null;
					return true;
				}

				boolean var98;
				if (ServerPacket.field2641 == var1.serverPacket) {
					var98 = var3.readBoolean();
					if (var98) {
						if (MidiPcmStream.field2799 == null) {
							MidiPcmStream.field2799 = new class381();
						}
					} else {
						MidiPcmStream.field2799 = null;
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.MIDI_SONG_STOP == var1.serverPacket) {
					var21 = var3.readUnsignedShort();
					var5 = var3.readUnsignedIntME();
					var25 = HealthBarDefinition.widgetDefinition.method1733(var5);
					if (var25.modelType != 6 || var21 != var25.modelId) {
						var25.modelType = 6;
						var25.modelId = var21;
						class159.invalidateWidget(var25);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.SYNTH_SOUND == var1.serverPacket) {
					return this.method383(var1, 1);
				}

				if (ServerPacket.field2748 == var1.serverPacket) {
					class153.readReflectionCheck(var3, var1.serverPacketLength);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.TOGGLE_OCULUS_ORB == var1.serverPacket) {
					var21 = var3.readUnsignedByte();
					if (var3.readUnsignedByte() == 0) {
						grandExchangeOffers[var21] = new GrandExchangeOffer();
						var3.offset += 18;
					} else {
						--var3.offset;
						grandExchangeOffers[var21] = new GrandExchangeOffer(var3, false);
					}

					field519 = cycleCntr;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.CAM_MOVETO == var1.serverPacket) {
					class106.processZoneOperation(ZoneOperation.OBJ_COUNT);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2682 == var1.serverPacket) {
					minimapState = var3.readUnsignedByte();
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.TRADING_POST_UPDATE == var1.serverPacket) {
					Interpreter.updatePlayers(var3, var1.serverPacketLength);
					WorldMapSectionType.method1314();
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.IF_OPENSUB == var1.serverPacket) {
					for (var21 = 0; var21 < Varps.Varps_main.length; ++var21) {
						if (Varps.Varps_main[var21] != Varps.Varps_temp[var21]) {
							Varps.Varps_main[var21] = Varps.Varps_temp[var21];
							Projectile.changeGameOptions(var21);
							changedVarps[++changedVarpCount - 1 & 31] = var21;
						}
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2670 == var1.serverPacket) {
					var21 = var3.readInt();
					InterfaceParent var80 = (InterfaceParent)interfaceParents.get((long)var21);
					if (var80 != null) {
						class302.closeInterface(var80, true);
					}

					if (meslayerContinueWidget != null) {
						class159.invalidateWidget(meslayerContinueWidget);
						meslayerContinueWidget = null;
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2719 == var1.serverPacket) {
					class316.method1650();
					var76 = var3.readByte();
					class147 var78 = new class147(var3);
					ClanSettings var91;
					if (var76 >= 0) {
						var91 = currentClanSettings[var76];
					} else {
						var91 = class478.guestClanSettings;
					}

					if (var91 == null) {
						this.method395(var76);
						var1.serverPacket = null;
						return true;
					}

					if (var78.field1346 > var91.field1385) {
						this.method395(var76);
						var1.serverPacket = null;
						return true;
					}

					if (var78.field1346 < var91.field1385) {
						var1.serverPacket = null;
						return true;
					}

					var78.method770(var91);
					var1.serverPacket = null;
					return true;
				}

				int var15;
				int var65;
				if (ServerPacket.IF_SETPLAYERMODEL_SELF == var1.serverPacket) {
					var9 = var3.readUnsignedByteSub();
					var23 = var9 >> 2;
					var11 = var9 & 3;
					var24 = field652[var23];
					var65 = var3.readUnsignedShort();
					var6 = var3.readMedium();
					var21 = var6 >> 16;
					var5 = var6 >> 8 & 255;
					var7 = var21 + (var6 >> 4 & 7);
					var8 = var5 + (var6 & 7);
					if (var7 >= 0 && var8 >= 0 && var7 < 103 && var8 < 103) {
						if (var24 == 0) {
							BoundaryObject var68 = class36.scene.method1479(ItemLayer.Client_plane, var7, var8);
							if (var68 != null) {
								var15 = class232.Entity_unpackID(var68.tag);
								if (var23 == 2) {
									var68.renderable1 = new DynamicObject(var15, 2, var11 + 4, ItemLayer.Client_plane, var7, var8, var65, false, var68.renderable1);
									var68.renderable2 = new DynamicObject(var15, 2, var11 + 1 & 3, ItemLayer.Client_plane, var7, var8, var65, false, var68.renderable2);
								} else {
									var68.renderable1 = new DynamicObject(var15, var23, var11, ItemLayer.Client_plane, var7, var8, var65, false, var68.renderable1);
								}
							}
						} else if (var24 == 1) {
							WallDecoration var67 = class36.scene.method1480(ItemLayer.Client_plane, var7, var8);
							if (var67 != null) {
								var15 = class232.Entity_unpackID(var67.tag);
								if (var23 != 4 && var23 != 5) {
									if (var23 == 6) {
										var67.renderable1 = new DynamicObject(var15, 4, var11 + 4, ItemLayer.Client_plane, var7, var8, var65, false, var67.renderable1);
									} else if (var23 == 7) {
										var67.renderable1 = new DynamicObject(var15, 4, (var11 + 2 & 3) + 4, ItemLayer.Client_plane, var7, var8, var65, false, var67.renderable1);
									} else if (var23 == 8) {
										var67.renderable1 = new DynamicObject(var15, 4, var11 + 4, ItemLayer.Client_plane, var7, var8, var65, false, var67.renderable1);
										var67.renderable2 = new DynamicObject(var15, 4, (var11 + 2 & 3) + 4, ItemLayer.Client_plane, var7, var8, var65, false, var67.renderable2);
									}
								} else {
									var67.renderable1 = new DynamicObject(var15, 4, var11, ItemLayer.Client_plane, var7, var8, var65, false, var67.renderable1);
								}
							}
						} else if (var24 == 2) {
							GameObject var64 = class36.scene.getGameObject(ItemLayer.Client_plane, var7, var8);
							if (var23 == 11) {
								var23 = 10;
							}

							if (var64 != null) {
								var64.renderable = new DynamicObject(class232.Entity_unpackID(var64.tag), var23, var11, ItemLayer.Client_plane, var7, var8, var65, false, var64.renderable);
							}
						} else if (var24 == 3) {
							FloorDecoration var66 = class36.scene.getFloorDecoration(ItemLayer.Client_plane, var7, var8);
							if (var66 != null) {
								var66.renderable = new DynamicObject(class232.Entity_unpackID(var66.tag), 22, var11, ItemLayer.Client_plane, var7, var8, var65, false, var66.renderable);
							}
						}
					}

					var1.serverPacket = null;
					return true;
				}

				int var16;
				int var17;
				int var18;
				Projectile var19;
				int var26;
				byte var57;
				byte var81;
				if (ServerPacket.NPC_ANIM_SPECIFIC == var1.serverPacket) {
					var15 = var3.readUnsignedShort();
					var17 = var3.readUnsignedByte();
					var6 = var3.readMedium();
					var21 = var6 >> 16;
					var5 = var6 >> 8 & 255;
					var7 = var21 + (var6 >> 4 & 7);
					var8 = var5 + (var6 & 7);
					var57 = var3.readByte();
					var16 = var3.readUnsignedShortAddLE();
					var24 = var3.readUnsignedShort();
					var11 = var3.method2610();
					var26 = var3.readUnsignedShortAdd() * 4;
					var65 = var3.readUnsignedByte() * 4;
					var18 = var3.readUnsignedIntIME();
					var81 = var3.readByteAdd();
					var9 = var57 + var7;
					var23 = var81 + var8;
					if (var7 >= 0 && var8 >= 0 && var7 < 104 && var8 < 104 && var9 >= 0 && var23 >= 0 && var9 < 104 && var23 < 104 && var24 != 65535) {
						var7 = var7 * 128 + 64;
						var8 = var8 * 128 + 64;
						var9 = var9 * 128 + 64;
						var23 = var23 * 128 + 64;
						var19 = new Projectile(var24, ItemLayer.Client_plane, var7, var8, WorldMapDecorationType.getTileHeight(var7, var8, ItemLayer.Client_plane) - var65, var15 + cycle, var16 + cycle, var17, var18, var11, var26);
						var19.setDestination(var9, var23, WorldMapDecorationType.getTileHeight(var9, var23, ItemLayer.Client_plane) - var26, var15 + cycle);
						projectiles.addFirst(var19);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2724 == var1.serverPacket) {
					class106.processZoneOperation(ZoneOperation.MAPPROJ_ANIM);
					var1.serverPacket = null;
					return true;
				}

				Widget var22;
				if (ServerPacket.UPDATE_ZONE_FULL_FOLLOWS == var1.serverPacket) {
					var21 = var3.readUnsignedByte();
					var5 = var3.readUnsignedShortAdd();
					var6 = var3.readInt();
					var22 = HealthBarDefinition.widgetDefinition.method1733(var6);
					ZoneOperation.method1633(var22, var21, var5);
					class159.invalidateWidget(var22);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.HINT_ARROW == var1.serverPacket) {
					var21 = var3.readUnsignedShortLE();
					var5 = var3.readIntIME();
					var6 = var3.readUnsignedShortAdd();
					var75 = (InterfaceParent)interfaceParents.get((long)var5);
					if (var75 != null) {
						class302.closeInterface(var75, var21 != var75.group);
					}

					UserComparator8.ifOpenSub(var5, var21, var6);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.UPDATE_ZONE_PARTIAL_ENCLOSED == var1.serverPacket) {
					var21 = var3.readInt();
					var5 = var3.readUnsignedShort();
					if (var21 < -70000) {
						var5 += 32768;
					}

					if (var21 >= 0) {
						var25 = HealthBarDefinition.widgetDefinition.method1733(var21);
					} else {
						var25 = null;
					}

					if (var25 != null) {
						for (var7 = 0; var7 < var25.itemIds.length; ++var7) {
							var25.itemIds[var7] = 0;
							var25.field3077[var7] = 0;
						}
					}

					class28.clearItemContainer(var5);
					var7 = var3.readUnsignedShort();

					for (var8 = 0; var8 < var7; ++var8) {
						var9 = var3.readUnsignedIntIME();
						var23 = var3.readUnsignedShortAdd();
						if (var23 == 255) {
							var23 = var3.readInt();
						}

						if (var25 != null && var8 < var25.itemIds.length) {
							var25.itemIds[var8] = var9;
							var25.field3077[var8] = var23;
						}

						class185.itemContainerSetItem(var5, var8, var9 - 1, var23);
					}

					if (var25 != null) {
						class159.invalidateWidget(var25);
					}

					class396.method2042();
					changedItemContainers[++changedItemContainersCount - 1 & 31] = var5 & 32767;
					var1.serverPacket = null;
					return true;
				}

				Widget var74;
				if (ServerPacket.field2674 == var1.serverPacket) {
					var21 = var3.readIntIME();
					var74 = HealthBarDefinition.widgetDefinition.method1733(var21);

					for (var6 = 0; var6 < var74.itemIds.length; ++var6) {
						var74.itemIds[var6] = -1;
						var74.itemIds[var6] = 0;
					}

					class159.invalidateWidget(var74);
					var1.serverPacket = null;
					return true;
				}

				long var27;
				long var29;
				String var34;
				if (ServerPacket.NPC_HEADICON_SPECIFIC == var1.serverPacket) {
					var52 = var3.readStringCp1252NullTerminated();
					var27 = (long)var3.readUnsignedShort();
					var29 = (long)var3.readMedium();
					PlayerType var90 = (PlayerType)class12.findEnumerated(class320.PlayerType_values(), var3.readUnsignedByte());
					long var32 = (var27 << 32) + var29;
					var82 = false;

					for (var65 = 0; var65 < 100; ++var65) {
						if (field615[var65] == var32) {
							var82 = true;
							break;
						}
					}

					if (class12.friendSystem.isIgnored(new Username(var52, class89.loginType))) {
						var82 = true;
					}

					if (!var82 && field479 == 0) {
						field615[field533] = var32;
						field533 = (field533 + 1) % 100;
						var34 = AbstractFont.escapeBrackets(class20.method77(class128.readString(var3)));
						byte var87;
						if (var90.isPrivileged) {
							var87 = 7;
						} else {
							var87 = 3;
						}

						if (var90.modIcon != -1) {
							GrandExchangeOfferUnitPriceComparator.addGameMessage(var87, FloorUnderlayDefinition.addImageTag(var90.modIcon) + var52, var34);
						} else {
							GrandExchangeOfferUnitPriceComparator.addGameMessage(var87, var52, var34);
						}
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.IF_SETPLAYERMODEL_BASECOLOUR == var1.serverPacket) {
					ObjTypeCustomisation.privateChatMode = WorldMapArea.method1204(var3.readUnsignedByte());
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.UPDATE_FRIENDLIST == var1.serverPacket) {
					isCameraLocked = true;
					field400 = false;
					field404 = true;
					var21 = class319.method1705(var3.readShort() & 2027);
					var5 = class240.method1293(var3.readShort() & 2027);
					var6 = var3.readUnsignedShort();
					var7 = var3.readUnsignedByte();
					field642 = new class490(Varcs.cameraPitch, var5, var6, var7);
					field643 = new class490(class192.cameraYaw, var21, var6, var7);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2656 == var1.serverPacket) {
					rebootTimer = var3.readUnsignedShort() * 30;
					field522 = cycleCntr;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.MIDI_SONG_WITH_SECONDARY == var1.serverPacket) {
					var21 = var3.readInt();
					var74 = HealthBarDefinition.widgetDefinition.method1733(var21);
					var74.modelType = 3;
					var74.modelId = class229.localPlayer.appearance.getChatHeadId();
					class159.invalidateWidget(var74);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.UPDATE_STAT == var1.serverPacket) {
					var21 = var3.method2602();
					var5 = var3.readInt();
					var25 = HealthBarDefinition.widgetDefinition.method1733(var5);
					if (var21 != var25.sequenceId || var21 == -1) {
						var25.sequenceId = var21;
						var25.modelFrame = 0;
						var25.modelFrameCycle = 0;
						class159.invalidateWidget(var25);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.MIDI_SONG == var1.serverPacket) {
					class396.method2042();
					runEnergy = var3.readUnsignedShort();
					field522 = cycleCntr;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.REFLECTIONCHECK_FRIENDLIST == var1.serverPacket) {
					var76 = var3.readByteNeg();
					var5 = var3.readUnsignedShort();
					Varps.Varps_temp[var5] = var76;
					if (Varps.Varps_main[var5] != var76) {
						Varps.Varps_main[var5] = var76;
					}

					Projectile.changeGameOptions(var5);
					changedVarps[++changedVarpCount - 1 & 31] = var5;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2756 == var1.serverPacket) {
					return this.method383(var1, 2);
				}

				if (ServerPacket.SET_PLAYER_OP == var1.serverPacket) {
					class106.processZoneOperation(ZoneOperation.field2622);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.UPDATE_IGNORELIST == var1.serverPacket) {
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

				if (ServerPacket.RUN_CLIENTSCRIPT == var1.serverPacket) {
					if (varclan == null) {
						varclan = new class466(Players.Widget_cachedFonts);
					}

					class535 var53 = Players.Widget_cachedFonts.method2340(var3);
					varclan.field3929.vmethod8143(var53.field4244, var53.field4243);
					field571[++field510 - 1 & 31] = var53.field4244;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.UPDATE_RUNWEIGHT == var1.serverPacket) {
					var21 = var3.readUnsignedShort();
					var5 = var3.readIntME();
					var25 = HealthBarDefinition.widgetDefinition.method1733(var5);
					if (var25.modelType != 1 || var21 != var25.modelId) {
						var25.modelType = 1;
						var25.modelId = var21;
						class159.invalidateWidget(var25);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.MESSAGE_GAME == var1.serverPacket) {
					var5 = var3.readUnsignedShortLE();
					var7 = var3.readUnsignedShortAdd();
					var6 = var3.readUnsignedIntME();
					var21 = var3.readUnsignedIntIME();
					Player var95;
					if (var21 == localPlayerIndex) {
						var95 = class229.localPlayer;
					} else {
						var95 = players[var21];
					}

					if (var95 != null) {
						var95.updateSpotAnimation(var7, var5, var6 >> 16, var6 & 65535);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.MIDI_JINGLE == var1.serverPacket) {
					var21 = var3.readUnsignedIntIME();
					WorldMapEvent.method1383(var21);
					changedItemContainers[++changedItemContainersCount - 1 & 31] = var21 & 32767;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2698 == var1.serverPacket) {
					var21 = var3.readInt();
					var5 = var3.readInt();
					var6 = class167.getGcDuration();
					PacketBufferNode var79 = class113.getPacketBufferNode(ClientPacket.OPHELDD, packetWriter.isaacCipher);
					var79.packetBuffer.method2613(var21);
					var79.packetBuffer.writeIntLE(var5);
					var79.packetBuffer.writeByteNeg(var6);
					var79.packetBuffer.writeByte(GameEngine.fps);
					packetWriter.addNode(var79);
					var1.serverPacket = null;
					return true;
				}

				String var84;
				if (ServerPacket.LOGIN_SCREEN_PACKET == var1.serverPacket) {
					var21 = var3.readUnsignedByte();
					var5 = var3.readUnsignedByteNeg();
					var84 = var3.readStringCp1252NullTerminated();
					if (var21 >= 1 && var21 <= 8) {
						if (var84.equalsIgnoreCase("null")) {
							var84 = null;
						}

						playerMenuActions[var21 - 1] = var84;
						playerOptionsPriorities[var21 - 1] = var5 == 0;
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.MESSAGE_CLANCHANNEL_SYSTEM == var1.serverPacket) {
					class12.friendSystem.method409();
					field524 = cycleCntr;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.IF_SETANIM == var1.serverPacket) {
					varclan = new class466(Players.Widget_cachedFonts);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.VARCLAN_ENABLE == var1.serverPacket) {
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.UPDATE_REBOOT_TIMER == var1.serverPacket) {
					var21 = var3.readUnsignedByte();
					var5 = var3.readUnsignedByte();
					var6 = var3.readUnsignedByte();
					var7 = var3.readUnsignedByte();
					cameraShaking[var21] = true;
					cameraShakeIntensity[var21] = var5;
					cameraMoveIntensity[var21] = var6;
					cameraShakeSpeed[var21] = var7;
					field589[var21] = 0;
					var1.serverPacket = null;
					return true;
				}

				Widget var93;
				if (ServerPacket.UPDATE_UID192 == var1.serverPacket) {
					var21 = var3.readUnsignedIntIME();
					var5 = var3.readInt();
					var6 = var3.readUnsignedShortLE();
					var7 = var3.readUnsignedShortAddLE();
					var93 = HealthBarDefinition.widgetDefinition.method1733(var5);
					if (var21 != var93.modelAngleX || var6 != var93.modelAngleY || var7 != var93.modelZoom) {
						var93.modelAngleX = var21;
						var93.modelAngleY = var6;
						var93.modelZoom = var7;
						class159.invalidateWidget(var93);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.IF_SETNPCHEAD == var1.serverPacket) {
					class106.processZoneOperation(ZoneOperation.field2620);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.UPDATE_SITESETTINGS == var1.serverPacket) {
					var21 = var3.readInt();
					if (var21 != field367) {
						field367 = var21;
						VerticalAlignment.method960();
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.CLANSETTINGS_FULL == var1.serverPacket) {
					class12.friendSystem.readUpdate(var3, var1.serverPacketLength);
					field524 = cycleCntr;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.MESSAGE_FRIENDCHANNEL == var1.serverPacket) {
					var98 = var3.readUnsignedByte() == 1;
					if (var98) {
						class489.field3990 = SpotAnimationDefinition.method962() - var3.readLong();
						class6.grandExchangeEvents = new GrandExchangeEvents(var3, true);
					} else {
						class6.grandExchangeEvents = null;
					}

					field527 = cycleCntr;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.REBUILD_REGION_NORMAL == var1.serverPacket) {
					var21 = var3.readUnsignedShort();
					if (var21 == 65535) {
						var21 = -1;
					}

					rootInterface = var21;
					this.method389(false);
					class130.method713(var21);
					class106.runWidgetOnLoadListener(rootInterface);

					for (var5 = 0; var5 < 100; ++var5) {
						field407[var5] = true;
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2642 == var1.serverPacket) {
					var21 = var3.readUnsignedShortAddLE();
					var6 = var3.readUnsignedByteNeg();
					var5 = var3.readUnsignedShortLE();
					if (var5 == 65535) {
						var5 = -1;
					}

					NPC var77 = npcs[var21];
					if (var77 != null) {
						if (var5 == var77.sequence && var5 != -1) {
							var8 = DynamicObject.SequenceDefinition_get(var5).replyMode;
							if (var8 == 1) {
								var77.sequenceFrame = 0;
								var77.sequenceFrameCycle = 0;
								var77.sequenceDelay = var6;
								var77.currentSequenceFrameIndex = 0;
							} else if (var8 == 2) {
								var77.currentSequenceFrameIndex = 0;
							}
						} else if (var5 == -1 || var77.sequence == -1 || DynamicObject.SequenceDefinition_get(var5).forcedPriority >= DynamicObject.SequenceDefinition_get(var77.sequence).forcedPriority) {
							var77.sequence = var5;
							var77.sequenceFrame = 0;
							var77.sequenceFrameCycle = 0;
							var77.sequenceDelay = var6;
							var77.currentSequenceFrameIndex = 0;
							var77.field1029 = var77.pathLength;
						}
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.NEW_PACKET_CAM_RESET_V2 == var1.serverPacket) {
					for (var21 = 0; var21 < players.length; ++var21) {
						if (players[var21] != null) {
							players[var21].sequence = -1;
						}
					}

					for (var21 = 0; var21 < npcs.length; ++var21) {
						if (npcs[var21] != null) {
							npcs[var21].sequence = -1;
						}
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2753 == var1.serverPacket) {
					class90.updateNpcs(false, var3);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2713 == var1.serverPacket) {
					class13.method51();
					var1.serverPacket = null;
					return false;
				}

				if (ServerPacket.OBJ_ADD == var1.serverPacket) {
					class396.method2042();
					weight = var3.readShort();
					field522 = cycleCntr;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.PLAYER_INFO == var1.serverPacket) {
					class106.processZoneOperation(ZoneOperation.LOC_DEL);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.REBUILD_REGION == var1.serverPacket) {
					isCameraLocked = true;
					field400 = false;
					field402 = false;
					ScriptFrame.cameraLookAtX = var3.readUnsignedByte();
					class216.cameraLookAtY = var3.readUnsignedByte();
					class127.cameraLookAtHeight = var3.readUnsignedShort();
					WorldMapIcon_0.cameraMoveToSpeed = var3.readUnsignedByte();
					class1.cameraLookAtAcceleration = var3.readUnsignedByte();
					if (class1.cameraLookAtAcceleration >= 100) {
						ViewportMouse.cameraX = ScriptFrame.cameraLookAtX * 128 + 64;
						class36.cameraZ = class216.cameraLookAtY * 128 + 64;
						SecureRandomFuture.cameraY = WorldMapDecorationType.getTileHeight(ViewportMouse.cameraX, class36.cameraZ, ItemLayer.Client_plane) - class127.cameraLookAtHeight;
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.SPOTANIM_SPECIFIC == var1.serverPacket) {
					return this.method384(var1);
				}

				if (ServerPacket.field2736 == var1.serverPacket) {
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

				if (ServerPacket.field2694 == var1.serverPacket) {
					var3.offset += 28;
					if (var3.checkCrc()) {
						class336.method1741(var3, var3.offset - 28);
					}

					var1.serverPacket = null;
					return true;
				}

				long var36;
				if (ServerPacket.field2673 == var1.serverPacket) {
					var76 = var3.readByte();
					var27 = (long)var3.readUnsignedShort();
					var29 = (long)var3.readMedium();
					var36 = (var27 << 32) + var29;
					var62 = false;
					ClanChannel var96 = var76 >= 0 ? currentClanChannels[var76] : ItemContainer.guestClanChannel;
					if (var96 == null) {
						var62 = true;
					} else {
						for (var65 = 0; var65 < 100; ++var65) {
							if (var36 == field615[var65]) {
								var62 = true;
								break;
							}
						}
					}

					if (!var62) {
						field615[field533] = var36;
						field533 = (field533 + 1) % 100;
						var34 = class128.readString(var3);
						var26 = var76 >= 0 ? 43 : 46;
						ArchiveLoader.addChatMessage(var26, "", var34, var96.name);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.UPDATE_INV_FULL == var1.serverPacket) {
					var8 = var3.readUnsignedShortAddLE();
					var5 = var3.readUnsignedShortLE();
					var7 = var3.readUnsignedIntIME();
					var6 = var3.readUnsignedShortLE();
					var21 = var3.readUnsignedShortAddLE();
					if (var21 == 65535) {
						var21 = -1;
					}

					ArrayList var31 = new ArrayList();
					var31.add(var21);
					class135.method734(var31, var5, var6, var7, var8);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.OBJ_DEL_LEGACY == var1.serverPacket) {
					var21 = var3.readIntIME();
					var20 = var3.readStringCp1252NullTerminated();
					var25 = HealthBarDefinition.widgetDefinition.method1733(var21);
					if (!var20.equals(var25.text)) {
						var25.text = var20;
						class159.invalidateWidget(var25);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2757 == var1.serverPacket) {
					var5 = var3.readUnsignedShort();
					var7 = var3.readUnsignedIntIME();
					var21 = var3.readUnsignedShortLE();
					var6 = var3.readUnsignedShortAddLE();
					class191.someMusicMethod(var21, var5, var6, var7);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2745 == var1.serverPacket) {
					class12.friendSystem.ignoreList.read(var3, var1.serverPacketLength);
					DelayFadeTask.FriendSystem_invalidateIgnoreds();
					field524 = cycleCntr;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.MESSAGE_PRIVATE == var1.serverPacket) {
					class106.processZoneOperation(ZoneOperation.field2618);
					var1.serverPacket = null;
					return true;
				}

				String var40;
				if (ServerPacket.PREFETCH_GAMEOBJECTS == var1.serverPacket) {
					var52 = var3.readStringCp1252NullTerminated();
					var27 = var3.readLong();
					var29 = (long)var3.readUnsignedShort();
					var36 = (long)var3.readMedium();
					PlayerType var97 = (PlayerType)class12.findEnumerated(class320.PlayerType_values(), var3.readUnsignedByte());
					var63 = (var29 << 32) + var36;
					boolean var85 = false;

					for (var15 = 0; var15 < 100; ++var15) {
						if (field615[var15] == var63) {
							var85 = true;
							break;
						}
					}

					if (var97.isUser && class12.friendSystem.isIgnored(new Username(var52, class89.loginType))) {
						var85 = true;
					}

					if (!var85 && field479 == 0) {
						field615[field533] = var63;
						field533 = (field533 + 1) % 100;
						var40 = AbstractFont.escapeBrackets(class20.method77(class128.readString(var3)));
						if (var97.modIcon != -1) {
							ArchiveLoader.addChatMessage(9, FloorUnderlayDefinition.addImageTag(var97.modIcon) + var52, var40, HitSplatDefinition.base37DecodeLong(var27));
						} else {
							ArchiveLoader.addChatMessage(9, var52, var40, HitSplatDefinition.base37DecodeLong(var27));
						}
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.IF_OPENTOP == var1.serverPacket) {
					var52 = var3.readStringCp1252NullTerminated();
					Object[] var73 = new Object[var52.length() + 1];

					for (var6 = var52.length() - 1; var6 >= 0; --var6) {
						if (var52.charAt(var6) == 's') {
							var73[var6 + 1] = var3.readStringCp1252NullTerminated();
						} else {
							var73[var6 + 1] = new Integer(var3.readInt());
						}
					}

					var73[0] = new Integer(var3.readInt());
					ScriptEvent var89 = new ScriptEvent();
					var89.args = var73;
					class157.runScriptEvent(var89);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2722 == var1.serverPacket) {
					var21 = var3.readUnsignedByte();
					WorldMapIcon_1.method1194(var21);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.VARCLAN_DISABLE == var1.serverPacket) {
					if (rootInterface != -1) {
						class514.runIntfCloseListener(rootInterface, 0);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.OBJ_COUNT == var1.serverPacket && isCameraLocked) {
					field400 = true;
					field404 = false;
					field402 = false;

					for (var21 = 0; var21 < 5; ++var21) {
						cameraShaking[var21] = false;
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2740 == var1.serverPacket) {
					var21 = var3.readUnsignedShortLE();
					var5 = var3.readInt();
					var6 = var21 >> 10 & 31;
					var7 = var21 >> 5 & 31;
					var8 = var21 & 31;
					var9 = (var7 << 11) + (var6 << 19) + (var8 << 3);
					Widget var58 = HealthBarDefinition.widgetDefinition.method1733(var5);
					if (var9 != var58.color) {
						var58.color = var9;
						class159.invalidateWidget(var58);
					}

					var1.serverPacket = null;
					return true;
				}

				NPC var94;
				if (ServerPacket.UPDATE_INV_STOP_TRANSMIT == var1.serverPacket) {
					var21 = var3.readUnsignedShortAddLE();
					var94 = npcs[var21];
					var6 = var3.readUnsignedShortAddLE();
					var5 = var3.readIntIME();
					var7 = var3.readUnsignedShortAdd();
					if (var94 != null) {
						var94.updateSpotAnimation(var7, var6, var5 >> 16, var5 & 65535);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.MESSAGE_CLANCHANNEL == var1.serverPacket) {
					field525 = cycleCntr;
					var76 = var3.readByte();
					if (var1.serverPacketLength == 1) {
						if (var76 >= 0) {
							currentClanChannels[var76] = null;
						} else {
							ItemContainer.guestClanChannel = null;
						}

						var1.serverPacket = null;
						return true;
					}

					if (var76 >= 0) {
						currentClanChannels[var76] = new ClanChannel(var3);
					} else {
						ItemContainer.guestClanChannel = new ClanChannel(var3);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.RESET_ANIMS == var1.serverPacket) {
					var21 = var3.readUnsignedIntME();
					var5 = var3.readUnsignedShortLE();
					short var60 = (short)var3.readShort();
					var7 = var3.readUnsignedShortAdd();
					var94 = npcs[var5];
					if (var94 != null) {
						var94.method586(var7, var21, var60);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.CAM_SHAKE == var1.serverPacket) {
					class18.field55 = var3.readUnsignedByteNeg();
					class6.field6 = var3.readUnsignedByteSub();

					while (var3.offset < var1.serverPacketLength) {
						var21 = var3.readUnsignedByte();
						ZoneOperation var72 = class520.method2524()[var21];
						class106.processZoneOperation(var72);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.RESET_CLIENT_VARCACHE == var1.serverPacket) {
					field525 = cycleCntr;
					var76 = var3.readByte();
					class161 var71 = new class161(var3);
					ClanChannel var88;
					if (var76 >= 0) {
						var88 = currentClanChannels[var76];
					} else {
						var88 = ItemContainer.guestClanChannel;
					}

					if (var88 == null) {
						this.method394(var76);
						var1.serverPacket = null;
						return true;
					}

					if (var71.field1409 > var88.field1421) {
						this.method394(var76);
						var1.serverPacket = null;
						return true;
					}

					if (var71.field1409 < var88.field1421) {
						var1.serverPacket = null;
						return true;
					}

					var71.method844(var88);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2709 == var1.serverPacket) {
					class106.processZoneOperation(ZoneOperation.OBJ_DEL);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.IF_CLOSESUB == var1.serverPacket) {
					class106.processZoneOperation(ZoneOperation.field2616);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.CHAT_FILTER_SETTINGS_PRIVATECHAT == var1.serverPacket) {
					class396.method2042();
					var21 = var3.readUnsignedByteSub();
					var5 = var3.readIntME();
					var6 = var3.readUnsignedByte();
					experience[var21] = var5;
					currentLevels[var21] = var6;
					levels[var21] = 1;
					field564[var21] = var6;

					for (var7 = 0; var7 < 98; ++var7) {
						if (var5 >= Skills.Skills_experienceTable[var7]) {
							levels[var21] = var7 + 2;
						}
					}

					changedSkills[++changedSkillsCount - 1 & 31] = var21;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.LOC_ANIM_SPECIFIC == var1.serverPacket) {
					class106.processZoneOperation(ZoneOperation.field2625);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.UPDATE_ZONE_PARTIAL_FOLLOWS == var1.serverPacket) {
					class410.method2140(var3.readStringCp1252NullTerminated());
					var1.serverPacket = null;
					return true;
				}

				boolean var55;
				if (ServerPacket.field2697 == var1.serverPacket) {
					var21 = var3.readIntME();
					var55 = var3.readUnsignedByte() == 1;
					var25 = HealthBarDefinition.widgetDefinition.method1733(var21);
					if (var55 != var25.isHidden) {
						var25.isHidden = var55;
						class159.invalidateWidget(var25);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2655 == var1.serverPacket) {
					class106.processZoneOperation(ZoneOperation.PREFETCH_GAMEOBJECTS);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.UPDATE_RUNENERGY == var1.serverPacket) {
					class18.field55 = var3.readUnsignedShortAdd();
					class6.field6 = var3.readUnsignedByteSub();
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.CAM_RESET == var1.serverPacket) {
					for (var21 = 0; var21 < VarpDefinition.field1443; ++var21) {
						VarpDefinition var70 = FloorOverlayDefinition.VarpDefinition_get(var21);
						if (var70 != null) {
							Varps.Varps_temp[var21] = 0;
							Varps.Varps_main[var21] = 0;
						}
					}

					class396.method2042();
					changedVarpCount += 32;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.IF_SETOBJECT == var1.serverPacket) {
					class106.processZoneOperation(ZoneOperation.AREA_SOUND);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.MESSAGE_PRIVATE_ECHO == var1.serverPacket) {
					var21 = var3.readInt();
					var5 = var3.readUnsignedShort();
					if (var21 < -70000) {
						var5 += 32768;
					}

					if (var21 >= 0) {
						var25 = HealthBarDefinition.widgetDefinition.method1733(var21);
					} else {
						var25 = null;
					}

					for (; var3.offset < var1.serverPacketLength; class185.itemContainerSetItem(var5, var7, var8 - 1, var9)) {
						var7 = var3.readUShortSmart();
						var8 = var3.readUnsignedShort();
						var9 = 0;
						if (var8 != 0) {
							var9 = var3.readUnsignedByte();
							if (var9 == 255) {
								var9 = var3.readInt();
							}
						}

						if (var25 != null && var7 >= 0 && var7 < var25.itemIds.length) {
							var25.itemIds[var7] = var8;
							var25.field3077[var7] = var9;
						}
					}

					if (var25 != null) {
						class159.invalidateWidget(var25);
					}

					class396.method2042();
					changedItemContainers[++changedItemContainersCount - 1 & 31] = var5 & 32767;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.PLAYER_ANIM_SPECIFIC == var1.serverPacket) {
					World var51 = new World();
					var51.host = var3.readStringCp1252NullTerminated();
					var51.id = var3.readUnsignedShort();
					var5 = var3.readInt();
					var51.properties = var5;
					if (var51.isDeadman()) {
						var51.field679 = "beta";
					}

					WorldMapSection2.updateGameState(45);
					var2.close();
					var2 = null;
					class28.changeWorld(var51);
					var1.serverPacket = null;
					return false;
				}

				if (ServerPacket.IF_SETTEXT == var1.serverPacket) {
					var21 = var3.readUnsignedIntME();
					var5 = var3.readIntIME();
					InterfaceParent var86 = (InterfaceParent)interfaceParents.get((long)var5);
					var75 = (InterfaceParent)interfaceParents.get((long)var21);
					if (var75 != null) {
						class302.closeInterface(var75, var86 == null || var86.group != var75.group);
					}

					if (var86 != null) {
						var86.remove();
						interfaceParents.put(var86, (long)var21);
					}

					var93 = HealthBarDefinition.widgetDefinition.method1733(var5);
					if (var93 != null) {
						class159.invalidateWidget(var93);
					}

					var93 = HealthBarDefinition.widgetDefinition.method1733(var21);
					if (var93 != null) {
						class159.invalidateWidget(var93);
						class132.revalidateWidgetScroll(HealthBarDefinition.widgetDefinition.Widget_interfaceComponents[var93.id >>> 16], var93, true);
					}

					if (rootInterface != -1) {
						class514.runIntfCloseListener(rootInterface, 1);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.IF_SETPLAYERMODEL_OBJ == var1.serverPacket) {
					isCameraLocked = true;
					field400 = false;
					field402 = true;
					ScriptFrame.cameraLookAtX = var3.readUnsignedByte();
					class216.cameraLookAtY = var3.readUnsignedByte();
					var21 = var3.readUnsignedShort();
					var5 = var3.readUnsignedShort();
					field403 = var3.readBoolean();
					var6 = var3.readUnsignedByte();
					var7 = ScriptFrame.cameraLookAtX * 128 + 64;
					var8 = class216.cameraLookAtY * 128 + 64;
					boolean var61 = false;
					boolean var83 = false;
					if (field403) {
						var9 = SecureRandomFuture.cameraY;
						var23 = WorldMapDecorationType.getTileHeight(var7, var8, ItemLayer.Client_plane) - var21;
					} else {
						var9 = WorldMapDecorationType.getTileHeight(ViewportMouse.cameraX, class36.cameraZ, ItemLayer.Client_plane) - SecureRandomFuture.cameraY;
						var23 = var21;
					}

					field644 = new class489(ViewportMouse.cameraX, class36.cameraZ, var9, var7, var8, var23, var5, var6);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.TRIGGER_ONDIALOGABORT == var1.serverPacket) {
					var9 = var3.readUnsignedShortLE();
					var8 = var3.readUnsignedShortAddLE();
					var21 = var3.readUnsignedShortAddLE();
					if (var21 == 65535) {
						var21 = -1;
					}

					var7 = var3.readUnsignedShortLE();
					var6 = var3.readUnsignedShortLE();
					var5 = var3.readUnsignedShortLE();
					if (var5 == 65535) {
						var5 = -1;
					}

					ArrayList var56 = new ArrayList();
					var56.add(var21);
					var56.add(var5);
					class135.method734(var56, var6, var7, var8, var9);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.MIDI_SWAP == var1.serverPacket) {
					GrandExchangeOfferUnitPriceComparator.loadRegions(true, var1.packetBuffer, false);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.SYNC_CLIENT_VARCACHE == var1.serverPacket) {
					var11 = var3.method2610();
					var26 = var3.readUnsignedByteNeg() * 4;
					var24 = var3.readUnsignedShortAddLE();
					var6 = var3.method2606();
					var21 = var6 >> 16;
					var5 = var6 >> 8 & 255;
					var7 = var21 + (var6 >> 4 & 7);
					var8 = var5 + (var6 & 7);
					var15 = var3.readUnsignedShortLE();
					var57 = var3.readByte();
					var18 = var3.readUnsignedByteSub();
					var16 = var3.readUnsignedIntIME();
					var17 = var3.readUnsignedShortAdd();
					var81 = var3.readByteAdd();
					var65 = var3.readUnsignedByte() * 4;
					var9 = var57 + var7;
					var23 = var81 + var8;
					if (var7 >= 0 && var8 >= 0 && var7 < 104 && var8 < 104 && var9 >= 0 && var23 >= 0 && var9 < 104 && var23 < 104 && var24 != 65535) {
						var7 = var7 * 128 + 64;
						var8 = var8 * 128 + 64;
						var9 = var9 * 128 + 64;
						var23 = var23 * 128 + 64;
						var19 = new Projectile(var24, ItemLayer.Client_plane, var7, var8, WorldMapDecorationType.getTileHeight(var7, var8, ItemLayer.Client_plane) - var65, var15 + cycle, var16 + cycle, var17, var18, var11, var26);
						var19.setDestination(var9, var23, WorldMapDecorationType.getTileHeight(var9, var23, ItemLayer.Client_plane) - var26, var15 + cycle);
						projectiles.addFirst(var19);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.NPC_INFO_LARGE == var1.serverPacket) {
					GrandExchangeOfferUnitPriceComparator.loadRegions(false, var1.packetBuffer, false);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.ENTER_FREECAM == var1.serverPacket) {
					GrandExchangeOfferUnitPriceComparator.loadRegions(false, var1.packetBuffer, true);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2707 == var1.serverPacket) {
					var5 = var3.readUnsignedShortAddLE();
					var21 = var3.readUnsignedShortLE();
					WorldMapManager.method1265(var21, var5);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.NEW_PACK_215 == var1.serverPacket) {
					var21 = var3.method2602();
					var5 = var3.method2604();
					var6 = var3.readIntIME();
					var22 = HealthBarDefinition.widgetDefinition.method1733(var6);
					if (var5 != var22.rawX || var21 != var22.rawY || var22.xAlignment != 0 || var22.yAlignment != 0) {
						var22.rawX = var5;
						var22.rawY = var21;
						var22.xAlignment = 0;
						var22.yAlignment = 0;
						class159.invalidateWidget(var22);
						this.alignWidget(var22);
						if (var22.type == 0) {
							class132.revalidateWidgetScroll(HealthBarDefinition.widgetDefinition.Widget_interfaceComponents[var6 >> 16], var22, false);
						}
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.VARCLAN == var1.serverPacket) {
					var21 = var3.readUnsignedShort();
					if (var21 == 65535) {
						var21 = -1;
					}

					class102.playSong(var21);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.IF_SETSCROLLPOS == var1.serverPacket) {
					var21 = var3.method2607();
					var5 = var3.readUnsignedIntIME();
					if (var5 == 65535) {
						var5 = -1;
					}

					FileSystem.playJingle(var5, var21);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.MINIMAP_TOGGLE == var1.serverPacket) {
					isCameraLocked = true;
					field400 = false;
					field404 = true;
					var21 = var3.readShort();
					var5 = var3.readShort();
					var6 = class240.method1293(var5 + Varcs.cameraPitch & 2027);
					var7 = var21 + class192.cameraYaw;
					var8 = var3.readUnsignedShort();
					var9 = var3.readUnsignedByte();
					field642 = new class490(Varcs.cameraPitch, var6, var8, var9);
					field643 = new class490(class192.cameraYaw, var7, var8, var9);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.OPEN_URL == var1.serverPacket) {
					var21 = var3.readUnsignedShortLE();
					var5 = var3.readUnsignedShortLE();
					var6 = var3.readIntIME();
					var22 = HealthBarDefinition.widgetDefinition.method1733(var6);
					var22.rotationKey = var5 + (var21 << 16);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2728 == var1.serverPacket) {
					class18.field55 = var3.readUnsignedShortAdd();
					class6.field6 = var3.readUnsignedShortAdd();

					for (var21 = class18.field55; var21 < class18.field55 + 8; ++var21) {
						for (var5 = class6.field6; var5 < class6.field6 + 8; ++var5) {
							if (groundItems[ItemLayer.Client_plane][var21][var5] != null) {
								groundItems[ItemLayer.Client_plane][var21][var5] = null;
								ClanSettings.updateItemPile(var21, var5);
							}
						}
					}

					for (PendingSpawn var50 = (PendingSpawn)pendingSpawns.last(); var50 != null; var50 = (PendingSpawn)pendingSpawns.previous()) {
						if (var50.x >= class18.field55 && var50.x < class18.field55 + 8 && var50.y >= class6.field6 && var50.y < class6.field6 + 8 && var50.plane == ItemLayer.Client_plane) {
							var50.endCycle = 0;
						}
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2684 == var1.serverPacket) {
					isCameraLocked = true;
					field400 = false;
					field404 = true;
					Messages.field1154 = var3.readUnsignedByte();
					AbstractWorldMapData.field2045 = var3.readUnsignedByte();
					class302.field2510 = var3.readUnsignedShort();
					var21 = var3.readUnsignedShort();
					var5 = var3.readUnsignedByte();
					var6 = Messages.field1154 * 128 + 64;
					var7 = AbstractWorldMapData.field2045 * 128 + 64;
					var8 = WorldMapDecorationType.getTileHeight(var6, var7, ItemLayer.Client_plane) - class302.field2510;
					var9 = var6 - ViewportMouse.cameraX;
					var23 = var8 - SecureRandomFuture.cameraY;
					var11 = var7 - class36.cameraZ;
					double var12 = Math.sqrt((double)(var9 * var9 + var11 * var11));
					var26 = class240.method1293((int)(Math.atan2((double)var23, var12) * 325.9490051269531D) & 2047);
					var15 = class319.method1705((int)(Math.atan2((double)var9, (double)var11) * -325.9490051269531D) & 2047);
					field642 = new class490(Varcs.cameraPitch, var26, var21, var5);
					field643 = new class490(class192.cameraYaw, var15, var21, var5);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2637 == var1.serverPacket) {
					var21 = var3.readIntME();
					var55 = var3.readUnsignedByteNeg() == 1;
					var25 = HealthBarDefinition.widgetDefinition.method1733(var21);
					class18.method70(var25, class229.localPlayer.appearance, var55);
					class159.invalidateWidget(var25);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.LOC_ADD_CHANGE == var1.serverPacket) {
					var21 = var3.readUnsignedByte();
					var5 = var3.readInt();
					var25 = HealthBarDefinition.widgetDefinition.method1733(var5);
					class302.method1626(var25, class229.localPlayer.appearance.field2947, var21);
					class159.invalidateWidget(var25);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.IF_SETPOSITION == var1.serverPacket) {
					var21 = var3.readUShortSmart();
					var55 = var3.readUnsignedByte() == 1;
					var84 = "";
					boolean var54 = false;
					if (var55) {
						var84 = var3.readStringCp1252NullTerminated();
						if (class12.friendSystem.isIgnored(new Username(var84, class89.loginType))) {
							var54 = true;
						}
					}

					String var92 = var3.readStringCp1252NullTerminated();
					if (!var54) {
						GrandExchangeOfferUnitPriceComparator.addGameMessage(var21, var84, var92);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.NPC_INFO_SMALL == var1.serverPacket) {
					var9 = var3.readUnsignedShortAddLE();
					var23 = var3.readUnsignedShortAdd();
					var6 = var3.readMedium();
					var21 = var6 >> 16;
					var5 = var6 >> 8 & 255;
					var7 = var21 + (var6 >> 4 & 7);
					var8 = var5 + (var6 & 7);
					var11 = var3.readUnsignedShortLE();
					if (var7 >= 0 && var8 >= 0 && var7 < 104 && var8 < 104) {
						var7 = var7 * 128 + 64;
						var8 = var8 * 128 + 64;
						GraphicsObject var38 = new GraphicsObject(var9, ItemLayer.Client_plane, var7, var8, WorldMapDecorationType.getTileHeight(var7, var8, ItemLayer.Client_plane) - var23, var11, cycle);
						graphicsObjects.addFirst(var38);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.UPDATE_FRIENDCHAT_CHANNEL_FULL == var1.serverPacket) {
					var21 = var3.readUnsignedIntME();
					var5 = var3.readIntME();
					var25 = HealthBarDefinition.widgetDefinition.method1733(var5);
					AbstractWorldMapData.method1323(var25, var21);
					class159.invalidateWidget(var25);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2718 == var1.serverPacket) {
					var21 = var3.readUnsignedIntME();
					var5 = var3.readUnsignedIntIME();
					if (var5 == 65535) {
						var5 = -1;
					}

					var6 = var3.readIntME();
					var22 = HealthBarDefinition.widgetDefinition.method1733(var6);
					ItemComposition var35;
					if (!var22.isIf3) {
						if (var5 == -1) {
							var22.modelType = 0;
							var1.serverPacket = null;
							return true;
						}

						var35 = class214.ItemDefinition_get(var5).getCountObj(var21);
						var22.modelType = 4;
						var22.modelId = var5;
						var22.modelAngleX = var35.xan2d;
						var22.modelAngleY = var35.yan2d;
						var22.modelZoom = var35.zoom2d * 100 / var21;
						class159.invalidateWidget(var22);
					} else {
						var22.itemId = var5;
						var22.itemQuantity = var21;
						var35 = class214.ItemDefinition_get(var5).getCountObj(var21);
						var22.modelAngleX = var35.xan2d;
						var22.modelAngleY = var35.yan2d;
						var22.modelAngleZ = var35.zan2d;
						var22.modelOffsetX = var35.offsetX2d;
						var22.modelOffsetY = var35.offsetY2d;
						var22.modelZoom = var35.zoom2d;
						if (var35.isStackable == 1) {
							var22.itemQuantityMode = 1;
						} else {
							var22.itemQuantityMode = 2;
						}

						if (var22.modelRotation > 0) {
							var22.modelZoom = var22.modelZoom * 32 / var22.modelRotation;
						} else if (var22.rawWidth > 0) {
							var22.modelZoom = var22.modelZoom * 32 / var22.rawWidth;
						}

						class159.invalidateWidget(var22);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.PLAYER_SPOTANIM_SPECIFIC == var1.serverPacket) {
					field400 = false;
					isCameraLocked = false;
					field402 = false;
					field404 = false;
					Messages.field1154 = 0;
					AbstractWorldMapData.field2045 = 0;
					class302.field2510 = 0;
					field403 = false;
					class60.cameraLookAtSpeed = 0;
					class134.cameraMoveToAcceleration = 0;
					class1.cameraLookAtAcceleration = 0;
					WorldMapIcon_0.cameraMoveToSpeed = 0;
					ScriptFrame.cameraLookAtX = 0;
					class216.cameraLookAtY = 0;
					class127.cameraLookAtHeight = 0;
					field644 = null;
					field642 = null;
					field643 = null;

					for (var21 = 0; var21 < 5; ++var21) {
						cameraShaking[var21] = false;
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.UPDATE_INV_CLEAR == var1.serverPacket) {
					byte[] var49 = new byte[var1.serverPacketLength];
					var3.method2534(var49, 0, var49.length);
					Buffer var69 = new Buffer(var49);
					var84 = var69.readStringCp1252NullTerminated();
					HealthBar.openURL(var84, true, false);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2639 == var1.serverPacket) {
					isCameraLocked = true;
					field400 = false;
					field404 = false;
					Messages.field1154 = var3.readUnsignedByte();
					AbstractWorldMapData.field2045 = var3.readUnsignedByte();
					class302.field2510 = var3.readUnsignedShort();
					class60.cameraLookAtSpeed = var3.readUnsignedByte();
					class134.cameraMoveToAcceleration = var3.readUnsignedByte();
					if (class134.cameraMoveToAcceleration >= 100) {
						var21 = Messages.field1154 * 128 + 64;
						var5 = AbstractWorldMapData.field2045 * 128 + 64;
						var6 = WorldMapDecorationType.getTileHeight(var21, var5, ItemLayer.Client_plane) - class302.field2510;
						var7 = var21 - ViewportMouse.cameraX;
						var8 = var6 - SecureRandomFuture.cameraY;
						var9 = var5 - class36.cameraZ;
						var23 = (int)Math.sqrt((double)(var9 * var9 + var7 * var7));
						Varcs.cameraPitch = (int)(Math.atan2((double)var8, (double)var23) * 325.9490051269531D) & 2047;
						class192.cameraYaw = (int)(Math.atan2((double)var7, (double)var9) * -325.9490051269531D) & 2047;
						if (Varcs.cameraPitch < 128) {
							Varcs.cameraPitch = 128;
						}

						if (Varcs.cameraPitch > 383) {
							Varcs.cameraPitch = 383;
						}
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.IF_SETHIDE == var1.serverPacket) {
					class396.method2042();
					var21 = var3.readUnsignedByteNeg();
					var5 = var3.readIntIME();
					var6 = var3.readUnsignedByte();
					var7 = var3.readUnsignedByteSub();
					experience[var6] = var5;
					currentLevels[var6] = var7;
					levels[var6] = 1;
					field564[var6] = var21;

					for (var8 = 0; var8 < 98; ++var8) {
						if (var5 >= Skills.Skills_experienceTable[var8]) {
							levels[var6] = var8 + 2;
						}
					}

					changedSkills[++changedSkillsCount - 1 & 31] = var6;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2633 == var1.serverPacket) {
					var21 = var3.readUnsignedShort();
					var5 = var3.readInt();
					Varps.Varps_temp[var21] = var5;
					if (Varps.Varps_main[var21] != var5) {
						Varps.Varps_main[var21] = var5;
					}

					Projectile.changeGameOptions(var21);
					changedVarps[++changedVarpCount - 1 & 31] = var21;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.EMPTY_PACKET == var1.serverPacket) {
					class106.processZoneOperation(ZoneOperation.LOC_ANIM);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2754 == var1.serverPacket) {
					var76 = var3.readByte();
					var20 = var3.readStringCp1252NullTerminated();
					long var41 = (long)var3.readUnsignedShort();
					long var43 = (long)var3.readMedium();
					PlayerType var10 = (PlayerType)class12.findEnumerated(class320.PlayerType_values(), var3.readUnsignedByte());
					long var45 = var43 + (var41 << 32);
					boolean var13 = false;
					ClanChannel var14 = null;
					var14 = var76 >= 0 ? currentClanChannels[var76] : ItemContainer.guestClanChannel;
					if (var14 == null) {
						var13 = true;
					} else {
						var15 = 0;

						while (true) {
							if (var15 >= 100) {
								if (var10.isUser && class12.friendSystem.isIgnored(new Username(var20, class89.loginType))) {
									var13 = true;
								}
								break;
							}

							if (var45 == field615[var15]) {
								var13 = true;
								break;
							}

							++var15;
						}
					}

					if (!var13) {
						field615[field533] = var45;
						field533 = (field533 + 1) % 100;
						var40 = AbstractFont.escapeBrackets(class128.readString(var3));
						var16 = var76 >= 0 ? 41 : 44;
						if (var10.modIcon != -1) {
							ArchiveLoader.addChatMessage(var16, FloorUnderlayDefinition.addImageTag(var10.modIcon) + var20, var40, var14.name);
						} else {
							ArchiveLoader.addChatMessage(var16, var20, var40, var14.name);
						}
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.IF_SETPLAYERHEAD == var1.serverPacket) {
					var21 = var3.readUnsignedIntME();
					var5 = var3.readUnsignedShortLE();
					if (var5 == 65535) {
						var5 = -1;
					}

					var6 = var3.readIntIME();
					var7 = var3.readUnsignedShort();
					if (var7 == 65535) {
						var7 = -1;
					}

					for (var8 = var7; var8 <= var5; ++var8) {
						var36 = ((long)var6 << 32) + (long)var8;
						Node var39 = widgetFlags.get(var36);
						if (var39 != null) {
							var39.remove();
						}

						widgetFlags.put(new IntegerNode(var21), var36);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.MAPPROJ_ANIM == var1.serverPacket) {
					var21 = var3.readUnsignedShortAddLE();
					var5 = var3.readUnsignedByteNeg();
					if (var21 == 65535) {
						var21 = -1;
					}

					WorldMapLabelSize.performPlayerAnimation(class229.localPlayer, var21, var5);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2743 == var1.serverPacket) {
					var21 = var3.readIntIME();
					var5 = var3.readUnsignedShortLE();
					var25 = HealthBarDefinition.widgetDefinition.method1733(var21);
					if (var25.modelType != 2 || var5 != var25.modelId) {
						var25.modelType = 2;
						var25.modelId = var5;
						class159.invalidateWidget(var25);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.UPDATE_FRIENDCHAT_CHANNEL_FULL_V2 == var1.serverPacket) {
					var21 = var3.readUnsignedByte();
					PacketWriter.forceDisconnect(var21);
					var1.serverPacket = null;
					return false;
				}

				GrandExchangeOfferWorldComparator.RunException_sendStackTrace("" + (var1.serverPacket != null ? var1.serverPacket.id * 1979699673 * 581410409 : -1) + "," + (var1.field1168 != null ? var1.field1168.id * 1979699673 * 581410409 : -1) + "," + (var1.field1166 != null ? var1.field1166.id * 1979699673 * 581410409 : -1) + "," + var1.serverPacketLength, (Throwable)null);
				class13.method51();
			} catch (IOException var47) {
				class9.method29();
			} catch (Exception var48) {
				var20 = "" + (var1.serverPacket != null ? var1.serverPacket.id * 1979699673 * 581410409 : -1) + "," + (var1.field1168 != null ? var1.field1168.id * 1979699673 * 581410409 : -1) + "," + (var1.field1166 != null ? var1.field1166.id * 1979699673 * 581410409 : -1) + "," + var1.serverPacketLength + "," + (class229.localPlayer.pathX[0] + NewShit.baseX) + "," + (class229.localPlayer.pathY[0] + class101.baseY) + ",";

				for (var6 = 0; var6 < var1.serverPacketLength && var6 < 50; ++var6) {
					var20 = var20 + var3.array[var6] + ",";
				}

				GrandExchangeOfferWorldComparator.RunException_sendStackTrace(var20, var48);
				class13.method51();
			}

			return true;
		}
	}

	@ObfuscatedName("kl")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "1598980943"
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
				if (var19 != 1 && (class19.mouseCam || var19 != 4)) {
					var2 = MouseHandler.MouseHandler_x;
					var15 = MouseHandler.MouseHandler_y;
					if (var2 < FriendSystem.menuX - 10 || var2 > FriendSystem.menuX + class428.menuWidth + 10 || var15 < class60.menuY - 10 || var15 > class515.menuHeight + class60.menuY + 10) {
						isMenuOpen = false;
						var16 = FriendSystem.menuX;
						var5 = class60.menuY;
						var20 = class428.menuWidth;
						var7 = class515.menuHeight;

						for (var8 = 0; var8 < rootWidgetCount; ++var8) {
							if (rootWidgetWidths[var8] + rootWidgetXs[var8] > var16 && rootWidgetXs[var8] < var20 + var16 && rootWidgetHeights[var8] + rootWidgetYs[var8] > var5 && rootWidgetYs[var8] < var5 + var7) {
								field407[var8] = true;
							}
						}
					}
				}

				if (var19 == 1 || !class19.mouseCam && var19 == 4) {
					var2 = FriendSystem.menuX;
					var15 = class60.menuY;
					var16 = class428.menuWidth;
					var5 = MouseHandler.MouseHandler_lastPressedX;
					var20 = MouseHandler.MouseHandler_lastPressedY;
					var7 = -1;

					int var9;
					for (var8 = 0; var8 < menuOptionsCount; ++var8) {
						var9 = var15 + (menuOptionsCount - 1 - var8) * 15 + 31;
						if (var5 > var2 && var5 < var2 + var16 && var20 > var9 - 13 && var20 < var9 + 3) {
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
						class407.menuAction(var8, var9, var10, var11, var12, var13, var14, MouseHandler.MouseHandler_lastPressedX, MouseHandler.MouseHandler_lastPressedY);
					}

					isMenuOpen = false;
					var8 = FriendSystem.menuX;
					var9 = class60.menuY;
					var10 = class428.menuWidth;
					var11 = class515.menuHeight;

					for (var12 = 0; var12 < rootWidgetCount; ++var12) {
						if (rootWidgetWidths[var12] + rootWidgetXs[var12] > var8 && rootWidgetXs[var12] < var8 + var10 && rootWidgetYs[var12] + rootWidgetHeights[var12] > var9 && rootWidgetYs[var12] < var11 + var9) {
							field407[var12] = true;
						}
					}
				}
			} else {
				var2 = menuOptionsCount - 1;
				if ((var19 == 1 || !class19.mouseCam && var19 == 4) && this.shouldLeftClickOpenMenu()) {
					var19 = 2;
				}

				if ((var19 == 1 || !class19.mouseCam && var19 == 4) && menuOptionsCount > 0 && var2 >= 0) {
					var16 = menuArguments1[var2];
					var5 = menuArguments2[var2];
					var20 = menuOpcodes[var2];
					var7 = menuIdentifiers[var2];
					var8 = menuItemIds[var2];
					String var17 = menuActions[var2];
					String var18 = menuTargets[var2];
					class407.menuAction(var16, var5, var20, var7, var8, var17, var18, MouseHandler.MouseHandler_lastPressedX, MouseHandler.MouseHandler_lastPressedY);
				}

				if (var19 == 2 && menuOptionsCount > 0) {
					this.openMenu(MouseHandler.MouseHandler_lastPressedX, MouseHandler.MouseHandler_lastPressedY);
				}
			}

		}
	}

	@ObfuscatedName("kc")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "-1230030345"
	)
	@Export("shouldLeftClickOpenMenu")
	final boolean shouldLeftClickOpenMenu() {
		int var1 = menuOptionsCount - 1;
		return (leftClickOpensMenu && menuOptionsCount > 2 || class514.method2508(var1)) && !menuShiftClick[var1];
	}

	@ObfuscatedName("ka")
	@ObfuscatedSignature(
		descriptor = "(IIB)V",
		garbageValue = "-26"
	)
	@Export("openMenu")
	final void openMenu(int var1, int var2) {
		Decimator.method322(var1, var2);
		var1 -= viewportOffsetX;
		var2 -= viewportOffsetY;
		class36.scene.menuOpen(ItemLayer.Client_plane, var1, var2, false);
		isMenuOpen = true;
	}

	@ObfuscatedName("lp")
	@ObfuscatedSignature(
		descriptor = "(ZI)V",
		garbageValue = "-577799502"
	)
	final void method389(boolean var1) {
		NPCComposition.method952(rootInterface, Language.canvasWidth, class47.canvasHeight, var1);
	}

	@ObfuscatedName("lh")
	@ObfuscatedSignature(
		descriptor = "(Lnn;I)V",
		garbageValue = "1484692020"
	)
	@Export("alignWidget")
	void alignWidget(Widget var1) {
		Widget var2 = var1.parentId == -1 ? null : HealthBarDefinition.widgetDefinition.method1733(var1.parentId);
		int var3;
		int var4;
		if (var2 == null) {
			var3 = Language.canvasWidth;
			var4 = class47.canvasHeight;
		} else {
			var3 = var2.width;
			var4 = var2.height;
		}

		Renderable.alignWidgetSize(var1, var3, var4, false);
		JagexCache.alignWidgetPosition(var1, var3, var4);
	}

	@ObfuscatedName("mf")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "-74"
	)
	final void method391() {
		class159.invalidateWidget(clickedWidget);
		++class148.widgetDragDuration;
		if (field397 && field396) {
			int var1 = MouseHandler.MouseHandler_x;
			int var2 = MouseHandler.MouseHandler_y;
			var1 -= widgetClickX;
			var2 -= widgetClickY;
			if (var1 < field512) {
				var1 = field512;
			}

			if (var1 + clickedWidget.width > field512 + clickedWidgetParent.width) {
				var1 = field512 + clickedWidgetParent.width - clickedWidget.width;
			}

			if (var2 < field513) {
				var2 = field513;
			}

			if (var2 + clickedWidget.height > field513 + clickedWidgetParent.height) {
				var2 = field513 + clickedWidgetParent.height - clickedWidget.height;
			}

			int var3 = var1 - field514;
			int var4 = var2 - field508;
			int var5 = clickedWidget.dragZoneSize;
			if (class148.widgetDragDuration > clickedWidget.dragThreshold && (var3 > var5 || var3 < -var5 || var4 > var5 || var4 < -var5)) {
				isDraggingWidget = true;
			}

			int var6 = var1 - field512 + clickedWidgetParent.scrollX;
			int var7 = var2 - field513 + clickedWidgetParent.scrollY;
			ScriptEvent var8;
			if (clickedWidget.onDrag != null && isDraggingWidget) {
				var8 = new ScriptEvent();
				var8.widget = clickedWidget;
				var8.mouseX = var6;
				var8.mouseY = var7;
				var8.args = clickedWidget.onDrag;
				class157.runScriptEvent(var8);
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
						class157.runScriptEvent(var8);
					}

					if (draggedOnWidget != null && class227.method1165(clickedWidget) != null) {
						PacketBufferNode var9 = class113.getPacketBufferNode(ClientPacket.field2559, packetWriter.isaacCipher);
						var9.packetBuffer.writeShortAdd(clickedWidget.itemId);
						var9.packetBuffer.writeIntME(draggedOnWidget.childIndex);
						var9.packetBuffer.writeIntLE(clickedWidget.id);
						var9.packetBuffer.writeInt(draggedOnWidget.id);
						var9.packetBuffer.writeShortAdd(clickedWidget.childIndex);
						var9.packetBuffer.writeIntME(draggedOnWidget.itemId);
						packetWriter.addNode(var9);
					}
				} else if (this.shouldLeftClickOpenMenu()) {
					this.openMenu(field514 + widgetClickX, field508 + widgetClickY);
				} else if (menuOptionsCount > 0) {
					method392(widgetClickX + field514, field508 + widgetClickY);
				}

				clickedWidget = null;
			}

		} else {
			if (class148.widgetDragDuration > 1) {
				if (!isDraggingWidget && menuOptionsCount > 0) {
					method392(widgetClickX + field514, widgetClickY + field508);
				}

				clickedWidget = null;
			}

		}
	}

	@ObfuscatedName("or")
	@ObfuscatedSignature(
		descriptor = "(I)Lvj;",
		garbageValue = "-1748725154"
	)
	@Export("username")
	public Username username() {
		return class229.localPlayer != null ? class229.localPlayer.username : null;
	}

	@ObfuscatedName("ob")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "-1572672090"
	)
	void method394(int var1) {
		if (param25 >= 216) {
			PacketBufferNode var2 = class113.getPacketBufferNode(ClientPacket.OPPLAYER5, packetWriter.isaacCipher);
			var2.packetBuffer.writeByte(var1);
			packetWriter.addNode(var2);
		}

	}

	@ObfuscatedName("os")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "-1728239313"
	)
	void method395(int var1) {
		if (param25 >= 216) {
			PacketBufferNode var2 = class113.getPacketBufferNode(ClientPacket.f1, packetWriter.isaacCipher);
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
							class85.clientLanguage = Language.method1995(Integer.parseInt(var2));
							break;
						case 7:
							int var4 = Integer.parseInt(var2);
							GameBuild[] var5 = class13.method50();
							int var6 = 0;

							GameBuild var8;
							while (true) {
								if (var6 >= var5.length) {
									var8 = null;
									break;
								}

								GameBuild var7 = var5[var6];
								if (var4 == var7.buildId) {
									var8 = var7;
									break;
								}

								++var6;
							}

							class191.field1585 = var8;
							break;
						case 8:
							if (var2.equalsIgnoreCase("true")) {
							}
							break;
						case 9:
							MenuAction.param9 = var2;
							break;
						case 10:
							Messages.field1156 = (StudioGame)class12.findEnumerated(VerticalAlignment.method955(), Integer.parseInt(var2));
							if (Messages.field1156 == StudioGame.oldscape) {
								class89.loginType = LoginType.oldscape;
							} else {
								class89.loginType = LoginType.field4092;
							}
							break;
						case 11:
							class314.field2776 = var2;
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
							DevicePcmPlayerProvider.field66 = Integer.parseInt(var2);
							break;
						case 15:
							gameBuild = Integer.parseInt(var2);
							break;
						case 17:
							MoveSpeed.field1933 = var2;
							break;
						case 21:
							param21 = Integer.parseInt(var2);
							break;
						case 22:
							FriendsChat.field3821 = var2;
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

				Scene.Scene_isLowDetail = false;
				isLowDetail = false;
				Friend.worldHost = this.getCodeBase().getHost();
				WorldMapSectionType.field2038 = new JagNetThread();
				String var9 = class191.field1585.name;
				byte var10 = 0;
				if ((worldProperties & class522.field4153.rsOrdinal()) != 0) {
					ItemLayer.field2109 = "beta";
				}

				try {
					class339.method1744("oldschool", ItemLayer.field2109, var9, var10, 23);
				} catch (Exception var12) {
					GrandExchangeOfferWorldComparator.RunException_sendStackTrace((String)null, var12);
				}

				SpriteMask.client = this;
				RuneLiteMenuEntry.client = (RSClient)(Object)  this;
				RunException.field4317 = clientType;
				Messages.field1155 = System.getenv("JX_ACCESS_TOKEN");
				ObjectComposition.field1664 = System.getenv("JX_REFRESH_TOKEN");
				class369.field3560 = System.getenv("JX_SESSION_ID");
				InterfaceParent.field862 = System.getenv("JX_CHARACTER_ID");
				String var14 = System.getenv("JX_DISPLAY_NAME");
				String var11;
				if (var14 != null && !var14.isEmpty() && var14.charAt(0) != '#') {
					var11 = var14;
				} else {
					var11 = "";
				}

				Login.field763 = var11;
				if (Boolean.parseBoolean(System.getProperty("jagex.disableBouncyCastle"))) {
					this.field661 = true;
				}

				if (field424 == -1) {
					if (!this.method364() && !this.method365()) {
						field424 = 0;
					} else {
						field424 = 5;
					}
				}

				this.startThread(765, 503, 218, 1);
			}
		} catch (RuntimeException var13) {
			throw CollisionMap.method1136(var13, "client.init(" + ')');
		}
	}

	@Export("finalize")
	@ObfuscatedName("finalize")
	protected void finalize() throws Throwable {
		InterfaceParent.method462(this);
		super.finalize();
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(Luo;B)I",
		garbageValue = "80"
	)
	static int method361(PacketBuffer var0) {
		int var1 = var0.readBits(2);
		int var2;
		if (var1 == 0) {
			var2 = 0;
		} else if (var1 == 1) {
			var2 = var0.readBits(5);
		} else if (var1 == 2) {
			var2 = var0.readBits(8);
		} else {
			var2 = var0.readBits(11);
		}

		return var2;
	}

	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "743374996"
	)
	public static void method360() {
		HitSplatDefinition.HitSplatDefinition_cached.clear();
		HitSplatDefinition.HitSplatDefinition_cachedSprites.clear();
		HitSplatDefinition.HitSplatDefinition_cachedFonts.clear();
	}

	@ObfuscatedName("mj")
	@ObfuscatedSignature(
		descriptor = "(III)V",
		garbageValue = "2100775885"
	)
	static void method392(int var0, int var1) {
		class59.method334(class174.tempMenuAction, var0, var1);
		class174.tempMenuAction = null;
	}
}