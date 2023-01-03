import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("nh")
@Implements("Timer")
public class Timer {
   @ObfuscatedName("vx")
   static Iterator field3652;
   @ObfuscatedName("h")
   long field3650 = -1L;
   @ObfuscatedName("e")
   long field3648 = -1L;
   @ObfuscatedName("v")
   public boolean field3644 = false;
   @ObfuscatedName("x")
   long field3642 = 0L;
   @ObfuscatedName("m")
   long field3646 = 0L;
   @ObfuscatedName("q")
   long field3647 = 0L;
   @ObfuscatedName("f")
   int field3645 = 0;
   @ObfuscatedName("r")
   int field3649 = 0;
   @ObfuscatedName("u")
   int field3643 = 0;
   @ObfuscatedName("b")
   int field3651 = 0;

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(S)V",
      garbageValue = "-26308"
   )
   public void method2005() {
      this.field3650 = Message.method344();
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "5"
   )
   public void method2000() {
      if (-1L != this.field3650) {
         this.field3646 = Message.method344() - this.field3650;
         this.field3650 = -1L;
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "(IB)V",
      garbageValue = "4"
   )
   public void method2001(int var1) {
      this.field3648 = Message.method344();
      this.field3645 = var1;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "1829013009"
   )
   public void method2002() {
      if (this.field3648 != -1L) {
         this.field3642 = Message.method344() - this.field3648;
         this.field3648 = -1L;
      }

      ++this.field3643;
      this.field3644 = true;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "-223931045"
   )
   public void method2003() {
      this.field3644 = false;
      this.field3649 = 0;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "-420900063"
   )
   public void method1999() {
      this.method2002();
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "(Lqy;B)V",
      garbageValue = "-113"
   )
   @Export("write")
   public void write(Buffer var1) {
      long var2 = this.field3646;
      var2 /= 10L;
      if (var2 < 0L) {
         var2 = 0L;
      } else if (var2 > 65535L) {
         var2 = 65535L;
      }

      var1.writeShort((int)var2);
      long var4 = this.field3642;
      var4 /= 10L;
      if (var4 < 0L) {
         var4 = 0L;
      } else if (var4 > 65535L) {
         var4 = 65535L;
      }

      var1.writeShort((int)var4);
      long var6 = this.field3647;
      var6 /= 10L;
      if (var6 < 0L) {
         var6 = 0L;
      } else if (var6 > 65535L) {
         var6 = 65535L;
      }

      var1.writeShort((int)var6);
      var1.writeShort(this.field3645);
      var1.writeShort(this.field3649);
      var1.writeShort(this.field3643);
      var1.writeShort(this.field3651);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      descriptor = "(Lly;Lly;III)Lnv;",
      garbageValue = "1891121533"
   )
   public static Font method2007(AbstractArchive var0, AbstractArchive var1, int var2, int var3) {
      byte[] var5 = var0.takeFile(var2, var3);
      boolean var4;
      if (var5 == null) {
         var4 = false;
      } else {
         VarpDefinition.SpriteBuffer_decode(var5);
         var4 = true;
      }

      if (!var4) {
         return null;
      } else {
         byte[] var6 = var1.takeFile(var2, var3);
         Font var8;
         if (var6 == null) {
            var8 = null;
         } else {
            Font var7 = new Font(var6, class481.SpriteBuffer_xOffsets, class414.SpriteBuffer_yOffsets, class11.SpriteBuffer_spriteWidths, StructComposition.SpriteBuffer_spriteHeights, WorldMapEvent.SpriteBuffer_spritePalette, FloorDecoration.SpriteBuffer_pixels);
            class481.SpriteBuffer_xOffsets = null;
            class414.SpriteBuffer_yOffsets = null;
            class11.SpriteBuffer_spriteWidths = null;
            StructComposition.SpriteBuffer_spriteHeights = null;
            WorldMapEvent.SpriteBuffer_spritePalette = null;
            FloorDecoration.SpriteBuffer_pixels = null;
            var8 = var7;
         }

         return var8;
      }
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      descriptor = "([BIIS)I",
      garbageValue = "-5416"
   )
   static int method2006(byte[] var0, int var1, int var2) {
      int var3 = -1;

      for(int var4 = var1; var4 < var2; ++var4) {
         var3 = var3 >>> 8 ^ Buffer.crc32Table[(var3 ^ var0[var4]) & 255];
      }

      var3 = ~var3;
      return var3;
   }
}
