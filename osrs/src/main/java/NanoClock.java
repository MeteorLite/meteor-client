import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gu")
@Implements("NanoClock")
public class NanoClock extends Clock {
    @ObfuscatedName("af")
    long lastTimeNano = System.nanoTime();

    @ObfuscatedName("af")
    @ObfuscatedSignature(
            descriptor = "(I)V",
            garbageValue = "-331366942"
    )
    public void mark() {
      this.lastTimeNano = System.nanoTime();
   }

    @ObfuscatedName("an")
    @ObfuscatedSignature(
            descriptor = "(III)I",
            garbageValue = "-1491982008"
    )
    public int wait(int var1, int var2) {
      long var3 = (long)var2 * 1000000L;
      long var5 = this.lastTimeNano - System.nanoTime();
      if (var5 < var3) {
         var5 = var3;
      }

      PlayerComposition.method1704(var5 / 1000000L);
      long var7 = System.nanoTime();

      int var9;
      for(var9 = 0; var9 < 10 && (var9 < 1 || this.lastTimeNano < var7); this.lastTimeNano += 1000000L * (long)var1) {
         ++var9;
      }

      if (this.lastTimeNano < var7) {
         this.lastTimeNano = var7;
      }

      return var9;
   }
}
