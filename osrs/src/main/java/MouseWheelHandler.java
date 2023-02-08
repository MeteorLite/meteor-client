import java.awt.Component;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("q")
@Implements("MouseWheelHandler")
public final class MouseWheelHandler implements class170, MouseWheelListener {
    @ObfuscatedName("f")
    int rotation = 0;

    @ObfuscatedName("f")
    @ObfuscatedSignature(
            descriptor = "(Ljava/awt/Component;I)V",
            garbageValue = "-708063290"
    )
    void addTo(Component var1) {
      var1.addMouseWheelListener(this);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      descriptor = "(Ljava/awt/Component;S)V",
      garbageValue = "29424"
   )
   void method78(Component var1) {
      var1.removeMouseWheelListener(this);
   }

    @ObfuscatedName("v")
    @ObfuscatedSignature(
            descriptor = "(B)I",
            garbageValue = "47"
    )
    public synchronized int useRotation() {
      int var1 = this.rotation;
      this.rotation = 0;
      return var1;
   }

    @ObfuscatedName("mouseWheelMoved")
    public synchronized void mouseWheelMoved(MouseWheelEvent var1) {
      this.rotation += var1.getWheelRotation();
   }
}
