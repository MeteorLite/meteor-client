import java.io.File;
import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("in")
@Implements("Rasterizer3D")
public class Rasterizer3D {
    @ObfuscatedName("af")
    public static int[] Rasterizer3D_colorPalette = new int[65536];
   @ObfuscatedName("an")
   static int[] field1997 = new int[512];
   @ObfuscatedName("aw")
   static int[] field1993 = new int[2048];
    @ObfuscatedName("ac")
    public static int[] Rasterizer3D_sine = new int[2048];
    @ObfuscatedName("au")
    public static int[] Rasterizer3D_cosine = new int[2048];
   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "Ljg;"
   )
   public static Clips clips;
   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      descriptor = "Lii;"
   )
   static class220 field1999;
   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "Lii;"
   )
   static final class220 field1998;
   @ObfuscatedName("at")
   @ObfuscatedSignature(
      descriptor = "Lii;"
   )
   static final class220 field1992;
   @ObfuscatedName("ai")
   static int field2000;

   static {
      int var0;
      for(var0 = 1; var0 < 512; ++var0) {
         field1997[var0] = '耀' / var0;
      }

      for(var0 = 1; var0 < 2048; ++var0) {
         field1993[var0] = 65536 / var0;
      }

      for(var0 = 0; var0 < 2048; ++var0) {
         Rasterizer3D_sine[var0] = (int)(65536.0D * Math.sin(0.0030679615D * (double)var0));
         Rasterizer3D_cosine[var0] = (int)(65536.0D * Math.cos(0.0030679615D * (double)var0));
      }

      clips = new Clips();
      field1998 = new class235(clips);
      field1992 = new class237(clips);
      field1999 = field1998;
   }

    @ObfuscatedName("an")
    @ObfuscatedSignature(
            descriptor = "(Ljava/lang/String;Ljava/lang/String;ZB)Lsy;",
            garbageValue = "-55"
    )
    public static AccessFile getPreferencesFile(String var0, String var1, boolean var2) {
      File var3 = new File(class335.cacheDir, "preferences" + var0 + ".dat");
      if (var3.exists()) {
         try {
            AccessFile var10 = new AccessFile(var3, "rw", 10000L);
            return var10;
         } catch (IOException var9) {
            ;
         }
      }

      String var4 = "";
      if (JagexCache.cacheGamebuild == 33) {
         var4 = "_rc";
      } else if (JagexCache.cacheGamebuild == 34) {
         var4 = "_wip";
      }

      File var5 = new File(HorizontalAlignment.userHomeDirectory, "jagex_" + var1 + "_preferences" + var0 + var4 + ".dat");
      AccessFile var6;
      if (!var2 && var5.exists()) {
         try {
            var6 = new AccessFile(var5, "rw", 10000L);
            return var6;
         } catch (IOException var8) {
            ;
         }
      }

      try {
         var6 = new AccessFile(var3, "rw", 10000L);
         return var6;
      } catch (IOException var7) {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      descriptor = "(ILch;ZI)I",
      garbageValue = "734419623"
   )
   static int method1216(int var0, Script var1, boolean var2) {
      Widget var3 = var2 ? SoundSystem.scriptDotWidget : class1.scriptActiveWidget;
      if (var0 == 1800) {
         Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class195.Widget_unpackTargetMask(KeyHandler.getWidgetFlags(var3));
         return 1;
      } else if (var0 != 1801) {
         if (var0 == 1802) {
            if (var3.dataText == null) {
               Interpreter.Interpreter_stringStack[++SecureRandomCallable.Interpreter_stringStackSize - 1] = "";
            } else {
               Interpreter.Interpreter_stringStack[++SecureRandomCallable.Interpreter_stringStackSize - 1] = var3.dataText;
            }

            return 1;
         } else {
            return 2;
         }
      } else {
         int var4 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
         --var4;
         if (var3.actions != null && var4 < var3.actions.length && var3.actions[var4] != null) {
            Interpreter.Interpreter_stringStack[++SecureRandomCallable.Interpreter_stringStackSize - 1] = var3.actions[var4];
         } else {
            Interpreter.Interpreter_stringStack[++SecureRandomCallable.Interpreter_stringStackSize - 1] = "";
         }

         return 1;
      }
   }
}
