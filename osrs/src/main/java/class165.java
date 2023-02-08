import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fd")
public class class165 extends class177 {
    @ObfuscatedName("hj")
    @ObfuscatedSignature(
            descriptor = "Lqq;"
    )
    static Fonts WorldMapElement_fonts;
   @ObfuscatedName("f")
   String field1411;
   // $FF: synthetic field
   @ObfuscatedSignature(
      descriptor = "Lfs;"
   )
   final class166 this$0;

   @ObfuscatedSignature(
      descriptor = "(Lfs;Ljava/lang/String;Ljava/lang/String;)V"
   )
   class165(class166 var1, String var2, String var3) {
      super(var1, var2);
      this.this$0 = var1;
      this.field1411 = var3;
   }

    @ObfuscatedName("f")
    @ObfuscatedSignature(
            descriptor = "(S)I",
            garbageValue = "1024"
    )
    public int vmethod3379() {
      return 1;
   }

    @ObfuscatedName("w")
    @ObfuscatedSignature(
            descriptor = "(I)Ljava/lang/String;",
            garbageValue = "1616244476"
    )
    public String vmethod3380() {
      return this.field1411;
   }

    @ObfuscatedName("gl")
    @ObfuscatedSignature(
            descriptor = "(Ljava/lang/String;ZI)V",
            garbageValue = "545013499"
    )
    static final void drawLoadingMessage(String var0, boolean var1) {
      if (Client.showLoadingMessages) {
         byte var2 = 4;
         int var3 = var2 + 6;
         int var4 = var2 + 6;
         int var5 = MenuAction.fontPlain12.lineWidth(var0, 250);
         int var6 = MenuAction.fontPlain12.lineCount(var0, 250) * 13;
         Rasterizer2D.Rasterizer2D_fillRectangle(var3 - var2, var4 - var2, var2 + var5 + var2, var6 + var2 + var2, 0);
         Rasterizer2D.Rasterizer2D_drawRectangle(var3 - var2, var4 - var2, var2 + var5 + var2, var2 + var2 + var6, 16777215);
         MenuAction.fontPlain12.drawLines(var0, var3, var4, var5, var6, 16777215, -1, 1, 1, 0);
         Language.method1878(var3 - var2, var4 - var2, var2 + var5 + var2, var2 + var6 + var2);
         if (var1) {
            KeyHandler.rasterProvider.drawFull(0, 0);
         } else {
            class7.method27(var3, var4, var5, var6);
         }

      }
   }
}
