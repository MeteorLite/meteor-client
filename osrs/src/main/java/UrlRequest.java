import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.net.URL;

@ObfuscatedName("et")
@Implements("UrlRequest")
public class UrlRequest {
	@ObfuscatedName("ae")
	static int field1175;
	@ObfuscatedName("ao")
	static int field1176;
	@ObfuscatedName("ad")
	public static short[] field1174;
	@ObfuscatedName("au")
	final URL field1177;
	@ObfuscatedName("at")
	volatile int field1179;
	@ObfuscatedName("ac")
	@Export("response0")
	volatile byte[] response0;

	static {
		field1175 = -1;
		field1176 = -2;
	}

	UrlRequest(URL var1) {
		this.field1179 = field1175;
		this.field1177 = var1;
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "1941771443"
	)
	@Export("isDone")
	public boolean isDone() {
		return this.field1179 != field1175;
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(I)[B",
		garbageValue = "-90219734"
	)
	@Export("getResponse")
	public byte[] getResponse() {
		return this.response0;
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(I)Ljava/lang/String;",
		garbageValue = "79865594"
	)
	public String method667() {
		return this.field1177.toString();
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(I)[Lnb;",
		garbageValue = "2139207855"
	)
	public static GameBuild[] method664() {
		return new GameBuild[]{GameBuild.LIVE, GameBuild.RC, GameBuild.WIP, GameBuild.BUILDLIVE};
	}
}