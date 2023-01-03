import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ob")
public class class414 implements class419 {
   @ObfuscatedName("m")
   public static int[] SpriteBuffer_yOffsets;
   @ObfuscatedName("jb")
   static int cameraY;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "Lqn;"
   )
   public final class444 field3788;

   @ObfuscatedSignature(
      descriptor = "(Lqc;)V"
   )
   class414(class445 var1) {
      this.field3788 = var1;
   }

   @ObfuscatedSignature(
      descriptor = "(Lor;)V"
   )
   public class414(class415 var1) {
      this(new class445(var1));
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(IB)I",
      garbageValue = "-99"
   )
   public int method2155(int var1) {
      return this.field3788.vmethod8144(var1);
   }
}
