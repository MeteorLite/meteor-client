import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fh")
public class class142 extends class143 {
	@ObfuscatedName("aw")
	int field1322;
	// $FF: synthetic field
	@ObfuscatedSignature(
		descriptor = "Lfr;"
	)
	@Export("this$0")
	@ObfuscatedName("this$0")
	final class146 this$0;

	@ObfuscatedSignature(
		descriptor = "(Lfr;)V"
	)
	class142(class146 var1) {
		this.this$0 = var1;
		this.field1322 = -1;
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(Lty;B)V",
		garbageValue = "1"
	)
	@Export("vmethod3254")
	void vmethod3254(Buffer var1) {
		this.field1322 = var1.readUnsignedShort();
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(Lfx;B)V",
		garbageValue = "-72"
	)
	@Export("vmethod3248")
	void vmethod3248(ClanSettings var1) {
		var1.method809(this.field1322);
	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "(ILdc;ZB)I",
		garbageValue = "-51"
	)
	static int method757(int var0, Script var1, boolean var2) {
		if (var0 < 1000) {
			return class301.method1577(var0, var1, var2);
		} else if (var0 < 1100) {
			return UserComparator10.method683(var0, var1, var2);
		} else if (var0 < 1200) {
			return SecureRandomFuture.method448(var0, var1, var2);
		} else if (var0 < 1300) {
			return class60.method328(var0, var1, var2);
		} else if (var0 < 1400) {
			return class9.method28(var0, var1, var2);
		} else if (var0 < 1500) {
			return class20.method74(var0, var1, var2);
		} else if (var0 < 1600) {
			return class10.method36(var0, var1, var2);
		} else if (var0 < 1700) {
			return class423.method2143(var0, var1, var2);
		} else if (var0 < 1800) {
			return Player.method503(var0, var1, var2);
		} else if (var0 < 1900) {
			return WorldMapIcon_1.method1372(var0, var1, var2);
		} else if (var0 < 2000) {
			return class319.method1666(var0, var1, var2);
		} else if (var0 < 2100) {
			return UserComparator10.method683(var0, var1, var2);
		} else if (var0 < 2200) {
			return SecureRandomFuture.method448(var0, var1, var2);
		} else if (var0 < 2300) {
			return class60.method328(var0, var1, var2);
		} else if (var0 < 2400) {
			return class9.method28(var0, var1, var2);
		} else if (var0 < 2500) {
			return class20.method74(var0, var1, var2);
		} else if (var0 < 2600) {
			return VarcInt.method942(var0, var1, var2);
		} else if (var0 < 2700) {
			return class47.method233(var0, var1, var2);
		} else if (var0 < 2800) {
			return ClanChannel.method856(var0, var1, var2);
		} else if (var0 < 2900) {
			return HealthBarUpdate.method533(var0, var1, var2);
		} else if (var0 < 3000) {
			return class319.method1666(var0, var1, var2);
		} else if (var0 < 3200) {
			return class9.method29(var0, var1, var2);
		} else if (var0 < 3300) {
			return ViewportMouse.method1322(var0, var1, var2);
		} else if (var0 < 3400) {
			return ApproximateRouteStrategy.method350(var0, var1, var2);
		} else if (var0 < 3500) {
			return FloorDecoration.method1155(var0, var1, var2);
		} else if (var0 < 3600) {
			return class467.method2325(var0, var1, var2);
		} else if (var0 < 3700) {
			return class92.method505(var0, var1, var2);
		} else if (var0 < 3800) {
			return Interpreter.method427(var0, var1, var2);
		} else if (var0 < 3900) {
			return class345.method1834(var0, var1, var2);
		} else if (var0 < 4000) {
			return Occluder.method1273(var0, var1, var2);
		} else if (var0 < 4100) {
			return MouseRecorder.method479(var0, var1, var2);
		} else if (var0 < 4200) {
			return FriendSystem.method420(var0, var1, var2);
		} else if (var0 < 4300) {
			return class339.method1824(var0, var1, var2);
		} else if (var0 < 5100) {
			return class335.method1815(var0, var1, var2);
		} else if (var0 < 5400) {
			return class113.method656(var0, var1, var2);
		} else if (var0 < 5600) {
			return WorldMapRectangle.method1496(var0, var1, var2);
		} else if (var0 < 5700) {
			return RouteStrategy.method1108(var0, var1, var2);
		} else if (var0 < 6300) {
			return ApproximateRouteStrategy.method351(var0, var1, var2);
		} else if (var0 < 6600) {
			return class167.method869(var0, var1, var2);
		} else if (var0 < 6700) {
			return WorldMapRectangle.method1497(var0, var1, var2);
		} else if (var0 < 6800) {
			return GrandExchangeOfferOwnWorldComparator.method356(var0, var1, var2);
		} else if (var0 < 6900) {
			return class12.method42(var0, var1, var2);
		} else if (var0 < 7000) {
			return MouseRecorder.method480(var0, var1, var2);
		} else if (var0 < 7100) {
			return class159.method838(var0, var1, var2);
		} else if (var0 < 7200) {
			return class219.method1124(var0, var1, var2);
		} else if (var0 < 7300) {
			return class30.method126(var0, var1, var2);
		} else if (var0 < 7500) {
			return class18.method65(var0, var1, var2);
		} else if (var0 < 7600) {
			return WorldMapScaleHandler.method1545(var0, var1, var2);
		} else {
			return var0 < 7700 ? MenuAction.method435(var0, var1, var2) : 2;
		}
	}

	@ObfuscatedName("mc")
	@ObfuscatedSignature(
		descriptor = "([Lmt;II)V",
		garbageValue = "-535637665"
	)
	@Export("drawModelComponents")
	static final void drawModelComponents(Widget[] var0, int var1) {
		for (int var2 = 0; var2 < var0.length; ++var2) {
			Widget var3 = var0[var2];
			if (var3 != null && var3.parentId == var1 && (!var3.isIf3 || !WorldMapDecorationType.isComponentHidden(var3))) {
				int var5;
				if (var3.type == 0) {
					if (!var3.isIf3 && WorldMapDecorationType.isComponentHidden(var3) && var3 != WorldMapScaleHandler.mousedOverWidgetIf1) {
						continue;
					}

					drawModelComponents(var0, var3.id);
					if (var3.children != null) {
						drawModelComponents(var3.children, var3.id);
					}

					InterfaceParent var4 = (InterfaceParent)Client.interfaceParents.get((long)var3.id);
					if (var4 != null) {
						var5 = var4.group;
						if (Login.loadInterface(var5)) {
							drawModelComponents(ArchiveLoader.Widget_interfaceComponents[var5], -1);
						}
					}
				}

				if (var3.type == 6) {
					if (var3.sequenceId != -1 || var3.sequenceId2 != -1) {
						boolean var8 = GrandExchangeOfferOwnWorldComparator.runCs1(var3);
						if (var8) {
							var5 = var3.sequenceId2;
						} else {
							var5 = var3.sequenceId;
						}

						if (var5 != -1) {
							SequenceDefinition var6 = class135.SequenceDefinition_get(var5);
							if (!var6.isCachedModelIdSet()) {
								for (var3.modelFrameCycle += Client.field452; var3.modelFrameCycle > var6.frameLengths[var3.modelFrame]; class200.invalidateWidget(var3)) {
									var3.modelFrameCycle -= var6.frameLengths[var3.modelFrame];
									++var3.modelFrame;
									if (var3.modelFrame >= var6.frameIds.length) {
										var3.modelFrame -= var6.frameCount;
										if (var3.modelFrame < 0 || var3.modelFrame >= var6.frameIds.length) {
											var3.modelFrame = 0;
										}
									}
								}
							} else {
								var3.modelFrame += Client.field452;
								int var7 = var6.method1067();
								if (var3.modelFrame >= var7) {
									var3.modelFrame -= var6.frameCount;
									if (var3.modelFrame < 0 || var3.modelFrame >= var7) {
										var3.modelFrame = 0;
									}
								}

								class200.invalidateWidget(var3);
							}
						}
					}

					if (var3.rotationKey != 0 && !var3.isIf3) {
						int var9 = var3.rotationKey >> 16;
						var5 = var3.rotationKey << 16 >> 16;
						var9 *= Client.field452;
						var5 *= Client.field452;
						var3.modelAngleX = var9 + var3.modelAngleX & 2047;
						var3.modelAngleY = var5 + var3.modelAngleY & 2047;
						class200.invalidateWidget(var3);
					}
				}
			}
		}

	}
}
