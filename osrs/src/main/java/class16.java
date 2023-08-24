import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

@ObfuscatedName("ag")
public class class16 implements ThreadFactory {
	@ObfuscatedName("au")
	final ThreadGroup field48;
	@ObfuscatedName("ae")
	final AtomicInteger field49;
	// $FF: synthetic field
	@ObfuscatedSignature(
		descriptor = "Lar;"
	)
	@Export("this$0")
	@ObfuscatedName("this$0")
	final class14 this$0;

	@ObfuscatedSignature(
		descriptor = "(Lar;)V"
	)
	class16(class14 var1) {
		this.this$0 = var1;
		this.field49 = new AtomicInteger(1);
		SecurityManager var2 = System.getSecurityManager();
		this.field48 = var2 != null ? var2.getThreadGroup() : Thread.currentThread().getThreadGroup();
	}

	@Export("newThread")
	@ObfuscatedName("newThread")
	public Thread newThread(Runnable var1) {
		Thread var2 = new Thread(this.field48, var1, this.this$0.field43 + "-rest-request-" + this.field49.getAndIncrement(), 0L);
		var2.setDaemon(true);
		var2.setPriority(5);
		return var2;
	}

	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "(II)I",
		garbageValue = "-192145795"
	)
	@Export("iLog")
	public static int iLog(int var0) {
		int var1 = 0;
		if (var0 < 0 || var0 >= 65536) {
			var0 >>>= 16;
			var1 += 16;
		}

		if (var0 >= 256) {
			var0 >>>= 8;
			var1 += 8;
		}

		if (var0 >= 16) {
			var0 >>>= 4;
			var1 += 4;
		}

		if (var0 >= 4) {
			var0 >>>= 2;
			var1 += 2;
		}

		if (var0 >= 1) {
			var0 >>>= 1;
			++var1;
		}

		return var0 + var1;
	}

	@ObfuscatedName("bv")
	@ObfuscatedSignature(
		descriptor = "(ILdh;ZB)I",
		garbageValue = "2"
	)
	static int method48(int var0, Script var1, boolean var2) {
		if (var0 == 3600) {
			if (class299.friendSystem.friendListStatus == 0) {
				Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = -2;
			} else if (class299.friendSystem.friendListStatus == 1) {
				Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = -1;
			} else {
				Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = class299.friendSystem.friendsList.getSize();
			}

			return 1;
		} else {
			int var3;
			if (var0 == 3601) {
				var3 = Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize];
				if (class299.friendSystem.method398() && var3 >= 0 && var3 < class299.friendSystem.friendsList.getSize()) {
					Friend var8 = (Friend)class299.friendSystem.friendsList.get(var3);
					Interpreter.Interpreter_stringStack[++class137.Interpreter_stringStackSize - 1] = var8.getName();
					Interpreter.Interpreter_stringStack[++class137.Interpreter_stringStackSize - 1] = var8.getPreviousName();
				} else {
					Interpreter.Interpreter_stringStack[++class137.Interpreter_stringStackSize - 1] = "";
					Interpreter.Interpreter_stringStack[++class137.Interpreter_stringStackSize - 1] = "";
				}

				return 1;
			} else if (var0 == 3602) {
				var3 = Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize];
				if (class299.friendSystem.method398() && var3 >= 0 && var3 < class299.friendSystem.friendsList.getSize()) {
					Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = ((Buddy)class299.friendSystem.friendsList.get(var3)).world;
				} else {
					Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = 0;
				}

				return 1;
			} else if (var0 == 3603) {
				var3 = Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize];
				if (class299.friendSystem.method398() && var3 >= 0 && var3 < class299.friendSystem.friendsList.getSize()) {
					Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = ((Buddy)class299.friendSystem.friendsList.get(var3)).rank;
				} else {
					Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = 0;
				}

				return 1;
			} else {
				String var5;
				if (var0 == 3604) {
					var5 = Interpreter.Interpreter_stringStack[--class137.Interpreter_stringStackSize];
					int var9 = Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize];
					class161.setFriendsRank(var5, var9);
					return 1;
				} else if (var0 == 3605) {
					var5 = Interpreter.Interpreter_stringStack[--class137.Interpreter_stringStackSize];
					class299.friendSystem.addFriend(var5);
					return 1;
				} else if (var0 == 3606) {
					var5 = Interpreter.Interpreter_stringStack[--class137.Interpreter_stringStackSize];
					class299.friendSystem.removeFriend(var5);
					return 1;
				} else if (var0 == 3607) {
					var5 = Interpreter.Interpreter_stringStack[--class137.Interpreter_stringStackSize];
					class299.friendSystem.addIgnore(var5);
					return 1;
				} else if (var0 == 3608) {
					var5 = Interpreter.Interpreter_stringStack[--class137.Interpreter_stringStackSize];
					boolean var6 = true;
					class299.friendSystem.removeIgnore(var5, var6);
					return 1;
				} else if (var0 == 3609) {
					var5 = Interpreter.Interpreter_stringStack[--class137.Interpreter_stringStackSize];
					var5 = ObjTypeCustomisation.method936(var5);
					Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = class299.friendSystem.isFriended(new Username(var5, Language.loginType), false) ? 1 : 0;
					return 1;
				} else if (var0 == 3611) {
					if (ReflectionCheck.friendsChat != null) {
						Interpreter.Interpreter_stringStack[++class137.Interpreter_stringStackSize - 1] = ReflectionCheck.friendsChat.name;
					} else {
						Interpreter.Interpreter_stringStack[++class137.Interpreter_stringStackSize - 1] = "";
					}

					return 1;
				} else if (var0 == 3612) {
					if (ReflectionCheck.friendsChat != null) {
						Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = ReflectionCheck.friendsChat.getSize();
					} else {
						Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = 0;
					}

					return 1;
				} else if (var0 == 3613) {
					var3 = Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize];
					if (ReflectionCheck.friendsChat != null && var3 < ReflectionCheck.friendsChat.getSize()) {
						Interpreter.Interpreter_stringStack[++class137.Interpreter_stringStackSize - 1] = ReflectionCheck.friendsChat.get(var3).getUsername().getName();
					} else {
						Interpreter.Interpreter_stringStack[++class137.Interpreter_stringStackSize - 1] = "";
					}

					return 1;
				} else if (var0 == 3614) {
					var3 = Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize];
					if (ReflectionCheck.friendsChat != null && var3 < ReflectionCheck.friendsChat.getSize()) {
						Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = ((Buddy)ReflectionCheck.friendsChat.get(var3)).getWorld();
					} else {
						Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = 0;
					}

					return 1;
				} else if (var0 == 3615) {
					var3 = Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize];
					if (ReflectionCheck.friendsChat != null && var3 < ReflectionCheck.friendsChat.getSize()) {
						Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = ((Buddy)ReflectionCheck.friendsChat.get(var3)).rank;
					} else {
						Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = 0;
					}

					return 1;
				} else if (var0 == 3616) {
					Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = ReflectionCheck.friendsChat != null ? ReflectionCheck.friendsChat.minKick : 0;
					return 1;
				} else if (var0 == 3617) {
					var5 = Interpreter.Interpreter_stringStack[--class137.Interpreter_stringStackSize];
					class131.clanKickUser(var5);
					return 1;
				} else if (var0 == 3618) {
					Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = ReflectionCheck.friendsChat != null ? ReflectionCheck.friendsChat.rank * 1868713607 * 106239799 : 0;
					return 1;
				} else if (var0 == 3619) {
					var5 = Interpreter.Interpreter_stringStack[--class137.Interpreter_stringStackSize];
					UrlRequester.Clan_joinChat(var5);
					return 1;
				} else if (var0 == 3620) {
					Player.Clan_leaveChat();
					return 1;
				} else if (var0 == 3621) {
					if (!class299.friendSystem.method398()) {
						Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = -1;
					} else {
						Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = class299.friendSystem.ignoreList.getSize();
					}

					return 1;
				} else if (var0 == 3622) {
					var3 = Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize];
					if (class299.friendSystem.method398() && var3 >= 0 && var3 < class299.friendSystem.ignoreList.getSize()) {
						Ignored var4 = (Ignored)class299.friendSystem.ignoreList.get(var3);
						Interpreter.Interpreter_stringStack[++class137.Interpreter_stringStackSize - 1] = var4.getName();
						Interpreter.Interpreter_stringStack[++class137.Interpreter_stringStackSize - 1] = var4.getPreviousName();
					} else {
						Interpreter.Interpreter_stringStack[++class137.Interpreter_stringStackSize - 1] = "";
						Interpreter.Interpreter_stringStack[++class137.Interpreter_stringStackSize - 1] = "";
					}

					return 1;
				} else if (var0 == 3623) {
					var5 = Interpreter.Interpreter_stringStack[--class137.Interpreter_stringStackSize];
					var5 = ObjTypeCustomisation.method936(var5);
					Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = class299.friendSystem.isIgnored(new Username(var5, Language.loginType)) ? 1 : 0;
					return 1;
				} else if (var0 == 3624) {
					var3 = Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize];
					if (ReflectionCheck.friendsChat != null && var3 < ReflectionCheck.friendsChat.getSize() && ReflectionCheck.friendsChat.get(var3).getUsername().equals(VarbitComposition.localPlayer.username)) {
						Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = 1;
					} else {
						Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = 0;
					}

					return 1;
				} else if (var0 == 3625) {
					if (ReflectionCheck.friendsChat != null && ReflectionCheck.friendsChat.owner != null) {
						Interpreter.Interpreter_stringStack[++class137.Interpreter_stringStackSize - 1] = ReflectionCheck.friendsChat.owner;
					} else {
						Interpreter.Interpreter_stringStack[++class137.Interpreter_stringStackSize - 1] = "";
					}

					return 1;
				} else if (var0 == 3626) {
					var3 = Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize];
					if (ReflectionCheck.friendsChat != null && var3 < ReflectionCheck.friendsChat.getSize() && ((ClanMate)ReflectionCheck.friendsChat.get(var3)).isFriend()) {
						Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = 1;
					} else {
						Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = 0;
					}

					return 1;
				} else if (var0 != 3627) {
					if (var0 == 3628) {
						class299.friendSystem.friendsList.removeComparator();
						return 1;
					} else {
						boolean var7;
						if (var0 == 3629) {
							var7 = Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize] == 1;
							class299.friendSystem.friendsList.addComparator(new UserComparator1(var7));
							return 1;
						} else if (var0 == 3630) {
							var7 = Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize] == 1;
							class299.friendSystem.friendsList.addComparator(new UserComparator2(var7));
							return 1;
						} else if (var0 == 3631) {
							var7 = Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize] == 1;
							class299.friendSystem.friendsList.addComparator(new UserComparator3(var7));
							return 1;
						} else if (var0 == 3632) {
							var7 = Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize] == 1;
							class299.friendSystem.friendsList.addComparator(new UserComparator4(var7));
							return 1;
						} else if (var0 == 3633) {
							var7 = Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize] == 1;
							class299.friendSystem.friendsList.addComparator(new UserComparator5(var7));
							return 1;
						} else if (var0 == 3634) {
							var7 = Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize] == 1;
							class299.friendSystem.friendsList.addComparator(new UserComparator6(var7));
							return 1;
						} else if (var0 == 3635) {
							var7 = Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize] == 1;
							class299.friendSystem.friendsList.addComparator(new UserComparator7(var7));
							return 1;
						} else if (var0 == 3636) {
							var7 = Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize] == 1;
							class299.friendSystem.friendsList.addComparator(new UserComparator8(var7));
							return 1;
						} else if (var0 == 3637) {
							var7 = Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize] == 1;
							class299.friendSystem.friendsList.addComparator(new UserComparator9(var7));
							return 1;
						} else if (var0 == 3638) {
							var7 = Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize] == 1;
							class299.friendSystem.friendsList.addComparator(new UserComparator10(var7));
							return 1;
						} else if (var0 == 3639) {
							class299.friendSystem.friendsList.sort();
							return 1;
						} else if (var0 == 3640) {
							class299.friendSystem.ignoreList.removeComparator();
							return 1;
						} else if (var0 == 3641) {
							var7 = Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize] == 1;
							class299.friendSystem.ignoreList.addComparator(new UserComparator1(var7));
							return 1;
						} else if (var0 == 3642) {
							var7 = Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize] == 1;
							class299.friendSystem.ignoreList.addComparator(new UserComparator2(var7));
							return 1;
						} else if (var0 == 3643) {
							class299.friendSystem.ignoreList.sort();
							return 1;
						} else if (var0 == 3644) {
							if (ReflectionCheck.friendsChat != null) {
								ReflectionCheck.friendsChat.removeComparator();
							}

							return 1;
						} else if (var0 == 3645) {
							var7 = Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize] == 1;
							if (ReflectionCheck.friendsChat != null) {
								ReflectionCheck.friendsChat.addComparator(new UserComparator1(var7));
							}

							return 1;
						} else if (var0 == 3646) {
							var7 = Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize] == 1;
							if (ReflectionCheck.friendsChat != null) {
								ReflectionCheck.friendsChat.addComparator(new UserComparator2(var7));
							}

							return 1;
						} else if (var0 == 3647) {
							var7 = Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize] == 1;
							if (ReflectionCheck.friendsChat != null) {
								ReflectionCheck.friendsChat.addComparator(new UserComparator3(var7));
							}

							return 1;
						} else if (var0 == 3648) {
							var7 = Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize] == 1;
							if (ReflectionCheck.friendsChat != null) {
								ReflectionCheck.friendsChat.addComparator(new UserComparator4(var7));
							}

							return 1;
						} else if (var0 == 3649) {
							var7 = Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize] == 1;
							if (ReflectionCheck.friendsChat != null) {
								ReflectionCheck.friendsChat.addComparator(new UserComparator5(var7));
							}

							return 1;
						} else if (var0 == 3650) {
							var7 = Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize] == 1;
							if (ReflectionCheck.friendsChat != null) {
								ReflectionCheck.friendsChat.addComparator(new UserComparator6(var7));
							}

							return 1;
						} else if (var0 == 3651) {
							var7 = Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize] == 1;
							if (ReflectionCheck.friendsChat != null) {
								ReflectionCheck.friendsChat.addComparator(new UserComparator7(var7));
							}

							return 1;
						} else if (var0 == 3652) {
							var7 = Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize] == 1;
							if (ReflectionCheck.friendsChat != null) {
								ReflectionCheck.friendsChat.addComparator(new UserComparator8(var7));
							}

							return 1;
						} else if (var0 == 3653) {
							var7 = Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize] == 1;
							if (ReflectionCheck.friendsChat != null) {
								ReflectionCheck.friendsChat.addComparator(new UserComparator9(var7));
							}

							return 1;
						} else if (var0 == 3654) {
							var7 = Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize] == 1;
							if (ReflectionCheck.friendsChat != null) {
								ReflectionCheck.friendsChat.addComparator(new UserComparator10(var7));
							}

							return 1;
						} else if (var0 == 3655) {
							if (ReflectionCheck.friendsChat != null) {
								ReflectionCheck.friendsChat.sort();
							}

							return 1;
						} else if (var0 == 3656) {
							var7 = Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize] == 1;
							class299.friendSystem.friendsList.addComparator(new BuddyRankComparator(var7));
							return 1;
						} else if (var0 == 3657) {
							var7 = Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize] == 1;
							if (ReflectionCheck.friendsChat != null) {
								ReflectionCheck.friendsChat.addComparator(new BuddyRankComparator(var7));
							}

							return 1;
						} else {
							return 2;
						}
					}
				} else {
					var3 = Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize];
					if (ReflectionCheck.friendsChat != null && var3 < ReflectionCheck.friendsChat.getSize() && ((ClanMate)ReflectionCheck.friendsChat.get(var3)).isIgnored()) {
						Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = 1;
					} else {
						Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = 0;
					}

					return 1;
				}
			}
		}
	}
}