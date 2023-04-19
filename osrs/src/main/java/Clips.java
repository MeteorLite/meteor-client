import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jg")
public class Clips {
    @ObfuscatedName("ou")
    static int selectedSpellWidget;
   @ObfuscatedName("af")
   boolean field2234 = false;
   @ObfuscatedName("an")
   public boolean field2226 = true;
   @ObfuscatedName("aw")
   int field2225 = 0;
   @ObfuscatedName("ab")
   public int viewportZoom = 512;
    @ObfuscatedName("aq")
    @ObfuscatedSignature(
            descriptor = "Ljq;"
    )
    public TextureLoader Rasterizer3D_textureLoader;
   @ObfuscatedName("ax")
   int field2231;
   @ObfuscatedName("ai")
   int field2229;
   @ObfuscatedName("ag")
   int field2233;
   @ObfuscatedName("ah")
   int field2232;
   @ObfuscatedName("av")
   int clipNegativeMidX;
   @ObfuscatedName("ar")
   int field2236;
   @ObfuscatedName("am")
   int clipNegativeMidY;
   @ObfuscatedName("as")
   int field2238;
    @ObfuscatedName("aj")
    int[] Rasterizer3D_rowOffsets = new int[1024];

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "-36"
   )
   void method1358() {
      this.field2231 = this.field2233 / 2;
      this.field2229 = this.field2232 / 2;
      this.clipNegativeMidX = -(this.field2231 * 1684654809) * -1346890391;
      this.field2236 = this.field2233 - this.field2231;
      this.clipNegativeMidY = -(this.field2229 * -2109856295) * 1380452969;
      this.field2238 = this.field2232 - this.field2229;
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "(IIIIB)V",
      garbageValue = "93"
   )
   void method1359(int var1, int var2, int var3, int var4) {
      this.field2231 = var1 - var2;
      this.field2229 = var3 - var4;
      this.clipNegativeMidX = -(this.field2231 * 1684654809) * -1346890391;
      this.field2236 = this.field2233 - this.field2231;
      this.clipNegativeMidY = -(this.field2229 * -2109856295) * 1380452969;
      this.field2238 = this.field2232 - this.field2229;
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      descriptor = "(IIII)V",
      garbageValue = "707163939"
   )
   void method1360(int var1, int var2, int var3) {
      this.field2234 = var1 < 0 || var1 > this.field2233 || var2 < 0 || var2 > this.field2233 || var3 < 0 || var3 > this.field2233;
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "(ILqk;Lnd;I)V",
      garbageValue = "-35309556"
   )
   static void method1361(int var0, ArchiveDisk var1, Archive var2) {
      ArchiveDiskAction var3 = new ArchiveDiskAction();
      var3.type = 1;
      var3.key = (long)var0;
      var3.archiveDisk = var1;
      var3.archive = var2;
      NodeDeque var4 = ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue;
      synchronized(ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue) {
         ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue.addFirst(var3);
      }

      class124.method741();
   }
}
