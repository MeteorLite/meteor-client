import java.io.UnsupportedEncodingException;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("re")
public class class463 implements class462 {
	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "Lorg/json/JSONObject;"
	)
	JSONObject field3892;

	public class463(byte[] var1) throws UnsupportedEncodingException {
		this.method2313(var1);
	}

	@ObfuscatedSignature(
		descriptor = "(Lorg/json/JSONObject;)V"
	)
	public class463(JSONObject var1) {
		this.field3892 = var1;
	}

	public class463(String var1) throws UnsupportedEncodingException {
		this.method2314(var1);
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(I)Lrs;",
		garbageValue = "186741716"
	)
	public class461 vmethod2213() {
		return class461.field3889;
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(I)[B",
		garbageValue = "-587379873"
	)
	@Export("vmethod7797")
	public byte[] vmethod7797() throws UnsupportedEncodingException {
		return this.field3892 == null ? new byte[0] : this.field3892.toString().getBytes("UTF-8");
	}

	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		descriptor = "([BI)V",
		garbageValue = "-957035381"
	)
	void method2313(byte[] var1) throws UnsupportedEncodingException {
		String var2 = new String(var1, "UTF-8");
		this.method2314(var2);
	}

	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;B)V",
		garbageValue = "42"
	)
	void method2314(String var1) throws UnsupportedEncodingException {
		try {
			if (var1.charAt(0) == '{') {
				this.field3892 = new JSONObject(var1);
			} else {
				if (var1.charAt(0) != '[') {
					throw new UnsupportedEncodingException("Invalid JSON passed to the JSON content builder.");
				}

				JSONArray var2 = new JSONArray(var1);
				this.field3892 = new JSONObject();
				this.field3892.method2691("arrayValues", var2);
			}

		} catch (JSONException var3) {
			throw new UnsupportedEncodingException(var3.getMessage());
		}
	}

	@ObfuscatedName("av")
	@ObfuscatedSignature(
		descriptor = "(B)Lorg/json/JSONObject;",
		garbageValue = "0"
	)
	public JSONObject method2315() {
		return this.field3892;
	}
}
