import java.net.MalformedURLException;
import java.net.URL;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ku")
public class class300 {
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "Ldm;"
   )
   UrlRequest field2806;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "Lrx;"
   )
   SpritePixels field2805;

   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;Ldl;)V"
   )
   class300(String var1, UrlRequester var2) {
      try {
         this.field2806 = var2.request(new URL(var1));
      } catch (MalformedURLException var4) {
         this.field2806 = null;
      }

   }

   @ObfuscatedSignature(
      descriptor = "(Ldm;)V"
   )
   class300(UrlRequest var1) {
      this.field2806 = var1;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(I)Lrx;",
      garbageValue = "-1221653843"
   )
   SpritePixels method1615() {
      if (this.field2805 == null && this.field2806 != null && this.field2806.isDone()) {
         if (this.field2806.getResponse() != null) {
            this.field2805 = Language.method1865(this.field2806.getResponse());
         }

         this.field2806 = null;
      }

      return this.field2805;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(IB)I",
      garbageValue = "-32"
   )
   public static int method1620(int var0) {
      return var0 >>> 12;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "(Lln;II)V",
      garbageValue = "1706135077"
   )
   static void method1618(Archive var0, int var1) {
      if (var0.field3445) {
         if (var1 <= NetCache.field3485) {
            throw new RuntimeException("");
         }

         if (var1 < NetCache.field3467) {
            NetCache.field3467 = var1;
         }
      } else {
         if (var1 >= NetCache.field3467) {
            throw new RuntimeException("");
         }

         if (var1 > NetCache.field3485) {
            NetCache.field3485 = var1;
         }
      }

      if (class169.field1440 != null) {
         class169.field1440.offset = var1 * 8 + 5;
         if (class169.field1440.offset >= class169.field1440.array.length) {
            if (!var0.field3445) {
               throw new RuntimeException("");
            }

            var0.method1785();
         } else {
            int var2 = class169.field1440.readInt();
            int var3 = class169.field1440.readInt();
            var0.loadIndex(var2, var3);
         }

      } else {
         VarpDefinition.requestNetFile((Archive)null, 255, 255, 0, (byte)0, true);
         NetCache.NetCache_archives[var1] = var0;
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "(Lqx;I)V",
      garbageValue = "-2117327604"
   )
   static final void method1616(PacketBuffer var0) {
      for(int var1 = 0; var1 < Players.Players_pendingUpdateCount; ++var1) {
         int var2 = Players.Players_pendingUpdateIndices[var1];
         Player var3 = Client.players[var2];
         int var4 = var0.readUnsignedByte();
         if ((var4 & 64) != 0) {
            var4 += var0.readUnsignedByte() << 8;
         }

         HorizontalAlignment.method950(var0, var2, var3, var4);
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      descriptor = "(Lkd;I)I",
      garbageValue = "1828008662"
   )
   static int method1619(Widget var0) {
      if (var0.type != 11) {
         --Interpreter.Interpreter_stringStackSize;
         Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = -1;
         return 1;
      } else {
         String var1 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
         Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = var0.method1728(var1);
         return 1;
      }
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "(ILbm;ZB)I",
      garbageValue = "7"
   )
   static int method1617(int var0, Script var1, boolean var2) {
      return 2;
   }
}
