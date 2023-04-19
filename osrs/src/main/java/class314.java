import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("mz")
public class class314 {
   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      descriptor = "Loq;"
   )
   class379 field2851 = new class379();
   @ObfuscatedName("am")
   @ObfuscatedSignature(
      descriptor = "Loq;"
   )
   class379 field2850 = new class379();
   @ObfuscatedName("as")
   boolean field2845 = false;
   @ObfuscatedName("aj")
   boolean field2846 = true;
   @ObfuscatedName("ak")
   int field2847 = 0;
   @ObfuscatedName("az")
   boolean field2848 = false;
   @ObfuscatedName("ad")
   int field2849 = 0;
   @ObfuscatedName("ae")
   int field2860 = 0;
   @ObfuscatedName("ap")
   int field2844 = 0;
   @ObfuscatedName("by")
   int field2852 = 0;
   @ObfuscatedName("bb")
   int field2853 = 0;
   @ObfuscatedName("bi")
   int field2854 = 0;
   @ObfuscatedName("be")
   int field2855 = 0;
   @ObfuscatedName("bk")
   int field2856 = Integer.MAX_VALUE;
   @ObfuscatedName("bx")
   int field2857 = Integer.MAX_VALUE;
   @ObfuscatedName("bo")
   int field2842 = 0;
   @ObfuscatedName("bz")
   int field2858 = 0;
   @ObfuscatedName("bm")
   int field2859 = 0;
   @ObfuscatedName("bd")
   int field2843 = 0;
   @ObfuscatedName("bt")
   @ObfuscatedSignature(
      descriptor = "Llx;"
   )
   class308 field2861;
   @ObfuscatedName("bj")
   @ObfuscatedSignature(
      descriptor = "Llx;"
   )
   class308 field2862;

   class314() {
      this.field2851.method2009(1);
      this.field2850.method2009(1);
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "-76"
   )
   void method1779() {
      this.field2847 = (this.field2847 + 1) % 60;
      if (this.field2855 > 0) {
         --this.field2855;
      }

   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "(ZI)Z",
      garbageValue = "-825756514"
   )
   public boolean method1706(boolean var1) {
      var1 = var1 && this.field2846;
      boolean var2 = this.field2845 != var1;
      this.field2845 = var1;
      if (!this.field2845) {
         this.method1725(this.field2852, this.field2852);
      }

      return var2;
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      descriptor = "(ZI)V",
      garbageValue = "1575779976"
   )
   public void method1707(boolean var1) {
      this.field2846 = var1;
      this.field2845 = var1 && this.field2845;
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;I)Z",
      garbageValue = "1247495644"
   )
   boolean method1708(String var1) {
      String var2 = this.field2851.method2007();
      if (!var2.equals(var1)) {
         var1 = this.method1757(var1);
         this.field2851.method2014(var1);
         this.method1713(this.field2859, this.field2843);
         this.method1761();
         this.method1766();
         return true;
      } else {
         return false;
      }
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;B)Z",
      garbageValue = "2"
   )
   boolean method1709(String var1) {
      this.field2850.method2014(var1);
      return true;
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "(Lou;I)Z",
      garbageValue = "1219787460"
   )
   boolean method1737(AbstractFont var1) {
      boolean var2 = !this.field2848;
      this.field2851.method2037(var1);
      this.field2850.method2037(var1);
      this.field2848 = true;
      var2 |= this.method1713(this.field2859, this.field2843);
      var2 |= this.method1725(this.field2853, this.field2852);
      if (this.method1761()) {
         this.method1766();
         var2 = true;
      }

      return var2;
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      descriptor = "(IIB)Z",
      garbageValue = "63"
   )
   public boolean method1710(int var1, int var2) {
      boolean var3 = this.field2842 != var1 || var2 != this.field2858;
      this.field2842 = var1;
      this.field2858 = var2;
      var3 |= this.method1713(this.field2859, this.field2843);
      return var3;
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "(II)Z",
      garbageValue = "2034737462"
   )
   public boolean method1711(int var1) {
      if (var1 < 0) {
         var1 = Integer.MAX_VALUE;
      }

      boolean var2 = var1 == this.field2851.method2038();
      this.field2851.method2033(var1);
      this.field2850.method2033(var1);
      if (this.method1761()) {
         this.method1766();
         var2 = true;
      }

      return var2;
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      descriptor = "(IB)Z",
      garbageValue = "16"
   )
   public boolean method1784(int var1) {
      this.field2851.method2003(var1);
      if (this.method1761()) {
         this.method1766();
         return true;
      } else {
         return false;
      }
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      descriptor = "(II)Z",
      garbageValue = "-1888462912"
   )
   public boolean method1712(int var1) {
      this.field2857 = var1;
      if (this.method1761()) {
         this.method1766();
         return true;
      } else {
         return false;
      }
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      descriptor = "(IIB)Z",
      garbageValue = "24"
   )
   public boolean method1713(int var1, int var2) {
      if (!this.method1748()) {
         this.field2859 = var1;
         this.field2843 = var2;
         return false;
      } else {
         int var3 = this.field2859;
         int var4 = this.field2843;
         int var5 = Math.max(0, this.field2851.method2019() - this.field2842 + 2);
         int var6 = Math.max(0, this.field2851.method2020() - this.field2858 + 1);
         this.field2859 = Math.max(0, Math.min(var5, var1));
         this.field2843 = Math.max(0, Math.min(var6, var2));
         return var3 != this.field2859 || var4 != this.field2843;
      }
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      descriptor = "(III)Z",
      garbageValue = "1553777879"
   )
   public boolean method1714(int var1, int var2) {
      boolean var3 = true;
      if (var1 < 0 || var1 > 2) {
         var3 = false;
      }

      if (var2 < 0 || var2 > 2) {
         var3 = false;
      }

      return var3 ? this.field2851.method2010(var1, var2) : false;
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      descriptor = "(II)V",
      garbageValue = "2084045870"
   )
   public void method1715(int var1) {
      this.field2851.method2011(var1);
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      descriptor = "(II)V",
      garbageValue = "-1564790862"
   )
   public void method1705(int var1) {
      this.field2849 = var1;
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      descriptor = "(II)V",
      garbageValue = "1444501030"
   )
   public void method1717(int var1) {
      this.field2851.method2009(var1);
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      descriptor = "(IS)V",
      garbageValue = "-6347"
   )
   public void method1718(int var1) {
      this.field2851.method2029(var1);
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      descriptor = "(IB)Z",
      garbageValue = "59"
   )
   public boolean method1719(int var1) {
      this.field2844 = var1;
      String var2 = this.field2851.method2007();
      int var3 = var2.length();
      var2 = this.method1757(var2);
      if (var2.length() != var3) {
         this.field2851.method2014(var2);
         this.method1713(this.field2859, this.field2843);
         this.method1761();
         this.method1766();
         return true;
      } else {
         return false;
      }
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "-83630880"
   )
   public void method1771() {
      this.field2848 = false;
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      descriptor = "(II)Z",
      garbageValue = "-337201766"
   )
   public boolean method1720(int var1) {
      if (this.method1765(var1)) {
         this.method1723();
         class380 var2 = this.field2851.method2032((char)var1, this.field2852, this.field2856);
         this.method1725(var2.method2044(), var2.method2044());
         this.method1761();
         this.method1766();
      }

      return true;
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "1712590947"
   )
   public void method1770() {
      if (!this.method1723() && this.field2852 > 0) {
         int var1 = this.field2851.method2015(this.field2852 - 1);
         this.method1766();
         this.method1725(var1, var1);
      }

   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "-11"
   )
   public void method1768() {
      if (!this.method1723() && this.field2852 < this.field2851.method2006()) {
         int var1 = this.field2851.method2015(this.field2852);
         this.method1766();
         this.method1725(var1, var1);
      }

   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "-1555798008"
   )
   public void method1780() {
      if (!this.method1723() && this.field2852 > 0) {
         class461 var1 = this.method1759(this.field2852 - 1);
         int var2 = this.field2851.method2016((Integer)var1.field3972, this.field2852);
         this.method1766();
         this.method1725(var2, var2);
      }

   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "-2132510379"
   )
   public void method1785() {
      if (!this.method1723() && this.field2852 < this.field2851.method2006()) {
         class461 var1 = this.method1759(this.field2852);
         int var2 = this.field2851.method2016(this.field2852, (Integer)var1.field3973);
         this.method1766();
         this.method1725(var2, var2);
      }

   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      descriptor = "(I)Z",
      garbageValue = "1772299463"
   )
   boolean method1723() {
      if (!this.method1756()) {
         return false;
      } else {
         int var1 = this.field2851.method2016(this.field2853, this.field2852);
         this.method1766();
         this.method1725(var1, var1);
         return true;
      }
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "-26"
   )
   public void method1787() {
      this.method1725(0, this.field2851.method2006());
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      descriptor = "(IIB)Z",
      garbageValue = "19"
   )
   public boolean method1725(int var1, int var2) {
      if (!this.method1748()) {
         this.field2853 = var1;
         this.field2852 = var2;
         return false;
      } else {
         if (var1 > this.field2851.method2006()) {
            var1 = this.field2851.method2006();
         }

         if (var2 > this.field2851.method2006()) {
            var2 = this.field2851.method2006();
         }

         boolean var3 = this.field2853 != var1 || var2 != this.field2852;
         this.field2853 = var1;
         if (var2 != this.field2852) {
            this.field2852 = var2;
            this.field2847 = 0;
            this.method1764();
         }

         if (var3 && this.field2862 != null) {
            this.field2862.vmethod5708();
         }

         return var3;
      }
   }

   @ObfuscatedName("by")
   @ObfuscatedSignature(
      descriptor = "(ZI)V",
      garbageValue = "-994542859"
   )
   public void method1722(boolean var1) {
      class461 var2 = this.method1760(this.field2852);
      this.method1762((Integer)var2.field3972, var1);
   }

   @ObfuscatedName("bb")
   @ObfuscatedSignature(
      descriptor = "(ZI)V",
      garbageValue = "-84102297"
   )
   public void method1772(boolean var1) {
      class461 var2 = this.method1760(this.field2852);
      this.method1762((Integer)var2.field3973, var1);
   }

   @ObfuscatedName("bi")
   @ObfuscatedSignature(
      descriptor = "(ZB)V",
      garbageValue = "78"
   )
   public void method1726(boolean var1) {
      this.method1762(0, var1);
   }

   @ObfuscatedName("be")
   @ObfuscatedSignature(
      descriptor = "(ZB)V",
      garbageValue = "-19"
   )
   public void method1773(boolean var1) {
      this.method1762(this.field2851.method2006(), var1);
   }

   @ObfuscatedName("bk")
   @ObfuscatedSignature(
      descriptor = "(ZI)V",
      garbageValue = "728659002"
   )
   public void method1728(boolean var1) {
      if (this.method1756() && !var1) {
         this.method1762(Math.min(this.field2853, this.field2852), var1);
      } else if (this.field2852 > 0) {
         this.method1762(this.field2852 - 1, var1);
      }

   }

   @ObfuscatedName("bx")
   @ObfuscatedSignature(
      descriptor = "(ZI)V",
      garbageValue = "-1785240009"
   )
   public void method1729(boolean var1) {
      if (this.method1756() && !var1) {
         this.method1762(Math.max(this.field2853, this.field2852), var1);
      } else if (this.field2852 < this.field2851.method2006()) {
         this.method1762(this.field2852 + 1, var1);
      }

   }

   @ObfuscatedName("bo")
   @ObfuscatedSignature(
      descriptor = "(ZI)V",
      garbageValue = "355798212"
   )
   public void method1786(boolean var1) {
      if (this.field2852 > 0) {
         class461 var2 = this.method1759(this.field2852 - 1);
         this.method1762((Integer)var2.field3972, var1);
      }

   }

   @ObfuscatedName("bz")
   @ObfuscatedSignature(
      descriptor = "(ZB)V",
      garbageValue = "3"
   )
   public void method1730(boolean var1) {
      if (this.field2852 < this.field2851.method2006()) {
         class461 var2 = this.method1759(this.field2852 + 1);
         this.method1762((Integer)var2.field3973, var1);
      }

   }

   @ObfuscatedName("bm")
   @ObfuscatedSignature(
      descriptor = "(ZB)V",
      garbageValue = "52"
   )
   public void method1731(boolean var1) {
      if (this.field2852 > 0) {
         this.method1762(this.field2851.method2018(this.field2852, -1), var1);
      }

   }

   @ObfuscatedName("bd")
   @ObfuscatedSignature(
      descriptor = "(ZB)V",
      garbageValue = "-45"
   )
   public void method1732(boolean var1) {
      if (this.field2852 < this.field2851.method2006()) {
         this.method1762(this.field2851.method2018(this.field2852, 1), var1);
      }

   }

   @ObfuscatedName("bt")
   @ObfuscatedSignature(
      descriptor = "(ZB)V",
      garbageValue = "1"
   )
   public void method1733(boolean var1) {
      if (this.field2852 > 0) {
         int var2 = this.method1763();
         this.method1762(this.field2851.method2018(this.field2852, -var2), var1);
      }

   }

   @ObfuscatedName("bj")
   @ObfuscatedSignature(
      descriptor = "(ZS)V",
      garbageValue = "12979"
   )
   public void method1721(boolean var1) {
      if (this.field2852 < this.field2851.method2006()) {
         int var2 = this.method1763();
         this.method1762(this.field2851.method2018(this.field2852, var2), var1);
      }

   }

   @ObfuscatedName("bn")
   @ObfuscatedSignature(
      descriptor = "(ZI)V",
      garbageValue = "-1605724073"
   )
   public void method1734(boolean var1) {
      class383 var2 = this.field2851.method2035(0, this.field2852);
      class461 var3 = var2.method2077();
      this.method1762(this.field2851.method2017((Integer)var3.field3972, this.field2843), var1);
   }

   @ObfuscatedName("bs")
   @ObfuscatedSignature(
      descriptor = "(ZI)V",
      garbageValue = "1731882601"
   )
   public void method1724(boolean var1) {
      class383 var2 = this.field2851.method2035(0, this.field2852);
      class461 var3 = var2.method2077();
      this.method1762(this.field2851.method2017((Integer)var3.field3972, this.field2858 + this.field2843), var1);
   }

   @ObfuscatedName("br")
   @ObfuscatedSignature(
      descriptor = "(IIZZI)V",
      garbageValue = "1549873407"
   )
   public void method1735(int var1, int var2, boolean var3, boolean var4) {
      boolean var5 = false;
      class461 var6;
      int var8;
      if (!this.field2848) {
         var8 = 0;
      } else {
         var1 += this.field2859;
         var2 += this.field2843;
         var6 = this.method1767();
         var8 = this.field2851.method2017(var1 - (Integer)var6.field3972, var2 - (Integer)var6.field3973);
      }

      if (var3 && var4) {
         this.field2860 = 1;
         var6 = this.method1759(var8);
         class461 var7 = this.method1759(this.field2854);
         this.method1758(var7, var6);
      } else if (var3) {
         this.field2860 = 1;
         var6 = this.method1759(var8);
         this.method1725((Integer)var6.field3972, (Integer)var6.field3973);
         this.field2854 = (Integer)var6.field3972;
      } else if (var4) {
         this.method1725(this.field2854, var8);
      } else {
         if (this.field2855 > 0 && var8 == this.field2854) {
            if (this.field2853 == this.field2852) {
               this.field2860 = 1;
               var6 = this.method1759(var8);
               this.method1725((Integer)var6.field3972, (Integer)var6.field3973);
            } else {
               this.field2860 = 2;
               var6 = this.method1760(var8);
               this.method1725((Integer)var6.field3972, (Integer)var6.field3973);
            }
         } else {
            this.field2860 = 0;
            this.method1725(var8, var8);
            this.field2854 = var8;
         }

         this.field2855 = 25;
      }

   }

   @ObfuscatedName("bg")
   @ObfuscatedSignature(
      descriptor = "(III)V",
      garbageValue = "915076242"
   )
   public void method1727(int var1, int var2) {
      if (this.field2848 && this.method1743()) {
         var1 += this.field2859;
         var2 += this.field2843;
         class461 var3 = this.method1767();
         int var4 = this.field2851.method2017(var1 - (Integer)var3.field3972, var2 - (Integer)var3.field3973);
         class461 var5;
         class461 var6;
         switch(this.field2860) {
         case 0:
            this.method1725(this.field2853, var4);
            break;
         case 1:
            var5 = this.method1759(this.field2854);
            var6 = this.method1759(var4);
            this.method1758(var5, var6);
            break;
         case 2:
            var5 = this.method1760(this.field2854);
            var6 = this.method1760(var4);
            this.method1758(var5, var6);
         }
      }

   }

   @ObfuscatedName("bu")
   @ObfuscatedSignature(
      descriptor = "(Ljava/awt/datatransfer/Clipboard;B)V",
      garbageValue = "36"
   )
   public void method1736(Clipboard var1) {
      class383 var2 = this.field2851.method2035(this.field2853, this.field2852);
      if (!var2.method2078()) {
         String var3 = var2.method2083();
         if (!var3.isEmpty()) {
            var1.setContents(new StringSelection(var3), (ClipboardOwner)null);
         }
      }

   }

   @ObfuscatedName("bf")
   @ObfuscatedSignature(
      descriptor = "(Ljava/awt/datatransfer/Clipboard;B)V",
      garbageValue = "107"
   )
   public void method1776(Clipboard var1) {
      if (this.method1756()) {
         this.method1736(var1);
         this.method1723();
      }

   }

   @ObfuscatedName("bq")
   @ObfuscatedSignature(
      descriptor = "(Ljava/awt/datatransfer/Clipboard;I)V",
      garbageValue = "-1794913499"
   )
   public void method1738(Clipboard var1) {
      Transferable var2 = var1.getContents((Object)null);
      if (var2 != null && var2.isDataFlavorSupported(DataFlavor.stringFlavor)) {
         try {
            String var3 = this.method1757((String)var2.getTransferData(DataFlavor.stringFlavor));
            this.method1723();
            class380 var4 = this.field2851.method2012(var3, this.field2852, this.field2856);
            this.method1725(var4.method2044(), var4.method2044());
            this.method1761();
            this.method1766();
         } catch (Exception var5) {
            ;
         }
      }

   }

   @ObfuscatedName("ba")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "113728735"
   )
   public void method1777() {
      this.field2843 = Math.max(0, this.field2843 - this.field2851.method2041());
   }

   @ObfuscatedName("bv")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "113"
   )
   public void method1778() {
      int var1 = Math.max(0, this.field2851.method2020() - this.field2858);
      this.field2843 = Math.min(var1, this.field2843 + this.field2851.method2041());
   }

   @ObfuscatedName("bl")
   @ObfuscatedSignature(
      descriptor = "(Llx;I)V",
      garbageValue = "-1866870049"
   )
   public void method1739(class308 var1) {
      this.field2861 = var1;
   }

   @ObfuscatedName("bp")
   @ObfuscatedSignature(
      descriptor = "(Llx;I)V",
      garbageValue = "-1257923429"
   )
   public void method1775(class308 var1) {
      this.field2862 = var1;
   }

   @ObfuscatedName("bc")
   @ObfuscatedSignature(
      descriptor = "(I)Loq;",
      garbageValue = "-1995273155"
   )
   public class379 method1740() {
      return this.field2851;
   }

   @ObfuscatedName("bh")
   @ObfuscatedSignature(
      descriptor = "(B)Loq;",
      garbageValue = "-94"
   )
   public class379 method1741() {
      return this.field2850;
   }

   @ObfuscatedName("bw")
   @ObfuscatedSignature(
      descriptor = "(I)Loa;",
      garbageValue = "2061234095"
   )
   public class383 method1742() {
      return this.field2851.method2035(this.field2853, this.field2852);
   }

   @ObfuscatedName("ce")
   @ObfuscatedSignature(
      descriptor = "(I)Z",
      garbageValue = "1877239255"
   )
   public boolean method1743() {
      return this.field2845;
   }

   @ObfuscatedName("ci")
   @ObfuscatedSignature(
      descriptor = "(I)Z",
      garbageValue = "1994580892"
   )
   public boolean method1744() {
      return this.field2846;
   }

   @ObfuscatedName("cs")
   @ObfuscatedSignature(
      descriptor = "(B)Z",
      garbageValue = "-30"
   )
   public boolean method1745() {
      return this.method1743() && this.field2847 % 60 < 30;
   }

   @ObfuscatedName("cc")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "-483082370"
   )
   public int method1746() {
      return this.field2852;
   }

   @ObfuscatedName("cn")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "-1050882526"
   )
   public int method1747() {
      return this.field2853;
   }

   @ObfuscatedName("ca")
   @ObfuscatedSignature(
      descriptor = "(I)Z",
      garbageValue = "32293634"
   )
   public boolean method1748() {
      return this.field2848;
   }

   @ObfuscatedName("cu")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "-57692379"
   )
   public int method1769() {
      return this.field2859;
   }

   @ObfuscatedName("ck")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "-91399205"
   )
   public int method1781() {
      return this.field2843;
   }

   @ObfuscatedName("cq")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "-1594572507"
   )
   public int method1749() {
      return this.field2851.method2038();
   }

   @ObfuscatedName("cm")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "-2023379849"
   )
   public int method1783() {
      return this.field2851.method2022();
   }

   @ObfuscatedName("cf")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "1424429838"
   )
   public int method1716() {
      return this.field2857;
   }

   @ObfuscatedName("cl")
   @ObfuscatedSignature(
      descriptor = "(B)I",
      garbageValue = "-111"
   )
   public int method1752() {
      return this.field2849;
   }

   @ObfuscatedName("cg")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "-1783004580"
   )
   public int method1751() {
      return this.field2851.method2034();
   }

   @ObfuscatedName("cr")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "2117890366"
   )
   public int method1753() {
      return this.field2844;
   }

   @ObfuscatedName("cy")
   @ObfuscatedSignature(
      descriptor = "(B)I",
      garbageValue = "-72"
   )
   public int method1754() {
      return this.field2851.method2024();
   }

   @ObfuscatedName("cx")
   @ObfuscatedSignature(
      descriptor = "(I)Z",
      garbageValue = "-1129098287"
   )
   public boolean method1755() {
      return this.method1783() > 1;
   }

   @ObfuscatedName("cv")
   @ObfuscatedSignature(
      descriptor = "(I)Z",
      garbageValue = "-306594009"
   )
   boolean method1756() {
      return this.field2853 != this.field2852;
   }

   @ObfuscatedName("cb")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;B)Ljava/lang/String;",
      garbageValue = "83"
   )
   String method1757(String var1) {
      StringBuilder var2 = new StringBuilder(var1.length());

      for(int var3 = 0; var3 < var1.length(); ++var3) {
         char var4 = var1.charAt(var3);
         if (this.method1765(var4)) {
            var2.append(var4);
         }
      }

      return var2.toString();
   }

   @ObfuscatedName("co")
   @ObfuscatedSignature(
      descriptor = "(Lrg;Lrg;I)V",
      garbageValue = "1153538536"
   )
   void method1758(class461 var1, class461 var2) {
      if ((Integer)var2.field3972 < (Integer)var1.field3972) {
         this.method1725((Integer)var1.field3973, (Integer)var2.field3972);
      } else {
         this.method1725((Integer)var1.field3972, (Integer)var2.field3973);
      }

   }

   @ObfuscatedName("cz")
   @ObfuscatedSignature(
      descriptor = "(IB)Lrg;",
      garbageValue = "-128"
   )
   class461 method1759(int var1) {
      int var2 = this.field2851.method2006();
      int var3 = 0;
      int var4 = var2;

      int var5;
      for(var5 = var1; var5 > 0; --var5) {
         if (this.method1782(this.field2851.method2002(var5 - 1).field3624)) {
            var3 = var5;
            break;
         }
      }

      for(var5 = var1; var5 < var2; ++var5) {
         if (this.method1782(this.field2851.method2002(var5).field3624)) {
            var4 = var5;
            break;
         }
      }

      return new class461(var3, var4);
   }

   @ObfuscatedName("cw")
   @ObfuscatedSignature(
      descriptor = "(II)Lrg;",
      garbageValue = "-600467207"
   )
   class461 method1760(int var1) {
      int var2 = this.field2851.method2006();
      int var3 = 0;
      int var4 = var2;

      int var5;
      for(var5 = var1; var5 > 0; --var5) {
         if (this.field2851.method2002(var5 - 1).field3624 == '\n') {
            var3 = var5;
            break;
         }
      }

      for(var5 = var1; var5 < var2; ++var5) {
         if (this.field2851.method2002(var5).field3624 == '\n') {
            var4 = var5;
            break;
         }
      }

      return new class461(var3, var4);
   }

   @ObfuscatedName("cj")
   @ObfuscatedSignature(
      descriptor = "(B)Z",
      garbageValue = "27"
   )
   boolean method1761() {
      if (!this.method1748()) {
         return false;
      } else {
         boolean var1 = false;
         if (this.field2851.method2006() > this.field2857) {
            this.field2851.method2016(this.field2857, this.field2851.method2006());
            var1 = true;
         }

         int var2 = this.method1783();
         int var3;
         if (this.field2851.method2021() > var2) {
            var3 = this.field2851.method2018(0, var2) - 1;
            this.field2851.method2016(var3, this.field2851.method2006());
            var1 = true;
         }

         if (var1) {
            var3 = this.field2852;
            int var4 = this.field2853;
            int var5 = this.field2851.method2006();
            if (this.field2852 > var5) {
               var3 = var5;
            }

            if (this.field2853 > var5) {
               var4 = var5;
            }

            this.method1725(var4, var3);
         }

         return var1;
      }
   }

   @ObfuscatedName("ch")
   @ObfuscatedSignature(
      descriptor = "(IZB)V",
      garbageValue = "53"
   )
   void method1762(int var1, boolean var2) {
      if (var2) {
         this.method1725(this.field2853, var1);
      } else {
         this.method1725(var1, var1);
      }

   }

   @ObfuscatedName("ct")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "-2810550"
   )
   int method1763() {
      return this.field2858 / this.field2851.method2041();
   }

   @ObfuscatedName("cp")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "46"
   )
   void method1764() {
      class383 var1 = this.field2851.method2035(0, this.field2852);
      class461 var2 = var1.method2077();
      int var3 = this.field2851.method2041();
      int var4 = (Integer)var2.field3972 - 10;
      int var5 = var4 + 20;
      int var6 = (Integer)var2.field3973 - 3;
      int var7 = var3 + var6 + 6;
      int var8 = this.field2859;
      int var9 = var8 + this.field2842;
      int var10 = this.field2843;
      int var11 = var10 + this.field2858;
      int var12 = this.field2859;
      int var13 = this.field2843;
      if (var4 < var8) {
         var12 = var4;
      } else if (var5 > var9) {
         var12 = var5 - this.field2842;
      }

      if (var6 < var10) {
         var13 = var6;
      } else if (var7 > var11) {
         var13 = var7 - this.field2858;
      }

      this.method1713(var12, var13);
   }

   @ObfuscatedName("cd")
   @ObfuscatedSignature(
      descriptor = "(II)Z",
      garbageValue = "1230751066"
   )
   boolean method1782(int var1) {
      return var1 == 32 || var1 == 10 || var1 == 9;
   }

   @ObfuscatedName("dm")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "1220338251"
   )
   void method1766() {
      if (this.field2861 != null) {
         this.field2861.vmethod5708();
      }

   }

   @ObfuscatedName("dw")
   @ObfuscatedSignature(
      descriptor = "(IB)Z",
      garbageValue = "11"
   )
   boolean method1765(int var1) {
      switch(this.field2844) {
      case 1:
         return MenuAction.isAlphaNumeric((char)var1);
      case 2:
         return class134.isCharAlphabetic((char)var1);
      case 3:
         return class149.isDigit((char)var1);
      case 4:
         char var2 = (char)var1;
         if (class149.isDigit(var2)) {
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
      descriptor = "(I)Lrg;",
      garbageValue = "351336662"
   )
   class461 method1767() {
      int var1 = this.field2851.method2039(this.field2842);
      int var2 = this.field2851.method2040(this.field2858);
      return new class461(var1, var2);
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      descriptor = "(ILjava/lang/String;Lnx;IB)Llg;",
      garbageValue = "53"
   )
   public static PacketBufferNode method1774(int var0, String var1, Language var2, int var3) {
      PacketBufferNode var4 = class330.getPacketBufferNode(ClientPacket.field2476, Client.packetWriter.isaacCipher);
      var4.packetBuffer.writeByte(0);
      int var5 = var4.packetBuffer.offset;
      var4.packetBuffer.writeByte(var0);
      String var6 = var1.toLowerCase();
      byte var7 = 0;
      if (var6.startsWith("yellow:")) {
         var7 = 0;
         var1 = var1.substring("yellow:".length());
      } else if (var6.startsWith("red:")) {
         var7 = 1;
         var1 = var1.substring("red:".length());
      } else if (var6.startsWith("green:")) {
         var7 = 2;
         var1 = var1.substring("green:".length());
      } else if (var6.startsWith("cyan:")) {
         var7 = 3;
         var1 = var1.substring("cyan:".length());
      } else if (var6.startsWith("purple:")) {
         var7 = 4;
         var1 = var1.substring("purple:".length());
      } else if (var6.startsWith("white:")) {
         var7 = 5;
         var1 = var1.substring("white:".length());
      } else if (var6.startsWith("flash1:")) {
         var7 = 6;
         var1 = var1.substring("flash1:".length());
      } else if (var6.startsWith("flash2:")) {
         var7 = 7;
         var1 = var1.substring("flash2:".length());
      } else if (var6.startsWith("flash3:")) {
         var7 = 8;
         var1 = var1.substring("flash3:".length());
      } else if (var6.startsWith("glow1:")) {
         var7 = 9;
         var1 = var1.substring("glow1:".length());
      } else if (var6.startsWith("glow2:")) {
         var7 = 10;
         var1 = var1.substring("glow2:".length());
      } else if (var6.startsWith("glow3:")) {
         var7 = 11;
         var1 = var1.substring("glow3:".length());
      } else if (var2 != Language.Language_EN) {
         if (var6.startsWith("yellow:")) {
            var7 = 0;
            var1 = var1.substring("yellow:".length());
         } else if (var6.startsWith("red:")) {
            var7 = 1;
            var1 = var1.substring("red:".length());
         } else if (var6.startsWith("green:")) {
            var7 = 2;
            var1 = var1.substring("green:".length());
         } else if (var6.startsWith("cyan:")) {
            var7 = 3;
            var1 = var1.substring("cyan:".length());
         } else if (var6.startsWith("purple:")) {
            var7 = 4;
            var1 = var1.substring("purple:".length());
         } else if (var6.startsWith("white:")) {
            var7 = 5;
            var1 = var1.substring("white:".length());
         } else if (var6.startsWith("flash1:")) {
            var7 = 6;
            var1 = var1.substring("flash1:".length());
         } else if (var6.startsWith("flash2:")) {
            var7 = 7;
            var1 = var1.substring("flash2:".length());
         } else if (var6.startsWith("flash3:")) {
            var7 = 8;
            var1 = var1.substring("flash3:".length());
         } else if (var6.startsWith("glow1:")) {
            var7 = 9;
            var1 = var1.substring("glow1:".length());
         } else if (var6.startsWith("glow2:")) {
            var7 = 10;
            var1 = var1.substring("glow2:".length());
         } else if (var6.startsWith("glow3:")) {
            var7 = 11;
            var1 = var1.substring("glow3:".length());
         }
      }

      var6 = var1.toLowerCase();
      byte var8 = 0;
      if (var6.startsWith("wave:")) {
         var8 = 1;
         var1 = var1.substring("wave:".length());
      } else if (var6.startsWith("wave2:")) {
         var8 = 2;
         var1 = var1.substring("wave2:".length());
      } else if (var6.startsWith("shake:")) {
         var8 = 3;
         var1 = var1.substring("shake:".length());
      } else if (var6.startsWith("scroll:")) {
         var8 = 4;
         var1 = var1.substring("scroll:".length());
      } else if (var6.startsWith("slide:")) {
         var8 = 5;
         var1 = var1.substring("slide:".length());
      } else if (var2 != Language.Language_EN) {
         if (var6.startsWith("wave:")) {
            var8 = 1;
            var1 = var1.substring("wave:".length());
         } else if (var6.startsWith("wave2:")) {
            var8 = 2;
            var1 = var1.substring("wave2:".length());
         } else if (var6.startsWith("shake:")) {
            var8 = 3;
            var1 = var1.substring("shake:".length());
         } else if (var6.startsWith("scroll:")) {
            var8 = 4;
            var1 = var1.substring("scroll:".length());
         } else if (var6.startsWith("slide:")) {
            var8 = 5;
            var1 = var1.substring("slide:".length());
         }
      }

      var4.packetBuffer.writeByte(var7);
      var4.packetBuffer.writeByte(var8);
      WorldMapArea.method1432(var4.packetBuffer, var1);
      if (var0 == class324.field3040.rsOrdinal()) {
         var4.packetBuffer.writeByte(var3);
      }

      var4.packetBuffer.method2479(var4.packetBuffer.offset - var5);
      return var4;
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      descriptor = "(ZI)V",
      garbageValue = "114146742"
   )
   public static void method1750(boolean var0) {
      if (var0 && Rasterizer2D.field4108 != null) {
         Rasterizer3D.field1999 = Rasterizer3D.field1992;
      } else {
         Rasterizer3D.field1999 = Rasterizer3D.field1998;
      }

   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "(Lnm;Ljava/lang/String;Ljava/lang/String;I)[Ltc;",
      garbageValue = "1567788624"
   )
   public static IndexedSprite[] method1788(AbstractArchive var0, String var1, String var2) {
      if (!var0.isValidFileName(var1, var2)) {
         return null;
      } else {
         int var3 = var0.getGroupId(var1);
         int var4 = var0.getFileId(var3, var2);
         return class68.method434(var0, var3, var4);
      }
   }

   @ObfuscatedName("bm")
   @ObfuscatedSignature(
      descriptor = "(ILmq;IIIII[FB)Lmq;",
      garbageValue = "34"
   )
   static Widget method1789(int var0, Widget var1, int var2, int var3, int var4, int var5, int var6, float[] var7) {
      Widget var8 = new Widget();
      var8.type = var0;
      var8.parentId = var1.id;
      var8.childIndex = var2;
      var8.isIf3 = true;
      var8.xAlignment = var3;
      var8.yAlignment = var4;
      var8.widthAlignment = var5;
      var8.heightAlignment = var6;
      var8.rawX = (int)((float)var1.width * var7[0]);
      var8.rawY = (int)((float)var1.height * var7[1]);
      var8.rawWidth = (int)((float)var1.width * var7[2]);
      var8.rawHeight = (int)(var7[3] * (float)var1.height);
      return var8;
   }
}
