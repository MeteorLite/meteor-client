import java.awt.Component;
import java.awt.Graphics;
import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("e")
@Implements("Canvas")
public final class Canvas extends java.awt.Canvas {
   @ObfuscatedName("vt")
   static Iterator field78;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      descriptor = "Lrg;"
   )
   static IndexedSprite field79;
   @ObfuscatedName("fl")
   @ObfuscatedSignature(
      descriptor = "Llm;"
   )
   static Archive field75;
   @ObfuscatedName("ff")
   static int field77;
    @ObfuscatedName("f")
    Component component;

   Canvas(Component var1) {
      this.component = var1;
   }

   public final void update(Graphics var1) {
      this.component.update(var1);
   }

   public final void paint(Graphics var1) {
      this.component.paint(var1);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "(B)[Ljw;",
      garbageValue = "-68"
   )
   static LoginPacket[] method82() {
      return new LoginPacket[]{LoginPacket.RECONNECT_LOGIN_CONNECTION, LoginPacket.field2681, LoginPacket.field2682, LoginPacket.NEW_LOGIN_CONNECTION, LoginPacket.field2677, LoginPacket.field2678};
   }
}
