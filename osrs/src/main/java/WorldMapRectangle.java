import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ju")
@Implements("WorldMapRectangle")
public final class WorldMapRectangle {
   @ObfuscatedName("uh")
   static int field2405;
    @ObfuscatedName("af")
    int width;
    @ObfuscatedName("an")
    int height;
    @ObfuscatedName("aw")
    int x;
    @ObfuscatedName("ac")
    int y;
   // $FF: synthetic field
   @ObfuscatedSignature(
           descriptor = "Ljv;"
   )
   @ObfuscatedName("this$0")
   final WorldMapManager this$0;

   @ObfuscatedSignature(
      descriptor = "(Ljv;)V"
   )
   WorldMapRectangle(WorldMapManager var1) {
      this.this$0 = var1;
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "5766018"
   )
   static void method1522(String var0, String var1, String var2) {
      class129.method763(7);
      class205.setLoginResponseString(var0, var1, var2);
   }
}
