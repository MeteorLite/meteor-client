import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fq")
@Implements("VarcInt")
public class VarcInt extends DualNode {
	@ObfuscatedName("a")
	@ObfuscatedSignature(
		descriptor = "Llg;"
	)
	@Export("VarcInt_archive")
	public static AbstractArchive VarcInt_archive;
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		descriptor = "Ljx;"
	)
	@Export("VarcInt_cached")
	public static EvictingDualNodeHashTable VarcInt_cached;
	@ObfuscatedName("c")
	@Export("persist")
	public boolean persist;

	static {
		VarcInt_cached = new EvictingDualNodeHashTable(64);
	}

	public VarcInt() {
		this.persist = false;
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		descriptor = "(Lqr;B)V",
		garbageValue = "-1"
	)
	public void method3459(Buffer var1) {
		while (true) {
			int var2 = var1.readUnsignedByte();
			if (var2 == 0) {
				return;
			}

			this.method3463(var1, var2);
		}
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "(Lqr;IB)V",
		garbageValue = "1"
	)
	void method3463(Buffer var1, int var2) {
		if (var2 == 2) {
			this.persist = true;
		}

	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		descriptor = "(S)[Ljw;",
		garbageValue = "20279"
	)
	@Export("ServerPacket_values")
	public static ServerPacket[] ServerPacket_values() {
		return new ServerPacket[]{ServerPacket.field3194, ServerPacket.field3131, ServerPacket.field3230, ServerPacket.field3153, ServerPacket.field3134, ServerPacket.field3135, ServerPacket.field3136, ServerPacket.field3179, ServerPacket.field3160, ServerPacket.field3139, ServerPacket.field3140, ServerPacket.field3141, ServerPacket.field3142, ServerPacket.field3168, ServerPacket.field3144, ServerPacket.field3151, ServerPacket.field3221, ServerPacket.field3147, ServerPacket.field3227, ServerPacket.field3149, ServerPacket.field3242, ServerPacket.field3197, ServerPacket.field3138, ServerPacket.field3150, ServerPacket.field3154, ServerPacket.field3155, ServerPacket.field3156, ServerPacket.field3132, ServerPacket.field3158, ServerPacket.field3159, ServerPacket.field3174, ServerPacket.field3146, ServerPacket.field3162, ServerPacket.field3201, ServerPacket.field3191, ServerPacket.field3165, ServerPacket.field3166, ServerPacket.field3167, ServerPacket.field3163, ServerPacket.field3169, ServerPacket.field3170, ServerPacket.field3171, ServerPacket.field3172, ServerPacket.field3243, ServerPacket.field3173, ServerPacket.field3175, ServerPacket.field3176, ServerPacket.field3210, ServerPacket.field3178, ServerPacket.field3199, ServerPacket.field3180, ServerPacket.field3181, ServerPacket.field3182, ServerPacket.field3183, ServerPacket.field3184, ServerPacket.field3137, ServerPacket.field3186, ServerPacket.field3187, ServerPacket.field3143, ServerPacket.field3189, ServerPacket.field3152, ServerPacket.field3217, ServerPacket.field3192, ServerPacket.field3193, ServerPacket.field3177, ServerPacket.field3195, ServerPacket.field3196, ServerPacket.field3130, ServerPacket.field3198, ServerPacket.field3188, ServerPacket.field3200, ServerPacket.field3229, ServerPacket.field3211, ServerPacket.field3203, ServerPacket.field3204, ServerPacket.field3205, ServerPacket.field3206, ServerPacket.field3207, ServerPacket.field3208, ServerPacket.field3209, ServerPacket.field3148, ServerPacket.field3164, ServerPacket.field3212, ServerPacket.field3213, ServerPacket.field3214, ServerPacket.field3215, ServerPacket.field3216, ServerPacket.field3185, ServerPacket.field3218, ServerPacket.field3219, ServerPacket.field3220, ServerPacket.field3202, ServerPacket.field3222, ServerPacket.field3223, ServerPacket.field3224, ServerPacket.field3225, ServerPacket.field3226, ServerPacket.field3239, ServerPacket.field3228, ServerPacket.field3190, ServerPacket.field3145, ServerPacket.field3231, ServerPacket.field3232, ServerPacket.field3233, ServerPacket.field3234, ServerPacket.field3235, ServerPacket.field3236, ServerPacket.field3237, ServerPacket.field3238, ServerPacket.field3161, ServerPacket.field3240};
	}
}
