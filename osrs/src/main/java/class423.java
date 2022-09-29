import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("pd")
public class class423 implements class422 {
	@ObfuscatedName("c")
	Map field4641;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		descriptor = "Lqg;"
	)
	final class451 field4640;

	@ObfuscatedSignature(
		descriptor = "(Lqg;)V"
	)
	public class423(class451 var1) {
		this.field4640 = var1;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "(IB)I",
		garbageValue = "121"
	)
	public int vmethod7651(int var1) {
		if (this.field4641 != null) {
			class452 var2 = (class452)this.field4641.get(var1);
			if (var2 != null) {
				return (Integer)var2.field4797;
			}
		}

		return (Integer)this.field4640.vmethod8208(var1);
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		descriptor = "(ILjava/lang/Object;I)V",
		garbageValue = "-24891652"
	)
	public void vmethod7652(int var1, Object var2) {
		if (this.field4641 == null) {
			this.field4641 = new HashMap();
			this.field4641.put(var1, new class452(var1, var2));
		} else {
			class452 var3 = (class452)this.field4641.get(var1);
			if (var3 == null) {
				this.field4641.put(var1, new class452(var1, var2));
			} else {
				var3.field4797 = var2;
			}
		}

	}

	public Iterator iterator() {
		return this.field4641 == null ? Collections.emptyList().iterator() : this.field4641.values().iterator();
	}
}
