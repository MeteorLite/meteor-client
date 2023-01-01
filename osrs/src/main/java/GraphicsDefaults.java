import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("on")
public class GraphicsDefaults {
   @ObfuscatedName("h")
   public int compass = -1;
   @ObfuscatedName("e")
   public int field4588 = -1;
   @ObfuscatedName("v")
   public int mapScenes = -1;
   @ObfuscatedName("x")
   public int headIconsPk = -1;
   @ObfuscatedName("m")
   public int field4585 = -1;
   @ObfuscatedName("q")
   public int field4587 = -1;
   @ObfuscatedName("f")
   public int field4591 = -1;
   @ObfuscatedName("r")
   public int field4589 = -1;
   @ObfuscatedName("u")
   public int field4590 = -1;
   @ObfuscatedName("b")
   public int field4586 = -1;
   @ObfuscatedName("j")
   public int field4592 = -1;

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(Lly;B)V",
      garbageValue = "8"
   )
   public void decode(AbstractArchive var1) {
      byte[] var2 = var1.takeFileFlat(DefaultsGroup.field4578.group);
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
            this.compass = var3.method8568();
            this.field4588 = var3.method8568();
            this.mapScenes = var3.method8568();
            this.headIconsPk = var3.method8568();
            this.field4585 = var3.method8568();
            this.field4587 = var3.method8568();
            this.field4591 = var3.method8568();
            this.field4589 = var3.method8568();
            this.field4590 = var3.method8568();
            this.field4586 = var3.method8568();
            this.field4592 = var3.method8568();
         }
      }
   }
}
