import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ic")
@Implements("WorldMapCacheName")
public class WorldMapCacheName {
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "Lic;"
   )
   public static final WorldMapCacheName field2403 = new WorldMapCacheName("details");
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "Lic;"
   )
   public static final WorldMapCacheName field2399 = new WorldMapCacheName("compositemap");
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "Lic;"
   )
   public static final WorldMapCacheName field2402 = new WorldMapCacheName("compositetexture");
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      descriptor = "Lic;"
   )
   static final WorldMapCacheName field2400 = new WorldMapCacheName("area");
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      descriptor = "Lic;"
   )
   public static final WorldMapCacheName field2398 = new WorldMapCacheName("labels");
   @ObfuscatedName("q")
   public final String name;

   WorldMapCacheName(String var1) {
      this.name = var1;
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      descriptor = "(ILbm;ZI)I",
      garbageValue = "1974028758"
   )
   static int method1468(int var0, Script var1, boolean var2) {
      if (var0 == 3600) {
         if (DefaultsGroup.friendSystem.field670 == 0) {
            Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = -2;
         } else if (DefaultsGroup.friendSystem.field670 == 1) {
            Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = -1;
         } else {
            Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = DefaultsGroup.friendSystem.friendsList.getSize();
         }

         return 1;
      } else {
         int var3;
         if (var0 == 3601) {
            var3 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize];
            if (DefaultsGroup.friendSystem.method407() && var3 >= 0 && var3 < DefaultsGroup.friendSystem.friendsList.getSize()) {
               Friend var8 = (Friend)DefaultsGroup.friendSystem.friendsList.get(var3);
               Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var8.getName();
               Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var8.getPreviousName();
            } else {
               Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
               Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
            }

            return 1;
         } else if (var0 == 3602) {
            var3 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize];
            if (DefaultsGroup.friendSystem.method407() && var3 >= 0 && var3 < DefaultsGroup.friendSystem.friendsList.getSize()) {
               Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = ((Buddy)DefaultsGroup.friendSystem.friendsList.get(var3)).world;
            } else {
               Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = 0;
            }

            return 1;
         } else if (var0 == 3603) {
            var3 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize];
            if (DefaultsGroup.friendSystem.method407() && var3 >= 0 && var3 < DefaultsGroup.friendSystem.friendsList.getSize()) {
               Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = ((Buddy)DefaultsGroup.friendSystem.friendsList.get(var3)).rank;
            } else {
               Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = 0;
            }

            return 1;
         } else {
            String var5;
            if (var0 == 3604) {
               var5 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
               int var6 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize];
               class159.method837(var5, var6);
               return 1;
            } else if (var0 == 3605) {
               var5 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
               DefaultsGroup.friendSystem.addFriend(var5);
               return 1;
            } else if (var0 == 3606) {
               var5 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
               DefaultsGroup.friendSystem.removeFriend(var5);
               return 1;
            } else if (var0 == 3607) {
               var5 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
               DefaultsGroup.friendSystem.addIgnore(var5);
               return 1;
            } else if (var0 == 3608) {
               var5 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
               DefaultsGroup.friendSystem.removeIgnore(var5);
               return 1;
            } else if (var0 == 3609) {
               var5 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
               var5 = class282.method1533(var5);
               Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = DefaultsGroup.friendSystem.isFriended(new Username(var5, SecureRandomFuture.loginType), false) ? 1 : 0;
               return 1;
            } else if (var0 == 3611) {
               if (class281.friendsChat != null) {
                  Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = class281.friendsChat.name;
               } else {
                  Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
               }

               return 1;
            } else if (var0 == 3612) {
               if (class281.friendsChat != null) {
                  Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = class281.friendsChat.getSize();
               } else {
                  Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = 0;
               }

               return 1;
            } else if (var0 == 3613) {
               var3 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize];
               if (class281.friendsChat != null && var3 < class281.friendsChat.getSize()) {
                  Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = class281.friendsChat.get(var3).getUsername().getName();
               } else {
                  Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
               }

               return 1;
            } else if (var0 == 3614) {
               var3 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize];
               if (class281.friendsChat != null && var3 < class281.friendsChat.getSize()) {
                  Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = ((Buddy)class281.friendsChat.get(var3)).getWorld();
               } else {
                  Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = 0;
               }

               return 1;
            } else if (var0 == 3615) {
               var3 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize];
               if (class281.friendsChat != null && var3 < class281.friendsChat.getSize()) {
                  Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = ((Buddy)class281.friendsChat.get(var3)).rank;
               } else {
                  Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = 0;
               }

               return 1;
            } else if (var0 == 3616) {
               Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = class281.friendsChat != null ? class281.friendsChat.minKick : 0;
               return 1;
            } else if (var0 == 3617) {
               var5 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
               ReflectionCheck.clanKickUser(var5);
               return 1;
            } else if (var0 == 3618) {
               Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = class281.friendsChat != null ? class281.friendsChat.rank * -249776335 * 1090208209 : 0;
               return 1;
            } else if (var0 == 3619) {
               var5 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
               Friend.Clan_joinChat(var5);
               return 1;
            } else if (var0 == 3620) {
               class7.Clan_leaveChat();
               return 1;
            } else if (var0 == 3621) {
               if (!DefaultsGroup.friendSystem.method407()) {
                  Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = -1;
               } else {
                  Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = DefaultsGroup.friendSystem.ignoreList.getSize();
               }

               return 1;
            } else if (var0 == 3622) {
               var3 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize];
               if (DefaultsGroup.friendSystem.method407() && var3 >= 0 && var3 < DefaultsGroup.friendSystem.ignoreList.getSize()) {
                  Ignored var4 = (Ignored)DefaultsGroup.friendSystem.ignoreList.get(var3);
                  Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var4.getName();
                  Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var4.getPreviousName();
               } else {
                  Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
                  Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
               }

               return 1;
            } else if (var0 == 3623) {
               var5 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
               var5 = class282.method1533(var5);
               Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = DefaultsGroup.friendSystem.isIgnored(new Username(var5, SecureRandomFuture.loginType)) ? 1 : 0;
               return 1;
            } else if (var0 == 3624) {
               var3 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize];
               if (class281.friendsChat != null && var3 < class281.friendsChat.getSize() && class281.friendsChat.get(var3).getUsername().equals(class155.localPlayer.username)) {
                  Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = 1;
               } else {
                  Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = 0;
               }

               return 1;
            } else if (var0 == 3625) {
               if (class281.friendsChat != null && class281.friendsChat.owner != null) {
                  Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = class281.friendsChat.owner;
               } else {
                  Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
               }

               return 1;
            } else if (var0 == 3626) {
               var3 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize];
               if (class281.friendsChat != null && var3 < class281.friendsChat.getSize() && ((ClanMate)class281.friendsChat.get(var3)).isFriend()) {
                  Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = 1;
               } else {
                  Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = 0;
               }

               return 1;
            } else if (var0 != 3627) {
               if (var0 == 3628) {
                  DefaultsGroup.friendSystem.friendsList.removeComparator();
                  return 1;
               } else {
                  boolean var7;
                  if (var0 == 3629) {
                     var7 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize] == 1;
                     DefaultsGroup.friendSystem.friendsList.addComparator(new UserComparator1(var7));
                     return 1;
                  } else if (var0 == 3630) {
                     var7 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize] == 1;
                     DefaultsGroup.friendSystem.friendsList.addComparator(new UserComparator2(var7));
                     return 1;
                  } else if (var0 == 3631) {
                     var7 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize] == 1;
                     DefaultsGroup.friendSystem.friendsList.addComparator(new UserComparator3(var7));
                     return 1;
                  } else if (var0 == 3632) {
                     var7 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize] == 1;
                     DefaultsGroup.friendSystem.friendsList.addComparator(new UserComparator4(var7));
                     return 1;
                  } else if (var0 == 3633) {
                     var7 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize] == 1;
                     DefaultsGroup.friendSystem.friendsList.addComparator(new UserComparator5(var7));
                     return 1;
                  } else if (var0 == 3634) {
                     var7 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize] == 1;
                     DefaultsGroup.friendSystem.friendsList.addComparator(new UserComparator6(var7));
                     return 1;
                  } else if (var0 == 3635) {
                     var7 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize] == 1;
                     DefaultsGroup.friendSystem.friendsList.addComparator(new UserComparator7(var7));
                     return 1;
                  } else if (var0 == 3636) {
                     var7 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize] == 1;
                     DefaultsGroup.friendSystem.friendsList.addComparator(new UserComparator8(var7));
                     return 1;
                  } else if (var0 == 3637) {
                     var7 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize] == 1;
                     DefaultsGroup.friendSystem.friendsList.addComparator(new UserComparator9(var7));
                     return 1;
                  } else if (var0 == 3638) {
                     var7 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize] == 1;
                     DefaultsGroup.friendSystem.friendsList.addComparator(new UserComparator10(var7));
                     return 1;
                  } else if (var0 == 3639) {
                     DefaultsGroup.friendSystem.friendsList.sort();
                     return 1;
                  } else if (var0 == 3640) {
                     DefaultsGroup.friendSystem.ignoreList.removeComparator();
                     return 1;
                  } else if (var0 == 3641) {
                     var7 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize] == 1;
                     DefaultsGroup.friendSystem.ignoreList.addComparator(new UserComparator1(var7));
                     return 1;
                  } else if (var0 == 3642) {
                     var7 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize] == 1;
                     DefaultsGroup.friendSystem.ignoreList.addComparator(new UserComparator2(var7));
                     return 1;
                  } else if (var0 == 3643) {
                     DefaultsGroup.friendSystem.ignoreList.sort();
                     return 1;
                  } else if (var0 == 3644) {
                     if (class281.friendsChat != null) {
                        class281.friendsChat.removeComparator();
                     }

                     return 1;
                  } else if (var0 == 3645) {
                     var7 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize] == 1;
                     if (class281.friendsChat != null) {
                        class281.friendsChat.addComparator(new UserComparator1(var7));
                     }

                     return 1;
                  } else if (var0 == 3646) {
                     var7 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize] == 1;
                     if (class281.friendsChat != null) {
                        class281.friendsChat.addComparator(new UserComparator2(var7));
                     }

                     return 1;
                  } else if (var0 == 3647) {
                     var7 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize] == 1;
                     if (class281.friendsChat != null) {
                        class281.friendsChat.addComparator(new UserComparator3(var7));
                     }

                     return 1;
                  } else if (var0 == 3648) {
                     var7 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize] == 1;
                     if (class281.friendsChat != null) {
                        class281.friendsChat.addComparator(new UserComparator4(var7));
                     }

                     return 1;
                  } else if (var0 == 3649) {
                     var7 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize] == 1;
                     if (class281.friendsChat != null) {
                        class281.friendsChat.addComparator(new UserComparator5(var7));
                     }

                     return 1;
                  } else if (var0 == 3650) {
                     var7 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize] == 1;
                     if (class281.friendsChat != null) {
                        class281.friendsChat.addComparator(new UserComparator6(var7));
                     }

                     return 1;
                  } else if (var0 == 3651) {
                     var7 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize] == 1;
                     if (class281.friendsChat != null) {
                        class281.friendsChat.addComparator(new UserComparator7(var7));
                     }

                     return 1;
                  } else if (var0 == 3652) {
                     var7 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize] == 1;
                     if (class281.friendsChat != null) {
                        class281.friendsChat.addComparator(new UserComparator8(var7));
                     }

                     return 1;
                  } else if (var0 == 3653) {
                     var7 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize] == 1;
                     if (class281.friendsChat != null) {
                        class281.friendsChat.addComparator(new UserComparator9(var7));
                     }

                     return 1;
                  } else if (var0 == 3654) {
                     var7 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize] == 1;
                     if (class281.friendsChat != null) {
                        class281.friendsChat.addComparator(new UserComparator10(var7));
                     }

                     return 1;
                  } else if (var0 == 3655) {
                     if (class281.friendsChat != null) {
                        class281.friendsChat.sort();
                     }

                     return 1;
                  } else if (var0 == 3656) {
                     var7 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize] == 1;
                     DefaultsGroup.friendSystem.friendsList.addComparator(new BuddyRankComparator(var7));
                     return 1;
                  } else if (var0 == 3657) {
                     var7 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize] == 1;
                     if (class281.friendsChat != null) {
                        class281.friendsChat.addComparator(new BuddyRankComparator(var7));
                     }

                     return 1;
                  } else {
                     return 2;
                  }
               }
            } else {
               var3 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize];
               if (class281.friendsChat != null && var3 < class281.friendsChat.getSize() && ((ClanMate)class281.friendsChat.get(var3)).isIgnored()) {
                  Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = 1;
               } else {
                  Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = 0;
               }

               return 1;
            }
         }
      }
   }

   @ObfuscatedName("ba")
   @ObfuscatedSignature(
      descriptor = "([BI)[B",
      garbageValue = "-606090063"
   )
   static final byte[] decompressBytes(byte[] var0) {
      Buffer var1 = new Buffer(var0);
      int var2 = var1.readUnsignedByte();
      int var3 = var1.readInt();
      if (var3 >= 0 && (AbstractArchive.maximumContainerSize == 0 || var3 <= AbstractArchive.maximumContainerSize)) {
         if (var2 == 0) {
            byte[] var4 = new byte[var3];
            var1.readBytes(var4, 0, var3);
            return var4;
         } else {
            int var6 = var1.readInt();
            if (var6 < 0 || AbstractArchive.maximumContainerSize != 0 && var6 > AbstractArchive.maximumContainerSize) {
               throw new RuntimeException();
            } else {
               byte[] var5 = new byte[var6];
               if (var2 == 1) {
                  BZip2Decompressor.BZip2Decompressor_decompress(var5, var6, var0, var3, 9);
               } else {
                  AbstractArchive.gzipDecompressor.decompress(var1, var5);
               }

               return var5;
            }
         }
      } else {
         throw new RuntimeException();
      }
   }
}
