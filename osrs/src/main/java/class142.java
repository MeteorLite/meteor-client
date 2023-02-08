import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ex")
public class class142 {
   @ObfuscatedName("f")
   long field1308;
   @ObfuscatedName("w")
   int field1309 = -1;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "Lmt;"
   )
   IterableNodeDeque field1307 = new IterableNodeDeque();

   @ObfuscatedSignature(
      descriptor = "(Lrd;)V"
   )
   public class142(Buffer var1) {
      this.method758(var1);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "(Lrd;B)V",
      garbageValue = "-63"
   )
   void method758(Buffer var1) {
      this.field1308 = var1.readLong();
      this.field1309 = var1.readInt();

      for(int var2 = var1.readUnsignedByte(); var2 != 0; var2 = var1.readUnsignedByte()) {
         Object var3;
         if (var2 == 3) {
            var3 = new class161(this);
         } else if (var2 == 1) {
            var3 = new class137(this);
         } else if (var2 == 13) {
            var3 = new class154(this);
         } else if (var2 == 4) {
            var3 = new class146(this);
         } else if (var2 == 6) {
            var3 = new class153(this);
         } else if (var2 == 5) {
            var3 = new class138(this);
         } else if (var2 == 2) {
            var3 = new class143(this);
         } else if (var2 == 7) {
            var3 = new class136(this);
         } else if (var2 == 14) {
            var3 = new class140(this);
         } else if (var2 == 8) {
            var3 = new class157(this);
         } else if (var2 == 9) {
            var3 = new class163(this);
         } else if (var2 == 10) {
            var3 = new class149(this);
         } else if (var2 == 11) {
            var3 = new class144(this);
         } else if (var2 == 12) {
            var3 = new class148(this);
         } else {
            if (var2 != 15) {
               throw new RuntimeException("");
            }

            var3 = new class158(this);
         }

         ((class139)var3).vmethod3254(var1);
         this.field1307.addFirst((Node)var3);
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      descriptor = "(Leb;B)V",
      garbageValue = "55"
   )
   public void method759(ClanSettings var1) {
      if (this.field1308 == var1.field1342 && this.field1309 == var1.field1343) {
         for(class139 var2 = (class139)this.field1307.last(); var2 != null; var2 = (class139)this.field1307.previous()) {
            var2.vmethod3248(var1);
         }

         ++var1.field1343;
      } else {
         throw new RuntimeException("");
      }
   }

    @ObfuscatedName("w")
    @ObfuscatedSignature(
            descriptor = "(Ljava/lang/CharSequence;I)Z",
            garbageValue = "-2070835107"
    )
    public static boolean isNumber(CharSequence var0) {
      boolean var2 = false;
      boolean var3 = false;
      int var4 = 0;
      int var5 = var0.length();
      int var6 = 0;

      boolean var1;
      while(true) {
         if (var6 >= var5) {
            var1 = var3;
            break;
         }

         label69: {
            char var7 = var0.charAt(var6);
            if (var6 == 0) {
               if (var7 == '-') {
                  var2 = true;
                  break label69;
               }

               if (var7 == '+') {
                  break label69;
               }
            }

            int var9;
            if (var7 >= '0' && var7 <= '9') {
               var9 = var7 - 48;
            } else if (var7 >= 'A' && var7 <= 'Z') {
               var9 = var7 - 55;
            } else {
               if (var7 < 'a' || var7 > 'z') {
                  var1 = false;
                  break;
               }

               var9 = var7 - 87;
            }

            if (var9 >= 10) {
               var1 = false;
               break;
            }

            if (var2) {
               var9 = -var9;
            }

            int var8 = var4 * 10 + var9;
            if (var4 != var8 / 10) {
               var1 = false;
               break;
            }

            var4 = var8;
            var3 = true;
         }

         ++var6;
      }

      return var1;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      descriptor = "([BIIIIIIIII[Lgv;I)V",
      garbageValue = "1595690184"
   )
   static final void method760(byte[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, CollisionMap[] var10) {
      int var12;
      for(int var11 = 0; var11 < 8; ++var11) {
         for(var12 = 0; var12 < 8; ++var12) {
            if (var11 + var2 > 0 && var11 + var2 < 103 && var3 + var12 > 0 && var3 + var12 < 103) {
               var10[var1].flags[var11 + var2][var12 + var3] &= -16777217;
            }
         }
      }

      Buffer var19 = new Buffer(var0);

      for(var12 = 0; var12 < 4; ++var12) {
         for(int var13 = 0; var13 < 64; ++var13) {
            for(int var14 = 0; var14 < 64; ++var14) {
               if (var12 == var4 && var13 >= var5 && var13 < var5 + 8 && var14 >= var6 && var14 < var6 + 8) {
                  int var15 = var2 + class133.method727(var13 & 7, var14 & 7, var7);
                  int var16 = var3 + class147.method781(var13 & 7, var14 & 7, var7);
                  int var17 = (var13 & 7) + var8 + var2;
                  int var18 = var3 + (var14 & 7) + var9;
                  class427.loadTerrain(var19, var1, var15, var16, var17, var18, var7);
               } else {
                  class427.loadTerrain(var19, 0, -1, -1, 0, 0, 0);
               }
            }
         }
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "-354459934"
   )
   public static final void method757() {
      ViewportMouse.ViewportMouse_isInViewport = false;
      ViewportMouse.ViewportMouse_entityCount = 0;
   }
}
