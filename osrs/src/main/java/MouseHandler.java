import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ab")
public class MouseHandler implements MouseListener, MouseMotionListener, FocusListener {
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -467089053
   )
   public static int MouseHandler_y = 0;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      descriptor = "Lab;"
   )
   public static MouseHandler MouseHandler_instance = new MouseHandler();
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -666107829
   )
   public static volatile int MouseHandler_idleCycles = 0;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1780151387
   )
   public static volatile int MouseHandler_currentButtonVolatile = 0;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -178516955
   )
   public static volatile int MouseHandler_xVolatile = -1;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1239267453
   )
   public static volatile int MouseHandler_yVolatile = -1;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      longValue = 4716901357680916313L
   )
   public static volatile long MouseHandler_lastMovedVolatile = -1L;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1144336295
   )
   public static int MouseHandler_currentButton = 0;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1055725291
   )
   public static int MouseHandler_x = 0;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      longValue = 1841814800481912317L
   )
   public static long MouseHandler_millis = 0L;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1359580461
   )
   public static volatile int MouseHandler_lastButtonVolatile = 0;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1431798489
   )
   public static volatile int MouseHandler_lastPressedXVolatile = 0;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -231426227
   )
   public static volatile int MouseHandler_lastPressedYVolatile = 0;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      longValue = -1319422683492569027L
   )
   public static volatile long MouseHandler_lastPressedTimeMillisVolatile = 0L;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1573473759
   )
   public static int MouseHandler_lastButton = 0;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1391909665
   )
   public static int MouseHandler_lastPressedX = 0;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -255937079
   )
   public static int MouseHandler_lastPressedY = 0;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      longValue = -3284909752288296989L
   )
   public static long MouseHandler_lastPressedTimeMillis = 0L;
   @ObfuscatedName("ih")
   @ObfuscatedSignature(
      descriptor = "[Lrx;"
   )
   static SpritePixels[] crossSprites;
   @ObfuscatedName("nb")
   @ObfuscatedGetter(
      intValue = -1112640559
   )
   static int menuHeight;
   @ObfuscatedName("pr")
   @ObfuscatedSignature(
      descriptor = "[Lkd;"
   )
   static Widget[] field268;

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

   public final synchronized void mousePressed(MouseEvent var1) {
      if (MouseHandler_instance != null) {
         MouseHandler_idleCycles = 0;
         MouseHandler_lastPressedXVolatile = var1.getX();
         MouseHandler_lastPressedYVolatile = var1.getY();
         MouseHandler_lastPressedTimeMillisVolatile = Message.method1197();
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
   static final int method700(int var0, int var1, int var2, int var3) {
      int var4 = 65536 - Rasterizer3D.Rasterizer3D_cosine[var2 * 1024 / var3] >> 1;
      return ((65536 - var4) * var0 >> 16) + (var4 * var1 >> 16);
   }
}
