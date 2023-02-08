import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("or")
@Implements("GraphicsDefaults")
public class GraphicsDefaults {
    @ObfuscatedName("bw")
    static String param9;
    @ObfuscatedName("f")
    public int compass = -1;
   @ObfuscatedName("w")
   public int field3758 = -1;
    @ObfuscatedName("v")
    public int mapScenes = -1;
    @ObfuscatedName("s")
    public int headIconsPk = -1;
   @ObfuscatedName("z")
   public int field3753 = -1;
   @ObfuscatedName("j")
   public int field3754 = -1;
   @ObfuscatedName("i")
   public int field3757 = -1;
   @ObfuscatedName("n")
   public int field3756 = -1;
   @ObfuscatedName("l")
   public int field3759 = -1;
   @ObfuscatedName("k")
   public int field3750 = -1;
   @ObfuscatedName("c")
   public int field3761 = -1;

    @ObfuscatedName("f")
    @ObfuscatedSignature(
            descriptor = "(Lln;B)V",
            garbageValue = "16"
    )
    public void decode(AbstractArchive var1) {
      byte[] var2 = var1.takeFileFlat(DefaultsGroup.field3749.group);
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
            this.compass = var3.method2419();
            this.field3758 = var3.method2419();
            this.mapScenes = var3.method2419();
            this.headIconsPk = var3.method2419();
            this.field3753 = var3.method2419();
            this.field3754 = var3.method2419();
            this.field3757 = var3.method2419();
            this.field3756 = var3.method2419();
            this.field3759 = var3.method2419();
            this.field3750 = var3.method2419();
            this.field3761 = var3.method2419();
         }
      }
   }
}
