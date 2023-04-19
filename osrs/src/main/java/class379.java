import java.util.ArrayList;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("oq")
public class class379 {
    @ObfuscatedName("aq")
    public static int musicTrackGroupId;
   @ObfuscatedName("ah")
   int field3616 = Integer.MAX_VALUE;
   @ObfuscatedName("av")
   int field3614 = Integer.MAX_VALUE;
   @ObfuscatedName("ar")
   int field3615 = 0;
   @ObfuscatedName("am")
   int field3620 = 0;
   @ObfuscatedName("as")
   int field3617 = 0;
   @ObfuscatedName("aj")
   boolean field3618 = true;
   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      descriptor = "Lou;"
   )
   AbstractFont field3612;
   @ObfuscatedName("az")
   ArrayList field3619 = new ArrayList();
   @ObfuscatedName("ad")
   int field3611 = 0;
   @ObfuscatedName("ae")
   int field3621 = 0;

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      descriptor = "(II)Lom;",
      garbageValue = "1345867261"
   )
   public class381 method2002(int var1) {
      return (class381)this.field3619.get(var1);
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "(I)Lom;",
      garbageValue = "-1433710051"
   )
   class381 method2023() {
      return this.field3619.size() == 0 ? null : (class381)this.field3619.get(this.field3619.size() - 1);
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      descriptor = "(I)Z",
      garbageValue = "-1182697415"
   )
   public boolean method2004() {
      return this.field3619.size() == 0;
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "(B)Z",
      garbageValue = "16"
   )
   boolean method2005() {
      return this.field3614 > 1;
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "1350377634"
   )
   public int method2006() {
      return this.field3619.size();
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "(I)Ljava/lang/String;",
      garbageValue = "-1389348498"
   )
   public String method2007() {
      if (this.method2004()) {
         return "";
      } else {
         StringBuilder var1 = new StringBuilder(this.method2006());

         for(int var2 = 0; var2 < this.method2006(); ++var2) {
            class381 var3 = this.method2002(var2);
            var1.append(var3.field3624);
         }

         return var1.toString();
      }
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      descriptor = "(IB)V",
      garbageValue = "2"
   )
   public void method2033(int var1) {
      if (this.field3612 != null && var1 < this.field3612.ascent * 2) {
         var1 = Integer.MAX_VALUE;
      }

      if (this.field3616 != var1) {
         this.field3616 = var1;
         this.method2025();
      }

   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "(IB)V",
      garbageValue = "47"
   )
   public void method2003(int var1) {
      if (this.field3614 != var1) {
         this.field3614 = var1;
         this.method2025();
      }

   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      descriptor = "(II)V",
      garbageValue = "-2120915806"
   )
   public void method2029(int var1) {
      if (this.field3621 != var1) {
         this.field3621 = var1;
         this.method2025();
      }

   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      descriptor = "(Lou;I)V",
      garbageValue = "-1950541126"
   )
   public void method2037(AbstractFont var1) {
      if (var1 != this.field3612) {
         this.field3612 = var1;
         if (this.field3612 != null) {
            if (this.field3617 == 0) {
               this.field3617 = this.field3612.ascent;
            }

            if (!this.method2004()) {
               this.method2025();
            }
         }
      }

   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      descriptor = "(IB)V",
      garbageValue = "-57"
   )
   public void method2009(int var1) {
      if (this.field3611 != var1) {
         this.field3611 = var1;
         this.method2025();
      }

   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      descriptor = "(III)Z",
      garbageValue = "1438102335"
   )
   public boolean method2010(int var1, int var2) {
      if (this.field3615 != var1 || var2 != this.field3620) {
         this.field3615 = var1;
         this.field3620 = var2;
         this.method2025();
      }

      return true;
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      descriptor = "(IB)V",
      garbageValue = "-54"
   )
   public void method2011(int var1) {
      if (this.field3617 != var1) {
         this.field3617 = var1;
         this.method2025();
      }

   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      descriptor = "(IIB)Loa;",
      garbageValue = "17"
   )
   public class383 method2035(int var1, int var2) {
      if (var2 == var1) {
         return new class383(this, 0, 0);
      } else if (var1 <= this.field3619.size() && var2 <= this.field3619.size()) {
         return var2 < var1 ? new class383(this, var2, var1) : new class383(this, var1, var2);
      } else {
         return new class383(this, 0, 0);
      }
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      descriptor = "(CIII)Low;",
      garbageValue = "1267710833"
   )
   public class380 method2032(char var1, int var2, int var3) {
      return this.method2012(Character.toString(var1), var2, var3);
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;IIB)Low;",
      garbageValue = "-18"
   )
   public class380 method2012(String var1, int var2, int var3) {
      if (var3 == 0) {
         var3 = Integer.MAX_VALUE;
      }

      int var4 = var2;
      if (this.field3619.size() >= var3) {
         this.method2026(var2, var2);
         return new class380(var2, true);
      } else {
         this.field3619.ensureCapacity(this.field3619.size() + var1.length());

         for(int var5 = 0; var5 < var1.length() && this.field3619.size() < var3; ++var5) {
            class381 var6 = new class381();
            var6.field3624 = var1.charAt(var5);
            this.field3619.add(var4, var6);
            ++var4;
         }

         this.method2026(var2, var4);
         if (this.field3614 != 0 && this.method2021() > this.field3614) {
            while(var4 != var2) {
               --var4;
               this.method2015(var4);
               if (this.method2021() <= this.field3614) {
                  break;
               }
            }

            return new class380(var4, true);
         } else {
            return new class380(var4, false);
         }
      }
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;IB)Low;",
      garbageValue = "24"
   )
   class380 method2013(String var1, int var2) {
      return this.method2012(var1, this.field3619.size(), var2);
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;I)Low;",
      garbageValue = "-844450457"
   )
   public class380 method2014(String var1) {
      this.method2008();
      return this.method2013(var1, 0);
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "-108"
   )
   void method2008() {
      this.field3619.clear();
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      descriptor = "(II)I",
      garbageValue = "1484829823"
   )
   public int method2015(int var1) {
      return this.method2016(var1, var1 + 1);
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "(III)I",
      garbageValue = "572114493"
   )
   public int method2016(int var1, int var2) {
      int var3;
      if (var2 < var1) {
         var3 = var2;
         var2 = var1;
         var1 = var3;
      }

      this.field3619.subList(var1, var2).clear();
      var3 = var1;
      if (this.method2005() && this.field3611 == 1) {
         while(var3 > 0) {
            --var3;
            char var4 = ((class381)this.field3619.get(var3)).field3624;
            if (var4 == ' ' || var4 == '\t') {
               break;
            }
         }
      }

      this.method2026(var3, var2);
      return var1;
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      descriptor = "(IIB)I",
      garbageValue = "-22"
   )
   public int method2017(int var1, int var2) {
      if (this.field3612 == null) {
         return 0;
      } else if (this.method2005() && var1 > this.field3616) {
         return this.field3619.size();
      } else {
         if (!this.field3619.isEmpty()) {
            for(int var3 = 0; var3 < this.field3619.size(); ++var3) {
               class381 var4 = (class381)this.field3619.get(var3);
               if (var2 <= var4.field3625 + this.method2041()) {
                  if (var2 < var4.field3625) {
                     break;
                  }

                  if (var1 < var4.field3623) {
                     return var3 > 0 ? var3 - 1 : 0;
                  }

                  if (var3 + 1 != this.field3619.size() && ((class381)this.field3619.get(var3 + 1)).field3625 != var4.field3625) {
                     int var5 = this.method2028((class381)this.field3619.get(var3), false);
                     if (var1 < var5 + var4.field3623) {
                        return var3;
                     }

                     if (var2 <= var4.field3625 + this.method2041()) {
                        return var3 + 1;
                     }
                  }
               }
            }

            class381 var6 = (class381)this.field3619.get(this.field3619.size() - 1);
            if (var1 >= var6.field3623 && var1 <= var6.field3623 + this.method2036() && var2 >= var6.field3625 && var2 <= var6.field3625 + this.method2041()) {
               return this.field3619.size() - 1;
            }
         }

         return this.field3619.size();
      }
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      descriptor = "(IIB)I",
      garbageValue = "95"
   )
   public int method2018(int var1, int var2) {
      if (this.field3612 != null && !this.method2004() && var1 <= this.field3619.size()) {
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
            class381 var6 = (class381)this.field3619.get(var1 - 1);
            var4 = var6.field3623 + this.method2027(var1 - 1);
            var5 = var6.field3625;
         } else if (var3 == -1 && var1 == 0) {
            return 0;
         }

         int var14 = 16777215;
         int var7 = 0;
         int var8 = var1;
         int var9 = 16777215;
         int var10 = var3 == 1 ? this.field3619.size() + 1 : 0;

         for(int var11 = var3 + var1; var10 != var11; var11 += var3) {
            class381 var12 = (class381)this.field3619.get(var11 - 1);
            if (var5 != var12.field3625) {
               ++var7;
               var5 = var12.field3625;
               if (var7 > var2) {
                  return var8;
               }
            }

            if (var7 == var2) {
               int var13 = Math.abs(var12.field3623 + this.method2027(var11 - 1) - var4);
               if (var13 >= var9) {
                  return var8;
               }

               var8 = var11;
               var9 = var13;
            }
         }

         if (var3 == 1) {
            return this.field3619.size();
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

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "-298165365"
   )
   public int method2019() {
      if (!this.field3619.isEmpty() && this.method2021() == 1) {
         return this.field3619.isEmpty() ? 0 : ((class381)this.field3619.get(this.field3619.size() - 1)).field3623 + this.method2036();
      } else {
         int var1 = -1;
         int var2 = 0;

         for(int var3 = this.field3619.size() - 1; var3 >= 0; --var3) {
            class381 var4 = (class381)this.field3619.get(var3);
            if (var1 != var4.field3625) {
               int var5 = this.method2028(var4, false) + var4.field3623;
               var2 = Math.max(var5, var2);
               var1 = var4.field3625;
            }
         }

         return var2;
      }
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "-1760321375"
   )
   public int method2020() {
      return this.method2004() ? 0 : this.field3612.ascent + ((class381)this.field3619.get(this.field3619.size() - 1)).field3625;
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "-297150195"
   )
   public int method2041() {
      return this.field3617;
   }

   @ObfuscatedName("by")
   @ObfuscatedSignature(
      descriptor = "(B)I",
      garbageValue = "36"
   )
   public int method2021() {
      return this.method2020() / this.field3612.ascent;
   }

   @ObfuscatedName("bb")
   @ObfuscatedSignature(
      descriptor = "(B)I",
      garbageValue = "80"
   )
   int method2036() {
      return this.method2004() ? 0 : this.method2028((class381)this.field3619.get(this.field3619.size() - 1), false);
   }

   @ObfuscatedName("bi")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "-1296915014"
   )
   public int method2038() {
      return this.field3616;
   }

   @ObfuscatedName("be")
   @ObfuscatedSignature(
      descriptor = "(S)I",
      garbageValue = "22905"
   )
   public int method2022() {
      return this.field3614;
   }

   @ObfuscatedName("bk")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "817014315"
   )
   public int method2034() {
      return this.field3611;
   }

   @ObfuscatedName("bx")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "785448473"
   )
   public int method2024() {
      return this.field3621;
   }

   @ObfuscatedName("bo")
   @ObfuscatedSignature(
      descriptor = "(IB)I",
      garbageValue = "88"
   )
   public int method2039(int var1) {
      switch(this.field3615) {
      case 0:
         return 0;
      case 1:
         return var1 / 2;
      case 2:
         return var1;
      default:
         return 0;
      }
   }

   @ObfuscatedName("bz")
   @ObfuscatedSignature(
      descriptor = "(II)I",
      garbageValue = "1521607060"
   )
   public int method2040(int var1) {
      switch(this.field3620) {
      case 0:
         return 0;
      case 1:
         return var1 / 2;
      case 2:
         return var1;
      default:
         return 0;
      }
   }

   @ObfuscatedName("bm")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "-224307219"
   )
   void method2025() {
      this.method2026(0, this.field3619.size());
   }

   @ObfuscatedName("bd")
   @ObfuscatedSignature(
      descriptor = "(III)V",
      garbageValue = "-93545195"
   )
   void method2026(int var1, int var2) {
      if (!this.method2004() && this.field3612 != null) {
         class461 var3 = this.method2001(var1, var2);
         boolean var4 = (Integer)var3.field3972 == 0 && (Integer)var3.field3973 == this.field3619.size();
         int var5 = (Integer)var3.field3972;
         int var6 = 0;
         int var7 = var4 ? 0 : ((class381)this.field3619.get((Integer)var3.field3972)).field3625 * -2052537805 * -727185157;
         int var8 = 0;

         int var9;
         for(var9 = (Integer)var3.field3972; var9 <= (Integer)var3.field3973; ++var9) {
            boolean var10 = var9 >= this.field3619.size();
            class381 var11 = (class381)this.field3619.get(!var10 ? var9 : this.field3619.size() - 1);
            int var12 = !var10 ? this.method2028(var11, false) : 0;
            boolean var13 = !var10 && var11.field3624 == '\n';
            boolean var14 = !var10 && this.method2005() && var6 + var12 > this.field3616;
            if (var13 || var14 || var10) {
               int var15 = var9;
               int var16 = 0;
               int var17;
               int var18;
               class381 var19;
               if (var14) {
                  var17 = 0;
                  if (this.field3611 == 1) {
                     for(var18 = var9; var18 > var5; --var18) {
                        var19 = (class381)this.field3619.get(var18);
                        var17 += var18 < var15 ? this.method2028(var19, false) : 0;
                        if (var19.field3624 == ' ' || var19.field3624 == '\n') {
                           var15 = var18;
                           var6 -= var17;
                           var16 = var17;
                           break;
                        }
                     }
                  }
               }

               var17 = -this.method2039(var6);

               for(var18 = var5; var18 < var15; ++var18) {
                  var19 = (class381)this.field3619.get(var18);
                  int var20 = this.method2028(var19, false);
                  var19.field3623 = var17;
                  var19.field3625 = var7;
                  var17 += var20;
               }

               var5 = var15;
               var6 = var16;
               var7 += this.method2041();
               ++var8;
            }

            var6 += !var10 ? var12 : 0;
         }

         if (this.field3620 != 0 && var4) {
            var9 = var8 * this.method2041();
            int var23 = this.method2040(var9);

            for(int var21 = 0; var21 < this.field3619.size(); ++var21) {
               class381 var22 = (class381)this.field3619.get(var21);
               var22.field3625 -= var23;
            }
         }

      }
   }

   @ObfuscatedName("bt")
   @ObfuscatedSignature(
      descriptor = "(II)I",
      garbageValue = "-465870520"
   )
   int method2027(int var1) {
      return var1 < this.field3619.size() ? this.method2028((class381)this.field3619.get(var1), false) : 0;
   }

   @ObfuscatedName("bj")
   @ObfuscatedSignature(
      descriptor = "(Lom;ZI)I",
      garbageValue = "-935952959"
   )
   int method2028(class381 var1, boolean var2) {
      if (var1.field3624 == '\n') {
         return 0;
      } else if (this.field3621 == 0) {
         int var3 = this.field3612.advances[var1.field3624];
         if (var3 == 0) {
            return var1.field3624 == '\t' ? this.field3612.advances[32] * 3 : this.field3612.advances[32];
         } else {
            return var3;
         }
      } else {
         return this.field3612.advances[42];
      }
   }

   @ObfuscatedName("bn")
   @ObfuscatedSignature(
      descriptor = "(III)Lrg;",
      garbageValue = "2105841802"
   )
   class461 method2001(int var1, int var2) {
      int var3 = Math.min(var1, var2);
      int var4 = Math.max(var1, var2);
      int var5 = this.field3619.size();
      if (var3 == 0 && var4 == var5) {
         return new class461(0, var5);
      } else {
         int var6 = this.method2030(var3, false);
         int var7 = this.method2031(var4, false);
         int var8;
         switch(this.field3620) {
         case 0:
            if (this.field3615 == 0) {
               return new class461(var6, var5);
            }

            var8 = this.method2030(var3, true);
            return new class461(var8, var5);
         case 1:
            return new class461(0, var5);
         case 2:
            if (this.field3615 == 2) {
               return new class461(0, var7);
            }

            var8 = this.method2031(var4, true);
            return new class461(0, var8);
         default:
            return new class461(0, var5);
         }
      }
   }

   @ObfuscatedName("bs")
   @ObfuscatedSignature(
      descriptor = "(IZI)I",
      garbageValue = "-423936082"
   )
   int method2030(int var1, boolean var2) {
      if (var1 < this.field3619.size()) {
         int var3 = ((class381)this.field3619.get(var1)).field3625;

         for(int var4 = var1; var4 > 0; --var4) {
            if (((class381)this.field3619.get(var4 - 1)).field3625 < var3) {
               if (!var2) {
                  return var4;
               }

               var2 = false;
               var3 = ((class381)this.field3619.get(var4 - 1)).field3625;
            }
         }
      }

      return 0;
   }

   @ObfuscatedName("br")
   @ObfuscatedSignature(
      descriptor = "(IZI)I",
      garbageValue = "-985100260"
   )
   int method2031(int var1, boolean var2) {
      if (var1 < this.field3619.size()) {
         int var3 = ((class381)this.field3619.get(var1)).field3625;

         for(int var4 = var1; var4 < this.field3619.size() - 1; ++var4) {
            if (((class381)this.field3619.get(var4 + 1)).field3625 > var3) {
               if (!var2) {
                  return var4;
               }

               var2 = false;
               var3 = ((class381)this.field3619.get(var4 + 1)).field3625;
            }
         }
      }

      return this.field3619.size();
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "-59"
   )
   public static void method2042() {
      ItemComposition.ItemDefinition_cached.clear();
      ItemComposition.ItemDefinition_cachedModels.clear();
      ItemComposition.ItemDefinition_cachedSprites.clear();
   }

    @ObfuscatedName("nl")
    @ObfuscatedSignature(
            descriptor = "(Ljava/lang/String;I)V",
            garbageValue = "613256531"
    )
    static final void Clan_joinChat(String var0) {
      if (!var0.equals("")) {
         PacketBufferNode var1 = class330.getPacketBufferNode(ClientPacket.field2508, Client.packetWriter.isaacCipher);
         var1.packetBuffer.writeByte(DynamicObject.stringCp1252NullTerminatedByteSize(var0));
         var1.packetBuffer.writeStringCp1252NullTerminated(var0);
         Client.packetWriter.addNode(var1);
      }
   }
}
