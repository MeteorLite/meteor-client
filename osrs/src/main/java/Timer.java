import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("qn")
@Implements("Timer")
public class Timer {
	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "Lfc;"
	)
	static ClanSettings field3782;
	@ObfuscatedName("at")
	long field3790;
	@ObfuscatedName("ah")
	long field3788;
	@ObfuscatedName("ar")
	public boolean field3792;
	@ObfuscatedName("ao")
	long field3789;
	@ObfuscatedName("ab")
	long field3787;
	@ObfuscatedName("au")
	long field3791;
	@ObfuscatedName("aa")
	int field3783;
	@ObfuscatedName("ac")
	int field3784;
	@ObfuscatedName("al")
	int field3785;
	@ObfuscatedName("az")
	int field3786;

	public Timer() {
		this.field3790 = -1L;
		this.field3788 = -1L;
		this.field3792 = false;
		this.field3789 = 0L;
		this.field3787 = 0L;
		this.field3791 = 0L;
		this.field3783 = 0;
		this.field3784 = 0;
		this.field3785 = 0;
		this.field3786 = 0;
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "919653710"
	)
	public void method2170() {
		this.field3790 = SpotAnimationDefinition.method962();
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "587956368"
	)
	public void method2171() {
		if (this.field3790 != -1L) {
			this.field3787 = SpotAnimationDefinition.method962() - this.field3790;
			this.field3790 = -1L;
		}

	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "1512116667"
	)
	public void method2172(int var1) {
		this.field3788 = SpotAnimationDefinition.method962();
		this.field3783 = var1;
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "-7"
	)
	public void method2173() {
		if (-1L != this.field3788) {
			this.field3789 = SpotAnimationDefinition.method962() - this.field3788;
			this.field3788 = -1L;
		}

		++this.field3785;
		this.field3792 = true;
	}

	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "2032251318"
	)
	public void method2174() {
		this.field3792 = false;
		this.field3784 = 0;
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "36"
	)
	public void method2175() {
		this.method2173();
	}

	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "(Luj;I)V",
		garbageValue = "221618490"
	)
	@Export("write")
	public void write(Buffer var1) {
		long var2 = this.field3787;
		var2 /= 10L;
		if (var2 < 0L) {
			var2 = 0L;
		} else if (var2 > 65535L) {
			var2 = 65535L;
		}

		var1.writeShort((int)var2);
		long var4 = this.field3789;
		var4 /= 10L;
		if (var4 < 0L) {
			var4 = 0L;
		} else if (var4 > 65535L) {
			var4 = 65535L;
		}

		var1.writeShort((int)var4);
		long var6 = this.field3791;
		var6 /= 10L;
		if (var6 < 0L) {
			var6 = 0L;
		} else if (var6 > 65535L) {
			var6 = 65535L;
		}

		var1.writeShort((int)var6);
		var1.writeShort(this.field3783);
		var1.writeShort(this.field3784);
		var1.writeShort(this.field3785);
		var1.writeShort(this.field3786);
	}
}