import java.io.UnsupportedEncodingException;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("om")
public class class401 implements class400 {
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		descriptor = "Lorg/json/JSONObject;"
	)
	JSONObject field4474;

	public class401(byte[] var1) throws UnsupportedEncodingException {
		this.method7308(var1);
	}

	public class401(String var1) throws UnsupportedEncodingException {
		this.method7306(var1);
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "(I)[B",
		garbageValue = "-606305433"
	)
	public byte[] vmethod7323() throws UnsupportedEncodingException {
		return this.field4474 == null ? new byte[0] : this.field4474.toString().getBytes("UTF-8");
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		descriptor = "([BI)V",
		garbageValue = "-65625485"
	)
	void method7308(byte[] var1) throws UnsupportedEncodingException {
		String var2 = new String(var1, "UTF-8");
		this.method7306(var2);
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;I)V",
		garbageValue = "-2069444703"
	)
	void method7306(String var1) throws UnsupportedEncodingException {
		try {
			if (var1.charAt(0) == '{') {
				this.field4474 = new JSONObject(var1);
			} else {
				if (var1.charAt(0) != '[') {
					throw new UnsupportedEncodingException("Invalid JSON passed to the JSON content builder.");
				}

				JSONArray var2 = new JSONArray(var1);
				this.field4474 = new JSONObject();
				this.field4474.method8562("arrayValues", var2);
			}

		} catch (JSONException var3) {
			throw new UnsupportedEncodingException(var3.getMessage());
		}
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		descriptor = "(I)LJSONObject;",
		garbageValue = "611549048"
	)
	public JSONObject method7307() {
		return this.field4474;
	}
}
