import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

@ObfuscatedName("dy")
@Implements("ClientPreferences")
public class ClientPreferences {
	@ObfuscatedName("cf")
	static int field1059;
	@ObfuscatedName("ao")
	@Export("roofsHidden")
	boolean roofsHidden;
	@ObfuscatedName("ah")
	@Export("hideUsername")
	boolean hideUsername;
	@ObfuscatedName("ar")
	@Export("titleMusicDisabled")
	boolean titleMusicDisabled;
	@ObfuscatedName("ab")
	@Export("displayFps")
	boolean displayFps;
	@ObfuscatedName("am")
	int field1068;
	@ObfuscatedName("av")
	@Export("brightness")
	double brightness;
	@ObfuscatedName("ag")
	@Export("musicVolume")
	int musicVolume;
	@ObfuscatedName("aa")
	@Export("soundEffectsVolume")
	int soundEffectsVolume;
	@ObfuscatedName("ap")
	@Export("areaSoundEffectsVolume")
	int areaSoundEffectsVolume;
	@ObfuscatedName("ay")
	int field1070;
	@ObfuscatedName("as")
	@Export("rememberedUsername")
	String rememberedUsername;
	@ObfuscatedName("aj")
	@Export("windowMode")
	int windowMode;
	@ObfuscatedName("an")
	@Export("parameters")
	final Map parameters;

	ClientPreferences() {
		this.hideUsername = false;
		this.displayFps = false;
		this.brightness = 0.8D;
		this.musicVolume = 127;
		this.soundEffectsVolume = 127;
		this.areaSoundEffectsVolume = 127;
		this.field1070 = -1;
		this.rememberedUsername = null;
		this.windowMode = 1;
		this.parameters = new LinkedHashMap();
		this.method536(true);
	}

	@ObfuscatedSignature(
		descriptor = "(Lul;)V"
	)
	ClientPreferences(Buffer var1) {
		this.hideUsername = false;
		this.displayFps = false;
		this.brightness = 0.8D;
		this.musicVolume = 127;
		this.soundEffectsVolume = 127;
		this.areaSoundEffectsVolume = 127;
		this.field1070 = -1;
		this.rememberedUsername = null;
		this.windowMode = 1;
		this.parameters = new LinkedHashMap();
		if (var1 != null && var1.array != null) {
			int var2 = var1.readUnsignedByte();
			if (var2 >= 0 && var2 <= 10) {
				if (var1.readUnsignedByte() == 1) {
					this.roofsHidden = true;
				}

				if (var2 > 1) {
					this.titleMusicDisabled = var1.readUnsignedByte() == 1;
				}

				if (var2 > 3) {
					this.windowMode = var1.readUnsignedByte();
				}

				if (var2 > 2) {
					int var3 = var1.readUnsignedByte();

					for (int var4 = 0; var4 < var3; ++var4) {
						int var5 = var1.readInt();
						int var6 = var1.readInt();
						this.parameters.put(var5, var6);
					}
				}

				if (var2 > 4) {
					this.rememberedUsername = var1.readStringCp1252NullTerminatedOrNull();
				}

				if (var2 > 5) {
					this.hideUsername = var1.readBoolean();
				}

				if (var2 > 6) {
					this.brightness = (double)var1.readUnsignedByte() / 100.0D;
					this.musicVolume = var1.readUnsignedByte();
					this.soundEffectsVolume = var1.readUnsignedByte();
					this.areaSoundEffectsVolume = var1.readUnsignedByte();
				}

				if (var2 > 7) {
					this.field1070 = var1.readUnsignedByte();
				}

				if (var2 > 8) {
					this.displayFps = var1.readUnsignedByte() == 1;
				}

				if (var2 > 9) {
					this.field1068 = var1.readInt();
				}
			} else {
				this.method536(true);
			}
		} else {
			this.method536(true);
		}

	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(ZB)V",
		garbageValue = "12"
	)
	void method536(boolean var1) {
	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "(I)Lul;",
		garbageValue = "2143107784"
	)
	@Export("toBuffer")
	Buffer toBuffer() {
		Buffer var1 = new Buffer(417, true);
		var1.writeByte(10);
		var1.writeByte(this.roofsHidden ? 1 : 0);
		var1.writeByte(this.titleMusicDisabled ? 1 : 0);
		var1.writeByte(this.windowMode);
		var1.writeByte(this.parameters.size());
		Iterator var2 = this.parameters.entrySet().iterator();

		while (var2.hasNext()) {
			Entry var3 = (Entry)var2.next();
			var1.writeInt((Integer)var3.getKey());
			var1.writeInt((Integer)var3.getValue());
		}

		var1.writeStringCp1252NullTerminated(this.rememberedUsername != null ? this.rememberedUsername : "");
		var1.writeBoolean(this.hideUsername);
		var1.writeByte((int)(100.0D * this.brightness));
		var1.writeByte(this.musicVolume);
		var1.writeByte(this.soundEffectsVolume);
		var1.writeByte(this.areaSoundEffectsVolume);
		var1.writeByte(this.field1070);
		var1.writeByte(this.displayFps ? 1 : 0);
		var1.writeInt(this.field1068);
		return var1;
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(ZS)V",
		garbageValue = "5523"
	)
	@Export("setRoofsHidden")
	void setRoofsHidden(boolean var1) {
		this.roofsHidden = var1;
		class144.savePreferences();
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "-16777216"
	)
	@Export("getRoofsHidden")
	boolean getRoofsHidden() {
		return this.roofsHidden;
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(ZB)V",
		garbageValue = "-118"
	)
	@Export("setIsUsernameHidden")
	void setIsUsernameHidden(boolean var1) {
		this.hideUsername = var1;
		class144.savePreferences();
	}

	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "2079873029"
	)
	@Export("getIsUsernameHidden")
	boolean getIsUsernameHidden() {
		return this.hideUsername;
	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "(ZI)V",
		garbageValue = "-1738158187"
	)
	@Export("getTitleMusicDisabled")
	void getTitleMusicDisabled(boolean var1) {
		this.titleMusicDisabled = var1;
		class144.savePreferences();
	}

	@ObfuscatedName("av")
	@ObfuscatedSignature(
		descriptor = "(B)Z",
		garbageValue = "-76"
	)
	@Export("getTitleMusicDisabled")
	boolean getTitleMusicDisabled() {
		return this.titleMusicDisabled;
	}

	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		descriptor = "(ZI)V",
		garbageValue = "-1239790948"
	)
	void method544(boolean var1) {
		this.displayFps = var1;
		class144.savePreferences();
	}

	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-448178452"
	)
	void method545() {
		this.method544(!this.displayFps);
	}

	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "1788161752"
	)
	boolean method546() {
		return this.displayFps;
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(IB)V",
		garbageValue = "34"
	)
	void method547(int var1) {
		this.field1068 = var1;
		class144.savePreferences();
	}

	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "-67"
	)
	int method548() {
		return this.field1068;
	}

	@ObfuscatedName("aj")
	@Export("setBrightness")
	void setBrightness(double var1) {
		this.brightness = var1;
		class144.savePreferences();
	}

	@ObfuscatedName("an")
	@ObfuscatedSignature(
		descriptor = "(I)D",
		garbageValue = "579802004"
	)
	@Export("getBrightness")
	double getBrightness() {
		return this.brightness;
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "428446104"
	)
	@Export("setCurrentMusicVolume")
	void setCurrentMusicVolume(int var1) {
		this.musicVolume = var1;
		class144.savePreferences();
	}

	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "813225298"
	)
	@Export("getCurrentMusicVolume")
	int getCurrentMusicVolume() {
		return this.musicVolume;
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "1930056928"
	)
	@Export("setCurrentSoundEffectVolume")
	void setCurrentSoundEffectVolume(int var1) {
		this.soundEffectsVolume = var1;
		class144.savePreferences();
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "440195040"
	)
	@Export("getCurrentSoundEffectsVolume")
	int getCurrentSoundEffectsVolume() {
		return this.soundEffectsVolume;
	}

	@ObfuscatedName("aq")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "-1563658200"
	)
	@Export("setAreaSoundEffectsVolume")
	void setAreaSoundEffectsVolume(int var1) {
		this.areaSoundEffectsVolume = var1;
		class144.savePreferences();
	}

	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "-40"
	)
	@Export("getAreaSoundEffectsVolume")
	int getAreaSoundEffectsVolume() {
		return this.areaSoundEffectsVolume;
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;S)V",
		garbageValue = "8224"
	)
	@Export("setUsernameToRemember")
	void setUsernameToRemember(String var1) {
		this.rememberedUsername = var1;
		class144.savePreferences();
	}

	@ObfuscatedName("af")
	@ObfuscatedSignature(
		descriptor = "(I)Ljava/lang/String;",
		garbageValue = "222957667"
	)
	@Export("getUsernameToRemember")
	String getUsernameToRemember() {
		return this.rememberedUsername;
	}

	@ObfuscatedName("ad")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "305556660"
	)
	void method559(int var1) {
		this.field1070 = var1;
		class144.savePreferences();
	}

	@ObfuscatedName("bn")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "2047489929"
	)
	int method560() {
		return this.field1070;
	}

	@ObfuscatedName("bk")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "1603412139"
	)
	void method561(int var1) {
		this.windowMode = var1;
		class144.savePreferences();
	}

	@ObfuscatedName("by")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "-453513391"
	)
	int method562() {
		return this.windowMode;
	}

	@ObfuscatedName("bd")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;II)V",
		garbageValue = "1984702450"
	)
	void method563(String var1, int var2) {
		int var3 = this.method566(var1);
		if (this.parameters.size() >= 10 && !this.parameters.containsKey(var3)) {
			Iterator var4 = this.parameters.entrySet().iterator();
			var4.next();
			var4.remove();
		}

		this.parameters.put(var3, var2);
		class144.savePreferences();
	}

	@ObfuscatedName("be")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;I)Z",
		garbageValue = "-754165935"
	)
	boolean method564(String var1) {
		int var2 = this.method566(var1);
		return this.parameters.containsKey(var2);
	}

	@ObfuscatedName("bv")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;I)I",
		garbageValue = "-558374148"
	)
	int method565(String var1) {
		int var2 = this.method566(var1);
		return !this.parameters.containsKey(var2) ? 0 : (Integer)this.parameters.get(var2);
	}

	@ObfuscatedName("ba")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;I)I",
		garbageValue = "1498275662"
	)
	int method566(String var1) {
		return PacketWriter.method647(var1.toLowerCase());
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(ILds;ZS)I",
		garbageValue = "-14036"
	)
	static int method567(int var0, Script var1, boolean var2) {
		int var3 = -1;
		Widget var4;
		if (var0 >= 2000) {
			var0 -= 1000;
			var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
			var4 = class33.widgetDefinition.method1740(var3);
		} else {
			var4 = var2 ? class416.scriptDotWidget : class306.scriptActiveWidget;
		}

		if (var0 == 1000) {
			Interpreter.Interpreter_intStackSize -= 4;
			var4.rawX = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
			var4.rawY = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
			var4.xAlignment = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 2];
			var4.yAlignment = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 3];
			ClanChannelMember.invalidateWidget(var4);
			class159.client.alignWidget(var4);
			if (var3 != -1 && var4.type == 0) {
				PendingSpawn.revalidateWidgetScroll(class33.widgetDefinition.Widget_interfaceComponents[var3 >> 16], var4, false);
			}

			return 1;
		} else if (var0 == 1001) {
			Interpreter.Interpreter_intStackSize -= 4;
			var4.rawWidth = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
			var4.rawHeight = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
			var4.widthAlignment = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 2];
			var4.heightAlignment = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 3];
			ClanChannelMember.invalidateWidget(var4);
			class159.client.alignWidget(var4);
			if (var3 != -1 && var4.type == 0) {
				PendingSpawn.revalidateWidgetScroll(class33.widgetDefinition.Widget_interfaceComponents[var3 >> 16], var4, false);
			}

			return 1;
		} else if (var0 == 1003) {
			boolean var5 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
			if (var5 != var4.isHidden) {
				var4.isHidden = var5;
				ClanChannelMember.invalidateWidget(var4);
			}

			return 1;
		} else if (var0 == 1005) {
			var4.noClickThrough = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
			return 1;
		} else if (var0 == 1006) {
			var4.noScrollThrough = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
			return 1;
		} else {
			return 2;
		}
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(I)[Lem;",
		garbageValue = "1083227717"
	)
	static AttackOption[] method569() {
		return new AttackOption[]{AttackOption.field1100, AttackOption.field1102, AttackOption.AttackOption_dependsOnCombatLevels, AttackOption.AttackOption_hidden, AttackOption.AttackOption_alwaysRightClick};
	}

	@ObfuscatedName("an")
	@ObfuscatedSignature(
		descriptor = "(IIB)I",
		garbageValue = "-29"
	)
	static final int method568(int var0, int var1) {
		int var2 = var1 * 57 + var0;
		var2 ^= var2 << 13;
		int var3 = var2 * (var2 * var2 * 15731 + 789221) + 1376312589 & Integer.MAX_VALUE;
		return var3 >> 19 & 255;
	}
}