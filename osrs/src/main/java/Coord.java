import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ko")
@Implements("Coord")
public class Coord {
    @ObfuscatedName("f")
    public int plane;
    @ObfuscatedName("w")
    public int x;
    @ObfuscatedName("v")
    public int y;

   @ObfuscatedSignature(
      descriptor = "(Lko;)V"
   )
   public Coord(Coord var1) {
      this.plane = var1.plane;
      this.x = var1.x;
      this.y = var1.y;
   }

   public Coord(int var1, int var2, int var3) {
      this.plane = var1;
      this.x = var2;
      this.y = var3;
   }

   public Coord(int var1) {
      if (var1 == -1) {
         this.plane = -1;
      } else {
         this.plane = var1 >> 28 & 3;
         this.x = var1 >> 14 & 16383;
         this.y = var1 & 16383;
      }

   }

    @ObfuscatedName("f")
    @ObfuscatedSignature(
            descriptor = "(I)I",
            garbageValue = "-198351367"
    )
    public int packed() {
      return class237.method1315(this.plane, this.x, this.y);
   }

    @ObfuscatedName("v")
    @ObfuscatedSignature(
            descriptor = "(Lko;B)Z",
            garbageValue = "-96"
    )
    boolean equalsCoord(Coord var1) {
      if (this.plane != var1.plane) {
         return false;
      } else if (this.x != var1.x) {
         return false;
      } else {
         return this.y == var1.y;
      }
   }

    @ObfuscatedName("s")
    @ObfuscatedSignature(
            descriptor = "(Ljava/lang/String;B)Ljava/lang/String;",
            garbageValue = "-50"
    )
    String toString(String var1) {
      return this.plane + var1 + (this.x >> 6) + var1 + (this.y >> 6) + var1 + (this.x & 63) + var1 + (this.y & 63);
   }

    @ObfuscatedName("equals")
    public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else {
         return !(var1 instanceof Coord) ? false : this.equalsCoord((Coord)var1);
      }
   }

    @ObfuscatedName("hashCode")
    public int hashCode() {
      return this.packed();
   }

    @ObfuscatedName("toString")
    public String toString() {
      return this.toString(",");
   }
}
