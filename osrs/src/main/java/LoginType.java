import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("rm")
@Implements("LoginType")
public class LoginType {
   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "Lrm;"
   )
   @Export("oldscape")
   public static final LoginType oldscape = new LoginType(7, 0, "", "");
   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "Lrm;"
   )
   static final LoginType field3911 = new LoginType(4, 1, "", "");
   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "Lrm;"
   )
   static final LoginType field3912 = new LoginType(6, 2, "", "");
   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "Lrm;"
   )
   static final LoginType field3910 = new LoginType(0, 3, "", "");
   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "Lrm;"
   )
   static final LoginType field3914 = new LoginType(5, 4, "", "");
   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      descriptor = "Lrm;"
   )
   static final LoginType field3915 = new LoginType(2, 5, "", "");
   @ObfuscatedName("av")
   @ObfuscatedSignature(
      descriptor = "Lrm;"
   )
   static final LoginType field3916 = new LoginType(3, 6, "", "");
   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      descriptor = "Lrm;"
   )
   static final LoginType field3918 = new LoginType(1, 7, "", "");
   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      descriptor = "Lrm;"
   )
   public static final LoginType field3913;
   @ObfuscatedName("ar")
   final int field3919;
   @ObfuscatedName("ak")
   final String field3917;

   static {
      field3913 = new LoginType(8, -1, "", "", true, new LoginType[]{oldscape, field3911, field3912, field3914, field3910});
   }

   LoginType(int var1, int var2, String var3, String var4) {
      this.field3919 = var1;
      this.field3917 = var4;
   }

   @ObfuscatedSignature(
      descriptor = "(IILjava/lang/String;Ljava/lang/String;Z[Lrm;)V"
   )
   LoginType(int var1, int var2, String var3, String var4, boolean var5, LoginType[] var6) {
      this.field3919 = var1;
      this.field3917 = var4;
   }

   @Export("toString")
   @ObfuscatedName("toString")
   public String toString() {
      return this.field3917;
   }
}
