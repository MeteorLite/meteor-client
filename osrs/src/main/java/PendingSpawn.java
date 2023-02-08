import java.io.File;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ct")
@Implements("PendingSpawn")
public final class PendingSpawn extends Node {
    @ObfuscatedName("em")
    @ObfuscatedSignature(
            descriptor = "Llm;"
    )
    static Archive archive13;
    @ObfuscatedName("f")
    int plane;
    @ObfuscatedName("w")
    int type;
    @ObfuscatedName("v")
    int x;
    @ObfuscatedName("s")
    int y;
    @ObfuscatedName("z")
    int objectId;
   @ObfuscatedName("j")
   int field926;
   @ObfuscatedName("i")
   int field927;
    @ObfuscatedName("n")
    int id;
    @ObfuscatedName("l")
    int rotation;
    @ObfuscatedName("k")
    int objectType;
   @ObfuscatedName("r")
   int field931 = 31;
    @ObfuscatedName("b")
    int startCycle = 0;
    @ObfuscatedName("m")
    int endCycle = -1;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "(II)V",
      garbageValue = "178165513"
   )
   void method496(int var1) {
      this.field931 = var1;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      descriptor = "(II)Z",
      garbageValue = "-211927889"
   )
   boolean method497(int var1) {
      if (var1 >= 0 && var1 <= 4) {
         return (this.field931 & 1 << var1) != 0;
      } else {
         return true;
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "(Ljava/io/File;B)V",
      garbageValue = "1"
   )
   public static void method499(File var0) {
      FileSystem.FileSystem_cacheDir = var0;
      if (!FileSystem.FileSystem_cacheDir.exists()) {
         throw new RuntimeException("");
      } else {
         FileSystem.FileSystem_hasPermissions = true;
      }
   }

    @ObfuscatedName("gr")
    @ObfuscatedSignature(
            descriptor = "(Lcl;IIB)V",
            garbageValue = "-1"
    )
    static void performPlayerAnimation(Player var0, int var1, int var2) {
      if (var0.sequence == var1 && var1 != -1) {
         int var3 = class85.SequenceDefinition_get(var1).replyMode;
         if (var3 == 1) {
            var0.sequenceFrame = 0;
            var0.sequenceFrameCycle = 0;
            var0.sequenceDelay = var2;
            var0.currentSequenceFrameIndex = 0;
         }

         if (var3 == 2) {
            var0.currentSequenceFrameIndex = 0;
         }
      } else if (var1 == -1 || var0.sequence == -1 || class85.SequenceDefinition_get(var1).forcedPriority >= class85.SequenceDefinition_get(var0.sequence).forcedPriority) {
         var0.sequence = var1;
         var0.sequenceFrame = 0;
         var0.sequenceFrameCycle = 0;
         var0.sequenceDelay = var2;
         var0.currentSequenceFrameIndex = 0;
         var0.field1006 = var0.pathLength;
      }

   }
}
