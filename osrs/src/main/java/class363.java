import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("mk")
public final class class363 {
	@ObfuscatedName("c")
	final Comparator field4312;
	@ObfuscatedName("p")
	final Map field4309;
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		descriptor = "Lmh;"
	)
	final class349 field4307;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		descriptor = "Lmh;"
	)
	final class349 field4308;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		longValue = -2535260607380577403L
	)
	final long field4305;
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		descriptor = "Lmq;"
	)
	final class361 field4310;
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = -1693667935
	)
	final int field4311;

	@ObfuscatedSignature(
		descriptor = "(JILmq;)V"
	)
	class363(long var1, int var3, class361 var4) {
		this.field4312 = new class362(this);
		this.field4305 = var1;
		this.field4311 = var3;
		this.field4310 = var4;
		if (this.field4311 == -1) {
			this.field4309 = new HashMap(64);
			this.field4307 = new class349(64, this.field4312);
			this.field4308 = null;
		} else {
			if (this.field4310 == null) {
				throw new IllegalArgumentException("");
			}

			this.field4309 = new HashMap(this.field4311);
			this.field4307 = new class349(this.field4311, this.field4312);
			this.field4308 = new class349(this.field4311);
		}

	}

	@ObfuscatedSignature(
		descriptor = "(ILmq;)V"
	)
	public class363(int var1, class361 var2) {
		this(-1L, var1, var2);
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "776562823"
	)
	boolean method6747() {
		return this.field4311 != -1;
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/Object;I)Ljava/lang/Object;",
		garbageValue = "1302830563"
	)
	public Object method6758(Object var1) {
		synchronized(this) {
			if (this.field4305 != -1L) {
				this.method6749();
			}

			class364 var3 = (class364)this.field4309.get(var1);
			if (var3 == null) {
				return null;
			} else {
				this.method6748(var3, false);
				return var3.field4319;
			}
		}
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/Object;Ljava/lang/Object;I)Ljava/lang/Object;",
		garbageValue = "904640996"
	)
	public Object method6750(Object var1, Object var2) {
		synchronized(this) {
			if (-1L != this.field4305) {
				this.method6749();
			}

			class364 var4 = (class364)this.field4309.get(var1);
			if (var4 != null) {
				Object var8 = var4.field4319;
				var4.field4319 = var2;
				this.method6748(var4, false);
				return var8;
			} else {
				class364 var5;
				if (this.method6747() && this.field4309.size() == this.field4311) {
					var5 = (class364)this.field4308.remove();
					this.field4309.remove(var5.field4316);
					this.field4307.remove(var5);
				}

				var5 = new class364(var2, var1);
				this.field4309.put(var1, var5);
				this.method6748(var5, true);
				return null;
			}
		}
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		descriptor = "(Lns;ZI)V",
		garbageValue = "1053593547"
	)
	void method6748(class364 var1, boolean var2) {
		if (!var2) {
			this.field4307.remove(var1);
			if (this.method6747() && !this.field4308.remove(var1)) {
				throw new IllegalStateException("");
			}
		}

		var1.field4317 = System.currentTimeMillis();
		if (this.method6747()) {
			switch(this.field4310.field4302) {
			case 0:
				var1.field4318 = var1.field4317;
				break;
			case 1:
				++var1.field4318;
			}

			this.field4308.add(var1);
		}

		this.field4307.add(var1);
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "26"
	)
	void method6749() {
		if (this.field4305 == -1L) {
			throw new IllegalStateException("");
		} else {
			long var1 = System.currentTimeMillis() - this.field4305;

			while (!this.field4307.isEmpty()) {
				class364 var3 = (class364)this.field4307.peek();
				if (var3.field4317 >= var1) {
					return;
				}

				this.field4309.remove(var3.field4316);
				this.field4307.remove(var3);
				if (this.method6747()) {
					this.field4308.remove(var3);
				}
			}

		}
	}
}
