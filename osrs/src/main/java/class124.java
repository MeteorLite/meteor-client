import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ek")
public class class124 {
   @ObfuscatedName("iy")
   @Export("timeOfPreviousKeyPress")
   static int timeOfPreviousKeyPress;
   @ObfuscatedName("ou")
   static int field1186;
   @ObfuscatedName("aj")
   public final int field1173;
   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "Lek;"
   )
   public class124 field1182;
   @ObfuscatedName("ac")
   float[][] field1187;
   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "[Lqt;"
   )
   final class421[] field1175;
   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "[Lqt;"
   )
   class421[] field1176;
   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      descriptor = "[Lqt;"
   )
   class421[] field1177;
   @ObfuscatedName("av")
   @ObfuscatedSignature(
      descriptor = "Lqt;"
   )
   class421 field1178 = new class421();
   @ObfuscatedName("aq")
   boolean field1172 = true;
   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      descriptor = "Lqt;"
   )
   class421 field1180 = new class421();
   @ObfuscatedName("ar")
   boolean field1181 = true;
   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      descriptor = "Lqt;"
   )
   class421 field1174 = new class421();
   @ObfuscatedName("ax")
   float[][] field1183;
   @ObfuscatedName("as")
   float[][] field1184;
   @ObfuscatedName("ay")
   float[][] field1185;

   @ObfuscatedSignature(
      descriptor = "(ILsy;Z)V"
   )
   public class124(int var1, Buffer var2, boolean var3) {
      this.field1173 = var2.readShort();
      this.field1175 = new class421[var1];
      this.field1176 = new class421[this.field1175.length];
      this.field1177 = new class421[this.field1175.length];
      this.field1187 = new float[this.field1175.length][3];

      for(int var4 = 0; var4 < this.field1175.length; ++var4) {
         this.field1175[var4] = new class421(var2, var3);
         this.field1187[var4][0] = var2.method2414();
         this.field1187[var4][1] = var2.method2414();
         this.field1187[var4][2] = var2.method2414();
      }

      this.method682();
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "-2063624266"
   )
   void method682() {
      this.field1183 = new float[this.field1175.length][3];
      this.field1184 = new float[this.field1175.length][3];
      this.field1185 = new float[this.field1175.length][3];
      class421[] var2 = class421.field3746;
      class421 var1;
      synchronized(class421.field3746) {
         if (class421.field3745 == 0) {
            var1 = new class421();
         } else {
            class421.field3746[--class421.field3745].method2193();
            var1 = class421.field3746[class421.field3745];
         }
      }

      class421 var7 = var1;

      for(int var5 = 0; var5 < this.field1175.length; ++var5) {
         class421 var4 = this.method683(var5);
         var7.method2188(var4);
         var7.method2192();
         this.field1183[var5] = var7.method2195();
         this.field1184[var5][0] = var4.field3743[12];
         this.field1184[var5][1] = var4.field3743[13];
         this.field1184[var5][2] = var4.field3743[14];
         this.field1185[var5] = var4.method2194();
      }

      var7.method2200();
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "(IB)Lqt;",
      garbageValue = "49"
   )
   class421 method683(int var1) {
      return this.field1175[var1];
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "(II)Lqt;",
      garbageValue = "-1175337484"
   )
   class421 method684(int var1) {
      if (this.field1176[var1] == null) {
         this.field1176[var1] = new class421(this.method683(var1));
         if (this.field1182 != null) {
            this.field1176[var1].method2189(this.field1182.method684(var1));
         } else {
            this.field1176[var1].method2189(class421.field3747);
         }
      }

      return this.field1176[var1];
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "(IB)Lqt;",
      garbageValue = "-71"
   )
   class421 method685(int var1) {
      if (this.field1177[var1] == null) {
         this.field1177[var1] = new class421(this.method684(var1));
         this.field1177[var1].method2192();
      }

      return this.field1177[var1];
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "(Lqt;I)V",
      garbageValue = "1219238582"
   )
   void method691(class421 var1) {
      this.field1178.method2188(var1);
      this.field1172 = true;
      this.field1181 = true;
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      descriptor = "(B)Lqt;",
      garbageValue = "83"
   )
   class421 method681() {
      return this.field1178;
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      descriptor = "(I)Lqt;",
      garbageValue = "1330180428"
   )
   class421 method686() {
      if (this.field1172) {
         this.field1180.method2188(this.method681());
         if (this.field1182 != null) {
            this.field1180.method2189(this.field1182.method686());
         }

         this.field1172 = false;
      }

      return this.field1180;
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      descriptor = "(II)Lqt;",
      garbageValue = "1012813641"
   )
   public class421 method687(int var1) {
      if (this.field1181) {
         this.field1174.method2188(this.method685(var1));
         this.field1174.method2189(this.method686());
         this.field1181 = false;
      }

      return this.field1174;
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      descriptor = "(II)[F",
      garbageValue = "-2121032861"
   )
   float[] method688(int var1) {
      return this.field1183[var1];
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      descriptor = "(II)[F",
      garbageValue = "1356694558"
   )
   float[] method689(int var1) {
      return this.field1184[var1];
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      descriptor = "(IB)[F",
      garbageValue = "-24"
   )
   float[] method690(int var1) {
      return this.field1185[var1];
   }
}
