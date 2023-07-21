import java.security.SecureRandom;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cc")
@Implements("SecureRandomFuture")
public class SecureRandomFuture {
	@ObfuscatedName("ud")
	static int field803;
	@ObfuscatedName("aw")
	@Export("executor")
	ExecutorService executor;
	@ObfuscatedName("ay")
	@Export("future")
	Future future;

	SecureRandomFuture() {
		this.executor = Executors.newSingleThreadExecutor();
		this.future = this.executor.submit(new SecureRandomCallable());
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "527623643"
	)
	@Export("shutdown")
	void shutdown() {
		this.executor.shutdown();
		this.executor = null;
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "62920637"
	)
	@Export("isDone")
	boolean isDone() {
		return this.future.isDone();
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(I)Ljava/security/SecureRandom;",
		garbageValue = "-1723376644"
	)
	@Export("get")
	SecureRandom get() {
		try {
			return (SecureRandom)this.future.get();
		} catch (Exception var2) {
			return WorldMapSection2.method1377();
		}
	}

	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		descriptor = "(ILdc;ZB)I",
		garbageValue = "49"
	)
	static int method448(int var0, Script var1, boolean var2) {
		int var4 = -1;
		Widget var3;
		if (var0 >= 2000) {
			var0 -= 1000;
			var4 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
			var3 = VarbitComposition.getWidget(var4);
		} else {
			var3 = var2 ? class36.scriptDotWidget : class351.scriptActiveWidget;
		}

		int var10;
		if (var0 == 1100) {
			Interpreter.Interpreter_intStackSize -= 2;
			var10 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
			int var6 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
			if (var3.type == 12) {
				class330 var7 = var3.method1805();
				if (var7 != null && var7.method1703(var10, var6)) {
					class200.invalidateWidget(var3);
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

				class200.invalidateWidget(var3);
			}

			return 1;
		} else if (var0 == 1101) {
			var3.color = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
			class200.invalidateWidget(var3);
			return 1;
		} else if (var0 == 1102) {
			var3.fill = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
			class200.invalidateWidget(var3);
			return 1;
		} else if (var0 == 1103) {
			var3.transparencyTop = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
			class200.invalidateWidget(var3);
			return 1;
		} else if (var0 == 1104) {
			var3.lineWid = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
			class200.invalidateWidget(var3);
			return 1;
		} else if (var0 == 1105) {
			var3.spriteId2 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
			class200.invalidateWidget(var3);
			return 1;
		} else if (var0 == 1106) {
			var3.spriteAngle = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
			class200.invalidateWidget(var3);
			return 1;
		} else if (var0 == 1107) {
			var3.spriteTiling = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
			class200.invalidateWidget(var3);
			return 1;
		} else if (var0 == 1108) {
			var3.modelType = 1;
			var3.modelId = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
			class200.invalidateWidget(var3);
			return 1;
		} else if (var0 == 1109) {
			Interpreter.Interpreter_intStackSize -= 6;
			var3.modelOffsetX = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
			var3.modelOffsetY = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
			var3.modelAngleX = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 2];
			var3.modelAngleY = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 3];
			var3.modelAngleZ = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 4];
			var3.modelZoom = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 5];
			class200.invalidateWidget(var3);
			return 1;
		} else if (var0 == 1110) {
			var10 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
			if (var10 != var3.sequenceId) {
				var3.sequenceId = var10;
				var3.modelFrame = 0;
				var3.modelFrameCycle = 0;
				class200.invalidateWidget(var3);
			}

			return 1;
		} else if (var0 == 1111) {
			var3.modelOrthog = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
			class200.invalidateWidget(var3);
			return 1;
		} else if (var0 == 1112) {
			String var14 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
			if (!var14.equals(var3.text)) {
				var3.text = var14;
				class200.invalidateWidget(var3);
			}

			return 1;
		} else {
			class330 var11;
			if (var0 == 1113) {
				var3.fontId = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
				if (var3.type == 12) {
					var11 = var3.method1805();
					if (var11 != null) {
						var11.method1710();
					}
				}

				class200.invalidateWidget(var3);
				return 1;
			} else if (var0 == 1114) {
				Interpreter.Interpreter_intStackSize -= 3;
				if (var3.type == 12) {
					var11 = var3.method1805();
					if (var11 != null) {
						var11.method1704(Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize], Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1]);
						var11.method1705(Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 2]);
					}
				} else {
					var3.textXAlignment = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
					var3.textYAlignment = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
					var3.textLineHeight = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 2];
				}

				class200.invalidateWidget(var3);
				return 1;
			} else if (var0 == 1115) {
				var3.textShadowed = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
				class200.invalidateWidget(var3);
				return 1;
			} else if (var0 == 1116) {
				var3.outline = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
				class200.invalidateWidget(var3);
				return 1;
			} else if (var0 == 1117) {
				var3.spriteShadow = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
				class200.invalidateWidget(var3);
				return 1;
			} else if (var0 == 1118) {
				var3.spriteFlipV = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
				class200.invalidateWidget(var3);
				return 1;
			} else if (var0 == 1119) {
				var3.spriteFlipH = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
				class200.invalidateWidget(var3);
				return 1;
			} else if (var0 == 1120) {
				Interpreter.Interpreter_intStackSize -= 2;
				var3.scrollWidth = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
				var3.scrollHeight = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
				class200.invalidateWidget(var3);
				if (var4 != -1 && var3.type == 0) {
					SoundCache.revalidateWidgetScroll(ArchiveLoader.Widget_interfaceComponents[var4 >> 16], var3, false);
				}

				return 1;
			} else if (var0 == 1121) {
				WorldMapArea.resumePauseWidget(var3.id, var3.childIndex);
				Client.meslayerContinueWidget = var3;
				class200.invalidateWidget(var3);
				return 1;
			} else if (var0 == 1122) {
				var3.spriteId = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
				class200.invalidateWidget(var3);
				return 1;
			} else if (var0 == 1123) {
				var3.color2 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
				class200.invalidateWidget(var3);
				return 1;
			} else if (var0 == 1124) {
				var3.transparencyBot = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
				class200.invalidateWidget(var3);
				return 1;
			} else if (var0 == 1125) {
				var10 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
				class525 var12 = (class525)ClientPreferences.findEnumerated(ItemLayer.FillMode_values(), var10);
				if (var12 != null) {
					var3.fillMode = var12;
					class200.invalidateWidget(var3);
				}

				return 1;
			} else {
				boolean var5;
				if (var0 == 1126) {
					var5 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
					var3.field2943 = var5;
					return 1;
				} else if (var0 == 1127) {
					var5 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
					var3.modelTransparency = var5;
					return 1;
				} else if (var0 == 1129) {
					var3.field3073 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
					class200.invalidateWidget(var3);
					return 1;
				} else if (var0 == 1130) {
					var3.method1789(Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize], WorldMapLabel.urlRequester, PendingSpawn.method515());
					return 1;
				} else if (var0 == 1131) {
					Interpreter.Interpreter_intStackSize -= 2;
					var3.method1792(Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize], Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1]);
					return 1;
				} else if (var0 == 1132) {
					var3.method1793(Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize], Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
					return 1;
				} else {
					class325 var13;
					if (var0 == 1133) {
						--Interpreter.Interpreter_intStackSize;
						var13 = var3.method1806();
						if (var13 != null) {
							var13.field2874 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
							class200.invalidateWidget(var3);
						}

						return 1;
					} else if (var0 == 1134) {
						--Interpreter.Interpreter_intStackSize;
						var13 = var3.method1806();
						if (var13 != null) {
							var13.field2875 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
							class200.invalidateWidget(var3);
						}

						return 1;
					} else if (var0 == 1135) {
						--Interpreter.Interpreter_stringStackSize;
						var11 = var3.method1805();
						if (var11 != null) {
							var3.text2 = Interpreter.Interpreter_stringStack[Interpreter.Interpreter_stringStackSize];
						}

						return 1;
					} else if (var0 == 1136) {
						--Interpreter.Interpreter_intStackSize;
						var13 = var3.method1806();
						if (var13 != null) {
							var13.field2873 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
							class200.invalidateWidget(var3);
						}

						return 1;
					} else if (var0 == 1137) {
						--Interpreter.Interpreter_intStackSize;
						var11 = var3.method1805();
						if (var11 != null && var11.method1700(Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize])) {
							class200.invalidateWidget(var3);
						}

						return 1;
					} else if (var0 == 1138) {
						--Interpreter.Interpreter_intStackSize;
						var11 = var3.method1805();
						if (var11 != null && var11.method1701(Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize])) {
							class200.invalidateWidget(var3);
						}

						return 1;
					} else if (var0 == 1139) {
						--Interpreter.Interpreter_intStackSize;
						var11 = var3.method1805();
						if (var11 != null && var11.method1702(Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize])) {
							class200.invalidateWidget(var3);
						}

						return 1;
					} else {
						class330 var9;
						if (var0 == 1140) {
							var5 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
							Client.field594.method1071();
							var9 = var3.method1805();
							if (var9 != null && var9.method1694(var5)) {
								if (var5) {
									Client.field594.method1069(var3);
								}

								class200.invalidateWidget(var3);
							}

							return 1;
						} else if (var0 == 1141) {
							var5 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
							if (!var5 && Client.field594.method1070() == var3) {
								Client.field594.method1071();
								class200.invalidateWidget(var3);
							}

							var9 = var3.method1805();
							if (var9 != null) {
								var9.method1695(var5);
							}

							return 1;
						} else if (var0 == 1142) {
							Interpreter.Interpreter_intStackSize -= 2;
							var11 = var3.method1805();
							if (var11 != null && var11.method1718(Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize], Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1])) {
								class200.invalidateWidget(var3);
							}

							return 1;
						} else if (var0 == 1143) {
							--Interpreter.Interpreter_intStackSize;
							var11 = var3.method1805();
							if (var11 != null && var11.method1718(Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize], Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize])) {
								class200.invalidateWidget(var3);
							}

							return 1;
						} else if (var0 == 1144) {
							--Interpreter.Interpreter_intStackSize;
							var11 = var3.method1805();
							if (var11 != null) {
								var11.method1707(Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize]);
								class200.invalidateWidget(var3);
							}

							return 1;
						} else if (var0 == 1145) {
							--Interpreter.Interpreter_intStackSize;
							var11 = var3.method1805();
							if (var11 != null) {
								var11.method1706(Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize]);
							}

							return 1;
						} else if (var0 == 1146) {
							--Interpreter.Interpreter_intStackSize;
							var11 = var3.method1805();
							if (var11 != null) {
								var11.method1709(Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize]);
							}

							return 1;
						} else if (var0 == 1147) {
							--Interpreter.Interpreter_intStackSize;
							var11 = var3.method1805();
							if (var11 != null) {
								var11.method1708(Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize]);
								class200.invalidateWidget(var3);
							}

							return 1;
						} else {
							class27 var8;
							if (var0 == 1148) {
								Interpreter.Interpreter_intStackSize -= 2;
								var8 = var3.method1807();
								if (var8 != null) {
									var8.method102(Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize], Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1]);
								}

								return 1;
							} else if (var0 == 1149) {
								Interpreter.Interpreter_intStackSize -= 2;
								var8 = var3.method1807();
								if (var8 != null) {
									var8.method103((char)Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize], Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1]);
								}

								return 1;
							} else if (var0 == 1150) {
								var3.method1790(Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize], WorldMapLabel.urlRequester);
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
