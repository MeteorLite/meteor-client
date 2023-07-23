import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.Map;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ac")
public class class20 {
	@ObfuscatedName("gz")
	static String field58;
	@ObfuscatedName("aw")
	final int field59;
	@ObfuscatedName("ay")
	final Map field61;
	@ObfuscatedName("ar")
	final String field60;

	class20(String var1) {
		this.field59 = 400;
		this.field61 = null;
		this.field60 = "";
	}

	class20(HttpURLConnection var1) throws IOException {
		this.field59 = var1.getResponseCode();
		var1.getResponseMessage();
		this.field61 = var1.getHeaderFields();
		StringBuilder var2 = new StringBuilder();
		InputStream var3 = this.field59 >= 300 ? var1.getErrorStream() : var1.getInputStream();
		if (var3 != null) {
			InputStreamReader var4 = new InputStreamReader(var3);
			BufferedReader var5 = new BufferedReader(var4);

			String var6;
			while ((var6 = var5.readLine()) != null) {
				var2.append(var6);
			}

			var3.close();
		}

		this.field60 = var2.toString();
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "1919676702"
	)
	public int method70() {
		return this.field59;
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(B)Ljava/util/Map;",
		garbageValue = "93"
	)
	public Map method71() {
		return this.field61;
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(I)Ljava/lang/String;",
		garbageValue = "1874601503"
	)
	public String method72() {
		return this.field60;
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(Lnd;I)V",
		garbageValue = "-425693267"
	)
	public static void method69(AbstractArchive var0) {
		StructComposition.StructDefinition_archive = var0;
	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "(CB)C",
		garbageValue = "-112"
	)
	static char method73(char var0) {
		switch(var0) {
		case ' ':
		case '-':
		case '_':
		case ' ':
			return '_';
		case '#':
		case '[':
		case ']':
			return var0;
		case 'À':
		case 'Á':
		case 'Â':
		case 'Ã':
		case 'Ä':
		case 'à':
		case 'á':
		case 'â':
		case 'ã':
		case 'ä':
			return 'a';
		case 'Ç':
		case 'ç':
			return 'c';
		case 'È':
		case 'É':
		case 'Ê':
		case 'Ë':
		case 'è':
		case 'é':
		case 'ê':
		case 'ë':
			return 'e';
		case 'Í':
		case 'Î':
		case 'Ï':
		case 'í':
		case 'î':
		case 'ï':
			return 'i';
		case 'Ñ':
		case 'ñ':
			return 'n';
		case 'Ò':
		case 'Ó':
		case 'Ô':
		case 'Õ':
		case 'Ö':
		case 'ò':
		case 'ó':
		case 'ô':
		case 'õ':
		case 'ö':
			return 'o';
		case 'Ù':
		case 'Ú':
		case 'Û':
		case 'Ü':
		case 'ù':
		case 'ú':
		case 'û':
		case 'ü':
			return 'u';
		case 'ß':
			return 'b';
		case 'ÿ':
		case 'Ÿ':
			return 'y';
		default:
			return Character.toLowerCase(var0);
		}
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(ILdc;ZI)I",
		garbageValue = "-2069534350"
	)
	static int method74(int var0, Script var1, boolean var2) {
		Widget var3;
		if (var0 >= 2000) {
			var0 -= 1000;
			var3 = VarbitComposition.getWidget(Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
		} else {
			var3 = var2 ? class36.scriptDotWidget : class351.scriptActiveWidget;
		}

		String var4 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
		int[] var5 = null;
		if (var4.length() > 0 && var4.charAt(var4.length() - 1) == 'Y') {
			int var6 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
			if (var6 > 0) {
				for (var5 = new int[var6]; var6-- > 0; var5[var6] = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]) {
				}
			}

			var4 = var4.substring(0, var4.length() - 1);
		}

		Object[] var9 = new Object[var4.length() + 1];

		int var7;
		for (var7 = var9.length - 1; var7 >= 1; --var7) {
			if (var4.charAt(var7 - 1) == 's') {
				var9[var7] = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
			} else {
				var9[var7] = new Integer(Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
			}
		}

		var7 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
		if (var7 != -1) {
			var9[0] = new Integer(var7);
		} else {
			var9 = null;
		}

		if (var0 == 1400) {
			var3.onClick = var9;
		} else if (var0 == 1401) {
			var3.onHold = var9;
		} else if (var0 == 1402) {
			var3.onRelease = var9;
		} else if (var0 == 1403) {
			var3.onMouseOver = var9;
		} else if (var0 == 1404) {
			var3.onMouseLeave = var9;
		} else if (var0 == 1405) {
			var3.onDrag = var9;
		} else if (var0 == 1406) {
			var3.onTargetLeave = var9;
		} else if (var0 == 1407) {
			var3.onVarTransmit = var9;
			var3.varTransmitTriggers = var5;
		} else if (var0 == 1408) {
			var3.onTimer = var9;
		} else if (var0 == 1409) {
			var3.onOp = var9;
		} else if (var0 == 1410) {
			var3.onDragComplete = var9;
		} else if (var0 == 1411) {
			var3.onClickRepeat = var9;
		} else if (var0 == 1412) {
			var3.onMouseRepeat = var9;
		} else if (var0 == 1414) {
			var3.onInvTransmit = var9;
			var3.invTransmitTriggers = var5;
		} else if (var0 == 1415) {
			var3.onStatTransmit = var9;
			var3.statTransmitTriggers = var5;
		} else if (var0 == 1416) {
			var3.onTargetEnter = var9;
		} else if (var0 == 1417) {
			var3.onScroll = var9;
		} else if (var0 == 1418) {
			var3.onChatTransmit = var9;
		} else if (var0 == 1419) {
			var3.onKey = var9;
		} else if (var0 == 1420) {
			var3.onFriendTransmit = var9;
		} else if (var0 == 1421) {
			var3.onClanTransmit = var9;
		} else if (var0 == 1422) {
			var3.onMiscTransmit = var9;
		} else if (var0 == 1423) {
			var3.onDialogAbort = var9;
		} else if (var0 == 1424) {
			var3.onSubChange = var9;
		} else if (var0 == 1425) {
			var3.onStockTransmit = var9;
		} else if (var0 == 1426) {
			var3.field3069 = var9;
		} else if (var0 == 1427) {
			var3.onResize = var9;
		} else if (var0 == 1428) {
			var3.field3070 = var9;
		} else if (var0 == 1429) {
			var3.field3062 = var9;
		} else if (var0 == 1430) {
			var3.field3061 = var9;
		} else if (var0 == 1431) {
			var3.field3068 = var9;
		} else if (var0 == 1434) {
			var3.field3072 = var9;
		} else if (var0 == 1435) {
			var3.field3042 = var9;
		} else {
			if (var0 < 1436 || var0 > 1439) {
				return 2;
			}

			class328 var8 = var3.method1808();
			if (var8 != null) {
				if (var0 == 1436) {
					var8.field2885 = var9;
				} else if (var0 == 1437) {
					var8.field2883 = var9;
				} else if (var0 == 1438) {
					var8.field2882 = var9;
				} else if (var0 == 1439) {
					var8.field2884 = var9;
				}
			}
		}

		var3.hasListener = true;
		return 1;
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(Lbq;I)V",
		garbageValue = "439702935"
	)
	static void method75(GameEngine var0) {
		class213 var1 = SceneTilePaint.method1324();

		while (var1.method1085()) {
			if (var1.field1869 == 13) {
				Login.worldSelectOpen = false;
				SongTask.leftTitleSprite.drawAt(Login.xPadding, 0);
				ScriptFrame.rightTitleSprite.drawAt(Login.xPadding + 382, 0);
				Login.logoSprite.drawAt(Login.xPadding + 382 - Login.logoSprite.subWidth / 2, 18);
				return;
			}

			if (var1.field1869 == 96) {
				if (Login.worldSelectPage > 0 && class47.worldSelectLeftSprite != null) {
					--Login.worldSelectPage;
				}
			} else if (var1.field1869 == 97 && Login.worldSelectPage < Login.worldSelectPagesCount && FontName.worldSelectRightSprite != null) {
				++Login.worldSelectPage;
			}
		}

		if (MouseHandler.MouseHandler_lastButton == 1 || !class28.mouseCam && MouseHandler.MouseHandler_lastButton == 4) {
			int var2 = Login.xPadding + 280;
			if (MouseHandler.MouseHandler_lastPressedX >= var2 && MouseHandler.MouseHandler_lastPressedX <= var2 + 14 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
				class300.changeWorldSelectSorting(0, 0);
				return;
			}

			if (MouseHandler.MouseHandler_lastPressedX >= var2 + 15 && MouseHandler.MouseHandler_lastPressedX <= var2 + 80 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
				class300.changeWorldSelectSorting(0, 1);
				return;
			}

			int var3 = Login.xPadding + 390;
			if (MouseHandler.MouseHandler_lastPressedX >= var3 && MouseHandler.MouseHandler_lastPressedX <= var3 + 14 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
				class300.changeWorldSelectSorting(1, 0);
				return;
			}

			if (MouseHandler.MouseHandler_lastPressedX >= var3 + 15 && MouseHandler.MouseHandler_lastPressedX <= var3 + 80 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
				class300.changeWorldSelectSorting(1, 1);
				return;
			}

			int var4 = Login.xPadding + 500;
			if (MouseHandler.MouseHandler_lastPressedX >= var4 && MouseHandler.MouseHandler_lastPressedX <= var4 + 14 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
				class300.changeWorldSelectSorting(2, 0);
				return;
			}

			if (MouseHandler.MouseHandler_lastPressedX >= var4 + 15 && MouseHandler.MouseHandler_lastPressedX <= var4 + 80 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
				class300.changeWorldSelectSorting(2, 1);
				return;
			}

			int var5 = Login.xPadding + 610;
			if (MouseHandler.MouseHandler_lastPressedX >= var5 && MouseHandler.MouseHandler_lastPressedX <= var5 + 14 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
				class300.changeWorldSelectSorting(3, 0);
				return;
			}

			if (MouseHandler.MouseHandler_lastPressedX >= var5 + 15 && MouseHandler.MouseHandler_lastPressedX <= var5 + 80 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
				class300.changeWorldSelectSorting(3, 1);
				return;
			}

			if (MouseHandler.MouseHandler_lastPressedX >= Login.xPadding + 708 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedX <= Login.xPadding + 708 + 50 && MouseHandler.MouseHandler_lastPressedY <= 20) {
				Login.worldSelectOpen = false;
				SongTask.leftTitleSprite.drawAt(Login.xPadding, 0);
				ScriptFrame.rightTitleSprite.drawAt(Login.xPadding + 382, 0);
				Login.logoSprite.drawAt(Login.xPadding + 382 - Login.logoSprite.subWidth / 2, 18);
				return;
			}

			if (Login.hoveredWorldIndex != -1) {
				World var6 = class387.World_worlds[Login.hoveredWorldIndex];
				if (var6.isDeadman()) {
					var6.field677 = "beta";
				}

				boolean var7 = false;
				if (var6.properties != Client.worldProperties) {
					boolean var8 = (Client.worldProperties & 65536) != 0;
					boolean var9 = var6.isDeadman();
					if (var8 && !var9 || !var8 && var9) {
						var7 = true;
					}
				}

				class137.changeWorld(var6);
				Login.worldSelectOpen = false;
				SongTask.leftTitleSprite.drawAt(Login.xPadding, 0);
				ScriptFrame.rightTitleSprite.drawAt(Login.xPadding + 382, 0);
				Login.logoSprite.drawAt(Login.xPadding + 382 - Login.logoSprite.subWidth / 2, 18);
				if (var7) {
					InterfaceParent.method471();
				}

				return;
			}

			if (Login.worldSelectPage > 0 && class47.worldSelectLeftSprite != null && MouseHandler.MouseHandler_lastPressedX >= 0 && MouseHandler.MouseHandler_lastPressedX <= class47.worldSelectLeftSprite.subWidth && MouseHandler.MouseHandler_lastPressedY >= WorldMapArchiveLoader.canvasHeight / 2 - 50 && MouseHandler.MouseHandler_lastPressedY <= WorldMapArchiveLoader.canvasHeight / 2 + 50) {
				--Login.worldSelectPage;
			}

			if (Login.worldSelectPage < Login.worldSelectPagesCount && FontName.worldSelectRightSprite != null && MouseHandler.MouseHandler_lastPressedX >= GrandExchangeOfferTotalQuantityComparator.canvasWidth - FontName.worldSelectRightSprite.subWidth - 5 && MouseHandler.MouseHandler_lastPressedX <= GrandExchangeOfferTotalQuantityComparator.canvasWidth && MouseHandler.MouseHandler_lastPressedY >= WorldMapArchiveLoader.canvasHeight / 2 - 50 && MouseHandler.MouseHandler_lastPressedY <= WorldMapArchiveLoader.canvasHeight / 2 + 50) {
				++Login.worldSelectPage;
			}
		}

	}
}
