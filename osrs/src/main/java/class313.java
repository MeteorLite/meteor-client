import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lc")
public enum class313 implements class345 {
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "Llc;"
   )
   field3028(0),
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "Llc;"
   )
   field3029(1),
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "Llc;"
   )
   field3031(2),
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      descriptor = "Llc;"
   )
   field3030(3),
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      descriptor = "Llc;"
   )
   field3032(4);

   @ObfuscatedName("q")
   final int field3033;

   class313(int var3) {
      this.field3033 = var3;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "(B)I",
      garbageValue = "96"
   )
   @Export("rsOrdinal")
   public int rsOrdinal() {
      return this.field3033;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      descriptor = "(II)I",
      garbageValue = "1788675438"
   )
   @Export("Messages_getLastChatID")
   static int Messages_getLastChatID(int var0) {
      Message var1 = (Message)Messages.Messages_hashTable.get((long)var0);
      if (var1 == null) {
         return -1;
      } else {
         return var1.previousDual == Messages.Messages_queue.sentinel ? -1 : ((Message)var1.previousDual).count;
      }
   }
}
