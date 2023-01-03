import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jn")
public class class276 {
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "Ljn;"
   )
   public static final class276 field2553 = new class276(4);
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "Ljn;"
   )
   public static final class276 field2542 = new class276(5);
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "Ljn;"
   )
   public static final class276 field2543 = new class276(6);
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      descriptor = "Ljn;"
   )
   public static final class276 field2554 = new class276(15);
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      descriptor = "Ljn;"
   )
   public static final class276 field2545 = new class276(4);
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      descriptor = "Ljn;"
   )
   public static final class276 field2549 = new class276(2);
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "Ljn;"
   )
   public static final class276 field2551 = new class276(7);
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      descriptor = "Ljn;"
   )
   public static final class276 field2547 = new class276(16);
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      descriptor = "Ljn;"
   )
   public static final class276 field2548 = new class276(8);
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      descriptor = "Ljn;"
   )
   public static final class276 field2541 = new class276(5);
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      descriptor = "Ljn;"
   )
   public static final class276 field2550 = new class276(14);
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      descriptor = "Ljn;"
   )
   public static final class276 field2544 = new class276(5);
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      descriptor = "Ljn;"
   )
   public static final class276 field2552 = new class276(7);
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      descriptor = "Ljn;"
   )
   public static final class276 field2546 = new class276(14);

   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "4"
   )
   class276(int var1) {
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "2126981871"
   )
   @Export("getGcDuration")
   protected static int getGcDuration() {
      int var0 = 0;
      if (Projectile.garbageCollector == null || !Projectile.garbageCollector.isValid()) {
         try {
            Iterator var1 = ManagementFactory.getGarbageCollectorMXBeans().iterator();

            while(var1.hasNext()) {
               GarbageCollectorMXBean var2 = (GarbageCollectorMXBean)var1.next();
               if (var2.isValid()) {
                  Projectile.garbageCollector = var2;
                  GameEngine.garbageCollectorLastCheckTimeMs = -1L;
                  GameEngine.garbageCollectorLastCollectionTime = -1L;
               }
            }
         } catch (Throwable var11) {
            ;
         }
      }

      if (Projectile.garbageCollector != null) {
         long var9 = Message.method344();
         long var3 = Projectile.garbageCollector.getCollectionTime();
         if (GameEngine.garbageCollectorLastCollectionTime != -1L) {
            long var5 = var3 - GameEngine.garbageCollectorLastCollectionTime;
            long var7 = var9 - GameEngine.garbageCollectorLastCheckTimeMs;
            if (0L != var7) {
               var0 = (int)(var5 * 100L / var7);
            }
         }

         GameEngine.garbageCollectorLastCollectionTime = var3;
         GameEngine.garbageCollectorLastCheckTimeMs = var9;
      }

      return var0;
   }

   @ObfuscatedName("jf")
   @ObfuscatedSignature(
      descriptor = "(Lbs;IIB)V",
      garbageValue = "-92"
   )
   static final void method1522(MenuAction var0, int var1, int var2) {
      if (var0 != null) {
         WorldMapData_0.menuAction(var0.param0, var0.param1, var0.opcode, var0.identifier, var0.itemId, var0.action, var0.target, var1, var2);
      }

   }
}
