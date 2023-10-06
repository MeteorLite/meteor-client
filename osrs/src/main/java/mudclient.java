// Decompiled by Jad v1.5.8c. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

import events.UpdateInventoryPacket;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import org.rationalityfrontline.kevent.Event;
import org.rationalityfrontline.kevent.KEventKt;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.*;
import java.util.HashMap;

@Implements("RSClient")
public final class mudclient extends NetworkedGame {

	//This will be modified via mixins if we are running injected
	public static boolean injected = false;

	private final void method45() {
		if((anInt652 & 1) == 1 && method66(anInt652))
			return;
		if((anInt652 & 1) == 0 && method66(anInt652)) {
			if(method66(anInt652 + 1 & 7)) {
				anInt652 = anInt652 + 1 & 7;
				return;
			}
			if(method66(anInt652 + 7 & 7))
				anInt652 = anInt652 + 7 & 7;
			return;
		}
		int ai[] = {
			1, -1, 2, -2, 3, -3, 4
		};
		for(int i = 0; i < 7; i++) {
			if(!method66(anInt652 + ai[i] + 8 & 7))
				continue;
			anInt652 = anInt652 + ai[i] + 8 & 7;
			break;
		}

		if((anInt652 & 1) == 0 && method66(anInt652)) {
			if(method66(anInt652 + 1 & 7)) {
				anInt652 = anInt652 + 1 & 7;
				return;
			}
			if(method66(anInt652 + 7 & 7))
				anInt652 = anInt652 + 7 & 7;
			return;
		} else {
			return;
		}
	}

	private final void method46() {
		if(anInt653 != 0) {
			for(int i = 0; i < anInt655; i++) {
				if(super.anInt39 >= surface.method212(menuOptions[i], 1) || super.anInt41 <= i * 12 || super.anInt41 >= 12 + i * 12)
					continue;
				super.packetStream.createPacket(116);
				super.packetStream.putByte(i);
				super.packetStream.endPacket();
				break;
			}

			anInt653 = 0;
			aBoolean656 = false;
			return;
		}
		for(int j = 0; j < anInt655; j++) {
			int k = 65535;
			if(super.anInt39 < surface.method212(menuOptions[j], 1) && super.anInt41 > j * 12 && super.anInt41 < 12 + j * 12)
				k = 0xff0000;
			surface.method254(menuOptions[j], 6, 12 + j * 12, 1, k);
		}

	}

	private final void method47() {
		int i = 0;
		byte byte0 = 50;
		byte byte1 = 50;
		world.method399(byte0 * 48 + 23, byte1 * 48 + 23, i);
		world.method402(aModelArray657);
		char c = '\u2600';
		char c1 = '\u1900';
		char c2 = '\u044C';
		char c3 = '\u0378';
		scene.anInt426 = 4100;
		scene.anInt430 = 4100;
		scene.anInt443 = 1;
		scene.anInt442 = 4000;
		scene.method263(c, -world.method410(c, c1), c1, 912, c3, 0, c2 * 2);
		scene.method288();
		surface.method209();
		surface.method209();
		surface.method207(0, 0, 512, 6, 0);
		for(int j = 6; j >= 1; j--)
			surface.method225(0, j, 0, j, 512, 8);

		surface.method207(0, 194, 512, 20, 0);
		for(int k = 6; k >= 1; k--)
			surface.method225(0, k, 0, 194 - k, 512, 8);

		surface.method246(15, 15, anInt658 + 10);
		surface.method252(anInt659, 0, 0, 512, 200);
		surface.method235(anInt659);
		c = '\u2400';
		c1 = '\u2400';
		c2 = '\u044C';
		c3 = '\u0378';
		scene.anInt426 = 4100;
		scene.anInt430 = 4100;
		scene.anInt443 = 1;
		scene.anInt442 = 4000;
		scene.method263(c, -world.method410(c, c1), c1, 912, c3, 0, c2 * 2);
		scene.method288();
		surface.method209();
		surface.method209();
		surface.method207(0, 0, 512, 6, 0);
		for(int l = 6; l >= 1; l--)
			surface.method225(0, l, 0, l, 512, 8);

		surface.method207(0, 194, 512, 20, 0);
		for(int i1 = 6; i1 >= 1; i1--)
			surface.method225(0, i1, 0, 194 - i1, 512, 8);

		surface.method246(15, 15, anInt658 + 10);
		surface.method252(anInt659 + 1, 0, 0, 512, 200);
		surface.method235(anInt659 + 1);
		for(int j1 = 0; j1 < 64; j1++) {
			scene.method271(world.aModelArrayArray598[0][j1]);
			scene.method271(world.aModelArrayArray597[1][j1]);
			scene.method271(world.aModelArrayArray598[1][j1]);
			scene.method271(world.aModelArrayArray597[2][j1]);
			scene.method271(world.aModelArrayArray598[2][j1]);
		}

		c = '\u2B80';
		c1 = '\u2880';
		c2 = '\u01F4';
		c3 = '\u0178';
		scene.anInt426 = 4100;
		scene.anInt430 = 4100;
		scene.anInt443 = 1;
		scene.anInt442 = 4000;
		scene.method263(c, -world.method410(c, c1), c1, 912, c3, 0, c2 * 2);
		scene.method288();
		surface.method209();
		surface.method209();
		surface.method207(0, 0, 512, 6, 0);
		for(int k1 = 6; k1 >= 1; k1--)
			surface.method225(0, k1, 0, k1, 512, 8);

		surface.method207(0, 194, 512, 20, 0);
		for(int l1 = 6; l1 >= 1; l1--)
			surface.method225(0, l1, 0, 194, 512, 8);

		surface.method246(15, 15, anInt658 + 10);
		surface.method252(anInt658 + 10, 0, 0, 512, 200);
		surface.method235(anInt658 + 10);
	}

	final void method48(int i, int j, int k, int l, int i1, int j1, int k1) {
		int l1 = anIntArray660[i1];
		int i2 = teleportBubbleTime[i1];
		if(l1 == 0) {
			int j2 = 255 + i2 * 5 * 256;
			surface.method258(i + k / 2, j + l / 2, 20 + i2 * 2, j2, 255 - i2 * 5);
		}
		if(l1 == 1) {
			int k2 = 0xff0000 + i2 * 5 * 256;
			surface.method258(i + k / 2, j + l / 2, 10 + i2, k2, 255 - i2 * 5);
		}
	}

	private final void method49() {
		anInt663 = anInt662;
		for(int i = 0; i < anInt662; i++) {
			anIntArray664[i] = anIntArray665[i];
			anIntArray666[i] = anIntArray667[i];
		}

		for(int j = 0; j < inventorySize; j++) {
			if(anInt663 >= bankItemsMax)
				break;
			int k = inventoryItemsIDs[j];
			boolean flag = false;
			for(int l = 0; l < anInt663; l++) {
				if(anIntArray664[l] != k)
					continue;
				flag = true;
				break;
			}

			if(!flag) {
				anIntArray664[anInt663] = k;
				anIntArray666[anInt663] = 0;
				anInt663++;
			}
		}

	}

	protected final void method6(int i, int j, int k) {
		anIntArray671[anInt672] = j;
		anIntArray673[anInt672] = k;
		anInt672 = anInt672 + 1 & 0x1fff;
		for(int l = 10; l < 4000; l++) {
			int i1 = anInt672 - l & 0x1fff;
			if(anIntArray671[i1] == j && anIntArray673[i1] == k) {
				boolean flag = false;
				for(int j1 = 1; j1 < l; j1++) {
					int k1 = anInt672 - j1 & 0x1fff;
					int l1 = i1 - j1 & 0x1fff;
					if(anIntArray671[l1] != j || anIntArray673[l1] != k)
						flag = true;
					if(anIntArray671[k1] != anIntArray671[l1] || anIntArray673[k1] != anIntArray673[l1])
						break;
					if(j1 == l - 1 && flag && anInt674 == 0 && anInt675 == 0) {
						method74();
						return;
					}
				}

			}
		}

	}

	private final Model method50(int i, int j, int k, int l, int i1) {
		int j1 = i;
		int k1 = j;
		int l1 = i;
		int i2 = j;
		int j2 = Definitions.anIntArray120[l];
		int k2 = Definitions.anIntArray121[l];
		int l2 = Definitions.anIntArray119[l];
		Model model = new Model(4, 1);
		if(k == 0)
			l1 = i + 1;
		if(k == 1)
			i2 = j + 1;
		if(k == 2) {
			j1 = i + 1;
			i2 = j + 1;
		}
		if(k == 3) {
			l1 = i + 1;
			i2 = j + 1;
		}
		j1 *= anInt676;
		k1 *= anInt676;
		l1 *= anInt676;
		i2 *= anInt676;
		int i3 = model.method198(j1, -world.method410(j1, k1), k1);
		int j3 = model.method198(j1, -world.method410(j1, k1) - l2, k1);
		int k3 = model.method198(l1, -world.method410(l1, i2) - l2, i2);
		int l3 = model.method198(l1, -world.method410(l1, i2), i2);
		int ai[] = {
			i3, j3, k3, l3
		};
		model.method184(4, ai, j2, k2);
		model.method205(false, 60, 24, -50, -10, -50);
		if(i >= 0 && j >= 0 && i < 96 && j < 96)
			scene.method305(model);
		model.anInt228 = i1 + 10000;
		return model;
	}

	final void method51(int i, int j, int k, int l, int i1, int j1, int k1) {
		RsCharacter rscharacter = aRsCharacterArray677[i1];
		int l1 = rscharacter.anInt153 + (anInt678 + 16) / 32 & 7;
		boolean flag = false;
		int i2 = l1;
		if(i2 == 5) {
			i2 = 3;
			flag = true;
		} else
		if(i2 == 6) {
			i2 = 2;
			flag = true;
		} else
		if(i2 == 7) {
			i2 = 1;
			flag = true;
		}
		int j2 = i2 * 3 + anIntArray679[(rscharacter.anInt152 / Definitions.anIntArray91[rscharacter.anInt151]) % 4];
		if(rscharacter.anInt153 == 8) {
			i2 = 5;
			l1 = 2;
			flag = false;
			i -= (Definitions.anIntArray93[rscharacter.anInt151] * k1) / 100;
			j2 = i2 * 3 + anIntArray680[(anInt681 / (Definitions.anIntArray92[rscharacter.anInt151] - 1)) % 8];
		} else
		if(rscharacter.anInt153 == 9) {
			i2 = 5;
			l1 = 2;
			flag = true;
			i += (Definitions.anIntArray93[rscharacter.anInt151] * k1) / 100;
			j2 = i2 * 3 + anIntArray682[(anInt681 / Definitions.anIntArray92[rscharacter.anInt151]) % 8];
		}
		for(int k2 = 0; k2 < 12; k2++) {
			int l2 = anIntArrayArray683[l1][k2];
			int k3 = Definitions.anIntArrayArray84[rscharacter.anInt151][l2];
			if(k3 >= 0) {
				int i4 = 0;
				int j4 = 0;
				int k4 = j2;
				if(flag && i2 >= 1 && i2 <= 3 && Definitions.anIntArray102[k3] == 1)
					k4 += 15;
				if(i2 != 5 || Definitions.anIntArray101[k3] == 1) {
					int l4 = k4 + Definitions.anIntArray103[k3];
					i4 = (i4 * k) / ((Surface) (surface)).anIntArray331[l4];
					j4 = (j4 * l) / ((Surface) (surface)).anIntArray332[l4];
					int i5 = (k * ((Surface) (surface)).anIntArray331[l4]) / ((Surface) (surface)).anIntArray331[Definitions.anIntArray103[k3]];
					i4 -= (i5 - k) / 2;
					int j5 = Definitions.anIntArray99[k3];
					int k5 = 0;
					if(j5 == 1) {
						j5 = Definitions.anIntArray85[rscharacter.anInt151];
						k5 = Definitions.anIntArray88[rscharacter.anInt151];
					} else
					if(j5 == 2) {
						j5 = Definitions.anIntArray86[rscharacter.anInt151];
						k5 = Definitions.anIntArray88[rscharacter.anInt151];
					} else
					if(j5 == 3) {
						j5 = Definitions.anIntArray87[rscharacter.anInt151];
						k5 = Definitions.anIntArray88[rscharacter.anInt151];
					}
					surface.method221(i + i4, j + j4, i5, l, l4, j5, k5, j1, flag);
				}
			}
		}

		if(rscharacter.anInt158 > 0) {
			recievedMessageMidPoint[anInt685] = surface.method212(rscharacter.aString157, 1) / 2;
			if(recievedMessageMidPoint[anInt685] > 150)
				recievedMessageMidPoint[anInt685] = 150;
			revievedMessageHeight[anInt685] = (surface.method212(rscharacter.aString157, 1) / 300) * surface.method238(1);
			receivedMessageX[anInt685] = i + k / 2;
			receivedMessageY[anInt685] = j;
			aStringArray689[anInt685++] = rscharacter.aString157;
		}
		if(rscharacter.anInt153 == 8 || rscharacter.anInt153 == 9 || rscharacter.anInt164 != 0) {
			if(rscharacter.anInt164 > 0) {
				int i3 = i;
				if(rscharacter.anInt153 == 8)
					i3 -= (20 * k1) / 100;
				else
				if(rscharacter.anInt153 == 9)
					i3 += (20 * k1) / 100;
				int l3 = (rscharacter.anInt162 * 30) / rscharacter.anInt163;
				anIntArray690[anInt691] = i3 + k / 2;
				anIntArray692[anInt691] = j;
				anIntArray693[anInt691++] = l3;
			}
			if(rscharacter.anInt164 > 150) {
				int j3 = i;
				if(rscharacter.anInt153 == 8)
					j3 -= (10 * k1) / 100;
				else
				if(rscharacter.anInt153 == 9)
					j3 += (10 * k1) / 100;
				surface.method246((j3 + k / 2) - 12, (j + l / 2) - 12, anInt658 + 12);
				surface.method216(String.valueOf(rscharacter.anInt161), (j3 + k / 2) - 1, j + l / 2 + 5, 3, 0xffffff);
			}
		}
	}

	final void method52(int i, int j, int k, int l, int i1, int j1, int k1) {
		RsCharacter rscharacter = aRsCharacterArray694[i1];
		if(rscharacter.anInt167 == 255)
			return;
		int l1 = rscharacter.anInt153 + (anInt678 + 16) / 32 & 7;
		boolean flag = false;
		int i2 = l1;
		if(i2 == 5) {
			i2 = 3;
			flag = true;
		} else
		if(i2 == 6) {
			i2 = 2;
			flag = true;
		} else
		if(i2 == 7) {
			i2 = 1;
			flag = true;
		}
		int j2 = i2 * 3 + anIntArray679[(rscharacter.anInt152 / 6) % 4];
		if(rscharacter.anInt153 == 8) {
			i2 = 5;
			l1 = 2;
			flag = false;
			i -= (5 * k1) / 100;
			j2 = i2 * 3 + anIntArray680[(anInt681 / 5) % 8];
		} else
		if(rscharacter.anInt153 == 9) {
			i2 = 5;
			l1 = 2;
			flag = true;
			i += (5 * k1) / 100;
			j2 = i2 * 3 + anIntArray682[(anInt681 / 6) % 8];
		}
		for(int k2 = 0; k2 < 12; k2++) {
			int l2 = anIntArrayArray683[l1][k2];
			int l3 = rscharacter.anIntArray176[l2] - 1;
			if(l3 >= 0) {
				int k4 = 0;
				int i5 = 0;
				int j5 = j2;
				if(flag && i2 >= 1 && i2 <= 3)
					if(Definitions.anIntArray102[l3] == 1)
						j5 += 15;
					else
					if(l2 == 4 && i2 == 1) {
						k4 = -22;
						i5 = -3;
						j5 = i2 * 3 + anIntArray679[(2 + rscharacter.anInt152 / 6) % 4];
					} else
					if(l2 == 4 && i2 == 2) {
						k4 = 0;
						i5 = -8;
						j5 = i2 * 3 + anIntArray679[(2 + rscharacter.anInt152 / 6) % 4];
					} else
					if(l2 == 4 && i2 == 3) {
						k4 = 26;
						i5 = -5;
						j5 = i2 * 3 + anIntArray679[(2 + rscharacter.anInt152 / 6) % 4];
					} else
					if(l2 == 3 && i2 == 1) {
						k4 = 22;
						i5 = 3;
						j5 = i2 * 3 + anIntArray679[(2 + rscharacter.anInt152 / 6) % 4];
					} else
					if(l2 == 3 && i2 == 2) {
						k4 = 0;
						i5 = 8;
						j5 = i2 * 3 + anIntArray679[(2 + rscharacter.anInt152 / 6) % 4];
					} else
					if(l2 == 3 && i2 == 3) {
						k4 = -26;
						i5 = 5;
						j5 = i2 * 3 + anIntArray679[(2 + rscharacter.anInt152 / 6) % 4];
					}
				if(i2 != 5 || Definitions.anIntArray101[l3] == 1) {
					int k5 = j5 + Definitions.anIntArray103[l3];
					k4 = (k4 * k) / ((Surface) (surface)).anIntArray331[k5];
					i5 = (i5 * l) / ((Surface) (surface)).anIntArray332[k5];
					int l5 = (k * ((Surface) (surface)).anIntArray331[k5]) / ((Surface) (surface)).anIntArray331[Definitions.anIntArray103[l3]];
					k4 -= (l5 - k) / 2;
					int i6 = Definitions.anIntArray99[l3];
					int j6 = anIntArray695[rscharacter.anInt168];
					if(i6 == 1)
						i6 = anIntArray696[rscharacter.anInt165];
					else
					if(i6 == 2)
						i6 = anIntArray697[rscharacter.anInt166];
					else
					if(i6 == 3)
						i6 = anIntArray697[rscharacter.anInt167];
					surface.method221(i + k4, j + i5, l5, l, k5, i6, j6, j1, flag);
				}
			}
		}

		if(rscharacter.anInt158 > 0) {
			recievedMessageMidPoint[anInt685] = surface.method212(rscharacter.aString157, 1) / 2;
			if(recievedMessageMidPoint[anInt685] > 150)
				recievedMessageMidPoint[anInt685] = 150;
			revievedMessageHeight[anInt685] = (surface.method212(rscharacter.aString157, 1) / 300) * surface.method238(1);
			receivedMessageX[anInt685] = i + k / 2;
			receivedMessageY[anInt685] = j;
			aStringArray689[anInt685++] = rscharacter.aString157;
		}
		if(rscharacter.anInt160 > 0) {
			anIntArray698[anInt699] = i + k / 2;
			anIntArray700[anInt699] = j;
			anIntArray701[anInt699] = k1;
			anIntArray702[anInt699++] = rscharacter.anInt159;
		}
		if(rscharacter.anInt153 == 8 || rscharacter.anInt153 == 9 || rscharacter.anInt164 != 0) {
			if(rscharacter.anInt164 > 0) {
				int i3 = i;
				if(rscharacter.anInt153 == 8)
					i3 -= (20 * k1) / 100;
				else
				if(rscharacter.anInt153 == 9)
					i3 += (20 * k1) / 100;
				int i4 = (rscharacter.anInt162 * 30) / rscharacter.anInt163;
				anIntArray690[anInt691] = i3 + k / 2;
				anIntArray692[anInt691] = j;
				anIntArray693[anInt691++] = i4;
			}
			if(rscharacter.anInt164 > 150) {
				int j3 = i;
				if(rscharacter.anInt153 == 8)
					j3 -= (10 * k1) / 100;
				else
				if(rscharacter.anInt153 == 9)
					j3 += (10 * k1) / 100;
				surface.method246((j3 + k / 2) - 12, (j + l / 2) - 12, anInt658 + 11);
				surface.method216(String.valueOf(rscharacter.anInt161), (j3 + k / 2) - 1, j + l / 2 + 5, 3, 0xffffff);
			}
		}
		if(rscharacter.anInt173 == 1 && rscharacter.anInt160 == 0) {
			int k3 = j1 + i + k / 2;
			if(rscharacter.anInt153 == 8)
				k3 -= (20 * k1) / 100;
			else
			if(rscharacter.anInt153 == 9)
				k3 += (20 * k1) / 100;
			int j4 = (16 * k1) / 100;
			int l4 = (16 * k1) / 100;
			surface.method245(k3 - j4 / 2, j - l4 / 2 - (10 * k1) / 100, j4, l4, anInt658 + 13);
		}
	}

	protected final void method9() {
		if(aBoolean703)
			return;
		if(aBoolean704)
			return;
		if(aBoolean705)
			return;
		try {
			anInt681++;
			if(loggedIn == 0) {
				super.anInt25 = 0;
				doCycleLoggedOut();
			}
			if(loggedIn == 1) {
				super.anInt25++;
				method119();
			}
			super.anInt43 = 0;
			super.anInt24 = 0;
			anInt707++;
			if(anInt707 > 500) {
				anInt707 = 0;
				int i = (int)(Math.random() * 4D);
				if((i & 1) == 1)
					anInt708 += cameraRotationXIncrement;
				if((i & 2) == 2)
					anInt710 += anInt711;
			}
			if(anInt708 < -50)
				cameraRotationXIncrement = 2;
			if(anInt708 > 50)
				cameraRotationXIncrement = -2;
			if(anInt710 < -50)
				anInt711 = 2;
			if(anInt710 > 50)
				anInt711 = -2;
			if(anInt712 > 0)
				anInt712--;
			if(anInt713 > 0)
				anInt713--;
			if(anInt714 > 0)
				anInt714--;
			if(anInt715 > 0) {
				anInt715--;
				return;
			}
		}
		catch(OutOfMemoryError _ex) {
			method88();
			aBoolean704 = true;
		}
	}

	private final RsCharacter method53(int i, int j, int k, int l, int i1) {
		if(aRsCharacterArray716[i] == null) {
			aRsCharacterArray716[i] = new RsCharacter();
			aRsCharacterArray716[i].anInt147 = i;
		}
		RsCharacter rscharacter = aRsCharacterArray716[i];
		boolean flag = false;
		for(int j1 = 0; j1 < anInt718; j1++) {
			if(aRsCharacterArray717[j1].anInt147 != i)
				continue;
			flag = true;
			break;
		}

		if(flag) {
			rscharacter.anInt151 = i1;
			rscharacter.anInt154 = l;
			int k1 = rscharacter.anInt156;
			if(j != rscharacter.anIntArray174[k1] || k != rscharacter.anIntArray175[k1]) {
				rscharacter.anInt156 = k1 = (k1 + 1) % 10;
				rscharacter.anIntArray174[k1] = j;
				rscharacter.anIntArray175[k1] = k;
			}
		} else {
			rscharacter.anInt147 = i;
			rscharacter.anInt155 = 0;
			rscharacter.anInt156 = 0;
			rscharacter.anIntArray174[0] = rscharacter.anInt149 = j;
			rscharacter.anIntArray175[0] = rscharacter.anInt150 = k;
			rscharacter.anInt151 = i1;
			rscharacter.anInt154 = rscharacter.anInt153 = l;
			rscharacter.anInt152 = 0;
		}
		aRsCharacterArray677[npcCount++] = rscharacter;
		return rscharacter;
	}

	private final void method54() {
		if(anInt653 != 0) {
			for(int i = 0; i < anInt724; i++) {
				int k = anInt720 + 2;
				int i1 = anInt721 + 27 + i * 15;
				if(super.anInt39 <= k - 2 || super.anInt41 <= i1 - 12 || super.anInt41 >= i1 + 4 || super.anInt39 >= (k - 3) + anInt722)
					continue;
				menuAction(menuIdxs[i]);
				break;
			}

			anInt653 = 0;
			aBoolean725 = false;
			return;
		}
		if(super.anInt39 < anInt720 - 10 || super.anInt41 < anInt721 - 10 || super.anInt39 > anInt720 + anInt722 + 10 || super.anInt41 > anInt721 + anInt726 + 10) {
			aBoolean725 = false;
			return;
		}
		surface.method224(anInt720, anInt721, anInt722, anInt726, 0xd0d0d0, 160);
		surface.method254("Choose option", anInt720 + 2, anInt721 + 12, 1, 65535);
		for(int j = 0; j < anInt724; j++) {
			int l = anInt720 + 2;
			int j1 = anInt721 + 27 + j * 15;
			int k1 = 0xffffff;
			if(super.anInt39 > l - 2 && super.anInt41 > j1 - 12 && super.anInt41 < j1 + 4 && super.anInt39 < (l - 3) + anInt722)
				k1 = 0xffff00;
			surface.method254(aStringArray727[menuIdxs[j]] + " " + aStringArray728[menuIdxs[j]], l, j1, 1, k1);
		}

	}

	private static final String method55(int i) {
		String s = String.valueOf(i);
		for(int j = s.length() - 3; j > 0; j -= 3)
			s = s.substring(0, j) + "," + s.substring(j);

		if(s.length() > 8)
			s = "@gre@" + s.substring(0, s.length() - 8) + " million @whi@(" + s + ")";
		else
		if(s.length() > 4)
			s = "@cya@" + s.substring(0, s.length() - 4) + "K @whi@(" + s + ")";
		return s;
	}

	private final void method56() {
		aPanel729.method142(super.anInt39, super.anInt41, super.anInt43, super.anInt42);
		if(aPanel729.method159(anInt730))
			do
				anInt731 = ((anInt731 - 1) + Definitions.anInt97) % Definitions.anInt97;
			while((Definitions.anIntArray100[anInt731] & 3) != 1 || (Definitions.anIntArray100[anInt731] & 4 * anInt732) == 0);
		if(aPanel729.method159(anInt733))
			do
				anInt731 = (anInt731 + 1) % Definitions.anInt97;
			while((Definitions.anIntArray100[anInt731] & 3) != 1 || (Definitions.anIntArray100[anInt731] & 4 * anInt732) == 0);
		if(aPanel729.method159(anInt734))
			anInt735 = ((anInt735 - 1) + anIntArray696.length) % anIntArray696.length;
		if(aPanel729.method159(anInt736))
			anInt735 = (anInt735 + 1) % anIntArray696.length;
		if(aPanel729.method159(anInt737) || aPanel729.method159(anInt738)) {
			for(anInt732 = 3 - anInt732; (Definitions.anIntArray100[anInt731] & 3) != 1 || (Definitions.anIntArray100[anInt731] & 4 * anInt732) == 0; anInt731 = (anInt731 + 1) % Definitions.anInt97);
			for(; (Definitions.anIntArray100[anInt739] & 3) != 2 || (Definitions.anIntArray100[anInt739] & 4 * anInt732) == 0; anInt739 = (anInt739 + 1) % Definitions.anInt97);
		}
		if(aPanel729.method159(anInt740))
			anInt741 = ((anInt741 - 1) + anIntArray697.length) % anIntArray697.length;
		if(aPanel729.method159(anInt742))
			anInt741 = (anInt741 + 1) % anIntArray697.length;
		if(aPanel729.method159(anInt743))
			anInt744 = ((anInt744 - 1) + anIntArray695.length) % anIntArray695.length;
		if(aPanel729.method159(anInt745))
			anInt744 = (anInt744 + 1) % anIntArray695.length;
		if(aPanel729.method159(anInt746))
			anInt747 = ((anInt747 - 1) + anIntArray697.length) % anIntArray697.length;
		if(aPanel729.method159(anInt748))
			anInt747 = (anInt747 + 1) % anIntArray697.length;
		if(aPanel729.method159(anInt749)) {
			super.packetStream.createPacket(235);
			super.packetStream.putByte(anInt732);
			super.packetStream.putByte(anInt731);
			super.packetStream.putByte(anInt739);
			super.packetStream.putByte(anInt750);
			super.packetStream.putByte(anInt735);
			super.packetStream.putByte(anInt741);
			super.packetStream.putByte(anInt747);
			super.packetStream.putByte(anInt744);
			super.packetStream.endPacket();
			surface.method244();
			aBoolean751 = false;
		}
	}

	private final void method57(int i, int j, int k) {
		surface.method247(i, j, k);
		surface.method247(i - 1, j, k);
		surface.method247(i + 1, j, k);
		surface.method247(i, j - 1, k);
		surface.method247(i, j + 1, k);
	}

	private final void method58(int i, int j, int k) {
		if(k == 0) {
			method69(sceneX, sceneY, i, j - 1, i, j, false, true);
			return;
		}
		if(k == 1) {
			method69(sceneX, sceneY, i - 1, j, i, j, false, true);
			return;
		} else {
			method69(sceneX, sceneY, i, j, i, j, true, true);
			return;
		}
	}

	private final void method59(int i, int j, int k, int l) {
		int i1;
		int j1;
		if(k == 0 || k == 4) {
			i1 = Definitions.anIntArray110[l];
			j1 = Definitions.anIntArray111[l];
		} else {
			j1 = Definitions.anIntArray110[l];
			i1 = Definitions.anIntArray111[l];
		}
		if(Definitions.anIntArray112[l] == 2 || Definitions.anIntArray112[l] == 3) {
			if(k == 0) {
				i--;
				i1++;
			}
			if(k == 2)
				j1++;
			if(k == 4)
				i1++;
			if(k == 6) {
				j--;
				j1++;
			}
			method69(sceneX, sceneY, i, j, (i + i1) - 1, (j + j1) - 1, false, true);
			return;
		} else {
			method69(sceneX, sceneY, i, j, (i + i1) - 1, (j + j1) - 1, true, true);
			return;
		}
	}

	private final void method60(boolean flag) {
		int i = ((Surface) (surface)).anInt320 - 199;
		char c = '\234';
		char c2 = '\230';
		surface.method246(i - 49, 3, anInt658 + 2);
		i += 40;
		surface.method207(i, 36, c, c2, 0);
		surface.method253(i, 36, i + c, 36 + c2);
		int k = 192 + anInt754;
		int i1 = anInt678 + anInt755 & 0xff;
		int k1 = ((localPlayer.anInt149 - 6040) * 3 * k) / 2048;
		int i3 = ((localPlayer.anInt150 - 6040) * 3 * k) / 2048;
		int k4 = Scene.anIntArray382[1024 - i1 * 4 & 0x3ff];
		int i5 = Scene.anIntArray382[(1024 - i1 * 4 & 0x3ff) + 1024];
		int k5 = i3 * k4 + k1 * i5 >> 18;
		i3 = i3 * i5 - k1 * k4 >> 18;
		k1 = k5;
		surface.method236((i + c / 2) - k1, 36 + c2 / 2 + i3, anInt658 - 1, i1 + 64 & 0xff, k);
		for(int i7 = 0; i7 < anInt759; i7++) {
			int l1 = (((anIntArray757[i7] * anInt676 + 64) - localPlayer.anInt149) * 3 * k) / 2048;
			int j3 = (((anIntArray758[i7] * anInt676 + 64) - localPlayer.anInt150) * 3 * k) / 2048;
			int l5 = j3 * k4 + l1 * i5 >> 18;
			j3 = j3 * i5 - l1 * k4 >> 18;
			l1 = l5;
			method57(i + c / 2 + l1, (36 + c2 / 2) - j3, 65535);
		}

		for(int j7 = 0; j7 < anInt762; j7++) {
			int i2 = (((anIntArray760[j7] * anInt676 + 64) - localPlayer.anInt149) * 3 * k) / 2048;
			int k3 = (((anIntArray761[j7] * anInt676 + 64) - localPlayer.anInt150) * 3 * k) / 2048;
			int i6 = k3 * k4 + i2 * i5 >> 18;
			k3 = k3 * i5 - i2 * k4 >> 18;
			i2 = i6;
			method57(i + c / 2 + i2, (36 + c2 / 2) - k3, 0xff0000);
		}

		for(int k7 = 0; k7 < npcCount; k7++) {
			RsCharacter rscharacter = aRsCharacterArray677[k7];
			int j2 = ((rscharacter.anInt149 - localPlayer.anInt149) * 3 * k) / 2048;
			int l3 = ((rscharacter.anInt150 - localPlayer.anInt150) * 3 * k) / 2048;
			int j6 = l3 * k4 + j2 * i5 >> 18;
			l3 = l3 * i5 - j2 * k4 >> 18;
			j2 = j6;
			method57(i + c / 2 + j2, (36 + c2 / 2) - l3, 0xffff00);
		}

		for(int l7 = 0; l7 < playerCount; l7++) {
			RsCharacter rscharacter1 = aRsCharacterArray694[l7];
			int k2 = ((rscharacter1.anInt149 - localPlayer.anInt149) * 3 * k) / 2048;
			int i4 = ((rscharacter1.anInt150 - localPlayer.anInt150) * 3 * k) / 2048;
			int k6 = i4 * k4 + k2 * i5 >> 18;
			i4 = i4 * i5 - k2 * k4 >> 18;
			k2 = k6;
			int j8 = 0xffffff;
			for(int k8 = 0; k8 < super.anInt603; k8++) {
				if(rscharacter1.aLong145 != super.aLongArray602[k8] || super.anIntArray604[k8] != 255)
					continue;
				j8 = 65280;
				break;
			}

			method57(i + c / 2 + k2, (36 + c2 / 2) - i4, j8);
		}

		surface.method258(i + c / 2, 36 + c2 / 2, 2, 0xffffff, 255);
		surface.method236(i + 19, 55, anInt658 + 24, anInt678 + 128 & 0xff, 128);
		surface.method253(0, 0, anInt764, anInt765 + 12);
		if(!flag)
			return;
		i = super.anInt39 - (((Surface) (surface)).anInt320 - 199);
		int i8 = super.anInt41 - 36;
		if(i >= 40 && i8 >= 0 && i < 196 && i8 < 152) {
			char c1 = '\234';
			char c3 = '\230';
			int l = 192 + anInt754;
			int j1 = anInt678 + anInt755 & 0xff;
			int j = ((Surface) (surface)).anInt320 - 199;
			j += 40;
			int l2 = ((super.anInt39 - (j + c1 / 2)) * 16384) / (3 * l);
			int j4 = ((super.anInt41 - (36 + c3 / 2)) * 16384) / (3 * l);
			int l4 = Scene.anIntArray382[1024 - j1 * 4 & 0x3ff];
			int j5 = Scene.anIntArray382[(1024 - j1 * 4 & 0x3ff) + 1024];
			int l6 = j4 * l4 + l2 * j5 >> 15;
			j4 = j4 * j5 - l2 * l4 >> 15;
			l2 = l6;
			l2 += localPlayer.anInt149;
			j4 = localPlayer.anInt150 - j4;
			if(anInt653 == 1)
				method106(sceneX, sceneY, l2 / 128, j4 / 128, false);
			anInt653 = 0;
		}
	}

	private final void doCycleLoggedOut() {
		if(super.anInt618 > 0)
			super.anInt618--;
		if(loginState == 0) {
			aPanel767.method142(super.anInt39, super.anInt41, super.anInt43, super.anInt42);
			if(aPanel767.method159(anInt768))
				loginState = 1;
			if(aPanel767.method159(anInt769)) {
				loginState = 2;
				aPanel770.method168(anInt771, "Please enter your username and password");
				aPanel770.method168(anInt772, "");
				aPanel770.method168(anInt773, "");
				aPanel770.method170(anInt772);
				return;
			}
		} else
		if(loginState == 1) {
			aPanel774.method142(super.anInt39, super.anInt41, super.anInt43, super.anInt42);
			if(aPanel774.method159(anInt775)) {
				loginState = 0;
				return;
			}
		} else
		if(loginState == 2) {
			aPanel770.method142(super.anInt39, super.anInt41, super.anInt43, super.anInt42);
			if(aPanel770.method159(anInt776))
				loginState = 0;
			if(aPanel770.method159(anInt772))
				aPanel770.method170(anInt773);
			if(aPanel770.method159(anInt773) || aPanel770.method159(anInt777)) {
				aString778 = aPanel770.method166(anInt772);
				aString779 = aPanel770.method166(anInt773);
				method39(aString778, aString779, false);
			}
		}
	}

	private final void method62() {
		if(showUiTab == 0 && super.anInt39 >= ((Surface) (surface)).anInt320 - 35 && super.anInt41 >= 3 && super.anInt39 < ((Surface) (surface)).anInt320 - 3 && super.anInt41 < 35)
			showUiTab = 1;
		if(showUiTab == 0 && super.anInt39 >= ((Surface) (surface)).anInt320 - 35 - 33 && super.anInt41 >= 3 && super.anInt39 < ((Surface) (surface)).anInt320 - 3 - 33 && super.anInt41 < 35) {
			showUiTab = 2;
			anInt755 = (int)(Math.random() * 13D) - 6;
			anInt754 = (int)(Math.random() * 23D) - 11;
		}
		if(showUiTab == 0 && super.anInt39 >= ((Surface) (surface)).anInt320 - 35 - 66 && super.anInt41 >= 3 && super.anInt39 < ((Surface) (surface)).anInt320 - 3 - 66 && super.anInt41 < 35)
			showUiTab = 3;
		if(showUiTab == 0 && super.anInt39 >= ((Surface) (surface)).anInt320 - 35 - 99 && super.anInt41 >= 3 && super.anInt39 < ((Surface) (surface)).anInt320 - 3 - 99 && super.anInt41 < 35)
			showUiTab = 4;
		if(showUiTab == 0 && super.anInt39 >= ((Surface) (surface)).anInt320 - 35 - 132 && super.anInt41 >= 3 && super.anInt39 < ((Surface) (surface)).anInt320 - 3 - 132 && super.anInt41 < 35)
			showUiTab = 5;
		if(showUiTab == 0 && super.anInt39 >= ((Surface) (surface)).anInt320 - 35 - 165 && super.anInt41 >= 3 && super.anInt39 < ((Surface) (surface)).anInt320 - 3 - 165 && super.anInt41 < 35)
			showUiTab = 6;
		if(showUiTab != 0 && super.anInt39 >= ((Surface) (surface)).anInt320 - 35 && super.anInt41 >= 3 && super.anInt39 < ((Surface) (surface)).anInt320 - 3 && super.anInt41 < 26)
			showUiTab = 1;
		if(showUiTab != 0 && showUiTab != 2 && super.anInt39 >= ((Surface) (surface)).anInt320 - 35 - 33 && super.anInt41 >= 3 && super.anInt39 < ((Surface) (surface)).anInt320 - 3 - 33 && super.anInt41 < 26) {
			showUiTab = 2;
			anInt755 = (int)(Math.random() * 13D) - 6;
			anInt754 = (int)(Math.random() * 23D) - 11;
		}
		if(showUiTab != 0 && super.anInt39 >= ((Surface) (surface)).anInt320 - 35 - 66 && super.anInt41 >= 3 && super.anInt39 < ((Surface) (surface)).anInt320 - 3 - 66 && super.anInt41 < 26)
			showUiTab = 3;
		if(showUiTab != 0 && super.anInt39 >= ((Surface) (surface)).anInt320 - 35 - 99 && super.anInt41 >= 3 && super.anInt39 < ((Surface) (surface)).anInt320 - 3 - 99 && super.anInt41 < 26)
			showUiTab = 4;
		if(showUiTab != 0 && super.anInt39 >= ((Surface) (surface)).anInt320 - 35 - 132 && super.anInt41 >= 3 && super.anInt39 < ((Surface) (surface)).anInt320 - 3 - 132 && super.anInt41 < 26)
			showUiTab = 5;
		if(showUiTab != 0 && super.anInt39 >= ((Surface) (surface)).anInt320 - 35 - 165 && super.anInt41 >= 3 && super.anInt39 < ((Surface) (surface)).anInt320 - 3 - 165 && super.anInt41 < 26)
			showUiTab = 6;
		if(showUiTab == 1 && (super.anInt39 < ((Surface) (surface)).anInt320 - 248 || super.anInt41 > 36 + (inventoryMaxItemCount / 5) * 34))
			showUiTab = 0;
		if(showUiTab == 3 && (super.anInt39 < ((Surface) (surface)).anInt320 - 199 || super.anInt41 > 316))
			showUiTab = 0;
		if((showUiTab == 2 || showUiTab == 4 || showUiTab == 5) && (super.anInt39 < ((Surface) (surface)).anInt320 - 199 || super.anInt41 > 240))
			showUiTab = 0;
		if(showUiTab == 6 && (super.anInt39 < ((Surface) (surface)).anInt320 - 199 || super.anInt41 > 311))
			showUiTab = 0;
	}

	protected final byte[] readDataFile(String s, String s1, int i) {
		if(!aBoolean782)
			s = "data/" + s;
		byte abyte0[] = link.getjag(s);
		if(abyte0 != null) {
			int j = ((abyte0[0] & 0xff) << 16) + ((abyte0[1] & 0xff) << 8) + (abyte0[2] & 0xff);
			int k = ((abyte0[3] & 0xff) << 16) + ((abyte0[4] & 0xff) << 8) + (abyte0[5] & 0xff);
			byte abyte1[] = new byte[abyte0.length - 6];
			for(int l = 0; l < abyte0.length - 6; l++)
				abyte1[l] = abyte0[l + 6];

			method1(i, "Unpacking " + s1);
			if(k != j) {
				byte abyte2[] = new byte[j];
				BZip2Decompressor.method133(abyte2, j, abyte1, k, 0);
				return abyte2;
			} else {
				return abyte1;
			}
		} else {
			return super.readDataFile(s, s1, i);
		}
	}

	private final void method64() {
		for(int i = 0; i < anInt685; i++) {
			int j = surface.method238(1);
			int l = receivedMessageX[i];
			int k1 = receivedMessageY[i];
			int j2 = recievedMessageMidPoint[i];
			int i3 = revievedMessageHeight[i];
			boolean flag = true;
			while(flag)  {
				flag = false;
				for(int i4 = 0; i4 < i; i4++)
					if(k1 + i3 > receivedMessageY[i4] - j && k1 - j < receivedMessageY[i4] + revievedMessageHeight[i4] && l - j2 < receivedMessageX[i4] + recievedMessageMidPoint[i4] && l + j2 > receivedMessageX[i4] - recievedMessageMidPoint[i4] && receivedMessageY[i4] - j - i3 < k1) {
						k1 = receivedMessageY[i4] - j - i3;
						flag = true;
					}

			}
			receivedMessageY[i] = k1;
			surface.method239(aStringArray689[i], l, k1, 1, 0xffff00, 300);
		}

		for(int k = 0; k < anInt699; k++) {
			int i1 = anIntArray698[k];
			int l1 = anIntArray700[k];
			int k2 = anIntArray701[k];
			int j3 = anIntArray702[k];
			int l3 = (39 * k2) / 100;
			int j4 = (27 * k2) / 100;
			int k4 = l1 - j4;
			surface.method262(i1 - l3 / 2, k4, l3, j4, anInt658 + 9, 85);
			int l4 = (36 * k2) / 100;
			int i5 = (24 * k2) / 100;
			surface.method221(i1 - l4 / 2, (k4 + j4 / 2) - i5 / 2, l4, i5, Definitions.anIntArray66[j3] + anInt786, Definitions.anIntArray71[j3], 0, 0, false);
		}

		for(int j1 = 0; j1 < anInt691; j1++) {
			int i2 = anIntArray690[j1];
			int l2 = anIntArray692[j1];
			int k3 = anIntArray693[j1];
			surface.method224(i2 - 15, l2 - 3, k3, 5, 65280, 192);
			surface.method224((i2 - 15) + k3, l2 - 3, 30 - k3, 5, 0xff0000, 192);
		}

	}

	private final void method65(int i, String s) {
		int j = anIntArray757[i];
		int k = anIntArray758[i];
		int l = j - localPlayer.anInt149 / 128;
		int i1 = k - localPlayer.anInt150 / 128;
		byte byte0 = 7;
		if(j >= 0 && k >= 0 && j < 96 && k < 96 && l > -byte0 && l < byte0 && i1 > -byte0 && i1 < byte0) {
			scene.method271(aModelArray787[i]);
			int j1 = Definitions.method127(s);
			Model model = aModelArray657[j1].method181();
			scene.method305(model);
			model.method205(true, 48, 48, -50, -10, -50);
			model.method195(aModelArray787[i]);
			model.anInt228 = i;
			aModelArray787[i] = model;
		}
	}

	private final boolean method66(int i) {
		int j = localPlayer.anInt149 / 128;
		int k = localPlayer.anInt150 / 128;
		for(int l = 2; l >= 1; l--) {
			if(i == 1 && ((world.anIntArrayArray573[j][k - l] & 0x80) == 128 || (world.anIntArrayArray573[j - l][k] & 0x80) == 128 || (world.anIntArrayArray573[j - l][k - l] & 0x80) == 128))
				return false;
			if(i == 3 && ((world.anIntArrayArray573[j][k + l] & 0x80) == 128 || (world.anIntArrayArray573[j - l][k] & 0x80) == 128 || (world.anIntArrayArray573[j - l][k + l] & 0x80) == 128))
				return false;
			if(i == 5 && ((world.anIntArrayArray573[j][k + l] & 0x80) == 128 || (world.anIntArrayArray573[j + l][k] & 0x80) == 128 || (world.anIntArrayArray573[j + l][k + l] & 0x80) == 128))
				return false;
			if(i == 7 && ((world.anIntArrayArray573[j][k - l] & 0x80) == 128 || (world.anIntArrayArray573[j + l][k] & 0x80) == 128 || (world.anIntArrayArray573[j + l][k - l] & 0x80) == 128))
				return false;
			if(i == 0 && (world.anIntArrayArray573[j][k - l] & 0x80) == 128)
				return false;
			if(i == 2 && (world.anIntArrayArray573[j - l][k] & 0x80) == 128)
				return false;
			if(i == 4 && (world.anIntArrayArray573[j][k + l] & 0x80) == 128)
				return false;
			if(i == 6 && (world.anIntArrayArray573[j + l][k] & 0x80) == 128)
				return false;
		}

		return true;
	}

	private final void method67() {
		char c = '\u0190';
		char c1 = 'd';
		if(aBoolean788) {
			c1 = '\u01C2';
			c1 = '\u012C';
		}
		surface.method207(256 - c / 2, 167 - c1 / 2, c, c1, 0);
		surface.method214(256 - c / 2, 167 - c1 / 2, c, c1, 0xffffff);
		surface.method239(aString789, 256, (167 - c1 / 2) + 20, 1, 0xffffff, c - 40);
		int i = 157 + c1 / 2;
		int j = 0xffffff;
		if(super.anInt41 > i - 12 && super.anInt41 <= i && super.anInt39 > 106 && super.anInt39 < 406)
			j = 0xff0000;
		surface.method216("Click here to close window", 256, i, 1, j);
		if(anInt653 == 1) {
			if(j == 0xff0000)
				aBoolean790 = false;
			if((super.anInt39 < 256 - c / 2 || super.anInt39 > 256 + c / 2) && (super.anInt41 < 167 - c1 / 2 || super.anInt41 > 167 + c1 / 2))
				aBoolean790 = false;
		}
		anInt653 = 0;
	}

	protected final void method15(int i) {
		if(loggedIn == 0) {
			if(loginState == 0)
				aPanel767.method169(i);
			if(loginState == 1)
				aPanel774.method169(i);
			if(loginState == 2)
				aPanel770.method169(i);
		}
		if(loggedIn == 1) {
			if(aBoolean751) {
				aPanel729.method169(i);
				return;
			}
			if(anInt791 == 0 && anInt792 == 0 && !aBoolean793)
				aPanel794.method169(i);
		}
	}

	private final int method68(int i) {
		int j = 0;
		for(int k = 0; k < inventorySize; k++)
			if(inventoryItemsIDs[k] == i)
				if(Definitions.inventoryItemsStackable[i] == 1)
					j++;
				else
					j += inventoryItemsQuantities[k];

		return j;
	}

	private final boolean method69(int i, int j, int k, int l, int i1, int j1, boolean flag, 
			boolean flag1) {
		int k1 = world.method398(i, j, k, l, i1, j1, anIntArray796, anIntArray797, flag);
		if(k1 == -1)
			if(flag1) {
				k1 = 1;
				anIntArray796[0] = k;
				anIntArray797[0] = l;
			} else {
				return false;
			}
		k1--;
		i = anIntArray796[k1];
		j = anIntArray797[k1];
		k1--;
		if(flag1)
			super.packetStream.createPacket(16);
		else
			super.packetStream.createPacket(187);
		super.packetStream.putShort(i + baseX);
		super.packetStream.putShort(j + baseY);
		if(flag1 && k1 == -1 && (i + baseX) % 5 == 0)
			k1 = 0;
		for(int l1 = k1; l1 >= 0 && l1 > k1 - 25; l1--) {
			super.packetStream.putByte(anIntArray796[l1] - i);
			super.packetStream.putByte(anIntArray797[l1] - j);
		}

		super.packetStream.endPacket();
		anInt800 = -24;
		anInt801 = super.anInt39;
		anInt802 = super.anInt41;
		return true;
	}

	protected final void method24() {
		anInt803 = 0;
		loginState = 0;
		loggedIn = 0;
		anInt675 = 0;
	}

	protected final void method41(String s, String s1) {
		if(loginState == 1)
			aPanel774.method168(anInt804, s + " " + s1);
		if(loginState == 2)
			aPanel770.method168(anInt771, s + " " + s1);
		aString805 = s1;
		method73();
		method13();
	}

	private final RsCharacter method70(int i, int j, int k, int l) {
		if(aRsCharacterArray806[i] == null) {
			aRsCharacterArray806[i] = new RsCharacter();
			aRsCharacterArray806[i].anInt147 = i;
			aRsCharacterArray806[i].anInt148 = 0;
		}
		RsCharacter rscharacter = aRsCharacterArray806[i];
		boolean flag = false;
		for(int i1 = 0; i1 < anInt808; i1++) {
			if(aRsCharacterArray807[i1].anInt147 != i)
				continue;
			flag = true;
			break;
		}

		if(flag) {
			rscharacter.anInt154 = l;
			int j1 = rscharacter.anInt156;
			if(j != rscharacter.anIntArray174[j1] || k != rscharacter.anIntArray175[j1]) {
				rscharacter.anInt156 = j1 = (j1 + 1) % 10;
				rscharacter.anIntArray174[j1] = j;
				rscharacter.anIntArray175[j1] = k;
			}
		} else {
			rscharacter.anInt147 = i;
			rscharacter.anInt155 = 0;
			rscharacter.anInt156 = 0;
			rscharacter.anIntArray174[0] = rscharacter.anInt149 = j;
			rscharacter.anIntArray175[0] = rscharacter.anInt150 = k;
			rscharacter.anInt154 = rscharacter.anInt153 = l;
			rscharacter.anInt152 = 0;
		}
		aRsCharacterArray694[playerCount++] = rscharacter;
		return rscharacter;
	}

	private final void method71() {
		surface.aBoolean321 = false;
		surface.method244();
		aPanel729.method150();
		int i = 140;
		int j = 50;
		i += 116;
		j -= 25;
		surface.method248(i - 32 - 55, j, 64, 102, Definitions.anIntArray103[anInt750], anIntArray697[anInt747]);
		surface.method221(i - 32 - 55, j, 64, 102, Definitions.anIntArray103[anInt739], anIntArray697[anInt741], anIntArray695[anInt744], 0, false);
		surface.method221(i - 32 - 55, j, 64, 102, Definitions.anIntArray103[anInt731], anIntArray696[anInt735], anIntArray695[anInt744], 0, false);
		surface.method248(i - 32, j, 64, 102, Definitions.anIntArray103[anInt750] + 6, anIntArray697[anInt747]);
		surface.method221(i - 32, j, 64, 102, Definitions.anIntArray103[anInt739] + 6, anIntArray697[anInt741], anIntArray695[anInt744], 0, false);
		surface.method221(i - 32, j, 64, 102, Definitions.anIntArray103[anInt731] + 6, anIntArray696[anInt735], anIntArray695[anInt744], 0, false);
		surface.method248((i - 32) + 55, j, 64, 102, Definitions.anIntArray103[anInt750] + 12, anIntArray697[anInt747]);
		surface.method221((i - 32) + 55, j, 64, 102, Definitions.anIntArray103[anInt739] + 12, anIntArray697[anInt741], anIntArray695[anInt744], 0, false);
		surface.method221((i - 32) + 55, j, 64, 102, Definitions.anIntArray103[anInt731] + 12, anIntArray696[anInt735], anIntArray695[anInt744], 0, false);
		surface.method246(0, anInt765, anInt658 + 22);
		surface.drawSurface(aGraphics809, 0, 0);
	}

	private final void method72() {
		if(anInt675 != 0)
			method94();
		else
		if(aBoolean810)
			method117();
		else
		if(aBoolean790)
			method67();
		else
		if(anInt811 == 1)
			method116();
		else
		if(aBoolean812 && anInt674 == 0)
			method77();
		else
		if(aBoolean813 && anInt674 == 0)
			method78();
		else
		if(showDialogTradeConfirm)
			method101();
		else
		if(aBoolean815)
			method113();
		else
		if(aBoolean816)
			method100();
		else
		if(aBoolean817)
			method112();
		else
		if(anInt792 == 1)
			method111();
		else
		if(anInt792 == 2)
			method98();
		else
		if(anInt791 != 0) {
			method84();
		} else {
			if(aBoolean656)
				method46();
			if(localPlayer.anInt153 == 8 || localPlayer.anInt153 == 9)
				method107();
			method62();
			boolean flag = !aBoolean656 && !aBoolean725;
			if(flag)
				anInt724 = 0;
			if(showUiTab == 0 && flag)
				method75();
			if(showUiTab == 1)
				method105(flag);
			if(showUiTab == 2)
				method60(flag);
			if(showUiTab == 3)
				method109(flag);
			if(showUiTab == 4)
				method104(flag);
			if(showUiTab == 5)
				method87(flag);
			if(showUiTab == 6)
				method89(flag);
			if(!aBoolean725 && !aBoolean656)
				method80();
			if(aBoolean725 && !aBoolean656)
				method54();
		}
		anInt653 = 0;
	}

	private final void method73() {
		aBoolean818 = false;
		surface.aBoolean321 = false;
		surface.method244();
		if(loginState == 0 || loginState == 1 || loginState == 2 || loginState == 3) {
			int i = (anInt681 * 2) % 3072;
			if(i < 1024) {
				surface.method246(0, 10, anInt659);
				if(i > 768)
					surface.method260(0, 10, anInt659 + 1, i - 768);
			} else
			if(i < 2048) {
				surface.method246(0, 10, anInt659 + 1);
				if(i > 1792)
					surface.method260(0, 10, anInt658 + 10, i - 1792);
			} else {
				surface.method246(0, 10, anInt658 + 10);
				if(i > 2816)
					surface.method260(0, 10, anInt659, i - 2816);
			}
		}
		if(loginState == 0)
			aPanel767.method150();
		if(loginState == 1)
			aPanel774.method150();
		if(loginState == 2)
			aPanel770.method150();
		surface.method246(0, anInt765, anInt658 + 22);
		surface.drawSurface(aGraphics809, 0, 0);
	}

	protected final void method31() {
		anInt803 = 0;
		anInt819 = 0;
		anInt675 = 0;
		loginState = 0;
		loggedIn = 1;
		method120();
		surface.method244();
		surface.drawSurface(aGraphics809, 0, 0);
		for(int i = 0; i < anInt759; i++) {
			scene.method271(aModelArray787[i]);
			world.method390(anIntArray757[i], anIntArray758[i], anIntArray820[i]);
		}

		for(int j = 0; j < anInt826; j++) {
			scene.method271(aModelArray821[j]);
			world.method391(anIntArray822[j], anIntArray823[j], wallObjectDirection[j], wallObjectID[j]);
		}

		anInt759 = 0;
		anInt826 = 0;
		anInt762 = 0;
		playerCount = 0;
		for(int k = 0; k < 4000; k++)
			aRsCharacterArray806[k] = null;

		for(int l = 0; l < 500; l++)
			aRsCharacterArray694[l] = null;

		npcCount = 0;
		for(int i1 = 0; i1 < 5000; i1++)
			aRsCharacterArray716[i1] = null;

		for(int j1 = 0; j1 < 500; j1++)
			aRsCharacterArray677[j1] = null;

		for(int k1 = 0; k1 < 50; k1++)
			aBooleanArray827[k1] = false;

		anInt653 = 0;
		super.anInt43 = 0;
		super.anInt42 = 0;
		aBoolean813 = false;
		aBoolean812 = false;
		aBoolean793 = false;
		super.anInt603 = 0;
	}

	protected final void method44(String s) {
		if(s.startsWith("@bor@")) {
			method79(s, 4);
			return;
		}
		if(s.startsWith("@que@")) {
			method79("@whi@" + s, 5);
			return;
		}
		if(s.startsWith("@pri@")) {
			method79(s, 6);
			return;
		} else {
			method79(s, 3);
			return;
		}
	}

	protected final void method25() {
		anInt675 = 0;
		method79("@cya@Sorry, you can't logout at the moment", 3);
	}

	private final void method74() {
		if(loggedIn == 0)
			return;
		if(anInt674 > 450) {
			method79("@cya@You can't logout during combat!", 3);
			return;
		}
		if(anInt674 > 0) {
			method79("@cya@You can't logout for 10 seconds after combat", 3);
			return;
		} else {
			super.packetStream.createPacket(102);
			super.packetStream.endPacket();
			anInt675 = 1000;
			return;
		}
	}

	private final void method75() {
		int i = 2203 - (sceneY + anInt828 + baseY);
		if(sceneX + anInt829 + baseX >= 2640)
			i = -50;
		int j = -1;
		for(int k = 0; k < anInt759; k++)
			aBooleanArray830[k] = false;

		for(int l = 0; l < anInt826; l++)
			aBooleanArray831[l] = false;

		int i1 = scene.method298();
		Model amodel[] = scene.method301();
		int ai[] = scene.method307();
		for(int j1 = 0; j1 < i1; j1++) {
			if(anInt724 > 200)
				break;
			int k1 = ai[j1];
			Model model = amodel[j1];
			if(model.anIntArray265[k1] <= 65535 || model.anIntArray265[k1] >= 0x30d40 && model.anIntArray265[k1] <= 0x493e0)
				if(model == scene.aModel392) {
					int i2 = model.anIntArray265[k1] % 10000;
					int l2 = model.anIntArray265[k1] / 10000;
					if(l2 == 1) {
						String s = "";
						int k3 = 0;
						if(localPlayer.anInt177 > 0 && aRsCharacterArray694[i2].anInt177 > 0)
							k3 = localPlayer.anInt177 - aRsCharacterArray694[i2].anInt177;
						if(k3 < 0)
							s = "@or1@";
						if(k3 < -3)
							s = "@or2@";
						if(k3 < -6)
							s = "@or3@";
						if(k3 < -9)
							s = "@red@";
						if(k3 > 0)
							s = "@gr1@";
						if(k3 > 3)
							s = "@gr2@";
						if(k3 > 6)
							s = "@gr3@";
						if(k3 > 9)
							s = "@gre@";
						s = " " + s + "(level-" + aRsCharacterArray694[i2].anInt177 + ")";
						if(selectedSpell >= 0) {
							if(Definitions.anIntArray137[selectedSpell] == 1 || Definitions.anIntArray137[selectedSpell] == 2) {
								aStringArray727[anInt724] = "Cast " + Definitions.aStringArray133[selectedSpell] + " on";
								aStringArray728[anInt724] = "@whi@" + aRsCharacterArray694[i2].aString146 + s;
								menuItemOpcodes[anInt724] = 800;
								menuItemX[anInt724] = aRsCharacterArray694[i2].anInt149;
								menuItemY[anInt724] = aRsCharacterArray694[i2].anInt150;
								menuItemIDs[anInt724] = aRsCharacterArray694[i2].anInt147;
								menuItemSourceIdxs[anInt724] = selectedSpell;
								anInt724++;
							}
						} else
						if(selectedItemSlot >= 0) {
							aStringArray727[anInt724] = "Use " + selectedItemName + " with";
							aStringArray728[anInt724] = "@whi@" + aRsCharacterArray694[i2].aString146 + s;
							menuItemOpcodes[anInt724] = 810;
							menuItemX[anInt724] = aRsCharacterArray694[i2].anInt149;
							menuItemY[anInt724] = aRsCharacterArray694[i2].anInt150;
							menuItemIDs[anInt724] = aRsCharacterArray694[i2].anInt147;
							menuItemSourceIdxs[anInt724] = selectedItemSlot;
							anInt724++;
						} else {
							if(i > 0 && (aRsCharacterArray694[i2].anInt150 - 64) / anInt676 + anInt828 + baseY < 2203) {
								aStringArray727[anInt724] = "Attack";
								aStringArray728[anInt724] = "@whi@" + aRsCharacterArray694[i2].aString146 + s;
								if(k3 >= 0 && k3 < 5)
									menuItemOpcodes[anInt724] = 805;
								else
									menuItemOpcodes[anInt724] = 2805;
								menuItemX[anInt724] = aRsCharacterArray694[i2].anInt149;
								menuItemY[anInt724] = aRsCharacterArray694[i2].anInt150;
								menuItemIDs[anInt724] = aRsCharacterArray694[i2].anInt147;
								anInt724++;
							} else
							if(isMembers) {
								aStringArray727[anInt724] = "Duel with";
								aStringArray728[anInt724] = "@whi@" + aRsCharacterArray694[i2].aString146 + s;
								menuItemX[anInt724] = aRsCharacterArray694[i2].anInt149;
								menuItemY[anInt724] = aRsCharacterArray694[i2].anInt150;
								menuItemOpcodes[anInt724] = 2806;
								menuItemIDs[anInt724] = aRsCharacterArray694[i2].anInt147;
								anInt724++;
							}
							aStringArray727[anInt724] = "Trade with";
							aStringArray728[anInt724] = "@whi@" + aRsCharacterArray694[i2].aString146 + s;
							menuItemOpcodes[anInt724] = 2810;
							menuItemIDs[anInt724] = aRsCharacterArray694[i2].anInt147;
							anInt724++;
							aStringArray727[anInt724] = "Follow";
							aStringArray728[anInt724] = "@whi@" + aRsCharacterArray694[i2].aString146 + s;
							menuItemOpcodes[anInt724] = 2820;
							menuItemIDs[anInt724] = aRsCharacterArray694[i2].anInt147;
							anInt724++;
						}
					} else
					if(l2 == 2) {
						if(selectedSpell >= 0) {
							if(Definitions.anIntArray137[selectedSpell] == 3) {
								aStringArray727[anInt724] = "Cast " + Definitions.aStringArray133[selectedSpell] + " on";
								aStringArray728[anInt724] = "@lre@" + Definitions.itemNames[anIntArray841[i2]];
								menuItemOpcodes[anInt724] = 200;
								menuItemX[anInt724] = anIntArray760[i2];
								menuItemY[anInt724] = anIntArray761[i2];
								menuItemIDs[anInt724] = anIntArray841[i2];
								menuItemSourceIdxs[anInt724] = selectedSpell;
								anInt724++;
							}
						} else
						if(selectedItemSlot >= 0) {
							aStringArray727[anInt724] = "Use " + selectedItemName + " with";
							aStringArray728[anInt724] = "@lre@" + Definitions.itemNames[anIntArray841[i2]];
							menuItemOpcodes[anInt724] = 210;
							menuItemX[anInt724] = anIntArray760[i2];
							menuItemY[anInt724] = anIntArray761[i2];
							menuItemIDs[anInt724] = anIntArray841[i2];
							menuItemSourceIdxs[anInt724] = selectedItemSlot;
							anInt724++;
						} else {
							aStringArray727[anInt724] = "Take";
							aStringArray728[anInt724] = "@lre@" + Definitions.itemNames[anIntArray841[i2]];
							menuItemOpcodes[anInt724] = 220;
							menuItemX[anInt724] = anIntArray760[i2];
							menuItemY[anInt724] = anIntArray761[i2];
							menuItemIDs[anInt724] = anIntArray841[i2];
							anInt724++;
							aStringArray727[anInt724] = "Examine";
							aStringArray728[anInt724] = "@lre@" + Definitions.itemNames[anIntArray841[i2]];
							menuItemOpcodes[anInt724] = 3200;
							menuItemIDs[anInt724] = anIntArray841[i2];
							anInt724++;
						}
					} else
					if(l2 == 3) {
						String s1 = "";
						int l3 = -1;
						int i4 = aRsCharacterArray677[i2].anInt151;
						if(Definitions.anIntArray83[i4] > 0) {
							int j4 = (Definitions.anIntArray79[i4] + Definitions.anIntArray82[i4] + Definitions.anIntArray80[i4] + Definitions.anIntArray81[i4]) / 4;
							int k4 = (anIntArray842[0] + anIntArray842[1] + anIntArray842[2] + anIntArray842[3] + 27) / 4;
							l3 = k4 - j4;
							s1 = "@yel@";
							if(l3 < 0)
								s1 = "@or1@";
							if(l3 < -3)
								s1 = "@or2@";
							if(l3 < -6)
								s1 = "@or3@";
							if(l3 < -9)
								s1 = "@red@";
							if(l3 > 0)
								s1 = "@gr1@";
							if(l3 > 3)
								s1 = "@gr2@";
							if(l3 > 6)
								s1 = "@gr3@";
							if(l3 > 9)
								s1 = "@gre@";
							s1 = " " + s1 + "(level-" + j4 + ")";
						}
						if(selectedSpell >= 0) {
							if(Definitions.anIntArray137[selectedSpell] == 2) {
								aStringArray727[anInt724] = "Cast " + Definitions.aStringArray133[selectedSpell] + " on";
								aStringArray728[anInt724] = "@yel@" + Definitions.aStringArray76[aRsCharacterArray677[i2].anInt151];
								menuItemOpcodes[anInt724] = 700;
								menuItemX[anInt724] = aRsCharacterArray677[i2].anInt149;
								menuItemY[anInt724] = aRsCharacterArray677[i2].anInt150;
								menuItemIDs[anInt724] = aRsCharacterArray677[i2].anInt147;
								menuItemSourceIdxs[anInt724] = selectedSpell;
								anInt724++;
							}
						} else
						if(selectedItemSlot >= 0) {
							aStringArray727[anInt724] = "Use " + selectedItemName + " with";
							aStringArray728[anInt724] = "@yel@" + Definitions.aStringArray76[aRsCharacterArray677[i2].anInt151];
							menuItemOpcodes[anInt724] = 710;
							menuItemX[anInt724] = aRsCharacterArray677[i2].anInt149;
							menuItemY[anInt724] = aRsCharacterArray677[i2].anInt150;
							menuItemIDs[anInt724] = aRsCharacterArray677[i2].anInt147;
							menuItemSourceIdxs[anInt724] = selectedItemSlot;
							anInt724++;
						} else {
							if(Definitions.anIntArray83[i4] > 0) {
								aStringArray727[anInt724] = "Attack";
								aStringArray728[anInt724] = "@yel@" + Definitions.aStringArray76[aRsCharacterArray677[i2].anInt151] + s1;
								if(l3 >= 0)
									menuItemOpcodes[anInt724] = 715;
								else
									menuItemOpcodes[anInt724] = 2715;
								menuItemX[anInt724] = aRsCharacterArray677[i2].anInt149;
								menuItemY[anInt724] = aRsCharacterArray677[i2].anInt150;
								menuItemIDs[anInt724] = aRsCharacterArray677[i2].anInt147;
								anInt724++;
							}
							aStringArray727[anInt724] = "Talk-to";
							aStringArray728[anInt724] = "@yel@" + Definitions.aStringArray76[aRsCharacterArray677[i2].anInt151];
							menuItemOpcodes[anInt724] = 720;
							menuItemX[anInt724] = aRsCharacterArray677[i2].anInt149;
							menuItemY[anInt724] = aRsCharacterArray677[i2].anInt150;
							menuItemIDs[anInt724] = aRsCharacterArray677[i2].anInt147;
							anInt724++;
							if(!Definitions.aStringArray78[i4].equals("")) {
								aStringArray727[anInt724] = Definitions.aStringArray78[i4];
								aStringArray728[anInt724] = "@yel@" + Definitions.aStringArray76[aRsCharacterArray677[i2].anInt151];
								menuItemOpcodes[anInt724] = 725;
								menuItemX[anInt724] = aRsCharacterArray677[i2].anInt149;
								menuItemY[anInt724] = aRsCharacterArray677[i2].anInt150;
								menuItemIDs[anInt724] = aRsCharacterArray677[i2].anInt147;
								anInt724++;
							}
							aStringArray727[anInt724] = "Examine";
							aStringArray728[anInt724] = "@yel@" + Definitions.aStringArray76[aRsCharacterArray677[i2].anInt151];
							menuItemOpcodes[anInt724] = 3700;
							menuItemIDs[anInt724] = aRsCharacterArray677[i2].anInt151;
							anInt724++;
						}
					}
				} else
				if(model != null && model.anInt228 >= 10000) {
					int j2 = model.anInt228 - 10000;
					int i3 = wallObjectID[j2];
					if(!aBooleanArray831[j2]) {
						if(selectedSpell >= 0) {
							if(Definitions.anIntArray137[selectedSpell] == 4) {
								aStringArray727[anInt724] = "Cast " + Definitions.aStringArray133[selectedSpell] + " on";
								aStringArray728[anInt724] = "@cya@" + Definitions.aStringArray115[i3];
								menuItemOpcodes[anInt724] = 300;
								menuItemX[anInt724] = anIntArray822[j2];
								menuItemY[anInt724] = anIntArray823[j2];
								menuItemIDs[anInt724] = wallObjectDirection[j2];
								menuItemSourceIdxs[anInt724] = selectedSpell;
								anInt724++;
							}
						} else
						if(selectedItemSlot >= 0) {
							aStringArray727[anInt724] = "Use " + selectedItemName + " with";
							aStringArray728[anInt724] = "@cya@" + Definitions.aStringArray115[i3];
							menuItemOpcodes[anInt724] = 310;
							menuItemX[anInt724] = anIntArray822[j2];
							menuItemY[anInt724] = anIntArray823[j2];
							menuItemIDs[anInt724] = wallObjectDirection[j2];
							menuItemSourceIdxs[anInt724] = selectedItemSlot;
							anInt724++;
						} else {
							if(!Definitions.aStringArray117[i3].equalsIgnoreCase("WalkTo")) {
								aStringArray727[anInt724] = Definitions.aStringArray117[i3];
								aStringArray728[anInt724] = "@cya@" + Definitions.aStringArray115[i3];
								menuItemOpcodes[anInt724] = 320;
								menuItemX[anInt724] = anIntArray822[j2];
								menuItemY[anInt724] = anIntArray823[j2];
								menuItemIDs[anInt724] = wallObjectDirection[j2];
								anInt724++;
							}
							if(!Definitions.aStringArray118[i3].equalsIgnoreCase("Examine")) {
								aStringArray727[anInt724] = Definitions.aStringArray118[i3];
								aStringArray728[anInt724] = "@cya@" + Definitions.aStringArray115[i3];
								menuItemOpcodes[anInt724] = 2300;
								menuItemX[anInt724] = anIntArray822[j2];
								menuItemY[anInt724] = anIntArray823[j2];
								menuItemIDs[anInt724] = wallObjectDirection[j2];
								anInt724++;
							}
							aStringArray727[anInt724] = "Examine";
							aStringArray728[anInt724] = "@cya@" + Definitions.aStringArray115[i3];
							menuItemOpcodes[anInt724] = 3300;
							menuItemIDs[anInt724] = i3;
							anInt724++;
						}
						aBooleanArray831[j2] = true;
					}
				} else
				if(model != null && model.anInt228 >= 0) {
					int k2 = model.anInt228;
					int j3 = anIntArray820[k2];
					if(!aBooleanArray830[k2]) {
						if(selectedSpell >= 0) {
							if(Definitions.anIntArray137[selectedSpell] == 5) {
								aStringArray727[anInt724] = "Cast " + Definitions.aStringArray133[selectedSpell] + " on";
								aStringArray728[anInt724] = "@cya@" + Definitions.aStringArray105[j3];
								menuItemOpcodes[anInt724] = 400;
								menuItemX[anInt724] = anIntArray757[k2];
								menuItemY[anInt724] = anIntArray758[k2];
								menuItemIDs[anInt724] = anIntArray843[k2];
								menuItemSourceIdxs[anInt724] = anIntArray820[k2];
								menuItemTargerIdxs[anInt724] = selectedSpell;
								anInt724++;
							}
						} else
						if(selectedItemSlot >= 0) {
							aStringArray727[anInt724] = "Use " + selectedItemName + " with";
							aStringArray728[anInt724] = "@cya@" + Definitions.aStringArray105[j3];
							menuItemOpcodes[anInt724] = 410;
							menuItemX[anInt724] = anIntArray757[k2];
							menuItemY[anInt724] = anIntArray758[k2];
							menuItemIDs[anInt724] = anIntArray843[k2];
							menuItemSourceIdxs[anInt724] = anIntArray820[k2];
							menuItemTargerIdxs[anInt724] = selectedItemSlot;
							anInt724++;
						} else {
							if(!Definitions.aStringArray107[j3].equalsIgnoreCase("WalkTo")) {
								aStringArray727[anInt724] = Definitions.aStringArray107[j3];
								aStringArray728[anInt724] = "@cya@" + Definitions.aStringArray105[j3];
								menuItemOpcodes[anInt724] = 420;
								menuItemX[anInt724] = anIntArray757[k2];
								menuItemY[anInt724] = anIntArray758[k2];
								menuItemIDs[anInt724] = anIntArray843[k2];
								menuItemSourceIdxs[anInt724] = anIntArray820[k2];
								anInt724++;
							}
							if(!Definitions.aStringArray108[j3].equalsIgnoreCase("Examine")) {
								aStringArray727[anInt724] = Definitions.aStringArray108[j3];
								aStringArray728[anInt724] = "@cya@" + Definitions.aStringArray105[j3];
								menuItemOpcodes[anInt724] = 2400;
								menuItemX[anInt724] = anIntArray757[k2];
								menuItemY[anInt724] = anIntArray758[k2];
								menuItemIDs[anInt724] = anIntArray843[k2];
								menuItemSourceIdxs[anInt724] = anIntArray820[k2];
								anInt724++;
							}
							aStringArray727[anInt724] = "Examine";
							aStringArray728[anInt724] = "@cya@" + Definitions.aStringArray105[j3];
							menuItemOpcodes[anInt724] = 3400;
							menuItemIDs[anInt724] = j3;
							anInt724++;
						}
						aBooleanArray830[k2] = true;
					}
				} else {
					if(k1 >= 0)
						k1 = model.anIntArray265[k1] - 0x30d40;
					if(k1 >= 0)
						j = k1;
				}
		}

		if(selectedSpell >= 0 && Definitions.anIntArray137[selectedSpell] <= 1) {
			aStringArray727[anInt724] = "Cast " + Definitions.aStringArray133[selectedSpell] + " on self";
			aStringArray728[anInt724] = "";
			menuItemOpcodes[anInt724] = 1000;
			menuItemIDs[anInt724] = selectedSpell;
			anInt724++;
		}
		if(j != -1) {
			int l1 = j;
			if(selectedSpell >= 0) {
				if(Definitions.anIntArray137[selectedSpell] == 6) {
					aStringArray727[anInt724] = "Cast " + Definitions.aStringArray133[selectedSpell] + " on ground";
					aStringArray728[anInt724] = "";
					menuItemOpcodes[anInt724] = 900;
					menuItemX[anInt724] = world.anIntArray593[l1];
					menuItemY[anInt724] = world.anIntArray594[l1];
					menuItemIDs[anInt724] = selectedSpell;
					anInt724++;
					return;
				}
			} else
			if(selectedItemSlot < 0) {
				aStringArray727[anInt724] = "Walk here";
				aStringArray728[anInt724] = "";
				menuItemOpcodes[anInt724] = 920;
				menuItemX[anInt724] = world.anIntArray593[l1];
				menuItemY[anInt724] = world.anIntArray594[l1];
				anInt724++;
			}
		}
	}

	private final void method76() {
		surface.method246(0, anInt765 - 4, anInt658 + 23);
		int i = Surface.method222(200, 200, 255);
		if(anInt845 == 0)
			i = Surface.method222(255, 200, 50);
		if(anInt712 % 30 > 15)
			i = Surface.method222(255, 50, 50);
		surface.method216("All messages", 54, anInt765 + 6, 0, i);
		i = Surface.method222(200, 200, 255);
		if(anInt845 == 1)
			i = Surface.method222(255, 200, 50);
		if(anInt713 % 30 > 15)
			i = Surface.method222(255, 50, 50);
		surface.method216("Chat history", 155, anInt765 + 6, 0, i);
		i = Surface.method222(200, 200, 255);
		if(anInt845 == 2)
			i = Surface.method222(255, 200, 50);
		if(anInt714 % 30 > 15)
			i = Surface.method222(255, 50, 50);
		surface.method216("Quest history", 255, anInt765 + 6, 0, i);
		i = Surface.method222(200, 200, 255);
		if(anInt845 == 3)
			i = Surface.method222(255, 200, 50);
		if(anInt715 % 30 > 15)
			i = Surface.method222(255, 50, 50);
		surface.method216("Private history", 355, anInt765 + 6, 0, i);
		surface.method216("Report abuse", 457, anInt765 + 6, 0, 0xffffff);
	}

	private final void method77() {
		char c = '\u0198';
		char c1 = '\u014E';
		if(anInt846 > 0 && anInt663 <= 48)
			anInt846 = 0;
		if(anInt846 > 1 && anInt663 <= 96)
			anInt846 = 1;
		if(anInt846 > 2 && anInt663 <= 144)
			anInt846 = 2;
		if(anInt847 >= anInt663 || anInt847 < 0)
			anInt847 = -1;
		if(anInt847 != -1 && anIntArray664[anInt847] != anInt848) {
			anInt847 = -1;
			anInt848 = -2;
		}
		if(anInt653 != 0) {
			anInt653 = 0;
			int i = super.anInt39 - (256 - c / 2);
			int k = super.anInt41 - (170 - c1 / 2);
			if(i >= 0 && k >= 12 && i < 408 && k < 280) {
				int i1 = anInt846 * 48;
				for(int l1 = 0; l1 < 6; l1++) {
					for(int j2 = 0; j2 < 8; j2++) {
						int l6 = 7 + j2 * 49;
						int j7 = 28 + l1 * 34;
						if(i > l6 && i < l6 + 49 && k > j7 && k < j7 + 34 && i1 < anInt663 && anIntArray664[i1] != -1) {
							anInt848 = anIntArray664[i1];
							anInt847 = i1;
						}
						i1++;
					}

				}

				i = 256 - c / 2;
				k = 170 - c1 / 2;
				int k2;
				if(anInt847 < 0)
					k2 = -1;
				else
					k2 = anIntArray664[anInt847];
				if(k2 != -1) {
					int j1 = anIntArray666[anInt847];
					if(Definitions.inventoryItemsStackable[k2] == 1 && j1 > 1)
						j1 = 1;
					if(j1 >= 1 && super.anInt39 >= i + 220 && super.anInt41 >= k + 238 && super.anInt39 < i + 250 && super.anInt41 <= k + 249) {
						super.packetStream.createPacket(22);
						super.packetStream.putShort(k2);
						super.packetStream.putShort(1);
						super.packetStream.put4(0x12345678);
						super.packetStream.endPacket();
					}
					if(j1 >= 5 && super.anInt39 >= i + 250 && super.anInt41 >= k + 238 && super.anInt39 < i + 280 && super.anInt41 <= k + 249) {
						super.packetStream.createPacket(22);
						super.packetStream.putShort(k2);
						super.packetStream.putShort(5);
						super.packetStream.put4(0x12345678);
						super.packetStream.endPacket();
					}
					if(j1 >= 25 && super.anInt39 >= i + 280 && super.anInt41 >= k + 238 && super.anInt39 < i + 305 && super.anInt41 <= k + 249) {
						super.packetStream.createPacket(22);
						super.packetStream.putShort(k2);
						super.packetStream.putShort(25);
						super.packetStream.put4(0x12345678);
						super.packetStream.endPacket();
					}
					if(j1 >= 100 && super.anInt39 >= i + 305 && super.anInt41 >= k + 238 && super.anInt39 < i + 335 && super.anInt41 <= k + 249) {
						super.packetStream.createPacket(22);
						super.packetStream.putShort(k2);
						super.packetStream.putShort(100);
						super.packetStream.put4(0x12345678);
						super.packetStream.endPacket();
					}
					if(j1 >= 500 && super.anInt39 >= i + 335 && super.anInt41 >= k + 238 && super.anInt39 < i + 368 && super.anInt41 <= k + 249) {
						super.packetStream.createPacket(22);
						super.packetStream.putShort(k2);
						super.packetStream.putShort(500);
						super.packetStream.put4(0x12345678);
						super.packetStream.endPacket();
					}
					if(j1 >= 2500 && super.anInt39 >= i + 370 && super.anInt41 >= k + 238 && super.anInt39 < i + 400 && super.anInt41 <= k + 249) {
						super.packetStream.createPacket(22);
						super.packetStream.putShort(k2);
						super.packetStream.putShort(2500);
						super.packetStream.put4(0x12345678);
						super.packetStream.endPacket();
					}
					if(method68(k2) >= 1 && super.anInt39 >= i + 220 && super.anInt41 >= k + 263 && super.anInt39 < i + 250 && super.anInt41 <= k + 274) {
						super.packetStream.createPacket(23);
						super.packetStream.putShort(k2);
						super.packetStream.putShort(1);
						super.packetStream.put4(0x87654321);
						super.packetStream.endPacket();
					}
					if(method68(k2) >= 5 && super.anInt39 >= i + 250 && super.anInt41 >= k + 263 && super.anInt39 < i + 280 && super.anInt41 <= k + 274) {
						super.packetStream.createPacket(23);
						super.packetStream.putShort(k2);
						super.packetStream.putShort(5);
						super.packetStream.put4(0x87654321);
						super.packetStream.endPacket();
					}
					if(method68(k2) >= 25 && super.anInt39 >= i + 280 && super.anInt41 >= k + 263 && super.anInt39 < i + 305 && super.anInt41 <= k + 274) {
						super.packetStream.createPacket(23);
						super.packetStream.putShort(k2);
						super.packetStream.putShort(25);
						super.packetStream.put4(0x87654321);
						super.packetStream.endPacket();
					}
					if(method68(k2) >= 100 && super.anInt39 >= i + 305 && super.anInt41 >= k + 263 && super.anInt39 < i + 335 && super.anInt41 <= k + 274) {
						super.packetStream.createPacket(23);
						super.packetStream.putShort(k2);
						super.packetStream.putShort(100);
						super.packetStream.put4(0x87654321);
						super.packetStream.endPacket();
					}
					if(method68(k2) >= 500 && super.anInt39 >= i + 335 && super.anInt41 >= k + 263 && super.anInt39 < i + 368 && super.anInt41 <= k + 274) {
						super.packetStream.createPacket(23);
						super.packetStream.putShort(k2);
						super.packetStream.putShort(500);
						super.packetStream.put4(0x87654321);
						super.packetStream.endPacket();
					}
					if(method68(k2) >= 2500 && super.anInt39 >= i + 370 && super.anInt41 >= k + 263 && super.anInt39 < i + 400 && super.anInt41 <= k + 274) {
						super.packetStream.createPacket(23);
						super.packetStream.putShort(k2);
						super.packetStream.putShort(2500);
						super.packetStream.put4(0x87654321);
						super.packetStream.endPacket();
					}
				}
			} else
			if(anInt663 > 48 && i >= 50 && i <= 115 && k <= 12)
				anInt846 = 0;
			else
			if(anInt663 > 48 && i >= 115 && i <= 180 && k <= 12)
				anInt846 = 1;
			else
			if(anInt663 > 96 && i >= 180 && i <= 245 && k <= 12)
				anInt846 = 2;
			else
			if(anInt663 > 144 && i >= 245 && i <= 310 && k <= 12) {
				anInt846 = 3;
			} else {
				super.packetStream.createPacket(212);
				super.packetStream.endPacket();
				aBoolean812 = false;
				return;
			}
		}
		int j = 256 - c / 2;
		int l = 170 - c1 / 2;
		surface.method207(j, l, 408, 12, 192);
		int k1 = 0x989898;
		surface.method224(j, l + 12, 408, 17, k1, 160);
		surface.method224(j, l + 29, 8, 204, k1, 160);
		surface.method224(j + 399, l + 29, 9, 204, k1, 160);
		surface.method224(j, l + 233, 408, 47, k1, 160);
		surface.method254("Bank", j + 1, l + 10, 1, 0xffffff);
		int i2 = 50;
		if(anInt663 > 48) {
			int l2 = 0xffffff;
			if(anInt846 == 0)
				l2 = 0xff0000;
			else
			if(super.anInt39 > j + i2 && super.anInt41 >= l && super.anInt39 < j + i2 + 65 && super.anInt41 < l + 12)
				l2 = 0xffff00;
			surface.method254("<page 1>", j + i2, l + 10, 1, l2);
			i2 += 65;
			l2 = 0xffffff;
			if(anInt846 == 1)
				l2 = 0xff0000;
			else
			if(super.anInt39 > j + i2 && super.anInt41 >= l && super.anInt39 < j + i2 + 65 && super.anInt41 < l + 12)
				l2 = 0xffff00;
			surface.method254("<page 2>", j + i2, l + 10, 1, l2);
			i2 += 65;
		}
		if(anInt663 > 96) {
			int i3 = 0xffffff;
			if(anInt846 == 2)
				i3 = 0xff0000;
			else
			if(super.anInt39 > j + i2 && super.anInt41 >= l && super.anInt39 < j + i2 + 65 && super.anInt41 < l + 12)
				i3 = 0xffff00;
			surface.method254("<page 3>", j + i2, l + 10, 1, i3);
			i2 += 65;
		}
		if(anInt663 > 144) {
			int j3 = 0xffffff;
			if(anInt846 == 3)
				j3 = 0xff0000;
			else
			if(super.anInt39 > j + i2 && super.anInt41 >= l && super.anInt39 < j + i2 + 65 && super.anInt41 < l + 12)
				j3 = 0xffff00;
			surface.method254("<page 4>", j + i2, l + 10, 1, j3);
			i2 += 65;
		}
		int k3 = 0xffffff;
		if(super.anInt39 > j + 320 && super.anInt41 >= l && super.anInt39 < j + 408 && super.anInt41 < l + 12)
			k3 = 0xff0000;
		surface.method243("Close window", j + 406, l + 10, 1, k3);
		surface.method254("Number in bank in green", j + 7, l + 24, 1, 65280);
		surface.method254("Number held in blue", j + 289, l + 24, 1, 65535);
		int i7 = 0xd0d0d0;
		int k7 = anInt846 * 48;
		for(int i8 = 0; i8 < 6; i8++) {
			for(int j8 = 0; j8 < 8; j8++) {
				int l8 = j + 7 + j8 * 49;
				int i9 = l + 28 + i8 * 34;
				if(anInt847 == k7)
					surface.method224(l8, i9, 49, 34, 0xff0000, 160);
				else
					surface.method224(l8, i9, 49, 34, i7, 160);
				surface.method214(l8, i9, 50, 35, 0);
				if(k7 < anInt663 && anIntArray664[k7] != -1) {
					surface.method221(l8, i9, 48, 32, anInt786 + Definitions.anIntArray66[anIntArray664[k7]], Definitions.anIntArray71[anIntArray664[k7]], 0, 0, false);
					surface.method254(String.valueOf(anIntArray666[k7]), l8 + 1, i9 + 10, 1, 65280);
					surface.method243(String.valueOf(method68(anIntArray664[k7])), l8 + 47, i9 + 29, 1, 65535);
				}
				k7++;
			}

		}

		surface.method251(j + 5, l + 256, 398, 0);
		if(anInt847 == -1) {
			surface.method216("Select an object to withdraw or deposit", j + 204, l + 248, 3, 0xffff00);
			return;
		}
		int k8;
		if(anInt847 < 0)
			k8 = -1;
		else
			k8 = anIntArray664[anInt847];
		if(k8 != -1) {
			int l7 = anIntArray666[anInt847];
			if(Definitions.inventoryItemsStackable[k8] == 1 && l7 > 1)
				l7 = 1;
			if(l7 > 0) {
				surface.method254("Withdraw " + Definitions.itemNames[k8], j + 2, l + 248, 1, 0xffffff);
				int l3 = 0xffffff;
				if(super.anInt39 >= j + 220 && super.anInt41 >= l + 238 && super.anInt39 < j + 250 && super.anInt41 <= l + 249)
					l3 = 0xff0000;
				surface.method254("One", j + 222, l + 248, 1, l3);
				if(l7 >= 5) {
					int i4 = 0xffffff;
					if(super.anInt39 >= j + 250 && super.anInt41 >= l + 238 && super.anInt39 < j + 280 && super.anInt41 <= l + 249)
						i4 = 0xff0000;
					surface.method254("Five", j + 252, l + 248, 1, i4);
				}
				if(l7 >= 25) {
					int j4 = 0xffffff;
					if(super.anInt39 >= j + 280 && super.anInt41 >= l + 238 && super.anInt39 < j + 305 && super.anInt41 <= l + 249)
						j4 = 0xff0000;
					surface.method254("25", j + 282, l + 248, 1, j4);
				}
				if(l7 >= 100) {
					int k4 = 0xffffff;
					if(super.anInt39 >= j + 305 && super.anInt41 >= l + 238 && super.anInt39 < j + 335 && super.anInt41 <= l + 249)
						k4 = 0xff0000;
					surface.method254("100", j + 307, l + 248, 1, k4);
				}
				if(l7 >= 500) {
					int l4 = 0xffffff;
					if(super.anInt39 >= j + 335 && super.anInt41 >= l + 238 && super.anInt39 < j + 368 && super.anInt41 <= l + 249)
						l4 = 0xff0000;
					surface.method254("500", j + 337, l + 248, 1, l4);
				}
				if(l7 >= 2500) {
					int i5 = 0xffffff;
					if(super.anInt39 >= j + 370 && super.anInt41 >= l + 238 && super.anInt39 < j + 400 && super.anInt41 <= l + 249)
						i5 = 0xff0000;
					surface.method254("2500", j + 370, l + 248, 1, i5);
				}
			}
			if(method68(k8) > 0) {
				surface.method254("Deposit " + Definitions.itemNames[k8], j + 2, l + 273, 1, 0xffffff);
				int j5 = 0xffffff;
				if(super.anInt39 >= j + 220 && super.anInt41 >= l + 263 && super.anInt39 < j + 250 && super.anInt41 <= l + 274)
					j5 = 0xff0000;
				surface.method254("One", j + 222, l + 273, 1, j5);
				if(method68(k8) >= 5) {
					int k5 = 0xffffff;
					if(super.anInt39 >= j + 250 && super.anInt41 >= l + 263 && super.anInt39 < j + 280 && super.anInt41 <= l + 274)
						k5 = 0xff0000;
					surface.method254("Five", j + 252, l + 273, 1, k5);
				}
				if(method68(k8) >= 25) {
					int l5 = 0xffffff;
					if(super.anInt39 >= j + 280 && super.anInt41 >= l + 263 && super.anInt39 < j + 305 && super.anInt41 <= l + 274)
						l5 = 0xff0000;
					surface.method254("25", j + 282, l + 273, 1, l5);
				}
				if(method68(k8) >= 100) {
					int i6 = 0xffffff;
					if(super.anInt39 >= j + 305 && super.anInt41 >= l + 263 && super.anInt39 < j + 335 && super.anInt41 <= l + 274)
						i6 = 0xff0000;
					surface.method254("100", j + 307, l + 273, 1, i6);
				}
				if(method68(k8) >= 500) {
					int j6 = 0xffffff;
					if(super.anInt39 >= j + 335 && super.anInt41 >= l + 263 && super.anInt39 < j + 368 && super.anInt41 <= l + 274)
						j6 = 0xff0000;
					surface.method254("500", j + 337, l + 273, 1, j6);
				}
				if(method68(k8) >= 2500) {
					int k6 = 0xffffff;
					if(super.anInt39 >= j + 370 && super.anInt41 >= l + 263 && super.anInt39 < j + 400 && super.anInt41 <= l + 274)
						k6 = 0xff0000;
					surface.method254("2500", j + 370, l + 273, 1, k6);
				}
			}
		}
	}

	private final void method78() {
		if(anInt653 != 0) {
			anInt653 = 0;
			int i = super.anInt39 - 52;
			int j = super.anInt41 - 44;
			if(i >= 0 && j >= 12 && i < 408 && j < 246) {
				int k = 0;
				for(int i1 = 0; i1 < 5; i1++) {
					for(int i2 = 0; i2 < 8; i2++) {
						int l2 = 7 + i2 * 49;
						int l3 = 28 + i1 * 34;
						if(i > l2 && i < l2 + 49 && j > l3 && j < l3 + 34 && anIntArray849[k] != -1) {
							anInt850 = k;
							anInt851 = anIntArray849[k];
						}
						k++;
					}

				}

				if(anInt850 >= 0) {
					int j2 = anIntArray849[anInt850];
					if(j2 != -1) {
						if(anIntArray852[anInt850] > 0 && i > 298 && j >= 204 && i < 408 && j <= 215) {
							int i3 = anInt853 + anIntArray854[anInt850];
							if(i3 < 10)
								i3 = 10;
							int i4 = (i3 * Definitions.anIntArray67[j2]) / 100;
							super.packetStream.createPacket(236);
							super.packetStream.putShort(anIntArray849[anInt850]);
							super.packetStream.put4(i4);
							super.packetStream.endPacket();
						}
						if(method68(j2) > 0 && i > 2 && j >= 229 && i < 112 && j <= 240) {
							int j3 = anInt855 + anIntArray854[anInt850];
							if(j3 < 10)
								j3 = 10;
							int j4 = (j3 * Definitions.anIntArray67[j2]) / 100;
							super.packetStream.createPacket(221);
							super.packetStream.putShort(anIntArray849[anInt850]);
							super.packetStream.put4(j4);
							super.packetStream.endPacket();
						}
					}
				}
			} else {
				super.packetStream.createPacket(166);
				super.packetStream.endPacket();
				aBoolean813 = false;
				return;
			}
		}
		byte byte0 = 52;
		byte byte1 = 44;
		surface.method207(byte0, byte1, 408, 12, 192);
		int l = 0x989898;
		surface.method224(byte0, byte1 + 12, 408, 17, l, 160);
		surface.method224(byte0, byte1 + 29, 8, 170, l, 160);
		surface.method224(byte0 + 399, byte1 + 29, 9, 170, l, 160);
		surface.method224(byte0, byte1 + 199, 408, 47, l, 160);
		surface.method254("Buying and selling items", byte0 + 1, byte1 + 10, 1, 0xffffff);
		int j1 = 0xffffff;
		if(super.anInt39 > byte0 + 320 && super.anInt41 >= byte1 && super.anInt39 < byte0 + 408 && super.anInt41 < byte1 + 12)
			j1 = 0xff0000;
		surface.method243("Close window", byte0 + 406, byte1 + 10, 1, j1);
		surface.method254("Shops stock in green", byte0 + 2, byte1 + 24, 1, 65280);
		surface.method254("Number you own in blue", byte0 + 135, byte1 + 24, 1, 65535);
		surface.method254("Your money: " + method68(10) + "gp", byte0 + 280, byte1 + 24, 1, 0xffff00);
		int k2 = 0xd0d0d0;
		int k3 = 0;
		for(int k4 = 0; k4 < 5; k4++) {
			for(int l4 = 0; l4 < 8; l4++) {
				int j5 = byte0 + 7 + l4 * 49;
				int i6 = byte1 + 28 + k4 * 34;
				if(anInt850 == k3)
					surface.method224(j5, i6, 49, 34, 0xff0000, 160);
				else
					surface.method224(j5, i6, 49, 34, k2, 160);
				surface.method214(j5, i6, 50, 35, 0);
				if(anIntArray849[k3] != -1) {
					surface.method221(j5, i6, 48, 32, anInt786 + Definitions.anIntArray66[anIntArray849[k3]], Definitions.anIntArray71[anIntArray849[k3]], 0, 0, false);
					surface.method254(String.valueOf(anIntArray852[k3]), j5 + 1, i6 + 10, 1, 65280);
					surface.method243(String.valueOf(method68(anIntArray849[k3])), j5 + 47, i6 + 10, 1, 65535);
				}
				k3++;
			}

		}

		surface.method251(byte0 + 5, byte1 + 222, 398, 0);
		if(anInt850 == -1) {
			surface.method216("Select an object to buy or sell", byte0 + 204, byte1 + 214, 3, 0xffff00);
			return;
		}
		int i5 = anIntArray849[anInt850];
		if(i5 != -1) {
			if(anIntArray852[anInt850] > 0) {
				int k5 = anInt853 + anIntArray854[anInt850];
				if(k5 < 10)
					k5 = 10;
				int j6 = (k5 * Definitions.anIntArray67[i5]) / 100;
				surface.method254("Buy a new " + Definitions.itemNames[i5] + " for " + j6 + "gp", byte0 + 2, byte1 + 214, 1, 0xffff00);
				int k1 = 0xffffff;
				if(super.anInt39 > byte0 + 298 && super.anInt41 >= byte1 + 204 && super.anInt39 < byte0 + 408 && super.anInt41 <= byte1 + 215)
					k1 = 0xff0000;
				surface.method243("Click here to buy", byte0 + 405, byte1 + 214, 3, k1);
			} else {
				surface.method216("This item is not currently available to buy", byte0 + 204, byte1 + 214, 3, 0xffff00);
			}
			if(method68(i5) > 0) {
				int l5 = anInt855 + anIntArray854[anInt850];
				if(l5 < 10)
					l5 = 10;
				int k6 = (l5 * Definitions.anIntArray67[i5]) / 100;
				surface.method243("Sell your " + Definitions.itemNames[i5] + " for " + k6 + "gp", byte0 + 405, byte1 + 239, 1, 0xffff00);
				int l1 = 0xffffff;
				if(super.anInt39 > byte0 + 2 && super.anInt41 >= byte1 + 229 && super.anInt39 < byte0 + 112 && super.anInt41 <= byte1 + 240)
					l1 = 0xff0000;
				surface.method254("Click here to sell", byte0 + 2, byte1 + 239, 3, l1);
				return;
			}
			surface.method216("You do not have any of this item to sell", byte0 + 204, byte1 + 239, 3, 0xffff00);
		}
	}

	private final void method79(String s, int i) {
		if(i == 2 || i == 4 || i == 6) {
			for(; s.length() > 5 && s.charAt(0) == '@' && s.charAt(4) == '@'; s = s.substring(5));
			int j = s.indexOf(":");
			if(j != -1) {
				String s1 = s.substring(0, j);
				long l = DataUtils.method356(s1);
				for(int i1 = 0; i1 < super.anInt606; i1++)
					if(super.aLongArray605[i1] == l)
						return;

			}
		}
		if(i == 2)
			s = "@yel@" + s;
		if(i == 3 || i == 4)
			s = "@whi@" + s;
		if(i == 6)
			s = "@cya@" + s;
		if(anInt845 != 0) {
			if(i == 4 || i == 3)
				anInt712 = 200;
			if(i == 2 && anInt845 != 1)
				anInt713 = 200;
			if(i == 5 && anInt845 != 2)
				anInt714 = 200;
			if(i == 6 && anInt845 != 3)
				anInt715 = 200;
			if(i == 3 && anInt845 != 0)
				anInt845 = 0;
			if(i == 6 && anInt845 != 3 && anInt845 != 0)
				anInt845 = 0;
		}
		for(int k = 4; k > 0; k--) {
			aStringArray856[k] = aStringArray856[k - 1];
			anIntArray857[k] = anIntArray857[k - 1];
		}

		aStringArray856[0] = s;
		anIntArray857[0] = 300;
		if(i == 2)
			if(aPanel794.anIntArray200[anInt858] == aPanel794.anIntArray195[anInt858] - 4)
				aPanel794.method141(anInt858, s, true);
			else
				aPanel794.method141(anInt858, s, false);
		if(i == 5)
			if(aPanel794.anIntArray200[anInt859] == aPanel794.anIntArray195[anInt859] - 4)
				aPanel794.method141(anInt859, s, true);
			else
				aPanel794.method141(anInt859, s, false);
		if(i == 6) {
			if(aPanel794.anIntArray200[anInt860] == aPanel794.anIntArray195[anInt860] - 4) {
				aPanel794.method141(anInt860, s, true);
				return;
			}
			aPanel794.method141(anInt860, s, false);
		}
	}

	private final void method80() {
		if(selectedSpell >= 0 || selectedItemSlot >= 0) {
			aStringArray727[anInt724] = "Cancel";
			aStringArray728[anInt724] = "";
			menuItemOpcodes[anInt724] = 4000;
			anInt724++;
		}
		for(int i = 0; i < anInt724; i++)
			menuIdxs[i] = i;

		for(boolean flag = false; !flag;) {
			flag = true;
			for(int j = 0; j < anInt724 - 1; j++) {
				int l = menuIdxs[j];
				int j1 = menuIdxs[j + 1];
				if(menuItemOpcodes[l] > menuItemOpcodes[j1]) {
					menuIdxs[j] = j1;
					menuIdxs[j + 1] = l;
					flag = false;
				}
			}

		}

		if(anInt724 > 20)
			anInt724 = 20;
		if(anInt724 > 0) {
			int k = -1;
			for(int i1 = 0; i1 < anInt724; i1++) {
				if(aStringArray728[menuIdxs[i1]] == null || aStringArray728[menuIdxs[i1]].length() <= 0)
					continue;
				k = i1;
				break;
			}

			String s = null;
			if((selectedItemSlot >= 0 || selectedSpell >= 0) && anInt724 == 1)
				s = "Choose a target";
			else
			if((selectedItemSlot >= 0 || selectedSpell >= 0) && anInt724 > 1)
				s = "@whi@" + aStringArray727[menuIdxs[0]] + " " + aStringArray728[menuIdxs[0]];
			else
			if(k != -1)
				s = aStringArray728[menuIdxs[k]] + ": @whi@" + aStringArray727[menuIdxs[0]];
			if(anInt724 == 2 && s != null)
				s = s + "@whi@ / 1 more option";
			if(anInt724 > 2 && s != null)
				s = s + "@whi@ / " + (anInt724 - 1) + " more options";
			if(s != null)
				surface.method254(s, 6, 14, 1, 0xffff00);
			if(!aBoolean861 && anInt653 == 1 || aBoolean861 && anInt653 == 1 && anInt724 == 1) {
				menuAction(menuIdxs[0]);
				anInt653 = 0;
				return;
			}
			if(!aBoolean861 && anInt653 == 2 || aBoolean861 && anInt653 == 1) {
				anInt726 = (anInt724 + 1) * 15;
				anInt722 = surface.method212("Choose option", 1) + 5;
				for(int k1 = 0; k1 < anInt724; k1++) {
					int l1 = surface.method212(aStringArray727[k1] + " " + aStringArray728[k1], 1) + 5;
					if(l1 > anInt722)
						anInt722 = l1;
				}

				anInt720 = super.anInt39 - anInt722 / 2;
				anInt721 = super.anInt41 - 7;
				aBoolean725 = true;
				if(anInt720 < 0)
					anInt720 = 0;
				if(anInt721 < 0)
					anInt721 = 0;
				if(anInt720 + anInt722 > 510)
					anInt720 = 510 - anInt722;
				if(anInt721 + anInt726 > 315)
					anInt721 = 315 - anInt726;
				anInt653 = 0;
			}
		}
	}

	private final void method81() {
		aPanel767 = new Panel(surface, 50);
		int i = 40;
		aPanel767.method153(256, 200 + i, "Click on an option", 5, true);
		aPanel767.method158(156, 240 + i, 120, 35);
		aPanel767.method158(356, 240 + i, 120, 35);
		aPanel767.method153(156, 240 + i, "New User", 5, false);
		aPanel767.method153(356, 240 + i, "Existing User", 5, false);
		anInt768 = aPanel767.method173(156, 240 + i, 120, 35);
		anInt769 = aPanel767.method173(356, 240 + i, 120, 35);
		aPanel774 = new Panel(surface, 50);
		i = 230;
		if(anInt862 == 0) {
			aPanel774.method153(256, i + 8, "To create an account please go back to the", 4, true);
			i += 20;
			aPanel774.method153(256, i + 8, "www.runescape.com front page, and choose 'create account'", 4, true);
		} else
		if(anInt862 == 1) {
			aPanel774.method153(256, i + 8, "To create an account please click on the", 4, true);
			i += 20;
			aPanel774.method153(256, i + 8, "'create account' link below the game window", 4, true);
		} else {
			aPanel774.method153(256, i + 8, "To create an account please go back to the", 4, true);
			i += 20;
			aPanel774.method153(256, i + 8, "runescape front webpage and choose 'create account'", 4, true);
		}
		i += 30;
		aPanel774.method158(256, i + 17, 150, 34);
		aPanel774.method153(256, i + 17, "Ok", 5, false);
		anInt775 = aPanel774.method173(256, i + 17, 150, 34);
		aPanel770 = new Panel(surface, 50);
		i = 230;
		anInt771 = aPanel770.method153(256, i - 10, "Please enter your username and password", 4, true);
		i += 28;
		aPanel770.method158(140, i, 200, 40);
		aPanel770.method153(140, i - 10, "Username:", 4, false);
		anInt772 = aPanel770.method157(140, i + 10, 200, 40, 4, 12, false, false);
		i += 47;
		aPanel770.method158(190, i, 200, 40);
		aPanel770.method153(190, i - 10, "Password:", 4, false);
		anInt773 = aPanel770.method157(190, i + 10, 200, 40, 4, 20, true, false);
		i -= 55;
		aPanel770.method158(410, i, 120, 25);
		aPanel770.method153(410, i, "Ok", 4, false);
		anInt777 = aPanel770.method173(410, i, 120, 25);
		i += 30;
		aPanel770.method158(410, i, 120, 25);
		aPanel770.method153(410, i, "Cancel", 4, false);
		anInt776 = aPanel770.method173(410, i, 120, 25);
		i += 30;
		aPanel770.method170(anInt772);
	}

	private final void method82() {
		byte abyte0[] = readDataFile("config" + Versions.anInt560 + ".jag", "Configuration", 10);
		if(abyte0 == null) {
			aBoolean705 = true;
			return;
		}
		Definitions.method128(abyte0, isMembers);
		byte abyte1[] = readDataFile("filter" + Versions.anInt567 + ".jag", "Chat system", 15);
		if(abyte1 == null) {
			aBoolean705 = true;
			return;
		} else {
			byte abyte2[] = DataUtils.loadData("fragmentsenc.txt", 0, abyte1);
			byte abyte3[] = DataUtils.loadData("badenc.txt", 0, abyte1);
			byte abyte4[] = DataUtils.loadData("hostenc.txt", 0, abyte1);
			byte abyte5[] = DataUtils.loadData("tldlist.txt", 0, abyte1);
			//TODO: check
			//ChatFilter.method367(new ByteBuffer(abyte2), new ByteBuffer(abyte3), new ByteBuffer(abyte4), new ByteBuffer(abyte5));
			return;
		}
	}

	private final void menuAction(int idx) {
		int localX = menuItemX[idx];
		int localY = menuItemY[idx];
		int id = menuItemIDs[idx];
		int sourceIdx = menuItemSourceIdxs[idx];
		int targetIdx = menuItemTargerIdxs[idx];
		int opcode = menuItemOpcodes[idx];
		if(opcode == 200) {
			walkToGroundItem(sceneX, sceneY, localX, localY, true);
			super.packetStream.createPacket(249);
			super.packetStream.putShort(localX + baseX);
			super.packetStream.putShort(localY + baseY);
			super.packetStream.putShort(id);
			super.packetStream.putShort(sourceIdx);
			super.packetStream.endPacket();
			selectedSpell = -1;
		}
		if(opcode == 210) {
			walkToGroundItem(sceneX, sceneY, localX, localY, true);
			super.packetStream.createPacket(53);
			super.packetStream.putShort(localX + baseX);
			super.packetStream.putShort(localY + baseY);
			super.packetStream.putShort(id);
			super.packetStream.putShort(sourceIdx);
			super.packetStream.endPacket();
			selectedItemSlot = -1;
		}
		if(opcode == 220) {
			walkToGroundItem(sceneX, sceneY, localX, localY, true);
			super.packetStream.createPacket(247);
			super.packetStream.putShort(localX + baseX);
			super.packetStream.putShort(localY + baseY);
			super.packetStream.putShort(id);
			super.packetStream.putShort(sourceIdx);
			super.packetStream.endPacket();
		}
		if(opcode == 3200)
			method79(Definitions.aStringArray64[id], 3);
		if(opcode == 300) {
			method58(localX, localY, id);
			super.packetStream.createPacket(180);
			super.packetStream.putShort(localX + baseX);
			super.packetStream.putShort(localY + baseY);
			super.packetStream.putByte(id);
			super.packetStream.putShort(sourceIdx);
			super.packetStream.endPacket();
			selectedSpell = -1;
		}
		if(opcode == 310) {
			method58(localX, localY, id);
			super.packetStream.createPacket(161);
			super.packetStream.putShort(localX + baseX);
			super.packetStream.putShort(localY + baseY);
			super.packetStream.putByte(id);
			super.packetStream.putShort(sourceIdx);
			super.packetStream.endPacket();
			selectedItemSlot = -1;
		}
		if(opcode == 320) {
			method58(localX, localY, id);
			super.packetStream.createPacket(14);
			super.packetStream.putShort(localX + baseX);
			super.packetStream.putShort(localY + baseY);
			super.packetStream.putByte(id);
			super.packetStream.endPacket();
		}
		if(opcode == 2300) {
			method58(localX, localY, id);
			super.packetStream.createPacket(127);
			super.packetStream.putShort(localX + baseX);
			super.packetStream.putShort(localY + baseY);
			super.packetStream.putByte(id);
			super.packetStream.endPacket();
		}
		if(opcode == 3300)
			method79(Definitions.aStringArray116[id], 3);
		if(opcode == 400) {
			method59(localX, localY, id, sourceIdx);
			super.packetStream.createPacket(99);
			super.packetStream.putShort(localX + baseX);
			super.packetStream.putShort(localY + baseY);
			super.packetStream.putShort(targetIdx);
			super.packetStream.endPacket();
			selectedSpell = -1;
		}
		if(opcode == 410) {
			method59(localX, localY, id, sourceIdx);
			super.packetStream.createPacket(115);
			super.packetStream.putShort(localX + baseX);
			super.packetStream.putShort(localY + baseY);
			super.packetStream.putShort(targetIdx);
			super.packetStream.endPacket();
			selectedItemSlot = -1;
		}
		if(opcode == 420) {
			method59(localX, localY, id, sourceIdx);
			super.packetStream.createPacket(136);
			super.packetStream.putShort(localX + baseX);
			super.packetStream.putShort(localY + baseY);
			super.packetStream.endPacket();
		}
		if(opcode == 2400) {
			method59(localX, localY, id, sourceIdx);
			super.packetStream.createPacket(79);
			super.packetStream.putShort(localX + baseX);
			super.packetStream.putShort(localY + baseY);
			super.packetStream.endPacket();
		}
		if(opcode == 3400)
			method79(Definitions.aStringArray106[id], 3);
		if(opcode == 600) {
			super.packetStream.createPacket(4);
			super.packetStream.putShort(id);
			super.packetStream.putShort(sourceIdx);
			super.packetStream.endPacket();
			selectedSpell = -1;
		}
		if(opcode == 610) {
			super.packetStream.createPacket(91);
			super.packetStream.putShort(id);
			super.packetStream.putShort(sourceIdx);
			super.packetStream.endPacket();
			selectedItemSlot = -1;
		}
		if(opcode == 620) {
			super.packetStream.createPacket(170);
			super.packetStream.putShort(id);
			super.packetStream.endPacket();
		}
		if(opcode == 630) {
			super.packetStream.createPacket(169);
			super.packetStream.putShort(id);
			super.packetStream.endPacket();
		}
		if(opcode == 640) {
			super.packetStream.createPacket(90);
			super.packetStream.putShort(id);
			super.packetStream.endPacket();
		}
		if(opcode == 650) {
			selectedItemSlot = id;
			showUiTab = 0;
			selectedItemName = Definitions.itemNames[inventoryItemsIDs[selectedItemSlot]];
		}
		if(opcode == 660) {
			super.packetStream.createPacket(246);
			super.packetStream.putShort(id);
			super.packetStream.endPacket();
			selectedItemSlot = -1;
			showUiTab = 0;
			method79("Dropping " + Definitions.itemNames[inventoryItemsIDs[id]], 4);
		}
		if(opcode == 3600)
			method79(Definitions.aStringArray64[id], 3);
		if(opcode == 700) {
			int l1 = (localX - 64) / anInt676;
			int l3 = (localY - 64) / anInt676;
			method106(sceneX, sceneY, l1, l3, true);
			super.packetStream.createPacket(50);
			super.packetStream.putShort(id);
			super.packetStream.putShort(sourceIdx);
			super.packetStream.endPacket();
			selectedSpell = -1;
		}
		if(opcode == 710) {
			int i2 = (localX - 64) / anInt676;
			int i4 = (localY - 64) / anInt676;
			method106(sceneX, sceneY, i2, i4, true);
			super.packetStream.createPacket(135);
			super.packetStream.putShort(id);
			super.packetStream.putShort(sourceIdx);
			super.packetStream.endPacket();
			selectedItemSlot = -1;
		}
		if(opcode == 720) {
			int j2 = (localX - 64) / anInt676;
			int j4 = (localY - 64) / anInt676;
			method106(sceneX, sceneY, j2, j4, true);
			super.packetStream.createPacket(153);
			super.packetStream.putShort(id);
			super.packetStream.endPacket();
		}
		if(opcode == 725) {
			int k2 = (localX - 64) / anInt676;
			int k4 = (localY - 64) / anInt676;
			method106(sceneX, sceneY, k2, k4, true);
			super.packetStream.createPacket(202);
			super.packetStream.putShort(id);
			super.packetStream.endPacket();
		}
		if(opcode == 715 || opcode == 2715) {
			int l2 = (localX - 64) / anInt676;
			int l4 = (localY - 64) / anInt676;
			method106(sceneX, sceneY, l2, l4, true);
			super.packetStream.createPacket(190);
			super.packetStream.putShort(id);
			super.packetStream.endPacket();
		}
		if(opcode == 3700)
			method79(Definitions.aStringArray77[id], 3);
		if(opcode == 800) {
			int i3 = (localX - 64) / anInt676;
			int i5 = (localY - 64) / anInt676;
			method106(sceneX, sceneY, i3, i5, true);
			super.packetStream.createPacket(229);
			super.packetStream.putShort(id);
			super.packetStream.putShort(sourceIdx);
			super.packetStream.endPacket();
			selectedSpell = -1;
		}
		if(opcode == 810) {
			int j3 = (localX - 64) / anInt676;
			int j5 = (localY - 64) / anInt676;
			method106(sceneX, sceneY, j3, j5, true);
			super.packetStream.createPacket(113);
			super.packetStream.putShort(id);
			super.packetStream.putShort(sourceIdx);
			super.packetStream.endPacket();
			selectedItemSlot = -1;
		}
		if(opcode == 805 || opcode == 2805) {
			int k3 = (localX - 64) / anInt676;
			int k5 = (localY - 64) / anInt676;
			method106(sceneX, sceneY, k3, k5, true);
			super.packetStream.createPacket(171);
			super.packetStream.putShort(id);
			super.packetStream.endPacket();
		}
		if(opcode == 2806) {
			super.packetStream.createPacket(103);
			super.packetStream.putShort(id);
			super.packetStream.endPacket();
		}
		if(opcode == 2810) {
			super.packetStream.createPacket(142);
			super.packetStream.putShort(id);
			super.packetStream.endPacket();
		}
		if(opcode == 2820) {
			super.packetStream.createPacket(165);
			super.packetStream.putShort(id);
			super.packetStream.endPacket();
		}
		if(opcode == 900) {
			method106(sceneX, sceneY, localX, localY, true);
			super.packetStream.createPacket(158);
			super.packetStream.putShort(localX + baseX);
			super.packetStream.putShort(localY + baseY);
			super.packetStream.putShort(id);
			super.packetStream.endPacket();
			selectedSpell = -1;
		}
		if(opcode == 920) {
			method106(sceneX, sceneY, localX, localY, false);
			if(anInt800 == -24)
				anInt800 = 24;
		}
		if(opcode == 1000) {
			super.packetStream.createPacket(137);
			super.packetStream.putShort(id);
			super.packetStream.endPacket();
			selectedSpell = -1;
		}
		if(opcode == 4000) {
			selectedItemSlot = -1;
			selectedSpell = -1;
		}
	}

	private final void method84() {
		if(anInt653 != 0) {
			anInt653 = 0;
			if(anInt791 == 1 && (super.anInt39 < 106 || super.anInt41 < 145 || super.anInt39 > 406 || super.anInt41 > 215)) {
				anInt791 = 0;
				return;
			}
			if(anInt791 == 2 && (super.anInt39 < 6 || super.anInt41 < 145 || super.anInt39 > 506 || super.anInt41 > 215)) {
				anInt791 = 0;
				return;
			}
			if(anInt791 == 3 && (super.anInt39 < 106 || super.anInt41 < 145 || super.anInt39 > 406 || super.anInt41 > 215)) {
				anInt791 = 0;
				return;
			}
			if(super.anInt39 > 236 && super.anInt39 < 276 && super.anInt41 > 193 && super.anInt41 < 213) {
				anInt791 = 0;
				return;
			}
		}
		int i = 145;
		if(anInt791 == 1) {
			surface.method207(106, i, 300, 70, 0);
			surface.method214(106, i, 300, 70, 0xffffff);
			i += 20;
			surface.method216("Enter name to add to friends list", 256, i, 4, 0xffffff);
			i += 20;
			surface.method216(super.inputTextCurrent + "*", 256, i, 4, 0xffffff);
			if(super.inputTextFinal.length() > 0) {
				String s = super.inputTextFinal.trim();
				super.inputTextCurrent = "";
				super.inputTextFinal = "";
				anInt791 = 0;
				if(s.length() > 0 && DataUtils.method356(s) != localPlayer.aLong145)
					method29(s);
			}
		}
		if(anInt791 == 2) {
			surface.method207(6, i, 500, 70, 0);
			surface.method214(6, i, 500, 70, 0xffffff);
			i += 20;
			surface.method216("Enter message to send to " + DataUtils.method351(aLong863), 256, i, 4, 0xffffff);
			i += 20;
			surface.method216(super.inputPmCurrent + "*", 256, i, 4, 0xffffff);
			if(super.inputPmFinal.length() > 0) {
				String s1 = super.inputPmFinal;
				super.inputPmCurrent = "";
				super.inputPmFinal = "";
				anInt791 = 0;
				int k = ChatEncoding.method389(s1);
				method27(aLong863, ChatEncoding.aByteArray557, k);
				s1 = ChatEncoding.method388(ChatEncoding.aByteArray557, 0, k);
				//s1 = ChatFilter.method380(s1);
				method44("@pri@You tell " + DataUtils.method351(aLong863) + ": " + s1);
			}
		}
		if(anInt791 == 3) {
			surface.method207(106, i, 300, 70, 0);
			surface.method214(106, i, 300, 70, 0xffffff);
			i += 20;
			surface.method216("Enter name to add to ignore list", 256, i, 4, 0xffffff);
			i += 20;
			surface.method216(super.inputTextCurrent + "*", 256, i, 4, 0xffffff);
			if(super.inputTextFinal.length() > 0) {
				String s2 = super.inputTextFinal.trim();
				super.inputTextCurrent = "";
				super.inputTextFinal = "";
				anInt791 = 0;
				if(s2.length() > 0 && DataUtils.method356(s2) != localPlayer.aLong145)
					method40(s2);
			}
		}
		int j = 0xffffff;
		if(super.anInt39 > 236 && super.anInt39 < 276 && super.anInt41 > 193 && super.anInt41 < 213)
			j = 0xffff00;
		surface.method216("Cancel", 256, 208, 1, j);
	}

	private final void method85() {
		byte abyte0[] = null;
		byte abyte1[] = null;
		abyte0 = readDataFile("entity" + Versions.anInt565 + ".jag", "people and monsters", 30);
		if(abyte0 == null) {
			aBoolean705 = true;
			return;
		}
		abyte1 = DataUtils.loadData("index.dat", 0, abyte0);
		byte abyte2[] = null;
		byte abyte3[] = null;
		if(isMembers) {
			abyte2 = readDataFile("entity" + Versions.anInt565 + ".mem", "member graphics", 45);
			if(abyte2 == null) {
				aBoolean705 = true;
				return;
			}
			abyte3 = DataUtils.loadData("index.dat", 0, abyte2);
		}
		int i = 0;
		anInt864 = 0;
		anInt865 = anInt864;
label0:
		for(int j = 0; j < Definitions.anInt97; j++) {
			String s = Definitions.aStringArray98[j];
			for(int k = 0; k < j; k++) {
				if(!Definitions.aStringArray98[k].equalsIgnoreCase(s))
					continue;
				Definitions.anIntArray103[j] = Definitions.anIntArray103[k];
				continue label0;
			}

			byte abyte7[] = DataUtils.loadData(s + ".dat", 0, abyte0);
			byte abyte4[] = abyte1;
			if(abyte7 == null && isMembers) {
				abyte7 = DataUtils.loadData(s + ".dat", 0, abyte2);
				abyte4 = abyte3;
			}
			if(abyte7 != null) {
				surface.method211(anInt865, abyte7, abyte4, 15);
				i += 15;
				if(Definitions.anIntArray101[j] == 1) {
					byte abyte8[] = DataUtils.loadData(s + "a.dat", 0, abyte0);
					byte abyte5[] = abyte1;
					if(abyte8 == null && isMembers) {
						abyte8 = DataUtils.loadData(s + "a.dat", 0, abyte2);
						abyte5 = abyte3;
					}
					surface.method211(anInt865 + 15, abyte8, abyte5, 3);
					i += 3;
				}
				if(Definitions.anIntArray102[j] == 1) {
					byte abyte9[] = DataUtils.loadData(s + "f.dat", 0, abyte0);
					byte abyte6[] = abyte1;
					if(abyte9 == null && isMembers) {
						abyte9 = DataUtils.loadData(s + "f.dat", 0, abyte2);
						abyte6 = abyte3;
					}
					surface.method211(anInt865 + 18, abyte9, abyte6, 9);
					i += 9;
				}
				if(Definitions.anIntArray100[j] != 0) {
					for(int l = anInt865; l < anInt865 + 27; l++)
						surface.method210(l);

				}
			}
			Definitions.anIntArray103[j] = anInt865;
			anInt865 += 27;
		}
	}

	private final boolean method86(int i, int j) {
		if(i == 31 && (method115(197) || method115(615) || method115(682)))
			return true;
		if(i == 32 && (method115(102) || method115(616) || method115(683)))
			return true;
		if(i == 33 && (method115(101) || method115(617) || method115(684)))
			return true;
		if(i == 34 && (method115(103) || method115(618) || method115(685)))
			return true;
		return method68(i) >= j;
	}

	private final void method87(boolean flag) {
		int i = ((Surface) (surface)).anInt320 - 199;
		int j = 36;
		surface.method246(i - 49, 3, anInt658 + 5);
		char c = '\304';
		char c1 = '\266';
		int l;
		int k = l = Surface.method222(160, 160, 160);
		if(anInt866 == 0)
			k = Surface.method222(220, 220, 220);
		else
			l = Surface.method222(220, 220, 220);
		surface.method224(i, j, c / 2, 24, k, 128);
		surface.method224(i + c / 2, j, c / 2, 24, l, 128);
		surface.method224(i, j + 24, c, c1 - 24, Surface.method222(220, 220, 220), 128);
		surface.method251(i, j + 24, c, 0);
		surface.method217(i + c / 2, j, 24, 0);
		surface.method251(i, (j + c1) - 16, c, 0);
		surface.method216("Friends", i + c / 4, j + 16, 4, 0);
		surface.method216("Ignore", i + c / 4 + c / 2, j + 16, 4, 0);
		aPanel867.method154(anInt868);
		if(anInt866 == 0) {
			for(int i1 = 0; i1 < super.anInt603; i1++) {
				String s;
				if(super.anIntArray604[i1] == 255)
					s = "@gre@";
				else
				if(super.anIntArray604[i1] > 0)
					s = "@yel@";
				else
					s = "@red@";
				aPanel867.method139(anInt868, i1, s + DataUtils.method351(super.aLongArray602[i1]) + "~439~@whi@Remove         WWWWWWWWWW");
			}

		}
		if(anInt866 == 1) {
			for(int j1 = 0; j1 < super.anInt606; j1++)
				aPanel867.method139(anInt868, j1, "@yel@" + DataUtils.method351(super.aLongArray605[j1]) + "~439~@whi@Remove         WWWWWWWWWW");

		}
		aPanel867.method150();
		if(anInt866 == 0) {
			int k1 = aPanel867.method164(anInt868);
			if(k1 >= 0 && super.anInt39 < 489) {
				if(super.anInt39 > 429)
					surface.method216("Click to remove " + DataUtils.method351(super.aLongArray602[k1]), i + c / 2, j + 35, 1, 0xffffff);
				else
				if(super.anIntArray604[k1] == 255)
					surface.method216("Click to message " + DataUtils.method351(super.aLongArray602[k1]), i + c / 2, j + 35, 1, 0xffffff);
				else
				if(super.anIntArray604[k1] > 0) {
					if(super.anIntArray604[k1] < 200)
						surface.method216(DataUtils.method351(super.aLongArray602[k1]) + " is on world " + (super.anIntArray604[k1] - 9), i + c / 2, j + 35, 1, 0xffffff);
					else
						surface.method216(DataUtils.method351(super.aLongArray602[k1]) + " is on classic " + (super.anIntArray604[k1] - 219), i + c / 2, j + 35, 1, 0xffffff);
				} else {
					surface.method216(DataUtils.method351(super.aLongArray602[k1]) + " is offline", i + c / 2, j + 35, 1, 0xffffff);
				}
			} else {
				surface.method216("Click a name to send a message", i + c / 2, j + 35, 1, 0xffffff);
			}
			int k2;
			if(super.anInt39 > i && super.anInt39 < i + c && super.anInt41 > (j + c1) - 16 && super.anInt41 < j + c1)
				k2 = 0xffff00;
			else
				k2 = 0xffffff;
			surface.method216("Click here to add a friend", i + c / 2, (j + c1) - 3, 1, k2);
		}
		if(anInt866 == 1) {
			int l1 = aPanel867.method164(anInt868);
			if(l1 >= 0 && super.anInt39 < 489 && super.anInt39 > 429) {
				if(super.anInt39 > 429)
					surface.method216("Click to remove " + DataUtils.method351(super.aLongArray605[l1]), i + c / 2, j + 35, 1, 0xffffff);
			} else {
				surface.method216("Blocking messages from:", i + c / 2, j + 35, 1, 0xffffff);
			}
			int l2;
			if(super.anInt39 > i && super.anInt39 < i + c && super.anInt41 > (j + c1) - 16 && super.anInt41 < j + c1)
				l2 = 0xffff00;
			else
				l2 = 0xffffff;
			surface.method216("Click here to add a name", i + c / 2, (j + c1) - 3, 1, l2);
		}
		if(!flag)
			return;
		i = super.anInt39 - (((Surface) (surface)).anInt320 - 199);
		j = super.anInt41 - 36;
		if(i >= 0 && j >= 0 && i < 196 && j < 182) {
			aPanel867.method142(i + (((Surface) (surface)).anInt320 - 199), j + 36, super.anInt43, super.anInt42);
			if(j <= 24 && anInt653 == 1)
				if(i < 98 && anInt866 == 1) {
					anInt866 = 0;
					aPanel867.method162(anInt868);
				} else
				if(i > 98 && anInt866 == 0) {
					anInt866 = 1;
					aPanel867.method162(anInt868);
				}
			if(anInt653 == 1 && anInt866 == 0) {
				int i2 = aPanel867.method164(anInt868);
				if(i2 >= 0 && super.anInt39 < 489)
					if(super.anInt39 > 429)
						method21(super.aLongArray602[i2]);
					else
					if(super.anIntArray604[i2] != 0) {
						anInt791 = 2;
						aLong863 = super.aLongArray602[i2];
						super.inputPmCurrent = "";
						super.inputPmFinal = "";
					}
			}
			if(anInt653 == 1 && anInt866 == 1) {
				int j2 = aPanel867.method164(anInt868);
				if(j2 >= 0 && super.anInt39 < 489 && super.anInt39 > 429)
					method23(super.aLongArray605[j2]);
			}
			if(j > 166 && anInt653 == 1 && anInt866 == 0) {
				anInt791 = 1;
				super.inputTextCurrent = "";
				super.inputTextFinal = "";
			}
			if(j > 166 && anInt653 == 1 && anInt866 == 1) {
				anInt791 = 3;
				super.inputTextCurrent = "";
				super.inputTextFinal = "";
			}
			anInt653 = 0;
		}
	}

	private final void method88() {
		try {
			if(surface != null) {
				surface.method249();
				surface.anIntArray322 = null;
				surface = null;
			}
			if(scene != null) {
				scene.method306();
				scene = null;
			}
			aModelArray657 = null;
			aModelArray787 = null;
			aModelArray821 = null;
			aRsCharacterArray806 = null;
			aRsCharacterArray694 = null;
			aRsCharacterArray716 = null;
			aRsCharacterArray677 = null;
			localPlayer = null;
			if(world != null) {
				world.aModelArray578 = null;
				world.aModelArrayArray597 = null;
				world.aModelArrayArray598 = null;
				world.aModel591 = null;
				world = null;
			}
			System.gc();
			return;
		}
		catch(Exception _ex) {
			return;
		}
	}

	private final void method89(boolean flag) {
		int i = ((Surface) (surface)).anInt320 - 199;
		int j = 36;
		surface.method246(i - 49, 3, anInt658 + 6);
		char c = '\304';
		surface.method224(i, 36, c, 65, Surface.method222(181, 181, 181), 160);
		surface.method224(i, 101, c, 65, Surface.method222(201, 201, 201), 160);
		surface.method224(i, 166, c, 95, Surface.method222(181, 181, 181), 160);
		surface.method224(i, 261, c, 40, Surface.method222(201, 201, 201), 160);
		int k = i + 3;
		int i1 = j + 15;
		surface.method254("Game options - click to toggle", k, i1, 1, 0);
		i1 += 15;
		if(aBoolean869)
			surface.method254("Camera angle mode - @gre@Auto", k, i1, 1, 0xffffff);
		else
			surface.method254("Camera angle mode - @red@Manual", k, i1, 1, 0xffffff);
		i1 += 15;
		if(aBoolean861)
			surface.method254("Mouse buttons - @red@One", k, i1, 1, 0xffffff);
		else
			surface.method254("Mouse buttons - @gre@Two", k, i1, 1, 0xffffff);
		i1 += 15;
		if(isMembers)
			if(aBoolean784)
				surface.method254("Sound effects - @red@off", k, i1, 1, 0xffffff);
			else
				surface.method254("Sound effects - @gre@on", k, i1, 1, 0xffffff);
		i1 += 15;
		surface.method254("To change your contact details,", k, i1, 0, 0xffffff);
		i1 += 15;
		surface.method254("password, recovery questions, etc..", k, i1, 0, 0xffffff);
		i1 += 15;
		surface.method254("please select 'account management'", k, i1, 0, 0xffffff);
		i1 += 15;
		if(anInt862 == 0)
			surface.method254("from the runescape.com front page", k, i1, 0, 0xffffff);
		else
		if(anInt862 == 1)
			surface.method254("from the link below the gamewindow", k, i1, 0, 0xffffff);
		else
			surface.method254("from the runescape front webpage", k, i1, 0, 0xffffff);
		i1 += 15;
		i1 += 5;
		surface.method254("Privacy settings. Will be applied to", i + 3, i1, 1, 0);
		i1 += 15;
		surface.method254("all people not on your friends list", i + 3, i1, 1, 0);
		i1 += 15;
		if(super.anInt609 == 0)
			surface.method254("Block chat messages: @red@<off>", i + 3, i1, 1, 0xffffff);
		else
			surface.method254("Block chat messages: @gre@<on>", i + 3, i1, 1, 0xffffff);
		i1 += 15;
		if(super.anInt610 == 0)
			surface.method254("Block private messages: @red@<off>", i + 3, i1, 1, 0xffffff);
		else
			surface.method254("Block private messages: @gre@<on>", i + 3, i1, 1, 0xffffff);
		i1 += 15;
		if(super.anInt611 == 0)
			surface.method254("Block trade requests: @red@<off>", i + 3, i1, 1, 0xffffff);
		else
			surface.method254("Block trade requests: @gre@<on>", i + 3, i1, 1, 0xffffff);
		i1 += 15;
		if(isMembers)
			if(super.anInt612 == 0)
				surface.method254("Block duel requests: @red@<off>", i + 3, i1, 1, 0xffffff);
			else
				surface.method254("Block duel requests: @gre@<on>", i + 3, i1, 1, 0xffffff);
		i1 += 15;
		i1 += 5;
		surface.method254("Always logout when you finish", k, i1, 1, 0);
		i1 += 15;
		int k1 = 0xffffff;
		if(super.anInt39 > k && super.anInt39 < k + c && super.anInt41 > i1 - 12 && super.anInt41 < i1 + 4)
			k1 = 0xffff00;
		surface.method254("Click here to logout", i + 3, i1, 1, k1);
		if(!flag)
			return;
		i = super.anInt39 - (((Surface) (surface)).anInt320 - 199);
		j = super.anInt41 - 36;
		if(i >= 0 && j >= 0 && i < 196 && j < 265) {
			int l1 = ((Surface) (surface)).anInt320 - 199;
			byte byte0 = 36;
			char c1 = '\304';
			int l = l1 + 3;
			int j1 = byte0 + 30;
			if(super.anInt39 > l && super.anInt39 < l + c1 && super.anInt41 > j1 - 12 && super.anInt41 < j1 + 4 && anInt653 == 1) {
				aBoolean869 = !aBoolean869;
				super.packetStream.createPacket(111);
				super.packetStream.putByte(0);
				super.packetStream.putByte(aBoolean869 ? 1 : 0);
				super.packetStream.endPacket();
			}
			j1 += 15;
			if(super.anInt39 > l && super.anInt39 < l + c1 && super.anInt41 > j1 - 12 && super.anInt41 < j1 + 4 && anInt653 == 1) {
				aBoolean861 = !aBoolean861;
				super.packetStream.createPacket(111);
				super.packetStream.putByte(2);
				super.packetStream.putByte(aBoolean861 ? 1 : 0);
				super.packetStream.endPacket();
			}
			j1 += 15;
			if(isMembers && super.anInt39 > l && super.anInt39 < l + c1 && super.anInt41 > j1 - 12 && super.anInt41 < j1 + 4 && anInt653 == 1) {
				aBoolean784 = !aBoolean784;
				super.packetStream.createPacket(111);
				super.packetStream.putByte(3);
				super.packetStream.putByte(aBoolean784 ? 1 : 0);
				super.packetStream.endPacket();
			}
			j1 += 15;
			j1 += 15;
			j1 += 15;
			j1 += 15;
			j1 += 15;
			boolean flag1 = false;
			j1 += 35;
			if(super.anInt39 > l && super.anInt39 < l + c1 && super.anInt41 > j1 - 12 && super.anInt41 < j1 + 4 && anInt653 == 1) {
				super.anInt609 = 1 - super.anInt609;
				flag1 = true;
			}
			j1 += 15;
			if(super.anInt39 > l && super.anInt39 < l + c1 && super.anInt41 > j1 - 12 && super.anInt41 < j1 + 4 && anInt653 == 1) {
				super.anInt610 = 1 - super.anInt610;
				flag1 = true;
			}
			j1 += 15;
			if(super.anInt39 > l && super.anInt39 < l + c1 && super.anInt41 > j1 - 12 && super.anInt41 < j1 + 4 && anInt653 == 1) {
				super.anInt611 = 1 - super.anInt611;
				flag1 = true;
			}
			j1 += 15;
			if(isMembers && super.anInt39 > l && super.anInt39 < l + c1 && super.anInt41 > j1 - 12 && super.anInt41 < j1 + 4 && anInt653 == 1) {
				super.anInt612 = 1 - super.anInt612;
				flag1 = true;
			}
			j1 += 15;
			if(flag1)
				method33(super.anInt609, super.anInt610, super.anInt611, super.anInt612);
			j1 += 20;
			if(super.anInt39 > l && super.anInt39 < l + c1 && super.anInt41 > j1 - 12 && super.anInt41 < j1 + 4 && anInt653 == 1)
				method74();
			anInt653 = 0;
		}
	}

	private final String method90(int i) {
		if(link.mainapp != null)
			return link.gethostname(DataUtils.method349(i));
		else
			return DataUtils.method349(i);
	}

	private final void method91() {
		aPanel794 = new Panel(surface, 10);
		anInt858 = aPanel794.method172(5, 269, 502, 56, 1, 20, true);
		anInt870 = aPanel794.method163(7, 324, 498, 14, 1, 80, false, true);
		anInt859 = aPanel794.method172(5, 269, 502, 56, 1, 20, true);
		anInt860 = aPanel794.method172(5, 269, 502, 56, 1, 20, true);
		aPanel794.method170(anInt870);
	}

	protected final void method37() {
		anInt803 = 0;
		if(anInt675 != 0) {
			method24();
			return;
		} else {
			super.method37();
			return;
		}
	}

	protected final void method43(int i, int j, byte buffer[]) {
		try {
			if(i == 191) {
				anInt808 = playerCount;
				for(int k = 0; k < anInt808; k++)
					aRsCharacterArray807[k] = aRsCharacterArray694[k];

				int k7 = 8;
				sceneX = DataUtils.method350(buffer, k7, 11);
				k7 += 11;
				sceneY = DataUtils.method350(buffer, k7, 13);
				k7 += 13;
				int l13 = DataUtils.method350(buffer, k7, 4);
				k7 += 4;
				boolean flag1 = method93(sceneX, sceneY);
				sceneX -= baseX;
				sceneY -= baseY;
				int l22 = sceneX * anInt676 + 64;
				int l25 = sceneY * anInt676 + 64;
				if(flag1) {
					localPlayer.anInt156 = 0;
					localPlayer.anInt155 = 0;
					localPlayer.anInt149 = localPlayer.anIntArray174[0] = l22;
					localPlayer.anInt150 = localPlayer.anIntArray175[0] = l25;
				}
				playerCount = 0;
				localPlayer = method70(localPlayerServerIdx, l22, l25, l13);
				int i29 = DataUtils.method350(buffer, k7, 8);
				k7 += 8;
				for(int l33 = 0; l33 < i29; l33++) {
					RsCharacter rscharacter3 = aRsCharacterArray807[l33 + 1];
					int k39 = DataUtils.method350(buffer, k7, 1);
					k7++;
					if(k39 != 0) {
						int k41 = DataUtils.method350(buffer, k7, 1);
						k7++;
						if(k41 == 0) {
							int l42 = DataUtils.method350(buffer, k7, 3);
							k7 += 3;
							int l43 = rscharacter3.anInt156;
							int j44 = rscharacter3.anIntArray174[l43];
							int k44 = rscharacter3.anIntArray175[l43];
							if(l42 == 2 || l42 == 1 || l42 == 3)
								j44 += anInt676;
							if(l42 == 6 || l42 == 5 || l42 == 7)
								j44 -= anInt676;
							if(l42 == 4 || l42 == 3 || l42 == 5)
								k44 += anInt676;
							if(l42 == 0 || l42 == 1 || l42 == 7)
								k44 -= anInt676;
							rscharacter3.anInt154 = l42;
							rscharacter3.anInt156 = l43 = (l43 + 1) % 10;
							rscharacter3.anIntArray174[l43] = j44;
							rscharacter3.anIntArray175[l43] = k44;
						} else {
							int i43 = DataUtils.method350(buffer, k7, 4);
							if((i43 & 0xc) == 12) {
								k7 += 2;
								continue;
							}
							rscharacter3.anInt154 = DataUtils.method350(buffer, k7, 4);
							k7 += 4;
						}
					}
					aRsCharacterArray694[playerCount++] = rscharacter3;
				}

				int i37 = 0;
				while(k7 + 24 < j * 8)  {
					int l39 = DataUtils.method350(buffer, k7, 11);
					k7 += 11;
					int l41 = DataUtils.method350(buffer, k7, 5);
					k7 += 5;
					if(l41 > 15)
						l41 -= 32;
					int j43 = DataUtils.method350(buffer, k7, 5);
					k7 += 5;
					if(j43 > 15)
						j43 -= 32;
					int i14 = DataUtils.method350(buffer, k7, 4);
					k7 += 4;
					int i44 = DataUtils.method350(buffer, k7, 1);
					k7++;
					int i23 = (sceneX + l41) * anInt676 + 64;
					int i26 = (sceneY + j43) * anInt676 + 64;
					method70(l39, i23, i26, i14);
					if(i44 == 0)
						anIntArray872[i37++] = l39;
				}
				if(i37 > 0) {
					super.packetStream.createPacket(163);
					super.packetStream.putShort(i37);
					for(int i40 = 0; i40 < i37; i40++) {
						RsCharacter rscharacter4 = aRsCharacterArray806[anIntArray872[i40]];
						super.packetStream.putShort(rscharacter4.anInt147);
						super.packetStream.putShort(rscharacter4.anInt148);
					}

					super.packetStream.endPacket();
					i37 = 0;
				}
				return;
			}
			if(i == 99) {
				for(int l = 1; l < j;)
					if(DataUtils.method340(buffer[l]) == 255) {
						int l7 = 0;
						int j14 = sceneX + buffer[l + 1] >> 3;
						int i19 = sceneY + buffer[l + 2] >> 3;
						l += 3;
						for(int j23 = 0; j23 < anInt762; j23++) {
							int j26 = (anIntArray760[j23] >> 3) - j14;
							int j29 = (anIntArray761[j23] >> 3) - i19;
							if(j26 != 0 || j29 != 0) {
								if(j23 != l7) {
									anIntArray760[l7] = anIntArray760[j23];
									anIntArray761[l7] = anIntArray761[j23];
									anIntArray841[l7] = anIntArray841[j23];
									anIntArray873[l7] = anIntArray873[j23];
								}
								l7++;
							}
						}

						anInt762 = l7;
					} else {
						int i8 = DataUtils.method344(buffer, l);
						l += 2;
						int k14 = sceneX + buffer[l++];
						int j19 = sceneY + buffer[l++];
						if((i8 & 0x8000) == 0) {
							anIntArray760[anInt762] = k14;
							anIntArray761[anInt762] = j19;
							anIntArray841[anInt762] = i8;
							anIntArray873[anInt762] = 0;
							for(int k23 = 0; k23 < anInt759; k23++) {
								if(anIntArray757[k23] != k14 || anIntArray758[k23] != j19)
									continue;
								anIntArray873[anInt762] = Definitions.anIntArray113[anIntArray820[k23]];
								break;
							}

							anInt762++;
						} else {
							i8 &= 0x7fff;
							int l23 = 0;
							for(int k26 = 0; k26 < anInt762; k26++)
								if(anIntArray760[k26] != k14 || anIntArray761[k26] != j19 || anIntArray841[k26] != i8) {
									if(k26 != l23) {
										anIntArray760[l23] = anIntArray760[k26];
										anIntArray761[l23] = anIntArray761[k26];
										anIntArray841[l23] = anIntArray841[k26];
										anIntArray873[l23] = anIntArray873[k26];
									}
									l23++;
								} else {
									i8 = -123;
								}

							anInt762 = l23;
						}
					}

				return;
			}
			if(i == 48) {
				for(int i1 = 1; i1 < j;)
					if(DataUtils.method340(buffer[i1]) == 255) {
						int j8 = 0;
						int l14 = sceneX + buffer[i1 + 1] >> 3;
						int k19 = sceneY + buffer[i1 + 2] >> 3;
						i1 += 3;
						for(int i24 = 0; i24 < anInt759; i24++) {
							int l26 = (anIntArray757[i24] >> 3) - l14;
							int k29 = (anIntArray758[i24] >> 3) - k19;
							if(l26 != 0 || k29 != 0) {
								if(i24 != j8) {
									aModelArray787[j8] = aModelArray787[i24];
									aModelArray787[j8].anInt228 = j8;
									anIntArray757[j8] = anIntArray757[i24];
									anIntArray758[j8] = anIntArray758[i24];
									anIntArray820[j8] = anIntArray820[i24];
									anIntArray843[j8] = anIntArray843[i24];
								}
								j8++;
							} else {
								scene.method271(aModelArray787[i24]);
								world.method390(anIntArray757[i24], anIntArray758[i24], anIntArray820[i24]);
							}
						}

						anInt759 = j8;
					} else {
						int k8 = DataUtils.method344(buffer, i1);
						i1 += 2;
						int i15 = sceneX + buffer[i1++];
						int l19 = sceneY + buffer[i1++];
						int j24 = 0;
						for(int i27 = 0; i27 < anInt759; i27++)
							if(anIntArray757[i27] != i15 || anIntArray758[i27] != l19) {
								if(i27 != j24) {
									aModelArray787[j24] = aModelArray787[i27];
									aModelArray787[j24].anInt228 = j24;
									anIntArray757[j24] = anIntArray757[i27];
									anIntArray758[j24] = anIntArray758[i27];
									anIntArray820[j24] = anIntArray820[i27];
									anIntArray843[j24] = anIntArray843[i27];
								}
								j24++;
							} else {
								scene.method271(aModelArray787[i27]);
								world.method390(anIntArray757[i27], anIntArray758[i27], anIntArray820[i27]);
							}

						anInt759 = j24;
						if(k8 != 60000) {
							int l29 = world.method407(i15, l19);
							int i34;
							int j37;
							if(l29 == 0 || l29 == 4) {
								i34 = Definitions.anIntArray110[k8];
								j37 = Definitions.anIntArray111[k8];
							} else {
								j37 = Definitions.anIntArray110[k8];
								i34 = Definitions.anIntArray111[k8];
							}
							int j40 = ((i15 + i15 + i34) * anInt676) / 2;
							int i42 = ((l19 + l19 + j37) * anInt676) / 2;
							int k43 = Definitions.anIntArray109[k8];
							Model model1 = aModelArray657[k43].method181();
							scene.method305(model1);
							model1.anInt228 = anInt759;
							model1.method204(0, l29 * 32, 0);
							model1.method197(j40, -world.method410(j40, i42), i42);
							model1.method205(true, 48, 48, -50, -10, -50);
							world.method400(i15, l19, k8);
							if(k8 == 74)
								model1.method197(0, -480, 0);
							anIntArray757[anInt759] = i15;
							anIntArray758[anInt759] = l19;
							anIntArray820[anInt759] = k8;
							anIntArray843[anInt759] = l29;
							aModelArray787[anInt759++] = model1;
						}
					}

				return;
			}
			//SEND_INVENTORY
			if(i == 53) {
				int offset = 1;
				inventorySize = buffer[offset++] & 255;
				for(int slot = 0; slot < inventorySize; slot++) {
					int j15 = DataUtils.method344(buffer, offset);
					offset += 2;
					inventoryItemsIDs[slot] = j15 & 32767;
					inventoryItemsEquipped[slot] = j15 / 32768;
					if(Definitions.inventoryItemsStackable[j15 & 32767] == 0) {
						inventoryItemsQuantities[slot] = DataUtils.method341(buffer, offset);
						if(inventoryItemsQuantities[slot] >= 128)
							offset += 4;
						else
							offset++;
					} else {
						inventoryItemsQuantities[slot] = 1;
					}
				}
				KEventKt.getKEVENT().post(new Event<>(new UpdateInventoryPacket()));
				return;
			}
			if(i == 234) {
				int k1 = DataUtils.method344(buffer, 1);
				int i9 = 3;
				for(int k15 = 0; k15 < k1; k15++) {
					int i20 = DataUtils.method344(buffer, i9);
					i9 += 2;
					RsCharacter rscharacter = aRsCharacterArray806[i20];
					byte byte6 = buffer[i9];
					i9++;
					if(byte6 == 0) {
						int i30 = DataUtils.method344(buffer, i9);
						i9 += 2;
						if(rscharacter != null) {
							rscharacter.anInt160 = 150;
							rscharacter.anInt159 = i30;
						}
					} else
					if(byte6 == 1) {
						byte byte7 = buffer[i9];
						i9++;
						if(rscharacter != null) {
							String s2 = ChatEncoding.method388(buffer, i9, byte7);
							//String s2 = ChatFilter.method380(ChatEncoding.method388(abyte0, i9, byte7)); TODO: check
							boolean flag3 = false;
							for(int k40 = 0; k40 < super.anInt606; k40++)
								if(super.aLongArray605[k40] == rscharacter.aLong145)
									flag3 = true;

							if(!flag3) {
								rscharacter.anInt158 = 150;
								rscharacter.aString157 = s2;
								method79(rscharacter.aString146 + ": " + rscharacter.aString157, 2);
							}
						}
						i9 += byte7;
					} else
					if(byte6 == 2) {
						int j30 = DataUtils.method340(buffer[i9]);
						i9++;
						int j34 = DataUtils.method340(buffer[i9]);
						i9++;
						int k37 = DataUtils.method340(buffer[i9]);
						i9++;
						if(rscharacter != null) {
							rscharacter.anInt161 = j30;
							rscharacter.anInt162 = j34;
							rscharacter.anInt163 = k37;
							rscharacter.anInt164 = 200;
							if(rscharacter == localPlayer) {
								anIntArray875[3] = j34;
								anIntArray842[3] = k37;
								aBoolean810 = false;
								aBoolean790 = false;
							}
						}
					} else
					if(byte6 == 3) {
						int k30 = DataUtils.method344(buffer, i9);
						i9 += 2;
						int k34 = DataUtils.method344(buffer, i9);
						i9 += 2;
						if(rscharacter != null) {
							rscharacter.anInt169 = k30;
							rscharacter.anInt171 = k34;
							rscharacter.anInt170 = -1;
							rscharacter.anInt172 = anInt876;
						}
					} else
					if(byte6 == 4) {
						int l30 = DataUtils.method344(buffer, i9);
						i9 += 2;
						int l34 = DataUtils.method344(buffer, i9);
						i9 += 2;
						if(rscharacter != null) {
							rscharacter.anInt169 = l30;
							rscharacter.anInt170 = l34;
							rscharacter.anInt171 = -1;
							rscharacter.anInt172 = anInt876;
						}
					} else
					if(byte6 == 5) {
						if(rscharacter != null) {
							rscharacter.anInt148 = DataUtils.method344(buffer, i9);
							i9 += 2;
							rscharacter.aLong145 = DataUtils.method348(buffer, i9);
							i9 += 8;
							rscharacter.aString146 = DataUtils.method351(rscharacter.aLong145);
							int i31 = DataUtils.method340(buffer[i9]);
							i9++;
							for(int i35 = 0; i35 < i31; i35++) {
								rscharacter.anIntArray176[i35] = DataUtils.method340(buffer[i9]);
								i9++;
							}

							for(int l37 = i31; l37 < 12; l37++)
								rscharacter.anIntArray176[l37] = 0;

							rscharacter.anInt165 = buffer[i9++] & 0xff;
							rscharacter.anInt166 = buffer[i9++] & 0xff;
							rscharacter.anInt167 = buffer[i9++] & 0xff;
							rscharacter.anInt168 = buffer[i9++] & 0xff;
							rscharacter.anInt177 = buffer[i9++] & 0xff;
							rscharacter.anInt173 = buffer[i9++] & 0xff;
						} else {
							i9 += 14;
							int j31 = DataUtils.method340(buffer[i9]);
							i9 += j31 + 1;
						}
					} else
					if(byte6 == 6) {
						byte byte8 = buffer[i9];
						i9++;
						if(rscharacter != null) {
							String s3 = ChatEncoding.method388(buffer, i9, byte8);
							rscharacter.anInt158 = 150;
							rscharacter.aString157 = s3;
							if(rscharacter == localPlayer)
								method79(rscharacter.aString146 + ": " + rscharacter.aString157, 5);
						}
						i9 += byte8;
					}
				}

				return;
			}
			if(i == 91) {
				for(int l1 = 1; l1 < j;)
					if(DataUtils.method340(buffer[l1]) == 255) {
						int j9 = 0;
						int l15 = sceneX + buffer[l1 + 1] >> 3;
						int j20 = sceneY + buffer[l1 + 2] >> 3;
						l1 += 3;
						for(int k24 = 0; k24 < anInt826; k24++) {
							int j27 = (anIntArray822[k24] >> 3) - l15;
							int k31 = (anIntArray823[k24] >> 3) - j20;
							if(j27 != 0 || k31 != 0) {
								if(k24 != j9) {
									aModelArray821[j9] = aModelArray821[k24];
									aModelArray821[j9].anInt228 = j9 + 10000;
									anIntArray822[j9] = anIntArray822[k24];
									anIntArray823[j9] = anIntArray823[k24];
									wallObjectDirection[j9] = wallObjectDirection[k24];
									wallObjectID[j9] = wallObjectID[k24];
								}
								j9++;
							} else {
								scene.method271(aModelArray821[k24]);
								world.method391(anIntArray822[k24], anIntArray823[k24], wallObjectDirection[k24], wallObjectID[k24]);
							}
						}

						anInt826 = j9;
					} else {
						int k9 = DataUtils.method344(buffer, l1);
						l1 += 2;
						int i16 = sceneX + buffer[l1++];
						int k20 = sceneY + buffer[l1++];
						byte byte5 = buffer[l1++];
						int k27 = 0;
						for(int l31 = 0; l31 < anInt826; l31++)
							if(anIntArray822[l31] != i16 || anIntArray823[l31] != k20 || wallObjectDirection[l31] != byte5) {
								if(l31 != k27) {
									aModelArray821[k27] = aModelArray821[l31];
									aModelArray821[k27].anInt228 = k27 + 10000;
									anIntArray822[k27] = anIntArray822[l31];
									anIntArray823[k27] = anIntArray823[l31];
									wallObjectDirection[k27] = wallObjectDirection[l31];
									wallObjectID[k27] = wallObjectID[l31];
								}
								k27++;
							} else {
								scene.method271(aModelArray821[l31]);
								world.method391(anIntArray822[l31], anIntArray823[l31], wallObjectDirection[l31], wallObjectID[l31]);
							}

						anInt826 = k27;
						if(k9 != 65535) {
							world.method401(i16, k20, byte5, k9);
							Model model = method50(i16, k20, byte5, k9, anInt826);
							aModelArray821[anInt826] = model;
							anIntArray822[anInt826] = i16;
							anIntArray823[anInt826] = k20;
							wallObjectID[anInt826] = k9;
							wallObjectDirection[anInt826++] = byte5;
						}
					}

				return;
			}
			if(i == 79) {
				anInt718 = npcCount;
				npcCount = 0;
				for(int i2 = 0; i2 < anInt718; i2++)
					aRsCharacterArray717[i2] = aRsCharacterArray677[i2];

				int l9 = 8;
				int j16 = DataUtils.method350(buffer, l9, 8);
				l9 += 8;
				for(int l20 = 0; l20 < j16; l20++) {
					RsCharacter rscharacter1 = aRsCharacterArray717[l20];
					int l27 = DataUtils.method350(buffer, l9, 1);
					l9++;
					if(l27 != 0) {
						int i32 = DataUtils.method350(buffer, l9, 1);
						l9++;
						if(i32 == 0) {
							int j35 = DataUtils.method350(buffer, l9, 3);
							l9 += 3;
							int i38 = rscharacter1.anInt156;
							int l40 = rscharacter1.anIntArray174[i38];
							int j42 = rscharacter1.anIntArray175[i38];
							if(j35 == 2 || j35 == 1 || j35 == 3)
								l40 += anInt676;
							if(j35 == 6 || j35 == 5 || j35 == 7)
								l40 -= anInt676;
							if(j35 == 4 || j35 == 3 || j35 == 5)
								j42 += anInt676;
							if(j35 == 0 || j35 == 1 || j35 == 7)
								j42 -= anInt676;
							rscharacter1.anInt154 = j35;
							rscharacter1.anInt156 = i38 = (i38 + 1) % 10;
							rscharacter1.anIntArray174[i38] = l40;
							rscharacter1.anIntArray175[i38] = j42;
						} else {
							int k35 = DataUtils.method350(buffer, l9, 4);
							if((k35 & 0xc) == 12) {
								l9 += 2;
								continue;
							}
							rscharacter1.anInt154 = DataUtils.method350(buffer, l9, 4);
							l9 += 4;
						}
					}
					aRsCharacterArray677[npcCount++] = rscharacter1;
				}

				while(l9 + 34 < j * 8)  {
					int l24 = DataUtils.method350(buffer, l9, 12);
					l9 += 12;
					int i28 = DataUtils.method350(buffer, l9, 5);
					l9 += 5;
					if(i28 > 15)
						i28 -= 32;
					int j32 = DataUtils.method350(buffer, l9, 5);
					l9 += 5;
					if(j32 > 15)
						j32 -= 32;
					int l35 = DataUtils.method350(buffer, l9, 4);
					l9 += 4;
					int j38 = (sceneX + i28) * anInt676 + 64;
					int i41 = (sceneY + j32) * anInt676 + 64;
					int k42 = DataUtils.method350(buffer, l9, 10);
					l9 += 10;
					if(k42 >= Definitions.anInt75)
						k42 = 24;
					method53(l24, j38, i41, l35, k42);
				}
				return;
			}
			if(i == 104) {
				int j2 = DataUtils.method344(buffer, 1);
				int i10 = 3;
				for(int k16 = 0; k16 < j2; k16++) {
					int i21 = DataUtils.method344(buffer, i10);
					i10 += 2;
					RsCharacter rscharacter2 = aRsCharacterArray716[i21];
					int j28 = DataUtils.method340(buffer[i10]);
					i10++;
					if(j28 == 1) {
						int k32 = DataUtils.method344(buffer, i10);
						i10 += 2;
						byte byte9 = buffer[i10];
						i10++;
						if(rscharacter2 != null) {
							String s4 = ChatEncoding.method388(buffer, i10, byte9);
							rscharacter2.anInt158 = 150;
							rscharacter2.aString157 = s4;
							if(k32 == localPlayer.anInt147)
								method79("@yel@" + Definitions.aStringArray76[rscharacter2.anInt151] + ": " + rscharacter2.aString157, 5);
						}
						i10 += byte9;
					} else
					if(j28 == 2) {
						int l32 = DataUtils.method340(buffer[i10]);
						i10++;
						int i36 = DataUtils.method340(buffer[i10]);
						i10++;
						int k38 = DataUtils.method340(buffer[i10]);
						i10++;
						if(rscharacter2 != null) {
							rscharacter2.anInt161 = l32;
							rscharacter2.anInt162 = i36;
							rscharacter2.anInt163 = k38;
							rscharacter2.anInt164 = 200;
						}
					}
				}

				return;
			}
			if(i == 245) {
				aBoolean656 = true;
				int k2 = DataUtils.method340(buffer[1]);
				anInt655 = k2;
				int j10 = 2;
				for(int l16 = 0; l16 < k2; l16++) {
					int j21 = DataUtils.method340(buffer[j10]);
					j10++;
					menuOptions[l16] = new String(buffer, j10, j21);
					j10 += j21;
				}

				return;
			}
			if(i == 252) {
				aBoolean656 = false;
				return;
			}
			if(i == 25) {
				aBoolean877 = true;
				localPlayerServerIdx = DataUtils.method344(buffer, 1);
				anInt829 = DataUtils.method344(buffer, 3);
				anInt828 = DataUtils.method344(buffer, 5);
				anInt878 = DataUtils.method344(buffer, 7);
				anInt879 = DataUtils.method344(buffer, 9);
				anInt828 -= anInt878 * anInt879;
				return;
			}
			if(i == 156) {
				int l2 = 1;
				for(int k10 = 0; k10 < 18; k10++)
					anIntArray875[k10] = DataUtils.method340(buffer[l2++]);

				for(int i17 = 0; i17 < 18; i17++)
					anIntArray842[i17] = DataUtils.method340(buffer[l2++]);

				for(int k21 = 0; k21 < 18; k21++) {
					anIntArray880[k21] = DataUtils.method343(buffer, l2);
					l2 += 4;
				}

				anInt881 = DataUtils.method340(buffer[l2++]);
				return;
			}
			if(i == 153) {
				for(int i3 = 0; i3 < 5; i3++)
					anIntArray882[i3] = DataUtils.method340(buffer[1 + i3]);

				return;
			}
			if(i == 83) {
				anInt883 = 250;
				return;
			}
			if(i == 211) {
				int j3 = (j - 1) / 4;
				for(int l10 = 0; l10 < j3; l10++) {
					int j17 = sceneX + DataUtils.method345(buffer, 1 + l10 * 4) >> 3;
					int l21 = sceneY + DataUtils.method345(buffer, 3 + l10 * 4) >> 3;
					int i25 = 0;
					for(int k28 = 0; k28 < anInt762; k28++) {
						int i33 = (anIntArray760[k28] >> 3) - j17;
						int j36 = (anIntArray761[k28] >> 3) - l21;
						if(i33 != 0 || j36 != 0) {
							if(k28 != i25) {
								anIntArray760[i25] = anIntArray760[k28];
								anIntArray761[i25] = anIntArray761[k28];
								anIntArray841[i25] = anIntArray841[k28];
								anIntArray873[i25] = anIntArray873[k28];
							}
							i25++;
						}
					}

					anInt762 = i25;
					i25 = 0;
					for(int j33 = 0; j33 < anInt759; j33++) {
						int k36 = (anIntArray757[j33] >> 3) - j17;
						int l38 = (anIntArray758[j33] >> 3) - l21;
						if(k36 != 0 || l38 != 0) {
							if(j33 != i25) {
								aModelArray787[i25] = aModelArray787[j33];
								aModelArray787[i25].anInt228 = i25;
								anIntArray757[i25] = anIntArray757[j33];
								anIntArray758[i25] = anIntArray758[j33];
								anIntArray820[i25] = anIntArray820[j33];
								anIntArray843[i25] = anIntArray843[j33];
							}
							i25++;
						} else {
							scene.method271(aModelArray787[j33]);
							world.method390(anIntArray757[j33], anIntArray758[j33], anIntArray820[j33]);
						}
					}

					anInt759 = i25;
					i25 = 0;
					for(int l36 = 0; l36 < anInt826; l36++) {
						int i39 = (anIntArray822[l36] >> 3) - j17;
						int j41 = (anIntArray823[l36] >> 3) - l21;
						if(i39 != 0 || j41 != 0) {
							if(l36 != i25) {
								aModelArray821[i25] = aModelArray821[l36];
								aModelArray821[i25].anInt228 = i25 + 10000;
								anIntArray822[i25] = anIntArray822[l36];
								anIntArray823[i25] = anIntArray823[l36];
								wallObjectDirection[i25] = wallObjectDirection[l36];
								wallObjectID[i25] = wallObjectID[l36];
							}
							i25++;
						} else {
							scene.method271(aModelArray821[l36]);
							world.method391(anIntArray822[l36], anIntArray823[l36], wallObjectDirection[l36], wallObjectID[l36]);
						}
					}

					anInt826 = i25;
				}

				return;
			}
			if(i == 59) {
				aBoolean751 = true;
				return;
			}
			if(i == 92) {
				int k3 = DataUtils.method344(buffer, 1);
				if(aRsCharacterArray806[k3] != null)
					aString884 = aRsCharacterArray806[k3].aString146;
				aBoolean815 = true;
				aBoolean885 = false;
				aBoolean886 = false;
				anInt887 = 0;
				anInt888 = 0;
				return;
			}
			if(i == 128) {
				aBoolean815 = false;
				showDialogTradeConfirm = false;
				return;
			}
			if(i == 97) {
				anInt888 = buffer[1] & 0xff;
				int l3 = 2;
				for(int i11 = 0; i11 < anInt888; i11++) {
					anIntArray889[i11] = DataUtils.method344(buffer, l3);
					l3 += 2;
					anIntArray890[i11] = DataUtils.method343(buffer, l3);
					l3 += 4;
				}

				aBoolean885 = false;
				aBoolean886 = false;
				return;
			}
			if(i == 162) {
				byte byte0 = buffer[1];
				if(byte0 == 1) {
					aBoolean885 = true;
					return;
				} else {
					aBoolean885 = false;
					return;
				}
			}
			if(i == 101) {
				aBoolean813 = true;
				int i4 = 1;
				int j11 = buffer[i4++] & 0xff;
				byte byte4 = buffer[i4++];
				anInt855 = buffer[i4++] & 0xff;
				anInt853 = buffer[i4++] & 0xff;
				for(int i22 = 0; i22 < 40; i22++)
					anIntArray849[i22] = -1;

				for(int j25 = 0; j25 < j11; j25++) {
					anIntArray849[j25] = DataUtils.method344(buffer, i4);
					i4 += 2;
					anIntArray852[j25] = DataUtils.method344(buffer, i4);
					i4 += 2;
					anIntArray854[j25] = buffer[i4++];
				}

				if(byte4 == 1) {
					int l28 = 39;
					for(int k33 = 0; k33 < inventorySize; k33++) {
						if(l28 < j11)
							break;
						boolean flag2 = false;
						for(int j39 = 0; j39 < 40; j39++) {
							if(anIntArray849[j39] != inventoryItemsIDs[k33])
								continue;
							flag2 = true;
							break;
						}

						if(inventoryItemsIDs[k33] == 10)
							flag2 = true;
						if(!flag2) {
							anIntArray849[l28] = inventoryItemsIDs[k33] & 0x7fff;
							anIntArray852[l28] = 0;
							anIntArray854[l28] = 0;
							l28--;
						}
					}

				}
				if(anInt850 >= 0 && anInt850 < 40 && anIntArray849[anInt850] != anInt851) {
					anInt850 = -1;
					anInt851 = -2;
				}
				return;
			}
			if(i == 137) {
				aBoolean813 = false;
				return;
			}
			if(i == 15) {
				byte byte1 = buffer[1];
				if(byte1 == 1) {
					aBoolean886 = true;
					return;
				} else {
					aBoolean886 = false;
					return;
				}
			}
			if(i == 240) {
				aBoolean869 = DataUtils.method340(buffer[1]) == 1;
				aBoolean861 = DataUtils.method340(buffer[2]) == 1;
				aBoolean784 = DataUtils.method340(buffer[3]) == 1;
				return;
			}
			if(i == 206) {
				for(int j4 = 0; j4 < j - 1; j4++) {
					boolean flag = buffer[j4 + 1] == 1;
					if(!aBooleanArray827[j4] && flag)
						SoundPlayer.play("prayeron");
					if(aBooleanArray827[j4] && !flag)
						SoundPlayer.play("prayeroff");
					aBooleanArray827[j4] = flag;
				}

				return;
			}
			if(i == 5) {
				for(int k4 = 0; k4 < 50; k4++)
					aBooleanArray891[k4] = buffer[k4 + 1] == 1;

				return;
			}
			if(i == 42) {
				aBoolean812 = true;
				int l4 = 1;
				anInt662 = buffer[l4++] & 0xff;
				bankItemsMax = buffer[l4++] & 0xff;
				for(int k11 = 0; k11 < anInt662; k11++) {
					anIntArray665[k11] = DataUtils.method344(buffer, l4);
					l4 += 2;
					anIntArray667[k11] = DataUtils.method341(buffer, l4);
					if(anIntArray667[k11] >= 128)
						l4 += 4;
					else
						l4++;
				}

				method49();
				return;
			}
			if(i == 203) {
				aBoolean812 = false;
				return;
			}
			if(i == 33) {
				int i5 = buffer[1] & 0xff;
				anIntArray880[i5] = DataUtils.method343(buffer, 2);
				return;
			}
			if(i == 176) {
				int j5 = DataUtils.method344(buffer, 1);
				if(aRsCharacterArray806[j5] != null)
					aString892 = aRsCharacterArray806[j5].aString146;
				aBoolean817 = true;
				anInt893 = 0;
				anInt894 = 0;
				aBoolean895 = false;
				aBoolean896 = false;
				aBoolean897 = false;
				aBoolean898 = false;
				aBoolean899 = false;
				aBoolean900 = false;
				return;
			}
			if(i == 225) {
				aBoolean817 = false;
				aBoolean816 = false;
				return;
			}
			if(i == 20) {
				showDialogTradeConfirm = true;
				tradeConfirmAccepted = false;
				aBoolean815 = false;
				int k5 = 1;
				aLong902 = DataUtils.method348(buffer, k5);
				k5 += 8;
				anInt903 = buffer[k5++] & 0xff;
				for(int l11 = 0; l11 < anInt903; l11++) {
					anIntArray904[l11] = DataUtils.method344(buffer, k5);
					k5 += 2;
					anIntArray905[l11] = DataUtils.method343(buffer, k5);
					k5 += 4;
				}

				anInt906 = buffer[k5++] & 0xff;
				for(int k17 = 0; k17 < anInt906; k17++) {
					anIntArray907[k17] = DataUtils.method344(buffer, k5);
					k5 += 2;
					anIntArray908[k17] = DataUtils.method343(buffer, k5);
					k5 += 4;
				}

				return;
			}
			if(i == 6) {
				anInt894 = buffer[1] & 0xff;
				int l5 = 2;
				for(int i12 = 0; i12 < anInt894; i12++) {
					anIntArray909[i12] = DataUtils.method344(buffer, l5);
					l5 += 2;
					anIntArray910[i12] = DataUtils.method343(buffer, l5);
					l5 += 4;
				}

				aBoolean895 = false;
				aBoolean896 = false;
				return;
			}
			if(i == 30) {
				if(buffer[1] == 1)
					aBoolean897 = true;
				else
					aBoolean897 = false;
				if(buffer[2] == 1)
					aBoolean898 = true;
				else
					aBoolean898 = false;
				if(buffer[3] == 1)
					aBoolean899 = true;
				else
					aBoolean899 = false;
				if(buffer[4] == 1)
					aBoolean900 = true;
				else
					aBoolean900 = false;
				aBoolean895 = false;
				aBoolean896 = false;
				return;
			}
			if(i == 249) {
				int i6 = 1;
				int j12 = buffer[i6++] & 0xff;
				int l17 = DataUtils.method344(buffer, i6);
				i6 += 2;
				int j22 = DataUtils.method341(buffer, i6);
				if(j22 >= 128)
					i6 += 4;
				else
					i6++;
				if(j22 == 0) {
					anInt662--;
					for(int k25 = j12; k25 < anInt662; k25++) {
						anIntArray665[k25] = anIntArray665[k25 + 1];
						anIntArray667[k25] = anIntArray667[k25 + 1];
					}

				} else {
					anIntArray665[j12] = l17;
					anIntArray667[j12] = j22;
					if(j12 >= anInt662)
						anInt662 = j12 + 1;
				}
				method49();
				return;
			}
			//SEND_INVENTORY_UPDATEITEM
			if(i == 90) {
				int j6 = 1;
				int k12 = 1;
				int i18 = buffer[j6++] & 0xff;
				int k22 = DataUtils.method344(buffer, j6);
				j6 += 2;
				if(Definitions.inventoryItemsStackable[k22 & 0x7fff] == 0) {
					k12 = DataUtils.method341(buffer, j6);
					if(k12 >= 128)
						j6 += 4;
					else
						j6++;
				}
				inventoryItemsIDs[i18] = k22 & 0x7fff;
				inventoryItemsEquipped[i18] = k22 / 32768;
				inventoryItemsQuantities[i18] = k12;
				if(i18 >= inventorySize)
					inventorySize = i18 + 1;
				KEventKt.getKEVENT().post(new Event<>(new UpdateInventoryPacket()));
				return;
			}
			//SEND_INVENTORY_REMOVE_ITEM
			if(i == 123) {
				int k6 = buffer[1] & 0xff;
				inventorySize--;
				for(int l12 = k6; l12 < inventorySize; l12++) {
					inventoryItemsIDs[l12] = inventoryItemsIDs[l12 + 1];
					inventoryItemsQuantities[l12] = inventoryItemsQuantities[l12 + 1];
					inventoryItemsEquipped[l12] = inventoryItemsEquipped[l12 + 1];
				}
				KEventKt.getKEVENT().post(new Event<>(new UpdateInventoryPacket()));
				return;
			}
			if(i == 159) {
				int l6 = 1;
				int i13 = buffer[l6++] & 0xff;
				anIntArray875[i13] = DataUtils.method340(buffer[l6++]);
				anIntArray842[i13] = DataUtils.method340(buffer[l6++]);
				anIntArray880[i13] = DataUtils.method343(buffer, l6);
				l6 += 4;
				return;
			}
			if(i == 253) {
				byte byte2 = buffer[1];
				if(byte2 == 1) {
					aBoolean895 = true;
					return;
				} else {
					aBoolean895 = false;
					return;
				}
			}
			if(i == 210) {
				byte byte3 = buffer[1];
				if(byte3 == 1) {
					aBoolean896 = true;
					return;
				} else {
					aBoolean896 = false;
					return;
				}
			}
			if(i == 172) {
				aBoolean816 = true;
				aBoolean911 = false;
				aBoolean817 = false;
				int i7 = 1;
				aLong912 = DataUtils.method348(buffer, i7);
				i7 += 8;
				anInt913 = buffer[i7++] & 0xff;
				for(int j13 = 0; j13 < anInt913; j13++) {
					anIntArray914[j13] = DataUtils.method344(buffer, i7);
					i7 += 2;
					anIntArray915[j13] = DataUtils.method343(buffer, i7);
					i7 += 4;
				}

				anInt916 = buffer[i7++] & 0xff;
				for(int j18 = 0; j18 < anInt916; j18++) {
					anIntArray917[j18] = DataUtils.method344(buffer, i7);
					i7 += 2;
					anIntArray918[j18] = DataUtils.method343(buffer, i7);
					i7 += 4;
				}

				anInt919 = buffer[i7++] & 0xff;
				anInt920 = buffer[i7++] & 0xff;
				anInt921 = buffer[i7++] & 0xff;
				anInt922 = buffer[i7++] & 0xff;
				return;
			}
			if(i == 204) {
				String s = new String(buffer, 1, j - 1);
				SoundPlayer.play(s);
				return;
			}
			if(i == 36) {
				if(anInt923 < 50) {
					int j7 = buffer[1] & 0xff;
					int k13 = buffer[2] + sceneX;
					int k18 = buffer[3] + sceneY;
					anIntArray660[anInt923] = j7;
					teleportBubbleTime[anInt923] = 0;
					anIntArray924[anInt923] = k13;
					anIntArray925[anInt923] = k18;
					anInt923++;
				}
				return;
			}
			if(i == 182) {
				if(!aBoolean818) {
					anInt926 = DataUtils.method343(buffer, 1);
					anInt927 = DataUtils.method344(buffer, 5);
					anInt928 = buffer[7] & 0xff;
					anInt929 = DataUtils.method344(buffer, 8);
					aBoolean810 = true;
					aBoolean818 = true;
					aString930 = null;
				}
				return;
			}
			if(i == 89) {
				aString789 = new String(buffer, 1, j - 1);
				aBoolean790 = true;
				aBoolean788 = false;
				return;
			}
			if(i == 222) {
				aString789 = new String(buffer, 1, j - 1);
				aBoolean790 = true;
				aBoolean788 = true;
				return;
			}
			if(i == 114) {
				anInt931 = DataUtils.method344(buffer, 1);
				return;
			}
			if(i == 117) {
				if(!aBoolean793)
					anInt932 = anInt931;
				aBoolean793 = true;
				super.inputTextCurrent = "";
				super.inputTextFinal = "";
				surface.method234(anInt933 + 1, buffer);
				aString934 = null;
				return;
			}
			if(i == 244) {
				anInt932 = DataUtils.method344(buffer, 1);
				return;
			}
			if(i == 84) {
				aBoolean793 = false;
				return;
			}
			if(i == 194) {
				aString934 = "Incorrect - Please wait...";
				return;
			}
			if(i == 52) {
				anInt803 = DataUtils.method344(buffer, 1) * 32;
				return;
			}
		}
		catch(RuntimeException runtimeexception) {
			if(anInt935 < 3) {
				super.packetStream.createPacket(3);
				super.packetStream.method329(runtimeexception.toString());
				super.packetStream.endPacket();
				super.packetStream.createPacket(3);
				super.packetStream.method329("p-type:" + i + " p-size:" + j);
				super.packetStream.endPacket();
				super.packetStream.createPacket(3);
				super.packetStream.method329("rx:" + sceneX + " ry:" + sceneY + " num3l:" + anInt759);
				super.packetStream.endPacket();
				String s1 = "";
				for(int l18 = 0; l18 < 80 && l18 < j; l18++)
					s1 = s1 + buffer[l18] + " ";

				super.packetStream.createPacket(3);
				super.packetStream.method329(s1);
				super.packetStream.endPacket();
				anInt935++;
			}
		}
	}

	protected final void method2() {
		method36();
		method88();
	}

	private final boolean method92(int i, int j, int k, int l, int i1, int j1, boolean flag, 
			boolean flag1) {
		int k1 = world.method398(i, j, k, l, i1, j1, anIntArray796, anIntArray797, flag);
		if(k1 == -1)
			return false;
		k1--;
		i = anIntArray796[k1];
		j = anIntArray797[k1];
		k1--;
		if(flag1)
			super.packetStream.createPacket(16);
		else
			super.packetStream.createPacket(187);
		super.packetStream.putShort(i + baseX);
		super.packetStream.putShort(j + baseY);
		if(flag1 && k1 == -1 && (i + baseX) % 5 == 0)
			k1 = 0;
		for(int l1 = k1; l1 >= 0 && l1 > k1 - 25; l1--) {
			super.packetStream.putByte(anIntArray796[l1] - i);
			super.packetStream.putByte(anIntArray797[l1] - j);
		}

		super.packetStream.endPacket();
		anInt800 = -24;
		anInt801 = super.anInt39;
		anInt802 = super.anInt41;
		return true;
	}

	private final boolean method93(int i, int j) {
		if(anInt883 != 0) {
			world.aBoolean572 = false;
			return false;
		}
		aBoolean877 = false;
		i += anInt829;
		j += anInt828;
		if(anInt936 == anInt878 && i > anInt937 && i < anInt938 && j > anInt939 && j < anInt940) {
			world.aBoolean572 = true;
			return false;
		}
		surface.method216("Loading... Please wait", 256, 192, 1, 0xffffff);
		method76();
		surface.drawSurface(aGraphics809, 0, 0);
		int k = baseX;
		int l = baseY;
		int i1 = (i + 24) / 48;
		int j1 = (j + 24) / 48;
		anInt936 = anInt878;
		baseX = i1 * 48 - 48;
		baseY = j1 * 48 - 48;
		anInt937 = i1 * 48 - 32;
		anInt939 = j1 * 48 - 32;
		anInt938 = i1 * 48 + 32;
		anInt940 = j1 * 48 + 32;
		world.method399(i, j, anInt936);
		baseX -= anInt829;
		baseY -= anInt828;
		int k1 = baseX - k;
		int l1 = baseY - l;
		for(int i2 = 0; i2 < anInt759; i2++) {
			anIntArray757[i2] -= k1;
			anIntArray758[i2] -= l1;
			int j2 = anIntArray757[i2];
			int l2 = anIntArray758[i2];
			int k3 = anIntArray820[i2];
			Model model = aModelArray787[i2];
			try {
				int l4 = anIntArray843[i2];
				int k5;
				int i6;
				if(l4 == 0 || l4 == 4) {
					k5 = Definitions.anIntArray110[k3];
					i6 = Definitions.anIntArray111[k3];
				} else {
					i6 = Definitions.anIntArray110[k3];
					k5 = Definitions.anIntArray111[k3];
				}
				int j6 = ((j2 + j2 + k5) * anInt676) / 2;
				int k6 = ((l2 + l2 + i6) * anInt676) / 2;
				if(j2 >= 0 && l2 >= 0 && j2 < 96 && l2 < 96) {
					scene.method305(model);
					model.method177(j6, -world.method410(j6, k6), k6);
					world.method400(j2, l2, k3);
					if(k3 == 74)
						model.method197(0, -480, 0);
				}
			}
			catch(RuntimeException runtimeexception) {
				System.out.println("Loc Error: " + runtimeexception.getMessage());
				System.out.println("i:" + i2 + " obj:" + model);
				runtimeexception.printStackTrace();
			}
		}

		for(int k2 = 0; k2 < anInt826; k2++) {
			anIntArray822[k2] -= k1;
			anIntArray823[k2] -= l1;
			int i3 = anIntArray822[k2];
			int l3 = anIntArray823[k2];
			int j4 = wallObjectID[k2];
			int i5 = wallObjectDirection[k2];
			try {
				world.method401(i3, l3, i5, j4);
				Model model1 = method50(i3, l3, i5, j4, k2);
				aModelArray821[k2] = model1;
			}
			catch(RuntimeException runtimeexception1) {
				System.out.println("Bound Error: " + runtimeexception1.getMessage());
				runtimeexception1.printStackTrace();
			}
		}

		for(int j3 = 0; j3 < anInt762; j3++) {
			anIntArray760[j3] -= k1;
			anIntArray761[j3] -= l1;
		}

		for(int i4 = 0; i4 < playerCount; i4++) {
			RsCharacter rscharacter = aRsCharacterArray694[i4];
			rscharacter.anInt149 -= k1 * anInt676;
			rscharacter.anInt150 -= l1 * anInt676;
			for(int j5 = 0; j5 <= rscharacter.anInt156; j5++) {
				rscharacter.anIntArray174[j5] -= k1 * anInt676;
				rscharacter.anIntArray175[j5] -= l1 * anInt676;
			}

		}

		for(int k4 = 0; k4 < npcCount; k4++) {
			RsCharacter rscharacter1 = aRsCharacterArray677[k4];
			rscharacter1.anInt149 -= k1 * anInt676;
			rscharacter1.anInt150 -= l1 * anInt676;
			for(int l5 = 0; l5 <= rscharacter1.anInt156; l5++) {
				rscharacter1.anIntArray174[l5] -= k1 * anInt676;
				rscharacter1.anIntArray175[l5] -= l1 * anInt676;
			}

		}

		world.aBoolean572 = true;
		return true;
	}

	private final void method94() {
		surface.method207(126, 137, 260, 60, 0);
		surface.method214(126, 137, 260, 60, 0xffffff);
		surface.method216("Logging out...", 256, 173, 5, 0xffffff);
	}

	private final void method95() {
		world.aByteArray588 = readDataFile("maps" + Versions.anInt561 + ".jag", "map", 70);
		if(isMembers)
			world.aByteArray589 = readDataFile("maps" + Versions.anInt561 + ".mem", "members map", 75);
		world.aByteArray586 = readDataFile("land" + Versions.anInt561 + ".jag", "landscape", 80);
		if(isMembers)
			world.aByteArray587 = readDataFile("land" + Versions.anInt561 + ".mem", "members landscape", 85);
	}

	private final void method96() {
		byte abyte0[] = readDataFile("media" + Versions.anInt562 + ".jag", "2d graphics", 20);
		if(abyte0 == null) {
			aBoolean705 = true;
			return;
		}
		byte abyte1[] = DataUtils.loadData("index.dat", 0, abyte0);
		surface.method211(anInt658, DataUtils.loadData("inv1.dat", 0, abyte0), abyte1, 1);
		surface.method211(anInt658 + 1, DataUtils.loadData("inv2.dat", 0, abyte0), abyte1, 6);
		surface.method211(anInt658 + 9, DataUtils.loadData("bubble.dat", 0, abyte0), abyte1, 1);
		surface.method211(anInt658 + 10, DataUtils.loadData("runescape.dat", 0, abyte0), abyte1, 1);
		surface.method211(anInt658 + 11, DataUtils.loadData("splat.dat", 0, abyte0), abyte1, 3);
		surface.method211(anInt658 + 14, DataUtils.loadData("icon.dat", 0, abyte0), abyte1, 8);
		surface.method211(anInt658 + 22, DataUtils.loadData("hbar.dat", 0, abyte0), abyte1, 1);
		surface.method211(anInt658 + 23, DataUtils.loadData("hbar2.dat", 0, abyte0), abyte1, 1);
		surface.method211(anInt658 + 24, DataUtils.loadData("compass.dat", 0, abyte0), abyte1, 1);
		surface.method211(anInt658 + 25, DataUtils.loadData("buttons.dat", 0, abyte0), abyte1, 2);
		surface.method211(anInt941, DataUtils.loadData("scrollbar.dat", 0, abyte0), abyte1, 2);
		surface.method211(anInt941 + 2, DataUtils.loadData("corners.dat", 0, abyte0), abyte1, 4);
		surface.method211(anInt941 + 6, DataUtils.loadData("arrows.dat", 0, abyte0), abyte1, 2);
		surface.method211(anInt942, DataUtils.loadData("projectile.dat", 0, abyte0), abyte1, Definitions.anInt131);
		int i = Definitions.anInt74;
		for(int j = 1; i > 0; j++) {
			int k = i;
			i -= 30;
			if(k > 30)
				k = 30;
			surface.method211(anInt786 + (j - 1) * 30, DataUtils.loadData("objects" + j + ".dat", 0, abyte0), abyte1, k);
		}

		surface.method210(anInt658);
		surface.method210(anInt658 + 9);
		for(int l = 11; l <= 26; l++)
			surface.method210(anInt658 + l);

		for(int i1 = 0; i1 < Definitions.anInt131; i1++)
			surface.method210(anInt942 + i1);

		for(int j1 = 0; j1 < Definitions.anInt74; j1++)
			surface.method210(anInt786 + j1);

	}

	protected final int method38() {
		return link.uid;
	}

	private final void walkToGroundItem(int i, int j, int k, int l, boolean flag) {
		if(method92(i, j, k, l, k, l, false, flag)) {
			return;
		} else {
			method69(i, j, k, l, k, l, true, flag);
			return;
		}
	}

	private final void method98() {
		if(super.inputTextFinal.length() > 0) {
			String s = super.inputTextFinal.trim();
			super.inputTextCurrent = "";
			super.inputTextFinal = "";
			if(s.length() > 0) {
				long l = DataUtils.method356(s);
				super.packetStream.createPacket(206);
				super.packetStream.method332(l);
				super.packetStream.putByte(anInt943);
				super.packetStream.putByte(aBoolean944 ? 1 : 0);
				super.packetStream.endPacket();
			}
			anInt792 = 0;
			return;
		}
		surface.method207(56, 130, 400, 100, 0);
		surface.method214(56, 130, 400, 100, 0xffffff);
		int i = 160;
		surface.method216("Now type the name of the offending player, and press enter", 256, i, 1, 0xffff00);
		i += 18;
		surface.method216("Name: " + super.inputTextCurrent + "*", 256, i, 4, 0xffffff);
		if(super.anInt626 > 0) {
			i = 207;
			if(aBoolean944)
				surface.method216("Moderator option: Mute player for 48 hours: <ON>", 256, i, 1, 0xff8000);
			else
				surface.method216("Moderator option: Mute player for 48 hours: <OFF>", 256, i, 1, 0xffffff);
			if(super.anInt39 > 106 && super.anInt39 < 406 && super.anInt41 > i - 13 && super.anInt41 < i + 2 && anInt653 == 1) {
				anInt653 = 0;
				aBoolean944 = !aBoolean944;
			}
		}
		i = 222;
		int j = 0xffffff;
		if(super.anInt39 > 196 && super.anInt39 < 316 && super.anInt41 > i - 13 && super.anInt41 < i + 2) {
			j = 0xffff00;
			if(anInt653 == 1) {
				anInt653 = 0;
				anInt792 = 0;
			}
		}
		surface.method216("Click here to cancel", 256, i, 1, j);
		if(anInt653 == 1 && (super.anInt39 < 56 || super.anInt39 > 456 || super.anInt41 < 130 || super.anInt41 > 230)) {
			anInt653 = 0;
			anInt792 = 0;
		}
	}

	private final void method99() {
		if(anInt883 != 0) {
			surface.method209();
			surface.method216("Oh dear! You are dead...", anInt764 / 2, anInt765 / 2, 7, 0xff0000);
			method76();
			surface.drawSurface(aGraphics809, 0, 0);
			return;
		}
		if(aBoolean751) {
			method71();
			return;
		}
		if(aBoolean793) {
			surface.method209();
			if(Math.random() < 0.14999999999999999D)
				surface.method216("ZZZ", (int)(Math.random() * 80D), (int)(Math.random() * 334D), 5, (int)(Math.random() * 16777215D));
			if(Math.random() < 0.14999999999999999D)
				surface.method216("ZZZ", 512 - (int)(Math.random() * 80D), (int)(Math.random() * 334D), 5, (int)(Math.random() * 16777215D));
			surface.method207(anInt764 / 2 - 100, 160, 200, 40, 0);
			surface.method216("You are sleeping", anInt764 / 2, 50, 7, 0xffff00);
			surface.method216("Fatigue: " + (anInt932 * 100) / 750 + "%", anInt764 / 2, 90, 7, 0xffff00);
			surface.method216("When you want to wake up just use your", anInt764 / 2, 140, 5, 0xffffff);
			surface.method216("keyboard to type the word in the box below", anInt764 / 2, 160, 5, 0xffffff);
			surface.method216(super.inputTextCurrent + "*", anInt764 / 2, 180, 5, 65535);
			if(aString934 == null)
				surface.method246(anInt764 / 2 - 127, 230, anInt933 + 1);
			else
				surface.method216(aString934, anInt764 / 2, 260, 5, 0xff0000);
			surface.method214(anInt764 / 2 - 128, 229, 257, 42, 0xffffff);
			method76();
			surface.method216("If you can't read the word", anInt764 / 2, 290, 1, 0xffffff);
			surface.method216("@yel@click here@whi@ to get a different one", anInt764 / 2, 305, 1, 0xffffff);
			surface.drawSurface(aGraphics809, 0, 0);
			return;
		}
		if(!world.aBoolean572)
			return;
		for(int i = 0; i < 64; i++) {
			scene.method271(world.aModelArrayArray598[anInt936][i]);
			if(anInt936 == 0) {
				scene.method271(world.aModelArrayArray597[1][i]);
				scene.method271(world.aModelArrayArray598[1][i]);
				scene.method271(world.aModelArrayArray597[2][i]);
				scene.method271(world.aModelArrayArray598[2][i]);
			}
			aBoolean945 = true;
			if(anInt936 == 0 && (world.anIntArrayArray573[localPlayer.anInt149 / 128][localPlayer.anInt150 / 128] & 0x80) == 0) {
				scene.method305(world.aModelArrayArray598[anInt936][i]);
				if(anInt936 == 0) {
					scene.method305(world.aModelArrayArray597[1][i]);
					scene.method305(world.aModelArrayArray598[1][i]);
					scene.method305(world.aModelArrayArray597[2][i]);
					scene.method305(world.aModelArrayArray598[2][i]);
				}
				aBoolean945 = false;
			}
		}

		if(anInt946 != anInt947) {
			anInt947 = anInt946;
			for(int j = 0; j < anInt759; j++) {
				if(anIntArray820[j] == 97)
					method65(j, "firea" + (anInt946 + 1));
				if(anIntArray820[j] == 274)
					method65(j, "fireplacea" + (anInt946 + 1));
				if(anIntArray820[j] == 1031)
					method65(j, "lightning" + (anInt946 + 1));
				if(anIntArray820[j] == 1036)
					method65(j, "firespell" + (anInt946 + 1));
				if(anIntArray820[j] == 1147)
					method65(j, "spellcharge" + (anInt946 + 1));
			}

		}
		if(anInt948 != anInt949) {
			anInt949 = anInt948;
			for(int k = 0; k < anInt759; k++) {
				if(anIntArray820[k] == 51)
					method65(k, "torcha" + (anInt948 + 1));
				if(anIntArray820[k] == 143)
					method65(k, "skulltorcha" + (anInt948 + 1));
			}

		}
		if(anInt950 != anInt951) {
			anInt951 = anInt950;
			for(int l = 0; l < anInt759; l++)
				if(anIntArray820[l] == 1142)
					method65(l, "clawspell" + (anInt950 + 1));

		}
		scene.method265(anInt952);
		anInt952 = 0;
		for(int i1 = 0; i1 < playerCount; i1++) {
			RsCharacter rscharacter = aRsCharacterArray694[i1];
			if(rscharacter.anInt167 != 255) {
				int k1 = rscharacter.anInt149;
				int i2 = rscharacter.anInt150;
				int k2 = -world.method410(k1, i2);
				int l3 = scene.method290(5000 + i1, k1, k2, i2, 145, 220, i1 + 10000);
				anInt952++;
				if(rscharacter == localPlayer)
					scene.method277(l3);
				if(rscharacter.anInt153 == 8)
					scene.method293(l3, -30);
				if(rscharacter.anInt153 == 9)
					scene.method293(l3, 30);
			}
		}

		for(int j1 = 0; j1 < playerCount; j1++) {
			RsCharacter rscharacter1 = aRsCharacterArray694[j1];
			if(rscharacter1.anInt172 > 0) {
				RsCharacter rscharacter2 = null;
				if(rscharacter1.anInt171 != -1)
					rscharacter2 = aRsCharacterArray716[rscharacter1.anInt171];
				else
				if(rscharacter1.anInt170 != -1)
					rscharacter2 = aRsCharacterArray806[rscharacter1.anInt170];
				if(rscharacter2 != null) {
					int l2 = rscharacter1.anInt149;
					int i4 = rscharacter1.anInt150;
					int l6 = -world.method410(l2, i4) - 110;
					int l8 = rscharacter2.anInt149;
					int k9 = rscharacter2.anInt150;
					int l9 = -world.method410(l8, k9) - Definitions.anIntArray90[rscharacter2.anInt151] / 2;
					int i10 = (l2 * rscharacter1.anInt172 + l8 * (anInt876 - rscharacter1.anInt172)) / anInt876;
					int j10 = (l6 * rscharacter1.anInt172 + l9 * (anInt876 - rscharacter1.anInt172)) / anInt876;
					int k10 = (i4 * rscharacter1.anInt172 + k9 * (anInt876 - rscharacter1.anInt172)) / anInt876;
					scene.method290(anInt942 + rscharacter1.anInt169, i10, j10, k10, 32, 32, 0);
					anInt952++;
				}
			}
		}

		for(int l1 = 0; l1 < npcCount; l1++) {
			RsCharacter rscharacter3 = aRsCharacterArray677[l1];
			int i3 = rscharacter3.anInt149;
			int j4 = rscharacter3.anInt150;
			int i7 = -world.method410(i3, j4);
			int i9 = scene.method290(20000 + l1, i3, i7, j4, Definitions.anIntArray89[rscharacter3.anInt151], Definitions.anIntArray90[rscharacter3.anInt151], l1 + 30000);
			anInt952++;
			if(rscharacter3.anInt153 == 8)
				scene.method293(i9, -30);
			if(rscharacter3.anInt153 == 9)
				scene.method293(i9, 30);
		}

		for(int j2 = 0; j2 < anInt762; j2++) {
			int j3 = anIntArray760[j2] * anInt676 + 64;
			int k4 = anIntArray761[j2] * anInt676 + 64;
			scene.method290(40000 + anIntArray841[j2], j3, -world.method410(j3, k4) - anIntArray873[j2], k4, 96, 64, j2 + 20000);
			anInt952++;
		}

		for(int k3 = 0; k3 < anInt923; k3++) {
			int l4 = anIntArray924[k3] * anInt676 + 64;
			int j7 = anIntArray925[k3] * anInt676 + 64;
			int j9 = anIntArray660[k3];
			if(j9 == 0) {
				scene.method290(50000 + k3, l4, -world.method410(l4, j7), j7, 128, 256, k3 + 50000);
				anInt952++;
			}
			if(j9 == 1) {
				scene.method290(50000 + k3, l4, -world.method410(l4, j7), j7, 128, 64, k3 + 50000);
				anInt952++;
			}
		}

		surface.aBoolean321 = false;
		surface.method244();
		surface.aBoolean321 = super.interlace;
		if(anInt936 == 3) {
			int i5 = 40 + (int)(Math.random() * 3D);
			int k7 = 40 + (int)(Math.random() * 7D);
			scene.method297(i5, k7, -50, -10, -50);
		}
		anInt699 = 0;
		anInt685 = 0;
		anInt691 = 0;
		if(cameraAutoAngleDebug) {
			if(aBoolean869 && !aBoolean945) {
				int j5 = anInt652;
				method45();
				if(anInt652 != j5) {
					anInt954 = localPlayer.anInt149;
					anInt955 = localPlayer.anInt150;
				}
			}
			scene.anInt426 = 3000;
			scene.anInt430 = 3000;
			scene.anInt443 = 1;
			scene.anInt442 = 2800;
			anInt678 = anInt652 * 32;
			int k5 = anInt954 + anInt708;
			int l7 = anInt955 + anInt710;
			scene.method263(k5, -world.method410(k5, l7), l7, 912, anInt678 * 4, 0, 2000);
		} else {
			if(aBoolean869 && !aBoolean945)
				method45();
			if(!super.interlace) {
				scene.anInt426 = 2400;
				scene.anInt430 = 2400;
				scene.anInt443 = 1;
				scene.anInt442 = 2300;
			} else {
				scene.anInt426 = 2200;
				scene.anInt430 = 2200;
				scene.anInt443 = 1;
				scene.anInt442 = 2100;
			}
			int l5 = anInt954 + anInt708;
			int i8 = anInt955 + anInt710;
			scene.method263(l5, -world.method410(l5, i8), i8, 912, anInt678 * 4, 0, anInt956 * 2);
		}
		scene.method288();
		method64();
		if(anInt800 > 0)
			surface.method246(anInt801 - 8, anInt802 - 8, anInt658 + 14 + (24 - anInt800) / 6);
		if(anInt800 < 0)
			surface.method246(anInt801 - 8, anInt802 - 8, anInt658 + 18 + (24 + anInt800) / 6);
		if(anInt803 != 0) {
			int i6 = anInt803 / 50;
			int j8 = i6 / 60;
			i6 %= 60;
			if(i6 < 10)
				surface.method216("System update in: " + j8 + ":0" + i6, 256, anInt765 - 7, 1, 0xffff00);
			else
				surface.method216("System update in: " + j8 + ":" + i6, 256, anInt765 - 7, 1, 0xffff00);
		}
		if(!aBoolean877) {
			int j6 = 2203 - (sceneY + anInt828 + baseY);
			if(sceneX + anInt829 + baseX >= 2640)
				j6 = -50;
			if(j6 > 0) {
				int k8 = 1 + j6 / 6;
				surface.method246(453, anInt765 - 56, anInt658 + 13);
				surface.method216("Wilderness", 465, anInt765 - 20, 1, 0xffff00);
				surface.method216("Level: " + k8, 465, anInt765 - 7, 1, 0xffff00);
				if(anInt811 == 0)
					anInt811 = 2;
			}
			if(anInt811 == 0 && j6 > -10 && j6 <= 0)
				anInt811 = 1;
		}
		if(anInt845 == 0) {
			for(int k6 = 0; k6 < 5; k6++)
				if(anIntArray857[k6] > 0) {
					String s = aStringArray856[k6];
					surface.method254(s, 7, anInt765 - 18 - k6 * 12, 1, 0xffff00);
				}

		}
		aPanel794.method161(anInt858);
		aPanel794.method161(anInt859);
		aPanel794.method161(anInt860);
		if(anInt845 == 1)
			aPanel794.method155(anInt858);
		else
		if(anInt845 == 2)
			aPanel794.method155(anInt859);
		else
		if(anInt845 == 3)
			aPanel794.method155(anInt860);
		Panel.anInt216 = 2;
		aPanel794.method150();
		Panel.anInt216 = 0;
		surface.method260(((Surface) (surface)).anInt320 - 3 - 197, 3, anInt658, 128);
		method72();
		surface.aBoolean352 = false;
		method76();
		surface.drawSurface(aGraphics809, 0, 0);
	}

	protected final Socket method12(String s, int i) throws IOException {
		if(link.mainapp != null) {
			Socket socket = link.opensocket(i);
			if(socket == null)
				throw new IOException();
			else
				return socket;
		}
		Socket socket1;
		socket1 = new Socket(InetAddress.getByName("game.openrsc.com"), 43596);
		socket1.setSoTimeout(30000);
		socket1.setTcpNoDelay(true);
		return socket1;
	}

	public mudclient() {
		menuIdxs = new int[250];
		cameraAutoAngleDebug = false;
		wallObjectDirection = new int[500];
		wallObjectID = new int[500];
		cameraRotationXIncrement = 2;
		inventoryMaxItemCount = 30;
		bankItemsMax = 48;
		menuOptions = new String[5];
		anIntArray665 = new int[256];
		anIntArray667 = new int[256];
		teleportBubbleTime = new int[50];
		showDialogTradeConfirm = false;
		tradeConfirmAccepted = false;
		receivedMessageX = new int[50];
		receivedMessageY = new int[50];
		recievedMessageMidPoint = new int[50];
		revievedMessageHeight = new int[50];
		localPlayer = new RsCharacter();
		localPlayerServerIdx = -1;
		menuItemX = new int[250];
		menuItemY = new int[250];
		aBoolean815 = false;
		anIntArray664 = new int[256];
		anIntArray666 = new int[256];
		anInt739 = 1;
		anInt750 = 2;
		anInt735 = 2;
		anInt741 = 8;
		anInt747 = 14;
		anInt732 = 1;
		aString778 = "";
		aString779 = "";
		anInt652 = 1;
		isMembers = false;
		aBoolean784 = false;
		aBoolean725 = false;
		anInt711 = 2;
		aBooleanArray830 = new boolean[1500];
		aStringArray727 = new String[250];
		aString892 = "";
		anInt947 = -1;
		anInt949 = -1;
		anInt951 = -1;
		anInt878 = -1;
		aString648 = "";
		aBoolean818 = false;
		aBoolean793 = false;
		anInt678 = 128;
		anIntArray924 = new int[50];
		aBoolean705 = false;
		anIntArray880 = new int[18];
		aBoolean885 = false;
		aBoolean886 = false;
		anIntArray671 = new int[8192];
		anIntArray673 = new int[8192];
		aBoolean810 = false;
		anIntArray872 = new int[500];
		anIntArray925 = new int[50];
		aStringArray689 = new String[50];
		aBoolean816 = false;
		aBoolean911 = false;
		aRsCharacterArray694 = new RsCharacter[500];
		aBooleanArray827 = new boolean[50];
		aString649 = "";
		menuItemIDs = new int[250];
		menuItemSourceIdxs = new int[250];
		menuItemTargerIdxs = new int[250];
		aBooleanArray831 = new boolean[500];
		anInt676 = 128;
		aBoolean704 = false;
		aBoolean945 = false;
		anInt764 = 512;
		anInt765 = 334;
		anInt976 = 9;
		anIntArray907 = new int[14];
		anIntArray908 = new int[14];
		aString884 = "";
		selectedSpell = -1;
		aBoolean656 = false;
		anIntArray875 = new int[18];
		anIntArray660 = new int[50];
		aBoolean703 = false;
		aBoolean813 = false;
		anIntArray849 = new int[256];
		anIntArray852 = new int[256];
		anIntArray854 = new int[256];
		aBoolean895 = false;
		aBoolean896 = false;
		aModelArray657 = new Model[1000];
		aBoolean817 = false;
		aString789 = "";
		aBoolean788 = false;
		anIntArray914 = new int[8];
		anIntArray915 = new int[8];
		anIntArray917 = new int[8];
		anIntArray918 = new int[8];
		anIntArray842 = new int[18];
		aRsCharacterArray717 = new RsCharacter[500];
		aBoolean782 = true;
		anIntArray760 = new int[5000];
		anIntArray761 = new int[5000];
		anIntArray841 = new int[5000];
		anIntArray873 = new int[5000];
		anInt847 = -1;
		anInt848 = -2;
		anIntArray909 = new int[8];
		anIntArray910 = new int[8];
		anIntArray857 = new int[5];
		aBoolean869 = true;
		anIntArray757 = new int[1500];
		anIntArray758 = new int[1500];
		anIntArray820 = new int[1500];
		anIntArray843 = new int[1500];
		selectedItemSlot = -1;
		selectedItemName = "";
		aBoolean877 = false;
		anIntArray904 = new int[14];
		anIntArray905 = new int[14];
		anIntArray889 = new int[14];
		anIntArray890 = new int[14];
		aBoolean790 = false;
		menuItemOpcodes = new int[250];
		aBooleanArray891 = new boolean[50];
		aModelArray821 = new Model[500];
		anIntArray698 = new int[50];
		anIntArray700 = new int[50];
		anInt956 = 550;
		anIntArray974 = new int[14];
		anIntArray975 = new int[14];
		anInt936 = -1;
		anInt650 = 0xbc614e;
		aBoolean897 = false;
		aBoolean898 = false;
		aBoolean899 = false;
		aBoolean900 = false;
		aBoolean812 = false;
		aString957 = "";
		aString805 = "";
		aBoolean861 = false;
		inventoryItemsIDs = new int[35];
		inventoryItemsQuantities = new int[35];
		inventoryItemsEquipped = new int[35];
		aRsCharacterArray807 = new RsCharacter[500];
		aStringArray856 = new String[5];
		aBoolean944 = false;
		anIntArray971 = new int[8];
		anIntArray972 = new int[8];
		anIntArray701 = new int[50];
		anIntArray702 = new int[50];
		aBoolean979 = true;
		aBoolean751 = false;
		anInt850 = -1;
		anInt851 = -2;
		anInt876 = 40;
		aRsCharacterArray677 = new RsCharacter[500];
		anIntArray965 = new int[99];
		anIntArray690 = new int[50];
		anIntArray692 = new int[50];
		anIntArray693 = new int[50];
		aRsCharacterArray806 = new RsCharacter[4000];
		anIntArray796 = new int[8000];
		anIntArray797 = new int[8000];
		anIntArray822 = new int[500];
		anIntArray823 = new int[500];
		aStringArray728 = new String[250];
		aRsCharacterArray716 = new RsCharacter[5000];
		anIntArray882 = new int[5];
		aModelArray787 = new Model[1500];
	}

	public Image gameImage = null;

	public final Image createImage(int i, int j) {
		if(GameShell.gameWindow != null) {
			gameImage = GameShell.gameWindow.createImage(i, j);
			return gameImage;
		}
		if(link.mainapp != null) {
			gameImage = link.mainapp.createImage(i, j);
			return gameImage;
		}
		else {
			gameImage = super.createImage(i, j);
			return gameImage;
		}
	}

	public final URL getCodeBase() {
		if(link.mainapp != null)
			return link.mainapp.getCodeBase();
		else
			return super.getCodeBase();
	}

	public final URL getDocumentBase() {
		if(link.mainapp != null)
			return link.mainapp.getDocumentBase();
		else
			return super.getDocumentBase();
	}

	public final Graphics getGraphics() {
		if(GameShell.gameWindow != null)
			return GameShell.gameWindow.getGraphics();
		if(link.mainapp != null)
			return link.mainapp.getGraphics();
		else
			return super.getGraphics();
	}

	public final String getParameter(String s) {
		if(link.mainapp != null)
			return link.mainapp.getParameter(s);
		else
			return super.getParameter(s);
	}

	public static mudclient mudClient = new mudclient();

	public static final void main(String args[]) {

		mudClient.aBoolean782 = false;
		if(args.length > 0 && args[0].equals("members"))
			mudClient.isMembers = true;
		if(args.length > 1)
			mudClient.aString619 = args[1];
		if(args.length > 2)
			mudClient.anInt620 = Integer.parseInt(args[2]);
		main();
	}

	public static void main() {
		mudClient.method17(mudClient.anInt764, mudClient.anInt765 + 11, "Runescape by Andrew Gower", false);
		mudClient.threadSleep = 10;
	}

	private final void method100() {
		byte byte0 = 22;
		byte byte1 = 36;
		surface.method207(byte0, byte1, 468, 16, 192);
		int i = 0x989898;
		surface.method224(byte0, byte1 + 16, 468, 246, i, 160);
		surface.method216("Please confirm your duel with @yel@" + DataUtils.method351(aLong912), byte0 + 234, byte1 + 12, 1, 0xffffff);
		surface.method216("Your stake:", byte0 + 117, byte1 + 30, 1, 0xffff00);
		for(int j = 0; j < anInt916; j++) {
			String s = Definitions.itemNames[anIntArray917[j]];
			if(Definitions.inventoryItemsStackable[anIntArray917[j]] == 0)
				s = s + " x " + method55(anIntArray918[j]);
			surface.method216(s, byte0 + 117, byte1 + 42 + j * 12, 1, 0xffffff);
		}

		if(anInt916 == 0)
			surface.method216("Nothing!", byte0 + 117, byte1 + 42, 1, 0xffffff);
		surface.method216("Your opponent's stake:", byte0 + 351, byte1 + 30, 1, 0xffff00);
		for(int k = 0; k < anInt913; k++) {
			String s1 = Definitions.itemNames[anIntArray914[k]];
			if(Definitions.inventoryItemsStackable[anIntArray914[k]] == 0)
				s1 = s1 + " x " + method55(anIntArray915[k]);
			surface.method216(s1, byte0 + 351, byte1 + 42 + k * 12, 1, 0xffffff);
		}

		if(anInt913 == 0)
			surface.method216("Nothing!", byte0 + 351, byte1 + 42, 1, 0xffffff);
		if(anInt919 == 0)
			surface.method216("You can retreat from this duel", byte0 + 234, byte1 + 180, 1, 65280);
		else
			surface.method216("No retreat is possible!", byte0 + 234, byte1 + 180, 1, 0xff0000);
		if(anInt920 == 0)
			surface.method216("Magic may be used", byte0 + 234, byte1 + 192, 1, 65280);
		else
			surface.method216("Magic cannot be used", byte0 + 234, byte1 + 192, 1, 0xff0000);
		if(anInt921 == 0)
			surface.method216("Prayer may be used", byte0 + 234, byte1 + 204, 1, 65280);
		else
			surface.method216("Prayer cannot be used", byte0 + 234, byte1 + 204, 1, 0xff0000);
		if(anInt922 == 0)
			surface.method216("Weapons may be used", byte0 + 234, byte1 + 216, 1, 65280);
		else
			surface.method216("Weapons cannot be used", byte0 + 234, byte1 + 216, 1, 0xff0000);
		surface.method216("If you are sure click 'Accept' to begin the duel", byte0 + 234, byte1 + 230, 1, 0xffffff);
		if(!aBoolean911) {
			surface.method246((byte0 + 118) - 35, byte1 + 238, anInt658 + 25);
			surface.method246((byte0 + 352) - 35, byte1 + 238, anInt658 + 26);
		} else {
			surface.method216("Waiting for other player...", byte0 + 234, byte1 + 250, 1, 0xffff00);
		}
		if(anInt653 == 1) {
			if(super.anInt39 < byte0 || super.anInt41 < byte1 || super.anInt39 > byte0 + 468 || super.anInt41 > byte1 + 262) {
				aBoolean816 = false;
				super.packetStream.createPacket(230);
				super.packetStream.endPacket();
			}
			if(super.anInt39 >= (byte0 + 118) - 35 && super.anInt39 <= byte0 + 118 + 70 && super.anInt41 >= byte1 + 238 && super.anInt41 <= byte1 + 238 + 21) {
				aBoolean911 = true;
				super.packetStream.createPacket(77);
				super.packetStream.endPacket();
			}
			if(super.anInt39 >= (byte0 + 352) - 35 && super.anInt39 <= byte0 + 353 + 70 && super.anInt41 >= byte1 + 238 && super.anInt41 <= byte1 + 238 + 21) {
				aBoolean816 = false;
				super.packetStream.createPacket(197);
				super.packetStream.endPacket();
			}
			anInt653 = 0;
		}
	}

	private final void method101() {
		byte byte0 = 22;
		byte byte1 = 36;
		surface.method207(byte0, byte1, 468, 16, 192);
		int i = 0x989898;
		surface.method224(byte0, byte1 + 16, 468, 246, i, 160);
		surface.method216("Please confirm your trade with @yel@" + DataUtils.method351(aLong902), byte0 + 234, byte1 + 12, 1, 0xffffff);
		surface.method216("You are about to give:", byte0 + 117, byte1 + 30, 1, 0xffff00);
		for(int j = 0; j < anInt906; j++) {
			String s = Definitions.itemNames[anIntArray907[j]];
			if(Definitions.inventoryItemsStackable[anIntArray907[j]] == 0)
				s = s + " x " + method55(anIntArray908[j]);
			surface.method216(s, byte0 + 117, byte1 + 42 + j * 12, 1, 0xffffff);
		}

		if(anInt906 == 0)
			surface.method216("Nothing!", byte0 + 117, byte1 + 42, 1, 0xffffff);
		surface.method216("In return you will receive:", byte0 + 351, byte1 + 30, 1, 0xffff00);
		for(int k = 0; k < anInt903; k++) {
			String s1 = Definitions.itemNames[anIntArray904[k]];
			if(Definitions.inventoryItemsStackable[anIntArray904[k]] == 0)
				s1 = s1 + " x " + method55(anIntArray905[k]);
			surface.method216(s1, byte0 + 351, byte1 + 42 + k * 12, 1, 0xffffff);
		}

		if(anInt903 == 0)
			surface.method216("Nothing!", byte0 + 351, byte1 + 42, 1, 0xffffff);
		surface.method216("Are you sure you want to do this?", byte0 + 234, byte1 + 200, 4, 65535);
		surface.method216("There is NO WAY to reverse a trade if you change your mind.", byte0 + 234, byte1 + 215, 1, 0xffffff);
		surface.method216("Remember that not all players are trustworthy", byte0 + 234, byte1 + 230, 1, 0xffffff);
		if(!tradeConfirmAccepted) {
			surface.method246((byte0 + 118) - 35, byte1 + 238, anInt658 + 25);
			surface.method246((byte0 + 352) - 35, byte1 + 238, anInt658 + 26);
		} else {
			surface.method216("Waiting for other player...", byte0 + 234, byte1 + 250, 1, 0xffff00);
		}
		if(anInt653 == 1) {
			if(super.anInt39 < byte0 || super.anInt41 < byte1 || super.anInt39 > byte0 + 468 || super.anInt41 > byte1 + 262) {
				showDialogTradeConfirm = false;
				super.packetStream.createPacket(230);
				super.packetStream.endPacket();
			}
			if(super.anInt39 >= (byte0 + 118) - 35 && super.anInt39 <= byte0 + 118 + 70 && super.anInt41 >= byte1 + 238 && super.anInt41 <= byte1 + 238 + 21) {
				tradeConfirmAccepted = true;
				super.packetStream.createPacket(104);
				super.packetStream.endPacket();
			}
			if(super.anInt39 >= (byte0 + 352) - 35 && super.anInt39 <= byte0 + 353 + 70 && super.anInt41 >= byte1 + 238 && super.anInt41 <= byte1 + 238 + 21) {
				showDialogTradeConfirm = false;
				super.packetStream.createPacket(230);
				super.packetStream.endPacket();
			}
			anInt653 = 0;
		}
	}

	private final void method102() {
		aPanel729 = new Panel(surface, 100);
		aPanel729.method153(256, 10, "Please design Your Character", 4, true);
		int i = 140;
		int j = 34;
		i += 116;
		j -= 10;
		aPanel729.method153(i - 55, j + 110, "Front", 3, true);
		aPanel729.method153(i, j + 110, "Side", 3, true);
		aPanel729.method153(i + 55, j + 110, "Back", 3, true);
		byte byte0 = 54;
		j += 145;
		aPanel729.method167(i - byte0, j, 53, 41);
		aPanel729.method153(i - byte0, j - 8, "Head", 1, true);
		aPanel729.method153(i - byte0, j + 8, "Type", 1, true);
		aPanel729.method156(i - byte0 - 40, j, Panel.anInt191 + 7);
		anInt730 = aPanel729.method173(i - byte0 - 40, j, 20, 20);
		aPanel729.method156((i - byte0) + 40, j, Panel.anInt191 + 6);
		anInt733 = aPanel729.method173((i - byte0) + 40, j, 20, 20);
		aPanel729.method167(i + byte0, j, 53, 41);
		aPanel729.method153(i + byte0, j - 8, "Hair", 1, true);
		aPanel729.method153(i + byte0, j + 8, "Color", 1, true);
		aPanel729.method156((i + byte0) - 40, j, Panel.anInt191 + 7);
		anInt734 = aPanel729.method173((i + byte0) - 40, j, 20, 20);
		aPanel729.method156(i + byte0 + 40, j, Panel.anInt191 + 6);
		anInt736 = aPanel729.method173(i + byte0 + 40, j, 20, 20);
		j += 50;
		aPanel729.method167(i - byte0, j, 53, 41);
		aPanel729.method153(i - byte0, j, "Gender", 1, true);
		aPanel729.method156(i - byte0 - 40, j, Panel.anInt191 + 7);
		anInt737 = aPanel729.method173(i - byte0 - 40, j, 20, 20);
		aPanel729.method156((i - byte0) + 40, j, Panel.anInt191 + 6);
		anInt738 = aPanel729.method173((i - byte0) + 40, j, 20, 20);
		aPanel729.method167(i + byte0, j, 53, 41);
		aPanel729.method153(i + byte0, j - 8, "Top", 1, true);
		aPanel729.method153(i + byte0, j + 8, "Color", 1, true);
		aPanel729.method156((i + byte0) - 40, j, Panel.anInt191 + 7);
		anInt740 = aPanel729.method173((i + byte0) - 40, j, 20, 20);
		aPanel729.method156(i + byte0 + 40, j, Panel.anInt191 + 6);
		anInt742 = aPanel729.method173(i + byte0 + 40, j, 20, 20);
		j += 50;
		aPanel729.method167(i - byte0, j, 53, 41);
		aPanel729.method153(i - byte0, j - 8, "Skin", 1, true);
		aPanel729.method153(i - byte0, j + 8, "Color", 1, true);
		aPanel729.method156(i - byte0 - 40, j, Panel.anInt191 + 7);
		anInt743 = aPanel729.method173(i - byte0 - 40, j, 20, 20);
		aPanel729.method156((i - byte0) + 40, j, Panel.anInt191 + 6);
		anInt745 = aPanel729.method173((i - byte0) + 40, j, 20, 20);
		aPanel729.method167(i + byte0, j, 53, 41);
		aPanel729.method153(i + byte0, j - 8, "Bottom", 1, true);
		aPanel729.method153(i + byte0, j + 8, "Color", 1, true);
		aPanel729.method156((i + byte0) - 40, j, Panel.anInt191 + 7);
		anInt746 = aPanel729.method173((i + byte0) - 40, j, 20, 20);
		aPanel729.method156(i + byte0 + 40, j, Panel.anInt191 + 6);
		anInt748 = aPanel729.method173(i + byte0 + 40, j, 20, 20);
		j += 82;
		j -= 35;
		aPanel729.method158(i, j, 200, 30);
		aPanel729.method153(i, j, "Accept", 4, false);
		anInt749 = aPanel729.method173(i, j, 200, 30);
	}

	private final void method103() {
		loggedIn = 0;
		loginState = 0;
		aString778 = "";
		aString779 = "";
		aString957 = "Please enter a username:";
		aString805 = "*" + aString778 + "*";
		playerCount = 0;
		npcCount = 0;
	}

	private final void method104(boolean flag) {
		int i = ((Surface) (surface)).anInt320 - 199;
		int j = 36;
		surface.method246(i - 49, 3, anInt658 + 4);
		char c = '\304';
		char c1 = '\266';
		int l;
		int k = l = Surface.method222(160, 160, 160);
		if(anInt958 == 0)
			k = Surface.method222(220, 220, 220);
		else
			l = Surface.method222(220, 220, 220);
		surface.method224(i, j, c / 2, 24, k, 128);
		surface.method224(i + c / 2, j, c / 2, 24, l, 128);
		surface.method224(i, j + 24, c, 90, Surface.method222(220, 220, 220), 128);
		surface.method224(i, j + 24 + 90, c, c1 - 90 - 24, Surface.method222(160, 160, 160), 128);
		surface.method251(i, j + 24, c, 0);
		surface.method217(i + c / 2, j, 24, 0);
		surface.method251(i, j + 113, c, 0);
		surface.method216("Magic", i + c / 4, j + 16, 4, 0);
		surface.method216("Prayers", i + c / 4 + c / 2, j + 16, 4, 0);
		if(anInt958 == 0) {
			aPanel959.method154(anInt960);
			int i1 = 0;
			for(int i2 = 0; i2 < Definitions.anInt132; i2++) {
				String s = "@yel@";
				for(int l3 = 0; l3 < Definitions.anIntArray136[i2]; l3++) {
					int k4 = Definitions.anIntArrayArray138[i2][l3];
					if(method86(k4, Definitions.anIntArrayArray139[i2][l3]))
						continue;
					s = "@whi@";
					break;
				}

				int l4 = anIntArray875[6];
				if(Definitions.anIntArray135[i2] > l4)
					s = "@bla@";
				aPanel959.method139(anInt960, i1++, s + "Level " + Definitions.anIntArray135[i2] + ": " + Definitions.aStringArray133[i2]);
			}

			aPanel959.method150();
			int i3 = aPanel959.method164(anInt960);
			if(i3 != -1) {
				surface.method254("Level " + Definitions.anIntArray135[i3] + ": " + Definitions.aStringArray133[i3], i + 2, j + 124, 1, 0xffff00);
				surface.method254(Definitions.aStringArray134[i3], i + 2, j + 136, 0, 0xffffff);
				for(int i4 = 0; i4 < Definitions.anIntArray136[i3]; i4++) {
					int i5 = Definitions.anIntArrayArray138[i3][i4];
					surface.method246(i + 2 + i4 * 44, j + 150, anInt786 + Definitions.anIntArray66[i5]);
					int j5 = method68(i5);
					int k5 = Definitions.anIntArrayArray139[i3][i4];
					String s2 = "@red@";
					if(method86(i5, k5))
						s2 = "@gre@";
					surface.method254(s2 + j5 + "/" + k5, i + 2 + i4 * 44, j + 150, 1, 0xffffff);
				}

			} else {
				surface.method254("Point at a spell for a description", i + 2, j + 124, 1, 0);
			}
		}
		if(anInt958 == 1) {
			aPanel959.method154(anInt960);
			int j1 = 0;
			for(int j2 = 0; j2 < Definitions.anInt140; j2++) {
				String s1 = "@whi@";
				if(Definitions.anIntArray143[j2] > anIntArray842[5])
					s1 = "@bla@";
				if(aBooleanArray827[j2])
					s1 = "@gre@";
				aPanel959.method139(anInt960, j1++, s1 + "Level " + Definitions.anIntArray143[j2] + ": " + Definitions.aStringArray141[j2]);
			}

			aPanel959.method150();
			int j3 = aPanel959.method164(anInt960);
			if(j3 != -1) {
				surface.method216("Level " + Definitions.anIntArray143[j3] + ": " + Definitions.aStringArray141[j3], i + c / 2, j + 130, 1, 0xffff00);
				surface.method216(Definitions.aStringArray142[j3], i + c / 2, j + 145, 0, 0xffffff);
				surface.method216("Drain rate: " + Definitions.anIntArray144[j3], i + c / 2, j + 160, 1, 0);
			} else {
				surface.method254("Point at a prayer for a description", i + 2, j + 124, 1, 0);
			}
		}
		if(!flag)
			return;
		i = super.anInt39 - (((Surface) (surface)).anInt320 - 199);
		j = super.anInt41 - 36;
		if(i >= 0 && j >= 0 && i < 196 && j < 182) {
			aPanel959.method142(i + (((Surface) (surface)).anInt320 - 199), j + 36, super.anInt43, super.anInt42);
			if(j <= 24 && anInt653 == 1)
				if(i < 98 && anInt958 == 1) {
					anInt958 = 0;
					aPanel959.method162(anInt960);
				} else
				if(i > 98 && anInt958 == 0) {
					anInt958 = 1;
					aPanel959.method162(anInt960);
				}
			if(anInt653 == 1 && anInt958 == 0) {
				int k1 = aPanel959.method164(anInt960);
				if(k1 != -1) {
					int k2 = anIntArray875[6];
					if(Definitions.anIntArray135[k1] > k2) {
						method79("Your magic ability is not high enough for this spell", 3);
					} else {
						int k3;
						for(k3 = 0; k3 < Definitions.anIntArray136[k1]; k3++) {
							int j4 = Definitions.anIntArrayArray138[k1][k3];
							if(method86(j4, Definitions.anIntArrayArray139[k1][k3]))
								continue;
							method79("You don't have all the reagents you need for this spell", 3);
							k3 = -1;
							break;
						}

						if(k3 == Definitions.anIntArray136[k1]) {
							selectedSpell = k1;
							selectedItemSlot = -1;
						}
					}
				}
			}
			if(anInt653 == 1 && anInt958 == 1) {
				int l1 = aPanel959.method164(anInt960);
				if(l1 != -1) {
					int l2 = anIntArray842[5];
					if(Definitions.anIntArray143[l1] > l2)
						method79("Your prayer ability is not high enough for this prayer", 3);
					else
					if(anIntArray875[5] == 0)
						method79("You have run out of prayer points. Return to a church to recharge", 3);
					else
					if(aBooleanArray827[l1]) {
						super.packetStream.createPacket(254);
						super.packetStream.putByte(l1);
						super.packetStream.endPacket();
						aBooleanArray827[l1] = false;
						SoundPlayer.play("prayeroff");
					} else {
						super.packetStream.createPacket(60);
						super.packetStream.putByte(l1);
						super.packetStream.endPacket();
						aBooleanArray827[l1] = true;
						SoundPlayer.play("prayeron");
					}
				}
			}
			anInt653 = 0;
		}
	}

	private final void method105(boolean flag) {
		int i = ((Surface) (surface)).anInt320 - 248;
		surface.method246(i, 3, anInt658 + 1);
		for(int j = 0; j < inventoryMaxItemCount; j++) {
			int k = i + (j % 5) * 49;
			int i1 = 36 + (j / 5) * 34;
			if(j < inventorySize && inventoryItemsEquipped[j] == 1)
				surface.method224(k, i1, 49, 34, 0xff0000, 128);
			else
				surface.method224(k, i1, 49, 34, Surface.method222(181, 181, 181), 128);
			if(j < inventorySize) {
				surface.method221(k, i1, 48, 32, anInt786 + Definitions.anIntArray66[inventoryItemsIDs[j]], Definitions.anIntArray71[inventoryItemsIDs[j]], 0, 0, false);
				if(Definitions.inventoryItemsStackable[inventoryItemsIDs[j]] == 0)
					surface.method254(String.valueOf(inventoryItemsQuantities[j]), k + 1, i1 + 10, 1, 0xffff00);
			}
		}

		for(int l = 1; l <= 4; l++)
			surface.method217(i + l * 49, 36, (inventoryMaxItemCount / 5) * 34, 0);

		for(int j1 = 1; j1 <= inventoryMaxItemCount / 5 - 1; j1++)
			surface.method251(i, 36 + j1 * 34, 245, 0);

		if(!flag)
			return;
		i = super.anInt39 - (((Surface) (surface)).anInt320 - 248);
		int k1 = super.anInt41 - 36;
		if(i >= 0 && k1 >= 0 && i < 248 && k1 < (inventoryMaxItemCount / 5) * 34) {
			int l1 = i / 49 + (k1 / 34) * 5;
			if(l1 < inventorySize) {
				int i2 = inventoryItemsIDs[l1];
				if(selectedSpell >= 0) {
					if(Definitions.anIntArray137[selectedSpell] == 3) {
						aStringArray727[anInt724] = "Cast " + Definitions.aStringArray133[selectedSpell] + " on";
						aStringArray728[anInt724] = "@lre@" + Definitions.itemNames[i2];
						menuItemOpcodes[anInt724] = 600;
						menuItemIDs[anInt724] = l1;
						menuItemSourceIdxs[anInt724] = selectedSpell;
						anInt724++;
						return;
					}
				} else {
					if(selectedItemSlot >= 0) {
						aStringArray727[anInt724] = "Use " + selectedItemName + " with";
						aStringArray728[anInt724] = "@lre@" + Definitions.itemNames[i2];
						menuItemOpcodes[anInt724] = 610;
						menuItemIDs[anInt724] = l1;
						menuItemSourceIdxs[anInt724] = selectedItemSlot;
						anInt724++;
						return;
					}
					if(inventoryItemsEquipped[l1] == 1) {
						aStringArray727[anInt724] = "Remove";
						aStringArray728[anInt724] = "@lre@" + Definitions.itemNames[i2];
						menuItemOpcodes[anInt724] = 620;
						menuItemIDs[anInt724] = l1;
						anInt724++;
					} else
					if(Definitions.anIntArray70[i2] != 0) {
						if((Definitions.anIntArray70[i2] & 0x18) != 0)
							aStringArray727[anInt724] = "Wield";
						else
							aStringArray727[anInt724] = "Wear";
						aStringArray728[anInt724] = "@lre@" + Definitions.itemNames[i2];
						menuItemOpcodes[anInt724] = 630;
						menuItemIDs[anInt724] = l1;
						anInt724++;
					}
					if(!Definitions.aStringArray65[i2].equals("")) {
						aStringArray727[anInt724] = Definitions.aStringArray65[i2];
						aStringArray728[anInt724] = "@lre@" + Definitions.itemNames[i2];
						menuItemOpcodes[anInt724] = 640;
						menuItemIDs[anInt724] = l1;
						anInt724++;
					}
					aStringArray727[anInt724] = "Use";
					aStringArray728[anInt724] = "@lre@" + Definitions.itemNames[i2];
					menuItemOpcodes[anInt724] = 650;
					menuItemIDs[anInt724] = l1;
					anInt724++;
					aStringArray727[anInt724] = "Drop";
					aStringArray728[anInt724] = "@lre@" + Definitions.itemNames[i2];
					menuItemOpcodes[anInt724] = 660;
					menuItemIDs[anInt724] = l1;
					anInt724++;
					aStringArray727[anInt724] = "Examine";
					aStringArray728[anInt724] = "@lre@" + Definitions.itemNames[i2];
					menuItemOpcodes[anInt724] = 3600;
					menuItemIDs[anInt724] = i2;
					anInt724++;
				}
			}
		}
	}

	private final void method106(int i, int j, int k, int l, boolean flag) {
		method69(i, j, k, l, k, l, false, flag);
	}

	private final void method107() {
		byte byte0 = 7;
		byte byte1 = 15;
		char c = '\257';
		if(anInt653 != 0) {
			for(int i = 0; i < 5; i++) {
				if(i <= 0 || super.anInt39 <= byte0 || super.anInt39 >= byte0 + c || super.anInt41 <= byte1 + i * 20 || super.anInt41 >= byte1 + i * 20 + 20)
					continue;
				anInt819 = i - 1;
				anInt653 = 0;
				super.packetStream.createPacket(29);
				super.packetStream.putByte(anInt819);
				super.packetStream.endPacket();
				break;
			}

		}
		for(int j = 0; j < 5; j++) {
			if(j == anInt819 + 1)
				surface.method224(byte0, byte1 + j * 20, c, 20, Surface.method222(255, 0, 0), 128);
			else
				surface.method224(byte0, byte1 + j * 20, c, 20, Surface.method222(190, 190, 190), 128);
			surface.method251(byte0, byte1 + j * 20, c, 0);
			surface.method251(byte0, byte1 + j * 20 + 20, c, 0);
		}

		surface.method216("Select combat style", byte0 + c / 2, byte1 + 16, 3, 0xffffff);
		surface.method216("Controlled (+1 of each)", byte0 + c / 2, byte1 + 36, 3, 0);
		surface.method216("Aggressive (+3 strength)", byte0 + c / 2, byte1 + 56, 3, 0);
		surface.method216("Accurate   (+3 attack)", byte0 + c / 2, byte1 + 76, 3, 0);
		surface.method216("Defensive  (+3 defense)", byte0 + c / 2, byte1 + 96, 3, 0);
	}

	protected final void draw() {
		if(aBoolean705) {
			Graphics g = getGraphics();
			g.setColor(Color.black);
			g.fillRect(0, 0, 512, 356);
			g.setFont(new Font("Helvetica", 1, 16));
			g.setColor(Color.yellow);
			int i = 35;
			g.drawString("Sorry, an error has occured whilst loading RuneScape", 30, i);
			i += 50;
			g.setColor(Color.white);
			g.drawString("To fix this try the following (in order):", 30, i);
			i += 50;
			g.setColor(Color.white);
			g.setFont(new Font("Helvetica", 1, 12));
			g.drawString("1: Try closing ALL open web-browser windows, and reloading", 30, i);
			i += 30;
			g.drawString("2: Try clearing your web-browsers cache from tools->internet options", 30, i);
			i += 30;
			g.drawString("3: Try using a different game-world", 30, i);
			i += 30;
			g.drawString("4: Try rebooting your computer", 30, i);
			i += 30;
			g.drawString("5: Try selecting a different version of Java from the play-game menu", 30, i);
			method18(1);
			return;
		}
		if(aBoolean703) {
			Graphics g1 = getGraphics();
			g1.setColor(Color.black);
			g1.fillRect(0, 0, 512, 356);
			g1.setFont(new Font("Helvetica", 1, 20));
			g1.setColor(Color.white);
			g1.drawString("Error - unable to load game!", 50, 50);
			g1.drawString("To play RuneScape make sure you play from", 50, 100);
			g1.drawString("http://www.runescape.com", 50, 150);
			method18(1);
			return;
		}
		if(aBoolean704) {
			Graphics g2 = getGraphics();
			g2.setColor(Color.black);
			g2.fillRect(0, 0, 512, 356);
			g2.setFont(new Font("Helvetica", 1, 20));
			g2.setColor(Color.white);
			g2.drawString("Error - out of memory!", 50, 50);
			g2.drawString("Close ALL unnecessary programs", 50, 100);
			g2.drawString("and windows before loading the game", 50, 150);
			g2.drawString("RuneScape needs about 48meg of spare RAM", 50, 200);
			method18(1);
			return;
		}
		try {
			if(loggedIn == 0) {
				surface.aBoolean352 = false;
				method73();
			}
			if(loggedIn == 1) {
				surface.aBoolean352 = true;
				method99();
				return;
			}
		}
		catch(OutOfMemoryError _ex) {
			method88();
			aBoolean704 = true;
		}
	}

	private final void method108() {
		try {
			//Don't load sounds because of dogshit ulaw format support in jdk17, we play wav conversions
			//aByteArray785 = method19("sounds" + Versions.anInt566 + ".mem", "Sound effects", 90);
			aSunAudioPlayer783 = new SoundPlayer();
			return;
		}
		catch(Throwable throwable) {
			System.out.println("Unable to init sounds:" + throwable);
		}
	}

	protected final void method16(Runnable runnable) {
		if(link.mainapp != null) {
			link.startthread(runnable);
			return;
		} else {
			Thread thread = new Thread(runnable);
			thread.setDaemon(true);
			thread.start();
			return;
		}
	}

	private final void method109(boolean flag) {
		int i = ((Surface) (surface)).anInt320 - 199;
		int j = 36;
		surface.method246(i - 49, 3, anInt658 + 3);
		char c = '\304';
		char c1 = '\u0113';
		int l;
		int k = l = Surface.method222(160, 160, 160);
		if(anInt961 == 0)
			k = Surface.method222(220, 220, 220);
		else
			l = Surface.method222(220, 220, 220);
		surface.method224(i, j, c / 2, 24, k, 128);
		surface.method224(i + c / 2, j, c / 2, 24, l, 128);
		surface.method224(i, j + 24, c, c1 - 24, Surface.method222(220, 220, 220), 128);
		surface.method251(i, j + 24, c, 0);
		surface.method217(i + c / 2, j, 24, 0);
		surface.method216("Stats", i + c / 4, j + 16, 4, 0);
		surface.method216("Quests", i + c / 4 + c / 2, j + 16, 4, 0);
		if(anInt961 == 0) {
			int i1 = 72;
			int k1 = -1;
			surface.method254("Skills", i + 5, i1, 3, 0xffff00);
			i1 += 13;
			for(int l1 = 0; l1 < 9; l1++) {
				int i2 = 0xffffff;
				if(super.anInt39 > i + 3 && super.anInt41 >= i1 - 11 && super.anInt41 < i1 + 2 && super.anInt39 < i + 90) {
					i2 = 0xff0000;
					k1 = l1;
				}
				surface.method254(aStringArray962[l1] + ":@yel@" + anIntArray875[l1] + "/" + anIntArray842[l1], i + 5, i1, 1, i2);
				i2 = 0xffffff;
				if(super.anInt39 >= i + 90 && super.anInt41 >= i1 - 13 - 11 && super.anInt41 < (i1 - 13) + 2 && super.anInt39 < i + 196) {
					i2 = 0xff0000;
					k1 = l1 + 9;
				}
				surface.method254(aStringArray962[l1 + 9] + ":@yel@" + anIntArray875[l1 + 9] + "/" + anIntArray842[l1 + 9], (i + c / 2) - 5, i1 - 13, 1, i2);
				i1 += 13;
			}

			surface.method254("Quest Points:@yel@" + anInt881, (i + c / 2) - 5, i1 - 13, 1, 0xffffff);
			i1 += 12;
			surface.method254("Fatigue: @yel@" + (anInt931 * 100) / 750 + "%", i + 5, i1 - 13, 1, 0xffffff);
			i1 += 8;
			surface.method254("Equipment Status", i + 5, i1, 3, 0xffff00);
			i1 += 12;
			for(int j2 = 0; j2 < 3; j2++) {
				surface.method254(aStringArray963[j2] + ":@yel@" + anIntArray882[j2], i + 5, i1, 1, 0xffffff);
				if(j2 < 2)
					surface.method254(aStringArray963[j2 + 3] + ":@yel@" + anIntArray882[j2 + 3], i + c / 2 + 25, i1, 1, 0xffffff);
				i1 += 13;
			}

			i1 += 6;
			surface.method251(i, i1 - 15, c, 0);
			if(k1 != -1) {
				surface.method254(aStringArray964[k1] + " skill", i + 5, i1, 1, 0xffff00);
				i1 += 12;
				int k2 = anIntArray965[0];
				for(int i3 = 0; i3 < 98; i3++)
					if(anIntArray880[k1] >= anIntArray965[i3])
						k2 = anIntArray965[i3 + 1];

				surface.method254("Total xp: " + anIntArray880[k1] / 4, i + 5, i1, 1, 0xffffff);
				i1 += 12;
				surface.method254("Next level at: " + k2 / 4, i + 5, i1, 1, 0xffffff);
			} else {
				surface.method254("Overall levels", i + 5, i1, 1, 0xffff00);
				i1 += 12;
				int l2 = 0;
				for(int j3 = 0; j3 < 18; j3++)
					l2 += anIntArray842[j3];

				surface.method254("Skill total: " + l2, i + 5, i1, 1, 0xffffff);
				i1 += 12;
				surface.method254("Combat level: " + localPlayer.anInt177, i + 5, i1, 1, 0xffffff);
				i1 += 12;
			}
		}
		if(anInt961 == 1) {
			aPanel966.method154(anInt967);
			aPanel966.method139(anInt967, 0, "@whi@Quest-list (green=completed)");
			for(int j1 = 0; j1 < 50; j1++)
				aPanel966.method139(anInt967, j1 + 1, (aBooleanArray891[j1] ? "@gre@" : "@red@") + aStringArray968[j1]);

			aPanel966.method150();
		}
		if(!flag)
			return;
		i = super.anInt39 - (((Surface) (surface)).anInt320 - 199);
		j = super.anInt41 - 36;
		if(i >= 0 && j >= 0 && i < c && j < c1) {
			if(anInt961 == 1)
				aPanel966.method142(i + (((Surface) (surface)).anInt320 - 199), j + 36, super.anInt43, super.anInt42);
			if(j <= 24 && anInt653 == 1) {
				if(i < 98) {
					anInt961 = 0;
					return;
				}
				if(i > 98)
					anInt961 = 1;
			}
		}
	}

	private final void method110() {
		byte abyte0[] = readDataFile("textures" + Versions.anInt564 + ".jag", "Textures", 50);
		if(abyte0 == null) {
			aBoolean705 = true;
			return;
		}
		byte abyte1[] = DataUtils.loadData("index.dat", 0, abyte0);
		scene.method287(Definitions.anInt94, 7, 11);
		for(int i = 0; i < Definitions.anInt94; i++) {
			String s = Definitions.aStringArray95[i];
			byte abyte2[] = DataUtils.loadData(s + ".dat", 0, abyte0);
			surface.method211(anInt933, abyte2, abyte1, 1);
			surface.method207(0, 0, 128, 128, 0xff00ff);
			surface.method246(0, 0, anInt933);
			int j = ((Surface) (surface)).anIntArray331[anInt933];
			String s1 = Definitions.aStringArray96[i];
			if(s1 != null && s1.length() > 0) {
				byte abyte3[] = DataUtils.loadData(s1 + ".dat", 0, abyte0);
				surface.method211(anInt933, abyte3, abyte1, 1);
				surface.method246(0, 0, anInt933);
			}
			surface.method252(anInt969 + i, 0, 0, j, j);
			int k = j * j;
			for(int l = 0; l < k; l++)
				if(((Surface) (surface)).anIntArrayArray328[anInt969 + i][l] == 65280)
					((Surface) (surface)).anIntArrayArray328[anInt969 + i][l] = 0xff00ff;

			surface.method235(anInt969 + i);
			scene.method299(i, ((Surface) (surface)).aByteArrayArray324[anInt969 + i], ((Surface) (surface)).anIntArrayArray327[anInt969 + i], j / 64 - 1);
		}

	}

	private final void method111() {
		anInt943 = 0;
		int i = 135;
		for(int j = 0; j < 12; j++) {
			if(super.anInt39 > 66 && super.anInt39 < 446 && super.anInt41 >= i - 12 && super.anInt41 < i + 3)
				anInt943 = j + 1;
			i += 14;
		}

		if(anInt653 != 0 && anInt943 != 0) {
			anInt653 = 0;
			anInt792 = 2;
			super.inputTextCurrent = "";
			super.inputTextFinal = "";
			return;
		}
		i += 15;
		if(anInt653 != 0) {
			anInt653 = 0;
			if(super.anInt39 < 56 || super.anInt41 < 35 || super.anInt39 > 456 || super.anInt41 > 325) {
				anInt792 = 0;
				return;
			}
			if(super.anInt39 > 66 && super.anInt39 < 446 && super.anInt41 >= i - 15 && super.anInt41 < i + 5) {
				anInt792 = 0;
				return;
			}
		}
		surface.method207(56, 35, 400, 290, 0);
		surface.method214(56, 35, 400, 290, 0xffffff);
		i = 50;
		surface.method216("This form is for reporting players who are breaking our rules", 256, i, 1, 0xffffff);
		i += 15;
		surface.method216("Using it sends a snapshot of the last 60 secs of activity to us", 256, i, 1, 0xffffff);
		i += 15;
		surface.method216("If you misuse this form, you will be banned.", 256, i, 1, 0xff8000);
		i += 15;
		i += 10;
		surface.method216("First indicate which of our 12 rules is being broken. For a detailed", 256, i, 1, 0xffff00);
		i += 15;
		surface.method216("explanation of each rule please read the manual on our website.", 256, i, 1, 0xffff00);
		i += 15;
		int k;
		if(anInt943 == 1) {
			surface.method214(66, i - 12, 380, 15, 0xffffff);
			k = 0xff8000;
		} else {
			k = 0xffffff;
		}
		surface.method216("1: Offensive language", 256, i, 1, k);
		i += 14;
		if(anInt943 == 2) {
			surface.method214(66, i - 12, 380, 15, 0xffffff);
			k = 0xff8000;
		} else {
			k = 0xffffff;
		}
		surface.method216("2: Item scamming", 256, i, 1, k);
		i += 14;
		if(anInt943 == 3) {
			surface.method214(66, i - 12, 380, 15, 0xffffff);
			k = 0xff8000;
		} else {
			k = 0xffffff;
		}
		surface.method216("3: Password scamming", 256, i, 1, k);
		i += 14;
		if(anInt943 == 4) {
			surface.method214(66, i - 12, 380, 15, 0xffffff);
			k = 0xff8000;
		} else {
			k = 0xffffff;
		}
		surface.method216("4: Bug abuse", 256, i, 1, k);
		i += 14;
		if(anInt943 == 5) {
			surface.method214(66, i - 12, 380, 15, 0xffffff);
			k = 0xff8000;
		} else {
			k = 0xffffff;
		}
		surface.method216("5: Jagex Staff impersonation", 256, i, 1, k);
		i += 14;
		if(anInt943 == 6) {
			surface.method214(66, i - 12, 380, 15, 0xffffff);
			k = 0xff8000;
		} else {
			k = 0xffffff;
		}
		surface.method216("6: Account sharing/trading", 256, i, 1, k);
		i += 14;
		if(anInt943 == 7) {
			surface.method214(66, i - 12, 380, 15, 0xffffff);
			k = 0xff8000;
		} else {
			k = 0xffffff;
		}
		surface.method216("7: Macroing", 256, i, 1, k);
		i += 14;
		if(anInt943 == 8) {
			surface.method214(66, i - 12, 380, 15, 0xffffff);
			k = 0xff8000;
		} else {
			k = 0xffffff;
		}
		surface.method216("8: Mutiple logging in", 256, i, 1, k);
		i += 14;
		if(anInt943 == 9) {
			surface.method214(66, i - 12, 380, 15, 0xffffff);
			k = 0xff8000;
		} else {
			k = 0xffffff;
		}
		surface.method216("9: Encouraging others to break rules", 256, i, 1, k);
		i += 14;
		if(anInt943 == 10) {
			surface.method214(66, i - 12, 380, 15, 0xffffff);
			k = 0xff8000;
		} else {
			k = 0xffffff;
		}
		surface.method216("10: Misuse of customer support", 256, i, 1, k);
		i += 14;
		if(anInt943 == 11) {
			surface.method214(66, i - 12, 380, 15, 0xffffff);
			k = 0xff8000;
		} else {
			k = 0xffffff;
		}
		surface.method216("11: Advertising / website", 256, i, 1, k);
		i += 14;
		if(anInt943 == 12) {
			surface.method214(66, i - 12, 380, 15, 0xffffff);
			k = 0xff8000;
		} else {
			k = 0xffffff;
		}
		surface.method216("12: Real world item trading", 256, i, 1, k);
		i += 14;
		i += 15;
		k = 0xffffff;
		if(super.anInt39 > 196 && super.anInt39 < 316 && super.anInt41 > i - 15 && super.anInt41 < i + 5)
			k = 0xffff00;
		surface.method216("Click here to cancel", 256, i, 1, k);
	}

	private final void method112() {
		if(anInt653 != 0 && anInt970 == 0)
			anInt970 = 1;
		if(anInt970 > 0) {
			int i = super.anInt39 - 22;
			int j = super.anInt41 - 36;
			if(i >= 0 && j >= 0 && i < 468 && j < 262) {
				if(i > 216 && j > 30 && i < 462 && j < 235) {
					int k = (i - 217) / 49 + ((j - 31) / 34) * 5;
					if(k >= 0 && k < inventorySize) {
						boolean flag1 = false;
						int l1 = 0;
						int k2 = inventoryItemsIDs[k];
						for(int k3 = 0; k3 < anInt893; k3++)
							if(anIntArray971[k3] == k2)
								if(Definitions.inventoryItemsStackable[k2] == 0) {
									for(int i4 = 0; i4 < anInt970; i4++) {
										if(anIntArray972[k3] < inventoryItemsQuantities[k])
											anIntArray972[k3]++;
										flag1 = true;
									}

								} else {
									l1++;
								}

						if(method68(k2) <= l1)
							flag1 = true;
						if(Definitions.anIntArray72[k2] == 1) {
							method79("This object cannot be added to a duel offer", 3);
							flag1 = true;
						}
						if(!flag1 && anInt893 < 8) {
							anIntArray971[anInt893] = k2;
							anIntArray972[anInt893] = 1;
							anInt893++;
							flag1 = true;
						}
						if(flag1) {
							super.packetStream.createPacket(33);
							super.packetStream.putByte(anInt893);
							for(int j4 = 0; j4 < anInt893; j4++) {
								super.packetStream.putShort(anIntArray971[j4]);
								super.packetStream.put4(anIntArray972[j4]);
							}

							super.packetStream.endPacket();
							aBoolean895 = false;
							aBoolean896 = false;
						}
					}
				}
				if(i > 8 && j > 30 && i < 205 && j < 129) {
					int l = (i - 9) / 49 + ((j - 31) / 34) * 4;
					if(l >= 0 && l < anInt893) {
						int j1 = anIntArray971[l];
						for(int i2 = 0; i2 < anInt970; i2++) {
							if(Definitions.inventoryItemsStackable[j1] == 0 && anIntArray972[l] > 1) {
								anIntArray972[l]--;
								continue;
							}
							anInt893--;
							anInt973 = 0;
							for(int l2 = l; l2 < anInt893; l2++) {
								anIntArray971[l2] = anIntArray971[l2 + 1];
								anIntArray972[l2] = anIntArray972[l2 + 1];
							}

							break;
						}

						super.packetStream.createPacket(33);
						super.packetStream.putByte(anInt893);
						for(int i3 = 0; i3 < anInt893; i3++) {
							super.packetStream.putShort(anIntArray971[i3]);
							super.packetStream.put4(anIntArray972[i3]);
						}

						super.packetStream.endPacket();
						aBoolean895 = false;
						aBoolean896 = false;
					}
				}
				boolean flag = false;
				if(i >= 93 && j >= 221 && i <= 104 && j <= 232) {
					aBoolean897 = !aBoolean897;
					flag = true;
				}
				if(i >= 93 && j >= 240 && i <= 104 && j <= 251) {
					aBoolean898 = !aBoolean898;
					flag = true;
				}
				if(i >= 191 && j >= 221 && i <= 202 && j <= 232) {
					aBoolean899 = !aBoolean899;
					flag = true;
				}
				if(i >= 191 && j >= 240 && i <= 202 && j <= 251) {
					aBoolean900 = !aBoolean900;
					flag = true;
				}
				if(flag) {
					super.packetStream.createPacket(8);
					super.packetStream.putByte(aBoolean897 ? 1 : 0);
					super.packetStream.putByte(aBoolean898 ? 1 : 0);
					super.packetStream.putByte(aBoolean899 ? 1 : 0);
					super.packetStream.putByte(aBoolean900 ? 1 : 0);
					super.packetStream.endPacket();
					aBoolean895 = false;
					aBoolean896 = false;
				}
				if(i >= 217 && j >= 238 && i <= 286 && j <= 259) {
					aBoolean896 = true;
					super.packetStream.createPacket(176);
					super.packetStream.endPacket();
				}
				if(i >= 394 && j >= 238 && i < 463 && j < 259) {
					aBoolean817 = false;
					super.packetStream.createPacket(197);
					super.packetStream.endPacket();
				}
			} else
			if(anInt653 != 0) {
				aBoolean817 = false;
				super.packetStream.createPacket(197);
				super.packetStream.endPacket();
			}
			anInt653 = 0;
			anInt970 = 0;
		}
		if(!aBoolean817)
			return;
		byte byte0 = 22;
		byte byte1 = 36;
		surface.method207(byte0, byte1, 468, 12, 0xc90b1d);
		int i1 = 0x989898;
		surface.method224(byte0, byte1 + 12, 468, 18, i1, 160);
		surface.method224(byte0, byte1 + 30, 8, 248, i1, 160);
		surface.method224(byte0 + 205, byte1 + 30, 11, 248, i1, 160);
		surface.method224(byte0 + 462, byte1 + 30, 6, 248, i1, 160);
		surface.method224(byte0 + 8, byte1 + 99, 197, 24, i1, 160);
		surface.method224(byte0 + 8, byte1 + 192, 197, 23, i1, 160);
		surface.method224(byte0 + 8, byte1 + 258, 197, 20, i1, 160);
		surface.method224(byte0 + 216, byte1 + 235, 246, 43, i1, 160);
		int k1 = 0xd0d0d0;
		surface.method224(byte0 + 8, byte1 + 30, 197, 69, k1, 160);
		surface.method224(byte0 + 8, byte1 + 123, 197, 69, k1, 160);
		surface.method224(byte0 + 8, byte1 + 215, 197, 43, k1, 160);
		surface.method224(byte0 + 216, byte1 + 30, 246, 205, k1, 160);
		for(int j2 = 0; j2 < 3; j2++)
			surface.method251(byte0 + 8, byte1 + 30 + j2 * 34, 197, 0);

		for(int j3 = 0; j3 < 3; j3++)
			surface.method251(byte0 + 8, byte1 + 123 + j3 * 34, 197, 0);

		for(int l3 = 0; l3 < 7; l3++)
			surface.method251(byte0 + 216, byte1 + 30 + l3 * 34, 246, 0);

		for(int k4 = 0; k4 < 6; k4++) {
			if(k4 < 5)
				surface.method217(byte0 + 8 + k4 * 49, byte1 + 30, 69, 0);
			if(k4 < 5)
				surface.method217(byte0 + 8 + k4 * 49, byte1 + 123, 69, 0);
			surface.method217(byte0 + 216 + k4 * 49, byte1 + 30, 205, 0);
		}

		surface.method251(byte0 + 8, byte1 + 215, 197, 0);
		surface.method251(byte0 + 8, byte1 + 257, 197, 0);
		surface.method217(byte0 + 8, byte1 + 215, 43, 0);
		surface.method217(byte0 + 204, byte1 + 215, 43, 0);
		surface.method254("Preparing to duel with: " + aString892, byte0 + 1, byte1 + 10, 1, 0xffffff);
		surface.method254("Your Stake", byte0 + 9, byte1 + 27, 4, 0xffffff);
		surface.method254("Opponent's Stake", byte0 + 9, byte1 + 120, 4, 0xffffff);
		surface.method254("Duel Options", byte0 + 9, byte1 + 212, 4, 0xffffff);
		surface.method254("Your Inventory", byte0 + 216, byte1 + 27, 4, 0xffffff);
		surface.method254("No retreating", byte0 + 8 + 1, byte1 + 215 + 16, 3, 0xffff00);
		surface.method254("No magic", byte0 + 8 + 1, byte1 + 215 + 35, 3, 0xffff00);
		surface.method254("No prayer", byte0 + 8 + 102, byte1 + 215 + 16, 3, 0xffff00);
		surface.method254("No weapons", byte0 + 8 + 102, byte1 + 215 + 35, 3, 0xffff00);
		surface.method214(byte0 + 93, byte1 + 215 + 6, 11, 11, 0xffff00);
		if(aBoolean897)
			surface.method207(byte0 + 95, byte1 + 215 + 8, 7, 7, 0xffff00);
		surface.method214(byte0 + 93, byte1 + 215 + 25, 11, 11, 0xffff00);
		if(aBoolean898)
			surface.method207(byte0 + 95, byte1 + 215 + 27, 7, 7, 0xffff00);
		surface.method214(byte0 + 191, byte1 + 215 + 6, 11, 11, 0xffff00);
		if(aBoolean899)
			surface.method207(byte0 + 193, byte1 + 215 + 8, 7, 7, 0xffff00);
		surface.method214(byte0 + 191, byte1 + 215 + 25, 11, 11, 0xffff00);
		if(aBoolean900)
			surface.method207(byte0 + 193, byte1 + 215 + 27, 7, 7, 0xffff00);
		if(!aBoolean896)
			surface.method246(byte0 + 217, byte1 + 238, anInt658 + 25);
		surface.method246(byte0 + 394, byte1 + 238, anInt658 + 26);
		if(aBoolean895) {
			surface.method216("Other player", byte0 + 341, byte1 + 246, 1, 0xffffff);
			surface.method216("has accepted", byte0 + 341, byte1 + 256, 1, 0xffffff);
		}
		if(aBoolean896) {
			surface.method216("Waiting for", byte0 + 217 + 35, byte1 + 246, 1, 0xffffff);
			surface.method216("other player", byte0 + 217 + 35, byte1 + 256, 1, 0xffffff);
		}
		for(int l4 = 0; l4 < inventorySize; l4++) {
			int i5 = 217 + byte0 + (l4 % 5) * 49;
			int k5 = 31 + byte1 + (l4 / 5) * 34;
			surface.method221(i5, k5, 48, 32, anInt786 + Definitions.anIntArray66[inventoryItemsIDs[l4]], Definitions.anIntArray71[inventoryItemsIDs[l4]], 0, 0, false);
			if(Definitions.inventoryItemsStackable[inventoryItemsIDs[l4]] == 0)
				surface.method254(String.valueOf(inventoryItemsQuantities[l4]), i5 + 1, k5 + 10, 1, 0xffff00);
		}

		for(int j5 = 0; j5 < anInt893; j5++) {
			int l5 = 9 + byte0 + (j5 % 4) * 49;
			int j6 = 31 + byte1 + (j5 / 4) * 34;
			surface.method221(l5, j6, 48, 32, anInt786 + Definitions.anIntArray66[anIntArray971[j5]], Definitions.anIntArray71[anIntArray971[j5]], 0, 0, false);
			if(Definitions.inventoryItemsStackable[anIntArray971[j5]] == 0)
				surface.method254(String.valueOf(anIntArray972[j5]), l5 + 1, j6 + 10, 1, 0xffff00);
			if(super.anInt39 > l5 && super.anInt39 < l5 + 48 && super.anInt41 > j6 && super.anInt41 < j6 + 32)
				surface.method254(Definitions.itemNames[anIntArray971[j5]] + ": @whi@" + Definitions.aStringArray64[anIntArray971[j5]], byte0 + 8, byte1 + 273, 1, 0xffff00);
		}

		for(int i6 = 0; i6 < anInt894; i6++) {
			int k6 = 9 + byte0 + (i6 % 4) * 49;
			int l6 = 124 + byte1 + (i6 / 4) * 34;
			surface.method221(k6, l6, 48, 32, anInt786 + Definitions.anIntArray66[anIntArray909[i6]], Definitions.anIntArray71[anIntArray909[i6]], 0, 0, false);
			if(Definitions.inventoryItemsStackable[anIntArray909[i6]] == 0)
				surface.method254(String.valueOf(anIntArray910[i6]), k6 + 1, l6 + 10, 1, 0xffff00);
			if(super.anInt39 > k6 && super.anInt39 < k6 + 48 && super.anInt41 > l6 && super.anInt41 < l6 + 32)
				surface.method254(Definitions.itemNames[anIntArray909[i6]] + ": @whi@" + Definitions.aStringArray64[anIntArray909[i6]], byte0 + 8, byte1 + 273, 1, 0xffff00);
		}

	}

	private final void method113() {
		if(anInt653 != 0 && anInt970 == 0)
			anInt970 = 1;
		if(anInt970 > 0) {
			int i = super.anInt39 - 22;
			int j = super.anInt41 - 36;
			if(i >= 0 && j >= 0 && i < 468 && j < 262) {
				if(i > 216 && j > 30 && i < 462 && j < 235) {
					int k = (i - 217) / 49 + ((j - 31) / 34) * 5;
					if(k >= 0 && k < inventorySize) {
						boolean flag = false;
						int l1 = 0;
						int k2 = inventoryItemsIDs[k];
						for(int k3 = 0; k3 < anInt887; k3++)
							if(anIntArray974[k3] == k2)
								if(Definitions.inventoryItemsStackable[k2] == 0) {
									for(int i4 = 0; i4 < anInt970; i4++) {
										if(anIntArray975[k3] < inventoryItemsQuantities[k])
											anIntArray975[k3]++;
										flag = true;
									}

								} else {
									l1++;
								}

						if(method68(k2) <= l1)
							flag = true;
						if(Definitions.anIntArray72[k2] == 1) {
							method79("This object cannot be traded with other players", 3);
							flag = true;
						}
						if(!flag && anInt887 < 12) {
							anIntArray974[anInt887] = k2;
							anIntArray975[anInt887] = 1;
							anInt887++;
							flag = true;
						}
						if(flag) {
							super.packetStream.createPacket(46);
							super.packetStream.putByte(anInt887);
							for(int j4 = 0; j4 < anInt887; j4++) {
								super.packetStream.putShort(anIntArray974[j4]);
								super.packetStream.put4(anIntArray975[j4]);
							}

							super.packetStream.endPacket();
							aBoolean885 = false;
							aBoolean886 = false;
						}
					}
				}
				if(i > 8 && j > 30 && i < 205 && j < 133) {
					int l = (i - 9) / 49 + ((j - 31) / 34) * 4;
					if(l >= 0 && l < anInt887) {
						int j1 = anIntArray974[l];
						for(int i2 = 0; i2 < anInt970; i2++) {
							if(Definitions.inventoryItemsStackable[j1] == 0 && anIntArray975[l] > 1) {
								anIntArray975[l]--;
								continue;
							}
							anInt887--;
							anInt973 = 0;
							for(int l2 = l; l2 < anInt887; l2++) {
								anIntArray974[l2] = anIntArray974[l2 + 1];
								anIntArray975[l2] = anIntArray975[l2 + 1];
							}

							break;
						}

						super.packetStream.createPacket(46);
						super.packetStream.putByte(anInt887);
						for(int i3 = 0; i3 < anInt887; i3++) {
							super.packetStream.putShort(anIntArray974[i3]);
							super.packetStream.put4(anIntArray975[i3]);
						}

						super.packetStream.endPacket();
						aBoolean885 = false;
						aBoolean886 = false;
					}
				}
				if(i >= 217 && j >= 238 && i <= 286 && j <= 259) {
					aBoolean886 = true;
					super.packetStream.createPacket(55);
					super.packetStream.endPacket();
				}
				if(i >= 394 && j >= 238 && i < 463 && j < 259) {
					aBoolean815 = false;
					super.packetStream.createPacket(230);
					super.packetStream.endPacket();
				}
			} else
			if(anInt653 != 0) {
				aBoolean815 = false;
				super.packetStream.createPacket(230);
				super.packetStream.endPacket();
			}
			anInt653 = 0;
			anInt970 = 0;
		}
		if(!aBoolean815)
			return;
		byte byte0 = 22;
		byte byte1 = 36;
		surface.method207(byte0, byte1, 468, 12, 192);
		int i1 = 0x989898;
		surface.method224(byte0, byte1 + 12, 468, 18, i1, 160);
		surface.method224(byte0, byte1 + 30, 8, 248, i1, 160);
		surface.method224(byte0 + 205, byte1 + 30, 11, 248, i1, 160);
		surface.method224(byte0 + 462, byte1 + 30, 6, 248, i1, 160);
		surface.method224(byte0 + 8, byte1 + 133, 197, 22, i1, 160);
		surface.method224(byte0 + 8, byte1 + 258, 197, 20, i1, 160);
		surface.method224(byte0 + 216, byte1 + 235, 246, 43, i1, 160);
		int k1 = 0xd0d0d0;
		surface.method224(byte0 + 8, byte1 + 30, 197, 103, k1, 160);
		surface.method224(byte0 + 8, byte1 + 155, 197, 103, k1, 160);
		surface.method224(byte0 + 216, byte1 + 30, 246, 205, k1, 160);
		for(int j2 = 0; j2 < 4; j2++)
			surface.method251(byte0 + 8, byte1 + 30 + j2 * 34, 197, 0);

		for(int j3 = 0; j3 < 4; j3++)
			surface.method251(byte0 + 8, byte1 + 155 + j3 * 34, 197, 0);

		for(int l3 = 0; l3 < 7; l3++)
			surface.method251(byte0 + 216, byte1 + 30 + l3 * 34, 246, 0);

		for(int k4 = 0; k4 < 6; k4++) {
			if(k4 < 5)
				surface.method217(byte0 + 8 + k4 * 49, byte1 + 30, 103, 0);
			if(k4 < 5)
				surface.method217(byte0 + 8 + k4 * 49, byte1 + 155, 103, 0);
			surface.method217(byte0 + 216 + k4 * 49, byte1 + 30, 205, 0);
		}

		surface.method254("Trading with: " + aString884, byte0 + 1, byte1 + 10, 1, 0xffffff);
		surface.method254("Your Offer", byte0 + 9, byte1 + 27, 4, 0xffffff);
		surface.method254("Opponent's Offer", byte0 + 9, byte1 + 152, 4, 0xffffff);
		surface.method254("Your Inventory", byte0 + 216, byte1 + 27, 4, 0xffffff);
		if(!aBoolean886)
			surface.method246(byte0 + 217, byte1 + 238, anInt658 + 25);
		surface.method246(byte0 + 394, byte1 + 238, anInt658 + 26);
		if(aBoolean885) {
			surface.method216("Other player", byte0 + 341, byte1 + 246, 1, 0xffffff);
			surface.method216("has accepted", byte0 + 341, byte1 + 256, 1, 0xffffff);
		}
		if(aBoolean886) {
			surface.method216("Waiting for", byte0 + 217 + 35, byte1 + 246, 1, 0xffffff);
			surface.method216("other player", byte0 + 217 + 35, byte1 + 256, 1, 0xffffff);
		}
		for(int l4 = 0; l4 < inventorySize; l4++) {
			int i5 = 217 + byte0 + (l4 % 5) * 49;
			int k5 = 31 + byte1 + (l4 / 5) * 34;
			surface.method221(i5, k5, 48, 32, anInt786 + Definitions.anIntArray66[inventoryItemsIDs[l4]], Definitions.anIntArray71[inventoryItemsIDs[l4]], 0, 0, false);
			if(Definitions.inventoryItemsStackable[inventoryItemsIDs[l4]] == 0)
				surface.method254(String.valueOf(inventoryItemsQuantities[l4]), i5 + 1, k5 + 10, 1, 0xffff00);
		}

		for(int j5 = 0; j5 < anInt887; j5++) {
			int l5 = 9 + byte0 + (j5 % 4) * 49;
			int j6 = 31 + byte1 + (j5 / 4) * 34;
			surface.method221(l5, j6, 48, 32, anInt786 + Definitions.anIntArray66[anIntArray974[j5]], Definitions.anIntArray71[anIntArray974[j5]], 0, 0, false);
			if(Definitions.inventoryItemsStackable[anIntArray974[j5]] == 0)
				surface.method254(String.valueOf(anIntArray975[j5]), l5 + 1, j6 + 10, 1, 0xffff00);
			if(super.anInt39 > l5 && super.anInt39 < l5 + 48 && super.anInt41 > j6 && super.anInt41 < j6 + 32)
				surface.method254(Definitions.itemNames[anIntArray974[j5]] + ": @whi@" + Definitions.aStringArray64[anIntArray974[j5]], byte0 + 8, byte1 + 273, 1, 0xffff00);
		}

		for(int i6 = 0; i6 < anInt888; i6++) {
			int k6 = 9 + byte0 + (i6 % 4) * 49;
			int l6 = 156 + byte1 + (i6 / 4) * 34;
			surface.method221(k6, l6, 48, 32, anInt786 + Definitions.anIntArray66[anIntArray889[i6]], Definitions.anIntArray71[anIntArray889[i6]], 0, 0, false);
			if(Definitions.inventoryItemsStackable[anIntArray889[i6]] == 0)
				surface.method254(String.valueOf(anIntArray890[i6]), k6 + 1, l6 + 10, 1, 0xffff00);
			if(super.anInt39 > k6 && super.anInt39 < k6 + 48 && super.anInt41 > l6 && super.anInt41 < l6 + 32)
				surface.method254(Definitions.itemNames[anIntArray889[i6]] + ": @whi@" + Definitions.aStringArray64[anIntArray889[i6]], byte0 + 8, byte1 + 273, 1, 0xffff00);
		}

	}

	protected final void startGame() {
		//checkHost
/*		if(aBoolean782) {
			String s = getDocumentBase().getHost().toLowerCase();
			if(!s.endsWith("jagex.com") && !s.endsWith("jagex.co.uk") && !s.endsWith("runescape.com") && !s.endsWith("runescape.co.uk") && !s.endsWith("runescape.net") && !s.endsWith("runescape.org") && !s.endsWith("penguin") && !s.endsWith("puffin")) {
				aBoolean703 = true;
				return;
			}
		}*/
		int i = 0;
		for(int j = 0; j < 99; j++) {
			int k = j + 1;
			int i1 = (int)((double)k + 300D * Math.pow(2D, (double)k / 7D));
			i += i1;
			anIntArray965[j] = i & 0xffffffc;
		}

		try {
			String s1 = getParameter("referid");
			anInt862 = Integer.parseInt(s1);
		}
		catch(Exception _ex) { }
		try {
			String s2 = getParameter("member");
			int j1 = Integer.parseInt(s2);
			if(j1 == 1)
				isMembers = true;
		}
		catch(Exception _ex) { }
		if(aBoolean782)
			super.anInt620 = 43594;
		super.anInt40 = 0;
		NetworkedGame.anInt621 = 1000;
		NetworkedGame.anInt625 = Versions.anInt559;
		try {
			String s3 = getParameter("poff");
			int k1 = Integer.parseInt(s3);
			super.anInt620 += k1;
			System.out.println("Offset: " + k1);
		}
		catch(Exception _ex) { }
		method82();
		if(aBoolean705)
			return;
		anInt658 = 2000;
		anInt941 = anInt658 + 100;
		anInt786 = anInt941 + 50;
		anInt659 = anInt786 + 1000;
		anInt942 = anInt659 + 10;
		anInt933 = anInt942 + 50;
		anInt969 = anInt933 + 10;
		aGraphics809 = getGraphics();
		method18(50);
		surface = new SpriteSurface(anInt764, anInt765 + 12, 4000, this);
		surface.aMudclient627 = this;
		surface.method253(0, 0, anInt764, anInt765 + 12);
		Panel.aBoolean190 = false;
		Panel.anInt191 = anInt941;
		aPanel959 = new Panel(surface, 5);
		int l = ((Surface) (surface)).anInt320 - 199;
		byte byte0 = 36;
		anInt960 = aPanel959.method152(l, byte0 + 24, 196, 90, 1, 500, true);
		aPanel867 = new Panel(surface, 5);
		anInt868 = aPanel867.method152(l, byte0 + 40, 196, 126, 1, 500, true);
		aPanel966 = new Panel(surface, 5);
		anInt967 = aPanel966.method152(l, byte0 + 24, 196, 251, 1, 500, true);
		method96();
		if(aBoolean705)
			return;
		method85();
		if(aBoolean705)
			return;
		scene = new Scene(surface, 15000, 15000, 1000);
		scene.method292(anInt764 / 2, anInt765 / 2, anInt764 / 2, anInt765 / 2, anInt764, anInt976);
		scene.anInt426 = 2400;
		scene.anInt430 = 2400;
		scene.anInt443 = 1;
		scene.anInt442 = 2300;
		scene.method309(-50, -10, -50);
		world = new RsWorld(scene, surface);
		world.anInt596 = anInt658;
		method110();
		if(aBoolean705)
			return;
		method114();
		if(aBoolean705)
			return;
		method95();
		if(aBoolean705)
			return;
		if(isMembers)
			method108();
		if(aBoolean705) {
			return;
		} else {
			loadSounds();
			method1(100, "Starting game...");
			method91();
			method81();
			method102();
			method103();
			method4();
			method47();
			return;
		}
	}

	public static HashMap<String, File> soundCache = new HashMap<String, File>();

	private void loadSounds() {
		try {
			File folder;
			if (mudClient.injected)
				folder = new File("../data/audio/");
			else
				folder = new File("./data/audio");
			File[] listOfFiles = folder.listFiles();

            for (File listOfFile : listOfFiles)
                if (listOfFile.isFile() && listOfFile.getName().endsWith(".wav")) {
                    soundCache.put(listOfFile.getName().toLowerCase(), listOfFile);
                }
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private final void method114() {
		Definitions.method127("torcha2");
		Definitions.method127("torcha3");
		Definitions.method127("torcha4");
		Definitions.method127("skulltorcha2");
		Definitions.method127("skulltorcha3");
		Definitions.method127("skulltorcha4");
		Definitions.method127("firea2");
		Definitions.method127("firea3");
		Definitions.method127("fireplacea2");
		Definitions.method127("fireplacea3");
		Definitions.method127("firespell2");
		Definitions.method127("firespell3");
		Definitions.method127("lightning2");
		Definitions.method127("lightning3");
		Definitions.method127("clawspell2");
		Definitions.method127("clawspell3");
		Definitions.method127("clawspell4");
		Definitions.method127("clawspell5");
		Definitions.method127("spellcharge2");
		Definitions.method127("spellcharge3");
		/*XXX modified if(method14()) {*/if(true) {
			byte abyte0[] = readDataFile("models" + Versions.anInt563 + ".jag", "3d models", 60);
			if(abyte0 == null) {
				aBoolean705 = true;
				return;
			}
			for(int j = 0; j < Definitions.anInt61; j++) {
				int k = DataUtils.method347(Definitions.aStringArray60[j] + ".ob3", abyte0);
				if(k != 0)
					aModelArray657[j] = new Model(abyte0, k, true);
				else
					aModelArray657[j] = new Model(1, 1);
				if(Definitions.aStringArray60[j].equals("giantcrystal"))
					aModelArray657[j].aBoolean267 = true;
			}

			return;
		}
		method1(70, "Loading 3d models");
		for(int i = 0; i < Definitions.anInt61; i++) {
			aModelArray657[i] = new Model("../gamedata/models/" + Definitions.aStringArray60[i] + ".ob2");
			if(Definitions.aStringArray60[i].equals("giantcrystal"))
				aModelArray657[i].aBoolean267 = true;
		}

	}

	private final boolean method115(int i) {
		for(int j = 0; j < inventorySize; j++)
			if(inventoryItemsIDs[j] == i && inventoryItemsEquipped[j] == 1)
				return true;

		return false;
	}

	private final void method116() {
		int i = 97;
		surface.method207(86, 77, 340, 180, 0);
		surface.method214(86, 77, 340, 180, 0xffffff);
		surface.method216("Warning! Proceed with caution", 256, i, 4, 0xff0000);
		i += 26;
		surface.method216("If you go much further north you will enter the", 256, i, 1, 0xffffff);
		i += 13;
		surface.method216("wilderness. This a very dangerous area where", 256, i, 1, 0xffffff);
		i += 13;
		surface.method216("other players can attack you!", 256, i, 1, 0xffffff);
		i += 22;
		surface.method216("The further north you go the more dangerous it", 256, i, 1, 0xffffff);
		i += 13;
		surface.method216("becomes, but the more treasure you will find.", 256, i, 1, 0xffffff);
		i += 22;
		surface.method216("In the wilderness an indicator at the bottom-right", 256, i, 1, 0xffffff);
		i += 13;
		surface.method216("of the screen will show the current level of danger", 256, i, 1, 0xffffff);
		i += 22;
		int j = 0xffffff;
		if(super.anInt41 > i - 12 && super.anInt41 <= i && super.anInt39 > 181 && super.anInt39 < 331)
			j = 0xff0000;
		surface.method216("Click here to close window", 256, i, 1, j);
		if(anInt653 != 0) {
			if(super.anInt41 > i - 12 && super.anInt41 <= i && super.anInt39 > 181 && super.anInt39 < 331)
				anInt811 = 2;
			if(super.anInt39 < 86 || super.anInt39 > 426 || super.anInt41 < 77 || super.anInt41 > 257)
				anInt811 = 2;
			anInt653 = 0;
		}
	}

	private final void method117() {
		int i = 65;
		if(anInt928 != 201)
			i += 60;
		if(anInt929 > 0)
			i += 60;
		if(anInt926 != 0)
			i += 45;
		int j = 167 - i / 2;
		surface.method207(56, 167 - i / 2, 400, i, 0);
		surface.method214(56, 167 - i / 2, 400, i, 0xffffff);
		j += 20;
		surface.method216("Welcome to RuneScape " + aString778, 256, j, 4, 0xffff00);
		j += 30;
		String s;
		if(anInt927 == 0)
			s = "earlier today";
		else
		if(anInt927 == 1)
			s = "yesterday";
		else
			s = anInt927 + " days ago";
		if(anInt926 != 0) {
			surface.method216("You last logged in " + s, 256, j, 1, 0xffffff);
			j += 15;
			if(aString930 == null)
				aString930 = method90(anInt926);
			surface.method216("from: " + aString930, 256, j, 1, 0xffffff);
			j += 15;
			j += 15;
		}
		if(anInt929 > 0) {
			int k = 0xffffff;
			surface.method216("Jagex staff will NEVER email you. We use the", 256, j, 1, k);
			j += 15;
			surface.method216("message-centre on this website instead.", 256, j, 1, k);
			j += 15;
			if(anInt929 == 1)
				surface.method216("You have @yel@0@whi@ unread messages in your message-centre", 256, j, 1, 0xffffff);
			else
				surface.method216("You have @gre@" + (anInt929 - 1) + " unread messages @whi@in your message-centre", 256, j, 1, 0xffffff);
			j += 15;
			j += 15;
		}
		if(anInt928 != 201) {
			if(anInt928 == 200) {
				surface.method216("You have not yet set any password recovery questions.", 256, j, 1, 0xff8000);
				j += 15;
				surface.method216("We strongly recommend you do so now to secure your account.", 256, j, 1, 0xff8000);
				j += 15;
				surface.method216("Do this from the 'account management' area on our front webpage", 256, j, 1, 0xff8000);
				j += 15;
			} else {
				String s1;
				if(anInt928 == 0)
					s1 = "Earlier today";
				else
				if(anInt928 == 1)
					s1 = "Yesterday";
				else
					s1 = anInt928 + " days ago";
				surface.method216(s1 + " you changed your recovery questions", 256, j, 1, 0xff8000);
				j += 15;
				surface.method216("If you do not remember making this change then cancel it immediately", 256, j, 1, 0xff8000);
				j += 15;
				surface.method216("Do this from the 'account management' area on our front webpage", 256, j, 1, 0xff8000);
				j += 15;
			}
			j += 15;
		}
		int l = 0xffffff;
		if(super.anInt41 > j - 12 && super.anInt41 <= j && super.anInt39 > 106 && super.anInt39 < 406)
			l = 0xff0000;
		surface.method216("Click here to close window", 256, j, 1, l);
		if(anInt653 == 1) {
			if(l == 0xff0000)
				aBoolean810 = false;
			if((super.anInt39 < 86 || super.anInt39 > 426) && (super.anInt41 < 167 - i / 2 || super.anInt41 > 167 + i / 2))
				aBoolean810 = false;
		}
		anInt653 = 0;
	}

	final void method118(int i, int j, int k, int l, int i1, int j1, int k1) {
		int l1 = Definitions.anIntArray66[i1] + anInt786;
		int i2 = Definitions.anIntArray71[i1];
		surface.method221(i, j, k, l, l1, i2, 0, 0, false);
	}

	private final void method119() {
		if(anInt803 > 1)
			anInt803--;
		method28();
		if(anInt675 > 0)
			anInt675--;
		if(super.anInt25 > 4500 && anInt674 == 0 && anInt675 == 0) {
			super.anInt25 -= 500;
			method74();
			return;
		}
		if(localPlayer.anInt153 == 8 || localPlayer.anInt153 == 9)
			anInt674 = 500;
		if(anInt674 > 0)
			anInt674--;
		if(aBoolean751) {
			method56();
			return;
		}
		for(int i = 0; i < playerCount; i++) {
			RsCharacter rscharacter = aRsCharacterArray694[i];
			int k = (rscharacter.anInt156 + 1) % 10;
			if(rscharacter.anInt155 != k) {
				int i1 = -1;
				int l2 = rscharacter.anInt155;
				int j4;
				if(l2 < k)
					j4 = k - l2;
				else
					j4 = (10 + k) - l2;
				int j5 = 4;
				if(j4 > 2)
					j5 = (j4 - 1) * 4;
				if(rscharacter.anIntArray174[l2] - rscharacter.anInt149 > anInt676 * 3 || rscharacter.anIntArray175[l2] - rscharacter.anInt150 > anInt676 * 3 || rscharacter.anIntArray174[l2] - rscharacter.anInt149 < -anInt676 * 3 || rscharacter.anIntArray175[l2] - rscharacter.anInt150 < -anInt676 * 3 || j4 > 8) {
					rscharacter.anInt149 = rscharacter.anIntArray174[l2];
					rscharacter.anInt150 = rscharacter.anIntArray175[l2];
				} else {
					if(rscharacter.anInt149 < rscharacter.anIntArray174[l2]) {
						rscharacter.anInt149 += j5;
						rscharacter.anInt152++;
						i1 = 2;
					} else
					if(rscharacter.anInt149 > rscharacter.anIntArray174[l2]) {
						rscharacter.anInt149 -= j5;
						rscharacter.anInt152++;
						i1 = 6;
					}
					if(rscharacter.anInt149 - rscharacter.anIntArray174[l2] < j5 && rscharacter.anInt149 - rscharacter.anIntArray174[l2] > -j5)
						rscharacter.anInt149 = rscharacter.anIntArray174[l2];
					if(rscharacter.anInt150 < rscharacter.anIntArray175[l2]) {
						rscharacter.anInt150 += j5;
						rscharacter.anInt152++;
						if(i1 == -1)
							i1 = 4;
						else
						if(i1 == 2)
							i1 = 3;
						else
							i1 = 5;
					} else
					if(rscharacter.anInt150 > rscharacter.anIntArray175[l2]) {
						rscharacter.anInt150 -= j5;
						rscharacter.anInt152++;
						if(i1 == -1)
							i1 = 0;
						else
						if(i1 == 2)
							i1 = 1;
						else
							i1 = 7;
					}
					if(rscharacter.anInt150 - rscharacter.anIntArray175[l2] < j5 && rscharacter.anInt150 - rscharacter.anIntArray175[l2] > -j5)
						rscharacter.anInt150 = rscharacter.anIntArray175[l2];
				}
				if(i1 != -1)
					rscharacter.anInt153 = i1;
				if(rscharacter.anInt149 == rscharacter.anIntArray174[l2] && rscharacter.anInt150 == rscharacter.anIntArray175[l2])
					rscharacter.anInt155 = (l2 + 1) % 10;
			} else {
				rscharacter.anInt153 = rscharacter.anInt154;
			}
			if(rscharacter.anInt158 > 0)
				rscharacter.anInt158--;
			if(rscharacter.anInt160 > 0)
				rscharacter.anInt160--;
			if(rscharacter.anInt164 > 0)
				rscharacter.anInt164--;
			if(anInt883 > 0) {
				anInt883--;
				if(anInt883 == 0)
					method79("You have been granted another life. Be more careful this time!", 3);
				if(anInt883 == 0)
					method79("You retain your skills. Your objects land where you died", 3);
			}
		}

		for(int j = 0; j < npcCount; j++) {
			RsCharacter rscharacter1 = aRsCharacterArray677[j];
			int j1 = (rscharacter1.anInt156 + 1) % 10;
			if(rscharacter1.anInt155 != j1) {
				int i3 = -1;
				int k4 = rscharacter1.anInt155;
				int k5;
				if(k4 < j1)
					k5 = j1 - k4;
				else
					k5 = (10 + j1) - k4;
				int l5 = 4;
				if(k5 > 2)
					l5 = (k5 - 1) * 4;
				if(rscharacter1.anIntArray174[k4] - rscharacter1.anInt149 > anInt676 * 3 || rscharacter1.anIntArray175[k4] - rscharacter1.anInt150 > anInt676 * 3 || rscharacter1.anIntArray174[k4] - rscharacter1.anInt149 < -anInt676 * 3 || rscharacter1.anIntArray175[k4] - rscharacter1.anInt150 < -anInt676 * 3 || k5 > 8) {
					rscharacter1.anInt149 = rscharacter1.anIntArray174[k4];
					rscharacter1.anInt150 = rscharacter1.anIntArray175[k4];
				} else {
					if(rscharacter1.anInt149 < rscharacter1.anIntArray174[k4]) {
						rscharacter1.anInt149 += l5;
						rscharacter1.anInt152++;
						i3 = 2;
					} else
					if(rscharacter1.anInt149 > rscharacter1.anIntArray174[k4]) {
						rscharacter1.anInt149 -= l5;
						rscharacter1.anInt152++;
						i3 = 6;
					}
					if(rscharacter1.anInt149 - rscharacter1.anIntArray174[k4] < l5 && rscharacter1.anInt149 - rscharacter1.anIntArray174[k4] > -l5)
						rscharacter1.anInt149 = rscharacter1.anIntArray174[k4];
					if(rscharacter1.anInt150 < rscharacter1.anIntArray175[k4]) {
						rscharacter1.anInt150 += l5;
						rscharacter1.anInt152++;
						if(i3 == -1)
							i3 = 4;
						else
						if(i3 == 2)
							i3 = 3;
						else
							i3 = 5;
					} else
					if(rscharacter1.anInt150 > rscharacter1.anIntArray175[k4]) {
						rscharacter1.anInt150 -= l5;
						rscharacter1.anInt152++;
						if(i3 == -1)
							i3 = 0;
						else
						if(i3 == 2)
							i3 = 1;
						else
							i3 = 7;
					}
					if(rscharacter1.anInt150 - rscharacter1.anIntArray175[k4] < l5 && rscharacter1.anInt150 - rscharacter1.anIntArray175[k4] > -l5)
						rscharacter1.anInt150 = rscharacter1.anIntArray175[k4];
				}
				if(i3 != -1)
					rscharacter1.anInt153 = i3;
				if(rscharacter1.anInt149 == rscharacter1.anIntArray174[k4] && rscharacter1.anInt150 == rscharacter1.anIntArray175[k4])
					rscharacter1.anInt155 = (k4 + 1) % 10;
			} else {
				rscharacter1.anInt153 = rscharacter1.anInt154;
				if(rscharacter1.anInt151 == 43)
					rscharacter1.anInt152++;
			}
			if(rscharacter1.anInt158 > 0)
				rscharacter1.anInt158--;
			if(rscharacter1.anInt160 > 0)
				rscharacter1.anInt160--;
			if(rscharacter1.anInt164 > 0)
				rscharacter1.anInt164--;
		}

		if(showUiTab != 2) {
			if(Surface.anInt338 > 0)
				anInt977++;
			if(Surface.anInt339 > 0)
				anInt977 = 0;
			Surface.anInt338 = 0;
			Surface.anInt339 = 0;
		}
		for(int l = 0; l < playerCount; l++) {
			RsCharacter rscharacter2 = aRsCharacterArray694[l];
			if(rscharacter2.anInt172 > 0)
				rscharacter2.anInt172--;
		}

		if(cameraAutoAngleDebug) {
			if(anInt954 - localPlayer.anInt149 < -500 || anInt954 - localPlayer.anInt149 > 500 || anInt955 - localPlayer.anInt150 < -500 || anInt955 - localPlayer.anInt150 > 500) {
				anInt954 = localPlayer.anInt149;
				anInt955 = localPlayer.anInt150;
			}
		} else {
			if(anInt954 - localPlayer.anInt149 < -500 || anInt954 - localPlayer.anInt149 > 500 || anInt955 - localPlayer.anInt150 < -500 || anInt955 - localPlayer.anInt150 > 500) {
				anInt954 = localPlayer.anInt149;
				anInt955 = localPlayer.anInt150;
			}
			if(anInt954 != localPlayer.anInt149)
				anInt954 += (localPlayer.anInt149 - anInt954) / (16 + (anInt956 - 500) / 15);
			if(anInt955 != localPlayer.anInt150)
				anInt955 += (localPlayer.anInt150 - anInt955) / (16 + (anInt956 - 500) / 15);
			if(aBoolean869) {
				int k1 = anInt652 * 32;
				int j3 = k1 - anInt678;
				byte byte0 = 1;
				if(j3 != 0) {
					anInt978++;
					if(j3 > 128) {
						byte0 = -1;
						j3 = 256 - j3;
					} else
					if(j3 > 0)
						byte0 = 1;
					else
					if(j3 < -128) {
						byte0 = 1;
						j3 = 256 + j3;
					} else
					if(j3 < 0) {
						byte0 = -1;
						j3 = -j3;
					}
					anInt678 += ((anInt978 * j3 + 255) / 256) * byte0;
					anInt678 &= 0xff;
				} else {
					anInt978 = 0;
				}
			}
		}
		if(anInt977 > 20) {
			aBoolean979 = false;
			anInt977 = 0;
		}
		if(aBoolean793) {
			if(super.inputTextFinal.length() > 0)
				if(super.inputTextFinal.equalsIgnoreCase("::lostcon") && !aBoolean782)
					super.packetStream.method339();
				else
				if(super.inputTextFinal.equalsIgnoreCase("::closecon") && !aBoolean782) {
					method36();
				} else {
					super.packetStream.createPacket(45);
					super.packetStream.method329(super.inputTextFinal);
					if(!aBoolean979) {
						super.packetStream.putByte(0);
						aBoolean979 = true;
					}
					super.packetStream.endPacket();
					super.inputTextCurrent = "";
					super.inputTextFinal = "";
					aString934 = "Please wait...";
				}
			if(super.anInt43 == 1 && super.anInt41 > 275 && super.anInt41 < 310 && super.anInt39 > 56 && super.anInt39 < 456) {
				super.packetStream.createPacket(45);
				super.packetStream.method329("-null-");
				if(!aBoolean979) {
					super.packetStream.putByte(0);
					aBoolean979 = true;
				}
				super.packetStream.endPacket();
				super.inputTextCurrent = "";
				super.inputTextFinal = "";
				aString934 = "Please wait...";
			}
			super.anInt43 = 0;
			return;
		}
		if(super.anInt41 > anInt765 - 4) {
			if(super.anInt39 > 15 && super.anInt39 < 96 && super.anInt43 == 1)
				anInt845 = 0;
			if(super.anInt39 > 110 && super.anInt39 < 194 && super.anInt43 == 1) {
				anInt845 = 1;
				aPanel794.anIntArray200[anInt858] = 0xf423f;
			}
			if(super.anInt39 > 215 && super.anInt39 < 295 && super.anInt43 == 1) {
				anInt845 = 2;
				aPanel794.anIntArray200[anInt859] = 0xf423f;
			}
			if(super.anInt39 > 315 && super.anInt39 < 395 && super.anInt43 == 1) {
				anInt845 = 3;
				aPanel794.anIntArray200[anInt860] = 0xf423f;
			}
			if(super.anInt39 > 417 && super.anInt39 < 497 && super.anInt43 == 1) {
				anInt792 = 1;
				anInt943 = 0;
				super.inputTextCurrent = "";
				super.inputTextFinal = "";
			}
			super.anInt43 = 0;
			super.anInt42 = 0;
		}
		aPanel794.method142(super.anInt39, super.anInt41, super.anInt43, super.anInt42);
		if(anInt845 > 0 && super.anInt39 >= 494 && super.anInt41 >= anInt765 - 66)
			super.anInt43 = 0;
		if(aPanel794.method159(anInt870)) {
			String s = aPanel794.method166(anInt870);
			aPanel794.method168(anInt870, "");
			if(s.startsWith("::")) {
				if(s.equalsIgnoreCase("::closecon") && !aBoolean782)
					super.packetStream.method339();
				else
				if(s.equalsIgnoreCase("::logout") && !aBoolean782)
					method36();
				else
				if(s.equalsIgnoreCase("::lostcon") && !aBoolean782)
					method37();
				else
					method35(s.substring(2));
			} else {
				int k3 = ChatEncoding.method389(s);
				method32(ChatEncoding.aByteArray557, k3);

				try {
					s = ChatEncoding.method388(ChatEncoding.aByteArray557, 0, k3);
					//TODO: Check
					//s = ChatFilter.method380(s);
					localPlayer.anInt158 = 150;
					localPlayer.aString157 = s;
					method79(localPlayer.aString146 + ": " + s, 2);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		}
		if(anInt845 == 0) {
			for(int l1 = 0; l1 < 5; l1++)
				if(anIntArray857[l1] > 0)
					anIntArray857[l1]--;

		}
		if(anInt883 != 0)
			super.anInt43 = 0;
		if(aBoolean815 || aBoolean817) {
			if(super.anInt42 != 0)
				anInt973++;
			else
				anInt973 = 0;
			if(anInt973 > 600)
				anInt970 += 5000;
			else
			if(anInt973 > 450)
				anInt970 += 500;
			else
			if(anInt973 > 300)
				anInt970 += 50;
			else
			if(anInt973 > 150)
				anInt970 += 5;
			else
			if(anInt973 > 50)
				anInt970++;
			else
			if(anInt973 > 20 && (anInt973 & 5) == 0)
				anInt970++;
		} else {
			anInt973 = 0;
			anInt970 = 0;
		}
		if(super.anInt43 == 1)
			anInt653 = 1;
		else
		if(super.anInt43 == 2)
			anInt653 = 2;
		scene.method286(super.anInt39, super.anInt41);
		super.anInt43 = 0;
		if(aBoolean869) {
			if(anInt978 == 0 || cameraAutoAngleDebug) {
				if(super.keyLeft) {
					anInt652 = anInt652 + 1 & 7;
					super.keyLeft = false;
					if(!aBoolean945) {
						if((anInt652 & 1) == 0)
							anInt652 = anInt652 + 1 & 7;
						for(int i2 = 0; i2 < 8; i2++) {
							if(method66(anInt652))
								break;
							anInt652 = anInt652 + 1 & 7;
						}

					}
				}
				if(super.keyRight) {
					anInt652 = anInt652 + 7 & 7;
					super.keyRight = false;
					if(!aBoolean945) {
						if((anInt652 & 1) == 0)
							anInt652 = anInt652 + 7 & 7;
						for(int j2 = 0; j2 < 8; j2++) {
							if(method66(anInt652))
								break;
							anInt652 = anInt652 + 7 & 7;
						}

					}
				}
			}
		} else
		if(super.keyLeft)
			anInt678 = anInt678 + 2 & 0xff;
		else
		if(super.keyRight)
			anInt678 = anInt678 - 2 & 0xff;
		if(aBoolean945 && anInt956 > 550)
			anInt956 -= 4;
		else
		if(!aBoolean945 && anInt956 < 750)
			anInt956 += 4;
		if(anInt800 > 0)
			anInt800--;
		else
		if(anInt800 < 0)
			anInt800++;
		scene.method270(17);
		anInt980++;
		if(anInt980 > 5) {
			anInt980 = 0;
			anInt946 = (anInt946 + 1) % 3;
			anInt948 = (anInt948 + 1) % 4;
			anInt950 = (anInt950 + 1) % 5;
		}
		for(int k2 = 0; k2 < anInt759; k2++) {
			int l3 = anIntArray757[k2];
			int l4 = anIntArray758[k2];
			if(l3 >= 0 && l4 >= 0 && l3 < 96 && l4 < 96 && anIntArray820[k2] == 74)
				aModelArray787[k2].method204(1, 0, 0);
		}

		for(int i4 = 0; i4 < anInt923; i4++) {
			teleportBubbleTime[i4]++;
			if(teleportBubbleTime[i4] > 50) {
				anInt923--;
				for(int i5 = i4; i5 < anInt923; i5++) {
					anIntArray924[i5] = anIntArray924[i5 + 1];
					anIntArray925[i5] = anIntArray925[i5 + 1];
					teleportBubbleTime[i5] = teleportBubbleTime[i5 + 1];
					anIntArray660[i5] = anIntArray660[i5 + 1];
				}

			}
		}

	}

	private final void method120() {
		super.inputPmCurrent = "";
		super.inputPmFinal = "";
	}

	private final int anInt636 = 250;
	private final int anInt637 = 5;
	private final int anInt638 = 50;
	private final int anInt639 = 18;
	private final int anInt640 = 500;
	private final int anInt641 = 1500;
	private final int anInt642 = 5000;
	private final int anInt643 = 5000;
	private final int anInt644 = 500;
	private final int anInt645 = 4000;
	private final int anInt646 = 500;
	private final int anInt647 = 8000;
	private String aString648;
	private String aString649;
	private int anInt650;
	private final String aStringArray651[] = {
		"Where were you born?", "What was your first teachers name?", "What is your fathers middle name?", "Who was your first best friend?", "What is your favourite vacation spot?", "What is your mothers middle name?", "What was your first pets name?", "What was the name of your first school?", "What is your mothers maiden name?", "Who was your first boyfriend/girlfriend?", 
		"What was the first computer game you purchased?", "Who is your favourite actor/actress?", "Who is your favourite author?", "Who is your favourite musician?", "Who is your favourite cartoon character?", "What is your favourite book?", "What is your favourite food?", "What is your favourite movie?"
	};
	private int anInt652;
	private int anInt653;
	private SpriteSurface surface;
	private String menuOptions[];
	private int anInt655;
	private boolean aBoolean656;
	private RsWorld world;
	private Model aModelArray657[];
	private Scene scene;
	private int anInt658;
	private int anInt659;
	private int anIntArray660[];
	private int teleportBubbleTime[];
	private int anInt662;
	private int anInt663;
	private int anIntArray664[];
	private int anIntArray665[];
	private int anIntArray666[];
	private int anIntArray667[];
	private int bankItemsMax;
	private int inventoryItemsIDs[];
	private int inventorySize;
	int anIntArray671[];
	private int anInt672;
	int anIntArray673[];
	private int anInt674;
	private int anInt675;
	private int anInt676;
	private RsCharacter aRsCharacterArray677[];
	private int anInt678;
	private int anIntArray679[] = {
		0, 1, 2, 1
	};
	private int anIntArray680[] = {
		0, 1, 2, 1, 0, 0, 0, 0
	};
	private int anInt681;
	private int anIntArray682[] = {
		0, 0, 0, 0, 0, 1, 2, 1
	};
	private int anIntArrayArray683[][] = {
		{
			11, 2, 9, 7, 1, 6, 10, 0, 5, 8, 
			3, 4
		}, {
			11, 2, 9, 7, 1, 6, 10, 0, 5, 8, 
			3, 4
		}, {
			11, 3, 2, 9, 7, 1, 6, 10, 0, 5, 
			8, 4
		}, {
			3, 4, 2, 9, 7, 1, 6, 10, 8, 11, 
			0, 5
		}, {
			3, 4, 2, 9, 7, 1, 6, 10, 8, 11, 
			0, 5
		}, {
			4, 3, 2, 9, 7, 1, 6, 10, 8, 11, 
			0, 5
		}, {
			11, 4, 2, 9, 7, 1, 6, 10, 0, 5, 
			8, 3
		}, {
			11, 2, 9, 7, 1, 6, 10, 0, 5, 8, 
			4, 3
		}
	};
	private int recievedMessageMidPoint[];
	private int anInt685;
	private int revievedMessageHeight[];
	private int receivedMessageX[];
	private int receivedMessageY[];
	String aStringArray689[];
	private int anIntArray690[];
	private int anInt691;
	private int anIntArray692[];
	private int anIntArray693[];
	private RsCharacter aRsCharacterArray694[];
	private final int anIntArray695[] = {
		0xecded0, 0xccb366, 0xb38c40, 0x997326, 0x906020
	};
	private final int anIntArray696[] = {
		0xffc030, 0xffa040, 0x805030, 0x604020, 0x303030, 0xff6020, 0xff4000, 0xffffff, 65280, 65535
	};
	private final int anIntArray697[] = {
		0xff0000, 0xff8000, 0xffe000, 0xa0e000, 57344, 32768, 41088, 45311, 33023, 12528, 
		0xe000e0, 0x303030, 0x604000, 0x805000, 0xffffff
	};
	private int anIntArray698[];
	private int anInt699;
	private int anIntArray700[];
	private int anIntArray701[];
	private int anIntArray702[];
	private boolean aBoolean703;
	private boolean aBoolean704;
	private boolean aBoolean705;
	private int loggedIn;
	private int anInt707;
	private int anInt708;
	private int cameraRotationXIncrement;
	private int anInt710;
	private int anInt711;
	private int anInt712;
	private int anInt713;
	private int anInt714;
	private int anInt715;
	private RsCharacter aRsCharacterArray716[];
	private RsCharacter aRsCharacterArray717[];
	private int anInt718;
	private int npcCount;
	private int anInt720;
	private int anInt721;
	private int anInt722;
	private int menuIdxs[];
	private int anInt724;
	private boolean aBoolean725;
	private int anInt726;
	private String aStringArray727[];
	private String aStringArray728[];
	private Panel aPanel729;
	private int anInt730;
	private int anInt731;
	private int anInt732;
	private int anInt733;
	private int anInt734;
	private int anInt735;
	private int anInt736;
	private int anInt737;
	private int anInt738;
	private int anInt739;
	private int anInt740;
	private int anInt741;
	private int anInt742;
	private int anInt743;
	private int anInt744;
	private int anInt745;
	private int anInt746;
	private int anInt747;
	private int anInt748;
	private int anInt749;
	private int anInt750;
	private boolean aBoolean751;
	int sceneX;
	int sceneY;
	private int anInt754;
	private int anInt755;
	private RsCharacter localPlayer;
	private int anIntArray757[];
	private int anIntArray758[];
	private int anInt759;
	private int anIntArray760[];
	private int anIntArray761[];
	private int anInt762;
	private int playerCount;
	int anInt764;
	int anInt765;
	@Export("gameState")
	private int loginState;
	private Panel aPanel767;
	private int anInt768;
	private int anInt769;
	private Panel aPanel770;
	private int anInt771;
	private int anInt772;
	private int anInt773;
	private Panel aPanel774;
	private int anInt775;
	private int anInt776;
	private int anInt777;
	private String aString778;
	private String aString779;
	private int showUiTab;
	private int inventoryMaxItemCount;
	private boolean aBoolean782;
	private SoundPlayer aSunAudioPlayer783;
	private boolean aBoolean784;
	private byte aByteArray785[];
	private int anInt786;
	private Model aModelArray787[];
	private boolean aBoolean788;
	private String aString789;
	private boolean aBoolean790;
	private int anInt791;
	private int anInt792;
	private boolean aBoolean793;
	private Panel aPanel794;
	private int inventoryItemsQuantities[];
	private int anIntArray796[];
	private int anIntArray797[];
	private int baseX;
	private int baseY;
	private int anInt800;
	int anInt801;
	int anInt802;
	private int anInt803;
	private int anInt804;
	private String aString805;
	private RsCharacter aRsCharacterArray806[];
	private RsCharacter aRsCharacterArray807[];
	private int anInt808;
	private Graphics aGraphics809;
	private boolean aBoolean810;
	private int anInt811;
	private boolean aBoolean812;
	private boolean aBoolean813;
	private boolean showDialogTradeConfirm;
	private boolean aBoolean815;
	private boolean aBoolean816;
	private boolean aBoolean817;
	private boolean aBoolean818;
	private int anInt819;
	private int anIntArray820[];
	private Model aModelArray821[];
	private int anIntArray822[];
	private int anIntArray823[];
	private int wallObjectDirection[];
	private int wallObjectID[];
	private int anInt826;
	private boolean aBooleanArray827[];
	private int anInt828;
	private int anInt829;
	private boolean aBooleanArray830[];
	private boolean aBooleanArray831[];
	private int selectedSpell;
	private int menuItemOpcodes[];
	private int menuItemX[];
	private int menuItemY[];
	private int menuItemIDs[];
	private int menuItemSourceIdxs[];
	private int selectedItemSlot;
	String selectedItemName;
	private boolean isMembers;
	private int anIntArray841[];
	private int anIntArray842[];
	private int anIntArray843[];
	private int menuItemTargerIdxs[];
	int anInt845;
	private int anInt846;
	private int anInt847;
	private int anInt848;
	private int anIntArray849[];
	private int anInt850;
	private int anInt851;
	private int anIntArray852[];
	private int anInt853;
	private int anIntArray854[];
	private int anInt855;
	private String aStringArray856[];
	private int anIntArray857[];
	int anInt858;
	int anInt859;
	int anInt860;
	private boolean aBoolean861;
	private int anInt862;
	long aLong863;
	private int anInt864;
	private int anInt865;
	int anInt866;
	private Panel aPanel867;
	int anInt868;
	private boolean aBoolean869;
	int anInt870;
	int localPlayerServerIdx;
	private int anIntArray872[];
	private int anIntArray873[];
	private int inventoryItemsEquipped[];
	private int anIntArray875[];
	private int anInt876;
	private boolean aBoolean877;
	private int anInt878;
	private int anInt879;
	private int anIntArray880[];
	private int anInt881;
	private int anIntArray882[];
	private int anInt883;
	private String aString884;
	private boolean aBoolean885;
	private boolean aBoolean886;
	private int anInt887;
	private int anInt888;
	private int anIntArray889[];
	private int anIntArray890[];
	private boolean aBooleanArray891[];
	private String aString892;
	private int anInt893;
	private int anInt894;
	private boolean aBoolean895;
	private boolean aBoolean896;
	private boolean aBoolean897;
	private boolean aBoolean898;
	private boolean aBoolean899;
	private boolean aBoolean900;
	private boolean tradeConfirmAccepted;
	private long aLong902;
	private int anInt903;
	private int anIntArray904[];
	private int anIntArray905[];
	private int anInt906;
	private int anIntArray907[];
	private int anIntArray908[];
	private int anIntArray909[];
	private int anIntArray910[];
	private boolean aBoolean911;
	private long aLong912;
	private int anInt913;
	private int anIntArray914[];
	private int anIntArray915[];
	private int anInt916;
	private int anIntArray917[];
	private int anIntArray918[];
	private int anInt919;
	private int anInt920;
	private int anInt921;
	private int anInt922;
	private int anInt923;
	private int anIntArray924[];
	private int anIntArray925[];
	private int anInt926;
	private int anInt927;
	private int anInt928;
	private int anInt929;
	private String aString930;
	private int anInt931;
	private int anInt932;
	private int anInt933;
	private String aString934;
	private int anInt935;
	private int anInt936;
	private int anInt937;
	private int anInt938;
	private int anInt939;
	private int anInt940;
	private int anInt941;
	private int anInt942;
	private int anInt943;
	private boolean aBoolean944;
	private boolean aBoolean945;
	private int anInt946;
	private int anInt947;
	private int anInt948;
	private int anInt949;
	private int anInt950;
	private int anInt951;
	private int anInt952;
	private boolean cameraAutoAngleDebug;
	private int anInt954;
	private int anInt955;
	private int anInt956;
	private String aString957;
	int anInt958;
	private Panel aPanel959;
	int anInt960;
	int anInt961;
	private final String aStringArray962[] = {
		"Attack", "Defense", "Strength", "Hits", "Ranged", "Prayer", "Magic", "Cooking", "Woodcut", "Fletching", 
		"Fishing", "Firemaking", "Crafting", "Smithing", "Mining", "Herblaw", "Agility", "Thieving"
	};
	private final String aStringArray963[] = {
		"Armour", "WeaponAim", "WeaponPower", "Magic", "Prayer"
	};
	private final String aStringArray964[] = {
		"Attack", "Defense", "Strength", "Hits", "Ranged", "Prayer", "Magic", "Cooking", "Woodcutting", "Fletching", 
		"Fishing", "Firemaking", "Crafting", "Smithing", "Mining", "Herblaw", "Agility", "Thieving"
	};
	private int anIntArray965[];
	private Panel aPanel966;
	int anInt967;
	private final String aStringArray968[] = {
		"Black knight's fortress", "Cook's assistant", "Demon slayer", "Doric's quest", "The restless ghost", "Goblin diplomacy", "Ernest the chicken", "Imp catcher", "Pirate's treasure", "Prince Ali rescue", 
		"Romeo & Juliet", "Sheep shearer", "Shield of Arrav", "The knight's sword", "Vampire slayer", "Witch's potion", "Dragon slayer", "Witch's house (members)", "Lost city (members)", "Hero's quest (members)", 
		"Druidic ritual (members)", "Merlin's crystal (members)", "Scorpion catcher (members)", "Family crest (members)", "Tribal totem (members)", "Fishing contest (members)", "Monk's friend (members)", "Temple of Ikov (members)", "Clock tower (members)", "The Holy Grail (members)", 
		"Fight Arena (members)", "Tree Gnome Village (members)", "The Hazeel Cult (members)", "Sheep Herder (members)", "Plague City (members)", "Sea Slug (members)", "Waterfall quest (members)", "Biohazard (members)", "Jungle potion (members)", "Grand tree (members)", 
		"Shilo village (members)", "Underground pass (members)", "Observatory quest (members)", "Tourist trap (members)", "Watchtower (members)", "Dwarf Cannon (members)", "Murder Mystery (members)", "Digsite (members)", "Gertrude's Cat (members)", "Legend's Quest (members)"
	};
	private int anInt969;
	private int anInt970;
	private int anIntArray971[];
	private int anIntArray972[];
	private int anInt973;
	private int anIntArray974[];
	private int anIntArray975[];
	private int anInt976;
	private int anInt977;
	private int anInt978;
	private boolean aBoolean979;
	private int anInt980;
}
