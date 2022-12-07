import java.lang.ref.SoftReference;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("jt")
public class SoftWrapper extends Wrapper {
   @ObfuscatedName("h")
   SoftReference ref;

   SoftWrapper(Object var1, int var2) {
      super(var2);
      this.ref = new SoftReference(var1);
   }

   @ObfuscatedName("h")
   Object get() {
      return this.ref.get();
   }

   @ObfuscatedName("e")
   boolean isSoft() {
      return true;
   }
}
