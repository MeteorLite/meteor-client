import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ko")
@Implements("PlayerComposition")
public class PlayerComposition {
   @ObfuscatedName("o")
   static final int[] equipmentIndices = new int[]{8, 11, 4, 6, 9, 7, 10};
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      descriptor = "Ljv;"
   )
   static EvictingDualNodeHashTable PlayerAppearance_cachedModels = new EvictingDualNodeHashTable(260);
   @ObfuscatedName("h")
   int[] equipment;
   @ObfuscatedName("e")
   int[] bodyColors;
   @ObfuscatedName("v")
   public int field2820 = -1;
   @ObfuscatedName("x")
   public int field2818 = 0;
   @ObfuscatedName("m")
   public int npcTransformId;
   @ObfuscatedName("q")
   long hash;
   @ObfuscatedName("f")
   long field2821;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      descriptor = "[Lfx;"
   )
   ObjTypeCustomisation[] customisations;
   @ObfuscatedName("u")
   boolean isFemale = false;

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "([I[Lfx;Z[IIIII)V",
      garbageValue = "-1317748076"
   )
   public void setAppearance(int[] var1, ObjTypeCustomisation[] var2, boolean var3, int[] var4, int var5, int var6, int var7) {
      this.customisations = var2;
      this.isFemale = var3;
      this.field2820 = var7;
      this.initiateAppearance(var1, var4, var5, var6);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "([I[IIIB)V",
      garbageValue = "53"
   )
   public void initiateAppearance(int[] var1, int[] var2, int var3, int var4) {
      if (var1 == null) {
         var1 = new int[12];

         for(int var5 = 0; var5 < 7; ++var5) {
            for(int var6 = 0; var6 < class71.KitDefinition_fileCount; ++var6) {
               KitDefinition var7 = AbstractSocket.KitDefinition_get(var6);
               if (var7 != null && !var7.nonSelectable && var7.bodypartID == var5 + (var3 == 1 ? 7 : 0)) {
                  var1[equipmentIndices[var5]] = var6 + 256;
                  break;
               }
            }
         }
      }

      this.equipment = var1;
      this.bodyColors = var2;
      this.field2818 = var3;
      this.npcTransformId = var4;
      this.setHash();
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "(IZB)V",
      garbageValue = "-11"
   )
   public void changeAppearance(int var1, boolean var2) {
      if (var1 != 1 || this.field2818 != 1) {
         int var3 = this.equipment[equipmentIndices[var1]];
         if (var3 != 0) {
            var3 -= 256;

            KitDefinition var4;
            do {
               if (!var2) {
                  --var3;
                  if (var3 < 0) {
                     var3 = class71.KitDefinition_fileCount - 1;
                  }
               } else {
                  ++var3;
                  if (var3 >= class71.KitDefinition_fileCount) {
                     var3 = 0;
                  }
               }

               var4 = AbstractSocket.KitDefinition_get(var3);
            } while(var4 == null || var4.nonSelectable || var4.bodypartID != (this.field2818 == 1 ? 7 : 0) + var1);

            this.equipment[equipmentIndices[var1]] = var3 + 256;
            this.setHash();
         }
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      descriptor = "(IZI)V",
      garbageValue = "906587072"
   )
   public void method1623(int var1, boolean var2) {
      int var3 = this.bodyColors[var1];
      if (!var2) {
         do {
            --var3;
            if (var3 < 0) {
               var3 = TriBool.field3706[var1].length - 1;
            }
         } while(!UserComparator7.method665(var1, var3));
      } else {
         do {
            ++var3;
            if (var3 >= TriBool.field3706[var1].length) {
               var3 = 0;
            }
         } while(!UserComparator7.method665(var1, var3));
      }

      this.bodyColors[var1] = var3;
      this.setHash();
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      descriptor = "(II)V",
      garbageValue = "-1044750621"
   )
   public void method1624(int var1) {
      if (this.field2818 != var1) {
         this.initiateAppearance((int[])null, this.bodyColors, var1, -1);
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      descriptor = "(Lqy;B)V",
      garbageValue = "11"
   )
   public void write(Buffer var1) {
      var1.writeByte(this.field2818);

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

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "(S)V",
      garbageValue = "-19775"
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
      this.hash += (long)this.field2818;
      this.equipment[5] = var3;
      this.equipment[9] = var4;
      if (var1 != 0L && var1 != this.hash || this.isFemale) {
         PlayerAppearance_cachedModels.remove(var1);
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      descriptor = "(Lga;ILga;II)Lhh;",
      garbageValue = "1815127134"
   )
   public Model getModel(SequenceDefinition var1, int var2, SequenceDefinition var3, int var4) {
      if (this.npcTransformId != -1) {
         return class129.getNpcDefinition(this.npcTransformId).method966(var1, var2, var3, var4, (NewShit)null);
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
               if (var11 >= 256 && var11 < 512 && !AbstractSocket.KitDefinition_get(var11 - 256).ready()) {
                  var9 = true;
               }

               if (var11 >= 512 && !NPCComposition.ItemDefinition_get(var11 - 512).method1032(this.field2818)) {
                  var9 = true;
               }
            }

            if (var9) {
               if (-1L != this.field2821) {
                  var18 = (Model)PlayerAppearance_cachedModels.get(this.field2821);
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
                     ModelData var14 = AbstractSocket.KitDefinition_get(var13 - 256).getModelData();
                     if (var14 != null) {
                        var19[var11++] = var14;
                     }
                  }

                  if (var13 >= 512) {
                     ItemComposition var22 = NPCComposition.ItemDefinition_get(var13 - 512);
                     ModelData var15 = var22.method1033(this.field2818);
                     if (var15 != null) {
                        if (this.customisations != null) {
                           ObjTypeCustomisation var16 = this.customisations[var12];
                           if (var16 != null) {
                              int var17;
                              if (var16.recol != null && var22.recolorFrom != null && var16.recol.length == var22.recolorTo.length) {
                                 for(var17 = 0; var17 < var22.recolorFrom.length; ++var17) {
                                    var15.recolor(var22.recolorTo[var17], var16.recol[var17]);
                                 }
                              }

                              if (var16.retex != null && var22.retextureFrom != null && var22.retextureTo.length == var16.retex.length) {
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
                  if (this.bodyColors[var13] < TriBool.field3706[var13].length) {
                     var20.recolor(class86.field869[var13], TriBool.field3706[var13][this.bodyColors[var13]]);
                  }

                  if (this.bodyColors[var13] < Varps.field2794[var13].length) {
                     var20.recolor(NewShit.field1545[var13], Varps.field2794[var13][this.bodyColors[var13]]);
                  }
               }

               var18 = var20.toModel(64, 850, -30, -50, -30);
               PlayerAppearance_cachedModels.put(var18, var5);
               this.field2821 = var5;
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

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      descriptor = "(B)Lgi;",
      garbageValue = "83"
   )
   ModelData getModelData() {
      if (this.npcTransformId != -1) {
         return class129.getNpcDefinition(this.npcTransformId).method953((NewShit)null);
      } else {
         boolean var1 = false;

         int var3;
         for(int var2 = 0; var2 < 12; ++var2) {
            var3 = this.equipment[var2];
            if (var3 >= 256 && var3 < 512 && !AbstractSocket.KitDefinition_get(var3 - 256).method926()) {
               var1 = true;
            }

            if (var3 >= 512 && !NPCComposition.ItemDefinition_get(var3 - 512).method1034(this.field2818)) {
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
                  var6 = AbstractSocket.KitDefinition_get(var5 - 256).getKitDefinitionModels();
                  if (var6 != null) {
                     var7[var3++] = var6;
                  }
               }

               if (var5 >= 512) {
                  var6 = NPCComposition.ItemDefinition_get(var5 - 512).method1035(this.field2818);
                  if (var6 != null) {
                     var7[var3++] = var6;
                  }
               }
            }

            ModelData var8 = new ModelData(var7, var3);

            for(var5 = 0; var5 < 5; ++var5) {
               if (this.bodyColors[var5] < TriBool.field3706[var5].length) {
                  var8.recolor(class86.field869[var5], TriBool.field3706[var5][this.bodyColors[var5]]);
               }

               if (this.bodyColors[var5] < Varps.field2794[var5].length) {
                  var8.recolor(NewShit.field1545[var5], Varps.field2794[var5][this.bodyColors[var5]]);
               }
            }

            return var8;
         }
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "1407340254"
   )
   public int getChatHeadId() {
      return this.npcTransformId == -1 ? (this.equipment[0] << 15) + this.equipment[1] + (this.equipment[11] << 5) + (this.equipment[8] << 10) + (this.bodyColors[0] << 25) + (this.bodyColors[4] << 20) : 305419896 + class129.getNpcDefinition(this.npcTransformId).id;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      descriptor = "(I)Lbz;",
      garbageValue = "-397803252"
   )
   static World worldListStart() {
      World.World_listCount = 0;
      return UserComparator9.getNextWorldListWorld();
   }

   @ObfuscatedName("ga")
   @ObfuscatedSignature(
      descriptor = "(II)V",
      garbageValue = "1666244801"
   )
   static final void forceDisconnect(int var0) {
      Player.logOut();
      switch(var0) {
      case 1:
         class376.method1998();
         break;
      case 2:
         class12.setLoginIndex(24);
         TaskHandler.setLoginResponseString("The game servers are currently being updated.", "Please wait a few minutes and try again.", "");
      }

   }
}
