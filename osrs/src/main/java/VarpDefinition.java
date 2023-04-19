import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gz")
@Implements("VarpDefinition")
public class VarpDefinition extends DualNode {
    @ObfuscatedName("af")
    @ObfuscatedSignature(
            descriptor = "Lnm;"
    )
    public static AbstractArchive VarpDefinition_archive;
   @ObfuscatedName("an")
   public static int field1475;
    @ObfuscatedName("aw")
    @ObfuscatedSignature(
            descriptor = "Lkh;"
    )
    public static EvictingDualNodeHashTable VarpDefinition_cached = new EvictingDualNodeHashTable(64);
    @ObfuscatedName("al")
    public static int musicTrackFileId;
    @ObfuscatedName("ac")
    public int type = 0;

    @ObfuscatedName("an")
    @ObfuscatedSignature(
            descriptor = "(Lsg;I)V",
            garbageValue = "955579844"
    )
    void decode(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if (var2 == 0) {
            return;
         }

         this.decodeNext(var1, var2);
      }
   }

    @ObfuscatedName("aw")
    @ObfuscatedSignature(
            descriptor = "(Lsg;II)V",
            garbageValue = "1359565158"
    )
    void decodeNext(Buffer var1, int var2) {
      if (var2 == 5) {
         this.type = var1.readUnsignedShort();
      }

   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "(IIII)Ltq;",
      garbageValue = "2091722822"
   )
   static SpritePixels method982(int var0, int var1, int var2) {
      return (SpritePixels)WorldMapRegion.WorldMapRegion_cachedSprites.get(BuddyRankComparator.method710(var0, var1, var2));
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      descriptor = "(I)[Ley;",
      garbageValue = "335062925"
   )
   static class126[] method983() {
      return new class126[]{class126.field1243, class126.field1240, class126.field1241, class126.field1246, class126.field1247, class126.field1244};
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      descriptor = "(IIII)V",
      garbageValue = "-1740756415"
   )
   public static void method981(int var0, int var1, int var2) {
      Rasterizer3D.clips.method1360(var0, var1, var2);
   }
}
