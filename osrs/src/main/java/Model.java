import java.util.HashMap;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hh")
@Implements("Model")
public class Model extends Renderable {
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "Lhh;"
   )
   static Model Model_sharedSequenceModel = new Model();
   @ObfuscatedName("e")
   static byte[] Model_sharedSequenceModelFaceAlphas = new byte[1];
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "Lhh;"
   )
   static Model Model_sharedSpotAnimationModel = new Model();
   @ObfuscatedName("x")
   static byte[] Model_sharedSpotAnimationModelFaceAlphas = new byte[1];
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      descriptor = "Loj;"
   )
   static class410 field2116 = new class410();
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      descriptor = "Loj;"
   )
   static class410 field2117 = new class410();
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "Loj;"
   )
   static class410 field2118 = new class410();
   @ObfuscatedName("az")
   static boolean[] field2150 = new boolean[6500];
   @ObfuscatedName("ak")
   static boolean[] field2151 = new boolean[6500];
   @ObfuscatedName("af")
   static int[] modelViewportXs = new int[6500];
   @ObfuscatedName("ai")
   static int[] modelViewportYs = new int[6500];
   @ObfuscatedName("ax")
   static int[] field2120 = new int[6500];
   @ObfuscatedName("ah")
   static int[] field2155 = new int[6500];
   @ObfuscatedName("aw")
   static int[] field2156 = new int[6500];
   @ObfuscatedName("aj")
   static int[] field2121 = new int[6500];
   @ObfuscatedName("ap")
   static char[] field2165 = new char[6000];
   @ObfuscatedName("aa")
   static char[][] field2130 = new char[6000][512];
   @ObfuscatedName("ae")
   static int[] field2122 = new int[12];
   @ObfuscatedName("ac")
   static int[][] field2179 = new int[12][2000];
   @ObfuscatedName("bh")
   static int[] field2163 = new int[2000];
   @ObfuscatedName("be")
   static int[] field2164 = new int[2000];
   @ObfuscatedName("bf")
   static int[] field2135 = new int[12];
   @ObfuscatedName("bo")
   static int[] field2166 = new int[10];
   @ObfuscatedName("by")
   static int[] field2112 = new int[10];
   @ObfuscatedName("bw")
   static int[] field2157 = new int[10];
   @ObfuscatedName("bp")
   static int Model_transformTempX;
   @ObfuscatedName("bc")
   static int Model_transformTempY;
   @ObfuscatedName("bl")
   static int Model_transformTempZ;
   @ObfuscatedName("bv")
   static boolean field2172 = true;
   @ObfuscatedName("bz")
   static int[] field2154;
   @ObfuscatedName("bi")
   static int[] field2174;
   @ObfuscatedName("br")
   static int[] field2125;
   @ObfuscatedName("bq")
   static int[] field2133;
   @ObfuscatedName("r")
   int verticesCount = 0;
   @ObfuscatedName("u")
   int[] verticesX;
   @ObfuscatedName("b")
   int[] verticesY;
   @ObfuscatedName("j")
   int[] verticesZ;
   @ObfuscatedName("g")
   public int indicesCount = 0;
   @ObfuscatedName("i")
   int[] indices1;
   @ObfuscatedName("o")
   int[] indices2;
   @ObfuscatedName("n")
   int[] indices3;
   @ObfuscatedName("k")
   int[] faceColors1;
   @ObfuscatedName("a")
   int[] faceColors2;
   @ObfuscatedName("s")
   int[] faceColors3;
   @ObfuscatedName("l")
   byte[] faceRenderPriorities;
   @ObfuscatedName("t")
   byte[] faceAlphas;
   @ObfuscatedName("c")
   byte[] field2147;
   @ObfuscatedName("p")
   short[] faceTextures;
   @ObfuscatedName("d")
   byte field2134 = 0;
   @ObfuscatedName("y")
   int field2167 = 0;
   @ObfuscatedName("z")
   int[] field2123;
   @ObfuscatedName("w")
   int[] field2137;
   @ObfuscatedName("as")
   int[] field2138;
   @ObfuscatedName("ad")
   int[][] vertexLabels;
   @ObfuscatedName("ao")
   int[][] faceLabelsAlpha;
   @ObfuscatedName("am")
   int[][] field2141;
   @ObfuscatedName("av")
   int[][] field2142;
   @ObfuscatedName("au")
   public boolean isSingleTile = false;
   @ObfuscatedName("ar")
   int boundsType;
   @ObfuscatedName("at")
   int bottomY;
   @ObfuscatedName("ay")
   int xzRadius;
   @ObfuscatedName("an")
   int diameter;
   @ObfuscatedName("ab")
   int radius;
   @ObfuscatedName("al")
   HashMap aabb = new HashMap();
   @ObfuscatedName("bs")
   public byte overrideHue;
   @ObfuscatedName("bt")
   public byte overrideSaturation;
   @ObfuscatedName("bu")
   public byte overrideLuminance;
   @ObfuscatedName("bj")
   public byte overrideAmount;
   @ObfuscatedName("bb")
   public short field2180;

   static {
      field2154 = Rasterizer3D.Rasterizer3D_sine;
      field2174 = Rasterizer3D.Rasterizer3D_cosine;
      field2125 = Rasterizer3D.Rasterizer3D_colorPalette;
      field2133 = Rasterizer3D.field1980;
   }

   Model() {
   }

   @ObfuscatedSignature(
      descriptor = "([Lhh;I)V"
   )
   public Model(Model[] var1, int var2) {
      boolean var3 = false;
      boolean var4 = false;
      boolean var5 = false;
      boolean var6 = false;
      this.verticesCount = 0;
      this.indicesCount = 0;
      this.field2167 = 0;
      this.field2134 = -1;

      int var7;
      Model var8;
      for(var7 = 0; var7 < var2; ++var7) {
         var8 = var1[var7];
         if (var8 != null) {
            this.verticesCount += var8.verticesCount;
            this.indicesCount += var8.indicesCount;
            this.field2167 += var8.field2167;
            if (var8.faceRenderPriorities != null) {
               var3 = true;
            } else {
               if (this.field2134 == -1) {
                  this.field2134 = var8.field2134;
               }

               if (this.field2134 != var8.field2134) {
                  var3 = true;
               }
            }

            var4 |= var8.faceAlphas != null;
            var5 |= var8.faceTextures != null;
            var6 |= var8.field2147 != null;
         }
      }

      this.verticesX = new int[this.verticesCount];
      this.verticesY = new int[this.verticesCount];
      this.verticesZ = new int[this.verticesCount];
      this.indices1 = new int[this.indicesCount];
      this.indices2 = new int[this.indicesCount];
      this.indices3 = new int[this.indicesCount];
      this.faceColors1 = new int[this.indicesCount];
      this.faceColors2 = new int[this.indicesCount];
      this.faceColors3 = new int[this.indicesCount];
      if (var3) {
         this.faceRenderPriorities = new byte[this.indicesCount];
      }

      if (var4) {
         this.faceAlphas = new byte[this.indicesCount];
      }

      if (var5) {
         this.faceTextures = new short[this.indicesCount];
      }

      if (var6) {
         this.field2147 = new byte[this.indicesCount];
      }

      if (this.field2167 > 0) {
         this.field2123 = new int[this.field2167];
         this.field2137 = new int[this.field2167];
         this.field2138 = new int[this.field2167];
      }

      this.verticesCount = 0;
      this.indicesCount = 0;
      this.field2167 = 0;

      for(var7 = 0; var7 < var2; ++var7) {
         var8 = var1[var7];
         if (var8 != null) {
            int var9;
            for(var9 = 0; var9 < var8.indicesCount; ++var9) {
               this.indices1[this.indicesCount] = this.verticesCount + var8.indices1[var9];
               this.indices2[this.indicesCount] = this.verticesCount + var8.indices2[var9];
               this.indices3[this.indicesCount] = this.verticesCount + var8.indices3[var9];
               this.faceColors1[this.indicesCount] = var8.faceColors1[var9];
               this.faceColors2[this.indicesCount] = var8.faceColors2[var9];
               this.faceColors3[this.indicesCount] = var8.faceColors3[var9];
               if (var3) {
                  if (var8.faceRenderPriorities != null) {
                     this.faceRenderPriorities[this.indicesCount] = var8.faceRenderPriorities[var9];
                  } else {
                     this.faceRenderPriorities[this.indicesCount] = var8.field2134;
                  }
               }

               if (var4 && var8.faceAlphas != null) {
                  this.faceAlphas[this.indicesCount] = var8.faceAlphas[var9];
               }

               if (var5) {
                  if (var8.faceTextures != null) {
                     this.faceTextures[this.indicesCount] = var8.faceTextures[var9];
                  } else {
                     this.faceTextures[this.indicesCount] = -1;
                  }
               }

               if (var6) {
                  if (var8.field2147 != null && var8.field2147[var9] != -1) {
                     this.field2147[this.indicesCount] = (byte)(this.field2167 + var8.field2147[var9]);
                  } else {
                     this.field2147[this.indicesCount] = -1;
                  }
               }

               ++this.indicesCount;
            }

            for(var9 = 0; var9 < var8.field2167; ++var9) {
               this.field2123[this.field2167] = this.verticesCount + var8.field2123[var9];
               this.field2137[this.field2167] = this.verticesCount + var8.field2137[var9];
               this.field2138[this.field2167] = this.verticesCount + var8.field2138[var9];
               ++this.field2167;
            }

            for(var9 = 0; var9 < var8.verticesCount; ++var9) {
               this.verticesX[this.verticesCount] = var8.verticesX[var9];
               this.verticesY[this.verticesCount] = var8.verticesY[var9];
               this.verticesZ[this.verticesCount] = var8.verticesZ[var9];
               ++this.verticesCount;
            }
         }
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "([[IIIIZI)Lhh;"
   )
   public Model contourGround(int[][] var1, int var2, int var3, int var4, boolean var5, int var6) {
      this.calculateBoundsCylinder();
      int var7 = var2 - this.xzRadius;
      int var8 = var2 + this.xzRadius;
      int var9 = var4 - this.xzRadius;
      int var10 = var4 + this.xzRadius;
      if (var7 >= 0 && var8 + 128 >> 7 < var1.length && var9 >= 0 && var10 + 128 >> 7 < var1[0].length) {
         var7 >>= 7;
         var8 = var8 + 127 >> 7;
         var9 >>= 7;
         var10 = var10 + 127 >> 7;
         if (var3 == var1[var7][var9] && var3 == var1[var8][var9] && var3 == var1[var7][var10] && var3 == var1[var8][var10]) {
            return this;
         } else {
            Model var11;
            if (var5) {
               var11 = new Model();
               var11.verticesCount = this.verticesCount;
               var11.indicesCount = this.indicesCount;
               var11.field2167 = this.field2167;
               var11.verticesX = this.verticesX;
               var11.verticesZ = this.verticesZ;
               var11.indices1 = this.indices1;
               var11.indices2 = this.indices2;
               var11.indices3 = this.indices3;
               var11.faceColors1 = this.faceColors1;
               var11.faceColors2 = this.faceColors2;
               var11.faceColors3 = this.faceColors3;
               var11.faceRenderPriorities = this.faceRenderPriorities;
               var11.faceAlphas = this.faceAlphas;
               var11.field2147 = this.field2147;
               var11.faceTextures = this.faceTextures;
               var11.field2134 = this.field2134;
               var11.field2123 = this.field2123;
               var11.field2137 = this.field2137;
               var11.field2138 = this.field2138;
               var11.vertexLabels = this.vertexLabels;
               var11.faceLabelsAlpha = this.faceLabelsAlpha;
               var11.isSingleTile = this.isSingleTile;
               var11.verticesY = new int[var11.verticesCount];
            } else {
               var11 = this;
            }

            int var12;
            int var13;
            int var14;
            int var15;
            int var16;
            int var17;
            int var18;
            int var19;
            int var20;
            int var21;
            if (var6 == 0) {
               for(var12 = 0; var12 < var11.verticesCount; ++var12) {
                  var13 = var2 + this.verticesX[var12];
                  var14 = var4 + this.verticesZ[var12];
                  var15 = var13 & 127;
                  var16 = var14 & 127;
                  var17 = var13 >> 7;
                  var18 = var14 >> 7;
                  var19 = var1[var17][var18] * (128 - var15) + var1[var17 + 1][var18] * var15 >> 7;
                  var20 = var1[var17][var18 + 1] * (128 - var15) + var15 * var1[var17 + 1][var18 + 1] >> 7;
                  var21 = var19 * (128 - var16) + var20 * var16 >> 7;
                  var11.verticesY[var12] = var21 + this.verticesY[var12] - var3;
               }
            } else {
               for(var12 = 0; var12 < var11.verticesCount; ++var12) {
                  var13 = (-this.verticesY[var12] << 16) / super.height;
                  if (var13 < var6) {
                     var14 = var2 + this.verticesX[var12];
                     var15 = var4 + this.verticesZ[var12];
                     var16 = var14 & 127;
                     var17 = var15 & 127;
                     var18 = var14 >> 7;
                     var19 = var15 >> 7;
                     var20 = var1[var18][var19] * (128 - var16) + var1[var18 + 1][var19] * var16 >> 7;
                     var21 = var1[var18][var19 + 1] * (128 - var16) + var16 * var1[var18 + 1][var19 + 1] >> 7;
                     int var22 = var20 * (128 - var17) + var21 * var17 >> 7;
                     var11.verticesY[var12] = (var6 - var13) * (var22 - var3) / var6 + this.verticesY[var12];
                  }
               }
            }

            var11.resetBounds();
            return var11;
         }
      } else {
         return this;
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      descriptor = "(Z)Lhh;"
   )
   public Model toSharedSequenceModel(boolean var1) {
      if (!var1 && Model_sharedSequenceModelFaceAlphas.length < this.indicesCount) {
         Model_sharedSequenceModelFaceAlphas = new byte[this.indicesCount + 100];
      }

      return this.buildSharedModel(var1, Model_sharedSequenceModel, Model_sharedSequenceModelFaceAlphas);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      descriptor = "(Z)Lhh;"
   )
   public Model toSharedSpotAnimationModel(boolean var1) {
      if (!var1 && Model_sharedSpotAnimationModelFaceAlphas.length < this.indicesCount) {
         Model_sharedSpotAnimationModelFaceAlphas = new byte[this.indicesCount + 100];
      }

      return this.buildSharedModel(var1, Model_sharedSpotAnimationModel, Model_sharedSpotAnimationModelFaceAlphas);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "(ZLhh;[B)Lhh;"
   )
   Model buildSharedModel(boolean var1, Model var2, byte[] var3) {
      var2.verticesCount = this.verticesCount;
      var2.indicesCount = this.indicesCount;
      var2.field2167 = this.field2167;
      if (var2.verticesX == null || var2.verticesX.length < this.verticesCount) {
         var2.verticesX = new int[this.verticesCount + 100];
         var2.verticesY = new int[this.verticesCount + 100];
         var2.verticesZ = new int[this.verticesCount + 100];
      }

      int var4;
      for(var4 = 0; var4 < this.verticesCount; ++var4) {
         var2.verticesX[var4] = this.verticesX[var4];
         var2.verticesY[var4] = this.verticesY[var4];
         var2.verticesZ[var4] = this.verticesZ[var4];
      }

      if (var1) {
         var2.faceAlphas = this.faceAlphas;
      } else {
         var2.faceAlphas = var3;
         if (this.faceAlphas == null) {
            for(var4 = 0; var4 < this.indicesCount; ++var4) {
               var2.faceAlphas[var4] = 0;
            }
         } else {
            for(var4 = 0; var4 < this.indicesCount; ++var4) {
               var2.faceAlphas[var4] = this.faceAlphas[var4];
            }
         }
      }

      var2.indices1 = this.indices1;
      var2.indices2 = this.indices2;
      var2.indices3 = this.indices3;
      var2.faceColors1 = this.faceColors1;
      var2.faceColors2 = this.faceColors2;
      var2.faceColors3 = this.faceColors3;
      var2.faceRenderPriorities = this.faceRenderPriorities;
      var2.field2147 = this.field2147;
      var2.faceTextures = this.faceTextures;
      var2.field2134 = this.field2134;
      var2.field2123 = this.field2123;
      var2.field2137 = this.field2137;
      var2.field2138 = this.field2138;
      var2.vertexLabels = this.vertexLabels;
      var2.faceLabelsAlpha = this.faceLabelsAlpha;
      var2.field2141 = this.field2141;
      var2.field2142 = this.field2142;
      var2.isSingleTile = this.isSingleTile;
      var2.resetBounds();
      var2.overrideAmount = 0;
      return var2;
   }

   @ObfuscatedName("r")
   void calculateBoundingBox(int var1) {
      if (!this.aabb.containsKey(var1)) {
         int var2 = 0;
         int var3 = 0;
         int var4 = 0;
         int var5 = 0;
         int var6 = 0;
         int var7 = 0;
         int var8 = field2174[var1];
         int var9 = field2154[var1];

         for(int var10 = 0; var10 < this.verticesCount; ++var10) {
            int var11 = Rasterizer3D.method1149(this.verticesX[var10], this.verticesZ[var10], var8, var9);
            int var12 = this.verticesY[var10];
            int var13 = Rasterizer3D.method1159(this.verticesX[var10], this.verticesZ[var10], var8, var9);
            if (var11 < var2) {
               var2 = var11;
            }

            if (var11 > var5) {
               var5 = var11;
            }

            if (var12 < var3) {
               var3 = var12;
            }

            if (var12 > var6) {
               var6 = var12;
            }

            if (var13 < var4) {
               var4 = var13;
            }

            if (var13 > var7) {
               var7 = var13;
            }
         }

         AABB var14 = new AABB((var5 + var2) / 2, (var6 + var3) / 2, (var7 + var4) / 2, (var5 - var2 + 1) / 2, (var6 - var3 + 1) / 2, (var7 - var4 + 1) / 2);
         boolean var15 = true;
         if (var14.xMidOffset < 32) {
            var14.xMidOffset = 32;
         }

         if (var14.zMidOffset < 32) {
            var14.zMidOffset = 32;
         }

         if (this.isSingleTile) {
            boolean var16 = true;
            var14.xMidOffset += 8;
            var14.zMidOffset += 8;
         }

         this.aabb.put(var1, var14);
      }
   }

   @ObfuscatedName("u")
   public void calculateBoundsCylinder() {
      if (this.boundsType != 1) {
         this.boundsType = 1;
         super.height = 0;
         this.bottomY = 0;
         this.xzRadius = 0;

         for(int var1 = 0; var1 < this.verticesCount; ++var1) {
            int var2 = this.verticesX[var1];
            int var3 = this.verticesY[var1];
            int var4 = this.verticesZ[var1];
            if (-var3 > super.height) {
               super.height = -var3;
            }

            if (var3 > this.bottomY) {
               this.bottomY = var3;
            }

            int var5 = var2 * var2 + var4 * var4;
            if (var5 > this.xzRadius) {
               this.xzRadius = var5;
            }
         }

         this.xzRadius = (int)(Math.sqrt((double)this.xzRadius) + 0.99D);
         this.radius = (int)(Math.sqrt((double)(this.xzRadius * this.xzRadius + super.height * super.height)) + 0.99D);
         this.diameter = this.radius + (int)(Math.sqrt((double)(this.xzRadius * this.xzRadius + this.bottomY * this.bottomY)) + 0.99D);
      }
   }

   @ObfuscatedName("b")
   void method1255() {
      if (this.boundsType != 2) {
         this.boundsType = 2;
         this.xzRadius = 0;

         for(int var1 = 0; var1 < this.verticesCount; ++var1) {
            int var2 = this.verticesX[var1];
            int var3 = this.verticesY[var1];
            int var4 = this.verticesZ[var1];
            int var5 = var2 * var2 + var4 * var4 + var3 * var3;
            if (var5 > this.xzRadius) {
               this.xzRadius = var5;
            }
         }

         this.xzRadius = (int)(Math.sqrt((double)this.xzRadius) + 0.99D);
         this.radius = this.xzRadius;
         this.diameter = this.xzRadius + this.xzRadius;
      }
   }

   @ObfuscatedName("j")
   public int method1256() {
      this.calculateBoundsCylinder();
      return this.xzRadius;
   }

   @ObfuscatedName("g")
   public void resetBounds() {
      this.boundsType = 0;
      this.aabb.clear();
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      descriptor = "(Lha;I)V"
   )
   public void animate(Frames var1, int var2) {
      if (this.vertexLabels != null) {
         if (var2 != -1) {
            Animation var3 = var1.frames[var2];
            Skeleton var4 = var3.skeleton;
            Model_transformTempX = 0;
            Model_transformTempY = 0;
            Model_transformTempZ = 0;

            for(int var5 = 0; var5 < var3.transformCount; ++var5) {
               int var6 = var3.transformSkeletonLabels[var5];
               this.transform(var4.transformTypes[var6], var4.labels[var6], var3.transformXs[var5], var3.transformYs[var5], var3.transformZs[var5]);
            }

            this.resetBounds();
         }
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      descriptor = "(Lew;I)V"
   )
   public void method1274(class130 var1, int var2) {
      Skeleton var3 = var1.field1257;
      class213 var4 = var3.method1175();
      if (var4 != null) {
         var3.method1175().method1171(var1, var2);
         this.method1259(var3.method1175(), var1.method722());
      }

      if (var1.method717()) {
         this.method1258(var1, var2);
      }

      this.resetBounds();
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      descriptor = "(Lew;I)V"
   )
   void method1258(class130 var1, int var2) {
      Skeleton var3 = var1.field1257;

      for(int var4 = 0; var4 < var3.count; ++var4) {
         int var5 = var3.transformTypes[var4];
         if (var5 == 5 && var1.field1258 != null && var1.field1258[var4] != null && var1.field1258[var4][0] != null && this.faceLabelsAlpha != null && this.faceAlphas != null) {
            class125 var6 = var1.field1258[var4][0];
            int[] var7 = var3.labels[var4];
            int var8 = var7.length;

            for(int var9 = 0; var9 < var8; ++var9) {
               int var10 = var7[var9];
               if (var10 < this.faceLabelsAlpha.length) {
                  int[] var11 = this.faceLabelsAlpha[var10];

                  for(int var12 = 0; var12 < var11.length; ++var12) {
                     int var13 = var11[var12];
                     int var14 = (int)((float)(this.faceAlphas[var13] & 255) + var6.method704(var2) * 255.0F);
                     if (var14 < 0) {
                        var14 = 0;
                     } else if (var14 > 255) {
                        var14 = 255;
                     }

                     this.faceAlphas[var13] = (byte)var14;
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      descriptor = "(Lhi;I)V"
   )
   void method1259(class213 var1, int var2) {
      this.method1271(var1, var2);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      descriptor = "(Lha;ILha;I[I)V"
   )
   public void animate2(Frames var1, int var2, Frames var3, int var4, int[] var5) {
      if (var2 != -1) {
         if (var5 != null && var4 != -1) {
            Animation var6 = var1.frames[var2];
            Animation var7 = var3.frames[var4];
            Skeleton var8 = var6.skeleton;
            Model_transformTempX = 0;
            Model_transformTempY = 0;
            Model_transformTempZ = 0;
            byte var9 = 0;
            int var13 = var9 + 1;
            int var10 = var5[var9];

            int var11;
            int var12;
            for(var11 = 0; var11 < var6.transformCount; ++var11) {
               for(var12 = var6.transformSkeletonLabels[var11]; var12 > var10; var10 = var5[var13++]) {
                  ;
               }

               if (var12 != var10 || var8.transformTypes[var12] == 0) {
                  this.transform(var8.transformTypes[var12], var8.labels[var12], var6.transformXs[var11], var6.transformYs[var11], var6.transformZs[var11]);
               }
            }

            Model_transformTempX = 0;
            Model_transformTempY = 0;
            Model_transformTempZ = 0;
            var9 = 0;
            var13 = var9 + 1;
            var10 = var5[var9];

            for(var11 = 0; var11 < var7.transformCount; ++var11) {
               for(var12 = var7.transformSkeletonLabels[var11]; var12 > var10; var10 = var5[var13++]) {
                  ;
               }

               if (var12 == var10 || var8.transformTypes[var12] == 0) {
                  this.transform(var8.transformTypes[var12], var8.labels[var12], var7.transformXs[var11], var7.transformYs[var11], var7.transformZs[var11]);
               }
            }

            this.resetBounds();
         } else {
            this.animate(var1, var2);
         }
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      descriptor = "(Lhn;Lew;I[ZZZ)V"
   )
   public void method1279(Skeleton var1, class130 var2, int var3, boolean[] var4, boolean var5, boolean var6) {
      class213 var7 = var1.method1175();
      if (var7 != null) {
         var7.method1173(var2, var3, var4, var5);
         if (var6) {
            this.method1259(var7, var2.method722());
         }
      }

      if (!var5 && var2.method717()) {
         this.method1258(var2, var3);
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      descriptor = "(Lha;I[IZ)V"
   )
   public void method1261(Frames var1, int var2, int[] var3, boolean var4) {
      if (var3 == null) {
         this.animate(var1, var2);
      } else {
         Animation var5 = var1.frames[var2];
         Skeleton var6 = var5.skeleton;
         byte var7 = 0;
         int var11 = var7 + 1;
         int var8 = var3[var7];
         Model_transformTempX = 0;
         Model_transformTempY = 0;
         Model_transformTempZ = 0;

         for(int var9 = 0; var9 < var5.transformCount; ++var9) {
            int var10;
            for(var10 = var5.transformSkeletonLabels[var9]; var10 > var8; var8 = var3[var11++]) {
               ;
            }

            if (var4) {
               if (var10 == var8 || var6.transformTypes[var10] == 0) {
                  this.transform(var6.transformTypes[var10], var6.labels[var10], var5.transformXs[var9], var5.transformYs[var9], var5.transformZs[var9]);
               }
            } else if (var10 != var8 || var6.transformTypes[var10] == 0) {
               this.transform(var6.transformTypes[var10], var6.labels[var10], var5.transformXs[var9], var5.transformYs[var9], var5.transformZs[var9]);
            }
         }

      }
   }

   @ObfuscatedName("t")
   void transform(int var1, int[] var2, int var3, int var4, int var5) {
      int var6 = var2.length;
      int var7;
      int var8;
      int var11;
      int var12;
      if (var1 == 0) {
         var7 = 0;
         Model_transformTempX = 0;
         Model_transformTempY = 0;
         Model_transformTempZ = 0;

         for(var8 = 0; var8 < var6; ++var8) {
            int var9 = var2[var8];
            if (var9 < this.vertexLabels.length) {
               int[] var10 = this.vertexLabels[var9];

               for(var11 = 0; var11 < var10.length; ++var11) {
                  var12 = var10[var11];
                  Model_transformTempX += this.verticesX[var12];
                  Model_transformTempY += this.verticesY[var12];
                  Model_transformTempZ += this.verticesZ[var12];
                  ++var7;
               }
            }
         }

         if (var7 > 0) {
            Model_transformTempX = var3 + Model_transformTempX / var7;
            Model_transformTempY = var4 + Model_transformTempY / var7;
            Model_transformTempZ = var5 + Model_transformTempZ / var7;
         } else {
            Model_transformTempX = var3;
            Model_transformTempY = var4;
            Model_transformTempZ = var5;
         }

      } else {
         int[] var18;
         int var19;
         if (var1 == 1) {
            for(var7 = 0; var7 < var6; ++var7) {
               var8 = var2[var7];
               if (var8 < this.vertexLabels.length) {
                  var18 = this.vertexLabels[var8];

                  for(var19 = 0; var19 < var18.length; ++var19) {
                     var11 = var18[var19];
                     this.verticesX[var11] += var3;
                     this.verticesY[var11] += var4;
                     this.verticesZ[var11] += var5;
                  }
               }
            }

         } else if (var1 == 2) {
            for(var7 = 0; var7 < var6; ++var7) {
               var8 = var2[var7];
               if (var8 < this.vertexLabels.length) {
                  var18 = this.vertexLabels[var8];

                  for(var19 = 0; var19 < var18.length; ++var19) {
                     var11 = var18[var19];
                     this.verticesX[var11] -= Model_transformTempX;
                     this.verticesY[var11] -= Model_transformTempY;
                     this.verticesZ[var11] -= Model_transformTempZ;
                     var12 = (var3 & 255) * 8;
                     int var13 = (var4 & 255) * 8;
                     int var14 = (var5 & 255) * 8;
                     int var15;
                     int var16;
                     int var17;
                     if (var14 != 0) {
                        var15 = field2154[var14];
                        var16 = field2174[var14];
                        var17 = var15 * this.verticesY[var11] + var16 * this.verticesX[var11] >> 16;
                        this.verticesY[var11] = var16 * this.verticesY[var11] - var15 * this.verticesX[var11] >> 16;
                        this.verticesX[var11] = var17;
                     }

                     if (var12 != 0) {
                        var15 = field2154[var12];
                        var16 = field2174[var12];
                        var17 = var16 * this.verticesY[var11] - var15 * this.verticesZ[var11] >> 16;
                        this.verticesZ[var11] = var15 * this.verticesY[var11] + var16 * this.verticesZ[var11] >> 16;
                        this.verticesY[var11] = var17;
                     }

                     if (var13 != 0) {
                        var15 = field2154[var13];
                        var16 = field2174[var13];
                        var17 = var15 * this.verticesZ[var11] + var16 * this.verticesX[var11] >> 16;
                        this.verticesZ[var11] = var16 * this.verticesZ[var11] - var15 * this.verticesX[var11] >> 16;
                        this.verticesX[var11] = var17;
                     }

                     this.verticesX[var11] += Model_transformTempX;
                     this.verticesY[var11] += Model_transformTempY;
                     this.verticesZ[var11] += Model_transformTempZ;
                  }
               }
            }

         } else if (var1 == 3) {
            for(var7 = 0; var7 < var6; ++var7) {
               var8 = var2[var7];
               if (var8 < this.vertexLabels.length) {
                  var18 = this.vertexLabels[var8];

                  for(var19 = 0; var19 < var18.length; ++var19) {
                     var11 = var18[var19];
                     this.verticesX[var11] -= Model_transformTempX;
                     this.verticesY[var11] -= Model_transformTempY;
                     this.verticesZ[var11] -= Model_transformTempZ;
                     this.verticesX[var11] = var3 * this.verticesX[var11] / 128;
                     this.verticesY[var11] = var4 * this.verticesY[var11] / 128;
                     this.verticesZ[var11] = var5 * this.verticesZ[var11] / 128;
                     this.verticesX[var11] += Model_transformTempX;
                     this.verticesY[var11] += Model_transformTempY;
                     this.verticesZ[var11] += Model_transformTempZ;
                  }
               }
            }

         } else if (var1 == 5) {
            if (this.faceLabelsAlpha != null && this.faceAlphas != null) {
               for(var7 = 0; var7 < var6; ++var7) {
                  var8 = var2[var7];
                  if (var8 < this.faceLabelsAlpha.length) {
                     var18 = this.faceLabelsAlpha[var8];

                     for(var19 = 0; var19 < var18.length; ++var19) {
                        var11 = var18[var19];
                        var12 = (this.faceAlphas[var11] & 255) + var3 * 8;
                        if (var12 < 0) {
                           var12 = 0;
                        } else if (var12 > 255) {
                           var12 = 255;
                        }

                        this.faceAlphas[var11] = (byte)var12;
                     }
                  }
               }
            }

         }
      }
   }

   @ObfuscatedName("c")
   public void rotateY90Ccw() {
      for(int var1 = 0; var1 < this.verticesCount; ++var1) {
         int var2 = this.verticesX[var1];
         this.verticesX[var1] = this.verticesZ[var1];
         this.verticesZ[var1] = -var2;
      }

      this.resetBounds();
   }

   @ObfuscatedName("p")
   public void rotateY180() {
      for(int var1 = 0; var1 < this.verticesCount; ++var1) {
         this.verticesX[var1] = -this.verticesX[var1];
         this.verticesZ[var1] = -this.verticesZ[var1];
      }

      this.resetBounds();
   }

   @ObfuscatedName("d")
   public void rotateY270Ccw() {
      for(int var1 = 0; var1 < this.verticesCount; ++var1) {
         int var2 = this.verticesZ[var1];
         this.verticesZ[var1] = this.verticesX[var1];
         this.verticesX[var1] = -var2;
      }

      this.resetBounds();
   }

   @ObfuscatedName("y")
   public void rotateZ(int var1) {
      int var2 = field2154[var1];
      int var3 = field2174[var1];

      for(int var4 = 0; var4 < this.verticesCount; ++var4) {
         int var5 = var3 * this.verticesY[var4] - var2 * this.verticesZ[var4] >> 16;
         this.verticesZ[var4] = var2 * this.verticesY[var4] + var3 * this.verticesZ[var4] >> 16;
         this.verticesY[var4] = var5;
      }

      this.resetBounds();
   }

   @ObfuscatedName("z")
   public void offsetBy(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.verticesCount; ++var4) {
         this.verticesX[var4] += var1;
         this.verticesY[var4] += var2;
         this.verticesZ[var4] += var3;
      }

      this.resetBounds();
   }

   @ObfuscatedName("w")
   public void scale(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.verticesCount; ++var4) {
         this.verticesX[var4] = this.verticesX[var4] * var1 / 128;
         this.verticesY[var4] = var2 * this.verticesY[var4] / 128;
         this.verticesZ[var4] = var3 * this.verticesZ[var4] / 128;
      }

      this.resetBounds();
   }

   @ObfuscatedName("as")
   public final void method1265(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      if (this.boundsType != 2 && this.boundsType != 1) {
         this.method1255();
      }

      int var8 = Rasterizer3D.Rasterizer3D_clipMidX;
      int var9 = Rasterizer3D.Rasterizer3D_clipMidY;
      int var10 = field2154[var1];
      int var11 = field2174[var1];
      int var12 = field2154[var2];
      int var13 = field2174[var2];
      int var14 = field2154[var3];
      int var15 = field2174[var3];
      int var16 = field2154[var4];
      int var17 = field2174[var4];
      int var18 = var16 * var6 + var17 * var7 >> 16;

      for(int var19 = 0; var19 < this.verticesCount; ++var19) {
         int var20 = this.verticesX[var19];
         int var21 = this.verticesY[var19];
         int var22 = this.verticesZ[var19];
         int var23;
         if (var3 != 0) {
            var23 = var21 * var14 + var20 * var15 >> 16;
            var21 = var21 * var15 - var20 * var14 >> 16;
            var20 = var23;
         }

         if (var1 != 0) {
            var23 = var21 * var11 - var22 * var10 >> 16;
            var22 = var21 * var10 + var22 * var11 >> 16;
            var21 = var23;
         }

         if (var2 != 0) {
            var23 = var22 * var12 + var20 * var13 >> 16;
            var22 = var22 * var13 - var20 * var12 >> 16;
            var20 = var23;
         }

         var20 += var5;
         var21 += var6;
         var22 += var7;
         var23 = var21 * var17 - var22 * var16 >> 16;
         var22 = var21 * var16 + var22 * var17 >> 16;
         field2120[var19] = var22 - var18;
         modelViewportXs[var19] = var20 * Rasterizer3D.Rasterizer3D_zoom / var22 + var8;
         modelViewportYs[var19] = var23 * Rasterizer3D.Rasterizer3D_zoom / var22 + var9;
         if (this.field2167 > 0) {
            field2155[var19] = var20;
            field2156[var19] = var23;
            field2121[var19] = var22;
         }
      }

      try {
         this.draw0(false, false, false, 0L);
      } catch (Exception var25) {
         ;
      }

   }

   @ObfuscatedName("ad")
   public final void method1272(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      if (this.boundsType != 2 && this.boundsType != 1) {
         this.method1255();
      }

      int var9 = Rasterizer3D.Rasterizer3D_clipMidX;
      int var10 = Rasterizer3D.Rasterizer3D_clipMidY;
      int var11 = field2154[var1];
      int var12 = field2174[var1];
      int var13 = field2154[var2];
      int var14 = field2174[var2];
      int var15 = field2154[var3];
      int var16 = field2174[var3];
      int var17 = field2154[var4];
      int var18 = field2174[var4];
      int var19 = var17 * var6 + var18 * var7 >> 16;

      for(int var20 = 0; var20 < this.verticesCount; ++var20) {
         int var21 = this.verticesX[var20];
         int var22 = this.verticesY[var20];
         int var23 = this.verticesZ[var20];
         int var24;
         if (var3 != 0) {
            var24 = var22 * var15 + var21 * var16 >> 16;
            var22 = var22 * var16 - var21 * var15 >> 16;
            var21 = var24;
         }

         if (var1 != 0) {
            var24 = var22 * var12 - var23 * var11 >> 16;
            var23 = var22 * var11 + var23 * var12 >> 16;
            var22 = var24;
         }

         if (var2 != 0) {
            var24 = var23 * var13 + var21 * var14 >> 16;
            var23 = var23 * var14 - var21 * var13 >> 16;
            var21 = var24;
         }

         var21 += var5;
         var22 += var6;
         var23 += var7;
         var24 = var22 * var18 - var23 * var17 >> 16;
         var23 = var22 * var17 + var23 * var18 >> 16;
         field2120[var20] = var23 - var19;
         modelViewportXs[var20] = var9 + var21 * Rasterizer3D.Rasterizer3D_zoom / var8;
         modelViewportYs[var20] = var10 + var24 * Rasterizer3D.Rasterizer3D_zoom / var8;
         if (this.field2167 > 0) {
            field2155[var20] = var21;
            field2156[var20] = var24;
            field2121[var20] = var23;
         }
      }

      try {
         this.draw0(false, false, false, 0L);
      } catch (Exception var26) {
         ;
      }

   }

   @ObfuscatedName("ao")
   final void draw0(boolean var1, boolean var2, boolean var3, long var4) {
      if (this.diameter < 6000) {
         int var6;
         for(var6 = 0; var6 < this.diameter; ++var6) {
            field2165[var6] = 0;
         }

         var6 = var3 ? 20 : 5;

         int var8;
         int var9;
         int var10;
         int var11;
         int var12;
         int var13;
         int var15;
         int var16;
         int var18;
         for(char var7 = 0; var7 < this.indicesCount; ++var7) {
            if (this.faceColors3[var7] != -2) {
               var8 = this.indices1[var7];
               var9 = this.indices2[var7];
               var10 = this.indices3[var7];
               var11 = modelViewportXs[var8];
               var12 = modelViewportXs[var9];
               var13 = modelViewportXs[var10];
               int var14;
               if (var1 && (var11 == -5000 || var12 == -5000 || var13 == -5000)) {
                  var14 = field2155[var8];
                  var15 = field2155[var9];
                  var16 = field2155[var10];
                  int var17 = field2156[var8];
                  var18 = field2156[var9];
                  int var19 = field2156[var10];
                  int var20 = field2121[var8];
                  int var21 = field2121[var9];
                  int var22 = field2121[var10];
                  var14 -= var15;
                  var16 -= var15;
                  var17 -= var18;
                  var19 -= var18;
                  var20 -= var21;
                  var22 -= var21;
                  int var23 = var17 * var22 - var20 * var19;
                  int var24 = var20 * var16 - var14 * var22;
                  int var25 = var14 * var19 - var17 * var16;
                  if (var15 * var23 + var18 * var24 + var21 * var25 > 0) {
                     field2151[var7] = true;
                     int var26 = (field2120[var8] + field2120[var9] + field2120[var10]) / 3 + this.radius;
                     field2130[var26][field2165[var26]++] = var7;
                  }
               } else {
                  if (var2 && class140.method748(modelViewportYs[var8], modelViewportYs[var9], modelViewportYs[var10], var11, var12, var13, var6)) {
                     class338.method1834(var4);
                     var2 = false;
                  }

                  if ((var11 - var12) * (modelViewportYs[var10] - modelViewportYs[var9]) - (var13 - var12) * (modelViewportYs[var8] - modelViewportYs[var9]) > 0) {
                     field2151[var7] = false;
                     if (var11 >= 0 && var12 >= 0 && var13 >= 0 && var11 <= Rasterizer3D.Rasterizer3D_clipWidth && var12 <= Rasterizer3D.Rasterizer3D_clipWidth && var13 <= Rasterizer3D.Rasterizer3D_clipWidth) {
                        field2150[var7] = false;
                     } else {
                        field2150[var7] = true;
                     }

                     var14 = (field2120[var8] + field2120[var9] + field2120[var10]) / 3 + this.radius;
                     field2130[var14][field2165[var14]++] = var7;
                  }
               }
            }
         }

         char[] var27;
         int var31;
         char var32;
         if (this.faceRenderPriorities == null) {
            for(var31 = this.diameter - 1; var31 >= 0; --var31) {
               var32 = field2165[var31];
               if (var32 > 0) {
                  var27 = field2130[var31];

                  for(var10 = 0; var10 < var32; ++var10) {
                     this.drawFace(var27[var10]);
                  }
               }
            }

         } else {
            for(var31 = 0; var31 < 12; ++var31) {
               field2122[var31] = 0;
               field2135[var31] = 0;
            }

            for(var31 = this.diameter - 1; var31 >= 0; --var31) {
               var32 = field2165[var31];
               if (var32 > 0) {
                  var27 = field2130[var31];

                  for(var10 = 0; var10 < var32; ++var10) {
                     char var33 = var27[var10];
                     byte var34 = this.faceRenderPriorities[var33];
                     var13 = field2122[var34]++;
                     field2179[var34][var13] = var33;
                     if (var34 < 10) {
                        field2135[var34] += var31;
                     } else if (var34 == 10) {
                        field2163[var13] = var31;
                     } else {
                        field2164[var13] = var31;
                     }
                  }
               }
            }

            var31 = 0;
            if (field2122[1] > 0 || field2122[2] > 0) {
               var31 = (field2135[1] + field2135[2]) / (field2122[1] + field2122[2]);
            }

            var8 = 0;
            if (field2122[3] > 0 || field2122[4] > 0) {
               var8 = (field2135[3] + field2135[4]) / (field2122[3] + field2122[4]);
            }

            var9 = 0;
            if (field2122[6] > 0 || field2122[8] > 0) {
               var9 = (field2135[8] + field2135[6]) / (field2122[8] + field2122[6]);
            }

            var11 = 0;
            var12 = field2122[10];
            int[] var28 = field2179[10];
            int[] var29 = field2163;
            if (var11 == var12) {
               var11 = 0;
               var12 = field2122[11];
               var28 = field2179[11];
               var29 = field2164;
            }

            if (var11 < var12) {
               var10 = var29[var11];
            } else {
               var10 = -1000;
            }

            for(var15 = 0; var15 < 10; ++var15) {
               while(var15 == 0 && var10 > var31) {
                  this.drawFace(var28[var11++]);
                  if (var11 == var12 && var28 != field2179[11]) {
                     var11 = 0;
                     var12 = field2122[11];
                     var28 = field2179[11];
                     var29 = field2164;
                  }

                  if (var11 < var12) {
                     var10 = var29[var11];
                  } else {
                     var10 = -1000;
                  }
               }

               while(var15 == 3 && var10 > var8) {
                  this.drawFace(var28[var11++]);
                  if (var11 == var12 && var28 != field2179[11]) {
                     var11 = 0;
                     var12 = field2122[11];
                     var28 = field2179[11];
                     var29 = field2164;
                  }

                  if (var11 < var12) {
                     var10 = var29[var11];
                  } else {
                     var10 = -1000;
                  }
               }

               while(var15 == 5 && var10 > var9) {
                  this.drawFace(var28[var11++]);
                  if (var11 == var12 && var28 != field2179[11]) {
                     var11 = 0;
                     var12 = field2122[11];
                     var28 = field2179[11];
                     var29 = field2164;
                  }

                  if (var11 < var12) {
                     var10 = var29[var11];
                  } else {
                     var10 = -1000;
                  }
               }

               var16 = field2122[var15];
               int[] var30 = field2179[var15];

               for(var18 = 0; var18 < var16; ++var18) {
                  this.drawFace(var30[var18]);
               }
            }

            while(var10 != -1000) {
               this.drawFace(var28[var11++]);
               if (var11 == var12 && var28 != field2179[11]) {
                  var11 = 0;
                  var28 = field2179[11];
                  var12 = field2122[11];
                  var29 = field2164;
               }

               if (var11 < var12) {
                  var10 = var29[var11];
               } else {
                  var10 = -1000;
               }
            }

         }
      }
   }

   @ObfuscatedName("am")
   final void drawFace(int var1) {
      if (field2151[var1]) {
         this.method1251(var1);
      } else {
         int var2 = this.indices1[var1];
         int var3 = this.indices2[var1];
         int var4 = this.indices3[var1];
         Rasterizer3D.field1977 = field2150[var1];
         if (this.faceAlphas == null) {
            Rasterizer3D.Rasterizer3D_alpha = 0;
         } else {
            Rasterizer3D.Rasterizer3D_alpha = this.faceAlphas[var1] & 255;
         }

         this.method1277(var1, modelViewportYs[var2], modelViewportYs[var3], modelViewportYs[var4], modelViewportXs[var2], modelViewportXs[var3], modelViewportXs[var4], this.faceColors1[var1], this.faceColors2[var1], this.faceColors3[var1]);
      }
   }

   @ObfuscatedName("av")
   boolean method1278(int var1) {
      return this.overrideAmount > 0 && var1 < this.field2180;
   }

   @ObfuscatedName("au")
   final void method1277(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10) {
      if (this.faceTextures != null && this.faceTextures[var1] != -1) {
         int var12;
         int var13;
         int var15;
         if (this.field2147 != null && this.field2147[var1] != -1) {
            int var14 = this.field2147[var1] & 255;
            var15 = this.field2123[var14];
            var12 = this.field2137[var14];
            var13 = this.field2138[var14];
         } else {
            var15 = this.indices1[var1];
            var12 = this.indices2[var1];
            var13 = this.indices3[var1];
         }

         if (this.faceColors3[var1] == -1) {
            Rasterizer3D.method1155(var2, var3, var4, var5, var6, var7, var8, var8, var8, field2155[var15], field2155[var12], field2155[var13], field2156[var15], field2156[var12], field2156[var13], field2121[var15], field2121[var12], field2121[var13], this.faceTextures[var1]);
         } else {
            Rasterizer3D.method1155(var2, var3, var4, var5, var6, var7, var8, var9, var10, field2155[var15], field2155[var12], field2155[var13], field2156[var15], field2156[var12], field2156[var13], field2121[var15], field2121[var12], field2121[var13], this.faceTextures[var1]);
         }
      } else {
         boolean var11 = this.method1278(var1);
         if (this.faceColors3[var1] == -1 && var11) {
            Rasterizer3D.method1153(var2, var3, var4, var5, var6, var7, field2125[this.faceColors1[var1]], this.overrideHue, this.overrideSaturation, this.overrideLuminance, this.overrideAmount);
         } else if (this.faceColors3[var1] == -1) {
            Rasterizer3D.method1152(var2, var3, var4, var5, var6, var7, field2125[this.faceColors1[var1]]);
         } else if (var11) {
            Rasterizer3D.method1150(var2, var3, var4, var5, var6, var7, var8, var9, var10, this.overrideHue, this.overrideSaturation, this.overrideLuminance, this.overrideAmount);
         } else {
            Rasterizer3D.method1163(var2, var3, var4, var5, var6, var7, var8, var9, var10);
         }
      }

   }

   @ObfuscatedName("ar")
   final void method1251(int var1) {
      int var2 = Rasterizer3D.Rasterizer3D_clipMidX;
      int var3 = Rasterizer3D.Rasterizer3D_clipMidY;
      int var4 = 0;
      int var5 = this.indices1[var1];
      int var6 = this.indices2[var1];
      int var7 = this.indices3[var1];
      int var8 = field2121[var5];
      int var9 = field2121[var6];
      int var10 = field2121[var7];
      if (this.faceAlphas == null) {
         Rasterizer3D.Rasterizer3D_alpha = 0;
      } else {
         Rasterizer3D.Rasterizer3D_alpha = this.faceAlphas[var1] & 255;
      }

      int var11;
      int var12;
      int var13;
      int var14;
      if (var8 >= 50) {
         field2166[var4] = modelViewportXs[var5];
         field2112[var4] = modelViewportYs[var5];
         field2157[var4++] = this.faceColors1[var1];
      } else {
         var11 = field2155[var5];
         var12 = field2156[var5];
         var13 = this.faceColors1[var1];
         if (var10 >= 50) {
            var14 = field2133[var10 - var8] * (50 - var8);
            field2166[var4] = var2 + Rasterizer3D.Rasterizer3D_zoom * (var11 + ((field2155[var7] - var11) * var14 >> 16)) / 50;
            field2112[var4] = var3 + Rasterizer3D.Rasterizer3D_zoom * (var12 + ((field2156[var7] - var12) * var14 >> 16)) / 50;
            field2157[var4++] = var13 + ((this.faceColors3[var1] - var13) * var14 >> 16);
         }

         if (var9 >= 50) {
            var14 = field2133[var9 - var8] * (50 - var8);
            field2166[var4] = var2 + Rasterizer3D.Rasterizer3D_zoom * (var11 + ((field2155[var6] - var11) * var14 >> 16)) / 50;
            field2112[var4] = var3 + Rasterizer3D.Rasterizer3D_zoom * (var12 + ((field2156[var6] - var12) * var14 >> 16)) / 50;
            field2157[var4++] = var13 + ((this.faceColors2[var1] - var13) * var14 >> 16);
         }
      }

      if (var9 >= 50) {
         field2166[var4] = modelViewportXs[var6];
         field2112[var4] = modelViewportYs[var6];
         field2157[var4++] = this.faceColors2[var1];
      } else {
         var11 = field2155[var6];
         var12 = field2156[var6];
         var13 = this.faceColors2[var1];
         if (var8 >= 50) {
            var14 = field2133[var8 - var9] * (50 - var9);
            field2166[var4] = var2 + Rasterizer3D.Rasterizer3D_zoom * (var11 + ((field2155[var5] - var11) * var14 >> 16)) / 50;
            field2112[var4] = var3 + Rasterizer3D.Rasterizer3D_zoom * (var12 + ((field2156[var5] - var12) * var14 >> 16)) / 50;
            field2157[var4++] = var13 + ((this.faceColors1[var1] - var13) * var14 >> 16);
         }

         if (var10 >= 50) {
            var14 = field2133[var10 - var9] * (50 - var9);
            field2166[var4] = var2 + Rasterizer3D.Rasterizer3D_zoom * (var11 + ((field2155[var7] - var11) * var14 >> 16)) / 50;
            field2112[var4] = var3 + Rasterizer3D.Rasterizer3D_zoom * (var12 + ((field2156[var7] - var12) * var14 >> 16)) / 50;
            field2157[var4++] = var13 + ((this.faceColors3[var1] - var13) * var14 >> 16);
         }
      }

      if (var10 >= 50) {
         field2166[var4] = modelViewportXs[var7];
         field2112[var4] = modelViewportYs[var7];
         field2157[var4++] = this.faceColors3[var1];
      } else {
         var11 = field2155[var7];
         var12 = field2156[var7];
         var13 = this.faceColors3[var1];
         if (var9 >= 50) {
            var14 = field2133[var9 - var10] * (50 - var10);
            field2166[var4] = var2 + Rasterizer3D.Rasterizer3D_zoom * (var11 + ((field2155[var6] - var11) * var14 >> 16)) / 50;
            field2112[var4] = var3 + Rasterizer3D.Rasterizer3D_zoom * (var12 + ((field2156[var6] - var12) * var14 >> 16)) / 50;
            field2157[var4++] = var13 + ((this.faceColors2[var1] - var13) * var14 >> 16);
         }

         if (var8 >= 50) {
            var14 = field2133[var8 - var10] * (50 - var10);
            field2166[var4] = var2 + Rasterizer3D.Rasterizer3D_zoom * (var11 + ((field2155[var5] - var11) * var14 >> 16)) / 50;
            field2112[var4] = var3 + Rasterizer3D.Rasterizer3D_zoom * (var12 + ((field2156[var5] - var12) * var14 >> 16)) / 50;
            field2157[var4++] = var13 + ((this.faceColors1[var1] - var13) * var14 >> 16);
         }
      }

      var11 = field2166[0];
      var12 = field2166[1];
      var13 = field2166[2];
      var14 = field2112[0];
      int var15 = field2112[1];
      int var16 = field2112[2];
      Rasterizer3D.field1977 = false;
      if (var4 == 3) {
         if (var11 < 0 || var12 < 0 || var13 < 0 || var11 > Rasterizer3D.Rasterizer3D_clipWidth || var12 > Rasterizer3D.Rasterizer3D_clipWidth || var13 > Rasterizer3D.Rasterizer3D_clipWidth) {
            Rasterizer3D.field1977 = true;
         }

         this.method1277(var1, var14, var15, var16, var11, var12, var13, field2157[0], field2157[1], field2157[2]);
      }

      if (var4 == 4) {
         if (var11 < 0 || var12 < 0 || var13 < 0 || var11 > Rasterizer3D.Rasterizer3D_clipWidth || var12 > Rasterizer3D.Rasterizer3D_clipWidth || var13 > Rasterizer3D.Rasterizer3D_clipWidth || field2166[3] < 0 || field2166[3] > Rasterizer3D.Rasterizer3D_clipWidth) {
            Rasterizer3D.field1977 = true;
         }

         int var18;
         if (this.faceTextures != null && this.faceTextures[var1] != -1) {
            int var19;
            int var21;
            if (this.field2147 != null && this.field2147[var1] != -1) {
               int var20 = this.field2147[var1] & 255;
               var21 = this.field2123[var20];
               var18 = this.field2137[var20];
               var19 = this.field2138[var20];
            } else {
               var21 = var5;
               var18 = var6;
               var19 = var7;
            }

            short var22 = this.faceTextures[var1];
            if (this.faceColors3[var1] == -1) {
               Rasterizer3D.method1155(var14, var15, var16, var11, var12, var13, this.faceColors1[var1], this.faceColors1[var1], this.faceColors1[var1], field2155[var21], field2155[var18], field2155[var19], field2156[var21], field2156[var18], field2156[var19], field2121[var21], field2121[var18], field2121[var19], var22);
               Rasterizer3D.method1155(var14, var16, field2112[3], var11, var13, field2166[3], this.faceColors1[var1], this.faceColors1[var1], this.faceColors1[var1], field2155[var21], field2155[var18], field2155[var19], field2156[var21], field2156[var18], field2156[var19], field2121[var21], field2121[var18], field2121[var19], var22);
            } else {
               Rasterizer3D.method1155(var14, var15, var16, var11, var12, var13, field2157[0], field2157[1], field2157[2], field2155[var21], field2155[var18], field2155[var19], field2156[var21], field2156[var18], field2156[var19], field2121[var21], field2121[var18], field2121[var19], var22);
               Rasterizer3D.method1155(var14, var16, field2112[3], var11, var13, field2166[3], field2157[0], field2157[2], field2157[3], field2155[var21], field2155[var18], field2155[var19], field2156[var21], field2156[var18], field2156[var19], field2121[var21], field2121[var18], field2121[var19], var22);
            }
         } else {
            boolean var17 = this.method1278(var1);
            if (this.faceColors3[var1] == -1 && var17) {
               var18 = field2125[this.faceColors1[var1]];
               Rasterizer3D.method1153(var14, var15, var16, var11, var12, var13, var18, this.overrideHue, this.overrideSaturation, this.overrideLuminance, this.overrideAmount);
               Rasterizer3D.method1153(var14, var16, field2112[3], var11, var13, field2166[3], var18, this.overrideHue, this.overrideSaturation, this.overrideLuminance, this.overrideAmount);
            } else if (this.faceColors3[var1] == -1) {
               var18 = field2125[this.faceColors1[var1]];
               Rasterizer3D.method1152(var14, var15, var16, var11, var12, var13, var18);
               Rasterizer3D.method1152(var14, var16, field2112[3], var11, var13, field2166[3], var18);
            } else if (var17) {
               Rasterizer3D.method1150(var14, var15, var16, var11, var12, var13, field2157[0], field2157[1], field2157[2], this.overrideHue, this.overrideLuminance, this.overrideSaturation, this.overrideAmount);
               Rasterizer3D.method1150(var14, var16, field2112[3], var11, var13, field2166[3], field2157[0], field2157[2], field2157[3], this.overrideHue, this.overrideLuminance, this.overrideSaturation, this.overrideAmount);
            } else {
               Rasterizer3D.method1163(var14, var15, var16, var11, var12, var13, field2157[0], field2157[1], field2157[2]);
               Rasterizer3D.method1163(var14, var16, field2112[3], var11, var13, field2166[3], field2157[0], field2157[2], field2157[3]);
            }
         }
      }

   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      descriptor = "(ILoj;)V"
   )
   void method1269(int var1, class410 var2) {
      float var3 = (float)this.verticesX[var1];
      float var4 = (float)(-this.verticesY[var1]);
      float var5 = (float)(-this.verticesZ[var1]);
      float var6 = 1.0F;
      this.verticesX[var1] = (int)(var2.field3763[0] * var3 + var2.field3763[4] * var4 + var2.field3763[8] * var5 + var2.field3763[12] * var6);
      this.verticesY[var1] = -((int)(var2.field3763[1] * var3 + var2.field3763[5] * var4 + var2.field3763[9] * var5 + var2.field3763[13] * var6));
      this.verticesZ[var1] = -((int)(var2.field3763[2] * var3 + var2.field3763[6] * var4 + var2.field3763[10] * var5 + var2.field3763[14] * var6));
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      descriptor = "(Lhi;I)V"
   )
   void method1271(class213 var1, int var2) {
      if (this.field2141 != null) {
         for(int var3 = 0; var3 < this.verticesCount; ++var3) {
            int[] var4 = this.field2141[var3];
            if (var4 != null && var4.length != 0) {
               int[] var5 = this.field2142[var3];
               field2116.method2132();

               for(int var6 = 0; var6 < var4.length; ++var6) {
                  int var7 = var4[var6];
                  class123 var8 = var1.method1170(var7);
                  if (var8 != null) {
                     field2117.method2134((float)var5[var6] / 255.0F);
                     field2118.method2133(var8.method684(var2));
                     field2118.method2136(field2117);
                     field2116.method2143(field2118);
                  }
               }

               this.method1269(var3, field2116);
            }
         }

      }
   }

   @ObfuscatedName("dn")
   void draw(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, long var9) {
      if (this.boundsType != 1) {
         this.calculateBoundsCylinder();
      }

      this.calculateBoundingBox(var1);
      int var11 = var5 * var8 - var4 * var6 >> 16;
      int var12 = var2 * var7 + var3 * var11 >> 16;
      int var13 = var3 * this.xzRadius >> 16;
      int var14 = var12 + var13;
      if (var14 > 50 && var12 < 3500) {
         int var15 = var8 * var4 + var5 * var6 >> 16;
         int var16 = (var15 - this.xzRadius) * Rasterizer3D.Rasterizer3D_zoom;
         if (var16 / var14 < Rasterizer3D.Rasterizer3D_clipMidX2) {
            int var17 = (var15 + this.xzRadius) * Rasterizer3D.Rasterizer3D_zoom;
            if (var17 / var14 > Rasterizer3D.Rasterizer3D_clipNegativeMidX) {
               int var18 = var3 * var7 - var11 * var2 >> 16;
               int var19 = var2 * this.xzRadius >> 16;
               int var20 = (var3 * this.bottomY >> 16) + var19;
               int var21 = (var18 + var20) * Rasterizer3D.Rasterizer3D_zoom;
               if (var21 / var14 > Rasterizer3D.Rasterizer3D_clipNegativeMidY) {
                  int var22 = (var3 * super.height >> 16) + var19;
                  int var23 = (var18 - var22) * Rasterizer3D.Rasterizer3D_zoom;
                  if (var23 / var14 < Rasterizer3D.Rasterizer3D_clipMidY2) {
                     int var24 = var13 + (var2 * super.height >> 16);
                     boolean var25 = false;
                     boolean var26 = false;
                     if (var12 - var24 <= 50) {
                        var26 = true;
                     }

                     boolean var27 = var26 || this.field2167 > 0;
                     int var28 = ViewportMouse.ViewportMouse_x;
                     int var30 = ViewportMouse.ViewportMouse_y;
                     boolean var32 = WorldMapElement.method919();
                     boolean var33 = var9 != 0L && !class272.method1513(var9);
                     boolean var35 = false;
                     int var39;
                     int var40;
                     int var41;
                     int var42;
                     int var51;
                     int var55;
                     int var56;
                     int var57;
                     if (var33 && var32) {
                        boolean var36 = false;
                        if (field2172) {
                           boolean var37;
                           if (!WorldMapElement.method919()) {
                              var37 = false;
                           } else {
                              int var45;
                              int var46;
                              int var47;
                              int var48;
                              if (!ViewportMouse.ViewportMouse_false0) {
                                 var39 = Scene.Scene_cameraPitchSine;
                                 var40 = Scene.Scene_cameraPitchCosine;
                                 var41 = Scene.Scene_cameraYawSine;
                                 var42 = Scene.Scene_cameraYawCosine;
                                 byte var43 = 50;
                                 short var44 = 3500;
                                 var45 = (ViewportMouse.ViewportMouse_x - Rasterizer3D.Rasterizer3D_clipMidX) * var43 / Rasterizer3D.Rasterizer3D_zoom;
                                 var46 = (ViewportMouse.ViewportMouse_y - Rasterizer3D.Rasterizer3D_clipMidY) * var43 / Rasterizer3D.Rasterizer3D_zoom;
                                 var47 = (ViewportMouse.ViewportMouse_x - Rasterizer3D.Rasterizer3D_clipMidX) * var44 / Rasterizer3D.Rasterizer3D_zoom;
                                 var48 = (ViewportMouse.ViewportMouse_y - Rasterizer3D.Rasterizer3D_clipMidY) * var44 / Rasterizer3D.Rasterizer3D_zoom;
                                 int var49 = Rasterizer3D.method1158(var46, var43, var40, var39);
                                 var56 = Rasterizer3D.method1162(var46, var43, var40, var39);
                                 var46 = var49;
                                 var49 = Rasterizer3D.method1158(var48, var44, var40, var39);
                                 var57 = Rasterizer3D.method1162(var48, var44, var40, var39);
                                 var48 = var49;
                                 var49 = Rasterizer3D.method1160(var45, var56, var42, var41);
                                 var56 = Rasterizer3D.method1161(var45, var56, var42, var41);
                                 var45 = var49;
                                 var49 = Rasterizer3D.method1160(var47, var57, var42, var41);
                                 var57 = Rasterizer3D.method1161(var47, var57, var42, var41);
                                 class358.field3565 = (var49 + var45) / 2;
                                 ViewportMouse.field2185 = (var48 + var46) / 2;
                                 class133.field1285 = (var56 + var57) / 2;
                                 class299.field2804 = (var49 - var45) / 2;
                                 class32.field89 = (var48 - var46) / 2;
                                 ViewportMouse.field2186 = (var57 - var56) / 2;
                                 ViewportMouse.field2187 = Math.abs(class299.field2804);
                                 SoundCache.field219 = Math.abs(class32.field89);
                                 ViewportMouse.field2181 = Math.abs(ViewportMouse.field2186);
                              }

                              AABB var50 = (AABB)this.aabb.get(var1);
                              var40 = var50.xMid + var6;
                              var41 = var7 + var50.yMid;
                              var42 = var8 + var50.zMid;
                              var56 = var50.xMidOffset;
                              var57 = var50.yMidOffset;
                              var45 = var50.zMidOffset;
                              var46 = class358.field3565 - var40;
                              var47 = ViewportMouse.field2185 - var41;
                              var48 = class133.field1285 - var42;
                              if (Math.abs(var46) > var56 + ViewportMouse.field2187) {
                                 var37 = false;
                              } else if (Math.abs(var47) > var57 + SoundCache.field219) {
                                 var37 = false;
                              } else if (Math.abs(var48) > var45 + ViewportMouse.field2181) {
                                 var37 = false;
                              } else if (Math.abs(var48 * class32.field89 - var47 * ViewportMouse.field2186) > var45 * SoundCache.field219 + var57 * ViewportMouse.field2181) {
                                 var37 = false;
                              } else if (Math.abs(var46 * ViewportMouse.field2186 - var48 * class299.field2804) > var56 * ViewportMouse.field2181 + var45 * ViewportMouse.field2187) {
                                 var37 = false;
                              } else if (Math.abs(var47 * class299.field2804 - var46 * class32.field89) > var56 * SoundCache.field219 + var57 * ViewportMouse.field2187) {
                                 var37 = false;
                              } else {
                                 var37 = true;
                              }
                           }

                           var36 = var37;
                        } else {
                           var55 = var12 - var13;
                           if (var55 <= 50) {
                              var55 = 50;
                           }

                           if (var15 > 0) {
                              var16 /= var14;
                              var17 /= var55;
                           } else {
                              var17 /= var14;
                              var16 /= var55;
                           }

                           if (var18 > 0) {
                              var23 /= var14;
                              var21 /= var55;
                           } else {
                              var21 /= var14;
                              var23 /= var55;
                           }

                           var51 = var28 - Rasterizer3D.Rasterizer3D_clipMidX;
                           var39 = var30 - Rasterizer3D.Rasterizer3D_clipMidY;
                           if (var51 > var16 && var51 < var17 && var39 > var23 && var39 < var21) {
                              var36 = true;
                           }
                        }

                        if (var36) {
                           if (this.isSingleTile) {
                              class338.method1834(var9);
                           } else {
                              var35 = true;
                           }
                        }
                     }

                     int var54 = Rasterizer3D.Rasterizer3D_clipMidX;
                     var55 = Rasterizer3D.Rasterizer3D_clipMidY;
                     var51 = 0;
                     var39 = 0;
                     if (var1 != 0) {
                        var51 = field2154[var1];
                        var39 = field2174[var1];
                     }

                     for(var40 = 0; var40 < this.verticesCount; ++var40) {
                        var41 = this.verticesX[var40];
                        var42 = this.verticesY[var40];
                        var56 = this.verticesZ[var40];
                        if (var1 != 0) {
                           var57 = var56 * var51 + var41 * var39 >> 16;
                           var56 = var56 * var39 - var41 * var51 >> 16;
                           var41 = var57;
                        }

                        var41 += var6;
                        var42 += var7;
                        var56 += var8;
                        var57 = var56 * var4 + var5 * var41 >> 16;
                        var56 = var5 * var56 - var41 * var4 >> 16;
                        var41 = var57;
                        var57 = var3 * var42 - var56 * var2 >> 16;
                        var56 = var42 * var2 + var3 * var56 >> 16;
                        field2120[var40] = var56 - var12;
                        if (var56 >= 50) {
                           modelViewportXs[var40] = var41 * Rasterizer3D.Rasterizer3D_zoom / var56 + var54;
                           modelViewportYs[var40] = var57 * Rasterizer3D.Rasterizer3D_zoom / var56 + var55;
                        } else {
                           modelViewportXs[var40] = -5000;
                           var25 = true;
                        }

                        if (var27) {
                           field2155[var40] = var41;
                           field2156[var40] = var57;
                           field2121[var40] = var56;
                        }
                     }

                     try {
                        this.draw0(var25, var35, this.isSingleTile, var9);
                     } catch (Exception var53) {
                        ;
                     }

                  }
               }
            }
         }
      }
   }
}
