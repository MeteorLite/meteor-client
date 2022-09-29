import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dm")
public class class126 extends class129 {
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = 154083721
	)
	int field1546;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = -1409203475
	)
	int field1547;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = 1494138605
	)
	int field1548;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = 1504882137
	)
	int field1549;
	// $FF: synthetic field
	@ObfuscatedSignature(
		descriptor = "Leo;"
	)
	final class132 this$0;

	@ObfuscatedSignature(
		descriptor = "(Leo;)V"
	)
	class126(class132 var1) {
		this.this$0 = var1;
		this.field1546 = -1;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "(Lqq;B)V",
		garbageValue = "-41"
	)
	void vmethod3320(Buffer var1) {
		this.field1546 = var1.readUnsignedShort();
		this.field1547 = var1.readInt();
		this.field1548 = var1.readUnsignedByte();
		this.field1549 = var1.readUnsignedByte();
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		descriptor = "(Led;I)V",
		garbageValue = "-538131930"
	)
	void vmethod3313(ClanSettings var1) {
		var1.method3125(this.field1546, this.field1547, this.field1548, this.field1549);
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "(IB)Lgx;",
		garbageValue = "-26"
	)
	public static HitSplatDefinition method2973(int var0) {
		HitSplatDefinition var1 = (HitSplatDefinition)HitSplatDefinition.HitSplatDefinition_cached.get((long)var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = HitSplatDefinition.HitSplatDefinition_archive.takeFile(32, var0);
			var1 = new HitSplatDefinition();
			if (var2 != null) {
				var1.decode(new Buffer(var2));
			}

			HitSplatDefinition.HitSplatDefinition_cached.put(var1, (long)var0);
			return var1;
		}
	}

	@ObfuscatedName("af")
	@ObfuscatedSignature(
		descriptor = "(II)I",
		garbageValue = "1443487610"
	)
	static int method2981(int var0) {
		return (int)((Math.log((double)var0) / Interpreter.field850 - 7.0D) * 256.0D);
	}
}
