import com.jagex.oldscape.pub.OAuthApi;
import com.jagex.oldscape.pub.OtlTokenRequester;
import com.jagex.oldscape.pub.RefreshAccessTokenRequester;
import com.jagex.oldscape.pub.RefreshAccessTokenResponse;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.concurrent.Future;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSClient;

@Implements("Client")
@ObfuscatedName("client")
public final class Client extends GameEngine implements Usernamed, OAuthApi {
   @ObfuscatedName("st")
   @ObfuscatedSignature(
      descriptor = "[Lep;"
   )
   static ClanSettings[] currentClanSettings;
   @ObfuscatedName("sw")
   static boolean playingJingle;
   @ObfuscatedName("vw")
   public static int field646;
   @ObfuscatedName("uj")
   static int viewportOffsetX;
   @ObfuscatedName("ui")
   static int viewportOffsetY;
   @ObfuscatedName("ws")
   static int[] field651;
   @ObfuscatedName("sx")
   static int destinationX;
   @ObfuscatedName("wt")
   static int[] field630;
   @ObfuscatedName("wd")
   @ObfuscatedSignature(
      descriptor = "Lbx;"
   )
   static final ApproximateRouteStrategy field650;
   @ObfuscatedName("su")
   static int destinationY;
   @ObfuscatedName("ts")
   static boolean isCameraLocked;
   @ObfuscatedName("sz")
   static int currentTrackGroupId;
   @ObfuscatedName("th")
   static boolean field617;
   @ObfuscatedName("sj")
   @ObfuscatedSignature(
      descriptor = "[Lfn;"
   )
   static ClanChannel[] currentClanChannels;
   @ObfuscatedName("vg")
   @ObfuscatedSignature(
      descriptor = "[Lmz;"
   )
   static GrandExchangeOffer[] grandExchangeOffers;
   @ObfuscatedName("uc")
   static int field637;
   @ObfuscatedName("ur")
   @ObfuscatedSignature(
      descriptor = "Lko;"
   )
   static PlayerComposition playerAppearance;
   @ObfuscatedName("ub")
   static int field638;
   @ObfuscatedName("vj")
   static ArrayList archiveLoaders;
   @ObfuscatedName("vt")
   static int archiveLoadersDone;
   @ObfuscatedName("tw")
   static int soundEffectCount;
   @ObfuscatedName("to")
   static int[] soundEffectIds;
   @ObfuscatedName("tj")
   static int[] queuedSoundEffectLoops;
   @ObfuscatedName("tf")
   static int[] queuedSoundEffectDelays;
   @ObfuscatedName("sh")
   static int minimapState;
   @ObfuscatedName("tr")
   @ObfuscatedSignature(
      descriptor = "[Lak;"
   )
   static SoundEffect[] soundEffects;
   @ObfuscatedName("vh")
   @ObfuscatedSignature(
      descriptor = "Ljv;"
   )
   static EvictingDualNodeHashTable Widget_cachedModels;
   @ObfuscatedName("ta")
   static int[] soundLocations;
   @ObfuscatedName("vp")
   @ObfuscatedSignature(
      descriptor = "Ljv;"
   )
   static EvictingDualNodeHashTable Widget_cachedFonts;
   @ObfuscatedName("ud")
   @ObfuscatedSignature(
      descriptor = "Lpd;"
   )
   static PlatformInfoProvider platformInfoProvider;
   @ObfuscatedName("ro")
   static long userRegistrationId;
   @ObfuscatedName("sd")
   static int field464;
   @ObfuscatedName("vq")
   @ObfuscatedSignature(
      descriptor = "Lni;"
   )
   static class384 archive5;
   @ObfuscatedName("ut")
   static boolean[] cameraShaking;
   @ObfuscatedName("ul")
   static short field623;
   @ObfuscatedName("uz")
   static short field395;
   @ObfuscatedName("uh")
   static short field629;
   @ObfuscatedName("uy")
   static short field355;
   @ObfuscatedName("sg")
   static int mapIconCount;
   @ObfuscatedName("up")
   static short field628;
   @ObfuscatedName("sl")
   static int[] mapIconXs;
   @ObfuscatedName("uu")
   static int viewportZoom;
   @ObfuscatedName("ua")
   static short field535;
   @ObfuscatedName("us")
   static int viewportWidth;
   @ObfuscatedName("uq")
   static int viewportHeight;
   @ObfuscatedName("sv")
   static int[] mapIconYs;
   @ObfuscatedName("sq")
   @ObfuscatedSignature(
      descriptor = "[Lrx;"
   )
   static SpritePixels[] mapIcons;
   @ObfuscatedName("ue")
   static short zoomHeight;
   @ObfuscatedName("ug")
   static short zoomWidth;
   @ObfuscatedName("vv")
   static int field649;
   @ObfuscatedName("ux")
   static int[] cameraMoveIntensity;
   @ObfuscatedName("ve")
   @ObfuscatedSignature(
      descriptor = "Lbg;"
   )
   static GrandExchangeOfferOwnWorldComparator GrandExchangeEvents_worldComparator;
   @ObfuscatedName("uo")
   static int[] cameraShakeIntensity;
   @ObfuscatedName("un")
   static int[] cameraShakeCycle;
   @ObfuscatedName("uv")
   static int[] cameraShakeSpeed;
   @ObfuscatedName("vr")
   static int field645;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      descriptor = "[Lgw;"
   )
   static CollisionMap[] collisionMaps;
   @ObfuscatedName("bh")
   static boolean field519 = true;
   @ObfuscatedName("be")
   public static int worldId = 1;
   @ObfuscatedName("bf")
   static int worldProperties = 0;
   @ObfuscatedName("by")
   static int gameBuild = 0;
   @ObfuscatedName("bc")
   public static boolean isMembersWorld = false;
   @ObfuscatedName("bl")
   static boolean isLowDetail = false;
   @ObfuscatedName("bi")
   static int field356 = -1;
   @ObfuscatedName("br")
   static int clientType = -1;
   @ObfuscatedName("bq")
   static int field543 = -1;
   @ObfuscatedName("bn")
   static boolean onMobile = false;
   @ObfuscatedName("ba")
   public static int field360 = 210;
   @ObfuscatedName("cc")
   static int gameState = 0;
   @ObfuscatedName("dn")
   static boolean isLoading = true;
   @ObfuscatedName("da")
   static int cycle = 0;
   @ObfuscatedName("de")
   static long mouseLastLastPressedTimeMillis = -1L;
   @ObfuscatedName("dw")
   static int field365 = -1;
   @ObfuscatedName("dm")
   static int field397 = -1;
   @ObfuscatedName("dv")
   static long field367 = -1L;
   @ObfuscatedName("ds")
   static boolean hadFocus = true;
   @ObfuscatedName("dc")
   static int rebootTimer = 0;
   @ObfuscatedName("dk")
   static int hintArrowType = 0;
   @ObfuscatedName("df")
   static int hintArrowNpcIndex = 0;
   @ObfuscatedName("dy")
   static int hintArrowPlayerIndex = 0;
   @ObfuscatedName("dx")
   static int hintArrowX = 0;
   @ObfuscatedName("dr")
   static int hintArrowY = 0;
   @ObfuscatedName("dd")
   static int hintArrowHeight = 0;
   @ObfuscatedName("dg")
   static int hintArrowSubX = 0;
   @ObfuscatedName("dq")
   static int hintArrowSubY = 0;
   @ObfuscatedName("dt")
   @ObfuscatedSignature(
      descriptor = "Lcz;"
   )
   static AttackOption playerAttackOption;
   @ObfuscatedName("dp")
   @ObfuscatedSignature(
      descriptor = "Lcz;"
   )
   static AttackOption npcAttackOption;
   @ObfuscatedName("eh")
   static int titleLoadingStage;
   @ObfuscatedName("ee")
   static int js5ConnectState;
   @ObfuscatedName("em")
   static int field382;
   @ObfuscatedName("fr")
   static int js5Errors;
   @ObfuscatedName("fp")
   static int loginState;
   @ObfuscatedName("fg")
   static int field493;
   @ObfuscatedName("ff")
   static int field386;
   @ObfuscatedName("ft")
   static int field372;
   @ObfuscatedName("fs")
   @ObfuscatedSignature(
      descriptor = "Let;"
   )
   static class132 field385;
   @ObfuscatedName("fh")
   @ObfuscatedSignature(
      descriptor = "Lrh;"
   )
   static class471 field485;
   @ObfuscatedName("gh")
   static final String field399;
   @ObfuscatedName("gr")
   static boolean Login_isUsernameRemembered;
   @ObfuscatedName("gk")
   @ObfuscatedSignature(
      descriptor = "Lbb;"
   )
   static SecureRandomFuture secureRandomFuture;
   @ObfuscatedName("gg")
   static byte[] randomDatData;
   @ObfuscatedName("gi")
   @ObfuscatedSignature(
      descriptor = "[Lcg;"
   )
   static NPC[] npcs;
   @ObfuscatedName("hs")
   static int npcCount;
   @ObfuscatedName("hx")
   static int[] npcIndices;
   @ObfuscatedName("ho")
   static int field409;
   @ObfuscatedName("he")
   static int[] field410;
   @ObfuscatedName("hn")
   @ObfuscatedSignature(
      descriptor = "Lde;"
   )
   public static final PacketWriter packetWriter;
   @ObfuscatedName("hf")
   static int logoutTimer;
   @ObfuscatedName("hr")
   static boolean hadNetworkError;
   @ObfuscatedName("hz")
   @ObfuscatedSignature(
      descriptor = "Lnh;"
   )
   static Timer timer;
   @ObfuscatedName("hg")
   static HashMap fontsMap;
   @ObfuscatedName("hp")
   static int field446;
   @ObfuscatedName("hd")
   static int field600;
   @ObfuscatedName("hu")
   static int field631;
   @ObfuscatedName("iq")
   static int field419;
   @ObfuscatedName("ip")
   static int field503;
   @ObfuscatedName("it")
   static String selectedItemName;
   @ObfuscatedName("iy")
   static int[] regionMapArchiveIds;
   @ObfuscatedName("ia")
   static boolean isInInstance;
   @ObfuscatedName("im")
   static int[][][] instanceChunkTemplates;
   @ObfuscatedName("in")
   static final int[] field424;
   @ObfuscatedName("ii")
   static int field408;
   @ObfuscatedName("jm")
   static int field564;
   @ObfuscatedName("jl")
   static int field496;
   @ObfuscatedName("jq")
   static int field377;
   @ObfuscatedName("jj")
   static int field429;
   @ObfuscatedName("jt")
   static boolean field534;
   @ObfuscatedName("jv")
   static int alternativeScrollbarWidth;
   @ObfuscatedName("jn")
   static int camAngleX;
   @ObfuscatedName("jx")
   static int camAngleY;
   @ObfuscatedName("jf")
   static int camAngleDY;
   @ObfuscatedName("jh")
   static int camAngleDX;
   @ObfuscatedName("jo")
   static int mouseCamClickedX;
   @ObfuscatedName("jg")
   static int mouseCamClickedY;
   @ObfuscatedName("jc")
   static int oculusOrbState;
   @ObfuscatedName("ja")
   static int camFollowHeight;
   @ObfuscatedName("ka")
   static int field483;
   @ObfuscatedName("km")
   static int field441;
   @ObfuscatedName("kl")
   static int field442;
   @ObfuscatedName("kc")
   static int oculusOrbNormalSpeed;
   @ObfuscatedName("kx")
   static int oculusOrbSlowedSpeed;
   @ObfuscatedName("ke")
   public static int field634;
   @ObfuscatedName("kv")
   static boolean field374;
   @ObfuscatedName("ks")
   static int field652;
   @ObfuscatedName("ky")
   static boolean field448;
   @ObfuscatedName("kr")
   static int field449;
   @ObfuscatedName("kb")
   static int overheadTextCount;
   @ObfuscatedName("kp")
   static int overheadTextLimit;
   @ObfuscatedName("ku")
   static int[] overheadTextXs;
   @ObfuscatedName("kt")
   static int[] overheadTextYs;
   @ObfuscatedName("ko")
   static int[] overheadTextAscents;
   @ObfuscatedName("ki")
   static int[] overheadTextXOffsets;
   @ObfuscatedName("kz")
   static int[] overheadTextColors;
   @ObfuscatedName("kd")
   static int[] overheadTextEffects;
   @ObfuscatedName("kf")
   static int[] overheadTextCyclesRemaining;
   @ObfuscatedName("kq")
   static String[] overheadText;
   @ObfuscatedName("kk")
   static int[][] tileLastDrawnActor;
   @ObfuscatedName("kw")
   static int viewportDrawCount;
   @ObfuscatedName("kj")
   static int viewportTempX;
   @ObfuscatedName("kh")
   static int viewportTempY;
   @ObfuscatedName("lb")
   static int mouseCrossX;
   @ObfuscatedName("lc")
   static int mouseCrossY;
   @ObfuscatedName("ll")
   static int mouseCrossState;
   @ObfuscatedName("lk")
   static int mouseCrossColor;
   @ObfuscatedName("lu")
   static boolean showMouseCross;
   @ObfuscatedName("lg")
   static int field469;
   @ObfuscatedName("ls")
   static int field470;
   @ObfuscatedName("lm")
   static int dragItemSlotSource;
   @ObfuscatedName("lh")
   static int draggedWidgetX;
   @ObfuscatedName("lj")
   static int draggedWidgetY;
   @ObfuscatedName("li")
   static int dragItemSlotDestination;
   @ObfuscatedName("le")
   static boolean field475;
   @ObfuscatedName("lq")
   static int itemDragDuration;
   @ObfuscatedName("lt")
   static int field536;
   @ObfuscatedName("ln")
   static boolean showLoadingMessages;
   @ObfuscatedName("ly")
   @ObfuscatedSignature(
      descriptor = "[Lcj;"
   )
   static Player[] players;
   @ObfuscatedName("lr")
   static int localPlayerIndex;
   @ObfuscatedName("lx")
   static int field537;
   @ObfuscatedName("la")
   static long field482;
   @ObfuscatedName("mn")
   static boolean renderSelf;
   @ObfuscatedName("ms")
   static int drawPlayerNames;
   @ObfuscatedName("mk")
   static int field624;
   @ObfuscatedName("me")
   static int[] field486;
   @ObfuscatedName("mb")
   static final int[] playerMenuOpcodes;
   @ObfuscatedName("mr")
   static String[] playerMenuActions;
   @ObfuscatedName("mi")
   static boolean[] playerOptionsPriorities;
   @ObfuscatedName("md")
   static int[] defaultRotations;
   @ObfuscatedName("mq")
   static int combatTargetPlayerIndex;
   @ObfuscatedName("mu")
   @ObfuscatedSignature(
      descriptor = "[[[Lmq;"
   )
   static NodeDeque[][][] groundItems;
   @ObfuscatedName("mv")
   @ObfuscatedSignature(
      descriptor = "Lmq;"
   )
   static NodeDeque pendingSpawns;
   @ObfuscatedName("ma")
   @ObfuscatedSignature(
      descriptor = "Lmq;"
   )
   static NodeDeque projectiles;
   @ObfuscatedName("mo")
   @ObfuscatedSignature(
      descriptor = "Lmq;"
   )
   static NodeDeque graphicsObjects;
   @ObfuscatedName("mm")
   static int[] currentLevels;
   @ObfuscatedName("mj")
   static int[] levels;
   @ObfuscatedName("my")
   static int[] experience;
   @ObfuscatedName("mp")
   static boolean leftClickOpensMenu;
   @ObfuscatedName("mc")
   static boolean isMenuOpen;
   @ObfuscatedName("nm")
   static int menuOptionsCount;
   @ObfuscatedName("nv")
   static int[] menuArguments1;
   @ObfuscatedName("nu")
   static int[] menuArguments2;
   @ObfuscatedName("ny")
   static int[] menuOpcodes;
   @ObfuscatedName("np")
   static int[] menuIdentifiers;
   @ObfuscatedName("ne")
   static int[] menuItemIds;
   @ObfuscatedName("na")
   static String[] menuActions;
   @ObfuscatedName("nl")
   static String[] menuTargets;
   @ObfuscatedName("nk")
   static boolean[] menuShiftClick;
   @ObfuscatedName("nf")
   static boolean followerOpsLowPriority;
   @ObfuscatedName("nh")
   static boolean shiftClickDrop;
   @ObfuscatedName("nr")
   static boolean tapToDrop;
   @ObfuscatedName("nd")
   static boolean showMouseOverText;
   @ObfuscatedName("no")
   static int viewportX;
   @ObfuscatedName("nq")
   static int viewportY;
   @ObfuscatedName("nz")
   static int field398;
   @ObfuscatedName("nj")
   static int field366;
   @ObfuscatedName("nn")
   static int isItemSelected;
   @ObfuscatedName("nc")
   static boolean isSpellSelected;
   @ObfuscatedName("oy")
   static int selectedSpellChildIndex;
   @ObfuscatedName("og")
   static int selectedSpellItemId;
   @ObfuscatedName("os")
   static String selectedSpellActionName;
   @ObfuscatedName("od")
   static String selectedSpellName;
   @ObfuscatedName("oq")
   static int rootInterface;
   @ObfuscatedName("oa")
   @ObfuscatedSignature(
      descriptor = "Lqp;"
   )
   static NodeHashTable interfaceParents;
   @ObfuscatedName("ox")
   static int field636;
   @ObfuscatedName("oi")
   static int field528;
   @ObfuscatedName("oo")
   static int chatEffects;
   @ObfuscatedName("on")
   static int field530;
   @ObfuscatedName("ok")
   @ObfuscatedSignature(
      descriptor = "Lkd;"
   )
   static Widget meslayerContinueWidget;
   @ObfuscatedName("of")
   static int runEnergy;
   @ObfuscatedName("ow")
   static int weight;
   @ObfuscatedName("op")
   static int staffModLevel;
   @ObfuscatedName("oj")
   static int followerIndex;
   @ObfuscatedName("oc")
   static boolean playerMod;
   @ObfuscatedName("oz")
   @ObfuscatedSignature(
      descriptor = "Lkd;"
   )
   static Widget viewportWidget;
   @ObfuscatedName("om")
   @ObfuscatedSignature(
      descriptor = "Lkd;"
   )
   static Widget clickedWidget;
   @ObfuscatedName("ob")
   @ObfuscatedSignature(
      descriptor = "Lkd;"
   )
   static Widget clickedWidgetParent;
   @ObfuscatedName("or")
   static int widgetClickX;
   @ObfuscatedName("pe")
   static int widgetClickY;
   @ObfuscatedName("pv")
   @ObfuscatedSignature(
      descriptor = "Lkd;"
   )
   static Widget draggedOnWidget;
   @ObfuscatedName("pa")
   static boolean field590;
   @ObfuscatedName("ps")
   static int field544;
   @ObfuscatedName("ph")
   static int field458;
   @ObfuscatedName("pu")
   static boolean field546;
   @ObfuscatedName("pf")
   static int field364;
   @ObfuscatedName("pn")
   static int field548;
   @ObfuscatedName("px")
   static boolean isDraggingWidget;
   @ObfuscatedName("po")
   static int cycleCntr;
   @ObfuscatedName("pl")
   static int[] changedVarps;
   @ObfuscatedName("pq")
   static int changedVarpCount;
   @ObfuscatedName("pk")
   static int[] changedItemContainers;
   @ObfuscatedName("pd")
   static int changedItemContainersCount;
   @ObfuscatedName("pc")
   static int[] changedSkills;
   @ObfuscatedName("pb")
   static int changedSkillsCount;
   @ObfuscatedName("pz")
   static int[] field557;
   @ObfuscatedName("pt")
   static int field558;
   @ObfuscatedName("pg")
   static int chatCycle;
   @ObfuscatedName("pi")
   static int field560;
   @ObfuscatedName("ql")
   static int field455;
   @ObfuscatedName("qp")
   static int field562;
   @ObfuscatedName("qn")
   static int field358;
   @ObfuscatedName("qc")
   static int field622;
   @ObfuscatedName("qi")
   static int field565;
   @ObfuscatedName("qt")
   static int field566;
   @ObfuscatedName("qd")
   static int mouseWheelRotation;
   @ObfuscatedName("qj")
   @ObfuscatedSignature(
      descriptor = "Lrd;"
   )
   static class484 field350;
   @ObfuscatedName("qh")
   @ObfuscatedSignature(
      descriptor = "Lmq;"
   )
   static NodeDeque scriptEvents;
   @ObfuscatedName("qr")
   @ObfuscatedSignature(
      descriptor = "Lmq;"
   )
   static NodeDeque field570;
   @ObfuscatedName("qg")
   @ObfuscatedSignature(
      descriptor = "Lmq;"
   )
   static NodeDeque field571;
   @ObfuscatedName("qo")
   @ObfuscatedSignature(
      descriptor = "Lmq;"
   )
   static NodeDeque field572;
   @ObfuscatedName("qs")
   @ObfuscatedSignature(
      descriptor = "Lqp;"
   )
   static NodeHashTable widgetFlags;
   @ObfuscatedName("qm")
   static int rootWidgetCount;
   @ObfuscatedName("qb")
   static int field653;
   @ObfuscatedName("qw")
   static boolean[] field576;
   @ObfuscatedName("qe")
   static boolean[] field577;
   @ObfuscatedName("qx")
   static boolean[] field578;
   @ObfuscatedName("qy")
   static int[] rootWidgetXs;
   @ObfuscatedName("qz")
   static int[] rootWidgetYs;
   @ObfuscatedName("rf")
   static int[] rootWidgetWidths;
   @ObfuscatedName("rq")
   static int[] rootWidgetHeights;
   @ObfuscatedName("rk")
   static int gameDrawingMode;
   @ObfuscatedName("rh")
   static long field584;
   @ObfuscatedName("rl")
   static boolean isResizable;
   @ObfuscatedName("ra")
   static int[] field586;
   @ObfuscatedName("rx")
   static int publicChatMode;
   @ObfuscatedName("rs")
   static int tradeChatMode;
   @ObfuscatedName("rg")
   static String field589;
   @ObfuscatedName("rt")
   static long[] crossWorldMessageIds;
   @ObfuscatedName("rr")
   static int crossWorldMessageIdsIndex;
   @ObfuscatedName("rc")
   @ObfuscatedSignature(
      descriptor = "Lgc;"
   )
   public static class201 keyHandlerInstance;
   @ObfuscatedName("re")
   @ObfuscatedSignature(
      descriptor = "Lgb;"
   )
   static class199 field417;
   @ObfuscatedName("rn")
   static int field555;
   @ObfuscatedName("rb")
   static int[] field619;
   @ObfuscatedName("rw")
   static int[] field596;
   @ObfuscatedName("fj")
   String field626;
   @ObfuscatedName("fw")
   @ObfuscatedSignature(
      descriptor = "Ln;"
   )
   class14 field391;
   @ObfuscatedName("gf")
   @ObfuscatedSignature(
      descriptor = "Lt;"
   )
   class19 field392;
   @ObfuscatedName("go")
   OtlTokenRequester field393;
   @ObfuscatedName("gj")
   Future field394;
   @ObfuscatedName("gp")
   boolean field435 = false;
   @ObfuscatedName("gz")
   @ObfuscatedSignature(
      descriptor = "Lt;"
   )
   class19 field499;
   @ObfuscatedName("gl")
   @ObfuscatedSignature(
      descriptor = "Lcom/jagex/oldscape/pub/RefreshAccessTokenRequester;"
   )
   RefreshAccessTokenRequester field511;
   @ObfuscatedName("gq")
   Future field468;
   @ObfuscatedName("gt")
   @ObfuscatedSignature(
      descriptor = "Lqy;"
   )
   Buffer field402;
   @ObfuscatedName("gc")
   @ObfuscatedSignature(
      descriptor = "Lr;"
   )
   class7 field418;
   @ObfuscatedName("gw")
   long field404 = -1L;

   static {
      playerAttackOption = AttackOption.AttackOption_hidden;
      npcAttackOption = AttackOption.AttackOption_hidden;
      titleLoadingStage = 0;
      js5ConnectState = 0;
      field382 = 0;
      js5Errors = 0;
      loginState = 0;
      field493 = 0;
      field386 = 0;
      field372 = 0;
      field385 = class132.field1276;
      field485 = class471.field4044;
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

      field399 = EnumComposition.method944(var2);
      Login_isUsernameRemembered = false;
      secureRandomFuture = new SecureRandomFuture();
      randomDatData = null;
      npcs = new NPC[65536];
      npcCount = 0;
      npcIndices = new int[65536];
      field409 = 0;
      field410 = new int[250];
      packetWriter = new PacketWriter();
      logoutTimer = 0;
      hadNetworkError = false;
      timer = new Timer();
      fontsMap = new HashMap();
      field446 = 0;
      field600 = 1;
      field631 = 0;
      field419 = 1;
      field503 = 0;
      collisionMaps = new CollisionMap[4];
      isInInstance = false;
      instanceChunkTemplates = new int[4][13][13];
      field424 = new int[]{0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3};
      field408 = 0;
      field564 = 2301979;
      field496 = 5063219;
      field377 = 3353893;
      field429 = 7759444;
      field534 = false;
      alternativeScrollbarWidth = 0;
      camAngleX = 128;
      camAngleY = 0;
      camAngleDY = 0;
      camAngleDX = 0;
      mouseCamClickedX = 0;
      mouseCamClickedY = 0;
      oculusOrbState = 0;
      camFollowHeight = 50;
      field483 = 0;
      field441 = 0;
      field442 = 0;
      oculusOrbNormalSpeed = 12;
      oculusOrbSlowedSpeed = 6;
      field634 = 0;
      field374 = false;
      field652 = 0;
      field448 = false;
      field449 = 0;
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
      field469 = 0;
      field470 = 0;
      dragItemSlotSource = 0;
      draggedWidgetX = 0;
      draggedWidgetY = 0;
      dragItemSlotDestination = 0;
      field475 = false;
      itemDragDuration = 0;
      field536 = 0;
      showLoadingMessages = true;
      players = new Player[2048];
      localPlayerIndex = -1;
      field537 = 0;
      field482 = -1L;
      renderSelf = true;
      drawPlayerNames = 0;
      field624 = 0;
      field486 = new int[1000];
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
      field398 = 0;
      field366 = 50;
      isItemSelected = 0;
      selectedItemName = null;
      isSpellSelected = false;
      selectedSpellChildIndex = -1;
      selectedSpellItemId = -1;
      selectedSpellActionName = null;
      selectedSpellName = null;
      rootInterface = -1;
      interfaceParents = new NodeHashTable(8);
      field636 = 0;
      field528 = -1;
      chatEffects = 0;
      field530 = 0;
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
      field590 = false;
      field544 = -1;
      field458 = -1;
      field546 = false;
      field364 = -1;
      field548 = -1;
      isDraggingWidget = false;
      cycleCntr = 1;
      changedVarps = new int[32];
      changedVarpCount = 0;
      changedItemContainers = new int[32];
      changedItemContainersCount = 0;
      changedSkills = new int[32];
      changedSkillsCount = 0;
      field557 = new int[32];
      field558 = 0;
      chatCycle = 0;
      field560 = 0;
      field455 = 0;
      field562 = 0;
      field358 = 0;
      field622 = 0;
      field565 = 0;
      field566 = 0;
      mouseWheelRotation = 0;
      field350 = new class484();
      scriptEvents = new NodeDeque();
      field570 = new NodeDeque();
      field571 = new NodeDeque();
      field572 = new NodeDeque();
      widgetFlags = new NodeHashTable(512);
      rootWidgetCount = 0;
      field653 = -2;
      field576 = new boolean[100];
      field577 = new boolean[100];
      field578 = new boolean[100];
      rootWidgetXs = new int[100];
      rootWidgetYs = new int[100];
      rootWidgetWidths = new int[100];
      rootWidgetHeights = new int[100];
      gameDrawingMode = 0;
      field584 = 0L;
      isResizable = true;
      field586 = new int[]{16776960, 16711680, 65280, 65535, 16711935, 16777215};
      publicChatMode = 0;
      tradeChatMode = 0;
      field589 = "";
      crossWorldMessageIds = new long[100];
      crossWorldMessageIdsIndex = 0;
      keyHandlerInstance = new class201();
      field417 = new class199();
      field555 = 0;
      field619 = new int[128];
      field596 = new int[128];
      userRegistrationId = -1L;
      currentClanSettings = new ClanSettings[4];
      currentClanChannels = new ClanChannel[4];
      field464 = -1;
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
      field617 = false;
      cameraShaking = new boolean[5];
      cameraShakeIntensity = new int[5];
      cameraMoveIntensity = new int[5];
      cameraShakeSpeed = new int[5];
      cameraShakeCycle = new int[5];
      field623 = 256;
      field395 = 205;
      zoomHeight = 256;
      zoomWidth = 320;
      field535 = 1;
      field628 = 32767;
      field629 = 1;
      field355 = 32767;
      viewportOffsetX = 0;
      viewportOffsetY = 0;
      viewportWidth = 0;
      viewportHeight = 0;
      viewportZoom = 0;
      playerAppearance = new PlayerComposition();
      field637 = -1;
      field638 = -1;
      platformInfoProvider = new DesktopPlatformInfoProvider();
      grandExchangeOffers = new GrandExchangeOffer[8];
      GrandExchangeEvents_worldComparator = new GrandExchangeOfferOwnWorldComparator();
      archive5 = new class384(8, class382.field3657);
      Widget_cachedModels = new EvictingDualNodeHashTable(64);
      Widget_cachedFonts = new EvictingDualNodeHashTable(64);
      field645 = -1;
      field646 = -1;
      archiveLoaders = new ArrayList(10);
      archiveLoadersDone = 0;
      field649 = 0;
      field650 = new ApproximateRouteStrategy();
      field651 = new int[50];
      field630 = new int[50];
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "-101"
   )
   protected final void resizeGame() {
      field584 = Message.method344() + 500L;
      this.resizeJS();
      if (rootInterface != -1) {
         this.resizeRoot(true);
      }

   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "0"
   )
   protected final void setUp() {
      int[] var1 = new int[]{20, 260, 10000};
      int[] var2 = new int[]{1000, 100, 500};
      if (var1 != null && var2 != null) {
         Frames.ByteArrayPool_alternativeSizes = var1;
         ModelData0.ByteArrayPool_altSizeArrayCounts = new int[var1.length];
         SceneTilePaint.ByteArrayPool_arrays = new byte[var1.length][][];

         for(int var3 = 0; var3 < Frames.ByteArrayPool_alternativeSizes.length; ++var3) {
            SceneTilePaint.ByteArrayPool_arrays[var3] = new byte[var2[var3]][];
            ByteArrayPool.field3641.add(var1[var3]);
         }

         Collections.sort(ByteArrayPool.field3641);
      } else {
         Frames.ByteArrayPool_alternativeSizes = null;
         ModelData0.ByteArrayPool_altSizeArrayCounts = null;
         SceneTilePaint.ByteArrayPool_arrays = null;
         ByteArrayPool.field3641.clear();
         ByteArrayPool.field3641.add(100);
         ByteArrayPool.field3641.add(5000);
         ByteArrayPool.field3641.add(10000);
         ByteArrayPool.field3641.add(30000);
      }

      ClanChannel.worldPort = gameBuild == 0 ? 'ꩊ' : worldId + '鱀';
      class137.js5Port = gameBuild == 0 ? 443 : worldId + '썐';
      class31.currentPort = ClanChannel.worldPort;
      class86.field869 = class304.field2849;
      TriBool.field3706 = class304.field2848;
      NewShit.field1545 = class304.field2852;
      Varps.field2794 = class304.field2850;
      TaskHandler.urlRequester = new class109(this.field435, 210);
      this.setUpKeyboard();
      this.method169();
      class86.mouseWheel = this.mouseWheel();
      this.method152(field417, 0);
      this.method152(keyHandlerInstance, 1);
      WorldMapArea.masterDisk = new ArchiveDisk(255, JagexCache.JagexCache_dat2File, JagexCache.JagexCache_idx255File, 500000);
      StructComposition.clientPreferences = class319.method1771();
      this.setUpClipboard();
      String var4 = BoundaryObject.field2215;
      class32.field86 = this;
      if (var4 != null) {
         class32.field87 = var4;
      }

      class101.setWindowedMode(StructComposition.clientPreferences.method551());
      DefaultsGroup.friendSystem = new FriendSystem(SecureRandomFuture.loginType);
      this.field391 = new class14("tokenRequest", 1, 1);
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "-22"
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
            Occluder.method1241();
            playPcmPlayers();
            keyHandlerInstance.method1081();
            this.method151();
            MouseHandler var8 = MouseHandler.MouseHandler_instance;
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

            if (class86.mouseWheel != null) {
               int var5 = class86.mouseWheel.useRotation();
               mouseWheelRotation = var5;
            }

            if (gameState == 0) {
               Tiles.load();
               class29.method117();
            } else if (gameState == 5) {
               ObjTypeCustomisation.loginScreen(this, AbstractWorldMapData.fontPlain12);
               Tiles.load();
               class29.method117();
            } else if (gameState != 10 && gameState != 11) {
               if (gameState == 20) {
                  ObjTypeCustomisation.loginScreen(this, AbstractWorldMapData.fontPlain12);
                  this.doCycleLoggedOut();
               } else if (gameState == 50) {
                  ObjTypeCustomisation.loginScreen(this, AbstractWorldMapData.fontPlain12);
                  this.doCycleLoggedOut();
               } else if (gameState == 25) {
                  GameEngine.method180();
               }
            } else {
               ObjTypeCustomisation.loginScreen(this, AbstractWorldMapData.fontPlain12);
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

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "(ZI)V",
      garbageValue = "920051106"
   )
   protected final void draw(boolean var1) {
      boolean var2 = class37.method184();
      if (var2 && playingJingle && TileItem.pcmPlayer0 != null) {
         TileItem.pcmPlayer0.tryDiscard();
      }

      if ((gameState == 10 || gameState == 20 || gameState == 30) && 0L != field584 && Message.method344() > field584) {
         class101.setWindowedMode(Message.getWindowedMode());
      }

      int var3;
      if (var1) {
         for(var3 = 0; var3 < 100; ++var3) {
            field576[var3] = true;
         }
      }

      if (gameState == 0) {
         this.drawInitial(Login.Login_loadingPercent, Login.Login_loadingText, var1);
      } else if (gameState == 5) {
         class199.drawTitle(class146.fontBold12, class151.fontPlain11, AbstractWorldMapData.fontPlain12);
      } else if (gameState != 10 && gameState != 11) {
         if (gameState == 20) {
            class199.drawTitle(class146.fontBold12, class151.fontPlain11, AbstractWorldMapData.fontPlain12);
         } else if (gameState == 50) {
            class199.drawTitle(class146.fontBold12, class151.fontPlain11, AbstractWorldMapData.fontPlain12);
         } else if (gameState == 25) {
            if (field503 == 1) {
               if (field446 > field600) {
                  field600 = field446;
               }

               var3 = (field600 * 50 - field446 * 50) / field600;
               SoundSystem.drawLoadingMessage("Loading - please wait." + "<br>" + " (" + var3 + "%" + ")", false);
            } else if (field503 == 2) {
               if (field631 > field419) {
                  field419 = field631;
               }

               var3 = (field419 * 50 - field631 * 50) / field419 + 50;
               SoundSystem.drawLoadingMessage("Loading - please wait." + "<br>" + " (" + var3 + "%" + ")", false);
            } else {
               SoundSystem.drawLoadingMessage("Loading - please wait.", false);
            }
         } else if (gameState == 30) {
            this.drawLoggedIn();
         } else if (gameState == 40) {
            SoundSystem.drawLoadingMessage("Connection lost" + "<br>" + "Please wait - attempting to reestablish", false);
         } else if (gameState == 45) {
            SoundSystem.drawLoadingMessage("Please wait...", false);
         }
      } else {
         class199.drawTitle(class146.fontBold12, class151.fontPlain11, AbstractWorldMapData.fontPlain12);
      }

      if (gameState == 30 && gameDrawingMode == 0 && !var1 && !isResizable) {
         for(var3 = 0; var3 < rootWidgetCount; ++var3) {
            if (field577[var3]) {
               RouteStrategy.rasterProvider.draw(rootWidgetXs[var3], rootWidgetYs[var3], rootWidgetWidths[var3], rootWidgetHeights[var3]);
               field577[var3] = false;
            }
         }
      } else if (gameState > 0) {
         RouteStrategy.rasterProvider.drawFull(0, 0);

         for(var3 = 0; var3 < rootWidgetCount; ++var3) {
            field577[var3] = false;
         }
      }

   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "1295386641"
   )
   protected final void kill0() {
      if (WorldMapArea.varcs.hasUnwrittenChanges()) {
         WorldMapArea.varcs.write();
      }

      if (class271.mouseRecorder != null) {
         class271.mouseRecorder.isRunning = false;
      }

      class271.mouseRecorder = null;
      packetWriter.close();
      if (MouseHandler.MouseHandler_instance != null) {
         MouseHandler var1 = MouseHandler.MouseHandler_instance;
         synchronized(MouseHandler.MouseHandler_instance) {
            MouseHandler.MouseHandler_instance = null;
         }
      }

      class86.mouseWheel = null;
      if (TileItem.pcmPlayer0 != null) {
         TileItem.pcmPlayer0.shutdown();
      }

      if (UserComparator8.pcmPlayer1 != null) {
         UserComparator8.pcmPlayer1.shutdown();
      }

      class241.method1410();
      class182.method938();
      if (TaskHandler.urlRequester != null) {
         TaskHandler.urlRequester.close();
         TaskHandler.urlRequester = null;
      }

      try {
         JagexCache.JagexCache_dat2File.close();

         for(int var3 = 0; var3 < class145.idxCount; ++var3) {
            JagexCache.JagexCache_idxFiles[var3].close();
         }

         JagexCache.JagexCache_idx255File.close();
         JagexCache.JagexCache_randomDat.close();
      } catch (Exception var5) {
         ;
      }

      this.field391.method50();
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "1344730333"
   )
   protected final void vmethod1485() {
   }

   @ObfuscatedName("fw")
   @ObfuscatedSignature(
      descriptor = "(I)Z",
      garbageValue = "854239934"
   )
   boolean method355() {
      return class146.field1331 != null && !class146.field1331.trim().isEmpty() && EnumComposition.field1536 != null && !EnumComposition.field1536.trim().isEmpty();
   }

   @ObfuscatedName("gf")
   @ObfuscatedSignature(
      descriptor = "(I)Z",
      garbageValue = "1394434953"
   )
   boolean method356() {
      return this.field393 != null;
   }

   @ObfuscatedName("go")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;I)V",
      garbageValue = "-1380875152"
   )
   void method377(String var1) throws IOException {
      HashMap var2 = new HashMap();
      var2.put("grant_type", "refresh_token");
      var2.put("scope", "gamesso.token.create");
      var2.put("refresh_token", var1);
      URL var3 = new URL(class17.field51 + "shield/oauth/token" + (new class423(var2)).method2177());
      HashMap var4 = new HashMap();
      var4.put("Authorization", "Basic " + field399);
      var4.put("Host", (new URL(class17.field51)).getHost());
      var4.put("Accept", class420.field3792.method2169());
      class9 var5 = class9.field25;
      RefreshAccessTokenRequester var6 = this.field511;
      if (var6 != null) {
         this.field468 = var6.request(var5.method26(), var3, var4, "");
      } else {
         class10 var7 = new class10(var3, var5, this.field435);
         Iterator var8 = var4.entrySet().iterator();

         while(var8.hasNext()) {
            Entry var9 = (Entry)var8.next();
            var7.method35((String)var9.getKey(), (String)var9.getValue());
         }

         this.field499 = this.field391.method47(var7);
      }
   }

   @ObfuscatedName("gj")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;I)V",
      garbageValue = "-426259759"
   )
   void method357(String var1) throws MalformedURLException, IOException {
      URL var2 = new URL(class17.field51 + "public/v1/games/YCfdbvr2pM1zUYMxJRexZY/play");
      HashMap var3 = new HashMap();
      var3.put("Authorization", "Bearer " + var1);
      class9 var4 = class9.field16;
      OtlTokenRequester var5 = this.field393;
      if (var5 != null) {
         this.field394 = var5.request(var4.method26(), var2, var3, "");
      } else {
         class10 var6 = new class10(var2, var4, this.field435);
         Iterator var7 = var3.entrySet().iterator();

         while(var7.hasNext()) {
            Entry var8 = (Entry)var7.next();
            var6.method35((String)var8.getKey(), (String)var8.getValue());
         }

         this.field392 = this.field391.method47(var6);
      }
   }

   @ObfuscatedName("gz")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "-1825291822"
   )
   void doCycleJs5() {
      if (gameState != 1000) {
         boolean var1 = WallDecoration.method1297();
         if (!var1) {
            this.doCycleJs5Connect();
         }

      }
   }

   @ObfuscatedName("gl")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "-924281456"
   )
   void doCycleJs5Connect() {
      if (NetCache.NetCache_crcMismatches >= 4) {
         this.error("js5crc");
         class140.updateGameState(1000);
      } else {
         if (NetCache.NetCache_ioExceptions >= 4) {
            if (gameState <= 5) {
               this.error("js5io");
               class140.updateGameState(1000);
               return;
            }

            field382 = 3000;
            NetCache.NetCache_ioExceptions = 3;
         }

         if (--field382 + 1 <= 0) {
            try {
               if (js5ConnectState == 0) {
                  class357.js5SocketTask = class242.taskHandler.newSocketTask(class139.worldHost, class31.currentPort);
                  ++js5ConnectState;
               }

               if (js5ConnectState == 1) {
                  if (class357.js5SocketTask.status == 2) {
                     this.js5Error(-1);
                     return;
                  }

                  if (class357.js5SocketTask.status == 1) {
                     ++js5ConnectState;
                  }
               }

               Buffer var3;
               if (js5ConnectState == 2) {
                  Socket var2 = (Socket)class357.js5SocketTask.result;
                  BufferedNetSocket var1 = new BufferedNetSocket(var2, 40000, 5000);
                  WorldMapIcon_1.js5Socket = var1;
                  var3 = new Buffer(5);
                  var3.writeByte(15);
                  var3.writeInt(210);
                  WorldMapIcon_1.js5Socket.write(var3.array, 0, 5);
                  ++js5ConnectState;
                  FileSystem.field1432 = Message.method344();
               }

               if (js5ConnectState == 3) {
                  if (WorldMapIcon_1.js5Socket.available() > 0) {
                     int var5 = WorldMapIcon_1.js5Socket.readUnsignedByte();
                     if (var5 != 0) {
                        this.js5Error(var5);
                        return;
                     }

                     ++js5ConnectState;
                  } else if (Message.method344() - FileSystem.field1432 > 30000L) {
                     this.js5Error(-2);
                     return;
                  }
               }

               if (js5ConnectState == 4) {
                  AbstractSocket var13 = WorldMapIcon_1.js5Socket;
                  boolean var6 = gameState > 20;
                  if (NetCache.NetCache_socket != null) {
                     try {
                        NetCache.NetCache_socket.close();
                     } catch (Exception var11) {
                        ;
                     }

                     NetCache.NetCache_socket = null;
                  }

                  NetCache.NetCache_socket = var13;
                  if (NetCache.NetCache_socket != null) {
                     try {
                        var3 = new Buffer(4);
                        var3.writeByte(var6 ? 2 : 3);
                        var3.writeMedium(0);
                        NetCache.NetCache_socket.write(var3.array, 0, 4);
                     } catch (IOException var10) {
                        try {
                           NetCache.NetCache_socket.close();
                        } catch (Exception var9) {
                           ;
                        }

                        ++NetCache.NetCache_ioExceptions;
                        NetCache.NetCache_socket = null;
                     }
                  }

                  NetCache.NetCache_responseHeaderBuffer.offset = 0;
                  NewShit.NetCache_currentResponse = null;
                  ModeWhere.NetCache_responseArchiveBuffer = null;
                  NetCache.field3466 = 0;

                  while(true) {
                     NetFileRequest var14 = (NetFileRequest)NetCache.NetCache_pendingPriorityResponses.first();
                     if (var14 == null) {
                        while(true) {
                           var14 = (NetFileRequest)NetCache.NetCache_pendingResponses.first();
                           if (var14 == null) {
                              if (NetCache.field3481 != 0) {
                                 try {
                                    var3 = new Buffer(4);
                                    var3.writeByte(4);
                                    var3.writeByte(NetCache.field3481);
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
                              NetCache.field3468 = Message.method344();
                              class357.js5SocketTask = null;
                              WorldMapIcon_1.js5Socket = null;
                              js5ConnectState = 0;
                              js5Errors = 0;
                              return;
                           }

                           NetCache.NetCache_pendingWritesQueue.addLast(var14);
                           NetCache.NetCache_pendingWrites.put(var14, var14.key);
                           ++NetCache.NetCache_pendingWritesCount;
                           --NetCache.NetCache_pendingResponsesCount;
                        }
                     }

                     NetCache.NetCache_pendingPriorityWrites.put(var14, var14.key);
                     ++NetCache.NetCache_pendingPriorityWritesCount;
                     --NetCache.NetCache_pendingPriorityResponsesCount;
                  }
               }
            } catch (IOException var12) {
               this.js5Error(-3);
            }

         }
      }
   }

   @ObfuscatedName("gq")
   @ObfuscatedSignature(
      descriptor = "(II)V",
      garbageValue = "1264077438"
   )
   void js5Error(int var1) {
      class357.js5SocketTask = null;
      WorldMapIcon_1.js5Socket = null;
      js5ConnectState = 0;
      if (class31.currentPort == ClanChannel.worldPort) {
         class31.currentPort = class137.js5Port;
      } else {
         class31.currentPort = ClanChannel.worldPort;
      }

      ++js5Errors;
      if (js5Errors < 2 || var1 != 7 && var1 != 9) {
         if (js5Errors >= 2 && var1 == 6) {
            this.error("js5connect_outofdate");
            class140.updateGameState(1000);
         } else if (js5Errors >= 4) {
            if (gameState <= 5) {
               this.error("js5connect");
               class140.updateGameState(1000);
            } else {
               field382 = 3000;
            }
         }
      } else if (gameState <= 5) {
         this.error("js5connect_full");
         class140.updateGameState(1000);
      } else {
         field382 = 3000;
      }

   }

   @ObfuscatedName("gm")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "25"
   )
   final void doCycleLoggedOut() {
      Object var1 = packetWriter.getSocket();
      PacketBuffer var2 = packetWriter.packetBuffer;

      try {
         if (loginState == 0) {
            if (class34.secureRandom == null && (secureRandomFuture.isDone() || field493 > 250)) {
               class34.secureRandom = secureRandomFuture.get();
               secureRandomFuture.shutdown();
               secureRandomFuture = null;
            }

            if (class34.secureRandom != null) {
               if (var1 != null) {
                  ((AbstractSocket)var1).close();
                  var1 = null;
               }

               class19.socketTask = null;
               hadNetworkError = false;
               field493 = 0;
               if (field485.method2423()) {
                  try {
                     this.method377(EnumComposition.field1536);
                     class37.method186(21);
                  } catch (Throwable var25) {
                     class132.RunException_sendStackTrace((String)null, var25);
                     class32.getLoginError(65);
                     return;
                  }
               } else {
                  class37.method186(1);
               }
            }
         }

         class21 var28;
         if (loginState == 21) {
            if (this.field468 != null) {
               if (!this.field468.isDone()) {
                  return;
               }

               if (this.field468.isCancelled()) {
                  class32.getLoginError(65);
                  this.field468 = null;
                  return;
               }

               try {
                  RefreshAccessTokenResponse var3 = (RefreshAccessTokenResponse)this.field468.get();
                  if (!var3.isSuccess()) {
                     class32.getLoginError(65);
                     this.field468 = null;
                     return;
                  }

                  class146.field1331 = var3.getAccessToken();
                  EnumComposition.field1536 = var3.getRefreshToken();
                  this.field468 = null;
               } catch (Exception var24) {
                  class132.RunException_sendStackTrace((String)null, var24);
                  class32.getLoginError(65);
                  this.field468 = null;
                  return;
               }
            } else {
               if (this.field499 == null) {
                  class32.getLoginError(65);
                  return;
               }

               if (!this.field499.method67()) {
                  return;
               }

               if (this.field499.method68()) {
                  class132.RunException_sendStackTrace(this.field499.method66(), (Throwable)null);
                  class32.getLoginError(65);
                  this.field499 = null;
                  return;
               }

               var28 = this.field499.method69();
               if (var28.method74() != 200) {
                  class32.getLoginError(65);
                  this.field499 = null;
                  return;
               }

               field493 = 0;
               class422 var4 = new class422(var28.method75());

               try {
                  class146.field1331 = var4.method2173().getString("access_token");
                  EnumComposition.field1536 = var4.method2173().getString("refresh_token");
               } catch (Exception var23) {
                  class132.RunException_sendStackTrace("Error parsing tokens", var23);
                  class32.getLoginError(65);
                  this.field499 = null;
                  return;
               }
            }

            this.method357(class146.field1331);
            class37.method186(20);
         }

         if (loginState == 20) {
            if (this.field394 != null) {
               if (!this.field394.isDone()) {
                  return;
               }

               if (this.field394.isCancelled()) {
                  class32.getLoginError(65);
                  this.field394 = null;
                  return;
               }

               try {
                  OtlTokenResponse var29 = (OtlTokenResponse)this.field394.get();
                  if (!var29.isSuccess()) {
                     class32.getLoginError(65);
                     this.field394 = null;
                     return;
                  }

                  this.field626 = var29.getToken();
                  this.field394 = null;
               } catch (Exception var22) {
                  class132.RunException_sendStackTrace((String)null, var22);
                  class32.getLoginError(65);
                  this.field394 = null;
                  return;
               }
            } else {
               if (this.field392 == null) {
                  class32.getLoginError(65);
                  return;
               }

               if (!this.field392.method67()) {
                  return;
               }

               if (this.field392.method68()) {
                  class132.RunException_sendStackTrace(this.field392.method66(), (Throwable)null);
                  class32.getLoginError(65);
                  this.field392 = null;
                  return;
               }

               var28 = this.field392.method69();
               if (var28.method74() != 200) {
                  class132.RunException_sendStackTrace("Response code: " + var28.method74() + "Response body: " + var28.method75(), (Throwable)null);
                  class32.getLoginError(65);
                  this.field392 = null;
                  return;
               }

               this.field626 = var28.method75();
               this.field392 = null;
            }

            field493 = 0;
            class37.method186(1);
         }

         if (loginState == 1) {
            if (class19.socketTask == null) {
               class19.socketTask = class242.taskHandler.newSocketTask(class139.worldHost, class31.currentPort);
            }

            if (class19.socketTask.status == 2) {
               throw new IOException();
            }

            if (class19.socketTask.status == 1) {
               Socket var30 = (Socket)class19.socketTask.result;
               BufferedNetSocket var31 = new BufferedNetSocket(var30, 40000, 5000);
               var1 = var31;
               packetWriter.setSocket(var31);
               class19.socketTask = null;
               class37.method186(2);
            }
         }

         PacketBufferNode var32;
         if (loginState == 2) {
            packetWriter.clearBuffer();
            var32 = class109.method651();
            var32.clientPacket = null;
            var32.clientPacketLength = 0;
            var32.packetBuffer = new PacketBuffer(5000);
            var32.packetBuffer.writeByte(LoginPacket.field2679.id);
            packetWriter.addNode(var32);
            packetWriter.flush();
            var2.offset = 0;
            class37.method186(3);
         }

         int var15;
         if (loginState == 3) {
            if (TileItem.pcmPlayer0 != null) {
               TileItem.pcmPlayer0.method226();
            }

            if (UserComparator8.pcmPlayer1 != null) {
               UserComparator8.pcmPlayer1.method226();
            }

            if (((AbstractSocket)var1).isAvailable(1)) {
               var15 = ((AbstractSocket)var1).readUnsignedByte();
               if (TileItem.pcmPlayer0 != null) {
                  TileItem.pcmPlayer0.method226();
               }

               if (UserComparator8.pcmPlayer1 != null) {
                  UserComparator8.pcmPlayer1.method226();
               }

               if (var15 != 0) {
                  class32.getLoginError(var15);
                  return;
               }

               var2.offset = 0;
               class37.method186(4);
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
               VerticalAlignment.field1600 = var2.readLong();
               class37.method186(5);
            }
         }

         if (loginState == 5) {
            packetWriter.packetBuffer.offset = 0;
            packetWriter.clearBuffer();
            PacketBuffer var33 = new PacketBuffer(500);
            int[] var34 = new int[]{class34.secureRandom.nextInt(), class34.secureRandom.nextInt(), class34.secureRandom.nextInt(), class34.secureRandom.nextInt()};
            var33.offset = 0;
            var33.writeByte(1);
            var33.writeInt(var34[0]);
            var33.writeInt(var34[1]);
            var33.writeInt(var34[2]);
            var33.writeInt(var34[3]);
            var33.writeLong(VerticalAlignment.field1600);
            if (gameState == 40) {
               var33.writeInt(WorldMapEvent.field2413[0]);
               var33.writeInt(WorldMapEvent.field2413[1]);
               var33.writeInt(WorldMapEvent.field2413[2]);
               var33.writeInt(WorldMapEvent.field2413[3]);
            } else {
               if (gameState == 50) {
                  var33.writeByte(class132.field1279.rsOrdinal());
                  var33.writeInt(class29.field81);
               } else {
                  var33.writeByte(field385.rsOrdinal());
                  switch(field385.field1278) {
                  case 0:
                     var33.offset += 4;
                  case 1:
                  default:
                     break;
                  case 2:
                     var33.writeInt(StructComposition.clientPreferences.method554(Login.Login_username));
                     break;
                  case 3:
                  case 4:
                     var33.writeMedium(class143.field1321);
                     ++var33.offset;
                  }
               }

               if (field485.method2423()) {
                  var33.writeByte(class471.field4037.rsOrdinal());
                  var33.writeStringCp1252NullTerminated(this.field626);
               } else {
                  var33.writeByte(class471.field4044.rsOrdinal());
                  var33.writeStringCp1252NullTerminated(Login.Login_password);
               }
            }

            var33.encryptRsa(class71.field725, class71.field723);
            WorldMapEvent.field2413 = var34;
            PacketBufferNode var6 = class109.method651();
            var6.clientPacket = null;
            var6.clientPacketLength = 0;
            var6.packetBuffer = new PacketBuffer(5000);
            var6.packetBuffer.offset = 0;
            if (gameState == 40) {
               var6.packetBuffer.writeByte(LoginPacket.field2682.id);
            } else {
               var6.packetBuffer.writeByte(LoginPacket.field2680.id);
            }

            var6.packetBuffer.writeShort(0);
            int var7 = var6.packetBuffer.offset;
            var6.packetBuffer.writeInt(210);
            var6.packetBuffer.writeInt(1);
            var6.packetBuffer.writeByte(clientType);
            var6.packetBuffer.writeByte(field543);
            byte var8 = 0;
            var6.packetBuffer.writeByte(var8);
            var6.packetBuffer.writeBytes(var33.array, 0, var33.offset);
            int var9 = var6.packetBuffer.offset;
            var6.packetBuffer.writeStringCp1252NullTerminated(Login.Login_username);
            var6.packetBuffer.writeByte((isResizable ? 1 : 0) << 1 | (isLowDetail ? 1 : 0));
            var6.packetBuffer.writeShort(CollisionMap.canvasWidth);
            var6.packetBuffer.writeShort(Language.canvasHeight);
            PacketBuffer var10 = var6.packetBuffer;
            int var13;
            if (randomDatData != null) {
               var10.writeBytes(randomDatData, 0, randomDatData.length);
            } else {
               byte[] var12 = new byte[24];

               try {
                  JagexCache.JagexCache_randomDat.seek(0L);
                  JagexCache.JagexCache_randomDat.readFully(var12);

                  for(var13 = 0; var13 < 24 && var12[var13] == 0; ++var13) {
                     ;
                  }

                  if (var13 >= 24) {
                     throw new IOException();
                  }
               } catch (Exception var26) {
                  for(int var14 = 0; var14 < 24; ++var14) {
                     var12[var14] = -1;
                  }
               }

               var10.writeBytes(var12, 0, var12.length);
            }

            var6.packetBuffer.writeStringCp1252NullTerminated(class133.field1284);
            var6.packetBuffer.writeInt(WallDecoration.field2226);
            Buffer var11 = new Buffer(class213.platformInfo.size());
            class213.platformInfo.write(var11);
            var6.packetBuffer.writeBytes(var11.array, 0, var11.array.length);
            var6.packetBuffer.writeByte(clientType);
            var6.packetBuffer.writeInt(0);
            var6.packetBuffer.writeInt(FloorUnderlayDefinition.archive4.hash);
            var6.packetBuffer.method2382(class71.archive12.hash);
            var6.packetBuffer.method2382(VerticalAlignment.archive17.hash);
            var6.packetBuffer.method2381(class89.archive15.hash);
            var6.packetBuffer.method2382(VarpDefinition.archive14.hash);
            var6.packetBuffer.method2381(HitSplatDefinition.archive2.hash);
            var6.packetBuffer.method2382(0);
            var6.packetBuffer.method2383(ClientPreferences.archive8.hash);
            var6.packetBuffer.method2381(class162.archive6.hash);
            var6.packetBuffer.writeInt(class358.archive13.hash);
            var6.packetBuffer.method2382(class170.archive18.hash);
            var6.packetBuffer.writeInt(Frames.field2062.hash);
            var6.packetBuffer.method2383(class301.archive11.hash);
            var6.packetBuffer.writeInt(class9.archive7.hash);
            var6.packetBuffer.writeInt(FontName.archive19.hash);
            var6.packetBuffer.method2383(WorldMapArea.archive20.hash);
            var6.packetBuffer.writeInt(class21.field63.hash);
            var6.packetBuffer.method2381(ClanChannelMember.archive10.hash);
            var6.packetBuffer.method2381(class4.archive9.hash);
            var6.packetBuffer.writeInt(WorldMapSection0.field2342.hash);
            var6.packetBuffer.method2383(HealthBar.field1045.hash);
            var6.packetBuffer.xteaEncrypt(var34, var9, var6.packetBuffer.offset);
            var6.packetBuffer.writeLengthShort(var6.packetBuffer.offset - var7);
            packetWriter.addNode(var6);
            packetWriter.flush();
            packetWriter.isaacCipher = new IsaacCipher(var34);
            int[] var41 = new int[4];

            for(var13 = 0; var13 < 4; ++var13) {
               var41[var13] = var34[var13] + 50;
            }

            var2.newIsaacCipher(var41);
            class37.method186(6);
         }

         int var17;
         if (loginState == 6 && ((AbstractSocket)var1).available() > 0) {
            var15 = ((AbstractSocket)var1).readUnsignedByte();
            if (var15 == 61) {
               var17 = ((AbstractSocket)var1).available();
               class155.field1380 = var17 == 1 && ((AbstractSocket)var1).readUnsignedByte() == 1;
               class37.method186(5);
            }

            if (var15 == 21 && gameState == 20) {
               class37.method186(12);
            } else if (var15 == 2) {
               class37.method186(14);
            } else if (var15 == 15 && gameState == 40) {
               packetWriter.serverPacketLength = -1;
               class37.method186(19);
            } else if (var15 == 64) {
               class37.method186(10);
            } else if (var15 == 23 && field386 < 1) {
               ++field386;
               class37.method186(0);
            } else if (var15 == 29) {
               class37.method186(17);
            } else {
               if (var15 != 69) {
                  class32.getLoginError(var15);
                  return;
               }

               class37.method186(7);
            }
         }

         if (loginState == 7 && ((AbstractSocket)var1).available() >= 2) {
            ((AbstractSocket)var1).read(var2.array, 0, 2);
            var2.offset = 0;
            UserComparator8.field1154 = var2.readUnsignedShort();
            class37.method186(8);
         }

         if (loginState == 8 && ((AbstractSocket)var1).available() >= UserComparator8.field1154) {
            var2.offset = 0;
            ((AbstractSocket)var1).read(var2.array, var2.offset, UserComparator8.field1154);
            class6 var35 = Skills.method1766()[var2.readUnsignedByte()];

            try {
               class3 var36 = NetCache.method1824(var35);
               this.field418 = new class7(var2, var36);
               class37.method186(9);
            } catch (Exception var21) {
               class32.getLoginError(22);
               return;
            }
         }

         if (loginState == 9 && this.field418.method21()) {
            this.field402 = this.field418.method20();
            this.field418.method17();
            this.field418 = null;
            if (this.field402 == null) {
               class32.getLoginError(22);
               return;
            }

            packetWriter.clearBuffer();
            var32 = class109.method651();
            var32.clientPacket = null;
            var32.clientPacketLength = 0;
            var32.packetBuffer = new PacketBuffer(5000);
            var32.packetBuffer.writeByte(LoginPacket.field2683.id);
            var32.packetBuffer.writeShort(this.field402.offset);
            var32.packetBuffer.method2343(this.field402);
            packetWriter.addNode(var32);
            packetWriter.flush();
            this.field402 = null;
            class37.method186(6);
         }

         if (loginState == 10 && ((AbstractSocket)var1).available() > 0) {
            TextureProvider.field2089 = ((AbstractSocket)var1).readUnsignedByte();
            class37.method186(11);
         }

         if (loginState == 11 && ((AbstractSocket)var1).available() >= TextureProvider.field2089) {
            ((AbstractSocket)var1).read(var2.array, 0, TextureProvider.field2089);
            var2.offset = 0;
            class37.method186(6);
         }

         if (loginState == 12 && ((AbstractSocket)var1).available() > 0) {
            field372 = (((AbstractSocket)var1).readUnsignedByte() + 3) * 60;
            class37.method186(13);
         }

         if (loginState == 13) {
            field493 = 0;
            TaskHandler.setLoginResponseString("You have only just left another world.", "Your profile will be transferred in:", field372 / 60 + " seconds.");
            if (--field372 <= 0) {
               class37.method186(0);
            }

         } else {
            if (loginState == 14 && ((AbstractSocket)var1).available() >= 1) {
               class420.field3795 = ((AbstractSocket)var1).readUnsignedByte();
               class37.method186(15);
            }

            if (loginState == 15 && ((AbstractSocket)var1).available() >= class420.field3795) {
               boolean var42 = ((AbstractSocket)var1).readUnsignedByte() == 1;
               ((AbstractSocket)var1).read(var2.array, 0, 4);
               var2.offset = 0;
               boolean var43 = false;
               if (var42) {
                  var17 = var2.readByteIsaac() << 24;
                  var17 |= var2.readByteIsaac() << 16;
                  var17 |= var2.readByteIsaac() << 8;
                  var17 |= var2.readByteIsaac();
                  StructComposition.clientPreferences.method552(Login.Login_username, var17);
               }

               if (Login_isUsernameRemembered) {
                  StructComposition.clientPreferences.method547(Login.Login_username);
               } else {
                  StructComposition.clientPreferences.method547((String)null);
               }

               Tile.savePreferences();
               staffModLevel = ((AbstractSocket)var1).readUnsignedByte();
               playerMod = ((AbstractSocket)var1).readUnsignedByte() == 1;
               localPlayerIndex = ((AbstractSocket)var1).readUnsignedByte();
               localPlayerIndex <<= 8;
               localPlayerIndex += ((AbstractSocket)var1).readUnsignedByte();
               field537 = ((AbstractSocket)var1).readUnsignedByte();
               ((AbstractSocket)var1).read(var2.array, 0, 8);
               var2.offset = 0;
               this.field404 = var2.readLong();
               if (class420.field3795 >= 29) {
                  ((AbstractSocket)var1).read(var2.array, 0, 8);
                  var2.offset = 0;
                  field482 = var2.readLong();
               }

               ((AbstractSocket)var1).read(var2.array, 0, 1);
               var2.offset = 0;
               ServerPacket[] var5 = EnumComposition.ServerPacket_values();
               int var18 = var2.readSmartByteShortIsaac();
               if (var18 < 0 || var18 >= var5.length) {
                  throw new IOException(var18 + " " + var2.offset);
               }

               packetWriter.serverPacket = var5[var18];
               packetWriter.serverPacketLength = packetWriter.serverPacket.length;
               ((AbstractSocket)var1).read(var2.array, 0, 2);
               var2.offset = 0;
               packetWriter.serverPacketLength = var2.readUnsignedShort();

               try {
                  class27.method102(BuddyRankComparator.client, "zap");
               } catch (Throwable var20) {
                  ;
               }

               class37.method186(16);
            }

            if (loginState == 16) {
               if (((AbstractSocket)var1).available() >= packetWriter.serverPacketLength) {
                  var2.offset = 0;
                  ((AbstractSocket)var1).read(var2.array, 0, packetWriter.serverPacketLength);
                  timer.method2002();
                  class104.method612();
                  class280.updatePlayer(var2);
                  class17.field50 = -1;
                  InterfaceParent.loadRegions(false, var2);
                  packetWriter.serverPacket = null;
               }

            } else {
               if (loginState == 17 && ((AbstractSocket)var1).available() >= 2) {
                  var2.offset = 0;
                  ((AbstractSocket)var1).read(var2.array, 0, 2);
                  var2.offset = 0;
                  class155.field1383 = var2.readUnsignedShort();
                  class37.method186(18);
               }

               if (loginState == 18 && ((AbstractSocket)var1).available() >= class155.field1383) {
                  var2.offset = 0;
                  ((AbstractSocket)var1).read(var2.array, 0, class155.field1383);
                  var2.offset = 0;
                  String var37 = var2.readStringCp1252NullTerminated();
                  String var40 = var2.readStringCp1252NullTerminated();
                  String var38 = var2.readStringCp1252NullTerminated();
                  TaskHandler.setLoginResponseString(var37, var40, var38);
                  class140.updateGameState(10);
                  if (field485.method2423()) {
                     class12.method42(9);
                  }
               }

               if (loginState != 19) {
                  ++field493;
                  if (field493 > 2000) {
                     if (field386 < 1) {
                        if (ClanChannel.worldPort == class31.currentPort) {
                           class31.currentPort = class137.js5Port;
                        } else {
                           class31.currentPort = ClanChannel.worldPort;
                        }

                        ++field386;
                        class37.method186(0);
                     } else {
                        class32.getLoginError(-3);
                     }
                  }
               } else {
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
                     timer.method1999();
                     packetWriter.clearBuffer();
                     packetWriter.packetBuffer.offset = 0;
                     packetWriter.serverPacket = null;
                     packetWriter.field1134 = null;
                     packetWriter.field1135 = null;
                     packetWriter.field1136 = null;
                     packetWriter.serverPacketLength = 0;
                     packetWriter.field1125 = 0;
                     rebootTimer = 0;
                     WorldMapSectionType.method1426();
                     minimapState = 0;
                     destinationX = 0;

                     for(var17 = 0; var17 < 2048; ++var17) {
                        players[var17] = null;
                     }

                     class155.localPlayer = null;

                     for(var17 = 0; var17 < npcs.length; ++var17) {
                        NPC var39 = npcs[var17];
                        if (var39 != null) {
                           var39.targetIndex = -1;
                           var39.false0 = false;
                        }
                     }

                     class32.method127();
                     class140.updateGameState(30);

                     for(var17 = 0; var17 < 100; ++var17) {
                        field576[var17] = true;
                     }

                     var32 = class136.getPacketBufferNode(ClientPacket.field2441, packetWriter.isaacCipher);
                     var32.packetBuffer.writeByte(Message.getWindowedMode());
                     var32.packetBuffer.writeShort(CollisionMap.canvasWidth);
                     var32.packetBuffer.writeShort(Language.canvasHeight);
                     packetWriter.addNode(var32);
                     class280.updatePlayer(var2);
                     if (var15 != var2.offset) {
                        throw new RuntimeException();
                     }
                  }
               }
            }
         }
      } catch (IOException var27) {
         if (field386 < 1) {
            if (class31.currentPort == ClanChannel.worldPort) {
               class31.currentPort = class137.js5Port;
            } else {
               class31.currentPort = ClanChannel.worldPort;
            }

            ++field386;
            class37.method186(0);
         } else {
            class32.getLoginError(-2);
         }
      }
   }

   @ObfuscatedName("gg")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "-35306056"
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
         FaceNormal.method1236();
      } else {
         if (!isMenuOpen) {
            FriendsChat.addCancelMenuEntry();
         }

         int var1;
         for(var1 = 0; var1 < 100 && this.method379(packetWriter); ++var1) {
            ;
         }

         if (gameState == 30) {
            while(true) {
               ReflectionCheck var2 = (ReflectionCheck)class37.reflectionChecks.last();
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
                  if (timer.field3644) {
                     var14 = class136.getPacketBufferNode(ClientPacket.field2527, packetWriter.isaacCipher);
                     var14.packetBuffer.writeByte(0);
                     var15 = var14.packetBuffer.offset;
                     timer.write(var14.packetBuffer);
                     var14.packetBuffer.method2388(var14.packetBuffer.offset - var15);
                     packetWriter.addNode(var14);
                     timer.method2003();
                  }

                  Object var35 = class271.mouseRecorder.lock;
                  int var4;
                  int var5;
                  int var6;
                  int var7;
                  int var8;
                  int var9;
                  int var10;
                  int var11;
                  synchronized(class271.mouseRecorder.lock) {
                     if (!field519) {
                        class271.mouseRecorder.index = 0;
                     } else if (MouseHandler.MouseHandler_lastButton != 0 || class271.mouseRecorder.index >= 40) {
                        var30 = null;
                        var3 = 0;
                        var4 = 0;
                        var5 = 0;
                        var6 = 0;

                        for(var7 = 0; var7 < class271.mouseRecorder.index && (var30 == null || var30.packetBuffer.offset - var3 < 246); ++var7) {
                           var4 = var7;
                           var8 = class271.mouseRecorder.ys[var7];
                           if (var8 < -1) {
                              var8 = -1;
                           } else if (var8 > 65534) {
                              var8 = 65534;
                           }

                           var9 = class271.mouseRecorder.xs[var7];
                           if (var9 < -1) {
                              var9 = -1;
                           } else if (var9 > 65534) {
                              var9 = 65534;
                           }

                           if (var9 != field365 || var8 != field397) {
                              if (var30 == null) {
                                 var30 = class136.getPacketBufferNode(ClientPacket.field2505, packetWriter.isaacCipher);
                                 var30.packetBuffer.writeByte(0);
                                 var3 = var30.packetBuffer.offset;
                                 var30.packetBuffer.offset += 2;
                                 var5 = 0;
                                 var6 = 0;
                              }

                              int var12;
                              if (field367 != -1L) {
                                 var10 = var9 - field365;
                                 var11 = var8 - field397;
                                 var12 = (int)((class271.mouseRecorder.millis[var7] - field367) / 20L);
                                 var5 = (int)((long)var5 + (class271.mouseRecorder.millis[var7] - field367) % 20L);
                              } else {
                                 var10 = var9;
                                 var11 = var8;
                                 var12 = Integer.MAX_VALUE;
                              }

                              field365 = var9;
                              field397 = var8;
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
                                 var30.packetBuffer.writeShort((var12 & 8191) + '\ue000');
                                 if (var9 != -1 && var8 != -1) {
                                    var30.packetBuffer.writeInt(var9 | var8 << 16);
                                 } else {
                                    var30.packetBuffer.writeInt(Integer.MIN_VALUE);
                                 }
                              }

                              ++var6;
                              field367 = class271.mouseRecorder.millis[var7];
                           }
                        }

                        if (var30 != null) {
                           var30.packetBuffer.method2388(var30.packetBuffer.offset - var3);
                           var7 = var30.packetBuffer.offset;
                           var30.packetBuffer.offset = var3;
                           var30.packetBuffer.writeByte(var5 / var6);
                           var30.packetBuffer.writeByte(var5 % var6);
                           var30.packetBuffer.offset = var7;
                           packetWriter.addNode(var30);
                        }

                        if (var4 >= class271.mouseRecorder.index) {
                           class271.mouseRecorder.index = 0;
                        } else {
                           class271.mouseRecorder.index -= var4;
                           System.arraycopy(class271.mouseRecorder.xs, var4, class271.mouseRecorder.xs, 0, class271.mouseRecorder.index);
                           System.arraycopy(class271.mouseRecorder.ys, var4, class271.mouseRecorder.ys, 0, class271.mouseRecorder.index);
                           System.arraycopy(class271.mouseRecorder.millis, var4, class271.mouseRecorder.millis, 0, class271.mouseRecorder.index);
                        }
                     }
                  }

                  PacketBufferNode var18;
                  if (MouseHandler.MouseHandler_lastButton == 1 || !SceneTilePaint.mouseCam && MouseHandler.MouseHandler_lastButton == 4 || MouseHandler.MouseHandler_lastButton == 2) {
                     long var16 = MouseHandler.MouseHandler_lastPressedTimeMillis - mouseLastLastPressedTimeMillis;
                     if (var16 > 32767L) {
                        var16 = 32767L;
                     }

                     mouseLastLastPressedTimeMillis = MouseHandler.MouseHandler_lastPressedTimeMillis;
                     var3 = MouseHandler.MouseHandler_lastPressedY;
                     if (var3 < 0) {
                        var3 = 0;
                     } else if (var3 > Language.canvasHeight) {
                        var3 = Language.canvasHeight;
                     }

                     var4 = MouseHandler.MouseHandler_lastPressedX;
                     if (var4 < 0) {
                        var4 = 0;
                     } else if (var4 > CollisionMap.canvasWidth) {
                        var4 = CollisionMap.canvasWidth;
                     }

                     var5 = (int)var16;
                     var18 = class136.getPacketBufferNode(ClientPacket.field2498, packetWriter.isaacCipher);
                     var18.packetBuffer.writeShort((MouseHandler.MouseHandler_lastButton == 2 ? 1 : 0) + (var5 << 1));
                     var18.packetBuffer.writeShort(var4);
                     var18.packetBuffer.writeShort(var3);
                     packetWriter.addNode(var18);
                  }

                  if (keyHandlerInstance.field1831 > 0) {
                     var14 = class136.getPacketBufferNode(ClientPacket.field2432, packetWriter.isaacCipher);
                     var14.packetBuffer.writeShort(0);
                     var15 = var14.packetBuffer.offset;
                     long var19 = Message.method344();

                     for(var5 = 0; var5 < keyHandlerInstance.field1831; ++var5) {
                        long var21 = var19 - userRegistrationId;
                        if (var21 > 16777215L) {
                           var21 = 16777215L;
                        }

                        userRegistrationId = var19;
                        var14.packetBuffer.writeMedium((int)var21);
                        var14.packetBuffer.writeByte(keyHandlerInstance.field1828[var5]);
                     }

                     var14.packetBuffer.writeLengthShort(var14.packetBuffer.offset - var15);
                     packetWriter.addNode(var14);
                  }

                  if (field652 > 0) {
                     --field652;
                  }

                  if (keyHandlerInstance.getKeyPressed(96) || keyHandlerInstance.getKeyPressed(97) || keyHandlerInstance.getKeyPressed(98) || keyHandlerInstance.getKeyPressed(99)) {
                     field448 = true;
                  }

                  if (field448 && field652 <= 0) {
                     field652 = 20;
                     field448 = false;
                     var14 = class136.getPacketBufferNode(ClientPacket.field2533, packetWriter.isaacCipher);
                     var14.packetBuffer.writeShort(camAngleY);
                     var14.packetBuffer.writeShort(camAngleX);
                     packetWriter.addNode(var14);
                  }

                  if (PacketBuffer.hasFocus && !hadFocus) {
                     hadFocus = true;
                     var14 = class136.getPacketBufferNode(ClientPacket.field2519, packetWriter.isaacCipher);
                     var14.packetBuffer.writeByte(1);
                     packetWriter.addNode(var14);
                  }

                  if (!PacketBuffer.hasFocus && hadFocus) {
                     hadFocus = false;
                     var14 = class136.getPacketBufferNode(ClientPacket.field2519, packetWriter.isaacCipher);
                     var14.packetBuffer.writeByte(0);
                     packetWriter.addNode(var14);
                  }

                  if (KitDefinition.worldMap != null) {
                     KitDefinition.worldMap.method2195();
                  }

                  if (class281.ClanChat_inClanChat) {
                     if (class281.friendsChat != null) {
                        class281.friendsChat.sort();
                     }

                     class169.method883();
                     class281.ClanChat_inClanChat = false;
                  }

                  class29.method116();
                  class253.method1450();
                  if (gameState != 30) {
                     return;
                  }

                  for(PendingSpawn var37 = (PendingSpawn)pendingSpawns.last(); var37 != null; var37 = (PendingSpawn)pendingSpawns.previous()) {
                     if (var37.hitpoints > 0) {
                        --var37.hitpoints;
                     }

                     if (var37.hitpoints == 0) {
                        if (var37.objectId >= 0) {
                           var3 = var37.objectId;
                           var4 = var37.field921;
                           ObjectComposition var23 = VarpDefinition.getObjectDefinition(var3);
                           if (var4 == 11) {
                              var4 = 10;
                           }

                           if (var4 >= 5 && var4 <= 8) {
                              var4 = 4;
                           }

                           boolean var36 = var23.method1014(var4);
                           if (!var36) {
                              continue;
                           }
                        }

                        BuddyRankComparator.addPendingSpawnToScene(var37.plane, var37.type, var37.x, var37.y, var37.objectId, var37.field928, var37.field921);
                        var37.remove();
                     } else {
                        if (var37.delay > 0) {
                           --var37.delay;
                        }

                        if (var37.delay == 0 && var37.x >= 1 && var37.y >= 1 && var37.x <= 102 && var37.y <= 102 && (var37.field922 < 0 || Archive.method1789(var37.field922, var37.field924))) {
                           BuddyRankComparator.addPendingSpawnToScene(var37.plane, var37.type, var37.x, var37.y, var37.field922, var37.field923, var37.field924);
                           var37.delay = -1;
                           if (var37.objectId == var37.field922 && var37.objectId == -1) {
                              var37.remove();
                           } else if (var37.field922 == var37.objectId && var37.field923 == var37.field928 && var37.field921 == var37.field924) {
                              var37.remove();
                           }
                        }
                     }
                  }

                  class130.method723();
                  ++packetWriter.field1125;
                  if (packetWriter.field1125 > 750) {
                     FaceNormal.method1236();
                     return;
                  }

                  HitSplatDefinition.method1009();

                  for(var1 = 0; var1 < npcCount; ++var1) {
                     var15 = npcIndices[var1];
                     NPC var24 = npcs[var15];
                     if (var24 != null) {
                        FloorDecoration.updateActorSequence(var24, var24.definition.size);
                     }
                  }

                  int[] var38 = Players.Players_indices;

                  for(var15 = 0; var15 < Players.Players_count; ++var15) {
                     Player var42 = players[var38[var15]];
                     if (var42 != null && var42.overheadTextCyclesRemaining > 0) {
                        --var42.overheadTextCyclesRemaining;
                        if (var42.overheadTextCyclesRemaining == 0) {
                           var42.overheadText = null;
                        }
                     }
                  }

                  for(var15 = 0; var15 < npcCount; ++var15) {
                     var3 = npcIndices[var15];
                     NPC var25 = npcs[var3];
                     if (var25 != null && var25.overheadTextCyclesRemaining > 0) {
                        --var25.overheadTextCyclesRemaining;
                        if (var25.overheadTextCyclesRemaining == 0) {
                           var25.overheadText = null;
                        }
                     }
                  }

                  ++field408;
                  if (mouseCrossColor != 0) {
                     mouseCrossState += 20;
                     if (mouseCrossState >= 400) {
                        mouseCrossColor = 0;
                     }
                  }

                  if (MusicPatchPcmStream.field2764 != null) {
                     ++field469;
                     if (field469 >= 15) {
                        class69.invalidateWidget(MusicPatchPcmStream.field2764);
                        MusicPatchPcmStream.field2764 = null;
                     }
                  }

                  Widget var39 = WorldMapScaleHandler.mousedOverWidgetIf1;
                  Widget var31 = class380.field3655;
                  WorldMapScaleHandler.mousedOverWidgetIf1 = null;
                  class380.field3655 = null;
                  draggedOnWidget = null;
                  field546 = false;
                  field590 = false;
                  field555 = 0;

                  while(keyHandlerInstance.method1087() && field555 < 128) {
                     if (staffModLevel >= 2 && keyHandlerInstance.getKeyPressed(82) && keyHandlerInstance.field1833 == 66) {
                        String var44 = LoginScreenAnimation.method529();
                        BuddyRankComparator.client.method148(var44);
                     } else if (oculusOrbState != 1 || keyHandlerInstance.field1820 <= 0) {
                        field596[field555] = keyHandlerInstance.field1833;
                        field619[field555] = keyHandlerInstance.field1820;
                        ++field555;
                     }
                  }

                  if (TaskHandler.method871() && keyHandlerInstance.getKeyPressed(82) && keyHandlerInstance.getKeyPressed(81) && mouseWheelRotation != 0) {
                     var3 = class155.localPlayer.plane - mouseWheelRotation;
                     if (var3 < 0) {
                        var3 = 0;
                     } else if (var3 > 3) {
                        var3 = 3;
                     }

                     if (var3 != class155.localPlayer.plane) {
                        var4 = class155.localPlayer.pathX[0] + class154.baseX;
                        var5 = class155.localPlayer.pathY[0] + class365.baseY;
                        var18 = class136.getPacketBufferNode(ClientPacket.field2504, packetWriter.isaacCipher);
                        var18.packetBuffer.method2386(var5);
                        var18.packetBuffer.method2368(var3);
                        var18.packetBuffer.writeIntME(var4);
                        var18.packetBuffer.method2383(0);
                        packetWriter.addNode(var18);
                     }

                     mouseWheelRotation = 0;
                  }

                  if (MouseHandler.MouseHandler_lastButton == 1) {
                     field417.method1065();
                  }

                  if (rootInterface != -1) {
                     class378.updateRootInterface(rootInterface, 0, 0, CollisionMap.canvasWidth, Language.canvasHeight, 0, 0);
                  }

                  ++cycleCntr;

                  while(true) {
                     Widget var41;
                     ScriptEvent var45;
                     Widget var46;
                     do {
                        var45 = (ScriptEvent)field570.removeLast();
                        if (var45 == null) {
                           while(true) {
                              do {
                                 var45 = (ScriptEvent)field571.removeLast();
                                 if (var45 == null) {
                                    while(true) {
                                       do {
                                          var45 = (ScriptEvent)scriptEvents.removeLast();
                                          if (var45 == null) {
                                             while(true) {
                                                while(true) {
                                                   PacketBufferNode var26;
                                                   class200 var47;
                                                   do {
                                                      do {
                                                         do {
                                                            var47 = (class200)field572.removeLast();
                                                            if (var47 == null) {
                                                               this.menu();
                                                               if (KitDefinition.worldMap != null) {
                                                                  KitDefinition.worldMap.method2204(class383.Client_plane, (class155.localPlayer.x >> 7) + class154.baseX, (class155.localPlayer.y >> 7) + class365.baseY, false);
                                                                  KitDefinition.worldMap.loadCache();
                                                               }

                                                               if (clickedWidget != null) {
                                                                  this.method371();
                                                               }

                                                               if (class368.dragInventoryWidget != null) {
                                                                  class69.invalidateWidget(class368.dragInventoryWidget);
                                                                  ++itemDragDuration;
                                                                  if (MouseHandler.MouseHandler_currentButton == 0) {
                                                                     if (field475) {
                                                                        if (class368.dragInventoryWidget == WorldMapID.hoveredItemContainer && dragItemSlotDestination != dragItemSlotSource) {
                                                                           Widget var48 = class368.dragInventoryWidget;
                                                                           byte var34 = 0;
                                                                           if (field530 == 1 && var48.contentType == 206) {
                                                                              var34 = 1;
                                                                           }

                                                                           if (var48.itemIds[dragItemSlotDestination] <= 0) {
                                                                              var34 = 0;
                                                                           }

                                                                           var6 = Clock.getWidgetFlags(var48);
                                                                           boolean var33 = (var6 >> 29 & 1) != 0;
                                                                           if (var33) {
                                                                              var7 = dragItemSlotSource;
                                                                              var8 = dragItemSlotDestination;
                                                                              var48.itemIds[var8] = var48.itemIds[var7];
                                                                              var48.itemQuantities[var8] = var48.itemQuantities[var7];
                                                                              var48.itemIds[var7] = -1;
                                                                              var48.itemQuantities[var7] = 0;
                                                                           } else if (var34 == 1) {
                                                                              var7 = dragItemSlotSource;
                                                                              var8 = dragItemSlotDestination;

                                                                              while(var7 != var8) {
                                                                                 if (var7 > var8) {
                                                                                    var48.swapItems(var7 - 1, var7);
                                                                                    --var7;
                                                                                 } else if (var7 < var8) {
                                                                                    var48.swapItems(var7 + 1, var7);
                                                                                    ++var7;
                                                                                 }
                                                                              }
                                                                           } else {
                                                                              var48.swapItems(dragItemSlotDestination, dragItemSlotSource);
                                                                           }

                                                                           var26 = class136.getPacketBufferNode(ClientPacket.field2442, packetWriter.isaacCipher);
                                                                           var26.packetBuffer.method2383(class368.dragInventoryWidget.id);
                                                                           var26.packetBuffer.method2386(dragItemSlotSource);
                                                                           var26.packetBuffer.writeShort(dragItemSlotDestination);
                                                                           var26.packetBuffer.method2370(var34);
                                                                           packetWriter.addNode(var26);
                                                                        }
                                                                     } else if (this.shouldLeftClickOpenMenu()) {
                                                                        this.openMenu(draggedWidgetX, draggedWidgetY);
                                                                     } else if (menuOptionsCount > 0) {
                                                                        WorldMapLabelSize.method1310(draggedWidgetX, draggedWidgetY);
                                                                     }

                                                                     field469 = 10;
                                                                     MouseHandler.MouseHandler_lastButton = 0;
                                                                     class368.dragInventoryWidget = null;
                                                                  } else if (itemDragDuration >= 5 && (MouseHandler.MouseHandler_x > draggedWidgetX + 5 || MouseHandler.MouseHandler_x < draggedWidgetX - 5 || MouseHandler.MouseHandler_y > draggedWidgetY + 5 || MouseHandler.MouseHandler_y < draggedWidgetY - 5)) {
                                                                     field475 = true;
                                                                  }
                                                               }

                                                               if (Scene.shouldSendWalk()) {
                                                                  var3 = Scene.Scene_selectedX;
                                                                  var4 = Scene.Scene_selectedY;
                                                                  PacketBufferNode var43 = class136.getPacketBufferNode(ClientPacket.field2467, packetWriter.isaacCipher);
                                                                  var43.packetBuffer.writeByte(5);
                                                                  var43.packetBuffer.method2370(keyHandlerInstance.getKeyPressed(82) ? (keyHandlerInstance.getKeyPressed(81) ? 2 : 1) : 0);
                                                                  var43.packetBuffer.method2386(var3 + class154.baseX);
                                                                  var43.packetBuffer.writeIntME(var4 + class365.baseY);
                                                                  packetWriter.addNode(var43);
                                                                  Scene.method1205();
                                                                  mouseCrossX = MouseHandler.MouseHandler_lastPressedX;
                                                                  mouseCrossY = MouseHandler.MouseHandler_lastPressedY;
                                                                  mouseCrossColor = 1;
                                                                  mouseCrossState = 0;
                                                                  destinationX = var3;
                                                                  destinationY = var4;
                                                               }

                                                               if (var39 != WorldMapScaleHandler.mousedOverWidgetIf1) {
                                                                  if (var39 != null) {
                                                                     class69.invalidateWidget(var39);
                                                                  }

                                                                  if (WorldMapScaleHandler.mousedOverWidgetIf1 != null) {
                                                                     class69.invalidateWidget(WorldMapScaleHandler.mousedOverWidgetIf1);
                                                                  }
                                                               }

                                                               if (var31 != class380.field3655 && field398 == field366) {
                                                                  if (var31 != null) {
                                                                     class69.invalidateWidget(var31);
                                                                  }

                                                                  if (class380.field3655 != null) {
                                                                     class69.invalidateWidget(class380.field3655);
                                                                  }
                                                               }

                                                               if (class380.field3655 != null) {
                                                                  if (field398 < field366) {
                                                                     ++field398;
                                                                     if (field366 == field398) {
                                                                        class69.invalidateWidget(class380.field3655);
                                                                     }
                                                                  }
                                                               } else if (field398 > 0) {
                                                                  --field398;
                                                               }

                                                               class9.method31();
                                                               if (field617) {
                                                                  class31.method124();
                                                               } else if (isCameraLocked) {
                                                                  var3 = class155.cameraMoveToX * 128 + 64;
                                                                  var4 = class34.cameraMoveToY * 128 + 64;
                                                                  var5 = SpotAnimationDefinition.getTileHeight(var3, var4, class383.Client_plane) - Script.cameraMoveToHeight;
                                                                  class280.method1527(var3, var5, var4);
                                                                  var3 = class109.cameraLookAtX * 128 + 64;
                                                                  var4 = class146.cameraLookAtY * 128 + 64;
                                                                  var5 = SpotAnimationDefinition.getTileHeight(var3, var4, class383.Client_plane) - class104.cameraLookAtHeight;
                                                                  var6 = var3 - class145.cameraX;
                                                                  var7 = var5 - class414.cameraY;
                                                                  var8 = var4 - ClanChannel.cameraZ;
                                                                  var9 = (int)Math.sqrt((double)(var8 * var8 + var6 * var6));
                                                                  var10 = (int)(Math.atan2((double)var7, (double)var9) * 325.9490051269531D) & 2047;
                                                                  var11 = (int)(Math.atan2((double)var6, (double)var8) * -325.9490051269531D) & 2047;
                                                                  class158.method834(var10, var11);
                                                               }

                                                               for(var3 = 0; var3 < 5; ++var3) {
                                                                  ++cameraShakeCycle[var3];
                                                               }

                                                               WorldMapArea.varcs.tryWrite();
                                                               var3 = ++MouseHandler.MouseHandler_idleCycles - 1;
                                                               var5 = class168.method881();
                                                               if (var3 > 15000 && var5 > 15000) {
                                                                  logoutTimer = 250;
                                                                  Player.method505(14500);
                                                                  var18 = class136.getPacketBufferNode(ClientPacket.field2508, packetWriter.isaacCipher);
                                                                  packetWriter.addNode(var18);
                                                               }

                                                               DefaultsGroup.friendSystem.processFriendUpdates();
                                                               ++packetWriter.pendingWrites;
                                                               if (packetWriter.pendingWrites > 50) {
                                                                  var18 = class136.getPacketBufferNode(ClientPacket.field2513, packetWriter.isaacCipher);
                                                                  packetWriter.addNode(var18);
                                                               }

                                                               try {
                                                                  packetWriter.flush();
                                                               } catch (IOException var27) {
                                                                  FaceNormal.method1236();
                                                               }

                                                               return;
                                                            }
                                                         } while(var47 == null);
                                                      } while(var47.field1818 == null);

                                                      if (var47.field1818.childIndex < 0) {
                                                         break;
                                                      }

                                                      var46 = ObjTypeCustomisation.getWidget(var47.field1818.parentId);
                                                   } while(var46 == null || var46.children == null || var46.children.length == 0 || var47.field1818.childIndex >= var46.children.length || var47.field1818 != var46.children[var47.field1818.childIndex]);

                                                   if (var47.field1818.type == 11 && var47.field1815 == 0) {
                                                      switch(var47.field1818.method1729()) {
                                                      case 0:
                                                         ModeWhere.openURL(var47.field1818.method1731(), true, false);
                                                         break;
                                                      case 1:
                                                         var5 = Clock.getWidgetFlags(var47.field1818);
                                                         boolean var32 = (var5 >> 22 & 1) != 0;
                                                         if (var32) {
                                                            int[] var40 = var47.field1818.method1732();
                                                            if (var40 != null) {
                                                               var26 = class136.getPacketBufferNode(ClientPacket.field2538, packetWriter.isaacCipher);
                                                               var26.packetBuffer.method2381(var40[2]);
                                                               var26.packetBuffer.writeInt(var47.field1818.id);
                                                               var26.packetBuffer.method2381(var47.field1818.method1730());
                                                               var26.packetBuffer.writeInt(var40[1]);
                                                               var26.packetBuffer.writeShort(var47.field1818.childIndex);
                                                               var26.packetBuffer.method2383(var40[0]);
                                                               packetWriter.addNode(var26);
                                                            }
                                                         }
                                                      }
                                                   } else if (var47.field1818.type == 12) {
                                                      class303 var49 = var47.field1818.method1724();
                                                      if (var49 != null && var49.method1633()) {
                                                         switch(var47.field1815) {
                                                         case 0:
                                                            field417.method1063(var47.field1818);
                                                            var49.method1635(true);
                                                            var49.method1668(var47.field1817, var47.field1816, keyHandlerInstance.getKeyPressed(82), keyHandlerInstance.getKeyPressed(81));
                                                            break;
                                                         case 1:
                                                            var49.method1707(var47.field1817, var47.field1816);
                                                         }
                                                      }
                                                   }
                                                }
                                             }
                                          }

                                          var46 = var45.widget;
                                          if (var46.childIndex < 0) {
                                             break;
                                          }

                                          var41 = ObjTypeCustomisation.getWidget(var46.parentId);
                                       } while(var41 == null || var41.children == null || var46.childIndex >= var41.children.length || var46 != var41.children[var46.childIndex]);

                                       WorldMapElement.runScriptEvent(var45);
                                    }
                                 }

                                 var46 = var45.widget;
                                 if (var46.childIndex < 0) {
                                    break;
                                 }

                                 var41 = ObjTypeCustomisation.getWidget(var46.parentId);
                              } while(var41 == null || var41.children == null || var46.childIndex >= var41.children.length || var46 != var41.children[var46.childIndex]);

                              WorldMapElement.runScriptEvent(var45);
                           }
                        }

                        var46 = var45.widget;
                        if (var46.childIndex < 0) {
                           break;
                        }

                        var41 = ObjTypeCustomisation.getWidget(var46.parentId);
                     } while(var41 == null || var41.children == null || var46.childIndex >= var41.children.length || var46 != var41.children[var46.childIndex]);

                     WorldMapElement.runScriptEvent(var45);
                  }
               }

               var30 = class136.getPacketBufferNode(ClientPacket.field2520, packetWriter.isaacCipher);
               var30.packetBuffer.writeByte(0);
               var3 = var30.packetBuffer.offset;
               ModelData0.performReflectionCheck(var30.packetBuffer);
               var30.packetBuffer.method2388(var30.packetBuffer.offset - var3);
               packetWriter.addNode(var30);
            }
         }
      }
   }

   @ObfuscatedName("hk")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "-1654731746"
   )
   void resizeJS() {
      int var1 = CollisionMap.canvasWidth;
      int var2 = Language.canvasHeight;
      if (super.contentWidth < var1) {
         var1 = super.contentWidth;
      }

      if (super.contentHeight < var2) {
         var2 = super.contentHeight;
      }

      if (StructComposition.clientPreferences != null) {
         try {
            Client var3 = BuddyRankComparator.client;
            Object[] var4 = new Object[]{Message.getWindowedMode()};
            //JSObject.getWindow(var3).call("resize", var4);
         } catch (Throwable var5) {
            ;
         }
      }

   }

   @ObfuscatedName("hq")
   @ObfuscatedSignature(
      descriptor = "(S)V",
      garbageValue = "-25398"
   )
   final void drawLoggedIn() {
      int var1;
      if (rootInterface != -1) {
         var1 = rootInterface;
         if (Players.loadInterface(var1)) {
            UserComparator10.drawModelComponents(class71.Widget_interfaceComponents[var1], -1);
         }
      }

      for(var1 = 0; var1 < rootWidgetCount; ++var1) {
         if (field576[var1]) {
            field577[var1] = true;
         }

         field578[var1] = field576[var1];
         field576[var1] = false;
      }

      field653 = cycle;
      viewportX = -1;
      viewportY = -1;
      WorldMapID.hoveredItemContainer = null;
      if (rootInterface != -1) {
         rootWidgetCount = 0;
         HealthBar.drawWidgets(rootInterface, 0, 0, CollisionMap.canvasWidth, Language.canvasHeight, 0, 0, -1);
      }

      Rasterizer2D.Rasterizer2D_resetClip();
      if (showMouseCross) {
         if (mouseCrossColor == 1) {
            MouseHandler.crossSprites[mouseCrossState / 100].drawTransBgAt(mouseCrossX - 8, mouseCrossY - 8);
         }

         if (mouseCrossColor == 2) {
            MouseHandler.crossSprites[mouseCrossState / 100 + 4].drawTransBgAt(mouseCrossX - 8, mouseCrossY - 8);
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
                  var5 = "Use" + " " + selectedItemName + " " + "->";
               } else if (isSpellSelected && menuOptionsCount < 2) {
                  var5 = selectedSpellActionName + " " + selectedSpellName + " " + "->";
               } else {
                  String var6;
                  if (var3 < 0) {
                     var6 = "";
                  } else if (menuTargets[var3].length() > 0) {
                     var6 = menuActions[var3] + " " + menuTargets[var3];
                  } else {
                     var6 = menuActions[var3];
                  }

                  var5 = var6;
               }

               if (menuOptionsCount > 2) {
                  var5 = var5 + MouseRecorder.colorStartTag(16777215) + " " + '/' + " " + (menuOptionsCount - 2) + " more options";
               }

               class146.fontBold12.drawRandomAlphaAndSpacing(var5, var1 + 4, var2 + 15, 16777215, 0, cycle / 1000);
            }
         }
      } else {
         GrandExchangeOfferOwnWorldComparator.method350();
      }

      if (gameDrawingMode == 3) {
         for(var1 = 0; var1 < rootWidgetCount; ++var1) {
            if (field578[var1]) {
               Rasterizer2D.Rasterizer2D_fillRectangleAlpha(rootWidgetXs[var1], rootWidgetYs[var1], rootWidgetWidths[var1], rootWidgetHeights[var1], 16711935, 128);
            } else if (field577[var1]) {
               Rasterizer2D.Rasterizer2D_fillRectangleAlpha(rootWidgetXs[var1], rootWidgetYs[var1], rootWidgetWidths[var1], rootWidgetHeights[var1], 16711680, 128);
            }
         }
      }

      var1 = class383.Client_plane;
      var2 = class155.localPlayer.x;
      var3 = class155.localPlayer.y;
      int var4 = field408;

      for(ObjectSound var14 = (ObjectSound)ObjectSound.objectSounds.last(); var14 != null; var14 = (ObjectSound)ObjectSound.objectSounds.previous()) {
         if (var14.soundEffectId != -1 || var14.soundEffectIds != null) {
            int var12 = 0;
            if (var2 > var14.maxX) {
               var12 += var2 - var14.maxX;
            } else if (var2 < var14.x) {
               var12 += var14.x - var2;
            }

            if (var3 > var14.maxY) {
               var12 += var3 - var14.maxY;
            } else if (var3 < var14.y) {
               var12 += var14.y - var3;
            }

            if (var12 - 64 <= var14.field680 && StructComposition.clientPreferences.method563() != 0 && var1 == var14.plane) {
               var12 -= 64;
               if (var12 < 0) {
                  var12 = 0;
               }

               int var7 = (var14.field680 - var12) * StructComposition.clientPreferences.method563() / var14.field680;
               Object var10000;
               if (var14.stream1 == null) {
                  if (var14.soundEffectId >= 0) {
                     var10000 = null;
                     SoundEffect var8 = SoundEffect.readSoundEffect(WorldMapSection0.field2342, var14.soundEffectId, 0);
                     if (var8 != null) {
                        RawSound var9 = var8.toRawSound().resample(DevicePcmPlayerProvider.decimator);
                        RawPcmStream var10 = RawPcmStream.createRawPcmStream(var9, 100, var7);
                        var10.setNumLoops(-1);
                        ApproximateRouteStrategy.pcmStreamMixer.addSubStream(var10);
                        var14.stream1 = var10;
                     }
                  }
               } else {
                  var14.stream1.method251(var7);
               }

               if (var14.stream2 == null) {
                  if (var14.soundEffectIds != null && (var14.field683 -= var4) <= 0) {
                     int var13 = (int)(Math.random() * (double)var14.soundEffectIds.length);
                     var10000 = null;
                     SoundEffect var15 = SoundEffect.readSoundEffect(WorldMapSection0.field2342, var14.soundEffectIds[var13], 0);
                     if (var15 != null) {
                        RawSound var16 = var15.toRawSound().resample(DevicePcmPlayerProvider.decimator);
                        RawPcmStream var11 = RawPcmStream.createRawPcmStream(var16, 100, var7);
                        var11.setNumLoops(0);
                        ApproximateRouteStrategy.pcmStreamMixer.addSubStream(var11);
                        var14.stream2 = var11;
                        var14.field683 = var14.field675 + (int)(Math.random() * (double)(var14.field672 - var14.field675));
                     }
                  }
               } else {
                  var14.stream2.method251(var7);
                  if (!var14.stream2.hasNext()) {
                     var14.stream2 = null;
                  }
               }
            } else {
               if (var14.stream1 != null) {
                  ApproximateRouteStrategy.pcmStreamMixer.removeSubStream(var14.stream1);
                  var14.stream1 = null;
               }

               if (var14.stream2 != null) {
                  ApproximateRouteStrategy.pcmStreamMixer.removeSubStream(var14.stream2);
                  var14.stream2 = null;
               }
            }
         }
      }

      field408 = 0;
   }

   @ObfuscatedName("ic")
   @ObfuscatedSignature(
      descriptor = "(Lde;II)Z",
      garbageValue = "-1959466740"
   )
   boolean method373(PacketWriter var1, int var2) {
      if (var1.serverPacketLength == 0) {
         class281.friendsChat = null;
      } else {
         if (class281.friendsChat == null) {
            class281.friendsChat = new FriendsChat(SecureRandomFuture.loginType, BuddyRankComparator.client);
         }

         class281.friendsChat.method2034(var1.packetBuffer, var2);
      }

      field455 = cycleCntr;
      class281.ClanChat_inClanChat = true;
      var1.serverPacket = null;
      return true;
   }

   @ObfuscatedName("iw")
   @ObfuscatedSignature(
      descriptor = "(Lde;I)Z",
      garbageValue = "-1099758914"
   )
   boolean method372(PacketWriter var1) {
      if (class281.friendsChat != null) {
         class281.friendsChat.method2031(var1.packetBuffer);
      }

      field455 = cycleCntr;
      class281.ClanChat_inClanChat = true;
      var1.serverPacket = null;
      return true;
   }

   @ObfuscatedName("il")
   @ObfuscatedSignature(
      descriptor = "(Lde;I)Z",
      garbageValue = "-42701230"
   )
   final boolean method379(PacketWriter var1) {
      AbstractSocket var2 = var1.getSocket();
      PacketBuffer var3 = var1.packetBuffer;
      if (var2 == null) {
         return false;
      } else {
         String var21;
         int var27;
         try {
            int var5;
            if (var1.serverPacket == null) {
               if (var1.field1133) {
                  if (!var2.isAvailable(1)) {
                     return false;
                  }

                  var2.read(var1.packetBuffer.array, 0, 1);
                  var1.field1125 = 0;
                  var1.field1133 = false;
               }

               var3.offset = 0;
               if (var3.method2326()) {
                  if (!var2.isAvailable(1)) {
                     return false;
                  }

                  var2.read(var1.packetBuffer.array, 1, 1);
                  var1.field1125 = 0;
               }

               var1.field1133 = true;
               ServerPacket[] var4 = EnumComposition.ServerPacket_values();
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
            var1.field1125 = 0;
            timer.method2005();
            var1.field1136 = var1.field1135;
            var1.field1135 = var1.field1134;
            var1.field1134 = var1.serverPacket;
            if (ServerPacket.field2587 == var1.serverPacket) {
               DevicePcmPlayerProvider.method80(class276.field2554);
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2572 == var1.serverPacket) {
               DevicePcmPlayerProvider.method80(class276.field2551);
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2634 == var1.serverPacket) {
               class312.updateNpcs(false, var3);
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2585 == var1.serverPacket) {
               if (LoginScreenAnimation.field1028 == null) {
                  LoginScreenAnimation.field1028 = new class414(class34.HitSplatDefinition_cached);
               }

               class475 var54 = class34.HitSplatDefinition_cached.method2159(var3);
               LoginScreenAnimation.field1028.field3788.vmethod8143(var54.field4047, var54.field4048);
               field557[++field558 - 1 & 31] = var54.field4047;
               var1.serverPacket = null;
               return true;
            }

            int var20;
            if (ServerPacket.field2625 == var1.serverPacket) {
               InvDefinition.field1464 = var3.readUnsignedByte();
               class125.field1224 = var3.method2394();

               while(var3.offset < var1.serverPacketLength) {
                  var20 = var3.readUnsignedByte();
                  class276 var79 = SpotAnimationDefinition.method971()[var20];
                  DevicePcmPlayerProvider.method80(var79);
               }

               var1.serverPacket = null;
               return true;
            }

            Widget var6;
            int var7;
            int var8;
            int var9;
            if (ServerPacket.field2604 == var1.serverPacket) {
               var20 = var3.readInt();
               var5 = var3.readUnsignedShort();
               if (var20 < -70000) {
                  var5 += 32768;
               }

               if (var20 >= 0) {
                  var6 = ObjTypeCustomisation.getWidget(var20);
               } else {
                  var6 = null;
               }

               for(; var3.offset < var1.serverPacketLength; class12.itemContainerSetItem(var5, var7, var8 - 1, var9)) {
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
                  class69.invalidateWidget(var6);
               }

               class136.method738();
               changedItemContainers[++changedItemContainersCount - 1 & 31] = var5 & 32767;
               var1.serverPacket = null;
               return true;
            }

            GameObject var14;
            int var15;
            int var16;
            String var26;
            byte var74;
            if (ServerPacket.field2662 == var1.serverPacket) {
               var74 = var3.readByte();
               var21 = var3.readStringCp1252NullTerminated();
               long var22 = (long)var3.readUnsignedShort();
               long var24 = (long)var3.readMedium();
               PlayerType var60 = (PlayerType)World.findEnumerated(class149.PlayerType_values(), var3.readUnsignedByte());
               long var11 = var24 + (var22 << 32);
               boolean var68 = false;
               var14 = null;
               ClanChannel var69 = var74 >= 0 ? currentClanChannels[var74] : VarcInt.guestClanChannel;
               if (var69 == null) {
                  var68 = true;
               } else {
                  var15 = 0;

                  while(true) {
                     if (var15 >= 100) {
                        if (var60.isUser && DefaultsGroup.friendSystem.isIgnored(new Username(var21, SecureRandomFuture.loginType))) {
                           var68 = true;
                        }
                        break;
                     }

                     if (var11 == crossWorldMessageIds[var15]) {
                        var68 = true;
                        break;
                     }

                     ++var15;
                  }
               }

               if (!var68) {
                  crossWorldMessageIds[crossWorldMessageIdsIndex] = var11;
                  crossWorldMessageIdsIndex = (crossWorldMessageIdsIndex + 1) % 100;
                  var26 = AbstractFont.escapeBrackets(class153.method817(var3));
                  var16 = var74 >= 0 ? 41 : 44;
                  if (var60.modIcon != -1) {
                     class381.addChatMessage(var16, class456.method2305(var60.modIcon) + var21, var26, var69.name);
                  } else {
                     class381.addChatMessage(var16, var21, var26, var69.name);
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2651 == var1.serverPacket) {
               isCameraLocked = true;
               field617 = false;
               class155.cameraMoveToX = var3.readUnsignedByte();
               class34.cameraMoveToY = var3.readUnsignedByte();
               Script.cameraMoveToHeight = var3.readUnsignedShort();
               class31.cameraMoveToSpeed = var3.readUnsignedByte();
               Tile.cameraMoveToAcceleration = var3.readUnsignedByte();
               if (Tile.cameraMoveToAcceleration >= 100) {
                  class145.cameraX = class155.cameraMoveToX * 128 + 64;
                  ClanChannel.cameraZ = class34.cameraMoveToY * 128 + 64;
                  class414.cameraY = SpotAnimationDefinition.getTileHeight(class145.cameraX, ClanChannel.cameraZ, class383.Client_plane) - Script.cameraMoveToHeight;
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2574 == var1.serverPacket) {
               var20 = var3.method2376();
               if (var20 == 65535) {
                  var20 = -1;
               }

               class169.playSong(var20);
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2627 == var1.serverPacket) {
               var20 = var3.method2389();
               var5 = var3.method2333();
               if (var5 == 65535) {
                  var5 = -1;
               }

               class16.playJingle(var5, var20);
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2571 == var1.serverPacket) {
               LoginScreenAnimation.field1028 = null;
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2646 == var1.serverPacket) {
               field358 = cycleCntr;
               var74 = var3.readByte();
               class153 var78 = new class153(var3);
               ClanChannel var63;
               if (var74 >= 0) {
                  var63 = currentClanChannels[var74];
               } else {
                  var63 = VarcInt.guestClanChannel;
               }

               var78.method816(var63);
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2623 == var1.serverPacket) {
               var20 = var3.method2384();
               var5 = var3.method2377();
               var27 = var5 >> 10 & 31;
               var7 = var5 >> 5 & 31;
               var8 = var5 & 31;
               var9 = (var7 << 11) + (var27 << 19) + (var8 << 3);
               Widget var59 = ObjTypeCustomisation.getWidget(var20);
               if (var9 != var59.color) {
                  var59.color = var9;
                  class69.invalidateWidget(var59);
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2669 == var1.serverPacket) {
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

            if (ServerPacket.field2618 == var1.serverPacket) {
               var20 = var3.readUnsignedByte();
               if (var3.readUnsignedByte() == 0) {
                  grandExchangeOffers[var20] = new GrandExchangeOffer();
                  var3.offset += 18;
               } else {
                  --var3.offset;
                  grandExchangeOffers[var20] = new GrandExchangeOffer(var3, false);
               }

               field622 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2612 == var1.serverPacket) {
               InterfaceParent.loadRegions(false, var1.packetBuffer);
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2569 == var1.serverPacket) {
               World var53 = new World();
               var53.host = var3.readStringCp1252NullTerminated();
               var53.id = var3.readUnsignedShort();
               var5 = var3.readInt();
               var53.properties = var5;
               class140.updateGameState(45);
               var2.close();
               var2 = null;
               UserComparator6.changeWorld(var53);
               var1.serverPacket = null;
               return false;
            }

            if (ServerPacket.field2608 == var1.serverPacket) {
               GameEngine.method170();
               var74 = var3.readByte();
               if (var1.serverPacketLength == 1) {
                  if (var74 >= 0) {
                     currentClanSettings[var74] = null;
                  } else {
                     class20.guestClanSettings = null;
                  }

                  var1.serverPacket = null;
                  return true;
               }

               if (var74 >= 0) {
                  currentClanSettings[var74] = new ClanSettings(var3);
               } else {
                  class20.guestClanSettings = new ClanSettings(var3);
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2600 == var1.serverPacket) {
               DevicePcmPlayerProvider.method80(class276.field2544);
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2643 == var1.serverPacket) {
               LoginScreenAnimation.privateChatMode = SceneTilePaint.method1286(var3.readUnsignedByte());
               var1.serverPacket = null;
               return true;
            }

            int var13;
            long var28;
            long var30;
            String var35;
            String var49;
            if (ServerPacket.field2656 == var1.serverPacket) {
               var49 = var3.readStringCp1252NullTerminated();
               var28 = (long)var3.readUnsignedShort();
               var30 = (long)var3.readMedium();
               PlayerType var32 = (PlayerType)World.findEnumerated(class149.PlayerType_values(), var3.readUnsignedByte());
               long var33 = var30 + (var28 << 32);
               boolean var64 = false;

               for(var13 = 0; var13 < 100; ++var13) {
                  if (crossWorldMessageIds[var13] == var33) {
                     var64 = true;
                     break;
                  }
               }

               if (DefaultsGroup.friendSystem.isIgnored(new Username(var49, SecureRandomFuture.loginType))) {
                  var64 = true;
               }

               if (!var64 && field536 == 0) {
                  crossWorldMessageIds[crossWorldMessageIdsIndex] = var33;
                  crossWorldMessageIdsIndex = (crossWorldMessageIdsIndex + 1) % 100;
                  var35 = AbstractFont.escapeBrackets(VarbitComposition.method985(class153.method817(var3)));
                  byte var83;
                  if (var32.isPrivileged) {
                     var83 = 7;
                  } else {
                     var83 = 3;
                  }

                  if (var32.modIcon != -1) {
                     KitDefinition.addGameMessage(var83, class456.method2305(var32.modIcon) + var49, var35);
                  } else {
                     KitDefinition.addGameMessage(var83, var49, var35);
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            int var12;
            int var17;
            int var18;
            Projectile var19;
            int var36;
            int var38;
            byte var61;
            int var84;
            byte var87;
            if (ServerPacket.field2658 == var1.serverPacket) {
               var61 = var3.readByte();
               var27 = var3.method2380();
               var20 = var27 >> 16;
               var5 = var27 >> 8 & 255;
               var7 = var20 + (var27 >> 4 & 7);
               var8 = var5 + (var27 & 7);
               var84 = var3.readShort();
               var15 = var3.method2377();
               var87 = var3.method2401();
               var17 = var3.method2394();
               var13 = var3.method2396() * 4;
               var16 = var3.method2377();
               var18 = var3.readUnsignedByte();
               var12 = var3.method2376();
               var36 = var3.method2396() * 4;
               var9 = var61 + var7;
               var38 = var87 + var8;
               if (var7 >= 0 && var8 >= 0 && var7 < 104 && var8 < 104 && var9 >= 0 && var38 >= 0 && var9 < 104 && var38 < 104 && var12 != 65535) {
                  var7 = var7 * 128 + 64;
                  var8 = var8 * 128 + 64;
                  var9 = var9 * 128 + 64;
                  var38 = var38 * 128 + 64;
                  var19 = new Projectile(var12, class383.Client_plane, var7, var8, SpotAnimationDefinition.getTileHeight(var7, var8, class383.Client_plane) - var13, var15 + cycle, var16 + cycle, var17, var18, var84, var36);
                  var19.setDestination(var9, var38, SpotAnimationDefinition.getTileHeight(var9, var38, class383.Client_plane) - var36, var15 + cycle);
                  projectiles.addFirst(var19);
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2579 == var1.serverPacket) {
               var36 = var3.method2371() * 4;
               var87 = var3.method2401();
               var17 = var3.readUnsignedByte();
               var61 = var3.method2401();
               var12 = var3.method2377();
               var84 = var3.method2392();
               var27 = var3.method2379();
               var20 = var27 >> 16;
               var5 = var27 >> 8 & 255;
               var7 = var20 + (var27 >> 4 & 7);
               var8 = var5 + (var27 & 7);
               var13 = var3.readUnsignedByte() * 4;
               var18 = var3.method2394();
               var15 = var3.method2333();
               var16 = var3.method2377();
               var9 = var61 + var7;
               var38 = var87 + var8;
               if (var7 >= 0 && var8 >= 0 && var7 < 104 && var8 < 104 && var9 >= 0 && var38 >= 0 && var9 < 104 && var38 < 104 && var12 != 65535) {
                  var7 = var7 * 128 + 64;
                  var8 = var8 * 128 + 64;
                  var9 = var9 * 128 + 64;
                  var38 = var38 * 128 + 64;
                  var19 = new Projectile(var12, class383.Client_plane, var7, var8, SpotAnimationDefinition.getTileHeight(var7, var8, class383.Client_plane) - var13, var15 + cycle, var16 + cycle, var17, var18, var84, var36);
                  var19.setDestination(var9, var38, SpotAnimationDefinition.getTileHeight(var9, var38, class383.Client_plane) - var36, var15 + cycle);
                  projectiles.addFirst(var19);
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2588 == var1.serverPacket) {
               DefaultsGroup.friendSystem.ignoreList.read(var3, var1.serverPacketLength);
               AbstractWorldMapData.FriendSystem_invalidateIgnoreds();
               field560 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2566 == var1.serverPacket) {
               var20 = var3.method2376();
               byte var70 = var3.method2395();
               Varps.Varps_temp[var20] = var70;
               if (Varps.Varps_main[var20] != var70) {
                  Varps.Varps_main[var20] = var70;
               }

               MouseRecorder.changeGameOptions(var20);
               changedVarps[++changedVarpCount - 1 & 31] = var20;
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2628 == var1.serverPacket) {
               DefaultsGroup.friendSystem.method405();
               field560 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2661 == var1.serverPacket) {
               var20 = var3.method2371();
               var21 = var3.readStringCp1252NullTerminated();
               var27 = var3.readUnsignedByte();
               if (var27 >= 1 && var27 <= 8) {
                  if (var21.equalsIgnoreCase("null")) {
                     var21 = null;
                  }

                  playerMenuActions[var27 - 1] = var21;
                  playerOptionsPriorities[var27 - 1] = var20 == 0;
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2609 == var1.serverPacket) {
               var20 = var3.method2333();
               Player var92;
               if (var20 == localPlayerIndex) {
                  var92 = class155.localPlayer;
               } else {
                  var92 = players[var20];
               }

               var5 = var3.method2376();
               var27 = var3.method2384();
               if (var92 != null) {
                  var92.spotAnimation = var5;
                  var92.spotAnimHeight = var27 >> 16;
                  var92.spotAnimationStartCycle = (var27 & '\uffff') + cycle;
                  var92.spotAnimationFrame = 0;
                  var92.spotAnimFrameCycle = 0;
                  if (var92.spotAnimationStartCycle > cycle) {
                     var92.spotAnimationFrame = -1;
                  }

                  if (var92.spotAnimation == 65535) {
                     var92.spotAnimation = -1;
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2657 == var1.serverPacket) {
               InterfaceParent.loadRegions(true, var1.packetBuffer);
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2591 == var1.serverPacket) {
               rebootTimer = var3.method2333() * 30;
               field566 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2611 == var1.serverPacket) {
               field358 = cycleCntr;
               var74 = var3.readByte();
               if (var1.serverPacketLength == 1) {
                  if (var74 >= 0) {
                     currentClanChannels[var74] = null;
                  } else {
                     VarcInt.guestClanChannel = null;
                  }

                  var1.serverPacket = null;
                  return true;
               }

               if (var74 >= 0) {
                  currentClanChannels[var74] = new ClanChannel(var3);
               } else {
                  VarcInt.guestClanChannel = new ClanChannel(var3);
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2562 == var1.serverPacket) {
               var20 = var3.method2333();
               rootInterface = var20;
               this.resizeRoot(false);
               class69.Widget_resetModelFrames(var20);
               class31.runWidgetOnLoadListener(rootInterface);

               for(var5 = 0; var5 < 100; ++var5) {
                  field576[var5] = true;
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2663 == var1.serverPacket) {
               DevicePcmPlayerProvider.method80(class276.field2547);
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2674 == var1.serverPacket) {
               class136.method738();
               runEnergy = var3.readUnsignedShort();
               field566 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2622 == var1.serverPacket) {
               for(var20 = 0; var20 < VarpDefinition.field1468; ++var20) {
                  VarpDefinition var77 = class109.VarpDefinition_get(var20);
                  if (var77 != null) {
                     Varps.Varps_temp[var20] = 0;
                     Varps.Varps_main[var20] = 0;
                  }
               }

               class136.method738();
               changedVarpCount += 32;
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2616 == var1.serverPacket) {
               isCameraLocked = false;

               for(var20 = 0; var20 < 5; ++var20) {
                  cameraShaking[var20] = false;
               }

               var1.serverPacket = null;
               return true;
            }

            Widget var86;
            if (ServerPacket.field2659 == var1.serverPacket) {
               var20 = var3.method2378();
               var5 = var3.method2384();
               var27 = var3.readShort();
               var86 = ObjTypeCustomisation.getWidget(var5);
               if (var27 != var86.rawX || var20 != var86.rawY || var86.xAlignment != 0 || var86.yAlignment != 0) {
                  var86.rawX = var27;
                  var86.rawY = var20;
                  var86.xAlignment = 0;
                  var86.yAlignment = 0;
                  class69.invalidateWidget(var86);
                  this.alignWidget(var86);
                  if (var86.type == 0) {
                     class169.revalidateWidgetScroll(class71.Widget_interfaceComponents[var5 >> 16], var86, false);
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2594 == var1.serverPacket && isCameraLocked) {
               field617 = true;
               class31.cameraMoveToSpeed = var3.readUnsignedByte();
               Tile.cameraMoveToAcceleration = var3.readUnsignedByte();
               class415.cameraLookAtSpeed = var3.readUnsignedByte();
               LoginScreenAnimation.cameraLookAtAcceleration = var3.readUnsignedByte();

               for(var20 = 0; var20 < 5; ++var20) {
                  cameraShaking[var20] = false;
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2638 == var1.serverPacket) {
               class136.method738();
               var20 = var3.method2384();
               var5 = var3.method2396();
               var27 = var3.method2396();
               experience[var27] = var20;
               currentLevels[var27] = var5;
               levels[var27] = 1;

               for(var7 = 0; var7 < 98; ++var7) {
                  if (var20 >= Skills.Skills_experienceTable[var7]) {
                     levels[var27] = var7 + 2;
                  }
               }

               changedSkills[++changedSkillsCount - 1 & 31] = var27;
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2584 == var1.serverPacket) {
               GameEngine.method170();
               var74 = var3.readByte();
               class139 var76 = new class139(var3);
               ClanSettings var58;
               if (var74 >= 0) {
                  var58 = currentClanSettings[var74];
               } else {
                  var58 = class20.guestClanSettings;
               }

               var76.method747(var58);
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2675 == var1.serverPacket) {
               var20 = var3.readInt();
               var5 = var3.method2396();
               short var81 = (short)var3.readShort();
               var7 = var3.method2377();
               NPC var91 = npcs[var7];
               if (var91 != null) {
                  var91.method579(var5, var20, var81);
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2607 == var1.serverPacket) {
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

            if (ServerPacket.field2602 == var1.serverPacket) {
               DevicePcmPlayerProvider.method80(class276.field2541);
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2668 == var1.serverPacket) {
               var27 = var3.readMedium();
               var20 = var27 >> 16;
               var5 = var27 >> 8 & 255;
               var7 = var20 + (var27 >> 4 & 7);
               var8 = var5 + (var27 & 7);
               var9 = var3.method2396();
               var38 = var9 >> 2;
               var84 = var9 & 3;
               var12 = field424[var38];
               var13 = var3.method2333();
               if (var7 >= 0 && var8 >= 0 && var7 < 103 && var8 < 103) {
                  if (var12 == 0) {
                     BoundaryObject var67 = ReflectionCheck.scene.getWallObject(class383.Client_plane, var7, var8);
                     if (var67 != null) {
                        var15 = Occluder.Entity_unpackID(var67.tag);
                        if (var38 == 2) {
                           var67.renderable1 = new DynamicObject(var15, 2, var84 + 4, class383.Client_plane, var7, var8, var13, false, var67.renderable1);
                           var67.renderable2 = new DynamicObject(var15, 2, var84 + 1 & 3, class383.Client_plane, var7, var8, var13, false, var67.renderable2);
                        } else {
                           var67.renderable1 = new DynamicObject(var15, var38, var84, class383.Client_plane, var7, var8, var13, false, var67.renderable1);
                        }
                     }
                  } else if (var12 == 1) {
                     WallDecoration var66 = ReflectionCheck.scene.getDecorativeObject(class383.Client_plane, var7, var8);
                     if (var66 != null) {
                        var15 = Occluder.Entity_unpackID(var66.tag);
                        if (var38 != 4 && var38 != 5) {
                           if (var38 == 6) {
                              var66.renderable1 = new DynamicObject(var15, 4, var84 + 4, class383.Client_plane, var7, var8, var13, false, var66.renderable1);
                           } else if (var38 == 7) {
                              var66.renderable1 = new DynamicObject(var15, 4, (var84 + 2 & 3) + 4, class383.Client_plane, var7, var8, var13, false, var66.renderable1);
                           } else if (var38 == 8) {
                              var66.renderable1 = new DynamicObject(var15, 4, var84 + 4, class383.Client_plane, var7, var8, var13, false, var66.renderable1);
                              var66.renderable2 = new DynamicObject(var15, 4, (var84 + 2 & 3) + 4, class383.Client_plane, var7, var8, var13, false, var66.renderable2);
                           }
                        } else {
                           var66.renderable1 = new DynamicObject(var15, 4, var84, class383.Client_plane, var7, var8, var13, false, var66.renderable1);
                        }
                     }
                  } else if (var12 == 2) {
                     var14 = ReflectionCheck.scene.getGameObject(class383.Client_plane, var7, var8);
                     if (var38 == 11) {
                        var38 = 10;
                     }

                     if (var14 != null) {
                        var14.renderable = new DynamicObject(Occluder.Entity_unpackID(var14.tag), var38, var84, class383.Client_plane, var7, var8, var13, false, var14.renderable);
                     }
                  } else if (var12 == 3) {
                     FloorDecoration var65 = ReflectionCheck.scene.getFloorDecoration(class383.Client_plane, var7, var8);
                     if (var65 != null) {
                        var65.renderable = new DynamicObject(Occluder.Entity_unpackID(var65.tag), 22, var84, class383.Client_plane, var7, var8, var13, false, var65.renderable);
                     }
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2639 == var1.serverPacket) {
               class19.updatePlayers(var3, var1.serverPacketLength);
               WorldMapID.method1448();
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2606 == var1.serverPacket) {
               class200.isLargePlayerInfo = true;
               class19.updatePlayers(var3, var1.serverPacketLength);
               WorldMapID.method1448();
               var1.serverPacket = null;
               return true;
            }

            InterfaceParent var85;
            if (ServerPacket.field2626 == var1.serverPacket) {
               var20 = var3.method2405();
               var5 = var3.method2396();
               var27 = var3.readUnsignedShort();
               var85 = (InterfaceParent)interfaceParents.get((long)var20);
               if (var85 != null) {
                  class9.closeInterface(var85, var27 != var85.group);
               }

               class7.ifOpenSub(var20, var27, var5);
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2667 == var1.serverPacket) {
               var20 = var3.method2373();
               var5 = var3.readUnsignedShort();
               var27 = var3.readUnsignedShort();
               var86 = ObjTypeCustomisation.getWidget(var20);
               var86.field2922 = var27 + (var5 << 16);
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2660 == var1.serverPacket) {
               return this.method372(var1);
            }

            if (ServerPacket.field2671 == var1.serverPacket) {
               DevicePcmPlayerProvider.method80(class276.field2552);
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2593 == var1.serverPacket) {
               return this.method373(var1, 1);
            }

            Widget var40;
            if (ServerPacket.field2596 == var1.serverPacket) {
               var20 = var3.method2373();
               var5 = var3.readInt();
               InterfaceParent var57 = (InterfaceParent)interfaceParents.get((long)var20);
               var85 = (InterfaceParent)interfaceParents.get((long)var5);
               if (var85 != null) {
                  class9.closeInterface(var85, var57 == null || var85.group != var57.group);
               }

               if (var57 != null) {
                  var57.remove();
                  interfaceParents.put(var57, (long)var5);
               }

               var40 = ObjTypeCustomisation.getWidget(var20);
               if (var40 != null) {
                  class69.invalidateWidget(var40);
               }

               var40 = ObjTypeCustomisation.getWidget(var5);
               if (var40 != null) {
                  class69.invalidateWidget(var40);
                  class169.revalidateWidgetScroll(class71.Widget_interfaceComponents[var40.id >>> 16], var40, true);
               }

               if (rootInterface != -1) {
                  GrandExchangeOfferAgeComparator.runIntfCloseListeners(rootInterface, 1);
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2676 == var1.serverPacket) {
               var20 = var3.method2405();
               var5 = var3.readUnsignedShort();
               var6 = ObjTypeCustomisation.getWidget(var20);
               if (var6.modelType != 6 || var5 != var6.modelId) {
                  var6.modelType = 6;
                  var6.modelId = var5;
                  class69.invalidateWidget(var6);
               }

               var1.serverPacket = null;
               return true;
            }

            boolean var55;
            String var56;
            if (ServerPacket.field2564 == var1.serverPacket) {
               var20 = var3.readUShortSmart();
               var55 = var3.readUnsignedByte() == 1;
               var56 = "";
               boolean var62 = false;
               if (var55) {
                  var56 = var3.readStringCp1252NullTerminated();
                  if (DefaultsGroup.friendSystem.isIgnored(new Username(var56, SecureRandomFuture.loginType))) {
                     var62 = true;
                  }
               }

               String var90 = var3.readStringCp1252NullTerminated();
               if (!var62) {
                  KitDefinition.addGameMessage(var20, var56, var90);
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2673 == var1.serverPacket) {
               byte[] var51 = new byte[var1.serverPacketLength];
               var3.method2322(var51, 0, var51.length);
               Buffer var75 = new Buffer(var51);
               var56 = var75.readStringCp1252NullTerminated();
               ModeWhere.openURL(var56, true, false);
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2617 == var1.serverPacket) {
               Player.logOut();
               var1.serverPacket = null;
               return false;
            }

            if (ServerPacket.field2654 == var1.serverPacket) {
               var20 = var3.method2373();
               var5 = var3.method2376();
               var6 = ObjTypeCustomisation.getWidget(var20);
               if (var6.modelType != 1 || var5 != var6.modelId) {
                  var6.modelType = 1;
                  var6.modelId = var5;
                  class69.invalidateWidget(var6);
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2642 == var1.serverPacket) {
               var20 = var3.readShort();
               var5 = var3.method2384();
               var6 = ObjTypeCustomisation.getWidget(var5);
               if (var20 != var6.sequenceId || var20 == -1) {
                  var6.sequenceId = var20;
                  var6.modelFrame = 0;
                  var6.modelFrameCycle = 0;
                  class69.invalidateWidget(var6);
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2582 == var1.serverPacket) {
               ParamComposition.field1638 = true;
               class312.updateNpcs(false, var3);
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2573 == var1.serverPacket) {
               DevicePcmPlayerProvider.method80(class276.field2549);
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2605 == var1.serverPacket) {
               DevicePcmPlayerProvider.method80(class276.field2550);
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2615 == var1.serverPacket) {
               class125.field1224 = var3.method2371();
               InvDefinition.field1464 = var3.method2394();

               for(var20 = InvDefinition.field1464; var20 < InvDefinition.field1464 + 8; ++var20) {
                  for(var5 = class125.field1224; var5 < class125.field1224 + 8; ++var5) {
                     if (groundItems[class383.Client_plane][var20][var5] != null) {
                        groundItems[class383.Client_plane][var20][var5] = null;
                        class358.updateItemPile(var20, var5);
                     }
                  }
               }

               for(PendingSpawn var50 = (PendingSpawn)pendingSpawns.last(); var50 != null; var50 = (PendingSpawn)pendingSpawns.previous()) {
                  if (var50.x >= InvDefinition.field1464 && var50.x < InvDefinition.field1464 + 8 && var50.y >= class125.field1224 && var50.y < class125.field1224 + 8 && var50.plane == class383.Client_plane) {
                     var50.hitpoints = 0;
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2647 == var1.serverPacket) {
               LoginScreenAnimation.field1028 = new class414(class34.HitSplatDefinition_cached);
               var1.serverPacket = null;
               return true;
            }

            NPC var39;
            if (ServerPacket.field2652 == var1.serverPacket) {
               var27 = var3.method2394();
               var20 = var3.method2376();
               var5 = var3.method2333();
               if (var5 == 65535) {
                  var5 = -1;
               }

               var39 = npcs[var20];
               if (var39 != null) {
                  if (var5 == var39.sequence && var5 != -1) {
                     var8 = AABB.SequenceDefinition_get(var5).field1786;
                     if (var8 == 1) {
                        var39.sequenceFrame = 0;
                        var39.sequenceFrameCycle = 0;
                        var39.sequenceDelay = var27;
                        var39.currentSequenceFrameIndex = 0;
                     } else if (var8 == 2) {
                        var39.currentSequenceFrameIndex = 0;
                     }
                  } else if (var5 == -1 || var39.sequence == -1 || AABB.SequenceDefinition_get(var5).field1809 >= AABB.SequenceDefinition_get(var39.sequence).field1809) {
                     var39.sequence = var5;
                     var39.sequenceFrame = 0;
                     var39.sequenceFrameCycle = 0;
                     var39.sequenceDelay = var27;
                     var39.currentSequenceFrameIndex = 0;
                     var39.field1004 = var39.pathLength;
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            long var41;
            long var44;
            if (ServerPacket.field2576 == var1.serverPacket) {
               var49 = var3.readStringCp1252NullTerminated();
               var28 = var3.readLong();
               var30 = (long)var3.readUnsignedShort();
               var41 = (long)var3.readMedium();
               PlayerType var93 = (PlayerType)World.findEnumerated(class149.PlayerType_values(), var3.readUnsignedByte());
               var44 = (var30 << 32) + var41;
               boolean var82 = false;

               for(var15 = 0; var15 < 100; ++var15) {
                  if (var44 == crossWorldMessageIds[var15]) {
                     var82 = true;
                     break;
                  }
               }

               if (var93.isUser && DefaultsGroup.friendSystem.isIgnored(new Username(var49, SecureRandomFuture.loginType))) {
                  var82 = true;
               }

               if (!var82 && field536 == 0) {
                  crossWorldMessageIds[crossWorldMessageIdsIndex] = var44;
                  crossWorldMessageIdsIndex = (crossWorldMessageIdsIndex + 1) % 100;
                  var26 = AbstractFont.escapeBrackets(VarbitComposition.method985(class153.method817(var3)));
                  if (var93.modIcon != -1) {
                     class381.addChatMessage(9, class456.method2305(var93.modIcon) + var49, var26, ModeWhere.base37DecodeLong(var28));
                  } else {
                     class381.addChatMessage(9, var49, var26, ModeWhere.base37DecodeLong(var28));
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2590 == var1.serverPacket) {
               DefaultsGroup.friendSystem.readUpdate(var3, var1.serverPacketLength);
               field560 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            boolean var80;
            if (ServerPacket.field2670 == var1.serverPacket) {
               var80 = var3.readUnsignedByte() == 1;
               if (var80) {
                  WorldMapLabelSize.field2243 = Message.method344() - var3.readLong();
                  ItemContainer.grandExchangeEvents = new GrandExchangeEvents(var3, true);
               } else {
                  ItemContainer.grandExchangeEvents = null;
               }

               field565 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2603 == var1.serverPacket) {
               DevicePcmPlayerProvider.method80(class276.field2543);
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2631 == var1.serverPacket) {
               minimapState = var3.readUnsignedByte();
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2665 == var1.serverPacket) {
               var20 = var3.method2384();
               var5 = var3.method2376();
               if (var5 == 65535) {
                  var5 = -1;
               }

               var27 = var3.method2384();
               var7 = var3.method2376();
               if (var7 == 65535) {
                  var7 = -1;
               }

               for(var8 = var5; var8 <= var7; ++var8) {
                  var41 = (long)var8 + ((long)var20 << 32);
                  Node var43 = widgetFlags.get(var41);
                  if (var43 != null) {
                     var43.remove();
                  }

                  widgetFlags.put(new IntegerNode(var27), var41);
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2567 == var1.serverPacket) {
               var20 = var3.method2376();
               var5 = var3.method2405();
               Varps.Varps_temp[var20] = var5;
               if (Varps.Varps_main[var20] != var5) {
                  Varps.Varps_main[var20] = var5;
               }

               MouseRecorder.changeGameOptions(var20);
               changedVarps[++changedVarpCount - 1 & 31] = var20;
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2664 == var1.serverPacket) {
               var80 = var3.readBoolean();
               if (var80) {
                  if (GameEngine.field129 == null) {
                     GameEngine.field129 = new class343();
                  }
               } else {
                  GameEngine.field129 = null;
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2580 == var1.serverPacket) {
               var9 = var3.method2333();
               var27 = var3.method2389();
               var20 = var27 >> 16;
               var5 = var27 >> 8 & 255;
               var7 = var20 + (var27 >> 4 & 7);
               var8 = var5 + (var27 & 7);
               var38 = var3.method2396();
               var84 = var3.method2377();
               if (var7 >= 0 && var8 >= 0 && var7 < 104 && var8 < 104) {
                  var7 = var7 * 128 + 64;
                  var8 = var8 * 128 + 64;
                  GraphicsObject var94 = new GraphicsObject(var9, class383.Client_plane, var7, var8, SpotAnimationDefinition.getTileHeight(var7, var8, class383.Client_plane) - var38, var84, cycle);
                  graphicsObjects.addFirst(var94);
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2586 == var1.serverPacket) {
               var20 = var3.readUnsignedByte();
               class272.method1514(var20);
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2629 == var1.serverPacket) {
               var20 = var3.readInt();
               var5 = var3.readInt();
               var27 = class276.getGcDuration();
               PacketBufferNode var88 = class136.getPacketBufferNode(ClientPacket.field2435, packetWriter.isaacCipher);
               var88.packetBuffer.method2383(var20);
               var88.packetBuffer.method2381(var5);
               var88.packetBuffer.writeByte(GameEngine.fps);
               var88.packetBuffer.writeByte(var27);
               packetWriter.addNode(var88);
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2613 == var1.serverPacket) {
               for(var20 = 0; var20 < Varps.Varps_main.length; ++var20) {
                  if (Varps.Varps_temp[var20] != Varps.Varps_main[var20]) {
                     Varps.Varps_main[var20] = Varps.Varps_temp[var20];
                     MouseRecorder.changeGameOptions(var20);
                     changedVarps[++changedVarpCount - 1 & 31] = var20;
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2624 == var1.serverPacket) {
               MilliClock.readReflectionCheck(var3, var1.serverPacketLength);
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2592 == var1.serverPacket) {
               DevicePcmPlayerProvider.method80(class276.field2553);
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2583 == var1.serverPacket) {
               var49 = var3.readStringCp1252NullTerminated();
               var21 = AbstractFont.escapeBrackets(VarbitComposition.method985(class153.method817(var3)));
               KitDefinition.addGameMessage(6, var49, var21);
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2577 == var1.serverPacket) {
               var20 = var3.readInt();
               InterfaceParent var73 = (InterfaceParent)interfaceParents.get((long)var20);
               if (var73 != null) {
                  class9.closeInterface(var73, true);
               }

               if (meslayerContinueWidget != null) {
                  class69.invalidateWidget(meslayerContinueWidget);
                  meslayerContinueWidget = null;
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2655 == var1.serverPacket) {
               UrlRequester.method640(var3.readStringCp1252NullTerminated());
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2578 == var1.serverPacket) {
               var49 = var3.readStringCp1252NullTerminated();
               var5 = var3.method2405();
               var6 = ObjTypeCustomisation.getWidget(var5);
               if (!var49.equals(var6.text)) {
                  var6.text = var49;
                  class69.invalidateWidget(var6);
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2633 == var1.serverPacket) {
               var20 = var3.readUnsignedShort();
               var5 = var3.method2405();
               var6 = ObjTypeCustomisation.getWidget(var5);
               if (var6.modelType != 2 || var20 != var6.modelId) {
                  var6.modelType = 2;
                  var6.modelId = var20;
                  class69.invalidateWidget(var6);
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2644 == var1.serverPacket) {
               var20 = var3.readUnsignedShort();
               var5 = var3.readUnsignedByte();
               var27 = var3.readUnsignedShort();
               class1.queueSoundEffect(var20, var5, var27);
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2635 == var1.serverPacket) {
               var20 = var3.readInt();
               var5 = var3.readUnsignedShort();
               if (var20 < -70000) {
                  var5 += 32768;
               }

               if (var20 >= 0) {
                  var6 = ObjTypeCustomisation.getWidget(var20);
               } else {
                  var6 = null;
               }

               if (var6 != null) {
                  for(var7 = 0; var7 < var6.itemIds.length; ++var7) {
                     var6.itemIds[var7] = 0;
                     var6.itemQuantities[var7] = 0;
                  }
               }

               Script.clearItemContainer(var5);
               var7 = var3.readUnsignedShort();

               for(var8 = 0; var8 < var7; ++var8) {
                  var9 = var3.method2371();
                  if (var9 == 255) {
                     var9 = var3.method2384();
                  }

                  var38 = var3.method2333();
                  if (var6 != null && var8 < var6.itemIds.length) {
                     var6.itemIds[var8] = var38;
                     var6.itemQuantities[var8] = var9;
                  }

                  class12.itemContainerSetItem(var5, var8, var38 - 1, var9);
               }

               if (var6 != null) {
                  class69.invalidateWidget(var6);
               }

               class136.method738();
               changedItemContainers[++changedItemContainersCount - 1 & 31] = var5 & 32767;
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2636 == var1.serverPacket) {
               class312.updateNpcs(true, var3);
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2589 == var1.serverPacket) {
               var3.offset += 28;
               if (var3.checkCrc()) {
                  TileItem.method606(var3, var3.offset - 28);
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2601 == var1.serverPacket) {
               DevicePcmPlayerProvider.method80(class276.field2545);
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2678 == var1.serverPacket) {
               var20 = var3.method2333();
               if (var20 == 65535) {
                  var20 = -1;
               }

               var5 = var3.method2405();
               var27 = var3.method2384();
               var86 = ObjTypeCustomisation.getWidget(var5);
               ItemComposition var89;
               if (!var86.isIf3) {
                  if (var20 == -1) {
                     var86.modelType = 0;
                     var1.serverPacket = null;
                     return true;
                  }

                  var89 = NPCComposition.ItemDefinition_get(var20);
                  var86.modelType = 4;
                  var86.modelId = var20;
                  var86.modelAngleX = var89.xan2d;
                  var86.modelAngleY = var89.yan2d;
                  var86.modelZoom = var89.zoom2d * 100 / var27;
                  class69.invalidateWidget(var86);
               } else {
                  var86.itemId = var20;
                  var86.itemQuantity = var27;
                  var89 = NPCComposition.ItemDefinition_get(var20);
                  var86.modelAngleX = var89.xan2d;
                  var86.modelAngleY = var89.yan2d;
                  var86.modelAngleZ = var89.zan2d;
                  var86.modelOffsetX = var89.offsetX2d;
                  var86.modelOffsetY = var89.offsetY2d;
                  var86.modelZoom = var89.zoom2d;
                  if (var89.isStackable == 1) {
                     var86.itemQuantityMode = 1;
                  } else {
                     var86.itemQuantityMode = 2;
                  }

                  if (var86.modelRotation > 0) {
                     var86.modelZoom = var86.modelZoom * 32 / var86.modelRotation;
                  } else if (var86.rawWidth > 0) {
                     var86.modelZoom = var86.modelZoom * 32 / var86.rawWidth;
                  }

                  class69.invalidateWidget(var86);
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2672 == var1.serverPacket) {
               DevicePcmPlayerProvider.method80(class276.field2546);
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2666 == var1.serverPacket) {
               class125.field1224 = var3.method2394();
               InvDefinition.field1464 = var3.method2394();
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2650 == var1.serverPacket) {
               var20 = var3.method2405();
               var5 = var3.method2376();
               var27 = var3.method2376();
               var7 = var3.method2376();
               var40 = ObjTypeCustomisation.getWidget(var20);
               if (var5 != var40.modelAngleX || var7 != var40.modelAngleY || var27 != var40.modelZoom) {
                  var40.modelAngleX = var5;
                  var40.modelAngleY = var7;
                  var40.modelZoom = var27;
                  class69.invalidateWidget(var40);
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2648 == var1.serverPacket) {
               var20 = var3.offset + var1.serverPacketLength;
               var5 = var3.readUnsignedShort();
               var27 = var3.readUnsignedShort();
               if (var5 != rootInterface) {
                  rootInterface = var5;
                  this.resizeRoot(false);
                  class69.Widget_resetModelFrames(rootInterface);
                  class31.runWidgetOnLoadListener(rootInterface);

                  for(var7 = 0; var7 < 100; ++var7) {
                     field576[var7] = true;
                  }
               }

               InterfaceParent var10;
               for(; var27-- > 0; var10.field840 = true) {
                  var7 = var3.readInt();
                  var8 = var3.readUnsignedShort();
                  var9 = var3.readUnsignedByte();
                  var10 = (InterfaceParent)interfaceParents.get((long)var7);
                  if (var10 != null && var8 != var10.group) {
                     class9.closeInterface(var10, true);
                     var10 = null;
                  }

                  if (var10 == null) {
                     var10 = class7.ifOpenSub(var7, var8, var9);
                  }
               }

               for(var85 = (InterfaceParent)interfaceParents.first(); var85 != null; var85 = (InterfaceParent)interfaceParents.next()) {
                  if (var85.field840) {
                     var85.field840 = false;
                  } else {
                     class9.closeInterface(var85, true);
                  }
               }

               widgetFlags = new NodeHashTable(512);

               while(var3.offset < var20) {
                  var7 = var3.readInt();
                  var8 = var3.readUnsignedShort();
                  var9 = var3.readUnsignedShort();
                  var38 = var3.readInt();

                  for(var84 = var8; var84 <= var9; ++var84) {
                     var44 = ((long)var7 << 32) + (long)var84;
                     widgetFlags.put(new IntegerNode(var38), var44);
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2581 == var1.serverPacket) {
               var5 = var3.method2405();
               var20 = var3.readUnsignedShort();
               var39 = npcs[var20];
               var27 = var3.readUnsignedShort();
               if (var39 != null) {
                  var39.spotAnimation = var27;
                  var39.spotAnimHeight = var5 >> 16;
                  var39.spotAnimationStartCycle = (var5 & '\uffff') + cycle;
                  var39.spotAnimationFrame = 0;
                  var39.spotAnimFrameCycle = 0;
                  if (var39.spotAnimationStartCycle > cycle) {
                     var39.spotAnimationFrame = -1;
                  }

                  if (var39.spotAnimation == 65535) {
                     var39.spotAnimation = -1;
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2614 == var1.serverPacket) {
               DevicePcmPlayerProvider.method80(class276.field2548);
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2598 == var1.serverPacket) {
               if (rootInterface != -1) {
                  GrandExchangeOfferAgeComparator.runIntfCloseListeners(rootInterface, 0);
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2575 == var1.serverPacket) {
               isCameraLocked = true;
               field617 = false;
               class109.cameraLookAtX = var3.readUnsignedByte();
               class146.cameraLookAtY = var3.readUnsignedByte();
               class104.cameraLookAtHeight = var3.readUnsignedShort();
               class415.cameraLookAtSpeed = var3.readUnsignedByte();
               LoginScreenAnimation.cameraLookAtAcceleration = var3.readUnsignedByte();
               if (LoginScreenAnimation.cameraLookAtAcceleration >= 100) {
                  var20 = class109.cameraLookAtX * 128 + 64;
                  var5 = class146.cameraLookAtY * 128 + 64;
                  var27 = SpotAnimationDefinition.getTileHeight(var20, var5, class383.Client_plane) - class104.cameraLookAtHeight;
                  var7 = var20 - class145.cameraX;
                  var8 = var27 - class414.cameraY;
                  var9 = var5 - ClanChannel.cameraZ;
                  var38 = (int)Math.sqrt((double)(var9 * var9 + var7 * var7));
                  class97.cameraPitch = (int)(Math.atan2((double)var8, (double)var38) * 325.9490051269531D) & 2047;
                  class128.cameraYaw = (int)(Math.atan2((double)var7, (double)var9) * -325.9490051269531D) & 2047;
                  if (class97.cameraPitch < 128) {
                     class97.cameraPitch = 128;
                  }

                  if (class97.cameraPitch > 383) {
                     class97.cameraPitch = 383;
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2645 == var1.serverPacket) {
               var74 = var3.readByte();
               var28 = (long)var3.readUnsignedShort();
               var30 = (long)var3.readMedium();
               var41 = var30 + (var28 << 32);
               boolean var37 = false;
               ClanChannel var46 = var74 >= 0 ? currentClanChannels[var74] : VarcInt.guestClanChannel;
               if (var46 == null) {
                  var37 = true;
               } else {
                  for(var13 = 0; var13 < 100; ++var13) {
                     if (crossWorldMessageIds[var13] == var41) {
                        var37 = true;
                        break;
                     }
                  }
               }

               if (!var37) {
                  crossWorldMessageIds[crossWorldMessageIdsIndex] = var41;
                  crossWorldMessageIdsIndex = (crossWorldMessageIdsIndex + 1) % 100;
                  var35 = class153.method817(var3);
                  var36 = var74 >= 0 ? 43 : 46;
                  class381.addChatMessage(var36, "", var35, var46.name);
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2620 == var1.serverPacket) {
               class136.method738();
               runEnergy = var3.readUnsignedByte();
               runEnergy = runEnergy * 809546495 * 100 * 664161535;
               field566 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2570 == var1.serverPacket) {
               var20 = var3.method2384();
               var55 = var3.readUnsignedByte() == 1;
               var6 = ObjTypeCustomisation.getWidget(var20);
               if (var55 != var6.isHidden) {
                  var6.isHidden = var55;
                  class69.invalidateWidget(var6);
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2649 == var1.serverPacket) {
               ParamComposition.field1638 = true;
               class312.updateNpcs(true, var3);
               var1.serverPacket = null;
               return true;
            }

            Widget var71;
            if (ServerPacket.field2610 == var1.serverPacket) {
               var20 = var3.method2384();
               var71 = ObjTypeCustomisation.getWidget(var20);
               var71.modelType = 3;
               var71.modelId = class155.localPlayer.appearance.getChatHeadId();
               class69.invalidateWidget(var71);
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2621 == var1.serverPacket) {
               class136.method738();
               weight = var3.readShort();
               field566 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2568 == var1.serverPacket) {
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2630 == var1.serverPacket) {
               return this.method373(var1, 2);
            }

            if (ServerPacket.field2563 == var1.serverPacket) {
               var20 = var3.readInt();
               if (var20 != field634) {
                  field634 = var20;
                  CollisionMap.method1096();
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2597 == var1.serverPacket) {
               var49 = var3.readStringCp1252NullTerminated();
               Object[] var72 = new Object[var49.length() + 1];

               for(var27 = var49.length() - 1; var27 >= 0; --var27) {
                  if (var49.charAt(var27) == 's') {
                     var72[var27 + 1] = var3.readStringCp1252NullTerminated();
                  } else {
                     var72[var27 + 1] = new Integer(var3.readInt());
                  }
               }

               var72[0] = new Integer(var3.readInt());
               ScriptEvent var52 = new ScriptEvent();
               var52.args = var72;
               WorldMapElement.runScriptEvent(var52);
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2637 == var1.serverPacket) {
               var20 = var3.readInt();
               var5 = var3.method2376();
               var6 = ObjTypeCustomisation.getWidget(var20);
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

            if (ServerPacket.field2641 == var1.serverPacket) {
               var20 = var3.method2377();
               DynamicObject.method452(var20);
               changedItemContainers[++changedItemContainersCount - 1 & 31] = var20 & 32767;
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2632 == var1.serverPacket) {
               var20 = var3.readUnsignedByte();
               var5 = var3.readUnsignedByte();
               var27 = var3.readUnsignedByte();
               var7 = var3.readUnsignedByte();
               cameraShaking[var20] = true;
               cameraShakeIntensity[var20] = var5;
               cameraMoveIntensity[var20] = var27;
               cameraShakeSpeed[var20] = var7;
               cameraShakeCycle[var20] = 0;
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2653 == var1.serverPacket) {
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

            if (ServerPacket.field2619 == var1.serverPacket) {
               var20 = var3.readInt();
               var71 = ObjTypeCustomisation.getWidget(var20);

               for(var27 = 0; var27 < var71.itemIds.length; ++var27) {
                  var71.itemIds[var27] = -1;
                  var71.itemIds[var27] = 0;
               }

               class69.invalidateWidget(var71);
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2640 == var1.serverPacket) {
               var20 = var3.readUnsignedByte();
               PlayerComposition.forceDisconnect(var20);
               var1.serverPacket = null;
               return false;
            }

            if (ServerPacket.field2595 == var1.serverPacket) {
               publicChatMode = var3.readUnsignedByte();
               tradeChatMode = var3.method2394();
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2565 == var1.serverPacket) {
               DevicePcmPlayerProvider.method80(class276.field2542);
               var1.serverPacket = null;
               return true;
            }

            class132.RunException_sendStackTrace("" + (var1.serverPacket != null ? var1.serverPacket.id * -170435115 * 1034875773 : -1) + "," + (var1.field1135 != null ? var1.field1135.id * -170435115 * 1034875773 : -1) + "," + (var1.field1136 != null ? var1.field1136.id * -170435115 * 1034875773 : -1) + "," + var1.serverPacketLength, (Throwable)null);
            Player.logOut();
         } catch (IOException var47) {
            FaceNormal.method1236();
         } catch (Exception var48) {
            var21 = "" + (var1.serverPacket != null ? var1.serverPacket.id * -170435115 * 1034875773 : -1) + "," + (var1.field1135 != null ? var1.field1135.id * -170435115 * 1034875773 : -1) + "," + (var1.field1136 != null ? var1.field1136.id * -170435115 * 1034875773 : -1) + "," + var1.serverPacketLength + "," + (class155.localPlayer.pathX[0] + class154.baseX) + "," + (class155.localPlayer.pathY[0] + class365.baseY) + ",";

            for(var27 = 0; var27 < var1.serverPacketLength && var27 < 50; ++var27) {
               var21 = var21 + var3.array[var27] + ",";
            }

            class132.RunException_sendStackTrace(var21, var48);
            Player.logOut();
         }

         return true;
      }
   }

   @ObfuscatedName("jr")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "919576358"
   )
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

      if (class368.dragInventoryWidget == null) {
         if (clickedWidget == null) {
            int var21;
            label220: {
               int var20 = MouseHandler.MouseHandler_lastButton;
               int var7;
               int var9;
               int var11;
               int var16;
               int var22;
               if (isMenuOpen) {
                  int var15;
                  if (var20 != 1 && (SceneTilePaint.mouseCam || var20 != 4)) {
                     var2 = MouseHandler.MouseHandler_x;
                     var15 = MouseHandler.MouseHandler_y;
                     if (var2 < VarcInt.menuX - 10 || var2 > AttackOption.menuWidth + VarcInt.menuX + 10 || var15 < NPC.menuY - 10 || var15 > MouseHandler.menuHeight + NPC.menuY + 10) {
                        isMenuOpen = false;
                        ReflectionCheck.method190(VarcInt.menuX, NPC.menuY, AttackOption.menuWidth, MouseHandler.menuHeight);
                     }
                  }

                  if (var20 == 1 || !SceneTilePaint.mouseCam && var20 == 4) {
                     var2 = VarcInt.menuX;
                     var15 = NPC.menuY;
                     var16 = AttackOption.menuWidth;
                     var5 = MouseHandler.MouseHandler_lastPressedX;
                     var21 = MouseHandler.MouseHandler_lastPressedY;
                     var7 = -1;

                     for(var22 = 0; var22 < menuOptionsCount; ++var22) {
                        var9 = var15 + (menuOptionsCount - 1 - var22) * 15 + 31;
                        if (var5 > var2 && var5 < var16 + var2 && var21 > var9 - 13 && var21 < var9 + 3) {
                           var7 = var22;
                        }
                     }

                     if (var7 != -1 && var7 >= 0) {
                        var22 = menuArguments1[var7];
                        var9 = menuArguments2[var7];
                        int var23 = menuOpcodes[var7];
                        var11 = menuIdentifiers[var7];
                        int var12 = menuItemIds[var7];
                        String var13 = menuActions[var7];
                        String var14 = menuTargets[var7];
                        WorldMapData_0.menuAction(var22, var9, var23, var11, var12, var13, var14, MouseHandler.MouseHandler_lastPressedX, MouseHandler.MouseHandler_lastPressedY);
                     }

                     isMenuOpen = false;
                     ReflectionCheck.method190(VarcInt.menuX, NPC.menuY, AttackOption.menuWidth, MouseHandler.menuHeight);
                  }
               } else {
                  var2 = menuOptionsCount - 1;
                  if ((var20 == 1 || !SceneTilePaint.mouseCam && var20 == 4) && var2 >= 0) {
                     var16 = menuOpcodes[var2];
                     if (var16 == 39 || var16 == 40 || var16 == 41 || var16 == 42 || var16 == 43 || var16 == 33 || var16 == 34 || var16 == 35 || var16 == 36 || var16 == 37 || var16 == 38 || var16 == 1005) {
                        var5 = menuArguments1[var2];
                        var21 = menuArguments2[var2];
                        Widget var17 = ObjTypeCustomisation.getWidget(var21);
                        var9 = Clock.getWidgetFlags(var17);
                        boolean var8 = (var9 >> 28 & 1) != 0;
                        if (var8) {
                           break label220;
                        }

                        var11 = Clock.getWidgetFlags(var17);
                        boolean var10 = (var11 >> 29 & 1) != 0;
                        if (var10) {
                           break label220;
                        }
                     }
                  }

                  if ((var20 == 1 || !SceneTilePaint.mouseCam && var20 == 4) && this.shouldLeftClickOpenMenu()) {
                     var20 = 2;
                  }

                  if ((var20 == 1 || !SceneTilePaint.mouseCam && var20 == 4) && menuOptionsCount > 0 && var2 >= 0) {
                     var16 = menuArguments1[var2];
                     var5 = menuArguments2[var2];
                     var21 = menuOpcodes[var2];
                     var7 = menuIdentifiers[var2];
                     var22 = menuItemIds[var2];
                     String var18 = menuActions[var2];
                     String var19 = menuTargets[var2];
                     WorldMapData_0.menuAction(var16, var5, var21, var7, var22, var18, var19, MouseHandler.MouseHandler_lastPressedX, MouseHandler.MouseHandler_lastPressedY);
                  }

                  if (var20 == 2 && menuOptionsCount > 0) {
                     this.openMenu(MouseHandler.MouseHandler_lastPressedX, MouseHandler.MouseHandler_lastPressedY);
                  }
               }

               return;
            }

            if (class368.dragInventoryWidget != null && !field475 && menuOptionsCount > 0 && !this.shouldLeftClickOpenMenu()) {
               WorldMapLabelSize.method1310(draggedWidgetX, draggedWidgetY);
            }

            field475 = false;
            itemDragDuration = 0;
            if (class368.dragInventoryWidget != null) {
               class69.invalidateWidget(class368.dragInventoryWidget);
            }

            class368.dragInventoryWidget = ObjTypeCustomisation.getWidget(var21);
            dragItemSlotSource = var5;
            draggedWidgetX = MouseHandler.MouseHandler_lastPressedX;
            draggedWidgetY = MouseHandler.MouseHandler_lastPressedY;
            if (var2 >= 0) {
               ReflectionCheck.method187(var2);
            }

            class69.invalidateWidget(class368.dragInventoryWidget);
         }
      }
   }

   @ObfuscatedName("jp")
   @ObfuscatedSignature(
      descriptor = "(I)Z",
      garbageValue = "1964270751"
   )
   final boolean shouldLeftClickOpenMenu() {
      int var1 = menuOptionsCount - 1;
      return (leftClickOpensMenu && menuOptionsCount > 2 || class281.method1532(var1)) && !menuShiftClick[var1];
   }

   @ObfuscatedName("jn")
   @ObfuscatedSignature(
      descriptor = "(III)V",
      garbageValue = "712334109"
   )
   final void openMenu(int var1, int var2) {
      int var3 = class146.fontBold12.stringWidth("Choose Option");

      int var4;
      int var5;
      for(var4 = 0; var4 < menuOptionsCount; ++var4) {
         var5 = class146.fontBold12.stringWidth(class34.method143(var4));
         if (var5 > var3) {
            var3 = var5;
         }
      }

      var3 += 8;
      var4 = menuOptionsCount * 15 + 22;
      var5 = var1 - var3 / 2;
      if (var3 + var5 > CollisionMap.canvasWidth) {
         var5 = CollisionMap.canvasWidth - var3;
      }

      if (var5 < 0) {
         var5 = 0;
      }

      int var6 = var2;
      if (var4 + var2 > Language.canvasHeight) {
         var6 = Language.canvasHeight - var4;
      }

      if (var6 < 0) {
         var6 = 0;
      }

      VarcInt.menuX = var5;
      NPC.menuY = var6;
      AttackOption.menuWidth = var3;
      MouseHandler.menuHeight = menuOptionsCount * 15 + 22;
      var1 -= viewportOffsetX;
      var2 -= viewportOffsetY;
      ReflectionCheck.scene.menuOpen(class383.Client_plane, var1, var2, false);
      isMenuOpen = true;
   }

   @ObfuscatedName("kb")
   @ObfuscatedSignature(
      descriptor = "(ZI)V",
      garbageValue = "-462347970"
   )
   final void resizeRoot(boolean var1) {
      ByteArrayPool.method1996(rootInterface, CollisionMap.canvasWidth, Language.canvasHeight, var1);
   }

   @ObfuscatedName("kp")
   @ObfuscatedSignature(
      descriptor = "(Lkd;I)V",
      garbageValue = "-1538657910"
   )
   void alignWidget(Widget var1) {
      Widget var2 = var1.parentId == -1 ? null : ObjTypeCustomisation.getWidget(var1.parentId);
      int var3;
      int var4;
      if (var2 == null) {
         var3 = CollisionMap.canvasWidth;
         var4 = Language.canvasHeight;
      } else {
         var3 = var2.width;
         var4 = var2.height;
      }

      Player.alignWidgetSize(var1, var3, var4, false);
      class89.alignWidgetPosition(var1, var3, var4);
   }

   @ObfuscatedName("ls")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "607225278"
   )
   final void method371() {
      class69.invalidateWidget(clickedWidget);
      ++class87.widgetDragDuration;
      if (field546 && field590) {
         int var1 = MouseHandler.MouseHandler_x;
         int var2 = MouseHandler.MouseHandler_y;
         var1 -= widgetClickX;
         var2 -= widgetClickY;
         if (var1 < field544) {
            var1 = field544;
         }

         if (var1 + clickedWidget.width > field544 + clickedWidgetParent.width) {
            var1 = field544 + clickedWidgetParent.width - clickedWidget.width;
         }

         if (var2 < field458) {
            var2 = field458;
         }

         if (var2 + clickedWidget.height > field458 + clickedWidgetParent.height) {
            var2 = field458 + clickedWidgetParent.height - clickedWidget.height;
         }

         int var3 = var1 - field364;
         int var4 = var2 - field548;
         int var5 = clickedWidget.dragZoneSize;
         if (class87.widgetDragDuration > clickedWidget.dragThreshold && (var3 > var5 || var3 < -var5 || var4 > var5 || var4 < -var5)) {
            isDraggingWidget = true;
         }

         int var6 = var1 - field544 + clickedWidgetParent.scrollX;
         int var7 = var2 - field458 + clickedWidgetParent.scrollY;
         ScriptEvent var8;
         if (clickedWidget.onDrag != null && isDraggingWidget) {
            var8 = new ScriptEvent();
            var8.widget = clickedWidget;
            var8.mouseX = var6;
            var8.mouseY = var7;
            var8.args = clickedWidget.onDrag;
            WorldMapElement.runScriptEvent(var8);
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
                  WorldMapElement.runScriptEvent(var8);
               }

               if (draggedOnWidget != null) {
                  Widget var9 = clickedWidget;
                  int var11 = Clock.getWidgetFlags(var9);
                  int var10 = var11 >> 17 & 7;
                  int var12 = var10;
                  Widget var15;
                  if (var10 == 0) {
                     var15 = null;
                  } else {
                     int var13 = 0;

                     while(true) {
                        if (var13 >= var12) {
                           var15 = var9;
                           break;
                        }

                        var9 = ObjTypeCustomisation.getWidget(var9.parentId);
                        if (var9 == null) {
                           var15 = null;
                           break;
                        }

                        ++var13;
                     }
                  }

                  if (var15 != null) {
                     PacketBufferNode var14 = class136.getPacketBufferNode(ClientPacket.field2510, packetWriter.isaacCipher);
                     var14.packetBuffer.method2386(clickedWidget.itemId);
                     var14.packetBuffer.method2375(clickedWidget.childIndex);
                     var14.packetBuffer.method2383(draggedOnWidget.id);
                     var14.packetBuffer.method2381(clickedWidget.id);
                     var14.packetBuffer.method2386(draggedOnWidget.childIndex);
                     var14.packetBuffer.method2386(draggedOnWidget.itemId);
                     packetWriter.addNode(var14);
                  }
               }
            } else if (this.shouldLeftClickOpenMenu()) {
               this.openMenu(field364 + widgetClickX, widgetClickY + field548);
            } else if (menuOptionsCount > 0) {
               WorldMapLabelSize.method1310(field364 + widgetClickX, field548 + widgetClickY);
            }

            clickedWidget = null;
         }

      } else {
         if (class87.widgetDragDuration > 1) {
            if (!isDraggingWidget && menuOptionsCount > 0) {
               WorldMapLabelSize.method1310(widgetClickX + field364, field548 + widgetClickY);
            }

            clickedWidget = null;
         }

      }
   }

   @ObfuscatedName("mw")
   @ObfuscatedSignature(
      descriptor = "(B)Lrp;",
      garbageValue = "77"
   )
   public Username username() {
      return class155.localPlayer != null ? class155.localPlayer.username : null;
   }

   @ObfuscatedName("init")
   public final void init() {
      if (this.checkHost()) {
         int var8;
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
                  Language var16;
                  if (var4 >= 0 && var4 < Language.field3526.length) {
                     var16 = Language.field3526[var4];
                  } else {
                     var16 = null;
                  }

                  class173.clientLanguage = var16;
                  break;
               case 7:
                  ModeWhere.field3543 = class16.method54(Integer.parseInt(var2));
                  break;
               case 8:
                  if (var2.equalsIgnoreCase("true")) {
                     ;
                  }
                  break;
               case 9:
                  class133.field1284 = var2;
                  break;
               case 10:
                  StudioGame[] var3 = new StudioGame[]{StudioGame.game3, StudioGame.stellardawn, StudioGame.runescape, StudioGame.oldscape, StudioGame.game5, StudioGame.game4};
                  LoginPacket.field2681 = (StudioGame)World.findEnumerated(var3, Integer.parseInt(var2));
                  if (LoginPacket.field2681 == StudioGame.oldscape) {
                     SecureRandomFuture.loginType = LoginType.oldscape;
                  } else {
                     SecureRandomFuture.loginType = LoginType.field3942;
                  }
                  break;
               case 11:
                  class17.field51 = var2;
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
                  WallDecoration.field2226 = Integer.parseInt(var2);
                  break;
               case 15:
                  gameBuild = Integer.parseInt(var2);
                  break;
               case 17:
                  class9.field23 = var2;
                  break;
               case 21:
                  field356 = Integer.parseInt(var2);
                  break;
               case 25:
                  var8 = var2.indexOf(".");
                  if (var8 == -1) {
                     field360 = Integer.parseInt(var2);
                  } else {
                     field360 = Integer.parseInt(var2.substring(0, var8));
                     Integer.parseInt(var2.substring(var8 + 1));
                  }
               }
            }
         }

         class34.method138();
         class139.worldHost = this.getCodeBase().getHost();
         String var9 = ModeWhere.field3543.name;
         byte var10 = 0;

         try {
            class145.idxCount = 22;
            LoginPacket.cacheGamebuild = var10;

            try {
               FillMode.operatingSystemName = System.getProperty("os.name");
            } catch (Exception var14) {
               FillMode.operatingSystemName = "Unknown";
            }

            Decimator.formattedOperatingSystemName = FillMode.operatingSystemName.toLowerCase();

            try {
               UserComparator3.userHomeDirectory = System.getProperty("user.home");
               if (UserComparator3.userHomeDirectory != null) {
                  UserComparator3.userHomeDirectory = UserComparator3.userHomeDirectory + "/";
               }
            } catch (Exception var13) {
               ;
            }

            try {
               if (Decimator.formattedOperatingSystemName.startsWith("win")) {
                  if (UserComparator3.userHomeDirectory == null) {
                     UserComparator3.userHomeDirectory = System.getenv("USERPROFILE");
                  }
               } else if (UserComparator3.userHomeDirectory == null) {
                  UserComparator3.userHomeDirectory = System.getenv("HOME");
               }

               if (UserComparator3.userHomeDirectory != null) {
                  UserComparator3.userHomeDirectory = UserComparator3.userHomeDirectory + "/";
               }
            } catch (Exception var12) {
               ;
            }

            if (UserComparator3.userHomeDirectory == null) {
               UserComparator3.userHomeDirectory = "~/";
            }

            class121.cacheParentPaths = new String[]{"c:/rscache/", "/rscache/", "c:/windows/", "c:/winnt/", "c:/", UserComparator3.userHomeDirectory, "/tmp/", ""};
            class89.cacheSubPaths = new String[]{".jagex_cache_" + LoginPacket.cacheGamebuild, ".file_store_" + LoginPacket.cacheGamebuild};

            label133:
            for(var8 = 0; var8 < 4; ++var8) {
               class281.cacheDir = VarcInt.method921("oldschool", var9, var8);
               if (!class281.cacheDir.exists()) {
                  class281.cacheDir.mkdirs();
               }

               File[] var11 = class281.cacheDir.listFiles();
               if (var11 == null) {
                  break;
               }

               File[] var5 = var11;
               int var6 = 0;

               while(true) {
                  if (var6 >= var5.length) {
                     break label133;
                  }

                  File var7 = var5[var6];
                  if (!WorldMapLabelSize.method1307(var7, false)) {
                     break;
                  }

                  ++var6;
               }
            }

            class170.method886(class281.cacheDir);
            WorldMapSectionType.method1430();
            JagexCache.JagexCache_dat2File = new BufferedFile(new AccessFile(class306.getFile("main_file_cache.dat2"), "rw", 1048576000L), 5200, 0);
            JagexCache.JagexCache_idx255File = new BufferedFile(new AccessFile(class306.getFile("main_file_cache.idx255"), "rw", 1048576L), 6000, 0);
            JagexCache.JagexCache_idxFiles = new BufferedFile[class145.idxCount];

            for(var8 = 0; var8 < class145.idxCount; ++var8) {
               JagexCache.JagexCache_idxFiles[var8] = new BufferedFile(new AccessFile(class306.getFile("main_file_cache.idx" + var8), "rw", 1048576L), 6000, 0);
            }
         } catch (Exception var15) {
            class132.RunException_sendStackTrace((String)null, var15);
         }

         BuddyRankComparator.client = this;
         RuneLiteMenuEntry.client = (RSClient) (Object) this;
         RunException.clientType = clientType;
         if (field543 == -1) {
            field543 = 0;
         }

         class146.field1331 = System.getenv("JX_ACCESS_TOKEN");
         EnumComposition.field1536 = System.getenv("JX_REFRESH_TOKEN");
         if (Boolean.parseBoolean(System.getProperty("jagex.disableBouncyCastle"))) {
            this.field435 = true;
         }

         this.startThread(765, 503, 210, 1);
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      descriptor = "(ILbm;ZI)I",
      garbageValue = "-1945377907"
   )
   static int method382(int var0, Script var1, boolean var2) {
      if (var0 == 3200) {
         class87.Interpreter_intStackSize -= 3;
         class1.queueSoundEffect(Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize], Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize + 1], Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize + 2]);
         return 1;
      } else if (var0 == 3201) {
         class169.playSong(Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize]);
         return 1;
      } else if (var0 == 3202) {
         class87.Interpreter_intStackSize -= 2;
         class16.playJingle(Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize], Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize + 1]);
         return 1;
      } else {
         class87 var3;
         class86 var4;
         int var5;
         int var6;
         String var7;
         if (var0 != 3212 && var0 != 3213 && var0 != 3209 && var0 != 3181 && var0 != 3203 && var0 != 3205 && var0 != 3207) {
            if (var0 != 3214 && var0 != 3215 && var0 != 3210 && var0 != 3182 && var0 != 3204 && var0 != 3206 && var0 != 3208) {
               return var0 == 3211 ? 1 : 2;
            } else {
               var3 = class87.field875;
               var4 = class86.field870;
               boolean var8 = false;
               if (var0 == 3214) {
                  var6 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize];
                  var3 = (class87)World.findEnumerated(class163.method866(), var6);
                  if (var3 == null) {
                     throw new RuntimeException(String.format("Unrecognized device option %d", var6));
                  }
               }

               if (var0 == 3215) {
                  var6 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize];
                  var4 = (class86)World.findEnumerated(WorldMapEvent.method1490(), var6);
                  if (var4 == null) {
                     throw new RuntimeException(String.format("Unrecognized game option %d", var6));
                  }
               }

               if (var0 == 3210) {
                  var6 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize];
                  var3 = (class87)World.findEnumerated(class163.method866(), var6);
                  if (var3 == null) {
                     var4 = (class86)World.findEnumerated(WorldMapEvent.method1490(), var6);
                     if (var4 == null) {
                        throw new RuntimeException(String.format("Unrecognized client option %d", var6));
                     }
                  }
               } else if (var0 == 3182) {
                  var3 = class87.field879;
               } else if (var0 == 3204) {
                  var4 = class86.field862;
               } else if (var0 == 3206) {
                  var4 = class86.field865;
               } else if (var0 == 3208) {
                  var4 = class86.field866;
               }

               if (var4 == class86.field870) {
                  switch(var3.field876) {
                  case 1:
                     var5 = StructComposition.clientPreferences.method536() ? 1 : 0;
                     break;
                  case 2:
                     var5 = StructComposition.clientPreferences.method546() ? 1 : 0;
                     break;
                  case 3:
                     var5 = StructComposition.clientPreferences.method538() ? 1 : 0;
                     break;
                  case 4:
                     var5 = StructComposition.clientPreferences.method540();
                     break;
                  case 5:
                     var5 = class273.method1517();
                     break;
                  default:
                     var7 = String.format("Unkown device option: %s.", var3.toString());
                     throw new RuntimeException(var7);
                  }
               } else {
                  switch(var4.field864) {
                  case 1:
                     var5 = StructComposition.clientPreferences.method535() ? 1 : 0;
                     break;
                  case 2:
                     var6 = StructComposition.clientPreferences.method543();
                     var5 = Math.round((float)(var6 * 100) / 255.0F);
                     break;
                  case 3:
                     var6 = StructComposition.clientPreferences.method544();
                     var5 = Math.round((float)(var6 * 100) / 127.0F);
                     break;
                  case 4:
                     var6 = StructComposition.clientPreferences.method563();
                     var5 = Math.round((float)(var6 * 100) / 127.0F);
                     break;
                  default:
                     var7 = String.format("Unkown game option: %s.", var4.toString());
                     throw new RuntimeException(var7);
                  }
               }

               Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = var5;
               return 1;
            }
         } else {
            var3 = class87.field875;
            var4 = class86.field870;
            var5 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize];
            if (var0 == 3212) {
               var6 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize];
               var3 = (class87)World.findEnumerated(class163.method866(), var6);
               if (var3 == null) {
                  throw new RuntimeException(String.format("Unrecognized device option %d", var6));
               }
            }

            if (var0 == 3213) {
               var6 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize];
               var4 = (class86)World.findEnumerated(WorldMapEvent.method1490(), var6);
               if (var4 == null) {
                  throw new RuntimeException(String.format("Unrecognized game option %d", var6));
               }
            }

            if (var0 == 3209) {
               var6 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize];
               var3 = (class87)World.findEnumerated(class163.method866(), var6);
               if (var3 == null) {
                  var4 = (class86)World.findEnumerated(WorldMapEvent.method1490(), var6);
                  if (var4 == null) {
                     throw new RuntimeException(String.format("Unrecognized client option %d", var6));
                  }
               }
            } else if (var0 == 3181) {
               var3 = class87.field879;
            } else if (var0 == 3203) {
               var4 = class86.field862;
            } else if (var0 == 3205) {
               var4 = class86.field865;
            } else if (var0 == 3207) {
               var4 = class86.field866;
            }

            if (var4 == class86.field870) {
               switch(var3.field876) {
               case 1:
                  StructComposition.clientPreferences.method558(var5 == 1);
                  break;
               case 2:
                  StructComposition.clientPreferences.method556(var5 == 1);
                  break;
               case 3:
                  StructComposition.clientPreferences.method559(var5 == 1);
                  break;
               case 4:
                  if (var5 < 0) {
                     var5 = 0;
                  }

                  StructComposition.clientPreferences.method539(var5);
                  break;
               case 5:
                  class14.method49(var5);
                  break;
               default:
                  var7 = String.format("Unkown device option: %s.", var3.toString());
                  throw new RuntimeException(var7);
               }
            } else {
               switch(var4.field864) {
               case 1:
                  StructComposition.clientPreferences.method562(var5 == 1);
                  break;
               case 2:
                  var5 = Math.min(Math.max(var5, 0), 100);
                  var6 = Math.round((float)(var5 * 255) / 100.0F);
                  class299.method1613(var6);
                  break;
               case 3:
                  var5 = Math.min(Math.max(var5, 0), 100);
                  var6 = Math.round((float)(var5 * 127) / 100.0F);
                  class7.method15(var6);
                  break;
               case 4:
                  var5 = Math.min(Math.max(var5, 0), 100);
                  var6 = Math.round((float)(var5 * 127) / 100.0F);
                  class18.method64(var6);
                  break;
               default:
                  var7 = String.format("Unkown game option: %s.", var4.toString());
                  throw new RuntimeException(var7);
               }
            }

            return 1;
         }
      }
   }

   @ObfuscatedName("fm")
   @ObfuscatedSignature(
      descriptor = "(B)Lpb;",
      garbageValue = "45"
   )
   static WorldMap getWorldMap() {
      return KitDefinition.worldMap;
   }

   @ObfuscatedName("gs")
   @ObfuscatedSignature(
      descriptor = "(S)V",
      garbageValue = "-4511"
   )
   static final void playPcmPlayers() {
      if (UserComparator8.pcmPlayer1 != null) {
         UserComparator8.pcmPlayer1.run();
      }

      if (TileItem.pcmPlayer0 != null) {
         TileItem.pcmPlayer0.run();
      }

   }
}
