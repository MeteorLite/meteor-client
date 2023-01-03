import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dq")
public class class121 {
   @ObfuscatedName("a")
   @Export("cacheParentPaths")
   public static String[] cacheParentPaths;
   @ObfuscatedName("h")
   int field1174;
   @ObfuscatedName("e")
   float field1169;
   @ObfuscatedName("v")
   float field1168 = Float.MAX_VALUE;
   @ObfuscatedName("x")
   float field1171 = Float.MAX_VALUE;
   @ObfuscatedName("m")
   float field1172 = Float.MAX_VALUE;
   @ObfuscatedName("q")
   float field1170 = Float.MAX_VALUE;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "Ldq;"
   )
   class121 field1173;

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(Lqy;II)V",
      garbageValue = "1617793347"
   )
   void method680(Buffer var1, int var2) {
      this.field1174 = var1.readShort();
      this.field1169 = var1.method2354();
      this.field1168 = var1.method2354();
      this.field1171 = var1.method2354();
      this.field1172 = var1.method2354();
      this.field1170 = var1.method2354();
   }

   @ObfuscatedName("ia")
   @ObfuscatedSignature(
      descriptor = "(I)Z",
      garbageValue = "-912452366"
   )
   static boolean method681() {
      return (Client.drawPlayerNames & 2) != 0;
   }
}
