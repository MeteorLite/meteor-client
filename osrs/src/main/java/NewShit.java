import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gp")
@Implements("NewShit")
public class NewShit {
   @ObfuscatedName("g")
   public static short[] field1545;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      descriptor = "Lld;"
   )
   public static NetFileRequest NetCache_currentResponse;
   @ObfuscatedName("h")
   public long field1546;
   @ObfuscatedName("e")
   int[] field1542;
   @ObfuscatedName("v")
   short[] field1543;
   @ObfuscatedName("x")
   short[] field1544;

   public NewShit(long var1, int[] var3, short[] var4, short[] var5) {
      this.field1546 = var1;
      this.field1542 = var3;
      this.field1543 = var4;
      this.field1544 = var5;
   }
}
