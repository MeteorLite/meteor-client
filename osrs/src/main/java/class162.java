import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gz")
public class class162 extends class140 {
   @ObfuscatedName("aj")
   long field1390;
   @ObfuscatedName("al")
   String field1389;
   // $FF: synthetic field
   @ObfuscatedSignature(
      descriptor = "Lfo;"
   )
   final class143 this$0;

   @ObfuscatedSignature(
      descriptor = "(Lfo;)V"
   )
   class162(class143 var1) {
      this.this$0 = var1;
      this.field1390 = -1L;
      this.field1389 = null;
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "(Lsy;I)V",
      garbageValue = "-1979280996"
   )
   @Export("vmethod3254")
   void vmethod3254(Buffer var1) {
      if (var1.readUnsignedByte() != 255) {
         --var1.offset;
         this.field1390 = var1.readLong();
      }

      this.field1389 = var1.readStringCp1252NullTerminatedOrNull();
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "(Lfi;B)V",
      garbageValue = "29"
   )
   @Export("vmethod3248")
   void vmethod3248(ClanSettings var1) {
      var1.method796(this.field1390, this.field1389);
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "(II)Lmf;",
      garbageValue = "927143554"
   )
   public static GameBuild method851(int var0) {
      GameBuild[] var1 = SecureRandomFuture.method438();

      for(int var2 = 0; var2 < var1.length; ++var2) {
         GameBuild var3 = var1[var2];
         if (var0 == var3.buildId) {
            return var3;
         }
      }

      return null;
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/CharSequence;B)Z",
      garbageValue = "-17"
   )
   @Export("isNumber")
   public static boolean isNumber(CharSequence var0) {
      return class175.method907(var0, 10, true);
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "-2027808995"
   )
   public static void method850() {
      VarbitComposition.VarbitDefinition_cached.clear();
   }
}
