import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("uq")
@Implements("BZip2State")
public final class BZip2State {
	@ObfuscatedName("ad")
	@Export("BZip2Decompressor_block")
	static int[] BZip2Decompressor_block;
	@ObfuscatedName("at")
	final int field4230;
	@ObfuscatedName("ah")
	final int field4227;
	@ObfuscatedName("ar")
	final int field4229;
	@ObfuscatedName("ao")
	final int field4228;
	@ObfuscatedName("ab")
	final int field4226;
	@ObfuscatedName("au")
	final int field4231;
	@ObfuscatedName("aa")
	@Export("inputArray")
	byte[] inputArray;
	@ObfuscatedName("ac")
	@Export("nextByte")
	int nextByte;
	@ObfuscatedName("al")
	@Export("nextBit_unused")
	int nextBit_unused;
	@ObfuscatedName("az")
	@Export("outputArray")
	byte[] outputArray;
	@ObfuscatedName("ap")
	@Export("next_out")
	int next_out;
	@ObfuscatedName("av")
	@Export("outputLength")
	int outputLength;
	@ObfuscatedName("ax")
	int field4216;
	@ObfuscatedName("as")
	@Export("out_char")
	byte out_char;
	@ObfuscatedName("ay")
	@Export("su_rNToGo")
	int su_rNToGo;
	@ObfuscatedName("ak")
	@Export("bsBuff")
	int bsBuff;
	@ObfuscatedName("aj")
	@Export("bsLive")
	int bsLive;
	@ObfuscatedName("am")
	@Export("blockSize100k")
	int blockSize100k;
	@ObfuscatedName("aq")
	@Export("originalPointer")
	int originalPointer;
	@ObfuscatedName("ai")
	int field4206;
	@ObfuscatedName("aw")
	@Export("su_ch2")
	int su_ch2;
	@ObfuscatedName("ae")
	@Export("unzftab")
	int[] unzftab;
	@ObfuscatedName("an")
	@Export("nblocks_used")
	int nblocks_used;
	@ObfuscatedName("ag")
	@Export("cftab")
	int[] cftab;
	@ObfuscatedName("af")
	@Export("nInUse")
	int nInUse;
	@ObfuscatedName("be")
	@Export("inUse")
	boolean[] inUse;
	@ObfuscatedName("bd")
	@Export("inUse16")
	boolean[] inUse16;
	@ObfuscatedName("bl")
	@Export("seqToUnseq")
	byte[] seqToUnseq;
	@ObfuscatedName("bi")
	@Export("ll8")
	byte[] ll8;
	@ObfuscatedName("bv")
	@Export("getAndMoveToFrontDecode_yy")
	int[] getAndMoveToFrontDecode_yy;
	@ObfuscatedName("bf")
	@Export("selector")
	byte[] selector;
	@ObfuscatedName("bg")
	@Export("selectorMtf")
	byte[] selectorMtf;
	@ObfuscatedName("ba")
	@Export("temp_charArray2d")
	byte[][] temp_charArray2d;
	@ObfuscatedName("bm")
	@Export("limit")
	int[][] limit;
	@ObfuscatedName("bp")
	@Export("base")
	int[][] base;
	@ObfuscatedName("bw")
	@Export("perm")
	int[][] perm;
	@ObfuscatedName("bj")
	@Export("minLens")
	int[] minLens;
	@ObfuscatedName("bn")
	int field4218;

	BZip2State() {
		this.field4230 = 4096;
		this.field4227 = 16;
		this.field4229 = 258;
		this.field4228 = 6;
		this.field4226 = 50;
		this.field4231 = 18002;
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