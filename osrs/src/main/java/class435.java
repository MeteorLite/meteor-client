import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

@ObfuscatedName("qc")
public final class class435 {
	@ObfuscatedName("at")
	final Comparator field3805;
	@ObfuscatedName("ah")
	final Map field3806;
	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "Lps;"
	)
	final class404 field3809;
	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "Lps;"
	)
	final class404 field3808;
	@ObfuscatedName("ab")
	final long field3807;
	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "Lqm;"
	)
	final class433 field3810;
	@ObfuscatedName("aa")
	final int field3804;

	@ObfuscatedSignature(
		descriptor = "(JILqm;)V"
	)
	class435(long var1, int var3, class433 var4) {
		this.field3805 = new class434(this);
		this.field3807 = var1;
		this.field3804 = var3;
		this.field3810 = var4;
		if (this.field3804 == -1) {
			this.field3806 = new HashMap(64);
			this.field3809 = new class404(64, this.field3805);
			this.field3808 = null;
		} else {
			if (this.field3810 == null) {
				throw new IllegalArgumentException("");
			}

			this.field3806 = new HashMap(this.field3804);
			this.field3809 = new class404(this.field3804, this.field3805);
			this.field3808 = new class404(this.field3804);
		}

	}

	@ObfuscatedSignature(
		descriptor = "(ILqm;)V"
	)
	public class435(int var1, class433 var2) {
		this(-1L, var1, var2);
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(B)Z",
		garbageValue = "2"
	)
	boolean method2195() {
		return this.field3804 != -1;
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/Object;B)Ljava/lang/Object;",
		garbageValue = "122"
	)
	public Object method2196(Object var1) {
		synchronized(this) {
			if (-1L != this.field3807) {
				this.method2199();
			}

			class436 var3 = (class436)this.field3806.get(var1);
			if (var3 == null) {
				return null;
			} else {
				this.method2198(var3, false);
				return var3.field3812;
			}
		}
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/Object;Ljava/lang/Object;I)Ljava/lang/Object;",
		garbageValue = "1227309321"
	)
	public Object method2197(Object var1, Object var2) {
		synchronized(this) {
			if (this.field3807 != -1L) {
				this.method2199();
			}

			class436 var4 = (class436)this.field3806.get(var1);
			if (var4 != null) {
				Object var8 = var4.field3812;
				var4.field3812 = var2;
				this.method2198(var4, false);
				return var8;
			} else {
				class436 var5;
				if (this.method2195() && this.field3806.size() == this.field3804) {
					var5 = (class436)this.field3808.remove();
					this.field3806.remove(var5.field3811);
					this.field3809.remove(var5);
				}

				var5 = new class436(var2, var1);
				this.field3806.put(var1, var5);
				this.method2198(var5, true);
				return null;
			}
		}
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(Lqe;ZB)V",
		garbageValue = "14"
	)
	void method2198(class436 var1, boolean var2) {
		if (!var2) {
			this.field3809.remove(var1);
			if (this.method2195()) {
			}
		}

		var1.field3814 = System.currentTimeMillis();
		if (this.method2195()) {
			switch(this.field3810.field3803) {
			case 0:
				++var1.field3813;
				break;
			case 1:
				var1.field3813 = var1.field3814;
			}

			this.field3808.add(var1);
		}

		this.field3809.add(var1);
	}

	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-704318355"
	)
	void method2199() {
		if (this.field3807 == -1L) {
			throw new IllegalStateException("");
		} else {
			long var1 = System.currentTimeMillis() - this.field3807;

			while (!this.field3809.isEmpty()) {
				class436 var3 = (class436)this.field3809.peek();
				if (var3.field3814 >= var1) {
					return;
				}

				this.field3806.remove(var3.field3811);
				this.field3809.remove(var3);
				if (this.method2195()) {
					this.field3808.remove(var3);
				}
			}

		}
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-189414151"
	)
	@Export("clearFiles")
	public void clearFiles() {
		synchronized(this) {
			this.field3806.clear();
			this.field3809.clear();
			if (this.method2195()) {
				this.field3808.clear();
			}

		}
	}

	@ObfuscatedName("in")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "12"
	)
	static final void method2201() {
		if (Client.field535 != ItemLayer.Client_plane) {
			Client.field535 = ItemLayer.Client_plane;
			WorldMapDecoration.method1330(ItemLayer.Client_plane);
		}

	}
}