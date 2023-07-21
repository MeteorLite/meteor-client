import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fd")
public class class141 extends class143 {
	@ObfuscatedName("aw")
	long field1321;
	@ObfuscatedName("ay")
	String field1320;
	// $FF: synthetic field
	@ObfuscatedSignature(
		descriptor = "Lfr;"
	)
	@Export("this$0")
	@ObfuscatedName("this$0")
	final class146 this$0;

	@ObfuscatedSignature(
		descriptor = "(Lfr;)V"
	)
	class141(class146 var1) {
		this.this$0 = var1;
		this.field1321 = -1L;
		this.field1320 = null;
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(Lty;B)V",
		garbageValue = "1"
	)
	@Export("vmethod3254")
	void vmethod3254(Buffer var1) {
		if (var1.readUnsignedByte() != 255) {
			--var1.offset;
			this.field1321 = var1.readLong();
		}

		this.field1320 = var1.readStringCp1252NullTerminatedOrNull();
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(Lfx;B)V",
		garbageValue = "-72"
	)
	@Export("vmethod3248")
	void vmethod3248(ClanSettings var1) {
		var1.method808(this.field1321, this.field1320, 0);
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(Lty;Lsa;B)Lsa;",
		garbageValue = "-36"
	)
	@Export("readStringIntParameters")
	static final IterableNodeHashTable readStringIntParameters(Buffer var0, IterableNodeHashTable var1) {
		int var2 = var0.readUnsignedByte();
		int var3;
		if (var1 == null) {
			var3 = UrlRequest.method657(var2);
			var1 = new IterableNodeHashTable(var3);
		}

		for (var3 = 0; var3 < var2; ++var3) {
			boolean var4 = var0.readUnsignedByte() == 1;
			int var5 = var0.readMedium();
			Object var6;
			if (var4) {
				var6 = new ObjectNode(var0.readStringCp1252NullTerminated());
			} else {
				var6 = new IntegerNode(var0.readInt());
			}

			var1.put((Node)var6, (long)var5);
		}

		return var1;
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(Ltc;I)I",
		garbageValue = "-1334865028"
	)
	static int method753(PacketBuffer var0) {
		int var1 = var0.readBits(2);
		int var2;
		if (var1 == 0) {
			var2 = 0;
		} else if (var1 == 1) {
			var2 = var0.readBits(5);
		} else if (var1 == 2) {
			var2 = var0.readBits(8);
		} else {
			var2 = var0.readBits(11);
		}

		return var2;
	}

	@ObfuscatedName("je")
	@ObfuscatedSignature(
		descriptor = "(Ldx;II)V",
		garbageValue = "-1017792324"
	)
	static final void method754(Actor var0, int var1) {
		ReflectionCheck.worldToScreen(var0.x, var0.y, var1);
	}
}
