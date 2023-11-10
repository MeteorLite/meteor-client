import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.concurrent.Callable;

@ObfuscatedName("fi")
class class138 implements Callable {
	// $FF: synthetic field
	@ObfuscatedSignature(
		descriptor = "Lfo;"
	)
	@Export("this$0")
	@ObfuscatedName("this$0")
	final class139 this$0;
	// $FF: synthetic field
	@ObfuscatedSignature(
		descriptor = "Luj;"
	)
	@Export("val$p")
	@ObfuscatedName("val$p")
	final Buffer val$p;
	// $FF: synthetic field
	@Export("val$version")
	@ObfuscatedName("val$version")
	final int val$version;

	@ObfuscatedSignature(
		descriptor = "(Lfo;Luj;I)V"
	)
	class138(class139 var1, Buffer var2, int var3) {
		this.this$0 = var1;
		this.val$p = var2;
		this.val$version = var3;
	}

	@Export("call")
	@ObfuscatedName("call")
	public Object call() {
		this.this$0.method740(this.val$p, this.val$version);
		return null;
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "0"
	)
	public static void method737() {
		FloorOverlayDefinition.FloorOverlayDefinition_cached.clear();
	}

	@ObfuscatedName("bh")
	@ObfuscatedSignature(
		descriptor = "(ILdt;ZI)I",
		garbageValue = "721798432"
	)
	static int method738(int var0, Script var1, boolean var2) {
		if (var0 == 6500) {
			Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = class241.loadWorlds() ? 1 : 0;
			return 1;
		} else {
			World var3;
			if (var0 == 6501) {
				var3 = Language.worldListStart();
				if (var3 != null) {
					Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var3.id;
					Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var3.properties;
					Interpreter.Interpreter_stringStack[++class127.Interpreter_stringStackSize - 1] = var3.activity;
					Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var3.location;
					Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var3.population;
					Interpreter.Interpreter_stringStack[++class127.Interpreter_stringStackSize - 1] = var3.host;
				} else {
					Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = -1;
					Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = 0;
					Interpreter.Interpreter_stringStack[++class127.Interpreter_stringStackSize - 1] = "";
					Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = 0;
					Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = 0;
					Interpreter.Interpreter_stringStack[++class127.Interpreter_stringStackSize - 1] = "";
				}

				return 1;
			} else if (var0 == 6502) {
				var3 = WorldMapData_0.getNextWorldListWorld();
				if (var3 != null) {
					Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var3.id;
					Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var3.properties;
					Interpreter.Interpreter_stringStack[++class127.Interpreter_stringStackSize - 1] = var3.activity;
					Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var3.location;
					Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var3.population;
					Interpreter.Interpreter_stringStack[++class127.Interpreter_stringStackSize - 1] = var3.host;
				} else {
					Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = -1;
					Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = 0;
					Interpreter.Interpreter_stringStack[++class127.Interpreter_stringStackSize - 1] = "";
					Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = 0;
					Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = 0;
					Interpreter.Interpreter_stringStack[++class127.Interpreter_stringStackSize - 1] = "";
				}

				return 1;
			} else {
				World var4;
				int var5;
				int var7;
				if (var0 == 6506) {
					var7 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
					var4 = null;

					for (var5 = 0; var5 < World.World_count; ++var5) {
						if (var7 == class361.World_worlds[var5].id) {
							var4 = class361.World_worlds[var5];
							break;
						}
					}

					if (var4 != null) {
						Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var4.id;
						Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var4.properties;
						Interpreter.Interpreter_stringStack[++class127.Interpreter_stringStackSize - 1] = var4.activity;
						Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var4.location;
						Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var4.population;
						Interpreter.Interpreter_stringStack[++class127.Interpreter_stringStackSize - 1] = var4.host;
					} else {
						Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = -1;
						Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = 0;
						Interpreter.Interpreter_stringStack[++class127.Interpreter_stringStackSize - 1] = "";
						Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = 0;
						Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = 0;
						Interpreter.Interpreter_stringStack[++class127.Interpreter_stringStackSize - 1] = "";
					}

					return 1;
				} else if (var0 == 6507) {
					DbTableType.Interpreter_intStackSize -= 4;
					var7 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize];
					boolean var10 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize + 1] == 1;
					var5 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize + 2];
					boolean var6 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize + 3] == 1;
					PacketWriter.sortWorldList(var7, var10, var5, var6);
					return 1;
				} else if (var0 != 6511) {
					if (var0 == 6512) {
						Client.followerOpsLowPriority = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize] == 1;
						return 1;
					} else {
						int var8;
						ParamComposition var9;
						if (var0 == 6513) {
							DbTableType.Interpreter_intStackSize -= 2;
							var7 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize];
							var8 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize + 1];
							var9 = Frames.getParamDefinition(var8);
							if (var9.isString()) {
								Interpreter.Interpreter_stringStack[++class127.Interpreter_stringStackSize - 1] = VerticalAlignment.getNpcDefinition(var7).getStringParam(var8, var9.defaultStr);
							} else {
								Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = VerticalAlignment.getNpcDefinition(var7).getIntParam(var8, var9.defaultInt);
							}

							return 1;
						} else if (var0 == 6514) {
							DbTableType.Interpreter_intStackSize -= 2;
							var7 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize];
							var8 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize + 1];
							var9 = Frames.getParamDefinition(var8);
							if (var9.isString()) {
								Interpreter.Interpreter_stringStack[++class127.Interpreter_stringStackSize - 1] = WorldMapSection2.getObjectDefinition(var7).getStringParam(var8, var9.defaultStr);
							} else {
								Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = WorldMapSection2.getObjectDefinition(var7).getIntParam(var8, var9.defaultInt);
							}

							return 1;
						} else if (var0 == 6515) {
							DbTableType.Interpreter_intStackSize -= 2;
							var7 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize];
							var8 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize + 1];
							var9 = Frames.getParamDefinition(var8);
							if (var9.isString()) {
								Interpreter.Interpreter_stringStack[++class127.Interpreter_stringStackSize - 1] = class214.ItemDefinition_get(var7).getStringParam(var8, var9.defaultStr);
							} else {
								Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = class214.ItemDefinition_get(var7).getIntParam(var8, var9.defaultInt);
							}

							return 1;
						} else if (var0 == 6516) {
							DbTableType.Interpreter_intStackSize -= 2;
							var7 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize];
							var8 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize + 1];
							var9 = Frames.getParamDefinition(var8);
							if (var9.isString()) {
								Interpreter.Interpreter_stringStack[++class127.Interpreter_stringStackSize - 1] = UserList.StructDefinition_getStructDefinition(var7).getStringParam(var8, var9.defaultStr);
							} else {
								Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = UserList.StructDefinition_getStructDefinition(var7).getIntParam(var8, var9.defaultInt);
							}

							return 1;
						} else if (var0 == 6518) {
							Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = Client.onMobile ? 1 : 0;
							return 1;
						} else if (var0 == 6519) {
							Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = Client.clientType;
							return 1;
						} else if (var0 == 6520) {
							return 1;
						} else if (var0 == 6521) {
							return 1;
						} else if (var0 == 6522) {
							--class127.Interpreter_stringStackSize;
							--DbTableType.Interpreter_intStackSize;
							return 1;
						} else if (var0 == 6523) {
							--class127.Interpreter_stringStackSize;
							--DbTableType.Interpreter_intStackSize;
							return 1;
						} else if (var0 == 6524) {
							Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = -1;
							return 1;
						} else if (var0 == 6525) {
							Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = 1;
							return 1;
						} else if (var0 == 6526) {
							Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = 1;
							return 1;
						} else if (var0 == 6527) {
							Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = Client.field424;
							return 1;
						} else {
							return 2;
						}
					}
				} else {
					var7 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
					if (var7 >= 0 && var7 < World.World_count) {
						var4 = class361.World_worlds[var7];
						Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var4.id;
						Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var4.properties;
						Interpreter.Interpreter_stringStack[++class127.Interpreter_stringStackSize - 1] = var4.activity;
						Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var4.location;
						Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var4.population;
						Interpreter.Interpreter_stringStack[++class127.Interpreter_stringStackSize - 1] = var4.host;
					} else {
						Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = -1;
						Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = 0;
						Interpreter.Interpreter_stringStack[++class127.Interpreter_stringStackSize - 1] = "";
						Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = 0;
						Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = 0;
						Interpreter.Interpreter_stringStack[++class127.Interpreter_stringStackSize - 1] = "";
					}

					return 1;
				}
			}
		}
	}

	@ObfuscatedName("nu")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;I)V",
		garbageValue = "-1926894842"
	)
	@Export("Clan_joinChat")
	static final void Clan_joinChat(String var0) {
		if (!var0.equals("")) {
			PacketBufferNode var1 = class113.getPacketBufferNode(ClientPacket.f22, Client.packetWriter.isaacCipher);
			var1.packetBuffer.writeByte(ClanChannel.stringCp1252NullTerminatedByteSize(var0));
			var1.packetBuffer.writeStringCp1252NullTerminated(var0);
			Client.packetWriter.addNode(var1);
		}
	}
}