import com.jagex.oldscape.pub.OAuthApi;
import com.jagex.oldscape.pub.OtlTokenRequester;
import com.jagex.oldscape.pub.RefreshAccessTokenRequester;
import com.jagex.oldscape.pub.RefreshAccessTokenResponse;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.Socket;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Future;

import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSClient;

@Implements("Client")
@ObfuscatedName("client")
public final class Client extends GameEngine implements Usernamed, OAuthApi {

   boolean shouldProcessClick() {
      return false;
   }

    @ObfuscatedName("vd")
    static int viewportOffsetX;
    @ObfuscatedName("vx")
    static int viewportOffsetY;
   @ObfuscatedName("wn")
   public static int field648;
   @ObfuscatedName("xr")
   @ObfuscatedSignature(
      descriptor = "Lcm;"
   )
   static final ApproximateRouteStrategy field653;
   @ObfuscatedName("xm")
   static int[] field654;
   @ObfuscatedName("xn")
   static int[] field655;
   @ObfuscatedName("vr")
   static int field639;
    @ObfuscatedName("vh")
    @ObfuscatedSignature(
            descriptor = "Lmw;"
    )
    static PlayerComposition playerAppearance;
    @ObfuscatedName("uj")
    static boolean isCameraLocked;
   @ObfuscatedName("vu")
   static int field640;
   @ObfuscatedName("uk")
   static boolean field598;
   @ObfuscatedName("ub")
   static boolean field541;
    @ObfuscatedName("we")
    static ArrayList archiveLoaders;
    @ObfuscatedName("wq")
    @ObfuscatedSignature(
            descriptor = "Lkh;"
    )
    static EvictingDualNodeHashTable Widget_cachedModels;
    @ObfuscatedName("ww")
    @ObfuscatedSignature(
            descriptor = "Lkh;"
    )
    static EvictingDualNodeHashTable Widget_cachedFonts;
    @ObfuscatedName("wy")
    static int archiveLoadersDone;
   @ObfuscatedName("ud")
   static boolean field615;
    @ObfuscatedName("wx")
    @ObfuscatedSignature(
            descriptor = "Lpk;"
    )
    static class398 archive5;
    @ObfuscatedName("vc")
    @ObfuscatedSignature(
            descriptor = "Lrz;"
    )
    static PlatformInfoProvider platformInfoProvider;
    @ObfuscatedName("tg")
    static int[] queuedSoundEffectDelays;
    @ObfuscatedName("ti")
    @ObfuscatedSignature(
            descriptor = "[Lbs;"
    )
    static SoundEffect[] soundEffects;
   @ObfuscatedName("ui")
   @ObfuscatedSignature(
      descriptor = "Lrm;"
   )
   static class455 field535;
    @ObfuscatedName("tb")
    static int[] soundLocations;
    @ObfuscatedName("vs")
    @ObfuscatedSignature(
            descriptor = "[Lnb;"
    )
    static GrandExchangeOffer[] grandExchangeOffers;
   @ObfuscatedName("ue")
   static boolean[] field620;
   @ObfuscatedName("vq")
   static int[] field621;
   @ObfuscatedName("vw")
   static int[] field643;
   @ObfuscatedName("vf")
   static int[] field499;
    @ObfuscatedName("vg")
    static int[] cameraShakeCycle;
   @ObfuscatedName("uc")
   static boolean field614;
   @ObfuscatedName("ws")
   static int field397;
   @ObfuscatedName("vv")
   static short field625;
   @ObfuscatedName("uz")
   @ObfuscatedSignature(
      descriptor = "Lrf;"
   )
   static class454 field604;
   @ObfuscatedName("va")
   static short field626;
   @ObfuscatedName("vo")
   static short field488;
   @ObfuscatedName("ua")
   @ObfuscatedSignature(
      descriptor = "Lrf;"
   )
   static class454 field617;
   @ObfuscatedName("vk")
   static short field562;
   @ObfuscatedName("vn")
   static short field630;
    @ObfuscatedName("vi")
    static int viewportZoom;
   @ObfuscatedName("vm")
   static short field440;
    @ObfuscatedName("vp")
    static int viewportWidth;
    @ObfuscatedName("vy")
    static int viewportHeight;
    @ObfuscatedName("vl")
    static short zoomHeight;
    @ObfuscatedName("ve")
    static short zoomWidth;
    @ObfuscatedName("wg")
    @ObfuscatedSignature(
            descriptor = "Lcf;"
    )
    static GrandExchangeOfferOwnWorldComparator GrandExchangeEvents_worldComparator;
   @ObfuscatedName("wi")
   static int field613;
   @ObfuscatedName("wz")
   static List field649;
    @ObfuscatedName("bh")
    static boolean lockMouseRecorder = true;
    @ObfuscatedName("bw")
    public static int worldId = 1;
    @ObfuscatedName("ce")
    static int worldProperties = 0;
    @ObfuscatedName("cs")
    static int gameBuild = 0;
   @ObfuscatedName("cc")
   @ObfuscatedSignature(
      descriptor = "Lmr;"
   )
   static StudioGame field358;
    @ObfuscatedName("ca")
    public static boolean isMembersWorld = false;
    @ObfuscatedName("cu")
    static boolean isLowDetail = false;
    @ObfuscatedName("cl")
    static int param21 = -1;
    @ObfuscatedName("cg")
    static int clientType = -1;
   @ObfuscatedName("cr")
   static int field363 = -1;
    @ObfuscatedName("cy")
    static boolean onMobile = false;
    @ObfuscatedName("cx")
    static int param25 = 213;
    @ObfuscatedName("dw")
    static int gameState = 0;
    @ObfuscatedName("da")
    static boolean isLoading = true;
    @ObfuscatedName("ep")
    static int cycle = 0;
    @ObfuscatedName("eo")
    static long mouseLastLastPressedTimeMillis = -1L;
    @ObfuscatedName("et")
    static int lastMouseRecordX = -1;
    @ObfuscatedName("ef")
    static int lastMouseRecordY = -1;
    @ObfuscatedName("ez")
    static long lastMouseRecordTime = -1L;
    @ObfuscatedName("ej")
    static boolean hadFocus = true;
    @ObfuscatedName("ea")
    static int rebootTimer = 0;
    @ObfuscatedName("eu")
    static int hintArrowType = 0;
    @ObfuscatedName("es")
    static int hintArrowNpcIndex = 0;
    @ObfuscatedName("eb")
    static int hintArrowPlayerIndex = 0;
    @ObfuscatedName("el")
    static int hintArrowX = 0;
    @ObfuscatedName("en")
    static int hintArrowY = 0;
    @ObfuscatedName("er")
    static int hintArrowHeight = 0;
    @ObfuscatedName("eg")
    static int hintArrowSubX = 0;
    @ObfuscatedName("ed")
    static int hintArrowSubY = 0;
    @ObfuscatedName("em")
    @ObfuscatedSignature(
            descriptor = "Ldj;"
    )
    static AttackOption playerAttackOption;
    @ObfuscatedName("ew")
    @ObfuscatedSignature(
            descriptor = "Ldj;"
    )
    static AttackOption npcAttackOption;
    @ObfuscatedName("ex")
    static boolean renderSelf;
    @ObfuscatedName("fi")
    static int titleLoadingStage;
    @ObfuscatedName("fp")
    static int js5ConnectState;
    @ObfuscatedName("fo")
    static int js5Cycles;
    @ObfuscatedName("gj")
    static int js5Errors;
    @ObfuscatedName("ge")
    static int loginState;
   @ObfuscatedName("ga")
   static int field391;
   @ObfuscatedName("gt")
   static int field392;
   @ObfuscatedName("gu")
   static int field393;
   @ObfuscatedName("gh")
   @ObfuscatedSignature(
      descriptor = "Lfp;"
   )
   static class135 field394;
   @ObfuscatedName("gy")
   @ObfuscatedSignature(
      descriptor = "Lsr;"
   )
   static class493 field395;
   @ObfuscatedName("hd")
   static final String field405;
    @ObfuscatedName("hb")
    static boolean Login_isUsernameRemembered;
    @ObfuscatedName("hq")
    @ObfuscatedSignature(
            descriptor = "Lcj;"
    )
    static SecureRandomFuture secureRandomFuture;
    @ObfuscatedName("hf")
    static byte[] randomDatData;
    @ObfuscatedName("iu")
    @ObfuscatedSignature(
            descriptor = "[Ldf;"
    )
    static NPC[] npcs;
    @ObfuscatedName("iw")
    static int npcCount;
    @ObfuscatedName("iy")
    static int[] npcIndices;
   @ObfuscatedName("ig")
   static int field416;
   @ObfuscatedName("ih")
   static int[] field417;
    @ObfuscatedName("in")
    @ObfuscatedSignature(
            descriptor = "Leq;"
    )
    public static final PacketWriter packetWriter;
    @ObfuscatedName("ii")
    static int logoutTimer;
    @ObfuscatedName("ik")
    static boolean hadNetworkError;
    @ObfuscatedName("ie")
    @ObfuscatedSignature(
            descriptor = "Lor;"
    )
    static Timer timer;
    @ObfuscatedName("im")
    static HashMap fontsMap;
   @ObfuscatedName("it")
   static String field364;
   @ObfuscatedName("jx")
   static int field427;
   @ObfuscatedName("jo")
   static int field593;
   @ObfuscatedName("jk")
   static int field425;
   @ObfuscatedName("jq")
   static int field426;
   @ObfuscatedName("je")
   static int field489;
    @ObfuscatedName("jr")
    @ObfuscatedSignature(
            descriptor = "[Lif;"
    )
    static CollisionMap[] collisionMaps;
    @ObfuscatedName("jv")
    static boolean isInInstance;
    @ObfuscatedName("jh")
    static int[][][] instanceChunkTemplates;
   @ObfuscatedName("jy")
   static final int[] field431;
   @ObfuscatedName("ja")
   static int field432;
   @ObfuscatedName("kq")
   static int field443;
   @ObfuscatedName("kw")
   static int field451;
   @ObfuscatedName("kk")
   static int field435;
   @ObfuscatedName("kj")
   static int field436;
   @ObfuscatedName("ki")
   static boolean field437;
    @ObfuscatedName("ko")
    static int alternativeScrollbarWidth;
    @ObfuscatedName("kp")
    static int camAngleX;
    @ObfuscatedName("kf")
    static int camAngleY;
    @ObfuscatedName("ks")
    static int camAngleDY;
    @ObfuscatedName("kn")
    static int camAngleDX;
    @ObfuscatedName("kz")
    static int mouseCamClickedX;
    @ObfuscatedName("km")
    static int mouseCamClickedY;
    @ObfuscatedName("lv")
    static int oculusOrbState;
    @ObfuscatedName("lm")
    static int camFollowHeight;
   @ObfuscatedName("li")
   static int field644;
   @ObfuscatedName("lu")
   static int field595;
   @ObfuscatedName("lk")
   static int field398;
    @ObfuscatedName("la")
    static int oculusOrbNormalSpeed;
    @ObfuscatedName("lp")
    static int oculusOrbSlowedSpeed;
   @ObfuscatedName("ly")
   public static int field444;
    @ObfuscatedName("ln")
    static boolean oculusOrbOnLocalPlayer;
    @ObfuscatedName("lt")
    static int packetIndicator;
    @ObfuscatedName("lz")
    static boolean emitPackets;
   @ObfuscatedName("lc")
   static int field456;
    @ObfuscatedName("ld")
    static int overheadTextCount;
    @ObfuscatedName("lq")
    static int overheadTextLimit;
    @ObfuscatedName("lj")
    static int[] overheadTextXs;
    @ObfuscatedName("ll")
    static int[] overheadTextYs;
    @ObfuscatedName("le")
    static int[] overheadTextAscents;
    @ObfuscatedName("lb")
    static int[] overheadTextXOffsets;
    @ObfuscatedName("lx")
    static int[] overheadTextColors;
    @ObfuscatedName("lo")
    static int[] overheadTextEffects;
    @ObfuscatedName("lw")
    static int[] overheadTextCyclesRemaining;
    @ObfuscatedName("lr")
    static String[] overheadText;
    @ObfuscatedName("mt")
    static int[][] tileLastDrawnActor;
    @ObfuscatedName("mw")
    static int viewportDrawCount;
    @ObfuscatedName("mz")
    static int viewportTempX;
    @ObfuscatedName("mu")
    static int viewportTempY;
    @ObfuscatedName("mq")
    static int mouseCrossX;
    @ObfuscatedName("mm")
    static int mouseCrossY;
    @ObfuscatedName("me")
    static int mouseCrossState;
    @ObfuscatedName("mv")
    static int mouseCrossColor;
    @ObfuscatedName("mx")
    static boolean showMouseCross;
   @ObfuscatedName("ma")
   static int field476;
    @ObfuscatedName("mj")
    static boolean showLoadingMessages;
    @ObfuscatedName("mc")
    @ObfuscatedSignature(
            descriptor = "[Ldv;"
    )
    static Player[] players;
    @ObfuscatedName("mg")
    static int localPlayerIndex;
    @ObfuscatedName("mo")
    static int isMembers;
    @ObfuscatedName("mn")
    static long playerUUID;
   @ObfuscatedName("md")
   static boolean field482;
    @ObfuscatedName("mk")
    static int drawPlayerNames;
   @ObfuscatedName("mb")
   static int field484;
   @ObfuscatedName("nz")
   static int[] field485;
    @ObfuscatedName("ns")
    static final int[] playerMenuOpcodes;
    @ObfuscatedName("nd")
    static String[] playerMenuActions;
    @ObfuscatedName("no")
    static boolean[] playerOptionsPriorities;
   @ObfuscatedName("nm")
   static int[] field561;
    @ObfuscatedName("nl")
    static int combatTargetPlayerIndex;
    @ObfuscatedName("nr")
    @ObfuscatedSignature(
            descriptor = "[[[Lnh;"
    )
    static NodeDeque[][][] groundItems;
    @ObfuscatedName("nn")
    @ObfuscatedSignature(
            descriptor = "Lnh;"
    )
    static NodeDeque pendingSpawns;
    @ObfuscatedName("na")
    @ObfuscatedSignature(
            descriptor = "Lnh;"
    )
    static NodeDeque projectiles;
    @ObfuscatedName("np")
    @ObfuscatedSignature(
            descriptor = "Lnh;"
    )
    static NodeDeque graphicsObjects;
    @ObfuscatedName("ng")
    static int[] currentLevels;
    @ObfuscatedName("ny")
    static int[] levels;
    @ObfuscatedName("nu")
    static int[] experience;
    @ObfuscatedName("nb")
    static boolean leftClickOpensMenu;
    @ObfuscatedName("nt")
    static boolean isMenuOpen;
    @ObfuscatedName("ne")
    static int menuOptionsCount;
    @ObfuscatedName("nk")
    static int[] menuArguments1;
    @ObfuscatedName("ni")
    static int[] menuArguments2;
    @ObfuscatedName("nh")
    static int[] menuOpcodes;
    @ObfuscatedName("nq")
    static int[] menuIdentifiers;
    @ObfuscatedName("oi")
    static int[] menuItemIds;
    @ObfuscatedName("og")
    static String[] menuActions;
    @ObfuscatedName("ok")
    static String[] menuTargets;
    @ObfuscatedName("ox")
    static boolean[] menuShiftClick;
    @ObfuscatedName("ov")
    static boolean followerOpsLowPriority;
    @ObfuscatedName("ol")
    static boolean tapToDrop;
    @ObfuscatedName("oz")
    static boolean showMouseOverText;
    @ObfuscatedName("of")
    static int viewportX;
    @ObfuscatedName("oy")
    static int viewportY;
   @ObfuscatedName("oe")
   static int field514;
   @ObfuscatedName("on")
   static int field515;
    @ObfuscatedName("oq")
    static int isItemSelected;
    @ObfuscatedName("om")
    static boolean isSpellSelected;
    @ObfuscatedName("oa")
    static int selectedSpellChildIndex;
    @ObfuscatedName("op")
    static int selectedSpellItemId;
   @ObfuscatedName("oj")
   static String field530;
   @ObfuscatedName("ob")
   static String field522;
    @ObfuscatedName("or")
    static int rootInterface;
    @ObfuscatedName("oc")
    @ObfuscatedSignature(
            descriptor = "Lrc;"
    )
    static NodeHashTable interfaceParents;
   @ObfuscatedName("pc")
   static int field463;
   @ObfuscatedName("pp")
   static int field526;
    @ObfuscatedName("py")
    static int chatEffects;
    @ObfuscatedName("pg")
    @ObfuscatedSignature(
            descriptor = "Lmq;"
    )
    static Widget meslayerContinueWidget;
    @ObfuscatedName("pk")
    static int runEnergy;
    @ObfuscatedName("pj")
    static int weight;
    @ObfuscatedName("pu")
    public static int staffModLevel;
    @ObfuscatedName("pt")
    static int followerIndex;
    @ObfuscatedName("po")
    static boolean playerMod;
    @ObfuscatedName("ps")
    @ObfuscatedSignature(
            descriptor = "Lmq;"
    )
    static Widget viewportWidget;
    @ObfuscatedName("pr")
    @ObfuscatedSignature(
            descriptor = "Lmq;"
    )
    static Widget clickedWidget;
    @ObfuscatedName("pf")
    @ObfuscatedSignature(
            descriptor = "Lmq;"
    )
    static Widget clickedWidgetParent;
    @ObfuscatedName("pd")
    static int widgetClickX;
    @ObfuscatedName("pw")
    static int widgetClickY;
    @ObfuscatedName("pz")
    @ObfuscatedSignature(
            descriptor = "Lmq;"
    )
    static Widget draggedOnWidget;
   @ObfuscatedName("pq")
   static boolean field540;
   @ObfuscatedName("pi")
   static int field495;
   @ObfuscatedName("pb")
   static int field542;
   @ObfuscatedName("px")
   static boolean field622;
   @ObfuscatedName("ph")
   static int field544;
   @ObfuscatedName("pv")
   static int field545;
    @ObfuscatedName("pn")
    static boolean isDraggingWidget;
    @ObfuscatedName("qu")
    static int cycleCntr;
    @ObfuscatedName("qr")
    static int[] changedVarps;
    @ObfuscatedName("qx")
    static int changedVarpCount;
    @ObfuscatedName("qj")
    static int[] changedItemContainers;
    @ObfuscatedName("qc")
    static int changedItemContainersCount;
    @ObfuscatedName("qs")
    static int[] changedSkills;
    @ObfuscatedName("qf")
    static int changedSkillsCount;
   @ObfuscatedName("qt")
   static int[] field554;
   @ObfuscatedName("qn")
   static int field555;
    @ObfuscatedName("qb")
    static int chatCycle;
   @ObfuscatedName("qg")
   static int field557;
   @ObfuscatedName("qd")
   static int field558;
   @ObfuscatedName("qy")
   static int field559;
   @ObfuscatedName("qz")
   static int field560;
   @ObfuscatedName("qq")
   static int field629;
   @ObfuscatedName("qv")
   static int field635;
   @ObfuscatedName("qa")
   static int field433;
    @ObfuscatedName("rd")
    static int mouseWheelRotation;
   @ObfuscatedName("rl")
   @ObfuscatedSignature(
      descriptor = "Ltz;"
   )
   static class506 field565;
    @ObfuscatedName("rq")
    @ObfuscatedSignature(
            descriptor = "Lnh;"
    )
    static NodeDeque scriptEvents;
   @ObfuscatedName("rt")
   @ObfuscatedSignature(
      descriptor = "Lnh;"
   )
   static NodeDeque field567;
   @ObfuscatedName("rp")
   @ObfuscatedSignature(
      descriptor = "Lnh;"
   )
   static NodeDeque field568;
   @ObfuscatedName("re")
   @ObfuscatedSignature(
      descriptor = "Lnh;"
   )
   static NodeDeque field569;
    @ObfuscatedName("rv")
    @ObfuscatedSignature(
            descriptor = "Lrc;"
    )
    static NodeHashTable widgetFlags;
    @ObfuscatedName("rr")
    static int rootWidgetCount;
   @ObfuscatedName("rs")
   static int field527;
   @ObfuscatedName("rf")
   static boolean[] field573;
   @ObfuscatedName("rm")
   static boolean[] field574;
   @ObfuscatedName("rw")
   static boolean[] field519;
    @ObfuscatedName("rh")
    static int[] rootWidgetXs;
    @ObfuscatedName("rb")
    static int[] rootWidgetYs;
    @ObfuscatedName("ra")
    static int[] rootWidgetWidths;
    @ObfuscatedName("ri")
    static int[] rootWidgetHeights;
    @ObfuscatedName("rg")
    static int gameDrawingMode;
   @ObfuscatedName("rj")
   static long field581;
    @ObfuscatedName("ro")
    static boolean isResizable;
   @ObfuscatedName("sy")
   static int[] field583;
    @ObfuscatedName("sj")
    static int publicChatMode;
    @ObfuscatedName("su")
    static int tradeChatMode;
   @ObfuscatedName("ss")
   static String field586;
   @ObfuscatedName("st")
   static long[] field652;
   @ObfuscatedName("sf")
   static int field588;
    @ObfuscatedName("sh")
    @ObfuscatedSignature(
            descriptor = "Lhy;"
    )
    public static class207 keyHandlerInstance;
   @ObfuscatedName("si")
   @ObfuscatedSignature(
      descriptor = "Lhe;"
   )
   static class205 field590;
   @ObfuscatedName("sm")
   static int field355;
   @ObfuscatedName("sk")
   static int[] field592;
   @ObfuscatedName("sz")
   static int[] field424;
    @ObfuscatedName("sc")
    static long timeOfPreviousKeyPress;
    @ObfuscatedName("sg")
    @ObfuscatedSignature(
            descriptor = "[Lfj;"
    )
    static ClanSettings[] currentClanSettings;
    @ObfuscatedName("so")
    @ObfuscatedSignature(
            descriptor = "[Lgj;"
    )
    static ClanChannel[] currentClanChannels;
   @ObfuscatedName("sp")
   static int field596;
    @ObfuscatedName("sr")
    static int mapIconCount;
    @ObfuscatedName("tw")
    static int[] mapIconXs;
    @ObfuscatedName("ty")
    static int[] mapIconYs;
    @ObfuscatedName("ts")
    @ObfuscatedSignature(
            descriptor = "[Ltq;"
    )
    static SpritePixels[] mapIcons;
    @ObfuscatedName("te")
    static int destinationX;
    @ObfuscatedName("th")
    static int destinationY;
    @ObfuscatedName("tp")
    static int minimapState;
    @ObfuscatedName("tz")
    static int currentTrackGroupId;
    @ObfuscatedName("tf")
    static boolean playingJingle;
    @ObfuscatedName("tl")
    static int soundEffectCount;
    @ObfuscatedName("tu")
    static int[] soundEffectIds;
    @ObfuscatedName("tr")
    static int[] queuedSoundEffectLoops;
   @ObfuscatedName("gx")
   String field396;
   @ObfuscatedName("gl")
   @ObfuscatedSignature(
      descriptor = "Lag;"
   )
   class14 field529;
   @ObfuscatedName("gz")
   @ObfuscatedSignature(
      descriptor = "Lam;"
   )
   class18 field390;
   @ObfuscatedName("hw")
   @ObfuscatedSignature(
      descriptor = "Lcom/jagex/oldscape/pub/OtlTokenRequester;"
   )
   OtlTokenRequester field399;
   @ObfuscatedName("hi")
   Future field400;
   @ObfuscatedName("hj")
   boolean field401 = false;
   @ObfuscatedName("hm")
   @ObfuscatedSignature(
      descriptor = "Lam;"
   )
   class18 field410;
   @ObfuscatedName("hu")
   @ObfuscatedSignature(
      descriptor = "Lcom/jagex/oldscape/pub/RefreshAccessTokenRequester;"
   )
   RefreshAccessTokenRequester field419;
   @ObfuscatedName("hx")
   Future field404;
   @ObfuscatedName("ha")
   @ObfuscatedSignature(
      descriptor = "Lsg;"
   )
   Buffer field409;
   @ObfuscatedName("hp")
   @ObfuscatedSignature(
      descriptor = "Lal;"
   )
   class7 field421;
    @ObfuscatedName("he")
    long accountHash = -1L;

   static {
      playerAttackOption = AttackOption.AttackOption_hidden;
      npcAttackOption = AttackOption.AttackOption_hidden;
      renderSelf = false;
      titleLoadingStage = 0;
      js5ConnectState = 0;
      js5Cycles = 0;
      js5Errors = 0;
      loginState = 0;
      field391 = 0;
      field392 = 0;
      field393 = 0;
      field394 = class135.field1305;
      field395 = class493.field4098;
      field405 = WorldMapSectionType.method1510(PlayerComposition.method1703("com_jagex_auth_desktop_osrs:public"));
      Login_isUsernameRemembered = false;
      secureRandomFuture = new SecureRandomFuture();
      randomDatData = null;
      npcs = new NPC[65536];
      npcCount = 0;
      npcIndices = new int[65536];
      field416 = 0;
      field417 = new int[250];
      packetWriter = new PacketWriter();
      logoutTimer = 0;
      hadNetworkError = false;
      timer = new Timer();
      fontsMap = new HashMap();
      field427 = 0;
      field593 = 1;
      field425 = 0;
      field426 = 1;
      field489 = 0;
      collisionMaps = new CollisionMap[4];
      isInInstance = false;
      instanceChunkTemplates = new int[4][13][13];
      field431 = new int[]{0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3};
      field432 = 0;
      field443 = 2301979;
      field451 = 5063219;
      field435 = 3353893;
      field436 = 7759444;
      field437 = false;
      alternativeScrollbarWidth = 0;
      camAngleX = 128;
      camAngleY = 0;
      camAngleDY = 0;
      camAngleDX = 0;
      mouseCamClickedX = 0;
      mouseCamClickedY = 0;
      oculusOrbState = 0;
      camFollowHeight = 50;
      field644 = 0;
      field595 = 0;
      field398 = 0;
      oculusOrbNormalSpeed = 12;
      oculusOrbSlowedSpeed = 6;
      field444 = 0;
      oculusOrbOnLocalPlayer = false;
      packetIndicator = 0;
      emitPackets = false;
      field456 = 0;
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
      field476 = 0;
      showLoadingMessages = true;
      players = new Player[2048];
      localPlayerIndex = -1;
      isMembers = 0;
      playerUUID = -1L;
      field482 = true;
      drawPlayerNames = 0;
      field484 = 0;
      field485 = new int[1000];
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
      field514 = 0;
      field515 = 50;
      isItemSelected = 0;
      field364 = null;
      isSpellSelected = false;
      selectedSpellChildIndex = -1;
      selectedSpellItemId = -1;
      field530 = null;
      field522 = null;
      rootInterface = -1;
      interfaceParents = new NodeHashTable(8);
      field463 = 0;
      field526 = -1;
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
      field540 = false;
      field495 = -1;
      field542 = -1;
      field622 = false;
      field544 = -1;
      field545 = -1;
      isDraggingWidget = false;
      cycleCntr = 1;
      changedVarps = new int[32];
      changedVarpCount = 0;
      changedItemContainers = new int[32];
      changedItemContainersCount = 0;
      changedSkills = new int[32];
      changedSkillsCount = 0;
      field554 = new int[32];
      field555 = 0;
      chatCycle = 0;
      field557 = 0;
      field558 = 0;
      field559 = 0;
      field560 = 0;
      field629 = 0;
      field635 = 0;
      field433 = 0;
      mouseWheelRotation = 0;
      field565 = new class506();
      scriptEvents = new NodeDeque();
      field567 = new NodeDeque();
      field568 = new NodeDeque();
      field569 = new NodeDeque();
      widgetFlags = new NodeHashTable(512);
      rootWidgetCount = 0;
      field527 = -2;
      field573 = new boolean[100];
      field574 = new boolean[100];
      field519 = new boolean[100];
      rootWidgetXs = new int[100];
      rootWidgetYs = new int[100];
      rootWidgetWidths = new int[100];
      rootWidgetHeights = new int[100];
      gameDrawingMode = 0;
      field581 = 0L;
      isResizable = true;
      field583 = new int[]{16776960, 16711680, 65280, 65535, 16711935, 16777215};
      publicChatMode = 0;
      tradeChatMode = 0;
      field586 = "";
      field652 = new long[100];
      field588 = 0;
      keyHandlerInstance = new class207();
      field590 = new class205();
      field355 = 0;
      field592 = new int[128];
      field424 = new int[128];
      timeOfPreviousKeyPress = -1L;
      currentClanSettings = new ClanSettings[4];
      currentClanChannels = new ClanChannel[4];
      field596 = -1;
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
      field541 = false;
      field614 = false;
      field615 = false;
      field535 = null;
      field617 = null;
      field604 = null;
      field598 = false;
      field620 = new boolean[5];
      field621 = new int[5];
      field643 = new int[5];
      field499 = new int[5];
      cameraShakeCycle = new int[5];
      field625 = 256;
      field626 = 205;
      zoomHeight = 256;
      zoomWidth = 320;
      field440 = 1;
      field630 = 32767;
      field488 = 1;
      field562 = 32767;
      viewportOffsetX = 0;
      viewportOffsetY = 0;
      viewportWidth = 0;
      viewportHeight = 0;
      viewportZoom = 0;
      playerAppearance = new PlayerComposition();
      field639 = -1;
      field640 = -1;
      platformInfoProvider = new DesktopPlatformInfoProvider();
      grandExchangeOffers = new GrandExchangeOffer[8];
      GrandExchangeEvents_worldComparator = new GrandExchangeOfferOwnWorldComparator();
      archive5 = new class398(8, class396.field3689);
      Widget_cachedModels = new EvictingDualNodeHashTable(64);
      Widget_cachedFonts = new EvictingDualNodeHashTable(64);
      field613 = -1;
      field648 = -1;
      field649 = new ArrayList();
      archiveLoaders = new ArrayList(10);
      archiveLoadersDone = 0;
      field397 = 0;
      field653 = new ApproximateRouteStrategy();
      field654 = new int[50];
      field655 = new int[50];
   }

    @ObfuscatedName("am")
    @ObfuscatedSignature(
            descriptor = "(B)V",
            garbageValue = "79"
    )
    protected final void resizeGame() {
      field581 = class96.clockNow() + 500L;
      this.resizeJS();
      if (rootInterface != -1) {
         this.resizeRoot(true);
      }

   }

    @ObfuscatedName("bm")
    @ObfuscatedSignature(
            descriptor = "(B)V",
            garbageValue = "42"
    )
    protected final void setUp() {
      class134.method782(new int[]{20, 260, 10000}, new int[]{1000, 100, 500});
      FriendsChat.worldPort = gameBuild == 0 ? 'ꩊ' : worldId + '鱀';
      class127.js5Port = gameBuild == 0 ? 443 : worldId + '썐';
      ItemContainer.currentPort = FriendsChat.worldPort;
      PlayerComposition.field2837 = class315.field2864;
      PlayerComposition.field2828 = class315.field2863;
      WorldMapIcon_0.field2359 = class315.field2865;
      class437.field3825 = class315.field2866;
      class14.urlRequester = new class108(this.field401, 213);
      this.setUpKeyboard();
      this.method186();
      class123.mouseWheel = this.mouseWheel();
      this.method160(field590, 0);
      this.method160(keyHandlerInstance, 1);
      WorldMapID.masterDisk = new ArchiveDisk(255, JagexCache.JagexCache_dat2File, JagexCache.JagexCache_idx255File, 500000);
      class20.clientPreferences = class205.method1146();
      this.setUpClipboard();
      String var2 = ReflectionCheck.field167;
      class31.field90 = this;
      if (var2 != null) {
         class31.field91 = var2;
      }

      Decimator.setWindowedMode(class20.clientPreferences.method577());
      World.friendSystem = new FriendSystem(class70.loginType);
      this.field529 = new class14("tokenRequest", 1, 1);
   }

    @ObfuscatedName("bd")
    @ObfuscatedSignature(
            descriptor = "(I)V",
            garbageValue = "-2106306379"
    )
    protected final void doCycle() {
      ++cycle;
      this.doCycleJs5();

      while(true) {
         NodeDeque var2 = ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue;
         ArchiveDiskAction var1;
         synchronized(ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue) {
            var1 = (ArchiveDiskAction)ArchiveDiskActionHandler.ArchiveDiskActionHandler_responseQueue.removeLast();
         }

         if (var1 == null) {
            int var5;
            try {
               if (class297.musicPlayerStatus == 1) {
                  var5 = class475.midiPcmStream.method1644();
                  if (var5 > 0 && class475.midiPcmStream.isReady()) {
                     var5 -= class162.pcmSampleLength;
                     if (var5 < 0) {
                        var5 = 0;
                     }

                     class475.midiPcmStream.setPcmStreamVolume(var5);
                  } else {
                     class475.midiPcmStream.clear();
                     class475.midiPcmStream.removeAll();
                     if (class297.musicTrackArchive != null) {
                        class297.musicPlayerStatus = 2;
                     } else {
                        class297.musicPlayerStatus = 0;
                     }

                     RouteStrategy.musicTrack = null;
                     class297.soundCache = null;
                  }
               }
            } catch (Exception var8) {
               var8.printStackTrace();
               class475.midiPcmStream.clear();
               class297.musicPlayerStatus = 0;
               RouteStrategy.musicTrack = null;
               class297.soundCache = null;
               class297.musicTrackArchive = null;
            }

            class323.playPcmPlayers();
            keyHandlerInstance.method1151();
            this.method169();
            MouseHandler var9 = MouseHandler.MouseHandler_instance;
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

            if (class123.mouseWheel != null) {
               var5 = class123.mouseWheel.useRotation();
               mouseWheelRotation = var5;
            }

            if (gameState == 0) {
               DevicePcmPlayerProvider.load();
               NPC.method611();
            } else if (gameState == 5) {
               EnumComposition.method1016(this, Language.fontPlain11, WallDecoration.fontPlain12);
               DevicePcmPlayerProvider.load();
               NPC.method611();
            } else if (gameState != 10 && gameState != 11) {
               if (gameState == 20) {
                  EnumComposition.method1016(this, Language.fontPlain11, WallDecoration.fontPlain12);
                  this.doCycleLoggedOut();
               } else if (gameState == 50) {
                  EnumComposition.method1016(this, Language.fontPlain11, WallDecoration.fontPlain12);
                  this.doCycleLoggedOut();
               } else if (gameState == 25) {
                  class27.method122();
               }
            } else {
               EnumComposition.method1016(this, Language.fontPlain11, WallDecoration.fontPlain12);
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

    @ObfuscatedName("bt")
    @ObfuscatedSignature(
            descriptor = "(ZS)V",
            garbageValue = "7737"
    )
    protected final void draw(boolean var1) {
      boolean var2;
      label175: {
         try {
            if (class297.musicPlayerStatus == 2) {
               if (RouteStrategy.musicTrack == null) {
                  RouteStrategy.musicTrack = MusicTrack.readTrack(class297.musicTrackArchive, class379.musicTrackGroupId, VarpDefinition.musicTrackFileId);
                  if (RouteStrategy.musicTrack == null) {
                     var2 = false;
                     break label175;
                  }
               }

               if (class297.soundCache == null) {
                  class297.soundCache = new SoundCache(class297.soundEffectsArchive, class297.musicSamplesArchive);
               }

               if (class475.midiPcmStream.loadMusicTrack(RouteStrategy.musicTrack, class297.musicPatchesArchive, class297.soundCache, 22050)) {
                  class475.midiPcmStream.clearAll();
                  class475.midiPcmStream.setPcmStreamVolume(class100.musicTrackVolume);
                  class475.midiPcmStream.setMusicTrack(RouteStrategy.musicTrack, class120.musicTrackBoolean);
                  class297.musicPlayerStatus = 0;
                  RouteStrategy.musicTrack = null;
                  class297.soundCache = null;
                  class297.musicTrackArchive = null;
                  var2 = true;
                  break label175;
               }
            }
         } catch (Exception var6) {
            var6.printStackTrace();
            class475.midiPcmStream.clear();
            class297.musicPlayerStatus = 0;
            RouteStrategy.musicTrack = null;
            class297.soundCache = null;
            class297.musicTrackArchive = null;
         }

         var2 = false;
      }

      if (var2 && playingJingle && class28.pcmPlayer0 != null) {
         class28.pcmPlayer0.tryDiscard();
      }

      if ((gameState == 10 || gameState == 20 || gameState == 30) && field581 != 0L && class96.clockNow() > field581) {
         Decimator.setWindowedMode(GrandExchangeOfferNameComparator.getWindowedMode());
      }

      int var4;
      if (var1) {
         for(var4 = 0; var4 < 100; ++var4) {
            field573[var4] = true;
         }
      }

      if (gameState == 0) {
         this.drawInitial(Login.Login_loadingPercent, Login.Login_loadingText, var1);
      } else if (gameState == 5) {
         class6.drawTitle(class137.fontBold12, Language.fontPlain11, WallDecoration.fontPlain12);
      } else if (gameState != 10 && gameState != 11) {
         if (gameState == 20) {
            class6.drawTitle(class137.fontBold12, Language.fontPlain11, WallDecoration.fontPlain12);
         } else if (gameState == 50) {
            class6.drawTitle(class137.fontBold12, Language.fontPlain11, WallDecoration.fontPlain12);
         } else if (gameState == 25) {
            if (field489 == 1) {
               if (field427 > field593) {
                  field593 = field427;
               }

               var4 = (field593 * 50 - field427 * 50) / field593;
               WorldMapDecoration.drawLoadingMessage("Loading - please wait." + "<br>" + " (" + var4 + "%" + ")", false);
            } else if (field489 == 2) {
               if (field425 > field426) {
                  field426 = field425;
               }

               var4 = (field426 * 50 - field425 * 50) / field426 + 50;
               WorldMapDecoration.drawLoadingMessage("Loading - please wait." + "<br>" + " (" + var4 + "%" + ")", false);
            } else {
               WorldMapDecoration.drawLoadingMessage("Loading - please wait.", false);
            }
         } else if (gameState == 30) {
            this.drawLoggedIn();
         } else if (gameState == 40) {
            WorldMapDecoration.drawLoadingMessage("Connection lost" + "<br>" + "Please wait - attempting to reestablish", false);
         } else if (gameState == 45) {
            WorldMapDecoration.drawLoadingMessage("Please wait...", false);
         }
      } else {
         class6.drawTitle(class137.fontBold12, Language.fontPlain11, WallDecoration.fontPlain12);
      }

      if (gameState == 30 && gameDrawingMode == 0 && !var1 && !isResizable) {
         for(var4 = 0; var4 < rootWidgetCount; ++var4) {
            if (field574[var4]) {
               RouteStrategy.rasterProvider.draw(rootWidgetXs[var4], rootWidgetYs[var4], rootWidgetWidths[var4], rootWidgetHeights[var4]);
               field574[var4] = false;
            }
         }
      } else if (gameState > 0) {
         RouteStrategy.rasterProvider.drawFull(0, 0);

         for(var4 = 0; var4 < rootWidgetCount; ++var4) {
            field574[var4] = false;
         }
      }

   }

    @ObfuscatedName("bj")
    @ObfuscatedSignature(
            descriptor = "(I)V",
            garbageValue = "-72974483"
    )
    protected final void kill0() {
      if (class373.varcs.hasUnwrittenChanges()) {
         class373.varcs.write();
      }

      if (UserComparator6.mouseRecorder != null) {
         UserComparator6.mouseRecorder.isRunning = false;
      }

      UserComparator6.mouseRecorder = null;
      packetWriter.close();
      GraphicsObject.method432();
      class123.mouseWheel = null;
      if (class28.pcmPlayer0 != null) {
         class28.pcmPlayer0.shutdown();
      }

      if (HorizontalAlignment.pcmPlayer1 != null) {
         HorizontalAlignment.pcmPlayer1.shutdown();
      }

      class295.method1608();
      class144.method822();
      if (class14.urlRequester != null) {
         class14.urlRequester.close();
         class14.urlRequester = null;
      }

      try {
         JagexCache.JagexCache_dat2File.close();

         for(int var1 = 0; var1 < JagexCache.idxCount; ++var1) {
            class370.JagexCache_idxFiles[var1].close();
         }

         JagexCache.JagexCache_idx255File.close();
         JagexCache.JagexCache_randomDat.close();
      } catch (Exception var3) {
         ;
      }

      this.field529.method54();
   }

    @ObfuscatedName("ba")
    @ObfuscatedSignature(
            descriptor = "(I)V",
            garbageValue = "-1086551379"
    )
    protected final void vmethod1485() {
   }

   @ObfuscatedName("gn")
   @ObfuscatedSignature(
      descriptor = "(I)Z",
      garbageValue = "-945273483"
   )
   boolean method394() {
      return ModeWhere.field3571 != null && !ModeWhere.field3571.trim().isEmpty() && TileItem.field1079 != null && !TileItem.field1079.trim().isEmpty();
   }

   @ObfuscatedName("gv")
   @ObfuscatedSignature(
      descriptor = "(B)Z",
      garbageValue = "24"
   )
   boolean method369() {
      return SpriteMask.field2808 != null && !SpriteMask.field2808.trim().isEmpty() && class121.field1185 != null && !class121.field1185.trim().isEmpty();
   }

   @ObfuscatedName("gx")
   @ObfuscatedSignature(
      descriptor = "(B)Z",
      garbageValue = "-2"
   )
   boolean method370() {
      return this.field399 != null;
   }

   @ObfuscatedName("gl")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;I)V",
      garbageValue = "-1706352658"
   )
   void method371(String var1) throws IOException {
      HashMap var2 = new HashMap();
      var2.put("grant_type", "refresh_token");
      var2.put("scope", "gamesso.token.create");
      var2.put("refresh_token", var1);
      URL var3 = new URL(ViewportMouse.field2213 + "shield/oauth/token" + (new class438(var2)).method2298());
      class394 var4 = new class394();
      var4.method2114(field405);
      var4.method2106("Host", (new URL(ViewportMouse.field2213)).getHost());
      var4.method2111(class435.field3823);
      class9 var5 = class9.field30;
      RefreshAccessTokenRequester var6 = this.field419;
      if (var6 != null) {
         this.field404 = var6.request(var5.method30(), var3, var4.method2105(), "");
      } else {
         class10 var7 = new class10(var3, var5, var4, this.field401);
         this.field410 = this.field529.method52(var7);
      }
   }

   @ObfuscatedName("gz")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;I)V",
      garbageValue = "1446006608"
   )
   void method397(String var1) throws IOException {
      URL var2 = new URL(ViewportMouse.field2213 + "public/v1/games/YCfdbvr2pM1zUYMxJRexZY/play");
      class394 var3 = new class394();
      var3.method2108(var1);
      class9 var4 = class9.field24;
      OtlTokenRequester var5 = this.field399;
      if (var5 != null) {
         this.field400 = var5.request(var4.method30(), var2, var3.method2105(), "");
      } else {
         class10 var6 = new class10(var2, var4, var3, this.field401);
         this.field390 = this.field529.method52(var6);
      }
   }

   @ObfuscatedName("hw")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "1474733588"
   )
   void method372(String var1, String var2) throws IOException, JSONException {
      URL var3 = new URL(ViewportMouse.field2213 + "/game-session/v1/tokens");
      class10 var4 = new class10(var3, class9.field30, this.field401);
      var4.method34().method2108(var1);
      var4.method34().method2111(class435.field3823);
      JSONObject var5 = new JSONObject();
      var5.method2652("accountId", var2);
      var4.method38(new class437(var5));
      this.field390 = this.field529.method52(var4);
   }

    @ObfuscatedName("hj")
    @ObfuscatedSignature(
            descriptor = "(B)V",
            garbageValue = "-53"
    )
    void doCycleJs5() {
      if (gameState != 1000) {
         boolean var1 = Tile.method1214();
         if (!var1) {
            this.doCycleJs5Connect();
         }

      }
   }

    @ObfuscatedName("hm")
    @ObfuscatedSignature(
            descriptor = "(I)V",
            garbageValue = "-121494842"
    )
    void doCycleJs5Connect() {
      if (NetCache.NetCache_crcMismatches >= 4) {
         this.error("js5crc");
         class138.updateGameState(1000);
      } else {
         if (NetCache.NetCache_ioExceptions >= 4) {
            if (gameState <= 5) {
               this.error("js5io");
               class138.updateGameState(1000);
               return;
            }

            js5Cycles = 3000;
            NetCache.NetCache_ioExceptions = 3;
         }

         if (--js5Cycles + 1 <= 0) {
            try {
               if (js5ConnectState == 0) {
                  WorldMapSection0.js5SocketTask = GameEngine.taskHandler.newSocketTask(UserComparator8.worldHost, ItemContainer.currentPort);
                  ++js5ConnectState;
               }

               if (js5ConnectState == 1) {
                  if (WorldMapSection0.js5SocketTask.status == 2) {
                     this.js5Error(-1);
                     return;
                  }

                  if (WorldMapSection0.js5SocketTask.status == 1) {
                     ++js5ConnectState;
                  }
               }

               if (js5ConnectState == 2) {
                  KitDefinition.js5Socket = class186.method1008((Socket)WorldMapSection0.js5SocketTask.result, 40000, 5000);
                  Buffer var1 = new Buffer(5);
                  var1.writeByte(15);
                  var1.writeInt(213);
                  KitDefinition.js5Socket.write(var1.array, 0, 5);
                  ++js5ConnectState;
                  class132.field1276 = class96.clockNow();
               }

               if (js5ConnectState == 3) {
                  if (KitDefinition.js5Socket.available() > 0) {
                     int var5 = KitDefinition.js5Socket.readUnsignedByte();
                     if (var5 != 0) {
                        this.js5Error(var5);
                        return;
                     }

                     ++js5ConnectState;
                  } else if (class96.clockNow() - class132.field1276 > 30000L) {
                     this.js5Error(-2);
                     return;
                  }
               }

               if (js5ConnectState == 4) {
                  AbstractSocket var10 = KitDefinition.js5Socket;
                  boolean var2 = gameState > 20;
                  if (NetCache.NetCache_socket != null) {
                     try {
                        NetCache.NetCache_socket.close();
                     } catch (Exception var8) {
                        ;
                     }

                     NetCache.NetCache_socket = null;
                  }

                  NetCache.NetCache_socket = var10;
                  class177.method967(var2);
                  NetCache.NetCache_responseHeaderBuffer.offset = 0;
                  Script.NetCache_currentResponse = null;
                  NetCache.NetCache_responseArchiveBuffer = null;
                  NetCache.field3504 = 0;

                  while(true) {
                     NetFileRequest var3 = (NetFileRequest)NetCache.NetCache_pendingPriorityResponses.first();
                     if (var3 == null) {
                        while(true) {
                           var3 = (NetFileRequest)NetCache.NetCache_pendingResponses.first();
                           if (var3 == null) {
                              if (NetCache.field3506 != 0) {
                                 try {
                                    Buffer var11 = new Buffer(4);
                                    var11.writeByte(4);
                                    var11.writeByte(NetCache.field3506);
                                    var11.writeShort(0);
                                    NetCache.NetCache_socket.write(var11.array, 0, 4);
                                 } catch (IOException var7) {
                                    try {
                                       NetCache.NetCache_socket.close();
                                    } catch (Exception var6) {
                                       ;
                                    }

                                    ++NetCache.NetCache_ioExceptions;
                                    NetCache.NetCache_socket = null;
                                 }
                              }

                              NetCache.NetCache_loadTime = 0;
                              NetCache.field3509 = class96.clockNow();
                              WorldMapSection0.js5SocketTask = null;
                              KitDefinition.js5Socket = null;
                              js5ConnectState = 0;
                              js5Errors = 0;
                              return;
                           }

                           NetCache.NetCache_pendingWritesQueue.addLast(var3);
                           NetCache.NetCache_pendingWrites.put(var3, var3.key);
                           ++NetCache.NetCache_pendingWritesCount;
                           --NetCache.NetCache_pendingResponsesCount;
                        }
                     }

                     NetCache.NetCache_pendingPriorityWrites.put(var3, var3.key);
                     ++NetCache.NetCache_pendingPriorityWritesCount;
                     --NetCache.NetCache_pendingPriorityResponsesCount;
                  }
               }
            } catch (IOException var9) {
               this.js5Error(-3);
            }

         }
      }
   }

    @ObfuscatedName("hu")
    @ObfuscatedSignature(
            descriptor = "(IB)V",
            garbageValue = "-19"
    )
    void js5Error(int var1) {
      WorldMapSection0.js5SocketTask = null;
      KitDefinition.js5Socket = null;
      js5ConnectState = 0;
      if (FriendsChat.worldPort == ItemContainer.currentPort) {
         ItemContainer.currentPort = class127.js5Port;
      } else {
         ItemContainer.currentPort = FriendsChat.worldPort;
      }

      ++js5Errors;
      if (js5Errors < 2 || var1 != 7 && var1 != 9) {
         if (js5Errors >= 2 && var1 == 6) {
            this.error("js5connect_outofdate");
            class138.updateGameState(1000);
         } else if (js5Errors >= 4) {
            if (gameState <= 5) {
               this.error("js5connect");
               class138.updateGameState(1000);
            } else {
               js5Cycles = 3000;
            }
         }
      } else if (gameState <= 5) {
         this.error("js5connect_full");
         class138.updateGameState(1000);
      } else {
         js5Cycles = 3000;
      }

   }

    @ObfuscatedName("hl")
    @ObfuscatedSignature(
            descriptor = "(I)V",
            garbageValue = "-564344594"
    )
    final void doCycleLoggedOut() {
      AbstractSocket var1 = packetWriter.getSocket();
      PacketBuffer var2 = packetWriter.packetBuffer;

      try {
         if (loginState == 0) {
            if (class174.secureRandom == null && (secureRandomFuture.isDone() || field391 > 250)) {
               class174.secureRandom = secureRandomFuture.get();
               secureRandomFuture.shutdown();
               secureRandomFuture = null;
            }

            if (class174.secureRandom != null) {
               if (var1 != null) {
                  var1.close();
                  var1 = null;
               }

               class1.socketTask = null;
               hadNetworkError = false;
               field391 = 0;
               if (field395.method2558()) {
                  if (this.method394()) {
                     try {
                        this.method371(TileItem.field1079);
                        class284.method1595(21);
                     } catch (Throwable var23) {
                        class387.RunException_sendStackTrace((String)null, var23);
                        class315.getLoginError(65);
                        return;
                     }
                  } else {
                     if (!this.method369()) {
                        class315.getLoginError(65);
                        return;
                     }

                     try {
                        this.method372(SpriteMask.field2808, class121.field1185);
                        class284.method1595(20);
                     } catch (Exception var22) {
                        class387.RunException_sendStackTrace((String)null, var22);
                        class315.getLoginError(65);
                        return;
                     }
                  }
               } else {
                  class284.method1595(1);
               }
            }
         }

         class20 var25;
         if (loginState == 21) {
            if (this.field404 != null) {
               if (!this.field404.isDone()) {
                  return;
               }

               if (this.field404.isCancelled()) {
                  class315.getLoginError(65);
                  this.field404 = null;
                  return;
               }

               try {
                  RefreshAccessTokenResponse var3 = (RefreshAccessTokenResponse)this.field404.get();
                  if (!var3.isSuccess()) {
                     class315.getLoginError(65);
                     this.field404 = null;
                     return;
                  }

                  ModeWhere.field3571 = var3.getAccessToken();
                  TileItem.field1079 = var3.getRefreshToken();
                  this.field404 = null;
               } catch (Exception var21) {
                  class387.RunException_sendStackTrace((String)null, var21);
                  class315.getLoginError(65);
                  this.field404 = null;
                  return;
               }
            } else {
               if (this.field410 == null) {
                  class315.getLoginError(65);
                  return;
               }

               if (!this.field410.method66()) {
                  return;
               }

               if (this.field410.method63()) {
                  class387.RunException_sendStackTrace(this.field410.method65(), (Throwable)null);
                  class315.getLoginError(65);
                  this.field410 = null;
                  return;
               }

               var25 = this.field410.method67();
               if (var25.method79() != 200) {
                  class315.getLoginError(65);
                  this.field410 = null;
                  return;
               }

               field391 = 0;
               class437 var4 = new class437(var25.method81());

               try {
                  ModeWhere.field3571 = var4.method2292().getString("access_token");
                  TileItem.field1079 = var4.method2292().getString("refresh_token");
               } catch (Exception var20) {
                  class387.RunException_sendStackTrace("Error parsing tokens", var20);
                  class315.getLoginError(65);
                  this.field410 = null;
                  return;
               }
            }

            this.method397(ModeWhere.field3571);
            class284.method1595(20);
         }

         if (loginState == 20) {
            if (this.field400 != null) {
               if (!this.field400.isDone()) {
                  return;
               }

               if (this.field400.isCancelled()) {
                  class315.getLoginError(65);
                  this.field400 = null;
                  return;
               }

               try {
                  OtlTokenResponse var26 = (OtlTokenResponse)this.field400.get();
                  if (!var26.isSuccess()) {
                     class315.getLoginError(65);
                     this.field400 = null;
                     return;
                  }

                  this.field396 = var26.getToken();
                  this.field400 = null;
               } catch (Exception var19) {
                  class387.RunException_sendStackTrace((String)null, var19);
                  class315.getLoginError(65);
                  this.field400 = null;
                  return;
               }
            } else {
               if (this.field390 == null) {
                  class315.getLoginError(65);
                  return;
               }

               if (!this.field390.method66()) {
                  return;
               }

               if (this.field390.method63()) {
                  class387.RunException_sendStackTrace(this.field390.method65(), (Throwable)null);
                  class315.getLoginError(65);
                  this.field390 = null;
                  return;
               }

               var25 = this.field390.method67();
               if (var25.method79() != 200) {
                  class387.RunException_sendStackTrace("Response code: " + var25.method79() + "Response body: " + var25.method81(), (Throwable)null);
                  class315.getLoginError(65);
                  this.field390 = null;
                  return;
               }

               List var28 = (List)var25.method80().get("Content-Type");
               if (var28 != null && var28.contains(class435.field3823.method2287())) {
                  try {
                     JSONObject var5 = new JSONObject(var25.method81());
                     this.field396 = var5.getString("token");
                  } catch (JSONException var18) {
                     class387.RunException_sendStackTrace((String)null, var18);
                     class315.getLoginError(65);
                     this.field390 = null;
                     return;
                  }
               } else {
                  this.field396 = var25.method81();
               }

               this.field390 = null;
            }

            field391 = 0;
            class284.method1595(1);
         }

         if (loginState == 1) {
            if (class1.socketTask == null) {
               class1.socketTask = GameEngine.taskHandler.newSocketTask(UserComparator8.worldHost, ItemContainer.currentPort);
            }

            if (class1.socketTask.status == 2) {
               throw new IOException();
            }

            if (class1.socketTask.status == 1) {
               var1 = class186.method1008((Socket)class1.socketTask.result, 40000, 5000);
               packetWriter.setSocket(var1);
               class1.socketTask = null;
               class284.method1595(2);
            }
         }

         PacketBufferNode var27;
         if (loginState == 2) {
            packetWriter.clearBuffer();
            var27 = class478.method2430();
            var27.packetBuffer.writeByte(LoginPacket.field2705.id);
            packetWriter.addNode(var27);
            packetWriter.flush();
            var2.offset = 0;
            class284.method1595(3);
         }

         int var12;
         if (loginState == 3) {
            if (class28.pcmPlayer0 != null) {
               class28.pcmPlayer0.method228();
            }

            if (HorizontalAlignment.pcmPlayer1 != null) {
               HorizontalAlignment.pcmPlayer1.method228();
            }

            if (var1.isAvailable(1)) {
               var12 = var1.readUnsignedByte();
               if (class28.pcmPlayer0 != null) {
                  class28.pcmPlayer0.method228();
               }

               if (HorizontalAlignment.pcmPlayer1 != null) {
                  HorizontalAlignment.pcmPlayer1.method228();
               }

               if (var12 != 0) {
                  class315.getLoginError(var12);
                  return;
               }

               var2.offset = 0;
               class284.method1595(4);
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
               GrandExchangeEvent.field3524 = var2.readLong();
               class284.method1595(5);
            }
         }

         int var6;
         if (loginState == 5) {
            packetWriter.packetBuffer.offset = 0;
            packetWriter.clearBuffer();
            PacketBuffer var29 = new PacketBuffer(500);
            int[] var30 = new int[]{class174.secureRandom.nextInt(), class174.secureRandom.nextInt(), class174.secureRandom.nextInt(), class174.secureRandom.nextInt()};
            var29.offset = 0;
            var29.writeByte(1);
            var29.writeInt(var30[0]);
            var29.writeInt(var30[1]);
            var29.writeInt(var30[2]);
            var29.writeInt(var30[3]);
            var29.writeLong(GrandExchangeEvent.field3524);
            if (gameState == 40) {
               var29.writeInt(Huffman.field3027[0]);
               var29.writeInt(Huffman.field3027[1]);
               var29.writeInt(Huffman.field3027[2]);
               var29.writeInt(Huffman.field3027[3]);
            } else {
               if (gameState == 50) {
                  var29.writeByte(class135.field1303.rsOrdinal());
                  var29.writeInt(ByteArrayPool.field3668);
               } else {
                  var29.writeByte(field394.rsOrdinal());
                  switch(field394.field1304) {
                  case 0:
                     var29.offset += 4;
                     break;
                  case 1:
                  case 3:
                     var29.writeMedium(class204.field1846);
                     ++var29.offset;
                     break;
                  case 2:
                     var29.writeInt(class20.clientPreferences.method579(Login.Login_username));
                  }
               }

               if (field395.method2558()) {
                  var29.writeByte(class493.field4094.rsOrdinal());
                  var29.writeStringCp1252NullTerminated(this.field396);
               } else {
                  var29.writeByte(class493.field4098.rsOrdinal());
                  var29.writeStringCp1252NullTerminated(Login.Login_password);
               }
            }

            var29.encryptRsa(class70.field726, class70.field727);
            Huffman.field3027 = var30;
            PacketBufferNode var33 = class478.method2430();
            var33.packetBuffer.offset = 0;
            if (gameState == 40) {
               var33.packetBuffer.writeByte(LoginPacket.RECONNECT_LOGIN_CONNECTION.id);
            } else {
               var33.packetBuffer.writeByte(LoginPacket.NEW_LOGIN_CONNECTION.id);
            }

            var33.packetBuffer.writeShort(0);
            var6 = var33.packetBuffer.offset;
            var33.packetBuffer.writeInt(213);
            var33.packetBuffer.writeInt(1);
            var33.packetBuffer.writeByte(clientType);
            var33.packetBuffer.writeByte(field363);
            byte var7 = 0;
            var33.packetBuffer.writeByte(var7);
            var33.packetBuffer.writeBytes(var29.array, 0, var29.offset);
            int var8 = var33.packetBuffer.offset;
            var33.packetBuffer.writeStringCp1252NullTerminated(Login.Login_username);
            var33.packetBuffer.writeByte((isResizable ? 1 : 0) << 1 | (isLowDetail ? 1 : 0));
            var33.packetBuffer.writeShort(GameEngine.canvasWidth);
            var33.packetBuffer.writeShort(class262.canvasHeight);
            class383.method2086(var33.packetBuffer);
            var33.packetBuffer.writeStringCp1252NullTerminated(class108.param9);
            var33.packetBuffer.writeInt(TriBool.field3738);
            Buffer var9 = new Buffer(UserComparator10.platformInfo.size());
            UserComparator10.platformInfo.write(var9);
            var33.packetBuffer.writeBytes(var9.array, 0, var9.array.length);
            var33.packetBuffer.writeByte(clientType);
            var33.packetBuffer.writeInt(0);
            var33.packetBuffer.writeIntME(DevicePcmPlayerProvider.field67.hash);
            var33.packetBuffer.writeIntME(GrandExchangeOfferUnitPriceComparator.archive18.hash);
            var33.packetBuffer.writeIntIME(GrandExchangeOfferTotalQuantityComparator.archive9.hash);
            var33.packetBuffer.writeIntLE(class452.archive8.hash);
            var33.packetBuffer.writeIntIME(class126.archive15.hash);
            var33.packetBuffer.writeIntLE(NetFileRequest.archive10.hash);
            var33.packetBuffer.writeInt(class399.archive6.hash);
            var33.packetBuffer.writeIntLE(class85.archive2.hash);
            var33.packetBuffer.writeIntLE(class85.archive4.hash);
            var33.packetBuffer.writeIntIME(class28.archive19.hash);
            var33.packetBuffer.writeIntLE(class230.archive14.hash);
            var33.packetBuffer.writeIntME(class128.archive13.hash);
            var33.packetBuffer.writeIntME(WorldMapLabelSize.field2285.hash);
            var33.packetBuffer.writeIntLE(FloorUnderlayDefinition.archive11.hash);
            var33.packetBuffer.writeIntIME(class168.archive17.hash);
            var33.packetBuffer.writeIntLE(class195.field1645.hash);
            var33.packetBuffer.writeIntLE(GameBuild.archive7.hash);
            var33.packetBuffer.writeIntME(class205.archive20.hash);
            var33.packetBuffer.writeIntME(0);
            var33.packetBuffer.writeIntIME(class426.field3811.hash);
            var33.packetBuffer.writeIntME(class126.archive12.hash);
            var33.packetBuffer.xteaEncrypt(var30, var8, var33.packetBuffer.offset);
            var33.packetBuffer.writeLengthShort(var33.packetBuffer.offset - var6);
            packetWriter.addNode(var33);
            packetWriter.flush();
            packetWriter.isaacCipher = new IsaacCipher(var30);
            int[] var10 = new int[4];

            for(int var11 = 0; var11 < 4; ++var11) {
               var10[var11] = var30[var11] + 50;
            }

            var2.newIsaacCipher(var10);
            class284.method1595(6);
         }

         int var13;
         if (loginState == 6 && var1.available() > 0) {
            var12 = var1.readUnsignedByte();
            if (var12 == 61) {
               var13 = var1.available();
               WorldMapSectionType.field2384 = var13 == 1 && var1.readUnsignedByte() == 1;
               class284.method1595(5);
            }

            if (var12 == 21 && gameState == 20) {
               class284.method1595(12);
            } else if (var12 == 2) {
               class284.method1595(14);
            } else if (var12 == 15 && gameState == 40) {
               packetWriter.serverPacketLength = -1;
               class284.method1595(19);
            } else if (var12 == 64) {
               class284.method1595(10);
            } else if (var12 == 23 && field392 < 1) {
               ++field392;
               class284.method1595(0);
            } else if (var12 == 29) {
               class284.method1595(17);
            } else {
               if (var12 != 69) {
                  class315.getLoginError(var12);
                  return;
               }

               class284.method1595(7);
            }
         }

         if (loginState == 7 && var1.available() >= 2) {
            var1.read(var2.array, 0, 2);
            var2.offset = 0;
            class13.field43 = var2.readUnsignedShort();
            class284.method1595(8);
         }

         if (loginState == 8 && var1.available() >= class13.field43) {
            var2.offset = 0;
            var1.read(var2.array, var2.offset, class13.field43);
            class6[] var31 = new class6[]{class6.field9};
            class6 var32 = var31[var2.readUnsignedByte()];

            try {
               class3 var35 = UserComparator4.method684(var32);
               this.field421 = new class7(var2, var35);
               class284.method1595(9);
            } catch (Exception var17) {
               class315.getLoginError(22);
               return;
            }
         }

         if (loginState == 9 && this.field421.method25()) {
            this.field409 = this.field421.method22();
            this.field421.method21();
            this.field421 = null;
            if (this.field409 == null) {
               class315.getLoginError(22);
               return;
            }

            packetWriter.clearBuffer();
            var27 = class478.method2430();
            var27.packetBuffer.writeByte(LoginPacket.field2700.id);
            var27.packetBuffer.writeShort(this.field409.offset);
            var27.packetBuffer.method2476(this.field409);
            packetWriter.addNode(var27);
            packetWriter.flush();
            this.field409 = null;
            class284.method1595(6);
         }

         if (loginState == 10 && var1.available() > 0) {
            DevicePcmPlayerProvider.field68 = var1.readUnsignedByte();
            class284.method1595(11);
         }

         if (loginState == 11 && var1.available() >= DevicePcmPlayerProvider.field68) {
            var1.read(var2.array, 0, DevicePcmPlayerProvider.field68);
            var2.offset = 0;
            class284.method1595(6);
         }

         if (loginState == 12 && var1.available() > 0) {
            field393 = (var1.readUnsignedByte() + 3) * 60;
            class284.method1595(13);
         }

         if (loginState == 13) {
            field391 = 0;
            class205.setLoginResponseString("You have only just left another world.", "Your profile will be transferred in:", field393 / 60 + " seconds.");
            if (--field393 <= 0) {
               class284.method1595(0);
            }

         } else {
            if (loginState == 14 && var1.available() >= 1) {
               class7.playerUUIDLength = var1.readUnsignedByte();
               class284.method1595(15);
            }

            if (loginState == 15 && var1.available() >= class7.playerUUIDLength) {
               boolean var42 = var1.readUnsignedByte() == 1;
               var1.read(var2.array, 0, 4);
               var2.offset = 0;
               boolean var41 = false;
               if (var42) {
                  var13 = var2.readByteIsaac() << 24;
                  var13 |= var2.readByteIsaac() << 16;
                  var13 |= var2.readByteIsaac() << 8;
                  var13 |= var2.readByteIsaac();
                  class20.clientPreferences.method582(Login.Login_username, var13);
               }

               if (Login_isUsernameRemembered) {
                  class20.clientPreferences.setUsernameToRemember(Login.Login_username);
               } else {
                  class20.clientPreferences.setUsernameToRemember((String)null);
               }

               class100.savePreferences();
               staffModLevel = var1.readUnsignedByte();
               playerMod = var1.readUnsignedByte() == 1;
               localPlayerIndex = var1.readUnsignedByte();
               localPlayerIndex <<= 8;
               localPlayerIndex += var1.readUnsignedByte();
               isMembers = var1.readUnsignedByte();
               var1.read(var2.array, 0, 8);
               var2.offset = 0;
               this.accountHash = var2.readLong();
               if (class7.playerUUIDLength >= 29) {
                  var1.read(var2.array, 0, 8);
                  var2.offset = 0;
                  playerUUID = var2.readLong();
               }

               var1.read(var2.array, 0, 1);
               var2.offset = 0;
               ServerPacket[] var38 = PacketBufferNode.ServerPacket_values();
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
                  class26.method112(ScriptFrame.client, "zap");
               } catch (Throwable var16) {
                  ;
               }

               class284.method1595(16);
            }

            if (loginState != 16) {
               if (loginState == 17 && var1.available() >= 2) {
                  var2.offset = 0;
                  var1.read(var2.array, 0, 2);
                  var2.offset = 0;
                  class4.field6 = var2.readUnsignedShort();
                  class284.method1595(18);
               }

               if (loginState == 18 && var1.available() >= class4.field6) {
                  var2.offset = 0;
                  var1.read(var2.array, 0, class4.field6);
                  var2.offset = 0;
                  String var39 = var2.readStringCp1252NullTerminated();
                  String var36 = var2.readStringCp1252NullTerminated();
                  String var40 = var2.readStringCp1252NullTerminated();
                  class205.setLoginResponseString(var39, var36, var40);
                  class138.updateGameState(10);
                  if (field395.method2558()) {
                     class129.method763(9);
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
                     timer.method2099();
                     class121.method724();
                     class422.updatePlayer(var2);
                     if (var12 != var2.offset) {
                        throw new RuntimeException();
                     }
                  }
               } else {
                  ++field391;
                  if (field391 > 2000) {
                     if (field392 < 1) {
                        if (FriendsChat.worldPort == ItemContainer.currentPort) {
                           ItemContainer.currentPort = class127.js5Port;
                        } else {
                           ItemContainer.currentPort = FriendsChat.worldPort;
                        }

                        ++field392;
                        class284.method1595(0);
                     } else {
                        class315.getLoginError(-3);
                     }
                  }
               }
            } else {
               if (var1.available() >= packetWriter.serverPacketLength) {
                  var2.offset = 0;
                  var1.read(var2.array, 0, packetWriter.serverPacketLength);
                  timer.method2097();
                  mouseLastLastPressedTimeMillis = -1L;
                  UserComparator6.mouseRecorder.index = 0;
                  AbstractByteArrayCopier.hasFocus = true;
                  hadFocus = true;
                  timeOfPreviousKeyPress = -1L;
                  class36.reflectionChecks = new IterableNodeDeque();
                  packetWriter.clearBuffer();
                  packetWriter.packetBuffer.offset = 0;
                  packetWriter.serverPacket = null;
                  packetWriter.field1138 = null;
                  packetWriter.field1139 = null;
                  packetWriter.field1133 = null;
                  packetWriter.serverPacketLength = 0;
                  packetWriter.field1136 = 0;
                  rebootTimer = 0;
                  logoutTimer = 0;
                  hintArrowType = 0;
                  menuOptionsCount = 0;
                  isMenuOpen = false;
                  MouseHandler.MouseHandler_idleCycles = 0;
                  class162.method912();
                  isItemSelected = 0;
                  isSpellSelected = false;
                  soundEffectCount = 0;
                  camAngleY = 0;
                  oculusOrbState = 0;
                  class132.field1277 = null;
                  minimapState = 0;
                  field596 = -1;
                  destinationX = 0;
                  destinationY = 0;
                  playerAttackOption = AttackOption.AttackOption_hidden;
                  npcAttackOption = AttackOption.AttackOption_hidden;
                  npcCount = 0;
                  Players.Players_count = 0;

                  for(var12 = 0; var12 < 2048; ++var12) {
                     Players.cachedAppearanceBuffer[var12] = null;
                     Players.playerMovementSpeeds[var12] = MoveSpeed.WALK;
                  }

                  for(var12 = 0; var12 < 2048; ++var12) {
                     players[var12] = null;
                  }

                  for(var12 = 0; var12 < 65536; ++var12) {
                     npcs[var12] = null;
                  }

                  combatTargetPlayerIndex = -1;
                  projectiles.clear();
                  graphicsObjects.clear();

                  for(var12 = 0; var12 < 4; ++var12) {
                     for(var13 = 0; var13 < 104; ++var13) {
                        for(int var15 = 0; var15 < 104; ++var15) {
                           groundItems[var12][var13][var15] = null;
                        }
                     }
                  }

                  pendingSpawns = new NodeDeque();
                  World.friendSystem.clear();

                  for(var12 = 0; var12 < VarpDefinition.field1475; ++var12) {
                     VarpDefinition var34 = GraphicsDefaults.VarpDefinition_get(var12);
                     if (var34 != null) {
                        Varps.Varps_temp[var12] = 0;
                        Varps.Varps_main[var12] = 0;
                     }
                  }

                  class373.varcs.clearTransient();
                  followerIndex = -1;
                  if (rootInterface != -1) {
                     var12 = rootInterface;
                     if (var12 != -1 && class264.Widget_loadedInterfaces[var12]) {
                        UserComparator3.Widget_archive.clearFilesGroup(var12);
                        if (VerticalAlignment.Widget_interfaceComponents[var12] != null) {
                           for(var13 = 0; var13 < VerticalAlignment.Widget_interfaceComponents[var12].length; ++var13) {
                              if (VerticalAlignment.Widget_interfaceComponents[var12][var13] != null) {
                                 VerticalAlignment.Widget_interfaceComponents[var12][var13] = null;
                              }
                           }

                           VerticalAlignment.Widget_interfaceComponents[var12] = null;
                           class264.Widget_loadedInterfaces[var12] = false;
                        }
                     }
                  }

                  for(InterfaceParent var37 = (InterfaceParent)interfaceParents.first(); var37 != null; var37 = (InterfaceParent)interfaceParents.next()) {
                     class357.closeInterface(var37, true);
                  }

                  rootInterface = -1;
                  interfaceParents = new NodeHashTable(8);
                  meslayerContinueWidget = null;
                  menuOptionsCount = 0;
                  isMenuOpen = false;
                  playerAppearance.method1693((int[])null, (int[])null, new int[]{0, 0, 0, 0, 0}, 0, -1);

                  for(var12 = 0; var12 < 8; ++var12) {
                     playerMenuActions[var12] = null;
                     playerOptionsPriorities[var12] = false;
                  }

                  ItemContainer.itemContainers = new NodeHashTable(32);
                  isLoading = true;

                  for(var12 = 0; var12 < 100; ++var12) {
                     field573[var12] = true;
                  }

                  class1.method4();
                  UserComparator5.friendsChat = null;
                  ItemComposition.guestClanSettings = null;
                  Arrays.fill(currentClanSettings, (Object)null);
                  MouseHandler.guestClanChannel = null;
                  Arrays.fill(currentClanChannels, (Object)null);

                  for(var12 = 0; var12 < 8; ++var12) {
                     grandExchangeOffers[var12] = new GrandExchangeOffer();
                  }

                  class375.grandExchangeEvents = null;
                  class422.updatePlayer(var2);
                  class28.timeOfPreviousKeyPress = -1;
                  class127.loadRegions(false, var2);
                  packetWriter.serverPacket = null;
               }

            }
         }
      } catch (IOException var24) {
         if (field392 < 1) {
            if (FriendsChat.worldPort == ItemContainer.currentPort) {
               ItemContainer.currentPort = class127.js5Port;
            } else {
               ItemContainer.currentPort = FriendsChat.worldPort;
            }

            ++field392;
            class284.method1595(0);
         } else {
            class315.getLoginError(-2);
         }
      }
   }

    @ObfuscatedName("hq")
    @ObfuscatedSignature(
            descriptor = "(B)V",
            garbageValue = "-67"
    )
    final void doCycleLoggedIn() {
      if (rebootTimer > 1) {
         --rebootTimer;
      }

      if (logoutTimer > 0) {
         --logoutTimer;
      }

      if (hadNetworkError) {
         hadNetworkError = false;
         class349.method1918();
      } else {
         if (!isMenuOpen) {
            class156.addCancelMenuEntry();
         }

         int var1;
         for(var1 = 0; var1 < 100 && this.method391(packetWriter); ++var1) {
            ;
         }

         if (gameState == 30) {
            while(true) {
               ReflectionCheck var2 = (ReflectionCheck)class36.reflectionChecks.last();
               boolean var30;
               if (var2 == null) {
                  var30 = false;
               } else {
                  var30 = true;
               }

               int var3;
               PacketBufferNode var31;
               if (!var30) {
                  PacketBufferNode var14;
                  int var15;
                  if (timer.field3670) {
                     var14 = class330.getPacketBufferNode(ClientPacket.field2552, packetWriter.isaacCipher);
                     var14.packetBuffer.writeByte(0);
                     var15 = var14.packetBuffer.offset;
                     timer.write(var14.packetBuffer);
                     var14.packetBuffer.method2479(var14.packetBuffer.offset - var15);
                     packetWriter.addNode(var14);
                     timer.method2098();
                  }

                  Object var37 = UserComparator6.mouseRecorder.lock;
                  int var4;
                  int var5;
                  int var6;
                  int var7;
                  int var8;
                  int var9;
                  int var10;
                  int var11;
                  int var12;
                  synchronized(UserComparator6.mouseRecorder.lock) {
                     if (!lockMouseRecorder) {
                        UserComparator6.mouseRecorder.index = 0;
                     } else if (MouseHandler.MouseHandler_lastButton != 0 || UserComparator6.mouseRecorder.index >= 40) {
                        var31 = null;
                        var3 = 0;
                        var4 = 0;
                        var5 = 0;
                        var6 = 0;

                        for(var7 = 0; var7 < UserComparator6.mouseRecorder.index && (var31 == null || var31.packetBuffer.offset - var3 < 246); ++var7) {
                           var4 = var7;
                           var8 = UserComparator6.mouseRecorder.ys[var7];
                           if (var8 < -1) {
                              var8 = -1;
                           } else if (var8 > 65534) {
                              var8 = 65534;
                           }

                           var9 = UserComparator6.mouseRecorder.xs[var7];
                           if (var9 < -1) {
                              var9 = -1;
                           } else if (var9 > 65534) {
                              var9 = 65534;
                           }

                           if (var9 != lastMouseRecordX || var8 != lastMouseRecordY) {
                              if (var31 == null) {
                                 var31 = class330.getPacketBufferNode(ClientPacket.field2559, packetWriter.isaacCipher);
                                 var31.packetBuffer.writeByte(0);
                                 var3 = var31.packetBuffer.offset;
                                 var31.packetBuffer.offset += 2;
                                 var5 = 0;
                                 var6 = 0;
                              }

                              if (-1L != lastMouseRecordTime) {
                                 var10 = var9 - lastMouseRecordX;
                                 var11 = var8 - lastMouseRecordY;
                                 var12 = (int)((UserComparator6.mouseRecorder.millis[var7] - lastMouseRecordTime) / 20L);
                                 var5 = (int)((long)var5 + (UserComparator6.mouseRecorder.millis[var7] - lastMouseRecordTime) % 20L);
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
                                 var31.packetBuffer.writeShort((var12 << 12) + var11 + (var10 << 6));
                              } else if (var12 < 32 && var10 >= -128 && var10 <= 127 && var11 >= -128 && var11 <= 127) {
                                 var10 += 128;
                                 var11 += 128;
                                 var31.packetBuffer.writeByte(var12 + 128);
                                 var31.packetBuffer.writeShort(var11 + (var10 << 8));
                              } else if (var12 < 32) {
                                 var31.packetBuffer.writeByte(var12 + 192);
                                 if (var9 != -1 && var8 != -1) {
                                    var31.packetBuffer.writeInt(var9 | var8 << 16);
                                 } else {
                                    var31.packetBuffer.writeInt(Integer.MIN_VALUE);
                                 }
                              } else {
                                 var31.packetBuffer.writeShort((var12 & 8191) + '\ue000');
                                 if (var9 != -1 && var8 != -1) {
                                    var31.packetBuffer.writeInt(var9 | var8 << 16);
                                 } else {
                                    var31.packetBuffer.writeInt(Integer.MIN_VALUE);
                                 }
                              }

                              ++var6;
                              lastMouseRecordTime = UserComparator6.mouseRecorder.millis[var7];
                           }
                        }

                        if (var31 != null) {
                           var31.packetBuffer.method2479(var31.packetBuffer.offset - var3);
                           var7 = var31.packetBuffer.offset;
                           var31.packetBuffer.offset = var3;
                           var31.packetBuffer.writeByte(var5 / var6);
                           var31.packetBuffer.writeByte(var5 % var6);
                           var31.packetBuffer.offset = var7;
                           packetWriter.addNode(var31);
                        }

                        if (var4 >= UserComparator6.mouseRecorder.index) {
                           UserComparator6.mouseRecorder.index = 0;
                        } else {
                           UserComparator6.mouseRecorder.index -= var4;
                           System.arraycopy(UserComparator6.mouseRecorder.xs, var4, UserComparator6.mouseRecorder.xs, 0, UserComparator6.mouseRecorder.index);
                           System.arraycopy(UserComparator6.mouseRecorder.ys, var4, UserComparator6.mouseRecorder.ys, 0, UserComparator6.mouseRecorder.index);
                           System.arraycopy(UserComparator6.mouseRecorder.millis, var4, UserComparator6.mouseRecorder.millis, 0, UserComparator6.mouseRecorder.index);
                        }
                     }
                  }

                  PacketBufferNode var18;
                  if (MouseHandler.MouseHandler_lastButton == 1 || !class473.mouseCam && MouseHandler.MouseHandler_lastButton == 4 || MouseHandler.MouseHandler_lastButton == 2) {
                     long var16 = MouseHandler.MouseHandler_lastPressedTimeMillis - mouseLastLastPressedTimeMillis;
                     if (var16 > 32767L) {
                        var16 = 32767L;
                     }

                     mouseLastLastPressedTimeMillis = MouseHandler.MouseHandler_lastPressedTimeMillis;
                     var3 = MouseHandler.MouseHandler_lastPressedY;
                     if (var3 < 0) {
                        var3 = 0;
                     } else if (var3 > class262.canvasHeight) {
                        var3 = class262.canvasHeight;
                     }

                     var4 = MouseHandler.MouseHandler_lastPressedX;
                     if (var4 < 0) {
                        var4 = 0;
                     } else if (var4 > GameEngine.canvasWidth) {
                        var4 = GameEngine.canvasWidth;
                     }

                     var5 = (int)var16;
                     if (shouldProcessClick()) {
                         var18 = class330.getPacketBufferNode(ClientPacket.CLICK, packetWriter.isaacCipher);
                         var18.packetBuffer.writeShort((MouseHandler.MouseHandler_lastButton == 2 ? 1 : 0) + (var5 << 1));
                         var18.packetBuffer.writeShort(var4);
                         var18.packetBuffer.writeShort(var3);
                         packetWriter.addNode(var18);
                     }
                  }

                  if (keyHandlerInstance.pressedKeysCount > 0) {
                     var14 = class330.getPacketBufferNode(ClientPacket.field2469, packetWriter.isaacCipher);
                     var14.packetBuffer.writeShort(0);
                     var15 = var14.packetBuffer.offset;
                     long var19 = class96.clockNow();

                     for(var5 = 0; var5 < keyHandlerInstance.pressedKeysCount; ++var5) {
                        long var21 = var19 - timeOfPreviousKeyPress;
                        if (var21 > 16777215L) {
                           var21 = 16777215L;
                        }

                        timeOfPreviousKeyPress = var19;
                        var14.packetBuffer.writeMedium1((int)var21);
                        var14.packetBuffer.writeByte(keyHandlerInstance.field1856[var5]);
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
                     var14 = class330.getPacketBufferNode(ClientPacket.field2541, packetWriter.isaacCipher);
                     var14.packetBuffer.writeShort(camAngleY);
                     var14.packetBuffer.writeShort(camAngleX);
                     packetWriter.addNode(var14);
                  }

                  if (AbstractByteArrayCopier.hasFocus && !hadFocus) {
                     hadFocus = true;
                     var14 = class330.getPacketBufferNode(ClientPacket.field2520, packetWriter.isaacCipher);
                     var14.packetBuffer.writeByte(1);
                     packetWriter.addNode(var14);
                  }

                  if (!AbstractByteArrayCopier.hasFocus && hadFocus) {
                     hadFocus = false;
                     var14 = class330.getPacketBufferNode(ClientPacket.field2520, packetWriter.isaacCipher);
                     var14.packetBuffer.writeByte(0);
                     packetWriter.addNode(var14);
                  }

                  if (class126.worldMap != null) {
                     class126.worldMap.method2329();
                  }

                  Coord.method1686();
                  WorldMapElement.method988();
                  UserComparator8.method689();
                  if (gameState != 30) {
                     return;
                  }

                  for(PendingSpawn var38 = (PendingSpawn)pendingSpawns.last(); var38 != null; var38 = (PendingSpawn)pendingSpawns.previous()) {
                     if (var38.endCycle > 0) {
                        --var38.endCycle;
                     }

                     if (var38.endCycle == 0) {
                        if (var38.objectId < 0 || class195.method1053(var38.objectId, var38.field922)) {
                           class81.addPendingSpawnToScene(var38.plane, var38.type, var38.x, var38.y, var38.objectId, var38.field927, var38.field922, var38.field931);
                           var38.remove();
                        }
                     } else {
                        if (var38.startCycle > 0) {
                           --var38.startCycle;
                        }

                        if (var38.startCycle == 0 && var38.x >= 1 && var38.y >= 1 && var38.x <= 102 && var38.y <= 102 && (var38.id < 0 || class195.method1053(var38.id, var38.objectType))) {
                           class81.addPendingSpawnToScene(var38.plane, var38.type, var38.x, var38.y, var38.id, var38.rotation, var38.objectType, var38.field931);
                           var38.startCycle = -1;
                           if (var38.objectId == var38.id && var38.objectId == -1) {
                              var38.remove();
                           } else if (var38.objectId == var38.id && var38.field927 == var38.rotation && var38.objectType == var38.field922) {
                              var38.remove();
                           }
                        }
                     }
                  }

                  for(var1 = 0; var1 < soundEffectCount; ++var1) {
                     --queuedSoundEffectDelays[var1];
                     if (queuedSoundEffectDelays[var1] >= -10) {
                        SoundEffect var32 = soundEffects[var1];
                        if (var32 == null) {
                           Object var10000 = null;
                           var32 = SoundEffect.readSoundEffect(class426.field3811, soundEffectIds[var1], 0);
                           if (var32 == null) {
                              continue;
                           }

                           queuedSoundEffectDelays[var1] += var32.calculateDelay();
                           soundEffects[var1] = var32;
                        }

                        if (queuedSoundEffectDelays[var1] < 0) {
                           if (soundLocations[var1] != 0) {
                              var4 = (soundLocations[var1] & 255) * 128;
                              var5 = soundLocations[var1] >> 16 & 255;
                              var6 = var5 * 128 + 64 - MusicPatchNode.localPlayer.x;
                              if (var6 < 0) {
                                 var6 = -var6;
                              }

                              var7 = soundLocations[var1] >> 8 & 255;
                              var8 = var7 * 128 + 64 - MusicPatchNode.localPlayer.y;
                              if (var8 < 0) {
                                 var8 = -var8;
                              }

                              var9 = var6 + var8 - 128;
                              if (var9 > var4) {
                                 queuedSoundEffectDelays[var1] = -100;
                                 continue;
                              }

                              if (var9 < 0) {
                                 var9 = 0;
                              }

                              var3 = (var4 - var9) * class20.clientPreferences.getAreaSoundEffectsVolume() / var4;
                           } else {
                              var3 = class20.clientPreferences.getCurrentSoundEffectsVolume();
                           }

                           if (var3 > 0) {
                              RawSound var23 = var32.toRawSound().resample(WorldMapSectionType.decimator);
                              RawPcmStream var24 = RawPcmStream.createRawPcmStream(var23, 100, var3);
                              var24.setNumLoops(queuedSoundEffectLoops[var1] - 1);
                              class130.pcmStreamMixer.addSubStream(var24);
                           }

                           queuedSoundEffectDelays[var1] = -100;
                        }
                     } else {
                        --soundEffectCount;

                        for(var15 = var1; var15 < soundEffectCount; ++var15) {
                           soundEffectIds[var15] = soundEffectIds[var15 + 1];
                           soundEffects[var15] = soundEffects[var15 + 1];
                           queuedSoundEffectLoops[var15] = queuedSoundEffectLoops[var15 + 1];
                           queuedSoundEffectDelays[var15] = queuedSoundEffectDelays[var15 + 1];
                           soundLocations[var15] = soundLocations[var15 + 1];
                        }

                        --var1;
                     }
                  }

                  if (playingJingle && !class4.method8()) {
                     if (class20.clientPreferences.getCurrentMusicVolume() != 0 && currentTrackGroupId != -1) {
                        Message.method355(class399.archive6, currentTrackGroupId, 0, class20.clientPreferences.getCurrentMusicVolume(), false);
                     }

                     playingJingle = false;
                  }

                  ++packetWriter.field1136;
                  if (packetWriter.field1136 > 750) {
                     class349.method1918();
                     return;
                  }

                  class207.method1162();
                  EnumComposition.method1013();
                  int[] var39 = Players.Players_indices;

                  for(var15 = 0; var15 < Players.Players_count; ++var15) {
                     Player var25 = players[var39[var15]];
                     if (var25 != null && var25.overheadTextCyclesRemaining > 0) {
                        --var25.overheadTextCyclesRemaining;
                        if (var25.overheadTextCyclesRemaining == 0) {
                           var25.overheadText = null;
                        }
                     }
                  }

                  for(var15 = 0; var15 < npcCount; ++var15) {
                     var3 = npcIndices[var15];
                     NPC var43 = npcs[var3];
                     if (var43 != null && var43.overheadTextCyclesRemaining > 0) {
                        --var43.overheadTextCyclesRemaining;
                        if (var43.overheadTextCyclesRemaining == 0) {
                           var43.overheadText = null;
                        }
                     }
                  }

                  ++field432;
                  if (mouseCrossColor != 0) {
                     mouseCrossState += 20;
                     if (mouseCrossState >= 400) {
                        mouseCrossColor = 0;
                     }
                  }

                  Widget var40 = MidiPcmStream.mousedOverWidgetIf1;
                  Widget var33 = class130.field1274;
                  MidiPcmStream.mousedOverWidgetIf1 = null;
                  class130.field1274 = null;
                  draggedOnWidget = null;
                  field622 = false;
                  field540 = false;
                  field355 = 0;

                  while(keyHandlerInstance.method1154() && field355 < 128) {
                     if (staffModLevel >= 2 && keyHandlerInstance.getKeyPressed(82) && keyHandlerInstance.field1867 == 66) {
                        StringBuilder var44 = new StringBuilder();

                        Message var41;
                        for(Iterator var46 = Messages.Messages_hashTable.iterator(); var46.hasNext(); var44.append(var41.text).append('\n')) {
                           var41 = (Message)var46.next();
                           if (var41.sender != null && !var41.sender.isEmpty()) {
                              var44.append(var41.sender).append(':');
                           }
                        }

                        String var49 = var44.toString();
                        ScriptFrame.client.method179(var49);
                     } else if (oculusOrbState != 1 || keyHandlerInstance.field1866 <= 0) {
                        field424[field355] = keyHandlerInstance.field1867;
                        field592[field355] = keyHandlerInstance.field1866;
                        ++field355;
                     }
                  }

                  boolean var34 = staffModLevel >= 2;
                  PacketBufferNode var26;
                  if (var34 && keyHandlerInstance.getKeyPressed(82) && keyHandlerInstance.getKeyPressed(81) && mouseWheelRotation != 0) {
                     var4 = MusicPatchNode.localPlayer.plane - mouseWheelRotation;
                     if (var4 < 0) {
                        var4 = 0;
                     } else if (var4 > 3) {
                        var4 = 3;
                     }

                     if (var4 != MusicPatchNode.localPlayer.plane) {
                        var5 = MusicPatchNode.localPlayer.pathX[0] + WorldMapData_0.baseX;
                        var6 = MusicPatchNode.localPlayer.pathY[0] + GameObject.baseY;
                        var26 = class330.getPacketBufferNode(ClientPacket.field2545, packetWriter.isaacCipher);
                        var26.packetBuffer.writeIntIME(0);
                        var26.packetBuffer.writeShortAdd(var5);
                        var26.packetBuffer.writeByteAdd(var4);
                        var26.packetBuffer.writeShortAddLE(var6);
                        packetWriter.addNode(var26);
                     }

                     mouseWheelRotation = 0;
                  }

                  if (MouseHandler.MouseHandler_lastButton == 1) {
                     field590.method1138();
                  }

                  if (rootInterface != -1) {
                     ReflectionCheck.updateRootInterface(rootInterface, 0, 0, GameEngine.canvasWidth, class262.canvasHeight, 0, 0);
                  }

                  ++cycleCntr;

                  while(true) {
                     Widget var42;
                     ScriptEvent var45;
                     Widget var47;
                     do {
                        var45 = (ScriptEvent)field567.removeLast();
                        if (var45 == null) {
                           while(true) {
                              do {
                                 var45 = (ScriptEvent)field568.removeLast();
                                 if (var45 == null) {
                                    while(true) {
                                       do {
                                          var45 = (ScriptEvent)scriptEvents.removeLast();
                                          if (var45 == null) {
                                             while(true) {
                                                class206 var48 = (class206)field569.removeLast();
                                                if (var48 == null) {
                                                   this.menu();
                                                   class36.method198();
                                                   if (clickedWidget != null) {
                                                      this.method389();
                                                   }

                                                   if (Scene.shouldSendWalk()) {
                                                      var4 = Scene.Scene_selectedX;
                                                      var5 = Scene.Scene_selectedY;
                                                      var18 = class330.getPacketBufferNode(ClientPacket.WALK, packetWriter.isaacCipher);
                                                      var18.packetBuffer.writeByte(5);
                                                      var18.packetBuffer.writeShortAddLE(var5 + GameObject.baseY);
                                                      var18.packetBuffer.writeShortLE(var4 + WorldMapData_0.baseX);
                                                      var18.packetBuffer.writeByteSub(keyHandlerInstance.getKeyPressed(82) ? (keyHandlerInstance.getKeyPressed(81) ? 2 : 1) : 0);
                                                      packetWriter.addNode(var18);
                                                      Scene.method1264();
                                                      mouseCrossX = MouseHandler.MouseHandler_lastPressedX;
                                                      mouseCrossY = MouseHandler.MouseHandler_lastPressedY;
                                                      mouseCrossColor = 1;
                                                      mouseCrossState = 0;
                                                      destinationX = var4;
                                                      destinationY = var5;
                                                   }

                                                   if (var40 != MidiPcmStream.mousedOverWidgetIf1) {
                                                      if (var40 != null) {
                                                         class144.invalidateWidget(var40);
                                                      }

                                                      if (MidiPcmStream.mousedOverWidgetIf1 != null) {
                                                         class144.invalidateWidget(MidiPcmStream.mousedOverWidgetIf1);
                                                      }
                                                   }

                                                   if (var33 != class130.field1274 && field515 == field514) {
                                                      if (var33 != null) {
                                                         class144.invalidateWidget(var33);
                                                      }

                                                      if (class130.field1274 != null) {
                                                         class144.invalidateWidget(class130.field1274);
                                                      }
                                                   }

                                                   if (class130.field1274 != null) {
                                                      if (field514 < field515) {
                                                         ++field514;
                                                         if (field514 == field515) {
                                                            class144.invalidateWidget(class130.field1274);
                                                         }
                                                      }
                                                   } else if (field514 > 0) {
                                                      --field514;
                                                   }

                                                   if (oculusOrbState == 0) {
                                                      var4 = MusicPatchNode.localPlayer.x;
                                                      var5 = MusicPatchNode.localPlayer.y;
                                                      if (class33.oculusOrbFocalPointX - var4 < -500 || class33.oculusOrbFocalPointX - var4 > 500 || class144.oculusOrbFocalPointY - var5 < -500 || class144.oculusOrbFocalPointY - var5 > 500) {
                                                         class33.oculusOrbFocalPointX = var4;
                                                         class144.oculusOrbFocalPointY = var5;
                                                      }

                                                      if (var4 != class33.oculusOrbFocalPointX) {
                                                         class33.oculusOrbFocalPointX += (var4 - class33.oculusOrbFocalPointX) / 16;
                                                      }

                                                      if (var5 != class144.oculusOrbFocalPointY) {
                                                         class144.oculusOrbFocalPointY += (var5 - class144.oculusOrbFocalPointY) / 16;
                                                      }

                                                      var6 = class33.oculusOrbFocalPointX >> 7;
                                                      var7 = class144.oculusOrbFocalPointY >> 7;
                                                      var8 = class147.getTileHeight(class33.oculusOrbFocalPointX, class144.oculusOrbFocalPointY, GameEngine.Client_plane);
                                                      var9 = 0;
                                                      if (var6 > 3 && var7 > 3 && var6 < 100 && var7 < 100) {
                                                         for(var10 = var6 - 4; var10 <= var6 + 4; ++var10) {
                                                            for(var11 = var7 - 4; var11 <= var7 + 4; ++var11) {
                                                               var12 = GameEngine.Client_plane;
                                                               if (var12 < 3 && (Tiles.Tiles_renderFlags[1][var10][var11] & 2) == 2) {
                                                                  ++var12;
                                                               }

                                                               int var27 = var8 - Tiles.Tiles_heights[var12][var10][var11];
                                                               if (var27 > var9) {
                                                                  var9 = var27;
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

                                                      if (var10 > field456) {
                                                         field456 += (var10 - field456) / 24;
                                                      } else if (var10 < field456) {
                                                         field456 += (var10 - field456) / 80;
                                                      }

                                                      class96.field1064 = class147.getTileHeight(MusicPatchNode.localPlayer.x, MusicPatchNode.localPlayer.y, GameEngine.Client_plane) - camFollowHeight;
                                                   } else if (oculusOrbState == 1) {
                                                      class324.method1838();
                                                      short var35 = -1;
                                                      if (keyHandlerInstance.getKeyPressed(33)) {
                                                         var35 = 0;
                                                      } else if (keyHandlerInstance.getKeyPressed(49)) {
                                                         var35 = 1024;
                                                      }

                                                      if (keyHandlerInstance.getKeyPressed(48)) {
                                                         if (var35 == 0) {
                                                            var35 = 1792;
                                                         } else if (var35 == 1024) {
                                                            var35 = 1280;
                                                         } else {
                                                            var35 = 1536;
                                                         }
                                                      } else if (keyHandlerInstance.getKeyPressed(50)) {
                                                         if (var35 == 0) {
                                                            var35 = 256;
                                                         } else if (var35 == 1024) {
                                                            var35 = 768;
                                                         } else {
                                                            var35 = 512;
                                                         }
                                                      }

                                                      byte var36 = 0;
                                                      if (keyHandlerInstance.getKeyPressed(35)) {
                                                         var36 = -1;
                                                      } else if (keyHandlerInstance.getKeyPressed(51)) {
                                                         var36 = 1;
                                                      }

                                                      var6 = 0;
                                                      if (var35 >= 0 || var36 != 0) {
                                                         var6 = keyHandlerInstance.getKeyPressed(81) ? oculusOrbSlowedSpeed * 583547559 * 519949591 : oculusOrbNormalSpeed * 1101365113 * -658916663;
                                                         var6 *= 16;
                                                         field595 = var35;
                                                         field398 = var36;
                                                      }

                                                      if (field644 < var6) {
                                                         field644 += var6 / 8;
                                                         if (field644 > var6) {
                                                            field644 = var6;
                                                         }
                                                      } else if (field644 > var6) {
                                                         field644 = field644 * 9 / 10;
                                                      }

                                                      if (field644 > 0) {
                                                         var7 = field644 / 16;
                                                         if (field595 >= 0) {
                                                            var4 = field595 - class125.cameraYaw & 2047;
                                                            var8 = Rasterizer3D.Rasterizer3D_sine[var4];
                                                            var9 = Rasterizer3D.Rasterizer3D_cosine[var4];
                                                            class33.oculusOrbFocalPointX += var7 * var8 / 65536;
                                                            class144.oculusOrbFocalPointY += var9 * var7 / 65536;
                                                         }

                                                         if (field398 != 0) {
                                                            class96.field1064 += var7 * field398;
                                                            if (class96.field1064 > 0) {
                                                               class96.field1064 = 0;
                                                            }
                                                         }
                                                      } else {
                                                         field595 = -1;
                                                         field398 = -1;
                                                      }

                                                      if (keyHandlerInstance.getKeyPressed(13)) {
                                                         Canvas.method92();
                                                      }
                                                   }

                                                   if (MouseHandler.MouseHandler_currentButton == 4 && class473.mouseCam) {
                                                      var4 = MouseHandler.MouseHandler_y - mouseCamClickedY;
                                                      camAngleDX = var4 * 2;
                                                      mouseCamClickedY = var4 != -1 && var4 != 1 ? (mouseCamClickedY + MouseHandler.MouseHandler_y) / 2 : MouseHandler.MouseHandler_y * -360301979 * -1224153235;
                                                      var5 = mouseCamClickedX - MouseHandler.MouseHandler_x;
                                                      camAngleDY = var5 * 2;
                                                      mouseCamClickedX = var5 != -1 && var5 != 1 ? (mouseCamClickedX + MouseHandler.MouseHandler_x) / 2 : MouseHandler.MouseHandler_x * -264773825 * -2063363905;
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

                                                   if (field598) {
                                                      class1.method5();
                                                   } else if (isCameraLocked) {
                                                      if (!field541) {
                                                         var4 = ObjTypeCustomisation.field1471 * 128 + 64;
                                                         var5 = class123.field1209 * 128 + 64;
                                                         var6 = class147.getTileHeight(var4, var5, GameEngine.Client_plane) - class16.field54;
                                                         class133.method777(var4, var6, var5);
                                                      } else if (field535 != null) {
                                                         class36.cameraX = field535.vmethod2321();
                                                         class297.cameraZ = field535.vmethod2319();
                                                         if (field615) {
                                                            class174.cameraY = field535.vmethod2320();
                                                         } else {
                                                            class174.cameraY = class147.getTileHeight(class36.cameraX, class297.cameraZ, GameEngine.Client_plane) - field535.vmethod2320();
                                                         }

                                                         field535.method2322();
                                                      }

                                                      if (!field614) {
                                                         var4 = FontName.field3970 * 128 + 64;
                                                         var5 = MilliClock.field1455 * 128 + 64;
                                                         var6 = class147.getTileHeight(var4, var5, GameEngine.Client_plane) - ScriptFrame.field343;
                                                         var7 = var4 - class36.cameraX;
                                                         var8 = var6 - class174.cameraY;
                                                         var9 = var5 - class297.cameraZ;
                                                         var10 = (int)Math.sqrt((double)(var7 * var7 + var9 * var9));
                                                         var11 = (int)(Math.atan2((double)var8, (double)var10) * 325.9490051269531D) & 2047;
                                                         var12 = (int)(Math.atan2((double)var7, (double)var9) * -325.9490051269531D) & 2047;
                                                         GraphicsObject.method433(var11, var12);
                                                      } else {
                                                         if (field604 != null) {
                                                            WorldMapSectionType.cameraPitch = field604.method2318();
                                                            WorldMapSectionType.cameraPitch = Math.min(Math.max(WorldMapSectionType.cameraPitch, 128), 383);
                                                            field604.method2322();
                                                         }

                                                         if (field617 != null) {
                                                            class125.cameraYaw = field617.method2318() & 2047;
                                                            field617.method2322();
                                                         }
                                                      }
                                                   }

                                                   for(var4 = 0; var4 < 5; ++var4) {
                                                      ++cameraShakeCycle[var4];
                                                   }

                                                   class373.varcs.tryWrite();
                                                   var4 = SecureRandomFuture.method457();
                                                   var5 = GameEngine.keyHandler.getIdleCycles();
                                                   if (var4 > 15000 && var5 > 15000) {
                                                      logoutTimer = 250;
                                                      MouseHandler.MouseHandler_idleCycles = 14500;
                                                      var26 = class330.getPacketBufferNode(ClientPacket.lkjsadlka, packetWriter.isaacCipher);
                                                      packetWriter.addNode(var26);
                                                   }

                                                   World.friendSystem.processFriendUpdates();

                                                   for(var7 = 0; var7 < field649.size(); ++var7) {
                                                      if (class20.method82((Integer)field649.get(var7)) != 2) {
                                                         field649.remove(var7);
                                                         --var7;
                                                      }
                                                   }

                                                   ++packetWriter.pendingWrites;
                                                   if (packetWriter.pendingWrites > 50) {
                                                      var26 = class330.getPacketBufferNode(ClientPacket.field2554, packetWriter.isaacCipher);
                                                      packetWriter.addNode(var26);
                                                   }

                                                   try {
                                                      packetWriter.flush();
                                                   } catch (IOException var28) {
                                                      class349.method1918();
                                                   }

                                                   return;
                                                }

                                                FriendsList.method2138(var48);
                                             }
                                          }

                                          var47 = var45.widget;
                                          if (var47.childIndex < 0) {
                                             break;
                                          }

                                          var42 = class165.getWidget(var47.parentId);
                                       } while(var42 == null || var42.children == null || var47.childIndex >= var42.children.length || var47 != var42.children[var47.childIndex]);

                                       HealthBarUpdate.runScriptEvent(var45);
                                    }
                                 }

                                 var47 = var45.widget;
                                 if (var47.childIndex < 0) {
                                    break;
                                 }

                                 var42 = class165.getWidget(var47.parentId);
                              } while(var42 == null || var42.children == null || var47.childIndex >= var42.children.length || var47 != var42.children[var47.childIndex]);

                              HealthBarUpdate.runScriptEvent(var45);
                           }
                        }

                        var47 = var45.widget;
                        if (var47.childIndex < 0) {
                           break;
                        }

                        var42 = class165.getWidget(var47.parentId);
                     } while(var42 == null || var42.children == null || var47.childIndex >= var42.children.length || var47 != var42.children[var47.childIndex]);

                     HealthBarUpdate.runScriptEvent(var45);
                  }
               }

               var31 = class330.getPacketBufferNode(ClientPacket.field2549, packetWriter.isaacCipher);
               var31.packetBuffer.writeByte(0);
               var3 = var31.packetBuffer.offset;
               class432.performReflectionCheck(var31.packetBuffer);
               var31.packetBuffer.method2479(var31.packetBuffer.offset - var3);
               packetWriter.addNode(var31);
            }
         }
      }
   }

    @ObfuscatedName("ip")
    @ObfuscatedSignature(
            descriptor = "(I)V",
            garbageValue = "-1447416501"
    )
    void resizeJS() {
      int var1 = GameEngine.canvasWidth;
      int var2 = class262.canvasHeight;
      if (super.contentWidth < var1) {
         var1 = super.contentWidth;
      }

      if (super.contentHeight < var2) {
         var2 = super.contentHeight;
      }

      if (class20.clientPreferences != null) {
         try {
            class26.method113(ScriptFrame.client, "resize", new Object[]{GrandExchangeOfferNameComparator.getWindowedMode()});
         } catch (Throwable var4) {
            ;
         }
      }

   }

    @ObfuscatedName("im")
    @ObfuscatedSignature(
            descriptor = "(I)V",
            garbageValue = "1724186279"
    )
    final void drawLoggedIn() {
      int var1;
      if (rootInterface != -1) {
         var1 = rootInterface;
         if (SoundSystem.loadInterface(var1)) {
            TileItem.drawModelComponents(VerticalAlignment.Widget_interfaceComponents[var1], -1);
         }
      }

      for(var1 = 0; var1 < rootWidgetCount; ++var1) {
         if (field573[var1]) {
            field574[var1] = true;
         }

         field519[var1] = field573[var1];
         field573[var1] = false;
      }

      field527 = cycle;
      viewportX = -1;
      viewportY = -1;
      if (rootInterface != -1) {
         rootWidgetCount = 0;
         class13.drawWidgets(rootInterface, 0, 0, GameEngine.canvasWidth, class262.canvasHeight, 0, 0, -1);
      }

      Rasterizer2D.Rasterizer2D_resetClip();
      if (showMouseCross) {
         if (mouseCrossColor == 1) {
            class173.crossSprites[mouseCrossState / 100].drawTransBgAt(mouseCrossX - 8, mouseCrossY - 8);
         }

         if (mouseCrossColor == 2) {
            class173.crossSprites[mouseCrossState / 100 + 4].drawTransBgAt(mouseCrossX - 8, mouseCrossY - 8);
         }
      }

      if (!isMenuOpen) {
         if (viewportX != -1) {
            class85.method498(viewportX, viewportY);
         }
      } else {
         var1 = class192.menuX;
         int var2 = ArchiveLoader.menuY;
         int var3 = DesktopPlatformInfoProvider.menuWidth;
         int var4 = class147.menuHeight;
         int var5 = 6116423;
         Rasterizer2D.Rasterizer2D_fillRectangle(var1, var2, var3, var4, var5);
         Rasterizer2D.Rasterizer2D_fillRectangle(var1 + 1, var2 + 1, var3 - 2, 16, 0);
         Rasterizer2D.Rasterizer2D_drawRectangle(var1 + 1, var2 + 18, var3 - 2, var4 - 19, 0);
         class137.fontBold12.draw("Choose Option", var1 + 3, var2 + 14, var5, -1);
         int var6 = MouseHandler.MouseHandler_x;
         int var7 = MouseHandler.MouseHandler_y;

         for(int var8 = 0; var8 < menuOptionsCount; ++var8) {
            int var9 = var2 + (menuOptionsCount - 1 - var8) * 15 + 31;
            int var10 = 16777215;
            if (var6 > var1 && var6 < var1 + var3 && var7 > var9 - 13 && var7 < var9 + 3) {
               var10 = 16776960;
            }

            class137.fontBold12.draw(Friend.method2152(var8), var1 + 3, var9, var10, 0);
         }

         FriendsChat.method2139(class192.menuX, ArchiveLoader.menuY, DesktopPlatformInfoProvider.menuWidth, class147.menuHeight);
      }

      if (gameDrawingMode == 3) {
         for(var1 = 0; var1 < rootWidgetCount; ++var1) {
            if (field519[var1]) {
               Rasterizer2D.Rasterizer2D_fillRectangleAlpha(rootWidgetXs[var1], rootWidgetYs[var1], rootWidgetWidths[var1], rootWidgetHeights[var1], 16711935, 128);
            } else if (field574[var1]) {
               Rasterizer2D.Rasterizer2D_fillRectangleAlpha(rootWidgetXs[var1], rootWidgetYs[var1], rootWidgetWidths[var1], rootWidgetHeights[var1], 16711680, 128);
            }
         }
      }

      class324.method1839(GameEngine.Client_plane, MusicPatchNode.localPlayer.x, MusicPatchNode.localPlayer.y, field432);
      field432 = 0;
   }

   @ObfuscatedName("jp")
   @ObfuscatedSignature(
      descriptor = "(Leq;II)Z",
      garbageValue = "-1339454052"
   )
   boolean method385(PacketWriter var1, int var2) {
      if (var1.serverPacketLength == 0) {
         UserComparator5.friendsChat = null;
      } else {
         if (UserComparator5.friendsChat == null) {
            UserComparator5.friendsChat = new FriendsChat(class70.loginType, ScriptFrame.client);
         }

         UserComparator5.friendsChat.method2142(var1.packetBuffer, var2);
      }

      field558 = cycleCntr;
      GraphicsObject.ClanChat_inClanChat = true;
      var1.serverPacket = null;
      return true;
   }

   @ObfuscatedName("jt")
   @ObfuscatedSignature(
      descriptor = "(Leq;B)Z",
      garbageValue = "-11"
   )
   boolean method386(PacketWriter var1) {
      if (UserComparator5.friendsChat != null) {
         UserComparator5.friendsChat.method2146(var1.packetBuffer);
      }

      field558 = cycleCntr;
      GraphicsObject.ClanChat_inClanChat = true;
      var1.serverPacket = null;
      return true;
   }

   @ObfuscatedName("ja")
   @ObfuscatedSignature(
      descriptor = "(Leq;I)Z",
      garbageValue = "-1910491091"
   )
   final boolean method391(PacketWriter var1) {
      AbstractSocket var2 = var1.getSocket();
      PacketBuffer var3 = var1.packetBuffer;
      if (var2 == null) {
         return false;
      } else {
         int flags;
         String var31;
         try {
            int graphic;
            if (var1.serverPacket == null) {
               if (var1.field1135) {
                  if (!var2.isAvailable(1)) {
                     return false;
                  }

                  var2.read(var1.packetBuffer.array, 0, 1);
                  var1.field1136 = 0;
                  var1.field1135 = false;
               }

               var3.offset = 0;
               if (var3.method2464()) {
                  if (!var2.isAvailable(1)) {
                     return false;
                  }

                  var2.read(var1.packetBuffer.array, 1, 1);
                  var1.field1136 = 0;
               }

               var1.field1135 = true;
               ServerPacket[] var4 = PacketBufferNode.ServerPacket_values();
               graphic = var3.readSmartByteShortIsaac();
               if (graphic < 0 || graphic >= var4.length) {
                  throw new IOException(graphic + " " + var3.offset);
               }

               var1.serverPacket = var4[graphic];
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
            var1.field1136 = 0;
            timer.method2095();
            var1.field1133 = var1.field1139;
            var1.field1139 = var1.field1138;
            var1.field1138 = var1.serverPacket;
            int var20;
            if (ServerPacket.field2608 == var1.serverPacket) {
               var20 = var3.readInt();
               graphic = var3.readInt();
               flags = NetCache.getGcDuration();
               PacketBufferNode var57 = class330.getPacketBufferNode(ClientPacket.wawdawdad, packetWriter.isaacCipher);
               var57.packetBuffer.writeByteAdd(GameEngine.fps);
               var57.packetBuffer.writeByteNeg(flags);
               var57.packetBuffer.writeIntME(var20);
               var57.packetBuffer.writeIntME(graphic);
               packetWriter.addNode(var57);
               var1.serverPacket = null;
               return true;
            }

            long var9;
            int var13;
            long var21;
            long var23;
            String var25;
            boolean var58;
            int var65;
            byte var66;
            if (ServerPacket.field2599 == var1.serverPacket) {
               var66 = var3.readByte();
               var21 = (long)var3.readUnsignedShort();
               var23 = (long)var3.readMedium();
               var9 = var23 + (var21 << 32);
               var58 = false;
               ClanChannel var59 = var66 >= 0 ? currentClanChannels[var66] : MouseHandler.guestClanChannel;
               if (var59 == null) {
                  var58 = true;
               } else {
                  for(var13 = 0; var13 < 100; ++var13) {
                     if (field652[var13] == var9) {
                        var58 = true;
                        break;
                     }
                  }
               }

               if (!var58) {
                  field652[field588] = var9;
                  field588 = (field588 + 1) % 100;
                  var25 = SceneTilePaint.readString(var3);
                  var65 = var66 >= 0 ? 43 : 46;
                  class136.addChatMessage(var65, "", var25, var59.name);
               }

               var1.serverPacket = null;
               return true;
            }

            int var8;
            int var26;
            if (ServerPacket.field2580 == var1.serverPacket) {
               var20 = var3.readIntME();
               graphic = var3.readIntIME();
               flags = var3.readUnsignedShortAddLE();
               if (flags == 65535) {
                  flags = -1;
               }

               var26 = var3.readUnsignedShortAdd();
               if (var26 == 65535) {
                  var26 = -1;
               }

               for(var8 = var26; var8 <= flags; ++var8) {
                  var9 = ((long)var20 << 32) + (long)var8;
                  Node var69 = widgetFlags.get(var9);
                  if (var69 != null) {
                     var69.remove();
                  }

                  widgetFlags.put(new IntegerNode(graphic), var9);
               }

               var1.serverPacket = null;
               return true;
            }

            Widget var54;
            if (ServerPacket.field2649 == var1.serverPacket) {
               var20 = var3.readSignedShortAdd();
               graphic = var3.readIntLE();
               flags = var3.method2533();
               var54 = class165.getWidget(graphic);
               if (var20 != var54.rawX || flags != var54.rawY || var54.xAlignment != 0 || var54.yAlignment != 0) {
                  var54.rawX = var20;
                  var54.rawY = flags;
                  var54.xAlignment = 0;
                  var54.yAlignment = 0;
                  class144.invalidateWidget(var54);
                  this.alignWidget(var54);
                  if (var54.type == 0) {
                     WallDecoration.revalidateWidgetScroll(VerticalAlignment.Widget_interfaceComponents[graphic >> 16], var54, false);
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2670 == var1.serverPacket) {
               var20 = var3.readUnsignedByteAdd();
               graphic = var3.readUnsignedByteNeg();
               flags = var3.readInt();
               var54 = class165.getWidget(flags);
               ChatChannel.method470(var54, var20, graphic);
               class144.invalidateWidget(var54);
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2648 == var1.serverPacket) {
               var20 = var3.readUnsignedByte();
               class293.forceDisconnect(var20);
               var1.serverPacket = null;
               return false;
            }

            if (ServerPacket.field2646 == var1.serverPacket) {
               var20 = var3.readUnsignedShortAddLE();
               graphic = var3.readUnsignedShort();
               flags = var3.readIntME();
               var54 = class165.getWidget(flags);
               var54.rotationKey = graphic + (var20 << 16);
               var1.serverPacket = null;
               return true;
            }

            NPC var55;
            if (ServerPacket.field2672 == var1.serverPacket) {
               var20 = var3.readUnsignedShort();
               var55 = npcs[var20];
               flags = var3.readUnsignedShort();
               graphic = var3.readInt();
               if (var55 != null) {
                  var55.updateSpotAnimation(0, flags, graphic >> 16, graphic & '\uffff');
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2634 == var1.serverPacket) {
               EnumComposition.processZoneOperation(ZoneOperation.field2572);
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2691 == var1.serverPacket) {
               var1.serverPacket = null;
               return true;
            }

            NPC var71;
            if (ServerPacket.field2680 == var1.serverPacket) {
               var20 = var3.readIntLE();
               graphic = var3.readUnsignedShortAdd();
               short var64 = (short)var3.method2533();
               var26 = var3.readUnsignedByteNeg();
               var71 = npcs[graphic];
               if (var71 != null) {
                  var71.method597(var26, var20, var64);
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2584 == var1.serverPacket) {
               var20 = var3.readUnsignedShort();
               Player var56;
               if (var20 == localPlayerIndex) {
                  var56 = MusicPatchNode.localPlayer;
               } else {
                  var56 = players[var20];
               }

               graphic = var3.readUnsignedShort();
               flags = var3.readInt();
               if (var56 != null) {
                  var56.updateSpotAnimation(0, graphic, flags >> 16, flags & '\uffff');
               }

               var1.serverPacket = null;
               return true;
            }

            boolean var67;
            String var79;
            if (ServerPacket.field2623 == var1.serverPacket) {
               var20 = var3.readUShortSmart();
               var67 = var3.readUnsignedByte() == 1;
               var79 = "";
               boolean var82 = false;
               if (var67) {
                  var79 = var3.readStringCp1252NullTerminated();
                  if (World.friendSystem.isIgnored(new Username(var79, class70.loginType))) {
                     var82 = true;
                  }
               }

               String var74 = var3.readStringCp1252NullTerminated();
               if (!var82) {
                  UserComparator5.addGameMessage(var20, var79, var74);
               }

               var1.serverPacket = null;
               return true;
            }

            Widget var29;
            if (ServerPacket.field2693 == var1.serverPacket) {
               var20 = var3.readIntIME();
               graphic = var3.readIntIME();
               var29 = class165.getWidget(var20);
               class282.method1591(var29, graphic);
               class144.invalidateWidget(var29);
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2601 == var1.serverPacket) {
               var20 = var3.readInt();
               var67 = var3._readUnsignedByteSub() == 1;
               var29 = class165.getWidget(var20);
               if (var67 != var29.isHidden) {
                  var29.isHidden = var67;
                  class144.invalidateWidget(var29);
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2641 == var1.serverPacket) {
               return this.method386(var1);
            }

            if (ServerPacket.field2665 == var1.serverPacket) {
               EnumComposition.processZoneOperation(ZoneOperation.field2567);
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2619 == var1.serverPacket) {
               var20 = var3.readIntLE();
               graphic = var3.readUnsignedShort();
               var29 = class165.getWidget(var20);
               if (var29.modelType != 1 || graphic != var29.modelId) {
                  var29.modelType = 1;
                  var29.modelId = graphic;
                  class144.invalidateWidget(var29);
               }

               var1.serverPacket = null;
               return true;
            }

            int var10;
            int var30;
            if (ServerPacket.field2690 == var1.serverPacket) {
               isCameraLocked = true;
               field598 = false;
               field541 = true;
               ObjTypeCustomisation.field1471 = var3.readUnsignedByte();
               class123.field1209 = var3.readUnsignedByte();
               var20 = var3.readUnsignedShort();
               graphic = var3.readUnsignedShort();
               field615 = var3.readBoolean();
               flags = var3.readUnsignedByte();
               var26 = ObjTypeCustomisation.field1471 * 128 + 64;
               var8 = class123.field1209 * 128 + 64;
               boolean var87 = false;
               boolean var62 = false;
               if (field615) {
                  var30 = class174.cameraY;
                  var10 = class147.getTileHeight(var26, var8, GameEngine.Client_plane) - var20;
               } else {
                  var30 = class147.getTileHeight(class36.cameraX, class297.cameraZ, GameEngine.Client_plane) - class174.cameraY;
                  var10 = var20;
               }

               field535 = new class453(class36.cameraX, class297.cameraZ, var30, var26, var8, var10, graphic, flags);
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2644 == var1.serverPacket) {
               return this.method385(var1, 2);
            }

            if (ServerPacket.field2698 == var1.serverPacket) {
               FontName.field3968 = var3.readUnsignedByteNeg();
               class9.field28 = var3.readUnsignedByte();

               while(var3.offset < var1.serverPacketLength) {
                  var20 = var3.readUnsignedByte();
                  ZoneOperation var88 = Varcs.method641()[var20];
                  EnumComposition.processZoneOperation(var88);
               }

               var1.serverPacket = null;
               return true;
            }

            Widget var78;
            if (ServerPacket.field2581 == var1.serverPacket) {
               var20 = var3.readIntLE();
               var78 = class165.getWidget(var20);
               var78.modelType = 3;
               var78.modelId = MusicPatchNode.localPlayer.appearance.getChatHeadId();
               class144.invalidateWidget(var78);
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2684 == var1.serverPacket) {
               var20 = var3.readUnsignedShort();
               if (var20 == 65535) {
                  var20 = -1;
               }

               rootInterface = var20;
               this.resizeRoot(false);
               ZoneOperation.Widget_resetModelFrames(var20);
               class12.runWidgetOnLoadListener(rootInterface);

               for(graphic = 0; graphic < 100; ++graphic) {
                  field573[graphic] = true;
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2669 == var1.serverPacket) {
               World.friendSystem.readUpdate(var3, var1.serverPacketLength);
               field557 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2626 == var1.serverPacket) {
               minimapState = var3.readUnsignedByte();
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2588 == var1.serverPacket) {
               EnumComposition.processZoneOperation(ZoneOperation.field2571);
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2695 == var1.serverPacket) {
               Players.varclan = null;
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2618 == var1.serverPacket) {
               EnumComposition.processZoneOperation(ZoneOperation.field2570);
               var1.serverPacket = null;
               return true;
            }

            String var49;
            if (ServerPacket.field2592 == var1.serverPacket) {
               var49 = var3.readStringCp1252NullTerminated();
               Object[] var86 = new Object[var49.length() + 1];

               for(flags = var49.length() - 1; flags >= 0; --flags) {
                  if (var49.charAt(flags) == 's') {
                     var86[flags + 1] = var3.readStringCp1252NullTerminated();
                  } else {
                     var86[flags + 1] = new Integer(var3.readInt());
                  }
               }

               var86[0] = new Integer(var3.readInt());
               ScriptEvent var89 = new ScriptEvent();
               var89.args = var86;
               HealthBarUpdate.runScriptEvent(var89);
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2666 == var1.serverPacket) {
               GrandExchangeEvents.updatePlayers(var3, var1.serverPacketLength);
               class85.method499();
               var1.serverPacket = null;
               return true;
            }

            int var15;
            int var16;
            GameObject var39;
            String var40;
            if (ServerPacket.field2628 == var1.serverPacket) {
               var66 = var3.readByte();
               var31 = var3.readStringCp1252NullTerminated();
               long var32 = (long)var3.readUnsignedShort();
               long var34 = (long)var3.readMedium();
               PlayerType var91 = (PlayerType)StructComposition.findEnumerated(StudioGame.PlayerType_values(), var3.readUnsignedByte());
               long var37 = var34 + (var32 << 32);
               boolean var61 = false;
               var39 = null;
               ClanChannel var95 = var66 >= 0 ? currentClanChannels[var66] : MouseHandler.guestClanChannel;
               if (var95 == null) {
                  var61 = true;
               } else {
                  var15 = 0;

                  while(true) {
                     if (var15 >= 100) {
                        if (var91.isUser && World.friendSystem.isIgnored(new Username(var31, class70.loginType))) {
                           var61 = true;
                        }
                        break;
                     }

                     if (field652[var15] == var37) {
                        var61 = true;
                        break;
                     }

                     ++var15;
                  }
               }

               if (!var61) {
                  field652[field588] = var37;
                  field588 = (field588 + 1) % 100;
                  var40 = AbstractFont.escapeBrackets(SceneTilePaint.readString(var3));
                  var16 = var66 >= 0 ? 41 : 44;
                  if (var91.modIcon != -1) {
                     class136.addChatMessage(var16, ArchiveDiskActionHandler.addImageTag(var91.modIcon) + var31, var40, var95.name);
                  } else {
                     class136.addChatMessage(var16, var31, var40, var95.name);
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2591 == var1.serverPacket) {
               var3.offset += 28;
               if (var3.checkCrc()) {
                  UserComparator4.method681(var3, var3.offset - 28);
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2622 == var1.serverPacket) {
               class127.loadRegions(false, var1.packetBuffer);
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2583 == var1.serverPacket) {
               var20 = var3.readUnsignedByte();
               if (var3.readUnsignedByte() == 0) {
                  grandExchangeOffers[var20] = new GrandExchangeOffer();
                  var3.offset += 18;
               } else {
                  --var3.offset;
                  grandExchangeOffers[var20] = new GrandExchangeOffer(var3, false);
               }

               field629 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2637 == var1.serverPacket) {
               var20 = var3.readSignedShortAddLE();
               graphic = var3.readIntIME();
               var29 = class165.getWidget(graphic);
               if (var20 != var29.sequenceId || var20 == -1) {
                  var29.sequenceId = var20;
                  var29.modelFrame = 0;
                  var29.modelFrameCycle = 0;
                  class144.invalidateWidget(var29);
               }

               var1.serverPacket = null;
               return true;
            }

            boolean var68;
            if (ServerPacket.REBUILD_REGION_NORMAL == var1.serverPacket) {
               var68 = var3.readUnsignedByte() == 1;
               graphic = var3.readInt();
               var29 = class165.getWidget(graphic);
               SecureRandomCallable.method476(var29, MusicPatchNode.localPlayer.appearance, var68);
               class144.invalidateWidget(var29);
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2633 == var1.serverPacket) {
               var20 = var3.readUnsignedShortLE();
               graphic = var3.readIntIME();
               flags = var20 >> 10 & 31;
               var26 = var20 >> 5 & 31;
               var8 = var20 & 31;
               var30 = (var26 << 11) + (flags << 19) + (var8 << 3);
               Widget var90 = class165.getWidget(graphic);
               if (var30 != var90.color) {
                  var90.color = var30;
                  class144.invalidateWidget(var90);
               }

               var1.serverPacket = null;
               return true;
            }

            int var11;
            int var96;
            if (ServerPacket.field2609 == var1.serverPacket) {
               var15 = var3.readUnsignedShort();
               var65 = var3.readUnsignedByteNeg() * 4;
               int var18 = var3._readUnsignedByteSub();
               byte var83 = var3.readUnsignedByteSub();
               var13 = var3._readUnsignedByteSub() * 4;
               var96 = var3.readUnsignedShort();
               var16 = var3.readUnsignedShortAddLE();
               var11 = var3.readSignedMedium_1();
               int var17 = var3.readUnsignedByte();
               flags = var3.method2513();
               var20 = flags >> 16;
               graphic = flags >> 8 & 255;
               var26 = var20 + (flags >> 4 & 7);
               var8 = graphic + (flags & 7);
               byte var60 = var3.readByte();
               var30 = var83 + var26;
               var10 = var60 + var8;
               if (var26 >= 0 && var8 >= 0 && var26 < 104 && var8 < 104 && var30 >= 0 && var10 >= 0 && var30 < 104 && var10 < 104 && var96 != 65535) {
                  var26 = var26 * 128 + 64;
                  var8 = var8 * 128 + 64;
                  var30 = var30 * 128 + 64;
                  var10 = var10 * 128 + 64;
                  Projectile var19 = new Projectile(var96, GameEngine.Client_plane, var26, var8, class147.getTileHeight(var26, var8, GameEngine.Client_plane) - var13, var15 + cycle, var16 + cycle, var17, var18, var11, var65);
                  var19.setDestination(var30, var10, class147.getTileHeight(var30, var10, GameEngine.Client_plane) - var65, var15 + cycle);
                  projectiles.addFirst(var19);
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.LOGOUT_TRANSFER == var1.serverPacket) {
               EnumComposition.processZoneOperation(ZoneOperation.field2564);
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.UPDATE_UID192 == var1.serverPacket) {
               World.friendSystem.method411();
               field557 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            InterfaceParent var7;
            long var42;
            if (ServerPacket.field2686 == var1.serverPacket) {
               var20 = var3.offset + var1.serverPacketLength;
               graphic = var3.readUnsignedShort();
               if (graphic == 65535) {
                  graphic = -1;
               }

               flags = var3.readUnsignedShort();
               if (graphic != rootInterface) {
                  rootInterface = graphic;
                  this.resizeRoot(false);
                  ZoneOperation.Widget_resetModelFrames(rootInterface);
                  class12.runWidgetOnLoadListener(rootInterface);

                  for(var26 = 0; var26 < 100; ++var26) {
                     field573[var26] = true;
                  }
               }

               InterfaceParent var36;
               for(; flags-- > 0; var36.field848 = true) {
                  var26 = var3.readInt();
                  var8 = var3.readUnsignedShort();
                  var30 = var3.readUnsignedByte();
                  var36 = (InterfaceParent)interfaceParents.get((long)var26);
                  if (var36 != null && var8 != var36.group) {
                     class357.closeInterface(var36, true);
                     var36 = null;
                  }

                  if (var36 == null) {
                     var36 = AttackOption.ifOpenSub(var26, var8, var30);
                  }
               }

               for(var7 = (InterfaceParent)interfaceParents.first(); var7 != null; var7 = (InterfaceParent)interfaceParents.next()) {
                  if (var7.field848) {
                     var7.field848 = false;
                  } else {
                     class357.closeInterface(var7, true);
                  }
               }

               widgetFlags = new NodeHashTable(512);

               while(var3.offset < var20) {
                  var26 = var3.readInt();
                  var8 = var3.readUnsignedShort();
                  var30 = var3.readUnsignedShort();
                  var10 = var3.readInt();

                  for(var11 = var8; var11 <= var30; ++var11) {
                     var42 = ((long)var26 << 32) + (long)var11;
                     widgetFlags.put(new IntegerNode(var10), var42);
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2650 == var1.serverPacket) {
               var20 = var3.readUnsignedByte();
               graphic = var3.readUnsignedByte();
               flags = var3.readUnsignedByte();
               var26 = var3.readUnsignedByte();
               field620[var20] = true;
               field621[var20] = graphic;
               field643[var20] = flags;
               field499[var20] = var26;
               cameraShakeCycle[var20] = 0;
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2668 == var1.serverPacket) {
               var20 = var3.readUnsignedShortAdd();
               flags = var3.readUnsignedByteAdd();
               graphic = var3.readUnsignedShortAdd();
               if (graphic == 65535) {
                  graphic = -1;
               }

               var55 = npcs[var20];
               if (var55 != null) {
                  if (graphic == var55.sequence && graphic != -1) {
                     var8 = ItemContainer.SequenceDefinition_get(graphic).replyMode;
                     if (var8 == 1) {
                        var55.sequenceFrame = 0;
                        var55.sequenceFrameCycle = 0;
                        var55.sequenceDelay = flags;
                        var55.currentSequenceFrameIndex = 0;
                     } else if (var8 == 2) {
                        var55.currentSequenceFrameIndex = 0;
                     }
                  } else if (graphic == -1 || var55.sequence == -1 || ItemContainer.SequenceDefinition_get(graphic).forcedPriority >= ItemContainer.SequenceDefinition_get(var55.sequence).forcedPriority) {
                     var55.sequence = graphic;
                     var55.sequenceFrame = 0;
                     var55.sequenceFrameCycle = 0;
                     var55.sequenceDelay = flags;
                     var55.currentSequenceFrameIndex = 0;
                     var55.field1006 = var55.pathLength;
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2652 == var1.serverPacket) {
               UserComparator3.readReflectionCheck(var3, var1.serverPacketLength);
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2632 == var1.serverPacket) {
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

            if (ServerPacket.field2605 == var1.serverPacket) {
               FontName.field3968 = var3._readUnsignedByteSub();
               class9.field28 = var3.readUnsignedByteNeg();
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2600 == var1.serverPacket) {
               EnumComposition.processZoneOperation(ZoneOperation.field2568);
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2630 == var1.serverPacket) {
               var68 = var3.readBoolean();
               if (var68) {
                  if (class132.field1277 == null) {
                     class132.field1277 = new class354();
                  }
               } else {
                  class132.field1277 = null;
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2681 == var1.serverPacket) {
               field560 = cycleCntr;
               var66 = var3.readByte();
               class156 var84 = new class156(var3);
               ClanChannel var85;
               if (var66 >= 0) {
                  var85 = currentClanChannels[var66];
               } else {
                  var85 = MouseHandler.guestClanChannel;
               }

               var84.method888(var85);
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2596 == var1.serverPacket) {
               var20 = var3.readInt();
               graphic = var3.readUnsignedShortAdd();
               Varps.Varps_temp[graphic] = var20;
               if (Varps.Varps_main[graphic] != var20) {
                  Varps.Varps_main[graphic] = var20;
               }

               class7.changeGameOptions(graphic);
               changedVarps[++changedVarpCount - 1 & 31] = graphic;
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2678 == var1.serverPacket) {
               var20 = var3.readInt();
               graphic = var3._readUnsignedByteSub();
               var29 = class165.getWidget(var20);
               class162.method911(var29, MusicPatchNode.localPlayer.appearance.field2840, graphic);
               class144.invalidateWidget(var29);
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2683 == var1.serverPacket) {
               field598 = false;
               isCameraLocked = false;
               field541 = false;
               field614 = false;
               FontName.field3970 = 0;
               MilliClock.field1455 = 0;
               ScriptFrame.field343 = 0;
               field615 = false;
               Archive.field3467 = 0;
               WorldMapElement.field1503 = 0;
               class138.field1314 = 0;
               KeyHandler.field81 = 0;
               ObjTypeCustomisation.field1471 = 0;
               class123.field1209 = 0;
               class16.field54 = 0;
               field535 = null;
               field604 = null;
               field617 = null;

               for(var20 = 0; var20 < 5; ++var20) {
                  field620[var20] = false;
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2629 == var1.serverPacket) {
               var20 = var3.readUnsignedShortLE();
               if (var20 == 65535) {
                  var20 = -1;
               }

               class1.playSong(var20);
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2659 == var1.serverPacket) {
               var20 = var3.readMedium();
               graphic = var3.readUnsignedShortLE();
               if (graphic == 65535) {
                  graphic = -1;
               }

               CollisionMap.playJingle(graphic, var20);
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2676 == var1.serverPacket) {
               var20 = var3.readIntIME();
               graphic = var3.readIntLE();
               flags = var3.readUnsignedShortAddLE();
               if (flags == 65535) {
                  flags = -1;
               }

               var54 = class165.getWidget(var20);
               ItemComposition var72;
               if (!var54.isIf3) {
                  if (flags == -1) {
                     var54.modelType = 0;
                     var1.serverPacket = null;
                     return true;
                  }

                  var72 = HealthBarUpdate.ItemDefinition_get(flags);
                  var54.modelType = 4;
                  var54.modelId = flags;
                  var54.modelAngleX = var72.xan2d;
                  var54.modelAngleY = var72.yan2d;
                  var54.modelZoom = var72.zoom2d * 100 / graphic;
                  class144.invalidateWidget(var54);
               } else {
                  var54.itemId = flags;
                  var54.itemQuantity = graphic;
                  var72 = HealthBarUpdate.ItemDefinition_get(flags);
                  var54.modelAngleX = var72.xan2d;
                  var54.modelAngleY = var72.yan2d;
                  var54.modelAngleZ = var72.zan2d;
                  var54.modelOffsetX = var72.offsetX2d;
                  var54.modelOffsetY = var72.offsetY2d;
                  var54.modelZoom = var72.zoom2d;
                  if (var72.isStackable == 1) {
                     var54.itemQuantityMode = 1;
                  } else {
                     var54.itemQuantityMode = 2;
                  }

                  if (var54.modelRotation > 0) {
                     var54.modelZoom = var54.modelZoom * 32 / var54.modelRotation;
                  } else if (var54.rawWidth > 0) {
                     var54.modelZoom = var54.modelZoom * 32 / var54.rawWidth;
                  }

                  class144.invalidateWidget(var54);
               }

               var1.serverPacket = null;
               return true;
            }

            boolean var41;
            if (ServerPacket.field2631 == var1.serverPacket) {
               isCameraLocked = true;
               field598 = false;
               field541 = true;
               ObjTypeCustomisation.field1471 = var3.readUnsignedByte();
               class123.field1209 = var3.readUnsignedByte();
               var20 = var3.readUnsignedShort();
               graphic = var3.readUnsignedByte() * 128 + 64;
               flags = var3.readUnsignedByte() * 128 + 64;
               var26 = var3.readUnsignedShort();
               field615 = var3.readBoolean();
               var8 = var3.readUnsignedByte();
               var30 = ObjTypeCustomisation.field1471 * 128 + 64;
               var10 = class123.field1209 * 128 + 64;
               var58 = false;
               var41 = false;
               if (field615) {
                  var11 = class174.cameraY;
                  var96 = class147.getTileHeight(var30, var10, GameEngine.Client_plane) - var20;
               } else {
                  var11 = class147.getTileHeight(class36.cameraX, class297.cameraZ, GameEngine.Client_plane) - class174.cameraY;
                  var96 = var20;
               }

               field535 = new class452(class36.cameraX, class297.cameraZ, var11, var30, var10, var96, graphic, flags, var26, var8);
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.PLAYER_INFO == var1.serverPacket) {
               if (rootInterface != -1) {
                  class127.runIntfCloseListeners(rootInterface, 0);
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.NPC_INFO_SMALL == var1.serverPacket && isCameraLocked) {
               field598 = true;
               field614 = false;
               field541 = false;

               for(var20 = 0; var20 < 5; ++var20) {
                  field620[var20] = false;
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.ENTER_FREECAM == var1.serverPacket) {
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

            if (ServerPacket.MESSAGE_PRIVATE == var1.serverPacket) {
               isCameraLocked = true;
               field598 = false;
               field614 = true;
               var20 = var3.readShort();
               graphic = var3.readShort();
               flags = class18.method77(graphic + WorldMapSectionType.cameraPitch & 2027);
               var26 = var20 + class125.cameraYaw;
               var8 = var3.readUnsignedShort();
               var30 = var3.readUnsignedByte();
               field604 = new class454(WorldMapSectionType.cameraPitch, flags, var8, var30);
               field617 = new class454(class125.cameraYaw, var26, var8, var30);
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.SPOTANIM_SPECIFIC == var1.serverPacket) {
               Players.varclan = new class429(MenuAction.HitSplatDefinition_cached);
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.TRIGGER_ONDIALOGABORT == var1.serverPacket) {
               byte[] var53 = new byte[var1.serverPacketLength];
               var3.method2459(var53, 0, var53.length);
               Buffer var81 = new Buffer(var53);
               var79 = var81.readStringCp1252NullTerminated();
               Ignored.openURL(var79, true, false);
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2614 == var1.serverPacket) {
               isCameraLocked = true;
               field598 = false;
               field541 = false;
               ObjTypeCustomisation.field1471 = var3.readUnsignedByte();
               class123.field1209 = var3.readUnsignedByte();
               class16.field54 = var3.readUnsignedShort();
               KeyHandler.field81 = var3.readUnsignedByte();
               class138.field1314 = var3.readUnsignedByte();
               if (class138.field1314 >= 100) {
                  class36.cameraX = ObjTypeCustomisation.field1471 * 128 + 64;
                  class297.cameraZ = class123.field1209 * 128 + 64;
                  class174.cameraY = class147.getTileHeight(class36.cameraX, class297.cameraZ, GameEngine.Client_plane) - class16.field54;
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2647 == var1.serverPacket) {
               class36.method199();
               var66 = var3.readByte();
               class142 var80 = new class142(var3);
               ClanSettings var75;
               if (var66 >= 0) {
                  var75 = currentClanSettings[var66];
               } else {
                  var75 = ItemComposition.guestClanSettings;
               }

               var80.method807(var75);
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.NPC_INFO_LARGE == var1.serverPacket) {
               var20 = var3.readUnsignedShort();
               graphic = var3.readUnsignedByte();
               flags = var3.readUnsignedShort();
               class133.queueSoundEffect(var20, graphic, flags);
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2620 == var1.serverPacket) {
               var20 = var3.readInt();
               if (var20 != field444) {
                  field444 = var20;
                  class173.method955();
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.UPDATE_ZONE_PARTIAL_FOLLOWS == var1.serverPacket) {
               ClientPacket.process();
               runEnergy = var3.readUnsignedShort();
               field433 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.MESSAGE_PRIVATE_ECHO == var1.serverPacket) {
               var20 = var3.readIntIME();
               graphic = var3.readUnsignedShortAddLE();
               var29 = class165.getWidget(var20);
               if (var29 != null && var29.type == 0) {
                  if (graphic > var29.scrollHeight - var29.height) {
                     graphic = var29.scrollHeight - var29.height;
                  }

                  if (graphic < 0) {
                     graphic = 0;
                  }

                  if (graphic != var29.scrollY) {
                     var29.scrollY = graphic;
                     class144.invalidateWidget(var29);
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.IF_SETNPCHEAD == var1.serverPacket) {
               var49 = var3.readStringCp1252NullTerminated();
               graphic = var3.readIntIME();
               var29 = class165.getWidget(graphic);
               if (!var49.equals(var29.text)) {
                  var29.text = var49;
                  class144.invalidateWidget(var29);
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.UPDATE_INV_CLEAR == var1.serverPacket) {
               class36.method199();
               var66 = var3.readByte();
               if (var1.serverPacketLength == 1) {
                  if (var66 >= 0) {
                     currentClanSettings[var66] = null;
                  } else {
                     ItemComposition.guestClanSettings = null;
                  }

                  var1.serverPacket = null;
                  return true;
               }

               if (var66 >= 0) {
                  currentClanSettings[var66] = new ClanSettings(var3);
               } else {
                  ItemComposition.guestClanSettings = new ClanSettings(var3);
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2696 == var1.serverPacket) {
               var26 = var3.readUnsignedByte();
               var20 = var3.readUnsignedShort();
               var71 = npcs[var20];
               flags = var3.readUnsignedShort();
               graphic = var3.readInt();
               if (var71 != null) {
                  var71.updateSpotAnimation(var26, flags, graphic >> 16, graphic & '\uffff');
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.MESSAGE_CLANCHANNEL_SYSTEM == var1.serverPacket) {
               for(var20 = 0; var20 < Varps.Varps_main.length; ++var20) {
                  if (Varps.Varps_temp[var20] != Varps.Varps_main[var20]) {
                     Varps.Varps_main[var20] = Varps.Varps_temp[var20];
                     class7.changeGameOptions(var20);
                     changedVarps[++changedVarpCount - 1 & 31] = var20;
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2657 == var1.serverPacket) {
               var20 = var3.readInt();
               graphic = var3.readUnsignedShort();
               if (var20 < -70000) {
                  graphic += 32768;
               }

               if (var20 >= 0) {
                  var29 = class165.getWidget(var20);
               } else {
                  var29 = null;
               }

               for(; var3.offset < var1.serverPacketLength; class373.itemContainerSetItem(graphic, var26, var8 - 1, var30)) {
                  var26 = var3.readUShortSmart();
                  var8 = var3.readUnsignedShort();
                  var30 = 0;
                  if (var8 != 0) {
                     var30 = var3.readUnsignedByte();
                     if (var30 == 255) {
                        var30 = var3.readInt();
                     }
                  }

                  if (var29 != null && var26 >= 0 && var26 < var29.itemIds.length) {
                     var29.itemIds[var26] = var8;
                     var29.field3007[var26] = var30;
                  }
               }

               if (var29 != null) {
                  class144.invalidateWidget(var29);
               }

               ClientPacket.process();
               changedItemContainers[++changedItemContainersCount - 1 & 31] = graphic & 32767;
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.CLANCHANNEL_DELTA == var1.serverPacket) {
               class31.logOut();
               var1.serverPacket = null;
               return false;
            }

            if (ServerPacket.field2642 == var1.serverPacket) {
               return this.method385(var1, 1);
            }

            if (ServerPacket.field2689 == var1.serverPacket) {
               isCameraLocked = true;
               field598 = false;
               field614 = true;
               var20 = class425.method2262(var3.readShort() & 2027);
               graphic = class18.method77(var3.readShort() & 2027);
               flags = var3.readUnsignedShort();
               var26 = var3.readUnsignedByte();
               field604 = new class454(WorldMapSectionType.cameraPitch, graphic, flags, var26);
               field617 = new class454(class125.cameraYaw, var20, flags, var26);
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2694 == var1.serverPacket) {
               ClientPacket.process();
               weight = var3.readShort();
               field433 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.IF_SETOBJECT == var1.serverPacket) {
               EnumComposition.processZoneOperation(ZoneOperation.field2569);
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.TRADING_POST_RESULTS == var1.serverPacket) {
               FontName.field3968 = var3.readUnsignedByte();
               class9.field28 = var3.readUnsignedByteAdd();

               for(var20 = class9.field28; var20 < class9.field28 + 8; ++var20) {
                  for(graphic = FontName.field3968; graphic < FontName.field3968 + 8; ++graphic) {
                     if (groundItems[GameEngine.Client_plane][var20][graphic] != null) {
                        groundItems[GameEngine.Client_plane][var20][graphic] = null;
                        class121.updateItemPile(var20, graphic);
                     }
                  }
               }

               for(PendingSpawn var52 = (PendingSpawn)pendingSpawns.last(); var52 != null; var52 = (PendingSpawn)pendingSpawns.previous()) {
                  if (var52.x >= class9.field28 && var52.x < class9.field28 + 8 && var52.y >= FontName.field3968 && var52.y < FontName.field3968 + 8 && var52.plane == GameEngine.Client_plane) {
                     var52.endCycle = 0;
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            Widget var28;
            if (ServerPacket.field2679 == var1.serverPacket) {
               var20 = var3.readIntIME();
               graphic = var3.readIntIME();
               InterfaceParent var73 = (InterfaceParent)interfaceParents.get((long)var20);
               var7 = (InterfaceParent)interfaceParents.get((long)graphic);
               if (var7 != null) {
                  class357.closeInterface(var7, var73 == null || var7.group != var73.group);
               }

               if (var73 != null) {
                  var73.remove();
                  interfaceParents.put(var73, (long)graphic);
               }

               var28 = class165.getWidget(var20);
               if (var28 != null) {
                  class144.invalidateWidget(var28);
               }

               var28 = class165.getWidget(graphic);
               if (var28 != null) {
                  class144.invalidateWidget(var28);
                  WallDecoration.revalidateWidgetScroll(VerticalAlignment.Widget_interfaceComponents[var28.id >>> 16], var28, true);
               }

               if (rootInterface != -1) {
                  class127.runIntfCloseListeners(rootInterface, 1);
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2677 == var1.serverPacket) {
               World var51 = new World();
               var51.host = var3.readStringCp1252NullTerminated();
               var51.id = var3.readUnsignedShort();
               graphic = var3.readInt();
               var51.properties = graphic;
               class138.updateGameState(45);
               var2.close();
               var2 = null;
               FloorOverlayDefinition.changeWorld(var51);
               var1.serverPacket = null;
               return false;
            }

            if (ServerPacket.IF_OPENSUB == var1.serverPacket) {
               class146.updateNpcs(true, var3);
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.REFLECTION_CHECK == var1.serverPacket) {
               EnumComposition.processZoneOperation(ZoneOperation.field2562);
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2660 == var1.serverPacket) {
               var20 = var3.readInt();
               var78 = class165.getWidget(var20);

               for(flags = 0; flags < var78.itemIds.length; ++flags) {
                  var78.itemIds[flags] = -1;
                  var78.itemIds[flags] = 0;
               }

               class144.invalidateWidget(var78);
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2682 == var1.serverPacket) {
               isCameraLocked = true;
               field598 = false;
               field614 = false;
               FontName.field3970 = var3.readUnsignedByte();
               MilliClock.field1455 = var3.readUnsignedByte();
               ScriptFrame.field343 = var3.readUnsignedShort();
               Archive.field3467 = var3.readUnsignedByte();
               WorldMapElement.field1503 = var3.readUnsignedByte();
               if (WorldMapElement.field1503 >= 100) {
                  var20 = FontName.field3970 * 128 + 64;
                  graphic = MilliClock.field1455 * 128 + 64;
                  flags = class147.getTileHeight(var20, graphic, GameEngine.Client_plane) - ScriptFrame.field343;
                  var26 = var20 - class36.cameraX;
                  var8 = flags - class174.cameraY;
                  var30 = graphic - class297.cameraZ;
                  var10 = (int)Math.sqrt((double)(var26 * var26 + var30 * var30));
                  WorldMapSectionType.cameraPitch = (int)(Math.atan2((double)var8, (double)var10) * 325.9490051269531D) & 2047;
                  class125.cameraYaw = (int)(Math.atan2((double)var26, (double)var30) * -325.9490051269531D) & 2047;
                  if (WorldMapSectionType.cameraPitch < 128) {
                     WorldMapSectionType.cameraPitch = 128;
                  }

                  if (WorldMapSectionType.cameraPitch > 383) {
                     WorldMapSectionType.cameraPitch = 383;
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2586 == var1.serverPacket) {
               ScriptFrame.method343(var3.readStringCp1252NullTerminated());
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2697 == var1.serverPacket) {
               var26 = var3.readUnsignedByte();
               var20 = var3.readUnsignedShort();
               Player var70;
               if (var20 == localPlayerIndex) {
                  var70 = MusicPatchNode.localPlayer;
               } else {
                  var70 = players[var20];
               }

               graphic = var3.readUnsignedShort();
               flags = var3.readInt();
               if (var70 != null) {
                  var70.updateSpotAnimation(var26, graphic, flags >> 16, flags & '\uffff');
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2615 == var1.serverPacket) {
               EnumComposition.processZoneOperation(ZoneOperation.field2565);
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2593 == var1.serverPacket) {
               ClientPacket.process();
               var20 = var3._readUnsignedByteSub();
               graphic = var3._readUnsignedByteSub();
               flags = var3.readIntLE();
               experience[var20] = flags;
               currentLevels[var20] = graphic;
               levels[var20] = 1;

               for(var26 = 0; var26 < 98; ++var26) {
                  if (flags >= Skills.Skills_experienceTable[var26]) {
                     levels[var20] = var26 + 2;
                  }
               }

               changedSkills[++changedSkillsCount - 1 & 31] = var20;
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.RESET_ANIMS == var1.serverPacket) {
               class127.loadRegions(true, var1.packetBuffer);
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.UPDATE_INV_FULL == var1.serverPacket) {
               var20 = var3.readUnsignedShortAddLE();
               graphic = var3.readUnsignedShortAdd();
               flags = var3.readIntME();
               var26 = var3.readUnsignedShort();
               var28 = class165.getWidget(flags);
               if (graphic != var28.modelAngleX || var20 != var28.modelAngleY || var26 != var28.modelZoom) {
                  var28.modelAngleX = graphic;
                  var28.modelAngleY = var20;
                  var28.modelZoom = var26;
                  class144.invalidateWidget(var28);
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.CAM_LOOKAT == var1.serverPacket) {
               var30 = var3.readUnsignedByte();
               var10 = var30 >> 2;
               var11 = var30 & 3;
               var96 = field431[var10];
               flags = var3.readMediumUnsigned_1();
               var20 = flags >> 16;
               graphic = flags >> 8 & 255;
               var26 = var20 + (flags >> 4 & 7);
               var8 = graphic + (flags & 7);
               var13 = var3.readUnsignedShortLE();
               if (var26 >= 0 && var8 >= 0 && var26 < 103 && var8 < 103) {
                  if (var96 == 0) {
                     BoundaryObject var94 = class31.scene.method1252(GameEngine.Client_plane, var26, var8);
                     if (var94 != null) {
                        var15 = InterfaceParent.Entity_unpackID(var94.tag);
                        if (var10 == 2) {
                           var94.renderable1 = new DynamicObject(var15, 2, var11 + 4, GameEngine.Client_plane, var26, var8, var13, false, var94.renderable1);
                           var94.renderable2 = new DynamicObject(var15, 2, var11 + 1 & 3, GameEngine.Client_plane, var26, var8, var13, false, var94.renderable2);
                        } else {
                           var94.renderable1 = new DynamicObject(var15, var10, var11, GameEngine.Client_plane, var26, var8, var13, false, var94.renderable1);
                        }
                     }
                  } else if (var96 == 1) {
                     WallDecoration var93 = class31.scene.method1253(GameEngine.Client_plane, var26, var8);
                     if (var93 != null) {
                        var15 = InterfaceParent.Entity_unpackID(var93.tag);
                        if (var10 != 4 && var10 != 5) {
                           if (var10 == 6) {
                              var93.renderable1 = new DynamicObject(var15, 4, var11 + 4, GameEngine.Client_plane, var26, var8, var13, false, var93.renderable1);
                           } else if (var10 == 7) {
                              var93.renderable1 = new DynamicObject(var15, 4, (var11 + 2 & 3) + 4, GameEngine.Client_plane, var26, var8, var13, false, var93.renderable1);
                           } else if (var10 == 8) {
                              var93.renderable1 = new DynamicObject(var15, 4, var11 + 4, GameEngine.Client_plane, var26, var8, var13, false, var93.renderable1);
                              var93.renderable2 = new DynamicObject(var15, 4, (var11 + 2 & 3) + 4, GameEngine.Client_plane, var26, var8, var13, false, var93.renderable2);
                           }
                        } else {
                           var93.renderable1 = new DynamicObject(var15, 4, var11, GameEngine.Client_plane, var26, var8, var13, false, var93.renderable1);
                        }
                     }
                  } else if (var96 == 2) {
                     var39 = class31.scene.getGameObject(GameEngine.Client_plane, var26, var8);
                     if (var10 == 11) {
                        var10 = 10;
                     }

                     if (var39 != null) {
                        var39.renderable = new DynamicObject(InterfaceParent.Entity_unpackID(var39.tag), var10, var11, GameEngine.Client_plane, var26, var8, var13, false, var39.renderable);
                     }
                  } else if (var96 == 3) {
                     FloorDecoration var92 = class31.scene.getFloorDecoration(GameEngine.Client_plane, var26, var8);
                     if (var92 != null) {
                        var92.renderable = new DynamicObject(InterfaceParent.Entity_unpackID(var92.tag), 22, var11, GameEngine.Client_plane, var26, var8, var13, false, var92.renderable);
                     }
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2613 == var1.serverPacket) {
               EnumComposition.processZoneOperation(ZoneOperation.field2566);
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.REBUILD_REGION == var1.serverPacket) {
               var20 = var3.readUnsignedByte();
               class244.method1392(var20);
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.HEAT_MAP == var1.serverPacket) {
               var68 = var3.readUnsignedByte() == 1;
               if (var68) {
                  class323.field3037 = class96.clockNow() - var3.readLong();
                  class375.grandExchangeEvents = new GrandExchangeEvents(var3, true);
               } else {
                  class375.grandExchangeEvents = null;
               }

               field635 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.UPDATE_RUNENERGY == var1.serverPacket) {
               isCameraLocked = true;
               field598 = false;
               field614 = true;
               FontName.field3970 = var3.readUnsignedByte();
               MilliClock.field1455 = var3.readUnsignedByte();
               ScriptFrame.field343 = var3.readUnsignedShort();
               var20 = var3.readUnsignedShort();
               graphic = var3.readUnsignedByte();
               flags = FontName.field3970 * 128 + 64;
               var26 = MilliClock.field1455 * 128 + 64;
               var8 = class147.getTileHeight(flags, var26, GameEngine.Client_plane) - ScriptFrame.field343;
               var30 = flags - class36.cameraX;
               var10 = var8 - class174.cameraY;
               var11 = var26 - class297.cameraZ;
               double var97 = Math.sqrt((double)(var11 * var11 + var30 * var30));
               var65 = class18.method77((int)(Math.atan2((double)var10, var97) * 325.9490051269531D) & 2047);
               var15 = class425.method2262((int)(Math.atan2((double)var30, (double)var11) * -325.9490051269531D) & 2047);
               field604 = new class454(WorldMapSectionType.cameraPitch, var65, var20, graphic);
               field617 = new class454(class125.cameraYaw, var15, var20, graphic);
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.IF_SETTEXT == var1.serverPacket) {
               FloorUnderlayDefinition.privateChatMode = class399.method2129(var3.readUnsignedByte());
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.GAMEFRAME_FULL == var1.serverPacket) {
               World.friendSystem.ignoreList.read(var3, var1.serverPacketLength);
               Login.FriendSystem_invalidateIgnoreds();
               field557 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2616 == var1.serverPacket) {
               class146.updateNpcs(false, var3);
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.IF_SETPOSITION == var1.serverPacket) {
               if (Players.varclan == null) {
                  Players.varclan = new class429(MenuAction.HitSplatDefinition_cached);
               }

               class497 var50 = MenuAction.HitSplatDefinition_cached.method2275(var3);
               Players.varclan.field3820.vmethod8143(var50.field4105, var50.field4104);
               field554[++field555 - 1 & 31] = var50.field4105;
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2664 == var1.serverPacket) {
               var66 = var3.readByteNeg();
               graphic = var3.readUnsignedShort();
               Varps.Varps_temp[graphic] = var66;
               if (Varps.Varps_main[graphic] != var66) {
                  Varps.Varps_main[graphic] = var66;
               }

               class7.changeGameOptions(graphic);
               changedVarps[++changedVarpCount - 1 & 31] = graphic;
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2594 == var1.serverPacket) {
               var20 = var3.readUnsignedShortAdd();
               User.method2164(var20);
               changedItemContainers[++changedItemContainersCount - 1 & 31] = var20 & 32767;
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.UPDATE_INV_PARTIAL == var1.serverPacket) {
               var20 = var3.readUnsignedShortAddLE();
               graphic = var3.readIntLE();
               var29 = class165.getWidget(graphic);
               if (var29.modelType != 6 || var20 != var29.modelId) {
                  var29.modelType = 6;
                  var29.modelId = var20;
                  class144.invalidateWidget(var29);
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2607 == var1.serverPacket) {
               var49 = var3.readStringCp1252NullTerminated();
               var21 = (long)var3.readUnsignedShort();
               var23 = (long)var3.readMedium();
               PlayerType var44 = (PlayerType)StructComposition.findEnumerated(StudioGame.PlayerType_values(), var3.readUnsignedByte());
               long var45 = var23 + (var21 << 32);
               var41 = false;

               for(var13 = 0; var13 < 100; ++var13) {
                  if (field652[var13] == var45) {
                     var41 = true;
                     break;
                  }
               }

               if (World.friendSystem.isIgnored(new Username(var49, class70.loginType))) {
                  var41 = true;
               }

               if (!var41 && field476 == 0) {
                  field652[field588] = var45;
                  field588 = (field588 + 1) % 100;
                  var25 = AbstractFont.escapeBrackets(BuddyRankComparator.method711(SceneTilePaint.readString(var3)));
                  byte var63;
                  if (var44.isPrivileged) {
                     var63 = 7;
                  } else {
                     var63 = 3;
                  }

                  if (var44.modIcon != -1) {
                     UserComparator5.addGameMessage(var63, ArchiveDiskActionHandler.addImageTag(var44.modIcon) + var49, var25);
                  } else {
                     UserComparator5.addGameMessage(var63, var49, var25);
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2627 == var1.serverPacket) {
               var20 = var3.readUnsignedShortAddLE();
               graphic = var3.readIntME();
               var29 = class165.getWidget(graphic);
               if (var29.modelType != 2 || var20 != var29.modelId) {
                  var29.modelType = 2;
                  var29.modelId = var20;
                  class144.invalidateWidget(var29);
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2658 == var1.serverPacket) {
               field560 = cycleCntr;
               var66 = var3.readByte();
               if (var1.serverPacketLength == 1) {
                  if (var66 >= 0) {
                     currentClanChannels[var66] = null;
                  } else {
                     MouseHandler.guestClanChannel = null;
                  }

                  var1.serverPacket = null;
                  return true;
               }

               if (var66 >= 0) {
                  currentClanChannels[var66] = new ClanChannel(var3);
               } else {
                  MouseHandler.guestClanChannel = new ClanChannel(var3);
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2671 == var1.serverPacket) {
               for(var20 = 0; var20 < VarpDefinition.field1475; ++var20) {
                  VarpDefinition var77 = GraphicsDefaults.VarpDefinition_get(var20);
                  if (var77 != null) {
                     Varps.Varps_temp[var20] = 0;
                     Varps.Varps_main[var20] = 0;
                  }
               }

               ClientPacket.process();
               changedVarpCount += 32;
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2667 == var1.serverPacket) {
               var20 = var3.readInt();
               InterfaceParent var76 = (InterfaceParent)interfaceParents.get((long)var20);
               if (var76 != null) {
                  class357.closeInterface(var76, true);
               }

               if (meslayerContinueWidget != null) {
                  class144.invalidateWidget(meslayerContinueWidget);
                  meslayerContinueWidget = null;
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.CHAT_FILTER_SETTINGS == var1.serverPacket) {
               var20 = var3._readUnsignedByteSub();
               var31 = var3.readStringCp1252NullTerminated();
               flags = var3._readUnsignedByteSub();
               if (var20 >= 1 && var20 <= 8) {
                  if (var31.equalsIgnoreCase("null")) {
                     var31 = null;
                  }

                  playerMenuActions[var20 - 1] = var31;
                  playerOptionsPriorities[var20 - 1] = flags == 0;
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2579 == var1.serverPacket) {
               var49 = var3.readStringCp1252NullTerminated();
               var31 = AbstractFont.escapeBrackets(BuddyRankComparator.method711(SceneTilePaint.readString(var3)));
               UserComparator5.addGameMessage(6, var49, var31);
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2597 == var1.serverPacket) {
               var49 = var3.readStringCp1252NullTerminated();
               var21 = var3.readLong();
               var23 = (long)var3.readUnsignedShort();
               var9 = (long)var3.readMedium();
               PlayerType var27 = (PlayerType)StructComposition.findEnumerated(StudioGame.PlayerType_values(), var3.readUnsignedByte());
               var42 = var9 + (var23 << 32);
               boolean var14 = false;

               for(var15 = 0; var15 < 100; ++var15) {
                  if (field652[var15] == var42) {
                     var14 = true;
                     break;
                  }
               }

               if (var27.isUser && World.friendSystem.isIgnored(new Username(var49, class70.loginType))) {
                  var14 = true;
               }

               if (!var14 && field476 == 0) {
                  field652[field588] = var42;
                  field588 = (field588 + 1) % 100;
                  var40 = AbstractFont.escapeBrackets(BuddyRankComparator.method711(SceneTilePaint.readString(var3)));
                  if (var27.modIcon != -1) {
                     class136.addChatMessage(9, ArchiveDiskActionHandler.addImageTag(var27.modIcon) + var49, var40, FloorUnderlayDefinition.base37DecodeLong(var21));
                  } else {
                     class136.addChatMessage(9, var49, var40, FloorUnderlayDefinition.base37DecodeLong(var21));
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2685 == var1.serverPacket) {
               var10 = var3.readUnsignedByte();
               var11 = var3.readUnsignedShortAddLE();
               flags = var3.readMediumUnsigned_1();
               var20 = flags >> 16;
               graphic = flags >> 8 & 255;
               var26 = var20 + (flags >> 4 & 7);
               var8 = graphic + (flags & 7);
               var30 = var3.readUnsignedShort();
               if (var26 >= 0 && var8 >= 0 && var26 < 104 && var8 < 104) {
                  var26 = var26 * 128 + 64;
                  var8 = var8 * 128 + 64;
                  GraphicsObject var12 = new GraphicsObject(var30, GameEngine.Client_plane, var26, var8, class147.getTileHeight(var26, var8, GameEngine.Client_plane) - var10, var11, cycle);
                  graphicsObjects.addFirst(var12);
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.VARCLAN == var1.serverPacket) {
               publicChatMode = var3._readUnsignedByteSub();
               tradeChatMode = var3.readUnsignedByte();
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2651 == var1.serverPacket) {
               rebootTimer = var3.readUnsignedShortLE() * 30;
               field433 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2598 == var1.serverPacket) {
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

            if (ServerPacket.field2610 == var1.serverPacket) {
               var20 = var3.readUnsignedByteNeg();
               graphic = var3.readUnsignedShortLE();
               flags = var3.readIntME();
               var7 = (InterfaceParent)interfaceParents.get((long)flags);
               if (var7 != null) {
                  class357.closeInterface(var7, graphic != var7.group);
               }

               AttackOption.ifOpenSub(flags, graphic, var20);
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2611 == var1.serverPacket) {
               var20 = var3.readInt();
               graphic = var3.readUnsignedShort();
               if (var20 < -70000) {
                  graphic += 32768;
               }

               if (var20 >= 0) {
                  var29 = class165.getWidget(var20);
               } else {
                  var29 = null;
               }

               if (var29 != null) {
                  for(var26 = 0; var26 < var29.itemIds.length; ++var26) {
                     var29.itemIds[var26] = 0;
                     var29.field3007[var26] = 0;
                  }
               }

               WorldMapRegion.clearItemContainer(graphic);
               var26 = var3.readUnsignedShort();

               for(var8 = 0; var8 < var26; ++var8) {
                  var30 = var3.readUnsignedShortLE();
                  var10 = var3._readUnsignedByteSub();
                  if (var10 == 255) {
                     var10 = var3.readIntME();
                  }

                  if (var29 != null && var8 < var29.itemIds.length) {
                     var29.itemIds[var8] = var30;
                     var29.field3007[var8] = var10;
                  }

                  class373.itemContainerSetItem(graphic, var8, var30 - 1, var10);
               }

               if (var29 != null) {
                  class144.invalidateWidget(var29);
               }

               ClientPacket.process();
               changedItemContainers[++changedItemContainersCount - 1 & 31] = graphic & 32767;
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2674 == var1.serverPacket) {
               EnumComposition.processZoneOperation(ZoneOperation.field2563);
               var1.serverPacket = null;
               return true;
            }

            class387.RunException_sendStackTrace("" + (var1.serverPacket != null ? var1.serverPacket.id * 1287795301 * 1490038637 : -1) + "," + (var1.field1139 != null ? var1.field1139.id * 1287795301 * 1490038637 : -1) + "," + (var1.field1133 != null ? var1.field1133.id * 1287795301 * 1490038637 : -1) + "," + var1.serverPacketLength, (Throwable)null);
            class31.logOut();
         } catch (IOException var47) {
            class349.method1918();
         } catch (Exception var48) {
            var31 = "" + (var1.serverPacket != null ? var1.serverPacket.id * 1287795301 * 1490038637 : -1) + "," + (var1.field1139 != null ? var1.field1139.id * 1287795301 * 1490038637 : -1) + "," + (var1.field1133 != null ? var1.field1133.id * 1287795301 * 1490038637 : -1) + "," + var1.serverPacketLength + "," + (MusicPatchNode.localPlayer.pathX[0] + WorldMapData_0.baseX) + "," + (MusicPatchNode.localPlayer.pathY[0] + GameObject.baseY) + ",";

            for(flags = 0; flags < var1.serverPacketLength && flags < 50; ++flags) {
               var31 = var31 + var3.array[flags] + ",";
            }

            class387.RunException_sendStackTrace(var31, var48);
            class31.logOut();
         }

         return true;
      }
   }

    @ObfuscatedName("ko")
    @ObfuscatedSignature(
            descriptor = "(B)V",
            garbageValue = "-47"
    )
    final void menu() {
      class425.method2264();
      if (clickedWidget == null) {
         int var1 = MouseHandler.MouseHandler_lastButton;
         int var2;
         int var3;
         int var4;
         int var5;
         int var6;
         int var7;
         if (isMenuOpen) {
            int var8;
            if (var1 != 1 && (class473.mouseCam || var1 != 4)) {
               var2 = MouseHandler.MouseHandler_x;
               var3 = MouseHandler.MouseHandler_y;
               if (var2 < class192.menuX - 10 || var2 > DesktopPlatformInfoProvider.menuWidth + class192.menuX + 10 || var3 < ArchiveLoader.menuY - 10 || var3 > ArchiveLoader.menuY + class147.menuHeight + 10) {
                  isMenuOpen = false;
                  var4 = class192.menuX;
                  var5 = ArchiveLoader.menuY;
                  var6 = DesktopPlatformInfoProvider.menuWidth;
                  var7 = class147.menuHeight;

                  for(var8 = 0; var8 < rootWidgetCount; ++var8) {
                     if (rootWidgetWidths[var8] + rootWidgetXs[var8] > var4 && rootWidgetXs[var8] < var4 + var6 && rootWidgetHeights[var8] + rootWidgetYs[var8] > var5 && rootWidgetYs[var8] < var7 + var5) {
                        field573[var8] = true;
                     }
                  }
               }
            }

            if (var1 == 1 || !class473.mouseCam && var1 == 4) {
               var2 = class192.menuX;
               var3 = ArchiveLoader.menuY;
               var4 = DesktopPlatformInfoProvider.menuWidth;
               var5 = MouseHandler.MouseHandler_lastPressedX;
               var6 = MouseHandler.MouseHandler_lastPressedY;
               var7 = -1;

               int var9;
               for(var8 = 0; var8 < menuOptionsCount; ++var8) {
                  var9 = (menuOptionsCount - 1 - var8) * 15 + var3 + 31;
                  if (var5 > var2 && var5 < var2 + var4 && var6 > var9 - 13 && var6 < var9 + 3) {
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
                  class17.menuAction(var8, var9, var10, var11, var12, var13, var14, MouseHandler.MouseHandler_lastPressedX, MouseHandler.MouseHandler_lastPressedY);
               }

               isMenuOpen = false;
               var8 = class192.menuX;
               var9 = ArchiveLoader.menuY;
               var10 = DesktopPlatformInfoProvider.menuWidth;
               var11 = class147.menuHeight;

               for(var12 = 0; var12 < rootWidgetCount; ++var12) {
                  if (rootWidgetWidths[var12] + rootWidgetXs[var12] > var8 && rootWidgetXs[var12] < var10 + var8 && rootWidgetYs[var12] + rootWidgetHeights[var12] > var9 && rootWidgetYs[var12] < var9 + var11) {
                     field573[var12] = true;
                  }
               }
            }
         } else {
            var2 = DynamicObject.method461();
            if ((var1 == 1 || !class473.mouseCam && var1 == 4) && this.shouldLeftClickOpenMenu()) {
               var1 = 2;
            }

            if ((var1 == 1 || !class473.mouseCam && var1 == 4) && menuOptionsCount > 0 && var2 >= 0) {
               var3 = menuArguments1[var2];
               var4 = menuArguments2[var2];
               var5 = menuOpcodes[var2];
               var6 = menuIdentifiers[var2];
               var7 = menuItemIds[var2];
               String var15 = menuActions[var2];
               String var16 = menuTargets[var2];
               class17.menuAction(var3, var4, var5, var6, var7, var15, var16, MouseHandler.MouseHandler_lastPressedX, MouseHandler.MouseHandler_lastPressedY);
            }

            if (var1 == 2 && menuOptionsCount > 0) {
               this.openMenu(MouseHandler.MouseHandler_lastPressedX, MouseHandler.MouseHandler_lastPressedY);
            }
         }

      }
   }

    @ObfuscatedName("kr")
    @ObfuscatedSignature(
            descriptor = "(I)Z",
            garbageValue = "-1679837219"
    )
    final boolean shouldLeftClickOpenMenu() {
      int var1 = DynamicObject.method461();
      boolean var2 = leftClickOpensMenu && menuOptionsCount > 2;
      if (!var2) {
         boolean var3;
         if (var1 < 0) {
            var3 = false;
         } else {
            int var4 = menuOpcodes[var1];
            if (var4 >= 2000) {
               var4 -= 2000;
            }

            if (var4 == 1007) {
               var3 = true;
            } else {
               var3 = false;
            }
         }

         var2 = var3;
      }

      return var2 && !menuShiftClick[var1];
   }

    @ObfuscatedName("kl")
    @ObfuscatedSignature(
            descriptor = "(III)V",
            garbageValue = "1018516557"
    )
    final void openMenu(int var1, int var2) {
      class431.method2278(var1, var2);
      var1 -= viewportOffsetX;
      var2 -= viewportOffsetY;
      class31.scene.menuOpen(GameEngine.Client_plane, var1, var2, false);
      isMenuOpen = true;
   }

    @ObfuscatedName("ln")
    @ObfuscatedSignature(
            descriptor = "(ZI)V",
            garbageValue = "36188245"
    )
    final void resizeRoot(boolean var1) {
      SequenceDefinition.method1129(rootInterface, GameEngine.canvasWidth, class262.canvasHeight, var1);
   }

    @ObfuscatedName("lt")
    @ObfuscatedSignature(
            descriptor = "(Lmq;I)V",
            garbageValue = "-1113228420"
    )
    void alignWidget(Widget var1) {
      Widget var2 = var1.parentId == -1 ? null : class165.getWidget(var1.parentId);
      int var3;
      int var4;
      if (var2 == null) {
         var3 = GameEngine.canvasWidth;
         var4 = class262.canvasHeight;
      } else {
         var3 = var2.width;
         var4 = var2.height;
      }

      class158.alignWidgetSize(var1, var3, var4, false);
      class192.alignWidgetPosition(var1, var3, var4);
   }

   @ObfuscatedName("me")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "-94"
   )
   final void method389() {
      class144.invalidateWidget(clickedWidget);
      ++class96.widgetDragDuration;
      if (field622 && field540) {
         int var1 = MouseHandler.MouseHandler_x;
         int var2 = MouseHandler.MouseHandler_y;
         var1 -= widgetClickX;
         var2 -= widgetClickY;
         if (var1 < field495) {
            var1 = field495;
         }

         if (var1 + clickedWidget.width > field495 + clickedWidgetParent.width) {
            var1 = field495 + clickedWidgetParent.width - clickedWidget.width;
         }

         if (var2 < field542) {
            var2 = field542;
         }

         if (var2 + clickedWidget.height > field542 + clickedWidgetParent.height) {
            var2 = field542 + clickedWidgetParent.height - clickedWidget.height;
         }

         int var3 = var1 - field544;
         int var4 = var2 - field545;
         int var5 = clickedWidget.dragZoneSize;
         if (class96.widgetDragDuration > clickedWidget.dragThreshold && (var3 > var5 || var3 < -var5 || var4 > var5 || var4 < -var5)) {
            isDraggingWidget = true;
         }

         int var6 = var1 - field495 + clickedWidgetParent.scrollX;
         int var7 = var2 - field542 + clickedWidgetParent.scrollY;
         ScriptEvent var8;
         if (clickedWidget.onDrag != null && isDraggingWidget) {
            var8 = new ScriptEvent();
            var8.widget = clickedWidget;
            var8.mouseX = var6;
            var8.mouseY = var7;
            var8.args = clickedWidget.onDrag;
            HealthBarUpdate.runScriptEvent(var8);
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
                  HealthBarUpdate.runScriptEvent(var8);
               }

               if (draggedOnWidget != null) {
                  Widget var9 = clickedWidget;
                  int var10 = StructComposition.method1071(KeyHandler.getWidgetFlags(var9));
                  Widget var13;
                  if (var10 == 0) {
                     var13 = null;
                  } else {
                     int var11 = 0;

                     while(true) {
                        if (var11 >= var10) {
                           var13 = var9;
                           break;
                        }

                        var9 = class165.getWidget(var9.parentId);
                        if (var9 == null) {
                           var13 = null;
                           break;
                        }

                        ++var11;
                     }
                  }

                  if (var13 != null) {
                     PacketBufferNode var12 = class330.getPacketBufferNode(ClientPacket.field2515, packetWriter.isaacCipher);
                     var12.packetBuffer.writeShortAdd(draggedOnWidget.itemId);
                     var12.packetBuffer.writeIntLE(draggedOnWidget.id);
                     var12.packetBuffer.writeShortAdd(draggedOnWidget.childIndex);
                     var12.packetBuffer.writeShortAdd(clickedWidget.childIndex);
                     var12.packetBuffer.writeIntME(clickedWidget.id);
                     var12.packetBuffer.writeShort(clickedWidget.itemId);
                     packetWriter.addNode(var12);
                  }
               }
            } else if (this.shouldLeftClickOpenMenu()) {
               this.openMenu(field544 + widgetClickX, widgetClickY + field545);
            } else if (menuOptionsCount > 0) {
               class204.method1136(field544 + widgetClickX, field545 + widgetClickY);
            }

            clickedWidget = null;
         }

      } else {
         if (class96.widgetDragDuration > 1) {
            if (!isDraggingWidget && menuOptionsCount > 0) {
               class204.method1136(field544 + widgetClickX, field545 + widgetClickY);
            }

            clickedWidget = null;
         }

      }
   }

    @ObfuscatedName("nv")
    @ObfuscatedSignature(
            descriptor = "(I)Ltm;",
            garbageValue = "637501068"
    )
    public Username username() {
      return MusicPatchNode.localPlayer != null ? MusicPatchNode.localPlayer.username : null;
   }

    @ObfuscatedName("init")
    public final void init() {
      if (this.checkHost()) {
         int var3;
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
                  ClanSettings.clientLanguage = Language.method1943(Integer.parseInt(var2));
                  break;
               case 7:
                  AABB.field2070 = class146.method832(Integer.parseInt(var2));
                  break;
               case 8:
                  if (var2.equalsIgnoreCase("true")) {
                     ;
                  }
                  break;
               case 9:
                  class108.param9 = var2;
                  break;
               case 10:
                  field358 = (StudioGame)StructComposition.findEnumerated(TaskHandler.method951(), Integer.parseInt(var2));
                  if (field358 == StudioGame.oldscape) {
                     class70.loginType = LoginType.oldscape;
                  } else {
                     class70.loginType = LoginType.field3998;
                  }
                  break;
               case 11:
                  ViewportMouse.field2213 = var2;
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
                  TriBool.field3738 = Integer.parseInt(var2);
                  break;
               case 15:
                  gameBuild = Integer.parseInt(var2);
                  break;
               case 17:
                  GrandExchangeOffer.field3530 = var2;
                  break;
               case 21:
                  param21 = Integer.parseInt(var2);
                  break;
               case 25:
                  var3 = var2.indexOf(".");
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
         UserComparator8.worldHost = this.getCodeBase().getHost();
         String var11 = AABB.field2070.name;
         byte var12 = 0;

         try {
            JagexCache.idxCount = 22;
            JagexCache.cacheGamebuild = var12;

            try {
               ModeWhere.operatingSystemName = System.getProperty("os.name");
            } catch (Exception var18) {
               ModeWhere.operatingSystemName = "Unknown";
            }

            WorldMapSectionType.formattedOperatingSystemName = ModeWhere.operatingSystemName.toLowerCase();

            try {
               HorizontalAlignment.userHomeDirectory = System.getProperty("user.home");
               if (HorizontalAlignment.userHomeDirectory != null) {
                  HorizontalAlignment.userHomeDirectory = HorizontalAlignment.userHomeDirectory + "/";
               }
            } catch (Exception var17) {
               ;
            }

            try {
               if (WorldMapSectionType.formattedOperatingSystemName.startsWith("win")) {
                  if (HorizontalAlignment.userHomeDirectory == null) {
                     HorizontalAlignment.userHomeDirectory = System.getenv("USERPROFILE");
                  }
               } else if (HorizontalAlignment.userHomeDirectory == null) {
                  HorizontalAlignment.userHomeDirectory = System.getenv("HOME");
               }

               if (HorizontalAlignment.userHomeDirectory != null) {
                  HorizontalAlignment.userHomeDirectory = HorizontalAlignment.userHomeDirectory + "/";
               }
            } catch (Exception var16) {
               ;
            }

            if (HorizontalAlignment.userHomeDirectory == null) {
               HorizontalAlignment.userHomeDirectory = "~/";
            }

            class130.cacheParentPaths = new String[]{"c:/rscache/", "/rscache/", "c:/windows/", "c:/winnt/", "c:/", HorizontalAlignment.userHomeDirectory, "/tmp/", ""};
            class96.cacheSubPaths = new String[]{".jagex_cache_" + JagexCache.cacheGamebuild, ".file_store_" + JagexCache.cacheGamebuild};

            label153:
            for(var3 = 0; var3 < 4; ++var3) {
               class335.cacheDir = ClanSettings.method870("oldschool", var11, var3);
               if (!class335.cacheDir.exists()) {
                  class335.cacheDir.mkdirs();
               }

               File[] var4 = class335.cacheDir.listFiles();
               if (var4 == null) {
                  break;
               }

               File[] var5 = var4;
               int var6 = 0;

               while(true) {
                  if (var6 >= var5.length) {
                     break label153;
                  }

                  File var7 = var5[var6];

                  boolean var8;
                  try {
                     RandomAccessFile var9 = new RandomAccessFile(var7, "rw");
                     int var10 = var9.read();
                     var9.seek(0L);
                     var9.write(var10);
                     var9.seek(0L);
                     var9.close();
                     var8 = true;
                  } catch (Exception var15) {
                     var8 = false;
                  }

                  if (!var8) {
                     break;
                  }

                  ++var6;
               }
            }

            File var13 = class335.cacheDir;
            class513.FileSystem_cacheDir = var13;
            if (!class513.FileSystem_cacheDir.exists()) {
               throw new RuntimeException("");
            }

            FileSystem.FileSystem_hasPermissions = true;
            Tiles.method475();
            JagexCache.JagexCache_dat2File = new BufferedFile(new AccessFile(class138.getFile("main_file_cache.dat2"), "rw", 1048576000L), 5200, 0);
            JagexCache.JagexCache_idx255File = new BufferedFile(new AccessFile(class138.getFile("main_file_cache.idx255"), "rw", 1048576L), 6000, 0);
            class370.JagexCache_idxFiles = new BufferedFile[JagexCache.idxCount];

            for(int var14 = 0; var14 < JagexCache.idxCount; ++var14) {
               class370.JagexCache_idxFiles[var14] = new BufferedFile(new AccessFile(class138.getFile("main_file_cache.idx" + var14), "rw", 1048576L), 6000, 0);
            }
         } catch (Exception var19) {
            class387.RunException_sendStackTrace((String)null, var19);
         }

         ScriptFrame.client = this;
         RuneLiteMenuEntry.client = (RSClient) (Object) this;
         RunException.field4178 = clientType;
         ModeWhere.field3571 = System.getenv("JX_ACCESS_TOKEN");
         TileItem.field1079 = System.getenv("JX_REFRESH_TOKEN");
         SpriteMask.field2808 = System.getenv("JX_SESSION_ID");
         class121.field1185 = System.getenv("JX_CHARACTER_ID");
         String var20 = System.getenv("JX_DISPLAY_NAME");
         Login.field749 = class31.method133(var20);
         if (Boolean.parseBoolean(System.getProperty("jagex.disableBouncyCastle"))) {
            this.field401 = true;
         }

         if (field363 == -1) {
            if (!this.method394() && !this.method369()) {
               field363 = 0;
            } else {
               field363 = 5;
            }
         }

         this.startThread(765, 503, 213, 1);
      }
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      descriptor = "(Lnm;Lnm;B)V",
      garbageValue = "-10"
   )
   public static void method398(AbstractArchive var0, AbstractArchive var1) {
      KitDefinition.KitDefinition_archive = var0;
      KitDefinition.KitDefinition_modelsArchive = var1;
      KitDefinition.KitDefinition_fileCount = KitDefinition.KitDefinition_archive.getGroupFileCount(3);
   }

   @ObfuscatedName("bn")
   @ObfuscatedSignature(
      descriptor = "(ILch;ZI)I",
      garbageValue = "-668307175"
   )
   static int method368(int var0, Script var1, boolean var2) {
      if (var0 == 5630) {
         logoutTimer = 250;
         return 1;
      } else {
         return 2;
      }
   }
}
