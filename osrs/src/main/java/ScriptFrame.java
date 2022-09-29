import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bi")
@Implements("ScriptFrame")
public class ScriptFrame {
	@ObfuscatedName("fx")
	@ObfuscatedGetter(
		intValue = 1366507483
	)
	static int field464;
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "Lbt;"
	)
	@Export("script")
	Script script;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = -1591927667
	)
	@Export("pc")
	int pc;
	@ObfuscatedName("f")
	@Export("intLocals")
	int[] intLocals;
	@ObfuscatedName("n")
	@Export("stringLocals")
	String[] stringLocals;

	ScriptFrame() {
		this.pc = -1;
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		descriptor = "([BIIB)Ljava/lang/String;",
		garbageValue = "1"
	)
	@Export("decodeStringCp1252")
	public static String decodeStringCp1252(byte[] var0, int var1, int var2) {
		char[] var3 = new char[var2];
		int var4 = 0;

		for (int var5 = 0; var5 < var2; ++var5) {
			int var6 = var0[var5 + var1] & 255;
			if (var6 != 0) {
				if (var6 >= 128 && var6 < 160) {
					char var7 = class342.cp1252AsciiExtension[var6 - 128];
					if (var7 == 0) {
						var7 = '?';
					}

					var6 = var7;
				}

				var3[var4++] = (char)var6;
			}
		}

		return new String(var3, 0, var4);
	}

	@ObfuscatedName("ir")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-585468309"
	)
	static final void method1133() {
		for (PendingSpawn var0 = (PendingSpawn)Client.pendingSpawns.last(); var0 != null; var0 = (PendingSpawn)Client.pendingSpawns.previous()) {
			if (var0.hitpoints == -1) {
				var0.delay = 0;
				class20.method302(var0);
			} else {
				var0.remove();
			}
		}

	}

	@ObfuscatedName("kj")
	@ObfuscatedSignature(
		descriptor = "(Lkw;B)V",
		garbageValue = "23"
	)
	static final void method1134(Widget var0) {
		int var1 = var0.contentType;
		if (var1 == 324) {
			if (Client.field566 == -1) {
				Client.field566 = var0.spriteId2;
				Client.field715 = var0.spriteId;
			}

			if (Client.playerAppearance.isFemale) {
				var0.spriteId2 = Client.field566;
			} else {
				var0.spriteId2 = Client.field715;
			}

		} else if (var1 == 325) {
			if (Client.field566 == -1) {
				Client.field566 = var0.spriteId2;
				Client.field715 = var0.spriteId;
			}

			if (Client.playerAppearance.isFemale) {
				var0.spriteId2 = Client.field715;
			} else {
				var0.spriteId2 = Client.field566;
			}

		} else if (var1 == 327) {
			var0.modelAngleX = 150;
			var0.modelAngleY = (int)(Math.sin((double)Client.cycle / 40.0D) * 256.0D) & 2047;
			var0.modelType = 5;
			var0.modelId = 0;
		} else if (var1 == 328) {
			var0.modelAngleX = 150;
			var0.modelAngleY = (int)(Math.sin((double)Client.cycle / 40.0D) * 256.0D) & 2047;
			var0.modelType = 5;
			var0.modelId = 1;
		}
	}
}
