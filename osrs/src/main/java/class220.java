import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("id")
public class class220 implements Comparator {
	class220() {
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(Lir;Lir;B)I",
		garbageValue = "71"
	)
	int method1125(class215 var1, class215 var2) {
		return var1.method1105() - var2.method1105();
	}

	public int compare(Object var1, Object var2) {
		return this.method1125((class215)var1, (class215)var2);
	}

	public boolean equals(Object var1) {
		return super.equals(var1);
	}

	@ObfuscatedName("aq")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "1166390548"
	)
	static final void method1126() {
		Tile.method1160("You can't add yourself to your own friend list");
	}
}
