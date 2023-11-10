import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.ArrayList;

@ObfuscatedName("qu")
@Implements("ConcurrentMidiTask")
public class ConcurrentMidiTask extends SongTask {
	@ObfuscatedName("at")
	ArrayList field3759;

	@ObfuscatedSignature(
		descriptor = "(Lql;Ljava/util/ArrayList;)V"
	)
	public ConcurrentMidiTask(SongTask var1, ArrayList var2) {
		super(var1);
		this.field3759 = var2;
		super.field3756 = "ConcurrentMidiTask";
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "-799935345"
	)
	@Export("vmethod2142")
	public boolean vmethod2142() {
		for (int var1 = 0; var1 < this.field3759.size(); ++var1) {
			SongTask var2 = (SongTask)this.field3759.get(var1);
			if (var2 == null) {
				this.field3759.remove(var1);
				--var1;
			} else if (var2.vmethod2142()) {
				if (var2.method2156()) {
					this.method2160(var2.method2158());
					this.field3759.clear();
					return true;
				}

				if (var2.method2159() != null) {
					this.field3759.add(var2.method2159());
				}

				super.field3754 = var2.field3754;
				this.field3759.remove(var1);
				--var1;
			}
		}

		if (this.field3759.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
}