import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hq")
@Implements("ObjectComposition")
public class ObjectComposition extends DualNode {
    @ObfuscatedName("af")
    static boolean ObjectDefinition_isLowDetail = false;
    @ObfuscatedName("an")
    @ObfuscatedSignature(
            descriptor = "Lnm;"
    )
    static AbstractArchive ObjectDefinition_archive;
    @ObfuscatedName("ac")
    @ObfuscatedSignature(
            descriptor = "Lkh;"
    )
    static EvictingDualNodeHashTable ObjectDefinition_cached = new EvictingDualNodeHashTable(4096);
    @ObfuscatedName("au")
    @ObfuscatedSignature(
            descriptor = "Lkh;"
    )
    public static EvictingDualNodeHashTable ObjectDefinition_cachedModelData = new EvictingDualNodeHashTable(500);
    @ObfuscatedName("ab")
    @ObfuscatedSignature(
            descriptor = "Lkh;"
    )
    static EvictingDualNodeHashTable ObjectDefinition_cachedEntities = new EvictingDualNodeHashTable(30);
    @ObfuscatedName("aq")
    @ObfuscatedSignature(
            descriptor = "Lkh;"
    )
    static EvictingDualNodeHashTable ObjectDefinition_cachedModels = new EvictingDualNodeHashTable(30);
   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "[Liz;"
   )
   static ModelData[] field1691 = new ModelData[4];
    @ObfuscatedName("at")
    public int id;
    @ObfuscatedName("aa")
    int[] modelIds;
    @ObfuscatedName("ay")
    int[] models;
    @ObfuscatedName("ao")
    public String name = "null";
    @ObfuscatedName("ax")
    short[] recolorFrom;
    @ObfuscatedName("ai")
    short[] recolorTo;
    @ObfuscatedName("ag")
    short[] retextureFrom;
    @ObfuscatedName("ah")
    short[] retextureTo;
    @ObfuscatedName("av")
    public int sizeX = 1;
    @ObfuscatedName("ar")
    public int sizeY = 1;
    @ObfuscatedName("am")
    public int interactType = 2;
    @ObfuscatedName("as")
    public boolean boolean1 = true;
    @ObfuscatedName("aj")
    public int int1 = -1;
    @ObfuscatedName("ak")
    int clipType = -1;
    @ObfuscatedName("az")
    boolean nonFlatShading = false;
    @ObfuscatedName("ad")
    public boolean modelClipped = false;
    @ObfuscatedName("ae")
    public int animationId = -1;
    @ObfuscatedName("ap")
    public int int2 = 16;
    @ObfuscatedName("by")
    int ambient = 0;
    @ObfuscatedName("bb")
    int contrast = 0;
    @ObfuscatedName("bi")
    public String[] actions = new String[5];
    @ObfuscatedName("be")
    public int mapIconId = -1;
    @ObfuscatedName("bk")
    public int mapSceneId = -1;
    @ObfuscatedName("bx")
    boolean isRotated = false;
    @ObfuscatedName("bo")
    public boolean clipped = true;
    @ObfuscatedName("bz")
    int modelSizeX = 128;
    @ObfuscatedName("bm")
    int modelHeight = 128;
    @ObfuscatedName("bd")
    int modelSizeY = 128;
    @ObfuscatedName("bt")
    int offsetX = 0;
    @ObfuscatedName("bj")
    int offsetHeight = 0;
    @ObfuscatedName("bn")
    int offsetY = 0;
    @ObfuscatedName("bs")
    public boolean boolean2 = false;
    @ObfuscatedName("br")
    boolean isSolid = false;
    @ObfuscatedName("bg")
    public int int3 = -1;
    @ObfuscatedName("bu")
    public int[] transforms;
    @ObfuscatedName("bf")
    int transformVarbit = -1;
    @ObfuscatedName("bq")
    int transformVarp = -1;
    @ObfuscatedName("ba")
    public int ambientSoundId = -1;
    @ObfuscatedName("bv")
    public int int7 = 0;
    @ObfuscatedName("bl")
    public int int5 = 0;
    @ObfuscatedName("bp")
    public int int6 = 0;
    @ObfuscatedName("bc")
    public int[] soundEffectIds;
    @ObfuscatedName("bh")
    public boolean boolean3 = true;
    @ObfuscatedName("bw")
    @ObfuscatedSignature(
            descriptor = "Lro;"
    )
    IterableNodeHashTable params;

    @ObfuscatedName("aw")
    @ObfuscatedSignature(
            descriptor = "(B)V",
            garbageValue = "97"
    )
    void postDecode() {
      if (this.int1 == -1) {
         this.int1 = 0;
         if (this.modelIds != null && (this.models == null || this.models[0] == 10)) {
            this.int1 = 1;
         }

         for(int var1 = 0; var1 < 5; ++var1) {
            if (this.actions[var1] != null) {
               this.int1 = 1;
            }
         }
      }

      if (this.int3 == -1) {
         this.int3 = this.interactType != 0 ? 1 : 0;
      }

   }

    @ObfuscatedName("ac")
    @ObfuscatedSignature(
            descriptor = "(Lsg;I)V",
            garbageValue = "1333765973"
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
            descriptor = "(Lsg;IB)V",
            garbageValue = "16"
    )
    void decodeNext(Buffer var1, int var2) {
      int var3;
      int var4;
      if (var2 == 1) {
         var3 = var1.readUnsignedByte();
         if (var3 > 0) {
            if (this.modelIds != null && !ObjectDefinition_isLowDetail) {
               var1.offset += var3 * 3;
            } else {
               this.models = new int[var3];
               this.modelIds = new int[var3];

               for(var4 = 0; var4 < var3; ++var4) {
                  this.modelIds[var4] = var1.readUnsignedShort();
                  this.models[var4] = var1.readUnsignedByte();
               }
            }
         }
      } else if (var2 == 2) {
         this.name = var1.readStringCp1252NullTerminated();
      } else if (var2 == 5) {
         var3 = var1.readUnsignedByte();
         if (var3 > 0) {
            if (this.modelIds != null && !ObjectDefinition_isLowDetail) {
               var1.offset += var3 * 2;
            } else {
               this.models = null;
               this.modelIds = new int[var3];

               for(var4 = 0; var4 < var3; ++var4) {
                  this.modelIds[var4] = var1.readUnsignedShort();
               }
            }
         }
      } else if (var2 == 14) {
         this.sizeX = var1.readUnsignedByte();
      } else if (var2 == 15) {
         this.sizeY = var1.readUnsignedByte();
      } else if (var2 == 17) {
         this.interactType = 0;
         this.boolean1 = false;
      } else if (var2 == 18) {
         this.boolean1 = false;
      } else if (var2 == 19) {
         this.int1 = var1.readUnsignedByte();
      } else if (var2 == 21) {
         this.clipType = 0;
      } else if (var2 == 22) {
         this.nonFlatShading = true;
      } else if (var2 == 23) {
         this.modelClipped = true;
      } else if (var2 == 24) {
         this.animationId = var1.readUnsignedShort();
         if (this.animationId == 65535) {
            this.animationId = -1;
         }
      } else if (var2 == 27) {
         this.interactType = 1;
      } else if (var2 == 28) {
         this.int2 = var1.readUnsignedByte();
      } else if (var2 == 29) {
         this.ambient = var1.readByte();
      } else if (var2 == 39) {
         this.contrast = var1.readByte() * 25;
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
      } else if (var2 == 61) {
         var1.readUnsignedShort();
      } else if (var2 == 62) {
         this.isRotated = true;
      } else if (var2 == 64) {
         this.clipped = false;
      } else if (var2 == 65) {
         this.modelSizeX = var1.readUnsignedShort();
      } else if (var2 == 66) {
         this.modelHeight = var1.readUnsignedShort();
      } else if (var2 == 67) {
         this.modelSizeY = var1.readUnsignedShort();
      } else if (var2 == 68) {
         this.mapSceneId = var1.readUnsignedShort();
      } else if (var2 == 69) {
         var1.readUnsignedByte();
      } else if (var2 == 70) {
         this.offsetX = var1.readShort();
      } else if (var2 == 71) {
         this.offsetHeight = var1.readShort();
      } else if (var2 == 72) {
         this.offsetY = var1.readShort();
      } else if (var2 == 73) {
         this.boolean2 = true;
      } else if (var2 == 74) {
         this.isSolid = true;
      } else if (var2 == 75) {
         this.int3 = var1.readUnsignedByte();
      } else if (var2 != 77 && var2 != 92) {
         if (var2 == 78) {
            this.ambientSoundId = var1.readUnsignedShort();
            this.int7 = var1.readUnsignedByte();
         } else if (var2 == 79) {
            this.int5 = var1.readUnsignedShort();
            this.int6 = var1.readUnsignedShort();
            this.int7 = var1.readUnsignedByte();
            var3 = var1.readUnsignedByte();
            this.soundEffectIds = new int[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.soundEffectIds[var4] = var1.readUnsignedShort();
            }
         } else if (var2 == 81) {
            this.clipType = var1.readUnsignedByte() * 256;
         } else if (var2 == 82) {
            this.mapIconId = var1.readUnsignedShort();
         } else if (var2 == 89) {
            this.boolean3 = false;
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
         if (var2 == 92) {
            var3 = var1.readUnsignedShort();
            if (var3 == 65535) {
               var3 = -1;
            }
         }

         var4 = var1.readUnsignedByte();
         this.transforms = new int[var4 + 2];

         for(int var5 = 0; var5 <= var4; ++var5) {
            this.transforms[var5] = var1.readUnsignedShort();
            if (this.transforms[var5] == 65535) {
               this.transforms[var5] = -1;
            }
         }

         this.transforms[var4 + 1] = var3;
      }

   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "(II)Z",
      garbageValue = "-1491101758"
   )
   public final boolean method1085(int var1) {
      if (this.models != null) {
         for(int var4 = 0; var4 < this.models.length; ++var4) {
            if (this.models[var4] == var1) {
               return class157.ObjectDefinition_modelsArchive.tryLoadFile(this.modelIds[var4] & '\uffff', 0);
            }
         }

         return true;
      } else if (this.modelIds == null) {
         return true;
      } else if (var1 != 10) {
         return true;
      } else {
         boolean var2 = true;

         for(int var3 = 0; var3 < this.modelIds.length; ++var3) {
            var2 &= class157.ObjectDefinition_modelsArchive.tryLoadFile(this.modelIds[var3] & '\uffff', 0);
         }

         return var2;
      }
   }

    @ObfuscatedName("aq")
    @ObfuscatedSignature(
            descriptor = "(I)Z",
            garbageValue = "-681431683"
    )
    public final boolean needsModelFiles() {
      if (this.modelIds == null) {
         return true;
      } else {
         boolean var1 = true;

         for(int var2 = 0; var2 < this.modelIds.length; ++var2) {
            var1 &= class157.ObjectDefinition_modelsArchive.tryLoadFile(this.modelIds[var2] & '\uffff', 0);
         }

         return var1;
      }
   }

    @ObfuscatedName("al")
    @ObfuscatedSignature(
            descriptor = "(II[[IIIIB)Liv;",
            garbageValue = "-73"
    )
    public final Renderable getEntity(int var1, int var2, int[][] var3, int var4, int var5, int var6) {
      long var7;
      if (this.models == null) {
         var7 = (long)(var2 + (this.id << 10));
      } else {
         var7 = (long)(var2 + (var1 << 3) + (this.id << 10));
      }

      Object var9 = (Renderable)ObjectDefinition_cachedEntities.get(var7);
      if (var9 == null) {
         ModelData var10 = this.getModelData(var1, var2);
         if (var10 == null) {
            return null;
         }

         if (!this.nonFlatShading) {
            var9 = var10.toModel(this.ambient + 64, this.contrast + 768, -50, -10, -50);
         } else {
            var10.ambient = (short)(this.ambient + 64);
            var10.contrast = (short)(this.contrast + 768);
            var10.calculateVertexNormals();
            var9 = var10;
         }

         ObjectDefinition_cachedEntities.put((DualNode)var9, var7);
      }

      if (this.nonFlatShading) {
         var9 = ((ModelData)var9).copyModelData();
      }

      if (this.clipType >= 0) {
         if (var9 instanceof Model) {
            var9 = ((Model)var9).contourGround(var3, var4, var5, var6, true, this.clipType);
         } else if (var9 instanceof ModelData) {
            var9 = ((ModelData)var9).method1187(var3, var4, var5, var6, true, this.clipType);
         }
      }

      return (Renderable)var9;
   }

    @ObfuscatedName("at")
    @ObfuscatedSignature(
            descriptor = "(II[[IIIIB)Lit;",
            garbageValue = "-58"
    )
    public final Model getModel(int var1, int var2, int[][] var3, int var4, int var5, int var6) {
      long var7;
      if (this.models == null) {
         var7 = (long)(var2 + (this.id << 10));
      } else {
         var7 = (long)(var2 + (var1 << 3) + (this.id << 10));
      }

      Model var9 = (Model)ObjectDefinition_cachedModels.get(var7);
      if (var9 == null) {
         ModelData var10 = this.getModelData(var1, var2);
         if (var10 == null) {
            return null;
         }

         var9 = var10.toModel(this.ambient + 64, this.contrast + 768, -50, -10, -50);
         ObjectDefinition_cachedModels.put(var9, var7);
      }

      if (this.clipType >= 0) {
         var9 = var9.contourGround(var3, var4, var5, var6, true, this.clipType);
      }

      return var9;
   }

    @ObfuscatedName("aa")
    @ObfuscatedSignature(
            descriptor = "(II[[IIIILha;II)Lit;",
            garbageValue = "-1613097024"
    )
    public final Model getModelDynamic(int var1, int var2, int[][] var3, int var4, int var5, int var6, SequenceDefinition var7, int var8) {
      long var9;
      if (this.models == null) {
         var9 = (long)(var2 + (this.id << 10));
      } else {
         var9 = (long)(var2 + (var1 << 3) + (this.id << 10));
      }

      Model var11 = (Model)ObjectDefinition_cachedModels.get(var9);
      if (var11 == null) {
         ModelData var12 = this.getModelData(var1, var2);
         if (var12 == null) {
            return null;
         }

         var11 = var12.toModel(this.ambient + 64, this.contrast + 768, -50, -10, -50);
         ObjectDefinition_cachedModels.put(var11, var9);
      }

      if (var7 == null && this.clipType == -1) {
         return var11;
      } else {
         if (var7 != null) {
            var11 = var7.transformObjectModel(var11, var8, var2);
         } else {
            var11 = var11.toSharedSequenceModel(true);
         }

         if (this.clipType >= 0) {
            var11 = var11.contourGround(var3, var4, var5, var6, false, this.clipType);
         }

         return var11;
      }
   }

    @ObfuscatedName("ay")
    @ObfuscatedSignature(
            descriptor = "(III)Liz;",
            garbageValue = "-512287449"
    )
    final ModelData getModelData(int var1, int var2) {
      ModelData var3 = null;
      boolean var4;
      int var5;
      int var7;
      if (this.models == null) {
         if (var1 != 10) {
            return null;
         }

         if (this.modelIds == null) {
            return null;
         }

         var4 = this.isRotated;
         if (var1 == 2 && var2 > 3) {
            var4 = !var4;
         }

         var5 = this.modelIds.length;

         for(int var6 = 0; var6 < var5; ++var6) {
            var7 = this.modelIds[var6];
            if (var4) {
               var7 += 65536;
            }

            var3 = (ModelData)ObjectDefinition_cachedModelData.get((long)var7);
            if (var3 == null) {
               var3 = ModelData.ModelData_get(class157.ObjectDefinition_modelsArchive, var7 & '\uffff', 0);
               if (var3 == null) {
                  return null;
               }

               if (var4) {
                  var3.method1194();
               }

               ObjectDefinition_cachedModelData.put(var3, (long)var7);
            }

            if (var5 > 1) {
               field1691[var6] = var3;
            }
         }

         if (var5 > 1) {
            var3 = new ModelData(field1691, var5);
         }
      } else {
         int var9 = -1;

         for(var5 = 0; var5 < this.models.length; ++var5) {
            if (this.models[var5] == var1) {
               var9 = var5;
               break;
            }
         }

         if (var9 == -1) {
            return null;
         }

         var5 = this.modelIds[var9];
         boolean var10 = this.isRotated ^ var2 > 3;
         if (var10) {
            var5 += 65536;
         }

         var3 = (ModelData)ObjectDefinition_cachedModelData.get((long)var5);
         if (var3 == null) {
            var3 = ModelData.ModelData_get(class157.ObjectDefinition_modelsArchive, var5 & '\uffff', 0);
            if (var3 == null) {
               return null;
            }

            if (var10) {
               var3.method1194();
            }

            ObjectDefinition_cachedModelData.put(var3, (long)var5);
         }
      }

      if (this.modelSizeX == 128 && this.modelHeight == 128 && this.modelSizeY == 128) {
         var4 = false;
      } else {
         var4 = true;
      }

      boolean var11;
      if (this.offsetX == 0 && this.offsetHeight == 0 && this.offsetY == 0) {
         var11 = false;
      } else {
         var11 = true;
      }

      ModelData var8 = new ModelData(var3, var2 == 0 && !var4 && !var11, this.recolorFrom == null, this.retextureFrom == null, true);
      if (var1 == 4 && var2 > 3) {
         var8.method1206(256);
         var8.changeOffset(45, 0, -45);
      }

      var2 &= 3;
      if (var2 == 1) {
         var8.method1188();
      } else if (var2 == 2) {
         var8.method1190();
      } else if (var2 == 3) {
         var8.method1189();
      }

      if (this.recolorFrom != null) {
         for(var7 = 0; var7 < this.recolorFrom.length; ++var7) {
            var8.recolor(this.recolorFrom[var7], this.recolorTo[var7]);
         }
      }

      if (this.retextureFrom != null) {
         for(var7 = 0; var7 < this.retextureFrom.length; ++var7) {
            var8.retexture(this.retextureFrom[var7], this.retextureTo[var7]);
         }
      }

      if (var4) {
         var8.resize(this.modelSizeX, this.modelHeight, this.modelSizeY);
      }

      if (var11) {
         var8.changeOffset(this.offsetX, this.offsetHeight, this.offsetY);
      }

      return var8;
   }

    @ObfuscatedName("ao")
    @ObfuscatedSignature(
            descriptor = "(B)Lhq;",
            garbageValue = "45"
    )
    public final ObjectComposition transform() {
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

      return var2 != -1 ? class144.getObjectDefinition(var2) : null;
   }

    @ObfuscatedName("ax")
    @ObfuscatedSignature(
            descriptor = "(III)I",
            garbageValue = "-1848862363"
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

    @ObfuscatedName("ai")
    @ObfuscatedSignature(
            descriptor = "(ILjava/lang/String;I)Ljava/lang/String;",
            garbageValue = "1804170179"
    )
    public String getStringParam(int var1, String var2) {
      return EnumComposition.method1014(this.params, var1, var2);
   }

    @ObfuscatedName("ah")
    @ObfuscatedSignature(
            descriptor = "(I)Z",
            garbageValue = "-1940318911"
    )
    public boolean hasSound() {
      if (this.transforms == null) {
         return this.ambientSoundId != -1 || this.soundEffectIds != null;
      } else {
         for(int var1 = 0; var1 < this.transforms.length; ++var1) {
            if (this.transforms[var1] != -1) {
               ObjectComposition var2 = class144.getObjectDefinition(this.transforms[var1]);
               if (var2.ambientSoundId != -1 || var2.soundEffectIds != null) {
                  return true;
               }
            }
         }

         return false;
      }
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      descriptor = "(IIB)Lch;",
      garbageValue = "-114"
   )
   static Script method1096(int var0, int var1) {
      Script var2 = (Script)Script.Script_cached.get((long)(var0 << 16));
      if (var2 != null) {
         return var2;
      } else {
         String var3 = String.valueOf(var0);
         int var4 = class126.archive12.getGroupId(var3);
         if (var4 == -1) {
            return null;
         } else {
            byte[] var5 = class126.archive12.takeFileFlat(var4);
            if (var5 != null) {
               if (var5.length <= 1) {
                  return null;
               }

               var2 = class33.newScript(var5);
               if (var2 != null) {
                  Script.Script_cached.put(var2, (long)(var0 << 16));
                  return var2;
               }
            }

            return null;
         }
      }
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      descriptor = "(II)Z",
      garbageValue = "1105978425"
   )
   public static boolean method1097(int var0) {
      return (var0 >> 22 & 1) != 0;
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      descriptor = "(ILch;ZB)I",
      garbageValue = "6"
   )
   static int method1094(int var0, Script var1, boolean var2) {
      if (var0 == 3200) {
         Interpreter.Interpreter_intStackSize -= 3;
         class133.queueSoundEffect(Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize], Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1], Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 2]);
         return 1;
      } else if (var0 == 3201) {
         class1.playSong(Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
         return 1;
      } else if (var0 == 3202) {
         Interpreter.Interpreter_intStackSize -= 2;
         CollisionMap.playJingle(Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize], Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1]);
         return 1;
      } else {
         int var6;
         class86 var8;
         class85 var9;
         int var10;
         String var12;
         if (var0 != 3212 && var0 != 3213 && var0 != 3209 && var0 != 3181 && var0 != 3203 && var0 != 3205 && var0 != 3207) {
            boolean var15;
            if (var0 != 3214 && var0 != 3215 && var0 != 3210 && var0 != 3182 && var0 != 3204 && var0 != 3206 && var0 != 3208) {
               if (var0 == 3211) {
                  return 1;
               } else {
                  int var3;
                  int var4;
                  if (var0 == 3216) {
                     var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                     var4 = 0;
                     class86 var13 = (class86)StructComposition.findEnumerated(ArchiveDiskAction.method1858(), var3);
                     if (var13 != null) {
                        var4 = var13 != class86.field886 ? 1 : 0;
                     }

                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var4;
                     return 1;
                  } else if (var0 == 3218) {
                     var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                     var4 = 0;
                     class85 var5 = (class85)StructComposition.findEnumerated(class121.method723(), var3);
                     if (var5 != null) {
                        var4 = var5 != class85.field872 ? 1 : 0;
                     }

                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var4;
                     return 1;
                  } else if (var0 != 3217 && var0 != 3219) {
                     return 2;
                  } else {
                     var8 = class86.field886;
                     var9 = class85.field872;
                     var15 = true;
                     boolean var14 = true;
                     int var7;
                     if (var0 == 3217) {
                        var7 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                        var8 = (class86)StructComposition.findEnumerated(ArchiveDiskAction.method1858(), var7);
                        if (var8 == null) {
                           throw new RuntimeException(String.format("Unrecognized device option %d", var7));
                        }
                     }

                     if (var0 == 3219) {
                        var7 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                        var9 = (class85)StructComposition.findEnumerated(class121.method723(), var7);
                        if (var9 == null) {
                           throw new RuntimeException(String.format("Unrecognized game option %d", var7));
                        }
                     }

                     String var11;
                     byte var16;
                     if (var9 == class85.field872) {
                        switch(var8.field887) {
                        case 1:
                        case 2:
                        case 3:
                           var16 = 0;
                           var6 = 1;
                           break;
                        case 4:
                           var16 = 0;
                           var6 = Integer.MAX_VALUE;
                           break;
                        case 5:
                           var16 = 0;
                           var6 = 100;
                           break;
                        default:
                           var11 = String.format("Unkown device option: %s.", var8.toString());
                           throw new RuntimeException(var11);
                        }
                     } else {
                        switch(var9.field873) {
                        case 1:
                           var16 = 0;
                           var6 = 1;
                           break;
                        case 2:
                        case 3:
                        case 4:
                           var16 = 0;
                           var6 = 100;
                           break;
                        default:
                           var11 = String.format("Unkown game option: %s.", var9.toString());
                           throw new RuntimeException(var11);
                        }
                     }

                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var16;
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var6;
                     return 1;
                  }
               }
            } else {
               var8 = class86.field886;
               var9 = class85.field872;
               var15 = false;
               if (var0 == 3214) {
                  var6 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                  var8 = (class86)StructComposition.findEnumerated(ArchiveDiskAction.method1858(), var6);
                  if (var8 == null) {
                     throw new RuntimeException(String.format("Unrecognized device option %d", var6));
                  }
               }

               if (var0 == 3215) {
                  var6 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                  var9 = (class85)StructComposition.findEnumerated(class121.method723(), var6);
                  if (var9 == null) {
                     throw new RuntimeException(String.format("Unrecognized game option %d", var6));
                  }
               }

               if (var0 == 3210) {
                  var6 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                  var8 = (class86)StructComposition.findEnumerated(ArchiveDiskAction.method1858(), var6);
                  if (var8 == null) {
                     var9 = (class85)StructComposition.findEnumerated(class121.method723(), var6);
                     if (var9 == null) {
                        throw new RuntimeException(String.format("Unrecognized client option %d", var6));
                     }
                  }
               } else if (var0 == 3182) {
                  var8 = class86.field884;
               } else if (var0 == 3204) {
                  var9 = class85.field877;
               } else if (var0 == 3206) {
                  var9 = class85.field871;
               } else if (var0 == 3208) {
                  var9 = class85.field874;
               }

               if (var9 == class85.field872) {
                  switch(var8.field887) {
                  case 1:
                     var10 = class20.clientPreferences.getIsUsernameHidden() ? 1 : 0;
                     break;
                  case 2:
                     var10 = class20.clientPreferences.getTitleMusicDisabled() ? 1 : 0;
                     break;
                  case 3:
                     var10 = class20.clientPreferences.method562() ? 1 : 0;
                     break;
                  case 4:
                     var10 = class20.clientPreferences.method573();
                     break;
                  case 5:
                     var10 = class103.method636();
                     break;
                  default:
                     var12 = String.format("Unkown device option: %s.", var8.toString());
                     throw new RuntimeException(var12);
                  }
               } else {
                  switch(var9.field873) {
                  case 1:
                     var10 = class20.clientPreferences.getRoofsHidden() ? 1 : 0;
                     break;
                  case 2:
                     var6 = class20.clientPreferences.getCurrentMusicVolume();
                     var10 = Math.round((float)(var6 * 100) / 255.0F);
                     break;
                  case 3:
                     var6 = class20.clientPreferences.getCurrentSoundEffectsVolume();
                     var10 = Math.round((float)(var6 * 100) / 127.0F);
                     break;
                  case 4:
                     var6 = class20.clientPreferences.getAreaSoundEffectsVolume();
                     var10 = Math.round((float)(var6 * 100) / 127.0F);
                     break;
                  default:
                     var12 = String.format("Unkown game option: %s.", var9.toString());
                     throw new RuntimeException(var12);
                  }
               }

               Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var10;
               return 1;
            }
         } else {
            var8 = class86.field886;
            var9 = class85.field872;
            var10 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
            if (var0 == 3212) {
               var6 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
               var8 = (class86)StructComposition.findEnumerated(ArchiveDiskAction.method1858(), var6);
               if (var8 == null) {
                  throw new RuntimeException(String.format("Unrecognized device option %d", var6));
               }
            }

            if (var0 == 3213) {
               var6 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
               var9 = (class85)StructComposition.findEnumerated(class121.method723(), var6);
               if (var9 == null) {
                  throw new RuntimeException(String.format("Unrecognized game option %d", var6));
               }
            }

            if (var0 == 3209) {
               var6 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
               var8 = (class86)StructComposition.findEnumerated(ArchiveDiskAction.method1858(), var6);
               if (var8 == null) {
                  var9 = (class85)StructComposition.findEnumerated(class121.method723(), var6);
                  if (var9 == null) {
                     throw new RuntimeException(String.format("Unrecognized client option %d", var6));
                  }
               }
            } else if (var0 == 3181) {
               var8 = class86.field884;
            } else if (var0 == 3203) {
               var9 = class85.field877;
            } else if (var0 == 3205) {
               var9 = class85.field871;
            } else if (var0 == 3207) {
               var9 = class85.field874;
            }

            if (var9 == class85.field872) {
               switch(var8.field887) {
               case 1:
                  class20.clientPreferences.setIsUsernameHidden(var10 == 1);
                  break;
               case 2:
                  class20.clientPreferences.getTitleMusicDisabled(var10 == 1);
                  break;
               case 3:
                  class20.clientPreferences.method580(var10 == 1);
                  break;
               case 4:
                  if (var10 < 0) {
                     var10 = 0;
                  }

                  class20.clientPreferences.method587(var10);
                  break;
               case 5:
                  ApproximateRouteStrategy.method359(var10);
                  break;
               default:
                  var12 = String.format("Unkown device option: %s.", var8.toString());
                  throw new RuntimeException(var12);
               }
            } else {
               switch(var9.field873) {
               case 1:
                  class20.clientPreferences.setRoofsHidden(var10 == 1);
                  break;
               case 2:
                  var10 = Math.min(Math.max(var10, 0), 100);
                  var6 = Math.round((float)(var10 * 255) / 100.0F);
                  class86.method502(var6);
                  break;
               case 3:
                  var10 = Math.min(Math.max(var10, 0), 100);
                  var6 = Math.round((float)(var10 * 127) / 100.0F);
                  class130.method764(var6);
                  break;
               case 4:
                  var10 = Math.min(Math.max(var10, 0), 100);
                  var6 = Math.round((float)(var10 * 127) / 100.0F);
                  class135.method783(var6);
                  break;
               default:
                  var12 = String.format("Unkown game option: %s.", var9.toString());
                  throw new RuntimeException(var12);
               }
            }

            return 1;
         }
      }
   }
}
