import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ei")
public class class133 extends DualNode {
   @ObfuscatedName("f")
   int field1269;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      descriptor = "[[Lda;"
   )
   public class125[][] field1266 = null;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "[[Lda;"
   )
   class125[][] field1267 = null;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      descriptor = "Lha;"
   )
   public Skeleton field1265;
   @ObfuscatedName("z")
   int field1264 = 0;
   @ObfuscatedName("j")
   boolean field1262;
   @ObfuscatedName("l")
   Future field1268;
   @ObfuscatedName("k")
   List field1263;

   @ObfuscatedSignature(
      descriptor = "(Lln;Lln;IZ)V"
   )
   class133(AbstractArchive var1, AbstractArchive var2, int var3, boolean var4) {
      this.field1269 = var3;
      byte[] var5 = var1.takeFile(this.field1269 >> 16 & '\uffff', this.field1269 & '\uffff');
      Buffer var6 = new Buffer(var5);
      int var7 = var6.readUnsignedByte();
      int var8 = var6.readUnsignedShort();
      byte[] var9;
      if (var4) {
         var9 = var2.getFile(0, var8);
      } else {
         var9 = var2.getFile(var8, 0);
      }

      this.field1265 = new Skeleton(var8, var9);
      this.field1263 = new ArrayList();
      this.field1268 = class277.field2428.submit(new class132(this, var6, var7));
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      descriptor = "(Lrd;IS)V",
      garbageValue = "-4594"
   )
   void method725(Buffer var1, int var2) {
      var1.readUnsignedShort();
      var1.readUnsignedShort();
      this.field1264 = var1.readUnsignedByte();
      int var3 = var1.readUnsignedShort();
      this.field1267 = new class125[this.field1265.method1184().method1178()][];
      this.field1266 = new class125[this.field1265.method1183()][];
      class124[] var4 = new class124[var3];

      int var5;
      int var7;
      int var16;
      for(var5 = 0; var5 < var3; ++var5) {
         var7 = var1.readUnsignedByte();
         class126[] var8 = new class126[]{class126.field1227, class126.field1229, class126.field1235, class126.field1230, class126.field1232, class126.field1231};
         class126 var9 = (class126)class4.findEnumerated(var8, var7);
         if (var9 == null) {
            var9 = class126.field1227;
         }

         var16 = var1.readShortSmart();
         int var11 = var1.readUnsignedByte();
         class127 var12 = (class127)class4.findEnumerated(class122.method688(), var11);
         if (var12 == null) {
            var12 = class127.field1244;
         }

         class125 var13 = new class125();
         var13.method704(var1, var2);
         var4[var5] = new class124(this, var13, var9, var12, var16);
         int var14 = var9.method708();
         class125[][] var15;
         if (var9 == class126.field1229) {
            var15 = this.field1267;
         } else {
            var15 = this.field1266;
         }

         if (var15[var16] == null) {
            var15[var16] = new class125[var14];
         }

         if (var9 == class126.field1232) {
            this.field1262 = true;
         }
      }

      var5 = var3 / class461.field3977;
      int var17 = var3 % class461.field3977;
      int var18 = 0;

      for(var16 = 0; var16 < class461.field3977; ++var16) {
         var7 = var18;
         var18 += var5;
         if (var17 > 0) {
            ++var18;
            --var17;
         }

         if (var18 == var7) {
            break;
         }

         this.field1263.add(class277.field2428.submit(new class128(this, var7, var18, var4)));
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "(S)Z",
      garbageValue = "21065"
   )
   public boolean method719() {
      if (this.field1268 == null && this.field1263 == null) {
         return true;
      } else {
         if (this.field1268 != null) {
            if (!this.field1268.isDone()) {
               return false;
            }

            this.field1268 = null;
         }

         boolean var1 = true;

         for(int var2 = 0; var2 < this.field1263.size(); ++var2) {
            if (!((Future)this.field1263.get(var2)).isDone()) {
               var1 = false;
            } else {
               this.field1263.remove(var2);
               --var2;
            }
         }

         if (!var1) {
            return false;
         } else {
            this.field1263 = null;
            return true;
         }
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      descriptor = "(B)I",
      garbageValue = "1"
   )
   public int method726() {
      return this.field1264;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      descriptor = "(I)Z",
      garbageValue = "-1498028146"
   )
   public boolean method720() {
      return this.field1262;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      descriptor = "(ILdc;III)V",
      garbageValue = "-2140393878"
   )
   public void method721(int var1, class122 var2, int var3, int var4) {
      class417[] var6 = class417.field3775;
      class417 var5;
      synchronized(class417.field3775) {
         if (class417.field3777 == 0) {
            var5 = new class417();
         } else {
            class417.field3775[--class417.field3777].method2187();
            var5 = class417.field3775[class417.field3777];
         }
      }

      this.method718(var5, var3, var2, var1);
      this.method724(var5, var3, var2, var1);
      this.method723(var5, var3, var2, var1);
      var2.method676(var5);
      var5.method2172();
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      descriptor = "(Lpb;ILdc;II)V",
      garbageValue = "1446395810"
   )
   void method718(class417 var1, int var2, class122 var3, int var4) {
      float[] var5 = var3.method679(this.field1264);
      float var6 = var5[0];
      float var7 = var5[1];
      float var8 = var5[2];
      if (this.field1267[var2] != null) {
         class125 var9 = this.field1267[var2][0];
         class125 var10 = this.field1267[var2][1];
         class125 var11 = this.field1267[var2][2];
         if (var9 != null) {
            var6 = var9.method696(var4);
         }

         if (var10 != null) {
            var7 = var10.method696(var4);
         }

         if (var11 != null) {
            var8 = var11.method696(var4);
         }
      }

      class416[] var26 = class416.field3770;
      class416 var25;
      synchronized(class416.field3770) {
         if (class388.field3666 == 0) {
            var25 = new class416();
         } else {
            class416.field3770[--class388.field3666].method2168();
            var25 = class416.field3770[class388.field3666];
         }
      }

      var25.method2171(1.0F, 0.0F, 0.0F, var6);
      class416[] var12 = class416.field3770;
      class416 var27;
      synchronized(class416.field3770) {
         if (class388.field3666 == 0) {
            var27 = new class416();
         } else {
            class416.field3770[--class388.field3666].method2168();
            var27 = class416.field3770[class388.field3666];
         }
      }

      var27.method2171(0.0F, 1.0F, 0.0F, var7);
      class416[] var14 = class416.field3770;
      class416 var13;
      synchronized(class416.field3770) {
         if (class388.field3666 == 0) {
            var13 = new class416();
         } else {
            class416.field3770[--class388.field3666].method2168();
            var13 = class416.field3770[class388.field3666];
         }
      }

      var13.method2171(0.0F, 0.0F, 1.0F, var8);
      class416[] var16 = class416.field3770;
      class416 var15;
      synchronized(class416.field3770) {
         if (class388.field3666 == 0) {
            var15 = new class416();
         } else {
            class416.field3770[--class388.field3666].method2168();
            var15 = class416.field3770[class388.field3666];
         }
      }

      var15.method2169(var13);
      var15.method2169(var25);
      var15.method2169(var27);
      class417[] var18 = class417.field3775;
      class417 var17;
      synchronized(class417.field3775) {
         if (class417.field3777 == 0) {
            var17 = new class417();
         } else {
            class417.field3775[--class417.field3777].method2187();
            var17 = class417.field3775[class417.field3777];
         }
      }

      var17.method2178(var15);
      var1.method2175(var17);
      var25.method2170();
      var27.method2170();
      var13.method2170();
      var15.method2170();
      var17.method2172();
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      descriptor = "(Lpb;ILdc;IB)V",
      garbageValue = "-85"
   )
   void method723(class417 var1, int var2, class122 var3, int var4) {
      float[] var5 = var3.method682(this.field1264);
      float var6 = var5[0];
      float var7 = var5[1];
      float var8 = var5[2];
      if (this.field1267[var2] != null) {
         class125 var9 = this.field1267[var2][3];
         class125 var10 = this.field1267[var2][4];
         class125 var11 = this.field1267[var2][5];
         if (var9 != null) {
            var6 = var9.method696(var4);
         }

         if (var10 != null) {
            var7 = var10.method696(var4);
         }

         if (var11 != null) {
            var8 = var11.method696(var4);
         }
      }

      var1.field3778[12] = var6;
      var1.field3778[13] = var7;
      var1.field3778[14] = var8;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      descriptor = "(Lpb;ILdc;II)V",
      garbageValue = "1689322046"
   )
   void method724(class417 var1, int var2, class122 var3, int var4) {
      float[] var5 = var3.method681(this.field1264);
      float var6 = var5[0];
      float var7 = var5[1];
      float var8 = var5[2];
      if (this.field1267[var2] != null) {
         class125 var9 = this.field1267[var2][6];
         class125 var10 = this.field1267[var2][7];
         class125 var11 = this.field1267[var2][8];
         if (var9 != null) {
            var6 = var9.method696(var4);
         }

         if (var10 != null) {
            var7 = var10.method696(var4);
         }

         if (var11 != null) {
            var8 = var11.method696(var4);
         }
      }

      class417[] var14 = class417.field3775;
      class417 var15;
      synchronized(class417.field3775) {
         if (class417.field3777 == 0) {
            var15 = new class417();
         } else {
            class417.field3775[--class417.field3777].method2187();
            var15 = class417.field3775[class417.field3777];
         }
      }

      var15.method2182(var6, var7, var8);
      var1.method2175(var15);
      var15.method2172();
   }

    @ObfuscatedName("f")
    @ObfuscatedSignature(
            descriptor = "(IB)Lkz;",
            garbageValue = "74"
    )
    public static Widget getWidget(int var0) {
      int var1 = var0 >> 16;
      int var2 = var0 & '\uffff';
      if (WorldMapLabel.Widget_interfaceComponents[var1] == null || WorldMapLabel.Widget_interfaceComponents[var1][var2] == null) {
         boolean var3 = class153.loadInterface(var1);
         if (!var3) {
            return null;
         }
      }

      return WorldMapLabel.Widget_interfaceComponents[var1][var2];
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "(IIII)I",
      garbageValue = "-186134787"
   )
   public static int method727(int var0, int var1, int var2) {
      var2 &= 3;
      if (var2 == 0) {
         return var0;
      } else if (var2 == 1) {
         return var1;
      } else {
         return var2 == 2 ? 7 - var0 : 7 - var1;
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "(B)I",
      garbageValue = "-25"
   )
   public static int method728() {
      return ++MouseHandler.MouseHandler_idleCycles - 1;
   }
}
