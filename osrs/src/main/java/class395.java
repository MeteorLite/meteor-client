import java.util.Arrays;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("pn")
public final class class395 implements Comparable {
   @ObfuscatedName("aj")
   Object field3652;
   @ObfuscatedName("al")
   Object field3650;
   @ObfuscatedName("ac")
   long field3649;
   @ObfuscatedName("ab")
   long field3651;

   class395(Object var1, Object var2) {
      this.field3652 = var1;
      this.field3650 = var2;
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "(Lpn;B)I",
      garbageValue = "119"
   )
   int method2072(class395 var1) {
      if (this.field3651 < var1.field3651) {
         return -1;
      } else {
         return this.field3651 > var1.field3651 ? 1 : 0;
      }
   }

   @Export("compareTo")
   @ObfuscatedName("compareTo")
   public int compareTo(Object var1) {
      return this.method2072((class395)var1);
   }

   @Export("hashCode")
   @ObfuscatedName("hashCode")
   public int hashCode() {
      return this.field3650.hashCode();
   }

   @Export("equals")
   @ObfuscatedName("equals")
   public boolean equals(Object var1) {
      if (var1 instanceof class395) {
         return this.field3650.equals(((class395)var1).field3650);
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "(IB)Lhv;",
      garbageValue = "120"
   )
   @Export("KitDefinition_get")
   public static KitDefinition KitDefinition_get(int var0) {
      KitDefinition var1 = (KitDefinition)KitDefinition.KitDefinition_cached.get((long)var0);
      if (var1 != null) {
         return var1;
      } else {
         byte[] var2 = GrandExchangeOfferTotalQuantityComparator.KitDefinition_archive.takeFile(3, var0);
         var1 = new KitDefinition();
         if (var2 != null) {
            var1.decode(new Buffer(var2));
         }

         KitDefinition.KitDefinition_cached.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("gx")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "35"
   )
   static void method2073() {
      Client.mouseLastLastPressedTimeMillis = -1L;
      class212.mouseRecorder.index = 0;
      Varps.hasFocus = true;
      Client.hadFocus = true;
      Client.timeOfPreviousKeyPress = -1L;
      class36.reflectionChecks = new IterableNodeDeque();
      Client.packetWriter.clearBuffer();
      Client.packetWriter.packetBuffer.offset = 0;
      Client.packetWriter.serverPacket = null;
      Client.packetWriter.field1129 = null;
      Client.packetWriter.field1130 = null;
      Client.packetWriter.field1131 = null;
      Client.packetWriter.serverPacketLength = 0;
      Client.packetWriter.field1124 = 0;
      Client.rebootTimer = 0;
      Client.logoutTimer = 0;
      Client.hintArrowType = 0;
      class60.method327();
      MouseHandler.MouseHandler_idleCycles = 0;
      class133.method722();
      Client.isItemSelected = 0;
      Client.isSpellSelected = false;
      Client.soundEffectCount = 0;
      Client.camAngleY = 0;
      Client.oculusOrbState = 0;
      Language.field3504 = null;
      Client.minimapState = 0;
      Client.field592 = -1;
      Client.destinationX = 0;
      Client.destinationY = 0;
      Client.playerAttackOption = AttackOption.AttackOption_hidden;
      Client.npcAttackOption = AttackOption.AttackOption_hidden;
      Client.npcCount = 0;
      DefaultsGroup.method2166();

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
      class6.friendSystem.clear();

      for(var0 = 0; var0 < VarpDefinition.field1461; ++var0) {
         VarpDefinition var3 = GameEngine.VarpDefinition_get(var0);
         if (var3 != null) {
            Varps.Varps_temp[var0] = 0;
            Varps.Varps_main[var0] = 0;
         }
      }

      class248.varcs.clearTransient();
      Client.followerIndex = -1;
      if (Client.rootInterface != -1) {
         class289.method1555(Client.rootInterface);
      }

      for(InterfaceParent var4 = (InterfaceParent)Client.interfaceParents.first(); var4 != null; var4 = (InterfaceParent)Client.interfaceParents.next()) {
         class17.closeInterface(var4, true);
      }

      Client.rootInterface = -1;
      Client.interfaceParents = new NodeHashTable(8);
      Client.meslayerContinueWidget = null;
      class60.method327();
      Client.playerAppearance.initiateAppearance((int[])null, new int[]{0, 0, 0, 0, 0}, 0, -1);

      for(var0 = 0; var0 < 8; ++var0) {
         Client.playerMenuActions[var0] = null;
         Client.playerOptionsPriorities[var0] = false;
      }

      class206.method1080();
      Client.isLoading = true;

      for(var0 = 0; var0 < 100; ++var0) {
         Client.field594[var0] = true;
      }

      PacketBufferNode var5 = UserComparator9.getPacketBufferNode(ClientPacket.field2432, Client.packetWriter.isaacCipher);
      var5.packetBuffer.writeByte(class7.getWindowedMode());
      var5.packetBuffer.writeShort(GameEngine.canvasWidth);
      var5.packetBuffer.writeShort(class143.canvasHeight);
      Client.packetWriter.addNode(var5);
      ReflectionCheck.friendsChat = null;
      WorldMapCacheName.guestClanSettings = null;
      Arrays.fill(Client.currentClanSettings, (Object)null);
      class19.guestClanChannel = null;
      Arrays.fill(Client.currentClanChannels, (Object)null);

      for(var0 = 0; var0 < 8; ++var0) {
         Client.grandExchangeOffers[var0] = new GrandExchangeOffer();
      }

      Projectile.grandExchangeEvents = null;
   }
}
