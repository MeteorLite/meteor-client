import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("qj")
@Implements("LoginType")
public class LoginType {
    @ObfuscatedName("f")
    @ObfuscatedSignature(
            descriptor = "Lqj;"
    )
    public static final LoginType oldscape = new LoginType(7, 0, "", "");
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      descriptor = "Lqj;"
   )
   static final LoginType field3948 = new LoginType(2, 1, "", "");
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "Lqj;"
   )
   static final LoginType field3947 = new LoginType(4, 2, "", "");
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      descriptor = "Lqj;"
   )
   static final LoginType field3952 = new LoginType(8, 3, "", "");
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      descriptor = "Lqj;"
   )
   static final LoginType field3949 = new LoginType(3, 4, "", "");
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      descriptor = "Lqj;"
   )
   static final LoginType field3950 = new LoginType(5, 5, "", "");
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      descriptor = "Lqj;"
   )
   static final LoginType field3955 = new LoginType(1, 6, "", "");
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      descriptor = "Lqj;"
   )
   static final LoginType field3951 = new LoginType(6, 7, "", "");
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      descriptor = "Lqj;"
   )
   public static final LoginType field3953;
   @ObfuscatedName("k")
   public final int field3954;
   @ObfuscatedName("c")
   final String field3945;

   static {
      field3953 = new LoginType(0, -1, "", "", true, new LoginType[]{oldscape, field3948, field3947, field3949, field3952});
   }

   LoginType(int var1, int var2, String var3, String var4) {
      this.field3954 = var1;
      this.field3945 = var4;
   }

   @ObfuscatedSignature(
      descriptor = "(IILjava/lang/String;Ljava/lang/String;Z[Lqj;)V"
   )
   LoginType(int var1, int var2, String var3, String var4, boolean var5, LoginType[] var6) {
      this.field3954 = var1;
      this.field3945 = var4;
   }

    @ObfuscatedName("toString")
    public String toString() {
      return this.field3945;
   }
}
