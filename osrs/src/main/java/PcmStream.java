import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bp")
@Implements("PcmStream")
public abstract class PcmStream extends Node {
   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      descriptor = "Lbp;"
   )
   @Export("after")
   PcmStream after;
   @ObfuscatedName("av")
   int field255;
   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      descriptor = "Lcu;"
   )
   @Export("sound")
   AbstractSound sound;
   @ObfuscatedName("am")
   @Export("active")
   volatile boolean active = true;

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "()Lbp;"
   )
   @Export("firstSubStream")
   protected abstract PcmStream firstSubStream();

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      descriptor = "()Lbp;"
   )
   @Export("nextSubStream")
   protected abstract PcmStream nextSubStream();

   @ObfuscatedName("al")
   @Export("vmethod5648")
   protected abstract int vmethod5648();

   @ObfuscatedName("at")
   @Export("fill")
   protected abstract void fill(int[] var1, int var2, int var3);

   @ObfuscatedName("ay")
   @Export("skip")
   protected abstract void skip(int var1);

   @ObfuscatedName("ba")
   @Export("vmethod1019")
   int vmethod1019() {
      return 255;
   }

   @ObfuscatedName("fz")
   @Export("update")
   final void update(int[] var1, int var2, int var3) {
      if (this.active) {
         this.fill(var1, var2, var3);
      } else {
         this.skip(var3);
      }

   }
}
