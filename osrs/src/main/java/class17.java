import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSessionContext;
import javax.security.cert.X509Certificate;
import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.security.cert.Certificate;

@ObfuscatedName("au")
class class17 implements SSLSession {
	@ObfuscatedName("ku")
	@Export("cameraY")
	static int cameraY;
	// $FF: synthetic field
	@ObfuscatedSignature(
		descriptor = "Lap;"
	)
	@Export("this$1")
	@ObfuscatedName("this$1")
	final class12 this$1;

	@ObfuscatedSignature(
		descriptor = "(Lap;)V"
	)
	class17(class12 var1) {
		this.this$1 = var1;
	}

	public int getApplicationBufferSize() {
		return 0;
	}

	public String getCipherSuite() {
		throw new UnsupportedOperationException();
	}

	public long getCreationTime() {
		throw new UnsupportedOperationException();
	}

	@Export("getId")
	@ObfuscatedName("getId")
	public byte[] getId() {
		throw new UnsupportedOperationException();
	}

	public long getLastAccessedTime() {
		throw new UnsupportedOperationException();
	}

	public Certificate[] getLocalCertificates() {
		throw new UnsupportedOperationException();
	}

	public Principal getLocalPrincipal() {
		throw new UnsupportedOperationException();
	}

	public int getPacketBufferSize() {
		throw new UnsupportedOperationException();
	}

	public X509Certificate[] getPeerCertificateChain() throws SSLPeerUnverifiedException {
		return null;
	}

	public Certificate[] getPeerCertificates() throws SSLPeerUnverifiedException {
		return this.this$1.field34;
	}

	public String getPeerHost() {
		throw new UnsupportedOperationException();
	}

	public int getPeerPort() {
		return 0;
	}

	@Export("getPeerPrincipal")
	@ObfuscatedName("getPeerPrincipal")
	public Principal getPeerPrincipal() throws SSLPeerUnverifiedException {
		return null;
	}

	public String getProtocol() {
		throw new UnsupportedOperationException();
	}

	public SSLSessionContext getSessionContext() {
		throw new UnsupportedOperationException();
	}

	@Export("getValue")
	@ObfuscatedName("getValue")
	public Object getValue(String var1) {
		throw new UnsupportedOperationException();
	}

	public String[] getValueNames() {
		throw new UnsupportedOperationException();
	}

	@Export("invalidate")
	@ObfuscatedName("invalidate")
	public void invalidate() {
		throw new UnsupportedOperationException();
	}

	@Export("isValid")
	@ObfuscatedName("isValid")
	public boolean isValid() {
		throw new UnsupportedOperationException();
	}

	@Export("putValue")
	@ObfuscatedName("putValue")
	public void putValue(String var1, Object var2) {
		throw new UnsupportedOperationException();
	}

	@Export("removeValue")
	@ObfuscatedName("removeValue")
	public void removeValue(String var1) {
		throw new UnsupportedOperationException();
	}

	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;Ljava/lang/String;ZB)Lto;",
		garbageValue = "110"
	)
	@Export("getPreferencesFile")
	public static AccessFile getPreferencesFile(String var0, String var1, boolean var2) {
		File var3 = new File(class500.cacheDir, "preferences" + var0 + ".dat");
		if (var3.exists()) {
			try {
				AccessFile var10 = new AccessFile(var3, "rw", 10000L);
				return var10;
			} catch (IOException var9) {
			}
		}

		String var4 = "";
		if (FileSystem.cacheGamebuild == 33) {
			var4 = "_rc";
		} else if (FileSystem.cacheGamebuild == 34) {
			var4 = "_wip";
		}

		File var5 = new File(DevicePcmPlayerProvider.userHomeDirectory, "jagex_" + var1 + "_preferences" + var0 + var4 + ".dat");
		AccessFile var6;
		if (!var2 && var5.exists()) {
			try {
				var6 = new AccessFile(var5, "rw", 10000L);
				return var6;
			} catch (IOException var8) {
			}
		}

		try {
			var6 = new AccessFile(var3, "rw", 10000L);
			return var6;
		} catch (IOException var7) {
			throw new RuntimeException();
		}
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(ILds;ZI)I",
		garbageValue = "201012705"
	)
	static int method56(int var0, Script var1, boolean var2) {
		int var4 = -1;
		Widget var3;
		if (var0 >= 2000) {
			var0 -= 1000;
			var4 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
			var3 = class33.field89.method1740(var4);
		} else {
			var3 = var2 ? class416.scriptDotWidget : class306.scriptActiveWidget;
		}

		int var10;
		if (var0 == 1100) {
			Interpreter.Interpreter_intStackSize -= 2;
			var10 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
			int var6 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
			if (var3.type == 12) {
				class344 var7 = var3.method1877();
				if (var7 != null && var7.method1772(var10, var6)) {
					ClanChannelMember.invalidateWidget(var3);
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

				ClanChannelMember.invalidateWidget(var3);
			}

			return 1;
		} else if (var0 == 1101) {
			var3.color = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
			ClanChannelMember.invalidateWidget(var3);
			return 1;
		} else if (var0 == 1102) {
			var3.fill = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
			ClanChannelMember.invalidateWidget(var3);
			return 1;
		} else if (var0 == 1103) {
			var3.transparencyTop = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
			ClanChannelMember.invalidateWidget(var3);
			return 1;
		} else if (var0 == 1104) {
			var3.lineWid = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
			ClanChannelMember.invalidateWidget(var3);
			return 1;
		} else if (var0 == 1105) {
			var3.spriteId2 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
			ClanChannelMember.invalidateWidget(var3);
			return 1;
		} else if (var0 == 1106) {
			var3.spriteAngle = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
			ClanChannelMember.invalidateWidget(var3);
			return 1;
		} else if (var0 == 1107) {
			var3.spriteTiling = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
			ClanChannelMember.invalidateWidget(var3);
			return 1;
		} else if (var0 == 1108) {
			var3.modelType = 1;
			var3.modelId = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
			ClanChannelMember.invalidateWidget(var3);
			return 1;
		} else if (var0 == 1109) {
			Interpreter.Interpreter_intStackSize -= 6;
			var3.modelOffsetX = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
			var3.modelOffsetY = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
			var3.modelAngleX = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 2];
			var3.modelAngleY = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 3];
			var3.modelAngleZ = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 4];
			var3.modelZoom = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 5];
			ClanChannelMember.invalidateWidget(var3);
			return 1;
		} else if (var0 == 1110) {
			var10 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
			if (var10 != var3.sequenceId) {
				var3.sequenceId = var10;
				var3.modelFrame = 0;
				var3.modelFrameCycle = 0;
				ClanChannelMember.invalidateWidget(var3);
			}

			return 1;
		} else if (var0 == 1111) {
			var3.modelOrthog = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
			ClanChannelMember.invalidateWidget(var3);
			return 1;
		} else {
			class344 var9;
			if (var0 != 1112) {
				class344 var12;
				if (var0 == 1113) {
					var3.fontId = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
					if (var3.type == 12) {
						var12 = var3.method1877();
						if (var12 != null) {
							var12.method1779();
						}
					}

					ClanChannelMember.invalidateWidget(var3);
					return 1;
				} else if (var0 == 1114) {
					Interpreter.Interpreter_intStackSize -= 3;
					if (var3.type == 12) {
						var12 = var3.method1877();
						if (var12 != null) {
							var12.method1773(Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize], Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1]);
							var12.method1774(Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 2]);
						}
					} else {
						var3.textXAlignment = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
						var3.textYAlignment = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
						var3.textLineHeight = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 2];
					}

					ClanChannelMember.invalidateWidget(var3);
					return 1;
				} else if (var0 == 1115) {
					var3.textShadowed = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
					ClanChannelMember.invalidateWidget(var3);
					return 1;
				} else if (var0 == 1116) {
					var3.outline = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
					ClanChannelMember.invalidateWidget(var3);
					return 1;
				} else if (var0 == 1117) {
					var3.spriteShadow = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
					ClanChannelMember.invalidateWidget(var3);
					return 1;
				} else if (var0 == 1118) {
					var3.spriteFlipV = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
					ClanChannelMember.invalidateWidget(var3);
					return 1;
				} else if (var0 == 1119) {
					var3.spriteFlipH = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
					ClanChannelMember.invalidateWidget(var3);
					return 1;
				} else if (var0 == 1120) {
					Interpreter.Interpreter_intStackSize -= 2;
					var3.scrollWidth = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
					var3.scrollHeight = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
					ClanChannelMember.invalidateWidget(var3);
					if (var4 != -1 && var3.type == 0) {
						PendingSpawn.revalidateWidgetScroll(class33.field89.Widget_interfaceComponents[var4 >> 16], var3, false);
					}

					return 1;
				} else if (var0 == 1121) {
					class174.resumePauseWidget(var3.id, var3.childIndex);
					Client.meslayerContinueWidget = var3;
					ClanChannelMember.invalidateWidget(var3);
					return 1;
				} else if (var0 == 1122) {
					var3.spriteId = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
					ClanChannelMember.invalidateWidget(var3);
					return 1;
				} else if (var0 == 1123) {
					var3.color2 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
					ClanChannelMember.invalidateWidget(var3);
					return 1;
				} else if (var0 == 1124) {
					var3.transparencyBot = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
					ClanChannelMember.invalidateWidget(var3);
					return 1;
				} else if (var0 == 1125) {
					var10 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
					class541 var13 = (class541)SequenceDefinition.findEnumerated(class472.FillMode_values(), var10);
					if (var13 != null) {
						var3.fillMode = var13;
						ClanChannelMember.invalidateWidget(var3);
					}

					return 1;
				} else {
					boolean var5;
					if (var0 == 1126) {
						var5 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
						var3.field2989 = var5;
						return 1;
					} else if (var0 == 1127) {
						var5 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
						var3.modelTransparency = var5;
						return 1;
					} else if (var0 == 1129) {
						var3.field3119 = Interpreter.Interpreter_stringStack[--class180.Interpreter_stringStackSize];
						ClanChannelMember.invalidateWidget(var3);
						return 1;
					} else if (var0 == 1130) {
						var3.method1861(Interpreter.Interpreter_stringStack[--class180.Interpreter_stringStackSize], AbstractWorldMapIcon.urlRequester, class304.method1635());
						return 1;
					} else if (var0 == 1131) {
						Interpreter.Interpreter_intStackSize -= 2;
						var3.method1864(Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize], Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1]);
						return 1;
					} else if (var0 == 1132) {
						var3.method1865(Interpreter.Interpreter_stringStack[--class180.Interpreter_stringStackSize], Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
						return 1;
					} else {
						class339 var14;
						if (var0 == 1133) {
							--Interpreter.Interpreter_intStackSize;
							var14 = var3.method1878();
							if (var14 != null) {
								var14.field2923 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
								ClanChannelMember.invalidateWidget(var3);
							}

							return 1;
						} else if (var0 == 1134) {
							--Interpreter.Interpreter_intStackSize;
							var14 = var3.method1878();
							if (var14 != null) {
								var14.field2925 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
								ClanChannelMember.invalidateWidget(var3);
							}

							return 1;
						} else if (var0 == 1135) {
							--class180.Interpreter_stringStackSize;
							var12 = var3.method1877();
							if (var12 != null) {
								var3.text2 = Interpreter.Interpreter_stringStack[class180.Interpreter_stringStackSize];
							}

							return 1;
						} else if (var0 == 1136) {
							--Interpreter.Interpreter_intStackSize;
							var14 = var3.method1878();
							if (var14 != null) {
								var14.field2924 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
								ClanChannelMember.invalidateWidget(var3);
							}

							return 1;
						} else if (var0 == 1137) {
							--Interpreter.Interpreter_intStackSize;
							var12 = var3.method1877();
							if (var12 != null && var12.method1769(Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize])) {
								ClanChannelMember.invalidateWidget(var3);
							}

							return 1;
						} else if (var0 == 1138) {
							--Interpreter.Interpreter_intStackSize;
							var12 = var3.method1877();
							if (var12 != null && var12.method1770(Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize])) {
								ClanChannelMember.invalidateWidget(var3);
							}

							return 1;
						} else if (var0 == 1139) {
							--Interpreter.Interpreter_intStackSize;
							var12 = var3.method1877();
							if (var12 != null && var12.method1771(Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize])) {
								ClanChannelMember.invalidateWidget(var3);
							}

							return 1;
						} else if (var0 == 1140) {
							var5 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
							Client.field422.method1134();
							var9 = var3.method1877();
							if (var9 != null && var9.method1763(var5)) {
								if (var5) {
									Client.field422.method1132(var3);
								}

								ClanChannelMember.invalidateWidget(var3);
							}

							return 1;
						} else if (var0 == 1141) {
							var5 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
							if (!var5 && Client.field422.method1133() == var3) {
								Client.field422.method1134();
								ClanChannelMember.invalidateWidget(var3);
							}

							var9 = var3.method1877();
							if (var9 != null) {
								var9.method1764(var5);
							}

							return 1;
						} else if (var0 == 1142) {
							Interpreter.Interpreter_intStackSize -= 2;
							var12 = var3.method1877();
							if (var12 != null && var12.method1787(Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize], Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1])) {
								ClanChannelMember.invalidateWidget(var3);
							}

							return 1;
						} else if (var0 == 1143) {
							--Interpreter.Interpreter_intStackSize;
							var12 = var3.method1877();
							if (var12 != null && var12.method1787(Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize], Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize])) {
								ClanChannelMember.invalidateWidget(var3);
							}

							return 1;
						} else if (var0 == 1144) {
							--Interpreter.Interpreter_intStackSize;
							var12 = var3.method1877();
							if (var12 != null) {
								var12.method1776(Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize]);
								ClanChannelMember.invalidateWidget(var3);
							}

							return 1;
						} else if (var0 == 1145) {
							--Interpreter.Interpreter_intStackSize;
							var12 = var3.method1877();
							if (var12 != null) {
								var12.method1775(Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize]);
							}

							return 1;
						} else if (var0 == 1146) {
							--Interpreter.Interpreter_intStackSize;
							var12 = var3.method1877();
							if (var12 != null) {
								var12.method1778(Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize]);
							}

							return 1;
						} else if (var0 == 1147) {
							--Interpreter.Interpreter_intStackSize;
							var12 = var3.method1877();
							if (var12 != null) {
								var12.method1777(Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize]);
								ClanChannelMember.invalidateWidget(var3);
							}

							return 1;
						} else {
							class27 var11;
							if (var0 == 1148) {
								Interpreter.Interpreter_intStackSize -= 2;
								var11 = var3.method1879();
								if (var11 != null) {
									var11.method102(Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize], Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1]);
								}

								return 1;
							} else if (var0 == 1149) {
								Interpreter.Interpreter_intStackSize -= 2;
								var11 = var3.method1879();
								if (var11 != null) {
									var11.method104((char)Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize], Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1]);
								}

								return 1;
							} else if (var0 == 1150) {
								var3.method1862(Interpreter.Interpreter_stringStack[--class180.Interpreter_stringStackSize], AbstractWorldMapIcon.urlRequester);
								return 1;
							} else {
								return 2;
							}
						}
					}
				}
			} else {
				String var8 = Interpreter.Interpreter_stringStack[--class180.Interpreter_stringStackSize];
				if (!var8.equals(var3.text)) {
					if (var3.type == 12) {
						var9 = var3.method1877();
						if (var9 != null && var9.method1819()) {
							var9.method1765(var8);
						} else {
							var3.text = var8;
						}
					} else {
						var3.text = var8;
					}

					ClanChannelMember.invalidateWidget(var3);
				}

				return 1;
			}
		}
	}

	@ObfuscatedName("bi")
	@ObfuscatedSignature(
		descriptor = "(ILds;ZI)I",
		garbageValue = "-236516761"
	)
	static int method57(int var0, Script var1, boolean var2) {
		if (var0 == 7108) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = VarcInt.method976() ? 1 : 0;
			return 1;
		} else {
			return 2;
		}
	}
}