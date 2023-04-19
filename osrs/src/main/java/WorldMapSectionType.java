import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jb")
@Implements("WorldMapSectionType")
public enum WorldMapSectionType implements class356 {
    @ObfuscatedName("af")
    @ObfuscatedSignature(
            descriptor = "Ljb;"
    )
    WORLDMAPSECTIONTYPE0(1, (byte)0),
    @ObfuscatedName("an")
    @ObfuscatedSignature(
            descriptor = "Ljb;"
    )
    WORLDMAPSECTIONTYPE1(0, (byte)1),
    @ObfuscatedName("aw")
    @ObfuscatedSignature(
            descriptor = "Ljb;"
    )
    WORLDMAPSECTIONTYPE2(3, (byte)2),
    @ObfuscatedName("ac")
    @ObfuscatedSignature(
            descriptor = "Ljb;"
    )
    WORLDMAPSECTIONTYPE3(2, (byte)3);

    @ObfuscatedName("tj")
    @ObfuscatedSignature(
            descriptor = "Lcc;"
    )
    static Decimator decimator;
    @ObfuscatedName("aj")
    public static String formattedOperatingSystemName;
   @ObfuscatedName("ds")
   static boolean field2384;
    @ObfuscatedName("ky")
    static int cameraPitch;
   @ObfuscatedName("ow")
   static int field2385;
    @ObfuscatedName("au")
    final int type;
    @ObfuscatedName("ab")
    final byte id;

   WorldMapSectionType(int var3, byte var4) {
      this.type = var3;
      this.id = var4;
   }

    @ObfuscatedName("af")
    @ObfuscatedSignature(
            descriptor = "(I)I",
            garbageValue = "741942848"
    )
    public int rsOrdinal() {
      return this.id;
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      descriptor = "([BI)Ljava/lang/String;",
      garbageValue = "-1678329446"
   )
   public static String method1510(byte[] var0) {
      return class144.method826(var0, 0, var0.length);
   }

    @ObfuscatedName("an")
    @ObfuscatedSignature(
            descriptor = "(Ljava/lang/CharSequence;I)Z",
            garbageValue = "88944891"
    )
    public static boolean isNumber(CharSequence var0) {
      return UrlRequester.method671(var0, 10, true);
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      descriptor = "(CI)C",
      garbageValue = "-1200984421"
   )
   static char method1507(char var0) {
      return var0 != 181 && var0 != 402 ? Character.toTitleCase(var0) : var0;
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      descriptor = "(I)[Ljb;",
      garbageValue = "-1754346109"
   )
   static WorldMapSectionType[] method1508() {
      return new WorldMapSectionType[]{WORLDMAPSECTIONTYPE1, WORLDMAPSECTIONTYPE2, WORLDMAPSECTIONTYPE3, WORLDMAPSECTIONTYPE0};
   }
}
