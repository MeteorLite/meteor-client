import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fy")
@Implements("ObjTypeCustomisation")
public class ObjTypeCustomisation {
    @ObfuscatedName("v")
    public short[] recol;
    @ObfuscatedName("s")
    public short[] retex;

   ObjTypeCustomisation(int var1) {
      ItemComposition var2 = TileItem.ItemDefinition_get(var1);
      if (var2.hasRecolor()) {
         this.recol = new short[var2.recolorTo.length];
         System.arraycopy(var2.recolorTo, 0, this.recol, 0, this.recol.length);
      }

      if (var2.hasRetexture()) {
         this.retex = new short[var2.retextureTo.length];
         System.arraycopy(var2.retextureTo, 0, this.retex, 0, this.retex.length);
      }

   }

    @ObfuscatedName("f")
    @ObfuscatedSignature(
            descriptor = "(I)[Ljg;",
            garbageValue = "1293582698"
    )
    public static ServerPacket[] ServerPacket_values() {
      return new ServerPacket[]{ServerPacket.field2661, ServerPacket.field2560, ServerPacket.field2651, ServerPacket.field2562, ServerPacket.field2563, ServerPacket.field2564, ServerPacket.field2604, ServerPacket.field2566, ServerPacket.field2672, ServerPacket.field2568, ServerPacket.field2569, ServerPacket.field2634, ServerPacket.field2571, ServerPacket.field2572, ServerPacket.field2640, ServerPacket.field2574, ServerPacket.field2575, ServerPacket.field2576, ServerPacket.field2577, ServerPacket.field2578, ServerPacket.field2626, ServerPacket.field2580, ServerPacket.field2598, ServerPacket.field2582, ServerPacket.field2573, ServerPacket.field2584, ServerPacket.field2585, ServerPacket.field2586, ServerPacket.field2587, ServerPacket.field2588, ServerPacket.field2589, ServerPacket.field2590, ServerPacket.field2591, ServerPacket.field2649, ServerPacket.field2593, ServerPacket.field2565, ServerPacket.field2567, ServerPacket.field2596, ServerPacket.field2597, ServerPacket.field2663, ServerPacket.field2583, ServerPacket.field2600, ServerPacket.field2594, ServerPacket.field2602, ServerPacket.field2603, ServerPacket.field2673, ServerPacket.field2605, ServerPacket.field2606, ServerPacket.field2607, ServerPacket.field2615, ServerPacket.field2609, ServerPacket.field2610, ServerPacket.field2611, ServerPacket.field2654, ServerPacket.field2613, ServerPacket.field2614, ServerPacket.field2620, ServerPacket.field2581, ServerPacket.field2617, ServerPacket.field2670, ServerPacket.field2561, ServerPacket.field2579, ServerPacket.field2621, ServerPacket.field2622, ServerPacket.field2623, ServerPacket.field2643, ServerPacket.field2625, ServerPacket.field2646, ServerPacket.field2627, ServerPacket.field2628, ServerPacket.field2601, ServerPacket.field2648, ServerPacket.field2631, ServerPacket.field2632, ServerPacket.field2638, ServerPacket.field2619, ServerPacket.field2618, ServerPacket.field2636, ServerPacket.field2637, ServerPacket.field2612, ServerPacket.field2639, ServerPacket.field2633, ServerPacket.field2658, ServerPacket.field2642, ServerPacket.field2599, ServerPacket.field2644, ServerPacket.field2645, ServerPacket.field2592, ServerPacket.field2647, ServerPacket.field2630, ServerPacket.field2616, ServerPacket.field2650, ServerPacket.field2641, ServerPacket.field2652, ServerPacket.field2653, ServerPacket.field2608, ServerPacket.field2559, ServerPacket.field2656, ServerPacket.field2657, ServerPacket.field2660, ServerPacket.field2659, ServerPacket.field2595, ServerPacket.field2655, ServerPacket.field2662, ServerPacket.field2624, ServerPacket.field2664, ServerPacket.field2665, ServerPacket.field2666, ServerPacket.field2667, ServerPacket.field2668, ServerPacket.field2669, ServerPacket.field2629, ServerPacket.field2671};
   }

    @ObfuscatedName("ih")
    @ObfuscatedSignature(
            descriptor = "(IIIIIIIIIIB)V",
            garbageValue = "63"
    )
    static final void updatePendingSpawn(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
      PendingSpawn var10 = null;

      for(PendingSpawn var11 = (PendingSpawn)Client.pendingSpawns.last(); var11 != null; var11 = (PendingSpawn)Client.pendingSpawns.previous()) {
         if (var0 == var11.plane && var11.x == var1 && var2 == var11.y && var3 == var11.type) {
            var10 = var11;
            break;
         }
      }

      if (var10 == null) {
         var10 = new PendingSpawn();
         var10.plane = var0;
         var10.type = var3;
         var10.x = var1;
         var10.y = var2;
         class204.method1076(var10);
         Client.pendingSpawns.addFirst(var10);
      }

      var10.id = var4;
      var10.objectType = var5;
      var10.rotation = var6;
      var10.startCycle = var8;
      var10.endCycle = var9;
      var10.method496(var7);
   }
}
