import java.util.ArrayList;
import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("pu")
public class class402 extends SongTask {
	@ObfuscatedName("aw")
	ArrayList field3699;

	@ObfuscatedSignature(
		descriptor = "(Lpp;Ljava/util/ArrayList;)V"
	)
	public class402(SongTask var1, ArrayList var2) {
		super(var1);
		super.field3712 = "ClearRequestTask";
		this.field3699 = var2;
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(II)Z",
		garbageValue = "994462530"
	)
	public boolean vmethod2107(int var1) {
		if (this.field3699.isEmpty()) {
			return true;
		} else {
			Iterator var2 = this.field3699.iterator();

			while (var2.hasNext()) {
				MusicSong var3 = (MusicSong)var2.next();

				try {
					if (class306.musicSongs.contains(var3)) {
						if (var3 == null) {
							class306.musicSongs.remove(var3);
						} else {
							--var3.midiPcmStream.field2795;
							if (var3.midiPcmStream.field2795 == 0) {
								var3.midiPcmStream.clear();
								var3.midiPcmStream.method1592();
								var3.midiPcmStream.setPcmStreamVolume(0);
							}

							FloorOverlayDefinition.method1052(var3.musicTrackGroupId, var3.musicTrackFileId);
							class306.musicSongs.remove(var3);
						}
					}
				} catch (Exception var5) {
					var5.printStackTrace();
					this.method2102(var5.getMessage());
					class306.musicSongs.clear();
					return true;
				}
			}

			return true;
		}
	}
}
