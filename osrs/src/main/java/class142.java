import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fh")
public class class142 extends class144 {
	@ObfuscatedName("at")
	long field1335;
	@ObfuscatedName("ah")
	String field1334;
	// $FF: synthetic field
	@ObfuscatedSignature(
		descriptor = "Lfv;"
	)
	final class147 this$0;

	@ObfuscatedSignature(
		descriptor = "(Lfv;)V"
	)
	class142(class147 var1) {
		this.this$0 = var1;
		this.field1335 = -1L;
		this.field1334 = null;
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(Luj;I)V",
		garbageValue = "-734756620"
	)
	@Export("vmethod3254")
	void vmethod3254(Buffer var1) {
		if (var1.readUnsignedByte() != 255) {
			--var1.offset;
			this.field1335 = var1.readLong();
		}

		this.field1334 = var1.readStringCp1252NullTerminatedOrNull();
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(Lfc;I)V",
		garbageValue = "-2111347169"
	)
	@Export("vmethod3248")
	void vmethod3248(ClanSettings var1) {
		var1.method804(this.field1335, this.field1334, 0);
	}

	@ObfuscatedName("bu")
	@ObfuscatedSignature(
		descriptor = "(IB)I",
		garbageValue = "0"
	)
	static int method758(int var0) {
		return (int)((Math.log((double)var0) / Interpreter.field717 - 7.0D) * 256.0D);
	}
}