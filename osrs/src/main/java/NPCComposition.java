import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hl")
@Implements("NPCComposition")
public class NPCComposition extends DualNode {
   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "Lne;"
   )
   @Export("NpcDefinition_archive")
   public static AbstractArchive NpcDefinition_archive;
   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "Lne;"
   )
   public static AbstractArchive field1548;
   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "Lkt;"
   )
   @Export("NpcDefinition_cached")
   public static EvictingDualNodeHashTable NpcDefinition_cached = new EvictingDualNodeHashTable(64);
   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "Lkt;"
   )
   @Export("NpcDefinition_cachedModels")
   public static EvictingDualNodeHashTable NpcDefinition_cachedModels = new EvictingDualNodeHashTable(50);
   @ObfuscatedName("ao")
   @Export("id")
   public int id;
   @ObfuscatedName("av")
   @Export("name")
   public String name = "null";
   @ObfuscatedName("aq")
   @Export("size")
   public int size = 1;
   @ObfuscatedName("ap")
   @Export("models")
   int[] models;
   @ObfuscatedName("ar")
   int[] field1555;
   @ObfuscatedName("ak")
   @Export("idleSequence")
   public int idleSequence = -1;
   @ObfuscatedName("ax")
   @Export("turnLeftSequence")
   public int turnLeftSequence = -1;
   @ObfuscatedName("as")
   @Export("turnRightSequence")
   public int turnRightSequence = -1;
   @ObfuscatedName("ay")
   @Export("walkSequence")
   public int walkSequence = -1;
   @ObfuscatedName("am")
   @Export("walkBackSequence")
   public int walkBackSequence = -1;
   @ObfuscatedName("az")
   @Export("walkLeftSequence")
   public int walkLeftSequence = -1;
   @ObfuscatedName("ae")
   @Export("walkRightSequence")
   public int walkRightSequence = -1;
   @ObfuscatedName("au")
   @Export("runSequence")
   public int runSequence = -1;
   @ObfuscatedName("ag")
   @Export("runBackSequence")
   public int runBackSequence = -1;
   @ObfuscatedName("at")
   @Export("runLeftSequence")
   public int runLeftSequence = -1;
   @ObfuscatedName("af")
   @Export("runRightSequence")
   public int runRightSequence = -1;
   @ObfuscatedName("ai")
   @Export("crawlSequence")
   public int crawlSequence = -1;
   @ObfuscatedName("aw")
   @Export("crawlBackSequence")
   public int crawlBackSequence = -1;
   @ObfuscatedName("aa")
   @Export("crawlLeftSequence")
   public int crawlLeftSequence = -1;
   @ObfuscatedName("ah")
   @Export("crawlRightSequence")
   public int crawlRightSequence = -1;
   @ObfuscatedName("ad")
   @Export("recolorFrom")
   short[] recolorFrom;
   @ObfuscatedName("bm")
   @Export("recolorTo")
   public short[] recolorTo;
   @ObfuscatedName("bv")
   @Export("retextureFrom")
   short[] retextureFrom;
   @ObfuscatedName("bo")
   @Export("retextureTo")
   public short[] retextureTo;
   @ObfuscatedName("bs")
   @Export("actions")
   public String[] actions = new String[5];
   @ObfuscatedName("bg")
   @Export("drawMapDot")
   public boolean drawMapDot = true;
   @ObfuscatedName("bh")
   @Export("combatLevel")
   public int combatLevel = -1;
   @ObfuscatedName("bl")
   @Export("widthScale")
   int widthScale = 128;
   @ObfuscatedName("bk")
   @Export("heightScale")
   int heightScale = 128;
   @ObfuscatedName("br")
   @Export("isVisible")
   public boolean isVisible = false;
   @ObfuscatedName("ba")
   @Export("ambient")
   int ambient = 0;
   @ObfuscatedName("bz")
   @Export("contrast")
   int contrast = 0;
   @ObfuscatedName("bq")
   @Export("rotation")
   public int rotation = 32;
   @ObfuscatedName("bc")
   @Export("transforms")
   public int[] transforms;
   @ObfuscatedName("bt")
   @Export("transformVarbit")
   int transformVarbit = -1;
   @ObfuscatedName("be")
   @Export("transformVarp")
   int transformVarp = -1;
   @ObfuscatedName("bu")
   @Export("isInteractable")
   public boolean isInteractable = true;
   @ObfuscatedName("bd")
   @Export("isClickable")
   public boolean isClickable = true;
   @ObfuscatedName("by")
   @Export("isFollower")
   public boolean isFollower = false;
   @ObfuscatedName("bp")
   @Export("headIconArchiveIds")
   int[] headIconArchiveIds = null;
   @ObfuscatedName("bb")
   @Export("headIconSpriteIndexes")
   short[] headIconSpriteIndexes = null;
   @ObfuscatedName("bx")
   @ObfuscatedSignature(
      descriptor = "Lrz;"
   )
   @Export("params")
   IterableNodeHashTable params;

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "1346369690"
   )
   @Export("postDecode")
   void postDecode() {
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "(Lsy;I)V",
      garbageValue = "-208240743"
   )
   @Export("decode")
   void decode(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if (var2 == 0) {
            return;
         }

         this.decodeNext(var1, var2);
      }
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "(Lsy;IS)V",
      garbageValue = "8039"
   )
   @Export("decodeNext")
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
         this.field1555 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field1555[var4] = var1.readUnsignedShort();
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
                  this.headIconArchiveIds[var6] = var1.method2423();
                  this.headIconSpriteIndexes[var6] = (short)var1.method2415();
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
               this.params = AABB.readStringIntParameters(var1, this.params);
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

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "(Lhx;ILhx;ILhj;B)Lix;",
      garbageValue = "3"
   )
   public final Model method961(SequenceDefinition var1, int var2, SequenceDefinition var3, int var4, NewShit var5) {
      if (this.transforms != null) {
         NPCComposition var6 = this.transform();
         return var6 == null ? null : var6.method961(var1, var2, var3, var4, var5);
      } else {
         long var10 = (long)this.id;
         if (var5 != null) {
            var10 |= var5.field1545 << 16;
         }

         Model var8 = (Model)NpcDefinition_cachedModels.get(var10);
         if (var8 == null) {
            ModelData var9 = this.method970(this.models, var5);
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

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      descriptor = "(Lhj;B)Liu;",
      garbageValue = "48"
   )
   public final ModelData method962(NewShit var1) {
      if (this.transforms != null) {
         NPCComposition var2 = this.transform();
         return var2 == null ? null : var2.method962(var1);
      } else {
         return this.method970(this.field1555, var1);
      }
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      descriptor = "([ILhj;I)Liu;",
      garbageValue = "1908228242"
   )
   ModelData method970(int[] var1, NewShit var2) {
      int[] var3 = var1;
      if (var2 != null && var2.field1542 != null) {
         var3 = var2.field1542;
      }

      if (var3 == null) {
         return null;
      } else {
         boolean var4 = false;

         for(int var5 = 0; var5 < var3.length; ++var5) {
            if (var3[var5] != -1 && !field1548.tryLoadFile(var3[var5], 0)) {
               var4 = true;
            }
         }

         if (var4) {
            return null;
         } else {
            ModelData[] var9 = new ModelData[var3.length];

            for(int var6 = 0; var6 < var3.length; ++var6) {
               var9[var6] = ModelData.ModelData_get(field1548, var3[var6], 0);
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
               if (var2 != null && var2.field1543 != null) {
                  var7 = var2.field1543;
               }

               for(var8 = 0; var8 < this.recolorFrom.length; ++var8) {
                  var10.recolor(this.recolorFrom[var8], var7[var8]);
               }
            }

            if (this.retextureFrom != null) {
               var7 = this.retextureTo;
               if (var2 != null && var2.field1544 != null) {
                  var7 = var2.field1544;
               }

               for(var8 = 0; var8 < this.retextureFrom.length; ++var8) {
                  var10.retexture(this.retextureFrom[var8], var7[var8]);
               }
            }

            return var10;
         }
      }
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      descriptor = "(B)Lhl;",
      garbageValue = "99"
   )
   @Export("transform")
   public final NPCComposition transform() {
      int var1 = -1;
      if (this.transformVarbit != -1) {
         var1 = class17.getVarbit(this.transformVarbit);
      } else if (this.transformVarp != -1) {
         var1 = Varps.Varps_main[this.transformVarp];
      }

      int var2;
      if (var1 >= 0 && var1 < this.transforms.length - 1) {
         var2 = this.transforms[var1];
      } else {
         var2 = this.transforms[this.transforms.length - 1];
      }

      return var2 != -1 ? class188.getNpcDefinition(var2) : null;
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      descriptor = "(I)Z",
      garbageValue = "1446160465"
   )
   @Export("transformIsVisible")
   public boolean transformIsVisible() {
      if (this.transforms == null) {
         return true;
      } else {
         int var1 = -1;
         if (this.transformVarbit != -1) {
            var1 = class17.getVarbit(this.transformVarbit);
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

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      descriptor = "(III)I",
      garbageValue = "-2100920118"
   )
   @Export("getIntParam")
   public int getIntParam(int var1, int var2) {
      return class139.method747(this.params, var1, var2);
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      descriptor = "(ILjava/lang/String;I)Ljava/lang/String;",
      garbageValue = "-2002434175"
   )
   @Export("getStringParam")
   public String getStringParam(int var1, String var2) {
      return class428.method2219(this.params, var1, var2);
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      descriptor = "(S)Z",
      garbageValue = "29155"
   )
   public boolean method967() {
      return this.headIconArchiveIds != null && this.headIconSpriteIndexes != null;
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      descriptor = "(B)[I",
      garbageValue = "111"
   )
   public int[] method968() {
      return this.headIconArchiveIds;
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      descriptor = "(II)I",
      garbageValue = "-829102278"
   )
   public int method969(int var1) {
      return this.headIconArchiveIds != null && var1 < this.headIconArchiveIds.length ? this.headIconArchiveIds[var1] : -1;
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      descriptor = "(I)[S",
      garbageValue = "483392453"
   )
   public short[] method964() {
      return this.headIconSpriteIndexes;
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      descriptor = "(II)S",
      garbageValue = "1369177294"
   )
   public short method972(int var1) {
      return this.headIconSpriteIndexes != null && var1 < this.headIconSpriteIndexes.length ? this.headIconSpriteIndexes[var1] : -1;
   }

   @ObfuscatedName("bn")
   @ObfuscatedSignature(
      descriptor = "(ILcv;ZI)I",
      garbageValue = "-1030053698"
   )
   static int method974(int var0, Script var1, boolean var2) {
      return 2;
   }

   @ObfuscatedName("ld")
   @ObfuscatedSignature(
      descriptor = "(IIB)V",
      garbageValue = "-64"
   )
   @Export("runIntfCloseListeners")
   static final void runIntfCloseListeners(int var0, int var1) {
      if (GrandExchangeEvent.loadInterface(var0)) {
         class6.runComponentCloseListeners(class155.Widget_interfaceComponents[var0], var1);
      }
   }
}
