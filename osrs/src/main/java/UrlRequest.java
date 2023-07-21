import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ei")
@Implements("UrlRequest")
public class UrlRequest {
	@ObfuscatedName("ay")
	static int field1162;
	@ObfuscatedName("ar")
	static int field1161;
	@ObfuscatedName("aw")
	final URL field1163;
	@ObfuscatedName("am")
	volatile int field1165;
	@ObfuscatedName("as")
	@Export("response0")
	volatile byte[] response0;

	static {
		field1162 = -1;
		field1161 = -2;
	}

	UrlRequest(URL var1) {
		this.field1165 = field1162;
		this.field1163 = var1;
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "-1097483800"
	)
	@Export("isDone")
	public boolean isDone() {
		return this.field1165 != field1162;
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(I)[B",
		garbageValue = "114961803"
	)
	@Export("getResponse")
	public byte[] getResponse() {
		return this.response0;
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(I)Ljava/lang/String;",
		garbageValue = "-1911821505"
	)
	public String method660() {
		return this.field1163.toString();
	}

	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		descriptor = "(IB)I",
		garbageValue = "12"
	)
	public static int method657(int var0) {
		--var0;
		var0 |= var0 >>> 1;
		var0 |= var0 >>> 2;
		var0 |= var0 >>> 4;
		var0 |= var0 >>> 8;
		var0 |= var0 >>> 16;
		return var0 + 1;
	}

	@ObfuscatedName("nl")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;ZB)Ljava/lang/String;",
		garbageValue = "80"
	)
	static String method661(String var0, boolean var1) {
		String var2 = var1 ? "https://" : "http://";
		if (Client.gameBuild == 1) {
			var0 = var0 + "-wtrc";
		} else if (Client.gameBuild == 2) {
			var0 = var0 + "-wtqa";
		} else if (Client.gameBuild == 3) {
			var0 = var0 + "-wtwip";
		} else if (Client.gameBuild == 5) {
			var0 = var0 + "-wti";
		} else if (Client.gameBuild == 4) {
			var0 = "local";
		}

		String var3 = "";
		if (class36.param9 != null) {
			var3 = "/p=" + class36.param9;
		}

		String var4 = "runescape.com";
		return var2 + var0 + "." + var4 + "/l=" + Interpreter.clientLanguage + "/a=" + PcmPlayer.field182 + var3 + "/";
	}
}
