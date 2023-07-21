import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fk")
public class class150 extends class143 {
	@ObfuscatedName("vx")
	@ObfuscatedSignature(
		descriptor = "Lda;"
	)
	@Export("clientPreferences")
	static ClientPreferences clientPreferences;
	@ObfuscatedName("aw")
	boolean field1346;
	@ObfuscatedName("ay")
	byte field1350;
	@ObfuscatedName("ar")
	byte field1348;
	@ObfuscatedName("am")
	byte field1347;
	@ObfuscatedName("as")
	byte field1349;
	// $FF: synthetic field
	@ObfuscatedSignature(
		descriptor = "Lfr;"
	)
	@Export("this$0")
	@ObfuscatedName("this$0")
	final class146 this$0;

	@ObfuscatedSignature(
		descriptor = "(Lfr;)V"
	)
	class150(class146 var1) {
		this.this$0 = var1;
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(Lty;B)V",
		garbageValue = "1"
	)
	@Export("vmethod3254")
	void vmethod3254(Buffer var1) {
		this.field1346 = var1.readUnsignedByte() == 1;
		this.field1350 = var1.readByte();
		this.field1348 = var1.readByte();
		this.field1347 = var1.readByte();
		this.field1349 = var1.readByte();
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(Lfx;B)V",
		garbageValue = "-72"
	)
	@Export("vmethod3248")
	void vmethod3248(ClanSettings var1) {
		var1.allowGuests = this.field1346;
		var1.field1375 = this.field1350;
		var1.field1372 = this.field1348;
		var1.field1373 = this.field1347;
		var1.field1374 = this.field1349;
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/Object;ZB)[B",
		garbageValue = "75"
	)
	public static byte[] method785(Object var0, boolean var1) {
		if (var0 == null) {
			return null;
		} else if (var0 instanceof byte[]) {
			byte[] var6 = (byte[])((byte[])var0);
			if (var1) {
				int var4 = var6.length;
				byte[] var5 = new byte[var4];
				System.arraycopy(var6, 0, var5, 0, var4);
				return var5;
			} else {
				return var6;
			}
		} else if (var0 instanceof AbstractByteArrayCopier) {
			AbstractByteArrayCopier var2 = (AbstractByteArrayCopier)var0;
			return var2.get();
		} else {
			throw new IllegalArgumentException();
		}
	}

	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "(IIIZIZS)V",
		garbageValue = "-25741"
	)
	@Export("doWorldSorting")
	static void doWorldSorting(int var0, int var1, int var2, boolean var3, int var4, boolean var5) {
		if (var0 < var1) {
			int var6 = (var0 + var1) / 2;
			int var7 = var0;
			World var8 = class387.World_worlds[var6];
			class387.World_worlds[var6] = class387.World_worlds[var1];
			class387.World_worlds[var1] = var8;

			for (int var9 = var0; var9 < var1; ++var9) {
				World var11 = class387.World_worlds[var9];
				int var12 = ClanSettings.compareWorlds(var11, var8, var2, var3);
				int var10;
				if (var12 != 0) {
					if (var3) {
						var10 = -var12;
					} else {
						var10 = var12;
					}
				} else if (var4 == -1) {
					var10 = 0;
				} else {
					int var13 = ClanSettings.compareWorlds(var11, var8, var4, var5);
					if (var5) {
						var10 = -var13;
					} else {
						var10 = var13;
					}
				}

				if (var10 <= 0) {
					World var14 = class387.World_worlds[var9];
					class387.World_worlds[var9] = class387.World_worlds[var7];
					class387.World_worlds[var7++] = var14;
				}
			}

			class387.World_worlds[var1] = class387.World_worlds[var7];
			class387.World_worlds[var7] = var8;
			doWorldSorting(var0, var7 - 1, var2, var3, var4, var5);
			doWorldSorting(var7 + 1, var1, var2, var3, var4, var5);
		}

	}

	@ObfuscatedName("nm")
	@ObfuscatedSignature(
		descriptor = "(IIZI)V",
		garbageValue = "2003552288"
	)
	static final void method789(int var0, int var1, boolean var2) {
		if (Client.currentClanChannels[var0] != null) {
			if (var1 >= 0 && var1 < Client.currentClanChannels[var0].method851()) {
				ClanChannelMember var3 = (ClanChannelMember)Client.currentClanChannels[var0].members.get(var1);
				PacketBufferNode var4 = class503.getPacketBufferNode(ClientPacket.field2529, Client.packetWriter.isaacCipher);
				var4.packetBuffer.writeByte(4 + class501.stringCp1252NullTerminatedByteSize(var3.username.getName()));
				var4.packetBuffer.writeByte(var0);
				var4.packetBuffer.writeShort(var1);
				var4.packetBuffer.writeBoolean(var2);
				var4.packetBuffer.writeStringCp1252NullTerminated(var3.username.getName());
				Client.packetWriter.addNode(var4);
			}
		}
	}
}
