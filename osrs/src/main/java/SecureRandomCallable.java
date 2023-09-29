import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.security.SecureRandom;
import java.util.concurrent.Callable;

@ObfuscatedName("dz")
@Implements("SecureRandomCallable")
public class SecureRandomCallable implements Callable {
	@ObfuscatedName("dq")
	@ObfuscatedSignature(
		descriptor = "[Lud;"
	)
	@Export("worldSelectBackSprites")
	static SpritePixels[] worldSelectBackSprites;
	@ObfuscatedName("uo")
	@Export("cameraMoveToSpeed")
	static int cameraMoveToSpeed;

	SecureRandomCallable() {
	}

	@Export("call")
	@ObfuscatedName("call")
	public Object call() {
		SecureRandom var2 = new SecureRandom();
		var2.nextInt();
		return var2;
	}

	@ObfuscatedName("oy")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-2097515012"
	)
	static void method458() {
		if (WallDecoration.field2303 != null) {
			Client.field368 = Client.cycle;
			WallDecoration.field2303.method1998();

			for (int var0 = 0; var0 < Client.players.length; ++var0) {
				if (Client.players[var0] != null) {
					WallDecoration.field2303.method1997((Client.players[var0].x >> 7) + class20.baseX, (Client.players[var0].y >> 7) + class19.baseY);
				}
			}
		}

	}
}