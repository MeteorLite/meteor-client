import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cs")
@Implements("PcmStreamMixerListener")
public abstract class PcmStreamMixerListener extends Node {
   @ObfuscatedName("af")
   int field300;

    @ObfuscatedName("af")
    abstract void remove2();

    @ObfuscatedName("an")
    @ObfuscatedSignature(
            descriptor = "(Lbn;)I"
    )
    abstract int update();
}
