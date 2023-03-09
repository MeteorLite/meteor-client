import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("mu")
public enum class333 implements class352 {
   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "Lmu;"
   )
   field3378(-1),
   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "Lmu;"
   )
   field3376(0),
   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "Lmu;"
   )
   field3375(1),
   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "Lmu;"
   )
   field3377(2);

   @ObfuscatedName("an")
   final int field3379;

   class333(int var3) {
      this.field3379 = var3;
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "-1409646049"
   )
   @Export("rsOrdinal")
   public int rsOrdinal() {
      return this.field3379;
   }

   @ObfuscatedName("kh")
   @ObfuscatedSignature(
      descriptor = "(IIIILjava/lang/String;I)V",
      garbageValue = "-159586085"
   )
   @Export("widgetDefaultMenuAction")
   static void widgetDefaultMenuAction(int var0, int var1, int var2, int var3, String var4) {
      Widget var5 = class36.getWidgetChild(var1, var2);
      if (var5 != null) {
         if (var5.onOp != null) {
            ScriptEvent var6 = new ScriptEvent();
            var6.widget = var5;
            var6.opIndex = var0;
            var6.targetName = var4;
            var6.args = var5.onOp;
            class9.runScriptEvent(var6);
         }

         boolean var11 = true;
         if (var5.contentType > 0) {
            var11 = class11.method41(var5);
         }

         if (var11) {
            int var8 = ParamComposition.getWidgetFlags(var5);
            int var9 = var0 - 1;
            boolean var7 = (var8 >> var9 + 1 & 1) != 0;
            if (var7) {
               PacketBufferNode var10;
               if (var0 == 1) {
                  var10 = UserComparator9.getPacketBufferNode(ClientPacket.field2438, Client.packetWriter.isaacCipher);
                  var10.packetBuffer.writeInt(var1);
                  var10.packetBuffer.writeShort(var2);
                  var10.packetBuffer.writeShort(var3);
                  Client.packetWriter.addNode(var10);
               }

               if (var0 == 2) {
                  var10 = UserComparator9.getPacketBufferNode(ClientPacket.field2502, Client.packetWriter.isaacCipher);
                  var10.packetBuffer.writeInt(var1);
                  var10.packetBuffer.writeShort(var2);
                  var10.packetBuffer.writeShort(var3);
                  Client.packetWriter.addNode(var10);
               }

               if (var0 == 3) {
                  var10 = UserComparator9.getPacketBufferNode(ClientPacket.field2495, Client.packetWriter.isaacCipher);
                  var10.packetBuffer.writeInt(var1);
                  var10.packetBuffer.writeShort(var2);
                  var10.packetBuffer.writeShort(var3);
                  Client.packetWriter.addNode(var10);
               }

               if (var0 == 4) {
                  var10 = UserComparator9.getPacketBufferNode(ClientPacket.field2420, Client.packetWriter.isaacCipher);
                  var10.packetBuffer.writeInt(var1);
                  var10.packetBuffer.writeShort(var2);
                  var10.packetBuffer.writeShort(var3);
                  Client.packetWriter.addNode(var10);
               }

               if (var0 == 5) {
                  var10 = UserComparator9.getPacketBufferNode(ClientPacket.field2480, Client.packetWriter.isaacCipher);
                  var10.packetBuffer.writeInt(var1);
                  var10.packetBuffer.writeShort(var2);
                  var10.packetBuffer.writeShort(var3);
                  Client.packetWriter.addNode(var10);
               }

               if (var0 == 6) {
                  var10 = UserComparator9.getPacketBufferNode(ClientPacket.field2475, Client.packetWriter.isaacCipher);
                  var10.packetBuffer.writeInt(var1);
                  var10.packetBuffer.writeShort(var2);
                  var10.packetBuffer.writeShort(var3);
                  Client.packetWriter.addNode(var10);
               }

               if (var0 == 7) {
                  var10 = UserComparator9.getPacketBufferNode(ClientPacket.field2425, Client.packetWriter.isaacCipher);
                  var10.packetBuffer.writeInt(var1);
                  var10.packetBuffer.writeShort(var2);
                  var10.packetBuffer.writeShort(var3);
                  Client.packetWriter.addNode(var10);
               }

               if (var0 == 8) {
                  var10 = UserComparator9.getPacketBufferNode(ClientPacket.field2441, Client.packetWriter.isaacCipher);
                  var10.packetBuffer.writeInt(var1);
                  var10.packetBuffer.writeShort(var2);
                  var10.packetBuffer.writeShort(var3);
                  Client.packetWriter.addNode(var10);
               }

               if (var0 == 9) {
                  var10 = UserComparator9.getPacketBufferNode(ClientPacket.field2444, Client.packetWriter.isaacCipher);
                  var10.packetBuffer.writeInt(var1);
                  var10.packetBuffer.writeShort(var2);
                  var10.packetBuffer.writeShort(var3);
                  Client.packetWriter.addNode(var10);
               }

               if (var0 == 10) {
                  var10 = UserComparator9.getPacketBufferNode(ClientPacket.field2442, Client.packetWriter.isaacCipher);
                  var10.packetBuffer.writeInt(var1);
                  var10.packetBuffer.writeShort(var2);
                  var10.packetBuffer.writeShort(var3);
                  Client.packetWriter.addNode(var10);
               }

            }
         }
      }
   }
}
