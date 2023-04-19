import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jf")
@Implements("WorldMapIcon_1")
public class WorldMapIcon_1 extends AbstractWorldMapIcon {
    @ObfuscatedName("af")
    final int objectDefId;
    @ObfuscatedName("an")
    @ObfuscatedSignature(
            descriptor = "Ljr;"
    )
    final WorldMapRegion region;
    @ObfuscatedName("aw")
    int element;
    @ObfuscatedName("ac")
    @ObfuscatedSignature(
            descriptor = "Lku;"
    )
    WorldMapLabel label;
    @ObfuscatedName("au")
    int subWidth;
    @ObfuscatedName("ab")
    int subHeight;

   @ObfuscatedSignature(
      descriptor = "(Llb;Llb;ILjr;)V"
   )
   WorldMapIcon_1(Coord var1, Coord var2, int var3, WorldMapRegion var4) {
      super(var1, var2);
      this.objectDefId = var3;
      this.region = var4;
      this.init();
   }

    @ObfuscatedName("af")
    @ObfuscatedSignature(
            descriptor = "(I)V",
            garbageValue = "1844375559"
    )
    void init() {
      this.element = class144.getObjectDefinition(this.objectDefId).transform().mapIconId;
      this.label = this.region.createMapLabel(class354.WorldMapElement_get(this.element));
      WorldMapElement var1 = class354.WorldMapElement_get(this.getElement());
      SpritePixels var2 = var1.getSpriteBool(false);
      if (var2 != null) {
         this.subWidth = var2.subWidth;
         this.subHeight = var2.subHeight;
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
