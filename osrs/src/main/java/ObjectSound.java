import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("br")
@Implements("ObjectSound")
public final class ObjectSound extends Node {
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "Lmq;"
   )
   @Export("objectSounds")
   static NodeDeque objectSounds = new NodeDeque();
   @ObfuscatedName("e")
   @Export("plane")
   int plane;
   @ObfuscatedName("v")
   @Export("x")
   int x;
   @ObfuscatedName("x")
   @Export("y")
   int y;
   @ObfuscatedName("m")
   @Export("maxX")
   int maxX;
   @ObfuscatedName("q")
   @Export("maxY")
   int maxY;
   @ObfuscatedName("f")
   int field680;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      descriptor = "Lgn;"
   )
   @Export("obj")
   ObjectComposition obj;
   @ObfuscatedName("u")
   @Export("soundEffectId")
   int soundEffectId;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      descriptor = "Lap;"
   )
   @Export("stream1")
   RawPcmStream stream1;
   @ObfuscatedName("j")
   int field675;
   @ObfuscatedName("g")
   int field672;
   @ObfuscatedName("i")
   @Export("soundEffectIds")
   int[] soundEffectIds;
   @ObfuscatedName("o")
   int field683;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      descriptor = "Lap;"
   )
   @Export("stream2")
   RawPcmStream stream2;

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "-1596084359"
   )
   @Export("set")
   void set() {
      int var1 = this.soundEffectId;
      ObjectComposition var2 = this.obj.transform();
      if (var2 != null) {
         this.soundEffectId = var2.ambientSoundId;
         this.field680 = var2.int7 * 128;
         this.field675 = var2.int5;
         this.field672 = var2.int6;
         this.soundEffectIds = var2.soundEffectIds;
      } else {
         this.soundEffectId = -1;
         this.field680 = 0;
         this.field675 = 0;
         this.field672 = 0;
         this.soundEffectIds = null;
      }

      if (var1 != this.soundEffectId && this.stream1 != null) {
         ApproximateRouteStrategy.pcmStreamMixer.removeSubStream(this.stream1);
         this.stream1 = null;
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "(CI)Z",
      garbageValue = "1783942898"
   )
   public static boolean method415(char var0) {
      if ((var0 < ' ' || var0 >= 127) && (var0 <= 127 || var0 >= 160) && (var0 <= 160 || var0 > 255)) {
         if (var0 != 0) {
            char[] var1 = class358.cp1252AsciiExtension;

            for(int var2 = 0; var2 < var1.length; ++var2) {
               char var3 = var1[var2];
               if (var0 == var3) {
                  return true;
               }
            }
         }

         return false;
      } else {
         return true;
      }
   }

   @ObfuscatedName("jy")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;Ljava/lang/String;IIIIB)V",
      garbageValue = "11"
   )
   @Export("insertMenuItemNoShift")
   public static final void insertMenuItemNoShift(String var0, String var1, int var2, int var3, int var4, int var5) {
      class37.insertMenuItem(var0, var1, var2, var3, var4, var5, -1, false);
   }
}
