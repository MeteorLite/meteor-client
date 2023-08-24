import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.*;

@ObfuscatedName("pa")
public class class392 extends AbstractQueue {
	@ObfuscatedName("wh")
	@ObfuscatedSignature(
		descriptor = "Lno;"
	)
	@Export("grandExchangeEvents")
	static GrandExchangeEvents grandExchangeEvents;
	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "[Lps;"
	)
	class390[] field3666;
	@ObfuscatedName("ae")
	Map field3665;
	@ObfuscatedName("ao")
	int field3664;
	@ObfuscatedName("at")
	final Comparator field3667;
	@ObfuscatedName("ac")
	int field3663;

	public class392(int var1, Comparator var2) {
		this.field3663 = 0;
		this.field3666 = new class390[var1];
		this.field3665 = new HashMap();
		this.field3667 = var2;
	}

	public class392(int var1) {
		this(var1, (Comparator)null);
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "0"
	)
	void method2031() {
		int var1 = (this.field3666.length << 1) + 1;
		this.field3666 = (class390[])((class390[])Arrays.copyOf(this.field3666, var1));
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(IB)V",
		garbageValue = "-119"
	)
	void method2032(int var1) {
		class390 var2;
		int var3;
		for (var2 = this.field3666[var1]; var1 > 0; var1 = var3) {
			var3 = var1 - 1 >>> 1;
			class390 var4 = this.field3666[var3];
			if (this.field3667 != null) {
				if (this.field3667.compare(var2.field3658, var4.field3658) >= 0) {
					break;
				}
			} else if (((Comparable)var2.field3658).compareTo(var4.field3658) >= 0) {
				break;
			}

			this.field3666[var1] = var4;
			this.field3666[var1].field3657 = var1;
		}

		this.field3666[var1] = var2;
		this.field3666[var1].field3657 = var1;
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "-466589419"
	)
	void method2033(int var1) {
		class390 var2 = this.field3666[var1];

		int var8;
		for (int var3 = this.field3664 >>> 1; var1 < var3; var1 = var8) {
			int var4 = (var1 << 1) + 1;
			class390 var5 = this.field3666[var4];
			int var6 = (var1 << 1) + 2;
			class390 var7 = this.field3666[var6];
			if (this.field3667 != null) {
				if (var6 < this.field3664 && this.field3667.compare(var5.field3658, var7.field3658) > 0) {
					var8 = var6;
				} else {
					var8 = var4;
				}
			} else if (var6 < this.field3664 && ((Comparable)var5.field3658).compareTo(var7.field3658) > 0) {
				var8 = var6;
			} else {
				var8 = var4;
			}

			if (this.field3667 != null) {
				if (this.field3667.compare(var2.field3658, this.field3666[var8].field3658) <= 0) {
					break;
				}
			} else if (((Comparable)var2.field3658).compareTo(this.field3666[var8].field3658) <= 0) {
				break;
			}

			this.field3666[var1] = this.field3666[var8];
			this.field3666[var1].field3657 = var1;
		}

		this.field3666[var1] = var2;
		this.field3666[var1].field3657 = var1;
	}

	@Export("remove")
	@ObfuscatedName("remove")
	public boolean remove(Object var1) {
		class390 var2 = (class390)this.field3665.remove(var1);
		if (var2 == null) {
			return false;
		} else {
			++this.field3663;
			--this.field3664;
			if (this.field3664 == var2.field3657) {
				this.field3666[this.field3664] = null;
				return true;
			} else {
				class390 var3 = this.field3666[this.field3664];
				this.field3666[this.field3664] = null;
				this.field3666[var2.field3657] = var3;
				this.field3666[var2.field3657].field3657 = var2.field3657;
				this.method2033(var2.field3657);
				if (var3 == this.field3666[var2.field3657]) {
					this.method2032(var2.field3657);
				}

				return true;
			}
		}
	}

	@Export("peek")
	@ObfuscatedName("peek")
	public Object peek() {
		return this.field3664 == 0 ? null : this.field3666[0].field3658;
	}

	@Export("size")
	@ObfuscatedName("size")
	public int size() {
		return this.field3664;
	}

	public boolean offer(Object var1) {
		if (this.field3665.containsKey(var1)) {
			throw new IllegalArgumentException("");
		} else {
			++this.field3663;
			int var2 = this.field3664;
			if (var2 >= this.field3666.length) {
				this.method2031();
			}

			++this.field3664;
			if (var2 == 0) {
				this.field3666[0] = new class390(var1, 0);
				this.field3665.put(var1, this.field3666[0]);
			} else {
				this.field3666[var2] = new class390(var1, var2);
				this.field3665.put(var1, this.field3666[var2]);
				this.method2032(var2);
			}

			return true;
		}
	}

	@Export("poll")
	@ObfuscatedName("poll")
	public Object poll() {
		if (this.field3664 == 0) {
			return null;
		} else {
			++this.field3663;
			Object var1 = this.field3666[0].field3658;
			this.field3665.remove(var1);
			--this.field3664;
			if (this.field3664 == 0) {
				this.field3666[this.field3664] = null;
			} else {
				this.field3666[0] = this.field3666[this.field3664];
				this.field3666[0].field3657 = 0;
				this.field3666[this.field3664] = null;
				this.method2033(0);
			}

			return var1;
		}
	}

	@Export("contains")
	@ObfuscatedName("contains")
	public boolean contains(Object var1) {
		return this.field3665.containsKey(var1);
	}

	@Export("toArray")
	@ObfuscatedName("toArray")
	public Object[] toArray() {
		Object[] var1 = super.toArray();
		if (this.field3667 != null) {
			Arrays.sort(var1, this.field3667);
		} else {
			Arrays.sort(var1);
		}

		return var1;
	}

	@Export("iterator")
	@ObfuscatedName("iterator")
	public Iterator iterator() {
		return new class391(this);
	}
}