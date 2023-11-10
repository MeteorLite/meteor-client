import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("tf")
@Implements("DbRowType")
public class DbRowType extends DualNode {
	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "Lol;"
	)
	public static AbstractArchive field4140;
	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "Llk;"
	)
	@Export("DBRowType_cache")
	static EvictingDualNodeHashTable DBRowType_cache;
	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "Lol;"
	)
	@Export("ItemDefinition_archive")
	public static AbstractArchive ItemDefinition_archive;
	@ObfuscatedName("ar")
	@Export("columnTypes")
	Object[][] columnTypes;
	@ObfuscatedName("ao")
	int[][] field4143;
	@ObfuscatedName("ab")
	@Export("tableId")
	public int tableId;

	static {
		DBRowType_cache = new EvictingDualNodeHashTable(64);
	}

	DbRowType() {
		this.tableId = -1;
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(Luj;S)V",
		garbageValue = "2044"
	)
	void method2520(Buffer var1) {
		while (true) {
			int var2 = var1.readUnsignedByte();
			if (var2 == 0) {
				return;
			}

			this.method2522(var1, var2);
		}
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(IB)[Ljava/lang/Object;",
		garbageValue = "14"
	)
	@Export("getColumnType")
	public Object[] getColumnType(int var1) {
		return this.columnTypes == null ? null : this.columnTypes[var1];
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(Luj;IB)V",
		garbageValue = "55"
	)
	void method2522(Buffer var1, int var2) {
		if (var2 == 3) {
			int var3 = var1.readUnsignedByte();
			if (this.columnTypes == null) {
				this.columnTypes = new Object[var3][];
				this.field4143 = new int[var3][];
			}

			for (int var4 = var1.readUnsignedByte(); var4 != 255; var4 = var1.readUnsignedByte()) {
				int var5 = var1.readUnsignedByte();
				int[] var6 = new int[var5];

				for (int var7 = 0; var7 < var5; ++var7) {
					var6[var7] = var1.readUShortSmart();
				}

				Object[][] var16 = this.columnTypes;
				int var10 = var1.readUShortSmart();
				Object[] var11 = new Object[var6.length * var10];

				for (int var12 = 0; var12 < var10; ++var12) {
					for (int var13 = 0; var13 < var6.length; ++var13) {
						int var14 = var13 + var6.length * var12;
						class514 var15 = class472.method2349(var6[var13]);
						var11[var14] = var15.method2506(var1);
					}
				}

				var16[var4] = var11;
				this.field4143[var4] = var6;
			}
		} else if (var2 == 4) {
			this.tableId = var1.packBytesToInt();
		}

	}

	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-1202767644"
	)
	void method2523() {
	}
}