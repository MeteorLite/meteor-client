import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gf")
public class class162 {
	@ObfuscatedName("fo")
	@ObfuscatedSignature(
		descriptor = "Lre;"
	)
	@Export("js5Socket")
	static AbstractSocket js5Socket;
	@ObfuscatedName("ac")
	long field1402;
	@ObfuscatedName("al")
	public long field1404;
	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "Lpy;"
	)
	IterableNodeDeque field1403;

	@ObfuscatedSignature(
		descriptor = "(Lul;)V"
	)
	public class162(Buffer var1) {
		this.field1404 = -1L;
		this.field1403 = new IterableNodeDeque();
		this.method850(var1);
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(Lul;B)V",
		garbageValue = "90"
	)
	void method850(Buffer var1) {
		this.field1402 = var1.readLong();
		this.field1404 = var1.readLong();

		for (int var2 = var1.readUnsignedByte(); var2 != 0; var2 = var1.readUnsignedByte()) {
			Object var3;
			if (var2 == 1) {
				var3 = new class157(this);
			} else if (var2 == 4) {
				var3 = new class168(this);
			} else if (var2 == 3) {
				var3 = new class153(this);
			} else if (var2 == 2) {
				var3 = new class151(this);
			} else {
				if (var2 != 5) {
					throw new RuntimeException("");
				}

				var3 = new class158(this);
			}

			((class161)var3).vmethod3238(var1);
			this.field1403.addFirst((Node)var3);
		}

	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "(Lgb;I)V",
		garbageValue = "-913420137"
	)
	public void method851(ClanChannel var1) {
		if (this.field1402 == var1.key && var1.field1417 == this.field1404) {
			for (class161 var2 = (class161)this.field1403.last(); var2 != null; var2 = (class161)this.field1403.previous()) {
				var2.vmethod3239(var1);
			}

			++var1.field1417;
		} else {
			throw new RuntimeException("");
		}
	}
}