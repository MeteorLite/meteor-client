import java.security.SecureRandom;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bb")
@Implements("SecureRandomFuture")
public class SecureRandomFuture {
   @ObfuscatedName("bp")
   @ObfuscatedSignature(
      descriptor = "Lqi;"
   )
   static LoginType loginType;
   @ObfuscatedName("h")
   ExecutorService executor = Executors.newSingleThreadExecutor();
   @ObfuscatedName("e")
   Future future;

   SecureRandomFuture() {
      this.future = this.executor.submit(new SecureRandomCallable());
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "120"
   )
   void shutdown() {
      this.executor.shutdown();
      this.executor = null;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "(I)Z",
      garbageValue = "-1647109690"
   )
   boolean isDone() {
      return this.future.isDone();
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "(I)Ljava/security/SecureRandom;",
      garbageValue = "1657619269"
   )
   SecureRandom get() {
      try {
         return (SecureRandom)this.future.get();
      } catch (Exception var4) {
         SecureRandom var3 = new SecureRandom();
         var3.nextInt();
         return var3;
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "([FIFI)F",
      garbageValue = "-1005552085"
   )
   static float method446(float[] var0, int var1, float var2) {
      float var3 = var0[var1];

      for(int var4 = var1 - 1; var4 >= 0; --var4) {
         var3 = var0[var4] + var3 * var2;
      }

      return var3;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "(ILbm;ZI)I",
      garbageValue = "-2142160663"
   )
   static int method445(int var0, Script var1, boolean var2) {
      if (var0 < 1000) {
         return UserComparator8.method662(var0, var1, var2);
      } else if (var0 < 1100) {
         return WorldMapData_1.method1402(var0, var1, var2);
      } else if (var0 < 1200) {
         return NPC.method573(var0, var1, var2);
      } else if (var0 < 1300) {
         return GrandExchangeOfferOwnWorldComparator.method351(var0, var1, var2);
      } else if (var0 < 1400) {
         return class32.method130(var0, var1, var2);
      } else if (var0 < 1500) {
         return MusicPatchNode.method1604(var0, var1, var2);
      } else if (var0 < 1600) {
         return class71.method431(var0, var1, var2);
      } else if (var0 < 1700) {
         return class343.method1854(var0, var1, var2);
      } else if (var0 < 1800) {
         return MusicPatchPcmStream.method1593(var0, var1, var2);
      } else if (var0 < 1900) {
         return WorldMapArea.method1349(var0, var1, var2);
      } else if (var0 < 2000) {
         return class365.method1912(var0, var1, var2);
      } else if (var0 < 2100) {
         return WorldMapData_1.method1402(var0, var1, var2);
      } else if (var0 < 2200) {
         return NPC.method573(var0, var1, var2);
      } else if (var0 < 2300) {
         return GrandExchangeOfferOwnWorldComparator.method351(var0, var1, var2);
      } else if (var0 < 2400) {
         return class32.method130(var0, var1, var2);
      } else if (var0 < 2500) {
         return MusicPatchNode.method1604(var0, var1, var2);
      } else if (var0 < 2600) {
         return class14.method51(var0, var1, var2);
      } else if (var0 < 2700) {
         return class7.method19(var0, var1, var2);
      } else if (var0 < 2800) {
         return MouseRecorder.method476(var0, var1, var2);
      } else if (var0 < 2900) {
         return WorldMapSection2.method1327(var0, var1, var2);
      } else if (var0 < 3000) {
         return class365.method1912(var0, var1, var2);
      } else if (var0 < 3200) {
         return class413.method2154(var0, var1, var2);
      } else if (var0 < 3300) {
         return Client.method382(var0, var1, var2);
      } else if (var0 < 3400) {
         return GrandExchangeOfferUnitPriceComparator.method1846(var0, var1, var2);
      } else if (var0 < 3500) {
         return SoundCache.method244(var0, var1, var2);
      } else if (var0 < 3600) {
         return FileSystem.method878(var0, var1, var2);
      } else if (var0 < 3700) {
         return WorldMapCacheName.method1468(var0, var1, var2);
      } else if (var0 < 3800) {
         return class20.method71(var0, var1, var2);
      } else if (var0 < 3900) {
         return SceneTilePaint.method1285(var0, var1, var2);
      } else if (var0 < 4000) {
         return class358.method1909(var0, var1, var2);
      } else if (var0 < 4100) {
         return ParamComposition.method991(var0, var1, var2);
      } else if (var0 < 4200) {
         return NPCComposition.method967(var0, var1, var2);
      } else if (var0 < 4300) {
         return class20.method73(var0, var1, var2);
      } else if (var0 < 5100) {
         return class144.method770(var0, var1, var2);
      } else if (var0 < 5400) {
         return class282.method1534(var0, var1, var2);
      } else if (var0 < 5600) {
         return class82.method469(var0, var1, var2);
      } else if (var0 < 5700) {
         return WallDecoration.method1294(var0, var1, var2);
      } else if (var0 < 6300) {
         return class10.method39(var0, var1, var2);
      } else if (var0 < 6600) {
         return class141.method755(var0, var1, var2);
      } else if (var0 < 6700) {
         return class126.method710(var0, var1, var2);
      } else if (var0 < 6800) {
         return KeyHandler.method98(var0, var1, var2);
      } else if (var0 < 6900) {
         return Message.method345(var0, var1, var2);
      } else if (var0 < 7000) {
         return class300.method1617(var0, var1, var2);
      } else if (var0 < 7100) {
         return class168.method880(var0, var1, var2);
      } else if (var0 < 7200) {
         return Player.method506(var0, var1, var2);
      } else if (var0 < 7300) {
         return class199.method1071(var0, var1, var2);
      } else if (var0 < 7500) {
         return WorldMapLabelSize.method1306(var0, var1, var2);
      } else if (var0 < 7600) {
         return class417.method2167(var0, var1, var2);
      } else {
         return var0 < 7700 ? HealthBarUpdate.method520(var0, var1, var2) : 2;
      }
   }

   @ObfuscatedName("ie")
   @ObfuscatedSignature(
      descriptor = "(B)I",
      garbageValue = "37"
   )
   static final int method444() {
      if (StructComposition.clientPreferences.method535()) {
         return class383.Client_plane;
      } else {
         int var0 = SpotAnimationDefinition.getTileHeight(class145.cameraX, ClanChannel.cameraZ, class383.Client_plane);
         return var0 - class414.cameraY < 800 && (Tiles.Tiles_renderFlags[class383.Client_plane][class145.cameraX >> 7][ClanChannel.cameraZ >> 7] & 4) != 0 ? class383.Client_plane : 3;
      }
   }
}
