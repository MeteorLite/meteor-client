import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("pa")
@Implements("LongNode")
public class LongNode extends Node {
    @ObfuscatedName("f")
    public long longValue;

   public LongNode(long var1) {
      this.longValue = var1;
   }
}
