import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("au")
public final class class4 {
   @ObfuscatedName("gq")
   static int field6;
    @ObfuscatedName("jf")
    static byte[][] regionLandArchives;

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      descriptor = "(I)[Lmi;",
      garbageValue = "-574756815"
   )
   static class330[] method7() {
      return new class330[]{class330.field3071, class330.field3072};
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      descriptor = "(Lnm;Lnm;Lnm;Lnm;I)V",
      garbageValue = "220568265"
   )
   public static void method10(AbstractArchive var0, AbstractArchive var1, AbstractArchive var2, AbstractArchive var3) {
      int var4 = 0;
      if (var0 != null) {
         UserComparator3.Widget_archive = var0;
         DynamicObject.field813 = var1;
         ScriptEvent.Widget_spritesArchive = var2;
         class146.Widget_fontsArchive = var3;
         var4 = UserComparator3.Widget_archive.getGroupCount();
      }

      VerticalAlignment.Widget_interfaceComponents = new Widget[var4][];
      class264.Widget_loadedInterfaces = new boolean[var4];
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "(I)Z",
      garbageValue = "-1773808953"
   )
   public static boolean method8() {
      return class297.musicPlayerStatus != 0 ? true : class475.midiPcmStream.isReady();
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "-518646489"
   )
   public static void method9() {
      KitDefinition.KitDefinition_cached.clear();
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      descriptor = "(Lmq;I)I",
      garbageValue = "-935305362"
   )
   static int method11(Widget var0) {
      if (var0.type != 11) {
         Interpreter.Interpreter_stringStack[SecureRandomCallable.Interpreter_stringStackSize - 1] = "";
         return 1;
      } else {
         String var1 = Interpreter.Interpreter_stringStack[--SecureRandomCallable.Interpreter_stringStackSize];
         Interpreter.Interpreter_stringStack[++SecureRandomCallable.Interpreter_stringStackSize - 1] = var0.method1809(var1);
         return 1;
      }
   }
}
