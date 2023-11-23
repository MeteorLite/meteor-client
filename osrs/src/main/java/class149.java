import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fk")
public class class149 extends class144 {
	@ObfuscatedName("at")
	int field1354;
	@ObfuscatedName("ah")
	int field1351;
	@ObfuscatedName("ar")
	int field1353;
	@ObfuscatedName("ao")
	int field1352;
	// $FF: synthetic field
	@ObfuscatedSignature(
		descriptor = "Lfv;"
	)
	final class147 this$0;

	@ObfuscatedSignature(
		descriptor = "(Lfv;)V"
	)
	class149(class147 var1) {
		this.this$0 = var1;
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(Luj;I)V",
		garbageValue = "-734756620"
	)
	@Export("vmethod3254")
	void vmethod3254(Buffer var1) {
		this.field1354 = var1.readInt();
		this.field1352 = var1.readInt();
		this.field1351 = var1.readUnsignedByte();
		this.field1353 = var1.readUnsignedByte();
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(Lfc;I)V",
		garbageValue = "-2111347169"
	)
	@Export("vmethod3248")
	void vmethod3248(ClanSettings var1) {
		var1.method815(this.field1354, this.field1352, this.field1351, this.field1353);
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(II)Lhz;",
		garbageValue = "1206229207"
	)
	public static HitSplatDefinition method776(int var0) {
		HitSplatDefinition var1 = (HitSplatDefinition)HitSplatDefinition.HitSplatDefinition_cached.get((long)var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = HitSplatDefinition.HitSplatDefinition_archive.takeFile(32, var0);
			var1 = new HitSplatDefinition();
			if (var2 != null) {
				var1.decode(new Buffer(var2));
			}

			HitSplatDefinition.HitSplatDefinition_cached.put(var1, (long)var0);
			return var1;
		}
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(ILdt;ZI)I",
		garbageValue = "1559513020"
	)
	static int opCodeCheck(int opCode, Script var1, boolean var2) {
		if (opCode < 1000) {
			return class47.method244(opCode, var1, var2);
		} else if (opCode < 1100) {
			return WidgetDefinition.method1738(opCode, var1, var2);
		} else if (opCode < 1200) {
			return class357.method1899(opCode, var1, var2);
		} else if (opCode < 1300) {
			return class426.method2177(opCode, var1, var2);
		} else if (opCode < 1400) {
			return WorldMapRectangle.method1327(opCode, var1, var2);
		} else if (opCode < 1500) {
			return class1.method3(opCode, var1, var2);
		} else if (opCode < 1600) {
			return ClanChannelMember.method768(opCode, var1, var2);
		} else if (opCode < 1700) {
			return ReflectionCheck.method186(opCode, var1, var2);
		} else if (opCode < 1800) {
			return class30.method133(opCode, var1, var2);
		} else if (opCode < 1900) {
			return ItemComposition.method1031(opCode, var1, var2);
		} else if (opCode < 2000) {
			return UserComparator6.method689(opCode, var1, var2);
		} else if (opCode < 2100) {
			return WidgetDefinition.method1738(opCode, var1, var2);
		} else if (opCode < 2200) {
			return class357.method1899(opCode, var1, var2);
		} else if (opCode < 2300) {
			return class426.method2177(opCode, var1, var2);
		} else if (opCode < 2400) {
			return WorldMapRectangle.method1327(opCode, var1, var2);
		} else if (opCode < 2500) {
			return class1.method3(opCode, var1, var2);
		} else if (opCode < 2600) {
			return class168.method874(opCode, var1, var2);
		} else if (opCode < 2700) {
			return class60.method338(opCode, var1, var2);
		} else if (opCode < 2800) {
			return FloorOverlayDefinition.method1038(opCode, var1, var2);
		} else if (opCode < 2900) {
			return UrlRequester.method651(opCode, var1, var2);
		} else if (opCode < 3000) {
			return UserComparator6.method689(opCode, var1, var2);
		} else if (opCode < 3200) {
			return World.method407(opCode, var1, var2);
		} else if (opCode < 3300) {
			return class159.method837(opCode, var1, var2);
		} else if (opCode < 3400) {
			return class463.method2335(opCode, var1, var2);
		} else if (opCode < 3500) {
			return ApproximateRouteStrategy.method356(opCode, var1, var2);
		} else if (opCode < 3600) {
			return RouteStrategy.method1151(opCode, var1, var2);
		} else if (opCode < 3700) {
			return class350.method1890(opCode, var1, var2);
		} else if (opCode < 3800) {
			return SequenceDefinition.method1055(opCode, var1, var2);
		} else if (opCode < 3900) {
			return WorldMapRectangle.method1328(opCode, var1, var2);
		} else if (opCode < 4000) {
			return Actor.method517(opCode, var1, var2);
		} else if (opCode < 4100) {
			return class422.method2168(opCode, var1, var2);
		} else if (opCode < 4200) {
			return ArchiveDiskAction.method1909(opCode, var1, var2);
		} else if (opCode < 4300) {
			return ObjectSound.method425(opCode, var1, var2);
		} else if (opCode < 5100) {
			return class12.method48(opCode, var1, var2);
		} else if (opCode < 5400) {
			return class72.method434(opCode, var1, var2);
		} else if (opCode < 5600) {
			return SoundSystem.method232(opCode, var1, var2);
		} else if (opCode < 5700) {
			return UserComparator9.method682(opCode, var1, var2);
		} else if (opCode < 6300) {
			return class134.method732(opCode, var1, var2);
		} else if (opCode < 6600) {
			return class138.method738(opCode, var1, var2);
		} else if (opCode < 6700) {
			return SecureRandomCallable.method458(opCode, var1, var2);
		} else if (opCode < 6800) {
			return class344.method1878(opCode, var1, var2);
		} else if (opCode < 6900) {
			return class17.method62(opCode, var1, var2);
		} else if (opCode < 7000) {
			return VerticalAlignment.method959(opCode, var1, var2);
		} else if (opCode < 7100) {
			return class148.method775(opCode, var1, var2);
		} else if (opCode < 7200) {
			return class158.method833(opCode, var1, var2);
		} else if (opCode < 7300) {
			return ScriptEvent.method468(opCode, var1, var2);
		} else if (opCode < 7500) {
			return class147.method771(opCode, var1, var2);
		} else if (opCode < 7600) {
			return class59.method333(opCode, var1, var2);
		} else if (opCode < 7700) {
			return class12.method49(opCode, var1, var2);
		} else {
			return opCode < 8100 ? ModelData0.method1599(opCode, var1, var2) : 2;
		}
	}

	@ObfuscatedName("hr")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "-869974291"
	)
	@Export("getLoginError")
	static void getLoginError(int var0) {
		int var1 = Login.loginIndex;
		if (var0 == -3) {
			class139.setLoginResponseString("Connection timed out.", "Please try using a different world.", "");
		} else if (var0 == -2) {
			class139.setLoginResponseString("Error connecting to server.", "Please try using a different world.", "");
		} else if (var0 == -1) {
			class139.setLoginResponseString("No response from server.", "Please try using a different world.", "");
		} else if (var0 == 3) {
			UserComparator7.method674(3);
			Login.field750 = 1;
		} else if (var0 == 4) {
			class129.method711(0);
		} else if (var0 == 5) {
			Login.field750 = 2;
			class139.setLoginResponseString("Either your account is still logged in, or the last", "world you were using has become unavailable.", "Please try again later.");
		} else if (var0 == 68) {
			if (!Client.reloadJS5) {
				Client.reloadJS5 = true;
				ByteArrayPool.reloadJS5();
				return;
			}

			class139.setLoginResponseString("RuneScape has been updated!", "Please reload this page.", "");
		} else if (!Client.onMobile && var0 == 6) {
			class139.setLoginResponseString("RuneScape has been updated!", "Please reload this page.", "");
		} else if (var0 == 7) {
			class139.setLoginResponseString("This world is full.", "Please use a different world.", "");
		} else if (var0 == 8) {
			class139.setLoginResponseString("Unable to connect.", "Login server offline.", "");
		} else if (var0 == 9) {
			class139.setLoginResponseString("Login limit exceeded.", "Too many connections from your address.", "");
		} else if (var0 == 10) {
			class139.setLoginResponseString("Unable to connect.", "Bad session id.", "");
		} else if (var0 == 11) {
			class139.setLoginResponseString("We suspect someone knows your password.", "Press 'change your password' on front page.", "");
		} else if (var0 == 12) {
			class139.setLoginResponseString("You need a members account to login to this world.", "Please subscribe, or use a different world.", "");
		} else if (var0 == 13) {
			class139.setLoginResponseString("Could not complete login.", "Please try using a different world.", "");
		} else if (var0 == 14) {
			class139.setLoginResponseString("The server is being updated.", "Please wait 1 minute and try again.", "");
		} else if (var0 == 16) {
			class139.setLoginResponseString("Too many login attempts.", "You can use the Jagex Launcher to continue playing.", "Press the button below to download it now.");
			UserComparator7.method674(33);
		} else if (var0 == 17) {
			class139.setLoginResponseString("To access this free world, log into a", "members world and move your character", "to a non-members area.");
		} else if (var0 == 18) {
			class129.method711(1);
		} else if (var0 == 19) {
			class139.setLoginResponseString("This world is running a closed Beta.", "Sorry invited players only.", "Please use a different world.");
		} else if (var0 == 20) {
			class139.setLoginResponseString("Invalid loginserver requested.", "Please try using a different world.", "");
		} else if (var0 == 22) {
			class139.setLoginResponseString("Malformed login packet.", "Please try again.", "");
		} else if (var0 == 23) {
			class139.setLoginResponseString("No reply from loginserver.", "Please wait 1 minute and try again.", "");
		} else if (var0 == 24) {
			class139.setLoginResponseString("Error loading your profile.", "Please contact customer support.", "");
		} else if (var0 == 25) {
			class139.setLoginResponseString("Unexpected loginserver response.", "Please try using a different world.", "");
		} else if (var0 == 26) {
			class139.setLoginResponseString("This computers address has been blocked", "as it was used to break our rules.", "");
		} else if (var0 == 27) {
			class139.setLoginResponseString("", "Service unavailable.", "");
		} else if (var0 == 31) {
			class139.setLoginResponseString("Your account must have a displayname set", "in order to play the game.  Please set it", "via the website, or the main game.");
		} else if (var0 == 32) {
			class129.method711(2);
		} else if (var0 == 37) {
			class139.setLoginResponseString("Your account is currently inaccessible.", "Please try again in a few minutes.", "");
		} else if (var0 == 38) {
			class139.setLoginResponseString("You need to vote to play!", "Visit runescape.com and vote,", "and then come back here!");
		} else if (var0 == 55) {
			UserComparator7.method674(8);
		} else {
			if (var0 == 56) {
				class139.setLoginResponseString("Enter the 6-digit code generated by your", "authenticator app.", "");
				WorldMapSection2.updateGameState(11);
				return;
			}

			if (var0 == 57) {
				class139.setLoginResponseString("The code you entered was incorrect.", "Please try again.", "");
				WorldMapSection2.updateGameState(11);
				return;
			}

			if (var0 == 61) {
				class139.setLoginResponseString("", "Please enter your date of birth (DD/MM/YYYY)", "");
				UserComparator7.method674(7);
			} else {
				if (var0 == 62) {
					WorldMapSection2.updateGameState(10);
					UserComparator7.method674(9);
					class139.setLoginResponseString("Login attempt timed out.", "Please try again.", "");
					return;
				}

				if (var0 == 63) {
					WorldMapSection2.updateGameState(10);
					UserComparator7.method674(9);
					class139.setLoginResponseString("You were signed out.", "Please sign in again.", "");
					return;
				}

				if (var0 == 65 || var0 == 67) {
					WorldMapSection2.updateGameState(10);
					UserComparator7.method674(9);
					class139.setLoginResponseString("Failed to login.", "Please try again.", "");
					return;
				}

				if (var0 == 71) {
					WorldMapSection2.updateGameState(10);
					UserComparator7.method674(7);
					class139.setLoginResponseString("There was a problem updating your DOB.", "Please try again later. If the problem ", "persists, please contact Jagex Support.");
				} else if (var0 == 73) {
					WorldMapSection2.updateGameState(10);
					UserComparator7.method674(6);
					class139.setLoginResponseString("Your date of birth information is waiting", "to be reviewed by our staff.", "It will be processed shortly.");
				} else if (var0 == 72) {
					WorldMapSection2.updateGameState(10);
					UserComparator7.method674(32);
				} else {
					class139.setLoginResponseString("Unexpected server response", "Please try using a different world.", "");
				}
			}
		}

		WorldMapSection2.updateGameState(10);
		int var4 = Login.loginIndex;
		boolean var5 = var1 != var4;
		if (!var5 && Client.field648.method2633()) {
			UserComparator7.method674(9);
		}

	}
}