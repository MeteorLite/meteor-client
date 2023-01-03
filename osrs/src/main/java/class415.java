import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("or")
public abstract class class415 extends class262 implements class474 {
   @ObfuscatedName("tv")
   @Export("cameraLookAtSpeed")
   static int cameraLookAtSpeed;
   @ObfuscatedName("m")
   @Export("Interpreter_stringLocals")
   static String[] Interpreter_stringLocals;

   @ObfuscatedSignature(
      descriptor = "(Llw;Lmb;I)V"
   )
   protected class415(StudioGame var1, Language var2, int var3) {
      super(var1, var2, var3);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(II)Lpv;",
      garbageValue = "307947551"
   )
   @Export("vmethod8207")
   protected abstract class417 vmethod8207(int var1);

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "(B)I",
      garbageValue = "50"
   )
   public int method2156() {
      return super.field2415;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "(II)Ljava/lang/Object;",
      garbageValue = "816156929"
   )
   @Export("vmethod8697")
   public Object vmethod8697(int var1) {
      class417 var2 = this.vmethod8207(var1);
      return var2 != null && var2.method2165() ? var2.method2166() : null;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      descriptor = "(Lqy;I)Lrz;",
      garbageValue = "1659575774"
   )
   public class475 method2159(Buffer var1) {
      int var2 = var1.readUnsignedShort();
      class417 var3 = this.vmethod8207(var2);
      class475 var4 = new class475(var2);
      Class var5 = var3.field3791.field3971;
      if (var5 == Integer.class) {
         var4.field4048 = var1.readInt();
      } else if (var5 == Long.class) {
         var4.field4048 = var1.readLong();
      } else if (var5 == String.class) {
         var4.field4048 = var1.readStringCp1252NullCircumfixed();
      } else {
         if (!class470.class.isAssignableFrom(var5)) {
            throw new IllegalStateException();
         }

         try {
            class470 var6 = (class470)var5.newInstance();
            var6.method2421(var1);
            var4.field4048 = var6;
         } catch (InstantiationException var7) {
            ;
         } catch (IllegalAccessException var8) {
            ;
         }
      }

      return var4;
   }
}
