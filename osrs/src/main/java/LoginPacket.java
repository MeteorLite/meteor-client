import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lo")
@Implements("LoginPacket")
public class LoginPacket implements class304 {
	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "Llo;"
	)
	public static final LoginPacket field2764;
	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "Llo;"
	)
	static final LoginPacket field2765;
	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "Llo;"
	)
	@Export("NEW_LOGIN_CONNECTION")
	public static final LoginPacket NEW_LOGIN_CONNECTION;
	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "Llo;"
	)
	@Export("RECONNECT_LOGIN_CONNECTION")
	public static final LoginPacket RECONNECT_LOGIN_CONNECTION;
	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "Llo;"
	)
	public static final LoginPacket field2761;
	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "Llo;"
	)
	static final LoginPacket field2766;
	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "[Llo;"
	)
	static final LoginPacket[] field2767;
	@ObfuscatedName("aa")
	@Export("id")
	public final int id;

	static {
		field2764 = new LoginPacket(14, 0);
		field2765 = new LoginPacket(15, 4);
		NEW_LOGIN_CONNECTION = new LoginPacket(16, -2);
		RECONNECT_LOGIN_CONNECTION = new LoginPacket(18, -2);
		field2761 = new LoginPacket(19, -2);
		field2766 = new LoginPacket(27, 0);
		field2767 = new LoginPacket[32];
		LoginPacket[] var0 = class36.method183();

		for (int var1 = 0; var1 < var0.length; ++var1) {
			field2767[var0[var1].id] = var0[var1];
		}

	}

	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "0"
	)
	LoginPacket(int var1, int var2) {
		this.id = var1;
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(II)Lgz;",
		garbageValue = "2140543068"
	)
	@Export("getInvDefinition")
	public static InvDefinition getInvDefinition(int var0) {
		InvDefinition var1 = (InvDefinition)InvDefinition.InvDefinition_cached.get((long)var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = InvDefinition.InvDefinition_archive.takeFile(5, var0);
			var1 = new InvDefinition();
			if (var2 != null) {
				var1.decode(new Buffer(var2));
			}

			InvDefinition.InvDefinition_cached.put(var1, (long)var0);
			return var1;
		}
	}

	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "216092039"
	)
	public static void method1643() {
		VarpDefinition.VarpDefinition_cached.clear();
	}

	@ObfuscatedName("io")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;ZB)V",
		garbageValue = "-63"
	)
	@Export("drawLoadingMessage")
	static final void drawLoadingMessage(String var0, boolean var1) {
		if (Client.showLoadingMessages) {
			byte var2 = 4;
			int var3 = var2 + 6;
			int var4 = var2 + 6;
			int var5 = ItemLayer.fontPlain12.lineWidth(var0, 250);
			int var6 = ItemLayer.fontPlain12.lineCount(var0, 250) * 13;
			Rasterizer2D.Rasterizer2D_fillRectangle(var3 - var2, var4 - var2, var5 + var2 + var2, var2 + var6 + var2, 0);
			Rasterizer2D.Rasterizer2D_drawRectangle(var3 - var2, var4 - var2, var5 + var2 + var2, var6 + var2 + var2, 16777215);
			ItemLayer.fontPlain12.drawLines(var0, var3, var4, var5, var6, 16777215, -1, 1, 1, 0);
			int var7 = var3 - var2;
			int var8 = var4 - var2;
			int var9 = var2 + var2 + var5;
			int var10 = var2 + var2 + var6;

			for (int var11 = 0; var11 < Client.rootWidgetCount; ++var11) {
				if (Client.rootWidgetWidths[var11] + Client.rootWidgetXs[var11] > var7 && Client.rootWidgetXs[var11] < var9 + var7 && Client.rootWidgetHeights[var11] + Client.rootWidgetYs[var11] > var8 && Client.rootWidgetYs[var11] < var8 + var10) {
					Client.field407[var11] = true;
				}
			}

			if (var1) {
				class338.rasterProvider.drawFull(0, 0);
			} else {
				SoundSystem.method233(var3, var4, var5, var6);
			}

		}
	}
}