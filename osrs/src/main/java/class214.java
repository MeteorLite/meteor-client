import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ib")
public class class214 {
	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "Lea;"
	)
	public UrlRequest field1852;
	@ObfuscatedName("ah")
	public float[] field1853;
	// $FF: synthetic field
	@ObfuscatedSignature(
		descriptor = "Lic;"
	)
	@Export("this$0")
	@ObfuscatedName("this$0")
	final class208 this$0;

	@ObfuscatedSignature(
		descriptor = "(Lic;)V"
	)
	class214(class208 var1) {
		this.this$0 = var1;
		this.field1853 = new float[4];
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(II)Lhv;",
		garbageValue = "-1391716385"
	)
	@Export("ItemDefinition_get")
	public static ItemComposition ItemDefinition_get(int var0) {
		ItemComposition var1 = (ItemComposition)ItemComposition.ItemDefinition_cached.get((long)var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = DbRowType.ItemDefinition_archive.takeFile(10, var0);
			var1 = new ItemComposition();
			var1.id = var0;
			if (var2 != null) {
				var1.decode(new Buffer(var2));
			}

			var1.post();
			if (var1.noteTemplate != -1) {
				var1.genCert(ItemDefinition_get(var1.noteTemplate), ItemDefinition_get(var1.note));
			}

			if (var1.notedId != -1) {
				var1.genBought(ItemDefinition_get(var1.notedId), ItemDefinition_get(var1.unnotedId));
			}

			if (var1.placeholderTemplate != -1) {
				var1.genPlaceholder(ItemDefinition_get(var1.placeholderTemplate), ItemDefinition_get(var1.placeholder));
			}

			if (!class129.ItemDefinition_inMembersWorld && var1.isMembersOnly) {
				if (var1.noteTemplate == -1 && var1.notedId == -1 && var1.placeholderTemplate == -1) {
					var1.name = var1.name + " (Members)";
				}

				var1.isTradable = false;

				int var3;
				for (var3 = 0; var3 < var1.groundActions.length; ++var3) {
					var1.groundActions[var3] = null;
				}

				for (var3 = 0; var3 < var1.inventoryActions.length; ++var3) {
					if (var3 != 4) {
						var1.inventoryActions[var3] = null;
					}
				}

				var1.shiftClickIndex = -2;
				var1.team = 0;
				if (var1.params != null) {
					boolean var6 = false;

					for (Node var4 = var1.params.first(); var4 != null; var4 = var1.params.next()) {
						ParamComposition var5 = Frames.getParamDefinition((int)var4.key);
						if (var5.autoDisable) {
							var4.remove();
						} else {
							var6 = true;
						}
					}

					if (!var6) {
						var1.params = null;
					}
				}
			}

			ItemComposition.ItemDefinition_cached.put(var1, (long)var0);
			return var1;
		}
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(II)I",
		garbageValue = "-2138855763"
	)
	public static int method1092(int var0) {
		return class314.field2775[var0];
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(I)Lrq;",
		garbageValue = "1839119171"
	)
	public static class461 method1093() {
		synchronized(class461.field3900) {
			if (IgnoreList.field3815 == 0) {
				return new class461();
			} else {
				class461.field3900[--IgnoreList.field3815].method2312();
				return class461.field3900[IgnoreList.field3815];
			}
		}
	}
}