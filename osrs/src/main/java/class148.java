import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fn")
public class class148 extends class143 {
	@ObfuscatedName("fn")
	@ObfuscatedSignature(
		descriptor = "Lny;"
	)
	static Archive field1335;
	@ObfuscatedName("jb")
	@Export("baseY")
	static int baseY;
	@ObfuscatedName("aw")
	int field1338;
	@ObfuscatedName("ay")
	int field1339;
	@ObfuscatedName("ar")
	int field1337;
	@ObfuscatedName("am")
	int field1336;
	// $FF: synthetic field
	@ObfuscatedSignature(
		descriptor = "Lfr;"
	)
	@Export("this$0")
	@ObfuscatedName("this$0")
	final class146 this$0;

	@ObfuscatedSignature(
		descriptor = "(Lfr;)V"
	)
	class148(class146 var1) {
		this.this$0 = var1;
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(Lty;B)V",
		garbageValue = "1"
	)
	@Export("vmethod3254")
	void vmethod3254(Buffer var1) {
		this.field1338 = var1.readInt();
		this.field1336 = var1.readInt();
		this.field1339 = var1.readUnsignedByte();
		this.field1337 = var1.readUnsignedByte();
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(Lfx;B)V",
		garbageValue = "-72"
	)
	@Export("vmethod3248")
	void vmethod3248(ClanSettings var1) {
		var1.method819(this.field1338, this.field1336, this.field1339, this.field1337);
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(ILrg;Lny;B)V",
		garbageValue = "98"
	)
	static void method779(int var0, ArchiveDisk var1, Archive var2) {
		ArchiveDiskAction var3 = new ArchiveDiskAction();
		var3.type = 1;
		var3.key = (long)var0;
		var3.archiveDisk = var1;
		var3.archive = var2;
		synchronized(ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue) {
			ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue.addFirst(var3);
		}

		class292.method1567();
	}
}
