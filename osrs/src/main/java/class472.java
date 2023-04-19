import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("sn")
class class472 implements Iterator {
   @ObfuscatedName("af")
   int field4017;
   // $FF: synthetic field
   @ObfuscatedSignature(
           descriptor = "Lsu;"
   )
   @ObfuscatedName("this$0")
   final class473 this$0;

   @ObfuscatedSignature(
      descriptor = "(Lsu;)V"
   )
   class472(class473 var1) {
      this.this$0 = var1;
   }

    @ObfuscatedName("hasNext")
    public boolean hasNext() {
      return this.field4017 < this.this$0.method2274();
   }

    @ObfuscatedName("remove")
    public void remove() {
      throw new UnsupportedOperationException();
   }

    @ObfuscatedName("next")
    public Object next() {
      int var1 = ++this.field4017 - 1;
      class431 var2 = (class431)this.this$0.field4018.get((long)var1);
      return var2 != null ? var2 : this.this$0.method2420(var1);
   }
}
