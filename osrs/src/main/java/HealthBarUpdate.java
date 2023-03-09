import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dw")
@Implements("HealthBarUpdate")
public class HealthBarUpdate extends Node {
   @ObfuscatedName("vc")
   @ObfuscatedSignature(
      descriptor = "Lrt;"
   )
   @Export("platformInfo")
   static PlatformInfo platformInfo;
   @ObfuscatedName("at")
   @ObfuscatedSignature(
      descriptor = "Lsy;"
   )
   public static Buffer field1010;
   @ObfuscatedName("aj")
   @Export("cycle")
   int cycle;
   @ObfuscatedName("al")
   @Export("health")
   int health;
   @ObfuscatedName("ac")
   @Export("health2")
   int health2;
   @ObfuscatedName("ab")
   @Export("cycleOffset")
   int cycleOffset;

   HealthBarUpdate(int var1, int var2, int var3, int var4) {
      this.cycle = var1;
      this.health = var2;
      this.health2 = var3;
      this.cycleOffset = var4;
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "(IIIII)V",
      garbageValue = "-1435919028"
   )
   @Export("set")
   void set(int var1, int var2, int var3, int var4) {
      this.cycle = var1;
      this.health = var2;
      this.health2 = var3;
      this.cycleOffset = var4;
   }
}
