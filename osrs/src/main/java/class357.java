import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("nm")
public class class357 {
	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "Lnm;"
	)
	static final class357 field3179;
	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "Lnm;"
	)
	static final class357 field3178;
	@ObfuscatedName("bh")
	@Export("hasFocus")
	protected static boolean hasFocus;
	@ObfuscatedName("ar")
	final int field3181;
	@ObfuscatedName("ao")
	final int field3180;

	static {
		field3179 = new class357(51, 27, 800, 0, 16, 16);
		field3178 = new class357(25, 28, 800, 656, 40, 40);
	}

	class357(int var1, int var2, int var3, int var4, int var5, int var6) {
		this.field3181 = var5;
		this.field3180 = var6;
	}

	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "(ILdt;ZI)I",
		garbageValue = "1617415071"
	)
	static int method1899(int var0, Script var1, boolean var2) {
		int var4 = -1;
		Widget var3;
		if (var0 >= 2000) {
			var0 -= 1000;
			var4 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
			var3 = HealthBarDefinition.widgetDefinition.method1733(var4);
		} else {
			var3 = var2 ? Interpreter.scriptDotWidget : HealthBar.scriptActiveWidget;
		}

		int var10;
		if (var0 == 1100) {
			DbTableType.Interpreter_intStackSize -= 2;
			var10 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize];
			int var6 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize + 1];
			if (var3.type == 12) {
				class341 var7 = var3.method1871();
				if (var7 != null && var7.method1768(var10, var6)) {
					class159.invalidateWidget(var3);
				}
			} else {
				var3.scrollX = var10;
				if (var3.scrollX > var3.scrollWidth - var3.width) {
					var3.scrollX = var3.scrollWidth - var3.width;
				}

				if (var3.scrollX < 0) {
					var3.scrollX = 0;
				}

				var3.scrollY = var6;
				if (var3.scrollY > var3.scrollHeight - var3.height) {
					var3.scrollY = var3.scrollHeight - var3.height;
				}

				if (var3.scrollY < 0) {
					var3.scrollY = 0;
				}

				class159.invalidateWidget(var3);
			}

			return 1;
		} else if (var0 == 1101) {
			var3.color = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
			class159.invalidateWidget(var3);
			return 1;
		} else if (var0 == 1102) {
			var3.fill = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize] == 1;
			class159.invalidateWidget(var3);
			return 1;
		} else if (var0 == 1103) {
			var3.transparencyTop = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
			class159.invalidateWidget(var3);
			return 1;
		} else if (var0 == 1104) {
			var3.lineWid = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
			class159.invalidateWidget(var3);
			return 1;
		} else if (var0 == 1105) {
			var3.spriteId2 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
			class159.invalidateWidget(var3);
			return 1;
		} else if (var0 == 1106) {
			var3.spriteAngle = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
			class159.invalidateWidget(var3);
			return 1;
		} else if (var0 == 1107) {
			var3.spriteTiling = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize] == 1;
			class159.invalidateWidget(var3);
			return 1;
		} else if (var0 == 1108) {
			var3.modelType = 1;
			var3.modelId = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
			class159.invalidateWidget(var3);
			return 1;
		} else if (var0 == 1109) {
			DbTableType.Interpreter_intStackSize -= 6;
			var3.modelOffsetX = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize];
			var3.modelOffsetY = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize + 1];
			var3.modelAngleX = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize + 2];
			var3.modelAngleY = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize + 3];
			var3.modelAngleZ = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize + 4];
			var3.modelZoom = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize + 5];
			class159.invalidateWidget(var3);
			return 1;
		} else if (var0 == 1110) {
			var10 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
			if (var10 != var3.sequenceId) {
				var3.sequenceId = var10;
				var3.modelFrame = 0;
				var3.modelFrameCycle = 0;
				class159.invalidateWidget(var3);
			}

			return 1;
		} else if (var0 == 1111) {
			var3.modelOrthog = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize] == 1;
			class159.invalidateWidget(var3);
			return 1;
		} else {
			class341 var9;
			if (var0 != 1112) {
				class341 var12;
				if (var0 == 1113) {
					var3.fontId = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
					if (var3.type == 12) {
						var12 = var3.method1871();
						if (var12 != null) {
							var12.method1775();
						}
					}

					class159.invalidateWidget(var3);
					return 1;
				} else if (var0 == 1114) {
					DbTableType.Interpreter_intStackSize -= 3;
					if (var3.type == 12) {
						var12 = var3.method1871();
						if (var12 != null) {
							var12.method1769(Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize], Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize + 1]);
							var12.method1770(Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize + 2]);
						}
					} else {
						var3.textXAlignment = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize];
						var3.textYAlignment = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize + 1];
						var3.textLineHeight = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize + 2];
					}

					class159.invalidateWidget(var3);
					return 1;
				} else if (var0 == 1115) {
					var3.textShadowed = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize] == 1;
					class159.invalidateWidget(var3);
					return 1;
				} else if (var0 == 1116) {
					var3.outline = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
					class159.invalidateWidget(var3);
					return 1;
				} else if (var0 == 1117) {
					var3.spriteShadow = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
					class159.invalidateWidget(var3);
					return 1;
				} else if (var0 == 1118) {
					var3.spriteFlipV = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize] == 1;
					class159.invalidateWidget(var3);
					return 1;
				} else if (var0 == 1119) {
					var3.spriteFlipH = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize] == 1;
					class159.invalidateWidget(var3);
					return 1;
				} else if (var0 == 1120) {
					DbTableType.Interpreter_intStackSize -= 2;
					var3.scrollWidth = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize];
					var3.scrollHeight = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize + 1];
					class159.invalidateWidget(var3);
					if (var4 != -1 && var3.type == 0) {
						class132.revalidateWidgetScroll(HealthBarDefinition.widgetDefinition.Widget_interfaceComponents[var4 >> 16], var3, false);
					}

					return 1;
				} else if (var0 == 1121) {
					class10.resumePauseWidget(var3.id, var3.childIndex);
					Client.meslayerContinueWidget = var3;
					class159.invalidateWidget(var3);
					return 1;
				} else if (var0 == 1122) {
					var3.spriteId = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
					class159.invalidateWidget(var3);
					return 1;
				} else if (var0 == 1123) {
					var3.color2 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
					class159.invalidateWidget(var3);
					return 1;
				} else if (var0 == 1124) {
					var3.transparencyBot = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
					class159.invalidateWidget(var3);
					return 1;
				} else if (var0 == 1125) {
					var10 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
					FillMode var13 = (FillMode)class12.findEnumerated(WallDecoration.FillMode_values(), var10);
					if (var13 != null) {
						var3.fillMode = var13;
						class159.invalidateWidget(var3);
					}

					return 1;
				} else {
					boolean var5;
					if (var0 == 1126) {
						var5 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize] == 1;
						var3.field2989 = var5;
						return 1;
					} else if (var0 == 1127) {
						var5 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize] == 1;
						var3.modelTransparency = var5;
						return 1;
					} else if (var0 == 1129) {
						var3.field3117 = Interpreter.Interpreter_stringStack[--class127.Interpreter_stringStackSize];
						class159.invalidateWidget(var3);
						return 1;
					} else if (var0 == 1130) {
						var3.method1855(Interpreter.Interpreter_stringStack[--class127.Interpreter_stringStackSize], class60.urlRequester, ModelData0.method1598());
						return 1;
					} else if (var0 == 1131) {
						DbTableType.Interpreter_intStackSize -= 2;
						var3.method1858(Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize], Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize + 1]);
						return 1;
					} else if (var0 == 1132) {
						var3.method1859(Interpreter.Interpreter_stringStack[--class127.Interpreter_stringStackSize], Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize]);
						return 1;
					} else {
						class336 var14;
						if (var0 == 1133) {
							--DbTableType.Interpreter_intStackSize;
							var14 = var3.method1872();
							if (var14 != null) {
								var14.field2923 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize];
								class159.invalidateWidget(var3);
							}

							return 1;
						} else if (var0 == 1134) {
							--DbTableType.Interpreter_intStackSize;
							var14 = var3.method1872();
							if (var14 != null) {
								var14.field2921 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize];
								class159.invalidateWidget(var3);
							}

							return 1;
						} else if (var0 == 1135) {
							--class127.Interpreter_stringStackSize;
							var12 = var3.method1871();
							if (var12 != null) {
								var3.text2 = Interpreter.Interpreter_stringStack[class127.Interpreter_stringStackSize];
							}

							return 1;
						} else if (var0 == 1136) {
							--DbTableType.Interpreter_intStackSize;
							var14 = var3.method1872();
							if (var14 != null) {
								var14.field2922 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize];
								class159.invalidateWidget(var3);
							}

							return 1;
						} else if (var0 == 1137) {
							--DbTableType.Interpreter_intStackSize;
							var12 = var3.method1871();
							if (var12 != null && var12.method1765(Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize])) {
								class159.invalidateWidget(var3);
							}

							return 1;
						} else if (var0 == 1138) {
							--DbTableType.Interpreter_intStackSize;
							var12 = var3.method1871();
							if (var12 != null && var12.method1766(Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize])) {
								class159.invalidateWidget(var3);
							}

							return 1;
						} else if (var0 == 1139) {
							--DbTableType.Interpreter_intStackSize;
							var12 = var3.method1871();
							if (var12 != null && var12.method1767(Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize])) {
								class159.invalidateWidget(var3);
							}

							return 1;
						} else if (var0 == 1140) {
							var5 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize] == 1;
							Client.field422.method1114();
							var9 = var3.method1871();
							if (var9 != null && var9.method1759(var5)) {
								if (var5) {
									Client.field422.method1112(var3);
								}

								class159.invalidateWidget(var3);
							}

							return 1;
						} else if (var0 == 1141) {
							var5 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize] == 1;
							if (!var5 && Client.field422.method1113() == var3) {
								Client.field422.method1114();
								class159.invalidateWidget(var3);
							}

							var9 = var3.method1871();
							if (var9 != null) {
								var9.method1760(var5);
							}

							return 1;
						} else if (var0 == 1142) {
							DbTableType.Interpreter_intStackSize -= 2;
							var12 = var3.method1871();
							if (var12 != null && var12.method1783(Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize], Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize + 1])) {
								class159.invalidateWidget(var3);
							}

							return 1;
						} else if (var0 == 1143) {
							--DbTableType.Interpreter_intStackSize;
							var12 = var3.method1871();
							if (var12 != null && var12.method1783(Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize], Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize])) {
								class159.invalidateWidget(var3);
							}

							return 1;
						} else if (var0 == 1144) {
							--DbTableType.Interpreter_intStackSize;
							var12 = var3.method1871();
							if (var12 != null) {
								var12.method1772(Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize]);
								class159.invalidateWidget(var3);
							}

							return 1;
						} else if (var0 == 1145) {
							--DbTableType.Interpreter_intStackSize;
							var12 = var3.method1871();
							if (var12 != null) {
								var12.method1771(Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize]);
							}

							return 1;
						} else if (var0 == 1146) {
							--DbTableType.Interpreter_intStackSize;
							var12 = var3.method1871();
							if (var12 != null) {
								var12.method1774(Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize]);
							}

							return 1;
						} else if (var0 == 1147) {
							--DbTableType.Interpreter_intStackSize;
							var12 = var3.method1871();
							if (var12 != null) {
								var12.method1773(Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize]);
								class159.invalidateWidget(var3);
							}

							return 1;
						} else {
							class27 var11;
							if (var0 == 1148) {
								DbTableType.Interpreter_intStackSize -= 2;
								var11 = var3.method1873();
								if (var11 != null) {
									var11.method111(Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize], Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize + 1]);
								}

								return 1;
							} else if (var0 == 1149) {
								DbTableType.Interpreter_intStackSize -= 2;
								var11 = var3.method1873();
								if (var11 != null) {
									var11.method113((char)Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize], Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize + 1]);
								}

								return 1;
							} else if (var0 == 1150) {
								var3.method1856(Interpreter.Interpreter_stringStack[--class127.Interpreter_stringStackSize], class60.urlRequester);
								return 1;
							} else {
								return 2;
							}
						}
					}
				}
			} else {
				String var8 = Interpreter.Interpreter_stringStack[--class127.Interpreter_stringStackSize];
				if (var3.type == 12) {
					var9 = var3.method1871();
					if (var9 != null && var9.method1815()) {
						var9.method1761(var8);
					} else {
						var3.text = var8;
					}

					class159.invalidateWidget(var3);
				} else if (!var8.equals(var3.text)) {
					var3.text = var8;
					class159.invalidateWidget(var3);
				}

				return 1;
			}
		}
	}

	@ObfuscatedName("hw")
	@ObfuscatedSignature(
		descriptor = "(Loh;Ljava/lang/String;I)V",
		garbageValue = "-587575754"
	)
	static void method1900(Archive var0, String var1) {
		ArchiveLoader var2 = new ArchiveLoader(var0, var1);
		Client.archiveLoaders.add(var2);
		Client.field549 += var2.groupCount;
	}
}