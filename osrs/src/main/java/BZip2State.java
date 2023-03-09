import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ss")
@Implements("BZip2State")
public final class BZip2State {
   @ObfuscatedName("aj")
   final int field4003 = 4096;
   @ObfuscatedName("al")
   final int field4006 = 16;
   @ObfuscatedName("ac")
   final int field3979 = 258;
   @ObfuscatedName("ab")
   final int field4008 = 6;
   @ObfuscatedName("an")
   final int field4002 = 50;
   @ObfuscatedName("ao")
   final int field3982 = 18002;
   @ObfuscatedName("av")
   @Export("inputArray")
   byte[] inputArray;
   @ObfuscatedName("aq")
   @Export("nextByte")
   int nextByte = 0;
   @ObfuscatedName("ap")
   @Export("nextBit_unused")
   int nextBit_unused;
   @ObfuscatedName("ar")
   @Export("outputArray")
   byte[] outputArray;
   @ObfuscatedName("ak")
   @Export("next_out")
   int next_out = 0;
   @ObfuscatedName("ax")
   @Export("outputLength")
   int outputLength;
   @ObfuscatedName("as")
   int field3989;
   @ObfuscatedName("ay")
   @Export("out_char")
   byte out_char;
   @ObfuscatedName("am")
   @Export("su_rNToGo")
   int su_rNToGo;
   @ObfuscatedName("az")
   @Export("bsBuff")
   int bsBuff;
   @ObfuscatedName("ae")
   @Export("bsLive")
   int bsLive;
   @ObfuscatedName("au")
   @Export("blockSize100k")
   int blockSize100k;
   @ObfuscatedName("ag")
   @Export("originalPointer")
   int originalPointer;
   @ObfuscatedName("at")
   int field3996;
   @ObfuscatedName("af")
   @Export("su_ch2")
   int su_ch2;
   @ObfuscatedName("ai")
   @Export("unzftab")
   int[] unzftab = new int[256];
   @ObfuscatedName("aw")
   @Export("nblocks_used")
   int nblocks_used;
   @ObfuscatedName("aa")
   @Export("cftab")
   int[] cftab = new int[257];
   @ObfuscatedName("ad")
   @Export("nInUse")
   int nInUse;
   @ObfuscatedName("bm")
   @Export("inUse")
   boolean[] inUse = new boolean[256];
   @ObfuscatedName("bv")
   @Export("inUse16")
   boolean[] inUse16 = new boolean[16];
   @ObfuscatedName("bo")
   @Export("seqToUnseq")
   byte[] seqToUnseq = new byte[256];
   @ObfuscatedName("bs")
   @Export("ll8")
   byte[] ll8 = new byte[4096];
   @ObfuscatedName("bg")
   @Export("getAndMoveToFrontDecode_yy")
   int[] getAndMoveToFrontDecode_yy = new int[16];
   @ObfuscatedName("bh")
   @Export("selector")
   byte[] selector = new byte[18002];
   @ObfuscatedName("bl")
   @Export("selectorMtf")
   byte[] selectorMtf = new byte[18002];
   @ObfuscatedName("bk")
   @Export("temp_charArray2d")
   byte[][] temp_charArray2d = new byte[6][258];
   @ObfuscatedName("br")
   @Export("limit")
   int[][] limit = new int[6][258];
   @ObfuscatedName("ba")
   @Export("base")
   int[][] base = new int[6][258];
   @ObfuscatedName("bz")
   @Export("perm")
   int[][] perm = new int[6][258];
   @ObfuscatedName("bq")
   @Export("minLens")
   int[] minLens = new int[6];
   @ObfuscatedName("bc")
   int field4014;
}
