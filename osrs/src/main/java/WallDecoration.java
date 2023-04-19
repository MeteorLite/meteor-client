import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("je")
@Implements("WallDecoration")
public final class WallDecoration {
    @ObfuscatedName("io")
    @ObfuscatedSignature(
            descriptor = "Lon;"
    )
    static Font fontPlain12;
    @ObfuscatedName("af")
    int z;
    @ObfuscatedName("an")
    int xOffset;
    @ObfuscatedName("aw")
    int x;
    @ObfuscatedName("ac")
    int y;
    @ObfuscatedName("au")
    int orientation;
    @ObfuscatedName("ab")
    int orientation2;
    @ObfuscatedName("aq")
    int yOffset;
    @ObfuscatedName("al")
    @ObfuscatedSignature(
            descriptor = "Liv;"
    )
    public Renderable renderable1;
    @ObfuscatedName("at")
    @ObfuscatedSignature(
            descriptor = "Liv;"
    )
    public Renderable renderable2;
    @ObfuscatedName("aa")
    public long tag = 0L;
    @ObfuscatedName("ay")
    int flags = 0;

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "285951283"
   )
   static void method1385() {
      if (Login.Login_username == null || Login.Login_username.length() <= 0) {
         if (class20.clientPreferences.getUsernameToRemember() != null) {
            Login.Login_username = class20.clientPreferences.getUsernameToRemember();
            Client.Login_isUsernameRemembered = true;
         } else {
            Client.Login_isUsernameRemembered = false;
         }

      }
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "([BIIII[Lif;I)V",
      garbageValue = "960745047"
   )
   static final void method1384(byte[] var0, int var1, int var2, int var3, int var4, CollisionMap[] var5) {
      int var7;
      int var8;
      for(int var6 = 0; var6 < 4; ++var6) {
         for(var7 = 0; var7 < 64; ++var7) {
            for(var8 = 0; var8 < 64; ++var8) {
               if (var7 + var1 > 0 && var7 + var1 < 103 && var8 + var2 > 0 && var8 + var2 < 103) {
                  var5[var6].flags[var7 + var1][var2 + var8] &= -16777217;
               }
            }
         }
      }

      Buffer var12 = new Buffer(var0);

      for(var7 = 0; var7 < 4; ++var7) {
         for(var8 = 0; var8 < 64; ++var8) {
            for(int var9 = 0; var9 < 64; ++var9) {
               int var10 = var8 + var1;
               int var11 = var9 + var2;
               class372.loadTerrain(var12, var7, var10, var11, var3 + var10, var11 + var4, 0);
            }
         }
      }

   }

    @ObfuscatedName("lz")
    @ObfuscatedSignature(
            descriptor = "([Lmq;Lmq;ZB)V",
            garbageValue = "44"
    )
    static void revalidateWidgetScroll(Widget[] var0, Widget var1, boolean var2) {
      int var3 = var1.scrollWidth != 0 ? var1.scrollWidth * -1469650905 * -773060713 : var1.width * -794961409 * 1774069247;
      int var4 = var1.scrollHeight != 0 ? var1.scrollHeight * -1357451643 * -1273374131 : var1.height * 1473950221 * 60157125;
      class135.resizeInterface(var0, var1.id, var3, var4, var2);
      if (var1.children != null) {
         class135.resizeInterface(var1.children, var1.id, var3, var4, var2);
      }

      InterfaceParent var5 = (InterfaceParent)Client.interfaceParents.get((long)var1.id);
      if (var5 != null) {
         SequenceDefinition.method1129(var5.group, var3, var4, var2);
      }

      if (var1.contentType == 1337) {
         ;
      }

   }
}
