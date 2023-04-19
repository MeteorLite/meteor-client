import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("sa")
final class class475 implements class474 {
    @ObfuscatedName("ac")
    @ObfuscatedSignature(
            descriptor = "Lln;"
    )
    public static MidiPcmStream midiPcmStream;

    @ObfuscatedName("af")
    @ObfuscatedSignature(
            descriptor = "(Ljava/lang/Object;Lsg;I)V",
            garbageValue = "-1451264347"
    )
    public void vmethod8274(Object var1, Buffer var2) {
      this.method2424((Integer)var1, var2);
   }

    @ObfuscatedName("an")
    @ObfuscatedSignature(
            descriptor = "(Lsg;I)Ljava/lang/Object;",
            garbageValue = "-1690934499"
    )
    public Object vmethod8273(Buffer var1) {
      return var1.readInt();
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/Integer;Lsg;I)V",
      garbageValue = "-1039582694"
   )
   void method2424(Integer var1, Buffer var2) {
      var2.writeInt(var1);
   }
}
