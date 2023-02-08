import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("js")
@Implements("ZoneOperation")
public class ZoneOperation {
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "Ljs;"
   )
   public static final ZoneOperation field2547 = new ZoneOperation(15);
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      descriptor = "Ljs;"
   )
   public static final ZoneOperation field2540 = new ZoneOperation(14);
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "Ljs;"
   )
   public static final ZoneOperation field2541 = new ZoneOperation(16);
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      descriptor = "Ljs;"
   )
   public static final ZoneOperation field2542 = new ZoneOperation(7);
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      descriptor = "Ljs;"
   )
   public static final ZoneOperation field2543 = new ZoneOperation(7);
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      descriptor = "Ljs;"
   )
   public static final ZoneOperation field2546 = new ZoneOperation(4);
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      descriptor = "Ljs;"
   )
   public static final ZoneOperation field2544 = new ZoneOperation(5);
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      descriptor = "Ljs;"
   )
   public static final ZoneOperation field2539 = new ZoneOperation(2);
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      descriptor = "Ljs;"
   )
   public static final ZoneOperation field2551 = new ZoneOperation(6);
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      descriptor = "Ljs;"
   )
   public static final ZoneOperation field2548 = new ZoneOperation(4);
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      descriptor = "Ljs;"
   )
   public static final ZoneOperation field2549 = new ZoneOperation(14);
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      descriptor = "Ljs;"
   )
   public static final ZoneOperation field2550 = new ZoneOperation(5);
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      descriptor = "Ljs;"
   )
   public static final ZoneOperation field2545 = new ZoneOperation(11);

   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "15"
   )
   ZoneOperation(int var1) {
   }

    @ObfuscatedName("f")
    @ObfuscatedSignature(
            descriptor = "(ILjava/lang/String;Ljava/lang/String;I)V",
            garbageValue = "1260897554"
    )
    static void addGameMessage(int var0, String var1, String var2) {
      class134.addChatMessage(var0, var1, var2, (String)null);
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "(III)I",
      garbageValue = "1433537546"
   )
   static int method1535(int var0, int var1) {
      ItemContainer var2 = (ItemContainer)ItemContainer.itemContainers.get((long)var0);
      if (var2 == null) {
         return 0;
      } else if (var1 == -1) {
         return 0;
      } else {
         int var3 = 0;

         for(int var4 = 0; var4 < var2.quantities.length; ++var4) {
            if (var2.ids[var4] == var1) {
               var3 += var2.quantities[var4];
            }
         }

         return var3;
      }
   }
}
