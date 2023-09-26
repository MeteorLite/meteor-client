import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

@ObfuscatedName("si")
public class class477 implements class476 {
	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "Lorg/json/JSONObject;"
	)
	JSONObject field3936;

	public class477(byte[] var1) throws UnsupportedEncodingException {
		this.method2377(var1);
	}

	public class477(JSONObject var1) {
		this.field3936 = var1;
	}

	public class477(String var1) throws UnsupportedEncodingException {
		this.method2378(var1);
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(B)Lst;",
		garbageValue = "1"
	)
	public class475 vmethod2213() {
		return class475.field3933;
	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "(B)[B",
		garbageValue = "17"
	)
	@Export("vmethod7797")
	public byte[] vmethod7797() throws UnsupportedEncodingException {
		return this.field3936 == null ? new byte[0] : this.field3936.toString().getBytes("UTF-8");
	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "([BI)V",
		garbageValue = "-1876533299"
	)
	void method2377(byte[] var1) throws UnsupportedEncodingException {
		String var2 = new String(var1, "UTF-8");
		this.method2378(var2);
	}

	@ObfuscatedName("av")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;I)V",
		garbageValue = "-1250526518"
	)
	void method2378(String var1) throws UnsupportedEncodingException {
		try {
			if (var1.charAt(0) == '{') {
				this.field3936 = new JSONObject(var1);
			} else {
				if (var1.charAt(0) != '[') {
					throw new UnsupportedEncodingException("Invalid JSON passed to the JSON content builder.");
				}

				JSONArray var2 = new JSONArray(var1);
				this.field3936 = new JSONObject();
				this.field3936.method2750("arrayValues", var2);
			}

		} catch (JSONException var3) {
			throw new UnsupportedEncodingException(var3.getMessage());
		}
	}

	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		descriptor = "(S)Lorg/json/JSONObject;",
		garbageValue = "-32336"
	)
	public JSONObject method2379() {
		return this.field3936;
	}
}