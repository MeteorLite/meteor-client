import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iz")
@Implements("WorldMapDecoration")
public class WorldMapDecoration {
   @ObfuscatedName("h")
   final int objectDefinitionId;
   @ObfuscatedName("e")
   final int decoration;
   @ObfuscatedName("v")
   final int rotation;

   WorldMapDecoration(int var1, int var2, int var3) {
      this.objectDefinitionId = var1;
      this.decoration = var2;
      this.rotation = var3;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(Lly;Lly;Lly;Lka;I)Z",
      garbageValue = "1603100581"
   )
   public static boolean method1442(AbstractArchive var0, AbstractArchive var1, AbstractArchive var2, MidiPcmStream var3) {
      class286.musicPatchesArchive = var0;
      class286.musicSamplesArchive = var1;
      class286.soundEffectsArchive = var2;
      class251.midiPcmStream = var3;
      return true;
   }
}
