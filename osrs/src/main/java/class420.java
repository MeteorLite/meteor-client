import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import javax.net.ssl.HttpsURLConnection;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("qb")
public class class420 {
	@ObfuscatedName("am")
	final Map field3752;
	@ObfuscatedName("as")
	final Map field3753;
	@ObfuscatedName("aj")
	final DecimalFormat field3751;

	public class420() {
		this.field3752 = new HashMap();
		this.field3753 = new HashMap();
		this.field3751 = new DecimalFormat();
		this.field3751.setMaximumFractionDigits(2);
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(Ljavax/net/ssl/HttpsURLConnection;B)V",
		garbageValue = "-29"
	)
	public void method2125(HttpsURLConnection var1) {
		Iterator var2 = this.field3752.entrySet().iterator();

		while (var2.hasNext()) {
			Entry var3 = (Entry)var2.next();
			var1.setRequestProperty((String)var3.getKey(), (String)var3.getValue());
		}

	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(I)Ljava/util/Map;",
		garbageValue = "1295921167"
	)
	public Map method2126() {
		return this.field3752;
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;Ljava/lang/String;I)V",
		garbageValue = "1082085990"
	)
	public void method2127(String var1, String var2) {
		if (var1 != null && !var1.isEmpty()) {
			this.field3752.put(var1, var2 != null ? var2 : "");
		}

	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;B)V",
		garbageValue = "70"
	)
	public void method2128(String var1) {
		if (var1 != null && !var1.isEmpty()) {
			this.field3752.remove(var1);
		}

	}

	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "(Lqc;Ljava/lang/String;I)V",
		garbageValue = "521425039"
	)
	void method2129(class419 var1, String var2) {
		String var3 = String.format("%s %s", var1.method2122(), var2);
		this.method2127("Authorization", var3);
	}

	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;I)V",
		garbageValue = "-2096354513"
	)
	public void method2130(String var1) {
		this.method2129(class419.field3748, var1);
	}

	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;I)V",
		garbageValue = "-892969750"
	)
	public void method2131(String var1) {
		this.method2129(class419.field3749, var1);
	}

	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "(Lrs;I)V",
		garbageValue = "-1926129301"
	)
	public void method2132(class461 var1) {
		this.field3752.put("Content-Type", var1.method2309());
	}

	@ObfuscatedName("av")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-1661875858"
	)
	public void method2133() {
		this.field3752.remove("Content-Type");
	}

	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		descriptor = "(Lrs;B)V",
		garbageValue = "11"
	)
	public void method2134(class461 var1) {
		this.method2135(var1, 1.0F);
	}

	@ObfuscatedName("aq")
	@ObfuscatedSignature(
		descriptor = "(Lrs;FI)V",
		garbageValue = "-1632504604"
	)
	void method2135(class461 var1, float var2) {
		this.field3753.put(var1, Math.max(0.0F, Math.min(1.0F, var2)));
		this.method2136();
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "-65"
	)
	void method2136() {
		this.field3752.remove("Accept");
		if (!this.field3753.isEmpty()) {
			this.field3752.put("Accept", this.method2137());
		}

	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(I)Ljava/lang/String;",
		garbageValue = "-2113017491"
	)
	String method2137() {
		ArrayList var1 = new ArrayList(this.field3753.entrySet());
		Collections.sort(var1, new class421(this));
		StringBuilder var2 = new StringBuilder();
		Iterator var3 = var1.iterator();

		while (var3.hasNext()) {
			Entry var4 = (Entry)var3.next();
			if (var2.length() > 0) {
				var2.append(",");
			}

			var2.append(((class461)var4.getKey()).method2309());
			float var5 = (Float)var4.getValue();
			if (var5 < 1.0F) {
				String var6 = this.field3751.format((double)var5);
				var2.append(";q=").append(var6);
			}
		}

		return var2.toString();
	}

	@ObfuscatedName("mx")
	@ObfuscatedSignature(
		descriptor = "([Lmt;II)V",
		garbageValue = "658485102"
	)
	@Export("runComponentCloseListeners")
	static final void runComponentCloseListeners(Widget[] var0, int var1) {
		for (int var2 = 0; var2 < var0.length; ++var2) {
			Widget var3 = var0[var2];
			if (var3 != null) {
				if (var3.type == 0) {
					if (var3.children != null) {
						runComponentCloseListeners(var3.children, var1);
					}

					InterfaceParent var4 = (InterfaceParent)Client.interfaceParents.get((long)var3.id);
					if (var4 != null) {
						ChatChannel.runIntfCloseListeners(var4.group, var1);
					}
				}

				ScriptEvent var5;
				if (var1 == 0 && var3.onDialogAbort != null) {
					var5 = new ScriptEvent();
					var5.widget = var3;
					var5.args = var3.onDialogAbort;
					GrandExchangeOfferOwnWorldComparator.runScriptEvent(var5);
				}

				if (var1 == 1 && var3.onSubChange != null) {
					if (var3.childIndex >= 0) {
						Widget var6 = VarbitComposition.getWidget(var3.id);
						if (var6 == null || var6.children == null || var3.childIndex >= var6.children.length || var3 != var6.children[var3.childIndex]) {
							continue;
						}
					}

					var5 = new ScriptEvent();
					var5.widget = var3;
					var5.args = var3.onSubChange;
					GrandExchangeOfferOwnWorldComparator.runScriptEvent(var5);
				}
			}
		}

	}
}
