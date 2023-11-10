// Decompiled by Jad v1.5.8c. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 


public class Panel {

	protected void method137(int i, int j, int k, int l, String[] as) {
		int i1 = 0;
		int j1 = as.length;
		for(int k1 = 0; k1 < j1; k1++) {
			i1 += aSurface181.textWidth(as[k1], l);
			if(k1 < j1 - 1)
				i1 += aSurface181.textWidth("  ", l);
		}

		int l1 = j - i1 / 2;
		int i2 = k + aSurface181.method238(l) / 3;
		for(int j2 = 0; j2 < j1; j2++) {
			int k2;
			if(aBooleanArray182[i])
				k2 = 0xffffff;
			else
				k2 = 0;
			if(mouseX >= l1 && mouseX <= l1 + aSurface181.textWidth(as[j2], l) && mouseY <= i2 && mouseY > i2 - aSurface181.method238(l)) {
				if(aBooleanArray182[i])
					k2 = 0x808080;
				else
					k2 = 0xffffff;
				if(anInt185 == 1) {
					anIntArray186[i] = j2;
					aBooleanArray187[i] = true;
				}
			}
			if(anIntArray186[i] == j2)
				if(aBooleanArray182[i])
					k2 = 0xff0000;
				else
					k2 = 0xc00000;
			aSurface181.drawString(as[j2], l1, i2, l, k2);
			l1 += aSurface181.textWidth(as[j2] + "  ", l);
		}

	}

	public void method138(int i, int j, int k, int l) {
		aSurface181.resize(i, j, i + k, j + l);
		aSurface181.method226(i, j, k, l, anInt188, anInt189);
		if(aBoolean190) {
			for(int i1 = i - (j & 0x3f); i1 < i + k; i1 += 128) {
				for(int j1 = j - (j & 0x1f); j1 < j + l; j1 += 128)
					aSurface181.method260(i1, j1, 6 + anInt191, 128);

			}

		}
		aSurface181.drawHorizontalLine(i, j, k, anInt189);
		aSurface181.drawHorizontalLine(i + 1, j + 1, k - 2, anInt189);
		aSurface181.drawHorizontalLine(i + 2, j + 2, k - 4, anInt192);
		aSurface181.method217(i, j, l, anInt189);
		aSurface181.method217(i + 1, j + 1, l - 2, anInt189);
		aSurface181.method217(i + 2, j + 2, l - 4, anInt192);
		aSurface181.drawHorizontalLine(i, (j + l) - 1, k, anInt188);
		aSurface181.drawHorizontalLine(i + 1, (j + l) - 2, k - 2, anInt188);
		aSurface181.drawHorizontalLine(i + 2, (j + l) - 3, k - 4, anInt193);
		aSurface181.method217((i + k) - 1, j, l, anInt188);
		aSurface181.method217((i + k) - 2, j + 1, l - 2, anInt188);
		aSurface181.method217((i + k) - 3, j + 2, l - 4, anInt193);
		aSurface181.resetBounds();
	}

	public void method139(int i, int j, String s) {
		aStringArrayArray194[i][j] = s;
		if(j + 1 > anIntArray195[i])
			anIntArray195[i] = j + 1;
	}

	public void method140(int i, int j, int k, int l) {
		aSurface181.method207(i, j, k, l, 0);
		aSurface181.method214(i, j, k, l, anInt196);
		aSurface181.method214(i + 1, j + 1, k - 2, l - 2, anInt197);
		aSurface181.method214(i + 2, j + 2, k - 4, l - 4, anInt198);
		aSurface181.drawSprite(i, j, 2 + anInt191);
		aSurface181.drawSprite((i + k) - 7, j, 3 + anInt191);
		aSurface181.drawSprite(i, (j + l) - 7, 4 + anInt191);
		aSurface181.drawSprite((i + k) - 7, (j + l) - 7, 5 + anInt191);
	}

	public void method141(int i, String s, boolean flag) {
		int j = anIntArray195[i]++;
		if(j >= anIntArray199[i]) {
			j--;
			anIntArray195[i]--;
			for(int k = 0; k < j; k++)
				aStringArrayArray194[i][k] = aStringArrayArray194[i][k + 1];

		}
		aStringArrayArray194[i][j] = s;
		if(flag)
			controlFlashText[i] = 0xf423f;
	}

	public void handleMouse(int i, int j, int k, int l) {
		mouseX = i;
		mouseY = j;
		anInt201 = l;
		if(k != 0)
			anInt185 = k;
		if(k == 1) {
			for(int i1 = 0; i1 < anInt208; i1++) {
				if(aBooleanArray202[i1] && anIntArray203[i1] == 10 && mouseX >= anIntArray204[i1] && mouseY >= anIntArray205[i1] && mouseX <= anIntArray204[i1] + anIntArray206[i1] && mouseY <= anIntArray205[i1] + anIntArray207[i1])
					aBooleanArray187[i1] = true;
				if(aBooleanArray202[i1] && anIntArray203[i1] == 14 && mouseX >= anIntArray204[i1] && mouseY >= anIntArray205[i1] && mouseX <= anIntArray204[i1] + anIntArray206[i1] && mouseY <= anIntArray205[i1] + anIntArray207[i1])
					anIntArray186[i1] = 1 - anIntArray186[i1];
			}

		}
		if(l == 1)
			anInt209++;
		else
			anInt209 = 0;
		if(k == 1 || anInt209 > 20) {
			for(int j1 = 0; j1 < anInt208; j1++)
				if(aBooleanArray202[j1] && anIntArray203[j1] == 15 && mouseX >= anIntArray204[j1] && mouseY >= anIntArray205[j1] && mouseX <= anIntArray204[j1] + anIntArray206[j1] && mouseY <= anIntArray205[j1] + anIntArray207[j1])
					aBooleanArray187[j1] = true;

			anInt209 -= 5;
		}
	}

	protected void method143(int i, int j, int k) {
		aSurface181.drawHorizontalLine(i, j, k, 0);
	}

	protected void method144(int i, int j, int k, int l, int i1) {
		aSurface181.method207(j, k, l, i1, 0xffffff);
		aSurface181.drawHorizontalLine(j, k, l, anInt189);
		aSurface181.method217(j, k, i1, anInt189);
		aSurface181.drawHorizontalLine(j, (k + i1) - 1, l, anInt188);
		aSurface181.method217((j + l) - 1, k, i1, anInt188);
		if(anIntArray186[i] == 1) {
			for(int j1 = 0; j1 < i1; j1++) {
				aSurface181.drawHorizontalLine(j + j1, k + j1, 1, 0);
				aSurface181.drawHorizontalLine((j + l) - 1 - j1, k + j1, 1, 0);
			}

		}
	}

	protected void method145(int i, int j, int k, int l, String[] as) {
		int i1 = as.length;
		int j1 = k - (aSurface181.method238(l) * (i1 - 1)) / 2;
		for(int k1 = 0; k1 < i1; k1++) {
			int l1;
			if(aBooleanArray182[i])
				l1 = 0xffffff;
			else
				l1 = 0;
			int i2 = aSurface181.textWidth(as[k1], l);
			if(mouseX >= j - i2 / 2 && mouseX <= j + i2 / 2 && mouseY - 2 <= j1 && mouseY - 2 > j1 - aSurface181.method238(l)) {
				if(aBooleanArray182[i])
					l1 = 0x808080;
				else
					l1 = 0xffffff;
				if(anInt185 == 1) {
					anIntArray186[i] = k1;
					aBooleanArray187[i] = true;
				}
			}
			if(anIntArray186[i] == k1)
				if(aBooleanArray182[i])
					l1 = 0xff0000;
				else
					l1 = 0xc00000;
			aSurface181.drawString(as[k1], j - i2 / 2, j1, l, l1);
			j1 += aSurface181.method238(l);
		}

	}

	protected void method146(int i, int j, int k, int l, int i1, int j1) {
		int k1 = (i + k) - 12;
		aSurface181.method214(k1, j, 12, l, 0);
		aSurface181.drawSprite(k1 + 1, j + 1, anInt191);
		aSurface181.drawSprite(k1 + 1, (j + l) - 12, 1 + anInt191);
		aSurface181.drawHorizontalLine(k1, j + 13, 12, 0);
		aSurface181.drawHorizontalLine(k1, (j + l) - 13, 12, 0);
		aSurface181.method226(k1 + 1, j + 14, 11, l - 27, anInt210, anInt211);
		aSurface181.method207(k1 + 3, i1 + j + 14, 7, j1, anInt212);
		aSurface181.method217(k1 + 2, i1 + j + 14, j1, anInt213);
		aSurface181.method217(k1 + 2 + 8, i1 + j + 14, j1, anInt214);
	}

	protected void method147(int i, int j, int k, int l, int i1, int j1, String[] as,
                             int k1, int l1) {
		int i2 = i1 / aSurface181.method238(j1);
		if(l1 > k1 - i2)
			l1 = k1 - i2;
		if(l1 < 0)
			l1 = 0;
		controlFlashText[i] = l1;
		if(i2 < k1) {
			int j2 = (j + l) - 12;
			int l2 = ((i1 - 27) * i2) / k1;
			if(l2 < 6)
				l2 = 6;
			int j3 = ((i1 - 27 - l2) * l1) / (k1 - i2);
			if(anInt201 == 1 && mouseX >= j2 && mouseX <= j2 + 12) {
				if(mouseY > k && mouseY < k + 12 && l1 > 0)
					l1--;
				if(mouseY > (k + i1) - 12 && mouseY < k + i1 && l1 < k1 - i2)
					l1++;
				controlFlashText[i] = l1;
			}
			if(anInt201 == 1 && (mouseX >= j2 && mouseX <= j2 + 12 || mouseX >= j2 - 12 && mouseX <= j2 + 24 && aBooleanArray215[i])) {
				if(mouseY > k + 12 && mouseY < (k + i1) - 12) {
					aBooleanArray215[i] = true;
					int l3 = mouseY - k - 12 - l2 / 2;
					l1 = (l3 * k1) / (i1 - 24);
					if(l1 > k1 - i2)
						l1 = k1 - i2;
					if(l1 < 0)
						l1 = 0;
					controlFlashText[i] = l1;
				}
			} else {
				aBooleanArray215[i] = false;
			}
			j3 = ((i1 - 27 - l2) * l1) / (k1 - i2);
			method146(j, k, l, i1, j3, l2);
		}
		int k2 = i1 - i2 * aSurface181.method238(j1);
		int i3 = k + (aSurface181.method238(j1) * 5) / 6 + k2 / 2;
		for(int k3 = l1; k3 < k1; k3++) {
			method160(i, j + 2, i3, as[k3], j1);
			i3 += aSurface181.method238(j1) - anInt216;
			if(i3 >= k + i1)
				return;
		}

	}

	protected void method148(int i, int j, int k, int l, int i1, int j1, String[] as,
                             int k1, int l1) {
		int i2 = i1 / aSurface181.method238(j1);
		if(i2 < k1) {
			int j2 = (j + l) - 12;
			int l2 = ((i1 - 27) * i2) / k1;
			if(l2 < 6)
				l2 = 6;
			int j3 = ((i1 - 27 - l2) * l1) / (k1 - i2);
			if(anInt201 == 1 && mouseX >= j2 && mouseX <= j2 + 12) {
				if(mouseY > k && mouseY < k + 12 && l1 > 0)
					l1--;
				if(mouseY > (k + i1) - 12 && mouseY < k + i1 && l1 < k1 - i2)
					l1++;
				controlFlashText[i] = l1;
			}
			if(anInt201 == 1 && (mouseX >= j2 && mouseX <= j2 + 12 || mouseX >= j2 - 12 && mouseX <= j2 + 24 && aBooleanArray215[i])) {
				if(mouseY > k + 12 && mouseY < (k + i1) - 12) {
					aBooleanArray215[i] = true;
					int l3 = mouseY - k - 12 - l2 / 2;
					l1 = (l3 * k1) / (i1 - 24);
					if(l1 < 0)
						l1 = 0;
					if(l1 > k1 - i2)
						l1 = k1 - i2;
					controlFlashText[i] = l1;
				}
			} else {
				aBooleanArray215[i] = false;
			}
			j3 = ((i1 - 27 - l2) * l1) / (k1 - i2);
			method146(j, k, l, i1, j3, l2);
		} else {
			l1 = 0;
			controlFlashText[i] = 0;
		}
		controlListEntryMouseOver[i] = -1;
		int k2 = i1 - i2 * aSurface181.method238(j1);
		int i3 = k + (aSurface181.method238(j1) * 5) / 6 + k2 / 2;

		for(int k3 = l1; k3 < k1; k3++) {
			int i4;
			if(aBooleanArray182[i])
				i4 = 0xffffff;
			else
				i4 = 0;

			if(mouseX >= j + 2 && mouseX <= j + 2 + aSurface181.textWidth(as[k3], j1) && mouseY - 2 <= i3 && mouseY - 2 > i3 - aSurface181.method238(j1)) {
				if(aBooleanArray182[i])
					i4 = 0x808080;
				else
					i4 = 0xffffff;
				controlListEntryMouseOver[i] = k3;
				if(anInt185 == 1) {
					anIntArray186[i] = k3;
					aBooleanArray187[i] = true;
				}
			}
			if(anIntArray186[i] == k3 && aBoolean218)
				i4 = 0xff0000;
			aSurface181.drawString(as[k3], j + 2, i3, j1, i4);
			i3 += aSurface181.method238(j1);
			if(i3 >= k + i1)
				return;
		}

	}

	public int method149(int i, int j, int k) {
		return Surface.method222((anInt219 * i) / 114, (anInt220 * j) / 114, (anInt221 * k) / 176);
	}

	public void method150() {
		for(int i = 0; i < anInt208; i++)
			if(aBooleanArray202[i])
				if(anIntArray203[i] == 0)
					method151(i, anIntArray204[i], anIntArray205[i], aStringArray222[i], anIntArray223[i]);
				else
				if(anIntArray203[i] == 1)
					method151(i, anIntArray204[i] - aSurface181.textWidth(aStringArray222[i], anIntArray223[i]) / 2, anIntArray205[i], aStringArray222[i], anIntArray223[i]);
				else
				if(anIntArray203[i] == 2)
					method138(anIntArray204[i], anIntArray205[i], anIntArray206[i], anIntArray207[i]);
				else
				if(anIntArray203[i] == 3)
					method143(anIntArray204[i], anIntArray205[i], anIntArray206[i]);
				else
				if(anIntArray203[i] == 4)
					method147(i, anIntArray204[i], anIntArray205[i], anIntArray206[i], anIntArray207[i], anIntArray223[i], aStringArrayArray194[i], anIntArray195[i], controlFlashText[i]);
				else
				if(anIntArray203[i] == 5 || anIntArray203[i] == 6)
					method171(i, anIntArray204[i], anIntArray205[i], anIntArray206[i], anIntArray207[i], aStringArray222[i], anIntArray223[i]);
				else
				if(anIntArray203[i] == 7)
					method137(i, anIntArray204[i], anIntArray205[i], anIntArray223[i], aStringArrayArray194[i]);
				else
				if(anIntArray203[i] == 8)
					method145(i, anIntArray204[i], anIntArray205[i], anIntArray223[i], aStringArrayArray194[i]);
				else
				if(anIntArray203[i] == 9)
					method148(i, anIntArray204[i], anIntArray205[i], anIntArray206[i], anIntArray207[i], anIntArray223[i], aStringArrayArray194[i], anIntArray195[i], controlFlashText[i]);
				else
				if(anIntArray203[i] == 11)
					method140(anIntArray204[i], anIntArray205[i], anIntArray206[i], anIntArray207[i]);
				else
				if(anIntArray203[i] == 12)
					method165(anIntArray204[i], anIntArray205[i], anIntArray223[i]);
				else
				if(anIntArray203[i] == 14)
					method144(i, anIntArray204[i], anIntArray205[i], anIntArray206[i], anIntArray207[i]);

		anInt185 = 0;
	}

	protected void method151(int i, int j, int k, String s, int l) {
		int i1 = k + aSurface181.method238(l) / 3;
		method160(i, j, i1, s, l);
	}

	public int method152(int i, int j, int k, int l, int i1, int j1, boolean flag) {
		anIntArray203[anInt208] = 9;
		aBooleanArray202[anInt208] = true;
		aBooleanArray187[anInt208] = false;
		anIntArray223[anInt208] = i1;
		aBooleanArray182[anInt208] = flag;
		anIntArray204[anInt208] = i;
		anIntArray205[anInt208] = j;
		anIntArray206[anInt208] = k;
		anIntArray207[anInt208] = l;
		anIntArray199[anInt208] = j1;
		aStringArrayArray194[anInt208] = new String[j1];
		anIntArray195[anInt208] = 0;
		controlFlashText[anInt208] = 0;
		anIntArray186[anInt208] = -1;
		controlListEntryMouseOver[anInt208] = -1;
		return anInt208++;
	}

	public int method153(int i, int j, String s, int k, boolean flag) {
		anIntArray203[anInt208] = 1;
		aBooleanArray202[anInt208] = true;
		aBooleanArray187[anInt208] = false;
		anIntArray223[anInt208] = k;
		aBooleanArray182[anInt208] = flag;
		anIntArray204[anInt208] = i;
		anIntArray205[anInt208] = j;
		aStringArray222[anInt208] = s;
		return anInt208++;
	}

	public void method154(int i) {
		anIntArray195[i] = 0;
	}

	public void method155(int i) {
		aBooleanArray202[i] = true;
	}

	public int method156(int i, int j, int k) {
		int l = aSurface181.anIntArray325[k];
		int i1 = aSurface181.anIntArray326[k];
		anIntArray203[anInt208] = 12;
		aBooleanArray202[anInt208] = true;
		aBooleanArray187[anInt208] = false;
		anIntArray204[anInt208] = i - l / 2;
		anIntArray205[anInt208] = j - i1 / 2;
		anIntArray206[anInt208] = l;
		anIntArray207[anInt208] = i1;
		anIntArray223[anInt208] = k;
		return anInt208++;
	}

	public int method157(int i, int j, int k, int l, int i1, int j1, boolean flag, 
			boolean flag1) {
		anIntArray203[anInt208] = 6;
		aBooleanArray202[anInt208] = true;
		aBooleanArray224[anInt208] = flag;
		aBooleanArray187[anInt208] = false;
		anIntArray223[anInt208] = i1;
		aBooleanArray182[anInt208] = flag1;
		anIntArray204[anInt208] = i;
		anIntArray205[anInt208] = j;
		anIntArray206[anInt208] = k;
		anIntArray207[anInt208] = l;
		anIntArray199[anInt208] = j1;
		aStringArray222[anInt208] = "";
		return anInt208++;
	}

	public int method158(int i, int j, int k, int l) {
		anIntArray203[anInt208] = 2;
		aBooleanArray202[anInt208] = true;
		aBooleanArray187[anInt208] = false;
		anIntArray204[anInt208] = i - k / 2;
		anIntArray205[anInt208] = j - l / 2;
		anIntArray206[anInt208] = k;
		anIntArray207[anInt208] = l;
		return anInt208++;
	}

	public boolean isClicked(int i) {
		if(aBooleanArray202[i] && aBooleanArray187[i]) {
			aBooleanArray187[i] = false;
			return true;
		} else {
			return false;
		}
	}

	protected void method160(int i, int j, int k, String s, int l) {
		int i1;
		if(aBooleanArray182[i])
			i1 = 0xffffff;
		else
			i1 = 0;
		aSurface181.drawString(s, j, k, l, i1);
	}

	public void method161(int i) {
		aBooleanArray202[i] = false;
	}

	public void method162(int i) {
		controlFlashText[i] = 0;
		controlListEntryMouseOver[i] = -1;
	}

	public int addTextListInput(int i, int j, int k, int l, int i1, int j1, boolean flag,
								boolean flag1) {
		anIntArray203[anInt208] = 5;
		aBooleanArray202[anInt208] = true;
		aBooleanArray224[anInt208] = flag;
		aBooleanArray187[anInt208] = false;
		anIntArray223[anInt208] = i1;
		aBooleanArray182[anInt208] = flag1;
		anIntArray204[anInt208] = i;
		anIntArray205[anInt208] = j;
		anIntArray206[anInt208] = k;
		anIntArray207[anInt208] = l;
		anIntArray199[anInt208] = j1;
		aStringArray222[anInt208] = "";
		return anInt208++;
	}

	public int getListEntryIndex(int i) {
		int j = controlListEntryMouseOver[i];
		return j;
	}

	protected void method165(int i, int j, int k) {
		aSurface181.drawSprite(i, j, k);
	}

	public String getText(int i) {
		if(aStringArray222[i] == null)
			return "null";
		else
			return aStringArray222[i];
	}

	public int method167(int i, int j, int k, int l) {
		anIntArray203[anInt208] = 11;
		aBooleanArray202[anInt208] = true;
		aBooleanArray187[anInt208] = false;
		anIntArray204[anInt208] = i - k / 2;
		anIntArray205[anInt208] = j - l / 2;
		anIntArray206[anInt208] = k;
		anIntArray207[anInt208] = l;
		return anInt208++;
	}

	public Panel(Surface surface, int i) {
		anInt225 = -1;
		aBoolean218 = true;
		aSurface181 = surface;
		anInt180 = i;
		aBooleanArray202 = new boolean[i];
		aBooleanArray215 = new boolean[i];
		aBooleanArray224 = new boolean[i];
		aBooleanArray187 = new boolean[i];
		aBooleanArray182 = new boolean[i];
		controlFlashText = new int[i];
		anIntArray195 = new int[i];
		anIntArray186 = new int[i];
		controlListEntryMouseOver = new int[i];
		anIntArray204 = new int[i];
		anIntArray205 = new int[i];
		anIntArray203 = new int[i];
		anIntArray206 = new int[i];
		anIntArray207 = new int[i];
		anIntArray199 = new int[i];
		anIntArray223 = new int[i];
		aStringArray222 = new String[i];
		aStringArrayArray194 = new String[i][];
		anInt210 = method149(114, 114, 176);
		anInt211 = method149(14, 14, 62);
		anInt213 = method149(200, 208, 232);
		anInt212 = method149(96, 129, 184);
		anInt214 = method149(53, 95, 115);
		anInt196 = method149(117, 142, 171);
		anInt197 = method149(98, 122, 158);
		anInt198 = method149(86, 100, 136);
		anInt189 = method149(135, 146, 179);
		anInt192 = method149(97, 112, 151);
		anInt193 = method149(88, 102, 136);
		anInt188 = method149(84, 93, 120);
	}

	public void updateText(int i, String s) {
		aStringArray222[i] = s;
	}

	public void method169(int i) {
		if(i == 0)
			return;
		if(anInt225 != -1 && aStringArray222[anInt225] != null && aBooleanArray202[anInt225]) {
			int j = aStringArray222[anInt225].length();
			if(i == 8 && j > 0)
				aStringArray222[anInt225] = aStringArray222[anInt225].substring(0, j - 1);
			if((i == 10 || i == 13) && j > 0)
				aBooleanArray187[anInt225] = true;
			String s = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"\243$%^&*()-_=+[{]};:'@#~,<.>/?\\| ";
			if(j < anIntArray199[anInt225]) {
				for(int k = 0; k < s.length(); k++)
					if(i == s.charAt(k))
						aStringArray222[anInt225] += (char)i;

			}
			if(i == 9) {
				do
					anInt225 = (anInt225 + 1) % anInt208;
				while(anIntArray203[anInt225] != 5 && anIntArray203[anInt225] != 6);
            }
		}
	}

	public void setFocus(int i) {
		anInt225 = i;
	}

	protected void method171(int i, int j, int k, int l, int i1, String s, int j1) {
		if(aBooleanArray224[i]) {
			int k1 = s.length();
			s = "";
			for(int i2 = 0; i2 < k1; i2++)
				s = s + "X";

		}
		if(anIntArray203[i] == 5) {
			if(anInt185 == 1 && mouseX >= j && mouseY >= k - i1 / 2 && mouseX <= j + l && mouseY <= k + i1 / 2)
				anInt225 = i;
		} else
		if(anIntArray203[i] == 6) {
			if(anInt185 == 1 && mouseX >= j - l / 2 && mouseY >= k - i1 / 2 && mouseX <= j + l / 2 && mouseY <= k + i1 / 2)
				anInt225 = i;
			j -= aSurface181.textWidth(s, j1) / 2;
		}
		if(anInt225 == i)
			s = s + "*";
		int l1 = k + aSurface181.method238(j1) / 3;
		method160(i, j, l1, s, j1);
	}

	public int addTextList(int i, int j, int k, int l, int i1, int j1, boolean flag) {
		anIntArray203[anInt208] = 4;
		aBooleanArray202[anInt208] = true;
		aBooleanArray187[anInt208] = false;
		anIntArray204[anInt208] = i;
		anIntArray205[anInt208] = j;
		anIntArray206[anInt208] = k;
		anIntArray207[anInt208] = l;
		aBooleanArray182[anInt208] = flag;
		anIntArray223[anInt208] = i1;
		anIntArray199[anInt208] = j1;
		anIntArray195[anInt208] = 0;
		controlFlashText[anInt208] = 0;
		aStringArrayArray194[anInt208] = new String[j1];
		return anInt208++;
	}

	public int method173(int i, int j, int k, int l) {
		anIntArray203[anInt208] = 10;
		aBooleanArray202[anInt208] = true;
		aBooleanArray187[anInt208] = false;
		anIntArray204[anInt208] = i - k / 2;
		anIntArray205[anInt208] = j - l / 2;
		anIntArray206[anInt208] = k;
		anIntArray207[anInt208] = l;
		return anInt208++;
	}

	int anInt180;
	public Surface aSurface181;
	boolean[] aBooleanArray182;
	int mouseX;
	int mouseY;
	int anInt185;
	public int[] anIntArray186;
	public boolean[] aBooleanArray187;
	int anInt188;
	int anInt189;
	public static boolean aBoolean190 = true;
	public static int anInt191;
	int anInt192;
	int anInt193;
	String[][] aStringArrayArray194;
	public int[] anIntArray195;
	int anInt196;
	int anInt197;
	int anInt198;
	int[] anIntArray199;
	public int[] controlFlashText;
	int anInt201;
	public boolean[] aBooleanArray202;
	int[] anIntArray203;
	int[] anIntArray204;
	int[] anIntArray205;
	int[] anIntArray206;
	int[] anIntArray207;
	int anInt208;
	int anInt209;
	int anInt210;
	int anInt211;
	int anInt212;
	int anInt213;
	int anInt214;
	public boolean[] aBooleanArray215;
	public static int anInt216;
	public int[] controlListEntryMouseOver;
	public boolean aBoolean218;
	public static int anInt219 = 114;
	public static int anInt220 = 114;
	public static int anInt221 = 176;
	String[] aStringArray222;
	int[] anIntArray223;
	public boolean[] aBooleanArray224;
	int anInt225;

}
