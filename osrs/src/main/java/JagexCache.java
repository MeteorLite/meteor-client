import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.io.File;
import java.util.Iterator;

@ObfuscatedName("gv")
@Implements("JagexCache")
public class JagexCache {
	@ObfuscatedName("ax")
	static File field1451;
	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "Ltl;"
	)
	@Export("JagexCache_randomDat")
	static BufferedFile JagexCache_randomDat;
	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		descriptor = "Ltl;"
	)
	@Export("JagexCache_dat2File")
	public static BufferedFile JagexCache_dat2File;
	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "Ltl;"
	)
	@Export("JagexCache_idx255File")
	public static BufferedFile JagexCache_idx255File;
	@ObfuscatedName("pl")
	@Export("selectedSpellWidget" )
	static int selectedSpellWidget;
	@ObfuscatedName("vz")
	static int field1450;

	static {
		JagexCache_randomDat = null;
		JagexCache_dat2File = null;
		JagexCache_idx255File = null;
	}

	@ObfuscatedName("it")
	@ObfuscatedSignature(
		descriptor = "(Ldi;I)V",
		garbageValue = "-1922065040"
	)
	static final void method918(Actor var0) {
		boolean var1 = var0.exactMoveArrive1Cycle == Client.cycle || var0.sequence == -1 || var0.sequenceDelay != 0;
		if (!var1) {
			SequenceDefinition var2 = class36.SequenceDefinition_get(var0.sequence);
			if (var2 != null && !var2.isCachedModelIdSet()) {
				var1 = var0.sequenceFrameCycle + 1 > var2.frameLengths[var0.sequenceFrame];
			} else {
				var1 = true;
			}
		}

		if (var1) {
			int var8 = var0.exactMoveArrive1Cycle - var0.spotAnimation;
			int var3 = Client.cycle - var0.spotAnimation;
			int var4 = var0.field971 * 64 + var0.field1016 * 128;
			int var5 = var0.field971 * 64 + var0.field1013 * 128;
			int var6 = var0.field971 * 64 + var0.field1021 * 128;
			int var7 = var0.field971 * 64 + var0.field1010 * 128;
			var0.x = (var3 * var6 + var4 * (var8 - var3)) / var8;
			var0.y = (var3 * var7 + var5 * (var8 - var3)) / var8;
		}

		var0.field1024 = 0;
		var0.orientation = var0.exactMoveDirection;
		var0.rotation = var0.orientation;
	}

	@ObfuscatedName("lp")
	@ObfuscatedSignature(
		descriptor = "(IIIIIII)V",
		garbageValue = "1000434204"
	)
	static final void method919(int var0, int var1, int var2, int var3, int var4, int var5) {
		int var6 = var2 - var0;
		int var7 = var3 - var1;
		int var8 = var6 >= 0 ? var6 : -var6;
		int var9 = var7 >= 0 ? var7 : -var7;
		int var10 = var8;
		if (var8 < var9) {
			var10 = var9;
		}

		if (var10 != 0) {
			int var11 = (var6 << 16) / var10;
			int var12 = (var7 << 16) / var10;
			if (var12 <= var11) {
				var11 = -var11;
			} else {
				var12 = -var12;
			}

			int var13 = var5 * var12 >> 17;
			int var14 = var5 * var12 + 1 >> 17;
			int var15 = var5 * var11 >> 17;
			int var16 = var5 * var11 + 1 >> 17;
			var0 -= Rasterizer2D.Rasterizer2D_xClipStart;
			var1 -= Rasterizer2D.Rasterizer2D_yClipStart;
			int var17 = var0 + var13;
			int var18 = var0 - var14;
			int var19 = var0 + var6 - var14;
			int var20 = var0 + var6 + var13;
			int var21 = var15 + var1;
			int var22 = var1 - var16;
			int var23 = var7 + var1 - var16;
			int var24 = var7 + var15 + var1;
			Rasterizer3D.method1252(var17, var18, var19);
			Rasterizer3D.method1254(var21, var22, var23, var17, var18, var19, 0.0F, 0.0F, 0.0F, var4);
			Rasterizer3D.method1252(var17, var19, var20);
			Rasterizer3D.method1254(var21, var23, var24, var17, var19, var20, 0.0F, 0.0F, 0.0F, var4);
		}
	}

	@ObfuscatedName("mg")
	static final void method920(double var0) {
		Rasterizer3D.method1236(var0);
		((TextureProvider)Rasterizer3D.clips.Rasterizer3D_textureLoader).setBrightness(var0);
		ItemComposition.ItemDefinition_cachedSprites.clear();
		class91.clientPreferences.setBrightness(var0);
	}

	@ObfuscatedName("nt")
	@ObfuscatedSignature(
		descriptor = "(IS)V",
		garbageValue = "-10864"
	)
	static final void method921(int var0) {
		var0 = Math.min(Math.max(var0, 0), 255);
		if (var0 != class91.clientPreferences.getCurrentMusicVolume()) {
			if (class91.clientPreferences.getCurrentMusicVolume() == 0 && ScriptFrame.method334()) {
				VarcInt.method975(CollisionMap.archive6, var0);
				Client.playingJingle = false;
			} else if (var0 == 0) {
				ItemComposition.method1088(0, 0);
				Client.playingJingle = false;
			} else if (!class319.musicSongs.isEmpty()) {
				Iterator var1 = class319.musicSongs.iterator();

				while (var1.hasNext()) {
					MusicSong var2 = (MusicSong)var1.next();
					if (var2 != null) {
						var2.musicTrackVolume = var0;
					}
				}

				MusicSong var3 = (MusicSong)class319.musicSongs.get(0);
				if (var3 != null && var3.midiPcmStream != null && var3.midiPcmStream.isReady() && !var3.field2886) {
					var3.midiPcmStream.setPcmStreamVolume(var0);
					var3.field2888 = (float)var0;
				}
			}

			class91.clientPreferences.setCurrentMusicVolume(var0);
		}

	}
}