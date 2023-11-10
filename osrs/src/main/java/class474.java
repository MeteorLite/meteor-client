import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

@ObfuscatedName("sv")
public class class474 implements class473 {
	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "Lorg/json/JSONObject;"
	)
	JSONObject field3934;

	public class474(byte[] var1) throws UnsupportedEncodingException {
		this.method2355(var1);
	}

	public class474(JSONObject var1) {
		this.field3934 = var1;
	}

	public class474(String var1) throws UnsupportedEncodingException {
		this.method2356(var1);
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(B)Lsi;",
		garbageValue = "-24"
	)
	public class472 vmethod2213() {
		return class472.field3931;
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(B)[B",
		garbageValue = "0"
	)
	@Export("vmethod7797")
	public byte[] vmethod7797() throws UnsupportedEncodingException {
		return this.field3934 == null ? new byte[0] : this.field3934.toString().getBytes("UTF-8");
	}

	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "([BI)V",
		garbageValue = "-1436694020"
	)
	void method2355(byte[] var1) throws UnsupportedEncodingException {
		String var2 = new String(var1, "UTF-8");
		this.method2356(var2);
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;I)V",
		garbageValue = "1963139059"
	)
	void method2356(String var1) throws UnsupportedEncodingException {
		try {
			if (var1.charAt(0) == '{') {
				this.field3934 = new JSONObject(var1);
			} else {
				if (var1.charAt(0) != '[') {
					throw new UnsupportedEncodingException("Invalid JSON passed to the JSON content builder.");
				}

				JSONArray var2 = new JSONArray(var1);
				this.field3934 = new JSONObject();
				this.field3934.method2727("arrayValues", var2);
			}

		} catch (JSONException var3) {
			throw new UnsupportedEncodingException(var3.getMessage());
		}
	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "(B)Lorg/json/JSONObject;",
		garbageValue = "70"
	)
	public JSONObject method2357() {
		return this.field3934;
	}
}