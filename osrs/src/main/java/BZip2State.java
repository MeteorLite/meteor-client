import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("rf")
@Implements("BZip2State")
public final class BZip2State {
   @ObfuscatedName("z")
   @Export("BZip2Decompressor_block")
   static int[] BZip2Decompressor_block;
   @ObfuscatedName("h")
   final int field4030 = 4096;
   @ObfuscatedName("e")
   final int field4001 = 16;
   @ObfuscatedName("v")
   final int field3999 = 258;
   @ObfuscatedName("x")
   final int field4025 = 6;
   @ObfuscatedName("m")
   final int field4000 = 50;
   @ObfuscatedName("q")
   final int field4002 = 18002;
   @ObfuscatedName("f")
   @Export("inputArray")
   byte[] inputArray;
   @ObfuscatedName("r")
   @Export("nextByte")
   int nextByte = 0;
   @ObfuscatedName("u")
   @Export("nextBit_unused")
   int nextBit_unused;
   @ObfuscatedName("b")
   @Export("outputArray")
   byte[] outputArray;
   @ObfuscatedName("j")
   @Export("next_out")
   int next_out = 0;
   @ObfuscatedName("g")
   @Export("outputLength")
   int outputLength;
   @ObfuscatedName("i")
   int field4012;
   @ObfuscatedName("o")
   @Export("out_char")
   byte out_char;
   @ObfuscatedName("n")
   @Export("su_rNToGo")
   int su_rNToGo;
   @ObfuscatedName("k")
   @Export("bsBuff")
   int bsBuff;
   @ObfuscatedName("a")
   @Export("bsLive")
   int bsLive;
   @ObfuscatedName("s")
   @Export("blockSize100k")
   int blockSize100k;
   @ObfuscatedName("l")
   @Export("originalPointer")
   int originalPointer;
   @ObfuscatedName("t")
   int field4016;
   @ObfuscatedName("c")
   @Export("su_ch2")
   int su_ch2;
   @ObfuscatedName("p")
   @Export("unzftab")
   int[] unzftab = new int[256];
   @ObfuscatedName("d")
   @Export("nblocks_used")
   int nblocks_used;
   @ObfuscatedName("y")
   @Export("cftab")
   int[] cftab = new int[257];
   @ObfuscatedName("w")
   @Export("nInUse")
   int nInUse;
   @ObfuscatedName("as")
   @Export("inUse")
   boolean[] inUse = new boolean[256];
   @ObfuscatedName("ad")
   @Export("inUse16")
   boolean[] inUse16 = new boolean[16];
   @ObfuscatedName("ao")
   @Export("seqToUnseq")
   byte[] seqToUnseq = new byte[256];
   @ObfuscatedName("am")
   @Export("ll8")
   byte[] ll8 = new byte[4096];
   @ObfuscatedName("av")
   @Export("getAndMoveToFrontDecode_yy")
   int[] getAndMoveToFrontDecode_yy = new int[16];
   @ObfuscatedName("au")
   @Export("selector")
   byte[] selector = new byte[18002];
   @ObfuscatedName("ar")
   @Export("selectorMtf")
   byte[] selectorMtf = new byte[18002];
   @ObfuscatedName("at")
   @Export("temp_charArray2d")
   byte[][] temp_charArray2d = new byte[6][258];
   @ObfuscatedName("ay")
   @Export("limit")
   int[][] limit = new int[6][258];
   @ObfuscatedName("an")
   @Export("base")
   int[][] base = new int[6][258];
   @ObfuscatedName("ab")
   @Export("perm")
   int[][] perm = new int[6][258];
   @ObfuscatedName("al")
   @Export("minLens")
   int[] minLens = new int[6];
   @ObfuscatedName("ag")
   int field4035;
}
