import java.awt.Image;
import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eq")
@Implements("PacketWriter")
public class PacketWriter {
   @ObfuscatedName("bo")
   static Image field1141;
   @ObfuscatedName("af")
   @ObfuscatedSignature(
      descriptor = "Lph;"
   )
   @Export("socket")
   AbstractSocket socket;
   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "Loi;"
   )
   @Export("packetBufferNodes")
   IterableNodeDeque packetBufferNodes = new IterableNodeDeque();
   @ObfuscatedName("aw")
   @Export("bufferSize")
   int bufferSize = 0;
   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "Lsg;"
   )
   @Export("buffer")
   Buffer buffer = new Buffer(5000);
   @ObfuscatedName("au")
   @ObfuscatedSignature(
      descriptor = "Ltp;"
   )
   @Export("isaacCipher")
   public IsaacCipher isaacCipher;
   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "Lsq;"
   )
   @Export("packetBuffer")
   PacketBuffer packetBuffer = new PacketBuffer(40000);
   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      descriptor = "Lls;"
   )
   @Export("serverPacket")
   ServerPacket serverPacket = null;
   @ObfuscatedName("al")
   @Export("serverPacketLength")
   int serverPacketLength = 0;
   @ObfuscatedName("at")
   boolean field1135 = true;
   @ObfuscatedName("aa")
   int field1136 = 0;
   @ObfuscatedName("ay")
   @Export("pendingWrites")
   int pendingWrites = 0;
   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      descriptor = "Lls;"
   )
   ServerPacket field1138;
   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      descriptor = "Lls;"
   )
   ServerPacket field1139;
   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      descriptor = "Lls;"
   )
   ServerPacket field1133;

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "1845394626"
   )
   @Export("clearBuffer")
   final void clearBuffer() {
      this.packetBufferNodes.rsClear();
      this.bufferSize = 0;
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "421941662"
   )
   @Export("flush")
   final void flush() throws IOException {
      if (this.socket != null && this.bufferSize > 0) {
         this.buffer.offset = 0;

         while(true) {
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

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      descriptor = "(Llg;I)V",
      garbageValue = "414135591"
   )
   @Export("addNode")
   public final void addNode(PacketBufferNode var1) {
      this.packetBufferNodes.addFirst(var1);
      var1.index = var1.packetBuffer.offset;
      var1.packetBuffer.offset = 0;
      this.bufferSize += var1.index;
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "(Lph;B)V",
      garbageValue = "1"
   )
   @Export("setSocket")
   void setSocket(AbstractSocket var1) {
      this.socket = var1;
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "-343033137"
   )
   @Export("close")
   void close() {
      if (this.socket != null) {
         this.socket.close();
         this.socket = null;
      }

   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "-274968704"
   )
   @Export("removeSocket")
   void removeSocket() {
      this.socket = null;
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      descriptor = "(B)Lph;",
      garbageValue = "2"
   )
   @Export("getSocket")
   AbstractSocket getSocket() {
      return this.socket;
   }
}
