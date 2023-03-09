import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ba")
@Implements("MouseHandler")
public class MouseHandler implements MouseListener, MouseMotionListener, FocusListener {
   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "Lba;"
   )
   @Export("MouseHandler_instance")
   public static MouseHandler MouseHandler_instance = new MouseHandler();
   @ObfuscatedName("an")
   @Export("MouseHandler_idleCycles")
   public static volatile int MouseHandler_idleCycles = 0;
   @ObfuscatedName("ao")
   @Export("MouseHandler_currentButtonVolatile")
   public static volatile int MouseHandler_currentButtonVolatile = 0;
   @ObfuscatedName("av")
   @Export("MouseHandler_xVolatile")
   public static volatile int MouseHandler_xVolatile = -1;
   @ObfuscatedName("aq")
   @Export("MouseHandler_yVolatile")
   public static volatile int MouseHandler_yVolatile = -1;
   @ObfuscatedName("ap")
   @Export("MouseHandler_lastMovedVolatile")
   public static volatile long MouseHandler_lastMovedVolatile = -1L;
   @ObfuscatedName("ar")
   @Export("MouseHandler_currentButton")
   public static int MouseHandler_currentButton = 0;
   @ObfuscatedName("ak")
   @Export("MouseHandler_x")
   public static int MouseHandler_x = 0;
   @ObfuscatedName("ax")
   @Export("MouseHandler_y")
   public static int MouseHandler_y = 0;
   @ObfuscatedName("as")
   @Export("MouseHandler_millis")
   public static long MouseHandler_millis = 0L;
   @ObfuscatedName("ay")
   @Export("MouseHandler_lastButtonVolatile")
   public static volatile int MouseHandler_lastButtonVolatile = 0;
   @ObfuscatedName("am")
   @Export("MouseHandler_lastPressedXVolatile")
   public static volatile int MouseHandler_lastPressedXVolatile = 0;
   @ObfuscatedName("az")
   @Export("MouseHandler_lastPressedYVolatile")
   public static volatile int MouseHandler_lastPressedYVolatile = 0;
   @ObfuscatedName("ae")
   @Export("MouseHandler_lastPressedTimeMillisVolatile")
   public static volatile long MouseHandler_lastPressedTimeMillisVolatile = 0L;
   @ObfuscatedName("au")
   @Export("MouseHandler_lastButton")
   public static int MouseHandler_lastButton = 0;
   @ObfuscatedName("ag")
   @Export("MouseHandler_lastPressedX")
   public static int MouseHandler_lastPressedX = 0;
   @ObfuscatedName("at")
   @Export("MouseHandler_lastPressedY")
   public static int MouseHandler_lastPressedY = 0;
   @ObfuscatedName("af")
   @Export("MouseHandler_lastPressedTimeMillis")
   public static long MouseHandler_lastPressedTimeMillis = 0L;

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "(Ljava/awt/event/MouseEvent;I)I",
      garbageValue = "-1524282401"
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

   public final synchronized void focusLost(FocusEvent var1) {
      if (MouseHandler_instance != null) {
         MouseHandler_currentButtonVolatile = 0;
      }

   }

   @Export("mousePressed")
   @ObfuscatedName("mousePressed")
   public final synchronized void mousePressed(MouseEvent var1) {
      if (MouseHandler_instance != null) {
         MouseHandler_idleCycles = 0;
         MouseHandler_lastPressedXVolatile = var1.getX();
         MouseHandler_lastPressedYVolatile = var1.getY();
         MouseHandler_lastPressedTimeMillisVolatile = WorldMapSection2.clockNow();
         MouseHandler_lastButtonVolatile = this.getButton(var1);
         if (MouseHandler_lastButtonVolatile != 0) {
            MouseHandler_currentButtonVolatile = MouseHandler_lastButtonVolatile;
         }
      }

      if (var1.isPopupTrigger()) {
         var1.consume();
      }

   }

   public final synchronized void mouseEntered(MouseEvent var1) {
      this.mouseMoved(var1);
   }

   public final synchronized void mouseDragged(MouseEvent var1) {
      this.mouseMoved(var1);
   }

   public final void focusGained(FocusEvent var1) {
   }

   @Export("mouseClicked")
   @ObfuscatedName("mouseClicked")
   public final void mouseClicked(MouseEvent var1) {
      if (var1.isPopupTrigger()) {
         var1.consume();
      }

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

   public final synchronized void mouseExited(MouseEvent var1) {
      if (MouseHandler_instance != null) {
         MouseHandler_idleCycles = 0;
         MouseHandler_xVolatile = -1;
         MouseHandler_yVolatile = -1;
         MouseHandler_lastMovedVolatile = var1.getWhen();
      }

   }
}
