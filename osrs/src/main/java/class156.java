import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fc")
public class class156 {
	@ObfuscatedName("hw")
	@ObfuscatedSignature(
		descriptor = "Lmv;"
	)
	@Export("fontPlain11")
	static Font fontPlain11;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = -677819103
	)
	int field1745;
	@ObfuscatedName("x")
	String field1740;
	@ObfuscatedName("j")
	@ObfuscatedSignature(
		descriptor = "Lcm;"
	)
	UrlRequest field1741;
	@ObfuscatedName("v")
	String field1742;
	@ObfuscatedName("h")
	float[] field1743;
	@ObfuscatedName("t")
	ArrayList field1734;
	@ObfuscatedName("u")
	ArrayList field1744;
	@ObfuscatedName("d")
	ArrayList field1736;
	@ObfuscatedName("b")
	Map field1749;
	@ObfuscatedName("a")
	Map field1748;

	public class156() {
		this.field1745 = -1;
		this.field1742 = null;
		this.field1743 = new float[4];
		this.field1734 = new ArrayList();
		this.field1744 = new ArrayList();
		this.field1736 = new ArrayList();
		this.field1749 = new HashMap();
		this.field1748 = new HashMap();
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;Lch;B)Z",
		garbageValue = "6"
	)
	public boolean method3374(String var1, UrlRequester var2) {
		if (var1 != null && !var1.isEmpty()) {
			if (var2 == null) {
				return false;
			} else {
				this.method3354();

				try {
					this.field1740 = var1;
					this.field1741 = var2.request(new URL(this.field1740));
					this.field1745 = 0;
					return true;
				} catch (MalformedURLException var4) {
					this.method3354();
					this.field1745 = 100;
					return false;
				}
			}
		} else {
			return false;
		}
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		descriptor = "(Lch;I)V",
		garbageValue = "2063306110"
	)
	public void method3345(UrlRequester var1) {
		switch(this.field1745) {
		case 0:
			this.method3358(var1);
			break;
		case 1:
			this.method3356();
			break;
		default:
			return;
		}

	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "94"
	)
	public int method3346() {
		return this.field1745;
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;B)I",
		garbageValue = "-91"
	)
	public int method3347(String var1) {
		return this.field1749.containsKey(var1) ? (Integer)this.field1749.get(var1) : -1;
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;B)Ljava/lang/String;",
		garbageValue = "16"
	)
	public String method3398(String var1) {
		return (String)((String)(this.field1748.containsKey(var1) ? this.field1748.get(var1) : null));
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		descriptor = "(S)Ljava/util/ArrayList;",
		garbageValue = "18519"
	)
	public ArrayList method3369() {
		return this.field1744;
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		descriptor = "(B)Ljava/util/ArrayList;",
		garbageValue = "0"
	)
	public ArrayList method3350() {
		return this.field1736;
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		descriptor = "(I)Ljava/lang/String;",
		garbageValue = "-1540585633"
	)
	public String method3408() {
		return this.field1742;
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		descriptor = "(I)[F",
		garbageValue = "643585474"
	)
	public float[] method3352() {
		return this.field1743;
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		descriptor = "(I)Ljava/util/ArrayList;",
		garbageValue = "1464603360"
	)
	public ArrayList method3353() {
		return this.field1734;
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "101"
	)
	void method3354() {
		this.field1741 = null;
		this.field1742 = null;
		this.field1743[0] = 0.0F;
		this.field1743[1] = 0.0F;
		this.field1743[2] = 1.0F;
		this.field1743[3] = 1.0F;
		this.field1734.clear();
		this.field1744.clear();
		this.field1736.clear();
		this.field1749.clear();
		this.field1748.clear();
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		descriptor = "(Lch;I)V",
		garbageValue = "-1243026809"
	)
	void method3358(UrlRequester var1) {
		if (this.field1741 != null && this.field1741.isDone()) {
			byte[] var2 = this.field1741.getResponse();
			if (var2 == null) {
				this.method3354();
				this.field1745 = 100;
			} else {
				JSONObject var3;
				try {
					class401 var4 = new class401(var2);
					var3 = var4.method7307();
					var3 = var3.getJSONObject("message");
				} catch (Exception var9) {
					this.method3354();
					this.field1745 = 102;
					return;
				}

				try {
					this.method3357(var3.getJSONArray("images"), var1);
				} catch (Exception var8) {
					this.field1744.clear();
				}

				try {
					this.method3406(var3.getJSONArray("labels"));
				} catch (Exception var7) {
					this.field1736.clear();
				}

				try {
					this.method3359(var3.getJSONObject("behaviour"));
				} catch (Exception var6) {
					this.field1742 = null;
					this.field1743[0] = 0.0F;
					this.field1743[1] = 0.0F;
					this.field1743[2] = 1.0F;
					this.field1743[3] = 1.0F;
					this.field1734.clear();
				}

				try {
					this.method3373(var3.getJSONObject("meta"));
				} catch (Exception var5) {
					this.field1749.clear();
					this.field1748.clear();
				}

				this.field1745 = this.field1744.size() > 0 ? 1 : 2;
				this.field1741 = null;
			}
		}
	}

	@ObfuscatedName("h")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "8"
	)
	void method3356() {
		Iterator var1 = this.field1744.iterator();

		class161 var2;
		do {
			if (!var1.hasNext()) {
				var1 = this.field1744.iterator();

				while (var1.hasNext()) {
					var2 = (class161)var1.next();
					if (var2.field1786 != null) {
						byte[] var3 = var2.field1786.getResponse();
						if (var3 != null && var3.length > 0) {
							this.field1745 = 2;
							return;
						}
					}
				}

				this.method3354();
				this.field1745 = 101;
				return;
			}

			var2 = (class161)var1.next();
		} while(var2.field1786 == null || var2.field1786.isDone());

	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		descriptor = "(LJSONArray;Lch;B)V",
		garbageValue = "-40"
	)
	void method3357(JSONArray var1, UrlRequester var2) throws JSONException {
		if (var1 != null) {
			for (int var3 = 0; var3 < var1.length(); ++var3) {
				try {
					JSONObject var4 = var1.getJSONObject(var3);
					class161 var5 = new class161(this);
					var5.field1786 = var2.request(new URL(var4.getString("src")));
					var5.field1781 = EnumComposition.method3622(var4, "placement");
					this.field1744.add(var5);
				} catch (MalformedURLException var6) {
				}
			}

		}
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		descriptor = "(LJSONArray;S)V",
		garbageValue = "-6900"
	)
	void method3406(JSONArray var1) throws JSONException {
		if (var1 != null) {
			for (int var2 = 0; var2 < var1.length(); ++var2) {
				JSONObject var3 = var1.getJSONObject(var2);
				class162 var4 = new class162(this);
				var4.field1788 = var3.getString("text");
				var4.field1792 = JagexCache.method3441(var3.getString("align_x"));
				var4.field1793 = JagexCache.method3441(var3.getString("align_y"));
				var4.field1794 = var3.getInt("font");
				var4.field1791 = EnumComposition.method3622(var3, "placement");
				this.field1736.add(var4);
			}

		}
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		descriptor = "(LJSONObject;I)V",
		garbageValue = "1343260933"
	)
	void method3359(JSONObject var1) throws JSONException {
		if (var1 != null) {
			this.field1743 = EnumComposition.method3622(var1, "clickbounds");
			this.field1742 = var1.getString("endpoint");
			String[] var2 = JSONObject.getNames(var1);

			for (int var3 = 0; var3 < var1.length(); ++var3) {
				if (!var2[var3].equals("clickbounds") && !var2[var3].equals("endpoint")) {
					try {
						int var4 = var1.getInt(var2[var3]);
						this.field1734.add(new class163(this, var2[var3], var4));
					} catch (Exception var8) {
						try {
							String var5 = var1.getString(var2[var3]);
							if (var5.equals("true")) {
								this.field1734.add(new class163(this, var2[var3], 1));
							} else if (var5.equals("false")) {
								this.field1734.add(new class163(this, var2[var3], 0));
							} else {
								this.field1734.add(new class155(this, var2[var3], var5));
							}
						} catch (Exception var7) {
						}
					}
				}
			}

		}
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		descriptor = "(LJSONObject;I)V",
		garbageValue = "-389541572"
	)
	void method3373(JSONObject var1) throws JSONException {
		String[] var2 = JSONObject.getNames(var1);

		for (int var3 = 0; var3 < var1.length(); ++var3) {
			try {
				int var4 = var1.getInt(var2[var3]);
				this.field1749.put(var2[var3], var4);
			} catch (Exception var8) {
				try {
					String var5 = var1.getString(var2[var3]);
					if (var5.equals("true")) {
						this.field1749.put(var2[var3], 1);
					} else if (var5.equals("false")) {
						this.field1749.put(var2[var3], 0);
					} else {
						this.field1748.put(var2[var3], var5);
					}
				} catch (Exception var7) {
				}
			}
		}

	}

	@ObfuscatedName("w")
	@Export("Entity_unpackID")
	public static int Entity_unpackID(long var0) {
		return (int)(var0 >>> 17 & 4294967295L);
	}

	@ObfuscatedName("hc")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "1805450282"
	)
	static final int method3395() {
		if (Player.clientPreferences.method2452()) {
			return Tiles.Client_plane;
		} else {
			int var0 = class120.getTileHeight(TaskHandler.cameraX, ApproximateRouteStrategy.cameraZ, Tiles.Client_plane);
			return var0 - SecureRandomFuture.cameraY < 800 && (Tiles.Tiles_renderFlags[Tiles.Client_plane][TaskHandler.cameraX >> 7][ApproximateRouteStrategy.cameraZ >> 7] & 4) != 0 ? Tiles.Client_plane : 3;
		}
	}

	@ObfuscatedName("jl")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "1115779957"
	)
	static final int method3411() {
		return Client.menuOptionsCount - 1;
	}
}
