import java.util.HashMap;
import java.util.Map;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eo")
@Implements("Messages")
public class Messages {
    @ObfuscatedName("af")
    static final Map Messages_channels = new HashMap();
    @ObfuscatedName("an")
    @ObfuscatedSignature(
            descriptor = "Lro;"
    )
    static final IterableNodeHashTable Messages_hashTable = new IterableNodeHashTable(1024);
    @ObfuscatedName("aw")
    @ObfuscatedSignature(
            descriptor = "Lox;"
    )
    static final IterableDualNodeQueue Messages_queue = new IterableDualNodeQueue();
    @ObfuscatedName("ac")
    static int Messages_count = 0;
    @ObfuscatedName("cp")
    static String otp;

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      descriptor = "(I)[Lex;",
      garbageValue = "-1633313603"
   )
   static class123[] method655() {
      return new class123[]{class123.field1207, class123.field1200, class123.field1202, class123.field1203, class123.field1204};
   }

   @ObfuscatedName("kc")
   @ObfuscatedSignature(
      descriptor = "(Ldg;I)V",
      garbageValue = "-1336825850"
   )
   static final void method656(PendingSpawn var0) {
      long var1 = 0L;
      int var3 = -1;
      int var4 = 0;
      int var5 = 0;
      if (var0.type == 0) {
         var1 = class31.scene.getBoundaryObjectTag(var0.plane, var0.x, var0.y);
      }

      if (var0.type == 1) {
         var1 = class31.scene.getWallDecorationTag(var0.plane, var0.x, var0.y);
      }

      if (var0.type == 2) {
         var1 = class31.scene.getGameObjectTag(var0.plane, var0.x, var0.y);
      }

      if (var0.type == 3) {
         var1 = class31.scene.getFloorDecorationTag(var0.plane, var0.x, var0.y);
      }

      if (var1 != 0L) {
         int var6 = class31.scene.getObjectFlags(var0.plane, var0.x, var0.y, var1);
         var3 = InterfaceParent.Entity_unpackID(var1);
         var4 = var6 & 31;
         var5 = var6 >> 6 & 3;
      }

      var0.objectId = var3;
      var0.field922 = var4;
      var0.field927 = var5;
   }
}
