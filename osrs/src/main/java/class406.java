import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

@ObfuscatedName("pm")
public class class406 implements Iterator {
	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "Lpn;"
	)
	class407 field3695;
	@ObfuscatedName("al")
	int field3694;
	@ObfuscatedName("ak")
	int field3693;

	@ObfuscatedSignature(
		descriptor = "(Lpn;)V"
	)
	class406(class407 var1) {
		this.field3694 = 0;
		this.field3693 = this.field3695.field3697;
		this.field3695 = var1;
	}

	@Export("hasNext")
	@ObfuscatedName("hasNext")
	public boolean hasNext() {
		return this.field3694 < this.field3695.field3696;
	}

	@Export("next")
	@ObfuscatedName("next")
	public Object next() {
		if (this.field3695.field3697 != this.field3693) {
			throw new ConcurrentModificationException();
		} else if (this.field3694 < this.field3695.field3696) {
			Object var1 = this.field3695.field3699[this.field3694].field3692;
			++this.field3694;
			return var1;
		} else {
			throw new NoSuchElementException();
		}
	}

	@Export("remove")
	@ObfuscatedName("remove")
	public void remove() {
		throw new UnsupportedOperationException();
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(II)Lir;",
		garbageValue = "-1697714323"
	)
	@Export("SpotAnimationDefinition_get")
	public static SpotAnimationDefinition SpotAnimationDefinition_get(int var0) {
		SpotAnimationDefinition var1 = (SpotAnimationDefinition)SpotAnimationDefinition.SpotAnimationDefinition_cached.get((long)var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = SpotAnimationDefinition.SpotAnimationDefinition_archive.takeFile(13, var0);
			var1 = new SpotAnimationDefinition();
			var1.id = var0;
			if (var2 != null) {
				var1.decode(new Buffer(var2));
			}

			SpotAnimationDefinition.SpotAnimationDefinition_cached.put(var1, (long)var0);
			return var1;
		}
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(II)Lfs;",
		garbageValue = "2022917395"
	)
	static class133 method2057(int var0) {
		class133[] var1 = new class133[]{class133.field1257, class133.field1260, class133.field1259, class133.field1262, class133.field1261, class133.field1258};
		class133 var2 = (class133)SequenceDefinition.findEnumerated(var1, var0);
		if (var2 == null) {
			var2 = class133.field1257;
		}

		return var2;
	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "(Lom;IB)Z",
		garbageValue = "1"
	)
	public static boolean method2058(AbstractArchive var0, int var1) {
		byte[] var2 = var0.takeFileFlat(var1);
		if (var2 == null) {
			return false;
		} else {
			class164.SpriteBuffer_decode(var2);
			return true;
		}
	}
}