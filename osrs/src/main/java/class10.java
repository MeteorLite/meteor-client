import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import javax.net.ssl.HttpsURLConnection;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("j")
public class class10 {
	@ObfuscatedName("cw")
	@ObfuscatedSignature(
		descriptor = "Lqu;"
	)
	static IndexedSprite field45;
	@ObfuscatedName("jz")
	@ObfuscatedGetter(
		intValue = 2124416093
	)
	@Export("cameraYaw")
	static int cameraYaw;
	@ObfuscatedName("c")
	HttpsURLConnection field48;
	@ObfuscatedName("p")
	final Map field43;
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		descriptor = "Loc;"
	)
	class400 field44;
	@ObfuscatedName("n")
	Map field50;
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		descriptor = "Lx;"
	)
	final class9 field46;
	@ObfuscatedName("w")
	boolean field47;
	@ObfuscatedName("s")
	boolean field52;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = 618018867
	)
	int field49;

	@ObfuscatedSignature(
		descriptor = "(Ljava/net/URL;Lx;Z)V"
	)
	public class10(URL var1, class9 var2, boolean var3) throws IOException {
		this.field47 = false;
		this.field52 = false;
		this.field49 = 300000;
		if (!var2.method87()) {
			throw new UnsupportedEncodingException("Unsupported request method used " + var2.method75());
		} else {
			this.field48 = (HttpsURLConnection)var1.openConnection();
			if (!var3) {
				HttpsURLConnection var4 = this.field48;
				if (class15.field86 == null) {
					class15.field86 = new class15();
				}

				class15 var5 = class15.field86;
				var4.setSSLSocketFactory(var5);
			}

			this.field46 = var2;
			this.field43 = new HashMap();
			this.field50 = new HashMap();
		}
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;Ljava/lang/String;I)V",
		garbageValue = "1485385530"
	)
	public void method92(String var1, String var2) {
		if (!this.field47) {
			this.field43.put(var1, var2);
		}
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		descriptor = "(B)Ljava/lang/String;",
		garbageValue = "-83"
	)
	String method96() {
		ArrayList var1 = new ArrayList(this.field50.entrySet());
		Collections.sort(var1, new class18(this));
		StringBuilder var2 = new StringBuilder();
		Iterator var3 = var1.iterator();

		while (var3.hasNext()) {
			Entry var4 = (Entry)var3.next();
			if (var2.length() > 0) {
				var2.append(",");
			}

			var2.append(((class399)var4.getKey()).method7299());
			float var5 = (Float)var4.getValue();
			if (var5 < 1.0F) {
				String var6 = Float.toString(var5).substring(0, 4);
				var2.append(";q=" + var6);
			}
		}

		return var2.toString();
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "376821684"
	)
	void method91() throws ProtocolException {
		if (!this.field47) {
			this.field48.setRequestMethod(this.field46.method75());
			if (!this.field50.isEmpty()) {
				this.field43.put("Accept", this.method96());
			}

			Iterator var1 = this.field43.entrySet().iterator();

			while (var1.hasNext()) {
				Entry var2 = (Entry)var1.next();
				this.field48.setRequestProperty((String)var2.getKey(), (String)var2.getValue());
			}

			if (this.field46.method76() && this.field44 != null) {
				this.field48.setDoOutput(true);
				ByteArrayOutputStream var13 = new ByteArrayOutputStream();

				try {
					var13.write(this.field44.vmethod7323());
					var13.writeTo(this.field48.getOutputStream());
				} catch (IOException var11) {
					var11.printStackTrace();
				} finally {
					if (var13 != null) {
						try {
							var13.close();
						} catch (IOException var10) {
							var10.printStackTrace();
						}
					}

				}
			}

			this.field48.setConnectTimeout(this.field49);
			this.field48.setInstanceFollowRedirects(this.field52);
			this.field47 = true;
		}
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		descriptor = "(B)Z",
		garbageValue = "-86"
	)
	boolean method95() throws IOException, SocketTimeoutException {
		if (!this.field47) {
			this.method91();
		}

		this.field48.connect();
		return this.field48.getResponseCode() == -1;
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		descriptor = "(I)Ly;",
		garbageValue = "-1364612263"
	)
	class21 method97() {
		try {
			if (!this.field47 || this.field48.getResponseCode() == -1) {
				return new class21("No REST response has been received yet.");
			}
		} catch (IOException var10) {
			this.field48.disconnect();
			return new class21("Error decoding REST response code: " + var10.getMessage());
		}

		class21 var1 = null;

		class21 var3;
		try {
			var1 = new class21(this.field48);
			return var1;
		} catch (IOException var8) {
			var3 = new class21("Error decoding REST response: " + var8.getMessage());
		} finally {
			this.field48.disconnect();
		}

		return var3;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "(IB)Lfa;",
		garbageValue = "16"
	)
	@Export("KitDefinition_get")
	public static KitDefinition KitDefinition_get(int var0) {
		KitDefinition var1 = (KitDefinition)KitDefinition.KitDefinition_cached.get((long)var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = KitDefinition.KitDefinition_archive.takeFile(3, var0);
			var1 = new KitDefinition();
			if (var2 != null) {
				var1.decode(new Buffer(var2));
			}

			KitDefinition.KitDefinition_cached.put(var1, (long)var0);
			return var1;
		}
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "(I)[Lqr;",
		garbageValue = "-2037614425"
	)
	static PrivateChatMode[] method106() {
		return new PrivateChatMode[]{PrivateChatMode.field4854, PrivateChatMode.field4852, PrivateChatMode.field4851};
	}

	@ObfuscatedName("gf")
	@ObfuscatedSignature(
		descriptor = "(Lce;B)V",
		garbageValue = "-50"
	)
	static final void method108(Actor var0) {
		boolean var1 = var0.field1136 == Client.cycle || var0.sequence == -1 || var0.sequenceDelay != 0;
		if (!var1) {
			SequenceDefinition var2 = class4.SequenceDefinition_get(var0.sequence);
			if (var2 != null && !var2.isCachedModelIdSet()) {
				var1 = var0.sequenceFrameCycle + 1 > var2.frameLengths[var0.sequenceFrame];
			} else {
				var1 = true;
			}
		}

		if (var1) {
			int var8 = var0.field1136 - var0.field1183;
			int var3 = Client.cycle - var0.field1183;
			int var4 = var0.field1192 * 128 + var0.field1131 * -360448000;
			int var5 = var0.field1181 * 128 + var0.field1131 * -360448000;
			int var6 = var0.field1180 * 128 + var0.field1131 * -360448000;
			int var7 = var0.field1140 * 128 + var0.field1131 * -360448000;
			var0.x = (var6 * var3 + var4 * (var8 - var3)) / var8;
			var0.y = (var3 * var7 + var5 * (var8 - var3)) / var8;
		}

		var0.field1201 = 0;
		var0.orientation = var0.field1185;
		var0.rotation = var0.orientation;
	}

	@ObfuscatedName("hl")
	@ObfuscatedSignature(
		descriptor = "(IB)V",
		garbageValue = "16"
	)
	static final void method109(int var0) {
		int[] var1 = class11.sceneMinimapSprite.pixels;
		int var2 = var1.length;

		int var3;
		for (var3 = 0; var3 < var2; ++var3) {
			var1[var3] = 0;
		}

		int var4;
		int var5;
		for (var3 = 1; var3 < 103; ++var3) {
			var4 = (103 - var3) * 2048 + 24628;

			for (var5 = 1; var5 < 103; ++var5) {
				if ((Tiles.Tiles_renderFlags[var0][var5][var3] & 24) == 0) {
					MusicPatchNode.scene.drawTileMinimap(var1, var4, 512, var0, var5, var3);
				}

				if (var0 < 3 && (Tiles.Tiles_renderFlags[var0 + 1][var5][var3] & 8) != 0) {
					MusicPatchNode.scene.drawTileMinimap(var1, var4, 512, var0 + 1, var5, var3);
				}

				var4 += 4;
			}
		}

		var3 = (238 + (int)(Math.random() * 20.0D) - 10 << 16) + (238 + (int)(Math.random() * 20.0D) - 10 << 8) + (238 + (int)(Math.random() * 20.0D) - 10);
		var4 = 238 + (int)(Math.random() * 20.0D) - 10 << 16;
		class11.sceneMinimapSprite.setRaster();

		int var6;
		for (var5 = 1; var5 < 103; ++var5) {
			for (var6 = 1; var6 < 103; ++var6) {
				if ((Tiles.Tiles_renderFlags[var0][var6][var5] & 24) == 0) {
					class148.drawObject(var0, var6, var5, var3, var4);
				}

				if (var0 < 3 && (Tiles.Tiles_renderFlags[var0 + 1][var6][var5] & 8) != 0) {
					class148.drawObject(var0 + 1, var6, var5, var3, var4);
				}
			}
		}

		Client.mapIconCount = 0;

		for (var5 = 0; var5 < 104; ++var5) {
			for (var6 = 0; var6 < 104; ++var6) {
				long var7 = MusicPatchNode.scene.getFloorDecorationTag(Tiles.Client_plane, var5, var6);
				if (var7 != 0L) {
					int var9 = class156.Entity_unpackID(var7);
					int var10 = PlayerComposition.getObjectDefinition(var9).mapIconId;
					if (var10 >= 0 && class139.WorldMapElement_get(var10).field1856) {
						Client.mapIcons[Client.mapIconCount] = class139.WorldMapElement_get(var10).getSpriteBool(false);
						Client.mapIconXs[Client.mapIconCount] = var5;
						Client.mapIconYs[Client.mapIconCount] = var6;
						++Client.mapIconCount;
					}
				}
			}
		}

		class20.rasterProvider.apply();
	}

	@ObfuscatedName("jn")
	@ObfuscatedSignature(
		descriptor = "(Lkw;IIIIIII)V",
		garbageValue = "2090499864"
	)
	static final void method110(Widget var0, int var1, int var2, int var3, int var4, int var5, int var6) {
		if (Client.field570) {
			Client.alternativeScrollbarWidth = 32;
		} else {
			Client.alternativeScrollbarWidth = 0;
		}

		Client.field570 = false;
		int var7;
		if (MouseHandler.MouseHandler_currentButton == 1 || !Renderable.mouseCam && MouseHandler.MouseHandler_currentButton == 4) {
			if (var5 >= var1 && var5 < var1 + 16 && var6 >= var2 && var6 < var2 + 16) {
				var0.scrollY -= 4;
				class403.invalidateWidget(var0);
			} else if (var5 >= var1 && var5 < var1 + 16 && var6 >= var3 + var2 - 16 && var6 < var3 + var2) {
				var0.scrollY += 4;
				class403.invalidateWidget(var0);
			} else if (var5 >= var1 - Client.alternativeScrollbarWidth && var5 < Client.alternativeScrollbarWidth + var1 + 16 && var6 >= var2 + 16 && var6 < var3 + var2 - 16) {
				var7 = var3 * (var3 - 32) / var4;
				if (var7 < 8) {
					var7 = 8;
				}

				int var8 = var6 - var2 - 16 - var7 / 2;
				int var9 = var3 - 32 - var7;
				var0.scrollY = var8 * (var4 - var3) / var9;
				class403.invalidateWidget(var0);
				Client.field570 = true;
			}
		}

		if (Client.mouseWheelRotation != 0) {
			var7 = var0.width;
			if (var5 >= var1 - var7 && var6 >= var2 && var5 < var1 + 16 && var6 <= var3 + var2) {
				var0.scrollY += Client.mouseWheelRotation * 45;
				class403.invalidateWidget(var0);
			}
		}

	}
}
