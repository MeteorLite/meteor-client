import java.nio.ByteBuffer;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("mp")
@Implements("DirectByteArrayCopier")
public class DirectByteArrayCopier extends AbstractByteArrayCopier {
    @ObfuscatedName("aq")
    static int gameCyclesToDo;
    @ObfuscatedName("af")
    ByteBuffer directBuffer;

    @ObfuscatedName("ac")
    @ObfuscatedSignature(
            descriptor = "(I)[B",
            garbageValue = "-302524425"
    )
    byte[] get() {
      byte[] var1 = new byte[this.directBuffer.capacity()];
      this.directBuffer.position(0);
      this.directBuffer.get(var1);
      return var1;
   }

    @ObfuscatedName("au")
    @ObfuscatedSignature(
            descriptor = "([BI)V",
            garbageValue = "1503790515"
    )
    void set(byte[] var1) {
      this.directBuffer = ByteBuffer.allocateDirect(var1.length);
      this.directBuffer.position(0);
      this.directBuffer.put(var1);
   }
}
