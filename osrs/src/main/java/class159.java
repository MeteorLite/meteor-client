import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gm")
public abstract class class159 extends Node {
	@ObfuscatedName("qw")
	@Export("widgetDragDuration")
	static int widgetDragDuration;

	class159() {
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(Ltm;B)V",
		garbageValue = "1"
	)
	@Export("vmethod3238")
	abstract void vmethod3238(Buffer var1);

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(Lgo;I)V",
		garbageValue = "831405774"
	)
	abstract void vmethod3239(ClanChannel var1);

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(II)Ltc;",
		garbageValue = "-2141629898"
	)
	@Export("getDbRowType")
	public static DbRowType getDbRowType(int var0) {
		DbRowType var1 = (DbRowType)DbRowType.DBRowType_cache.get((long)var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = DbRowType.field4116.takeFile(38, var0);
			var1 = new DbRowType();
			if (var2 != null) {
				var1.method2508(new Buffer(var2));
			}

			var1.method2511();
			DbRowType.DBRowType_cache.put(var1, (long)var0);
			return var1;
		}
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(IB)Ltk;",
		garbageValue = "44"
	)
	@Export("getDbTableType")
	public static DbTableType getDbTableType(int var0) {
		DbTableType var1 = (DbTableType)DbTableType.DBTableType_cache.get((long)var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = DbTableType.field4110.takeFile(39, var0);
			var1 = new DbTableType();
			if (var2 != null) {
				var1.method2503(new Buffer(var2));
			}

			var1.method2505();
			DbTableType.DBTableType_cache.put(var1, (long)var0);
			return var1;
		}
	}
}