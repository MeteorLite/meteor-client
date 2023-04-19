import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.DataLine.Info;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ae")
@Implements("DevicePcmPlayer")
public class DevicePcmPlayer extends PcmPlayer {
    @ObfuscatedName("af")
    SourceDataLine line;
    @ObfuscatedName("an")
    AudioFormat format;
    @ObfuscatedName("aw")
    int capacity2;
    @ObfuscatedName("ac")
    byte[] byteSamples;

    @ObfuscatedName("af")
    @ObfuscatedSignature(
            descriptor = "(B)V",
            garbageValue = "28"
    )
    protected void init() {
      this.format = new AudioFormat((float)PcmPlayer.field201, 16, PcmPlayer.PcmPlayer_stereo ? 2 : 1, true, false);
      this.byteSamples = new byte[256 << (PcmPlayer.PcmPlayer_stereo ? 2 : 1)];
   }

    @ObfuscatedName("an")
    @ObfuscatedSignature(
            descriptor = "(II)V",
            garbageValue = "182405776"
    )
    protected void open(int var1) throws LineUnavailableException {
      try {
         Info var2 = new Info(SourceDataLine.class, this.format, var1 << (PcmPlayer.PcmPlayer_stereo ? 2 : 1));
         this.line = (SourceDataLine)AudioSystem.getLine(var2);
         this.line.open();
         this.line.start();
         this.capacity2 = var1;
      } catch (LineUnavailableException var3) {
         if (class18.method76(var1) != 1) {
            this.open(class70.method442(var1));
         } else {
            this.line = null;
            throw var3;
         }
      }
   }

    @ObfuscatedName("aw")
    @ObfuscatedSignature(
            descriptor = "(I)I",
            garbageValue = "-654786411"
    )
    protected int position() {
      return this.capacity2 - (this.line.available() >> (PcmPlayer.PcmPlayer_stereo ? 2 : 1));
   }

    @ObfuscatedName("ac")
    protected void write() {
      int var1 = 256;
      if (PcmPlayer.PcmPlayer_stereo) {
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

    @ObfuscatedName("au")
    @ObfuscatedSignature(
            descriptor = "(I)V",
            garbageValue = "-1466449702"
    )
    protected void close() {
      if (this.line != null) {
         this.line.close();
         this.line = null;
      }

   }

    @ObfuscatedName("ab")
    @ObfuscatedSignature(
            descriptor = "(B)V",
            garbageValue = "22"
    )
    protected void discard() {
      this.line.flush();
   }
}
