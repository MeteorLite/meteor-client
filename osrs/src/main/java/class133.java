import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fh")
public class class133 extends DualNode {
   @ObfuscatedName("aq")
   static int field1283;
   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      descriptor = "Lfj;"
   )
   static ClanSettings field1286;
   @ObfuscatedName("af")
   int field1278;
   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "[[Lek;"
   )
   public class125[][] field1282 = null;
   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      descriptor = "[[Lek;"
   )
   class125[][] field1279 = null;
   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "Lik;"
   )
   public Skeleton field1280;
   @ObfuscatedName("au")
   int field1281 = 0;
   @ObfuscatedName("ab")
   boolean field1287;
   @ObfuscatedName("at")
   Future field1284;
   @ObfuscatedName("aa")
   List field1285;

   @ObfuscatedSignature(
      descriptor = "(Lnm;Lnm;IZ)V"
   )
   class133(AbstractArchive var1, AbstractArchive var2, int var3, boolean var4) {
      this.field1278 = var3;
      byte[] var5 = var1.takeFile(this.field1278 >> 16 & '\uffff', this.field1278 & '\uffff');
      Buffer var6 = new Buffer(var5);
      int var7 = var6.readUnsignedByte();
      int var8 = var6.readUnsignedShort();
      byte[] var9;
      if (var4) {
         var9 = var2.getFile(0, var8);
      } else {
         var9 = var2.getFile(var8, 0);
      }

      this.field1280 = new Skeleton(var8, var9);
      this.field1285 = new ArrayList();
      this.field1284 = class374.field3598.submit(new class132(this, var6, var7));
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "(Lsg;IB)V",
      garbageValue = "-87"
   )
   void method769(Buffer var1, int var2) {
      var1.readUnsignedShort();
      var1.readUnsignedShort();
      this.field1281 = var1.readUnsignedByte();
      int var3 = var1.readUnsignedShort();
      this.field1279 = new class125[this.field1280.method1235().method1217()][];
      this.field1282 = new class125[this.field1280.method1234()][];
      class124[] var4 = new class124[var3];

      int var5;
      int var7;
      int var9;
      for(var5 = 0; var5 < var3; ++var5) {
         var7 = var1.readUnsignedByte();
         class126 var8 = (class126)StructComposition.findEnumerated(VarpDefinition.method983(), var7);
         if (var8 == null) {
            var8 = class126.field1243;
         }

         var9 = var1.readShortSmart();
         class127 var10 = UserComparator9.method705(var1.readUnsignedByte());
         class125 var11 = new class125();
         var11.method743(var1, var2);
         var4[var5] = new class124(this, var11, var8, var10, var9);
         int var12 = var8.method755();
         class125[][] var13;
         if (var8 == class126.field1240) {
            var13 = this.field1279;
         } else {
            var13 = this.field1282;
         }

         if (var13[var9] == null) {
            var13[var9] = new class125[var12];
         }

         if (var8 == class126.field1247) {
            this.field1287 = true;
         }
      }

      var5 = var3 / field1283;
      int var14 = var3 % field1283;
      int var15 = 0;

      for(var9 = 0; var9 < field1283; ++var9) {
         var7 = var15;
         var15 += var5;
         if (var14 > 0) {
            ++var15;
            --var14;
         }

         if (var15 == var7) {
            break;
         }

         this.field1285.add(class374.field3598.submit(new class128(this, var7, var15, var4)));
      }

   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      descriptor = "(I)Z",
      garbageValue = "-63286081"
   )
   public boolean method774() {
      if (this.field1284 == null && this.field1285 == null) {
         return true;
      } else {
         if (this.field1284 != null) {
            if (!this.field1284.isDone()) {
               return false;
            }

            this.field1284 = null;
         }

         boolean var1 = true;

         for(int var2 = 0; var2 < this.field1285.size(); ++var2) {
            if (!((Future)this.field1285.get(var2)).isDone()) {
               var1 = false;
            } else {
               this.field1285.remove(var2);
               --var2;
            }
         }

         if (!var1) {
            return false;
         } else {
            this.field1285 = null;
            return true;
         }
      }
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "-2042558319"
   )
   public int method773() {
      return this.field1281;
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      descriptor = "(I)Z",
      garbageValue = "1713081171"
   )
   public boolean method770() {
      return this.field1287;
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "(ILew;III)V",
      garbageValue = "-434592312"
   )
   public void method771(int var1, class122 var2, int var3, int var4) {
      class425[] var6 = class425.field3793;
      class425 var5;
      synchronized(class425.field3793) {
         if (class425.field3794 == 0) {
            var5 = new class425();
         } else {
            class425.field3793[--class425.field3794].method2250();
            var5 = class425.field3793[class425.field3794];
         }
      }

      this.method775(var5, var3, var2, var1);
      this.method776(var5, var3, var2, var1);
      this.method772(var5, var3, var2, var1);
      var2.method733(var5);
      var5.method2249();
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      descriptor = "(Lqj;ILew;II)V",
      garbageValue = "-2042507237"
   )
   void method775(class425 var1, int var2, class122 var3, int var4) {
      float[] var5 = var3.method734(this.field1281);
      float var6 = var5[0];
      float var7 = var5[1];
      float var8 = var5[2];
      if (this.field1279[var2] != null) {
         class125 var9 = this.field1279[var2][0];
         class125 var10 = this.field1279[var2][1];
         class125 var11 = this.field1279[var2][2];
         if (var9 != null) {
            var6 = var9.method744(var4);
         }

         if (var10 != null) {
            var7 = var10.method744(var4);
         }

         if (var11 != null) {
            var8 = var11.method744(var4);
         }
      }

      class424 var17 = class131.method767();
      var17.method2241(1.0F, 0.0F, 0.0F, var6);
      class424 var18 = class131.method767();
      var18.method2241(0.0F, 1.0F, 0.0F, var7);
      class424 var19 = class131.method767();
      var19.method2241(0.0F, 0.0F, 1.0F, var8);
      class424 var12 = class131.method767();
      var12.method2242(var19);
      var12.method2242(var17);
      var12.method2242(var18);
      class425[] var14 = class425.field3793;
      class425 var13;
      synchronized(class425.field3793) {
         if (class425.field3794 == 0) {
            var13 = new class425();
         } else {
            class425.field3793[--class425.field3794].method2250();
            var13 = class425.field3793[class425.field3794];
         }
      }

      var13.method2256(var12);
      var1.method2255(var13);
      var17.method2243();
      var18.method2243();
      var19.method2243();
      var12.method2243();
      var13.method2249();
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "(Lqj;ILew;II)V",
      garbageValue = "2146059803"
   )
   void method772(class425 var1, int var2, class122 var3, int var4) {
      float[] var5 = var3.method730(this.field1281);
      float var6 = var5[0];
      float var7 = var5[1];
      float var8 = var5[2];
      if (this.field1279[var2] != null) {
         class125 var9 = this.field1279[var2][3];
         class125 var10 = this.field1279[var2][4];
         class125 var11 = this.field1279[var2][5];
         if (var9 != null) {
            var6 = var9.method744(var4);
         }

         if (var10 != null) {
            var7 = var10.method744(var4);
         }

         if (var11 != null) {
            var8 = var11.method744(var4);
         }
      }

      var1.field3797[12] = var6;
      var1.field3797[13] = var7;
      var1.field3797[14] = var8;
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      descriptor = "(Lqj;ILew;II)V",
      garbageValue = "-1686943935"
   )
   void method776(class425 var1, int var2, class122 var3, int var4) {
      float[] var5 = var3.method731(this.field1281);
      float var6 = var5[0];
      float var7 = var5[1];
      float var8 = var5[2];
      if (this.field1279[var2] != null) {
         class125 var9 = this.field1279[var2][6];
         class125 var10 = this.field1279[var2][7];
         class125 var11 = this.field1279[var2][8];
         if (var9 != null) {
            var6 = var9.method744(var4);
         }

         if (var10 != null) {
            var7 = var10.method744(var4);
         }

         if (var11 != null) {
            var8 = var11.method744(var4);
         }
      }

      class425[] var14 = class425.field3793;
      class425 var15;
      synchronized(class425.field3793) {
         if (class425.field3794 == 0) {
            var15 = new class425();
         } else {
            class425.field3793[--class425.field3794].method2250();
            var15 = class425.field3793[class425.field3794];
         }
      }

      var15.method2260(var6, var7, var8);
      var1.method2255(var15);
      var15.method2249();
   }

    @ObfuscatedName("he")
    @ObfuscatedSignature(
            descriptor = "(IIIB)V",
            garbageValue = "-121"
    )
    static void queueSoundEffect(int var0, int var1, int var2) {
      if (class20.clientPreferences.getCurrentSoundEffectsVolume() != 0 && var1 != 0 && Client.soundEffectCount < 50) {
         Client.soundEffectIds[Client.soundEffectCount] = var0;
         Client.queuedSoundEffectLoops[Client.soundEffectCount] = var1;
         Client.queuedSoundEffectDelays[Client.soundEffectCount] = var2;
         Client.soundEffects[Client.soundEffectCount] = null;
         Client.soundLocations[Client.soundEffectCount] = 0;
         ++Client.soundEffectCount;
      }

   }

   @ObfuscatedName("il")
   @ObfuscatedSignature(
      descriptor = "(IIII)V",
      garbageValue = "1741543163"
   )
   static final void method777(int var0, int var1, int var2) {
      if (class36.cameraX < var0) {
         class36.cameraX = (var0 - class36.cameraX) * class138.field1314 / 1000 + class36.cameraX + KeyHandler.field81;
         if (class36.cameraX > var0) {
            class36.cameraX = var0;
         }
      }

      if (class36.cameraX > var0) {
         class36.cameraX -= (class36.cameraX - var0) * class138.field1314 / 1000 + KeyHandler.field81;
         if (class36.cameraX < var0) {
            class36.cameraX = var0;
         }
      }

      if (class174.cameraY < var1) {
         class174.cameraY = (var1 - class174.cameraY) * class138.field1314 / 1000 + class174.cameraY + KeyHandler.field81;
         if (class174.cameraY > var1) {
            class174.cameraY = var1;
         }
      }

      if (class174.cameraY > var1) {
         class174.cameraY -= (class174.cameraY - var1) * class138.field1314 / 1000 + KeyHandler.field81;
         if (class174.cameraY < var1) {
            class174.cameraY = var1;
         }
      }

      if (class297.cameraZ < var2) {
         class297.cameraZ = (var2 - class297.cameraZ) * class138.field1314 / 1000 + class297.cameraZ + KeyHandler.field81;
         if (class297.cameraZ > var2) {
            class297.cameraZ = var2;
         }
      }

      if (class297.cameraZ > var2) {
         class297.cameraZ -= (class297.cameraZ - var2) * class138.field1314 / 1000 + KeyHandler.field81;
         if (class297.cameraZ < var2) {
            class297.cameraZ = var2;
         }
      }

   }
}
