import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ox")
@Implements("ArchiveDiskActionHandler")
public class ArchiveDiskActionHandler implements Runnable {
	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "Lon;"
	)
	@Export("ArchiveDiskActionHandler_requestQueue")
	public static final NodeDeque ArchiveDiskActionHandler_requestQueue;
	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "Lon;"
	)
	@Export("ArchiveDiskActionHandler_responseQueue")
	public static NodeDeque ArchiveDiskActionHandler_responseQueue;
	@ObfuscatedName("ar")
	static int field3542;
	@ObfuscatedName("ao")
	static boolean field3541;
	@ObfuscatedName("ab")
	static Object field3543;
	@ObfuscatedName("au")
	@Export("ArchiveDiskActionHandler_thread")
	static Thread ArchiveDiskActionHandler_thread;

	static {
		ArchiveDiskActionHandler_requestQueue = new NodeDeque();
		ArchiveDiskActionHandler_responseQueue = new NodeDeque();
		field3542 = 0;
		field3541 = false;
		field3543 = new Object();
	}

	ArchiveDiskActionHandler() {
	}

	@Export("run")
	@ObfuscatedName("run")
	public void run() {
		try {
			while (true) {
				ArchiveDiskAction var1;
				synchronized(ArchiveDiskActionHandler_requestQueue) {
					var1 = (ArchiveDiskAction)ArchiveDiskActionHandler_requestQueue.last();
				}

				if (var1 != null) {
					if (var1.type == 0) {
						var1.archiveDisk.write((int)var1.key, var1.data, var1.data.length);
						synchronized(ArchiveDiskActionHandler_requestQueue) {
							var1.remove();
						}
					} else if (var1.type == 1) {
						var1.data = var1.archiveDisk.read((int)var1.key);
						synchronized(ArchiveDiskActionHandler_requestQueue) {
							ArchiveDiskActionHandler_responseQueue.addFirst(var1);
						}
					}

					synchronized(field3543) {
						if ((field3541 || field3542 <= 1) && ArchiveDiskActionHandler_requestQueue.method2016()) {
							field3542 = 0;
							field3543.notifyAll();
							return;
						}

						field3542 = 600;
					}
				} else {
					class219.method1104(100L);
					synchronized(field3543) {
						if ((field3541 || field3542 <= 1) && ArchiveDiskActionHandler_requestQueue.method2016()) {
							field3542 = 0;
							field3543.notifyAll();
							return;
						}

						--field3542;
					}
				}
			}
		} catch (Exception var13) {
			GrandExchangeOfferWorldComparator.RunException_sendStackTrace((String)null, var13);
		}
	}
}