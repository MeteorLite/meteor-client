import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gq")
@Implements("MilliClock")
public class MilliClock extends Clock {
   @ObfuscatedName("aj")
   long[] field1437 = new long[10];
   @ObfuscatedName("al")
   int field1438 = 256;
   @ObfuscatedName("ac")
   int field1436 = 1;
   @ObfuscatedName("ab")
   long field1439 = WorldMapSection2.clockNow();
   @ObfuscatedName("an")
   int field1440 = 0;
   @ObfuscatedName("ao")
   int field1441;

   MilliClock() {
      for(int var1 = 0; var1 < 10; ++var1) {
         this.field1437[var1] = this.field1439;
      }

   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "1425086968"
   )
   @Export("mark")
   public void mark() {
      for(int var1 = 0; var1 < 10; ++var1) {
         this.field1437[var1] = 0L;
      }

   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "(III)I",
      garbageValue = "1465993621"
   )
   @Export("wait")
   public int wait(int var1, int var2) {
      int var3 = this.field1438;
      int var4 = this.field1436;
      this.field1438 = 300;
      this.field1436 = 1;
      this.field1439 = WorldMapSection2.clockNow();
      if (this.field1437[this.field1441] == 0L) {
         this.field1438 = var3;
         this.field1436 = var4;
      } else if (this.field1439 > this.field1437[this.field1441]) {
         this.field1438 = (int)((long)(var1 * 2560) / (this.field1439 - this.field1437[this.field1441]));
      }

      if (this.field1438 < 25) {
         this.field1438 = 25;
      }

      if (this.field1438 > 256) {
         this.field1438 = 256;
         this.field1436 = (int)((long)var1 - (this.field1439 - this.field1437[this.field1441]) / 10L);
      }

      if (this.field1436 > var1) {
         this.field1436 = var1;
      }

      this.field1437[this.field1441] = this.field1439;
      this.field1441 = (this.field1441 + 1) % 10;
      int var5;
      if (this.field1436 > 1) {
         for(var5 = 0; var5 < 10; ++var5) {
            if (0L != this.field1437[var5]) {
               this.field1437[var5] += (long)this.field1436;
            }
         }
      }

      if (this.field1436 < var2) {
         this.field1436 = var2;
      }

      Login.method429((long)this.field1436);

      for(var5 = 0; this.field1440 < 256; this.field1440 += this.field1438) {
         ++var5;
      }

      this.field1440 &= 255;
      return var5;
   }
}
