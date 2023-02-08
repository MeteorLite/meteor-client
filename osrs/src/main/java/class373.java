import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("nu")
public class class373 {
   @ObfuscatedName("in")
   static int field3599;
   @ObfuscatedName("f")
   int field3600;

   @ObfuscatedSignature(
      descriptor = "(IZ)V",
      garbageValue = "1"
   )
   class373(int var1, boolean var2) {
      this.field3600 = var1;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "(B)I",
      garbageValue = "-32"
   )
   public int method1972() {
      return this.field3600;
   }

   @ObfuscatedName("fz")
   @ObfuscatedSignature(
      descriptor = "(ZI)V",
      garbageValue = "-1525904611"
   )
   static final void method1971(boolean var0) {
      if (var0) {
         Client.field403 = Login.field764 ? class135.field1283 : class135.field1285;
      } else {
         Client.field403 = PacketWriter.clientPreferences.method537(Login.Login_username) ? class135.field1286 : class135.field1284;
      }

   }
}
