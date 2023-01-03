import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ei")
public abstract class class152 extends Node {
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(Lqy;I)V",
      garbageValue = "468341515"
   )
   @Export("vmethod3238")
   abstract void vmethod3238(Buffer var1);

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "(Lfn;I)V",
      garbageValue = "1227548281"
   )
   @Export("vmethod3239")
   abstract void vmethod3239(ClanChannel var1);

   @ObfuscatedName("hn")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;I)V",
      garbageValue = "-1882870143"
   )
   @Export("doCheat")
   static final void doCheat(String var0) {
      if (var0.equalsIgnoreCase("toggleroof")) {
         StructComposition.clientPreferences.method562(!StructComposition.clientPreferences.method535());
         if (StructComposition.clientPreferences.method535()) {
            KitDefinition.addGameMessage(99, "", "Roofs are now all hidden");
         } else {
            KitDefinition.addGameMessage(99, "", "Roofs will only be removed selectively");
         }
      }

      if (var0.equalsIgnoreCase("displayfps")) {
         StructComposition.clientPreferences.method550();
      }

      if (var0.equalsIgnoreCase("renderself")) {
         Client.renderSelf = !Client.renderSelf;
      }

      if (var0.equalsIgnoreCase("mouseovertext")) {
         Client.showMouseOverText = !Client.showMouseOverText;
      }

      if (Client.staffModLevel >= 2) {
         if (var0.equalsIgnoreCase("errortest")) {
            throw new RuntimeException();
         }

         if (var0.equalsIgnoreCase("showcoord")) {
            KitDefinition.worldMap.showCoord = !KitDefinition.worldMap.showCoord;
         }

         if (var0.equalsIgnoreCase("fpson")) {
            StructComposition.clientPreferences.method559(true);
         }

         if (var0.equalsIgnoreCase("fpsoff")) {
            StructComposition.clientPreferences.method559(false);
         }

         if (var0.equalsIgnoreCase("gc")) {
            System.gc();
         }

         if (var0.equalsIgnoreCase("clientdrop")) {
            FaceNormal.method1236();
         }
      }

      PacketBufferNode var1 = class136.getPacketBufferNode(ClientPacket.field2468, Client.packetWriter.isaacCipher);
      var1.packetBuffer.writeByte(var0.length() + 1);
      var1.packetBuffer.writeStringCp1252NullTerminated(var0);
      Client.packetWriter.addNode(var1);
   }
}
