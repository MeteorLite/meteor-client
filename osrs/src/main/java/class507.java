import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("tx")
public class class507 extends DualNode {
	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "[Ltm;"
	)
	class503[] field4103;
	@ObfuscatedName("as")
	List field4102;

	@ObfuscatedSignature(
		descriptor = "(Lnd;I)V"
	)
	public class507(AbstractArchive var1, int var2) {
		byte[] var3 = var1.takeFile(var2, 0);
		this.method2484(new Buffer(var3));
	}

	@ObfuscatedSignature(
		descriptor = "(Lnd;II)V"
	)
	public class507(AbstractArchive var1, int var2, int var3) {
		byte[] var4 = var1.takeFile(var2, var3 + 1);
		this.method2484(new Buffer(var4));
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(Lty;I)V",
		garbageValue = "702803819"
	)
	void method2484(Buffer var1) {
		int var2 = var1.method2545();
		this.field4103 = new class503[var2];
		this.field4102 = new ArrayList(var2);

		for (int var3 = 0; var3 < var2; ++var3) {
			this.field4103[var3] = (class503)ClientPreferences.findEnumerated(class503.method2469(), var1.readUnsignedByte());
			int var4 = var1.method2545();
			HashMap var5 = new HashMap(var4);

			while (var4-- > 0) {
				Object var6 = this.field4103[var3].method2474(var1);
				int var7 = var1.method2545();
				ArrayList var8 = new ArrayList();

				while (var7-- > 0) {
					int var9 = var1.method2545();
					var8.add(var9);
				}

				var5.put(var6, var8);
			}

			this.field4102.add(var3, var5);
		}

	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/Object;IB)Ljava/util/List;",
		garbageValue = "-17"
	)
	public List method2485(Object var1, int var2) {
		if (var2 < 0) {
			var2 = 0;
		}

		Map var3 = (Map)this.field4102.get(var2);
		return (List)var3.get(var1);
	}
}
