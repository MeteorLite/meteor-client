// Decompiled by Jad v1.5.8c. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

import java.io.*;

public class Model {

	public int method174(byte[] abyte0) {
		for(; abyte0[anInt232] == 10 || abyte0[anInt232] == 13; anInt232++);
		int i = anIntArray233[abyte0[anInt232++] & 0xff];
		int j = anIntArray233[abyte0[anInt232++] & 0xff];
		int k = anIntArray233[abyte0[anInt232++] & 0xff];
		int l = (i * 4096 + j * 64 + k) - 0x20000;
		if(l == 0x1e240)
			l = anInt234;
		return l;
	}

	public void method175(Model[] amodel, int i, boolean flag) {
		int j = 0;
		int k = 0;
		for(int l = 0; l < i; l++) {
			j += amodel[l].anInt235;
			k += amodel[l].anInt236;
		}

		method186(k, j);
		if(flag)
			anIntArrayArray237 = new int[j][];
		for(int i1 = 0; i1 < i; i1++) {
			Model model = amodel[i1];
			model.method182();
			anInt238 = model.anInt238;
			anInt239 = model.anInt239;
			anInt240 = model.anInt240;
			anInt241 = model.anInt241;
			anInt242 = model.anInt242;
			anInt243 = model.anInt243;
			for(int j1 = 0; j1 < model.anInt235; j1++) {
				int[] ai = new int[model.anIntArray244[j1]];
				int[] ai1 = model.anIntArrayArray245[j1];
				for(int k1 = 0; k1 < model.anIntArray244[j1]; k1++)
					ai[k1] = method198(model.anIntArray246[ai1[k1]], model.anIntArray247[ai1[k1]], model.anIntArray248[ai1[k1]]);

				int l1 = createFace(model.anIntArray244[j1], ai, model.anIntArray249[j1], model.anIntArray250[j1]);
				anIntArray251[l1] = model.anIntArray251[j1];
				anIntArray252[l1] = model.anIntArray252[j1];
				anIntArray253[l1] = model.anIntArray253[j1];
				if(flag)
					if(i > 1) {
						anIntArrayArray237[l1] = new int[model.anIntArrayArray237[j1].length + 1];
						anIntArrayArray237[l1][0] = i1;
                        System.arraycopy(model.anIntArrayArray237[j1], 0, anIntArrayArray237[l1], 1, model.anIntArrayArray237[j1].length);

					} else {
						anIntArrayArray237[l1] = new int[model.anIntArrayArray237[j1].length];
                        System.arraycopy(model.anIntArrayArray237[j1], 0, anIntArrayArray237[l1], 0, model.anIntArrayArray237[j1].length);

					}
			}

		}

		anInt254 = 1;
	}

	private void method176(int i, int j, int k) {
		for(int i3 = 0; i3 < anInt236; i3++) {
			if(k != 0) {
				int l = anIntArray255[k];
				int k1 = anIntArray255[k + 256];
				int j2 = anIntArray256[i3] * l + anIntArray257[i3] * k1 >> 15;
				anIntArray256[i3] = anIntArray256[i3] * k1 - anIntArray257[i3] * l >> 15;
				anIntArray257[i3] = j2;
			}
			if(i != 0) {
				int i1 = anIntArray255[i];
				int l1 = anIntArray255[i + 256];
				int k2 = anIntArray256[i3] * l1 - anIntArray258[i3] * i1 >> 15;
				anIntArray258[i3] = anIntArray256[i3] * i1 + anIntArray258[i3] * l1 >> 15;
				anIntArray256[i3] = k2;
			}
			if(j != 0) {
				int j1 = anIntArray255[j];
				int i2 = anIntArray255[j + 256];
				int l2 = anIntArray258[i3] * j1 + anIntArray257[i3] * i2 >> 15;
				anIntArray258[i3] = anIntArray258[i3] * i2 - anIntArray257[i3] * j1 >> 15;
				anIntArray257[i3] = l2;
			}
		}

	}

	public void method177(int i, int j, int k) {
		anInt259 = i;
		anInt260 = j;
		anInt261 = k;
		method187();
		anInt254 = 1;
	}

	public void method178() {
		anInt235 = 0;
		anInt236 = 0;
	}

	public void method179(Model model, int[] ai, int i, int j) {
		int[] ai1 = new int[i];
		for(int k = 0; k < i; k++) {
			int l = ai1[k] = model.method198(anIntArray246[ai[k]], anIntArray247[ai[k]], anIntArray248[ai[k]]);
			model.anIntArray262[l] = anIntArray262[ai[k]];
			model.aByteArray263[l] = aByteArray263[ai[k]];
		}

		int i1 = model.createFace(i, ai1, anIntArray249[j], anIntArray250[j]);
		if(!model.aBoolean264 && !aBoolean264)
			model.faceTag[i1] = faceTag[j];
		model.anIntArray251[i1] = anIntArray251[j];
		model.anIntArray252[i1] = anIntArray252[j];
		model.anIntArray253[i1] = anIntArray253[j];
	}

	public void method180(int i, int j) {
		anInt235 -= i;
		if(anInt235 < 0)
			anInt235 = 0;
		anInt236 -= j;
		if(anInt236 < 0)
			anInt236 = 0;
	}

	public Model method181() {
		Model[] amodel = new Model[1];
		amodel[0] = this;
		Model model = new Model(amodel, 1);
		model.anInt266 = anInt266;
		model.aBoolean267 = aBoolean267;
		return model;
	}

	public void method182() {
		method200();
		for(int i = 0; i < anInt236; i++) {
			anIntArray246[i] = anIntArray257[i];
			anIntArray247[i] = anIntArray256[i];
			anIntArray248[i] = anIntArray258[i];
		}

		anInt259 = anInt260 = anInt261 = 0;
		anInt270 = anInt269 = anInt268 = 0;
		anInt273 = anInt272 = anInt271 = 256;
		anInt279 = anInt278 = anInt277 = anInt276 = anInt275 = anInt274 = 256;
		anInt280 = 0;
	}

	public void method183(int i, int j, int k, int l, int i1, int j1, int k1, 
			int l1) {
		method200();
		//This causes a bug when rendering distance is extended and camera angles are specific
		if (!mudclient.injected) {
			if(anInt281 > Scene.anInt400 || anInt282 < Scene.anInt399 || anInt283 > Scene.anInt396 || anInt284 < Scene.anInt395 || anInt285 > Scene.anInt398 || anInt286 < Scene.anInt397) {
				aBoolean287 = false;
				return;
			}
		}
		aBoolean287 = true;
		int l2 = 0;
		int i3 = 0;
		int j3 = 0;
		int k3 = 0;
		int l3 = 0;
		int i4 = 0;
		if(j1 != 0) {
			l2 = anIntArray288[j1];
			i3 = anIntArray288[j1 + 1024];
		}
		if(i1 != 0) {
			l3 = anIntArray288[i1];
			i4 = anIntArray288[i1 + 1024];
		}
		if(l != 0) {
			j3 = anIntArray288[l];
			k3 = anIntArray288[l + 1024];
		}
		for(int j4 = 0; j4 < anInt236; j4++) {
			int k4 = anIntArray257[j4] - i;
			int l4 = anIntArray256[j4] - j;
			int i5 = anIntArray258[j4] - k;
			if(j1 != 0) {
				int i2 = l4 * l2 + k4 * i3 >> 15;
				l4 = l4 * i3 - k4 * l2 >> 15;
				k4 = i2;
			}
			if(i1 != 0) {
				int j2 = i5 * l3 + k4 * i4 >> 15;
				i5 = i5 * i4 - k4 * l3 >> 15;
				k4 = j2;
			}
			if(l != 0) {
				int k2 = l4 * k3 - i5 * j3 >> 15;
				i5 = l4 * j3 + i5 * k3 >> 15;
				l4 = k2;
			}
			if(i5 >= l1)
				anIntArray289[j4] = (k4 << k1) / i5;
			else
				anIntArray289[j4] = k4 << k1;
			if(i5 >= l1)
				anIntArray290[j4] = (l4 << k1) / i5;
			else
				anIntArray290[j4] = l4 << k1;
			anIntArray291[j4] = k4;
			anIntArray292[j4] = l4;
			anIntArray293[j4] = i5;
		}

	}

	public int createFace(int i, int[] ai, int j, int k) {
		if(anInt235 >= anInt294) {
			return -1;
		} else {
			anIntArray244[anInt235] = i;
			anIntArrayArray245[anInt235] = ai;
			anIntArray249[anInt235] = j;
			anIntArray250[anInt235] = k;
			anInt254 = 1;
			return anInt235++;
		}
	}

	public void method185() {
		anIntArray291 = new int[anInt236];
		anIntArray292 = new int[anInt236];
		anIntArray293 = new int[anInt236];
		anIntArray289 = new int[anInt236];
		anIntArray290 = new int[anInt236];
	}

	private void method186(int i, int j) {
		anIntArray246 = new int[i];
		anIntArray247 = new int[i];
		anIntArray248 = new int[i];
		anIntArray262 = new int[i];
		aByteArray263 = new byte[i];
		anIntArray244 = new int[j];
		anIntArrayArray245 = new int[j][];
		anIntArray249 = new int[j];
		anIntArray250 = new int[j];
		anIntArray251 = new int[j];
		anIntArray252 = new int[j];
		anIntArray253 = new int[j];
		if(!aBoolean295) {
			anIntArray291 = new int[i];
			anIntArray292 = new int[i];
			anIntArray293 = new int[i];
			anIntArray289 = new int[i];
			anIntArray290 = new int[i];
		}
		if(!aBoolean264) {
			isLocalPlayer = new byte[j];
			faceTag = new int[j];
		}
		if(aBoolean297) {
			anIntArray257 = anIntArray246;
			anIntArray256 = anIntArray247;
			anIntArray258 = anIntArray248;
		} else {
			anIntArray257 = new int[i];
			anIntArray256 = new int[i];
			anIntArray258 = new int[i];
		}
		if(!aBoolean298 || !aBoolean299) {
			anIntArray300 = new int[j];
			anIntArray301 = new int[j];
			anIntArray302 = new int[j];
		}
		if(!aBoolean299) {
			anIntArray303 = new int[j];
			anIntArray304 = new int[j];
			anIntArray305 = new int[j];
			anIntArray306 = new int[j];
			anIntArray307 = new int[j];
			anIntArray308 = new int[j];
		}
		anInt235 = 0;
		anInt236 = 0;
		anInt309 = i;
		anInt294 = j;
		anInt259 = anInt260 = anInt261 = 0;
		anInt270 = anInt269 = anInt268 = 0;
		anInt273 = anInt272 = anInt271 = 256;
		anInt279 = anInt278 = anInt277 = anInt276 = anInt275 = anInt274 = 256;
		anInt280 = 0;
	}

	private void method187() {
		if(anInt279 != 256 || anInt278 != 256 || anInt277 != 256 || anInt276 != 256 || anInt275 != 256 || anInt274 != 256) {
			anInt280 = 4;
			return;
		}
		if(anInt273 != 256 || anInt272 != 256 || anInt271 != 256) {
			anInt280 = 3;
			return;
		}
		if(anInt270 != 0 || anInt269 != 0 || anInt268 != 0) {
			anInt280 = 2;
			return;
		}
		if(anInt259 != 0 || anInt260 != 0 || anInt261 != 0) {
			anInt280 = 1;
        } else {
			anInt280 = 0;
        }
	}

	public void method188() {
		if(aBoolean298 && aBoolean299)
			return;
		for(int i = 0; i < anInt235; i++) {
			int[] ai = anIntArrayArray245[i];
			int j = anIntArray257[ai[0]];
			int k = anIntArray256[ai[0]];
			int l = anIntArray258[ai[0]];
			int i1 = anIntArray257[ai[1]] - j;
			int j1 = anIntArray256[ai[1]] - k;
			int k1 = anIntArray258[ai[1]] - l;
			int l1 = anIntArray257[ai[2]] - j;
			int i2 = anIntArray256[ai[2]] - k;
			int j2 = anIntArray258[ai[2]] - l;
			int k2 = j1 * j2 - i2 * k1;
			int l2 = k1 * l1 - j2 * i1;
			int i3;
			for(i3 = i1 * i2 - l1 * j1; k2 > 8192 || l2 > 8192 || i3 > 8192 || k2 < -8192 || l2 < -8192 || i3 < -8192; i3 >>= 1) {
				k2 >>= 1;
				l2 >>= 1;
			}

			int j3 = (int)(256D * Math.sqrt(k2 * k2 + l2 * l2 + i3 * i3));
			if(j3 <= 0)
				j3 = 1;
			anIntArray300[i] = (k2 * 0x10000) / j3;
			anIntArray301[i] = (l2 * 0x10000) / j3;
			anIntArray302[i] = (i3 * 65535) / j3;
			anIntArray252[i] = -1;
		}

		method189();
	}

	public void method189() {
		if(aBoolean298)
			return;
		int i = anInt239 * anInt243 >> 8;
		for(int j = 0; j < anInt235; j++)
			if(anIntArray251[j] != anInt234)
				anIntArray251[j] = (anIntArray300[j] * anInt240 + anIntArray301[j] * anInt241 + anIntArray302[j] * anInt242) / i;

		int[] ai = new int[anInt236];
		int[] ai1 = new int[anInt236];
		int[] ai2 = new int[anInt236];
		int[] ai3 = new int[anInt236];
		for(int k = 0; k < anInt236; k++) {
			ai[k] = 0;
			ai1[k] = 0;
			ai2[k] = 0;
			ai3[k] = 0;
		}

		for(int l = 0; l < anInt235; l++)
			if(anIntArray251[l] == anInt234) {
				for(int i1 = 0; i1 < anIntArray244[l]; i1++) {
					int k1 = anIntArrayArray245[l][i1];
					ai[k1] += anIntArray300[l];
					ai1[k1] += anIntArray301[l];
					ai2[k1] += anIntArray302[l];
					ai3[k1]++;
				}

			}

		for(int j1 = 0; j1 < anInt236; j1++)
			if(ai3[j1] > 0)
				anIntArray262[j1] = (ai[j1] * anInt240 + ai1[j1] * anInt241 + ai2[j1] * anInt242) / (i * ai3[j1]);

	}

	private void method190(int i, int j, int k) {
		for(int l = 0; l < anInt236; l++) {
			anIntArray257[l] = anIntArray257[l] * i >> 8;
			anIntArray256[l] = anIntArray256[l] * j >> 8;
			anIntArray258[l] = anIntArray258[l] * k >> 8;
		}

	}

	private void method191(int i, int j, int k, int l, int i1, int j1) {
		for(int k1 = 0; k1 < anInt236; k1++) {
			if(i != 0)
				anIntArray257[k1] += anIntArray256[k1] * i >> 8;
			if(j != 0)
				anIntArray258[k1] += anIntArray256[k1] * j >> 8;
			if(k != 0)
				anIntArray257[k1] += anIntArray258[k1] * k >> 8;
			if(l != 0)
				anIntArray256[k1] += anIntArray258[k1] * l >> 8;
			if(i1 != 0)
				anIntArray258[k1] += anIntArray257[k1] * i1 >> 8;
			if(j1 != 0)
				anIntArray256[k1] += anIntArray257[k1] * j1 >> 8;
		}

	}

	public Model method192(boolean flag, boolean flag1, boolean flag2, boolean flag3) {
		Model[] amodel = new Model[1];
		amodel[0] = this;
		Model model = new Model(amodel, 1, flag, flag1, flag2, flag3);
		model.anInt266 = anInt266;
		return model;
	}

	private void method193(int i, int j, int k) {
		for(int l = 0; l < anInt236; l++) {
			anIntArray257[l] += i;
			anIntArray256[l] += j;
			anIntArray258[l] += k;
		}

	}

	public int createVertex(int i, int j, int k) {
		if(anInt236 >= anInt309) {
			return -1;
		} else {
			anIntArray246[anInt236] = i;
			anIntArray247[anInt236] = j;
			anIntArray248[anInt236] = k;
			return anInt236++;
		}
	}

	public void method195(Model model) {
		anInt270 = model.anInt270;
		anInt269 = model.anInt269;
		anInt268 = model.anInt268;
		anInt259 = model.anInt259;
		anInt260 = model.anInt260;
		anInt261 = model.anInt261;
		method187();
		anInt254 = 1;
	}

	public void method196(int i, int j) {
		aByteArray263[i] = (byte)j;
	}

	public void method197(int i, int j, int k) {
		anInt259 += i;
		anInt260 += j;
		anInt261 += k;
		method187();
		anInt254 = 1;
	}

	public int method198(int i, int j, int k) {
		for(int l = 0; l < anInt236; l++)
			if(anIntArray246[l] == i && anIntArray247[l] == j && anIntArray248[l] == k)
				return l;

		if(anInt236 >= anInt309) {
			return -1;
		} else {
			anIntArray246[anInt236] = i;
			anIntArray247[anInt236] = j;
			anIntArray248[anInt236] = k;
			return anInt236++;
		}
	}

	public void method199(int i, int j, int k, int l, int i1) {
		anInt238 = 256 - i * 4;
		anInt239 = (64 - j) * 16 + 128;
		if(aBoolean298) {
        } else {
			anInt240 = k;
			anInt241 = l;
			anInt242 = i1;
			anInt243 = (int)Math.sqrt(k * k + l * l + i1 * i1);
			method189();
        }
	}

	public void method200() {
		if(anInt254 == 2) {
			anInt254 = 0;
			for(int i = 0; i < anInt236; i++) {
				anIntArray257[i] = anIntArray246[i];
				anIntArray256[i] = anIntArray247[i];
				anIntArray258[i] = anIntArray248[i];
			}

			anInt283 = anInt285 = anInt281 = 0xff676981;
			anInt310 = anInt284 = anInt286 = anInt282 = 0x98967f;
			return;
		}
		if(anInt254 == 1) {
			anInt254 = 0;
			for(int j = 0; j < anInt236; j++) {
				anIntArray257[j] = anIntArray246[j];
				anIntArray256[j] = anIntArray247[j];
				anIntArray258[j] = anIntArray248[j];
			}

			if(anInt280 >= 2)
				method176(anInt270, anInt269, anInt268);
			if(anInt280 >= 3)
				method190(anInt273, anInt272, anInt271);
			if(anInt280 >= 4)
				method191(anInt279, anInt278, anInt277, anInt276, anInt275, anInt274);
			if(anInt280 >= 1)
				method193(anInt259, anInt260, anInt261);
			method206();
			method188();
		}
	}

	public Model[] method201(int i, int j, int k, int l, int i1, int j1, int k1, 
			boolean flag) {
		method182();
		int[] ai = new int[j1];
		int[] ai1 = new int[j1];
		for(int l1 = 0; l1 < j1; l1++) {
			ai[l1] = 0;
			ai1[l1] = 0;
		}

		for(int i2 = 0; i2 < anInt235; i2++) {
			int j2 = 0;
			int k2 = 0;
			int i3 = anIntArray244[i2];
			int[] ai2 = anIntArrayArray245[i2];
			for(int i4 = 0; i4 < i3; i4++) {
				j2 += anIntArray246[ai2[i4]];
				k2 += anIntArray248[ai2[i4]];
			}

			int k4 = j2 / (i3 * k) + (k2 / (i3 * l)) * i1;
			ai[k4] += i3;
			ai1[k4]++;
		}

		Model[] amodel = new Model[j1];
		for(int l2 = 0; l2 < j1; l2++) {
			if(ai[l2] > k1)
				ai[l2] = k1;
			amodel[l2] = new Model(ai[l2], ai1[l2], true, true, true, flag, true);
			amodel[l2].anInt239 = anInt239;
			amodel[l2].anInt238 = anInt238;
		}

		for(int j3 = 0; j3 < anInt235; j3++) {
			int k3 = 0;
			int j4 = 0;
			int l4 = anIntArray244[j3];
			int[] ai3 = anIntArrayArray245[j3];
			for(int i5 = 0; i5 < l4; i5++) {
				k3 += anIntArray246[ai3[i5]];
				j4 += anIntArray248[ai3[i5]];
			}

			int j5 = k3 / (l4 * k) + (j4 / (l4 * l)) * i1;
			method179(amodel[j5], ai3, l4, j3);
		}

		for(int l3 = 0; l3 < j1; l3++)
			amodel[l3].method185();

		return amodel;
	}

	public void method202(int i, int j, int k) {
		if(aBoolean298) {
        } else {
			anInt240 = i;
			anInt241 = j;
			anInt242 = k;
			anInt243 = (int)Math.sqrt(i * i + j * j + k * k);
			method189();
        }
	}

	public Model(byte[] abyte0, int i, boolean flag) {
		anInt254 = 1;
		aBoolean287 = true;
		aBoolean226 = true;
		aBoolean227 = false;
		aBoolean267 = false;
		anInt228 = -1;
		aBoolean297 = false;
		aBoolean299 = false;
		aBoolean298 = false;
		aBoolean264 = false;
		aBoolean295 = false;
		anInt230 = 4;
		anInt234 = 0xbc614e;
		anInt310 = 0xbc614e;
		anInt240 = 180;
		anInt241 = 155;
		anInt242 = 95;
		anInt243 = 256;
		anInt239 = 512;
		anInt238 = 32;
		int j = DataUtils.method344(abyte0, i);
		i += 2;
		int k = DataUtils.method344(abyte0, i);
		i += 2;
		method186(j, k);
		anIntArrayArray237 = new int[k][1];
		for(int l = 0; l < j; l++) {
			anIntArray246[l] = DataUtils.method345(abyte0, i);
			i += 2;
		}

		for(int i1 = 0; i1 < j; i1++) {
			anIntArray247[i1] = DataUtils.method345(abyte0, i);
			i += 2;
		}

		for(int j1 = 0; j1 < j; j1++) {
			anIntArray248[j1] = DataUtils.method345(abyte0, i);
			i += 2;
		}

		anInt236 = j;
		for(int k1 = 0; k1 < k; k1++)
			anIntArray244[k1] = abyte0[i++] & 0xff;

		for(int l1 = 0; l1 < k; l1++) {
			anIntArray249[l1] = DataUtils.method345(abyte0, i);
			i += 2;
			if(anIntArray249[l1] == 32767)
				anIntArray249[l1] = anInt234;
		}

		for(int i2 = 0; i2 < k; i2++) {
			anIntArray250[i2] = DataUtils.method345(abyte0, i);
			i += 2;
			if(anIntArray250[i2] == 32767)
				anIntArray250[i2] = anInt234;
		}

		for(int j2 = 0; j2 < k; j2++) {
			int k2 = abyte0[i++] & 0xff;
			if(k2 == 0)
				anIntArray251[j2] = 0;
			else
				anIntArray251[j2] = anInt234;
		}

		for(int l2 = 0; l2 < k; l2++) {
			anIntArrayArray245[l2] = new int[anIntArray244[l2]];
			for(int i3 = 0; i3 < anIntArray244[l2]; i3++)
				if(j < 256) {
					anIntArrayArray245[l2][i3] = abyte0[i++] & 0xff;
				} else {
					anIntArrayArray245[l2][i3] = DataUtils.method344(abyte0, i);
					i += 2;
				}

		}

		anInt235 = k;
		anInt254 = 1;
	}

	public Model(Model[] amodel, int i) {
		anInt254 = 1;
		aBoolean287 = true;
		aBoolean226 = true;
		aBoolean227 = false;
		aBoolean267 = false;
		anInt228 = -1;
		aBoolean297 = false;
		aBoolean299 = false;
		aBoolean298 = false;
		aBoolean264 = false;
		aBoolean295 = false;
		anInt230 = 4;
		anInt234 = 0xbc614e;
		anInt310 = 0xbc614e;
		anInt240 = 180;
		anInt241 = 155;
		anInt242 = 95;
		anInt243 = 256;
		anInt239 = 512;
		anInt238 = 32;
		method175(amodel, i, true);
	}

	public Model(Model[] amodel, int i, boolean flag, boolean flag1, boolean flag2, boolean flag3) {
		anInt254 = 1;
		aBoolean287 = true;
		aBoolean226 = true;
		aBoolean227 = false;
		aBoolean267 = false;
		anInt228 = -1;
		aBoolean297 = false;
		aBoolean299 = false;
		aBoolean298 = false;
		aBoolean264 = false;
		aBoolean295 = false;
		anInt230 = 4;
		anInt234 = 0xbc614e;
		anInt310 = 0xbc614e;
		anInt240 = 180;
		anInt241 = 155;
		anInt242 = 95;
		anInt243 = 256;
		anInt239 = 512;
		anInt238 = 32;
		aBoolean297 = flag;
		aBoolean299 = flag1;
		aBoolean298 = flag2;
		aBoolean264 = flag3;
		method175(amodel, i, false);
	}

	public Model(int i, int j) {
		anInt254 = 1;
		aBoolean287 = true;
		aBoolean226 = true;
		aBoolean227 = false;
		aBoolean267 = false;
		anInt228 = -1;
		aBoolean297 = false;
		aBoolean299 = false;
		aBoolean298 = false;
		aBoolean264 = false;
		aBoolean295 = false;
		anInt230 = 4;
		anInt234 = 0xbc614e;
		anInt310 = 0xbc614e;
		anInt240 = 180;
		anInt241 = 155;
		anInt242 = 95;
		anInt243 = 256;
		anInt239 = 512;
		anInt238 = 32;
		method186(i, j);
		anIntArrayArray237 = new int[j][1];
		for(int k = 0; k < j; k++)
			anIntArrayArray237[k][0] = k;

	}

	public Model(int i, int j, boolean flag, boolean flag1, boolean flag2, boolean flag3, boolean flag4) {
		anInt254 = 1;
		aBoolean287 = true;
		aBoolean226 = true;
		aBoolean227 = false;
		aBoolean267 = false;
		anInt228 = -1;
		aBoolean297 = false;
		aBoolean299 = false;
		aBoolean298 = false;
		aBoolean264 = false;
		aBoolean295 = false;
		anInt230 = 4;
		anInt234 = 0xbc614e;
		anInt310 = 0xbc614e;
		anInt240 = 180;
		anInt241 = 155;
		anInt242 = 95;
		anInt243 = 256;
		anInt239 = 512;
		anInt238 = 32;
		aBoolean297 = flag;
		aBoolean299 = flag1;
		aBoolean298 = flag2;
		aBoolean264 = flag3;
		aBoolean295 = flag4;
		method186(i, j);
	}

	public Model(String s) {
		anInt254 = 1;
		aBoolean287 = true;
		aBoolean226 = true;
		aBoolean227 = false;
		aBoolean267 = false;
		anInt228 = -1;
		aBoolean297 = false;
		aBoolean299 = false;
		aBoolean298 = false;
		aBoolean264 = false;
		aBoolean295 = false;
		anInt230 = 4;
		anInt234 = 0xbc614e;
		anInt310 = 0xbc614e;
		anInt240 = 180;
		anInt241 = 155;
		anInt242 = 95;
		anInt243 = 256;
		anInt239 = 512;
		anInt238 = 32;
		boolean flag = false;
		boolean flag1 = false;
		byte[] abyte0 = null;
		try {
			java.io.InputStream inputstream = DataUtils.method353(s);
			DataInputStream datainputstream = new DataInputStream(inputstream);
			abyte0 = new byte[3];
			anInt232 = 0;
			anInt231 = 0;
			for(int i = 0; i < 3; i += datainputstream.read(abyte0, i, 3 - i));
			int k = method174(abyte0);
			abyte0 = new byte[k];
			anInt232 = 0;
			anInt231 = 0;
			for(int j = 0; j < k; j += datainputstream.read(abyte0, j, k - j));
			datainputstream.close();
		}
		catch(IOException _ex) {
			anInt236 = 0;
			anInt235 = 0;
			return;
		}
		int l = method174(abyte0);
		int i1 = method174(abyte0);
		boolean flag2 = false;
		method186(l, i1);
		anIntArrayArray237 = new int[i1][];
		for(int j3 = 0; j3 < l; j3++) {
			int j1 = method174(abyte0);
			int k1 = method174(abyte0);
			int l1 = method174(abyte0);
			method198(j1, k1, l1);
		}

		for(int k3 = 0; k3 < i1; k3++) {
			int i2 = method174(abyte0);
			int j2 = method174(abyte0);
			int k2 = method174(abyte0);
			int l2 = method174(abyte0);
			anInt239 = method174(abyte0);
			anInt238 = method174(abyte0);
			int i3 = method174(abyte0);
			int[] ai = new int[i2];
			for(int l3 = 0; l3 < i2; l3++)
				ai[l3] = method174(abyte0);

			int[] ai1 = new int[l2];
			for(int i4 = 0; i4 < l2; i4++)
				ai1[i4] = method174(abyte0);

			int j4 = createFace(i2, ai, j2, k2);
			anIntArrayArray237[k3] = ai1;
			if(i3 == 0)
				anIntArray251[j4] = 0;
			else
				anIntArray251[j4] = anInt234;
		}

		anInt254 = 1;
	}

	public void method203(int i, int j, int k) {
		anInt270 = i & 0xff;
		anInt269 = j & 0xff;
		anInt268 = k & 0xff;
		method187();
		anInt254 = 1;
	}

	public void rotate(int i, int j, int k) {
		anInt270 = anInt270 + i & 0xff;
		anInt269 = anInt269 + j & 0xff;
		anInt268 = anInt268 + k & 0xff;
		method187();
		anInt254 = 1;
	}

	public void method205(boolean flag, int i, int j, int k, int l, int i1) {
		anInt238 = 256 - i * 4;
		anInt239 = (64 - j) * 16 + 128;
		if(aBoolean298)
			return;
		for(int j1 = 0; j1 < anInt235; j1++)
			if(flag)
				anIntArray251[j1] = anInt234;
			else
				anIntArray251[j1] = 0;

		anInt240 = k;
		anInt241 = l;
		anInt242 = i1;
		anInt243 = (int)Math.sqrt(k * k + l * l + i1 * i1);
		method189();
	}

	private void method206() {
		anInt283 = anInt285 = anInt281 = 0xf423f;
		anInt310 = anInt284 = anInt286 = anInt282 = 0xfff0bdc1;
		for(int i = 0; i < anInt235; i++) {
			int[] ai = anIntArrayArray245[i];
			int k = ai[0];
			int i1 = anIntArray244[i];
			int j1;
			int k1 = j1 = anIntArray257[k];
			int l1;
			int i2 = l1 = anIntArray256[k];
			int j2;
			int k2 = j2 = anIntArray258[k];
			for(int j = 0; j < i1; j++) {
				int l = ai[j];
				if(anIntArray257[l] < j1)
					j1 = anIntArray257[l];
				else
				if(anIntArray257[l] > k1)
					k1 = anIntArray257[l];
				if(anIntArray256[l] < l1)
					l1 = anIntArray256[l];
				else
				if(anIntArray256[l] > i2)
					i2 = anIntArray256[l];
				if(anIntArray258[l] < j2)
					j2 = anIntArray258[l];
				else
				if(anIntArray258[l] > k2)
					k2 = anIntArray258[l];
			}

			if(!aBoolean299) {
				anIntArray303[i] = j1;
				anIntArray304[i] = k1;
				anIntArray305[i] = l1;
				anIntArray306[i] = i2;
				anIntArray307[i] = j2;
				anIntArray308[i] = k2;
			}
			if(k1 - j1 > anInt310)
				anInt310 = k1 - j1;
			if(i2 - l1 > anInt310)
				anInt310 = i2 - l1;
			if(k2 - j2 > anInt310)
				anInt310 = k2 - j2;
			if(j1 < anInt283)
				anInt283 = j1;
			if(k1 > anInt284)
				anInt284 = k1;
			if(l1 < anInt285)
				anInt285 = l1;
			if(i2 > anInt286)
				anInt286 = i2;
			if(j2 < anInt281)
				anInt281 = j2;
			if(k2 > anInt282)
				anInt282 = k2;
		}

	}

	public boolean aBoolean226;
	public boolean aBoolean227;
	public int anInt228;
	private static final byte[] aByteArray229;
	private final int anInt230;
	private int anInt231;
	private int anInt232;
	private static final int[] anIntArray233;
	private final int anInt234;
	public int anInt235;
	public int anInt236;
	private int[][] anIntArrayArray237;
	protected int anInt238;
	protected int anInt239;
	private int anInt240;
	private int anInt241;
	private int anInt242;
	private int anInt243;
	public int[] anIntArray244;
	public int[][] anIntArrayArray245;
	public int[] anIntArray246;
	public int[] anIntArray247;
	public int[] anIntArray248;
	public int[] anIntArray249;
	public int[] anIntArray250;
	public int[] anIntArray251;
	public int[] anIntArray252;
	public int[] anIntArray253;
	public int anInt254;
	private static final int[] anIntArray255;
	public int[] anIntArray256;
	public int[] anIntArray257;
	public int[] anIntArray258;
	private int anInt259;
	private int anInt260;
	private int anInt261;
	public int[] anIntArray262;
	public byte[] aByteArray263;
	public boolean aBoolean264;
	public int[] faceTag;
	public int anInt266;
	public boolean aBoolean267;
	private int anInt268;
	private int anInt269;
	private int anInt270;
	private int anInt271;
	private int anInt272;
	private int anInt273;
	private int anInt274;
	private int anInt275;
	private int anInt276;
	private int anInt277;
	private int anInt278;
	private int anInt279;
	private int anInt280;
	public int anInt281;
	public int anInt282;
	public int anInt283;
	public int anInt284;
	public int anInt285;
	public int anInt286;
	public boolean aBoolean287;
	private static final int[] anIntArray288;
	public int[] anIntArray289;
	public int[] anIntArray290;
	public int[] anIntArray291;
	public int[] anIntArray292;
	public int[] anIntArray293;
	private int anInt294;
	public boolean aBoolean295;
	public byte[] isLocalPlayer;
	private boolean aBoolean297;
	public boolean aBoolean298;
	public boolean aBoolean299;
	public int[] anIntArray300;
	public int[] anIntArray301;
	public int[] anIntArray302;
	private int[] anIntArray303;
	private int[] anIntArray304;
	private int[] anIntArray305;
	private int[] anIntArray306;
	private int[] anIntArray307;
	private int[] anIntArray308;
	public int anInt309;
	private int anInt310;

	static  {
		anIntArray255 = new int[512];
		anIntArray288 = new int[2048];
		aByteArray229 = new byte[64];
		anIntArray233 = new int[256];
		for(int i = 0; i < 256; i++) {
			anIntArray255[i] = (int)(Math.sin((double)i * 0.02454369D) * 32768D);
			anIntArray255[i + 256] = (int)(Math.cos((double)i * 0.02454369D) * 32768D);
		}

		for(int j = 0; j < 1024; j++) {
			anIntArray288[j] = (int)(Math.sin((double)j * 0.00613592315D) * 32768D);
			anIntArray288[j + 1024] = (int)(Math.cos((double)j * 0.00613592315D) * 32768D);
		}

		for(int k = 0; k < 10; k++)
			aByteArray229[k] = (byte)(48 + k);

		for(int l = 0; l < 26; l++)
			aByteArray229[l + 10] = (byte)(65 + l);

		for(int i1 = 0; i1 < 26; i1++)
			aByteArray229[i1 + 36] = (byte)(97 + i1);

		aByteArray229[62] = -93;
		aByteArray229[63] = 36;
		for(int j1 = 0; j1 < 10; j1++)
			anIntArray233[48 + j1] = j1;

		for(int k1 = 0; k1 < 26; k1++)
			anIntArray233[65 + k1] = k1 + 10;

		for(int l1 = 0; l1 < 26; l1++)
			anIntArray233[97 + l1] = l1 + 36;

		anIntArray233[163] = 62;
		anIntArray233[36] = 63;
	}
}
