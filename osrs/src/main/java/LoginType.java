import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("sw")
@Implements("LoginType")
public class LoginType {
    @ObfuscatedName("af")
    @ObfuscatedSignature(
            descriptor = "Lsw;"
    )
    public static final LoginType oldscape = new LoginType(4, 0, "", "");
   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "Lsw;"
   )
   static final LoginType field3991 = new LoginType(6, 1, "", "");
   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      descriptor = "Lsw;"
   )
   static final LoginType field3993 = new LoginType(3, 2, "", "");
   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "Lsw;"
   )
   static final LoginType field3994 = new LoginType(8, 3, "", "");
   @ObfuscatedName("au")
   @ObfuscatedSignature(
      descriptor = "Lsw;"
   )
   static final LoginType field3990 = new LoginType(7, 4, "", "");
   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "Lsw;"
   )
   static final LoginType field3995 = new LoginType(5, 5, "", "");
   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      descriptor = "Lsw;"
   )
   static final LoginType field3996 = new LoginType(2, 6, "", "");
   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "Lsw;"
   )
   static final LoginType field3997 = new LoginType(1, 7, "", "");
   @ObfuscatedName("at")
   @ObfuscatedSignature(
      descriptor = "Lsw;"
   )
   public static final LoginType field3998;
   @ObfuscatedName("aa")
   final int field3999;
   @ObfuscatedName("ay")
   final String field4000;

   static {
      field3998 = new LoginType(0, -1, "", "", true, new LoginType[]{oldscape, field3991, field3993, field3990, field3994});
   }

   LoginType(int var1, int var2, String var3, String var4) {
      this.field3999 = var1;
      this.field4000 = var4;
   }

   @ObfuscatedSignature(
      descriptor = "(IILjava/lang/String;Ljava/lang/String;Z[Lsw;)V"
   )
   LoginType(int var1, int var2, String var3, String var4, boolean var5, LoginType[] var6) {
      this.field3999 = var1;
      this.field4000 = var4;
   }

    @ObfuscatedName("toString")
    public String toString() {
      return this.field4000;
   }
}
