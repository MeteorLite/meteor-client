import java.awt.Component;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("y")
@Implements("KeyHandler")
public class KeyHandler implements KeyListener, FocusListener {
    @ObfuscatedName("av")
    @ObfuscatedSignature(
            descriptor = "Lrv;"
    )
    public static AbstractRasterProvider rasterProvider;
    @ObfuscatedName("ch")
    @ObfuscatedSignature(
            descriptor = "[Lrg;"
    )
    static IndexedSprite[] worldSelectStars;
   @ObfuscatedName("ie")
   static int field86;
    @ObfuscatedName("nr")
    @ObfuscatedSignature(
            descriptor = "Lkz;"
    )
    static Widget mousedOverWidgetIf1;
   @ObfuscatedName("w")
   Collection field85 = new ArrayList(100);
   @ObfuscatedName("v")
   Collection field91 = new ArrayList(100);
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      descriptor = "[Lag;"
   )
   class29[] field89 = new class29[3];
    @ObfuscatedName("z")
    boolean[] KeyHandler_pressedKeys = new boolean[112];
    @ObfuscatedName("j")
    volatile int KeyHandler_idleCycles = 0;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "(Lag;IB)V",
      garbageValue = "-21"
   )
   void method90(class29 var1, int var2) {
      this.field89[var2] = var1;
   }

    @ObfuscatedName("w")
    @ObfuscatedSignature(
            descriptor = "(I)I",
            garbageValue = "2042589970"
    )
    public int getIdleCycles() {
      return this.KeyHandler_idleCycles;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "(Ljava/awt/Component;I)V",
      garbageValue = "719186766"
   )
   void method92(Component var1) {
      var1.setFocusTraversalKeysEnabled(false);
      var1.addKeyListener(this);
      var1.addFocusListener(this);
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      descriptor = "(Ljava/awt/Component;I)V",
      garbageValue = "1271861184"
   )
   synchronized void method95(Component var1) {
      var1.removeKeyListener(this);
      var1.removeFocusListener(this);
      synchronized(this) {
         this.field85.add(new class33(4, 0));
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "-7"
   )
   void method93() {
      ++this.KeyHandler_idleCycles;
      this.method89();
      Iterator var1 = this.field91.iterator();

      while(var1.hasNext()) {
         class33 var2 = (class33)var1.next();

         for(int var3 = 0; var3 < this.field89.length && !var2.method133(this.field89[var3]); ++var3) {
            ;
         }
      }

      this.field91.clear();
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "-850276975"
   )
   synchronized void method89() {
      Collection var1 = this.field91;
      this.field91 = this.field85;
      this.field85 = var1;
   }

    @ObfuscatedName("keyPressed")
    public final synchronized void keyPressed(KeyEvent var1) {
      int var2 = var1.getKeyCode();
      if (var2 >= 0 && var2 < PcmPlayer.method213()) {
         var2 = GrandExchangeOfferUnitPriceComparator.method1863(var2);
         if (class203.method1074(var2)) {
            var2 = -1;
         }
      } else {
         var2 = -1;
      }

      if (var2 >= 0) {
         this.KeyHandler_pressedKeys[var2] = true;
         this.field85.add(new class33(1, var2));
         this.KeyHandler_idleCycles = 0;
      }

      var1.consume();
   }

    @ObfuscatedName("keyReleased")
    public final synchronized void keyReleased(KeyEvent var1) {
      int var2 = var1.getKeyCode();
      if (var2 >= 0 && var2 < PcmPlayer.method213()) {
         var2 = GrandExchangeOfferUnitPriceComparator.method1863(var2) & -129;
      } else {
         var2 = -1;
      }

      if (var2 >= 0) {
         this.KeyHandler_pressedKeys[var2] = false;
         this.field85.add(new class33(2, var2));
      }

      var1.consume();
   }

    @ObfuscatedName("keyTyped")
    public final synchronized void keyTyped(KeyEvent var1) {
      char var2 = var1.getKeyChar();
      if (var2 != 0 && var2 != '\uffff') {
         boolean var3;
         if (var2 > 0 && var2 < 128 || var2 >= 160 && var2 <= 255) {
            var3 = true;
         } else {
            label53: {
               if (var2 != 0) {
                  char[] var4 = class362.cp1252AsciiExtension;

                  for(int var5 = 0; var5 < var4.length; ++var5) {
                     char var6 = var4[var5];
                     if (var6 == var2) {
                        var3 = true;
                        break label53;
                     }
                  }
               }

               var3 = false;
            }
         }

         if (var3) {
            this.field85.add(new class33(3, var2));
         }
      }

      var1.consume();
   }

    @ObfuscatedName("focusLost")
    public final synchronized void focusLost(FocusEvent var1) {
      for(int var2 = 0; var2 < 112; ++var2) {
         if (this.KeyHandler_pressedKeys[var2]) {
            this.KeyHandler_pressedKeys[var2] = false;
            this.field85.add(new class33(2, var2));
         }
      }

      this.field85.add(new class33(4, 0));
   }

   public final synchronized void focusGained(FocusEvent var1) {
      this.field85.add(new class33(4, 1));
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      descriptor = "(CII)Ljava/lang/String;",
      garbageValue = "-1112576285"
   )
   public static String method94(char var0, int var1) {
      char[] var2 = new char[var1];

      for(int var3 = 0; var3 < var1; ++var3) {
         var2[var3] = var0;
      }

      return new String(var2);
   }
}
