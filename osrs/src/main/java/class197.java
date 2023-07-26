import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hd")
public class class197 {
	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "Lhd;"
	)
	static final class197 field1627;
	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "Lhd;"
	)
	static final class197 field1628;
	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "Lhd;"
	)
	static final class197 field1625;
	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "Lhd;"
	)
	static final class197 field1624;
	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "Lhd;"
	)
	static final class197 field1626;
	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		descriptor = "Lhd;"
	)
	static final class197 field1623;
	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		descriptor = "Lhd;"
	)
	static final class197 field1622;
	@ObfuscatedName("fj")
	static long field1620;
	@ObfuscatedName("fd")
	@ObfuscatedSignature(
		descriptor = "Lny;"
	)
	@Export("archive2")
	static Archive archive2;

	static {
		field1627 = new class197(0, class210.field1838);
		field1628 = new class197(1, class210.field1837);
		field1625 = new class197(2, class210.field1836);
		field1624 = new class197(3, class210.field1833);
		field1626 = new class197(4, class210.field1834);
		field1623 = new class197(5, class210.field1839);
		field1622 = new class197(6, class210.field1835);
	}

	@ObfuscatedSignature(
		descriptor = "(ILis;)V"
	)
	class197(int var1, class210 var2) {
	}

	@ObfuscatedName("am")
	public static int method979(long var0) {
		return (int)(var0 >>> 7 & 127L);
	}

	@ObfuscatedName("he")
	@ObfuscatedSignature(
		descriptor = "(Lny;Ljava/lang/String;I)V",
		garbageValue = "1681789978"
	)
	static void method980(Archive var0, String var1) {
		ArchiveLoader var2 = new ArchiveLoader(var0, var1);
		Client.archiveLoaders.add(var2);
		Client.field548 += var2.groupCount;
	}

	@ObfuscatedName("ie")
	@ObfuscatedSignature(
		descriptor = "(Ldx;I)V",
		garbageValue = "-971627157"
	)
	static final void method981(Actor var0) {
		boolean var1 = var0.exactMoveArrive1Cycle == Client.cycle || var0.sequence == -1 || var0.sequenceDelay != 0;
		if (!var1) {
			SequenceDefinition var2 = class135.SequenceDefinition_get(var0.sequence);
			if (var2 != null && !var2.isCachedModelIdSet()) {
				var1 = var0.sequenceFrameCycle + 1 > var2.frameLengths[var0.sequenceFrame];
			} else {
				var1 = true;
			}
		}

		if (var1) {
			int var8 = var0.exactMoveArrive1Cycle - var0.spotAnimation;
			int var3 = Client.cycle - var0.spotAnimation;
			int var4 = var0.field976 * 64 + var0.field1013 * 128;
			int var5 = var0.field976 * 64 + var0.field1007 * 128;
			int var6 = var0.field976 * 64 + var0.field1011 * 128;
			int var7 = var0.field976 * 64 + var0.field1010 * 128;
			var0.x = (var3 * var6 + var4 * (var8 - var3)) / var8;
			var0.y = (var7 * var3 + var5 * (var8 - var3)) / var8;
		}

		var0.field1020 = 0;
		var0.orientation = var0.exactMoveDirection;
		var0.rotation = var0.orientation;
	}
}
