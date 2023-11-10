import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.Iterator;

@ObfuscatedName("tl")
public class class509 extends class467 implements class294 {
	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "Lol;"
	)
	final AbstractArchive field4122;
	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "Lls;"
	)
	final DemotingHashTable field4121;
	@ObfuscatedName("ao")
	final int field4120;

	@ObfuscatedSignature(
		descriptor = "(Lnt;ILof;Lol;)V"
	)
	public class509(StudioGame var1, int var2, Language var3, AbstractArchive var4) {
		super(var1, var3, var4 != null ? var4.getGroupFileCount(var2) : 0);
		this.field4121 = new DemotingHashTable(64);
		this.field4122 = var4;
		this.field4120 = var2;
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(IB)Lsj;",
		garbageValue = "-61"
	)
	@Export("vmethod8207")
	protected class469 vmethod8207(int var1) {
		synchronized(this.field4121) {
			class468 var2 = (class468)this.field4121.get((long)var1);
			if (var2 == null) {
				var2 = this.method2492(var1);
				this.field4121.method1611(var2, (long)var1);
			}

			return var2;
		}
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(IB)Lsg;",
		garbageValue = "0"
	)
	class468 method2492(int var1) {
		byte[] var2 = this.field4122.takeFile(this.field4120, var1);
		class468 var3 = new class468(var1);
		if (var2 != null) {
			var3.method2343(new Buffer(var2));
		}

		return var3;
	}

	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-985406624"
	)
	public void method2493() {
		synchronized(this.field4121) {
			this.field4121.clear();
		}
	}

	@Export("iterator")
	@ObfuscatedName("iterator")
	public Iterator iterator() {
		return new class508(this);
	}
}