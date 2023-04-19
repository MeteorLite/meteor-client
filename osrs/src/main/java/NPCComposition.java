import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hs")
@Implements("NPCComposition")
public class NPCComposition extends DualNode {
    @ObfuscatedName("an")
    @ObfuscatedSignature(
            descriptor = "Lnm;"
    )
    static AbstractArchive NpcDefinition_archive;
   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      descriptor = "Lnm;"
   )
   static AbstractArchive field1559;
    @ObfuscatedName("ac")
    @ObfuscatedSignature(
            descriptor = "Lkh;"
    )
    static EvictingDualNodeHashTable NpcDefinition_cached = new EvictingDualNodeHashTable(64);
    @ObfuscatedName("au")
    @ObfuscatedSignature(
            descriptor = "Lkh;"
    )
    static EvictingDualNodeHashTable NpcDefinition_cachedModels = new EvictingDualNodeHashTable(50);
    @ObfuscatedName("ab")
    public int id;
    @ObfuscatedName("aq")
    public String name = "null";
    @ObfuscatedName("al")
    public int size = 1;
    @ObfuscatedName("at")
    int[] models;
   @ObfuscatedName("aa")
   int[] field1604;
    @ObfuscatedName("ay")
    public int idleSequence = -1;
    @ObfuscatedName("ao")
    public int turnLeftSequence = -1;
    @ObfuscatedName("ax")
    public int turnRightSequence = -1;
    @ObfuscatedName("ai")
    public int walkSequence = -1;
    @ObfuscatedName("ag")
    public int walkBackSequence = -1;
    @ObfuscatedName("ah")
    public int walkLeftSequence = -1;
    @ObfuscatedName("av")
    public int walkRightSequence = -1;
    @ObfuscatedName("ar")
    public int runSequence = -1;
    @ObfuscatedName("am")
    public int runBackSequence = -1;
    @ObfuscatedName("as")
    public int runLeftSequence = -1;
    @ObfuscatedName("aj")
    public int runRightSequence = -1;
    @ObfuscatedName("ak")
    public int crawlSequence = -1;
    @ObfuscatedName("az")
    public int crawlBackSequence = -1;
    @ObfuscatedName("ad")
    public int crawlLeftSequence = -1;
    @ObfuscatedName("ae")
    public int crawlRightSequence = -1;
    @ObfuscatedName("ap")
    short[] recolorFrom;
    @ObfuscatedName("by")
    public short[] recolorTo;
    @ObfuscatedName("bb")
    short[] retextureFrom;
    @ObfuscatedName("bi")
    public short[] retextureTo;
    @ObfuscatedName("be")
    public String[] actions = new String[5];
    @ObfuscatedName("bk")
    public boolean drawMapDot = true;
    @ObfuscatedName("bx")
    public int combatLevel = -1;
    @ObfuscatedName("bo")
    int widthScale = 128;
    @ObfuscatedName("bz")
    int heightScale = 128;
    @ObfuscatedName("bm")
    public boolean isVisible = false;
    @ObfuscatedName("bd")
    int ambient = 0;
    @ObfuscatedName("bt")
    int contrast = 0;
    @ObfuscatedName("bj")
    public int rotation = 32;
    @ObfuscatedName("bn")
    public int[] transforms;
    @ObfuscatedName("bs")
    int transformVarbit = -1;
    @ObfuscatedName("br")
    int transformVarp = -1;
    @ObfuscatedName("bg")
    public boolean isInteractable = true;
    @ObfuscatedName("bu")
    public boolean isClickable = true;
    @ObfuscatedName("bf")
    public boolean isFollower = false;
    @ObfuscatedName("bq")
    int[] headIconArchiveIds = null;
    @ObfuscatedName("ba")
    short[] headIconSpriteIndexes = null;
    @ObfuscatedName("bv")
    @ObfuscatedSignature(
            descriptor = "Lro;"
    )
    IterableNodeHashTable params;

    @ObfuscatedName("aw")
    @ObfuscatedSignature(
            descriptor = "(I)V",
            garbageValue = "835833293"
    )
    void postDecode() {
   }

    @ObfuscatedName("ac")
    @ObfuscatedSignature(
            descriptor = "(Lsg;I)V",
            garbageValue = "-247932803"
    )
    void decode(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if (var2 == 0) {
            return;
         }

         this.decodeNext(var1, var2);
      }
   }

    @ObfuscatedName("au")
    @ObfuscatedSignature(
            descriptor = "(Lsg;II)V",
            garbageValue = "1239995114"
    )
    void decodeNext(Buffer var1, int var2) {
      int var3;
      int var4;
      if (var2 == 1) {
         var3 = var1.readUnsignedByte();
         this.models = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.models[var4] = var1.readUnsignedShort();
         }
      } else if (var2 == 2) {
         this.name = var1.readStringCp1252NullTerminated();
      } else if (var2 == 12) {
         this.size = var1.readUnsignedByte();
      } else if (var2 == 13) {
         this.idleSequence = var1.readUnsignedShort();
      } else if (var2 == 14) {
         this.walkSequence = var1.readUnsignedShort();
      } else if (var2 == 15) {
         this.turnLeftSequence = var1.readUnsignedShort();
      } else if (var2 == 16) {
         this.turnRightSequence = var1.readUnsignedShort();
      } else if (var2 == 17) {
         this.walkSequence = var1.readUnsignedShort();
         this.walkBackSequence = var1.readUnsignedShort();
         this.walkLeftSequence = var1.readUnsignedShort();
         this.walkRightSequence = var1.readUnsignedShort();
      } else if (var2 == 18) {
         var1.readUnsignedShort();
      } else if (var2 >= 30 && var2 < 35) {
         this.actions[var2 - 30] = var1.readStringCp1252NullTerminated();
         if (this.actions[var2 - 30].equalsIgnoreCase("Hidden")) {
            this.actions[var2 - 30] = null;
         }
      } else if (var2 == 40) {
         var3 = var1.readUnsignedByte();
         this.recolorFrom = new short[var3];
         this.recolorTo = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.recolorFrom[var4] = (short)var1.readUnsignedShort();
            this.recolorTo[var4] = (short)var1.readUnsignedShort();
         }
      } else if (var2 == 41) {
         var3 = var1.readUnsignedByte();
         this.retextureFrom = new short[var3];
         this.retextureTo = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.retextureFrom[var4] = (short)var1.readUnsignedShort();
            this.retextureTo[var4] = (short)var1.readUnsignedShort();
         }
      } else if (var2 == 60) {
         var3 = var1.readUnsignedByte();
         this.field1604 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field1604[var4] = var1.readUnsignedShort();
         }
      } else if (var2 == 93) {
         this.drawMapDot = false;
      } else if (var2 == 95) {
         this.combatLevel = var1.readUnsignedShort();
      } else if (var2 == 97) {
         this.widthScale = var1.readUnsignedShort();
      } else if (var2 == 98) {
         this.heightScale = var1.readUnsignedShort();
      } else if (var2 == 99) {
         this.isVisible = true;
      } else if (var2 == 100) {
         this.ambient = var1.readByte();
      } else if (var2 == 101) {
         this.contrast = var1.readByte() * 5;
      } else {
         int var5;
         if (var2 == 102) {
            var3 = var1.readUnsignedByte();
            var4 = 0;

            for(var5 = var3; var5 != 0; var5 >>= 1) {
               ++var4;
            }

            this.headIconArchiveIds = new int[var4];
            this.headIconSpriteIndexes = new short[var4];

            for(int var6 = 0; var6 < var4; ++var6) {
               if ((var3 & 1 << var6) == 0) {
                  this.headIconArchiveIds[var6] = -1;
                  this.headIconSpriteIndexes[var6] = -1;
               } else {
                  this.headIconArchiveIds[var6] = var1.method2516();
                  this.headIconSpriteIndexes[var6] = (short)var1.method2491();
               }
            }
         } else if (var2 == 103) {
            this.rotation = var1.readUnsignedShort();
         } else if (var2 != 106 && var2 != 118) {
            if (var2 == 107) {
               this.isInteractable = false;
            } else if (var2 == 109) {
               this.isClickable = false;
            } else if (var2 == 111) {
               this.isFollower = true;
            } else if (var2 == 114) {
               this.runSequence = var1.readUnsignedShort();
            } else if (var2 == 115) {
               this.runSequence = var1.readUnsignedShort();
               this.runBackSequence = var1.readUnsignedShort();
               this.runLeftSequence = var1.readUnsignedShort();
               this.runRightSequence = var1.readUnsignedShort();
            } else if (var2 == 116) {
               this.crawlSequence = var1.readUnsignedShort();
            } else if (var2 == 117) {
               this.crawlSequence = var1.readUnsignedShort();
               this.crawlBackSequence = var1.readUnsignedShort();
               this.crawlLeftSequence = var1.readUnsignedShort();
               this.crawlRightSequence = var1.readUnsignedShort();
            } else if (var2 == 249) {
               this.params = ChatChannel.readStringIntParameters(var1, this.params);
            }
         } else {
            this.transformVarbit = var1.readUnsignedShort();
            if (this.transformVarbit == 65535) {
               this.transformVarbit = -1;
            }

            this.transformVarp = var1.readUnsignedShort();
            if (this.transformVarp == 65535) {
               this.transformVarp = -1;
            }

            var3 = -1;
            if (var2 == 118) {
               var3 = var1.readUnsignedShort();
               if (var3 == 65535) {
                  var3 = -1;
               }
            }

            var4 = var1.readUnsignedByte();
            this.transforms = new int[var4 + 2];

            for(var5 = 0; var5 <= var4; ++var5) {
               this.transforms[var5] = var1.readUnsignedShort();
               if (this.transforms[var5] == 65535) {
                  this.transforms[var5] = -1;
               }
            }

            this.transforms[var4 + 1] = var3;
         }
      }

   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "(Lha;ILha;ILhv;B)Lit;",
      garbageValue = "49"
   )
   public final Model method1021(SequenceDefinition var1, int var2, SequenceDefinition var3, int var4, NewShit var5) {
      if (this.transforms != null) {
         NPCComposition var6 = this.transform();
         return var6 == null ? null : var6.method1021(var1, var2, var3, var4, var5);
      } else {
         long var10 = (long)this.id;
         if (var5 != null) {
            var10 |= var5.field1556 << 16;
         }

         Model var8 = (Model)NpcDefinition_cachedModels.get(var10);
         if (var8 == null) {
            ModelData var9 = this.method1023(this.models, var5);
            if (var9 == null) {
               return null;
            }

            var8 = var9.toModel(this.ambient + 64, this.contrast + 850, -30, -50, -30);
            NpcDefinition_cachedModels.put(var8, var10);
         }

         Model var12;
         if (var1 != null && var3 != null) {
            var12 = var1.applyTransformations(var8, var2, var3, var4);
         } else if (var1 != null) {
            var12 = var1.transformActorModel(var8, var2);
         } else if (var3 != null) {
            var12 = var3.transformActorModel(var8, var4);
         } else {
            var12 = var8.toSharedSequenceModel(true);
         }

         if (this.widthScale != 128 || this.heightScale != 128) {
            var12.scale(this.widthScale, this.heightScale, this.widthScale);
         }

         return var12;
      }
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      descriptor = "(Lhv;B)Liz;",
      garbageValue = "64"
   )
   public final ModelData method1022(NewShit var1) {
      if (this.transforms != null) {
         NPCComposition var2 = this.transform();
         return var2 == null ? null : var2.method1022(var1);
      } else {
         return this.method1023(this.field1604, var1);
      }
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "([ILhv;I)Liz;",
      garbageValue = "-417083855"
   )
   ModelData method1023(int[] var1, NewShit var2) {
      int[] var3 = var1;
      if (var2 != null && var2.field1555 != null) {
         var3 = var2.field1555;
      }

      if (var3 == null) {
         return null;
      } else {
         boolean var4 = false;

         for(int var5 = 0; var5 < var3.length; ++var5) {
            if (var3[var5] != -1 && !field1559.tryLoadFile(var3[var5], 0)) {
               var4 = true;
            }
         }

         if (var4) {
            return null;
         } else {
            ModelData[] var9 = new ModelData[var3.length];

            for(int var6 = 0; var6 < var3.length; ++var6) {
               var9[var6] = ModelData.ModelData_get(field1559, var3[var6], 0);
            }

            ModelData var10;
            if (var9.length == 1) {
               var10 = var9[0];
               if (var10 == null) {
                  var10 = new ModelData(var9, var9.length);
               }
            } else {
               var10 = new ModelData(var9, var9.length);
            }

            short[] var7;
            int var8;
            if (this.recolorFrom != null) {
               var7 = this.recolorTo;
               if (var2 != null && var2.field1554 != null) {
                  var7 = var2.field1554;
               }

               for(var8 = 0; var8 < this.recolorFrom.length; ++var8) {
                  var10.recolor(this.recolorFrom[var8], var7[var8]);
               }
            }

            if (this.retextureFrom != null) {
               var7 = this.retextureTo;
               if (var2 != null && var2.field1557 != null) {
                  var7 = var2.field1557;
               }

               for(var8 = 0; var8 < this.retextureFrom.length; ++var8) {
                  var10.retexture(this.retextureFrom[var8], var7[var8]);
               }
            }

            return var10;
         }
      }
   }

    @ObfuscatedName("at")
    @ObfuscatedSignature(
            descriptor = "(I)Lhs;",
            garbageValue = "1271441583"
    )
    public final NPCComposition transform() {
      int var1 = -1;
      if (this.transformVarbit != -1) {
         var1 = class252.getVarbit(this.transformVarbit);
      } else if (this.transformVarp != -1) {
         var1 = Varps.Varps_main[this.transformVarp];
      }

      int var2;
      if (var1 >= 0 && var1 < this.transforms.length - 1) {
         var2 = this.transforms[var1];
      } else {
         var2 = this.transforms[this.transforms.length - 1];
      }

      return var2 != -1 ? AbstractArchive.getNpcDefinition(var2) : null;
   }

    @ObfuscatedName("aa")
    @ObfuscatedSignature(
            descriptor = "(I)Z",
            garbageValue = "41635170"
    )
    public boolean transformIsVisible() {
      if (this.transforms == null) {
         return true;
      } else {
         int var1 = -1;
         if (this.transformVarbit != -1) {
            var1 = class252.getVarbit(this.transformVarbit);
         } else if (this.transformVarp != -1) {
            var1 = Varps.Varps_main[this.transformVarp];
         }

         if (var1 >= 0 && var1 < this.transforms.length) {
            return this.transforms[var1] != -1;
         } else {
            return this.transforms[this.transforms.length - 1] != -1;
         }
      }
   }

    @ObfuscatedName("ay")
    @ObfuscatedSignature(
            descriptor = "(III)I",
            garbageValue = "1858319582"
    )
    public int getIntParam(int var1, int var2) {
      IterableNodeHashTable var4 = this.params;
      int var3;
      if (var4 == null) {
         var3 = var2;
      } else {
         IntegerNode var5 = (IntegerNode)var4.get((long)var1);
         if (var5 == null) {
            var3 = var2;
         } else {
            var3 = var5.integer;
         }
      }

      return var3;
   }

    @ObfuscatedName("ao")
    @ObfuscatedSignature(
            descriptor = "(ILjava/lang/String;I)Ljava/lang/String;",
            garbageValue = "1361992151"
    )
    public String getStringParam(int var1, String var2) {
      return EnumComposition.method1014(this.params, var1, var2);
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      descriptor = "(B)Z",
      garbageValue = "29"
   )
   public boolean method1028() {
      return this.headIconArchiveIds != null && this.headIconSpriteIndexes != null;
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      descriptor = "(I)[I",
      garbageValue = "-185133589"
   )
   public int[] method1029() {
      return this.headIconArchiveIds;
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      descriptor = "(IB)I",
      garbageValue = "123"
   )
   public int method1030(int var1) {
      return this.headIconArchiveIds != null && var1 < this.headIconArchiveIds.length ? this.headIconArchiveIds[var1] : -1;
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      descriptor = "(I)[S",
      garbageValue = "800844396"
   )
   public short[] method1031() {
      return this.headIconSpriteIndexes;
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      descriptor = "(II)S",
      garbageValue = "439788995"
   )
   public short method1032(int var1) {
      return this.headIconSpriteIndexes != null && var1 < this.headIconSpriteIndexes.length ? this.headIconSpriteIndexes[var1] : -1;
   }

   @ObfuscatedName("aq")
   public static int method1035(long var0) {
      return (int)(var0 >>> 7 & 127L);
   }
}
