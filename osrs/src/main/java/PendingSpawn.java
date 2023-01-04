import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cm")
@Implements("PendingSpawn")
public final class PendingSpawn extends Node {
   @ObfuscatedName("ns")
   @ObfuscatedSignature(
      descriptor = "Lbs;"
   )
   static MenuAction tempMenuAction;
   @ObfuscatedName("h")
   int plane;
   @ObfuscatedName("e")
   int type;
   @ObfuscatedName("v")
   int x;
   @ObfuscatedName("x")
   int y;
   @ObfuscatedName("m")
   int objectId;
   @ObfuscatedName("q")
   int field928;
   @ObfuscatedName("f")
   int field921;
   @ObfuscatedName("r")
   int id;
   @ObfuscatedName("u")
   int rotation;
   @ObfuscatedName("b")
   int objectType;
   @ObfuscatedName("g")
   int field920 = 31;
   @ObfuscatedName("i")
   int startCycle = 0;
   @ObfuscatedName("o")
   int endCycle = -1;

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(IB)V",
      garbageValue = "-39"
   )
   void method509(int var1) {
      this.field920 = var1;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "(II)Z",
      garbageValue = "-2145111937"
   )
   boolean method510(int var1) {
      if (var1 >= 0 && var1 <= 4) {
         return (this.field920 & 1 << var1) != 0;
      } else {
         return true;
      }
   }
}
