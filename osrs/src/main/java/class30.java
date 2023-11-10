import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import javax.imageio.ImageIO;
import java.util.ArrayList;
import java.util.Iterator;

@ObfuscatedName("bv")
public class class30 {
	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "Lol;"
	)
	@Export("VarcInt_archive")
	public static AbstractArchive VarcInt_archive;

	static {
		ImageIO.setUseCache(false);
	}

	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "(Ljava/util/ArrayList;ZI)V",
		garbageValue = "358922906"
	)
	static void method131(ArrayList var0, boolean var1) {
		if (!var1) {
			class316.field2787.clear();
		}

		Iterator var2 = var0.iterator();

		while (var2.hasNext()) {
			MusicSong var3 = (MusicSong)var2.next();
			if (var3.musicTrackGroupId != -1 && var3.musicTrackFileId != -1) {
				if (!var1) {
					class316.field2787.add(var3);
				}

				class316.field2790.add(var3);
			}
		}

	}

	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "(ILdt;ZI)I",
		garbageValue = "-2029161315"
	)
	static int method133(int var0, Script var1, boolean var2) {
		Widget var3 = var2 ? Interpreter.scriptDotWidget : HealthBar.scriptActiveWidget;
		if (var0 == 1700) {
			Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var3.itemId;
			return 1;
		} else if (var0 == 1701) {
			if (var3.itemId != -1) {
				Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var3.itemQuantity;
			} else {
				Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = 0;
			}

			return 1;
		} else if (var0 == 1702) {
			Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var3.childIndex;
			return 1;
		} else if (var0 == 1707) {
			Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var3.method1861() ? 1 : 0;
			return 1;
		} else if (var0 == 1708) {
			return class310.method1645(var3);
		} else {
			return var0 == 1709 ? GrandExchangeOfferTotalQuantityComparator.method1965(var3) : 2;
		}
	}

	@ObfuscatedName("ck")
	@ObfuscatedSignature(
		descriptor = "([BI)[B",
		garbageValue = "-1158445957"
	)
	@Export("decompressBytes")
	static final byte[] decompressBytes(byte[] var0) {
		Buffer var1 = new Buffer(var0);
		int var2 = var1.readUnsignedByte();
		int var3 = var1.readInt();
		if (var3 >= 0 && (AbstractArchive.maximumContainerSize == 0 || var3 <= AbstractArchive.maximumContainerSize)) {
			if (var2 == 0) {
				byte[] var4 = new byte[var3];
				var1.readBytes(var4, 0, var3);
				return var4;
			} else {
				int var6 = var1.readInt();
				if (var6 < 0 || AbstractArchive.maximumContainerSize != 0 && var6 > AbstractArchive.maximumContainerSize) {
					throw new RuntimeException();
				} else {
					byte[] var5 = new byte[var6];
					if (var2 == 1) {
						BZip2Decompressor.BZip2Decompressor_decompress(var5, var6, var0, var3, 9);
					} else {
						AbstractArchive.gzipDecompressor.decompress(var1, var5);
					}

					return var5;
				}
			}
		} else {
			throw new RuntimeException();
		}
	}

	@ObfuscatedName("nj")
	@ObfuscatedSignature(
		descriptor = "(III)V",
		garbageValue = "1125993888"
	)
	static final void method134(int var0, int var1) {
		ClanChannel var2 = var0 >= 0 ? Client.currentClanChannels[var0] : ItemContainer.guestClanChannel;
		if (var2 != null && var1 >= 0 && var1 < var2.method857()) {
			ClanChannelMember var3 = (ClanChannelMember)var2.members.get(var1);
			if (var3.rank == -1) {
				String var4 = var3.username.getName();
				PacketBufferNode var5 = class113.getPacketBufferNode(ClientPacket.f65, Client.packetWriter.isaacCipher);
				var5.packetBuffer.writeByte(3 + ClanChannel.stringCp1252NullTerminatedByteSize(var4));
				var5.packetBuffer.writeByte(var0);
				var5.packetBuffer.writeShort(var1);
				var5.packetBuffer.writeStringCp1252NullTerminated(var4);
				Client.packetWriter.addNode(var5);
			}
		}
	}
}