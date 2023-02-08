import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fc")
public abstract class class177 {
    @ObfuscatedName("r")
    @ObfuscatedSignature(
            descriptor = "Lfb;"
    )
    static Clock clock;
   @ObfuscatedName("s")
   String field1461;
   // $FF: synthetic field
   @ObfuscatedSignature(
           descriptor = "Lfs;"
   )
   @ObfuscatedName("this$0")
   final class166 this$0;

   @ObfuscatedSignature(
      descriptor = "(Lfs;Ljava/lang/String;)V"
   )
   class177(class166 var1, String var2) {
      this.this$0 = var1;
      this.field1461 = var2;
   }

    @ObfuscatedName("f")
    @ObfuscatedSignature(
            descriptor = "(S)I",
            garbageValue = "1024"
    )
    public abstract int vmethod3379();

    @ObfuscatedName("w")
    @ObfuscatedSignature(
            descriptor = "(I)Ljava/lang/String;",
            garbageValue = "1616244476"
    )
    public String vmethod3380() {
      return null;
   }

    @ObfuscatedName("l")
    @ObfuscatedSignature(
            descriptor = "(B)I",
            garbageValue = "64"
    )
    public int vmethod3378() {
      return -1;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      descriptor = "(B)Ljava/lang/String;",
      garbageValue = "10"
   )
   public String method903() {
      return this.field1461;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "1253975547"
   )
   public static void method905() {
      class290.midiPcmStream.clear();
      class290.musicPlayerStatus = 1;
      class6.musicTrackArchive = null;
   }
}
