import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("so")
@Implements("BZip2State")
public final class BZip2State {
   @ObfuscatedName("af")
   final int field4062 = 4096;
   @ObfuscatedName("an")
   final int field4056 = 16;
   @ObfuscatedName("aw")
   final int field4086 = 258;
   @ObfuscatedName("ac")
   final int field4057 = 6;
   @ObfuscatedName("au")
   final int field4059 = 50;
   @ObfuscatedName("ab")
   final int field4055 = 18002;
   @ObfuscatedName("aq")
   @Export("inputArray")
   byte[] inputArray;
   @ObfuscatedName("al")
   @Export("nextByte")
   int nextByte = 0;
   @ObfuscatedName("at")
   @Export("nextBit_unused")
   int nextBit_unused;
   @ObfuscatedName("aa")
   @Export("outputArray")
   byte[] outputArray;
   @ObfuscatedName("ay")
   @Export("next_out")
   int next_out = 0;
   @ObfuscatedName("ao")
   @Export("outputLength")
   int outputLength;
   @ObfuscatedName("ax")
   int field4067;
   @ObfuscatedName("ai")
   @Export("out_char")
   byte out_char;
   @ObfuscatedName("ag")
   @Export("su_rNToGo")
   int su_rNToGo;
   @ObfuscatedName("ah")
   @Export("bsBuff")
   int bsBuff;
   @ObfuscatedName("av")
   @Export("bsLive")
   int bsLive;
   @ObfuscatedName("ar")
   @Export("blockSize100k")
   int blockSize100k;
   @ObfuscatedName("am")
   @Export("originalPointer")
   int originalPointer;
   @ObfuscatedName("as")
   int field4074;
   @ObfuscatedName("aj")
   @Export("su_ch2")
   int su_ch2;
   @ObfuscatedName("ak")
   @Export("unzftab")
   int[] unzftab = new int[256];
   @ObfuscatedName("az")
   @Export("nblocks_used")
   int nblocks_used;
   @ObfuscatedName("ad")
   @Export("cftab")
   int[] cftab = new int[257];
   @ObfuscatedName("ap")
   @Export("nInUse")
   int nInUse;
   @ObfuscatedName("by")
   @Export("inUse")
   boolean[] inUse = new boolean[256];
   @ObfuscatedName("bb")
   @Export("inUse16")
   boolean[] inUse16 = new boolean[16];
   @ObfuscatedName("bi")
   @Export("seqToUnseq")
   byte[] seqToUnseq = new byte[256];
   @ObfuscatedName("be")
   @Export("ll8")
   byte[] ll8 = new byte[4096];
   @ObfuscatedName("bk")
   @Export("getAndMoveToFrontDecode_yy")
   int[] getAndMoveToFrontDecode_yy = new int[16];
   @ObfuscatedName("bx")
   @Export("selector")
   byte[] selector = new byte[18002];
   @ObfuscatedName("bo")
   @Export("selectorMtf")
   byte[] selectorMtf = new byte[18002];
   @ObfuscatedName("bz")
   @Export("temp_charArray2d")
   byte[][] temp_charArray2d = new byte[6][258];
   @ObfuscatedName("bm")
   @Export("limit")
   int[][] limit = new int[6][258];
   @ObfuscatedName("bd")
   @Export("base")
   int[][] base = new int[6][258];
   @ObfuscatedName("bt")
   @Export("perm")
   int[][] perm = new int[6][258];
   @ObfuscatedName("bj")
   @Export("minLens")
   int[] minLens = new int[6];
   @ObfuscatedName("bn")
   int field4092;
}
