import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ri")
@Implements("BZip2State")
public final class BZip2State {
   @ObfuscatedName("f")
   final int field4012 = 4096;
   @ObfuscatedName("w")
   final int field4010 = 16;
   @ObfuscatedName("v")
   final int field4011 = 258;
   @ObfuscatedName("s")
   final int field4040 = 6;
   @ObfuscatedName("z")
   final int field4013 = 50;
   @ObfuscatedName("j")
   final int field4031 = 18002;
    @ObfuscatedName("i")
    byte[] inputArray;
    @ObfuscatedName("n")
    int nextByte = 0;
    @ObfuscatedName("l")
    int nextBit_unused;
    @ObfuscatedName("k")
    byte[] outputArray;
    @ObfuscatedName("c")
    int next_out = 0;
    @ObfuscatedName("r")
    int outputLength;
   @ObfuscatedName("b")
   int field4021;
    @ObfuscatedName("m")
    byte out_char;
    @ObfuscatedName("t")
    int su_rNToGo;
    @ObfuscatedName("h")
    int bsBuff;
    @ObfuscatedName("p")
    int bsLive;
    @ObfuscatedName("o")
    int blockSize100k;
    @ObfuscatedName("u")
    int originalPointer;
   @ObfuscatedName("x")
   int field4028;
    @ObfuscatedName("a")
    int su_ch2;
    @ObfuscatedName("q")
    int[] unzftab = new int[256];
    @ObfuscatedName("d")
    int nblocks_used;
    @ObfuscatedName("e")
    int[] cftab = new int[257];
    @ObfuscatedName("y")
    int nInUse;
    @ObfuscatedName("af")
    boolean[] inUse = new boolean[256];
    @ObfuscatedName("aa")
    boolean[] inUse16 = new boolean[16];
    @ObfuscatedName("ai")
    byte[] seqToUnseq = new byte[256];
    @ObfuscatedName("ag")
    byte[] ll8 = new byte[4096];
    @ObfuscatedName("aw")
    int[] getAndMoveToFrontDecode_yy = new int[16];
    @ObfuscatedName("ar")
    byte[] selector = new byte[18002];
    @ObfuscatedName("al")
    byte[] selectorMtf = new byte[18002];
    @ObfuscatedName("at")
    byte[][] temp_charArray2d = new byte[6][258];
    @ObfuscatedName("aj")
    int[][] limit = new int[6][258];
    @ObfuscatedName("ax")
    int[][] base = new int[6][258];
    @ObfuscatedName("az")
    int[][] perm = new int[6][258];
    @ObfuscatedName("ap")
    int[] minLens = new int[6];
   @ObfuscatedName("ay")
   int field4046;

    @ObfuscatedName("w")
    @ObfuscatedSignature(
            descriptor = "(Lln;III)Lrs;",
            garbageValue = "-126642203"
    )
    public static SpritePixels SpriteBuffer_getSprite(AbstractArchive var0, int var1, int var2) {
      if (!Buffer.method2444(var0, var1, var2)) {
         return null;
      } else {
         SpritePixels var4 = new SpritePixels();
         var4.width = class488.SpriteBuffer_spriteWidth;
         var4.height = class488.SpriteBuffer_spriteHeight;
         var4.xOffset = class488.SpriteBuffer_xOffsets[0];
         var4.yOffset = ApproximateRouteStrategy.SpriteBuffer_yOffsets[0];
         var4.subWidth = FriendsList.SpriteBuffer_spriteWidths[0];
         var4.subHeight = class132.SpriteBuffer_spriteHeights[0];
         int var5 = var4.subWidth * var4.subHeight;
         byte[] var6 = class140.SpriteBuffer_pixels[0];
         var4.pixels = new int[var5];

         for(int var7 = 0; var7 < var5; ++var7) {
            var4.pixels[var7] = class100.SpriteBuffer_spritePalette[var6[var7] & 255];
         }

         class100.method595();
         return var4;
      }
   }
}
