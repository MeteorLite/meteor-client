import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.ArrayList;
import java.util.Iterator;

@ObfuscatedName("pq")
public class class413 extends SongTask {
	@ObfuscatedName("at")
	ArrayList field3745;

	@ObfuscatedSignature(
		descriptor = "(Lql;Ljava/util/ArrayList;)V"
	)
	public class413(SongTask var1, ArrayList var2) {
		super(var1);
		super.field3756 = "ClearRequestTask";
		this.field3745 = var2;
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "-799935345"
	)
	@Export("vmethod2142")
	public boolean vmethod2142() {
		if (this.field3745.isEmpty()) {
			return true;
		} else {
			Iterator var1 = this.field3745.iterator();

			while (var1.hasNext()) {
				MusicSong var2 = (MusicSong)var1.next();

				try {
					if (class316.musicSongs.contains(var2)) {
						if (var2 == null) {
							class316.musicSongs.remove(var2);
						} else {
							if (var2.midiPcmStream.field2830 > 0) {
								--var2.midiPcmStream.field2830;
							}

							if (var2.midiPcmStream.field2830 == 0) {
								var2.midiPcmStream.clear();
								var2.midiPcmStream.method1657();
								var2.midiPcmStream.setPcmStreamVolume(0);
							}

							int var3 = var2.musicTrackGroupId;
							int var4 = var2.musicTrackFileId;
							Iterator var5 = class316.field2793.iterator();

							while (var5.hasNext()) {
								class322 var6 = (class322)var5.next();
								var6.vmethod1644(var3, var4);
							}

							class316.musicSongs.remove(var2);
						}
					}
				} catch (Exception var8) {
					GrandExchangeOfferWorldComparator.RunException_sendStackTrace((String)null, var8);
					this.method2160(var8.getMessage());
					class316.musicSongs.clear();
					return true;
				}
			}

			return true;
		}
	}
}