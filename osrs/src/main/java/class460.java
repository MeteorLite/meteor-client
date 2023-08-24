import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("re")
public class class460 {
	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "Lre;"
	)
	public static final class460 field3901;
	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "Lre;"
	)
	static final class460 field3902;
	@ObfuscatedName("ao")
	String field3903;

	static {
		field3901 = new class460("application/json");
		field3902 = new class460("text/plain");
	}

	class460(String var1) {
		this.field3903 = var1;
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(I)Ljava/lang/String;",
		garbageValue = "-1631262328"
	)
	public String method2331() {
		return this.field3903;
	}

	@ObfuscatedName("kf")
	@ObfuscatedSignature(
		descriptor = "(IIIIII)Z",
		garbageValue = "1329235005"
	)
	static final boolean method2332(int var0, int var1, int var2, int var3, int var4) {
		PendingSpawn var5 = null;

		for (PendingSpawn var6 = (PendingSpawn)Client.pendingSpawns.last(); var6 != null; var6 = (PendingSpawn)Client.pendingSpawns.previous()) {
			if (var0 == var6.plane && var6.x == var1 && var2 == var6.y && var3 == var6.type) {
				var5 = var6;
				break;
			}
		}

		if (var5 != null) {
			var5.field945 = var4;
			return true;
		} else {
			return false;
		}
	}
}