import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.ArrayList;

@ObfuscatedName("pe")
@Implements("ConcurrentMidiTask")
public class ConcurrentMidiTask extends SongTask {
	@ObfuscatedName("au")
	ArrayList field3725;

	@ObfuscatedSignature(
		descriptor = "(Lpm;Ljava/util/ArrayList;)V"
	)
	public ConcurrentMidiTask(SongTask var1, ArrayList var2) {
		super(var1);
		this.field3725 = var2;
		super.field3722 = "ConcurrentMidiTask";
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "1604030758"
	)
	public boolean vmethod2142() {
		for (int var1 = 0; var1 < this.field3725.size(); ++var1) {
			SongTask var2 = (SongTask)this.field3725.get(var1);
			if (var2 == null) {
				this.field3725.remove(var1);
				--var1;
			} else if (var2.vmethod2142()) {
				if (var2.method2132()) {
					this.method2138(var2.method2135());
					this.field3725.clear();
					return true;
				}

				if (var2.method2136() != null) {
					this.field3725.add(var2.method2136());
				}

				super.field3721 = var2.field3721;
				this.field3725.remove(var1);
				--var1;
			}
		}

		if (this.field3725.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
}