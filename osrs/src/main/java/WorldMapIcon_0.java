import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jt")
@Implements("WorldMapIcon_0")
public class WorldMapIcon_0 extends AbstractWorldMapIcon {
   @ObfuscatedName("ax")
   public static short[] field2359;
    @ObfuscatedName("af")
    final int element;
    @ObfuscatedName("an")
    @ObfuscatedSignature(
            descriptor = "Lku;"
    )
    final WorldMapLabel label;
    @ObfuscatedName("aw")
    final int subWidth;
    @ObfuscatedName("ac")
    final int subHeight;

   @ObfuscatedSignature(
      descriptor = "(Llb;Llb;ILku;)V"
   )
   WorldMapIcon_0(Coord var1, Coord var2, int var3, WorldMapLabel var4) {
      super(var1, var2);
      this.element = var3;
      this.label = var4;
      WorldMapElement var5 = class354.WorldMapElement_get(this.getElement());
      SpritePixels var6 = var5.getSpriteBool(false);
      if (var6 != null) {
         this.subWidth = var6.subWidth;
         this.subHeight = var6.subHeight;
      } else {
         this.subWidth = 0;
         this.subHeight = 0;
      }

   }

    @ObfuscatedName("an")
    @ObfuscatedSignature(
            descriptor = "(I)I",
            garbageValue = "-1645421540"
    )
    public int getElement() {
      return this.element;
   }

    @ObfuscatedName("aw")
    @ObfuscatedSignature(
            descriptor = "(I)Lku;",
            garbageValue = "-2043987595"
    )
    WorldMapLabel getLabel() {
      return this.label;
   }

    @ObfuscatedName("ac")
    @ObfuscatedSignature(
            descriptor = "(I)I",
            garbageValue = "-1623088499"
    )
    int getSubWidth() {
      return this.subWidth;
   }

    @ObfuscatedName("au")
    @ObfuscatedSignature(
            descriptor = "(I)I",
            garbageValue = "435365367"
    )
    int getSubHeight() {
      return this.subHeight;
   }
}
