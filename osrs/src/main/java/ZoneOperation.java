import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.Iterator;

import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jn")
public class ZoneOperation {
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "Ljn;"
   )
   public static final ZoneOperation field2553 = new ZoneOperation(4);
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "Ljn;"
   )
   public static final ZoneOperation field2542 = new ZoneOperation(5);
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "Ljn;"
   )
   public static final ZoneOperation field2543 = new ZoneOperation(6);
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      descriptor = "Ljn;"
   )
   public static final ZoneOperation field2554 = new ZoneOperation(15);
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      descriptor = "Ljn;"
   )
   public static final ZoneOperation field2545 = new ZoneOperation(4);
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      descriptor = "Ljn;"
   )
   public static final ZoneOperation field2549 = new ZoneOperation(2);
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "Ljn;"
   )
   public static final ZoneOperation field2551 = new ZoneOperation(7);
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      descriptor = "Ljn;"
   )
   public static final ZoneOperation field2547 = new ZoneOperation(16);
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      descriptor = "Ljn;"
   )
   public static final ZoneOperation field2548 = new ZoneOperation(8);
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      descriptor = "Ljn;"
   )
   public static final ZoneOperation field2541 = new ZoneOperation(5);
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      descriptor = "Ljn;"
   )
   public static final ZoneOperation field2550 = new ZoneOperation(14);
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      descriptor = "Ljn;"
   )
   public static final ZoneOperation field2544 = new ZoneOperation(5);
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      descriptor = "Ljn;"
   )
   public static final ZoneOperation field2552 = new ZoneOperation(7);
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      descriptor = "Ljn;"
   )
   public static final ZoneOperation field2546 = new ZoneOperation(14);

   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "4"
   )
   ZoneOperation(int var1) {
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "2126981871"
   )
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
         long var9 = Message.clockNow();
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
