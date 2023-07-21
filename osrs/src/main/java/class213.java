import java.util.Arrays;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ih")
public class class213 implements class29 {
	@ObfuscatedName("aw")
	char[] field1860;
	@ObfuscatedName("ay")
	int[] field1866;
	@ObfuscatedName("ar")
	public int[] field1870;
	@ObfuscatedName("am")
	@Export("pressedKeysCount")
	public int pressedKeysCount;
	@ObfuscatedName("as")
	int[] field1865;
	@ObfuscatedName("aj")
	int field1862;
	@ObfuscatedName("ag")
	int field1861;
	@ObfuscatedName("az")
	int field1864;
	@ObfuscatedName("av")
	int field1863;
	@ObfuscatedName("ap")
	boolean[] field1857;
	@ObfuscatedName("aq")
	boolean[] field1858;
	@ObfuscatedName("at")
	boolean[] field1859;
	@ObfuscatedName("ah")
	public char field1867;
	@ObfuscatedName("ax")
	public int field1869;

	public class213() {
		this.field1860 = new char[128];
		this.field1866 = new int[128];
		this.field1870 = new int[128];
		this.pressedKeysCount = 0;
		this.field1865 = new int[128];
		this.field1862 = 0;
		this.field1861 = 0;
		this.field1864 = 0;
		this.field1863 = 0;
		this.field1857 = new boolean[112];
		this.field1858 = new boolean[112];
		this.field1859 = new boolean[112];
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(II)Z",
		garbageValue = "-1364202239"
	)
	@Export("vmethod3949")
	public boolean vmethod3949(int var1) {
		this.method1082(var1);
		this.field1857[var1] = true;
		this.field1858[var1] = true;
		this.field1859[var1] = false;
		this.field1870[++this.pressedKeysCount - 1] = var1;
		return true;
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(II)Z",
		garbageValue = "1960624058"
	)
	@Export("vmethod3989")
	public boolean vmethod3989(int var1) {
		this.field1857[var1] = false;
		this.field1858[var1] = false;
		this.field1859[var1] = true;
		this.field1865[++this.field1862 - 1] = var1;
		return true;
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(CI)Z",
		garbageValue = "932068520"
	)
	@Export("vmethod3951")
	public boolean vmethod3951(char var1) {
		int var2 = this.field1864 + 1 & 127;
		if (var2 != this.field1861) {
			this.field1866[this.field1864] = -1;
			this.field1860[this.field1864] = var1;
			this.field1864 = var2;
		}

		return false;
	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "(ZB)Z",
		garbageValue = "-93"
	)
	@Export("vmethod3953")
	public boolean vmethod3953(boolean var1) {
		return false;
	}

	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "1128886308"
	)
	void method1082(int var1) {
		int var2 = this.field1864 + 1 & 127;
		if (var2 != this.field1861) {
			this.field1866[this.field1864] = var1;
			this.field1860[this.field1864] = 0;
			this.field1864 = var2;
		}

	}

	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "196397421"
	)
	public void method1084() {
		this.field1861 = this.field1863;
		this.field1863 = this.field1864;
		this.pressedKeysCount = 0;
		this.field1862 = 0;
		Arrays.fill(this.field1858, false);
		Arrays.fill(this.field1859, false);
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "-560084710"
	)
	public final boolean method1085() {
		if (this.field1863 == this.field1861) {
			return false;
		} else {
			this.field1869 = this.field1866[this.field1861];
			this.field1867 = this.field1860[this.field1861];
			this.field1861 = this.field1861 + 1 & 127;
			return true;
		}
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(II)Z",
		garbageValue = "-1196932561"
	)
	public boolean method1086(int var1) {
		return var1 >= 0 && var1 < 112 ? this.field1858[var1] : false;
	}

	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "(II)Z",
		garbageValue = "1392271778"
	)
	@Export("getKeyPressed")
	public boolean getKeyPressed(int var1) {
		return var1 >= 0 && var1 < 112 ? this.field1857[var1] : false;
	}

	@ObfuscatedName("ad")
	@ObfuscatedSignature(
		descriptor = "(II)Z",
		garbageValue = "1727357268"
	)
	public boolean method1088(int var1) {
		return var1 >= 0 && var1 < 112 ? this.field1859[var1] : false;
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(I)[I",
		garbageValue = "-1635816541"
	)
	public int[] method1089() {
		int[] var1 = new int[this.pressedKeysCount];

		for (int var2 = 0; var2 < this.pressedKeysCount; ++var2) {
			var1[var2] = this.field1870[var2];
		}

		return var1;
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(B)[I",
		garbageValue = "0"
	)
	public int[] method1090() {
		int[] var1 = new int[this.field1862];

		for (int var2 = 0; var2 < this.field1862; ++var2) {
			var1[var2] = this.field1865[var2];
		}

		return var1;
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;S)V",
		garbageValue = "4430"
	)
	@Export("addChatMessage")
	static void addChatMessage(int var0, String var1, String var2, String var3) {
		ChatChannel var4 = (ChatChannel)Messages.Messages_channels.get(var0);
		if (var4 == null) {
			var4 = new ChatChannel();
			Messages.Messages_channels.put(var0, var4);
		}

		Message var5 = var4.addMessage(var0, var1, var2, var3);
		Messages.Messages_hashTable.put(var5, (long)var5.count);
		Messages.Messages_queue.add(var5);
		Client.chatCycle = Client.cycleCntr;
	}
}
