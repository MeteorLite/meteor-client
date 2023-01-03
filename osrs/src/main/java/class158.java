import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fa")
public class class158 extends class136 {
   @ObfuscatedName("h")
   long field1397;
   @ObfuscatedName("e")
   String field1396;
   // $FF: synthetic field
   @ObfuscatedSignature(
      descriptor = "Lem;"
   )
   final class139 this$0;

   @ObfuscatedSignature(
      descriptor = "(Lem;)V"
   )
   class158(class139 var1) {
      this.this$0 = var1;
      this.field1397 = -1L;
      this.field1396 = null;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(Lqy;I)V",
      garbageValue = "1101327225"
   )
   @Export("vmethod3254")
   void vmethod3254(Buffer var1) {
      if (var1.readUnsignedByte() != 255) {
         --var1.offset;
         this.field1397 = var1.readLong();
      }

      this.field1396 = var1.readStringCp1252NullTerminatedOrNull();
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "(Lep;I)V",
      garbageValue = "839088249"
   )
   @Export("vmethod3248")
   void vmethod3248(ClanSettings var1) {
      var1.method785(this.field1397, this.field1396);
   }

   @ObfuscatedName("hr")
   @ObfuscatedSignature(
      descriptor = "(IIB)V",
      garbageValue = "120"
   )
   static final void method834(int var0, int var1) {
      if (var0 < 128) {
         var0 = 128;
      }

      if (var0 > 383) {
         var0 = 383;
      }

      if (class97.cameraPitch < var0) {
         class97.cameraPitch = (var0 - class97.cameraPitch) * LoginScreenAnimation.cameraLookAtAcceleration / 1000 + class97.cameraPitch + class415.cameraLookAtSpeed;
         if (class97.cameraPitch > var0) {
            class97.cameraPitch = var0;
         }
      }

      if (class97.cameraPitch > var0) {
         class97.cameraPitch -= (class97.cameraPitch - var0) * LoginScreenAnimation.cameraLookAtAcceleration / 1000 + class415.cameraLookAtSpeed;
         if (class97.cameraPitch < var0) {
            class97.cameraPitch = var0;
         }
      }

      int var2 = var1 - class128.cameraYaw;
      if (var2 > 1024) {
         var2 -= 2048;
      }

      if (var2 < -1024) {
         var2 += 2048;
      }

      if (var2 > 0) {
         class128.cameraYaw = class128.cameraYaw + class415.cameraLookAtSpeed + var2 * LoginScreenAnimation.cameraLookAtAcceleration / 1000;
         class128.cameraYaw &= 2047;
      }

      if (var2 < 0) {
         class128.cameraYaw -= -var2 * LoginScreenAnimation.cameraLookAtAcceleration / 1000 + class415.cameraLookAtSpeed;
         class128.cameraYaw &= 2047;
      }

      int var3 = var1 - class128.cameraYaw;
      if (var3 > 1024) {
         var3 -= 2048;
      }

      if (var3 < -1024) {
         var3 += 2048;
      }

      if (var3 < 0 && var2 > 0 || var3 > 0 && var2 < 0) {
         class128.cameraYaw = var1;
      }

   }
}
