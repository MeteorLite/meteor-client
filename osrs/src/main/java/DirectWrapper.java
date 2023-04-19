import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("kp")
@Implements("DirectWrapper")
public class DirectWrapper extends Wrapper {
    @ObfuscatedName("af")
    Object obj;

   DirectWrapper(Object var1, int var2) {
      super(var2);
      this.obj = var1;
   }

    @ObfuscatedName("af")
    Object get() {
      return this.obj;
   }

    @ObfuscatedName("an")
    boolean isSoft() {
      return false;
   }
}
