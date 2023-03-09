import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("pw")
@Implements("GraphicsDefaults")
public class GraphicsDefaults {
   @ObfuscatedName("aj")
   @Export("compass")
   public int compass = -1;
   @ObfuscatedName("al")
   public int field3719 = -1;
   @ObfuscatedName("ac")
   @Export("mapScenes")
   public int mapScenes = -1;
   @ObfuscatedName("ab")
   @Export("headIconsPk")
   public int headIconsPk = -1;
   @ObfuscatedName("an")
   public int field3716 = -1;
   @ObfuscatedName("ao")
   public int field3720 = -1;
   @ObfuscatedName("av")
   public int field3721 = -1;
   @ObfuscatedName("aq")
   public int field3722 = -1;
   @ObfuscatedName("ap")
   public int field3717 = -1;
   @ObfuscatedName("ar")
   public int field3723 = -1;
   @ObfuscatedName("ak")
   public int field3724 = -1;

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "(Lne;I)V",
      garbageValue = "1692757151"
   )
   @Export("decode")
   public void decode(AbstractArchive var1) {
      byte[] var2 = var1.takeFileFlat(DefaultsGroup.field3713.group);
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
            this.compass = var3.method2423();
            this.field3719 = var3.method2423();
            this.mapScenes = var3.method2423();
            this.headIconsPk = var3.method2423();
            this.field3716 = var3.method2423();
            this.field3720 = var3.method2423();
            this.field3721 = var3.method2423();
            this.field3722 = var3.method2423();
            this.field3717 = var3.method2423();
            this.field3723 = var3.method2423();
            this.field3724 = var3.method2423();
         }
      }
   }
}
