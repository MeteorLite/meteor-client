import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("qu")
@Implements("IgnoreList")
public class IgnoreList extends UserList {
	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "Lte;"
	)
	final LoginType field3811;

	@ObfuscatedSignature(
		descriptor = "(Lte;)V"
	)
	public IgnoreList(LoginType var1) {
		super(400);
		this.field3811 = var1;
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(I)Lrp;",
		garbageValue = "1002915738"
	)
	@Export("newInstance")
	User newInstance() {
		return new Ignored();
	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "(II)[Lrp;",
		garbageValue = "-1086220070"
	)
	@Export("newTypedArray")
	User[] newTypedArray(int var1) {
		return new Ignored[var1];
	}

	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "(Lul;IB)V",
		garbageValue = "2"
	)
	@Export("read")
	public void read(Buffer var1, int var2) {
		while (var1.offset < var2) {
			int var3 = var1.readUnsignedByte();
			if (var3 == 4) {
				Username var4 = new Username(var1.readStringCp1252NullTerminated(), this.field3811);
				if (!var4.hasCleanName()) {
					throw new IllegalStateException();
				}

				boolean var5 = false;
				InvDefinition.friendSystem.removeIgnore(var4.getName(), var5);
			} else {
				boolean var9 = (var3 & 1) != 0;
				Username var10 = new Username(var1.readStringCp1252NullTerminated(), this.field3811);
				Username var6 = new Username(var1.readStringCp1252NullTerminated(), this.field3811);
				var1.readStringCp1252NullTerminated();
				if (!var10.hasCleanName()) {
					throw new IllegalStateException();
				}

				Ignored var7 = (Ignored)this.getByCurrentUsername(var10);
				if (var9) {
					Ignored var8 = (Ignored)this.getByCurrentUsername(var6);
					if (var8 != null && var7 != var8) {
						if (var7 != null) {
							this.remove(var8);
						} else {
							var7 = var8;
						}
					}
				}

				if (var7 != null) {
					this.changeName(var7, var10, var6);
				} else if (this.getSize() < 400) {
					int var11 = this.getSize();
					var7 = (Ignored)this.addLast(var10, var6);
					var7.id = var11;
				}
			}
		}

	}
}