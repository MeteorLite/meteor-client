import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ee")
public class class152 extends class155 {
   @ObfuscatedName("fy")
   static String field1373;
   @ObfuscatedName("f")
   int field1372;
   @ObfuscatedName("w")
   byte field1371;
   @ObfuscatedName("v")
   int field1374;
   @ObfuscatedName("s")
   String field1370;
   // $FF: synthetic field
   @ObfuscatedSignature(
      descriptor = "Lfn;"
   )
   final class156 this$0;

   @ObfuscatedSignature(
      descriptor = "(Lfn;)V"
   )
   class152(class156 var1) {
      this.this$0 = var1;
      this.field1372 = -1;
   }

    @ObfuscatedName("f")
    @ObfuscatedSignature(
            descriptor = "(Lrd;B)V",
            garbageValue = "-123"
    )
    void vmethod3238(Buffer var1) {
      var1.readUnsignedByte();
      this.field1372 = var1.readUnsignedShort();
      this.field1371 = var1.readByte();
      this.field1374 = var1.readUnsignedShort();
      var1.readLong();
      this.field1370 = var1.readStringCp1252NullTerminated();
      var1.readUnsignedByte();
   }

    @ObfuscatedName("w")
    @ObfuscatedSignature(
            descriptor = "(Lfm;I)V",
            garbageValue = "127147356"
    )
    void vmethod3239(ClanChannel var1) {
      ClanChannelMember var2 = (ClanChannelMember)var1.members.get(this.field1372);
      var2.rank = this.field1371;
      var2.world = this.field1374;
      var2.username = new Username(this.field1370);
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      descriptor = "(IIII)I",
      garbageValue = "-1452562011"
   )
   public static int method815(int var0, int var1, int var2) {
      int var3 = SoundCache.method231(var2 - var1 + 1);
      var3 <<= var1;
      var0 |= var3;
      return var0;
   }
}
