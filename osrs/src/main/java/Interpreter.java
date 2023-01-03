import java.util.ArrayList;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bq")
@Implements("Interpreter")
public class Interpreter {
   @ObfuscatedName("x")
   @Export("Interpreter_intLocals")
   static int[] Interpreter_intLocals;
   @ObfuscatedName("q")
   @Export("Interpreter_arrayLengths")
   static int[] Interpreter_arrayLengths = new int[5];
   @ObfuscatedName("f")
   @Export("Interpreter_arrays")
   static int[][] Interpreter_arrays = new int[5][5000];
   @ObfuscatedName("r")
   @Export("Interpreter_intStack")
   static int[] Interpreter_intStack = new int[1000];
   @ObfuscatedName("b")
   @Export("Interpreter_stringStack")
   static String[] Interpreter_stringStack = new String[1000];
   @ObfuscatedName("j")
   @Export("Interpreter_stringStackSize")
   static int Interpreter_stringStackSize;
   @ObfuscatedName("g")
   @Export("Interpreter_frameDepth")
   static int Interpreter_frameDepth = 0;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      descriptor = "[Lbl;"
   )
   @Export("Interpreter_frames")
   static ScriptFrame[] Interpreter_frames = new ScriptFrame[50];
   @ObfuscatedName("l")
   @Export("Interpreter_calendar")
   static java.util.Calendar Interpreter_calendar = java.util.Calendar.getInstance();
   @ObfuscatedName("t")
   @Export("Interpreter_MONTHS")
   static final String[] Interpreter_MONTHS = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
   @ObfuscatedName("p")
   static boolean field694 = false;
   @ObfuscatedName("d")
   static boolean field697 = false;
   @ObfuscatedName("y")
   static ArrayList field696 = new ArrayList();
   @ObfuscatedName("z")
   static int field700 = 0;
   @ObfuscatedName("ao")
   static final double field699 = Math.log(2.0D);

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(III)I",
      garbageValue = "-1706343111"
   )
   static int method419(int var0, int var1) {
      FloorOverlayDefinition var3 = (FloorOverlayDefinition)FloorOverlayDefinition.FloorOverlayDefinition_cached.get((long)var0);
      FloorOverlayDefinition var2;
      if (var3 != null) {
         var2 = var3;
      } else {
         byte[] var4 = FloorOverlayDefinition.FloorOverlayDefinition_archive.takeFile(4, var0);
         var3 = new FloorOverlayDefinition();
         if (var4 != null) {
            var3.decode(new Buffer(var4), var0);
         }

         var3.postDecode();
         FloorOverlayDefinition.FloorOverlayDefinition_cached.put(var3, (long)var0);
         var2 = var3;
      }

      if (var2 == null) {
         return var1;
      } else if (var2.secondaryRgb >= 0) {
         return var2.secondaryRgb | -16777216;
      } else if (var2.texture >= 0) {
         int var10 = MusicPatchPcmStream.method1599(Rasterizer3D.Rasterizer3D_textureLoader.getAverageTextureRGB(var2.texture), 96);
         return Rasterizer3D.Rasterizer3D_colorPalette[var10] | -16777216;
      } else if (var2.primaryRgb == 16711935) {
         return var1;
      } else {
         int var5 = var2.hue;
         int var6 = var2.saturation;
         int var7 = var2.lightness;
         if (var7 > 179) {
            var6 /= 2;
         }

         if (var7 > 192) {
            var6 /= 2;
         }

         if (var7 > 217) {
            var6 /= 2;
         }

         if (var7 > 243) {
            var6 /= 2;
         }

         int var8 = (var6 / 32 << 7) + var7 / 2 + (var5 / 4 << 10);
         int var9 = MusicPatchPcmStream.method1599(var8, 96);
         return Rasterizer3D.Rasterizer3D_colorPalette[var9] | -16777216;
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(Lkq;S)V",
      garbageValue = "750"
   )
   public static void method417(Huffman var0) {
      class308.huffman = var0;
   }

   @ObfuscatedName("kf")
   @ObfuscatedSignature(
      descriptor = "(IIIIII)V",
      garbageValue = "1417118672"
   )
   @Export("drawScrollBar")
   static final void drawScrollBar(int var0, int var1, int var2, int var3, int var4) {
      class89.scrollBarSprites[0].drawAt(var0, var1);
      class89.scrollBarSprites[1].drawAt(var0, var3 + var1 - 16);
      Rasterizer2D.Rasterizer2D_fillRectangle(var0, var1 + 16, 16, var3 - 32, Client.field564);
      int var5 = var3 * (var3 - 32) / var4;
      if (var5 < 8) {
         var5 = 8;
      }

      int var6 = (var3 - 32 - var5) * var2 / (var4 - var3);
      Rasterizer2D.Rasterizer2D_fillRectangle(var0, var6 + var1 + 16, 16, var5, Client.field496);
      Rasterizer2D.Rasterizer2D_drawVerticalLine(var0, var6 + var1 + 16, var5, Client.field429);
      Rasterizer2D.Rasterizer2D_drawVerticalLine(var0 + 1, var6 + var1 + 16, var5, Client.field429);
      Rasterizer2D.Rasterizer2D_drawHorizontalLine(var0, var6 + var1 + 16, 16, Client.field429);
      Rasterizer2D.Rasterizer2D_drawHorizontalLine(var0, var6 + var1 + 17, 16, Client.field429);
      Rasterizer2D.Rasterizer2D_drawVerticalLine(var0 + 15, var6 + var1 + 16, var5, Client.field377);
      Rasterizer2D.Rasterizer2D_drawVerticalLine(var0 + 14, var6 + var1 + 17, var5 - 1, Client.field377);
      Rasterizer2D.Rasterizer2D_drawHorizontalLine(var0, var6 + var5 + var1 + 15, 16, Client.field377);
      Rasterizer2D.Rasterizer2D_drawHorizontalLine(var0 + 1, var6 + var5 + var1 + 14, 15, Client.field377);
   }
}
