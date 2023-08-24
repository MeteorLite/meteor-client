import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

@ObfuscatedName("qv")
public final class class423 {
	@ObfuscatedName("au")
	final Comparator field3771;
	@ObfuscatedName("ae")
	final Map field3772;
	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "Lpa;"
	)
	final class392 field3774;
	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "Lpa;"
	)
	final class392 field3775;
	@ObfuscatedName("ac")
	final long field3773;
	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		descriptor = "Lqm;"
	)
	final class421 field3776;
	@ObfuscatedName("az")
	final int field3770;

	@ObfuscatedSignature(
		descriptor = "(JILqm;)V"
	)
	class423(long var1, int var3, class421 var4) {
		this.field3771 = new class422(this);
		this.field3773 = var1;
		this.field3770 = var3;
		this.field3776 = var4;
		if (this.field3770 == -1) {
			this.field3772 = new HashMap(64);
			this.field3774 = new class392(64, this.field3771);
			this.field3775 = null;
		} else {
			if (this.field3776 == null) {
				throw new IllegalArgumentException("");
			}

			this.field3772 = new HashMap(this.field3770);
			this.field3774 = new class392(this.field3770, this.field3771);
			this.field3775 = new class392(this.field3770);
		}

	}

	@ObfuscatedSignature(
		descriptor = "(ILqm;)V"
	)
	public class423(int var1, class421 var2) {
		this(-1L, var1, var2);
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "1594986015"
	)
	boolean method2179() {
		return this.field3770 != -1;
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/Object;B)Ljava/lang/Object;",
		garbageValue = "-31"
	)
	public Object method2180(Object var1) {
		synchronized(this) {
			if (this.field3773 != -1L) {
				this.method2183();
			}

			class424 var3 = (class424)this.field3772.get(var1);
			if (var3 == null) {
				return null;
			} else {
				this.method2182(var3, false);
				return var3.field3778;
			}
		}
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/Object;Ljava/lang/Object;I)Ljava/lang/Object;",
		garbageValue = "-396691149"
	)
	public Object method2181(Object var1, Object var2) {
		synchronized(this) {
			if (this.field3773 != -1L) {
				this.method2183();
			}

			class424 var4 = (class424)this.field3772.get(var1);
			if (var4 != null) {
				Object var8 = var4.field3778;
				var4.field3778 = var2;
				this.method2182(var4, false);
				return var8;
			} else {
				class424 var5;
				if (this.method2179() && this.field3772.size() == this.field3770) {
					var5 = (class424)this.field3775.remove();
					this.field3772.remove(var5.field3777);
					this.field3774.remove(var5);
				}

				var5 = new class424(var2, var1);
				this.field3772.put(var1, var5);
				this.method2182(var5, true);
				return null;
			}
		}
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(Lqj;ZB)V",
		garbageValue = "16"
	)
	void method2182(class424 var1, boolean var2) {
		if (!var2) {
			this.field3774.remove(var1);
			if (this.method2179() && !this.field3775.remove(var1)) {
				throw new IllegalStateException("");
			}
		}

		var1.field3779 = System.currentTimeMillis();
		if (this.method2179()) {
			switch(this.field3776.field3768) {
			case 0:
				var1.field3780 = var1.field3779;
				break;
			case 1:
				++var1.field3780;
			}

			this.field3775.add(var1);
		}

		this.field3774.add(var1);
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "1791287945"
	)
	void method2183() {
		if (this.field3773 == -1L) {
			throw new IllegalStateException("");
		} else {
			long var1 = System.currentTimeMillis() - this.field3773;

			while (!this.field3774.isEmpty()) {
				class424 var3 = (class424)this.field3774.peek();
				if (var3.field3779 >= var1) {
					return;
				}

				this.field3772.remove(var3.field3777);
				this.field3774.remove(var3);
				if (this.method2179()) {
					this.field3775.remove(var3);
				}
			}

		}
	}

	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "33"
	)
	public void method2184() {
		synchronized(this) {
			this.field3772.clear();
			this.field3774.clear();
			if (this.method2179()) {
				this.field3775.clear();
			}

		}
	}
}