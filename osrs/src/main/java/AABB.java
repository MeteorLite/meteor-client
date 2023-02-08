import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hl")
@Implements("AABB")
public class AABB {
   @ObfuscatedName("f")
   @Export("xMid")
   int xMid;
   @ObfuscatedName("w")
   @Export("yMid")
   int yMid;
   @ObfuscatedName("v")
   @Export("zMid")
   int zMid;
   @ObfuscatedName("s")
   @Export("xMidOffset")
   int xMidOffset;
   @ObfuscatedName("z")
   @Export("yMidOffset")
   int yMidOffset;
   @ObfuscatedName("j")
   @Export("zMidOffset")
   int zMidOffset;

   AABB(int var1, int var2, int var3, int var4, int var5, int var6) {
      this.xMid = var1;
      this.yMid = var2;
      this.zMid = var3;
      this.xMidOffset = var4;
      this.yMidOffset = var5;
      this.zMidOffset = var6;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "(Lln;III)[Lrs;",
      garbageValue = "-1613206903"
   )
   public static SpritePixels[] method1240(AbstractArchive var0, int var1, int var2) {
      if (!Buffer.method2444(var0, var1, var2)) {
         return null;
      } else {
         SpritePixels[] var4 = new SpritePixels[class488.SpriteBuffer_spriteCount];

         for(int var5 = 0; var5 < class488.SpriteBuffer_spriteCount; ++var5) {
            SpritePixels var6 = var4[var5] = new SpritePixels();
            var6.width = class488.SpriteBuffer_spriteWidth;
            var6.height = class488.SpriteBuffer_spriteHeight;
            var6.xOffset = class488.SpriteBuffer_xOffsets[var5];
            var6.yOffset = ApproximateRouteStrategy.SpriteBuffer_yOffsets[var5];
            var6.subWidth = FriendsList.SpriteBuffer_spriteWidths[var5];
            var6.subHeight = class132.SpriteBuffer_spriteHeights[var5];
            int var7 = var6.subWidth * var6.subHeight;
            byte[] var8 = class140.SpriteBuffer_pixels[var5];
            var6.pixels = new int[var7];

            for(int var9 = 0; var9 < var7; ++var9) {
               var6.pixels[var9] = class100.SpriteBuffer_spritePalette[var8[var9] & 255];
            }
         }

         class100.method595();
         return var4;
      }
   }

   @ObfuscatedName("hb")
   @ObfuscatedSignature(
      descriptor = "(IIIII)V",
      garbageValue = "-1608051056"
   )
   static final void method1239(int var0, int var1, int var2, int var3) {
      Client.field494 = 0;
      int var4 = (class387.localPlayer.x >> 7) + ParamComposition.baseX;
      int var5 = (class387.localPlayer.y >> 7) + Client.baseY;
      if (var4 >= 3053 && var4 <= 3156 && var5 >= 3056 && var5 <= 3136) {
         Client.field494 = 1;
      }

      if (var4 >= 3072 && var4 <= 3118 && var5 >= 9492 && var5 <= 9535) {
         Client.field494 = 1;
      }

      if (Client.field494 == 1 && var4 >= 3139 && var4 <= 3199 && var5 >= 3008 && var5 <= 3062) {
         Client.field494 = 0;
      }

   }
}
