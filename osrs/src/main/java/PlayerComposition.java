import java.util.Arrays;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("mw")
@Implements("PlayerComposition")
public class PlayerComposition {
   @ObfuscatedName("ay")
   public static short[] field2837;
   @ObfuscatedName("ao")
   public static short[][] field2828;
    @ObfuscatedName("ag")
    static final int[] equipmentIndices;
    @ObfuscatedName("ar")
    @ObfuscatedSignature(
            descriptor = "Lkh;"
    )
    static EvictingDualNodeHashTable PlayerAppearance_cachedModels;
   @ObfuscatedName("af")
   int[] field2841;
    @ObfuscatedName("an")
    int[] equipment;
    @ObfuscatedName("aw")
    int[] bodyColors;
   @ObfuscatedName("ac")
   public int field2831 = -1;
   @ObfuscatedName("au")
   public int field2840 = 0;
    @ObfuscatedName("ab")
    public int npcTransformId;
    @ObfuscatedName("aq")
    long hash;
   @ObfuscatedName("al")
   long field2834;
    @ObfuscatedName("at")
    @ObfuscatedSignature(
            descriptor = "[Lgx;"
    )
    ObjTypeCustomisation[] customisations;
    @ObfuscatedName("aa")
    boolean isFemale = false;

   static {
      equipmentIndices = new int[]{class204.field1839.field1831, class204.field1840.field1831, class204.field1835.field1831, class204.field1837.field1831, class204.field1834.field1831, class204.field1838.field1831, class204.field1843.field1831};
      PlayerAppearance_cachedModels = new EvictingDualNodeHashTable(260);
   }

   public PlayerComposition() {
   }

   @ObfuscatedSignature(
      descriptor = "(Lmw;)V"
   )
   PlayerComposition(PlayerComposition var1) {
      int[] var2 = Arrays.copyOf(var1.equipment, var1.equipment.length);
      int[] var3 = Arrays.copyOf(var1.field2841, var1.field2841.length);
      ObjTypeCustomisation[] var4 = (ObjTypeCustomisation[])(var1.customisations != null ? (ObjTypeCustomisation[])Arrays.copyOf(var1.customisations, var1.customisations.length) : null);
      int[] var5 = Arrays.copyOf(var1.bodyColors, var1.bodyColors.length);
      this.method1692(var3, var2, var4, false, var5, var1.field2840, var1.npcTransformId, var1.field2831);
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      descriptor = "([I[I[Lgx;Z[IIIIB)V",
      garbageValue = "21"
   )
   public void method1692(int[] var1, int[] var2, ObjTypeCustomisation[] var3, boolean var4, int[] var5, int var6, int var7, int var8) {
      this.customisations = var3;
      this.isFemale = var4;
      this.field2831 = var8;
      this.method1693(var1, var2, var5, var6, var7);
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "([I[I[IIII)V",
      garbageValue = "1564496359"
   )
   public void method1693(int[] var1, int[] var2, int[] var3, int var4, int var5) {
      if (var1 == null) {
         var1 = this.method1697(var4);
      }

      if (var2 == null) {
         var2 = this.method1697(var4);
      }

      this.field2841 = var1;
      this.equipment = var2;
      this.bodyColors = var3;
      this.field2840 = var4;
      this.npcTransformId = var5;
      this.setHash();
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      descriptor = "(II)[I",
      garbageValue = "-1826313610"
   )
   int[] method1697(int var1) {
      int[] var2 = new int[12];

      for(int var3 = 0; var3 < 7; ++var3) {
         class163.method915(var1, var2, var3);
      }

      return var2;
   }

    @ObfuscatedName("au")
    @ObfuscatedSignature(
            descriptor = "(IZI)V",
            garbageValue = "-1645926709"
    )
    public void changeAppearance(int var1, boolean var2) {
      if (var1 != 1 || this.field2840 != 1) {
         int var3 = this.equipment[equipmentIndices[var1]];
         if (var3 != 0) {
            var3 -= 256;

            KitDefinition var4;
            do {
               if (!var2) {
                  --var3;
                  if (var3 < 0) {
                     var3 = KitDefinition.KitDefinition_fileCount - 1;
                  }
               } else {
                  ++var3;
                  if (var3 >= KitDefinition.KitDefinition_fileCount) {
                     var3 = 0;
                  }
               }

               var4 = class100.KitDefinition_get(var3);
            } while(var4 == null || var4.nonSelectable || var4.bodypartID != var1 + (this.field2840 == 1 ? 7 : 0));

            this.equipment[equipmentIndices[var1]] = var3 + 256;
            this.setHash();
         }
      }
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "(IZI)V",
      garbageValue = "-1999663188"
   )
   public void method1699(int var1, boolean var2) {
      int var3 = this.bodyColors[var1];
      if (!var2) {
         do {
            --var3;
            if (var3 < 0) {
               var3 = field2828[var1].length - 1;
            }
         } while(!ClanSettings.method869(var1, var3));
      } else {
         do {
            ++var3;
            if (var3 >= field2828[var1].length) {
               var3 = 0;
            }
         } while(!ClanSettings.method869(var1, var3));
      }

      this.bodyColors[var1] = var3;
      this.setHash();
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      descriptor = "(II)V",
      garbageValue = "1411028779"
   )
   public void method1694(int var1) {
      if (this.field2840 != var1) {
         this.method1693((int[])null, (int[])null, this.bodyColors, var1, -1);
      }
   }

    @ObfuscatedName("al")
    @ObfuscatedSignature(
            descriptor = "(Lsg;B)V",
            garbageValue = "64"
    )
    public void write(Buffer var1) {
      var1.writeByte(this.field2840);

      int var2;
      for(var2 = 0; var2 < 7; ++var2) {
         int var3 = this.equipment[equipmentIndices[var2]];
         if (var3 == 0) {
            var1.writeByte(-1);
         } else {
            var1.writeByte(var3 - 256);
         }
      }

      for(var2 = 0; var2 < 5; ++var2) {
         var1.writeByte(this.bodyColors[var2]);
      }

   }

    @ObfuscatedName("at")
    @ObfuscatedSignature(
            descriptor = "(I)V",
            garbageValue = "1418315210"
    )
    void setHash() {
      long var1 = this.hash;
      int var3 = this.equipment[5];
      int var4 = this.equipment[9];
      this.equipment[5] = var4;
      this.equipment[9] = var3;
      this.hash = 0L;

      int var5;
      for(var5 = 0; var5 < 12; ++var5) {
         this.hash <<= 4;
         if (this.equipment[var5] >= 256) {
            this.hash += (long)(this.equipment[var5] - 256);
         }
      }

      if (this.equipment[0] >= 256) {
         this.hash += (long)(this.equipment[0] - 256 >> 4);
      }

      if (this.equipment[1] >= 256) {
         this.hash += (long)(this.equipment[1] - 256 >> 8);
      }

      for(var5 = 0; var5 < 5; ++var5) {
         this.hash <<= 3;
         this.hash += (long)this.bodyColors[var5];
      }

      this.hash <<= 1;
      this.hash += (long)this.field2840;
      this.equipment[5] = var3;
      this.equipment[9] = var4;
      if (var1 != 0L && this.hash != var1 || this.isFemale) {
         PlayerAppearance_cachedModels.remove(var1);
      }

   }

    @ObfuscatedName("aa")
    @ObfuscatedSignature(
            descriptor = "(Lha;ILha;IB)Lit;",
            garbageValue = "42"
    )
    public Model getModel(SequenceDefinition var1, int var2, SequenceDefinition var3, int var4) {
      if (this.npcTransformId != -1) {
         return AbstractArchive.getNpcDefinition(this.npcTransformId).method1021(var1, var2, var3, var4, (NewShit)null);
      } else {
         long var5 = this.hash;
         int[] var7 = this.equipment;
         if (var1 != null && (var1.shield >= 0 || var1.weapon >= 0)) {
            var7 = new int[12];

            for(int var8 = 0; var8 < 12; ++var8) {
               var7[var8] = this.equipment[var8];
            }

            if (var1.shield >= 0) {
               var5 += (long)(var1.shield - this.equipment[5] << 40);
               var7[5] = var1.shield;
            }

            if (var1.weapon >= 0) {
               var5 += (long)(var1.weapon - this.equipment[3] << 48);
               var7[3] = var1.weapon;
            }
         }

         Model var18 = (Model)PlayerAppearance_cachedModels.get(var5);
         if (var18 == null) {
            boolean var9 = false;

            int var11;
            for(int var10 = 0; var10 < 12; ++var10) {
               var11 = var7[var10];
               if (var11 >= 256 && var11 < 512 && !class100.KitDefinition_get(var11 - 256).ready()) {
                  var9 = true;
               }

               if (var11 >= 512 && !HealthBarUpdate.ItemDefinition_get(var11 - 512).method1104(this.field2840)) {
                  var9 = true;
               }
            }

            if (var9) {
               if (-1L != this.field2834) {
                  var18 = (Model)PlayerAppearance_cachedModels.get(this.field2834);
               }

               if (var18 == null) {
                  return null;
               }
            }

            if (var18 == null) {
               ModelData[] var19 = new ModelData[12];
               var11 = 0;

               int var13;
               for(int var12 = 0; var12 < 12; ++var12) {
                  var13 = var7[var12];
                  if (var13 >= 256 && var13 < 512) {
                     ModelData var14 = class100.KitDefinition_get(var13 - 256).getModelData();
                     if (var14 != null) {
                        var19[var11++] = var14;
                     }
                  }

                  if (var13 >= 512) {
                     ItemComposition var22 = HealthBarUpdate.ItemDefinition_get(var13 - 512);
                     ModelData var15 = var22.method1111(this.field2840);
                     if (var15 != null) {
                        if (this.customisations != null) {
                           ObjTypeCustomisation var16 = this.customisations[var12];
                           if (var16 != null) {
                              int var17;
                              if (var16.recol != null && var22.recolorFrom != null && var22.recolorTo.length == var16.recol.length) {
                                 for(var17 = 0; var17 < var22.recolorFrom.length; ++var17) {
                                    var15.recolor(var22.recolorTo[var17], var16.recol[var17]);
                                 }
                              }

                              if (var16.retex != null && var22.retextureFrom != null && var16.retex.length == var22.retextureTo.length) {
                                 for(var17 = 0; var17 < var22.retextureFrom.length; ++var17) {
                                    var15.retexture(var22.retextureTo[var17], var16.retex[var17]);
                                 }
                              }
                           }
                        }

                        var19[var11++] = var15;
                     }
                  }
               }

               ModelData var20 = new ModelData(var19, var11);

               for(var13 = 0; var13 < 5; ++var13) {
                  if (this.bodyColors[var13] < field2828[var13].length) {
                     var20.recolor(field2837[var13], field2828[var13][this.bodyColors[var13]]);
                  }

                  if (this.bodyColors[var13] < class437.field3825[var13].length) {
                     var20.recolor(WorldMapIcon_0.field2359[var13], class437.field3825[var13][this.bodyColors[var13]]);
                  }
               }

               var18 = var20.toModel(64, 850, -30, -50, -30);
               PlayerAppearance_cachedModels.put(var18, var5);
               this.field2834 = var5;
            }
         }

         Model var21;
         if (var1 == null && var3 == null) {
            var21 = var18.toSharedSequenceModel(true);
         } else if (var1 != null && var3 != null) {
            var21 = var1.applyTransformations(var18, var2, var3, var4);
         } else if (var1 != null) {
            var21 = var1.transformActorModel(var18, var2);
         } else {
            var21 = var3.transformActorModel(var18, var4);
         }

         return var21;
      }
   }

    @ObfuscatedName("ay")
    @ObfuscatedSignature(
            descriptor = "(B)Liz;",
            garbageValue = "126"
    )
    ModelData getModelData() {
      if (this.npcTransformId != -1) {
         return AbstractArchive.getNpcDefinition(this.npcTransformId).method1022((NewShit)null);
      } else {
         boolean var1 = false;

         int var3;
         for(int var2 = 0; var2 < 12; ++var2) {
            var3 = this.equipment[var2];
            if (var3 >= 256 && var3 < 512 && !class100.KitDefinition_get(var3 - 256).method997()) {
               var1 = true;
            }

            if (var3 >= 512 && !HealthBarUpdate.ItemDefinition_get(var3 - 512).method1105(this.field2840)) {
               var1 = true;
            }
         }

         if (var1) {
            return null;
         } else {
            ModelData[] var7 = new ModelData[12];
            var3 = 0;

            int var5;
            for(int var4 = 0; var4 < 12; ++var4) {
               var5 = this.equipment[var4];
               ModelData var6;
               if (var5 >= 256 && var5 < 512) {
                  var6 = class100.KitDefinition_get(var5 - 256).getKitDefinitionModels();
                  if (var6 != null) {
                     var7[var3++] = var6;
                  }
               }

               if (var5 >= 512) {
                  var6 = HealthBarUpdate.ItemDefinition_get(var5 - 512).method1106(this.field2840);
                  if (var6 != null) {
                     var7[var3++] = var6;
                  }
               }
            }

            ModelData var8 = new ModelData(var7, var3);

            for(var5 = 0; var5 < 5; ++var5) {
               if (this.bodyColors[var5] < field2828[var5].length) {
                  var8.recolor(field2837[var5], field2828[var5][this.bodyColors[var5]]);
               }

               if (this.bodyColors[var5] < class437.field3825[var5].length) {
                  var8.recolor(WorldMapIcon_0.field2359[var5], class437.field3825[var5][this.bodyColors[var5]]);
               }
            }

            return var8;
         }
      }
   }

    @ObfuscatedName("ao")
    @ObfuscatedSignature(
            descriptor = "(S)I",
            garbageValue = "5890"
    )
    public int getChatHeadId() {
      return this.npcTransformId == -1 ? (this.equipment[0] << 15) + this.equipment[1] + (this.equipment[11] << 5) + (this.equipment[8] << 10) + (this.bodyColors[0] << 25) + (this.bodyColors[4] << 20) : 305419896 + AbstractArchive.getNpcDefinition(this.npcTransformId).id;
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "-469114674"
   )
   void method1702() {
      this.method1693(this.field2841, this.equipment, this.bodyColors, this.field2840, this.npcTransformId);
   }

   @ObfuscatedName("af")
   public static final void method1704(long var0) {
      if (var0 > 0L) {
         if (0L == var0 % 10L) {
            long var2 = var0 - 1L;

            try {
               Thread.sleep(var2);
            } catch (InterruptedException var8) {
               ;
            }

            try {
               Thread.sleep(1L);
            } catch (InterruptedException var7) {
               ;
            }
         } else {
            try {
               Thread.sleep(var0);
            } catch (InterruptedException var6) {
               ;
            }
         }

      }
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/CharSequence;B)[B",
      garbageValue = "-35"
   )
   public static byte[] method1703(CharSequence var0) {
      int var1 = var0.length();
      byte[] var2 = new byte[var1];

      for(int var3 = 0; var3 < var1; ++var3) {
         char var4 = var0.charAt(var3);
         if (var4 > 127) {
            var2[var3] = 63;
         } else {
            var2[var3] = (byte)var4;
         }
      }

      return var2;
   }
}
