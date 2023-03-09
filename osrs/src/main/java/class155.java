import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fx")
public class class155 extends class140 {
   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      descriptor = "[[Lmy;"
   )
   @Export("Widget_interfaceComponents")
   public static Widget[][] Widget_interfaceComponents;
   @ObfuscatedName("aj")
   long field1369;
   @ObfuscatedName("al")
   String field1371;
   @ObfuscatedName("ac")
   int field1370;
   // $FF: synthetic field
   @ObfuscatedSignature(
      descriptor = "Lfo;"
   )
   final class143 this$0;

   @ObfuscatedSignature(
      descriptor = "(Lfo;)V"
   )
   class155(class143 var1) {
      this.this$0 = var1;
      this.field1369 = -1L;
      this.field1371 = null;
      this.field1370 = 0;
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "(Lsy;I)V",
      garbageValue = "-1979280996"
   )
   @Export("vmethod3254")
   void vmethod3254(Buffer var1) {
      if (var1.readUnsignedByte() != 255) {
         --var1.offset;
         this.field1369 = var1.readLong();
      }

      this.field1371 = var1.readStringCp1252NullTerminatedOrNull();
      this.field1370 = var1.readUnsignedShort();
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "(Lfi;B)V",
      garbageValue = "29"
   )
   @Export("vmethod3248")
   void vmethod3248(ClanSettings var1) {
      var1.method793(this.field1369, this.field1371, this.field1370);
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "11"
   )
   public static void method825() {
      SpotAnimationDefinition.SpotAnimationDefinition_cached.clear();
      SpotAnimationDefinition.SpotAnimationDefinition_cachedModels.clear();
   }
}
