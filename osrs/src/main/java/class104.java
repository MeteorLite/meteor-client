import java.util.Arrays;

import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dh")
public class class104 {
   @ObfuscatedName("tb")
   static int cameraLookAtHeight;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "Ldh;"
   )
   static final class104 field1114 = new class104(0);
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "Ldh;"
   )
   static final class104 field1098 = new class104(1);
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "Ldh;"
   )
   static final class104 field1099 = new class104(2);
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      descriptor = "Ldh;"
   )
   static final class104 field1100 = new class104(3);
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      descriptor = "Ldh;"
   )
   static final class104 field1105 = new class104(4);
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      descriptor = "Ldh;"
   )
   static final class104 field1102 = new class104(5);
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "Ldh;"
   )
   static final class104 field1103 = new class104(6);
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      descriptor = "Ldh;"
   )
   static final class104 field1104 = new class104(7);
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      descriptor = "Ldh;"
   )
   static final class104 field1109 = new class104(8);
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      descriptor = "Ldh;"
   )
   static final class104 field1106 = new class104(9);
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      descriptor = "Ldh;"
   )
   static final class104 field1108 = new class104(10);
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      descriptor = "Ldh;"
   )
   static final class104 field1101 = new class104(11);
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      descriptor = "Ldh;"
   )
   static final class104 field1107 = new class104(12);
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      descriptor = "Ldh;"
   )
   static final class104 field1110 = new class104(13);
   @ObfuscatedName("ij")
   static int[][] xteaKeys;
   @ObfuscatedName("n")
   int field1111;

   class104(int var1) {
      this.field1111 = var1;
   }

   @ObfuscatedName("gn")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "1882053186"
   )
   static void method612() {
      Client.mouseLastLastPressedTimeMillis = -1L;
      class271.mouseRecorder.index = 0;
      PacketBuffer.hasFocus = true;
      Client.hadFocus = true;
      Client.timeOfPreviousKeyPress = -1L;
      class37.reflectionChecks = new IterableNodeDeque();
      Client.packetWriter.clearBuffer();
      Client.packetWriter.packetBuffer.offset = 0;
      Client.packetWriter.serverPacket = null;
      Client.packetWriter.field1134 = null;
      Client.packetWriter.field1135 = null;
      Client.packetWriter.field1136 = null;
      Client.packetWriter.serverPacketLength = 0;
      Client.packetWriter.field1125 = 0;
      Client.rebootTimer = 0;
      Client.logoutTimer = 0;
      Client.hintArrowType = 0;
      WorldMapSectionType.method1426();
      Player.method505(0);
      class319.method1772();
      Client.isItemSelected = 0;
      Client.isSpellSelected = false;
      Client.soundEffectCount = 0;
      Client.camAngleY = 0;
      Client.oculusOrbState = 0;
      GameEngine.field129 = null;
      Client.minimapState = 0;
      Client.field464 = -1;
      Client.destinationX = 0;
      Client.destinationY = 0;
      Client.playerAttackOption = AttackOption.AttackOption_hidden;
      Client.npcAttackOption = AttackOption.AttackOption_hidden;
      Client.npcCount = 0;
      Language.method1866();

      int var0;
      for(var0 = 0; var0 < 2048; ++var0) {
         Client.players[var0] = null;
      }

      for(var0 = 0; var0 < 65536; ++var0) {
         Client.npcs[var0] = null;
      }

      Client.combatTargetPlayerIndex = -1;
      Client.projectiles.clear();
      Client.graphicsObjects.clear();

      for(var0 = 0; var0 < 4; ++var0) {
         for(int var1 = 0; var1 < 104; ++var1) {
            for(int var2 = 0; var2 < 104; ++var2) {
               Client.groundItems[var0][var1][var2] = null;
            }
         }
      }

      Client.pendingSpawns = new NodeDeque();
      DefaultsGroup.friendSystem.clear();

      for(var0 = 0; var0 < VarpDefinition.field1468; ++var0) {
         VarpDefinition var3 = class109.VarpDefinition_get(var0);
         if (var3 != null) {
            Varps.Varps_temp[var0] = 0;
            Varps.Varps_main[var0] = 0;
         }
      }

      WorldMapArea.varcs.clearTransient();
      Client.followerIndex = -1;
      if (Client.rootInterface != -1) {
         HitSplatDefinition.method1006(Client.rootInterface);
      }

      for(InterfaceParent var4 = (InterfaceParent)Client.interfaceParents.first(); var4 != null; var4 = (InterfaceParent)Client.interfaceParents.next()) {
         class9.closeInterface(var4, true);
      }

      Client.rootInterface = -1;
      Client.interfaceParents = new NodeHashTable(8);
      Client.meslayerContinueWidget = null;
      WorldMapSectionType.method1426();
      Client.playerAppearance.initiateAppearance((int[])null, new int[]{0, 0, 0, 0, 0}, 0, -1);

      for(var0 = 0; var0 < 8; ++var0) {
         Client.playerMenuActions[var0] = null;
         Client.playerOptionsPriorities[var0] = false;
      }

      class32.method127();
      Client.isLoading = true;

      for(var0 = 0; var0 < 100; ++var0) {
         Client.field576[var0] = true;
      }

      PacketBufferNode var5 = class136.getPacketBufferNode(ClientPacket.field2441, Client.packetWriter.isaacCipher);
      var5.packetBuffer.writeByte(Message.getWindowedMode());
      var5.packetBuffer.writeShort(CollisionMap.canvasWidth);
      var5.packetBuffer.writeShort(Language.canvasHeight);
      Client.packetWriter.addNode(var5);
      class281.friendsChat = null;
      class20.guestClanSettings = null;
      Arrays.fill(Client.currentClanSettings, (Object)null);
      VarcInt.guestClanChannel = null;
      Arrays.fill(Client.currentClanChannels, (Object)null);

      for(var0 = 0; var0 < 8; ++var0) {
         Client.grandExchangeOffers[var0] = new GrandExchangeOffer();
      }

      ItemContainer.grandExchangeEvents = null;
   }
}
