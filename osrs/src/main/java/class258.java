import java.util.List;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jj")
public class class258 {
   @ObfuscatedName("vf")
   static List field2371;
   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "Ljj;"
   )
   static final class258 field2369 = new class258(0);
   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "Ljj;"
   )
   static final class258 field2373 = new class258(1);
   @ObfuscatedName("fb")
   @ObfuscatedSignature(
      descriptor = "Lmx;"
   )
   @Export("archive2")
   static Archive archive2;
   @ObfuscatedName("ac")
   @Export("value")
   final int value;

   class258(int var1) {
      this.value = var1;
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "(I)[Lke;",
      garbageValue = "-1296187217"
   )
   @Export("ServerPacket_values")
   public static ServerPacket[] ServerPacket_values() {
      return new ServerPacket[]{ServerPacket.REBUILD_REGION_NORMAL, ServerPacket.REBUILD_REGION, ServerPacket.field2542, ServerPacket.CLANCHANNEL_DELTA, ServerPacket.field2540, ServerPacket.field2541, ServerPacket.REFLECTION_CHECK, ServerPacket.field2543, ServerPacket.field2635, ServerPacket.UPDATE_INV_FULL, ServerPacket.CHAT_FILTER_SETTINGS, ServerPacket.field2547, ServerPacket.field2548, ServerPacket.field2559, ServerPacket.field2550, ServerPacket.field2551, ServerPacket.field2552, ServerPacket.field2553, ServerPacket.field2611, ServerPacket.field2555, ServerPacket.field2556, ServerPacket.SPOTANIM_SPECIFIC, ServerPacket.RESET_ANIMS, ServerPacket.field2544, ServerPacket.field2617, ServerPacket.ENTER_FREECAM, ServerPacket.field2562, ServerPacket.field2563, ServerPacket.field2564, ServerPacket.field2565, ServerPacket.field2566, ServerPacket.field2570, ServerPacket.field2584, ServerPacket.UPDATE_INV_PARTIAL, ServerPacket.field2545, ServerPacket.field2608, ServerPacket.PLAYER_INFO, ServerPacket.GAMEFRAME_FULL, ServerPacket.field2567, ServerPacket.TRIGGER_ONDIALOGABORT, ServerPacket.field2576, ServerPacket.SYNTH_SOUND, ServerPacket.HEAT_MAP, ServerPacket.TRADING_POST_RESULTS, ServerPacket.field2580, ServerPacket.MESSAGE_PRIVATE, ServerPacket.field2637, ServerPacket.IF_SETEVENTS, ServerPacket.field2538, ServerPacket.FRIENDLIST_LOADED, ServerPacket.field2586, ServerPacket.CAM_SHAKE, ServerPacket.UPDATE_UID192, ServerPacket.field2644, ServerPacket.field2590, ServerPacket.IF_MOVESUB, ServerPacket.UPDATE_RUNENERGY, ServerPacket.IF_SETNPCHEAD, ServerPacket.UPDATE_ZONE_PARTIAL_FOLLOWS, ServerPacket.field2620, ServerPacket.IF_SETANIM, ServerPacket.IF_OPENSUB, ServerPacket.field2539, ServerPacket.field2599, ServerPacket.field2600, ServerPacket.field2621, ServerPacket.CAM_LOOKAT, ServerPacket.field2603, ServerPacket.field2604, ServerPacket.field2605, ServerPacket.field2606, ServerPacket.field2607, ServerPacket.field2633, ServerPacket.field2609, ServerPacket.field2610, ServerPacket.VARCLAN, ServerPacket.field2612, ServerPacket.LOGOUT_TRANSFER, ServerPacket.field2614, ServerPacket.field2615, ServerPacket.field2616, ServerPacket.field2596, ServerPacket.field2618, ServerPacket.field2619, ServerPacket.MESSAGE_CLANCHANNEL_SYSTEM, ServerPacket.UPDATE_INV_CLEAR, ServerPacket.field2622, ServerPacket.field2623, ServerPacket.field2624, ServerPacket.field2639, ServerPacket.field2626, ServerPacket.field2627, ServerPacket.IF_SETPOSITION, ServerPacket.TOGGLE_OCULUS_ORB, ServerPacket.field2630, ServerPacket.field2631, ServerPacket.field2632, ServerPacket.MESSAGE_PRIVATE_ECHO, ServerPacket.IF_SETTEXT, ServerPacket.field2595, ServerPacket.NPC_INFO_SMALL, ServerPacket.NPC_INFO_LARGE, ServerPacket.field2589, ServerPacket.field2554, ServerPacket.field2640, ServerPacket.IF_SETOBJECT, ServerPacket.field2642, ServerPacket.field2643};
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "-36"
   )
   public static void method1464() {
      class293.midiPcmStream.clear();
      class293.musicPlayerStatus = 1;
      class364.musicTrackArchive = null;
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "(IB)Z",
      garbageValue = "-28"
   )
   public static boolean method1462(int var0) {
      return var0 >= WorldMapDecorationType.field3002.id && var0 <= WorldMapDecorationType.field3017.id;
   }
}
