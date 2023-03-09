import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("oc")
public class class381 {
   @ObfuscatedName("ky")
   @Export("cameraX")
   static int cameraX;
   @ObfuscatedName("aj")
   int field3606;
   @ObfuscatedName("al")
   int field3604;
   @ObfuscatedName("ac")
   int field3603;
   @ObfuscatedName("ab")
   int field3605;

   @Export("toString")
   @ObfuscatedName("toString")
   public String toString() {
      boolean var1 = true;
      int var2 = 10 - Integer.toString(this.field3606).length();
      int var3 = 10 - Integer.toString(this.field3603).length();
      int var4 = 10 - Integer.toString(this.field3604).length();
      String var5 = "          ".substring(10 - var2);
      String var6 = "          ".substring(10 - var3);
      String var7 = "          ".substring(10 - var4);
      return "    Size: " + this.field3606 + var5 + "Created: " + this.field3604 + var7 + "Total used: " + this.field3603 + var6 + "Max-In-Use: " + this.field3605;
   }

   @ObfuscatedName("jv")
   @ObfuscatedSignature(
      descriptor = "(B)Z",
      garbageValue = "24"
   )
   static final boolean method2031() {
      return Client.isMenuOpen;
   }
}
