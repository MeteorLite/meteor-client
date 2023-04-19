import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fr")
public class class145 extends class155 {
   @ObfuscatedName("af")
   int field1334;
   @ObfuscatedName("an")
   byte field1335;
   @ObfuscatedName("aw")
   int field1337;
   @ObfuscatedName("ac")
   String field1336;
   // $FF: synthetic field
   @ObfuscatedSignature(
      descriptor = "Lgr;"
   )
   final class156 this$0;

   @ObfuscatedSignature(
      descriptor = "(Lgr;)V"
   )
   class145(class156 var1) {
      this.this$0 = var1;
      this.field1334 = -1;
   }

    @ObfuscatedName("af")
    @ObfuscatedSignature(
            descriptor = "(Lsg;I)V",
            garbageValue = "-1949352075"
    )
    void vmethod3238(Buffer var1) {
      this.field1334 = var1.readUnsignedShort();
      this.field1335 = var1.readByte();
      this.field1337 = var1.readUnsignedShort();
      var1.readLong();
      this.field1336 = var1.readStringCp1252NullTerminated();
   }

    @ObfuscatedName("an")
    @ObfuscatedSignature(
            descriptor = "(Lgj;B)V",
            garbageValue = "-49"
    )
    void vmethod3239(ClanChannel var1) {
      ClanChannelMember var2 = (ClanChannelMember)var1.members.get(this.field1334);
      var2.rank = this.field1335;
      var2.world = this.field1337;
      var2.username = new Username(this.field1336);
   }
}
