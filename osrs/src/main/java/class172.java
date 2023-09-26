import net.runelite.mapping.Export;
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

@ObfuscatedName("gr")
public class class172 {
	@ObfuscatedName("am")
	int field1431;
	@ObfuscatedName("av")
	String field1433;
	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		descriptor = "Leq;"
	)
	UrlRequest field1429;
	@ObfuscatedName("aa")
	String field1432;
	@ObfuscatedName("ap")
	float[] field1430;
	@ObfuscatedName("ay")
	ArrayList field1436;
	@ObfuscatedName("as")
	ArrayList field1435;
	@ObfuscatedName("aj")
	ArrayList field1434;
	@ObfuscatedName("an")
	Map field1437;
	@ObfuscatedName("au")
	Map field1438;

	public class172() {
		this.field1431 = -1;
		this.field1432 = null;
		this.field1430 = new float[4];
		this.field1436 = new ArrayList();
		this.field1435 = new ArrayList();
		this.field1434 = new ArrayList();
		this.field1437 = new HashMap();
		this.field1438 = new HashMap();
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;Len;I)Z",
		garbageValue = "2131230297"
	)
	public boolean method887(String var1, UrlRequester var2) {
		if (var1 != null && !var1.isEmpty()) {
			if (var2 == null) {
				return false;
			} else {
				this.method899();

				try {
					this.field1433 = var1;
					this.field1429 = var2.request(new URL(this.field1433));
					this.field1431 = 0;
					return true;
				} catch (MalformedURLException var4) {
					this.method899();
					this.field1431 = 100;
					return false;
				}
			}
		} else {
			return false;
		}
	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "(Len;I)V",
		garbageValue = "-1476947490"
	)
	public void method888(UrlRequester var1) {
		switch(this.field1431) {
		case 0:
			this.method900(var1);
			break;
		case 1:
			this.method901();
			break;
		default:
			return;
		}

	}

	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "-1358158711"
	)
	public int method890() {
		return this.field1431;
	}

	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;I)I",
		garbageValue = "778119532"
	)
	public int method891(String var1) {
		return this.field1437.containsKey(var1) ? (Integer)this.field1437.get(var1) : -1;
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;I)Ljava/lang/String;",
		garbageValue = "-1794264749"
	)
	public String method892(String var1) {
		return (String)((String)(this.field1438.containsKey(var1) ? this.field1438.get(var1) : null));
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(I)Ljava/util/ArrayList;",
		garbageValue = "-1636742003"
	)
	public ArrayList method893() {
		return this.field1435;
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(I)Ljava/util/ArrayList;",
		garbageValue = "-1336792690"
	)
	public ArrayList method894() {
		return this.field1434;
	}

	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "(B)Ljava/lang/String;",
		garbageValue = "-5"
	)
	public String method896() {
		return this.field1432;
	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "(B)[F",
		garbageValue = "82"
	)
	public float[] method897() {
		return this.field1430;
	}

	@ObfuscatedName("av")
	@ObfuscatedSignature(
		descriptor = "(I)Ljava/util/ArrayList;",
		garbageValue = "-1672118960"
	)
	public ArrayList method898() {
		return this.field1436;
	}

	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "1"
	)
	void method899() {
		this.field1429 = null;
		this.field1432 = null;
		this.field1430[0] = 0.0F;
		this.field1430[1] = 0.0F;
		this.field1430[2] = 1.0F;
		this.field1430[3] = 1.0F;
		this.field1436.clear();
		this.field1435.clear();
		this.field1434.clear();
		this.field1437.clear();
		this.field1438.clear();
	}

	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "(Len;S)V",
		garbageValue = "182"
	)
	void method900(UrlRequester var1) {
		if (this.field1429 != null && this.field1429.isDone()) {
			byte[] var2 = this.field1429.getResponse();
			if (var2 == null) {
				this.method899();
				this.field1431 = 100;
			} else {
				try {
					this.method906(new class477(var2), var1);
				} catch (UnsupportedEncodingException var4) {
					this.method899();
					this.field1431 = 102;
					return;
				}

				this.field1431 = this.field1435.size() > 0 ? 1 : 2;
				this.field1429 = null;
			}
		}
	}

	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "14"
	)
	void method901() {
		Iterator var1 = this.field1435.iterator();

		class178 var2;
		do {
			if (!var1.hasNext()) {
				var1 = this.field1435.iterator();

				while (var1.hasNext()) {
					var2 = (class178)var1.next();
					if (var2.field1460 != null) {
						byte[] var3 = var2.field1460.getResponse();
						if (var3 != null && var3.length > 0) {
							this.field1431 = 2;
							return;
						}
					}
				}

				this.method899();
				this.field1431 = 101;
				return;
			}

			var2 = (class178)var1.next();
		} while(var2.field1460 == null || var2.field1460.isDone());

	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(Lorg/json/JSONArray;Len;I)V",
		garbageValue = "-2004474628"
	)
	void method902(JSONArray var1, UrlRequester var2) throws JSONException {
		if (var1 != null) {
			for (int var3 = 0; var3 < var1.length(); ++var3) {
				try {
					JSONObject var4 = var1.getJSONObject(var3);
					class178 var5 = new class178(this);
					var5.field1460 = var2.request(new URL(var4.getString("src")));
					var5.field1461 = FloorUnderlayDefinition.method1043(var4, "placement");
					this.field1435.add(var5);
				} catch (MalformedURLException var6) {
				}
			}

		}
	}

	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "(Lorg/json/JSONArray;I)V",
		garbageValue = "1577665850"
	)
	void method903(JSONArray var1) throws JSONException {
		if (var1 != null) {
			for (int var2 = 0; var2 < var1.length(); ++var2) {
				JSONObject var3 = var1.getJSONObject(var2);
				class179 var4 = new class179(this);
				var4.field1466 = var3.getString("text");
				String var7 = var3.getString("align_x");
				byte var6;
				if (var7.equals("centre")) {
					var6 = 1;
				} else if (!var7.equals("bottom") && !var7.equals("right")) {
					var6 = 0;
				} else {
					var6 = 2;
				}

				var4.field1464 = var6;
				String var10 = var3.getString("align_y");
				byte var9;
				if (var10.equals("centre")) {
					var9 = 1;
				} else if (!var10.equals("bottom") && !var10.equals("right")) {
					var9 = 0;
				} else {
					var9 = 2;
				}

				var4.field1465 = var9;
				var4.field1463 = var3.getInt("font");
				var4.field1462 = FloorUnderlayDefinition.method1043(var3, "placement");
				this.field1434.add(var4);
			}

		}
	}

	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		descriptor = "(Lorg/json/JSONObject;B)V",
		garbageValue = "-11"
	)
	void method904(JSONObject var1) throws JSONException {
		if (var1 != null) {
			this.field1430 = FloorUnderlayDefinition.method1043(var1, "clickbounds");
			this.field1432 = var1.getString("endpoint");
			String[] var2 = JSONObject.getNames(var1);

			for (int var3 = 0; var3 < var1.length(); ++var3) {
				if (!var2[var3].equals("clickbounds") && !var2[var3].equals("endpoint")) {
					try {
						int var4 = var1.getInt(var2[var3]);
						this.field1436.add(new class180(this, var2[var3], var4));
					} catch (Exception var8) {
						try {
							String var5 = var1.getString(var2[var3]);
							if (var5.equals("true")) {
								this.field1436.add(new class180(this, var2[var3], 1));
							} else if (var5.equals("false")) {
								this.field1436.add(new class180(this, var2[var3], 0));
							} else {
								this.field1436.add(new class171(this, var2[var3], var5));
							}
						} catch (Exception var7) {
						}
					}
				}
			}

		}
	}

	@ObfuscatedName("an")
	@ObfuscatedSignature(
		descriptor = "(Lorg/json/JSONObject;I)V",
		garbageValue = "-451947529"
	)
	void method905(JSONObject var1) throws JSONException {
		String[] var2 = JSONObject.getNames(var1);

		for (int var3 = 0; var3 < var1.length(); ++var3) {
			try {
				int var4 = var1.getInt(var2[var3]);
				this.field1437.put(var2[var3], var4);
			} catch (Exception var8) {
				try {
					String var5 = var1.getString(var2[var3]);
					if (var5.equals("true")) {
						this.field1437.put(var2[var3], 1);
					} else if (var5.equals("false")) {
						this.field1437.put(var2[var3], 0);
					} else {
						this.field1438.put(var2[var3], var5);
					}
				} catch (Exception var7) {
				}
			}
		}

	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(Lsi;Len;B)V",
		garbageValue = "0"
	)
	void method906(class477 var1, UrlRequester var2) {
		JSONObject var3;
		try {
			var3 = var1.method2379();
			var3 = var3.getJSONObject("message");
		} catch (Exception var9) {
			this.method899();
			this.field1431 = 102;
			return;
		}

		try {
			this.method902(var3.getJSONArray("images"), var2);
		} catch (Exception var8) {
			this.field1435.clear();
		}

		try {
			this.method903(var3.getJSONArray("labels"));
		} catch (Exception var7) {
			this.field1434.clear();
		}

		try {
			this.method904(var3.getJSONObject("behaviour"));
		} catch (Exception var6) {
			this.field1432 = null;
			this.field1430[0] = 0.0F;
			this.field1430[1] = 0.0F;
			this.field1430[2] = 1.0F;
			this.field1430[3] = 1.0F;
			this.field1436.clear();
		}

		try {
			this.method905(var3.getJSONObject("meta"));
		} catch (Exception var5) {
			this.field1437.clear();
			this.field1438.clear();
		}

	}

	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;Len;I)Z",
		garbageValue = "16776960"
	)
	public boolean method907(String var1, UrlRequester var2) {
		try {
			this.method906(new class477(var1.getBytes()), var2);
			this.field1431 = this.field1435.size() > 0 ? 1 : 2;
		} catch (UnsupportedEncodingException var4) {
			this.field1431 = 102;
		}

		return this.field1431 < 100;
	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "(Lul;B)Ljava/lang/String;",
		garbageValue = "100"
	)
	@Export("readString")
	public static String readString(Buffer var0) {
		String var1;
		try {
			int var2 = var0.readUShortSmart();
			if (var2 > 32767) {
				var2 = 32767;
			}

			byte[] var3 = new byte[var2];
			var0.offset += class349.huffman.decompress(var0.array, var0.offset, var3, 0, var2);
			String var4 = class92.decodeStringCp1252(var3, 0, var2);
			var1 = var4;
		} catch (Exception var6) {
			var1 = "Cabbage";
		}

		return var1;
	}

	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "(II)I",
		garbageValue = "-955507774"
	)
	@Export("iLog")
	public static int iLog(int var0) {
		int var1 = 0;
		if (var0 < 0 || var0 >= 65536) {
			var0 >>>= 16;
			var1 += 16;
		}

		if (var0 >= 256) {
			var0 >>>= 8;
			var1 += 8;
		}

		if (var0 >= 16) {
			var0 >>>= 4;
			var1 += 4;
		}

		if (var0 >= 4) {
			var0 >>>= 2;
			var1 += 2;
		}

		if (var0 >= 1) {
			var0 >>>= 1;
			++var1;
		}

		return var0 + var1;
	}

	@ObfuscatedName("ny")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "1926904038"
	)
	static final void method908() {
		Client.field525 = Client.cycleCntr;
		PcmPlayer.field180 = true;
	}
}