import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bz")
@Implements("PcmStreamMixerListener")
public abstract class PcmStreamMixerListener extends Node {
   @ObfuscatedName("f")
   int field303;

    @ObfuscatedName("f")
    abstract void remove2();

    @ObfuscatedName("w")
    @ObfuscatedSignature(
            descriptor = "(Lay;)I"
    )
    abstract int update();
}
