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

@ObfuscatedName("ic")
public class class208 {
	@ObfuscatedName("al")
	int field1829;
	@ObfuscatedName("az")
	String field1831;
	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		descriptor = "Lea;"
	)
	UrlRequest field1827;
	@ObfuscatedName("av")
	String field1830;
	@ObfuscatedName("ax")
	float[] field1828;
	@ObfuscatedName("as")
	ArrayList field1833;
	@ObfuscatedName("ay")
	ArrayList field1834;
	@ObfuscatedName("ak")
	ArrayList field1832;
	@ObfuscatedName("aj")
	Map field1835;
	@ObfuscatedName("am")
	Map field1836;

	public class208() {
		this.field1829 = -1;
		this.field1830 = null;
		this.field1828 = new float[4];
		this.field1833 = new ArrayList();
		this.field1834 = new ArrayList();
		this.field1832 = new ArrayList();
		this.field1835 = new HashMap();
		this.field1836 = new HashMap();
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;Lel;B)Z",
		garbageValue = "-18"
	)
	public boolean method1063(String var1, UrlRequester var2) {
		if (var1 != null && !var1.isEmpty()) {
			if (var2 == null) {
				return false;
			} else {
				this.method1073();

				try {
					this.field1831 = var1;
					this.field1827 = var2.request(new URL(this.field1831));
					this.field1829 = 0;
					return true;
				} catch (MalformedURLException var4) {
					this.method1073();
					this.field1829 = 100;
					return false;
				}
			}
		} else {
			return false;
		}
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(Lel;I)V",
		garbageValue = "1589272882"
	)
	public void method1064(UrlRequester var1) {
		switch(this.field1829) {
		case 0:
			this.method1074(var1);
			break;
		case 1:
			this.method1075();
			break;
		default:
			return;
		}

	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "-1"
	)
	public int method1065() {
		return this.field1829;
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;I)I",
		garbageValue = "256889728"
	)
	public int method1066(String var1) {
		return this.field1835.containsKey(var1) ? (Integer)this.field1835.get(var1) : -1;
	}

	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;I)Ljava/lang/String;",
		garbageValue = "1206229207"
	)
	public String method1067(String var1) {
		return (String)((String)(this.field1836.containsKey(var1) ? this.field1836.get(var1) : null));
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(I)Ljava/util/ArrayList;",
		garbageValue = "2021801100"
	)
	public ArrayList method1068() {
		return this.field1834;
	}

	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "(I)Ljava/util/ArrayList;",
		garbageValue = "-2096187297"
	)
	public ArrayList method1069() {
		return this.field1832;
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(I)Ljava/lang/String;",
		garbageValue = "-944579598"
	)
	public String method1070() {
		return this.field1830;
	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "(B)[F",
		garbageValue = "94"
	)
	public float[] method1071() {
		return this.field1828;
	}

	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "(I)Ljava/util/ArrayList;",
		garbageValue = "523040657"
	)
	public ArrayList method1072() {
		return this.field1833;
	}

	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "64156006"
	)
	void method1073() {
		this.field1827 = null;
		this.field1830 = null;
		this.field1828[0] = 0.0F;
		this.field1828[1] = 0.0F;
		this.field1828[2] = 1.0F;
		this.field1828[3] = 1.0F;
		this.field1833.clear();
		this.field1834.clear();
		this.field1832.clear();
		this.field1835.clear();
		this.field1836.clear();
	}

	@ObfuscatedName("av")
	@ObfuscatedSignature(
		descriptor = "(Lel;I)V",
		garbageValue = "357044570"
	)
	void method1074(UrlRequester var1) {
		if (this.field1827 != null && this.field1827.isDone()) {
			byte[] var2 = this.field1827.getResponse();
			if (var2 == null) {
				this.method1073();
				this.field1829 = 100;
			} else {
				try {
					this.method1080(new class474(var2), var1);
				} catch (UnsupportedEncodingException var4) {
					this.method1073();
					this.field1829 = 102;
					return;
				}

				this.field1829 = this.field1834.size() > 0 ? 1 : 2;
				this.field1827 = null;
			}
		}
	}

	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-841261467"
	)
	void method1075() {
		Iterator var1 = this.field1834.iterator();

		class214 var2;
		do {
			if (!var1.hasNext()) {
				var1 = this.field1834.iterator();

				while (var1.hasNext()) {
					var2 = (class214)var1.next();
					if (var2.field1852 != null) {
						byte[] var3 = var2.field1852.getResponse();
						if (var3 != null && var3.length > 0) {
							this.field1829 = 2;
							return;
						}
					}
				}

				this.method1073();
				this.field1829 = 101;
				return;
			}

			var2 = (class214)var1.next();
		} while(var2.field1852 == null || var2.field1852.isDone());

	}

	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "(Lorg/json/JSONArray;Lel;I)V",
		garbageValue = "-1649177141"
	)
	void method1076(JSONArray var1, UrlRequester var2) throws JSONException {
		if (var1 != null) {
			for (int var3 = 0; var3 < var1.length(); ++var3) {
				try {
					JSONObject var4 = var1.getJSONObject(var3);
					class214 var5 = new class214(this);
					var5.field1852 = var2.request(new URL(var4.getString("src")));
					var5.field1853 = class9.method27(var4, "placement");
					this.field1834.add(var5);
				} catch (MalformedURLException var6) {
				}
			}

		}
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(Lorg/json/JSONArray;B)V",
		garbageValue = "1"
	)
	void method1077(JSONArray var1) throws JSONException {
		if (var1 != null) {
			for (int var2 = 0; var2 < var1.length(); ++var2) {
				JSONObject var3 = var1.getJSONObject(var2);
				class215 var4 = new class215(this);
				var4.field1859 = var3.getString("text");
				var4.field1858 = class33.method143(var3.getString("align_x"));
				var4.field1856 = class33.method143(var3.getString("align_y"));
				var4.field1857 = var3.getInt("font");
				var4.field1855 = class9.method27(var3, "placement");
				this.field1832.add(var4);
			}

		}
	}

	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "(Lorg/json/JSONObject;I)V",
		garbageValue = "1286553511"
	)
	void method1078(JSONObject var1) throws JSONException {
		if (var1 != null) {
			this.field1828 = class9.method27(var1, "clickbounds");
			this.field1830 = var1.getString("endpoint");
			String[] var2 = JSONObject.getNames(var1);

			for (int var3 = 0; var3 < var1.length(); ++var3) {
				if (!var2[var3].equals("clickbounds") && !var2[var3].equals("endpoint")) {
					try {
						int var4 = var1.getInt(var2[var3]);
						this.field1833.add(new class216(this, var2[var3], var4));
					} catch (Exception var8) {
						try {
							String var5 = var1.getString(var2[var3]);
							if (var5.equals("true")) {
								this.field1833.add(new class216(this, var2[var3], 1));
							} else if (var5.equals("false")) {
								this.field1833.add(new class216(this, var2[var3], 0));
							} else {
								this.field1833.add(new class207(this, var2[var3], var5));
							}
						} catch (Exception var7) {
						}
					}
				}
			}

		}
	}

	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		descriptor = "(Lorg/json/JSONObject;B)V",
		garbageValue = "-85"
	)
	void method1079(JSONObject var1) throws JSONException {
		String[] var2 = JSONObject.getNames(var1);

		for (int var3 = 0; var3 < var1.length(); ++var3) {
			try {
				int var4 = var1.getInt(var2[var3]);
				this.field1835.put(var2[var3], var4);
			} catch (Exception var8) {
				try {
					String var5 = var1.getString(var2[var3]);
					if (var5.equals("true")) {
						this.field1835.put(var2[var3], 1);
					} else if (var5.equals("false")) {
						this.field1835.put(var2[var3], 0);
					} else {
						this.field1836.put(var2[var3], var5);
					}
				} catch (Exception var7) {
				}
			}
		}

	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "(Lsv;Lel;I)V",
		garbageValue = "1323384211"
	)
	void method1080(class474 var1, UrlRequester var2) {
		JSONObject var3;
		try {
			var3 = var1.method2357();
			var3 = var3.getJSONObject("message");
		} catch (Exception var9) {
			this.method1073();
			this.field1829 = 102;
			return;
		}

		try {
			this.method1076(var3.getJSONArray("images"), var2);
		} catch (Exception var8) {
			this.field1834.clear();
		}

		try {
			this.method1077(var3.getJSONArray("labels"));
		} catch (Exception var7) {
			this.field1832.clear();
		}

		try {
			this.method1078(var3.getJSONObject("behaviour"));
		} catch (Exception var6) {
			this.field1830 = null;
			this.field1828[0] = 0.0F;
			this.field1828[1] = 0.0F;
			this.field1828[2] = 1.0F;
			this.field1828[3] = 1.0F;
			this.field1833.clear();
		}

		try {
			this.method1079(var3.getJSONObject("meta"));
		} catch (Exception var5) {
			this.field1835.clear();
			this.field1836.clear();
		}

	}

	@ObfuscatedName("aq")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;Lel;I)Z",
		garbageValue = "348701890"
	)
	public boolean method1081(String var1, UrlRequester var2) {
		try {
			this.method1080(new class474(var1.getBytes()), var2);
			this.field1829 = this.field1834.size() > 0 ? 1 : 2;
		} catch (UnsupportedEncodingException var4) {
			this.field1829 = 102;
		}

		return this.field1829 < 100;
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "1432052010"
	)
	public static void method1062() {
		class174.archive7.clear();
	}
}