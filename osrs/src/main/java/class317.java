import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("mm")
public class class317 {
   @ObfuscatedName("jo")
   @ObfuscatedSignature(
      descriptor = "(III)V",
      garbageValue = "2047832354"
   )
   static final void method1828(int var0, int var1) {
      if (Client.hintArrowType == 2) {
         class374.worldToScreen((Client.hintArrowX - WorldMapData_0.baseX << 7) + Client.hintArrowSubX, (Client.hintArrowY - GameObject.baseY << 7) + Client.hintArrowSubY, Client.hintArrowHeight * 2);
         if (Client.viewportTempX > -1 && Client.cycle % 20 < 10) {
            KitDefinition.headIconHintSprites[0].drawTransBgAt(var0 + Client.viewportTempX - 12, Client.viewportTempY + var1 - 28);
         }

      }
   }
}
