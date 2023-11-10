import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import org.bouncycastle.crypto.tls.DefaultTlsClient;
import org.bouncycastle.crypto.tls.TlsAuthentication;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Hashtable;

@ObfuscatedName("as")
class class13 extends DefaultTlsClient {
	// $FF: synthetic field
	@ObfuscatedSignature(
		descriptor = "Lax;"
	)
	final class12 this$1;

	@ObfuscatedSignature(
		descriptor = "(Lax;)V"
	)
	class13(class12 var1) {
		this.this$1 = var1;
	}

	@Export("getClientExtensions")
	@ObfuscatedName("getClientExtensions")
	public Hashtable getClientExtensions() throws IOException {
		Hashtable var1 = super.getClientExtensions();
		if (var1 == null) {
			var1 = new Hashtable();
		}

		byte[] var2 = this.this$1.val$host.getBytes();
		ByteArrayOutputStream var3 = new ByteArrayOutputStream();
		DataOutputStream var4 = new DataOutputStream(var3);
		var4.writeShort(var2.length + 3);
		var4.writeByte(0);
		var4.writeShort(var2.length);
		var4.write(var2);
		var4.close();
		var1.put(0, var3.toByteArray());
		return var1;
	}

	@Export("getAuthentication")
	@ObfuscatedName("getAuthentication")
	public TlsAuthentication getAuthentication() throws IOException {
		return new class11(this);
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(I)[Lnv;",
		garbageValue = "173861677"
	)
	public static GameBuild[] method50() {
		return new GameBuild[]{GameBuild.BUILDLIVE, GameBuild.LIVE, GameBuild.RC, GameBuild.WIP};
	}

	@ObfuscatedName("hy")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "20"
	)
	static final void method51() {
		Client.packetWriter.close();
		ObjectSound.method424();
		class36.scene.clear();

		for (int var0 = 0; var0 < 4; ++var0) {
			Client.collisionMaps[var0].clear();
		}

		Client.field422.method1114();
		System.gc();
		WorldMapManager.method1265(0, 0);
		class472.method2350();
		Client.playingJingle = false;
		WorldMapSectionType.method1311();
		WorldMapSection2.updateGameState(10);
	}
}