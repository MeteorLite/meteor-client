import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("te")
@Implements("BZip2State")
public final class BZip2State {
	@ObfuscatedName("au")
	final int field4202;
	@ObfuscatedName("ae")
	final int field4198;
	@ObfuscatedName("ao")
	final int field4200;
	@ObfuscatedName("at")
	final int field4201;
	@ObfuscatedName("ac")
	final int field4197;
	@ObfuscatedName("ai")
	final int field4199;
	@ObfuscatedName("az")
	@Export("inputArray")
	byte[] inputArray;
	@ObfuscatedName("ap")
	@Export("nextByte")
	int nextByte;
	@ObfuscatedName("aa")
	@Export("nextBit_unused")
	int nextBit_unused;
	@ObfuscatedName("af")
	@Export("outputArray")
	byte[] outputArray;
	@ObfuscatedName("ad")
	@Export("next_out")
	int next_out;
	@ObfuscatedName("aq")
	@Export("outputLength")
	int outputLength;
	@ObfuscatedName("al")
	int field4182;
	@ObfuscatedName("an")
	@Export("out_char")
	byte out_char;
	@ObfuscatedName("ar")
	@Export("su_rNToGo")
	int su_rNToGo;
	@ObfuscatedName("ab")
	@Export("bsBuff")
	int bsBuff;
	@ObfuscatedName("ag")
	@Export("bsLive")
	int bsLive;
	@ObfuscatedName("am")
	@Export("blockSize100k")
	int blockSize100k;
	@ObfuscatedName("ax")
	@Export("originalPointer")
	int originalPointer;
	@ObfuscatedName("ah")
	int field4179;
	@ObfuscatedName("as")
	@Export("su_ch2")
	int su_ch2;
	@ObfuscatedName("ay")
	@Export("unzftab")
	int[] unzftab;
	@ObfuscatedName("aj")
	@Export("nblocks_used")
	int nblocks_used;
	@ObfuscatedName("av")
	@Export("cftab")
	int[] cftab;
	@ObfuscatedName("ak")
	@Export("nInUse")
	int nInUse;
	@ObfuscatedName("bh")
	@Export("inUse")
	boolean[] inUse;
	@ObfuscatedName("bj")
	@Export("inUse16")
	boolean[] inUse16;
	@ObfuscatedName("bk")
	@Export("seqToUnseq")
	byte[] seqToUnseq;
	@ObfuscatedName("bv")
	@Export("ll8")
	byte[] ll8;
	@ObfuscatedName("bt")
	@Export("getAndMoveToFrontDecode_yy")
	int[] getAndMoveToFrontDecode_yy;
	@ObfuscatedName("bd")
	@Export("selector")
	byte[] selector;
	@ObfuscatedName("by")
	@Export("selectorMtf")
	byte[] selectorMtf;
	@ObfuscatedName("bs")
	@Export("temp_charArray2d")
	byte[][] temp_charArray2d;
	@ObfuscatedName("bm")
	@Export("limit")
	int[][] limit;
	@ObfuscatedName("bf")
	@Export("base")
	int[][] base;
	@ObfuscatedName("bq")
	@Export("perm")
	int[][] perm;
	@ObfuscatedName("ba")
	@Export("minLens")
	int[] minLens;
	@ObfuscatedName("bl")
	int field4189;

	BZip2State() {
		this.field4202 = 4096;
		this.field4198 = 16;
		this.field4200 = 258;
		this.field4201 = 6;
		this.field4197 = 50;
		this.field4199 = 18002;
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