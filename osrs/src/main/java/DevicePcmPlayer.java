import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.DataLine.Info;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("v")
@Implements("DevicePcmPlayer")
public class DevicePcmPlayer extends PcmPlayer {
	@ObfuscatedName("a")
	@Export("format")
	AudioFormat format;
	@ObfuscatedName("f")
	@Export("line")
	SourceDataLine line;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = -224805165
	)
	@Export("capacity2")
	int capacity2;
	@ObfuscatedName("x")
	@Export("byteSamples")
	byte[] byteSamples;

	DevicePcmPlayer() {
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "1886684155"
	)
	@Export("init")
	protected void init() {
		this.format = new AudioFormat((float)SoundCache.field337, 16, class157.PcmPlayer_stereo ? 2 : 1, true, false);
		this.byteSamples = new byte[256 << (class157.PcmPlayer_stereo ? 2 : 1)];
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		descriptor = "(IB)V",
		garbageValue = "-13"
	)
	@Export("open")
	protected void open(int var1) throws LineUnavailableException {
		try {
			Info var2 = new Info(SourceDataLine.class, this.format, var1 << (class157.PcmPlayer_stereo ? 2 : 1));
			this.line = (SourceDataLine)AudioSystem.getLine(var2);
			this.line.open();
			this.line.start();
			this.capacity2 = var1;
		} catch (LineUnavailableException var3) {
			if (Renderable.method4454(var1) != 1) {
				this.open(class37.method712(var1));
			} else {
				this.line = null;
				throw var3;
			}
		}
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "-1692273069"
	)
	@Export("position")
	protected int position() {
		return this.capacity2 - (this.line.available() >> (class157.PcmPlayer_stereo ? 2 : 1));
	}

	@ObfuscatedName("x")
	@Export("write")
	protected void write() {
		int var1 = 256;
		if (class157.PcmPlayer_stereo) {
			var1 <<= 1;
		}

		for (int var2 = 0; var2 < var1; ++var2) {
			int var3 = super.samples[var2];
			if ((var3 + 8388608 & -16777216) != 0) {
				var3 = 8388607 ^ var3 >> 31;
			}

			this.byteSamples[var2 * 2] = (byte)(var3 >> 8);
			this.byteSamples[var2 * 2 + 1] = (byte)(var3 >> 16);
		}

		this.line.write(this.byteSamples, 0, var1 << 1);
	}

	@ObfuscatedName("h")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "1178676683"
	)
	@Export("close")
	protected void close() {
		if (this.line != null) {
			this.line.close();
			this.line = null;
		}

	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "117"
	)
	@Export("discard")
	protected void discard() {
		this.line.flush();
	}
}
