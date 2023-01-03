import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cr")
@Implements("TileItem")
public final class TileItem extends Renderable {
   @ObfuscatedName("ss")
   @ObfuscatedSignature(
      descriptor = "Lax;"
   )
   @Export("pcmPlayer0")
   static PcmPlayer pcmPlayer0;
   @ObfuscatedName("h")
   @Export("id")
   int id;
   @ObfuscatedName("e")
   @Export("quantity")
   int quantity;
   @ObfuscatedName("x")
   int field1079 = 31;

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(II)V",
      garbageValue = "-434295648"
   )
   void method603(int var1) {
      this.field1079 = var1;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "(I)Lhh;",
      garbageValue = "-1279733976"
   )
   @Export("getModel")
   protected final Model getModel() {
      return NPCComposition.ItemDefinition_get(this.id).getModel(this.quantity);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      descriptor = "(IB)Z",
      garbageValue = "8"
   )
   boolean method604(int var1) {
      if (var1 >= 0 && var1 <= 4) {
         return (this.field1079 & 1 << var1) != 0;
      } else {
         return true;
      }
   }

   @ObfuscatedName("mh")
   @ObfuscatedSignature(
      descriptor = "(Lqy;IB)V",
      garbageValue = "7"
   )
   static void method606(Buffer var0, int var1) {
      ArchiveLoader.method463(var0.array, var1);
      class125.method695(var0, var1);
   }
}
