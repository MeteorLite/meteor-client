import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gi")
public class class161 {
	@ObfuscatedName("at")
	long field1407;
	@ObfuscatedName("ah")
	public long field1409;
	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "Lpm;"
	)
	IterableNodeDeque field1408;

	@ObfuscatedSignature(
		descriptor = "(Luj;)V"
	)
	public class161(Buffer var1) {
		this.field1409 = -1L;
		this.field1408 = new IterableNodeDeque();
		this.method843(var1);
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(Luj;B)V",
		garbageValue = "-62"
	)
	void method843(Buffer var1) {
		this.field1407 = var1.readLong();
		this.field1409 = var1.readLong();

		for (int var2 = var1.readUnsignedByte(); var2 != 0; var2 = var1.readUnsignedByte()) {
			Object var3;
			if (var2 == 1) {
				var3 = new class156(this);
			} else if (var2 == 4) {
				var3 = new class167(this);
			} else if (var2 == 3) {
				var3 = new class152(this);
			} else if (var2 == 2) {
				var3 = new class150(this);
			} else {
				if (var2 != 5) {
					throw new RuntimeException("");
				}

				var3 = new class157(this);
			}

			((class160)var3).vmethod3238(var1);
			this.field1408.addFirst((Node)var3);
		}

	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(Lgn;I)V",
		garbageValue = "1259262891"
	)
	public void method844(ClanChannel var1) {
		if (var1.key == this.field1407 && this.field1409 == var1.field1421) {
			for (class160 var2 = (class160)this.field1408.last(); var2 != null; var2 = (class160)this.field1408.previous()) {
				var2.vmethod3239(var1);
			}

			++var1.field1421;
		} else {
			throw new RuntimeException("");
		}
	}
}