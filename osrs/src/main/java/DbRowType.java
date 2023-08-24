import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("tc")
@Implements("DbRowType")
public class DbRowType extends DualNode {
	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "Lnu;"
	)
	static AbstractArchive field4116;
	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "Lle;"
	)
	@Export("DBRowType_cache")
	static EvictingDualNodeHashTable DBRowType_cache;
	@ObfuscatedName("ao")
	@Export("columnTypes")
	Object[][] columnTypes;
	@ObfuscatedName("at")
	int[][] field4117;
	@ObfuscatedName("ac")
	@Export("tableId")
	public int tableId;

	static {
		DBRowType_cache = new EvictingDualNodeHashTable(64);
	}

	DbRowType() {
		this.tableId = -1;
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(Ltm;I)V",
		garbageValue = "-1552202999"
	)
	void method2508(Buffer var1) {
		while (true) {
			int var2 = var1.readUnsignedByte();
			if (var2 == 0) {
				return;
			}

			this.method2510(var1, var2);
		}
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(II)[Ljava/lang/Object;",
		garbageValue = "1717778174"
	)
	@Export("getColumnType")
	public Object[] getColumnType(int var1) {
		return this.columnTypes == null ? null : this.columnTypes[var1];
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(Ltm;II)V",
		garbageValue = "1262873215"
	)
	void method2510(Buffer var1, int var2) {
		if (var2 == 3) {
			int var3 = var1.readUnsignedByte();
			if (this.columnTypes == null) {
				this.columnTypes = new Object[var3][];
				this.field4117 = new int[var3][];
			}

			for (int var4 = var1.readUnsignedByte(); var4 != 255; var4 = var1.readUnsignedByte()) {
				int var5 = var1.readUnsignedByte();
				int[] var6 = new int[var5];

				for (int var7 = 0; var7 < var5; ++var7) {
					var6[var7] = var1.readUShortSmart();
				}

				this.columnTypes[var4] = KeyHandler.method88(var1, var6);
				this.field4117[var4] = var6;
			}
		} else if (var2 == 4) {
			this.tableId = var1.method2565();
		}

	}

	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "-55"
	)
	void method2511() {
	}
}