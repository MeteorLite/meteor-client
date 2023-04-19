import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kg")
@Implements("AbstractWorldMapIcon")
public abstract class AbstractWorldMapIcon {
    @ObfuscatedName("aq")
    @ObfuscatedSignature(
            descriptor = "Llb;"
    )
    public final Coord coord2;
    @ObfuscatedName("al")
    @ObfuscatedSignature(
            descriptor = "Llb;"
    )
    public final Coord coord1;
    @ObfuscatedName("at")
    int screenX;
    @ObfuscatedName("aa")
    int screenY;

   @ObfuscatedSignature(
      descriptor = "(Llb;Llb;)V"
   )
   AbstractWorldMapIcon(Coord var1, Coord var2) {
      this.coord1 = var1;
      this.coord2 = var2;
   }

    @ObfuscatedName("an")
    @ObfuscatedSignature(
            descriptor = "(I)I",
            garbageValue = "-1645421540"
    )
    public abstract int getElement();

    @ObfuscatedName("aw")
    @ObfuscatedSignature(
            descriptor = "(I)Lku;",
            garbageValue = "-2043987595"
    )
    abstract WorldMapLabel getLabel();

    @ObfuscatedName("ac")
    @ObfuscatedSignature(
            descriptor = "(I)I",
            garbageValue = "-1623088499"
    )
    abstract int getSubWidth();

    @ObfuscatedName("au")
    @ObfuscatedSignature(
            descriptor = "(I)I",
            garbageValue = "435365367"
    )
    abstract int getSubHeight();

    @ObfuscatedName("am")
    @ObfuscatedSignature(
            descriptor = "(IIB)Z",
            garbageValue = "-65"
    )
    boolean fitsScreen(int var1, int var2) {
      if (this.elementFitsScreen(var1, var2)) {
         return true;
      } else {
         return this.labelFitsScreen(var1, var2);
      }
   }

    @ObfuscatedName("as")
    @ObfuscatedSignature(
            descriptor = "(I)Z",
            garbageValue = "1824088404"
    )
    boolean hasValidElement() {
      return this.getElement() >= 0;
   }

    @ObfuscatedName("aj")
    @ObfuscatedSignature(
            descriptor = "(III)Z",
            garbageValue = "2000208750"
    )
    boolean elementFitsScreen(int var1, int var2) {
      if (!this.hasValidElement()) {
         return false;
      } else {
         WorldMapElement var3 = class354.WorldMapElement_get(this.getElement());
         int var4 = this.getSubWidth();
         int var5 = this.getSubHeight();
         switch(var3.horizontalAlignment.value) {
         case 0:
            if (var1 > this.screenX - var4 && var1 <= this.screenX) {
               break;
            }

            return false;
         case 1:
            if (var1 >= this.screenX && var1 < var4 + this.screenX) {
               break;
            }

            return false;
         case 2:
            if (var1 < this.screenX - var4 / 2 || var1 > var4 / 2 + this.screenX) {
               return false;
            }
         }

         switch(var3.verticalAlignment.value) {
         case 0:
            if (var2 >= this.screenY && var2 < var5 + this.screenY) {
               break;
            }

            return false;
         case 1:
            if (var2 < this.screenY - var5 / 2 || var2 > var5 / 2 + this.screenY) {
               return false;
            }
            break;
         case 2:
            if (var2 <= this.screenY - var5 || var2 > this.screenY) {
               return false;
            }
         }

         return true;
      }
   }

    @ObfuscatedName("ak")
    @ObfuscatedSignature(
            descriptor = "(III)Z",
            garbageValue = "-1064122109"
    )
    boolean labelFitsScreen(int var1, int var2) {
      WorldMapLabel var3 = this.getLabel();
      if (var3 == null) {
         return false;
      } else if (var1 >= this.screenX - var3.width / 2 && var1 <= var3.width / 2 + this.screenX) {
         return var2 >= this.screenY && var2 <= this.screenY + var3.height;
      } else {
         return false;
      }
   }
}
