import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("uo")
@Implements("BZip2State")
public final class BZip2State {
	@ObfuscatedName("ac")
	final int field4224;
	@ObfuscatedName("al")
	final int field4227;
	@ObfuscatedName("ak")
	final int field4226;
	@ObfuscatedName("ax")
	final int field4229;
	@ObfuscatedName("ao")
	final int field4228;
	@ObfuscatedName("ah")
	final int field4225;
	@ObfuscatedName("ar")
	@Export("inputArray")
	byte[] inputArray;
	@ObfuscatedName("ab")
	@Export("nextByte")
	int nextByte;
	@ObfuscatedName("am")
	@Export("nextBit_unused")
	int nextBit_unused;
	@ObfuscatedName("av")
	@Export("outputArray")
	byte[] outputArray;
	@ObfuscatedName("ag")
	@Export("next_out")
	int next_out;
	@ObfuscatedName("aa")
	@Export("outputLength")
	int outputLength;
	@ObfuscatedName("ap")
	int field4211;
	@ObfuscatedName("ay")
	@Export("out_char")
	byte out_char;
	@ObfuscatedName("as")
	@Export("su_rNToGo")
	int su_rNToGo;
	@ObfuscatedName("aj")
	@Export("bsBuff")
	int bsBuff;
	@ObfuscatedName("an")
	@Export("bsLive")
	int bsLive;
	@ObfuscatedName("au")
	@Export("blockSize100k")
	int blockSize100k;
	@ObfuscatedName("ai")
	@Export("originalPointer")
	int originalPointer;
	@ObfuscatedName("ae")
	int field4205;
	@ObfuscatedName("aw")
	@Export("su_ch2")
	int su_ch2;
	@ObfuscatedName("aq")
	@Export("unzftab")
	int[] unzftab;
	@ObfuscatedName("az")
	@Export("nblocks_used")
	int nblocks_used;
	@ObfuscatedName("at")
	@Export("cftab")
	int[] cftab;
	@ObfuscatedName("ad")
	@Export("nInUse")
	int nInUse;
	@ObfuscatedName("bn")
	@Export("inUse")
	boolean[] inUse;
	@ObfuscatedName("bk")
	@Export("inUse16")
	boolean[] inUse16;
	@ObfuscatedName("by")
	@Export("seqToUnseq")
	byte[] seqToUnseq;
	@ObfuscatedName("bd")
	@Export("ll8")
	byte[] ll8;
	@ObfuscatedName("be")
	@Export("getAndMoveToFrontDecode_yy")
	int[] getAndMoveToFrontDecode_yy;
	@ObfuscatedName("bv")
	@Export("selector")
	byte[] selector;
	@ObfuscatedName("ba")
	@Export("selectorMtf")
	byte[] selectorMtf;
	@ObfuscatedName("bz")
	@Export("temp_charArray2d")
	byte[][] temp_charArray2d;
	@ObfuscatedName("bb")
	@Export("limit")
	int[][] limit;
	@ObfuscatedName("bo")
	@Export("base")
	int[][] base;
	@ObfuscatedName("bp")
	@Export("perm")
	int[][] perm;
	@ObfuscatedName("bt")
	@Export("minLens")
	int[] minLens;
	@ObfuscatedName("bm")
	int field4216;

	BZip2State() {
		this.field4224 = 4096;
		this.field4227 = 16;
		this.field4226 = 258;
		this.field4229 = 6;
		this.field4228 = 50;
		this.field4225 = 18002;
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