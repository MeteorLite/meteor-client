import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.awt.*;

@ObfuscatedName("fx")
public class class151 extends class144 {
	@ObfuscatedName("bg")
	static Image field1359;
	@ObfuscatedName("at")
	boolean field1360;
	@ObfuscatedName("ah")
	byte field1362;
	@ObfuscatedName("ar")
	byte field1364;
	@ObfuscatedName("ao")
	byte field1363;
	@ObfuscatedName("ab")
	byte field1361;
	// $FF: synthetic field
	@ObfuscatedSignature(
		descriptor = "Lfv;"
	)
	final class147 this$0;

	@ObfuscatedSignature(
		descriptor = "(Lfv;)V"
	)
	class151(class147 var1) {
		this.this$0 = var1;
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(Luj;I)V",
		garbageValue = "-734756620"
	)
	@Export("vmethod3254")
	void vmethod3254(Buffer var1) {
		this.field1360 = var1.readUnsignedByte() == 1;
		this.field1362 = var1.readByte();
		this.field1364 = var1.readByte();
		this.field1363 = var1.readByte();
		this.field1361 = var1.readByte();
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(Lfc;I)V",
		garbageValue = "-2111347169"
	)
	@Export("vmethod3248")
	void vmethod3248(ClanSettings var1) {
		var1.allowGuests = this.field1360;
		var1.field1380 = this.field1362;
		var1.field1383 = this.field1364;
		var1.field1381 = this.field1363;
		var1.field1382 = this.field1361;
	}

	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "(II)Lfo;",
		garbageValue = "1476785465"
	)
	static class139 method788(int var0) {
		if (MouseRecorder.method469(var0) != 0) {
			return null;
		} else {
			class139 var2 = (class139)SequenceDefinition.SequenceDefinition_cachedModel.get((long)var0);
			class139 var1;
			if (var2 != null) {
				var1 = var2;
			} else {
				var2 = Login.method437(SequenceDefinition.SequenceDefinition_animationsArchive, SequenceDefinition.SequenceDefinition_skeletonsArchive, var0, false);
				if (var2 != null) {
					SequenceDefinition.SequenceDefinition_cachedModel.put(var2, (long)var0);
				}

				var1 = var2;
			}

			return var1;
		}
	}
}