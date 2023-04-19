import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("qn")
public abstract class class430 extends class273 implements class496 {
   @ObfuscatedSignature(
      descriptor = "(Lmr;Lnx;I)V"
   )
   protected class430(StudioGame var1, Language var2, int var3) {
      super(var1, var2, var3);
   }

    @ObfuscatedName("af")
    @ObfuscatedSignature(
            descriptor = "(IB)Lqg;",
            garbageValue = "0"
    )
    protected abstract class432 vmethod8207(int var1);

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "-1861055046"
   )
   public int method2274() {
      return super.field2449;
   }

    @ObfuscatedName("aw")
    @ObfuscatedSignature(
            descriptor = "(IS)Ljava/lang/Object;",
            garbageValue = "-16285"
    )
    public Object vmethod8697(int var1) {
      class432 var2 = this.vmethod8207(var1);
      return var2 != null && var2.method2283() ? var2.method2284() : null;
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "(Lsg;I)Lte;",
      garbageValue = "2049638438"
   )
   public class497 method2275(Buffer var1) {
      int var2 = var1.readUnsignedShort();
      class432 var3 = this.vmethod8207(var2);
      class497 var4 = new class497(var2);
      Class var5 = var3.field3821.field4031;
      if (var5 == Integer.class) {
         var4.field4104 = var1.readInt();
      } else if (var5 == Long.class) {
         var4.field4104 = var1.readLong();
      } else if (var5 == String.class) {
         var4.field4104 = var1.readStringCp1252NullCircumfixed();
      } else {
         if (!class492.class.isAssignableFrom(var5)) {
            throw new IllegalStateException();
         }

         try {
            class492 var6 = (class492)var5.newInstance();
            var6.method2556(var1);
            var4.field4104 = var6;
         } catch (InstantiationException var7) {
            ;
         } catch (IllegalAccessException var8) {
            ;
         }
      }

      return var4;
   }
}
