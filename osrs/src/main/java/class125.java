import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.net.URL;

@ObfuscatedName("eg")
public class class125 {
	@ObfuscatedName("iy")
	static long field1195;
	@ObfuscatedName("jh")
	static int field1193;
	@ObfuscatedName("lw")
	static int field1194;
	@ObfuscatedName("au")
	int field1202;
	@ObfuscatedName("ae")
	float field1198;
	@ObfuscatedName("ao")
	float field1200;
	@ObfuscatedName("at")
	float field1201;
	@ObfuscatedName("ac")
	float field1197;
	@ObfuscatedName("ai")
	float field1199;
	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "Leg;"
	)
	class125 field1196;

	class125() {
		this.field1200 = Float.MAX_VALUE;
		this.field1201 = Float.MAX_VALUE;
		this.field1197 = Float.MAX_VALUE;
		this.field1199 = Float.MAX_VALUE;
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(Ltm;IS)V",
		garbageValue = "249"
	)
	void method696(Buffer var1, int var2) {
		this.field1202 = var1.readShort();
		this.field1198 = var1.method2551();
		this.field1200 = var1.method2551();
		this.field1201 = var1.method2551();
		this.field1197 = var1.method2551();
		this.field1199 = var1.method2551();
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "1201510681"
	)
	@Export("loadWorlds")
	static boolean loadWorlds() {
		try {
			if (WorldMapLabelSize.World_request == null) {
				WorldMapLabelSize.World_request = FriendsChat.urlRequester.request(new URL(class200.field1669));
			} else if (WorldMapLabelSize.World_request.isDone()) {
				byte[] var0 = WorldMapLabelSize.World_request.getResponse();
				Buffer var1 = new Buffer(var0);
				var1.readInt();
				World.World_count = var1.readUnsignedShort();
				class176.World_worlds = new World[World.World_count];

				World var3;
				for (int var2 = 0; var2 < World.World_count; var3.index = var2++) {
					var3 = class176.World_worlds[var2] = new World();
					var3.id = var1.readUnsignedShort();
					var3.properties = var1.readInt();
					var3.host = var1.readStringCp1252NullTerminated();
					var3.activity = var1.readStringCp1252NullTerminated();
					var3.location = var1.readUnsignedByte();
					var3.population = var1.readShort();
				}

				GameEngine.sortWorlds(class176.World_worlds, 0, class176.World_worlds.length - 1, World.World_sortOption1, World.World_sortOption2);
				WorldMapLabelSize.World_request = null;
				return true;
			}
		} catch (Exception var4) {
			var4.printStackTrace();
			WorldMapLabelSize.World_request = null;
		}

		return false;
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(IB)[B",
		garbageValue = "-47"
	)
	@Export("ByteArrayPool_getArray")
	public static synchronized byte[] ByteArrayPool_getArray(int var0) {
		return ByteArrayPool.ByteArrayPool_getArrayBool(var0, false);
	}
}