import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eo")
public class class132 {
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		longValue = -6674799221148244799L
	)
	long field1581;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = 304285101
	)
	int field1576;
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		descriptor = "Llz;"
	)
	IterableNodeDeque field1577;

	@ObfuscatedSignature(
		descriptor = "(Lqq;)V"
	)
	public class132(Buffer var1) {
		this.field1576 = -1;
		this.field1577 = new IterableNodeDeque();
		this.method3030(var1);
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "(Lqq;I)V",
		garbageValue = "-2121541233"
	)
	void method3030(Buffer var1) {
		this.field1581 = var1.readLong();
		this.field1576 = var1.readInt();

		for (int var2 = var1.readUnsignedByte(); var2 != 0; var2 = var1.readUnsignedByte()) {
			Object var3;
			if (var2 == 3) {
				var3 = new class151(this);
			} else if (var2 == 1) {
				var3 = new class127(this);
			} else if (var2 == 13) {
				var3 = new class144(this);
			} else if (var2 == 4) {
				var3 = new class136(this);
			} else if (var2 == 6) {
				var3 = new class143(this);
			} else if (var2 == 5) {
				var3 = new class128(this);
			} else if (var2 == 2) {
				var3 = new class133(this);
			} else if (var2 == 7) {
				var3 = new class126(this);
			} else if (var2 == 14) {
				var3 = new class130(this);
			} else if (var2 == 8) {
				var3 = new class147(this);
			} else if (var2 == 9) {
				var3 = new class153(this);
			} else if (var2 == 10) {
				var3 = new class139(this);
			} else if (var2 == 11) {
				var3 = new class134(this);
			} else if (var2 == 12) {
				var3 = new class138(this);
			} else {
				if (var2 != 15) {
					throw new RuntimeException("");
				}

				var3 = new class148(this);
			}

			((class129)var3).vmethod3320(var1);
			this.field1577.addFirst((Node)var3);
		}

	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		descriptor = "(Led;B)V",
		garbageValue = "-61"
	)
	public void method3028(ClanSettings var1) {
		if (var1.field1626 == this.field1581 && this.field1576 == var1.field1630) {
			for (class129 var2 = (class129)this.field1577.last(); var2 != null; var2 = (class129)this.field1577.previous()) {
				var2.vmethod3313(var1);
			}

			++var1.field1630;
		} else {
			throw new RuntimeException("");
		}
	}
}
