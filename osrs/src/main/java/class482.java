import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("sg")
public class class482 implements class352 {
   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "Lsg;"
   )
   public static final class482 field4023 = new class482(5, 0);
   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "Lsg;"
   )
   public static final class482 field4017 = new class482(3, 2);
   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "Lsg;"
   )
   static final class482 field4018 = new class482(2, 5);
   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "Lsg;"
   )
   static final class482 field4016 = new class482(1, 6);
   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "Lsg;"
   )
   static final class482 field4020 = new class482(0, 7);
   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      descriptor = "Lsg;"
   )
   static final class482 field4021 = new class482(4, 8);
   @ObfuscatedName("av")
   final int field4022;
   @ObfuscatedName("aq")
   final int field4019;

   class482(int var1, int var2) {
      this.field4022 = var1;
      this.field4019 = var2;
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "-1409646049"
   )
   @Export("rsOrdinal")
   public int rsOrdinal() {
      return this.field4019;
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "(I)Z",
      garbageValue = "-1427661354"
   )
   public boolean method2484() {
      return this == field4017;
   }
}
