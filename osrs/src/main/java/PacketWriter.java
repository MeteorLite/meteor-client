import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eb")
@Implements("PacketWriter")
public class PacketWriter {
	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "Lqh;"
	)
	@Export("socket")
	AbstractSocket socket;
	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "Lor;"
	)
	@Export("packetBufferNodes")
	IterableNodeDeque packetBufferNodes;
	@ObfuscatedName("ar")
	@Export("bufferSize")
	int bufferSize;
	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "Lty;"
	)
	@Export("buffer")
	Buffer buffer;
	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "Luy;"
	)
	@Export("isaacCipher")
	public IsaacCipher isaacCipher;
	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		descriptor = "Ltc;"
	)
	@Export("packetBuffer")
	PacketBuffer packetBuffer;
	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		descriptor = "Lls;"
	)
	@Export("serverPacket")
	ServerPacket serverPacket;
	@ObfuscatedName("az")
	@Export("serverPacketLength")
	int serverPacketLength;
	@ObfuscatedName("av")
	boolean field1140;
	@ObfuscatedName("ap")
	int field1141;
	@ObfuscatedName("aq")
	@Export("pendingWrites")
	int pendingWrites;
	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "Lls;"
	)
	ServerPacket field1147;
	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "Lls;"
	)
	ServerPacket field1146;
	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "Lls;"
	)
	ServerPacket field1148;

	PacketWriter() {
		this.packetBufferNodes = new IterableNodeDeque();
		this.bufferSize = 0;
		this.buffer = new Buffer(5000);
		this.packetBuffer = new PacketBuffer(40000);
		this.serverPacket = null;
		this.serverPacketLength = 0;
		this.field1140 = true;
		this.field1141 = 0;
		this.pendingWrites = 0;
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-1305418239"
	)
	@Export("clearBuffer")
	final void clearBuffer() {
		this.packetBufferNodes.rsClear();
		this.bufferSize = 0;
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "14"
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

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(Llv;I)V",
		garbageValue = "1819467600"
	)
	@Export("addNode")
	public final void addNode(PacketBufferNode var1) {
		this.packetBufferNodes.addFirst(var1);
		var1.index = var1.packetBuffer.offset;
		var1.packetBuffer.offset = 0;
		this.bufferSize += var1.index;
	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "(Lqh;I)V",
		garbageValue = "12780855"
	)
	@Export("setSocket")
	void setSocket(AbstractSocket var1) {
		this.socket = var1;
	}

	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-2143075980"
	)
	@Export("close")
	void close() {
		if (this.socket != null) {
			this.socket.close();
			this.socket = null;
		}

	}

	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-1207430407"
	)
	@Export("removeSocket")
	void removeSocket() {
		this.socket = null;
	}

	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		descriptor = "(B)Lqh;",
		garbageValue = "29"
	)
	@Export("getSocket")
	AbstractSocket getSocket() {
		return this.socket;
	}

	@ObfuscatedName("jr")
	@ObfuscatedSignature(
		descriptor = "(Liy;I)V",
		garbageValue = "-950444283"
	)
	static void method643(class212 var0) {
		if (var0 != null && var0.field1856 != null) {
			if (var0.field1856.childIndex >= 0) {
				Widget var1 = VarbitComposition.getWidget(var0.field1856.parentId);
				if (var1 == null || var1.children == null || var1.children.length == 0 || var0.field1856.childIndex >= var1.children.length || var0.field1856 != var1.children[var0.field1856.childIndex]) {
					return;
				}
			}

			if (var0.field1856.type == 11 && var0.field1855 == 0) {
				if (var0.field1856.method1794(var0.field1854, var0.field1853, 0, 0)) {
					switch(var0.field1856.method1798()) {
					case 0:
						NPC.openURL(var0.field1856.method1800(), true, false);
						break;
					case 1:
						int var2 = UserComparator8.getWidgetFlags(var0.field1856);
						boolean var5 = (var2 >> 22 & 1) != 0;
						if (var5) {
							int[] var3 = var0.field1856.method1801();
							if (var3 != null) {
								PacketBufferNode var4 = class503.getPacketBufferNode(ClientPacket.CAMVIEW_CLICK, Client.packetWriter.isaacCipher);
								var4.packetBuffer.writeShortAddLE(var0.field1856.childIndex);
								var4.packetBuffer.writeIntME(var3[1]);
								var4.packetBuffer.writeIntIME(var0.field1856.method1799());
								var4.packetBuffer.writeIntLE(var3[2]);
								var4.packetBuffer.writeIntLE(var3[0]);
								var4.packetBuffer.writeIntIME(var0.field1856.id);
								Client.packetWriter.addNode(var4);
							}
						}
					}
				}
			} else if (var0.field1856.type == 12) {
				class330 var6 = var0.field1856.method1805();
				if (var6 != null && var6.method1746()) {
					switch(var0.field1855) {
					case 0:
						Client.field594.method1069(var0.field1856);
						var6.method1694(true);
						var6.method1733(var0.field1854, var0.field1853, Client.keyHandlerInstance.getKeyPressed(82), Client.keyHandlerInstance.getKeyPressed(81));
						break;
					case 1:
						var6.method1734(var0.field1854, var0.field1853);
					}
				}
			}

		}
	}
}
