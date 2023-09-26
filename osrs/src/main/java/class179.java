import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gg")
public class class179 {
	@ObfuscatedName("ax")
	public String field1466;
	@ObfuscatedName("ao")
	public float[] field1462;
	@ObfuscatedName("ah")
	public int field1464;
	@ObfuscatedName("ar")
	public int field1465;
	@ObfuscatedName("ab")
	public int field1463;
	// $FF: synthetic field
	@ObfuscatedSignature(
		descriptor = "Lgr;"
	)
	@Export("this$0")
	@ObfuscatedName("this$0")
	final class172 this$0;

	@ObfuscatedSignature(
		descriptor = "(Lgr;)V"
	)
	class179(class172 var1) {
		this.this$0 = var1;
		this.field1462 = new float[4];
		this.field1464 = 1;
		this.field1465 = 1;
		this.field1463 = 0;
	}

	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "(II)Lfl;",
		garbageValue = "-1919119231"
	)
	static class134 method927(int var0) {
		class134[] var1 = new class134[]{class134.field1268, class134.field1273, class134.field1272, class134.field1281, class134.field1276, class134.field1270, class134.field1278, class134.field1267, class134.field1274, class134.field1280, class134.field1269, class134.field1266, class134.field1277, class134.field1282, class134.field1279, class134.field1271, class134.field1275};
		class134 var2 = (class134)SequenceDefinition.findEnumerated(var1, var0);
		if (var2 == null) {
			var2 = class134.field1268;
		}

		return var2;
	}
}