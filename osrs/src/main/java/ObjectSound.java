import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cy")
@Implements("ObjectSound")
public final class ObjectSound extends Node {
	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "Lod;"
	)
	@Export("objectSounds")
	static NodeDeque objectSounds;
	@ObfuscatedName("ay")
	@Export("plane")
	int plane;
	@ObfuscatedName("ar")
	@Export("x")
	int x;
	@ObfuscatedName("am")
	@Export("y")
	int y;
	@ObfuscatedName("as")
	@Export("maxX")
	int maxX;
	@ObfuscatedName("aj")
	@Export("maxY")
	int maxY;
	@ObfuscatedName("ag")
	int field687;
	@ObfuscatedName("az")
	@Export("soundEffectId")
	int soundEffectId;
	@ObfuscatedName("av")
	@ObfuscatedSignature(
		descriptor = "Lbt;"
	)
	@Export("stream1")
	RawPcmStream stream1;
	@ObfuscatedName("ap")
	int field691;
	@ObfuscatedName("aq")
	int field692;
	@ObfuscatedName("at")
	@Export("soundEffectIds")
	int[] soundEffectIds;
	@ObfuscatedName("ah")
	int field688;
	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "Lbt;"
	)
	@Export("stream2")
	RawPcmStream stream2;
	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "Lhb;"
	)
	@Export("obj")
	ObjectComposition obj;

	static {
		objectSounds = new NodeDeque();
	}

	ObjectSound() {
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "1847013025"
	)
	@Export("set")
	void set() {
		int var1 = this.soundEffectId;
		ObjectComposition var2 = this.obj.transform();
		if (var2 != null) {
			this.soundEffectId = var2.ambientSoundId;
			this.field687 = var2.int7 * 128;
			this.field691 = var2.int5;
			this.field692 = var2.int6;
			this.soundEffectIds = var2.soundEffectIds;
		} else {
			this.soundEffectId = -1;
			this.field687 = 0;
			this.field691 = 0;
			this.field692 = 0;
			this.soundEffectIds = null;
		}

		if (var1 != this.soundEffectId && this.stream1 != null) {
			SecureRandomCallable.pcmStreamMixer.removeSubStream(this.stream1);
			this.stream1 = null;
		}

	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(IIB)I",
		garbageValue = "0"
	)
	static int method422(int var0, int var1) {
		ItemContainer var2 = (ItemContainer)ItemContainer.itemContainers.get((long)var0);
		if (var2 == null) {
			return 0;
		} else if (var1 == -1) {
			return 0;
		} else {
			int var3 = 0;

			for (int var4 = 0; var4 < var2.quantities.length; ++var4) {
				if (var2.ids[var4] == var1) {
					var3 += var2.quantities[var4];
				}
			}

			return var3;
		}
	}
}
