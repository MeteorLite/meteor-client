import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fl")
public class class134 extends DualNode {
   @ObfuscatedName("av")
   public static int field1263;
   @ObfuscatedName("ak")
   @Export("Tiles_saturation")
   static int[] Tiles_saturation;
   @ObfuscatedName("aj")
   int field1264;
   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "[[Lew;"
   )
   public class127[][] field1258 = null;
   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "[[Lew;"
   )
   class127[][] field1265 = null;
   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "Lin;"
   )
   public Skeleton field1260;
   @ObfuscatedName("an")
   int field1257 = 0;
   @ObfuscatedName("ao")
   boolean field1259;
   @ObfuscatedName("ap")
   Future field1262;
   @ObfuscatedName("ar")
   List field1261;

   @ObfuscatedSignature(
      descriptor = "(Lne;Lne;IZ)V",
      garbageValue = "0"
   )
   public class134(AbstractArchive var1, AbstractArchive var2, int var3, boolean var4) {
      this.field1264 = var3;
      byte[] var5 = var1.takeFile(this.field1264 >> 16 & '\uffff', this.field1264 & '\uffff');
      Buffer var6 = new Buffer(var5);
      int var7 = var6.readUnsignedByte();
      int var8 = var6.readUnsignedShort();
      byte[] var9 = var2.getFile(var8, 0);
      this.field1260 = new Skeleton(var8, var9);
      this.field1261 = new ArrayList();
      this.field1262 = UserComparator7.field1146.submit(new class131(this, var6, var7));
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "(Lsy;IB)V",
      garbageValue = "15"
   )
   void method729(Buffer var1, int var2) {
      var1.readUnsignedShort();
      var1.readUnsignedShort();
      this.field1257 = var1.readUnsignedByte();
      int var3 = var1.readUnsignedShort();
      this.field1265 = new class127[this.field1260.method1185().method1177()][];
      this.field1258 = new class127[this.field1260.method1186()][];
      class126[] var4 = new class126[var3];

      int var5;
      int var7;
      for(var5 = 0; var5 < var3; ++var5) {
         class128 var6 = UserComparator9.method664(var1.readUnsignedByte());
         var7 = var1.readShortSmart();
         class129 var8 = WorldMapSectionType.method1444(var1.readUnsignedByte());
         class127 var9 = new class127();
         var9.method698(var1, var2);
         var4[var5] = new class126(this, var9, var6, var8, var7);
         int var10 = var6.method707();
         class127[][] var11;
         if (var6 == class128.field1234) {
            var11 = this.field1265;
         } else {
            var11 = this.field1258;
         }

         if (var11[var7] == null) {
            var11[var7] = new class127[var10];
         }

         if (var6 == class128.field1228) {
            this.field1259 = true;
         }
      }

      var5 = var3 / field1263;
      int var12 = var3 % field1263;
      int var13 = 0;

      for(int var14 = 0; var14 < field1263; ++var14) {
         var7 = var13;
         var13 += var5;
         if (var12 > 0) {
            ++var13;
            --var12;
         }

         if (var13 == var7) {
            break;
         }

         this.field1261.add(UserComparator7.field1146.submit(new class133(this, var7, var13, var4)));
      }

   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "(I)Z",
      garbageValue = "204129598"
   )
   public boolean method725() {
      if (this.field1262 == null && this.field1261 == null) {
         return true;
      } else {
         if (this.field1262 != null) {
            if (!this.field1262.isDone()) {
               return false;
            }

            this.field1262 = null;
         }

         boolean var1 = true;

         for(int var2 = 0; var2 < this.field1261.size(); ++var2) {
            if (!((Future)this.field1261.get(var2)).isDone()) {
               var1 = false;
            } else {
               this.field1261.remove(var2);
               --var2;
            }
         }

         if (!var1) {
            return false;
         } else {
            this.field1261 = null;
            return true;
         }
      }
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "(B)I",
      garbageValue = "44"
   )
   public int method731() {
      return this.field1257;
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "(I)Z",
      garbageValue = "-213201648"
   )
   public boolean method724() {
      return this.field1259;
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "(ILek;III)V",
      garbageValue = "-1829799905"
   )
   public void method727(int var1, class124 var2, int var3, int var4) {
      class421[] var6 = class421.field3746;
      class421 var5;
      synchronized(class421.field3746) {
         if (class421.field3745 == 0) {
            var5 = new class421();
         } else {
            class421.field3746[--class421.field3745].method2193();
            var5 = class421.field3746[class421.field3745];
         }
      }

      this.method728(var5, var3, var2, var1);
      this.method726(var5, var3, var2, var1);
      this.method730(var5, var3, var2, var1);
      var2.method691(var5);
      var5.method2200();
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      descriptor = "(Lqt;ILek;IB)V",
      garbageValue = "-67"
   )
   void method728(class421 var1, int var2, class124 var3, int var4) {
      float[] var5 = var3.method688(this.field1257);
      float var6 = var5[0];
      float var7 = var5[1];
      float var8 = var5[2];
      if (this.field1265[var2] != null) {
         class127 var9 = this.field1265[var2][0];
         class127 var10 = this.field1265[var2][1];
         class127 var11 = this.field1265[var2][2];
         if (var9 != null) {
            var6 = var9.method699(var4);
         }

         if (var10 != null) {
            var7 = var10.method699(var4);
         }

         if (var11 != null) {
            var8 = var11.method699(var4);
         }
      }

      class420 var17 = class287.method1546();
      var17.method2181(1.0F, 0.0F, 0.0F, var6);
      class420 var18 = class287.method1546();
      var18.method2181(0.0F, 1.0F, 0.0F, var7);
      class420 var19 = class287.method1546();
      var19.method2181(0.0F, 0.0F, 1.0F, var8);
      class420 var12 = class287.method1546();
      var12.method2180(var19);
      var12.method2180(var17);
      var12.method2180(var18);
      class421[] var14 = class421.field3746;
      class421 var13;
      synchronized(class421.field3746) {
         if (class421.field3745 == 0) {
            var13 = new class421();
         } else {
            class421.field3746[--class421.field3745].method2193();
            var13 = class421.field3746[class421.field3745];
         }
      }

      var13.method2190(var12);
      var1.method2189(var13);
      var17.method2183();
      var18.method2183();
      var19.method2183();
      var12.method2183();
      var13.method2200();
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      descriptor = "(Lqt;ILek;IB)V",
      garbageValue = "21"
   )
   void method730(class421 var1, int var2, class124 var3, int var4) {
      float[] var5 = var3.method689(this.field1257);
      float var6 = var5[0];
      float var7 = var5[1];
      float var8 = var5[2];
      if (this.field1265[var2] != null) {
         class127 var9 = this.field1265[var2][3];
         class127 var10 = this.field1265[var2][4];
         class127 var11 = this.field1265[var2][5];
         if (var9 != null) {
            var6 = var9.method699(var4);
         }

         if (var10 != null) {
            var7 = var10.method699(var4);
         }

         if (var11 != null) {
            var8 = var11.method699(var4);
         }
      }

      var1.field3743[12] = var6;
      var1.field3743[13] = var7;
      var1.field3743[14] = var8;
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      descriptor = "(Lqt;ILek;IB)V",
      garbageValue = "-128"
   )
   void method726(class421 var1, int var2, class124 var3, int var4) {
      float[] var5 = var3.method690(this.field1257);
      float var6 = var5[0];
      float var7 = var5[1];
      float var8 = var5[2];
      if (this.field1265[var2] != null) {
         class127 var9 = this.field1265[var2][6];
         class127 var10 = this.field1265[var2][7];
         class127 var11 = this.field1265[var2][8];
         if (var9 != null) {
            var6 = var9.method699(var4);
         }

         if (var10 != null) {
            var7 = var10.method699(var4);
         }

         if (var11 != null) {
            var8 = var11.method699(var4);
         }
      }

      class421[] var14 = class421.field3746;
      class421 var15;
      synchronized(class421.field3746) {
         if (class421.field3745 == 0) {
            var15 = new class421();
         } else {
            class421.field3746[--class421.field3745].method2193();
            var15 = class421.field3746[class421.field3745];
         }
      }

      var15.method2186(var6, var7, var8);
      var1.method2189(var15);
      var15.method2200();
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "(II)Lhk;",
      garbageValue = "-998339406"
   )
   public static FloorUnderlayDefinition method732(int var0) {
      FloorUnderlayDefinition var1 = (FloorUnderlayDefinition)FloorUnderlayDefinition.FloorUnderlayDefinition_cached.get((long)var0);
      if (var1 != null) {
         return var1;
      } else {
         byte[] var2 = FloorUnderlayDefinition.FloorUnderlayDefinition_archive.takeFile(1, var0);
         var1 = new FloorUnderlayDefinition();
         if (var2 != null) {
            var1.decode(new Buffer(var2), var0);
         }

         var1.postDecode();
         FloorUnderlayDefinition.FloorUnderlayDefinition_cached.put(var1, (long)var0);
         return var1;
      }
   }
}
