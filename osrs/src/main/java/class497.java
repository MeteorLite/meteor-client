import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.Iterator;

@ObfuscatedName("th")
public class class497 extends class455 implements class283 {
	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "Lnu;"
	)
	final AbstractArchive field4096;
	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "Lkg;"
	)
	final DemotingHashTable field4095;
	@ObfuscatedName("at")
	final int field4094;

	@ObfuscatedSignature(
		descriptor = "(Lns;ILon;Lnu;)V"
	)
	public class497(StudioGame var1, int var2, Language var3, AbstractArchive var4) {
		super(var1, var3, var4 != null ? var4.getGroupFileCount(var2) : 0);
		this.field4095 = new DemotingHashTable(64);
		this.field4096 = var4;
		this.field4094 = var2;
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(IB)Lrv;",
		garbageValue = "-32"
	)
	@Export("vmethod8207")
	protected class457 vmethod8207(int var1) {
		synchronized(this.field4095) {
			class456 var2 = (class456)this.field4095.get((long)var1);
			if (var2 == null) {
				var2 = this.method2482(var1);
				this.field4095.method1593(var2, (long)var1);
			}

			return var2;
		}
	}

	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "(IB)Lrg;",
		garbageValue = "-117"
	)
	class456 method2482(int var1) {
		byte[] var2 = this.field4096.takeFile(this.field4094, var1);
		class456 var3 = new class456(var1);
		if (var2 != null) {
			var3.method2327(new Buffer(var2));
		}

		return var3;
	}

	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "322447059"
	)
	public void method2483() {
		synchronized(this.field4095) {
			this.field4095.clear();
		}
	}

	@Export("iterator")
	@ObfuscatedName("iterator")
	public Iterator iterator() {
		return new class496(this);
	}
}