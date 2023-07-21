import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("tb")
@Implements("BZip2State")
public final class BZip2State {
	@ObfuscatedName("aw")
	final int field4156;
	@ObfuscatedName("ay")
	final int field4157;
	@ObfuscatedName("ar")
	final int field4154;
	@ObfuscatedName("am")
	final int field4153;
	@ObfuscatedName("as")
	final int field4155;
	@ObfuscatedName("aj")
	final int field4152;
	@ObfuscatedName("ag")
	@Export("inputArray")
	byte[] inputArray;
	@ObfuscatedName("az")
	@Export("nextByte")
	int nextByte;
	@ObfuscatedName("av")
	@Export("nextBit_unused")
	int nextBit_unused;
	@ObfuscatedName("ap")
	@Export("outputArray")
	byte[] outputArray;
	@ObfuscatedName("aq")
	@Export("next_out")
	int next_out;
	@ObfuscatedName("at")
	@Export("outputLength")
	int outputLength;
	@ObfuscatedName("ah")
	int field4135;
	@ObfuscatedName("ax")
	@Export("out_char")
	byte out_char;
	@ObfuscatedName("aa")
	@Export("su_rNToGo")
	int su_rNToGo;
	@ObfuscatedName("au")
	@Export("bsBuff")
	int bsBuff;
	@ObfuscatedName("ae")
	@Export("bsLive")
	int bsLive;
	@ObfuscatedName("ab")
	@Export("blockSize100k")
	int blockSize100k;
	@ObfuscatedName("ad")
	@Export("originalPointer")
	int originalPointer;
	@ObfuscatedName("ao")
	int field4138;
	@ObfuscatedName("ac")
	@Export("su_ch2")
	int su_ch2;
	@ObfuscatedName("ak")
	@Export("unzftab")
	int[] unzftab;
	@ObfuscatedName("an")
	@Export("nblocks_used")
	int nblocks_used;
	@ObfuscatedName("af")
	@Export("cftab")
	int[] cftab;
	@ObfuscatedName("al")
	@Export("nInUse")
	int nInUse;
	@ObfuscatedName("bd")
	@Export("inUse")
	boolean[] inUse;
	@ObfuscatedName("bb")
	@Export("inUse16")
	boolean[] inUse16;
	@ObfuscatedName("bn")
	@Export("seqToUnseq")
	byte[] seqToUnseq;
	@ObfuscatedName("ba")
	@Export("ll8")
	byte[] ll8;
	@ObfuscatedName("bf")
	@Export("getAndMoveToFrontDecode_yy")
	int[] getAndMoveToFrontDecode_yy;
	@ObfuscatedName("bs")
	@Export("selector")
	byte[] selector;
	@ObfuscatedName("bp")
	@Export("selectorMtf")
	byte[] selectorMtf;
	@ObfuscatedName("bv")
	@Export("temp_charArray2d")
	byte[][] temp_charArray2d;
	@ObfuscatedName("bq")
	@Export("limit")
	int[][] limit;
	@ObfuscatedName("bo")
	@Export("base")
	int[][] base;
	@ObfuscatedName("br")
	@Export("perm")
	int[][] perm;
	@ObfuscatedName("bw")
	@Export("minLens")
	int[] minLens;
	@ObfuscatedName("be")
	int field4144;

	BZip2State() {
		this.field4156 = 4096;
		this.field4157 = 16;
		this.field4154 = 258;
		this.field4153 = 6;
		this.field4155 = 50;
		this.field4152 = 18002;
		this.nextByte = 0;
		this.next_out = 0;
		this.unzftab = new int[256];
		this.cftab = new int[257];
		this.inUse = new boolean[256];
		this.inUse16 = new boolean[16];
		this.seqToUnseq = new byte[256];
		this.ll8 = new byte[4096];
		this.getAndMoveToFrontDecode_yy = new int[16];
		this.selector = new byte[18002];
		this.selectorMtf = new byte[18002];
		this.temp_charArray2d = new byte[6][258];
		this.limit = new int[6][258];
		this.base = new int[6][258];
		this.perm = new int[6][258];
		this.minLens = new int[6];
	}
}
