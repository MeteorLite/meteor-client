import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fn")
@Implements("ClanChannel")
public class ClanChannel extends Node {
   @ObfuscatedName("fy")
   static int worldPort;
   @ObfuscatedName("jw")
   static int cameraZ;
   @ObfuscatedName("h")
   boolean field1393;
   @ObfuscatedName("e")
   boolean field1385 = true;
   @ObfuscatedName("v")
   public List members;
   @ObfuscatedName("x")
   int[] sortedMembers;
   @ObfuscatedName("m")
   long field1388;
   @ObfuscatedName("q")
   public String name = null;
   @ObfuscatedName("f")
   public byte field1390;
   @ObfuscatedName("r")
   public byte field1392;

   static {
      new BitSet(65536);
   }

   @ObfuscatedSignature(
      descriptor = "(Lqy;)V"
   )
   public ClanChannel(Buffer var1) {
      this.method830(var1);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(I)[I",
      garbageValue = "-1521514395"
   )
   public int[] getSortedMembers() {
      if (this.sortedMembers == null) {
         String[] var1 = new String[this.members.size()];
         this.sortedMembers = new int[this.members.size()];

         for(int var2 = 0; var2 < this.members.size(); this.sortedMembers[var2] = var2++) {
            var1[var2] = ((ClanChannelMember)this.members.get(var2)).username.method2504();
         }

         ItemContainer.method467(var1, this.sortedMembers);
      }

      return this.sortedMembers;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "(Lee;I)V",
      garbageValue = "-2049218043"
   )
   void addMember(ClanChannelMember var1) {
      this.members.add(var1);
      this.sortedMembers = null;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "(II)V",
      garbageValue = "1798196264"
   )
   void removeMember(int var1) {
      this.members.remove(var1);
      this.sortedMembers = null;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "-825544108"
   )
   public int method828() {
      return this.members.size();
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;I)I",
      garbageValue = "939290136"
   )
   public int method829(String var1) {
      if (!this.field1385) {
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

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      descriptor = "(Lqy;B)V",
      garbageValue = "-112"
   )
   void method830(Buffer var1) {
      int var2 = var1.readUnsignedByte();
      if ((var2 & 1) != 0) {
         this.field1393 = true;
      }

      if ((var2 & 2) != 0) {
         this.field1385 = true;
      }

      int var3 = 2;
      if ((var2 & 4) != 0) {
         var3 = var1.readUnsignedByte();
      }

      super.key = var1.readLong();
      this.field1388 = var1.readLong();
      this.name = var1.readStringCp1252NullTerminated();
      var1.readBoolean();
      this.field1392 = var1.readByte();
      this.field1390 = var1.readByte();
      int var4 = var1.readUnsignedShort();
      if (var4 > 0) {
         this.members = new ArrayList(var4);

         for(int var5 = 0; var5 < var4; ++var5) {
            ClanChannelMember var6 = new ClanChannelMember();
            if (this.field1393) {
               var1.readLong();
            }

            if (this.field1385) {
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
}
