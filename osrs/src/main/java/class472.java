import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("si")
public class class472 {
	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "Lsi;"
	)
	public static final class472 field3931;
	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "Lsi;"
	)
	static final class472 field3932;
	@ObfuscatedName("ar")
	String field3933;

	static {
		field3931 = new class472("application/json");
		field3932 = new class472("text/plain");
	}

	class472(String var1) {
		this.field3933 = var1;
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(I)Ljava/lang/String;",
		garbageValue = "1925429052"
	)
	public String method2348() {
		return this.field3933;
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(II)Ltu;",
		garbageValue = "-2020292957"
	)
	public static class514 method2349(int var0) {
		int var1 = class512.field4123[var0];
		if (var1 == 1) {
			return class514.field4126;
		} else if (var1 == 2) {
			return class514.field4125;
		} else {
			return var1 == 3 ? class514.field4124 : null;
		}
	}

	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-2006289317"
	)
	public static void method2350() {
		class316.field2787.clear();
	}

	@ObfuscatedName("kn")
	@ObfuscatedSignature(
		descriptor = "(Luo;B)V",
		garbageValue = "-41"
	)
	static final void method2351(PacketBuffer var0) {
		var0.importIndex();
		int var1 = var0.readBits(8);
		int var2;
		if (var1 < Client.npcCount) {
			for (var2 = var1; var2 < Client.npcCount; ++var2) {
				Client.field559[++Client.field489 - 1] = Client.npcIndices[var2];
			}
		}

		if (var1 > Client.npcCount) {
			throw new RuntimeException("");
		} else {
			Client.npcCount = 0;

			for (var2 = 0; var2 < var1; ++var2) {
				int var3 = Client.npcIndices[var2];
				NPC var4 = Client.npcs[var3];
				int var5 = var0.readBits(1);
				if (var5 == 0) {
					Client.npcIndices[++Client.npcCount - 1] = var3;
					var4.npcCycle = Client.cycle;
				} else {
					int var6 = var0.readBits(2);
					if (var6 == 0) {
						Client.npcIndices[++Client.npcCount - 1] = var3;
						var4.npcCycle = Client.cycle;
						Client.field550[++Client.field449 - 1] = var3;
					} else {
						int var7;
						int var8;
						if (var6 == 1) {
							Client.npcIndices[++Client.npcCount - 1] = var3;
							var4.npcCycle = Client.cycle;
							var7 = var0.readBits(3);
							var4.move(var7, MoveSpeed.WALK);
							var8 = var0.readBits(1);
							if (var8 == 1) {
								Client.field550[++Client.field449 - 1] = var3;
							}
						} else if (var6 == 2) {
							Client.npcIndices[++Client.npcCount - 1] = var3;
							var4.npcCycle = Client.cycle;
							if (var0.readBits(1) == 1) {
								var7 = var0.readBits(3);
								var4.move(var7, MoveSpeed.RUN);
								var8 = var0.readBits(3);
								var4.move(var8, MoveSpeed.RUN);
							} else {
								var7 = var0.readBits(3);
								var4.move(var7, MoveSpeed.CRAWL);
							}

							var7 = var0.readBits(1);
							if (var7 == 1) {
								Client.field550[++Client.field449 - 1] = var3;
							}
						} else if (var6 == 3) {
							Client.field559[++Client.field489 - 1] = var3;
						}
					}
				}
			}

		}
	}
}