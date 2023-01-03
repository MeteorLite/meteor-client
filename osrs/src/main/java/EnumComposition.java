import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("go")
@Implements("EnumComposition")
public class EnumComposition extends DualNode {
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "Ljv;"
   )
   @Export("EnumDefinition_cached")
   static EvictingDualNodeHashTable EnumDefinition_cached = new EvictingDualNodeHashTable(64);
   @ObfuscatedName("fe")
   static String field1536;
   @ObfuscatedName("v")
   @Export("inputType")
   public char inputType;
   @ObfuscatedName("x")
   @Export("outputType")
   public char outputType;
   @ObfuscatedName("m")
   @Export("defaultStr")
   public String defaultStr = "null";
   @ObfuscatedName("q")
   @Export("defaultInt")
   public int defaultInt;
   @ObfuscatedName("f")
   @Export("outputCount")
   public int outputCount = 0;
   @ObfuscatedName("r")
   @Export("keys")
   public int[] keys;
   @ObfuscatedName("u")
   @Export("intVals")
   public int[] intVals;
   @ObfuscatedName("b")
   @Export("strVals")
   public String[] strVals;

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "(Lqy;I)V",
      garbageValue = "-2074495591"
   )
   @Export("decode")
   void decode(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if (var2 == 0) {
            return;
         }

         this.decodeNext(var1, var2);
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      descriptor = "(Lqy;IS)V",
      garbageValue = "8918"
   )
   @Export("decodeNext")
   void decodeNext(Buffer var1, int var2) {
      if (var2 == 1) {
         this.inputType = (char)var1.readUnsignedByte();
      } else if (var2 == 2) {
         this.outputType = (char)var1.readUnsignedByte();
      } else if (var2 == 3) {
         this.defaultStr = var1.readStringCp1252NullTerminated();
      } else if (var2 == 4) {
         this.defaultInt = var1.readInt();
      } else {
         int var3;
         if (var2 == 5) {
            this.outputCount = var1.readUnsignedShort();
            this.keys = new int[this.outputCount];
            this.strVals = new String[this.outputCount];

            for(var3 = 0; var3 < this.outputCount; ++var3) {
               this.keys[var3] = var1.readInt();
               this.strVals[var3] = var1.readStringCp1252NullTerminated();
            }
         } else if (var2 == 6) {
            this.outputCount = var1.readUnsignedShort();
            this.keys = new int[this.outputCount];
            this.intVals = new int[this.outputCount];

            for(var3 = 0; var3 < this.outputCount; ++var3) {
               this.keys[var3] = var1.readInt();
               this.intVals[var3] = var1.readInt();
            }
         }
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "-585138184"
   )
   @Export("size")
   public int size() {
      return this.outputCount;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(I)[Ljf;",
      garbageValue = "-1969198767"
   )
   @Export("ServerPacket_values")
   public static ServerPacket[] ServerPacket_values() {
      return new ServerPacket[]{ServerPacket.field2597, ServerPacket.field2596, ServerPacket.field2673, ServerPacket.field2565, ServerPacket.field2576, ServerPacket.field2567, ServerPacket.field2564, ServerPacket.field2569, ServerPacket.field2570, ServerPacket.field2587, ServerPacket.field2572, ServerPacket.field2573, ServerPacket.field2574, ServerPacket.field2641, ServerPacket.field2650, ServerPacket.field2577, ServerPacket.field2578, ServerPacket.field2579, ServerPacket.field2580, ServerPacket.field2609, ServerPacket.field2575, ServerPacket.field2583, ServerPacket.field2653, ServerPacket.field2585, ServerPacket.field2651, ServerPacket.field2562, ServerPacket.field2588, ServerPacket.field2589, ServerPacket.field2590, ServerPacket.field2591, ServerPacket.field2584, ServerPacket.field2593, ServerPacket.field2581, ServerPacket.field2649, ServerPacket.field2566, ServerPacket.field2659, ServerPacket.field2598, ServerPacket.field2592, ServerPacket.field2600, ServerPacket.field2601, ServerPacket.field2602, ServerPacket.field2603, ServerPacket.field2630, ServerPacket.field2605, ServerPacket.field2606, ServerPacket.field2563, ServerPacket.field2608, ServerPacket.field2621, ServerPacket.field2610, ServerPacket.field2611, ServerPacket.field2571, ServerPacket.field2636, ServerPacket.field2614, ServerPacket.field2615, ServerPacket.field2616, ServerPacket.field2635, ServerPacket.field2595, ServerPacket.field2619, ServerPacket.field2620, ServerPacket.field2618, ServerPacket.field2622, ServerPacket.field2623, ServerPacket.field2624, ServerPacket.field2625, ServerPacket.field2626, ServerPacket.field2645, ServerPacket.field2664, ServerPacket.field2613, ServerPacket.field2628, ServerPacket.field2604, ServerPacket.field2632, ServerPacket.field2633, ServerPacket.field2634, ServerPacket.field2586, ServerPacket.field2627, ServerPacket.field2637, ServerPacket.field2643, ServerPacket.field2639, ServerPacket.field2640, ServerPacket.field2678, ServerPacket.field2642, ServerPacket.field2617, ServerPacket.field2644, ServerPacket.field2638, ServerPacket.field2646, ServerPacket.field2647, ServerPacket.field2648, ServerPacket.field2665, ServerPacket.field2582, ServerPacket.field2594, ServerPacket.field2666, ServerPacket.field2607, ServerPacket.field2654, ServerPacket.field2655, ServerPacket.field2656, ServerPacket.field2657, ServerPacket.field2658, ServerPacket.field2652, ServerPacket.field2660, ServerPacket.field2661, ServerPacket.field2662, ServerPacket.field2663, ServerPacket.field2631, ServerPacket.field2612, ServerPacket.field2629, ServerPacket.field2667, ServerPacket.field2668, ServerPacket.field2669, ServerPacket.field2670, ServerPacket.field2671, ServerPacket.field2672, ServerPacket.field2568, ServerPacket.field2674, ServerPacket.field2675, ServerPacket.field2676};
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "([BI)Ljava/lang/String;",
      garbageValue = "-850113409"
   )
   public static String method944(byte[] var0) {
      int var2 = var0.length;
      StringBuilder var3 = new StringBuilder();

      for(int var4 = 0; var4 < var2 + 0; var4 += 3) {
         int var5 = var0[var4] & 255;
         var3.append(class359.field3568[var5 >>> 2]);
         if (var4 < var2 - 1) {
            int var6 = var0[var4 + 1] & 255;
            var3.append(class359.field3568[(var5 & 3) << 4 | var6 >>> 4]);
            if (var4 < var2 - 2) {
               int var7 = var0[var4 + 2] & 255;
               var3.append(class359.field3568[(var6 & 15) << 2 | var7 >>> 6]).append(class359.field3568[var7 & 63]);
            } else {
               var3.append(class359.field3568[(var6 & 15) << 2]).append("=");
            }
         } else {
            var3.append(class359.field3568[(var5 & 3) << 4]).append("==");
         }
      }

      String var1 = var3.toString();
      return var1;
   }
}
