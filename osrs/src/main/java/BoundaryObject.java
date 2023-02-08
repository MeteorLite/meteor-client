import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hg")
@Implements("BoundaryObject")
public final class BoundaryObject {
   @ObfuscatedName("an")
   static String field2196;
    @ObfuscatedName("f")
    int z;
    @ObfuscatedName("w")
    int x;
    @ObfuscatedName("v")
    int y;
    @ObfuscatedName("s")
    int orientationA;
    @ObfuscatedName("z")
    int orientationB;
    @ObfuscatedName("j")
    @ObfuscatedSignature(
            descriptor = "Lhd;"
    )
    public Renderable renderable1;
    @ObfuscatedName("i")
    @ObfuscatedSignature(
            descriptor = "Lhd;"
    )
    public Renderable renderable2;
    @ObfuscatedName("n")
    public long tag = 0L;
    @ObfuscatedName("l")
    int flags = 0;

   @ObfuscatedName("gs")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "-1120121316"
   )
   static final void method1300() {
      class275.method1525(WorldMapRegion.field2281, PacketWriter.field1136, WorldMapDecoration.field2367);
      FloorOverlayDefinition.method1048(class135.field1289, class16.field56);
      if (ClanSettings.cameraX == WorldMapRegion.field2281 && UserComparator10.cameraY == PacketWriter.field1136 && WorldMapDecoration.field2367 == class366.cameraZ && class135.field1289 == class103.cameraPitch && class16.field56 == class285.cameraYaw) {
         Client.field631 = false;
         Client.isCameraLocked = false;
         WorldMapData_0.cameraLookAtX = 0;
         Players.cameraLookAtY = 0;
         FloorOverlayDefinition.cameraLookAtHeight = 0;
         Message.cameraLookAtSpeed = 0;
         AttackOption.cameraLookAtAcceleration = 0;
         UserComparator7.cameraMoveToAcceleration = 0;
         ModeWhere.cameraMoveToSpeed = 0;
         Occluder.cameraMoveToX = 0;
         class108.cameraMoveToY = 0;
         class10.cameraMoveToHeight = 0;
      }

   }
}
