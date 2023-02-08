import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ax")
@Implements("MouseHandler")
public class MouseHandler implements MouseListener, MouseMotionListener, FocusListener {
    @ObfuscatedName("s")
    @ObfuscatedSignature(
            descriptor = "Lax;"
    )
    public static MouseHandler MouseHandler_instance = new MouseHandler();
    @ObfuscatedName("z")
    public static volatile int MouseHandler_idleCycles = 0;
    @ObfuscatedName("j")
    static volatile int MouseHandler_currentButtonVolatile = 0;
    @ObfuscatedName("i")
    static volatile int MouseHandler_xVolatile = -1;
    @ObfuscatedName("n")
    static volatile int MouseHandler_yVolatile = -1;
    @ObfuscatedName("l")
    static volatile long MouseHandler_lastMovedVolatile = -1L;
    @ObfuscatedName("k")
    public static int MouseHandler_x = 0;
    @ObfuscatedName("c")
    public static int MouseHandler_currentButton = 0;
    @ObfuscatedName("r")
    public static int MouseHandler_y = 0;
    @ObfuscatedName("b")
    public static long MouseHandler_millis = 0L;
    @ObfuscatedName("m")
    static volatile int MouseHandler_lastButtonVolatile = 0;
    @ObfuscatedName("t")
    static volatile int MouseHandler_lastPressedXVolatile = 0;
    @ObfuscatedName("h")
    static volatile int MouseHandler_lastPressedYVolatile = 0;
    @ObfuscatedName("p")
    static volatile long MouseHandler_lastPressedTimeMillisVolatile = 0L;
    @ObfuscatedName("o")
    public static int MouseHandler_lastButton = 0;
    @ObfuscatedName("u")
    public static int MouseHandler_lastPressedX = 0;
    @ObfuscatedName("x")
    public static int MouseHandler_lastPressedY = 0;
    @ObfuscatedName("a")
    public static long MouseHandler_lastPressedTimeMillis = 0L;
   @ObfuscatedName("ph")
   @ObfuscatedSignature(
      descriptor = "[Lkz;"
   )
   static Widget[] field159;

    @ObfuscatedName("s")
    @ObfuscatedSignature(
            descriptor = "(Ljava/awt/event/MouseEvent;I)I",
            garbageValue = "-1007792141"
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

    @ObfuscatedName("mousePressed")
    public final synchronized void mousePressed(MouseEvent var1) {
      if (MouseHandler_instance != null) {
         MouseHandler_idleCycles = 0;
         MouseHandler_lastPressedXVolatile = var1.getX();
         MouseHandler_lastPressedYVolatile = var1.getY();
         MouseHandler_lastPressedTimeMillisVolatile = class153.clockNow();
         MouseHandler_lastButtonVolatile = this.getButton(var1);
         if (MouseHandler_lastButtonVolatile != 0) {
            MouseHandler_currentButtonVolatile = MouseHandler_lastButtonVolatile;
         }
      }

      if (var1.isPopupTrigger()) {
         var1.consume();
      }

   }

    @ObfuscatedName("mouseClicked")
    public final void mouseClicked(MouseEvent var1) {
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

   public final synchronized void focusLost(FocusEvent var1) {
      if (MouseHandler_instance != null) {
         MouseHandler_currentButtonVolatile = 0;
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

   public final void focusGained(FocusEvent var1) {
   }
}
