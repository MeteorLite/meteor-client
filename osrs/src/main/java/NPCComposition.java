import java.util.Date;

import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gz")
@Implements("NPCComposition")
public class NPCComposition extends DualNode {
   @ObfuscatedName("tq")
   static int field1594;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "Lly;"
   )
   static AbstractArchive NpcDefinition_archive;
   @ObfuscatedName("m")
   static int defaultHeadIconArchive;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      descriptor = "Ljv;"
   )
   static EvictingDualNodeHashTable NpcDefinition_cached = new EvictingDualNodeHashTable(64);
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "Ljv;"
   )
   static EvictingDualNodeHashTable NpcDefinition_cachedModels = new EvictingDualNodeHashTable(50);
   @ObfuscatedName("r")
   public int id;
   @ObfuscatedName("u")
   public String name = "null";
   @ObfuscatedName("b")
   public int size = 1;
   @ObfuscatedName("j")
   int[] models;
   @ObfuscatedName("g")
   int[] field1554;
   @ObfuscatedName("i")
   public int idleSequence = -1;
   @ObfuscatedName("o")
   public int turnLeftSequence = -1;
   @ObfuscatedName("n")
   public int turnRightSequence = -1;
   @ObfuscatedName("k")
   public int walkSequence = -1;
   @ObfuscatedName("a")
   public int walkBackSequence = -1;
   @ObfuscatedName("s")
   public int walkLeftSequence = -1;
   @ObfuscatedName("l")
   public int walkRightSequence = -1;
   @ObfuscatedName("t")
   public int runSequence = -1;
   @ObfuscatedName("c")
   public int runBackSequence = -1;
   @ObfuscatedName("p")
   public int runLeftSequence = -1;
   @ObfuscatedName("d")
   public int runRightSequence = -1;
   @ObfuscatedName("y")
   public int crawlSequence = -1;
   @ObfuscatedName("z")
   public int crawlBackSequence = -1;
   @ObfuscatedName("w")
   public int crawlLeftSequence = -1;
   @ObfuscatedName("as")
   public int crawlRightSequence = -1;
   @ObfuscatedName("ad")
   short[] recolorFrom;
   @ObfuscatedName("ao")
   public short[] recolorTo;
   @ObfuscatedName("am")
   short[] retextureFrom;
   @ObfuscatedName("av")
   public short[] retextureTo;
   @ObfuscatedName("au")
   public String[] actions = new String[5];
   @ObfuscatedName("ar")
   public boolean drawMapDot = true;
   @ObfuscatedName("at")
   public int combatLevel = -1;
   @ObfuscatedName("ay")
   int widthScale = 128;
   @ObfuscatedName("an")
   int heightScale = 128;
   @ObfuscatedName("ab")
   public boolean isVisible = false;
   @ObfuscatedName("al")
   int ambient = 0;
   @ObfuscatedName("ag")
   int contrast = 0;
   @ObfuscatedName("az")
   public int rotation = 32;
   @ObfuscatedName("ak")
   public int[] transforms;
   @ObfuscatedName("af")
   int transformVarbit = -1;
   @ObfuscatedName("ai")
   int transformVarp = -1;
   @ObfuscatedName("ax")
   public boolean isInteractable = true;
   @ObfuscatedName("ah")
   public boolean isClickable = true;
   @ObfuscatedName("aw")
   public boolean isFollower = false;
   @ObfuscatedName("aj")
   int[] headIconArchiveIds = null;
   @ObfuscatedName("aq")
   short[] headIconSpriteIndexes = null;
   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      descriptor = "Lql;"
   )
   IterableNodeHashTable params;

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "-60"
   )
   void postDecode() {
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      descriptor = "(Lqy;B)V",
      garbageValue = "0"
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

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      descriptor = "(Lqy;II)V",
      garbageValue = "-1000073156"
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
         this.field1554 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field1554[var4] = var1.readUnsignedShort();
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
            if (GrandExchangeOfferUnitPriceComparator.field3505) {
               this.headIconArchiveIds = new int[1];
               this.headIconSpriteIndexes = new short[1];
               this.headIconArchiveIds[0] = defaultHeadIconArchive;
               this.headIconSpriteIndexes[0] = (short)var1.readUnsignedShort();
            } else {
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
                     this.headIconArchiveIds[var6] = var1.method2362();
                     this.headIconSpriteIndexes[var6] = (short)var1.method2407();
                  }
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
               this.params = DynamicObject.readStringIntParameters(var1, this.params);
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

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      descriptor = "(Lga;ILga;ILgp;B)Lhh;",
      garbageValue = "115"
   )
   public final Model method966(SequenceDefinition var1, int var2, SequenceDefinition var3, int var4, NewShit var5) {
      if (this.transforms != null) {
         NPCComposition var6 = this.transform();
         return var6 == null ? null : var6.method966(var1, var2, var3, var4, var5);
      } else {
         long var10 = (long)this.id;
         if (var5 != null) {
            var10 |= var5.field1546 << 16;
         }

         Model var8 = (Model)NpcDefinition_cachedModels.get(var10);
         if (var8 == null) {
            ModelData var9 = this.method955(this.models, var5);
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

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "(Lgp;I)Lgi;",
      garbageValue = "1744013797"
   )
   public final ModelData method953(NewShit var1) {
      if (this.transforms != null) {
         NPCComposition var2 = this.transform();
         return var2 == null ? null : var2.method953(var1);
      } else {
         return this.method955(this.field1554, var1);
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      descriptor = "([ILgp;I)Lgi;",
      garbageValue = "951395147"
   )
   ModelData method955(int[] var1, NewShit var2) {
      int[] var3 = var1;
      if (var2 != null && var2.field1542 != null) {
         var3 = var2.field1542;
      }

      if (var3 == null) {
         return null;
      } else {
         boolean var4 = false;

         for(int var5 = 0; var5 < var3.length; ++var5) {
            if (var3[var5] != -1 && !class363.field3575.tryLoadFile(var3[var5], 0)) {
               var4 = true;
            }
         }

         if (var4) {
            return null;
         } else {
            ModelData[] var9 = new ModelData[var3.length];

            for(int var6 = 0; var6 < var3.length; ++var6) {
               var9[var6] = ModelData.ModelData_get(class363.field3575, var3[var6], 0);
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

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      descriptor = "(I)Lgz;",
      garbageValue = "-549841481"
   )
   public final NPCComposition transform() {
      int var1 = -1;
      if (this.transformVarbit != -1) {
         var1 = ObjTypeCustomisation.getVarbit(this.transformVarbit);
      } else if (this.transformVarp != -1) {
         var1 = Varps.Varps_main[this.transformVarp];
      }

      int var2;
      if (var1 >= 0 && var1 < this.transforms.length - 1) {
         var2 = this.transforms[var1];
      } else {
         var2 = this.transforms[this.transforms.length - 1];
      }

      return var2 != -1 ? class129.getNpcDefinition(var2) : null;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      descriptor = "(I)Z",
      garbageValue = "2130957543"
   )
   public boolean transformIsVisible() {
      if (this.transforms == null) {
         return true;
      } else {
         int var1 = -1;
         if (this.transformVarbit != -1) {
            var1 = ObjTypeCustomisation.getVarbit(this.transformVarbit);
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

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      descriptor = "(III)I",
      garbageValue = "-1577076717"
   )
   public int getIntParam(int var1, int var2) {
      return UserComparator8.method661(this.params, var1, var2);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      descriptor = "(ILjava/lang/String;B)Ljava/lang/String;",
      garbageValue = "100"
   )
   public String getStringParam(int var1, String var2) {
      IterableNodeHashTable var4 = this.params;
      String var3;
      if (var4 == null) {
         var3 = var2;
      } else {
         ObjectNode var5 = (ObjectNode)var4.get((long)var1);
         if (var5 == null) {
            var3 = var2;
         } else {
            var3 = (String)var5.obj;
         }
      }

      return var3;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      descriptor = "(I)Z",
      garbageValue = "-700368633"
   )
   public boolean method958() {
      return this.headIconArchiveIds != null && this.headIconSpriteIndexes != null;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      descriptor = "(I)[I",
      garbageValue = "-1876307033"
   )
   public int[] method961() {
      return this.headIconArchiveIds;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      descriptor = "(II)I",
      garbageValue = "803471346"
   )
   public int method952(int var1) {
      return this.headIconArchiveIds != null && var1 < this.headIconArchiveIds.length ? this.headIconArchiveIds[var1] : -1;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      descriptor = "(I)[S",
      garbageValue = "-44005875"
   )
   public short[] method964() {
      return this.headIconSpriteIndexes;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      descriptor = "(II)S",
      garbageValue = "257867612"
   )
   public short method959(int var1) {
      return this.headIconSpriteIndexes != null && var1 < this.headIconSpriteIndexes.length ? this.headIconSpriteIndexes[var1] : -1;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "(II)Lgr;",
      garbageValue = "-664337463"
   )
   public static ItemComposition ItemDefinition_get(int var0) {
      ItemComposition var1 = (ItemComposition)ItemComposition.ItemDefinition_cached.get((long)var0);
      if (var1 != null) {
         return var1;
      } else {
         byte[] var2 = ItemComposition.ItemDefinition_archive.takeFile(10, var0);
         var1 = new ItemComposition();
         var1.id = var0;
         if (var2 != null) {
            var1.decode(new Buffer(var2));
         }

         var1.post();
         if (var1.noteTemplate != -1) {
            var1.genCert(ItemDefinition_get(var1.noteTemplate), ItemDefinition_get(var1.note));
         }

         if (var1.notedId != -1) {
            var1.genBought(ItemDefinition_get(var1.notedId), ItemDefinition_get(var1.unnotedId));
         }

         if (var1.placeholderTemplate != -1) {
            var1.genPlaceholder(ItemDefinition_get(var1.placeholderTemplate), ItemDefinition_get(var1.placeholder));
         }

         if (!Clock.ItemDefinition_inMembersWorld && var1.isMembersOnly) {
            var1.name = "Members object";
            var1.isTradable = false;

            int var3;
            for(var3 = 0; var3 < var1.groundActions.length; ++var3) {
               var1.groundActions[var3] = null;
            }

            for(var3 = 0; var3 < var1.inventoryActions.length; ++var3) {
               if (var3 != 4) {
                  var1.inventoryActions[var3] = null;
               }
            }

            var1.shiftClickIndex = -2;
            var1.team = 0;
            if (var1.params != null) {
               boolean var6 = false;

               for(Node var4 = var1.params.first(); var4 != null; var4 = var1.params.next()) {
                  ParamComposition var5 = class149.getParamDefinition((int)var4.key);
                  if (var5.autoDisable) {
                     var4.remove();
                  } else {
                     var6 = true;
                  }
               }

               if (!var6) {
                  var1.params = null;
               }
            }
         }

         ItemComposition.ItemDefinition_cached.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      descriptor = "(ILbm;ZI)I",
      garbageValue = "-771473401"
   )
   static int method967(int var0, Script var1, boolean var2) {
      String var3;
      int var4;
      if (var0 == 4100) {
         var3 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
         var4 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize];
         Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var3 + var4;
         return 1;
      } else {
         String var9;
         if (var0 == 4101) {
            Interpreter.Interpreter_stringStackSize -= 2;
            var3 = Interpreter.Interpreter_stringStack[Interpreter.Interpreter_stringStackSize];
            var9 = Interpreter.Interpreter_stringStack[Interpreter.Interpreter_stringStackSize + 1];
            Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var3 + var9;
            return 1;
         } else if (var0 == 4102) {
            var3 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
            var4 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize];
            Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var3 + Huffman.intToString(var4, true);
            return 1;
         } else if (var0 == 4103) {
            var3 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
            Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var3.toLowerCase();
            return 1;
         } else {
            int var6;
            int var10;
            if (var0 == 4104) {
               var10 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize];
               long var11 = ((long)var10 + 11745L) * 86400000L;
               Interpreter.Interpreter_calendar.setTime(new Date(var11));
               var6 = Interpreter.Interpreter_calendar.get(5);
               int var17 = Interpreter.Interpreter_calendar.get(2);
               int var8 = Interpreter.Interpreter_calendar.get(1);
               Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var6 + "-" + Interpreter.Interpreter_MONTHS[var17] + "-" + var8;
               return 1;
            } else if (var0 != 4105) {
               if (var0 == 4106) {
                  var10 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize];
                  Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = Integer.toString(var10);
                  return 1;
               } else if (var0 == 4107) {
                  Interpreter.Interpreter_stringStackSize -= 2;
                  Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = class145.method773(WallDecoration.compareStrings(Interpreter.Interpreter_stringStack[Interpreter.Interpreter_stringStackSize], Interpreter.Interpreter_stringStack[Interpreter.Interpreter_stringStackSize + 1], class173.clientLanguage));
                  return 1;
               } else {
                  int var5;
                  byte[] var13;
                  Font var14;
                  if (var0 == 4108) {
                     var3 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
                     class87.Interpreter_intStackSize -= 2;
                     var4 = Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize];
                     var5 = Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize + 1];
                     var13 = class358.archive13.takeFile(var5, 0);
                     var14 = new Font(var13);
                     Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = var14.lineCount(var3, var4);
                     return 1;
                  } else if (var0 == 4109) {
                     var3 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
                     class87.Interpreter_intStackSize -= 2;
                     var4 = Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize];
                     var5 = Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize + 1];
                     var13 = class358.archive13.takeFile(var5, 0);
                     var14 = new Font(var13);
                     Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = var14.lineWidth(var3, var4);
                     return 1;
                  } else if (var0 == 4110) {
                     Interpreter.Interpreter_stringStackSize -= 2;
                     var3 = Interpreter.Interpreter_stringStack[Interpreter.Interpreter_stringStackSize];
                     var9 = Interpreter.Interpreter_stringStack[Interpreter.Interpreter_stringStackSize + 1];
                     if (Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize] == 1) {
                        Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var3;
                     } else {
                        Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var9;
                     }

                     return 1;
                  } else if (var0 == 4111) {
                     var3 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
                     Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = AbstractFont.escapeBrackets(var3);
                     return 1;
                  } else if (var0 == 4112) {
                     var3 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
                     var4 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize];
                     Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var3 + (char)var4;
                     return 1;
                  } else if (var0 == 4113) {
                     var10 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize];
                     Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = class148.isCharPrintable((char)var10) ? 1 : 0;
                     return 1;
                  } else if (var0 == 4114) {
                     var10 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize];
                     Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = ObjectComposition.isAlphaNumeric((char)var10) ? 1 : 0;
                     return 1;
                  } else if (var0 == 4115) {
                     var10 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize];
                     Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = ViewportMouse.isCharAlphabetic((char)var10) ? 1 : 0;
                     return 1;
                  } else if (var0 == 4116) {
                     var10 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize];
                     Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = WorldMapLabelSize.isDigit((char)var10) ? 1 : 0;
                     return 1;
                  } else if (var0 == 4117) {
                     var3 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
                     if (var3 != null) {
                        Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = var3.length();
                     } else {
                        Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = 0;
                     }

                     return 1;
                  } else if (var0 == 4118) {
                     var3 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
                     class87.Interpreter_intStackSize -= 2;
                     var4 = Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize];
                     var5 = Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize + 1];
                     Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var3.substring(var4, var5);
                     return 1;
                  } else if (var0 == 4119) {
                     var3 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
                     StringBuilder var18 = new StringBuilder(var3.length());
                     boolean var16 = false;

                     for(var6 = 0; var6 < var3.length(); ++var6) {
                        char var7 = var3.charAt(var6);
                        if (var7 == '<') {
                           var16 = true;
                        } else if (var7 == '>') {
                           var16 = false;
                        } else if (!var16) {
                           var18.append(var7);
                        }
                     }

                     Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var18.toString();
                     return 1;
                  } else if (var0 == 4120) {
                     var3 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
                     var4 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize];
                     Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = var3.indexOf(var4);
                     return 1;
                  } else if (var0 == 4121) {
                     Interpreter.Interpreter_stringStackSize -= 2;
                     var3 = Interpreter.Interpreter_stringStack[Interpreter.Interpreter_stringStackSize];
                     var9 = Interpreter.Interpreter_stringStack[Interpreter.Interpreter_stringStackSize + 1];
                     var5 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize];
                     Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = var3.indexOf(var9, var5);
                     return 1;
                  } else if (var0 == 4122) {
                     var3 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
                     Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var3.toUpperCase();
                     return 1;
                  } else if (var0 == 4123) {
                     Interpreter.Interpreter_stringStackSize -= 3;
                     var3 = Interpreter.Interpreter_stringStack[Interpreter.Interpreter_stringStackSize];
                     var9 = Interpreter.Interpreter_stringStack[Interpreter.Interpreter_stringStackSize + 1];
                     String var15 = Interpreter.Interpreter_stringStack[Interpreter.Interpreter_stringStackSize + 2];
                     if (class155.localPlayer.appearance == null) {
                        Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var15;
                        return 1;
                     } else {
                        switch(class155.localPlayer.appearance.field2820) {
                        case 0:
                           Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var3;
                           break;
                        case 1:
                           Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var9;
                           break;
                        case 2:
                        default:
                           Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var15;
                        }

                        return 1;
                     }
                  } else {
                     return 2;
                  }
               }
            } else {
               Interpreter.Interpreter_stringStackSize -= 2;
               var3 = Interpreter.Interpreter_stringStack[Interpreter.Interpreter_stringStackSize];
               var9 = Interpreter.Interpreter_stringStack[Interpreter.Interpreter_stringStackSize + 1];
               if (class155.localPlayer.appearance != null && class155.localPlayer.appearance.field2818 != 0) {
                  Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var9;
               } else {
                  Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var3;
               }

               return 1;
            }
         }
      }
   }
}
