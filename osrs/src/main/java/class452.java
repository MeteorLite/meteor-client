import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("qe")
public class class452 implements class451 {
   @ObfuscatedName("f")
   Map field3944;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      descriptor = "Lrc;"
   )
   final class481 field3943;

   @ObfuscatedSignature(
      descriptor = "(Lrc;)V"
   )
   public class452(class481 var1) {
      this.field3943 = var1;
   }

    @ObfuscatedName("f")
    @ObfuscatedSignature(
            descriptor = "(IB)I",
            garbageValue = "69"
    )
    public int vmethod8144(int var1) {
      if (this.field3944 != null) {
         class482 var2 = (class482)this.field3944.get(var1);
         if (var2 != null) {
            return (Integer)var2.field4060;
         }
      }

      return (Integer)this.field3943.vmethod8697(var1);
   }

    @ObfuscatedName("w")
    @ObfuscatedSignature(
            descriptor = "(ILjava/lang/Object;I)V",
            garbageValue = "-1706605993"
    )
    public void vmethod8143(int var1, Object var2) {
      if (this.field3944 == null) {
         this.field3944 = new HashMap();
         this.field3944.put(var1, new class482(var1, var2));
      } else {
         class482 var3 = (class482)this.field3944.get(var1);
         if (var3 == null) {
            this.field3944.put(var1, new class482(var1, var2));
         } else {
            var3.field4060 = var2;
         }
      }

   }

    @ObfuscatedName("iterator")
    public Iterator iterator() {
      return this.field3944 == null ? Collections.emptyList().iterator() : this.field3944.values().iterator();
   }
}
