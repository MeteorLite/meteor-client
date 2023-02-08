import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cd")
@Implements("ScriptEvent")
public class ScriptEvent extends Node {
    @ObfuscatedName("f")
    Object[] args;
    @ObfuscatedName("w")
    boolean isMouseInputEvent;
    @ObfuscatedName("v")
    @ObfuscatedSignature(
            descriptor = "Lkz;"
    )
    Widget widget;
    @ObfuscatedName("s")
    int mouseX;
    @ObfuscatedName("z")
    int mouseY;
    @ObfuscatedName("j")
    int opIndex;
    @ObfuscatedName("i")
    @ObfuscatedSignature(
            descriptor = "Lkz;"
    )
    Widget dragTarget;
    @ObfuscatedName("n")
    int keyTyped;
    @ObfuscatedName("l")
    int keyPressed;
    @ObfuscatedName("k")
    String targetName;
   @ObfuscatedName("c")
   int field866;
    @ObfuscatedName("r")
    int type = 76;

    @ObfuscatedName("f")
    @ObfuscatedSignature(
            descriptor = "([Ljava/lang/Object;I)V",
            garbageValue = "710868309"
    )
    public void setArgs(Object[] var1) {
      this.args = var1;
   }

    @ObfuscatedName("w")
    @ObfuscatedSignature(
            descriptor = "(II)V",
            garbageValue = "-2059816970"
    )
    public void setType(int var1) {
      this.type = var1;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "(Lkz;I)V",
      garbageValue = "826217061"
   )
   public void method461(Widget var1) {
      this.widget = var1;
   }

    @ObfuscatedName("gj")
    @ObfuscatedSignature(
            descriptor = "(IIB)V",
            garbageValue = "-48"
    )
    static void playJingle(int var0, int var1) {
      if (PacketWriter.clientPreferences.getCurrentMusicVolume() != 0 && var0 != -1) {
         class148.method784(MusicPatchNode.field2782, var0, 0, PacketWriter.clientPreferences.getCurrentMusicVolume(), false);
         Client.playingJingle = true;
      }

   }
}
