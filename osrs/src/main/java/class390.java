import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("oq")
class class390 implements Comparator {
   // $FF: synthetic field
   @ObfuscatedSignature(
           descriptor = "Lok;"
   )
   @ObfuscatedName("this$0")
   final class391 this$0;

   @ObfuscatedSignature(
      descriptor = "(Lok;)V"
   )
   class390(class391 var1) {
      this.this$0 = var1;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "(Loh;Loh;I)I",
      garbageValue = "-653612573"
   )
   int method2049(class392 var1, class392 var2) {
      if (var1.field3681 > var2.field3681) {
         return 1;
      } else {
         return var1.field3681 < var2.field3681 ? -1 : 0;
      }
   }

   @ObfuscatedName("compare")
   public int compare(Object var1, Object var2) {
      return this.method2049((class392)var1, (class392)var2);
   }

   @ObfuscatedName("equals")
   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      descriptor = "(ILba;ZI)I",
      garbageValue = "1626793735"
   )
   static int method2047(int var0, Script var1, boolean var2) {
      if (var0 == 3600) {
         if (WorldMapElement.friendSystem.field682 == 0) {
            Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = -2;
         } else if (WorldMapElement.friendSystem.field682 == 1) {
            Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = -1;
         } else {
            Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = WorldMapElement.friendSystem.friendsList.getSize();
         }

         return 1;
      } else {
         int var3;
         if (var0 == 3601) {
            var3 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize];
            if (WorldMapElement.friendSystem.method404() && var3 >= 0 && var3 < WorldMapElement.friendSystem.friendsList.getSize()) {
               Friend var8 = (Friend)WorldMapElement.friendSystem.friendsList.get(var3);
               Interpreter.Interpreter_stringStack[++class20.Interpreter_stringStackSize - 1] = var8.getName();
               Interpreter.Interpreter_stringStack[++class20.Interpreter_stringStackSize - 1] = var8.getPreviousName();
            } else {
               Interpreter.Interpreter_stringStack[++class20.Interpreter_stringStackSize - 1] = "";
               Interpreter.Interpreter_stringStack[++class20.Interpreter_stringStackSize - 1] = "";
            }

            return 1;
         } else if (var0 == 3602) {
            var3 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize];
            if (WorldMapElement.friendSystem.method404() && var3 >= 0 && var3 < WorldMapElement.friendSystem.friendsList.getSize()) {
               Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = ((Buddy)WorldMapElement.friendSystem.friendsList.get(var3)).world;
            } else {
               Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = 0;
            }

            return 1;
         } else if (var0 == 3603) {
            var3 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize];
            if (WorldMapElement.friendSystem.method404() && var3 >= 0 && var3 < WorldMapElement.friendSystem.friendsList.getSize()) {
               Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = ((Buddy)WorldMapElement.friendSystem.friendsList.get(var3)).rank;
            } else {
               Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = 0;
            }

            return 1;
         } else {
            String var5;
            if (var0 == 3604) {
               var5 = Interpreter.Interpreter_stringStack[--class20.Interpreter_stringStackSize];
               int var6 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize];
               class385.method2030(var5, var6);
               return 1;
            } else if (var0 == 3605) {
               var5 = Interpreter.Interpreter_stringStack[--class20.Interpreter_stringStackSize];
               WorldMapElement.friendSystem.addFriend(var5);
               return 1;
            } else if (var0 == 3606) {
               var5 = Interpreter.Interpreter_stringStack[--class20.Interpreter_stringStackSize];
               WorldMapElement.friendSystem.removeFriend(var5);
               return 1;
            } else if (var0 == 3607) {
               var5 = Interpreter.Interpreter_stringStack[--class20.Interpreter_stringStackSize];
               WorldMapElement.friendSystem.addIgnore(var5);
               return 1;
            } else if (var0 == 3608) {
               var5 = Interpreter.Interpreter_stringStack[--class20.Interpreter_stringStackSize];
               WorldMapElement.friendSystem.removeIgnore(var5);
               return 1;
            } else if (var0 == 3609) {
               var5 = Interpreter.Interpreter_stringStack[--class20.Interpreter_stringStackSize];
               var5 = class6.method16(var5);
               Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = WorldMapElement.friendSystem.isFriended(new Username(var5, WorldMapCacheName.loginType), false) ? 1 : 0;
               return 1;
            } else if (var0 == 3611) {
               if (class463.friendsChat != null) {
                  Interpreter.Interpreter_stringStack[++class20.Interpreter_stringStackSize - 1] = class463.friendsChat.name;
               } else {
                  Interpreter.Interpreter_stringStack[++class20.Interpreter_stringStackSize - 1] = "";
               }

               return 1;
            } else if (var0 == 3612) {
               if (class463.friendsChat != null) {
                  Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = class463.friendsChat.getSize();
               } else {
                  Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = 0;
               }

               return 1;
            } else if (var0 == 3613) {
               var3 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize];
               if (class463.friendsChat != null && var3 < class463.friendsChat.getSize()) {
                  Interpreter.Interpreter_stringStack[++class20.Interpreter_stringStackSize - 1] = class463.friendsChat.get(var3).getUsername().getName();
               } else {
                  Interpreter.Interpreter_stringStack[++class20.Interpreter_stringStackSize - 1] = "";
               }

               return 1;
            } else if (var0 == 3614) {
               var3 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize];
               if (class463.friendsChat != null && var3 < class463.friendsChat.getSize()) {
                  Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = ((Buddy)class463.friendsChat.get(var3)).getWorld();
               } else {
                  Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = 0;
               }

               return 1;
            } else if (var0 == 3615) {
               var3 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize];
               if (class463.friendsChat != null && var3 < class463.friendsChat.getSize()) {
                  Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = ((Buddy)class463.friendsChat.get(var3)).rank;
               } else {
                  Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = 0;
               }

               return 1;
            } else if (var0 == 3616) {
               Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = class463.friendsChat != null ? class463.friendsChat.minKick : 0;
               return 1;
            } else if (var0 == 3617) {
               var5 = Interpreter.Interpreter_stringStack[--class20.Interpreter_stringStackSize];
               class160.clanKickUser(var5);
               return 1;
            } else if (var0 == 3618) {
               Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = class463.friendsChat != null ? class463.friendsChat.rank * -414265771 * -2029011203 : 0;
               return 1;
            } else if (var0 == 3619) {
               var5 = Interpreter.Interpreter_stringStack[--class20.Interpreter_stringStackSize];
               ClanSettings.Clan_joinChat(var5);
               return 1;
            } else if (var0 == 3620) {
               GrandExchangeOffer.Clan_leaveChat();
               return 1;
            } else if (var0 == 3621) {
               if (!WorldMapElement.friendSystem.method404()) {
                  Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = -1;
               } else {
                  Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = WorldMapElement.friendSystem.ignoreList.getSize();
               }

               return 1;
            } else if (var0 == 3622) {
               var3 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize];
               if (WorldMapElement.friendSystem.method404() && var3 >= 0 && var3 < WorldMapElement.friendSystem.ignoreList.getSize()) {
                  Ignored var4 = (Ignored)WorldMapElement.friendSystem.ignoreList.get(var3);
                  Interpreter.Interpreter_stringStack[++class20.Interpreter_stringStackSize - 1] = var4.getName();
                  Interpreter.Interpreter_stringStack[++class20.Interpreter_stringStackSize - 1] = var4.getPreviousName();
               } else {
                  Interpreter.Interpreter_stringStack[++class20.Interpreter_stringStackSize - 1] = "";
                  Interpreter.Interpreter_stringStack[++class20.Interpreter_stringStackSize - 1] = "";
               }

               return 1;
            } else if (var0 == 3623) {
               var5 = Interpreter.Interpreter_stringStack[--class20.Interpreter_stringStackSize];
               var5 = class6.method16(var5);
               Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = WorldMapElement.friendSystem.isIgnored(new Username(var5, WorldMapCacheName.loginType)) ? 1 : 0;
               return 1;
            } else if (var0 == 3624) {
               var3 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize];
               if (class463.friendsChat != null && var3 < class463.friendsChat.getSize() && class463.friendsChat.get(var3).getUsername().equals(class387.localPlayer.username)) {
                  Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = 1;
               } else {
                  Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = 0;
               }

               return 1;
            } else if (var0 == 3625) {
               if (class463.friendsChat != null && class463.friendsChat.owner != null) {
                  Interpreter.Interpreter_stringStack[++class20.Interpreter_stringStackSize - 1] = class463.friendsChat.owner;
               } else {
                  Interpreter.Interpreter_stringStack[++class20.Interpreter_stringStackSize - 1] = "";
               }

               return 1;
            } else if (var0 == 3626) {
               var3 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize];
               if (class463.friendsChat != null && var3 < class463.friendsChat.getSize() && ((ClanMate)class463.friendsChat.get(var3)).isFriend()) {
                  Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = 1;
               } else {
                  Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = 0;
               }

               return 1;
            } else if (var0 != 3627) {
               if (var0 == 3628) {
                  WorldMapElement.friendSystem.friendsList.removeComparator();
                  return 1;
               } else {
                  boolean var7;
                  if (var0 == 3629) {
                     var7 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize] == 1;
                     WorldMapElement.friendSystem.friendsList.addComparator(new UserComparator1(var7));
                     return 1;
                  } else if (var0 == 3630) {
                     var7 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize] == 1;
                     WorldMapElement.friendSystem.friendsList.addComparator(new UserComparator2(var7));
                     return 1;
                  } else if (var0 == 3631) {
                     var7 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize] == 1;
                     WorldMapElement.friendSystem.friendsList.addComparator(new UserComparator3(var7));
                     return 1;
                  } else if (var0 == 3632) {
                     var7 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize] == 1;
                     WorldMapElement.friendSystem.friendsList.addComparator(new UserComparator4(var7));
                     return 1;
                  } else if (var0 == 3633) {
                     var7 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize] == 1;
                     WorldMapElement.friendSystem.friendsList.addComparator(new UserComparator5(var7));
                     return 1;
                  } else if (var0 == 3634) {
                     var7 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize] == 1;
                     WorldMapElement.friendSystem.friendsList.addComparator(new UserComparator6(var7));
                     return 1;
                  } else if (var0 == 3635) {
                     var7 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize] == 1;
                     WorldMapElement.friendSystem.friendsList.addComparator(new UserComparator7(var7));
                     return 1;
                  } else if (var0 == 3636) {
                     var7 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize] == 1;
                     WorldMapElement.friendSystem.friendsList.addComparator(new UserComparator8(var7));
                     return 1;
                  } else if (var0 == 3637) {
                     var7 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize] == 1;
                     WorldMapElement.friendSystem.friendsList.addComparator(new UserComparator9(var7));
                     return 1;
                  } else if (var0 == 3638) {
                     var7 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize] == 1;
                     WorldMapElement.friendSystem.friendsList.addComparator(new UserComparator10(var7));
                     return 1;
                  } else if (var0 == 3639) {
                     WorldMapElement.friendSystem.friendsList.sort();
                     return 1;
                  } else if (var0 == 3640) {
                     WorldMapElement.friendSystem.ignoreList.removeComparator();
                     return 1;
                  } else if (var0 == 3641) {
                     var7 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize] == 1;
                     WorldMapElement.friendSystem.ignoreList.addComparator(new UserComparator1(var7));
                     return 1;
                  } else if (var0 == 3642) {
                     var7 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize] == 1;
                     WorldMapElement.friendSystem.ignoreList.addComparator(new UserComparator2(var7));
                     return 1;
                  } else if (var0 == 3643) {
                     WorldMapElement.friendSystem.ignoreList.sort();
                     return 1;
                  } else if (var0 == 3644) {
                     if (class463.friendsChat != null) {
                        class463.friendsChat.removeComparator();
                     }

                     return 1;
                  } else if (var0 == 3645) {
                     var7 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize] == 1;
                     if (class463.friendsChat != null) {
                        class463.friendsChat.addComparator(new UserComparator1(var7));
                     }

                     return 1;
                  } else if (var0 == 3646) {
                     var7 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize] == 1;
                     if (class463.friendsChat != null) {
                        class463.friendsChat.addComparator(new UserComparator2(var7));
                     }

                     return 1;
                  } else if (var0 == 3647) {
                     var7 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize] == 1;
                     if (class463.friendsChat != null) {
                        class463.friendsChat.addComparator(new UserComparator3(var7));
                     }

                     return 1;
                  } else if (var0 == 3648) {
                     var7 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize] == 1;
                     if (class463.friendsChat != null) {
                        class463.friendsChat.addComparator(new UserComparator4(var7));
                     }

                     return 1;
                  } else if (var0 == 3649) {
                     var7 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize] == 1;
                     if (class463.friendsChat != null) {
                        class463.friendsChat.addComparator(new UserComparator5(var7));
                     }

                     return 1;
                  } else if (var0 == 3650) {
                     var7 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize] == 1;
                     if (class463.friendsChat != null) {
                        class463.friendsChat.addComparator(new UserComparator6(var7));
                     }

                     return 1;
                  } else if (var0 == 3651) {
                     var7 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize] == 1;
                     if (class463.friendsChat != null) {
                        class463.friendsChat.addComparator(new UserComparator7(var7));
                     }

                     return 1;
                  } else if (var0 == 3652) {
                     var7 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize] == 1;
                     if (class463.friendsChat != null) {
                        class463.friendsChat.addComparator(new UserComparator8(var7));
                     }

                     return 1;
                  } else if (var0 == 3653) {
                     var7 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize] == 1;
                     if (class463.friendsChat != null) {
                        class463.friendsChat.addComparator(new UserComparator9(var7));
                     }

                     return 1;
                  } else if (var0 == 3654) {
                     var7 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize] == 1;
                     if (class463.friendsChat != null) {
                        class463.friendsChat.addComparator(new UserComparator10(var7));
                     }

                     return 1;
                  } else if (var0 == 3655) {
                     if (class463.friendsChat != null) {
                        class463.friendsChat.sort();
                     }

                     return 1;
                  } else if (var0 == 3656) {
                     var7 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize] == 1;
                     WorldMapElement.friendSystem.friendsList.addComparator(new BuddyRankComparator(var7));
                     return 1;
                  } else if (var0 == 3657) {
                     var7 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize] == 1;
                     if (class463.friendsChat != null) {
                        class463.friendsChat.addComparator(new BuddyRankComparator(var7));
                     }

                     return 1;
                  } else {
                     return 2;
                  }
               }
            } else {
               var3 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize];
               if (class463.friendsChat != null && var3 < class463.friendsChat.getSize() && ((ClanMate)class463.friendsChat.get(var3)).isIgnored()) {
                  Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = 1;
               } else {
                  Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = 0;
               }

               return 1;
            }
         }
      }
   }

   @ObfuscatedName("kn")
   @ObfuscatedSignature(
           descriptor = "([Lkz;II)V",
           garbageValue = "-133105136"
   )
   static final void drawModelComponents(Widget[] var0, int var1) {
      for(int var2 = 0; var2 < var0.length; ++var2) {
         Widget var3 = var0[var2];
         if (var3 != null && var3.parentId == var1 && (!var3.isIf3 || !class160.isComponentHidden(var3))) {
            int var5;
            if (var3.type == 0) {
               if (!var3.isIf3 && class160.isComponentHidden(var3) && var3 != KeyHandler.mousedOverWidgetIf1) {
                  continue;
               }

               drawModelComponents(var0, var3.id);
               if (var3.children != null) {
                  drawModelComponents(var3.children, var3.id);
               }

               InterfaceParent var4 = (InterfaceParent)Client.interfaceParents.get((long)var3.id);
               if (var4 != null) {
                  var5 = var4.group;
                  if (class153.loadInterface(var5)) {
                     drawModelComponents(WorldMapLabel.Widget_interfaceComponents[var5], -1);
                  }
               }
            }

            if (var3.type == 6) {
               if (var3.sequenceId != -1 || var3.sequenceId2 != -1) {
                  boolean var8 = UserComparator5.runCs1(var3);
                  if (var8) {
                     var5 = var3.sequenceId2;
                  } else {
                     var5 = var3.sequenceId;
                  }

                  if (var5 != -1) {
                     SequenceDefinition var6 = class85.SequenceDefinition_get(var5);
                     if (!var6.isCachedModelIdSet()) {
                        for(var3.modelFrameCycle += Client.field442; var3.modelFrameCycle > var6.frameLengths[var3.modelFrame]; LoginScreenAnimation.invalidateWidget(var3)) {
                           var3.modelFrameCycle -= var6.frameLengths[var3.modelFrame];
                           ++var3.modelFrame;
                           if (var3.modelFrame >= var6.frameIds.length) {
                              var3.modelFrame -= var6.frameCount;
                              if (var3.modelFrame < 0 || var3.modelFrame >= var6.frameIds.length) {
                                 var3.modelFrame = 0;
                              }
                           }
                        }
                     } else {
                        var3.modelFrame += Client.field442;
                        int var7 = var6.method1060();
                        if (var3.modelFrame >= var7) {
                           var3.modelFrame -= var6.frameCount;
                           if (var3.modelFrame < 0 || var3.modelFrame >= var7) {
                              var3.modelFrame = 0;
                           }
                        }

                        LoginScreenAnimation.invalidateWidget(var3);
                     }
                  }
               }

               if (var3.rotationKey != 0 && !var3.isIf3) {
                  int var9 = var3.rotationKey >> 16;
                  var5 = var3.rotationKey << 16 >> 16;
                  var9 *= Client.field442;
                  var5 *= Client.field442;
                  var3.modelAngleX = var9 + var3.modelAngleX & 2047;
                  var3.modelAngleY = var5 + var3.modelAngleY & 2047;
                  LoginScreenAnimation.invalidateWidget(var3);
               }
            }
         }
      }

   }
}
