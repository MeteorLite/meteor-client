// Decompiled by Jad v1.5.8c. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 


public final class IsaacCipher {

	private final void method310() {
		anInt504 += ++anInt505;
		for(int i = 0; i < 256; i++) {
			int j = anIntArray506[i];
			switch(i & 3) {
			case 0: // '\0'
				anInt507 ^= anInt507 << 13;
				break;

			case 1: // '\001'
				anInt507 ^= anInt507 >>> 6;
				break;

			case 2: // '\002'
				anInt507 ^= anInt507 << 2;
				break;

			case 3: // '\003'
				anInt507 ^= anInt507 >>> 16;
				break;
			}
			anInt507 += anIntArray506[i + 128 & 0xff];
			int k;
			anIntArray506[i] = k = anIntArray506[(j & 0x3fc) >> 2] + anInt507 + anInt504;
			anIntArray508[i] = anInt504 = anIntArray506[(k >> 8 & 0x3fc) >> 2] + j;
		}

	}

	public final int method311() {
		if(anInt509-- == 0) {
			method310();
			anInt509 = 255;
		}
		return anIntArray508[anInt509];
	}

	private final void method312() {
		int i1;
		int j1;
		int k1;
		int l1;
		int i2;
		int j2;
		int k2;
		int l = i1 = j1 = k1 = l1 = i2 = j2 = k2 = 0x9e3779b9;
		for(int i = 0; i < 4; i++) {
			l ^= i1 << 11;
			k1 += l;
			i1 += j1;
			i1 ^= j1 >>> 2;
			l1 += i1;
			j1 += k1;
			j1 ^= k1 << 8;
			i2 += j1;
			k1 += l1;
			k1 ^= l1 >>> 16;
			j2 += k1;
			l1 += i2;
			l1 ^= i2 << 10;
			k2 += l1;
			i2 += j2;
			i2 ^= j2 >>> 4;
			l += i2;
			j2 += k2;
			j2 ^= k2 << 8;
			i1 += j2;
			k2 += l;
			k2 ^= l >>> 9;
			j1 += k2;
			l += i1;
		}

		for(int j = 0; j < 256; j += 8) {
			l += anIntArray508[j];
			i1 += anIntArray508[j + 1];
			j1 += anIntArray508[j + 2];
			k1 += anIntArray508[j + 3];
			l1 += anIntArray508[j + 4];
			i2 += anIntArray508[j + 5];
			j2 += anIntArray508[j + 6];
			k2 += anIntArray508[j + 7];
			l ^= i1 << 11;
			k1 += l;
			i1 += j1;
			i1 ^= j1 >>> 2;
			l1 += i1;
			j1 += k1;
			j1 ^= k1 << 8;
			i2 += j1;
			k1 += l1;
			k1 ^= l1 >>> 16;
			j2 += k1;
			l1 += i2;
			l1 ^= i2 << 10;
			k2 += l1;
			i2 += j2;
			i2 ^= j2 >>> 4;
			l += i2;
			j2 += k2;
			j2 ^= k2 << 8;
			i1 += j2;
			k2 += l;
			k2 ^= l >>> 9;
			j1 += k2;
			l += i1;
			anIntArray506[j] = l;
			anIntArray506[j + 1] = i1;
			anIntArray506[j + 2] = j1;
			anIntArray506[j + 3] = k1;
			anIntArray506[j + 4] = l1;
			anIntArray506[j + 5] = i2;
			anIntArray506[j + 6] = j2;
			anIntArray506[j + 7] = k2;
		}

		for(int k = 0; k < 256; k += 8) {
			l += anIntArray506[k];
			i1 += anIntArray506[k + 1];
			j1 += anIntArray506[k + 2];
			k1 += anIntArray506[k + 3];
			l1 += anIntArray506[k + 4];
			i2 += anIntArray506[k + 5];
			j2 += anIntArray506[k + 6];
			k2 += anIntArray506[k + 7];
			l ^= i1 << 11;
			k1 += l;
			i1 += j1;
			i1 ^= j1 >>> 2;
			l1 += i1;
			j1 += k1;
			j1 ^= k1 << 8;
			i2 += j1;
			k1 += l1;
			k1 ^= l1 >>> 16;
			j2 += k1;
			l1 += i2;
			l1 ^= i2 << 10;
			k2 += l1;
			i2 += j2;
			i2 ^= j2 >>> 4;
			l += i2;
			j2 += k2;
			j2 ^= k2 << 8;
			i1 += j2;
			k2 += l;
			k2 ^= l >>> 9;
			j1 += k2;
			l += i1;
			anIntArray506[k] = l;
			anIntArray506[k + 1] = i1;
			anIntArray506[k + 2] = j1;
			anIntArray506[k + 3] = k1;
			anIntArray506[k + 4] = l1;
			anIntArray506[k + 5] = i2;
			anIntArray506[k + 6] = j2;
			anIntArray506[k + 7] = k2;
		}

		method310();
		anInt509 = 256;
	}

	public IsaacCipher(int ai[]) {
		anIntArray506 = new int[256];
		anIntArray508 = new int[256];
		for(int i = 0; i < ai.length; i++)
			anIntArray508[i] = ai[i];

		method312();
	}

	private int anInt504;
	private int anInt505;
	private int anIntArray506[];
	private int anInt507;
	private int anIntArray508[];
	private int anInt509;
}
