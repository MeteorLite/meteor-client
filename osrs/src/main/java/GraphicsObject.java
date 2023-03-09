import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cq")
@Implements("GraphicsObject")
public class GraphicsObject extends Renderable {
   @ObfuscatedName("aj")
   @Export("id")
   int id;
   @ObfuscatedName("al")
   @Export("cycleStart")
   int cycleStart;
   @ObfuscatedName("ac")
   @Export("plane")
   int plane;
   @ObfuscatedName("ab")
   @Export("x")
   int x;
   @ObfuscatedName("an")
   @Export("y")
   int y;
   @ObfuscatedName("ao")
   @Export("z")
   int z;
   @ObfuscatedName("av")
   @ObfuscatedSignature(
      descriptor = "Lhx;"
   )
   @Export("sequenceDefinition")
   SequenceDefinition sequenceDefinition;
   @ObfuscatedName("aq")
   @Export("frame")
   int frame;
   @ObfuscatedName("ap")
   @Export("frameCycle")
   int frameCycle;
   @ObfuscatedName("ar")
   @Export("isFinished")
   boolean isFinished;

   GraphicsObject(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      this.frame = 0;
      this.frameCycle = 0;
      this.isFinished = false;
      this.id = var1;
      this.plane = var2;
      this.x = var3;
      this.y = var4;
      this.z = var5;
      this.cycleStart = var7 + var6;
      int var8 = DevicePcmPlayerProvider.SpotAnimationDefinition_get(this.id).sequence;
      if (var8 != -1) {
         this.isFinished = false;
         this.sequenceDefinition = Coord.SequenceDefinition_get(var8);
      } else {
         this.isFinished = true;
      }

   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "(II)V",
      garbageValue = "-1172204333"
   )
   @Export("advance")
   final void advance(int var1) {
      if (!this.isFinished) {
         this.frameCycle += var1;
         if (!this.sequenceDefinition.isCachedModelIdSet()) {
            while(this.frameCycle > this.sequenceDefinition.frameLengths[this.frame]) {
               this.frameCycle -= this.sequenceDefinition.frameLengths[this.frame];
               ++this.frame;
               if (this.frame >= this.sequenceDefinition.frameIds.length) {
                  this.isFinished = true;
                  break;
               }
            }
         } else {
            this.frame += var1;
            if (this.frame >= this.sequenceDefinition.method1066()) {
               this.isFinished = true;
            }
         }

      }
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "(I)Lix;",
      garbageValue = "-1998422213"
   )
   @Export("getModel")
   protected final Model getModel() {
      SpotAnimationDefinition var1 = DevicePcmPlayerProvider.SpotAnimationDefinition_get(this.id);
      Model var2;
      if (!this.isFinished) {
         var2 = var1.getModel(this.frame);
      } else {
         var2 = var1.getModel(-1);
      }

      return var2 == null ? null : var2;
   }

   public GraphicsObject() {
   }
}
