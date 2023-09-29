import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.ArrayList;
import java.util.Comparator;

@ObfuscatedName("qp")
class class437 implements Comparator {
	// $FF: synthetic field
	@ObfuscatedSignature(
		descriptor = "Lqe;"
	)
	@Export("this$0")
	@ObfuscatedName("this$0")
	final class438 this$0;

	@ObfuscatedSignature(
		descriptor = "(Lqe;)V"
	)
	class437(class438 var1) {
		this.this$0 = var1;
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(Lqd;Lqd;I)I",
		garbageValue = "-199204638"
	)
	int method2213(class439 var1, class439 var2) {
		if (var1.field3809 > var2.field3809) {
			return 1;
		} else {
			return var1.field3809 < var2.field3809 ? -1 : 0;
		}
	}

	@Export("compare")
	@ObfuscatedName("compare")
	public int compare(Object var1, Object var2) {
		return this.method2213((class439)var1, (class439)var2);
	}

	@Export("equals")
	@ObfuscatedName("equals")
	public boolean equals(Object var1) {
		return super.equals(var1);
	}

	@ObfuscatedName("im")
	@ObfuscatedSignature(
		descriptor = "(III)V",
		garbageValue = "-1139961954"
	)
	@Export("playJingle")
	static void playJingle(int var0, int var1) {
		if (class91.clientPreferences.getCurrentMusicVolume() != 0 && var0 != -1) {
			ArrayList var2 = new ArrayList();
			var2.add(new MusicSong(Language.field3643, var0, 0, class91.clientPreferences.getCurrentMusicVolume(), false));
			class148.method776(var2, 0, 0, 0, 0, true);
			Client.playingJingle = true;
		}

	}
}