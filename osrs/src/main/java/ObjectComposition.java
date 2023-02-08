import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gp")
@Implements("ObjectComposition")
public class ObjectComposition extends DualNode {
    @ObfuscatedName("f")
    public static boolean ObjectDefinition_isLowDetail = false;
    @ObfuscatedName("w")
    @ObfuscatedSignature(
            descriptor = "Lln;"
    )
    public static AbstractArchive ObjectDefinition_archive;
    @ObfuscatedName("v")
    @ObfuscatedSignature(
            descriptor = "Lln;"
    )
    public static AbstractArchive ObjectDefinition_modelsArchive;
    @ObfuscatedName("s")
    @ObfuscatedSignature(
            descriptor = "Lja;"
    )
    public static EvictingDualNodeHashTable ObjectDefinition_cached = new EvictingDualNodeHashTable(4096);
    @ObfuscatedName("z")
    @ObfuscatedSignature(
            descriptor = "Lja;"
    )
    public static EvictingDualNodeHashTable ObjectDefinition_cachedModelData = new EvictingDualNodeHashTable(500);
    @ObfuscatedName("j")
    @ObfuscatedSignature(
            descriptor = "Lja;"
    )
    public static EvictingDualNodeHashTable ObjectDefinition_cachedEntities = new EvictingDualNodeHashTable(30);
    @ObfuscatedName("i")
    @ObfuscatedSignature(
            descriptor = "Lja;"
    )
    public static EvictingDualNodeHashTable ObjectDefinition_cachedModels = new EvictingDualNodeHashTable(30);
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      descriptor = "[Lhe;"
   )
   static ModelData[] field1663 = new ModelData[4];
    @ObfuscatedName("l")
    public int id;
    @ObfuscatedName("k")
    int[] modelIds;
    @ObfuscatedName("c")
    int[] models;
    @ObfuscatedName("r")
    public String name = "null";
    @ObfuscatedName("b")
    short[] recolorFrom;
    @ObfuscatedName("m")
    short[] recolorTo;
    @ObfuscatedName("t")
    short[] retextureFrom;
    @ObfuscatedName("h")
    short[] retextureTo;
    @ObfuscatedName("p")
    public int sizeX = 1;
    @ObfuscatedName("o")
    public int sizeY = 1;
    @ObfuscatedName("u")
    public int interactType = 2;
    @ObfuscatedName("x")
    public boolean boolean1 = true;
    @ObfuscatedName("a")
    public int int1 = -1;
    @ObfuscatedName("q")
    int clipType = -1;
    @ObfuscatedName("d")
    boolean nonFlatShading = false;
    @ObfuscatedName("e")
    public boolean modelClipped = false;
    @ObfuscatedName("g")
    public int animationId = -1;
    @ObfuscatedName("y")
    public int int2 = 16;
    @ObfuscatedName("af")
    int ambient = 0;
    @ObfuscatedName("aa")
    int contrast = 0;
    @ObfuscatedName("ai")
    public String[] actions = new String[5];
    @ObfuscatedName("ag")
    public int mapIconId = -1;
    @ObfuscatedName("aw")
    public int mapSceneId = -1;
    @ObfuscatedName("ar")
    boolean isRotated = false;
    @ObfuscatedName("al")
    public boolean clipped = true;
    @ObfuscatedName("at")
    int modelSizeX = 128;
    @ObfuscatedName("aj")
    int modelHeight = 128;
    @ObfuscatedName("ax")
    int modelSizeY = 128;
    @ObfuscatedName("az")
    int offsetX = 0;
    @ObfuscatedName("ap")
    int offsetHeight = 0;
    @ObfuscatedName("ay")
    int offsetY = 0;
    @ObfuscatedName("ac")
    public boolean boolean2 = false;
    @ObfuscatedName("av")
    boolean isSolid = false;
    @ObfuscatedName("aq")
    public int int3 = -1;
    @ObfuscatedName("ak")
    public int[] transforms;
    @ObfuscatedName("au")
    int transformVarbit = -1;
    @ObfuscatedName("ae")
    int transformVarp = -1;
    @ObfuscatedName("ah")
    public int ambientSoundId = -1;
    @ObfuscatedName("ad")
    public int int7 = 0;
    @ObfuscatedName("ab")
    public int int5 = 0;
    @ObfuscatedName("an")
    public int int6 = 0;
    @ObfuscatedName("am")
    public int[] soundEffectIds;
    @ObfuscatedName("as")
    public boolean boolean3 = true;
    @ObfuscatedName("ao")
    @ObfuscatedSignature(
            descriptor = "Lqu;"
    )
    IterableNodeHashTable params;

    @ObfuscatedName("w")
    @ObfuscatedSignature(
            descriptor = "(I)V",
            garbageValue = "588512698"
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

    @ObfuscatedName("v")
    @ObfuscatedSignature(
            descriptor = "(Lrd;B)V",
            garbageValue = "19"
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

    @ObfuscatedName("s")
    @ObfuscatedSignature(
            descriptor = "(Lrd;II)V",
            garbageValue = "-1895254265"
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

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      descriptor = "(II)Z",
      garbageValue = "-28697708"
   )
   public final boolean method1016(int var1) {
      if (this.models != null) {
         for(int var4 = 0; var4 < this.models.length; ++var4) {
            if (this.models[var4] == var1) {
               return ObjectDefinition_modelsArchive.tryLoadFile(this.modelIds[var4] & '\uffff', 0);
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
            var2 &= ObjectDefinition_modelsArchive.tryLoadFile(this.modelIds[var3] & '\uffff', 0);
         }

         return var2;
      }
   }

    @ObfuscatedName("j")
    @ObfuscatedSignature(
            descriptor = "(I)Z",
            garbageValue = "484018991"
    )
    public final boolean needsModelFiles() {
      if (this.modelIds == null) {
         return true;
      } else {
         boolean var1 = true;

         for(int var2 = 0; var2 < this.modelIds.length; ++var2) {
            var1 &= ObjectDefinition_modelsArchive.tryLoadFile(this.modelIds[var2] & '\uffff', 0);
         }

         return var1;
      }
   }

    @ObfuscatedName("i")
    @ObfuscatedSignature(
            descriptor = "(II[[IIIII)Lhd;",
            garbageValue = "-433227803"
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
            var9 = ((ModelData)var9).method1121(var3, var4, var5, var6, true, this.clipType);
         }
      }

      return (Renderable)var9;
   }

    @ObfuscatedName("n")
    @ObfuscatedSignature(
            descriptor = "(II[[IIIII)Lhs;",
            garbageValue = "-2132061030"
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

    @ObfuscatedName("l")
    @ObfuscatedSignature(
            descriptor = "(II[[IIIILge;II)Lhs;",
            garbageValue = "322009286"
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

    @ObfuscatedName("k")
    @ObfuscatedSignature(
            descriptor = "(IIB)Lhe;",
            garbageValue = "2"
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
               var3 = ModelData.ModelData_get(ObjectDefinition_modelsArchive, var7 & '\uffff', 0);
               if (var3 == null) {
                  return null;
               }

               if (var4) {
                  var3.method1139();
               }

               ObjectDefinition_cachedModelData.put(var3, (long)var7);
            }

            if (var5 > 1) {
               field1663[var6] = var3;
            }
         }

         if (var5 > 1) {
            var3 = new ModelData(field1663, var5);
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
            var3 = ModelData.ModelData_get(ObjectDefinition_modelsArchive, var5 & '\uffff', 0);
            if (var3 == null) {
               return null;
            }

            if (var10) {
               var3.method1139();
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
         var8.method1125(256);
         var8.changeOffset(45, 0, -45);
      }

      var2 &= 3;
      if (var2 == 1) {
         var8.method1136();
      } else if (var2 == 2) {
         var8.method1123();
      } else if (var2 == 3) {
         var8.method1124();
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

    @ObfuscatedName("c")
    @ObfuscatedSignature(
            descriptor = "(I)Lgp;",
            garbageValue = "577239947"
    )
    public final ObjectComposition transform() {
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

      return var2 != -1 ? class463.getObjectDefinition(var2) : null;
   }

    @ObfuscatedName("r")
    @ObfuscatedSignature(
            descriptor = "(IIS)I",
            garbageValue = "-28323"
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

    @ObfuscatedName("b")
    @ObfuscatedSignature(
            descriptor = "(ILjava/lang/String;B)Ljava/lang/String;",
            garbageValue = "0"
    )
    public String getStringParam(int var1, String var2) {
      return class145.method771(this.params, var1, var2);
   }

    @ObfuscatedName("m")
    @ObfuscatedSignature(
            descriptor = "(I)Z",
            garbageValue = "-1475679879"
    )
    public boolean hasSound() {
      if (this.transforms == null) {
         return this.ambientSoundId != -1 || this.soundEffectIds != null;
      } else {
         for(int var1 = 0; var1 < this.transforms.length; ++var1) {
            if (this.transforms[var1] != -1) {
               ObjectComposition var2 = class463.getObjectDefinition(this.transforms[var1]);
               if (var2.ambientSoundId != -1 || var2.soundEffectIds != null) {
                  return true;
               }
            }
         }

         return false;
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "(Lln;I)V",
      garbageValue = "-1134526530"
   )
   public static void method1029(AbstractArchive var0) {
      DbRowType.field3995 = var0;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "(I)Lji;",
      garbageValue = "-296895971"
   )
   public static PacketBufferNode method1025() {
      PacketBufferNode var0 = InterfaceParent.createPacketBufferNode();
      var0.clientPacket = null;
      var0.clientPacketLength = 0;
      var0.packetBuffer = new PacketBuffer(5000);
      return var0;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      descriptor = "(Lln;IB)V",
      garbageValue = "-82"
   )
   static void method1028(AbstractArchive var0, int var1) {
      if ((var1 & 536870912) != 0) {
         class33.logoSprite = VarcInt.SpriteBuffer_getIndexedSpriteByName(var0, "logo_deadman_mode", "");
      } else if ((var1 & 1073741824) != 0) {
         class33.logoSprite = VarcInt.SpriteBuffer_getIndexedSpriteByName(var0, "logo_seasonal_mode", "");
      } else if ((var1 & 256) != 0) {
         class33.logoSprite = VarcInt.SpriteBuffer_getIndexedSpriteByName(var0, "logo_speedrunning", "");
      } else {
         class33.logoSprite = VarcInt.SpriteBuffer_getIndexedSpriteByName(var0, "logo", "");
      }

   }
}
