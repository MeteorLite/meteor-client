import java.util.ArrayList;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("nu")
public class class368 {
   @ObfuscatedName("lz")
   @ObfuscatedSignature(
      descriptor = "Lkd;"
   )
   @Export("dragInventoryWidget")
   static Widget dragInventoryWidget;
   @ObfuscatedName("j")
   int field3587 = Integer.MAX_VALUE;
   @ObfuscatedName("g")
   int field3588 = 0;
   @ObfuscatedName("i")
   boolean field3589 = true;
   @ObfuscatedName("o")
   boolean field3590 = true;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      descriptor = "Lne;"
   )
   AbstractFont field3591;
   @ObfuscatedName("k")
   ArrayList field3592 = new ArrayList();
   @ObfuscatedName("a")
   int field3593 = 0;
   @ObfuscatedName("s")
   int field3594 = 0;

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(II)Lnp;",
      garbageValue = "599099594"
   )
   public class370 method1918(int var1) {
      return (class370)this.field3592.get(var1);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "(B)Lnp;",
      garbageValue = "68"
   )
   class370 method1919() {
      return this.field3592.size() == 0 ? null : (class370)this.field3592.get(this.field3592.size() - 1);
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "(I)Z",
      garbageValue = "2107005785"
   )
   public boolean method1943() {
      return this.field3592.size() == 0;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "-1127139622"
   )
   public int method1921() {
      return this.field3592.size();
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      descriptor = "(B)Ljava/lang/String;",
      garbageValue = "1"
   )
   public String method1941() {
      if (this.method1943()) {
         return "";
      } else {
         StringBuilder var1 = new StringBuilder(this.method1921());

         for(int var2 = 0; var2 < this.method1921(); ++var2) {
            class370 var3 = this.method1918(var2);
            var1.append(var3.field3597);
         }

         return var1.toString();
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      descriptor = "(IZI)V",
      garbageValue = "-552089288"
   )
   public void method1922(int var1, boolean var2) {
      if (this.field3591 != null && var1 < this.field3591.ascent * 2) {
         var1 = Integer.MAX_VALUE;
      }

      if (this.field3587 != var1 || var2 != this.field3589) {
         this.field3587 = var1;
         this.field3589 = var2;
         this.method1920(0, this.field3592.size(), false);
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "(IB)V",
      garbageValue = "-73"
   )
   public void method1923(int var1) {
      if (this.field3594 != var1) {
         this.field3594 = var1;
         this.method1920(0, this.field3592.size(), false);
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      descriptor = "(Lne;I)V",
      garbageValue = "1392079190"
   )
   public void method1945(AbstractFont var1) {
      if (var1 != this.field3591) {
         this.field3591 = var1;
         if (this.field3591 != null) {
            if (this.field3588 == 0) {
               this.field3588 = this.field3591.ascent;
            }

            if (!this.method1943()) {
               this.method1920(0, this.field3592.size(), false);
            }
         }
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      descriptor = "(IS)V",
      garbageValue = "-3706"
   )
   public void method1947(int var1) {
      if (this.field3593 != var1) {
         this.field3593 = var1;
         this.method1920(0, this.field3592.size(), false);
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      descriptor = "(II)V",
      garbageValue = "-1109991484"
   )
   public void method1946(int var1) {
      if (this.field3588 != var1) {
         this.field3588 = var1;
         this.method1920(0, this.field3592.size(), false);
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      descriptor = "(IIB)Lna;",
      garbageValue = "14"
   )
   public class372 method1942(int var1, int var2) {
      if (var2 == var1) {
         return new class372(this, 0, 0);
      } else if (var1 <= this.field3592.size() && var2 <= this.field3592.size()) {
         return var2 < var1 ? new class372(this, var2, var1) : new class372(this, var1, var2);
      } else {
         return new class372(this, 0, 0);
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      descriptor = "(CIIII)Lny;",
      garbageValue = "1107452813"
   )
   public class369 method1925(char var1, int var2, int var3, int var4) {
      return this.method1926(Character.toString(var1), var2, var3, var4);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;IIII)Lny;",
      garbageValue = "-620830058"
   )
   public class369 method1926(String var1, int var2, int var3, int var4) {
      if (var3 == 0) {
         var3 = Integer.MAX_VALUE;
      }

      if (this.field3592.size() >= var3) {
         return new class369(var2, true);
      } else {
         this.field3592.ensureCapacity(this.field3592.size() + var1.length());
         int var5 = var2;
         int var6 = 0;
         class370 var7 = this.method1938(var2);
         int var8 = this.method1939(var2);

         int var9;
         int var10;
         for(var9 = -1; var6 < var1.length() && this.field3592.size() < var3; ++var5) {
            class370 var11 = new class370();
            var11.field3597 = var1.charAt(var6++);
            if (var11.field3597 == '\n') {
               var11.field3598 = var7.field3598 + this.method1948();
               var10 = 0;
            } else {
               var11.field3599 = var8 + var7.field3599;
               var11.field3598 = var7.field3598;
               var10 = this.method1940(var11, false);
               if (this.field3589 && var10 + var11.field3599 > this.field3587) {
                  if (this.field3593 == 0) {
                     var11.field3599 = 0;
                     var11.field3598 += this.method1948();
                  } else if (var9 == -1) {
                     var9 = var5;
                  }
               }
            }

            var7 = var11;
            var8 = var10;
            this.field3592.add(var5, var11);
         }

         var10 = var9 == -1 ? var5 : var9;
         this.method1920(var10, this.field3592.size(), true);
         if (var4 != 0 && this.method1949() > var4) {
            while(var5 != var2) {
               --var5;
               this.method1930(var5);
               if (this.method1949() <= var4) {
                  break;
               }
            }

            return new class369(var5, true);
         } else {
            return new class369(var5, false);
         }
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;III)Lny;",
      garbageValue = "1594768119"
   )
   class369 method1927(String var1, int var2, int var3) {
      return this.method1926(var1, this.field3592.size(), var2, var3);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;B)Lny;",
      garbageValue = "103"
   )
   public class369 method1928(String var1) {
      this.method1929();
      return this.method1927(var1, 0, 0);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "-16"
   )
   void method1929() {
      this.field3592.clear();
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      descriptor = "(II)I",
      garbageValue = "1344636736"
   )
   public int method1930(int var1) {
      return this.method1924(var1, var1 + 1);
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      descriptor = "(III)I",
      garbageValue = "888686654"
   )
   public int method1924(int var1, int var2) {
      int var3;
      if (var2 < var1) {
         var3 = var2;
         var2 = var1;
         var1 = var3;
      }

      this.field3592.subList(var1, var2).clear();
      var3 = var1;
      if (this.field3589 && this.field3593 == 1) {
         label32: {
            int var4 = var1;

            char var5;
            do {
               if (var4 <= 0) {
                  break label32;
               }

               --var4;
               var5 = ((class370)this.field3592.get(var4)).field3597;
            } while(var5 != ' ' && var5 != '\t');

            var3 = var4;
         }
      }

      this.method1920(var3, this.field3592.size(), true);
      return var1;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      descriptor = "(III)I",
      garbageValue = "655575850"
   )
   public int method1931(int var1, int var2) {
      if (this.field3591 != null && var1 >= 0 && var2 >= 0) {
         if (this.field3589 && var1 > this.field3587) {
            return this.field3592.size();
         } else {
            if (!this.field3592.isEmpty()) {
               for(int var3 = 0; var3 < this.field3592.size(); ++var3) {
                  class370 var4 = (class370)this.field3592.get(var3);
                  if (var2 <= var4.field3598 + this.method1948()) {
                     if (var2 < var4.field3598) {
                        break;
                     }

                     if (var1 < var4.field3599) {
                        return var3 > 0 ? var3 - 1 : 0;
                     }

                     if (var3 + 1 != this.field3592.size() && ((class370)this.field3592.get(var3 + 1)).field3598 != var4.field3598) {
                        int var5 = this.method1940((class370)this.field3592.get(var3), false);
                        if (var1 < var5 + var4.field3599) {
                           return var3;
                        }

                        if (var2 <= var4.field3598 + this.method1948()) {
                           return var3 + 1;
                        }
                     }
                  }
               }

               class370 var6 = (class370)this.field3592.get(this.field3592.size() - 1);
               if (var1 >= var6.field3599 && var1 <= var6.field3599 + this.method1934() && var2 >= var6.field3598 && var2 <= var6.field3598 + this.method1948()) {
                  return this.field3592.size() - 1;
               }
            }

            return this.field3592.size();
         }
      } else {
         return 0;
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      descriptor = "(III)I",
      garbageValue = "-1958663606"
   )
   public int method1932(int var1, int var2) {
      if (this.field3591 != null && !this.method1943() && var1 <= this.field3592.size()) {
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
            class370 var6 = (class370)this.field3592.get(var1 - 1);
            var4 = var6.field3599 + this.method1937(var1 - 1);
            var5 = var6.field3598;
         } else if (var3 == -1 && var1 == 0) {
            return 0;
         }

         int var14 = 16777215;
         int var7 = 0;
         int var8 = var1;
         int var9 = 16777215;
         int var10 = var3 == 1 ? this.field3592.size() + 1 : 0;

         for(int var11 = var3 + var1; var11 != var10; var11 += var3) {
            class370 var12 = (class370)this.field3592.get(var11 - 1);
            if (var5 != var12.field3598) {
               ++var7;
               var5 = var12.field3598;
               if (var7 > var2) {
                  return var8;
               }
            }

            if (var7 == var2) {
               int var13 = Math.abs(var12.field3599 + this.method1937(var11 - 1) - var4);
               if (var13 >= var9) {
                  return var8;
               }

               var8 = var11;
               var9 = var13;
            }
         }

         if (var3 == 1) {
            return this.field3592.size();
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

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "-130437286"
   )
   public int method1933() {
      if (!this.field3592.isEmpty() && this.method1949() == 1) {
         return this.field3592.isEmpty() ? 0 : ((class370)this.field3592.get(this.field3592.size() - 1)).field3599 + this.method1934();
      } else {
         int var1 = -1;
         int var2 = 0;

         for(int var3 = this.field3592.size() - 1; var3 >= 0; --var3) {
            class370 var4 = (class370)this.field3592.get(var3);
            if (var1 != var4.field3598) {
               int var5 = this.method1940(var4, false) + var4.field3599;
               var2 = Math.max(var5, var2);
               var1 = var4.field3598;
            }
         }

         return var2;
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      descriptor = "(S)I",
      garbageValue = "-25123"
   )
   public int method1950() {
      return this.method1943() ? 0 : this.field3591.ascent + ((class370)this.field3592.get(this.field3592.size() - 1)).field3598;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "845637475"
   )
   public int method1948() {
      return this.field3588;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "-2032059234"
   )
   public int method1949() {
      return this.method1950() / this.field3591.ascent;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "-1139842629"
   )
   int method1934() {
      return this.method1943() ? 0 : this.method1940((class370)this.field3592.get(this.field3592.size() - 1), false);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "253173757"
   )
   public int method1935() {
      return this.field3587;
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "1423170238"
   )
   public int method1936() {
      return this.field3593;
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "1071508455"
   )
   public int method1944() {
      return this.field3594;
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      descriptor = "(IIZI)V",
      garbageValue = "177216138"
   )
   void method1920(int var1, int var2, boolean var3) {
      if (!this.method1943() && this.field3591 != null) {
         class370 var4 = this.method1938(var1);
         int var5 = this.method1939(var1);

         for(int var6 = var1; var6 < var2; ++var6) {
            class370 var7 = (class370)this.field3592.get(var6);
            int var10;
            if (var7.field3597 == '\n') {
               int var9 = var4.field3598 + this.method1948();
               if (var3) {
                  if (var9 != var7.field3598) {
                     var10 = var9 - var7.field3598;

                     for(int var11 = var6; var11 < var2; ++var11) {
                        class370 var10000 = (class370)this.field3592.get(var11);
                        var10000.field3598 += var10;
                     }
                  }
                  break;
               }

               var7.field3598 = var9;
               boolean var8 = false;
            } else {
               var7.field3599 = var5 + var4.field3599;
               var7.field3598 = var4.field3598;
               int var18 = this.method1940(var7, false);
               if (this.field3589 && var18 + var7.field3599 > this.field3587) {
                  boolean var19 = false;
                  if (this.field3593 == 1) {
                     for(var10 = var6; var10 > 0; --var10) {
                        class370 var17 = (class370)this.field3592.get(var10 - 1);
                        if (var7.field3598 != var17.field3598) {
                           break;
                        }

                        if (var17.field3597 == ' ' || var17.field3597 == '\t') {
                           class370 var12 = (class370)this.field3592.get(var10);
                           int var13 = var12.field3599;
                           int var14 = var12.field3598 + this.method1948();

                           for(int var15 = var10; var15 <= var6; ++var15) {
                              class370 var16 = (class370)this.field3592.get(var15);
                              var16.field3599 -= var13;
                              var16.field3598 = var14;
                           }

                           var19 = true;
                           break;
                        }
                     }
                  }

                  if (!var19) {
                     var7.field3599 = 0;
                     var7.field3598 += this.method1948();
                  }
               }
            }

            var4 = (class370)this.field3592.get(var6);
            var5 = this.method1940(var4, false);
         }

      }
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      descriptor = "(II)Lnp;",
      garbageValue = "187141060"
   )
   class370 method1938(int var1) {
      if (var1 > 0 && !this.field3592.isEmpty()) {
         return var1 >= this.field3592.size() ? (class370)this.field3592.get(this.field3592.size() - 1) : (class370)this.field3592.get(var1 - 1);
      } else {
         return new class370();
      }
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      descriptor = "(II)I",
      garbageValue = "1721941194"
   )
   int method1939(int var1) {
      if (var1 > 0 && !this.field3592.isEmpty()) {
         return var1 >= this.field3592.size() ? this.method1937(this.field3592.size() - 1) : this.method1937(var1 - 1);
      } else {
         return 0;
      }
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      descriptor = "(II)I",
      garbageValue = "-18349977"
   )
   int method1937(int var1) {
      return var1 < this.field3592.size() ? this.method1940((class370)this.field3592.get(var1), false) : 0;
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      descriptor = "(Lnp;ZB)I",
      garbageValue = "-31"
   )
   int method1940(class370 var1, boolean var2) {
      if (var1.field3597 == '\n') {
         return 0;
      } else if (this.field3594 == 0) {
         int var3 = this.field3591.advances[var1.field3597];
         if (var3 == 0) {
            return var1.field3597 == '\t' ? this.field3591.advances[32] * 3 : this.field3591.advances[32];
         } else {
            return var3;
         }
      } else {
         return this.field3591.advances[42];
      }
   }
}
