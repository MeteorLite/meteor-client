import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gq")
public class class170 {
	@ObfuscatedName("ja")
	@Export("regionLandArchiveIds")
	static int[] regionLandArchiveIds;
	@ObfuscatedName("av")
	int field1434;
	@ObfuscatedName("ap")
	String field1435;
	@ObfuscatedName("aq")
	@ObfuscatedSignature(
		descriptor = "Lei;"
	)
	UrlRequest field1432;
	@ObfuscatedName("at")
	String field1436;
	@ObfuscatedName("ah")
	float[] field1433;
	@ObfuscatedName("ax")
	ArrayList field1439;
	@ObfuscatedName("aa")
	ArrayList field1437;
	@ObfuscatedName("au")
	ArrayList field1438;
	@ObfuscatedName("ae")
	Map field1441;
	@ObfuscatedName("ab")
	Map field1440;

	public class170() {
		this.field1434 = -1;
		this.field1436 = null;
		this.field1433 = new float[4];
		this.field1439 = new ArrayList();
		this.field1437 = new ArrayList();
		this.field1438 = new ArrayList();
		this.field1441 = new HashMap();
		this.field1440 = new HashMap();
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;Lej;B)Z",
		garbageValue = "-55"
	)
	public boolean method875(String var1, UrlRequester var2) {
		if (var1 != null && !var1.isEmpty()) {
			if (var2 == null) {
				return false;
			} else {
				this.method885();

				try {
					this.field1435 = var1;
					this.field1432 = var2.request(new URL(this.field1435));
					this.field1434 = 0;
					return true;
				} catch (MalformedURLException var4) {
					this.method885();
					this.field1434 = 100;
					return false;
				}
			}
		} else {
			return false;
		}
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(Lej;B)V",
		garbageValue = "88"
	)
	public void method876(UrlRequester var1) {
		switch(this.field1434) {
		case 0:
			this.method886(var1);
			break;
		case 1:
			this.method887();
			break;
		default:
			return;
		}

	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "1160046533"
	)
	public int method877() {
		return this.field1434;
	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;I)I",
		garbageValue = "212756708"
	)
	public int method878(String var1) {
		return this.field1441.containsKey(var1) ? (Integer)this.field1441.get(var1) : -1;
	}

	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;I)Ljava/lang/String;",
		garbageValue = "103576370"
	)
	public String method879(String var1) {
		return (String)((String)(this.field1440.containsKey(var1) ? this.field1440.get(var1) : null));
	}

	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		descriptor = "(I)Ljava/util/ArrayList;",
		garbageValue = "494222917"
	)
	public ArrayList method880() {
		return this.field1437;
	}

	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		descriptor = "(B)Ljava/util/ArrayList;",
		garbageValue = "35"
	)
	public ArrayList method881() {
		return this.field1438;
	}

	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "(B)Ljava/lang/String;",
		garbageValue = "120"
	)
	public String method882() {
		return this.field1436;
	}

	@ObfuscatedName("av")
	@ObfuscatedSignature(
		descriptor = "(I)[F",
		garbageValue = "1926620523"
	)
	public float[] method883() {
		return this.field1433;
	}

	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		descriptor = "(B)Ljava/util/ArrayList;",
		garbageValue = "88"
	)
	public ArrayList method884() {
		return this.field1439;
	}

	@ObfuscatedName("aq")
	@ObfuscatedSignature(
		descriptor = "(S)V",
		garbageValue = "500"
	)
	void method885() {
		this.field1432 = null;
		this.field1436 = null;
		this.field1433[0] = 0.0F;
		this.field1433[1] = 0.0F;
		this.field1433[2] = 1.0F;
		this.field1433[3] = 1.0F;
		this.field1439.clear();
		this.field1437.clear();
		this.field1438.clear();
		this.field1441.clear();
		this.field1440.clear();
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(Lej;B)V",
		garbageValue = "0"
	)
	void method886(UrlRequester var1) {
		if (this.field1432 != null && this.field1432.isDone()) {
			byte[] var2 = this.field1432.getResponse();
			if (var2 == null) {
				this.method885();
				this.field1434 = 100;
			} else {
				try {
					this.method892(new class463(var2), var1);
				} catch (UnsupportedEncodingException var4) {
					this.method885();
					this.field1434 = 102;
					return;
				}

				this.field1434 = this.field1437.size() > 0 ? 1 : 2;
				this.field1432 = null;
			}
		}
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "706475225"
	)
	void method887() {
		Iterator var1 = this.field1437.iterator();

		class176 var2;
		do {
			if (!var1.hasNext()) {
				var1 = this.field1437.iterator();

				while (var1.hasNext()) {
					var2 = (class176)var1.next();
					if (var2.field1460 != null) {
						byte[] var3 = var2.field1460.getResponse();
						if (var3 != null && var3.length > 0) {
							this.field1434 = 2;
							return;
						}
					}
				}

				this.method885();
				this.field1434 = 101;
				return;
			}

			var2 = (class176)var1.next();
		} while(var2.field1460 == null || var2.field1460.isDone());

	}

	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "(Lorg/json/JSONArray;Lej;I)V",
		garbageValue = "-506183299"
	)
	void method888(JSONArray var1, UrlRequester var2) throws JSONException {
		if (var1 != null) {
			for (int var3 = 0; var3 < var1.length(); ++var3) {
				try {
					JSONObject var4 = var1.getJSONObject(var3);
					class176 var5 = new class176(this);
					var5.field1460 = var2.request(new URL(var4.getString("src")));
					var5.field1461 = class106.method620(var4, "placement");
					this.field1437.add(var5);
				} catch (MalformedURLException var6) {
				}
			}

		}
	}

	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "(Lorg/json/JSONArray;I)V",
		garbageValue = "-86694133"
	)
	void method889(JSONArray var1) throws JSONException {
		if (var1 != null) {
			for (int var2 = 0; var2 < var1.length(); ++var2) {
				JSONObject var3 = var1.getJSONObject(var2);
				class177 var4 = new class177(this);
				var4.field1467 = var3.getString("text");
				var4.field1465 = class27.method113(var3.getString("align_x"));
				var4.field1464 = class27.method113(var3.getString("align_y"));
				var4.field1466 = var3.getInt("font");
				var4.field1463 = class106.method620(var3, "placement");
				this.field1438.add(var4);
			}

		}
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(Lorg/json/JSONObject;S)V",
		garbageValue = "-18886"
	)
	void method890(JSONObject var1) throws JSONException {
		if (var1 != null) {
			this.field1433 = class106.method620(var1, "clickbounds");
			this.field1436 = var1.getString("endpoint");
			String[] var2 = JSONObject.getNames(var1);

			for (int var3 = 0; var3 < var1.length(); ++var3) {
				if (!var2[var3].equals("clickbounds") && !var2[var3].equals("endpoint")) {
					try {
						int var4 = var1.getInt(var2[var3]);
						this.field1439.add(new class178(this, var2[var3], var4));
					} catch (Exception var8) {
						try {
							String var5 = var1.getString(var2[var3]);
							if (var5.equals("true")) {
								this.field1439.add(new class178(this, var2[var3], 1));
							} else if (var5.equals("false")) {
								this.field1439.add(new class178(this, var2[var3], 0));
							} else {
								this.field1439.add(new class169(this, var2[var3], var5));
							}
						} catch (Exception var7) {
						}
					}
				}
			}

		}
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(Lorg/json/JSONObject;I)V",
		garbageValue = "357071457"
	)
	void method891(JSONObject var1) throws JSONException {
		String[] var2 = JSONObject.getNames(var1);

		for (int var3 = 0; var3 < var1.length(); ++var3) {
			try {
				int var4 = var1.getInt(var2[var3]);
				this.field1441.put(var2[var3], var4);
			} catch (Exception var8) {
				try {
					String var5 = var1.getString(var2[var3]);
					if (var5.equals("true")) {
						this.field1441.put(var2[var3], 1);
					} else if (var5.equals("false")) {
						this.field1441.put(var2[var3], 0);
					} else {
						this.field1440.put(var2[var3], var5);
					}
				} catch (Exception var7) {
				}
			}
		}

	}

	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "(Lre;Lej;B)V",
		garbageValue = "28"
	)
	void method892(class463 var1, UrlRequester var2) {
		JSONObject var3;
		try {
			var3 = var1.method2315();
			var3 = var3.getJSONObject("message");
		} catch (Exception var9) {
			this.method885();
			this.field1434 = 102;
			return;
		}

		try {
			this.method888(var3.getJSONArray("images"), var2);
		} catch (Exception var8) {
			this.field1437.clear();
		}

		try {
			this.method889(var3.getJSONArray("labels"));
		} catch (Exception var7) {
			this.field1438.clear();
		}

		try {
			this.method890(var3.getJSONObject("behaviour"));
		} catch (Exception var6) {
			this.field1436 = null;
			this.field1433[0] = 0.0F;
			this.field1433[1] = 0.0F;
			this.field1433[2] = 1.0F;
			this.field1433[3] = 1.0F;
			this.field1439.clear();
		}

		try {
			this.method891(var3.getJSONObject("meta"));
		} catch (Exception var5) {
			this.field1441.clear();
			this.field1440.clear();
		}

	}

	@ObfuscatedName("ad")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;Lej;B)Z",
		garbageValue = "6"
	)
	public boolean method893(String var1, UrlRequester var2) {
		try {
			this.method892(new class463(var1.getBytes()), var2);
			this.field1434 = this.field1437.size() > 0 ? 1 : 2;
		} catch (UnsupportedEncodingException var4) {
			this.field1434 = 102;
		}

		return this.field1434 < 100;
	}

	@ObfuscatedName("aw")
	@Export("base37DecodeLong")
	public static String base37DecodeLong(long var0) {
		if (var0 > 0L && var0 < 6582952005840035281L) {
			if (var0 % 37L == 0L) {
				return null;
			} else {
				int var2 = 0;

				for (long var3 = var0; 0L != var3; var3 /= 37L) {
					++var2;
				}

				StringBuilder var5;
				char var8;
				for (var5 = new StringBuilder(var2); 0L != var0; var5.append(var8)) {
					long var6 = var0;
					var0 /= 37L;
					var8 = class389.base37Table[(int)(var6 - var0 * 37L)];
					if (var8 == '_') {
						int var9 = var5.length() - 1;
						var5.setCharAt(var9, Character.toUpperCase(var5.charAt(var9)));
						var8 = 160;
					}
				}

				var5.reverse();
				var5.setCharAt(0, Character.toUpperCase(var5.charAt(0)));
				return var5.toString();
			}
		} else {
			return null;
		}
	}
}
