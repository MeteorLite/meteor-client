import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fq")
public class class133 implements class383 {
	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "Lfq;"
	)
	static final class133 field1296;
	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "Lfq;"
	)
	static final class133 field1288;
	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "Lfq;"
	)
	static final class133 field1294;
	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "Lfq;"
	)
	static final class133 field1292;
	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "Lfq;"
	)
	static final class133 field1286;
	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "Lfq;"
	)
	static final class133 field1297;
	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "Lfq;"
	)
	static final class133 field1285;
	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "Lfq;"
	)
	static final class133 field1287;
	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "Lfq;"
	)
	static final class133 field1291;
	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "Lfq;"
	)
	static final class133 field1301;
	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		descriptor = "Lfq;"
	)
	static final class133 field1293;
	@ObfuscatedName("av")
	@ObfuscatedSignature(
		descriptor = "Lfq;"
	)
	static final class133 field1298;
	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "Lfq;"
	)
	static final class133 field1299;
	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "Lfq;"
	)
	static final class133 field1295;
	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "Lfq;"
	)
	static final class133 field1300;
	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "Lfq;"
	)
	static final class133 field1290;
	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		descriptor = "Lfq;"
	)
	static final class133 field1289;
	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "Ljt;"
	)
	@Export("worldMapEvent")
	static WorldMapEvent worldMapEvent;
	@ObfuscatedName("am")
	final int field1303;
	@ObfuscatedName("aq")
	final int field1304;
	@ObfuscatedName("ai")
	final int field1302;

	static {
		field1296 = new class133(0, 0, (String)null, -1, -1);
		field1288 = new class133(1, 1, (String)null, 0, 2);
		field1294 = new class133(2, 2, (String)null, 1, 2);
		field1292 = new class133(3, 3, (String)null, 2, 2);
		field1286 = new class133(4, 4, (String)null, 3, 1);
		field1297 = new class133(5, 5, (String)null, 4, 1);
		field1285 = new class133(6, 6, (String)null, 5, 1);
		field1287 = new class133(7, 7, (String)null, 6, 3);
		field1291 = new class133(8, 8, (String)null, 7, 3);
		field1301 = new class133(9, 9, (String)null, 8, 3);
		field1293 = new class133(10, 10, (String)null, 0, 7);
		field1298 = new class133(11, 11, (String)null, 1, 7);
		field1299 = new class133(12, 12, (String)null, 2, 7);
		field1295 = new class133(13, 13, (String)null, 3, 7);
		field1300 = new class133(14, 14, (String)null, 4, 7);
		field1290 = new class133(15, 15, (String)null, 5, 7);
		field1289 = new class133(16, 16, (String)null, 0, 5);
	}

	@ObfuscatedSignature(
		descriptor = "(IILjava/lang/String;II)V",
		garbageValue = "-1"
	)
	class133(int var1, int var2, String var3, int var4, int var5) {
		this.field1303 = var1;
		this.field1304 = var2;
		this.field1302 = var4;
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "-2145781629"
	)
	int method729() {
		return this.field1302;
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "-11"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.field1304;
	}
}