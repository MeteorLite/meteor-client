import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("rf")
public final class BZip2State {
   @ObfuscatedName("z")
   static int[] BZip2Decompressor_block;
   @ObfuscatedName("h")
   final int field4954 = 4096;
   @ObfuscatedName("e")
   final int field4925 = 16;
   @ObfuscatedName("v")
   final int field4923 = 258;
   @ObfuscatedName("x")
   final int field4949 = 6;
   @ObfuscatedName("m")
   final int field4924 = 50;
   @ObfuscatedName("q")
   final int field4926 = 18002;
   @ObfuscatedName("f")
   byte[] inputArray;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1821114693
   )
   int nextByte = 0;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1658409903
   )
   int nextBit_unused;
   @ObfuscatedName("b")
   byte[] outputArray;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1295462847
   )
   int next_out = 0;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1101177005
   )
   int outputLength;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -825545807
   )
   int field4936;
   @ObfuscatedName("o")
   byte out_char;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -57104711
   )
   int su_rNToGo;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1388160973
   )
   int bsBuff;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -2006172181
   )
   int bsLive;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 571376640
   )
   int blockSize100k;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1238646899
   )
   int originalPointer;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 935146643
   )
   int field4940;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -633335589
   )
   int su_ch2;
   @ObfuscatedName("p")
   int[] unzftab = new int[256];
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -287672173
   )
   int nblocks_used;
   @ObfuscatedName("y")
   int[] cftab = new int[257];
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -50977887
   )
   int nInUse;
   @ObfuscatedName("as")
   boolean[] inUse = new boolean[256];
   @ObfuscatedName("ad")
   boolean[] inUse16 = new boolean[16];
   @ObfuscatedName("ao")
   byte[] seqToUnseq = new byte[256];
   @ObfuscatedName("am")
   byte[] ll8 = new byte[4096];
   @ObfuscatedName("av")
   int[] getAndMoveToFrontDecode_yy = new int[16];
   @ObfuscatedName("au")
   byte[] selector = new byte[18002];
   @ObfuscatedName("ar")
   byte[] selectorMtf = new byte[18002];
   @ObfuscatedName("at")
   byte[][] temp_charArray2d = new byte[6][258];
   @ObfuscatedName("ay")
   int[][] limit = new int[6][258];
   @ObfuscatedName("an")
   int[][] base = new int[6][258];
   @ObfuscatedName("ab")
   int[][] perm = new int[6][258];
   @ObfuscatedName("al")
   int[] minLens = new int[6];
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = -290046001
   )
   int field4959;
}
