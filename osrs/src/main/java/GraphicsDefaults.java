import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("qw")
@Implements("GraphicsDefaults")
public class GraphicsDefaults {
    @ObfuscatedName("af")
    public int compass = -1;
   @ObfuscatedName("an")
   public int field3767 = -1;
    @ObfuscatedName("aw")
    public int mapScenes = -1;
    @ObfuscatedName("ac")
    public int headIconsPk = -1;
   @ObfuscatedName("au")
   public int field3775 = -1;
   @ObfuscatedName("ab")
   public int field3772 = -1;
   @ObfuscatedName("aq")
   public int field3773 = -1;
   @ObfuscatedName("al")
   public int field3771 = -1;
   @ObfuscatedName("at")
   public int field3774 = -1;
   @ObfuscatedName("aa")
   public int field3776 = -1;
   @ObfuscatedName("ay")
   public int field3768 = -1;

    @ObfuscatedName("af")
    @ObfuscatedSignature(
            descriptor = "(Lnm;I)V",
            garbageValue = "-1761039075"
    )
    public void decode(AbstractArchive var1) {
      byte[] var2 = var1.takeFileFlat(DefaultsGroup.field3766.group);
      Buffer var3 = new Buffer(var2);

      while(true) {
         int var4 = var3.readUnsignedByte();
         if (var4 == 0) {
            return;
         }

         switch(var4) {
         case 1:
            var3.readMedium();
            break;
         case 2:
            this.compass = var3.method2516();
            this.field3767 = var3.method2516();
            this.mapScenes = var3.method2516();
            this.headIconsPk = var3.method2516();
            this.field3775 = var3.method2516();
            this.field3772 = var3.method2516();
            this.field3773 = var3.method2516();
            this.field3771 = var3.method2516();
            this.field3774 = var3.method2516();
            this.field3776 = var3.method2516();
            this.field3768 = var3.method2516();
         }
      }
   }

    @ObfuscatedName("af")
    @ObfuscatedSignature(
            descriptor = "(II)Lgz;",
            garbageValue = "-1565571529"
    )
    public static VarpDefinition VarpDefinition_get(int var0) {
      VarpDefinition var1 = (VarpDefinition)VarpDefinition.VarpDefinition_cached.get((long)var0);
      if (var1 != null) {
         return var1;
      } else {
         byte[] var2 = VarpDefinition.VarpDefinition_archive.takeFile(16, var0);
         var1 = new VarpDefinition();
         if (var2 != null) {
            var1.decode(new Buffer(var2));
         }

         VarpDefinition.VarpDefinition_cached.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("jg")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "-93"
   )
   static final void method2228() {
      for(GraphicsObject var0 = (GraphicsObject)Client.graphicsObjects.last(); var0 != null; var0 = (GraphicsObject)Client.graphicsObjects.previous()) {
         if (var0.plane == GameEngine.Client_plane && !var0.isFinished) {
            if (Client.cycle >= var0.cycleStart) {
               var0.advance(Client.field432);
               if (var0.isFinished) {
                  var0.remove();
               } else {
                  class31.scene.drawEntity(var0.plane, var0.x, var0.y, var0.z, 60, var0, 0, -1L, false);
               }
            }
         } else {
            var0.remove();
         }
      }

   }
}
