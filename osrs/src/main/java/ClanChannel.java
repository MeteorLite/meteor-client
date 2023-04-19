import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gj")
@Implements("ClanChannel")
public class ClanChannel extends Node {
    @ObfuscatedName("av")
    static int[] ByteArrayPool_alternativeSizes;
   @ObfuscatedName("af")
   boolean field1402;
   @ObfuscatedName("an")
   boolean field1404 = true;
    @ObfuscatedName("aw")
    public List members;
    @ObfuscatedName("ac")
    int[] sortedMembers;
   @ObfuscatedName("au")
   long field1399;
    @ObfuscatedName("ab")
    public String name = null;
   @ObfuscatedName("aq")
   public byte field1396;
   @ObfuscatedName("al")
   public byte field1401;

   static {
      new BitSet(65536);
   }

   @ObfuscatedSignature(
      descriptor = "(Lsg;)V"
   )
   public ClanChannel(Buffer var1) {
      this.method900(var1);
   }

    @ObfuscatedName("af")
    @ObfuscatedSignature(
            descriptor = "(I)[I",
            garbageValue = "67863678"
    )
    public int[] getSortedMembers() {
      if (this.sortedMembers == null) {
         String[] var1 = new String[this.members.size()];
         this.sortedMembers = new int[this.members.size()];

         for(int var2 = 0; var2 < this.members.size(); this.sortedMembers[var2] = var2++) {
            var1[var2] = ((ClanChannelMember)this.members.get(var2)).username.method2643();
         }

         int[] var3 = this.sortedMembers;
         class138.method801(var1, var3, 0, var1.length - 1);
      }

      return this.sortedMembers;
   }

    @ObfuscatedName("an")
    @ObfuscatedSignature(
            descriptor = "(Lfz;I)V",
            garbageValue = "-1098707641"
    )
    void addMember(ClanChannelMember var1) {
      this.members.add(var1);
      this.sortedMembers = null;
   }

    @ObfuscatedName("aw")
    @ObfuscatedSignature(
            descriptor = "(IB)V",
            garbageValue = "-27"
    )
    void removeMember(int var1) {
      this.members.remove(var1);
      this.sortedMembers = null;
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "390972136"
   )
   public int method898() {
      return this.members.size();
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;I)I",
      garbageValue = "-1047252257"
   )
   public int method897(String var1) {
      if (!this.field1404) {
         throw new RuntimeException("Displaynames not available");
      } else {
         for(int var2 = 0; var2 < this.members.size(); ++var2) {
            if (((ClanChannelMember)this.members.get(var2)).username.getName().equalsIgnoreCase(var1)) {
               return var2;
            }
         }

         return -1;
      }
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "(Lsg;I)V",
      garbageValue = "-1838416622"
   )
   void method900(Buffer var1) {
      int var2 = var1.readUnsignedByte();
      if ((var2 & 1) != 0) {
         this.field1402 = true;
      }

      if ((var2 & 2) != 0) {
         this.field1404 = true;
      }

      int var3 = 2;
      if ((var2 & 4) != 0) {
         var3 = var1.readUnsignedByte();
      }

      super.key = var1.readLong();
      this.field1399 = var1.readLong();
      this.name = var1.readStringCp1252NullTerminated();
      var1.readBoolean();
      this.field1401 = var1.readByte();
      this.field1396 = var1.readByte();
      int var4 = var1.readUnsignedShort();
      if (var4 > 0) {
         this.members = new ArrayList(var4);

         for(int var5 = 0; var5 < var4; ++var5) {
            ClanChannelMember var6 = new ClanChannelMember();
            if (this.field1402) {
               var1.readLong();
            }

            if (this.field1404) {
               var6.username = new Username(var1.readStringCp1252NullTerminated());
            }

            var6.rank = var1.readByte();
            var6.world = var1.readUnsignedShort();
            if (var3 >= 3) {
               var1.readBoolean();
            }

            this.members.add(var5, var6);
         }
      }

   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "(IIIIB)I",
      garbageValue = "91"
   )
   static final int method903(int var0, int var1, int var2, int var3) {
      return var2 * var1 - var3 * var0 >> 16;
   }
}
