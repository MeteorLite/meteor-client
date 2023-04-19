import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lg")
@Implements("PacketBufferNode")
public class PacketBufferNode extends Node {
    @ObfuscatedName("au")
    @ObfuscatedSignature(
            descriptor = "[Llg;"
    )
    static PacketBufferNode[] PacketBufferNode_packetBufferNodes = new PacketBufferNode[300];
    @ObfuscatedName("ab")
    static int PacketBufferNode_packetBufferNodeCount = 0;
    @ObfuscatedName("af")
    @ObfuscatedSignature(
            descriptor = "Llv;"
    )
    ClientPacket clientPacket;
    @ObfuscatedName("an")
    int clientPacketLength;
    @ObfuscatedName("aw")
    @ObfuscatedSignature(
            descriptor = "Lsq;"
    )
    public PacketBuffer packetBuffer;
    @ObfuscatedName("ac")
    public int index;

    @ObfuscatedName("ac")
    @ObfuscatedSignature(
            descriptor = "(I)V",
            garbageValue = "-2073453785"
    )
    public void release() {
      if (PacketBufferNode_packetBufferNodeCount < PacketBufferNode_packetBufferNodes.length) {
         PacketBufferNode_packetBufferNodes[++PacketBufferNode_packetBufferNodeCount - 1] = this;
      }
   }

    @ObfuscatedName("af")
    @ObfuscatedSignature(
            descriptor = "(I)[Lls;",
            garbageValue = "-1731859764"
    )
    public static ServerPacket[] ServerPacket_values() {
      return new ServerPacket[]{ServerPacket.field2622, ServerPacket.field2580, ServerPacket.field2581, ServerPacket.CLANCHANNEL_DELTA, ServerPacket.IF_SETTEXT, ServerPacket.field2584, ServerPacket.REFLECTION_CHECK, ServerPacket.field2608, ServerPacket.field2629, ServerPacket.field2588, ServerPacket.CHAT_FILTER_SETTINGS, ServerPacket.field2615, ServerPacket.field2591, ServerPacket.field2592, ServerPacket.field2593, ServerPacket.field2594, ServerPacket.field2667, ServerPacket.field2596, ServerPacket.field2583, ServerPacket.field2598, ServerPacket.field2599, ServerPacket.SPOTANIM_SPECIFIC, ServerPacket.field2601, ServerPacket.NPC_INFO_LARGE, ServerPacket.field2666, ServerPacket.ENTER_FREECAM, ServerPacket.field2605, ServerPacket.IF_SETPOSITION, ServerPacket.field2607, ServerPacket.field2603, ServerPacket.field2609, ServerPacket.field2610, ServerPacket.field2683, ServerPacket.UPDATE_INV_PARTIAL, ServerPacket.field2644, ServerPacket.field2611, ServerPacket.PLAYER_INFO, ServerPacket.field2616, ServerPacket.IF_SETOBJECT, ServerPacket.field2618, ServerPacket.field2619, ServerPacket.field2613, ServerPacket.RESET_ANIMS, ServerPacket.field2586, ServerPacket.field2671, ServerPacket.UPDATE_INV_FULL, ServerPacket.MESSAGE_CLANCHANNEL_SYSTEM, ServerPacket.field2626, ServerPacket.field2623, ServerPacket.field2649, ServerPacket.field2679, ServerPacket.field2627, ServerPacket.UPDATE_UID192, ServerPacket.field2632, ServerPacket.field2633, ServerPacket.field2634, ServerPacket.UPDATE_ZONE_PARTIAL_FOLLOWS, ServerPacket.IF_SETNPCHEAD, ServerPacket.field2637, ServerPacket.HEAT_MAP, ServerPacket.TRIGGER_ONDIALOGABORT, ServerPacket.IF_OPENSUB, ServerPacket.field2641, ServerPacket.field2642, ServerPacket.REBUILD_REGION, ServerPacket.field2677, ServerPacket.CAM_LOOKAT, ServerPacket.field2647, ServerPacket.field2597, ServerPacket.field2648, ServerPacket.field2695, ServerPacket.field2650, ServerPacket.field2651, ServerPacket.field2652, ServerPacket.GAMEFRAME_FULL, ServerPacket.VARCLAN, ServerPacket.field2620, ServerPacket.LOGOUT_TRANSFER, ServerPacket.field2686, ServerPacket.field2658, ServerPacket.field2676, ServerPacket.field2660, ServerPacket.field2694, ServerPacket.field2579, ServerPacket.field2691, ServerPacket.field2664, ServerPacket.field2665, ServerPacket.field2630, ServerPacket.NPC_INFO_SMALL, ServerPacket.field2668, ServerPacket.field2669, ServerPacket.field2659, ServerPacket.field2698, ServerPacket.field2657, ServerPacket.UPDATE_INV_CLEAR, ServerPacket.field2674, ServerPacket.TRADING_POST_RESULTS, ServerPacket.MESSAGE_PRIVATE_ECHO, ServerPacket.field2614, ServerPacket.field2672, ServerPacket.field2628, ServerPacket.field2680, ServerPacket.field2681, ServerPacket.field2682, ServerPacket.field2600, ServerPacket.field2684, ServerPacket.field2685, ServerPacket.field2646, ServerPacket.UPDATE_RUNENERGY, ServerPacket.MESSAGE_PRIVATE, ServerPacket.field2689, ServerPacket.field2690, ServerPacket.field2631, ServerPacket.REBUILD_REGION_NORMAL, ServerPacket.field2693, ServerPacket.field2670, ServerPacket.field2678, ServerPacket.field2696, ServerPacket.field2697};
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/CharSequence;B)I",
      garbageValue = "27"
   )
   public static int method1602(CharSequence var0) {
      return SecureRandomFuture.method456(var0, 10, true);
   }
}
