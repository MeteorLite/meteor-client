import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dt")
public enum class86 implements class356 {
   @ObfuscatedName("af")
   @ObfuscatedSignature(
      descriptor = "Ldt;"
   )
   field886(0, -1),
   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "Ldt;"
   )
   field880(1, 2),
   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      descriptor = "Ldt;"
   )
   field881(2, 3),
   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "Ldt;"
   )
   field882(3, 4),
   @ObfuscatedName("au")
   @ObfuscatedSignature(
      descriptor = "Ldt;"
   )
   field883(4, 5),
   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "Ldt;"
   )
   field884(5, 6);

   @ObfuscatedName("uf")
   static int field888;
   @ObfuscatedName("at")
   static int[] field879;
   @ObfuscatedName("aq")
   final int field887;
   @ObfuscatedName("al")
   final int field885;

   class86(int var3, int var4) {
      this.field887 = var3;
      this.field885 = var4;
   }

    @ObfuscatedName("af")
    @ObfuscatedSignature(
            descriptor = "(I)I",
            garbageValue = "741942848"
    )
    public int rsOrdinal() {
      return this.field885;
   }

   @ObfuscatedName("mo")
   @ObfuscatedSignature(
      descriptor = "(IB)V",
      garbageValue = "-62"
   )
   static final void method502(int var0) {
      var0 = Math.min(Math.max(var0, 0), 255);
      if (var0 != class20.clientPreferences.getCurrentMusicVolume()) {
         if (class20.clientPreferences.getCurrentMusicVolume() == 0 && Client.currentTrackGroupId != -1) {
            Message.method355(class399.archive6, Client.currentTrackGroupId, 0, var0, false);
            Client.playingJingle = false;
         } else if (var0 == 0) {
            FloorUnderlayDefinition.method1050();
            Client.playingJingle = false;
         } else {
            class220.method1232(var0);
         }

         class20.clientPreferences.setCurrentMusicVolume(var0);
      }

   }
}
