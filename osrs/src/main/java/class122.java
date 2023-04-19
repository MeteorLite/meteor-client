import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ew")
public class class122 {
   @ObfuscatedName("af")
   public final int field1195;
   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "Lew;"
   )
   public class122 field1192;
   @ObfuscatedName("aw")
   float[][] field1188;
   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "[Lqj;"
   )
   final class425[] field1189;
   @ObfuscatedName("au")
   @ObfuscatedSignature(
      descriptor = "[Lqj;"
   )
   class425[] field1190;
   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "[Lqj;"
   )
   class425[] field1191;
   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      descriptor = "Lqj;"
   )
   class425 field1199 = new class425();
   @ObfuscatedName("al")
   boolean field1193 = true;
   @ObfuscatedName("at")
   @ObfuscatedSignature(
      descriptor = "Lqj;"
   )
   class425 field1194 = new class425();
   @ObfuscatedName("aa")
   boolean field1186 = true;
   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      descriptor = "Lqj;"
   )
   class425 field1196 = new class425();
   @ObfuscatedName("ao")
   float[][] field1197;
   @ObfuscatedName("ax")
   float[][] field1187;
   @ObfuscatedName("ai")
   float[][] field1198;

   @ObfuscatedSignature(
      descriptor = "(ILsg;Z)V"
   )
   public class122(int var1, Buffer var2, boolean var3) {
      this.field1195 = var2.readShort();
      this.field1189 = new class425[var1];
      this.field1190 = new class425[this.field1189.length];
      this.field1191 = new class425[this.field1189.length];
      this.field1188 = new float[this.field1189.length][3];

      for(int var4 = 0; var4 < this.field1189.length; ++var4) {
         this.field1189[var4] = new class425(var2, var3);
         this.field1188[var4][0] = var2.method2487();
         this.field1188[var4][1] = var2.method2487();
         this.field1188[var4][2] = var2.method2487();
      }

      this.method725();
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "685443179"
   )
   void method725() {
      this.field1197 = new float[this.field1189.length][3];
      this.field1187 = new float[this.field1189.length][3];
      this.field1198 = new float[this.field1189.length][3];
      class425[] var2 = class425.field3793;
      class425 var1;
      synchronized(class425.field3793) {
         if (class425.field3794 == 0) {
            var1 = new class425();
         } else {
            class425.field3793[--class425.field3794].method2250();
            var1 = class425.field3793[class425.field3794];
         }
      }

      class425 var7 = var1;

      for(int var5 = 0; var5 < this.field1189.length; ++var5) {
         class425 var4 = this.method726(var5);
         var7.method2252(var4);
         var7.method2259();
         this.field1197[var5] = var7.method2246();
         this.field1187[var5][0] = var4.field3797[12];
         this.field1187[var5][1] = var4.field3797[13];
         this.field1187[var5][2] = var4.field3797[14];
         this.field1198[var5] = var4.method2261();
      }

      var7.method2249();
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "(IB)Lqj;",
      garbageValue = "0"
   )
   class425 method726(int var1) {
      return this.field1189[var1];
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      descriptor = "(IB)Lqj;",
      garbageValue = "8"
   )
   class425 method727(int var1) {
      if (this.field1190[var1] == null) {
         this.field1190[var1] = new class425(this.method726(var1));
         if (this.field1192 != null) {
            this.field1190[var1].method2255(this.field1192.method727(var1));
         } else {
            this.field1190[var1].method2255(class425.field3792);
         }
      }

      return this.field1190[var1];
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "(II)Lqj;",
      garbageValue = "2116559151"
   )
   class425 method732(int var1) {
      if (this.field1191[var1] == null) {
         this.field1191[var1] = new class425(this.method727(var1));
         this.field1191[var1].method2259();
      }

      return this.field1191[var1];
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      descriptor = "(Lqj;I)V",
      garbageValue = "-2093338496"
   )
   void method733(class425 var1) {
      this.field1199.method2252(var1);
      this.field1193 = true;
      this.field1186 = true;
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "(I)Lqj;",
      garbageValue = "535482001"
   )
   class425 method729() {
      return this.field1199;
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      descriptor = "(B)Lqj;",
      garbageValue = "2"
   )
   class425 method735() {
      if (this.field1193) {
         this.field1194.method2252(this.method729());
         if (this.field1192 != null) {
            this.field1194.method2255(this.field1192.method735());
         }

         this.field1193 = false;
      }

      return this.field1194;
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "(II)Lqj;",
      garbageValue = "250554518"
   )
   public class425 method728(int var1) {
      if (this.field1186) {
         this.field1196.method2252(this.method732(var1));
         this.field1196.method2255(this.method735());
         this.field1186 = false;
      }

      return this.field1196;
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      descriptor = "(II)[F",
      garbageValue = "689701217"
   )
   float[] method734(int var1) {
      return this.field1197[var1];
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      descriptor = "(II)[F",
      garbageValue = "2097133235"
   )
   float[] method730(int var1) {
      return this.field1187[var1];
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      descriptor = "(II)[F",
      garbageValue = "-2141341986"
   )
   float[] method731(int var1) {
      return this.field1198[var1];
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      descriptor = "(IB)Lhb;",
      garbageValue = "4"
   )
   public static HitSplatDefinition method738(int var0) {
      HitSplatDefinition var1 = (HitSplatDefinition)HitSplatDefinition.HitSplatDefinition_cached.get((long)var0);
      if (var1 != null) {
         return var1;
      } else {
         byte[] var2 = HitSplatDefinition.HitSplatDefinition_archive.takeFile(32, var0);
         var1 = new HitSplatDefinition();
         if (var2 != null) {
            var1.decode(new Buffer(var2));
         }

         HitSplatDefinition.HitSplatDefinition_cached.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      descriptor = "(IIIII)V",
      garbageValue = "-1549240794"
   )
   static final void method736(int var0, int var1, int var2, int var3) {
      for(int var4 = var1; var4 <= var3 + var1; ++var4) {
         for(int var5 = var0; var5 <= var0 + var2; ++var5) {
            if (var5 >= 0 && var5 < 104 && var4 >= 0 && var4 < 104) {
               Tiles.field819[0][var5][var4] = 127;
               if (var0 == var5 && var5 > 0) {
                  Tiles.Tiles_heights[0][var5][var4] = Tiles.Tiles_heights[0][var5 - 1][var4];
               }

               if (var5 == var0 + var2 && var5 < 103) {
                  Tiles.Tiles_heights[0][var5][var4] = Tiles.Tiles_heights[0][var5 + 1][var4];
               }

               if (var4 == var1 && var4 > 0) {
                  Tiles.Tiles_heights[0][var5][var4] = Tiles.Tiles_heights[0][var5][var4 - 1];
               }

               if (var4 == var3 + var1 && var4 < 103) {
                  Tiles.Tiles_heights[0][var5][var4] = Tiles.Tiles_heights[0][var5][var4 + 1];
               }
            }
         }
      }

   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "-702557639"
   )
   static final void method737() {
      if (!ViewportMouse.ViewportMouse_false0) {
         int var0 = Scene.Scene_cameraPitchSine;
         int var1 = Scene.Scene_cameraPitchCosine;
         int var2 = Scene.Scene_cameraYawSine;
         int var3 = Scene.Scene_cameraYawCosine;
         byte var4 = 50;
         short var5 = 3500;
         int var6 = (ViewportMouse.ViewportMouse_x - TaskHandler.getClipMidX()) * var4 / UserComparator7.get3dZoom();
         int var7 = (ViewportMouse.ViewportMouse_y - class12.getClipMidY()) * var4 / UserComparator7.get3dZoom();
         int var8 = (ViewportMouse.ViewportMouse_x - TaskHandler.getClipMidX()) * var5 / UserComparator7.get3dZoom();
         int var9 = (ViewportMouse.ViewportMouse_y - class12.getClipMidY()) * var5 / UserComparator7.get3dZoom();
         int var11 = var1 * var7 + var0 * var4 >> 16;
         int var12 = var1 * var4 - var0 * var7 >> 16;
         int var13 = var5 * var0 + var1 * var9 >> 16;
         int var14 = var1 * var5 - var9 * var0 >> 16;
         int var10 = class387.method2093(var6, var12, var3, var2);
         int var15 = class437.method2295(var6, var12, var3, var2);
         var6 = var10;
         var10 = class387.method2093(var8, var14, var3, var2);
         int var16 = class437.method2295(var8, var14, var3, var2);
         ViewportMouse.field2207 = (var6 + var10) / 2;
         class294.field2715 = (var11 + var13) / 2;
         ViewportMouse.field2208 = (var16 + var15) / 2;
         ViewportMouse.field2209 = (var10 - var6) / 2;
         UserComparator8.field1157 = (var13 - var11) / 2;
         ReflectionCheck.field166 = (var16 - var15) / 2;
         EnumComposition.field1536 = Math.abs(ViewportMouse.field2209);
         ViewportMouse.field2211 = Math.abs(UserComparator8.field1157);
         class9.field29 = Math.abs(ReflectionCheck.field166);
      }
   }
}
