import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.HashMap;
import java.util.Map;

@ObfuscatedName("nt")
public class WidgetDefinition {
	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "Lom;"
	)
	@Export("widgetArchive")
	AbstractArchive widgetArchive;
	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "Lom;"
	)
	AbstractArchive field2917;
	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "Lom;"
	)
	AbstractArchive field2916;
	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "Lom;"
	)
	AbstractArchive field2919;
	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "Lom;"
	)
	AbstractArchive field2918;
	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "[[Lnm;"
	)
	public Widget[][] Widget_interfaceComponents;
	@ObfuscatedName("ab")
	Map field2910;
	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "Llr;"
	)
	@Export("Widget_cachedSprites")
	EvictingDualNodeHashTable Widget_cachedSprites;
	@ObfuscatedName("av")
	@ObfuscatedSignature(
		descriptor = "Llr;"
	)
	@Export("Widget_cachedModels")
	EvictingDualNodeHashTable Widget_cachedModels;
	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		descriptor = "Llr;"
	)
	@Export("Widget_cachedFonts")
	EvictingDualNodeHashTable Widget_cachedFonts;
	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "Llr;"
	)
	@Export("Widget_cachedSpriteMasks")
	EvictingDualNodeHashTable Widget_cachedSpriteMasks;
	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		descriptor = "Lqe;"
	)
	class438 field2920;
	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "Lqe;"
	)
	class438 field2921;

	@ObfuscatedSignature(
		descriptor = "(Lom;Lom;Lom;Lom;Lom;)V"
	)
	public WidgetDefinition(AbstractArchive var1, AbstractArchive var2, AbstractArchive var3, AbstractArchive var4, AbstractArchive var5) {
		this.field2910 = new HashMap();
		this.Widget_cachedSprites = new EvictingDualNodeHashTable(200);
		this.Widget_cachedModels = new EvictingDualNodeHashTable(50);
		this.Widget_cachedFonts = new EvictingDualNodeHashTable(20);
		this.Widget_cachedSpriteMasks = new EvictingDualNodeHashTable(8);
		this.field2920 = new class438(10, class436.field3797);
		this.field2921 = new class438(10, class436.field3797);
		int var6 = 0;
		if (var1 != null) {
			this.widgetArchive = var1;
			this.field2916 = var2;
			this.field2919 = var3;
			this.field2918 = var4;
			this.field2917 = var5;
			var6 = this.widgetArchive.getGroupCount();
		}

		this.Widget_interfaceComponents = new Widget[var6][];
		AbstractUserComparator.field3833 = new boolean[var6];
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(II)Lnm;",
		garbageValue = "-836235004"
	)
	public Widget method1740(int var1) {
		int var2 = var1 >> 16;
		int var3 = var1 & 65535;
		if (this.Widget_interfaceComponents[var2] == null || this.Widget_interfaceComponents[var2][var3] == null) {
			boolean var4 = this.method1742(var2);
			if (!var4) {
				return null;
			}
		}

		return this.Widget_interfaceComponents[var2][var3];
	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "(III)Lnm;",
		garbageValue = "-1175209184"
	)
	@Export("getWidgetChild")
	public Widget getWidgetChild(int var1, int var2) {
		Widget var3 = this.method1740(var1);
		if (var2 == -1) {
			return var3;
		} else {
			return var3 != null && var3.children != null && var2 < var3.children.length ? var3.children[var2] : null;
		}
	}

	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "(IS)Z",
		garbageValue = "-8971"
	)
	public boolean method1742(int var1) {
		if (AbstractUserComparator.field3833[var1]) {
			return true;
		} else if (!this.widgetArchive.tryLoadGroup(var1)) {
			return false;
		} else {
			int var2 = this.widgetArchive.getGroupFileCount(var1);
			if (var2 == 0) {
				AbstractUserComparator.field3833[var1] = true;
				return true;
			} else {
				if (this.Widget_interfaceComponents[var1] == null) {
					this.Widget_interfaceComponents[var1] = new Widget[var2];
				}

				for (int var3 = 0; var3 < var2; ++var3) {
					if (this.Widget_interfaceComponents[var1][var3] == null) {
						byte[] var4 = this.widgetArchive.takeFile(var1, var3);
						if (var4 != null) {
							this.Widget_interfaceComponents[var1][var3] = new Widget();
							this.Widget_interfaceComponents[var1][var3].id = var3 + (var1 << 16);
							if (var4[0] == -1) {
								this.Widget_interfaceComponents[var1][var3].decode(new Buffer(var4));
							} else {
								this.Widget_interfaceComponents[var1][var3].decodeLegacy(new Buffer(var4));
							}

							if (this.field2917 != null) {
								byte[] var5 = this.field2917.takeFile(var1, var3);
								if (var5 != null && var5.length > 0) {
									this.Widget_interfaceComponents[var1][var3].method1847(new Buffer(var5));
									this.field2910.put(this.Widget_interfaceComponents[var1][var3].field2983, var1);
								}
							}
						}
					}
				}

				AbstractUserComparator.field3833[var1] = true;
				return true;
			}
		}
	}

	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "1200843852"
	)
	public void method1743(int var1) {
		if (var1 != -1) {
			if (AbstractUserComparator.field3833[var1]) {
				this.widgetArchive.clearFilesGroup(var1);
				if (this.Widget_interfaceComponents[var1] != null) {
					for (int var2 = 0; var2 < this.Widget_interfaceComponents[var1].length; ++var2) {
						if (this.Widget_interfaceComponents[var1][var2] != null) {
							this.Widget_interfaceComponents[var1][var2] = null;
						}
					}

					this.Widget_interfaceComponents[var1] = null;
					AbstractUserComparator.field3833[var1] = false;
				}
			}
		}
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "-17"
	)
	public void method1744() {
		this.Widget_cachedSprites.clear();
		this.Widget_cachedModels.clear();
		this.Widget_cachedFonts.clear();
		this.Widget_cachedSpriteMasks.clear();
	}

	@ObfuscatedName("lr")
	@ObfuscatedSignature(
		descriptor = "(III)Ljava/lang/String;",
		garbageValue = "-1362915838"
	)
	static final String method1745(int var0, int var1) {
		int var2 = var1 - var0;
		if (var2 < -9) {
			return Client.colorStartTag(16711680);
		} else if (var2 < -6) {
			return Client.colorStartTag(16723968);
		} else if (var2 < -3) {
			return Client.colorStartTag(16740352);
		} else if (var2 < 0) {
			return Client.colorStartTag(16756736);
		} else if (var2 > 9) {
			return Client.colorStartTag(65280);
		} else if (var2 > 6) {
			return Client.colorStartTag(4259584);
		} else if (var2 > 3) {
			return Client.colorStartTag(8453888);
		} else {
			return var2 > 0 ? Client.colorStartTag(12648192) : Client.colorStartTag(16776960);
		}
	}
}