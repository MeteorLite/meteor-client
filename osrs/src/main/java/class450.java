import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("qv")
class class450 implements Iterator {
   @ObfuscatedName("h")
   int field4861;
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
      return this.field4861 < this.this$0.method7870();
   }

   @ObfuscatedName("remove")
   public void remove() {
      throw new UnsupportedOperationException();
   }

   @ObfuscatedName("next")
   public Object next() {
      int var1 = ++this.field4861 - 1;
      class416 var2 = (class416)this.this$0.field4864.get((long)var1);
      return var2 != null ? var2 : this.this$0.method8352(var1);
   }
}
