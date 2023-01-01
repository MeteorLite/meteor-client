import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cm")
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
   int field1175;
   @ObfuscatedName("f")
   int field1166;
   @ObfuscatedName("r")
   int field1167;
   @ObfuscatedName("u")
   int field1168;
   @ObfuscatedName("b")
   int field1169;
   @ObfuscatedName("g")
   int field1165 = 31;
   @ObfuscatedName("i")
   int delay = 0;
   @ObfuscatedName("o")
   int hitpoints = -1;

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(IB)V",
      garbageValue = "-39"
   )
   void method2338(int var1) {
      this.field1165 = var1;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "(II)Z",
      garbageValue = "-2145111937"
   )
   boolean method2341(int var1) {
      if (var1 >= 0 && var1 <= 4) {
         return (this.field1165 & 1 << var1) != 0;
      } else {
         return true;
      }
   }
}
