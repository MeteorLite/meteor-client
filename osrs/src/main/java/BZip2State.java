import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("qg")
@Implements("BZip2State")
public final class BZip2State {
	@ObfuscatedName("a")
	final int field4897;
	@ObfuscatedName("f")
	final int field4906;
	@ObfuscatedName("c")
	final int field4874;
	@ObfuscatedName("x")
	final int field4904;
	@ObfuscatedName("h")
	final int field4876;
	@ObfuscatedName("j")
	final int field4877;
	@ObfuscatedName("y")
	@Export("inputArray")
	byte[] inputArray;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = 319853541
	)
	@Export("nextByte")
	int nextByte;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = 66344113
	)
	@Export("nextBit_unused")
	int nextBit_unused;
	@ObfuscatedName("r")
	@Export("outputArray")
	byte[] outputArray;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = -1237496315
	)
	@Export("next_out")
	int next_out;
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = -409923105
	)
	@Export("outputLength")
	int outputLength;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = -756614111
	)
	int field4884;
	@ObfuscatedName("b")
	@Export("out_char")
	byte out_char;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = -555947993
	)
	@Export("su_rNToGo")
	int su_rNToGo;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = -857144097
	)
	@Export("bsBuff")
	int bsBuff;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = -63773237
	)
	@Export("bsLive")
	int bsLive;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = -1460536320
	)
	@Export("blockSize100k")
	int blockSize100k;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = -1584521491
	)
	@Export("originalPointer")
	int originalPointer;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = -747859165
	)
	int field4891;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = 1755316433
	)
	@Export("su_ch2")
	int su_ch2;
	@ObfuscatedName("i")
	@Export("unzftab")
	int[] unzftab;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = 1896063491
	)
	@Export("nblocks_used")
	int nblocks_used;
	@ObfuscatedName("g")
	@Export("cftab")
	int[] cftab;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = 451668383
	)
	@Export("nInUse")
	int nInUse;
	@ObfuscatedName("aj")
	@Export("inUse")
	boolean[] inUse;
	@ObfuscatedName("an")
	@Export("inUse16")
	boolean[] inUse16;
	@ObfuscatedName("ah")
	@Export("seqToUnseq")
	byte[] seqToUnseq;
	@ObfuscatedName("ao")
	@Export("ll8")
	byte[] ll8;
	@ObfuscatedName("ac")
	@Export("getAndMoveToFrontDecode_yy")
	int[] getAndMoveToFrontDecode_yy;
	@ObfuscatedName("af")
	@Export("selector")
	byte[] selector;
	@ObfuscatedName("ad")
	@Export("selectorMtf")
	byte[] selectorMtf;
	@ObfuscatedName("av")
	@Export("temp_charArray2d")
	byte[][] temp_charArray2d;
	@ObfuscatedName("ak")
	@Export("limit")
	int[][] limit;
	@ObfuscatedName("ae")
	@Export("base")
	int[][] base;
	@ObfuscatedName("ap")
	@Export("perm")
	int[][] perm;
	@ObfuscatedName("as")
	@Export("minLens")
	int[] minLens;
	@ObfuscatedName("aq")
	@ObfuscatedGetter(
		intValue = -897288801
	)
	int field4909;

	BZip2State() {
		this.field4897 = 4096;
		this.field4906 = 16;
		this.field4874 = 258;
		this.field4904 = 6;
		this.field4876 = 50;
		this.field4877 = 18002;
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
