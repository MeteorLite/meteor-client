import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("jr")
@Implements("Wrapper")
public abstract class Wrapper extends DualNode {
    @ObfuscatedName("w")
    final int size;

   Wrapper(int var1) {
      this.size = var1;
   }

    @ObfuscatedName("f")
    abstract Object get();

    @ObfuscatedName("w")
    abstract boolean isSoft();
}
