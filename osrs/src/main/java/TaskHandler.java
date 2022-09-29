import java.io.DataInputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fr")
@Implements("TaskHandler")
public class TaskHandler implements Runnable {
	@ObfuscatedName("c")
	@Export("javaVendor")
	public static String javaVendor;
	@ObfuscatedName("p")
	@Export("javaVersion")
	public static String javaVersion;
	@ObfuscatedName("fj")
	@ObfuscatedGetter(
		intValue = -835811821
	)
	@Export("js5Port")
	static int js5Port;
	@ObfuscatedName("jf")
	@ObfuscatedGetter(
		intValue = -1847541183
	)
	@Export("cameraX")
	static int cameraX;
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		descriptor = "Lfk;"
	)
	@Export("current")
	Task current;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		descriptor = "Lfk;"
	)
	@Export("task")
	Task task;
	@ObfuscatedName("k")
	@Export("thread")
	Thread thread;
	@ObfuscatedName("w")
	@Export("isClosed")
	boolean isClosed;

	public TaskHandler() {
		this.current = null;
		this.task = null;
		this.isClosed = false;
		javaVendor = "Unknown";
		javaVersion = "1.6";

		try {
			javaVendor = System.getProperty("java.vendor");
			javaVersion = System.getProperty("java.version");
		} catch (Exception var2) {
		}

		this.isClosed = false;
		this.thread = new Thread(this);
		this.thread.setPriority(10);
		this.thread.setDaemon(true);
		this.thread.start();
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "1156795430"
	)
	@Export("close")
	public final void close() {
		synchronized(this) {
			this.isClosed = true;
			this.notifyAll();
		}

		try {
			this.thread.join();
		} catch (InterruptedException var3) {
		}

	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		descriptor = "(IIILjava/lang/Object;I)Lfk;",
		garbageValue = "-721329580"
	)
	@Export("newTask")
	final Task newTask(int var1, int var2, int var3, Object var4) {
		Task var5 = new Task();
		var5.type = var1;
		var5.intArgument = var2;
		var5.objectArgument = var4;
		synchronized(this) {
			if (this.task != null) {
				this.task.next = var5;
				this.task = var5;
			} else {
				this.task = this.current = var5;
			}

			this.notify();
			return var5;
		}
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;IB)Lfk;",
		garbageValue = "20"
	)
	@Export("newSocketTask")
	public final Task newSocketTask(String var1, int var2) {
		return this.newTask(1, var2, 0, var1);
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/Runnable;II)Lfk;",
		garbageValue = "-1090757177"
	)
	@Export("newThreadTask")
	public final Task newThreadTask(Runnable var1, int var2) {
		return this.newTask(2, var2, 0, var1);
	}

	public final void run() {
		while (true) {
			Task var1;
			synchronized(this) {
				while (true) {
					if (this.isClosed) {
						return;
					}

					if (this.current != null) {
						var1 = this.current;
						this.current = this.current.next;
						if (this.current == null) {
							this.task = null;
						}
						break;
					}

					try {
						this.wait();
					} catch (InterruptedException var8) {
					}
				}
			}

			try {
				int var5 = var1.type;
				if (var5 == 1) {
					var1.result = new Socket(InetAddress.getByName((String)var1.objectArgument), var1.intArgument);
				} else if (var5 == 2) {
					Thread var3 = new Thread((Runnable)var1.objectArgument);
					var3.setDaemon(true);
					var3.start();
					var3.setPriority(var1.intArgument);
					var1.result = var3;
				} else if (var5 == 4) {
					var1.result = new DataInputStream(((URL)var1.objectArgument).openStream());
				}

				var1.status = 1;
			} catch (ThreadDeath var6) {
				throw var6;
			} catch (Throwable var7) {
				var1.status = 2;
			}
		}
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "(Llv;Llv;ZI)V",
		garbageValue = "-877084978"
	)
	public static void method3429(AbstractArchive var0, AbstractArchive var1, boolean var2) {
		ObjectComposition.ObjectDefinition_archive = var0;
		ObjectComposition.ObjectDefinition_modelsArchive = var1;
		ObjectComposition.ObjectDefinition_isLowDetail = var2;
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		descriptor = "(IILgb;Lgj;I)Z",
		garbageValue = "-211862078"
	)
	public static final boolean method3431(int var0, int var1, RouteStrategy var2, CollisionMap var3) {
		int var4 = var0;
		int var5 = var1;
		byte var6 = 64;
		byte var7 = 64;
		int var8 = var0 - var6;
		int var9 = var1 - var7;
		class194.directions[var6][var7] = 99;
		class194.distances[var6][var7] = 0;
		byte var10 = 0;
		int var11 = 0;
		class194.bufferX[var10] = var0;
		byte var10001 = var10;
		int var18 = var10 + 1;
		class194.bufferY[var10001] = var1;
		int[][] var12 = var3.flags;

		while (var18 != var11) {
			var4 = class194.bufferX[var11];
			var5 = class194.bufferY[var11];
			var11 = var11 + 1 & 4095;
			int var16 = var4 - var8;
			int var17 = var5 - var9;
			int var13 = var4 - var3.xInset;
			int var14 = var5 - var3.yInset;
			if (var2.hasArrived(2, var4, var5, var3)) {
				Bounds.field4422 = var4;
				class347.field4205 = var5;
				return true;
			}

			int var15 = class194.distances[var16][var17] + 1;
			if (var16 > 0 && class194.directions[var16 - 1][var17] == 0 && (var12[var13 - 1][var14] & 19136782) == 0 && (var12[var13 - 1][var14 + 1] & 19136824) == 0) {
				class194.bufferX[var18] = var4 - 1;
				class194.bufferY[var18] = var5;
				var18 = var18 + 1 & 4095;
				class194.directions[var16 - 1][var17] = 2;
				class194.distances[var16 - 1][var17] = var15;
			}

			if (var16 < 126 && class194.directions[var16 + 1][var17] == 0 && (var12[var13 + 2][var14] & 19136899) == 0 && (var12[var13 + 2][var14 + 1] & 19136992) == 0) {
				class194.bufferX[var18] = var4 + 1;
				class194.bufferY[var18] = var5;
				var18 = var18 + 1 & 4095;
				class194.directions[var16 + 1][var17] = 8;
				class194.distances[var16 + 1][var17] = var15;
			}

			if (var17 > 0 && class194.directions[var16][var17 - 1] == 0 && (var12[var13][var14 - 1] & 19136782) == 0 && (var12[var13 + 1][var14 - 1] & 19136899) == 0) {
				class194.bufferX[var18] = var4;
				class194.bufferY[var18] = var5 - 1;
				var18 = var18 + 1 & 4095;
				class194.directions[var16][var17 - 1] = 1;
				class194.distances[var16][var17 - 1] = var15;
			}

			if (var17 < 126 && class194.directions[var16][var17 + 1] == 0 && (var12[var13][var14 + 2] & 19136824) == 0 && (var12[var13 + 1][var14 + 2] & 19136992) == 0) {
				class194.bufferX[var18] = var4;
				class194.bufferY[var18] = var5 + 1;
				var18 = var18 + 1 & 4095;
				class194.directions[var16][var17 + 1] = 4;
				class194.distances[var16][var17 + 1] = var15;
			}

			if (var16 > 0 && var17 > 0 && class194.directions[var16 - 1][var17 - 1] == 0 && (var12[var13 - 1][var14] & 19136830) == 0 && (var12[var13 - 1][var14 - 1] & 19136782) == 0 && (var12[var13][var14 - 1] & 19136911) == 0) {
				class194.bufferX[var18] = var4 - 1;
				class194.bufferY[var18] = var5 - 1;
				var18 = var18 + 1 & 4095;
				class194.directions[var16 - 1][var17 - 1] = 3;
				class194.distances[var16 - 1][var17 - 1] = var15;
			}

			if (var16 < 126 && var17 > 0 && class194.directions[var16 + 1][var17 - 1] == 0 && (var12[var13 + 1][var14 - 1] & 19136911) == 0 && (var12[var13 + 2][var14 - 1] & 19136899) == 0 && (var12[var13 + 2][var14] & 19136995) == 0) {
				class194.bufferX[var18] = var4 + 1;
				class194.bufferY[var18] = var5 - 1;
				var18 = var18 + 1 & 4095;
				class194.directions[var16 + 1][var17 - 1] = 9;
				class194.distances[var16 + 1][var17 - 1] = var15;
			}

			if (var16 > 0 && var17 < 126 && class194.directions[var16 - 1][var17 + 1] == 0 && (var12[var13 - 1][var14 + 1] & 19136830) == 0 && (var12[var13 - 1][var14 + 2] & 19136824) == 0 && (var12[var13][var14 + 2] & 19137016) == 0) {
				class194.bufferX[var18] = var4 - 1;
				class194.bufferY[var18] = var5 + 1;
				var18 = var18 + 1 & 4095;
				class194.directions[var16 - 1][var17 + 1] = 6;
				class194.distances[var16 - 1][var17 + 1] = var15;
			}

			if (var16 < 126 && var17 < 126 && class194.directions[var16 + 1][var17 + 1] == 0 && (var12[var13 + 1][var14 + 2] & 19137016) == 0 && (var12[var13 + 2][var14 + 2] & 19136992) == 0 && (var12[var13 + 2][var14 + 1] & 19136995) == 0) {
				class194.bufferX[var18] = var4 + 1;
				class194.bufferY[var18] = var5 + 1;
				var18 = var18 + 1 & 4095;
				class194.directions[var16 + 1][var17 + 1] = 12;
				class194.distances[var16 + 1][var17 + 1] = var15;
			}
		}

		Bounds.field4422 = var4;
		class347.field4205 = var5;
		return false;
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		descriptor = "(II)I",
		garbageValue = "1250341507"
	)
	public static int method3414(int var0) {
		return var0 >>> 4 & class440.field4721;
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/CharSequence;IZI)Z",
		garbageValue = "1756871869"
	)
	static boolean method3422(CharSequence var0, int var1, boolean var2) {
		if (var1 >= 2 && var1 <= 36) {
			boolean var3 = false;
			boolean var4 = false;
			int var5 = 0;
			int var6 = var0.length();

			for (int var7 = 0; var7 < var6; ++var7) {
				char var8 = var0.charAt(var7);
				if (var7 == 0) {
					if (var8 == '-') {
						var3 = true;
						continue;
					}

					if (var8 == '+') {
						continue;
					}
				}

				int var10;
				if (var8 >= '0' && var8 <= '9') {
					var10 = var8 - '0';
				} else if (var8 >= 'A' && var8 <= 'Z') {
					var10 = var8 - '7';
				} else {
					if (var8 < 'a' || var8 > 'z') {
						return false;
					}

					var10 = var8 - 'W';
				}

				if (var10 >= var1) {
					return false;
				}

				if (var3) {
					var10 = -var10;
				}

				int var9 = var10 + var5 * var1;
				if (var9 / var1 != var5) {
					return false;
				}

				var5 = var9;
				var4 = true;
			}

			return var4;
		} else {
			throw new IllegalArgumentException("" + var1);
		}
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "-793593903"
	)
	public static void method3435(int var0) {
		class274.musicPlayerStatus = 1;
		class274.musicTrackArchive = null;
		class274.musicTrackGroupId = -1;
		StructComposition.musicTrackFileId = -1;
		class269.musicTrackVolume = 0;
		TriBool.musicTrackBoolean = false;
		VarcInt.pcmSampleLength = var0;
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		descriptor = "(II)[B",
		garbageValue = "2075625078"
	)
	@Export("ByteArrayPool_getArray")
	public static synchronized byte[] ByteArrayPool_getArray(int var0) {
		return ByteArrayPool.ByteArrayPool_getArrayBool(var0, false);
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		descriptor = "(ZZB)I",
		garbageValue = "18"
	)
	public static int method3433(boolean var0, boolean var1) {
		byte var2 = 0;
		int var3 = var2 + NetCache.NetCache_pendingPriorityWritesCount + NetCache.NetCache_pendingPriorityResponsesCount;
		return var3;
	}

	@ObfuscatedName("gk")
	@ObfuscatedSignature(
		descriptor = "(S)V",
		garbageValue = "-16060"
	)
	static final void method3430() {
		if (class142.ClanChat_inClanChat) {
			if (class145.friendsChat != null) {
				class145.friendsChat.sort();
			}

			for (int var0 = 0; var0 < Players.Players_count; ++var0) {
				Player var1 = Client.players[Players.Players_indices[var0]];
				var1.clearIsInFriendsChat();
			}

			class142.ClanChat_inClanChat = false;
		}

	}

	@ObfuscatedName("ip")
	@ObfuscatedSignature(
		descriptor = "(IIIIIIII)V",
		garbageValue = "-1637204954"
	)
	@Export("addPendingSpawnToScene")
	static final void addPendingSpawnToScene(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
		if (var2 >= 1 && var3 >= 1 && var2 <= 102 && var3 <= 102) {
			if (Client.isLowDetail && var0 != Tiles.Client_plane) {
				return;
			}

			long var7 = 0L;
			boolean var9 = true;
			boolean var10 = false;
			boolean var11 = false;
			if (var1 == 0) {
				var7 = MusicPatchNode.scene.getBoundaryObjectTag(var0, var2, var3);
			}

			if (var1 == 1) {
				var7 = MusicPatchNode.scene.getWallDecorationTag(var0, var2, var3);
			}

			if (var1 == 2) {
				var7 = MusicPatchNode.scene.getGameObjectTag(var0, var2, var3);
			}

			if (var1 == 3) {
				var7 = MusicPatchNode.scene.getFloorDecorationTag(var0, var2, var3);
			}

			int var12;
			if (var7 != 0L) {
				var12 = MusicPatchNode.scene.getObjectFlags(var0, var2, var3, var7);
				int var14 = class156.Entity_unpackID(var7);
				int var15 = var12 & 31;
				int var16 = var12 >> 6 & 3;
				ObjectComposition var13;
				if (var1 == 0) {
					MusicPatchNode.scene.removeBoundaryObject(var0, var2, var3);
					var13 = PlayerComposition.getObjectDefinition(var14);
					if (var13.interactType != 0) {
						Client.collisionMaps[var0].method3995(var2, var3, var15, var16, var13.boolean1);
					}
				}

				if (var1 == 1) {
					MusicPatchNode.scene.removeWallDecoration(var0, var2, var3);
				}

				if (var1 == 2) {
					MusicPatchNode.scene.removeGameObject(var0, var2, var3);
					var13 = PlayerComposition.getObjectDefinition(var14);
					if (var2 + var13.sizeX > 103 || var3 + var13.sizeX > 103 || var2 + var13.sizeY > 103 || var3 + var13.sizeY > 103) {
						return;
					}

					if (var13.interactType != 0) {
						Client.collisionMaps[var0].setFlagOffNonSquare(var2, var3, var13.sizeX, var13.sizeY, var16, var13.boolean1);
					}
				}

				if (var1 == 3) {
					MusicPatchNode.scene.removeFloorDecoration(var0, var2, var3);
					var13 = PlayerComposition.getObjectDefinition(var14);
					if (var13.interactType == 1) {
						Client.collisionMaps[var0].method4011(var2, var3);
					}
				}
			}

			if (var4 >= 0) {
				var12 = var0;
				if (var0 < 3 && (Tiles.Tiles_renderFlags[1][var2][var3] & 2) == 2) {
					var12 = var0 + 1;
				}

				class259.method5338(var0, var12, var2, var3, var4, var5, var6, MusicPatchNode.scene, Client.collisionMaps[var0]);
			}
		}

	}

	@ObfuscatedName("kx")
	@ObfuscatedSignature(
		descriptor = "(Lkw;IIS)V",
		garbageValue = "13153"
	)
	@Export("Widget_addToMenu")
	static final void Widget_addToMenu(Widget var0, int var1, int var2) {
		if (var0.buttonType == 1) {
			class395.method7283(var0.buttonText, "", 24, 0, 0, var0.id, var0.itemId);
		}

		String var3;
		if (var0.buttonType == 2 && !Client.isSpellSelected) {
			var3 = class67.Widget_getSpellActionName(var0);
			if (var3 != null) {
				class395.method7283(var3, SoundCache.colorStartTag(65280) + var0.spellName, 25, 0, -1, var0.id, var0.itemId);
			}
		}

		if (var0.buttonType == 3) {
			class135.insertMenuItemNoShift("Close", "", 26, 0, 0, var0.id);
		}

		if (var0.buttonType == 4) {
			class135.insertMenuItemNoShift(var0.buttonText, "", 28, 0, 0, var0.id);
		}

		if (var0.buttonType == 5) {
			class135.insertMenuItemNoShift(var0.buttonText, "", 29, 0, 0, var0.id);
		}

		if (var0.buttonType == 6 && Client.meslayerContinueWidget == null) {
			class135.insertMenuItemNoShift(var0.buttonText, "", 30, 0, -1, var0.id);
		}

		int var4;
		int var6;
		int var7;
		int var15;
		if (var0.type == 2) {
			var15 = 0;

			for (var4 = 0; var4 < var0.height; ++var4) {
				for (int var17 = 0; var17 < var0.width; ++var17) {
					var6 = (var0.paddingX + 32) * var17;
					var7 = (var0.paddingY + 32) * var4;
					if (var15 < 20) {
						var6 += var0.inventoryXOffsets[var15];
						var7 += var0.inventoryYOffsets[var15];
					}

					if (var1 >= var6 && var2 >= var7 && var1 < var6 + 32 && var2 < var7 + 32) {
						Client.dragItemSlotDestination = var15;
						SceneTilePaint.hoveredItemContainer = var0;
						if (var0.itemIds[var15] > 0) {
							label359: {
								ItemComposition var8 = UserComparator3.ItemDefinition_get(var0.itemIds[var15] - 1);
								boolean var9;
								int var10;
								if (Client.isItemSelected == 1) {
									var10 = class97.getWidgetFlags(var0);
									var9 = (var10 >> 30 & 1) != 0;
									if (var9) {
										if (var0.id != GameObject.selectedItemWidget || var15 != ApproximateRouteStrategy.selectedItemSlot) {
											class395.method7283("Use", Client.selectedItemName + " " + "->" + " " + SoundCache.colorStartTag(16748608) + var8.name, 31, 0, var15, var0.id, var8.id);
										}
										break label359;
									}
								}

								if (Client.isSpellSelected) {
									var10 = class97.getWidgetFlags(var0);
									var9 = (var10 >> 30 & 1) != 0;
									if (var9) {
										if ((UrlRequest.selectedSpellFlags & 16) == 16) {
											class395.method7283(Client.selectedSpellActionName, Client.selectedSpellName + " " + "->" + " " + SoundCache.colorStartTag(16748608) + var8.name, 32, 0, var15, var0.id, var8.id);
										}
										break label359;
									}
								}

								String[] var19 = var8.inventoryActions;
								var10 = -1;
								if (Client.shiftClickDrop && MidiPcmStream.method5533()) {
									var10 = var8.getShiftClickIndex();
								}

								if (Login.method2084(class97.getWidgetFlags(var0))) {
									for (int var11 = 4; var11 >= 3; --var11) {
										if (var10 != var11) {
											class370.addWidgetItemMenuItem(var0, var8, var15, var11, false);
										}
									}
								}

								if (MusicPatchNode.method5641(class97.getWidgetFlags(var0))) {
									class395.method7283("Use", SoundCache.colorStartTag(16748608) + var8.name, 38, 0, var15, var0.id, var8.id);
								}

								int var12 = class97.getWidgetFlags(var0);
								boolean var21 = (var12 >> 30 & 1) != 0;
								int var13;
								if (var21) {
									for (var13 = 2; var13 >= 0; --var13) {
										if (var10 != var13) {
											class370.addWidgetItemMenuItem(var0, var8, var15, var13, false);
										}
									}

									if (var10 >= 0) {
										class370.addWidgetItemMenuItem(var0, var8, var15, var10, true);
									}
								}

								var19 = var0.itemActions;
								if (var19 != null) {
									for (var13 = 4; var13 >= 0; --var13) {
										if (var19[var13] != null) {
											byte var14 = 0;
											if (var13 == 0) {
												var14 = 39;
											}

											if (var13 == 1) {
												var14 = 40;
											}

											if (var13 == 2) {
												var14 = 41;
											}

											if (var13 == 3) {
												var14 = 42;
											}

											if (var13 == 4) {
												var14 = 43;
											}

											class395.method7283(var19[var13], SoundCache.colorStartTag(16748608) + var8.name, var14, 0, var15, var0.id, var8.id);
										}
									}
								}

								class395.method7283("Examine", SoundCache.colorStartTag(16748608) + var8.name, 1005, 0, var15, var0.id, var8.id);
							}
						}
					}

					++var15;
				}
			}
		}

		if (var0.isIf3) {
			if (Client.isSpellSelected) {
				if (MenuAction.method2030(class97.getWidgetFlags(var0)) && (UrlRequest.selectedSpellFlags & 32) == 32) {
					class395.method7283(Client.selectedSpellActionName, Client.selectedSpellName + " " + "->" + " " + var0.dataText, 58, 0, var0.childIndex, var0.id, var0.itemId);
				}
			} else {
				for (var15 = 9; var15 >= 5; --var15) {
					var6 = class97.getWidgetFlags(var0);
					boolean var22 = (var6 >> var15 + 1 & 1) != 0;
					String var18;
					if (!var22 && var0.onOp == null) {
						var18 = null;
					} else if (var0.actions != null && var0.actions.length > var15 && var0.actions[var15] != null && var0.actions[var15].trim().length() != 0) {
						var18 = var0.actions[var15];
					} else {
						var18 = null;
					}

					if (var18 != null) {
						class395.method7283(var18, var0.dataText, 1007, var15 + 1, var0.childIndex, var0.id, var0.itemId);
					}
				}

				var3 = class67.Widget_getSpellActionName(var0);
				if (var3 != null) {
					class395.method7283(var3, var0.dataText, 25, 0, var0.childIndex, var0.id, var0.itemId);
				}

				for (var4 = 4; var4 >= 0; --var4) {
					var7 = class97.getWidgetFlags(var0);
					boolean var20 = (var7 >> var4 + 1 & 1) != 0;
					String var5;
					if (!var20 && var0.onOp == null) {
						var5 = null;
					} else if (var0.actions != null && var0.actions.length > var4 && var0.actions[var4] != null && var0.actions[var4].trim().length() != 0) {
						var5 = var0.actions[var4];
					} else {
						var5 = null;
					}

					if (var5 != null) {
						class399.insertMenuItem(var5, var0.dataText, 57, var4 + 1, var0.childIndex, var0.id, var0.itemId, var0.prioritizeMenuEntry);
					}
				}

				if (HealthBarDefinition.method3605(class97.getWidgetFlags(var0))) {
					class135.insertMenuItemNoShift("Continue", "", 30, 0, var0.childIndex, var0.id);
				}
			}
		}

	}
}
