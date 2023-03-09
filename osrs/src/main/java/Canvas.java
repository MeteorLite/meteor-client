import java.awt.Component;
import java.awt.Graphics;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aa")
@Implements("Canvas")
public final class Canvas extends java.awt.Canvas {
   @ObfuscatedName("uj")
   @Export("cameraLookAtY")
   static int cameraLookAtY;
   @ObfuscatedName("an")
   @Export("SpriteBuffer_yOffsets")
   public static int[] SpriteBuffer_yOffsets;
   @ObfuscatedName("ar")
   static int field70;
   @ObfuscatedName("aj")
   @Export("component")
   Component component;

   Canvas(Component var1) {
      this.component = var1;
   }

   public final void paint(Graphics var1) {
      this.component.paint(var1);
   }

   public final void update(Graphics var1) {
      this.component.update(var1);
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "([Ljava/lang/String;[IB)V",
      garbageValue = "123"
   )
   public static void method91(String[] var0, int[] var1) {
      HealthBar.method557(var0, var1, 0, var0.length - 1);
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "(IB)Ljava/lang/String;",
      garbageValue = "-22"
   )
   @Export("colorStartTag")
   static String colorStartTag(int var0) {
      return "<col=" + Integer.toHexString(var0) + ">";
   }
}
