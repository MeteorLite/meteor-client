import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("jc")
@Implements("DirectWrapper")
public class DirectWrapper extends Wrapper {
    @ObfuscatedName("f")
    Object obj;

   DirectWrapper(Object var1, int var2) {
      super(var2);
      this.obj = var1;
   }

    @ObfuscatedName("f")
    Object get() {
      return this.obj;
   }

    @ObfuscatedName("w")
    boolean isSoft() {
      return false;
   }
}
