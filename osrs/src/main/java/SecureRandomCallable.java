import java.security.SecureRandom;
import java.util.Arrays;
import java.util.concurrent.Callable;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dm")
@Implements("SecureRandomCallable")
public class SecureRandomCallable implements Callable {
    @ObfuscatedName("ay")
    static int Interpreter_stringStackSize;

    @ObfuscatedName("call")
    public Object call() {
      SecureRandom var2 = new SecureRandom();
      var2.nextInt();
      return var2;
   }

   @ObfuscatedName("bv")
   @ObfuscatedSignature(
      descriptor = "(Lmq;Lmw;ZS)V",
      garbageValue = "222"
   )
   public static void method476(Widget var0, PlayerComposition var1, boolean var2) {
      var0.modelType = 7;
      var0.field2894 = new PlayerComposition(var1);
      if (!var2) {
         var0.field2894.equipment = Arrays.copyOf(var0.field2894.field2841, var0.field2894.field2841.length);
         var0.field2894.method1702();
      }

   }
}
