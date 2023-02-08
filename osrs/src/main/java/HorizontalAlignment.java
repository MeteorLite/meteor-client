import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gw")
@Implements("HorizontalAlignment")
public enum HorizontalAlignment implements class349 {
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "Lgw;"
   )
   field1542(0, 0),
    @ObfuscatedName("w")
    @ObfuscatedSignature(
            descriptor = "Lgw;"
    )
    HorizontalAlignment_centered(2, 1),
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "Lgw;"
   )
   field1539(1, 2);

   @ObfuscatedName("ed")
   static long field1543;
    @ObfuscatedName("s")
    public final int value;
    @ObfuscatedName("z")
    final int id;

   HorizontalAlignment(int var3, int var4) {
      this.value = var3;
      this.id = var4;
   }

    @ObfuscatedName("f")
    @ObfuscatedSignature(
            descriptor = "(B)I",
            garbageValue = "3"
    )
    public int rsOrdinal() {
      return this.id;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "-1953251596"
   )
   static void method951() {
      Tiles.Tiles_minPlane = 99;
      Tiles.Tiles_underlays = new short[4][104][104];
      class172.Tiles_overlays = new short[4][104][104];
      Tiles.Tiles_shapes = new byte[4][104][104];
      Tiles.field835 = new byte[4][104][104];
      class312.field3014 = new int[4][105][105];
      Tiles.field836 = new byte[4][105][105];
      class323.field3055 = new int[105][105];
      class100.Tiles_hue = new int[104];
      class161.Tiles_saturation = new int[104];
      Tiles.Tiles_lightness = new int[104];
      class463.Tiles_hueMultiplier = new int[104];
      SceneTilePaint.field2195 = new int[104];
   }

    @ObfuscatedName("gk")
    @ObfuscatedSignature(
            descriptor = "(S)V",
            garbageValue = "381"
    )
    static final void playPcmPlayers() {
      if (WorldMapSectionType.pcmPlayer1 != null) {
         WorldMapSectionType.pcmPlayer1.run();
      }

      if (SoundSystem.pcmPlayer0 != null) {
         SoundSystem.pcmPlayer0.run();
      }

   }
}
