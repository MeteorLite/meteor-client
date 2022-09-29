import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("in")
@Implements("WorldMapEvent")
public class WorldMapEvent {
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = -1057426347
	)
	@Export("mapElement")
	public int mapElement;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		descriptor = "Lkz;"
	)
	@Export("coord1")
	public Coord coord1;
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		descriptor = "Lkz;"
	)
	@Export("coord2")
	public Coord coord2;

	@ObfuscatedSignature(
		descriptor = "(ILkz;Lkz;)V"
	)
	public WorldMapEvent(int var1, Coord var2, Coord var3) {
		this.mapElement = var1;
		this.coord1 = var2;
		this.coord2 = var3;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "(B)[Ljl;",
		garbageValue = "127"
	)
	@Export("ServerPacket_values")
	public static ServerPacket[] ServerPacket_values() {
		return new ServerPacket[]{ServerPacket.field3134, ServerPacket.field3174, ServerPacket.field3073, ServerPacket.field3074, ServerPacket.field3145, ServerPacket.field3076, ServerPacket.field3077, ServerPacket.field3125, ServerPacket.field3120, ServerPacket.field3080, ServerPacket.field3081, ServerPacket.field3141, ServerPacket.field3083, ServerPacket.field3084, ServerPacket.field3085, ServerPacket.field3086, ServerPacket.field3087, ServerPacket.field3071, ServerPacket.field3142, ServerPacket.field3090, ServerPacket.field3095, ServerPacket.field3092, ServerPacket.field3093, ServerPacket.field3079, ServerPacket.field3104, ServerPacket.field3149, ServerPacket.field3097, ServerPacket.field3098, ServerPacket.field3099, ServerPacket.field3147, ServerPacket.field3101, ServerPacket.field3102, ServerPacket.field3103, ServerPacket.field3165, ServerPacket.field3105, ServerPacket.field3106, ServerPacket.field3107, ServerPacket.field3153, ServerPacket.field3109, ServerPacket.field3110, ServerPacket.field3113, ServerPacket.field3175, ServerPacket.field3115, ServerPacket.field3114, ServerPacket.field3078, ServerPacket.field3116, ServerPacket.field3117, ServerPacket.field3118, ServerPacket.field3119, ServerPacket.field3127, ServerPacket.field3121, ServerPacket.field3151, ServerPacket.field3123, ServerPacket.field3124, ServerPacket.field3072, ServerPacket.field3126, ServerPacket.field3096, ServerPacket.field3100, ServerPacket.field3129, ServerPacket.field3130, ServerPacket.field3131, ServerPacket.field3132, ServerPacket.field3133, ServerPacket.field3091, ServerPacket.field3135, ServerPacket.field3136, ServerPacket.field3137, ServerPacket.field3138, ServerPacket.field3139, ServerPacket.field3140, ServerPacket.field3170, ServerPacket.field3172, ServerPacket.field3143, ServerPacket.field3144, ServerPacket.field3094, ServerPacket.field3146, ServerPacket.field3158, ServerPacket.field3112, ServerPacket.field3177, ServerPacket.field3111, ServerPacket.field3150, ServerPacket.field3152, ServerPacket.field3089, ServerPacket.field3160, ServerPacket.field3155, ServerPacket.field3156, ServerPacket.field3157, ServerPacket.field3164, ServerPacket.field3159, ServerPacket.field3082, ServerPacket.field3161, ServerPacket.field3088, ServerPacket.field3163, ServerPacket.field3075, ServerPacket.field3154, ServerPacket.field3162, ServerPacket.field3167, ServerPacket.field3168, ServerPacket.field3169, ServerPacket.field3122, ServerPacket.field3171, ServerPacket.field3128, ServerPacket.field3173, ServerPacket.field3108, ServerPacket.field3166, ServerPacket.field3176};
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "(II)Ldv;",
		garbageValue = "-958717632"
	)
	static class119 method5257(int var0) {
		class119[] var1 = new class119[]{class119.field1480, class119.field1470, class119.field1473, class119.field1472, class119.field1471, class119.field1474};
		class119 var2 = (class119)Varps.findEnumerated(var1, var0);
		if (var2 == null) {
			var2 = class119.field1480;
		}

		return var2;
	}

	@ObfuscatedName("hd")
	@ObfuscatedSignature(
		descriptor = "(Lcl;I)Z",
		garbageValue = "2125074657"
	)
	static boolean method5256(Player var0) {
		if (Client.drawPlayerNames == 0) {
			return false;
		} else {
			boolean var1;
			if (class67.localPlayer == var0) {
				var1 = (Client.drawPlayerNames & 8) != 0;
				return var1;
			} else {
				var1 = UserComparator4.method2730() || class137.method3085() && var0.isFriend();
				if (!var1) {
					boolean var2 = (Client.drawPlayerNames & 2) != 0;
					var1 = var2 && var0.isFriendsChatMember();
				}

				return var1;
			}
		}
	}
}
