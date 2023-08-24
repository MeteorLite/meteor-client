import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.Arrays;

@ObfuscatedName("io")
public class class214 {
	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "Lio;"
	)
	static final class214 field1903;
	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "Lio;"
	)
	static final class214 field1900;
	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "Lio;"
	)
	public static final class214 field1898;
	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "Lio;"
	)
	static final class214 field1902;
	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "Lio;"
	)
	static final class214 field1899;
	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		descriptor = "Lio;"
	)
	static final class214 field1901;
	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "Lio;"
	)
	static final class214 field1904;
	@ObfuscatedName("ad")
	@ObfuscatedSignature(
		descriptor = "[Lio;"
	)
	static final class214[] field1905;
	@ObfuscatedName("ap")
	final int field1906;
	@ObfuscatedName("aa")
	public final int field1907;
	@ObfuscatedName("af")
	public final int field1908;

	static {
		field1903 = new class214(6, 8, 8);
		field1900 = new class214(3, 16, 16);
		field1898 = new class214(0, 32, 32);
		field1902 = new class214(2, 48, 48);
		field1899 = new class214(4, 64, 64);
		field1901 = new class214(5, 96, 96);
		field1904 = new class214(1, 128, 128);
		field1905 = class271.method1541();
		Arrays.sort(field1905, new class219());
	}

	class214(int var1, int var2, int var3) {
		this.field1906 = var1;
		this.field1907 = var2;
		this.field1908 = var3;
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(S)I",
		garbageValue = "-4502"
	)
	int method1123() {
		return this.field1908 * this.field1907;
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-1568434479"
	)
	public static void method1124() {
		synchronized(ArchiveDiskActionHandler.field3513) {
			if (ArchiveDiskActionHandler.field3512 != 0) {
				ArchiveDiskActionHandler.field3512 = 1;
				ArchiveDiskActionHandler.field3511 = true;

				try {
					ArchiveDiskActionHandler.field3513.wait();
				} catch (InterruptedException var3) {
				}
			}

		}
	}
}