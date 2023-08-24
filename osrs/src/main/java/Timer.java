import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.ArrayList;

@ObfuscatedName("py")
@Implements("Timer")
public class Timer {
	@ObfuscatedName("au")
	long field3755;
	@ObfuscatedName("ae")
	long field3752;
	@ObfuscatedName("ao")
	public boolean field3756;
	@ObfuscatedName("at")
	long field3754;
	@ObfuscatedName("ac")
	long field3751;
	@ObfuscatedName("ai")
	long field3753;
	@ObfuscatedName("az")
	int field3750;
	@ObfuscatedName("ap")
	int field3749;
	@ObfuscatedName("aa")
	int field3747;
	@ObfuscatedName("af")
	int field3748;

	public Timer() {
		this.field3755 = -1L;
		this.field3752 = -1L;
		this.field3756 = false;
		this.field3754 = 0L;
		this.field3751 = 0L;
		this.field3753 = 0L;
		this.field3750 = 0;
		this.field3749 = 0;
		this.field3747 = 0;
		this.field3748 = 0;
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(S)V",
		garbageValue = "8457"
	)
	public void method2150() {
		this.field3755 = GameEngine.clockNow();
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-1934849344"
	)
	public void method2151() {
		if (-1L != this.field3755) {
			this.field3751 = GameEngine.clockNow() - this.field3755;
			this.field3755 = -1L;
		}

	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "-350362388"
	)
	public void method2152(int var1) {
		this.field3752 = GameEngine.clockNow();
		this.field3750 = var1;
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "1654604746"
	)
	public void method2153() {
		if (-1L != this.field3752) {
			this.field3754 = GameEngine.clockNow() - this.field3752;
			this.field3752 = -1L;
		}

		++this.field3747;
		this.field3756 = true;
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-1332700570"
	)
	public void method2154() {
		this.field3756 = false;
		this.field3749 = 0;
	}

	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-1203645178"
	)
	public void method2155() {
		this.method2153();
	}

	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "(Ltm;I)V",
		garbageValue = "-1131300040"
	)
	@Export("write")
	public void write(Buffer var1) {
		ClientPreferences.method539(var1, this.field3751);
		ClientPreferences.method539(var1, this.field3754);
		ClientPreferences.method539(var1, this.field3753);
		var1.writeShort(this.field3750);
		var1.writeShort(this.field3749);
		var1.writeShort(this.field3747);
		var1.writeShort(this.field3748);
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(Lnu;Lnu;ZII)V",
		garbageValue = "-1307965199"
	)
	static void method2157(AbstractArchive var0, AbstractArchive var1, boolean var2, int var3) {
		if (class403.clearLoginScreen) {
			if (var3 == 4) {
				PcmPlayer.method212(4);
			}

		} else {
			if (var3 == 0) {
				WorldMapAreaData.method1574(var2);
			} else {
				PcmPlayer.method212(var3);
			}

			Rasterizer2D.Rasterizer2D_clear();
			byte[] var4 = var0.takeFileByNames("title.jpg", "");
			Login.leftTitleSprite = WorldMapData_1.method1484(var4);
			Bounds.rightTitleSprite = Login.leftTitleSprite.mirrorHorizontally();
			int var5 = Client.worldProperties;
			if ((var5 & class510.field4132.rsOrdinal()) != 0) {
				SoundSystem.logoSprite = class172.SpriteBuffer_getIndexedSpriteByName(var1, "logo_deadman_mode", "");
			} else if ((var5 & class510.field4131.rsOrdinal()) != 0) {
				SoundSystem.logoSprite = class172.SpriteBuffer_getIndexedSpriteByName(var1, "logo_seasonal_mode", "");
			} else if ((var5 & class510.field4122.rsOrdinal()) != 0) {
				SoundSystem.logoSprite = class172.SpriteBuffer_getIndexedSpriteByName(var1, "logo_speedrunning", "");
			} else {
				SoundSystem.logoSprite = class172.SpriteBuffer_getIndexedSpriteByName(var1, "logo", "");
			}

			Login.titleboxSprite = class172.SpriteBuffer_getIndexedSpriteByName(var1, "titlebox", "");
			class219.titlebuttonSprite = class172.SpriteBuffer_getIndexedSpriteByName(var1, "titlebutton", "");
			Login.field777 = class172.SpriteBuffer_getIndexedSpriteByName(var1, "titlebutton_large", "");
			ItemContainer.field853 = class172.SpriteBuffer_getIndexedSpriteByName(var1, "play_now_text", "");
			class172.SpriteBuffer_getIndexedSpriteByName(var1, "titlebutton_wide42,1", "");
			Login.runesSprite = class219.method1149(var1, "runes", "");
			class13.title_muteSprite = class219.method1149(var1, "title_mute", "");
			Login.options_buttons_0Sprite = class172.SpriteBuffer_getIndexedSpriteByName(var1, "options_radio_buttons,0", "");
			Skills.field3145 = class172.SpriteBuffer_getIndexedSpriteByName(var1, "options_radio_buttons,4", "");
			UserComparator6.options_buttons_2Sprite = class172.SpriteBuffer_getIndexedSpriteByName(var1, "options_radio_buttons,2", "");
			VerticalAlignment.field1631 = class172.SpriteBuffer_getIndexedSpriteByName(var1, "options_radio_buttons,6", "");
			class136.field1295 = Login.options_buttons_0Sprite.subWidth;
			User.field3801 = Login.options_buttons_0Sprite.subHeight;
			class139.field1323 = new LoginScreenAnimation(Login.runesSprite);
			if (var2) {
				Login.Login_username = "";
				Login.Login_password = "";
				Login.field768 = new String[8];
				Login.field752 = 0;
			}

			class503.field4107 = 0;
			class369.otp = "";
			Login.field743 = true;
			Login.worldSelectOpen = false;
			if (!class449.clientPreferences.getTitleMusicDisabled()) {
				ArrayList var6 = new ArrayList();
				var6.add(new MusicSong(class385.archive6, "scape main", "", 255, false));
				class53.method291(var6, 0, 0, 0, 100, false);
			} else {
				Script.method445(0, 0);
			}

			UrlRequester.method652();
			CollisionMap.method1122().method1932(false);
			class403.clearLoginScreen = true;
			Login.xPadding = (class113.canvasWidth - 765) / 2;
			Login.loginBoxX = Login.xPadding + 202;
			class452.loginBoxCenter = Login.loginBoxX + 180;
			Login.leftTitleSprite.drawAt(Login.xPadding, 0);
			Bounds.rightTitleSprite.drawAt(Login.xPadding + 382, 0);
			SoundSystem.logoSprite.drawAt(Login.xPadding + 382 - SoundSystem.logoSprite.subWidth / 2, 18);
		}
	}
}