import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@ObfuscatedName("gf")
public class class170 {
	@ObfuscatedName("aa")
	int field1443;
	@ObfuscatedName("af")
	String field1444;
	@ObfuscatedName("ad")
	@ObfuscatedSignature(
		descriptor = "Let;"
	)
	UrlRequest field1441;
	@ObfuscatedName("aq")
	String field1445;
	@ObfuscatedName("al")
	float[] field1442;
	@ObfuscatedName("an")
	ArrayList field1447;
	@ObfuscatedName("ar")
	ArrayList field1448;
	@ObfuscatedName("ab")
	ArrayList field1446;
	@ObfuscatedName("ag")
	Map field1449;
	@ObfuscatedName("am")
	Map field1450;

	public class170() {
		this.field1443 = -1;
		this.field1445 = null;
		this.field1442 = new float[4];
		this.field1447 = new ArrayList();
		this.field1448 = new ArrayList();
		this.field1446 = new ArrayList();
		this.field1449 = new HashMap();
		this.field1450 = new HashMap();
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;Lev;I)Z",
		garbageValue = "-117070837"
	)
	public boolean method881(String var1, UrlRequester var2) {
		if (var1 != null && !var1.isEmpty()) {
			if (var2 == null) {
				return false;
			} else {
				this.method891();

				try {
					this.field1444 = var1;
					this.field1441 = var2.request(new URL(this.field1444));
					this.field1443 = 0;
					return true;
				} catch (MalformedURLException var4) {
					this.method891();
					this.field1443 = 100;
					return false;
				}
			}
		} else {
			return false;
		}
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(Lev;I)V",
		garbageValue = "-1262385396"
	)
	public void method882(UrlRequester var1) {
		switch(this.field1443) {
		case 0:
			this.method892(var1);
			break;
		case 1:
			this.method893();
			break;
		default:
			return;
		}

	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "1206059947"
	)
	public int method883() {
		return this.field1443;
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;I)I",
		garbageValue = "-63404292"
	)
	public int method884(String var1) {
		return this.field1449.containsKey(var1) ? (Integer)this.field1449.get(var1) : -1;
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;I)Ljava/lang/String;",
		garbageValue = "-1647715363"
	)
	public String method885(String var1) {
		return (String)((String)(this.field1450.containsKey(var1) ? this.field1450.get(var1) : null));
	}

	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		descriptor = "(B)Ljava/util/ArrayList;",
		garbageValue = "-87"
	)
	public ArrayList method886() {
		return this.field1448;
	}

	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "(B)Ljava/util/ArrayList;",
		garbageValue = "88"
	)
	public ArrayList method887() {
		return this.field1446;
	}

	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		descriptor = "(I)Ljava/lang/String;",
		garbageValue = "-1756409477"
	)
	public String method888() {
		return this.field1445;
	}

	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "(I)[F",
		garbageValue = "-2115403959"
	)
	public float[] method889() {
		return this.field1442;
	}

	@ObfuscatedName("af")
	@ObfuscatedSignature(
		descriptor = "(B)Ljava/util/ArrayList;",
		garbageValue = "-78"
	)
	public ArrayList method890() {
		return this.field1447;
	}

	@ObfuscatedName("ad")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "22"
	)
	void method891() {
		this.field1441 = null;
		this.field1445 = null;
		this.field1442[0] = 0.0F;
		this.field1442[1] = 0.0F;
		this.field1442[2] = 1.0F;
		this.field1442[3] = 1.0F;
		this.field1447.clear();
		this.field1448.clear();
		this.field1446.clear();
		this.field1449.clear();
		this.field1450.clear();
	}

	@ObfuscatedName("aq")
	@ObfuscatedSignature(
		descriptor = "(Lev;B)V",
		garbageValue = "-76"
	)
	void method892(UrlRequester var1) {
		if (this.field1441 != null && this.field1441.isDone()) {
			byte[] var2 = this.field1441.getResponse();
			if (var2 == null) {
				this.method891();
				this.field1443 = 100;
			} else {
				try {
					this.method898(new class462(var2), var1);
				} catch (UnsupportedEncodingException var4) {
					this.method891();
					this.field1443 = 102;
					return;
				}

				this.field1443 = this.field1448.size() > 0 ? 1 : 2;
				this.field1441 = null;
			}
		}
	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-2026180069"
	)
	void method893() {
		Iterator var1 = this.field1448.iterator();

		class176 var2;
		do {
			if (!var1.hasNext()) {
				var1 = this.field1448.iterator();

				while (var1.hasNext()) {
					var2 = (class176)var1.next();
					if (var2.field1469 != null) {
						byte[] var3 = var2.field1469.getResponse();
						if (var3 != null && var3.length > 0) {
							this.field1443 = 2;
							return;
						}
					}
				}

				this.method891();
				this.field1443 = 101;
				return;
			}

			var2 = (class176)var1.next();
		} while(var2.field1469 == null || var2.field1469.isDone());

	}

	@ObfuscatedName("an")
	@ObfuscatedSignature(
		descriptor = "(Lorg/json/JSONArray;Lev;B)V",
		garbageValue = "-22"
	)
	void method894(JSONArray var1, UrlRequester var2) throws JSONException {
		if (var1 != null) {
			for (int var3 = 0; var3 < var1.length(); ++var3) {
				try {
					JSONObject var4 = var1.getJSONObject(var3);
					class176 var5 = new class176(this);
					var5.field1469 = var2.request(new URL(var4.getString("src")));
					var5.field1470 = UserComparator5.method679(var4, "placement");
					this.field1448.add(var5);
				} catch (MalformedURLException var6) {
				}
			}

		}
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(Lorg/json/JSONArray;I)V",
		garbageValue = "205832282"
	)
	void method895(JSONArray var1) throws JSONException {
		if (var1 != null) {
			for (int var2 = 0; var2 < var1.length(); ++var2) {
				JSONObject var3 = var1.getJSONObject(var2);
				class177 var4 = new class177(this);
				var4.field1476 = var3.getString("text");
				String var7 = var3.getString("align_x");
				byte var6;
				if (var7.equals("centre")) {
					var6 = 1;
				} else if (!var7.equals("bottom") && !var7.equals("right")) {
					var6 = 0;
				} else {
					var6 = 2;
				}

				var4.field1473 = var6;
				String var10 = var3.getString("align_y");
				byte var9;
				if (var10.equals("centre")) {
					var9 = 1;
				} else if (!var10.equals("bottom") && !var10.equals("right")) {
					var9 = 0;
				} else {
					var9 = 2;
				}

				var4.field1475 = var9;
				var4.field1474 = var3.getInt("font");
				var4.field1472 = UserComparator5.method679(var3, "placement");
				this.field1446.add(var4);
			}

		}
	}

	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "(Lorg/json/JSONObject;I)V",
		garbageValue = "3730991"
	)
	void method896(JSONObject var1) throws JSONException {
		if (var1 != null) {
			this.field1442 = UserComparator5.method679(var1, "clickbounds");
			this.field1445 = var1.getString("endpoint");
			String[] var2 = JSONObject.getNames(var1);

			for (int var3 = 0; var3 < var1.length(); ++var3) {
				if (!var2[var3].equals("clickbounds") && !var2[var3].equals("endpoint")) {
					try {
						int var4 = var1.getInt(var2[var3]);
						this.field1447.add(new class178(this, var2[var3], var4));
					} catch (Exception var8) {
						try {
							String var5 = var1.getString(var2[var3]);
							if (var5.equals("true")) {
								this.field1447.add(new class178(this, var2[var3], 1));
							} else if (var5.equals("false")) {
								this.field1447.add(new class178(this, var2[var3], 0));
							} else {
								this.field1447.add(new class169(this, var2[var3], var5));
							}
						} catch (Exception var7) {
						}
					}
				}
			}

		}
	}

	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		descriptor = "(Lorg/json/JSONObject;B)V",
		garbageValue = "-60"
	)
	void method897(JSONObject var1) throws JSONException {
		String[] var2 = JSONObject.getNames(var1);

		for (int var3 = 0; var3 < var1.length(); ++var3) {
			try {
				int var4 = var1.getInt(var2[var3]);
				this.field1449.put(var2[var3], var4);
			} catch (Exception var8) {
				try {
					String var5 = var1.getString(var2[var3]);
					if (var5.equals("true")) {
						this.field1449.put(var2[var3], 1);
					} else if (var5.equals("false")) {
						this.field1449.put(var2[var3], 0);
					} else {
						this.field1450.put(var2[var3], var5);
					}
				} catch (Exception var7) {
				}
			}
		}

	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "(Lrl;Lev;B)V",
		garbageValue = "80"
	)
	void method898(class462 var1, UrlRequester var2) {
		JSONObject var3;
		try {
			var3 = var1.method2338();
			var3 = var3.getJSONObject("message");
		} catch (Exception var9) {
			this.method891();
			this.field1443 = 102;
			return;
		}

		try {
			this.method894(var3.getJSONArray("images"), var2);
		} catch (Exception var8) {
			this.field1448.clear();
		}

		try {
			this.method895(var3.getJSONArray("labels"));
		} catch (Exception var7) {
			this.field1446.clear();
		}

		try {
			this.method896(var3.getJSONObject("behaviour"));
		} catch (Exception var6) {
			this.field1445 = null;
			this.field1442[0] = 0.0F;
			this.field1442[1] = 0.0F;
			this.field1442[2] = 1.0F;
			this.field1442[3] = 1.0F;
			this.field1447.clear();
		}

		try {
			this.method897(var3.getJSONObject("meta"));
		} catch (Exception var5) {
			this.field1449.clear();
			this.field1450.clear();
		}

	}

	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;Lev;I)Z",
		garbageValue = "1404178579"
	)
	public boolean method899(String var1, UrlRequester var2) {
		try {
			this.method898(new class462(var1.getBytes()), var2);
			this.field1443 = this.field1448.size() > 0 ? 1 : 2;
		} catch (UnsupportedEncodingException var4) {
			this.field1443 = 102;
		}

		return this.field1443 < 100;
	}

	@ObfuscatedName("bc")
	@ObfuscatedSignature(
		descriptor = "(ILdh;ZI)I",
		garbageValue = "1176704124"
	)
	static int method900(int var0, Script var1, boolean var2) {
		return 2;
	}
}