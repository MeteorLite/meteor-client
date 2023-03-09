import java.applet.Applet;
import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.ImageObserver;
import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("br")
@Implements("GameEngine")
public abstract class GameEngine extends Applet implements Runnable, FocusListener, WindowListener {
   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "Lge;"
   )
   @Export("taskHandler")
   protected static TaskHandler taskHandler;
   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "Lbr;"
   )
   @Export("gameEngine")
   static GameEngine gameEngine = null;
   @ObfuscatedName("ac")
   @Export("GameEngine_redundantStartThreadCount")
   static int GameEngine_redundantStartThreadCount = 0;
   @ObfuscatedName("ab")
   @Export("stopTimeMs")
   static long stopTimeMs = 0L;
   @ObfuscatedName("an")
   @Export("isKilled")
   static boolean isKilled = false;
   @ObfuscatedName("av")
   @Export("gameCyclesToDo")
   static int gameCyclesToDo;
   @ObfuscatedName("aq")
   @Export("cycleDurationMillis")
   static int cycleDurationMillis = 20;
   @ObfuscatedName("ap")
   @Export("fiveOrOne")
   static int fiveOrOne = 1;
   @ObfuscatedName("ar")
   @Export("fps")
   protected static int fps = 0;
   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      descriptor = "Lgj;"
   )
   @Export("clock")
   static Clock clock;
   @ObfuscatedName("as")
   @Export("graphicsTickTimes")
   static long[] graphicsTickTimes = new long[32];
   @ObfuscatedName("am")
   @Export("clientTickTimes")
   static long[] clientTickTimes = new long[32];
   @ObfuscatedName("af")
   @Export("canvasWidth")
   public static int canvasWidth;
   @ObfuscatedName("bl")
   static int field114 = 500;
   @ObfuscatedName("bu")
   @Export("volatileFocus")
   static volatile boolean volatileFocus = true;
   @ObfuscatedName("by")
   @ObfuscatedSignature(
      descriptor = "Lad;"
   )
   @Export("keyHandler")
   protected static KeyHandler keyHandler = new KeyHandler();
   @ObfuscatedName("bb")
   @Export("garbageCollectorLastCollectionTime")
   static long garbageCollectorLastCollectionTime = -1L;
   @ObfuscatedName("bx")
   @Export("garbageCollectorLastCheckTimeMs")
   static long garbageCollectorLastCheckTimeMs = -1L;
   @ObfuscatedName("il")
   @Export("baseX")
   static int baseX;
   @ObfuscatedName("ao")
   @Export("hasErrored")
   boolean hasErrored = false;
   @ObfuscatedName("ae")
   @Export("contentWidth")
   protected int contentWidth;
   @ObfuscatedName("au")
   @Export("contentHeight")
   protected int contentHeight;
   @ObfuscatedName("ag")
   @Export("canvasX")
   int canvasX = 0;
   @ObfuscatedName("at")
   @Export("canvasY")
   int canvasY = 0;
   @ObfuscatedName("aw")
   int field128;
   @ObfuscatedName("aa")
   int field112;
   @ObfuscatedName("ah")
   @Export("maxCanvasWidth")
   int maxCanvasWidth;
   @ObfuscatedName("ad")
   @Export("maxCanvasHeight")
   int maxCanvasHeight;
   @ObfuscatedName("bo")
   @Export("frame")
   Frame frame;
   @ObfuscatedName("bs")
   @Export("canvas")
   java.awt.Canvas canvas;
   @ObfuscatedName("bg")
   @Export("fullRedraw")
   volatile boolean fullRedraw = true;
   @ObfuscatedName("bk")
   @Export("resizeCanvasNextFrame")
   boolean resizeCanvasNextFrame = false;
   @ObfuscatedName("br")
   @Export("isCanvasInvalid")
   volatile boolean isCanvasInvalid = false;
   @ObfuscatedName("ba")
   volatile long field121 = 0L;
   @ObfuscatedName("bc")
   @ObfuscatedSignature(
      descriptor = "Lai;"
   )
   @Export("mouseWheelHandler")
   MouseWheelHandler mouseWheelHandler;
   @ObfuscatedName("bt")
   @Export("clipboard")
   Clipboard clipboard;
   @ObfuscatedName("be")
   @Export("eventQueue")
   final EventQueue eventQueue;

   protected GameEngine() {
      EventQueue var1 = null;

      try {
         var1 = Toolkit.getDefaultToolkit().getSystemEventQueue();
      } catch (Throwable var3) {
         ;
      }

      this.eventQueue = var1;
      DevicePcmPlayerProvider var2 = new DevicePcmPlayerProvider();
      Script.pcmPlayerProvider = var2;
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      descriptor = "(IIB)V",
      garbageValue = "2"
   )
   @Export("setMaxCanvasSize")
   protected final void setMaxCanvasSize(int var1, int var2) {
      if (this.maxCanvasWidth != var1 || var2 != this.maxCanvasHeight) {
         this.method165();
      }

      this.maxCanvasWidth = var1;
      this.maxCanvasHeight = var2;
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/Object;I)V",
      garbageValue = "-2104196567"
   )
   @Export("post")
   final void post(Object var1) {
      if (this.eventQueue != null) {
         for(int var2 = 0; var2 < 50 && this.eventQueue.peekEvent() != null; ++var2) {
            Login.method429(1L);
         }

         if (var1 != null) {
            this.eventQueue.postEvent(new ActionEvent(var1, 1001, "dummy"));
         }

      }
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      descriptor = "(I)Lgc;",
      garbageValue = "-1701222724"
   )
   @Export("mouseWheel")
   protected class171 mouseWheel() {
      if (this.mouseWheelHandler == null) {
         this.mouseWheelHandler = new MouseWheelHandler();
         this.mouseWheelHandler.addTo(this.canvas);
      }

      return this.mouseWheelHandler;
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "-1249824971"
   )
   @Export("setUpClipboard")
   protected void setUpClipboard() {
      this.clipboard = this.getToolkit().getSystemClipboard();
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;I)V",
      garbageValue = "1507261375"
   )
   protected void method142(String var1) {
      this.clipboard.setContents(new StringSelection(var1), (ClipboardOwner)null);
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      descriptor = "(I)Ljava/awt/datatransfer/Clipboard;",
      garbageValue = "-2020792172"
   )
   @Export("getClipboard")
   public Clipboard getClipboard() {
      return this.clipboard;
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "25"
   )
   @Export("setUpKeyboard")
   protected final void setUpKeyboard() {
      if (TaskHandler.javaVendor.toLowerCase().indexOf("microsoft") != -1) {
         class28.KeyHandler_keyCodes[186] = 57;
         class28.KeyHandler_keyCodes[187] = 27;
         class28.KeyHandler_keyCodes[188] = 71;
         class28.KeyHandler_keyCodes[189] = 26;
         class28.KeyHandler_keyCodes[190] = 72;
         class28.KeyHandler_keyCodes[191] = 73;
         class28.KeyHandler_keyCodes[192] = 58;
         class28.KeyHandler_keyCodes[219] = 42;
         class28.KeyHandler_keyCodes[220] = 74;
         class28.KeyHandler_keyCodes[221] = 43;
         class28.KeyHandler_keyCodes[222] = 59;
         class28.KeyHandler_keyCodes[223] = 28;
      } else {
         class28.KeyHandler_keyCodes[44] = 71;
         class28.KeyHandler_keyCodes[45] = 26;
         class28.KeyHandler_keyCodes[46] = 72;
         class28.KeyHandler_keyCodes[47] = 73;
         class28.KeyHandler_keyCodes[59] = 57;
         class28.KeyHandler_keyCodes[61] = 27;
         class28.KeyHandler_keyCodes[91] = 42;
         class28.KeyHandler_keyCodes[92] = 74;
         class28.KeyHandler_keyCodes[93] = 43;
         class28.KeyHandler_keyCodes[192] = 28;
         class28.KeyHandler_keyCodes[222] = 58;
         class28.KeyHandler_keyCodes[520] = 59;
      }

      keyHandler.method100(this.canvas);
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      descriptor = "(S)V",
      garbageValue = "6427"
   )
   protected final void method145() {
      keyHandler.method101();
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      descriptor = "(Lbs;II)V",
      garbageValue = "-987446905"
   )
   protected void method139(class29 var1, int var2) {
      keyHandler.method98(var1, var2);
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "0"
   )
   protected final void method146() {
      AABB.method1242(this.canvas);
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "1946831285"
   )
   @Export("resizeCanvas")
   final void resizeCanvas() {
      Container var1 = this.container();
      if (var1 != null) {
         Bounds var2 = this.getFrameContentBounds();
         this.contentWidth = Math.max(var2.highX, this.field128);
         this.contentHeight = Math.max(var2.highY, this.field112);
         if (this.contentWidth <= 0) {
            this.contentWidth = 1;
         }

         if (this.contentHeight <= 0) {
            this.contentHeight = 1;
         }

         canvasWidth = Math.min(this.contentWidth, this.maxCanvasWidth);
         class143.canvasHeight = Math.min(this.contentHeight, this.maxCanvasHeight);
         this.canvasX = (this.contentWidth - canvasWidth) / 2;
         this.canvasY = 0;
         this.canvas.setSize(canvasWidth, class143.canvasHeight);
         StudioGame.rasterProvider = new RasterProvider(canvasWidth, class143.canvasHeight, this.canvas);
         if (var1 == this.frame) {
            Insets var3 = this.frame.getInsets();
            this.canvas.setLocation(this.canvasX + var3.left, var3.top + this.canvasY);
         } else {
            this.canvas.setLocation(this.canvasX, this.canvasY);
         }

         this.fullRedraw = true;
         this.resizeGame();
      }
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "1315269031"
   )
   @Export("resizeGame")
   protected abstract void resizeGame();

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "11"
   )
   @Export("clearBackground")
   void clearBackground() {
      int var1 = this.canvasX;
      int var2 = this.canvasY;
      int var3 = this.contentWidth - canvasWidth - var1;
      int var4 = this.contentHeight - class143.canvasHeight - var2;
      if (var1 > 0 || var3 > 0 || var2 > 0 || var4 > 0) {
         try {
            Container var5 = this.container();
            int var6 = 0;
            int var7 = 0;
            if (var5 == this.frame) {
               Insets var8 = this.frame.getInsets();
               var6 = var8.left;
               var7 = var8.top;
            }

            Graphics var10 = var5.getGraphics();
            var10.setColor(Color.black);
            if (var1 > 0) {
               var10.fillRect(var6, var7, var1, this.contentHeight);
            }

            if (var2 > 0) {
               var10.fillRect(var6, var7, this.contentWidth, var2);
            }

            if (var3 > 0) {
               var10.fillRect(var6 + this.contentWidth - var3, var7, var3, this.contentHeight);
            }

            if (var4 > 0) {
               var10.fillRect(var6, var7 + this.contentHeight - var4, this.contentWidth, var4);
            }
         } catch (Exception var9) {
            ;
         }
      }

   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "122"
   )
   @Export("replaceCanvas")
   final void replaceCanvas() {
      keyHandler.method102(this.canvas);
      InvDefinition.method925(this.canvas);
      if (this.mouseWheelHandler != null) {
         this.mouseWheelHandler.method86(this.canvas);
      }

      this.addCanvas();
      keyHandler.method100(this.canvas);
      AABB.method1242(this.canvas);
      if (this.mouseWheelHandler != null) {
         this.mouseWheelHandler.addTo(this.canvas);
      }

      this.method165();
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      descriptor = "(IIIII)V",
      garbageValue = "131093465"
   )
   @Export("startThread")
   protected final void startThread(int var1, int var2, int var3, int var4) {
      try {
         if (gameEngine != null) {
            ++GameEngine_redundantStartThreadCount;
            if (GameEngine_redundantStartThreadCount >= 3) {
               this.error("alreadyloaded");
               return;
            }

            this.getAppletContext().showDocument(this.getDocumentBase(), "_self");
            return;
         }

         gameEngine = this;
         canvasWidth = var1;
         class143.canvasHeight = var2;
         RunException.RunException_revision = var3;
         class199.field1633 = var4;
         RunException.RunException_applet = this;
         if (taskHandler == null) {
            taskHandler = new TaskHandler();
         }

         taskHandler.newThreadTask(this, 1);
      } catch (Exception var6) {
         class364.RunException_sendStackTrace((String)null, var6);
         this.error("crash");
      }

   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "1598805112"
   )
   @Export("addCanvas")
   final synchronized void addCanvas() {
      Container var1 = this.container();
      if (this.canvas != null) {
         this.canvas.removeFocusListener(this);
         var1.remove(this.canvas);
      }

      canvasWidth = Math.max(var1.getWidth(), this.field128);
      class143.canvasHeight = Math.max(var1.getHeight(), this.field112);
      Insets var2;
      if (this.frame != null) {
         var2 = this.frame.getInsets();
         canvasWidth -= var2.right + var2.left;
         class143.canvasHeight -= var2.top + var2.bottom;
      }

      this.canvas = new Canvas(this);
      var1.setBackground(Color.BLACK);
      var1.setLayout((LayoutManager)null);
      var1.add(this.canvas);
      this.canvas.setSize(canvasWidth, class143.canvasHeight);
      this.canvas.setVisible(true);
      this.canvas.setBackground(Color.BLACK);
      if (var1 == this.frame) {
         var2 = this.frame.getInsets();
         this.canvas.setLocation(var2.left + this.canvasX, this.canvasY + var2.top);
      } else {
         this.canvas.setLocation(this.canvasX, this.canvasY);
      }

      this.canvas.addFocusListener(this);
      this.canvas.requestFocus();
      this.fullRedraw = true;
      if (StudioGame.rasterProvider != null && canvasWidth == StudioGame.rasterProvider.width && class143.canvasHeight == StudioGame.rasterProvider.height) {
         ((RasterProvider)StudioGame.rasterProvider).setComponent(this.canvas);
         StudioGame.rasterProvider.drawFull(0, 0);
      } else {
         StudioGame.rasterProvider = new RasterProvider(canvasWidth, class143.canvasHeight, this.canvas);
      }

      this.isCanvasInvalid = false;
      this.field121 = WorldMapSection2.clockNow();
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      descriptor = "(I)Z",
      garbageValue = "-2146736962"
   )
   @Export("checkHost")
   protected final boolean checkHost() {
      String var1 = this.getDocumentBase().getHost().toLowerCase();
      if (!var1.equals("jagex.com") && !var1.endsWith(".jagex.com")) {
         if (!var1.equals("runescape.com") && !var1.endsWith(".runescape.com")) {
            if (var1.endsWith("127.0.0.1")) {
               return true;
            } else {
               while(var1.length() > 0 && var1.charAt(var1.length() - 1) >= '0' && var1.charAt(var1.length() - 1) <= '9') {
                  var1 = var1.substring(0, var1.length() - 1);
               }

               if (var1.endsWith("192.168.1.")) {
                  return true;
               } else {
                  this.error("invalidhost");
                  return false;
               }
            }
         } else {
            return true;
         }
      } else {
         return true;
      }
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "-433695714"
   )
   @Export("clientTick")
   void clientTick() {
      long var1 = WorldMapSection2.clockNow();
      long var3 = clientTickTimes[VarpDefinition.field1465];
      clientTickTimes[VarpDefinition.field1465] = var1;
      VarpDefinition.field1465 = VarpDefinition.field1465 + 1 & 31;
      if (var3 != 0L && var1 > var3) {
         ;
      }

      synchronized(this) {
         Varps.hasFocus = volatileFocus;
      }

      this.doCycle();
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "1700389398"
   )
   @Export("graphicsTick")
   void graphicsTick() {
      Container var1 = this.container();
      long var2 = WorldMapSection2.clockNow();
      long var4 = graphicsTickTimes[class212.field1850];
      graphicsTickTimes[class212.field1850] = var2;
      class212.field1850 = class212.field1850 + 1 & 31;
      if (0L != var4 && var2 > var4) {
         int var6 = (int)(var2 - var4);
         fps = ((var6 >> 1) + 32000) / var6;
      }

      if (++field114 - 1 > 50) {
         field114 -= 50;
         this.fullRedraw = true;
         this.canvas.setSize(canvasWidth, class143.canvasHeight);
         this.canvas.setVisible(true);
         if (var1 == this.frame) {
            Insets var7 = this.frame.getInsets();
            this.canvas.setLocation(this.canvasX + var7.left, var7.top + this.canvasY);
         } else {
            this.canvas.setLocation(this.canvasX, this.canvasY);
         }
      }

      if (this.isCanvasInvalid) {
         this.replaceCanvas();
      }

      this.method148();
      this.draw(this.fullRedraw);
      if (this.fullRedraw) {
         this.clearBackground();
      }

      this.fullRedraw = false;
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "-237818236"
   )
   final void method148() {
      Bounds var1 = this.getFrameContentBounds();
      if (this.contentWidth != var1.highX || this.contentHeight != var1.highY || this.resizeCanvasNextFrame) {
         this.resizeCanvas();
         this.resizeCanvasNextFrame = false;
      }

   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "-1502888715"
   )
   final void method165() {
      this.resizeCanvasNextFrame = true;
   }

   @ObfuscatedName("bm")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "12"
   )
   @Export("kill")
   final synchronized void kill() {
      if (!isKilled) {
         isKilled = true;

         try {
            this.canvas.removeFocusListener(this);
         } catch (Exception var5) {
            ;
         }

         try {
            this.kill0();
         } catch (Exception var4) {
            ;
         }

         if (this.frame != null) {
            try {
               System.exit(0);
            } catch (Throwable var3) {
               ;
            }
         }

         if (taskHandler != null) {
            try {
               taskHandler.close();
            } catch (Exception var2) {
               ;
            }
         }

         this.vmethod1485();
      }
   }

   @ObfuscatedName("bk")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "-1812622075"
   )
   @Export("setUp")
   protected abstract void setUp();

   @ObfuscatedName("br")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "32"
   )
   @Export("doCycle")
   protected abstract void doCycle();

   @ObfuscatedName("ba")
   @ObfuscatedSignature(
      descriptor = "(ZS)V",
      garbageValue = "28303"
   )
   @Export("draw")
   protected abstract void draw(boolean var1);

   @ObfuscatedName("bz")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "-78"
   )
   @Export("kill0")
   protected abstract void kill0();

   @ObfuscatedName("bq")
   @ObfuscatedSignature(
      descriptor = "(ILjava/lang/String;ZS)V",
      garbageValue = "1501"
   )
   @Export("drawInitial")
   protected final void drawInitial(int var1, String var2, boolean var3) {
      try {
         Graphics var4 = this.canvas.getGraphics();
         if (class306.fontHelvetica13 == null) {
            class306.fontHelvetica13 = new java.awt.Font("Helvetica", 1, 13);
            class139.loginScreenFontMetrics = this.canvas.getFontMetrics(class306.fontHelvetica13);
         }

         if (var3) {
            var4.setColor(Color.black);
            var4.fillRect(0, 0, canvasWidth, class143.canvasHeight);
         }

         Color var5 = new Color(140, 17, 17);

         try {
            if (AbstractByteArrayCopier.field2987 == null) {
               AbstractByteArrayCopier.field2987 = this.canvas.createImage(304, 34);
            }

            Graphics var6 = AbstractByteArrayCopier.field2987.getGraphics();
            var6.setColor(var5);
            var6.drawRect(0, 0, 303, 33);
            var6.fillRect(2, 2, var1 * 3, 30);
            var6.setColor(Color.black);
            var6.drawRect(1, 1, 301, 31);
            var6.fillRect(var1 * 3 + 2, 2, 300 - var1 * 3, 30);
            var6.setFont(class306.fontHelvetica13);
            var6.setColor(Color.white);
            var6.drawString(var2, (304 - class139.loginScreenFontMetrics.stringWidth(var2)) / 2, 22);
            var4.drawImage(AbstractByteArrayCopier.field2987, canvasWidth / 2 - 152, class143.canvasHeight / 2 - 18, (ImageObserver)null);
         } catch (Exception var9) {
            int var7 = canvasWidth / 2 - 152;
            int var8 = class143.canvasHeight / 2 - 18;
            var4.setColor(var5);
            var4.drawRect(var7, var8, 303, 33);
            var4.fillRect(var7 + 2, var8 + 2, var1 * 3, 30);
            var4.setColor(Color.black);
            var4.drawRect(var7 + 1, var8 + 1, 301, 31);
            var4.fillRect(var7 + var1 * 3 + 2, var8 + 2, 300 - var1 * 3, 30);
            var4.setFont(class306.fontHelvetica13);
            var4.setColor(Color.white);
            var4.drawString(var2, var7 + (304 - class139.loginScreenFontMetrics.stringWidth(var2)) / 2, var8 + 22);
         }
      } catch (Exception var10) {
         this.canvas.repaint();
      }

   }

   @ObfuscatedName("bc")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "3"
   )
   protected final void method157() {
      AbstractByteArrayCopier.field2987 = null;
      class306.fontHelvetica13 = null;
      class139.loginScreenFontMetrics = null;
   }

   @ObfuscatedName("bt")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;I)V",
      garbageValue = "160680772"
   )
   @Export("error")
   protected void error(String var1) {
      if (!this.hasErrored) {
         this.hasErrored = true;
         System.out.println("error_game_" + var1);

         try {
            this.getAppletContext().showDocument(new URL(this.getCodeBase(), "error_game_" + var1 + ".ws"), "_self");
         } catch (Exception var3) {
            ;
         }

      }
   }

   @ObfuscatedName("be")
   @ObfuscatedSignature(
      descriptor = "(I)Ljava/awt/Container;",
      garbageValue = "335116823"
   )
   @Export("container")
   Container container() {
      return (Container)(this.frame != null ? this.frame : this);
   }

   @ObfuscatedName("bu")
   @ObfuscatedSignature(
      descriptor = "(I)Lqy;",
      garbageValue = "-2116397766"
   )
   @Export("getFrameContentBounds")
   Bounds getFrameContentBounds() {
      Container var1 = this.container();
      int var2 = Math.max(var1.getWidth(), this.field128);
      int var3 = Math.max(var1.getHeight(), this.field112);
      if (this.frame != null) {
         Insets var4 = this.frame.getInsets();
         var2 -= var4.right + var4.left;
         var3 -= var4.top + var4.bottom;
      }

      return new Bounds(var2, var3);
   }

   @ObfuscatedName("bd")
   @ObfuscatedSignature(
      descriptor = "(I)Z",
      garbageValue = "-254629922"
   )
   @Export("hasFrame")
   protected final boolean hasFrame() {
      return this.frame != null;
   }

   @ObfuscatedName("bp")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "-87"
   )
   @Export("vmethod1485")
   protected abstract void vmethod1485();

   @Export("destroy")
   @ObfuscatedName("destroy")
   public final void destroy() {
      if (this == gameEngine && !isKilled) {
         stopTimeMs = WorldMapSection2.clockNow();
         Login.method429(5000L);
         this.kill();
      }
   }

   @Export("paint")
   @ObfuscatedName("paint")
   public final synchronized void paint(Graphics var1) {
      if (this == gameEngine && !isKilled) {
         this.fullRedraw = true;
         if (WorldMapSection2.clockNow() - this.field121 > 1000L) {
            Rectangle var2 = var1.getClipBounds();
            if (var2 == null || var2.width >= canvasWidth && var2.height >= class143.canvasHeight) {
               this.isCanvasInvalid = true;
            }
         }

      }
   }

   @Export("run")
   @ObfuscatedName("run")
   public void run() {
      try {
         if (TaskHandler.javaVendor != null) {
            String var1 = TaskHandler.javaVendor.toLowerCase();
            if (var1.indexOf("sun") != -1 || var1.indexOf("apple") != -1) {
               String var2 = TaskHandler.javaVersion;
               if (var2.equals("1.1") || var2.startsWith("1.1.") || var2.equals("1.2") || var2.startsWith("1.2.") || var2.equals("1.3") || var2.startsWith("1.3.") || var2.equals("1.4") || var2.startsWith("1.4.") || var2.equals("1.5") || var2.startsWith("1.5.") || var2.equals("1.6.0")) {
                  this.error("wrongjava");
                  return;
               }

               if (var2.startsWith("1.6.0_")) {
                  int var3;
                  for(var3 = 6; var3 < var2.length() && class28.isDigit(var2.charAt(var3)); ++var3) {
                     ;
                  }

                  String var4 = var2.substring(6, var3);
                  if (class162.isNumber(var4) && GrandExchangeEvent.method1867(var4) < 10) {
                     this.error("wrongjava");
                     return;
                  }
               }

               fiveOrOne = 5;
            }
         }

         this.setFocusCycleRoot(true);
         this.addCanvas();
         this.setUp();
         clock = class421.method2197();

         while(0L == stopTimeMs || WorldMapSection2.clockNow() < stopTimeMs) {
            gameCyclesToDo = clock.wait(cycleDurationMillis, fiveOrOne);

            for(int var5 = 0; var5 < gameCyclesToDo; ++var5) {
               this.clientTick();
            }

            this.graphicsTick();
            this.post(this.canvas);
         }
      } catch (Exception var6) {
         class364.RunException_sendStackTrace((String)null, var6);
         this.error("crash");
      }

      this.kill();
   }

   public final void windowDeactivated(WindowEvent var1) {
   }

   @Export("stop")
   @ObfuscatedName("stop")
   public final void stop() {
      if (this == gameEngine && !isKilled) {
         stopTimeMs = WorldMapSection2.clockNow() + 4000L;
      }
   }

   @Export("update")
   @ObfuscatedName("update")
   public final void update(Graphics var1) {
      this.paint(var1);
   }

   public final void focusLost(FocusEvent var1) {
      volatileFocus = false;
   }

   public final void windowActivated(WindowEvent var1) {
   }

   public final void windowClosed(WindowEvent var1) {
   }

   @Export("windowClosing")
   @ObfuscatedName("windowClosing")
   public final void windowClosing(WindowEvent var1) {
      this.destroy();
   }

   public final void windowIconified(WindowEvent var1) {
   }

   public final void windowOpened(WindowEvent var1) {
   }

   @ObfuscatedName("init")
   public abstract void init();

   @Export("start")
   @ObfuscatedName("start")
   public final void start() {
      if (this == gameEngine && !isKilled) {
         stopTimeMs = 0L;
      }
   }

   public final void windowDeiconified(WindowEvent var1) {
   }

   @Export("focusGained")
   @ObfuscatedName("focusGained")
   public final void focusGained(FocusEvent var1) {
      volatileFocus = true;
      this.fullRedraw = true;
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "(II)Lhc;",
      garbageValue = "976952306"
   )
   @Export("VarpDefinition_get")
   public static VarpDefinition VarpDefinition_get(int var0) {
      VarpDefinition var1 = (VarpDefinition)VarpDefinition.VarpDefinition_cached.get((long)var0);
      if (var1 != null) {
         return var1;
      } else {
         byte[] var2 = VarpDefinition.VarpDefinition_archive.takeFile(16, var0);
         var1 = new VarpDefinition();
         if (var2 != null) {
            var1.decode(new Buffer(var2));
         }

         VarpDefinition.VarpDefinition_cached.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("km")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "-141536950"
   )
   @Export("Widget_runOnTargetLeave")
   static void Widget_runOnTargetLeave() {
      if (Client.isSpellSelected) {
         Widget var0 = class36.getWidgetChild(class18.selectedSpellWidget, Client.selectedSpellChildIndex);
         if (var0 != null && var0.onTargetLeave != null) {
            ScriptEvent var1 = new ScriptEvent();
            var1.widget = var0;
            var1.args = var0.onTargetLeave;
            class9.runScriptEvent(var1);
         }

         Client.selectedSpellItemId = -1;
         Client.isSpellSelected = false;
         class69.invalidateWidget(var0);
      }
   }
}
