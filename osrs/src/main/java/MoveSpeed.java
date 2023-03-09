import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("is")
@Implements("MoveSpeed")
public enum MoveSpeed implements class352 {
   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "Lis;"
   )
   @Export("STATIONARY")
   STATIONARY((byte)-1),
   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "Lis;"
   )
   @Export("CRAWL")
   CRAWL((byte)0),
   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "Lis;"
   )
   @Export("WALK")
   WALK((byte)1),
   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "Lis;"
   )
   @Export("RUN")
   RUN((byte)2);

   @ObfuscatedName("bv")
   @ObfuscatedSignature(
      descriptor = "Lne;"
   )
   static AbstractArchive field1844;
   @ObfuscatedName("hn")
   static String field1841;
   @ObfuscatedName("an")
   @Export("speed")
   public byte speed;

   MoveSpeed(byte var3) {
      this.speed = var3;
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "-1409646049"
   )
   @Export("rsOrdinal")
   public int rsOrdinal() {
      return this.speed;
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "(I)[Lmn;",
      garbageValue = "2085906620"
   )
   @Export("PlayerType_values")
   public static PlayerType[] PlayerType_values() {
      return new PlayerType[]{PlayerType.field3391, PlayerType.field3389, PlayerType.field3387, PlayerType.PlayerType_playerModerator, PlayerType.field3392, PlayerType.PlayerType_ultimateIronman, PlayerType.field3380, PlayerType.PlayerType_ironman, PlayerType.field3395, PlayerType.PlayerType_normal, PlayerType.field3394, PlayerType.field3393, PlayerType.PlayerType_hardcoreIronman, PlayerType.field3388, PlayerType.PlayerType_jagexModerator, PlayerType.field3397, PlayerType.field3390};
   }

   @ObfuscatedName("an")
   public static int method1114(long var0) {
      return (int)(var0 >>> 7 & 127L);
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      descriptor = "(IB)I",
      garbageValue = "45"
   )
   public static int method1115(int var0) {
      if (var0 > 0) {
         return 1;
      } else {
         return var0 < 0 ? -1 : 0;
      }
   }

   @ObfuscatedName("mu")
   @ObfuscatedSignature(
      descriptor = "(II)V",
      garbageValue = "-1285650077"
   )
   static void method1113(int var0) {
      for(IntegerNode var1 = (IntegerNode)Client.widgetFlags.first(); var1 != null; var1 = (IntegerNode)Client.widgetFlags.next()) {
         if ((long)var0 == (var1.key >> 48 & 65535L)) {
            var1.remove();
         }
      }

   }
}
