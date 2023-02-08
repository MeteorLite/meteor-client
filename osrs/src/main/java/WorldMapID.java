import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ie")
@Implements("WorldMapID")
public class WorldMapID {
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "Lie;"
   )
   static final WorldMapID field2380 = new WorldMapID(0);
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      descriptor = "Lie;"
   )
   static final WorldMapID field2381 = new WorldMapID(1);
    @ObfuscatedName("v")
    final int value;

   WorldMapID(int var1) {
      this.value = var1;
   }

   @ObfuscatedName("ic")
   @ObfuscatedSignature(
      descriptor = "(Lcf;I)V",
      garbageValue = "1547422490"
   )
   static void method1457(NPC var0) {
      var0.field939 = var0.definition.size;
      var0.field1004 = var0.definition.rotation;
      var0.walkSequence = var0.definition.walkSequence;
      var0.walkBackSequence = var0.definition.walkBackSequence;
      var0.walkLeftSequence = var0.definition.walkLeftSequence;
      var0.walkRightSequence = var0.definition.walkRightSequence;
      var0.idleSequence = var0.definition.idleSequence;
      var0.turnLeftSequence = var0.definition.turnLeftSequence;
      var0.turnRightSequence = var0.definition.turnRightSequence;
      var0.runSequence = var0.definition.runSequence;
      var0.runBackSequence = var0.definition.runBackSequence;
      var0.runLeftSequence = var0.definition.runLeftSequence;
      var0.runRightSequence = var0.definition.runRightSequence;
      var0.crawlSequence = var0.definition.crawlSequence;
      var0.crawlBackSequence = var0.definition.crawlBackSequence;
      var0.crawlLeftSequence = var0.definition.crawlLeftSequence;
      var0.crawlRightSequence = var0.definition.crawlRightSequence;
   }
}
