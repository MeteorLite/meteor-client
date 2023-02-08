import java.util.HashSet;
import java.util.Set;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("mm")
@Implements("ModeWhere")
public enum ModeWhere implements class349 {
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "Lmm;"
   )
   field3544("", 0, new class348[]{class348.field3521}),
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      descriptor = "Lmm;"
   )
   field3536("", 1, new class348[]{class348.field3522, class348.field3521}),
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "Lmm;"
   )
   field3537("", 2, new class348[]{class348.field3522, class348.field3523, class348.field3521}),
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      descriptor = "Lmm;"
   )
   field3538("", 3, new class348[]{class348.field3522}),
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      descriptor = "Lmm;"
   )
   field3551("", 4),
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      descriptor = "Lmm;"
   )
   field3548("", 5, new class348[]{class348.field3522, class348.field3521}),
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      descriptor = "Lmm;"
   )
   field3539("", 6, new class348[]{class348.field3521}),
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      descriptor = "Lmm;"
   )
   field3542("", 8, new class348[]{class348.field3522, class348.field3521}),
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      descriptor = "Lmm;"
   )
   field3543("", 9, new class348[]{class348.field3522, class348.field3523}),
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      descriptor = "Lmm;"
   )
   field3535("", 10, new class348[]{class348.field3522}),
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      descriptor = "Lmm;"
   )
   field3547("", 11, new class348[]{class348.field3522}),
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      descriptor = "Lmm;"
   )
   field3546("", 12, new class348[]{class348.field3522, class348.field3521}),
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      descriptor = "Lmm;"
   )
   field3540("", 13, new class348[]{class348.field3522});

    @ObfuscatedName("tk")
    static int cameraMoveToSpeed;
    @ObfuscatedName("nf")
    static int menuY;
    @ObfuscatedName("m")
    final int id;
   @ObfuscatedName("t")
   final Set field3549 = new HashSet();

   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;I[Lmd;)V"
   )
   ModeWhere(String var3, int var4, class348[] var5) {
      this.id = var4;
      class348[] var6 = var5;

      for(int var7 = 0; var7 < var6.length; ++var7) {
         class348 var8 = var6[var7];
         this.field3549.add(var8);
      }

   }

   ModeWhere(String var3, int var4) {
      this.id = var4;
   }

    @ObfuscatedName("f")
    @ObfuscatedSignature(
            descriptor = "(B)I",
            garbageValue = "3"
    )
    public int rsOrdinal() {
      return this.id;
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "(ILkz;IIIII[FI)Lkz;",
      garbageValue = "2073812484"
   )
   static Widget method1883(int var0, Widget var1, int var2, int var3, int var4, int var5, int var6, float[] var7) {
      Widget var8 = new Widget();
      var8.type = var0;
      var8.parentId = var1.id;
      var8.childIndex = var2;
      var8.isIf3 = true;
      var8.xAlignment = var3;
      var8.yAlignment = var4;
      var8.widthAlignment = var5;
      var8.heightAlignment = var6;
      var8.rawX = (int)(var7[0] * (float)var1.width);
      var8.rawY = (int)((float)var1.height * var7[1]);
      var8.rawWidth = (int)(var7[2] * (float)var1.width);
      var8.rawHeight = (int)((float)var1.height * var7[3]);
      return var8;
   }

    @ObfuscatedName("lc")
    @ObfuscatedSignature(
            descriptor = "(IIII)Lcq;",
            garbageValue = "-837606466"
    )
    static final InterfaceParent ifOpenSub(int var0, int var1, int var2) {
      InterfaceParent var3 = new InterfaceParent();
      var3.group = var1;
      var3.type = var2;
      Client.interfaceParents.put(var3, (long)var0);
      class155.Widget_resetModelFrames(var1);
      Widget var4 = class133.getWidget(var0);
      LoginScreenAnimation.invalidateWidget(var4);
      if (Client.meslayerContinueWidget != null) {
         LoginScreenAnimation.invalidateWidget(Client.meslayerContinueWidget);
         Client.meslayerContinueWidget = null;
      }

      AbstractWorldMapData.revalidateWidgetScroll(WorldMapLabel.Widget_interfaceComponents[var0 >> 16], var4, false);
      SoundCache.runWidgetOnLoadListener(var1);
      if (Client.rootInterface != -1) {
         class147.runIntfCloseListeners(Client.rootInterface, 1);
      }

      return var3;
   }

   @ObfuscatedName("mq")
   @ObfuscatedSignature(
      descriptor = "(IB)V",
      garbageValue = "0"
   )
   static void method1885(int var0) {
      if (var0 != Client.loginState) {
         Client.loginState = var0;
      }
   }
}
