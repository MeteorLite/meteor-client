import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eo")
@Implements("UrlRequest")
public class UrlRequest {
   @ObfuscatedName("al")
   static int field1140 = -1;
   @ObfuscatedName("ac")
   static int field1141 = -2;
   @ObfuscatedName("aj")
   final URL field1142;
   @ObfuscatedName("ab")
   volatile int field1139;
   @ObfuscatedName("an")
   @Export("response0")
   volatile byte[] response0;

   UrlRequest(URL var1) {
      this.field1139 = field1140;
      this.field1142 = var1;
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "(I)Z",
      garbageValue = "549528116"
   )
   @Export("isDone")
   public boolean isDone() {
      return this.field1139 != field1140;
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "(I)[B",
      garbageValue = "1852193551"
   )
   @Export("getResponse")
   public byte[] getResponse() {
      return this.response0;
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "(S)Ljava/lang/String;",
      garbageValue = "-24011"
   )
   public String method644() {
      return this.field1142.toString();
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "(IZIZI)V",
      garbageValue = "837272188"
   )
   @Export("sortWorldList")
   static void sortWorldList(int var0, boolean var1, int var2, boolean var3) {
      if (class260.World_worlds != null) {
         class12.doWorldSorting(0, class260.World_worlds.length - 1, var0, var1, var2, var3);
      }

   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "1203549376"
   )
   public static void method645() {
      ParamComposition.ParamDefinition_cached.clear();
   }
}
