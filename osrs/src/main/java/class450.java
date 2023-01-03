import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("qv")
class class450 implements Iterator {
   @ObfuscatedName("h")
   int field3961;
   // $FF: synthetic field
   @ObfuscatedSignature(
      descriptor = "Lqk;"
   )
   @ObfuscatedName("this$0")
   final class451 this$0;

   @ObfuscatedSignature(
      descriptor = "(Lqk;)V"
   )
   class450(class451 var1) {
      this.this$0 = var1;
   }

   @ObfuscatedName("hasNext")
   public boolean hasNext() {
      return this.field3961 < this.this$0.method2156();
   }

   @ObfuscatedName("remove")
   public void remove() {
      throw new UnsupportedOperationException();
   }

   @ObfuscatedName("next")
   public Object next() {
      int var1 = ++this.field3961 - 1;
      class416 var2 = (class416)this.this$0.field3964.get((long)var1);
      return var2 != null ? var2 : this.this$0.method2288(var1);
   }
}
