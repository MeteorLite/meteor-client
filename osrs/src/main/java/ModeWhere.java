import java.util.HashSet;
import java.util.Set;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("nm")
@Implements("ModeWhere")
public enum ModeWhere implements class352 {
   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "Lnm;"
   )
   field3514("", 0, new class351[]{class351.field3493}),
   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "Lnm;"
   )
   field3510("", 1, new class351[]{class351.field3492, class351.field3493}),
   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "Lnm;"
   )
   field3509("", 2, new class351[]{class351.field3492, class351.field3494, class351.field3493}),
   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "Lnm;"
   )
   field3521("", 3, new class351[]{class351.field3492}),
   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "Lnm;"
   )
   field3513("", 4),
   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      descriptor = "Lnm;"
   )
   field3511("", 5, new class351[]{class351.field3492, class351.field3493}),
   @ObfuscatedName("av")
   @ObfuscatedSignature(
      descriptor = "Lnm;"
   )
   field3515("", 6, new class351[]{class351.field3493}),
   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      descriptor = "Lnm;"
   )
   field3520("", 8, new class351[]{class351.field3492, class351.field3493}),
   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      descriptor = "Lnm;"
   )
   field3517("", 9, new class351[]{class351.field3492, class351.field3494}),
   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      descriptor = "Lnm;"
   )
   field3518("", 10, new class351[]{class351.field3492}),
   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      descriptor = "Lnm;"
   )
   field3519("", 11, new class351[]{class351.field3492}),
   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      descriptor = "Lnm;"
   )
   field3522("", 12, new class351[]{class351.field3492, class351.field3493}),
   @ObfuscatedName("as")
   @ObfuscatedSignature(
      descriptor = "Lnm;"
   )
   field3516("", 13, new class351[]{class351.field3492});

   @ObfuscatedName("ay")
   @Export("id")
   final int id;
   @ObfuscatedName("am")
   final Set field3523 = new HashSet();

   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;I[Lnu;)V"
   )
   ModeWhere(String var3, int var4, class351[] var5) {
      this.id = var4;
      class351[] var6 = var5;

      for(int var7 = 0; var7 < var6.length; ++var7) {
         class351 var8 = var6[var7];
         this.field3523.add(var8);
      }

   }

   ModeWhere(String var3, int var4) {
      this.id = var4;
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "-1409646049"
   )
   @Export("rsOrdinal")
   public int rsOrdinal() {
      return this.id;
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "(S)I",
      garbageValue = "16024"
   )
   public static int method1900() {
      return ++MouseHandler.MouseHandler_idleCycles - 1;
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "114"
   )
   static void method1899() {
      if (Login.clearLoginScreen) {
         WorldMapSprite.titleboxSprite = null;
         Login.titlebuttonSprite = null;
         Login.runesSprite = null;
         Login.leftTitleSprite = null;
         class419.rightTitleSprite = null;
         Login.logoSprite = null;
         class139.title_muteSprite = null;
         Login.options_buttons_0Sprite = null;
         Login.options_buttons_2Sprite = null;
         WorldMapSection2.worldSelectBackSprites = null;
         class279.worldSelectFlagSprites = null;
         class353.worldSelectArrows = null;
         class293.worldSelectStars = null;
         FriendSystem.field664 = null;
         ArchiveDiskActionHandler.field3410.method520();
         class293.musicPlayerStatus = 1;
         class364.musicTrackArchive = null;
         IntHashTable.musicTrackGroupId = -1;
         class293.musicTrackFileId = -1;
         class368.musicTrackVolume = 0;
         class293.musicTrackBoolean = false;
         AbstractRasterProvider.pcmSampleLength = 2;
         class166.method865(true);
         Login.clearLoginScreen = false;
      }
   }
}
