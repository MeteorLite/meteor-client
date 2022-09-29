import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("mj")
@Implements("ByteArrayPool")
public class ByteArrayPool {
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = 990985137
	)
	@Export("ByteArrayPool_smallCount")
	static int ByteArrayPool_smallCount;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = -38943471
	)
	@Export("ByteArrayPool_mediumCount")
	static int ByteArrayPool_mediumCount;
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = 285552363
	)
	@Export("ByteArrayPool_largeCount")
	static int ByteArrayPool_largeCount;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = -1008615281
	)
	static int field4250;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = 1069808971
	)
	static int field4251;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = -1833319861
	)
	static int field4252;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = 1710772269
	)
	static int field4253;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = 1226776487
	)
	static int field4254;
	@ObfuscatedName("h")
	@Export("ByteArrayPool_small")
	static byte[][] ByteArrayPool_small;
	@ObfuscatedName("t")
	@Export("ByteArrayPool_medium")
	static byte[][] ByteArrayPool_medium;
	@ObfuscatedName("u")
	@Export("ByteArrayPool_large")
	static byte[][] ByteArrayPool_large;
	@ObfuscatedName("d")
	static byte[][] field4245;
	@ObfuscatedName("e")
	static ArrayList field4259;

	static {
		ByteArrayPool_smallCount = 0;
		ByteArrayPool_mediumCount = 0;
		ByteArrayPool_largeCount = 0;
		field4250 = 0;
		field4251 = 1000;
		field4252 = 250;
		field4253 = 100;
		field4254 = 50;
		ByteArrayPool_small = new byte[1000][];
		ByteArrayPool_medium = new byte[250][];
		ByteArrayPool_large = new byte[100][];
		field4245 = new byte[50][];
		field4259 = new ArrayList();
		FriendSystem.method1807();
		new HashMap();
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		descriptor = "(IZI)[B",
		garbageValue = "938167543"
	)
	@Export("ByteArrayPool_getArrayBool")
	static synchronized byte[] ByteArrayPool_getArrayBool(int var0, boolean var1) {
		byte[] var4;
		if (var0 != 100) {
			if (var0 < 100) {
			}
		} else if (ByteArrayPool_smallCount > 0) {
			var4 = ByteArrayPool_small[--ByteArrayPool_smallCount];
			ByteArrayPool_small[ByteArrayPool_smallCount] = null;
			return var4;
		}

		if (var0 != 5000) {
			if (var0 < 5000) {
			}
		} else if (ByteArrayPool_mediumCount > 0) {
			var4 = ByteArrayPool_medium[--ByteArrayPool_mediumCount];
			ByteArrayPool_medium[ByteArrayPool_mediumCount] = null;
			return var4;
		}

		if (var0 != 10000) {
			if (var0 < 10000) {
			}
		} else if (ByteArrayPool_largeCount > 0) {
			var4 = ByteArrayPool_large[--ByteArrayPool_largeCount];
			ByteArrayPool_large[ByteArrayPool_largeCount] = null;
			return var4;
		}

		if (var0 != 30000) {
			if (var0 < 30000) {
			}
		} else if (field4250 > 0) {
			var4 = field4245[--field4250];
			field4245[field4250] = null;
			return var4;
		}

		if (UrlRequest.ByteArrayPool_arrays != null) {
			for (int var2 = 0; var2 < ArchiveDiskActionHandler.ByteArrayPool_alternativeSizes.length; ++var2) {
				if (ArchiveDiskActionHandler.ByteArrayPool_alternativeSizes[var2] != var0) {
					if (var0 < ArchiveDiskActionHandler.ByteArrayPool_alternativeSizes[var2]) {
					}
				} else if (class137.ByteArrayPool_altSizeArrayCounts[var2] > 0) {
					byte[] var3 = UrlRequest.ByteArrayPool_arrays[var2][--class137.ByteArrayPool_altSizeArrayCounts[var2]];
					UrlRequest.ByteArrayPool_arrays[var2][class137.ByteArrayPool_altSizeArrayCounts[var2]] = null;
					return var3;
				}
			}
		}

		return new byte[var0];
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		descriptor = "(Lai;Lmv;I)V",
		garbageValue = "1971727150"
	)
	@Export("loginScreen")
	static void loginScreen(GameEngine var0, Font var1) {
		if (Login.worldSelectOpen) {
			ClanChannelMember.method3026(var0);
		} else {
			if ((MouseHandler.MouseHandler_lastButton == 1 || !Renderable.mouseCam && MouseHandler.MouseHandler_lastButton == 4) && MouseHandler.MouseHandler_lastPressedX >= Login.xPadding + 765 - 50 && MouseHandler.MouseHandler_lastPressedY >= 453) {
				Player.clientPreferences.method2392(!Player.clientPreferences.method2393());
				if (!Player.clientPreferences.method2393()) {
					Archive var2 = class14.archive6;
					int var3 = var2.getGroupId("scape main");
					int var4 = var2.getFileId(var3, "");
					Message.method1164(var2, var3, var4, 255, false);
				} else {
					class17.method267();
				}
			}

			if (Client.gameState != 5) {
				if (-1L == Login.field924) {
					Login.field924 = Language.method6232() + 1000L;
				}

				long var22 = Language.method6232();
				boolean var37;
				if (Client.archiveLoaders != null && Client.archiveLoadersDone < Client.archiveLoaders.size()) {
					while (true) {
						if (Client.archiveLoadersDone >= Client.archiveLoaders.size()) {
							var37 = true;
							break;
						}

						ArchiveLoader var5 = (ArchiveLoader)Client.archiveLoaders.get(Client.archiveLoadersDone);
						if (!var5.isLoaded()) {
							var37 = false;
							break;
						}

						++Client.archiveLoadersDone;
					}
				} else {
					var37 = true;
				}

				if (var37 && -1L == Login.field918) {
					Login.field918 = var22;
					if (Login.field918 > Login.field924) {
						Login.field924 = Login.field918;
					}
				}

				if (Client.gameState == 10 || Client.gameState == 11) {
					int var24;
					if (Language.Language_EN == class271.clientLanguage) {
						if (MouseHandler.MouseHandler_lastButton == 1 || !Renderable.mouseCam && MouseHandler.MouseHandler_lastButton == 4) {
							var24 = Login.xPadding + 5;
							short var6 = 463;
							byte var7 = 100;
							byte var8 = 35;
							if (MouseHandler.MouseHandler_lastPressedX >= var24 && MouseHandler.MouseHandler_lastPressedX <= var24 + var7 && MouseHandler.MouseHandler_lastPressedY >= var6 && MouseHandler.MouseHandler_lastPressedY <= var8 + var6) {
								if (UserComparator9.loadWorlds()) {
									Login.worldSelectOpen = true;
									Login.worldSelectPage = 0;
									Login.worldSelectPagesCount = 0;
								}

								return;
							}
						}

						if (Frames.World_request != null && UserComparator9.loadWorlds()) {
							Login.worldSelectOpen = true;
							Login.worldSelectPage = 0;
							Login.worldSelectPagesCount = 0;
						}
					}

					var24 = MouseHandler.MouseHandler_lastButton;
					int var38 = MouseHandler.MouseHandler_lastPressedX;
					int var39 = MouseHandler.MouseHandler_lastPressedY;
					if (var24 == 0) {
						var38 = MouseHandler.MouseHandler_x;
						var39 = MouseHandler.MouseHandler_y;
					}

					if (!Renderable.mouseCam && var24 == 4) {
						var24 = 1;
					}

					int var42;
					short var43;
					if (Login.loginIndex == 0) {
						boolean var50 = false;

						while (class28.isKeyDown()) {
							if (class142.field1665 == 84) {
								var50 = true;
							}
						}

						var42 = ModeWhere.loginBoxCenter - 80;
						var43 = 291;
						if (var24 == 1 && var38 >= var42 - 75 && var38 <= var42 + 75 && var39 >= var43 - 20 && var39 <= var43 + 20) {
							CollisionMap.openURL(SecureRandomCallable.method2205("secure", true) + "m=account-creation/g=oldscape/create_account_funnel.ws", true, false);
						}

						var42 = ModeWhere.loginBoxCenter + 80;
						if (var24 == 1 && var38 >= var42 - 75 && var38 <= var42 + 75 && var39 >= var43 - 20 && var39 <= var43 + 20 || var50) {
							if ((Client.worldProperties & 33554432) != 0) {
								Login.Login_response0 = "";
								Login.Login_response1 = "This is a <col=00ffff>Beta<col=ffffff> world.";
								Login.Login_response2 = "Your normal account will not be affected.";
								Login.Login_response3 = "";
								class139.method3101(1);
								class65.method2029();
							} else if ((Client.worldProperties & 4) != 0) {
								if ((Client.worldProperties & 1024) != 0) {
									Login.Login_response1 = "This is a <col=ffff00>High Risk <col=ff0000>PvP<col=ffffff> world.";
									Login.Login_response2 = "Players can attack each other almost everywhere";
									Login.Login_response3 = "and the Protect Item prayer won't work.";
								} else {
									Login.Login_response1 = "This is a <col=ff0000>PvP<col=ffffff> world.";
									Login.Login_response2 = "Players can attack each other";
									Login.Login_response3 = "almost everywhere.";
								}

								Login.Login_response0 = "Warning!";
								class139.method3101(1);
								class65.method2029();
							} else if ((Client.worldProperties & 1024) != 0) {
								Login.Login_response1 = "This is a <col=ffff00>High Risk<col=ffffff> world.";
								Login.Login_response2 = "The Protect Item prayer will";
								Login.Login_response3 = "not work on this world.";
								Login.Login_response0 = "Warning!";
								class139.method3101(1);
								class65.method2029();
							} else {
								Calendar.Login_promptCredentials(false);
							}
						}
					} else {
						short var9;
						int var40;
						if (Login.loginIndex == 1) {
							while (true) {
								if (!class28.isKeyDown()) {
									var40 = ModeWhere.loginBoxCenter - 80;
									var9 = 321;
									if (var24 == 1 && var38 >= var40 - 75 && var38 <= var40 + 75 && var39 >= var9 - 20 && var39 <= var9 + 20) {
										Calendar.Login_promptCredentials(false);
									}

									var40 = ModeWhere.loginBoxCenter + 80;
									if (var24 == 1 && var38 >= var40 - 75 && var38 <= var40 + 75 && var39 >= var9 - 20 && var39 <= var9 + 20) {
										class139.method3101(0);
									}
									break;
								}

								if (class142.field1665 == 84) {
									Calendar.Login_promptCredentials(false);
								} else if (class142.field1665 == 13) {
									class139.method3101(0);
								}
							}
						} else {
							int var12;
							short var41;
							boolean var45;
							if (Login.loginIndex == 2) {
								var41 = 201;
								var40 = var41 + 52;
								if (var24 == 1 && var39 >= var40 - 12 && var39 < var40 + 2) {
									Login.currentLoginField = 0;
								}

								var40 += 15;
								if (var24 == 1 && var39 >= var40 - 12 && var39 < var40 + 2) {
									Login.currentLoginField = 1;
								}

								var40 += 15;
								var41 = 361;
								if (class269.field3195 != null) {
									var42 = class269.field3195.highX / 2;
									if (var24 == 1 && var38 >= class269.field3195.lowX - var42 && var38 <= var42 + class269.field3195.lowX && var39 >= var41 - 15 && var39 < var41) {
										switch(Login.field903) {
										case 1:
											SecureRandomCallable.setLoginResponseString("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
											class139.method3101(5);
											return;
										case 2:
											CollisionMap.openURL("https://support.runescape.com/hc/en-gb", true, false);
										}
									}
								}

								var42 = ModeWhere.loginBoxCenter - 80;
								var43 = 321;
								if (var24 == 1 && var38 >= var42 - 75 && var38 <= var42 + 75 && var39 >= var43 - 20 && var39 <= var43 + 20) {
									Login.Login_username = Login.Login_username.trim();
									if (Login.Login_username.length() == 0) {
										SecureRandomCallable.setLoginResponseString("", "Please enter your username/email address.", "");
										return;
									}

									if (Login.Login_password.length() == 0) {
										SecureRandomCallable.setLoginResponseString("", "Please enter your password.", "");
										return;
									}

									SecureRandomCallable.setLoginResponseString("", "Connecting to server...", "");
									PacketWriter.method2673(false);
									Coord.updateGameState(20);
									return;
								}

								var42 = Login.loginBoxX + 180 + 80;
								if (var24 == 1 && var38 >= var42 - 75 && var38 <= var42 + 75 && var39 >= var43 - 20 && var39 <= var43 + 20) {
									class139.method3101(0);
									Login.Login_username = "";
									Login.Login_password = "";
									class347.field4201 = 0;
									class28.otp = "";
									Login.field916 = true;
								}

								var42 = ModeWhere.loginBoxCenter + -117;
								var43 = 277;
								Login.field925 = var38 >= var42 && var38 < var42 + ReflectionCheck.field256 && var39 >= var43 && var39 < var43 + WorldMapID.field2874;
								if (var24 == 1 && Login.field925) {
									Client.Login_isUsernameRemembered = !Client.Login_isUsernameRemembered;
									if (!Client.Login_isUsernameRemembered && Player.clientPreferences.method2407() != null) {
										Player.clientPreferences.method2406((String)null);
									}
								}

								var42 = ModeWhere.loginBoxCenter + 24;
								var43 = 277;
								Login.field920 = var38 >= var42 && var38 < var42 + ReflectionCheck.field256 && var39 >= var43 && var39 < var43 + WorldMapID.field2874;
								if (var24 == 1 && Login.field920) {
									Player.clientPreferences.method2390(!Player.clientPreferences.method2397());
									if (!Player.clientPreferences.method2397()) {
										Login.Login_username = "";
										Player.clientPreferences.method2406((String)null);
										class65.method2029();
									}
								}

								while (true) {
									int var47;
									Transferable var52;
									do {
										while (true) {
											label1266:
											do {
												while (true) {
													while (class28.isKeyDown()) {
														if (class142.field1665 != 13) {
															if (Login.currentLoginField != 0) {
																continue label1266;
															}

															char var46 = class229.field2794;

															for (var12 = 0; var12 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"ï¿½$%^&*()-_=+[{]};:'@#~,<.>/?\\| ".length() && var46 != "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"ï¿½$%^&*()-_=+[{]};:'@#~,<.>/?\\| ".charAt(var12); ++var12) {
															}

															if (class142.field1665 == 85 && Login.Login_username.length() > 0) {
																Login.Login_username = Login.Login_username.substring(0, Login.Login_username.length() - 1);
															}

															if (class142.field1665 == 84 || class142.field1665 == 80) {
																Login.currentLoginField = 1;
															}

															if (class118.method2893(class229.field2794) && Login.Login_username.length() < 320) {
																Login.Login_username = Login.Login_username + class229.field2794;
															}
														} else {
															class139.method3101(0);
															Login.Login_username = "";
															Login.Login_password = "";
															class347.field4201 = 0;
															class28.otp = "";
															Login.field916 = true;
														}
													}

													return;
												}
											} while(Login.currentLoginField != 1);

											if (class142.field1665 == 85 && Login.Login_password.length() > 0) {
												Login.Login_password = Login.Login_password.substring(0, Login.Login_password.length() - 1);
											} else if (class142.field1665 == 84 || class142.field1665 == 80) {
												Login.currentLoginField = 0;
												if (class142.field1665 == 84) {
													Login.Login_username = Login.Login_username.trim();
													if (Login.Login_username.length() == 0) {
														SecureRandomCallable.setLoginResponseString("", "Please enter your username/email address.", "");
														return;
													}

													if (Login.Login_password.length() == 0) {
														SecureRandomCallable.setLoginResponseString("", "Please enter your password.", "");
														return;
													}

													SecureRandomCallable.setLoginResponseString("", "Connecting to server...", "");
													PacketWriter.method2673(false);
													Coord.updateGameState(20);
													return;
												}
											}

											if ((KeyHandler.KeyHandler_pressedKeys[82] || KeyHandler.KeyHandler_pressedKeys[87]) && class142.field1665 == 67) {
												Clipboard var51 = Toolkit.getDefaultToolkit().getSystemClipboard();
												var52 = var51.getContents(IgnoreList.client);
												var47 = 20 - Login.Login_password.length();
												break;
											}

											char var48 = class229.field2794;
											if (var48 >= ' ' && var48 < 127 || var48 > 127 && var48 < 160 || var48 > 160 && var48 <= 255) {
												var45 = true;
											} else {
												label1491: {
													if (var48 != 0) {
														char[] var53 = class342.cp1252AsciiExtension;

														for (int var54 = 0; var54 < var53.length; ++var54) {
															char var15 = var53[var54];
															if (var15 == var48) {
																var45 = true;
																break label1491;
															}
														}
													}

													var45 = false;
												}
											}

											if (var45 && class118.method2893(class229.field2794) && Login.Login_password.length() < 20) {
												Login.Login_password = Login.Login_password + class229.field2794;
											}
										}
									} while(var47 <= 0);

									try {
										String var14 = (String)var52.getTransferData(DataFlavor.stringFlavor);
										int var49 = Math.min(var47, var14.length());

										for (int var16 = 0; var16 < var49; ++var16) {
											char var18 = var14.charAt(var16);
											boolean var17;
											if ((var18 < ' ' || var18 >= 127) && (var18 <= 127 || var18 >= 160) && (var18 <= 160 || var18 > 255)) {
												label1478: {
													if (var18 != 0) {
														char[] var19 = class342.cp1252AsciiExtension;

														for (int var20 = 0; var20 < var19.length; ++var20) {
															char var21 = var19[var20];
															if (var21 == var18) {
																var17 = true;
																break label1478;
															}
														}
													}

													var17 = false;
												}
											} else {
												var17 = true;
											}

											if (!var17 || !class118.method2893(var14.charAt(var16))) {
												class139.method3101(3);
												return;
											}
										}

										Login.Login_password = Login.Login_password + var14.substring(0, var49);
									} catch (UnsupportedFlavorException var35) {
									} catch (IOException var36) {
									}
								}
							} else if (Login.loginIndex == 3) {
								var40 = Login.loginBoxX + 180;
								var9 = 276;
								if (var24 == 1 && var38 >= var40 - 75 && var38 <= var40 + 75 && var39 >= var9 - 20 && var39 <= var9 + 20) {
									ObjectSound.method1848(false);
								}

								var40 = Login.loginBoxX + 180;
								var9 = 326;
								if (var24 == 1 && var38 >= var40 - 75 && var38 <= var40 + 75 && var39 >= var9 - 20 && var39 <= var9 + 20) {
									SecureRandomCallable.setLoginResponseString("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
									class139.method3101(5);
									return;
								}
							} else {
								int var11;
								if (Login.loginIndex == 4) {
									var40 = Login.loginBoxX + 180 - 80;
									var9 = 321;
									if (var24 == 1 && var38 >= var40 - 75 && var38 <= var40 + 75 && var39 >= var9 - 20 && var39 <= var9 + 20) {
										class28.otp.trim();
										if (class28.otp.length() != 6) {
											SecureRandomCallable.setLoginResponseString("", "Please enter a 6-digit PIN.", "");
											return;
										}

										class347.field4201 = Integer.parseInt(class28.otp);
										class28.otp = "";
										PacketWriter.method2673(true);
										SecureRandomCallable.setLoginResponseString("", "Connecting to server...", "");
										Coord.updateGameState(20);
										return;
									}

									if (var24 == 1 && var38 >= Login.loginBoxX + 180 - 9 && var38 <= Login.loginBoxX + 180 + 130 && var39 >= 263 && var39 <= 296) {
										Login.field916 = !Login.field916;
									}

									if (var24 == 1 && var38 >= Login.loginBoxX + 180 - 34 && var38 <= Login.loginBoxX + 34 + 180 && var39 >= 351 && var39 <= 363) {
										CollisionMap.openURL(SecureRandomCallable.method2205("secure", true) + "m=totp-authenticator/disableTOTPRequest", true, false);
									}

									var40 = Login.loginBoxX + 180 + 80;
									if (var24 == 1 && var38 >= var40 - 75 && var38 <= var40 + 75 && var39 >= var9 - 20 && var39 <= var9 + 20) {
										class139.method3101(0);
										Login.Login_username = "";
										Login.Login_password = "";
										class347.field4201 = 0;
										class28.otp = "";
									}

									while (class28.isKeyDown()) {
										boolean var10 = false;

										for (var11 = 0; var11 < "1234567890".length(); ++var11) {
											if (class229.field2794 == "1234567890".charAt(var11)) {
												var10 = true;
												break;
											}
										}

										if (class142.field1665 == 13) {
											class139.method3101(0);
											Login.Login_username = "";
											Login.Login_password = "";
											class347.field4201 = 0;
											class28.otp = "";
										} else {
											if (class142.field1665 == 85 && class28.otp.length() > 0) {
												class28.otp = class28.otp.substring(0, class28.otp.length() - 1);
											}

											if (class142.field1665 == 84) {
												class28.otp.trim();
												if (class28.otp.length() != 6) {
													SecureRandomCallable.setLoginResponseString("", "Please enter a 6-digit PIN.", "");
													return;
												}

												class347.field4201 = Integer.parseInt(class28.otp);
												class28.otp = "";
												PacketWriter.method2673(true);
												SecureRandomCallable.setLoginResponseString("", "Connecting to server...", "");
												Coord.updateGameState(20);
												return;
											}

											if (var10 && class28.otp.length() < 6) {
												class28.otp = class28.otp + class229.field2794;
											}
										}
									}
								} else if (Login.loginIndex == 5) {
									var40 = Login.loginBoxX + 180 - 80;
									var9 = 321;
									if (var24 == 1 && var38 >= var40 - 75 && var38 <= var40 + 75 && var39 >= var9 - 20 && var39 <= var9 + 20) {
										Login.Login_username = Login.Login_username.trim();
										if (Login.Login_username.length() == 0) {
											SecureRandomCallable.setLoginResponseString("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
										} else {
											long var29 = class33.method630();
											int var44;
											if (0L == var29) {
												var44 = 5;
											} else {
												var44 = class13.method185(var29, Login.Login_username);
											}

											switch(var44) {
											case 2:
												SecureRandomCallable.setLoginResponseString(Strings.field3934, Strings.field3855, Strings.field3883);
												class139.method3101(6);
												break;
											case 3:
												SecureRandomCallable.setLoginResponseString("", "Error connecting to server.", "");
												break;
											case 4:
												SecureRandomCallable.setLoginResponseString("The part of the website you are trying", "to connect to is offline at the moment.", "Please try again later.");
												break;
											case 5:
												SecureRandomCallable.setLoginResponseString("Sorry, there was an error trying to", "log you in to this part of the website.", "Please try again later.");
												break;
											case 6:
												SecureRandomCallable.setLoginResponseString("", "Error connecting to server.", "");
												break;
											case 7:
												SecureRandomCallable.setLoginResponseString("You must enter a valid login to proceed. For accounts", "created after 24th November 2010, please use your", "email address. Otherwise please use your username.");
											}
										}

										return;
									}

									var40 = Login.loginBoxX + 180 + 80;
									if (var24 == 1 && var38 >= var40 - 75 && var38 <= var40 + 75 && var39 >= var9 - 20 && var39 <= var9 + 20) {
										Calendar.Login_promptCredentials(true);
									}

									var43 = 361;
									if (Projectile.field957 != null) {
										var11 = Projectile.field957.highX / 2;
										if (var24 == 1 && var38 >= Projectile.field957.lowX - var11 && var38 <= var11 + Projectile.field957.lowX && var39 >= var43 - 15 && var39 < var43) {
											CollisionMap.openURL(SecureRandomCallable.method2205("secure", true) + "m=weblogin/g=oldscape/cant_log_in", true, false);
										}
									}

									while (class28.isKeyDown()) {
										var45 = false;

										for (var12 = 0; var12 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"ï¿½$%^&*()-_=+[{]};:'@#~,<.>/?\\| ".length(); ++var12) {
											if (class229.field2794 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"ï¿½$%^&*()-_=+[{]};:'@#~,<.>/?\\| ".charAt(var12)) {
												var45 = true;
												break;
											}
										}

										if (class142.field1665 == 13) {
											Calendar.Login_promptCredentials(true);
										} else {
											if (class142.field1665 == 85 && Login.Login_username.length() > 0) {
												Login.Login_username = Login.Login_username.substring(0, Login.Login_username.length() - 1);
											}

											if (class142.field1665 == 84) {
												Login.Login_username = Login.Login_username.trim();
												if (Login.Login_username.length() == 0) {
													SecureRandomCallable.setLoginResponseString("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
												} else {
													long var31 = class33.method630();
													if (0L == var31) {
														var12 = 5;
													} else {
														var12 = class13.method185(var31, Login.Login_username);
													}

													switch(var12) {
													case 2:
														SecureRandomCallable.setLoginResponseString(Strings.field3934, Strings.field3855, Strings.field3883);
														class139.method3101(6);
														break;
													case 3:
														SecureRandomCallable.setLoginResponseString("", "Error connecting to server.", "");
														break;
													case 4:
														SecureRandomCallable.setLoginResponseString("The part of the website you are trying", "to connect to is offline at the moment.", "Please try again later.");
														break;
													case 5:
														SecureRandomCallable.setLoginResponseString("Sorry, there was an error trying to", "log you in to this part of the website.", "Please try again later.");
														break;
													case 6:
														SecureRandomCallable.setLoginResponseString("", "Error connecting to server.", "");
														break;
													case 7:
														SecureRandomCallable.setLoginResponseString("You must enter a valid login to proceed. For accounts", "created after 24th November 2010, please use your", "email address. Otherwise please use your username.");
													}
												}

												return;
											}

											if (var45 && Login.Login_username.length() < 320) {
												Login.Login_username = Login.Login_username + class229.field2794;
											}
										}
									}
								} else if (Login.loginIndex != 6) {
									if (Login.loginIndex == 7) {
										if (UserComparator9.field1387 && !Client.onMobile) {
											var40 = ModeWhere.loginBoxCenter - 150;
											var42 = var40 + 40 + 240 + 25;
											var43 = 231;
											var11 = var43 + 40;
											if (var24 == 1 && var38 >= var40 && var38 <= var42 && var39 >= var43 && var39 <= var11) {
												Login.field891 = ItemContainer.method2230(var40, var38);
											}

											var12 = Login.loginBoxX + 180 - 80;
											short var13 = 321;
											boolean var28;
											if (var24 == 1 && var38 >= var12 - 75 && var38 <= var12 + 75 && var39 >= var13 - 20 && var39 <= var13 + 20) {
												var28 = Skeleton.method4257();
												if (var28) {
													Coord.updateGameState(50);
													return;
												}
											}

											var12 = Login.loginBoxX + 180 + 80;
											if (var24 == 1 && var38 >= var12 - 75 && var38 <= var12 + 75 && var39 >= var13 - 20 && var39 <= var13 + 20) {
												Login.field907 = new String[8];
												Calendar.Login_promptCredentials(true);
											}

											while (class28.isKeyDown()) {
												if (class142.field1665 == 101) {
													Login.field907[Login.field891] = null;
												}

												if (class142.field1665 == 85) {
													if (Login.field907[Login.field891] == null && Login.field891 > 0) {
														--Login.field891;
													}

													Login.field907[Login.field891] = null;
												}

												if (class229.field2794 >= '0' && class229.field2794 <= '9') {
													Login.field907[Login.field891] = "" + class229.field2794;
													if (Login.field891 < 7) {
														++Login.field891;
													}
												}

												if (class142.field1665 == 84) {
													var28 = Skeleton.method4257();
													if (var28) {
														Coord.updateGameState(50);
													}

													return;
												}
											}
										} else {
											var40 = Login.loginBoxX + 180 - 80;
											var9 = 321;
											if (var24 == 1 && var38 >= var40 - 75 && var38 <= var40 + 75 && var39 >= var9 - 20 && var39 <= var9 + 20) {
												CollisionMap.openURL(SecureRandomCallable.method2205("secure", true) + "m=dob/set_dob.ws", true, false);
												SecureRandomCallable.setLoginResponseString("", "Page has opened in a new window.", "(Please check your popup blocker.)");
												class139.method3101(6);
												return;
											}

											var40 = Login.loginBoxX + 180 + 80;
											if (var24 == 1 && var38 >= var40 - 75 && var38 <= var40 + 75 && var39 >= var9 - 20 && var39 <= var9 + 20) {
												Calendar.Login_promptCredentials(true);
											}
										}
									} else if (Login.loginIndex == 8) {
										var40 = Login.loginBoxX + 180 - 80;
										var9 = 321;
										if (var24 == 1 && var38 >= var40 - 75 && var38 <= var40 + 75 && var39 >= var9 - 20 && var39 <= var9 + 20) {
											CollisionMap.openURL("https://www.jagex.com/terms/privacy", true, false);
											SecureRandomCallable.setLoginResponseString("", "Page has opened in a new window.", "(Please check your popup blocker.)");
											class139.method3101(6);
											return;
										}

										var40 = Login.loginBoxX + 180 + 80;
										if (var24 == 1 && var38 >= var40 - 75 && var38 <= var40 + 75 && var39 >= var9 - 20 && var39 <= var9 + 20) {
											Calendar.Login_promptCredentials(true);
										}
									} else if (Login.loginIndex == 9) {
										var40 = Login.loginBoxX + 180;
										var9 = 311;
										if (class142.field1665 == 84 || class142.field1665 == 13 || var24 == 1 && var38 >= var40 - 75 && var38 <= var40 + 75 && var39 >= var9 - 20 && var39 <= var9 + 20) {
											ObjectSound.method1848(false);
										}
									} else if (Login.loginIndex == 10) {
										var40 = Login.loginBoxX + 180;
										var9 = 209;
										if (class142.field1665 == 84 || var24 == 1 && var38 >= var40 - 109 && var38 <= var40 + 109 && var39 >= var9 && var39 <= var9 + 68) {
											SecureRandomCallable.setLoginResponseString("", "Connecting to server...", "");
											Client.field639 = class448.field4785;
											PacketWriter.method2673(false);
											Coord.updateGameState(20);
										}
									} else if (Login.loginIndex == 12) {
										var40 = ModeWhere.loginBoxCenter;
										var9 = 233;
										Bounds var33 = var1.method6558(0, 30, "<col=ffd200>terms of use</col>, <col=ffd200>privacy policy</col>, and <col=ffd200>end user licence</col>", var40, var9);
										Bounds var25 = var1.method6558(32, 32, "<col=ffd200>terms of use</col>, <col=ffd200>privacy policy</col>, and <col=ffd200>end user licence</col>", var40, var9);
										Bounds var26 = var1.method6558(70, 34, "<col=ffd200>terms of use</col>, <col=ffd200>privacy policy</col>, and <col=ffd200>end user licence</col>", var40, var9);
										var42 = var9 + 17;
										Bounds var27 = var1.method6558(0, 34, "<col=ffd200>agreement (EULA)</col>.", var40, var42);
										if (var24 == 1) {
											if (var33.method7113(var38, var39)) {
												CollisionMap.openURL("https://www.jagex.com/terms", true, false);
											} else if (var25.method7113(var38, var39)) {
												CollisionMap.openURL("https://www.jagex.com/terms/privacy", true, false);
											} else if (var26.method7113(var38, var39) || var27.method7113(var38, var39)) {
												CollisionMap.openURL("https://www.jagex.com/en-GB/legal/eula-runescape-oldschool", true, false);
											}
										}

										var40 = ModeWhere.loginBoxCenter - 80;
										var9 = 311;
										if (var24 == 1 && var38 >= var40 - 75 && var38 <= var40 + 75 && var39 >= var9 - 20 && var39 <= var9 + 20) {
											Player.clientPreferences.method2408(Client.field497);
											ObjectSound.method1848(true);
										}

										var40 = ModeWhere.loginBoxCenter + 80;
										if (var24 == 1 && var38 >= var40 - 75 && var38 <= var40 + 75 && var39 >= var9 - 20 && var39 <= var9 + 20) {
											Login.loginIndex = 13;
										}
									} else if (Login.loginIndex == 13) {
										var40 = ModeWhere.loginBoxCenter;
										var9 = 321;
										if (var24 == 1 && var38 >= var40 - 75 && var38 <= var40 + 75 && var39 >= var9 - 20 && var39 <= var9 + 20) {
											ObjectSound.method1848(true);
										}
									} else if (Login.loginIndex == 14) {
										String var34 = "";
										switch(Login.field902) {
										case 0:
											var34 = "https://support.runescape.com/hc/en-gb/articles/115002238729-Account-Bans";
											break;
										case 1:
											var34 = "https://support.runescape.com/hc/en-gb/articles/206103939-My-account-is-locked";
											break;
										case 2:
											var34 = "https://support.runescape.com/hc/en-gb/articles/207256855-Settle-an-Unpaid-Balance";
											break;
										default:
											Calendar.Login_promptCredentials(false);
										}

										var42 = Login.loginBoxX + 180;
										var43 = 276;
										if (var24 == 1 && var38 >= var42 - 75 && var38 <= var42 + 75 && var39 >= var43 - 20 && var39 <= var43 + 20) {
											CollisionMap.openURL(var34, true, false);
											SecureRandomCallable.setLoginResponseString("", "Page has opened in a new window.", "(Please check your popup blocker.)");
											class139.method3101(6);
											return;
										}

										var42 = Login.loginBoxX + 180;
										var43 = 326;
										if (var24 == 1 && var38 >= var42 - 75 && var38 <= var42 + 75 && var39 >= var43 - 20 && var39 <= var43 + 20) {
											Calendar.Login_promptCredentials(false);
										}
									} else if (Login.loginIndex == 24) {
										var40 = Login.loginBoxX + 180;
										var9 = 301;
										if (var24 == 1 && var38 >= var40 - 75 && var38 <= var40 + 75 && var39 >= var9 - 20 && var39 <= var9 + 20) {
											ObjectSound.method1848(false);
										}
									} else if (Login.loginIndex == 26) {
										var40 = Login.loginBoxX + 180 - 80;
										var9 = 321;
										if (var24 == 1 && var38 >= var40 - 75 && var38 <= var40 + 75 && var39 >= var9 - 20 && var39 <= var9 + 20) {
											CollisionMap.openURL(SecureRandomCallable.method2205("secure", true) + "m=dob/set_dob.ws", true, false);
											SecureRandomCallable.setLoginResponseString("", "Page has opened in a new window.", "(Please check your popup blocker.)");
											class139.method3101(6);
											return;
										}

										var40 = Login.loginBoxX + 180 + 80;
										if (var24 == 1 && var38 >= var40 - 75 && var38 <= var40 + 75 && var39 >= var9 - 20 && var39 <= var9 + 20) {
											Calendar.Login_promptCredentials(true);
										}
									}
								} else {
									while (true) {
										do {
											if (!class28.isKeyDown()) {
												var41 = 321;
												if (var24 == 1 && var39 >= var41 - 20 && var39 <= var41 + 20) {
													Calendar.Login_promptCredentials(true);
												}

												return;
											}
										} while(class142.field1665 != 84 && class142.field1665 != 13);

										Calendar.Login_promptCredentials(true);
									}
								}
							}
						}
					}

				}
			}
		}
	}

	@ObfuscatedName("la")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "54"
	)
	static final void method6699() {
		Client.field701 = Client.cycleCntr;
		class142.ClanChat_inClanChat = true;
	}
}
