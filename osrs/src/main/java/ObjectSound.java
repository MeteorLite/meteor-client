import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bd")
@Implements("ObjectSound")
public final class ObjectSound extends Node {
    @ObfuscatedName("f")
    @ObfuscatedSignature(
            descriptor = "Lmo;"
    )
    static NodeDeque objectSounds = new NodeDeque();
    @ObfuscatedName("w")
    int plane;
    @ObfuscatedName("v")
    int x;
   @ObfuscatedName("s")
   int field699;
    @ObfuscatedName("z")
    int maxX;
    @ObfuscatedName("j")
    int y;
    @ObfuscatedName("i")
    int maxY;
   @ObfuscatedName("n")
   int field692;
    @ObfuscatedName("l")
    int soundEffectId;
    @ObfuscatedName("k")
    @ObfuscatedSignature(
            descriptor = "Lab;"
    )
    RawPcmStream stream1;
   @ObfuscatedName("c")
   int field695;
    @ObfuscatedName("r")
    @ObfuscatedSignature(
            descriptor = "Lgp;"
    )
    ObjectComposition obj;
    @ObfuscatedName("b")
    int[] soundEffectIds;
   @ObfuscatedName("m")
   int field697;
    @ObfuscatedName("t")
    @ObfuscatedSignature(
            descriptor = "Lab;"
    )
    RawPcmStream stream2;

    @ObfuscatedName("w")
    @ObfuscatedSignature(
            descriptor = "(I)V",
            garbageValue = "1406631425"
    )
    void set() {
      int var1 = this.soundEffectId;
      ObjectComposition var2 = this.obj.transform();
      if (var2 != null) {
         this.soundEffectId = var2.ambientSoundId;
         this.field692 = var2.int7 * 128;
         this.field699 = var2.int5;
         this.field695 = var2.int6;
         this.soundEffectIds = var2.soundEffectIds;
      } else {
         this.soundEffectId = -1;
         this.field692 = 0;
         this.field699 = 0;
         this.field695 = 0;
         this.soundEffectIds = null;
      }

      if (var1 != this.soundEffectId && this.stream1 != null) {
         class209.pcmStreamMixer.removeSubStream(this.stream1);
         this.stream1 = null;
      }

   }

    @ObfuscatedName("f")
    @ObfuscatedSignature(
            descriptor = "(IB)Ljava/lang/String;",
            garbageValue = "1"
    )
    static String addImageTag(int var0) {
      return "<img=" + var0 + ">";
   }

    @ObfuscatedName("l")
    @ObfuscatedSignature(
            descriptor = "(Lkz;I[B[BB)V",
            garbageValue = "8"
    )
    static final void Widget_setKey(Widget var0, int var1, byte[] var2, byte[] var3) {
      if (var0.field2937 == null) {
         if (var2 == null) {
            return;
         }

         var0.field2937 = new byte[11][];
         var0.field2938 = new byte[11][];
         var0.field2939 = new int[11];
         var0.field2940 = new int[11];
      }

      var0.field2937[var1] = var2;
      if (var2 != null) {
         var0.field2936 = true;
      } else {
         var0.field2936 = false;

         for(int var4 = 0; var4 < var0.field2937.length; ++var4) {
            if (var0.field2937[var4] != null) {
               var0.field2936 = true;
               break;
            }
         }
      }

      var0.field2938[var1] = var3;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "-1223653382"
   )
   public static void method411() {
      SequenceDefinition.SequenceDefinition_cached.clear();
      SequenceDefinition.SequenceDefinition_cachedFrames.clear();
      SequenceDefinition.SequenceDefinition_cachedModel.clear();
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      descriptor = "(Lfg;III)Lak;",
      garbageValue = "-613295096"
   )
   public static final PcmPlayer method407(TaskHandler var0, int var1, int var2) {
      if (class284.field2683 == 0) {
         throw new IllegalStateException();
      } else if (var1 >= 0 && var1 < 2) {
         if (var2 < 256) {
            var2 = 256;
         }

         try {
            PcmPlayer var3 = class157.pcmPlayerProvider.player();
            var3.samples = new int[256 * (PcmPlayer.PcmPlayer_stereo ? 2 : 1)];
            var3.field204 = var2;
            var3.init();
            var3.capacity = (var2 & -1024) + 1024;
            if (var3.capacity > 16384) {
               var3.capacity = 16384;
            }

            var3.open(var3.capacity);
            if (WorldMapCacheName.field2393 > 0 && class266.soundSystem == null) {
               class266.soundSystem = new SoundSystem();
               PcmPlayer.soundSystemExecutor = Executors.newScheduledThreadPool(1);
               PcmPlayer.soundSystemExecutor.scheduleAtFixedRate(class266.soundSystem, 0L, 10L, TimeUnit.MILLISECONDS);
            }

            if (class266.soundSystem != null) {
               if (class266.soundSystem.players[var1] != null) {
                  throw new IllegalArgumentException();
               }

               class266.soundSystem.players[var1] = var3;
            }

            return var3;
         } catch (Throwable var4) {
            return new PcmPlayer();
         }
      } else {
         throw new IllegalArgumentException();
      }
   }
}
