import java.util.ArrayList;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ow")
public class class375 {
   @ObfuscatedName("az")
   int field3564 = Integer.MAX_VALUE;
   @ObfuscatedName("ae")
   int field3563 = Integer.MAX_VALUE;
   @ObfuscatedName("au")
   int field3566 = 0;
   @ObfuscatedName("ag")
   int field3567 = 0;
   @ObfuscatedName("at")
   int field3571 = 0;
   @ObfuscatedName("af")
   boolean field3568 = true;
   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      descriptor = "Lou;"
   )
   AbstractFont field3569;
   @ObfuscatedName("aw")
   ArrayList field3570 = new ArrayList();
   @ObfuscatedName("aa")
   int field3565 = 0;
   @ObfuscatedName("ah")
   int field3572 = 0;

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "(IB)Lod;",
      garbageValue = "-58"
   )
   public class377 method1987(int var1) {
      return (class377)this.field3570.get(var1);
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "(I)Lod;",
      garbageValue = "2053007893"
   )
   class377 method1948() {
      return this.field3570.size() == 0 ? null : (class377)this.field3570.get(this.field3570.size() - 1);
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "(I)Z",
      garbageValue = "1946472859"
   )
   public boolean method1949() {
      return this.field3570.size() == 0;
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "(I)Z",
      garbageValue = "-1445253617"
   )
   boolean method1985() {
      return this.field3563 > 1;
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "1456819718"
   )
   public int method1950() {
      return this.field3570.size();
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      descriptor = "(I)Ljava/lang/String;",
      garbageValue = "-1489675961"
   )
   public String method1951() {
      if (this.method1949()) {
         return "";
      } else {
         StringBuilder var1 = new StringBuilder(this.method1950());

         for(int var2 = 0; var2 < this.method1950(); ++var2) {
            class377 var3 = this.method1987(var2);
            var1.append(var3.field3577);
         }

         return var1.toString();
      }
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      descriptor = "(IB)V",
      garbageValue = "13"
   )
   public void method1952(int var1) {
      if (this.field3569 != null && var1 < this.field3569.ascent * 2) {
         var1 = Integer.MAX_VALUE;
      }

      if (this.field3564 != var1) {
         this.field3564 = var1;
         this.method1973();
      }

   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      descriptor = "(IB)V",
      garbageValue = "-22"
   )
   public void method1953(int var1) {
      if (this.field3563 != var1) {
         this.field3563 = var1;
         this.method1973();
      }

   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      descriptor = "(II)V",
      garbageValue = "2052556376"
   )
   public void method1954(int var1) {
      if (this.field3572 != var1) {
         this.field3572 = var1;
         this.method1973();
      }

   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      descriptor = "(Lou;I)V",
      garbageValue = "2091647435"
   )
   public void method1955(AbstractFont var1) {
      if (var1 != this.field3569) {
         this.field3569 = var1;
         if (this.field3569 != null) {
            if (this.field3571 == 0) {
               this.field3571 = this.field3569.ascent;
            }

            if (!this.method1949()) {
               this.method1973();
            }
         }
      }

   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      descriptor = "(II)V",
      garbageValue = "1711544559"
   )
   public void method1988(int var1) {
      if (this.field3565 != var1) {
         this.field3565 = var1;
         this.method1973();
      }

   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      descriptor = "(III)Z",
      garbageValue = "-2039244192"
   )
   public boolean method1956(int var1, int var2) {
      if (this.field3566 != var1 || var2 != this.field3567) {
         this.field3566 = var1;
         this.field3567 = var2;
         this.method1973();
      }

      return true;
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      descriptor = "(IB)V",
      garbageValue = "-39"
   )
   public void method1957(int var1) {
      if (this.field3571 != var1) {
         this.field3571 = var1;
         this.method1973();
      }

   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      descriptor = "(III)Lon;",
      garbageValue = "-555760487"
   )
   public class379 method1958(int var1, int var2) {
      if (var2 == var1) {
         return new class379(this, 0, 0);
      } else if (var1 <= this.field3570.size() && var2 <= this.field3570.size()) {
         return var2 < var1 ? new class379(this, var2, var1) : new class379(this, var1, var2);
      } else {
         return new class379(this, 0, 0);
      }
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      descriptor = "(CIIB)Loj;",
      garbageValue = "1"
   )
   public class376 method1983(char var1, int var2, int var3) {
      return this.method1971(Character.toString(var1), var2, var3);
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;III)Loj;",
      garbageValue = "-727480702"
   )
   public class376 method1971(String var1, int var2, int var3) {
      if (var3 == 0) {
         var3 = Integer.MAX_VALUE;
      }

      int var4 = var2;
      if (this.field3570.size() >= var3) {
         this.method1974(var2, var2);
         return new class376(var2, true);
      } else {
         this.field3570.ensureCapacity(this.field3570.size() + var1.length());

         for(int var5 = 0; var5 < var1.length() && this.field3570.size() < var3; ++var5) {
            class377 var6 = new class377();
            var6.field3577 = var1.charAt(var5);
            this.field3570.add(var4, var6);
            ++var4;
         }

         this.method1974(var2, var4);
         if (this.field3563 != 0 && this.method1968() > this.field3563) {
            while(var4 != var2) {
               --var4;
               this.method1962(var4);
               if (this.method1968() <= this.field3563) {
                  break;
               }
            }

            return new class376(var4, true);
         } else {
            return new class376(var4, false);
         }
      }
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;II)Loj;",
      garbageValue = "-2097418671"
   )
   class376 method1984(String var1, int var2) {
      return this.method1971(var1, this.field3570.size(), var2);
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;S)Loj;",
      garbageValue = "180"
   )
   public class376 method1960(String var1) {
      this.method1961();
      return this.method1984(var1, 0);
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "-52"
   )
   void method1961() {
      this.field3570.clear();
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      descriptor = "(II)I",
      garbageValue = "914132212"
   )
   public int method1962(int var1) {
      return this.method1976(var1, var1 + 1);
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      descriptor = "(III)I",
      garbageValue = "-2141158161"
   )
   public int method1976(int var1, int var2) {
      int var3;
      if (var2 < var1) {
         var3 = var2;
         var2 = var1;
         var1 = var3;
      }

      this.field3570.subList(var1, var2).clear();
      var3 = var1;
      if (this.method1985() && this.field3565 == 1) {
         while(var3 > 0) {
            --var3;
            char var4 = ((class377)this.field3570.get(var3)).field3577;
            if (var4 == ' ' || var4 == '\t') {
               break;
            }
         }
      }

      this.method1974(var3, var2);
      return var1;
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      descriptor = "(III)I",
      garbageValue = "-1082221342"
   )
   public int method1963(int var1, int var2) {
      if (this.field3569 == null) {
         return 0;
      } else if (this.method1985() && var1 > this.field3564) {
         return this.field3570.size();
      } else {
         if (!this.field3570.isEmpty()) {
            for(int var3 = 0; var3 < this.field3570.size(); ++var3) {
               class377 var4 = (class377)this.field3570.get(var3);
               if (var2 <= var4.field3575 + this.method1967()) {
                  if (var2 < var4.field3575) {
                     break;
                  }

                  if (var1 < var4.field3576) {
                     return var3 > 0 ? var3 - 1 : 0;
                  }

                  if (var3 + 1 != this.field3570.size() && ((class377)this.field3570.get(var3 + 1)).field3575 != var4.field3575) {
                     int var5 = this.method1979((class377)this.field3570.get(var3), false);
                     if (var1 < var5 + var4.field3576) {
                        return var3;
                     }

                     if (var2 <= var4.field3575 + this.method1967()) {
                        return var3 + 1;
                     }
                  }
               }
            }

            class377 var6 = (class377)this.field3570.get(this.field3570.size() - 1);
            if (var1 >= var6.field3576 && var1 <= var6.field3576 + this.method1969() && var2 >= var6.field3575 && var2 <= var6.field3575 + this.method1967()) {
               return this.field3570.size() - 1;
            }
         }

         return this.field3570.size();
      }
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      descriptor = "(IIB)I",
      garbageValue = "70"
   )
   public int method1964(int var1, int var2) {
      if (this.field3569 != null && !this.method1949() && var1 <= this.field3570.size()) {
         byte var3;
         if (var2 > 0) {
            var3 = 1;
         } else {
            var3 = -1;
            var2 = -var2;
         }

         int var4 = 0;
         int var5 = 0;
         if (var1 > 0) {
            class377 var6 = (class377)this.field3570.get(var1 - 1);
            var4 = var6.field3576 + this.method1975(var1 - 1);
            var5 = var6.field3575;
         } else if (var3 == -1 && var1 == 0) {
            return 0;
         }

         int var14 = 16777215;
         int var7 = 0;
         int var8 = var1;
         int var9 = 16777215;
         int var10 = var3 == 1 ? this.field3570.size() + 1 : 0;

         for(int var11 = var3 + var1; var11 != var10; var11 += var3) {
            class377 var12 = (class377)this.field3570.get(var11 - 1);
            if (var5 != var12.field3575) {
               ++var7;
               var5 = var12.field3575;
               if (var7 > var2) {
                  return var8;
               }
            }

            if (var7 == var2) {
               int var13 = Math.abs(var12.field3576 + this.method1975(var11 - 1) - var4);
               if (var13 >= var9) {
                  return var8;
               }

               var8 = var11;
               var9 = var13;
            }
         }

         if (var3 == 1) {
            return this.field3570.size();
         } else {
            if (var5 != 0) {
               ++var7;
            }

            return var9 == 16777215 || var7 == var2 && var4 < var9 ? 0 : var8;
         }
      } else {
         return 0;
      }
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      descriptor = "(B)I",
      garbageValue = "-103"
   )
   public int method1965() {
      if (!this.field3570.isEmpty() && this.method1968() == 1) {
         return this.field3570.isEmpty() ? 0 : ((class377)this.field3570.get(this.field3570.size() - 1)).field3576 + this.method1969();
      } else {
         int var1 = -1;
         int var2 = 0;

         for(int var3 = this.field3570.size() - 1; var3 >= 0; --var3) {
            class377 var4 = (class377)this.field3570.get(var3);
            if (var1 != var4.field3575) {
               int var5 = this.method1979(var4, false) + var4.field3576;
               var2 = Math.max(var5, var2);
               var1 = var4.field3575;
            }
         }

         return var2;
      }
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "-463176913"
   )
   public int method1966() {
      return this.method1949() ? 0 : this.field3569.ascent + ((class377)this.field3570.get(this.field3570.size() - 1)).field3575;
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "1395107807"
   )
   public int method1967() {
      return this.field3571;
   }

   @ObfuscatedName("bm")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "777744451"
   )
   public int method1968() {
      return this.method1966() / this.field3569.ascent;
   }

   @ObfuscatedName("bv")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "1365210754"
   )
   int method1969() {
      return this.method1949() ? 0 : this.method1979((class377)this.field3570.get(this.field3570.size() - 1), false);
   }

   @ObfuscatedName("bo")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "1992476190"
   )
   public int method1970() {
      return this.field3564;
   }

   @ObfuscatedName("bs")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "1670251162"
   )
   public int method1981() {
      return this.field3563;
   }

   @ObfuscatedName("bg")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "-1925990481"
   )
   public int method1972() {
      return this.field3565;
   }

   @ObfuscatedName("bh")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "1880572091"
   )
   public int method1986() {
      return this.field3572;
   }

   @ObfuscatedName("bl")
   @ObfuscatedSignature(
      descriptor = "(II)I",
      garbageValue = "152707656"
   )
   public int method1982(int var1) {
      switch(this.field3566) {
      case 0:
         return 0;
      case 1:
         return var1 / 2;
      case 2:
         return var1;
      default:
         System.out.println("TextRun.getLeftOffsetForHorizontalAlignment: Invalid horizontal alignment. Value: '" + this.field3566 + "'.");
         return 0;
      }
   }

   @ObfuscatedName("bk")
   @ObfuscatedSignature(
      descriptor = "(II)I",
      garbageValue = "-80288601"
   )
   public int method1977(int var1) {
      switch(this.field3567) {
      case 0:
         return 0;
      case 1:
         return var1 / 2;
      case 2:
         return var1;
      default:
         System.out.println("TextRun.getTopOffsetForVerticalAlignment: Invalid vertical alignment. Value: '" + this.field3567 + "'.");
         return 0;
      }
   }

   @ObfuscatedName("br")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "-62815061"
   )
   void method1973() {
      this.method1974(0, this.field3570.size());
   }

   @ObfuscatedName("ba")
   @ObfuscatedSignature(
      descriptor = "(IIB)V",
      garbageValue = "75"
   )
   void method1974(int var1, int var2) {
      if (!this.method1949() && this.field3569 != null) {
         class451 var3 = this.method1959(var1, var2);
         boolean var4 = (Integer)var3.field3892 == 0 && (Integer)var3.field3893 == this.field3570.size();
         int var5 = (Integer)var3.field3892;
         int var6 = 0;
         int var7 = var4 ? 0 : ((class377)this.field3570.get((Integer)var3.field3892)).field3575 * -1485466487 * 1079124409;
         int var8 = 0;

         int var9;
         for(var9 = (Integer)var3.field3892; var9 <= (Integer)var3.field3893; ++var9) {
            boolean var10 = var9 >= this.field3570.size();
            class377 var11 = (class377)this.field3570.get(!var10 ? var9 : this.field3570.size() - 1);
            int var12 = !var10 ? this.method1979(var11, false) : 0;
            boolean var13 = !var10 && var11.field3577 == '\n';
            boolean var14 = !var10 && this.method1985() && var12 + var6 > this.field3564;
            if (var13 || var14 || var10) {
               int var15 = var9;
               int var16 = 0;
               int var17;
               int var18;
               class377 var19;
               if (var14) {
                  var17 = 0;
                  if (this.field3565 == 1) {
                     for(var18 = var9; var18 > var5; --var18) {
                        var19 = (class377)this.field3570.get(var18);
                        var17 += var18 < var15 ? this.method1979(var19, false) : 0;
                        if (var19.field3577 == ' ' || var19.field3577 == '\n') {
                           var15 = var18;
                           var6 -= var17;
                           var16 = var17;
                           break;
                        }
                     }
                  }
               }

               var17 = -this.method1982(var6);

               for(var18 = var5; var18 < var15; ++var18) {
                  var19 = (class377)this.field3570.get(var18);
                  int var20 = this.method1979(var19, false);
                  var19.field3576 = var17;
                  var19.field3575 = var7;
                  var17 += var20;
               }

               var5 = var15;
               var6 = var16;
               var7 += this.method1967();
               ++var8;
            }

            var6 += !var10 ? var12 : 0;
         }

         if (this.field3567 != 0 && var4) {
            var9 = var8 * this.method1967();
            int var23 = this.method1977(var9);

            for(int var21 = 0; var21 < this.field3570.size(); ++var21) {
               class377 var22 = (class377)this.field3570.get(var21);
               var22.field3575 -= var23;
            }
         }

      }
   }

   @ObfuscatedName("bz")
   @ObfuscatedSignature(
      descriptor = "(II)I",
      garbageValue = "2066300625"
   )
   int method1975(int var1) {
      return var1 < this.field3570.size() ? this.method1979((class377)this.field3570.get(var1), false) : 0;
   }

   @ObfuscatedName("bq")
   @ObfuscatedSignature(
      descriptor = "(Lod;ZI)I",
      garbageValue = "-615847689"
   )
   int method1979(class377 var1, boolean var2) {
      if (var1.field3577 == '\n') {
         return 0;
      } else if (this.field3572 == 0) {
         int var3 = this.field3569.advances[var1.field3577];
         if (var3 == 0) {
            return var1.field3577 == '\t' ? this.field3569.advances[32] * 3 : this.field3569.advances[32];
         } else {
            return var3;
         }
      } else {
         return this.field3569.advances[42];
      }
   }

   @ObfuscatedName("bc")
   @ObfuscatedSignature(
      descriptor = "(IIB)Lrv;",
      garbageValue = "124"
   )
   class451 method1959(int var1, int var2) {
      int var3 = Math.min(var1, var2);
      int var4 = Math.max(var1, var2);
      int var5 = this.field3570.size();
      if (var3 == 0 && var5 == var4) {
         return new class451(0, var5);
      } else {
         int var6 = this.method1980(var3, false);
         int var7 = this.method1978(var4, false);
         int var8;
         switch(this.field3567) {
         case 0:
            if (this.field3566 == 0) {
               return new class451(var6, var5);
            }

            var8 = this.method1980(var3, true);
            return new class451(var8, var5);
         case 1:
            return new class451(0, var5);
         case 2:
            if (this.field3566 == 2) {
               return new class451(0, var7);
            }

            var8 = this.method1978(var4, true);
            return new class451(0, var8);
         default:
            return new class451(0, var5);
         }
      }
   }

   @ObfuscatedName("bt")
   @ObfuscatedSignature(
      descriptor = "(IZI)I",
      garbageValue = "1702728009"
   )
   int method1980(int var1, boolean var2) {
      if (var1 < this.field3570.size()) {
         int var3 = ((class377)this.field3570.get(var1)).field3575;

         for(int var4 = var1; var4 > 0; --var4) {
            if (((class377)this.field3570.get(var4 - 1)).field3575 < var3) {
               if (!var2) {
                  return var4;
               }

               var2 = false;
               var3 = ((class377)this.field3570.get(var4 - 1)).field3575;
            }
         }
      }

      return 0;
   }

   @ObfuscatedName("be")
   @ObfuscatedSignature(
      descriptor = "(IZI)I",
      garbageValue = "2145203744"
   )
   int method1978(int var1, boolean var2) {
      if (var1 < this.field3570.size()) {
         int var3 = ((class377)this.field3570.get(var1)).field3575;

         for(int var4 = var1; var4 < this.field3570.size() - 1; ++var4) {
            if (((class377)this.field3570.get(var4 + 1)).field3575 > var3) {
               if (!var2) {
                  return var4;
               }

               var2 = false;
               var3 = ((class377)this.field3570.get(var4 + 1)).field3575;
            }
         }
      }

      return this.field3570.size();
   }
}
