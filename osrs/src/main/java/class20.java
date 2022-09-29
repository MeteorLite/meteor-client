import java.io.IOException;
import java.util.concurrent.Callable;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("g")
public class class20 implements Callable {
	@ObfuscatedName("d")
	@ObfuscatedSignature(
		descriptor = "Lqq;"
	)
	@Export("NetCache_responseArchiveBuffer")
	public static Buffer NetCache_responseArchiveBuffer;
	@ObfuscatedName("af")
	@ObfuscatedSignature(
		descriptor = "Lqd;"
	)
	@Export("rasterProvider")
	public static AbstractRasterProvider rasterProvider;
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "Lj;"
	)
	final class10 field114;
	// $FF: synthetic field
	@ObfuscatedSignature(
		descriptor = "Lu;"
	)
	final class14 this$0;

	@ObfuscatedSignature(
		descriptor = "(Lu;Lj;)V"
	)
	class20(class14 var1, class10 var2) {
		this.this$0 = var1;
		this.field114 = var2;
	}

	public Object call() throws Exception {
		try {
			while (this.field114.method95()) {
				class28.method412(10L);
			}
		} catch (IOException var2) {
			return new class21("Error servicing REST query: " + var2.getMessage());
		}

		return this.field114.method97();
	}

	@ObfuscatedName("ik")
	@ObfuscatedSignature(
		descriptor = "(Lcw;B)V",
		garbageValue = "80"
	)
	static final void method302(PendingSpawn var0) {
		long var1 = 0L;
		int var3 = -1;
		int var4 = 0;
		int var5 = 0;
		if (var0.type == 0) {
			var1 = MusicPatchNode.scene.getBoundaryObjectTag(var0.plane, var0.x, var0.y);
		}

		if (var0.type == 1) {
			var1 = MusicPatchNode.scene.getWallDecorationTag(var0.plane, var0.x, var0.y);
		}

		if (var0.type == 2) {
			var1 = MusicPatchNode.scene.getGameObjectTag(var0.plane, var0.x, var0.y);
		}

		if (var0.type == 3) {
			var1 = MusicPatchNode.scene.getFloorDecorationTag(var0.plane, var0.x, var0.y);
		}

		if (var1 != 0L) {
			int var6 = MusicPatchNode.scene.getObjectFlags(var0.plane, var0.x, var0.y, var1);
			var3 = class156.Entity_unpackID(var1);
			var4 = var6 & 31;
			var5 = var6 >> 6 & 3;
		}

		var0.objectId = var3;
		var0.field1121 = var4;
		var0.field1119 = var5;
	}

	@ObfuscatedName("lk")
	@ObfuscatedSignature(
		descriptor = "(III)V",
		garbageValue = "417114904"
	)
	static final void method303(int var0, int var1) {
		if (Client.currentClanChannels[var0] != null) {
			if (var1 >= 0 && var1 < Client.currentClanChannels[var0].method3265()) {
				ClanChannelMember var2 = (ClanChannelMember)Client.currentClanChannels[var0].members.get(var1);
				if (var2.rank == -1) {
					PacketBufferNode var3 = class120.getPacketBufferNode(ClientPacket.field2955, Client.packetWriter.isaacCipher);
					var3.packetBuffer.writeByte(3 + class357.stringCp1252NullTerminatedByteSize(var2.username.getName()));
					var3.packetBuffer.writeByte(var0);
					var3.packetBuffer.writeShort(var1);
					var3.packetBuffer.writeStringCp1252NullTerminated(var2.username.getName());
					Client.packetWriter.addNode(var3);
				}
			}
		}
	}
}
