import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ObfuscatedName("uq")
public class class521 extends DualNode {
	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "[Ltr;"
	)
	class517[] field4142;
	@ObfuscatedName("ao")
	List field4141;

	@ObfuscatedSignature(
		descriptor = "(Lom;I)V"
	)
	public class521(AbstractArchive var1, int var2) {
		byte[] var3 = var1.takeFile(var2, 0);
		this.method2541(new Buffer(var3));
	}

	@ObfuscatedSignature(
		descriptor = "(Lom;II)V"
	)
	public class521(AbstractArchive var1, int var2, int var3) {
		byte[] var4 = var1.takeFile(var2, var3 + 1);
		this.method2541(new Buffer(var4));
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(Lul;I)V",
		garbageValue = "677675313"
	)
	void method2541(Buffer var1) {
		int var2 = var1.packBytesToInt();
		this.field4142 = new class517[var2];
		this.field4141 = new ArrayList(var2);

		for (int var3 = 0; var3 < var2; ++var3) {
			this.field4142[var3] = (class517)SequenceDefinition.findEnumerated(class517.method2528(), var1.readUnsignedByte());
			int var4 = var1.packBytesToInt();
			HashMap var5 = new HashMap(var4);

			while (var4-- > 0) {
				Object var6 = this.field4142[var3].method2532(var1);
				int var7 = var1.packBytesToInt();
				ArrayList var8 = new ArrayList();

				while (var7-- > 0) {
					int var9 = var1.packBytesToInt();
					var8.add(var9);
				}

				var5.put(var6, var8);
			}

			this.field4141.add(var3, var5);
		}

	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/Object;II)Ljava/util/List;",
		garbageValue = "17353223"
	)
	public List method2542(Object var1, int var2) {
		if (var2 < 0) {
			var2 = 0;
		}

		Map var3 = (Map)this.field4141.get(var2);
		return (List)var3.get(var1);
	}
}