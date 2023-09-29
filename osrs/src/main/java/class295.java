import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lk")
public abstract class class295 implements class297 {
	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "Lom;"
	)
	@Export("SequenceDefinition_archive")
	static AbstractArchive SequenceDefinition_archive;
	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		descriptor = "Lgi;"
	)
	static ClanSettings field2496;
	@ObfuscatedName("ac")
	protected int field2498;

	@ObfuscatedSignature(
		descriptor = "(Lnp;Loa;I)V"
	)
	protected class295(StudioGame var1, Language var2, int var3) {
		this.field2498 = var3;
	}
}