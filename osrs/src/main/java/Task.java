import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fl")
public class Task {
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "Lfl;"
   )
   Task next;
   @ObfuscatedName("x")
   public volatile int status = 0;
   @ObfuscatedName("m")
   int type;
   @ObfuscatedName("q")
   public int intArgument;
   @ObfuscatedName("f")
   Object objectArgument;
   @ObfuscatedName("r")
   public volatile Object result;
}
