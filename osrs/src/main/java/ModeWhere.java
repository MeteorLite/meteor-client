import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.HashSet;
import java.util.Set;

@ObfuscatedName("or")
@Implements("ModeWhere")
public enum ModeWhere implements class386 {
	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "Lor;"
	)
	field3654("", 0, new class385[]{class385.field3638, class385.field3635}),
	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "Lor;"
	)
	field3658("", 1, new class385[]{class385.field3636, class385.field3638, class385.field3635}),
	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "Lor;"
	)
	field3657("", 2, new class385[]{class385.field3636, class385.field3637, class385.field3638}),
	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "Lor;"
	)
	field3664("", 3, new class385[]{class385.field3636}),
	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "Lor;"
	)
	field3660("", 4),
	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "Lor;"
	)
	field3656("", 5, new class385[]{class385.field3636, class385.field3638}),
	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "Lor;"
	)
	field3662("", 6, new class385[]{class385.field3638}),
	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "Lor;"
	)
	field3653("", 8, new class385[]{class385.field3636, class385.field3638}),
	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "Lor;"
	)
	field3659("", 9, new class385[]{class385.field3636, class385.field3637}),
	@ObfuscatedName("av")
	@ObfuscatedSignature(
		descriptor = "Lor;"
	)
	field3663("", 10, new class385[]{class385.field3636}),
	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		descriptor = "Lor;"
	)
	field3655("", 11, new class385[]{class385.field3636}),
	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "Lor;"
	)
	field3652("", 12, new class385[]{class385.field3636, class385.field3638}),
	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		descriptor = "Lor;"
	)
	field3661("", 13, new class385[]{class385.field3636});

	@ObfuscatedName("ay")
	@Export("id")
	final int id;
	@ObfuscatedName("as")
	final Set field3666;

	static {
		$values$();
	}

	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;I[Loi;)V"
	)
	ModeWhere(String var3, int var4, class385[] var5) {
		this.field3666 = new HashSet();
		this.id = var4;
		class385[] var6 = var5;

		for (int var7 = 0; var7 < var6.length; ++var7) {
			class385 var8 = var6[var7];
			this.field3666.add(var8);
		}

	}

	ModeWhere(String var3, int var4) {
		this.field3666 = new HashSet();
		this.id = var4;
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

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "(III)I",
		garbageValue = "-1022385277"
	)
	public static int method2011(int var0, int var1) {
		int var2;
		if (var1 > var0) {
			var2 = var0;
			var0 = var1;
			var1 = var2;
		}

		while (var1 != 0) {
			var2 = var0 % var1;
			var0 = var1;
			var1 = var2;
		}

		return var0;
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(B)[Lor;",
		garbageValue = "28"
	)
	@Export("$values$")
	static ModeWhere[] $values$() {
		return new ModeWhere[]{field3652, field3653, field3658, field3660, field3657, field3659, field3664, field3655, field3663, field3662, field3661, field3654, field3656};
	}

	@ObfuscatedName("ik")
	@ObfuscatedSignature(
		descriptor = "(Lif;IIIS)V",
		garbageValue = "-16278"
	)
	static void method2013(SequenceDefinition var0, int var1, int var2, int var3) {
		if (Client.soundEffectCount < 50 && class91.clientPreferences.getAreaSoundEffectsVolume() != 0) {
			if (var0.animMayaFrameSounds != null && var0.animMayaFrameSounds.containsKey(var1)) {
				class91.method482((Integer)var0.animMayaFrameSounds.get(var1), var2, var3);
			}
		}
	}

	@ObfuscatedName("jv")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "-2030592343"
	)
	static boolean method2014() {
		return (Client.drawPlayerNames & 1) != 0;
	}
}