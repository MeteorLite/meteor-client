import java.util.Arrays;
import java.util.HashMap;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("it")
@Implements("Model")
public class Model extends Renderable {
    @ObfuscatedName("af")
    @ObfuscatedSignature(
            descriptor = "Lit;"
    )
    static Model Model_sharedSequenceModel = new Model();
    @ObfuscatedName("an")
    static byte[] Model_sharedSequenceModelFaceAlphas = new byte[1];
    @ObfuscatedName("aw")
    @ObfuscatedSignature(
            descriptor = "Lit;"
    )
    static Model Model_sharedSpotAnimationModel = new Model();
    @ObfuscatedName("ac")
    static byte[] Model_sharedSpotAnimationModelFaceAlphas = new byte[1];
   @ObfuscatedName("au")
   @ObfuscatedSignature(
      descriptor = "Lqj;"
   )
   static class425 field2134 = new class425();
   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "Lqj;"
   )
   static class425 field2135 = new class425();
   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      descriptor = "Lqj;"
   )
   static class425 field2136 = new class425();
   @ObfuscatedName("bs")
   static boolean[] field2168 = new boolean[6500];
   @ObfuscatedName("br")
   static boolean[] field2169 = new boolean[6500];
    @ObfuscatedName("bg")
    static int[] modelViewportXs = new int[6500];
    @ObfuscatedName("bu")
    static int[] modelViewportYs = new int[6500];
   @ObfuscatedName("bf")
   static float[] field2172 = new float[6500];
   @ObfuscatedName("bq")
   static int[] field2173 = new int[6500];
   @ObfuscatedName("ba")
   static int[] field2161 = new int[6500];
   @ObfuscatedName("bv")
   static int[] field2175 = new int[6500];
   @ObfuscatedName("bl")
   static int[] field2200 = new int[6500];
   @ObfuscatedName("bc")
   static char[] field2195 = new char[6000];
   @ObfuscatedName("bh")
   static char[][] field2178 = new char[6000][512];
   @ObfuscatedName("bw")
   static int[] field2179 = new int[12];
   @ObfuscatedName("ce")
   static int[][] field2145 = new int[12][2000];
   @ObfuscatedName("ci")
   static int[] field2181 = new int[2000];
   @ObfuscatedName("cs")
   static int[] field2182 = new int[2000];
   @ObfuscatedName("cc")
   static int[] field2183 = new int[12];
   @ObfuscatedName("cn")
   static int[] field2184 = new int[10];
   @ObfuscatedName("ca")
   static int[] field2185 = new int[10];
   @ObfuscatedName("cu")
   static int[] field2186 = new int[10];
   @ObfuscatedName("ck")
   static float[] field2150 = new float[10];
    @ObfuscatedName("cq")
    static int Model_transformTempX;
    @ObfuscatedName("cm")
    static int Model_transformTempY;
    @ObfuscatedName("cf")
    static int Model_transformTempZ;
   @ObfuscatedName("cl")
   static boolean field2180 = true;
   @ObfuscatedName("cy")
   static int[] field2192;
   @ObfuscatedName("cx")
   static int[] field2132;
   @ObfuscatedName("cv")
   static int[] field2140;
   @ObfuscatedName("cb")
   static int[] field2176;
   @ObfuscatedName("cw")
   static final float field2198;
    @ObfuscatedName("al")
    public int verticesCount = 0;
    @ObfuscatedName("at")
    int[] verticesX;
    @ObfuscatedName("aa")
    int[] verticesY;
    @ObfuscatedName("ay")
    int[] verticesZ;
    @ObfuscatedName("ao")
    public int indicesCount = 0;
    @ObfuscatedName("ax")
    int[] indices1;
    @ObfuscatedName("ai")
    int[] indices2;
    @ObfuscatedName("ag")
    int[] indices3;
    @ObfuscatedName("ah")
    int[] faceColors1;
    @ObfuscatedName("av")
    int[] faceColors2;
    @ObfuscatedName("ar")
    int[] faceColors3;
    @ObfuscatedName("am")
    byte[] faceRenderPriorities;
    @ObfuscatedName("as")
    byte[] faceAlphas;
   @ObfuscatedName("aj")
   byte[] field2154;
    @ObfuscatedName("ak")
    short[] faceTextures;
   @ObfuscatedName("az")
   public byte field2152 = 0;
   @ObfuscatedName("ad")
   public int field2153 = 0;
   @ObfuscatedName("ae")
   int[] field2199;
   @ObfuscatedName("ap")
   int[] field2155;
   @ObfuscatedName("by")
   int[] field2187;
    @ObfuscatedName("bb")
    int[][] vertexLabels;
    @ObfuscatedName("bi")
    int[][] faceLabelsAlpha;
   @ObfuscatedName("be")
   int[][] field2156;
   @ObfuscatedName("bk")
   int[][] field2160;
    @ObfuscatedName("bx")
    public boolean isSingleTile = false;
    @ObfuscatedName("bo")
    int boundsType;
    @ObfuscatedName("bz")
    int bottomY;
    @ObfuscatedName("bm")
    int xzRadius;
    @ObfuscatedName("bd")
    int diameter;
    @ObfuscatedName("bt")
    int radius;
    @ObfuscatedName("bj")
    HashMap aabb = new HashMap();
    @ObfuscatedName("cj")
    public byte overrideHue;
    @ObfuscatedName("ch")
    public byte overrideSaturation;
    @ObfuscatedName("ct")
    public byte overrideLuminance;
    @ObfuscatedName("cp")
    public byte overrideAmount;
   @ObfuscatedName("cd")
   public short field2196;

   static {
      field2192 = Rasterizer3D.Rasterizer3D_sine;
      field2132 = Rasterizer3D.Rasterizer3D_cosine;
      field2140 = Rasterizer3D.Rasterizer3D_colorPalette;
      field2176 = Rasterizer3D.field1993;
      field2198 = NPC.method609(50);
   }

   Model() {
   }

   public Model(int var1, int var2, int var3, byte var4) {
      this.method1339(var1, var2, var3);
      this.field2152 = var4;
      this.verticesCount = 0;
      this.indicesCount = 0;
      this.field2153 = 0;
   }

   @ObfuscatedSignature(
      descriptor = "([Lit;I)V"
   )
   public Model(Model[] var1, int var2) {
      this.verticesCount = 0;
      this.indicesCount = 0;
      this.field2153 = 0;
      this.field2152 = -1;

      int var3;
      for(var3 = 0; var3 < var2; ++var3) {
         Model var4 = var1[var3];
         if (var4 != null) {
            this.verticesCount += var4.verticesCount;
            this.indicesCount += var4.indicesCount;
            this.field2153 += var4.field2153;
            if (this.field2152 == -1) {
               this.field2152 = var4.field2152;
            }
         }
      }

      this.method1339(this.verticesCount, this.indicesCount, this.field2153);
      this.verticesCount = 0;
      this.indicesCount = 0;
      this.field2153 = 0;

      for(var3 = 0; var3 < var2; ++var3) {
         this.method1342(var1[var3]);
      }

   }

   @ObfuscatedName("af")
   void method1339(int var1, int var2, int var3) {
      this.verticesX = new int[var1];
      this.verticesY = new int[var1];
      this.verticesZ = new int[var1];
      this.indices1 = new int[var2];
      this.indices2 = new int[var2];
      this.indices3 = new int[var2];
      this.faceColors1 = new int[var2];
      this.faceColors2 = new int[var2];
      this.faceColors3 = new int[var2];
      if (var3 > 0) {
         this.field2199 = new int[var3];
         this.field2155 = new int[var3];
         this.field2187 = new int[var3];
      }

   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      descriptor = "(Lit;)V"
   )
   void method1310(Model var1) {
      int var2 = this.indices1.length;
      if (this.faceRenderPriorities == null && (var1.faceRenderPriorities != null || this.field2152 != var1.field2152)) {
         this.faceRenderPriorities = new byte[var2];
         Arrays.fill(this.faceRenderPriorities, this.field2152);
      }

      if (this.faceAlphas == null && var1.faceAlphas != null) {
         this.faceAlphas = new byte[var2];
         Arrays.fill(this.faceAlphas, (byte)0);
      }

      if (this.faceTextures == null && var1.faceTextures != null) {
         this.faceTextures = new short[var2];
         Arrays.fill(this.faceTextures, (short)-1);
      }

      if (this.field2154 == null && var1.field2154 != null) {
         this.field2154 = new byte[var2];
         Arrays.fill(this.field2154, (byte)-1);
      }

   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "(Lit;)V"
   )
   public void method1342(Model var1) {
      if (var1 != null) {
         this.method1310(var1);

         int var2;
         for(var2 = 0; var2 < var1.indicesCount; ++var2) {
            this.indices1[this.indicesCount] = this.verticesCount + var1.indices1[var2];
            this.indices2[this.indicesCount] = this.verticesCount + var1.indices2[var2];
            this.indices3[this.indicesCount] = this.verticesCount + var1.indices3[var2];
            this.faceColors1[this.indicesCount] = var1.faceColors1[var2];
            this.faceColors2[this.indicesCount] = var1.faceColors2[var2];
            this.faceColors3[this.indicesCount] = var1.faceColors3[var2];
            if (this.faceRenderPriorities != null) {
               this.faceRenderPriorities[this.indicesCount] = var1.faceRenderPriorities != null ? var1.faceRenderPriorities[var2] : var1.field2152;
            }

            if (this.faceAlphas != null && var1.faceAlphas != null) {
               this.faceAlphas[this.indicesCount] = var1.faceAlphas[var2];
            }

            if (this.faceTextures != null) {
               this.faceTextures[this.indicesCount] = var1.faceTextures != null ? var1.faceTextures[var2] : -1;
            }

            if (this.field2154 != null) {
               if (var1.field2154 != null && var1.field2154[var2] != -1) {
                  this.field2154[this.indicesCount] = (byte)(var1.field2154[var2] + this.field2153);
               } else {
                  this.field2154[this.indicesCount] = -1;
               }
            }

            ++this.indicesCount;
         }

         for(var2 = 0; var2 < var1.field2153; ++var2) {
            this.field2199[this.field2153] = this.verticesCount + var1.field2199[var2];
            this.field2155[this.field2153] = this.verticesCount + var1.field2155[var2];
            this.field2187[this.field2153] = this.verticesCount + var1.field2187[var2];
            ++this.field2153;
         }

         for(var2 = 0; var2 < var1.verticesCount; ++var2) {
            this.verticesX[this.verticesCount] = var1.verticesX[var2];
            this.verticesY[this.verticesCount] = var1.verticesY[var2];
            this.verticesZ[this.verticesCount] = var1.verticesZ[var2];
            ++this.verticesCount;
         }

      }
   }

    @ObfuscatedName("at")
    @ObfuscatedSignature(
            descriptor = "([[IIIIZI)Lit;"
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
               var11.field2153 = this.field2153;
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
               var11.field2154 = this.field2154;
               var11.faceTextures = this.faceTextures;
               var11.field2152 = this.field2152;
               var11.field2199 = this.field2199;
               var11.field2155 = this.field2155;
               var11.field2187 = this.field2187;
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

    @ObfuscatedName("aa")
    @ObfuscatedSignature(
            descriptor = "(Z)Lit;"
    )
    public Model toSharedSequenceModel(boolean var1) {
      if (!var1 && Model_sharedSequenceModelFaceAlphas.length < this.indicesCount) {
         Model_sharedSequenceModelFaceAlphas = new byte[this.indicesCount + 100];
      }

      return this.buildSharedModel(var1, Model_sharedSequenceModel, Model_sharedSequenceModelFaceAlphas);
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      descriptor = "(Z)Lit;"
   )
   public Model toSharedSpotAnimationModel(boolean var1) {
      if (!var1 && Model_sharedSpotAnimationModelFaceAlphas.length < this.indicesCount) {
         Model_sharedSpotAnimationModelFaceAlphas = new byte[this.indicesCount + 100];
      }

      return this.buildSharedModel(var1, Model_sharedSpotAnimationModel, Model_sharedSpotAnimationModelFaceAlphas);
   }

    @ObfuscatedName("ao")
    @ObfuscatedSignature(
            descriptor = "(ZLit;[B)Lit;"
    )
    Model buildSharedModel(boolean var1, Model var2, byte[] var3) {
      var2.verticesCount = this.verticesCount;
      var2.indicesCount = this.indicesCount;
      var2.field2153 = this.field2153;
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
      var2.field2154 = this.field2154;
      var2.faceTextures = this.faceTextures;
      var2.field2152 = this.field2152;
      var2.field2199 = this.field2199;
      var2.field2155 = this.field2155;
      var2.field2187 = this.field2187;
      var2.vertexLabels = this.vertexLabels;
      var2.faceLabelsAlpha = this.faceLabelsAlpha;
      var2.field2156 = this.field2156;
      var2.field2160 = this.field2160;
      var2.isSingleTile = this.isSingleTile;
      var2.resetBounds();
      var2.overrideAmount = 0;
      return var2;
   }

    @ObfuscatedName("ax")
    void calculateBoundingBox(int var1) {
      if (!this.aabb.containsKey(var1)) {
         int var2 = 0;
         int var3 = 0;
         int var4 = 0;
         int var5 = 0;
         int var6 = 0;
         int var7 = 0;
         int var8 = field2132[var1];
         int var9 = field2192[var1];

         for(int var10 = 0; var10 < this.verticesCount; ++var10) {
            int var11 = class143.method812(this.verticesX[var10], this.verticesZ[var10], var8, var9);
            int var12 = this.verticesY[var10];
            int var13 = ClanChannel.method903(this.verticesX[var10], this.verticesZ[var10], var8, var9);
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

    @ObfuscatedName("ai")
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

   @ObfuscatedName("ag")
   void method1341() {
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

   @ObfuscatedName("ah")
   public int method1318() {
      this.calculateBoundsCylinder();
      return this.xzRadius;
   }

    @ObfuscatedName("av")
    public void resetBounds() {
      this.boundsType = 0;
      this.aabb.clear();
   }

    @ObfuscatedName("ar")
    @ObfuscatedSignature(
            descriptor = "(Lio;I)V"
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

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      descriptor = "(Lfh;I)V"
   )
   public void method1317(class133 var1, int var2) {
      Skeleton var3 = var1.field1280;
      class219 var4 = var3.method1235();
      if (var4 != null) {
         var3.method1235().method1221(var1, var2);
         this.method1319(var3.method1235(), var1.method773());
      }

      if (var1.method770()) {
         this.method1325(var1, var2);
      }

      this.resetBounds();
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      descriptor = "(Lfh;I)V"
   )
   void method1325(class133 var1, int var2) {
      Skeleton var3 = var1.field1280;

      for(int var4 = 0; var4 < var3.count; ++var4) {
         int var5 = var3.transformTypes[var4];
         if (var5 == 5 && var1.field1282 != null && var1.field1282[var4] != null && var1.field1282[var4][0] != null && this.faceLabelsAlpha != null && this.faceAlphas != null) {
            class125 var6 = var1.field1282[var4][0];
            int[] var7 = var3.labels[var4];
            int var8 = var7.length;

            for(int var9 = 0; var9 < var8; ++var9) {
               int var10 = var7[var9];
               if (var10 < this.faceLabelsAlpha.length) {
                  int[] var11 = this.faceLabelsAlpha[var10];

                  for(int var12 = 0; var12 < var11.length; ++var12) {
                     int var13 = var11[var12];
                     int var14 = (int)((float)(this.faceAlphas[var13] & 255) + var6.method744(var2) * 255.0F);
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

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "(Lic;I)V"
   )
   void method1319(class219 var1, int var2) {
      this.method1333(var1, var2);
   }

    @ObfuscatedName("ak")
    @ObfuscatedSignature(
            descriptor = "(Lio;ILio;I[I)V"
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

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      descriptor = "(Lik;Lfh;I[ZZZ)V"
   )
   public void method1336(Skeleton var1, class133 var2, int var3, boolean[] var4, boolean var5, boolean var6) {
      class219 var7 = var1.method1235();
      if (var7 != null) {
         var7.method1222(var2, var3, var4, var5);
         if (var6) {
            this.method1319(var7, var2.method773());
         }
      }

      if (!var5 && var2.method770()) {
         this.method1325(var2, var3);
      }

   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      descriptor = "(Lio;I[IZ)V"
   )
   public void method1322(Frames var1, int var2, int[] var3, boolean var4) {
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

    @ObfuscatedName("ae")
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
                        var15 = field2192[var14];
                        var16 = field2132[var14];
                        var17 = var15 * this.verticesY[var11] + var16 * this.verticesX[var11] >> 16;
                        this.verticesY[var11] = var16 * this.verticesY[var11] - var15 * this.verticesX[var11] >> 16;
                        this.verticesX[var11] = var17;
                     }

                     if (var12 != 0) {
                        var15 = field2192[var12];
                        var16 = field2132[var12];
                        var17 = var16 * this.verticesY[var11] - var15 * this.verticesZ[var11] >> 16;
                        this.verticesZ[var11] = var15 * this.verticesY[var11] + var16 * this.verticesZ[var11] >> 16;
                        this.verticesY[var11] = var17;
                     }

                     if (var13 != 0) {
                        var15 = field2192[var13];
                        var16 = field2132[var13];
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

    @ObfuscatedName("ap")
    public void rotateY90Ccw() {
      for(int var1 = 0; var1 < this.verticesCount; ++var1) {
         int var2 = this.verticesX[var1];
         this.verticesX[var1] = this.verticesZ[var1];
         this.verticesZ[var1] = -var2;
      }

      this.resetBounds();
   }

    @ObfuscatedName("by")
    public void rotateY180() {
      for(int var1 = 0; var1 < this.verticesCount; ++var1) {
         this.verticesX[var1] = -this.verticesX[var1];
         this.verticesZ[var1] = -this.verticesZ[var1];
      }

      this.resetBounds();
   }

    @ObfuscatedName("bb")
    public void rotateY270Ccw() {
      for(int var1 = 0; var1 < this.verticesCount; ++var1) {
         int var2 = this.verticesZ[var1];
         this.verticesZ[var1] = this.verticesX[var1];
         this.verticesX[var1] = -var2;
      }

      this.resetBounds();
   }

    @ObfuscatedName("bi")
    public void rotateZ(int var1) {
      int var2 = field2192[var1];
      int var3 = field2132[var1];

      for(int var4 = 0; var4 < this.verticesCount; ++var4) {
         int var5 = var3 * this.verticesY[var4] - var2 * this.verticesZ[var4] >> 16;
         this.verticesZ[var4] = var2 * this.verticesY[var4] + var3 * this.verticesZ[var4] >> 16;
         this.verticesY[var4] = var5;
      }

      this.resetBounds();
   }

    @ObfuscatedName("be")
    public void offsetBy(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.verticesCount; ++var4) {
         this.verticesX[var4] += var1;
         this.verticesY[var4] += var2;
         this.verticesZ[var4] += var3;
      }

      this.resetBounds();
   }

    @ObfuscatedName("bk")
    public void scale(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.verticesCount; ++var4) {
         this.verticesX[var4] = this.verticesX[var4] * var1 / 128;
         this.verticesY[var4] = var2 * this.verticesY[var4] / 128;
         this.verticesZ[var4] = var3 * this.verticesZ[var4] / 128;
      }

      this.resetBounds();
   }

   @ObfuscatedName("bx")
   public final void method1343(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      if (this.boundsType != 2 && this.boundsType != 1) {
         this.method1341();
      }

      int var8 = TaskHandler.getClipMidX();
      int var9 = class12.getClipMidY();
      int var10 = field2192[var1];
      int var11 = field2132[var1];
      int var12 = field2192[var2];
      int var13 = field2132[var2];
      int var14 = field2192[var3];
      int var15 = field2132[var3];
      int var16 = field2192[var4];
      int var17 = field2132[var4];
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
         field2173[var19] = var22 - var18;
         modelViewportXs[var19] = var8 + var20 * UserComparator7.get3dZoom() / var22;
         modelViewportYs[var19] = var9 + var23 * UserComparator7.get3dZoom() / var22;
         field2172[var19] = NPC.method609(var22);
         if (this.field2153 > 0) {
            field2161[var19] = var20;
            field2175[var19] = var23;
            field2200[var19] = var22;
         }
      }

      try {
         this.draw0(false, false, false, 0L);
      } catch (Exception var25) {
         ;
      }

   }

   @ObfuscatedName("bo")
   public final void method1327(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      if (this.boundsType != 2 && this.boundsType != 1) {
         this.method1341();
      }

      int var9 = TaskHandler.getClipMidX();
      int var10 = class12.getClipMidY();
      int var11 = field2192[var1];
      int var12 = field2132[var1];
      int var13 = field2192[var2];
      int var14 = field2132[var2];
      int var15 = field2192[var3];
      int var16 = field2132[var3];
      int var17 = field2192[var4];
      int var18 = field2132[var4];
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
         field2173[var20] = var23 - var19;
         modelViewportXs[var20] = var9 + var21 * UserComparator7.get3dZoom() / var8;
         modelViewportYs[var20] = var10 + var24 * UserComparator7.get3dZoom() / var8;
         field2172[var20] = NPC.method609(var8);
         if (this.field2153 > 0) {
            field2161[var20] = var21;
            field2175[var20] = var24;
            field2200[var20] = var23;
         }
      }

      try {
         this.draw0(false, false, false, 0L);
      } catch (Exception var26) {
         ;
      }

   }

    @ObfuscatedName("bz")
    final void draw0(boolean var1, boolean var2, boolean var3, long var4) {
      if (this.diameter < 6000) {
         int var6;
         for(var6 = 0; var6 < this.diameter; ++var6) {
            field2195[var6] = 0;
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
               int var17;
               if (!var1 || var11 != -5000 && var12 != -5000 && var13 != -5000) {
                  if (var2) {
                     var15 = modelViewportYs[var8];
                     var16 = modelViewportYs[var9];
                     var17 = modelViewportYs[var10];
                     var18 = var6 + ViewportMouse.ViewportMouse_y;
                     boolean var35;
                     if (var18 < var15 && var18 < var16 && var18 < var17) {
                        var35 = false;
                     } else {
                        var18 = ViewportMouse.ViewportMouse_y - var6;
                        if (var18 > var15 && var18 > var16 && var18 > var17) {
                           var35 = false;
                        } else {
                           var18 = var6 + ViewportMouse.ViewportMouse_x;
                           if (var18 < var11 && var18 < var12 && var18 < var13) {
                              var35 = false;
                           } else {
                              var18 = ViewportMouse.ViewportMouse_x - var6;
                              if (var18 > var11 && var18 > var12 && var18 > var13) {
                                 var35 = false;
                              } else {
                                 var35 = true;
                              }
                           }
                        }
                     }

                     if (var35) {
                        GraphicsObject.method429(var4);
                        var2 = false;
                     }
                  }

                  if ((var11 - var12) * (modelViewportYs[var10] - modelViewportYs[var9]) - (var13 - var12) * (modelViewportYs[var8] - modelViewportYs[var9]) > 0) {
                     field2169[var7] = false;
                     var14 = class6.method20();
                     if (var11 >= 0 && var12 >= 0 && var13 >= 0 && var11 <= var14 && var12 <= var14 && var13 <= var14) {
                        field2168[var7] = false;
                     } else {
                        field2168[var7] = true;
                     }

                     var15 = (field2173[var8] + field2173[var9] + field2173[var10]) / 3 + this.radius;
                     field2178[var15][field2195[var15]++] = var7;
                  }
               } else {
                  var14 = field2161[var8];
                  var15 = field2161[var9];
                  var16 = field2161[var10];
                  var17 = field2175[var8];
                  var18 = field2175[var9];
                  int var19 = field2175[var10];
                  int var20 = field2200[var8];
                  int var21 = field2200[var9];
                  int var22 = field2200[var10];
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
                     field2169[var7] = true;
                     int var26 = (field2173[var8] + field2173[var9] + field2173[var10]) / 3 + this.radius;
                     field2178[var26][field2195[var26]++] = var7;
                  }
               }
            }
         }

         char[] var27;
         int var31;
         char var32;
         if (this.faceRenderPriorities == null) {
            for(var31 = this.diameter - 1; var31 >= 0; --var31) {
               var32 = field2195[var31];
               if (var32 > 0) {
                  var27 = field2178[var31];

                  for(var10 = 0; var10 < var32; ++var10) {
                     this.drawFace(var27[var10]);
                  }
               }
            }

         } else {
            for(var31 = 0; var31 < 12; ++var31) {
               field2179[var31] = 0;
               field2183[var31] = 0;
            }

            for(var31 = this.diameter - 1; var31 >= 0; --var31) {
               var32 = field2195[var31];
               if (var32 > 0) {
                  var27 = field2178[var31];

                  for(var10 = 0; var10 < var32; ++var10) {
                     char var33 = var27[var10];
                     byte var34 = this.faceRenderPriorities[var33];
                     var13 = field2179[var34]++;
                     field2145[var34][var13] = var33;
                     if (var34 < 10) {
                        field2183[var34] += var31;
                     } else if (var34 == 10) {
                        field2181[var13] = var31;
                     } else {
                        field2182[var13] = var31;
                     }
                  }
               }
            }

            var31 = 0;
            if (field2179[1] > 0 || field2179[2] > 0) {
               var31 = (field2183[1] + field2183[2]) / (field2179[1] + field2179[2]);
            }

            var8 = 0;
            if (field2179[3] > 0 || field2179[4] > 0) {
               var8 = (field2183[3] + field2183[4]) / (field2179[3] + field2179[4]);
            }

            var9 = 0;
            if (field2179[6] > 0 || field2179[8] > 0) {
               var9 = (field2183[8] + field2183[6]) / (field2179[8] + field2179[6]);
            }

            var11 = 0;
            var12 = field2179[10];
            int[] var28 = field2145[10];
            int[] var29 = field2181;
            if (var11 == var12) {
               var11 = 0;
               var12 = field2179[11];
               var28 = field2145[11];
               var29 = field2182;
            }

            if (var11 < var12) {
               var10 = var29[var11];
            } else {
               var10 = -1000;
            }

            for(var15 = 0; var15 < 10; ++var15) {
               while(var15 == 0 && var10 > var31) {
                  this.drawFace(var28[var11++]);
                  if (var11 == var12 && var28 != field2145[11]) {
                     var11 = 0;
                     var12 = field2179[11];
                     var28 = field2145[11];
                     var29 = field2182;
                  }

                  if (var11 < var12) {
                     var10 = var29[var11];
                  } else {
                     var10 = -1000;
                  }
               }

               while(var15 == 3 && var10 > var8) {
                  this.drawFace(var28[var11++]);
                  if (var11 == var12 && var28 != field2145[11]) {
                     var11 = 0;
                     var12 = field2179[11];
                     var28 = field2145[11];
                     var29 = field2182;
                  }

                  if (var11 < var12) {
                     var10 = var29[var11];
                  } else {
                     var10 = -1000;
                  }
               }

               while(var15 == 5 && var10 > var9) {
                  this.drawFace(var28[var11++]);
                  if (var11 == var12 && var28 != field2145[11]) {
                     var11 = 0;
                     var12 = field2179[11];
                     var28 = field2145[11];
                     var29 = field2182;
                  }

                  if (var11 < var12) {
                     var10 = var29[var11];
                  } else {
                     var10 = -1000;
                  }
               }

               var16 = field2179[var15];
               int[] var30 = field2145[var15];

               for(var18 = 0; var18 < var16; ++var18) {
                  this.drawFace(var30[var18]);
               }
            }

            while(var10 != -1000) {
               this.drawFace(var28[var11++]);
               if (var11 == var12 && var28 != field2145[11]) {
                  var11 = 0;
                  var28 = field2145[11];
                  var12 = field2179[11];
                  var29 = field2182;
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

    @ObfuscatedName("bm")
    final void drawFace(int var1) {
      if (field2169[var1]) {
         this.method1334(var1);
      } else {
         int var2 = this.indices1[var1];
         int var3 = this.indices2[var1];
         int var4 = this.indices3[var1];
         Rasterizer3D.clips.field2234 = field2168[var1];
         if (this.faceAlphas == null) {
            Rasterizer3D.clips.field2225 = 0;
         } else {
            Rasterizer3D.clips.field2225 = this.faceAlphas[var1] & 255;
         }

         this.method1332(var1, modelViewportYs[var2], modelViewportYs[var3], modelViewportYs[var4], modelViewportXs[var2], modelViewportXs[var3], modelViewportXs[var4], field2172[var2], field2172[var3], field2172[var4], this.faceColors1[var1], this.faceColors2[var1], this.faceColors3[var1]);
      }
   }

   @ObfuscatedName("bd")
   boolean method1331(int var1) {
      return this.overrideAmount > 0 && var1 < this.field2196;
   }

   @ObfuscatedName("bt")
   final void method1332(int var1, int var2, int var3, int var4, int var5, int var6, int var7, float var8, float var9, float var10, int var11, int var12, int var13) {
      int var21;
      if (this.faceTextures != null && this.faceTextures[var1] != -1) {
         int var20;
         int var22;
         if (this.field2154 != null && this.field2154[var1] != -1) {
            int var23 = this.field2154[var1] & 255;
            var20 = this.field2199[var23];
            var21 = this.field2155[var23];
            var22 = this.field2187[var23];
         } else {
            var20 = this.indices1[var1];
            var21 = this.indices2[var1];
            var22 = this.indices3[var1];
         }

         if (this.faceColors3[var1] == -1) {
            DevicePcmPlayerProvider.method89(var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, var11, var11, field2161[var20], field2161[var21], field2161[var22], field2175[var20], field2175[var21], field2175[var22], field2200[var20], field2200[var21], field2200[var22], this.faceTextures[var1]);
         } else {
            DevicePcmPlayerProvider.method89(var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, field2161[var20], field2161[var21], field2161[var22], field2175[var20], field2175[var21], field2175[var22], field2200[var20], field2200[var21], field2200[var22], this.faceTextures[var1]);
         }
      } else {
         boolean var14 = this.method1331(var1);
         byte var16;
         byte var17;
         byte var18;
         if (this.faceColors3[var1] == -1 && var14) {
            var21 = field2140[this.faceColors1[var1]];
            var16 = this.overrideHue;
            var17 = this.overrideSaturation;
            var18 = this.overrideLuminance;
            byte var19 = this.overrideAmount;
            Rasterizer3D.field1999.method1231(var2, var3, var4, var5, var6, var7, var8, var9, var10, var21, var16, var17, var18, var19);
         } else if (this.faceColors3[var1] == -1) {
            class144.method825(var2, var3, var4, var5, var6, var7, var8, var9, var10, field2140[this.faceColors1[var1]]);
         } else if (var14) {
            byte var15 = this.overrideHue;
            var16 = this.overrideSaturation;
            var17 = this.overrideLuminance;
            var18 = this.overrideAmount;
            Rasterizer3D.field1999.method1224(var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var15, var16, var17, var18);
         } else {
            BoundaryObject.method1379(var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13);
         }
      }

   }

   @ObfuscatedName("bj")
   final void method1334(int var1) {
      int var2 = TaskHandler.getClipMidX();
      int var3 = class12.getClipMidY();
      int var4 = 0;
      int var5 = this.indices1[var1];
      int var6 = this.indices2[var1];
      int var7 = this.indices3[var1];
      int var8 = field2200[var5];
      int var9 = field2200[var6];
      int var10 = field2200[var7];
      if (this.faceAlphas == null) {
         Rasterizer3D.clips.field2225 = 0;
      } else {
         Rasterizer3D.clips.field2225 = this.faceAlphas[var1] & 255;
      }

      int var11;
      int var12;
      int var13;
      int var14;
      if (var8 >= 50) {
         field2184[var4] = modelViewportXs[var5];
         field2185[var4] = modelViewportYs[var5];
         field2150[var4] = field2172[var7];
         field2186[var4++] = this.faceColors1[var1];
      } else {
         var11 = field2161[var5];
         var12 = field2175[var5];
         var13 = this.faceColors1[var1];
         if (var10 >= 50) {
            var14 = field2176[var10 - var8] * (50 - var8);
            field2184[var4] = var2 + (var11 + ((field2161[var7] - var11) * var14 >> 16)) * UserComparator7.get3dZoom() / 50;
            field2185[var4] = var3 + (var12 + ((field2175[var7] - var12) * var14 >> 16)) * UserComparator7.get3dZoom() / 50;
            field2150[var4] = field2198;
            field2186[var4++] = var13 + ((this.faceColors3[var1] - var13) * var14 >> 16);
         }

         if (var9 >= 50) {
            var14 = field2176[var9 - var8] * (50 - var8);
            field2184[var4] = var2 + (var11 + ((field2161[var6] - var11) * var14 >> 16)) * UserComparator7.get3dZoom() / 50;
            field2185[var4] = var3 + (var12 + ((field2175[var6] - var12) * var14 >> 16)) * UserComparator7.get3dZoom() / 50;
            field2150[var4] = field2198;
            field2186[var4++] = var13 + ((this.faceColors2[var1] - var13) * var14 >> 16);
         }
      }

      if (var9 >= 50) {
         field2184[var4] = modelViewportXs[var6];
         field2185[var4] = modelViewportYs[var6];
         field2150[var4] = field2172[var7];
         field2186[var4++] = this.faceColors2[var1];
      } else {
         var11 = field2161[var6];
         var12 = field2175[var6];
         var13 = this.faceColors2[var1];
         if (var8 >= 50) {
            var14 = field2176[var8 - var9] * (50 - var9);
            field2184[var4] = var2 + (var11 + ((field2161[var5] - var11) * var14 >> 16)) * UserComparator7.get3dZoom() / 50;
            field2185[var4] = var3 + (var12 + ((field2175[var5] - var12) * var14 >> 16)) * UserComparator7.get3dZoom() / 50;
            field2150[var4] = field2198;
            field2186[var4++] = var13 + ((this.faceColors1[var1] - var13) * var14 >> 16);
         }

         if (var10 >= 50) {
            var14 = field2176[var10 - var9] * (50 - var9);
            field2184[var4] = var2 + (var11 + ((field2161[var7] - var11) * var14 >> 16)) * UserComparator7.get3dZoom() / 50;
            field2185[var4] = var3 + (var12 + ((field2175[var7] - var12) * var14 >> 16)) * UserComparator7.get3dZoom() / 50;
            field2186[var4++] = var13 + ((this.faceColors3[var1] - var13) * var14 >> 16);
         }
      }

      if (var10 >= 50) {
         field2184[var4] = modelViewportXs[var7];
         field2185[var4] = modelViewportYs[var7];
         field2150[var4] = field2172[var7];
         field2186[var4++] = this.faceColors3[var1];
      } else {
         var11 = field2161[var7];
         var12 = field2175[var7];
         var13 = this.faceColors3[var1];
         if (var9 >= 50) {
            var14 = field2176[var9 - var10] * (50 - var10);
            field2184[var4] = var2 + (var11 + ((field2161[var6] - var11) * var14 >> 16)) * UserComparator7.get3dZoom() / 50;
            field2185[var4] = var3 + (var12 + ((field2175[var6] - var12) * var14 >> 16)) * UserComparator7.get3dZoom() / 50;
            field2150[var4] = field2198;
            field2186[var4++] = var13 + ((this.faceColors2[var1] - var13) * var14 >> 16);
         }

         if (var8 >= 50) {
            var14 = field2176[var8 - var10] * (50 - var10);
            field2184[var4] = var2 + (var11 + ((field2161[var5] - var11) * var14 >> 16)) * UserComparator7.get3dZoom() / 50;
            field2185[var4] = var3 + (var12 + ((field2175[var5] - var12) * var14 >> 16)) * UserComparator7.get3dZoom() / 50;
            field2150[var4] = field2198;
            field2186[var4++] = var13 + ((this.faceColors1[var1] - var13) * var14 >> 16);
         }
      }

      var11 = field2184[0];
      var12 = field2184[1];
      var13 = field2184[2];
      var14 = field2185[0];
      int var15 = field2185[1];
      int var16 = field2185[2];
      float var17 = field2150[0];
      float var18 = field2150[1];
      float var19 = field2150[2];
      Rasterizer3D.clips.field2234 = false;
      int var20 = class6.method20();
      if (var4 == 3) {
         if (var11 < 0 || var12 < 0 || var13 < 0 || var11 > var20 || var12 > var20 || var13 > var20) {
            Rasterizer3D.clips.field2234 = true;
         }

         this.method1332(var1, var14, var15, var16, var11, var12, var13, var17, var18, var19, field2186[0], field2186[1], field2186[2]);
      }

      if (var4 == 4) {
         if (var11 < 0 || var12 < 0 || var13 < 0 || var11 > var20 || var12 > var20 || var13 > var20 || field2184[3] < 0 || field2184[3] > var20) {
            Rasterizer3D.clips.field2234 = true;
         }

         int var22;
         int var23;
         int var24;
         if (this.faceTextures != null && this.faceTextures[var1] != -1) {
            int var38;
            if (this.field2154 != null && this.field2154[var1] != -1) {
               var24 = this.field2154[var1] & 255;
               var38 = this.field2199[var24];
               var22 = this.field2155[var24];
               var23 = this.field2187[var24];
            } else {
               var38 = var5;
               var22 = var6;
               var23 = var7;
            }

            short var41 = this.faceTextures[var1];
            if (this.faceColors3[var1] == -1) {
               DevicePcmPlayerProvider.method89(var14, var15, var16, var11, var12, var13, var17, var18, var19, this.faceColors1[var1], this.faceColors1[var1], this.faceColors1[var1], field2161[var38], field2161[var22], field2161[var23], field2175[var38], field2175[var22], field2175[var23], field2200[var38], field2200[var22], field2200[var23], var41);
               DevicePcmPlayerProvider.method89(var14, var16, field2185[3], var11, var13, field2184[3], var17, var19, field2150[3], this.faceColors1[var1], this.faceColors1[var1], this.faceColors1[var1], field2161[var38], field2161[var22], field2161[var23], field2175[var38], field2175[var22], field2175[var23], field2200[var38], field2200[var22], field2200[var23], var41);
            } else {
               DevicePcmPlayerProvider.method89(var14, var15, var16, var11, var12, var13, var17, var18, var19, field2186[0], field2186[1], field2186[2], field2161[var38], field2161[var22], field2161[var23], field2175[var38], field2175[var22], field2175[var23], field2200[var38], field2200[var22], field2200[var23], var41);
               DevicePcmPlayerProvider.method89(var14, var16, field2185[3], var11, var13, field2184[3], var17, var19, field2150[3], field2186[0], field2186[2], field2186[3], field2161[var38], field2161[var22], field2161[var23], field2175[var38], field2175[var22], field2175[var23], field2200[var38], field2200[var22], field2200[var23], var41);
            }
         } else {
            boolean var21 = this.method1331(var1);
            byte var25;
            byte var26;
            if (this.faceColors3[var1] == -1 && var21) {
               var22 = field2140[this.faceColors1[var1]];
               byte var39 = this.overrideHue;
               byte var40 = this.overrideSaturation;
               var25 = this.overrideLuminance;
               var26 = this.overrideAmount;
               Rasterizer3D.field1999.method1231(var14, var15, var16, var11, var12, var13, var17, var18, var19, var22, var39, var40, var25, var26);
               int var42 = field2185[3];
               int var43 = field2184[3];
               float var44 = field2150[3];
               byte var45 = this.overrideHue;
               byte var46 = this.overrideSaturation;
               byte var47 = this.overrideLuminance;
               byte var48 = this.overrideAmount;
               Rasterizer3D.field1999.method1231(var14, var16, var42, var11, var13, var43, var17, var19, var44, var22, var45, var46, var47, var48);
            } else if (this.faceColors3[var1] == -1) {
               var22 = field2140[this.faceColors1[var1]];
               class144.method825(var14, var15, var16, var11, var12, var13, var17, var18, var19, var22);
               class144.method825(var14, var16, field2185[3], var11, var13, field2184[3], var17, var19, field2150[3], var22);
            } else if (var21) {
               var22 = field2186[0];
               var23 = field2186[1];
               var24 = field2186[2];
               var25 = this.overrideHue;
               var26 = this.overrideLuminance;
               byte var27 = this.overrideSaturation;
               byte var28 = this.overrideAmount;
               Rasterizer3D.field1999.method1224(var14, var15, var16, var11, var12, var13, var17, var18, var19, var22, var23, var24, var25, var26, var27, var28);
               int var29 = field2185[3];
               int var30 = field2184[3];
               int var31 = field2186[0];
               int var32 = field2186[2];
               int var33 = field2186[3];
               byte var34 = this.overrideHue;
               byte var35 = this.overrideLuminance;
               byte var36 = this.overrideSaturation;
               byte var37 = this.overrideAmount;
               Rasterizer3D.field1999.method1224(var14, var16, var29, var11, var13, var30, 0.0F, 0.0F, 0.0F, var31, var32, var33, var34, var35, var36, var37);
            } else {
               BoundaryObject.method1379(var14, var15, var16, var11, var12, var13, var17, var18, var19, field2186[0], field2186[1], field2186[2]);
               BoundaryObject.method1379(var14, var16, field2185[3], var11, var13, field2184[3], var17, var19, field2150[3], field2186[0], field2186[2], field2186[3]);
            }
         }
      }

   }

   @ObfuscatedName("bn")
   @ObfuscatedSignature(
      descriptor = "(ILqj;)V"
   )
   void method1326(int var1, class425 var2) {
      float var3 = (float)this.verticesX[var1];
      float var4 = (float)(-this.verticesY[var1]);
      float var5 = (float)(-this.verticesZ[var1]);
      float var6 = 1.0F;
      this.verticesX[var1] = (int)(var2.field3797[0] * var3 + var2.field3797[4] * var4 + var2.field3797[8] * var5 + var2.field3797[12] * var6);
      this.verticesY[var1] = -((int)(var2.field3797[1] * var3 + var2.field3797[5] * var4 + var2.field3797[9] * var5 + var2.field3797[13] * var6));
      this.verticesZ[var1] = -((int)(var2.field3797[2] * var3 + var2.field3797[6] * var4 + var2.field3797[10] * var5 + var2.field3797[14] * var6));
   }

   @ObfuscatedName("bs")
   @ObfuscatedSignature(
      descriptor = "(Lic;I)V"
   )
   void method1333(class219 var1, int var2) {
      if (this.field2156 != null) {
         for(int var3 = 0; var3 < this.verticesCount; ++var3) {
            int[] var4 = this.field2156[var3];
            if (var4 != null && var4.length != 0) {
               int[] var5 = this.field2160[var3];
               field2134.method2251();

               for(int var6 = 0; var6 < var4.length; ++var6) {
                  int var7 = var4[var6];
                  class122 var8 = var1.method1219(var7);
                  if (var8 != null) {
                     field2135.method2253((float)var5[var6] / 255.0F);
                     field2136.method2252(var8.method728(var2));
                     field2136.method2255(field2135);
                     field2134.method2254(field2136);
                  }
               }

               this.method1326(var3, field2134);
            }
         }

      }
   }

    @ObfuscatedName("df")
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
         int var16 = (var15 - this.xzRadius) * UserComparator7.get3dZoom();
         if (var16 / var14 < class264.getClipMidX2()) {
            int var17 = (var15 + this.xzRadius) * UserComparator7.get3dZoom();
            int var18 = var17 / var14;
            int var19 = Rasterizer3D.clips.clipNegativeMidX;
            if (var18 > var19) {
               int var20 = var3 * var7 - var11 * var2 >> 16;
               int var21 = var2 * this.xzRadius >> 16;
               int var22 = (var3 * this.bottomY >> 16) + var21;
               int var23 = (var20 + var22) * UserComparator7.get3dZoom();
               int var24 = var23 / var14;
               int var25 = Rasterizer3D.clips.clipNegativeMidY;
               if (var24 > var25) {
                  int var26 = (var3 * super.height >> 16) + var21;
                  int var27 = (var20 - var26) * UserComparator7.get3dZoom();
                  if (var27 / var14 < class142.getClipMidY2()) {
                     int var28 = var13 + (var2 * super.height >> 16);
                     boolean var29 = false;
                     boolean var30 = false;
                     if (var12 - var28 <= 50) {
                        var30 = true;
                     }

                     boolean var31 = var30 || this.field2153 > 0;
                     int var32 = Projectile.method452();
                     int var33 = ViewportMouse.ViewportMouse_y;
                     boolean var35 = ViewportMouse.ViewportMouse_isInViewport;
                     boolean var37 = class173.method957(var9);
                     boolean var38 = false;
                     int var40;
                     int var41;
                     int var42;
                     if (var37 && var35) {
                        boolean var39 = false;
                        if (field2180) {
                           var39 = class428.method2272(this, var1, var6, var7, var8);
                        } else {
                           var40 = var12 - var13;
                           if (var40 <= 50) {
                              var40 = 50;
                           }

                           if (var15 > 0) {
                              var16 /= var14;
                              var17 /= var40;
                           } else {
                              var17 /= var14;
                              var16 /= var40;
                           }

                           if (var20 > 0) {
                              var27 /= var14;
                              var23 /= var40;
                           } else {
                              var23 /= var14;
                              var27 /= var40;
                           }

                           var41 = var32 - TaskHandler.getClipMidX();
                           var42 = var33 - class12.getClipMidY();
                           if (var41 > var16 && var41 < var17 && var42 > var27 && var42 < var23) {
                              var39 = true;
                           }
                        }

                        if (var39) {
                           if (this.isSingleTile) {
                              GraphicsObject.method429(var9);
                           } else {
                              var38 = true;
                           }
                        }
                     }

                     int var50 = TaskHandler.getClipMidX();
                     var40 = class12.getClipMidY();
                     var41 = 0;
                     var42 = 0;
                     if (var1 != 0) {
                        var41 = field2192[var1];
                        var42 = field2132[var1];
                     }

                     for(int var43 = 0; var43 < this.verticesCount; ++var43) {
                        int var44 = this.verticesX[var43];
                        int var45 = this.verticesY[var43];
                        int var46 = this.verticesZ[var43];
                        int var47;
                        if (var1 != 0) {
                           var47 = var46 * var41 + var44 * var42 >> 16;
                           var46 = var46 * var42 - var44 * var41 >> 16;
                           var44 = var47;
                        }

                        var44 += var6;
                        var45 += var7;
                        var46 += var8;
                        var47 = var46 * var4 + var5 * var44 >> 16;
                        var46 = var5 * var46 - var44 * var4 >> 16;
                        var44 = var47;
                        var47 = var3 * var45 - var46 * var2 >> 16;
                        var46 = var45 * var2 + var3 * var46 >> 16;
                        field2173[var43] = var46 - var12;
                        if (var46 >= 50) {
                           modelViewportXs[var43] = var50 + var44 * UserComparator7.get3dZoom() / var46;
                           modelViewportYs[var43] = var40 + var47 * UserComparator7.get3dZoom() / var46;
                           field2172[var43] = NPC.method609(var46);
                        } else {
                           modelViewportXs[var43] = -5000;
                           var29 = true;
                        }

                        if (var31) {
                           field2161[var43] = var44;
                           field2175[var43] = var47;
                           field2200[var43] = var46;
                        }
                     }

                     try {
                        this.draw0(var29, var38, this.isSingleTile, var9);
                     } catch (Exception var49) {
                        ;
                     }

                  }
               }
            }
         }
      }
   }
}
