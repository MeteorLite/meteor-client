import net.runelite.mapping.Export;
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
   @Export("tempMenuAction")
   static MenuAction tempMenuAction;
   @ObfuscatedName("h")
   @Export("plane")
   int plane;
   @ObfuscatedName("e")
   @Export("type")
   int type;
   @ObfuscatedName("v")
   @Export("x")
   int x;
   @ObfuscatedName("x")
   @Export("y")
   int y;
   @ObfuscatedName("m")
   @Export("objectId")
   int objectId;
   @ObfuscatedName("q")
   int field928;
   @ObfuscatedName("f")
   int field921;
   @ObfuscatedName("r")
   int field922;
   @ObfuscatedName("u")
   int field923;
   @ObfuscatedName("b")
   int field924;
   @ObfuscatedName("g")
   int field920 = 31;
   @ObfuscatedName("i")
   @Export("delay")
   int delay = 0;
   @ObfuscatedName("o")
   @Export("hitpoints")
   int hitpoints = -1;

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
