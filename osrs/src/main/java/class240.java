import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jr")
public class class240 {
   @ObfuscatedName("mg")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "343853799"
   )
   static final void method1312() {
      PacketBufferNode var0 = UserComparator9.getPacketBufferNode(ClientPacket.field2500, Client.packetWriter.isaacCipher);
      Client.packetWriter.addNode(var0);
      Interpreter.field692 = true;

      for(InterfaceParent var1 = (InterfaceParent)Client.interfaceParents.first(); var1 != null; var1 = (InterfaceParent)Client.interfaceParents.next()) {
         if (var1.type == 0 || var1.type == 3) {
            class17.closeInterface(var1, true);
         }
      }

      if (Client.meslayerContinueWidget != null) {
         class69.invalidateWidget(Client.meslayerContinueWidget);
         Client.meslayerContinueWidget = null;
      }

      Interpreter.field692 = false;
   }
}
