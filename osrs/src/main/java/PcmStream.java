import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aa")
public abstract class PcmStream extends Node {
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      descriptor = "Laa;"
   )
   PcmStream after;
   @ObfuscatedName("a")
   int field383;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      descriptor = "Lbc;"
   )
   AbstractSound sound;
   @ObfuscatedName("l")
   volatile boolean active = true;

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      descriptor = "()Laa;"
   )
   protected abstract PcmStream firstSubStream();

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "()Laa;"
   )
   protected abstract PcmStream nextSubStream();

   @ObfuscatedName("r")
   protected abstract int vmethod5753();

   @ObfuscatedName("u")
   protected abstract void fill(int[] var1, int var2, int var3);

   @ObfuscatedName("j")
   protected abstract void skip(int var1);

   @ObfuscatedName("af")
   int vmethod1052() {
      return 255;
   }

   @ObfuscatedName("fb")
   final void update(int[] var1, int var2, int var3) {
      if (this.active) {
         this.fill(var1, var2, var3);
      } else {
         this.skip(var3);
      }

   }
}
