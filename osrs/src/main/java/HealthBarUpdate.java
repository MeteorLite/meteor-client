import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cz")
@Implements("HealthBarUpdate")
public class HealthBarUpdate extends Node {
    @ObfuscatedName("f")
    int cycle;
    @ObfuscatedName("w")
    int health;
    @ObfuscatedName("v")
    int health2;
    @ObfuscatedName("s")
    int cycleOffset;

   HealthBarUpdate(int var1, int var2, int var3, int var4) {
      this.cycle = var1;
      this.health = var2;
      this.health2 = var3;
      this.cycleOffset = var4;
   }

    @ObfuscatedName("f")
    @ObfuscatedSignature(
            descriptor = "(IIIIB)V",
            garbageValue = "88"
    )
    void set(int var1, int var2, int var3, int var4) {
      this.cycle = var1;
      this.health = var2;
      this.health2 = var3;
      this.cycleOffset = var4;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "-1170890753"
   )
   static void method507(String var0, String var1, String var2) {
      ReflectionCheck.method171(7);
      class70.setLoginResponseString(var0, var1, var2);
   }
}
