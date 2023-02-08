import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("go")
@Implements("NPCComposition")
public class NPCComposition extends DualNode {
    @ObfuscatedName("w")
    @ObfuscatedSignature(
            descriptor = "Lln;"
    )
    static AbstractArchive NpcDefinition_archive;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "Lln;"
   )
   static AbstractArchive field1550;
    @ObfuscatedName("s")
    @ObfuscatedSignature(
            descriptor = "Lja;"
    )
    static EvictingDualNodeHashTable NpcDefinition_cached = new EvictingDualNodeHashTable(64);
    @ObfuscatedName("z")
    @ObfuscatedSignature(
            descriptor = "Lja;"
    )
    static EvictingDualNodeHashTable NpcDefinition_cachedModels = new EvictingDualNodeHashTable(50);
    @ObfuscatedName("j")
    public int id;
    @ObfuscatedName("i")
    public String name = "null";
    @ObfuscatedName("n")
    public int size = 1;
    @ObfuscatedName("l")
    int[] models;
   @ObfuscatedName("k")
   int[] field1557;
    @ObfuscatedName("c")
    public int idleSequence = -1;
    @ObfuscatedName("r")
    public int turnLeftSequence = -1;
    @ObfuscatedName("b")
    public int turnRightSequence = -1;
    @ObfuscatedName("m")
    public int walkSequence = -1;
    @ObfuscatedName("t")
    public int walkBackSequence = -1;
    @ObfuscatedName("h")
    public int walkLeftSequence = -1;
    @ObfuscatedName("p")
    public int walkRightSequence = -1;
    @ObfuscatedName("o")
    public int runSequence = -1;
    @ObfuscatedName("u")
    public int runBackSequence = -1;
    @ObfuscatedName("x")
    public int runLeftSequence = -1;
    @ObfuscatedName("a")
    public int runRightSequence = -1;
    @ObfuscatedName("q")
    public int crawlSequence = -1;
    @ObfuscatedName("d")
    public int crawlBackSequence = -1;
    @ObfuscatedName("e")
    public int crawlLeftSequence = -1;
    @ObfuscatedName("g")
    public int crawlRightSequence = -1;
    @ObfuscatedName("y")
    short[] recolorFrom;
    @ObfuscatedName("af")
    public short[] recolorTo;
    @ObfuscatedName("aa")
    short[] retextureFrom;
    @ObfuscatedName("ai")
    public short[] retextureTo;
    @ObfuscatedName("ag")
    public String[] actions = new String[5];
    @ObfuscatedName("aw")
    public boolean drawMapDot = true;
    @ObfuscatedName("ar")
    public int combatLevel = -1;
    @ObfuscatedName("al")
    int widthScale = 128;
    @ObfuscatedName("at")
    int heightScale = 128;
    @ObfuscatedName("aj")
    public boolean isVisible = false;
    @ObfuscatedName("ax")
    int ambient = 0;
    @ObfuscatedName("az")
    int contrast = 0;
    @ObfuscatedName("ap")
    public int rotation = 32;
    @ObfuscatedName("ay")
    public int[] transforms;
    @ObfuscatedName("ac")
    int transformVarbit = -1;
    @ObfuscatedName("av")
    int transformVarp = -1;
    @ObfuscatedName("aq")
    public boolean isInteractable = true;
    @ObfuscatedName("ak")
    public boolean isClickable = true;
    @ObfuscatedName("au")
    public boolean isFollower = false;
    @ObfuscatedName("ae")
    int[] headIconArchiveIds = null;
    @ObfuscatedName("ah")
    short[] headIconSpriteIndexes = null;
    @ObfuscatedName("ad")
    @ObfuscatedSignature(
            descriptor = "Lqu;"
    )
    IterableNodeHashTable params;

    @ObfuscatedName("v")
    @ObfuscatedSignature(
            descriptor = "(B)V",
            garbageValue = "-20"
    )
    void postDecode() {
   }

    @ObfuscatedName("s")
    @ObfuscatedSignature(
            descriptor = "(Lrd;I)V",
            garbageValue = "-992361699"
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

    @ObfuscatedName("z")
    @ObfuscatedSignature(
            descriptor = "(Lrd;IB)V",
            garbageValue = "0"
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
         this.field1557 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field1557[var4] = var1.readUnsignedShort();
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
                  this.headIconArchiveIds[var6] = var1.method2419();
                  this.headIconSpriteIndexes[var6] = (short)var1.method2389();
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
               this.params = class127.readStringIntParameters(var1, this.params);
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

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      descriptor = "(Lge;ILge;ILgj;I)Lhs;",
      garbageValue = "-699264349"
   )
   public final Model method958(SequenceDefinition var1, int var2, SequenceDefinition var3, int var4, NewShit var5) {
      if (this.transforms != null) {
         NPCComposition var6 = this.transform();
         return var6 == null ? null : var6.method958(var1, var2, var3, var4, var5);
      } else {
         long var10 = (long)this.id;
         if (var5 != null) {
            var10 |= var5.field1547 << 16;
         }

         Model var8 = (Model)NpcDefinition_cachedModels.get(var10);
         if (var8 == null) {
            ModelData var9 = this.method959(this.models, var5);
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

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      descriptor = "(Lgj;I)Lhe;",
      garbageValue = "777135590"
   )
   public final ModelData method968(NewShit var1) {
      if (this.transforms != null) {
         NPCComposition var2 = this.transform();
         return var2 == null ? null : var2.method968(var1);
      } else {
         return this.method959(this.field1557, var1);
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      descriptor = "([ILgj;I)Lhe;",
      garbageValue = "-1265657645"
   )
   ModelData method959(int[] var1, NewShit var2) {
      int[] var3 = var1;
      if (var2 != null && var2.field1544 != null) {
         var3 = var2.field1544;
      }

      if (var3 == null) {
         return null;
      } else {
         boolean var4 = false;

         for(int var5 = 0; var5 < var3.length; ++var5) {
            if (var3[var5] != -1 && !field1550.tryLoadFile(var3[var5], 0)) {
               var4 = true;
            }
         }

         if (var4) {
            return null;
         } else {
            ModelData[] var9 = new ModelData[var3.length];

            for(int var6 = 0; var6 < var3.length; ++var6) {
               var9[var6] = ModelData.ModelData_get(field1550, var3[var6], 0);
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
               if (var2 != null && var2.field1545 != null) {
                  var7 = var2.field1545;
               }

               for(var8 = 0; var8 < this.recolorFrom.length; ++var8) {
                  var10.recolor(this.recolorFrom[var8], var7[var8]);
               }
            }

            if (this.retextureFrom != null) {
               var7 = this.retextureTo;
               if (var2 != null && var2.field1546 != null) {
                  var7 = var2.field1546;
               }

               for(var8 = 0; var8 < this.retextureFrom.length; ++var8) {
                  var10.retexture(this.retextureFrom[var8], var7[var8]);
               }
            }

            return var10;
         }
      }
   }

    @ObfuscatedName("l")
    @ObfuscatedSignature(
            descriptor = "(I)Lgo;",
            garbageValue = "-1447312355"
    )
    public final NPCComposition transform() {
      int var1 = -1;
      if (this.transformVarbit != -1) {
         var1 = SecureRandomFuture.getVarbit(this.transformVarbit);
      } else if (this.transformVarp != -1) {
         var1 = Varps.Varps_main[this.transformVarp];
      }

      int var2;
      if (var1 >= 0 && var1 < this.transforms.length - 1) {
         var2 = this.transforms[var1];
      } else {
         var2 = this.transforms[this.transforms.length - 1];
      }

      return var2 != -1 ? class137.getNpcDefinition(var2) : null;
   }

    @ObfuscatedName("k")
    @ObfuscatedSignature(
            descriptor = "(I)Z",
            garbageValue = "1020653096"
    )
    public boolean transformIsVisible() {
      if (this.transforms == null) {
         return true;
      } else {
         int var1 = -1;
         if (this.transformVarbit != -1) {
            var1 = SecureRandomFuture.getVarbit(this.transformVarbit);
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

    @ObfuscatedName("c")
    @ObfuscatedSignature(
            descriptor = "(III)I",
            garbageValue = "1125226221"
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

    @ObfuscatedName("r")
    @ObfuscatedSignature(
            descriptor = "(ILjava/lang/String;B)Ljava/lang/String;",
            garbageValue = "-97"
    )
    public String getStringParam(int var1, String var2) {
      return class145.method771(this.params, var1, var2);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      descriptor = "(I)Z",
      garbageValue = "1185474611"
   )
   public boolean method964() {
      return this.headIconArchiveIds != null && this.headIconSpriteIndexes != null;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      descriptor = "(I)[I",
      garbageValue = "303356409"
   )
   public int[] method970() {
      return this.headIconArchiveIds;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(II)I",
      garbageValue = "1165166877"
   )
   public int method969(int var1) {
      return this.headIconArchiveIds != null && var1 < this.headIconArchiveIds.length ? this.headIconArchiveIds[var1] : -1;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      descriptor = "(B)[S",
      garbageValue = "1"
   )
   public short[] method967() {
      return this.headIconSpriteIndexes;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      descriptor = "(II)S",
      garbageValue = "-242037321"
   )
   public short method966(int var1) {
      return this.headIconSpriteIndexes != null && var1 < this.headIconSpriteIndexes.length ? this.headIconSpriteIndexes[var1] : -1;
   }
}
