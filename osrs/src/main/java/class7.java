import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("al")
public class class7 {
    @ObfuscatedName("gm")
    static int playerUUIDLength;
    @ObfuscatedName("mp")
    @ObfuscatedSignature(
            descriptor = "Lim;"
    )
    static TextureProvider textureProvider;
   @ObfuscatedName("af")
   ExecutorService field16 = Executors.newSingleThreadExecutor();
   @ObfuscatedName("an")
   Future field14;
   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      descriptor = "Lsg;"
   )
   final Buffer field11;
   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "Lac;"
   )
   final class3 field12;

   @ObfuscatedSignature(
      descriptor = "(Lsg;Lac;)V"
   )
   public class7(Buffer var1, class3 var2) {
      this.field11 = var1;
      this.field12 = var2;
      this.method23();
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      descriptor = "(I)Z",
      garbageValue = "-571674084"
   )
   public boolean method25() {
      return this.field14.isDone();
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "47"
   )
   public void method21() {
      this.field16.shutdown();
      this.field16 = null;
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      descriptor = "(I)Lsg;",
      garbageValue = "1213555586"
   )
   public Buffer method22() {
      try {
         return (Buffer)this.field14.get();
      } catch (Exception var2) {
         return null;
      }
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "(S)V",
      garbageValue = "32199"
   )
   void method23() {
      this.field14 = this.field16.submit(new class1(this, this.field11, this.field12));
   }

    @ObfuscatedName("aw")
    @ObfuscatedSignature(
            descriptor = "(DIII)V",
            garbageValue = "-1907908914"
    )
    static void Rasterizer3D_buildPalette(double var0, int var2, int var3) {
      int var4 = var2 * 128;

      for(int var5 = var2; var5 < var3; ++var5) {
         double var6 = (double)(var5 >> 3) / 64.0D + 0.0078125D;
         double var8 = 0.0625D + (double)(var5 & 7) / 8.0D;

         for(int var10 = 0; var10 < 128; ++var10) {
            double var11 = (double)var10 / 128.0D;
            double var13 = var11;
            double var15 = var11;
            double var17 = var11;
            if (var8 != 0.0D) {
               double var19;
               if (var11 < 0.5D) {
                  var19 = var11 * (var8 + 1.0D);
               } else {
                  var19 = var8 + var11 - var8 * var11;
               }

               double var21 = var11 * 2.0D - var19;
               double var23 = var6 + 0.3333333333333333D;
               if (var23 > 1.0D) {
                  --var23;
               }

               double var27 = var6 - 0.3333333333333333D;
               if (var27 < 0.0D) {
                  ++var27;
               }

               if (var23 * 6.0D < 1.0D) {
                  var13 = var23 * 6.0D * (var19 - var21) + var21;
               } else if (var23 * 2.0D < 1.0D) {
                  var13 = var19;
               } else if (var23 * 3.0D < 2.0D) {
                  var13 = var21 + 6.0D * (0.6666666666666666D - var23) * (var19 - var21);
               } else {
                  var13 = var21;
               }

               if (var6 * 6.0D < 1.0D) {
                  var15 = var21 + (var19 - var21) * 6.0D * var6;
               } else if (var6 * 2.0D < 1.0D) {
                  var15 = var19;
               } else if (var6 * 3.0D < 2.0D) {
                  var15 = var21 + (var19 - var21) * (0.6666666666666666D - var6) * 6.0D;
               } else {
                  var15 = var21;
               }

               if (var27 * 6.0D < 1.0D) {
                  var17 = var27 * (var19 - var21) * 6.0D + var21;
               } else if (var27 * 2.0D < 1.0D) {
                  var17 = var19;
               } else if (var27 * 3.0D < 2.0D) {
                  var17 = 6.0D * (var19 - var21) * (0.6666666666666666D - var27) + var21;
               } else {
                  var17 = var21;
               }
            }

            int var29 = (int)(var13 * 256.0D);
            int var20 = (int)(var15 * 256.0D);
            int var30 = (int)(var17 * 256.0D);
            int var22 = var30 + (var20 << 8) + (var29 << 16);
            var22 = UrlRequest.Rasterizer3D_brighten(var22, var0);
            if (var22 == 0) {
               var22 = 1;
            }

            Rasterizer3D.Rasterizer3D_colorPalette[var4++] = var22;
         }
      }

   }

    @ObfuscatedName("at")
    @ObfuscatedSignature(
            descriptor = "(Lmq;I[B[BI)V",
            garbageValue = "1887295232"
    )
    static final void Widget_setKey(Widget var0, int var1, byte[] var2, byte[] var3) {
      if (var0.field2954 == null) {
         if (var2 == null) {
            return;
         }

         var0.field2954 = new byte[11][];
         var0.field2955 = new byte[11][];
         var0.field2936 = new int[11];
         var0.field2977 = new int[11];
      }

      var0.field2954[var1] = var2;
      if (var2 != null) {
         var0.field2891 = true;
      } else {
         var0.field2891 = false;

         for(int var4 = 0; var4 < var0.field2954.length; ++var4) {
            if (var0.field2954[var4] != null) {
               var0.field2891 = true;
               break;
            }
         }
      }

      var0.field2955[var1] = var3;
   }

    @ObfuscatedName("md")
    @ObfuscatedSignature(
            descriptor = "(II)V",
            garbageValue = "2026496728"
    )
    static final void changeGameOptions(int var0) {
      ClientPacket.process();
      class18.method71();
      int var1 = GraphicsDefaults.VarpDefinition_get(var0).type;
      if (var1 != 0) {
         int var2 = Varps.Varps_main[var0];
         if (var1 == 1) {
            if (var2 == 1) {
               ScriptFrame.method341(0.9D);
            }

            if (var2 == 2) {
               ScriptFrame.method341(0.8D);
            }

            if (var2 == 3) {
               ScriptFrame.method341(0.7D);
            }

            if (var2 == 4) {
               ScriptFrame.method341(0.6D);
            }
         }

         if (var1 == 3) {
            if (var2 == 0) {
               class86.method502(255);
            }

            if (var2 == 1) {
               class86.method502(192);
            }

            if (var2 == 2) {
               class86.method502(128);
            }

            if (var2 == 3) {
               class86.method502(64);
            }

            if (var2 == 4) {
               class86.method502(0);
            }
         }

         if (var1 == 4) {
            if (var2 == 0) {
               class130.method764(127);
            }

            if (var2 == 1) {
               class130.method764(96);
            }

            if (var2 == 2) {
               class130.method764(64);
            }

            if (var2 == 3) {
               class130.method764(32);
            }

            if (var2 == 4) {
               class130.method764(0);
            }
         }

         if (var1 == 5) {
            Client.leftClickOpensMenu = var2 == 1;
         }

         if (var1 == 6) {
            Client.chatEffects = var2;
         }

         if (var1 == 9) {
            ;
         }

         if (var1 == 10) {
            if (var2 == 0) {
               class135.method783(127);
            }

            if (var2 == 1) {
               class135.method783(96);
            }

            if (var2 == 2) {
               class135.method783(64);
            }

            if (var2 == 3) {
               class135.method783(32);
            }

            if (var2 == 4) {
               class135.method783(0);
            }
         }

         if (var1 == 17) {
            Client.followerIndex = var2 & '\uffff';
         }

         if (var1 == 18) {
            Client.playerAttackOption = (AttackOption)StructComposition.findEnumerated(UserComparator4.method685(), var2);
            if (Client.playerAttackOption == null) {
               Client.playerAttackOption = AttackOption.AttackOption_dependsOnCombatLevels;
            }
         }

         if (var1 == 19) {
            if (var2 == -1) {
               Client.combatTargetPlayerIndex = -1;
            } else {
               Client.combatTargetPlayerIndex = var2 & 2047;
            }
         }

         if (var1 == 22) {
            Client.npcAttackOption = (AttackOption)StructComposition.findEnumerated(UserComparator4.method685(), var2);
            if (Client.npcAttackOption == null) {
               Client.npcAttackOption = AttackOption.AttackOption_dependsOnCombatLevels;
            }
         }

      }
   }
}
