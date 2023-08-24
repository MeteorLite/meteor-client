import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

@ObfuscatedName("dp")
@Implements("ClientPreferences")
public class ClientPreferences {
	@ObfuscatedName("ac")
	@Export("roofsHidden")
	boolean roofsHidden;
	@ObfuscatedName("ai")
	@Export("hideUsername")
	boolean hideUsername;
	@ObfuscatedName("az")
	@Export("titleMusicDisabled")
	boolean titleMusicDisabled;
	@ObfuscatedName("ap")
	@Export("displayFps")
	boolean displayFps;
	@ObfuscatedName("aa")
	int field1061;
	@ObfuscatedName("af")
	@Export("brightness")
	double brightness;
	@ObfuscatedName("ad")
	@Export("musicVolume")
	int musicVolume;
	@ObfuscatedName("aq")
	@Export("soundEffectsVolume")
	int soundEffectsVolume;
	@ObfuscatedName("al")
	@Export("areaSoundEffectsVolume")
	int areaSoundEffectsVolume;
	@ObfuscatedName("an")
	int field1065;
	@ObfuscatedName("ar")
	@Export("rememberedUsername")
	String rememberedUsername;
	@ObfuscatedName("ab")
	@Export("windowMode")
	int windowMode;
	@ObfuscatedName("ag")
	@Export("parameters")
	final Map parameters;

	ClientPreferences() {
		this.hideUsername = false;
		this.displayFps = false;
		this.brightness = 0.8D;
		this.musicVolume = 127;
		this.soundEffectsVolume = 127;
		this.areaSoundEffectsVolume = 127;
		this.field1065 = -1;
		this.rememberedUsername = null;
		this.windowMode = 1;
		this.parameters = new LinkedHashMap();
		this.method540(true);
	}

	@ObfuscatedSignature(
		descriptor = "(Ltm;)V"
	)
	ClientPreferences(Buffer var1) {
		this.hideUsername = false;
		this.displayFps = false;
		this.brightness = 0.8D;
		this.musicVolume = 127;
		this.soundEffectsVolume = 127;
		this.areaSoundEffectsVolume = 127;
		this.field1065 = -1;
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
					this.field1065 = var1.readUnsignedByte();
				}

				if (var2 > 8) {
					this.displayFps = var1.readUnsignedByte() == 1;
				}

				if (var2 > 9) {
					this.field1061 = var1.readInt();
				}
			} else {
				this.method540(true);
			}
		} else {
			this.method540(true);
		}

	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(ZB)V",
		garbageValue = "-35"
	)
	void method540(boolean var1) {
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(I)Ltm;",
		garbageValue = "1941143653"
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
		var1.writeByte(this.field1065);
		var1.writeByte(this.displayFps ? 1 : 0);
		var1.writeInt(this.field1061);
		return var1;
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(ZI)V",
		garbageValue = "932955968"
	)
	@Export("setRoofsHidden")
	void setRoofsHidden(boolean var1) {
		this.roofsHidden = var1;
		class338.savePreferences();
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "-767626364"
	)
	@Export("getRoofsHidden")
	boolean getRoofsHidden() {
		return this.roofsHidden;
	}

	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		descriptor = "(ZI)V",
		garbageValue = "-211242200"
	)
	@Export("setIsUsernameHidden")
	void setIsUsernameHidden(boolean var1) {
		this.hideUsername = var1;
		class338.savePreferences();
	}

	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "1977526319"
	)
	@Export("getIsUsernameHidden")
	boolean getIsUsernameHidden() {
		return this.hideUsername;
	}

	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		descriptor = "(ZI)V",
		garbageValue = "-973658923"
	)
	@Export("getTitleMusicDisabled")
	void getTitleMusicDisabled(boolean var1) {
		this.titleMusicDisabled = var1;
		class338.savePreferences();
	}

	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "(B)Z",
		garbageValue = "120"
	)
	@Export("getTitleMusicDisabled")
	boolean getTitleMusicDisabled() {
		return this.titleMusicDisabled;
	}

	@ObfuscatedName("af")
	@ObfuscatedSignature(
		descriptor = "(ZI)V",
		garbageValue = "534613668"
	)
	void method548(boolean var1) {
		this.displayFps = var1;
		class338.savePreferences();
	}

	@ObfuscatedName("ad")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-1847880996"
	)
	void method549() {
		this.method548(!this.displayFps);
	}

	@ObfuscatedName("aq")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "1017741261"
	)
	boolean method550() {
		return this.displayFps;
	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "(IB)V",
		garbageValue = "-11"
	)
	void method551(int var1) {
		this.field1061 = var1;
		class338.savePreferences();
	}

	@ObfuscatedName("an")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "1963125343"
	)
	int method552() {
		return this.field1061;
	}

	@ObfuscatedName("ar")
	@Export("setBrightness")
	void setBrightness(double var1) {
		this.brightness = var1;
		class338.savePreferences();
	}

	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "(I)D",
		garbageValue = "-1673173244"
	)
	@Export("getBrightness")
	double getBrightness() {
		return this.brightness;
	}

	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "-631794357"
	)
	@Export("setCurrentMusicVolume")
	void setCurrentMusicVolume(int var1) {
		this.musicVolume = var1;
		class338.savePreferences();
	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "121"
	)
	@Export("getCurrentMusicVolume")
	int getCurrentMusicVolume() {
		return this.musicVolume;
	}

	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "(IB)V",
		garbageValue = "-18"
	)
	@Export("setCurrentSoundEffectVolume")
	void setCurrentSoundEffectVolume(int var1) {
		this.soundEffectsVolume = var1;
		class338.savePreferences();
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "1509566185"
	)
	@Export("getCurrentSoundEffectsVolume")
	int getCurrentSoundEffectsVolume() {
		return this.soundEffectsVolume;
	}

	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "291571755"
	)
	@Export("setAreaSoundEffectsVolume")
	void setAreaSoundEffectsVolume(int var1) {
		this.areaSoundEffectsVolume = var1;
		class338.savePreferences();
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "-76"
	)
	@Export("getAreaSoundEffectsVolume")
	int getAreaSoundEffectsVolume() {
		return this.areaSoundEffectsVolume;
	}

	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;I)V",
		garbageValue = "1859632471"
	)
	@Export("setUsernameToRemember")
	void setUsernameToRemember(String var1) {
		this.rememberedUsername = var1;
		class338.savePreferences();
	}

	@ObfuscatedName("av")
	@ObfuscatedSignature(
		descriptor = "(B)Ljava/lang/String;",
		garbageValue = "63"
	)
	@Export("getUsernameToRemember")
	String getUsernameToRemember() {
		return this.rememberedUsername;
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "1109709806"
	)
	void method563(int var1) {
		this.field1065 = var1;
		class338.savePreferences();
	}

	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "-1749033471"
	)
	int method564() {
		return this.field1065;
	}

	@ObfuscatedName("bh")
	@ObfuscatedSignature(
		descriptor = "(IB)V",
		garbageValue = "23"
	)
	void method565(int var1) {
		this.windowMode = var1;
		class338.savePreferences();
	}

	@ObfuscatedName("bj")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "-1232255249"
	)
	int method566() {
		return this.windowMode;
	}

	@ObfuscatedName("bk")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;II)V",
		garbageValue = "-867564338"
	)
	void method567(String var1, int var2) {
		int var3 = this.method570(var1);
		if (this.parameters.size() >= 10 && !this.parameters.containsKey(var3)) {
			Iterator var4 = this.parameters.entrySet().iterator();
			var4.next();
			var4.remove();
		}

		this.parameters.put(var3, var2);
		class338.savePreferences();
	}

	@ObfuscatedName("bv")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;I)Z",
		garbageValue = "-1796045546"
	)
	boolean method568(String var1) {
		int var2 = this.method570(var1);
		return this.parameters.containsKey(var2);
	}

	@ObfuscatedName("bt")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;S)I",
		garbageValue = "-25926"
	)
	int method569(String var1) {
		int var2 = this.method570(var1);
		return !this.parameters.containsKey(var2) ? 0 : (Integer)this.parameters.get(var2);
	}

	@ObfuscatedName("bd")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;B)I",
		garbageValue = "-112"
	)
	int method570(String var1) {
		return VarbitComposition.method1012(var1.toLowerCase());
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(II)I",
		garbageValue = "-1544580715"
	)
	@Export("getVarbit")
	public static int getVarbit(int var0) {
		VarbitComposition var1 = class384.method2022(var0);
		int var2 = var1.baseVar;
		int var3 = var1.startBit;
		int var4 = var1.endBit;
		int var5 = Varps.Varps_masks[var4 - var3];
		return Varps.Varps_main[var2] >> var3 & var5;
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(CB)Z",
		garbageValue = "31"
	)
	public static final boolean method537(char var0) {
		if (Character.isISOControl(var0)) {
			return false;
		} else if (WorldMapLabel.isAlphaNumeric(var0)) {
			return true;
		} else {
			char[] var1 = class493.field4077;

			int var2;
			char var3;
			for (var2 = 0; var2 < var1.length; ++var2) {
				var3 = var1[var2];
				if (var0 == var3) {
					return true;
				}
			}

			var1 = class493.field4078;

			for (var2 = 0; var2 < var1.length; ++var2) {
				var3 = var1[var2];
				if (var0 == var3) {
					return true;
				}
			}

			return false;
		}
	}

	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		descriptor = "(Ltm;J)V"
	)
	static void method539(Buffer var0, long var1) {
		var1 /= 10L;
		if (var1 < 0L) {
			var1 = 0L;
		} else if (var1 > 65535L) {
			var1 = 65535L;
		}

		var0.writeShort((int)var1);
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(IB)I",
		garbageValue = "-51"
	)
	public static int method571(int var0) {
		class137 var1 = class338.method1862(var0);
		if (var1 == null) {
			return 2;
		} else {
			return var1.method746() ? 0 : 1;
		}
	}

	@ObfuscatedName("ka")
	@ObfuscatedSignature(
		descriptor = "(IIIIIIIIIIS)V",
		garbageValue = "10324"
	)
	@Export("updatePendingSpawn")
	static final void updatePendingSpawn(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
		PendingSpawn var10 = null;

		for (PendingSpawn var11 = (PendingSpawn)Client.pendingSpawns.last(); var11 != null; var11 = (PendingSpawn)Client.pendingSpawns.previous()) {
			if (var0 == var11.plane && var11.x == var1 && var2 == var11.y && var3 == var11.type) {
				var10 = var11;
				break;
			}
		}

		if (var10 == null) {
			var10 = new PendingSpawn();
			var10.plane = var0;
			var10.type = var3;
			var10.x = var1;
			var10.y = var2;
			var10.field945 = -1;
			PacketWriter.method646(var10);
			Client.pendingSpawns.addFirst(var10);
		}

		var10.id = var4;
		var10.objectType = var5;
		var10.rotation = var6;
		var10.startCycle = var8;
		var10.endCycle = var9;
		var10.method506(var7);
	}
}