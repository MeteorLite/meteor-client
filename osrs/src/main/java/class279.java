import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kq")
public class class279 {
   @ObfuscatedName("dr")
   @ObfuscatedSignature(
      descriptor = "[Lsp;"
   )
   @Export("worldSelectFlagSprites")
   static IndexedSprite[] worldSelectFlagSprites;

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "(Lsy;I)Ljava/lang/String;",
      garbageValue = "1523365304"
   )
   @Export("readString")
   public static String readString(Buffer var0) {
      return GrandExchangeEvents.method1854(var0, 32767);
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      descriptor = "(Lne;Ljava/lang/String;Ljava/lang/String;B)[Lsn;",
      garbageValue = "7"
   )
   public static SpritePixels[] method1541(AbstractArchive var0, String var1, String var2) {
      int var3 = var0.getGroupId(var1);
      int var4 = var0.getFileId(var3, var2);
      return class70.method416(var0, var3, var4);
   }

   @ObfuscatedName("ap")
   @Export("Entity_unpackID")
   public static int Entity_unpackID(long var0) {
      return (int)(var0 >>> 17 & 4294967295L);
   }

   @ObfuscatedName("mr")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "50"
   )
   static final void method1540() {
      Client.field555 = Client.cycleCntr;
      ObjTypeCustomisation.field1453 = true;
   }
}
