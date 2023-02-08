import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ns")
@Implements("Timer")
public class Timer {
   @ObfuscatedName("f")
   long field3650 = -1L;
   @ObfuscatedName("w")
   long field3649 = -1L;
   @ObfuscatedName("v")
   public boolean field3655 = false;
   @ObfuscatedName("s")
   long field3651 = 0L;
   @ObfuscatedName("z")
   long field3657 = 0L;
   @ObfuscatedName("j")
   long field3653 = 0L;
   @ObfuscatedName("i")
   int field3654 = 0;
   @ObfuscatedName("n")
   int field3648 = 0;
   @ObfuscatedName("l")
   int field3656 = 0;
   @ObfuscatedName("k")
   int field3652 = 0;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "-1022354551"
   )
   public void method2023() {
      this.field3650 = class153.clockNow();
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "1441360663"
   )
   public void method2021() {
      if (-1L != this.field3650) {
         this.field3657 = class153.clockNow() - this.field3650;
         this.field3650 = -1L;
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "(IB)V",
      garbageValue = "-21"
   )
   public void method2026(int var1) {
      this.field3649 = class153.clockNow();
      this.field3654 = var1;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "1971822075"
   )
   public void method2022() {
      if (this.field3649 != -1L) {
         this.field3651 = class153.clockNow() - this.field3649;
         this.field3649 = -1L;
      }

      ++this.field3656;
      this.field3655 = true;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "35"
   )
   public void method2025() {
      this.field3655 = false;
      this.field3648 = 0;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "1398178117"
   )
   public void method2024() {
      this.method2022();
   }

    @ObfuscatedName("i")
    @ObfuscatedSignature(
            descriptor = "(Lrd;I)V",
            garbageValue = "8909785"
    )
    public void write(Buffer var1) {
      ServerPacket.method1539(var1, this.field3657);
      ServerPacket.method1539(var1, this.field3651);
      ServerPacket.method1539(var1, this.field3653);
      var1.writeShort(this.field3654);
      var1.writeShort(this.field3648);
      var1.writeShort(this.field3656);
      var1.writeShort(this.field3652);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "-96"
   )
   static void method2027() {
      Tiles.Tiles_underlays = null;
      class172.Tiles_overlays = null;
      Tiles.Tiles_shapes = null;
      Tiles.field835 = null;
      class312.field3014 = null;
      Tiles.field836 = null;
      class323.field3055 = null;
      class100.Tiles_hue = null;
      class161.Tiles_saturation = null;
      Tiles.Tiles_lightness = null;
      class463.Tiles_hueMultiplier = null;
      SceneTilePaint.field2195 = null;
   }
}
