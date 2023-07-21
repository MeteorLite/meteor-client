import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("tt")
class class497 implements Iterator {
	@ObfuscatedName("el")
	@ObfuscatedSignature(
		descriptor = "Lde;"
	)
	@Export("mouseRecorder")
	static MouseRecorder mouseRecorder;
	@ObfuscatedName("aw")
	int field4083;
	// $FF: synthetic field
	@ObfuscatedSignature(
		descriptor = "Ltp;"
	)
	@Export("this$0")
	@ObfuscatedName("this$0")
	final class498 this$0;

	@ObfuscatedSignature(
		descriptor = "(Ltp;)V"
	)
	class497(class498 var1) {
		this.this$0 = var1;
	}

	@Export("hasNext")
	@ObfuscatedName("hasNext")
	public boolean hasNext() {
		return this.field4083 < this.this$0.method2298();
	}

	@Export("next")
	@ObfuscatedName("next")
	public Object next() {
		int var1 = ++this.field4083 - 1;
		class457 var2 = (class457)this.this$0.field4085.get((long)var1);
		return var2 != null ? var2 : this.this$0.method2457(var1);
	}

	@Export("remove")
	@ObfuscatedName("remove")
	public void remove() {
		throw new UnsupportedOperationException();
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/CharSequence;I)Ljava/lang/String;",
		garbageValue = "2111297623"
	)
	public static String method2455(CharSequence var0) {
		int var1 = var0.length();
		StringBuilder var2 = new StringBuilder(var1);

		for (int var3 = 0; var3 < var1; ++var3) {
			char var4 = var0.charAt(var3);
			if ((var4 < 'a' || var4 > 'z') && (var4 < 'A' || var4 > 'Z') && (var4 < '0' || var4 > '9') && var4 != '.' && var4 != '-' && var4 != '*' && var4 != '_') {
				if (var4 == ' ') {
					var2.append('+');
				} else {
					byte var5 = class313.charToByteCp1252(var4);
					var2.append('%');
					int var6 = var5 >> 4 & 15;
					if (var6 >= 10) {
						var2.append((char)(var6 + 55));
					} else {
						var2.append((char)(var6 + 48));
					}

					var6 = var5 & 15;
					if (var6 >= 10) {
						var2.append((char)(var6 + 55));
					} else {
						var2.append((char)(var6 + 48));
					}
				}
			} else {
				var2.append(var4);
			}
		}

		return var2.toString();
	}
}
