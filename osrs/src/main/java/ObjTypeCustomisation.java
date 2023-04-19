import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gx")
@Implements("ObjTypeCustomisation")
public class ObjTypeCustomisation {
   @ObfuscatedName("ut")
   static int field1471;
    @ObfuscatedName("aw")
    public short[] recol;
    @ObfuscatedName("ac")
    public short[] retex;

   ObjTypeCustomisation(int var1) {
      ItemComposition var2 = HealthBarUpdate.ItemDefinition_get(var1);
      if (var2.hasRecolor()) {
         this.recol = new short[var2.recolorTo.length];
         System.arraycopy(var2.recolorTo, 0, this.recol, 0, this.recol.length);
      }

      if (var2.hasRetexture()) {
         this.retex = new short[var2.retextureTo.length];
         System.arraycopy(var2.retextureTo, 0, this.retex, 0, this.retex.length);
      }

   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "(Lsg;II)V",
      garbageValue = "-1564700734"
   )
   public static void method972(Buffer var0, int var1) {
      if (JagexCache.JagexCache_randomDat != null) {
         try {
            JagexCache.JagexCache_randomDat.seek(0L);
            JagexCache.JagexCache_randomDat.write(var0.array, var1, 24);
         } catch (Exception var3) {
            ;
         }
      }

   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      descriptor = "(I)Ltq;",
      garbageValue = "-1490841904"
   )
   static SpritePixels method973() {
      SpritePixels var0 = new SpritePixels();
      var0.width = class503.SpriteBuffer_spriteWidth;
      var0.height = class503.SpriteBuffer_spriteHeight;
      var0.xOffset = class503.SpriteBuffer_xOffsets[0];
      var0.yOffset = class17.SpriteBuffer_yOffsets[0];
      var0.subWidth = class97.SpriteBuffer_spriteWidths[0];
      var0.subHeight = class138.SpriteBuffer_spriteHeights[0];
      int var1 = var0.subHeight * var0.subWidth;
      byte[] var2 = VarbitComposition.SpriteBuffer_pixels[0];
      var0.pixels = new int[var1];

      for(int var3 = 0; var3 < var1; ++var3) {
         var0.pixels[var3] = class394.SpriteBuffer_spritePalette[var2[var3] & 255];
      }

      class398.method2125();
      return var0;
   }

   @ObfuscatedName("bw")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;B)I",
      garbageValue = "5"
   )
   public static int method971(String var0) {
      return var0.length() + 2;
   }
}
