import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.io.File;

@ObfuscatedName("gp")
@Implements("JagexCache")
public class JagexCache {
	@ObfuscatedName("at")
	static File field1463;
	@ObfuscatedName("ac")
	@Export("cacheDir")
	static File cacheDir;
	@ObfuscatedName("ai")
	static int field1461;
	@ObfuscatedName("aq")
	@ObfuscatedSignature(
		descriptor = "Ltd;"
	)
	@Export("JagexCache_randomDat")
	public static BufferedFile JagexCache_randomDat;
	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "Ltd;"
	)
	@Export("JagexCache_dat2File")
	public static BufferedFile JagexCache_dat2File;
	@ObfuscatedName("an")
	@ObfuscatedSignature(
		descriptor = "Ltd;"
	)
	@Export("JagexCache_idx255File")
	public static BufferedFile JagexCache_idx255File;
	@ObfuscatedName("ab")
	@Export("cacheGamebuild")
	static int cacheGamebuild;
	@ObfuscatedName("am")
	static String[] field1464;

	static {
		JagexCache_randomDat = null;
		JagexCache_dat2File = null;
		JagexCache_idx255File = null;
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(II)I",
		garbageValue = "-812306716"
	)
	static int method909(int var0) {
		return class28.KeyHandler_keyCodes[var0];
	}
}