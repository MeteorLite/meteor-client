import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

@ObfuscatedName("rl")
public class class462 implements class461 {
	@ObfuscatedName("at")
	public static int field3904;
	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "Lorg/json/JSONObject;"
	)
	JSONObject field3905;

	public class462(byte[] var1) throws UnsupportedEncodingException {
		this.method2336(var1);
	}

	public class462(JSONObject var1) {
		this.field3905 = var1;
	}

	public class462(String var1) throws UnsupportedEncodingException {
		this.method2337(var1);
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(I)Lre;",
		garbageValue = "1843960357"
	)
	public class460 vmethod2213() {
		return class460.field3901;
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(I)[B",
		garbageValue = "-2012768243"
	)
	@Export("vmethod7797")
	public byte[] vmethod7797() throws UnsupportedEncodingException {
		return this.field3905 == null ? new byte[0] : this.field3905.toString().getBytes("UTF-8");
	}

	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		descriptor = "([BB)V",
		garbageValue = "-68"
	)
	void method2336(byte[] var1) throws UnsupportedEncodingException {
		String var2 = new String(var1, "UTF-8");
		this.method2337(var2);
	}

	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;B)V",
		garbageValue = "-32"
	)
	void method2337(String var1) throws UnsupportedEncodingException {
		try {
			if (var1.charAt(0) == '{') {
				this.field3905 = new JSONObject(var1);
			} else {
				if (var1.charAt(0) != '[') {
					throw new UnsupportedEncodingException("Invalid JSON passed to the JSON content builder.");
				}

				JSONArray var2 = new JSONArray(var1);
				this.field3905 = new JSONObject();
				this.field3905.method2709("arrayValues", var2);
			}

		} catch (JSONException var3) {
			throw new UnsupportedEncodingException(var3.getMessage());
		}
	}

	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		descriptor = "(B)Lorg/json/JSONObject;",
		garbageValue = "-30"
	)
	public JSONObject method2338() {
		return this.field3905;
	}
}