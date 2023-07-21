import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("rx")
public class class464 implements class462 {
	@ObfuscatedName("aw")
	final Map field3893;

	public class464(Map var1) {
		this.field3893 = var1;
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(I)Lrs;",
		garbageValue = "186741716"
	)
	@Export("vmethod2213")
	public class461 vmethod2213() {
		return null;
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(I)[B",
		garbageValue = "-587379873"
	)
	@Export("vmethod7797")
	public byte[] vmethod7797() throws UnsupportedEncodingException {
		return this.method2319().getBytes("UTF-8");
	}

	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		descriptor = "(I)Ljava/lang/String;",
		garbageValue = "1821639668"
	)
	public String method2319() throws UnsupportedEncodingException {
		StringBuilder var1 = new StringBuilder();
		Iterator var2 = this.field3893.entrySet().iterator();

		while (var2.hasNext()) {
			Entry var3 = (Entry)var2.next();
			String var4 = URLEncoder.encode((String)var3.getKey(), "UTF-8");
			String var5 = URLEncoder.encode((String)var3.getValue(), "UTF-8");
			var1.append(var4).append("=").append(var5).append("&");
		}

		if (var1.length() == 0) {
			return "";
		} else {
			var1.deleteCharAt(var1.length() - 1);
			var1.insert(0, "?");
			return var1.toString();
		}
	}
}
