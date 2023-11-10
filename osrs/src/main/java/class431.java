import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import javax.net.ssl.HttpsURLConnection;
import java.text.DecimalFormat;
import java.util.*;
import java.util.Map.Entry;

@ObfuscatedName("qf")
public class class431 {
	@ObfuscatedName("ao")
	final Map field3799;
	@ObfuscatedName("ab")
	final Map field3798;
	@ObfuscatedName("au")
	final DecimalFormat field3797;

	public class431() {
		this.field3799 = new HashMap();
		this.field3798 = new HashMap();
		this.field3797 = new DecimalFormat();
		this.field3797.setMaximumFractionDigits(2);
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(Ljavax/net/ssl/HttpsURLConnection;I)V",
		garbageValue = "514712825"
	)
	public void method2180(HttpsURLConnection var1) {
		Iterator var2 = this.field3799.entrySet().iterator();

		while (var2.hasNext()) {
			Entry var3 = (Entry)var2.next();
			var1.setRequestProperty((String)var3.getKey(), (String)var3.getValue());
		}

	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(I)Ljava/util/Map;",
		garbageValue = "289317846"
	)
	public Map method2181() {
		return this.field3799;
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;Ljava/lang/String;I)V",
		garbageValue = "-1068565867"
	)
	public void method2182(String var1, String var2) {
		if (var1 != null && !var1.isEmpty()) {
			this.field3799.put(var1, var2 != null ? var2 : "");
		}

	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;B)V",
		garbageValue = "90"
	)
	public void method2183(String var1) {
		if (var1 != null && !var1.isEmpty()) {
			this.field3799.remove(var1);
		}

	}

	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "(Lqr;Ljava/lang/String;I)V",
		garbageValue = "-1582767971"
	)
	void method2184(class430 var1, String var2) {
		String var3 = String.format("%s %s", var1.method2179(), var2);
		this.method2182("Authorization", var3);
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;S)V",
		garbageValue = "1431"
	)
	public void method2185(String var1) {
		this.method2184(class430.field3795, var1);
	}

	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;I)V",
		garbageValue = "1155653800"
	)
	public void method2186(String var1) {
		this.method2184(class430.field3794, var1);
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(Lsi;B)V",
		garbageValue = "-85"
	)
	public void method2187(class472 var1) {
		this.field3799.put("Content-Type", var1.method2348());
	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "37"
	)
	public void method2188() {
		this.field3799.remove("Content-Type");
	}

	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "(Lsi;B)V",
		garbageValue = "4"
	)
	public void method2189(class472 var1) {
		this.method2190(var1, 1.0F);
	}

	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		descriptor = "(Lsi;FI)V",
		garbageValue = "-974878647"
	)
	void method2190(class472 var1, float var2) {
		this.field3798.put(var1, Math.max(0.0F, Math.min(1.0F, var2)));
		this.method2191();
	}

	@ObfuscatedName("av")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-1694240959"
	)
	void method2191() {
		this.field3799.remove("Accept");
		if (!this.field3798.isEmpty()) {
			this.field3799.put("Accept", this.method2192());
		}

	}

	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "(I)Ljava/lang/String;",
		garbageValue = "1880009483"
	)
	String method2192() {
		ArrayList var1 = new ArrayList(this.field3798.entrySet());
		Collections.sort(var1, new class432(this));
		StringBuilder var2 = new StringBuilder();
		Iterator var3 = var1.iterator();

		while (var3.hasNext()) {
			Entry var4 = (Entry)var3.next();
			if (var2.length() > 0) {
				var2.append(",");
			}

			var2.append(((class472)var4.getKey()).method2348());
			float var5 = (Float)var4.getValue();
			if (var5 < 1.0F) {
				String var6 = this.field3797.format((double)var5);
				var2.append(";q=").append(var6);
			}
		}

		return var2.toString();
	}
}