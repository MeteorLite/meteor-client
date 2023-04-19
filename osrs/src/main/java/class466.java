import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ry")
public class class466 implements class465 {
   @ObfuscatedName("af")
   Map field3989;
   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "Lts;"
   )
   final class496 field3988;

   @ObfuscatedSignature(
      descriptor = "(Lts;)V"
   )
   public class466(class496 var1) {
      this.field3988 = var1;
   }

    @ObfuscatedName("af")
    @ObfuscatedSignature(
            descriptor = "(IB)I",
            garbageValue = "91"
    )
    public int vmethod8144(int var1) {
      if (this.field3989 != null) {
         class497 var2 = (class497)this.field3989.get(var1);
         if (var2 != null) {
            return (Integer)var2.field4104;
         }
      }

      return (Integer)this.field3988.vmethod8697(var1);
   }

    @ObfuscatedName("an")
    @ObfuscatedSignature(
            descriptor = "(ILjava/lang/Object;I)V",
            garbageValue = "606161244"
    )
    public void vmethod8143(int var1, Object var2) {
      if (this.field3989 == null) {
         this.field3989 = new HashMap();
         this.field3989.put(var1, new class497(var1, var2));
      } else {
         class497 var3 = (class497)this.field3989.get(var1);
         if (var3 == null) {
            this.field3989.put(var1, new class497(var1, var2));
         } else {
            var3.field4104 = var2;
         }
      }

   }

    @ObfuscatedName("iterator")
    public Iterator iterator() {
      return this.field3989 == null ? Collections.emptyList().iterator() : this.field3989.values().iterator();
   }
}
