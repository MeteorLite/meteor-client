import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("sj")
public class class491 implements class490 {
	@ObfuscatedName("aw")
	Map field4052;
	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "Lul;"
	)
	final class521 field4053;

	@ObfuscatedSignature(
		descriptor = "(Lul;)V"
	)
	public class491(class521 var1) {
		this.field4053 = var1;
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(II)I",
		garbageValue = "2127277043"
	)
	@Export("vmethod8144")
	public int vmethod8144(int var1) {
		if (this.field4052 != null) {
			class522 var2 = (class522)this.field4052.get(var1);
			if (var2 != null) {
				return (Integer)var2.field4169;
			}
		}

		return (Integer)this.field4053.vmethod8697(var1);
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(ILjava/lang/Object;I)V",
		garbageValue = "-1811511637"
	)
	@Export("vmethod8143")
	public void vmethod8143(int var1, Object var2) {
		if (this.field4052 == null) {
			this.field4052 = new HashMap();
			this.field4052.put(var1, new class522(var1, var2));
		} else {
			class522 var3 = (class522)this.field4052.get(var1);
			if (var3 == null) {
				this.field4052.put(var1, new class522(var1, var2));
			} else {
				var3.field4169 = var2;
			}
		}

	}

	@Export("iterator")
	@ObfuscatedName("iterator")
	public Iterator iterator() {
		return this.field4052 == null ? Collections.emptyList().iterator() : this.field4052.values().iterator();
	}
}
