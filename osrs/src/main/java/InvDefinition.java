import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fq")
public class InvDefinition extends DualNode {
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "Lly;"
   )
   static AbstractArchive InvDefinition_archive;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "Ljv;"
   )
   static EvictingDualNodeHashTable InvDefinition_cached = new EvictingDualNodeHashTable(64);
   @ObfuscatedName("if")
   @ObfuscatedGetter(
      intValue = 780032889
   )
   static int field1918;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1028832281
   )
   public int size = 0;

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "(Lqy;I)V",
      garbageValue = "232861305"
   )
   void decode(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if (var2 == 0) {
            return;
         }

         this.decodeNext(var1, var2);
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      descriptor = "(Lqy;IB)V",
      garbageValue = "42"
   )
   void decodeNext(Buffer var1, int var2) {
      if (var2 == 2) {
         this.size = var1.readUnsignedShort();
      }

   }
}
