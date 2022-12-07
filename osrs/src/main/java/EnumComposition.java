import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("go")
public class EnumComposition extends DualNode {
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "Ljv;"
   )
   static EvictingDualNodeHashTable EnumDefinition_cached = new EvictingDualNodeHashTable(64);
   @ObfuscatedName("fe")
   static String field2006;
   @ObfuscatedName("v")
   public char inputType;
   @ObfuscatedName("x")
   public char outputType;
   @ObfuscatedName("m")
   public String defaultStr = "null";
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1478484323
   )
   public int defaultInt;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1015031679
   )
   public int outputCount = 0;
   @ObfuscatedName("r")
   public int[] keys;
   @ObfuscatedName("u")
   public int[] intVals;
   @ObfuscatedName("b")
   public String[] strVals;

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "(Lqy;I)V",
      garbageValue = "-2074495591"
   )
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
   public int size() {
      return this.outputCount;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(I)[Ljf;",
      garbageValue = "-1969198767"
   )
   public static ServerPacket[] ServerPacket_values() {
      return new ServerPacket[]{ServerPacket.field3218, ServerPacket.field3217, ServerPacket.field3294, ServerPacket.field3186, ServerPacket.field3197, ServerPacket.field3188, ServerPacket.field3185, ServerPacket.field3190, ServerPacket.field3191, ServerPacket.field3208, ServerPacket.field3193, ServerPacket.field3194, ServerPacket.field3195, ServerPacket.field3262, ServerPacket.field3271, ServerPacket.field3198, ServerPacket.field3199, ServerPacket.field3200, ServerPacket.field3201, ServerPacket.field3230, ServerPacket.field3196, ServerPacket.field3204, ServerPacket.field3274, ServerPacket.field3206, ServerPacket.field3272, ServerPacket.field3183, ServerPacket.field3209, ServerPacket.field3210, ServerPacket.field3211, ServerPacket.field3212, ServerPacket.field3205, ServerPacket.field3214, ServerPacket.field3202, ServerPacket.field3270, ServerPacket.field3187, ServerPacket.field3280, ServerPacket.field3219, ServerPacket.field3213, ServerPacket.field3221, ServerPacket.field3222, ServerPacket.field3223, ServerPacket.field3224, ServerPacket.field3251, ServerPacket.field3226, ServerPacket.field3227, ServerPacket.field3184, ServerPacket.field3229, ServerPacket.field3242, ServerPacket.field3231, ServerPacket.field3232, ServerPacket.field3192, ServerPacket.field3257, ServerPacket.field3235, ServerPacket.field3236, ServerPacket.field3237, ServerPacket.field3256, ServerPacket.field3216, ServerPacket.field3240, ServerPacket.field3241, ServerPacket.field3239, ServerPacket.field3243, ServerPacket.field3244, ServerPacket.field3245, ServerPacket.field3246, ServerPacket.field3247, ServerPacket.field3266, ServerPacket.field3285, ServerPacket.field3234, ServerPacket.field3249, ServerPacket.field3225, ServerPacket.field3253, ServerPacket.field3254, ServerPacket.field3255, ServerPacket.field3207, ServerPacket.field3248, ServerPacket.field3258, ServerPacket.field3264, ServerPacket.field3260, ServerPacket.field3261, ServerPacket.field3299, ServerPacket.field3263, ServerPacket.field3238, ServerPacket.field3265, ServerPacket.field3259, ServerPacket.field3267, ServerPacket.field3268, ServerPacket.field3269, ServerPacket.field3286, ServerPacket.field3203, ServerPacket.field3215, ServerPacket.field3287, ServerPacket.field3228, ServerPacket.field3275, ServerPacket.field3276, ServerPacket.field3277, ServerPacket.field3278, ServerPacket.field3279, ServerPacket.field3273, ServerPacket.field3281, ServerPacket.field3282, ServerPacket.field3283, ServerPacket.field3284, ServerPacket.field3252, ServerPacket.field3233, ServerPacket.field3250, ServerPacket.field3288, ServerPacket.field3289, ServerPacket.field3290, ServerPacket.field3291, ServerPacket.field3292, ServerPacket.field3293, ServerPacket.field3189, ServerPacket.field3295, ServerPacket.field3296, ServerPacket.field3297};
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "([BI)Ljava/lang/String;",
      garbageValue = "-850113409"
   )
   public static String method3650(byte[] var0) {
      int var2 = var0.length;
      StringBuilder var3 = new StringBuilder();

      for(int var4 = 0; var4 < var2 + 0; var4 += 3) {
         int var5 = var0[var4] & 255;
         var3.append(class359.field4350[var5 >>> 2]);
         if (var4 < var2 - 1) {
            int var6 = var0[var4 + 1] & 255;
            var3.append(class359.field4350[(var5 & 3) << 4 | var6 >>> 4]);
            if (var4 < var2 - 2) {
               int var7 = var0[var4 + 2] & 255;
               var3.append(class359.field4350[(var6 & 15) << 2 | var7 >>> 6]).append(class359.field4350[var7 & 63]);
            } else {
               var3.append(class359.field4350[(var6 & 15) << 2]).append("=");
            }
         } else {
            var3.append(class359.field4350[(var5 & 3) << 4]).append("==");
         }
      }

      String var1 = var3.toString();
      return var1;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/Throwable;Ljava/lang/String;)Lrw;"
   )
   public static RunException newRunException(Throwable var0, String var1) {
      RunException var2;
      if (var0 instanceof RunException) {
         var2 = (RunException)var0;
         var2.message = var2.message + ' ' + var1;
      } else {
         var2 = new RunException(var0, var1);
      }

      return var2;
   }
}
