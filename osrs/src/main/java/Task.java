import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gp")
@Implements("Task")
public class Task {
    @ObfuscatedName("af")
    @ObfuscatedSignature(
            descriptor = "Lgp;"
    )
    Task next;
    @ObfuscatedName("ac")
    public volatile int status = 0;
    @ObfuscatedName("au")
    int type;
    @ObfuscatedName("ab")
    public int intArgument;
    @ObfuscatedName("aq")
    Object objectArgument;
    @ObfuscatedName("al")
    public volatile Object result;
}
