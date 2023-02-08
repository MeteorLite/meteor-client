import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lf")
@Implements("WorldMapDecorationType")
public enum WorldMapDecorationType implements class349 {
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "Llf;"
   )
   field3038(0, 0),
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      descriptor = "Llf;"
   )
   field3035(1, 0),
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "Llf;"
   )
   field3031(2, 0),
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      descriptor = "Llf;"
   )
   field3032(3, 0),
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      descriptor = "Llf;"
   )
   field3037(9, 2),
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      descriptor = "Llf;"
   )
   field3034(4, 1),
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      descriptor = "Llf;"
   )
   field3030(5, 1),
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      descriptor = "Llf;"
   )
   field3036(6, 1),
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      descriptor = "Llf;"
   )
   field3043(7, 1),
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      descriptor = "Llf;"
   )
   field3033(8, 1),
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      descriptor = "Llf;"
   )
   field3042(12, 2),
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      descriptor = "Llf;"
   )
   field3040(13, 2),
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      descriptor = "Llf;"
   )
   field3041(14, 2),
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      descriptor = "Llf;"
   )
   field3039(15, 2),
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      descriptor = "Llf;"
   )
   field3046(16, 2),
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "Llf;"
   )
   field3044(17, 2),
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      descriptor = "Llf;"
   )
   field3045(18, 2),
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      descriptor = "Llf;"
   )
   field3029(19, 2),
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      descriptor = "Llf;"
   )
   field3047(20, 2),
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      descriptor = "Llf;"
   )
   field3048(21, 2),
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      descriptor = "Llf;"
   )
   field3049(10, 2),
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      descriptor = "Llf;"
   )
   field3050(11, 2),
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      descriptor = "Llf;"
   )
   field3051(22, 3);

    @ObfuscatedName("e")
    public final int id;

   @ObfuscatedSignature(
      descriptor = "(II)V",
      garbageValue = "0"
   )
   WorldMapDecorationType(int var3, int var4) {
      this.id = var3;
   }

    @ObfuscatedName("f")
    @ObfuscatedSignature(
            descriptor = "(B)I",
            garbageValue = "3"
    )
    public int rsOrdinal() {
      return this.id;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "91461371"
   )
   public static void method1777() {
      VarbitComposition.VarbitDefinition_cached.clear();
   }

    @ObfuscatedName("ek")
    @ObfuscatedSignature(
            descriptor = "(I)Lqf;",
            garbageValue = "1722547378"
    )
    static WorldMap getWorldMap() {
      return GrandExchangeOfferUnitPriceComparator.worldMap;
   }
}
