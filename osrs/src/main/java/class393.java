import java.util.AbstractQueue;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("pd")
public class class393 extends AbstractQueue {
	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "[Lpa;"
	)
	class391[] field3658;
	@ObfuscatedName("ay")
	Map field3657;
	@ObfuscatedName("ar")
	int field3655;
	@ObfuscatedName("am")
	final Comparator field3659;
	@ObfuscatedName("as")
	int field3656;

	public class393(int var1, Comparator var2) {
		this.field3656 = 0;
		this.field3658 = new class391[var1];
		this.field3657 = new HashMap();
		this.field3659 = var2;
	}

	public class393(int var1) {
		this(var1, (Comparator)null);
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "1737767650"
	)
	void method1988() {
		int var1 = (this.field3658.length << 1) + 1;
		this.field3658 = (class391[])((class391[])Arrays.copyOf(this.field3658, var1));
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(IB)V",
		garbageValue = "22"
	)
	void method1989(int var1) {
		class391 var2;
		int var3;
		for (var2 = this.field3658[var1]; var1 > 0; var1 = var3) {
			var3 = var1 - 1 >>> 1;
			class391 var4 = this.field3658[var3];
			if (this.field3659 != null) {
				if (this.field3659.compare(var2.field3651, var4.field3651) >= 0) {
					break;
				}
			} else if (((Comparable)var2.field3651).compareTo(var4.field3651) >= 0) {
				break;
			}

			this.field3658[var1] = var4;
			this.field3658[var1].field3650 = var1;
		}

		this.field3658[var1] = var2;
		this.field3658[var1].field3650 = var1;
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(IB)V",
		garbageValue = "4"
	)
	void method1990(int var1) {
		class391 var2 = this.field3658[var1];

		int var8;
		for (int var3 = this.field3655 >>> 1; var1 < var3; var1 = var8) {
			int var4 = (var1 << 1) + 1;
			class391 var5 = this.field3658[var4];
			int var6 = (var1 << 1) + 2;
			class391 var7 = this.field3658[var6];
			if (this.field3659 != null) {
				if (var6 < this.field3655 && this.field3659.compare(var5.field3651, var7.field3651) > 0) {
					var8 = var6;
				} else {
					var8 = var4;
				}
			} else if (var6 < this.field3655 && ((Comparable)var5.field3651).compareTo(var7.field3651) > 0) {
				var8 = var6;
			} else {
				var8 = var4;
			}

			if (this.field3659 != null) {
				if (this.field3659.compare(var2.field3651, this.field3658[var8].field3651) <= 0) {
					break;
				}
			} else if (((Comparable)var2.field3651).compareTo(this.field3658[var8].field3651) <= 0) {
				break;
			}

			this.field3658[var1] = this.field3658[var8];
			this.field3658[var1].field3650 = var1;
		}

		this.field3658[var1] = var2;
		this.field3658[var1].field3650 = var1;
	}

	@Export("remove")
	@ObfuscatedName("remove")
	public boolean remove(Object var1) {
		class391 var2 = (class391)this.field3657.remove(var1);
		if (var2 == null) {
			return false;
		} else {
			++this.field3656;
			--this.field3655;
			if (var2.field3650 == this.field3655) {
				this.field3658[this.field3655] = null;
				return true;
			} else {
				class391 var3 = this.field3658[this.field3655];
				this.field3658[this.field3655] = null;
				this.field3658[var2.field3650] = var3;
				this.field3658[var2.field3650].field3650 = var2.field3650;
				this.method1990(var2.field3650);
				if (var3 == this.field3658[var2.field3650]) {
					this.method1989(var2.field3650);
				}

				return true;
			}
		}
	}

	@Export("peek")
	@ObfuscatedName("peek")
	public Object peek() {
		return this.field3655 == 0 ? null : this.field3658[0].field3651;
	}

	@Export("size")
	@ObfuscatedName("size")
	public int size() {
		return this.field3655;
	}

	@Export("offer")
	@ObfuscatedName("offer")
	public boolean offer(Object var1) {
		if (this.field3657.containsKey(var1)) {
			throw new IllegalArgumentException("");
		} else {
			++this.field3656;
			int var2 = this.field3655;
			if (var2 >= this.field3658.length) {
				this.method1988();
			}

			++this.field3655;
			if (var2 == 0) {
				this.field3658[0] = new class391(var1, 0);
				this.field3657.put(var1, this.field3658[0]);
			} else {
				this.field3658[var2] = new class391(var1, var2);
				this.field3657.put(var1, this.field3658[var2]);
				this.method1989(var2);
			}

			return true;
		}
	}

	@Export("poll")
	@ObfuscatedName("poll")
	public Object poll() {
		if (this.field3655 == 0) {
			return null;
		} else {
			++this.field3656;
			Object var1 = this.field3658[0].field3651;
			this.field3657.remove(var1);
			--this.field3655;
			if (this.field3655 == 0) {
				this.field3658[this.field3655] = null;
			} else {
				this.field3658[0] = this.field3658[this.field3655];
				this.field3658[0].field3650 = 0;
				this.field3658[this.field3655] = null;
				this.method1990(0);
			}

			return var1;
		}
	}

	@Export("contains")
	@ObfuscatedName("contains")
	public boolean contains(Object var1) {
		return this.field3657.containsKey(var1);
	}

	@Export("toArray")
	@ObfuscatedName("toArray")
	public Object[] toArray() {
		Object[] var1 = super.toArray();
		if (this.field3659 != null) {
			Arrays.sort(var1, this.field3659);
		} else {
			Arrays.sort(var1);
		}

		return var1;
	}

	@Export("iterator")
	@ObfuscatedName("iterator")
	public Iterator iterator() {
		return new class392(this);
	}

	@ObfuscatedName("jb")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-408081757"
	)
	static final void method1991() {
		for (Projectile var0 = (Projectile)Client.projectiles.last(); var0 != null; var0 = (Projectile)Client.projectiles.previous()) {
			if (var0.plane == class36.Client_plane && Client.cycle <= var0.cycleEnd) {
				if (Client.cycle >= var0.cycleStart) {
					if (var0.targetIndex > 0) {
						NPC var1 = Client.npcs[var0.targetIndex - 1];
						if (var1 != null && var1.x >= 0 && var1.x < 13312 && var1.y >= 0 && var1.y < 13312) {
							var0.setDestination(var1.x, var1.y, class306.getTileHeight(var1.x, var1.y, var0.plane) - var0.endHeight, Client.cycle);
						}
					}

					if (var0.targetIndex < 0) {
						int var2 = -var0.targetIndex - 1;
						Player var3;
						if (var2 == Client.localPlayerIndex) {
							var3 = class136.localPlayer;
						} else {
							var3 = Client.players[var2];
						}

						if (var3 != null && var3.x >= 0 && var3.x < 13312 && var3.y >= 0 && var3.y < 13312) {
							var0.setDestination(var3.x, var3.y, class306.getTileHeight(var3.x, var3.y, var0.plane) - var0.endHeight, Client.cycle);
						}
					}

					var0.advance(Client.field452);
					UserComparator5.scene.drawEntity(class36.Client_plane, (int)var0.x, (int)var0.y, (int)var0.z, 60, var0, var0.yaw, -1L, false);
				}
			} else {
				var0.remove();
			}
		}

	}
}
