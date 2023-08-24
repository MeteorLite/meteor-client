import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@ObfuscatedName("ar")
public class class14 {
	@ObfuscatedName("au")
	final int field42;
	@ObfuscatedName("ae")
	final String field43;
	@ObfuscatedName("ao")
	final ThreadFactory field44;
	@ObfuscatedName("at")
	final ThreadPoolExecutor field45;

	public class14(String var1, int var2, int var3) {
		this.field43 = var1;
		this.field42 = var2;
		this.field44 = new class16(this);
		this.field45 = this.method37(var3);
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(IB)Ljava/util/concurrent/ThreadPoolExecutor;",
		garbageValue = "-56"
	)
	final ThreadPoolExecutor method37(int var1) {
		return new ThreadPoolExecutor(var1, var1, 0L, TimeUnit.MILLISECONDS, new ArrayBlockingQueue(this.field42), this.field44);
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(Lad;B)Lax;",
		garbageValue = "19"
	)
	public class18 method38(class10 var1) {
		if (this.field45.getQueue().remainingCapacity() <= 0) {
			System.err.println("REST thread pool queue is empty\r\nThread pool size " + this.field45.getCorePoolSize() + " Queue capacity " + this.field42);
			return new class18("Queue full");
		} else {
			class18 var2 = new class18(this.field45.submit(new class19(this, var1)));
			return var2;
		}
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "2032063402"
	)
	public final void method40() {
		try {
			this.field45.shutdown();
		} catch (Exception var2) {
			System.err.println("Error shutting down RestRequestService\r\n" + var2);
		}

	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(Lsf;III)I",
		garbageValue = "-1229342893"
	)
	static int method39(IterableNodeHashTable var0, int var1, int var2) {
		if (var0 == null) {
			return var2;
		} else {
			IntegerNode var3 = (IntegerNode)var0.get((long)var1);
			return var3 == null ? var2 : var3.integer;
		}
	}

	@ObfuscatedName("lp")
	@ObfuscatedSignature(
		descriptor = "(ILjava/lang/String;I)V",
		garbageValue = "-525651527"
	)
	static void method41(int var0, String var1) {
		int var2 = Players.Players_count;
		int[] var3 = Players.Players_indices;
		boolean var4 = false;
		Username var5 = new Username(var1, Language.loginType);

		for (int var6 = 0; var6 < var2; ++var6) {
			Player var7 = Client.players[var3[var6]];
			if (var7 != null && var7 != VarbitComposition.localPlayer && var7.username != null && var7.username.equals(var5)) {
				PacketBufferNode var8;
				if (var0 == 1) {
					var8 = ApproximateRouteStrategy.getPacketBufferNode(ClientPacket.OPPLAYER1, Client.packetWriter.isaacCipher);
					var8.packetBuffer.writeShortAddLE(var3[var6]);
					var8.packetBuffer.writeByteSub(0);
					Client.packetWriter.addNode(var8);
				} else if (var0 == 4) {
					var8 = ApproximateRouteStrategy.getPacketBufferNode(ClientPacket.OPPLAYER4, Client.packetWriter.isaacCipher);
					var8.packetBuffer.writeShortAdd(var3[var6]);
					var8.packetBuffer.writeByteNeg(0);
					Client.packetWriter.addNode(var8);
				} else if (var0 == 6) {
					var8 = ApproximateRouteStrategy.getPacketBufferNode(ClientPacket.OPPLAYER6, Client.packetWriter.isaacCipher);
					var8.packetBuffer.writeShortAdd(var3[var6]);
					var8.packetBuffer.writeByteSub(0);
					Client.packetWriter.addNode(var8);
				} else if (var0 == 7) {
					var8 = ApproximateRouteStrategy.getPacketBufferNode(ClientPacket.OPPLAYER7, Client.packetWriter.isaacCipher);
					var8.packetBuffer.writeIntME(var3[var6]);
					var8.packetBuffer.writeByte(0);
					Client.packetWriter.addNode(var8);
				}

				var4 = true;
				break;
			}
		}

		if (!var4) {
			MouseHandler.addGameMessage(4, "", "Unable to find " + var1);
		}

	}

	@ObfuscatedName("lt")
	@ObfuscatedSignature(
		descriptor = "(III)Ljava/lang/String;",
		garbageValue = "-539103842"
	)
	static final String method42(int var0, int var1) {
		int var2 = var1 - var0;
		if (var2 < -9) {
			return MoveSpeed.colorStartTag(16711680);
		} else if (var2 < -6) {
			return MoveSpeed.colorStartTag(16723968);
		} else if (var2 < -3) {
			return MoveSpeed.colorStartTag(16740352);
		} else if (var2 < 0) {
			return MoveSpeed.colorStartTag(16756736);
		} else if (var2 > 9) {
			return MoveSpeed.colorStartTag(65280);
		} else if (var2 > 6) {
			return MoveSpeed.colorStartTag(4259584);
		} else if (var2 > 3) {
			return MoveSpeed.colorStartTag(8453888);
		} else {
			return var2 > 0 ? MoveSpeed.colorStartTag(12648192) : MoveSpeed.colorStartTag(16776960);
		}
	}

	@ObfuscatedName("mz")
	@ObfuscatedSignature(
		descriptor = "(ZB)V",
		garbageValue = "-26"
	)
	@Export("setTapToDrop")
	static void setTapToDrop(boolean var0) {
		Client.tapToDrop = var0;
	}

	@ObfuscatedName("nd")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "-361779527"
	)
	static final void method44(int var0) {
		var0 = Math.min(Math.max(var0, 0), 127);
		class449.clientPreferences.setAreaSoundEffectsVolume(var0);
	}
}