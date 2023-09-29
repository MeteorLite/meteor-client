import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.applet.Applet;
import java.util.ArrayList;
import java.util.Iterator;

@ObfuscatedName("qi")
public class class416 extends SongTask {
	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "Lnm;"
	)
	@Export("scriptDotWidget")
	static Widget scriptDotWidget;
	@ObfuscatedName("ac")
	ArrayList field3743;

	@ObfuscatedSignature(
		descriptor = "(Lqm;Ljava/util/ArrayList;)V"
	)
	public class416(SongTask var1, ArrayList var2) {
		super(var1);
		super.field3753 = "ClearRequestTask";
		this.field3743 = var2;
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(B)Z",
		garbageValue = "-90"
	)
	@Export("vmethod2142")
	public boolean vmethod2142() {
		if (this.field3743.isEmpty()) {
			return true;
		} else {
			Iterator var1 = this.field3743.iterator();

			while (var1.hasNext()) {
				MusicSong var2 = (MusicSong)var1.next();

				try {
					if (class319.musicSongs.contains(var2)) {
						if (var2 == null) {
							class319.musicSongs.remove(var2);
						} else {
							if (var2.midiPcmStream.field2833 > 0) {
								--var2.midiPcmStream.field2833;
							}

							if (var2.midiPcmStream.field2833 == 0) {
								var2.midiPcmStream.clear();
								var2.midiPcmStream.method1666();
								var2.midiPcmStream.setPcmStreamVolume(0);
							}

							WorldMapDecorationType.method1897(var2.musicTrackGroupId, var2.musicTrackFileId);
							class319.musicSongs.remove(var2);
						}
					}
				} catch (Exception var4) {
					class190.RunException_sendStackTrace((String)null, var4);
					this.method2170(var4.getMessage());
					class319.musicSongs.clear();
					return true;
				}
			}

			return true;
		}
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(Ljava/applet/Applet;Ljava/lang/String;B)V",
		garbageValue = "25"
	)
	public static void method2159(Applet var0, String var1) {
		class31.field83 = var0;
		if (var1 != null) {
			class31.field84 = var1;
		}

	}
}