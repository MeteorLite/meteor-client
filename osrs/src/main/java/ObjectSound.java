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
    static NodeDeque objectSounds = new NodeDeque();
    @ObfuscatedName("jw")
    static byte[][] regionMapArchives;
    @ObfuscatedName("an")
    int plane;
    @ObfuscatedName("aw")
    int x;
    @ObfuscatedName("ac")
    int y;
    @ObfuscatedName("au")
    int maxX;
    @ObfuscatedName("ab")
    int maxY;
   @ObfuscatedName("aq")
   int field673;
    @ObfuscatedName("al")
    int soundEffectId;
    @ObfuscatedName("at")
    @ObfuscatedSignature(
            descriptor = "Lbl;"
    )
    RawPcmStream stream1;
   @ObfuscatedName("aa")
   int field681;
   @ObfuscatedName("ay")
   int field682;
    @ObfuscatedName("ao")
    int[] soundEffectIds;
   @ObfuscatedName("ax")
   int field679;
    @ObfuscatedName("ai")
    @ObfuscatedSignature(
            descriptor = "Lbl;"
    )
    RawPcmStream stream2;
    @ObfuscatedName("ag")
    @ObfuscatedSignature(
            descriptor = "Lhq;"
    )
    ObjectComposition obj;

    @ObfuscatedName("aw")
    @ObfuscatedSignature(
            descriptor = "(I)V",
            garbageValue = "27660078"
    )
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
