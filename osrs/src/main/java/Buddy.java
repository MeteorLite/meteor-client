import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("pb")
@Implements("Buddy")
public class Buddy extends User {
    @ObfuscatedName("au")
    public int world = -1;
    @ObfuscatedName("ab")
    public int int2;
    @ObfuscatedName("aq")
    public int rank;

    @ObfuscatedName("bf")
    @ObfuscatedSignature(
            descriptor = "(III)V",
            garbageValue = "1994082485"
    )
    void set(int var1, int var2) {
      this.world = var1;
      this.int2 = var2;
   }

    @ObfuscatedName("bq")
    @ObfuscatedSignature(
            descriptor = "(I)I",
            garbageValue = "-199616481"
    )
    public int getWorld() {
      return this.world;
   }

    @ObfuscatedName("ba")
    @ObfuscatedSignature(
            descriptor = "(I)Z",
            garbageValue = "-1103584997"
    )
    public boolean hasWorld() {
      return this.world > 0;
   }
}
