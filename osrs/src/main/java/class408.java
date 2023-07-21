import java.util.ArrayList;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("pf")
public class class408 extends class407 {
	@ObfuscatedName("aw")
	ArrayList field3715;

	@ObfuscatedSignature(
		descriptor = "(Lpp;Ljava/util/ArrayList;)V"
	)
	public class408(class407 var1, ArrayList var2) {
		super(var1);
		this.field3715 = var2;
		super.field3712 = "ConcurrentMidiTask";
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(II)Z",
		garbageValue = "994462530"
	)
	public boolean vmethod2107(int var1) {
		for (int var2 = 0; var2 < this.field3715.size(); ++var2) {
			class407 var3 = (class407)this.field3715.get(var2);
			if (var3 == null) {
				this.field3715.remove(var2);
				--var2;
			} else if (var3.vmethod2107(var1)) {
				if (var3.method2098()) {
					this.method2102(var3.method2100());
					this.field3715.clear();
					return true;
				}

				if (var3.method2101() != null) {
					this.field3715.add(var3.method2101());
				}

				super.field3711 = var3.field3711;
				this.field3715.remove(var2);
				--var2;
			}
		}

		if (this.field3715.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "(Lnd;Lnd;IIS)Lpc;",
		garbageValue = "-2870"
	)
	public static Font method2106(AbstractArchive var0, AbstractArchive var1, int var2, int var3) {
		byte[] var5 = var0.takeFile(var2, var3);
		boolean var4;
		if (var5 == null) {
			var4 = false;
		} else {
			VarbitComposition.SpriteBuffer_decode(var5);
			var4 = true;
		}

		if (!var4) {
			return null;
		} else {
			byte[] var6 = var1.takeFile(var2, var3);
			Font var8;
			if (var6 == null) {
				var8 = null;
			} else {
				Font var7 = new Font(var6, class492.SpriteBuffer_xOffsets, class134.SpriteBuffer_yOffsets, class172.SpriteBuffer_spriteWidths, class528.SpriteBuffer_spriteHeights, class528.SpriteBuffer_spritePalette, ArchiveDiskAction.SpriteBuffer_pixels);
				DbTableType.method2483();
				var8 = var7;
			}

			return var8;
		}
	}
}
