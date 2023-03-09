import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("pt")
@Implements("Buddy")
public class Buddy extends User {
   @ObfuscatedName("an")
   @Export("world")
   public int world = -1;
   @ObfuscatedName("ao")
   @Export("int2")
   public int int2;
   @ObfuscatedName("av")
   @Export("rank")
   public int rank;

   @ObfuscatedName("bp")
   @ObfuscatedSignature(
      descriptor = "(III)V",
      garbageValue = "-170651115"
   )
   @Export("set")
   void set(int var1, int var2) {
      this.world = var1;
      this.int2 = var2;
   }

   @ObfuscatedName("bb")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "1953082718"
   )
   @Export("getWorld")
   public int getWorld() {
      return this.world;
   }

   @ObfuscatedName("bx")
   @ObfuscatedSignature(
      descriptor = "(B)Z",
      garbageValue = "-117"
   )
   @Export("hasWorld")
   public boolean hasWorld() {
      return this.world > 0;
   }
}
