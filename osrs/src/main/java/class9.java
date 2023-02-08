import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("k")
public class class9 implements class349 {
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "Lk;"
   )
   public static final class9 field19 = new class9(0, "POST", true, true);
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      descriptor = "Lk;"
   )
   public static final class9 field20 = new class9(1, "GET", true, false);
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "Lk;"
   )
   static final class9 field21 = new class9(2, "PUT", false, true);
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      descriptor = "Lk;"
   )
   static final class9 field29 = new class9(3, "PATCH", false, true);
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      descriptor = "Lk;"
   )
   static final class9 field23 = new class9(4, "DELETE", false, true);
    @ObfuscatedName("u")
    public static byte[][][] ByteArrayPool_arrays;
    @ObfuscatedName("on")
    static int selectedSpellWidget;
    @ObfuscatedName("qa")
    @ObfuscatedSignature(
            descriptor = "Ldw;"
    )
    static Varcs varcs;
   @ObfuscatedName("j")
   int field24;
   @ObfuscatedName("i")
   String field25;
   @ObfuscatedName("n")
   boolean field26;
   @ObfuscatedName("l")
   boolean field27;

   class9(int var1, String var2, boolean var3, boolean var4) {
      this.field24 = var1;
      this.field25 = var2;
      this.field26 = var3;
      this.field27 = var4;
   }

    @ObfuscatedName("f")
    @ObfuscatedSignature(
            descriptor = "(B)I",
            garbageValue = "3"
    )
    public int rsOrdinal() {
      return this.field24;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "(B)Z",
      garbageValue = "119"
   )
   boolean method35() {
      return this.field26;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      descriptor = "(B)Ljava/lang/String;",
      garbageValue = "-39"
   )
   public String method31() {
      return this.field25;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      descriptor = "(B)Z",
      garbageValue = "-16"
   )
   boolean method34() {
      return this.field27;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "(Lln;B)V",
      garbageValue = "0"
   )
   public static void method32(AbstractArchive var0) {
      DevicePcmPlayerProvider.VarbitDefinition_archive = var0;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "-38"
   )
   public static void method36() {
      MouseHandler var0 = MouseHandler.MouseHandler_instance;
      synchronized(MouseHandler.MouseHandler_instance) {
         MouseHandler.MouseHandler_currentButton = MouseHandler.MouseHandler_currentButtonVolatile;
         MouseHandler.MouseHandler_x = MouseHandler.MouseHandler_xVolatile;
         MouseHandler.MouseHandler_y = MouseHandler.MouseHandler_yVolatile;
         MouseHandler.MouseHandler_millis = MouseHandler.MouseHandler_lastMovedVolatile;
         MouseHandler.MouseHandler_lastButton = MouseHandler.MouseHandler_lastButtonVolatile;
         MouseHandler.MouseHandler_lastPressedX = MouseHandler.MouseHandler_lastPressedXVolatile;
         MouseHandler.MouseHandler_lastPressedY = MouseHandler.MouseHandler_lastPressedYVolatile;
         MouseHandler.MouseHandler_lastPressedTimeMillis = MouseHandler.MouseHandler_lastPressedTimeMillisVolatile;
         MouseHandler.MouseHandler_lastButtonVolatile = 0;
      }
   }
}
