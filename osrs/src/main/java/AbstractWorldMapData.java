import java.util.LinkedList;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ia")
@Implements("AbstractWorldMapData")
public abstract class AbstractWorldMapData {
   @ObfuscatedName("o")
   public static boolean field2351 = true;
    @ObfuscatedName("z")
    int regionXLow;
    @ObfuscatedName("j")
    int regionYLow;
    @ObfuscatedName("i")
    int regionX;
    @ObfuscatedName("n")
    int regionY;
    @ObfuscatedName("l")
    int minPlane;
    @ObfuscatedName("k")
    int planes;
    @ObfuscatedName("c")
    int groupId = -1;
    @ObfuscatedName("r")
    int fileId = -1;
    @ObfuscatedName("b")
    short[][][] floorUnderlayIds;
    @ObfuscatedName("m")
    short[][][] floorOverlayIds;
   @ObfuscatedName("t")
   byte[][][] field2358;
   @ObfuscatedName("h")
   byte[][][] field2355;
    @ObfuscatedName("p")
    @ObfuscatedSignature(
            descriptor = "[[[[Lik;"
    )
    WorldMapDecoration[][][][] decorations;
   @ObfuscatedName("u")
   boolean field2356;
   @ObfuscatedName("x")
   boolean field2357;

   AbstractWorldMapData() {
      new LinkedList();
      this.field2356 = false;
      this.field2357 = false;
   }

    @ObfuscatedName("w")
    @ObfuscatedSignature(
            descriptor = "(Lrd;B)V",
            garbageValue = "9"
    )
    abstract void readGeography(Buffer var1);

    @ObfuscatedName("a")
    @ObfuscatedSignature(
            descriptor = "(I)Z",
            garbageValue = "-217482611"
    )
    boolean isFullyLoaded() {
      return this.field2356 && this.field2357;
   }

    @ObfuscatedName("q")
    @ObfuscatedSignature(
            descriptor = "(Lln;B)V",
            garbageValue = "110"
    )
    void loadGeography(AbstractArchive var1) {
      if (!this.isFullyLoaded()) {
         byte[] var2 = var1.takeFile(this.groupId, this.fileId);
         if (var2 != null) {
            this.readGeography(new Buffer(var2));
            this.field2356 = true;
            this.field2357 = true;
         }

      }
   }

    @ObfuscatedName("d")
    @ObfuscatedSignature(
            descriptor = "(B)V",
            garbageValue = "126"
    )
    void reset() {
      this.floorUnderlayIds = null;
      this.floorOverlayIds = null;
      this.field2358 = null;
      this.field2355 = null;
      this.decorations = null;
      this.field2356 = false;
      this.field2357 = false;
   }

    @ObfuscatedName("e")
    @ObfuscatedSignature(
            descriptor = "(IILrd;B)V",
            garbageValue = "1"
    )
    void readTile(int var1, int var2, Buffer var3) {
      int var4 = var3.readUnsignedByte();
      if (var4 != 0) {
         if ((var4 & 1) != 0) {
            this.method1445(var1, var2, var3, var4);
         } else {
            this.method1450(var1, var2, var3, var4);
         }

      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      descriptor = "(IILrd;II)V",
      garbageValue = "-2024811095"
   )
   void method1445(int var1, int var2, Buffer var3, int var4) {
      boolean var5 = (var4 & 2) != 0;
      if (var5) {
         this.floorOverlayIds[0][var1][var2] = field2351 ? (short)var3.readUnsignedShort() : (short)var3.readUnsignedByte();
      }

      this.floorUnderlayIds[0][var1][var2] = field2351 ? (short)var3.readUnsignedShort() : (short)var3.readUnsignedByte();
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      descriptor = "(IILrd;II)V",
      garbageValue = "2043326073"
   )
   void method1450(int var1, int var2, Buffer var3, int var4) {
      int var5 = ((var4 & 24) >> 3) + 1;
      boolean var6 = (var4 & 2) != 0;
      boolean var7 = (var4 & 4) != 0;
      this.floorUnderlayIds[0][var1][var2] = field2351 ? (short)var3.readUnsignedShort() : (short)var3.readUnsignedByte();
      int var8;
      int var9;
      int var11;
      if (var6) {
         var8 = var3.readUnsignedByte();

         for(var9 = 0; var9 < var8; ++var9) {
            int var10 = field2351 ? var3.readUnsignedShort() : var3.readUnsignedByte();
            if (var10 != 0) {
               this.floorOverlayIds[var9][var1][var2] = (short)var10;
               var11 = var3.readUnsignedByte();
               this.field2358[var9][var1][var2] = (byte)(var11 >> 2);
               this.field2355[var9][var1][var2] = (byte)(var11 & 3);
            }
         }
      }

      if (var7) {
         for(var8 = 0; var8 < var5; ++var8) {
            var9 = var3.readUnsignedByte();
            if (var9 != 0) {
               WorldMapDecoration[] var14 = this.decorations[var8][var1][var2] = new WorldMapDecoration[var9];

               for(var11 = 0; var11 < var9; ++var11) {
                  int var12 = var3.method2419();
                  int var13 = var3.readUnsignedByte();
                  var14[var11] = new WorldMapDecoration(var12, var13 >> 2, var13 & 3);
               }
            }
         }
      }

   }

    @ObfuscatedName("af")
    @ObfuscatedSignature(
            descriptor = "(I)I",
            garbageValue = "1948785623"
    )
    int getRegionX() {
      return this.regionX;
   }

    @ObfuscatedName("aa")
    @ObfuscatedSignature(
            descriptor = "(I)I",
            garbageValue = "1777462733"
    )
    int getRegionY() {
      return this.regionY;
   }

    @ObfuscatedName("jv")
    @ObfuscatedSignature(
            descriptor = "([Lkz;Lkz;ZB)V",
            garbageValue = "-1"
    )
    static void revalidateWidgetScroll(Widget[] var0, Widget var1, boolean var2) {
      int var3 = var1.scrollWidth != 0 ? var1.scrollWidth * -1665715877 * 1727370963 : var1.width * -1145697413 * -1115677773;
      int var4 = var1.scrollHeight != 0 ? var1.scrollHeight * -2014827871 * 1565145441 : var1.height * -1361869075 * 2038548197;
      class374.resizeInterface(var0, var1.id, var3, var4, var2);
      if (var1.children != null) {
         class374.resizeInterface(var1.children, var1.id, var3, var4, var2);
      }

      InterfaceParent var5 = (InterfaceParent)Client.interfaceParents.get((long)var1.id);
      if (var5 != null) {
         int var6 = var5.group;
         if (class153.loadInterface(var6)) {
            class374.resizeInterface(WorldMapLabel.Widget_interfaceComponents[var6], -1, var3, var4, var2);
         }
      }

      if (var1.contentType == 1337) {
         ;
      }

   }
}
