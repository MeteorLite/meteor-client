import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.Date;

@ObfuscatedName("ip")
@Implements("MoveSpeed")
public enum MoveSpeed implements class386 {
	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "Lip;"
	)
	@Export("STATIONARY")
	STATIONARY((byte)-1),
	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "Lip;"
	)
	@Export("CRAWL")
	CRAWL((byte)0),
	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "Lip;"
	)
	@Export("WALK")
	WALK((byte)1),
	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "Lip;"
	)
	@Export("RUN")
	RUN((byte)2);

	@ObfuscatedName("ao")
	@Export("speed")
	public byte speed;

	MoveSpeed(byte var3) {
		this.speed = var3;
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "-1243971674"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.speed;
	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "(Ljava/util/Date;B)Z",
		garbageValue = "-81"
	)
	static boolean method1187(Date var0) {
		Date var1 = class314.method1652();
		return var0.after(var1);
	}

	@ObfuscatedName("of")
	@ObfuscatedSignature(
		descriptor = "(Lnm;IB)Ljava/lang/String;",
		garbageValue = "-29"
	)
	static String method1188(Widget var0, int var1) {
		int var3 = MouseRecorder.getWidgetFlags(var0);
		boolean var2 = (var3 >> var1 + 1 & 1) != 0;
		if (!var2 && var0.onOp == null) {
			return null;
		} else {
			return var0.actions != null && var0.actions.length > var1 && var0.actions[var1] != null && var0.actions[var1].trim().length() != 0 ? var0.actions[var1] : null;
		}
	}
}