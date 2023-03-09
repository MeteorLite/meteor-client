import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eu")
public class class128 implements class352 {
   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "Leu;"
   )
   static final class128 field1225 = new class128(0, 0, (String)null, 0);
   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "Leu;"
   )
   static final class128 field1234 = new class128(1, 1, (String)null, 9);
   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "Leu;"
   )
   static final class128 field1226 = new class128(2, 2, (String)null, 3);
   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "Leu;"
   )
   static final class128 field1227 = new class128(3, 3, (String)null, 6);
   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "Leu;"
   )
   static final class128 field1228 = new class128(4, 4, (String)null, 1);
   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      descriptor = "Leu;"
   )
   static final class128 field1229 = new class128(5, 5, (String)null, 3);
   @ObfuscatedName("ax")
   public static short[] field1231;
   @ObfuscatedName("lk")
   static int field1233;
   @ObfuscatedName("av")
   final int field1230;
   @ObfuscatedName("aq")
   final int field1224;
   @ObfuscatedName("ap")
   final int field1232;

   class128(int var1, int var2, String var3, int var4) {
      this.field1230 = var1;
      this.field1224 = var2;
      this.field1232 = var4;
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "-1409646049"
   )
   @Export("rsOrdinal")
   public int rsOrdinal() {
      return this.field1224;
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "-1814624795"
   )
   int method707() {
      return this.field1232;
   }

   @ObfuscatedName("bm")
   @ObfuscatedSignature(
      descriptor = "(Lge;IIB)Lbd;",
      garbageValue = "25"
   )
   public static final PcmPlayer method709(TaskHandler var0, int var1, int var2) {
      if (PcmPlayer.field194 == 0) {
         throw new IllegalStateException();
      } else if (var1 >= 0 && var1 < 2) {
         if (var2 < 256) {
            var2 = 256;
         }

         try {
            PcmPlayer var3 = Script.pcmPlayerProvider.player();
            var3.samples = new int[(ChatChannel.PcmPlayer_stereo ? 2 : 1) * 256];
            var3.field189 = var2;
            var3.init();
            var3.capacity = (var2 & -1024) + 1024;
            if (var3.capacity > 16384) {
               var3.capacity = 16384;
            }

            var3.open(var3.capacity);
            if (TileItem.field1075 > 0 && class291.soundSystem == null) {
               class291.soundSystem = new SoundSystem();
               PcmPlayer.soundSystemExecutor = Executors.newScheduledThreadPool(1);
               PcmPlayer.soundSystemExecutor.scheduleAtFixedRate(class291.soundSystem, 0L, 10L, TimeUnit.MILLISECONDS);
            }

            if (class291.soundSystem != null) {
               if (class291.soundSystem.players[var1] != null) {
                  throw new IllegalArgumentException();
               }

               class291.soundSystem.players[var1] = var3;
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
