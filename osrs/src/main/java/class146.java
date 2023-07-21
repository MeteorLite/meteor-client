import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fr")
public class class146 {
	@ObfuscatedName("aw")
	long field1329;
	@ObfuscatedName("ay")
	int field1328;
	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "Lor;"
	)
	IterableNodeDeque field1330;

	@ObfuscatedSignature(
		descriptor = "(Lty;)V"
	)
	public class146(Buffer var1) {
		this.field1328 = -1;
		this.field1330 = new IterableNodeDeque();
		this.method773(var1);
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(Lty;I)V",
		garbageValue = "-625880362"
	)
	void method773(Buffer var1) {
		this.field1329 = var1.readLong();
		this.field1328 = var1.readInt();

		for (int var2 = var1.readUnsignedByte(); var2 != 0; var2 = var1.readUnsignedByte()) {
			Object var3;
			if (var2 == 3) {
				var3 = new class165(this);
			} else if (var2 == 1) {
				var3 = new class141(this);
			} else if (var2 == 13) {
				var3 = new class158(this);
			} else if (var2 == 4) {
				var3 = new class150(this);
			} else if (var2 == 6) {
				var3 = new class157(this);
			} else if (var2 == 5) {
				var3 = new class142(this);
			} else if (var2 == 2) {
				var3 = new class147(this);
			} else if (var2 == 7) {
				var3 = new class140(this);
			} else if (var2 == 14) {
				var3 = new class144(this);
			} else if (var2 == 8) {
				var3 = new class161(this);
			} else if (var2 == 9) {
				var3 = new class167(this);
			} else if (var2 == 10) {
				var3 = new class153(this);
			} else if (var2 == 11) {
				var3 = new class148(this);
			} else if (var2 == 12) {
				var3 = new class152(this);
			} else {
				if (var2 != 15) {
					throw new RuntimeException("");
				}

				var3 = new class162(this);
			}

			((class143)var3).vmethod3254(var1);
			this.field1330.addFirst((Node)var3);
		}

	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(Lfx;I)V",
		garbageValue = "-955904177"
	)
	public void method774(ClanSettings var1) {
		if (this.field1329 == var1.field1366 && this.field1328 == var1.field1363) {
			for (class143 var2 = (class143)this.field1330.last(); var2 != null; var2 = (class143)this.field1330.previous()) {
				var2.vmethod3248(var1);
			}

			++var1.field1363;
		} else {
			throw new RuntimeException("");
		}
	}

	@ObfuscatedName("nx")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;ZB)V",
		garbageValue = "0"
	)
	@Export("findItemDefinitions")
	static void findItemDefinitions(String var0, boolean var1) {
		var0 = var0.toLowerCase();
		short[] var2 = new short[16];
		int var3 = 0;

		for (int var4 = 0; var4 < class239.ItemDefinition_fileCount; ++var4) {
			ItemComposition var5 = class125.ItemDefinition_get(var4);
			if ((!var1 || var5.isTradable) && var5.noteTemplate == -1 && var5.name.toLowerCase().indexOf(var0) != -1) {
				if (var3 >= 250) {
					JagexCache.foundItemIdCount = -1;
					MouseRecorder.foundItemIds = null;
					return;
				}

				if (var3 >= var2.length) {
					short[] var6 = new short[var2.length * 2];

					for (int var7 = 0; var7 < var3; ++var7) {
						var6[var7] = var2[var7];
					}

					var2 = var6;
				}

				var2[var3++] = (short)var4;
			}
		}

		MouseRecorder.foundItemIds = var2;
		ClanSettings.foundItemIndex = 0;
		JagexCache.foundItemIdCount = var3;
		String[] var8 = new String[JagexCache.foundItemIdCount];

		for (int var9 = 0; var9 < JagexCache.foundItemIdCount; ++var9) {
			var8[var9] = class125.ItemDefinition_get(var2[var9]).name;
		}

		class481.method2350(var8, MouseRecorder.foundItemIds);
	}

	@ObfuscatedName("ox")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-618232336"
	)
	static void method776() {
		for (int var0 = 0; var0 < Client.field605.size(); ++var0) {
			if (class273.method1504((Integer)Client.field605.get(var0)) != 2) {
				Client.field605.remove(var0);
				--var0;
			}
		}

	}
}
