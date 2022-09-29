import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("mu")
@Implements("Timer")
public class Timer {
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		longValue = -3926726354020327003L
	)
	long field4268;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		longValue = -1127738657898247179L
	)
	long field4272;
	@ObfuscatedName("f")
	public boolean field4265;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		longValue = -6950914943070846117L
	)
	long field4266;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		longValue = 5923765781629435585L
	)
	long field4267;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		longValue = 5285216938933534565L
	)
	long field4263;
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = 1510518223
	)
	int field4269;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = -578071481
	)
	int field4270;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = 1628135725
	)
	int field4271;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = -1569242559
	)
	int field4264;

	public Timer() {
		this.field4268 = -1L;
		this.field4272 = -1L;
		this.field4265 = false;
		this.field4266 = 0L;
		this.field4267 = 0L;
		this.field4263 = 0L;
		this.field4269 = 0;
		this.field4270 = 0;
		this.field4271 = 0;
		this.field4264 = 0;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "894218512"
	)
	public void method6702() {
		this.field4268 = Language.method6232();
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-645941723"
	)
	public void method6707() {
		if (-1L != this.field4268) {
			this.field4267 = Language.method6232() - this.field4268;
			this.field4268 = -1L;
		}

	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "-1357516830"
	)
	public void method6704(int var1) {
		this.field4272 = Language.method6232();
		this.field4269 = var1;
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "-40"
	)
	public void method6701() {
		if (-1L != this.field4272) {
			this.field4266 = Language.method6232() - this.field4272;
			this.field4272 = -1L;
		}

		++this.field4271;
		this.field4265 = true;
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "-10"
	)
	public void method6724() {
		this.field4265 = false;
		this.field4270 = 0;
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-1307557155"
	)
	public void method6725() {
		this.method6701();
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		descriptor = "(Lqq;I)V",
		garbageValue = "456320258"
	)
	@Export("write")
	public void write(Buffer var1) {
		class33.method643(var1, this.field4267);
		class33.method643(var1, this.field4266);
		class33.method643(var1, this.field4263);
		var1.writeShort(this.field4269);
		var1.writeShort(this.field4270);
		var1.writeShort(this.field4271);
		var1.writeShort(this.field4264);
	}
}
