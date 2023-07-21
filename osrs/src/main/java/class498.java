import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("tp")
public class class498 extends class456 implements class284 {
	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "Lnd;"
	)
	final AbstractArchive field4086;
	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "Llj;"
	)
	final DemotingHashTable field4085;
	@ObfuscatedName("am")
	final int field4084;

	@ObfuscatedSignature(
		descriptor = "(Lnu;ILot;Lnd;)V"
	)
	public class498(StudioGame var1, int var2, Language var3, AbstractArchive var4) {
		super(var1, var3, var4 != null ? var4.getGroupFileCount(var2) : 0);
		this.field4085 = new DemotingHashTable(64);
		this.field4086 = var4;
		this.field4084 = var2;
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(II)Lrc;",
		garbageValue = "-1481639468"
	)
	@Export("vmethod8207")
	protected class458 vmethod8207(int var1) {
		synchronized(this.field4085) {
			class457 var2 = (class457)this.field4085.get((long)var1);
			if (var2 == null) {
				var2 = this.method2457(var1);
				this.field4085.method1553(var2, (long)var1);
			}

			return var2;
		}
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(IB)Lrl;",
		garbageValue = "-53"
	)
	class457 method2457(int var1) {
		byte[] var2 = this.field4086.takeFile(this.field4084, var1);
		class457 var3 = new class457(var1);
		if (var2 != null) {
			var3.method2304(new Buffer(var2));
		}

		return var3;
	}

	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "356849458"
	)
	public void method2458() {
		synchronized(this.field4085) {
			this.field4085.clear();
		}
	}

	@Export("iterator")
	@ObfuscatedName("iterator")
	public Iterator iterator() {
		return new class497(this);
	}
}
