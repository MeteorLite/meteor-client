import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.DataLine.Info;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ah")
@Implements("DevicePcmPlayer")
public class DevicePcmPlayer extends PcmPlayer {
   @ObfuscatedName("aj")
   @Export("format")
   AudioFormat format;
   @ObfuscatedName("al")
   @Export("line")
   SourceDataLine line;
   @ObfuscatedName("ac")
   @Export("capacity2")
   int capacity2;
   @ObfuscatedName("ab")
   @Export("byteSamples")
   byte[] byteSamples;

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "-2134180158"
   )
   @Export("init")
   protected void init() {
      this.format = new AudioFormat((float)PcmPlayer.field194, 16, ChatChannel.PcmPlayer_stereo ? 2 : 1, true, false);
      this.byteSamples = new byte[256 << (ChatChannel.PcmPlayer_stereo ? 2 : 1)];
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "(IB)V",
      garbageValue = "1"
   )
   @Export("open")
   protected void open(int var1) throws LineUnavailableException {
      try {
         Info var2 = new Info(SourceDataLine.class, this.format, var1 << (ChatChannel.PcmPlayer_stereo ? 2 : 1));
         this.line = (SourceDataLine)AudioSystem.getLine(var2);
         this.line.open();
         this.line.start();
         this.capacity2 = var1;
      } catch (LineUnavailableException var3) {
         if (class287.method1548(var1) != 1) {
            this.open(WorldMapLabelSize.method1313(var1));
         } else {
            this.line = null;
            throw var3;
         }
      }
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "(B)I",
      garbageValue = "84"
   )
   @Export("position")
   protected int position() {
      return this.capacity2 - (this.line.available() >> (ChatChannel.PcmPlayer_stereo ? 2 : 1));
   }

   @ObfuscatedName("ab")
   @Export("write")
   protected void write() {
      int var1 = 256;
      if (ChatChannel.PcmPlayer_stereo) {
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

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "-1"
   )
   @Export("close")
   protected void close() {
      if (this.line != null) {
         this.line.close();
         this.line = null;
      }

   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      descriptor = "(S)V",
      garbageValue = "-5904"
   )
   @Export("discard")
   protected void discard() {
      this.line.flush();
   }
}
