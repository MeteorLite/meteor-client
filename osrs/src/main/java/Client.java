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
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Future;

import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSClient;

@Implements("Client")
@ObfuscatedName("client")
public final class Client extends GameEngine implements Usernamed, OAuthApi {
   @ObfuscatedName("se")
   @ObfuscatedSignature(
           descriptor = "[Leb;"
   )
   static ClanSettings[] currentClanSettings;
   @ObfuscatedName("uh")
   static int viewportOffsetX;
   @ObfuscatedName("uo")
   static int viewportOffsetY;
   @ObfuscatedName("vs")
   public static int field660;
   @ObfuscatedName("tu")
   static boolean playingJingle;
   @ObfuscatedName("wv")
   @ObfuscatedSignature(
      descriptor = "Lbn;"
   )
   static final ApproximateRouteStrategy field412;
   @ObfuscatedName("sx")
   static int destinationX;
   @ObfuscatedName("sr")
   static int destinationY;
   @ObfuscatedName("tc")
   static int soundEffectCount;
   @ObfuscatedName("tl")
   static int[] soundEffectIds;
   @ObfuscatedName("tg")
   static int[] queuedSoundEffectLoops;
   @ObfuscatedName("ws")
   static int[] field666;
   @ObfuscatedName("tj")
   static int[] queuedSoundEffectDelays;
   @ObfuscatedName("wx")
   static int[] field649;
   @ObfuscatedName("ti")
   @ObfuscatedSignature(
           descriptor = "[Lac;"
   )
   static SoundEffect[] soundEffects;
   @ObfuscatedName("tz")
   static boolean isCameraLocked;
   @ObfuscatedName("ts")
   static int[] soundLocations;
   @ObfuscatedName("ul")
   static boolean field631;
   @ObfuscatedName("vu")
   static ArrayList archiveLoaders;
   @ObfuscatedName("wd")
   static int archiveLoadersDone;
   @ObfuscatedName("uf")
   static boolean[] cameraShaking;
   @ObfuscatedName("va")
   static int field651;
   @ObfuscatedName("vn")
   @ObfuscatedSignature(
           descriptor = "Lka;"
   )
   static PlayerComposition playerAppearance;
   @ObfuscatedName("vw")
   static int field652;
   @ObfuscatedName("vh")
   @ObfuscatedSignature(
           descriptor = "Lqm;"
   )
   static PlatformInfoProvider platformInfoProvider;
   @ObfuscatedName("vo")
   @ObfuscatedSignature(
           descriptor = "[Lmi;"
   )
   static GrandExchangeOffer[] grandExchangeOffers;
   @ObfuscatedName("tm")
   static int minimapState;
   @ObfuscatedName("vj")
   @ObfuscatedSignature(
           descriptor = "Lja;"
   )
   static EvictingDualNodeHashTable Widget_cachedModels;
   @ObfuscatedName("vy")
   @ObfuscatedSignature(
           descriptor = "Lja;"
   )
   static EvictingDualNodeHashTable Widget_cachedFonts;
   @ObfuscatedName("sq")
   static int field614;
   @ObfuscatedName("sw")
   @ObfuscatedSignature(
           descriptor = "[Lfm;"
   )
   static ClanChannel[] currentClanChannels;
   @ObfuscatedName("vd")
   @ObfuscatedSignature(
           descriptor = "Lok;"
   )
   static class391 archive5;
   @ObfuscatedName("us")
   static short field637;
   @ObfuscatedName("uv")
   static short field638;
   @ObfuscatedName("ut")
   static short field643;
   @ObfuscatedName("uj")
   static short field644;
   @ObfuscatedName("ua")
   static short field642;
   @ObfuscatedName("tb")
   static int currentTrackGroupId;
   @ObfuscatedName("um")
   static int viewportZoom;
   @ObfuscatedName("uw")
   static short field627;
   @ObfuscatedName("ug")
   static int viewportWidth;
   @ObfuscatedName("sc")
   static int mapIconCount;
   @ObfuscatedName("uk")
   static int viewportHeight;
   @ObfuscatedName("sb")
   static int[] mapIconXs;
   @ObfuscatedName("sn")
   static int[] mapIconYs;
   @ObfuscatedName("wy")
   static int field664;
   @ObfuscatedName("su")
   @ObfuscatedSignature(
           descriptor = "[Lrs;"
   )
   static SpritePixels[] mapIcons;
   @ObfuscatedName("ud")
   static short zoomHeight;
   @ObfuscatedName("up")
   static short zoomWidth;
   @ObfuscatedName("uz")
   static int[] cameraMoveIntensity;
   @ObfuscatedName("uc")
   static int[] cameraShakeIntensity;
   @ObfuscatedName("ub")
   static int[] cameraShakeSpeed;
   @ObfuscatedName("ue")
   static int[] cameraShakeCycle;
   @ObfuscatedName("vk")
   @ObfuscatedSignature(
           descriptor = "Lbi;"
   )
   static GrandExchangeOfferOwnWorldComparator GrandExchangeEvents_worldComparator;
   @ObfuscatedName("ve")
   static int field641;
   @ObfuscatedName("vb")
   static List field661;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
           descriptor = "[Lgv;"
   )
   static CollisionMap[] collisionMaps;
   @ObfuscatedName("bj")
   static boolean lockMouseRecorder = true;
   @ObfuscatedName("bf")
   public static int worldId = 1;
   @ObfuscatedName("bz")
   static int worldProperties = 0;
   @ObfuscatedName("bm")
   static int gameBuild = 0;
   @ObfuscatedName("bl")
   public static boolean isMembersWorld = false;
   @ObfuscatedName("bq")
   static boolean isLowDetail = false;
   @ObfuscatedName("bd")
   static int param21 = -1;
   @ObfuscatedName("bg")
   static int clientType = -1;
   @ObfuscatedName("bb")
   static int field372 = -1;
   @ObfuscatedName("bk")
   static boolean onMobile = false;
   @ObfuscatedName("bs")
   public static int param25 = 211;
   @ObfuscatedName("cp")
   static int gameState = 0;
   @ObfuscatedName("dz")
   static boolean isLoading = true;
   @ObfuscatedName("db")
   static int cycle = 0;
   @ObfuscatedName("di")
   static long mouseLastLastPressedTimeMillis = -1L;
   @ObfuscatedName("dg")
   static int lastMouseRecordX = -1;
   @ObfuscatedName("dm")
   static int lastMouseRecordY = -1;
   @ObfuscatedName("dn")
   static long lastMouseRecordTime = -1L;
   @ObfuscatedName("df")
   static boolean hadFocus = true;
   @ObfuscatedName("dv")
   static int rebootTimer = 0;
   @ObfuscatedName("dr")
   static int hintArrowType = 0;
   @ObfuscatedName("do")
   static int hintArrowNpcIndex = 0;
   @ObfuscatedName("dt")
   static int hintArrowPlayerIndex = 0;
   @ObfuscatedName("dl")
   static int hintArrowX = 0;
   @ObfuscatedName("dh")
   static int hintArrowY = 0;
   @ObfuscatedName("dd")
   static int hintArrowHeight = 0;
   @ObfuscatedName("dp")
   static int hintArrowSubX = 0;
   @ObfuscatedName("ds")
   static int hintArrowSubY = 0;
   @ObfuscatedName("de")
   @ObfuscatedSignature(
           descriptor = "Lco;"
   )
   static AttackOption playerAttackOption;
   @ObfuscatedName("du")
   @ObfuscatedSignature(
           descriptor = "Lco;"
   )
   static AttackOption npcAttackOption;
   @ObfuscatedName("eq")
   static int titleLoadingStage;
   @ObfuscatedName("ew")
   static int js5ConnectState;
   @ObfuscatedName("ej")
   static int js5Cycles;
   @ObfuscatedName("fu")
   static int js5Errors;
   @ObfuscatedName("fk")
   static int loginState;
   @ObfuscatedName("fd")
   static int field400;
   @ObfuscatedName("fs")
   static int field401;
   @ObfuscatedName("fg")
   static int field514;
   @ObfuscatedName("fq")
   @ObfuscatedSignature(
      descriptor = "Leq;"
   )
   static class135 field403;
   @ObfuscatedName("fj")
   @ObfuscatedSignature(
      descriptor = "Lro;"
   )
   static class478 field404;
   @ObfuscatedName("gd")
   static final String field414;
   @ObfuscatedName("gg")
   static String field669;
   @ObfuscatedName("ge")
   static boolean Login_isUsernameRemembered;
   @ObfuscatedName("gm")
   @ObfuscatedSignature(
           descriptor = "Lbc;"
   )
   static SecureRandomFuture secureRandomFuture;
   @ObfuscatedName("hf")
   static byte[] randomDatData;
   @ObfuscatedName("hv")
   @ObfuscatedSignature(
           descriptor = "[Lcf;"
   )
   static NPC[] npcs;
   @ObfuscatedName("hm")
   static int npcCount;
   @ObfuscatedName("hy")
   static int[] npcIndices;
   @ObfuscatedName("hr")
   static int field425;
   @ObfuscatedName("hk")
   static int[] field426;
   @ObfuscatedName("hl")
   @ObfuscatedSignature(
           descriptor = "Ldb;"
   )
   public static final PacketWriter packetWriter;
   @ObfuscatedName("hb")
   static int logoutTimer;
   @ObfuscatedName("hw")
   static boolean hadNetworkError;
   @ObfuscatedName("hx")
   @ObfuscatedSignature(
           descriptor = "Lns;"
   )
   static Timer timer;
   @ObfuscatedName("hc")
   static HashMap fontsMap;
   @ObfuscatedName("ij")
   static int baseY;
   @ObfuscatedName("ip")
   static int field433;
   @ObfuscatedName("iw")
   static int field434;
   @ObfuscatedName("ii")
   static int field435;
   @ObfuscatedName("id")
   static int field436;
   @ObfuscatedName("ic")
   static int field609;
   @ObfuscatedName("it")
   static String selectedItemName;
   @ObfuscatedName("ik")
   static boolean isInInstance;
   @ObfuscatedName("iy")
   static int[][][] instanceChunkTemplates;
   @ObfuscatedName("il")
   static final int[] OBJECT_TYPE_TO_STUB_TYPE;
   @ObfuscatedName("if")
   static int field442;
   @ObfuscatedName("jb")
   static int field443;
   @ObfuscatedName("jp")
   static int field444;
   @ObfuscatedName("jh")
   static int field524;
   @ObfuscatedName("ja")
   static int field504;
   @ObfuscatedName("jc")
   static boolean field549;
   @ObfuscatedName("jr")
   static int alternativeScrollbarWidth;
   @ObfuscatedName("jg")
   static int camAngleX;
   @ObfuscatedName("jw")
   static int camAngleY;
   @ObfuscatedName("jx")
   static int camAngleDY;
   @ObfuscatedName("jk")
   static int camAngleDX;
   @ObfuscatedName("ki")
   static int mouseCamClickedX;
   @ObfuscatedName("ku")
   static int mouseCamClickedY;
   @ObfuscatedName("kf")
   static int oculusOrbState;
   @ObfuscatedName("kq")
   static int camFollowHeight;
   @ObfuscatedName("kk")
   static int field457;
   @ObfuscatedName("kt")
   static int field458;
   @ObfuscatedName("kd")
   static int field399;
   @ObfuscatedName("kx")
   static int oculusOrbNormalSpeed;
   @ObfuscatedName("kb")
   static int oculusOrbSlowedSpeed;
   @ObfuscatedName("ke")
   static int field462;
   @ObfuscatedName("ko")
   static boolean oculusOrbOnLocalPlayer;
   @ObfuscatedName("km")
   static int packetIndicator;
   @ObfuscatedName("kr")
   static boolean emitPackets;
   @ObfuscatedName("kc")
   static int field466;
   @ObfuscatedName("kn")
   static int overheadTextCount;
   @ObfuscatedName("kl")
   static int overheadTextLimit;
   @ObfuscatedName("ka")
   static int[] overheadTextXs;
   @ObfuscatedName("kp")
   static int[] overheadTextYs;
   @ObfuscatedName("kh")
   static int[] overheadTextAscents;
   @ObfuscatedName("kz")
   static int[] overheadTextXOffsets;
   @ObfuscatedName("kw")
   static int[] overheadTextColors;
   @ObfuscatedName("kg")
   static int[] overheadTextEffects;
   @ObfuscatedName("lj")
   static int[] overheadTextCyclesRemaining;
   @ObfuscatedName("lh")
   static String[] overheadText;
   @ObfuscatedName("lc")
   static int[][] tileLastDrawnActor;
   @ObfuscatedName("lw")
   static int viewportDrawCount;
   @ObfuscatedName("lk")
   static int viewportTempX;
   @ObfuscatedName("ly")
   static int viewportTempY;
   @ObfuscatedName("lf")
   static int mouseCrossX;
   @ObfuscatedName("ls")
   static int mouseCrossY;
   @ObfuscatedName("lg")
   static int mouseCrossState;
   @ObfuscatedName("lb")
   static int mouseCrossColor;
   @ObfuscatedName("lz")
   static boolean showMouseCross;
   @ObfuscatedName("lp")
   static int field608;
   @ObfuscatedName("le")
   static int field487;
   @ObfuscatedName("lt")
   static int dragItemSlotSource;
   @ObfuscatedName("lq")
   static int draggedWidgetX;
   @ObfuscatedName("lo")
   static int draggedWidgetY;
   @ObfuscatedName("lu")
   static int dragItemSlotDestination;
   @ObfuscatedName("lx")
   static boolean field492;
   @ObfuscatedName("li")
   static int itemDragDuration;
   @ObfuscatedName("lm")
   static int field494;
   @ObfuscatedName("ln")
   static boolean showLoadingMessages;
   @ObfuscatedName("mk")
   @ObfuscatedSignature(
           descriptor = "[Lcl;"
   )
   static Player[] players;
   @ObfuscatedName("mp")
   static int localPlayerIndex;
   @ObfuscatedName("ma")
   static int isMembers;
   @ObfuscatedName("mg")
   static long playerUUID;
   @ObfuscatedName("mv")
   static boolean renderSelf;
   @ObfuscatedName("mb")
   static int drawPlayerNames;
   @ObfuscatedName("mq")
   static int field502;
   @ObfuscatedName("mn")
   static int[] field503;
   @ObfuscatedName("ms")
   static final int[] playerMenuOpcodes;
   @ObfuscatedName("my")
   static String[] playerMenuActions;
   @ObfuscatedName("mo")
   static boolean[] playerOptionsPriorities;
   @ObfuscatedName("mf")
   static int[] defaultRotations;
   @ObfuscatedName("mt")
   static int combatTargetPlayerIndex;
   @ObfuscatedName("me")
   @ObfuscatedSignature(
           descriptor = "[[[Lmo;"
   )
   static NodeDeque[][][] groundItems;
   @ObfuscatedName("mj")
   @ObfuscatedSignature(
           descriptor = "Lmo;"
   )
   static NodeDeque pendingSpawns;
   @ObfuscatedName("mc")
   @ObfuscatedSignature(
           descriptor = "Lmo;"
   )
   static NodeDeque projectiles;
   @ObfuscatedName("mz")
   @ObfuscatedSignature(
           descriptor = "Lmo;"
   )
   static NodeDeque graphicsObjects;
   @ObfuscatedName("mh")
   static int[] currentLevels;
   @ObfuscatedName("mr")
   static int[] levels;
   @ObfuscatedName("nc")
   static int[] experience;
   @ObfuscatedName("ni")
   static boolean leftClickOpensMenu;
   @ObfuscatedName("ne")
   static boolean isMenuOpen;
   @ObfuscatedName("np")
   static int menuOptionsCount;
   @ObfuscatedName("nu")
   static int[] menuArguments1;
   @ObfuscatedName("nq")
   static int[] menuArguments2;
   @ObfuscatedName("nw")
   static int[] menuOpcodes;
   @ObfuscatedName("nm")
   static int[] menuIdentifiers;
   @ObfuscatedName("nn")
   static int[] menuItemIds;
   @ObfuscatedName("na")
   static String[] menuActions;
   @ObfuscatedName("no")
   static String[] menuTargets;
   @ObfuscatedName("ny")
   static boolean[] menuShiftClick;
   @ObfuscatedName("ns")
   static boolean followerOpsLowPriority;
   @ObfuscatedName("nt")
   static boolean shiftClickDrop;
   @ObfuscatedName("nj")
   static boolean tapToDrop;
   @ObfuscatedName("nz")
   static boolean showMouseOverText;
   @ObfuscatedName("nb")
   static int viewportX;
   @ObfuscatedName("nx")
   static int viewportY;
   @ObfuscatedName("ok")
   static int field533;
   @ObfuscatedName("oh")
   static int field534;
   @ObfuscatedName("om")
   static int isItemSelected;
   @ObfuscatedName("oe")
   static boolean isSpellSelected;
   @ObfuscatedName("ol")
   static int selectedSpellChildIndex;
   @ObfuscatedName("oo")
   static int selectedSpellItemId;
   @ObfuscatedName("ow")
   static String selectedSpellActionName;
   @ObfuscatedName("ou")
   static String selectedSpellName;
   @ObfuscatedName("ob")
   static int rootInterface;
   @ObfuscatedName("oz")
   @ObfuscatedSignature(
           descriptor = "Lqg;"
   )
   static NodeHashTable interfaceParents;
   @ObfuscatedName("ox")
   static int field662;
   @ObfuscatedName("os")
   static int field545;
   @ObfuscatedName("oi")
   static int chatEffects;
   @ObfuscatedName("of")
   static int field547;
   @ObfuscatedName("or")
   @ObfuscatedSignature(
           descriptor = "Lkz;"
   )
   static Widget meslayerContinueWidget;
   @ObfuscatedName("oj")
   static int runEnergy;
   @ObfuscatedName("op")
   static int weight;
   @ObfuscatedName("oy")
   public static int staffModLevel;
   @ObfuscatedName("pl")
   static int followerIndex;
   @ObfuscatedName("pb")
   static boolean playerMod;
   @ObfuscatedName("pn")
   @ObfuscatedSignature(
           descriptor = "Lkz;"
   )
   static Widget viewportWidget;
   @ObfuscatedName("pv")
   @ObfuscatedSignature(
           descriptor = "Lkz;"
   )
   public static Widget clickedWidget;
   @ObfuscatedName("px")
   @ObfuscatedSignature(
           descriptor = "Lkz;"
   )
   static Widget clickedWidgetParent;
   @ObfuscatedName("pq")
   static int widgetClickX;
   @ObfuscatedName("po")
   static int widgetClickY;
   @ObfuscatedName("pp")
   @ObfuscatedSignature(
           descriptor = "Lkz;"
   )
   static Widget draggedOnWidget;
   @ObfuscatedName("pj")
   static boolean field560;
   @ObfuscatedName("pk")
   static int field659;
   @ObfuscatedName("pe")
   static int field667;
   @ObfuscatedName("pf")
   static boolean field563;
   @ObfuscatedName("pm")
   static int field601;
   @ObfuscatedName("ps")
   static int field422;
   @ObfuscatedName("pt")
   static boolean isDraggingWidget;
   @ObfuscatedName("py")
   static int cycleCntr;
   @ObfuscatedName("pg")
   static int[] changedVarps;
   @ObfuscatedName("pr")
   static int changedVarpCount;
   @ObfuscatedName("pc")
   static int[] changedItemContainers;
   @ObfuscatedName("pu")
   static int changedItemContainersCount;
   @ObfuscatedName("qm")
   static int[] changedSkills;
   @ObfuscatedName("qz")
   static int changedSkillsCount;
   @ObfuscatedName("qf")
   static int[] field574;
   @ObfuscatedName("qq")
   static int field566;
   @ObfuscatedName("qy")
   static int chatCycle;
   @ObfuscatedName("qd")
   static int field577;
   @ObfuscatedName("qi")
   static int field505;
   @ObfuscatedName("qu")
   static int field562;
   @ObfuscatedName("qg")
   static int field561;
   @ObfuscatedName("qs")
   static int field580;
   @ObfuscatedName("qe")
   static int field668;
   @ObfuscatedName("qj")
   static int field625;
   @ObfuscatedName("qk")
   static int mouseWheelRotation;
   @ObfuscatedName("qx")
   @ObfuscatedSignature(
      descriptor = "Lrj;"
   )
   static class491 field583;
   @ObfuscatedName("qw")
   @ObfuscatedSignature(
           descriptor = "Lmo;"
   )
   static NodeDeque scriptEvents;
   @ObfuscatedName("ql")
   @ObfuscatedSignature(
      descriptor = "Lmo;"
   )
   static NodeDeque field632;
   @ObfuscatedName("qn")
   @ObfuscatedSignature(
      descriptor = "Lmo;"
   )
   static NodeDeque field586;
   @ObfuscatedName("qv")
   @ObfuscatedSignature(
      descriptor = "Lmo;"
   )
   static NodeDeque field587;
   @ObfuscatedName("qo")
   @ObfuscatedSignature(
           descriptor = "Lqg;"
   )
   static NodeHashTable widgetFlags;
   @ObfuscatedName("qc")
   static int rootWidgetCount;
   @ObfuscatedName("rn")
   static int field590;
   @ObfuscatedName("rr")
   static boolean[] field591;
   @ObfuscatedName("rf")
   static boolean[] field546;
   @ObfuscatedName("rl")
   static boolean[] field428;
   @ObfuscatedName("ru")
   static int[] rootWidgetXs;
   @ObfuscatedName("rd")
   static int[] rootWidgetYs;
   @ObfuscatedName("rx")
   static int[] rootWidgetWidths;
   @ObfuscatedName("ri")
   static int[] rootWidgetHeights;
   @ObfuscatedName("rb")
   static int gameDrawingMode;
   @ObfuscatedName("rz")
   static long field599;
   @ObfuscatedName("ro")
   static boolean isResizable;
   @ObfuscatedName("re")
   static int[] field622;
   @ObfuscatedName("rg")
   static int publicChatMode;
   @ObfuscatedName("rk")
   static int tradeChatMode;
   @ObfuscatedName("rw")
   static String field604;
   @ObfuscatedName("rj")
   static long[] crossWorldMessageIds;
   @ObfuscatedName("ra")
   static int crossWorldMessageIdsIndex;
   @ObfuscatedName("rp")
   @ObfuscatedSignature(
           descriptor = "Lgl;"
   )
   public static class205 keyHandlerInstance;
   @ObfuscatedName("sp")
   @ObfuscatedSignature(
      descriptor = "Lgm;"
   )
   static class203 field617;
   @ObfuscatedName("si")
   static int field623;
   @ObfuscatedName("sd")
   static int[] field618;
   @ObfuscatedName("st")
   static int[] field610;
   @ObfuscatedName("sf")
   static long timeOfPreviousKeyPress;
   @ObfuscatedName("gk")
   String field391;
   @ObfuscatedName("ga")
   @ObfuscatedSignature(
      descriptor = "Lt;"
   )
   class14 field406;
   @ObfuscatedName("gf")
   @ObfuscatedSignature(
      descriptor = "Lu;"
   )
   class18 field548;
   @ObfuscatedName("gi")
   OtlTokenRequester field408;
   @ObfuscatedName("gx")
   Future field409;
   @ObfuscatedName("gq")
   boolean field410 = false;
   @ObfuscatedName("gw")
   @ObfuscatedSignature(
      descriptor = "Lu;"
   )
   class18 field411;
   @ObfuscatedName("gj")
   @ObfuscatedSignature(
      descriptor = "Lcom/jagex/oldscape/pub/RefreshAccessTokenRequester;"
   )
   RefreshAccessTokenRequester field481;
   @ObfuscatedName("go")
   Future field648;
   @ObfuscatedName("gv")
   @ObfuscatedSignature(
      descriptor = "Lrd;"
   )
   Buffer field418;
   @ObfuscatedName("gt")
   @ObfuscatedSignature(
      descriptor = "Ln;"
   )
   class7 field419;
   @ObfuscatedName("hz")
   long accountHash = -1L;

   static {
      playerAttackOption = AttackOption.AttackOption_hidden;
      npcAttackOption = AttackOption.AttackOption_hidden;
      titleLoadingStage = 0;
      js5ConnectState = 0;
      js5Cycles = 0;
      js5Errors = 0;
      loginState = 0;
      field400 = 0;
      field401 = 0;
      field514 = 0;
      field403 = class135.field1284;
      field404 = class478.field4053;
      byte[] var1 = NetCache.method1839("com_jagex_auth_desktop_osrs:public");
      int var3 = var1.length;
      StringBuilder var4 = new StringBuilder();

      for(int var5 = 0; var5 < var3 + 0; var5 += 3) {
         int var6 = var1[var5] & 255;
         var4.append(class363.field3571[var6 >>> 2]);
         if (var5 < var3 - 1) {
            int var7 = var1[var5 + 1] & 255;
            var4.append(class363.field3571[(var6 & 3) << 4 | var7 >>> 4]);
            if (var5 < var3 - 2) {
               int var8 = var1[var5 + 2] & 255;
               var4.append(class363.field3571[(var7 & 15) << 2 | var8 >>> 6]).append(class363.field3571[var8 & 63]);
            } else {
               var4.append(class363.field3571[(var7 & 15) << 2]).append("=");
            }
         } else {
            var4.append(class363.field3571[(var6 & 3) << 4]).append("==");
         }
      }

      String var2 = var4.toString();
      field414 = var2;
      Login_isUsernameRemembered = false;
      secureRandomFuture = new SecureRandomFuture();
      randomDatData = null;
      npcs = new NPC[65536];
      npcCount = 0;
      npcIndices = new int[65536];
      field425 = 0;
      field426 = new int[250];
      packetWriter = new PacketWriter();
      logoutTimer = 0;
      hadNetworkError = false;
      timer = new Timer();
      fontsMap = new HashMap();
      field433 = 0;
      field434 = 1;
      field435 = 0;
      field436 = 1;
      field609 = 0;
      collisionMaps = new CollisionMap[4];
      isInInstance = false;
      instanceChunkTemplates = new int[4][13][13];
      OBJECT_TYPE_TO_STUB_TYPE = new int[]{0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3};
      field442 = 0;
      field443 = 2301979;
      field444 = 5063219;
      field524 = 3353893;
      field504 = 7759444;
      field549 = false;
      alternativeScrollbarWidth = 0;
      camAngleX = 128;
      camAngleY = 0;
      camAngleDY = 0;
      camAngleDX = 0;
      mouseCamClickedX = 0;
      mouseCamClickedY = 0;
      oculusOrbState = 0;
      camFollowHeight = 50;
      field457 = 0;
      field458 = 0;
      field399 = 0;
      oculusOrbNormalSpeed = 12;
      oculusOrbSlowedSpeed = 6;
      field462 = 0;
      oculusOrbOnLocalPlayer = false;
      packetIndicator = 0;
      emitPackets = false;
      field466 = 0;
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
      field608 = 0;
      field487 = 0;
      dragItemSlotSource = 0;
      draggedWidgetX = 0;
      draggedWidgetY = 0;
      dragItemSlotDestination = 0;
      field492 = false;
      itemDragDuration = 0;
      field494 = 0;
      showLoadingMessages = true;
      players = new Player[2048];
      localPlayerIndex = -1;
      isMembers = 0;
      playerUUID = -1L;
      renderSelf = true;
      drawPlayerNames = 0;
      field502 = 0;
      field503 = new int[1000];
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
      field533 = 0;
      field534 = 50;
      isItemSelected = 0;
      selectedItemName = null;
      isSpellSelected = false;
      selectedSpellChildIndex = -1;
      selectedSpellItemId = -1;
      selectedSpellActionName = null;
      selectedSpellName = null;
      rootInterface = -1;
      interfaceParents = new NodeHashTable(8);
      field662 = 0;
      field545 = -1;
      chatEffects = 0;
      field547 = 0;
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
      field560 = false;
      field659 = -1;
      field667 = -1;
      field563 = false;
      field601 = -1;
      field422 = -1;
      isDraggingWidget = false;
      cycleCntr = 1;
      changedVarps = new int[32];
      changedVarpCount = 0;
      changedItemContainers = new int[32];
      changedItemContainersCount = 0;
      changedSkills = new int[32];
      changedSkillsCount = 0;
      field574 = new int[32];
      field566 = 0;
      chatCycle = 0;
      field577 = 0;
      field505 = 0;
      field562 = 0;
      field561 = 0;
      field580 = 0;
      field668 = 0;
      field625 = 0;
      mouseWheelRotation = 0;
      field583 = new class491();
      scriptEvents = new NodeDeque();
      field632 = new NodeDeque();
      field586 = new NodeDeque();
      field587 = new NodeDeque();
      widgetFlags = new NodeHashTable(512);
      rootWidgetCount = 0;
      field590 = -2;
      field591 = new boolean[100];
      field546 = new boolean[100];
      field428 = new boolean[100];
      rootWidgetXs = new int[100];
      rootWidgetYs = new int[100];
      rootWidgetWidths = new int[100];
      rootWidgetHeights = new int[100];
      gameDrawingMode = 0;
      field599 = 0L;
      isResizable = true;
      field622 = new int[]{16776960, 16711680, 65280, 65535, 16711935, 16777215};
      publicChatMode = 0;
      tradeChatMode = 0;
      field604 = "";
      crossWorldMessageIds = new long[100];
      crossWorldMessageIdsIndex = 0;
      keyHandlerInstance = new class205();
      field617 = new class203();
      field623 = 0;
      field618 = new int[128];
      field610 = new int[128];
      timeOfPreviousKeyPress = -1L;
      currentClanSettings = new ClanSettings[4];
      currentClanChannels = new ClanChannel[4];
      field614 = -1;
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
      field631 = false;
      cameraShaking = new boolean[5];
      cameraShakeIntensity = new int[5];
      cameraMoveIntensity = new int[5];
      cameraShakeSpeed = new int[5];
      cameraShakeCycle = new int[5];
      field637 = 256;
      field638 = 205;
      zoomHeight = 256;
      zoomWidth = 320;
      field627 = 1;
      field642 = 32767;
      field643 = 1;
      field644 = 32767;
      viewportOffsetX = 0;
      viewportOffsetY = 0;
      viewportWidth = 0;
      viewportHeight = 0;
      viewportZoom = 0;
      playerAppearance = new PlayerComposition();
      field651 = -1;
      field652 = -1;
      platformInfoProvider = new DesktopPlatformInfoProvider();
      grandExchangeOffers = new GrandExchangeOffer[8];
      GrandExchangeEvents_worldComparator = new GrandExchangeOfferOwnWorldComparator();
      archive5 = new class391(8, class389.field3670);
      Widget_cachedModels = new EvictingDualNodeHashTable(64);
      Widget_cachedFonts = new EvictingDualNodeHashTable(64);
      field641 = -1;
      field660 = -1;
      field661 = new ArrayList();
      archiveLoaders = new ArrayList(10);
      archiveLoadersDone = 0;
      field664 = 0;
      field412 = new ApproximateRouteStrategy();
      field666 = new int[50];
      field649 = new int[50];
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
           descriptor = "(I)V",
           garbageValue = "-1977939270"
   )
   protected final void resizeGame() {
      field599 = class153.clockNow() + 500L;
      this.resizeJS();
      if (rootInterface != -1) {
         this.resizeRoot(true);
      }

   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
           descriptor = "(I)V",
           garbageValue = "1082760075"
   )
   protected final void setUp() {
      int[] var1 = new int[]{20, 260, 10000};
      int[] var2 = new int[]{1000, 100, 500};
      if (var1 != null && var2 != null) {
         class172.ByteArrayPool_alternativeSizes = var1;
         class132.ByteArrayPool_altSizeArrayCounts = new int[var1.length];
         class9.ByteArrayPool_arrays = new byte[var1.length][][];

         for(int var3 = 0; var3 < class172.ByteArrayPool_alternativeSizes.length; ++var3) {
            class9.ByteArrayPool_arrays[var3] = new byte[var2[var3]][];
            ByteArrayPool.field3635.add(var1[var3]);
         }

         Collections.sort(ByteArrayPool.field3635);
      } else {
         class172.ByteArrayPool_alternativeSizes = null;
         class132.ByteArrayPool_altSizeArrayCounts = null;
         class9.ByteArrayPool_arrays = null;
         class36.method169();
      }

      class1.worldPort = gameBuild == 0 ? 'ꩊ' : worldId + '鱀';
      class10.js5Port = gameBuild == 0 ? 443 : worldId + '썐';
      Calendar.currentPort = class1.worldPort;
      class384.field3658 = class308.field2844;
      UserComparator8.field1152 = class308.field2845;
      ItemLayer.field1866 = class308.field2846;
      Varcs.field1116 = class308.field2847;
      class245.urlRequester = new class108(this.field410, 211);
      this.setUpKeyboard();
      this.method143();
      class326.mouseWheel = this.mouseWheel();
      this.method142(field617, 0);
      this.method142(keyHandlerInstance, 1);
      class12.masterDisk = new ArchiveDisk(255, JagexCache.JagexCache_dat2File, JagexCache.JagexCache_idx255File, 500000);
      PacketWriter.clientPreferences = class138.method746();
      this.setUpClipboard();
      Occluder.method1251(this, FriendsList.field3687);
      class160.setWindowedMode(PacketWriter.clientPreferences.method536());
      WorldMapElement.friendSystem = new FriendSystem(WorldMapCacheName.loginType);
      this.field406 = new class14("tokenRequest", 1, 1);
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
           descriptor = "(I)V",
           garbageValue = "-1127205702"
   )
   protected final void doCycle() {
      ++cycle;
      this.doCycleJs5();
      WorldMapIcon_0.method1425();

      int var1;
      try {
         if (class290.musicPlayerStatus == 1) {
            var1 = class290.midiPcmStream.method1556();
            if (var1 > 0 && class290.midiPcmStream.isReady()) {
               var1 -= class203.pcmSampleLength;
               if (var1 < 0) {
                  var1 = 0;
               }

               class290.midiPcmStream.setPcmStreamVolume(var1);
            } else {
               class290.midiPcmStream.clear();
               class290.midiPcmStream.removeAll();
               if (class6.musicTrackArchive != null) {
                  class290.musicPlayerStatus = 2;
               } else {
                  class290.musicPlayerStatus = 0;
               }

               class427.musicTrack = null;
               class154.soundCache = null;
            }
         }
      } catch (Exception var3) {
         var3.printStackTrace();
         class290.midiPcmStream.clear();
         class290.musicPlayerStatus = 0;
         class427.musicTrack = null;
         class154.soundCache = null;
         class6.musicTrackArchive = null;
      }

      HorizontalAlignment.playPcmPlayers();
      keyHandlerInstance.method1084();
      this.method152();
      class9.method36();
      if (class326.mouseWheel != null) {
         var1 = class326.mouseWheel.useRotation();
         mouseWheelRotation = var1;
      }

      if (gameState == 0) {
         class366.load();
         class204.method1075();
      } else if (gameState == 5) {
         PacketWriter.loginScreen(this, MenuAction.fontPlain12);
         class366.load();
         class204.method1075();
      } else if (gameState != 10 && gameState != 11) {
         if (gameState == 20) {
            PacketWriter.loginScreen(this, MenuAction.fontPlain12);
            this.doCycleLoggedOut();
         } else if (gameState == 50) {
            PacketWriter.loginScreen(this, MenuAction.fontPlain12);
            this.doCycleLoggedOut();
         } else if (gameState == 25) {
            class361.method1923();
         }
      } else {
         PacketWriter.loginScreen(this, MenuAction.fontPlain12);
      }

      if (gameState == 30) {
         this.doCycleLoggedIn();
      } else if (gameState == 40 || gameState == 45) {
         this.doCycleLoggedOut();
      }

   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
           descriptor = "(ZI)V",
           garbageValue = "1484603297"
   )
   protected final void draw(boolean var1) {
      boolean var2;
      label170: {
         try {
            if (class290.musicPlayerStatus == 2) {
               if (class427.musicTrack == null) {
                  class427.musicTrack = MusicTrack.readTrack(class6.musicTrackArchive, class20.musicTrackGroupId, class161.musicTrackFileId);
                  if (class427.musicTrack == null) {
                     var2 = false;
                     break label170;
                  }
               }

               if (class154.soundCache == null) {
                  class154.soundCache = new SoundCache(class290.soundEffectsArchive, class290.musicSamplesArchive);
               }

               if (class290.midiPcmStream.loadMusicTrack(class427.musicTrack, class290.musicPatchesArchive, class154.soundCache, 22050)) {
                  class290.midiPcmStream.clearAll();
                  class290.midiPcmStream.setPcmStreamVolume(class290.musicTrackVolume);
                  class290.midiPcmStream.setMusicTrack(class427.musicTrack, class423.musicTrackBoolean);
                  class290.musicPlayerStatus = 0;
                  class427.musicTrack = null;
                  class154.soundCache = null;
                  class6.musicTrackArchive = null;
                  var2 = true;
                  break label170;
               }
            }
         } catch (Exception var6) {
            var6.printStackTrace();
            class290.midiPcmStream.clear();
            class290.musicPlayerStatus = 0;
            class427.musicTrack = null;
            class154.soundCache = null;
            class6.musicTrackArchive = null;
         }

         var2 = false;
      }

      if (var2 && playingJingle && SoundSystem.pcmPlayer0 != null) {
         SoundSystem.pcmPlayer0.tryDiscard();
      }

      if ((gameState == 10 || gameState == 20 || gameState == 30) && field599 != 0L && class153.clockNow() > field599) {
         class160.setWindowedMode(Message.getWindowedMode());
      }

      int var4;
      if (var1) {
         for(var4 = 0; var4 < 100; ++var4) {
            field591[var4] = true;
         }
      }

      if (gameState == 0) {
         this.drawInitial(Login.Login_loadingPercent, Login.Login_loadingText, var1);
      } else if (gameState == 5) {
         GrandExchangeOfferAgeComparator.drawTitle(class19.fontBold12, class276.fontPlain11, MenuAction.fontPlain12);
      } else if (gameState != 10 && gameState != 11) {
         if (gameState == 20) {
            GrandExchangeOfferAgeComparator.drawTitle(class19.fontBold12, class276.fontPlain11, MenuAction.fontPlain12);
         } else if (gameState == 50) {
            GrandExchangeOfferAgeComparator.drawTitle(class19.fontBold12, class276.fontPlain11, MenuAction.fontPlain12);
         } else if (gameState == 25) {
            if (field609 == 1) {
               if (field433 > field434) {
                  field434 = field433;
               }

               var4 = (field434 * 50 - field433 * 50) / field434;
               class165.drawLoadingMessage("Loading - please wait." + "<br>" + " (" + var4 + "%" + ")", false);
            } else if (field609 == 2) {
               if (field435 > field436) {
                  field436 = field435;
               }

               var4 = (field436 * 50 - field435 * 50) / field436 + 50;
               class165.drawLoadingMessage("Loading - please wait." + "<br>" + " (" + var4 + "%" + ")", false);
            } else {
               class165.drawLoadingMessage("Loading - please wait.", false);
            }
         } else if (gameState == 30) {
            this.drawLoggedIn();
         } else if (gameState == 40) {
            class165.drawLoadingMessage("Connection lost" + "<br>" + "Please wait - attempting to reestablish", false);
         } else if (gameState == 45) {
            class165.drawLoadingMessage("Please wait...", false);
         }
      } else {
         GrandExchangeOfferAgeComparator.drawTitle(class19.fontBold12, class276.fontPlain11, MenuAction.fontPlain12);
      }

      if (gameState == 30 && gameDrawingMode == 0 && !var1 && !isResizable) {
         for(var4 = 0; var4 < rootWidgetCount; ++var4) {
            if (field546[var4]) {
               KeyHandler.rasterProvider.draw(rootWidgetXs[var4], rootWidgetYs[var4], rootWidgetWidths[var4], rootWidgetHeights[var4]);
               field546[var4] = false;
            }
         }
      } else if (gameState > 0) {
         KeyHandler.rasterProvider.drawFull(0, 0);

         for(var4 = 0; var4 < rootWidgetCount; ++var4) {
            field546[var4] = false;
         }
      }

   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
           descriptor = "(I)V",
           garbageValue = "1860938943"
   )
   protected final void kill0() {
      if (class9.varcs.hasUnwrittenChanges()) {
         class9.varcs.write();
      }

      if (class36.mouseRecorder != null) {
         class36.mouseRecorder.isRunning = false;
      }

      class36.mouseRecorder = null;
      packetWriter.close();
      if (MouseHandler.MouseHandler_instance != null) {
         MouseHandler var1 = MouseHandler.MouseHandler_instance;
         synchronized(MouseHandler.MouseHandler_instance) {
            MouseHandler.MouseHandler_instance = null;
         }
      }

      class326.mouseWheel = null;
      if (SoundSystem.pcmPlayer0 != null) {
         SoundSystem.pcmPlayer0.shutdown();
      }

      if (WorldMapSectionType.pcmPlayer1 != null) {
         WorldMapSectionType.pcmPlayer1.shutdown();
      }

      CollisionMap.method1103();
      Object var7 = ArchiveDiskActionHandler.ArchiveDiskActionHandler_lock;
      synchronized(ArchiveDiskActionHandler.ArchiveDiskActionHandler_lock) {
         if (ArchiveDiskActionHandler.field3437 != 0) {
            ArchiveDiskActionHandler.field3437 = 1;

            try {
               ArchiveDiskActionHandler.ArchiveDiskActionHandler_lock.wait();
            } catch (InterruptedException var4) {
               ;
            }
         }
      }

      if (class245.urlRequester != null) {
         class245.urlRequester.close();
         class245.urlRequester = null;
      }

      Huffman.method1764();
      this.field406.method54();
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
           descriptor = "(I)V",
           garbageValue = "1991813544"
   )
   protected final void vmethod1485() {
   }

   @ObfuscatedName("fx")
   @ObfuscatedSignature(
      descriptor = "(I)Z",
      garbageValue = "1921365209"
   )
   boolean method369() {
      return Frames.field2059 != null && !Frames.field2059.trim().isEmpty() && class152.field1373 != null && !class152.field1373.trim().isEmpty();
   }

   @ObfuscatedName("fh")
   @ObfuscatedSignature(
      descriptor = "(I)Z",
      garbageValue = "-2126073648"
   )
   boolean method343() {
      return MusicPatchNode.field2783 != null && !MusicPatchNode.field2783.trim().isEmpty() && VarcInt.field1501 != null && !VarcInt.field1501.trim().isEmpty();
   }

   @ObfuscatedName("fm")
   @ObfuscatedSignature(
      descriptor = "(S)Z",
      garbageValue = "167"
   )
   boolean method344() {
      return this.field408 != null;
   }

   @ObfuscatedName("fe")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;I)V",
      garbageValue = "1761087263"
   )
   void method345(String var1) throws IOException {
      HashMap var2 = new HashMap();
      var2.put("grant_type", "refresh_token");
      var2.put("scope", "gamesso.token.create");
      var2.put("refresh_token", var1);
      URL var3 = new URL(field669 + "shield/oauth/token" + (new class430(var2)).method2214());
      class387 var4 = new class387();
      var4.method2041(field414);
      var4.method2044("Host", (new URL(field669)).getHost());
      var4.method2037(class427.field3808);
      class9 var5 = class9.field19;
      RefreshAccessTokenRequester var6 = this.field481;
      if (var6 != null) {
         this.field648 = var6.request(var5.method31(), var3, var4.method2033(), "");
      } else {
         class10 var7 = new class10(var3, var5, var4, this.field410);
         this.field411 = this.field406.method55(var7);
      }
   }

   @ObfuscatedName("fl")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;I)V",
      garbageValue = "2143605223"
   )
   void method364(String var1) throws IOException {
      URL var2 = new URL(field669 + "public/v1/games/YCfdbvr2pM1zUYMxJRexZY/play");
      class387 var3 = new class387();
      var3.method2042(var1);
      class9 var4 = class9.field20;
      OtlTokenRequester var5 = this.field408;
      if (var5 != null) {
         this.field409 = var5.request(var4.method31(), var2, var3.method2033(), "");
      } else {
         class10 var6 = new class10(var2, var4, var3, this.field410);
         this.field548 = this.field406.method55(var6);
      }
   }

   @ObfuscatedName("fu")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "-986853622"
   )
   void method342(String var1, String var2) throws IOException, JSONException {
      URL var3 = new URL(field669 + "/game-session/v1/tokens");
      class10 var4 = new class10(var3, class9.field19, this.field410);
      var4.method41().method2042(var1);
      var4.method41().method2037(class427.field3808);
      JSONObject var5 = new JSONObject();
      var5.method2546("accountId", var2);
      var4.method38(new class429(var5));
      this.field548 = this.field406.method55(var4);
   }

   @ObfuscatedName("fk")
   @ObfuscatedSignature(
           descriptor = "(I)V",
           garbageValue = "-1902910944"
   )
   void doCycleJs5() {
      if (gameState != 1000) {
         boolean var1 = class96.method577();
         if (!var1) {
            this.doCycleJs5Connect();
         }

      }
   }

   @ObfuscatedName("fd")
   @ObfuscatedSignature(
           descriptor = "(S)V",
           garbageValue = "3134"
   )
   void doCycleJs5Connect() {
      if (NetCache.NetCache_crcMismatches >= 4) {
         this.error("js5crc");
         class246.updateGameState(1000);
      } else {
         if (NetCache.NetCache_ioExceptions >= 4) {
            if (gameState <= 5) {
               this.error("js5io");
               class246.updateGameState(1000);
               return;
            }

            js5Cycles = 3000;
            NetCache.NetCache_ioExceptions = 3;
         }

         if (--js5Cycles + 1 <= 0) {
            try {
               if (js5ConnectState == 0) {
                  WorldMapManager.js5SocketTask = GameEngine.taskHandler.newSocketTask(NetCache.worldHost, Calendar.currentPort);
                  ++js5ConnectState;
               }

               if (js5ConnectState == 1) {
                  if (WorldMapManager.js5SocketTask.status == 2) {
                     this.js5Error(-1);
                     return;
                  }

                  if (WorldMapManager.js5SocketTask.status == 1) {
                     ++js5ConnectState;
                  }
               }

               Buffer var3;
               if (js5ConnectState == 2) {
                  Socket var2 = (Socket)WorldMapManager.js5SocketTask.result;
                  BufferedNetSocket var1 = new BufferedNetSocket(var2, 40000, 5000);
                  Decimator.js5Socket = var1;
                  var3 = new Buffer(5);
                  var3.writeByte(15);
                  var3.writeInt(211);
                  Decimator.js5Socket.write(var3.array, 0, 5);
                  ++js5ConnectState;
                  HorizontalAlignment.field1543 = class153.clockNow();
               }

               if (js5ConnectState == 3) {
                  if (Decimator.js5Socket.available() > 0) {
                     int var5 = Decimator.js5Socket.readUnsignedByte();
                     if (var5 != 0) {
                        this.js5Error(var5);
                        return;
                     }

                     ++js5ConnectState;
                  } else if (class153.clockNow() - HorizontalAlignment.field1543 > 30000L) {
                     this.js5Error(-2);
                     return;
                  }
               }

               if (js5ConnectState == 4) {
                  AbstractSocket var13 = Decimator.js5Socket;
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
                  WorldMapDecoration.NetCache_currentResponse = null;
                  class14.NetCache_responseArchiveBuffer = null;
                  NetCache.field3484 = 0;

                  while(true) {
                     NetFileRequest var14 = (NetFileRequest)NetCache.NetCache_pendingPriorityResponses.first();
                     if (var14 == null) {
                        while(true) {
                           var14 = (NetFileRequest)NetCache.NetCache_pendingResponses.first();
                           if (var14 == null) {
                              if (NetCache.field3482 != 0) {
                                 try {
                                    var3 = new Buffer(4);
                                    var3.writeByte(4);
                                    var3.writeByte(NetCache.field3482);
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
                              NetCache.field3486 = class153.clockNow();
                              WorldMapManager.js5SocketTask = null;
                              Decimator.js5Socket = null;
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

   @ObfuscatedName("fs")
   @ObfuscatedSignature(
           descriptor = "(II)V",
           garbageValue = "-1698459928"
   )
   void js5Error(int var1) {
      WorldMapManager.js5SocketTask = null;
      Decimator.js5Socket = null;
      js5ConnectState = 0;
      if (Calendar.currentPort == class1.worldPort) {
         Calendar.currentPort = class10.js5Port;
      } else {
         Calendar.currentPort = class1.worldPort;
      }

      ++js5Errors;
      if (js5Errors < 2 || var1 != 7 && var1 != 9) {
         if (js5Errors >= 2 && var1 == 6) {
            this.error("js5connect_outofdate");
            class246.updateGameState(1000);
         } else if (js5Errors >= 4) {
            if (gameState <= 5) {
               this.error("js5connect");
               class246.updateGameState(1000);
            } else {
               js5Cycles = 3000;
            }
         }
      } else if (gameState <= 5) {
         this.error("js5connect_full");
         class246.updateGameState(1000);
      } else {
         js5Cycles = 3000;
      }

   }

   public boolean shouldProcessClick() {
      return true;
   }

   @ObfuscatedName("fv")
   @ObfuscatedSignature(
           descriptor = "(I)V",
           garbageValue = "-1895423785"
   )
   final void doCycleLoggedOut() {
      Object var1 = packetWriter.getSocket();
      PacketBuffer var2 = packetWriter.packetBuffer;

      try {
         if (loginState == 0) {
            if (GrandExchangeOfferTotalQuantityComparator.secureRandom == null && (secureRandomFuture.isDone() || field400 > 250)) {
               GrandExchangeOfferTotalQuantityComparator.secureRandom = secureRandomFuture.get();
               secureRandomFuture.shutdown();
               secureRandomFuture = null;
            }

            if (GrandExchangeOfferTotalQuantityComparator.secureRandom != null) {
               if (var1 != null) {
                  ((AbstractSocket)var1).close();
                  var1 = null;
               }

               BufferedSource.socketTask = null;
               hadNetworkError = false;
               field400 = 0;
               if (field404.method2459()) {
                  if (this.method369()) {
                     try {
                        this.method345(class152.field1373);
                        ModeWhere.method1885(21);
                     } catch (Throwable var23) {
                        class121.RunException_sendStackTrace((String)null, var23);
                        class33.getLoginError(65);
                        return;
                     }
                  } else {
                     if (!this.method343()) {
                        class33.getLoginError(65);
                        return;
                     }

                     try {
                        this.method342(MusicPatchNode.field2783, VarcInt.field1501);
                        ModeWhere.method1885(20);
                     } catch (Exception var22) {
                        class121.RunException_sendStackTrace((String)null, var22);
                        class33.getLoginError(65);
                        return;
                     }
                  }
               } else {
                  ModeWhere.method1885(1);
               }
            }
         }

         class20 var25;
         if (loginState == 21) {
            if (this.field648 != null) {
               if (!this.field648.isDone()) {
                  return;
               }

               if (this.field648.isCancelled()) {
                  class33.getLoginError(65);
                  this.field648 = null;
                  return;
               }

               try {
                  RefreshAccessTokenResponse var3 = (RefreshAccessTokenResponse)this.field648.get();
                  if (!var3.isSuccess()) {
                     class33.getLoginError(65);
                     this.field648 = null;
                     return;
                  }

                  Frames.field2059 = var3.getAccessToken();
                  class152.field1373 = var3.getRefreshToken();
                  this.field648 = null;
               } catch (Exception var21) {
                  class121.RunException_sendStackTrace((String)null, var21);
                  class33.getLoginError(65);
                  this.field648 = null;
                  return;
               }
            } else {
               if (this.field411 == null) {
                  class33.getLoginError(65);
                  return;
               }

               if (!this.field411.method70()) {
                  return;
               }

               if (this.field411.method72()) {
                  class121.RunException_sendStackTrace(this.field411.method69(), (Throwable)null);
                  class33.getLoginError(65);
                  this.field411 = null;
                  return;
               }

               var25 = this.field411.method71();
               if (var25.method76() != 200) {
                  class33.getLoginError(65);
                  this.field411 = null;
                  return;
               }

               field400 = 0;
               class429 var4 = new class429(var25.method75());

               try {
                  Frames.field2059 = var4.method2209().getString("access_token");
                  class152.field1373 = var4.method2209().getString("refresh_token");
               } catch (Exception var20) {
                  class121.RunException_sendStackTrace("Error parsing tokens", var20);
                  class33.getLoginError(65);
                  this.field411 = null;
                  return;
               }
            }

            this.method364(Frames.field2059);
            ModeWhere.method1885(20);
         }

         if (loginState == 20) {
            if (this.field409 != null) {
               if (!this.field409.isDone()) {
                  return;
               }

               if (this.field409.isCancelled()) {
                  class33.getLoginError(65);
                  this.field409 = null;
                  return;
               }

               try {
                  OtlTokenResponse var26 = (OtlTokenResponse)this.field409.get();
                  if (!var26.isSuccess()) {
                     class33.getLoginError(65);
                     this.field409 = null;
                     return;
                  }

                  this.field391 = var26.getToken();
                  this.field409 = null;
               } catch (Exception var19) {
                  class121.RunException_sendStackTrace((String)null, var19);
                  class33.getLoginError(65);
                  this.field409 = null;
                  return;
               }
            } else {
               if (this.field548 == null) {
                  class33.getLoginError(65);
                  return;
               }

               if (!this.field548.method70()) {
                  return;
               }

               if (this.field548.method72()) {
                  class121.RunException_sendStackTrace(this.field548.method69(), (Throwable)null);
                  class33.getLoginError(65);
                  this.field548 = null;
                  return;
               }

               var25 = this.field548.method71();
               if (var25.method76() != 200) {
                  class121.RunException_sendStackTrace("Response code: " + var25.method76() + "Response body: " + var25.method75(), (Throwable)null);
                  class33.getLoginError(65);
                  this.field548 = null;
                  return;
               }

               List var28 = (List)var25.method74().get("Content-Type");
               if (var28 != null && var28.contains(class427.field3808.method2204())) {
                  try {
                     JSONObject var5 = new JSONObject(var25.method75());
                     this.field391 = var5.getString("token");
                  } catch (JSONException var18) {
                     class121.RunException_sendStackTrace((String)null, var18);
                     class33.getLoginError(65);
                     this.field548 = null;
                     return;
                  }
               } else {
                  this.field391 = var25.method75();
               }

               this.field548 = null;
            }

            field400 = 0;
            ModeWhere.method1885(1);
         }

         if (loginState == 1) {
            if (BufferedSource.socketTask == null) {
               BufferedSource.socketTask = GameEngine.taskHandler.newSocketTask(NetCache.worldHost, Calendar.currentPort);
            }

            if (BufferedSource.socketTask.status == 2) {
               throw new IOException();
            }

            if (BufferedSource.socketTask.status == 1) {
               Socket var30 = (Socket)BufferedSource.socketTask.result;
               BufferedNetSocket var27 = new BufferedNetSocket(var30, 40000, 5000);
               var1 = var27;
               packetWriter.setSocket(var27);
               BufferedSource.socketTask = null;
               ModeWhere.method1885(2);
            }
         }

         PacketBufferNode var29;
         if (loginState == 2) {
            packetWriter.clearBuffer();
            var29 = ObjectComposition.method1025();
            var29.packetBuffer.writeByte(LoginPacket.field2682.id);
            packetWriter.addNode(var29);
            packetWriter.flush();
            var2.offset = 0;
            ModeWhere.method1885(3);
         }

         int var12;
         if (loginState == 3) {
            if (SoundSystem.pcmPlayer0 != null) {
               SoundSystem.pcmPlayer0.method201();
            }

            if (WorldMapSectionType.pcmPlayer1 != null) {
               WorldMapSectionType.pcmPlayer1.method201();
            }

            if (((AbstractSocket)var1).isAvailable(1)) {
               var12 = ((AbstractSocket)var1).readUnsignedByte();
               if (SoundSystem.pcmPlayer0 != null) {
                  SoundSystem.pcmPlayer0.method201();
               }

               if (WorldMapSectionType.pcmPlayer1 != null) {
                  WorldMapSectionType.pcmPlayer1.method201();
               }

               if (var12 != 0) {
                  class33.getLoginError(var12);
                  return;
               }

               var2.offset = 0;
               ModeWhere.method1885(4);
            }
         }

         if (loginState == 4) {
            if (var2.offset < 8) {
               var12 = ((AbstractSocket)var1).available();
               if (var12 > 8 - var2.offset) {
                  var12 = 8 - var2.offset;
               }

               if (var12 > 0) {
                  ((AbstractSocket)var1).read(var2.array, var2.offset, var12);
                  var2.offset += var12;
               }
            }

            if (var2.offset == 8) {
               var2.offset = 0;
               class149.field1336 = var2.readLong();
               ModeWhere.method1885(5);
            }
         }

         int var6;
         if (loginState == 5) {
            packetWriter.packetBuffer.offset = 0;
            packetWriter.clearBuffer();
            PacketBuffer var31 = new PacketBuffer(500);
            int[] var32 = new int[]{GrandExchangeOfferTotalQuantityComparator.secureRandom.nextInt(), GrandExchangeOfferTotalQuantityComparator.secureRandom.nextInt(), GrandExchangeOfferTotalQuantityComparator.secureRandom.nextInt(), GrandExchangeOfferTotalQuantityComparator.secureRandom.nextInt()};
            var31.offset = 0;
            var31.writeByte(1);
            var31.writeInt(var32[0]);
            var31.writeInt(var32[1]);
            var31.writeInt(var32[2]);
            var31.writeInt(var32[3]);
            var31.writeLong(class149.field1336);
            if (gameState == 40) {
               var31.writeInt(class18.field58[0]);
               var31.writeInt(class18.field58[1]);
               var31.writeInt(class18.field58[2]);
               var31.writeInt(class18.field58[3]);
            } else {
               if (gameState == 50) {
                  var31.writeByte(class135.field1290.rsOrdinal());
                  var31.writeInt(MusicPatchNode2.field2701);
               } else {
                  var31.writeByte(field403.rsOrdinal());
                  switch(field403.field1287) {
                  case 0:
                     var31.offset += 4;
                  case 1:
                  default:
                     break;
                  case 2:
                     var31.writeInt(PacketWriter.clientPreferences.method538(Login.Login_username));
                     break;
                  case 3:
                  case 4:
                     var31.writeMedium(UserComparator4.field1149);
                     ++var31.offset;
                  }
               }

               if (field404.method2459()) {
                  var31.writeByte(class478.field4049.rsOrdinal());
                  var31.writeStringCp1252NullTerminated(this.field391);
               } else {
                  var31.writeByte(class478.field4053.rsOrdinal());
                  var31.writeStringCp1252NullTerminated(Login.Login_password);
               }
            }

            var31.encryptRsa(class70.field737, class70.field736);
            class18.field58 = var32;
            PacketBufferNode var33 = ObjectComposition.method1025();
            var33.packetBuffer.offset = 0;
            if (gameState == 40) {
               var33.packetBuffer.writeByte(LoginPacket.RECONNECT_LOGIN_CONNECTION.id);
            } else {
               var33.packetBuffer.writeByte(LoginPacket.NEW_LOGIN_CONNECTION.id);
            }

            var33.packetBuffer.writeShort(0);
            var6 = var33.packetBuffer.offset;
            var33.packetBuffer.writeInt(211);
            var33.packetBuffer.writeInt(1);
            var33.packetBuffer.writeByte(clientType);
            var33.packetBuffer.writeByte(field372);
            byte var7 = 0;
            var33.packetBuffer.writeByte(var7);
            var33.packetBuffer.writeBytes(var31.array, 0, var31.offset);
            int var8 = var33.packetBuffer.offset;
            var33.packetBuffer.writeStringCp1252NullTerminated(Login.Login_username);
            var33.packetBuffer.writeByte((isResizable ? 1 : 0) << 1 | (isLowDetail ? 1 : 0));
            var33.packetBuffer.writeShort(GameEngine.canvasWidth);
            var33.packetBuffer.writeShort(class127.canvasHeight);
            UserComparator3.method656(var33.packetBuffer);
            var33.packetBuffer.writeStringCp1252NullTerminated(GraphicsDefaults.param9);
            var33.packetBuffer.writeInt(Message.field359);
            Buffer var9 = new Buffer(UserComparator9.platformInfo.size());
            UserComparator9.platformInfo.write(var9);
            var33.packetBuffer.writeBytes(var9.array, 0, var9.array.length);
            var33.packetBuffer.writeByte(clientType);
            var33.packetBuffer.writeInt(0);
            var33.packetBuffer.method2382(class12.archive12.hash);
            var33.packetBuffer.method2382(class372.archive2.hash);
            var33.packetBuffer.method2382(ApproximateRouteStrategy.archive10.hash);
            var33.packetBuffer.method2441(MusicPatchNode.field2782.hash);
            var33.packetBuffer.method2414(NetCache.archive9.hash);
            var33.packetBuffer.method2441(0);
            var33.packetBuffer.method2441(class174.archive14.hash);
            var33.packetBuffer.writeInt(GameEngine.archive19.hash);
            var33.packetBuffer.method2414(class419.archive18.hash);
            var33.packetBuffer.writeInt(class27.archive20.hash);
            var33.packetBuffer.method2382(class13.field44.hash);
            var33.packetBuffer.method2441(class144.archive4.hash);
            var33.packetBuffer.method2414(WorldMapEvent.archive8.hash);
            var33.packetBuffer.writeInt(PendingSpawn.archive13.hash);
            var33.packetBuffer.method2414(class153.archive6.hash);
            var33.packetBuffer.method2414(class286.archive15.hash);
            var33.packetBuffer.method2382(class148.field1333.hash);
            var33.packetBuffer.method2382(class151.archive11.hash);
            var33.packetBuffer.method2441(CollisionMap.archive17.hash);
            var33.packetBuffer.writeInt(DynamicObject.field826.hash);
            var33.packetBuffer.method2441(FriendsChat.archive7.hash);
            var33.packetBuffer.xteaEncrypt(var32, var8, var33.packetBuffer.offset);
            var33.packetBuffer.writeLengthShort(var33.packetBuffer.offset - var6);
            packetWriter.addNode(var33);
            packetWriter.flush();
            packetWriter.isaacCipher = new IsaacCipher(var32);
            int[] var10 = new int[4];

            for(int var11 = 0; var11 < 4; ++var11) {
               var10[var11] = var32[var11] + 50;
            }

            var2.newIsaacCipher(var10);
            ModeWhere.method1885(6);
         }

         int var13;
         if (loginState == 6 && ((AbstractSocket)var1).available() > 0) {
            var12 = ((AbstractSocket)var1).readUnsignedByte();
            if (var12 == 61) {
               var13 = ((AbstractSocket)var1).available();
               class209.field1857 = var13 == 1 && ((AbstractSocket)var1).readUnsignedByte() == 1;
               ModeWhere.method1885(5);
            }

            if (var12 == 21 && gameState == 20) {
               ModeWhere.method1885(12);
            } else if (var12 == 2) {
               ModeWhere.method1885(14);
            } else if (var12 == 15 && gameState == 40) {
               packetWriter.serverPacketLength = -1;
               ModeWhere.method1885(19);
            } else if (var12 == 64) {
               ModeWhere.method1885(10);
            } else if (var12 == 23 && field401 < 1) {
               ++field401;
               ModeWhere.method1885(0);
            } else if (var12 == 29) {
               ModeWhere.method1885(17);
            } else {
               if (var12 != 69) {
                  class33.getLoginError(var12);
                  return;
               }

               ModeWhere.method1885(7);
            }
         }

         if (loginState == 7 && ((AbstractSocket)var1).available() >= 2) {
            ((AbstractSocket)var1).read(var2.array, 0, 2);
            var2.offset = 0;
            MidiPcmStream.field2725 = var2.readUnsignedShort();
            ModeWhere.method1885(8);
         }

         if (loginState == 8 && ((AbstractSocket)var1).available() >= MidiPcmStream.field2725) {
            var2.offset = 0;
            ((AbstractSocket)var1).read(var2.array, var2.offset, MidiPcmStream.field2725);
            class6[] var34 = new class6[]{class6.field7};
            class6 var35 = var34[var2.readUnsignedByte()];

            try {
               class3 var36 = class70.method423(var35);
               this.field419 = new class7(var2, var36);
               ModeWhere.method1885(9);
            } catch (Exception var17) {
               class33.getLoginError(22);
               return;
            }
         }

         if (loginState == 9 && this.field419.method21()) {
            this.field418 = this.field419.method25();
            this.field419.method22();
            this.field419 = null;
            if (this.field418 == null) {
               class33.getLoginError(22);
               return;
            }

            packetWriter.clearBuffer();
            var29 = ObjectComposition.method1025();
            var29.packetBuffer.writeByte(LoginPacket.field2678.id);
            var29.packetBuffer.writeShort(this.field418.offset);
            var29.packetBuffer.method2443(this.field418);
            packetWriter.addNode(var29);
            packetWriter.flush();
            this.field418 = null;
            ModeWhere.method1885(6);
         }

         if (loginState == 10 && ((AbstractSocket)var1).available() > 0) {
            class121.field1177 = ((AbstractSocket)var1).readUnsignedByte();
            ModeWhere.method1885(11);
         }

         if (loginState == 11 && ((AbstractSocket)var1).available() >= class121.field1177) {
            ((AbstractSocket)var1).read(var2.array, 0, class121.field1177);
            var2.offset = 0;
            ModeWhere.method1885(6);
         }

         if (loginState == 12 && ((AbstractSocket)var1).available() > 0) {
            field514 = (((AbstractSocket)var1).readUnsignedByte() + 3) * 60;
            ModeWhere.method1885(13);
         }

         if (loginState == 13) {
            field400 = 0;
            class70.setLoginResponseString("You have only just left another world.", "Your profile will be transferred in:", field514 / 60 + " seconds.");
            if (--field514 <= 0) {
               ModeWhere.method1885(0);
            }

         } else {
            if (loginState == 14 && ((AbstractSocket)var1).available() >= 1) {
               TriBool.playerUUIDLength = ((AbstractSocket)var1).readUnsignedByte();
               ModeWhere.method1885(15);
            }

            boolean var43;
            if (loginState == 15 && ((AbstractSocket)var1).available() >= TriBool.playerUUIDLength) {
               boolean var44 = ((AbstractSocket)var1).readUnsignedByte() == 1;
               ((AbstractSocket)var1).read(var2.array, 0, 4);
               var2.offset = 0;
               var43 = false;
               if (var44) {
                  var13 = var2.readByteIsaac() << 24;
                  var13 |= var2.readByteIsaac() << 16;
                  var13 |= var2.readByteIsaac() << 8;
                  var13 |= var2.readByteIsaac();
                  PacketWriter.clientPreferences.method550(Login.Login_username, var13);
               }

               if (Login_isUsernameRemembered) {
                  PacketWriter.clientPreferences.setUsernameToRemember(Login.Login_username);
               } else {
                  PacketWriter.clientPreferences.setUsernameToRemember((String)null);
               }

               SoundSystem.savePreferences();
               staffModLevel = ((AbstractSocket)var1).readUnsignedByte();
               playerMod = ((AbstractSocket)var1).readUnsignedByte() == 1;
               localPlayerIndex = ((AbstractSocket)var1).readUnsignedByte();
               localPlayerIndex <<= 8;
               localPlayerIndex += ((AbstractSocket)var1).readUnsignedByte();
               isMembers = ((AbstractSocket)var1).readUnsignedByte();
               ((AbstractSocket)var1).read(var2.array, 0, 8);
               var2.offset = 0;
               this.accountHash = var2.readLong();
               if (TriBool.playerUUIDLength >= 29) {
                  ((AbstractSocket)var1).read(var2.array, 0, 8);
                  var2.offset = 0;
                  playerUUID = var2.readLong();
               }

               ((AbstractSocket)var1).read(var2.array, 0, 1);
               var2.offset = 0;
               ServerPacket[] var39 = ObjTypeCustomisation.ServerPacket_values();
               var6 = var2.readSmartByteShortIsaac();
               if (var6 < 0 || var6 >= var39.length) {
                  throw new IOException(var6 + " " + var2.offset);
               }

               packetWriter.serverPacket = var39[var6];
               packetWriter.serverPacketLength = packetWriter.serverPacket.length;
               ((AbstractSocket)var1).read(var2.array, 0, 2);
               var2.offset = 0;
               packetWriter.serverPacketLength = var2.readUnsignedShort();

               try {
                  Client var14 = Decimator.client;
                  //JSObject.getWindow(var14).call("zap", (Object[])null);
               } catch (Throwable var16) {
                  ;
               }

               ModeWhere.method1885(16);
            }

            if (loginState != 16) {
               if (loginState == 17 && ((AbstractSocket)var1).available() >= 2) {
                  var2.offset = 0;
                  ((AbstractSocket)var1).read(var2.array, 0, 2);
                  var2.offset = 0;
                  Canvas.field77 = var2.readUnsignedShort();
                  ModeWhere.method1885(18);
               }

               if (loginState == 18 && ((AbstractSocket)var1).available() >= Canvas.field77) {
                  var2.offset = 0;
                  ((AbstractSocket)var1).read(var2.array, 0, Canvas.field77);
                  var2.offset = 0;
                  String var42 = var2.readStringCp1252NullTerminated();
                  String var38 = var2.readStringCp1252NullTerminated();
                  String var41 = var2.readStringCp1252NullTerminated();
                  class70.setLoginResponseString(var42, var38, var41);
                  class246.updateGameState(10);
                  if (field404.method2459()) {
                     ReflectionCheck.method171(9);
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
                     var12 = packetWriter.serverPacketLength;
                     timer.method2024();
                     class12.method47();
                     Login.updatePlayer(var2);
                     if (var12 != var2.offset) {
                        throw new RuntimeException();
                     }
                  }
               } else {
                  ++field400;
                  if (field400 > 2000) {
                     if (field401 < 1) {
                        if (Calendar.currentPort == class1.worldPort) {
                           Calendar.currentPort = class10.js5Port;
                        } else {
                           Calendar.currentPort = class1.worldPort;
                        }

                        ++field401;
                        ModeWhere.method1885(0);
                     } else {
                        class33.getLoginError(-3);
                     }
                  }
               }
            } else {
               if (((AbstractSocket)var1).available() >= packetWriter.serverPacketLength) {
                  var2.offset = 0;
                  ((AbstractSocket)var1).read(var2.array, 0, packetWriter.serverPacketLength);
                  timer.method2022();
                  mouseLastLastPressedTimeMillis = -1L;
                  class36.mouseRecorder.index = 0;
                  GameEngine.hasFocus = true;
                  hadFocus = true;
                  timeOfPreviousKeyPress = -1L;
                  class146.method775();
                  packetWriter.clearBuffer();
                  packetWriter.packetBuffer.offset = 0;
                  packetWriter.serverPacket = null;
                  packetWriter.field1137 = null;
                  packetWriter.field1133 = null;
                  packetWriter.field1134 = null;
                  packetWriter.serverPacketLength = 0;
                  packetWriter.field1130 = 0;
                  rebootTimer = 0;
                  logoutTimer = 0;
                  hintArrowType = 0;
                  ScriptFrame.method322();
                  MouseHandler.MouseHandler_idleCycles = 0;
                  class140.method754();
                  isItemSelected = 0;
                  isSpellSelected = false;
                  soundEffectCount = 0;
                  camAngleY = 0;
                  oculusOrbState = 0;
                  class136.field1293 = null;
                  minimapState = 0;
                  field614 = -1;
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

                  int var15;
                  for(var12 = 0; var12 < 4; ++var12) {
                     for(var13 = 0; var13 < 104; ++var13) {
                        for(var15 = 0; var15 < 104; ++var15) {
                           groundItems[var12][var13][var15] = null;
                        }
                     }
                  }

                  pendingSpawns = new NodeDeque();
                  WorldMapElement.friendSystem.clear();

                  for(var12 = 0; var12 < VarpDefinition.field1471; ++var12) {
                     VarpDefinition var37 = TaskHandler.VarpDefinition_get(var12);
                     if (var37 != null) {
                        Varps.Varps_temp[var12] = 0;
                        Varps.Varps_main[var12] = 0;
                     }
                  }

                  class9.varcs.clearTransient();
                  followerIndex = -1;
                  if (rootInterface != -1) {
                     var12 = rootInterface;
                     if (var12 != -1 && class431.Widget_loadedInterfaces[var12]) {
                        UserComparator8.Widget_archive.clearFilesGroup(var12);
                        if (WorldMapLabel.Widget_interfaceComponents[var12] != null) {
                           var43 = true;

                           for(var15 = 0; var15 < WorldMapLabel.Widget_interfaceComponents[var12].length; ++var15) {
                              if (WorldMapLabel.Widget_interfaceComponents[var12][var15] != null) {
                                 if (WorldMapLabel.Widget_interfaceComponents[var12][var15].type != 2) {
                                    WorldMapLabel.Widget_interfaceComponents[var12][var15] = null;
                                 } else {
                                    var43 = false;
                                 }
                              }
                           }

                           if (var43) {
                              WorldMapLabel.Widget_interfaceComponents[var12] = null;
                           }

                           class431.Widget_loadedInterfaces[var12] = false;
                        }
                     }
                  }

                  for(InterfaceParent var40 = (InterfaceParent)interfaceParents.first(); var40 != null; var40 = (InterfaceParent)interfaceParents.next()) {
                     class10.closeInterface(var40, true);
                  }

                  rootInterface = -1;
                  interfaceParents = new NodeHashTable(8);
                  meslayerContinueWidget = null;
                  ScriptFrame.method322();
                  playerAppearance.initiateAppearance((int[])null, new int[]{0, 0, 0, 0, 0}, 0, -1);

                  for(var12 = 0; var12 < 8; ++var12) {
                     playerMenuActions[var12] = null;
                     playerOptionsPriorities[var12] = false;
                  }

                  class320.method1780();
                  isLoading = true;

                  for(var12 = 0; var12 < 100; ++var12) {
                     field591[var12] = true;
                  }

                  var29 = Renderable.getPacketBufferNode(ClientPacket.field2494, packetWriter.isaacCipher);
                  var29.packetBuffer.writeByte(Message.getWindowedMode());
                  var29.packetBuffer.writeShort(GameEngine.canvasWidth);
                  var29.packetBuffer.writeShort(class127.canvasHeight);
                  packetWriter.addNode(var29);
                  class463.friendsChat = null;
                  DynamicObject.guestClanSettings = null;
                  Arrays.fill(currentClanSettings, (Object)null);
                  class482.guestClanChannel = null;
                  Arrays.fill(currentClanChannels, (Object)null);

                  for(var12 = 0; var12 < 8; ++var12) {
                     grandExchangeOffers[var12] = new GrandExchangeOffer();
                  }

                  EnumComposition.grandExchangeEvents = null;
                  Login.updatePlayer(var2);
                  class303.timeOfPreviousKeyPress = -1;
                  class277.loadRegions(false, var2);
                  packetWriter.serverPacket = null;
               }

            }
         }
      } catch (IOException var24) {
         if (field401 < 1) {
            if (class1.worldPort == Calendar.currentPort) {
               Calendar.currentPort = class10.js5Port;
            } else {
               Calendar.currentPort = class1.worldPort;
            }

            ++field401;
            ModeWhere.method1885(0);
         } else {
            class33.getLoginError(-2);
         }
      }
   }

   @ObfuscatedName("fp")
   @ObfuscatedSignature(
           descriptor = "(I)V",
           garbageValue = "1825942383"
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
         WorldMapManager.method1404();
      } else {
         if (!isMenuOpen) {
            class174.addCancelMenuEntry();
         }

         int var1;
         for(var1 = 0; var1 < 100 && this.method367(packetWriter); ++var1) {
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
                  if (timer.field3655) {
                     var14 = Renderable.getPacketBufferNode(ClientPacket.field2457, packetWriter.isaacCipher);
                     var14.packetBuffer.writeByte(0);
                     var15 = var14.packetBuffer.offset;
                     timer.write(var14.packetBuffer);
                     var14.packetBuffer.method2434(var14.packetBuffer.offset - var15);
                     packetWriter.addNode(var14);
                     timer.method2025();
                  }

                  Object var38 = class36.mouseRecorder.lock;
                  int var4;
                  int var5;
                  int var6;
                  int var7;
                  int var8;
                  int var9;
                  int var10;
                  int var11;
                  int var12;
                  synchronized(class36.mouseRecorder.lock) {
                     if (!lockMouseRecorder) {
                        class36.mouseRecorder.index = 0;
                     } else if (MouseHandler.MouseHandler_lastButton != 0 || class36.mouseRecorder.index >= 40) {
                        var31 = null;
                        var3 = 0;
                        var4 = 0;
                        var5 = 0;
                        var6 = 0;

                        for(var7 = 0; var7 < class36.mouseRecorder.index && (var31 == null || var31.packetBuffer.offset - var3 < 246); ++var7) {
                           var4 = var7;
                           var8 = class36.mouseRecorder.ys[var7];
                           if (var8 < -1) {
                              var8 = -1;
                           } else if (var8 > 65534) {
                              var8 = 65534;
                           }

                           var9 = class36.mouseRecorder.xs[var7];
                           if (var9 < -1) {
                              var9 = -1;
                           } else if (var9 > 65534) {
                              var9 = 65534;
                           }

                           if (var9 != lastMouseRecordX || var8 != lastMouseRecordY) {
                              if (var31 == null) {
                                 var31 = Renderable.getPacketBufferNode(ClientPacket.field2534, packetWriter.isaacCipher);
                                 var31.packetBuffer.writeByte(0);
                                 var3 = var31.packetBuffer.offset;
                                 var31.packetBuffer.offset += 2;
                                 var5 = 0;
                                 var6 = 0;
                              }

                              if (-1L != lastMouseRecordTime) {
                                 var10 = var9 - lastMouseRecordX;
                                 var11 = var8 - lastMouseRecordY;
                                 var12 = (int)((class36.mouseRecorder.millis[var7] - lastMouseRecordTime) / 20L);
                                 var5 = (int)((long)var5 + (class36.mouseRecorder.millis[var7] - lastMouseRecordTime) % 20L);
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
                              lastMouseRecordTime = class36.mouseRecorder.millis[var7];
                           }
                        }

                        if (var31 != null) {
                           var31.packetBuffer.method2434(var31.packetBuffer.offset - var3);
                           var7 = var31.packetBuffer.offset;
                           var31.packetBuffer.offset = var3;
                           var31.packetBuffer.writeByte(var5 / var6);
                           var31.packetBuffer.writeByte(var5 % var6);
                           var31.packetBuffer.offset = var7;
                           packetWriter.addNode(var31);
                        }

                        if (var4 >= class36.mouseRecorder.index) {
                           class36.mouseRecorder.index = 0;
                        } else {
                           class36.mouseRecorder.index -= var4;
                           System.arraycopy(class36.mouseRecorder.xs, var4, class36.mouseRecorder.xs, 0, class36.mouseRecorder.index);
                           System.arraycopy(class36.mouseRecorder.ys, var4, class36.mouseRecorder.ys, 0, class36.mouseRecorder.index);
                           System.arraycopy(class36.mouseRecorder.millis, var4, class36.mouseRecorder.millis, 0, class36.mouseRecorder.index);
                        }
                     }
                  }

                  PacketBufferNode var18;
                  if (MouseHandler.MouseHandler_lastButton == 1 || !ClanMate.mouseCam && MouseHandler.MouseHandler_lastButton == 4 || MouseHandler.MouseHandler_lastButton == 2) {
                     long var16 = MouseHandler.MouseHandler_lastPressedTimeMillis - mouseLastLastPressedTimeMillis;
                     if (var16 > 32767L) {
                        var16 = 32767L;
                     }

                     mouseLastLastPressedTimeMillis = MouseHandler.MouseHandler_lastPressedTimeMillis;
                     var3 = MouseHandler.MouseHandler_lastPressedY;
                     if (var3 < 0) {
                        var3 = 0;
                     } else if (var3 > class127.canvasHeight) {
                        var3 = class127.canvasHeight;
                     }

                     var4 = MouseHandler.MouseHandler_lastPressedX;
                     if (var4 < 0) {
                        var4 = 0;
                     } else if (var4 > GameEngine.canvasWidth) {
                        var4 = GameEngine.canvasWidth;
                     }

                     var5 = (int)var16;
                     if (shouldProcessClick()) {
                        var18 = Renderable.getPacketBufferNode(ClientPacket.field2432, packetWriter.isaacCipher);
                        var18.packetBuffer.writeShort((var5 << 1) + (MouseHandler.MouseHandler_lastButton == 2 ? 1 : 0));
                        var18.packetBuffer.writeShort(var4);
                        var18.packetBuffer.writeShort(var3);
                        packetWriter.addNode(var18);
                     }
                  }

                  if (keyHandlerInstance.pressedKeysCount > 0) {
                     var14 = Renderable.getPacketBufferNode(ClientPacket.field2522, packetWriter.isaacCipher);
                     var14.packetBuffer.writeShort(0);
                     var15 = var14.packetBuffer.offset;
                     long var19 = class153.clockNow();

                     for(var5 = 0; var5 < keyHandlerInstance.pressedKeysCount; ++var5) {
                        long var21 = var19 - timeOfPreviousKeyPress;
                        if (var21 > 16777215L) {
                           var21 = 16777215L;
                        }

                        timeOfPreviousKeyPress = var19;
                        var14.packetBuffer.writeMediumMiddle((int)var21);
                        var14.packetBuffer.writeByteS(keyHandlerInstance.field1821[var5]);
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
                     var14 = Renderable.getPacketBufferNode(ClientPacket.field2514, packetWriter.isaacCipher);
                     var14.packetBuffer.writeShortLEA(camAngleX);
                     var14.packetBuffer.writeShort(camAngleY);
                     packetWriter.addNode(var14);
                  }

                  if (GameEngine.hasFocus && !hadFocus) {
                     hadFocus = true;
                     var14 = Renderable.getPacketBufferNode(ClientPacket.field2468, packetWriter.isaacCipher);
                     var14.packetBuffer.writeByte(1);
                     packetWriter.addNode(var14);
                  }

                  if (!GameEngine.hasFocus && hadFocus) {
                     hadFocus = false;
                     var14 = Renderable.getPacketBufferNode(ClientPacket.field2468, packetWriter.isaacCipher);
                     var14.packetBuffer.writeByte(0);
                     packetWriter.addNode(var14);
                  }

                  if (GrandExchangeOfferUnitPriceComparator.worldMap != null) {
                     GrandExchangeOfferUnitPriceComparator.worldMap.method2233();
                  }

                  class374.method1973();
                  if (VarbitComposition.field1631) {
                     for(var1 = 0; var1 < Players.Players_count; ++var1) {
                        Player var32 = players[Players.Players_indices[var1]];
                        var32.clearIsInClanChat();
                     }

                     VarbitComposition.field1631 = false;
                  }

                  if (field614 != class103.Client_plane) {
                     field614 = class103.Client_plane;
                     AttackOption.method589(class103.Client_plane);
                  }

                  if (gameState != 30) {
                     return;
                  }

                  for(PendingSpawn var40 = (PendingSpawn)pendingSpawns.last(); var40 != null; var40 = (PendingSpawn)pendingSpawns.previous()) {
                     if (var40.endCycle > 0) {
                        --var40.endCycle;
                     }

                     ObjectComposition var23;
                     boolean var39;
                     if (var40.endCycle == 0) {
                        if (var40.objectId >= 0) {
                           var3 = var40.objectId;
                           var4 = var40.field927;
                           var23 = class463.getObjectDefinition(var3);
                           if (var4 == 11) {
                              var4 = 10;
                           }

                           if (var4 >= 5 && var4 <= 8) {
                              var4 = 4;
                           }

                           var39 = var23.method1016(var4);
                           if (!var39) {
                              continue;
                           }
                        }

                        Skills.addPendingSpawnToScene(var40.plane, var40.type, var40.x, var40.y, var40.objectId, var40.field926, var40.field927);
                        var40.remove();
                     } else {
                        if (var40.startCycle > 0) {
                           --var40.startCycle;
                        }

                        if (var40.startCycle == 0 && var40.x >= 1 && var40.y >= 1 && var40.x <= 102 && var40.y <= 102) {
                           if (var40.id >= 0) {
                              var3 = var40.id;
                              var4 = var40.objectType;
                              var23 = class463.getObjectDefinition(var3);
                              if (var4 == 11) {
                                 var4 = 10;
                              }

                              if (var4 >= 5 && var4 <= 8) {
                                 var4 = 4;
                              }

                              var39 = var23.method1016(var4);
                              if (!var39) {
                                 continue;
                              }
                           }

                           Skills.addPendingSpawnToScene(var40.plane, var40.type, var40.x, var40.y, var40.id, var40.rotation, var40.objectType);
                           var40.startCycle = -1;
                           if (var40.objectId == var40.id && var40.objectId == -1) {
                              var40.remove();
                           } else if (var40.id == var40.objectId && var40.rotation == var40.field926 && var40.field927 == var40.objectType) {
                              var40.remove();
                           }
                        }
                     }
                  }

                  class7.method23();
                  ++packetWriter.field1130;
                  if (packetWriter.field1130 > 750) {
                     WorldMapManager.method1404();
                     return;
                  }

                  MenuAction.method415();
                  VarbitComposition.method983();
                  class120.method671();
                  ++field442;
                  if (mouseCrossColor != 0) {
                     mouseCrossState += 20;
                     if (mouseCrossState >= 400) {
                        mouseCrossColor = 0;
                     }
                  }

                  if (class378.field3629 != null) {
                     ++field608;
                     if (field608 >= 15) {
                        LoginScreenAnimation.invalidateWidget(class378.field3629);
                        class378.field3629 = null;
                     }
                  }

                  Widget var41 = KeyHandler.mousedOverWidgetIf1;
                  Widget var33 = class18.field60;
                  KeyHandler.mousedOverWidgetIf1 = null;
                  class18.field60 = null;
                  draggedOnWidget = null;
                  field563 = false;
                  field560 = false;
                  field623 = 0;

                  while(keyHandlerInstance.method1085() && field623 < 128) {
                     if (staffModLevel >= 2 && keyHandlerInstance.getKeyPressed(82) && keyHandlerInstance.field1832 == 66) {
                        String var24 = class209.method1111();
                        Decimator.client.copyToClipboard(var24);
                     } else if (oculusOrbState != 1 || keyHandlerInstance.field1826 <= 0) {
                        field610[field623] = keyHandlerInstance.field1832;
                        field618[field623] = keyHandlerInstance.field1826;
                        ++field623;
                     }
                  }

                  boolean var34 = staffModLevel >= 2;
                  if (var34 && keyHandlerInstance.getKeyPressed(82) && keyHandlerInstance.getKeyPressed(81) && mouseWheelRotation != 0) {
                     var4 = class387.localPlayer.plane - mouseWheelRotation;
                     if (var4 < 0) {
                        var4 = 0;
                     } else if (var4 > 3) {
                        var4 = 3;
                     }

                     if (var4 != class387.localPlayer.plane) {
                        class168.method891(class387.localPlayer.pathX[0] + ParamComposition.baseX, class387.localPlayer.pathY[0] + baseY, var4, false);
                     }

                     mouseWheelRotation = 0;
                  }

                  if (MouseHandler.MouseHandler_lastButton == 1) {
                     field617.method1066();
                  }

                  if (rootInterface != -1) {
                     class144.updateRootInterface(rootInterface, 0, 0, GameEngine.canvasWidth, class127.canvasHeight, 0, 0);
                  }

                  ++cycleCntr;

                  while(true) {
                     ScriptEvent var25;
                     Widget var42;
                     Widget var43;
                     do {
                        var25 = (ScriptEvent)field632.removeLast();
                        if (var25 == null) {
                           while(true) {
                              do {
                                 var25 = (ScriptEvent)field586.removeLast();
                                 if (var25 == null) {
                                    while(true) {
                                       do {
                                          var25 = (ScriptEvent)scriptEvents.removeLast();
                                          if (var25 == null) {
                                             while(true) {
                                                while(true) {
                                                   class204 var46;
                                                   do {
                                                      do {
                                                         do {
                                                            var46 = (class204)field587.removeLast();
                                                            if (var46 == null) {
                                                               this.menu();
                                                               if (GrandExchangeOfferUnitPriceComparator.worldMap != null) {
                                                                  GrandExchangeOfferUnitPriceComparator.worldMap.method2290(class103.Client_plane, (class387.localPlayer.x >> 7) + ParamComposition.baseX, (class387.localPlayer.y >> 7) + baseY, false);
                                                                  GrandExchangeOfferUnitPriceComparator.worldMap.loadCache();
                                                               }

                                                               if (clickedWidget != null) {
                                                                  this.method370();
                                                               }

                                                               if (WorldMapLabelSize.dragInventoryWidget != null) {
                                                                  LoginScreenAnimation.invalidateWidget(WorldMapLabelSize.dragInventoryWidget);
                                                                  ++itemDragDuration;
                                                                  if (MouseHandler.MouseHandler_currentButton == 0) {
                                                                     if (field492) {
                                                                        if (WorldMapLabelSize.dragInventoryWidget == class157.hoveredItemContainer && dragItemSlotSource != dragItemSlotDestination) {
                                                                           Widget var47 = WorldMapLabelSize.dragInventoryWidget;
                                                                           byte var35 = 0;
                                                                           if (field547 == 1 && var47.contentType == 206) {
                                                                              var35 = 1;
                                                                           }

                                                                           if (var47.itemIds[dragItemSlotDestination] <= 0) {
                                                                              var35 = 0;
                                                                           }

                                                                           if (class16.method58(class173.getWidgetFlags(var47))) {
                                                                              var6 = dragItemSlotSource;
                                                                              var7 = dragItemSlotDestination;
                                                                              var47.itemIds[var7] = var47.itemIds[var6];
                                                                              var47.itemQuantities[var7] = var47.itemQuantities[var6];
                                                                              var47.itemIds[var6] = -1;
                                                                              var47.itemQuantities[var6] = 0;
                                                                           } else if (var35 == 1) {
                                                                              var6 = dragItemSlotSource;
                                                                              var7 = dragItemSlotDestination;

                                                                              while(var6 != var7) {
                                                                                 if (var6 > var7) {
                                                                                    var47.swapItems(var6 - 1, var6);
                                                                                    --var6;
                                                                                 } else if (var6 < var7) {
                                                                                    var47.swapItems(var6 + 1, var6);
                                                                                    ++var6;
                                                                                 }
                                                                              }
                                                                           } else {
                                                                              var47.swapItems(dragItemSlotDestination, dragItemSlotSource);
                                                                           }

                                                                           var18 = Renderable.getPacketBufferNode(ClientPacket.field2512, packetWriter.isaacCipher);
                                                                           var18.packetBuffer.writeShortLE(dragItemSlotSource);
                                                                           var18.packetBuffer.writeShortA(dragItemSlotDestination);
                                                                           var18.packetBuffer.method2399(var35);
                                                                           var18.packetBuffer.method2382(WorldMapLabelSize.dragInventoryWidget.id);
                                                                           packetWriter.addNode(var18);
                                                                        }
                                                                     } else if (this.shouldLeftClickOpenMenu()) {
                                                                        this.openMenu(draggedWidgetX, draggedWidgetY);
                                                                     } else if (menuOptionsCount > 0) {
                                                                        Skills.method1779(draggedWidgetX, draggedWidgetY);
                                                                     }

                                                                     field608 = 10;
                                                                     MouseHandler.MouseHandler_lastButton = 0;
                                                                     WorldMapLabelSize.dragInventoryWidget = null;
                                                                  } else if (itemDragDuration >= 5 && (MouseHandler.MouseHandler_x > draggedWidgetX + 5 || MouseHandler.MouseHandler_x < draggedWidgetX - 5 || MouseHandler.MouseHandler_y > draggedWidgetY + 5 || MouseHandler.MouseHandler_y < draggedWidgetY - 5)) {
                                                                     field492 = true;
                                                                  }
                                                               }

                                                               if (Scene.shouldSendWalk()) {
                                                                  var4 = Scene.Scene_selectedX;
                                                                  var5 = Scene.Scene_selectedY;
                                                                  var18 = Renderable.getPacketBufferNode(ClientPacket.field2526, packetWriter.isaacCipher);
                                                                  var18.packetBuffer.writeByte(5);
                                                                  var18.packetBuffer.writeShort(var4 + ParamComposition.baseX);
                                                                  var18.packetBuffer.writeByteA(keyHandlerInstance.getKeyPressed(82) ? (keyHandlerInstance.getKeyPressed(81) ? 2 : 1) : 0);
                                                                  var18.packetBuffer.writeShort(var5 + baseY);
                                                                  packetWriter.addNode(var18);
                                                                  Scene.method1224();
                                                                  mouseCrossX = MouseHandler.MouseHandler_lastPressedX;
                                                                  mouseCrossY = MouseHandler.MouseHandler_lastPressedY;
                                                                  mouseCrossColor = 1;
                                                                  mouseCrossState = 0;
                                                                  destinationX = var4;
                                                                  destinationY = var5;
                                                               }

                                                               if (var41 != KeyHandler.mousedOverWidgetIf1) {
                                                                  if (var41 != null) {
                                                                     LoginScreenAnimation.invalidateWidget(var41);
                                                                  }

                                                                  if (KeyHandler.mousedOverWidgetIf1 != null) {
                                                                     LoginScreenAnimation.invalidateWidget(KeyHandler.mousedOverWidgetIf1);
                                                                  }
                                                               }

                                                               if (var33 != class18.field60 && field533 == field534) {
                                                                  if (var33 != null) {
                                                                     LoginScreenAnimation.invalidateWidget(var33);
                                                                  }

                                                                  if (class18.field60 != null) {
                                                                     LoginScreenAnimation.invalidateWidget(class18.field60);
                                                                  }
                                                               }

                                                               if (class18.field60 != null) {
                                                                  if (field533 < field534) {
                                                                     ++field533;
                                                                     if (field534 == field533) {
                                                                        LoginScreenAnimation.invalidateWidget(class18.field60);
                                                                     }
                                                                  }
                                                               } else if (field533 > 0) {
                                                                  --field533;
                                                               }

                                                               if (oculusOrbState == 0) {
                                                                  var4 = class387.localPlayer.x;
                                                                  var5 = class387.localPlayer.y;
                                                                  if (class245.oculusOrbFocalPointX - var4 < -500 || class245.oculusOrbFocalPointX - var4 > 500 || UserComparator10.oculusOrbFocalPointY - var5 < -500 || UserComparator10.oculusOrbFocalPointY - var5 > 500) {
                                                                     class245.oculusOrbFocalPointX = var4;
                                                                     UserComparator10.oculusOrbFocalPointY = var5;
                                                                  }

                                                                  if (var4 != class245.oculusOrbFocalPointX) {
                                                                     class245.oculusOrbFocalPointX += (var4 - class245.oculusOrbFocalPointX) / 16;
                                                                  }

                                                                  if (var5 != UserComparator10.oculusOrbFocalPointY) {
                                                                     UserComparator10.oculusOrbFocalPointY += (var5 - UserComparator10.oculusOrbFocalPointY) / 16;
                                                                  }

                                                                  var6 = class245.oculusOrbFocalPointX >> 7;
                                                                  var7 = UserComparator10.oculusOrbFocalPointY >> 7;
                                                                  var8 = GrandExchangeOfferNameComparator.getTileHeight(class245.oculusOrbFocalPointX, UserComparator10.oculusOrbFocalPointY, class103.Client_plane);
                                                                  var9 = 0;
                                                                  if (var6 > 3 && var7 > 3 && var6 < 100 && var7 < 100) {
                                                                     for(var10 = var6 - 4; var10 <= var6 + 4; ++var10) {
                                                                        for(var11 = var7 - 4; var11 <= var7 + 4; ++var11) {
                                                                           var12 = class103.Client_plane;
                                                                           if (var12 < 3 && (Tiles.Tiles_renderFlags[1][var10][var11] & 2) == 2) {
                                                                              ++var12;
                                                                           }

                                                                           int var26 = var8 - Tiles.Tiles_heights[var12][var10][var11];
                                                                           if (var26 > var9) {
                                                                              var9 = var26;
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

                                                                  if (var10 > field466) {
                                                                     field466 += (var10 - field466) / 24;
                                                                  } else if (var10 < field466) {
                                                                     field466 += (var10 - field466) / 80;
                                                                  }

                                                                  Ignored.field3716 = GrandExchangeOfferNameComparator.getTileHeight(class387.localPlayer.x, class387.localPlayer.y, class103.Client_plane) - camFollowHeight;
                                                               } else if (oculusOrbState == 1) {
                                                                  GrandExchangeOfferOwnWorldComparator.method341();
                                                                  short var37 = -1;
                                                                  if (keyHandlerInstance.getKeyPressed(33)) {
                                                                     var37 = 0;
                                                                  } else if (keyHandlerInstance.getKeyPressed(49)) {
                                                                     var37 = 1024;
                                                                  }

                                                                  if (keyHandlerInstance.getKeyPressed(48)) {
                                                                     if (var37 == 0) {
                                                                        var37 = 1792;
                                                                     } else if (var37 == 1024) {
                                                                        var37 = 1280;
                                                                     } else {
                                                                        var37 = 1536;
                                                                     }
                                                                  } else if (keyHandlerInstance.getKeyPressed(50)) {
                                                                     if (var37 == 0) {
                                                                        var37 = 256;
                                                                     } else if (var37 == 1024) {
                                                                        var37 = 768;
                                                                     } else {
                                                                        var37 = 512;
                                                                     }
                                                                  }

                                                                  byte var36 = 0;
                                                                  if (keyHandlerInstance.getKeyPressed(35)) {
                                                                     var36 = -1;
                                                                  } else if (keyHandlerInstance.getKeyPressed(51)) {
                                                                     var36 = 1;
                                                                  }

                                                                  var6 = 0;
                                                                  if (var37 >= 0 || var36 != 0) {
                                                                     var6 = keyHandlerInstance.getKeyPressed(81) ? oculusOrbSlowedSpeed * -237513411 * 293972501 : oculusOrbNormalSpeed * 850633261 * -134546011;
                                                                     var6 *= 16;
                                                                     field458 = var37;
                                                                     field399 = var36;
                                                                  }

                                                                  if (field457 < var6) {
                                                                     field457 += var6 / 8;
                                                                     if (field457 > var6) {
                                                                        field457 = var6;
                                                                     }
                                                                  } else if (field457 > var6) {
                                                                     field457 = field457 * 9 / 10;
                                                                  }

                                                                  if (field457 > 0) {
                                                                     var7 = field457 / 16;
                                                                     if (field458 >= 0) {
                                                                        var4 = field458 - class285.cameraYaw & 2047;
                                                                        var8 = Rasterizer3D.Rasterizer3D_sine[var4];
                                                                        var9 = Rasterizer3D.Rasterizer3D_cosine[var4];
                                                                        class245.oculusOrbFocalPointX += var8 * var7 / 65536;
                                                                        UserComparator10.oculusOrbFocalPointY += var9 * var7 / 65536;
                                                                     }

                                                                     if (field399 != 0) {
                                                                        Ignored.field3716 += var7 * field399;
                                                                        if (Ignored.field3716 > 0) {
                                                                           Ignored.field3716 = 0;
                                                                        }
                                                                     }
                                                                  } else {
                                                                     field458 = -1;
                                                                     field399 = -1;
                                                                  }

                                                                  if (keyHandlerInstance.getKeyPressed(13)) {
                                                                     packetWriter.addNode(Renderable.getPacketBufferNode(ClientPacket.field2527, packetWriter.isaacCipher));
                                                                     oculusOrbState = 0;
                                                                  }
                                                               }

                                                               if (MouseHandler.MouseHandler_currentButton == 4 && ClanMate.mouseCam) {
                                                                  var4 = MouseHandler.MouseHandler_y - mouseCamClickedY;
                                                                  camAngleDX = var4 * 2;
                                                                  mouseCamClickedY = var4 != -1 && var4 != 1 ? (mouseCamClickedY + MouseHandler.MouseHandler_y) / 2 : MouseHandler.MouseHandler_y * 361628717 * -278205531;
                                                                  var5 = mouseCamClickedX - MouseHandler.MouseHandler_x;
                                                                  camAngleDY = var5 * 2;
                                                                  mouseCamClickedX = var5 != -1 && var5 != 1 ? (mouseCamClickedX + MouseHandler.MouseHandler_x) / 2 : MouseHandler.MouseHandler_x * -1498866663 * -477200343;
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

                                                               if (field631) {
                                                                  BoundaryObject.method1300();
                                                               } else if (isCameraLocked) {
                                                                  var4 = Occluder.cameraMoveToX * 128 + 64;
                                                                  var5 = class108.cameraMoveToY * 128 + 64;
                                                                  var6 = GrandExchangeOfferNameComparator.getTileHeight(var4, var5, class103.Client_plane) - class10.cameraMoveToHeight;
                                                                  class275.method1525(var4, var6, var5);
                                                                  var4 = WorldMapData_0.cameraLookAtX * 128 + 64;
                                                                  var5 = Players.cameraLookAtY * 128 + 64;
                                                                  var6 = GrandExchangeOfferNameComparator.getTileHeight(var4, var5, class103.Client_plane) - FloorOverlayDefinition.cameraLookAtHeight;
                                                                  var7 = var4 - ClanSettings.cameraX;
                                                                  var8 = var6 - UserComparator10.cameraY;
                                                                  var9 = var5 - class366.cameraZ;
                                                                  var10 = (int)Math.sqrt((double)(var7 * var7 + var9 * var9));
                                                                  var11 = (int)(Math.atan2((double)var8, (double)var10) * 325.9490051269531D) & 2047;
                                                                  var12 = (int)(Math.atan2((double)var7, (double)var9) * -325.9490051269531D) & 2047;
                                                                  FloorOverlayDefinition.method1048(var11, var12);
                                                               }

                                                               for(var4 = 0; var4 < 5; ++var4) {
                                                                  ++cameraShakeCycle[var4];
                                                               }

                                                               class9.varcs.tryWrite();
                                                               var4 = class133.method728();
                                                               var5 = GameEngine.keyHandler.getIdleCycles();
                                                               PacketBufferNode var27;
                                                               if (var4 > 15000 && var5 > 15000) {
                                                                  logoutTimer = 250;
                                                                  MouseHandler.MouseHandler_idleCycles = 14500;
                                                                  var27 = Renderable.getPacketBufferNode(ClientPacket.field2508, packetWriter.isaacCipher);
                                                                  packetWriter.addNode(var27);
                                                               }

                                                               WorldMapElement.friendSystem.processFriendUpdates();

                                                               for(var7 = 0; var7 < field661.size(); ++var7) {
                                                                  if (class70.method420((Integer)field661.get(var7)) != 2) {
                                                                     field661.remove(var7);
                                                                     --var7;
                                                                  }
                                                               }

                                                               ++packetWriter.pendingWrites;
                                                               if (packetWriter.pendingWrites > 50) {
                                                                  var27 = Renderable.getPacketBufferNode(ClientPacket.field2466, packetWriter.isaacCipher);
                                                                  packetWriter.addNode(var27);
                                                               }

                                                               try {
                                                                  packetWriter.flush();
                                                               } catch (IOException var28) {
                                                                  WorldMapManager.method1404();
                                                               }

                                                               return;
                                                            }
                                                         } while(var46 == null);
                                                      } while(var46.field1818 == null);

                                                      if (var46.field1818.childIndex < 0) {
                                                         break;
                                                      }

                                                      var43 = class133.getWidget(var46.field1818.parentId);
                                                   } while(var43 == null || var43.children == null || var43.children.length == 0 || var46.field1818.childIndex >= var43.children.length || var46.field1818 != var43.children[var46.field1818.childIndex]);

                                                   if (var46.field1818.type == 11 && var46.field1815 == 0) {
                                                      switch(var46.field1818.method1741()) {
                                                      case 0:
                                                         AttackOption.openURL(var46.field1818.method1748(), true, false);
                                                         break;
                                                      case 1:
                                                         if (NewShit.method952(class173.getWidgetFlags(var46.field1818))) {
                                                            int[] var45 = var46.field1818.method1751();
                                                            if (var45 != null) {
                                                               var18 = Renderable.getPacketBufferNode(ClientPacket.field2532, packetWriter.isaacCipher);
                                                               var18.packetBuffer.method2441(var45[2]);
                                                               var18.packetBuffer.method2414(var45[1]);
                                                               var18.packetBuffer.writeInt(var46.field1818.method1757());
                                                               var18.packetBuffer.method2382(var46.field1818.id);
                                                               var18.packetBuffer.writeShortLEA(var46.field1818.childIndex);
                                                               var18.packetBuffer.method2414(var45[0]);
                                                               packetWriter.addNode(var18);
                                                            }
                                                         }
                                                      }
                                                   } else if (var46.field1818.type == 12) {
                                                      class307 var44 = var46.field1818.method1750();
                                                      if (var44 != null && var44.method1663()) {
                                                         switch(var46.field1815) {
                                                         case 0:
                                                            field617.method1065(var46.field1818);
                                                            var44.method1708(true);
                                                            var44.method1671(var46.field1816, var46.field1817, keyHandlerInstance.getKeyPressed(82), keyHandlerInstance.getKeyPressed(81));
                                                            break;
                                                         case 1:
                                                            var44.method1706(var46.field1816, var46.field1817);
                                                         }
                                                      }
                                                   }
                                                }
                                             }
                                          }

                                          var43 = var25.widget;
                                          if (var43.childIndex < 0) {
                                             break;
                                          }

                                          var42 = class133.getWidget(var43.parentId);
                                       } while(var42 == null || var42.children == null || var43.childIndex >= var42.children.length || var43 != var42.children[var43.childIndex]);

                                       WorldMapAreaData.runScriptEvent(var25);
                                    }
                                 }

                                 var43 = var25.widget;
                                 if (var43.childIndex < 0) {
                                    break;
                                 }

                                 var42 = class133.getWidget(var43.parentId);
                              } while(var42 == null || var42.children == null || var43.childIndex >= var42.children.length || var43 != var42.children[var43.childIndex]);

                              WorldMapAreaData.runScriptEvent(var25);
                           }
                        }

                        var43 = var25.widget;
                        if (var43.childIndex < 0) {
                           break;
                        }

                        var42 = class133.getWidget(var43.parentId);
                     } while(var42 == null || var42.children == null || var43.childIndex >= var42.children.length || var43 != var42.children[var43.childIndex]);

                     WorldMapAreaData.runScriptEvent(var25);
                  }
               }

               var31 = Renderable.getPacketBufferNode(ClientPacket.field2500, packetWriter.isaacCipher);
               var31.packetBuffer.writeByte(0);
               var3 = var31.packetBuffer.offset;
               ClanChannel.performReflectionCheck(var31.packetBuffer);
               var31.packetBuffer.method2434(var31.packetBuffer.offset - var3);
               packetWriter.addNode(var31);
            }
         }
      }
   }

   @ObfuscatedName("gm")
   @ObfuscatedSignature(
           descriptor = "(I)V",
           garbageValue = "-1406120481"
   )
   void resizeJS() {
      int var1 = GameEngine.canvasWidth;
      int var2 = class127.canvasHeight;
      if (super.contentWidth < var1) {
         var1 = super.contentWidth;
      }

      if (super.contentHeight < var2) {
         var2 = super.contentHeight;
      }

      if (PacketWriter.clientPreferences != null) {
         try {
            Client var3 = Decimator.client;
            Object[] var4 = new Object[]{Message.getWindowedMode()};
            //JSObject.getWindow(var3).call("resize", var4);
         } catch (Throwable var5) {
            ;
         }
      }

   }

   @ObfuscatedName("gu")
   @ObfuscatedSignature(
           descriptor = "(I)V",
           garbageValue = "551347183"
   )
   final void drawLoggedIn() {
      int var1;
      if (rootInterface != -1) {
         var1 = rootInterface;
         if (class153.loadInterface(var1)) {
            class390.drawModelComponents(WorldMapLabel.Widget_interfaceComponents[var1], -1);
         }
      }

      for(var1 = 0; var1 < rootWidgetCount; ++var1) {
         if (field591[var1]) {
            field546[var1] = true;
         }

         field428[var1] = field591[var1];
         field591[var1] = false;
      }

      field590 = cycle;
      viewportX = -1;
      viewportY = -1;
      class157.hoveredItemContainer = null;
      if (rootInterface != -1) {
         rootWidgetCount = 0;
         class97.drawWidgets(rootInterface, 0, 0, GameEngine.canvasWidth, class127.canvasHeight, 0, 0, -1);
      }

      Rasterizer2D.Rasterizer2D_resetClip();
      if (showMouseCross) {
         if (mouseCrossColor == 1) {
            Calendar.crossSprites[mouseCrossState / 100].drawTransBgAt(mouseCrossX - 8, mouseCrossY - 8);
         }

         if (mouseCrossColor == 2) {
            Calendar.crossSprites[mouseCrossState / 100 + 4].drawTransBgAt(mouseCrossX - 8, mouseCrossY - 8);
         }
      }

      if (!isMenuOpen) {
         if (viewportX != -1) {
            var1 = viewportX;
            int var2 = viewportY;
            if ((menuOptionsCount >= 2 || isItemSelected != 0 || isSpellSelected) && showMouseOverText) {
               int var3 = menuOptionsCount - 1;
               String var5;
               if (isItemSelected == 1 && menuOptionsCount < 2) {
                  var5 = "Use" + " " + selectedItemName + " " + "->";
               } else if (isSpellSelected && menuOptionsCount < 2) {
                  var5 = selectedSpellActionName + " " + selectedSpellName + " " + "->";
               } else {
                  var5 = TriBool.method2128(var3);
               }

               if (menuOptionsCount > 2) {
                  var5 = var5 + class149.colorStartTag(16777215) + " " + '/' + " " + (menuOptionsCount - 2) + " more options";
               }

               class19.fontBold12.drawRandomAlphaAndSpacing(var5, var1 + 4, var2 + 15, 16777215, 0, cycle / 1000);
            }
         }
      } else {
         StructComposition.method999();
      }

      if (gameDrawingMode == 3) {
         for(var1 = 0; var1 < rootWidgetCount; ++var1) {
            if (field428[var1]) {
               Rasterizer2D.Rasterizer2D_fillRectangleAlpha(rootWidgetXs[var1], rootWidgetYs[var1], rootWidgetWidths[var1], rootWidgetHeights[var1], 16711935, 128);
            } else if (field546[var1]) {
               Rasterizer2D.Rasterizer2D_fillRectangleAlpha(rootWidgetXs[var1], rootWidgetYs[var1], rootWidgetWidths[var1], rootWidgetHeights[var1], 16711680, 128);
            }
         }
      }

      class12.method50(class103.Client_plane, class387.localPlayer.x, class387.localPlayer.y, field442);
      field442 = 0;
   }

   @ObfuscatedName("hg")
   @ObfuscatedSignature(
      descriptor = "(Ldb;IB)Z",
      garbageValue = "-1"
   )
   boolean method371(PacketWriter var1, int var2) {
      if (var1.serverPacketLength == 0) {
         class463.friendsChat = null;
      } else {
         if (class463.friendsChat == null) {
            class463.friendsChat = new FriendsChat(WorldMapCacheName.loginType, Decimator.client);
         }

         class463.friendsChat.method2072(var1.packetBuffer, var2);
      }

      class138.method745();
      var1.serverPacket = null;
      return true;
   }

   @ObfuscatedName("hh")
   @ObfuscatedSignature(
      descriptor = "(Ldb;I)Z",
      garbageValue = "270594437"
   )
   boolean method354(PacketWriter var1) {
      if (class463.friendsChat != null) {
         class463.friendsChat.method2070(var1.packetBuffer);
      }

      class138.method745();
      var1.serverPacket = null;
      return true;
   }

   @ObfuscatedName("ij")
   @ObfuscatedSignature(
      descriptor = "(Ldb;I)Z",
      garbageValue = "897974344"
   )
   final boolean method367(PacketWriter var1) {
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
               if (var1.field1129) {
                  if (!var2.isAvailable(1)) {
                     return false;
                  }

                  var2.read(var1.packetBuffer.array, 0, 1);
                  var1.field1130 = 0;
                  var1.field1129 = false;
               }

               var3.offset = 0;
               if (var3.method2367()) {
                  if (!var2.isAvailable(1)) {
                     return false;
                  }

                  var2.read(var1.packetBuffer.array, 1, 1);
                  var1.field1130 = 0;
               }

               var1.field1129 = true;
               ServerPacket[] var4 = ObjTypeCustomisation.ServerPacket_values();
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
            var1.field1130 = 0;
            timer.method2023();
            var1.field1134 = var1.field1133;
            var1.field1133 = var1.field1137;
            var1.field1137 = var1.serverPacket;
            if (ServerPacket.field2572 == var1.serverPacket) {
               KeyHandler.field86 = var3.readUnsignedShortA();
               class373.field3599 = var3.readUnsignedByte();
               var1.serverPacket = null;
               return true;
            }

            int var20;
            String var54;
            boolean var73;
            if (ServerPacket.field2591 == var1.serverPacket) {
               var20 = var3.readUShortSmart();
               var73 = var3.readUnsignedByte() == 1;
               var54 = "";
               boolean var69 = false;
               if (var73) {
                  var54 = var3.readStringCp1252NullTerminated();
                  if (WorldMapElement.friendSystem.isIgnored(new Username(var54, WorldMapCacheName.loginType))) {
                     var69 = true;
                  }
               }

               String var60 = var3.readStringCp1252NullTerminated();
               if (!var69) {
                  ZoneOperation.addGameMessage(var20, var54, var60);
               }

               var1.serverPacket = null;
               return true;
            }

            Widget var53;
            if (ServerPacket.field2655 == var1.serverPacket) {
               var20 = var3.readInt();
               var73 = var3.method2401() == 1;
               var53 = class133.getWidget(var20);
               if (var73 != var53.isHidden) {
                  var53.isHidden = var73;
                  LoginScreenAnimation.invalidateWidget(var53);
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2673 == var1.serverPacket) {
               var20 = var3.readUnsignedShort();
               var5 = var3.readUnsignedByte();
               var21 = var3.readUnsignedShort();
               class275.queueSoundEffect(var20, var5, var21);
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

            Widget var76;
            if (ServerPacket.field2639 == var1.serverPacket) {
               var20 = var3.readUnsignedShortLEA();
               var5 = var3.readUnsignedShort();
               var21 = var3.method2415();
               var76 = class133.getWidget(var21);
               var76.rotationKey = var5 + (var20 << 16);
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2661 == var1.serverPacket) {
               class277.loadRegions(false, var1.packetBuffer);
               var1.serverPacket = null;
               return true;
            }

            boolean var93;
            if (ServerPacket.field2626 == var1.serverPacket) {
               var93 = var3.readUnsignedByte() == 1;
               if (var93) {
                  class361.field3568 = class153.clockNow() - var3.readLong();
                  EnumComposition.grandExchangeEvents = new GrandExchangeEvents(var3, true);
               } else {
                  EnumComposition.grandExchangeEvents = null;
               }

               field668 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            int var7;
            int var9;
            int var10;
            int var12;
            int var13;
            int var14;
            int var15;
            int var16;
            int var17;
            int var18;
            Projectile var19;
            int var23;
            byte var62;
            int var64;
            byte var66;
            if (ServerPacket.field2665 == var1.serverPacket) {
               var62 = var3.method2431();
               var14 = var3.method2401() * 4;
               var66 = var3.method2442();
               var18 = var3.method2401();
               var13 = var3.method2401() * 4;
               var15 = var3.readUnsignedShort();
               var17 = var3.readUnsignedByte();
               var12 = var3.readUnsignedShortLE();
               var16 = var3.readUnsignedShortLE();
               var21 = var3.method2412();
               var20 = var21 >> 16;
               var5 = var21 >> 8 & 255;
               var7 = var20 + (var21 >> 4 & 7);
               var23 = var5 + (var21 & 7);
               var64 = var3.method2409();
               var9 = var66 + var7;
               var10 = var62 + var23;
               if (var7 >= 0 && var23 >= 0 && var7 < 104 && var23 < 104 && var9 >= 0 && var10 >= 0 && var9 < 104 && var10 < 104 && var12 != 65535) {
                  var7 = var7 * 128 + 64;
                  var23 = var23 * 128 + 64;
                  var9 = var9 * 128 + 64;
                  var10 = var10 * 128 + 64;
                  var19 = new Projectile(var12, class103.Client_plane, var7, var23, GrandExchangeOfferNameComparator.getTileHeight(var7, var23, class103.Client_plane) - var13, var15 + cycle, var16 + cycle, var17, var18, var64, var14);
                  var19.setDestination(var9, var10, GrandExchangeOfferNameComparator.getTileHeight(var9, var10, class103.Client_plane) - var14, var15 + cycle);
                  projectiles.addFirst(var19);
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2594 == var1.serverPacket) {
               var66 = var3.method2442();
               var18 = var3.readUnsignedShortA();
               var15 = var3.readUnsignedShortLEA();
               var12 = var3.readUnsignedShort();
               var17 = var3.method2401();
               var21 = var3.method2412();
               var20 = var21 >> 16;
               var5 = var21 >> 8 & 255;
               var7 = var20 + (var21 >> 4 & 7);
               var23 = var5 + (var21 & 7);
               var64 = var3.method2420();
               var13 = var3.readUnsignedShortA() * 4;
               var62 = var3.readByte();
               var16 = var3.readUnsignedShortLEA();
               var14 = var3.readUnsignedShortA() * 4;
               var9 = var66 + var7;
               var10 = var62 + var23;
               if (var7 >= 0 && var23 >= 0 && var7 < 104 && var23 < 104 && var9 >= 0 && var10 >= 0 && var9 < 104 && var10 < 104 && var12 != 65535) {
                  var7 = var7 * 128 + 64;
                  var23 = var23 * 128 + 64;
                  var9 = var9 * 128 + 64;
                  var10 = var10 * 128 + 64;
                  var19 = new Projectile(var12, class103.Client_plane, var7, var23, GrandExchangeOfferNameComparator.getTileHeight(var7, var23, class103.Client_plane) - var13, var15 + cycle, var16 + cycle, var17, var18, var64, var14);
                  var19.setDestination(var9, var10, GrandExchangeOfferNameComparator.getTileHeight(var9, var10, class103.Client_plane) - var14, var15 + cycle);
                  projectiles.addFirst(var19);
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2592 == var1.serverPacket) {
               if (class388.field3667 == null) {
                  class388.field3667 = new class421(MoveSpeed.HitSplatDefinition_cached);
               }

               class482 var56 = MoveSpeed.HitSplatDefinition_cached.method2197(var3);
               class388.field3667.field3802.vmethod8143(var56.field4059, var56.field4060);
               field574[++field566 - 1 & 31] = var56.field4059;
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2563 == var1.serverPacket) {
               isCameraLocked = true;
               field631 = false;
               Occluder.cameraMoveToX = var3.readUnsignedByte();
               class108.cameraMoveToY = var3.readUnsignedByte();
               class10.cameraMoveToHeight = var3.readUnsignedShort();
               ModeWhere.cameraMoveToSpeed = var3.readUnsignedByte();
               UserComparator7.cameraMoveToAcceleration = var3.readUnsignedByte();
               if (UserComparator7.cameraMoveToAcceleration >= 100) {
                  ClanSettings.cameraX = Occluder.cameraMoveToX * 128 + 64;
                  class366.cameraZ = class108.cameraMoveToY * 128 + 64;
                  UserComparator10.cameraY = GrandExchangeOfferNameComparator.getTileHeight(ClanSettings.cameraX, class366.cameraZ, class103.Client_plane) - class10.cameraMoveToHeight;
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2567 == var1.serverPacket) {
               class388.field3667 = null;
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2578 == var1.serverPacket) {
               var20 = var3.readUnsignedShortLE();
               VarpDefinition.method918(var20);
               changedItemContainers[++changedItemContainersCount - 1 & 31] = var20 & 32767;
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2623 == var1.serverPacket) {
               var20 = var3.readInt();
               InterfaceParent var86 = (InterfaceParent)interfaceParents.get((long)var20);
               if (var86 != null) {
                  class10.closeInterface(var86, true);
               }

               if (meslayerContinueWidget != null) {
                  LoginScreenAnimation.invalidateWidget(meslayerContinueWidget);
                  meslayerContinueWidget = null;
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2602 == var1.serverPacket) {
               var20 = var3.readInt();
               if (var20 != field462) {
                  field462 = var20;
                  SoundSystem.method221();
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2634 == var1.serverPacket) {
               isCameraLocked = false;

               for(var20 = 0; var20 < 5; ++var20) {
                  cameraShaking[var20] = false;
               }

               var1.serverPacket = null;
               return true;
            }

            String var50;
            if (ServerPacket.field2577 == var1.serverPacket) {
               var50 = var3.readStringCp1252NullTerminated();
               Object[] var85 = new Object[var50.length() + 1];

               for(var21 = var50.length() - 1; var21 >= 0; --var21) {
                  if (var50.charAt(var21) == 's') {
                     var85[var21 + 1] = var3.readStringCp1252NullTerminated();
                  } else {
                     var85[var21 + 1] = new Integer(var3.readInt());
                  }
               }

               var85[0] = new Integer(var3.readInt());
               ScriptEvent var65 = new ScriptEvent();
               var65.args = var85;
               WorldMapAreaData.runScriptEvent(var65);
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2606 == var1.serverPacket) {
               var20 = var3.readUnsignedShortLE();
               if (var20 == 65535) {
                  var20 = -1;
               }

               var5 = var3.method2417();
               var21 = var3.method2417();
               var76 = class133.getWidget(var21);
               ItemComposition var59;
               if (!var76.isIf3) {
                  if (var20 == -1) {
                     var76.modelType = 0;
                     var1.serverPacket = null;
                     return true;
                  }

                  var59 = TileItem.ItemDefinition_get(var20);
                  var76.modelType = 4;
                  var76.modelId = var20;
                  var76.modelAngleX = var59.xan2d;
                  var76.modelAngleY = var59.yan2d;
                  var76.modelZoom = var59.zoom2d * 100 / var5;
                  LoginScreenAnimation.invalidateWidget(var76);
               } else {
                  var76.itemId = var20;
                  var76.itemQuantity = var5;
                  var59 = TileItem.ItemDefinition_get(var20);
                  var76.modelAngleX = var59.xan2d;
                  var76.modelAngleY = var59.yan2d;
                  var76.modelAngleZ = var59.zan2d;
                  var76.modelOffsetX = var59.offsetX2d;
                  var76.modelOffsetY = var59.offsetY2d;
                  var76.modelZoom = var59.zoom2d;
                  if (var59.isStackable == 1) {
                     var76.itemQuantityMode = 1;
                  } else {
                     var76.itemQuantityMode = 2;
                  }

                  if (var76.modelRotation > 0) {
                     var76.modelZoom = var76.modelZoom * 32 / var76.modelRotation;
                  } else if (var76.rawWidth > 0) {
                     var76.modelZoom = var76.modelZoom * 32 / var76.rawWidth;
                  }

                  LoginScreenAnimation.invalidateWidget(var76);
               }

               var1.serverPacket = null;
               return true;
            }

            GameObject var32;
            String var33;
            byte var84;
            if (ServerPacket.field2599 == var1.serverPacket) {
               var84 = var3.readByte();
               var24 = var3.readStringCp1252NullTerminated();
               long var25 = (long)var3.readUnsignedShort();
               long var27 = (long)var3.readMedium();
               PlayerType var88 = (PlayerType)class4.findEnumerated(ArchiveLoader.PlayerType_values(), var3.readUnsignedByte());
               long var30 = var27 + (var25 << 32);
               boolean var68 = false;
               var32 = null;
               ClanChannel var92 = var84 >= 0 ? currentClanChannels[var84] : class482.guestClanChannel;
               if (var92 == null) {
                  var68 = true;
               } else {
                  var15 = 0;

                  while(true) {
                     if (var15 >= 100) {
                        if (var88.isUser && WorldMapElement.friendSystem.isIgnored(new Username(var24, WorldMapCacheName.loginType))) {
                           var68 = true;
                        }
                        break;
                     }

                     if (var30 == crossWorldMessageIds[var15]) {
                        var68 = true;
                        break;
                     }

                     ++var15;
                  }
               }

               if (!var68) {
                  crossWorldMessageIds[crossWorldMessageIdsIndex] = var30;
                  crossWorldMessageIdsIndex = (crossWorldMessageIdsIndex + 1) % 100;
                  var33 = AbstractFont.escapeBrackets(class163.readString(var3));
                  var16 = var84 >= 0 ? 41 : 44;
                  if (var88.modIcon != -1) {
                     class134.addChatMessage(var16, ObjectSound.addImageTag(var88.modIcon) + var24, var33, var92.name);
                  } else {
                     class134.addChatMessage(var16, var24, var33, var92.name);
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2658 == var1.serverPacket) {
               return this.method371(var1, 1);
            }

            if (ServerPacket.field2668 == var1.serverPacket) {
               Decimator.processZoneOperation(ZoneOperation.field2546);
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2576 == var1.serverPacket) {
               var20 = var3.readUnsignedByte();
               if (var3.readUnsignedByte() == 0) {
                  grandExchangeOffers[var20] = new GrandExchangeOffer();
                  var3.offset += 18;
               } else {
                  --var3.offset;
                  grandExchangeOffers[var20] = new GrandExchangeOffer(var3, false);
               }

               field580 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2653 == var1.serverPacket) {
               var5 = var3.readUnsignedShortLEA();
               var20 = var3.readUnsignedByteS();
               Player var77;
               if (var20 == localPlayerIndex) {
                  var77 = class387.localPlayer;
               } else {
                  var77 = players[var20];
               }

               var21 = var3.method2417();
               if (var77 != null) {
                  var77.spotAnimation = var5;
                  var77.spotAnimHeight = var21 >> 16;
                  var77.spotAnimationStartCycle = (var21 & '\uffff') + cycle;
                  var77.spotAnimationFrame = 0;
                  var77.spotAnimFrameCycle = 0;
                  if (var77.spotAnimationStartCycle > cycle) {
                     var77.spotAnimationFrame = -1;
                  }

                  if (var77.spotAnimation == 65535) {
                     var77.spotAnimation = -1;
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2597 == var1.serverPacket) {
               Decimator.processZoneOperation(ZoneOperation.field2543);
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2624 == var1.serverPacket) {
               var20 = var3.readInt();
               var5 = var3.readUnsignedShortLE();
               var53 = class133.getWidget(var20);
               if (var53.modelType != 2 || var5 != var53.modelId) {
                  var53.modelType = 2;
                  var53.modelId = var5;
                  LoginScreenAnimation.invalidateWidget(var53);
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2614 == var1.serverPacket) {
               Decimator.processZoneOperation(ZoneOperation.field2550);
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2595 == var1.serverPacket) {
               Decimator.processZoneOperation(ZoneOperation.field2540);
               var1.serverPacket = null;
               return true;
            }

            long var34;
            InterfaceParent var74;
            if (ServerPacket.field2652 == var1.serverPacket) {
               var20 = var3.offset + var1.serverPacketLength;
               var5 = var3.readUnsignedShort();
               var21 = var3.readUnsignedShort();
               if (var5 != rootInterface) {
                  rootInterface = var5;
                  this.resizeRoot(false);
                  class155.Widget_resetModelFrames(rootInterface);
                  SoundCache.runWidgetOnLoadListener(rootInterface);

                  for(var7 = 0; var7 < 100; ++var7) {
                     field591[var7] = true;
                  }
               }

               InterfaceParent var87;
               for(; var21-- > 0; var87.field854 = true) {
                  var7 = var3.readInt();
                  var23 = var3.readUnsignedShort();
                  var9 = var3.readUnsignedByte();
                  var87 = (InterfaceParent)interfaceParents.get((long)var7);
                  if (var87 != null && var23 != var87.group) {
                     class10.closeInterface(var87, true);
                     var87 = null;
                  }

                  if (var87 == null) {
                     var87 = ModeWhere.ifOpenSub(var7, var23, var9);
                  }
               }

               for(var74 = (InterfaceParent)interfaceParents.first(); var74 != null; var74 = (InterfaceParent)interfaceParents.next()) {
                  if (var74.field854) {
                     var74.field854 = false;
                  } else {
                     class10.closeInterface(var74, true);
                  }
               }

               widgetFlags = new NodeHashTable(512);

               while(var3.offset < var20) {
                  var7 = var3.readInt();
                  var23 = var3.readUnsignedShort();
                  var9 = var3.readUnsignedShort();
                  var10 = var3.readInt();

                  for(var64 = var23; var64 <= var9; ++var64) {
                     var34 = ((long)var7 << 32) + (long)var64;
                     widgetFlags.put(new IntegerNode(var10), var34);
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            NPC var75;
            if (ServerPacket.field2650 == var1.serverPacket) {
               var20 = var3.readUnsignedShort();
               var5 = var3.readUnsignedByteS();
               var21 = var3.readUnsignedByte();
               if (var5 == 65535) {
                  var5 = -1;
               }

               var75 = npcs[var20];
               if (var75 != null) {
                  if (var5 == var75.sequence && var5 != -1) {
                     var23 = class85.SequenceDefinition_get(var5).replyMode;
                     if (var23 == 1) {
                        var75.sequenceFrame = 0;
                        var75.sequenceFrameCycle = 0;
                        var75.sequenceDelay = var21;
                        var75.currentSequenceFrameIndex = 0;
                     } else if (var23 == 2) {
                        var75.currentSequenceFrameIndex = 0;
                     }
                  } else if (var5 == -1 || var75.sequence == -1 || class85.SequenceDefinition_get(var5).forcedPriority >= class85.SequenceDefinition_get(var75.sequence).forcedPriority) {
                     var75.sequence = var5;
                     var75.sequenceFrame = 0;
                     var75.sequenceFrameCycle = 0;
                     var75.sequenceDelay = var21;
                     var75.currentSequenceFrameIndex = 0;
                     var75.field1006 = var75.pathLength;
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2618 == var1.serverPacket) {
               field561 = cycleCntr;
               var84 = var3.readByte();
               class156 var83 = new class156(var3);
               ClanChannel var61;
               if (var84 >= 0) {
                  var61 = currentClanChannels[var84];
               } else {
                  var61 = class482.guestClanChannel;
               }

               var83.method832(var61);
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2654 == var1.serverPacket) {
               ClientPacket.updateNpcs(false, var3);
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2631 == var1.serverPacket) {
               field561 = cycleCntr;
               var84 = var3.readByte();
               if (var1.serverPacketLength == 1) {
                  if (var84 >= 0) {
                     currentClanChannels[var84] = null;
                  } else {
                     class482.guestClanChannel = null;
                  }

                  var1.serverPacket = null;
                  return true;
               }

               if (var84 >= 0) {
                  currentClanChannels[var84] = new ClanChannel(var3);
               } else {
                  class482.guestClanChannel = new ClanChannel(var3);
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2670 == var1.serverPacket) {
               var64 = var3.readUnsignedShort();
               var10 = var3.readUnsignedShortA();
               var9 = var3.readUnsignedByteS();
               var21 = var3.method2439();
               var20 = var21 >> 16;
               var5 = var21 >> 8 & 255;
               var7 = var20 + (var21 >> 4 & 7);
               var23 = var5 + (var21 & 7);
               if (var7 >= 0 && var23 >= 0 && var7 < 104 && var23 < 104) {
                  var7 = var7 * 128 + 64;
                  var23 = var23 * 128 + 64;
                  GraphicsObject var94 = new GraphicsObject(var9, class103.Client_plane, var7, var23, GrandExchangeOfferNameComparator.getTileHeight(var7, var23, class103.Client_plane) - var10, var64, cycle);
                  graphicsObjects.addFirst(var94);
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2586 == var1.serverPacket) {
               return this.method354(var1);
            }

            if (ServerPacket.field2651 == var1.serverPacket) {
               class310.updatePlayers(var3, var1.serverPacketLength);
               GameObject.method1308();
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2562 == var1.serverPacket) {
               class323.isLargePlayerInfo = true;
               class310.updatePlayers(var3, var1.serverPacketLength);
               GameObject.method1308();
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2566 == var1.serverPacket) {
               ClientPacket.updateNpcs(true, var3);
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2598 == var1.serverPacket) {
               class288.privateChatMode = NewShit.method955(var3.readUnsignedByte());
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2638 == var1.serverPacket) {
               var3.offset += 28;
               if (var3.checkCrc()) {
                  class10.method37(var3, var3.offset - 28);
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2627 == var1.serverPacket) {
               World var55 = new World();
               var55.host = var3.readStringCp1252NullTerminated();
               var55.id = var3.readUnsignedShort();
               var5 = var3.readInt();
               var55.properties = var5;
               class246.updateGameState(45);
               var2.close();
               var2 = null;
               VarbitComposition.changeWorld(var55);
               var1.serverPacket = null;
               return false;
            }

            if (ServerPacket.field2646 == var1.serverPacket) {
               var20 = var3.readUnsignedByteS();
               var5 = var3.readInt();
               var53 = class133.getWidget(var5);
               if (var53.modelType != 1 || var20 != var53.modelId) {
                  var53.modelType = 1;
                  var53.modelId = var20;
                  LoginScreenAnimation.invalidateWidget(var53);
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2581 == var1.serverPacket) {
               HealthBarDefinition.logOut();
               var1.serverPacket = null;
               return false;
            }

            if (ServerPacket.field2615 == var1.serverPacket) {
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2664 == var1.serverPacket) {
               KeyHandler.field86 = var3.readUnsignedShortA();
               class373.field3599 = var3.readUnsignedShortA();

               while(var3.offset < var1.serverPacketLength) {
                  var20 = var3.readUnsignedByte();
                  ZoneOperation var82 = class27.method108()[var20];
                  Decimator.processZoneOperation(var82);
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2587 == var1.serverPacket) {
               var20 = var3.readUnsignedByteS();
               short var72 = (short)var3.method2408();
               var21 = var3.readUnsignedShortA();
               var7 = var3.method2417();
               NPC var57 = npcs[var20];
               if (var57 != null) {
                  var57.method564(var21, var7, var72);
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2604 == var1.serverPacket) {
               isCameraLocked = true;
               field631 = false;
               WorldMapData_0.cameraLookAtX = var3.readUnsignedByte();
               Players.cameraLookAtY = var3.readUnsignedByte();
               FloorOverlayDefinition.cameraLookAtHeight = var3.readUnsignedShort();
               Message.cameraLookAtSpeed = var3.readUnsignedByte();
               AttackOption.cameraLookAtAcceleration = var3.readUnsignedByte();
               if (AttackOption.cameraLookAtAcceleration >= 100) {
                  var20 = WorldMapData_0.cameraLookAtX * 128 + 64;
                  var5 = Players.cameraLookAtY * 128 + 64;
                  var21 = GrandExchangeOfferNameComparator.getTileHeight(var20, var5, class103.Client_plane) - FloorOverlayDefinition.cameraLookAtHeight;
                  var7 = var20 - ClanSettings.cameraX;
                  var23 = var21 - UserComparator10.cameraY;
                  var9 = var5 - class366.cameraZ;
                  var10 = (int)Math.sqrt((double)(var7 * var7 + var9 * var9));
                  class103.cameraPitch = (int)(Math.atan2((double)var23, (double)var10) * 325.9490051269531D) & 2047;
                  class285.cameraYaw = (int)(Math.atan2((double)var7, (double)var9) * -325.9490051269531D) & 2047;
                  if (class103.cameraPitch < 128) {
                     class103.cameraPitch = 128;
                  }

                  if (class103.cameraPitch > 383) {
                     class103.cameraPitch = 383;
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2611 == var1.serverPacket) {
               SoundCache.method225();
               var84 = var3.readByte();
               if (var1.serverPacketLength == 1) {
                  if (var84 >= 0) {
                     currentClanSettings[var84] = null;
                  } else {
                     DynamicObject.guestClanSettings = null;
                  }

                  var1.serverPacket = null;
                  return true;
               }

               if (var84 >= 0) {
                  currentClanSettings[var84] = new ClanSettings(var3);
               } else {
                  DynamicObject.guestClanSettings = new ClanSettings(var3);
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2564 == var1.serverPacket) {
               class123.process();
               weight = var3.readShort();
               field625 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2648 == var1.serverPacket) {
               if (rootInterface != -1) {
                  class147.runIntfCloseListeners(rootInterface, 0);
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2583 == var1.serverPacket) {
               var20 = var3.method2415();
               var5 = var3.method2408();
               var21 = var3.method2408();
               var76 = class133.getWidget(var20);
               if (var5 != var76.rawX || var21 != var76.rawY || var76.xAlignment != 0 || var76.yAlignment != 0) {
                  var76.rawX = var5;
                  var76.rawY = var21;
                  var76.xAlignment = 0;
                  var76.yAlignment = 0;
                  LoginScreenAnimation.invalidateWidget(var76);
                  this.alignWidget(var76);
                  if (var76.type == 0) {
                     AbstractWorldMapData.revalidateWidgetScroll(WorldMapLabel.Widget_interfaceComponents[var20 >> 16], var76, false);
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2580 == var1.serverPacket) {
               return this.method371(var1, 2);
            }

            if (ServerPacket.field2643 == var1.serverPacket) {
               minimapState = var3.readUnsignedByte();
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2656 == var1.serverPacket) {
               var20 = var3.readUnsignedByteS();
               byte var71 = var3.method2404();
               Varps.Varps_temp[var20] = var71;
               if (Varps.Varps_main[var20] != var71) {
                  Varps.Varps_main[var20] = var71;
               }

               ReflectionCheck.changeGameOptions(var20);
               changedVarps[++changedVarpCount - 1 & 31] = var20;
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2632 == var1.serverPacket) {
               WorldMapElement.friendSystem.readUpdate(var3, var1.serverPacketLength);
               field577 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2579 == var1.serverPacket) {
               NewShit.method954(var3.readStringCp1252NullTerminated());
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2565 == var1.serverPacket) {
               Decimator.processZoneOperation(ZoneOperation.field2551);
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2645 == var1.serverPacket) {
               var50 = var3.readStringCp1252NullTerminated();
               var24 = AbstractFont.escapeBrackets(ParamComposition.method994(class163.readString(var3)));
               ZoneOperation.addGameMessage(6, var50, var24);
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2608 == var1.serverPacket) {
               var20 = var3.readUnsignedByte();
               UrlRequest.method645(var20);
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2644 == var1.serverPacket) {
               var93 = var3.readBoolean();
               if (var93) {
                  if (class136.field1293 == null) {
                     class136.field1293 = new class347();
                  }
               } else {
                  class136.field1293 = null;
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2589 == var1.serverPacket) {
               class277.loadRegions(true, var1.packetBuffer);
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2663 == var1.serverPacket) {
               var20 = var3.readUnsignedShort();
               if (var20 == 65535) {
                  var20 = -1;
               }

               SpriteMask.playSong(var20);
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2609 == var1.serverPacket) {
               var20 = var3.readMedium();
               var5 = var3.readUnsignedByteS();
               if (var5 == 65535) {
                  var5 = -1;
               }

               ScriptEvent.playJingle(var5, var20);
               var1.serverPacket = null;
               return true;
            }

            long var37;
            long var39;
            String var44;
            if (ServerPacket.field2584 == var1.serverPacket) {
               var50 = var3.readStringCp1252NullTerminated();
               var37 = (long)var3.readUnsignedShort();
               var39 = (long)var3.readMedium();
               PlayerType var41 = (PlayerType)class4.findEnumerated(ArchiveLoader.PlayerType_values(), var3.readUnsignedByte());
               long var42 = var39 + (var37 << 32);
               boolean var63 = false;

               for(var13 = 0; var13 < 100; ++var13) {
                  if (var42 == crossWorldMessageIds[var13]) {
                     var63 = true;
                     break;
                  }
               }

               if (WorldMapElement.friendSystem.isIgnored(new Username(var50, WorldMapCacheName.loginType))) {
                  var63 = true;
               }

               if (!var63 && field494 == 0) {
                  crossWorldMessageIds[crossWorldMessageIdsIndex] = var42;
                  crossWorldMessageIdsIndex = (crossWorldMessageIdsIndex + 1) % 100;
                  var44 = AbstractFont.escapeBrackets(ParamComposition.method994(class163.readString(var3)));
                  byte var70;
                  if (var41.isPrivileged) {
                     var70 = 7;
                  } else {
                     var70 = 3;
                  }

                  if (var41.modIcon != -1) {
                     ZoneOperation.addGameMessage(var70, ObjectSound.addImageTag(var41.modIcon) + var50, var44);
                  } else {
                     ZoneOperation.addGameMessage(var70, var50, var44);
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2621 == var1.serverPacket) {
               var20 = var3.readUnsignedShort();
               var75 = npcs[var20];
               var21 = var3.readUnsignedShortLE();
               var5 = var3.method2416();
               if (var75 != null) {
                  var75.spotAnimation = var21;
                  var75.spotAnimHeight = var5 >> 16;
                  var75.spotAnimationStartCycle = (var5 & '\uffff') + cycle;
                  var75.spotAnimationFrame = 0;
                  var75.spotAnimFrameCycle = 0;
                  if (var75.spotAnimationStartCycle > cycle) {
                     var75.spotAnimationFrame = -1;
                  }

                  if (var75.spotAnimation == 65535) {
                     var75.spotAnimation = -1;
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2607 == var1.serverPacket) {
               var20 = var3.readUnsignedShortLE();
               rootInterface = var20;
               this.resizeRoot(false);
               class155.Widget_resetModelFrames(var20);
               SoundCache.runWidgetOnLoadListener(rootInterface);

               for(var5 = 0; var5 < 100; ++var5) {
                  field591[var5] = true;
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2642 == var1.serverPacket) {
               var50 = var3.readStringCp1252NullTerminated();
               var5 = var3.method2416();
               var53 = class133.getWidget(var5);
               if (!var50.equals(var53.text)) {
                  var53.text = var50;
                  LoginScreenAnimation.invalidateWidget(var53);
               }

               var1.serverPacket = null;
               return true;
            }

            Widget var81;
            if (ServerPacket.field2613 == var1.serverPacket) {
               var20 = var3.method2416();
               var81 = class133.getWidget(var20);

               for(var21 = 0; var21 < var81.itemIds.length; ++var21) {
                  var81.itemIds[var21] = -1;
                  var81.itemIds[var21] = 0;
               }

               LoginScreenAnimation.invalidateWidget(var81);
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2560 == var1.serverPacket) {
               Decimator.processZoneOperation(ZoneOperation.field2539);
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2561 == var1.serverPacket) {
               var20 = var3.method2417();
               var81 = class133.getWidget(var20);
               var81.modelType = 3;
               var81.modelId = class387.localPlayer.appearance.getChatHeadId();
               LoginScreenAnimation.invalidateWidget(var81);
               var1.serverPacket = null;
               return true;
            }

            long var45;
            if (ServerPacket.field2629 == var1.serverPacket) {
               var50 = var3.readStringCp1252NullTerminated();
               var37 = var3.readLong();
               var39 = (long)var3.readUnsignedShort();
               var45 = (long)var3.readMedium();
               PlayerType var95 = (PlayerType)class4.findEnumerated(ArchiveLoader.PlayerType_values(), var3.readUnsignedByte());
               var34 = var45 + (var39 << 32);
               boolean var67 = false;

               for(var15 = 0; var15 < 100; ++var15) {
                  if (var34 == crossWorldMessageIds[var15]) {
                     var67 = true;
                     break;
                  }
               }

               if (var95.isUser && WorldMapElement.friendSystem.isIgnored(new Username(var50, WorldMapCacheName.loginType))) {
                  var67 = true;
               }

               if (!var67 && field494 == 0) {
                  crossWorldMessageIds[crossWorldMessageIdsIndex] = var34;
                  crossWorldMessageIdsIndex = (crossWorldMessageIdsIndex + 1) % 100;
                  var33 = AbstractFont.escapeBrackets(ParamComposition.method994(class163.readString(var3)));
                  if (var95.modIcon != -1) {
                     class134.addChatMessage(9, ObjectSound.addImageTag(var95.modIcon) + var50, var33, WorldMapSection1.base37DecodeLong(var37));
                  } else {
                     class134.addChatMessage(9, var50, var33, WorldMapSection1.base37DecodeLong(var37));
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2593 == var1.serverPacket) {
               var20 = var3.readUnsignedByte();
               FaceNormal.forceDisconnect(var20);
               var1.serverPacket = null;
               return false;
            }

            if (ServerPacket.field2667 == var1.serverPacket) {
               WorldMapElement.friendSystem.method399();
               field577 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2582 == var1.serverPacket) {
               Decimator.processZoneOperation(ZoneOperation.field2544);
               var1.serverPacket = null;
               return true;
            }

            Widget var8;
            if (ServerPacket.field2625 == var1.serverPacket) {
               var20 = var3.readUnsignedShortLE();
               var5 = var3.method2415();
               var21 = var3.readUnsignedByteS();
               var7 = var3.readUnsignedShort();
               var8 = class133.getWidget(var5);
               if (var20 != var8.modelAngleX || var21 != var8.modelAngleY || var7 != var8.modelZoom) {
                  var8.modelAngleX = var20;
                  var8.modelAngleY = var21;
                  var8.modelZoom = var7;
                  LoginScreenAnimation.invalidateWidget(var8);
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2574 == var1.serverPacket) {
               class147.readReflectionCheck(var3, var1.serverPacketLength);
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2622 == var1.serverPacket) {
               ServerPacket.field2674 = true;
               ClientPacket.updateNpcs(true, var3);
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2596 == var1.serverPacket) {
               class123.process();
               var20 = var3.readUnsignedByteA();
               var5 = var3.readUnsignedByteA();
               var21 = var3.method2417();
               experience[var5] = var21;
               currentLevels[var5] = var20;
               levels[var5] = 1;

               for(var7 = 0; var7 < 98; ++var7) {
                  if (var21 >= Skills.Skills_experienceTable[var7]) {
                     levels[var5] = var7 + 2;
                  }
               }

               changedSkills[++changedSkillsCount - 1 & 31] = var5;
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2630 == var1.serverPacket) {
               var20 = var3.readUnsignedShortLEA();
               var5 = var3.method2401();
               var21 = var3.method2417();
               var74 = (InterfaceParent)interfaceParents.get((long)var21);
               if (var74 != null) {
                  class10.closeInterface(var74, var20 != var74.group);
               }

               ModeWhere.ifOpenSub(var21, var20, var5);
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2585 == var1.serverPacket) {
               var20 = var3.readUnsignedShort();
               var5 = var3.method2415();
               Varps.Varps_temp[var20] = var5;
               if (Varps.Varps_main[var20] != var5) {
                  Varps.Varps_main[var20] = var5;
               }

               ReflectionCheck.changeGameOptions(var20);
               changedVarps[++changedVarpCount - 1 & 31] = var20;
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2603 == var1.serverPacket) {
               var20 = var3.readInt();
               var5 = var3.readUnsignedShort();
               if (var20 < -70000) {
                  var5 += 32768;
               }

               if (var20 >= 0) {
                  var53 = class133.getWidget(var20);
               } else {
                  var53 = null;
               }

               if (var53 != null) {
                  for(var7 = 0; var7 < var53.itemIds.length; ++var7) {
                     var53.itemIds[var7] = 0;
                     var53.itemQuantities[var7] = 0;
                  }
               }

               GrandExchangeOfferTotalQuantityComparator.clearItemContainer(var5);
               var7 = var3.readUnsignedShort();

               for(var23 = 0; var23 < var7; ++var23) {
                  var9 = var3.readUnsignedByte();
                  if (var9 == 255) {
                     var9 = var3.readInt();
                  }

                  var10 = var3.readUnsignedByteS();
                  if (var53 != null && var23 < var53.itemIds.length) {
                     var53.itemIds[var23] = var10;
                     var53.itemQuantities[var23] = var9;
                  }

                  CollisionMap.itemContainerSetItem(var5, var23, var10 - 1, var9);
               }

               if (var53 != null) {
                  LoginScreenAnimation.invalidateWidget(var53);
               }

               class123.process();
               changedItemContainers[++changedItemContainersCount - 1 & 31] = var5 & 32767;
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2588 == var1.serverPacket) {
               SoundCache.method225();
               var84 = var3.readByte();
               class142 var80 = new class142(var3);
               ClanSettings var58;
               if (var84 >= 0) {
                  var58 = currentClanSettings[var84];
               } else {
                  var58 = DynamicObject.guestClanSettings;
               }

               var80.method759(var58);
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2600 == var1.serverPacket) {
               Decimator.processZoneOperation(ZoneOperation.field2547);
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2601 == var1.serverPacket) {
               var20 = var3.readInt();
               var5 = var3.readUnsignedShort();
               if (var20 < -70000) {
                  var5 += 32768;
               }

               if (var20 >= 0) {
                  var53 = class133.getWidget(var20);
               } else {
                  var53 = null;
               }

               for(; var3.offset < var1.serverPacketLength; CollisionMap.itemContainerSetItem(var5, var7, var23 - 1, var9)) {
                  var7 = var3.readUShortSmart();
                  var23 = var3.readUnsignedShort();
                  var9 = 0;
                  if (var23 != 0) {
                     var9 = var3.readUnsignedByte();
                     if (var9 == 255) {
                        var9 = var3.readInt();
                     }
                  }

                  if (var53 != null && var7 >= 0 && var7 < var53.itemIds.length) {
                     var53.itemIds[var7] = var23;
                     var53.itemQuantities[var7] = var9;
                  }
               }

               if (var53 != null) {
                  LoginScreenAnimation.invalidateWidget(var53);
               }

               class123.process();
               changedItemContainers[++changedItemContainersCount - 1 & 31] = var5 & 32767;
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2619 == var1.serverPacket) {
               class123.process();
               runEnergy = var3.readUnsignedShort();
               field625 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2605 == var1.serverPacket) {
               var20 = var3.method2416();
               var5 = var3.readUnsignedShort();
               if (var5 == 65535) {
                  var5 = -1;
               }

               var21 = var3.readInt();
               var7 = var3.readUnsignedShortLEA();
               if (var7 == 65535) {
                  var7 = -1;
               }

               for(var23 = var7; var23 <= var5; ++var23) {
                  var45 = ((long)var20 << 32) + (long)var23;
                  Node var47 = widgetFlags.get(var45);
                  if (var47 != null) {
                     var47.remove();
                  }

                  widgetFlags.put(new IntegerNode(var21), var45);
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2671 == var1.serverPacket) {
               Decimator.processZoneOperation(ZoneOperation.field2545);
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2569 == var1.serverPacket) {
               Decimator.processZoneOperation(ZoneOperation.field2548);
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2657 == var1.serverPacket) {
               var21 = var3.method2439();
               var20 = var21 >> 16;
               var5 = var21 >> 8 & 255;
               var7 = var20 + (var21 >> 4 & 7);
               var23 = var5 + (var21 & 7);
               var9 = var3.method2401();
               var10 = var9 >> 2;
               var64 = var9 & 3;
               var12 = OBJECT_TYPE_TO_STUB_TYPE[var10];
               var13 = var3.readUnsignedShortLEA();
               if (var7 >= 0 && var23 >= 0 && var7 < 103 && var23 < 103) {
                  if (var12 == 0) {
                     BoundaryObject var91 = WorldMapAreaData.scene.method1200(class103.Client_plane, var7, var23);
                     if (var91 != null) {
                        var15 = class124.Entity_unpackID(var91.tag);
                        if (var10 == 2) {
                           var91.renderable1 = new DynamicObject(var15, 2, var64 + 4, class103.Client_plane, var7, var23, var13, false, var91.renderable1);
                           var91.renderable2 = new DynamicObject(var15, 2, var64 + 1 & 3, class103.Client_plane, var7, var23, var13, false, var91.renderable2);
                        } else {
                           var91.renderable1 = new DynamicObject(var15, var10, var64, class103.Client_plane, var7, var23, var13, false, var91.renderable1);
                        }
                     }
                  } else if (var12 == 1) {
                     WallDecoration var90 = WorldMapAreaData.scene.method1201(class103.Client_plane, var7, var23);
                     if (var90 != null) {
                        var15 = class124.Entity_unpackID(var90.tag);
                        if (var10 != 4 && var10 != 5) {
                           if (var10 == 6) {
                              var90.renderable1 = new DynamicObject(var15, 4, var64 + 4, class103.Client_plane, var7, var23, var13, false, var90.renderable1);
                           } else if (var10 == 7) {
                              var90.renderable1 = new DynamicObject(var15, 4, (var64 + 2 & 3) + 4, class103.Client_plane, var7, var23, var13, false, var90.renderable1);
                           } else if (var10 == 8) {
                              var90.renderable1 = new DynamicObject(var15, 4, var64 + 4, class103.Client_plane, var7, var23, var13, false, var90.renderable1);
                              var90.renderable2 = new DynamicObject(var15, 4, (var64 + 2 & 3) + 4, class103.Client_plane, var7, var23, var13, false, var90.renderable2);
                           }
                        } else {
                           var90.renderable1 = new DynamicObject(var15, 4, var64, class103.Client_plane, var7, var23, var13, false, var90.renderable1);
                        }
                     }
                  } else if (var12 == 2) {
                     var32 = WorldMapAreaData.scene.getGameObject(class103.Client_plane, var7, var23);
                     if (var10 == 11) {
                        var10 = 10;
                     }

                     if (var32 != null) {
                        var32.renderable = new DynamicObject(class124.Entity_unpackID(var32.tag), var10, var64, class103.Client_plane, var7, var23, var13, false, var32.renderable);
                     }
                  } else if (var12 == 3) {
                     FloorDecoration var89 = WorldMapAreaData.scene.getFloorDecoration(class103.Client_plane, var7, var23);
                     if (var89 != null) {
                        var89.renderable = new DynamicObject(class124.Entity_unpackID(var89.tag), 22, var64, class103.Client_plane, var7, var23, var13, false, var89.renderable);
                     }
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2647 == var1.serverPacket) {
               var20 = var3.method2408();
               var5 = var3.method2416();
               var53 = class133.getWidget(var5);
               if (var20 != var53.sequenceId || var20 == -1) {
                  var53.sequenceId = var20;
                  var53.modelFrame = 0;
                  var53.modelFrameCycle = 0;
                  LoginScreenAnimation.invalidateWidget(var53);
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2633 == var1.serverPacket) {
               var84 = var3.readByte();
               var37 = (long)var3.readUnsignedShort();
               var39 = (long)var3.readMedium();
               var45 = var39 + (var37 << 32);
               boolean var11 = false;
               ClanChannel var36 = var84 >= 0 ? currentClanChannels[var84] : class482.guestClanChannel;
               if (var36 == null) {
                  var11 = true;
               } else {
                  for(var13 = 0; var13 < 100; ++var13) {
                     if (var45 == crossWorldMessageIds[var13]) {
                        var11 = true;
                        break;
                     }
                  }
               }

               if (!var11) {
                  crossWorldMessageIds[crossWorldMessageIdsIndex] = var45;
                  crossWorldMessageIdsIndex = (crossWorldMessageIdsIndex + 1) % 100;
                  var44 = class163.readString(var3);
                  var14 = var84 >= 0 ? 43 : 46;
                  class134.addChatMessage(var14, "", var44, var36.name);
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2617 == var1.serverPacket) {
               var20 = var3.method2417();
               var5 = var3.readUnsignedShortLEA();
               var21 = var5 >> 10 & 31;
               var7 = var5 >> 5 & 31;
               var23 = var5 & 31;
               var9 = (var7 << 11) + (var21 << 19) + (var23 << 3);
               Widget var29 = class133.getWidget(var20);
               if (var9 != var29.color) {
                  var29.color = var9;
                  LoginScreenAnimation.invalidateWidget(var29);
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2559 == var1.serverPacket) {
               WorldMapElement.friendSystem.ignoreList.read(var3, var1.serverPacketLength);
               FontName.FriendSystem_invalidateIgnoreds();
               field577 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2659 == var1.serverPacket) {
               var20 = var3.readUnsignedShortLEA();
               var5 = var3.method2417();
               var53 = class133.getWidget(var5);
               if (var53 != null && var53.type == 0) {
                  if (var20 > var53.scrollHeight - var53.height) {
                     var20 = var53.scrollHeight - var53.height;
                  }

                  if (var20 < 0) {
                     var20 = 0;
                  }

                  if (var20 != var53.scrollY) {
                     var53.scrollY = var20;
                     LoginScreenAnimation.invalidateWidget(var53);
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2662 == var1.serverPacket && isCameraLocked) {
               field631 = true;
               ModeWhere.cameraMoveToSpeed = var3.readUnsignedByte();
               UserComparator7.cameraMoveToAcceleration = var3.readUnsignedByte();
               Message.cameraLookAtSpeed = var3.readUnsignedByte();
               AttackOption.cameraLookAtAcceleration = var3.readUnsignedByte();

               for(var20 = 0; var20 < 5; ++var20) {
                  cameraShaking[var20] = false;
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2640 == var1.serverPacket) {
               class388.field3667 = new class421(MoveSpeed.HitSplatDefinition_cached);
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2590 == var1.serverPacket) {
               Decimator.processZoneOperation(ZoneOperation.field2549);
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2649 == var1.serverPacket) {
               byte[] var52 = new byte[var1.serverPacketLength];
               var3.method2361(var52, 0, var52.length);
               Buffer var79 = new Buffer(var52);
               var54 = var79.readStringCp1252NullTerminated();
               AttackOption.openURL(var54, true, false);
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2636 == var1.serverPacket) {
               var20 = var3.method2416();
               var5 = var3.readUnsignedShort();
               var53 = class133.getWidget(var20);
               if (var53.modelType != 6 || var5 != var53.modelId) {
                  var53.modelType = 6;
                  var53.modelId = var5;
                  LoginScreenAnimation.invalidateWidget(var53);
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2669 == var1.serverPacket) {
               var20 = var3.method2417();
               var5 = var3.method2416();
               InterfaceParent var6 = (InterfaceParent)interfaceParents.get((long)var20);
               var74 = (InterfaceParent)interfaceParents.get((long)var5);
               if (var74 != null) {
                  class10.closeInterface(var74, var6 == null || var6.group != var74.group);
               }

               if (var6 != null) {
                  var6.remove();
                  interfaceParents.put(var6, (long)var5);
               }

               var8 = class133.getWidget(var20);
               if (var8 != null) {
                  LoginScreenAnimation.invalidateWidget(var8);
               }

               var8 = class133.getWidget(var5);
               if (var8 != null) {
                  LoginScreenAnimation.invalidateWidget(var8);
                  AbstractWorldMapData.revalidateWidgetScroll(WorldMapLabel.Widget_interfaceComponents[var8.id >>> 16], var8, true);
               }

               if (rootInterface != -1) {
                  class147.runIntfCloseListeners(rootInterface, 1);
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2573 == var1.serverPacket) {
               Decimator.processZoneOperation(ZoneOperation.field2542);
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2641 == var1.serverPacket) {
               tradeChatMode = var3.method2401();
               publicChatMode = var3.readUnsignedShortA();
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2568 == var1.serverPacket) {
               ServerPacket.field2674 = true;
               ClientPacket.updateNpcs(false, var3);
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2610 == var1.serverPacket) {
               rebootTimer = var3.readUnsignedByteS() * 30;
               field625 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2612 == var1.serverPacket) {
               for(var20 = 0; var20 < Varps.Varps_main.length; ++var20) {
                  if (Varps.Varps_temp[var20] != Varps.Varps_main[var20]) {
                     Varps.Varps_main[var20] = Varps.Varps_temp[var20];
                     ReflectionCheck.changeGameOptions(var20);
                     changedVarps[++changedVarpCount - 1 & 31] = var20;
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2666 == var1.serverPacket) {
               Decimator.processZoneOperation(ZoneOperation.field2541);
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2571 == var1.serverPacket) {
               class373.field3599 = var3.method2401();
               KeyHandler.field86 = var3.readUnsignedByte();

               for(var20 = class373.field3599; var20 < class373.field3599 + 8; ++var20) {
                  for(var5 = KeyHandler.field86; var5 < KeyHandler.field86 + 8; ++var5) {
                     if (groundItems[class103.Client_plane][var20][var5] != null) {
                        groundItems[class103.Client_plane][var20][var5] = null;
                        ClientPacket.updateItemPile(var20, var5);
                     }
                  }
               }

               for(PendingSpawn var51 = (PendingSpawn)pendingSpawns.last(); var51 != null; var51 = (PendingSpawn)pendingSpawns.previous()) {
                  if (var51.x >= class373.field3599 && var51.x < class373.field3599 + 8 && var51.y >= KeyHandler.field86 && var51.y < KeyHandler.field86 + 8 && var51.plane == class103.Client_plane) {
                     var51.endCycle = 0;
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2672 == var1.serverPacket) {
               for(var20 = 0; var20 < VarpDefinition.field1471; ++var20) {
                  VarpDefinition var78 = TaskHandler.VarpDefinition_get(var20);
                  if (var78 != null) {
                     Varps.Varps_temp[var20] = 0;
                     Varps.Varps_main[var20] = 0;
                  }
               }

               class123.process();
               changedVarpCount += 32;
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2575 == var1.serverPacket) {
               var20 = var3.readUnsignedByte();
               var5 = var3.readUnsignedByte();
               var21 = var3.readUnsignedByte();
               var7 = var3.readUnsignedByte();
               cameraShaking[var20] = true;
               cameraShakeIntensity[var20] = var5;
               cameraMoveIntensity[var20] = var21;
               cameraShakeSpeed[var20] = var7;
               cameraShakeCycle[var20] = 0;
               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2637 == var1.serverPacket) {
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

            if (ServerPacket.field2620 == var1.serverPacket) {
               var50 = var3.readStringCp1252NullTerminated();
               var5 = var3.readUnsignedShortA();
               var21 = var3.readUnsignedByteA();
               if (var21 >= 1 && var21 <= 8) {
                  if (var50.equalsIgnoreCase("null")) {
                     var50 = null;
                  }

                  playerMenuActions[var21 - 1] = var50;
                  playerOptionsPriorities[var21 - 1] = var5 == 0;
               }

               var1.serverPacket = null;
               return true;
            }

            if (ServerPacket.field2660 == var1.serverPacket) {
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

            if (ServerPacket.field2628 == var1.serverPacket) {
               var20 = var3.readInt();
               var5 = var3.readInt();
               var21 = class287.getGcDuration();
               PacketBufferNode var22 = Renderable.getPacketBufferNode(ClientPacket.field2439, packetWriter.isaacCipher);
               var22.packetBuffer.method2414(var20);
               var22.packetBuffer.method2441(var5);
               var22.packetBuffer.writeByteA(GameEngine.fps);
               var22.packetBuffer.writeByte(var21);
               packetWriter.addNode(var22);
               var1.serverPacket = null;
               return true;
            }

            class121.RunException_sendStackTrace("" + (var1.serverPacket != null ? var1.serverPacket.id * 618004529 * -1282844463 : -1) + "," + (var1.field1133 != null ? var1.field1133.id * 618004529 * -1282844463 : -1) + "," + (var1.field1134 != null ? var1.field1134.id * 618004529 * -1282844463 : -1) + "," + var1.serverPacketLength, (Throwable)null);
            HealthBarDefinition.logOut();
         } catch (IOException var48) {
            WorldMapManager.method1404();
         } catch (Exception var49) {
            var24 = "" + (var1.serverPacket != null ? var1.serverPacket.id * 618004529 * -1282844463 : -1) + "," + (var1.field1133 != null ? var1.field1133.id * 618004529 * -1282844463 : -1) + "," + (var1.field1134 != null ? var1.field1134.id * 618004529 * -1282844463 : -1) + "," + var1.serverPacketLength + "," + (class387.localPlayer.pathX[0] + ParamComposition.baseX) + "," + (class387.localPlayer.pathY[0] + baseY) + ",";

            for(var21 = 0; var21 < var1.serverPacketLength && var21 < 50; ++var21) {
               var24 = var24 + var3.array[var21] + ",";
            }

            class121.RunException_sendStackTrace(var24, var49);
            HealthBarDefinition.logOut();
         }

         return true;
      }
   }

   @ObfuscatedName("ik")
   @ObfuscatedSignature(
           descriptor = "(B)V",
           garbageValue = "-124"
   )
   final void menu() {
      class127.method712();
      if (WorldMapLabelSize.dragInventoryWidget == null) {
         if (clickedWidget == null) {
            int var1 = MouseHandler.MouseHandler_lastButton;
            int var2;
            int var4;
            int var5;
            int var6;
            if (isMenuOpen) {
               int var3;
               if (var1 != 1 && (ClanMate.mouseCam || var1 != 4)) {
                  var2 = MouseHandler.MouseHandler_x;
                  var3 = MouseHandler.MouseHandler_y;
                  if (var2 < class130.menuX - 10 || var2 > class130.menuX + class7.menuWidth + 10 || var3 < ModeWhere.menuY - 10 || var3 > PlayerType.menuHeight + ModeWhere.menuY + 10) {
                     isMenuOpen = false;
                     Language.method1878(class130.menuX, ModeWhere.menuY, class7.menuWidth, PlayerType.menuHeight);
                  }
               }

               if (var1 == 1 || !ClanMate.mouseCam && var1 == 4) {
                  var2 = class130.menuX;
                  var3 = ModeWhere.menuY;
                  var4 = class7.menuWidth;
                  var5 = MouseHandler.MouseHandler_lastPressedX;
                  var6 = MouseHandler.MouseHandler_lastPressedY;
                  int var7 = -1;

                  for(int var8 = 0; var8 < menuOptionsCount; ++var8) {
                     int var9 = var3 + (menuOptionsCount - 1 - var8) * 15 + 31;
                     if (var5 > var2 && var5 < var2 + var4 && var6 > var9 - 13 && var6 < var9 + 3) {
                        var7 = var8;
                     }
                  }

                  if (var7 != -1) {
                     FloorDecoration.method1142(var7);
                  }

                  isMenuOpen = false;
                  Language.method1878(class130.menuX, ModeWhere.menuY, class7.menuWidth, PlayerType.menuHeight);
               }
            } else {
               var2 = menuOptionsCount - 1;
               if ((var1 == 1 || !ClanMate.mouseCam && var1 == 4) && var2 >= 0) {
                  var4 = menuOpcodes[var2];
                  if (var4 == 39 || var4 == 40 || var4 == 41 || var4 == 42 || var4 == 43 || var4 == 33 || var4 == 34 || var4 == 35 || var4 == 36 || var4 == 37 || var4 == 38 || var4 == 1005) {
                     var5 = menuArguments1[var2];
                     var6 = menuArguments2[var2];
                     Widget var10 = class133.getWidget(var6);
                     if (ViewportMouse.method1295(class173.getWidgetFlags(var10)) || class16.method58(class173.getWidgetFlags(var10))) {
                        if (WorldMapLabelSize.dragInventoryWidget != null && !field492 && menuOptionsCount > 0 && !this.shouldLeftClickOpenMenu()) {
                           Skills.method1779(draggedWidgetX, draggedWidgetY);
                        }

                        field492 = false;
                        itemDragDuration = 0;
                        if (WorldMapLabelSize.dragInventoryWidget != null) {
                           LoginScreenAnimation.invalidateWidget(WorldMapLabelSize.dragInventoryWidget);
                        }

                        WorldMapLabelSize.dragInventoryWidget = class133.getWidget(var6);
                        dragItemSlotSource = var5;
                        draggedWidgetX = MouseHandler.MouseHandler_lastPressedX;
                        draggedWidgetY = MouseHandler.MouseHandler_lastPressedY;
                        if (var2 >= 0) {
                           class33.method131(var2);
                        }

                        LoginScreenAnimation.invalidateWidget(WorldMapLabelSize.dragInventoryWidget);
                        return;
                     }
                  }
               }

               if ((var1 == 1 || !ClanMate.mouseCam && var1 == 4) && this.shouldLeftClickOpenMenu()) {
                  var1 = 2;
               }

               if ((var1 == 1 || !ClanMate.mouseCam && var1 == 4) && menuOptionsCount > 0) {
                  FloorDecoration.method1142(var2);
               }

               if (var1 == 2 && menuOptionsCount > 0) {
                  this.openMenu(MouseHandler.MouseHandler_lastPressedX, MouseHandler.MouseHandler_lastPressedY);
               }
            }

         }
      }
   }

   @ObfuscatedName("iy")
   @ObfuscatedSignature(
           descriptor = "(I)Z",
           garbageValue = "1730699476"
   )
   final boolean shouldLeftClickOpenMenu() {
      int var1 = menuOptionsCount - 1;
      return (leftClickOpensMenu && menuOptionsCount > 2 || ArchiveDisk.method2154(var1)) && !menuShiftClick[var1];
   }

   @ObfuscatedName("il")
   @ObfuscatedSignature(
           descriptor = "(IIS)V",
           garbageValue = "3638"
   )
   final void openMenu(int var1, int var2) {
      class275.method1524(var1, var2);
      var1 -= viewportOffsetX;
      var2 -= viewportOffsetY;
      WorldMapAreaData.scene.menuOpen(class103.Client_plane, var1, var2, false);
      isMenuOpen = true;
   }

   @ObfuscatedName("jq")
   @ObfuscatedSignature(
           descriptor = "(ZI)V",
           garbageValue = "-1196271761"
   )
   final void resizeRoot(boolean var1) {
      int var2 = rootInterface;
      int var3 = GameEngine.canvasWidth;
      int var4 = class127.canvasHeight;
      if (class153.loadInterface(var2)) {
         class374.resizeInterface(WorldMapLabel.Widget_interfaceComponents[var2], -1, var3, var4, var1);
      }

   }

   @ObfuscatedName("jf")
   @ObfuscatedSignature(
           descriptor = "(Lkz;I)V",
           garbageValue = "-2114785008"
   )
   void alignWidget(Widget var1) {
      Widget var2 = var1.parentId == -1 ? null : class133.getWidget(var1.parentId);
      int var3;
      int var4;
      if (var2 == null) {
         var3 = GameEngine.canvasWidth;
         var4 = class127.canvasHeight;
      } else {
         var3 = var2.width;
         var4 = var2.height;
      }

      alignWidgetSize(var1, var3, var4, false);
      alignWidgetPosition(var1, var3, var4);
   }

   @ObfuscatedName("kx")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "839046279"
   )
   final void method370() {
      LoginScreenAnimation.invalidateWidget(clickedWidget);
      ++class27.widgetDragDuration;
      if (field563 && field560) {
         int var1 = MouseHandler.MouseHandler_x;
         int var2 = MouseHandler.MouseHandler_y;
         var1 -= widgetClickX;
         var2 -= widgetClickY;
         if (var1 < field659) {
            var1 = field659;
         }

         if (var1 + clickedWidget.width > field659 + clickedWidgetParent.width) {
            var1 = field659 + clickedWidgetParent.width - clickedWidget.width;
         }

         if (var2 < field667) {
            var2 = field667;
         }

         if (var2 + clickedWidget.height > field667 + clickedWidgetParent.height) {
            var2 = field667 + clickedWidgetParent.height - clickedWidget.height;
         }

         int var3 = var1 - field601;
         int var4 = var2 - field422;
         int var5 = clickedWidget.dragZoneSize;
         if (class27.widgetDragDuration > clickedWidget.dragThreshold && (var3 > var5 || var3 < -var5 || var4 > var5 || var4 < -var5)) {
            isDraggingWidget = true;
         }

         int var6 = var1 - field659 + clickedWidgetParent.scrollX;
         int var7 = var2 - field667 + clickedWidgetParent.scrollY;
         ScriptEvent var8;
         if (clickedWidget.onDrag != null && isDraggingWidget) {
            var8 = new ScriptEvent();
            var8.widget = clickedWidget;
            var8.mouseX = var6;
            var8.mouseY = var7;
            var8.args = clickedWidget.onDrag;
            WorldMapAreaData.runScriptEvent(var8);
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
                  WorldMapAreaData.runScriptEvent(var8);
               }

               if (draggedOnWidget != null) {
                  Widget var9 = clickedWidget;
                  int var10 = ClanChannel.method846(class173.getWidgetFlags(var9));
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

                        var9 = class133.getWidget(var9.parentId);
                        if (var9 == null) {
                           var13 = null;
                           break;
                        }

                        ++var11;
                     }
                  }

                  if (var13 != null) {
                     PacketBufferNode var12 = Renderable.getPacketBufferNode(ClientPacket.field2487, packetWriter.isaacCipher);
                     var12.packetBuffer.writeShort(clickedWidget.itemId);
                     var12.packetBuffer.writeInt(draggedOnWidget.id);
                     var12.packetBuffer.writeShort(draggedOnWidget.childIndex);
                     var12.packetBuffer.writeShortLEA(draggedOnWidget.itemId);
                     var12.packetBuffer.writeShort(clickedWidget.childIndex);
                     var12.packetBuffer.method2382(clickedWidget.id);
                     packetWriter.addNode(var12);
                  }
               }
            } else if (this.shouldLeftClickOpenMenu()) {
               this.openMenu(widgetClickX + field601, widgetClickY + field422);
            } else if (menuOptionsCount > 0) {
               Skills.method1779(widgetClickX + field601, widgetClickY + field422);
            }

            clickedWidget = null;
         }

      } else {
         if (class27.widgetDragDuration > 1) {
            if (!isDraggingWidget && menuOptionsCount > 0) {
               Skills.method1779(widgetClickX + field601, widgetClickY + field422);
            }

            clickedWidget = null;
         }

      }
   }

   @ObfuscatedName("ma")
   @ObfuscatedSignature(
           descriptor = "(I)Lsi;",
           garbageValue = "-2141997640"
   )
   public Username username() {
      return class387.localPlayer != null ? class387.localPlayer.username : null;
   }

   @ObfuscatedName("init")
   public final void init() {
      if (this.checkHost()) {
         int var3;
         int var4;
         int var7;
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
                  var4 = Integer.parseInt(var2);
                  Language var53;
                  if (var4 >= 0 && var4 < Language.field3530.length) {
                     var53 = Language.field3530[var4];
                  } else {
                     var53 = null;
                  }

                  class36.clientLanguage = var53;
                  break;
               case 7:
                  var4 = Integer.parseInt(var2);
                  GameBuild[] var5 = new GameBuild[]{GameBuild.WIP, GameBuild.RC, GameBuild.LIVE, GameBuild.BUILDLIVE};
                  GameBuild[] var6 = var5;
                  var7 = 0;

                  GameBuild var17;
                  while(true) {
                     if (var7 >= var6.length) {
                        var17 = null;
                        break;
                     }

                     GameBuild var8 = var6[var7];
                     if (var4 == var8.buildId) {
                        var17 = var8;
                        break;
                     }

                     ++var7;
                  }

                  class147.field1330 = var17;
                  break;
               case 8:
                  if (var2.equalsIgnoreCase("true")) {
                     ;
                  }
                  break;
               case 9:
                  GraphicsDefaults.param9 = var2;
                  break;
               case 10:
                  class134.field1270 = (StudioGame)class4.findEnumerated(WorldMapSection1.method1466(), Integer.parseInt(var2));
                  if (class134.field1270 == StudioGame.oldscape) {
                     WorldMapCacheName.loginType = LoginType.oldscape;
                  } else {
                     WorldMapCacheName.loginType = LoginType.field3953;
                  }
                  break;
               case 11:
                  field669 = var2;
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
                  Message.field359 = Integer.parseInt(var2);
                  break;
               case 15:
                  gameBuild = Integer.parseInt(var2);
                  break;
               case 17:
                  VerticalAlignment.field1594 = var2;
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
         NetCache.worldHost = this.getCodeBase().getHost();
         String var18 = class147.field1330.name;
         byte var19 = 0;

         try {
            JagexCache.idxCount = 22;
            class86.cacheGamebuild = var19;

            try {
               class168.operatingSystemName = System.getProperty("os.name");
            } catch (Exception var36) {
               class168.operatingSystemName = "Unknown";
            }

            SpotAnimationDefinition.formattedOperatingSystemName = class168.operatingSystemName.toLowerCase();

            try {
               UserComparator4.userHomeDirectory = System.getProperty("user.home");
               if (UserComparator4.userHomeDirectory != null) {
                  UserComparator4.userHomeDirectory = UserComparator4.userHomeDirectory + "/";
               }
            } catch (Exception var35) {
               ;
            }

            try {
               if (SpotAnimationDefinition.formattedOperatingSystemName.startsWith("win")) {
                  if (UserComparator4.userHomeDirectory == null) {
                     UserComparator4.userHomeDirectory = System.getenv("USERPROFILE");
                  }
               } else if (UserComparator4.userHomeDirectory == null) {
                  UserComparator4.userHomeDirectory = System.getenv("HOME");
               }

               if (UserComparator4.userHomeDirectory != null) {
                  UserComparator4.userHomeDirectory = UserComparator4.userHomeDirectory + "/";
               }
            } catch (Exception var34) {
               ;
            }

            if (UserComparator4.userHomeDirectory == null) {
               UserComparator4.userHomeDirectory = "~/";
            }

            class158.cacheParentPaths = new String[]{"c:/rscache/", "/rscache/", "c:/windows/", "c:/winnt/", "c:/", UserComparator4.userHomeDirectory, "/tmp/", ""};
            class130.cacheSubPaths = new String[]{".jagex_cache_" + class86.cacheGamebuild, ".file_store_" + class86.cacheGamebuild};
            var3 = 0;

            label342:
            while(var3 < 4) {
               String var41 = var3 == 0 ? "" : "" + var3;
               UserComparator5.JagexCache_locationFile = new File(UserComparator4.userHomeDirectory, "jagex_cl_oldschool_" + var18 + var41 + ".dat");
               String var43 = null;
               String var20 = null;
               boolean var21 = false;
               Buffer var10;
               int var11;
               int var13;
               File var46;
               if (UserComparator5.JagexCache_locationFile.exists()) {
                  try {
                     AccessFile var9 = new AccessFile(UserComparator5.JagexCache_locationFile, "rw", 10000L);

                     for(var10 = new Buffer((int)var9.length()); var10.offset < var10.array.length; var10.offset += var11) {
                        var11 = var9.read(var10.array, var10.offset, var10.array.length - var10.offset);
                        if (var11 == -1) {
                           throw new IOException();
                        }
                     }

                     var10.offset = 0;
                     var11 = var10.readUnsignedByte();
                     if (var11 < 1 || var11 > 3) {
                        throw new IOException("" + var11);
                     }

                     int var12 = 0;
                     if (var11 > 1) {
                        var12 = var10.readUnsignedByte();
                     }

                     if (var11 <= 2) {
                        var43 = var10.readStringCp1252NullCircumfixed();
                        if (var12 == 1) {
                           var20 = var10.readStringCp1252NullCircumfixed();
                        }
                     } else {
                        var43 = var10.readCESU8();
                        if (var12 == 1) {
                           var20 = var10.readCESU8();
                        }
                     }

                     var9.close();
                  } catch (IOException var39) {
                     var39.printStackTrace();
                  }

                  if (var43 != null) {
                     var46 = new File(var43);
                     if (!var46.exists()) {
                        var43 = null;
                     }
                  }

                  if (var43 != null) {
                     var46 = new File(var43, "test.dat");

                     boolean var49;
                     try {
                        RandomAccessFile var22 = new RandomAccessFile(var46, "rw");
                        var13 = var22.read();
                        var22.seek(0L);
                        var22.write(var13);
                        var22.seek(0L);
                        var22.close();
                        var46.delete();
                        var49 = true;
                     } catch (Exception var33) {
                        var49 = false;
                     }

                     if (!var49) {
                        var43 = null;
                     }
                  }
               }

               if (var43 == null && var3 == 0) {
                  label318:
                  for(int var23 = 0; var23 < class130.cacheSubPaths.length; ++var23) {
                     for(int var24 = 0; var24 < class158.cacheParentPaths.length; ++var24) {
                        File var25 = new File(class158.cacheParentPaths[var24] + class130.cacheSubPaths[var23] + File.separatorChar + "oldschool" + File.separatorChar);
                        if (var25.exists()) {
                           File var26 = new File(var25, "test.dat");

                           boolean var51;
                           try {
                              RandomAccessFile var14 = new RandomAccessFile(var26, "rw");
                              int var15 = var14.read();
                              var14.seek(0L);
                              var14.write(var15);
                              var14.seek(0L);
                              var14.close();
                              var26.delete();
                              var51 = true;
                           } catch (Exception var32) {
                              var51 = false;
                           }

                           if (var51) {
                              var43 = var25.toString();
                              var21 = true;
                              break label318;
                           }
                        }
                     }
                  }
               }

               if (var43 == null) {
                  var43 = UserComparator4.userHomeDirectory + File.separatorChar + "jagexcache" + var41 + File.separatorChar + "oldschool" + File.separatorChar + var18 + File.separatorChar;
                  var21 = true;
               }

               File var45;
               if (var20 != null) {
                  var45 = new File(var20);
                  var46 = new File(var43);

                  try {
                     File[] var58 = var45.listFiles();
                     File[] var55 = var58;

                     for(var13 = 0; var13 < var55.length; ++var13) {
                        File var52 = var55[var13];
                        File var27 = new File(var46, var52.getName());
                        boolean var16 = var52.renameTo(var27);
                        if (!var16) {
                           throw new IOException();
                        }
                     }
                  } catch (Exception var38) {
                     var38.printStackTrace();
                  }

                  var21 = true;
               }

               if (var21) {
                  var45 = new File(var43);
                  var10 = null;

                  try {
                     AccessFile var59 = new AccessFile(UserComparator5.JagexCache_locationFile, "rw", 10000L);
                     Buffer var56 = new Buffer(500);
                     var56.writeByte(3);
                     var56.writeByte(var10 != null ? 1 : 0);
                     var56.writeCESU8(var45.getPath());
                     if (var10 != null) {
                        var56.writeCESU8("");
                     }

                     var59.write(var56.array, 0, var56.offset);
                     var59.close();
                  } catch (IOException var31) {
                     var31.printStackTrace();
                  }
               }

               File var28 = new File(var43);
               Ignored.cacheDir = var28;
               if (!Ignored.cacheDir.exists()) {
                  Ignored.cacheDir.mkdirs();
               }

               File[] var42 = Ignored.cacheDir.listFiles();
               if (var42 == null) {
                  break;
               }

               File[] var47 = var42;
               var7 = 0;

               while(true) {
                  if (var7 >= var47.length) {
                     break label342;
                  }

                  File var44 = var47[var7];

                  boolean var57;
                  try {
                     RandomAccessFile var50 = new RandomAccessFile(var44, "rw");
                     var11 = var50.read();
                     var50.seek(0L);
                     var50.write(var11);
                     var50.seek(0L);
                     var50.close();
                     var57 = true;
                  } catch (Exception var30) {
                     var57 = false;
                  }

                  if (!var57) {
                     ++var3;
                     break;
                  }

                  ++var7;
               }
            }

            PendingSpawn.method499(Ignored.cacheDir);

            try {
               File var54 = new File(UserComparator4.userHomeDirectory, "random.dat");
               int var29;
               if (var54.exists()) {
                  JagexCache.JagexCache_randomDat = new BufferedFile(new AccessFile(var54, "rw", 25L), 24, 0);
               } else {
                  label271:
                  for(var4 = 0; var4 < class130.cacheSubPaths.length; ++var4) {
                     for(var29 = 0; var29 < class158.cacheParentPaths.length; ++var29) {
                        File var48 = new File(class158.cacheParentPaths[var29] + class130.cacheSubPaths[var4] + File.separatorChar + "random.dat");
                        if (var48.exists()) {
                           JagexCache.JagexCache_randomDat = new BufferedFile(new AccessFile(var48, "rw", 25L), 24, 0);
                           break label271;
                        }
                     }
                  }
               }

               if (JagexCache.JagexCache_randomDat == null) {
                  RandomAccessFile var60 = new RandomAccessFile(var54, "rw");
                  var29 = var60.read();
                  var60.seek(0L);
                  var60.write(var29);
                  var60.seek(0L);
                  var60.close();
                  JagexCache.JagexCache_randomDat = new BufferedFile(new AccessFile(var54, "rw", 25L), 24, 0);
               }
            } catch (IOException var37) {
               ;
            }

            JagexCache.JagexCache_dat2File = new BufferedFile(new AccessFile(class372.getFile("main_file_cache.dat2"), "rw", 1048576000L), 5200, 0);
            JagexCache.JagexCache_idx255File = new BufferedFile(new AccessFile(class372.getFile("main_file_cache.idx255"), "rw", 1048576L), 6000, 0);
            class18.JagexCache_idxFiles = new BufferedFile[JagexCache.idxCount];

            for(var3 = 0; var3 < JagexCache.idxCount; ++var3) {
               class18.JagexCache_idxFiles[var3] = new BufferedFile(new AccessFile(class372.getFile("main_file_cache.idx" + var3), "rw", 1048576L), 6000, 0);
            }
         } catch (Exception var40) {
            class121.RunException_sendStackTrace((String)null, var40);
         }

         Decimator.client = this;
         RuneLiteMenuEntry.client = (RSClient) (Object) this;
         RunException.field4130 = clientType;
         Frames.field2059 = System.getenv("JX_ACCESS_TOKEN");
         class152.field1373 = System.getenv("JX_REFRESH_TOKEN");
         MusicPatchNode.field2783 = System.getenv("JX_SESSION_ID");
         VarcInt.field1501 = System.getenv("JX_CHARACTER_ID");
         Occluder.method1250(System.getenv("JX_DISPLAY_NAME"));
         if (Boolean.parseBoolean(System.getProperty("jagex.disableBouncyCastle"))) {
            this.field410 = true;
         }

         if (field372 == -1) {
            if (!this.method369() && !this.method343()) {
               field372 = 0;
            } else {
               field372 = 5;
            }
         }

         this.startThread(765, 503, 211, 1);
      }
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "(ILba;ZI)I",
      garbageValue = "-381999451"
   )
   static int method368(int var0, Script var1, boolean var2) {
      return 2;
   }

   @ObfuscatedName("bm")
   @ObfuscatedSignature(
      descriptor = "(II)Ljava/lang/Object;",
      garbageValue = "-1698320506"
   )
   static Object method374(int var0) {
      return FriendsList.method2066((class463)class4.findEnumerated(class463.method2337(), var0));
   }

   @ObfuscatedName("ji")
   @ObfuscatedSignature(
           descriptor = "(Lkz;IIZI)V",
           garbageValue = "1319818447"
   )
   static void alignWidgetSize(Widget var0, int var1, int var2, boolean var3) {
      int var4 = var0.width;
      int var5 = var0.height;
      if (var0.widthAlignment == 0) {
         var0.width = var0.rawWidth;
      } else if (var0.widthAlignment == 1) {
         var0.width = var1 - var0.rawWidth;
      } else if (var0.widthAlignment == 2) {
         var0.width = var0.rawWidth * var1 >> 14;
      }

      if (var0.heightAlignment == 0) {
         var0.height = var0.rawHeight;
      } else if (var0.heightAlignment == 1) {
         var0.height = var2 - var0.rawHeight;
      } else if (var0.heightAlignment == 2) {
         var0.height = var2 * var0.rawHeight >> 14;
      }

      if (var0.widthAlignment == 4) {
         var0.width = var0.field2964 * var0.height / var0.field2875;
      }

      if (var0.heightAlignment == 4) {
         var0.height = var0.width * var0.field2875 / var0.field2964;
      }

      if (var0.contentType == 1337) {
         viewportWidget = var0;
      }

      if (var0.type == 12) {
         var0.method1750().method1645(var0.width, var0.height);
      }

      if (var3 && var0.onResize != null && (var4 != var0.width || var5 != var0.height)) {
         ScriptEvent var6 = new ScriptEvent();
         var6.widget = var0;
         var6.args = var0.onResize;
         scriptEvents.addFirst(var6);
      }

   }

   @ObfuscatedName("jg")
   @ObfuscatedSignature(
           descriptor = "(Lkz;III)V",
           garbageValue = "1034721181"
   )
   static void alignWidgetPosition(Widget var0, int var1, int var2) {
      if (var0.xAlignment == 0) {
         var0.x = var0.rawX;
      } else if (var0.xAlignment == 1) {
         var0.x = var0.rawX + (var1 - var0.width) / 2;
      } else if (var0.xAlignment == 2) {
         var0.x = var1 - var0.width - var0.rawX;
      } else if (var0.xAlignment == 3) {
         var0.x = var0.rawX * var1 >> 14;
      } else if (var0.xAlignment == 4) {
         var0.x = (var0.rawX * var1 >> 14) + (var1 - var0.width) / 2;
      } else {
         var0.x = var1 - var0.width - (var0.rawX * var1 >> 14);
      }

      if (var0.yAlignment == 0) {
         var0.y = var0.rawY;
      } else if (var0.yAlignment == 1) {
         var0.y = (var2 - var0.height) / 2 + var0.rawY;
      } else if (var0.yAlignment == 2) {
         var0.y = var2 - var0.height - var0.rawY;
      } else if (var0.yAlignment == 3) {
         var0.y = var2 * var0.rawY >> 14;
      } else if (var0.yAlignment == 4) {
         var0.y = (var2 - var0.height) / 2 + (var2 * var0.rawY >> 14);
      } else {
         var0.y = var2 - var0.height - (var2 * var0.rawY >> 14);
      }

   }
}
