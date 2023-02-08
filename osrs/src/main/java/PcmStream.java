import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("an")
@Implements("PcmStream")
public abstract class PcmStream extends Node {
    @ObfuscatedName("w")
    volatile boolean active = true;
    @ObfuscatedName("p")
    @ObfuscatedSignature(
            descriptor = "Lan;"
    )
    PcmStream after;
   @ObfuscatedName("o")
   int field256;
    @ObfuscatedName("u")
    @ObfuscatedSignature(
            descriptor = "Lbo;"
    )
    AbstractSound sound;

    @ObfuscatedName("j")
    @ObfuscatedSignature(
            descriptor = "()Lan;"
    )
    protected abstract PcmStream firstSubStream();

    @ObfuscatedName("i")
    @ObfuscatedSignature(
            descriptor = "()Lan;"
    )
    protected abstract PcmStream nextSubStream();

    @ObfuscatedName("n")
    protected abstract int vmethod5648();

    @ObfuscatedName("l")
    protected abstract void fill(int[] var1, int var2, int var3);

    @ObfuscatedName("c")
    protected abstract void skip(int var1);

    @ObfuscatedName("av")
    int vmethod1019() {
      return 255;
   }

    @ObfuscatedName("ec")
    final void update(int[] var1, int var2, int var3) {
      if (this.active) {
         this.fill(var1, var2, var3);
      } else {
         this.skip(var3);
      }

   }
}
