import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fx")
public class class137 extends class139 {
    @ObfuscatedName("ip")
    @ObfuscatedSignature(
            descriptor = "Lon;"
    )
    static Font fontBold12;
   @ObfuscatedName("af")
   long field1311;
   @ObfuscatedName("an")
   String field1312;
   // $FF: synthetic field
   @ObfuscatedSignature(
      descriptor = "Lfa;"
   )
   final class142 this$0;

   @ObfuscatedSignature(
      descriptor = "(Lfa;)V"
   )
   class137(class142 var1) {
      this.this$0 = var1;
      this.field1311 = -1L;
      this.field1312 = null;
   }

    @ObfuscatedName("af")
    @ObfuscatedSignature(
            descriptor = "(Lsg;I)V",
            garbageValue = "168736686"
    )
    void vmethod3254(Buffer var1) {
      if (var1.readUnsignedByte() != 255) {
         --var1.offset;
         this.field1311 = var1.readLong();
      }

      this.field1312 = var1.readStringCp1252NullTerminatedOrNull();
   }

    @ObfuscatedName("an")
    @ObfuscatedSignature(
            descriptor = "(Lfj;I)V",
            garbageValue = "1712319228"
    )
    void vmethod3248(ClanSettings var1) {
      var1.method849(this.field1311, this.field1312, 0);
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "-876753180"
   )
   static void method792() {
      Tiles.Tiles_minPlane = 99;
      class186.Tiles_underlays = new short[4][104][104];
      Tiles.Tiles_overlays = new short[4][104][104];
      Tiles.Tiles_shapes = new byte[4][104][104];
      Tiles.field824 = new byte[4][104][104];
      class161.field1407 = new int[4][105][105];
      Tiles.field819 = new byte[4][105][105];
      Tiles.field821 = new int[105][105];
      FileSystem.Tiles_hue = new int[104];
      Tiles.Tiles_saturation = new int[104];
      class283.Tiles_lightness = new int[104];
      UserComparator4.Tiles_hueMultiplier = new int[104];
      class31.field92 = new int[104];
   }
}
