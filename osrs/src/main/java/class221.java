import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.awt.datatransfer.Clipboard;

@ObfuscatedName("ij")
public class class221 implements class29 {
	@ObfuscatedName("pk")
	static int field1877;
	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "Lnn;"
	)
	Widget field1880;
	@ObfuscatedName("ah")
	boolean field1878;
	@ObfuscatedName("ar")
	boolean field1879;

	public class221() {
		this.field1880 = null;
		this.field1878 = false;
		this.field1879 = false;
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(IS)Z",
		garbageValue = "512"
	)
	@Export("vmethod3949")
	public boolean vmethod3949(int var1) {
		if (this.field1880 == null) {
			return false;
		} else {
			class27 var2 = this.field1880.method1873();
			if (var2 == null) {
				return false;
			} else {
				if (var2.method119(var1)) {
					switch(var1) {
					case 81:
						this.field1879 = true;
						break;
					case 82:
						this.field1878 = true;
						break;
					default:
						if (this.method1119(var1)) {
							class159.invalidateWidget(this.field1880);
						}
					}
				}

				return var2.method117(var1);
			}
		}
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(II)Z",
		garbageValue = "-1146773117"
	)
	public boolean vmethod3989(int var1) {
		switch(var1) {
		case 81:
			this.field1879 = false;
			return false;
		case 82:
			this.field1878 = false;
			return false;
		default:
			return false;
		}
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(CI)Z",
		garbageValue = "984376689"
	)
	@Export("vmethod3951")
	public boolean vmethod3951(char var1) {
		if (this.field1880 == null) {
			return false;
		} else if (!DirectByteArrayCopier.method1884(var1)) {
			return false;
		} else {
			class341 var2 = this.field1880.method1871();
			if (var2 != null && var2.method1815()) {
				class27 var3 = this.field1880.method1873();
				if (var3 == null) {
					return false;
				} else {
					if (var3.method120(var1) && var2.method1776(var1)) {
						class159.invalidateWidget(this.field1880);
					}

					return var3.method118(var1);
				}
			} else {
				return false;
			}
		}
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(ZB)Z",
		garbageValue = "-49"
	)
	@Export("vmethod3953")
	public boolean vmethod3953(boolean var1) {
		return false;
	}

	@ObfuscatedName("av")
	@ObfuscatedSignature(
		descriptor = "(Lnn;I)V",
		garbageValue = "950407656"
	)
	public void method1112(Widget var1) {
		if (var1 != null) {
			if (var1 != this.field1880) {
				this.method1114();
				this.field1880 = var1;
			}

			class339 var2 = var1.method1874();
			if (var2 != null) {
				if (!var2.field2934.method1810() && var2.field2931 != null) {
					ScriptEvent var3 = new ScriptEvent();
					var3.method467(var1);
					var3.setArgs(var2.field2931);
					FileSystem.getScriptEvents().addFirst(var3);
				}

				var2.field2934.method1759(true);
			}
		} else {
			this.method1114();
		}

	}

	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "(S)Lnn;",
		garbageValue = "-15065"
	)
	public Widget method1113() {
		return this.field1880;
	}

	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-881991302"
	)
	public void method1114() {
		if (this.field1880 != null) {
			class339 var1 = this.field1880.method1874();
			Widget var2 = this.field1880;
			this.field1880 = null;
			if (var1 != null) {
				if (var1.field2934.method1810() && var1.field2931 != null) {
					ScriptEvent var3 = new ScriptEvent();
					var3.method467(var2);
					var3.setArgs(var1.field2931);
					FileSystem.getScriptEvents().addFirst(var3);
				}

				var1.field2934.method1759(false);
			}
		}
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(IB)Z",
		garbageValue = "2"
	)
	boolean method1119(int var1) {
		if (this.field1880 == null) {
			return false;
		} else {
			class341 var2 = this.field1880.method1871();
			if (var2 != null && var2.method1815()) {
				Clipboard var5;
				switch(var1) {
				case 13:
					this.method1114();
					return true;
				case 48:
					if (this.field1878) {
						var2.method1782();
					}

					return true;
				case 65:
					if (this.field1878) {
						var5 = SpriteMask.client.getClipboard();
						var2.method1801(var5);
					}

					return true;
				case 66:
					if (this.field1878) {
						var5 = SpriteMask.client.getClipboard();
						var2.method1800(var5);
					}

					return true;
				case 67:
					if (this.field1878) {
						var5 = SpriteMask.client.getClipboard();
						var2.method1802(var5);
					}

					return true;
				case 84:
					if (var2.method1821() == 0) {
						var2.method1776(10);
					} else if (this.field1879 && var2.method1825()) {
						var2.method1776(10);
					} else {
						class339 var3 = this.field1880.method1874();
						ScriptEvent var4 = new ScriptEvent();
						var4.method467(this.field1880);
						var4.setArgs(var3.field2930);
						FileSystem.getScriptEvents().addFirst(var4);
						this.method1114();
					}

					return true;
				case 85:
					if (this.field1878) {
						var2.method1779();
					} else {
						var2.method1777();
					}

					return true;
				case 96:
					if (this.field1878) {
						var2.method1790(this.field1879);
					} else {
						var2.method1788(this.field1879);
					}

					return true;
				case 97:
					if (this.field1878) {
						var2.method1791(this.field1879);
					} else {
						var2.method1789(this.field1879);
					}

					return true;
				case 98:
					if (this.field1878) {
						var2.method1803();
					} else {
						var2.method1792(this.field1879);
					}

					return true;
				case 99:
					if (this.field1878) {
						var2.method1804();
					} else {
						var2.method1793(this.field1879);
					}

					return true;
				case 101:
					if (this.field1878) {
						var2.method1780();
					} else {
						var2.method1778();
					}

					return true;
				case 102:
					if (this.field1878) {
						var2.method1786(this.field1879);
					} else {
						var2.method1784(this.field1879);
					}

					return true;
				case 103:
					if (this.field1878) {
						var2.method1787(this.field1879);
					} else {
						var2.method1785(this.field1879);
					}

					return true;
				case 104:
					if (this.field1878) {
						var2.method1796(this.field1879);
					} else {
						var2.method1794(this.field1879);
					}

					return true;
				case 105:
					if (this.field1878) {
						var2.method1797(this.field1879);
					} else {
						var2.method1795(this.field1879);
					}

					return true;
				default:
					return false;
				}
			} else {
				return false;
			}
		}
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(B)[Laa;",
		garbageValue = "-14"
	)
	public static class6[] method1111() {
		return new class6[]{class6.field9};
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(Luo;I)V",
		garbageValue = "-620397215"
	)
	static final void method1120(PacketBuffer var0) {
		int var1 = 0;
		var0.importIndex();

		byte[] var10000;
		int var2;
		int var3;
		int var4;
		for (var2 = 0; var2 < Players.Players_count; ++var2) {
			var3 = Players.Players_indices[var2];
			if ((Players.activityFlags[var3] & 1) == 0) {
				if (var1 > 0) {
					--var1;
					var10000 = Players.activityFlags;
					var10000[var3] = (byte)(var10000[var3] | 2);
				} else {
					var4 = var0.readBits(1);
					if (var4 == 0) {
						var1 = Client.method361(var0);
						var10000 = Players.activityFlags;
						var10000[var3] = (byte)(var10000[var3] | 2);
					} else {
						class9.readPlayerUpdate(var0, var3);
					}
				}
			}
		}

		var0.exportIndex();
		if (var1 != 0) {
			throw new RuntimeException();
		} else {
			var0.importIndex();

			for (var2 = 0; var2 < Players.Players_count; ++var2) {
				var3 = Players.Players_indices[var2];
				if ((Players.activityFlags[var3] & 1) != 0) {
					if (var1 > 0) {
						--var1;
						var10000 = Players.activityFlags;
						var10000[var3] = (byte)(var10000[var3] | 2);
					} else {
						var4 = var0.readBits(1);
						if (var4 == 0) {
							var1 = Client.method361(var0);
							var10000 = Players.activityFlags;
							var10000[var3] = (byte)(var10000[var3] | 2);
						} else {
							class9.readPlayerUpdate(var0, var3);
						}
					}
				}
			}

			var0.exportIndex();
			if (var1 != 0) {
				throw new RuntimeException();
			} else {
				var0.importIndex();

				for (var2 = 0; var2 < Players.Players_emptyIdxCount; ++var2) {
					var3 = Players.Players_emptyIndices[var2];
					if ((Players.activityFlags[var3] & 1) != 0) {
						if (var1 > 0) {
							--var1;
							var10000 = Players.activityFlags;
							var10000[var3] = (byte)(var10000[var3] | 2);
						} else {
							var4 = var0.readBits(1);
							if (var4 == 0) {
								var1 = Client.method361(var0);
								var10000 = Players.activityFlags;
								var10000[var3] = (byte)(var10000[var3] | 2);
							} else if (Buddy.updateExternalPlayer(var0, var3)) {
								var10000 = Players.activityFlags;
								var10000[var3] = (byte)(var10000[var3] | 2);
							}
						}
					}
				}

				var0.exportIndex();
				if (var1 != 0) {
					throw new RuntimeException();
				} else {
					var0.importIndex();

					for (var2 = 0; var2 < Players.Players_emptyIdxCount; ++var2) {
						var3 = Players.Players_emptyIndices[var2];
						if ((Players.activityFlags[var3] & 1) == 0) {
							if (var1 > 0) {
								--var1;
								var10000 = Players.activityFlags;
								var10000[var3] = (byte)(var10000[var3] | 2);
							} else {
								var4 = var0.readBits(1);
								if (var4 == 0) {
									var1 = Client.method361(var0);
									var10000 = Players.activityFlags;
									var10000[var3] = (byte)(var10000[var3] | 2);
								} else if (Buddy.updateExternalPlayer(var0, var3)) {
									var10000 = Players.activityFlags;
									var10000[var3] = (byte)(var10000[var3] | 2);
								}
							}
						}
					}

					var0.exportIndex();
					if (var1 != 0) {
						throw new RuntimeException();
					} else {
						Players.Players_count = 0;
						Players.Players_emptyIdxCount = 0;

						for (var2 = 1; var2 < 2048; ++var2) {
							var10000 = Players.activityFlags;
							var10000[var2] = (byte)(var10000[var2] >> 1);
							Player var5 = Client.players[var2];
							if (var5 != null) {
								Players.Players_indices[++Players.Players_count - 1] = var2;
							} else {
								Players.Players_emptyIndices[++Players.Players_emptyIdxCount - 1] = var2;
							}
						}

					}
				}
			}
		}
	}
}