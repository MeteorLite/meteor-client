import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ut")
public class class544 {
	@ObfuscatedName("ah")
	int field4294;
	@ObfuscatedName("ar")
	int field4298;
	@ObfuscatedName("ao")
	int field4296;
	@ObfuscatedName("ab")
	int field4292;
	@ObfuscatedName("au")
	int field4300;
	@ObfuscatedName("aa")
	int field4291;
	@ObfuscatedName("ac")
	int field4293;
	@ObfuscatedName("al")
	int field4295;
	@ObfuscatedName("az")
	boolean field4290;
	@ObfuscatedName("ap")
	int field4297;
	@ObfuscatedName("av")
	int field4301;
	@ObfuscatedName("ax")
	int field4302;
	@ObfuscatedName("as")
	int field4299;

	public class544() {
		this.field4293 = 0;
		this.field4295 = 0;
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(IIIIIIIIZB)V",
		garbageValue = "0"
	)
	public void method2712(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, boolean var9) {
		this.field4294 = var1;
		this.field4298 = var2;
		this.field4296 = var3;
		this.field4292 = var4;
		this.field4300 = var5;
		this.field4291 = var6;
		this.field4293 = var7;
		this.field4295 = var8;
		this.field4290 = var9;
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(IIIIB)V",
		garbageValue = "82"
	)
	public void method2713(int var1, int var2, int var3, int var4) {
		this.field4297 = var1;
		this.field4301 = var2;
		this.field4302 = var3;
		this.field4299 = var4;
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(Lpv;Lpf;I)V",
		garbageValue = "72760556"
	)
	public void method2714(class406 var1, Font var2) {
		if (var2 != null) {
			int var3 = var2.ascent;
			int var4 = Math.min(this.field4292, (int)((float)var3 * 0.9F));
			int var5 = var1.method2084(this.field4296);
			int var6 = var1.method2085(this.field4292);
			int var7 = var5 + (this.field4294 - this.field4300);
			int var8 = var6 + var3 + (this.field4298 - this.field4291);
			Rasterizer2D.Rasterizer2D_setClip(this.field4294, this.field4298, this.field4294 + this.field4296, this.field4292 + this.field4298);
			int var9 = this.field4295;
			int var10 = this.field4293;
			if (var9 > var10) {
				int var11 = var9;
				var9 = var10;
				var10 = var11;
			}

			class410 var21 = var1.method2065(0, var9);
			class410 var12 = var1.method2065(var9, var10);
			class410 var13 = var1.method2065(var10, var1.method2055());
			class410 var14 = var1.method2065(0, this.field4293);
			int var16;
			int var18;
			if (!var12.method2133()) {
				int var15 = var2.maxAscent + var2.maxDescent;

				for (var16 = 0; var16 < var12.method2134(); ++var16) {
					class408 var17 = var12.method2138(var16);
					var18 = var7 + var17.field3717;
					int var19 = var2.charWidth(var17.field3716);
					int var20 = var8 + var17.field3718 - var3;
					Rasterizer2D.Rasterizer2D_fillRectangle(var18, var20, var19, var15, this.field4299);
				}
			}

			if (!var21.method2133()) {
				var2.method2112(var21, var7, var8, this.field4297, this.field4301, -1);
			}

			if (!var12.method2133()) {
				var2.method2112(var12, var7, var8, this.field4302, this.field4301, -1);
			}

			if (!var13.method2133()) {
				var2.method2112(var13, var7, var8, this.field4297, this.field4301, -1);
			}

			if (this.field4290) {
				class497 var22 = var14.method2137();
				var16 = var7 + (Integer)var22.field4074;
				int var23 = var8 + (Integer)var22.field4073;
				var18 = var23 - var4;
				Rasterizer2D.Rasterizer2D_drawLine(var16, var23, var16, var18, this.field4297);
				if (this.field4301 != -1) {
					Rasterizer2D.Rasterizer2D_drawLine(var16 + 1, var23 + 1, var16 + 1, var18 + 1, this.field4301);
				}
			}

		}
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(ILjava/lang/String;Lof;II)Lld;",
		garbageValue = "-1670201559"
	)
	public static PacketBufferNode method2711(int var0, String var1, Language var2, int var3) {
		PacketBufferNode var4 = class113.getPacketBufferNode(ClientPacket.f96, Client.packetWriter.isaacCipher);
		var4.packetBuffer.writeByte(0);
		int var5 = var4.packetBuffer.offset;
		var4.packetBuffer.writeByte(var0);
		String var6 = var1.toLowerCase();
		int var7 = 0;
		byte[] var8 = null;
		if (var6.startsWith("yellow:")) {
			var7 = 0;
			var1 = var1.substring("yellow:".length());
		} else if (var6.startsWith("red:")) {
			var7 = 1;
			var1 = var1.substring("red:".length());
		} else if (var6.startsWith("green:")) {
			var7 = 2;
			var1 = var1.substring("green:".length());
		} else if (var6.startsWith("cyan:")) {
			var7 = 3;
			var1 = var1.substring("cyan:".length());
		} else if (var6.startsWith("purple:")) {
			var7 = 4;
			var1 = var1.substring("purple:".length());
		} else if (var6.startsWith("white:")) {
			var7 = 5;
			var1 = var1.substring("white:".length());
		} else if (var6.startsWith("flash1:")) {
			var7 = 6;
			var1 = var1.substring("flash1:".length());
		} else if (var6.startsWith("flash2:")) {
			var7 = 7;
			var1 = var1.substring("flash2:".length());
		} else if (var6.startsWith("flash3:")) {
			var7 = 8;
			var1 = var1.substring("flash3:".length());
		} else if (var6.startsWith("glow1:")) {
			var7 = 9;
			var1 = var1.substring("glow1:".length());
		} else if (var6.startsWith("glow2:")) {
			var7 = 10;
			var1 = var1.substring("glow2:".length());
		} else if (var6.startsWith("glow3:")) {
			var7 = 11;
			var1 = var1.substring("glow3:".length());
		} else if (var6.startsWith("rainbow:")) {
			var7 = 12;
			var1 = var1.substring("rainbow:".length());
		} else if (var6.startsWith("pattern")) {
			boolean var10 = true;
			boolean var11 = true;
			int var12 = "pattern".length();
			int var13 = 0;
			byte[] var14 = new byte[8];

			byte[] var9;
			while (true) {
				int var15 = var12 + var13;
				if (var15 >= var6.length()) {
					var9 = null;
					break;
				}

				char var16 = var6.charAt(var15);
				if (var16 == ':') {
					if (var13 == 0) {
						var9 = null;
					} else {
						byte[] var17 = new byte[var13];
						System.arraycopy(var14, 0, var17, 0, var13);
						var9 = var17;
					}
					break;
				}

				if (var14.length == var13) {
					var9 = null;
					break;
				}

				if (var16 >= '0' && var16 <= '9') {
					var16 = (char)(var16 - '0');
				} else {
					if (var16 < 'a' || var16 > 'z') {
						var9 = null;
						break;
					}

					var16 = (char)(var16 - 'W');
				}

				var14[var13++] = (byte)var16;
			}

			var8 = var9;
			if (var9 != null) {
				var7 = var9.length + 12;
				var1 = var1.substring("pattern".length() + var9.length + 1);
			}
		}

		var6 = var1.toLowerCase();
		byte var18 = 0;
		if (var6.startsWith("wave:")) {
			var18 = 1;
			var1 = var1.substring("wave:".length());
		} else if (var6.startsWith("wave2:")) {
			var18 = 2;
			var1 = var1.substring("wave2:".length());
		} else if (var6.startsWith("shake:")) {
			var18 = 3;
			var1 = var1.substring("shake:".length());
		} else if (var6.startsWith("scroll:")) {
			var18 = 4;
			var1 = var1.substring("scroll:".length());
		} else if (var6.startsWith("slide:")) {
			var18 = 5;
			var1 = var1.substring("slide:".length());
		}

		var4.packetBuffer.writeByte(var7);
		var4.packetBuffer.writeByte(var18);
		if (var8 != null && Client.param25 >= 214) {
			for (int var19 = 0; var19 < var8.length; ++var19) {
				var4.packetBuffer.writeByte(var8[var19]);
			}
		}

		PcmPlayer.method210(var4.packetBuffer, var1);
		if (var0 == class351.field3144.rsOrdinal()) {
			var4.packetBuffer.writeByte(var3);
		}

		var4.packetBuffer.writeLengthByte(var4.packetBuffer.offset - var5);
		return var4;
	}
}