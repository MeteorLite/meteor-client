import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.HashMap;
import java.util.Map;

@ObfuscatedName("eo")
@Implements("Messages")
public class Messages {
	@ObfuscatedName("at")
	@Export("Messages_channels")
	static final Map Messages_channels;
	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "Ltz;"
	)
	@Export("Messages_hashTable")
	static final IterableNodeHashTable Messages_hashTable;
	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "Lpo;"
	)
	@Export("Messages_queue")
	static final IterableDualNodeQueue Messages_queue;
	@ObfuscatedName("ao")
	@Export("Messages_count")
	static int Messages_count;
	@ObfuscatedName("cx")
	@ObfuscatedSignature(
		descriptor = "Lnt;"
	)
	static StudioGame field1156;
	@ObfuscatedName("gk")
	static String field1155;
	@ObfuscatedName("uu")
	@Export("cameraLookAtX")
	static int cameraMoveToX;

	static {
		Messages_channels = new HashMap();
		Messages_hashTable = new IterableNodeHashTable(1024);
		Messages_queue = new IterableDualNodeQueue();
		Messages_count = 0;
	}

	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		descriptor = "(IIII)I",
		garbageValue = "292264125"
	)
	static final int method634(int var0, int var1, int var2) {
		if (var2 > 179) {
			var1 /= 2;
		}

		if (var2 > 192) {
			var1 /= 2;
		}

		if (var2 > 217) {
			var1 /= 2;
		}

		if (var2 > 243) {
			var1 /= 2;
		}

		int var3 = (var1 / 32 << 7) + (var0 / 4 << 10) + var2 / 2;
		return var3;
	}
}