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
   int nextByte = 0;
   @ObfuscatedName("u")
   int nextBit_unused;
   @ObfuscatedName("b")
   byte[] outputArray;
   @ObfuscatedName("j")
   int next_out = 0;
   @ObfuscatedName("g")
   int outputLength;
   @ObfuscatedName("i")
   int field4936;
   @ObfuscatedName("o")
   byte out_char;
   @ObfuscatedName("n")
   int su_rNToGo;
   @ObfuscatedName("k")
   int bsBuff;
   @ObfuscatedName("a")
   int bsLive;
   @ObfuscatedName("s")
   int blockSize100k;
   @ObfuscatedName("l")
   int originalPointer;
   @ObfuscatedName("t")
   int field4940;
   @ObfuscatedName("c")
   int su_ch2;
   @ObfuscatedName("p")
   int[] unzftab = new int[256];
   @ObfuscatedName("d")
   int nblocks_used;
   @ObfuscatedName("y")
   int[] cftab = new int[257];
   @ObfuscatedName("w")
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
   int field4959;
}
