import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.io.EOFException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

@ObfuscatedName("em")
@Implements("Varcs")
public class Varcs {
	@ObfuscatedName("jw")
	@Export("xteaKeys")
	static int[][] xteaKeys;
	@ObfuscatedName("lf")
	@Export("cameraPitch")
	static int cameraPitch;
	@ObfuscatedName("ar")
	@Export("intsPersistence")
	boolean[] intsPersistence;
	@ObfuscatedName("ao")
	@Export("map")
	Map map;
	/** @deprecated */
	@Deprecated
	@ObfuscatedName("ab")
	@Export("strings")
	String[] strings;
	@ObfuscatedName("au")
	@Export("unwrittenChanges")
	boolean unwrittenChanges;
	@ObfuscatedName("aa")
	long field1152;

	Varcs() {
		this.unwrittenChanges = false;
		int var1 = class344.archive2.getGroupFileCount(19);
		this.map = new HashMap();
		this.intsPersistence = new boolean[var1];

		int var2;
		for (var2 = 0; var2 < var1; ++var2) {
			VarcInt var3 = class140.method750(var2);
			this.intsPersistence[var2] = var3.persist;
		}

		var2 = 0;
		if (class344.archive2.method1923(15)) {
			var2 = class344.archive2.getGroupFileCount(15);
		}

		this.strings = new String[var2];
		this.read();
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(III)V",
		garbageValue = "-1897497270"
	)
	@Export("setInt")
	void setInt(int var1, int var2) {
		this.map.put(var1, var2);
		if (this.intsPersistence[var1]) {
			this.unwrittenChanges = true;
		}

	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(II)I",
		garbageValue = "-1991515717"
	)
	@Export("getInt")
	int getInt(int var1) {
		Object var2 = this.map.get(var1);
		return var2 instanceof Integer ? (Integer)var2 : -1;
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(ILjava/lang/String;B)V",
		garbageValue = "-59"
	)
	@Export("setString")
	void setString(int var1, String var2) {
		this.map.put(var1, var2);
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(IB)Ljava/lang/String;",
		garbageValue = "32"
	)
	@Export("getString")
	String getString(int var1) {
		Object var2 = this.map.get(var1);
		return var2 instanceof String ? (String)var2 : "";
	}

	/** @deprecated */
	@Deprecated
	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "(ILjava/lang/String;I)V",
		garbageValue = "-1603974039"
	)
	@Export("setStringOld")
	void setStringOld(int var1, String var2) {
		this.strings[var1] = var2;
	}

	/** @deprecated */
	@Deprecated
	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(IB)Ljava/lang/String;",
		garbageValue = "0"
	)
	@Export("getStringOld")
	String getStringOld(int var1) {
		return this.strings[var1];
	}

	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "19136992"
	)
	@Export("clearTransient")
	void clearTransient() {
		int var1;
		for (var1 = 0; var1 < this.intsPersistence.length; ++var1) {
			if (!this.intsPersistence[var1]) {
				this.map.remove(var1);
			}
		}

		for (var1 = 0; var1 < this.strings.length; ++var1) {
			this.strings[var1] = null;
		}

	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(ZI)Lto;",
		garbageValue = "-1859436086"
	)
	@Export("getPreferencesFile")
	AccessFile getPreferencesFile(boolean var1) {
		return class131.getPreferencesFile("2", Messages.field1156.name, var1);
	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-2104867526"
	)
	@Export("write")
	void write() {
		AccessFile var1 = this.getPreferencesFile(true);

		try {
			int var2 = 3;
			int var3 = 0;
			Iterator var4 = this.map.entrySet().iterator();

			while (var4.hasNext()) {
				Entry var5 = (Entry)var4.next();
				int var6 = (Integer)var5.getKey();
				if (this.intsPersistence[var6]) {
					Object var7 = var5.getValue();
					var2 += 3;
					if (var7 instanceof Integer) {
						var2 += 4;
					} else if (var7 instanceof String) {
						var2 += ClanChannel.stringCp1252NullTerminatedByteSize((String)var7);
					}

					++var3;
				}
			}

			Buffer var26 = new Buffer(var2);
			var26.writeByte(2);
			var26.writeShort(var3);
			Iterator var27 = this.map.entrySet().iterator();

			while (var27.hasNext()) {
				Entry var15 = (Entry)var27.next();
				int var16 = (Integer)var15.getKey();
				if (this.intsPersistence[var16]) {
					var26.writeShort(var16);
					Object var8 = var15.getValue();
					class514 var9 = class514.method2504(var8.getClass());
					var26.writeByte(var9.field4128);
					Class var11 = var8.getClass();
					class514 var12 = class514.method2504(var11);
					if (var12 == null) {
						throw new IllegalArgumentException();
					}

					class510 var10 = var12.field4131;
					var10.vmethod8274(var8, var26);
				}
			}

			var1.write(var26.array, 0, var26.offset);
		} catch (Exception var24) {
		} finally {
			try {
				var1.close();
			} catch (Exception var23) {
			}

		}

		this.unwrittenChanges = false;
		this.field1152 = SpotAnimationDefinition.method962();
	}

	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "121"
	)
	@Export("read")
	void read() {
		AccessFile var1 = this.getPreferencesFile(false);

		try {
			byte[] var2 = new byte[(int)var1.length()];

			int var4;
			for (int var3 = 0; var3 < var2.length; var3 += var4) {
				var4 = var1.read(var2, var3, var2.length - var3);
				if (var4 == -1) {
					throw new EOFException();
				}
			}

			Buffer var14 = new Buffer(var2);
			if (var14.array.length - var14.offset < 1) {
				return;
			}

			int var15 = var14.readUnsignedByte();
			if (var15 < 0 || var15 > 2) {
				return;
			}

			int var7;
			int var8;
			int var9;
			int var16;
			if (var15 >= 2) {
				var16 = var14.readUnsignedShort();

				for (var7 = 0; var7 < var16; ++var7) {
					var8 = var14.readUnsignedShort();
					var9 = var14.readUnsignedByte();
					class514 var10 = (class514)class12.findEnumerated(class514.method2503(), var9);
					Object var11 = var10.method2506(var14);
					if (var8 >= 0 && var8 < this.intsPersistence.length && this.intsPersistence[var8]) {
						this.map.put(var8, var11);
					}
				}
			} else {
				var16 = var14.readUnsignedShort();

				for (var7 = 0; var7 < var16; ++var7) {
					var8 = var14.readUnsignedShort();
					var9 = var14.readInt();
					if (var8 >= 0 && var8 < this.intsPersistence.length && this.intsPersistence[var8]) {
						this.map.put(var8, var9);
					}
				}

				var7 = var14.readUnsignedShort();

				for (var8 = 0; var8 < var7; ++var8) {
					var14.readUnsignedShort();
					var14.readStringCp1252NullTerminated();
				}
			}
		} catch (Exception var25) {
		} finally {
			try {
				var1.close();
			} catch (Exception var24) {
			}

		}

		this.unwrittenChanges = false;
	}

	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "1055402619"
	)
	@Export("tryWrite")
	void tryWrite() {
		if (this.unwrittenChanges && this.field1152 < SpotAnimationDefinition.method962() - 60000L) {
			this.write();
		}

	}

	@ObfuscatedName("av")
	@ObfuscatedSignature(
		descriptor = "(B)Z",
		garbageValue = "3"
	)
	@Export("hasUnwrittenChanges")
	boolean hasUnwrittenChanges() {
		return this.unwrittenChanges;
	}

	@ObfuscatedName("lg")
	@ObfuscatedSignature(
		descriptor = "(IIIIII)V",
		garbageValue = "2070284698"
	)
	@Export("drawScrollBar")
	static final void drawScrollBar(int var0, int var1, int var2, int var3, int var4) {
		class31.scrollBarSprites[0].drawAt(var0, var1);
		class31.scrollBarSprites[1].drawAt(var0, var3 + var1 - 16);
		Rasterizer2D.Rasterizer2D_fillRectangle(var0, var1 + 16, 16, var3 - 32, Client.field461);
		int var5 = var3 * (var3 - 32) / var4;
		if (var5 < 8) {
			var5 = 8;
		}

		int var6 = (var3 - 32 - var5) * var2 / (var4 - var3);
		Rasterizer2D.Rasterizer2D_fillRectangle(var0, var6 + var1 + 16, 16, var5, Client.field458);
		Rasterizer2D.Rasterizer2D_drawVerticalLine(var0, var6 + var1 + 16, var5, Client.field457);
		Rasterizer2D.Rasterizer2D_drawVerticalLine(var0 + 1, var6 + var1 + 16, var5, Client.field457);
		Rasterizer2D.Rasterizer2D_drawHorizontalLine(var0, var6 + var1 + 16, 16, Client.field457);
		Rasterizer2D.Rasterizer2D_drawHorizontalLine(var0, var6 + var1 + 17, 16, Client.field457);
		Rasterizer2D.Rasterizer2D_drawVerticalLine(var0 + 15, var6 + var1 + 16, var5, Client.field459);
		Rasterizer2D.Rasterizer2D_drawVerticalLine(var0 + 14, var6 + var1 + 17, var5 - 1, Client.field459);
		Rasterizer2D.Rasterizer2D_drawHorizontalLine(var0, var5 + var6 + var1 + 15, 16, Client.field459);
		Rasterizer2D.Rasterizer2D_drawHorizontalLine(var0 + 1, var6 + var5 + var1 + 14, 15, Client.field459);
	}
}