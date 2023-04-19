import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cg")
@Implements("FriendSystem")
public class FriendSystem {
    @ObfuscatedName("ac")
    @ObfuscatedSignature(
            descriptor = "Lsw;"
    )
    final LoginType loginType;
    @ObfuscatedName("au")
    @ObfuscatedSignature(
            descriptor = "Lpo;"
    )
    public final FriendsList friendsList;
    @ObfuscatedName("ab")
    @ObfuscatedSignature(
            descriptor = "Lpu;"
    )
    public final IgnoreList ignoreList;
   @ObfuscatedName("aq")
   int field672 = 0;

   @ObfuscatedSignature(
      descriptor = "(Lsw;)V"
   )
   FriendSystem(LoginType var1) {
      this.loginType = var1;
      this.friendsList = new FriendsList(var1);
      this.ignoreList = new IgnoreList(var1);
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      descriptor = "(I)Z",
      garbageValue = "-405500659"
   )
   boolean method420() {
      return this.field672 == 2;
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "0"
   )
   final void method411() {
      this.field672 = 1;
   }

    @ObfuscatedName("aw")
    @ObfuscatedSignature(
            descriptor = "(Lsg;II)V",
            garbageValue = "734353750"
    )
    final void readUpdate(Buffer var1, int var2) {
      this.friendsList.read(var1, var2);
      this.field672 = 2;

      for(int var3 = 0; var3 < Players.Players_count; ++var3) {
         Player var4 = Client.players[Players.Players_indices[var3]];
         var4.clearIsFriend();
      }

      GameEngine.method180();
      if (UserComparator5.friendsChat != null) {
         UserComparator5.friendsChat.clearFriends();
      }

   }

    @ObfuscatedName("ac")
    @ObfuscatedSignature(
            descriptor = "(I)V",
            garbageValue = "1673735823"
    )
    final void processFriendUpdates() {
      for(FriendLoginUpdate var1 = (FriendLoginUpdate)this.friendsList.friendLoginUpdates.last(); var1 != null; var1 = (FriendLoginUpdate)this.friendsList.friendLoginUpdates.previous()) {
         if ((long)var1.field3722 < class96.clockNow() / 1000L - 5L) {
            if (var1.worldId > 0) {
               UserComparator5.addGameMessage(5, "", var1.friendUsername + " has logged in.");
            }

            if (var1.worldId == 0) {
               UserComparator5.addGameMessage(5, "", var1.friendUsername + " has logged out.");
            }

            var1.remove();
         }
      }

   }

    @ObfuscatedName("au")
    @ObfuscatedSignature(
            descriptor = "(B)V",
            garbageValue = "108"
    )
    final void clear() {
      this.field672 = 0;
      this.friendsList.clear();
      this.ignoreList.clear();
   }

    @ObfuscatedName("ab")
    @ObfuscatedSignature(
            descriptor = "(Ltm;ZB)Z",
            garbageValue = "-51"
    )
    final boolean isFriended(Username var1, boolean var2) {
      if (var1 == null) {
         return false;
      } else if (var1.equals(MusicPatchNode.localPlayer.username)) {
         return true;
      } else {
         return this.friendsList.isFriended(var1, var2);
      }
   }

    @ObfuscatedName("aq")
    @ObfuscatedSignature(
            descriptor = "(Ltm;I)Z",
            garbageValue = "-1193559293"
    )
    final boolean isIgnored(Username var1) {
      if (var1 == null) {
         return false;
      } else {
         return this.ignoreList.contains(var1);
      }
   }

    @ObfuscatedName("al")
    @ObfuscatedSignature(
            descriptor = "(Ljava/lang/String;B)V",
            garbageValue = "-60"
    )
    final void addFriend(String var1) {
      if (var1 != null) {
         Username var2 = new Username(var1, this.loginType);
         if (var2.hasCleanName()) {
            if (this.friendsListIsFull()) {
               VerticalAlignment.method1036("Your friend list is full. Max of 200 for free users, and 400 for members");
            } else if (MusicPatchNode.localPlayer.username.equals(var2)) {
               class33.method143();
            } else if (this.isFriended(var2, false)) {
               VerticalAlignment.method1036(var1 + " is already on your friend list");
            } else if (this.isIgnored(var2)) {
               Message.method350(var1);
            } else {
               PacketBufferNode var3 = class330.getPacketBufferNode(ClientPacket.field2519, Client.packetWriter.isaacCipher);
               var3.packetBuffer.writeByte(DynamicObject.stringCp1252NullTerminatedByteSize(var1));
               var3.packetBuffer.writeStringCp1252NullTerminated(var1);
               Client.packetWriter.addNode(var3);
            }
         }
      }
   }

    @ObfuscatedName("ao")
    @ObfuscatedSignature(
            descriptor = "(B)Z",
            garbageValue = "-57"
    )
    final boolean friendsListIsFull() {
      return this.friendsList.isFull() || this.friendsList.getSize() >= 200 && Client.isMembers != 1;
   }

    @ObfuscatedName("ax")
    @ObfuscatedSignature(
            descriptor = "(Ljava/lang/String;I)V",
            garbageValue = "42988923"
    )
    final void addIgnore(String var1) {
      if (var1 != null) {
         Username var2 = new Username(var1, this.loginType);
         if (var2.hasCleanName()) {
            if (this.canAddIgnore()) {
               VerticalAlignment.method1036("Your ignore list is full. Max of 100 for free users, and 400 for members");
            } else if (MusicPatchNode.localPlayer.username.equals(var2)) {
               GrandExchangeOfferOwnWorldComparator.method364();
            } else if (this.isIgnored(var2)) {
               VerticalAlignment.method1036(var1 + " is already on your ignore list");
            } else if (this.isFriended(var2, false)) {
               VerticalAlignment.method1036("Please remove " + var1 + " from your friend list first");
            } else {
               PacketBufferNode var3 = class330.getPacketBufferNode(ClientPacket.field2485, Client.packetWriter.isaacCipher);
               var3.packetBuffer.writeByte(DynamicObject.stringCp1252NullTerminatedByteSize(var1));
               var3.packetBuffer.writeStringCp1252NullTerminated(var1);
               Client.packetWriter.addNode(var3);
            }
         }
      }
   }

    @ObfuscatedName("ag")
    @ObfuscatedSignature(
            descriptor = "(I)Z",
            garbageValue = "-300357261"
    )
    final boolean canAddIgnore() {
      return this.ignoreList.isFull() || this.ignoreList.getSize() >= 100 && Client.isMembers != 1;
   }

    @ObfuscatedName("ah")
    @ObfuscatedSignature(
            descriptor = "(Ljava/lang/String;I)V",
            garbageValue = "-1657474548"
    )
    final void removeFriend(String var1) {
      if (var1 != null) {
         Username var2 = new Username(var1, this.loginType);
         if (var2.hasCleanName()) {
            if (this.friendsList.removeByUsername(var2)) {
               Client.field557 = Client.cycleCntr;
               PacketBufferNode var3 = class330.getPacketBufferNode(ClientPacket.field2560, Client.packetWriter.isaacCipher);
               var3.packetBuffer.writeByte(DynamicObject.stringCp1252NullTerminatedByteSize(var1));
               var3.packetBuffer.writeStringCp1252NullTerminated(var1);
               Client.packetWriter.addNode(var3);
            }

            for(int var5 = 0; var5 < Players.Players_count; ++var5) {
               Player var4 = Client.players[Players.Players_indices[var5]];
               var4.clearIsFriend();
            }

            GameEngine.method180();
            if (UserComparator5.friendsChat != null) {
               UserComparator5.friendsChat.clearFriends();
            }

         }
      }
   }

    @ObfuscatedName("av")
    @ObfuscatedSignature(
            descriptor = "(Ljava/lang/String;ZB)V",
            garbageValue = "-43"
    )
    public final void removeIgnore(String var1, boolean var2) {
      if (var1 != null) {
         Username var3 = new Username(var1, this.loginType);
         if (var3.hasCleanName()) {
            if (this.ignoreList.removeByUsername(var3)) {
               Client.field557 = Client.cycleCntr;
               if (var2) {
                  PacketBufferNode var4 = class330.getPacketBufferNode(ClientPacket.field2478, Client.packetWriter.isaacCipher);
                  var4.packetBuffer.writeByte(DynamicObject.stringCp1252NullTerminatedByteSize(var1));
                  var4.packetBuffer.writeStringCp1252NullTerminated(var1);
                  Client.packetWriter.addNode(var4);
               }
            }

            Login.FriendSystem_invalidateIgnoreds();
         }
      }
   }

    @ObfuscatedName("am")
    @ObfuscatedSignature(
            descriptor = "(Ltm;I)Z",
            garbageValue = "-2018991784"
    )
    final boolean isFriendAndHasWorld(Username var1) {
      Friend var2 = (Friend)this.friendsList.getByUsername(var1);
      return var2 != null && var2.hasWorld();
   }

   @ObfuscatedName("ce")
   @ObfuscatedSignature(
      descriptor = "(ILch;ZI)I",
      garbageValue = "994468925"
   )
   static int method425(int var0, Script var1, boolean var2) {
      return 2;
   }
}
