// Decompiled by Jad v1.5.8c. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

import java.io.PrintStream;

public class Scene {

	public void method263(int i, int j, int k, int l, int i1, int j1, int k1) {
		l &= 0x3ff;
		i1 &= 0x3ff;
		j1 &= 0x3ff;
		anInt379 = 1024 - l & 0x3ff;
		anInt380 = 1024 - i1 & 0x3ff;
		anInt381 = 1024 - j1 & 0x3ff;
		int l1 = 0;
		int i2 = 0;
		int j2 = k1;
		if(l != 0) {
			int k2 = anIntArray382[l];
			int j3 = anIntArray382[l + 1024];
			int i4 = i2 * j3 - j2 * k2 >> 15;
			j2 = i2 * k2 + j2 * j3 >> 15;
			i2 = i4;
		}
		if(i1 != 0) {
			int l2 = anIntArray382[i1];
			int k3 = anIntArray382[i1 + 1024];
			int j4 = j2 * l2 + l1 * k3 >> 15;
			j2 = j2 * k3 - l1 * l2 >> 15;
			l1 = j4;
		}
		if(j1 != 0) {
			int i3 = anIntArray382[j1];
			int l3 = anIntArray382[j1 + 1024];
			int k4 = i2 * i3 + l1 * l3 >> 15;
			i2 = i2 * l3 - l1 * i3 >> 15;
			l1 = k4;
		}
		anInt383 = i - l1;
		anInt384 = j - i2;
		anInt385 = k - j2;
	}

	private void method264(int i) {
		char c;
		if(anIntArray386[i] == 0)
			c = '@';
		else
			c = '\200';
		int[] ai = anIntArrayArray387[i];
		int j = 0;
		for(int k = 0; k < c; k++) {
			for(int l = 0; l < c; l++) {
				int j1 = anIntArrayArray388[i][aByteArrayArray389[i][l + k * c] & 0xff];
				j1 &= 0xf8f8ff;
				if(j1 == 0)
					j1 = 1;
				else
				if(j1 == 0xf800ff) {
					j1 = 0;
					aBooleanArray390[i] = true;
				}
				ai[j++] = j1;
			}

		}

		for(int i1 = 0; i1 < j; i1++) {
			int k1 = ai[i1];
			ai[j + i1] = k1 - (k1 >>> 3) & 0xf8f8ff;
			ai[j * 2 + i1] = k1 - (k1 >>> 2) & 0xf8f8ff;
			ai[j * 3 + i1] = k1 - (k1 >>> 2) - (k1 >>> 3) & 0xf8f8ff;
		}

	}

	public void method265(int i) {
		anInt391 -= i;
		aModel392.method180(i, i * 2);
		if(anInt391 < 0)
			anInt391 = 0;
	}

	public boolean method266(int[] ai, int[] ai1, int[] ai2, int[] ai3) {
		int i = ai.length;
		int j = ai2.length;
		byte byte0 = 0;
		int i20;
		int k20 = i20 = ai1[0];
		int k = 0;
		int j20;
		int l20 = j20 = ai3[0];
		int i1 = 0;
		for(int i21 = 1; i21 < i; i21++)
			if(ai1[i21] < i20) {
				i20 = ai1[i21];
				k = i21;
			} else
			if(ai1[i21] > k20)
				k20 = ai1[i21];

		for(int j21 = 1; j21 < j; j21++)
			if(ai3[j21] < j20) {
				j20 = ai3[j21];
				i1 = j21;
			} else
			if(ai3[j21] > l20)
				l20 = ai3[j21];

		if(j20 >= k20)
			return false;
		if(i20 >= l20)
			return false;
		int l;
		int j1;
		boolean flag;
		if(ai1[k] < ai3[i1]) {
			for(l = k; ai1[l] < ai3[i1]; l = (l + 1) % i);
			for(; ai1[k] < ai3[i1]; k = ((k - 1) + i) % i);
			int k1 = method308(ai[(k + 1) % i], ai1[(k + 1) % i], ai[k], ai1[k], ai3[i1]);
			int k6 = method308(ai[((l - 1) + i) % i], ai1[((l - 1) + i) % i], ai[l], ai1[l], ai3[i1]);
			int l10 = ai2[i1];
			flag = (k1 < l10) | (k6 < l10);
			if(method300(k1, k6, l10, flag))
				return true;
			j1 = (i1 + 1) % j;
			i1 = ((i1 - 1) + j) % j;
			if(k == l)
				byte0 = 1;
		} else {
			for(j1 = i1; ai3[j1] < ai1[k]; j1 = (j1 + 1) % j);
			for(; ai3[i1] < ai1[k]; i1 = ((i1 - 1) + j) % j);
			int l1 = ai[k];
			int i11 = method308(ai2[(i1 + 1) % j], ai3[(i1 + 1) % j], ai2[i1], ai3[i1], ai1[k]);
			int l15 = method308(ai2[((j1 - 1) + j) % j], ai3[((j1 - 1) + j) % j], ai2[j1], ai3[j1], ai1[k]);
			flag = (l1 < i11) | (l1 < l15);
			if(method300(i11, l15, l1, !flag))
				return true;
			l = (k + 1) % i;
			k = ((k - 1) + i) % i;
			if(i1 == j1)
				byte0 = 2;
		}
		while(byte0 == 0) 
			if(ai1[k] < ai1[l]) {
				if(ai1[k] < ai3[i1]) {
					if(ai1[k] < ai3[j1]) {
						int i2 = ai[k];
						int l6 = method308(ai[((l - 1) + i) % i], ai1[((l - 1) + i) % i], ai[l], ai1[l], ai1[k]);
						int j11 = method308(ai2[(i1 + 1) % j], ai3[(i1 + 1) % j], ai2[i1], ai3[i1], ai1[k]);
						int i16 = method308(ai2[((j1 - 1) + j) % j], ai3[((j1 - 1) + j) % j], ai2[j1], ai3[j1], ai1[k]);
						if(method303(i2, l6, j11, i16, flag))
							return true;
						k = ((k - 1) + i) % i;
						if(k == l)
							byte0 = 1;
					} else {
						int j2 = method308(ai[(k + 1) % i], ai1[(k + 1) % i], ai[k], ai1[k], ai3[j1]);
						int i7 = method308(ai[((l - 1) + i) % i], ai1[((l - 1) + i) % i], ai[l], ai1[l], ai3[j1]);
						int k11 = method308(ai2[(i1 + 1) % j], ai3[(i1 + 1) % j], ai2[i1], ai3[i1], ai3[j1]);
						int j16 = ai2[j1];
						if(method303(j2, i7, k11, j16, flag))
							return true;
						j1 = (j1 + 1) % j;
						if(i1 == j1)
							byte0 = 2;
					}
				} else
				if(ai3[i1] < ai3[j1]) {
					int k2 = method308(ai[(k + 1) % i], ai1[(k + 1) % i], ai[k], ai1[k], ai3[i1]);
					int j7 = method308(ai[((l - 1) + i) % i], ai1[((l - 1) + i) % i], ai[l], ai1[l], ai3[i1]);
					int l11 = ai2[i1];
					int k16 = method308(ai2[((j1 - 1) + j) % j], ai3[((j1 - 1) + j) % j], ai2[j1], ai3[j1], ai3[i1]);
					if(method303(k2, j7, l11, k16, flag))
						return true;
					i1 = ((i1 - 1) + j) % j;
					if(i1 == j1)
						byte0 = 2;
				} else {
					int l2 = method308(ai[(k + 1) % i], ai1[(k + 1) % i], ai[k], ai1[k], ai3[j1]);
					int k7 = method308(ai[((l - 1) + i) % i], ai1[((l - 1) + i) % i], ai[l], ai1[l], ai3[j1]);
					int i12 = method308(ai2[(i1 + 1) % j], ai3[(i1 + 1) % j], ai2[i1], ai3[i1], ai3[j1]);
					int l16 = ai2[j1];
					if(method303(l2, k7, i12, l16, flag))
						return true;
					j1 = (j1 + 1) % j;
					if(i1 == j1)
						byte0 = 2;
				}
			} else
			if(ai1[l] < ai3[i1]) {
				if(ai1[l] < ai3[j1]) {
					int i3 = method308(ai[(k + 1) % i], ai1[(k + 1) % i], ai[k], ai1[k], ai1[l]);
					int l7 = ai[l];
					int j12 = method308(ai2[(i1 + 1) % j], ai3[(i1 + 1) % j], ai2[i1], ai3[i1], ai1[l]);
					int i17 = method308(ai2[((j1 - 1) + j) % j], ai3[((j1 - 1) + j) % j], ai2[j1], ai3[j1], ai1[l]);
					if(method303(i3, l7, j12, i17, flag))
						return true;
					l = (l + 1) % i;
					if(k == l)
						byte0 = 1;
				} else {
					int j3 = method308(ai[(k + 1) % i], ai1[(k + 1) % i], ai[k], ai1[k], ai3[j1]);
					int i8 = method308(ai[((l - 1) + i) % i], ai1[((l - 1) + i) % i], ai[l], ai1[l], ai3[j1]);
					int k12 = method308(ai2[(i1 + 1) % j], ai3[(i1 + 1) % j], ai2[i1], ai3[i1], ai3[j1]);
					int j17 = ai2[j1];
					if(method303(j3, i8, k12, j17, flag))
						return true;
					j1 = (j1 + 1) % j;
					if(i1 == j1)
						byte0 = 2;
				}
			} else
			if(ai3[i1] < ai3[j1]) {
				int k3 = method308(ai[(k + 1) % i], ai1[(k + 1) % i], ai[k], ai1[k], ai3[i1]);
				int j8 = method308(ai[((l - 1) + i) % i], ai1[((l - 1) + i) % i], ai[l], ai1[l], ai3[i1]);
				int l12 = ai2[i1];
				int k17 = method308(ai2[((j1 - 1) + j) % j], ai3[((j1 - 1) + j) % j], ai2[j1], ai3[j1], ai3[i1]);
				if(method303(k3, j8, l12, k17, flag))
					return true;
				i1 = ((i1 - 1) + j) % j;
				if(i1 == j1)
					byte0 = 2;
			} else {
				int l3 = method308(ai[(k + 1) % i], ai1[(k + 1) % i], ai[k], ai1[k], ai3[j1]);
				int k8 = method308(ai[((l - 1) + i) % i], ai1[((l - 1) + i) % i], ai[l], ai1[l], ai3[j1]);
				int i13 = method308(ai2[(i1 + 1) % j], ai3[(i1 + 1) % j], ai2[i1], ai3[i1], ai3[j1]);
				int l17 = ai2[j1];
				if(method303(l3, k8, i13, l17, flag))
					return true;
				j1 = (j1 + 1) % j;
				if(i1 == j1)
					byte0 = 2;
			}
		while(byte0 == 1) 
			if(ai1[k] < ai3[i1]) {
				if(ai1[k] < ai3[j1]) {
					int i4 = ai[k];
					int j13 = method308(ai2[(i1 + 1) % j], ai3[(i1 + 1) % j], ai2[i1], ai3[i1], ai1[k]);
					int i18 = method308(ai2[((j1 - 1) + j) % j], ai3[((j1 - 1) + j) % j], ai2[j1], ai3[j1], ai1[k]);
					return method300(j13, i18, i4, !flag);
				}
				int j4 = method308(ai[(k + 1) % i], ai1[(k + 1) % i], ai[k], ai1[k], ai3[j1]);
				int l8 = method308(ai[((l - 1) + i) % i], ai1[((l - 1) + i) % i], ai[l], ai1[l], ai3[j1]);
				int k13 = method308(ai2[(i1 + 1) % j], ai3[(i1 + 1) % j], ai2[i1], ai3[i1], ai3[j1]);
				int j18 = ai2[j1];
				if(method303(j4, l8, k13, j18, flag))
					return true;
				j1 = (j1 + 1) % j;
				if(i1 == j1)
					byte0 = 0;
			} else
			if(ai3[i1] < ai3[j1]) {
				int k4 = method308(ai[(k + 1) % i], ai1[(k + 1) % i], ai[k], ai1[k], ai3[i1]);
				int i9 = method308(ai[((l - 1) + i) % i], ai1[((l - 1) + i) % i], ai[l], ai1[l], ai3[i1]);
				int l13 = ai2[i1];
				int k18 = method308(ai2[((j1 - 1) + j) % j], ai3[((j1 - 1) + j) % j], ai2[j1], ai3[j1], ai3[i1]);
				if(method303(k4, i9, l13, k18, flag))
					return true;
				i1 = ((i1 - 1) + j) % j;
				if(i1 == j1)
					byte0 = 0;
			} else {
				int l4 = method308(ai[(k + 1) % i], ai1[(k + 1) % i], ai[k], ai1[k], ai3[j1]);
				int j9 = method308(ai[((l - 1) + i) % i], ai1[((l - 1) + i) % i], ai[l], ai1[l], ai3[j1]);
				int i14 = method308(ai2[(i1 + 1) % j], ai3[(i1 + 1) % j], ai2[i1], ai3[i1], ai3[j1]);
				int l18 = ai2[j1];
				if(method303(l4, j9, i14, l18, flag))
					return true;
				j1 = (j1 + 1) % j;
				if(i1 == j1)
					byte0 = 0;
			}
		while(byte0 == 2) 
			if(ai3[i1] < ai1[k]) {
				if(ai3[i1] < ai1[l]) {
					int i5 = method308(ai[(k + 1) % i], ai1[(k + 1) % i], ai[k], ai1[k], ai3[i1]);
					int k9 = method308(ai[((l - 1) + i) % i], ai1[((l - 1) + i) % i], ai[l], ai1[l], ai3[i1]);
					int j14 = ai2[i1];
					return method300(i5, k9, j14, flag);
				}
				int j5 = method308(ai[(k + 1) % i], ai1[(k + 1) % i], ai[k], ai1[k], ai1[l]);
				int l9 = ai[l];
				int k14 = method308(ai2[(i1 + 1) % j], ai3[(i1 + 1) % j], ai2[i1], ai3[i1], ai1[l]);
				int i19 = method308(ai2[((j1 - 1) + j) % j], ai3[((j1 - 1) + j) % j], ai2[j1], ai3[j1], ai1[l]);
				if(method303(j5, l9, k14, i19, flag))
					return true;
				l = (l + 1) % i;
				if(k == l)
					byte0 = 0;
			} else
			if(ai1[k] < ai1[l]) {
				int k5 = ai[k];
				int i10 = method308(ai[((l - 1) + i) % i], ai1[((l - 1) + i) % i], ai[l], ai1[l], ai1[k]);
				int l14 = method308(ai2[(i1 + 1) % j], ai3[(i1 + 1) % j], ai2[i1], ai3[i1], ai1[k]);
				int j19 = method308(ai2[((j1 - 1) + j) % j], ai3[((j1 - 1) + j) % j], ai2[j1], ai3[j1], ai1[k]);
				if(method303(k5, i10, l14, j19, flag))
					return true;
				k = ((k - 1) + i) % i;
				if(k == l)
					byte0 = 0;
			} else {
				int l5 = method308(ai[(k + 1) % i], ai1[(k + 1) % i], ai[k], ai1[k], ai1[l]);
				int j10 = ai[l];
				int i15 = method308(ai2[(i1 + 1) % j], ai3[(i1 + 1) % j], ai2[i1], ai3[i1], ai1[l]);
				int k19 = method308(ai2[((j1 - 1) + j) % j], ai3[((j1 - 1) + j) % j], ai2[j1], ai3[j1], ai1[l]);
				if(method303(l5, j10, i15, k19, flag))
					return true;
				l = (l + 1) % i;
				if(k == l)
					byte0 = 0;
			}
		if(ai1[k] < ai3[i1]) {
			int i6 = ai[k];
			int j15 = method308(ai2[(i1 + 1) % j], ai3[(i1 + 1) % j], ai2[i1], ai3[i1], ai1[k]);
			int l19 = method308(ai2[((j1 - 1) + j) % j], ai3[((j1 - 1) + j) % j], ai2[j1], ai3[j1], ai1[k]);
			return method300(j15, l19, i6, !flag);
		}
		int j6 = method308(ai[(k + 1) % i], ai1[(k + 1) % i], ai[k], ai1[k], ai3[i1]);
		int k10 = method308(ai[((l - 1) + i) % i], ai1[((l - 1) + i) % i], ai[l], ai1[l], ai3[i1]);
		int k15 = ai2[i1];
		return method300(j6, k10, k15, flag);
	}

	public boolean method267(Polygon[] apolygon, int i, int j) {
		do {
			Polygon polygon = apolygon[i];
			for(int k = i + 1; k <= j; k++) {
				Polygon polygon1 = apolygon[k];
				if(!method291(polygon1, polygon))
					break;
				apolygon[i] = polygon1;
				apolygon[k] = polygon;
				i = k;
				if(i == j) {
					anInt393 = i;
					anInt394 = i - 1;
					return true;
				}
			}

			Polygon polygon2 = apolygon[j];
			for(int l = j - 1; l >= i; l--) {
				Polygon polygon3 = apolygon[l];
				if(!method291(polygon2, polygon3))
					break;
				apolygon[j] = polygon3;
				apolygon[l] = polygon2;
				j = l;
				if(i == j) {
					anInt393 = j + 1;
					anInt394 = j;
					return true;
				}
			}

			if(i + 1 >= j) {
				anInt393 = i;
				anInt394 = j;
				return false;
			}
			if(!method267(apolygon, i + 1, j)) {
				anInt393 = i;
				return false;
			}
			j = anInt394;
		} while(true);
	}

	public void method268(int i, int j, int k) {
		int l = -anInt379 + 1024 & 0x3ff;
		int i1 = -anInt380 + 1024 & 0x3ff;
		int j1 = -anInt381 + 1024 & 0x3ff;
		if(j1 != 0) {
			int k1 = anIntArray382[j1];
			int j2 = anIntArray382[j1 + 1024];
			int i3 = j * k1 + i * j2 >> 15;
			j = j * j2 - i * k1 >> 15;
			i = i3;
		}
		if(l != 0) {
			int l1 = anIntArray382[l];
			int k2 = anIntArray382[l + 1024];
			int j3 = j * k2 - k * l1 >> 15;
			k = j * l1 + k * k2 >> 15;
			j = j3;
		}
		if(i1 != 0) {
			int i2 = anIntArray382[i1];
			int l2 = anIntArray382[i1 + 1024];
			int k3 = k * i2 + i * l2 >> 15;
			k = k * l2 - i * i2 >> 15;
			i = k3;
		}
		if(i < anInt395)
			anInt395 = i;
		if(i > anInt396)
			anInt396 = i;
		if(j < anInt397)
			anInt397 = j;
		if(j > anInt398)
			anInt398 = j;
		if(k < anInt399)
			anInt399 = k;
		if(k > anInt400)
			anInt400 = k;
	}

	public int method269(int i) {
		if(i == 0xbc614e)
			return 0;
		method289(i);
		if(i >= 0)
			return anIntArrayArray387[i][0];
		if(i < 0) {
			i = -(i + 1);
			int j = i >> 10 & 0x1f;
			int k = i >> 5 & 0x1f;
			int l = i & 0x1f;
			return (j << 19) + (k << 11) + (l << 3);
		} else {
			return 0;
		}
	}

	public void method270(int i) {
		if(anIntArrayArray387[i] == null)
			return;
		int[] ai = anIntArrayArray387[i];
		for(int j = 0; j < 64; j++) {
			int k = j + 4032;
			int l = ai[k];
			for(int j1 = 0; j1 < 63; j1++) {
				ai[k] = ai[k - 64];
				k -= 64;
			}

			anIntArrayArray387[i][k] = l;
		}

		char c = '\u1000';
		for(int i1 = 0; i1 < c; i1++) {
			int k1 = ai[i1];
			ai[c + i1] = k1 - (k1 >>> 3) & 0xf8f8ff;
			ai[c * 2 + i1] = k1 - (k1 >>> 2) & 0xf8f8ff;
			ai[c * 3 + i1] = k1 - (k1 >>> 2) - (k1 >>> 3) & 0xf8f8ff;
		}

	}

	public void method271(Model model) {
		for(int i = 0; i < anInt402; i++)
			if(aModelArray401[i] == model) {
				anInt402--;
				for(int j = i; j < anInt402; j++) {
					aModelArray401[j] = aModelArray401[j + 1];
					anIntArray403[j] = anIntArray403[j + 1];
				}

			}

	}

	private void method272(Polygon[] apolygon, int i, int j) {
		if(i < j) {
			int k = i - 1;
			int l = j + 1;
			int i1 = (i + j) / 2;
			Polygon polygon = apolygon[i1];
			apolygon[i1] = apolygon[i];
			apolygon[i] = polygon;
			int j1 = polygon.anInt361;
			while(k < l)  {
				do
					l--;
				while(apolygon[l].anInt361 < j1);
				do
					k++;
				while(apolygon[k].anInt361 > j1);
				if(k < l) {
					Polygon polygon1 = apolygon[k];
					apolygon[k] = apolygon[l];
					apolygon[l] = polygon1;
				}
			}
			method272(apolygon, i, l);
			method272(apolygon, l + 1, j);
		}
	}

	private void method273(int i, int j, int k, int l, int i1, int[] ai, int[] ai1,
                           int[] ai2, Model model, int j1) {
		if(i1 == 3) {
			int k1 = ai1[0] + anInt404;
			int k2 = ai1[1] + anInt404;
			int k3 = ai1[2] + anInt404;
			int k4 = ai[0];
			int l5 = ai[1];
			int j7 = ai[2];
			int l8 = ai2[0];
			int j10 = ai2[1];
			int j11 = ai2[2];
			int j12 = (anInt404 + anInt405) - 1;
			int l12 = 0;
			int j13 = 0;
			int l13 = 0;
			int j14 = 0;
			int l14 = 0xbc614e;
			int j15 = 0xff439eb2;
			if(k3 != k1) {
				j13 = (j7 - k4 << 8) / (k3 - k1);
				j14 = (j11 - l8 << 8) / (k3 - k1);
				if(k1 < k3) {
					l12 = k4 << 8;
					l13 = l8 << 8;
					l14 = k1;
					j15 = k3;
				} else {
					l12 = j7 << 8;
					l13 = j11 << 8;
					l14 = k3;
					j15 = k1;
				}
				if(l14 < 0) {
					l12 -= j13 * l14;
					l13 -= j14 * l14;
					l14 = 0;
				}
				if(j15 > j12)
					j15 = j12;
			}
			int l15 = 0;
			int j16 = 0;
			int l16 = 0;
			int j17 = 0;
			int l17 = 0xbc614e;
			int j18 = 0xff439eb2;
			if(k2 != k1) {
				j16 = (l5 - k4 << 8) / (k2 - k1);
				j17 = (j10 - l8 << 8) / (k2 - k1);
				if(k1 < k2) {
					l15 = k4 << 8;
					l16 = l8 << 8;
					l17 = k1;
					j18 = k2;
				} else {
					l15 = l5 << 8;
					l16 = j10 << 8;
					l17 = k2;
					j18 = k1;
				}
				if(l17 < 0) {
					l15 -= j16 * l17;
					l16 -= j17 * l17;
					l17 = 0;
				}
				if(j18 > j12)
					j18 = j12;
			}
			int l18 = 0;
			int j19 = 0;
			int l19 = 0;
			int j20 = 0;
			int l20 = 0xbc614e;
			int j21 = 0xff439eb2;
			if(k3 != k2) {
				j19 = (j7 - l5 << 8) / (k3 - k2);
				j20 = (j11 - j10 << 8) / (k3 - k2);
				if(k2 < k3) {
					l18 = l5 << 8;
					l19 = j10 << 8;
					l20 = k2;
					j21 = k3;
				} else {
					l18 = j7 << 8;
					l19 = j11 << 8;
					l20 = k3;
					j21 = k2;
				}
				if(l20 < 0) {
					l18 -= j19 * l20;
					l19 -= j20 * l20;
					l20 = 0;
				}
				if(j21 > j12)
					j21 = j12;
			}
			anInt406 = l14;
			if(l17 < anInt406)
				anInt406 = l17;
			if(l20 < anInt406)
				anInt406 = l20;
			anInt407 = j15;
			if(j18 > anInt407)
				anInt407 = j18;
			if(j21 > anInt407)
				anInt407 = j21;
			int l21 = 0;
			for(k = anInt406; k < anInt407; k++) {
				if(k >= l14 && k < j15) {
					i = j = l12;
					l = l21 = l13;
					l12 += j13;
					l13 += j14;
				} else {
					i = 0xa0000;
					j = 0xfff60000;
				}
				if(k >= l17 && k < j18) {
					if(l15 < i) {
						i = l15;
						l = l16;
					}
					if(l15 > j) {
						j = l15;
						l21 = l16;
					}
					l15 += j16;
					l16 += j17;
				}
				if(k >= l20 && k < j21) {
					if(l18 < i) {
						i = l18;
						l = l19;
					}
					if(l18 > j) {
						j = l18;
						l21 = l19;
					}
					l18 += j19;
					l19 += j20;
				}
				Scanline scanline6 = aScanlineArray408[k];
				scanline6.anInt370 = i;
				scanline6.anInt371 = j;
				scanline6.anInt372 = l;
				scanline6.anInt373 = l21;
			}

			if(anInt406 < anInt404 - anInt405)
				anInt406 = anInt404 - anInt405;
		} else
		if(i1 == 4) {
			int l1 = ai1[0] + anInt404;
			int l2 = ai1[1] + anInt404;
			int l3 = ai1[2] + anInt404;
			int l4 = ai1[3] + anInt404;
			int i6 = ai[0];
			int k7 = ai[1];
			int i9 = ai[2];
			int k10 = ai[3];
			int k11 = ai2[0];
			int k12 = ai2[1];
			int i13 = ai2[2];
			int k13 = ai2[3];
			int i14 = (anInt404 + anInt405) - 1;
			int k14 = 0;
			int i15 = 0;
			int k15 = 0;
			int i16 = 0;
			int k16 = 0xbc614e;
			int i17 = 0xff439eb2;
			if(l4 != l1) {
				i15 = (k10 - i6 << 8) / (l4 - l1);
				i16 = (k13 - k11 << 8) / (l4 - l1);
				if(l1 < l4) {
					k14 = i6 << 8;
					k15 = k11 << 8;
					k16 = l1;
					i17 = l4;
				} else {
					k14 = k10 << 8;
					k15 = k13 << 8;
					k16 = l4;
					i17 = l1;
				}
				if(k16 < 0) {
					k14 -= i15 * k16;
					k15 -= i16 * k16;
					k16 = 0;
				}
				if(i17 > i14)
					i17 = i14;
			}
			int k17 = 0;
			int i18 = 0;
			int k18 = 0;
			int i19 = 0;
			int k19 = 0xbc614e;
			int i20 = 0xff439eb2;
			if(l2 != l1) {
				i18 = (k7 - i6 << 8) / (l2 - l1);
				i19 = (k12 - k11 << 8) / (l2 - l1);
				if(l1 < l2) {
					k17 = i6 << 8;
					k18 = k11 << 8;
					k19 = l1;
					i20 = l2;
				} else {
					k17 = k7 << 8;
					k18 = k12 << 8;
					k19 = l2;
					i20 = l1;
				}
				if(k19 < 0) {
					k17 -= i18 * k19;
					k18 -= i19 * k19;
					k19 = 0;
				}
				if(i20 > i14)
					i20 = i14;
			}
			int k20 = 0;
			int i21 = 0;
			int k21 = 0;
			int i22 = 0;
			int j22 = 0xbc614e;
			int k22 = 0xff439eb2;
			if(l3 != l2) {
				i21 = (i9 - k7 << 8) / (l3 - l2);
				i22 = (i13 - k12 << 8) / (l3 - l2);
				if(l2 < l3) {
					k20 = k7 << 8;
					k21 = k12 << 8;
					j22 = l2;
					k22 = l3;
				} else {
					k20 = i9 << 8;
					k21 = i13 << 8;
					j22 = l3;
					k22 = l2;
				}
				if(j22 < 0) {
					k20 -= i21 * j22;
					k21 -= i22 * j22;
					j22 = 0;
				}
				if(k22 > i14)
					k22 = i14;
			}
			int l22 = 0;
			int i23 = 0;
			int j23 = 0;
			int k23 = 0;
			int l23 = 0xbc614e;
			int i24 = 0xff439eb2;
			if(l4 != l3) {
				i23 = (k10 - i9 << 8) / (l4 - l3);
				k23 = (k13 - i13 << 8) / (l4 - l3);
				if(l3 < l4) {
					l22 = i9 << 8;
					j23 = i13 << 8;
					l23 = l3;
					i24 = l4;
				} else {
					l22 = k10 << 8;
					j23 = k13 << 8;
					l23 = l4;
					i24 = l3;
				}
				if(l23 < 0) {
					l22 -= i23 * l23;
					j23 -= k23 * l23;
					l23 = 0;
				}
				if(i24 > i14)
					i24 = i14;
			}
			anInt406 = k16;
			if(k19 < anInt406)
				anInt406 = k19;
			if(j22 < anInt406)
				anInt406 = j22;
			if(l23 < anInt406)
				anInt406 = l23;
			anInt407 = i17;
			if(i20 > anInt407)
				anInt407 = i20;
			if(k22 > anInt407)
				anInt407 = k22;
			if(i24 > anInt407)
				anInt407 = i24;
			int j24 = 0;
			for(k = anInt406; k < anInt407; k++) {
				if(k >= k16 && k < i17) {
					i = j = k14;
					l = j24 = k15;
					k14 += i15;
					k15 += i16;
				} else {
					i = 0xa0000;
					j = 0xfff60000;
				}
				if(k >= k19 && k < i20) {
					if(k17 < i) {
						i = k17;
						l = k18;
					}
					if(k17 > j) {
						j = k17;
						j24 = k18;
					}
					k17 += i18;
					k18 += i19;
				}
				if(k >= j22 && k < k22) {
					if(k20 < i) {
						i = k20;
						l = k21;
					}
					if(k20 > j) {
						j = k20;
						j24 = k21;
					}
					k20 += i21;
					k21 += i22;
				}
				if(k >= l23 && k < i24) {
					if(l22 < i) {
						i = l22;
						l = j23;
					}
					if(l22 > j) {
						j = l22;
						j24 = j23;
					}
					l22 += i23;
					j23 += k23;
				}
				Scanline scanline7 = aScanlineArray408[k];
				scanline7.anInt370 = i;
				scanline7.anInt371 = j;
				scanline7.anInt372 = l;
				scanline7.anInt373 = j24;
			}

			if(anInt406 < anInt404 - anInt405)
				anInt406 = anInt404 - anInt405;
		} else {
			anInt407 = anInt406 = ai1[0] += anInt404;
			for(k = 1; k < i1; k++) {
				int i2;
				if((i2 = ai1[k] += anInt404) < anInt406)
					anInt406 = i2;
				else
				if(i2 > anInt407)
					anInt407 = i2;
			}

			if(anInt406 < anInt404 - anInt405)
				anInt406 = anInt404 - anInt405;
			if(anInt407 >= anInt404 + anInt405)
				anInt407 = (anInt404 + anInt405) - 1;
			if(anInt406 >= anInt407)
				return;
			for(k = anInt406; k < anInt407; k++) {
				Scanline scanline = aScanlineArray408[k];
				scanline.anInt370 = 0xa0000;
				scanline.anInt371 = 0xfff60000;
			}

			int j2 = i1 - 1;
			int i3 = ai1[0];
			int i4 = ai1[j2];
			if(i3 < i4) {
				int i5 = ai[0] << 8;
				int j6 = (ai[j2] - ai[0] << 8) / (i4 - i3);
				int l7 = ai2[0] << 8;
				int j9 = (ai2[j2] - ai2[0] << 8) / (i4 - i3);
				if(i3 < 0) {
					i5 -= j6 * i3;
					l7 -= j9 * i3;
					i3 = 0;
				}
				if(i4 > anInt407)
					i4 = anInt407;
				for(k = i3; k <= i4; k++) {
					Scanline scanline2 = aScanlineArray408[k];
					scanline2.anInt370 = scanline2.anInt371 = i5;
					scanline2.anInt372 = scanline2.anInt373 = l7;
					i5 += j6;
					l7 += j9;
				}

			} else
			if(i3 > i4) {
				int j5 = ai[j2] << 8;
				int k6 = (ai[0] - ai[j2] << 8) / (i3 - i4);
				int i8 = ai2[j2] << 8;
				int k9 = (ai2[0] - ai2[j2] << 8) / (i3 - i4);
				if(i4 < 0) {
					j5 -= k6 * i4;
					i8 -= k9 * i4;
					i4 = 0;
				}
				if(i3 > anInt407)
					i3 = anInt407;
				for(k = i4; k <= i3; k++) {
					Scanline scanline3 = aScanlineArray408[k];
					scanline3.anInt370 = scanline3.anInt371 = j5;
					scanline3.anInt372 = scanline3.anInt373 = i8;
					j5 += k6;
					i8 += k9;
				}

			}
			for(k = 0; k < j2; k++) {
				int k5 = k + 1;
				int j3 = ai1[k];
				int j4 = ai1[k5];
				if(j3 < j4) {
					int l6 = ai[k] << 8;
					int j8 = (ai[k5] - ai[k] << 8) / (j4 - j3);
					int l9 = ai2[k] << 8;
					int l10 = (ai2[k5] - ai2[k] << 8) / (j4 - j3);
					if(j3 < 0) {
						l6 -= j8 * j3;
						l9 -= l10 * j3;
						j3 = 0;
					}
					if(j4 > anInt407)
						j4 = anInt407;
					for(int l11 = j3; l11 <= j4; l11++) {
						Scanline scanline4 = aScanlineArray408[l11];
						if(l6 < scanline4.anInt370) {
							scanline4.anInt370 = l6;
							scanline4.anInt372 = l9;
						}
						if(l6 > scanline4.anInt371) {
							scanline4.anInt371 = l6;
							scanline4.anInt373 = l9;
						}
						l6 += j8;
						l9 += l10;
					}

				} else
				if(j3 > j4) {
					int i7 = ai[k5] << 8;
					int k8 = (ai[k] - ai[k5] << 8) / (j3 - j4);
					int i10 = ai2[k5] << 8;
					int i11 = (ai2[k] - ai2[k5] << 8) / (j3 - j4);
					if(j4 < 0) {
						i7 -= k8 * j4;
						i10 -= i11 * j4;
						j4 = 0;
					}
					if(j3 > anInt407)
						j3 = anInt407;
					for(int i12 = j4; i12 <= j3; i12++) {
						Scanline scanline5 = aScanlineArray408[i12];
						if(i7 < scanline5.anInt370) {
							scanline5.anInt370 = i7;
							scanline5.anInt372 = i10;
						}
						if(i7 > scanline5.anInt371) {
							scanline5.anInt371 = i7;
							scanline5.anInt373 = i10;
						}
						i7 += k8;
						i10 += i11;
					}

				}
			}

			if(anInt406 < anInt404 - anInt405)
				anInt406 = anInt404 - anInt405;
		}
		if(aBoolean409 && anInt410 < anInt411 && anInt412 >= anInt406 && anInt412 < anInt407) {
			Scanline scanline1 = aScanlineArray408[anInt412];
			if(anInt413 >= scanline1.anInt370 >> 8 && anInt413 <= scanline1.anInt371 >> 8 && scanline1.anInt370 <= scanline1.anInt371 && !model.aBoolean264 && model.aByteArray296[j1] == 0) {
				aModelArray414[anInt410] = model;
				anIntArray415[anInt410] = j1;
				anInt410++;
			}
		}
	}

	private void method274(int i) {
		Polygon polygon = aPolygonArray416[i];
		Model model = polygon.aModel359;
		int j = polygon.anInt360;
		int[] ai = model.anIntArrayArray245[j];
		int l = 0;
		int i1 = 0;
		int j1 = 1;
		int k1 = model.anIntArray291[ai[0]];
		int l1 = model.anIntArray292[ai[0]];
		int i2 = model.anIntArray293[ai[0]];
		model.anIntArray253[j] = 1;
		model.anIntArray252[j] = 0;
		polygon.anInt365 = k1 * l + l1 * i1 + i2 * j1;
		polygon.anInt362 = l;
		polygon.anInt363 = i1;
		polygon.anInt364 = j1;
		int j2 = model.anIntArray293[ai[0]];
		int k2 = j2;
		int l2 = model.anIntArray289[ai[0]];
		int i3 = l2;
		if(model.anIntArray289[ai[1]] < l2)
			l2 = model.anIntArray289[ai[1]];
		else
			i3 = model.anIntArray289[ai[1]];
		int j3 = model.anIntArray290[ai[1]];
		int k3 = model.anIntArray290[ai[0]];
		int k = model.anIntArray293[ai[1]];
		if(k > k2)
			k2 = k;
		else
		if(k < j2)
			j2 = k;
		k = model.anIntArray289[ai[1]];
		if(k > i3)
			i3 = k;
		else
		if(k < l2)
			l2 = k;
		k = model.anIntArray290[ai[1]];
		if(k > k3)
			k3 = k;
		else
		if(k < j3)
			j3 = k;
		polygon.anInt357 = j2;
		polygon.anInt358 = k2;
		polygon.anInt353 = l2 - 20;
		polygon.anInt355 = i3 + 20;
		polygon.anInt354 = j3;
		polygon.anInt356 = k3;
	}

	public static int method275(int i, int j, int k) {
		return -1 - (i / 8) * 1024 - (j / 8) * 32 - k / 8;
	}

	public void method276() {
		anInt391 = 0;
		aModel392.method178();
	}

	public void method277(int i) {
		aModel392.aByteArray296[i] = 1;
	}

	private static void method278(int[] ai, int i, int j, int k, int[] ai1, int l, int i1) {
		if(i >= 0)
			return;
		i1 <<= 1;
		k = ai1[l >> 8 & 0xff];
		l += i1;
		int j1 = i / 8;
		for(int k1 = j1; k1 < 0; k1++) {
			ai[j++] = k;
			ai[j++] = k;
			k = ai1[l >> 8 & 0xff];
			l += i1;
			ai[j++] = k;
			ai[j++] = k;
			k = ai1[l >> 8 & 0xff];
			l += i1;
			ai[j++] = k;
			ai[j++] = k;
			k = ai1[l >> 8 & 0xff];
			l += i1;
			ai[j++] = k;
			ai[j++] = k;
			k = ai1[l >> 8 & 0xff];
			l += i1;
		}

		j1 = -(i % 8);
		for(int l1 = 0; l1 < j1; l1++) {
			ai[j++] = k;
			if((l1 & 1) == 1) {
				k = ai1[l >> 8 & 0xff];
				l += i1;
			}
		}

	}

	private static void method279(int[] ai, int[] ai1, int i, int j, int k, int l, int i1, int j1,
                                  int k1, int l1, int i2, int j2, int k2, int l2) {
		if(i2 <= 0)
			return;
		int i3 = 0;
		int j3 = 0;
		l2 <<= 2;
		if(i1 != 0) {
			i3 = k / i1 << 6;
			j3 = l / i1 << 6;
		}
		if(i3 < 0)
			i3 = 0;
		else
		if(i3 > 4032)
			i3 = 4032;
		for(int i4 = i2; i4 > 0; i4 -= 16) {
			k += j1;
			l += k1;
			i1 += l1;
			i = i3;
			j = j3;
			if(i1 != 0) {
				i3 = k / i1 << 6;
				j3 = l / i1 << 6;
			}
			if(i3 < 0)
				i3 = 0;
			else
			if(i3 > 4032)
				i3 = 4032;
			int k3 = i3 - i >> 4;
			int l3 = j3 - j >> 4;
			int j4 = k2 >> 20;
			i += k2 & 0xc0000;
			k2 += l2;
			if(i4 < 16) {
				for(int k4 = 0; k4 < i4; k4++) {
					ai[j2++] = (ai1[(j & 0xfc0) + (i >> 6)] >>> j4) + (ai[j2] >> 1 & 0x7f7f7f);
					i += k3;
					j += l3;
					if((k4 & 3) == 3) {
						i = (i & 0xfff) + (k2 & 0xc0000);
						j4 = k2 >> 20;
						k2 += l2;
					}
				}

			} else {
				ai[j2++] = (ai1[(j & 0xfc0) + (i >> 6)] >>> j4) + (ai[j2] >> 1 & 0x7f7f7f);
				i += k3;
				j += l3;
				ai[j2++] = (ai1[(j & 0xfc0) + (i >> 6)] >>> j4) + (ai[j2] >> 1 & 0x7f7f7f);
				i += k3;
				j += l3;
				ai[j2++] = (ai1[(j & 0xfc0) + (i >> 6)] >>> j4) + (ai[j2] >> 1 & 0x7f7f7f);
				i += k3;
				j += l3;
				ai[j2++] = (ai1[(j & 0xfc0) + (i >> 6)] >>> j4) + (ai[j2] >> 1 & 0x7f7f7f);
				i += k3;
				j += l3;
				i = (i & 0xfff) + (k2 & 0xc0000);
				j4 = k2 >> 20;
				k2 += l2;
				ai[j2++] = (ai1[(j & 0xfc0) + (i >> 6)] >>> j4) + (ai[j2] >> 1 & 0x7f7f7f);
				i += k3;
				j += l3;
				ai[j2++] = (ai1[(j & 0xfc0) + (i >> 6)] >>> j4) + (ai[j2] >> 1 & 0x7f7f7f);
				i += k3;
				j += l3;
				ai[j2++] = (ai1[(j & 0xfc0) + (i >> 6)] >>> j4) + (ai[j2] >> 1 & 0x7f7f7f);
				i += k3;
				j += l3;
				ai[j2++] = (ai1[(j & 0xfc0) + (i >> 6)] >>> j4) + (ai[j2] >> 1 & 0x7f7f7f);
				i += k3;
				j += l3;
				i = (i & 0xfff) + (k2 & 0xc0000);
				j4 = k2 >> 20;
				k2 += l2;
				ai[j2++] = (ai1[(j & 0xfc0) + (i >> 6)] >>> j4) + (ai[j2] >> 1 & 0x7f7f7f);
				i += k3;
				j += l3;
				ai[j2++] = (ai1[(j & 0xfc0) + (i >> 6)] >>> j4) + (ai[j2] >> 1 & 0x7f7f7f);
				i += k3;
				j += l3;
				ai[j2++] = (ai1[(j & 0xfc0) + (i >> 6)] >>> j4) + (ai[j2] >> 1 & 0x7f7f7f);
				i += k3;
				j += l3;
				ai[j2++] = (ai1[(j & 0xfc0) + (i >> 6)] >>> j4) + (ai[j2] >> 1 & 0x7f7f7f);
				i += k3;
				j += l3;
				i = (i & 0xfff) + (k2 & 0xc0000);
				j4 = k2 >> 20;
				k2 += l2;
				ai[j2++] = (ai1[(j & 0xfc0) + (i >> 6)] >>> j4) + (ai[j2] >> 1 & 0x7f7f7f);
				i += k3;
				j += l3;
				ai[j2++] = (ai1[(j & 0xfc0) + (i >> 6)] >>> j4) + (ai[j2] >> 1 & 0x7f7f7f);
				i += k3;
				j += l3;
				ai[j2++] = (ai1[(j & 0xfc0) + (i >> 6)] >>> j4) + (ai[j2] >> 1 & 0x7f7f7f);
				i += k3;
				j += l3;
				ai[j2++] = (ai1[(j & 0xfc0) + (i >> 6)] >>> j4) + (ai[j2] >> 1 & 0x7f7f7f);
			}
		}

	}

	private static void method280(int[] ai, int i, int j, int k, int[] ai1, int l, int i1, int j1,
                                  int k1, int l1, int i2, int j2, int k2, int l2, int i3) {
		if(j2 <= 0)
			return;
		int j3 = 0;
		int k3 = 0;
		i3 <<= 2;
		if(j1 != 0) {
			j3 = l / j1 << 7;
			k3 = i1 / j1 << 7;
		}
		if(j3 < 0)
			j3 = 0;
		else
		if(j3 > 16256)
			j3 = 16256;
		for(int j4 = j2; j4 > 0; j4 -= 16) {
			l += k1;
			i1 += l1;
			j1 += i2;
			j = j3;
			k = k3;
			if(j1 != 0) {
				j3 = l / j1 << 7;
				k3 = i1 / j1 << 7;
			}
			if(j3 < 0)
				j3 = 0;
			else
			if(j3 > 16256)
				j3 = 16256;
			int l3 = j3 - j >> 4;
			int i4 = k3 - k >> 4;
			int k4 = l2 >> 23;
			j += l2 & 0x600000;
			l2 += i3;
			if(j4 < 16) {
				for(int l4 = 0; l4 < j4; l4++) {
					if((i = ai1[(k & 0x3f80) + (j >> 7)] >>> k4) != 0)
						ai[k2] = i;
					k2++;
					j += l3;
					k += i4;
					if((l4 & 3) == 3) {
						j = (j & 0x3fff) + (l2 & 0x600000);
						k4 = l2 >> 23;
						l2 += i3;
					}
				}

			} else {
				if((i = ai1[(k & 0x3f80) + (j >> 7)] >>> k4) != 0)
					ai[k2] = i;
				k2++;
				j += l3;
				k += i4;
				if((i = ai1[(k & 0x3f80) + (j >> 7)] >>> k4) != 0)
					ai[k2] = i;
				k2++;
				j += l3;
				k += i4;
				if((i = ai1[(k & 0x3f80) + (j >> 7)] >>> k4) != 0)
					ai[k2] = i;
				k2++;
				j += l3;
				k += i4;
				if((i = ai1[(k & 0x3f80) + (j >> 7)] >>> k4) != 0)
					ai[k2] = i;
				k2++;
				j += l3;
				k += i4;
				j = (j & 0x3fff) + (l2 & 0x600000);
				k4 = l2 >> 23;
				l2 += i3;
				if((i = ai1[(k & 0x3f80) + (j >> 7)] >>> k4) != 0)
					ai[k2] = i;
				k2++;
				j += l3;
				k += i4;
				if((i = ai1[(k & 0x3f80) + (j >> 7)] >>> k4) != 0)
					ai[k2] = i;
				k2++;
				j += l3;
				k += i4;
				if((i = ai1[(k & 0x3f80) + (j >> 7)] >>> k4) != 0)
					ai[k2] = i;
				k2++;
				j += l3;
				k += i4;
				if((i = ai1[(k & 0x3f80) + (j >> 7)] >>> k4) != 0)
					ai[k2] = i;
				k2++;
				j += l3;
				k += i4;
				j = (j & 0x3fff) + (l2 & 0x600000);
				k4 = l2 >> 23;
				l2 += i3;
				if((i = ai1[(k & 0x3f80) + (j >> 7)] >>> k4) != 0)
					ai[k2] = i;
				k2++;
				j += l3;
				k += i4;
				if((i = ai1[(k & 0x3f80) + (j >> 7)] >>> k4) != 0)
					ai[k2] = i;
				k2++;
				j += l3;
				k += i4;
				if((i = ai1[(k & 0x3f80) + (j >> 7)] >>> k4) != 0)
					ai[k2] = i;
				k2++;
				j += l3;
				k += i4;
				if((i = ai1[(k & 0x3f80) + (j >> 7)] >>> k4) != 0)
					ai[k2] = i;
				k2++;
				j += l3;
				k += i4;
				j = (j & 0x3fff) + (l2 & 0x600000);
				k4 = l2 >> 23;
				l2 += i3;
				if((i = ai1[(k & 0x3f80) + (j >> 7)] >>> k4) != 0)
					ai[k2] = i;
				k2++;
				j += l3;
				k += i4;
				if((i = ai1[(k & 0x3f80) + (j >> 7)] >>> k4) != 0)
					ai[k2] = i;
				k2++;
				j += l3;
				k += i4;
				if((i = ai1[(k & 0x3f80) + (j >> 7)] >>> k4) != 0)
					ai[k2] = i;
				k2++;
				j += l3;
				k += i4;
				if((i = ai1[(k & 0x3f80) + (j >> 7)] >>> k4) != 0)
					ai[k2] = i;
				k2++;
			}
		}

	}

	private static void method281(int[] ai, int i, int j, int k, int[] ai1, int l, int i1) {
		if(i >= 0)
			return;
		i1 <<= 2;
		k = ai1[l >> 8 & 0xff];
		l += i1;
		int j1 = i / 16;
		for(int k1 = j1; k1 < 0; k1++) {
			ai[j++] = k + (ai[j] >> 1 & 0x7f7f7f);
			ai[j++] = k + (ai[j] >> 1 & 0x7f7f7f);
			ai[j++] = k + (ai[j] >> 1 & 0x7f7f7f);
			ai[j++] = k + (ai[j] >> 1 & 0x7f7f7f);
			k = ai1[l >> 8 & 0xff];
			l += i1;
			ai[j++] = k + (ai[j] >> 1 & 0x7f7f7f);
			ai[j++] = k + (ai[j] >> 1 & 0x7f7f7f);
			ai[j++] = k + (ai[j] >> 1 & 0x7f7f7f);
			ai[j++] = k + (ai[j] >> 1 & 0x7f7f7f);
			k = ai1[l >> 8 & 0xff];
			l += i1;
			ai[j++] = k + (ai[j] >> 1 & 0x7f7f7f);
			ai[j++] = k + (ai[j] >> 1 & 0x7f7f7f);
			ai[j++] = k + (ai[j] >> 1 & 0x7f7f7f);
			ai[j++] = k + (ai[j] >> 1 & 0x7f7f7f);
			k = ai1[l >> 8 & 0xff];
			l += i1;
			ai[j++] = k + (ai[j] >> 1 & 0x7f7f7f);
			ai[j++] = k + (ai[j] >> 1 & 0x7f7f7f);
			ai[j++] = k + (ai[j] >> 1 & 0x7f7f7f);
			ai[j++] = k + (ai[j] >> 1 & 0x7f7f7f);
			k = ai1[l >> 8 & 0xff];
			l += i1;
		}

		j1 = -(i % 16);
		for(int l1 = 0; l1 < j1; l1++) {
			ai[j++] = k + (ai[j] >> 1 & 0x7f7f7f);
			if((l1 & 3) == 3) {
				k = ai1[l >> 8 & 0xff];
				l += i1;
				l += i1;
			}
		}

	}

	private static void method282(int[] ai, int i, int j, int k, int[] ai1, int l, int i1) {
		if(i >= 0)
			return;
		i1 <<= 2;
		k = ai1[l >> 8 & 0xff];
		l += i1;
		int j1 = i / 16;
		for(int k1 = j1; k1 < 0; k1++) {
			ai[j++] = k;
			ai[j++] = k;
			ai[j++] = k;
			ai[j++] = k;
			k = ai1[l >> 8 & 0xff];
			l += i1;
			ai[j++] = k;
			ai[j++] = k;
			ai[j++] = k;
			ai[j++] = k;
			k = ai1[l >> 8 & 0xff];
			l += i1;
			ai[j++] = k;
			ai[j++] = k;
			ai[j++] = k;
			ai[j++] = k;
			k = ai1[l >> 8 & 0xff];
			l += i1;
			ai[j++] = k;
			ai[j++] = k;
			ai[j++] = k;
			ai[j++] = k;
			k = ai1[l >> 8 & 0xff];
			l += i1;
		}

		j1 = -(i % 16);
		for(int l1 = 0; l1 < j1; l1++) {
			ai[j++] = k;
			if((l1 & 3) == 3) {
				k = ai1[l >> 8 & 0xff];
				l += i1;
			}
		}

	}

	private static void method283(int[] ai, int[] ai1, int i, int j, int k, int l, int i1, int j1,
                                  int k1, int l1, int i2, int j2, int k2, int l2) {
		if(i2 <= 0)
			return;
		int i3 = 0;
		int j3 = 0;
		int i4 = 0;
		if(i1 != 0) {
			i = k / i1 << 7;
			j = l / i1 << 7;
		}
		if(i < 0)
			i = 0;
		else
		if(i > 16256)
			i = 16256;
		k += j1;
		l += k1;
		i1 += l1;
		if(i1 != 0) {
			i3 = k / i1 << 7;
			j3 = l / i1 << 7;
		}
		if(i3 < 0)
			i3 = 0;
		else
		if(i3 > 16256)
			i3 = 16256;
		int k3 = i3 - i >> 4;
		int l3 = j3 - j >> 4;
		for(int j4 = i2 >> 4; j4 > 0; j4--) {
			i += k2 & 0x600000;
			i4 = k2 >> 23;
			k2 += l2;
			ai[j2++] = ai1[(j & 0x3f80) + (i >> 7)] >>> i4;
			i += k3;
			j += l3;
			ai[j2++] = ai1[(j & 0x3f80) + (i >> 7)] >>> i4;
			i += k3;
			j += l3;
			ai[j2++] = ai1[(j & 0x3f80) + (i >> 7)] >>> i4;
			i += k3;
			j += l3;
			ai[j2++] = ai1[(j & 0x3f80) + (i >> 7)] >>> i4;
			i += k3;
			j += l3;
			i = (i & 0x3fff) + (k2 & 0x600000);
			i4 = k2 >> 23;
			k2 += l2;
			ai[j2++] = ai1[(j & 0x3f80) + (i >> 7)] >>> i4;
			i += k3;
			j += l3;
			ai[j2++] = ai1[(j & 0x3f80) + (i >> 7)] >>> i4;
			i += k3;
			j += l3;
			ai[j2++] = ai1[(j & 0x3f80) + (i >> 7)] >>> i4;
			i += k3;
			j += l3;
			ai[j2++] = ai1[(j & 0x3f80) + (i >> 7)] >>> i4;
			i += k3;
			j += l3;
			i = (i & 0x3fff) + (k2 & 0x600000);
			i4 = k2 >> 23;
			k2 += l2;
			ai[j2++] = ai1[(j & 0x3f80) + (i >> 7)] >>> i4;
			i += k3;
			j += l3;
			ai[j2++] = ai1[(j & 0x3f80) + (i >> 7)] >>> i4;
			i += k3;
			j += l3;
			ai[j2++] = ai1[(j & 0x3f80) + (i >> 7)] >>> i4;
			i += k3;
			j += l3;
			ai[j2++] = ai1[(j & 0x3f80) + (i >> 7)] >>> i4;
			i += k3;
			j += l3;
			i = (i & 0x3fff) + (k2 & 0x600000);
			i4 = k2 >> 23;
			k2 += l2;
			ai[j2++] = ai1[(j & 0x3f80) + (i >> 7)] >>> i4;
			i += k3;
			j += l3;
			ai[j2++] = ai1[(j & 0x3f80) + (i >> 7)] >>> i4;
			i += k3;
			j += l3;
			ai[j2++] = ai1[(j & 0x3f80) + (i >> 7)] >>> i4;
			i += k3;
			j += l3;
			ai[j2++] = ai1[(j & 0x3f80) + (i >> 7)] >>> i4;
			i = i3;
			j = j3;
			k += j1;
			l += k1;
			i1 += l1;
			if(i1 != 0) {
				i3 = k / i1 << 7;
				j3 = l / i1 << 7;
			}
			if(i3 < 0)
				i3 = 0;
			else
			if(i3 > 16256)
				i3 = 16256;
			k3 = i3 - i >> 4;
			l3 = j3 - j >> 4;
		}

		for(int k4 = 0; k4 < (i2 & 0xf); k4++) {
			if((k4 & 3) == 0) {
				i = (i & 0x3fff) + (k2 & 0x600000);
				i4 = k2 >> 23;
				k2 += l2;
			}
			ai[j2++] = ai1[(j & 0x3f80) + (i >> 7)] >>> i4;
			i += k3;
			j += l3;
		}

	}

	private static void method284(int[] ai, int[] ai1, int i, int j, int k, int l, int i1, int j1,
                                  int k1, int l1, int i2, int j2, int k2, int l2) {
		if(i2 <= 0)
			return;
		int i3 = 0;
		int j3 = 0;
		int i4 = 0;
		if(i1 != 0) {
			i = k / i1 << 7;
			j = l / i1 << 7;
		}
		if(i < 0)
			i = 0;
		else
		if(i > 16256)
			i = 16256;
		k += j1;
		l += k1;
		i1 += l1;
		if(i1 != 0) {
			i3 = k / i1 << 7;
			j3 = l / i1 << 7;
		}
		if(i3 < 0)
			i3 = 0;
		else
		if(i3 > 16256)
			i3 = 16256;
		int k3 = i3 - i >> 4;
		int l3 = j3 - j >> 4;
		for(int j4 = i2 >> 4; j4 > 0; j4--) {
			i += k2 & 0x600000;
			i4 = k2 >> 23;
			k2 += l2;
			ai[j2++] = (ai1[(j & 0x3f80) + (i >> 7)] >>> i4) + (ai[j2] >> 1 & 0x7f7f7f);
			i += k3;
			j += l3;
			ai[j2++] = (ai1[(j & 0x3f80) + (i >> 7)] >>> i4) + (ai[j2] >> 1 & 0x7f7f7f);
			i += k3;
			j += l3;
			ai[j2++] = (ai1[(j & 0x3f80) + (i >> 7)] >>> i4) + (ai[j2] >> 1 & 0x7f7f7f);
			i += k3;
			j += l3;
			ai[j2++] = (ai1[(j & 0x3f80) + (i >> 7)] >>> i4) + (ai[j2] >> 1 & 0x7f7f7f);
			i += k3;
			j += l3;
			i = (i & 0x3fff) + (k2 & 0x600000);
			i4 = k2 >> 23;
			k2 += l2;
			ai[j2++] = (ai1[(j & 0x3f80) + (i >> 7)] >>> i4) + (ai[j2] >> 1 & 0x7f7f7f);
			i += k3;
			j += l3;
			ai[j2++] = (ai1[(j & 0x3f80) + (i >> 7)] >>> i4) + (ai[j2] >> 1 & 0x7f7f7f);
			i += k3;
			j += l3;
			ai[j2++] = (ai1[(j & 0x3f80) + (i >> 7)] >>> i4) + (ai[j2] >> 1 & 0x7f7f7f);
			i += k3;
			j += l3;
			ai[j2++] = (ai1[(j & 0x3f80) + (i >> 7)] >>> i4) + (ai[j2] >> 1 & 0x7f7f7f);
			i += k3;
			j += l3;
			i = (i & 0x3fff) + (k2 & 0x600000);
			i4 = k2 >> 23;
			k2 += l2;
			ai[j2++] = (ai1[(j & 0x3f80) + (i >> 7)] >>> i4) + (ai[j2] >> 1 & 0x7f7f7f);
			i += k3;
			j += l3;
			ai[j2++] = (ai1[(j & 0x3f80) + (i >> 7)] >>> i4) + (ai[j2] >> 1 & 0x7f7f7f);
			i += k3;
			j += l3;
			ai[j2++] = (ai1[(j & 0x3f80) + (i >> 7)] >>> i4) + (ai[j2] >> 1 & 0x7f7f7f);
			i += k3;
			j += l3;
			ai[j2++] = (ai1[(j & 0x3f80) + (i >> 7)] >>> i4) + (ai[j2] >> 1 & 0x7f7f7f);
			i += k3;
			j += l3;
			i = (i & 0x3fff) + (k2 & 0x600000);
			i4 = k2 >> 23;
			k2 += l2;
			ai[j2++] = (ai1[(j & 0x3f80) + (i >> 7)] >>> i4) + (ai[j2] >> 1 & 0x7f7f7f);
			i += k3;
			j += l3;
			ai[j2++] = (ai1[(j & 0x3f80) + (i >> 7)] >>> i4) + (ai[j2] >> 1 & 0x7f7f7f);
			i += k3;
			j += l3;
			ai[j2++] = (ai1[(j & 0x3f80) + (i >> 7)] >>> i4) + (ai[j2] >> 1 & 0x7f7f7f);
			i += k3;
			j += l3;
			ai[j2++] = (ai1[(j & 0x3f80) + (i >> 7)] >>> i4) + (ai[j2] >> 1 & 0x7f7f7f);
			i = i3;
			j = j3;
			k += j1;
			l += k1;
			i1 += l1;
			if(i1 != 0) {
				i3 = k / i1 << 7;
				j3 = l / i1 << 7;
			}
			if(i3 < 0)
				i3 = 0;
			else
			if(i3 > 16256)
				i3 = 16256;
			k3 = i3 - i >> 4;
			l3 = j3 - j >> 4;
		}

		for(int k4 = 0; k4 < (i2 & 0xf); k4++) {
			if((k4 & 3) == 0) {
				i = (i & 0x3fff) + (k2 & 0x600000);
				i4 = k2 >> 23;
				k2 += l2;
			}
			ai[j2++] = (ai1[(j & 0x3f80) + (i >> 7)] >>> i4) + (ai[j2] >> 1 & 0x7f7f7f);
			i += k3;
			j += l3;
		}

	}

	public void method285(int i, Polygon[] apolygon, int j) {
		for(int k = 0; k <= j; k++) {
			apolygon[k].aBoolean368 = false;
			apolygon[k].anInt367 = k;
			apolygon[k].anInt369 = -1;
		}

		int l = 0;
		do {
			while(apolygon[l].aBoolean368) 
				l++;
			if(l == j)
				return;
			Polygon polygon = apolygon[l];
			polygon.aBoolean368 = true;
			int i1 = l;
			int j1 = l + i;
			if(j1 >= j)
				j1 = j - 1;
			for(int k1 = j1; k1 >= i1 + 1; k1--) {
				Polygon polygon1 = apolygon[k1];
				if(polygon.anInt353 < polygon1.anInt355 && polygon1.anInt353 < polygon.anInt355 && polygon.anInt354 < polygon1.anInt356 && polygon1.anInt354 < polygon.anInt356 && polygon.anInt367 != polygon1.anInt369 && !method291(polygon, polygon1) && method296(polygon1, polygon)) {
					method267(apolygon, i1, k1);
					if(apolygon[k1] != polygon1)
						k1++;
					i1 = anInt393;
					polygon1.anInt369 = polygon.anInt367;
				}
			}

		} while(true);
	}

	public void method286(int i, int j) {
		anInt413 = i - anInt417;
		anInt412 = j;
		anInt410 = 0;
		aBoolean409 = true;
	}

	public void method287(int i, int j, int k) {
		anInt418 = i;
		aByteArrayArray389 = new byte[i][];
		anIntArrayArray388 = new int[i][];
		anIntArray386 = new int[i];
		aLongArray419 = new long[i];
		aBooleanArray390 = new boolean[i];
		anIntArrayArray387 = new int[i][];
		aLong420 = 0L;
		anIntArrayArray421 = new int[j][];
		anIntArrayArray422 = new int[k][];
	}

	public void method288() {
		aBoolean424 = aSurface423.aBoolean321;
		int i3 = anInt425 * anInt426 >> anInt427;
		int j3 = anInt405 * anInt426 >> anInt427;
		anInt395 = 0;
		anInt396 = 0;
		anInt397 = 0;
		anInt398 = 0;
		anInt399 = 0;
		anInt400 = 0;
		method268(-i3, -j3, anInt426);
		method268(-i3, j3, anInt426);
		method268(i3, -j3, anInt426);
		method268(i3, j3, anInt426);
		method268(-anInt425, -anInt405, 0);
		method268(-anInt425, anInt405, 0);
		method268(anInt425, -anInt405, 0);
		method268(anInt425, anInt405, 0);
		anInt395 += anInt383;
		anInt396 += anInt383;
		anInt397 += anInt384;
		anInt398 += anInt384;
		anInt399 += anInt385;
		anInt400 += anInt385;
		aModelArray401[anInt402] = aModel392;
		aModel392.anInt254 = 2;
		for(int i = 0; i < anInt402; i++)
			aModelArray401[i].method183(anInt383, anInt384, anInt385, anInt379, anInt380, anInt381, anInt427, anInt428);

		aModelArray401[anInt402].method183(anInt383, anInt384, anInt385, anInt379, anInt380, anInt381, anInt427, anInt428);
		anInt429 = 0;
		for(int k3 = 0; k3 < anInt402; k3++) {
			Model model = aModelArray401[k3];
			if(model.aBoolean287) {
				for(int j = 0; j < model.anInt235; j++) {
					int l3 = model.anIntArray244[j];
					int[] ai1 = model.anIntArrayArray245[j];
					boolean flag = false;
					for(int k4 = 0; k4 < l3; k4++) {
						int i1 = model.anIntArray293[ai1[k4]];
						if(i1 <= anInt428 || i1 >= anInt426)
							continue;
						flag = true;
						break;
					}

					if(flag) {
						int l1 = 0;
						for(int k5 = 0; k5 < l3; k5++) {
							int j1 = model.anIntArray289[ai1[k5]];
							if(j1 > -anInt425)
								l1 |= 1;
							if(j1 < anInt425)
								l1 |= 2;
							if(l1 == 3)
								break;
						}

						if(l1 == 3) {
							int i2 = 0;
							for(int l6 = 0; l6 < l3; l6++) {
								int k1 = model.anIntArray290[ai1[l6]];
								if(k1 > -anInt405)
									i2 |= 1;
								if(k1 < anInt405)
									i2 |= 2;
								if(i2 == 3)
									break;
							}

							if(i2 == 3) {
								Polygon polygon1 = aPolygonArray416[anInt429];
								polygon1.aModel359 = model;
								polygon1.anInt360 = j;
								method304(anInt429);
								int l8;
								if(polygon1.anInt365 < 0)
									l8 = model.anIntArray249[j];
								else
									l8 = model.anIntArray250[j];
								if(l8 != 0xbc614e) {
									int j2 = 0;
									for(int l9 = 0; l9 < l3; l9++)
										j2 += model.anIntArray293[ai1[l9]];

									int l2;
									polygon1.anInt361 = l2 = j2 / l3 + model.anInt266;
									polygon1.anInt366 = l8;
									anInt429++;
								}
							}
						}
					}
				}

			}
		}

		Model model1 = aModel392;
		if(model1.aBoolean287) {
			for(int k = 0; k < model1.anInt235; k++) {
				int[] ai = model1.anIntArrayArray245[k];
				int j4 = ai[0];
				int l4 = model1.anIntArray289[j4];
				int l5 = model1.anIntArray290[j4];
				int i7 = model1.anIntArray293[j4];
				if(i7 > anInt428 && i7 < anInt430) {
					int i8 = (anIntArray431[k] << anInt427) / i7;
					int i9 = (anIntArray432[k] << anInt427) / i7;
					if(l4 - i8 / 2 <= anInt425 && l4 + i8 / 2 >= -anInt425 && l5 - i9 <= anInt405 && l5 >= -anInt405) {
						Polygon polygon2 = aPolygonArray416[anInt429];
						polygon2.aModel359 = model1;
						polygon2.anInt360 = k;
						method274(anInt429);
						polygon2.anInt361 = (i7 + model1.anIntArray293[ai[1]]) / 2;
						anInt429++;
					}
				}
			}

		}
		if(anInt429 == 0)
			return;
		anInt433 = anInt429;
		method272(aPolygonArray416, 0, anInt429 - 1);
		method285(100, aPolygonArray416, anInt429);
		for(int i4 = 0; i4 < anInt429; i4++) {
			Polygon polygon = aPolygonArray416[i4];
			Model model2 = polygon.aModel359;
			int l = polygon.anInt360;
			if(model2 == aModel392) {
				int[] ai2 = model2.anIntArrayArray245[l];
				int i6 = ai2[0];
				int j7 = model2.anIntArray289[i6];
				int j8 = model2.anIntArray290[i6];
				int j9 = model2.anIntArray293[i6];
				int i10 = (anIntArray431[l] << anInt427) / j9;
				int k10 = (anIntArray432[l] << anInt427) / j9;
				int i11 = j8 - model2.anIntArray290[ai2[1]];
				int j11 = ((model2.anIntArray289[ai2[1]] - j7) * i11) / k10;
				j11 = model2.anIntArray289[ai2[1]] - j7;
				int l11 = j7 - i10 / 2;
				int j12 = (anInt404 + j8) - k10;
				aSurface423.method220(l11 + anInt417, j12, i10, k10, anIntArray434[l], j11, (256 << anInt427) / j9);
				if(aBoolean409 && anInt410 < anInt411) {
					l11 += (anIntArray435[l] << anInt427) / j9;
					if(anInt412 >= j12 && anInt412 <= j12 + k10 && anInt413 >= l11 && anInt413 <= l11 + i10 && !model2.aBoolean264 && model2.aByteArray296[l] == 0) {
						aModelArray414[anInt410] = model2;
						anIntArray415[anInt410] = l;
						anInt410++;
					}
				}
			} else {
				int k8 = 0;
				int j10 = 0;
				int l10 = model2.anIntArray244[l];
				int[] ai3 = model2.anIntArrayArray245[l];
				if(model2.anIntArray251[l] != 0xbc614e)
					if(polygon.anInt365 < 0)
						j10 = model2.anInt238 - model2.anIntArray251[l];
					else
						j10 = model2.anInt238 + model2.anIntArray251[l];
				for(int k11 = 0; k11 < l10; k11++) {
					int k2 = ai3[k11];
					anIntArray436[k11] = model2.anIntArray291[k2];
					anIntArray437[k11] = model2.anIntArray292[k2];
					anIntArray438[k11] = model2.anIntArray293[k2];
					if(model2.anIntArray251[l] == 0xbc614e)
						if(polygon.anInt365 < 0)
							j10 = (model2.anInt238 - model2.anIntArray262[k2]) + model2.aByteArray263[k2];
						else
							j10 = model2.anInt238 + model2.anIntArray262[k2] + model2.aByteArray263[k2];
					if(model2.anIntArray293[k2] >= anInt428) {
						anIntArray439[k8] = model2.anIntArray289[k2];
						anIntArray440[k8] = model2.anIntArray290[k2];
						anIntArray441[k8] = j10;
						if(model2.anIntArray293[k2] > anInt442)
							anIntArray441[k8] += (model2.anIntArray293[k2] - anInt442) / anInt443;
						k8++;
					} else {
						int k9;
						if(k11 == 0)
							k9 = ai3[l10 - 1];
						else
							k9 = ai3[k11 - 1];
						if(model2.anIntArray293[k9] >= anInt428) {
							int k7 = model2.anIntArray293[k2] - model2.anIntArray293[k9];
							int i5 = model2.anIntArray291[k2] - ((model2.anIntArray291[k2] - model2.anIntArray291[k9]) * (model2.anIntArray293[k2] - anInt428)) / k7;
							int j6 = model2.anIntArray292[k2] - ((model2.anIntArray292[k2] - model2.anIntArray292[k9]) * (model2.anIntArray293[k2] - anInt428)) / k7;
							anIntArray439[k8] = (i5 << anInt427) / anInt428;
							anIntArray440[k8] = (j6 << anInt427) / anInt428;
							anIntArray441[k8] = j10;
							k8++;
						}
						if(k11 == l10 - 1)
							k9 = ai3[0];
						else
							k9 = ai3[k11 + 1];
						if(model2.anIntArray293[k9] >= anInt428) {
							int l7 = model2.anIntArray293[k2] - model2.anIntArray293[k9];
							int j5 = model2.anIntArray291[k2] - ((model2.anIntArray291[k2] - model2.anIntArray291[k9]) * (model2.anIntArray293[k2] - anInt428)) / l7;
							int k6 = model2.anIntArray292[k2] - ((model2.anIntArray292[k2] - model2.anIntArray292[k9]) * (model2.anIntArray293[k2] - anInt428)) / l7;
							anIntArray439[k8] = (j5 << anInt427) / anInt428;
							anIntArray440[k8] = (k6 << anInt427) / anInt428;
							anIntArray441[k8] = j10;
							k8++;
						}
					}
				}

				for(int i12 = 0; i12 < l10; i12++) {
					if(anIntArray441[i12] < 0)
						anIntArray441[i12] = 0;
					else
					if(anIntArray441[i12] > 255)
						anIntArray441[i12] = 255;
					if(polygon.anInt366 >= 0)
						if(anIntArray386[polygon.anInt366] == 1)
							anIntArray441[i12] <<= 9;
						else
							anIntArray441[i12] <<= 6;
				}

				method273(0, 0, 0, 0, k8, anIntArray439, anIntArray440, anIntArray441, model2, l);
				if(anInt407 > anInt406)
					method302(0, 0, l10, anIntArray436, anIntArray437, anIntArray438, polygon.anInt366, model2);
			}
		}

		aBoolean409 = false;
	}

	public void method289(int i) {
		if(i < 0)
			return;
		aLongArray419[i] = aLong420++;
		if(anIntArrayArray387[i] != null)
			return;
		if(anIntArray386[i] == 0) {
			for(int j = 0; j < anIntArrayArray421.length; j++)
				if(anIntArrayArray421[j] == null) {
					anIntArrayArray421[j] = new int[16384];
					anIntArrayArray387[i] = anIntArrayArray421[j];
					method264(i);
					return;
				}

			long l = 1L << 30;
			int i1 = 0;
			for(int k1 = 0; k1 < anInt418; k1++)
				if(k1 != i && anIntArray386[k1] == 0 && anIntArrayArray387[k1] != null && aLongArray419[k1] < l) {
					l = aLongArray419[k1];
					i1 = k1;
				}

			anIntArrayArray387[i] = anIntArrayArray387[i1];
			anIntArrayArray387[i1] = null;
			method264(i);
			return;
		}
		for(int k = 0; k < anIntArrayArray422.length; k++)
			if(anIntArrayArray422[k] == null) {
				anIntArrayArray422[k] = new int[0x10000];
				anIntArrayArray387[i] = anIntArrayArray422[k];
				method264(i);
				return;
			}

		long l1 = 1L << 30;
		int j1 = 0;
		for(int i2 = 0; i2 < anInt418; i2++)
			if(i2 != i && anIntArray386[i2] == 1 && anIntArrayArray387[i2] != null && aLongArray419[i2] < l1) {
				l1 = aLongArray419[i2];
				j1 = i2;
			}

		anIntArrayArray387[i] = anIntArrayArray387[j1];
		anIntArrayArray387[j1] = null;
		method264(i);
	}

	public int method290(int i, int j, int k, int l, int i1, int j1, int k1) {
		anIntArray434[anInt391] = i;
		anIntArray444[anInt391] = j;
		anIntArray445[anInt391] = k;
		anIntArray446[anInt391] = l;
		anIntArray431[anInt391] = i1;
		anIntArray432[anInt391] = j1;
		anIntArray435[anInt391] = 0;
		int l1 = aModel392.method194(j, k, l);
		int i2 = aModel392.method194(j, k - j1, l);
		int[] ai = {
			l1, i2
		};
		aModel392.method184(2, ai, 0, 0);
		aModel392.anIntArray265[anInt391] = k1;
		aModel392.aByteArray296[anInt391++] = 0;
		return anInt391 - 1;
	}

	private boolean method291(Polygon polygon, Polygon polygon1) {
		if(polygon.anInt353 >= polygon1.anInt355)
			return true;
		if(polygon1.anInt353 >= polygon.anInt355)
			return true;
		if(polygon.anInt354 >= polygon1.anInt356)
			return true;
		if(polygon1.anInt354 >= polygon.anInt356)
			return true;
		if(polygon.anInt357 >= polygon1.anInt358)
			return true;
		if(polygon1.anInt357 > polygon.anInt358)
			return false;
		Model model = polygon.aModel359;
		Model model1 = polygon1.aModel359;
		int i = polygon.anInt360;
		int j = polygon1.anInt360;
		int[] ai = model.anIntArrayArray245[i];
		int[] ai1 = model1.anIntArrayArray245[j];
		int k = model.anIntArray244[i];
		int l = model1.anIntArray244[j];
		int k2 = model1.anIntArray291[ai1[0]];
		int l2 = model1.anIntArray292[ai1[0]];
		int i3 = model1.anIntArray293[ai1[0]];
		int j3 = polygon1.anInt362;
		int k3 = polygon1.anInt363;
		int l3 = polygon1.anInt364;
		int i4 = model1.anIntArray253[j];
		int j4 = polygon1.anInt365;
		boolean flag = false;
		for(int k4 = 0; k4 < k; k4++) {
			int i1 = ai[k4];
			int i2 = (k2 - model.anIntArray291[i1]) * j3 + (l2 - model.anIntArray292[i1]) * k3 + (i3 - model.anIntArray293[i1]) * l3;
			if((i2 >= -i4 || j4 >= 0) && (i2 <= i4 || j4 <= 0))
				continue;
			flag = true;
			break;
		}

		if(!flag)
			return true;
		k2 = model.anIntArray291[ai[0]];
		l2 = model.anIntArray292[ai[0]];
		i3 = model.anIntArray293[ai[0]];
		j3 = polygon.anInt362;
		k3 = polygon.anInt363;
		l3 = polygon.anInt364;
		i4 = model.anIntArray253[i];
		j4 = polygon.anInt365;
		flag = false;
		for(int l4 = 0; l4 < l; l4++) {
			int j1 = ai1[l4];
			int j2 = (k2 - model1.anIntArray291[j1]) * j3 + (l2 - model1.anIntArray292[j1]) * k3 + (i3 - model1.anIntArray293[j1]) * l3;
			if((j2 >= -i4 || j4 <= 0) && (j2 <= i4 || j4 >= 0))
				continue;
			flag = true;
			break;
		}

		if(!flag)
			return true;
		int[] ai2;
		int[] ai3;
		if(k == 2) {
			ai2 = new int[4];
			ai3 = new int[4];
			int i5 = ai[0];
			int k1 = ai[1];
			ai2[0] = model.anIntArray289[i5] - 20;
			ai2[1] = model.anIntArray289[k1] - 20;
			ai2[2] = model.anIntArray289[k1] + 20;
			ai2[3] = model.anIntArray289[i5] + 20;
			ai3[0] = ai3[3] = model.anIntArray290[i5];
			ai3[1] = ai3[2] = model.anIntArray290[k1];
		} else {
			ai2 = new int[k];
			ai3 = new int[k];
			for(int j5 = 0; j5 < k; j5++) {
				int i6 = ai[j5];
				ai2[j5] = model.anIntArray289[i6];
				ai3[j5] = model.anIntArray290[i6];
			}

		}
		int[] ai4;
		int[] ai5;
		if(l == 2) {
			ai4 = new int[4];
			ai5 = new int[4];
			int k5 = ai1[0];
			int l1 = ai1[1];
			ai4[0] = model1.anIntArray289[k5] - 20;
			ai4[1] = model1.anIntArray289[l1] - 20;
			ai4[2] = model1.anIntArray289[l1] + 20;
			ai4[3] = model1.anIntArray289[k5] + 20;
			ai5[0] = ai5[3] = model1.anIntArray290[k5];
			ai5[1] = ai5[2] = model1.anIntArray290[l1];
		} else {
			ai4 = new int[l];
			ai5 = new int[l];
			for(int l5 = 0; l5 < l; l5++) {
				int j6 = ai1[l5];
				ai4[l5] = model1.anIntArray289[j6];
				ai5[l5] = model1.anIntArray290[j6];
			}

		}
		return !method266(ai2, ai3, ai4, ai5);
	}

	public void method292(int i, int j, int k, int l, int i1, int j1) {
		anInt425 = k;
		anInt405 = l;
		anInt417 = i;
		anInt404 = j;
		anInt447 = i1;
		anInt427 = j1;
		aScanlineArray408 = new Scanline[l + j];
		for(int k1 = 0; k1 < l + j; k1++)
			aScanlineArray408[k1] = new Scanline();

	}

	public void method293(int i, int j) {
		anIntArray435[i] = j;
	}

	private static void method294(int[] ai, int[] ai1, int i, int j, int k, int l, int i1, int j1,
                                  int k1, int l1, int i2, int j2, int k2, int l2) {
		if(i2 <= 0)
			return;
		int i3 = 0;
		int j3 = 0;
		l2 <<= 2;
		if(i1 != 0) {
			i3 = k / i1 << 6;
			j3 = l / i1 << 6;
		}
		if(i3 < 0)
			i3 = 0;
		else
		if(i3 > 4032)
			i3 = 4032;
		for(int i4 = i2; i4 > 0; i4 -= 16) {
			k += j1;
			l += k1;
			i1 += l1;
			i = i3;
			j = j3;
			if(i1 != 0) {
				i3 = k / i1 << 6;
				j3 = l / i1 << 6;
			}
			if(i3 < 0)
				i3 = 0;
			else
			if(i3 > 4032)
				i3 = 4032;
			int k3 = i3 - i >> 4;
			int l3 = j3 - j >> 4;
			int j4 = k2 >> 20;
			i += k2 & 0xc0000;
			k2 += l2;
			if(i4 < 16) {
				for(int k4 = 0; k4 < i4; k4++) {
					ai[j2++] = ai1[(j & 0xfc0) + (i >> 6)] >>> j4;
					i += k3;
					j += l3;
					if((k4 & 3) == 3) {
						i = (i & 0xfff) + (k2 & 0xc0000);
						j4 = k2 >> 20;
						k2 += l2;
					}
				}

			} else {
				ai[j2++] = ai1[(j & 0xfc0) + (i >> 6)] >>> j4;
				i += k3;
				j += l3;
				ai[j2++] = ai1[(j & 0xfc0) + (i >> 6)] >>> j4;
				i += k3;
				j += l3;
				ai[j2++] = ai1[(j & 0xfc0) + (i >> 6)] >>> j4;
				i += k3;
				j += l3;
				ai[j2++] = ai1[(j & 0xfc0) + (i >> 6)] >>> j4;
				i += k3;
				j += l3;
				i = (i & 0xfff) + (k2 & 0xc0000);
				j4 = k2 >> 20;
				k2 += l2;
				ai[j2++] = ai1[(j & 0xfc0) + (i >> 6)] >>> j4;
				i += k3;
				j += l3;
				ai[j2++] = ai1[(j & 0xfc0) + (i >> 6)] >>> j4;
				i += k3;
				j += l3;
				ai[j2++] = ai1[(j & 0xfc0) + (i >> 6)] >>> j4;
				i += k3;
				j += l3;
				ai[j2++] = ai1[(j & 0xfc0) + (i >> 6)] >>> j4;
				i += k3;
				j += l3;
				i = (i & 0xfff) + (k2 & 0xc0000);
				j4 = k2 >> 20;
				k2 += l2;
				ai[j2++] = ai1[(j & 0xfc0) + (i >> 6)] >>> j4;
				i += k3;
				j += l3;
				ai[j2++] = ai1[(j & 0xfc0) + (i >> 6)] >>> j4;
				i += k3;
				j += l3;
				ai[j2++] = ai1[(j & 0xfc0) + (i >> 6)] >>> j4;
				i += k3;
				j += l3;
				ai[j2++] = ai1[(j & 0xfc0) + (i >> 6)] >>> j4;
				i += k3;
				j += l3;
				i = (i & 0xfff) + (k2 & 0xc0000);
				j4 = k2 >> 20;
				k2 += l2;
				ai[j2++] = ai1[(j & 0xfc0) + (i >> 6)] >>> j4;
				i += k3;
				j += l3;
				ai[j2++] = ai1[(j & 0xfc0) + (i >> 6)] >>> j4;
				i += k3;
				j += l3;
				ai[j2++] = ai1[(j & 0xfc0) + (i >> 6)] >>> j4;
				i += k3;
				j += l3;
				ai[j2++] = ai1[(j & 0xfc0) + (i >> 6)] >>> j4;
			}
		}

	}

	private static void method295(int[] ai, int i, int j, int k, int[] ai1, int l, int i1, int j1,
                                  int k1, int l1, int i2, int j2, int k2, int l2, int i3) {
		if(j2 <= 0)
			return;
		int j3 = 0;
		int k3 = 0;
		i3 <<= 2;
		if(j1 != 0) {
			j3 = l / j1 << 6;
			k3 = i1 / j1 << 6;
		}
		if(j3 < 0)
			j3 = 0;
		else
		if(j3 > 4032)
			j3 = 4032;
		for(int j4 = j2; j4 > 0; j4 -= 16) {
			l += k1;
			i1 += l1;
			j1 += i2;
			j = j3;
			k = k3;
			if(j1 != 0) {
				j3 = l / j1 << 6;
				k3 = i1 / j1 << 6;
			}
			if(j3 < 0)
				j3 = 0;
			else
			if(j3 > 4032)
				j3 = 4032;
			int l3 = j3 - j >> 4;
			int i4 = k3 - k >> 4;
			int k4 = l2 >> 20;
			j += l2 & 0xc0000;
			l2 += i3;
			if(j4 < 16) {
				for(int l4 = 0; l4 < j4; l4++) {
					if((i = ai1[(k & 0xfc0) + (j >> 6)] >>> k4) != 0)
						ai[k2] = i;
					k2++;
					j += l3;
					k += i4;
					if((l4 & 3) == 3) {
						j = (j & 0xfff) + (l2 & 0xc0000);
						k4 = l2 >> 20;
						l2 += i3;
					}
				}

			} else {
				if((i = ai1[(k & 0xfc0) + (j >> 6)] >>> k4) != 0)
					ai[k2] = i;
				k2++;
				j += l3;
				k += i4;
				if((i = ai1[(k & 0xfc0) + (j >> 6)] >>> k4) != 0)
					ai[k2] = i;
				k2++;
				j += l3;
				k += i4;
				if((i = ai1[(k & 0xfc0) + (j >> 6)] >>> k4) != 0)
					ai[k2] = i;
				k2++;
				j += l3;
				k += i4;
				if((i = ai1[(k & 0xfc0) + (j >> 6)] >>> k4) != 0)
					ai[k2] = i;
				k2++;
				j += l3;
				k += i4;
				j = (j & 0xfff) + (l2 & 0xc0000);
				k4 = l2 >> 20;
				l2 += i3;
				if((i = ai1[(k & 0xfc0) + (j >> 6)] >>> k4) != 0)
					ai[k2] = i;
				k2++;
				j += l3;
				k += i4;
				if((i = ai1[(k & 0xfc0) + (j >> 6)] >>> k4) != 0)
					ai[k2] = i;
				k2++;
				j += l3;
				k += i4;
				if((i = ai1[(k & 0xfc0) + (j >> 6)] >>> k4) != 0)
					ai[k2] = i;
				k2++;
				j += l3;
				k += i4;
				if((i = ai1[(k & 0xfc0) + (j >> 6)] >>> k4) != 0)
					ai[k2] = i;
				k2++;
				j += l3;
				k += i4;
				j = (j & 0xfff) + (l2 & 0xc0000);
				k4 = l2 >> 20;
				l2 += i3;
				if((i = ai1[(k & 0xfc0) + (j >> 6)] >>> k4) != 0)
					ai[k2] = i;
				k2++;
				j += l3;
				k += i4;
				if((i = ai1[(k & 0xfc0) + (j >> 6)] >>> k4) != 0)
					ai[k2] = i;
				k2++;
				j += l3;
				k += i4;
				if((i = ai1[(k & 0xfc0) + (j >> 6)] >>> k4) != 0)
					ai[k2] = i;
				k2++;
				j += l3;
				k += i4;
				if((i = ai1[(k & 0xfc0) + (j >> 6)] >>> k4) != 0)
					ai[k2] = i;
				k2++;
				j += l3;
				k += i4;
				j = (j & 0xfff) + (l2 & 0xc0000);
				k4 = l2 >> 20;
				l2 += i3;
				if((i = ai1[(k & 0xfc0) + (j >> 6)] >>> k4) != 0)
					ai[k2] = i;
				k2++;
				j += l3;
				k += i4;
				if((i = ai1[(k & 0xfc0) + (j >> 6)] >>> k4) != 0)
					ai[k2] = i;
				k2++;
				j += l3;
				k += i4;
				if((i = ai1[(k & 0xfc0) + (j >> 6)] >>> k4) != 0)
					ai[k2] = i;
				k2++;
				j += l3;
				k += i4;
				if((i = ai1[(k & 0xfc0) + (j >> 6)] >>> k4) != 0)
					ai[k2] = i;
				k2++;
			}
		}

	}

	private boolean method296(Polygon polygon, Polygon polygon1) {
		Model model = polygon.aModel359;
		Model model1 = polygon1.aModel359;
		int i = polygon.anInt360;
		int j = polygon1.anInt360;
		int[] ai = model.anIntArrayArray245[i];
		int[] ai1 = model1.anIntArrayArray245[j];
		int k = model.anIntArray244[i];
		int l = model1.anIntArray244[j];
		int i2 = model1.anIntArray291[ai1[0]];
		int j2 = model1.anIntArray292[ai1[0]];
		int k2 = model1.anIntArray293[ai1[0]];
		int l2 = polygon1.anInt362;
		int i3 = polygon1.anInt363;
		int j3 = polygon1.anInt364;
		int k3 = model1.anIntArray253[j];
		int l3 = polygon1.anInt365;
		boolean flag = false;
		for(int i4 = 0; i4 < k; i4++) {
			int i1 = ai[i4];
			int k1 = (i2 - model.anIntArray291[i1]) * l2 + (j2 - model.anIntArray292[i1]) * i3 + (k2 - model.anIntArray293[i1]) * j3;
			if((k1 >= -k3 || l3 >= 0) && (k1 <= k3 || l3 <= 0))
				continue;
			flag = true;
			break;
		}

		if(!flag)
			return true;
		i2 = model.anIntArray291[ai[0]];
		j2 = model.anIntArray292[ai[0]];
		k2 = model.anIntArray293[ai[0]];
		l2 = polygon.anInt362;
		i3 = polygon.anInt363;
		j3 = polygon.anInt364;
		k3 = model.anIntArray253[i];
		l3 = polygon.anInt365;
		flag = false;
		for(int j4 = 0; j4 < l; j4++) {
			int j1 = ai1[j4];
			int l1 = (i2 - model1.anIntArray291[j1]) * l2 + (j2 - model1.anIntArray292[j1]) * i3 + (k2 - model1.anIntArray293[j1]) * j3;
			if((l1 >= -k3 || l3 <= 0) && (l1 <= k3 || l3 >= 0))
				continue;
			flag = true;
			break;
		}

		return !flag;
	}

	public void method297(int i, int j, int k, int l, int i1) {
		if(k == 0 && l == 0 && i1 == 0)
			k = 32;
		for(int j1 = 0; j1 < anInt402; j1++)
			aModelArray401[j1].method199(i, j, k, l, i1);

	}

	public int method298() {
		return anInt410;
	}

	public Scene(Surface surface, int i, int j, int k) {
		anInt452 = 50;
		anIntArray449 = new int[anInt452];
		anIntArrayArray450 = new int[anInt452][256];
		anInt428 = 5;
		anInt426 = 1000;
		anInt430 = 1000;
		anInt443 = 20;
		anInt442 = 10;
		aBoolean453 = false;
		aDouble375 = 1.1000000000000001D;
		anInt376 = 1;
		aBoolean409 = false;
		anInt411 = 100;
		aModelArray414 = new Model[anInt411];
		anIntArray415 = new int[anInt411];
		anInt447 = 512;
		anInt425 = 256;
		anInt405 = 192;
		anInt417 = 256;
		anInt404 = 256;
		anInt427 = 8;
		anInt454 = 4;
		anIntArray439 = new int[40];
		anIntArray440 = new int[40];
		anIntArray441 = new int[40];
		anIntArray436 = new int[40];
		anIntArray437 = new int[40];
		anIntArray438 = new int[40];
		aBoolean424 = false;
		aSurface423 = surface;
		anInt425 = surface.anInt320 / 2;
		anInt405 = surface.anInt323 / 2;
		anIntArray448 = surface.anIntArray322;
		anInt402 = 0;
		anInt455 = i;
		aModelArray401 = new Model[anInt455];
		anIntArray403 = new int[anInt455];
		anInt429 = 0;
		aPolygonArray416 = new Polygon[j];
		for(int l = 0; l < j; l++)
			aPolygonArray416[l] = new Polygon();

		anInt391 = 0;
		aModel392 = new Model(k * 2, k);
		anIntArray434 = new int[k];
		anIntArray431 = new int[k];
		anIntArray432 = new int[k];
		anIntArray444 = new int[k];
		anIntArray445 = new int[k];
		anIntArray446 = new int[k];
		anIntArray435 = new int[k];
		if(aByteArray377 == null)
			aByteArray377 = new byte[17691];
		anInt383 = 0;
		anInt384 = 0;
		anInt385 = 0;
		anInt379 = 0;
		anInt380 = 0;
		anInt381 = 0;
		for(int i1 = 0; i1 < 256; i1++) {
			anIntArray374[i1] = (int)(Math.sin((double)i1 * 0.02454369D) * 32768D);
			anIntArray374[i1 + 256] = (int)(Math.cos((double)i1 * 0.02454369D) * 32768D);
		}

		for(int j1 = 0; j1 < 1024; j1++) {
			anIntArray382[j1] = (int)(Math.sin((double)j1 * 0.00613592315D) * 32768D);
			anIntArray382[j1 + 1024] = (int)(Math.cos((double)j1 * 0.00613592315D) * 32768D);
		}

		if(!DataUtils.aBoolean540);
	}

	public void method299(int i, byte[] abyte0, int[] ai, int j) {
		aByteArrayArray389[i] = abyte0;
		anIntArrayArray388[i] = ai;
		anIntArray386[i] = j;
		aLongArray419[i] = 0L;
		aBooleanArray390[i] = false;
		anIntArrayArray387[i] = null;
		method289(i);
	}

	public boolean method300(int i, int j, int k, boolean flag) {
		if(flag && i <= k || i < k) {
			if(j > k)
				return true;
			return !flag;
		}
		if(j < k)
			return true;
		else
			return flag;
	}

	public Model[] method301() {
		return aModelArray414;
	}

	private void method302(int i, int j, int k, int[] ai, int[] ai1, int[] ai2, int l,
                           Model model) {
		if(l == -2)
			return;
		if(l >= 0) {
			if(l >= anInt418)
				l = 0;
			method289(l);
			int i1 = ai[0];
			int k1 = ai1[0];
			int j2 = ai2[0];
			int i3 = i1 - ai[1];
			int k3 = k1 - ai1[1];
			int i4 = j2 - ai2[1];
			k--;
			int i6 = ai[k] - i1;
			int j7 = ai1[k] - k1;
			int k8 = ai2[k] - j2;
			if(anIntArray386[l] == 1) {
				int l9 = i6 * k1 - j7 * i1 << 12;
				int k10 = j7 * j2 - k8 * k1 << (5 - anInt427) + 7 + 4;
				int i11 = k8 * i1 - i6 * j2 << (5 - anInt427) + 7;
				int k11 = i3 * k1 - k3 * i1 << 12;
				int i12 = k3 * j2 - i4 * k1 << (5 - anInt427) + 7 + 4;
				int k12 = i4 * i1 - i3 * j2 << (5 - anInt427) + 7;
				int i13 = k3 * i6 - i3 * j7 << 5;
				int k13 = i4 * j7 - k3 * k8 << (5 - anInt427) + 4;
				int i14 = i3 * k8 - i4 * i6 >> anInt427 - 5;
				int k14 = k10 >> 4;
				int i15 = i12 >> 4;
				int k15 = k13 >> 4;
				int i16 = anInt406 - anInt404;
				int k16 = anInt447;
				int i17 = anInt417 + anInt406 * k16;
				byte byte1 = 1;
				l9 += i11 * i16;
				k11 += k12 * i16;
				i13 += i14 * i16;
				if(aBoolean424) {
					if((anInt406 & 1) == 1) {
						anInt406++;
						l9 += i11;
						k11 += k12;
						i13 += i14;
						i17 += k16;
					}
					i11 <<= 1;
					k12 <<= 1;
					i14 <<= 1;
					k16 <<= 1;
					byte1 = 2;
				}
				if(model.aBoolean227) {
					for(i = anInt406; i < anInt407; i += byte1) {
						Scanline scanline3 = aScanlineArray408[i];
						j = scanline3.anInt370 >> 8;
						int k17 = scanline3.anInt371 >> 8;
						int k20 = k17 - j;
						if(k20 <= 0) {
							l9 += i11;
							k11 += k12;
							i13 += i14;
							i17 += k16;
						} else {
							int i22 = scanline3.anInt372;
							int k23 = (scanline3.anInt373 - i22) / k20;
							if(j < -anInt425) {
								i22 += (-anInt425 - j) * k23;
								j = -anInt425;
								k20 = k17 - j;
							}
							if(k17 > anInt425) {
								int l17 = anInt425;
								k20 = l17 - j;
							}
							method284(anIntArray448, anIntArrayArray387[l], 0, 0, l9 + k14 * j, k11 + i15 * j, i13 + k15 * j, k10, i12, k13, k20, i17 + j, i22, k23 << 2);
							l9 += i11;
							k11 += k12;
							i13 += i14;
							i17 += k16;
						}
					}

					return;
				}
				if(!aBooleanArray390[l]) {
					for(i = anInt406; i < anInt407; i += byte1) {
						Scanline scanline4 = aScanlineArray408[i];
						j = scanline4.anInt370 >> 8;
						int i18 = scanline4.anInt371 >> 8;
						int l20 = i18 - j;
						if(l20 <= 0) {
							l9 += i11;
							k11 += k12;
							i13 += i14;
							i17 += k16;
						} else {
							int j22 = scanline4.anInt372;
							int l23 = (scanline4.anInt373 - j22) / l20;
							if(j < -anInt425) {
								j22 += (-anInt425 - j) * l23;
								j = -anInt425;
								l20 = i18 - j;
							}
							if(i18 > anInt425) {
								int j18 = anInt425;
								l20 = j18 - j;
							}
							method283(anIntArray448, anIntArrayArray387[l], 0, 0, l9 + k14 * j, k11 + i15 * j, i13 + k15 * j, k10, i12, k13, l20, i17 + j, j22, l23 << 2);
							l9 += i11;
							k11 += k12;
							i13 += i14;
							i17 += k16;
						}
					}

					return;
				}
				for(i = anInt406; i < anInt407; i += byte1) {
					Scanline scanline5 = aScanlineArray408[i];
					j = scanline5.anInt370 >> 8;
					int k18 = scanline5.anInt371 >> 8;
					int i21 = k18 - j;
					if(i21 <= 0) {
						l9 += i11;
						k11 += k12;
						i13 += i14;
						i17 += k16;
					} else {
						int k22 = scanline5.anInt372;
						int i24 = (scanline5.anInt373 - k22) / i21;
						if(j < -anInt425) {
							k22 += (-anInt425 - j) * i24;
							j = -anInt425;
							i21 = k18 - j;
						}
						if(k18 > anInt425) {
							int l18 = anInt425;
							i21 = l18 - j;
						}
						method280(anIntArray448, 0, 0, 0, anIntArrayArray387[l], l9 + k14 * j, k11 + i15 * j, i13 + k15 * j, k10, i12, k13, i21, i17 + j, k22, i24);
						l9 += i11;
						k11 += k12;
						i13 += i14;
						i17 += k16;
					}
				}

				return;
			}
			int i10 = i6 * k1 - j7 * i1 << 11;
			int l10 = j7 * j2 - k8 * k1 << (5 - anInt427) + 6 + 4;
			int j11 = k8 * i1 - i6 * j2 << (5 - anInt427) + 6;
			int l11 = i3 * k1 - k3 * i1 << 11;
			int j12 = k3 * j2 - i4 * k1 << (5 - anInt427) + 6 + 4;
			int l12 = i4 * i1 - i3 * j2 << (5 - anInt427) + 6;
			int j13 = k3 * i6 - i3 * j7 << 5;
			int l13 = i4 * j7 - k3 * k8 << (5 - anInt427) + 4;
			int j14 = i3 * k8 - i4 * i6 >> anInt427 - 5;
			int l14 = l10 >> 4;
			int j15 = j12 >> 4;
			int l15 = l13 >> 4;
			int j16 = anInt406 - anInt404;
			int l16 = anInt447;
			int j17 = anInt417 + anInt406 * l16;
			byte byte2 = 1;
			i10 += j11 * j16;
			l11 += l12 * j16;
			j13 += j14 * j16;
			if(aBoolean424) {
				if((anInt406 & 1) == 1) {
					anInt406++;
					i10 += j11;
					l11 += l12;
					j13 += j14;
					j17 += l16;
				}
				j11 <<= 1;
				l12 <<= 1;
				j14 <<= 1;
				l16 <<= 1;
				byte2 = 2;
			}
			if(model.aBoolean227) {
				for(i = anInt406; i < anInt407; i += byte2) {
					Scanline scanline6 = aScanlineArray408[i];
					j = scanline6.anInt370 >> 8;
					int i19 = scanline6.anInt371 >> 8;
					int j21 = i19 - j;
					if(j21 <= 0) {
						i10 += j11;
						l11 += l12;
						j13 += j14;
						j17 += l16;
					} else {
						int l22 = scanline6.anInt372;
						int j24 = (scanline6.anInt373 - l22) / j21;
						if(j < -anInt425) {
							l22 += (-anInt425 - j) * j24;
							j = -anInt425;
							j21 = i19 - j;
						}
						if(i19 > anInt425) {
							int j19 = anInt425;
							j21 = j19 - j;
						}
						method279(anIntArray448, anIntArrayArray387[l], 0, 0, i10 + l14 * j, l11 + j15 * j, j13 + l15 * j, l10, j12, l13, j21, j17 + j, l22, j24);
						i10 += j11;
						l11 += l12;
						j13 += j14;
						j17 += l16;
					}
				}

				return;
			}
			if(!aBooleanArray390[l]) {
				for(i = anInt406; i < anInt407; i += byte2) {
					Scanline scanline7 = aScanlineArray408[i];
					j = scanline7.anInt370 >> 8;
					int k19 = scanline7.anInt371 >> 8;
					int k21 = k19 - j;
					if(k21 <= 0) {
						i10 += j11;
						l11 += l12;
						j13 += j14;
						j17 += l16;
					} else {
						int i23 = scanline7.anInt372;
						int k24 = (scanline7.anInt373 - i23) / k21;
						if(j < -anInt425) {
							i23 += (-anInt425 - j) * k24;
							j = -anInt425;
							k21 = k19 - j;
						}
						if(k19 > anInt425) {
							int l19 = anInt425;
							k21 = l19 - j;
						}
						method294(anIntArray448, anIntArrayArray387[l], 0, 0, i10 + l14 * j, l11 + j15 * j, j13 + l15 * j, l10, j12, l13, k21, j17 + j, i23, k24);
						i10 += j11;
						l11 += l12;
						j13 += j14;
						j17 += l16;
					}
				}

				return;
			}
			for(i = anInt406; i < anInt407; i += byte2) {
				Scanline scanline8 = aScanlineArray408[i];
				j = scanline8.anInt370 >> 8;
				int i20 = scanline8.anInt371 >> 8;
				int l21 = i20 - j;
				if(l21 <= 0) {
					i10 += j11;
					l11 += l12;
					j13 += j14;
					j17 += l16;
				} else {
					int j23 = scanline8.anInt372;
					int l24 = (scanline8.anInt373 - j23) / l21;
					if(j < -anInt425) {
						j23 += (-anInt425 - j) * l24;
						j = -anInt425;
						l21 = i20 - j;
					}
					if(i20 > anInt425) {
						int j20 = anInt425;
						l21 = j20 - j;
					}
					method295(anIntArray448, 0, 0, 0, anIntArrayArray387[l], i10 + l14 * j, l11 + j15 * j, j13 + l15 * j, l10, j12, l13, l21, j17 + j, j23, l24);
					i10 += j11;
					l11 += l12;
					j13 += j14;
					j17 += l16;
				}
			}

			return;
		}
		for(int j1 = 0; j1 < anInt452; j1++) {
			if(anIntArray449[j1] == l) {
				anIntArray451 = anIntArrayArray450[j1];
				break;
			}
			if(j1 == anInt452 - 1) {
				int l1 = (int)(Math.random() * (double)anInt452);
				anIntArray449[l1] = l;
				l = -1 - l;
				int k2 = (l >> 10 & 0x1f) * 8;
				int j3 = (l >> 5 & 0x1f) * 8;
				int l3 = (l & 0x1f) * 8;
				for(int j4 = 0; j4 < 256; j4++) {
					int j6 = j4 * j4;
					int k7 = (k2 * j6) / 0x10000;
					int l8 = (j3 * j6) / 0x10000;
					int j10 = (l3 * j6) / 0x10000;
					anIntArrayArray450[l1][255 - j4] = (k7 << 16) + (l8 << 8) + j10;
				}

				anIntArray451 = anIntArrayArray450[l1];
			}
		}

		int i2 = anInt447;
		int l2 = anInt417 + anInt406 * i2;
		byte byte0 = 1;
		if(aBoolean424) {
			if((anInt406 & 1) == 1) {
				anInt406++;
				l2 += i2;
			}
			i2 <<= 1;
			byte0 = 2;
		}
		if(model.aBoolean267) {
			for(i = anInt406; i < anInt407; i += byte0) {
				Scanline scanline = aScanlineArray408[i];
				j = scanline.anInt370 >> 8;
				int k4 = scanline.anInt371 >> 8;
				int k6 = k4 - j;
				if(k6 <= 0) {
					l2 += i2;
				} else {
					int l7 = scanline.anInt372;
					int i9 = (scanline.anInt373 - l7) / k6;
					if(j < -anInt425) {
						l7 += (-anInt425 - j) * i9;
						j = -anInt425;
						k6 = k4 - j;
					}
					if(k4 > anInt425) {
						int l4 = anInt425;
						k6 = l4 - j;
					}
					method281(anIntArray448, -k6, l2 + j, 0, anIntArray451, l7, i9);
					l2 += i2;
				}
			}

			return;
		}
		if(aBoolean453) {
			for(i = anInt406; i < anInt407; i += byte0) {
				Scanline scanline1 = aScanlineArray408[i];
				j = scanline1.anInt370 >> 8;
				int i5 = scanline1.anInt371 >> 8;
				int l6 = i5 - j;
				if(l6 <= 0) {
					l2 += i2;
				} else {
					int i8 = scanline1.anInt372;
					int j9 = (scanline1.anInt373 - i8) / l6;
					if(j < -anInt425) {
						i8 += (-anInt425 - j) * j9;
						j = -anInt425;
						l6 = i5 - j;
					}
					if(i5 > anInt425) {
						int j5 = anInt425;
						l6 = j5 - j;
					}
					method278(anIntArray448, -l6, l2 + j, 0, anIntArray451, i8, j9);
					l2 += i2;
				}
			}

			return;
		}
		for(i = anInt406; i < anInt407; i += byte0) {
			Scanline scanline2 = aScanlineArray408[i];
			j = scanline2.anInt370 >> 8;
			int k5 = scanline2.anInt371 >> 8;
			int i7 = k5 - j;
			if(i7 <= 0) {
				l2 += i2;
			} else {
				int j8 = scanline2.anInt372;
				int k9 = (scanline2.anInt373 - j8) / i7;
				if(j < -anInt425) {
					j8 += (-anInt425 - j) * k9;
					j = -anInt425;
					i7 = k5 - j;
				}
				if(k5 > anInt425) {
					int l5 = anInt425;
					i7 = l5 - j;
				}
				method282(anIntArray448, -i7, l2 + j, 0, anIntArray451, j8, k9);
				l2 += i2;
			}
		}

	}

	public boolean method303(int i, int j, int k, int l, boolean flag) {
		if(flag && i <= k || i < k) {
			if(i > l)
				return true;
			if(j > k)
				return true;
			if(j > l)
				return true;
			return !flag;
		}
		if(i < l)
			return true;
		if(j < k)
			return true;
		if(j < l)
			return true;
		else
			return flag;
	}

	private void method304(int i) {
		Polygon polygon = aPolygonArray416[i];
		Model model = polygon.aModel359;
		int j = polygon.anInt360;
		int[] ai = model.anIntArrayArray245[j];
		int k = model.anIntArray244[j];
		int l = model.anIntArray252[j];
		int j1 = model.anIntArray291[ai[0]];
		int k1 = model.anIntArray292[ai[0]];
		int l1 = model.anIntArray293[ai[0]];
		int i2 = model.anIntArray291[ai[1]] - j1;
		int j2 = model.anIntArray292[ai[1]] - k1;
		int k2 = model.anIntArray293[ai[1]] - l1;
		int l2 = model.anIntArray291[ai[2]] - j1;
		int i3 = model.anIntArray292[ai[2]] - k1;
		int j3 = model.anIntArray293[ai[2]] - l1;
		int k3 = j2 * j3 - i3 * k2;
		int l3 = k2 * l2 - j3 * i2;
		int i4 = i2 * i3 - l2 * j2;
		if(l == -1) {
			l = 0;
			for(; k3 > 25000 || l3 > 25000 || i4 > 25000 || k3 < -25000 || l3 < -25000 || i4 < -25000; i4 >>= 1) {
				l++;
				k3 >>= 1;
				l3 >>= 1;
			}

			model.anIntArray252[j] = l;
			model.anIntArray253[j] = (int)((double)anInt454 * Math.sqrt(k3 * k3 + l3 * l3 + i4 * i4));
		} else {
			k3 >>= l;
			l3 >>= l;
			i4 >>= l;
		}
		polygon.anInt365 = j1 * k3 + k1 * l3 + l1 * i4;
		polygon.anInt362 = k3;
		polygon.anInt363 = l3;
		polygon.anInt364 = i4;
		int j4 = model.anIntArray293[ai[0]];
		int k4 = j4;
		int l4 = model.anIntArray289[ai[0]];
		int i5 = l4;
		int j5 = model.anIntArray290[ai[0]];
		int k5 = j5;
		for(int l5 = 1; l5 < k; l5++) {
			int i1 = model.anIntArray293[ai[l5]];
			if(i1 > k4)
				k4 = i1;
			else
			if(i1 < j4)
				j4 = i1;
			i1 = model.anIntArray289[ai[l5]];
			if(i1 > i5)
				i5 = i1;
			else
			if(i1 < l4)
				l4 = i1;
			i1 = model.anIntArray290[ai[l5]];
			if(i1 > k5)
				k5 = i1;
			else
			if(i1 < j5)
				j5 = i1;
		}

		polygon.anInt357 = j4;
		polygon.anInt358 = k4;
		polygon.anInt353 = l4;
		polygon.anInt355 = i5;
		polygon.anInt354 = j5;
		polygon.anInt356 = k5;
	}

	public void method305(Model model) {
		if(model == null)
			System.out.println("Warning tried to add null object!");
		if(anInt402 < anInt455) {
			anIntArray403[anInt402] = 0;
			aModelArray401[anInt402++] = model;
		}
	}

	public void method306() {
		method276();
		for(int i = 0; i < anInt402; i++)
			aModelArray401[i] = null;

		anInt402 = 0;
	}

	public int[] method307() {
		return anIntArray415;
	}

	public int method308(int i, int j, int k, int l, int i1) {
		if(l == j)
			return i;
		else
			return i + ((k - i) * (i1 - j)) / (l - j);
	}

	public void method309(int i, int j, int k) {
		if(i == 0 && j == 0 && k == 0)
			i = 32;
		for(int l = 0; l < anInt402; l++)
			aModelArray401[l].method202(i, j, k);

	}

	private static final int[] anIntArray374 = new int[512];
	public double aDouble375;
	public int anInt376;
	private static byte[] aByteArray377;
	private static final int[] anIntArray378 = new int[256];
	private int anInt379;
	private int anInt380;
	private int anInt381;
	public static int[] anIntArray382 = new int[2048];
	private int anInt383;
	private int anInt384;
	private int anInt385;
	int[] anIntArray386;
	int[][] anIntArrayArray387;
	int[][] anIntArrayArray388;
	byte[][] aByteArrayArray389;
	boolean[] aBooleanArray390;
	private int anInt391;
	public Model aModel392;
	int anInt393;
	int anInt394;
	static int anInt395;
	static int anInt396;
	static int anInt397;
	static int anInt398;
	static int anInt399;
	static int anInt400;
	public Model[] aModelArray401;
	public int anInt402;
	private final int[] anIntArray403;
	private int anInt404;
	private int anInt405;
	int anInt406;
	int anInt407;
	Scanline[] aScanlineArray408;
	private boolean aBoolean409;
	private int anInt410;
	private final int anInt411;
	private int anInt412;
	private int anInt413;
	private final Model[] aModelArray414;
	private final int[] anIntArray415;
	private final Polygon[] aPolygonArray416;
	private int anInt417;
	int anInt418;
	long[] aLongArray419;
	private static long aLong420;
	int[][] anIntArrayArray421;
	int[][] anIntArrayArray422;
	Surface aSurface423;
	boolean aBoolean424;
	private int anInt425;
	public int anInt426;
	private int anInt427;
	public int anInt428;
	private int anInt429;
	public int anInt430;
	private final int[] anIntArray431;
	private final int[] anIntArray432;
	public int anInt433;
	private final int[] anIntArray434;
	private final int[] anIntArray435;
	int[] anIntArray436;
	int[] anIntArray437;
	int[] anIntArray438;
	int[] anIntArray439;
	int[] anIntArray440;
	int[] anIntArray441;
	public int anInt442;
	public int anInt443;
	private final int[] anIntArray444;
	private final int[] anIntArray445;
	private final int[] anIntArray446;
	private int anInt447;
	public int[] anIntArray448;
	int[] anIntArray449;
	int[][] anIntArrayArray450;
	int[] anIntArray451;
	int anInt452;
	public boolean aBoolean453;
	private final int anInt454;
	public int anInt455;

}
