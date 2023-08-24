import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import javax.net.ssl.HttpsURLConnection;
import java.text.DecimalFormat;
import java.util.*;
import java.util.Map.Entry;

@ObfuscatedName("qf")
public class class419 {
	@ObfuscatedName("nx")
	@Export("menuY")
	static int menuY;
	@ObfuscatedName("at")
	final Map field3764;
	@ObfuscatedName("ac")
	final Map field3763;
	@ObfuscatedName("ai")
	final DecimalFormat field3762;

	public class419() {
		this.field3764 = new HashMap();
		this.field3763 = new HashMap();
		this.field3762 = new DecimalFormat();
		this.field3762.setMaximumFractionDigits(2);
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(Ljavax/net/ssl/HttpsURLConnection;B)V",
		garbageValue = "14"
	)
	public void method2164(HttpsURLConnection var1) {
		Iterator var2 = this.field3764.entrySet().iterator();

		while (var2.hasNext()) {
			Entry var3 = (Entry)var2.next();
			var1.setRequestProperty((String)var3.getKey(), (String)var3.getValue());
		}

	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(I)Ljava/util/Map;",
		garbageValue = "1187497182"
	)
	public Map method2165() {
		return this.field3764;
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;Ljava/lang/String;I)V",
		garbageValue = "2091196892"
	)
	public void method2166(String var1, String var2) {
		if (var1 != null && !var1.isEmpty()) {
			this.field3764.put(var1, var2 != null ? var2 : "");
		}

	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;I)V",
		garbageValue = "-321106609"
	)
	public void method2167(String var1) {
		if (var1 != null && !var1.isEmpty()) {
			this.field3764.remove(var1);
		}

	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(Lqn;Ljava/lang/String;B)V",
		garbageValue = "19"
	)
	void method2168(class418 var1, String var2) {
		String var3 = String.format("%s %s", var1.method2162(), var2);
		this.method2166("Authorization", var3);
	}

	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;I)V",
		garbageValue = "-1710758973"
	)
	public void method2169(String var1) {
		this.method2168(class418.field3759, var1);
	}

	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;I)V",
		garbageValue = "-911338485"
	)
	public void method2170(String var1) {
		this.method2168(class418.field3758, var1);
	}

	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		descriptor = "(Lre;I)V",
		garbageValue = "858846638"
	)
	public void method2171(class460 var1) {
		this.field3764.put("Content-Type", var1.method2331());
	}

	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "10"
	)
	public void method2172() {
		this.field3764.remove("Content-Type");
	}

	@ObfuscatedName("af")
	@ObfuscatedSignature(
		descriptor = "(Lre;B)V",
		garbageValue = "103"
	)
	public void method2173(class460 var1) {
		this.method2174(var1, 1.0F);
	}

	@ObfuscatedName("ad")
	@ObfuscatedSignature(
		descriptor = "(Lre;FI)V",
		garbageValue = "-2080888931"
	)
	void method2174(class460 var1, float var2) {
		this.field3763.put(var1, Math.max(0.0F, Math.min(1.0F, var2)));
		this.method2175();
	}

	@ObfuscatedName("aq")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-689194447"
	)
	void method2175() {
		this.field3764.remove("Accept");
		if (!this.field3763.isEmpty()) {
			this.field3764.put("Accept", this.method2176());
		}

	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "(B)Ljava/lang/String;",
		garbageValue = "92"
	)
	String method2176() {
		ArrayList var1 = new ArrayList(this.field3763.entrySet());
		Collections.sort(var1, new class420(this));
		StringBuilder var2 = new StringBuilder();
		Iterator var3 = var1.iterator();

		while (var3.hasNext()) {
			Entry var4 = (Entry)var3.next();
			if (var2.length() > 0) {
				var2.append(",");
			}

			var2.append(((class460)var4.getKey()).method2331());
			float var5 = (Float)var4.getValue();
			if (var5 < 1.0F) {
				String var6 = this.field3762.format((double)var5);
				var2.append(";q=").append(var6);
			}
		}

		return var2.toString();
	}
}