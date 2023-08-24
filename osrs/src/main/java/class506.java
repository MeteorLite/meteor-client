import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ObfuscatedName("tx")
public class class506 extends DualNode {
	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "[Ltb;"
	)
	class502[] field4114;
	@ObfuscatedName("ac")
	List field4113;

	@ObfuscatedSignature(
		descriptor = "(Lnu;I)V"
	)
	public class506(AbstractArchive var1, int var2) {
		byte[] var3 = var1.takeFile(var2, 0);
		this.method2506(new Buffer(var3));
	}

	@ObfuscatedSignature(
		descriptor = "(Lnu;II)V"
	)
	public class506(AbstractArchive var1, int var2, int var3) {
		byte[] var4 = var1.takeFile(var2, var3 + 1);
		this.method2506(new Buffer(var4));
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(Ltm;I)V",
		garbageValue = "1051210616"
	)
	void method2506(Buffer var1) {
		int var2 = var1.method2565();
		this.field4114 = new class502[var2];
		this.field4113 = new ArrayList(var2);

		for (int var3 = 0; var3 < var2; ++var3) {
			this.field4114[var3] = (class502)KeyHandler.findEnumerated(class502.method2494(), var1.readUnsignedByte());
			int var4 = var1.method2565();
			HashMap var5 = new HashMap(var4);

			while (var4-- > 0) {
				Object var6 = this.field4114[var3].method2497(var1);
				int var7 = var1.method2565();
				ArrayList var8 = new ArrayList();

				while (var7-- > 0) {
					int var9 = var1.method2565();
					var8.add(var9);
				}

				var5.put(var6, var8);
			}

			this.field4113.add(var3, var5);
		}

	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/Object;IB)Ljava/util/List;",
		garbageValue = "113"
	)
	public List method2507(Object var1, int var2) {
		if (var2 < 0) {
			var2 = 0;
		}

		Map var3 = (Map)this.field4113.get(var2);
		return (List)var3.get(var1);
	}
}