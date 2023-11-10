import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("da")
public class class92 {
	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "Lda;"
	)
	static final class92 field942;
	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "Lda;"
	)
	static final class92 field935;
	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "Lda;"
	)
	static final class92 field940;
	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "Lda;"
	)
	static final class92 field938;
	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "Lda;"
	)
	static final class92 field933;
	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "Lda;"
	)
	static final class92 field943;
	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "Lda;"
	)
	static final class92 field932;
	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "Lda;"
	)
	static final class92 field934;
	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "Lda;"
	)
	static final class92 field937;
	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "Lda;"
	)
	static final class92 field947;
	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		descriptor = "Lda;"
	)
	static final class92 field939;
	@ObfuscatedName("av")
	@ObfuscatedSignature(
		descriptor = "Lda;"
	)
	static final class92 field944;
	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "Lda;"
	)
	static final class92 field945;
	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "Lda;"
	)
	static final class92 field941;
	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "Lda;"
	)
	static final class92 field946;
	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "Lda;"
	)
	static final class92 field936;

	static {
		field942 = new class92();
		field935 = new class92();
		field940 = new class92();
		field938 = new class92();
		field933 = new class92();
		field943 = new class92();
		field932 = new class92();
		field934 = new class92();
		field937 = new class92();
		field947 = new class92();
		field939 = new class92();
		field944 = new class92();
		field945 = new class92();
		field941 = new class92();
		field946 = new class92();
		field936 = new class92();
	}

	class92() {
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(II)Lgh;",
		garbageValue = "-1228219586"
	)
	public static HealthBarDefinition method497(int var0) {
		HealthBarDefinition var1 = (HealthBarDefinition)HealthBarDefinition.HealthBarDefinition_cached.get((long)var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = HealthBarDefinition.HealthBarDefinition_archive.takeFile(33, var0);
			var1 = new HealthBarDefinition();
			var1.field1494 = var0;
			if (var2 != null) {
				var1.decode(new Buffer(var2));
			}

			HealthBarDefinition.HealthBarDefinition_cached.put(var1, (long)var0);
			return var1;
		}
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(II)I",
		garbageValue = "1040473159"
	)
	static int method498(int var0) {
		Message var1 = (Message)Messages.Messages_hashTable.get((long)var0);
		if (var1 == null) {
			return -1;
		} else {
			return var1.nextDual == Messages.Messages_queue.sentinel ? -1 : ((Message)var1.nextDual).count;
		}
	}

	@ObfuscatedName("jv")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "124"
	)
	static void method499() {
		if (class229.localPlayer.x >> 7 == Client.destinationX && class229.localPlayer.y >> 7 == Client.destinationY) {
			Client.destinationX = 0;
		}

	}
}