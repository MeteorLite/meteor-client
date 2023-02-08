import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jx")
public class class284 {
   @ObfuscatedName("z")
   public static int field2683;

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      descriptor = "(ILln;IIIZI)V",
      garbageValue = "2064487710"
   )
   public static void method1542(int var0, AbstractArchive var1, int var2, int var3, int var4, boolean var5) {
      class290.musicPlayerStatus = 1;
      class6.musicTrackArchive = var1;
      class20.musicTrackGroupId = var2;
      class161.musicTrackFileId = var3;
      class290.musicTrackVolume = var4;
      class423.musicTrackBoolean = var5;
      class203.pcmSampleLength = var0;
   }
}
