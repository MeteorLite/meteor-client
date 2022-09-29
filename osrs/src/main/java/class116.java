import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dj")
public class class116 {
	@ObfuscatedName("d")
	@ObfuscatedSignature(
		descriptor = "Lqu;"
	)
	static IndexedSprite field1428;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = 898403645
	)
	public final int field1435;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		descriptor = "Ldj;"
	)
	public class116 field1429;
	@ObfuscatedName("f")
	float[][] field1430;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		descriptor = "[Lnw;"
	)
	final class389[] field1431;
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		descriptor = "[Lnw;"
	)
	class389[] field1432;
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		descriptor = "[Lnw;"
	)
	class389[] field1433;
	@ObfuscatedName("s")
	@ObfuscatedSignature(
		descriptor = "Lnw;"
	)
	class389 field1434;
	@ObfuscatedName("q")
	boolean field1439;
	@ObfuscatedName("m")
	@ObfuscatedSignature(
		descriptor = "Lnw;"
	)
	class389 field1442;
	@ObfuscatedName("x")
	boolean field1437;
	@ObfuscatedName("j")
	@ObfuscatedSignature(
		descriptor = "Lnw;"
	)
	class389 field1436;
	@ObfuscatedName("v")
	float[][] field1438;
	@ObfuscatedName("h")
	float[][] field1440;
	@ObfuscatedName("t")
	float[][] field1441;

	@ObfuscatedSignature(
		descriptor = "(ILqq;Z)V"
	)
	public class116(int var1, Buffer var2, boolean var3) {
		this.field1434 = new class389();
		this.field1439 = true;
		this.field1442 = new class389();
		this.field1437 = true;
		this.field1436 = new class389();
		this.field1435 = var2.readShort();
		this.field1431 = new class389[var1];
		this.field1432 = new class389[this.field1431.length];
		this.field1433 = new class389[this.field1431.length];
		this.field1430 = new float[this.field1431.length][3];

		for (int var4 = 0; var4 < this.field1431.length; ++var4) {
			this.field1431[var4] = new class389(var2, var3);
			this.field1430[var4][0] = var2.method7930();
			this.field1430[var4][1] = var2.method7930();
			this.field1430[var4][2] = var2.method7930();
		}

		this.method2820();
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-1096441219"
	)
	void method2820() {
		this.field1438 = new float[this.field1431.length][3];
		this.field1440 = new float[this.field1431.length][3];
		this.field1441 = new float[this.field1431.length][3];
		class389 var1 = SequenceDefinition.method3974();

		for (int var2 = 0; var2 < this.field1431.length; ++var2) {
			class389 var3 = this.method2821(var2);
			var1.method7227(var3);
			var1.method7199();
			this.field1438[var2] = var1.method7206();
			this.field1440[var2][0] = var3.field4440[12];
			this.field1440[var2][1] = var3.field4440[13];
			this.field1440[var2][2] = var3.field4440[14];
			this.field1441[var2] = var3.method7185();
		}

		var1.method7203();
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		descriptor = "(IB)Lnw;",
		garbageValue = "26"
	)
	class389 method2821(int var1) {
		return this.field1431[var1];
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		descriptor = "(II)Lnw;",
		garbageValue = "-1383019646"
	)
	class389 method2833(int var1) {
		if (this.field1432[var1] == null) {
			this.field1432[var1] = new class389(this.method2821(var1));
			if (this.field1429 != null) {
				this.field1432[var1].method7178(this.field1429.method2833(var1));
			} else {
				this.field1432[var1].method7178(class389.field4438);
			}
		}

		return this.field1432[var1];
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		descriptor = "(II)Lnw;",
		garbageValue = "2040180782"
	)
	class389 method2823(int var1) {
		if (this.field1433[var1] == null) {
			this.field1433[var1] = new class389(this.method2833(var1));
			this.field1433[var1].method7199();
		}

		return this.field1433[var1];
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		descriptor = "(Lnw;B)V",
		garbageValue = "3"
	)
	void method2824(class389 var1) {
		this.field1434.method7227(var1);
		this.field1439 = true;
		this.field1437 = true;
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		descriptor = "(I)Lnw;",
		garbageValue = "-102436308"
	)
	class389 method2825() {
		return this.field1434;
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		descriptor = "(I)Lnw;",
		garbageValue = "-970698711"
	)
	class389 method2851() {
		if (this.field1439) {
			this.field1442.method7227(this.method2825());
			if (this.field1429 != null) {
				this.field1442.method7178(this.field1429.method2851());
			}

			this.field1439 = false;
		}

		return this.field1442;
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		descriptor = "(IB)Lnw;",
		garbageValue = "-119"
	)
	public class389 method2827(int var1) {
		if (this.field1437) {
			this.field1436.method7227(this.method2823(var1));
			this.field1436.method7178(this.method2851());
			this.field1437 = false;
		}

		return this.field1436;
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		descriptor = "(II)[F",
		garbageValue = "-767664590"
	)
	float[] method2828(int var1) {
		return this.field1438[var1];
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		descriptor = "(IB)[F",
		garbageValue = "-7"
	)
	float[] method2849(int var1) {
		return this.field1440[var1];
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		descriptor = "(II)[F",
		garbageValue = "251783866"
	)
	float[] method2854(int var1) {
		return this.field1441[var1];
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "(IB)Lbt;",
		garbageValue = "84"
	)
	@Export("getScript")
	static Script getScript(int var0) {
		Script var1 = (Script)Script.Script_cached.get((long)var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = class102.archive12.takeFile(var0, 0);
			if (var2 == null) {
				return null;
			} else {
				var1 = WorldMapRegion.newScript(var2);
				Script.Script_cached.put(var1, (long)var0);
				return var1;
			}
		}
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "2093501897"
	)
	static final void method2857() {
		Object var10000 = null;
		String var0 = "You can't add yourself to your own friend list";
		class65.addGameMessage(30, "", var0);
	}
}
