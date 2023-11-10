import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.Iterator;

@ObfuscatedName("pj")
@Implements("AddRequestTask")
public class AddRequestTask extends SongTask {
	@ObfuscatedSignature(
		descriptor = "(Lql;)V"
	)
	public AddRequestTask(SongTask var1) {
		super(var1);
		super.field3756 = "AddRequestTask";
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "-799935345"
	)
	@Export("vmethod2142")
	public boolean vmethod2142() {
		while (!class316.field2790.isEmpty()) {
			MusicSong var1 = (MusicSong)class316.field2790.peek();
			if (var1 == null) {
				class316.field2790.pop();
			} else {
				var1.midiPcmStream = this.method2142();
				class316.musicSongs.add(var1);
				class316.field2790.pop();
			}
		}

		return true;
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(I)Lmn;",
		garbageValue = "1270029666"
	)
	MidiPcmStream method2142() {
		MidiPcmStream var1 = null;
		Iterator var2 = class316.midiPcmStream.iterator();

		while (true) {
			MidiPcmStream var3;
			do {
				do {
					if (!var2.hasNext()) {
						if (var1 != null) {
							++var1.field2830;
							if (var1.method1653() == 0 && var1.isReady()) {
								var1.clear();
								var1.method1657();
								var1.setPcmStreamVolume(0);
							}
						}

						return var1;
					}

					var3 = (MidiPcmStream)var2.next();
				} while(var3 == null);
			} while(var1 != null && var1.field2830 <= var3.field2830 && (var3.method1653() != 0 || !var3.isReady()));

			var1 = var3;
		}
	}
}