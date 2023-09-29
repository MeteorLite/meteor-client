import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.Iterator;

@ObfuscatedName("sc")
public class class492 extends class494 {
	@ObfuscatedName("ac")
	int field3994;
	@ObfuscatedName("al")
	int field3997;
	@ObfuscatedName("ak")
	int field3996;
	@ObfuscatedName("ax")
	int field3999;
	@ObfuscatedName("ao")
	int field3998;
	@ObfuscatedName("ah")
	int field3995;

	public class492(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
		super(var7, var8);
		this.field3994 = 0;
		this.field3997 = 0;
		this.field3996 = 0;
		this.field3999 = 0;
		this.field3998 = 0;
		this.field3995 = 0;
		this.field3994 = var1;
		this.field3997 = var2;
		this.field3996 = var3;
		this.field3999 = var4;
		this.field3998 = var5;
		this.field3995 = var6;
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "-437522182"
	)
	public int vmethod2349() {
		double var1 = this.method2414();
		return (int)Math.round(var1 * (double)(this.field3999 - this.field3994) + (double)this.field3994);
	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "-1670157872"
	)
	public int vmethod2347() {
		double var1 = this.method2414();
		return (int)Math.round((double)this.field3997 + var1 * (double)(this.field3998 - this.field3997));
	}

	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "54"
	)
	public int vmethod2320() {
		double var1 = this.method2414();
		return (int)Math.round((double)this.field3996 + (double)(this.field3995 - this.field3996) * var1);
	}

	@ObfuscatedName("nh")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "69"
	)
	@Export("FriendSystem_invalidateIgnoreds")
	static final void FriendSystem_invalidateIgnoreds() {
		Iterator var0 = Messages.Messages_hashTable.iterator();

		while (var0.hasNext()) {
			Message var1 = (Message)var0.next();
			var1.clearIsFromIgnored();
		}

		if (class358.friendsChat != null) {
			class358.friendsChat.invalidateIgnoreds();
		}

	}
}