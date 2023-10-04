// Decompiled by Jad v1.5.8c. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

import java.io.PrintStream;

public class BZip2Decompressor {

	private static void method129(BZip2Block bzip2block) {
		byte byte4 = bzip2block.aByte466;
		int i = bzip2block.anInt467;
		int j = bzip2block.anInt476;
		int k = bzip2block.anInt475;
		int ai[] = BZip2Block.anIntArray477;
		int l = bzip2block.anInt474;
		byte abyte0[] = bzip2block.aByteArray461;
		int i1 = bzip2block.anInt462;
		int j1 = bzip2block.anInt463;
		int k1 = j1;
		int l1 = bzip2block.anInt479 + 1;
label0:
		do {
			if(i > 0) {
				do {
					if(j1 == 0)
						break label0;
					if(i == 1)
						break;
					abyte0[i1] = byte4;
					i--;
					i1++;
					j1--;
				} while(true);
				if(j1 == 0) {
					i = 1;
					break;
				}
				abyte0[i1] = byte4;
				i1++;
				j1--;
			}
			boolean flag = true;
			while(flag)  {
				flag = false;
				if(j == l1) {
					i = 0;
					break label0;
				}
				byte4 = (byte)k;
				l = ai[l];
				byte byte0 = (byte)(l & 0xff);
				l >>= 8;
				j++;
				if(byte0 != k) {
					k = byte0;
					if(j1 == 0) {
						i = 1;
					} else {
						abyte0[i1] = byte4;
						i1++;
						j1--;
						flag = true;
						continue;
					}
					break label0;
				}
				if(j != l1)
					continue;
				if(j1 == 0) {
					i = 1;
					break label0;
				}
				abyte0[i1] = byte4;
				i1++;
				j1--;
				flag = true;
			}
			i = 2;
			l = ai[l];
			byte byte1 = (byte)(l & 0xff);
			l >>= 8;
			if(++j != l1)
				if(byte1 != k) {
					k = byte1;
				} else {
					i = 3;
					l = ai[l];
					byte byte2 = (byte)(l & 0xff);
					l >>= 8;
					if(++j != l1)
						if(byte2 != k) {
							k = byte2;
						} else {
							l = ai[l];
							byte byte3 = (byte)(l & 0xff);
							l >>= 8;
							j++;
							i = (byte3 & 0xff) + 4;
							l = ai[l];
							k = (byte)(l & 0xff);
							l >>= 8;
							j++;
						}
				}
		} while(true);
		int i2 = bzip2block.anInt464;
		bzip2block.anInt464 += k1 - j1;
		if(bzip2block.anInt464 < i2)
			bzip2block.anInt465++;
		bzip2block.aByte466 = byte4;
		bzip2block.anInt467 = i;
		bzip2block.anInt476 = j;
		bzip2block.anInt475 = k;
		BZip2Block.anIntArray477 = ai;
		bzip2block.anInt474 = l;
		bzip2block.aByteArray461 = abyte0;
		bzip2block.anInt462 = i1;
		bzip2block.anInt463 = j1;
	}

	private static void method130(int ai[], int ai1[], int ai2[], byte abyte0[], int i, int j, int k) {
		int l = 0;
		for(int i1 = i; i1 <= j; i1++) {
			for(int l2 = 0; l2 < k; l2++)
				if(abyte0[l2] == i1) {
					ai2[l] = l2;
					l++;
				}

		}

		for(int j1 = 0; j1 < 23; j1++)
			ai1[j1] = 0;

		for(int k1 = 0; k1 < k; k1++)
			ai1[abyte0[k1] + 1]++;

		for(int l1 = 1; l1 < 23; l1++)
			ai1[l1] += ai1[l1 - 1];

		for(int i2 = 0; i2 < 23; i2++)
			ai[i2] = 0;

		int i3 = 0;
		for(int j2 = i; j2 <= j; j2++) {
			i3 += ai1[j2 + 1] - ai1[j2];
			ai[j2] = i3 - 1;
			i3 <<= 1;
		}

		for(int k2 = i + 1; k2 <= j; k2++)
			ai1[k2] = (ai[k2 - 1] + 1 << 1) - ai1[k2];

	}

	private static int method131(int i, BZip2Block bzip2block) {
		int j;
		do {
			if(bzip2block.anInt470 >= i) {
				int k = bzip2block.anInt469 >> bzip2block.anInt470 - i & (1 << i) - 1;
				bzip2block.anInt470 -= i;
				j = k;
				break;
			}
			bzip2block.anInt469 = bzip2block.anInt469 << 8 | bzip2block.aByteArray456[bzip2block.anInt457] & 0xff;
			bzip2block.anInt470 += 8;
			bzip2block.anInt457++;
			bzip2block.anInt458--;
			bzip2block.anInt459++;
			if(bzip2block.anInt459 == 0)
				bzip2block.anInt460++;
		} while(true);
		return j;
	}

	private static void method132(BZip2Block bzip2block) {
		bzip2block.anInt478 = 0;
		for(int i = 0; i < 256; i++)
			if(bzip2block.aBooleanArray492[i]) {
				bzip2block.aByteArray494[bzip2block.anInt478] = (byte)i;
				bzip2block.anInt478++;
			}

	}

	public static int method133(byte abyte0[], int i, byte abyte1[], int j, int k) {
		BZip2Block bzip2block = new BZip2Block();
		bzip2block.aByteArray456 = abyte1;
		bzip2block.anInt457 = k;
		bzip2block.aByteArray461 = abyte0;
		bzip2block.anInt462 = 0;
		bzip2block.anInt458 = j;
		bzip2block.anInt463 = i;
		bzip2block.anInt470 = 0;
		bzip2block.anInt469 = 0;
		bzip2block.anInt459 = 0;
		bzip2block.anInt460 = 0;
		bzip2block.anInt464 = 0;
		bzip2block.anInt465 = 0;
		bzip2block.anInt472 = 0;
		method135(bzip2block);
		i -= bzip2block.anInt463;
		return i;
	}

	private static byte method134(BZip2Block bzip2block) {
		return (byte)method131(8, bzip2block);
	}

	private static void method135(BZip2Block bzip2block) {
		boolean flag = false;
		boolean flag1 = false;
		boolean flag2 = false;
		boolean flag3 = false;
		boolean flag4 = false;
		boolean flag5 = false;
		boolean flag6 = false;
		boolean flag7 = false;
		boolean flag8 = false;
		boolean flag9 = false;
		boolean flag10 = false;
		boolean flag11 = false;
		boolean flag12 = false;
		boolean flag13 = false;
		boolean flag14 = false;
		boolean flag15 = false;
		boolean flag16 = false;
		boolean flag17 = false;
		boolean flag18 = false;
		int k8 = 0;
		int ai[] = null;
		int ai1[] = null;
		int ai2[] = null;
		bzip2block.anInt471 = 1;
		if(BZip2Block.anIntArray477 == null)
			BZip2Block.anIntArray477 = new int[bzip2block.anInt471 * 0x186a0];
		boolean flag19 = true;
		while(flag19)  {
			byte byte0 = method134(bzip2block);
			if(byte0 == 23)
				return;
			byte0 = method134(bzip2block);
			byte0 = method134(bzip2block);
			byte0 = method134(bzip2block);
			byte0 = method134(bzip2block);
			byte0 = method134(bzip2block);
			bzip2block.anInt472++;
			byte0 = method134(bzip2block);
			byte0 = method134(bzip2block);
			byte0 = method134(bzip2block);
			byte0 = method134(bzip2block);
			byte0 = method136(bzip2block);
			if(byte0 != 0)
				bzip2block.aBoolean468 = true;
			else
				bzip2block.aBoolean468 = false;
			if(bzip2block.aBoolean468)
				System.out.println("PANIC! RANDOMISED BLOCK!");
			bzip2block.anInt473 = 0;
			byte0 = method134(bzip2block);
			bzip2block.anInt473 = bzip2block.anInt473 << 8 | byte0 & 0xff;
			byte0 = method134(bzip2block);
			bzip2block.anInt473 = bzip2block.anInt473 << 8 | byte0 & 0xff;
			byte0 = method134(bzip2block);
			bzip2block.anInt473 = bzip2block.anInt473 << 8 | byte0 & 0xff;
			for(int j = 0; j < 16; j++) {
				byte byte1 = method136(bzip2block);
				if(byte1 == 1)
					bzip2block.aBooleanArray493[j] = true;
				else
					bzip2block.aBooleanArray493[j] = false;
			}

			for(int k = 0; k < 256; k++)
				bzip2block.aBooleanArray492[k] = false;

			for(int l = 0; l < 16; l++)
				if(bzip2block.aBooleanArray493[l]) {
					for(int i3 = 0; i3 < 16; i3++) {
						byte byte2 = method136(bzip2block);
						if(byte2 == 1)
							bzip2block.aBooleanArray492[l * 16 + i3] = true;
					}

				}

			method132(bzip2block);
			int i4 = bzip2block.anInt478 + 2;
			int j4 = method131(3, bzip2block);
			int k4 = method131(15, bzip2block);
			for(int i1 = 0; i1 < k4; i1++) {
				int j3 = 0;
				do {
					byte byte3 = method136(bzip2block);
					if(byte3 == 0)
						break;
					j3++;
				} while(true);
				bzip2block.aByteArray498[i1] = (byte)j3;
			}

			byte abyte0[] = new byte[6];
			for(byte byte16 = 0; byte16 < j4; byte16++)
				abyte0[byte16] = byte16;

			for(int j1 = 0; j1 < k4; j1++) {
				byte byte17 = bzip2block.aByteArray498[j1];
				byte byte15 = abyte0[byte17];
				for(; byte17 > 0; byte17--)
					abyte0[byte17] = abyte0[byte17 - 1];

				abyte0[0] = byte15;
				bzip2block.aByteArray497[j1] = byte15;
			}

			for(int k3 = 0; k3 < j4; k3++) {
				int l6 = method131(5, bzip2block);
				for(int k1 = 0; k1 < i4; k1++) {
					do {
						byte byte4 = method136(bzip2block);
						if(byte4 == 0)
							break;
						byte4 = method136(bzip2block);
						if(byte4 == 0)
							l6++;
						else
							l6--;
					} while(true);
					bzip2block.aByteArrayArray499[k3][k1] = (byte)l6;
				}

			}

			for(int l3 = 0; l3 < j4; l3++) {
				byte byte8 = 32;
				int i = 0;
				for(int l1 = 0; l1 < i4; l1++) {
					if(bzip2block.aByteArrayArray499[l3][l1] > i)
						i = bzip2block.aByteArrayArray499[l3][l1];
					if(bzip2block.aByteArrayArray499[l3][l1] < byte8)
						byte8 = bzip2block.aByteArrayArray499[l3][l1];
				}

				method130(bzip2block.anIntArrayArray500[l3], bzip2block.anIntArrayArray501[l3], bzip2block.anIntArrayArray502[l3], bzip2block.aByteArrayArray499[l3], byte8, i, i4);
				bzip2block.anIntArray503[l3] = byte8;
			}

			int l4 = bzip2block.anInt478 + 1;
			int l5 = 0x186a0 * bzip2block.anInt471;
			int i5 = -1;
			int j5 = 0;
			for(int i2 = 0; i2 <= 255; i2++)
				bzip2block.anIntArray489[i2] = 0;

			int j9 = 4095;
			for(int l8 = 15; l8 >= 0; l8--) {
				for(int i9 = 15; i9 >= 0; i9--) {
					bzip2block.aByteArray495[j9] = (byte)(l8 * 16 + i9);
					j9--;
				}

				bzip2block.anIntArray496[l8] = j9 + 1;
			}

			int i6 = 0;
			if(j5 == 0) {
				i5++;
				j5 = 50;
				byte byte12 = bzip2block.aByteArray497[i5];
				k8 = bzip2block.anIntArray503[byte12];
				ai = bzip2block.anIntArrayArray500[byte12];
				ai2 = bzip2block.anIntArrayArray502[byte12];
				ai1 = bzip2block.anIntArrayArray501[byte12];
			}
			j5--;
			int i7 = k8;
			int l7;
			byte byte9;
			for(l7 = method131(i7, bzip2block); l7 > ai[i7]; l7 = l7 << 1 | byte9) {
				i7++;
				byte9 = method136(bzip2block);
			}

			for(int k5 = ai2[l7 - ai1[i7]]; k5 != l4;)
				if(k5 == 0 || k5 == 1) {
					int j6 = -1;
					int k6 = 1;
					do {
						if(k5 == 0)
							j6 += k6;
						else
						if(k5 == 1)
							j6 += 2 * k6;
						k6 *= 2;
						if(j5 == 0) {
							i5++;
							j5 = 50;
							byte byte13 = bzip2block.aByteArray497[i5];
							k8 = bzip2block.anIntArray503[byte13];
							ai = bzip2block.anIntArrayArray500[byte13];
							ai2 = bzip2block.anIntArrayArray502[byte13];
							ai1 = bzip2block.anIntArrayArray501[byte13];
						}
						j5--;
						int j7 = k8;
						int i8;
						byte byte10;
						for(i8 = method131(j7, bzip2block); i8 > ai[j7]; i8 = i8 << 1 | byte10) {
							j7++;
							byte10 = method136(bzip2block);
						}

						k5 = ai2[i8 - ai1[j7]];
					} while(k5 == 0 || k5 == 1);
					j6++;
					byte byte5 = bzip2block.aByteArray494[bzip2block.aByteArray495[bzip2block.anIntArray496[0]] & 0xff];
					bzip2block.anIntArray489[byte5 & 0xff] += j6;
					for(; j6 > 0; j6--) {
						BZip2Block.anIntArray477[i6] = byte5 & 0xff;
						i6++;
					}

				} else {
					int j11 = k5 - 1;
					byte byte6;
					if(j11 < 16) {
						int j10 = bzip2block.anIntArray496[0];
						byte6 = bzip2block.aByteArray495[j10 + j11];
						for(; j11 > 3; j11 -= 4) {
							int k11 = j10 + j11;
							bzip2block.aByteArray495[k11] = bzip2block.aByteArray495[k11 - 1];
							bzip2block.aByteArray495[k11 - 1] = bzip2block.aByteArray495[k11 - 2];
							bzip2block.aByteArray495[k11 - 2] = bzip2block.aByteArray495[k11 - 3];
							bzip2block.aByteArray495[k11 - 3] = bzip2block.aByteArray495[k11 - 4];
						}

						for(; j11 > 0; j11--)
							bzip2block.aByteArray495[j10 + j11] = bzip2block.aByteArray495[(j10 + j11) - 1];

						bzip2block.aByteArray495[j10] = byte6;
					} else {
						int l10 = j11 / 16;
						int i11 = j11 % 16;
						int k10 = bzip2block.anIntArray496[l10] + i11;
						byte6 = bzip2block.aByteArray495[k10];
						for(; k10 > bzip2block.anIntArray496[l10]; k10--)
							bzip2block.aByteArray495[k10] = bzip2block.aByteArray495[k10 - 1];

						bzip2block.anIntArray496[l10]++;
						for(; l10 > 0; l10--) {
							bzip2block.anIntArray496[l10]--;
							bzip2block.aByteArray495[bzip2block.anIntArray496[l10]] = bzip2block.aByteArray495[(bzip2block.anIntArray496[l10 - 1] + 16) - 1];
						}

						bzip2block.anIntArray496[0]--;
						bzip2block.aByteArray495[bzip2block.anIntArray496[0]] = byte6;
						if(bzip2block.anIntArray496[0] == 0) {
							int i10 = 4095;
							for(int k9 = 15; k9 >= 0; k9--) {
								for(int l9 = 15; l9 >= 0; l9--) {
									bzip2block.aByteArray495[i10] = bzip2block.aByteArray495[bzip2block.anIntArray496[k9] + l9];
									i10--;
								}

								bzip2block.anIntArray496[k9] = i10 + 1;
							}

						}
					}
					bzip2block.anIntArray489[bzip2block.aByteArray494[byte6 & 0xff] & 0xff]++;
					BZip2Block.anIntArray477[i6] = bzip2block.aByteArray494[byte6 & 0xff] & 0xff;
					i6++;
					if(j5 == 0) {
						i5++;
						j5 = 50;
						byte byte14 = bzip2block.aByteArray497[i5];
						k8 = bzip2block.anIntArray503[byte14];
						ai = bzip2block.anIntArrayArray500[byte14];
						ai2 = bzip2block.anIntArrayArray502[byte14];
						ai1 = bzip2block.anIntArrayArray501[byte14];
					}
					j5--;
					int k7 = k8;
					int j8;
					byte byte11;
					for(j8 = method131(k7, bzip2block); j8 > ai[k7]; j8 = j8 << 1 | byte11) {
						k7++;
						byte11 = method136(bzip2block);
					}

					k5 = ai2[j8 - ai1[k7]];
				}

			bzip2block.anInt467 = 0;
			bzip2block.aByte466 = 0;
			bzip2block.anIntArray490[0] = 0;
			for(int j2 = 1; j2 <= 256; j2++)
				bzip2block.anIntArray490[j2] = bzip2block.anIntArray489[j2 - 1];

			for(int k2 = 1; k2 <= 256; k2++)
				bzip2block.anIntArray490[k2] += bzip2block.anIntArray490[k2 - 1];

			for(int l2 = 0; l2 < i6; l2++) {
				byte byte7 = (byte)(BZip2Block.anIntArray477[l2] & 0xff);
				BZip2Block.anIntArray477[bzip2block.anIntArray490[byte7 & 0xff]] |= l2 << 8;
				bzip2block.anIntArray490[byte7 & 0xff]++;
			}

			bzip2block.anInt474 = BZip2Block.anIntArray477[bzip2block.anInt473] >> 8;
			bzip2block.anInt476 = 0;
			bzip2block.anInt474 = BZip2Block.anIntArray477[bzip2block.anInt474];
			bzip2block.anInt475 = (byte)(bzip2block.anInt474 & 0xff);
			bzip2block.anInt474 >>= 8;
			bzip2block.anInt476++;
			bzip2block.anInt479 = i6;
			method129(bzip2block);
			if(bzip2block.anInt476 == bzip2block.anInt479 + 1 && bzip2block.anInt467 == 0)
				flag19 = true;
			else
				flag19 = false;
		}
	}

	private static byte method136(BZip2Block bzip2block) {
		return (byte)method131(1, bzip2block);
	}
}
