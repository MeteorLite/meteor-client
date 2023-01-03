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
   public static int MouseHandler_y = 0;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      descriptor = "Lab;"
   )
   public static MouseHandler MouseHandler_instance = new MouseHandler();
   @ObfuscatedName("q")
   public static volatile int MouseHandler_idleCycles = 0;
   @ObfuscatedName("f")
   public static volatile int MouseHandler_currentButtonVolatile = 0;
   @ObfuscatedName("r")
   public static volatile int MouseHandler_xVolatile = -1;
   @ObfuscatedName("u")
   public static volatile int MouseHandler_yVolatile = -1;
   @ObfuscatedName("b")
   public static volatile long MouseHandler_lastMovedVolatile = -1L;
   @ObfuscatedName("j")
   public static int MouseHandler_currentButton = 0;
   @ObfuscatedName("g")
   public static int MouseHandler_x = 0;
   @ObfuscatedName("i")
   public static long MouseHandler_millis = 0L;
   @ObfuscatedName("o")
   public static volatile int MouseHandler_lastButtonVolatile = 0;
   @ObfuscatedName("n")
   public static volatile int MouseHandler_lastPressedXVolatile = 0;
   @ObfuscatedName("k")
   public static volatile int MouseHandler_lastPressedYVolatile = 0;
   @ObfuscatedName("a")
   public static volatile long MouseHandler_lastPressedTimeMillisVolatile = 0L;
   @ObfuscatedName("s")
   public static int MouseHandler_lastButton = 0;
   @ObfuscatedName("l")
   public static int MouseHandler_lastPressedX = 0;
   @ObfuscatedName("t")
   public static int MouseHandler_lastPressedY = 0;
   @ObfuscatedName("c")
   public static long MouseHandler_lastPressedTimeMillis = 0L;
   @ObfuscatedName("ih")
   @ObfuscatedSignature(
      descriptor = "[Lrx;"
   )
   static SpritePixels[] crossSprites;
   @ObfuscatedName("nb")
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
