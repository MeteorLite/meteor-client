import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("da")
public class class125 {
   @ObfuscatedName("f")
   boolean field1226;
   @ObfuscatedName("w")
   boolean field1205;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "Lde;"
   )
   class123 field1206;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      descriptor = "Lde;"
   )
   class123 field1223;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      descriptor = "[Ldp;"
   )
   class120[] field1208;
   @ObfuscatedName("j")
   boolean field1209;
   @ObfuscatedName("i")
   float field1204;
   @ObfuscatedName("n")
   float field1211;
   @ObfuscatedName("l")
   float field1212;
   @ObfuscatedName("k")
   float field1213;
   @ObfuscatedName("c")
   float field1225;
   @ObfuscatedName("r")
   float field1215;
   @ObfuscatedName("b")
   float field1216;
   @ObfuscatedName("m")
   float field1219;
   @ObfuscatedName("t")
   float field1217;
   @ObfuscatedName("h")
   float field1218;
   @ObfuscatedName("p")
   boolean field1214 = true;
   @ObfuscatedName("o")
   int field1207 = 0;
   @ObfuscatedName("u")
   float[] field1220;
   @ObfuscatedName("x")
   int field1210;
   @ObfuscatedName("a")
   int field1222;
   @ObfuscatedName("q")
   float field1221;
   @ObfuscatedName("d")
   float field1224;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "(Lrd;II)I",
      garbageValue = "-1866146568"
   )
   int method704(Buffer var1, int var2) {
      int var3 = var1.readUnsignedShort();
      ReflectionCheck.method170(var1.readUnsignedByte());
      int var5 = var1.readUnsignedByte();
      class123 var6 = (class123)class4.findEnumerated(UrlRequester.method628(), var5);
      if (var6 == null) {
         var6 = class123.field1193;
      }

      this.field1206 = var6;
      this.field1223 = ItemContainer.method455(var1.readUnsignedByte());
      this.field1226 = var1.readUnsignedByte() != 0;
      this.field1208 = new class120[var3];
      class120 var9 = null;

      for(int var7 = 0; var7 < var3; ++var7) {
         class120 var8 = new class120();
         var8.method669(var1, var2);
         this.field1208[var7] = var8;
         if (var9 != null) {
            var9.field1168 = var8;
         }

         var9 = var8;
      }

      return var3;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "26018598"
   )
   void method703() {
      this.field1210 = this.field1208[0].field1173;
      this.field1222 = this.field1208[this.method701() - 1].field1173;
      this.field1220 = new float[this.method698() + 1];

      for(int var1 = this.method702(); var1 <= this.method697(); ++var1) {
         this.field1220[var1 - this.method702()] = UrlRequester.method635(this, (float)var1);
      }

      this.field1208 = null;
      this.field1221 = UrlRequester.method635(this, (float)(this.method702() - 1));
      this.field1224 = UrlRequester.method635(this, (float)(this.method697() + 1));
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "(II)F",
      garbageValue = "2047017372"
   )
   public float method696(int var1) {
      if (var1 < this.method702()) {
         return this.field1221;
      } else {
         return var1 > this.method697() ? this.field1224 : this.field1220[var1 - this.method702()];
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "-178881798"
   )
   int method702() {
      return this.field1210;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "-1489350859"
   )
   int method697() {
      return this.field1222;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      descriptor = "(B)I",
      garbageValue = "11"
   )
   int method698() {
      return this.method697() - this.method702();
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      descriptor = "(FI)I",
      garbageValue = "-2139366977"
   )
   int method699(float var1) {
      if (this.field1207 < 0 || (float)this.field1208[this.field1207].field1173 > var1 || this.field1208[this.field1207].field1168 != null && (float)this.field1208[this.field1207].field1168.field1173 <= var1) {
         if (var1 >= (float)this.method702() && var1 <= (float)this.method697()) {
            int var2 = this.method701();
            int var3 = this.field1207;
            if (var2 > 0) {
               int var4 = 0;
               int var5 = var2 - 1;

               do {
                  int var6 = var5 + var4 >> 1;
                  if (var1 < (float)this.field1208[var6].field1173) {
                     if (var1 > (float)this.field1208[var6 - 1].field1173) {
                        var3 = var6 - 1;
                        break;
                     }

                     var5 = var6 - 1;
                  } else {
                     if (var1 <= (float)this.field1208[var6].field1173) {
                        var3 = var6;
                        break;
                     }

                     if (var1 < (float)this.field1208[var6 + 1].field1173) {
                        var3 = var6;
                        break;
                     }

                     var4 = var6 + 1;
                  }
               } while(var4 <= var5);
            }

            if (var3 != this.field1207) {
               this.field1207 = var3;
               this.field1214 = true;
            }

            return this.field1207;
         } else {
            return -1;
         }
      } else {
         return this.field1207;
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      descriptor = "(FB)Ldp;",
      garbageValue = "-71"
   )
   class120 method700(float var1) {
      int var2 = this.method699(var1);
      return var2 >= 0 && var2 < this.field1208.length ? this.field1208[var2] : null;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "1012762214"
   )
   int method701() {
      return this.field1208 == null ? 0 : this.field1208.length;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      descriptor = "(Lln;Ljava/lang/String;Ljava/lang/String;I)[Lrg;",
      garbageValue = "-46072999"
   )
   public static IndexedSprite[] method705(AbstractArchive var0, String var1, String var2) {
      int var3 = var0.getGroupId(var1);
      int var4 = var0.getFileId(var3, var2);
      IndexedSprite[] var5;
      if (!Buffer.method2444(var0, var3, var4)) {
         var5 = null;
      } else {
         IndexedSprite[] var7 = new IndexedSprite[class488.SpriteBuffer_spriteCount];

         for(int var8 = 0; var8 < class488.SpriteBuffer_spriteCount; ++var8) {
            IndexedSprite var9 = var7[var8] = new IndexedSprite();
            var9.width = class488.SpriteBuffer_spriteWidth;
            var9.height = class488.SpriteBuffer_spriteHeight;
            var9.xOffset = class488.SpriteBuffer_xOffsets[var8];
            var9.yOffset = ApproximateRouteStrategy.SpriteBuffer_yOffsets[var8];
            var9.subWidth = FriendsList.SpriteBuffer_spriteWidths[var8];
            var9.subHeight = class132.SpriteBuffer_spriteHeights[var8];
            var9.palette = class100.SpriteBuffer_spritePalette;
            var9.pixels = class140.SpriteBuffer_pixels[var8];
         }

         class100.method595();
         var5 = var7;
      }

      return var5;
   }
}
