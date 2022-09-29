import com.jagex.oldscape.pub.OAuthApi;
import com.jagex.oldscape.pub.OtlTokenRequester;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.concurrent.Future;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@Implements("Client")
@ObfuscatedName("client")
public final class Client extends GameEngine implements Usernamed, OAuthApi {

	@ObfuscatedName("rj")
	@ObfuscatedSignature(
		descriptor = "[Led;"
	)
	@Export("currentClanSettings")
	static ClanSettings[] currentClanSettings;
	@ObfuscatedName("sz")
	@Export("playingJingle")
	static boolean playingJingle;
	@ObfuscatedName("va")
	@ObfuscatedGetter(
		intValue = -1358104763
	)
	public static int field782;
	@ObfuscatedName("sm")
	@ObfuscatedSignature(
		descriptor = "Lad;"
	)
	@Export("pcmPlayer1")
	static PcmPlayer pcmPlayer1;
	@ObfuscatedName("ux")
	@ObfuscatedGetter(
		intValue = 1569844235
	)
	@Export("viewportOffsetX")
	static int viewportOffsetX;
	@ObfuscatedName("uk")
	@ObfuscatedGetter(
		intValue = 651915753
	)
	@Export("viewportOffsetY")
	static int viewportOffsetY;
	@ObfuscatedName("vt")
	static int[] field787;
	@ObfuscatedName("vo")
	static int[] field788;
	@ObfuscatedName("sn")
	@ObfuscatedGetter(
		intValue = 2058275655
	)
	@Export("destinationX")
	static int destinationX;
	@ObfuscatedName("vy")
	@ObfuscatedSignature(
		descriptor = "Lby;"
	)
	static final ApproximateRouteStrategy field786;
	@ObfuscatedName("sh")
	@ObfuscatedGetter(
		intValue = -341659067
	)
	@Export("destinationY")
	static int destinationY;
	@ObfuscatedName("ri")
	@ObfuscatedGetter(
		intValue = 1876141191
	)
	@Export("tradeChatMode")
	static int tradeChatMode;
	@ObfuscatedName("us")
	@ObfuscatedGetter(
		intValue = 1197744969
	)
	static int field566;
	@ObfuscatedName("rt")
	@ObfuscatedGetter(
		intValue = -189498203
	)
	@Export("publicChatMode")
	static int publicChatMode;
	@ObfuscatedName("uw")
	@ObfuscatedSignature(
		descriptor = "Lke;"
	)
	@Export("playerAppearance")
	static PlayerComposition playerAppearance;
	@ObfuscatedName("ut")
	@ObfuscatedGetter(
		intValue = -270756597
	)
	static int field715;
	@ObfuscatedName("sq")
	@ObfuscatedGetter(
		intValue = 472847473
	)
	@Export("soundEffectCount")
	static int soundEffectCount;
	@ObfuscatedName("sy")
	@Export("soundEffectIds")
	static int[] soundEffectIds;
	@ObfuscatedName("sr")
	@Export("queuedSoundEffectLoops")
	static int[] queuedSoundEffectLoops;
	@ObfuscatedName("si")
	@Export("queuedSoundEffectDelays")
	static int[] queuedSoundEffectDelays;
	@ObfuscatedName("sk")
	@ObfuscatedGetter(
		intValue = -1850275625
	)
	@Export("minimapState")
	static int minimapState;
	@ObfuscatedName("so")
	@ObfuscatedSignature(
		descriptor = "[Lap;"
	)
	@Export("soundEffects")
	static SoundEffect[] soundEffects;
	@ObfuscatedName("uf")
	@ObfuscatedSignature(
		descriptor = "Lif;"
	)
	@Export("Widget_cachedModels")
	static EvictingDualNodeHashTable Widget_cachedModels;
	@ObfuscatedName("sb")
	@Export("soundLocations")
	static int[] soundLocations;
	@ObfuscatedName("ud")
	@ObfuscatedSignature(
		descriptor = "Lif;"
	)
	@Export("Widget_cachedFonts")
	static EvictingDualNodeHashTable Widget_cachedFonts;
	@ObfuscatedName("sj")
	@ObfuscatedGetter(
		intValue = -1180731439
	)
	@Export("currentTrackGroupId")
	static int currentTrackGroupId;
	@ObfuscatedName("vc")
	@Export("archiveLoaders")
	static ArrayList archiveLoaders;
	@ObfuscatedName("rg")
	@ObfuscatedGetter(
		longValue = 1659896925640892851L
	)
	static long field733;
	@ObfuscatedName("vw")
	@ObfuscatedGetter(
		intValue = -1500212927
	)
	@Export("archiveLoadersDone")
	static int archiveLoadersDone;
	@ObfuscatedName("sl")
	@Export("isCameraLocked")
	static boolean isCameraLocked;
	@ObfuscatedName("rl")
	static long[] crossWorldMessageIds;
	@ObfuscatedName("tc")
	static boolean[] field755;
	@ObfuscatedName("tz")
	static int[] field575;
	@ObfuscatedName("rz")
	@ObfuscatedGetter(
		intValue = 1886028331
	)
	@Export("mapIconCount")
	static int mapIconCount;
	@ObfuscatedName("td")
	static int[] field757;
	@ObfuscatedName("rx")
	@Export("mapIconXs")
	static int[] mapIconXs;
	@ObfuscatedName("rq")
	@ObfuscatedGetter(
		intValue = -814923163
	)
	static int crossWorldMessageIdsIndex;
	@ObfuscatedName("tb")
	static int[] field758;
	@ObfuscatedName("rm")
	@ObfuscatedSignature(
		descriptor = "[Ler;"
	)
	@Export("currentClanChannels")
	static ClanChannel[] currentClanChannels;
	@ObfuscatedName("uy")
	@ObfuscatedSignature(
		descriptor = "Lot;"
	)
	@Export("platformInfoProvider")
	static PlatformInfoProvider platformInfoProvider;
	@ObfuscatedName("ta")
	static int[] field759;
	@ObfuscatedName("rb")
	@ObfuscatedGetter(
		intValue = -1267299117
	)
	static int field736;
	@ObfuscatedName("ry")
	@Export("mapIconYs")
	static int[] mapIconYs;
	@ObfuscatedName("tl")
	static boolean field544;
	@ObfuscatedName("ra")
	@ObfuscatedSignature(
		descriptor = "[Lqi;"
	)
	@Export("mapIcons")
	static SpritePixels[] mapIcons;
	@ObfuscatedName("th")
	static short field760;
	@ObfuscatedName("tw")
	static short field762;
	@ObfuscatedName("uu")
	static short field537;
	@ObfuscatedName("uq")
	static short field638;
	@ObfuscatedName("ur")
	static short field756;
	@ObfuscatedName("ui")
	@ObfuscatedGetter(
		intValue = 1313769551
	)
	@Export("viewportZoom")
	static int viewportZoom;
	@ObfuscatedName("tt")
	static short field764;
	@ObfuscatedName("ua")
	@ObfuscatedGetter(
		intValue = -308539085
	)
	@Export("viewportWidth")
	static int viewportWidth;
	@ObfuscatedName("um")
	@ObfuscatedGetter(
		intValue = -1120100653
	)
	@Export("viewportHeight")
	static int viewportHeight;
	@ObfuscatedName("uj")
	@ObfuscatedSignature(
		descriptor = "[Llr;"
	)
	@Export("grandExchangeOffers")
	static GrandExchangeOffer[] grandExchangeOffers;
	@ObfuscatedName("ru")
	@ObfuscatedGetter(
		intValue = -2098122201
	)
	static int field529;
	@ObfuscatedName("vd")
	@ObfuscatedGetter(
		intValue = 882600475
	)
	static int field613;
	@ObfuscatedName("rs")
	static int[] field749;
	@ObfuscatedName("rf")
	static int[] field731;
	@ObfuscatedName("tx")
	@Export("zoomHeight")
	static short zoomHeight;
	@ObfuscatedName("tn")
	@Export("zoomWidth")
	static short zoomWidth;
	@ObfuscatedName("rn")
	static String field752;
	@ObfuscatedName("tg")
	@ObfuscatedGetter(
		intValue = -1693900609
	)
	static int field789;
	@ObfuscatedName("rh")
	static int[] field724;
	@ObfuscatedName("ue")
	@ObfuscatedSignature(
		descriptor = "Lbz;"
	)
	@Export("GrandExchangeEvents_worldComparator")
	static GrandExchangeOfferOwnWorldComparator GrandExchangeEvents_worldComparator;
	@ObfuscatedName("ug")
	@ObfuscatedGetter(
		intValue = 1042842941
	)
	static int field618;
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		descriptor = "[Lgj;"
	)
	@Export("collisionMaps")
	static CollisionMap[] collisionMaps;
	@ObfuscatedName("au")
	static boolean field587;
	@ObfuscatedName("bg")
	@ObfuscatedGetter(
		intValue = -955103455
	)
	@Export("worldId")
	public static int worldId;
	@ObfuscatedName("bw")
	@ObfuscatedGetter(
		intValue = 285959915
	)
	@Export("worldProperties")
	static int worldProperties;
	@ObfuscatedName("bv")
	@ObfuscatedGetter(
		intValue = -926068429
	)
	@Export("gameBuild")
	static int gameBuild;
	@ObfuscatedName("by")
	@Export("isMembersWorld")
	public static boolean isMembersWorld;
	@ObfuscatedName("bz")
	@Export("isLowDetail")
	static boolean isLowDetail;
	@ObfuscatedName("bl")
	@ObfuscatedGetter(
		intValue = -1086519913
	)
	static int field497;
	@ObfuscatedName("bk")
	@ObfuscatedGetter(
		intValue = -942178573
	)
	@Export("clientType")
	static int clientType;
	@ObfuscatedName("bh")
	@ObfuscatedGetter(
		intValue = -607785167
	)
	static int field571;
	@ObfuscatedName("bx")
	@Export("onMobile")
	static boolean onMobile;
	@ObfuscatedName("cv")
	@ObfuscatedGetter(
		intValue = -1929522483
	)
	@Export("gameState")
	static int gameState;
	@ObfuscatedName("cm")
	@Export("isLoading")
	static boolean isLoading;
	@ObfuscatedName("db")
	@ObfuscatedGetter(
		intValue = 1165332781
	)
	@Export("cycle")
	static int cycle;
	@ObfuscatedName("df")
	@ObfuscatedGetter(
		longValue = 357724067631522685L
	)
	@Export("mouseLastLastPressedTimeMillis")
	static long mouseLastLastPressedTimeMillis;
	@ObfuscatedName("da")
	@ObfuscatedGetter(
		intValue = 1995242549
	)
	static int field505;
	@ObfuscatedName("dp")
	@ObfuscatedGetter(
		intValue = 1250215341
	)
	static int field506;
	@ObfuscatedName("dr")
	@ObfuscatedGetter(
		longValue = -4196392371729312045L
	)
	static long field507;
	@ObfuscatedName("dq")
	@Export("hadFocus")
	static boolean hadFocus;
	@ObfuscatedName("dl")
	@ObfuscatedGetter(
		intValue = 1319778895
	)
	@Export("rebootTimer")
	static int rebootTimer;
	@ObfuscatedName("do")
	@ObfuscatedGetter(
		intValue = 1947634697
	)
	@Export("hintArrowType")
	static int hintArrowType;
	@ObfuscatedName("dg")
	@ObfuscatedGetter(
		intValue = 456318925
	)
	@Export("hintArrowNpcIndex")
	static int hintArrowNpcIndex;
	@ObfuscatedName("dz")
	@ObfuscatedGetter(
		intValue = -1730174795
	)
	@Export("hintArrowPlayerIndex")
	static int hintArrowPlayerIndex;
	@ObfuscatedName("dx")
	@ObfuscatedGetter(
		intValue = -2137633873
	)
	@Export("hintArrowX")
	static int hintArrowX;
	@ObfuscatedName("dj")
	@ObfuscatedGetter(
		intValue = -1850916367
	)
	@Export("hintArrowY")
	static int hintArrowY;
	@ObfuscatedName("dk")
	@ObfuscatedGetter(
		intValue = 1826852820
	)
	@Export("hintArrowHeight")
	static int hintArrowHeight;
	@ObfuscatedName("di")
	@ObfuscatedGetter(
		intValue = -1635656640
	)
	@Export("hintArrowSubX")
	static int hintArrowSubX;
	@ObfuscatedName("dv")
	@ObfuscatedGetter(
		intValue = 1189714033
	)
	@Export("hintArrowSubY")
	static int hintArrowSubY;
	@ObfuscatedName("dw")
	@ObfuscatedSignature(
		descriptor = "Lcq;"
	)
	@Export("playerAttackOption")
	static AttackOption playerAttackOption;
	@ObfuscatedName("dn")
	@ObfuscatedSignature(
		descriptor = "Lcq;"
	)
	@Export("npcAttackOption")
	static AttackOption npcAttackOption;
	@ObfuscatedName("dd")
	@ObfuscatedGetter(
		intValue = -1084537321
	)
	@Export("titleLoadingStage")
	static int titleLoadingStage;
	@ObfuscatedName("ee")
	@ObfuscatedGetter(
		intValue = -1027332567
	)
	@Export("js5ConnectState")
	static int js5ConnectState;
	@ObfuscatedName("ea")
	@ObfuscatedGetter(
		intValue = -939239011
	)
	static int field522;
	@ObfuscatedName("el")
	@ObfuscatedGetter(
		intValue = 686071665
	)
	@Export("js5Errors")
	static int js5Errors;
	@ObfuscatedName("fc")
	@ObfuscatedGetter(
		intValue = -796037507
	)
	@Export("loginState")
	static int loginState;
	@ObfuscatedName("fr")
	@ObfuscatedGetter(
		intValue = 385086823
	)
	static int field525;
	@ObfuscatedName("fg")
	@ObfuscatedGetter(
		intValue = -1489299043
	)
	static int field526;
	@ObfuscatedName("fv")
	@ObfuscatedGetter(
		intValue = -560586039
	)
	static int field527;
	@ObfuscatedName("fm")
	@ObfuscatedSignature(
		descriptor = "Ldh;"
	)
	static class125 field528;
	@ObfuscatedName("fl")
	@ObfuscatedSignature(
		descriptor = "Lqs;"
	)
	static class448 field639;
	@ObfuscatedName("fz")
	static final String field661;
	@ObfuscatedName("gk")
	@Export("Login_isUsernameRemembered")
	static boolean Login_isUsernameRemembered;
	@ObfuscatedName("gw")
	@ObfuscatedSignature(
		descriptor = "Lba;"
	)
	@Export("secureRandomFuture")
	static SecureRandomFuture secureRandomFuture;
	@ObfuscatedName("gc")
	@Export("randomDatData")
	static byte[] randomDatData;
	@ObfuscatedName("gs")
	@ObfuscatedSignature(
		descriptor = "[Lco;"
	)
	@Export("npcs")
	static NPC[] npcs;
	@ObfuscatedName("gf")
	@ObfuscatedGetter(
		intValue = -614487589
	)
	@Export("npcCount")
	static int npcCount;
	@ObfuscatedName("go")
	@Export("npcIndices")
	static int[] npcIndices;
	@ObfuscatedName("ge")
	@ObfuscatedGetter(
		intValue = 1572689161
	)
	static int field549;
	@ObfuscatedName("gm")
	static int[] field550;
	@ObfuscatedName("gh")
	@ObfuscatedSignature(
		descriptor = "Lcs;"
	)
	@Export("packetWriter")
	public static final PacketWriter packetWriter;
	@ObfuscatedName("hi")
	@ObfuscatedGetter(
		intValue = -1315915121
	)
	@Export("logoutTimer")
	static int logoutTimer;
	@ObfuscatedName("he")
	@Export("hadNetworkError")
	static boolean hadNetworkError;
	@ObfuscatedName("hm")
	@ObfuscatedSignature(
		descriptor = "Lmu;"
	)
	@Export("timer")
	static Timer timer;
	@ObfuscatedName("hc")
	@Export("fontsMap")
	static HashMap fontsMap;
	@ObfuscatedName("hq")
	@ObfuscatedGetter(
		intValue = 1517738829
	)
	static int field523;
	@ObfuscatedName("hf")
	@ObfuscatedGetter(
		intValue = -681391809
	)
	static int field585;
	@ObfuscatedName("ht")
	@ObfuscatedGetter(
		intValue = -1347427523
	)
	static int field558;
	@ObfuscatedName("hy")
	@ObfuscatedGetter(
		intValue = 960719949
	)
	static int field559;
	@ObfuscatedName("hx")
	@ObfuscatedGetter(
		intValue = 856798245
	)
	static int field774;
	@ObfuscatedName("il")
	@Export("isInInstance")
	static boolean isInInstance;
	@ObfuscatedName("ie")
	@Export("instanceChunkTemplates")
	static int[][][] instanceChunkTemplates;
	@ObfuscatedName("ir")
	static final int[] field564;
	@ObfuscatedName("ii")
	@ObfuscatedGetter(
		intValue = -1469577063
	)
	static int field743;
	@ObfuscatedName("iu")
	@ObfuscatedGetter(
		intValue = 1618207093
	)
	static int field508;
	@ObfuscatedName("it")
	@Export("selectedItemName")
	static String selectedItemName;
	@ObfuscatedName("io")
	@ObfuscatedGetter(
		intValue = -25198189
	)
	static int field716;
	@ObfuscatedName("if")
	@ObfuscatedGetter(
		intValue = -1436052139
	)
	static int field568;
	@ObfuscatedName("im")
	@ObfuscatedGetter(
		intValue = -1748283211
	)
	static int field727;
	@ObfuscatedName("id")
	static boolean field570;
	@ObfuscatedName("jp")
	@ObfuscatedGetter(
		intValue = -2052071939
	)
	@Export("alternativeScrollbarWidth")
	static int alternativeScrollbarWidth;
	@ObfuscatedName("js")
	@ObfuscatedGetter(
		intValue = 1549581749
	)
	@Export("camAngleX")
	static int camAngleX;
	@ObfuscatedName("jt")
	@ObfuscatedGetter(
		intValue = 338293883
	)
	@Export("camAngleY")
	static int camAngleY;
	@ObfuscatedName("ja")
	@ObfuscatedGetter(
		intValue = 469381565
	)
	@Export("camAngleDY")
	static int camAngleDY;
	@ObfuscatedName("jy")
	@ObfuscatedGetter(
		intValue = -899947855
	)
	@Export("camAngleDX")
	static int camAngleDX;
	@ObfuscatedName("ju")
	@ObfuscatedGetter(
		intValue = 1416659259
	)
	@Export("mouseCamClickedX")
	static int mouseCamClickedX;
	@ObfuscatedName("jc")
	@ObfuscatedGetter(
		intValue = 584448557
	)
	@Export("mouseCamClickedY")
	static int mouseCamClickedY;
	@ObfuscatedName("jg")
	@ObfuscatedGetter(
		intValue = -1295727583
	)
	@Export("oculusOrbState")
	static int oculusOrbState;
	@ObfuscatedName("jj")
	@ObfuscatedGetter(
		intValue = -822684481
	)
	@Export("camFollowHeight")
	static int camFollowHeight;
	@ObfuscatedName("jd")
	@ObfuscatedGetter(
		intValue = 127647999
	)
	static int field580;
	@ObfuscatedName("jb")
	@ObfuscatedGetter(
		intValue = -2009562911
	)
	static int field581;
	@ObfuscatedName("ji")
	@ObfuscatedGetter(
		intValue = 178959503
	)
	static int field582;
	@ObfuscatedName("jk")
	@ObfuscatedGetter(
		intValue = 1397841051
	)
	@Export("oculusOrbNormalSpeed")
	static int oculusOrbNormalSpeed;
	@ObfuscatedName("jv")
	@ObfuscatedGetter(
		intValue = 1483305355
	)
	@Export("oculusOrbSlowedSpeed")
	static int oculusOrbSlowedSpeed;
	@ObfuscatedName("je")
	@ObfuscatedGetter(
		intValue = -1563090891
	)
	static int field754;
	@ObfuscatedName("kv")
	static boolean field586;
	@ObfuscatedName("kx")
	@ObfuscatedGetter(
		intValue = -988021777
	)
	static int field630;
	@ObfuscatedName("ko")
	static boolean field543;
	@ObfuscatedName("kb")
	@ObfuscatedGetter(
		intValue = -1233568483
	)
	static int field589;
	@ObfuscatedName("kz")
	@ObfuscatedGetter(
		intValue = -247945411
	)
	@Export("overheadTextCount")
	static int overheadTextCount;
	@ObfuscatedName("ki")
	@ObfuscatedGetter(
		intValue = -2005837749
	)
	@Export("overheadTextLimit")
	static int overheadTextLimit;
	@ObfuscatedName("kk")
	@Export("overheadTextXs")
	static int[] overheadTextXs;
	@ObfuscatedName("ke")
	@Export("overheadTextYs")
	static int[] overheadTextYs;
	@ObfuscatedName("kd")
	@Export("overheadTextAscents")
	static int[] overheadTextAscents;
	@ObfuscatedName("kw")
	@Export("overheadTextXOffsets")
	static int[] overheadTextXOffsets;
	@ObfuscatedName("km")
	@Export("overheadTextColors")
	static int[] overheadTextColors;
	@ObfuscatedName("kh")
	@Export("overheadTextEffects")
	static int[] overheadTextEffects;
	@ObfuscatedName("kc")
	@Export("overheadTextCyclesRemaining")
	static int[] overheadTextCyclesRemaining;
	@ObfuscatedName("kr")
	@Export("overheadText")
	static String[] overheadText;
	@ObfuscatedName("kq")
	@Export("tileLastDrawnActor")
	static int[][] tileLastDrawnActor;
	@ObfuscatedName("ka")
	@ObfuscatedGetter(
		intValue = 1680051095
	)
	@Export("viewportDrawCount")
	static int viewportDrawCount;
	@ObfuscatedName("kp")
	@ObfuscatedGetter(
		intValue = -1719740117
	)
	@Export("viewportTempX")
	static int viewportTempX;
	@ObfuscatedName("ku")
	@ObfuscatedGetter(
		intValue = 961153905
	)
	@Export("viewportTempY")
	static int viewportTempY;
	@ObfuscatedName("kg")
	@ObfuscatedGetter(
		intValue = 2144290199
	)
	@Export("mouseCrossX")
	static int mouseCrossX;
	@ObfuscatedName("kl")
	@ObfuscatedGetter(
		intValue = 1615978565
	)
	@Export("mouseCrossY")
	static int mouseCrossY;
	@ObfuscatedName("kn")
	@ObfuscatedGetter(
		intValue = -1615092235
	)
	@Export("mouseCrossState")
	static int mouseCrossState;
	@ObfuscatedName("kt")
	@ObfuscatedGetter(
		intValue = 783878283
	)
	@Export("mouseCrossColor")
	static int mouseCrossColor;
	@ObfuscatedName("kf")
	@Export("showMouseCross")
	static boolean showMouseCross;
	@ObfuscatedName("ky")
	@ObfuscatedGetter(
		intValue = 183903601
	)
	static int field609;
	@ObfuscatedName("kj")
	@ObfuscatedGetter(
		intValue = -1355746395
	)
	static int field635;
	@ObfuscatedName("lb")
	@ObfuscatedGetter(
		intValue = 1550083197
	)
	@Export("dragItemSlotSource")
	static int dragItemSlotSource;
	@ObfuscatedName("lx")
	@ObfuscatedGetter(
		intValue = 1684772177
	)
	@Export("draggedWidgetX")
	static int draggedWidgetX;
	@ObfuscatedName("lv")
	@ObfuscatedGetter(
		intValue = 1937959615
	)
	@Export("draggedWidgetY")
	static int draggedWidgetY;
	@ObfuscatedName("lh")
	@ObfuscatedGetter(
		intValue = 1285032319
	)
	@Export("dragItemSlotDestination")
	static int dragItemSlotDestination;
	@ObfuscatedName("lg")
	static boolean field763;
	@ObfuscatedName("lo")
	@ObfuscatedGetter(
		intValue = 1511731025
	)
	@Export("itemDragDuration")
	static int itemDragDuration;
	@ObfuscatedName("lf")
	@ObfuscatedGetter(
		intValue = 323214685
	)
	static int field617;
	@ObfuscatedName("li")
	@Export("showLoadingMessages")
	static boolean showLoadingMessages;
	@ObfuscatedName("la")
	@ObfuscatedSignature(
		descriptor = "[Lcl;"
	)
	@Export("players")
	static Player[] players;
	@ObfuscatedName("lt")
	@ObfuscatedGetter(
		intValue = -605970647
	)
	@Export("localPlayerIndex")
	static int localPlayerIndex;
	@ObfuscatedName("lm")
	@ObfuscatedGetter(
		intValue = 1164507621
	)
	static int field621;
	@ObfuscatedName("le")
	@ObfuscatedGetter(
		longValue = -6637453507816676259L
	)
	static long field498;
	@ObfuscatedName("lk")
	@Export("renderSelf")
	static boolean renderSelf;
	@ObfuscatedName("lc")
	@ObfuscatedGetter(
		intValue = -263767255
	)
	@Export("drawPlayerNames")
	static int drawPlayerNames;
	@ObfuscatedName("lp")
	@ObfuscatedGetter(
		intValue = 1770673121
	)
	static int field625;
	@ObfuscatedName("lz")
	static int[] field775;
	@ObfuscatedName("md")
	@Export("playerMenuOpcodes")
	static final int[] playerMenuOpcodes;
	@ObfuscatedName("mt")
	@Export("playerMenuActions")
	static String[] playerMenuActions;
	@ObfuscatedName("ml")
	@Export("playerOptionsPriorities")
	static boolean[] playerOptionsPriorities;
	@ObfuscatedName("mz")
	@Export("defaultRotations")
	static int[] defaultRotations;
	@ObfuscatedName("mo")
	@ObfuscatedGetter(
		intValue = 228143751
	)
	@Export("combatTargetPlayerIndex")
	static int combatTargetPlayerIndex;
	@ObfuscatedName("mi")
	@ObfuscatedSignature(
		descriptor = "[[[Llc;"
	)
	@Export("groundItems")
	static NodeDeque[][][] groundItems;
	@ObfuscatedName("ma")
	@ObfuscatedSignature(
		descriptor = "Llc;"
	)
	@Export("pendingSpawns")
	static NodeDeque pendingSpawns;
	@ObfuscatedName("my")
	@ObfuscatedSignature(
		descriptor = "Llc;"
	)
	@Export("projectiles")
	static NodeDeque projectiles;
	@ObfuscatedName("mp")
	@ObfuscatedSignature(
		descriptor = "Llc;"
	)
	@Export("graphicsObjects")
	static NodeDeque graphicsObjects;
	@ObfuscatedName("mr")
	@Export("currentLevels")
	static int[] currentLevels;
	@ObfuscatedName("mh")
	@Export("levels")
	static int[] levels;
	@ObfuscatedName("mv")
	@Export("experience")
	static int[] experience;
	@ObfuscatedName("mf")
	@Export("leftClickOpensMenu")
	static boolean leftClickOpensMenu;
	@ObfuscatedName("mc")
	@Export("isMenuOpen")
	static boolean isMenuOpen;
	@ObfuscatedName("mb")
	@ObfuscatedGetter(
		intValue = -1221650631
	)
	@Export("menuOptionsCount")
	static int menuOptionsCount;
	@ObfuscatedName("me")
	@Export("menuArguments1")
	static int[] menuArguments1;
	@ObfuscatedName("mw")
	@Export("menuArguments2")
	static int[] menuArguments2;
	@ObfuscatedName("mq")
	@Export("menuOpcodes")
	static int[] menuOpcodes;
	@ObfuscatedName("mn")
	@Export("menuIdentifiers")
	static int[] menuIdentifiers;
	@ObfuscatedName("mk")
	static int[] menuItemIds;
	@ObfuscatedName("ns")
	@Export("menuActions")
	static String[] menuActions;
	@ObfuscatedName("nu")
	@Export("menuTargets")
	static String[] menuTargets;
	@ObfuscatedName("np")
	@Export("menuShiftClick")
	static boolean[] menuShiftClick;
	@ObfuscatedName("na")
	@Export("followerOpsLowPriority")
	static boolean followerOpsLowPriority;
	@ObfuscatedName("ne")
	@Export("shiftClickDrop")
	static boolean shiftClickDrop;
	@ObfuscatedName("ni")
	@Export("tapToDrop")
	static boolean tapToDrop;
	@ObfuscatedName("nh")
	@Export("showMouseOverText")
	static boolean showMouseOverText;
	@ObfuscatedName("nc")
	@ObfuscatedGetter(
		intValue = 94097817
	)
	@Export("viewportX")
	static int viewportX;
	@ObfuscatedName("nx")
	@ObfuscatedGetter(
		intValue = -726283291
	)
	@Export("viewportY")
	static int viewportY;
	@ObfuscatedName("nt")
	@ObfuscatedGetter(
		intValue = 32964859
	)
	static int field560;
	@ObfuscatedName("nl")
	@ObfuscatedGetter(
		intValue = -154462467
	)
	static int field657;
	@ObfuscatedName("no")
	@ObfuscatedGetter(
		intValue = 1548097615
	)
	@Export("isItemSelected")
	static int isItemSelected;
	@ObfuscatedName("nb")
	@Export("isSpellSelected")
	static boolean isSpellSelected;
	@ObfuscatedName("nv")
	@ObfuscatedGetter(
		intValue = 580477963
	)
	@Export("selectedSpellChildIndex")
	static int selectedSpellChildIndex;
	@ObfuscatedName("nd")
	@ObfuscatedGetter(
		intValue = 1851481475
	)
	@Export("selectedSpellItemId")
	static int selectedSpellItemId;
	@ObfuscatedName("nz")
	@Export("selectedSpellActionName")
	static String selectedSpellActionName;
	@ObfuscatedName("ny")
	@Export("selectedSpellName")
	static String selectedSpellName;
	@ObfuscatedName("nn")
	@ObfuscatedGetter(
		intValue = -450916759
	)
	@Export("rootInterface")
	static int rootInterface;
	@ObfuscatedName("nw")
	@ObfuscatedSignature(
		descriptor = "Lpm;"
	)
	@Export("interfaceParents")
	static NodeHashTable interfaceParents;
	@ObfuscatedName("op")
	@ObfuscatedGetter(
		intValue = -2071864311
	)
	static int field593;
	@ObfuscatedName("ol")
	@ObfuscatedGetter(
		intValue = 2142545009
	)
	static int field668;
	@ObfuscatedName("of")
	@ObfuscatedGetter(
		intValue = -343729041
	)
	@Export("chatEffects")
	static int chatEffects;
	@ObfuscatedName("oq")
	@ObfuscatedGetter(
		intValue = 859837901
	)
	static int field565;
	@ObfuscatedName("ok")
	@ObfuscatedSignature(
		descriptor = "Lkw;"
	)
	@Export("meslayerContinueWidget")
	static Widget meslayerContinueWidget;
	@ObfuscatedName("ou")
	@ObfuscatedGetter(
		intValue = -532915775
	)
	@Export("runEnergy")
	static int runEnergy;
	@ObfuscatedName("oc")
	@ObfuscatedGetter(
		intValue = -806074421
	)
	@Export("weight")
	static int weight;
	@ObfuscatedName("om")
	@ObfuscatedGetter(
		intValue = 2096379489
	)
	@Export("staffModLevel")
	public static int staffModLevel;
	@ObfuscatedName("oo")
	@ObfuscatedGetter(
		intValue = -853079577
	)
	@Export("followerIndex")
	static int followerIndex;
	@ObfuscatedName("oj")
	@Export("playerMod")
	static boolean playerMod;
	@ObfuscatedName("oh")
	@ObfuscatedSignature(
		descriptor = "Lkw;"
	)
	@Export("viewportWidget")
	static Widget viewportWidget;
	@ObfuscatedName("oy")
	@ObfuscatedSignature(
		descriptor = "Lkw;"
	)
	@Export("clickedWidget")
	static Widget clickedWidget;
	@ObfuscatedName("oa")
	@ObfuscatedSignature(
		descriptor = "Lkw;"
	)
	@Export("clickedWidgetParent")
	static Widget clickedWidgetParent;
	@ObfuscatedName("oe")
	@ObfuscatedGetter(
		intValue = -572216347
	)
	@Export("widgetClickX")
	static int widgetClickX;
	@ObfuscatedName("oz")
	@ObfuscatedGetter(
		intValue = -508828023
	)
	@Export("widgetClickY")
	static int widgetClickY;
	@ObfuscatedName("ox")
	@ObfuscatedSignature(
		descriptor = "Lkw;"
	)
	@Export("draggedOnWidget")
	static Widget draggedOnWidget;
	@ObfuscatedName("or")
	static boolean field683;
	@ObfuscatedName("ov")
	@ObfuscatedGetter(
		intValue = -1081263179
	)
	static int field783;
	@ObfuscatedName("ob")
	@ObfuscatedGetter(
		intValue = -1666573751
	)
	static int field744;
	@ObfuscatedName("os")
	static boolean field686;
	@ObfuscatedName("ot")
	@ObfuscatedGetter(
		intValue = -617257983
	)
	static int field687;
	@ObfuscatedName("ow")
	@ObfuscatedGetter(
		intValue = 1039872673
	)
	static int field688;
	@ObfuscatedName("pi")
	@Export("isDraggingWidget")
	static boolean isDraggingWidget;
	@ObfuscatedName("pm")
	@ObfuscatedGetter(
		intValue = -1341875553
	)
	@Export("cycleCntr")
	static int cycleCntr;
	@ObfuscatedName("pn")
	@Export("changedVarps")
	static int[] changedVarps;
	@ObfuscatedName("pj")
	@ObfuscatedGetter(
		intValue = -1032863153
	)
	@Export("changedVarpCount")
	static int changedVarpCount;
	@ObfuscatedName("pk")
	@Export("changedItemContainers")
	static int[] changedItemContainers;
	@ObfuscatedName("pr")
	@ObfuscatedGetter(
		intValue = -793051319
	)
	static int field694;
	@ObfuscatedName("pv")
	@Export("changedSkills")
	static int[] changedSkills;
	@ObfuscatedName("pf")
	@ObfuscatedGetter(
		intValue = -1595421791
	)
	@Export("changedSkillsCount")
	static int changedSkillsCount;
	@ObfuscatedName("po")
	static int[] field590;
	@ObfuscatedName("pa")
	@ObfuscatedGetter(
		intValue = -1669218215
	)
	static int field698;
	@ObfuscatedName("px")
	@ObfuscatedGetter(
		intValue = -1315170369
	)
	@Export("chatCycle")
	static int chatCycle;
	@ObfuscatedName("pz")
	@ObfuscatedGetter(
		intValue = 1133823213
	)
	static int field700;
	@ObfuscatedName("ps")
	@ObfuscatedGetter(
		intValue = 2039857333
	)
	static int field701;
	@ObfuscatedName("py")
	@ObfuscatedGetter(
		intValue = -1750917415
	)
	static int field702;
	@ObfuscatedName("pg")
	@ObfuscatedGetter(
		intValue = -1220894383
	)
	static int field745;
	@ObfuscatedName("pt")
	@ObfuscatedGetter(
		intValue = -312378233
	)
	static int field704;
	@ObfuscatedName("pb")
	@ObfuscatedGetter(
		intValue = -1530390561
	)
	static int field705;
	@ObfuscatedName("pl")
	@ObfuscatedGetter(
		intValue = 655257345
	)
	static int field706;
	@ObfuscatedName("qx")
	@ObfuscatedGetter(
		intValue = -584786819
	)
	@Export("mouseWheelRotation")
	static int mouseWheelRotation;
	@ObfuscatedName("qz")
	@ObfuscatedSignature(
		descriptor = "Llc;"
	)
	@Export("scriptEvents")
	static NodeDeque scriptEvents;
	@ObfuscatedName("qa")
	@ObfuscatedSignature(
		descriptor = "Llc;"
	)
	static NodeDeque field709;
	@ObfuscatedName("qs")
	@ObfuscatedSignature(
		descriptor = "Llc;"
	)
	static NodeDeque field626;
	@ObfuscatedName("qn")
	@ObfuscatedSignature(
		descriptor = "Lpm;"
	)
	@Export("widgetFlags")
	static NodeHashTable widgetFlags;
	@ObfuscatedName("qg")
	@ObfuscatedGetter(
		intValue = 1284586997
	)
	@Export("rootWidgetCount")
	static int rootWidgetCount;
	@ObfuscatedName("ql")
	@ObfuscatedGetter(
		intValue = -513678565
	)
	static int field713;
	@ObfuscatedName("qk")
	static boolean[] field714;
	@ObfuscatedName("qd")
	static boolean[] field556;
	@ObfuscatedName("qt")
	static boolean[] field671;
	@ObfuscatedName("qu")
	@Export("rootWidgetXs")
	static int[] rootWidgetXs;
	@ObfuscatedName("qi")
	@Export("rootWidgetYs")
	static int[] rootWidgetYs;
	@ObfuscatedName("qe")
	@Export("rootWidgetWidths")
	static int[] rootWidgetWidths;
	@ObfuscatedName("qp")
	@Export("rootWidgetHeights")
	static int[] rootWidgetHeights;
	@ObfuscatedName("qv")
	@ObfuscatedGetter(
		intValue = -1589240577
	)
	@Export("gameDrawingMode")
	static int gameDrawingMode;
	@ObfuscatedName("qr")
	@ObfuscatedGetter(
		longValue = 6601777156529964847L
	)
	static long field678;
	@ObfuscatedName("qm")
	@Export("isResizable")
	static boolean isResizable;
	@ObfuscatedName("fb")
	String field530;
	@ObfuscatedName("fa")
	@ObfuscatedSignature(
		descriptor = "Lu;"
	)
	class14 field531;
	@ObfuscatedName("fd")
	@ObfuscatedSignature(
		descriptor = "Le;"
	)
	class19 field576;
	@ObfuscatedName("fu")
	com.jagex.oldscape.pub.OtlTokenRequester field533;
	@ObfuscatedName("fe")
	Future field515;
	@ObfuscatedName("fy")
	boolean field535;
	@ObfuscatedName("fs")
	@ObfuscatedSignature(
		descriptor = "Le;"
	)
	class19 field536;
	@ObfuscatedName("fw")
	@ObfuscatedSignature(
		descriptor = "Lcom/jagex/oldscape/pub/RefreshAccessTokenRequester;"
	)
	OtlTokenRequester field719;
	@ObfuscatedName("ft")
	Future field538;
	@ObfuscatedName("gb")
	@ObfuscatedSignature(
		descriptor = "Lqq;"
	)
	Buffer field542;
	@ObfuscatedName("ga")
	@ObfuscatedSignature(
		descriptor = "Lq;"
	)
	class7 field721;
	@ObfuscatedName("gn")
	@ObfuscatedGetter(
		longValue = -6377200187917740923L
	)
	long field710;

	static {
		field587 = true;
		worldId = 1;
		worldProperties = 0;
		gameBuild = 0;
		isMembersWorld = false;
		isLowDetail = false;
		field497 = -1;
		clientType = -1;
		field571 = -1;
		onMobile = false;
		gameState = 0;
		isLoading = true;
		cycle = 0;
		mouseLastLastPressedTimeMillis = 1L;
		field505 = -1;
		field506 = -1;
		field507 = -1L;
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
		titleLoadingStage = 0;
		js5ConnectState = 0;
		field522 = 0;
		js5Errors = 0;
		loginState = 0;
		field525 = 0;
		field526 = 0;
		field527 = 0;
		field528 = class125.field1536;
		field639 = class448.field4784;
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

		field661 = ItemLayer.method4040(var2);
		Login_isUsernameRemembered = false;
		secureRandomFuture = new SecureRandomFuture();
		randomDatData = null;
		npcs = new NPC[32768];
		npcCount = 0;
		npcIndices = new int[32768];
		field549 = 0;
		field550 = new int[250];
		packetWriter = new PacketWriter();
		logoutTimer = 0;
		hadNetworkError = false;
		timer = new Timer();
		fontsMap = new HashMap();
		field523 = 0;
		field585 = 1;
		field558 = 0;
		field559 = 1;
		field774 = 0;
		collisionMaps = new CollisionMap[4];
		isInInstance = false;
		instanceChunkTemplates = new int[4][13][13];
		field564 = new int[]{0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3};
		field743 = 0;
		field508 = 2301979;
		field716 = 5063219;
		field568 = 3353893;
		field727 = 7759444;
		field570 = false;
		alternativeScrollbarWidth = 0;
		camAngleX = 128;
		camAngleY = 0;
		camAngleDY = 0;
		camAngleDX = 0;
		mouseCamClickedX = 0;
		mouseCamClickedY = 0;
		oculusOrbState = 0;
		camFollowHeight = 50;
		field580 = 0;
		field581 = 0;
		field582 = 0;
		oculusOrbNormalSpeed = 12;
		oculusOrbSlowedSpeed = 6;
		field754 = 0;
		field586 = false;
		field630 = 0;
		field543 = false;
		field589 = 0;
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
		field609 = 0;
		field635 = 0;
		dragItemSlotSource = 0;
		draggedWidgetX = 0;
		draggedWidgetY = 0;
		dragItemSlotDestination = 0;
		field763 = false;
		itemDragDuration = 0;
		field617 = 0;
		showLoadingMessages = true;
		players = new Player[2048];
		localPlayerIndex = -1;
		field621 = 0;
		field498 = -1L;
		renderSelf = true;
		drawPlayerNames = 0;
		field625 = 0;
		field775 = new int[1000];
		playerMenuOpcodes = new int[]{44, 45, 46, 47, 48, 49, 50, 51};
		playerMenuActions = new String[8];
		playerOptionsPriorities = new boolean[8];
		defaultRotations = new int[]{768, 1024, 1280, 512, 1536, 256, 0, 1792};
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
		shiftClickDrop = false;
		tapToDrop = false;
		showMouseOverText = true;
		viewportX = -1;
		viewportY = -1;
		field560 = 0;
		field657 = 50;
		isItemSelected = 0;
		selectedItemName = null;
		isSpellSelected = false;
		selectedSpellChildIndex = -1;
		selectedSpellItemId = -1;
		selectedSpellActionName = null;
		selectedSpellName = null;
		rootInterface = -1;
		interfaceParents = new NodeHashTable(8);
		field593 = 0;
		field668 = -1;
		chatEffects = 0;
		field565 = 0;
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
		field683 = false;
		field783 = -1;
		field744 = -1;
		field686 = false;
		field687 = -1;
		field688 = -1;
		isDraggingWidget = false;
		cycleCntr = 1;
		changedVarps = new int[32];
		changedVarpCount = 0;
		changedItemContainers = new int[32];
		field694 = 0;
		changedSkills = new int[32];
		changedSkillsCount = 0;
		field590 = new int[32];
		field698 = 0;
		chatCycle = 0;
		field700 = 0;
		field701 = 0;
		field702 = 0;
		field745 = 0;
		field704 = 0;
		field705 = 0;
		field706 = 0;
		mouseWheelRotation = 0;
		scriptEvents = new NodeDeque();
		field709 = new NodeDeque();
		field626 = new NodeDeque();
		widgetFlags = new NodeHashTable(512);
		rootWidgetCount = 0;
		field713 = -2;
		field714 = new boolean[100];
		field556 = new boolean[100];
		field671 = new boolean[100];
		rootWidgetXs = new int[100];
		rootWidgetYs = new int[100];
		rootWidgetWidths = new int[100];
		rootWidgetHeights = new int[100];
		gameDrawingMode = 0;
		field678 = 0L;
		isResizable = true;
		field724 = new int[]{16776960, 16711680, 65280, 65535, 16711935, 16777215};
		publicChatMode = 0;
		tradeChatMode = 0;
		field752 = "";
		crossWorldMessageIds = new long[100];
		crossWorldMessageIdsIndex = 0;
		field529 = 0;
		field731 = new int[128];
		field749 = new int[128];
		field733 = -1L;
		currentClanSettings = new ClanSettings[4];
		currentClanChannels = new ClanChannel[4];
		field736 = -1;
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
		field544 = false;
		field755 = new boolean[5];
		field575 = new int[5];
		field757 = new int[5];
		field758 = new int[5];
		field759 = new int[5];
		field760 = 256;
		field762 = 205;
		zoomHeight = 256;
		zoomWidth = 320;
		field764 = 1;
		field756 = 32767;
		field537 = 1;
		field638 = 32767;
		viewportOffsetX = 0;
		viewportOffsetY = 0;
		viewportWidth = 0;
		viewportHeight = 0;
		viewportZoom = 0;
		playerAppearance = new PlayerComposition();
		field566 = -1;
		field715 = -1;
		platformInfoProvider = new DesktopPlatformInfoProvider();
		grandExchangeOffers = new GrandExchangeOffer[8];
		GrandExchangeEvents_worldComparator = new GrandExchangeOfferOwnWorldComparator();
		Widget_cachedModels = new EvictingDualNodeHashTable(64);
		Widget_cachedFonts = new EvictingDualNodeHashTable(64);
		field618 = -1;
		field782 = -1;
		archiveLoaders = new ArrayList(10);
		archiveLoadersDone = 0;
		field613 = 0;
		field786 = new ApproximateRouteStrategy();
		field787 = new int[50];
		field788 = new int[50];
	}

	public Client() {
		this.field535 = false;
		this.field710 = -1L;
	}

	@ObfuscatedName("h")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "35"
	)
	@Export("resizeGame")
	protected final void resizeGame() {
		field678 = Language.method6232() + 500L;
		this.resizeJS();
		if (rootInterface != -1) {
			this.resizeRoot(true);
		}

	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "501973473"
	)
	@Export("setUp")
	protected final void setUp() {
		class307.method5930(new int[]{20, 260, 10000}, new int[]{1000, 100, 500});
		NPC.worldPort = gameBuild == 0 ? 43594 : worldId + 40000;
		TaskHandler.js5Port = gameBuild == 0 ? 443 : worldId + 50000;
		BuddyRankComparator.currentPort = NPC.worldPort;
		class133.field1589 = class294.field3370;
		class358.field4279 = class294.field3371;
		class239.field2865 = class294.field3372;
		MusicPatchPcmStream.field3288 = class294.field3373;
		Messages.urlRequester = new class102(this.field535, 208);
		this.setUpKeyboard();
		this.method448();
		class136.mouseWheel = this.mouseWheel();
		ChatChannel.masterDisk = new ArchiveDisk(255, JagexCache.JagexCache_dat2File, JagexCache.JagexCache_idx255File, 500000);
		Player.clientPreferences = Decimator.method1102();
		this.setUpClipboard();
		class11.method119(this, class345.field4194);
		WallDecoration.setWindowedMode(Player.clientPreferences.method2411());
		Varps.friendSystem = new FriendSystem(Players.loginType);
		this.field531 = new class14("tokenRequest", 1, 1);
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-2025034455"
	)
	@Export("doCycle")
	protected final void doCycle() {
		++cycle;
		this.doCycleJs5();
		class152.method3303();

		int var1;
		try {
			if (class274.musicPlayerStatus == 1) {
				var1 = class139.midiPcmStream.method5466();
				if (var1 > 0 && class139.midiPcmStream.isReady()) {
					var1 -= VarcInt.pcmSampleLength;
					if (var1 < 0) {
						var1 = 0;
					}

					class139.midiPcmStream.setPcmStreamVolume(var1);
				} else {
					class139.midiPcmStream.clear();
					class139.midiPcmStream.removeAll();
					if (class274.musicTrackArchive != null) {
						class274.musicPlayerStatus = 2;
					} else {
						class274.musicPlayerStatus = 0;
					}

					class274.musicTrack = null;
					class29.soundCache = null;
				}
			}
		} catch (Exception var8) {
			var8.printStackTrace();
			class139.midiPcmStream.clear();
			class274.musicPlayerStatus = 0;
			class274.musicTrack = null;
			class29.soundCache = null;
			class274.musicTrackArchive = null;
		}

		class14.playPcmPlayers();
		synchronized(KeyHandler.KeyHandler_instance) {
			++KeyHandler.KeyHandler_idleCycles;
			KeyHandler.field144 = KeyHandler.field146;
			KeyHandler.field141 = 0;
			KeyHandler.field123 = 0;
			Arrays.fill(KeyHandler.field133, false);
			Arrays.fill(KeyHandler.field134, false);
			if (KeyHandler.field131 < 0) {
				Arrays.fill(KeyHandler.KeyHandler_pressedKeys, false);
				KeyHandler.field131 = KeyHandler.field136;
			} else {
				while (KeyHandler.field131 != KeyHandler.field136) {
					int var2 = KeyHandler.field135[KeyHandler.field136];
					KeyHandler.field136 = KeyHandler.field136 + 1 & 127;
					if (var2 < 0) {
						var2 = ~var2;
						if (KeyHandler.KeyHandler_pressedKeys[var2]) {
							KeyHandler.KeyHandler_pressedKeys[var2] = false;
							KeyHandler.field134[var2] = true;
							KeyHandler.field143[KeyHandler.field123] = var2;
							++KeyHandler.field123;
						}
					} else {
						if (!KeyHandler.KeyHandler_pressedKeys[var2] && KeyHandler.field141 < KeyHandler.field140.length - 1) {
							KeyHandler.field133[var2] = true;
							KeyHandler.field140[++KeyHandler.field141 - 1] = var2;
						}

						KeyHandler.KeyHandler_pressedKeys[var2] = true;
					}
				}
			}

			if (KeyHandler.field141 > 0) {
				KeyHandler.KeyHandler_idleCycles = 0;
			}

			KeyHandler.field146 = KeyHandler.field145;
		}

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

		if (class136.mouseWheel != null) {
			var1 = class136.mouseWheel.useRotation();
			mouseWheelRotation = var1;
		}

		if (gameState == 0) {
			class202.load();
			class18.method282();
		} else if (gameState == 5) {
			ByteArrayPool.loginScreen(this, class1.fontPlain12);
			class202.load();
			class18.method282();
		} else if (gameState != 10 && gameState != 11) {
			if (gameState == 20) {
				ByteArrayPool.loginScreen(this, class1.fontPlain12);
				this.doCycleLoggedOut();
			} else if (gameState == 50) {
				ByteArrayPool.loginScreen(this, class1.fontPlain12);
				this.doCycleLoggedOut();
			} else if (gameState == 25) {
				class269.method5365();
			}
		} else {
			ByteArrayPool.loginScreen(this, class1.fontPlain12);
		}

		if (gameState == 30) {
			this.doCycleLoggedIn();
		} else if (gameState == 40 || gameState == 45) {
			this.doCycleLoggedOut();
		}

	}

	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "(ZS)V",
		garbageValue = "8076"
	)
	@Export("draw")
	protected final void draw(boolean var1) {
		boolean var2 = class65.method2027();
		if (var2 && playingJingle && class241.pcmPlayer0 != null) {
			class241.pcmPlayer0.tryDiscard();
		}

		if ((gameState == 10 || gameState == 20 || gameState == 30) && 0L != field678 && Language.method6232() > field678) {
			WallDecoration.setWindowedMode(SceneTilePaint.getWindowedMode());
		}

		int var3;
		if (var1) {
			for (var3 = 0; var3 < 100; ++var3) {
				field714[var3] = true;
			}
		}

		if (gameState == 0) {
			this.drawInitial(Login.Login_loadingPercent, Login.Login_loadingText, var1);
		} else if (gameState == 5) {
			WorldMapLabelSize.drawTitle(class29.fontBold12, class156.fontPlain11, class1.fontPlain12);
		} else if (gameState != 10 && gameState != 11) {
			if (gameState == 20) {
				WorldMapLabelSize.drawTitle(class29.fontBold12, class156.fontPlain11, class1.fontPlain12);
			} else if (gameState == 50) {
				WorldMapLabelSize.drawTitle(class29.fontBold12, class156.fontPlain11, class1.fontPlain12);
			} else if (gameState == 25) {
				if (field774 == 1) {
					if (field523 > field585) {
						field585 = field523;
					}

					var3 = (field585 * 50 - field523 * 50) / field585;
					class146.drawLoadingMessage("Loading - please wait." + "<br>" + " (" + var3 + "%" + ")", false);
				} else if (field774 == 2) {
					if (field558 > field559) {
						field559 = field558;
					}

					var3 = (field559 * 50 - field558 * 50) / field559 + 50;
					class146.drawLoadingMessage("Loading - please wait." + "<br>" + " (" + var3 + "%" + ")", false);
				} else {
					class146.drawLoadingMessage("Loading - please wait.", false);
				}
			} else if (gameState == 30) {
				this.drawLoggedIn();
			} else if (gameState == 40) {
				class146.drawLoadingMessage("Connection lost" + "<br>" + "Please wait - attempting to reestablish", false);
			} else if (gameState == 45) {
				class146.drawLoadingMessage("Please wait...", false);
			}
		} else {
			WorldMapLabelSize.drawTitle(class29.fontBold12, class156.fontPlain11, class1.fontPlain12);
		}

		if (gameState == 30 && gameDrawingMode == 0 && !var1 && !isResizable) {
			for (var3 = 0; var3 < rootWidgetCount; ++var3) {
				if (field556[var3]) {
					class20.rasterProvider.draw(rootWidgetXs[var3], rootWidgetYs[var3], rootWidgetWidths[var3], rootWidgetHeights[var3]);
					field556[var3] = false;
				}
			}
		} else if (gameState > 0) {
			class20.rasterProvider.drawFull(0, 0);

			for (var3 = 0; var3 < rootWidgetCount; ++var3) {
				field556[var3] = false;
			}
		}

	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-1894132503"
	)
	@Export("kill0")
	protected final void kill0() {
		if (LoginType.varcs.hasUnwrittenChanges()) {
			LoginType.varcs.write();
		}

		if (class268.mouseRecorder != null) {
			class268.mouseRecorder.isRunning = false;
		}

		class268.mouseRecorder = null;
		packetWriter.close();
		if (KeyHandler.KeyHandler_instance != null) {
			synchronized(KeyHandler.KeyHandler_instance) {
				KeyHandler.KeyHandler_instance = null;
			}
		}

		RouteStrategy.method4027();
		class136.mouseWheel = null;
		if (class241.pcmPlayer0 != null) {
			class241.pcmPlayer0.shutdown();
		}

		if (pcmPlayer1 != null) {
			pcmPlayer1.shutdown();
		}

		class14.method196();
		class139.method3104();
		if (Messages.urlRequester != null) {
			Messages.urlRequester.close();
			Messages.urlRequester = null;
		}

		try {
			JagexCache.JagexCache_dat2File.close();

			for (int var3 = 0; var3 < JagexCache.idxCount; ++var3) {
				JagexCache.JagexCache_idxFiles[var3].close();
			}

			JagexCache.JagexCache_idx255File.close();
			JagexCache.JagexCache_randomDat.close();
		} catch (Exception var5) {
		}

		this.field531.method192();
	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "3"
	)
	protected final void vmethod1229() {
	}

	@ObfuscatedName("fr")
	@ObfuscatedSignature(
		descriptor = "(B)Z",
		garbageValue = "-27"
	)
	boolean method1190() {
		return AccessFile.field4662 != null && !AccessFile.field4662.trim().isEmpty() && WorldMapManager.field2773 != null && !WorldMapManager.field2773.trim().isEmpty();
	}

	@ObfuscatedName("fg")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "659678762"
	)
	boolean method1191() {
		return this.field533 != null;
	}

	@ObfuscatedName("fv")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;I)V",
		garbageValue = "204177750"
	)
	void method1586(String var1) throws IOException {
		HashMap var2 = new HashMap();
		var2.put("grant_type", "refresh_token");
		var2.put("scope", "gamesso.token.create");
		var2.put("refresh_token", var1);
		URL var3 = new URL(Actor.field1164 + "shield/oauth/token" + (new class402(var2)).method7320());
		HashMap var4 = new HashMap();
		var4.put("Authorization", "Basic " + field661);
		var4.put("Host", (new URL(Actor.field1164)).getHost());
		var4.put("Accept", class399.field4470.method7299());
		class9 var5 = class9.field34;
		OtlTokenRequester var6 = this.field719;
		if (var6 != null) {
			this.field538 = var6.request(var5.method75(), var3, var4, "");
		} else {
			class10 var7 = new class10(var3, var5, this.field535);
			Iterator var8 = var4.entrySet().iterator();

			while (var8.hasNext()) {
				Entry var9 = (Entry)var8.next();
				var7.method92((String)var9.getKey(), (String)var9.getValue());
			}

			this.field536 = this.field531.method188(var7);
		}
	}

	@ObfuscatedName("fm")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;I)V",
		garbageValue = "1756143445"
	)
	void method1193(String var1) throws MalformedURLException, IOException {
		URL var2 = new URL(Actor.field1164 + "public/v1/games/YCfdbvr2pM1zUYMxJRexZY/play");
		HashMap var3 = new HashMap();
		var3.put("Authorization", "Bearer " + var1);
		class9 var4 = class9.field32;
		com.jagex.oldscape.pub.OtlTokenRequester var5 = this.field533;
		if (var5 != null) {
			this.field515 = var5.request(var4.method75(), var2, var3, "");
		} else {
			class10 var6 = new class10(var2, var4, this.field535);
			Iterator var7 = var3.entrySet().iterator();

			while (var7.hasNext()) {
				Entry var8 = (Entry)var7.next();
				var6.method92((String)var8.getKey(), (String)var8.getValue());
			}

			this.field576 = this.field531.method188(var6);
		}
	}

	@ObfuscatedName("fn")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "-125"
	)
	@Export("doCycleJs5")
	void doCycleJs5() {
		if (gameState != 1000) {
			long var2 = Language.method6232();
			int var4 = (int)(var2 - NetCache.field4058);
			NetCache.field4058 = var2;
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
					label244: {
						if (NetCache.NetCache_loadTime > 30000) {
							throw new IOException();
						}

						NetFileRequest var5;
						Buffer var6;
						while (NetCache.NetCache_pendingPriorityResponsesCount < 200 && NetCache.NetCache_pendingPriorityWritesCount > 0) {
							var5 = (NetFileRequest)NetCache.NetCache_pendingPriorityWrites.first();
							var6 = new Buffer(4);
							var6.writeByte(1);
							var6.writeMedium((int)var5.key);
							NetCache.NetCache_socket.write(var6.array, 0, 4);
							NetCache.NetCache_pendingPriorityResponses.put(var5, var5.key);
							--NetCache.NetCache_pendingPriorityWritesCount;
							++NetCache.NetCache_pendingPriorityResponsesCount;
						}

						while (NetCache.NetCache_pendingResponsesCount < 200 && NetCache.NetCache_pendingWritesCount > 0) {
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

						for (int var17 = 0; var17 < 100; ++var17) {
							int var18 = NetCache.NetCache_socket.available();
							if (var18 < 0) {
								throw new IOException();
							}

							if (var18 == 0) {
								break;
							}

							NetCache.NetCache_loadTime = 0;
							byte var7 = 0;
							if (class135.NetCache_currentResponse == null) {
								var7 = 8;
							} else if (NetCache.field4075 == 0) {
								var7 = 1;
							}

							int var8;
							int var9;
							int var10;
							byte[] var10000;
							int var10001;
							Buffer var24;
							if (var7 > 0) {
								var8 = var7 - NetCache.NetCache_responseHeaderBuffer.offset;
								if (var8 > var18) {
									var8 = var18;
								}

								NetCache.NetCache_socket.read(NetCache.NetCache_responseHeaderBuffer.array, NetCache.NetCache_responseHeaderBuffer.offset, var8);
								if (NetCache.field4068 != 0) {
									for (var9 = 0; var9 < var8; ++var9) {
										var10000 = NetCache.NetCache_responseHeaderBuffer.array;
										var10001 = NetCache.NetCache_responseHeaderBuffer.offset + var9;
										var10000[var10001] ^= NetCache.field4068;
									}
								}

								var24 = NetCache.NetCache_responseHeaderBuffer;
								var24.offset += var8;
								if (NetCache.NetCache_responseHeaderBuffer.offset < var7) {
									break;
								}

								if (class135.NetCache_currentResponse == null) {
									NetCache.NetCache_responseHeaderBuffer.offset = 0;
									var9 = NetCache.NetCache_responseHeaderBuffer.readUnsignedByte();
									var10 = NetCache.NetCache_responseHeaderBuffer.readUnsignedShort();
									int var11 = NetCache.NetCache_responseHeaderBuffer.readUnsignedByte();
									int var12 = NetCache.NetCache_responseHeaderBuffer.readInt();
									long var13 = (long)(var10 + (var9 << 16));
									NetFileRequest var15 = (NetFileRequest)NetCache.NetCache_pendingPriorityResponses.get(var13);
									AbstractWorldMapIcon.field2886 = true;
									if (var15 == null) {
										var15 = (NetFileRequest)NetCache.NetCache_pendingResponses.get(var13);
										AbstractWorldMapIcon.field2886 = false;
									}

									if (var15 == null) {
										throw new IOException();
									}

									int var16 = var11 == 0 ? 5 : 9;
									class135.NetCache_currentResponse = var15;
									class20.NetCache_responseArchiveBuffer = new Buffer(var16 + var12 + class135.NetCache_currentResponse.padding);
									class20.NetCache_responseArchiveBuffer.writeByte(var11);
									class20.NetCache_responseArchiveBuffer.writeInt(var12);
									NetCache.field4075 = 8;
									NetCache.NetCache_responseHeaderBuffer.offset = 0;
								} else if (NetCache.field4075 == 0) {
									if (NetCache.NetCache_responseHeaderBuffer.array[0] == -1) {
										NetCache.field4075 = 1;
										NetCache.NetCache_responseHeaderBuffer.offset = 0;
									} else {
										class135.NetCache_currentResponse = null;
									}
								}
							} else {
								var8 = class20.NetCache_responseArchiveBuffer.array.length - class135.NetCache_currentResponse.padding;
								var9 = 512 - NetCache.field4075;
								if (var9 > var8 - class20.NetCache_responseArchiveBuffer.offset) {
									var9 = var8 - class20.NetCache_responseArchiveBuffer.offset;
								}

								if (var9 > var18) {
									var9 = var18;
								}

								NetCache.NetCache_socket.read(class20.NetCache_responseArchiveBuffer.array, class20.NetCache_responseArchiveBuffer.offset, var9);
								if (NetCache.field4068 != 0) {
									for (var10 = 0; var10 < var9; ++var10) {
										var10000 = class20.NetCache_responseArchiveBuffer.array;
										var10001 = var10 + class20.NetCache_responseArchiveBuffer.offset;
										var10000[var10001] ^= NetCache.field4068;
									}
								}

								var24 = class20.NetCache_responseArchiveBuffer;
								var24.offset += var9;
								NetCache.field4075 += var9;
								if (var8 == class20.NetCache_responseArchiveBuffer.offset) {
									if (class135.NetCache_currentResponse.key == 16711935L) {
										MilliClock.field1810 = class20.NetCache_responseArchiveBuffer;

										for (var10 = 0; var10 < 256; ++var10) {
											Archive var19 = NetCache.NetCache_archives[var10];
											if (var19 != null) {
												WorldMapID.method5123(var19, var10);
											}
										}
									} else {
										NetCache.NetCache_crc.reset();
										NetCache.NetCache_crc.update(class20.NetCache_responseArchiveBuffer.array, 0, var8);
										var10 = (int)NetCache.NetCache_crc.getValue();
										if (var10 != class135.NetCache_currentResponse.crc) {
											try {
												NetCache.NetCache_socket.close();
											} catch (Exception var22) {
											}

											++NetCache.NetCache_crcMismatches;
											NetCache.NetCache_socket = null;
											NetCache.field4068 = (byte)((int)(Math.random() * 255.0D + 1.0D));
											var1 = false;
											break label244;
										}

										NetCache.NetCache_crcMismatches = 0;
										NetCache.NetCache_ioExceptions = 0;
										class135.NetCache_currentResponse.archive.write((int)(class135.NetCache_currentResponse.key & 65535L), class20.NetCache_responseArchiveBuffer.array, (class135.NetCache_currentResponse.key & 16711680L) == 16711680L, AbstractWorldMapIcon.field2886);
									}

									class135.NetCache_currentResponse.remove();
									if (AbstractWorldMapIcon.field2886) {
										--NetCache.NetCache_pendingPriorityResponsesCount;
									} else {
										--NetCache.NetCache_pendingResponsesCount;
									}

									NetCache.field4075 = 0;
									class135.NetCache_currentResponse = null;
									class20.NetCache_responseArchiveBuffer = null;
								} else {
									if (NetCache.field4075 != 512) {
										break;
									}

									NetCache.field4075 = 0;
								}
							}
						}

						var1 = true;
					}
				} catch (IOException var23) {
					try {
						NetCache.NetCache_socket.close();
					} catch (Exception var21) {
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

	@ObfuscatedName("fp")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "-29"
	)
	@Export("doCycleJs5Connect")
	void doCycleJs5Connect() {
		if (NetCache.NetCache_crcMismatches >= 4) {
			this.error("js5crc");
			Coord.updateGameState(1000);
		} else {
			if (NetCache.NetCache_ioExceptions >= 4) {
				if (gameState <= 5) {
					this.error("js5io");
					Coord.updateGameState(1000);
					return;
				}

				field522 = 3000;
				NetCache.NetCache_ioExceptions = 3;
			}

			if (--field522 + 1 <= 0) {
				try {
					if (js5ConnectState == 0) {
						HealthBarDefinition.js5SocketTask = class11.taskHandler.newSocketTask(WorldMapLabelSize.worldHost, BuddyRankComparator.currentPort);
						++js5ConnectState;
					}

					if (js5ConnectState == 1) {
						if (HealthBarDefinition.js5SocketTask.status == 2) {
							this.js5Error(-1);
							return;
						}

						if (HealthBarDefinition.js5SocketTask.status == 1) {
							++js5ConnectState;
						}
					}

					if (js5ConnectState == 2) {
						Socket var2 = (Socket)HealthBarDefinition.js5SocketTask.result;
						BufferedNetSocket var1 = new BufferedNetSocket(var2, 40000, 5000);
						WorldMapLabelSize.js5Socket = var1;
						Buffer var3 = new Buffer(5);
						var3.writeByte(15);
						var3.writeInt(208);
						WorldMapLabelSize.js5Socket.write(var3.array, 0, 5);
						++js5ConnectState;
						Projectile.field949 = Language.method6232();
					}

					if (js5ConnectState == 3) {
						if (WorldMapLabelSize.js5Socket.available() > 0) {
							int var4 = WorldMapLabelSize.js5Socket.readUnsignedByte();
							if (var4 != 0) {
								this.js5Error(var4);
								return;
							}

							++js5ConnectState;
						} else if (Language.method6232() - Projectile.field949 > 30000L) {
							this.js5Error(-2);
							return;
						}
					}

					if (js5ConnectState == 4) {
						class182.method3703(WorldMapLabelSize.js5Socket, gameState > 20);
						HealthBarDefinition.js5SocketTask = null;
						WorldMapLabelSize.js5Socket = null;
						js5ConnectState = 0;
						js5Errors = 0;
					}
				} catch (IOException var5) {
					this.js5Error(-3);
				}

			}
		}
	}

	@ObfuscatedName("fj")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "-725482489"
	)
	@Export("js5Error")
	void js5Error(int var1) {
		HealthBarDefinition.js5SocketTask = null;
		WorldMapLabelSize.js5Socket = null;
		js5ConnectState = 0;
		if (BuddyRankComparator.currentPort == NPC.worldPort) {
			BuddyRankComparator.currentPort = TaskHandler.js5Port;
		} else {
			BuddyRankComparator.currentPort = NPC.worldPort;
		}

		++js5Errors;
		if (js5Errors < 2 || var1 != 7 && var1 != 9) {
			if (js5Errors >= 2 && var1 == 6) {
				this.error("js5connect_outofdate");
				Coord.updateGameState(1000);
			} else if (js5Errors >= 4) {
				if (gameState <= 5) {
					this.error("js5connect");
					Coord.updateGameState(1000);
				} else {
					field522 = 3000;
				}
			}
		} else if (gameState <= 5) {
			this.error("js5connect_full");
			Coord.updateGameState(1000);
		} else {
			field522 = 3000;
		}

	}

	@ObfuscatedName("fh")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "2142038163"
	)
	@Export("doCycleLoggedOut")
	final void doCycleLoggedOut() {
		Object var1 = packetWriter.getSocket();
		PacketBuffer var2 = packetWriter.packetBuffer;

		try {
			if (loginState == 0) {
				if (class29.secureRandom == null && (secureRandomFuture.isDone() || field525 > 250)) {
					class29.secureRandom = secureRandomFuture.get();
					secureRandomFuture.shutdown();
					secureRandomFuture = null;
				}

				if (class29.secureRandom != null) {
					if (var1 != null) {
						((AbstractSocket)var1).close();
						var1 = null;
					}

					Clock.socketTask = null;
					hadNetworkError = false;
					field525 = 0;
					if (field639.method8184()) {
						try {
							this.method1586(WorldMapManager.field2773);
							class142.method3196(21);
						} catch (Throwable var29) {
							Clock.RunException_sendStackTrace((String)null, var29);
							class12.getLoginError(65);
							return;
						}
					} else {
						class142.method3196(1);
					}
				}
			}

			OtlTokenResponse var3;
			class21 var32;
			if (loginState == 21) {
				if (this.field538 != null) {
					if (!this.field538.isDone()) {
						return;
					}

					if (this.field538.isCancelled()) {
						class12.getLoginError(65);
						this.field538 = null;
						return;
					}

					try {
						var3 = (OtlTokenResponse)this.field538.get();
						if (!var3.isSuccess()) {
							class12.getLoginError(65);
							this.field538 = null;
							return;
						}

						AccessFile.field4662 = var3.getAccessToken();
						WorldMapManager.field2773 = var3.getRefreshToken();
						this.field538 = null;
					} catch (Exception var28) {
						Clock.RunException_sendStackTrace((String)null, var28);
						class12.getLoginError(65);
						this.field538 = null;
						return;
					}
				} else {
					if (this.field536 == null) {
						class12.getLoginError(65);
						return;
					}

					if (!this.field536.method291()) {
						return;
					}

					if (this.field536.method289()) {
						Clock.RunException_sendStackTrace(this.field536.method288(), (Throwable)null);
						class12.getLoginError(65);
						this.field536 = null;
						return;
					}

					var32 = this.field536.method286();
					if (var32.method306() != 200) {
						class12.getLoginError(65);
						this.field536 = null;
						return;
					}

					field525 = 0;
					class401 var4 = new class401(var32.method307());

					try {
						AccessFile.field4662 = var4.method7307().getString("access_token");
						WorldMapManager.field2773 = var4.method7307().getString("refresh_token");
					} catch (Exception var27) {
						Clock.RunException_sendStackTrace("Error parsing tokens", var27);
						class12.getLoginError(65);
						this.field536 = null;
						return;
					}
				}

				this.method1193(AccessFile.field4662);
				class142.method3196(20);
			}

			if (loginState == 20) {
				if (this.field515 != null) {
					if (!this.field515.isDone()) {
						return;
					}

					if (this.field515.isCancelled()) {
						class12.getLoginError(65);
						this.field515 = null;
						return;
					}

					try {
						var3 = (OtlTokenResponse)this.field515.get();
						if (!var3.isSuccess()) {
							class12.getLoginError(65);
							this.field515 = null;
							return;
						}

						this.field530 = var3.getAccessToken();
						this.field515 = null;
					} catch (Exception var26) {
						Clock.RunException_sendStackTrace((String)null, var26);
						class12.getLoginError(65);
						this.field515 = null;
						return;
					}
				} else {
					if (this.field576 == null) {
						class12.getLoginError(65);
						return;
					}

					if (!this.field576.method291()) {
						return;
					}

					if (this.field576.method289()) {
						Clock.RunException_sendStackTrace(this.field576.method288(), (Throwable)null);
						class12.getLoginError(65);
						this.field576 = null;
						return;
					}

					var32 = this.field576.method286();
					if (var32.method306() != 200) {
						Clock.RunException_sendStackTrace("Response code: " + var32.method306() + "Response body: " + var32.method307(), (Throwable)null);
						class12.getLoginError(65);
						this.field576 = null;
						return;
					}

					this.field530 = var32.method307();
					this.field576 = null;
				}

				field525 = 0;
				class142.method3196(1);
			}

			if (loginState == 1) {
				if (Clock.socketTask == null) {
					Clock.socketTask = class11.taskHandler.newSocketTask(WorldMapLabelSize.worldHost, BuddyRankComparator.currentPort);
				}

				if (Clock.socketTask.status == 2) {
					throw new IOException();
				}

				if (Clock.socketTask.status == 1) {
					Socket var33 = (Socket)Clock.socketTask.result;
					BufferedNetSocket var34 = new BufferedNetSocket(var33, 40000, 5000);
					var1 = var34;
					packetWriter.setSocket(var34);
					Clock.socketTask = null;
					class142.method3196(2);
				}
			}

			PacketBufferNode var35;
			if (loginState == 2) {
				packetWriter.clearBuffer();
				var35 = PcmPlayer.method795();
				var35.clientPacket = null;
				var35.clientPacketLength = 0;
				var35.packetBuffer = new PacketBuffer(5000);
				var35.packetBuffer.writeByte(LoginPacket.field3182.id);
				packetWriter.addNode(var35);
				packetWriter.flush();
				var2.offset = 0;
				class142.method3196(3);
			}

			int var15;
			if (loginState == 3) {
				if (class241.pcmPlayer0 != null) {
					class241.pcmPlayer0.method774();
				}

				if (pcmPlayer1 != null) {
					pcmPlayer1.method774();
				}

				if (((AbstractSocket)var1).isAvailable(1)) {
					var15 = ((AbstractSocket)var1).readUnsignedByte();
					if (class241.pcmPlayer0 != null) {
						class241.pcmPlayer0.method774();
					}

					if (pcmPlayer1 != null) {
						pcmPlayer1.method774();
					}

					if (var15 != 0) {
						class12.getLoginError(var15);
						return;
					}

					var2.offset = 0;
					class142.method3196(4);
				}
			}

			if (loginState == 4) {
				if (var2.offset < 8) {
					var15 = ((AbstractSocket)var1).available();
					if (var15 > 8 - var2.offset) {
						var15 = 8 - var2.offset;
					}

					if (var15 > 0) {
						((AbstractSocket)var1).read(var2.array, var2.offset, var15);
						var2.offset += var15;
					}
				}

				if (var2.offset == 8) {
					var2.offset = 0;
					class6.field16 = var2.readLong();
					class142.method3196(5);
				}
			}

			if (loginState == 5) {
				packetWriter.packetBuffer.offset = 0;
				packetWriter.clearBuffer();
				PacketBuffer var36 = new PacketBuffer(500);
				int[] var37 = new int[]{class29.secureRandom.nextInt(), class29.secureRandom.nextInt(), class29.secureRandom.nextInt(), class29.secureRandom.nextInt()};
				var36.offset = 0;
				var36.writeByte(1);
				var36.writeInt(var37[0]);
				var36.writeInt(var37[1]);
				var36.writeInt(var37[2]);
				var36.writeInt(var37[3]);
				var36.writeLong(class6.field16);
				int var9;
				if (gameState == 40) {
					var36.writeInt(class29.field176[0]);
					var36.writeInt(class29.field176[1]);
					var36.writeInt(class29.field176[2]);
					var36.writeInt(class29.field176[3]);
				} else {
					if (gameState == 50) {
						var36.writeByte(class125.field1540.rsOrdinal());
						var36.writeInt(MusicPatchNode2.field3223);
					} else {
						var36.writeByte(field528.rsOrdinal());
						switch(field528.field1544) {
						case 0:
						case 3:
							var36.writeMedium(class347.field4201);
							++var36.offset;
							break;
						case 1:
							LinkedHashMap var6 = Player.clientPreferences.parameters;
							String var8 = Login.Login_username;
							var9 = var8.length();
							int var10 = 0;

							for (int var11 = 0; var11 < var9; ++var11) {
								var10 = (var10 << 5) - var10 + var8.charAt(var11);
							}

							var36.writeInt((Integer)var6.get(var10));
						case 2:
						default:
							break;
						case 4:
							var36.offset += 4;
						}
					}

					if (field639.method8184()) {
						var36.writeByte(class448.field4785.rsOrdinal());
						var36.writeStringCp1252NullTerminated(this.field530);
					} else {
						var36.writeByte(class448.field4784.rsOrdinal());
						var36.writeStringCp1252NullTerminated(Login.Login_password);
					}
				}

				var36.encryptRsa(class67.field884, class67.field885);
				class29.field176 = var37;
				PacketBufferNode var43 = PcmPlayer.method795();
				var43.clientPacket = null;
				var43.clientPacketLength = 0;
				var43.packetBuffer = new PacketBuffer(5000);
				var43.packetBuffer.offset = 0;
				if (gameState == 40) {
					var43.packetBuffer.writeByte(LoginPacket.field3179.id);
				} else {
					var43.packetBuffer.writeByte(LoginPacket.field3187.id);
				}

				var43.packetBuffer.writeShort(0);
				int var7 = var43.packetBuffer.offset;
				var43.packetBuffer.writeInt(208);
				var43.packetBuffer.writeInt(1);
				var43.packetBuffer.writeByte(clientType);
				var43.packetBuffer.writeByte(field571);
				byte var16 = 0;
				var43.packetBuffer.writeByte(var16);
				var43.packetBuffer.writeBytes(var36.array, 0, var36.offset);
				var9 = var43.packetBuffer.offset;
				var43.packetBuffer.writeStringCp1252NullTerminated(Login.Login_username);
				var43.packetBuffer.writeByte((isResizable ? 1 : 0) << 1 | (isLowDetail ? 1 : 0));
				var43.packetBuffer.writeShort(class123.canvasWidth);
				var43.packetBuffer.writeShort(class166.canvasHeight);
				PacketBuffer var17 = var43.packetBuffer;
				int var13;
				if (randomDatData != null) {
					var17.writeBytes(randomDatData, 0, randomDatData.length);
				} else {
					byte[] var12 = new byte[24];

					try {
						JagexCache.JagexCache_randomDat.seek(0L);
						JagexCache.JagexCache_randomDat.readFully(var12);

						for (var13 = 0; var13 < 24 && var12[var13] == 0; ++var13) {
						}

						if (var13 >= 24) {
							throw new IOException();
						}
					} catch (Exception var30) {
						for (int var14 = 0; var14 < 24; ++var14) {
							var12[var14] = -1;
						}
					}

					var17.writeBytes(var12, 0, var12.length);
				}

				var43.packetBuffer.writeStringCp1252NullTerminated(AttackOption.field1279);
				var43.packetBuffer.writeInt(UserComparator10.field1393);
				Buffer var19 = new Buffer(class9.platformInfo.size());
				class9.platformInfo.write(var19);
				var43.packetBuffer.writeBytes(var19.array, 0, var19.array.length);
				var43.packetBuffer.writeByte(clientType);
				var43.packetBuffer.writeInt(0);
				var43.packetBuffer.method7916(HealthBar.archive17.hash);
				var43.packetBuffer.method7972(UserComparator10.archive4.hash);
				var43.packetBuffer.method7971(UserList.archive13.hash);
				var43.packetBuffer.writeInt(class283.field3325.hash);
				var43.packetBuffer.method7971(0);
				var43.packetBuffer.method7971(UserComparator10.archive19.hash);
				var43.packetBuffer.writeInt(DevicePcmPlayerProvider.archive5.hash);
				var43.packetBuffer.writeInt(class163.archive10.hash);
				var43.packetBuffer.method7971(class119.archive2.hash);
				var43.packetBuffer.method7972(ChatChannel.archive8.hash);
				var43.packetBuffer.method7916(class301.archive7.hash);
				var43.packetBuffer.method7916(Huffman.archive20.hash);
				var43.packetBuffer.writeInt(HorizontalAlignment.field1926.hash);
				var43.packetBuffer.writeInt(class83.field1081.hash);
				var43.packetBuffer.method7972(class14.archive6.hash);
				var43.packetBuffer.writeInt(class14.archive14.hash);
				var43.packetBuffer.method7971(class434.archive9.hash);
				var43.packetBuffer.writeInt(FaceNormal.archive11.hash);
				var43.packetBuffer.method7971(class19.archive15.hash);
				var43.packetBuffer.method7916(class102.archive12.hash);
				var43.packetBuffer.method7972(class67.archive18.hash);
				var43.packetBuffer.xteaEncrypt(var37, var9, var43.packetBuffer.offset);
				var43.packetBuffer.writeLengthShort(var43.packetBuffer.offset - var7);
				packetWriter.addNode(var43);
				packetWriter.flush();
				packetWriter.isaacCipher = new IsaacCipher(var37);
				int[] var45 = new int[4];

				for (var13 = 0; var13 < 4; ++var13) {
					var45[var13] = var37[var13] + 50;
				}

				var2.newIsaacCipher(var45);
				class142.method3196(6);
			}

			int var20;
			if (loginState == 6 && ((AbstractSocket)var1).available() > 0) {
				var15 = ((AbstractSocket)var1).readUnsignedByte();
				if (var15 == 61) {
					var20 = ((AbstractSocket)var1).available();
					UserComparator9.field1387 = var20 == 1 && ((AbstractSocket)var1).readUnsignedByte() == 1;
					class142.method3196(5);
				}

				if (var15 == 21 && gameState == 20) {
					class142.method3196(12);
				} else if (var15 == 2) {
					class142.method3196(14);
				} else if (var15 == 15 && gameState == 40) {
					packetWriter.serverPacketLength = -1;
					class142.method3196(19);
				} else if (var15 == 64) {
					class142.method3196(10);
				} else if (var15 == 23 && field526 < 1) {
					++field526;
					class142.method3196(0);
				} else if (var15 == 29) {
					class142.method3196(17);
				} else {
					if (var15 != 69) {
						class12.getLoginError(var15);
						return;
					}

					class142.method3196(7);
				}
			}

			if (loginState == 7 && ((AbstractSocket)var1).available() >= 2) {
				((AbstractSocket)var1).read(var2.array, 0, 2);
				var2.offset = 0;
				FillMode.field4809 = var2.readUnsignedShort();
				class142.method3196(8);
			}

			if (loginState == 8 && ((AbstractSocket)var1).available() >= FillMode.field4809) {
				var2.offset = 0;
				((AbstractSocket)var1).read(var2.array, var2.offset, FillMode.field4809);
				class6 var38 = class117.method2863()[var2.readUnsignedByte()];

				try {
					class3 var39 = method1723(var38);
					this.field721 = new class7(var2, var39);
					class142.method3196(9);
				} catch (Exception var25) {
					class12.getLoginError(22);
					return;
				}
			}

			if (loginState == 9 && this.field721.method51()) {
				this.field542 = this.field721.method55();
				this.field721.method52();
				this.field721 = null;
				if (this.field542 == null) {
					class12.getLoginError(22);
					return;
				}

				packetWriter.clearBuffer();
				var35 = PcmPlayer.method795();
				var35.clientPacket = null;
				var35.clientPacketLength = 0;
				var35.packetBuffer = new PacketBuffer(5000);
				var35.packetBuffer.writeByte(LoginPacket.field3183.id);
				var35.packetBuffer.writeShort(this.field542.offset);
				var35.packetBuffer.method8116(this.field542);
				packetWriter.addNode(var35);
				packetWriter.flush();
				this.field542 = null;
				class142.method3196(6);
			}

			if (loginState == 10 && ((AbstractSocket)var1).available() > 0) {
				ScriptFrame.field464 = ((AbstractSocket)var1).readUnsignedByte();
				class142.method3196(11);
			}

			if (loginState == 11 && ((AbstractSocket)var1).available() >= ScriptFrame.field464) {
				((AbstractSocket)var1).read(var2.array, 0, ScriptFrame.field464);
				var2.offset = 0;
				class142.method3196(6);
			}

			if (loginState == 12 && ((AbstractSocket)var1).available() > 0) {
				field527 = (((AbstractSocket)var1).readUnsignedByte() + 3) * 60;
				class142.method3196(13);
			}

			if (loginState == 13) {
				field525 = 0;
				SecureRandomCallable.setLoginResponseString("You have only just left another world.", "Your profile will be transferred in:", field527 / 60 + " seconds.");
				if (--field527 <= 0) {
					class142.method3196(0);
				}

			} else {
				if (loginState == 14 && ((AbstractSocket)var1).available() >= 1) {
					class9.field31 = ((AbstractSocket)var1).readUnsignedByte();
					class142.method3196(15);
				}

				if (loginState == 15 && ((AbstractSocket)var1).available() >= class9.field31) {
					boolean var46 = ((AbstractSocket)var1).readUnsignedByte() == 1;
					((AbstractSocket)var1).read(var2.array, 0, 4);
					var2.offset = 0;
					boolean var47 = false;
					if (var46) {
						var20 = var2.readByteIsaac() << 24;
						var20 |= var2.readByteIsaac() << 16;
						var20 |= var2.readByteIsaac() << 8;
						var20 |= var2.readByteIsaac();
						int var21 = Skeleton.method4255(Login.Login_username);
						if (Player.clientPreferences.parameters.size() >= 10 && !Player.clientPreferences.parameters.containsKey(var21)) {
							Iterator var44 = Player.clientPreferences.parameters.entrySet().iterator();
							var44.next();
							var44.remove();
						}

						Player.clientPreferences.parameters.put(var21, var20);
					}

					if (Login_isUsernameRemembered) {
						Player.clientPreferences.method2406(Login.Login_username);
					} else {
						Player.clientPreferences.method2406((String)null);
					}

					GrandExchangeOfferAgeComparator.savePreferences();
					staffModLevel = ((AbstractSocket)var1).readUnsignedByte();
					playerMod = ((AbstractSocket)var1).readUnsignedByte() == 1;
					localPlayerIndex = ((AbstractSocket)var1).readUnsignedByte();
					localPlayerIndex <<= 8;
					localPlayerIndex += ((AbstractSocket)var1).readUnsignedByte();
					field621 = ((AbstractSocket)var1).readUnsignedByte();
					((AbstractSocket)var1).read(var2.array, 0, 8);
					var2.offset = 0;
					this.field710 = var2.readLong();
					if (class9.field31 >= 29) {
						((AbstractSocket)var1).read(var2.array, 0, 8);
						var2.offset = 0;
						field498 = var2.readLong();
					}

					((AbstractSocket)var1).read(var2.array, 0, 1);
					var2.offset = 0;
					ServerPacket[] var5 = WorldMapEvent.ServerPacket_values();
					int var22 = var2.readSmartByteShortIsaac();
					if (var22 < 0 || var22 >= var5.length) {
						throw new IOException(var22 + " " + var2.offset);
					}

					packetWriter.serverPacket = var5[var22];
					packetWriter.serverPacketLength = packetWriter.serverPacket.length;
					((AbstractSocket)var1).read(var2.array, 0, 2);
					var2.offset = 0;
					packetWriter.serverPacketLength = var2.readUnsignedShort();

					try {
						class27.method404(IgnoreList.client, "zap");
					} catch (Throwable var24) {
					}

					class142.method3196(16);
				}

				if (loginState == 16) {
					if (((AbstractSocket)var1).available() >= packetWriter.serverPacketLength) {
						var2.offset = 0;
						((AbstractSocket)var1).read(var2.array, 0, packetWriter.serverPacketLength);
						timer.method6701();
						class11.method113();
						RouteStrategy.updatePlayer(var2);
						class6.field17 = -1;
						class114.loadRegions(false, var2);
						packetWriter.serverPacket = null;
					}

				} else {
					if (loginState == 17 && ((AbstractSocket)var1).available() >= 2) {
						var2.offset = 0;
						((AbstractSocket)var1).read(var2.array, 0, 2);
						var2.offset = 0;
						class97.field1320 = var2.readUnsignedShort();
						class142.method3196(18);
					}

					if (loginState == 18 && ((AbstractSocket)var1).available() >= class97.field1320) {
						var2.offset = 0;
						((AbstractSocket)var1).read(var2.array, 0, class97.field1320);
						var2.offset = 0;
						String var40 = var2.readStringCp1252NullTerminated();
						String var42 = var2.readStringCp1252NullTerminated();
						String var41 = var2.readStringCp1252NullTerminated();
						SecureRandomCallable.setLoginResponseString(var40, var42, var41);
						Coord.updateGameState(10);
						if (field639.method8184()) {
							class139.method3101(9);
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
							var15 = packetWriter.serverPacketLength;
							timer.method6725();
							class343.method6444();
							RouteStrategy.updatePlayer(var2);
							if (var15 != var2.offset) {
								throw new RuntimeException();
							}
						}
					} else {
						++field525;
						if (field525 > 2000) {
							if (field526 < 1) {
								if (NPC.worldPort == BuddyRankComparator.currentPort) {
									BuddyRankComparator.currentPort = TaskHandler.js5Port;
								} else {
									BuddyRankComparator.currentPort = NPC.worldPort;
								}

								++field526;
								class142.method3196(0);
							} else {
								class12.getLoginError(-3);
							}
						}
					}
				}
			}
		} catch (IOException var31) {
			if (field526 < 1) {
				if (NPC.worldPort == BuddyRankComparator.currentPort) {
					BuddyRankComparator.currentPort = TaskHandler.js5Port;
				} else {
					BuddyRankComparator.currentPort = NPC.worldPort;
				}

				++field526;
				class142.method3196(0);
			} else {
				class12.getLoginError(-2);
			}
		}
	}

	@ObfuscatedName("ft")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "695049263"
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
			class67.method2033();
		} else {
			if (!isMenuOpen) {
				FloorOverlayDefinition.addCancelMenuEntry();
			}

			for (int var1 = 0; var1 < 100 && this.method1447(packetWriter); ++var1) {
			}

			if (gameState == 30) {
				int var2;
				PacketBufferNode var14;
				while (class153.method3318()) {
					var14 = class120.getPacketBufferNode(ClientPacket.field2960, packetWriter.isaacCipher);
					var14.packetBuffer.writeByte(0);
					var2 = var14.packetBuffer.offset;
					class130.performReflectionCheck(var14.packetBuffer);
					var14.packetBuffer.method7920(var14.packetBuffer.offset - var2);
					packetWriter.addNode(var14);
				}

				if (timer.field4265) {
					var14 = class120.getPacketBufferNode(ClientPacket.field3021, packetWriter.isaacCipher);
					var14.packetBuffer.writeByte(0);
					var2 = var14.packetBuffer.offset;
					timer.write(var14.packetBuffer);
					var14.packetBuffer.method7920(var14.packetBuffer.offset - var2);
					packetWriter.addNode(var14);
					timer.method6724();
				}

				int var3;
				int var4;
				int var5;
				int var6;
				int var7;
				int var8;
				synchronized(class268.mouseRecorder.lock) {
					if (!field587) {
						class268.mouseRecorder.index = 0;
					} else if (MouseHandler.MouseHandler_lastButton != 0 || class268.mouseRecorder.index >= 40) {
						PacketBufferNode var15 = null;
						var3 = 0;
						var4 = 0;
						var5 = 0;
						var6 = 0;

						for (var7 = 0; var7 < class268.mouseRecorder.index && (var15 == null || var15.packetBuffer.offset - var3 < 246); ++var7) {
							var4 = var7;
							var8 = class268.mouseRecorder.ys[var7];
							if (var8 < -1) {
								var8 = -1;
							} else if (var8 > 65534) {
								var8 = 65534;
							}

							int var9 = class268.mouseRecorder.xs[var7];
							if (var9 < -1) {
								var9 = -1;
							} else if (var9 > 65534) {
								var9 = 65534;
							}

							if (var9 != field505 || var8 != field506) {
								if (var15 == null) {
									var15 = class120.getPacketBufferNode(ClientPacket.field2952, packetWriter.isaacCipher);
									var15.packetBuffer.writeByte(0);
									var3 = var15.packetBuffer.offset;
									PacketBuffer var10000 = var15.packetBuffer;
									var10000.offset += 2;
									var5 = 0;
									var6 = 0;
								}

								int var10;
								int var11;
								int var12;
								if (field507 != -1L) {
									var10 = var9 - field505;
									var11 = var8 - field506;
									var12 = (int)((class268.mouseRecorder.millis[var7] - field507) / 20L);
									var5 = (int)((long)var5 + (class268.mouseRecorder.millis[var7] - field507) % 20L);
								} else {
									var10 = var9;
									var11 = var8;
									var12 = Integer.MAX_VALUE;
								}

								field505 = var9;
								field506 = var8;
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
								field507 = class268.mouseRecorder.millis[var7];
							}
						}

						if (var15 != null) {
							var15.packetBuffer.method7920(var15.packetBuffer.offset - var3);
							var7 = var15.packetBuffer.offset;
							var15.packetBuffer.offset = var3;
							var15.packetBuffer.writeByte(var5 / var6);
							var15.packetBuffer.writeByte(var5 % var6);
							var15.packetBuffer.offset = var7;
							packetWriter.addNode(var15);
						}

						if (var4 >= class268.mouseRecorder.index) {
							class268.mouseRecorder.index = 0;
						} else {
							MouseRecorder var40 = class268.mouseRecorder;
							var40.index -= var4;
							System.arraycopy(class268.mouseRecorder.xs, var4, class268.mouseRecorder.xs, 0, class268.mouseRecorder.index);
							System.arraycopy(class268.mouseRecorder.ys, var4, class268.mouseRecorder.ys, 0, class268.mouseRecorder.index);
							System.arraycopy(class268.mouseRecorder.millis, var4, class268.mouseRecorder.millis, 0, class268.mouseRecorder.index);
						}
					}
				}

				PacketBufferNode var18;
				if (MouseHandler.MouseHandler_lastButton == 1 || !Renderable.mouseCam && MouseHandler.MouseHandler_lastButton == 4 || MouseHandler.MouseHandler_lastButton == 2) {
					long var16 = MouseHandler.MouseHandler_lastPressedTimeMillis - mouseLastLastPressedTimeMillis * -1L;
					if (var16 > 32767L) {
						var16 = 32767L;
					}

					mouseLastLastPressedTimeMillis = MouseHandler.MouseHandler_lastPressedTimeMillis * -1L;
					var3 = MouseHandler.MouseHandler_lastPressedY;
					if (var3 < 0) {
						var3 = 0;
					} else if (var3 > class166.canvasHeight) {
						var3 = class166.canvasHeight;
					}

					var4 = MouseHandler.MouseHandler_lastPressedX;
					if (var4 < 0) {
						var4 = 0;
					} else if (var4 > class123.canvasWidth) {
						var4 = class123.canvasWidth;
					}

					var5 = (int)var16;
					var18 = class120.getPacketBufferNode(ClientPacket.field3039, packetWriter.isaacCipher);
					var18.packetBuffer.writeShort((MouseHandler.MouseHandler_lastButton == 2 ? 1 : 0) + (var5 << 1));
					var18.packetBuffer.writeShort(var4);
					var18.packetBuffer.writeShort(var3);
					packetWriter.addNode(var18);
				}

				if (KeyHandler.field141 > 0) {
					var14 = class120.getPacketBufferNode(ClientPacket.field3023, packetWriter.isaacCipher);
					var14.packetBuffer.writeShort(0);
					var2 = var14.packetBuffer.offset;
					long var19 = Language.method6232();

					for (var5 = 0; var5 < KeyHandler.field141; ++var5) {
						long var21 = var19 - field733;
						if (var21 > 16777215L) {
							var21 = 16777215L;
						}

						field733 = var19;
						var14.packetBuffer.method7983((int)var21);
						var14.packetBuffer.method8136(KeyHandler.field140[var5]);
					}

					var14.packetBuffer.writeLengthShort(var14.packetBuffer.offset - var2);
					packetWriter.addNode(var14);
				}

				if (field630 > 0) {
					--field630;
				}

				if (KeyHandler.KeyHandler_pressedKeys[96] || KeyHandler.KeyHandler_pressedKeys[97] || KeyHandler.KeyHandler_pressedKeys[98] || KeyHandler.KeyHandler_pressedKeys[99]) {
					field543 = true;
				}

				if (field543 && field630 <= 0) {
					field630 = 20;
					field543 = false;
					var14 = class120.getPacketBufferNode(ClientPacket.field2940, packetWriter.isaacCipher);
					var14.packetBuffer.writeShort(camAngleX);
					var14.packetBuffer.writeIntME(camAngleY);
					packetWriter.addNode(var14);
				}

				if (class92.hasFocus && !hadFocus) {
					hadFocus = true;
					var14 = class120.getPacketBufferNode(ClientPacket.field3005, packetWriter.isaacCipher);
					var14.packetBuffer.writeByte(1);
					packetWriter.addNode(var14);
				}

				if (!class92.hasFocus && hadFocus) {
					hadFocus = false;
					var14 = class120.getPacketBufferNode(ClientPacket.field3005, packetWriter.isaacCipher);
					var14.packetBuffer.writeByte(0);
					packetWriter.addNode(var14);
				}

				if (Decimator.worldMap != null) {
					Decimator.worldMap.method7397();
				}

				TaskHandler.method3430();
				if (SecureRandomFuture.field964) {
					class230.method5028();
					SecureRandomFuture.field964 = false;
				}

				class175.method3615();
				if (gameState == 30) {
					for (PendingSpawn var31 = (PendingSpawn)pendingSpawns.last(); var31 != null; var31 = (PendingSpawn)pendingSpawns.previous()) {
						if (var31.hitpoints > 0) {
							--var31.hitpoints;
						}

						if (var31.hitpoints == 0) {
							if (var31.objectId < 0 || UserComparator9.method2776(var31.objectId, var31.field1121)) {
								TaskHandler.addPendingSpawnToScene(var31.plane, var31.type, var31.x, var31.y, var31.objectId, var31.field1119, var31.field1121);
								var31.remove();
							}
						} else {
							if (var31.delay > 0) {
								--var31.delay;
							}

							if (var31.delay == 0 && var31.x >= 1 && var31.y >= 1 && var31.x <= 102 && var31.y <= 102 && (var31.id < 0 || UserComparator9.method2776(var31.id, var31.field1123))) {
								TaskHandler.addPendingSpawnToScene(var31.plane, var31.type, var31.x, var31.y, var31.id, var31.orientation, var31.field1123);
								var31.delay = -1;
								if (var31.objectId == var31.id && var31.objectId == -1) {
									var31.remove();
								} else if (var31.id == var31.objectId && var31.field1119 == var31.orientation && var31.field1123 == var31.field1121) {
									var31.remove();
								}
							}
						}
					}

					class390.method7252();
					++packetWriter.field1349;
					if (packetWriter.field1349 > 750) {
						class67.method2033();
					} else {
						FloorUnderlayDefinition.method3692();
						class360.method6734();
						int[] var32 = Players.Players_indices;

						for (var2 = 0; var2 < Players.Players_count; ++var2) {
							Player var23 = players[var32[var2]];
							if (var23 != null && var23.overheadTextCyclesRemaining > 0) {
								--var23.overheadTextCyclesRemaining;
								if (var23.overheadTextCyclesRemaining == 0) {
									var23.overheadText = null;
								}
							}
						}

						for (var2 = 0; var2 < npcCount; ++var2) {
							var3 = npcIndices[var2];
							NPC var24 = npcs[var3];
							if (var24 != null && var24.overheadTextCyclesRemaining > 0) {
								--var24.overheadTextCyclesRemaining;
								if (var24.overheadTextCyclesRemaining == 0) {
									var24.overheadText = null;
								}
							}
						}

						++field743;
						if (mouseCrossColor != 0) {
							mouseCrossState = mouseCrossState * 400 + 20;
							if (mouseCrossState * 400 >= 400) {
								mouseCrossColor = 0;
							}
						}

						if (DevicePcmPlayerProvider.field153 != null) {
							++field609;
							if (field609 >= 15) {
								class403.invalidateWidget(DevicePcmPlayerProvider.field153);
								DevicePcmPlayerProvider.field153 = null;
							}
						}

						Widget var33 = class148.mousedOverWidgetIf1;
						Widget var34 = GrandExchangeEvent.field4105;
						class148.mousedOverWidgetIf1 = null;
						GrandExchangeEvent.field4105 = null;
						draggedOnWidget = null;
						field686 = false;
						field683 = false;
						field529 = 0;

						while (class28.isKeyDown() && field529 < 128) {
							if (staffModLevel >= 2 && KeyHandler.KeyHandler_pressedKeys[82] && class142.field1665 == 66) {
								String var35 = ViewportMouse.method4628();
								IgnoreList.client.method446(var35);
							} else if (oculusOrbState != 1 || class229.field2794 <= 0) {
								field749[field529] = class142.field1665;
								field731[field529] = class229.field2794;
								++field529;
							}
						}

						if (Decimator.method1091() && KeyHandler.KeyHandler_pressedKeys[82] && KeyHandler.KeyHandler_pressedKeys[81] && mouseWheelRotation != 0) {
							var3 = class67.localPlayer.plane - mouseWheelRotation;
							if (var3 < 0) {
								var3 = 0;
							} else if (var3 > 3) {
								var3 = 3;
							}

							if (var3 != class67.localPlayer.plane) {
								var4 = class67.localPlayer.pathX[0] + class128.baseX * 64;
								var5 = class67.localPlayer.pathY[0] + WorldMapData_1.baseY * 64;
								var18 = class120.getPacketBufferNode(ClientPacket.field3008, packetWriter.isaacCipher);
								var18.packetBuffer.method7952(var3);
								var18.packetBuffer.writeShort(var5);
								var18.packetBuffer.method7971(0);
								var18.packetBuffer.method7961(var4);
								packetWriter.addNode(var18);
							}

							mouseWheelRotation = 0;
						}

						if (rootInterface != -1) {
							class259.updateRootInterface(rootInterface, 0, 0, class123.canvasWidth, class166.canvasHeight, 0, 0);
						}

						++cycleCntr;

						while (true) {
							Widget var25;
							ScriptEvent var36;
							Widget var37;
							do {
								var36 = (ScriptEvent)field709.removeLast();
								if (var36 == null) {
									while (true) {
										do {
											var36 = (ScriptEvent)field626.removeLast();
											if (var36 == null) {
												while (true) {
													do {
														var36 = (ScriptEvent)scriptEvents.removeLast();
														if (var36 == null) {
															this.menu();
															LoginScreenAnimation.method2379();
															if (clickedWidget != null) {
																this.method1208();
															}

															if (User.dragInventoryWidget != null) {
																class403.invalidateWidget(User.dragInventoryWidget);
																++itemDragDuration;
																if (MouseHandler.MouseHandler_currentButton == 0) {
																	if (field763) {
																		if (User.dragInventoryWidget == SceneTilePaint.hoveredItemContainer && dragItemSlotSource != dragItemSlotDestination) {
																			Widget var38 = User.dragInventoryWidget;
																			byte var29 = 0;
																			if (field565 == 1 && var38.contentType == 206) {
																				var29 = 1;
																			}

																			if (var38.itemIds[dragItemSlotDestination] <= 0) {
																				var29 = 0;
																			}

																			var6 = class97.getWidgetFlags(var38);
																			boolean var30 = (var6 >> 29 & 1) != 0;
																			if (var30) {
																				var7 = dragItemSlotSource;
																				var8 = dragItemSlotDestination;
																				var38.itemIds[var8] = var38.itemIds[var7];
																				var38.itemQuantities[var8] = var38.itemQuantities[var7];
																				var38.itemIds[var7] = -1;
																				var38.itemQuantities[var7] = 0;
																			} else if (var29 == 1) {
																				var7 = dragItemSlotSource;
																				var8 = dragItemSlotDestination;

																				while (var7 != var8) {
																					if (var7 > var8) {
																						var38.swapItems(var7 - 1, var7);
																						--var7;
																					} else if (var7 < var8) {
																						var38.swapItems(var7 + 1, var7);
																						++var7;
																					}
																				}
																			} else {
																				var38.swapItems(dragItemSlotDestination, dragItemSlotSource);
																			}

																			PacketBufferNode var26 = class120.getPacketBufferNode(ClientPacket.field2947, packetWriter.isaacCipher);
																			var26.packetBuffer.method8004(var29);
																			var26.packetBuffer.writeIntME(dragItemSlotSource);
																			var26.packetBuffer.method7916(User.dragInventoryWidget.id);
																			var26.packetBuffer.method7961(dragItemSlotDestination);
																			packetWriter.addNode(var26);
																		}
																	} else if (this.shouldLeftClickOpenMenu()) {
																		this.openMenu(draggedWidgetX, draggedWidgetY);
																	} else if (menuOptionsCount > 0) {
																		NPCComposition.method3663(draggedWidgetX, draggedWidgetY);
																	}

																	field609 = 10;
																	MouseHandler.MouseHandler_lastButton = 0;
																	User.dragInventoryWidget = null;
																} else if (itemDragDuration >= 5 && (MouseHandler.MouseHandler_x > draggedWidgetX + 5 || MouseHandler.MouseHandler_x < draggedWidgetX - 5 || MouseHandler.MouseHandler_y > draggedWidgetY + 5 || MouseHandler.MouseHandler_y < draggedWidgetY - 5)) {
																	field763 = true;
																}
															}

															if (Scene.shouldSendWalk()) {
																var3 = Scene.Scene_selectedX;
																var4 = Scene.Scene_selectedY;
																PacketBufferNode var39 = class120.getPacketBufferNode(ClientPacket.field3033, packetWriter.isaacCipher);
																var39.packetBuffer.writeByte(5);
																var39.packetBuffer.method7962(class128.baseX * 64 + var3);
																var39.packetBuffer.writeShort(WorldMapData_1.baseY * 64 + var4);
																var39.packetBuffer.method7952(KeyHandler.KeyHandler_pressedKeys[82] ? (KeyHandler.KeyHandler_pressedKeys[81] ? 2 : 1) : 0);
																packetWriter.addNode(var39);
																Scene.method4395();
																mouseCrossX = MouseHandler.MouseHandler_lastPressedX;
																mouseCrossY = MouseHandler.MouseHandler_lastPressedY;
																mouseCrossColor = 1;
																mouseCrossState = 0;
																destinationX = var3;
																destinationY = var4;
															}

															if (var33 != class148.mousedOverWidgetIf1) {
																if (var33 != null) {
																	class403.invalidateWidget(var33);
																}

																if (class148.mousedOverWidgetIf1 != null) {
																	class403.invalidateWidget(class148.mousedOverWidgetIf1);
																}
															}

															if (var34 != GrandExchangeEvent.field4105 && field657 == field560) {
																if (var34 != null) {
																	class403.invalidateWidget(var34);
																}

																if (GrandExchangeEvent.field4105 != null) {
																	class403.invalidateWidget(GrandExchangeEvent.field4105);
																}
															}

															if (GrandExchangeEvent.field4105 != null) {
																if (field560 < field657) {
																	++field560;
																	if (field657 == field560) {
																		class403.invalidateWidget(GrandExchangeEvent.field4105);
																	}
																}
															} else if (field560 > 0) {
																--field560;
															}

															FontName.method7596();
															if (field544) {
																Tile.method4128(class402.field4479, class152.field1724, ArchiveDiskActionHandler.field4010);
																class7.method67(class21.field120, field789);
																if (TaskHandler.cameraX == class402.field4479 && class152.field1724 == SecureRandomFuture.cameraY && ArchiveDiskActionHandler.field4010 == ApproximateRouteStrategy.cameraZ && class21.field120 == class163.cameraPitch && field789 == class10.cameraYaw) {
																	field544 = false;
																	isCameraLocked = false;
																	class119.field1479 = 0;
																	MusicPatchNode.field3301 = 0;
																	class123.field1520 = 0;
																	SoundSystem.field327 = 0;
																	class93.field1270 = 0;
																	UserComparator6.field1398 = 0;
																	ObjectSound.field832 = 0;
																	SceneTilePaint.field2638 = 0;
																	UrlRequester.field1355 = 0;
																	Strings.field3978 = 0;
																}
															} else if (isCameraLocked) {
																class119.method2909();
															}

															for (var3 = 0; var3 < 5; ++var3) {
																int var10002 = field759[var3]++;
															}

															LoginType.varcs.tryWrite();
															var3 = ++MouseHandler.MouseHandler_idleCycles - 1;
															var5 = class150.method3287();
															if (var3 > 15000 && var5 > 15000) {
																logoutTimer = 250;
																GraphicsDefaults.method7089(14500);
																var18 = class120.getPacketBufferNode(ClientPacket.field2957, packetWriter.isaacCipher);
																packetWriter.addNode(var18);
															}

															Varps.friendSystem.processFriendUpdates();
															++packetWriter.pendingWrites;
															if (packetWriter.pendingWrites > 50) {
																var18 = class120.getPacketBufferNode(ClientPacket.field2986, packetWriter.isaacCipher);
																packetWriter.addNode(var18);
															}

															try {
																packetWriter.flush();
															} catch (IOException var27) {
																class67.method2033();
															}

															return;
														}

														var37 = var36.widget;
														if (var37.childIndex < 0) {
															break;
														}

														var25 = SpotAnimationDefinition.getWidget(var37.parentId);
													} while(var25 == null || var25.children == null || var37.childIndex >= var25.children.length || var37 != var25.children[var37.childIndex]);

													class348.runScriptEvent(var36);
												}
											}

											var37 = var36.widget;
											if (var37.childIndex < 0) {
												break;
											}

											var25 = SpotAnimationDefinition.getWidget(var37.parentId);
										} while(var25 == null || var25.children == null || var37.childIndex >= var25.children.length || var37 != var25.children[var37.childIndex]);

										class348.runScriptEvent(var36);
									}
								}

								var37 = var36.widget;
								if (var37.childIndex < 0) {
									break;
								}

								var25 = SpotAnimationDefinition.getWidget(var37.parentId);
							} while(var25 == null || var25.children == null || var37.childIndex >= var25.children.length || var37 != var25.children[var37.childIndex]);

							class348.runScriptEvent(var36);
						}
					}
				}
			}
		}
	}

	@ObfuscatedName("gg")
	@ObfuscatedSignature(
		descriptor = "(S)V",
		garbageValue = "128"
	)
	@Export("resizeJS")
	void resizeJS() {
		int var1 = class123.canvasWidth;
		int var2 = class166.canvasHeight;
		if (super.contentWidth < var1) {
			var1 = super.contentWidth;
		}

		if (super.contentHeight < var2) {
			var2 = super.contentHeight;
		}

		if (Player.clientPreferences != null) {
			try {
				class27.method405(IgnoreList.client, "resize", new Object[]{SceneTilePaint.getWindowedMode()});
			} catch (Throwable var4) {
			}
		}

	}

	@ObfuscatedName("gh")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-1587589415"
	)
	@Export("drawLoggedIn")
	final void drawLoggedIn() {
		if (rootInterface != -1) {
			class260.method5339(rootInterface);
		}

		int var1;
		for (var1 = 0; var1 < rootWidgetCount; ++var1) {
			if (field714[var1]) {
				field556[var1] = true;
			}

			field671[var1] = field714[var1];
			field714[var1] = false;
		}

		field713 = cycle;
		viewportX = -1;
		viewportY = -1;
		SceneTilePaint.hoveredItemContainer = null;
		if (rootInterface != -1) {
			rootWidgetCount = 0;
			class193.drawWidgets(rootInterface, 0, 0, class123.canvasWidth, class166.canvasHeight, 0, 0, -1);
		}

		Rasterizer2D.Rasterizer2D_resetClip();
		if (showMouseCross) {
			if (mouseCrossColor == 1) {
				SpotAnimationDefinition.crossSprites[mouseCrossState * 400 / 100].drawTransBgAt(mouseCrossX - 8, mouseCrossY - 8);
			}

			if (mouseCrossColor == 2) {
				SpotAnimationDefinition.crossSprites[mouseCrossState * 400 / 100 + 4].drawTransBgAt(mouseCrossX - 8, mouseCrossY - 8);
			}
		}

		if (!isMenuOpen) {
			if (viewportX != -1) {
				Message.method1165(viewportX, viewportY);
			}
		} else {
			HealthBarUpdate.method2352();
		}

		if (gameDrawingMode == 3) {
			for (var1 = 0; var1 < rootWidgetCount; ++var1) {
				if (field671[var1]) {
					Rasterizer2D.Rasterizer2D_fillRectangleAlpha(rootWidgetXs[var1], rootWidgetYs[var1], rootWidgetWidths[var1], rootWidgetHeights[var1], 16711935, 128);
				} else if (field556[var1]) {
					Rasterizer2D.Rasterizer2D_fillRectangleAlpha(rootWidgetXs[var1], rootWidgetYs[var1], rootWidgetWidths[var1], rootWidgetHeights[var1], 16711680, 128);
				}
			}
		}

		class166.method3494(Tiles.Client_plane, class67.localPlayer.x, class67.localPlayer.y, field743);
		field743 = 0;
	}

	@ObfuscatedName("hb")
	@ObfuscatedSignature(
		descriptor = "(Lcs;II)Z",
		garbageValue = "-433074130"
	)
	boolean method1206(PacketWriter var1, int var2) {
		if (var1.serverPacketLength == 0) {
			class145.friendsChat = null;
		} else {
			if (class145.friendsChat == null) {
				class145.friendsChat = new FriendsChat(Players.loginType, IgnoreList.client);
			}

			class145.friendsChat.method6823(var1.packetBuffer, var2);
		}

		ByteArrayPool.method6699();
		var1.serverPacket = null;
		return true;
	}

	@ObfuscatedName("ho")
	@ObfuscatedSignature(
		descriptor = "(Lcs;S)Z",
		garbageValue = "26433"
	)
	boolean method1207(PacketWriter var1) {
		if (class145.friendsChat != null) {
			class145.friendsChat.method6806(var1.packetBuffer);
		}

		ByteArrayPool.method6699();
		var1.serverPacket = null;
		return true;
	}

	@ObfuscatedName("ig")
	@ObfuscatedSignature(
		descriptor = "(Lcs;B)Z",
		garbageValue = "82"
	)
	final boolean method1447(PacketWriter var1) {
		AbstractSocket var2 = var1.getSocket();
		PacketBuffer var3 = var1.packetBuffer;
		if (var2 == null) {
			return false;
		} else {
			int var21;
			String var22;
			try {
				int var5;
				if (var1.serverPacket == null) {
					if (var1.field1340) {
						if (!var2.isAvailable(1)) {
							return false;
						}

						var2.read(var1.packetBuffer.array, 0, 1);
						var1.field1349 = 0;
						var1.field1340 = false;
					}

					var3.offset = 0;
					if (var3.method7869()) {
						if (!var2.isAvailable(1)) {
							return false;
						}

						var2.read(var1.packetBuffer.array, 1, 1);
						var1.field1349 = 0;
					}

					var1.field1340 = true;
					ServerPacket[] var4 = WorldMapEvent.ServerPacket_values();
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
				var1.field1349 = 0;
				timer.method6702();
				var1.field1345 = var1.field1350;
				var1.field1350 = var1.field1348;
				var1.field1348 = var1.serverPacket;
				Widget var6;
				int var7;
				int var8;
				int var9;
				int var10;
				int var20;
				if (ServerPacket.field3170 == var1.serverPacket) {
					var20 = var3.readInt();
					var5 = var3.readUnsignedShort();
					if (var20 < -70000) {
						var5 += 32768;
					}

					if (var20 >= 0) {
						var6 = SpotAnimationDefinition.getWidget(var20);
					} else {
						var6 = null;
					}

					if (var6 != null) {
						for (var7 = 0; var7 < var6.itemIds.length; ++var7) {
							var6.itemIds[var7] = 0;
							var6.itemQuantities[var7] = 0;
						}
					}

					VarpDefinition.clearItemContainer(var5);
					var7 = var3.readUnsignedShort();

					for (var8 = 0; var8 < var7; ++var8) {
						var9 = var3.method7955();
						if (var9 == 255) {
							var9 = var3.method7973();
						}

						var10 = var3.method7964();
						if (var6 != null && var8 < var6.itemIds.length) {
							var6.itemIds[var8] = var10;
							var6.itemQuantities[var8] = var9;
						}

						class28.itemContainerSetItem(var5, var8, var10 - 1, var9);
					}

					if (var6 != null) {
						class403.invalidateWidget(var6);
					}

					class33.method647();
					changedItemContainers[++field694 - 1 & 31] = var5 & 32767;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field3077 == var1.serverPacket) {
					SoundSystem.method813(class264.field3052);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field3174 == var1.serverPacket) {
					class114.loadRegions(false, var1.packetBuffer);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field3115 == var1.serverPacket) {
					return this.method1206(var1, 2);
				}

				if (ServerPacket.field3120 == var1.serverPacket) {
					SoundSystem.method813(class264.field3046);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field3136 == var1.serverPacket) {
					WorldMapSectionType.field2826 = true;
					class386.updateNpcs(false, var3);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field3119 == var1.serverPacket) {
					var20 = var3.method7964();
					var5 = var3.method8135();
					Varps.Varps_temp[var20] = var5;
					if (Varps.Varps_main[var20] != var5) {
						Varps.Varps_main[var20] = var5;
					}

					class269.changeGameOptions(var20);
					changedVarps[++changedVarpCount - 1 & 31] = var20;
					var1.serverPacket = null;
					return true;
				}

				int var11;
				int var12;
				int var13;
				int var14;
				int var15;
				int var16;
				if (ServerPacket.field3166 == var1.serverPacket) {
					byte var66 = var3.method7970();
					int var18 = var3.method7955();
					var12 = var3.method7965();
					var11 = var3.readShort();
					var21 = var3.method8101();
					var20 = var21 >> 16;
					var5 = var21 >> 8 & 255;
					var7 = var20 + (var21 >> 4 & 7);
					var8 = var5 + (var21 & 7);
					byte var63 = var3.readByte();
					var15 = var3.method7964();
					var13 = var3.method8023() * 4;
					var14 = var3.readUnsignedByte() * 4;
					int var17 = var3.method7955();
					var16 = var3.method7965();
					var9 = var66 + var7;
					var10 = var63 + var8;
					if (var7 >= 0 && var8 >= 0 && var7 < 104 && var8 < 104 && var9 >= 0 && var10 >= 0 && var9 < 104 && var10 < 104 && var12 != 65535) {
						var7 = var7 * 128 + 64;
						var8 = var8 * 128 + 64;
						var9 = var9 * 128 + 64;
						var10 = var10 * 128 + 64;
						Projectile var19 = new Projectile(var12, Tiles.Client_plane, var7, var8, class120.getTileHeight(var7, var8, Tiles.Client_plane) - var13, var15 + cycle, var16 + cycle, var17, var18, var11, var14);
						var19.setDestination(var9, var10, class120.getTileHeight(var9, var10, Tiles.Client_plane) - var14, var15 + cycle);
						projectiles.addFirst(var19);
					}

					var1.serverPacket = null;
					return true;
				}

				String var50;
				if (ServerPacket.field3130 == var1.serverPacket) {
					var50 = var3.readStringCp1252NullTerminated();
					var22 = AbstractFont.escapeBrackets(class123.method2954(Occluder.method4474(var3)));
					class65.addGameMessage(6, var50, var22);
					var1.serverPacket = null;
					return true;
				}

				long var23;
				long var25;
				long var27;
				long var30;
				String var32;
				if (ServerPacket.field3132 == var1.serverPacket) {
					var50 = var3.readStringCp1252NullTerminated();
					var23 = var3.readLong();
					var25 = (long)var3.readUnsignedShort();
					var27 = (long)var3.readMedium();
					PlayerType var80 = (PlayerType)Varps.findEnumerated(class437.PlayerType_values(), var3.readUnsignedByte());
					var30 = var27 + (var25 << 32);
					boolean var69 = false;

					for (var15 = 0; var15 < 100; ++var15) {
						if (var30 == crossWorldMessageIds[var15]) {
							var69 = true;
							break;
						}
					}

					if (var80.isUser && Varps.friendSystem.isIgnored(new Username(var50, Players.loginType))) {
						var69 = true;
					}

					if (!var69 && field617 == 0) {
						crossWorldMessageIds[crossWorldMessageIdsIndex] = var30;
						crossWorldMessageIdsIndex = (crossWorldMessageIdsIndex + 1) % 100;
						var32 = AbstractFont.escapeBrackets(class123.method2954(Occluder.method4474(var3)));
						if (var80.modIcon != -1) {
							class120.addChatMessage(9, SecureRandomFuture.method2108(var80.modIcon) + var50, var32, class241.base37DecodeLong(var23));
						} else {
							class120.addChatMessage(9, var50, var32, class241.base37DecodeLong(var23));
						}
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field3089 == var1.serverPacket) {
					Varps.friendSystem.readUpdate(var3, var1.serverPacketLength);
					field700 = cycleCntr;
					var1.serverPacket = null;
					return true;
				}

				Widget var33;
				if (ServerPacket.field3107 == var1.serverPacket) {
					var20 = var3.method7964();
					var5 = var3.method7974();
					var21 = var3.method7964();
					var7 = var3.method8143();
					var33 = SpotAnimationDefinition.getWidget(var5);
					if (var7 != var33.modelAngleX || var20 != var33.modelAngleY || var21 != var33.modelZoom) {
						var33.modelAngleX = var7;
						var33.modelAngleY = var20;
						var33.modelZoom = var21;
						class403.invalidateWidget(var33);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field3139 == var1.serverPacket) {
					WorldMapID.method5124(var3.readStringCp1252NullTerminated());
					var1.serverPacket = null;
					return true;
				}

				String var64;
				if (ServerPacket.field3149 == var1.serverPacket) {
					byte[] var57 = new byte[var1.serverPacketLength];
					var3.method7871(var57, 0, var57.length);
					Buffer var78 = new Buffer(var57);
					var64 = var78.readStringCp1252NullTerminated();
					CollisionMap.openURL(var64, true, false);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field3163 == var1.serverPacket) {
					tradeChatMode = var3.method8023();
					publicChatMode = var3.method8023();
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field3150 == var1.serverPacket) {
					hintArrowType = var3.readUnsignedByte();
					if (hintArrowType == 1) {
						hintArrowNpcIndex = var3.readUnsignedShort();
					}

					if (hintArrowType >= 2 && hintArrowType <= 6) {
						if (hintArrowType == 2) {
							hintArrowSubX = 4096;
							hintArrowSubY = 64;
						}

						if (hintArrowType == 3) {
							hintArrowSubX = 0;
							hintArrowSubY = 64;
						}

						if (hintArrowType == 4) {
							hintArrowSubX = 8192;
							hintArrowSubY = 64;
						}

						if (hintArrowType == 5) {
							hintArrowSubX = 4096;
							hintArrowSubY = 0;
						}

						if (hintArrowType == 6) {
							hintArrowSubX = 4096;
							hintArrowSubY = 128;
						}

						hintArrowType = 2;
						hintArrowX = var3.readUnsignedShort();
						hintArrowY = var3.readUnsignedShort();
						hintArrowHeight = var3.readUnsignedByte() * 4;
					}

					if (hintArrowType == 10) {
						hintArrowPlayerIndex = var3.readUnsignedShort();
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field3090 == var1.serverPacket) {
					SoundSystem.method813(class264.field3054);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field3175 == var1.serverPacket) {
					var20 = var3.method8143();
					rootInterface = var20;
					this.resizeRoot(false);
					MouseHandler.Widget_resetModelFrames(var20);
					class11.runWidgetOnLoadListener(rootInterface);

					for (var5 = 0; var5 < 100; ++var5) {
						field714[var5] = true;
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field3087 == var1.serverPacket) {
					class392.field4456 = var3.method7954();
					ItemComposition.field2163 = var3.method7955();
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field3133 == var1.serverPacket) {
					for (var20 = 0; var20 < Varps.Varps_main.length; ++var20) {
						if (Varps.Varps_main[var20] != Varps.Varps_temp[var20]) {
							Varps.Varps_main[var20] = Varps.Varps_temp[var20];
							class269.changeGameOptions(var20);
							changedVarps[++changedVarpCount - 1 & 31] = var20;
						}
					}

					var1.serverPacket = null;
					return true;
				}

				GameObject var41;
				byte var79;
				if (ServerPacket.field3131 == var1.serverPacket) {
					var79 = var3.readByte();
					var22 = var3.readStringCp1252NullTerminated();
					long var34 = (long)var3.readUnsignedShort();
					long var36 = (long)var3.readMedium();
					PlayerType var84 = (PlayerType)Varps.findEnumerated(class437.PlayerType_values(), var3.readUnsignedByte());
					long var39 = var36 + (var34 << 32);
					boolean var68 = false;
					var41 = null;
					ClanChannel var89 = var79 >= 0 ? currentClanChannels[var79] : MusicPatchPcmStream.guestClanChannel;
					if (var89 == null) {
						var68 = true;
					} else {
						var15 = 0;

						while (true) {
							if (var15 >= 100) {
								if (var84.isUser && Varps.friendSystem.isIgnored(new Username(var22, Players.loginType))) {
									var68 = true;
								}
								break;
							}

							if (crossWorldMessageIds[var15] == var39) {
								var68 = true;
								break;
							}

							++var15;
						}
					}

					if (!var68) {
						crossWorldMessageIds[crossWorldMessageIdsIndex] = var39;
						crossWorldMessageIdsIndex = (crossWorldMessageIdsIndex + 1) % 100;
						var32 = AbstractFont.escapeBrackets(Occluder.method4474(var3));
						var16 = var79 >= 0 ? 41 : 44;
						if (var84.modIcon != -1) {
							class120.addChatMessage(var16, SecureRandomFuture.method2108(var84.modIcon) + var22, var32, var89.name);
						} else {
							class120.addChatMessage(var16, var22, var32, var89.name);
						}
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field3161 == var1.serverPacket) {
					ItemComposition.field2163 = var3.method7954();
					class392.field4456 = var3.readUnsignedByte();

					while (var3.offset < var1.serverPacketLength) {
						var20 = var3.readUnsignedByte();
						class264 var77 = ItemComposition.method3911()[var20];
						SoundSystem.method813(var77);
					}

					var1.serverPacket = null;
					return true;
				}

				Widget var71;
				if (ServerPacket.field3110 == var1.serverPacket) {
					var20 = var3.method8135();
					var71 = SpotAnimationDefinition.getWidget(var20);

					for (var21 = 0; var21 < var71.itemIds.length; ++var21) {
						var71.itemIds[var21] = -1;
						var71.itemIds[var21] = 0;
					}

					class403.invalidateWidget(var71);
					var1.serverPacket = null;
					return true;
				}

				boolean var52;
				if (ServerPacket.field3121 == var1.serverPacket) {
					var20 = var3.readUShortSmart();
					var52 = var3.readUnsignedByte() == 1;
					var64 = "";
					boolean var61 = false;
					if (var52) {
						var64 = var3.readStringCp1252NullTerminated();
						if (Varps.friendSystem.isIgnored(new Username(var64, Players.loginType))) {
							var61 = true;
						}
					}

					String var82 = var3.readStringCp1252NullTerminated();
					if (!var61) {
						class65.addGameMessage(var20, var64, var82);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field3167 == var1.serverPacket) {
					var20 = var3.readShort();
					var5 = var3.readInt();
					var6 = SpotAnimationDefinition.getWidget(var5);
					if (var20 != var6.sequenceId || var20 == -1) {
						var6.sequenceId = var20;
						var6.modelFrame = 0;
						var6.modelFrameCycle = 0;
						class403.invalidateWidget(var6);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field3104 == var1.serverPacket) {
					class114.loadRegions(true, var1.packetBuffer);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field3088 == var1.serverPacket) {
					var20 = var3.method8143();
					if (var20 == 65535) {
						var20 = -1;
					}

					class9.playSong(var20);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field3112 == var1.serverPacket) {
					var20 = var3.method7965();
					if (var20 == 65535) {
						var20 = -1;
					}

					var5 = var3.method8101();
					class161.method3458(var20, var5);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field3125 == var1.serverPacket) {
					class142.privateChatMode = ChatChannel.method2146(var3.readUnsignedByte());
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field3165 == var1.serverPacket) {
					class386.updateNpcs(false, var3);
					var1.serverPacket = null;
					return true;
				}

				Widget var91;
				if (ServerPacket.field3108 == var1.serverPacket) {
					var20 = var3.readUnsignedShort();
					if (var20 == 65535) {
						var20 = -1;
					}

					var5 = var3.method7973();
					var21 = var3.method8135();
					var91 = SpotAnimationDefinition.getWidget(var5);
					ItemComposition var81;
					if (!var91.isIf3) {
						if (var20 == -1) {
							var91.modelType = 0;
							var1.serverPacket = null;
							return true;
						}

						var81 = UserComparator3.ItemDefinition_get(var20);
						var91.modelType = 4;
						var91.modelId = var20;
						var91.modelAngleX = var81.xan2d;
						var91.modelAngleY = var81.yan2d;
						var91.modelZoom = var81.zoom2d * 100 / var21;
						class403.invalidateWidget(var91);
					} else {
						var91.itemId = var20;
						var91.itemQuantity = var21;
						var81 = UserComparator3.ItemDefinition_get(var20);
						var91.modelAngleX = var81.xan2d;
						var91.modelAngleY = var81.yan2d;
						var91.modelAngleZ = var81.zan2d;
						var91.modelOffsetX = var81.offsetX2d;
						var91.modelOffsetY = var81.offsetY2d;
						var91.modelZoom = var81.zoom2d;
						if (var81.isStackable == 1) {
							var91.itemQuantityMode = 1;
						} else {
							var91.itemQuantityMode = 2;
						}

						if (var91.field3446 > 0) {
							var91.modelZoom = var91.modelZoom * 32 / var91.field3446;
						} else if (var91.rawWidth > 0) {
							var91.modelZoom = var91.modelZoom * 32 / var91.rawWidth;
						}

						class403.invalidateWidget(var91);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field3082 == var1.serverPacket) {
					SecureRandomFuture.updatePlayers(var3, var1.serverPacketLength);
					SpriteMask.method5688();
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field3075 == var1.serverPacket) {
					Varps.friendSystem.method1785();
					field700 = cycleCntr;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field3158 == var1.serverPacket) {
					var20 = var3.readInt();
					var5 = var3.readUnsignedShort();
					if (var20 < -70000) {
						var5 += 32768;
					}

					if (var20 >= 0) {
						var6 = SpotAnimationDefinition.getWidget(var20);
					} else {
						var6 = null;
					}

					for (; var3.offset < var1.serverPacketLength; class28.itemContainerSetItem(var5, var7, var8 - 1, var9)) {
						var7 = var3.readUShortSmart();
						var8 = var3.readUnsignedShort();
						var9 = 0;
						if (var8 != 0) {
							var9 = var3.readUnsignedByte();
							if (var9 == 255) {
								var9 = var3.readInt();
							}
						}

						if (var6 != null && var7 >= 0 && var7 < var6.itemIds.length) {
							var6.itemIds[var7] = var8;
							var6.itemQuantities[var7] = var9;
						}
					}

					if (var6 != null) {
						class403.invalidateWidget(var6);
					}

					class33.method647();
					changedItemContainers[++field694 - 1 & 31] = var5 & 32767;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field3128 == var1.serverPacket) {
					isCameraLocked = false;

					for (var20 = 0; var20 < 5; ++var20) {
						field755[var20] = false;
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field3091 == var1.serverPacket) {
					if (class29.field182 == null) {
						class29.field182 = new class393(class150.HitSplatDefinition_cached);
					}

					class452 var55 = class150.HitSplatDefinition_cached.method7271(var3);
					class29.field182.field4464.vmethod7652(var55.field4796, var55.field4797);
					field590[++field698 - 1 & 31] = var55.field4796;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field3140 == var1.serverPacket) {
					var20 = var3.readUnsignedByte();
					var5 = var3.readUnsignedByte();
					var21 = var3.readUnsignedByte();
					var7 = var3.readUnsignedByte();
					field755[var20] = true;
					field575[var20] = var5;
					field757[var20] = var21;
					field758[var20] = var7;
					field759[var20] = 0;
					var1.serverPacket = null;
					return true;
				}

				boolean var76;
				if (ServerPacket.field3156 == var1.serverPacket) {
					var76 = var3.readUnsignedByte() == 1;
					if (var76) {
						SceneTilePaint.field2649 = Language.method6232() - var3.readLong();
						EnumComposition.grandExchangeEvents = new GrandExchangeEvents(var3, true);
					} else {
						EnumComposition.grandExchangeEvents = null;
					}

					field705 = cycleCntr;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field3118 == var1.serverPacket) {
					field745 = cycleCntr;
					var79 = var3.readByte();
					class146 var75 = new class146(var3);
					ClanChannel var60;
					if (var79 >= 0) {
						var60 = currentClanChannels[var79];
					} else {
						var60 = MusicPatchPcmStream.guestClanChannel;
					}

					var75.method3230(var60);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field3137 == var1.serverPacket) {
					var20 = var3.method7965();
					Player var92;
					if (var20 == localPlayerIndex) {
						var92 = class67.localPlayer;
					} else {
						var92 = players[var20];
					}

					var21 = var3.method7974();
					var5 = var3.readUnsignedShort();
					if (var92 != null) {
						var92.spotAnimation = var5;
						var92.field1145 = var21 >> 16;
						var92.field1147 = (var21 & 65535) + cycle;
						var92.spotAnimationFrame = 0;
						var92.field1176 = 0;
						if (var92.field1147 > cycle) {
							var92.spotAnimationFrame = -1;
						}

						if (var92.spotAnimation == 65535) {
							var92.spotAnimation = -1;
						}
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field3113 == var1.serverPacket) {
					var20 = var3.readUnsignedShort();
					if (var20 == 65535) {
						var20 = -1;
					}

					var5 = var3.method7965();
					if (var5 == 65535) {
						var5 = -1;
					}

					var21 = var3.method7973();
					var7 = var3.method7973();

					for (var8 = var5; var8 <= var20; ++var8) {
						var27 = ((long)var21 << 32) + (long)var8;
						Node var29 = widgetFlags.get(var27);
						if (var29 != null) {
							var29.remove();
						}

						widgetFlags.put(new IntegerNode(var7), var27);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field3154 == var1.serverPacket) {
					UserComparator3.method2766();
					var79 = var3.readByte();
					if (var1.serverPacketLength == 1) {
						if (var79 >= 0) {
							currentClanSettings[var79] = null;
						} else {
							class83.guestClanSettings = null;
						}

						var1.serverPacket = null;
						return true;
					}

					if (var79 >= 0) {
						currentClanSettings[var79] = new ClanSettings(var3);
					} else {
						class83.guestClanSettings = new ClanSettings(var3);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field3138 == var1.serverPacket) {
					SoundSystem.method813(class264.field3056);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field3116 == var1.serverPacket) {
					isCameraLocked = true;
					field544 = false;
					class119.field1479 = var3.readUnsignedByte() * 128;
					MusicPatchNode.field3301 = var3.readUnsignedByte() * 128;
					class123.field1520 = var3.readUnsignedShort();
					SoundSystem.field327 = var3.readUnsignedByte();
					class93.field1270 = var3.readUnsignedByte();
					if (class93.field1270 >= 100) {
						var20 = class119.field1479 * 16384 + 64;
						var5 = MusicPatchNode.field3301 * 16384 + 64;
						var21 = class120.getTileHeight(var20, var5, Tiles.Client_plane) - class123.field1520;
						var7 = var20 - TaskHandler.cameraX;
						var8 = var21 - SecureRandomFuture.cameraY;
						var9 = var5 - ApproximateRouteStrategy.cameraZ;
						var10 = (int)Math.sqrt((double)(var9 * var9 + var7 * var7));
						class163.cameraPitch = (int)(Math.atan2((double)var8, (double)var10) * 325.9490051269531D) & 2047;
						class10.cameraYaw = (int)(Math.atan2((double)var7, (double)var9) * -325.9490051269531D) & 2047;
						if (class163.cameraPitch < 128) {
							class163.cameraPitch = 128;
						}

						if (class163.cameraPitch > 383) {
							class163.cameraPitch = 383;
						}
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field3094 == var1.serverPacket) {
					SoundSystem.method813(class264.field3057);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field3081 == var1.serverPacket) {
					var20 = var3.readInt();
					if (var20 != field754) {
						field754 = var20;
						class434.method7791();
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field3160 == var1.serverPacket) {
					WorldMapSectionType.field2826 = true;
					class386.updateNpcs(true, var3);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field3144 == var1.serverPacket) {
					SoundSystem.method813(class264.field3047);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field3129 == var1.serverPacket) {
					var20 = var3.readUnsignedByte();
					if (var3.readUnsignedByte() == 0) {
						grandExchangeOffers[var20] = new GrandExchangeOffer();
						var3.offset += 18;
					} else {
						--var3.offset;
						grandExchangeOffers[var20] = new GrandExchangeOffer(var3, false);
					}

					field704 = cycleCntr;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field3084 == var1.serverPacket) {
					ApproximateRouteStrategy.logOut();
					var1.serverPacket = null;
					return false;
				}

				if (ServerPacket.field3124 == var1.serverPacket) {
					ItemComposition.field2163 = var3.readUnsignedByte();
					class392.field4456 = var3.method7955();

					for (var20 = class392.field4456; var20 < class392.field4456 + 8; ++var20) {
						for (var5 = ItemComposition.field2163; var5 < ItemComposition.field2163 + 8; ++var5) {
							if (groundItems[Tiles.Client_plane][var20][var5] != null) {
								groundItems[Tiles.Client_plane][var20][var5] = null;
								Friend.updateItemPile(var20, var5);
							}
						}
					}

					for (PendingSpawn var53 = (PendingSpawn)pendingSpawns.last(); var53 != null; var53 = (PendingSpawn)pendingSpawns.previous()) {
						if (var53.x >= class392.field4456 && var53.x < class392.field4456 + 8 && var53.y >= ItemComposition.field2163 && var53.y < ItemComposition.field2163 + 8 && var53.plane == Tiles.Client_plane) {
							var53.hitpoints = 0;
						}
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field3177 == var1.serverPacket) {
					var20 = var3.readInt();
					var5 = var3.method8143();
					var21 = var5 >> 10 & 31;
					var7 = var5 >> 5 & 31;
					var8 = var5 & 31;
					var9 = (var7 << 11) + (var21 << 19) + (var8 << 3);
					Widget var83 = SpotAnimationDefinition.getWidget(var20);
					if (var9 != var83.color) {
						var83.color = var9;
						class403.invalidateWidget(var83);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field3114 == var1.serverPacket) {
					field745 = cycleCntr;
					var79 = var3.readByte();
					if (var1.serverPacketLength == 1) {
						if (var79 >= 0) {
							currentClanChannels[var79] = null;
						} else {
							MusicPatchPcmStream.guestClanChannel = null;
						}

						var1.serverPacket = null;
						return true;
					}

					if (var79 >= 0) {
						currentClanChannels[var79] = new ClanChannel(var3);
					} else {
						MusicPatchPcmStream.guestClanChannel = new ClanChannel(var3);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field3172 == var1.serverPacket) {
					var20 = var3.readInt();
					var5 = var3.readUnsignedShort();
					var21 = var3.readUnsignedShort();
					var91 = SpotAnimationDefinition.getWidget(var20);
					var91.field3451 = var5 + (var21 << 16);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field3102 == var1.serverPacket) {
					var20 = var3.method7967();
					var5 = var3.readInt();
					var21 = var3.method7967();
					var91 = SpotAnimationDefinition.getWidget(var5);
					if (var21 != var91.rawX || var20 != var91.rawY || var91.xAlignment != 0 || var91.yAlignment != 0) {
						var91.rawX = var21;
						var91.rawY = var20;
						var91.xAlignment = 0;
						var91.yAlignment = 0;
						class403.invalidateWidget(var91);
						this.alignWidget(var91);
						if (var91.type == 0) {
							StructComposition.revalidateWidgetScroll(Calendar.Widget_interfaceComponents[var5 >> 16], var91, false);
						}
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field3096 == var1.serverPacket) {
					var50 = var3.readStringCp1252NullTerminated();
					var5 = var3.readUnsignedByte();
					var21 = var3.readUnsignedByte();
					if (var5 >= 1 && var5 <= 8) {
						if (var50.equalsIgnoreCase("null")) {
							var50 = null;
						}

						playerMenuActions[var5 - 1] = var50;
						playerOptionsPriorities[var5 - 1] = var21 == 0;
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field3100 == var1.serverPacket) {
					var3.offset += 28;
					if (var3.checkCrc()) {
						WorldMapData_1.method4979(var3, var3.offset - 28);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field3098 == var1.serverPacket) {
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

				InterfaceParent var88;
				if (ServerPacket.field3146 == var1.serverPacket) {
					var20 = var3.offset + var1.serverPacketLength;
					var5 = var3.readUnsignedShort();
					var21 = var3.readUnsignedShort();
					if (var5 != rootInterface) {
						rootInterface = var5;
						this.resizeRoot(false);
						MouseHandler.Widget_resetModelFrames(rootInterface);
						class11.runWidgetOnLoadListener(rootInterface);

						for (var7 = 0; var7 < 100; ++var7) {
							field714[var7] = true;
						}
					}

					InterfaceParent var38;
					for (; var21-- > 0; var38.field1036 = true) {
						var7 = var3.readInt();
						var8 = var3.readUnsignedShort();
						var9 = var3.readUnsignedByte();
						var38 = (InterfaceParent)interfaceParents.get((long)var7);
						if (var38 != null && var8 != var38.group) {
							class120.closeInterface(var38, true);
							var38 = null;
						}

						if (var38 == null) {
							var38 = class134.method3053(var7, var8, var9);
						}
					}

					for (var88 = (InterfaceParent)interfaceParents.first(); var88 != null; var88 = (InterfaceParent)interfaceParents.next()) {
						if (var88.field1036) {
							var88.field1036 = false;
						} else {
							class120.closeInterface(var88, true);
						}
					}

					widgetFlags = new NodeHashTable(512);

					while (var3.offset < var20) {
						var7 = var3.readInt();
						var8 = var3.readUnsignedShort();
						var9 = var3.readUnsignedShort();
						var10 = var3.readInt();

						for (var11 = var8; var11 <= var9; ++var11) {
							var30 = ((long)var7 << 32) + (long)var11;
							widgetFlags.put(new IntegerNode(var10), var30);
						}
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field3083 == var1.serverPacket) {
					var20 = var3.readUnsignedByte();
					Projectile.method2097(var20);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field3109 == var1.serverPacket) {
					var20 = var3.method8135();
					var5 = var3.method7964();
					var6 = SpotAnimationDefinition.getWidget(var20);
					if (var6.modelType != 2 || var5 != var6.modelId) {
						var6.modelType = 2;
						var6.modelId = var5;
						class403.invalidateWidget(var6);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field3134 == var1.serverPacket) {
					if (rootInterface != -1) {
						class18.runIntfCloseListeners(rootInterface, 0);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field3159 == var1.serverPacket) {
					for (var20 = 0; var20 < VarpDefinition.field1841; ++var20) {
						VarpDefinition var74 = class119.VarpDefinition_get(var20);
						if (var74 != null) {
							Varps.Varps_temp[var20] = 0;
							Varps.Varps_main[var20] = 0;
						}
					}

					class33.method647();
					changedVarpCount += 32;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field3176 == var1.serverPacket) {
					SoundSystem.method813(class264.field3050);
					var1.serverPacket = null;
					return true;
				}

				String var46;
				if (ServerPacket.field3164 == var1.serverPacket) {
					var50 = var3.readStringCp1252NullTerminated();
					var23 = (long)var3.readUnsignedShort();
					var25 = (long)var3.readMedium();
					PlayerType var43 = (PlayerType)Varps.findEnumerated(class437.PlayerType_values(), var3.readUnsignedByte());
					long var44 = (var23 << 32) + var25;
					boolean var65 = false;

					for (var13 = 0; var13 < 100; ++var13) {
						if (crossWorldMessageIds[var13] == var44) {
							var65 = true;
							break;
						}
					}

					if (Varps.friendSystem.isIgnored(new Username(var50, Players.loginType))) {
						var65 = true;
					}

					if (!var65 && field617 == 0) {
						crossWorldMessageIds[crossWorldMessageIdsIndex] = var44;
						crossWorldMessageIdsIndex = (crossWorldMessageIdsIndex + 1) % 100;
						var46 = AbstractFont.escapeBrackets(class123.method2954(Occluder.method4474(var3)));
						byte var67;
						if (var43.isPrivileged) {
							var67 = 7;
						} else {
							var67 = 3;
						}

						if (var43.modIcon != -1) {
							class65.addGameMessage(var67, SecureRandomFuture.method2108(var43.modIcon) + var50, var46);
						} else {
							class65.addGameMessage(var67, var50, var46);
						}
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field3079 == var1.serverPacket) {
					World var51 = new World();
					var51.host = var3.readStringCp1252NullTerminated();
					var51.id = var3.readUnsignedShort();
					var5 = var3.readInt();
					var51.properties = var5;
					Coord.updateGameState(45);
					var2.close();
					var2 = null;
					class221.changeWorld(var51);
					var1.serverPacket = null;
					return false;
				}

				if (ServerPacket.field3099 == var1.serverPacket) {
					var20 = var3.readUnsignedByte();
					DevicePcmPlayerProvider.forceDisconnect(var20);
					var1.serverPacket = null;
					return false;
				}

				if (ServerPacket.field3145 == var1.serverPacket) {
					SoundSystem.method813(class264.field3053);
					var1.serverPacket = null;
					return true;
				}

				NPC var90;
				if (ServerPacket.field3169 == var1.serverPacket) {
					var5 = var3.method7965();
					var21 = var3.method8023();
					var20 = var3.method7965();
					if (var5 == 65535) {
						var5 = -1;
					}

					var90 = npcs[var20];
					if (var90 != null) {
						if (var5 == var90.sequence && var5 != -1) {
							var8 = class4.SequenceDefinition_get(var5).field2219;
							if (var8 == 1) {
								var90.sequenceFrame = 0;
								var90.sequenceFrameCycle = 0;
								var90.sequenceDelay = var21;
								var90.field1173 = 0;
							} else if (var8 == 2) {
								var90.field1173 = 0;
							}
						} else if (var5 == -1 || var90.sequence == -1 || class4.SequenceDefinition_get(var5).field2212 >= class4.SequenceDefinition_get(var90.sequence).field2212) {
							var90.sequence = var5;
							var90.sequenceFrame = 0;
							var90.sequenceFrameCycle = 0;
							var90.sequenceDelay = var21;
							var90.field1173 = 0;
							var90.field1202 = var90.pathLength;
						}
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field3072 == var1.serverPacket) {
					UserComparator3.method2766();
					var79 = var3.readByte();
					class132 var73 = new class132(var3);
					ClanSettings var59;
					if (var79 >= 0) {
						var59 = currentClanSettings[var79];
					} else {
						var59 = class83.guestClanSettings;
					}

					var73.method3028(var59);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field3152 == var1.serverPacket) {
					var79 = var3.readByte();
					var23 = (long)var3.readUnsignedShort();
					var25 = (long)var3.readMedium();
					var27 = var25 + (var23 << 32);
					boolean var62 = false;
					ClanChannel var93 = var79 >= 0 ? currentClanChannels[var79] : MusicPatchPcmStream.guestClanChannel;
					if (var93 == null) {
						var62 = true;
					} else {
						for (var13 = 0; var13 < 100; ++var13) {
							if (var27 == crossWorldMessageIds[var13]) {
								var62 = true;
								break;
							}
						}
					}

					if (!var62) {
						crossWorldMessageIds[crossWorldMessageIdsIndex] = var27;
						crossWorldMessageIdsIndex = (crossWorldMessageIdsIndex + 1) % 100;
						var46 = Occluder.method4474(var3);
						var14 = var79 >= 0 ? 43 : 46;
						class120.addChatMessage(var14, "", var46, var93.name);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field3143 == var1.serverPacket) {
					Varps.friendSystem.ignoreList.read(var3, var1.serverPacketLength);
					class364.FriendSystem_invalidateIgnoreds();
					field700 = cycleCntr;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field3155 == var1.serverPacket) {
					class29.field182 = null;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field3093 == var1.serverPacket) {
					return this.method1206(var1, 1);
				}

				if (ServerPacket.field3162 == var1.serverPacket) {
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

				if (ServerPacket.field3117 == var1.serverPacket) {
					var50 = var3.readStringCp1252NullTerminated();
					Object[] var72 = new Object[var50.length() + 1];

					for (var21 = var50.length() - 1; var21 >= 0; --var21) {
						if (var50.charAt(var21) == 's') {
							var72[var21 + 1] = var3.readStringCp1252NullTerminated();
						} else {
							var72[var21 + 1] = new Integer(var3.readInt());
						}
					}

					var72[0] = new Integer(var3.readInt());
					ScriptEvent var58 = new ScriptEvent();
					var58.args = var72;
					class348.runScriptEvent(var58);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field3085 == var1.serverPacket) {
					var20 = var3.method8143();
					var5 = var3.method7973();
					var21 = var3.method7955();
					var88 = (InterfaceParent)interfaceParents.get((long)var5);
					if (var88 != null) {
						class120.closeInterface(var88, var20 != var88.group);
					}

					class134.method3053(var5, var20, var21);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field3103 == var1.serverPacket) {
					class33.method647();
					var20 = var3.method8135();
					var5 = var3.method7955();
					var21 = var3.method7955();
					experience[var5] = var20;
					currentLevels[var5] = var21;
					levels[var5] = 1;

					for (var7 = 0; var7 < 98; ++var7) {
						if (var20 >= Skills.Skills_experienceTable[var7]) {
							levels[var5] = var7 + 2;
						}
					}

					changedSkills[++changedSkillsCount - 1 & 31] = var5;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field3078 == var1.serverPacket) {
					isCameraLocked = true;
					field544 = false;
					SceneTilePaint.field2638 = var3.readUnsignedByte() * 16384;
					UrlRequester.field1355 = var3.readUnsignedByte() * 128;
					Strings.field3978 = var3.readUnsignedShort();
					ObjectSound.field832 = var3.readUnsignedByte();
					UserComparator6.field1398 = var3.readUnsignedByte();
					if (UserComparator6.field1398 >= 100) {
						TaskHandler.cameraX = SceneTilePaint.field2638 * 128 + 64;
						ApproximateRouteStrategy.cameraZ = UrlRequester.field1355 * 16384 + 64;
						SecureRandomFuture.cameraY = class120.getTileHeight(TaskHandler.cameraX, ApproximateRouteStrategy.cameraZ, Tiles.Client_plane) - Strings.field3978;
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field3123 == var1.serverPacket) {
					return this.method1207(var1);
				}

				if (ServerPacket.field3151 == var1.serverPacket) {
					class386.updateNpcs(true, var3);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field3168 == var1.serverPacket) {
					class33.method647();
					runEnergy = var3.readUnsignedByte();
					field706 = cycleCntr;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field3126 == var1.serverPacket) {
					var20 = var3.readUnsignedShort();
					var5 = var3.readUnsignedByte();
					var21 = var3.readUnsignedShort();
					class67.queueSoundEffect(var20, var5, var21);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field3095 == var1.serverPacket) {
					var20 = var3.readInt();
					var71 = SpotAnimationDefinition.getWidget(var20);
					var71.modelType = 3;
					var71.modelId = class67.localPlayer.appearance.getChatHeadId();
					class403.invalidateWidget(var71);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field3173 == var1.serverPacket) {
					SoundSystem.method813(class264.field3049);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field3127 == var1.serverPacket && isCameraLocked) {
					field544 = true;
					ObjectSound.field832 = var3.readUnsignedByte();
					UserComparator6.field1398 = var3.readUnsignedByte();
					SoundSystem.field327 = var3.readUnsignedByte();
					class93.field1270 = var3.readUnsignedByte();

					for (var20 = 0; var20 < 5; ++var20) {
						field755[var20] = false;
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field3074 == var1.serverPacket) {
					rebootTimer = var3.readUnsignedShort() * 30;
					field706 = cycleCntr;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field3135 == var1.serverPacket) {
					var21 = var3.method7964();
					var20 = var3.method7965();
					var90 = npcs[var20];
					var5 = var3.method7973();
					if (var90 != null) {
						var90.spotAnimation = var21;
						var90.field1145 = var5 >> 16;
						var90.field1147 = (var5 & 65535) + cycle;
						var90.spotAnimationFrame = 0;
						var90.field1176 = 0;
						if (var90.field1147 > cycle) {
							var90.spotAnimationFrame = -1;
						}

						if (var90.spotAnimation == 65535) {
							var90.spotAnimation = -1;
						}
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field3142 == var1.serverPacket) {
					var20 = var3.method7964();
					class33.method639(var20);
					changedItemContainers[++field694 - 1 & 31] = var20 & 32767;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field3092 == var1.serverPacket) {
					var76 = var3.readBoolean();
					if (var76) {
						if (Varcs.field1323 == null) {
							Varcs.field1323 = new class327();
						}
					} else {
						Varcs.field1323 = null;
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field3106 == var1.serverPacket) {
					var11 = var3.readUnsignedShort();
					var9 = var3.method7964();
					var21 = var3.method8101();
					var20 = var21 >> 16;
					var5 = var21 >> 8 & 255;
					var7 = var20 + (var21 >> 4 & 7);
					var8 = var5 + (var21 & 7);
					var10 = var3.method8023();
					if (var7 >= 0 && var8 >= 0 && var7 < 104 && var8 < 104) {
						var7 = var7 * 128 + 64;
						var8 = var8 * 128 + 64;
						GraphicsObject var47 = new GraphicsObject(var9, Tiles.Client_plane, var7, var8, class120.getTileHeight(var7, var8, Tiles.Client_plane) - var10, var11, cycle);
						graphicsObjects.addFirst(var47);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field3086 == var1.serverPacket) {
					var20 = var3.method7973();
					var5 = var3.method8143();
					var6 = SpotAnimationDefinition.getWidget(var20);
					if (var6.modelType != 1 || var5 != var6.modelId) {
						var6.modelType = 1;
						var6.modelId = var5;
						class403.invalidateWidget(var6);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field3101 == var1.serverPacket) {
					SoundSystem.method813(class264.field3055);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field3111 == var1.serverPacket) {
					class33.method647();
					weight = var3.readShort();
					field706 = cycleCntr;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field3141 == var1.serverPacket) {
					SoundSystem.method813(class264.field3051);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field3105 == var1.serverPacket) {
					minimapState = var3.readUnsignedByte();
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field3076 == var1.serverPacket) {
					ServerPacket.readReflectionCheck(var3, var1.serverPacketLength);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field3171 == var1.serverPacket) {
					var21 = var3.method8101();
					var20 = var21 >> 16;
					var5 = var21 >> 8 & 255;
					var7 = var20 + (var21 >> 4 & 7);
					var8 = var5 + (var21 & 7);
					var13 = var3.method8143();
					var9 = var3.method8023();
					var10 = var9 >> 2;
					var11 = var9 & 3;
					var12 = field564[var10];
					if (var7 >= 0 && var8 >= 0 && var7 < 103 && var8 < 103) {
						if (var12 == 0) {
							BoundaryObject var87 = MusicPatchNode.scene.method4281(Tiles.Client_plane, var7, var8);
							if (var87 != null) {
								var15 = class156.Entity_unpackID(var87.tag);
								if (var10 == 2) {
									var87.renderable1 = new DynamicObject(var15, 2, var11 + 4, Tiles.Client_plane, var7, var8, var13, false, var87.renderable1);
									var87.renderable2 = new DynamicObject(var15, 2, var11 + 1 & 3, Tiles.Client_plane, var7, var8, var13, false, var87.renderable2);
								} else {
									var87.renderable1 = new DynamicObject(var15, var10, var11, Tiles.Client_plane, var7, var8, var13, false, var87.renderable1);
								}
							}
						} else if (var12 == 1) {
							WallDecoration var86 = MusicPatchNode.scene.method4282(Tiles.Client_plane, var7, var8);
							if (var86 != null) {
								var15 = class156.Entity_unpackID(var86.tag);
								if (var10 != 4 && var10 != 5) {
									if (var10 == 6) {
										var86.renderable1 = new DynamicObject(var15, 4, var11 + 4, Tiles.Client_plane, var7, var8, var13, false, var86.renderable1);
									} else if (var10 == 7) {
										var86.renderable1 = new DynamicObject(var15, 4, (var11 + 2 & 3) + 4, Tiles.Client_plane, var7, var8, var13, false, var86.renderable1);
									} else if (var10 == 8) {
										var86.renderable1 = new DynamicObject(var15, 4, var11 + 4, Tiles.Client_plane, var7, var8, var13, false, var86.renderable1);
										var86.renderable2 = new DynamicObject(var15, 4, (var11 + 2 & 3) + 4, Tiles.Client_plane, var7, var8, var13, false, var86.renderable2);
									}
								} else {
									var86.renderable1 = new DynamicObject(var15, 4, var11, Tiles.Client_plane, var7, var8, var13, false, var86.renderable1);
								}
							}
						} else if (var12 == 2) {
							var41 = MusicPatchNode.scene.getGameObject(Tiles.Client_plane, var7, var8);
							if (var10 == 11) {
								var10 = 10;
							}

							if (var41 != null) {
								var41.renderable = new DynamicObject(class156.Entity_unpackID(var41.tag), var10, var11, Tiles.Client_plane, var7, var8, var13, false, var41.renderable);
							}
						} else if (var12 == 3) {
							FloorDecoration var85 = MusicPatchNode.scene.getFloorDecoration(Tiles.Client_plane, var7, var8);
							if (var85 != null) {
								var85.renderable = new DynamicObject(class156.Entity_unpackID(var85.tag), 22, var11, Tiles.Client_plane, var7, var8, var13, false, var85.renderable);
							}
						}
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field3122 == var1.serverPacket) {
					var20 = var3.method7964();
					byte var54 = var3.method7975();
					Varps.Varps_temp[var20] = var54;
					if (Varps.Varps_main[var20] != var54) {
						Varps.Varps_main[var20] = var54;
					}

					class269.changeGameOptions(var20);
					changedVarps[++changedVarpCount - 1 & 31] = var20;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field3097 == var1.serverPacket) {
					var20 = var3.readInt();
					InterfaceParent var70 = (InterfaceParent)interfaceParents.get((long)var20);
					if (var70 != null) {
						class120.closeInterface(var70, true);
					}

					if (meslayerContinueWidget != null) {
						class403.invalidateWidget(meslayerContinueWidget);
						meslayerContinueWidget = null;
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field3153 == var1.serverPacket) {
					class29.field182 = new class393(class150.HitSplatDefinition_cached);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field3071 == var1.serverPacket) {
					var20 = var3.method7973();
					var5 = var3.method8135();
					InterfaceParent var56 = (InterfaceParent)interfaceParents.get((long)var20);
					var88 = (InterfaceParent)interfaceParents.get((long)var5);
					if (var88 != null) {
						class120.closeInterface(var88, var56 == null || var56.group != var88.group);
					}

					if (var56 != null) {
						var56.remove();
						interfaceParents.put(var56, (long)var5);
					}

					var33 = SpotAnimationDefinition.getWidget(var20);
					if (var33 != null) {
						class403.invalidateWidget(var33);
					}

					var33 = SpotAnimationDefinition.getWidget(var5);
					if (var33 != null) {
						class403.invalidateWidget(var33);
						StructComposition.revalidateWidgetScroll(Calendar.Widget_interfaceComponents[var33.id >>> 16], var33, true);
					}

					if (rootInterface != -1) {
						class18.runIntfCloseListeners(rootInterface, 1);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field3080 == var1.serverPacket) {
					var20 = var3.method7964();
					var5 = var3.method8135();
					var6 = SpotAnimationDefinition.getWidget(var5);
					if (var6 != null && var6.type == 0) {
						if (var20 > var6.scrollHeight - var6.height) {
							var20 = var6.scrollHeight - var6.height;
						}

						if (var20 < 0) {
							var20 = 0;
						}

						if (var20 != var6.scrollY) {
							var6.scrollY = var20;
							class403.invalidateWidget(var6);
						}
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field3157 == var1.serverPacket) {
					var20 = var3.readInt();
					var52 = var3.readUnsignedByte() == 1;
					var6 = SpotAnimationDefinition.getWidget(var20);
					if (var52 != var6.isHidden) {
						var6.isHidden = var52;
						class403.invalidateWidget(var6);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field3147 == var1.serverPacket) {
					var20 = var3.readInt();
					var5 = var3.readInt();
					var21 = DynamicObject.getGcDuration();
					PacketBufferNode var42 = class120.getPacketBufferNode(ClientPacket.field3022, packetWriter.isaacCipher);
					var42.packetBuffer.writeInt(var20);
					var42.packetBuffer.writeInt(var5);
					var42.packetBuffer.writeByte(GameEngine.fps);
					var42.packetBuffer.method8004(var21);
					packetWriter.addNode(var42);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field3073 == var1.serverPacket) {
					var20 = var3.readInt();
					var22 = var3.readStringCp1252NullTerminated();
					var6 = SpotAnimationDefinition.getWidget(var20);
					if (!var22.equals(var6.text)) {
						var6.text = var22;
						class403.invalidateWidget(var6);
					}

					var1.serverPacket = null;
					return true;
				}

				Clock.RunException_sendStackTrace("" + (var1.serverPacket != null ? var1.serverPacket.id : -1) + "," + (var1.field1350 != null ? var1.field1350.id : -1) + "," + (var1.field1345 != null ? var1.field1345.id : -1) + "," + var1.serverPacketLength, (Throwable)null);
				ApproximateRouteStrategy.logOut();
			} catch (IOException var48) {
				class67.method2033();
			} catch (Exception var49) {
				var22 = "" + (var1.serverPacket != null ? var1.serverPacket.id : -1) + "," + (var1.field1350 != null ? var1.field1350.id : -1) + "," + (var1.field1345 != null ? var1.field1345.id : -1) + "," + var1.serverPacketLength + "," + (class67.localPlayer.pathX[0] + class128.baseX * 64) + "," + (class67.localPlayer.pathY[0] + WorldMapData_1.baseY * 64) + ",";

				for (var21 = 0; var21 < var1.serverPacketLength && var21 < 50; ++var21) {
					var22 = var22 + var3.array[var21] + ",";
				}

				Clock.RunException_sendStackTrace(var22, var49);
				ApproximateRouteStrategy.logOut();
			}

			return true;
		}
	}

	@ObfuscatedName("iu")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "279726113"
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
					String var18 = menuTargets[var2];
					menuTargets[var2] = menuTargets[var2 + 1];
					menuTargets[var2 + 1] = var18;
					String var19 = menuActions[var2];
					menuActions[var2] = menuActions[var2 + 1];
					menuActions[var2 + 1] = var19;
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
					boolean var15 = menuShiftClick[var2];
					menuShiftClick[var2] = menuShiftClick[var2 + 1];
					menuShiftClick[var2 + 1] = var15;
					var1 = false;
				}
			}
		}

		if (User.dragInventoryWidget == null) {
			if (clickedWidget == null) {
				int var4;
				label260: {
					int var20 = MouseHandler.MouseHandler_lastButton;
					int var3;
					int var8;
					int var21;
					int var22;
					if (isMenuOpen) {
						if (var20 != 1 && (Renderable.mouseCam || var20 != 4)) {
							var2 = MouseHandler.MouseHandler_x;
							var3 = MouseHandler.MouseHandler_y;
							if (var2 < BufferedSource.menuX - 10 || var2 > MusicPatchNode.menuWidth + BufferedSource.menuX + 10 || var3 < class115.menuY - 10 || var3 > class115.menuY + GrandExchangeEvents.menuHeight + 10) {
								isMenuOpen = false;
								class9.method89(BufferedSource.menuX, class115.menuY, MusicPatchNode.menuWidth, GrandExchangeEvents.menuHeight);
							}
						}

						if (var20 == 1 || !Renderable.mouseCam && var20 == 4) {
							var2 = BufferedSource.menuX;
							var3 = class115.menuY;
							var4 = MusicPatchNode.menuWidth;
							var5 = MouseHandler.MouseHandler_lastPressedX;
							var22 = MouseHandler.MouseHandler_lastPressedY;
							var21 = -1;

							int var17;
							for (var8 = 0; var8 < menuOptionsCount; ++var8) {
								var17 = var3 + (menuOptionsCount - 1 - var8) * 15 + 31;
								if (var5 > var2 && var5 < var4 + var2 && var22 > var17 - 13 && var22 < var17 + 3) {
									var21 = var8;
								}
							}

							if (var21 != -1 && var21 >= 0) {
								var8 = menuArguments1[var21];
								var17 = menuArguments2[var21];
								int var10 = menuOpcodes[var21];
								int var11 = menuIdentifiers[var21];
								int var12 = menuItemIds[var21];
								String var13 = menuActions[var21];
								String var14 = menuTargets[var21];
								class17.menuAction(var8, var17, var10, var11, var12, var13, var14, MouseHandler.MouseHandler_lastPressedX, MouseHandler.MouseHandler_lastPressedY);
							}

							isMenuOpen = false;
							class9.method89(BufferedSource.menuX, class115.menuY, MusicPatchNode.menuWidth, GrandExchangeEvents.menuHeight);
						}
					} else {
						var2 = class156.method3411();
						if ((var20 == 1 || !Renderable.mouseCam && var20 == 4) && var2 >= 0) {
							var3 = menuOpcodes[var2];
							if (var3 == 39 || var3 == 40 || var3 == 41 || var3 == 42 || var3 == 43 || var3 == 33 || var3 == 34 || var3 == 35 || var3 == 36 || var3 == 37 || var3 == 38 || var3 == 1005) {
								var4 = menuArguments1[var2];
								var5 = menuArguments2[var2];
								Widget var6 = SpotAnimationDefinition.getWidget(var5);
								if (class328.method6220(class97.getWidgetFlags(var6))) {
									break label260;
								}

								var8 = class97.getWidgetFlags(var6);
								boolean var7 = (var8 >> 29 & 1) != 0;
								if (var7) {
									break label260;
								}
							}
						}

						if ((var20 == 1 || !Renderable.mouseCam && var20 == 4) && this.shouldLeftClickOpenMenu()) {
							var20 = 2;
						}

						if ((var20 == 1 || !Renderable.mouseCam && var20 == 4) && menuOptionsCount > 0 && var2 >= 0) {
							var3 = menuArguments1[var2];
							var4 = menuArguments2[var2];
							var5 = menuOpcodes[var2];
							var22 = menuIdentifiers[var2];
							var21 = menuItemIds[var2];
							String var16 = menuActions[var2];
							String var9 = menuTargets[var2];
							class17.menuAction(var3, var4, var5, var22, var21, var16, var9, MouseHandler.MouseHandler_lastPressedX, MouseHandler.MouseHandler_lastPressedY);
						}

						if (var20 == 2 && menuOptionsCount > 0) {
							this.openMenu(MouseHandler.MouseHandler_lastPressedX, MouseHandler.MouseHandler_lastPressedY);
						}
					}

					return;
				}

				if (User.dragInventoryWidget != null && !field763 && menuOptionsCount > 0 && !this.shouldLeftClickOpenMenu()) {
					NPCComposition.method3663(draggedWidgetX, draggedWidgetY);
				}

				field763 = false;
				itemDragDuration = 0;
				if (User.dragInventoryWidget != null) {
					class403.invalidateWidget(User.dragInventoryWidget);
				}

				User.dragInventoryWidget = SpotAnimationDefinition.getWidget(var5);
				dragItemSlotSource = var4;
				draggedWidgetX = MouseHandler.MouseHandler_lastPressedX;
				draggedWidgetY = MouseHandler.MouseHandler_lastPressedY;
				if (var2 >= 0) {
					class146.tempMenuAction = new MenuAction();
					class146.tempMenuAction.param0 = menuArguments1[var2];
					class146.tempMenuAction.param1 = menuArguments2[var2];
					class146.tempMenuAction.opcode = menuOpcodes[var2];
					class146.tempMenuAction.identifier = menuIdentifiers[var2];
					class146.tempMenuAction.itemId = menuItemIds[var2];
					class146.tempMenuAction.action = menuActions[var2];
					class146.tempMenuAction.target = menuTargets[var2];
				}

				class403.invalidateWidget(User.dragInventoryWidget);
			}
		}
	}

	@ObfuscatedName("ix")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "-910299550"
	)
	@Export("shouldLeftClickOpenMenu")
	final boolean shouldLeftClickOpenMenu() {
		int var1 = class156.method3411();
		return (leftClickOpensMenu && menuOptionsCount > 2 || class1.method15(var1)) && !menuShiftClick[var1];
	}

	@ObfuscatedName("it")
	@ObfuscatedSignature(
		descriptor = "(III)V",
		garbageValue = "831466911"
	)
	@Export("openMenu")
	final void openMenu(int var1, int var2) {
		int var3 = class29.fontBold12.stringWidth("Choose Option");

		int var4;
		int var5;
		for (var4 = 0; var4 < menuOptionsCount; ++var4) {
			var5 = class29.fontBold12.stringWidth(DynamicObject.method2135(var4));
			if (var5 > var3) {
				var3 = var5;
			}
		}

		var3 += 8;
		var4 = menuOptionsCount * 15 + 22;
		var5 = var1 - var3 / 2;
		if (var3 + var5 > class123.canvasWidth) {
			var5 = class123.canvasWidth - var3;
		}

		if (var5 < 0) {
			var5 = 0;
		}

		int var6 = var2;
		if (var2 + var4 > class166.canvasHeight) {
			var6 = class166.canvasHeight - var4;
		}

		if (var6 < 0) {
			var6 = 0;
		}

		BufferedSource.menuX = var5;
		class115.menuY = var6;
		MusicPatchNode.menuWidth = var3;
		GrandExchangeEvents.menuHeight = menuOptionsCount * 15 + 22;
		var1 -= viewportOffsetX;
		var2 -= viewportOffsetY;
		MusicPatchNode.scene.menuOpen(Tiles.Client_plane, var1, var2, false);
		isMenuOpen = true;
	}

	@ObfuscatedName("jo")
	@ObfuscatedSignature(
		descriptor = "(ZI)V",
		garbageValue = "-1858917735"
	)
	@Export("resizeRoot")
	final void resizeRoot(boolean var1) {
		int var2 = rootInterface;
		int var3 = class123.canvasWidth;
		int var4 = class166.canvasHeight;
		if (FloorOverlayDefinition.loadInterface(var2)) {
			StructComposition.resizeInterface(Calendar.Widget_interfaceComponents[var2], -1, var3, var4, var1);
		}

	}

	@ObfuscatedName("jx")
	@ObfuscatedSignature(
		descriptor = "(Lkw;I)V",
		garbageValue = "903202346"
	)
	@Export("alignWidget")
	void alignWidget(Widget var1) {
		Widget var2 = var1.parentId == -1 ? null : SpotAnimationDefinition.getWidget(var1.parentId);
		int var3;
		int var4;
		if (var2 == null) {
			var3 = class123.canvasWidth;
			var4 = class166.canvasHeight;
		} else {
			var3 = var2.width;
			var4 = var2.height;
		}

		class93.alignWidgetSize(var1, var3, var4, false);
		HealthBarDefinition.alignWidgetPosition(var1, var3, var4);
	}

	@ObfuscatedName("kh")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "-125"
	)
	final void method1208() {
		class403.invalidateWidget(clickedWidget);
		++class259.widgetDragDuration;
		if (field686 && field683) {
			int var1 = MouseHandler.MouseHandler_x;
			int var2 = MouseHandler.MouseHandler_y;
			var1 -= widgetClickX;
			var2 -= widgetClickY;
			if (var1 < field783) {
				var1 = field783;
			}

			if (var1 + clickedWidget.width > field783 + clickedWidgetParent.width) {
				var1 = field783 + clickedWidgetParent.width - clickedWidget.width;
			}

			if (var2 < field744) {
				var2 = field744;
			}

			if (var2 + clickedWidget.height > field744 + clickedWidgetParent.height) {
				var2 = field744 + clickedWidgetParent.height - clickedWidget.height;
			}

			int var3 = var1 - field687;
			int var4 = var2 - field688;
			int var5 = clickedWidget.dragZoneSize;
			if (class259.widgetDragDuration > clickedWidget.dragThreshold && (var3 > var5 || var3 < -var5 || var4 > var5 || var4 < -var5)) {
				isDraggingWidget = true;
			}

			int var6 = var1 - field783 + clickedWidgetParent.scrollX;
			int var7 = var2 - field744 + clickedWidgetParent.scrollY;
			ScriptEvent var8;
			if (clickedWidget.onDrag != null && isDraggingWidget) {
				var8 = new ScriptEvent();
				var8.widget = clickedWidget;
				var8.mouseX = var6;
				var8.mouseY = var7;
				var8.args = clickedWidget.onDrag;
				class348.runScriptEvent(var8);
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
						class348.runScriptEvent(var8);
					}

					if (draggedOnWidget != null && HitSplatDefinition.method3782(clickedWidget) != null) {
						PacketBufferNode var9 = class120.getPacketBufferNode(ClientPacket.field2950, packetWriter.isaacCipher);
						var9.packetBuffer.writeIntME(clickedWidget.childIndex);
						var9.packetBuffer.method7961(draggedOnWidget.itemId);
						var9.packetBuffer.writeIntME(clickedWidget.itemId);
						var9.packetBuffer.method7971(draggedOnWidget.id);
						var9.packetBuffer.method7961(draggedOnWidget.childIndex);
						var9.packetBuffer.method7971(clickedWidget.id);
						packetWriter.addNode(var9);
					}
				} else if (this.shouldLeftClickOpenMenu()) {
					this.openMenu(widgetClickX + field687, field688 + widgetClickY);
				} else if (menuOptionsCount > 0) {
					NPCComposition.method3663(field687 + widgetClickX, field688 + widgetClickY);
				}

				clickedWidget = null;
			}

		} else {
			if (class259.widgetDragDuration > 1) {
				if (!isDraggingWidget && menuOptionsCount > 0) {
					NPCComposition.method3663(field687 + widgetClickX, widgetClickY + field688);
				}

				clickedWidget = null;
			}

		}
	}

	@ObfuscatedName("ml")
	@ObfuscatedSignature(
		descriptor = "(B)Lqo;",
		garbageValue = "101"
	)
	@Export("username")
	public Username username() {
		return class67.localPlayer != null ? class67.localPlayer.username : null;
	}

	public void setOtlTokenRequester(com.jagex.oldscape.pub.OtlTokenRequester var1) {
		if (var1 != null) {
			this.field533 = var1;
			class139.method3101(10);
		}
	}

	@ObfuscatedSignature(
		descriptor = "(Lcom/jagex/oldscape/pub/RefreshAccessTokenRequester;)V"
	)
	@Override
	public void setRefreshTokenRequester(OtlTokenRequester var1) {
		if (var1 != null) {
			this.field719 = var1;
		}
	}

	public boolean isOnLoginScreen() {
		return gameState == 10;
	}

	public long getAccountHash() {
		return this.field710;
	}

	public final void init() {
		try {
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
							Language var13;
							if (var4 >= 0 && var4 < Language.field4143.length) {
								var13 = Language.field4143[var4];
							} else {
								var13 = null;
							}

							class271.clientLanguage = var13;
							break;
						case 7:
							var4 = Integer.parseInt(var2);
							GameBuild[] var5 = class7.method59();
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

							WorldMapSectionType.field2825 = var8;
							break;
						case 8:
							if (var2.equalsIgnoreCase("true")) {
							}
							break;
						case 9:
							AttackOption.field1279 = var2;
							break;
						case 10:
							class153.field1729 = (StudioGame)Varps.findEnumerated(InvDefinition.method3523(), Integer.parseInt(var2));
							if (StudioGame.oldscape == class153.field1729) {
								Players.loginType = LoginType.oldscape;
							} else {
								Players.loginType = LoginType.field4650;
							}
							break;
						case 11:
							Actor.field1164 = var2;
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
							UserComparator10.field1393 = Integer.parseInt(var2);
							break;
						case 15:
							gameBuild = Integer.parseInt(var2);
							break;
						case 17:
							WorldMapSection1.field2879 = var2;
							break;
						case 21:
							field497 = Integer.parseInt(var2);
							break;
						case 25:
							int var3 = var2.indexOf(".");
							if (var3 == -1) {
								Integer.parseInt(var2);
							} else {
								Integer.parseInt(var2.substring(0, var3));
								Integer.parseInt(var2.substring(var3 + 1));
							}
						}
					}
				}

				class97.method2585();
				WorldMapLabelSize.worldHost = this.getCodeBase().getHost();
				String var9 = WorldMapSectionType.field2825.name;
				byte var10 = 0;

				try {
					class33.method641("oldschool", var9, var10, 22);
				} catch (Exception var11) {
					Clock.RunException_sendStackTrace((String)null, var11);
				}

				IgnoreList.client = this;
				class130.clientType = clientType;
				if (field571 == -1) {
					field571 = 0;
				}

				AccessFile.field4662 = System.getenv("JX_ACCESS_TOKEN");
				WorldMapManager.field2773 = System.getenv("JX_REFRESH_TOKEN");
				if (Boolean.parseBoolean(System.getProperty("jagex.disableBouncyCastle"))) {
					this.field535 = true;
				}

				this.startThread(765, 503, 208, 1);
			}
		} catch (RuntimeException var12) {
			throw Bounds.newRunException(var12, "client.init(" + ')');
		}
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "(Ls;B)Ln;",
		garbageValue = "1"
	)
	public static class3 method1723(class6 var0) {
		switch(var0.field14) {
		case 0:
			return new class0();
		default:
			throw new IllegalArgumentException();
		}
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		descriptor = "(ZZI)Lqu;",
		garbageValue = "-2098723867"
	)
	static IndexedSprite method1725(boolean var0, boolean var1) {
		return var0 ? (var1 ? class116.field1428 : UserComparator7.options_buttons_2Sprite) : (var1 ? SoundSystem.field324 : WorldMapDecoration.options_buttons_0Sprite);
	}

	@ObfuscatedName("ha")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-1643217593"
	)
	static void method1726() {
		int var0 = Players.Players_count;
		int[] var1 = Players.Players_indices;

		for (int var2 = 0; var2 < var0; ++var2) {
			if (var1[var2] != combatTargetPlayerIndex && var1[var2] != localPlayerIndex) {
				class67.addPlayerToScene(players[var1[var2]], true);
			}
		}

	}

	@ObfuscatedName("is")
	@ObfuscatedSignature(
		descriptor = "(IIB)Lgb;",
		garbageValue = "117"
	)
	static RouteStrategy method1724(int var0, int var1) {
		field786.approxDestinationX = var0;
		field786.approxDestinationY = var1;
		field786.approxDestinationSizeX = 1;
		field786.approxDestinationSizeY = 1;
		return field786;
	}
}
