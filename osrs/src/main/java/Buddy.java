import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("oa")
@Implements("Buddy")
public class Buddy extends User {
    @ObfuscatedName("z")
    public int world = -1;
    @ObfuscatedName("j")
    public int int2;
    @ObfuscatedName("i")
    public int rank;

    @ObfuscatedName("ab")
    @ObfuscatedSignature(
            descriptor = "(III)V",
            garbageValue = "350597562"
    )
    void set(int var1, int var2) {
      this.world = var1;
      this.int2 = var2;
   }

    @ObfuscatedName("an")
    @ObfuscatedSignature(
            descriptor = "(B)I",
            garbageValue = "-56"
    )
    public int getWorld() {
      return this.world;
   }

    @ObfuscatedName("am")
    @ObfuscatedSignature(
            descriptor = "(I)Z",
            garbageValue = "1851366387"
    )
    public boolean hasWorld() {
      return this.world > 0;
   }
}
