import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("si")
final class class479 implements class474 {
    @ObfuscatedName("af")
    @ObfuscatedSignature(
            descriptor = "(Ljava/lang/Object;Lsg;I)V",
            garbageValue = "-1451264347"
    )
    public void vmethod8274(Object var1, Buffer var2) {
      this.method2443((String)var1, var2);
   }

    @ObfuscatedName("an")
    @ObfuscatedSignature(
            descriptor = "(Lsg;I)Ljava/lang/Object;",
            garbageValue = "-1690934499"
    )
    public Object vmethod8273(Buffer var1) {
      return var1.readStringCp1252NullTerminated();
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;Lsg;B)V",
      garbageValue = "-97"
   )
   void method2443(String var1, Buffer var2) {
      var2.writeStringCp1252NullTerminated(var1);
   }
}
