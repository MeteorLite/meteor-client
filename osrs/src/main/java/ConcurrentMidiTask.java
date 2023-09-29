import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.ArrayList;

@ObfuscatedName("qz")
@Implements("ConcurrentMidiTask")
public class ConcurrentMidiTask extends SongTask {
	@ObfuscatedName("ac")
	ArrayList field3756;

	@ObfuscatedSignature(
		descriptor = "(Lqm;Ljava/util/ArrayList;)V"
	)
	public ConcurrentMidiTask(SongTask var1, ArrayList var2) {
		super(var1);
		this.field3756 = var2;
		super.field3753 = "ConcurrentMidiTask";
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(B)Z",
		garbageValue = "-90"
	)
	@Export("vmethod2142")
	public boolean vmethod2142() {
		for (int var1 = 0; var1 < this.field3756.size(); ++var1) {
			SongTask var2 = (SongTask)this.field3756.get(var1);
			if (var2 == null) {
				this.field3756.remove(var1);
				--var1;
			} else if (var2.vmethod2142()) {
				if (var2.method2165()) {
					this.method2170(var2.method2168());
					this.field3756.clear();
					return true;
				}

				if (var2.method2169() != null) {
					this.field3756.add(var2.method2169());
				}

				super.field3752 = var2.field3752;
				this.field3756.remove(var1);
				--var1;
			}
		}

		if (this.field3756.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	@ObfuscatedName("jf")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-495331166"
	)
	static final void method2173() {
		Client.field481 = 0;
		int var0 = (TextureProvider.localPlayer.x >> 7) + class20.baseX;
		int var1 = (TextureProvider.localPlayer.y >> 7) + class19.baseY;
		if (var0 >= 3053 && var0 <= 3156 && var1 >= 3056 && var1 <= 3136) {
			Client.field481 = 1;
		}

		if (var0 >= 3072 && var0 <= 3118 && var1 >= 9492 && var1 <= 9535) {
			Client.field481 = 1;
		}

		if (Client.field481 == 1 && var0 >= 3139 && var0 <= 3199 && var1 >= 3008 && var1 <= 3062) {
			Client.field481 = 0;
		}

	}
}