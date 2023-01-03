import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.DataLine.Info;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("w")
@Implements("DevicePcmPlayer")
public class DevicePcmPlayer extends PcmPlayer {
   @ObfuscatedName("h")
   AudioFormat format;
   @ObfuscatedName("e")
   SourceDataLine line;
   @ObfuscatedName("v")
   int capacity2;
   @ObfuscatedName("x")
   byte[] byteSamples;

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "-1022018312"
   )
   protected void init() {
      this.format = new AudioFormat((float)PcmPlayer.field198, 16, class286.PcmPlayer_stereo ? 2 : 1, true, false);
      this.byteSamples = new byte[256 << (class286.PcmPlayer_stereo ? 2 : 1)];
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "(IB)V",
      garbageValue = "-95"
   )
   protected void open(int var1) throws LineUnavailableException {
      try {
         Info var2 = new Info(SourceDataLine.class, this.format, var1 << (class286.PcmPlayer_stereo ? 2 : 1));
         this.line = (SourceDataLine)AudioSystem.getLine(var2);
         this.line.open();
         this.line.start();
         this.capacity2 = var1;
      } catch (LineUnavailableException var3) {
         if (class233.method1304(var1) != 1) {
            this.open(AccessFile.method2278(var1));
         } else {
            this.line = null;
            throw var3;
         }
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "(B)I",
      garbageValue = "116"
   )
   protected int position() {
      return this.capacity2 - (this.line.available() >> (class286.PcmPlayer_stereo ? 2 : 1));
   }

   @ObfuscatedName("x")
   protected void write() {
      int var1 = 256;
      if (class286.PcmPlayer_stereo) {
         var1 <<= 1;
      }

      for(int var2 = 0; var2 < var1; ++var2) {
         int var3 = super.samples[var2];
         if ((var3 + 8388608 & -16777216) != 0) {
            var3 = 8388607 ^ var3 >> 31;
         }

         this.byteSamples[var2 * 2] = (byte)(var3 >> 8);
         this.byteSamples[var2 * 2 + 1] = (byte)(var3 >> 16);
      }

      this.line.write(this.byteSamples, 0, var1 << 1);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "-126"
   )
   protected void close() {
      if (this.line != null) {
         this.line.close();
         this.line = null;
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "1458227244"
   )
   protected void discard() {
      this.line.flush();
   }
}
