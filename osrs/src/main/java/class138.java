import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fj")
public enum class138 implements class372 {
	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "Lfj;"
	)
	field1301(0, 0),
	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "Lfj;"
	)
	field1302(1, 1),
	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "Lfj;"
	)
	field1298(2, 2),
	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "Lfj;"
	)
	field1297(3, 3),
	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "Lfj;"
	)
	field1299(4, 4),
	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		descriptor = "Lfj;"
	)
	field1296(5, 5),
	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		descriptor = "Lfj;"
	)
	field1295(6, 6),
	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "Lfj;"
	)
	field1303(7, 7),
	@ObfuscatedName("av")
	@ObfuscatedSignature(
		descriptor = "Lfj;"
	)
	field1300(8, 8);

	@ObfuscatedName("ap")
	final int field1304;
	@ObfuscatedName("aq")
	final int field1305;

	class138(int var3, int var4) {
		this.field1304 = var3;
		this.field1305 = var4;
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "1644350448"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.field1305;
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(B)Lrm;",
		garbageValue = "16"
	)
	public static class451 method744() {
		synchronized(class451.field3860) {
			if (class451.field3858 == 0) {
				return new class451();
			} else {
				class451.field3860[--class451.field3858].method2275();
				return class451.field3860[class451.field3858];
			}
		}
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(I)[Llx;",
		garbageValue = "1787686386"
	)
	static LoginPacket[] method743() {
		return new LoginPacket[]{LoginPacket.field2726, LoginPacket.field2724, LoginPacket.field2727, LoginPacket.field2725, LoginPacket.RECONNECT_LOGIN_CONNECTION, LoginPacket.NEW_LOGIN_CONNECTION};
	}
}
