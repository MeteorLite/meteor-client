import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("on")
@Implements("GraphicsDefaults")
public class GraphicsDefaults {
   @ObfuscatedName("h")
   public int compass = -1;
   @ObfuscatedName("e")
   public int field3741 = -1;
   @ObfuscatedName("v")
   public int mapScenes = -1;
   @ObfuscatedName("x")
   public int headIconsPk = -1;
   @ObfuscatedName("m")
   public int field3738 = -1;
   @ObfuscatedName("q")
   public int field3740 = -1;
   @ObfuscatedName("f")
   public int field3744 = -1;
   @ObfuscatedName("r")
   public int field3742 = -1;
   @ObfuscatedName("u")
   public int field3743 = -1;
   @ObfuscatedName("b")
   public int field3739 = -1;
   @ObfuscatedName("j")
   public int field3745 = -1;

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(Lly;B)V",
      garbageValue = "8"
   )
   public void decode(AbstractArchive var1) {
      byte[] var2 = var1.takeFileFlat(DefaultsGroup.field3732.group);
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
            this.compass = var3.method2362();
            this.field3741 = var3.method2362();
            this.mapScenes = var3.method2362();
            this.headIconsPk = var3.method2362();
            this.field3738 = var3.method2362();
            this.field3740 = var3.method2362();
            this.field3744 = var3.method2362();
            this.field3742 = var3.method2362();
            this.field3743 = var3.method2362();
            this.field3739 = var3.method2362();
            this.field3745 = var3.method2362();
         }
      }
   }
}
