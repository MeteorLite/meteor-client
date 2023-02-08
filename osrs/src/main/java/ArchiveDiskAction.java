import java.util.Date;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lx")
@Implements("ArchiveDiskAction")
public class ArchiveDiskAction extends Node {
    @ObfuscatedName("f")
    int type;
    @ObfuscatedName("w")
    byte[] data;
    @ObfuscatedName("v")
    @ObfuscatedSignature(
            descriptor = "Loi;"
    )
    ArchiveDisk archiveDisk;
    @ObfuscatedName("s")
    @ObfuscatedSignature(
            descriptor = "Llm;"
    )
    Archive archive;

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      descriptor = "(Ljava/util/Date;I)Z",
      garbageValue = "814020204"
   )
   static boolean method1791(Date var0) {
      Date var1 = StudioGame.method1786();
      return var0.after(var1);
   }
}
