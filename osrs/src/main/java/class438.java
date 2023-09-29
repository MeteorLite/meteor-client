import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

@ObfuscatedName("qe")
public final class class438 {
	@ObfuscatedName("ac")
	final Comparator field3801;
	@ObfuscatedName("al")
	final Map field3802;
	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "Lpn;"
	)
	final class407 field3804;
	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "Lpn;"
	)
	final class407 field3805;
	@ObfuscatedName("ao")
	final long field3803;
	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "Lqs;"
	)
	final class436 field3806;
	@ObfuscatedName("ar")
	final int field3800;

	@ObfuscatedSignature(
		descriptor = "(JILqs;)V"
	)
	class438(long var1, int var3, class436 var4) {
		this.field3801 = new class437(this);
		this.field3803 = var1;
		this.field3800 = var3;
		this.field3806 = var4;
		if (this.field3800 == -1) {
			this.field3802 = new HashMap(64);
			this.field3804 = new class407(64, this.field3801);
			this.field3805 = null;
		} else {
			if (this.field3806 == null) {
				throw new IllegalArgumentException("");
			}

			this.field3802 = new HashMap(this.field3800);
			this.field3804 = new class407(this.field3800, this.field3801);
			this.field3805 = new class407(this.field3800);
		}

	}

	@ObfuscatedSignature(
		descriptor = "(ILqs;)V"
	)
	public class438(int var1, class436 var2) {
		this(-1L, var1, var2);
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(B)Z",
		garbageValue = "111"
	)
	boolean method2215() {
		return this.field3800 != -1;
	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/Object;I)Ljava/lang/Object;",
		garbageValue = "1480842854"
	)
	public Object method2216(Object var1) {
		synchronized(this) {
			if (this.field3803 != -1L) {
				this.method2219();
			}

			class439 var3 = (class439)this.field3802.get(var1);
			if (var3 == null) {
				return null;
			} else {
				this.method2218(var3, false);
				return var3.field3807;
			}
		}
	}

	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/Object;Ljava/lang/Object;I)Ljava/lang/Object;",
		garbageValue = "-496116903"
	)
	public Object method2217(Object var1, Object var2) {
		synchronized(this) {
			if (this.field3803 != -1L) {
				this.method2219();
			}

			class439 var4 = (class439)this.field3802.get(var1);
			if (var4 != null) {
				Object var8 = var4.field3807;
				var4.field3807 = var2;
				this.method2218(var4, false);
				return var8;
			} else {
				class439 var5;
				if (this.method2215() && this.field3802.size() == this.field3800) {
					var5 = (class439)this.field3805.remove();
					this.field3802.remove(var5.field3808);
					this.field3804.remove(var5);
				}

				var5 = new class439(var2, var1);
				this.field3802.put(var1, var5);
				this.method2218(var5, true);
				return null;
			}
		}
	}

	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "(Lqd;ZI)V",
		garbageValue = "396560222"
	)
	void method2218(class439 var1, boolean var2) {
		if (!var2) {
			this.field3804.remove(var1);
			if (this.method2215() && !this.field3805.remove(var1)) {
				throw new IllegalStateException("");
			}
		}

		var1.field3809 = System.currentTimeMillis();
		if (this.method2215()) {
			switch(this.field3806.field3799) {
			case 0:
				++var1.field3810;
				break;
			case 1:
				var1.field3810 = var1.field3809;
			}

			this.field3805.add(var1);
		}

		this.field3804.add(var1);
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "21"
	)
	void method2219() {
		long var1 = System.currentTimeMillis() - this.field3803;

		while (!this.field3804.isEmpty()) {
			class439 var3 = (class439)this.field3804.peek();
			if (var3.field3809 >= var1) {
				return;
			}

			this.field3802.remove(var3.field3808);
			this.field3804.remove(var3);
			if (this.method2215()) {
				this.field3805.remove(var3);
			}
		}

	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "2"
	)
	@Export("clearFiles")
	public void clearFiles() {
		synchronized(this) {
			this.field3802.clear();
			this.field3804.clear();
			if (this.method2215()) {
				this.field3805.clear();
			}

		}
	}
}