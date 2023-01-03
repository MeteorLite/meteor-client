import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jk")
@Implements("WorldMapEvent")
public class WorldMapEvent {
   @ObfuscatedName("r")
   public static int[] SpriteBuffer_spritePalette;
   @ObfuscatedName("gb")
   static int[] field2413;
   @ObfuscatedName("h")
   public int mapElement;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "Lky;"
   )
   public Coord coord1;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "Lky;"
   )
   public Coord coord2;

   @ObfuscatedSignature(
      descriptor = "(ILky;Lky;)V"
   )
   public WorldMapEvent(int var1, Coord var2, Coord var3) {
      this.mapElement = var1;
      this.coord1 = var2;
      this.coord2 = var3;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(I)[Lcy;",
      garbageValue = "1028083236"
   )
   static class86[] method1490() {
      return new class86[]{class86.field865, class86.field863, class86.field870, class86.field866, class86.field862};
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      descriptor = "(IIII)I",
      garbageValue = "687315637"
   )
   public static int method1491(int var0, int var1, int var2) {
      int var3 = Actor.method516(var2 - var1 + 1);
      var3 <<= var1;
      var0 |= var3;
      return var0;
   }
}
