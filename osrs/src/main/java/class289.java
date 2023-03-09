import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lg")
public final class class289 {
   @ObfuscatedName("aj")
   static long field2656;
   @ObfuscatedName("al")
   static long field2657;

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "(IS)V",
      garbageValue = "-30547"
   )
   public static void method1555(int var0) {
      if (var0 != -1) {
         if (class123.Widget_loadedInterfaces[var0]) {
            MouseRecorder.Widget_archive.clearFilesGroup(var0);
            if (class155.Widget_interfaceComponents[var0] != null) {
               for(int var1 = 0; var1 < class155.Widget_interfaceComponents[var0].length; ++var1) {
                  if (class155.Widget_interfaceComponents[var0][var1] != null) {
                     class155.Widget_interfaceComponents[var0][var1] = null;
                  }
               }

               class155.Widget_interfaceComponents[var0] = null;
               class123.Widget_loadedInterfaces[var0] = false;
            }
         }
      }
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "71128846"
   )
   static void method1554() {
      Iterator var0 = Messages.Messages_hashTable.iterator();

      while(var0.hasNext()) {
         Message var1 = (Message)var0.next();
         var1.clearIsFromFriend();
      }

   }
}
