import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import javax.net.ssl.HttpsURLConnection;
import java.text.DecimalFormat;
import java.util.*;
import java.util.Map.Entry;

@ObfuscatedName("qv")
public class class434 {
	@ObfuscatedName("wj")
	@ObfuscatedSignature(
		descriptor = "Ltu;"
	)
	@Export("worldMap")
	static WorldMap worldMap;
	@ObfuscatedName("ax")
	final Map field3796;
	@ObfuscatedName("ao")
	final Map field3795;
	@ObfuscatedName("ah")
	final DecimalFormat field3794;

	public class434() {
		this.field3796 = new HashMap();
		this.field3795 = new HashMap();
		this.field3794 = new DecimalFormat();
		this.field3794.setMaximumFractionDigits(2);
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(Ljavax/net/ssl/HttpsURLConnection;B)V",
		garbageValue = "69"
	)
	public void method2196(HttpsURLConnection var1) {
		Iterator var2 = this.field3796.entrySet().iterator();

		while (var2.hasNext()) {
			Entry var3 = (Entry)var2.next();
			var1.setRequestProperty((String)var3.getKey(), (String)var3.getValue());
		}

	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "(I)Ljava/util/Map;",
		garbageValue = "-1436798954"
	)
	public Map method2197() {
		return this.field3796;
	}

	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;Ljava/lang/String;I)V",
		garbageValue = "2031585126"
	)
	public void method2198(String var1, String var2) {
		if (var1 != null && !var1.isEmpty()) {
			this.field3796.put(var1, var2 != null ? var2 : "");
		}

	}

	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;I)V",
		garbageValue = "-476420420"
	)
	public void method2199(String var1) {
		if (var1 != null && !var1.isEmpty()) {
			this.field3796.remove(var1);
		}

	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(Lqf;Ljava/lang/String;B)V",
		garbageValue = "38"
	)
	void method2200(class433 var1, String var2) {
		String var3 = String.format("%s %s", var1.method2195(), var2);
		this.method2198("Authorization", var3);
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;I)V",
		garbageValue = "696444770"
	)
	public void method2201(String var1) {
		this.method2200(class433.field3790, var1);
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;I)V",
		garbageValue = "-1668239999"
	)
	public void method2202(String var1) {
		this.method2200(class433.field3791, var1);
	}

	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "(Lst;I)V",
		garbageValue = "1867259345"
	)
	public void method2203(class475 var1) {
		this.field3796.put("Content-Type", var1.method2373());
	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "25"
	)
	public void method2204() {
		this.field3796.remove("Content-Type");
	}

	@ObfuscatedName("av")
	@ObfuscatedSignature(
		descriptor = "(Lst;I)V",
		garbageValue = "807760846"
	)
	public void method2205(class475 var1) {
		this.method2206(var1, 1.0F);
	}

	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		descriptor = "(Lst;FI)V",
		garbageValue = "1069776907"
	)
	void method2206(class475 var1, float var2) {
		this.field3795.put(var1, Math.max(0.0F, Math.min(1.0F, var2)));
		this.method2207();
	}

	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "-118"
	)
	void method2207() {
		this.field3796.remove("Accept");
		if (!this.field3795.isEmpty()) {
			this.field3796.put("Accept", this.method2208());
		}

	}

	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		descriptor = "(B)Ljava/lang/String;",
		garbageValue = "58"
	)
	String method2208() {
		ArrayList var1 = new ArrayList(this.field3795.entrySet());
		Collections.sort(var1, new class435(this));
		StringBuilder var2 = new StringBuilder();
		Iterator var3 = var1.iterator();

		while (var3.hasNext()) {
			Entry var4 = (Entry)var3.next();
			if (var2.length() > 0) {
				var2.append(",");
			}

			var2.append(((class475)var4.getKey()).method2373());
			float var5 = (Float)var4.getValue();
			if (var5 < 1.0F) {
				String var6 = this.field3794.format((double)var5);
				var2.append(";q=").append(var6);
			}
		}

		return var2.toString();
	}
}