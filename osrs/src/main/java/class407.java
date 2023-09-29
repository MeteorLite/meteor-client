import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.*;

@ObfuscatedName("pn")
public class class407 extends AbstractQueue {
	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "[Lpd;"
	)
	class405[] field3699;
	@ObfuscatedName("al")
	Map field3698;
	@ObfuscatedName("ak")
	int field3696;
	@ObfuscatedName("ax")
	final Comparator field3700;
	@ObfuscatedName("ao")
	int field3697;

	public class407(int var1, Comparator var2) {
		this.field3697 = 0;
		this.field3699 = new class405[var1];
		this.field3698 = new HashMap();
		this.field3700 = var2;
	}

	public class407(int var1) {
		this(var1, (Comparator)null);
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "677116728"
	)
	void method2059() {
		int var1 = (this.field3699.length << 1) + 1;
		this.field3699 = (class405[])((class405[])Arrays.copyOf(this.field3699, var1));
	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "1848491495"
	)
	void method2060(int var1) {
		class405 var2;
		int var3;
		for (var2 = this.field3699[var1]; var1 > 0; var1 = var3) {
			var3 = var1 - 1 >>> 1;
			class405 var4 = this.field3699[var3];
			if (this.field3700 != null) {
				if (this.field3700.compare(var2.field3692, var4.field3692) >= 0) {
					break;
				}
			} else if (((Comparable)var2.field3692).compareTo(var4.field3692) >= 0) {
				break;
			}

			this.field3699[var1] = var4;
			this.field3699[var1].field3691 = var1;
		}

		this.field3699[var1] = var2;
		this.field3699[var1].field3691 = var1;
	}

	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "-1866393303"
	)
	void method2061(int var1) {
		class405 var2 = this.field3699[var1];

		int var8;
		for (int var3 = this.field3696 >>> 1; var1 < var3; var1 = var8) {
			int var4 = (var1 << 1) + 1;
			class405 var5 = this.field3699[var4];
			int var6 = (var1 << 1) + 2;
			class405 var7 = this.field3699[var6];
			if (this.field3700 != null) {
				if (var6 < this.field3696 && this.field3700.compare(var5.field3692, var7.field3692) > 0) {
					var8 = var6;
				} else {
					var8 = var4;
				}
			} else if (var6 < this.field3696 && ((Comparable)var5.field3692).compareTo(var7.field3692) > 0) {
				var8 = var6;
			} else {
				var8 = var4;
			}

			if (this.field3700 != null) {
				if (this.field3700.compare(var2.field3692, this.field3699[var8].field3692) <= 0) {
					break;
				}
			} else if (((Comparable)var2.field3692).compareTo(this.field3699[var8].field3692) <= 0) {
				break;
			}

			this.field3699[var1] = this.field3699[var8];
			this.field3699[var1].field3691 = var1;
		}

		this.field3699[var1] = var2;
		this.field3699[var1].field3691 = var1;
	}

	@Export("remove")
	@ObfuscatedName("remove")
	public boolean remove(Object var1) {
		class405 var2 = (class405)this.field3698.remove(var1);
		if (var2 == null) {
			return false;
		} else {
			++this.field3697;
			--this.field3696;
			if (this.field3696 == var2.field3691) {
				this.field3699[this.field3696] = null;
				return true;
			} else {
				class405 var3 = this.field3699[this.field3696];
				this.field3699[this.field3696] = null;
				this.field3699[var2.field3691] = var3;
				this.field3699[var2.field3691].field3691 = var2.field3691;
				this.method2061(var2.field3691);
				if (var3 == this.field3699[var2.field3691]) {
					this.method2060(var2.field3691);
				}

				return true;
			}
		}
	}

	@Export("peek")
	@ObfuscatedName("peek")
	public Object peek() {
		return this.field3696 == 0 ? null : this.field3699[0].field3692;
	}

	@Export("size")
	@ObfuscatedName("size")
	public int size() {
		return this.field3696;
	}

	@Export("offer")
	@ObfuscatedName("offer")
	public boolean offer(Object var1) {
		if (this.field3698.containsKey(var1)) {
			throw new IllegalArgumentException("");
		} else {
			++this.field3697;
			int var2 = this.field3696;
			if (var2 >= this.field3699.length) {
				this.method2059();
			}

			++this.field3696;
			if (var2 == 0) {
				this.field3699[0] = new class405(var1, 0);
				this.field3698.put(var1, this.field3699[0]);
			} else {
				this.field3699[var2] = new class405(var1, var2);
				this.field3698.put(var1, this.field3699[var2]);
				this.method2060(var2);
			}

			return true;
		}
	}

	@Export("poll")
	@ObfuscatedName("poll")
	public Object poll() {
		if (this.field3696 == 0) {
			return null;
		} else {
			++this.field3697;
			Object var1 = this.field3699[0].field3692;
			this.field3698.remove(var1);
			--this.field3696;
			if (this.field3696 == 0) {
				this.field3699[this.field3696] = null;
			} else {
				this.field3699[0] = this.field3699[this.field3696];
				this.field3699[0].field3691 = 0;
				this.field3699[this.field3696] = null;
				this.method2061(0);
			}

			return var1;
		}
	}

	@Export("contains")
	@ObfuscatedName("contains")
	public boolean contains(Object var1) {
		return this.field3698.containsKey(var1);
	}

	@Export("toArray")
	@ObfuscatedName("toArray")
	public Object[] toArray() {
		Object[] var1 = super.toArray();
		if (this.field3700 != null) {
			Arrays.sort(var1, this.field3700);
		} else {
			Arrays.sort(var1);
		}

		return var1;
	}

	@Export("iterator")
	@ObfuscatedName("iterator")
	public Iterator iterator() {
		return new class406(this);
	}

	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "-105"
	)
	public static void method2062() {
		class326.SpriteBuffer_xOffsets = null;
		ModelData0.SpriteBuffer_yOffsets = null;
		class59.SpriteBuffer_spriteWidths = null;
		class544.SpriteBuffer_spriteHeights = null;
		class372.SpriteBuffer_spritePalette = null;
		AddRequestTask.SpriteBuffer_pixels = null;
	}
}