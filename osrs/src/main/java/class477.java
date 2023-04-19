import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("sf")
final class class477 implements class474 {
   @ObfuscatedName("kt")
   @ObfuscatedSignature(
      descriptor = "[Ltq;"
   )
   @Export("mapDotSprites")
   static SpritePixels[] mapDotSprites;

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/Object;Lsg;I)V",
      garbageValue = "-1451264347"
   )
   @Export("vmethod8274")
   public void vmethod8274(Object var1, Buffer var2) {
      this.method2427((Long)var1, var2);
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "(Lsg;I)Ljava/lang/Object;",
      garbageValue = "-1690934499"
   )
   @Export("vmethod8273")
   public Object vmethod8273(Buffer var1) {
      return var1.readLong();
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/Long;Lsg;B)V",
      garbageValue = "0"
   )
   void method2427(Long var1, Buffer var2) {
      var2.writeLong(var1);
   }
}
