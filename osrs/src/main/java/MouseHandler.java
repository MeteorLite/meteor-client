import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ab")
@Implements("MouseHandler")
public class MouseHandler implements MouseListener, MouseMotionListener, FocusListener {
   @ObfuscatedName("x")
   @Export("MouseHandler_y")
   public static int MouseHandler_y = 0;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      descriptor = "Lab;"
   )
   @Export("MouseHandler_instance")
   public static MouseHandler MouseHandler_instance = new MouseHandler();
   @ObfuscatedName("q")
   @Export("MouseHandler_idleCycles")
   public static volatile int MouseHandler_idleCycles = 0;
   @ObfuscatedName("f")
   @Export("MouseHandler_currentButtonVolatile")
   public static volatile int MouseHandler_currentButtonVolatile = 0;
   @ObfuscatedName("r")
   @Export("MouseHandler_xVolatile")
   public static volatile int MouseHandler_xVolatile = -1;
   @ObfuscatedName("u")
   @Export("MouseHandler_yVolatile")
   public static volatile int MouseHandler_yVolatile = -1;
   @ObfuscatedName("b")
   @Export("MouseHandler_lastMovedVolatile")
   public static volatile long MouseHandler_lastMovedVolatile = -1L;
   @ObfuscatedName("j")
   @Export("MouseHandler_currentButton")
   public static int MouseHandler_currentButton = 0;
   @ObfuscatedName("g")
   @Export("MouseHandler_x")
   public static int MouseHandler_x = 0;
   @ObfuscatedName("i")
   @Export("MouseHandler_millis")
   public static long MouseHandler_millis = 0L;
   @ObfuscatedName("o")
   @Export("MouseHandler_lastButtonVolatile")
   public static volatile int MouseHandler_lastButtonVolatile = 0;
   @ObfuscatedName("n")
   @Export("MouseHandler_lastPressedXVolatile")
   public static volatile int MouseHandler_lastPressedXVolatile = 0;
   @ObfuscatedName("k")
   @Export("MouseHandler_lastPressedYVolatile")
   public static volatile int MouseHandler_lastPressedYVolatile = 0;
   @ObfuscatedName("a")
   @Export("MouseHandler_lastPressedTimeMillisVolatile")
   public static volatile long MouseHandler_lastPressedTimeMillisVolatile = 0L;
   @ObfuscatedName("s")
   @Export("MouseHandler_lastButton")
   public static int MouseHandler_lastButton = 0;
   @ObfuscatedName("l")
   @Export("MouseHandler_lastPressedX")
   public static int MouseHandler_lastPressedX = 0;
   @ObfuscatedName("t")
   @Export("MouseHandler_lastPressedY")
   public static int MouseHandler_lastPressedY = 0;
   @ObfuscatedName("c")
   @Export("MouseHandler_lastPressedTimeMillis")
   public static long MouseHandler_lastPressedTimeMillis = 0L;
   @ObfuscatedName("ih")
   @ObfuscatedSignature(
      descriptor = "[Lrx;"
   )
   @Export("crossSprites")
   static SpritePixels[] crossSprites;
   @ObfuscatedName("nb")
   @Export("menuHeight")
   static int menuHeight;
   @ObfuscatedName("pr")
   @ObfuscatedSignature(
      descriptor = "[Lkd;"
   )
   static Widget[] field151;

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "(Ljava/awt/event/MouseEvent;B)I",
      garbageValue = "116"
   )
   @Export("getButton")
   final int getButton(MouseEvent var1) {
      int var2 = var1.getButton();
      if (!var1.isAltDown() && var2 != 2) {
         return !var1.isMetaDown() && var2 != 3 ? 1 : 2;
      } else {
         return 4;
      }
   }

   public final synchronized void mouseMoved(MouseEvent var1) {
      if (MouseHandler_instance != null) {
         MouseHandler_idleCycles = 0;
         MouseHandler_xVolatile = var1.getX();
         MouseHandler_yVolatile = var1.getY();
         MouseHandler_lastMovedVolatile = var1.getWhen();
      }

   }

   public final void focusGained(FocusEvent var1) {
   }

   @Export("mouseReleased")
   @ObfuscatedName("mouseReleased")
   public final synchronized void mouseReleased(MouseEvent var1) {
      if (MouseHandler_instance != null) {
         MouseHandler_idleCycles = 0;
         MouseHandler_currentButtonVolatile = 0;
      }

      if (var1.isPopupTrigger()) {
         var1.consume();
      }

   }

   public final synchronized void mouseEntered(MouseEvent var1) {
      this.mouseMoved(var1);
   }

   @Export("mouseClicked")
   @ObfuscatedName("mouseClicked")
   public final void mouseClicked(MouseEvent var1) {
      if (var1.isPopupTrigger()) {
         var1.consume();
      }

   }

   public final synchronized void mouseExited(MouseEvent var1) {
      if (MouseHandler_instance != null) {
         MouseHandler_idleCycles = 0;
         MouseHandler_xVolatile = -1;
         MouseHandler_yVolatile = -1;
         MouseHandler_lastMovedVolatile = var1.getWhen();
      }

   }

   public final synchronized void focusLost(FocusEvent var1) {
      if (MouseHandler_instance != null) {
         MouseHandler_currentButtonVolatile = 0;
      }

   }

   public final synchronized void mouseDragged(MouseEvent var1) {
      this.mouseMoved(var1);
   }

   @Export("mousePressed")
   @ObfuscatedName("mousePressed")
   public final synchronized void mousePressed(MouseEvent var1) {
      if (MouseHandler_instance != null) {
         MouseHandler_idleCycles = 0;
         MouseHandler_lastPressedXVolatile = var1.getX();
         MouseHandler_lastPressedYVolatile = var1.getY();
         MouseHandler_lastPressedTimeMillisVolatile = Message.method344();
         MouseHandler_lastButtonVolatile = this.getButton(var1);
         if (MouseHandler_lastButtonVolatile != 0) {
            MouseHandler_currentButtonVolatile = MouseHandler_lastButtonVolatile;
         }
      }

      if (var1.isPopupTrigger()) {
         var1.consume();
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      descriptor = "(IIIIB)I",
      garbageValue = "-23"
   )
   static final int method183(int var0, int var1, int var2, int var3) {
      int var4 = 65536 - Rasterizer3D.Rasterizer3D_cosine[var2 * 1024 / var3] >> 1;
      return ((65536 - var4) * var0 >> 16) + (var4 * var1 >> 16);
   }
}
