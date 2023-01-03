import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dt")
public class class123 {
   @ObfuscatedName("h")
   public final int field1184;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "Ldt;"
   )
   public class123 field1181;
   @ObfuscatedName("v")
   float[][] field1182;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      descriptor = "[Loj;"
   )
   final class410[] field1183;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      descriptor = "[Loj;"
   )
   class410[] field1180;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      descriptor = "[Loj;"
   )
   class410[] field1185;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "Loj;"
   )
   class410 field1186 = new class410();
   @ObfuscatedName("r")
   boolean field1190 = true;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      descriptor = "Loj;"
   )
   class410 field1192 = new class410();
   @ObfuscatedName("b")
   boolean field1189 = true;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      descriptor = "Loj;"
   )
   class410 field1187 = new class410();
   @ObfuscatedName("g")
   float[][] field1188;
   @ObfuscatedName("i")
   float[][] field1191;
   @ObfuscatedName("o")
   float[][] field1193;

   @ObfuscatedSignature(
      descriptor = "(ILqy;Z)V"
   )
   public class123(int var1, Buffer var2, boolean var3) {
      this.field1184 = var2.readShort();
      this.field1183 = new class410[var1];
      this.field1180 = new class410[this.field1183.length];
      this.field1185 = new class410[this.field1183.length];
      this.field1182 = new float[this.field1183.length][3];

      for(int var4 = 0; var4 < this.field1183.length; ++var4) {
         this.field1183[var4] = new class410(var2, var3);
         this.field1182[var4][0] = var2.method2354();
         this.field1182[var4][1] = var2.method2354();
         this.field1182[var4][2] = var2.method2354();
      }

      this.method682();
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "-114"
   )
   void method682() {
      this.field1188 = new float[this.field1183.length][3];
      this.field1191 = new float[this.field1183.length][3];
      this.field1193 = new float[this.field1183.length][3];
      class410 var1 = class326.method1778();

      for(int var2 = 0; var2 < this.field1183.length; ++var2) {
         class410 var3 = this.method692(var2);
         var1.method2133(var3);
         var1.method2139();
         this.field1188[var2] = var1.method2130();
         this.field1191[var2][0] = var3.field3763[12];
         this.field1191[var2][1] = var3.field3763[13];
         this.field1191[var2][2] = var3.field3763[14];
         this.field1193[var2] = var3.method2140();
      }

      var1.method2141();
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "(II)Loj;",
      garbageValue = "-197286260"
   )
   class410 method692(int var1) {
      return this.field1183[var1];
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "(IB)Loj;",
      garbageValue = "-39"
   )
   class410 method683(int var1) {
      if (this.field1180[var1] == null) {
         this.field1180[var1] = new class410(this.method692(var1));
         if (this.field1181 != null) {
            this.field1180[var1].method2136(this.field1181.method683(var1));
         } else {
            this.field1180[var1].method2136(class410.field3764);
         }
      }

      return this.field1180[var1];
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      descriptor = "(IS)Loj;",
      garbageValue = "-1313"
   )
   class410 method691(int var1) {
      if (this.field1185[var1] == null) {
         this.field1185[var1] = new class410(this.method683(var1));
         this.field1185[var1].method2139();
      }

      return this.field1185[var1];
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      descriptor = "(Loj;I)V",
      garbageValue = "-969750342"
   )
   void method686(class410 var1) {
      this.field1186.method2133(var1);
      this.field1190 = true;
      this.field1189 = true;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      descriptor = "(I)Loj;",
      garbageValue = "1985387676"
   )
   class410 method685() {
      return this.field1186;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "(I)Loj;",
      garbageValue = "46823189"
   )
   class410 method690() {
      if (this.field1190) {
         this.field1192.method2133(this.method685());
         if (this.field1181 != null) {
            this.field1192.method2136(this.field1181.method690());
         }

         this.field1190 = false;
      }

      return this.field1192;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      descriptor = "(II)Loj;",
      garbageValue = "1286617605"
   )
   public class410 method684(int var1) {
      if (this.field1189) {
         this.field1187.method2133(this.method691(var1));
         this.field1187.method2136(this.method690());
         this.field1189 = false;
      }

      return this.field1187;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      descriptor = "(IB)[F",
      garbageValue = "0"
   )
   float[] method687(int var1) {
      return this.field1188[var1];
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      descriptor = "(II)[F",
      garbageValue = "-2100029248"
   )
   float[] method688(int var1) {
      return this.field1191[var1];
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      descriptor = "(IS)[F",
      garbageValue = "1900"
   )
   float[] method689(int var1) {
      return this.field1193[var1];
   }
}
