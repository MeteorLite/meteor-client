import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("nn")
@Implements("AbstractByteArrayCopier")
public abstract class AbstractByteArrayCopier {
	@ObfuscatedName("ft")
	@ObfuscatedSignature(
		descriptor = "Lok;"
	)
	static Archive field3136;

	AbstractByteArrayCopier() {
	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "(I)[B",
		garbageValue = "1381422717"
	)
	@Export("get")
	abstract byte[] get();

	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "([BI)V",
		garbageValue = "-2137536013"
	)
	@Export("set")
	public abstract void set(byte[] var1);

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(II)Lfy;",
		garbageValue = "-1206517900"
	)
	static class140 method1886(int var0) {
		class140[] var1 = new class140[]{class140.field1301, class140.field1304, class140.field1303, class140.field1308, class140.field1306, class140.field1302, class140.field1307, class140.field1300, class140.field1305};
		class140 var2 = (class140)SequenceDefinition.findEnumerated(var1, var0);
		if (var2 == null) {
			var2 = class140.field1305;
		}

		return var2;
	}
}