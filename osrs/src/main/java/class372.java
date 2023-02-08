import java.io.File;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("np")
public class class372 {
    @ObfuscatedName("eh")
    @ObfuscatedSignature(
            descriptor = "Llm;"
    )
    static Archive archive2;
   @ObfuscatedName("c")
   int field3592 = Integer.MAX_VALUE;
   @ObfuscatedName("r")
   int field3595 = 0;
   @ObfuscatedName("b")
   boolean field3593 = true;
   @ObfuscatedName("m")
   boolean field3591 = true;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      descriptor = "Lnw;"
   )
   AbstractFont field3594;
   @ObfuscatedName("h")
   ArrayList field3590 = new ArrayList();
   @ObfuscatedName("p")
   int field3596 = 0;
   @ObfuscatedName("o")
   int field3597 = 0;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "(IB)Lnq;",
      garbageValue = "55"
   )
   public class374 method1937(int var1) {
      return (class374)this.field3590.get(var1);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      descriptor = "(I)Lnq;",
      garbageValue = "-899837938"
   )
   class374 method1954() {
      return this.field3590.size() == 0 ? null : (class374)this.field3590.get(this.field3590.size() - 1);
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "(B)Z",
      garbageValue = "51"
   )
   public boolean method1939() {
      return this.field3590.size() == 0;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "-1962221607"
   )
   public int method1967() {
      return this.field3590.size();
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      descriptor = "(S)Ljava/lang/String;",
      garbageValue = "-14961"
   )
   public String method1941() {
      if (this.method1939()) {
         return "";
      } else {
         StringBuilder var1 = new StringBuilder(this.method1967());

         for(int var2 = 0; var2 < this.method1967(); ++var2) {
            class374 var3 = this.method1937(var2);
            var1.append(var3.field3603);
         }

         return var1.toString();
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      descriptor = "(IZI)V",
      garbageValue = "682732986"
   )
   public void method1942(int var1, boolean var2) {
      if (this.field3594 != null && var1 < this.field3594.ascent * 2) {
         var1 = Integer.MAX_VALUE;
      }

      if (this.field3592 != var1 || var2 != this.field3593) {
         this.field3592 = var1;
         this.field3593 = var2;
         this.method1959(0, this.field3590.size(), false);
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      descriptor = "(IB)V",
      garbageValue = "-55"
   )
   public void method1943(int var1) {
      if (this.field3597 != var1) {
         this.field3597 = var1;
         this.method1959(0, this.field3590.size(), false);
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      descriptor = "(Lnw;I)V",
      garbageValue = "1071681431"
   )
   public void method1948(AbstractFont var1) {
      if (var1 != this.field3594) {
         this.field3594 = var1;
         if (this.field3594 != null) {
            if (this.field3595 == 0) {
               this.field3595 = this.field3594.ascent;
            }

            if (!this.method1939()) {
               this.method1959(0, this.field3590.size(), false);
            }
         }
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      descriptor = "(II)V",
      garbageValue = "-98802638"
   )
   public void method1958(int var1) {
      if (this.field3596 != var1) {
         this.field3596 = var1;
         this.method1959(0, this.field3590.size(), false);
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      descriptor = "(IS)V",
      garbageValue = "9870"
   )
   public void method1944(int var1) {
      if (this.field3595 != var1) {
         this.field3595 = var1;
         this.method1959(0, this.field3590.size(), false);
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      descriptor = "(IIB)Lnm;",
      garbageValue = "8"
   )
   public class376 method1965(int var1, int var2) {
      if (var2 == var1) {
         return new class376(this, 0, 0);
      } else if (var1 <= this.field3590.size() && var2 <= this.field3590.size()) {
         return var2 < var1 ? new class376(this, var2, var1) : new class376(this, var1, var2);
      } else {
         return new class376(this, 0, 0);
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      descriptor = "(CIIII)Lnu;",
      garbageValue = "-412468704"
   )
   public class373 method1968(char var1, int var2, int var3, int var4) {
      return this.method1946(Character.toString(var1), var2, var3, var4);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;IIII)Lnu;",
      garbageValue = "-2136642155"
   )
   public class373 method1946(String var1, int var2, int var3, int var4) {
      if (var3 == 0) {
         var3 = Integer.MAX_VALUE;
      }

      if (this.field3590.size() >= var3) {
         return new class373(var2, true);
      } else {
         this.field3590.ensureCapacity(this.field3590.size() + var1.length());
         int var5 = var2;
         int var6 = 0;
         class374 var7 = this.method1960(var2);
         int var8 = this.method1949(var2);

         int var9;
         int var10;
         for(var9 = -1; var6 < var1.length() && this.field3590.size() < var3; ++var5) {
            class374 var11 = new class374();
            var11.field3603 = var1.charAt(var6++);
            if (var11.field3603 == '\n') {
               var11.field3602 = var7.field3602 + this.method1953();
               var10 = 0;
            } else {
               var11.field3601 = var8 + var7.field3601;
               var11.field3602 = var7.field3602;
               var10 = this.method1962(var11, false);
               if (this.field3593 && var10 + var11.field3601 > this.field3592) {
                  if (this.field3596 == 0) {
                     var11.field3601 = 0;
                     var11.field3602 += this.method1953();
                  } else if (var9 == -1) {
                     var9 = var5;
                  }
               }
            }

            var7 = var11;
            var8 = var10;
            this.field3590.add(var5, var11);
         }

         var10 = var9 == -1 ? var5 : var9;
         this.method1959(var10, this.field3590.size(), true);
         if (var4 != 0 && this.method1964() > var4) {
            while(var5 != var2) {
               --var5;
               this.method1966(var5);
               if (this.method1964() <= var4) {
                  break;
               }
            }

            return new class373(var5, true);
         } else {
            return new class373(var5, false);
         }
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;III)Lnu;",
      garbageValue = "-1922985516"
   )
   class373 method1938(String var1, int var2, int var3) {
      return this.method1946(var1, this.field3590.size(), var2, var3);
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;I)Lnu;",
      garbageValue = "-998070512"
   )
   public class373 method1947(String var1) {
      this.method1940();
      return this.method1938(var1, 0, 0);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "1"
   )
   void method1940() {
      this.field3590.clear();
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      descriptor = "(II)I",
      garbageValue = "-8448203"
   )
   public int method1966(int var1) {
      return this.method1950(var1, var1 + 1);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      descriptor = "(IIS)I",
      garbageValue = "10408"
   )
   public int method1950(int var1, int var2) {
      int var3;
      if (var2 < var1) {
         var3 = var2;
         var2 = var1;
         var1 = var3;
      }

      this.field3590.subList(var1, var2).clear();
      var3 = var1;
      if (this.field3593 && this.field3596 == 1) {
         label32: {
            int var4 = var1;

            char var5;
            do {
               if (var4 <= 0) {
                  break label32;
               }

               --var4;
               var5 = ((class374)this.field3590.get(var4)).field3603;
            } while(var5 != ' ' && var5 != '\t');

            var3 = var4;
         }
      }

      this.method1959(var3, this.field3590.size(), true);
      return var1;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      descriptor = "(IIS)I",
      garbageValue = "525"
   )
   public int method1951(int var1, int var2) {
      if (this.field3594 != null && var1 >= 0 && var2 >= 0) {
         if (this.field3593 && var1 > this.field3592) {
            return this.field3590.size();
         } else {
            if (!this.field3590.isEmpty()) {
               for(int var3 = 0; var3 < this.field3590.size(); ++var3) {
                  class374 var4 = (class374)this.field3590.get(var3);
                  if (var2 <= var4.field3602 + this.method1953()) {
                     if (var2 < var4.field3602) {
                        break;
                     }

                     if (var1 < var4.field3601) {
                        return var3 > 0 ? var3 - 1 : 0;
                     }

                     if (var3 + 1 != this.field3590.size() && ((class374)this.field3590.get(var3 + 1)).field3602 != var4.field3602) {
                        int var5 = this.method1962((class374)this.field3590.get(var3), false);
                        if (var1 < var5 + var4.field3601) {
                           return var3;
                        }

                        if (var2 <= var4.field3602 + this.method1953()) {
                           return var3 + 1;
                        }
                     }
                  }
               }

               class374 var6 = (class374)this.field3590.get(this.field3590.size() - 1);
               if (var1 >= var6.field3601 && var1 <= var6.field3601 + this.method1955() && var2 >= var6.field3602 && var2 <= var6.field3602 + this.method1953()) {
                  return this.field3590.size() - 1;
               }
            }

            return this.field3590.size();
         }
      } else {
         return 0;
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      descriptor = "(III)I",
      garbageValue = "2001960464"
   )
   public int method1963(int var1, int var2) {
      if (this.field3594 != null && !this.method1939() && var1 <= this.field3590.size()) {
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
            class374 var6 = (class374)this.field3590.get(var1 - 1);
            var4 = var6.field3601 + this.method1961(var1 - 1);
            var5 = var6.field3602;
         } else if (var3 == -1 && var1 == 0) {
            return 0;
         }

         int var14 = 16777215;
         int var7 = 0;
         int var8 = var1;
         int var9 = 16777215;
         int var10 = var3 == 1 ? this.field3590.size() + 1 : 0;

         for(int var11 = var3 + var1; var11 != var10; var11 += var3) {
            class374 var12 = (class374)this.field3590.get(var11 - 1);
            if (var5 != var12.field3602) {
               ++var7;
               var5 = var12.field3602;
               if (var7 > var2) {
                  return var8;
               }
            }

            if (var7 == var2) {
               int var13 = Math.abs(var12.field3601 + this.method1961(var11 - 1) - var4);
               if (var13 >= var9) {
                  return var8;
               }

               var8 = var11;
               var9 = var13;
            }
         }

         if (var3 == 1) {
            return this.field3590.size();
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

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      descriptor = "(B)I",
      garbageValue = "-78"
   )
   public int method1969() {
      if (!this.field3590.isEmpty() && this.method1964() == 1) {
         return this.field3590.isEmpty() ? 0 : ((class374)this.field3590.get(this.field3590.size() - 1)).field3601 + this.method1955();
      } else {
         int var1 = -1;
         int var2 = 0;

         for(int var3 = this.field3590.size() - 1; var3 >= 0; --var3) {
            class374 var4 = (class374)this.field3590.get(var3);
            if (var1 != var4.field3602) {
               int var5 = this.method1962(var4, false) + var4.field3601;
               var2 = Math.max(var5, var2);
               var1 = var4.field3602;
            }
         }

         return var2;
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      descriptor = "(B)I",
      garbageValue = "-30"
   )
   public int method1952() {
      return this.method1939() ? 0 : this.field3594.ascent + ((class374)this.field3590.get(this.field3590.size() - 1)).field3602;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "-534651403"
   )
   public int method1953() {
      return this.field3595;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "-1958718002"
   )
   public int method1964() {
      return this.method1952() / this.field3594.ascent;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "-1535007927"
   )
   int method1955() {
      return this.method1939() ? 0 : this.method1962((class374)this.field3590.get(this.field3590.size() - 1), false);
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "-983822310"
   )
   public int method1956() {
      return this.field3592;
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "-1001126357"
   )
   public int method1957() {
      return this.field3596;
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      descriptor = "(B)I",
      garbageValue = "63"
   )
   public int method1945() {
      return this.field3597;
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      descriptor = "(IIZI)V",
      garbageValue = "1645181643"
   )
   void method1959(int var1, int var2, boolean var3) {
      if (!this.method1939() && this.field3594 != null) {
         class374 var4 = this.method1960(var1);
         int var5 = this.method1949(var1);

         for(int var6 = var1; var6 < var2; ++var6) {
            class374 var7 = (class374)this.field3590.get(var6);
            int var10;
            if (var7.field3603 == '\n') {
               int var9 = var4.field3602 + this.method1953();
               if (var3) {
                  if (var9 != var7.field3602) {
                     var10 = var9 - var7.field3602;

                     for(int var11 = var6; var11 < var2; ++var11) {
                        class374 var10000 = (class374)this.field3590.get(var11);
                        var10000.field3602 += var10;
                     }
                  }
                  break;
               }

               var7.field3602 = var9;
               boolean var8 = false;
            } else {
               var7.field3601 = var5 + var4.field3601;
               var7.field3602 = var4.field3602;
               int var18 = this.method1962(var7, false);
               if (this.field3593 && var18 + var7.field3601 > this.field3592) {
                  boolean var19 = false;
                  if (this.field3596 == 1) {
                     for(var10 = var6; var10 > 0; --var10) {
                        class374 var17 = (class374)this.field3590.get(var10 - 1);
                        if (var17.field3602 != var7.field3602) {
                           break;
                        }

                        if (var17.field3603 == ' ' || var17.field3603 == '\t') {
                           class374 var12 = (class374)this.field3590.get(var10);
                           int var13 = var12.field3601;
                           int var14 = var12.field3602 + this.method1953();

                           for(int var15 = var10; var15 <= var6; ++var15) {
                              class374 var16 = (class374)this.field3590.get(var15);
                              var16.field3601 -= var13;
                              var16.field3602 = var14;
                           }

                           var19 = true;
                           break;
                        }
                     }
                  }

                  if (!var19) {
                     var7.field3601 = 0;
                     var7.field3602 += this.method1953();
                  }
               }
            }

            var4 = (class374)this.field3590.get(var6);
            var5 = this.method1962(var4, false);
         }

      }
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      descriptor = "(II)Lnq;",
      garbageValue = "-614261861"
   )
   class374 method1960(int var1) {
      if (var1 > 0 && !this.field3590.isEmpty()) {
         return var1 >= this.field3590.size() ? (class374)this.field3590.get(this.field3590.size() - 1) : (class374)this.field3590.get(var1 - 1);
      } else {
         return new class374();
      }
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      descriptor = "(IB)I",
      garbageValue = "113"
   )
   int method1949(int var1) {
      if (var1 > 0 && !this.field3590.isEmpty()) {
         return var1 >= this.field3590.size() ? this.method1961(this.field3590.size() - 1) : this.method1961(var1 - 1);
      } else {
         return 0;
      }
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      descriptor = "(II)I",
      garbageValue = "2008557271"
   )
   int method1961(int var1) {
      return var1 < this.field3590.size() ? this.method1962((class374)this.field3590.get(var1), false) : 0;
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "(Lnq;ZI)I",
      garbageValue = "1847840161"
   )
   int method1962(class374 var1, boolean var2) {
      if (var1.field3603 == '\n') {
         return 0;
      } else if (this.field3597 == 0) {
         int var3 = this.field3594.advances[var1.field3603];
         if (var3 == 0) {
            return var1.field3603 == '\t' ? this.field3594.advances[32] * 3 : this.field3594.advances[32];
         } else {
            return var3;
         }
      } else {
         return this.field3594.advances[42];
      }
   }

    @ObfuscatedName("w")
    @ObfuscatedSignature(
            descriptor = "(Ljava/lang/String;I)Ljava/io/File;",
            garbageValue = "-354380087"
    )
    public static File getFile(String var0) {
      if (!FileSystem.FileSystem_hasPermissions) {
         throw new RuntimeException("");
      } else {
         File var1 = (File)FileSystem.FileSystem_cacheFiles.get(var0);
         if (var1 != null) {
            return var1;
         } else {
            File var2 = new File(FileSystem.FileSystem_cacheDir, var0);
            RandomAccessFile var3 = null;

            try {
               File var4 = new File(var2.getParent());
               if (!var4.exists()) {
                  throw new RuntimeException("");
               } else {
                  var3 = new RandomAccessFile(var2, "rw");
                  int var5 = var3.read();
                  var3.seek(0L);
                  var3.write(var5);
                  var3.seek(0L);
                  var3.close();
                  FileSystem.FileSystem_cacheFiles.put(var0, var2);
                  return var2;
               }
            } catch (Exception var8) {
               try {
                  if (var3 != null) {
                     var3.close();
                     var3 = null;
                  }
               } catch (Exception var7) {
                  ;
               }

               throw new RuntimeException();
            }
         }
      }
   }
}
