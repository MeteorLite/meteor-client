import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kw")
public abstract class AbstractByteArrayCopier {
   @ObfuscatedName("m")
   static Thread ArchiveDiskActionHandler_thread;

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "(B)[B",
      garbageValue = "-108"
   )
   abstract byte[] get();

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      descriptor = "([BI)V",
      garbageValue = "-878200260"
   )
   public abstract void set(byte[] var1);
}
