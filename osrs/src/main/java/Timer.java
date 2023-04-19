import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("or")
@Implements("Timer")
public class Timer {
   @ObfuscatedName("af")
   long field3672 = -1L;
   @ObfuscatedName("an")
   long field3671 = -1L;
   @ObfuscatedName("aw")
   public boolean field3670 = false;
   @ObfuscatedName("ac")
   long field3673 = 0L;
   @ObfuscatedName("au")
   long field3674 = 0L;
   @ObfuscatedName("ab")
   long field3675 = 0L;
   @ObfuscatedName("aq")
   int field3676 = 0;
   @ObfuscatedName("al")
   int field3677 = 0;
   @ObfuscatedName("at")
   int field3678 = 0;
   @ObfuscatedName("aa")
   int field3679 = 0;

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "-1033751982"
   )
   public void method2095() {
      this.field3672 = class96.clockNow();
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "-1996100766"
   )
   public void method2101() {
      if (this.field3672 != -1L) {
         this.field3674 = class96.clockNow() - this.field3672;
         this.field3672 = -1L;
      }

   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      descriptor = "(IB)V",
      garbageValue = "13"
   )
   public void method2096(int var1) {
      this.field3671 = class96.clockNow();
      this.field3676 = var1;
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "1585437622"
   )
   public void method2097() {
      if (-1L != this.field3671) {
         this.field3673 = class96.clockNow() - this.field3671;
         this.field3671 = -1L;
      }

      ++this.field3678;
      this.field3670 = true;
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "-90"
   )
   public void method2098() {
      this.field3670 = false;
      this.field3677 = 0;
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "2129657232"
   )
   public void method2099() {
      this.method2097();
   }

    @ObfuscatedName("aq")
    @ObfuscatedSignature(
            descriptor = "(Lsg;I)V",
            garbageValue = "-1606158047"
    )
    public void write(Buffer var1) {
      long var2 = this.field3674;
      var2 /= 10L;
      if (var2 < 0L) {
         var2 = 0L;
      } else if (var2 > 65535L) {
         var2 = 65535L;
      }

      var1.writeShort((int)var2);
      long var4 = this.field3673;
      var4 /= 10L;
      if (var4 < 0L) {
         var4 = 0L;
      } else if (var4 > 65535L) {
         var4 = 65535L;
      }

      var1.writeShort((int)var4);
      long var6 = this.field3675;
      var6 /= 10L;
      if (var6 < 0L) {
         var6 = 0L;
      } else if (var6 > 65535L) {
         var6 = 65535L;
      }

      var1.writeShort((int)var6);
      var1.writeShort(this.field3676);
      var1.writeShort(this.field3677);
      var1.writeShort(this.field3678);
      var1.writeShort(this.field3679);
   }
}
