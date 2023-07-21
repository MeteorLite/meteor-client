import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("da")
@Implements("ClientPreferences")
public class ClientPreferences {
	@ObfuscatedName("as")
	@Export("roofsHidden")
	boolean roofsHidden;
	@ObfuscatedName("aj")
	@Export("hideUsername")
	boolean hideUsername;
	@ObfuscatedName("ag")
	@Export("titleMusicDisabled")
	boolean titleMusicDisabled;
	@ObfuscatedName("az")
	@Export("displayFps")
	boolean displayFps;
	@ObfuscatedName("av")
	int field1062;
	@ObfuscatedName("ap")
	@Export("brightness")
	double brightness;
	@ObfuscatedName("aq")
	@Export("musicVolume")
	int musicVolume;
	@ObfuscatedName("at")
	@Export("soundEffectsVolume")
	int soundEffectsVolume;
	@ObfuscatedName("ah")
	@Export("areaSoundEffectsVolume")
	int areaSoundEffectsVolume;
	@ObfuscatedName("ax")
	int field1063;
	@ObfuscatedName("aa")
	@Export("rememberedUsername")
	String rememberedUsername;
	@ObfuscatedName("au")
	@Export("windowMode")
	int windowMode;
	@ObfuscatedName("ae")
	@Export("parameters")
	final Map parameters;

	ClientPreferences() {
		this.hideUsername = false;
		this.displayFps = false;
		this.brightness = 0.8D;
		this.musicVolume = 127;
		this.soundEffectsVolume = 127;
		this.areaSoundEffectsVolume = 127;
		this.field1063 = -1;
		this.rememberedUsername = null;
		this.windowMode = 1;
		this.parameters = new LinkedHashMap();
		this.method547(true);
	}

	@ObfuscatedSignature(
		descriptor = "(Lty;)V"
	)
	ClientPreferences(Buffer var1) {
		this.hideUsername = false;
		this.displayFps = false;
		this.brightness = 0.8D;
		this.musicVolume = 127;
		this.soundEffectsVolume = 127;
		this.areaSoundEffectsVolume = 127;
		this.field1063 = -1;
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
					this.field1063 = var1.readUnsignedByte();
				}

				if (var2 > 8) {
					this.displayFps = var1.readUnsignedByte() == 1;
				}

				if (var2 > 9) {
					this.field1062 = var1.readInt();
				}
			} else {
				this.method547(true);
			}
		} else {
			this.method547(true);
		}

	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(ZB)V",
		garbageValue = "-46"
	)
	void method547(boolean var1) {
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(I)Lty;",
		garbageValue = "-819930938"
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
		var1.writeByte(this.field1063);
		var1.writeByte(this.displayFps ? 1 : 0);
		var1.writeInt(this.field1062);
		return var1;
	}

	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "(ZB)V",
		garbageValue = "100"
	)
	@Export("setRoofsHidden")
	void setRoofsHidden(boolean var1) {
		this.roofsHidden = var1;
		GrandExchangeEvents.savePreferences();
	}

	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		descriptor = "(B)Z",
		garbageValue = "-38"
	)
	@Export("getRoofsHidden")
	boolean getRoofsHidden() {
		return this.roofsHidden;
	}

	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		descriptor = "(ZI)V",
		garbageValue = "441049992"
	)
	@Export("setIsUsernameHidden")
	void setIsUsernameHidden(boolean var1) {
		this.hideUsername = var1;
		GrandExchangeEvents.savePreferences();
	}

	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "2023726507"
	)
	@Export("getIsUsernameHidden")
	boolean getIsUsernameHidden() {
		return this.hideUsername;
	}

	@ObfuscatedName("av")
	@ObfuscatedSignature(
		descriptor = "(ZI)V",
		garbageValue = "-1734059763"
	)
	@Export("getTitleMusicDisabled")
	void getTitleMusicDisabled(boolean var1) {
		this.titleMusicDisabled = var1;
		GrandExchangeEvents.savePreferences();
	}

	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "-1364267368"
	)
	@Export("getTitleMusicDisabled")
	boolean getTitleMusicDisabled() {
		return this.titleMusicDisabled;
	}

	@ObfuscatedName("aq")
	@ObfuscatedSignature(
		descriptor = "(ZI)V",
		garbageValue = "102997965"
	)
	void method555(boolean var1) {
		this.displayFps = var1;
		GrandExchangeEvents.savePreferences();
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-728222714"
	)
	void method556() {
		this.method555(!this.displayFps);
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(B)Z",
		garbageValue = "19"
	)
	boolean method557() {
		return this.displayFps;
	}

	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "-95805097"
	)
	void method558(int var1) {
		this.field1062 = var1;
		GrandExchangeEvents.savePreferences();
	}

	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "(S)I",
		garbageValue = "-11415"
	)
	int method559() {
		return this.field1062;
	}

	@ObfuscatedName("au")
	@Export("setBrightness")
	void setBrightness(double var1) {
		this.brightness = var1;
		GrandExchangeEvents.savePreferences();
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(B)D",
		garbageValue = "49"
	)
	@Export("getBrightness")
	double getBrightness() {
		return this.brightness;
	}

	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "1354981451"
	)
	@Export("setCurrentMusicVolume")
	void setCurrentMusicVolume(int var1) {
		this.musicVolume = var1;
		GrandExchangeEvents.savePreferences();
	}

	@ObfuscatedName("ad")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "-54"
	)
	@Export("getCurrentMusicVolume")
	int getCurrentMusicVolume() {
		return this.musicVolume;
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(IB)V",
		garbageValue = "-65"
	)
	@Export("setCurrentSoundEffectVolume")
	void setCurrentSoundEffectVolume(int var1) {
		this.soundEffectsVolume = var1;
		GrandExchangeEvents.savePreferences();
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "-232317840"
	)
	@Export("getCurrentSoundEffectsVolume")
	int getCurrentSoundEffectsVolume() {
		return this.soundEffectsVolume;
	}

	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "(IB)V",
		garbageValue = "-58"
	)
	@Export("setAreaSoundEffectsVolume")
	void setAreaSoundEffectsVolume(int var1) {
		this.areaSoundEffectsVolume = var1;
		GrandExchangeEvents.savePreferences();
	}

	@ObfuscatedName("an")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "160605956"
	)
	@Export("getAreaSoundEffectsVolume")
	int getAreaSoundEffectsVolume() {
		return this.areaSoundEffectsVolume;
	}

	@ObfuscatedName("af")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;S)V",
		garbageValue = "-1250"
	)
	@Export("setUsernameToRemember")
	void setUsernameToRemember(String var1) {
		this.rememberedUsername = var1;
		GrandExchangeEvents.savePreferences();
	}

	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		descriptor = "(I)Ljava/lang/String;",
		garbageValue = "575676245"
	)
	@Export("getUsernameToRemember")
	String getUsernameToRemember() {
		return this.rememberedUsername;
	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "2070702766"
	)
	void method570(int var1) {
		this.field1063 = var1;
		GrandExchangeEvents.savePreferences();
	}

	@ObfuscatedName("bd")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "2072184025"
	)
	int method571() {
		return this.field1063;
	}

	@ObfuscatedName("bb")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "-1480770994"
	)
	void method572(int var1) {
		this.windowMode = var1;
		GrandExchangeEvents.savePreferences();
	}

	@ObfuscatedName("bn")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "-56"
	)
	int method573() {
		return this.windowMode;
	}

	@ObfuscatedName("ba")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;II)V",
		garbageValue = "-159104125"
	)
	void method574(String var1, int var2) {
		int var3 = this.method577(var1);
		if (this.parameters.size() >= 10 && !this.parameters.containsKey(var3)) {
			Iterator var4 = this.parameters.entrySet().iterator();
			var4.next();
			var4.remove();
		}

		this.parameters.put(var3, var2);
		GrandExchangeEvents.savePreferences();
	}

	@ObfuscatedName("bf")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;I)Z",
		garbageValue = "1920162688"
	)
	boolean method575(String var1) {
		int var2 = this.method577(var1);
		return this.parameters.containsKey(var2);
	}

	@ObfuscatedName("bs")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;I)I",
		garbageValue = "-458294629"
	)
	int method576(String var1) {
		int var2 = this.method577(var1);
		return !this.parameters.containsKey(var2) ? 0 : (Integer)this.parameters.get(var2);
	}

	@ObfuscatedName("bp")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;I)I",
		garbageValue = "-1103687979"
	)
	int method577(String var1) {
		return ItemLayer.method1128(var1.toLowerCase());
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "([Los;II)Los;",
		garbageValue = "-1385726051"
	)
	@Export("findEnumerated")
	public static class372 findEnumerated(class372[] var0, int var1) {
		class372[] var2 = var0;

		for (int var3 = 0; var3 < var2.length; ++var3) {
			class372 var4 = var2[var3];
			if (var1 == var4.rsOrdinal()) {
				return var4;
			}
		}

		return null;
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(FB)F",
		garbageValue = "-99"
	)
	public static final float method546(float var0) {
		float var1 = 75.0F;
		float var2 = 10000.0F;
		float var3 = 750000.0F / (10000.0F - var0 * 9925.0F);
		return (var3 - 75.0F) / 9925.0F;
	}
}
