import java.net.MalformedURLException;
import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dj")
@Implements("AttackOption")
public enum AttackOption implements class356 {
    @ObfuscatedName("af")
    @ObfuscatedSignature(
            descriptor = "Ldj;"
    )
    AttackOption_dependsOnCombatLevels(0),
    @ObfuscatedName("an")
    @ObfuscatedSignature(
            descriptor = "Ldj;"
    )
    AttackOption_alwaysRightClick(1),
   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      descriptor = "Ldj;"
   )
   field1070(2),
    @ObfuscatedName("ac")
    @ObfuscatedSignature(
            descriptor = "Ldj;"
    )
    AttackOption_hidden(3),
   @ObfuscatedName("au")
   @ObfuscatedSignature(
      descriptor = "Ldj;"
   )
   field1073(4);

    @ObfuscatedName("ab")
    final int id;

   AttackOption(int var3) {
      this.id = var3;
   }

    @ObfuscatedName("af")
    @ObfuscatedSignature(
            descriptor = "(I)I",
            garbageValue = "741942848"
    )
    public int rsOrdinal() {
      return this.id;
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;B)Z",
      garbageValue = "29"
   )
   static boolean method619(String var0) {
      if (var0 == null) {
         return false;
      } else {
         try {
            new URL(var0);
            return true;
         } catch (MalformedURLException var2) {
            return false;
         }
      }
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      descriptor = "(II)I",
      garbageValue = "-1961239650"
   )
   public static int method621(int var0) {
      return class439.field3829[var0 & 16383];
   }

    @ObfuscatedName("mf")
    @ObfuscatedSignature(
            descriptor = "(IIII)Ldi;",
            garbageValue = "-1618920051"
    )
    static final InterfaceParent ifOpenSub(int var0, int var1, int var2) {
      InterfaceParent var3 = new InterfaceParent();
      var3.group = var1;
      var3.type = var2;
      Client.interfaceParents.put(var3, (long)var0);
      ZoneOperation.Widget_resetModelFrames(var1);
      Widget var4 = class165.getWidget(var0);
      class144.invalidateWidget(var4);
      if (Client.meslayerContinueWidget != null) {
         class144.invalidateWidget(Client.meslayerContinueWidget);
         Client.meslayerContinueWidget = null;
      }

      WallDecoration.revalidateWidgetScroll(VerticalAlignment.Widget_interfaceComponents[var0 >> 16], var4, false);
      class12.runWidgetOnLoadListener(var1);
      if (Client.rootInterface != -1) {
         class127.runIntfCloseListeners(Client.rootInterface, 1);
      }

      return var3;
   }
}
