import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("qm")
@Implements("DbRowType")
public class DbRowType extends DualNode {
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "Lly;"
   )
   static AbstractArchive field3979;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "Ljv;"
   )
   static EvictingDualNodeHashTable DBRowType_cache = new EvictingDualNodeHashTable(64);
   @ObfuscatedName("v")
   Object[][] columnTypes;
   @ObfuscatedName("x")
   int[][] field3982;
   @ObfuscatedName("m")
   public int tableId = -1;

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "(Lqy;I)V",
      garbageValue = "-1689842467"
   )
   void method2318(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if (var2 == 0) {
            return;
         }

         this.method2320(var1, var2);
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      descriptor = "(II)[Ljava/lang/Object;",
      garbageValue = "-1711583640"
   )
   public Object[] getColumnType(int var1) {
      return this.columnTypes == null ? null : this.columnTypes[var1];
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      descriptor = "(Lqy;IB)V",
      garbageValue = "-14"
   )
   void method2320(Buffer var1, int var2) {
      if (var2 == 3) {
         int var3 = var1.readUnsignedByte();
         if (this.columnTypes == null) {
            this.columnTypes = new Object[var3][];
            this.field3982 = new int[var3][];
         }

         for(int var4 = var1.readUnsignedByte(); var4 != 255; var4 = var1.readUnsignedByte()) {
            int var5 = var1.readUnsignedByte();
            int[] var6 = new int[var5];

            for(int var7 = 0; var7 < var5; ++var7) {
               var6[var7] = var1.readUShortSmart();
            }

            Object[][] var16 = this.columnTypes;
            int var10 = var1.readUShortSmart();
            Object[] var11 = new Object[var6.length * var10];

            for(int var12 = 0; var12 < var10; ++var12) {
               for(int var13 = 0; var13 < var6.length; ++var13) {
                  int var14 = var13 + var6.length * var12;
                  class456 var15 = class9.method33(var6[var13]);
                  var11[var14] = var15.method2301(var1);
               }
            }

            var16[var4] = var11;
            this.field3982[var4] = var6;
         }
      } else if (var2 == 4) {
         this.tableId = var1.method2363();
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "1976644812"
   )
   void method2319() {
   }
}
