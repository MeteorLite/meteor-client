import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("er")
public class class142 extends class152 {
   @ObfuscatedName("pw")
   static int field1316;
   @ObfuscatedName("h")
   int field1312;
   @ObfuscatedName("e")
   byte field1315;
   @ObfuscatedName("v")
   int field1314;
   @ObfuscatedName("x")
   String field1313;
   // $FF: synthetic field
   @ObfuscatedSignature(
      descriptor = "Led;"
   )
   final class153 this$0;

   @ObfuscatedSignature(
      descriptor = "(Led;)V"
   )
   class142(class153 var1) {
      this.this$0 = var1;
      this.field1312 = -1;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(Lqy;I)V",
      garbageValue = "468341515"
   )
   void vmethod3238(Buffer var1) {
      this.field1312 = var1.readUnsignedShort();
      this.field1315 = var1.readByte();
      this.field1314 = var1.readUnsignedShort();
      var1.readLong();
      this.field1313 = var1.readStringCp1252NullTerminated();
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "(Lfn;I)V",
      garbageValue = "1227548281"
   )
   void vmethod3239(ClanChannel var1) {
      ClanChannelMember var2 = (ClanChannelMember)var1.members.get(this.field1312);
      var2.rank = this.field1315;
      var2.world = this.field1314;
      var2.username = new Username(this.field1313);
   }
}
