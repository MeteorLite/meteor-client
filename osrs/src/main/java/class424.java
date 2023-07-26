import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ql")
public final class class424 {
	@ObfuscatedName("ak")
	static String field3759;
	@ObfuscatedName("ci")
	static int field3758;
	@ObfuscatedName("aw")
	final Comparator field3761;
	@ObfuscatedName("ay")
	final Map field3762;
	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "Lpd;"
	)
	final class393 field3765;
	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "Lpd;"
	)
	final class393 field3764;
	@ObfuscatedName("as")
	final long field3763;
	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		descriptor = "Lqu;"
	)
	final class422 field3766;
	@ObfuscatedName("ag")
	final int field3760;

	@ObfuscatedSignature(
		descriptor = "(JILqu;)V"
	)
	class424(long var1, int var3, class422 var4) {
		this.field3761 = new class423(this);
		this.field3763 = var1;
		this.field3760 = var3;
		this.field3766 = var4;
		if (this.field3760 == -1) {
			this.field3762 = new HashMap(64);
			this.field3765 = new class393(64, this.field3761);
			this.field3764 = null;
		} else {
			if (this.field3766 == null) {
				throw new IllegalArgumentException("");
			}

			this.field3762 = new HashMap(this.field3760);
			this.field3765 = new class393(this.field3760, this.field3761);
			this.field3764 = new class393(this.field3760);
		}

	}

	@ObfuscatedSignature(
		descriptor = "(ILqu;)V"
	)
	public class424(int var1, class422 var2) {
		this(-1L, var1, var2);
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "-61352900"
	)
	boolean method2145() {
		return this.field3760 != -1;
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/Object;I)Ljava/lang/Object;",
		garbageValue = "2120370610"
	)
	public Object method2146(Object var1) {
		synchronized(this) {
			if (-1L != this.field3763) {
				this.method2149();
			}

			class425 var3 = (class425)this.field3762.get(var1);
			if (var3 == null) {
				return null;
			} else {
				this.method2148(var3, false);
				return var3.field3767;
			}
		}
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/Object;Ljava/lang/Object;I)Ljava/lang/Object;",
		garbageValue = "301709804"
	)
	public Object method2147(Object var1, Object var2) {
		synchronized(this) {
			if (-1L != this.field3763) {
				this.method2149();
			}

			class425 var4 = (class425)this.field3762.get(var1);
			if (var4 != null) {
				Object var8 = var4.field3767;
				var4.field3767 = var2;
				this.method2148(var4, false);
				return var8;
			} else {
				class425 var5;
				if (this.method2145() && this.field3762.size() == this.field3760) {
					var5 = (class425)this.field3764.remove();
					this.field3762.remove(var5.field3768);
					this.field3765.remove(var5);
				}

				var5 = new class425(var2, var1);
				this.field3762.put(var1, var5);
				this.method2148(var5, true);
				return null;
			}
		}
	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "(Lqr;ZI)V",
		garbageValue = "-113992548"
	)
	void method2148(class425 var1, boolean var2) {
		if (!var2) {
			this.field3765.remove(var1);
			if (this.method2145()) {
			}
		}

		var1.field3770 = System.currentTimeMillis();
		if (this.method2145()) {
			switch(this.field3766.field3757) {
			case 0:
				++var1.field3769;
				break;
			case 1:
				var1.field3769 = var1.field3770;
			}

			this.field3764.add(var1);
		}

		this.field3765.add(var1);
	}

	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "54"
	)
	void method2149() {
		long var1 = System.currentTimeMillis() - this.field3763;

		while (!this.field3765.isEmpty()) {
			class425 var3 = (class425)this.field3765.peek();
			if (var3.field3770 >= var1) {
				return;
			}

			this.field3762.remove(var3.field3768);
			this.field3765.remove(var3);
			if (this.method2145()) {
				this.field3764.remove(var3);
			}
		}

	}

	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-2134542094"
	)
	public void method2150() {
		synchronized(this) {
			this.field3762.clear();
			this.field3765.clear();
			if (this.method2145()) {
				this.field3764.clear();
			}

		}
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(IB)Ltu;",
		garbageValue = "78"
	)
	@Export("getDbRowType")
	public static DbRowType getDbRowType(int var0) {
		DbRowType var1 = (DbRowType)DbRowType.DBRowType_cache.get((long)var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = DbRowType.field4105.takeFile(38, var0);
			var1 = new DbRowType();
			if (var2 != null) {
				var1.method2487(new Buffer(var2));
			}

			var1.method2490();
			DbRowType.DBRowType_cache.put(var1, (long)var0);
			return var1;
		}
	}
}
