import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ar")
public class class9 implements class352 {
   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "Lar;"
   )
   public static final class9 field23 = new class9(0, "POST", true, true);
   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "Lar;"
   )
   public static final class9 field19 = new class9(1, "GET", true, false);
   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "Lar;"
   )
   static final class9 field20 = new class9(2, "PUT", false, true);
   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "Lar;"
   )
   static final class9 field21 = new class9(3, "PATCH", false, true);
   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "Lar;"
   )
   static final class9 field22 = new class9(4, "DELETE", false, true);
   @ObfuscatedName("ao")
   int field25;
   @ObfuscatedName("av")
   String field24;
   @ObfuscatedName("aq")
   boolean field27;
   @ObfuscatedName("ap")
   boolean field26;

   class9(int var1, String var2, boolean var3, boolean var4) {
      this.field25 = var1;
      this.field24 = var2;
      this.field27 = var3;
      this.field26 = var4;
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "-1409646049"
   )
   @Export("rsOrdinal")
   public int rsOrdinal() {
      return this.field25;
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "(I)Z",
      garbageValue = "-1979721546"
   )
   boolean method25() {
      return this.field27;
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "(I)Ljava/lang/String;",
      garbageValue = "1838962601"
   )
   public String method26() {
      return this.field24;
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      descriptor = "(I)Z",
      garbageValue = "534305297"
   )
   boolean method27() {
      return this.field26;
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "(Ldx;I)V",
      garbageValue = "-2025110230"
   )
   @Export("runScriptEvent")
   public static void runScriptEvent(ScriptEvent var0) {
      class14.runScript(var0, 500000, 475000);
   }
}
