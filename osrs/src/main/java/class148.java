import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ec")
public class class148 extends class139 {
   @ObfuscatedName("z")
   static int field1332;
   @ObfuscatedName("eb")
   @ObfuscatedSignature(
      descriptor = "Llm;"
   )
   static Archive field1333;
    @ObfuscatedName("nl")
    @ObfuscatedSignature(
            descriptor = "Lbs;"
    )
    static MenuAction tempMenuAction;
   @ObfuscatedName("f")
   String field1334;
   // $FF: synthetic field
   @ObfuscatedSignature(
      descriptor = "Lex;"
   )
   final class142 this$0;

   @ObfuscatedSignature(
      descriptor = "(Lex;)V"
   )
   class148(class142 var1) {
      this.this$0 = var1;
   }

    @ObfuscatedName("f")
    @ObfuscatedSignature(
            descriptor = "(Lrd;S)V",
            garbageValue = "-5782"
    )
    void vmethod3254(Buffer var1) {
      this.field1334 = var1.readStringCp1252NullTerminated();
      var1.readInt();
   }

    @ObfuscatedName("w")
    @ObfuscatedSignature(
            descriptor = "(Leb;B)V",
            garbageValue = "-26"
    )
    void vmethod3248(ClanSettings var1) {
      var1.name = this.field1334;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      descriptor = "(Lln;IIIZI)V",
      garbageValue = "1410945003"
   )
   public static void method784(AbstractArchive var0, int var1, int var2, int var3, boolean var4) {
      class290.musicPlayerStatus = 1;
      class6.musicTrackArchive = var0;
      class20.musicTrackGroupId = var1;
      class161.musicTrackFileId = var2;
      class290.musicTrackVolume = var3;
      class423.musicTrackBoolean = var4;
      class203.pcmSampleLength = 10000;
   }
}
