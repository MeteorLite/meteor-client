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
    byte[] inputArray;
    @ObfuscatedName("al")
    int nextByte = 0;
    @ObfuscatedName("at")
    int nextBit_unused;
    @ObfuscatedName("aa")
    byte[] outputArray;
    @ObfuscatedName("ay")
    int next_out = 0;
    @ObfuscatedName("ao")
    int outputLength;
   @ObfuscatedName("ax")
   int field4067;
    @ObfuscatedName("ai")
    byte out_char;
    @ObfuscatedName("ag")
    int su_rNToGo;
    @ObfuscatedName("ah")
    int bsBuff;
    @ObfuscatedName("av")
    int bsLive;
    @ObfuscatedName("ar")
    int blockSize100k;
    @ObfuscatedName("am")
    int originalPointer;
   @ObfuscatedName("as")
   int field4074;
    @ObfuscatedName("aj")
    int su_ch2;
    @ObfuscatedName("ak")
    int[] unzftab = new int[256];
    @ObfuscatedName("az")
    int nblocks_used;
    @ObfuscatedName("ad")
    int[] cftab = new int[257];
    @ObfuscatedName("ap")
    int nInUse;
    @ObfuscatedName("by")
    boolean[] inUse = new boolean[256];
    @ObfuscatedName("bb")
    boolean[] inUse16 = new boolean[16];
    @ObfuscatedName("bi")
    byte[] seqToUnseq = new byte[256];
    @ObfuscatedName("be")
    byte[] ll8 = new byte[4096];
    @ObfuscatedName("bk")
    int[] getAndMoveToFrontDecode_yy = new int[16];
    @ObfuscatedName("bx")
    byte[] selector = new byte[18002];
    @ObfuscatedName("bo")
    byte[] selectorMtf = new byte[18002];
    @ObfuscatedName("bz")
    byte[][] temp_charArray2d = new byte[6][258];
    @ObfuscatedName("bm")
    int[][] limit = new int[6][258];
    @ObfuscatedName("bd")
    int[][] base = new int[6][258];
    @ObfuscatedName("bt")
    int[][] perm = new int[6][258];
    @ObfuscatedName("bj")
    int[] minLens = new int[6];
   @ObfuscatedName("bn")
   int field4092;
}
