import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cr")
@Implements("ObjectSound")
public final class ObjectSound extends Node {
   @ObfuscatedName("af")
   @ObfuscatedSignature(
      descriptor = "Lnh;"
   )
   @Export("objectSounds")
   static NodeDeque objectSounds = new NodeDeque();
   @ObfuscatedName("jw")
   @Export("regionMapArchives")
   static byte[][] regionMapArchives;
   @ObfuscatedName("an")
   @Export("plane")
   int plane;
   @ObfuscatedName("aw")
   @Export("x")
   int x;
   @ObfuscatedName("ac")
   @Export("y")
   int y;
   @ObfuscatedName("au")
   @Export("maxX")
   int maxX;
   @ObfuscatedName("ab")
   @Export("maxY")
   int maxY;
   @ObfuscatedName("aq")
   int field673;
   @ObfuscatedName("al")
   @Export("soundEffectId")
   int soundEffectId;
   @ObfuscatedName("at")
   @ObfuscatedSignature(
      descriptor = "Lbl;"
   )
   @Export("stream1")
   RawPcmStream stream1;
   @ObfuscatedName("aa")
   int field681;
   @ObfuscatedName("ay")
   int field682;
   @ObfuscatedName("ao")
   @Export("soundEffectIds")
   int[] soundEffectIds;
   @ObfuscatedName("ax")
   int field679;
   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      descriptor = "Lbl;"
   )
   @Export("stream2")
   RawPcmStream stream2;
   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      descriptor = "Lhq;"
   )
   @Export("obj")
   ObjectComposition obj;

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "27660078"
   )
   @Export("set")
   void set() {
      int var1 = this.soundEffectId;
      ObjectComposition var2 = this.obj.transform();
      if (var2 != null) {
         this.soundEffectId = var2.ambientSoundId;
         this.field673 = var2.int7 * 128;
         this.field681 = var2.int5;
         this.field682 = var2.int6;
         this.soundEffectIds = var2.soundEffectIds;
      } else {
         this.soundEffectId = -1;
         this.field673 = 0;
         this.field681 = 0;
         this.field682 = 0;
         this.soundEffectIds = null;
      }

      if (var1 != this.soundEffectId && this.stream1 != null) {
         class130.pcmStreamMixer.removeSubStream(this.stream1);
         this.stream1 = null;
      }

   }
}
