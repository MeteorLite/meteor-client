import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hi")
@Implements("VarcInt")
public class VarcInt extends DualNode {
    @ObfuscatedName("an")
    @ObfuscatedSignature(
            descriptor = "Lkh;"
    )
    public static EvictingDualNodeHashTable VarcInt_cached = new EvictingDualNodeHashTable(64);
    @ObfuscatedName("aw")
    public boolean persist = false;

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      descriptor = "(Lsg;I)V",
      garbageValue = "1521148390"
   )
   public void method991(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if (var2 == 0) {
            return;
         }

         this.method992(var1, var2);
      }
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "(Lsg;II)V",
      garbageValue = "-194909553"
   )
   void method992(Buffer var1, int var2) {
      if (var2 == 2) {
         this.persist = true;
      }

   }

    @ObfuscatedName("ag")
    @ObfuscatedSignature(
            descriptor = "(CB)Z",
            garbageValue = "4"
    )
    public static boolean isCharPrintable(char var0) {
      if (var0 >= ' ' && var0 <= '~') {
         return true;
      } else if (var0 >= 160 && var0 <= 255) {
         return true;
      } else {
         return var0 == 8364 || var0 == 338 || var0 == 8212 || var0 == 339 || var0 == 376;
      }
   }
}
