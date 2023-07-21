import java.util.ArrayList;
import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("pu")
public class class402 extends class407 {
	@ObfuscatedName("aw")
	ArrayList field3699;

	@ObfuscatedSignature(
		descriptor = "(Lpp;Ljava/util/ArrayList;)V"
	)
	public class402(class407 var1, ArrayList var2) {
		super(var1);
		super.field3712 = "ClearRequestTask";
		this.field3699 = var2;
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(II)Z",
		garbageValue = "994462530"
	)
	public boolean vmethod2107(int var1) {
		if (this.field3699.isEmpty()) {
			return true;
		} else {
			Iterator var2 = this.field3699.iterator();

			while (var2.hasNext()) {
				class318 var3 = (class318)var2.next();

				try {
					if (class306.field2756.contains(var3)) {
						if (var3 == null) {
							class306.field2756.remove(var3);
						} else {
							--var3.field2857.field2795;
							if (var3.field2857.field2795 == 0) {
								var3.field2857.clear();
								var3.field2857.method1592();
								var3.field2857.setPcmStreamVolume(0);
							}

							FloorOverlayDefinition.method1052(var3.field2856, var3.field2855);
							class306.field2756.remove(var3);
						}
					}
				} catch (Exception var5) {
					var5.printStackTrace();
					this.method2102(var5.getMessage());
					class306.field2756.clear();
					return true;
				}
			}

			return true;
		}
	}
}
