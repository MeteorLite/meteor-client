import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fm")
public class class130 {
	@ObfuscatedName("qb")
	@Export("widgetDragDuration")
	static int widgetDragDuration;
	@ObfuscatedName("aw")
	boolean field1228;
	@ObfuscatedName("ay")
	boolean field1229;
	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "Leu;"
	)
	class128 field1231;
	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "Leu;"
	)
	class128 field1230;
	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "[Lev;"
	)
	class125[] field1232;
	@ObfuscatedName("aj")
	boolean field1227;
	@ObfuscatedName("ag")
	float field1234;
	@ObfuscatedName("az")
	float field1244;
	@ObfuscatedName("av")
	float field1242;
	@ObfuscatedName("ap")
	float field1238;
	@ObfuscatedName("aq")
	float field1239;
	@ObfuscatedName("at")
	float field1240;
	@ObfuscatedName("ah")
	float field1235;
	@ObfuscatedName("ax")
	float field1243;
	@ObfuscatedName("aa")
	float field1233;
	@ObfuscatedName("au")
	float field1241;
	@ObfuscatedName("ae")
	boolean field1226;
	@ObfuscatedName("ab")
	int field1246;
	@ObfuscatedName("ad")
	float[] field1245;
	@ObfuscatedName("ao")
	int field1248;
	@ObfuscatedName("ac")
	int field1247;
	@ObfuscatedName("ak")
	float field1236;
	@ObfuscatedName("an")
	float field1237;

	class130() {
		this.field1226 = true;
		this.field1246 = 0;
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(Lty;IB)I",
		garbageValue = "123"
	)
	int method709(Buffer var1, int var2) {
		int var3 = var1.readUnsignedShort();
		AttackOption.method610(var1.readUnsignedByte());
		this.field1231 = class74.method437(var1.readUnsignedByte());
		this.field1230 = class74.method437(var1.readUnsignedByte());
		this.field1228 = var1.readUnsignedByte() != 0;
		this.field1232 = new class125[var3];
		class125 var4 = null;

		for (int var5 = 0; var5 < var3; ++var5) {
			class125 var6 = new class125();
			var6.method688(var1, var2);
			this.field1232[var5] = var6;
			if (var4 != null) {
				var4.field1187 = var6;
			}

			var4 = var6;
		}

		return var3;
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-725467027"
	)
	void method710() {
		this.field1248 = this.field1232[0].field1193;
		this.field1247 = this.field1232[this.method717() - 1].field1193;
		this.field1245 = new float[this.method714() + 1];

		for (int var1 = this.method712(); var1 <= this.method713(); ++var1) {
			this.field1245[var1 - this.method712()] = ApproximateRouteStrategy.method348(this, (float)var1);
		}

		this.field1232 = null;
		this.field1236 = ApproximateRouteStrategy.method348(this, (float)(this.method712() - 1));
		this.field1237 = ApproximateRouteStrategy.method348(this, (float)(this.method713() + 1));
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(II)F",
		garbageValue = "-1628852517"
	)
	public float method711(int var1) {
		if (var1 < this.method712()) {
			return this.field1236;
		} else {
			return var1 > this.method713() ? this.field1237 : this.field1245[var1 - this.method712()];
		}
	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "0"
	)
	int method712() {
		return this.field1248;
	}

	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "-1597544274"
	)
	int method713() {
		return this.field1247;
	}

	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "606654204"
	)
	int method714() {
		return this.method713() - this.method712();
	}

	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		descriptor = "(FI)I",
		garbageValue = "1218924507"
	)
	int method715(float var1) {
		if (this.field1246 >= 0 && (float)this.field1232[this.field1246].field1193 <= var1 && (this.field1232[this.field1246].field1187 == null || (float)this.field1232[this.field1246].field1187.field1193 > var1)) {
			return this.field1246;
		} else if (var1 >= (float)this.method712() && var1 <= (float)this.method713()) {
			int var2 = this.method717();
			int var3 = this.field1246;
			if (var2 > 0) {
				int var4 = 0;
				int var5 = var2 - 1;

				do {
					int var6 = var4 + var5 >> 1;
					if (var1 < (float)this.field1232[var6].field1193) {
						if (var1 > (float)this.field1232[var6 - 1].field1193) {
							var3 = var6 - 1;
							break;
						}

						var5 = var6 - 1;
					} else {
						if (var1 <= (float)this.field1232[var6].field1193) {
							var3 = var6;
							break;
						}

						if (var1 < (float)this.field1232[var6 + 1].field1193) {
							var3 = var6;
							break;
						}

						var4 = var6 + 1;
					}
				} while(var4 <= var5);
			}

			if (var3 != this.field1246) {
				this.field1246 = var3;
				this.field1226 = true;
			}

			return this.field1246;
		} else {
			return -1;
		}
	}

	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "(FI)Lev;",
		garbageValue = "-487533983"
	)
	class125 method716(float var1) {
		int var2 = this.method715(var1);
		return var2 >= 0 && var2 < this.field1232.length ? this.field1232[var2] : null;
	}

	@ObfuscatedName("av")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "2"
	)
	int method717() {
		return this.field1232 == null ? 0 : this.field1232.length;
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(I)Llv;",
		garbageValue = "685705935"
	)
	public static PacketBufferNode method708() {
		return PacketBufferNode.PacketBufferNode_packetBufferNodeCount == 0 ? new PacketBufferNode() : PacketBufferNode.PacketBufferNode_packetBufferNodes[--PacketBufferNode.PacketBufferNode_packetBufferNodeCount];
	}
}
