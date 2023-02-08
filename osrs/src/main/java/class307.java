import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kp")
public class class307 {
    @ObfuscatedName("cd")
    @ObfuscatedSignature(
            descriptor = "[Lrg;"
    )
    static IndexedSprite[] worldSelectFlagSprites;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      descriptor = "Lnp;"
   )
   class372 field2824 = new class372();
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      descriptor = "Lnp;"
   )
   class372 field2840 = new class372();
   @ObfuscatedName("x")
   boolean field2826 = false;
   @ObfuscatedName("a")
   boolean field2827 = true;
   @ObfuscatedName("q")
   int field2828 = 0;
   @ObfuscatedName("d")
   boolean field2829 = false;
   @ObfuscatedName("e")
   int field2830 = 0;
   @ObfuscatedName("g")
   int field2831 = 0;
   @ObfuscatedName("y")
   int field2825 = 0;
   @ObfuscatedName("af")
   int field2832 = 0;
   @ObfuscatedName("aa")
   int field2833 = 0;
   @ObfuscatedName("ai")
   int field2834 = 0;
   @ObfuscatedName("ag")
   int field2835 = 0;
   @ObfuscatedName("aw")
   int field2836 = Integer.MAX_VALUE;
   @ObfuscatedName("ar")
   int field2837 = Integer.MAX_VALUE;
   @ObfuscatedName("al")
   int field2838 = Integer.MAX_VALUE;
   @ObfuscatedName("at")
   int field2839 = 0;
   @ObfuscatedName("aj")
   int field2842 = 0;
   @ObfuscatedName("ax")
   int field2821 = 0;
   @ObfuscatedName("az")
   int field2841 = 0;
   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      descriptor = "Lkm;"
   )
   class301 field2823;
   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      descriptor = "Lkm;"
   )
   class301 field2822;

   class307() {
      this.field2824.method1958(1);
      this.field2840.method1958(1);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "-907314219"
   )
   void method1641() {
      this.field2828 = (this.field2828 + 1) % 60;
      if (this.field2835 > 0) {
         --this.field2835;
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      descriptor = "(ZB)Z",
      garbageValue = "-101"
   )
   public boolean method1708(boolean var1) {
      var1 = var1 && this.field2827;
      boolean var2 = this.field2826 != var1;
      this.field2826 = var1;
      if (!this.field2826) {
         this.method1700(this.field2832, this.field2832);
      }

      return var2;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "(ZI)V",
      garbageValue = "49231833"
   )
   public void method1643(boolean var1) {
      this.field2827 = var1;
      this.field2826 = var1 && this.field2826;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;I)Z",
      garbageValue = "-2115269539"
   )
   boolean method1659(String var1) {
      String var2 = this.field2824.method1941();
      if (!var2.equals(var1)) {
         var1 = this.method1691(var1);
         this.field2824.method1947(var1);
         this.method1648(this.field2821, this.field2841);
         this.method1695();
         this.method1698();
         return true;
      } else {
         return false;
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;I)Z",
      garbageValue = "2098104516"
   )
   boolean method1644(String var1) {
      this.field2840.method1947(var1);
      return true;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      descriptor = "(Lnw;B)Z",
      garbageValue = "103"
   )
   boolean method1702(AbstractFont var1) {
      boolean var2 = !this.field2829;
      this.field2824.method1948(var1);
      this.field2840.method1948(var1);
      this.field2829 = true;
      var2 |= this.method1648(this.field2821, this.field2841);
      var2 |= this.method1700(this.field2833, this.field2832);
      if (this.method1695()) {
         this.method1698();
         var2 = true;
      }

      return var2;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      descriptor = "(IIB)Z",
      garbageValue = "-7"
   )
   public boolean method1645(int var1, int var2) {
      boolean var3 = this.field2839 != var1 || var2 != this.field2842;
      this.field2839 = var1;
      this.field2842 = var2;
      var3 |= this.method1648(this.field2821, this.field2841);
      return var3;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      descriptor = "(IB)Z",
      garbageValue = "59"
   )
   public boolean method1646(int var1) {
      if (var1 < 0) {
         var1 = Integer.MAX_VALUE;
      }

      boolean var2 = var1 == this.field2824.method1956();
      this.field2824.method1942(var1, true);
      this.field2840.method1942(var1, true);
      if (this.method1695()) {
         this.method1698();
         var2 = true;
      }

      return var2;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      descriptor = "(II)Z",
      garbageValue = "-229191440"
   )
   public boolean method1647(int var1) {
      if (var1 < 0) {
         this.field2836 = Integer.MAX_VALUE;
      } else {
         this.field2836 = var1;
      }

      if (this.method1695()) {
         this.method1698();
         return true;
      } else {
         return false;
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      descriptor = "(IB)Z",
      garbageValue = "-125"
   )
   public boolean method1717(int var1) {
      this.field2838 = var1;
      if (this.method1695()) {
         this.method1698();
         return true;
      } else {
         return false;
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      descriptor = "(III)Z",
      garbageValue = "1771659696"
   )
   public boolean method1648(int var1, int var2) {
      if (!this.method1683()) {
         this.field2821 = var1;
         this.field2841 = var2;
         return false;
      } else {
         int var3 = this.field2821;
         int var4 = this.field2841;
         int var5 = Math.max(0, this.field2824.method1969() - this.field2839 + 2);
         int var6 = Math.max(0, this.field2824.method1952() - this.field2842 + 1);
         this.field2821 = Math.max(0, Math.min(var5, var1));
         this.field2841 = Math.max(0, Math.min(var6, var2));
         return var3 != this.field2821 || var4 != this.field2841;
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      descriptor = "(IIB)Z",
      garbageValue = "25"
   )
   public boolean method1711(int var1, int var2) {
      return true;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      descriptor = "(II)V",
      garbageValue = "575795924"
   )
   public void method1649(int var1) {
      this.field2824.method1944(var1);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      descriptor = "(II)V",
      garbageValue = "-1337038489"
   )
   public void method1650(int var1) {
      this.field2830 = var1;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      descriptor = "(II)V",
      garbageValue = "646756591"
   )
   public void method1651(int var1) {
      this.field2824.method1958(var1);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(II)V",
      garbageValue = "1378818373"
   )
   public void method1652(int var1) {
      this.field2824.method1943(var1);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      descriptor = "(IB)Z",
      garbageValue = "-49"
   )
   public boolean method1653(int var1) {
      this.field2825 = var1;
      String var2 = this.field2824.method1941();
      int var3 = var2.length();
      var2 = this.method1691(var2);
      if (var2.length() != var3) {
         this.field2824.method1947(var2);
         this.method1648(this.field2821, this.field2841);
         this.method1695();
         this.method1698();
         return true;
      } else {
         return false;
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "66"
   )
   public void method1701() {
      this.field2829 = false;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      descriptor = "(II)Z",
      garbageValue = "1369936671"
   )
   public boolean method1654(int var1) {
      if (this.method1699(var1)) {
         this.method1658();
         class373 var2 = this.field2824.method1968((char)var1, this.field2832, this.field2837, this.field2836);
         this.method1700(var2.method1972(), var2.method1972());
         this.method1695();
         this.method1698();
      }

      return true;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "-70"
   )
   public void method1655() {
      if (!this.method1658() && this.field2832 > 0) {
         int var1 = this.field2824.method1966(this.field2832 - 1);
         this.method1698();
         this.method1700(var1, var1);
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "127602061"
   )
   public void method1713() {
      if (!this.method1658() && this.field2832 < this.field2824.method1967()) {
         int var1 = this.field2824.method1966(this.field2832);
         this.method1698();
         this.method1700(var1, var1);
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "1362450681"
   )
   public void method1656() {
      if (!this.method1658() && this.field2832 > 0) {
         class447 var1 = this.method1693(this.field2832 - 1);
         int var2 = this.field2824.method1950((Integer)var1.field3927, this.field2832);
         this.method1698();
         this.method1700(var2, var2);
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "1932520887"
   )
   public void method1657() {
      if (!this.method1658() && this.field2832 < this.field2824.method1967()) {
         class447 var1 = this.method1693(this.field2832);
         int var2 = this.field2824.method1950(this.field2832, (Integer)var1.field3928);
         this.method1698();
         this.method1700(var2, var2);
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "(I)Z",
      garbageValue = "1659058039"
   )
   boolean method1658() {
      if (!this.method1712()) {
         return false;
      } else {
         int var1 = this.field2824.method1950(this.field2833, this.field2832);
         this.method1698();
         this.method1700(var1, var1);
         return true;
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "2"
   )
   public void method1692() {
      this.method1700(0, this.field2824.method1967());
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      descriptor = "(III)Z",
      garbageValue = "-1250868463"
   )
   public boolean method1700(int var1, int var2) {
      if (!this.method1683()) {
         this.field2833 = var1;
         this.field2832 = var2;
         return false;
      } else {
         if (var1 > this.field2824.method1967()) {
            var1 = this.field2824.method1967();
         }

         if (var2 > this.field2824.method1967()) {
            var2 = this.field2824.method1967();
         }

         boolean var3 = this.field2833 != var1 || var2 != this.field2832;
         this.field2833 = var1;
         if (var2 != this.field2832) {
            this.field2832 = var2;
            this.field2828 = 0;
            this.method1696();
         }

         if (var3 && this.field2822 != null) {
            this.field2822.vmethod5708();
         }

         return var3;
      }
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      descriptor = "(ZI)V",
      garbageValue = "1672652675"
   )
   public void method1642(boolean var1) {
      class447 var2 = this.method1694(this.field2832);
      this.method1685((Integer)var2.field3927, var1);
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      descriptor = "(ZI)V",
      garbageValue = "754153094"
   )
   public void method1710(boolean var1) {
      class447 var2 = this.method1694(this.field2832);
      this.method1685((Integer)var2.field3928, var1);
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      descriptor = "(ZI)V",
      garbageValue = "-1647876465"
   )
   public void method1715(boolean var1) {
      this.method1685(0, var1);
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      descriptor = "(ZI)V",
      garbageValue = "1488591424"
   )
   public void method1718(boolean var1) {
      this.method1685(this.field2824.method1967(), var1);
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      descriptor = "(ZB)V",
      garbageValue = "0"
   )
   public void method1703(boolean var1) {
      if (this.method1712() && !var1) {
         this.method1685(Math.min(this.field2833, this.field2832), var1);
      } else if (this.field2832 > 0) {
         this.method1685(this.field2832 - 1, var1);
      }

   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      descriptor = "(ZI)V",
      garbageValue = "-1917917432"
   )
   public void method1662(boolean var1) {
      if (this.method1712() && !var1) {
         this.method1685(Math.max(this.field2833, this.field2832), var1);
      } else if (this.field2832 < this.field2824.method1967()) {
         this.method1685(this.field2832 + 1, var1);
      }

   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "(ZI)V",
      garbageValue = "1661249652"
   )
   public void method1719(boolean var1) {
      if (this.field2832 > 0) {
         class447 var2 = this.method1693(this.field2832 - 1);
         this.method1685((Integer)var2.field3927, var1);
      }

   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      descriptor = "(ZI)V",
      garbageValue = "-1637073208"
   )
   public void method1664(boolean var1) {
      if (this.field2832 < this.field2824.method1967()) {
         class447 var2 = this.method1693(this.field2832 + 1);
         this.method1685((Integer)var2.field3928, var1);
      }

   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "(ZI)V",
      garbageValue = "-2057418884"
   )
   public void method1665(boolean var1) {
      if (this.field2832 > 0) {
         this.method1685(this.field2824.method1963(this.field2832, -1), var1);
      }

   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      descriptor = "(ZI)V",
      garbageValue = "-2073067096"
   )
   public void method1666(boolean var1) {
      if (this.field2832 < this.field2824.method1967()) {
         this.method1685(this.field2824.method1963(this.field2832, 1), var1);
      }

   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      descriptor = "(ZB)V",
      garbageValue = "113"
   )
   public void method1667(boolean var1) {
      if (this.field2832 > 0) {
         int var2 = this.method1720();
         this.method1685(this.field2824.method1963(this.field2832, -var2), var1);
      }

   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      descriptor = "(ZB)V",
      garbageValue = "-20"
   )
   public void method1668(boolean var1) {
      if (this.field2832 < this.field2824.method1967()) {
         int var2 = this.method1720();
         this.method1685(this.field2824.method1963(this.field2832, var2), var1);
      }

   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      descriptor = "(ZI)V",
      garbageValue = "1600044103"
   )
   public void method1669(boolean var1) {
      class376 var2 = this.field2824.method1965(0, this.field2832);
      class447 var3 = var2.method2010();
      this.method1685(this.field2824.method1951((Integer)var3.field3927, this.field2841), var1);
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "(ZB)V",
      garbageValue = "-82"
   )
   public void method1670(boolean var1) {
      class376 var2 = this.field2824.method1965(0, this.field2832);
      class447 var3 = var2.method2010();
      this.method1685(this.field2824.method1951((Integer)var3.field3927, this.field2841 + this.field2842), var1);
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      descriptor = "(IIZZI)V",
      garbageValue = "-663576903"
   )
   public void method1671(int var1, int var2, boolean var3, boolean var4) {
      boolean var5 = false;
      int var8;
      if (!this.field2829) {
         var8 = 0;
      } else {
         var1 += this.field2821;
         var2 += this.field2841;
         var8 = this.field2824.method1951(var1, var2);
      }

      class447 var6;
      if (var3 && var4) {
         this.field2831 = 1;
         var6 = this.method1693(var8);
         class447 var7 = this.method1693(this.field2834);
         this.method1707(var7, var6);
      } else if (var3) {
         this.field2831 = 1;
         var6 = this.method1693(var8);
         this.method1700((Integer)var6.field3927, (Integer)var6.field3928);
         this.field2834 = (Integer)var6.field3927;
      } else if (var4) {
         this.method1700(this.field2834, var8);
      } else {
         if (this.field2835 > 0 && var8 == this.field2834) {
            if (this.field2832 == this.field2833) {
               this.field2831 = 1;
               var6 = this.method1693(var8);
               this.method1700((Integer)var6.field3927, (Integer)var6.field3928);
            } else {
               this.field2831 = 2;
               var6 = this.method1694(var8);
               this.method1700((Integer)var6.field3927, (Integer)var6.field3928);
            }
         } else {
            this.field2831 = 0;
            this.method1700(var8, var8);
            this.field2834 = var8;
         }

         this.field2835 = 25;
      }

   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      descriptor = "(IIB)V",
      garbageValue = "50"
   )
   public void method1706(int var1, int var2) {
      if (this.field2829 && this.method1680()) {
         var1 += this.field2821;
         var2 += this.field2841;
         int var3 = this.field2824.method1951(var1, var2);
         class447 var4;
         class447 var5;
         switch(this.field2831) {
         case 0:
            this.method1700(this.field2833, var3);
            break;
         case 1:
            var4 = this.method1693(this.field2834);
            var5 = this.method1693(var3);
            this.method1707(var4, var5);
            break;
         case 2:
            var4 = this.method1694(this.field2834);
            var5 = this.method1694(var3);
            this.method1707(var4, var5);
         }
      }

   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      descriptor = "(Ljava/awt/datatransfer/Clipboard;B)V",
      garbageValue = "38"
   )
   public void method1672(Clipboard var1) {
      class376 var2 = this.field2824.method1965(this.field2833, this.field2832);
      if (!var2.method2006()) {
         String var3 = var2.method2013();
         if (!var3.isEmpty()) {
            var1.setContents(new StringSelection(var3), (ClipboardOwner)null);
         }
      }

   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      descriptor = "(Ljava/awt/datatransfer/Clipboard;I)V",
      garbageValue = "2113716103"
   )
   public void method1673(Clipboard var1) {
      if (this.method1712()) {
         this.method1672(var1);
         this.method1658();
      }

   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      descriptor = "(Ljava/awt/datatransfer/Clipboard;I)V",
      garbageValue = "-1739927066"
   )
   public void method1705(Clipboard var1) {
      Transferable var2 = var1.getContents((Object)null);
      if (var2 != null && var2.isDataFlavorSupported(DataFlavor.stringFlavor)) {
         try {
            String var3 = this.method1691((String)var2.getTransferData(DataFlavor.stringFlavor));
            this.method1658();
            class373 var4 = this.field2824.method1946(var3, this.field2832, this.field2837, this.field2836);
            this.method1700(var4.method1972(), var4.method1972());
            this.method1695();
            this.method1698();
         } catch (Exception var5) {
            System.out.println("Error pasting clipboard to InputField.");
         }
      }

   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "2102286537"
   )
   public void method1674() {
      this.field2841 = Math.max(0, this.field2841 - this.field2824.method1953());
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "373252948"
   )
   public void method1675() {
      int var1 = Math.max(0, this.field2824.method1952() - this.field2842);
      this.field2841 = Math.min(var1, this.field2841 + this.field2824.method1953());
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "(Lkm;I)V",
      garbageValue = "1850283525"
   )
   public void method1676(class301 var1) {
      this.field2823 = var1;
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "(Lkm;I)V",
      garbageValue = "2122113051"
   )
   public void method1677(class301 var1) {
      this.field2822 = var1;
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      descriptor = "(I)Lnp;",
      garbageValue = "1893289455"
   )
   public class372 method1678() {
      return this.field2824;
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      descriptor = "(I)Lnp;",
      garbageValue = "-1034233503"
   )
   public class372 method1714() {
      return this.field2840;
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      descriptor = "(B)Lnm;",
      garbageValue = "-44"
   )
   public class376 method1679() {
      return this.field2824.method1965(this.field2833, this.field2832);
   }

   @ObfuscatedName("bj")
   @ObfuscatedSignature(
      descriptor = "(I)Z",
      garbageValue = "-1981913214"
   )
   public boolean method1680() {
      return this.field2826;
   }

   @ObfuscatedName("bf")
   @ObfuscatedSignature(
      descriptor = "(I)Z",
      garbageValue = "2077111986"
   )
   public boolean method1663() {
      return this.field2827;
   }

   @ObfuscatedName("bz")
   @ObfuscatedSignature(
      descriptor = "(B)Z",
      garbageValue = "110"
   )
   public boolean method1681() {
      return this.method1680() && this.field2828 % 60 < 30;
   }

   @ObfuscatedName("br")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "-1889382032"
   )
   public int method1716() {
      return this.field2832;
   }

   @ObfuscatedName("bm")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "621557504"
   )
   public int method1682() {
      return this.field2833;
   }

   @ObfuscatedName("be")
   @ObfuscatedSignature(
      descriptor = "(I)Z",
      garbageValue = "-1371647930"
   )
   public boolean method1683() {
      return this.field2829;
   }

   @ObfuscatedName("bo")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "605810854"
   )
   public int method1684() {
      return this.field2821;
   }

   @ObfuscatedName("bl")
   @ObfuscatedSignature(
      descriptor = "(S)I",
      garbageValue = "25511"
   )
   public int method1704() {
      return this.field2841;
   }

   @ObfuscatedName("bq")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "-880385464"
   )
   public int method1661() {
      return this.field2824.method1956();
   }

   @ObfuscatedName("bn")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "595036192"
   )
   public int method1686() {
      return this.field2836;
   }

   @ObfuscatedName("bi")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "641760578"
   )
   public int method1687() {
      return this.field2838;
   }

   @ObfuscatedName("bw")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "1597714886"
   )
   public int method1660() {
      return this.field2830;
   }

   @ObfuscatedName("bt")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "-1235797121"
   )
   public int method1688() {
      return this.field2824.method1957();
   }

   @ObfuscatedName("bd")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "-347080143"
   )
   public int method1709() {
      return this.field2825;
   }

   @ObfuscatedName("bg")
   @ObfuscatedSignature(
      descriptor = "(B)I",
      garbageValue = "19"
   )
   public int method1689() {
      return this.field2824.method1945();
   }

   @ObfuscatedName("bb")
   @ObfuscatedSignature(
      descriptor = "(B)Z",
      garbageValue = "-68"
   )
   public boolean method1690() {
      return this.field2836 > 1;
   }

   @ObfuscatedName("bk")
   @ObfuscatedSignature(
      descriptor = "(I)Z",
      garbageValue = "-1923749872"
   )
   boolean method1712() {
      return this.field2833 != this.field2832;
   }

   @ObfuscatedName("bs")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;I)Ljava/lang/String;",
      garbageValue = "-182363535"
   )
   String method1691(String var1) {
      StringBuilder var2 = new StringBuilder(var1.length());

      for(int var3 = 0; var3 < var1.length(); ++var3) {
         char var4 = var1.charAt(var3);
         if (this.method1699(var4)) {
            var2.append(var4);
         }
      }

      return var2.toString();
   }

   @ObfuscatedName("by")
   @ObfuscatedSignature(
      descriptor = "(Lqd;Lqd;I)V",
      garbageValue = "1953734910"
   )
   void method1707(class447 var1, class447 var2) {
      if ((Integer)var2.field3927 < (Integer)var1.field3927) {
         this.method1700((Integer)var1.field3928, (Integer)var2.field3927);
      } else {
         this.method1700((Integer)var1.field3927, (Integer)var2.field3928);
      }

   }

   @ObfuscatedName("bu")
   @ObfuscatedSignature(
      descriptor = "(IB)Lqd;",
      garbageValue = "11"
   )
   class447 method1693(int var1) {
      int var2 = this.field2824.method1967();
      int var3 = 0;
      int var4 = var2;

      int var5;
      for(var5 = var1; var5 > 0; --var5) {
         if (this.method1697(this.field2824.method1937(var5 - 1).field3603)) {
            var3 = var5;
            break;
         }
      }

      for(var5 = var1; var5 < var2; ++var5) {
         if (this.method1697(this.field2824.method1937(var5).field3603)) {
            var4 = var5;
            break;
         }
      }

      return new class447(var3, var4);
   }

   @ObfuscatedName("bp")
   @ObfuscatedSignature(
      descriptor = "(IB)Lqd;",
      garbageValue = "127"
   )
   class447 method1694(int var1) {
      int var2 = this.field2824.method1967();
      int var3 = 0;
      int var4 = var2;

      int var5;
      for(var5 = var1; var5 > 0; --var5) {
         if (this.field2824.method1937(var5 - 1).field3603 == '\n') {
            var3 = var5;
            break;
         }
      }

      for(var5 = var1; var5 < var2; ++var5) {
         if (this.field2824.method1937(var5).field3603 == '\n') {
            var4 = var5;
            break;
         }
      }

      return new class447(var3, var4);
   }

   @ObfuscatedName("bc")
   @ObfuscatedSignature(
      descriptor = "(B)Z",
      garbageValue = "100"
   )
   boolean method1695() {
      if (!this.method1683()) {
         return false;
      } else {
         boolean var1 = false;
         if (this.field2824.method1967() > this.field2838) {
            this.field2824.method1950(this.field2838, this.field2824.method1967());
            var1 = true;
         }

         int var2;
         if (this.field2824.method1964() > this.field2836) {
            var2 = this.field2824.method1963(0, this.field2836) - 1;
            this.field2824.method1950(var2, this.field2824.method1967());
            var1 = true;
         }

         if (var1) {
            var2 = this.field2832;
            int var3 = this.field2833;
            int var4 = this.field2824.method1967();
            if (this.field2832 > var4) {
               var2 = var4;
            }

            if (this.field2833 > var4) {
               var3 = var4;
            }

            this.method1700(var3, var2);
         }

         return var1;
      }
   }

   @ObfuscatedName("ba")
   @ObfuscatedSignature(
      descriptor = "(IZB)V",
      garbageValue = "16"
   )
   void method1685(int var1, boolean var2) {
      if (var2) {
         this.method1700(this.field2833, var1);
      } else {
         this.method1700(var1, var1);
      }

   }

   @ObfuscatedName("bh")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "-954530936"
   )
   int method1720() {
      return this.field2842 / this.field2824.method1953();
   }

   @ObfuscatedName("bx")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "-1927387060"
   )
   void method1696() {
      class376 var1 = this.field2824.method1965(0, this.field2832);
      class447 var2 = var1.method2010();
      int var3 = this.field2824.method1953();
      int var4 = (Integer)var2.field3927 - 10;
      int var5 = var4 + 20;
      int var6 = (Integer)var2.field3928 - 3;
      int var7 = var6 + var3 + 6;
      int var8 = this.field2821;
      int var9 = var8 + this.field2839;
      int var10 = this.field2841;
      int var11 = var10 + this.field2842;
      int var12 = this.field2821;
      int var13 = this.field2841;
      if (var4 < var8) {
         var12 = var4;
      } else if (var5 > var9) {
         var12 = var5 - this.field2839;
      }

      if (var6 < var10) {
         var13 = var6;
      } else if (var7 > var11) {
         var13 = var7 - this.field2842;
      }

      this.method1648(var12, var13);
   }

   @ObfuscatedName("bv")
   @ObfuscatedSignature(
      descriptor = "(IB)Z",
      garbageValue = "105"
   )
   boolean method1697(int var1) {
      return var1 == 32 || var1 == 10 || var1 == 9;
   }

   @ObfuscatedName("cu")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "754124756"
   )
   void method1698() {
      if (this.field2823 != null) {
         this.field2823.vmethod5708();
      }

   }

   @ObfuscatedName("cr")
   @ObfuscatedSignature(
      descriptor = "(IB)Z",
      garbageValue = "1"
   )
   boolean method1699(int var1) {
      switch(this.field2825) {
      case 1:
         return class97.isAlphaNumeric((char)var1);
      case 2:
         return class155.isCharAlphabetic((char)var1);
      case 3:
         return CollisionMap.isDigit((char)var1);
      case 4:
         char var2 = (char)var1;
         if (CollisionMap.isDigit(var2)) {
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
