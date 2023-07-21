import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gs")
public class class160 {
	@ObfuscatedName("aw")
	long field1404;
	@ObfuscatedName("ay")
	long field1405;
	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "Lor;"
	)
	IterableNodeDeque field1406;

	@ObfuscatedSignature(
		descriptor = "(Lty;)V"
	)
	public class160(Buffer var1) {
		this.field1405 = -1L;
		this.field1406 = new IterableNodeDeque();
		this.method841(var1);
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(Lty;I)V",
		garbageValue = "-1382103151"
	)
	void method841(Buffer var1) {
		this.field1404 = var1.readLong();
		this.field1405 = var1.readLong();

		for (int var2 = var1.readUnsignedByte(); var2 != 0; var2 = var1.readUnsignedByte()) {
			Object var3;
			if (var2 == 1) {
				var3 = new class155(this);
			} else if (var2 == 4) {
				var3 = new class166(this);
			} else if (var2 == 3) {
				var3 = new class151(this);
			} else if (var2 == 2) {
				var3 = new class149(this);
			} else {
				if (var2 != 5) {
					throw new RuntimeException("");
				}

				var3 = new class156(this);
			}

			((class159)var3).vmethod3238(var1);
			this.field1406.addFirst((Node)var3);
		}

	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(Lgh;I)V",
		garbageValue = "1629184454"
	)
	public void method842(ClanChannel var1) {
		if (this.field1404 == var1.key && this.field1405 == var1.field1414) {
			for (class159 var2 = (class159)this.field1406.last(); var2 != null; var2 = (class159)this.field1406.previous()) {
				var2.vmethod3239(var1);
			}

			++var1.field1414;
		} else {
			throw new RuntimeException("");
		}
	}
}
