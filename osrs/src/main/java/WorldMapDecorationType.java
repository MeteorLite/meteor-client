import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.Iterator;

@ObfuscatedName("nl")
@Implements("WorldMapDecorationType")
public enum WorldMapDecorationType implements class386 {
	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "Lnl;"
	)
	field3150(0, 0),
	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "Lnl;"
	)
	field3162(1, 0),
	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "Lnl;"
	)
	field3151(2, 0),
	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "Lnl;"
	)
	field3153(3, 0),
	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "Lnl;"
	)
	field3152(9, 2),
	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "Lnl;"
	)
	field3159(4, 1),
	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "Lnl;"
	)
	field3167(5, 1),
	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "Lnl;"
	)
	field3156(6, 1),
	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "Lnl;"
	)
	field3163(7, 1),
	@ObfuscatedName("av")
	@ObfuscatedSignature(
		descriptor = "Lnl;"
	)
	field3170(8, 1),
	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		descriptor = "Lnl;"
	)
	field3158(12, 2),
	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "Lnl;"
	)
	field3155(13, 2),
	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		descriptor = "Lnl;"
	)
	field3165(14, 2),
	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "Lnl;"
	)
	field3172(15, 2),
	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "Lnl;"
	)
	field3168(16, 2),
	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		descriptor = "Lnl;"
	)
	field3161(17, 2),
	@ObfuscatedName("an")
	@ObfuscatedSignature(
		descriptor = "Lnl;"
	)
	field3164(18, 2),
	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "Lnl;"
	)
	field3169(19, 2),
	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		descriptor = "Lnl;"
	)
	field3160(20, 2),
	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "Lnl;"
	)
	field3157(21, 2),
	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "Lnl;"
	)
	field3171(10, 2),
	@ObfuscatedName("aq")
	@ObfuscatedSignature(
		descriptor = "Lnl;"
	)
	field3166(11, 2),
	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "Lnl;"
	)
	field3173(22, 3);

	@ObfuscatedName("gl")
	@ObfuscatedSignature(
		descriptor = "Lok;"
	)
	static Archive field3154;
	@ObfuscatedName("at")
	@Export("id")
	public final int id;

	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "0"
	)
	WorldMapDecorationType(int var3, int var4) {
		this.id = var3;
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "-1243971674"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.id;
	}

	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "(IIB)V",
		garbageValue = "0"
	)
	public static void method1897(int var0, int var1) {
		Iterator var2 = class319.field2792.iterator();

		while (var2.hasNext()) {
			class325 var3 = (class325)var2.next();
			var3.vmethod1644(var0, var1);
		}

	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-1905325743"
	)
	public static void method1898() {
		synchronized(ArchiveDiskActionHandler.field3545) {
			if (ArchiveDiskActionHandler.field3544 != 0) {
				ArchiveDiskActionHandler.field3544 = 1;
				ArchiveDiskActionHandler.field3543 = true;

				try {
					ArchiveDiskActionHandler.field3545.wait();
				} catch (InterruptedException var3) {
				}
			}

		}
	}
}