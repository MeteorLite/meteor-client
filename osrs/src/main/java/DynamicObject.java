import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bh")
@Implements("DynamicObject")
public class DynamicObject extends Renderable {
   @ObfuscatedName("sa")
   @ObfuscatedSignature(
           descriptor = "Leb;"
   )
   static ClanSettings guestClanSettings;
   @ObfuscatedName("eo")
   @ObfuscatedSignature(
      descriptor = "Llm;"
   )
   static Archive field826;
   @ObfuscatedName("f")
   int id;
   @ObfuscatedName("w")
   int type;
   @ObfuscatedName("v")
   int orientation;
   @ObfuscatedName("s")
   int plane;
   @ObfuscatedName("z")
   int x;
   @ObfuscatedName("j")
   int y;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
           descriptor = "Lge;"
   )
   SequenceDefinition sequenceDefinition;
   @ObfuscatedName("n")
   int frame;
   @ObfuscatedName("l")
   int cycleStart;

   @ObfuscatedSignature(
      descriptor = "(IIIIIIIZLhd;)V"
   )
   DynamicObject(int var1, int var2, int var3, int var4, int var5, int var6, int var7, boolean var8, Renderable var9) {
      this.id = var1;
      this.type = var2;
      this.orientation = var3;
      this.plane = var4;
      this.x = var5;
      this.y = var6;
      if (var7 != -1) {
         this.sequenceDefinition = class85.SequenceDefinition_get(var7);
         this.frame = 0;
         this.cycleStart = Client.cycle - 1;
         if (this.sequenceDefinition.replyMode == 0 && var9 != null && var9 instanceof DynamicObject) {
            DynamicObject var10 = (DynamicObject)var9;
            if (this.sequenceDefinition == var10.sequenceDefinition) {
               this.frame = var10.frame;
               this.cycleStart = var10.cycleStart;
               return;
            }
         }

         if (var8 && this.sequenceDefinition.frameCount != -1) {
            if (!this.sequenceDefinition.isCachedModelIdSet()) {
               this.frame = (int)(Math.random() * (double)this.sequenceDefinition.frameIds.length);
               this.cycleStart -= (int)(Math.random() * (double)this.sequenceDefinition.frameLengths[this.frame]);
            } else {
               this.frame = (int)(Math.random() * (double)this.sequenceDefinition.method1060());
            }
         }
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
           descriptor = "(I)Lhs;",
           garbageValue = "922199662"
   )
   protected final Model getModel() {
      int var2;
      if (this.sequenceDefinition != null) {
         int var1 = Client.cycle - this.cycleStart;
         if (var1 > 100 && this.sequenceDefinition.frameCount > 0) {
            var1 = 100;
         }

         if (this.sequenceDefinition.isCachedModelIdSet()) {
            var2 = this.sequenceDefinition.method1060();
            this.frame += var1;
            var1 = 0;
            if (this.frame >= var2) {
               this.frame = var2 - this.sequenceDefinition.frameCount;
               if (this.frame < 0 || this.frame > var2) {
                  this.sequenceDefinition = null;
               }
            }
         } else {
            label69: {
               do {
                  do {
                     if (var1 <= this.sequenceDefinition.frameLengths[this.frame]) {
                        break label69;
                     }

                     var1 -= this.sequenceDefinition.frameLengths[this.frame];
                     ++this.frame;
                  } while(this.frame < this.sequenceDefinition.frameIds.length);

                  this.frame -= this.sequenceDefinition.frameCount;
               } while(this.frame >= 0 && this.frame < this.sequenceDefinition.frameIds.length);

               this.sequenceDefinition = null;
            }
         }

         this.cycleStart = Client.cycle - var1;
      }

      ObjectComposition var12 = class463.getObjectDefinition(this.id);
      if (var12.transforms != null) {
         var12 = var12.transform();
      }

      if (var12 == null) {
         return null;
      } else {
         int var3;
         if (this.orientation != 1 && this.orientation != 3) {
            var2 = var12.sizeX;
            var3 = var12.sizeY;
         } else {
            var2 = var12.sizeY;
            var3 = var12.sizeX;
         }

         int var4 = (var2 >> 1) + this.x;
         int var5 = (var2 + 1 >> 1) + this.x;
         int var6 = (var3 >> 1) + this.y;
         int var7 = (var3 + 1 >> 1) + this.y;
         int[][] var8 = Tiles.Tiles_heights[this.plane];
         int var9 = var8[var4][var6] + var8[var5][var6] + var8[var4][var7] + var8[var5][var7] >> 2;
         int var10 = (this.x << 7) + (var2 << 6);
         int var11 = (this.y << 7) + (var3 << 6);
         return var12.getModelDynamic(this.type, this.orientation, var8, var10, var9, var11, this.sequenceDefinition, this.frame);
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      descriptor = "(Lda;FI)F",
      garbageValue = "1597261635"
   )
   static float method439(class125 var0, float var1) {
      if (var0 == null) {
         return 0.0F;
      } else {
         float var2;
         if (var1 == var0.field1204) {
            var2 = 0.0F;
         } else if (var1 == var0.field1211) {
            var2 = 1.0F;
         } else {
            var2 = (var1 - var0.field1204) / (var0.field1211 - var0.field1204);
         }

         float var3;
         if (var0.field1209) {
            var3 = var2;
         } else {
            class121.field1174[3] = var0.field1215;
            class121.field1174[2] = var0.field1225;
            class121.field1174[1] = var0.field1213;
            class121.field1174[0] = var0.field1212 - var2;
            class121.field1178[0] = 0.0F;
            class121.field1178[1] = 0.0F;
            class121.field1178[2] = 0.0F;
            class121.field1178[3] = 0.0F;
            class121.field1178[4] = 0.0F;
            int var4 = SpriteMask.method1623(class121.field1174, 3, 0.0F, true, 1.0F, true, class121.field1178);
            if (var4 == 1) {
               var3 = class121.field1178[0];
            } else {
               var3 = 0.0F;
            }
         }

         return var0.field1216 + var3 * (var0.field1219 + (var0.field1218 * var3 + var0.field1217) * var3);
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      descriptor = "(I)Z",
      garbageValue = "-1846374701"
   )
   public static boolean method441() {
      return class290.musicPlayerStatus != 0 ? true : class290.midiPcmStream.isReady();
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      descriptor = "(ILba;ZI)I",
      garbageValue = "-338772616"
   )
   static int method440(int var0, Script var1, boolean var2) {
      if (var0 == 3800) {
         if (guestClanSettings != null) {
            Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = 1;
            WorldMapArea.field2264 = guestClanSettings;
         } else {
            Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = 0;
         }

         return 1;
      } else {
         int var3;
         if (var0 == 3801) {
            var3 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize];
            if (Client.currentClanSettings[var3] != null) {
               Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = 1;
               WorldMapArea.field2264 = Client.currentClanSettings[var3];
            } else {
               Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = 0;
            }

            return 1;
         } else if (var0 == 3802) {
            Interpreter.Interpreter_stringStack[++class20.Interpreter_stringStackSize - 1] = WorldMapArea.field2264.name;
            return 1;
         } else if (var0 == 3803) {
            Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = WorldMapArea.field2264.allowGuests ? 1 : 0;
            return 1;
         } else if (var0 == 3804) {
            Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = WorldMapArea.field2264.field1347;
            return 1;
         } else if (var0 == 3805) {
            Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = WorldMapArea.field2264.field1363;
            return 1;
         } else if (var0 == 3806) {
            Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = WorldMapArea.field2264.field1359;
            return 1;
         } else if (var0 == 3807) {
            Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = WorldMapArea.field2264.field1349;
            return 1;
         } else if (var0 == 3809) {
            Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = WorldMapArea.field2264.memberCount;
            return 1;
         } else if (var0 == 3810) {
            var3 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize];
            Interpreter.Interpreter_stringStack[++class20.Interpreter_stringStackSize - 1] = WorldMapArea.field2264.memberNames[var3];
            return 1;
         } else if (var0 == 3811) {
            var3 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize];
            Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = WorldMapArea.field2264.memberRanks[var3];
            return 1;
         } else if (var0 == 3812) {
            Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = WorldMapArea.field2264.bannedMemberCount;
            return 1;
         } else if (var0 == 3813) {
            var3 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize];
            Interpreter.Interpreter_stringStack[++class20.Interpreter_stringStackSize - 1] = WorldMapArea.field2264.bannedMemberNames[var3];
            return 1;
         } else {
            int var5;
            int var6;
            if (var0 == 3814) {
               class302.Interpreter_intStackSize -= 3;
               var3 = Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize];
               var6 = Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize + 1];
               var5 = Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize + 2];
               Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = WorldMapArea.field2264.method790(var3, var6, var5);
               return 1;
            } else if (var0 == 3815) {
               Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = WorldMapArea.field2264.currentOwner;
               return 1;
            } else if (var0 == 3816) {
               Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = WorldMapArea.field2264.field1358;
               return 1;
            } else if (var0 == 3817) {
               Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = WorldMapArea.field2264.method808(Interpreter.Interpreter_stringStack[--class20.Interpreter_stringStackSize]);
               return 1;
            } else if (var0 == 3818) {
               Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize - 1] = WorldMapArea.field2264.getSortedMembers()[Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize - 1]];
               return 1;
            } else if (var0 == 3819) {
               class302.Interpreter_intStackSize -= 2;
               var3 = Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize];
               var6 = Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize + 1];
               Player.method486(var6, var3);
               return 1;
            } else if (var0 == 3820) {
               var3 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize];
               Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = WorldMapArea.field2264.field1355[var3];
               return 1;
            } else {
               if (var0 == 3821) {
                  class302.Interpreter_intStackSize -= 3;
                  var3 = Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize];
                  boolean var4 = Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize + 1] == 1;
                  var5 = Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize + 2];
                  UserComparator7.method652(var5, var3, var4);
               }

               if (var0 == 3822) {
                  var3 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize];
                  Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = WorldMapArea.field2264.field1356[var3] ? 1 : 0;
                  return 1;
               } else if (var0 == 3850) {
                  if (class482.guestClanChannel != null) {
                     Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = 1;
                     ScriptFrame.field347 = class482.guestClanChannel;
                  } else {
                     Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = 0;
                  }

                  return 1;
               } else if (var0 == 3851) {
                  var3 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize];
                  if (Client.currentClanChannels[var3] != null) {
                     Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = 1;
                     ScriptFrame.field347 = Client.currentClanChannels[var3];
                     MusicPatch.field2746 = var3;
                  } else {
                     Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = 0;
                  }

                  return 1;
               } else if (var0 == 3852) {
                  Interpreter.Interpreter_stringStack[++class20.Interpreter_stringStackSize - 1] = ScriptFrame.field347.name;
                  return 1;
               } else if (var0 == 3853) {
                  Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = ScriptFrame.field347.field1397;
                  return 1;
               } else if (var0 == 3854) {
                  Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = ScriptFrame.field347.field1396;
                  return 1;
               } else if (var0 == 3855) {
                  Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = ScriptFrame.field347.method844();
                  return 1;
               } else if (var0 == 3856) {
                  var3 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize];
                  Interpreter.Interpreter_stringStack[++class20.Interpreter_stringStackSize - 1] = ((ClanChannelMember)ScriptFrame.field347.members.get(var3)).username.getName();
                  return 1;
               } else if (var0 == 3857) {
                  var3 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize];
                  Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = ((ClanChannelMember)ScriptFrame.field347.members.get(var3)).rank;
                  return 1;
               } else if (var0 == 3858) {
                  var3 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize];
                  Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = ((ClanChannelMember)ScriptFrame.field347.members.get(var3)).world;
                  return 1;
               } else if (var0 == 3859) {
                  var3 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize];
                  AbstractByteArrayCopier.method1768(MusicPatch.field2746, var3);
                  return 1;
               } else if (var0 == 3860) {
                  Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = ScriptFrame.field347.method842(Interpreter.Interpreter_stringStack[--class20.Interpreter_stringStackSize]);
                  return 1;
               } else if (var0 == 3861) {
                  Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize - 1] = ScriptFrame.field347.getSortedMembers()[Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize - 1]];
                  return 1;
               } else if (var0 == 3890) {
                  Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = class388.field3667 != null ? 1 : 0;
                  return 1;
               } else {
                  return 2;
               }
            }
         }
      }
   }
}
