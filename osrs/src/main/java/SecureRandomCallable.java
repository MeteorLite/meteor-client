import java.util.concurrent.Callable;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bq")
@Implements("SecureRandomCallable")
public class SecureRandomCallable implements Callable {
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = -1101640601
	)
	@Export("SpriteBuffer_spriteWidth")
	public static int SpriteBuffer_spriteWidth;

	SecureRandomCallable() {
	}

	public Object call() {
		return class271.method5377();
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		descriptor = "(II)Lpl;",
		garbageValue = "1045421766"
	)
	public static class439 method2201(int var0) {
		class439 var1 = (class439)class439.DBRowType_cache.get((long)var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = class439.field4718.takeFile(38, var0);
			var1 = new class439();
			if (var2 != null) {
				var1.method7830(new Buffer(var2));
			}

			var1.method7829();
			class439.DBRowType_cache.put(var1, (long)var0);
			return var1;
		}
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V",
		garbageValue = "1277193517"
	)
	@Export("setLoginResponseString")
	static void setLoginResponseString(String var0, String var1, String var2) {
		Login.Login_response1 = var0;
		Login.Login_response2 = var1;
		Login.Login_response3 = var2;
	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "(ILbt;ZI)I",
		garbageValue = "1555404404"
	)
	static int method2206(int var0, Script var1, boolean var2) {
		if (var0 == 7463) {
			boolean var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
			class12.method164(var3);
			return 1;
		} else {
			return 2;
		}
	}

	@ObfuscatedName("lz")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;ZI)Ljava/lang/String;",
		garbageValue = "699416183"
	)
	static String method2205(String var0, boolean var1) {
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
		if (AttackOption.field1279 != null) {
			var3 = "/p=" + AttackOption.field1279;
		}

		String var4 = "runescape.com";
		return var2 + var0 + "." + var4 + "/l=" + class271.clientLanguage + "/a=" + UserComparator10.field1393 + var3 + "/";
	}
}
