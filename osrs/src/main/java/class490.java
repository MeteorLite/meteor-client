import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@ObfuscatedName("sx")
public class class490 implements class489 {
	@ObfuscatedName("au")
	Map field4064;
	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "Luu;"
	)
	final class522 field4065;

	@ObfuscatedSignature(
		descriptor = "(Luu;)V"
	)
	public class490(class522 var1) {
		this.field4065 = var1;
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(IS)I",
		garbageValue = "31516"
	)
	@Export("vmethod8144")
	public int vmethod8144(int var1) {
		if (this.field4064 != null) {
			class523 var2 = (class523)this.field4064.get(var1);
			if (var2 != null) {
				return (Integer)var2.field4215;
			}
		}

		return (Integer)this.field4065.vmethod8697(var1);
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(ILjava/lang/Object;I)V",
		garbageValue = "1797615972"
	)
	@Export("vmethod8143")
	public void vmethod8143(int var1, Object var2) {
		if (this.field4064 == null) {
			this.field4064 = new HashMap();
			this.field4064.put(var1, new class523(var1, var2));
		} else {
			class523 var3 = (class523)this.field4064.get(var1);
			if (var3 == null) {
				this.field4064.put(var1, new class523(var1, var2));
			} else {
				var3.field4215 = var2;
			}
		}

	}

	@Export("iterator")
	@ObfuscatedName("iterator")
	public Iterator iterator() {
		return this.field4064 == null ? Collections.emptyList().iterator() : this.field4064.values().iterator();
	}
}