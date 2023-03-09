import java.util.Arrays;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ic")
public class class208 implements class29 {
   @ObfuscatedName("au")
   static int field1826;
   @ObfuscatedName("dv")
   @ObfuscatedSignature(
      descriptor = "Lsp;"
   )
   @Export("worldSelectRightSprite")
   static IndexedSprite worldSelectRightSprite;
   @ObfuscatedName("aj")
   char[] field1818 = new char[128];
   @ObfuscatedName("al")
   int[] field1813 = new int[128];
   @ObfuscatedName("ac")
   public int[] field1814 = new int[128];
   @ObfuscatedName("ab")
   @Export("pressedKeysCount")
   public int pressedKeysCount = 0;
   @ObfuscatedName("an")
   int[] field1816 = new int[128];
   @ObfuscatedName("ao")
   int field1817 = 0;
   @ObfuscatedName("av")
   int field1825 = 0;
   @ObfuscatedName("aq")
   int field1819 = 0;
   @ObfuscatedName("ap")
   int field1820 = 0;
   @ObfuscatedName("ar")
   boolean[] field1821 = new boolean[112];
   @ObfuscatedName("ak")
   boolean[] field1822 = new boolean[112];
   @ObfuscatedName("ax")
   boolean[] field1812 = new boolean[112];
   @ObfuscatedName("as")
   public char field1824;
   @ObfuscatedName("ay")
   public int field1823;

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "(II)Z",
      garbageValue = "1308084386"
   )
   @Export("vmethod3949")
   public boolean vmethod3949(int var1) {
      this.method1087(var1);
      this.field1821[var1] = true;
      this.field1822[var1] = true;
      this.field1812[var1] = false;
      this.field1814[++this.pressedKeysCount - 1] = var1;
      return true;
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "(II)Z",
      garbageValue = "1404887619"
   )
   @Export("vmethod3989")
   public boolean vmethod3989(int var1) {
      this.field1821[var1] = false;
      this.field1822[var1] = false;
      this.field1812[var1] = true;
      this.field1816[++this.field1817 - 1] = var1;
      return true;
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "(CI)Z",
      garbageValue = "-870523457"
   )
   @Export("vmethod3951")
   public boolean vmethod3951(char var1) {
      int var2 = this.field1819 + 1 & 127;
      if (var2 != this.field1825) {
         this.field1813[this.field1819] = -1;
         this.field1818[this.field1819] = var1;
         this.field1819 = var2;
      }

      return false;
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "(ZB)Z",
      garbageValue = "104"
   )
   @Export("vmethod3953")
   public boolean vmethod3953(boolean var1) {
      return false;
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      descriptor = "(II)V",
      garbageValue = "939129373"
   )
   void method1087(int var1) {
      int var2 = this.field1819 + 1 & 127;
      if (var2 != this.field1825) {
         this.field1813[this.field1819] = var1;
         this.field1818[this.field1819] = 0;
         this.field1819 = var2;
      }

   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "1250890967"
   )
   public void method1092() {
      this.field1825 = this.field1820;
      this.field1820 = this.field1819;
      this.pressedKeysCount = 0;
      this.field1817 = 0;
      Arrays.fill(this.field1822, false);
      Arrays.fill(this.field1812, false);
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      descriptor = "(I)Z",
      garbageValue = "516855165"
   )
   public final boolean method1090() {
      if (this.field1825 == this.field1820) {
         return false;
      } else {
         this.field1823 = this.field1813[this.field1825];
         this.field1824 = this.field1818[this.field1825];
         this.field1825 = this.field1825 + 1 & 127;
         return true;
      }
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      descriptor = "(IB)Z",
      garbageValue = "126"
   )
   public boolean method1091(int var1) {
      return var1 >= 0 && var1 < 112 ? this.field1822[var1] : false;
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      descriptor = "(II)Z",
      garbageValue = "1148875783"
   )
   @Export("getKeyPressed")
   public boolean getKeyPressed(int var1) {
      return var1 >= 0 && var1 < 112 ? this.field1821[var1] : false;
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      descriptor = "(II)Z",
      garbageValue = "-1144678086"
   )
   public boolean method1088(int var1) {
      return var1 >= 0 && var1 < 112 ? this.field1812[var1] : false;
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      descriptor = "(I)[I",
      garbageValue = "1721523722"
   )
   public int[] method1096() {
      int[] var1 = new int[this.pressedKeysCount];

      for(int var2 = 0; var2 < this.pressedKeysCount; ++var2) {
         var1[var2] = this.field1814[var2];
      }

      return var1;
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      descriptor = "(B)[I",
      garbageValue = "107"
   )
   public int[] method1094() {
      int[] var1 = new int[this.field1817];

      for(int var2 = 0; var2 < this.field1817; ++var2) {
         var1[var2] = this.field1816[var2];
      }

      return var1;
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "(I)[Lkz;",
      garbageValue = "845145141"
   )
   public static ZoneOperation[] method1097() {
      return new ZoneOperation[]{ZoneOperation.field2522, ZoneOperation.field2521, ZoneOperation.field2520, ZoneOperation.field2523, ZoneOperation.field2519, ZoneOperation.field2518, ZoneOperation.field2524, ZoneOperation.field2525, ZoneOperation.field2526, ZoneOperation.field2527, ZoneOperation.field2528};
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "(B)[Led;",
      garbageValue = "-73"
   )
   static class129[] method1089() {
      return new class129[]{class129.field1254, class129.field1236, class129.field1238, class129.field1237, class129.field1249, class129.field1239, class129.field1240, class129.field1241, class129.field1242, class129.field1243, class129.field1244, class129.field1245, class129.field1246, class129.field1247, class129.field1248, class129.field1235, class129.field1250};
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "(IB)Lct;",
      garbageValue = "-2"
   )
   @Export("Messages_getMessage")
   static Message Messages_getMessage(int var0) {
      return (Message)Messages.Messages_hashTable.get((long)var0);
   }
}
