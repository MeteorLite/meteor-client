import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cs")
@Implements("PacketWriter")
public class PacketWriter {
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "Lnl;"
	)
	@Export("socket")
	AbstractSocket socket;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		descriptor = "Llz;"
	)
	@Export("packetBufferNodes")
	IterableNodeDeque packetBufferNodes;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = 2113687051
	)
	@Export("bufferSize")
	int bufferSize;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		descriptor = "Lqq;"
	)
	@Export("buffer")
	Buffer buffer;
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		descriptor = "Lqv;"
	)
	@Export("isaacCipher")
	public IsaacCipher isaacCipher;
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		descriptor = "Lqf;"
	)
	@Export("packetBuffer")
	PacketBuffer packetBuffer;
	@ObfuscatedName("s")
	@ObfuscatedSignature(
		descriptor = "Ljl;"
	)
	@Export("serverPacket")
	ServerPacket serverPacket;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = -1033255131
	)
	@Export("serverPacketLength")
	int serverPacketLength;
	@ObfuscatedName("m")
	boolean field1340;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = 87824195
	)
	int field1349;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = -934025343
	)
	@Export("pendingWrites")
	int pendingWrites;
	@ObfuscatedName("v")
	@ObfuscatedSignature(
		descriptor = "Ljl;"
	)
	ServerPacket field1348;
	@ObfuscatedName("h")
	@ObfuscatedSignature(
		descriptor = "Ljl;"
	)
	ServerPacket field1350;
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		descriptor = "Ljl;"
	)
	ServerPacket field1345;

	PacketWriter() {
		this.packetBufferNodes = new IterableNodeDeque();
		this.bufferSize = 0;
		this.buffer = new Buffer(5000);
		this.packetBuffer = new PacketBuffer(40000);
		this.serverPacket = null;
		this.serverPacketLength = 0;
		this.field1340 = true;
		this.field1349 = 0;
		this.pendingWrites = 0;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "2084194601"
	)
	@Export("clearBuffer")
	final void clearBuffer() {
		this.packetBufferNodes.rsClear();
		this.bufferSize = 0;
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "1134433923"
	)
	@Export("flush")
	final void flush() throws IOException {
		if (this.socket != null && this.bufferSize > 0) {
			this.buffer.offset = 0;

			while (true) {
				PacketBufferNode var1 = (PacketBufferNode)this.packetBufferNodes.last();
				if (var1 == null || var1.index > this.buffer.array.length - this.buffer.offset) {
					this.socket.write(this.buffer.array, 0, this.buffer.offset);
					this.pendingWrites = 0;
					break;
				}

				this.buffer.writeBytes(var1.packetBuffer.array, 0, var1.index);
				this.bufferSize -= var1.index;
				var1.remove();
				var1.packetBuffer.releaseArray();
				var1.release();
			}
		}

	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		descriptor = "(Ljm;I)V",
		garbageValue = "-1674700526"
	)
	@Export("addNode")
	public final void addNode(PacketBufferNode var1) {
		this.packetBufferNodes.addFirst(var1);
		var1.index = var1.packetBuffer.offset;
		var1.packetBuffer.offset = 0;
		this.bufferSize += var1.index;
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		descriptor = "(Lnl;I)V",
		garbageValue = "-1808674743"
	)
	@Export("setSocket")
	void setSocket(AbstractSocket var1) {
		this.socket = var1;
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "-81"
	)
	@Export("close")
	void close() {
		if (this.socket != null) {
			this.socket.close();
			this.socket = null;
		}

	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-308687118"
	)
	@Export("removeSocket")
	void removeSocket() {
		this.socket = null;
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		descriptor = "(B)Lnl;",
		garbageValue = "90"
	)
	@Export("getSocket")
	AbstractSocket getSocket() {
		return this.socket;
	}

	@ObfuscatedName("fw")
	@ObfuscatedSignature(
		descriptor = "(ZI)V",
		garbageValue = "-7211049"
	)
	static final void method2673(boolean var0) {
		if (var0) {
			Client.field528 = Login.field916 ? class125.field1541 : class125.field1539;
		} else {
			Client.field528 = Player.clientPreferences.parameters.containsKey(Skeleton.method4255(Login.Login_username)) ? class125.field1542 : class125.field1536;
		}

	}

	@ObfuscatedName("iz")
	@ObfuscatedSignature(
		descriptor = "(ILjava/lang/String;B)V",
		garbageValue = "1"
	)
	static void method2674(int var0, String var1) {
		int var2 = Players.Players_count;
		int[] var3 = Players.Players_indices;
		boolean var4 = false;
		Username var5 = new Username(var1, Players.loginType);

		for (int var6 = 0; var6 < var2; ++var6) {
			Player var7 = Client.players[var3[var6]];
			if (var7 != null && var7 != class67.localPlayer && var7.username != null && var7.username.equals(var5)) {
				PacketBufferNode var8;
				if (var0 == 1) {
					var8 = class120.getPacketBufferNode(ClientPacket.field3011, Client.packetWriter.isaacCipher);
					var8.packetBuffer.writeShort(var3[var6]);
					var8.packetBuffer.method7952(0);
					Client.packetWriter.addNode(var8);
				} else if (var0 == 4) {
					var8 = class120.getPacketBufferNode(ClientPacket.field2975, Client.packetWriter.isaacCipher);
					var8.packetBuffer.method7961(var3[var6]);
					var8.packetBuffer.method8004(0);
					Client.packetWriter.addNode(var8);
				} else if (var0 == 6) {
					var8 = class120.getPacketBufferNode(ClientPacket.field2973, Client.packetWriter.isaacCipher);
					var8.packetBuffer.method8004(0);
					var8.packetBuffer.method7962(var3[var6]);
					Client.packetWriter.addNode(var8);
				} else if (var0 == 7) {
					var8 = class120.getPacketBufferNode(ClientPacket.field2997, Client.packetWriter.isaacCipher);
					var8.packetBuffer.writeByte(0);
					var8.packetBuffer.writeIntME(var3[var6]);
					Client.packetWriter.addNode(var8);
				}

				var4 = true;
				break;
			}
		}

		if (!var4) {
			class65.addGameMessage(4, "", "Unable to find " + var1);
		}

	}
}
