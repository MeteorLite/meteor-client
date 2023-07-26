import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("pm")
@Implements("Timer")
public class Timer {
	@ObfuscatedName("aw")
	long field3745;
	@ObfuscatedName("ay")
	long field3746;
	@ObfuscatedName("ar")
	public boolean field3747;
	@ObfuscatedName("am")
	long field3743;
	@ObfuscatedName("as")
	long field3744;
	@ObfuscatedName("aj")
	long field3742;
	@ObfuscatedName("ag")
	int field3738;
	@ObfuscatedName("az")
	int field3741;
	@ObfuscatedName("av")
	int field3740;
	@ObfuscatedName("ap")
	int field3739;

	public Timer() {
		this.field3745 = -1L;
		this.field3746 = -1L;
		this.field3747 = false;
		this.field3743 = 0L;
		this.field3744 = 0L;
		this.field3742 = 0L;
		this.field3738 = 0;
		this.field3741 = 0;
		this.field3740 = 0;
		this.field3739 = 0;
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(S)V",
		garbageValue = "4160"
	)
	public void method2112() {
		this.field3745 = class113.clockNow();
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-1471320567"
	)
	public void method2113() {
		if (this.field3745 != -1L) {
			this.field3744 = class113.clockNow() - this.field3745;
			this.field3745 = -1L;
		}

	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "-1578635933"
	)
	public void method2115(int var1) {
		this.field3746 = class113.clockNow();
		this.field3738 = var1;
	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-1011224380"
	)
	public void method2116() {
		if (-1L != this.field3746) {
			this.field3743 = class113.clockNow() - this.field3746;
			this.field3746 = -1L;
		}

		++this.field3740;
		this.field3747 = true;
	}

	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-1728500698"
	)
	public void method2117() {
		this.field3747 = false;
		this.field3741 = 0;
	}

	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-2026051280"
	)
	public void method2118() {
		this.method2116();
	}

	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		descriptor = "(Lty;B)V",
		garbageValue = "22"
	)
	@Export("write")
	public void write(Buffer var1) {
		Message.method345(var1, this.field3744);
		Message.method345(var1, this.field3743);
		Message.method345(var1, this.field3742);
		var1.writeShort(this.field3738);
		var1.writeShort(this.field3741);
		var1.writeShort(this.field3740);
		var1.writeShort(this.field3739);
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(IB)I",
		garbageValue = "-6"
	)
	public static int method2114(int var0) {
		return (var0 & class509.field4110) - 1;
	}
}
