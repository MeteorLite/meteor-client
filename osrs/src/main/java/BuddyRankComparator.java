import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eg")
@Implements("BuddyRankComparator")
public class BuddyRankComparator extends AbstractUserComparator {
	@ObfuscatedName("wz")
	@Export("foundItemIdCount")
	static int foundItemIdCount;
	@ObfuscatedName("gw")
	@ObfuscatedSignature(
		descriptor = "Loh;"
	)
	static Archive field1200;
	@ObfuscatedName("at")
	@Export("reversed")
	final boolean reversed;

	public BuddyRankComparator(boolean var1) {
		this.reversed = var1;
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(Lrh;Lrh;B)I",
		garbageValue = "95"
	)
	@Export("compareBuddy")
	int compareBuddy(Buddy var1, Buddy var2) {
		if (var2.rank != var1.rank) {
			return this.reversed ? var1.rank - var2.rank : var2.rank - var1.rank;
		} else {
			return this.compareUser(var1, var2);
		}
	}

	@Export("compare")
	@ObfuscatedName("compare")
	public int compare(Object var1, Object var2) {
		return this.compareBuddy((Buddy)var1, (Buddy)var2);
	}

	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "-457265261"
	)
	public static boolean method687() {
		if (!class316.field2798.isEmpty()) {
			return true;
		} else {
			return !class316.musicSongs.isEmpty() && class316.musicSongs.get(0) != null && ((MusicSong)class316.musicSongs.get(0)).midiPcmStream != null ? ((MusicSong)class316.musicSongs.get(0)).midiPcmStream.isReady() : false;
		}
	}
}