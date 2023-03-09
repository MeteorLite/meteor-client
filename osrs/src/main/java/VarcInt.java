import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hr")
@Implements("VarcInt")
public class VarcInt extends DualNode {
   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "Lne;"
   )
   @Export("VarcInt_archive")
   public static AbstractArchive VarcInt_archive;
   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "Lkt;"
   )
   @Export("VarcInt_cached")
   public static EvictingDualNodeHashTable VarcInt_cached = new EvictingDualNodeHashTable(64);
   @ObfuscatedName("aq")
   @Export("ItemDefinition_inMembersWorld")
   public static boolean ItemDefinition_inMembersWorld;
   @ObfuscatedName("ac")
   @Export("persist")
   public boolean persist = false;

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "(Lsy;I)V",
      garbageValue = "1857783206"
   )
   public void method936(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if (var2 == 0) {
            return;
         }

         this.method937(var1, var2);
      }
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "(Lsy;II)V",
      garbageValue = "-1286505504"
   )
   void method937(Buffer var1, int var2) {
      if (var2 == 2) {
         this.persist = true;
      }

   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "(I)[Lis;",
      garbageValue = "-353492841"
   )
   public static MoveSpeed[] method938() {
      return new MoveSpeed[]{MoveSpeed.STATIONARY, MoveSpeed.WALK, MoveSpeed.CRAWL, MoveSpeed.RUN};
   }
}
