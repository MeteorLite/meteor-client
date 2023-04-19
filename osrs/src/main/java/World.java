import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cl")
@Implements("World")
public class World {
   @ObfuscatedName("vt")
   @ObfuscatedSignature(
      descriptor = "Lcg;"
   )
   @Export("friendSystem")
   public static FriendSystem friendSystem;
   @ObfuscatedName("ab")
   @Export("World_count")
   static int World_count = 0;
   @ObfuscatedName("aq")
   @Export("World_listCount")
   static int World_listCount = 0;
   @ObfuscatedName("al")
   @Export("World_sortOption2")
   static int[] World_sortOption2 = new int[]{1, 1, 1, 1};
   @ObfuscatedName("at")
   @Export("World_sortOption1")
   static int[] World_sortOption1 = new int[]{0, 1, 2, 3};
   @ObfuscatedName("dt")
   @ObfuscatedSignature(
      descriptor = "[Ltc;"
   )
   @Export("worldSelectStars")
   static IndexedSprite[] worldSelectStars;
   @ObfuscatedName("ay")
   @Export("id")
   int id;
   @ObfuscatedName("ao")
   @Export("properties")
   int properties;
   @ObfuscatedName("ax")
   @Export("population")
   int population;
   @ObfuscatedName("ai")
   @Export("host")
   String host;
   @ObfuscatedName("ag")
   @Export("activity")
   String activity;
   @ObfuscatedName("ah")
   @Export("location")
   int location;
   @ObfuscatedName("av")
   @Export("index")
   int index;

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      descriptor = "(I)Z",
      garbageValue = "1029039210"
   )
   @Export("isMembersOnly")
   boolean isMembersOnly() {
      return (1 & this.properties) != 0;
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      descriptor = "(I)Z",
      garbageValue = "-1583670467"
   )
   @Export("isDeadman")
   boolean isDeadman() {
      return (65536 & this.properties) != 0;
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      descriptor = "(I)Z",
      garbageValue = "671253830"
   )
   boolean method408() {
      return (2 & this.properties) != 0;
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      descriptor = "(I)Z",
      garbageValue = "1502648578"
   )
   @Export("isPvp")
   boolean isPvp() {
      return (4 & this.properties) != 0;
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      descriptor = "(B)Z",
      garbageValue = "105"
   )
   boolean method402() {
      return (8 & this.properties) != 0;
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      descriptor = "(B)Z",
      garbageValue = "62"
   )
   boolean method407() {
      return (536870912 & this.properties) != 0;
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      descriptor = "(I)Z",
      garbageValue = "578362576"
   )
   @Export("isBeta")
   boolean isBeta() {
      return (33554432 & this.properties) != 0;
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      descriptor = "(B)Z",
      garbageValue = "99"
   )
   boolean method404() {
      return (1073741824 & this.properties) != 0;
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      descriptor = "(I)Z",
      garbageValue = "-459773999"
   )
   boolean method405() {
      return (256 & this.properties) != 0;
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      descriptor = "(B)Z",
      garbageValue = "116"
   )
   boolean method406() {
      return (134217728 & this.properties) != 0;
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      descriptor = "(Lnm;S)V",
      garbageValue = "941"
   )
   public static void method409(AbstractArchive var0) {
      FloorUnderlayDefinition.FloorUnderlayDefinition_archive = var0;
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "(IB)I",
      garbageValue = "127"
   )
   @Export("Messages_getHistorySize")
   static int Messages_getHistorySize(int var0) {
      ChatChannel var1 = (ChatChannel)Messages.Messages_channels.get(var0);
      return var1 == null ? 0 : var1.size();
   }
}
