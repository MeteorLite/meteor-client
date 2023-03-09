import java.io.File;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fy")
@Implements("ClanChannelMember")
public class ClanChannelMember {
   @ObfuscatedName("ab")
   @Export("JagexCache_locationFile")
   static File JagexCache_locationFile;
   @ObfuscatedName("aj")
   @Export("rank")
   public byte rank;
   @ObfuscatedName("al")
   @Export("world")
   public int world;
   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "Ltj;"
   )
   @Export("username")
   public Username username;

   @ObfuscatedName("mc")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "0"
   )
   @Export("Clan_leaveChat")
   static final void Clan_leaveChat() {
      PacketBufferNode var0 = UserComparator9.getPacketBufferNode(ClientPacket.field2467, Client.packetWriter.isaacCipher);
      var0.packetBuffer.writeByte(0);
      Client.packetWriter.addNode(var0);
   }
}
