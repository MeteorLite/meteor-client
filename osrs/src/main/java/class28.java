import java.util.Arrays;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ao")
public class class28 {
   @ObfuscatedName("f")
   int[] field78 = new int[112];
   @ObfuscatedName("r")
   int[] field79 = new int[192];

   public class28() {
      Arrays.fill(this.field78, 3);
      Arrays.fill(this.field79, 3);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(III)V",
      garbageValue = "1368624225"
   )
   public void method107(int var1, int var2) {
      if (this.method109(var1) && this.method110(var2)) {
         this.field78[var1] = var2;
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "(CII)V",
      garbageValue = "1784799880"
   )
   public void method104(char var1, int var2) {
      if (this.method111(var1) && this.method110(var2)) {
         this.field79[var1] = var2;
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "(IB)I",
      garbageValue = "32"
   )
   public int method103(int var1) {
      return this.method109(var1) ? this.field78[var1] : 0;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      descriptor = "(CI)I",
      garbageValue = "-1468094014"
   )
   public int method105(char var1) {
      return this.method111(var1) ? this.field79[var1] : 0;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      descriptor = "(II)Z",
      garbageValue = "-1654206318"
   )
   public boolean method113(int var1) {
      return this.method109(var1) && (this.field78[var1] == 1 || this.field78[var1] == 3);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      descriptor = "(CI)Z",
      garbageValue = "1403697419"
   )
   public boolean method106(char var1) {
      return this.method111(var1) && (this.field79[var1] == 1 || this.field79[var1] == 3);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "(II)Z",
      garbageValue = "-2025762954"
   )
   public boolean method108(int var1) {
      return this.method109(var1) && (this.field78[var1] == 2 || this.field78[var1] == 3);
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      descriptor = "(CB)Z",
      garbageValue = "-11"
   )
   public boolean method112(char var1) {
      return this.method111(var1) && (this.field79[var1] == 2 || this.field79[var1] == 3);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      descriptor = "(IB)Z",
      garbageValue = "0"
   )
   boolean method109(int var1) {
      if (var1 >= 0 && var1 < 112) {
         return true;
      } else {
         System.out.println("Invalid keycode: " + var1);
         return false;
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      descriptor = "(CB)Z",
      garbageValue = "-1"
   )
   boolean method111(char var1) {
      if (var1 >= 0 && var1 < 192) {
         return true;
      } else {
         System.out.println("Invalid keychar: " + var1);
         return false;
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      descriptor = "(II)Z",
      garbageValue = "-361086221"
   )
   boolean method110(int var1) {
      if (var1 >= 0 && var1 < 4) {
         return true;
      } else {
         System.out.println("Invalid mode: " + var1);
         return false;
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "(Ldu;FI)F",
      garbageValue = "-834185099"
   )
   static float method114(class125 var0, float var1) {
      if (var0 == null) {
         return 0.0F;
      } else {
         float var2;
         if (var0.field1207 == var1) {
            var2 = 0.0F;
         } else if (var1 == var0.field1208) {
            var2 = 1.0F;
         } else {
            var2 = (var1 - var0.field1207) / (var0.field1208 - var0.field1207);
         }

         float var3;
         if (var0.field1221) {
            var3 = var2;
         } else {
            class122.field1176[3] = var0.field1212;
            class122.field1176[2] = var0.field1201;
            class122.field1176[1] = var0.field1223;
            class122.field1176[0] = var0.field1209 - var2;
            class122.field1179[0] = 0.0F;
            class122.field1179[1] = 0.0F;
            class122.field1179[2] = 0.0F;
            class122.field1179[3] = 0.0F;
            class122.field1179[4] = 0.0F;
            int var4 = WorldMapArchiveLoader.method2193(class122.field1176, 3, 0.0F, true, 1.0F, true, class122.field1179);
            if (var4 == 1) {
               var3 = class122.field1179[0];
            } else {
               var3 = 0.0F;
            }
         }

         return var0.field1213 + var3 * (var0.field1214 + (var3 * var0.field1216 + var0.field1215) * var3);
      }
   }
}
