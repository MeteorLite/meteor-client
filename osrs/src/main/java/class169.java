import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fh")
public class class169 {
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      descriptor = "Lqy;"
   )
   static Buffer field1440;
   @ObfuscatedName("x")
   public String field1435;
   @ObfuscatedName("m")
   public float[] field1436;
   @ObfuscatedName("q")
   public int field1438;
   @ObfuscatedName("f")
   public int field1439;
   @ObfuscatedName("r")
   public int field1437;
   // $FF: synthetic field
   @ObfuscatedSignature(
      descriptor = "Lfk;"
   )
   @ObfuscatedName("this$0")
   final class163 this$0;

   @ObfuscatedSignature(
      descriptor = "(Lfk;)V"
   )
   class169(class163 var1) {
      this.this$0 = var1;
      this.field1436 = new float[4];
      this.field1438 = 1;
      this.field1439 = 1;
      this.field1437 = 0;
   }

   @ObfuscatedName("hx")
   @ObfuscatedSignature(
      descriptor = "(IB)V",
      garbageValue = "0"
   )
   static void playSong(int var0) {
      if (var0 == -1 && !Client.playingJingle) {
         class6.method14();
      } else if (var0 != -1 && var0 != Client.currentTrackGroupId && StructComposition.clientPreferences.getCurrentMusicVolume() != 0 && !Client.playingJingle) {
         Archive var1 = class162.archive6;
         int var2 = StructComposition.clientPreferences.getCurrentMusicVolume();
         class286.musicPlayerStatus = 1;
         class304.musicTrackArchive = var1;
         class109.musicTrackGroupId = var0;
         class286.musicTrackFileId = 0;
         class467.musicTrackVolume = var2;
         class145.musicTrackBoolean = false;
         class286.pcmSampleLength = 2;
      }

      Client.currentTrackGroupId = var0;
   }

   @ObfuscatedName("ku")
   @ObfuscatedSignature(
      descriptor = "([Lkd;Lkd;ZI)V",
      garbageValue = "2119865006"
   )
   static void revalidateWidgetScroll(Widget[] var0, Widget var1, boolean var2) {
      int var3 = var1.scrollWidth != 0 ? var1.scrollWidth * 666858271 * -1494857505 : var1.width * 1832001725 * -170206571;
      int var4 = var1.scrollHeight != 0 ? var1.scrollHeight * -319102043 * -969061331 : var1.height * 882604251 * 1399571283;
      ItemContainer.resizeInterface(var0, var1.id, var3, var4, var2);
      if (var1.children != null) {
         ItemContainer.resizeInterface(var1.children, var1.id, var3, var4, var2);
      }

      InterfaceParent var5 = (InterfaceParent)Client.interfaceParents.get((long)var1.id);
      if (var5 != null) {
         ByteArrayPool.method1996(var5.group, var3, var4, var2);
      }

      if (var1.contentType == 1337) {
         ;
      }

   }

   @ObfuscatedName("me")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "66"
   )
   static final void method883() {
      for(int var0 = 0; var0 < Players.Players_count; ++var0) {
         Player var1 = Client.players[Players.Players_indices[var0]];
         var1.clearIsInFriendsChat();
      }

   }
}
