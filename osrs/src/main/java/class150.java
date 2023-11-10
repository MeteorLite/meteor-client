import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fz")
public class class150 extends class160 {
	@ObfuscatedName("at")
	int field1357;
	@ObfuscatedName("ah")
	byte field1355;
	@ObfuscatedName("ar")
	int field1356;
	@ObfuscatedName("ao")
	String field1358;
	// $FF: synthetic field
	@ObfuscatedSignature(
		descriptor = "Lgi;"
	)
	final class161 this$0;

	@ObfuscatedSignature(
		descriptor = "(Lgi;)V"
	)
	class150(class161 var1) {
		this.this$0 = var1;
		this.field1357 = -1;
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(Luj;I)V",
		garbageValue = "1810249387"
	)
	@Export("vmethod3238")
	void vmethod3238(Buffer var1) {
		this.field1357 = var1.readUnsignedShort();
		this.field1355 = var1.readByte();
		this.field1356 = var1.readUnsignedShort();
		var1.readLong();
		this.field1358 = var1.readStringCp1252NullTerminated();
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(Lgn;B)V",
		garbageValue = "-75"
	)
	@Export("vmethod3239")
	void vmethod3239(ClanChannel var1) {
		ClanChannelMember var2 = (ClanChannelMember)var1.members.get(this.field1357);
		var2.rank = this.field1355;
		var2.world = this.field1356;
		var2.username = new Username(this.field1358);
	}

	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "1818675777"
	)
	static void method785() {
		if (Client.Login_isUsernameRemembered && Login.Login_username != null && Login.Login_username.length() > 0) {
			Login.currentLoginField = 1;
		} else {
			Login.currentLoginField = 0;
		}

	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/CharSequence;I)I",
		garbageValue = "2073691331"
	)
	@Export("hashString")
	public static int hashString(CharSequence var0) {
		int var1 = var0.length();
		int var2 = 0;

		for (int var3 = 0; var3 < var1; ++var3) {
			var2 = (var2 << 5) - var2 + class137.charToByteCp1252(var0.charAt(var3));
		}

		return var2;
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "([BIII)Z",
		garbageValue = "-851651370"
	)
	static final boolean method784(byte[] var0, int var1, int var2) {
		boolean var3 = true;
		Buffer var4 = new Buffer(var0);
		int var5 = -1;

		label57:
		while (true) {
			int var6 = var4.readIncrSmallSmart();
			if (var6 == 0) {
				return var3;
			}

			var5 += var6;
			int var7 = 0;
			boolean var8 = false;

			while (true) {
				int var9;
				while (!var8) {
					var9 = var4.readUShortSmart();
					if (var9 == 0) {
						continue label57;
					}

					var7 += var9 - 1;
					int var10 = var7 & 63;
					int var11 = var7 >> 6 & 63;
					int var12 = var4.readUnsignedByte() >> 2;
					int var13 = var11 + var1;
					int var14 = var10 + var2;
					if (var13 > 0 && var14 > 0 && var13 < 103 && var14 < 103) {
						ObjectComposition var15 = WorldMapSection2.getObjectDefinition(var5);
						if (var12 != 22 || !Client.isLowDetail || var15.int1 != 0 || var15.interactType == 1 || var15.boolean2) {
							if (!var15.needsModelFiles()) {
								++Client.field453;
								var3 = false;
							}

							var8 = true;
						}
					}
				}

				var9 = var4.readUShortSmart();
				if (var9 == 0) {
					break;
				}

				var4.readUnsignedByte();
			}
		}
	}
}