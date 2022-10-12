import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ny")
@Implements("FriendsList")
public class FriendsList extends UserList {
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "Lqu;"
	)
	@Export("loginType")
	final LoginType loginType;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = -2045646185
	)
	int field4457;
	@ObfuscatedName("h")
	@ObfuscatedSignature(
		descriptor = "Lmf;"
	)
	public class351 field4461;

	@ObfuscatedSignature(
		descriptor = "(Lqu;)V"
	)
	public FriendsList(LoginType var1) {
		super(400);
		this.field4457 = 1;
		this.field4461 = new class351();
		this.loginType = var1;
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		descriptor = "(B)Loj;",
		garbageValue = "31"
	)
	@Export("newInstance")
	User newInstance() {
		return new Friend();
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		descriptor = "(II)[Loj;",
		garbageValue = "-41299588"
	)
	@Export("newTypedArray")
	User[] newTypedArray(int var1) {
		return new Friend[var1];
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "(Lrg;ZI)Z",
		garbageValue = "903458766"
	)
	@Export("isFriended")
	public boolean isFriended(Username var1, boolean var2) {
		Friend var3 = (Friend)this.getByUsername(var1);
		if (var3 == null) {
			return false;
		} else {
			return !var2 || var3.world != 0;
		}
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		descriptor = "(Lqr;II)V",
		garbageValue = "-1997017332"
	)
	@Export("read")
	public void read(Buffer var1, int var2) {
		while (true) {
			if (var1.offset < var2) {
				boolean var3 = var1.readUnsignedByte() == 1;
				Username var4 = new Username(var1.readStringCp1252NullTerminated(), this.loginType);
				Username var5 = new Username(var1.readStringCp1252NullTerminated(), this.loginType);
				int var6 = var1.readUnsignedShort();
				int var7 = var1.readUnsignedByte();
				int var8 = var1.readUnsignedByte();
				boolean var9 = (var8 & 2) != 0;
				boolean var10 = (var8 & 1) != 0;
				if (var6 > 0) {
					var1.readStringCp1252NullTerminated();
					var1.readUnsignedByte();
					var1.readInt();
				}

				var1.readStringCp1252NullTerminated();
				if (var4 != null && var4.hasCleanName()) {
					Friend var11 = (Friend)this.getByCurrentUsername(var4);
					if (var3) {
						Friend var12 = (Friend)this.getByCurrentUsername(var5);
						if (var12 != null && var12 != var11) {
							if (var11 != null) {
								this.remove(var12);
							} else {
								var11 = var12;
							}
						}
					}

					if (var11 != null) {
						this.changeName(var11, var4, var5);
						if (var6 != var11.world) {
							boolean var14 = true;

							for (class388 var13 = (class388)this.field4461.method6736(); var13 != null; var13 = (class388)this.field4461.method6733()) {
								if (var13.field4475.equals(var4)) {
									if (var6 != 0 && var13.field4476 == 0) {
										var13.method7815();
										var14 = false;
									} else if (var6 == 0 && var13.field4476 != 0) {
										var13.method7815();
										var14 = false;
									}
								}
							}

							if (var14) {
								this.field4461.method6734(new class388(var4, var6));
							}
						}
					} else {
						if (this.getSize() >= 400) {
							continue;
						}

						var11 = (Friend)this.addLast(var4, var5);
					}

					if (var6 != var11.world) {
						var11.int2 = ++this.field4457 - 1;
						if (var11.world == -1 && var6 == 0) {
							var11.int2 = -(var11.int2 * 765902219) * 1732968995;
						}

						var11.world = var6;
					}

					var11.rank = var7;
					var11.field4472 = var9;
					var11.field4473 = var10;
					continue;
				}

				throw new IllegalStateException();
			}

			this.sort();
			return;
		}
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "(Llg;III)Lri;",
		garbageValue = "720037522"
	)
	@Export("SpriteBuffer_getSprite")
	public static SpritePixels SpriteBuffer_getSprite(AbstractArchive var0, int var1, int var2) {
		byte[] var4 = var0.takeFile(var1, var2);
		boolean var3;
		if (var4 == null) {
			var3 = false;
		} else {
			class335.SpriteBuffer_decode(var4);
			var3 = true;
		}

		return !var3 ? null : class31.method466();
	}
}
