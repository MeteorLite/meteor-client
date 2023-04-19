import java.security.SecureRandom;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gk")
public class class174 extends class177 {
    @ObfuscatedName("hz")
    static SecureRandom secureRandom;
    @ObfuscatedName("kv")
    static int cameraY;
   @ObfuscatedName("af")
   int field1452;
   // $FF: synthetic field
   @ObfuscatedSignature(
      descriptor = "Lgy;"
   )
   final class166 this$0;

   @ObfuscatedSignature(
      descriptor = "(Lgy;Ljava/lang/String;I)V"
   )
   class174(class166 var1, String var2, int var3) {
      super(var1, var2);
      this.this$0 = var1;
      this.field1452 = var3;
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      descriptor = "(B)I",
      garbageValue = "-41"
   )
   public int vmethod3379() {
      return 0;
   }

    @ObfuscatedName("al")
    @ObfuscatedSignature(
            descriptor = "(I)I",
            garbageValue = "421671702"
    )
    public int vmethod3378() {
      return this.field1452;
   }
}
