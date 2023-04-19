import java.util.LinkedList;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jz")
@Implements("AbstractWorldMapData")
public abstract class AbstractWorldMapData {
    @ObfuscatedName("au")
    int regionXLow;
    @ObfuscatedName("ab")
    int regionYLow;
    @ObfuscatedName("aq")
    int regionX;
    @ObfuscatedName("al")
    int regionY;
    @ObfuscatedName("at")
    int minPlane;
    @ObfuscatedName("aa")
    int planes;
    @ObfuscatedName("ay")
    int groupId = -1;
    @ObfuscatedName("ao")
    int fileId = -1;
    @ObfuscatedName("ax")
    short[][][] floorUnderlayIds;
    @ObfuscatedName("ai")
    short[][][] floorOverlayIds;
   @ObfuscatedName("ag")
   byte[][][] field2390;
   @ObfuscatedName("ah")
   byte[][][] field2396;
    @ObfuscatedName("av")
    @ObfuscatedSignature(
            descriptor = "[[[[Ljl;"
    )
    WorldMapDecoration[][][][] decorations;
   @ObfuscatedName("ar")
   boolean field2398;
   @ObfuscatedName("am")
   boolean field2399;

   AbstractWorldMapData() {
      new LinkedList();
      this.field2398 = false;
      this.field2399 = false;
   }

    @ObfuscatedName("an")
    @ObfuscatedSignature(
            descriptor = "(Lsg;S)V",
            garbageValue = "2348"
    )
    abstract void readGeography(Buffer var1);

    @ObfuscatedName("ae")
    @ObfuscatedSignature(
            descriptor = "(I)Z",
            garbageValue = "-556860665"
    )
    boolean isFullyLoaded() {
      return this.field2398 && this.field2399;
   }

    @ObfuscatedName("ap")
    @ObfuscatedSignature(
            descriptor = "(Lnm;B)V",
            garbageValue = "97"
    )
    void loadGeography(AbstractArchive var1) {
      if (!this.isFullyLoaded()) {
         byte[] var2 = var1.takeFile(this.groupId, this.fileId);
         if (var2 != null) {
            this.readGeography(new Buffer(var2));
            this.field2398 = true;
            this.field2399 = true;
         }

      }
   }

    @ObfuscatedName("by")
    @ObfuscatedSignature(
            descriptor = "(I)V",
            garbageValue = "216938688"
    )
    void reset() {
      this.floorUnderlayIds = null;
      this.floorOverlayIds = null;
      this.field2390 = null;
      this.field2396 = null;
      this.decorations = null;
      this.field2398 = false;
      this.field2399 = false;
   }

    @ObfuscatedName("bb")
    @ObfuscatedSignature(
            descriptor = "(IILsg;I)V",
            garbageValue = "1675486274"
    )
    void readTile(int var1, int var2, Buffer var3) {
      int var4 = var3.readUnsignedByte();
      if (var4 != 0) {
         if ((var4 & 1) != 0) {
            this.method1516(var1, var2, var3, var4);
         } else {
            this.method1517(var1, var2, var3, var4);
         }

      }
   }

   @ObfuscatedName("bi")
   @ObfuscatedSignature(
      descriptor = "(IILsg;IB)V",
      garbageValue = "-28"
   )
   void method1516(int var1, int var2, Buffer var3, int var4) {
      boolean var5 = (var4 & 2) != 0;
      if (var5) {
         this.floorOverlayIds[0][var1][var2] = (short)var3.readUnsignedShort();
      }

      this.floorUnderlayIds[0][var1][var2] = (short)var3.readUnsignedShort();
   }

   @ObfuscatedName("be")
   @ObfuscatedSignature(
      descriptor = "(IILsg;II)V",
      garbageValue = "675570307"
   )
   void method1517(int var1, int var2, Buffer var3, int var4) {
      int var5 = ((var4 & 24) >> 3) + 1;
      boolean var6 = (var4 & 2) != 0;
      boolean var7 = (var4 & 4) != 0;
      this.floorUnderlayIds[0][var1][var2] = (short)var3.readUnsignedShort();
      int var8;
      int var9;
      int var11;
      if (var6) {
         var8 = var3.readUnsignedByte();

         for(var9 = 0; var9 < var8; ++var9) {
            int var10 = var3.readUnsignedShort();
            if (var10 != 0) {
               this.floorOverlayIds[var9][var1][var2] = (short)var10;
               var11 = var3.readUnsignedByte();
               this.field2390[var9][var1][var2] = (byte)(var11 >> 2);
               this.field2396[var9][var1][var2] = (byte)(var11 & 3);
            }
         }
      }

      if (var7) {
         for(var8 = 0; var8 < var5; ++var8) {
            var9 = var3.readUnsignedByte();
            if (var9 != 0) {
               WorldMapDecoration[] var14 = this.decorations[var8][var1][var2] = new WorldMapDecoration[var9];

               for(var11 = 0; var11 < var9; ++var11) {
                  int var12 = var3.method2516();
                  int var13 = var3.readUnsignedByte();
                  var14[var11] = new WorldMapDecoration(var12, var13 >> 2, var13 & 3);
               }
            }
         }
      }

   }

    @ObfuscatedName("bk")
    @ObfuscatedSignature(
            descriptor = "(I)I",
            garbageValue = "790722291"
    )
    int getRegionX() {
      return this.regionX;
   }

    @ObfuscatedName("bx")
    @ObfuscatedSignature(
            descriptor = "(I)I",
            garbageValue = "2104723155"
    )
    int getRegionY() {
      return this.regionY;
   }

    @ObfuscatedName("ac")
    @ObfuscatedSignature(
            descriptor = "(II)[B",
            garbageValue = "1786635610"
    )
    public static synchronized byte[] ByteArrayPool_getArray(int var0) {
      return ByteArrayPool.ByteArrayPool_getArrayBool(var0, false);
   }
}
