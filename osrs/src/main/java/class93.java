import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dw")
public class class93 {
	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "(ILdh;ZI)I",
		garbageValue = "36436435"
	)
	static int method504(int var0, Script var1, boolean var2) {
		int var4 = -1;
		Widget var3;
		if (var0 >= 2000) {
			var0 -= 1000;
			var4 = Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize];
			var3 = class92.getWidget(var4);
		} else {
			var3 = var2 ? GameObject.scriptDotWidget : SceneTilePaint.scriptActiveWidget;
		}

		int var10;
		if (var0 == 1100) {
			SoundCache.Interpreter_intStackSize -= 2;
			var10 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize];
			int var6 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize + 1];
			if (var3.type == 12) {
				class329 var7 = var3.method1844();
				if (var7 != null && var7.method1740(var10, var6)) {
					class218.invalidateWidget(var3);
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

				class218.invalidateWidget(var3);
			}

			return 1;
		} else if (var0 == 1101) {
			var3.color = Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize];
			class218.invalidateWidget(var3);
			return 1;
		} else if (var0 == 1102) {
			var3.fill = Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize] == 1;
			class218.invalidateWidget(var3);
			return 1;
		} else if (var0 == 1103) {
			var3.transparencyTop = Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize];
			class218.invalidateWidget(var3);
			return 1;
		} else if (var0 == 1104) {
			var3.lineWid = Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize];
			class218.invalidateWidget(var3);
			return 1;
		} else if (var0 == 1105) {
			var3.spriteId2 = Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize];
			class218.invalidateWidget(var3);
			return 1;
		} else if (var0 == 1106) {
			var3.spriteAngle = Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize];
			class218.invalidateWidget(var3);
			return 1;
		} else if (var0 == 1107) {
			var3.spriteTiling = Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize] == 1;
			class218.invalidateWidget(var3);
			return 1;
		} else if (var0 == 1108) {
			var3.modelType = 1;
			var3.modelId = Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize];
			class218.invalidateWidget(var3);
			return 1;
		} else if (var0 == 1109) {
			SoundCache.Interpreter_intStackSize -= 6;
			var3.modelOffsetX = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize];
			var3.modelOffsetY = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize + 1];
			var3.modelAngleX = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize + 2];
			var3.modelAngleY = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize + 3];
			var3.modelAngleZ = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize + 4];
			var3.modelZoom = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize + 5];
			class218.invalidateWidget(var3);
			return 1;
		} else if (var0 == 1110) {
			var10 = Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize];
			if (var10 != var3.sequenceId) {
				var3.sequenceId = var10;
				var3.modelFrame = 0;
				var3.modelFrameCycle = 0;
				class218.invalidateWidget(var3);
			}

			return 1;
		} else if (var0 == 1111) {
			var3.modelOrthog = Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize] == 1;
			class218.invalidateWidget(var3);
			return 1;
		} else if (var0 == 1112) {
			String var14 = Interpreter.Interpreter_stringStack[--class137.Interpreter_stringStackSize];
			if (!var14.equals(var3.text)) {
				var3.text = var14;
				class218.invalidateWidget(var3);
			}

			return 1;
		} else {
			class329 var11;
			if (var0 == 1113) {
				var3.fontId = Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize];
				if (var3.type == 12) {
					var11 = var3.method1844();
					if (var11 != null) {
						var11.method1747();
					}
				}

				class218.invalidateWidget(var3);
				return 1;
			} else if (var0 == 1114) {
				SoundCache.Interpreter_intStackSize -= 3;
				if (var3.type == 12) {
					var11 = var3.method1844();
					if (var11 != null) {
						var11.method1741(Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize], Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize + 1]);
						var11.method1742(Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize + 2]);
					}
				} else {
					var3.textXAlignment = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize];
					var3.textYAlignment = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize + 1];
					var3.textLineHeight = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize + 2];
				}

				class218.invalidateWidget(var3);
				return 1;
			} else if (var0 == 1115) {
				var3.textShadowed = Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize] == 1;
				class218.invalidateWidget(var3);
				return 1;
			} else if (var0 == 1116) {
				var3.outline = Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize];
				class218.invalidateWidget(var3);
				return 1;
			} else if (var0 == 1117) {
				var3.spriteShadow = Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize];
				class218.invalidateWidget(var3);
				return 1;
			} else if (var0 == 1118) {
				var3.spriteFlipV = Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize] == 1;
				class218.invalidateWidget(var3);
				return 1;
			} else if (var0 == 1119) {
				var3.spriteFlipH = Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize] == 1;
				class218.invalidateWidget(var3);
				return 1;
			} else if (var0 == 1120) {
				SoundCache.Interpreter_intStackSize -= 2;
				var3.scrollWidth = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize];
				var3.scrollHeight = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize + 1];
				class218.invalidateWidget(var3);
				if (var4 != -1 && var3.type == 0) {
					Login.revalidateWidgetScroll(PacketBufferNode.Widget_interfaceComponents[var4 >> 16], var3, false);
				}

				return 1;
			} else if (var0 == 1121) {
				class466.resumePauseWidget(var3.id, var3.childIndex);
				Client.meslayerContinueWidget = var3;
				class218.invalidateWidget(var3);
				return 1;
			} else if (var0 == 1122) {
				var3.spriteId = Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize];
				class218.invalidateWidget(var3);
				return 1;
			} else if (var0 == 1123) {
				var3.color2 = Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize];
				class218.invalidateWidget(var3);
				return 1;
			} else if (var0 == 1124) {
				var3.transparencyBot = Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize];
				class218.invalidateWidget(var3);
				return 1;
			} else if (var0 == 1125) {
				var10 = Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize];
				FillMode var12 = (FillMode)KeyHandler.findEnumerated(MidiPcmStream.FillMode_values(), var10);
				if (var12 != null) {
					var3.fillMode = var12;
					class218.invalidateWidget(var3);
				}

				return 1;
			} else {
				boolean var5;
				if (var0 == 1126) {
					var5 = Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize] == 1;
					var3.field2962 = var5;
					return 1;
				} else if (var0 == 1127) {
					var5 = Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize] == 1;
					var3.modelTransparency = var5;
					return 1;
				} else if (var0 == 1129) {
					var3.field3091 = Interpreter.Interpreter_stringStack[--class137.Interpreter_stringStackSize];
					class218.invalidateWidget(var3);
					return 1;
				} else if (var0 == 1130) {
					var3.method1828(Interpreter.Interpreter_stringStack[--class137.Interpreter_stringStackSize], FriendsChat.urlRequester, UrlRequester.method654());
					return 1;
				} else if (var0 == 1131) {
					SoundCache.Interpreter_intStackSize -= 2;
					var3.method1831(Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize], Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize + 1]);
					return 1;
				} else if (var0 == 1132) {
					var3.method1832(Interpreter.Interpreter_stringStack[--class137.Interpreter_stringStackSize], Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize]);
					return 1;
				} else {
					class324 var13;
					if (var0 == 1133) {
						--SoundCache.Interpreter_intStackSize;
						var13 = var3.method1845();
						if (var13 != null) {
							var13.field2892 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize];
							class218.invalidateWidget(var3);
						}

						return 1;
					} else if (var0 == 1134) {
						--SoundCache.Interpreter_intStackSize;
						var13 = var3.method1845();
						if (var13 != null) {
							var13.field2890 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize];
							class218.invalidateWidget(var3);
						}

						return 1;
					} else if (var0 == 1135) {
						--class137.Interpreter_stringStackSize;
						var11 = var3.method1844();
						if (var11 != null) {
							var3.text2 = Interpreter.Interpreter_stringStack[class137.Interpreter_stringStackSize];
						}

						return 1;
					} else if (var0 == 1136) {
						--SoundCache.Interpreter_intStackSize;
						var13 = var3.method1845();
						if (var13 != null) {
							var13.field2891 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize];
							class218.invalidateWidget(var3);
						}

						return 1;
					} else if (var0 == 1137) {
						--SoundCache.Interpreter_intStackSize;
						var11 = var3.method1844();
						if (var11 != null && var11.method1737(Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize])) {
							class218.invalidateWidget(var3);
						}

						return 1;
					} else if (var0 == 1138) {
						--SoundCache.Interpreter_intStackSize;
						var11 = var3.method1844();
						if (var11 != null && var11.method1738(Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize])) {
							class218.invalidateWidget(var3);
						}

						return 1;
					} else if (var0 == 1139) {
						--SoundCache.Interpreter_intStackSize;
						var11 = var3.method1844();
						if (var11 != null && var11.method1739(Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize])) {
							class218.invalidateWidget(var3);
						}

						return 1;
					} else {
						class329 var9;
						if (var0 == 1140) {
							var5 = Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize] == 1;
							Client.field423.method1090();
							var9 = var3.method1844();
							if (var9 != null && var9.method1731(var5)) {
								if (var5) {
									Client.field423.method1088(var3);
								}

								class218.invalidateWidget(var3);
							}

							return 1;
						} else if (var0 == 1141) {
							var5 = Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize] == 1;
							if (!var5 && Client.field423.method1089() == var3) {
								Client.field423.method1090();
								class218.invalidateWidget(var3);
							}

							var9 = var3.method1844();
							if (var9 != null) {
								var9.method1732(var5);
							}

							return 1;
						} else if (var0 == 1142) {
							SoundCache.Interpreter_intStackSize -= 2;
							var11 = var3.method1844();
							if (var11 != null && var11.method1755(Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize], Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize + 1])) {
								class218.invalidateWidget(var3);
							}

							return 1;
						} else if (var0 == 1143) {
							--SoundCache.Interpreter_intStackSize;
							var11 = var3.method1844();
							if (var11 != null && var11.method1755(Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize], Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize])) {
								class218.invalidateWidget(var3);
							}

							return 1;
						} else if (var0 == 1144) {
							--SoundCache.Interpreter_intStackSize;
							var11 = var3.method1844();
							if (var11 != null) {
								var11.method1744(Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize]);
								class218.invalidateWidget(var3);
							}

							return 1;
						} else if (var0 == 1145) {
							--SoundCache.Interpreter_intStackSize;
							var11 = var3.method1844();
							if (var11 != null) {
								var11.method1743(Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize]);
							}

							return 1;
						} else if (var0 == 1146) {
							--SoundCache.Interpreter_intStackSize;
							var11 = var3.method1844();
							if (var11 != null) {
								var11.method1746(Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize]);
							}

							return 1;
						} else if (var0 == 1147) {
							--SoundCache.Interpreter_intStackSize;
							var11 = var3.method1844();
							if (var11 != null) {
								var11.method1745(Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize]);
								class218.invalidateWidget(var3);
							}

							return 1;
						} else {
							class27 var8;
							if (var0 == 1148) {
								SoundCache.Interpreter_intStackSize -= 2;
								var8 = var3.method1846();
								if (var8 != null) {
									var8.method96(Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize], Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize + 1]);
								}

								return 1;
							} else if (var0 == 1149) {
								SoundCache.Interpreter_intStackSize -= 2;
								var8 = var3.method1846();
								if (var8 != null) {
									var8.method97((char)Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize], Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize + 1]);
								}

								return 1;
							} else if (var0 == 1150) {
								var3.method1829(Interpreter.Interpreter_stringStack[--class137.Interpreter_stringStackSize], FriendsChat.urlRequester);
								return 1;
							} else {
								return 2;
							}
						}
					}
				}
			}
		}
	}
}