import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bv")
public class class33 {
	@ObfuscatedName("aq")
	public static short[] field89;
	@ObfuscatedName("oo")
	@Export("selectedSpellWidget")
	static int selectedSpellWidget;
	@ObfuscatedName("ag")
	int field91;
	@ObfuscatedName("az")
	int field92;

	class33(int var1, int var2) {
		this.field91 = var1;
		this.field92 = var2;
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(Lba;S)Z",
		garbageValue = "-1563"
	)
	boolean method134(class29 var1) {
		if (var1 == null) {
			return false;
		} else {
			switch(this.field91) {
			case 1:
				return var1.vmethod3949(this.field92);
			case 2:
				return var1.vmethod3989(this.field92);
			case 3:
				return var1.vmethod3951((char)this.field92);
			case 4:
				return var1.vmethod3953(this.field92 == 1);
			default:
				return false;
			}
		}
	}
}
