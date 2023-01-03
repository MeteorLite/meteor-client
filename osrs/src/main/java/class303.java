import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ki")
public class class303 {
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      descriptor = "Lnu;"
   )
   class368 field2832 = new class368();
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      descriptor = "Lnu;"
   )
   class368 field2827 = new class368();
   @ObfuscatedName("t")
   boolean field2834 = false;
   @ObfuscatedName("c")
   boolean field2831 = true;
   @ObfuscatedName("p")
   int field2845 = 0;
   @ObfuscatedName("d")
   boolean field2835 = false;
   @ObfuscatedName("y")
   int field2836 = 0;
   @ObfuscatedName("z")
   int field2837 = 0;
   @ObfuscatedName("w")
   int field2838 = 0;
   @ObfuscatedName("as")
   int field2833 = 0;
   @ObfuscatedName("ad")
   int field2840 = 0;
   @ObfuscatedName("ao")
   int field2841 = 0;
   @ObfuscatedName("am")
   int field2842 = 0;
   @ObfuscatedName("av")
   int field2839 = Integer.MAX_VALUE;
   @ObfuscatedName("au")
   int field2828 = Integer.MAX_VALUE;
   @ObfuscatedName("ar")
   int field2830 = Integer.MAX_VALUE;
   @ObfuscatedName("at")
   int field2844 = 0;
   @ObfuscatedName("ay")
   int field2843 = 0;
   @ObfuscatedName("an")
   int field2829 = 0;
   @ObfuscatedName("ab")
   int field2826 = 0;
   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "Lkr;"
   )
   class297 field2846;
   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      descriptor = "Lkr;"
   )
   class297 field2847;

   class303() {
      this.field2832.method1947(1);
      this.field2827.method1947(1);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "1350430597"
   )
   void method1634() {
      this.field2845 = (this.field2845 + 1) % 60;
      if (this.field2842 > 0) {
         --this.field2842;
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "(ZI)Z",
      garbageValue = "1031224212"
   )
   public boolean method1635(boolean var1) {
      var1 = var1 && this.field2831;
      boolean var2 = this.field2834 != var1;
      this.field2834 = var1;
      if (!this.field2834) {
         this.method1656(this.field2833, this.field2833);
      }

      return var2;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "(ZI)V",
      garbageValue = "-1990857914"
   )
   public void method1636(boolean var1) {
      this.field2831 = var1;
      this.field2834 = var1 && this.field2834;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;I)Z",
      garbageValue = "1086312663"
   )
   boolean method1637(String var1) {
      String var2 = this.field2832.method1941();
      if (!var2.equals(var1)) {
         var1 = this.method1689(var1);
         this.field2832.method1928(var1);
         this.method1643(this.field2829, this.field2826);
         this.method1669();
         this.method1693();
         return true;
      } else {
         return false;
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;I)Z",
      garbageValue = "-966702085"
   )
   boolean method1711(String var1) {
      this.field2827.method1928(var1);
      return true;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      descriptor = "(Lne;S)Z",
      garbageValue = "-408"
   )
   boolean method1638(AbstractFont var1) {
      boolean var2 = !this.field2835;
      this.field2832.method1945(var1);
      this.field2827.method1945(var1);
      this.field2835 = true;
      var2 |= this.method1643(this.field2829, this.field2826);
      var2 |= this.method1656(this.field2840, this.field2833);
      if (this.method1669()) {
         this.method1693();
         var2 = true;
      }

      return var2;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "(III)Z",
      garbageValue = "1720007659"
   )
   public boolean method1639(int var1, int var2) {
      boolean var3 = this.field2844 != var1 || var2 != this.field2843;
      this.field2844 = var1;
      this.field2843 = var2;
      var3 |= this.method1643(this.field2829, this.field2826);
      return var3;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      descriptor = "(IB)Z",
      garbageValue = "11"
   )
   public boolean method1640(int var1) {
      if (var1 < 0) {
         var1 = Integer.MAX_VALUE;
      }

      boolean var2 = var1 == this.field2832.method1935();
      this.field2832.method1922(var1, true);
      this.field2827.method1922(var1, true);
      if (this.method1669()) {
         this.method1693();
         var2 = true;
      }

      return var2;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      descriptor = "(II)Z",
      garbageValue = "195765062"
   )
   public boolean method1641(int var1) {
      if (var1 < 0) {
         this.field2839 = Integer.MAX_VALUE;
      } else {
         this.field2839 = var1;
      }

      if (this.method1669()) {
         this.method1693();
         return true;
      } else {
         return false;
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      descriptor = "(IB)Z",
      garbageValue = "-54"
   )
   public boolean method1642(int var1) {
      this.field2830 = var1;
      if (this.method1669()) {
         this.method1693();
         return true;
      } else {
         return false;
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      descriptor = "(III)Z",
      garbageValue = "1288674527"
   )
   public boolean method1643(int var1, int var2) {
      if (!this.method1706()) {
         this.field2829 = var1;
         this.field2826 = var2;
         return false;
      } else {
         int var3 = this.field2829;
         int var4 = this.field2826;
         int var5 = Math.max(0, this.field2832.method1933() - this.field2844 + 2);
         int var6 = Math.max(0, this.field2832.method1950() - this.field2843 + 1);
         this.field2829 = Math.max(0, Math.min(var5, var1));
         this.field2826 = Math.max(0, Math.min(var6, var2));
         return var3 != this.field2829 || var4 != this.field2826;
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      descriptor = "(III)Z",
      garbageValue = "-1022783976"
   )
   public boolean method1644(int var1, int var2) {
      return true;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      descriptor = "(II)V",
      garbageValue = "604179607"
   )
   public void method1645(int var1) {
      this.field2832.method1946(var1);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      descriptor = "(II)V",
      garbageValue = "-1403807319"
   )
   public void method1646(int var1) {
      this.field2836 = var1;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      descriptor = "(II)V",
      garbageValue = "716355991"
   )
   public void method1697(int var1) {
      this.field2832.method1947(var1);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      descriptor = "(II)V",
      garbageValue = "217166740"
   )
   public void method1684(int var1) {
      this.field2832.method1923(var1);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      descriptor = "(IB)Z",
      garbageValue = "50"
   )
   public boolean method1703(int var1) {
      this.field2838 = var1;
      String var2 = this.field2832.method1941();
      int var3 = var2.length();
      var2 = this.method1689(var2);
      if (var2.length() != var3) {
         this.field2832.method1928(var2);
         this.method1643(this.field2829, this.field2826);
         this.method1669();
         this.method1693();
         return true;
      } else {
         return false;
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "-1966558117"
   )
   public void method1648() {
      this.field2835 = false;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      descriptor = "(II)Z",
      garbageValue = "-188837227"
   )
   public boolean method1649(int var1) {
      if (this.method1675(var1)) {
         this.method1654();
         class369 var2 = this.field2832.method1925((char)var1, this.field2833, this.field2828, this.field2839);
         this.method1656(var2.method1951(), var2.method1951());
         this.method1669();
         this.method1693();
      }

      return true;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      descriptor = "(S)V",
      garbageValue = "3315"
   )
   public void method1650() {
      if (!this.method1654() && this.field2833 > 0) {
         int var1 = this.field2832.method1930(this.field2833 - 1);
         this.method1693();
         this.method1656(var1, var1);
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "1"
   )
   public void method1651() {
      if (!this.method1654() && this.field2833 < this.field2832.method1921()) {
         int var1 = this.field2832.method1930(this.field2833);
         this.method1693();
         this.method1656(var1, var1);
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "512301118"
   )
   public void method1652() {
      if (!this.method1654() && this.field2833 > 0) {
         class440 var1 = this.method1690(this.field2833 - 1);
         int var2 = this.field2832.method1924((Integer)var1.field3917, this.field2833);
         this.method1693();
         this.method1656(var2, var2);
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      descriptor = "(S)V",
      garbageValue = "-30062"
   )
   public void method1653() {
      if (!this.method1654() && this.field2833 < this.field2832.method1921()) {
         class440 var1 = this.method1690(this.field2833);
         int var2 = this.field2832.method1924(this.field2833, (Integer)var1.field3916);
         this.method1693();
         this.method1656(var2, var2);
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      descriptor = "(I)Z",
      garbageValue = "1528760733"
   )
   boolean method1654() {
      if (!this.method1688()) {
         return false;
      } else {
         int var1 = this.field2832.method1924(this.field2840, this.field2833);
         this.method1693();
         this.method1656(var1, var1);
         return true;
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "54505361"
   )
   public void method1710() {
      this.method1656(0, this.field2832.method1921());
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      descriptor = "(IIB)Z",
      garbageValue = "-34"
   )
   public boolean method1656(int var1, int var2) {
      if (!this.method1706()) {
         this.field2840 = var1;
         this.field2833 = var2;
         return false;
      } else {
         if (var1 > this.field2832.method1921()) {
            var1 = this.field2832.method1921();
         }

         if (var2 > this.field2832.method1921()) {
            var2 = this.field2832.method1921();
         }

         boolean var3 = this.field2840 != var1 || var2 != this.field2833;
         this.field2840 = var1;
         if (var2 != this.field2833) {
            this.field2833 = var2;
            this.field2845 = 0;
            this.method1692();
         }

         if (var3 && this.field2847 != null) {
            this.field2847.vmethod5708();
         }

         return var3;
      }
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      descriptor = "(ZB)V",
      garbageValue = "111"
   )
   public void method1712(boolean var1) {
      class440 var2 = this.method1702(this.field2833);
      this.method1709((Integer)var2.field3917, var1);
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      descriptor = "(ZI)V",
      garbageValue = "1891106199"
   )
   public void method1657(boolean var1) {
      class440 var2 = this.method1702(this.field2833);
      this.method1709((Integer)var2.field3916, var1);
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      descriptor = "(ZI)V",
      garbageValue = "-926488964"
   )
   public void method1658(boolean var1) {
      this.method1709(0, var1);
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      descriptor = "(ZI)V",
      garbageValue = "1841715153"
   )
   public void method1659(boolean var1) {
      this.method1709(this.field2832.method1921(), var1);
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      descriptor = "(ZI)V",
      garbageValue = "-585513262"
   )
   public void method1660(boolean var1) {
      if (this.method1688() && !var1) {
         this.method1709(Math.min(this.field2840, this.field2833), var1);
      } else if (this.field2833 > 0) {
         this.method1709(this.field2833 - 1, var1);
      }

   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      descriptor = "(ZB)V",
      garbageValue = "7"
   )
   public void method1661(boolean var1) {
      if (this.method1688() && !var1) {
         this.method1709(Math.max(this.field2840, this.field2833), var1);
      } else if (this.field2833 < this.field2832.method1921()) {
         this.method1709(this.field2833 + 1, var1);
      }

   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      descriptor = "(ZB)V",
      garbageValue = "101"
   )
   public void method1662(boolean var1) {
      if (this.field2833 > 0) {
         class440 var2 = this.method1690(this.field2833 - 1);
         this.method1709((Integer)var2.field3917, var1);
      }

   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      descriptor = "(ZB)V",
      garbageValue = "-17"
   )
   public void method1655(boolean var1) {
      if (this.field2833 < this.field2832.method1921()) {
         class440 var2 = this.method1690(this.field2833 + 1);
         this.method1709((Integer)var2.field3916, var1);
      }

   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      descriptor = "(ZI)V",
      garbageValue = "478652614"
   )
   public void method1699(boolean var1) {
      if (this.field2833 > 0) {
         this.method1709(this.field2832.method1932(this.field2833, -1), var1);
      }

   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "(ZB)V",
      garbageValue = "-76"
   )
   public void method1679(boolean var1) {
      if (this.field2833 < this.field2832.method1921()) {
         this.method1709(this.field2832.method1932(this.field2833, 1), var1);
      }

   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "(ZS)V",
      garbageValue = "-2228"
   )
   public void method1664(boolean var1) {
      if (this.field2833 > 0) {
         int var2 = this.method1691();
         this.method1709(this.field2832.method1932(this.field2833, -var2), var1);
      }

   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "(ZI)V",
      garbageValue = "314854978"
   )
   public void method1665(boolean var1) {
      if (this.field2833 < this.field2832.method1921()) {
         int var2 = this.method1691();
         this.method1709(this.field2832.method1932(this.field2833, var2), var1);
      }

   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      descriptor = "(ZB)V",
      garbageValue = "4"
   )
   public void method1666(boolean var1) {
      class372 var2 = this.field2832.method1942(0, this.field2833);
      class440 var3 = var2.method1986();
      this.method1709(this.field2832.method1931((Integer)var3.field3917, this.field2826), var1);
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      descriptor = "(ZI)V",
      garbageValue = "891282237"
   )
   public void method1667(boolean var1) {
      class372 var2 = this.field2832.method1942(0, this.field2833);
      class440 var3 = var2.method1986();
      this.method1709(this.field2832.method1931((Integer)var3.field3917, this.field2843 + this.field2826), var1);
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      descriptor = "(IIZZB)V",
      garbageValue = "80"
   )
   public void method1668(int var1, int var2, boolean var3, boolean var4) {
      boolean var5 = false;
      int var8;
      if (!this.field2835) {
         var8 = 0;
      } else {
         var1 += this.field2829;
         var2 += this.field2826;
         var8 = this.field2832.method1931(var1, var2);
      }

      class440 var6;
      if (var3 && var4) {
         this.field2837 = 1;
         var6 = this.method1690(var8);
         class440 var7 = this.method1690(this.field2841);
         this.method1705(var7, var6);
      } else if (var3) {
         this.field2837 = 1;
         var6 = this.method1690(var8);
         this.method1656((Integer)var6.field3917, (Integer)var6.field3916);
         this.field2841 = (Integer)var6.field3917;
      } else if (var4) {
         this.method1656(this.field2841, var8);
      } else {
         if (this.field2842 > 0 && var8 == this.field2841) {
            if (this.field2840 == this.field2833) {
               this.field2837 = 1;
               var6 = this.method1690(var8);
               this.method1656((Integer)var6.field3917, (Integer)var6.field3916);
            } else {
               this.field2837 = 2;
               var6 = this.method1702(var8);
               this.method1656((Integer)var6.field3917, (Integer)var6.field3916);
            }
         } else {
            this.field2837 = 0;
            this.method1656(var8, var8);
            this.field2841 = var8;
         }

         this.field2842 = 25;
      }

   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      descriptor = "(III)V",
      garbageValue = "116560284"
   )
   public void method1707(int var1, int var2) {
      if (this.field2835 && this.method1694()) {
         var1 += this.field2829;
         var2 += this.field2826;
         int var3 = this.field2832.method1931(var1, var2);
         class440 var4;
         class440 var5;
         switch(this.field2837) {
         case 0:
            this.method1656(this.field2840, var3);
            break;
         case 1:
            var4 = this.method1690(this.field2841);
            var5 = this.method1690(var3);
            this.method1705(var4, var5);
            break;
         case 2:
            var4 = this.method1702(this.field2841);
            var5 = this.method1702(var3);
            this.method1705(var4, var5);
         }
      }

   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      descriptor = "(Ljava/awt/datatransfer/Clipboard;I)V",
      garbageValue = "-1357067118"
   )
   public void method1701(Clipboard var1) {
      class372 var2 = this.field2832.method1942(this.field2840, this.field2833);
      if (!var2.method1984()) {
         String var3 = var2.method1990();
         if (!var3.isEmpty()) {
            var1.setContents(new StringSelection(var3), (ClipboardOwner)null);
         }
      }

   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      descriptor = "(Ljava/awt/datatransfer/Clipboard;I)V",
      garbageValue = "1200185346"
   )
   public void method1670(Clipboard var1) {
      if (this.method1688()) {
         this.method1701(var1);
         this.method1654();
      }

   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      descriptor = "(Ljava/awt/datatransfer/Clipboard;I)V",
      garbageValue = "1443728969"
   )
   public void method1671(Clipboard var1) {
      Transferable var2 = var1.getContents((Object)null);
      if (var2 != null && var2.isDataFlavorSupported(DataFlavor.stringFlavor)) {
         try {
            String var3 = this.method1689((String)var2.getTransferData(DataFlavor.stringFlavor));
            this.method1654();
            class369 var4 = this.field2832.method1926(var3, this.field2833, this.field2828, this.field2839);
            this.method1656(var4.method1951(), var4.method1951());
            this.method1669();
            this.method1693();
         } catch (Exception var5) {
            System.out.println("Error pasting clipboard to InputField.");
         }
      }

   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "-382481619"
   )
   public void method1672() {
      this.field2826 = Math.max(0, this.field2826 - this.field2832.method1948());
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "-1691398443"
   )
   public void method1695() {
      int var1 = Math.max(0, this.field2832.method1950() - this.field2843);
      this.field2826 = Math.min(var1, this.field2826 + this.field2832.method1948());
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      descriptor = "(Lkr;I)V",
      garbageValue = "-1482480307"
   )
   public void method1673(class297 var1) {
      this.field2846 = var1;
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      descriptor = "(Lkr;I)V",
      garbageValue = "-981604746"
   )
   public void method1674(class297 var1) {
      this.field2847 = var1;
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      descriptor = "(I)Lnu;",
      garbageValue = "-174585091"
   )
   public class368 method1696() {
      return this.field2832;
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      descriptor = "(I)Lnu;",
      garbageValue = "-1028025765"
   )
   public class368 method1647() {
      return this.field2827;
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "(B)Lna;",
      garbageValue = "0"
   )
   public class372 method1676() {
      return this.field2832.method1942(this.field2840, this.field2833);
   }

   @ObfuscatedName("bh")
   @ObfuscatedSignature(
      descriptor = "(I)Z",
      garbageValue = "1825590323"
   )
   public boolean method1694() {
      return this.field2834;
   }

   @ObfuscatedName("by")
   @ObfuscatedSignature(
      descriptor = "(B)Z",
      garbageValue = "0"
   )
   public boolean method1633() {
      return this.field2831;
   }

   @ObfuscatedName("bw")
   @ObfuscatedSignature(
      descriptor = "(S)Z",
      garbageValue = "241"
   )
   public boolean method1677() {
      return this.method1694() && this.field2845 % 60 < 30;
   }

   @ObfuscatedName("bp")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "1904955935"
   )
   public int method1678() {
      return this.field2833;
   }

   @ObfuscatedName("bc")
   @ObfuscatedSignature(
      descriptor = "(B)I",
      garbageValue = "-80"
   )
   public int method1663() {
      return this.field2840;
   }

   @ObfuscatedName("bl")
   @ObfuscatedSignature(
      descriptor = "(I)Z",
      garbageValue = "-555561187"
   )
   public boolean method1706() {
      return this.field2835;
   }

   @ObfuscatedName("bv")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "-1887741730"
   )
   public int method1680() {
      return this.field2829;
   }

   @ObfuscatedName("bx")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "1255754672"
   )
   public int method1681() {
      return this.field2826;
   }

   @ObfuscatedName("bg")
   @ObfuscatedSignature(
      descriptor = "(S)I",
      garbageValue = "-17768"
   )
   public int method1682() {
      return this.field2832.method1935();
   }

   @ObfuscatedName("bz")
   @ObfuscatedSignature(
      descriptor = "(B)I",
      garbageValue = "-40"
   )
   public int method1683() {
      return this.field2839;
   }

   @ObfuscatedName("bi")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "-1076456010"
   )
   public int method1708() {
      return this.field2830;
   }

   @ObfuscatedName("br")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "-216079285"
   )
   public int method1685() {
      return this.field2836;
   }

   @ObfuscatedName("bq")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "-1133819584"
   )
   public int method1704() {
      return this.field2832.method1936();
   }

   @ObfuscatedName("bn")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "-2061169778"
   )
   public int method1686() {
      return this.field2838;
   }

   @ObfuscatedName("ba")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "-1951131614"
   )
   public int method1698() {
      return this.field2832.method1944();
   }

   @ObfuscatedName("bs")
   @ObfuscatedSignature(
      descriptor = "(I)Z",
      garbageValue = "1774852145"
   )
   public boolean method1687() {
      return this.field2839 > 1;
   }

   @ObfuscatedName("bt")
   @ObfuscatedSignature(
      descriptor = "(I)Z",
      garbageValue = "1862038399"
   )
   boolean method1688() {
      return this.field2833 != this.field2840;
   }

   @ObfuscatedName("bu")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;I)Ljava/lang/String;",
      garbageValue = "-1311901455"
   )
   String method1689(String var1) {
      StringBuilder var2 = new StringBuilder(var1.length());

      for(int var3 = 0; var3 < var1.length(); ++var3) {
         char var4 = var1.charAt(var3);
         if (this.method1675(var4)) {
            var2.append(var4);
         }
      }

      return var2.toString();
   }

   @ObfuscatedName("bj")
   @ObfuscatedSignature(
      descriptor = "(Lpg;Lpg;I)V",
      garbageValue = "-1058810846"
   )
   void method1705(class440 var1, class440 var2) {
      if ((Integer)var2.field3917 < (Integer)var1.field3917) {
         this.method1656((Integer)var1.field3916, (Integer)var2.field3917);
      } else {
         this.method1656((Integer)var1.field3917, (Integer)var2.field3916);
      }

   }

   @ObfuscatedName("bb")
   @ObfuscatedSignature(
      descriptor = "(II)Lpg;",
      garbageValue = "-1657189807"
   )
   class440 method1690(int var1) {
      int var2 = this.field2832.method1921();
      int var3 = 0;
      int var4 = var2;

      int var5;
      for(var5 = var1; var5 > 0; --var5) {
         if (this.method1700(this.field2832.method1918(var5 - 1).field3597)) {
            var3 = var5;
            break;
         }
      }

      for(var5 = var1; var5 < var2; ++var5) {
         if (this.method1700(this.field2832.method1918(var5).field3597)) {
            var4 = var5;
            break;
         }
      }

      return new class440(var3, var4);
   }

   @ObfuscatedName("bm")
   @ObfuscatedSignature(
      descriptor = "(II)Lpg;",
      garbageValue = "1830301127"
   )
   class440 method1702(int var1) {
      int var2 = this.field2832.method1921();
      int var3 = 0;
      int var4 = var2;

      int var5;
      for(var5 = var1; var5 > 0; --var5) {
         if (this.field2832.method1918(var5 - 1).field3597 == '\n') {
            var3 = var5;
            break;
         }
      }

      for(var5 = var1; var5 < var2; ++var5) {
         if (this.field2832.method1918(var5).field3597 == '\n') {
            var4 = var5;
            break;
         }
      }

      return new class440(var3, var4);
   }

   @ObfuscatedName("bk")
   @ObfuscatedSignature(
      descriptor = "(I)Z",
      garbageValue = "8914325"
   )
   boolean method1669() {
      if (!this.method1706()) {
         return false;
      } else {
         boolean var1 = false;
         if (this.field2832.method1921() > this.field2830) {
            this.field2832.method1924(this.field2830, this.field2832.method1921());
            var1 = true;
         }

         int var2;
         if (this.field2832.method1949() > this.field2839) {
            var2 = this.field2832.method1932(0, this.field2839) - 1;
            this.field2832.method1924(var2, this.field2832.method1921());
            var1 = true;
         }

         if (var1) {
            var2 = this.field2833;
            int var3 = this.field2840;
            int var4 = this.field2832.method1921();
            if (this.field2833 > var4) {
               var2 = var4;
            }

            if (this.field2840 > var4) {
               var3 = var4;
            }

            this.method1656(var3, var2);
         }

         return var1;
      }
   }

   @ObfuscatedName("bd")
   @ObfuscatedSignature(
      descriptor = "(IZI)V",
      garbageValue = "-1350161608"
   )
   void method1709(int var1, boolean var2) {
      if (var2) {
         this.method1656(this.field2840, var1);
      } else {
         this.method1656(var1, var1);
      }

   }

   @ObfuscatedName("cf")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "-201387644"
   )
   int method1691() {
      return this.field2843 / this.field2832.method1948();
   }

   @ObfuscatedName("cl")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "797989363"
   )
   void method1692() {
      class372 var1 = this.field2832.method1942(0, this.field2833);
      class440 var2 = var1.method1986();
      int var3 = this.field2832.method1948();
      int var4 = (Integer)var2.field3917 - 10;
      int var5 = var4 + 20;
      int var6 = (Integer)var2.field3916 - 3;
      int var7 = var6 + var3 + 6;
      int var8 = this.field2829;
      int var9 = var8 + this.field2844;
      int var10 = this.field2826;
      int var11 = var10 + this.field2843;
      int var12 = this.field2829;
      int var13 = this.field2826;
      if (var4 < var8) {
         var12 = var4;
      } else if (var5 > var9) {
         var12 = var5 - this.field2844;
      }

      if (var6 < var10) {
         var13 = var6;
      } else if (var7 > var11) {
         var13 = var7 - this.field2843;
      }

      this.method1643(var12, var13);
   }

   @ObfuscatedName("cq")
   @ObfuscatedSignature(
      descriptor = "(II)Z",
      garbageValue = "2021327959"
   )
   boolean method1700(int var1) {
      return var1 == 32 || var1 == 10 || var1 == 9;
   }

   @ObfuscatedName("cc")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "1"
   )
   void method1693() {
      if (this.field2846 != null) {
         this.field2846.vmethod5708();
      }

   }

   @ObfuscatedName("cw")
   @ObfuscatedSignature(
      descriptor = "(II)Z",
      garbageValue = "-1962828241"
   )
   boolean method1675(int var1) {
      switch(this.field2838) {
      case 1:
         return ObjectComposition.isAlphaNumeric((char)var1);
      case 2:
         return ViewportMouse.isCharAlphabetic((char)var1);
      case 3:
         return WorldMapLabelSize.isDigit((char)var1);
      case 4:
         char var2 = (char)var1;
         if (WorldMapLabelSize.isDigit(var2)) {
            return true;
         } else {
            if (var2 != 'k' && var2 != 'K' && var2 != 'm' && var2 != 'M' && var2 != 'b' && var2 != 'B') {
               return false;
            }

            return true;
         }
      default:
         return true;
      }
   }
}
