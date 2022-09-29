import java.util.AbstractQueue;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("mh")
public class class349 extends AbstractQueue {
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "[Lmp;"
	)
	class347[] field4212;
	@ObfuscatedName("p")
	Map field4213;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = -748861033
	)
	int field4216;
	@ObfuscatedName("n")
	final Comparator field4215;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = 1839339259
	)
	int field4214;

	public class349(int var1, Comparator var2) {
		this.field4214 = 0;
		this.field4212 = new class347[var1];
		this.field4213 = new HashMap();
		this.field4215 = var2;
	}

	public class349(int var1) {
		this(var1, (Comparator)null);
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "-45"
	)
	void method6518() {
		int var1 = (this.field4212.length << 1) + 1;
		this.field4212 = (class347[])((class347[])Arrays.copyOf(this.field4212, var1));
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "-1583792739"
	)
	void method6520(int var1) {
		class347 var2;
		int var3;
		for (var2 = this.field4212[var1]; var1 > 0; var1 = var3) {
			var3 = var1 - 1 >>> 1;
			class347 var4 = this.field4212[var3];
			if (this.field4215 != null) {
				if (this.field4215.compare(var2.field4204, var4.field4204) >= 0) {
					break;
				}
			} else if (((Comparable)var2.field4204).compareTo(var4.field4204) >= 0) {
				break;
			}

			this.field4212[var1] = var4;
			this.field4212[var1].field4206 = var1;
		}

		this.field4212[var1] = var2;
		this.field4212[var1].field4206 = var1;
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		descriptor = "(IB)V",
		garbageValue = "-91"
	)
	void method6521(int var1) {
		class347 var2 = this.field4212[var1];

		int var8;
		for (int var3 = this.field4216 >>> 1; var1 < var3; var1 = var8) {
			int var4 = (var1 << 1) + 1;
			class347 var5 = this.field4212[var4];
			int var6 = (var1 << 1) + 2;
			class347 var7 = this.field4212[var6];
			if (this.field4215 != null) {
				if (var6 < this.field4216 && this.field4215.compare(var5.field4204, var7.field4204) > 0) {
					var8 = var6;
				} else {
					var8 = var4;
				}
			} else if (var6 < this.field4216 && ((Comparable)var5.field4204).compareTo(var7.field4204) > 0) {
				var8 = var6;
			} else {
				var8 = var4;
			}

			if (this.field4215 != null) {
				if (this.field4215.compare(var2.field4204, this.field4212[var8].field4204) <= 0) {
					break;
				}
			} else if (((Comparable)var2.field4204).compareTo(this.field4212[var8].field4204) <= 0) {
				break;
			}

			this.field4212[var1] = this.field4212[var8];
			this.field4212[var1].field4206 = var1;
		}

		this.field4212[var1] = var2;
		this.field4212[var1].field4206 = var1;
	}

	public boolean remove(Object var1) {
		class347 var2 = (class347)this.field4213.remove(var1);
		if (var2 == null) {
			return false;
		} else {
			++this.field4214;
			--this.field4216;
			if (var2.field4206 == this.field4216) {
				this.field4212[this.field4216] = null;
				return true;
			} else {
				class347 var3 = this.field4212[this.field4216];
				this.field4212[this.field4216] = null;
				this.field4212[var2.field4206] = var3;
				this.field4212[var2.field4206].field4206 = var2.field4206;
				this.method6521(var2.field4206);
				if (var3 == this.field4212[var2.field4206]) {
					this.method6520(var2.field4206);
				}

				return true;
			}
		}
	}

	public Object peek() {
		return this.field4216 == 0 ? null : this.field4212[0].field4204;
	}

	public int size() {
		return this.field4216;
	}

	public boolean offer(Object var1) {
		if (this.field4213.containsKey(var1)) {
			throw new IllegalArgumentException("");
		} else {
			++this.field4214;
			int var2 = this.field4216;
			if (var2 >= this.field4212.length) {
				this.method6518();
			}

			++this.field4216;
			if (var2 == 0) {
				this.field4212[0] = new class347(var1, 0);
				this.field4213.put(var1, this.field4212[0]);
			} else {
				this.field4212[var2] = new class347(var1, var2);
				this.field4213.put(var1, this.field4212[var2]);
				this.method6520(var2);
			}

			return true;
		}
	}

	public boolean contains(Object var1) {
		return this.field4213.containsKey(var1);
	}

	public Iterator iterator() {
		return new class348(this);
	}

	public Object poll() {
		if (this.field4216 == 0) {
			return null;
		} else {
			++this.field4214;
			Object var1 = this.field4212[0].field4204;
			this.field4213.remove(var1);
			--this.field4216;
			if (this.field4216 == 0) {
				this.field4212[this.field4216] = null;
			} else {
				this.field4212[0] = this.field4212[this.field4216];
				this.field4212[0].field4206 = 0;
				this.field4212[this.field4216] = null;
				this.method6521(0);
			}

			return var1;
		}
	}

	public Object[] toArray() {
		Object[] var1 = super.toArray();
		if (this.field4215 != null) {
			Arrays.sort(var1, this.field4215);
		} else {
			Arrays.sort(var1);
		}

		return var1;
	}
}
