import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("oy")
public class class389 {
   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "Loy;"
   )
   static final class389 field3633 = new class389("Basic");
   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "Loy;"
   )
   static final class389 field3631 = new class389("Bearer");
   @ObfuscatedName("ac")
   final String field3632;

   class389(String var1) {
      this.field3632 = var1;
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "(I)Ljava/lang/String;",
      garbageValue = "1567314137"
   )
   String method2046() {
      return this.field3632;
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "1824771862"
   )
   static int method2047() {
      return ++Messages.Messages_count - 1;
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "69"
   )
   static void method2048() {
      for(ObjectSound var0 = (ObjectSound)ObjectSound.objectSounds.last(); var0 != null; var0 = (ObjectSound)ObjectSound.objectSounds.previous()) {
         if (var0.stream1 != null) {
            class323.pcmStreamMixer.removeSubStream(var0.stream1);
            var0.stream1 = null;
         }

         if (var0.stream2 != null) {
            class323.pcmStreamMixer.removeSubStream(var0.stream2);
            var0.stream2 = null;
         }
      }

      ObjectSound.objectSounds.clear();
   }
}
