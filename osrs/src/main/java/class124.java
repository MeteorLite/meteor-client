import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dp")
public enum class124 implements class345 {
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "Ldp;"
   )
   field1199(0, 0),
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "Ldp;"
   )
   field1194(1, 1),
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "Ldp;"
   )
   field1195(2, 2),
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      descriptor = "Ldp;"
   )
   field1200(3, 3),
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      descriptor = "Ldp;"
   )
   field1197(4, 4);

   @ObfuscatedName("q")
   final int field1198;
   @ObfuscatedName("f")
   final int field1196;

   class124(int var3, int var4) {
      this.field1198 = var3;
      this.field1196 = var4;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "(B)I",
      garbageValue = "96"
   )
   public int rsOrdinal() {
      return this.field1196;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      descriptor = "(ZI)V",
      garbageValue = "-1048113560"
   )
   static void method694(boolean var0) {
      byte var1 = 0;
      boolean var2 = StructComposition.clientPreferences.method542() >= Client.param21;
      if (!var2) {
         var1 = 12;
      } else if (BuddyRankComparator.client.method355() || BuddyRankComparator.client.method356()) {
         var1 = 10;
      }

      class12.setLoginIndex(var1);
      if (var0) {
         Login.Login_username = "";
         Login.Login_password = "";
         class143.field1321 = 0;
         class141.otp = "";
      }

      GameObject.method1298();
      SoundSystem.method237();
   }
}
