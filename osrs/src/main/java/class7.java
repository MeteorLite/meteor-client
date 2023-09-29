import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@ObfuscatedName("ab")
public class class7 {
	@ObfuscatedName("ac")
	ExecutorService field7;
	@ObfuscatedName("al")
	Future field8;
	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "Lul;"
	)
	final Buffer field10;
	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "Lax;"
	)
	final class3 field9;

	@ObfuscatedSignature(
		descriptor = "(Lul;Lax;)V"
	)
	public class7(Buffer var1, class3 var2) {
		this.field7 = Executors.newSingleThreadExecutor();
		this.field10 = var1;
		this.field9 = var2;
		this.method21();
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(B)Z",
		garbageValue = "8"
	)
	public boolean method17() {
		return this.field8.isDone();
	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "40"
	)
	public void method18() {
		this.field7.shutdown();
		this.field7 = null;
	}

	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "(I)Lul;",
		garbageValue = "1362565755"
	)
	public Buffer method19() {
		try {
			return (Buffer)this.field8.get();
		} catch (Exception var2) {
			return null;
		}
	}

	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-693034688"
	)
	void method21() {
		this.field8 = this.field7.submit(new class1(this, this.field10, this.field9));
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(I)J",
		garbageValue = "-20434766"
	)
	static long method20() {
		try {
			URL var0 = new URL(ScriptEvent.method474("services", false) + "m=accountappeal/login.ws");
			URLConnection var1 = var0.openConnection();
			var1.setRequestProperty("connection", "close");
			var1.setDoInput(true);
			var1.setDoOutput(true);
			var1.setConnectTimeout(5000);
			OutputStreamWriter var2 = new OutputStreamWriter(var1.getOutputStream());
			var2.write("data1=req");
			var2.flush();
			InputStream var3 = var1.getInputStream();
			Buffer var4 = new Buffer(new byte[1000]);

			do {
				int var5 = var3.read(var4.array, var4.offset, 1000 - var4.offset);
				if (var5 == -1) {
					var4.offset = 0;
					long var7 = var4.readLong();
					return var7;
				}

				var4.offset += var5;
			} while(var4.offset < 1000);

			return 0L;
		} catch (Exception var9) {
			return 0L;
		}
	}

	@ObfuscatedName("ht")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "1063387188"
	)
	@Export("forceDisconnect")
	static final void forceDisconnect(int var0) {
		CollisionMap.method1166();
		switch(var0) {
		case 1:
			GameEngine.method166(24);
			AbstractWorldMapIcon.setLoginResponseString("", "You were disconnected from the server.", "");
			break;
		case 2:
			class339.method1746();
		}

	}

	@ObfuscatedName("jt")
	@ObfuscatedSignature(
		descriptor = "(I)Lpf;",
		garbageValue = "2097624965"
	)
	@Export("getScriptEvents")
	public static NodeDeque getScriptEvents() {
		return Client.scriptEvents;
	}
}