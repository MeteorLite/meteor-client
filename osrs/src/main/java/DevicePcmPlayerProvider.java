import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("d")
@Implements("DevicePcmPlayerProvider")
public class DevicePcmPlayerProvider implements class50 {
    @ObfuscatedName("f")
    @ObfuscatedSignature(
            descriptor = "Lln;"
    )
    static AbstractArchive VarbitDefinition_archive;

    @ObfuscatedName("f")
    @ObfuscatedSignature(
            descriptor = "(B)Lak;",
            garbageValue = "7"
    )
    public PcmPlayer player() {
      return new DevicePcmPlayer();
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "(Lln;I)V",
      garbageValue = "1456896340"
   )
   public static void method81(AbstractArchive var0) {
      DbTableType.field3990 = var0;
   }
}
