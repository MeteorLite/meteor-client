import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fd")
@Implements("NanoClock")
public class NanoClock extends Clock {
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      longValue = -3571804006841329007L
   )
   @Export("lastTimeNano")
   long lastTimeNano = System.nanoTime();

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "118747683"
   )
   @Export("mark")
   public void mark() {
      this.lastTimeNano = System.nanoTime();
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "(III)I",
      garbageValue = "1532577739"
   )
   @Export("wait")
   public int wait(int var1, int var2) {
      long var3 = 1000000L * (long)var2;
      long var5 = this.lastTimeNano - System.nanoTime();
      if (var5 < var3) {
         var5 = var3;
      }

      class12.method157(var5 / 1000000L);
      long var7 = System.nanoTime();

      int var9;
      for(var9 = 0; var9 < 10 && (var9 < 1 || this.lastTimeNano < var7); this.lastTimeNano += (long)var1 * 1000000L) {
         ++var9;
      }

      if (this.lastTimeNano < var7) {
         this.lastTimeNano = var7;
      }

      return var9;
   }
}
