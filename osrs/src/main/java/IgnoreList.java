import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("qm")
@Implements("IgnoreList")
public class IgnoreList extends UserList {
	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "Lsi;"
	)
	final LoginType field3771;

	@ObfuscatedSignature(
		descriptor = "(Lsi;)V"
	)
	public IgnoreList(LoginType var1) {
		super(400);
		this.field3771 = var1;
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(S)Lqe;",
		garbageValue = "3401"
	)
	@Export("newInstance")
	User newInstance() {
		return new Ignored();
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(IB)[Lqe;",
		garbageValue = "7"
	)
	@Export("newTypedArray")
	User[] newTypedArray(int var1) {
		return new Ignored[var1];
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(Lty;II)V",
		garbageValue = "1365602141"
	)
	@Export("read")
	public void read(Buffer var1, int var2) {
		while (var1.offset < var2) {
			int var3 = var1.readUnsignedByte();
			if (var3 == 4) {
				Username var4 = new Username(var1.readStringCp1252NullTerminated(), this.field3771);
				boolean var5 = false;
				class177.friendSystem.removeIgnore(var4.getName(), var5);
			} else {
				boolean var9 = (var3 & 1) != 0;
				Username var10 = new Username(var1.readStringCp1252NullTerminated(), this.field3771);
				Username var6 = new Username(var1.readStringCp1252NullTerminated(), this.field3771);
				var1.readStringCp1252NullTerminated();
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
