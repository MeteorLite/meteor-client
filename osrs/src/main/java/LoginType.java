import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("qi")
@Implements("LoginType")
public class LoginType {
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "Lqi;"
   )
   public static final LoginType oldscape = new LoginType(7, 0, "", "");
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "Lqi;"
   )
   static final LoginType field3934 = new LoginType(0, 1, "", "");
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "Lqi;"
   )
   static final LoginType field3943 = new LoginType(6, 2, "", "");
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      descriptor = "Lqi;"
   )
   static final LoginType field3937 = new LoginType(5, 3, "", "");
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      descriptor = "Lqi;"
   )
   static final LoginType field3935 = new LoginType(8, 4, "", "");
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      descriptor = "Lqi;"
   )
   static final LoginType field3939 = new LoginType(1, 5, "", "");
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "Lqi;"
   )
   static final LoginType field3940 = new LoginType(3, 6, "", "");
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      descriptor = "Lqi;"
   )
   static final LoginType field3941 = new LoginType(2, 7, "", "");
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      descriptor = "Lqi;"
   )
   public static final LoginType field3942;
   @ObfuscatedName("b")
   public final int field3938;
   @ObfuscatedName("j")
   final String field3944;

   static {
      field3942 = new LoginType(4, -1, "", "", true, new LoginType[]{oldscape, field3934, field3943, field3935, field3937});
   }

   LoginType(int var1, int var2, String var3, String var4) {
      this.field3938 = var1;
      this.field3944 = var4;
   }

   @ObfuscatedSignature(
      descriptor = "(IILjava/lang/String;Ljava/lang/String;Z[Lqi;)V"
   )
   LoginType(int var1, int var2, String var3, String var4, boolean var5, LoginType[] var6) {
      this.field3938 = var1;
      this.field3944 = var4;
   }

   @ObfuscatedName("toString")
   public String toString() {
      return this.field3944;
   }
}
