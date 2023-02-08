import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fv")
public class class173 {
   @ObfuscatedName("s")
   public String field1442;
   @ObfuscatedName("z")
   public float[] field1446;
   @ObfuscatedName("j")
   public int field1443;
   @ObfuscatedName("i")
   public int field1444;
   @ObfuscatedName("n")
   public int field1445;
   // $FF: synthetic field
   @ObfuscatedSignature(
           descriptor = "Lfs;"
   )
   @ObfuscatedName("this$0")
   final class166 this$0;

   @ObfuscatedSignature(
      descriptor = "(Lfs;)V"
   )
   class173(class166 var1) {
      this.this$0 = var1;
      this.field1446 = new float[4];
      this.field1443 = 1;
      this.field1444 = 1;
      this.field1445 = 0;
   }

    @ObfuscatedName("li")
    @ObfuscatedSignature(
            descriptor = "(Lkz;I)I",
            garbageValue = "-182721901"
    )
    static int getWidgetFlags(Widget var0) {
      IntegerNode var1 = (IntegerNode)Client.widgetFlags.get((long)var0.childIndex + ((long)var0.id << 32));
      return var1 != null ? var1.integer : var0.flags;
   }
}
