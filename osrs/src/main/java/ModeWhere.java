import java.util.HashSet;
import java.util.Set;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ox")
@Implements("ModeWhere")
public enum ModeWhere implements class372 {
	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "Lox;"
	)
	field3615("", 0, new class371[]{class371.field3585, class371.field3587}),
	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "Lox;"
	)
	field3616("", 1, new class371[]{class371.field3586, class371.field3585, class371.field3587}),
	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "Lox;"
	)
	field3611("", 2, new class371[]{class371.field3586, class371.field3588, class371.field3585}),
	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "Lox;"
	)
	field3608("", 3, new class371[]{class371.field3586}),
	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "Lox;"
	)
	field3612("", 4),
	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		descriptor = "Lox;"
	)
	field3607("", 5, new class371[]{class371.field3586, class371.field3585}),
	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		descriptor = "Lox;"
	)
	field3605("", 6, new class371[]{class371.field3585}),
	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "Lox;"
	)
	field3617("", 8, new class371[]{class371.field3586, class371.field3585}),
	@ObfuscatedName("av")
	@ObfuscatedSignature(
		descriptor = "Lox;"
	)
	field3614("", 9, new class371[]{class371.field3586, class371.field3588}),
	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		descriptor = "Lox;"
	)
	field3609("", 10, new class371[]{class371.field3586}),
	@ObfuscatedName("aq")
	@ObfuscatedSignature(
		descriptor = "Lox;"
	)
	field3610("", 11, new class371[]{class371.field3586}),
	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "Lox;"
	)
	field3613("", 12, new class371[]{class371.field3586, class371.field3585}),
	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "Lox;"
	)
	field3606("", 13, new class371[]{class371.field3586});

	@ObfuscatedName("ug")
	static int field3604;
	@ObfuscatedName("ng")
	@Export("menuHeight")
	static int menuHeight;
	@ObfuscatedName("uc")
	static int cameraMoveToHeight;
	@ObfuscatedName("ax")
	@Export("id")
	final int id;
	@ObfuscatedName("aa")
	final Set field3619;

	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;I[Loe;)V"
	)
	ModeWhere(String var3, int var4, class371[] var5) {
		this.field3619 = new HashSet();
		this.id = var4;
		class371[] var6 = var5;

		for (int var7 = 0; var7 < var6.length; ++var7) {
			class371 var8 = var6[var7];
			this.field3619.add(var8);
		}

	}

	ModeWhere(String var3, int var4) {
		this.field3619 = new HashSet();
		this.id = var4;
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "1644350448"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.id;
	}

	@ObfuscatedName("jl")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "-1069349497"
	)
	static boolean method1946() {
		return (Client.drawPlayerNames & 2) != 0;
	}
}
