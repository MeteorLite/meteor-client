import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fo")
@Implements("MilliClock")
public class MilliClock extends Clock {
   @ObfuscatedName("f")
   long[] field1449 = new long[10];
   @ObfuscatedName("w")
   int field1450 = 256;
   @ObfuscatedName("v")
   int field1454 = 1;
   @ObfuscatedName("s")
   long field1451 = class153.clockNow();
   @ObfuscatedName("z")
   int field1452 = 0;
   @ObfuscatedName("j")
   int field1453;

   MilliClock() {
      for(int var1 = 0; var1 < 10; ++var1) {
         this.field1449[var1] = this.field1451;
      }

   }

    @ObfuscatedName("f")
    @ObfuscatedSignature(
            descriptor = "(I)V",
            garbageValue = "-1619845116"
    )
    public void mark() {
      for(int var1 = 0; var1 < 10; ++var1) {
         this.field1449[var1] = 0L;
      }

   }

    @ObfuscatedName("w")
    @ObfuscatedSignature(
            descriptor = "(III)I",
            garbageValue = "1661663667"
    )
    public int wait(int var1, int var2) {
      int var3 = this.field1450;
      int var4 = this.field1454;
      this.field1450 = 300;
      this.field1454 = 1;
      this.field1451 = class153.clockNow();
      if (0L == this.field1449[this.field1453]) {
         this.field1450 = var3;
         this.field1454 = var4;
      } else if (this.field1451 > this.field1449[this.field1453]) {
         this.field1450 = (int)((long)(var1 * 2560) / (this.field1451 - this.field1449[this.field1453]));
      }

      if (this.field1450 < 25) {
         this.field1450 = 25;
      }

      if (this.field1450 > 256) {
         this.field1450 = 256;
         this.field1454 = (int)((long)var1 - (this.field1451 - this.field1449[this.field1453]) / 10L);
      }

      if (this.field1454 > var1) {
         this.field1454 = var1;
      }

      this.field1449[this.field1453] = this.field1451;
      this.field1453 = (this.field1453 + 1) % 10;
      int var5;
      if (this.field1454 > 1) {
         for(var5 = 0; var5 < 10; ++var5) {
            if (0L != this.field1449[var5]) {
               this.field1449[var5] += (long)this.field1454;
            }
         }
      }

      if (this.field1454 < var2) {
         this.field1454 = var2;
      }

      Clock.method911((long)this.field1454);

      for(var5 = 0; this.field1452 < 256; this.field1452 += this.field1450) {
         ++var5;
      }

      this.field1452 &= 255;
      return var5;
   }
}
