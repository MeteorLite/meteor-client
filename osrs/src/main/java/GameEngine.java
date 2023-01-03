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

import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("an")
@Implements("GameEngine")
public abstract class GameEngine extends Applet implements Runnable, FocusListener, WindowListener {
   @ObfuscatedName("vo")
   @ObfuscatedSignature(
      descriptor = "Lms;"
   )
   public static class343 field129;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "Lan;"
   )
   static GameEngine gameEngine = null;
   @ObfuscatedName("v")
   static int GameEngine_redundantStartThreadCount = 0;
   @ObfuscatedName("m")
   static long stopTimeMs = 0L;
   @ObfuscatedName("q")
   static boolean isKilled = false;
   @ObfuscatedName("u")
   static int cycleDurationMillis = 20;
   @ObfuscatedName("b")
   static int fiveOrOne = 1;
   @ObfuscatedName("j")
   protected static int fps = 0;
   @ObfuscatedName("o")
   static long[] graphicsTickTimes = new long[32];
   @ObfuscatedName("k")
   static long[] clientTickTimes = new long[32];
   @ObfuscatedName("an")
   static int field118 = 500;
   @ObfuscatedName("ah")
   static volatile boolean volatileFocus = true;
   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "Las;"
   )
   static KeyHandler keyHandler = new KeyHandler();
   @ObfuscatedName("ap")
   static long garbageCollectorLastCollectionTime = -1L;
   @ObfuscatedName("aa")
   static long garbageCollectorLastCheckTimeMs = -1L;
   @ObfuscatedName("f")
   boolean hasErrored = false;
   @ObfuscatedName("s")
   protected int contentWidth;
   @ObfuscatedName("l")
   protected int contentHeight;
   @ObfuscatedName("t")
   int canvasX = 0;
   @ObfuscatedName("c")
   int canvasY = 0;
   @ObfuscatedName("z")
   int field111;
   @ObfuscatedName("as")
   int field98;
   @ObfuscatedName("ad")
   int maxCanvasWidth;
   @ObfuscatedName("ao")
   int maxCanvasHeight;
   @ObfuscatedName("au")
   Frame frame;
   @ObfuscatedName("ar")
   java.awt.Canvas canvas;
   @ObfuscatedName("at")
   volatile boolean fullRedraw = true;
   @ObfuscatedName("ab")
   boolean resizeCanvasNextFrame = false;
   @ObfuscatedName("al")
   volatile boolean isCanvasInvalid = false;
   @ObfuscatedName("ag")
   volatile long field121 = 0L;
   @ObfuscatedName("af")
   @ObfuscatedSignature(
      descriptor = "Ld;"
   )
   MouseWheelHandler mouseWheelHandler;
   @ObfuscatedName("ai")
   Clipboard clipboard;
   @ObfuscatedName("ax")
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
      class20.pcmPlayerProvider = var2;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      descriptor = "(III)V",
      garbageValue = "1034759117"
   )
   protected final void setMaxCanvasSize(int var1, int var2) {
      if (this.maxCanvasWidth != var1 || var2 != this.maxCanvasHeight) {
         this.method160();
      }

      this.maxCanvasWidth = var1;
      this.maxCanvasHeight = var2;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/Object;I)V",
      garbageValue = "812093850"
   )
   final void post(Object var1) {
      if (this.eventQueue != null) {
         for(int var2 = 0; var2 < 50 && this.eventQueue.peekEvent() != null; ++var2) {
            class12.method44(1L);
         }

         if (var1 != null) {
            this.eventQueue.postEvent(new ActionEvent(var1, 1001, "dummy"));
         }

      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      descriptor = "(I)Lff;",
      garbageValue = "815709128"
   )
   protected class166 mouseWheel() {
      if (this.mouseWheelHandler == null) {
         this.mouseWheelHandler = new MouseWheelHandler();
         this.mouseWheelHandler.addTo(this.canvas);
      }

      return this.mouseWheelHandler;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "-65"
   )
   protected void setUpClipboard() {
      this.clipboard = this.getToolkit().getSystemClipboard();
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;S)V",
      garbageValue = "26091"
   )
   protected void method148(String var1) {
      this.clipboard.setContents(new StringSelection(var1), (ClipboardOwner)null);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      descriptor = "(B)Ljava/awt/datatransfer/Clipboard;",
      garbageValue = "10"
   )
   public Clipboard method149() {
      return this.clipboard;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "316580569"
   )
   protected final void setUpKeyboard() {
      if (TaskHandler.javaVendor.toLowerCase().indexOf("microsoft") != -1) {
         class29.KeyHandler_keyCodes[186] = 57;
         class29.KeyHandler_keyCodes[187] = 27;
         class29.KeyHandler_keyCodes[188] = 71;
         class29.KeyHandler_keyCodes[189] = 26;
         class29.KeyHandler_keyCodes[190] = 72;
         class29.KeyHandler_keyCodes[191] = 73;
         class29.KeyHandler_keyCodes[192] = 58;
         class29.KeyHandler_keyCodes[219] = 42;
         class29.KeyHandler_keyCodes[220] = 74;
         class29.KeyHandler_keyCodes[221] = 43;
         class29.KeyHandler_keyCodes[222] = 59;
         class29.KeyHandler_keyCodes[223] = 28;
      } else {
         class29.KeyHandler_keyCodes[44] = 71;
         class29.KeyHandler_keyCodes[45] = 26;
         class29.KeyHandler_keyCodes[46] = 72;
         class29.KeyHandler_keyCodes[47] = 73;
         class29.KeyHandler_keyCodes[59] = 57;
         class29.KeyHandler_keyCodes[61] = 27;
         class29.KeyHandler_keyCodes[91] = 42;
         class29.KeyHandler_keyCodes[92] = 74;
         class29.KeyHandler_keyCodes[93] = 43;
         class29.KeyHandler_keyCodes[192] = 28;
         class29.KeyHandler_keyCodes[222] = 58;
         class29.KeyHandler_keyCodes[520] = 59;
      }

      keyHandler.method94(this.canvas);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "504544713"
   )
   protected final void method151() {
      keyHandler.method96();
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      descriptor = "(Lav;IB)V",
      garbageValue = "0"
   )
   protected void method152(class30 var1, int var2) {
      keyHandler.method92(var1, var2);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "848418077"
   )
   protected final void method169() {
      java.awt.Canvas var1 = this.canvas;
      var1.addMouseListener(MouseHandler.MouseHandler_instance);
      var1.addMouseMotionListener(MouseHandler.MouseHandler_instance);
      var1.addFocusListener(MouseHandler.MouseHandler_instance);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "-1257419471"
   )
   final void resizeCanvas() {
      Container var1 = this.container();
      if (var1 != null) {
         Bounds var2 = this.getFrameContentBounds();
         this.contentWidth = Math.max(var2.highX, this.field111);
         this.contentHeight = Math.max(var2.highY, this.field98);
         if (this.contentWidth <= 0) {
            this.contentWidth = 1;
         }

         if (this.contentHeight <= 0) {
            this.contentHeight = 1;
         }

         CollisionMap.canvasWidth = Math.min(this.contentWidth, this.maxCanvasWidth);
         Language.canvasHeight = Math.min(this.contentHeight, this.maxCanvasHeight);
         this.canvasX = (this.contentWidth - CollisionMap.canvasWidth) / 2;
         this.canvasY = 0;
         this.canvas.setSize(CollisionMap.canvasWidth, Language.canvasHeight);
         RouteStrategy.rasterProvider = new RasterProvider(CollisionMap.canvasWidth, Language.canvasHeight, this.canvas);
         if (var1 == this.frame) {
            Insets var3 = this.frame.getInsets();
            this.canvas.setLocation(var3.left + this.canvasX, this.canvasY + var3.top);
         } else {
            this.canvas.setLocation(this.canvasX, this.canvasY);
         }

         this.fullRedraw = true;
         this.resizeGame();
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "-101"
   )
   protected abstract void resizeGame();

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "-1765015837"
   )
   void clearBackground() {
      int var1 = this.canvasX;
      int var2 = this.canvasY;
      int var3 = this.contentWidth - CollisionMap.canvasWidth - var1;
      int var4 = this.contentHeight - Language.canvasHeight - var2;
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

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "1144522069"
   )
   final void replaceCanvas() {
      keyHandler.method91(this.canvas);
      AttackOption.method598(this.canvas);
      if (this.mouseWheelHandler != null) {
         this.mouseWheelHandler.method79(this.canvas);
      }

      this.addCanvas();
      keyHandler.method94(this.canvas);
      java.awt.Canvas var1 = this.canvas;
      var1.addMouseListener(MouseHandler.MouseHandler_instance);
      var1.addMouseMotionListener(MouseHandler.MouseHandler_instance);
      var1.addFocusListener(MouseHandler.MouseHandler_instance);
      if (this.mouseWheelHandler != null) {
         this.mouseWheelHandler.addTo(this.canvas);
      }

      this.method160();
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      descriptor = "(IIIIB)V",
      garbageValue = "-39"
   )
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
         CollisionMap.canvasWidth = var1;
         Language.canvasHeight = var2;
         RunException.RunException_revision = var3;
         RunException.field4112 = var4;
         class422.RunException_applet = this;
         if (class242.taskHandler == null) {
            class242.taskHandler = new TaskHandler();
         }

         class242.taskHandler.newThreadTask(this, 1);
      } catch (Exception var6) {
         class132.RunException_sendStackTrace((String)null, var6);
         this.error("crash");
      }

   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "62"
   )
   final synchronized void addCanvas() {
      Container var1 = this.container();
      if (this.canvas != null) {
         this.canvas.removeFocusListener(this);
         var1.remove(this.canvas);
      }

      CollisionMap.canvasWidth = Math.max(var1.getWidth(), this.field111);
      Language.canvasHeight = Math.max(var1.getHeight(), this.field98);
      Insets var2;
      if (this.frame != null) {
         var2 = this.frame.getInsets();
         CollisionMap.canvasWidth -= var2.right + var2.left;
         Language.canvasHeight -= var2.bottom + var2.top;
      }

      this.canvas = new Canvas(this);
      var1.setBackground(Color.BLACK);
      var1.setLayout((LayoutManager)null);
      var1.add(this.canvas);
      this.canvas.setSize(CollisionMap.canvasWidth, Language.canvasHeight);
      this.canvas.setVisible(true);
      this.canvas.setBackground(Color.BLACK);
      if (var1 == this.frame) {
         var2 = this.frame.getInsets();
         this.canvas.setLocation(this.canvasX + var2.left, var2.top + this.canvasY);
      } else {
         this.canvas.setLocation(this.canvasX, this.canvasY);
      }

      this.canvas.addFocusListener(this);
      this.canvas.requestFocus();
      this.fullRedraw = true;
      if (RouteStrategy.rasterProvider != null && CollisionMap.canvasWidth == RouteStrategy.rasterProvider.width && Language.canvasHeight == RouteStrategy.rasterProvider.height) {
         ((RasterProvider)RouteStrategy.rasterProvider).setComponent(this.canvas);
         RouteStrategy.rasterProvider.drawFull(0, 0);
      } else {
         RouteStrategy.rasterProvider = new RasterProvider(CollisionMap.canvasWidth, Language.canvasHeight, this.canvas);
      }

      this.isCanvasInvalid = false;
      this.field121 = Message.clockNow();
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      descriptor = "(B)Z",
      garbageValue = "88"
   )
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

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "-42"
   )
   void clientTick() {
      long var1 = Message.clockNow();
      long var3 = clientTickTimes[class1.field2];
      clientTickTimes[class1.field2] = var1;
      class1.field2 = class1.field2 + 1 & 31;
      if (0L != var3 && var1 > var3) {
         ;
      }

      synchronized(this) {
         PacketBuffer.hasFocus = volatileFocus;
      }

      this.doCycle();
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "683817333"
   )
   void graphicsTick() {
      Container var1 = this.container();
      long var2 = Message.clockNow();
      long var4 = graphicsTickTimes[AbstractRasterProvider.field4059];
      graphicsTickTimes[AbstractRasterProvider.field4059] = var2;
      AbstractRasterProvider.field4059 = AbstractRasterProvider.field4059 + 1 & 31;
      if (0L != var4 && var2 > var4) {
         int var6 = (int)(var2 - var4);
         fps = ((var6 >> 1) + 32000) / var6;
      }

      if (++field118 - 1 > 50) {
         field118 -= 50;
         this.fullRedraw = true;
         this.canvas.setSize(CollisionMap.canvasWidth, Language.canvasHeight);
         this.canvas.setVisible(true);
         if (var1 == this.frame) {
            Insets var7 = this.frame.getInsets();
            this.canvas.setLocation(var7.left + this.canvasX, this.canvasY + var7.top);
         } else {
            this.canvas.setLocation(this.canvasX, this.canvasY);
         }
      }

      if (this.isCanvasInvalid) {
         this.replaceCanvas();
      }

      this.method159();
      this.draw(this.fullRedraw);
      if (this.fullRedraw) {
         this.clearBackground();
      }

      this.fullRedraw = false;
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "-1669783800"
   )
   final void method159() {
      Bounds var1 = this.getFrameContentBounds();
      if (this.contentWidth != var1.highX || this.contentHeight != var1.highY || this.resizeCanvasNextFrame) {
         this.resizeCanvas();
         this.resizeCanvasNextFrame = false;
      }

   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      descriptor = "(S)V",
      garbageValue = "22596"
   )
   final void method160() {
      this.resizeCanvasNextFrame = true;
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "-1133942382"
   )
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

         if (class242.taskHandler != null) {
            try {
               class242.taskHandler.close();
            } catch (Exception var2) {
               ;
            }
         }

         this.vmethod1485();
      }
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "0"
   )
   protected abstract void setUp();

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "-22"
   )
   protected abstract void doCycle();

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "(ZI)V",
      garbageValue = "920051106"
   )
   protected abstract void draw(boolean var1);

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "1295386641"
   )
   protected abstract void kill0();

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      descriptor = "(ILjava/lang/String;ZI)V",
      garbageValue = "1038398992"
   )
   protected final void drawInitial(int var1, String var2, boolean var3) {
      try {
         Graphics var4 = this.canvas.getGraphics();
         if (class20.fontHelvetica13 == null) {
            class20.fontHelvetica13 = new java.awt.Font("Helvetica", 1, 13);
            Messages.loginScreenFontMetrics = this.canvas.getFontMetrics(class20.fontHelvetica13);
         }

         if (var3) {
            var4.setColor(Color.black);
            var4.fillRect(0, 0, CollisionMap.canvasWidth, Language.canvasHeight);
         }

         Color var5 = new Color(140, 17, 17);

         try {
            if (class69.field713 == null) {
               class69.field713 = this.canvas.createImage(304, 34);
            }

            Graphics var6 = class69.field713.getGraphics();
            var6.setColor(var5);
            var6.drawRect(0, 0, 303, 33);
            var6.fillRect(2, 2, var1 * 3, 30);
            var6.setColor(Color.black);
            var6.drawRect(1, 1, 301, 31);
            var6.fillRect(var1 * 3 + 2, 2, 300 - var1 * 3, 30);
            var6.setFont(class20.fontHelvetica13);
            var6.setColor(Color.white);
            var6.drawString(var2, (304 - Messages.loginScreenFontMetrics.stringWidth(var2)) / 2, 22);
            var4.drawImage(class69.field713, CollisionMap.canvasWidth / 2 - 152, Language.canvasHeight / 2 - 18, (ImageObserver)null);
         } catch (Exception var9) {
            int var7 = CollisionMap.canvasWidth / 2 - 152;
            int var8 = Language.canvasHeight / 2 - 18;
            var4.setColor(var5);
            var4.drawRect(var7, var8, 303, 33);
            var4.fillRect(var7 + 2, var8 + 2, var1 * 3, 30);
            var4.setColor(Color.black);
            var4.drawRect(var7 + 1, var8 + 1, 301, 31);
            var4.fillRect(var7 + var1 * 3 + 2, var8 + 2, 300 - var1 * 3, 30);
            var4.setFont(class20.fontHelvetica13);
            var4.setColor(Color.white);
            var4.drawString(var2, var7 + (304 - Messages.loginScreenFontMetrics.stringWidth(var2)) / 2, var8 + 22);
         }
      } catch (Exception var10) {
         this.canvas.repaint();
      }

   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "1741242852"
   )
   protected final void method166() {
      class69.field713 = null;
      class20.fontHelvetica13 = null;
      Messages.loginScreenFontMetrics = null;
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;I)V",
      garbageValue = "754431924"
   )
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

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      descriptor = "(I)Ljava/awt/Container;",
      garbageValue = "-1750796052"
   )
   Container container() {
      return (Container)(this.frame != null ? this.frame : this);
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      descriptor = "(I)Lok;",
      garbageValue = "1915646281"
   )
   Bounds getFrameContentBounds() {
      Container var1 = this.container();
      int var2 = Math.max(var1.getWidth(), this.field111);
      int var3 = Math.max(var1.getHeight(), this.field98);
      if (this.frame != null) {
         Insets var4 = this.frame.getInsets();
         var2 -= var4.right + var4.left;
         var3 -= var4.bottom + var4.top;
      }

      return new Bounds(var2, var3);
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      descriptor = "(I)Z",
      garbageValue = "-1602409348"
   )
   protected final boolean hasFrame() {
      return this.frame != null;
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "1344730333"
   )
   protected abstract void vmethod1485();

   @ObfuscatedName("destroy")
   public final void destroy() {
      if (this == gameEngine && !isKilled) {
         stopTimeMs = Message.clockNow();
         class12.method44(5000L);
         this.kill();
      }
   }

   @ObfuscatedName("paint")
   public final synchronized void paint(Graphics var1) {
      if (this == gameEngine && !isKilled) {
         this.fullRedraw = true;
         if (Message.clockNow() - this.field121 > 1000L) {
            Rectangle var2 = var1.getClipBounds();
            if (var2 == null || var2.width >= CollisionMap.canvasWidth && var2.height >= Language.canvasHeight) {
               this.isCanvasInvalid = true;
            }
         }

      }
   }

   @ObfuscatedName("stop")
   public final void stop() {
      if (this == gameEngine && !isKilled) {
         stopTimeMs = Message.clockNow() + 4000L;
      }
   }

   @ObfuscatedName("focusGained")
   public final void focusGained(FocusEvent var1) {
      volatileFocus = true;
      this.fullRedraw = true;
   }

   public final void windowDeiconified(WindowEvent var1) {
   }

   public final void windowIconified(WindowEvent var1) {
   }

   public final void windowOpened(WindowEvent var1) {
   }

   @ObfuscatedName("init")
   public abstract void init();

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
                  for(var3 = 6; var3 < var2.length() && WorldMapLabelSize.isDigit(var2.charAt(var3)); ++var3) {
                     ;
                  }

                  String var4 = var2.substring(6, var3);
                  if (class346.isNumber(var4) && class412.method2151(var4) < 10) {
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

         Object var8;
         try {
            var8 = new NanoClock();
         } catch (Throwable var6) {
            var8 = new MilliClock();
         }

         UrlRequest.clock = (Clock)var8;

         while(0L == stopTimeMs || Message.clockNow() < stopTimeMs) {
            class173.gameCyclesToDo = UrlRequest.clock.wait(cycleDurationMillis, fiveOrOne);

            for(int var5 = 0; var5 < class173.gameCyclesToDo; ++var5) {
               this.clientTick();
            }

            this.graphicsTick();
            this.post(this.canvas);
         }
      } catch (Exception var7) {
         class132.RunException_sendStackTrace((String)null, var7);
         this.error("crash");
      }

      this.kill();
   }

   @ObfuscatedName("start")
   public final void start() {
      if (this == gameEngine && !isKilled) {
         stopTimeMs = 0L;
      }
   }

   @ObfuscatedName("update")
   public final void update(Graphics var1) {
      this.paint(var1);
   }

   public final void windowDeactivated(WindowEvent var1) {
   }

   public final void windowClosed(WindowEvent var1) {
   }

   public final void focusLost(FocusEvent var1) {
      volatileFocus = false;
   }

   @ObfuscatedName("windowClosing")
   public final void windowClosing(WindowEvent var1) {
      this.destroy();
   }

   public final void windowActivated(WindowEvent var1) {
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      descriptor = "(IIIZIB)J",
      garbageValue = "22"
   )
   public static long calculateTag(int var0, int var1, int var2, boolean var3, int var4) {
      long var5 = (long)((var0 & 127) << 0 | (var1 & 127) << 7 | (var2 & 3) << 14) | ((long)var4 & 4294967295L) << 17;
      if (var3) {
         var5 |= 65536L;
      }

      return var5;
   }

   @ObfuscatedName("hj")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "1631778915"
   )
   static void method179() {
      PacketBufferNode var0 = class136.getPacketBufferNode(ClientPacket.field2441, Client.packetWriter.isaacCipher);
      var0.packetBuffer.writeByte(Message.getWindowedMode());
      var0.packetBuffer.writeShort(CollisionMap.canvasWidth);
      var0.packetBuffer.writeShort(Language.canvasHeight);
      Client.packetWriter.addNode(var0);
   }

   @ObfuscatedName("ig")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "-53"
   )
   static final void method180() {
      FontName.method2255(false);
      Client.field446 = 0;
      boolean var0 = true;

      int var1;
      for(var1 = 0; var1 < class133.regionLandArchives.length; ++var1) {
         if (Client.regionMapArchiveIds[var1] != -1 && class133.regionLandArchives[var1] == null) {
            class133.regionLandArchives[var1] = class4.archive9.takeFile(Client.regionMapArchiveIds[var1], 0);
            if (class133.regionLandArchives[var1] == null) {
               var0 = false;
               ++Client.field446;
            }
         }

         if (class379.regionLandArchiveIds[var1] != -1 && class241.regionMapArchives[var1] == null) {
            class241.regionMapArchives[var1] = class4.archive9.takeFileEncrypted(class379.regionLandArchiveIds[var1], 0, class104.xteaKeys[var1]);
            if (class241.regionMapArchives[var1] == null) {
               var0 = false;
               ++Client.field446;
            }
         }
      }

      if (!var0) {
         Client.field503 = 1;
      } else {
         Client.field631 = 0;
         var0 = true;

         int var3;
         int var4;
         for(var1 = 0; var1 < class133.regionLandArchives.length; ++var1) {
            byte[] var2 = class241.regionMapArchives[var1];
            if (var2 != null) {
               var3 = (class205.regions[var1] >> 8) * 64 - class154.baseX;
               var4 = (class205.regions[var1] & 255) * 64 - class365.baseY;
               if (Client.isInInstance) {
                  var3 = 10;
                  var4 = 10;
               }

               var0 &= Tiles.method461(var2, var3, var4);
            }
         }

         if (!var0) {
            Client.field503 = 2;
         } else {
            if (Client.field503 != 0) {
               SoundSystem.drawLoadingMessage("Loading - please wait." + "<br>" + " (" + 100 + "%" + ")", true);
            }

            Client.playPcmPlayers();
            ReflectionCheck.scene.clear();

            for(var1 = 0; var1 < 4; ++var1) {
               Client.collisionMaps[var1].clear();
            }

            int var15;
            for(var1 = 0; var1 < 4; ++var1) {
               for(var15 = 0; var15 < 104; ++var15) {
                  for(var3 = 0; var3 < 104; ++var3) {
                     Tiles.Tiles_renderFlags[var1][var15][var3] = 0;
                  }
               }
            }

            Client.playPcmPlayers();
            GrandExchangeEvent.method1836();
            var1 = class133.regionLandArchives.length;
            UrlRequester.method644();
            FontName.method2255(true);
            int var17;
            if (!Client.isInInstance) {
               byte[] var5;
               for(var15 = 0; var15 < var1; ++var15) {
                  var3 = (class205.regions[var15] >> 8) * 64 - class154.baseX;
                  var4 = (class205.regions[var15] & 255) * 64 - class365.baseY;
                  var5 = class133.regionLandArchives[var15];
                  if (var5 != null) {
                     Client.playPcmPlayers();
                     class14.method48(var5, var3, var4, class17.timeOfPreviousKeyPress * 8 - 48, MusicPatchNode2.field2707 * 8 - 48, Client.collisionMaps);
                  }
               }

               for(var15 = 0; var15 < var1; ++var15) {
                  var3 = (class205.regions[var15] >> 8) * 64 - class154.baseX;
                  var4 = (class205.regions[var15] & 255) * 64 - class365.baseY;
                  var5 = class133.regionLandArchives[var15];
                  if (var5 == null && MusicPatchNode2.field2707 < 800) {
                     Client.playPcmPlayers();
                     class71.method430(var3, var4, 64, 64);
                  }
               }

               FontName.method2255(true);

               for(var15 = 0; var15 < var1; ++var15) {
                  byte[] var16 = class241.regionMapArchives[var15];
                  if (var16 != null) {
                     var4 = (class205.regions[var15] >> 8) * 64 - class154.baseX;
                     var17 = (class205.regions[var15] & 255) * 64 - class365.baseY;
                     Client.playPcmPlayers();
                     class139.method745(var16, var4, var17, ReflectionCheck.scene, Client.collisionMaps);
                  }
               }
            }

            int var6;
            int var7;
            int var8;
            if (Client.isInInstance) {
               int var9;
               int var10;
               int var11;
               for(var15 = 0; var15 < 4; ++var15) {
                  Client.playPcmPlayers();

                  for(var3 = 0; var3 < 13; ++var3) {
                     for(var4 = 0; var4 < 13; ++var4) {
                        boolean var19 = false;
                        var6 = Client.instanceChunkTemplates[var15][var3][var4];
                        if (var6 != -1) {
                           var7 = var6 >> 24 & 3;
                           var8 = var6 >> 1 & 3;
                           var9 = var6 >> 14 & 1023;
                           var10 = var6 >> 3 & 2047;
                           var11 = (var9 / 8 << 8) + var10 / 8;

                           for(int var12 = 0; var12 < class205.regions.length; ++var12) {
                              if (class205.regions[var12] == var11 && class133.regionLandArchives[var12] != null) {
                                 int var13 = (var9 - var3) * 8;
                                 int var14 = (var10 - var4) * 8;
                                 KeyHandler.method97(class133.regionLandArchives[var12], var15, var3 * 8, var4 * 8, var7, (var9 & 7) * 8, (var10 & 7) * 8, var8, var13, var14, Client.collisionMaps);
                                 var19 = true;
                                 break;
                              }
                           }
                        }

                        if (!var19) {
                           ScriptFrame.method331(var15, var3 * 8, var4 * 8);
                        }
                     }
                  }
               }

               for(var15 = 0; var15 < 13; ++var15) {
                  for(var3 = 0; var3 < 13; ++var3) {
                     var4 = Client.instanceChunkTemplates[0][var15][var3];
                     if (var4 == -1) {
                        class71.method430(var15 * 8, var3 * 8, 8, 8);
                     }
                  }
               }

               FontName.method2255(true);

               for(var15 = 0; var15 < 4; ++var15) {
                  Client.playPcmPlayers();

                  for(var3 = 0; var3 < 13; ++var3) {
                     for(var4 = 0; var4 < 13; ++var4) {
                        var17 = Client.instanceChunkTemplates[var15][var3][var4];
                        if (var17 != -1) {
                           var6 = var17 >> 24 & 3;
                           var7 = var17 >> 1 & 3;
                           var8 = var17 >> 14 & 1023;
                           var9 = var17 >> 3 & 2047;
                           var10 = (var8 / 8 << 8) + var9 / 8;

                           for(var11 = 0; var11 < class205.regions.length; ++var11) {
                              if (class205.regions[var11] == var10 && class241.regionMapArchives[var11] != null) {
                                 Tiles.method460(class241.regionMapArchives[var11], var15, var3 * 8, var4 * 8, var6, (var8 & 7) * 8, (var9 & 7) * 8, var7, ReflectionCheck.scene, Client.collisionMaps);
                                 break;
                              }
                           }
                        }
                     }
                  }
               }
            }

            FontName.method2255(true);
            Client.playPcmPlayers();
            WorldMapIcon_1.method1317(ReflectionCheck.scene, Client.collisionMaps);
            FontName.method2255(true);
            var15 = Tiles.Tiles_minPlane;
            if (var15 > class383.Client_plane) {
               var15 = class383.Client_plane;
            }

            if (var15 < class383.Client_plane - 1) {
               var15 = class383.Client_plane - 1;
            }

            if (Client.isLowDetail) {
               ReflectionCheck.scene.init(Tiles.Tiles_minPlane);
            } else {
               ReflectionCheck.scene.init(0);
            }

            for(var3 = 0; var3 < 104; ++var3) {
               for(var4 = 0; var4 < 104; ++var4) {
                  class358.updateItemPile(var3, var4);
               }
            }

            Client.playPcmPlayers();
            MoveSpeed.method1105();
            ObjectComposition.ObjectDefinition_cachedModelData.clear();
            PacketBufferNode var18;
            if (BuddyRankComparator.client.hasFrame()) {
               var18 = class136.getPacketBufferNode(ClientPacket.field2514, Client.packetWriter.isaacCipher);
               var18.packetBuffer.writeInt(1057001181);
               Client.packetWriter.addNode(var18);
            }

            if (!Client.isInInstance) {
               var3 = (class17.timeOfPreviousKeyPress - 6) / 8;
               var4 = (class17.timeOfPreviousKeyPress + 6) / 8;
               var17 = (MusicPatchNode2.field2707 - 6) / 8;
               var6 = (MusicPatchNode2.field2707 + 6) / 8;

               for(var7 = var3 - 1; var7 <= var4 + 1; ++var7) {
                  for(var8 = var17 - 1; var8 <= var6 + 1; ++var8) {
                     if (var7 < var3 || var7 > var4 || var8 < var17 || var8 > var6) {
                        class4.archive9.loadRegionFromName("m" + var7 + "_" + var8);
                        class4.archive9.loadRegionFromName("l" + var7 + "_" + var8);
                     }
                  }
               }
            }

            class140.updateGameState(30);
            Client.playPcmPlayers();
            class384.method2012();
            var18 = class136.getPacketBufferNode(ClientPacket.field2491, Client.packetWriter.isaacCipher);
            Client.packetWriter.addNode(var18);
            class29.method117();
         }
      }
   }

   @ObfuscatedName("mz")
   @ObfuscatedSignature(
      descriptor = "(IIIILrx;Lkv;I)V",
      garbageValue = "-2077430533"
   )
   static final void worldToMinimap(int var0, int var1, int var2, int var3, SpritePixels var4, SpriteMask var5) {
      int var6 = var3 * var3 + var2 * var2;
      if (var6 > 4225 && var6 < 90000) {
         int var7 = Client.camAngleY & 2047;
         int var8 = Rasterizer3D.Rasterizer3D_sine[var7];
         int var9 = Rasterizer3D.Rasterizer3D_cosine[var7];
         int var10 = var9 * var2 + var3 * var8 >> 16;
         int var11 = var3 * var9 - var8 * var2 >> 16;
         double var12 = Math.atan2((double)var10, (double)var11);
         int var14 = var5.width / 2 - 25;
         int var15 = (int)(Math.sin(var12) * (double)var14);
         int var16 = (int)(Math.cos(var12) * (double)var14);
         byte var17 = 20;
         class139.redHintArrowSprite.method2485(var15 + (var0 + var5.width / 2 - var17 / 2), var5.height / 2 + var1 - var17 / 2 - var16 - 10, var17, var17, 15, 15, var12, 256);
      } else {
         class282.drawSpriteOnMinimap(var0, var1, var2, var3, var4, var5);
      }

   }

   @ObfuscatedName("ml")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "766208383"
   )
   static final void method170() {
      Client.field562 = Client.cycleCntr;
      BufferedSink.field3726 = true;
   }
}
