import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("qg")
final class class457 implements class452 {
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/Object;Lqy;I)V",
      garbageValue = "-1165050397"
   )
   @Export("vmethod8274")
   public void vmethod8274(Object var1, Buffer var2) {
      this.method2307((String)var1, var2);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "(Lqy;I)Ljava/lang/Object;",
      garbageValue = "1911852841"
   )
   @Export("vmethod8273")
   public Object vmethod8273(Buffer var1) {
      return var1.readStringCp1252NullTerminated();
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;Lqy;B)V",
      garbageValue = "-8"
   )
   void method2307(String var1, Buffer var2) {
      var2.writeStringCp1252NullTerminated(var1);
   }
}
