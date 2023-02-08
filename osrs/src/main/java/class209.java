import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hf")
public class class209 {
    @ObfuscatedName("tf")
    @ObfuscatedSignature(
            descriptor = "Lay;"
    )
    static PcmStreamMixer pcmStreamMixer;
    @ObfuscatedName("v")
    public static int[][] directions = new int[128][128];
    @ObfuscatedName("s")
    public static int[][] distances = new int[128][128];
   @ObfuscatedName("z")
   public static int field1853;
   @ObfuscatedName("j")
   public static int field1854;
    @ObfuscatedName("n")
    public static int[] bufferX = new int[4096];
    @ObfuscatedName("l")
    public static int[] bufferY = new int[4096];
   @ObfuscatedName("dw")
   static boolean field1857;

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      descriptor = "(I)Ljava/lang/String;",
      garbageValue = "31888042"
   )
   static String method1111() {
      StringBuilder var0 = new StringBuilder();

      Message var2;
      for(Iterator var1 = Messages.Messages_hashTable.iterator(); var1.hasNext(); var0.append(var2.text).append('\n')) {
         var2 = (Message)var1.next();
         if (var2.sender != null && !var2.sender.isEmpty()) {
            var0.append(var2.sender).append(':');
         }
      }

      return var0.toString();
   }
}
