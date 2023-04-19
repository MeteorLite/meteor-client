import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("nw")
@Implements("ArchiveDiskAction")
public class ArchiveDiskAction extends Node {
    @ObfuscatedName("af")
    int type;
    @ObfuscatedName("an")
    public byte[] data;
    @ObfuscatedName("aw")
    @ObfuscatedSignature(
            descriptor = "Lqk;"
    )
    public ArchiveDisk archiveDisk;
    @ObfuscatedName("ac")
    @ObfuscatedSignature(
            descriptor = "Lnd;"
    )
    public Archive archive;

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      descriptor = "(I)[Ldt;",
      garbageValue = "-678147968"
   )
   static class86[] method1858() {
      return new class86[]{class86.field880, class86.field884, class86.field881, class86.field886, class86.field883, class86.field882};
   }

    @ObfuscatedName("ly")
    @ObfuscatedSignature(
            descriptor = "(IS)Ljava/lang/String;",
            garbageValue = "13178"
    )
    static final String formatItemStacks(int var0) {
      String var1 = Integer.toString(var0);

      for(int var2 = var1.length() - 3; var2 > 0; var2 -= 3) {
         var1 = var1.substring(0, var2) + "," + var1.substring(var2);
      }

      if (var1.length() > 9) {
         return " " + class383.colorStartTag(65408) + var1.substring(0, var1.length() - 8) + "M" + " " + " (" + var1 + ")" + "</col>";
      } else {
         return var1.length() > 6 ? " " + class383.colorStartTag(16777215) + var1.substring(0, var1.length() - 4) + "K" + " " + " (" + var1 + ")" + "</col>" : " " + class383.colorStartTag(16776960) + var1 + "</col>";
      }
   }
}
