import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jc")
@Implements("BoundaryObject")
public final class BoundaryObject {
   @ObfuscatedName("aj")
   @Export("z")
   int z;
   @ObfuscatedName("al")
   @Export("x")
   int x;
   @ObfuscatedName("ac")
   @Export("y")
   int y;
   @ObfuscatedName("ab")
   @Export("orientationA")
   int orientationA;
   @ObfuscatedName("an")
   @Export("orientationB")
   int orientationB;
   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      descriptor = "Liq;"
   )
   @Export("renderable1")
   public Renderable renderable1;
   @ObfuscatedName("av")
   @ObfuscatedSignature(
      descriptor = "Liq;"
   )
   @Export("renderable2")
   public Renderable renderable2;
   @ObfuscatedName("aq")
   @Export("tag")
   public long tag = 0L;
   @ObfuscatedName("ap")
   @Export("flags")
   int flags = 0;

   @ObfuscatedName("ix")
   @ObfuscatedSignature(
      descriptor = "(ZI)V",
      garbageValue = "1252454973"
   )
   static final void method1298(boolean var0) {
      EnumComposition.playPcmPlayers();
      ++Client.packetWriter.pendingWrites;
      if (Client.packetWriter.pendingWrites >= 50 || var0) {
         Client.packetWriter.pendingWrites = 0;
         if (!Client.hadNetworkError && Client.packetWriter.getSocket() != null) {
            PacketBufferNode var1 = UserComparator9.getPacketBufferNode(ClientPacket.field2456, Client.packetWriter.isaacCipher);
            Client.packetWriter.addNode(var1);

            try {
               Client.packetWriter.flush();
            } catch (IOException var3) {
               Client.hadNetworkError = true;
            }
         }

      }
   }
}
