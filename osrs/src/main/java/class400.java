import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("pe")
public class class400 extends class407 {
	@ObfuscatedSignature(
		descriptor = "(Lpp;)V"
	)
	public class400(class407 var1) {
		super(var1);
		super.field3712 = "AddRequestTask";
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(II)Z",
		garbageValue = "994462530"
	)
	public boolean vmethod2107(int var1) {
		while (!class306.field2758.isEmpty()) {
			class318 var2 = (class318)class306.field2758.peek();
			if (var2 == null) {
				class306.field2758.pop();
			} else {
				var2.field2857 = this.method2084();
				class306.field2756.add(var2);
				class306.field2758.pop();
			}
		}

		return true;
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(I)Llc;",
		garbageValue = "1784609156"
	)
	MidiPcmStream method2084() {
		MidiPcmStream var1 = null;
		Iterator var2 = class306.midiPcmStream.iterator();

		while (true) {
			MidiPcmStream var3;
			do {
				do {
					if (!var2.hasNext()) {
						if (var1 != null) {
							++var1.field2795;
							if (var1.method1588() == 0 && var1.isReady()) {
								var1.clear();
								var1.method1592();
								var1.setPcmStreamVolume(0);
							}
						}

						return var1;
					}

					var3 = (MidiPcmStream)var2.next();
				} while(var3 == null);
			} while(var1 != null && var1.field2795 <= var3.field2795 && (var3.field2795 != var1.field2795 || var3.method1588() != 0 || !var3.isReady()));

			var1 = var3;
		}
	}

	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		descriptor = "(Lmt;I[B[BS)V",
		garbageValue = "24138"
	)
	@Export("Widget_setKey")
	static final void Widget_setKey(Widget var0, int var1, byte[] var2, byte[] var3) {
		if (var0.field2960 == null) {
			if (var2 == null) {
				return;
			}

			var0.field2960 = new byte[11][];
			var0.field2959 = new byte[11][];
			var0.field3028 = new int[11];
			var0.field3029 = new int[11];
		}

		var0.field2960[var1] = var2;
		if (var2 != null) {
			var0.field2951 = true;
		} else {
			var0.field2951 = false;

			for (int var4 = 0; var4 < var0.field2960.length; ++var4) {
				if (var0.field2960[var4] != null) {
					var0.field2951 = true;
					break;
				}
			}
		}

		var0.field2959[var1] = var3;
	}
}
