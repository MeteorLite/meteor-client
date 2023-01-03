import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gs")
@Implements("MoveSpeed")
public enum MoveSpeed implements class345 {
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "Lgs;"
   )
   STATIONARY((byte)-1),
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "Lgs;"
   )
   CRAWL((byte)0),
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "Lgs;"
   )
   WALK((byte)1),
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      descriptor = "Lgs;"
   )
   RUN((byte)2);

   @ObfuscatedName("m")
   public byte speed;

   MoveSpeed(byte var3) {
      this.speed = var3;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "(B)I",
      garbageValue = "96"
   )
   public int rsOrdinal() {
      return this.speed;
   }

   @ObfuscatedName("je")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "-1945373310"
   )
   static final void method1105() {
      for(PendingSpawn var0 = (PendingSpawn)Client.pendingSpawns.last(); var0 != null; var0 = (PendingSpawn)Client.pendingSpawns.previous()) {
         if (var0.hitpoints == -1) {
            var0.delay = 0;
            UserComparator4.method659(var0);
         } else {
            var0.remove();
         }
      }

   }
}
