import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("qc")
public class class445 implements class444 {
   @ObfuscatedName("h")
   Map field3932;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "Lru;"
   )
   final class474 field3933;

   @ObfuscatedSignature(
      descriptor = "(Lru;)V"
   )
   public class445(class474 var1) {
      this.field3933 = var1;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(IB)I",
      garbageValue = "110"
   )
   public int vmethod8144(int var1) {
      if (this.field3932 != null) {
         class475 var2 = (class475)this.field3932.get(var1);
         if (var2 != null) {
            return (Integer)var2.field4048;
         }
      }

      return (Integer)this.field3933.vmethod8697(var1);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "(ILjava/lang/Object;I)V",
      garbageValue = "-1944779147"
   )
   public void vmethod8143(int var1, Object var2) {
      if (this.field3932 == null) {
         this.field3932 = new HashMap();
         this.field3932.put(var1, new class475(var1, var2));
      } else {
         class475 var3 = (class475)this.field3932.get(var1);
         if (var3 == null) {
            this.field3932.put(var1, new class475(var1, var2));
         } else {
            var3.field4048 = var2;
         }
      }

   }

   @ObfuscatedName("iterator")
   public Iterator iterator() {
      return this.field3932 == null ? Collections.emptyList().iterator() : this.field3932.values().iterator();
   }
}
