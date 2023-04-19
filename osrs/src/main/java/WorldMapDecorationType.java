import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("mc")
@Implements("WorldMapDecorationType")
public enum WorldMapDecorationType implements class356 {
   @ObfuscatedName("af")
   @ObfuscatedSignature(
      descriptor = "Lmc;"
   )
   field3047(0, 0),
   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "Lmc;"
   )
   field3045(1, 0),
   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      descriptor = "Lmc;"
   )
   field3046(2, 0),
   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "Lmc;"
   )
   field3050(3, 0),
   @ObfuscatedName("au")
   @ObfuscatedSignature(
      descriptor = "Lmc;"
   )
   field3048(9, 2),
   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "Lmc;"
   )
   field3044(4, 1),
   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      descriptor = "Lmc;"
   )
   field3061(5, 1),
   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "Lmc;"
   )
   field3051(6, 1),
   @ObfuscatedName("at")
   @ObfuscatedSignature(
      descriptor = "Lmc;"
   )
   field3052(7, 1),
   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      descriptor = "Lmc;"
   )
   field3053(8, 1),
   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      descriptor = "Lmc;"
   )
   field3054(12, 2),
   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      descriptor = "Lmc;"
   )
   field3055(13, 2),
   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      descriptor = "Lmc;"
   )
   field3049(14, 2),
   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      descriptor = "Lmc;"
   )
   field3057(15, 2),
   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      descriptor = "Lmc;"
   )
   field3058(16, 2),
   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      descriptor = "Lmc;"
   )
   field3063(17, 2),
   @ObfuscatedName("av")
   @ObfuscatedSignature(
      descriptor = "Lmc;"
   )
   field3060(18, 2),
   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      descriptor = "Lmc;"
   )
   field3062(19, 2),
   @ObfuscatedName("am")
   @ObfuscatedSignature(
      descriptor = "Lmc;"
   )
   field3056(20, 2),
   @ObfuscatedName("as")
   @ObfuscatedSignature(
      descriptor = "Lmc;"
   )
   field3059(21, 2),
   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "Lmc;"
   )
   field3064(10, 2),
   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      descriptor = "Lmc;"
   )
   field3065(11, 2),
   @ObfuscatedName("az")
   @ObfuscatedSignature(
      descriptor = "Lmc;"
   )
   field3066(22, 3);

    @ObfuscatedName("ad")
    public final int id;

   @ObfuscatedSignature(
      descriptor = "(II)V",
      garbageValue = "0"
   )
   WorldMapDecorationType(int var3, int var4) {
      this.id = var3;
   }

    @ObfuscatedName("af")
    @ObfuscatedSignature(
            descriptor = "(I)I",
            garbageValue = "741942848"
    )
    public int rsOrdinal() {
      return this.id;
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/CharSequence;B)Ljava/lang/String;",
      garbageValue = "1"
   )
   public static String method1841(CharSequence var0) {
      return class14.method57('*', var0.length());
   }
}
