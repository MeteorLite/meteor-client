import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hd")
@Implements("HorizontalAlignment")
public enum HorizontalAlignment implements class356 {
   @ObfuscatedName("af")
   @ObfuscatedSignature(
      descriptor = "Lhd;"
   )
   field1547(0, 0),
    @ObfuscatedName("an")
    @ObfuscatedSignature(
            descriptor = "Lhd;"
    )
    HorizontalAlignment_centered(2, 1),
   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      descriptor = "Lhd;"
   )
   field1549(1, 2);

    @ObfuscatedName("az")
    public static String userHomeDirectory;
    @ObfuscatedName("tt")
    @ObfuscatedSignature(
            descriptor = "Lbu;"
    )
    static PcmPlayer pcmPlayer1;
    @ObfuscatedName("ac")
    public final int value;
    @ObfuscatedName("au")
    final int id;

   HorizontalAlignment(int var3, int var4) {
      this.value = var3;
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

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      descriptor = "(ZZB)I",
      garbageValue = "-35"
   )
   public static int method1019(boolean var0, boolean var1) {
      byte var2 = 0;
      int var3 = var2 + NetCache.NetCache_pendingPriorityWritesCount + NetCache.NetCache_pendingPriorityResponsesCount;
      return var3;
   }
}
