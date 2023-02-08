import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fz")
@Implements("InvDefinition")
public class InvDefinition extends DualNode {
    @ObfuscatedName("f")
    @ObfuscatedSignature(
            descriptor = "Lln;"
    )
    public static AbstractArchive InvDefinition_archive;
    @ObfuscatedName("w")
    @ObfuscatedSignature(
            descriptor = "Lja;"
    )
    static EvictingDualNodeHashTable InvDefinition_cached = new EvictingDualNodeHashTable(64);
    @ObfuscatedName("bh")
    static String otp;
    @ObfuscatedName("ju")
    @ObfuscatedSignature(
            descriptor = "[Lrg;"
    )
    static IndexedSprite[] scrollBarSprites;
    @ObfuscatedName("v")
    public int size = 0;

    @ObfuscatedName("w")
    @ObfuscatedSignature(
            descriptor = "(Lrd;I)V",
            garbageValue = "-336923015"
    )
    void decode(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if (var2 == 0) {
            return;
         }

         this.decodeNext(var1, var2);
      }
   }

    @ObfuscatedName("v")
    @ObfuscatedSignature(
            descriptor = "(Lrd;IB)V",
            garbageValue = "118"
    )
    void decodeNext(Buffer var1, int var2) {
      if (var2 == 2) {
         this.size = var1.readUnsignedShort();
      }

   }
}
