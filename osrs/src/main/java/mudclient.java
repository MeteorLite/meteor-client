// Decompiled by Jad v1.5.8c. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

import events.UpdateInventoryPacket;
import net.runelite.api.Constants;
import net.runelite.mapping.Implements;
import org.rationalityfrontline.kevent.Event;
import org.rationalityfrontline.kevent.KEventKt;

import java.awt.*;
import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.HashMap;

@Implements("RSClient")
public final class mudclient extends NetworkedGame {

	//This will be modified via mixins if we are running injected
	public static boolean injected = false;
	//Used so we can modify hitsplat easily
	boolean drawHitsplatsAboveScene = false;

	private void method45() {
		if((cameraAngle & 1) == 1 && isValidCameraAngle(cameraAngle))
			return;
		if((cameraAngle & 1) == 0 && isValidCameraAngle(cameraAngle)) {
			if(isValidCameraAngle(cameraAngle + 1 & 7)) {
				cameraAngle = cameraAngle + 1 & 7;
				return;
			}
			if(isValidCameraAngle(cameraAngle + 7 & 7))
				cameraAngle = cameraAngle + 7 & 7;
			return;
		}
		int[] ai = {
			1, -1, 2, -2, 3, -3, 4
		};
		for(int i = 0; i < 7; i++) {
			if(!isValidCameraAngle(cameraAngle + ai[i] + 8 & 7))
				continue;
			cameraAngle = cameraAngle + ai[i] + 8 & 7;
			break;
		}

		if((cameraAngle & 1) == 0 && isValidCameraAngle(cameraAngle)) {
			if(isValidCameraAngle(cameraAngle + 1 & 7)) {
				cameraAngle = cameraAngle + 1 & 7;
				return;
			}
			if(isValidCameraAngle(cameraAngle + 7 & 7))
				cameraAngle = cameraAngle + 7 & 7;
        } else {
        }
	}

	private void chooseOption(int optionIdx) {
		super.packetStream.createPacket(116);
		super.packetStream.putByte(optionIdx);
		super.packetStream.endPacket();
	}


	private void method46() {
		if(mouseButtonClick != 0) {
			for(int i = 0; i < optionMenuCount; i++) {
				if(super.mouseX >= surface.textWidth(menuOptions[i], 1) || super.mouseY <= i * 12 || super.mouseY >= 12 + i * 12)
					continue;
				chooseOption(i);
				break;
			}

			mouseButtonClick = 0;
			showOptionMenu = false;
			return;
		}
		for(int j = 0; j < optionMenuCount; j++) {
			int k = 65535;
			if(super.mouseX < surface.textWidth(menuOptions[j], 1) && super.mouseY > j * 12 && super.mouseY < 12 + j * 12)
				k = 0xff0000;
			surface.drawString(menuOptions[j], 6, 12 + j * 12, 1, k);
		}

	}

	private void method47() {
		int i = 0;
		byte byte0 = 50;
		byte byte1 = 50;
		world.method399(byte0 * 48 + 23, byte1 * 48 + 23, i);
		world.method402(gameModels);
		char c = '\u2600';
		char c1 = '\u1900';
		char c2 = '\u044C';
		char c3 = '\u0378';
		scene.clipFar3d = 4100;
		scene.clipFar2d = 4100;
		scene.fogZFalloff = 1;
		scene.fogZDistance = 4000;
		scene.setCamera(c, -world.method410(c, c1), c1, 912, c3, 0, c2 * 2);
		scene.render();
		surface.fadeToBlack();
		surface.fadeToBlack();
		surface.method207(0, 0, 512, 6, 0);
		for(int j = 6; j >= 1; j--)
			surface.method225(0, j, 0, j, 512, 8);

		surface.method207(0, 194, 512, 20, 0);
		for(int k = 6; k >= 1; k--)
			surface.method225(0, k, 0, 194 - k, 512, 8);

		surface.drawSprite(15, 15, spriteMedia + 10);
		surface.method252(spriteLogo, 0, 0, 512, 200);
		surface.method235(spriteLogo);
		c = '\u2400';
		c1 = '\u2400';
		c2 = '\u044C';
		c3 = '\u0378';
		scene.clipFar3d = 4100;
		scene.clipFar2d = 4100;
		scene.fogZFalloff = 1;
		scene.fogZDistance = 4000;
		scene.setCamera(c, -world.method410(c, c1), c1, 912, c3, 0, c2 * 2);
		scene.render();
		surface.fadeToBlack();
		surface.fadeToBlack();
		surface.method207(0, 0, 512, 6, 0);
		for(int l = 6; l >= 1; l--)
			surface.method225(0, l, 0, l, 512, 8);

		surface.method207(0, 194, 512, 20, 0);
		for(int i1 = 6; i1 >= 1; i1--)
			surface.method225(0, i1, 0, 194 - i1, 512, 8);

		surface.drawSprite(15, 15, spriteMedia + 10);
		surface.method252(spriteLogo + 1, 0, 0, 512, 200);
		surface.method235(spriteLogo + 1);
		for(int j1 = 0; j1 < 64; j1++) {
			scene.removeModel(world.roofModels[0][j1]);
			scene.removeModel(world.aModelArrayArray597[1][j1]);
			scene.removeModel(world.roofModels[1][j1]);
			scene.removeModel(world.aModelArrayArray597[2][j1]);
			scene.removeModel(world.roofModels[2][j1]);
		}

		c = '\u2B80';
		c1 = '\u2880';
		c2 = '\u01F4';
		c3 = '\u0178';
		scene.clipFar3d = 4100;
		scene.clipFar2d = 4100;
		scene.fogZFalloff = 1;
		scene.fogZDistance = 4000;
		scene.setCamera(c, -world.method410(c, c1), c1, 912, c3, 0, c2 * 2);
		scene.render();
		surface.fadeToBlack();
		surface.fadeToBlack();
		surface.method207(0, 0, 512, 6, 0);
		for(int k1 = 6; k1 >= 1; k1--)
			surface.method225(0, k1, 0, k1, 512, 8);

		surface.method207(0, 194, 512, 20, 0);
		for(int l1 = 6; l1 >= 1; l1--)
			surface.method225(0, l1, 0, 194, 512, 8);

		surface.drawSprite(15, 15, spriteMedia + 10);
		surface.method252(spriteMedia + 10, 0, 0, 512, 200);
		surface.method235(spriteMedia + 10);
	}

	void drawTeleportBubble(int i, int j, int k, int l, int i1, int j1, int k1) {
		int l1 = teleportBubbleType[i1];
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

	private void method49() {
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

	protected void method6(int i, int j, int k) {
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
					if(j1 == l - 1 && flag && combatTimeout == 0 && logoutTimeout == 0) {
						logout();
						return;
					}
				}

			}
		}

	}

	private Model createModel(int i, int j, int k, int l, int i1) {
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
		j1 *= magicLoc;
		k1 *= magicLoc;
		l1 *= magicLoc;
		i2 *= magicLoc;
		int i3 = model.method198(j1, -world.method410(j1, k1), k1);
		int j3 = model.method198(j1, -world.method410(j1, k1) - l2, k1);
		int k3 = model.method198(l1, -world.method410(l1, i2) - l2, i2);
		int l3 = model.method198(l1, -world.method410(l1, i2), i2);
		int[] ai = {
			i3, j3, k3, l3
		};
		model.createFace(4, ai, j2, k2);
		model.setLight(false, 60, 24, -50, -10, -50);
		if(i >= 0 && j >= 0 && i < 96 && j < 96)
			scene.addModel(model);
		model.key = i1 + 10000;
		return model;
	}

	void drawNPC(int x, int y, int width, int height, int i1, int j1, int k1) {
		Character rscharacter = npcs[i1];
		int l1 = rscharacter.animation + (cameraRotation + 16) / 32 & 7;
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
		int j2 = i2 * 3 + anIntArray679[(rscharacter.stepCount / Definitions.anIntArray91[rscharacter.npcID]) % 4];
		if(rscharacter.animation == 8) {
			i2 = 5;
			l1 = 2;
			flag = false;
			x -= (Definitions.anIntArray93[rscharacter.npcID] * k1) / 100;
			j2 = i2 * 3 + anIntArray680[(cycle / (Definitions.anIntArray92[rscharacter.npcID] - 1)) % 8];
		} else
		if(rscharacter.animation == 9) {
			i2 = 5;
			l1 = 2;
			flag = true;
			x += (Definitions.anIntArray93[rscharacter.npcID] * k1) / 100;
			j2 = i2 * 3 + anIntArray682[(cycle / Definitions.anIntArray92[rscharacter.npcID]) % 8];
		}
		for(int k2 = 0; k2 < 12; k2++) {
			int l2 = anIntArrayArray683[l1][k2];
			int k3 = Definitions.anIntArrayArray84[rscharacter.npcID][l2];
			if(k3 >= 0) {
				int i4 = 0;
				int j4 = 0;
				int k4 = j2;
				if(flag && i2 >= 1 && i2 <= 3 && Definitions.anIntArray102[k3] == 1)
					k4 += 15;
				if(i2 != 5 || Definitions.anIntArray101[k3] == 1) {
					int l4 = k4 + Definitions.anIntArray103[k3];
					i4 = (i4 * width) / surface.anIntArray331[l4];
					j4 = (j4 * height) / surface.anIntArray332[l4];
					int i5 = (width * surface.anIntArray331[l4]) / surface.anIntArray331[Definitions.anIntArray103[k3]];
					i4 -= (i5 - width) / 2;
					int j5 = Definitions.anIntArray99[k3];
					int k5 = 0;
					if(j5 == 1) {
						j5 = Definitions.anIntArray85[rscharacter.npcID];
						k5 = Definitions.anIntArray88[rscharacter.npcID];
					} else
					if(j5 == 2) {
						j5 = Definitions.anIntArray86[rscharacter.npcID];
						k5 = Definitions.anIntArray88[rscharacter.npcID];
					} else
					if(j5 == 3) {
						j5 = Definitions.anIntArray87[rscharacter.npcID];
						k5 = Definitions.anIntArray88[rscharacter.npcID];
					}
					surface.spriteClipping(x + i4, y + j4, i5, height, l4, j5, k5, j1, flag);
				}
			}
		}

		if(rscharacter.messageTimeout > 0) {
			recievedMessageMidPoint[anInt685] = surface.textWidth(rscharacter.message, 1) / 2;
			if(recievedMessageMidPoint[anInt685] > 150)
				recievedMessageMidPoint[anInt685] = 150;
			revievedMessageHeight[anInt685] = (surface.textWidth(rscharacter.message, 1) / 300) * surface.method238(1);
			receivedMessageX[anInt685] = x + width / 2;
			receivedMessageY[anInt685] = y;
			aStringArray689[anInt685++] = rscharacter.message;
		}
		if(rscharacter.animation == 8 || rscharacter.animation == 9 || rscharacter.combatTimer != 0) {
			if(rscharacter.combatTimer > 0) {
				int i3 = x;
				if(rscharacter.animation == 8)
					i3 -= (20 * k1) / 100;
				else
				if(rscharacter.animation == 9)
					i3 += (20 * k1) / 100;
				int l3 = (rscharacter.currentHealth * 30) / rscharacter.maxHealth;
				anIntArray690[anInt691] = i3 + width / 2;
				anIntArray692[anInt691] = y;
				anIntArray693[anInt691++] = l3;
			}
			if(rscharacter.combatTimer > 150) {
				int x1 = x;
				if(rscharacter.animation == 8)
					x1 -= (10 * k1) / 100;
				else
				if(rscharacter.animation == 9)
					x1 += (10 * k1) / 100;

				//draw hitsplat. in meteor, we do this after scene so it's not hidden by models
				rscharacter.screenCenterX = x1 + (width / 2);
				rscharacter.screenCenterY = y + (height / 2);

				if (!drawHitsplatsAboveScene) {
					surface.drawSprite(rscharacter.screenCenterX - 12, rscharacter.screenCenterY - 12, spriteMedia + 12);
					surface.drawStringCenter(String.valueOf(rscharacter.damageTaken), rscharacter.screenCenterX - 1, rscharacter.screenCenterY + 5, 3, 0xffffff);
				}
			}
		}
	}

	void drawPlayer(int x, int y, int width, int height, int idx, int j1, int k1) {
		Character rscharacter = players[idx];
		if(rscharacter.bottomColor == 255)
			return;
		int l1 = rscharacter.animation + (cameraRotation + 16) / 32 & 7;
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
		int j2 = i2 * 3 + anIntArray679[(rscharacter.stepCount / 6) % 4];
		if(rscharacter.animation == 8) {
			i2 = 5;
			l1 = 2;
			flag = false;
			x -= (5 * k1) / 100;
			j2 = i2 * 3 + anIntArray680[(cycle / 5) % 8];
		} else
		if(rscharacter.animation == 9) {
			i2 = 5;
			l1 = 2;
			flag = true;
			x += (5 * k1) / 100;
			j2 = i2 * 3 + anIntArray682[(cycle / 6) % 8];
		}
		for(int k2 = 0; k2 < 12; k2++) {
			int l2 = anIntArrayArray683[l1][k2];
			int l3 = rscharacter.equipment[l2] - 1;
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
						j5 = i2 * 3 + anIntArray679[(2 + rscharacter.stepCount / 6) % 4];
					} else
					if(l2 == 4 && i2 == 2) {
						k4 = 0;
						i5 = -8;
						j5 = i2 * 3 + anIntArray679[(2 + rscharacter.stepCount / 6) % 4];
					} else
					if(l2 == 4 && i2 == 3) {
						k4 = 26;
						i5 = -5;
						j5 = i2 * 3 + anIntArray679[(2 + rscharacter.stepCount / 6) % 4];
					} else
					if(l2 == 3 && i2 == 1) {
						k4 = 22;
						i5 = 3;
						j5 = i2 * 3 + anIntArray679[(2 + rscharacter.stepCount / 6) % 4];
					} else
					if(l2 == 3 && i2 == 2) {
						k4 = 0;
						i5 = 8;
						j5 = i2 * 3 + anIntArray679[(2 + rscharacter.stepCount / 6) % 4];
					} else
					if(l2 == 3 && i2 == 3) {
						k4 = -26;
						i5 = 5;
						j5 = i2 * 3 + anIntArray679[(2 + rscharacter.stepCount / 6) % 4];
					}
				if(i2 != 5 || Definitions.anIntArray101[l3] == 1) {
					int k5 = j5 + Definitions.anIntArray103[l3];
					k4 = (k4 * width) / surface.anIntArray331[k5];
					i5 = (i5 * height) / surface.anIntArray332[k5];
					int l5 = (width * surface.anIntArray331[k5]) / surface.anIntArray331[Definitions.anIntArray103[l3]];
					k4 -= (l5 - width) / 2;
					int i6 = Definitions.anIntArray99[l3];
					int j6 = anIntArray695[rscharacter.skinColor];
					if(i6 == 1)
						i6 = anIntArray696[rscharacter.hairColor];
					else
					if(i6 == 2)
						i6 = anIntArray697[rscharacter.topColor];
					else
					if(i6 == 3)
						i6 = anIntArray697[rscharacter.bottomColor];
					surface.spriteClipping(x + k4, y + i5, l5, height, k5, i6, j6, j1, flag);
				}
			}
		}

		if(rscharacter.messageTimeout > 0) {
			recievedMessageMidPoint[anInt685] = surface.textWidth(rscharacter.message, 1) / 2;
			if(recievedMessageMidPoint[anInt685] > 150)
				recievedMessageMidPoint[anInt685] = 150;
			revievedMessageHeight[anInt685] = (surface.textWidth(rscharacter.message, 1) / 300) * surface.method238(1);
			receivedMessageX[anInt685] = x + width / 2;
			receivedMessageY[anInt685] = y;
			aStringArray689[anInt685++] = rscharacter.message;
		}
		if(rscharacter.bubbleTimeout > 0) {
			anIntArray698[anInt699] = x + width / 2;
			anIntArray700[anInt699] = y;
			anIntArray701[anInt699] = k1;
			anIntArray702[anInt699++] = rscharacter.bubbleItem;
		}
		if(rscharacter.animation == 8 || rscharacter.animation == 9 || rscharacter.combatTimer != 0) {
			if(rscharacter.combatTimer > 0) {
				int i3 = x;
				if(rscharacter.animation == 8)
					i3 -= (20 * k1) / 100;
				else
				if(rscharacter.animation == 9)
					i3 += (20 * k1) / 100;
				int i4 = (rscharacter.currentHealth * 30) / rscharacter.maxHealth;
				anIntArray690[anInt691] = i3 + width / 2;
				anIntArray692[anInt691] = y;
				anIntArray693[anInt691++] = i4;
			}
			if(rscharacter.combatTimer > 150) {
				int j3 = x;
				if(rscharacter.animation == 8)
					j3 -= (10 * k1) / 100;
				else
				if(rscharacter.animation == 9)
					j3 += (10 * k1) / 100;
				//draw hitsplat. in meteor, we do this after scene so it's not hidden by models
				rscharacter.screenCenterX = j3 + width / 2;
				rscharacter.screenCenterY = y + height / 2;

				if (!drawHitsplatsAboveScene) {
					surface.drawSprite(rscharacter.screenCenterX - 12, rscharacter.screenCenterY - 12, spriteMedia + 11);
					surface.drawStringCenter(String.valueOf(rscharacter.damageTaken), rscharacter.screenCenterX - 1, rscharacter.screenCenterY + 5, 3, 0xffffff);
				}
			}
		}

		if(rscharacter.skullVisible == 1 && rscharacter.bubbleTimeout == 0) {
			int k3 = j1 + x + width / 2;
			if(rscharacter.animation == 8)
				k3 -= (20 * k1) / 100;
			else
			if(rscharacter.animation == 9)
				k3 += (20 * k1) / 100;
			int j4 = (16 * k1) / 100;
			int l4 = (16 * k1) / 100;
			surface.spriteClipping(k3 - j4 / 2, y - l4 / 2 - (10 * k1) / 100, j4, l4, spriteMedia + 13);
		}
	}

	protected void doCycle() {
		if(errorLoadingCodebase)
			return;
		if(errorLoadingMemory)
			return;
		if(errorLoadingData)
			return;
		try {
			cycle++;
			if(loggedIn == 0) {
				super.mouseIdleCycles = 0;
				doCycleLoggedOut();
			}
			if(loggedIn == 1) {
				super.mouseIdleCycles++;
				doCycleLoggedIn();
			}
			super.lastMouseButtonDown = 0;
			super.anInt24 = 0;
			cameraRotationTime++;
			if(cameraRotationTime > 500) {
				cameraRotationTime = 0;
				int i = (int)(Math.random() * 4D);
				if((i & 1) == 1)
					cameraRotationX += cameraRotationXIncrement;
				if((i & 2) == 2)
					cameraRotationY += cameraRotationYIncrement;
			}
			if(cameraRotationX < -50)
				cameraRotationXIncrement = 2;
			if(cameraRotationX > 50)
				cameraRotationXIncrement = -2;
			if(cameraRotationY < -50)
				cameraRotationYIncrement = 2;
			if(cameraRotationY > 50)
				cameraRotationYIncrement = -2;
			if(messageTabFlashAll > 0)
				messageTabFlashAll--;
			if(messageTabFlashHistory > 0)
				messageTabFlashHistory--;
			if(messtageTabFlashQuest > 0)
				messtageTabFlashQuest--;
			if(messageTabFlashPrivate > 0) {
				messageTabFlashPrivate--;
            }
		}
		catch(OutOfMemoryError _ex) {
			disposeAndCollect();
			errorLoadingMemory = true;
		}
	}

	private Character method53(int i, int j, int k, int l, int i1) {
		if(aCharacterArray716[i] == null) {
			aCharacterArray716[i] = new Character();
			aCharacterArray716[i].serverIndex = i;
		}
		Character rscharacter = aCharacterArray716[i];
		boolean flag = false;
		for(int j1 = 0; j1 < anInt718; j1++) {
			if(aCharacterArray717[j1].serverIndex != i)
				continue;
			flag = true;
			break;
		}

		if(flag) {
			rscharacter.npcID = i1;
			rscharacter.nextAnimation = l;
			int k1 = rscharacter.waypointCurrent;
			if(j != rscharacter.waypointsX[k1] || k != rscharacter.waypointsY[k1]) {
				rscharacter.waypointCurrent = k1 = (k1 + 1) % 10;
				rscharacter.waypointsX[k1] = j;
				rscharacter.waypointsY[k1] = k;
			}
		} else {
			rscharacter.serverIndex = i;
			rscharacter.movingStep = 0;
			rscharacter.waypointCurrent = 0;
			rscharacter.waypointsX[0] = rscharacter.currentX = j;
			rscharacter.waypointsY[0] = rscharacter.currentY = k;
			rscharacter.npcID = i1;
			rscharacter.nextAnimation = rscharacter.animation = l;
			rscharacter.stepCount = 0;
		}
		npcs[npcCount++] = rscharacter;
		return rscharacter;
	}

	private void drawRightClickMenu() {
		if(mouseButtonClick != 0) {
			for(int i = 0; i < menuItemsCount; i++) {
				int k = anInt720 + 2;
				int i1 = anInt721 + 27 + i * 15;
				if(super.mouseX <= k - 2 || super.mouseY <= i1 - 12 || super.mouseY >= i1 + 4 || super.mouseX >= (k - 3) + anInt722)
					continue;
				menuAction(menuIdxs[i]);
				break;
			}

			mouseButtonClick = 0;
			showRightClickMenu = false;
			return;
		}
		if(super.mouseX < anInt720 - 10 || super.mouseY < anInt721 - 10 || super.mouseX > anInt720 + anInt722 + 10 || super.mouseY > anInt721 + anInt726 + 10) {
			showRightClickMenu = false;
			return;
		}
		surface.method224(anInt720, anInt721, anInt722, anInt726, 0xd0d0d0, 160);
		surface.drawString("Choose option", anInt720 + 2, anInt721 + 12, 1, 65535);
		for(int j = 0; j < menuItemsCount; j++) {
			int l = anInt720 + 2;
			int j1 = anInt721 + 27 + j * 15;
			int k1 = 0xffffff;
			if(super.mouseX > l - 2 && super.mouseY > j1 - 12 && super.mouseY < j1 + 4 && super.mouseX < (l - 3) + anInt722)
				k1 = 0xffff00;
			surface.drawString(aStringArray727[menuIdxs[j]] + " " + aStringArray728[menuIdxs[j]], l, j1, 1, k1);
		}

	}

	private static String method55(int i) {
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

	private void processChangeAppearance() {
		aPanel729.handleMouse(super.mouseX, super.mouseY, super.lastMouseButtonDown, super.mouseButtonDown);
		if(aPanel729.isClicked(anInt730))
			do
				anInt731 = ((anInt731 - 1) + Definitions.anInt97) % Definitions.anInt97;
			while((Definitions.anIntArray100[anInt731] & 3) != 1 || (Definitions.anIntArray100[anInt731] & 4 * anInt732) == 0);
		if(aPanel729.isClicked(anInt733))
			do
				anInt731 = (anInt731 + 1) % Definitions.anInt97;
			while((Definitions.anIntArray100[anInt731] & 3) != 1 || (Definitions.anIntArray100[anInt731] & 4 * anInt732) == 0);
		if(aPanel729.isClicked(anInt734))
			anInt735 = ((anInt735 - 1) + anIntArray696.length) % anIntArray696.length;
		if(aPanel729.isClicked(anInt736))
			anInt735 = (anInt735 + 1) % anIntArray696.length;
		if(aPanel729.isClicked(anInt737) || aPanel729.isClicked(anInt738)) {
			for(anInt732 = 3 - anInt732; (Definitions.anIntArray100[anInt731] & 3) != 1 || (Definitions.anIntArray100[anInt731] & 4 * anInt732) == 0; anInt731 = (anInt731 + 1) % Definitions.anInt97);
			for(; (Definitions.anIntArray100[anInt739] & 3) != 2 || (Definitions.anIntArray100[anInt739] & 4 * anInt732) == 0; anInt739 = (anInt739 + 1) % Definitions.anInt97);
		}
		if(aPanel729.isClicked(anInt740))
			anInt741 = ((anInt741 - 1) + anIntArray697.length) % anIntArray697.length;
		if(aPanel729.isClicked(anInt742))
			anInt741 = (anInt741 + 1) % anIntArray697.length;
		if(aPanel729.isClicked(anInt743))
			anInt744 = ((anInt744 - 1) + anIntArray695.length) % anIntArray695.length;
		if(aPanel729.isClicked(anInt745))
			anInt744 = (anInt744 + 1) % anIntArray695.length;
		if(aPanel729.isClicked(anInt746))
			anInt747 = ((anInt747 - 1) + anIntArray697.length) % anIntArray697.length;
		if(aPanel729.isClicked(anInt748))
			anInt747 = (anInt747 + 1) % anIntArray697.length;
		if(aPanel729.isClicked(anInt749)) {
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
			changeAppearanceVisible = false;
		}
	}

	private void method57(int i, int j, int k) {
		surface.method247(i, j, k);
		surface.method247(i - 1, j, k);
		surface.method247(i + 1, j, k);
		surface.method247(i, j - 1, k);
		surface.method247(i, j + 1, k);
	}

	private void method58(int i, int j, int k) {
		if(k == 0) {
			method69(sceneX, sceneY, i, j - 1, i, j, false, true);
			return;
		}
		if(k == 1) {
			method69(sceneX, sceneY, i - 1, j, i, j, false, true);
        } else {
			method69(sceneX, sceneY, i, j, i, j, true, true);
        }
	}

	private void method59(int i, int j, int k, int l) {
		int i1;
		int j1;
		if(k == 0 || k == 4) {
			i1 = Definitions.objectWidth[l];
			j1 = Definitions.objectHeight[l];
		} else {
			j1 = Definitions.objectWidth[l];
			i1 = Definitions.objectHeight[l];
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
        } else {
			method69(sceneX, sceneY, i, j, (i + i1) - 1, (j + j1) - 1, true, true);
        }
	}

	private void drawUiTabMinimap(boolean flag) {
		int i = surface.width2 - 199;
		char c = '\234';
		char c2 = '\230';
		surface.drawSprite(i - 49, 3, spriteMedia + 2);
		i += 40;
		surface.method207(i, 36, c, c2, 0);
		surface.resize(i, 36, i + c, 36 + c2);
		int k = 192 + anInt754;
		int i1 = cameraRotation + anInt755 & 0xff;
		int k1 = ((localPlayer.currentX - 6040) * 3 * k) / 2048;
		int i3 = ((localPlayer.currentY - 6040) * 3 * k) / 2048;
		int k4 = Scene.sin2048Cache[1024 - i1 * 4 & 0x3ff];
		int i5 = Scene.sin2048Cache[(1024 - i1 * 4 & 0x3ff) + 1024];
		int k5 = i3 * k4 + k1 * i5 >> 18;
		i3 = i3 * i5 - k1 * k4 >> 18;
		k1 = k5;
		surface.method236((i + c / 2) - k1, 36 + c2 / 2 + i3, spriteMedia - 1, i1 + 64 & 0xff, k);
		for(int i7 = 0; i7 < objectCount; i7++) {
			int l1 = (((objectX[i7] * magicLoc + 64) - localPlayer.currentX) * 3 * k) / 2048;
			int j3 = (((objectY[i7] * magicLoc + 64) - localPlayer.currentY) * 3 * k) / 2048;
			int l5 = j3 * k4 + l1 * i5 >> 18;
			j3 = j3 * i5 - l1 * k4 >> 18;
			l1 = l5;
			method57(i + c / 2 + l1, (36 + c2 / 2) - j3, 65535);
		}

		for(int j7 = 0; j7 < anInt762; j7++) {
			int i2 = (((anIntArray760[j7] * magicLoc + 64) - localPlayer.currentX) * 3 * k) / 2048;
			int k3 = (((anIntArray761[j7] * magicLoc + 64) - localPlayer.currentY) * 3 * k) / 2048;
			int i6 = k3 * k4 + i2 * i5 >> 18;
			k3 = k3 * i5 - i2 * k4 >> 18;
			i2 = i6;
			method57(i + c / 2 + i2, (36 + c2 / 2) - k3, 0xff0000);
		}

		for(int k7 = 0; k7 < npcCount; k7++) {
			Character rscharacter = npcs[k7];
			int j2 = ((rscharacter.currentX - localPlayer.currentX) * 3 * k) / 2048;
			int l3 = ((rscharacter.currentY - localPlayer.currentY) * 3 * k) / 2048;
			int j6 = l3 * k4 + j2 * i5 >> 18;
			l3 = l3 * i5 - j2 * k4 >> 18;
			j2 = j6;
			method57(i + c / 2 + j2, (36 + c2 / 2) - l3, 0xffff00);
		}

		for(int l7 = 0; l7 < playerCount; l7++) {
			Character rscharacter1 = players[l7];
			int k2 = ((rscharacter1.currentX - localPlayer.currentX) * 3 * k) / 2048;
			int i4 = ((rscharacter1.currentY - localPlayer.currentY) * 3 * k) / 2048;
			int k6 = i4 * k4 + k2 * i5 >> 18;
			i4 = i4 * i5 - k2 * k4 >> 18;
			k2 = k6;
			int j8 = 0xffffff;
			for(int k8 = 0; k8 < super.anInt603; k8++) {
				if(rscharacter1.hash != super.friendListHashes[k8] || super.friendListOnline[k8] != 255)
					continue;
				j8 = 65280;
				break;
			}

			method57(i + c / 2 + k2, (36 + c2 / 2) - i4, j8);
		}

		surface.method258(i + c / 2, 36 + c2 / 2, 2, 0xffffff, 255);
		surface.method236(i + 19, 55, spriteMedia + 24, cameraRotation + 128 & 0xff, 128);
		surface.resize(0, 0, gameWidth, gameHeight + 12);
		if(!flag)
			return;
		i = super.mouseX - (surface.width2 - 199);
		int i8 = super.mouseY - 36;
		if(i >= 40 && i8 >= 0 && i < 196 && i8 < 152) {
			char c1 = '\234';
			char c3 = '\230';
			int l = 192 + anInt754;
			int j1 = cameraRotation + anInt755 & 0xff;
			int j = surface.width2 - 199;
			j += 40;
			int l2 = ((super.mouseX - (j + c1 / 2)) * 16384) / (3 * l);
			int j4 = ((super.mouseY - (36 + c3 / 2)) * 16384) / (3 * l);
			int l4 = Scene.sin2048Cache[1024 - j1 * 4 & 0x3ff];
			int j5 = Scene.sin2048Cache[(1024 - j1 * 4 & 0x3ff) + 1024];
			int l6 = j4 * l4 + l2 * j5 >> 15;
			j4 = j4 * j5 - l2 * l4 >> 15;
			l2 = l6;
			l2 += localPlayer.currentX;
			j4 = localPlayer.currentY - j4;
			if(mouseButtonClick == 1)
				method106(sceneX, sceneY, l2 / 128, j4 / 128, false);
			mouseButtonClick = 0;
		}
	}

	private void doCycleLoggedOut() {
		if(super.anInt618 > 0)
			super.anInt618--;
		if(loginState == 0) {
			aPanel767.handleMouse(super.mouseX, super.mouseY, super.lastMouseButtonDown, super.mouseButtonDown);
			if(aPanel767.isClicked(anInt768))
				loginState = 1;
			if(aPanel767.isClicked(anInt769)) {
				loginState = 2;
				aPanel770.updateText(anInt771, "Please enter your username and password");
				aPanel770.updateText(anInt772, "");
				aPanel770.updateText(anInt773, "");
				aPanel770.setFocus(anInt772);
            }
		} else
		if(loginState == 1) {
			aPanel774.handleMouse(super.mouseX, super.mouseY, super.lastMouseButtonDown, super.mouseButtonDown);
			if(aPanel774.isClicked(anInt775)) {
				loginState = 0;
            }
		} else
		if(loginState == 2) {
			aPanel770.handleMouse(super.mouseX, super.mouseY, super.lastMouseButtonDown, super.mouseButtonDown);
			if(aPanel770.isClicked(anInt776))
				loginState = 0;
			if(aPanel770.isClicked(anInt772))
				aPanel770.setFocus(anInt773);
			if(aPanel770.isClicked(anInt773) || aPanel770.isClicked(anInt777)) {
				loginUsername = aPanel770.getText(anInt772);
				aString779 = aPanel770.getText(anInt773);
				method39(loginUsername, aString779, false);
			}
		}
	}

	private void setActiveUiTab() {
		if(showUiTab == 0 && super.mouseX >= surface.width2 - 35 && super.mouseY >= 3 && super.mouseX < surface.width2 - 3 && super.mouseY < 35)
			showUiTab = 1;
		if(showUiTab == 0 && super.mouseX >= surface.width2 - 35 - 33 && super.mouseY >= 3 && super.mouseX < surface.width2 - 3 - 33 && super.mouseY < 35) {
			showUiTab = 2;
			anInt755 = (int)(Math.random() * 13D) - 6;
			anInt754 = (int)(Math.random() * 23D) - 11;
		}
		if(showUiTab == 0 && super.mouseX >= surface.width2 - 35 - 66 && super.mouseY >= 3 && super.mouseX < surface.width2 - 3 - 66 && super.mouseY < 35)
			showUiTab = 3;
		if(showUiTab == 0 && super.mouseX >= surface.width2 - 35 - 99 && super.mouseY >= 3 && super.mouseX < surface.width2 - 3 - 99 && super.mouseY < 35)
			showUiTab = 4;
		if(showUiTab == 0 && super.mouseX >= surface.width2 - 35 - 132 && super.mouseY >= 3 && super.mouseX < surface.width2 - 3 - 132 && super.mouseY < 35)
			showUiTab = 5;
		if(showUiTab == 0 && super.mouseX >= surface.width2 - 35 - 165 && super.mouseY >= 3 && super.mouseX < surface.width2 - 3 - 165 && super.mouseY < 35)
			showUiTab = 6;
		if(showUiTab != 0 && super.mouseX >= surface.width2 - 35 && super.mouseY >= 3 && super.mouseX < surface.width2 - 3 && super.mouseY < 26)
			showUiTab = 1;
		if(showUiTab != 0 && showUiTab != 2 && super.mouseX >= surface.width2 - 35 - 33 && super.mouseY >= 3 && super.mouseX < surface.width2 - 3 - 33 && super.mouseY < 26) {
			showUiTab = 2;
			anInt755 = (int)(Math.random() * 13D) - 6;
			anInt754 = (int)(Math.random() * 23D) - 11;
		}
		if(showUiTab != 0 && super.mouseX >= surface.width2 - 35 - 66 && super.mouseY >= 3 && super.mouseX < surface.width2 - 3 - 66 && super.mouseY < 26)
			showUiTab = 3;
		if(showUiTab != 0 && super.mouseX >= surface.width2 - 35 - 99 && super.mouseY >= 3 && super.mouseX < surface.width2 - 3 - 99 && super.mouseY < 26)
			showUiTab = 4;
		if(showUiTab != 0 && super.mouseX >= surface.width2 - 35 - 132 && super.mouseY >= 3 && super.mouseX < surface.width2 - 3 - 132 && super.mouseY < 26)
			showUiTab = 5;
		if(showUiTab != 0 && super.mouseX >= surface.width2 - 35 - 165 && super.mouseY >= 3 && super.mouseX < surface.width2 - 3 - 165 && super.mouseY < 26)
			showUiTab = 6;
		if(showUiTab == 1 && (super.mouseX < surface.width2 - 248 || super.mouseY > 36 + (inventoryMaxItemCount / 5) * 34))
			showUiTab = 0;
		if(showUiTab == 3 && (super.mouseX < surface.width2 - 199 || super.mouseY > 316))
			showUiTab = 0;
		if((showUiTab == 2 || showUiTab == 4 || showUiTab == 5) && (super.mouseX < surface.width2 - 199 || super.mouseY > 240))
			showUiTab = 0;
		if(showUiTab == 6 && (super.mouseX < surface.width2 - 199 || super.mouseY > 311))
			showUiTab = 0;
	}

	protected byte[] readDataFile(String s, String s1, int i) {
		if(!aBoolean782)
			s = "/" + s;
		byte[] abyte0 = link.getjag(s);
		if(abyte0 != null) {
			int j = ((abyte0[0] & 0xff) << 16) + ((abyte0[1] & 0xff) << 8) + (abyte0[2] & 0xff);
			int k = ((abyte0[3] & 0xff) << 16) + ((abyte0[4] & 0xff) << 8) + (abyte0[5] & 0xff);
			byte[] abyte1 = new byte[abyte0.length - 6];
            System.arraycopy(abyte0, 6, abyte1, 0, abyte0.length - 6);

			method1(i, "Unpacking " + s1);
			if(k != j) {
				byte[] abyte2 = new byte[j];
				BZip2Decompressor.method133(abyte2, j, abyte1, k, 0);
				return abyte2;
			} else {
				return abyte1;
			}
		} else {
			return super.readDataFile(s, s1, i);
		}
	}

	private void method64() {
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
			surface.method262(i1 - l3 / 2, k4, l3, j4, spriteMedia + 9, 85);
			int l4 = (36 * k2) / 100;
			int i5 = (24 * k2) / 100;
			surface.spriteClipping(i1 - l4 / 2, (k4 + j4 / 2) - i5 / 2, l4, i5, Definitions.itemImages[j3] + spriteItem, Definitions.itemMasks[j3], 0, 0, false);
		}

		for(int j1 = 0; j1 < anInt691; j1++) {
			int i2 = anIntArray690[j1];
			int l2 = anIntArray692[j1];
			int k3 = anIntArray693[j1];
			surface.method224(i2 - 15, l2 - 3, k3, 5, 65280, 192);
			surface.method224((i2 - 15) + k3, l2 - 3, 30 - k3, 5, 0xff0000, 192);
		}

	}

	private void method65(int i, String s) {
		int j = objectX[i];
		int k = objectY[i];
		int l = j - localPlayer.currentX / 128;
		int i1 = k - localPlayer.currentY / 128;
		byte byte0 = 7;
		if(j >= 0 && k >= 0 && j < 96 && k < 96 && l > -byte0 && l < byte0 && i1 > -byte0 && i1 < byte0) {
			scene.removeModel(objectModel[i]);
			int j1 = Definitions.method127(s);
			Model model = gameModels[j1].copy();
			scene.addModel(model);
			model.setLight(true, 48, 48, -50, -10, -50);
			model.method195(objectModel[i]);
			model.key = i;
			objectModel[i] = model;
		}
	}

	private boolean isValidCameraAngle(int i) {
		int j = localPlayer.currentX / 128;
		int k = localPlayer.currentY / 128;
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

	private void method67() {
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
		if(super.mouseY > i - 12 && super.mouseY <= i && super.mouseX > 106 && super.mouseX < 406)
			j = 0xff0000;
		surface.drawStringCenter("Click here to close window", 256, i, 1, j);
		if(mouseButtonClick == 1) {
			if(j == 0xff0000)
				aBoolean790 = false;
			if((super.mouseX < 256 - c / 2 || super.mouseX > 256 + c / 2) && (super.mouseY < 167 - c1 / 2 || super.mouseY > 167 + c1 / 2))
				aBoolean790 = false;
		}
		mouseButtonClick = 0;
	}

	protected void method15(int i) {
		if(loggedIn == 0) {
			if(loginState == 0)
				aPanel767.method169(i);
			if(loginState == 1)
				aPanel774.method169(i);
			if(loginState == 2)
				aPanel770.method169(i);
		}
		if(loggedIn == 1) {
			if(changeAppearanceVisible) {
				aPanel729.method169(i);
				return;
			}
			if(anInt791 == 0 && showDialogReportAbuseStep == 0 && !isSleeping)
				panelMessageTabs.method169(i);
		}
	}

	private int getInventoryItemCount(int i) {
		int j = 0;
		for(int k = 0; k < inventorySize; k++)
			if(inventoryItemsIDs[k] == i)
				if(Definitions.inventoryItemsStackable[i] == 1)
					j++;
				else
					j += inventoryItemsQuantities[k];

		return j;
	}

	private boolean method69(int i, int j, int k, int l, int i1, int j1, boolean flag,
                             boolean flag1) {
		int k1 = world.method398(i, j, k, l, i1, j1, walkPathX, walkPathY, flag);
		if(k1 == -1)
			if(flag1) {
				k1 = 1;
				walkPathX[0] = k;
				walkPathY[0] = l;
			} else {
				return false;
			}
		k1--;
		i = walkPathX[k1];
		j = walkPathY[k1];
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
			super.packetStream.putByte(walkPathX[l1] - i);
			super.packetStream.putByte(walkPathY[l1] - j);
		}

		super.packetStream.endPacket();
		mouseClickXStep = -24;
		anInt801 = super.mouseX;
		anInt802 = super.mouseY;
		return true;
	}

	protected void method24() {
		systemUpdateTimer = 0;
		loginState = 0;
		loggedIn = 0;
		logoutTimeout = 0;
	}

	protected void method41(String s, String s1) {
		if(loginState == 1)
			aPanel774.updateText(anInt804, s + " " + s1);
		if(loginState == 2)
			aPanel770.updateText(anInt771, s + " " + s1);
		aString805 = s1;
		method73();
		method13();
	}

	private Character method70(int i, int j, int k, int l) {
		if(aCharacterArray806[i] == null) {
			aCharacterArray806[i] = new Character();
			aCharacterArray806[i].serverIndex = i;
			aCharacterArray806[i].serverID = 0;
		}
		Character rscharacter = aCharacterArray806[i];
		boolean flag = false;
		for(int i1 = 0; i1 < anInt808; i1++) {
			if(aCharacterArray807[i1].serverIndex != i)
				continue;
			flag = true;
			break;
		}

		if(flag) {
			rscharacter.nextAnimation = l;
			int j1 = rscharacter.waypointCurrent;
			if(j != rscharacter.waypointsX[j1] || k != rscharacter.waypointsY[j1]) {
				rscharacter.waypointCurrent = j1 = (j1 + 1) % 10;
				rscharacter.waypointsX[j1] = j;
				rscharacter.waypointsY[j1] = k;
			}
		} else {
			rscharacter.serverIndex = i;
			rscharacter.movingStep = 0;
			rscharacter.waypointCurrent = 0;
			rscharacter.waypointsX[0] = rscharacter.currentX = j;
			rscharacter.waypointsY[0] = rscharacter.currentY = k;
			rscharacter.nextAnimation = rscharacter.animation = l;
			rscharacter.stepCount = 0;
		}
		players[playerCount++] = rscharacter;
		return rscharacter;
	}

	private void method71() {
		surface.aBoolean321 = false;
		surface.method244();
		aPanel729.method150();
		int i = 140;
		int j = 50;
		i += 116;
		j -= 25;
		surface.method248(i - 32 - 55, j, 64, 102, Definitions.anIntArray103[anInt750], anIntArray697[anInt747]);
		surface.spriteClipping(i - 32 - 55, j, 64, 102, Definitions.anIntArray103[anInt739], anIntArray697[anInt741], anIntArray695[anInt744], 0, false);
		surface.spriteClipping(i - 32 - 55, j, 64, 102, Definitions.anIntArray103[anInt731], anIntArray696[anInt735], anIntArray695[anInt744], 0, false);
		surface.method248(i - 32, j, 64, 102, Definitions.anIntArray103[anInt750] + 6, anIntArray697[anInt747]);
		surface.spriteClipping(i - 32, j, 64, 102, Definitions.anIntArray103[anInt739] + 6, anIntArray697[anInt741], anIntArray695[anInt744], 0, false);
		surface.spriteClipping(i - 32, j, 64, 102, Definitions.anIntArray103[anInt731] + 6, anIntArray696[anInt735], anIntArray695[anInt744], 0, false);
		surface.method248((i - 32) + 55, j, 64, 102, Definitions.anIntArray103[anInt750] + 12, anIntArray697[anInt747]);
		surface.spriteClipping((i - 32) + 55, j, 64, 102, Definitions.anIntArray103[anInt739] + 12, anIntArray697[anInt741], anIntArray695[anInt744], 0, false);
		surface.spriteClipping((i - 32) + 55, j, 64, 102, Definitions.anIntArray103[anInt731] + 12, anIntArray696[anInt735], anIntArray695[anInt744], 0, false);
		surface.drawSprite(0, gameHeight, spriteMedia + 22);
		surface.draw(graphics, 0, 0);
	}

	private void drawUI() {
		if(logoutTimeout != 0)
			method94();
		else
		if(aBoolean810)
			drawDialogWelcome();
		else
		if(aBoolean790)
			method67();
		else
		if(anInt811 == 1)
			method116();
		else
		if(aBoolean812 && combatTimeout == 0)
			method77();
		else
		if(aBoolean813 && combatTimeout == 0)
			drawDialogShop();
		else
		if(showDialogTradeConfirm)
			method101();
		else
		if(showDialogTrade)
			method113();
		else
		if(aBoolean816)
			method100();
		else
		if(showDialogDuel)
			method112();
		else
		if(showDialogReportAbuseStep == 1)
			method111();
		else
		if(showDialogReportAbuseStep == 2)
			method98();
		else
		if(anInt791 != 0) {
			method84();
		} else {
			if(showOptionMenu)
				method46();
			if(localPlayer.animation == 8 || localPlayer.animation == 9)
				method107();
			setActiveUiTab();
			boolean flag = !showOptionMenu && !showRightClickMenu;
			if(flag)
				menuItemsCount = 0;
			if(showUiTab == 0 && flag)
				method75();
			if(showUiTab == 1)
				drawUiTabInventory(flag);
			if(showUiTab == 2)
				drawUiTabMinimap(flag);
			if(showUiTab == 3)
				drawUiTabPlayerInfo(flag);
			if(showUiTab == 4)
				drawUiTabMagic(flag);
			if(showUiTab == 5)
				drawUiTabSocial(flag);
			if(showUiTab == 6)
				drawUiTabOptions(flag);
			if(!showRightClickMenu && !showOptionMenu)
				createTopMouseMenu();
			if(showRightClickMenu && !showOptionMenu)
				drawRightClickMenu();
		}
		mouseButtonClick = 0;
	}

	private void method73() {
		aBoolean818 = false;
		surface.aBoolean321 = false;
		surface.method244();
		if(loginState == 0 || loginState == 1 || loginState == 2 || loginState == 3) {
			int i = (cycle * 2) % 3072;
			if(i < 1024) {
				surface.drawSprite(0, 10, spriteLogo);
				if(i > 768)
					surface.method260(0, 10, spriteLogo + 1, i - 768);
			} else
			if(i < 2048) {
				surface.drawSprite(0, 10, spriteLogo + 1);
				if(i > 1792)
					surface.method260(0, 10, spriteMedia + 10, i - 1792);
			} else {
				surface.drawSprite(0, 10, spriteMedia + 10);
				if(i > 2816)
					surface.method260(0, 10, spriteLogo, i - 2816);
			}
		}
		if(loginState == 0)
			aPanel767.method150();
		if(loginState == 1)
			aPanel774.method150();
		if(loginState == 2)
			aPanel770.method150();
		surface.drawSprite(0, gameHeight, spriteMedia + 22);
		surface.draw(graphics, 0, 0);
	}

	public int getDefaultCombatStyle() {
		return -1;
	}

	protected void method31() {
		systemUpdateTimer = 0;
		combatStyle = getDefaultCombatStyle();
		logoutTimeout = 0;
		loginState = 0;
		loggedIn = 1;
		method120();
		surface.method244();
		surface.draw(graphics, 0, 0);
		for(int i = 0; i < objectCount; i++) {
			scene.removeModel(objectModel[i]);
			world.method390(objectX[i], objectY[i], objectID[i]);
		}

		for(int j = 0; j < anInt826; j++) {
			scene.removeModel(aModelArray821[j]);
			world.method391(anIntArray822[j], anIntArray823[j], wallObjectDirection[j], wallObjectID[j]);
		}

		objectCount = 0;
		anInt826 = 0;
		anInt762 = 0;
		playerCount = 0;
		for(int k = 0; k < 4000; k++)
			aCharacterArray806[k] = null;

		for(int l = 0; l < 500; l++)
			players[l] = null;

		npcCount = 0;
		for(int i1 = 0; i1 < 5000; i1++)
			aCharacterArray716[i1] = null;

		for(int j1 = 0; j1 < 500; j1++)
			npcs[j1] = null;

		for(int k1 = 0; k1 < 50; k1++)
			aBooleanArray827[k1] = false;

		mouseButtonClick = 0;
		super.lastMouseButtonDown = 0;
		super.mouseButtonDown = 0;
		aBoolean813 = false;
		aBoolean812 = false;
		isSleeping = false;
		super.anInt603 = 0;
	}

	protected void method44(String s) {
		if(s.startsWith("@bor@")) {
			sendMessage(s, 4);
			return;
		}
		if(s.startsWith("@que@")) {
			sendMessage("@whi@" + s, 5);
			return;
		}
		if(s.startsWith("@pri@")) {
			sendMessage(s, 6);
        } else {
			sendMessage(s, 3);
        }
	}

	protected void method25() {
		logoutTimeout = 0;
		sendMessage("@cya@Sorry, you can't logout at the moment", 3);
	}

	private void logout() {
		if(loggedIn == 0)
			return;
		if(combatTimeout > 450) {
			sendMessage("@cya@You can't logout during combat!", 3);
			return;
		}
		if(combatTimeout > 0) {
			sendMessage("@cya@You can't logout for 10 seconds after combat", 3);
        } else {
			super.packetStream.createPacket(102);
			super.packetStream.endPacket();
			logoutTimeout = 1000;
        }
	}

	private void method75() {
		int i = 2203 - (sceneY + anInt828 + baseY);
		if(sceneX + anInt829 + baseX >= 2640)
			i = -50;
		int j = -1;
		for(int k = 0; k < objectCount; k++)
			aBooleanArray830[k] = false;

		for(int l = 0; l < anInt826; l++)
			aBooleanArray831[l] = false;

		int i1 = scene.method298();
		Model[] amodel = scene.method301();
		int[] ai = scene.method307();
		for(int j1 = 0; j1 < i1; j1++) {
			if(menuItemsCount > 200)
				break;
			int k1 = ai[j1];
			Model model = amodel[j1];
			if(model.faceTag[k1] <= 65535 || model.faceTag[k1] >= 0x30d40 && model.faceTag[k1] <= 0x493e0)
				if(model == scene.view) {
					int i2 = model.faceTag[k1] % 10000;
					int l2 = model.faceTag[k1] / 10000;
					if(l2 == 1) {
						String s = "";
						int k3 = 0;
						if(localPlayer.combatLevel > 0 && players[i2].combatLevel > 0)
							k3 = localPlayer.combatLevel - players[i2].combatLevel;
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
						s = " " + s + "(level-" + players[i2].combatLevel + ")";
						if(selectedSpell >= 0) {
							if(Definitions.anIntArray137[selectedSpell] == 1 || Definitions.anIntArray137[selectedSpell] == 2) {
								aStringArray727[menuItemsCount] = "Cast " + Definitions.aStringArray133[selectedSpell] + " on";
								aStringArray728[menuItemsCount] = "@whi@" + players[i2].name + s;
								menuItemOpcodes[menuItemsCount] = 800;
								menuItemX[menuItemsCount] = players[i2].currentX;
								menuItemY[menuItemsCount] = players[i2].currentY;
								menuItemIDs[menuItemsCount] = players[i2].serverIndex;
								menuItemSourceIdxs[menuItemsCount] = selectedSpell;
								menuItemsCount++;
							}
						} else
						if(selectedItemSlot >= 0) {
							aStringArray727[menuItemsCount] = "Use " + selectedItemName + " with";
							aStringArray728[menuItemsCount] = "@whi@" + players[i2].name + s;
							menuItemOpcodes[menuItemsCount] = 810;
							menuItemX[menuItemsCount] = players[i2].currentX;
							menuItemY[menuItemsCount] = players[i2].currentY;
							menuItemIDs[menuItemsCount] = players[i2].serverIndex;
							menuItemSourceIdxs[menuItemsCount] = selectedItemSlot;
							menuItemsCount++;
						} else {
							if(i > 0 && (players[i2].currentY - 64) / magicLoc + anInt828 + baseY < 2203) {
								aStringArray727[menuItemsCount] = "Attack";
								aStringArray728[menuItemsCount] = "@whi@" + players[i2].name + s;
								if(k3 >= 0 && k3 < 5)
									menuItemOpcodes[menuItemsCount] = 805;
								else
									menuItemOpcodes[menuItemsCount] = 2805;
								menuItemX[menuItemsCount] = players[i2].currentX;
								menuItemY[menuItemsCount] = players[i2].currentY;
								menuItemIDs[menuItemsCount] = players[i2].serverIndex;
								menuItemsCount++;
							} else
							if(isMembers) {
								aStringArray727[menuItemsCount] = "Duel with";
								aStringArray728[menuItemsCount] = "@whi@" + players[i2].name + s;
								menuItemX[menuItemsCount] = players[i2].currentX;
								menuItemY[menuItemsCount] = players[i2].currentY;
								menuItemOpcodes[menuItemsCount] = 2806;
								menuItemIDs[menuItemsCount] = players[i2].serverIndex;
								menuItemsCount++;
							}
							aStringArray727[menuItemsCount] = "Trade with";
							aStringArray728[menuItemsCount] = "@whi@" + players[i2].name + s;
							menuItemOpcodes[menuItemsCount] = 2810;
							menuItemIDs[menuItemsCount] = players[i2].serverIndex;
							menuItemsCount++;
							aStringArray727[menuItemsCount] = "Follow";
							aStringArray728[menuItemsCount] = "@whi@" + players[i2].name + s;
							menuItemOpcodes[menuItemsCount] = 2820;
							menuItemIDs[menuItemsCount] = players[i2].serverIndex;
							menuItemsCount++;
						}
					} else
					if(l2 == 2) {
						if(selectedSpell >= 0) {
							if(Definitions.anIntArray137[selectedSpell] == 3) {
								aStringArray727[menuItemsCount] = "Cast " + Definitions.aStringArray133[selectedSpell] + " on";
								aStringArray728[menuItemsCount] = "@lre@" + Definitions.itemNames[anIntArray841[i2]];
								menuItemOpcodes[menuItemsCount] = 200;
								menuItemX[menuItemsCount] = anIntArray760[i2];
								menuItemY[menuItemsCount] = anIntArray761[i2];
								menuItemIDs[menuItemsCount] = anIntArray841[i2];
								menuItemSourceIdxs[menuItemsCount] = selectedSpell;
								menuItemsCount++;
							}
						} else
						if(selectedItemSlot >= 0) {
							aStringArray727[menuItemsCount] = "Use " + selectedItemName + " with";
							aStringArray728[menuItemsCount] = "@lre@" + Definitions.itemNames[anIntArray841[i2]];
							menuItemOpcodes[menuItemsCount] = 210;
							menuItemX[menuItemsCount] = anIntArray760[i2];
							menuItemY[menuItemsCount] = anIntArray761[i2];
							menuItemIDs[menuItemsCount] = anIntArray841[i2];
							menuItemSourceIdxs[menuItemsCount] = selectedItemSlot;
							menuItemsCount++;
						} else {
							aStringArray727[menuItemsCount] = "Take";
							aStringArray728[menuItemsCount] = "@lre@" + Definitions.itemNames[anIntArray841[i2]];
							menuItemOpcodes[menuItemsCount] = 220;
							menuItemX[menuItemsCount] = anIntArray760[i2];
							menuItemY[menuItemsCount] = anIntArray761[i2];
							menuItemIDs[menuItemsCount] = anIntArray841[i2];
							menuItemsCount++;
							aStringArray727[menuItemsCount] = "Examine";
							aStringArray728[menuItemsCount] = "@lre@" + Definitions.itemNames[anIntArray841[i2]];
							menuItemOpcodes[menuItemsCount] = 3200;
							menuItemIDs[menuItemsCount] = anIntArray841[i2];
							menuItemsCount++;
						}
					} else
					if(l2 == 3) {
						String s1 = "";
						int l3 = -1;
						int i4 = npcs[i2].npcID;
						if(Definitions.anIntArray83[i4] > 0) {
							int j4 = (Definitions.anIntArray79[i4] + Definitions.anIntArray82[i4] + Definitions.anIntArray80[i4] + Definitions.anIntArray81[i4]) / 4;
							int k4 = (realSkillLevels[0] + realSkillLevels[1] + realSkillLevels[2] + realSkillLevels[3] + 27) / 4;
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
								aStringArray727[menuItemsCount] = "Cast " + Definitions.aStringArray133[selectedSpell] + " on";
								aStringArray728[menuItemsCount] = "@yel@" + Definitions.npcName[npcs[i2].npcID];
								menuItemOpcodes[menuItemsCount] = 700;
								menuItemX[menuItemsCount] = npcs[i2].currentX;
								menuItemY[menuItemsCount] = npcs[i2].currentY;
								menuItemIDs[menuItemsCount] = npcs[i2].serverIndex;
								menuItemSourceIdxs[menuItemsCount] = selectedSpell;
								menuItemsCount++;
							}
						} else
						if(selectedItemSlot >= 0) {
							aStringArray727[menuItemsCount] = "Use " + selectedItemName + " with";
							aStringArray728[menuItemsCount] = "@yel@" + Definitions.npcName[npcs[i2].npcID];
							menuItemOpcodes[menuItemsCount] = 710;
							menuItemX[menuItemsCount] = npcs[i2].currentX;
							menuItemY[menuItemsCount] = npcs[i2].currentY;
							menuItemIDs[menuItemsCount] = npcs[i2].serverIndex;
							menuItemSourceIdxs[menuItemsCount] = selectedItemSlot;
							menuItemsCount++;
						} else {
							if(Definitions.anIntArray83[i4] > 0) {
								aStringArray727[menuItemsCount] = "Attack";
								aStringArray728[menuItemsCount] = "@yel@" + Definitions.npcName[npcs[i2].npcID] + s1;
								if(l3 >= 0)
									menuItemOpcodes[menuItemsCount] = 715;
								else
									menuItemOpcodes[menuItemsCount] = 2715;
								menuItemX[menuItemsCount] = npcs[i2].currentX;
								menuItemY[menuItemsCount] = npcs[i2].currentY;
								menuItemIDs[menuItemsCount] = npcs[i2].serverIndex;
								menuItemsCount++;
							}
							aStringArray727[menuItemsCount] = "Talk-to";
							aStringArray728[menuItemsCount] = "@yel@" + Definitions.npcName[npcs[i2].npcID];
							menuItemOpcodes[menuItemsCount] = 720;
							menuItemX[menuItemsCount] = npcs[i2].currentX;
							menuItemY[menuItemsCount] = npcs[i2].currentY;
							menuItemIDs[menuItemsCount] = npcs[i2].serverIndex;
							menuItemsCount++;
							if(!Definitions.aStringArray78[i4].equals("")) {
								aStringArray727[menuItemsCount] = Definitions.aStringArray78[i4];
								aStringArray728[menuItemsCount] = "@yel@" + Definitions.npcName[npcs[i2].npcID];
								menuItemOpcodes[menuItemsCount] = 725;
								menuItemX[menuItemsCount] = npcs[i2].currentX;
								menuItemY[menuItemsCount] = npcs[i2].currentY;
								menuItemIDs[menuItemsCount] = npcs[i2].serverIndex;
								menuItemsCount++;
							}
							aStringArray727[menuItemsCount] = "Examine";
							aStringArray728[menuItemsCount] = "@yel@" + Definitions.npcName[npcs[i2].npcID];
							menuItemOpcodes[menuItemsCount] = 3700;
							menuItemIDs[menuItemsCount] = npcs[i2].npcID;
							menuItemsCount++;
						}
					}
				} else
				if(model != null && model.key >= 10000) {
					int j2 = model.key - 10000;
					int i3 = wallObjectID[j2];
					if(!aBooleanArray831[j2]) {
						if(selectedSpell >= 0) {
							if(Definitions.anIntArray137[selectedSpell] == 4) {
								aStringArray727[menuItemsCount] = "Cast " + Definitions.aStringArray133[selectedSpell] + " on";
								aStringArray728[menuItemsCount] = "@cya@" + Definitions.aStringArray115[i3];
								menuItemOpcodes[menuItemsCount] = 300;
								menuItemX[menuItemsCount] = anIntArray822[j2];
								menuItemY[menuItemsCount] = anIntArray823[j2];
								menuItemIDs[menuItemsCount] = wallObjectDirection[j2];
								menuItemSourceIdxs[menuItemsCount] = selectedSpell;
								menuItemsCount++;
							}
						} else
						if(selectedItemSlot >= 0) {
							aStringArray727[menuItemsCount] = "Use " + selectedItemName + " with";
							aStringArray728[menuItemsCount] = "@cya@" + Definitions.aStringArray115[i3];
							menuItemOpcodes[menuItemsCount] = 310;
							menuItemX[menuItemsCount] = anIntArray822[j2];
							menuItemY[menuItemsCount] = anIntArray823[j2];
							menuItemIDs[menuItemsCount] = wallObjectDirection[j2];
							menuItemSourceIdxs[menuItemsCount] = selectedItemSlot;
							menuItemsCount++;
						} else {
							if(!Definitions.aStringArray117[i3].equalsIgnoreCase("WalkTo")) {
								aStringArray727[menuItemsCount] = Definitions.aStringArray117[i3];
								aStringArray728[menuItemsCount] = "@cya@" + Definitions.aStringArray115[i3];
								menuItemOpcodes[menuItemsCount] = 320;
								menuItemX[menuItemsCount] = anIntArray822[j2];
								menuItemY[menuItemsCount] = anIntArray823[j2];
								menuItemIDs[menuItemsCount] = wallObjectDirection[j2];
								menuItemsCount++;
							}
							if(!Definitions.aStringArray118[i3].equalsIgnoreCase("Examine")) {
								aStringArray727[menuItemsCount] = Definitions.aStringArray118[i3];
								aStringArray728[menuItemsCount] = "@cya@" + Definitions.aStringArray115[i3];
								menuItemOpcodes[menuItemsCount] = 2300;
								menuItemX[menuItemsCount] = anIntArray822[j2];
								menuItemY[menuItemsCount] = anIntArray823[j2];
								menuItemIDs[menuItemsCount] = wallObjectDirection[j2];
								menuItemsCount++;
							}
							aStringArray727[menuItemsCount] = "Examine";
							aStringArray728[menuItemsCount] = "@cya@" + Definitions.aStringArray115[i3];
							menuItemOpcodes[menuItemsCount] = 3300;
							menuItemIDs[menuItemsCount] = i3;
							menuItemsCount++;
						}
						aBooleanArray831[j2] = true;
					}
				} else
				if(model != null && model.key >= 0) {
					int k2 = model.key;
					int j3 = objectID[k2];
					if(!aBooleanArray830[k2]) {
						if(selectedSpell >= 0) {
							if(Definitions.anIntArray137[selectedSpell] == 5) {
								aStringArray727[menuItemsCount] = "Cast " + Definitions.aStringArray133[selectedSpell] + " on";
								aStringArray728[menuItemsCount] = "@cya@" + Definitions.aStringArray105[j3];
								menuItemOpcodes[menuItemsCount] = 400;
								menuItemX[menuItemsCount] = objectX[k2];
								menuItemY[menuItemsCount] = objectY[k2];
								menuItemIDs[menuItemsCount] = objectDirection[k2];
								menuItemSourceIdxs[menuItemsCount] = objectID[k2];
								menuItemTargerIdxs[menuItemsCount] = selectedSpell;
								menuItemsCount++;
							}
						} else
						if(selectedItemSlot >= 0) {
							aStringArray727[menuItemsCount] = "Use " + selectedItemName + " with";
							aStringArray728[menuItemsCount] = "@cya@" + Definitions.aStringArray105[j3];
							menuItemOpcodes[menuItemsCount] = 410;
							menuItemX[menuItemsCount] = objectX[k2];
							menuItemY[menuItemsCount] = objectY[k2];
							menuItemIDs[menuItemsCount] = objectDirection[k2];
							menuItemSourceIdxs[menuItemsCount] = objectID[k2];
							menuItemTargerIdxs[menuItemsCount] = selectedItemSlot;
							menuItemsCount++;
						} else {
							if(!Definitions.aStringArray107[j3].equalsIgnoreCase("WalkTo")) {
								aStringArray727[menuItemsCount] = Definitions.aStringArray107[j3];
								aStringArray728[menuItemsCount] = "@cya@" + Definitions.aStringArray105[j3];
								menuItemOpcodes[menuItemsCount] = 420;
								menuItemX[menuItemsCount] = objectX[k2];
								menuItemY[menuItemsCount] = objectY[k2];
								menuItemIDs[menuItemsCount] = objectDirection[k2];
								menuItemSourceIdxs[menuItemsCount] = objectID[k2];
								menuItemsCount++;
							}
							if(!Definitions.aStringArray108[j3].equalsIgnoreCase("Examine")) {
								aStringArray727[menuItemsCount] = Definitions.aStringArray108[j3];
								aStringArray728[menuItemsCount] = "@cya@" + Definitions.aStringArray105[j3];
								menuItemOpcodes[menuItemsCount] = 2400;
								menuItemX[menuItemsCount] = objectX[k2];
								menuItemY[menuItemsCount] = objectY[k2];
								menuItemIDs[menuItemsCount] = objectDirection[k2];
								menuItemSourceIdxs[menuItemsCount] = objectID[k2];
								menuItemsCount++;
							}
							aStringArray727[menuItemsCount] = "Examine";
							aStringArray728[menuItemsCount] = "@cya@" + Definitions.aStringArray105[j3];
							menuItemOpcodes[menuItemsCount] = 3400;
							menuItemIDs[menuItemsCount] = j3;
							menuItemsCount++;
						}
						aBooleanArray830[k2] = true;
					}
				} else {
					if(k1 >= 0)
						k1 = model.faceTag[k1] - 0x30d40;
					if(k1 >= 0)
						j = k1;
				}
		}

		if(selectedSpell >= 0 && Definitions.anIntArray137[selectedSpell] <= 1) {
			aStringArray727[menuItemsCount] = "Cast " + Definitions.aStringArray133[selectedSpell] + " on self";
			aStringArray728[menuItemsCount] = "";
			menuItemOpcodes[menuItemsCount] = 1000;
			menuItemIDs[menuItemsCount] = selectedSpell;
			menuItemsCount++;
		}
		if(j != -1) {
			int l1 = j;
			if(selectedSpell >= 0) {
				if(Definitions.anIntArray137[selectedSpell] == 6) {
					aStringArray727[menuItemsCount] = "Cast " + Definitions.aStringArray133[selectedSpell] + " on ground";
					aStringArray728[menuItemsCount] = "";
					menuItemOpcodes[menuItemsCount] = 900;
					menuItemX[menuItemsCount] = world.anIntArray593[l1];
					menuItemY[menuItemsCount] = world.anIntArray594[l1];
					menuItemIDs[menuItemsCount] = selectedSpell;
					menuItemsCount++;
                }
			} else
			if(selectedItemSlot < 0) {
				aStringArray727[menuItemsCount] = "Walk here";
				aStringArray728[menuItemsCount] = "";
				menuItemOpcodes[menuItemsCount] = 920;
				menuItemX[menuItemsCount] = world.anIntArray593[l1];
				menuItemY[menuItemsCount] = world.anIntArray594[l1];
				menuItemsCount++;
			}
		}
	}

	private void method76() {
		//surface.drawSprite(0, gameHeight - 4, spriteMedia + 23);
		if (injected) {
			int i = 510;
			surface.drawSprite(0, gameHeight - 2, spriteMedia + 23);
			while (i < gameWidth) {
				surface.drawSprite(i, gameHeight + 2, spriteMedia + 22);
				i+= 510;
			}
		} else {
			surface.drawSprite(0, gameHeight - 4, spriteMedia + 23);
		}
		int i = Surface.method222(200, 200, 255);
		int textHeight = gameHeight + 6;
		if (injected)
			textHeight += 2;
		if(messageTabSelected == 0)
			i = Surface.method222(255, 200, 50);
		if(messageTabFlashAll % 30 > 15)
			i = Surface.method222(255, 50, 50);
		surface.drawStringCenter("All messages", 54, textHeight, 0, i);
		i = Surface.method222(200, 200, 255);
		if(messageTabSelected == 1)
			i = Surface.method222(255, 200, 50);
		if(messageTabFlashHistory % 30 > 15)
			i = Surface.method222(255, 50, 50);
		surface.drawStringCenter("Chat history", 155, textHeight, 0, i);
		i = Surface.method222(200, 200, 255);
		if(messageTabSelected == 2)
			i = Surface.method222(255, 200, 50);
		if(messtageTabFlashQuest % 30 > 15)
			i = Surface.method222(255, 50, 50);
		surface.drawStringCenter("Quest history", 255, textHeight, 0, i);
		i = Surface.method222(200, 200, 255);
		if(messageTabSelected == 3)
			i = Surface.method222(255, 200, 50);
		if(messageTabFlashPrivate % 30 > 15)
			i = Surface.method222(255, 50, 50);
		surface.drawStringCenter("Private history", 355, textHeight, 0, i);
		surface.drawStringCenter("Report abuse", 457, textHeight, 0, 0xffffff);
	}

	private void method77() {
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
		if(mouseButtonClick != 0) {
			mouseButtonClick = 0;
			int i = super.mouseX - (256 - c / 2);
			int k = super.mouseY - (170 - c1 / 2);
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
					if(j1 >= 1 && super.mouseX >= i + 220 && super.mouseY >= k + 238 && super.mouseX < i + 250 && super.mouseY <= k + 249) {
						super.packetStream.createPacket(22);
						super.packetStream.putShort(k2);
						super.packetStream.putShort(1);
						super.packetStream.put4(0x12345678);
						super.packetStream.endPacket();
					}
					if(j1 >= 5 && super.mouseX >= i + 250 && super.mouseY >= k + 238 && super.mouseX < i + 280 && super.mouseY <= k + 249) {
						super.packetStream.createPacket(22);
						super.packetStream.putShort(k2);
						super.packetStream.putShort(5);
						super.packetStream.put4(0x12345678);
						super.packetStream.endPacket();
					}
					if(j1 >= 25 && super.mouseX >= i + 280 && super.mouseY >= k + 238 && super.mouseX < i + 305 && super.mouseY <= k + 249) {
						super.packetStream.createPacket(22);
						super.packetStream.putShort(k2);
						super.packetStream.putShort(25);
						super.packetStream.put4(0x12345678);
						super.packetStream.endPacket();
					}
					if(j1 >= 100 && super.mouseX >= i + 305 && super.mouseY >= k + 238 && super.mouseX < i + 335 && super.mouseY <= k + 249) {
						super.packetStream.createPacket(22);
						super.packetStream.putShort(k2);
						super.packetStream.putShort(100);
						super.packetStream.put4(0x12345678);
						super.packetStream.endPacket();
					}
					if(j1 >= 500 && super.mouseX >= i + 335 && super.mouseY >= k + 238 && super.mouseX < i + 368 && super.mouseY <= k + 249) {
						super.packetStream.createPacket(22);
						super.packetStream.putShort(k2);
						super.packetStream.putShort(500);
						super.packetStream.put4(0x12345678);
						super.packetStream.endPacket();
					}
					if(j1 >= 2500 && super.mouseX >= i + 370 && super.mouseY >= k + 238 && super.mouseX < i + 400 && super.mouseY <= k + 249) {
						super.packetStream.createPacket(22);
						super.packetStream.putShort(k2);
						super.packetStream.putShort(2500);
						super.packetStream.put4(0x12345678);
						super.packetStream.endPacket();
					}
					if(getInventoryItemCount(k2) >= 1 && super.mouseX >= i + 220 && super.mouseY >= k + 263 && super.mouseX < i + 250 && super.mouseY <= k + 274) {
						super.packetStream.createPacket(23);
						super.packetStream.putShort(k2);
						super.packetStream.putShort(1);
						super.packetStream.put4(0x87654321);
						super.packetStream.endPacket();
					}
					if(getInventoryItemCount(k2) >= 5 && super.mouseX >= i + 250 && super.mouseY >= k + 263 && super.mouseX < i + 280 && super.mouseY <= k + 274) {
						super.packetStream.createPacket(23);
						super.packetStream.putShort(k2);
						super.packetStream.putShort(5);
						super.packetStream.put4(0x87654321);
						super.packetStream.endPacket();
					}
					if(getInventoryItemCount(k2) >= 25 && super.mouseX >= i + 280 && super.mouseY >= k + 263 && super.mouseX < i + 305 && super.mouseY <= k + 274) {
						super.packetStream.createPacket(23);
						super.packetStream.putShort(k2);
						super.packetStream.putShort(25);
						super.packetStream.put4(0x87654321);
						super.packetStream.endPacket();
					}
					if(getInventoryItemCount(k2) >= 100 && super.mouseX >= i + 305 && super.mouseY >= k + 263 && super.mouseX < i + 335 && super.mouseY <= k + 274) {
						super.packetStream.createPacket(23);
						super.packetStream.putShort(k2);
						super.packetStream.putShort(100);
						super.packetStream.put4(0x87654321);
						super.packetStream.endPacket();
					}
					if(getInventoryItemCount(k2) >= 500 && super.mouseX >= i + 335 && super.mouseY >= k + 263 && super.mouseX < i + 368 && super.mouseY <= k + 274) {
						super.packetStream.createPacket(23);
						super.packetStream.putShort(k2);
						super.packetStream.putShort(500);
						super.packetStream.put4(0x87654321);
						super.packetStream.endPacket();
					}
					if(getInventoryItemCount(k2) >= 2500 && super.mouseX >= i + 370 && super.mouseY >= k + 263 && super.mouseX < i + 400 && super.mouseY <= k + 274) {
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
		surface.drawString("Bank", j + 1, l + 10, 1, 0xffffff);
		int i2 = 50;
		if(anInt663 > 48) {
			int l2 = 0xffffff;
			if(anInt846 == 0)
				l2 = 0xff0000;
			else
			if(super.mouseX > j + i2 && super.mouseY >= l && super.mouseX < j + i2 + 65 && super.mouseY < l + 12)
				l2 = 0xffff00;
			surface.drawString("<page 1>", j + i2, l + 10, 1, l2);
			i2 += 65;
			l2 = 0xffffff;
			if(anInt846 == 1)
				l2 = 0xff0000;
			else
			if(super.mouseX > j + i2 && super.mouseY >= l && super.mouseX < j + i2 + 65 && super.mouseY < l + 12)
				l2 = 0xffff00;
			surface.drawString("<page 2>", j + i2, l + 10, 1, l2);
			i2 += 65;
		}
		if(anInt663 > 96) {
			int i3 = 0xffffff;
			if(anInt846 == 2)
				i3 = 0xff0000;
			else
			if(super.mouseX > j + i2 && super.mouseY >= l && super.mouseX < j + i2 + 65 && super.mouseY < l + 12)
				i3 = 0xffff00;
			surface.drawString("<page 3>", j + i2, l + 10, 1, i3);
			i2 += 65;
		}
		if(anInt663 > 144) {
			int j3 = 0xffffff;
			if(anInt846 == 3)
				j3 = 0xff0000;
			else
			if(super.mouseX > j + i2 && super.mouseY >= l && super.mouseX < j + i2 + 65 && super.mouseY < l + 12)
				j3 = 0xffff00;
			surface.drawString("<page 4>", j + i2, l + 10, 1, j3);
			i2 += 65;
		}
		int k3 = 0xffffff;
		if(super.mouseX > j + 320 && super.mouseY >= l && super.mouseX < j + 408 && super.mouseY < l + 12)
			k3 = 0xff0000;
		surface.method243("Close window", j + 406, l + 10, 1, k3);
		surface.drawString("Number in bank in green", j + 7, l + 24, 1, 65280);
		surface.drawString("Number held in blue", j + 289, l + 24, 1, 65535);
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
					surface.spriteClipping(l8, i9, 48, 32, spriteItem + Definitions.itemImages[anIntArray664[k7]], Definitions.itemMasks[anIntArray664[k7]], 0, 0, false);
					surface.drawString(String.valueOf(anIntArray666[k7]), l8 + 1, i9 + 10, 1, 65280);
					surface.method243(String.valueOf(getInventoryItemCount(anIntArray664[k7])), l8 + 47, i9 + 29, 1, 65535);
				}
				k7++;
			}

		}

		surface.drawHorizontalLine(j + 5, l + 256, 398, 0);
		if(anInt847 == -1) {
			surface.drawStringCenter("Select an object to withdraw or deposit", j + 204, l + 248, 3, 0xffff00);
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
				surface.drawString("Withdraw " + Definitions.itemNames[k8], j + 2, l + 248, 1, 0xffffff);
				int l3 = 0xffffff;
				if(super.mouseX >= j + 220 && super.mouseY >= l + 238 && super.mouseX < j + 250 && super.mouseY <= l + 249)
					l3 = 0xff0000;
				surface.drawString("One", j + 222, l + 248, 1, l3);
				if(l7 >= 5) {
					int i4 = 0xffffff;
					if(super.mouseX >= j + 250 && super.mouseY >= l + 238 && super.mouseX < j + 280 && super.mouseY <= l + 249)
						i4 = 0xff0000;
					surface.drawString("Five", j + 252, l + 248, 1, i4);
				}
				if(l7 >= 25) {
					int j4 = 0xffffff;
					if(super.mouseX >= j + 280 && super.mouseY >= l + 238 && super.mouseX < j + 305 && super.mouseY <= l + 249)
						j4 = 0xff0000;
					surface.drawString("25", j + 282, l + 248, 1, j4);
				}
				if(l7 >= 100) {
					int k4 = 0xffffff;
					if(super.mouseX >= j + 305 && super.mouseY >= l + 238 && super.mouseX < j + 335 && super.mouseY <= l + 249)
						k4 = 0xff0000;
					surface.drawString("100", j + 307, l + 248, 1, k4);
				}
				if(l7 >= 500) {
					int l4 = 0xffffff;
					if(super.mouseX >= j + 335 && super.mouseY >= l + 238 && super.mouseX < j + 368 && super.mouseY <= l + 249)
						l4 = 0xff0000;
					surface.drawString("500", j + 337, l + 248, 1, l4);
				}
				if(l7 >= 2500) {
					int i5 = 0xffffff;
					if(super.mouseX >= j + 370 && super.mouseY >= l + 238 && super.mouseX < j + 400 && super.mouseY <= l + 249)
						i5 = 0xff0000;
					surface.drawString("2500", j + 370, l + 248, 1, i5);
				}
			}
			if(getInventoryItemCount(k8) > 0) {
				surface.drawString("Deposit " + Definitions.itemNames[k8], j + 2, l + 273, 1, 0xffffff);
				int j5 = 0xffffff;
				if(super.mouseX >= j + 220 && super.mouseY >= l + 263 && super.mouseX < j + 250 && super.mouseY <= l + 274)
					j5 = 0xff0000;
				surface.drawString("One", j + 222, l + 273, 1, j5);
				if(getInventoryItemCount(k8) >= 5) {
					int k5 = 0xffffff;
					if(super.mouseX >= j + 250 && super.mouseY >= l + 263 && super.mouseX < j + 280 && super.mouseY <= l + 274)
						k5 = 0xff0000;
					surface.drawString("Five", j + 252, l + 273, 1, k5);
				}
				if(getInventoryItemCount(k8) >= 25) {
					int l5 = 0xffffff;
					if(super.mouseX >= j + 280 && super.mouseY >= l + 263 && super.mouseX < j + 305 && super.mouseY <= l + 274)
						l5 = 0xff0000;
					surface.drawString("25", j + 282, l + 273, 1, l5);
				}
				if(getInventoryItemCount(k8) >= 100) {
					int i6 = 0xffffff;
					if(super.mouseX >= j + 305 && super.mouseY >= l + 263 && super.mouseX < j + 335 && super.mouseY <= l + 274)
						i6 = 0xff0000;
					surface.drawString("100", j + 307, l + 273, 1, i6);
				}
				if(getInventoryItemCount(k8) >= 500) {
					int j6 = 0xffffff;
					if(super.mouseX >= j + 335 && super.mouseY >= l + 263 && super.mouseX < j + 368 && super.mouseY <= l + 274)
						j6 = 0xff0000;
					surface.drawString("500", j + 337, l + 273, 1, j6);
				}
				if(getInventoryItemCount(k8) >= 2500) {
					int k6 = 0xffffff;
					if(super.mouseX >= j + 370 && super.mouseY >= l + 263 && super.mouseX < j + 400 && super.mouseY <= l + 274)
						k6 = 0xff0000;
					surface.drawString("2500", j + 370, l + 273, 1, k6);
				}
			}
		}
	}

	public HashMap<Integer, PendingShopAction> pendingShopBuyActions = new HashMap<>();
	public HashMap<Integer, PendingShopAction> pendingShopSellActions = new HashMap<>();

	public ArrayList<Integer> pendingShopBuyActionsToRemove = new ArrayList<>();
	public ArrayList<Integer> pendingShopSellActionsToRemove = new ArrayList<>();
	public static class PendingShopAction {
		public int pendingActions = 0;
		public int val1;
		public int val2;
	}

	//I would like to cleanup most of the modifications made here to be mostly done in mixins
	//but for now it will do
	private void drawDialogShop() {
		//Send pending shop actions 1 per frame
		//This is how we have to do it, no modification to protocol allowed by openrsc devs for 203 :(
		if (injected) {
			boolean didAction = false;
			//Send 1 sell if there is one pending
			for (int key : pendingShopSellActions.keySet()) {
				PendingShopAction pendingShopAction = pendingShopSellActions.get(key);
				if (pendingShopAction.pendingActions > 0) {
					super.packetStream.createPacket(221);
					super.packetStream.putShort(pendingShopAction.val1);
					super.packetStream.put4(pendingShopAction.val2);
					super.packetStream.endPacket();
					pendingShopAction.pendingActions -= 1;
					didAction = true;
				}
				if (pendingShopAction.pendingActions <= 0) {
					pendingShopSellActionsToRemove.add(key);
				}
				if (didAction)
					break;
			}
			//Send 1 buy if there is one pending
			if (!didAction) {
				for (int key : pendingShopBuyActions.keySet()) {
					PendingShopAction pendingShopAction = pendingShopBuyActions.get(key);
					if (pendingShopAction.pendingActions > 0) {
						super.packetStream.createPacket(236);
						super.packetStream.putShort(pendingShopAction.val1);
						super.packetStream.put4(pendingShopAction.val2);
						super.packetStream.endPacket();
						pendingShopAction.pendingActions -= 1;
						didAction = true;
					}
					if (pendingShopAction.pendingActions <= 0) {
						pendingShopBuyActionsToRemove.add(key);
					}
					if (didAction)
						break;
				}
			}
			//remove empty pending actions
			for (int toRemove : pendingShopSellActionsToRemove)
				pendingShopSellActions.remove(toRemove);
			for (int toRemove : pendingShopBuyActionsToRemove)
				pendingShopSellActions.remove(toRemove);
			pendingShopSellActionsToRemove.clear();
			pendingShopBuyActionsToRemove.clear();
		}
		if(mouseButtonClick != 0) {
			mouseButtonClick = 0;
			int i = super.mouseX - 52;
			int j = super.mouseY - 44;
			int mlx = this.mouseX - (Constants.GAME_FIXED_WIDTH - 408) / 2;
			int mly = this.mouseY - (Constants.GAME_FIXED_HEIGHT - 246) / 2;
			if(i >= 0 && j >= 12 && i < 408 && j < 246) {
				//Close shop, clear pending actions
				if (injected) {
					pendingShopSellActions.clear();
					pendingShopBuyActions.clear();
				}

				int k = 0;
				for(int i1 = 0; i1 < 5; i1++) {
					for(int i2 = 0; i2 < 8; i2++) {
						int l2 = 7 + i2 * 49;
						int l3 = 28 + i1 * 34;
						if(i > l2 && i < l2 + 49 && j > l3 && j < l3 + 34 && shopCategoryID[k] != -1) {
							shopSelectedItemIndex = k;
							shopSelectedItemType = shopCategoryID[k];
						}
						k++;
					}

				}

				if(shopSelectedItemIndex >= 0) {
					int id = shopCategoryID[shopSelectedItemIndex];
					if(id != -1) {
						//Buy 1,5,10,50
						int shopCount = this.shopItemQuantities[this.shopSelectedItemIndex];
						if (injected) {
							byte pendingCount = 0;
							boolean mouseInBuyRow = 204 + 44 <= this.mouseY && 44 + 215 >= this.mouseY;
							if (mouseInBuyRow) {
								if (mlx > 318 && mlx < 330) {
									pendingCount = 1;
								}

								if (mlx > 333 && mlx < 345) {
									pendingCount = 5;
								}

								if (mlx > 348 && mlx < 365) {
									pendingCount = 10;
								}

								if (mlx > 368 && mlx < 385) {
									pendingCount = 50;
								}

							/*if (mlx > 388 && mlx < 400) {
								this.showItemModX(InputXPrompt.shopBuyX, InputXAction.SHOP_BUY, true);
							}*/

								if (pendingCount != 0) {
									PendingShopAction pendingShopAction = pendingShopBuyActions.get(id);
									if (pendingShopAction == null)
										pendingShopAction = new PendingShopAction();

									pendingShopAction.pendingActions += pendingCount - 1;

									if (pendingShopAction.pendingActions > shopCount) {
										pendingShopAction.pendingActions = shopCount;
									}
									int i3 = shopPriceMod + shopItemPrices[shopSelectedItemIndex];
									if(i3 < 10)
										i3 = 10;
									int i4 = (i3 * Definitions.itemBasePrice[id]) / 100;
									pendingShopAction.val1 = shopCategoryID[shopSelectedItemIndex];
									pendingShopAction.val2 = i4;
									pendingShopBuyActions.put(id, pendingShopAction);

									super.packetStream.createPacket(236);
									super.packetStream.putShort(pendingShopAction.val1);
									super.packetStream.put4(pendingShopAction.val2);
									super.packetStream.endPacket();
								}
							}

						} else {
							if(shopItemQuantities[shopSelectedItemIndex] > 0 && i > 298 && j >= 204 && i < 408 && j <= 215) {
								int i3 = shopPriceMod + shopItemPrices[shopSelectedItemIndex];
								if(i3 < 10)
									i3 = 10;
								int i4 = (i3 * Definitions.itemBasePrice[id]) / 100;
								super.packetStream.createPacket(236);
								super.packetStream.putShort(shopCategoryID[shopSelectedItemIndex]);
								super.packetStream.put4(i4);
								super.packetStream.endPacket();
							}
						}
						//Sell 1,5,10,50
						int inventoryCount = getInventoryItemCount(id);

						if (injected) {
							byte pendingCount = 0;
							boolean mouseInSellRow = this.mouseY >= 44 + 229 && 44 + 240 >= this.mouseY;
							if (mouseInSellRow) {
								if (mlx > 318 && mlx < 330) {
									pendingCount = 1;
								}

								if (mlx > 333 && mlx < 345) {
									pendingCount = 5;
								}

								if (mlx > 348 && mlx < 365) {
									pendingCount = 10;
								}
								//TODO: Fix
						/*	if (mlx > 388 && mlx < 400) {
								this.showItemModX(InputXPrompt.shopSellX, InputXAction.SHOP_SELL, true);
							}*/

								if (mlx > 368 && mlx < 385) {
									pendingCount = 50;
								}

								if (pendingCount != 0) {
									PendingShopAction pendingShopAction = pendingShopSellActions.get(id);
									if (pendingShopAction == null)
										pendingShopAction = new PendingShopAction();

									pendingShopAction.pendingActions += pendingCount - 1;

									if (pendingShopAction.pendingActions > inventoryCount - 1) {
										pendingShopAction.pendingActions = inventoryCount - 1;
									}
									int j3 = anInt855 + shopItemPrices[shopSelectedItemIndex];
									if(j3 < 10)
										j3 = 10;
									int j4 = (j3 * Definitions.itemBasePrice[id]) / 100;
									pendingShopAction.val1 = shopCategoryID[shopSelectedItemIndex];
									pendingShopAction.val2 = j4;
									pendingShopSellActions.put(id, pendingShopAction);

									super.packetStream.createPacket(221);
									super.packetStream.putShort(pendingShopAction.val1);
									super.packetStream.put4(pendingShopAction.val2);
									super.packetStream.endPacket();
								}
							}
						} else {
							if(inventoryCount > 0 && i > 2 && j >= 229 && i < 112 && j <= 240) {
								int j3 = anInt855 + shopItemPrices[shopSelectedItemIndex];
								if(j3 < 10)
									j3 = 10;
								int j4 = (j3 * Definitions.itemBasePrice[id]) / 100;
								super.packetStream.createPacket(221);
								super.packetStream.putShort(shopCategoryID[shopSelectedItemIndex]);
								super.packetStream.put4(j4);
								super.packetStream.endPacket();
							}
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
		byte xr = 52;
		byte yr = 44;
		surface.method207(xr, yr, 408, 12, 192);
		int l = 0x989898;
		surface.method224(xr, yr + 12, 408, 17, l, 160);
		surface.method224(xr, yr + 29, 8, 170, l, 160);
		surface.method224(xr + 399, yr + 29, 9, 170, l, 160);
		surface.method224(xr, yr + 199, 408, 47, l, 160);
		surface.drawString("Buying and selling items", xr + 1, yr + 10, 1, 0xffffff);
		int color2 = 0xffffff;
		if(super.mouseX > xr + 320 && super.mouseY >= yr && super.mouseX < xr + 408 && super.mouseY < yr + 12)
			color2 = 0xff0000;
		surface.method243("Close window", xr + 406, yr + 10, 1, color2);
		surface.drawString("Shops stock in green", xr + 2, yr + 24, 1, 65280);
		surface.drawString("Number you own in blue", xr + 135, yr + 24, 1, 65535);
		surface.drawString("Your money: " + getInventoryItemCount(10) + "gp", xr + 280, yr + 24, 1, 0xffff00);
		int k2 = 0xd0d0d0;
		int k3 = 0;
		for(int k4 = 0; k4 < 5; k4++) {
			for(int l4 = 0; l4 < 8; l4++) {
				int j5 = xr + 7 + l4 * 49;
				int i6 = yr + 28 + k4 * 34;
				if(shopSelectedItemIndex == k3)
					surface.method224(j5, i6, 49, 34, 0xff0000, 160);
				else
					surface.method224(j5, i6, 49, 34, k2, 160);
				surface.method214(j5, i6, 50, 35, 0);
				if(shopCategoryID[k3] != -1) {
					surface.spriteClipping(j5, i6, 48, 32, spriteItem + Definitions.itemImages[shopCategoryID[k3]], Definitions.itemMasks[shopCategoryID[k3]], 0, 0, false);
					surface.drawString(String.valueOf(shopItemQuantities[k3]), j5 + 1, i6 + 10, 1, 65280);
					surface.method243(String.valueOf(getInventoryItemCount(shopCategoryID[k3])), j5 + 47, i6 + 10, 1, 65535);
				}
				k3++;
			}

		}

		surface.drawHorizontalLine(xr + 5, yr + 222, 398, 0);
		if(shopSelectedItemIndex == -1) {
			surface.drawStringCenter("Select an object to buy or sell", xr + 204, yr + 214, 3, 0xffff00);
			return;
		}
		int id = shopCategoryID[shopSelectedItemIndex];
		if(id != -1) {
			if (!injected) {
				if(shopItemQuantities[shopSelectedItemIndex] > 0) {
					int k5 = shopPriceMod + shopItemPrices[shopSelectedItemIndex];
					if(k5 < 10)
						k5 = 10;
					int buyCost = (k5 * Definitions.itemBasePrice[id]) / 100;
					surface.drawString("Buy a new " + Definitions.itemNames[id] + " for " + buyCost + "gp", xr + 2, yr + 214, 1, 0xffff00);
					int k1 = 0xffffff;
					if(super.mouseX > xr + 298 && super.mouseY >= yr + 204 && super.mouseX < xr + 408 && super.mouseY <= yr + 215)
						k1 = 0xff0000;
					surface.method243("Click here to buy", xr + 405, yr + 214, 3, k1);
				} else {
					surface.drawStringCenter("This item is not currently available to buy", xr + 204, yr + 214, 3, 0xffff00);
				}
				if(getInventoryItemCount(id) > 0) {
					int l5 = anInt855 + shopItemPrices[shopSelectedItemIndex];
					if(l5 < 10)
						l5 = 10;
					int sellCost = (l5 * Definitions.itemBasePrice[id]) / 100;
					surface.method243("Sell your " + Definitions.itemNames[id] + " for " + sellCost + "gp", xr + 405, yr + 239, 1, 0xffff00);
					int l1 = 0xffffff;
					if(super.mouseX > xr + 2 && super.mouseY >= yr + 229 && super.mouseX < xr + 112 && super.mouseY <= yr + 240)
						l1 = 0xff0000;
					surface.drawString("Click here to sell", xr + 2, yr + 239, 3, l1);
					return;
				}
				surface.drawStringCenter("You do not have any of this item to sell", xr + 204, yr + 239, 3, 0xffff00);
			} else {
				int shopQuantity = shopItemQuantities[shopSelectedItemIndex];
				int playerQuantity = getInventoryItemCount(id);

				int l5 = anInt855 + shopItemPrices[shopSelectedItemIndex];
				if(l5 < 10)
					l5 = 10;
				int sellCost = (l5 * Definitions.itemBasePrice[id]) / 100;

				int k5 = shopPriceMod + shopItemPrices[shopSelectedItemIndex];
				if(k5 < 10)
					k5 = 10;
				int buyCost = (k5 * Definitions.itemBasePrice[id]) / 100;

				// Buy
				if (shopQuantity <= 0) {
					surface.drawStringCenter("This item is not currently available to buy",204 + xr,  214 + yr, 3, 0xFFFF00);
				} else {
					surface.drawString(
							Definitions.itemNames[id] + ": buy for " + buyCost + "gp each", 2 + xr,
							yr + 214, 1, 0xFFFF00);
					boolean mouseInRow = 204 + yr <= this.mouseY && yr + 215 >= this.mouseY;
					surface.drawString("Buy:", xr + 285, 214 + yr, 3, 0xFFFFFF);
					color2 = 0xFFFFFF;
					if (mouseInRow && this.mouseX > 318 + xr && this.mouseX < xr + 330) {
						color2 = 0xFF0000;
					}
					surface.drawString("1", xr + 320, 214 + yr, 3, color2);

					color2 = 0xFFFFFF;
					if (mouseInRow && this.mouseX > 333 + xr && this.mouseX < 345 + xr) {
						color2 = 0xFF0000;
					}
					surface.drawString("5", 335 + xr, 214 + yr, 3, color2);

					color2 = 0xFFFFFF;
					if (mouseInRow && 348 + xr < this.mouseX && this.mouseX < xr + 365) {
						color2 = 0xFF0000;
					}
					surface.drawString("10", 350 + xr, 214 + yr, 3, color2);

					color2 = 0xFFFFFF;
					if (mouseInRow && this.mouseX > 368 + xr && 385 + xr > this.mouseX) {
						color2 = 0xFF0000;
					}
					surface.drawString("50", xr + 370, 214 + yr, 3, color2);

/*					color2 = 0xFFFFFF;
					if (mouseInRow && this.mouseX > xr + 388 && this.mouseX < 400 + xr) {
						color2 = 0xFF0000;
					}
					surface.drawString("X", 390 + xr, 214 + yr, 3, color2);*/
				}

				//Sell

				if (playerQuantity <=0) {
					surface.drawString("You do not have any of this item to sell",xr + 204, 239 + yr, 3, 0xFFFF00);
				} else {
					surface.drawString(
							Definitions.itemNames[id] + ": sell for " + sellCost + "gp each", 2 + xr,
							yr + 239, 1, 0xFFFF00);
					boolean mouseInRow = this.mouseY >= yr + 229 && yr + 240 >= this.mouseY;

					color2 = 0xFFFFFF;
					surface.drawString("Sell:", xr + 285, yr + 239, 3, 0xFFFFFF);
					if (mouseInRow && xr + 318 < this.mouseX && this.mouseX < xr + 330) {
						color2 = 0xFF0000;
					}
					surface.drawString("1", xr + 320, 239 + yr, 3, color2);

					color2 = 0xFFFFFF;
					if (mouseInRow && xr + 333 < this.mouseX && this.mouseX < xr + 345) {
						color2 = 0xFF0000;
					}
					surface.drawString("5", 335 + xr, 239 + yr, 3, color2);

					color2 = 0xFFFFFF;
					if (mouseInRow && 348 + xr < this.mouseX && 365 + xr > this.mouseX) {
						color2 = 0xFF0000;
					}
					surface.drawString("10", xr + 350, 239 + yr, 3, color2);

					color2 = 0xFFFFFF;
					if (mouseInRow && this.mouseX > xr + 368 && 385 + xr > this.mouseX) {
						color2 = 0xFF0000;
					}
					surface.drawString("50", xr + 370, 239 + yr, 3, color2);

/*					color2 = 0xFFFFFF;
					if (mouseInRow && this.mouseX > 388 + xr && xr + 400 > this.mouseX) {
						color2 = 0xFF0000;
					}
					surface.drawString("X", xr + 390, yr + 239, 3, color2);*/
				}
			}
		}
	}

	private void sendMessage(String s, int i) {
		if(i == 2 || i == 4 || i == 6) {
			for(; s.length() > 5 && s.charAt(0) == '@' && s.charAt(4) == '@'; s = s.substring(5));
			int j = s.indexOf(":");
			if(j != -1) {
				String s1 = s.substring(0, j);
				long l = DataUtils.method356(s1);
				for(int i1 = 0; i1 < super.anInt606; i1++)
					if(super.ignoreList[i1] == l)
						return;

			}
		}
		if(i == 2)
			s = "@yel@" + s;
		if(i == 3 || i == 4)
			s = "@whi@" + s;
		if(i == 6)
			s = "@cya@" + s;
		if(messageTabSelected != 0) {
			if(i == 4 || i == 3)
				messageTabFlashAll = 200;
			if(i == 2 && messageTabSelected != 1)
				messageTabFlashHistory = 200;
			if(i == 5 && messageTabSelected != 2)
				messtageTabFlashQuest = 200;
			if(i == 6 && messageTabSelected != 3)
				messageTabFlashPrivate = 200;
			if(i == 3 && messageTabSelected != 0)
				messageTabSelected = 0;
			if(i == 6 && messageTabSelected != 3 && messageTabSelected != 0)
				messageTabSelected = 0;
		}
		for(int k = 4; k > 0; k--) {
			aStringArray856[k] = aStringArray856[k - 1];
			messageHistoryTimeout[k] = messageHistoryTimeout[k - 1];
		}

		aStringArray856[0] = s;
		messageHistoryTimeout[0] = 300;
		if(i == 2)
            panelMessageTabs.method141(controlTextListChat, s, panelMessageTabs.controlFlashText[controlTextListChat] == panelMessageTabs.anIntArray195[controlTextListChat] - 4);
		if(i == 5)
            panelMessageTabs.method141(controlTextListQuest, s, panelMessageTabs.controlFlashText[controlTextListQuest] == panelMessageTabs.anIntArray195[controlTextListQuest] - 4);
		if(i == 6) {
			if(panelMessageTabs.controlFlashText[controlTextListPrivate] == panelMessageTabs.anIntArray195[controlTextListPrivate] - 4) {
				panelMessageTabs.method141(controlTextListPrivate, s, true);
				return;
			}
			panelMessageTabs.method141(controlTextListPrivate, s, false);
		}
	}

	private void createTopMouseMenu() {
		if(selectedSpell >= 0 || selectedItemSlot >= 0) {
			aStringArray727[menuItemsCount] = "Cancel";
			aStringArray728[menuItemsCount] = "";
			menuItemOpcodes[menuItemsCount] = 4000;
			menuItemsCount++;
		}
		for(int i = 0; i < menuItemsCount; i++)
			menuIdxs[i] = i;

		for(boolean flag = false; !flag;) {
			flag = true;
			for(int j = 0; j < menuItemsCount - 1; j++) {
				int l = menuIdxs[j];
				int j1 = menuIdxs[j + 1];
				if(menuItemOpcodes[l] > menuItemOpcodes[j1]) {
					menuIdxs[j] = j1;
					menuIdxs[j + 1] = l;
					flag = false;
				}
			}

		}

		if(menuItemsCount > 20)
			menuItemsCount = 20;
		if(menuItemsCount > 0) {
			int k = -1;
			for(int i1 = 0; i1 < menuItemsCount; i1++) {
				if(aStringArray728[menuIdxs[i1]] == null || aStringArray728[menuIdxs[i1]].length() <= 0)
					continue;
				k = i1;
				break;
			}

			String s = null;
			if((selectedItemSlot >= 0 || selectedSpell >= 0) && menuItemsCount == 1)
				s = "Choose a target";
			else
			if((selectedItemSlot >= 0 || selectedSpell >= 0) && menuItemsCount > 1)
				s = "@whi@" + aStringArray727[menuIdxs[0]] + " " + aStringArray728[menuIdxs[0]];
			else
			if(k != -1)
				s = aStringArray728[menuIdxs[k]] + ": @whi@" + aStringArray727[menuIdxs[0]];
			if(menuItemsCount == 2 && s != null)
				s = s + "@whi@ / 1 more option";
			if(menuItemsCount > 2 && s != null)
				s = s + "@whi@ / " + (menuItemsCount - 1) + " more options";
			if(s != null)
				surface.drawString(s, 6, 14, 1, 0xffff00);
			if(!aBoolean861 && mouseButtonClick == 1 || aBoolean861 && mouseButtonClick == 1 && menuItemsCount == 1) {
				menuAction(menuIdxs[0]);
				mouseButtonClick = 0;
				return;
			}
			if(!aBoolean861 && mouseButtonClick == 2 || aBoolean861 && mouseButtonClick == 1) {
				anInt726 = (menuItemsCount + 1) * 15;
				anInt722 = surface.textWidth("Choose option", 1) + 5;
				for(int k1 = 0; k1 < menuItemsCount; k1++) {
					int l1 = surface.textWidth(aStringArray727[k1] + " " + aStringArray728[k1], 1) + 5;
					if(l1 > anInt722)
						anInt722 = l1;
				}

				anInt720 = super.mouseX - anInt722 / 2;
				anInt721 = super.mouseY - 7;
				showRightClickMenu = true;
				if(anInt720 < 0)
					anInt720 = 0;
				if(anInt721 < 0)
					anInt721 = 0;
				if(anInt720 + anInt722 > gameWidth)
					anInt720 = gameWidth - anInt722;
				if(anInt721 + anInt726 > gameHeight)
					anInt721 = gameHeight - anInt726;
				mouseButtonClick = 0;
			}
		}
	}

	private void method81() {
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
		aPanel770.setFocus(anInt772);
	}

	private void loadData() {
		byte[] abyte0 = readDataFile("config" + Versions.anInt560 + ".jag", "Configuration", 10);
		if(abyte0 == null) {
			errorLoadingData = true;
			return;
		}
		Definitions.method128(abyte0, isMembers);
		byte[] abyte1 = readDataFile("filter" + Versions.anInt567 + ".jag", "Chat system", 15);
		if(abyte1 == null) {
			errorLoadingData = true;
        } else {
			byte[] abyte2 = DataUtils.loadData("fragmentsenc.txt", 0, abyte1);
			byte[] abyte3 = DataUtils.loadData("badenc.txt", 0, abyte1);
			byte[] abyte4 = DataUtils.loadData("hostenc.txt", 0, abyte1);
			byte[] abyte5 = DataUtils.loadData("tldlist.txt", 0, abyte1);
			//TODO: check
			//ChatFilter.method367(new ByteBuffer(abyte2), new ByteBuffer(abyte3), new ByteBuffer(abyte4), new ByteBuffer(abyte5));
        }
	}

	private void menuAction(int idx) {
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
			sendMessage(Definitions.aStringArray64[id], 3);
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
			sendMessage(Definitions.aStringArray116[id], 3);
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
			sendMessage(Definitions.aStringArray106[id], 3);
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
			sendMessage("Dropping " + Definitions.itemNames[inventoryItemsIDs[id]], 4);
		}
		if(opcode == 3600)
			sendMessage(Definitions.aStringArray64[id], 3);
		if(opcode == 700) {
			int l1 = (localX - 64) / magicLoc;
			int l3 = (localY - 64) / magicLoc;
			method106(sceneX, sceneY, l1, l3, true);
			super.packetStream.createPacket(50);
			super.packetStream.putShort(id);
			super.packetStream.putShort(sourceIdx);
			super.packetStream.endPacket();
			selectedSpell = -1;
		}
		if(opcode == 710) {
			int i2 = (localX - 64) / magicLoc;
			int i4 = (localY - 64) / magicLoc;
			method106(sceneX, sceneY, i2, i4, true);
			super.packetStream.createPacket(135);
			super.packetStream.putShort(id);
			super.packetStream.putShort(sourceIdx);
			super.packetStream.endPacket();
			selectedItemSlot = -1;
		}
		if(opcode == 720) {
			int j2 = (localX - 64) / magicLoc;
			int j4 = (localY - 64) / magicLoc;
			method106(sceneX, sceneY, j2, j4, true);
			super.packetStream.createPacket(153);
			super.packetStream.putShort(id);
			super.packetStream.endPacket();
		}
		if(opcode == 725) {
			int k2 = (localX - 64) / magicLoc;
			int k4 = (localY - 64) / magicLoc;
			method106(sceneX, sceneY, k2, k4, true);
			super.packetStream.createPacket(202);
			super.packetStream.putShort(id);
			super.packetStream.endPacket();
		}
		if(opcode == 715 || opcode == 2715) {
			int l2 = (localX - 64) / magicLoc;
			int l4 = (localY - 64) / magicLoc;
			method106(sceneX, sceneY, l2, l4, true);
			super.packetStream.createPacket(190);
			super.packetStream.putShort(id);
			super.packetStream.endPacket();
		}
		if(opcode == 3700)
			sendMessage(Definitions.aStringArray77[id], 3);
		if(opcode == 800) {
			int i3 = (localX - 64) / magicLoc;
			int i5 = (localY - 64) / magicLoc;
			method106(sceneX, sceneY, i3, i5, true);
			super.packetStream.createPacket(229);
			super.packetStream.putShort(id);
			super.packetStream.putShort(sourceIdx);
			super.packetStream.endPacket();
			selectedSpell = -1;
		}
		if(opcode == 810) {
			int j3 = (localX - 64) / magicLoc;
			int j5 = (localY - 64) / magicLoc;
			method106(sceneX, sceneY, j3, j5, true);
			super.packetStream.createPacket(113);
			super.packetStream.putShort(id);
			super.packetStream.putShort(sourceIdx);
			super.packetStream.endPacket();
			selectedItemSlot = -1;
		}
		if(opcode == 805 || opcode == 2805) {
			int k3 = (localX - 64) / magicLoc;
			int k5 = (localY - 64) / magicLoc;
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
			if(mouseClickXStep == -24)
				mouseClickXStep = 24;
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

	private void method84() {
		if(mouseButtonClick != 0) {
			mouseButtonClick = 0;
			if(anInt791 == 1 && (super.mouseX < 106 || super.mouseY < 145 || super.mouseX > 406 || super.mouseY > 215)) {
				anInt791 = 0;
				return;
			}
			if(anInt791 == 2 && (super.mouseX < 6 || super.mouseY < 145 || super.mouseX > 506 || super.mouseY > 215)) {
				anInt791 = 0;
				return;
			}
			if(anInt791 == 3 && (super.mouseX < 106 || super.mouseY < 145 || super.mouseX > 406 || super.mouseY > 215)) {
				anInt791 = 0;
				return;
			}
			if(super.mouseX > 236 && super.mouseX < 276 && super.mouseY > 193 && super.mouseY < 213) {
				anInt791 = 0;
				return;
			}
		}
		int i = 145;
		if(anInt791 == 1) {
			surface.method207(106, i, 300, 70, 0);
			surface.method214(106, i, 300, 70, 0xffffff);
			i += 20;
			surface.drawStringCenter("Enter name to add to friends list", 256, i, 4, 0xffffff);
			i += 20;
			surface.drawStringCenter(super.inputTextCurrent + "*", 256, i, 4, 0xffffff);
			if(super.inputTextFinal.length() > 0) {
				String s = super.inputTextFinal.trim();
				super.inputTextCurrent = "";
				super.inputTextFinal = "";
				anInt791 = 0;
				if(s.length() > 0 && DataUtils.method356(s) != localPlayer.hash)
					method29(s);
			}
		}
		if(anInt791 == 2) {
			surface.method207(6, i, 500, 70, 0);
			surface.method214(6, i, 500, 70, 0xffffff);
			i += 20;
			surface.drawStringCenter("Enter message to send to " + DataUtils.method351(aLong863), 256, i, 4, 0xffffff);
			i += 20;
			surface.drawStringCenter(super.inputPmCurrent + "*", 256, i, 4, 0xffffff);
			if(super.inputPmFinal.length() > 0) {
				String s1 = super.inputPmFinal;
				super.inputPmCurrent = "";
				super.inputPmFinal = "";
				anInt791 = 0;
				int k = ChatEncoding.scramble(s1);
				method27(aLong863, ChatEncoding.scrambledbytes, k);
				s1 = ChatEncoding.method388(ChatEncoding.scrambledbytes, 0, k);
				//s1 = ChatFilter.method380(s1);
				method44("@pri@You tell " + DataUtils.method351(aLong863) + ": " + s1);
			}
		}
		if(anInt791 == 3) {
			surface.method207(106, i, 300, 70, 0);
			surface.method214(106, i, 300, 70, 0xffffff);
			i += 20;
			surface.drawStringCenter("Enter name to add to ignore list", 256, i, 4, 0xffffff);
			i += 20;
			surface.drawStringCenter(super.inputTextCurrent + "*", 256, i, 4, 0xffffff);
			if(super.inputTextFinal.length() > 0) {
				String s2 = super.inputTextFinal.trim();
				super.inputTextCurrent = "";
				super.inputTextFinal = "";
				anInt791 = 0;
				if(s2.length() > 0 && DataUtils.method356(s2) != localPlayer.hash)
					method40(s2);
			}
		}
		int j = 0xffffff;
		if(super.mouseX > 236 && super.mouseX < 276 && super.mouseY > 193 && super.mouseY < 213)
			j = 0xffff00;
		surface.drawStringCenter("Cancel", 256, 208, 1, j);
	}

	private void method85() {
		byte[] abyte0 = null;
		byte[] abyte1 = null;
		abyte0 = readDataFile("entity" + Versions.anInt565 + ".jag", "people and monsters", 30);
		if(abyte0 == null) {
			errorLoadingData = true;
			return;
		}
		abyte1 = DataUtils.loadData("index.dat", 0, abyte0);
		byte[] abyte2 = null;
		byte[] abyte3 = null;
		if(isMembers) {
			abyte2 = readDataFile("entity" + Versions.anInt565 + ".mem", "member graphics", 45);
			if(abyte2 == null) {
				errorLoadingData = true;
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

			byte[] abyte7 = DataUtils.loadData(s + ".dat", 0, abyte0);
			byte[] abyte4 = abyte1;
			if(abyte7 == null && isMembers) {
				abyte7 = DataUtils.loadData(s + ".dat", 0, abyte2);
				abyte4 = abyte3;
			}
			if(abyte7 != null) {
				surface.method211(anInt865, abyte7, abyte4, 15);
				i += 15;
				if(Definitions.anIntArray101[j] == 1) {
					byte[] abyte8 = DataUtils.loadData(s + "a.dat", 0, abyte0);
					byte[] abyte5 = abyte1;
					if(abyte8 == null && isMembers) {
						abyte8 = DataUtils.loadData(s + "a.dat", 0, abyte2);
						abyte5 = abyte3;
					}
					surface.method211(anInt865 + 15, abyte8, abyte5, 3);
					i += 3;
				}
				if(Definitions.anIntArray102[j] == 1) {
					byte[] abyte9 = DataUtils.loadData(s + "f.dat", 0, abyte0);
					byte[] abyte6 = abyte1;
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

	private boolean method86(int i, int j) {
		if(i == 31 && (method115(197) || method115(615) || method115(682)))
			return true;
		if(i == 32 && (method115(102) || method115(616) || method115(683)))
			return true;
		if(i == 33 && (method115(101) || method115(617) || method115(684)))
			return true;
		if(i == 34 && (method115(103) || method115(618) || method115(685)))
			return true;
		return getInventoryItemCount(i) >= j;
	}

	private void drawUiTabSocial(boolean flag) {
		int i = surface.width2 - 199;
		int j = 36;
		surface.drawSprite(i - 49, 3, spriteMedia + 5);
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
		surface.drawHorizontalLine(i, j + 24, c, 0);
		surface.method217(i + c / 2, j, 24, 0);
		surface.drawHorizontalLine(i, (j + c1) - 16, c, 0);
		surface.drawStringCenter("Friends", i + c / 4, j + 16, 4, 0);
		surface.drawStringCenter("Ignore", i + c / 4 + c / 2, j + 16, 4, 0);
		panelSocialList.method154(controlListSocialPlayers);
		if(anInt866 == 0) {
			for(int i1 = 0; i1 < super.anInt603; i1++) {
				String s;
				if(super.friendListOnline[i1] == 255)
					s = "@gre@";
				else
				if(super.friendListOnline[i1] > 0)
					s = "@yel@";
				else
					s = "@red@";
				String nameX = "~" + (gameWidth - 195) + "~";
				String removeX = "~" + (gameWidth - 80) + "~";
				panelSocialList.method139(controlListSocialPlayers, i1,  nameX +  s + DataUtils.method351(super.friendListHashes[i1]) + removeX + "@whi@Remove            WWWWWWWWWW");
			}

		}
		if(anInt866 == 1) {
			for(int j1 = 0; j1 < super.anInt606; j1++) {
				String nameX = "~" + (gameWidth - 195) + "~";
				String removeX = "~" + (gameWidth - 80) + "~";
				panelSocialList.method139(controlListSocialPlayers, j1, nameX + "@yel@" + DataUtils.method351(super.ignoreList[j1]) + removeX + "@whi@Remove              WWWWWWWWWW");
			}
		}
		panelSocialList.method150();
		if(anInt866 == 0) {
			int k1 = panelSocialList.getListEntryIndex(controlListSocialPlayers);
			if(k1 >= 0 && super.mouseX < gameWidth - 20) {
				if(super.mouseX > gameWidth - 80)
					surface.drawStringCenter("Click to remove " + DataUtils.method351(super.friendListHashes[k1]), i + c / 2, j + 35, 1, 0xffffff);
				else
				if(super.friendListOnline[k1] == 255)
					surface.drawStringCenter("Click to message " + DataUtils.method351(super.friendListHashes[k1]), i + c / 2, j + 35, 1, 0xffffff);
				else
				if(super.friendListOnline[k1] > 0) {
					if(super.friendListOnline[k1] < 200)
						surface.drawStringCenter(DataUtils.method351(super.friendListHashes[k1]) + " is on world " + (super.friendListOnline[k1] - 9), i + c / 2, j + 35, 1, 0xffffff);
					else
						surface.drawStringCenter(DataUtils.method351(super.friendListHashes[k1]) + " is on classic " + (super.friendListOnline[k1] - 219), i + c / 2, j + 35, 1, 0xffffff);
				} else {
					surface.drawStringCenter(DataUtils.method351(super.friendListHashes[k1]) + " is offline", i + c / 2, j + 35, 1, 0xffffff);
				}
			} else {
				surface.drawStringCenter("Click a name to send a message", i + c / 2, j + 35, 1, 0xffffff);
			}
			int k2;
			if(super.mouseX > i && super.mouseX < i + c && super.mouseY > (j + c1) - 16 && super.mouseY < j + c1)
				k2 = 0xffff00;
			else
				k2 = 0xffffff;
			surface.drawStringCenter("Click here to add a friend", i + c / 2, (j + c1) - 3, 1, k2);
		}
		if(anInt866 == 1) {
			int l1 = panelSocialList.getListEntryIndex(controlListSocialPlayers);
			if(l1 >= 0 && super.mouseX < gameWidth - 20 && super.mouseX > gameWidth - 80) {
				if(super.mouseX > gameWidth - 80)
					surface.drawStringCenter("Click to remove " + DataUtils.method351(super.ignoreList[l1]), i + c / 2, j + 35, 1, 0xffffff);
			} else {
				surface.drawStringCenter("Blocking messages from:", i + c / 2, j + 35, 1, 0xffffff);
			}
			int l2;
			if(super.mouseX > i && super.mouseX < i + c && super.mouseY > (j + c1) - 16 && super.mouseY < j + c1)
				l2 = 0xffff00;
			else
				l2 = 0xffffff;
			surface.drawStringCenter("Click here to add a name", i + c / 2, (j + c1) - 3, 1, l2);
		}
		if(!flag)
			return;
		i = super.mouseX - (gameWidth - 199);
		j = super.mouseY - 36;
		if(i >= 0 && j >= 0 && i < 196 && j < 182) {
			panelSocialList.handleMouse(i + (gameWidth - 199), j + 36, super.lastMouseButtonDown, super.mouseButtonDown);
			if(j <= 24 && mouseButtonClick == 1)
				if(i < 98 && anInt866 == 1) {
					anInt866 = 0;
					panelSocialList.method162(controlListSocialPlayers);
				} else
				if(i > 98 && anInt866 == 0) {
					anInt866 = 1;
					panelSocialList.method162(controlListSocialPlayers);
				}
			if(mouseButtonClick == 1 && anInt866 == 0) {
				int i2 = panelSocialList.getListEntryIndex(controlListSocialPlayers);
				String nameX = "~" + (gameWidth - 195) + "~";
				String removeX = "~" + (gameWidth - 80) + "~";
				if(i2 >= 0 && super.mouseX < gameWidth)
					if(super.mouseX > (gameWidth - 80))
						method21(super.friendListHashes[i2]);
					else
					if(super.friendListOnline[i2] != 0) {
						anInt791 = 2;
						aLong863 = super.friendListHashes[i2];
						super.inputPmCurrent = "";
						super.inputPmFinal = "";
					}
			}
			if(mouseButtonClick == 1 && anInt866 == 1) {
				int j2 = panelSocialList.getListEntryIndex(controlListSocialPlayers);
				if(j2 >= 0 && super.mouseX > (gameWidth - 80) )
					method23(super.ignoreList[j2]);
			}
			if(j > 166 && mouseButtonClick == 1 && anInt866 == 0) {
				anInt791 = 1;
				super.inputTextCurrent = "";
				super.inputTextFinal = "";
			}
			if(j > 166 && mouseButtonClick == 1 && anInt866 == 1) {
				anInt791 = 3;
				super.inputTextCurrent = "";
				super.inputTextFinal = "";
			}
			mouseButtonClick = 0;
		}
	}

	private void disposeAndCollect() {
		try {
			if(surface != null) {
				surface.method249();
				surface.pixels = null;
				surface = null;
			}
			if(scene != null) {
				scene.method306();
				scene = null;
			}
			gameModels = null;
			objectModel = null;
			aModelArray821 = null;
			aCharacterArray806 = null;
			players = null;
			aCharacterArray716 = null;
			npcs = null;
			localPlayer = null;
			if(world != null) {
				world.aModelArray578 = null;
				world.aModelArrayArray597 = null;
				world.roofModels = null;
				world.aModel591 = null;
				world = null;
			}
			System.gc();
        }
		catch(Exception _ex) {
        }
	}

	private void drawUiTabOptions(boolean flag) {
		int i = surface.width2 - 199;
		int j = 36;
		surface.drawSprite(i - 49, 3, spriteMedia + 6);
		char c = '\304';
		surface.method224(i, 36, c, 65, Surface.method222(181, 181, 181), 160);
		surface.method224(i, 101, c, 65, Surface.method222(201, 201, 201), 160);
		surface.method224(i, 166, c, 95, Surface.method222(181, 181, 181), 160);
		surface.method224(i, 261, c, 40, Surface.method222(201, 201, 201), 160);
		int k = i + 3;
		int i1 = j + 15;
		surface.drawString("Game options - click to toggle", k, i1, 1, 0);
		i1 += 15;
		if(optionCameraModeAuto)
			surface.drawString("Camera angle mode - @gre@Auto", k, i1, 1, 0xffffff);
		else
			surface.drawString("Camera angle mode - @red@Manual", k, i1, 1, 0xffffff);
		i1 += 15;
		if(aBoolean861)
			surface.drawString("Mouse buttons - @red@One", k, i1, 1, 0xffffff);
		else
			surface.drawString("Mouse buttons - @gre@Two", k, i1, 1, 0xffffff);
		i1 += 15;
		if(isMembers)
			if(aBoolean784)
				surface.drawString("Sound effects - @red@off", k, i1, 1, 0xffffff);
			else
				surface.drawString("Sound effects - @gre@on", k, i1, 1, 0xffffff);
		i1 += 15;
		surface.drawString("To change your contact details,", k, i1, 0, 0xffffff);
		i1 += 15;
		surface.drawString("password, recovery questions, etc..", k, i1, 0, 0xffffff);
		i1 += 15;
		surface.drawString("please select 'account management'", k, i1, 0, 0xffffff);
		i1 += 15;
		if(anInt862 == 0)
			surface.drawString("from the runescape.com front page", k, i1, 0, 0xffffff);
		else
		if(anInt862 == 1)
			surface.drawString("from the link below the gamewindow", k, i1, 0, 0xffffff);
		else
			surface.drawString("from the runescape front webpage", k, i1, 0, 0xffffff);
		i1 += 15;
		i1 += 5;
		surface.drawString("Privacy settings. Will be applied to", i + 3, i1, 1, 0);
		i1 += 15;
		surface.drawString("all people not on your friends list", i + 3, i1, 1, 0);
		i1 += 15;
		if(super.anInt609 == 0)
			surface.drawString("Block chat messages: @red@<off>", i + 3, i1, 1, 0xffffff);
		else
			surface.drawString("Block chat messages: @gre@<on>", i + 3, i1, 1, 0xffffff);
		i1 += 15;
		if(super.anInt610 == 0)
			surface.drawString("Block private messages: @red@<off>", i + 3, i1, 1, 0xffffff);
		else
			surface.drawString("Block private messages: @gre@<on>", i + 3, i1, 1, 0xffffff);
		i1 += 15;
		if(super.anInt611 == 0)
			surface.drawString("Block trade requests: @red@<off>", i + 3, i1, 1, 0xffffff);
		else
			surface.drawString("Block trade requests: @gre@<on>", i + 3, i1, 1, 0xffffff);
		i1 += 15;
		if(isMembers)
			if(super.anInt612 == 0)
				surface.drawString("Block duel requests: @red@<off>", i + 3, i1, 1, 0xffffff);
			else
				surface.drawString("Block duel requests: @gre@<on>", i + 3, i1, 1, 0xffffff);
		i1 += 15;
		i1 += 5;
		surface.drawString("Always logout when you finish", k, i1, 1, 0);
		i1 += 15;
		int k1 = 0xffffff;
		if(super.mouseX > k && super.mouseX < k + c && super.mouseY > i1 - 12 && super.mouseY < i1 + 4)
			k1 = 0xffff00;
		surface.drawString("Click here to logout", i + 3, i1, 1, k1);
		if(!flag)
			return;
		i = super.mouseX - (surface.width2 - 199);
		j = super.mouseY - 36;
		if(i >= 0 && j >= 0 && i < 196 && j < 265) {
			int l1 = surface.width2 - 199;
			byte byte0 = 36;
			char c1 = '\304';
			int l = l1 + 3;
			int j1 = byte0 + 30;
			if(super.mouseX > l && super.mouseX < l + c1 && super.mouseY > j1 - 12 && super.mouseY < j1 + 4 && mouseButtonClick == 1) {
				optionCameraModeAuto = !optionCameraModeAuto;
				super.packetStream.createPacket(111);
				super.packetStream.putByte(0);
				super.packetStream.putByte(optionCameraModeAuto ? 1 : 0);
				super.packetStream.endPacket();
			}
			j1 += 15;
			if(super.mouseX > l && super.mouseX < l + c1 && super.mouseY > j1 - 12 && super.mouseY < j1 + 4 && mouseButtonClick == 1) {
				aBoolean861 = !aBoolean861;
				super.packetStream.createPacket(111);
				super.packetStream.putByte(2);
				super.packetStream.putByte(aBoolean861 ? 1 : 0);
				super.packetStream.endPacket();
			}
			j1 += 15;
			if(isMembers && super.mouseX > l && super.mouseX < l + c1 && super.mouseY > j1 - 12 && super.mouseY < j1 + 4 && mouseButtonClick == 1) {
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
			if(super.mouseX > l && super.mouseX < l + c1 && super.mouseY > j1 - 12 && super.mouseY < j1 + 4 && mouseButtonClick == 1) {
				super.anInt609 = 1 - super.anInt609;
				flag1 = true;
			}
			j1 += 15;
			if(super.mouseX > l && super.mouseX < l + c1 && super.mouseY > j1 - 12 && super.mouseY < j1 + 4 && mouseButtonClick == 1) {
				super.anInt610 = 1 - super.anInt610;
				flag1 = true;
			}
			j1 += 15;
			if(super.mouseX > l && super.mouseX < l + c1 && super.mouseY > j1 - 12 && super.mouseY < j1 + 4 && mouseButtonClick == 1) {
				super.anInt611 = 1 - super.anInt611;
				flag1 = true;
			}
			j1 += 15;
			if(isMembers && super.mouseX > l && super.mouseX < l + c1 && super.mouseY > j1 - 12 && super.mouseY < j1 + 4 && mouseButtonClick == 1) {
				super.anInt612 = 1 - super.anInt612;
				flag1 = true;
			}
			j1 += 15;
			if(flag1)
				method33(super.anInt609, super.anInt610, super.anInt611, super.anInt612);
			j1 += 20;
			if(super.mouseX > l && super.mouseX < l + c1 && super.mouseY > j1 - 12 && super.mouseY < j1 + 4 && mouseButtonClick == 1)
				logout();
			mouseButtonClick = 0;
		}
	}

	private String method90(int i) {
		if(link.mainapp != null)
			return link.gethostname(DataUtils.method349(i));
		else
			return DataUtils.method349(i);
	}

	private void createMessageTabPanel() {
		panelMessageTabs = new Panel(surface, 10);
		controlTextListChat = panelMessageTabs.addTextList(5, gameHeight - 74, gameWidth, 56, 1, 20, true);
		controlTextListAll = panelMessageTabs.addTextListInput(7, gameHeight - 80, gameWidth, 14, 1, 80, false, true);
		controlTextListQuest = panelMessageTabs.addTextList(5, gameHeight - 74, gameWidth, 56, 1, 20, true);
		controlTextListPrivate = panelMessageTabs.addTextList(5, gameHeight - 74, gameWidth, 56, 1, 20, true);
		panelMessageTabs.setFocus(controlTextListAll);
	}

	protected void lostConnection() {
		systemUpdateTimer = 0;
		if(logoutTimeout != 0) {
			method24();
        } else {
			super.lostConnection();
        }
	}

	protected void method43(int i, int j, byte[] buffer) {
		try {
			if(i == 191) {
				anInt808 = playerCount;
                if (anInt808 >= 0) System.arraycopy(players, 0, aCharacterArray807, 0, anInt808);

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
				int l22 = sceneX * magicLoc + 64;
				int l25 = sceneY * magicLoc + 64;
				if(flag1) {
					localPlayer.waypointCurrent = 0;
					localPlayer.movingStep = 0;
					localPlayer.currentX = localPlayer.waypointsX[0] = l22;
					localPlayer.currentY = localPlayer.waypointsY[0] = l25;
				}
				playerCount = 0;
				localPlayer = method70(localPlayerServerIdx, l22, l25, l13);
				int i29 = DataUtils.method350(buffer, k7, 8);
				k7 += 8;
				for(int l33 = 0; l33 < i29; l33++) {
					Character rscharacter3 = aCharacterArray807[l33 + 1];
					int k39 = DataUtils.method350(buffer, k7, 1);
					k7++;
					if(k39 != 0) {
						int k41 = DataUtils.method350(buffer, k7, 1);
						k7++;
						if(k41 == 0) {
							int l42 = DataUtils.method350(buffer, k7, 3);
							k7 += 3;
							int l43 = rscharacter3.waypointCurrent;
							int j44 = rscharacter3.waypointsX[l43];
							int k44 = rscharacter3.waypointsY[l43];
							if(l42 == 2 || l42 == 1 || l42 == 3)
								j44 += magicLoc;
							if(l42 == 6 || l42 == 5 || l42 == 7)
								j44 -= magicLoc;
							if(l42 == 4 || l42 == 3 || l42 == 5)
								k44 += magicLoc;
							if(l42 == 0 || l42 == 1 || l42 == 7)
								k44 -= magicLoc;
							rscharacter3.nextAnimation = l42;
							rscharacter3.waypointCurrent = l43 = (l43 + 1) % 10;
							rscharacter3.waypointsX[l43] = j44;
							rscharacter3.waypointsY[l43] = k44;
						} else {
							int i43 = DataUtils.method350(buffer, k7, 4);
							if((i43 & 0xc) == 12) {
								k7 += 2;
								continue;
							}
							rscharacter3.nextAnimation = DataUtils.method350(buffer, k7, 4);
							k7 += 4;
						}
					}
					players[playerCount++] = rscharacter3;
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
					int i23 = (sceneX + l41) * magicLoc + 64;
					int i26 = (sceneY + j43) * magicLoc + 64;
					method70(l39, i23, i26, i14);
					if(i44 == 0)
						anIntArray872[i37++] = l39;
				}
				if(i37 > 0) {
					super.packetStream.createPacket(163);
					super.packetStream.putShort(i37);
					for(int i40 = 0; i40 < i37; i40++) {
						Character rscharacter4 = aCharacterArray806[anIntArray872[i40]];
						super.packetStream.putShort(rscharacter4.serverIndex);
						super.packetStream.putShort(rscharacter4.serverID);
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
							for(int k23 = 0; k23 < objectCount; k23++) {
								if(objectX[k23] != k14 || objectY[k23] != j19)
									continue;
								anIntArray873[anInt762] = Definitions.anIntArray113[objectID[k23]];
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
						for(int i24 = 0; i24 < objectCount; i24++) {
							int l26 = (objectX[i24] >> 3) - l14;
							int k29 = (objectY[i24] >> 3) - k19;
							if(l26 != 0 || k29 != 0) {
								if(i24 != j8) {
									objectModel[j8] = objectModel[i24];
									objectModel[j8].key = j8;
									objectX[j8] = objectX[i24];
									objectY[j8] = objectY[i24];
									objectID[j8] = objectID[i24];
									objectDirection[j8] = objectDirection[i24];
								}
								j8++;
							} else {
								scene.removeModel(objectModel[i24]);
								world.method390(objectX[i24], objectY[i24], objectID[i24]);
							}
						}

						objectCount = j8;
					} else {
						int id = DataUtils.method344(buffer, i1);
						i1 += 2;
						int lx = sceneX + buffer[i1++];
						int ly = sceneY + buffer[i1++];
						int j24 = 0;
						for(int i27 = 0; i27 < objectCount; i27++)
							if(objectX[i27] != lx || objectY[i27] != ly) {
								if(i27 != j24) {
									objectModel[j24] = objectModel[i27];
									objectModel[j24].key = j24;
									objectX[j24] = objectX[i27];
									objectY[j24] = objectY[i27];
									objectID[j24] = objectID[i27];
									objectDirection[j24] = objectDirection[i27];
								}
								j24++;
							} else {
								scene.removeModel(objectModel[i27]);
								world.method390(objectX[i27], objectY[i27], objectID[i27]);
							}

						objectCount = j24;
						if(id != 60000) {
							int direction = world.getTileDirection(lx, ly);
							int width;
							int height;
							if(direction == 0 || direction == 4) {
								width = Definitions.objectWidth[id];
								height = Definitions.objectHeight[id];
							} else {
								height = Definitions.objectWidth[id];
								width = Definitions.objectHeight[id];
							}
							int j40 = ((lx + lx + width) * magicLoc) / 2;
							int i42 = ((ly + ly + height) * magicLoc) / 2;
							int modelIdx = Definitions.objectModelIndex[id];
							Model model = gameModels[modelIdx].copy();
							if (injected)
								setModelData(model, id, (lx * 128) + 64, (ly * 128) + 64, width, false);
							scene.addModel(model);
							model.key = objectCount;
							model.rotate(0, direction * 32, 0);
							model.translate(j40, -world.method410(j40, i42), i42);
							model.setLight(true, 48, 48, -50, -10, -50);
							world.removeObject2(lx, ly, id);
							if(id == 74)
								model.translate(0, -480, 0);
							objectX[objectCount] = lx;
							objectY[objectCount] = ly;
							objectID[objectCount] = id;
							objectDirection[objectCount] = direction;
							objectModel[objectCount++] = model;
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
					Character rscharacter = aCharacterArray806[i20];
					byte byte6 = buffer[i9];
					i9++;
					if(byte6 == 0) {
						int i30 = DataUtils.method344(buffer, i9);
						i9 += 2;
						if(rscharacter != null) {
							rscharacter.bubbleTimeout = 150;
							rscharacter.bubbleItem = i30;
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
                                if (super.ignoreList[k40] == rscharacter.hash) {
                                    flag3 = true;
                                    break;
                                }

							if(!flag3) {
								rscharacter.messageTimeout = 150;
								rscharacter.message = s2;
								sendMessage(rscharacter.name + ": " + rscharacter.message, 2);
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
							rscharacter.damageTaken = j30;
							rscharacter.currentHealth = j34;
							rscharacter.maxHealth = k37;
							rscharacter.combatTimer = 200;
							if(rscharacter == localPlayer) {
								boostedSkillLevels[3] = j34;
								realSkillLevels[3] = k37;
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
							rscharacter.incomingProjectileSprite = k30;
							rscharacter.attackingNpcServerIndex = k34;
							rscharacter.attackingPlayerServerIndex = -1;
							rscharacter.projectileRange = anInt876;
						}
					} else
					if(byte6 == 4) {
						int l30 = DataUtils.method344(buffer, i9);
						i9 += 2;
						int l34 = DataUtils.method344(buffer, i9);
						i9 += 2;
						if(rscharacter != null) {
							rscharacter.incomingProjectileSprite = l30;
							rscharacter.attackingPlayerServerIndex = l34;
							rscharacter.attackingNpcServerIndex = -1;
							rscharacter.projectileRange = anInt876;
						}
					} else
					if(byte6 == 5) {
						if(rscharacter != null) {
							rscharacter.serverID = DataUtils.method344(buffer, i9);
							i9 += 2;
							rscharacter.hash = DataUtils.method348(buffer, i9);
							i9 += 8;
							rscharacter.name = DataUtils.method351(rscharacter.hash);
							int i31 = DataUtils.method340(buffer[i9]);
							i9++;
							for(int i35 = 0; i35 < i31; i35++) {
								rscharacter.equipment[i35] = DataUtils.method340(buffer[i9]);
								i9++;
							}

							for(int l37 = i31; l37 < 12; l37++)
								rscharacter.equipment[l37] = 0;

							rscharacter.hairColor = buffer[i9++] & 0xff;
							rscharacter.topColor = buffer[i9++] & 0xff;
							rscharacter.bottomColor = buffer[i9++] & 0xff;
							rscharacter.skinColor = buffer[i9++] & 0xff;
							rscharacter.combatLevel = buffer[i9++] & 0xff;
							rscharacter.skullVisible = buffer[i9++] & 0xff;
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
							rscharacter.messageTimeout = 150;
							rscharacter.message = s3;
							if(rscharacter == localPlayer)
								sendMessage(rscharacter.name + ": " + rscharacter.message, 5);
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
									aModelArray821[j9].key = j9 + 10000;
									anIntArray822[j9] = anIntArray822[k24];
									anIntArray823[j9] = anIntArray823[k24];
									wallObjectDirection[j9] = wallObjectDirection[k24];
									wallObjectID[j9] = wallObjectID[k24];
								}
								j9++;
							} else {
								scene.removeModel(aModelArray821[k24]);
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
									aModelArray821[k27].key = k27 + 10000;
									anIntArray822[k27] = anIntArray822[l31];
									anIntArray823[k27] = anIntArray823[l31];
									wallObjectDirection[k27] = wallObjectDirection[l31];
									wallObjectID[k27] = wallObjectID[l31];
								}
								k27++;
							} else {
								scene.removeModel(aModelArray821[l31]);
								world.method391(anIntArray822[l31], anIntArray823[l31], wallObjectDirection[l31], wallObjectID[l31]);
							}

						anInt826 = k27;
						if(k9 != 65535) {
							world.method401(i16, k20, byte5, k9);
							Model model = createModel(i16, k20, byte5, k9, anInt826);
							if (injected)
								setModelData(model, k9, (i16 * 128) + 64, (k20 * 128) + 64, 1, true);
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
                if (anInt718 >= 0) System.arraycopy(npcs, 0, aCharacterArray717, 0, anInt718);

				int l9 = 8;
				int j16 = DataUtils.method350(buffer, l9, 8);
				l9 += 8;
				for(int l20 = 0; l20 < j16; l20++) {
					Character rscharacter1 = aCharacterArray717[l20];
					int l27 = DataUtils.method350(buffer, l9, 1);
					l9++;
					if(l27 != 0) {
						int i32 = DataUtils.method350(buffer, l9, 1);
						l9++;
						if(i32 == 0) {
							int j35 = DataUtils.method350(buffer, l9, 3);
							l9 += 3;
							int i38 = rscharacter1.waypointCurrent;
							int l40 = rscharacter1.waypointsX[i38];
							int j42 = rscharacter1.waypointsY[i38];
							if(j35 == 2 || j35 == 1 || j35 == 3)
								l40 += magicLoc;
							if(j35 == 6 || j35 == 5 || j35 == 7)
								l40 -= magicLoc;
							if(j35 == 4 || j35 == 3 || j35 == 5)
								j42 += magicLoc;
							if(j35 == 0 || j35 == 1 || j35 == 7)
								j42 -= magicLoc;
							rscharacter1.nextAnimation = j35;
							rscharacter1.waypointCurrent = i38 = (i38 + 1) % 10;
							rscharacter1.waypointsX[i38] = l40;
							rscharacter1.waypointsY[i38] = j42;
						} else {
							int k35 = DataUtils.method350(buffer, l9, 4);
							if((k35 & 0xc) == 12) {
								l9 += 2;
								continue;
							}
							rscharacter1.nextAnimation = DataUtils.method350(buffer, l9, 4);
							l9 += 4;
						}
					}
					npcs[npcCount++] = rscharacter1;
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
					int j38 = (sceneX + i28) * magicLoc + 64;
					int i41 = (sceneY + j32) * magicLoc + 64;
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
					Character rscharacter2 = aCharacterArray716[i21];
					int j28 = DataUtils.method340(buffer[i10]);
					i10++;
					if(j28 == 1) {
						int k32 = DataUtils.method344(buffer, i10);
						i10 += 2;
						byte byte9 = buffer[i10];
						i10++;
						if(rscharacter2 != null) {
							String s4 = ChatEncoding.method388(buffer, i10, byte9);
							rscharacter2.messageTimeout = 150;
							rscharacter2.message = s4;
							if(k32 == localPlayer.serverIndex)
								sendMessage("@yel@" + Definitions.npcName[rscharacter2.npcID] + ": " + rscharacter2.message, 5);
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
							rscharacter2.damageTaken = l32;
							rscharacter2.currentHealth = i36;
							rscharacter2.maxHealth = k38;
							rscharacter2.combatTimer = 200;
						}
					}
				}

				return;
			}
			if(i == 245) {
				showOptionMenu = true;
				int k2 = DataUtils.method340(buffer[1]);
				optionMenuCount = k2;
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
				showOptionMenu = false;
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
					boostedSkillLevels[k10] = DataUtils.method340(buffer[l2++]);

				for(int i17 = 0; i17 < 18; i17++)
					realSkillLevels[i17] = DataUtils.method340(buffer[l2++]);

				for(int k21 = 0; k21 < 18; k21++) {
					skillXPs[k21] = DataUtils.method343(buffer, l2);
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
				deathScreenTimeout = 250;
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
					for(int j33 = 0; j33 < objectCount; j33++) {
						int k36 = (objectX[j33] >> 3) - j17;
						int l38 = (objectY[j33] >> 3) - l21;
						if(k36 != 0 || l38 != 0) {
							if(j33 != i25) {
								objectModel[i25] = objectModel[j33];
								objectModel[i25].key = i25;
								objectX[i25] = objectX[j33];
								objectY[i25] = objectY[j33];
								objectID[i25] = objectID[j33];
								objectDirection[i25] = objectDirection[j33];
							}
							i25++;
						} else {
							scene.removeModel(objectModel[j33]);
							world.method390(objectX[j33], objectY[j33], objectID[j33]);
						}
					}

					objectCount = i25;
					i25 = 0;
					for(int l36 = 0; l36 < anInt826; l36++) {
						int i39 = (anIntArray822[l36] >> 3) - j17;
						int j41 = (anIntArray823[l36] >> 3) - l21;
						if(i39 != 0 || j41 != 0) {
							if(l36 != i25) {
								aModelArray821[i25] = aModelArray821[l36];
								aModelArray821[i25].key = i25 + 10000;
								anIntArray822[i25] = anIntArray822[l36];
								anIntArray823[i25] = anIntArray823[l36];
								wallObjectDirection[i25] = wallObjectDirection[l36];
								wallObjectID[i25] = wallObjectID[l36];
							}
							i25++;
						} else {
							scene.removeModel(aModelArray821[l36]);
							world.method391(anIntArray822[l36], anIntArray823[l36], wallObjectDirection[l36], wallObjectID[l36]);
						}
					}

					anInt826 = i25;
				}

				return;
			}
			if(i == 59) {
				changeAppearanceVisible = true;
				return;
			}
			if(i == 92) {
				int k3 = DataUtils.method344(buffer, 1);
				if(aCharacterArray806[k3] != null)
					aString884 = aCharacterArray806[k3].name;
				showDialogTrade = true;
				aBoolean885 = false;
				aBoolean886 = false;
				anInt887 = 0;
				anInt888 = 0;
				return;
			}
			if(i == 128) {
				showDialogTrade = false;
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
				shopPriceMod = buffer[i4++] & 0xff;
				for(int i22 = 0; i22 < 40; i22++)
					shopCategoryID[i22] = -1;

				for(int j25 = 0; j25 < j11; j25++) {
					shopCategoryID[j25] = DataUtils.method344(buffer, i4);
					i4 += 2;
					shopItemQuantities[j25] = DataUtils.method344(buffer, i4);
					i4 += 2;
					shopItemPrices[j25] = buffer[i4++];
				}

				if(byte4 == 1) {
					int l28 = 39;
					for(int k33 = 0; k33 < inventorySize; k33++) {
						if(l28 < j11)
							break;
						boolean flag2 = false;
						for(int j39 = 0; j39 < 40; j39++) {
							if(shopCategoryID[j39] != inventoryItemsIDs[k33])
								continue;
							flag2 = true;
							break;
						}

						if(inventoryItemsIDs[k33] == 10)
							flag2 = true;
						if(!flag2) {
							shopCategoryID[l28] = inventoryItemsIDs[k33] & 0x7fff;
							shopItemQuantities[l28] = 0;
							shopItemPrices[l28] = 0;
							l28--;
						}
					}

				}
				if(shopSelectedItemIndex >= 0 && shopSelectedItemIndex < 40 && shopCategoryID[shopSelectedItemIndex] != shopSelectedItemType) {
					shopSelectedItemIndex = -1;
					shopSelectedItemType = -2;
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
				optionCameraModeAuto = DataUtils.method340(buffer[1]) == 1;
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
				skillXPs[i5] = DataUtils.method343(buffer, 2);
				return;
			}
			if(i == 176) {
				int j5 = DataUtils.method344(buffer, 1);
				if(aCharacterArray806[j5] != null)
					aString892 = aCharacterArray806[j5].name;
				showDialogDuel = true;
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
				showDialogDuel = false;
				aBoolean816 = false;
				return;
			}
			if(i == 20) {
				showDialogTradeConfirm = true;
				tradeConfirmAccepted = false;
				showDialogTrade = false;
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
                aBoolean897 = buffer[1] == 1;
                aBoolean898 = buffer[2] == 1;
                aBoolean899 = buffer[3] == 1;
                aBoolean900 = buffer[4] == 1;
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
				boostedSkillLevels[i13] = DataUtils.method340(buffer[l6++]);
				realSkillLevels[i13] = DataUtils.method340(buffer[l6++]);
				skillXPs[i13] = DataUtils.method343(buffer, l6);
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
				showDialogDuel = false;
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
				if(teleportBubbleCount < 50) {
					int j7 = buffer[1] & 0xff;
					int k13 = buffer[2] + sceneX;
					int k18 = buffer[3] + sceneY;
					teleportBubbleType[teleportBubbleCount] = j7;
					teleportBubbleTime[teleportBubbleCount] = 0;
					teleportBubbleX[teleportBubbleCount] = k13;
					teleportBubbleY[teleportBubbleCount] = k18;
					teleportBubbleCount++;
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
				statFatigue = DataUtils.method344(buffer, 1);
				return;
			}
			if(i == 117) {
				if(!isSleeping)
					anInt932 = statFatigue;
				isSleeping = true;
				super.inputTextCurrent = "";
				super.inputTextFinal = "";
				surface.method234(anInt933 + 1, buffer);
				sleepingStatusText = null;
				return;
			}
			if(i == 244) {
				anInt932 = DataUtils.method344(buffer, 1);
				return;
			}
			if(i == 84) {
				isSleeping = false;
				return;
			}
			if(i == 194) {
				sleepingStatusText = "Incorrect - Please wait...";
				return;
			}
			if(i == 52) {
				systemUpdateTimer = DataUtils.method344(buffer, 1) * 32;
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
				super.packetStream.method329("rx:" + sceneX + " ry:" + sceneY + " num3l:" + objectCount);
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

	protected void method2() {
		closeConnection();
		disposeAndCollect();
	}

	private boolean method92(int i, int j, int k, int l, int i1, int j1, boolean flag,
                             boolean flag1) {
		int k1 = world.method398(i, j, k, l, i1, j1, walkPathX, walkPathY, flag);
		if(k1 == -1)
			return false;
		k1--;
		i = walkPathX[k1];
		j = walkPathY[k1];
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
			super.packetStream.putByte(walkPathX[l1] - i);
			super.packetStream.putByte(walkPathY[l1] - j);
		}

		super.packetStream.endPacket();
		mouseClickXStep = -24;
		anInt801 = super.mouseX;
		anInt802 = super.mouseY;
		return true;
	}

	private boolean method93(int i, int j) {
		if(deathScreenTimeout != 0) {
			world.aBoolean572 = false;
			return false;
		}
		aBoolean877 = false;
		i += anInt829;
		j += anInt828;
		if(plane == anInt878 && i > anInt937 && i < anInt938 && j > anInt939 && j < anInt940) {
			world.aBoolean572 = true;
			return false;
		}
		surface.drawStringCenter("Loading... Please wait", 256, 192, 1, 0xffffff);
		method76();
		surface.draw(graphics, 0, 0);
		int k = baseX;
		int l = baseY;
		int i1 = (i + 24) / 48;
		int j1 = (j + 24) / 48;
		plane = anInt878;
		baseX = i1 * 48 - 48;
		baseY = j1 * 48 - 48;
		anInt937 = i1 * 48 - 32;
		anInt939 = j1 * 48 - 32;
		anInt938 = i1 * 48 + 32;
		anInt940 = j1 * 48 + 32;
		world.method399(i, j, plane);
		baseX -= anInt829;
		baseY -= anInt828;
		int k1 = baseX - k;
		int l1 = baseY - l;
		for(int i2 = 0; i2 < objectCount; i2++) {
			objectX[i2] -= k1;
			objectY[i2] -= l1;
			int j2 = objectX[i2];
			int l2 = objectY[i2];
			int k3 = objectID[i2];
			Model model = objectModel[i2];
			try {
				int l4 = objectDirection[i2];
				int k5;
				int i6;
				if(l4 == 0 || l4 == 4) {
					k5 = Definitions.objectWidth[k3];
					i6 = Definitions.objectHeight[k3];
				} else {
					i6 = Definitions.objectWidth[k3];
					k5 = Definitions.objectHeight[k3];
				}
				int j6 = ((j2 + j2 + k5) * magicLoc) / 2;
				int k6 = ((l2 + l2 + i6) * magicLoc) / 2;
				if(j2 >= 0 && l2 >= 0 && j2 < 96 && l2 < 96) {
					scene.addModel(model);
					model.method177(j6, -world.method410(j6, k6), k6);
					world.removeObject2(j2, l2, k3);
					if(k3 == 74)
						model.translate(0, -480, 0);
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
				Model model1 = createModel(i3, l3, i5, j4, k2);
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
			Character rscharacter = players[i4];
			rscharacter.currentX -= k1 * magicLoc;
			rscharacter.currentY -= l1 * magicLoc;
			for(int j5 = 0; j5 <= rscharacter.waypointCurrent; j5++) {
				rscharacter.waypointsX[j5] -= k1 * magicLoc;
				rscharacter.waypointsY[j5] -= l1 * magicLoc;
			}

		}

		for(int k4 = 0; k4 < npcCount; k4++) {
			Character rscharacter1 = npcs[k4];
			rscharacter1.currentX -= k1 * magicLoc;
			rscharacter1.currentY -= l1 * magicLoc;
			for(int l5 = 0; l5 <= rscharacter1.waypointCurrent; l5++) {
				rscharacter1.waypointsX[l5] -= k1 * magicLoc;
				rscharacter1.waypointsY[l5] -= l1 * magicLoc;
			}

		}

		world.aBoolean572 = true;
		return true;
	}

	private void method94() {
		surface.method207(126, 137, 260, 60, 0);
		surface.method214(126, 137, 260, 60, 0xffffff);
		surface.drawStringCenter("Logging out...", 256, 173, 5, 0xffffff);
	}

	private void method95() {
		world.aByteArray588 = readDataFile("maps" + Versions.anInt561 + ".jag", "map", 70);
		if(isMembers)
			world.aByteArray589 = readDataFile("maps" + Versions.anInt561 + ".mem", "members map", 75);
		world.aByteArray586 = readDataFile("land" + Versions.anInt561 + ".jag", "landscape", 80);
		if(isMembers)
			world.aByteArray587 = readDataFile("land" + Versions.anInt561 + ".mem", "members landscape", 85);
	}

	private void method96() {
		byte[] abyte0 = readDataFile("media" + Versions.anInt562 + ".jag", "2d graphics", 20);
		if(abyte0 == null) {
			errorLoadingData = true;
			return;
		}
		byte[] abyte1 = DataUtils.loadData("index.dat", 0, abyte0);
		surface.method211(spriteMedia, DataUtils.loadData("inv1.dat", 0, abyte0), abyte1, 1);
		surface.method211(spriteMedia + 1, DataUtils.loadData("inv2.dat", 0, abyte0), abyte1, 6);
		surface.method211(spriteMedia + 9, DataUtils.loadData("bubble.dat", 0, abyte0), abyte1, 1);
		surface.method211(spriteMedia + 10, DataUtils.loadData("runescape.dat", 0, abyte0), abyte1, 1);
		surface.method211(spriteMedia + 11, DataUtils.loadData("splat.dat", 0, abyte0), abyte1, 3);
		surface.method211(spriteMedia + 14, DataUtils.loadData("icon.dat", 0, abyte0), abyte1, 8);
		surface.method211(spriteMedia + 22, DataUtils.loadData("hbar.dat", 0, abyte0), abyte1, 1);
		surface.method211(spriteMedia + 23, DataUtils.loadData("hbar2.dat", 0, abyte0), abyte1, 1);
		surface.method211(spriteMedia + 24, DataUtils.loadData("compass.dat", 0, abyte0), abyte1, 1);
		surface.method211(spriteMedia + 25, DataUtils.loadData("buttons.dat", 0, abyte0), abyte1, 2);
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
			surface.method211(spriteItem + (j - 1) * 30, DataUtils.loadData("objects" + j + ".dat", 0, abyte0), abyte1, k);
		}

		surface.method210(spriteMedia);
		surface.method210(spriteMedia + 9);
		for(int l = 11; l <= 26; l++)
			surface.method210(spriteMedia + l);

		for(int i1 = 0; i1 < Definitions.anInt131; i1++)
			surface.method210(anInt942 + i1);

		for(int j1 = 0; j1 < Definitions.anInt74; j1++)
			surface.method210(spriteItem + j1);

	}

	protected int method38() {
		return link.uid;
	}

	private void walkToGroundItem(int i, int j, int k, int l, boolean flag) {
		if(method92(i, j, k, l, k, l, false, flag)) {
        } else {
			method69(i, j, k, l, k, l, true, flag);
        }
	}

	private void method98() {
		if(super.inputTextFinal.length() > 0) {
			String s = super.inputTextFinal.trim();
			super.inputTextCurrent = "";
			super.inputTextFinal = "";
			if(s.length() > 0) {
				long l = DataUtils.method356(s);
				super.packetStream.createPacket(206);
				super.packetStream.method332(l);
				super.packetStream.putByte(reportAbuseOffence);
				super.packetStream.putByte(aBoolean944 ? 1 : 0);
				super.packetStream.endPacket();
			}
			showDialogReportAbuseStep = 0;
			return;
		}
		surface.method207(56, 130, 400, 100, 0);
		surface.method214(56, 130, 400, 100, 0xffffff);
		int i = 160;
		surface.drawStringCenter("Now type the name of the offending player, and press enter", 256, i, 1, 0xffff00);
		i += 18;
		surface.drawStringCenter("Name: " + super.inputTextCurrent + "*", 256, i, 4, 0xffffff);
		if(super.anInt626 > 0) {
			i = 207;
			if(aBoolean944)
				surface.drawStringCenter("Moderator option: Mute player for 48 hours: <ON>", 256, i, 1, 0xff8000);
			else
				surface.drawStringCenter("Moderator option: Mute player for 48 hours: <OFF>", 256, i, 1, 0xffffff);
			if(super.mouseX > 106 && super.mouseX < 406 && super.mouseY > i - 13 && super.mouseY < i + 2 && mouseButtonClick == 1) {
				mouseButtonClick = 0;
				aBoolean944 = !aBoolean944;
			}
		}
		i = 222;
		int j = 0xffffff;
		if(super.mouseX > 196 && super.mouseX < 316 && super.mouseY > i - 13 && super.mouseY < i + 2) {
			j = 0xffff00;
			if(mouseButtonClick == 1) {
				mouseButtonClick = 0;
				showDialogReportAbuseStep = 0;
			}
		}
		surface.drawStringCenter("Click here to cancel", 256, i, 1, j);
		if(mouseButtonClick == 1 && (super.mouseX < 56 || super.mouseX > 456 || super.mouseY < 130 || super.mouseY > 230)) {
			mouseButtonClick = 0;
			showDialogReportAbuseStep = 0;
		}
	}

	void drawUpperLevelModels(int idx) {
		if(plane == 0 && (world.anIntArrayArray573[localPlayer.currentX / 128][localPlayer.currentY / 128] & 0x80) == 0) {
			world.addRoofs(0, idx);
			if(plane == 0) {
				scene.addModel(world.aModelArrayArray597[1][idx]);
				world.addRoofs(1, idx);
				scene.addModel(world.aModelArrayArray597[2][idx]);
				world.addRoofs(2, idx);
			}
			fogOfWar = false;
		}
	}


	private void drawGame() {
		if(deathScreenTimeout != 0) {
			surface.fadeToBlack();
			surface.drawStringCenter("Oh dear! You are dead...", gameWidth / 2, gameHeight / 2, 7, 0xff0000);
			method76();
			surface.draw(graphics, 0, 0);
			return;
		}
		if(changeAppearanceVisible) {
			method71();
			return;
		}
		if(isSleeping) {
			surface.fadeToBlack();
			if(Math.random() < 0.14999999999999999D)
				surface.drawStringCenter("ZZZ", (int)(Math.random() * 80D), (int)(Math.random() * 334D), 5, (int)(Math.random() * 16777215D));
			if(Math.random() < 0.14999999999999999D)
				surface.drawStringCenter("ZZZ", 512 - (int)(Math.random() * 80D), (int)(Math.random() * 334D), 5, (int)(Math.random() * 16777215D));
			surface.method207(gameWidth / 2 - 100, 160, 200, 40, 0);
			surface.drawStringCenter("You are sleeping", gameWidth / 2, 50, 7, 0xffff00);
			surface.drawStringCenter("Fatigue: " + (anInt932 * 100) / 750 + "%", gameWidth / 2, 90, 7, 0xffff00);
			surface.drawStringCenter("When you want to wake up just use your", gameWidth / 2, 140, 5, 0xffffff);
			surface.drawStringCenter("keyboard to type the word in the box below", gameWidth / 2, 160, 5, 0xffffff);
			surface.drawStringCenter(super.inputTextCurrent + "*", gameWidth / 2, 180, 5, 65535);
			if(sleepingStatusText == null)
				surface.drawSprite(gameWidth / 2 - 127, 230, anInt933 + 1);
			else
				surface.drawStringCenter(sleepingStatusText, gameWidth / 2, 260, 5, 0xff0000);
			surface.method214(gameWidth / 2 - 128, 229, 257, 42, 0xffffff);
			method76();
			surface.drawStringCenter("If you can't read the word", gameWidth / 2, 290, 1, 0xffffff);
			surface.drawStringCenter("@yel@click here@whi@ to get a different one", gameWidth / 2, 305, 1, 0xffffff);
			surface.draw(graphics, 0, 0);
			return;
		}
		if(!world.aBoolean572)
			return;
		for(int i = 0; i < 64; i++) {
			scene.removeModel(world.roofModels[plane][i]);
			if(plane == 0) {
				scene.removeModel(world.aModelArrayArray597[1][i]);
				scene.removeModel(world.roofModels[1][i]);
				scene.removeModel(world.aModelArrayArray597[2][i]);
				scene.removeModel(world.roofModels[2][i]);
			}
			fogOfWar = true;
			drawUpperLevelModels(i);
		}

		if(objectAnimationNumberFireLightningSpell != anInt947) {
			anInt947 = objectAnimationNumberFireLightningSpell;
			for(int j = 0; j < objectCount; j++) {
				if(objectID[j] == 97)
					method65(j, "firea" + (objectAnimationNumberFireLightningSpell + 1));
				if(objectID[j] == 274)
					method65(j, "fireplacea" + (objectAnimationNumberFireLightningSpell + 1));
				if(objectID[j] == 1031)
					method65(j, "lightning" + (objectAnimationNumberFireLightningSpell + 1));
				if(objectID[j] == 1036)
					method65(j, "firespell" + (objectAnimationNumberFireLightningSpell + 1));
				if(objectID[j] == 1147)
					method65(j, "spellcharge" + (objectAnimationNumberFireLightningSpell + 1));
			}

		}
		if(objectAnimationNumberTorch != anInt949) {
			anInt949 = objectAnimationNumberTorch;
			for(int k = 0; k < objectCount; k++) {
				if(objectID[k] == 51)
					method65(k, "torcha" + (objectAnimationNumberTorch + 1));
				if(objectID[k] == 143)
					method65(k, "skulltorcha" + (objectAnimationNumberTorch + 1));
			}

		}
		if(objectAnimationNumberClaw != anInt951) {
			anInt951 = objectAnimationNumberClaw;
			for(int l = 0; l < objectCount; l++)
				if(objectID[l] == 1142)
					method65(l, "clawspell" + (objectAnimationNumberClaw + 1));

		}
		scene.method265(anInt952);
		anInt952 = 0;
		for(int i1 = 0; i1 < playerCount; i1++) {
			Character character = players[i1];
			if(character.bottomColor != 255) {
				int x = character.currentX;
				int y = character.currentY;

				int plane = -world.method410(x, y);
				int id = scene.addSprite(5000 + i1, x, plane, y, 145, 220, i1 + 10000);
				anInt952++;
				if(character == localPlayer)
					scene.setLocalPlayer(id);
				if(character.animation == 8)
					scene.setSpriteTranslateX(id, -30);
				if(character.animation == 9)
					scene.setSpriteTranslateX(id, 30);
			}
		}

		for(int j1 = 0; j1 < playerCount; j1++) {
			Character rscharacter1 = players[j1];
			if(rscharacter1.projectileRange > 0) {
				Character rscharacter2 = null;
				if(rscharacter1.attackingNpcServerIndex != -1)
					rscharacter2 = aCharacterArray716[rscharacter1.attackingNpcServerIndex];
				else
				if(rscharacter1.attackingPlayerServerIndex != -1)
					rscharacter2 = aCharacterArray806[rscharacter1.attackingPlayerServerIndex];
				if(rscharacter2 != null) {
					int l2 = rscharacter1.currentX;
					int i4 = rscharacter1.currentY;
					int l6 = -world.method410(l2, i4) - 110;
					int l8 = rscharacter2.currentX;
					int k9 = rscharacter2.currentY;
					int l9 = -world.method410(l8, k9) - Definitions.anIntArray90[rscharacter2.npcID] / 2;
					int i10 = (l2 * rscharacter1.projectileRange + l8 * (anInt876 - rscharacter1.projectileRange)) / anInt876;
					int j10 = (l6 * rscharacter1.projectileRange + l9 * (anInt876 - rscharacter1.projectileRange)) / anInt876;
					int k10 = (i4 * rscharacter1.projectileRange + k9 * (anInt876 - rscharacter1.projectileRange)) / anInt876;
					scene.addSprite(anInt942 + rscharacter1.incomingProjectileSprite, i10, j10, k10, 32, 32, 0);
					anInt952++;
				}
			}
		}

		for(int l1 = 0; l1 < npcCount; l1++) {
			Character rscharacter3 = npcs[l1];
			int i3 = rscharacter3.currentX;
			int j4 = rscharacter3.currentY;
			int i7 = -world.method410(i3, j4);
			int i9 = scene.addSprite(20000 + l1, i3, i7, j4, Definitions.anIntArray89[rscharacter3.npcID], Definitions.anIntArray90[rscharacter3.npcID], l1 + 30000);
			anInt952++;
			if(rscharacter3.animation == 8)
				scene.setSpriteTranslateX(i9, -30);
			if(rscharacter3.animation == 9)
				scene.setSpriteTranslateX(i9, 30);
		}

		for(int j2 = 0; j2 < anInt762; j2++) {
			int j3 = anIntArray760[j2] * magicLoc + 64;
			int k4 = anIntArray761[j2] * magicLoc + 64;
			scene.addSprite(40000 + anIntArray841[j2], j3, -world.method410(j3, k4) - anIntArray873[j2], k4, 96, 64, j2 + 20000);
			anInt952++;
		}

		for(int k3 = 0; k3 < teleportBubbleCount; k3++) {
			int l4 = teleportBubbleX[k3] * magicLoc + 64;
			int j7 = teleportBubbleY[k3] * magicLoc + 64;
			int j9 = teleportBubbleType[k3];
			if(j9 == 0) {
				scene.addSprite(50000 + k3, l4, -world.method410(l4, j7), j7, 128, 256, k3 + 50000);
				anInt952++;
			}
			if(j9 == 1) {
				scene.addSprite(50000 + k3, l4, -world.method410(l4, j7), j7, 128, 64, k3 + 50000);
				anInt952++;
			}
		}

		surface.aBoolean321 = false;
		surface.method244();
		surface.aBoolean321 = super.interlace;
		if(plane == 3) {
			int i5 = 40 + (int)(Math.random() * 3D);
			int k7 = 40 + (int)(Math.random() * 7D);
			scene.method297(i5, k7, -50, -10, -50);
		}
		anInt699 = 0;
		anInt685 = 0;
		anInt691 = 0;
		if(cameraAutoAngleDebug) {
			if(optionCameraModeAuto && !fogOfWar) {
				int j5 = cameraAngle;
				method45();
				if(cameraAngle != j5) {
					cameraAutoRotatePlayerX = localPlayer.currentX;
					cameraAutoRotatePlayerY = localPlayer.currentY;
				}
			}
			scene.clipFar3d = 3000;
			scene.clipFar2d = 3000;
			scene.fogZFalloff = 1;
			scene.fogZDistance = 2800;
			cameraRotation = cameraAngle * 32;
			int k5 = cameraAutoRotatePlayerX + cameraRotationX;
			int l7 = cameraAutoRotatePlayerY + cameraRotationY;
			scene.setCamera(k5, -world.method410(k5, l7), l7, 912, cameraRotation * 4, 0, 2000);
		} else {
			if(optionCameraModeAuto && !fogOfWar)
				method45();
			if(!super.interlace) {
				scene.clipFar3d = 2400;
				scene.clipFar2d = 2400;
				scene.fogZFalloff = 1;
				scene.fogZDistance = 2300;
			} else {
				scene.clipFar3d = 2200;
				scene.clipFar2d = 2200;
				scene.fogZFalloff = 1;
				scene.fogZDistance = 2100;
			}
			int l5 = cameraAutoRotatePlayerX + cameraRotationX;
			int i8 = cameraAutoRotatePlayerY + cameraRotationY;
			scene.setCamera(l5, -world.method410(l5, i8), i8, 912, cameraRotation * 4, 0, cameraZoom * 2);
		}
		scene.render();
		method64();
		drawMouseClick(false);
		if(systemUpdateTimer != 0) {
			int i6 = systemUpdateTimer / 50;
			int j8 = i6 / 60;
			i6 %= 60;
			if(i6 < 10)
				surface.drawStringCenter("System update in: " + j8 + ":0" + i6, 256, gameHeight - 7, 1, 0xffff00);
			else
				surface.drawStringCenter("System update in: " + j8 + ":" + i6, 256, gameHeight - 7, 1, 0xffff00);
		}
		if(!aBoolean877) {
			int j6 = 2203 - (sceneY + anInt828 + baseY);
			if(sceneX + anInt829 + baseX >= 2640)
				j6 = -50;
			if(j6 > 0) {
				int k8 = 1 + j6 / 6;
				surface.drawSprite(453, gameHeight - 56, spriteMedia + 13);
				surface.drawStringCenter("Wilderness", 465, gameHeight - 20, 1, 0xffff00);
				surface.drawStringCenter("Level: " + k8, 465, gameHeight - 7, 1, 0xffff00);
				if(anInt811 == 0)
					anInt811 = 2;
			}
			if(anInt811 == 0 && j6 > -10 && j6 <= 0)
				anInt811 = 1;
		}
		if(messageTabSelected == 0) {
			for(int k6 = 0; k6 < 5; k6++)
				if(messageHistoryTimeout[k6] > 0) {
					String s = aStringArray856[k6];
					surface.drawString(s, 7, gameHeight - 18 - k6 * 12, 1, 0xffff00);
				}

		}
		panelMessageTabs.method161(controlTextListChat);
		panelMessageTabs.method161(controlTextListQuest);
		panelMessageTabs.method161(controlTextListPrivate);
		if(messageTabSelected == 1)
			panelMessageTabs.method155(controlTextListChat);
		else
		if(messageTabSelected == 2)
			panelMessageTabs.method155(controlTextListQuest);
		else
		if(messageTabSelected == 3)
			panelMessageTabs.method155(controlTextListPrivate);
		Panel.anInt216 = 2;
		panelMessageTabs.method150();
		Panel.anInt216 = 0;
		surface.method260(surface.width2 - 3 - 197, 3, spriteMedia, 128);
		drawUI();
		drawMouseClick(true);
		surface.loggedIn = false;
		method76();
		surface.draw(graphics, 0, 0);
	}

	//Draw mouse later if injected so clicks show properly over map etc, but keep normal behavior in vanilla
	public void drawMouseClick(boolean afterUI) {
		if (!injected || afterUI) {
			if(mouseClickXStep > 0)
				surface.drawSprite(anInt801 - 8, anInt802 - 8, spriteMedia + 14 + (24 - mouseClickXStep) / 6);
			if(mouseClickXStep < 0)
				surface.drawSprite(anInt801 - 8, anInt802 - 8, spriteMedia + 18 + (24 + mouseClickXStep) / 6);
		}
	}

	protected Socket method12(String s, int i) throws IOException {
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
		localPlayer = new Character();
		localPlayerServerIdx = -1;
		menuItemX = new int[250];
		menuItemY = new int[250];
		showDialogTrade = false;
		anIntArray664 = new int[256];
		anIntArray666 = new int[256];
		anInt739 = 1;
		anInt750 = 2;
		anInt735 = 2;
		anInt741 = 8;
		anInt747 = 14;
		anInt732 = 1;
		loginUsername = "";
		aString779 = "";
		cameraAngle = 1;
		isMembers = false;
		aBoolean784 = false;
		showRightClickMenu = false;
		cameraRotationYIncrement = 2;
		aBooleanArray830 = new boolean[1500];
		aStringArray727 = new String[250];
		aString892 = "";
		anInt947 = -1;
		anInt949 = -1;
		anInt951 = -1;
		anInt878 = -1;
		aString648 = "";
		aBoolean818 = false;
		isSleeping = false;
		cameraRotation = 128;
		teleportBubbleX = new int[50];
		errorLoadingData = false;
		skillXPs = new int[18];
		aBoolean885 = false;
		aBoolean886 = false;
		anIntArray671 = new int[8192];
		anIntArray673 = new int[8192];
		aBoolean810 = false;
		anIntArray872 = new int[500];
		teleportBubbleY = new int[50];
		aStringArray689 = new String[50];
		aBoolean816 = false;
		aBoolean911 = false;
		players = new Character[500];
		aBooleanArray827 = new boolean[50];
		aString649 = "";
		menuItemIDs = new int[250];
		menuItemSourceIdxs = new int[250];
		menuItemTargerIdxs = new int[250];
		aBooleanArray831 = new boolean[500];
		magicLoc = 128;
		errorLoadingMemory = false;
		fogOfWar = false;
		gameWidth = 512;
		gameHeight = 334;
		anInt976 = 9;
		anIntArray907 = new int[14];
		anIntArray908 = new int[14];
		aString884 = "";
		selectedSpell = -1;
		showOptionMenu = false;
		boostedSkillLevels = new int[18];
		teleportBubbleType = new int[50];
		errorLoadingCodebase = false;
		aBoolean813 = false;
		shopCategoryID = new int[256];
		shopItemQuantities = new int[256];
		shopItemPrices = new int[256];
		aBoolean895 = false;
		aBoolean896 = false;
		gameModels = new Model[1000];
		showDialogDuel = false;
		aString789 = "";
		aBoolean788 = false;
		anIntArray914 = new int[8];
		anIntArray915 = new int[8];
		anIntArray917 = new int[8];
		anIntArray918 = new int[8];
		realSkillLevels = new int[18];
		aCharacterArray717 = new Character[500];
		aBoolean782 = true;
		anIntArray760 = new int[5000];
		anIntArray761 = new int[5000];
		anIntArray841 = new int[5000];
		anIntArray873 = new int[5000];
		anInt847 = -1;
		anInt848 = -2;
		anIntArray909 = new int[8];
		anIntArray910 = new int[8];
		messageHistoryTimeout = new int[5];
		optionCameraModeAuto = true;
		objectX = new int[1500];
		objectY = new int[1500];
		objectID = new int[1500];
		objectDirection = new int[1500];
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
		cameraZoom = 550;
		anIntArray974 = new int[14];
		anIntArray975 = new int[14];
		plane = -1;
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
		aCharacterArray807 = new Character[500];
		aStringArray856 = new String[5];
		aBoolean944 = false;
		anIntArray971 = new int[8];
		anIntArray972 = new int[8];
		anIntArray701 = new int[50];
		anIntArray702 = new int[50];
		sleepWordDelay = true;
		changeAppearanceVisible = false;
		shopSelectedItemIndex = -1;
		shopSelectedItemType = -2;
		anInt876 = 40;
		npcs = new Character[500];
		levelXPs = new int[99];
		anIntArray690 = new int[50];
		anIntArray692 = new int[50];
		anIntArray693 = new int[50];
		aCharacterArray806 = new Character[4000];
		walkPathX = new int[8000];
		walkPathY = new int[8000];
		anIntArray822 = new int[500];
		anIntArray823 = new int[500];
		aStringArray728 = new String[250];
		aCharacterArray716 = new Character[5000];
		anIntArray882 = new int[5];
		objectModel = new Model[1500];
	}

	public Image gameImage = null;

	public Image createImage(int i, int j) {
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

	public URL getCodeBase() {
		if(link.mainapp != null)
			return link.mainapp.getCodeBase();
		else
			return super.getCodeBase();
	}

	public URL getDocumentBase() {
		if(link.mainapp != null)
			return link.mainapp.getDocumentBase();
		else
			return super.getDocumentBase();
	}

	public Graphics getGraphics() {
		if(GameShell.gameWindow != null)
			return GameShell.gameWindow.getGraphics();
		if(link.mainapp != null)
			return link.mainapp.getGraphics();
		else
			return super.getGraphics();
	}

	public String getParameter(String s) {
		if(link.mainapp != null)
			return link.mainapp.getParameter(s);
		else
			return super.getParameter(s);
	}

	public static mudclient mudClient = new mudclient();

	public static void main(String[] args) {

		mudClient.aBoolean782 = false;
		//Default to members with option to specify f2p (members areas load with water terrain if using f2p)
        mudClient.isMembers = args.length == 0 || !args[0].equals("f2p");
		if(args.length > 1)
			mudClient.aString619 = args[1];
		if(args.length > 2)
			mudClient.anInt620 = Integer.parseInt(args[2]);
		main();
	}



	public static void main() {


		mudClient.setupWindow(Constants.GAME_FIXED_WIDTH + 1, Constants.GAME_FIXED_HEIGHT, "Runescape by Andrew Gower", false);
		mudClient.threadSleep = 10;
	}

	private void method100() {
		byte byte0 = 22;
		byte byte1 = 36;
		surface.method207(byte0, byte1, 468, 16, 192);
		int i = 0x989898;
		surface.method224(byte0, byte1 + 16, 468, 246, i, 160);
		surface.drawStringCenter("Please confirm your duel with @yel@" + DataUtils.method351(aLong912), byte0 + 234, byte1 + 12, 1, 0xffffff);
		surface.drawStringCenter("Your stake:", byte0 + 117, byte1 + 30, 1, 0xffff00);
		for(int j = 0; j < anInt916; j++) {
			String s = Definitions.itemNames[anIntArray917[j]];
			if(Definitions.inventoryItemsStackable[anIntArray917[j]] == 0)
				s = s + " x " + method55(anIntArray918[j]);
			surface.drawStringCenter(s, byte0 + 117, byte1 + 42 + j * 12, 1, 0xffffff);
		}

		if(anInt916 == 0)
			surface.drawStringCenter("Nothing!", byte0 + 117, byte1 + 42, 1, 0xffffff);
		surface.drawStringCenter("Your opponent's stake:", byte0 + 351, byte1 + 30, 1, 0xffff00);
		for(int k = 0; k < anInt913; k++) {
			String s1 = Definitions.itemNames[anIntArray914[k]];
			if(Definitions.inventoryItemsStackable[anIntArray914[k]] == 0)
				s1 = s1 + " x " + method55(anIntArray915[k]);
			surface.drawStringCenter(s1, byte0 + 351, byte1 + 42 + k * 12, 1, 0xffffff);
		}

		if(anInt913 == 0)
			surface.drawStringCenter("Nothing!", byte0 + 351, byte1 + 42, 1, 0xffffff);
		if(anInt919 == 0)
			surface.drawStringCenter("You can retreat from this duel", byte0 + 234, byte1 + 180, 1, 65280);
		else
			surface.drawStringCenter("No retreat is possible!", byte0 + 234, byte1 + 180, 1, 0xff0000);
		if(anInt920 == 0)
			surface.drawStringCenter("Magic may be used", byte0 + 234, byte1 + 192, 1, 65280);
		else
			surface.drawStringCenter("Magic cannot be used", byte0 + 234, byte1 + 192, 1, 0xff0000);
		if(anInt921 == 0)
			surface.drawStringCenter("Prayer may be used", byte0 + 234, byte1 + 204, 1, 65280);
		else
			surface.drawStringCenter("Prayer cannot be used", byte0 + 234, byte1 + 204, 1, 0xff0000);
		if(anInt922 == 0)
			surface.drawStringCenter("Weapons may be used", byte0 + 234, byte1 + 216, 1, 65280);
		else
			surface.drawStringCenter("Weapons cannot be used", byte0 + 234, byte1 + 216, 1, 0xff0000);
		surface.drawStringCenter("If you are sure click 'Accept' to begin the duel", byte0 + 234, byte1 + 230, 1, 0xffffff);
		if(!aBoolean911) {
			surface.drawSprite((byte0 + 118) - 35, byte1 + 238, spriteMedia + 25);
			surface.drawSprite((byte0 + 352) - 35, byte1 + 238, spriteMedia + 26);
		} else {
			surface.drawStringCenter("Waiting for other player...", byte0 + 234, byte1 + 250, 1, 0xffff00);
		}
		if(mouseButtonClick == 1) {
			if(super.mouseX < byte0 || super.mouseY < byte1 || super.mouseX > byte0 + 468 || super.mouseY > byte1 + 262) {
				aBoolean816 = false;
				super.packetStream.createPacket(230);
				super.packetStream.endPacket();
			}
			if(super.mouseX >= (byte0 + 118) - 35 && super.mouseX <= byte0 + 118 + 70 && super.mouseY >= byte1 + 238 && super.mouseY <= byte1 + 238 + 21) {
				aBoolean911 = true;
				super.packetStream.createPacket(77);
				super.packetStream.endPacket();
			}
			if(super.mouseX >= (byte0 + 352) - 35 && super.mouseX <= byte0 + 353 + 70 && super.mouseY >= byte1 + 238 && super.mouseY <= byte1 + 238 + 21) {
				aBoolean816 = false;
				super.packetStream.createPacket(197);
				super.packetStream.endPacket();
			}
			mouseButtonClick = 0;
		}
	}

	private void method101() {
		byte byte0 = 22;
		byte byte1 = 36;
		surface.method207(byte0, byte1, 468, 16, 192);
		int i = 0x989898;
		surface.method224(byte0, byte1 + 16, 468, 246, i, 160);
		surface.drawStringCenter("Please confirm your trade with @yel@" + DataUtils.method351(aLong902), byte0 + 234, byte1 + 12, 1, 0xffffff);
		surface.drawStringCenter("You are about to give:", byte0 + 117, byte1 + 30, 1, 0xffff00);
		for(int j = 0; j < anInt906; j++) {
			String s = Definitions.itemNames[anIntArray907[j]];
			if(Definitions.inventoryItemsStackable[anIntArray907[j]] == 0)
				s = s + " x " + method55(anIntArray908[j]);
			surface.drawStringCenter(s, byte0 + 117, byte1 + 42 + j * 12, 1, 0xffffff);
		}

		if(anInt906 == 0)
			surface.drawStringCenter("Nothing!", byte0 + 117, byte1 + 42, 1, 0xffffff);
		surface.drawStringCenter("In return you will receive:", byte0 + 351, byte1 + 30, 1, 0xffff00);
		for(int k = 0; k < anInt903; k++) {
			String s1 = Definitions.itemNames[anIntArray904[k]];
			if(Definitions.inventoryItemsStackable[anIntArray904[k]] == 0)
				s1 = s1 + " x " + method55(anIntArray905[k]);
			surface.drawStringCenter(s1, byte0 + 351, byte1 + 42 + k * 12, 1, 0xffffff);
		}

		if(anInt903 == 0)
			surface.drawStringCenter("Nothing!", byte0 + 351, byte1 + 42, 1, 0xffffff);
		surface.drawStringCenter("Are you sure you want to do this?", byte0 + 234, byte1 + 200, 4, 65535);
		surface.drawStringCenter("There is NO WAY to reverse a trade if you change your mind.", byte0 + 234, byte1 + 215, 1, 0xffffff);
		surface.drawStringCenter("Remember that not all players are trustworthy", byte0 + 234, byte1 + 230, 1, 0xffffff);
		if(!tradeConfirmAccepted) {
			surface.drawSprite((byte0 + 118) - 35, byte1 + 238, spriteMedia + 25);
			surface.drawSprite((byte0 + 352) - 35, byte1 + 238, spriteMedia + 26);
		} else {
			surface.drawStringCenter("Waiting for other player...", byte0 + 234, byte1 + 250, 1, 0xffff00);
		}
		if(mouseButtonClick == 1) {
			if(super.mouseX < byte0 || super.mouseY < byte1 || super.mouseX > byte0 + 468 || super.mouseY > byte1 + 262) {
				showDialogTradeConfirm = false;
				super.packetStream.createPacket(230);
				super.packetStream.endPacket();
			}
			if(super.mouseX >= (byte0 + 118) - 35 && super.mouseX <= byte0 + 118 + 70 && super.mouseY >= byte1 + 238 && super.mouseY <= byte1 + 238 + 21) {
				tradeConfirmAccepted = true;
				super.packetStream.createPacket(104);
				super.packetStream.endPacket();
			}
			if(super.mouseX >= (byte0 + 352) - 35 && super.mouseX <= byte0 + 353 + 70 && super.mouseY >= byte1 + 238 && super.mouseY <= byte1 + 238 + 21) {
				showDialogTradeConfirm = false;
				super.packetStream.createPacket(230);
				super.packetStream.endPacket();
			}
			mouseButtonClick = 0;
		}
	}

	private void method102() {
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

	private void method103() {
		loggedIn = 0;
		loginState = 0;
		loginUsername = "";
		aString779 = "";
		aString957 = "Please enter a username:";
		aString805 = "*" + loginUsername + "*";
		playerCount = 0;
		npcCount = 0;
	}

	private void drawUiTabMagic(boolean flag) {
		int mouseX = surface.width2 - 199;
		int mouseY = 36;
		surface.drawSprite(mouseX - 49, 3, spriteMedia + 4);
		char c = '\304';
		char c1 = '\266';
		int l;
		int k = l = Surface.method222(160, 160, 160);
		if(anInt958 == 0)
			k = Surface.method222(220, 220, 220);
		else
			l = Surface.method222(220, 220, 220);
		surface.method224(mouseX, mouseY, c / 2, 24, k, 128);
		surface.method224(mouseX + c / 2, mouseY, c / 2, 24, l, 128);
		surface.method224(mouseX, mouseY + 24, c, 90, Surface.method222(220, 220, 220), 128);
		surface.method224(mouseX, mouseY + 24 + 90, c, c1 - 90 - 24, Surface.method222(160, 160, 160), 128);
		surface.drawHorizontalLine(mouseX, mouseY + 24, c, 0);
		surface.method217(mouseX + c / 2, mouseY, 24, 0);
		surface.drawHorizontalLine(mouseX, mouseY + 113, c, 0);
		surface.drawStringCenter("Magic", mouseX + c / 4, mouseY + 16, 4, 0);
		surface.drawStringCenter("Prayers", mouseX + c / 4 + c / 2, mouseY + 16, 4, 0);
		if(anInt958 == 0) {
			panelMagicPrayer.method154(controlListMagicPrayer);
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

				int l4 = boostedSkillLevels[6];
				if(Definitions.anIntArray135[i2] > l4)
					s = "@bla@";
				panelMagicPrayer.method139(controlListMagicPrayer, i1++, s + "Level " + Definitions.anIntArray135[i2] + ": " + Definitions.aStringArray133[i2]);
			}

			panelMagicPrayer.method150();
			int i3 = panelMagicPrayer.getListEntryIndex(controlListMagicPrayer);
			if(i3 != -1) {
				surface.drawString("Level " + Definitions.anIntArray135[i3] + ": " + Definitions.aStringArray133[i3], mouseX + 2, mouseY + 124, 1, 0xffff00);
				surface.drawString(Definitions.aStringArray134[i3], mouseX + 2, mouseY + 136, 0, 0xffffff);
				for(int i4 = 0; i4 < Definitions.anIntArray136[i3]; i4++) {
					int i5 = Definitions.anIntArrayArray138[i3][i4];
					surface.drawSprite(mouseX + 2 + i4 * 44, mouseY + 150, spriteItem + Definitions.itemImages[i5]);
					int j5 = getInventoryItemCount(i5);
					int k5 = Definitions.anIntArrayArray139[i3][i4];
					String s2 = "@red@";
					if(method86(i5, k5))
						s2 = "@gre@";
					surface.drawString(s2 + j5 + "/" + k5, mouseX + 2 + i4 * 44, mouseY + 150, 1, 0xffffff);
				}

			} else {
				surface.drawString("Point at a spell for a description", mouseX + 2, mouseY + 124, 1, 0);
			}
		}
		if(anInt958 == 1) {
			panelMagicPrayer.method154(controlListMagicPrayer);
			int j1 = 0;
			for(int j2 = 0; j2 < Definitions.anInt140; j2++) {
				String s1 = "@whi@";
				if(Definitions.anIntArray143[j2] > realSkillLevels[5])
					s1 = "@bla@";
				if(aBooleanArray827[j2])
					s1 = "@gre@";
				panelMagicPrayer.method139(controlListMagicPrayer, j1++, s1 + "Level " + Definitions.anIntArray143[j2] + ": " + Definitions.aStringArray141[j2]);
			}

			panelMagicPrayer.method150();
			int j3 = panelMagicPrayer.getListEntryIndex(controlListMagicPrayer);
			if(j3 != -1) {
				surface.drawStringCenter("Level " + Definitions.anIntArray143[j3] + ": " + Definitions.aStringArray141[j3], mouseX + c / 2, mouseY + 130, 1, 0xffff00);
				surface.drawStringCenter(Definitions.aStringArray142[j3], mouseX + c / 2, mouseY + 145, 0, 0xffffff);
				surface.drawStringCenter("Drain rate: " + Definitions.anIntArray144[j3], mouseX + c / 2, mouseY + 160, 1, 0);
			} else {
				surface.drawString("Point at a prayer for a description", mouseX + 2, mouseY + 124, 1, 0);
			}
		}
		if(!flag)
			return;
		mouseX = super.mouseX - (gameWidth - 199);
		mouseY = super.mouseY - 36;
		if(mouseX >= 0 && mouseY >= 0 && mouseX < 196 && mouseY < 182) {
			panelMagicPrayer.handleMouse(mouseX + (gameWidth - 199), mouseY + 36, super.lastMouseButtonDown, super.mouseButtonDown);
			if(mouseY <= 24 && mouseButtonClick == 1)
				if(mouseX < 98 && anInt958 == 1) {
					anInt958 = 0;
					panelMagicPrayer.method162(controlListMagicPrayer);
				} else
				if(mouseX > 98 && anInt958 == 0) {
					anInt958 = 1;
					panelMagicPrayer.method162(controlListMagicPrayer);
				}
			if(mouseButtonClick == 1 && anInt958 == 0) {
				int k1 = panelMagicPrayer.getListEntryIndex(controlListMagicPrayer);
				if(k1 != -1) {
					int k2 = boostedSkillLevels[6];
					if(Definitions.anIntArray135[k1] > k2) {
						sendMessage("Your magic ability is not high enough for this spell", 3);
					} else {
						int k3;
						for(k3 = 0; k3 < Definitions.anIntArray136[k1]; k3++) {
							int j4 = Definitions.anIntArrayArray138[k1][k3];
							if(method86(j4, Definitions.anIntArrayArray139[k1][k3]))
								continue;
							sendMessage("You don't have all the reagents you need for this spell", 3);
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
			if(mouseButtonClick == 1 && anInt958 == 1) {
				int l1 = panelMagicPrayer.getListEntryIndex(controlListMagicPrayer);
				if(l1 != -1) {
					int l2 = realSkillLevels[5];
					if(Definitions.anIntArray143[l1] > l2)
						sendMessage("Your prayer ability is not high enough for this prayer", 3);
					else
					if(boostedSkillLevels[5] == 0)
						sendMessage("You have run out of prayer points. Return to a church to recharge", 3);
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
			mouseButtonClick = 0;
		}
	}

	private void drawUiTabInventory(boolean flag) {
		int i = surface.width2 - 248;
		surface.drawSprite(i, 3, spriteMedia + 1);
		for(int j = 0; j < inventoryMaxItemCount; j++) {
			int k = i + (j % 5) * 49;
			int i1 = 36 + (j / 5) * 34;
			if(j < inventorySize && inventoryItemsEquipped[j] == 1)
				surface.method224(k, i1, 49, 34, 0xff0000, 128);
			else
				surface.method224(k, i1, 49, 34, Surface.method222(181, 181, 181), 128);
			if(j < inventorySize) {
				surface.spriteClipping(k, i1, 48, 32, spriteItem + Definitions.itemImages[inventoryItemsIDs[j]], Definitions.itemMasks[inventoryItemsIDs[j]], 0, 0, false);
				if(Definitions.inventoryItemsStackable[inventoryItemsIDs[j]] == 0)
					surface.drawString(String.valueOf(inventoryItemsQuantities[j]), k + 1, i1 + 10, 1, 0xffff00);
			}
		}

		for(int l = 1; l <= 4; l++)
			surface.method217(i + l * 49, 36, (inventoryMaxItemCount / 5) * 34, 0);

		for(int j1 = 1; j1 <= inventoryMaxItemCount / 5 - 1; j1++)
			surface.drawHorizontalLine(i, 36 + j1 * 34, 245, 0);

		if(!flag)
			return;
		i = super.mouseX - (surface.width2 - 248);
		int k1 = super.mouseY - 36;
		if(i >= 0 && k1 >= 0 && i < 248 && k1 < (inventoryMaxItemCount / 5) * 34) {
			int l1 = i / 49 + (k1 / 34) * 5;
			if(l1 < inventorySize) {
				int i2 = inventoryItemsIDs[l1];
				if(selectedSpell >= 0) {
					if(Definitions.anIntArray137[selectedSpell] == 3) {
						aStringArray727[menuItemsCount] = "Cast " + Definitions.aStringArray133[selectedSpell] + " on";
						aStringArray728[menuItemsCount] = "@lre@" + Definitions.itemNames[i2];
						menuItemOpcodes[menuItemsCount] = 600;
						menuItemIDs[menuItemsCount] = l1;
						menuItemSourceIdxs[menuItemsCount] = selectedSpell;
						menuItemsCount++;
                    }
				} else {
					if(selectedItemSlot >= 0) {
						aStringArray727[menuItemsCount] = "Use " + selectedItemName + " with";
						aStringArray728[menuItemsCount] = "@lre@" + Definitions.itemNames[i2];
						menuItemOpcodes[menuItemsCount] = 610;
						menuItemIDs[menuItemsCount] = l1;
						menuItemSourceIdxs[menuItemsCount] = selectedItemSlot;
						menuItemsCount++;
						return;
					}
					if(inventoryItemsEquipped[l1] == 1) {
						aStringArray727[menuItemsCount] = "Remove";
						aStringArray728[menuItemsCount] = "@lre@" + Definitions.itemNames[i2];
						menuItemOpcodes[menuItemsCount] = 620;
						menuItemIDs[menuItemsCount] = l1;
						menuItemsCount++;
					} else
					if(Definitions.anIntArray70[i2] != 0) {
						if((Definitions.anIntArray70[i2] & 0x18) != 0)
							aStringArray727[menuItemsCount] = "Wield";
						else
							aStringArray727[menuItemsCount] = "Wear";
						aStringArray728[menuItemsCount] = "@lre@" + Definitions.itemNames[i2];
						menuItemOpcodes[menuItemsCount] = 630;
						menuItemIDs[menuItemsCount] = l1;
						menuItemsCount++;
					}
					if(!Definitions.aStringArray65[i2].equals("")) {
						aStringArray727[menuItemsCount] = Definitions.aStringArray65[i2];
						aStringArray728[menuItemsCount] = "@lre@" + Definitions.itemNames[i2];
						menuItemOpcodes[menuItemsCount] = 640;
						menuItemIDs[menuItemsCount] = l1;
						menuItemsCount++;
					}
					aStringArray727[menuItemsCount] = "Use";
					aStringArray728[menuItemsCount] = "@lre@" + Definitions.itemNames[i2];
					menuItemOpcodes[menuItemsCount] = 650;
					menuItemIDs[menuItemsCount] = l1;
					menuItemsCount++;
					aStringArray727[menuItemsCount] = "Drop";
					aStringArray728[menuItemsCount] = "@lre@" + Definitions.itemNames[i2];
					menuItemOpcodes[menuItemsCount] = 660;
					menuItemIDs[menuItemsCount] = l1;
					menuItemsCount++;
					aStringArray727[menuItemsCount] = "Examine";
					aStringArray728[menuItemsCount] = "@lre@" + Definitions.itemNames[i2];
					menuItemOpcodes[menuItemsCount] = 3600;
					menuItemIDs[menuItemsCount] = i2;
					menuItemsCount++;
				}
			}
		}
	}

	private void method106(int i, int j, int k, int l, boolean flag) {
		method69(i, j, k, l, k, l, false, flag);
	}

	private void method107() {
		byte byte0 = 7;
		byte byte1 = 15;
		char c = '\257';
		if(mouseButtonClick != 0) {
			for(int i = 0; i < 5; i++) {
				if(i <= 0 || super.mouseX <= byte0 || super.mouseX >= byte0 + c || super.mouseY <= byte1 + i * 20 || super.mouseY >= byte1 + i * 20 + 20)
					continue;
				combatStyle = i - 1;
				mouseButtonClick = 0;
				super.packetStream.createPacket(29);
				super.packetStream.putByte(combatStyle);
				super.packetStream.endPacket();
				break;
			}

		}
		for(int j = 0; j < 5; j++) {
			if(j == combatStyle + 1)
				surface.method224(byte0, byte1 + j * 20, c, 20, Surface.method222(255, 0, 0), 128);
			else
				surface.method224(byte0, byte1 + j * 20, c, 20, Surface.method222(190, 190, 190), 128);
			surface.drawHorizontalLine(byte0, byte1 + j * 20, c, 0);
			surface.drawHorizontalLine(byte0, byte1 + j * 20 + 20, c, 0);
		}

		surface.drawStringCenter("Select combat style", byte0 + c / 2, byte1 + 16, 3, 0xffffff);
		surface.drawStringCenter("Controlled (+1 of each)", byte0 + c / 2, byte1 + 36, 3, 0);
		surface.drawStringCenter("Aggressive (+3 strength)", byte0 + c / 2, byte1 + 56, 3, 0);
		surface.drawStringCenter("Accurate   (+3 attack)", byte0 + c / 2, byte1 + 76, 3, 0);
		surface.drawStringCenter("Defensive  (+3 defense)", byte0 + c / 2, byte1 + 96, 3, 0);
	}

	protected void draw() {
		if(errorLoadingData) {
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
		if(errorLoadingCodebase) {
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
		if(errorLoadingMemory) {
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
				surface.loggedIn = false;
				method73();
			}
			if(loggedIn == 1) {
				surface.loggedIn = true;
				try {
					drawGame();
				} catch (Exception e) {
					e.printStackTrace();
				}
            }
		}
		catch(OutOfMemoryError _ex) {
			disposeAndCollect();
			errorLoadingMemory = true;
		}
	}

	private void method108() {
		try {
			//Don't load sounds because of dogshit ulaw format support in jdk17, we play wav conversions
			//aByteArray785 = method19("sounds" + Versions.anInt566 + ".mem", "Sound effects", 90);
			aSunAudioPlayer783 = new SoundPlayer();
        }
		catch(Throwable throwable) {
			System.out.println("Unable to init sounds:" + throwable);
		}
	}

	protected void method16(Runnable runnable) {
		if(link.mainapp != null) {
			link.startthread(runnable);
        } else {
			Thread thread = new Thread(runnable);
			thread.setDaemon(true);
			thread.start();
        }
	}

	private void drawUiTabPlayerInfo(boolean flag) {
		int i = surface.width2 - 199;
		int j = 36;
		surface.drawSprite(i - 49, 3, spriteMedia + 3);
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
		surface.drawHorizontalLine(i, j + 24, c, 0);
		surface.method217(i + c / 2, j, 24, 0);
		surface.drawStringCenter("Stats", i + c / 4, j + 16, 4, 0);
		surface.drawStringCenter("Quests", i + c / 4 + c / 2, j + 16, 4, 0);
		if(anInt961 == 0) {
			int i1 = 72;
			int skill = -1;
			surface.drawString("Skills", i + 5, i1, 3, 0xffff00);
			i1 += 13;
			for(int l1 = 0; l1 < 9; l1++) {
				int i2 = 0xffffff;
				if(super.mouseX > i + 3 && super.mouseY >= i1 - 11 && super.mouseY < i1 + 2 && super.mouseX < i + 90) {
					i2 = 0xff0000;
					skill = l1;
				}
				surface.drawString(skillNamesShort[l1] + ":@yel@" + boostedSkillLevels[l1] + "/" + realSkillLevels[l1], i + 5, i1, 1, i2);
				i2 = 0xffffff;
				if(super.mouseX >= i + 90 && super.mouseY >= i1 - 13 - 11 && super.mouseY < (i1 - 13) + 2 && super.mouseX < i + 196) {
					i2 = 0xff0000;
					skill = l1 + 9;
				}
				surface.drawString(skillNamesShort[l1 + 9] + ":@yel@" + boostedSkillLevels[l1 + 9] + "/" + realSkillLevels[l1 + 9], (i + c / 2) - 5, i1 - 13, 1, i2);
				i1 += 13;
			}

			surface.drawString("Quest Points:@yel@" + anInt881, (i + c / 2) - 5, i1 - 13, 1, 0xffffff);
			i1 += 12;
			surface.drawString("Fatigue: @yel@" + (statFatigue * 100) / 750 + "%", i + 5, i1 - 13, 1, 0xffffff);
			i1 += 8;
			surface.drawString("Equipment Status", i + 5, i1, 3, 0xffff00);
			i1 += 12;
			for(int j2 = 0; j2 < 3; j2++) {
				surface.drawString(aStringArray963[j2] + ":@yel@" + anIntArray882[j2], i + 5, i1, 1, 0xffffff);
				if(j2 < 2)
					surface.drawString(aStringArray963[j2 + 3] + ":@yel@" + anIntArray882[j2 + 3], i + c / 2 + 25, i1, 1, 0xffffff);
				i1 += 13;
			}

			i1 += 6;
			surface.drawHorizontalLine(i, i1 - 15, c, 0);
			if(skill != -1) {
				surface.drawString(skillNameLong[skill] + " skill", i + 5, i1, 1, 0xffff00);
				i1 += 12;
				int k2 = levelXPs[0];
				for(int i3 = 0; i3 < 98; i3++)
					if(skillXPs[skill] >= levelXPs[i3])
						k2 = levelXPs[i3 + 1];

				surface.drawString("Total xp: " + skillXPs[skill] / 4, i + 5, i1, 1, 0xffffff);
				i1 += 12;
				surface.drawString("Next level at: " + k2 / 4, i + 5, i1, 1, 0xffffff);
			} else {
				surface.drawString("Overall levels", i + 5, i1, 1, 0xffff00);
				i1 += 12;
				int l2 = 0;
				for(int j3 = 0; j3 < 18; j3++)
					l2 += realSkillLevels[j3];

				surface.drawString("Skill total: " + l2, i + 5, i1, 1, 0xffffff);
				i1 += 12;
				surface.drawString("Combat level: " + localPlayer.combatLevel, i + 5, i1, 1, 0xffffff);
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
		i = super.mouseX - (surface.width2 - 199);
		j = super.mouseY - 36;
		if(i >= 0 && j >= 0 && i < c && j < c1) {
			if(anInt961 == 1)
				aPanel966.handleMouse(i + (surface.width2 - 199), j + 36, super.lastMouseButtonDown, super.mouseButtonDown);
			if(j <= 24 && mouseButtonClick == 1) {
				if(i < 98) {
					anInt961 = 0;
					return;
				}
				if(i > 98)
					anInt961 = 1;
			}
		}
	}

	private void method110() {
		byte[] abyte0 = readDataFile("textures" + Versions.anInt564 + ".jag", "Textures", 50);
		if(abyte0 == null) {
			errorLoadingData = true;
			return;
		}
		byte[] abyte1 = DataUtils.loadData("index.dat", 0, abyte0);
		scene.method287(Definitions.anInt94, 7, 11);
		for(int i = 0; i < Definitions.anInt94; i++) {
			String s = Definitions.aStringArray95[i];
			byte[] abyte2 = DataUtils.loadData(s + ".dat", 0, abyte0);
			surface.method211(anInt933, abyte2, abyte1, 1);
			surface.method207(0, 0, 128, 128, 0xff00ff);
			surface.drawSprite(0, 0, anInt933);
			int j = surface.anIntArray331[anInt933];
			String s1 = Definitions.aStringArray96[i];
			if(s1 != null && s1.length() > 0) {
				byte[] abyte3 = DataUtils.loadData(s1 + ".dat", 0, abyte0);
				surface.method211(anInt933, abyte3, abyte1, 1);
				surface.drawSprite(0, 0, anInt933);
			}
			surface.method252(anInt969 + i, 0, 0, j, j);
			int k = j * j;
			for(int l = 0; l < k; l++)
				if(surface.anIntArrayArray328[anInt969 + i][l] == 65280)
					surface.anIntArrayArray328[anInt969 + i][l] = 0xff00ff;

			surface.method235(anInt969 + i);
			scene.method299(i, surface.aByteArrayArray324[anInt969 + i], surface.anIntArrayArray327[anInt969 + i], j / 64 - 1);
		}

	}

	private void method111() {
		reportAbuseOffence = 0;
		int i = 135;
		for(int j = 0; j < 12; j++) {
			if(super.mouseX > 66 && super.mouseX < 446 && super.mouseY >= i - 12 && super.mouseY < i + 3)
				reportAbuseOffence = j + 1;
			i += 14;
		}

		if(mouseButtonClick != 0 && reportAbuseOffence != 0) {
			mouseButtonClick = 0;
			showDialogReportAbuseStep = 2;
			super.inputTextCurrent = "";
			super.inputTextFinal = "";
			return;
		}
		i += 15;
		if(mouseButtonClick != 0) {
			mouseButtonClick = 0;
			if(super.mouseX < 56 || super.mouseY < 35 || super.mouseX > 456 || super.mouseY > 325) {
				showDialogReportAbuseStep = 0;
				return;
			}
			if(super.mouseX > 66 && super.mouseX < 446 && super.mouseY >= i - 15 && super.mouseY < i + 5) {
				showDialogReportAbuseStep = 0;
				return;
			}
		}
		surface.method207(56, 35, 400, 290, 0);
		surface.method214(56, 35, 400, 290, 0xffffff);
		i = 50;
		surface.drawStringCenter("This form is for reporting players who are breaking our rules", 256, i, 1, 0xffffff);
		i += 15;
		surface.drawStringCenter("Using it sends a snapshot of the last 60 secs of activity to us", 256, i, 1, 0xffffff);
		i += 15;
		surface.drawStringCenter("If you misuse this form, you will be banned.", 256, i, 1, 0xff8000);
		i += 15;
		i += 10;
		surface.drawStringCenter("First indicate which of our 12 rules is being broken. For a detailed", 256, i, 1, 0xffff00);
		i += 15;
		surface.drawStringCenter("explanation of each rule please read the manual on our website.", 256, i, 1, 0xffff00);
		i += 15;
		int k;
		if(reportAbuseOffence == 1) {
			surface.method214(66, i - 12, 380, 15, 0xffffff);
			k = 0xff8000;
		} else {
			k = 0xffffff;
		}
		surface.drawStringCenter("1: Offensive language", 256, i, 1, k);
		i += 14;
		if(reportAbuseOffence == 2) {
			surface.method214(66, i - 12, 380, 15, 0xffffff);
			k = 0xff8000;
		} else {
			k = 0xffffff;
		}
		surface.drawStringCenter("2: Item scamming", 256, i, 1, k);
		i += 14;
		if(reportAbuseOffence == 3) {
			surface.method214(66, i - 12, 380, 15, 0xffffff);
			k = 0xff8000;
		} else {
			k = 0xffffff;
		}
		surface.drawStringCenter("3: Password scamming", 256, i, 1, k);
		i += 14;
		if(reportAbuseOffence == 4) {
			surface.method214(66, i - 12, 380, 15, 0xffffff);
			k = 0xff8000;
		} else {
			k = 0xffffff;
		}
		surface.drawStringCenter("4: Bug abuse", 256, i, 1, k);
		i += 14;
		if(reportAbuseOffence == 5) {
			surface.method214(66, i - 12, 380, 15, 0xffffff);
			k = 0xff8000;
		} else {
			k = 0xffffff;
		}
		surface.drawStringCenter("5: Jagex Staff impersonation", 256, i, 1, k);
		i += 14;
		if(reportAbuseOffence == 6) {
			surface.method214(66, i - 12, 380, 15, 0xffffff);
			k = 0xff8000;
		} else {
			k = 0xffffff;
		}
		surface.drawStringCenter("6: Account sharing/trading", 256, i, 1, k);
		i += 14;
		if(reportAbuseOffence == 7) {
			surface.method214(66, i - 12, 380, 15, 0xffffff);
			k = 0xff8000;
		} else {
			k = 0xffffff;
		}
		surface.drawStringCenter("7: Macroing", 256, i, 1, k);
		i += 14;
		if(reportAbuseOffence == 8) {
			surface.method214(66, i - 12, 380, 15, 0xffffff);
			k = 0xff8000;
		} else {
			k = 0xffffff;
		}
		surface.drawStringCenter("8: Mutiple logging in", 256, i, 1, k);
		i += 14;
		if(reportAbuseOffence == 9) {
			surface.method214(66, i - 12, 380, 15, 0xffffff);
			k = 0xff8000;
		} else {
			k = 0xffffff;
		}
		surface.drawStringCenter("9: Encouraging others to break rules", 256, i, 1, k);
		i += 14;
		if(reportAbuseOffence == 10) {
			surface.method214(66, i - 12, 380, 15, 0xffffff);
			k = 0xff8000;
		} else {
			k = 0xffffff;
		}
		surface.drawStringCenter("10: Misuse of customer support", 256, i, 1, k);
		i += 14;
		if(reportAbuseOffence == 11) {
			surface.method214(66, i - 12, 380, 15, 0xffffff);
			k = 0xff8000;
		} else {
			k = 0xffffff;
		}
		surface.drawStringCenter("11: Advertising / website", 256, i, 1, k);
		i += 14;
		if(reportAbuseOffence == 12) {
			surface.method214(66, i - 12, 380, 15, 0xffffff);
			k = 0xff8000;
		} else {
			k = 0xffffff;
		}
		surface.drawStringCenter("12: Real world item trading", 256, i, 1, k);
		i += 14;
		i += 15;
		k = 0xffffff;
		if(super.mouseX > 196 && super.mouseX < 316 && super.mouseY > i - 15 && super.mouseY < i + 5)
			k = 0xffff00;
		surface.drawStringCenter("Click here to cancel", 256, i, 1, k);
	}

	private void method112() {
		if(mouseButtonClick != 0 && mouseButtonItemCountIncrement == 0)
			mouseButtonItemCountIncrement = 1;
		if(mouseButtonItemCountIncrement > 0) {
			int i = super.mouseX - 22;
			int j = super.mouseY - 36;
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
									for(int i4 = 0; i4 < mouseButtonItemCountIncrement; i4++) {
										if(anIntArray972[k3] < inventoryItemsQuantities[k])
											anIntArray972[k3]++;
										flag1 = true;
									}

								} else {
									l1++;
								}

						if(getInventoryItemCount(k2) <= l1)
							flag1 = true;
						if(Definitions.anIntArray72[k2] == 1) {
							sendMessage("This object cannot be added to a duel offer", 3);
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
						for(int i2 = 0; i2 < mouseButtonItemCountIncrement; i2++) {
							if(Definitions.inventoryItemsStackable[j1] == 0 && anIntArray972[l] > 1) {
								anIntArray972[l]--;
								continue;
							}
							anInt893--;
							mouseButtonDownTime = 0;
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
					showDialogDuel = false;
					super.packetStream.createPacket(197);
					super.packetStream.endPacket();
				}
			} else
			if(mouseButtonClick != 0) {
				showDialogDuel = false;
				super.packetStream.createPacket(197);
				super.packetStream.endPacket();
			}
			mouseButtonClick = 0;
			mouseButtonItemCountIncrement = 0;
		}
		if(!showDialogDuel)
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
			surface.drawHorizontalLine(byte0 + 8, byte1 + 30 + j2 * 34, 197, 0);

		for(int j3 = 0; j3 < 3; j3++)
			surface.drawHorizontalLine(byte0 + 8, byte1 + 123 + j3 * 34, 197, 0);

		for(int l3 = 0; l3 < 7; l3++)
			surface.drawHorizontalLine(byte0 + 216, byte1 + 30 + l3 * 34, 246, 0);

		for(int k4 = 0; k4 < 6; k4++) {
			if(k4 < 5)
				surface.method217(byte0 + 8 + k4 * 49, byte1 + 30, 69, 0);
			if(k4 < 5)
				surface.method217(byte0 + 8 + k4 * 49, byte1 + 123, 69, 0);
			surface.method217(byte0 + 216 + k4 * 49, byte1 + 30, 205, 0);
		}

		surface.drawHorizontalLine(byte0 + 8, byte1 + 215, 197, 0);
		surface.drawHorizontalLine(byte0 + 8, byte1 + 257, 197, 0);
		surface.method217(byte0 + 8, byte1 + 215, 43, 0);
		surface.method217(byte0 + 204, byte1 + 215, 43, 0);
		surface.drawString("Preparing to duel with: " + aString892, byte0 + 1, byte1 + 10, 1, 0xffffff);
		surface.drawString("Your Stake", byte0 + 9, byte1 + 27, 4, 0xffffff);
		surface.drawString("Opponent's Stake", byte0 + 9, byte1 + 120, 4, 0xffffff);
		surface.drawString("Duel Options", byte0 + 9, byte1 + 212, 4, 0xffffff);
		surface.drawString("Your Inventory", byte0 + 216, byte1 + 27, 4, 0xffffff);
		surface.drawString("No retreating", byte0 + 8 + 1, byte1 + 215 + 16, 3, 0xffff00);
		surface.drawString("No magic", byte0 + 8 + 1, byte1 + 215 + 35, 3, 0xffff00);
		surface.drawString("No prayer", byte0 + 8 + 102, byte1 + 215 + 16, 3, 0xffff00);
		surface.drawString("No weapons", byte0 + 8 + 102, byte1 + 215 + 35, 3, 0xffff00);
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
			surface.drawSprite(byte0 + 217, byte1 + 238, spriteMedia + 25);
		surface.drawSprite(byte0 + 394, byte1 + 238, spriteMedia + 26);
		if(aBoolean895) {
			surface.drawStringCenter("Other player", byte0 + 341, byte1 + 246, 1, 0xffffff);
			surface.drawStringCenter("has accepted", byte0 + 341, byte1 + 256, 1, 0xffffff);
		}
		if(aBoolean896) {
			surface.drawStringCenter("Waiting for", byte0 + 217 + 35, byte1 + 246, 1, 0xffffff);
			surface.drawStringCenter("other player", byte0 + 217 + 35, byte1 + 256, 1, 0xffffff);
		}
		for(int l4 = 0; l4 < inventorySize; l4++) {
			int i5 = 217 + byte0 + (l4 % 5) * 49;
			int k5 = 31 + byte1 + (l4 / 5) * 34;
			surface.spriteClipping(i5, k5, 48, 32, spriteItem + Definitions.itemImages[inventoryItemsIDs[l4]], Definitions.itemMasks[inventoryItemsIDs[l4]], 0, 0, false);
			if(Definitions.inventoryItemsStackable[inventoryItemsIDs[l4]] == 0)
				surface.drawString(String.valueOf(inventoryItemsQuantities[l4]), i5 + 1, k5 + 10, 1, 0xffff00);
		}

		for(int j5 = 0; j5 < anInt893; j5++) {
			int l5 = 9 + byte0 + (j5 % 4) * 49;
			int j6 = 31 + byte1 + (j5 / 4) * 34;
			surface.spriteClipping(l5, j6, 48, 32, spriteItem + Definitions.itemImages[anIntArray971[j5]], Definitions.itemMasks[anIntArray971[j5]], 0, 0, false);
			if(Definitions.inventoryItemsStackable[anIntArray971[j5]] == 0)
				surface.drawString(String.valueOf(anIntArray972[j5]), l5 + 1, j6 + 10, 1, 0xffff00);
			if(super.mouseX > l5 && super.mouseX < l5 + 48 && super.mouseY > j6 && super.mouseY < j6 + 32)
				surface.drawString(Definitions.itemNames[anIntArray971[j5]] + ": @whi@" + Definitions.aStringArray64[anIntArray971[j5]], byte0 + 8, byte1 + 273, 1, 0xffff00);
		}

		for(int i6 = 0; i6 < anInt894; i6++) {
			int k6 = 9 + byte0 + (i6 % 4) * 49;
			int l6 = 124 + byte1 + (i6 / 4) * 34;
			surface.spriteClipping(k6, l6, 48, 32, spriteItem + Definitions.itemImages[anIntArray909[i6]], Definitions.itemMasks[anIntArray909[i6]], 0, 0, false);
			if(Definitions.inventoryItemsStackable[anIntArray909[i6]] == 0)
				surface.drawString(String.valueOf(anIntArray910[i6]), k6 + 1, l6 + 10, 1, 0xffff00);
			if(super.mouseX > k6 && super.mouseX < k6 + 48 && super.mouseY > l6 && super.mouseY < l6 + 32)
				surface.drawString(Definitions.itemNames[anIntArray909[i6]] + ": @whi@" + Definitions.aStringArray64[anIntArray909[i6]], byte0 + 8, byte1 + 273, 1, 0xffff00);
		}

	}

	private void method113() {
		if(mouseButtonClick != 0 && mouseButtonItemCountIncrement == 0)
			mouseButtonItemCountIncrement = 1;
		if(mouseButtonItemCountIncrement > 0) {
			int i = super.mouseX - 22;
			int j = super.mouseY - 36;
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
									for(int i4 = 0; i4 < mouseButtonItemCountIncrement; i4++) {
										if(anIntArray975[k3] < inventoryItemsQuantities[k])
											anIntArray975[k3]++;
										flag = true;
									}

								} else {
									l1++;
								}

						if(getInventoryItemCount(k2) <= l1)
							flag = true;
						if(Definitions.anIntArray72[k2] == 1) {
							sendMessage("This object cannot be traded with other players", 3);
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
						for(int i2 = 0; i2 < mouseButtonItemCountIncrement; i2++) {
							if(Definitions.inventoryItemsStackable[j1] == 0 && anIntArray975[l] > 1) {
								anIntArray975[l]--;
								continue;
							}
							anInt887--;
							mouseButtonDownTime = 0;
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
					showDialogTrade = false;
					super.packetStream.createPacket(230);
					super.packetStream.endPacket();
				}
			} else
			if(mouseButtonClick != 0) {
				showDialogTrade = false;
				super.packetStream.createPacket(230);
				super.packetStream.endPacket();
			}
			mouseButtonClick = 0;
			mouseButtonItemCountIncrement = 0;
		}
		if(!showDialogTrade)
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
			surface.drawHorizontalLine(byte0 + 8, byte1 + 30 + j2 * 34, 197, 0);

		for(int j3 = 0; j3 < 4; j3++)
			surface.drawHorizontalLine(byte0 + 8, byte1 + 155 + j3 * 34, 197, 0);

		for(int l3 = 0; l3 < 7; l3++)
			surface.drawHorizontalLine(byte0 + 216, byte1 + 30 + l3 * 34, 246, 0);

		for(int k4 = 0; k4 < 6; k4++) {
			if(k4 < 5)
				surface.method217(byte0 + 8 + k4 * 49, byte1 + 30, 103, 0);
			if(k4 < 5)
				surface.method217(byte0 + 8 + k4 * 49, byte1 + 155, 103, 0);
			surface.method217(byte0 + 216 + k4 * 49, byte1 + 30, 205, 0);
		}

		surface.drawString("Trading with: " + aString884, byte0 + 1, byte1 + 10, 1, 0xffffff);
		surface.drawString("Your Offer", byte0 + 9, byte1 + 27, 4, 0xffffff);
		surface.drawString("Opponent's Offer", byte0 + 9, byte1 + 152, 4, 0xffffff);
		surface.drawString("Your Inventory", byte0 + 216, byte1 + 27, 4, 0xffffff);
		if(!aBoolean886)
			surface.drawSprite(byte0 + 217, byte1 + 238, spriteMedia + 25);
		surface.drawSprite(byte0 + 394, byte1 + 238, spriteMedia + 26);
		if(aBoolean885) {
			surface.drawStringCenter("Other player", byte0 + 341, byte1 + 246, 1, 0xffffff);
			surface.drawStringCenter("has accepted", byte0 + 341, byte1 + 256, 1, 0xffffff);
		}
		if(aBoolean886) {
			surface.drawStringCenter("Waiting for", byte0 + 217 + 35, byte1 + 246, 1, 0xffffff);
			surface.drawStringCenter("other player", byte0 + 217 + 35, byte1 + 256, 1, 0xffffff);
		}
		for(int l4 = 0; l4 < inventorySize; l4++) {
			int i5 = 217 + byte0 + (l4 % 5) * 49;
			int k5 = 31 + byte1 + (l4 / 5) * 34;
			surface.spriteClipping(i5, k5, 48, 32, spriteItem + Definitions.itemImages[inventoryItemsIDs[l4]], Definitions.itemMasks[inventoryItemsIDs[l4]], 0, 0, false);
			if(Definitions.inventoryItemsStackable[inventoryItemsIDs[l4]] == 0)
				surface.drawString(String.valueOf(inventoryItemsQuantities[l4]), i5 + 1, k5 + 10, 1, 0xffff00);
		}

		for(int j5 = 0; j5 < anInt887; j5++) {
			int l5 = 9 + byte0 + (j5 % 4) * 49;
			int j6 = 31 + byte1 + (j5 / 4) * 34;
			surface.spriteClipping(l5, j6, 48, 32, spriteItem + Definitions.itemImages[anIntArray974[j5]], Definitions.itemMasks[anIntArray974[j5]], 0, 0, false);
			if(Definitions.inventoryItemsStackable[anIntArray974[j5]] == 0)
				surface.drawString(String.valueOf(anIntArray975[j5]), l5 + 1, j6 + 10, 1, 0xffff00);
			if(super.mouseX > l5 && super.mouseX < l5 + 48 && super.mouseY > j6 && super.mouseY < j6 + 32)
				surface.drawString(Definitions.itemNames[anIntArray974[j5]] + ": @whi@" + Definitions.aStringArray64[anIntArray974[j5]], byte0 + 8, byte1 + 273, 1, 0xffff00);
		}

		for(int i6 = 0; i6 < anInt888; i6++) {
			int k6 = 9 + byte0 + (i6 % 4) * 49;
			int l6 = 156 + byte1 + (i6 / 4) * 34;
			surface.spriteClipping(k6, l6, 48, 32, spriteItem + Definitions.itemImages[anIntArray889[i6]], Definitions.itemMasks[anIntArray889[i6]], 0, 0, false);
			if(Definitions.inventoryItemsStackable[anIntArray889[i6]] == 0)
				surface.drawString(String.valueOf(anIntArray890[i6]), k6 + 1, l6 + 10, 1, 0xffff00);
			if(super.mouseX > k6 && super.mouseX < k6 + 48 && super.mouseY > l6 && super.mouseY < l6 + 32)
				surface.drawString(Definitions.itemNames[anIntArray889[i6]] + ": @whi@" + Definitions.aStringArray64[anIntArray889[i6]], byte0 + 8, byte1 + 273, 1, 0xffff00);
		}

	}

	//This is called via api/mixins
	public void updateBounds(int width, int height) {
		gameWidth = width;
		gameHeight = height - 12;
		boolean reset = gameWidth != surface.width2 || height + 12 != surface.height2;

        surface.resize(0, 0, gameWidth, height + 12);
		surface.width2 = gameWidth;
		surface.height2 = height + 12;
		gameWindow.resize(gameWidth, height + 12);

		if (reset) {
			int l = surface.width2 - 199;
			byte byte0 = 36;
			panelMagicPrayer.anInt208 = 0;
			controlListMagicPrayer = panelMagicPrayer.method152(l, byte0 + 24, 196, 90, 1, 500, true);
			panelSocialList.anInt208 = 0;
			controlListSocialPlayers = panelSocialList.method152(l, byte0 + 40, 196, 126, 1, 500, true);
			aPanel966.anInt208 = 0;
			anInt967 = aPanel966.method152(l, byte0 + 24, 196, 251, 1, 500, true);
		}

		if (scene != null) {
			scene.raster = Surface.pixels;
			scene.setBounds(gameWidth / 2, gameHeight / 2, gameWidth / 2, gameHeight / 2, gameWidth, anInt976);
		}
	}

	protected void startGame() {
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
			levelXPs[j] = i & 0xffffffc;
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
		loadData();
		if(errorLoadingData)
			return;
		spriteMedia = 2000;
		anInt941 = spriteMedia + 100;
		spriteItem = anInt941 + 50;
		spriteLogo = spriteItem + 1000;
		anInt942 = spriteLogo + 10;
		anInt933 = anInt942 + 50;
		anInt969 = anInt933 + 10;
		graphics = getGraphics();
		method18(50);
		surface = new SpriteSurface(gameWidth, gameHeight + 12, 4000, this);
		surface.resize(0, 0, gameWidth, gameHeight + 12);
		Panel.aBoolean190 = false;
		Panel.anInt191 = anInt941;
		panelMagicPrayer = new Panel(surface, 5);
		int l = surface.width2 - 199;
		byte byte0 = 36;
		controlListMagicPrayer = panelMagicPrayer.method152(l, byte0 + 24, 196, 90, 1, 500, true);
		panelSocialList = new Panel(surface, 5);
		controlListSocialPlayers = panelSocialList.method152(l, byte0 + 40, 196, 126, 1, 500, true);
		aPanel966 = new Panel(surface, 5);
		anInt967 = aPanel966.method152(l, byte0 + 24, 196, 251, 1, 500, true);
		method96();
		if(errorLoadingData)
			return;
		method85();
		if(errorLoadingData)
			return;
		scene = new Scene(surface, 15000, 15000, 1000);
		scene.setBounds(gameWidth / 2, gameHeight / 2, gameWidth / 2, gameHeight / 2, gameWidth, anInt976);
		scene.clipFar3d = 2400;
		scene.clipFar2d = 2400;
		scene.fogZFalloff = 1;
		scene.fogZDistance = 2300;
		scene.method309(-50, -10, -50);
		world = new World(scene, surface);
		world.anInt596 = spriteMedia;
		method110();
		if(errorLoadingData)
			return;
		method114();
		if(errorLoadingData)
			return;
		method95();
		if(errorLoadingData)
			return;
		if(isMembers)
			method108();
		if(errorLoadingData) {
        } else {
			loadSounds();
			method1(100, "Starting game...");
			createMessageTabPanel();
			method81();
			method102();
			method103();
			method4();
			method47();
        }
	}

	public static HashMap<String, File> soundCache = new HashMap<String, File>();

	private void loadSounds() {
		try {
			File folder = GameShell.dataDir;
			File[] listOfFiles = folder.listFiles();

            for (File listOfFile : listOfFiles)
                if (listOfFile.isFile() && listOfFile.getName().endsWith(".wav")) {
                    soundCache.put(listOfFile.getName().toLowerCase(), listOfFile);
                }
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void method114() {
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
			byte[] abyte0 = readDataFile("models" + Versions.anInt563 + ".jag", "3d models", 60);
			if(abyte0 == null) {
				errorLoadingData = true;
				return;
			}
			for(int j = 0; j < Definitions.anInt61; j++) {
				int k = DataUtils.method347(Definitions.aStringArray60[j] + ".ob3", abyte0);
				if(k != 0)
					gameModels[j] = new Model(abyte0, k, true);
				else
					gameModels[j] = new Model(1, 1);
				if(Definitions.aStringArray60[j].equals("giantcrystal"))
					gameModels[j].aBoolean267 = true;
			}

			return;
		}
		method1(70, "Loading 3d models");
		for(int i = 0; i < Definitions.anInt61; i++) {
			gameModels[i] = new Model("../gamedata/models/" + Definitions.aStringArray60[i] + ".ob2");
			if(Definitions.aStringArray60[i].equals("giantcrystal"))
				gameModels[i].aBoolean267 = true;
		}

	}

	private boolean method115(int i) {
		for(int j = 0; j < inventorySize; j++)
			if(inventoryItemsIDs[j] == i && inventoryItemsEquipped[j] == 1)
				return true;

		return false;
	}

	private void method116() {
		int i = 97;
		surface.method207(86, 77, 340, 180, 0);
		surface.method214(86, 77, 340, 180, 0xffffff);
		surface.drawStringCenter("Warning! Proceed with caution", 256, i, 4, 0xff0000);
		i += 26;
		surface.drawStringCenter("If you go much further north you will enter the", 256, i, 1, 0xffffff);
		i += 13;
		surface.drawStringCenter("wilderness. This a very dangerous area where", 256, i, 1, 0xffffff);
		i += 13;
		surface.drawStringCenter("other players can attack you!", 256, i, 1, 0xffffff);
		i += 22;
		surface.drawStringCenter("The further north you go the more dangerous it", 256, i, 1, 0xffffff);
		i += 13;
		surface.drawStringCenter("becomes, but the more treasure you will find.", 256, i, 1, 0xffffff);
		i += 22;
		surface.drawStringCenter("In the wilderness an indicator at the bottom-right", 256, i, 1, 0xffffff);
		i += 13;
		surface.drawStringCenter("of the screen will show the current level of danger", 256, i, 1, 0xffffff);
		i += 22;
		int j = 0xffffff;
		if(super.mouseY > i - 12 && super.mouseY <= i && super.mouseX > 181 && super.mouseX < 331)
			j = 0xff0000;
		surface.drawStringCenter("Click here to close window", 256, i, 1, j);
		if(mouseButtonClick != 0) {
			if(super.mouseY > i - 12 && super.mouseY <= i && super.mouseX > 181 && super.mouseX < 331)
				anInt811 = 2;
			if(super.mouseX < 86 || super.mouseX > 426 || super.mouseY < 77 || super.mouseY > 257)
				anInt811 = 2;
			mouseButtonClick = 0;
		}
	}

	private void drawDialogWelcome() {
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
		surface.drawStringCenter("Welcome to RuneScape " + loginUsername, 256, j, 4, 0xffff00);
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
			surface.drawStringCenter("You last logged in " + s, 256, j, 1, 0xffffff);
			j += 15;
			if(aString930 == null)
				aString930 = method90(anInt926);
			surface.drawStringCenter("from: " + aString930, 256, j, 1, 0xffffff);
			j += 15;
			j += 15;
		}
		if(anInt929 > 0) {
			int k = 0xffffff;
			surface.drawStringCenter("Jagex staff will NEVER email you. We use the", 256, j, 1, k);
			j += 15;
			surface.drawStringCenter("message-centre on this website instead.", 256, j, 1, k);
			j += 15;
			if(anInt929 == 1)
				surface.drawStringCenter("You have @yel@0@whi@ unread messages in your message-centre", 256, j, 1, 0xffffff);
			else
				surface.drawStringCenter("You have @gre@" + (anInt929 - 1) + " unread messages @whi@in your message-centre", 256, j, 1, 0xffffff);
			j += 15;
			j += 15;
		}
		if(anInt928 != 201) {
			if(anInt928 == 200) {
				surface.drawStringCenter("You have not yet set any password recovery questions.", 256, j, 1, 0xff8000);
				j += 15;
				surface.drawStringCenter("We strongly recommend you do so now to secure your account.", 256, j, 1, 0xff8000);
				j += 15;
				surface.drawStringCenter("Do this from the 'account management' area on our front webpage", 256, j, 1, 0xff8000);
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
				surface.drawStringCenter(s1 + " you changed your recovery questions", 256, j, 1, 0xff8000);
				j += 15;
				surface.drawStringCenter("If you do not remember making this change then cancel it immediately", 256, j, 1, 0xff8000);
				j += 15;
				surface.drawStringCenter("Do this from the 'account management' area on our front webpage", 256, j, 1, 0xff8000);
				j += 15;
			}
			j += 15;
		}
		int l = 0xffffff;
		if(super.mouseY > j - 12 && super.mouseY <= j && super.mouseX > 106 && super.mouseX < 406)
			l = 0xff0000;
		surface.drawStringCenter("Click here to close window", 256, j, 1, l);
		if(mouseButtonClick == 1) {
			if(l == 0xff0000)
				aBoolean810 = false;
			if((super.mouseX < 86 || super.mouseX > 426) && (super.mouseY < 167 - i / 2 || super.mouseY > 167 + i / 2))
				aBoolean810 = false;
		}
		mouseButtonClick = 0;
	}

	void drawItem(int i, int j, int k, int l, int i1, int j1, int k1) {
		int image = Definitions.itemImages[i1] + spriteItem;
		int mask = Definitions.itemMasks[i1];
		surface.spriteClipping(i, j, k, l, image, mask, 0, 0, false);
	}

	private void doCycleLoggedIn() {
		if(systemUpdateTimer > 1)
			systemUpdateTimer--;
		checkConnection();
		if(logoutTimeout > 0)
			logoutTimeout--;
		if(super.mouseIdleCycles > 4500 && combatTimeout == 0 && logoutTimeout == 0) {
			super.mouseIdleCycles -= 500;
			logout();
			return;
		}
		if(localPlayer.animation == 8 || localPlayer.animation == 9)
			combatTimeout = 500;
		if(combatTimeout > 0)
			combatTimeout--;
		if(changeAppearanceVisible) {
			processChangeAppearance();
			return;
		}
		for(int i = 0; i < playerCount; i++) {
			Character character = players[i];
			int k = (character.waypointCurrent + 1) % 10;
			if(character.movingStep != k) {
				int i1 = -1;
				int l2 = character.movingStep;
				int j4;
				if(l2 < k)
					j4 = k - l2;
				else
					j4 = (10 + k) - l2;
				int j5 = 4;
				if(j4 > 2)
					j5 = (j4 - 1) * 4;
				if(character.waypointsX[l2] - character.currentX > magicLoc * 3 || character.waypointsY[l2] - character.currentY > magicLoc * 3 || character.waypointsX[l2] - character.currentX < -magicLoc * 3 || character.waypointsY[l2] - character.currentY < -magicLoc * 3 || j4 > 8) {
					character.currentX = character.waypointsX[l2];
					character.currentY = character.waypointsY[l2];
				} else {
					if(character.currentX < character.waypointsX[l2]) {
						character.currentX += j5;
						character.stepCount++;
						i1 = 2;
					} else
					if(character.currentX > character.waypointsX[l2]) {
						character.currentX -= j5;
						character.stepCount++;
						i1 = 6;
					}
					if(character.currentX - character.waypointsX[l2] < j5 && character.currentX - character.waypointsX[l2] > -j5)
						character.currentX = character.waypointsX[l2];
					if(character.currentY < character.waypointsY[l2]) {
						character.currentY += j5;
						character.stepCount++;
						if(i1 == -1)
							i1 = 4;
						else
						if(i1 == 2)
							i1 = 3;
						else
							i1 = 5;
					} else
					if(character.currentY > character.waypointsY[l2]) {
						character.currentY -= j5;
						character.stepCount++;
						if(i1 == -1)
							i1 = 0;
						else
						if(i1 == 2)
							i1 = 1;
						else
							i1 = 7;
					}
					if(character.currentY - character.waypointsY[l2] < j5 && character.currentY - character.waypointsY[l2] > -j5)
						character.currentY = character.waypointsY[l2];
				}
				if(i1 != -1)
					character.animation = i1;
				if(character.currentX == character.waypointsX[l2] && character.currentY == character.waypointsY[l2])
					character.movingStep = (l2 + 1) % 10;
			} else {
				character.animation = character.nextAnimation;
			}
			if(character.messageTimeout > 0)
				character.messageTimeout--;
			if(character.bubbleTimeout > 0)
				character.bubbleTimeout--;
			if(character.combatTimer > 0)
				character.combatTimer--;
			if(deathScreenTimeout > 0) {
				deathScreenTimeout--;
				if(deathScreenTimeout == 0)
					sendMessage("You have been granted another life. Be more careful this time!", 3);
				if(deathScreenTimeout == 0)
					sendMessage("You retain your skills. Your objects land where you died", 3);
			}
		}

		for(int j = 0; j < npcCount; j++) {
			Character rscharacter1 = npcs[j];
			int j1 = (rscharacter1.waypointCurrent + 1) % 10;
			if(rscharacter1.movingStep != j1) {
				int i3 = -1;
				int k4 = rscharacter1.movingStep;
				int k5;
				if(k4 < j1)
					k5 = j1 - k4;
				else
					k5 = (10 + j1) - k4;
				int l5 = 4;
				if(k5 > 2)
					l5 = (k5 - 1) * 4;
				if(rscharacter1.waypointsX[k4] - rscharacter1.currentX > magicLoc * 3 || rscharacter1.waypointsY[k4] - rscharacter1.currentY > magicLoc * 3 || rscharacter1.waypointsX[k4] - rscharacter1.currentX < -magicLoc * 3 || rscharacter1.waypointsY[k4] - rscharacter1.currentY < -magicLoc * 3 || k5 > 8) {
					rscharacter1.currentX = rscharacter1.waypointsX[k4];
					rscharacter1.currentY = rscharacter1.waypointsY[k4];
				} else {
					if(rscharacter1.currentX < rscharacter1.waypointsX[k4]) {
						rscharacter1.currentX += l5;
						rscharacter1.stepCount++;
						i3 = 2;
					} else
					if(rscharacter1.currentX > rscharacter1.waypointsX[k4]) {
						rscharacter1.currentX -= l5;
						rscharacter1.stepCount++;
						i3 = 6;
					}
					if(rscharacter1.currentX - rscharacter1.waypointsX[k4] < l5 && rscharacter1.currentX - rscharacter1.waypointsX[k4] > -l5)
						rscharacter1.currentX = rscharacter1.waypointsX[k4];
					if(rscharacter1.currentY < rscharacter1.waypointsY[k4]) {
						rscharacter1.currentY += l5;
						rscharacter1.stepCount++;
						if(i3 == -1)
							i3 = 4;
						else
						if(i3 == 2)
							i3 = 3;
						else
							i3 = 5;
					} else
					if(rscharacter1.currentY > rscharacter1.waypointsY[k4]) {
						rscharacter1.currentY -= l5;
						rscharacter1.stepCount++;
						if(i3 == -1)
							i3 = 0;
						else
						if(i3 == 2)
							i3 = 1;
						else
							i3 = 7;
					}
					if(rscharacter1.currentY - rscharacter1.waypointsY[k4] < l5 && rscharacter1.currentY - rscharacter1.waypointsY[k4] > -l5)
						rscharacter1.currentY = rscharacter1.waypointsY[k4];
				}
				if(i3 != -1)
					rscharacter1.animation = i3;
				if(rscharacter1.currentX == rscharacter1.waypointsX[k4] && rscharacter1.currentY == rscharacter1.waypointsY[k4])
					rscharacter1.movingStep = (k4 + 1) % 10;
			} else {
				rscharacter1.animation = rscharacter1.nextAnimation;
				if(rscharacter1.npcID == 43)
					rscharacter1.stepCount++;
			}
			if(rscharacter1.messageTimeout > 0)
				rscharacter1.messageTimeout--;
			else if (injected)
				rscharacter1.message = null;
			if(rscharacter1.bubbleTimeout > 0)
				rscharacter1.bubbleTimeout--;
			if(rscharacter1.combatTimer > 0)
				rscharacter1.combatTimer--;
		}

		if(showUiTab != 2) {
			if(Surface.anInt338 > 0)
				sleepWordDelayTimer++;
			if(Surface.anInt339 > 0)
				sleepWordDelayTimer = 0;
			Surface.anInt338 = 0;
			Surface.anInt339 = 0;
		}
		for(int l = 0; l < playerCount; l++) {
			Character rscharacter2 = players[l];
			if(rscharacter2.projectileRange > 0)
				rscharacter2.projectileRange--;
		}

		if(cameraAutoAngleDebug) {
			if(cameraAutoRotatePlayerX - localPlayer.currentX < -500 || cameraAutoRotatePlayerX - localPlayer.currentX > 500 || cameraAutoRotatePlayerY - localPlayer.currentY < -500 || cameraAutoRotatePlayerY - localPlayer.currentY > 500) {
				cameraAutoRotatePlayerX = localPlayer.currentX;
				cameraAutoRotatePlayerY = localPlayer.currentY;
			}
		} else {
			if(cameraAutoRotatePlayerX - localPlayer.currentX < -500 || cameraAutoRotatePlayerX - localPlayer.currentX > 500 || cameraAutoRotatePlayerY - localPlayer.currentY < -500 || cameraAutoRotatePlayerY - localPlayer.currentY > 500) {
				cameraAutoRotatePlayerX = localPlayer.currentX;
				cameraAutoRotatePlayerY = localPlayer.currentY;
			}
			//These changes prevent camera snapping when zoomed out far
			if(cameraAutoRotatePlayerX != localPlayer.currentX)
				if (!injected)
					cameraAutoRotatePlayerX += (localPlayer.currentX - cameraAutoRotatePlayerX) / (16 + (cameraZoom - 500) / 15);
				else
					cameraAutoRotatePlayerX += (localPlayer.currentX - cameraAutoRotatePlayerX) / 64;
			if(cameraAutoRotatePlayerY != localPlayer.currentY)
				if (!injected)
					cameraAutoRotatePlayerY += (localPlayer.currentY - cameraAutoRotatePlayerY) / (16 + (cameraZoom - 500) / 15);
				else
					cameraAutoRotatePlayerY += (localPlayer.currentY - cameraAutoRotatePlayerY) / 64;
			if(optionCameraModeAuto) {
				int k1 = cameraAngle * 32;
				int j3 = k1 - cameraRotation;
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
					cameraRotation += ((anInt978 * j3 + 255) / 256) * byte0;
					cameraRotation &= 0xff;
				} else {
					anInt978 = 0;
				}
			}
		}
		if(sleepWordDelayTimer > 20) {
			sleepWordDelay = false;
			sleepWordDelayTimer = 0;
		}
		if(isSleeping) {
			if(super.inputTextFinal.length() > 0)
				if(super.inputTextFinal.equalsIgnoreCase("::lostcon") && !aBoolean782)
					super.packetStream.method339();
				else
				if(super.inputTextFinal.equalsIgnoreCase("::closecon") && !aBoolean782) {
					closeConnection();
				} else {
					super.packetStream.createPacket(45);
					super.packetStream.method329(super.inputTextFinal);
					if(!sleepWordDelay) {
						super.packetStream.putByte(0);
						sleepWordDelay = true;
					}
					super.packetStream.endPacket();
					super.inputTextCurrent = "";
					super.inputTextFinal = "";
					sleepingStatusText = "Please wait...";
				}
			if(super.lastMouseButtonDown == 1 && super.mouseY > 275 && super.mouseY < 310 && super.mouseX > 56 && super.mouseX < 456) {
				super.packetStream.createPacket(45);
				super.packetStream.method329("-null-");
				if(!sleepWordDelay) {
					super.packetStream.putByte(0);
					sleepWordDelay = true;
				}
				super.packetStream.endPacket();
				super.inputTextCurrent = "";
				super.inputTextFinal = "";
				sleepingStatusText = "Please wait...";
			}
			super.lastMouseButtonDown = 0;
			return;
		}
		if(super.mouseY > gameHeight - 4) {
			if(super.mouseX > 15 && super.mouseX < 96 && super.lastMouseButtonDown == 1)
				messageTabSelected = 0;
			if(super.mouseX > 110 && super.mouseX < 194 && super.lastMouseButtonDown == 1) {
				messageTabSelected = 1;
				panelMessageTabs.controlFlashText[controlTextListChat] = 0xf423f;
			}
			if(super.mouseX > 215 && super.mouseX < 295 && super.lastMouseButtonDown == 1) {
				messageTabSelected = 2;
				panelMessageTabs.controlFlashText[controlTextListQuest] = 0xf423f;
			}
			if(super.mouseX > 315 && super.mouseX < 395 && super.lastMouseButtonDown == 1) {
				messageTabSelected = 3;
				panelMessageTabs.controlFlashText[controlTextListPrivate] = 0xf423f;
			}
			if(super.mouseX > 417 && super.mouseX < 497 && super.lastMouseButtonDown == 1) {
				showDialogReportAbuseStep = 1;
				reportAbuseOffence = 0;
				super.inputTextCurrent = "";
				super.inputTextFinal = "";
			}
			super.lastMouseButtonDown = 0;
			super.mouseButtonDown = 0;
		}
		panelMessageTabs.handleMouse(super.mouseX, super.mouseY, super.lastMouseButtonDown, super.mouseButtonDown);
		if(messageTabSelected > 0 && super.mouseX >= 494 && super.mouseY >= gameHeight - 66)
			super.lastMouseButtonDown = 0;
		if(panelMessageTabs.isClicked(controlTextListAll)) {
			String s = panelMessageTabs.getText(controlTextListAll);
			panelMessageTabs.updateText(controlTextListAll, "");
			if(s.startsWith("::")) {
				if(s.equalsIgnoreCase("::closecon") && !aBoolean782)
					super.packetStream.method339();
				else
				if(s.equalsIgnoreCase("::logout") && !aBoolean782)
					closeConnection();
				else
				if(s.equalsIgnoreCase("::lostcon") && !aBoolean782)
					lostConnection();
				else
					sendCommandString(s.substring(2));
			} else {
				int k3 = ChatEncoding.scramble(s);
				sendChatMessagePacket(ChatEncoding.scrambledbytes, k3);

				try {
					s = ChatEncoding.method388(ChatEncoding.scrambledbytes, 0, k3);
					//TODO: Check
					//s = ChatFilter.method380(s);
					localPlayer.messageTimeout = 150;
					localPlayer.message = s;
					sendMessage(localPlayer.name + ": " + s, 2);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		}
		if(messageTabSelected == 0) {
			for(int l1 = 0; l1 < 5; l1++)
				if(messageHistoryTimeout[l1] > 0)
					messageHistoryTimeout[l1]--;

		}
		if(deathScreenTimeout != 0)
			super.lastMouseButtonDown = 0;
		if(showDialogTrade || showDialogDuel) {
			if(super.mouseButtonDown != 0)
				mouseButtonDownTime++;
			else
				mouseButtonDownTime = 0;
			if(mouseButtonDownTime > 600)
				mouseButtonItemCountIncrement += 5000;
			else
			if(mouseButtonDownTime > 450)
				mouseButtonItemCountIncrement += 500;
			else
			if(mouseButtonDownTime > 300)
				mouseButtonItemCountIncrement += 50;
			else
			if(mouseButtonDownTime > 150)
				mouseButtonItemCountIncrement += 5;
			else
			if(mouseButtonDownTime > 50)
				mouseButtonItemCountIncrement++;
			else
			if(mouseButtonDownTime > 20 && (mouseButtonDownTime & 5) == 0)
				mouseButtonItemCountIncrement++;
		} else {
			mouseButtonDownTime = 0;
			mouseButtonItemCountIncrement = 0;
		}
		if(super.lastMouseButtonDown == 1)
			mouseButtonClick = 1;
		else
		if(super.lastMouseButtonDown == 2)
			mouseButtonClick = 2;
		scene.setMouseLocation(super.mouseX, super.mouseY);
		super.lastMouseButtonDown = 0;
		if(optionCameraModeAuto) {
			if(anInt978 == 0 || cameraAutoAngleDebug) {
				if(super.keyLeft) {
					cameraAngle = cameraAngle + 1 & 7;
					super.keyLeft = false;
					if(!fogOfWar) {
						if((cameraAngle & 1) == 0)
							cameraAngle = cameraAngle + 1 & 7;
						for(int i2 = 0; i2 < 8; i2++) {
							if(isValidCameraAngle(cameraAngle))
								break;
							cameraAngle = cameraAngle + 1 & 7;
						}

					}
				}
				if(super.keyRight) {
					cameraAngle = cameraAngle + 7 & 7;
					super.keyRight = false;
					if(!fogOfWar) {
						if((cameraAngle & 1) == 0)
							cameraAngle = cameraAngle + 7 & 7;
						for(int j2 = 0; j2 < 8; j2++) {
							if(isValidCameraAngle(cameraAngle))
								break;
							cameraAngle = cameraAngle + 7 & 7;
						}

					}
				}
			}
		} else
		if(super.keyLeft)
			cameraRotation = cameraRotation + 2 & 0xff;
		else
		if(super.keyRight)
			cameraRotation = cameraRotation - 2 & 0xff;
		if(fogOfWar && cameraZoom > 550)
			cameraZoom -= 4;
		else
		if(!fogOfWar && cameraZoom < 200)
			cameraZoom += 4;
		if(mouseClickXStep > 0)
			mouseClickXStep--;
		else
		if(mouseClickXStep < 0)
			mouseClickXStep++;
		scene.handleFountains(17);
		objectAnimationCount++;
		if(objectAnimationCount > 5) {
			objectAnimationCount = 0;
			objectAnimationNumberFireLightningSpell = (objectAnimationNumberFireLightningSpell + 1) % 3;
			objectAnimationNumberTorch = (objectAnimationNumberTorch + 1) % 4;
			objectAnimationNumberClaw = (objectAnimationNumberClaw + 1) % 5;
		}
		for(int objectIdx = 0; objectIdx < objectCount; objectIdx++) {
			int l3 = objectX[objectIdx];
			int l4 = objectY[objectIdx];
			if(l3 >= 0 && l4 >= 0 && l3 < 96 && l4 < 96 && objectID[objectIdx] == 74)
				objectModel[objectIdx].rotate(1, 0, 0);
		}

		for(int i4 = 0; i4 < teleportBubbleCount; i4++) {
			teleportBubbleTime[i4]++;
			if(teleportBubbleTime[i4] > 50) {
				teleportBubbleCount--;
				for(int i5 = i4; i5 < teleportBubbleCount; i5++) {
					teleportBubbleX[i5] = teleportBubbleX[i5 + 1];
					teleportBubbleY[i5] = teleportBubbleY[i5 + 1];
					teleportBubbleTime[i5] = teleportBubbleTime[i5 + 1];
					teleportBubbleType[i5] = teleportBubbleType[i5 + 1];
				}

			}
		}

	}

	private void method120() {
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
	private final String aString648;
	private final String aString649;
	private final int anInt650;
	private final String[] aStringArray651 = {
		"Where were you born?", "What was your first teachers name?", "What is your fathers middle name?", "Who was your first best friend?", "What is your favourite vacation spot?", "What is your mothers middle name?", "What was your first pets name?", "What was the name of your first school?", "What is your mothers maiden name?", "Who was your first boyfriend/girlfriend?", 
		"What was the first computer game you purchased?", "Who is your favourite actor/actress?", "Who is your favourite author?", "Who is your favourite musician?", "Who is your favourite cartoon character?", "What is your favourite book?", "What is your favourite food?", "What is your favourite movie?"
	};
	private int cameraAngle;
	private int mouseButtonClick;
	private SpriteSurface surface;
	private final String[] menuOptions;
	private int optionMenuCount;
	private boolean showOptionMenu;
	private World world;
	private Model[] gameModels;
	public Scene scene;
	private int spriteMedia;
	private int spriteLogo;
	private final int[] teleportBubbleType;
	private final int[] teleportBubbleTime;
	private int anInt662;
	private int anInt663;
	private final int[] anIntArray664;
	private final int[] anIntArray665;
	private final int[] anIntArray666;
	private final int[] anIntArray667;
	private int bankItemsMax;
	private final int[] inventoryItemsIDs;
	private int inventorySize;
	int[] anIntArray671;
	private int anInt672;
	int[] anIntArray673;
	private int combatTimeout;
	private int logoutTimeout;
	private final int magicLoc;
	private Character[] npcs;
	private int cameraRotation;
	private final int[] anIntArray679 = {
		0, 1, 2, 1
	};
	private final int[] anIntArray680 = {
		0, 1, 2, 1, 0, 0, 0, 0
	};
	private int cycle;
	private final int[] anIntArray682 = {
		0, 0, 0, 0, 0, 1, 2, 1
	};
	private final int[][] anIntArrayArray683 = {
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
	private final int[] recievedMessageMidPoint;
	private int anInt685;
	private final int[] revievedMessageHeight;
	private final int[] receivedMessageX;
	private final int[] receivedMessageY;
	String[] aStringArray689;
	private final int[] anIntArray690;
	private int anInt691;
	private final int[] anIntArray692;
	private final int[] anIntArray693;
	private Character[] players;
	private final int[] anIntArray695 = {
		0xecded0, 0xccb366, 0xb38c40, 0x997326, 0x906020
	};
	private final int[] anIntArray696 = {
		0xffc030, 0xffa040, 0x805030, 0x604020, 0x303030, 0xff6020, 0xff4000, 0xffffff, 65280, 65535
	};
	private final int[] anIntArray697 = {
		0xff0000, 0xff8000, 0xffe000, 0xa0e000, 57344, 32768, 41088, 45311, 33023, 12528, 
		0xe000e0, 0x303030, 0x604000, 0x805000, 0xffffff
	};
	private final int[] anIntArray698;
	private int anInt699;
	private final int[] anIntArray700;
	private final int[] anIntArray701;
	private final int[] anIntArray702;
	private final boolean errorLoadingCodebase;
	private boolean errorLoadingMemory;
	private boolean errorLoadingData;
	private int loggedIn;
	private int cameraRotationTime;
	private int cameraRotationX;
	private int cameraRotationXIncrement;
	private int cameraRotationY;
	private int cameraRotationYIncrement;
	private int messageTabFlashAll;
	private int messageTabFlashHistory;
	private int messtageTabFlashQuest;
	private int messageTabFlashPrivate;
	private Character[] aCharacterArray716;
	private final Character[] aCharacterArray717;
	private int anInt718;
	private int npcCount;
	private int anInt720;
	private int anInt721;
	private int anInt722;
	private final int[] menuIdxs;
	private int menuItemsCount;
	private boolean showRightClickMenu;
	private int anInt726;
	private final String[] aStringArray727;
	private final String[] aStringArray728;
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
	private final int anInt750;
	private boolean changeAppearanceVisible;
	int sceneX;
	int sceneY;
	private int anInt754;
	private int anInt755;
	private Character localPlayer;
	private final int[] objectX;
	private final int[] objectY;
	private int objectCount;
	private final int[] anIntArray760;
	private final int[] anIntArray761;
	private int anInt762;
	private int playerCount;
	public static int gameWidth;
	public static int gameHeight;

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
	private String loginUsername;
	private String aString779;
	private int showUiTab;
	private final int inventoryMaxItemCount;
	private boolean aBoolean782;
	private SoundPlayer aSunAudioPlayer783;
	private boolean aBoolean784;
	private byte[] aByteArray785;
	private int spriteItem;
	private Model[] objectModel;
	private boolean aBoolean788;
	private String aString789;
	private boolean aBoolean790;
	private int anInt791;
	private int showDialogReportAbuseStep;
	private boolean isSleeping;
	private Panel panelMessageTabs;
	private final int[] inventoryItemsQuantities;
	private final int[] walkPathX;
	private final int[] walkPathY;
	private int baseX;
	private int baseY;
	private int mouseClickXStep;
	int anInt801;
	int anInt802;
	private int systemUpdateTimer;
	private int anInt804;
	private String aString805;
	private Character[] aCharacterArray806;
	private final Character[] aCharacterArray807;
	private int anInt808;
	private Graphics graphics;
	private boolean aBoolean810;
	private int anInt811;
	private boolean aBoolean812;
	private boolean aBoolean813;
	private boolean showDialogTradeConfirm;
	private boolean showDialogTrade;
	private boolean aBoolean816;
	private boolean showDialogDuel;
	private boolean aBoolean818;
	private int combatStyle;
	private final int[] objectID;
	private Model[] aModelArray821;
	private final int[] anIntArray822;
	private final int[] anIntArray823;
	private final int[] wallObjectDirection;
	private final int[] wallObjectID;
	private int anInt826;
	private final boolean[] aBooleanArray827;
	private int anInt828;
	private int anInt829;
	private final boolean[] aBooleanArray830;
	private final boolean[] aBooleanArray831;
	private int selectedSpell;
	private final int[] menuItemOpcodes;
	private final int[] menuItemX;
	private final int[] menuItemY;
	private final int[] menuItemIDs;
	private final int[] menuItemSourceIdxs;
	private int selectedItemSlot;
	String selectedItemName;
	private boolean isMembers;
	private final int[] anIntArray841;
	private final int[] realSkillLevels;
	private final int[] objectDirection;
	private final int[] menuItemTargerIdxs;
	int messageTabSelected;
	private int anInt846;
	private int anInt847;
	private int anInt848;
	private final int[] shopCategoryID;
	private int shopSelectedItemIndex;
	private int shopSelectedItemType;
	private final int[] shopItemQuantities;
	private int shopPriceMod;
	private final int[] shopItemPrices;
	private int anInt855;
	private final String[] aStringArray856;
	private final int[] messageHistoryTimeout;
	int controlTextListChat;
	int controlTextListQuest;
	int controlTextListPrivate;
	private boolean aBoolean861;
	private int anInt862;
	long aLong863;
	private int anInt864;
	private int anInt865;
	int anInt866;
	private Panel panelSocialList;
	int controlListSocialPlayers;
	private boolean optionCameraModeAuto;
	int controlTextListAll;
	int localPlayerServerIdx;
	private final int[] anIntArray872;
	private final int[] anIntArray873;
	private final int[] inventoryItemsEquipped;
	private final int[] boostedSkillLevels;
	private final int anInt876;
	private boolean aBoolean877;
	private int anInt878;
	private int anInt879;
	private final int[] skillXPs;
	private int anInt881;
	private final int[] anIntArray882;
	private int deathScreenTimeout;
	private String aString884;
	private boolean aBoolean885;
	private boolean aBoolean886;
	private int anInt887;
	private int anInt888;
	private final int[] anIntArray889;
	private final int[] anIntArray890;
	private final boolean[] aBooleanArray891;
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
	private final int[] anIntArray904;
	private final int[] anIntArray905;
	private int anInt906;
	private final int[] anIntArray907;
	private final int[] anIntArray908;
	private final int[] anIntArray909;
	private final int[] anIntArray910;
	private boolean aBoolean911;
	private long aLong912;
	private int anInt913;
	private final int[] anIntArray914;
	private final int[] anIntArray915;
	private int anInt916;
	private final int[] anIntArray917;
	private final int[] anIntArray918;
	private int anInt919;
	private int anInt920;
	private int anInt921;
	private int anInt922;
	private int teleportBubbleCount;
	private final int[] teleportBubbleX;
	private final int[] teleportBubbleY;
	private int anInt926;
	private int anInt927;
	private int anInt928;
	private int anInt929;
	private String aString930;
	private int statFatigue;
	private int anInt932;
	private int anInt933;
	private String sleepingStatusText;
	private int anInt935;
	private static int plane;
	private int anInt937;
	private int anInt938;
	private int anInt939;
	private int anInt940;
	private int anInt941;
	private int anInt942;
	private int reportAbuseOffence;
	private boolean aBoolean944;
	private boolean fogOfWar;
	private int objectAnimationNumberFireLightningSpell;
	private int anInt947;
	private int objectAnimationNumberTorch;
	private int anInt949;
	private int objectAnimationNumberClaw;
	private int anInt951;
	private int anInt952;
	private final boolean cameraAutoAngleDebug;
	private int cameraAutoRotatePlayerX;
	private int cameraAutoRotatePlayerY;
	private int cameraZoom;
	private String aString957;
	int anInt958;
	private Panel panelMagicPrayer;
	int controlListMagicPrayer;
	int anInt961;
	private final String[] skillNamesShort = {
		"Attack", "Defense", "Strength", "Hits", "Ranged", "Prayer", "Magic", "Cooking", "Woodcut", "Fletching", 
		"Fishing", "Firemaking", "Crafting", "Smithing", "Mining", "Herblaw", "Agility", "Thieving"
	};
	private final String[] aStringArray963 = {
		"Armour", "WeaponAim", "WeaponPower", "Magic", "Prayer"
	};
	private final String[] skillNameLong = {
		"Attack", "Defense", "Strength", "Hits", "Ranged", "Prayer", "Magic", "Cooking", "Woodcutting", "Fletching", 
		"Fishing", "Firemaking", "Crafting", "Smithing", "Mining", "Herblaw", "Agility", "Thieving"
	};
	private final int[] levelXPs;
	private Panel aPanel966;
	int anInt967;
	private final String[] aStringArray968 = {
		"Black knight's fortress", "Cook's assistant", "Demon slayer", "Doric's quest", "The restless ghost", "Goblin diplomacy", "Ernest the chicken", "Imp catcher", "Pirate's treasure", "Prince Ali rescue", 
		"Romeo & Juliet", "Sheep shearer", "Shield of Arrav", "The knight's sword", "Vampire slayer", "Witch's potion", "Dragon slayer", "Witch's house (members)", "Lost city (members)", "Hero's quest (members)", 
		"Druidic ritual (members)", "Merlin's crystal (members)", "Scorpion catcher (members)", "Family crest (members)", "Tribal totem (members)", "Fishing contest (members)", "Monk's friend (members)", "Temple of Ikov (members)", "Clock tower (members)", "The Holy Grail (members)", 
		"Fight Arena (members)", "Tree Gnome Village (members)", "The Hazeel Cult (members)", "Sheep Herder (members)", "Plague City (members)", "Sea Slug (members)", "Waterfall quest (members)", "Biohazard (members)", "Jungle potion (members)", "Grand tree (members)", 
		"Shilo village (members)", "Underground pass (members)", "Observatory quest (members)", "Tourist trap (members)", "Watchtower (members)", "Dwarf Cannon (members)", "Murder Mystery (members)", "Digsite (members)", "Gertrude's Cat (members)", "Legend's Quest (members)"
	};
	private int anInt969;
	private int mouseButtonItemCountIncrement;
	private final int[] anIntArray971;
	private final int[] anIntArray972;
	private int mouseButtonDownTime;
	private final int[] anIntArray974;
	private final int[] anIntArray975;
	private final int anInt976;
	private int sleepWordDelayTimer;
	private int anInt978;
	private boolean sleepWordDelay;
	private int objectAnimationCount;

	public void setModelData(Model model, int objectID, int localX, int localY, int width, boolean wallObject) {

	}
}
