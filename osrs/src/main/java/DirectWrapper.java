import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ji")
@Implements("DirectWrapper")
public class DirectWrapper extends Wrapper {
   @ObfuscatedName("h")
   Object obj;

   DirectWrapper(Object var1, int var2) {
      super(var2);
      this.obj = var1;
   }

   @ObfuscatedName("h")
   Object get() {
      return this.obj;
   }

   @ObfuscatedName("e")
   boolean isSoft() {
      return false;
   }
}
