import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("oa")
public class class383 {
   @ObfuscatedName("af")
   @ObfuscatedSignature(
      descriptor = "Loq;"
   )
   class379 field3650;
   @ObfuscatedName("an")
   int field3648 = 0;
   @ObfuscatedName("aw")
   int field3649 = 0;

   @ObfuscatedSignature(
      descriptor = "(Loq;II)V"
   )
   class383(class379 var1, int var2, int var3) {
      this.field3650 = var1;
      this.field3648 = var2;
      this.field3649 = var3;
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      descriptor = "(I)Ljava/lang/String;",
      garbageValue = "-48485402"
   )
   public String method2083() {
      if (this.method2078()) {
         return "";
      } else {
         StringBuilder var1 = new StringBuilder(this.method2079());

         for(int var2 = this.field3648; var2 < this.field3649; ++var2) {
            class381 var3 = this.field3650.method2002(var2);
            var1.append(var3.field3624);
         }

         return var1.toString();
      }
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "(II)Z",
      garbageValue = "1783943189"
   )
   boolean method2081(int var1) {
      return this.field3650.method2024() == 2 || this.field3650.method2024() == 1 && (!this.field3650.field3618 || this.field3649 - 1 != var1);
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      descriptor = "(I)Z",
      garbageValue = "791000990"
   )
   public boolean method2078() {
      return this.field3649 == this.field3648;
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "(B)I",
      garbageValue = "87"
   )
   public int method2079() {
      return this.field3649 - this.field3648;
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      descriptor = "(Lom;I)Z",
      garbageValue = "-2138550127"
   )
   boolean method2082(class381 var1) {
      if (this.field3650.field3621 == 2) {
         return true;
      } else if (this.field3650.field3621 == 0) {
         return false;
      } else {
         return this.field3650.method2023() != var1;
      }
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "-2139094912"
   )
   int method2084() {
      if (this.method2078()) {
         return 0;
      } else {
         class381 var1 = this.field3650.method2002(this.field3649 - 1);
         if (var1.field3624 == '\n') {
            return 0;
         } else if (this.method2082(var1)) {
            return this.field3650.field3612.advances[42];
         } else {
            int var2 = this.field3650.field3612.advances[var1.field3624];
            if (var2 == 0) {
               return var1.field3624 == '\t' ? this.field3650.field3612.advances[32] * 3 : this.field3650.field3612.advances[32];
            } else {
               return var2;
            }
         }
      }
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      descriptor = "(B)Lrg;",
      garbageValue = "5"
   )
   public class461 method2077() {
      if (this.method2078()) {
         return new class461(0, 0);
      } else {
         class381 var1 = this.field3650.method2002(this.field3649 - 1);
         return new class461(var1.field3623 + this.method2084(), var1.field3625);
      }
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "(II)Lom;",
      garbageValue = "-1037292745"
   )
   public class381 method2080(int var1) {
      return var1 >= 0 && var1 < this.method2079() ? this.field3650.method2002(this.field3648 + var1) : null;
   }

    @ObfuscatedName("an")
    @ObfuscatedSignature(
            descriptor = "(II)Ljava/lang/String;",
            garbageValue = "-1607388222"
    )
    static String colorStartTag(int var0) {
      return "<col=" + Integer.toHexString(var0) + ">";
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "-1054245173"
   )
   public static void method2087() {
      DbTableType.DBTableType_cache.clear();
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      descriptor = "(IIB)I",
      garbageValue = "119"
   )
   static final int method2085(int var0, int var1) {
      int var2 = Actor.method537(var0 - 1, var1 - 1) + Actor.method537(var0 + 1, var1 - 1) + Actor.method537(var0 - 1, var1 + 1) + Actor.method537(var0 + 1, var1 + 1);
      int var3 = Actor.method537(var0 - 1, var1) + Actor.method537(var0 + 1, var1) + Actor.method537(var0, var1 - 1) + Actor.method537(var0, var1 + 1);
      int var4 = Actor.method537(var0, var1);
      return var2 / 16 + var3 / 8 + var4 / 4;
   }

   @ObfuscatedName("nj")
   @ObfuscatedSignature(
      descriptor = "(Lsg;B)V",
      garbageValue = "23"
   )
   static void method2086(Buffer var0) {
      if (Client.randomDatData != null) {
         var0.writeBytes(Client.randomDatData, 0, Client.randomDatData.length);
      } else {
         byte[] var2 = new byte[24];

         try {
            JagexCache.JagexCache_randomDat.seek(0L);
            JagexCache.JagexCache_randomDat.readFully(var2);

            int var3;
            for(var3 = 0; var3 < 24 && var2[var3] == 0; ++var3) {
               ;
            }

            if (var3 >= 24) {
               throw new IOException();
            }
         } catch (Exception var6) {
            for(int var4 = 0; var4 < 24; ++var4) {
               var2[var4] = -1;
            }
         }

         var0.writeBytes(var2, 0, var2.length);
      }
   }
}
