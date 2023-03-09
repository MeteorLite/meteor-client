import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ch")
@Implements("ObjectSound")
public final class ObjectSound extends Node {
   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "Lnj;"
   )
   @Export("objectSounds")
   static NodeDeque objectSounds = new NodeDeque();
   @ObfuscatedName("al")
   @Export("plane")
   int plane;
   @ObfuscatedName("ac")
   @Export("x")
   int x;
   @ObfuscatedName("ab")
   @Export("y")
   int y;
   @ObfuscatedName("an")
   @Export("maxX")
   int maxX;
   @ObfuscatedName("ao")
   @Export("maxY")
   int maxY;
   @ObfuscatedName("av")
   int field672;
   @ObfuscatedName("aq")
   @Export("soundEffectId")
   int soundEffectId;
   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      descriptor = "Lbn;"
   )
   @Export("stream1")
   RawPcmStream stream1;
   @ObfuscatedName("ar")
   int field666;
   @ObfuscatedName("ak")
   int field668;
   @ObfuscatedName("ax")
   @Export("soundEffectIds")
   int[] soundEffectIds;
   @ObfuscatedName("as")
   int field678;
   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      descriptor = "Lbn;"
   )
   @Export("stream2")
   RawPcmStream stream2;
   @ObfuscatedName("am")
   @ObfuscatedSignature(
      descriptor = "Lhu;"
   )
   @Export("obj")
   ObjectComposition obj;

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "79523440"
   )
   @Export("set")
   void set() {
      int var1 = this.soundEffectId;
      ObjectComposition var2 = this.obj.transform();
      if (var2 != null) {
         this.soundEffectId = var2.ambientSoundId;
         this.field672 = var2.int7 * 128;
         this.field666 = var2.int5;
         this.field668 = var2.int6;
         this.soundEffectIds = var2.soundEffectIds;
      } else {
         this.soundEffectId = -1;
         this.field672 = 0;
         this.field666 = 0;
         this.field668 = 0;
         this.soundEffectIds = null;
      }

      if (var1 != this.soundEffectId && this.stream1 != null) {
         class323.pcmStreamMixer.removeSubStream(this.stream1);
         this.stream1 = null;
      }

   }
}
