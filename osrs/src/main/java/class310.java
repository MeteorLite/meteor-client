import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lo")
public class class310 {
   @ObfuscatedName("au")
   @ObfuscatedSignature(
      descriptor = "Low;"
   )
   class375 field2812 = new class375();
   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      descriptor = "Low;"
   )
   class375 field2801 = new class375();
   @ObfuscatedName("at")
   boolean field2798 = false;
   @ObfuscatedName("af")
   boolean field2803 = true;
   @ObfuscatedName("ai")
   int field2804 = 0;
   @ObfuscatedName("aw")
   boolean field2805 = false;
   @ObfuscatedName("aa")
   int field2806 = 0;
   @ObfuscatedName("ah")
   int field2807 = 0;
   @ObfuscatedName("ad")
   int field2808 = 0;
   @ObfuscatedName("bm")
   int field2809 = 0;
   @ObfuscatedName("bv")
   int field2800 = 0;
   @ObfuscatedName("bo")
   int field2810 = 0;
   @ObfuscatedName("bs")
   int field2799 = 0;
   @ObfuscatedName("bg")
   int field2811 = Integer.MAX_VALUE;
   @ObfuscatedName("bh")
   int field2817 = Integer.MAX_VALUE;
   @ObfuscatedName("bl")
   int field2813 = 0;
   @ObfuscatedName("bk")
   int field2802 = 0;
   @ObfuscatedName("br")
   int field2815 = 0;
   @ObfuscatedName("ba")
   int field2816 = 0;
   @ObfuscatedName("bz")
   @ObfuscatedSignature(
      descriptor = "Lll;"
   )
   class304 field2814;
   @ObfuscatedName("bq")
   @ObfuscatedSignature(
      descriptor = "Lll;"
   )
   class304 field2818;

   class310() {
      this.field2812.method1988(1);
      this.field2801.method1988(1);
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "1714802262"
   )
   void method1654() {
      this.field2804 = (this.field2804 + 1) % 60;
      if (this.field2799 > 0) {
         --this.field2799;
      }

   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "(ZB)Z",
      garbageValue = "2"
   )
   public boolean method1706(boolean var1) {
      var1 = var1 && this.field2803;
      boolean var2 = this.field2798 != var1;
      this.field2798 = var1;
      if (!this.field2798) {
         this.method1672(this.field2809, this.field2809);
      }

      return var2;
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "(ZI)V",
      garbageValue = "1686031987"
   )
   public void method1670(boolean var1) {
      this.field2803 = var1;
      this.field2798 = var1 && this.field2798;
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;I)Z",
      garbageValue = "-417183925"
   )
   boolean method1723(String var1) {
      String var2 = this.field2812.method1951();
      if (!var2.equals(var1)) {
         var1 = this.method1673(var1);
         this.field2812.method1960(var1);
         this.method1662(this.field2815, this.field2816);
         this.method1704();
         this.method1708();
         return true;
      } else {
         return false;
      }
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;B)Z",
      garbageValue = "16"
   )
   boolean method1657(String var1) {
      this.field2801.method1960(var1);
      return true;
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      descriptor = "(Lou;I)Z",
      garbageValue = "-473812710"
   )
   boolean method1727(AbstractFont var1) {
      boolean var2 = !this.field2805;
      this.field2812.method1955(var1);
      this.field2801.method1955(var1);
      this.field2805 = true;
      var2 |= this.method1662(this.field2815, this.field2816);
      var2 |= this.method1672(this.field2800, this.field2809);
      if (this.method1704()) {
         this.method1708();
         var2 = true;
      }

      return var2;
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      descriptor = "(III)Z",
      garbageValue = "1542973086"
   )
   public boolean method1658(int var1, int var2) {
      boolean var3 = this.field2813 != var1 || var2 != this.field2802;
      this.field2813 = var1;
      this.field2802 = var2;
      var3 |= this.method1662(this.field2815, this.field2816);
      return var3;
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      descriptor = "(IB)Z",
      garbageValue = "-41"
   )
   public boolean method1653(int var1) {
      if (var1 < 0) {
         var1 = Integer.MAX_VALUE;
      }

      boolean var2 = var1 == this.field2812.method1970();
      this.field2812.method1952(var1);
      this.field2801.method1952(var1);
      if (this.method1704()) {
         this.method1708();
         var2 = true;
      }

      return var2;
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      descriptor = "(II)Z",
      garbageValue = "981334972"
   )
   public boolean method1660(int var1) {
      this.field2812.method1953(var1);
      if (this.method1704()) {
         this.method1708();
         return true;
      } else {
         return false;
      }
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      descriptor = "(IB)Z",
      garbageValue = "120"
   )
   public boolean method1661(int var1) {
      this.field2817 = var1;
      if (this.method1704()) {
         this.method1708();
         return true;
      } else {
         return false;
      }
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      descriptor = "(III)Z",
      garbageValue = "573264435"
   )
   public boolean method1662(int var1, int var2) {
      if (!this.method1694()) {
         this.field2815 = var1;
         this.field2816 = var2;
         return false;
      } else {
         int var3 = this.field2815;
         int var4 = this.field2816;
         int var5 = Math.max(0, this.field2812.method1965() - this.field2813 + 2);
         int var6 = Math.max(0, this.field2812.method1966() - this.field2802 + 1);
         this.field2815 = Math.max(0, Math.min(var5, var1));
         this.field2816 = Math.max(0, Math.min(var6, var2));
         return var3 != this.field2815 || var4 != this.field2816;
      }
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      descriptor = "(III)Z",
      garbageValue = "-297314157"
   )
   public boolean method1716(int var1, int var2) {
      boolean var3 = true;
      if (var1 < 0 || var1 > 2) {
         System.out.println("InputField.setAlignment: Invalid horizontal alignment. Given value: '" + var1 + "'.");
         var3 = false;
      }

      if (var2 < 0 || var2 > 2) {
         System.out.println("InputField.setAlignment: Invalid vertical alignment. Given value: '" + var2 + "'.");
         var3 = false;
      }

      return var3 ? this.field2812.method1956(var1, var2) : false;
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      descriptor = "(II)V",
      garbageValue = "-2050381023"
   )
   public void method1663(int var1) {
      this.field2812.method1957(var1);
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      descriptor = "(IS)V",
      garbageValue = "5000"
   )
   public void method1686(int var1) {
      this.field2806 = var1;
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      descriptor = "(IB)V",
      garbageValue = "91"
   )
   public void method1711(int var1) {
      this.field2812.method1988(var1);
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      descriptor = "(IB)V",
      garbageValue = "1"
   )
   public void method1664(int var1) {
      this.field2812.method1954(var1);
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      descriptor = "(II)Z",
      garbageValue = "235641685"
   )
   public boolean method1714(int var1) {
      this.field2808 = var1;
      String var2 = this.field2812.method1951();
      int var3 = var2.length();
      var2 = this.method1673(var2);
      if (var2.length() != var3) {
         this.field2812.method1960(var2);
         this.method1662(this.field2815, this.field2816);
         this.method1704();
         this.method1708();
         return true;
      } else {
         return false;
      }
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "2120482340"
   )
   public void method1665() {
      this.field2805 = false;
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      descriptor = "(II)Z",
      garbageValue = "-1552754857"
   )
   public boolean method1666(int var1) {
      if (this.method1655(var1)) {
         this.method1732();
         class376 var2 = this.field2812.method1983((char)var1, this.field2809, this.field2811);
         this.method1672(var2.method1989(), var2.method1989());
         this.method1704();
         this.method1708();
      }

      return true;
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "1620308356"
   )
   public void method1667() {
      if (!this.method1732() && this.field2809 > 0) {
         int var1 = this.field2812.method1962(this.field2809 - 1);
         this.method1708();
         this.method1672(var1, var1);
      }

   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "-1088264884"
   )
   public void method1668() {
      if (!this.method1732() && this.field2809 < this.field2812.method1950()) {
         int var1 = this.field2812.method1962(this.field2809);
         this.method1708();
         this.method1672(var1, var1);
      }

   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "-672060695"
   )
   public void method1669() {
      if (!this.method1732() && this.field2809 > 0) {
         class451 var1 = this.method1702(this.field2809 - 1);
         int var2 = this.field2812.method1976((Integer)var1.field3892, this.field2809);
         this.method1708();
         this.method1672(var2, var2);
      }

   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "158006576"
   )
   public void method1691() {
      if (!this.method1732() && this.field2809 < this.field2812.method1950()) {
         class451 var1 = this.method1702(this.field2809);
         int var2 = this.field2812.method1976(this.field2809, (Integer)var1.field3893);
         this.method1708();
         this.method1672(var2, var2);
      }

   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      descriptor = "(B)Z",
      garbageValue = "60"
   )
   boolean method1732() {
      if (!this.method1701()) {
         return false;
      } else {
         int var1 = this.field2812.method1976(this.field2800, this.field2809);
         this.method1708();
         this.method1672(var1, var1);
         return true;
      }
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "105"
   )
   public void method1671() {
      this.method1672(0, this.field2812.method1950());
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      descriptor = "(III)Z",
      garbageValue = "-976822634"
   )
   public boolean method1672(int var1, int var2) {
      if (!this.method1694()) {
         this.field2800 = var1;
         this.field2809 = var2;
         return false;
      } else {
         if (var1 > this.field2812.method1950()) {
            var1 = this.field2812.method1950();
         }

         if (var2 > this.field2812.method1950()) {
            var2 = this.field2812.method1950();
         }

         boolean var3 = this.field2800 != var1 || var2 != this.field2809;
         this.field2800 = var1;
         if (var2 != this.field2809) {
            this.field2809 = var2;
            this.field2804 = 0;
            this.method1726();
         }

         if (var3 && this.field2818 != null) {
            this.field2818.vmethod5708();
         }

         return var3;
      }
   }

   @ObfuscatedName("bm")
   @ObfuscatedSignature(
      descriptor = "(ZB)V",
      garbageValue = "4"
   )
   public void method1724(boolean var1) {
      class451 var2 = this.method1703(this.field2809);
      this.method1705((Integer)var2.field3892, var1);
   }

   @ObfuscatedName("bv")
   @ObfuscatedSignature(
      descriptor = "(ZB)V",
      garbageValue = "1"
   )
   public void method1730(boolean var1) {
      class451 var2 = this.method1703(this.field2809);
      this.method1705((Integer)var2.field3893, var1);
   }

   @ObfuscatedName("bo")
   @ObfuscatedSignature(
      descriptor = "(ZI)V",
      garbageValue = "-1194970788"
   )
   public void method1710(boolean var1) {
      this.method1705(0, var1);
   }

   @ObfuscatedName("bs")
   @ObfuscatedSignature(
      descriptor = "(ZB)V",
      garbageValue = "32"
   )
   public void method1674(boolean var1) {
      this.method1705(this.field2812.method1950(), var1);
   }

   @ObfuscatedName("bg")
   @ObfuscatedSignature(
      descriptor = "(ZI)V",
      garbageValue = "1911929784"
   )
   public void method1675(boolean var1) {
      if (this.method1701() && !var1) {
         this.method1705(Math.min(this.field2800, this.field2809), var1);
      } else if (this.field2809 > 0) {
         this.method1705(this.field2809 - 1, var1);
      }

   }

   @ObfuscatedName("bh")
   @ObfuscatedSignature(
      descriptor = "(ZI)V",
      garbageValue = "-1578037568"
   )
   public void method1676(boolean var1) {
      if (this.method1701() && !var1) {
         this.method1705(Math.max(this.field2800, this.field2809), var1);
      } else if (this.field2809 < this.field2812.method1950()) {
         this.method1705(this.field2809 + 1, var1);
      }

   }

   @ObfuscatedName("bl")
   @ObfuscatedSignature(
      descriptor = "(ZI)V",
      garbageValue = "-1446997327"
   )
   public void method1677(boolean var1) {
      if (this.field2809 > 0) {
         class451 var2 = this.method1702(this.field2809 - 1);
         this.method1705((Integer)var2.field3892, var1);
      }

   }

   @ObfuscatedName("bk")
   @ObfuscatedSignature(
      descriptor = "(ZI)V",
      garbageValue = "-1939904884"
   )
   public void method1718(boolean var1) {
      if (this.field2809 < this.field2812.method1950()) {
         class451 var2 = this.method1702(this.field2809 + 1);
         this.method1705((Integer)var2.field3893, var1);
      }

   }

   @ObfuscatedName("br")
   @ObfuscatedSignature(
      descriptor = "(ZI)V",
      garbageValue = "2005118133"
   )
   public void method1659(boolean var1) {
      if (this.field2809 > 0) {
         this.method1705(this.field2812.method1964(this.field2809, -1), var1);
      }

   }

   @ObfuscatedName("ba")
   @ObfuscatedSignature(
      descriptor = "(ZI)V",
      garbageValue = "1910910611"
   )
   public void method1720(boolean var1) {
      if (this.field2809 < this.field2812.method1950()) {
         this.method1705(this.field2812.method1964(this.field2809, 1), var1);
      }

   }

   @ObfuscatedName("bz")
   @ObfuscatedSignature(
      descriptor = "(ZI)V",
      garbageValue = "2137080090"
   )
   public void method1697(boolean var1) {
      if (this.field2809 > 0) {
         int var2 = this.method1733();
         this.method1705(this.field2812.method1964(this.field2809, -var2), var1);
      }

   }

   @ObfuscatedName("bq")
   @ObfuscatedSignature(
      descriptor = "(ZI)V",
      garbageValue = "1881074040"
   )
   public void method1713(boolean var1) {
      if (this.field2809 < this.field2812.method1950()) {
         int var2 = this.method1733();
         this.method1705(this.field2812.method1964(this.field2809, var2), var1);
      }

   }

   @ObfuscatedName("bc")
   @ObfuscatedSignature(
      descriptor = "(ZI)V",
      garbageValue = "2036072619"
   )
   public void method1728(boolean var1) {
      class379 var2 = this.field2812.method1958(0, this.field2809);
      class451 var3 = var2.method2028();
      this.method1705(this.field2812.method1963((Integer)var3.field3892, this.field2816), var1);
   }

   @ObfuscatedName("bt")
   @ObfuscatedSignature(
      descriptor = "(ZI)V",
      garbageValue = "1382425470"
   )
   public void method1679(boolean var1) {
      class379 var2 = this.field2812.method1958(0, this.field2809);
      class451 var3 = var2.method2028();
      this.method1705(this.field2812.method1963((Integer)var3.field3892, this.field2816 + this.field2802), var1);
   }

   @ObfuscatedName("be")
   @ObfuscatedSignature(
      descriptor = "(IIZZI)V",
      garbageValue = "1883477450"
   )
   public void method1680(int var1, int var2, boolean var3, boolean var4) {
      boolean var5 = false;
      class451 var6;
      int var8;
      if (!this.field2805) {
         var8 = 0;
      } else {
         var1 += this.field2815;
         var2 += this.field2816;
         var6 = this.method1709();
         var8 = this.field2812.method1963(var1 - (Integer)var6.field3892, var2 - (Integer)var6.field3893);
      }

      if (var3 && var4) {
         this.field2807 = 1;
         var6 = this.method1702(var8);
         class451 var7 = this.method1702(this.field2810);
         this.method1719(var7, var6);
      } else if (var3) {
         this.field2807 = 1;
         var6 = this.method1702(var8);
         this.method1672((Integer)var6.field3892, (Integer)var6.field3893);
         this.field2810 = (Integer)var6.field3892;
      } else if (var4) {
         this.method1672(this.field2810, var8);
      } else {
         if (this.field2799 > 0 && var8 == this.field2810) {
            if (this.field2809 == this.field2800) {
               this.field2807 = 1;
               var6 = this.method1702(var8);
               this.method1672((Integer)var6.field3892, (Integer)var6.field3893);
            } else {
               this.field2807 = 2;
               var6 = this.method1703(var8);
               this.method1672((Integer)var6.field3892, (Integer)var6.field3893);
            }
         } else {
            this.field2807 = 0;
            this.method1672(var8, var8);
            this.field2810 = var8;
         }

         this.field2799 = 25;
      }

   }

   @ObfuscatedName("bu")
   @ObfuscatedSignature(
      descriptor = "(IIB)V",
      garbageValue = "1"
   )
   public void method1681(int var1, int var2) {
      if (this.field2805 && this.method1721()) {
         var1 += this.field2815;
         var2 += this.field2816;
         class451 var3 = this.method1709();
         int var4 = this.field2812.method1963(var1 - (Integer)var3.field3892, var2 - (Integer)var3.field3893);
         class451 var5;
         class451 var6;
         switch(this.field2807) {
         case 0:
            this.method1672(this.field2800, var4);
            break;
         case 1:
            var5 = this.method1702(this.field2810);
            var6 = this.method1702(var4);
            this.method1719(var5, var6);
            break;
         case 2:
            var5 = this.method1703(this.field2810);
            var6 = this.method1703(var4);
            this.method1719(var5, var6);
         }
      }

   }

   @ObfuscatedName("bd")
   @ObfuscatedSignature(
      descriptor = "(Ljava/awt/datatransfer/Clipboard;B)V",
      garbageValue = "-56"
   )
   public void method1682(Clipboard var1) {
      class379 var2 = this.field2812.method1958(this.field2800, this.field2809);
      if (!var2.method2023()) {
         String var3 = var2.method2021();
         if (!var3.isEmpty()) {
            var1.setContents(new StringSelection(var3), (ClipboardOwner)null);
         }
      }

   }

   @ObfuscatedName("by")
   @ObfuscatedSignature(
      descriptor = "(Ljava/awt/datatransfer/Clipboard;B)V",
      garbageValue = "-82"
   )
   public void method1731(Clipboard var1) {
      if (this.method1701()) {
         this.method1682(var1);
         this.method1732();
      }

   }

   @ObfuscatedName("bp")
   @ObfuscatedSignature(
      descriptor = "(Ljava/awt/datatransfer/Clipboard;B)V",
      garbageValue = "63"
   )
   public void method1684(Clipboard var1) {
      Transferable var2 = var1.getContents((Object)null);
      if (var2 != null && var2.isDataFlavorSupported(DataFlavor.stringFlavor)) {
         try {
            String var3 = this.method1673((String)var2.getTransferData(DataFlavor.stringFlavor));
            this.method1732();
            class376 var4 = this.field2812.method1971(var3, this.field2809, this.field2811);
            this.method1672(var4.method1989(), var4.method1989());
            this.method1704();
            this.method1708();
         } catch (Exception var5) {
            System.out.println("Error pasting clipboard to InputField.");
         }
      }

   }

   @ObfuscatedName("bb")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "26"
   )
   public void method1685() {
      this.field2816 = Math.max(0, this.field2816 - this.field2812.method1967());
   }

   @ObfuscatedName("bx")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "1569086073"
   )
   public void method1683() {
      int var1 = Math.max(0, this.field2812.method1966() - this.field2802);
      this.field2816 = Math.min(var1, this.field2816 + this.field2812.method1967());
   }

   @ObfuscatedName("bn")
   @ObfuscatedSignature(
      descriptor = "(Lll;B)V",
      garbageValue = "-73"
   )
   public void method1678(class304 var1) {
      this.field2814 = var1;
   }

   @ObfuscatedName("bj")
   @ObfuscatedSignature(
      descriptor = "(Lll;B)V",
      garbageValue = "-5"
   )
   public void method1687(class304 var1) {
      this.field2818 = var1;
   }

   @ObfuscatedName("bf")
   @ObfuscatedSignature(
      descriptor = "(I)Low;",
      garbageValue = "1262168662"
   )
   public class375 method1688() {
      return this.field2812;
   }

   @ObfuscatedName("bw")
   @ObfuscatedSignature(
      descriptor = "(I)Low;",
      garbageValue = "2112515776"
   )
   public class375 method1689() {
      return this.field2801;
   }

   @ObfuscatedName("bi")
   @ObfuscatedSignature(
      descriptor = "(I)Lon;",
      garbageValue = "1325696613"
   )
   public class379 method1690() {
      return this.field2812.method1958(this.field2800, this.field2809);
   }

   @ObfuscatedName("cl")
   @ObfuscatedSignature(
      descriptor = "(I)Z",
      garbageValue = "-549820891"
   )
   public boolean method1721() {
      return this.field2798;
   }

   @ObfuscatedName("ca")
   @ObfuscatedSignature(
      descriptor = "(B)Z",
      garbageValue = "3"
   )
   public boolean method1715() {
      return this.field2803;
   }

   @ObfuscatedName("cb")
   @ObfuscatedSignature(
      descriptor = "(B)Z",
      garbageValue = "-71"
   )
   public boolean method1692() {
      return this.method1721() && this.field2804 % 60 < 30;
   }

   @ObfuscatedName("co")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "1567314781"
   )
   public int method1693() {
      return this.field2809;
   }

   @ObfuscatedName("cj")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "752181260"
   )
   public int method1729() {
      return this.field2800;
   }

   @ObfuscatedName("cn")
   @ObfuscatedSignature(
      descriptor = "(I)Z",
      garbageValue = "-435556851"
   )
   public boolean method1694() {
      return this.field2805;
   }

   @ObfuscatedName("ce")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "875824176"
   )
   public int method1695() {
      return this.field2815;
   }

   @ObfuscatedName("cd")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "151655806"
   )
   public int method1722() {
      return this.field2816;
   }

   @ObfuscatedName("cc")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "1709224599"
   )
   public int method1696() {
      return this.field2812.method1970();
   }

   @ObfuscatedName("ct")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "-50256780"
   )
   public int method1656() {
      return this.field2812.method1981();
   }

   @ObfuscatedName("cy")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "-250886570"
   )
   public int method1699() {
      return this.field2817;
   }

   @ObfuscatedName("ck")
   @ObfuscatedSignature(
      descriptor = "(B)I",
      garbageValue = "16"
   )
   public int method1698() {
      return this.field2806;
   }

   @ObfuscatedName("cz")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "-1805162168"
   )
   public int method1712() {
      return this.field2812.method1972();
   }

   @ObfuscatedName("cg")
   @ObfuscatedSignature(
      descriptor = "(S)I",
      garbageValue = "29919"
   )
   public int method1700() {
      return this.field2808;
   }

   @ObfuscatedName("ch")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "-1565778570"
   )
   public int method1717() {
      return this.field2812.method1986();
   }

   @ObfuscatedName("cs")
   @ObfuscatedSignature(
      descriptor = "(I)Z",
      garbageValue = "2045196166"
   )
   public boolean method1707() {
      return this.method1656() > 1;
   }

   @ObfuscatedName("cq")
   @ObfuscatedSignature(
      descriptor = "(I)Z",
      garbageValue = "-2138172639"
   )
   boolean method1701() {
      return this.field2800 != this.field2809;
   }

   @ObfuscatedName("cx")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;I)Ljava/lang/String;",
      garbageValue = "-1725028844"
   )
   String method1673(String var1) {
      StringBuilder var2 = new StringBuilder(var1.length());

      for(int var3 = 0; var3 < var1.length(); ++var3) {
         char var4 = var1.charAt(var3);
         if (this.method1655(var4)) {
            var2.append(var4);
         }
      }

      return var2.toString();
   }

   @ObfuscatedName("cu")
   @ObfuscatedSignature(
      descriptor = "(Lrv;Lrv;I)V",
      garbageValue = "-418592345"
   )
   void method1719(class451 var1, class451 var2) {
      if ((Integer)var2.field3892 < (Integer)var1.field3892) {
         this.method1672((Integer)var1.field3893, (Integer)var2.field3892);
      } else {
         this.method1672((Integer)var1.field3892, (Integer)var2.field3893);
      }

   }

   @ObfuscatedName("cm")
   @ObfuscatedSignature(
      descriptor = "(IB)Lrv;",
      garbageValue = "-68"
   )
   class451 method1702(int var1) {
      int var2 = this.field2812.method1950();
      int var3 = 0;
      int var4 = var2;

      int var5;
      for(var5 = var1; var5 > 0; --var5) {
         if (this.method1725(this.field2812.method1987(var5 - 1).field3577)) {
            var3 = var5;
            break;
         }
      }

      for(var5 = var1; var5 < var2; ++var5) {
         if (this.method1725(this.field2812.method1987(var5).field3577)) {
            var4 = var5;
            break;
         }
      }

      return new class451(var3, var4);
   }

   @ObfuscatedName("cw")
   @ObfuscatedSignature(
      descriptor = "(IB)Lrv;",
      garbageValue = "61"
   )
   class451 method1703(int var1) {
      int var2 = this.field2812.method1950();
      int var3 = 0;
      int var4 = var2;

      int var5;
      for(var5 = var1; var5 > 0; --var5) {
         if (this.field2812.method1987(var5 - 1).field3577 == '\n') {
            var3 = var5;
            break;
         }
      }

      for(var5 = var1; var5 < var2; ++var5) {
         if (this.field2812.method1987(var5).field3577 == '\n') {
            var4 = var5;
            break;
         }
      }

      return new class451(var3, var4);
   }

   @ObfuscatedName("cp")
   @ObfuscatedSignature(
      descriptor = "(B)Z",
      garbageValue = "0"
   )
   boolean method1704() {
      if (!this.method1694()) {
         return false;
      } else {
         boolean var1 = false;
         if (this.field2812.method1950() > this.field2817) {
            this.field2812.method1976(this.field2817, this.field2812.method1950());
            var1 = true;
         }

         int var2 = this.method1656();
         int var3;
         if (this.field2812.method1968() > var2) {
            var3 = this.field2812.method1964(0, var2) - 1;
            this.field2812.method1976(var3, this.field2812.method1950());
            var1 = true;
         }

         if (var1) {
            var3 = this.field2809;
            int var4 = this.field2800;
            int var5 = this.field2812.method1950();
            if (this.field2809 > var5) {
               var3 = var5;
            }

            if (this.field2800 > var5) {
               var4 = var5;
            }

            this.method1672(var4, var3);
         }

         return var1;
      }
   }

   @ObfuscatedName("ci")
   @ObfuscatedSignature(
      descriptor = "(IZI)V",
      garbageValue = "-838795897"
   )
   void method1705(int var1, boolean var2) {
      if (var2) {
         this.method1672(this.field2800, var1);
      } else {
         this.method1672(var1, var1);
      }

   }

   @ObfuscatedName("cf")
   @ObfuscatedSignature(
      descriptor = "(S)I",
      garbageValue = "3157"
   )
   int method1733() {
      return this.field2802 / this.field2812.method1967();
   }

   @ObfuscatedName("cv")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "2005598872"
   )
   void method1726() {
      class379 var1 = this.field2812.method1958(0, this.field2809);
      class451 var2 = var1.method2028();
      int var3 = this.field2812.method1967();
      int var4 = (Integer)var2.field3892 - 10;
      int var5 = var4 + 20;
      int var6 = (Integer)var2.field3893 - 3;
      int var7 = var6 + var3 + 6;
      int var8 = this.field2815;
      int var9 = var8 + this.field2813;
      int var10 = this.field2816;
      int var11 = var10 + this.field2802;
      int var12 = this.field2815;
      int var13 = this.field2816;
      if (var4 < var8) {
         var12 = var4;
      } else if (var5 > var9) {
         var12 = var5 - this.field2813;
      }

      if (var6 < var10) {
         var13 = var6;
      } else if (var7 > var11) {
         var13 = var7 - this.field2802;
      }

      this.method1662(var12, var13);
   }

   @ObfuscatedName("cr")
   @ObfuscatedSignature(
      descriptor = "(IB)Z",
      garbageValue = "85"
   )
   boolean method1725(int var1) {
      return var1 == 32 || var1 == 10 || var1 == 9;
   }

   @ObfuscatedName("du")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "14181552"
   )
   void method1708() {
      if (this.field2814 != null) {
         this.field2814.vmethod5708();
      }

   }

   @ObfuscatedName("dg")
   @ObfuscatedSignature(
      descriptor = "(II)Z",
      garbageValue = "15719519"
   )
   boolean method1655(int var1) {
      switch(this.field2808) {
      case 1:
         return PlayerComposition.isAlphaNumeric((char)var1);
      case 2:
         return ArchiveDiskAction.isCharAlphabetic((char)var1);
      case 3:
         return class28.isDigit((char)var1);
      case 4:
         char var2 = (char)var1;
         if (class28.isDigit(var2)) {
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

   @ObfuscatedName("dc")
   @ObfuscatedSignature(
      descriptor = "(B)Lrv;",
      garbageValue = "9"
   )
   class451 method1709() {
      int var1 = this.field2812.method1982(this.field2813);
      int var2 = this.field2812.method1977(this.field2802);
      return new class451(var1, var2);
   }
}
