import java.lang.management.GarbageCollectorMXBean;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fa")
public enum class135 implements class352 {
   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "Lfa;"
   )
   field1276(0, 0),
   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "Lfa;"
   )
   field1267(1, 1),
   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "Lfa;"
   )
   field1268(2, 2),
   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "Lfa;"
   )
   field1269(3, 3),
   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "Lfa;"
   )
   field1277(4, 4),
   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      descriptor = "Lfa;"
   )
   field1271(5, 5),
   @ObfuscatedName("av")
   @ObfuscatedSignature(
      descriptor = "Lfa;"
   )
   field1272(6, 6),
   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      descriptor = "Lfa;"
   )
   field1273(7, 7),
   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      descriptor = "Lfa;"
   )
   field1274(8, 8);

   @ObfuscatedName("bp")
   @Export("garbageCollector")
   static GarbageCollectorMXBean garbageCollector;
   @ObfuscatedName("fg")
   @ObfuscatedSignature(
      descriptor = "Lmx;"
   )
   @Export("archive4")
   static Archive archive4;
   @ObfuscatedName("ar")
   final int field1270;
   @ObfuscatedName("ak")
   final int field1278;

   class135(int var3, int var4) {
      this.field1270 = var3;
      this.field1278 = var4;
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "-1409646049"
   )
   @Export("rsOrdinal")
   public int rsOrdinal() {
      return this.field1278;
   }

   @ObfuscatedName("cj")
   @ObfuscatedSignature(
      descriptor = "(II)Ljava/lang/Object;",
      garbageValue = "1765946215"
   )
   static Object method734(int var0) {
      return class148.method778((class467)SpriteMask.findEnumerated(class467.method2367(), var0));
   }
}
