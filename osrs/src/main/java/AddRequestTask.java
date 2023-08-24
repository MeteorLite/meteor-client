import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.Iterator;

@ObfuscatedName("pf")
@Implements("AddRequestTask")
public class AddRequestTask extends SongTask {
	@ObfuscatedName("tw")
	@ObfuscatedSignature(
		descriptor = "Lbb;"
	)
	@Export("pcmPlayer1")
	static PcmPlayer pcmPlayer1;

	@ObfuscatedSignature(
		descriptor = "(Lpm;)V"
	)
	public AddRequestTask(SongTask var1) {
		super(var1);
		super.field3722 = "AddRequestTask";
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "1604030758"
	)
	public boolean vmethod2142() {
		while (!class305.field2774.isEmpty()) {
			MusicSong var1 = (MusicSong)class305.field2774.peek();
			if (var1 == null) {
				class305.field2774.pop();
			} else {
				var1.midiPcmStream = this.method2123();
				class305.musicSongs.add(var1);
				class305.field2774.pop();
			}
		}

		return true;
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(B)Llf;",
		garbageValue = "53"
	)
	MidiPcmStream method2123() {
		MidiPcmStream var1 = null;
		Iterator var2 = class305.midiPcmStream.iterator();

		while (true) {
			MidiPcmStream var3;
			do {
				do {
					if (!var2.hasNext()) {
						if (var1 != null) {
							++var1.field2809;
							if (var1.method1629() == 0 && var1.isReady()) {
								var1.clear();
								var1.method1633();
								var1.setPcmStreamVolume(0);
							}
						}

						return var1;
					}

					var3 = (MidiPcmStream)var2.next();
				} while(var3 == null);
			} while(var1 != null && var1.field2809 <= var3.field2809 && (var3.method1629() != 0 || !var3.isReady()));

			var1 = var3;
		}
	}

	@ObfuscatedName("ij")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "-71"
	)
	static final void method2124() {
		if (WorldMapIcon_0.field2397) {
			for (int var0 = 0; var0 < Players.Players_count; ++var0) {
				Player var1 = Client.players[Players.Players_indices[var0]];
				var1.clearIsInClanChat();
			}

			WorldMapIcon_0.field2397 = false;
		}

	}
}