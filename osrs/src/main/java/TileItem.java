import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cr")
public final class TileItem extends Renderable {
   @ObfuscatedName("ss")
   @ObfuscatedSignature(
      descriptor = "Lax;"
   )
   static PcmPlayer pcmPlayer0;
   @ObfuscatedName("h")
   int id;
   @ObfuscatedName("e")
   int quantity;
   @ObfuscatedName("x")
   int field1353 = 31;

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(II)V",
      garbageValue = "-434295648"
   )
   void method2612(int var1) {
      this.field1353 = var1;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "(I)Lhh;",
      garbageValue = "-1279733976"
   )
   protected final Model getModel() {
      return NPCComposition.ItemDefinition_get(this.id).getModel(this.quantity);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      descriptor = "(IB)Z",
      garbageValue = "8"
   )
   boolean method2613(int var1) {
      if (var1 >= 0 && var1 <= 4) {
         return (this.field1353 & 1 << var1) != 0;
      } else {
         return true;
      }
   }

   @ObfuscatedName("mh")
   @ObfuscatedSignature(
      descriptor = "(Lqy;IB)V",
      garbageValue = "7"
   )
   static void method2619(Buffer var0, int var1) {
      ArchiveLoader.method2222(var0.array, var1);
      class125.method2940(var0, var1);
   }
}
