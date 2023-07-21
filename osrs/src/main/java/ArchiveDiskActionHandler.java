import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("nl")
@Implements("ArchiveDiskActionHandler")
public class ArchiveDiskActionHandler implements Runnable {
	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "Lod;"
	)
	@Export("ArchiveDiskActionHandler_requestQueue")
	static final NodeDeque ArchiveDiskActionHandler_requestQueue;
	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "Lod;"
	)
	@Export("ArchiveDiskActionHandler_responseQueue")
	static NodeDeque ArchiveDiskActionHandler_responseQueue;
	@ObfuscatedName("ar")
	static int field3499;
	@ObfuscatedName("am")
	static boolean field3498;
	@ObfuscatedName("as")
	static Object field3500;
	@ObfuscatedName("aj")
	@Export("ArchiveDiskActionHandler_thread")
	static Thread ArchiveDiskActionHandler_thread;

	static {
		ArchiveDiskActionHandler_requestQueue = new NodeDeque();
		ArchiveDiskActionHandler_responseQueue = new NodeDeque();
		field3499 = 0;
		field3498 = false;
		field3500 = new Object();
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

					synchronized(field3500) {
						if ((field3498 || field3499 <= 1) && ArchiveDiskActionHandler_requestQueue.method1960()) {
							field3499 = 0;
							field3500.notifyAll();
							return;
						}

						field3499 = 600;
					}
				} else {
					class13.method44(100L);
					synchronized(field3500) {
						if ((field3498 || field3499 <= 1) && ArchiveDiskActionHandler_requestQueue.method1960()) {
							field3499 = 0;
							field3500.notifyAll();
							return;
						}

						--field3499;
					}
				}
			}
		} catch (Exception var13) {
			class317.RunException_sendStackTrace((String)null, var13);
		}
	}

	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "707019941"
	)
	public static void method1849() {
		FloorUnderlayDefinition.FloorUnderlayDefinition_cached.clear();
	}
}
