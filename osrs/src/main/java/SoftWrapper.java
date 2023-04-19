import java.lang.ref.SoftReference;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ky")
@Implements("SoftWrapper")
public class SoftWrapper extends Wrapper {
    @ObfuscatedName("af")
    SoftReference ref;

   SoftWrapper(Object var1, int var2) {
      super(var2);
      this.ref = new SoftReference(var1);
   }

    @ObfuscatedName("af")
    Object get() {
      return this.ref.get();
   }

    @ObfuscatedName("an")
    boolean isSoft() {
      return true;
   }
}
