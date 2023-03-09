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
      return new ServerPacket[]{ServerPacket.field2628, ServerPacket.field2537, ServerPacket.field2542, ServerPacket.field2636, ServerPacket.field2540, ServerPacket.field2541, ServerPacket.field2571, ServerPacket.field2543, ServerPacket.field2635, ServerPacket.field2598, ServerPacket.field2546, ServerPacket.field2547, ServerPacket.field2548, ServerPacket.field2559, ServerPacket.field2550, ServerPacket.field2551, ServerPacket.field2552, ServerPacket.field2553, ServerPacket.field2611, ServerPacket.field2555, ServerPacket.field2556, ServerPacket.field2557, ServerPacket.field2558, ServerPacket.field2544, ServerPacket.field2617, ServerPacket.field2561, ServerPacket.field2562, ServerPacket.field2563, ServerPacket.field2564, ServerPacket.field2565, ServerPacket.field2566, ServerPacket.field2570, ServerPacket.field2584, ServerPacket.field2572, ServerPacket.field2545, ServerPacket.field2608, ServerPacket.field2597, ServerPacket.field2573, ServerPacket.field2567, ServerPacket.field2575, ServerPacket.field2576, ServerPacket.field2577, ServerPacket.field2578, ServerPacket.field2579, ServerPacket.field2580, ServerPacket.field2581, ServerPacket.field2637, ServerPacket.field2583, ServerPacket.field2538, ServerPacket.field2585, ServerPacket.field2586, ServerPacket.field2587, ServerPacket.field2588, ServerPacket.field2644, ServerPacket.field2590, ServerPacket.field2591, ServerPacket.field2592, ServerPacket.field2602, ServerPacket.field2594, ServerPacket.field2620, ServerPacket.field2601, ServerPacket.field2568, ServerPacket.field2539, ServerPacket.field2599, ServerPacket.field2600, ServerPacket.field2621, ServerPacket.field2625, ServerPacket.field2603, ServerPacket.field2604, ServerPacket.field2605, ServerPacket.field2606, ServerPacket.field2607, ServerPacket.field2633, ServerPacket.field2609, ServerPacket.field2610, ServerPacket.field2536, ServerPacket.field2612, ServerPacket.field2613, ServerPacket.field2614, ServerPacket.field2615, ServerPacket.field2616, ServerPacket.field2596, ServerPacket.field2618, ServerPacket.field2619, ServerPacket.field2549, ServerPacket.field2574, ServerPacket.field2622, ServerPacket.field2623, ServerPacket.field2624, ServerPacket.field2639, ServerPacket.field2626, ServerPacket.field2627, ServerPacket.field2638, ServerPacket.field2629, ServerPacket.field2630, ServerPacket.field2631, ServerPacket.field2632, ServerPacket.field2593, ServerPacket.field2634, ServerPacket.field2595, ServerPacket.field2560, ServerPacket.field2569, ServerPacket.field2589, ServerPacket.field2554, ServerPacket.field2640, ServerPacket.field2641, ServerPacket.field2642, ServerPacket.field2643};
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
