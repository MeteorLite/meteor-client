import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bs")
public class class33 {
	@ObfuscatedName("um")
	@Export("cameraMoveToY")
	static int cameraMoveToY;
	@ObfuscatedName("un")
	@Export("cameraLookAtSpeed")
	static int cameraLookAtSpeed;
	@ObfuscatedName("az")
	int field92;
	@ObfuscatedName("ap")
	int field91;

	class33(int var1, int var2) {
		this.field92 = var1;
		this.field91 = var2;
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(Lbv;I)Z",
		garbageValue = "625917301"
	)
	boolean method130(class29 var1) {
		if (var1 == null) {
			return false;
		} else {
			switch(this.field92) {
			case 1:
				return var1.vmethod3949(this.field91);
			case 2:
				return var1.vmethod3989(this.field91);
			case 3:
				return var1.vmethod3951((char)this.field91);
			case 4:
				return var1.vmethod3953(this.field91 == 1);
			default:
				return false;
			}
		}
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(IIIII)I",
		garbageValue = "-795893337"
	)
	static final int method129(int var0, int var1, int var2, int var3) {
		return var0 * var2 + var3 * var1 >> 16;
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(II)Lco;",
		garbageValue = "-1816107521"
	)
	@Export("Messages_getMessage")
	static Message Messages_getMessage(int var0) {
		return (Message)Messages.Messages_hashTable.get((long)var0);
	}
}