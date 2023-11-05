// Decompiled by Jad v1.5.8c. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

import net.runelite.mapping.Implements;

import java.awt.*;
import java.awt.image.*;
import java.util.Arrays;

@Implements("RSSurface")
public class Surface
	implements ImageProducer, ImageObserver {

	public void method207(int i, int j, int k, int l, int i1) {
		if(i < boundsTopX) {
			k -= boundsTopX - i;
			i = boundsTopX;
		}
		if(j < boundsTopY) {
			l -= boundsTopY - j;
			j = boundsTopY;
		}
		if(i + k > boundsBottomX)
			k = boundsBottomX - i;
		if(j + l > boundsBottomY)
			l = boundsBottomY - j;
		int j1 = width2 - k;
		byte byte0 = 1;
		if(aBoolean321) {
			byte0 = 2;
			j1 += width2;
			if((j & 1) != 0) {
				j++;
				l--;
			}
		}
		int k1 = i + j * width2;
		for(int l1 = -l; l1 < 0; l1 += byte0) {
			for(int i2 = -k; i2 < 0; i2++)
				pixels[k1++] = i1;

			k1 += j1;
		}

	}

	private void method208(int[] ai, int[] ai1, int i, int j, int k, int l, int i1,
                           int j1, int k1, int l1, int i2) {
		int j2 = 256 - i2;
		for(int k2 = -i1; k2 < 0; k2 += l1) {
			for(int l2 = -l; l2 < 0; l2++) {
				i = ai1[j++];
				if(i != 0) {
					int i3 = ai[k];
					ai[k++] = ((i & 0xff00ff) * i2 + (i3 & 0xff00ff) * j2 & 0xff00ff00) + ((i & 0xff00) * i2 + (i3 & 0xff00) * j2 & 0xff0000) >> 8;
				} else {
					k++;
				}
			}

			k += j1;
			j += k1;
		}

	}

	public void fadeToBlack() {
		int k = width2 * height2;
		for(int j = 0; j < k; j++) {
			int i = pixels[j] & 0xffffff;
			pixels[j] = (i >>> 1 & 0x7f7f7f) + (i >>> 2 & 0x3f3f3f) + (i >>> 3 & 0x1f1f1f) + (i >>> 4 & 0xf0f0f);
		}

	}

	public void method210(int i) {
		if(aByteArrayArray324[i] == null)
			return;
		int j = anIntArray325[i] * anIntArray326[i];
		byte[] abyte0 = aByteArrayArray324[i];
		int[] ai = anIntArrayArray327[i];
		int[] ai1 = new int[j];
		for(int k = 0; k < j; k++) {
			int l = ai[abyte0[k] & 0xff];
			if(l == 0)
				l = 1;
			else
			if(l == 0xff00ff)
				l = 0;
			ai1[k] = l;
		}

		anIntArrayArray328[i] = ai1;
		aByteArrayArray324[i] = null;
		anIntArrayArray327[i] = null;
	}

	public void method211(int i, byte[] abyte0, byte[] abyte1, int j) {
		int k = DataUtils.method344(abyte0, 0);
		int l = DataUtils.method344(abyte1, k);
		k += 2;
		int i1 = DataUtils.method344(abyte1, k);
		k += 2;
		int j1 = abyte1[k++] & 0xff;
		int[] ai = new int[j1];
		ai[0] = 0xff00ff;
		for(int k1 = 0; k1 < j1 - 1; k1++) {
			ai[k1 + 1] = ((abyte1[k] & 0xff) << 16) + ((abyte1[k + 1] & 0xff) << 8) + (abyte1[k + 2] & 0xff);
			k += 3;
		}

		int l1 = 2;
		for(int i2 = i; i2 < i + j; i2++) {
			anIntArray329[i2] = abyte1[k++] & 0xff;
			anIntArray330[i2] = abyte1[k++] & 0xff;
			anIntArray325[i2] = DataUtils.method344(abyte1, k);
			k += 2;
			anIntArray326[i2] = DataUtils.method344(abyte1, k);
			k += 2;
			int j2 = abyte1[k++] & 0xff;
			int k2 = anIntArray325[i2] * anIntArray326[i2];
			aByteArrayArray324[i2] = new byte[k2];
			anIntArrayArray327[i2] = ai;
			anIntArray331[i2] = l;
			anIntArray332[i2] = i1;
			anIntArrayArray328[i2] = null;
            aBooleanArray333[i2] = anIntArray329[i2] != 0 || anIntArray330[i2] != 0;
			if(j2 == 0) {
				for(int l2 = 0; l2 < k2; l2++) {
					aByteArrayArray324[i2][l2] = abyte0[l1++];
					if(aByteArrayArray324[i2][l2] == 0)
						aBooleanArray333[i2] = true;
				}

			} else
			if(j2 == 1) {
				for(int i3 = 0; i3 < anIntArray325[i2]; i3++) {
					for(int j3 = 0; j3 < anIntArray326[i2]; j3++) {
						aByteArrayArray324[i2][i3 + j3 * anIntArray325[i2]] = abyte0[l1++];
						if(aByteArrayArray324[i2][i3 + j3 * anIntArray325[i2]] == 0)
							aBooleanArray333[i2] = true;
					}

				}

			}
		}

	}

	public int textWidth(String s, int i) {
		int j = 0;
		byte[] abyte0 = fonts[i];
		for(int k = 0; k < s.length(); k++)
			if(s.charAt(k) == '@' && k + 4 < s.length() && s.charAt(k + 4) == '@')
				k += 4;
			else
			if(s.charAt(k) == '~' && k + 4 < s.length() && s.charAt(k + 4) == '~')
				k += 4;
			else
				j += abyte0[inputFilterCharFontAddr[s.charAt(k)] + 7];

		return j;
	}

	private void drawCharacter(int i, int j, int k, int l, byte[] abyte0, boolean flag) {
		int i1 = j + abyte0[i + 5];
		int j1 = k - abyte0[i + 6];
		int k1 = abyte0[i + 3];
		int l1 = abyte0[i + 4];
		int i2 = abyte0[i] * 16384 + abyte0[i + 1] * 128 + abyte0[i + 2];
		int j2 = i1 + j1 * width2;
		int k2 = width2 - k1;
		int l2 = 0;
		if(j1 < boundsTopY) {
			int i3 = boundsTopY - j1;
			l1 -= i3;
			j1 = boundsTopY;
			i2 += i3 * k1;
			j2 += i3 * width2;
		}
		if(j1 + l1 >= boundsBottomY)
			l1 -= ((j1 + l1) - boundsBottomY) + 1;
		if(i1 < boundsTopX) {
			int j3 = boundsTopX - i1;
			k1 -= j3;
			i1 = boundsTopX;
			i2 += j3;
			j2 += j3;
			l2 += j3;
			k2 += j3;
		}
		if(i1 + k1 >= boundsBottomX) {
			int k3 = ((i1 + k1) - boundsBottomX) + 1;
			k1 -= k3;
			l2 += k3;
			k2 += k3;
		}
		if(k1 > 0 && l1 > 0) {
			if(flag) {
				method218(pixels, abyte0, l, i2, j2, k1, l1, k2, l2);
				return;
			}
			method250(pixels, abyte0, l, i2, j2, k1, l1, k2, l2);
		}
	}

	public void method214(int i, int j, int k, int l, int i1) {
		drawHorizontalLine(i, j, k, i1);
		drawHorizontalLine(i, (j + l) - 1, k, i1);
		method217(i, j, l, i1);
		method217((i + k) - 1, j, l, i1);
	}

	public int method215(int i) {
		if(i == 0)
			return fonts[i][8] - 2;
		else
			return fonts[i][8] - 1;
	}

	public void drawStringCenter(String s, int i, int j, int k, int l) {
		drawString(s, i - textWidth(s, k) / 2, j, k, l);
	}

	public void method217(int i, int j, int k, int l) {
		if(i < boundsTopX || i >= boundsBottomX)
			return;
		if(j < boundsTopY) {
			k -= boundsTopY - j;
			j = boundsTopY;
		}
		if(j + k > boundsBottomX)
			k = boundsBottomY - j;
		int i1 = i + j * width2;
		for(int j1 = 0; j1 < k; j1++)
			pixels[i1 + j1 * width2] = l;

	}

	private void method218(int[] ai, byte[] abyte0, int i, int j, int k, int l, int i1,
                           int j1, int k1) {
		for(int l1 = -i1; l1 < 0; l1++) {
			for(int i2 = -l; i2 < 0; i2++) {
				int j2 = abyte0[j++] & 0xff;
				if(j2 > 30) {
					if(j2 >= 230) {
						ai[k++] = i;
					} else {
						int k2 = ai[k];
						ai[k++] = ((i & 0xff00ff) * j2 + (k2 & 0xff00ff) * (256 - j2) & 0xff00ff00) + ((i & 0xff00) * j2 + (k2 & 0xff00) * (256 - j2) & 0xff0000) >> 8;
					}
				} else {
					k++;
				}
			}

			k += j1;
			j += k1;
		}

	}

	private void method219(int[] ai, int[] ai1, int i, int j, int k, int l, int i1,
                           int j1, int k1, int l1) {
		int i2 = -(l >> 2);
		l = -(l & 3);
		for(int j2 = -i1; j2 < 0; j2 += l1) {
			for(int k2 = i2; k2 < 0; k2++) {
				i = ai1[j++];
				if(i != 0)
					ai[k++] = i;
				else
					k++;
				i = ai1[j++];
				if(i != 0)
					ai[k++] = i;
				else
					k++;
				i = ai1[j++];
				if(i != 0)
					ai[k++] = i;
				else
					k++;
				i = ai1[j++];
				if(i != 0)
					ai[k++] = i;
				else
					k++;
			}

			for(int l2 = l; l2 < 0; l2++) {
				i = ai1[j++];
				if(i != 0)
					ai[k++] = i;
				else
					k++;
			}

			k += j1;
			j += k1;
		}

	}

	public void spriteClipping(int i, int j, int k, int l, int i1, int j1, int k1) {
		spriteClipping(i, j, k, l, i1);
	}

	public void spriteClipping(int i, int j, int k, int l, int i1, int j1, int k1,
							   int l1, boolean flag) {
		try {
			if(j1 == 0)
				j1 = 0xffffff;
			if(k1 == 0)
				k1 = 0xffffff;
			int i2 = anIntArray325[i1];
			int j2 = anIntArray326[i1];
			int k2 = 0;
			int l2 = 0;
			int i3 = l1 << 16;
			int j3 = (i2 << 16) / k;
			int k3 = (j2 << 16) / l;
			int l3 = -(l1 << 16) / l;
			if(aBooleanArray333[i1]) {
				int i4 = anIntArray331[i1];
				int k4 = anIntArray332[i1];
				j3 = (i4 << 16) / k;
				k3 = (k4 << 16) / l;
				int j5 = anIntArray329[i1];
				int k5 = anIntArray330[i1];
				if(flag)
					j5 = i4 - anIntArray325[i1] - j5;
				i += ((j5 * k + i4) - 1) / i4;
				int l5 = ((k5 * l + k4) - 1) / k4;
				j += l5;
				i3 += l5 * l3;
				if((j5 * k) % i4 != 0)
					k2 = (i4 - (j5 * k) % i4 << 16) / k;
				if((k5 * l) % k4 != 0)
					l2 = (k4 - (k5 * l) % k4 << 16) / l;
				k = ((((anIntArray325[i1] << 16) - k2) + j3) - 1) / j3;
				l = ((((anIntArray326[i1] << 16) - l2) + k3) - 1) / k3;
			}
			int j4 = j * width2;
			i3 += i << 16;
			if(j < boundsTopY) {
				int l4 = boundsTopY - j;
				l -= l4;
				j = boundsTopY;
				j4 += l4 * width2;
				l2 += k3 * l4;
				i3 += l3 * l4;
			}
			if(j + l >= boundsBottomY)
				l -= ((j + l) - boundsBottomY) + 1;
			int i5 = j4 / width2 & 1;
			if(!aBoolean321)
				i5 = 2;
			if(k1 == 0xffffff) {
				if(anIntArrayArray328[i1] != null)
					if(!flag) {
						method231(pixels, anIntArrayArray328[i1], 0, k2, l2, j4, k, l, j3, k3, i2, j1, i3, l3, i5);
						return;
					} else {
						method231(pixels, anIntArrayArray328[i1], 0, (anIntArray325[i1] << 16) - k2 - 1, l2, j4, k, l, -j3, k3, i2, j1, i3, l3, i5);
						return;
					}
				if(!flag) {
					method229(pixels, aByteArrayArray324[i1], anIntArrayArray327[i1], 0, k2, l2, j4, k, l, j3, k3, i2, j1, i3, l3, i5);
					return;
				} else {
					method229(pixels, aByteArrayArray324[i1], anIntArrayArray327[i1], 0, (anIntArray325[i1] << 16) - k2 - 1, l2, j4, k, l, -j3, k3, i2, j1, i3, l3, i5);
					return;
				}
			}
			if(anIntArrayArray328[i1] != null)
				if(!flag) {
					method228(pixels, anIntArrayArray328[i1], 0, k2, l2, j4, k, l, j3, k3, i2, j1, k1, i3, l3, i5);
					return;
				} else {
					method228(pixels, anIntArrayArray328[i1], 0, (anIntArray325[i1] << 16) - k2 - 1, l2, j4, k, l, -j3, k3, i2, j1, k1, i3, l3, i5);
					return;
				}
			if(!flag) {
				method227(pixels, aByteArrayArray324[i1], anIntArrayArray327[i1], 0, k2, l2, j4, k, l, j3, k3, i2, j1, k1, i3, l3, i5);
            } else {
				method227(pixels, aByteArrayArray324[i1], anIntArrayArray327[i1], 0, (anIntArray325[i1] << 16) - k2 - 1, l2, j4, k, l, -j3, k3, i2, j1, k1, i3, l3, i5);
            }
		}
		catch(Exception _ex) {
			System.out.println("error in sprite clipping routine");
		}
	}

	public static int method222(int i, int j, int k) {
		return (i << 16) + (j << 8) + k;
	}

	public void method223() {
		boundsTopX = 0;
		boundsTopY = 0;
		boundsBottomX = width2;
		boundsBottomY = height2;
	}

	public void method224(int i, int j, int k, int l, int i1, int j1) {
		if(i < boundsTopX) {
			k -= boundsTopX - i;
			i = boundsTopX;
		}
		if(j < boundsTopY) {
			l -= boundsTopY - j;
			j = boundsTopY;
		}
		if(i + k > boundsBottomX)
			k = boundsBottomX - i;
		if(j + l > boundsBottomY)
			l = boundsBottomY - j;
		int k1 = 256 - j1;
		int l1 = (i1 >> 16 & 0xff) * j1;
		int i2 = (i1 >> 8 & 0xff) * j1;
		int j2 = (i1 & 0xff) * j1;
		int j3 = width2 - k;
		byte byte0 = 1;
		if(aBoolean321) {
			byte0 = 2;
			j3 += width2;
			if((j & 1) != 0) {
				j++;
				l--;
			}
		}
		int k3 = i + j * width2;
		for(int l3 = 0; l3 < l; l3 += byte0) {
			for(int i4 = -k; i4 < 0; i4++) {
				int k2 = (pixels[k3] >> 16 & 0xff) * k1;
				int l2 = (pixels[k3] >> 8 & 0xff) * k1;
				int i3 = (pixels[k3] & 0xff) * k1;
				int j4 = ((l1 + k2 >> 8) << 16) + ((i2 + l2 >> 8) << 8) + (j2 + i3 >> 8);
				pixels[k3++] = j4;
			}

			k3 += j3;
		}

	}

	public void method225(int i, int j, int k, int l, int i1, int j1) {
		for(int k1 = k; k1 < k + i1; k1++) {
			for(int l1 = l; l1 < l + j1; l1++) {
				int i2 = 0;
				int j2 = 0;
				int k2 = 0;
				int l2 = 0;
				for(int i3 = k1 - i; i3 <= k1 + i; i3++)
					if(i3 >= 0 && i3 < width2) {
						for(int j3 = l1 - j; j3 <= l1 + j; j3++)
							if(j3 >= 0 && j3 < height2) {
								int k3 = pixels[i3 + width2 * j3];
								i2 += k3 >> 16 & 0xff;
								j2 += k3 >> 8 & 0xff;
								k2 += k3 & 0xff;
								l2++;
							}

					}

				pixels[k1 + width2 * l1] = (i2 / l2 << 16) + (j2 / l2 << 8) + k2 / l2;
			}

		}

	}

	public void method226(int i, int j, int k, int l, int i1, int j1) {
		if(i < boundsTopX) {
			k -= boundsTopX - i;
			i = boundsTopX;
		}
		if(i + k > boundsBottomX)
			k = boundsBottomX - i;
		int k1 = j1 >> 16 & 0xff;
		int l1 = j1 >> 8 & 0xff;
		int i2 = j1 & 0xff;
		int j2 = i1 >> 16 & 0xff;
		int k2 = i1 >> 8 & 0xff;
		int l2 = i1 & 0xff;
		int i3 = width2 - k;
		byte byte0 = 1;
		if(aBoolean321) {
			byte0 = 2;
			i3 += width2;
			if((j & 1) != 0) {
				j++;
				l--;
			}
		}
		int j3 = i + j * width2;
		for(int k3 = 0; k3 < l; k3 += byte0)
			if(k3 + j >= boundsTopY && k3 + j < boundsBottomY) {
				int l3 = ((k1 * k3 + j2 * (l - k3)) / l << 16) + ((l1 * k3 + k2 * (l - k3)) / l << 8) + (i2 * k3 + l2 * (l - k3)) / l;
				for(int i4 = -k; i4 < 0; i4++)
					pixels[j3++] = l3;

				j3 += i3;
			} else {
				j3 += width2;
			}

	}

	private void method227(int[] ai, byte[] abyte0, int[] ai1, int i, int j, int k, int l,
                           int i1, int j1, int k1, int l1, int i2, int j2, int k2,
                           int l2, int i3, int j3) {
		int j4 = j2 >> 16 & 0xff;
		int k4 = j2 >> 8 & 0xff;
		int l4 = j2 & 0xff;
		int i5 = k2 >> 16 & 0xff;
		int j5 = k2 >> 8 & 0xff;
		int k5 = k2 & 0xff;
		try {
			int l5 = j;
			for(int i6 = -j1; i6 < 0; i6++) {
				int j6 = (k >> 16) * i2;
				int k6 = l2 >> 16;
				int l6 = i1;
				if(k6 < boundsTopX) {
					int i7 = boundsTopX - k6;
					l6 -= i7;
					k6 = boundsTopX;
					j += k1 * i7;
				}
				if(k6 + l6 >= boundsBottomX) {
					int j7 = (k6 + l6) - boundsBottomX;
					l6 -= j7;
				}
				j3 = 1 - j3;
				if(j3 != 0) {
					for(int k7 = k6; k7 < k6 + l6; k7++) {
						i = abyte0[(j >> 16) + j6] & 0xff;
						if(i != 0) {
							i = ai1[i];
							int k3 = i >> 16 & 0xff;
							int l3 = i >> 8 & 0xff;
							int i4 = i & 0xff;
							if(k3 == l3 && l3 == i4)
								ai[k7 + l] = ((k3 * j4 >> 8) << 16) + ((l3 * k4 >> 8) << 8) + (i4 * l4 >> 8);
							else
							if(k3 == 255 && l3 == i4)
								ai[k7 + l] = ((k3 * i5 >> 8) << 16) + ((l3 * j5 >> 8) << 8) + (i4 * k5 >> 8);
							else
								ai[k7 + l] = i;
						}
						j += k1;
					}

				}
				k += l1;
				j = l5;
				l += width2;
				l2 += i3;
			}

        }
		catch(Exception _ex) {
			System.out.println("error in transparent sprite plot routine");
		}
	}

	private void method228(int[] ai, int[] ai1, int i, int j, int k, int l, int i1,
                           int j1, int k1, int l1, int i2, int j2, int k2, int l2,
                           int i3, int j3) {
		int j4 = j2 >> 16 & 0xff;
		int k4 = j2 >> 8 & 0xff;
		int l4 = j2 & 0xff;
		int i5 = k2 >> 16 & 0xff;
		int j5 = k2 >> 8 & 0xff;
		int k5 = k2 & 0xff;
		try {
			int l5 = j;
			for(int i6 = -j1; i6 < 0; i6++) {
				int j6 = (k >> 16) * i2;
				int k6 = l2 >> 16;
				int l6 = i1;
				if(k6 < boundsTopX) {
					int i7 = boundsTopX - k6;
					l6 -= i7;
					k6 = boundsTopX;
					j += k1 * i7;
				}
				if(k6 + l6 >= boundsBottomX) {
					int j7 = (k6 + l6) - boundsBottomX;
					l6 -= j7;
				}
				j3 = 1 - j3;
				if(j3 != 0) {
					for(int k7 = k6; k7 < k6 + l6; k7++) {
						i = ai1[(j >> 16) + j6];
						if(i != 0) {
							int k3 = i >> 16 & 0xff;
							int l3 = i >> 8 & 0xff;
							int i4 = i & 0xff;
							if(k3 == l3 && l3 == i4)
								ai[k7 + l] = ((k3 * j4 >> 8) << 16) + ((l3 * k4 >> 8) << 8) + (i4 * l4 >> 8);
							else
							if(k3 == 255 && l3 == i4)
								ai[k7 + l] = ((k3 * i5 >> 8) << 16) + ((l3 * j5 >> 8) << 8) + (i4 * k5 >> 8);
							else
								ai[k7 + l] = i;
						}
						j += k1;
					}

				}
				k += l1;
				j = l5;
				l += width2;
				l2 += i3;
			}

        }
		catch(Exception _ex) {
			System.out.println("error in transparent sprite plot routine");
		}
	}

	private void method229(int[] ai, byte[] abyte0, int[] ai1, int i, int j, int k, int l,
                           int i1, int j1, int k1, int l1, int i2, int j2, int k2,
                           int l2, int i3) {
		int i4 = j2 >> 16 & 0xff;
		int j4 = j2 >> 8 & 0xff;
		int k4 = j2 & 0xff;
		try {
			int l4 = j;
			for(int i5 = -j1; i5 < 0; i5++) {
				int j5 = (k >> 16) * i2;
				int k5 = k2 >> 16;
				int l5 = i1;
				if(k5 < boundsTopX) {
					int i6 = boundsTopX - k5;
					l5 -= i6;
					k5 = boundsTopX;
					j += k1 * i6;
				}
				if(k5 + l5 >= boundsBottomX) {
					int j6 = (k5 + l5) - boundsBottomX;
					l5 -= j6;
				}
				i3 = 1 - i3;
				if(i3 != 0) {
					for(int k6 = k5; k6 < k5 + l5; k6++) {
						i = abyte0[(j >> 16) + j5] & 0xff;
						if(i != 0) {
							i = ai1[i];
							int j3 = i >> 16 & 0xff;
							int k3 = i >> 8 & 0xff;
							int l3 = i & 0xff;
							if(j3 == k3 && k3 == l3)
								ai[k6 + l] = ((j3 * i4 >> 8) << 16) + ((k3 * j4 >> 8) << 8) + (l3 * k4 >> 8);
							else
								ai[k6 + l] = i;
						}
						j += k1;
					}

				}
				k += l1;
				j = l4;
				l += width2;
				k2 += l2;
			}

        }
		catch(Exception _ex) {
			System.out.println("error in transparent sprite plot routine");
		}
	}

	private void method230(int[] ai, int[] ai1, int i, int j, int k, int l, int i1,
                           int j1, int k1, int l1, int i2, int j2, int k2, int l2) {
		int i3 = l2 >> 16 & 0xff;
		int j3 = l2 >> 8 & 0xff;
		int k3 = l2 & 0xff;
		try {
			int l3 = j;
			for(int i4 = -k1; i4 < 0; i4 += k2) {
				int j4 = (k >> 16) * j2;
				for(int k4 = -j1; k4 < 0; k4++) {
					i = ai1[(j >> 16) + j4];
					if(i != 0) {
						int l4 = i >> 16 & 0xff;
						int i5 = i >> 8 & 0xff;
						int j5 = i & 0xff;
						if(l4 == i5 && i5 == j5)
							ai[l++] = ((l4 * i3 >> 8) << 16) + ((i5 * j3 >> 8) << 8) + (j5 * k3 >> 8);
						else
							ai[l++] = i;
					} else {
						l++;
					}
					j += l1;
				}

				k += i2;
				j = l3;
				l += i1;
			}

        }
		catch(Exception _ex) {
			System.out.println("error in plot_scale");
		}
	}

	private void method231(int[] ai, int[] ai1, int i, int j, int k, int l, int i1,
                           int j1, int k1, int l1, int i2, int j2, int k2, int l2,
                           int i3) {
		int i4 = j2 >> 16 & 0xff;
		int j4 = j2 >> 8 & 0xff;
		int k4 = j2 & 0xff;
		try {
			int l4 = j;
			for(int i5 = -j1; i5 < 0; i5++) {
				int j5 = (k >> 16) * i2;
				int k5 = k2 >> 16;
				int l5 = i1;
				if(k5 < boundsTopX) {
					int i6 = boundsTopX - k5;
					l5 -= i6;
					k5 = boundsTopX;
					j += k1 * i6;
				}
				if(k5 + l5 >= boundsBottomX) {
					int j6 = (k5 + l5) - boundsBottomX;
					l5 -= j6;
				}
				i3 = 1 - i3;
				if(i3 != 0) {
					for(int k6 = k5; k6 < k5 + l5; k6++) {
						i = ai1[(j >> 16) + j5];
						if(i != 0) {
							int j3 = i >> 16 & 0xff;
							int k3 = i >> 8 & 0xff;
							int l3 = i & 0xff;
							if(j3 == k3 && k3 == l3)
								ai[k6 + l] = ((j3 * i4 >> 8) << 16) + ((k3 * j4 >> 8) << 8) + (l3 * k4 >> 8);
							else
								ai[k6 + l] = i;
						}
						j += k1;
					}

				}
				k += l1;
				j = l4;
				l += width2;
				k2 += l2;
			}

        }
		catch(Exception _ex) {
			System.out.println("error in transparent sprite plot routine");
		}
	}

	private void method232(int[] ai, int[] ai1, int i, int j, int k, int l, int i1,
                           int j1, int k1, int l1, int i2, int j2, int k2) {
		try {
			int l2 = j;
			for(int i3 = -k1; i3 < 0; i3 += k2) {
				int j3 = (k >> 16) * j2;
				for(int k3 = -j1; k3 < 0; k3++) {
					i = ai1[(j >> 16) + j3];
					if(i != 0)
						ai[l++] = i;
					else
						l++;
					j += l1;
				}

				k += i2;
				j = l2;
				l += i1;
			}

        }
		catch(Exception _ex) {
			System.out.println("error in plot_scale");
		}
	}

	private void method233(int[] ai, byte[] abyte0, int[] ai1, int i, int j, int k, int l,
                           int i1, int j1, int k1) {
		int l1 = -(k >> 2);
		k = -(k & 3);
		for(int i2 = -l; i2 < 0; i2 += k1) {
			for(int j2 = l1; j2 < 0; j2++) {
				byte byte0 = abyte0[i++];
				if(byte0 != 0)
					ai[j++] = ai1[byte0 & 0xff];
				else
					j++;
				byte0 = abyte0[i++];
				if(byte0 != 0)
					ai[j++] = ai1[byte0 & 0xff];
				else
					j++;
				byte0 = abyte0[i++];
				if(byte0 != 0)
					ai[j++] = ai1[byte0 & 0xff];
				else
					j++;
				byte0 = abyte0[i++];
				if(byte0 != 0)
					ai[j++] = ai1[byte0 & 0xff];
				else
					j++;
			}

			for(int k2 = k; k2 < 0; k2++) {
				byte byte1 = abyte0[i++];
				if(byte1 != 0)
					ai[j++] = ai1[byte1 & 0xff];
				else
					j++;
			}

			j += i1;
			i += j1;
		}

	}

	public void method234(int i, byte[] abyte0) {
		int[] ai = anIntArrayArray328[i] = new int[10200];
		anIntArray325[i] = 255;
		anIntArray326[i] = 40;
		anIntArray329[i] = 0;
		anIntArray330[i] = 0;
		anIntArray331[i] = 255;
		anIntArray332[i] = 40;
		aBooleanArray333[i] = false;
		int j = 0;
		int k = 1;
		int l;
		for(l = 0; l < 255;) {
			int i1 = abyte0[k++] & 0xff;
			for(int k1 = 0; k1 < i1; k1++)
				ai[l++] = j;

			j = 0xffffff - j;
		}

		for(int j1 = 1; j1 < 40; j1++) {
			for(int l1 = 0; l1 < 255;) {
				int i2 = abyte0[k++] & 0xff;
				for(int j2 = 0; j2 < i2; j2++) {
					ai[l] = ai[l - 255];
					l++;
					l1++;
				}

				if(l1 < 255) {
					ai[l] = 0xffffff - ai[l - 255];
					l++;
					l1++;
				}
			}

		}

	}

	public void method235(int i) {
		int j = anIntArray325[i] * anIntArray326[i];
		int[] ai = anIntArrayArray328[i];
		int[] ai1 = new int[32768];
		for(int k = 0; k < j; k++) {
			int l = ai[k];
			ai1[((l & 0xf80000) >> 9) + ((l & 0xf800) >> 6) + ((l & 0xf8) >> 3)]++;
		}

		int[] ai2 = new int[256];
		ai2[0] = 0xff00ff;
		int[] ai3 = new int[256];
		for(int i1 = 0; i1 < 32768; i1++) {
			int j1 = ai1[i1];
			if(j1 > ai3[255]) {
				for(int k1 = 1; k1 < 256; k1++) {
					if(j1 <= ai3[k1])
						continue;
					for(int i2 = 255; i2 > k1; i2--) {
						ai2[i2] = ai2[i2 - 1];
						ai3[i2] = ai3[i2 - 1];
					}

					ai2[k1] = ((i1 & 0x7c00) << 9) + ((i1 & 0x3e0) << 6) + ((i1 & 0x1f) << 3) + 0x40404;
					ai3[k1] = j1;
					break;
				}

			}
			ai1[i1] = -1;
		}

		byte[] abyte0 = new byte[j];
		for(int l1 = 0; l1 < j; l1++) {
			int j2 = ai[l1];
			int k2 = ((j2 & 0xf80000) >> 9) + ((j2 & 0xf800) >> 6) + ((j2 & 0xf8) >> 3);
			int l2 = ai1[k2];
			if(l2 == -1) {
				int i3 = 0x3b9ac9ff;
				int j3 = j2 >> 16 & 0xff;
				int k3 = j2 >> 8 & 0xff;
				int l3 = j2 & 0xff;
				for(int i4 = 0; i4 < 256; i4++) {
					int j4 = ai2[i4];
					int k4 = j4 >> 16 & 0xff;
					int l4 = j4 >> 8 & 0xff;
					int i5 = j4 & 0xff;
					int j5 = (j3 - k4) * (j3 - k4) + (k3 - l4) * (k3 - l4) + (l3 - i5) * (l3 - i5);
					if(j5 < i3) {
						i3 = j5;
						l2 = i4;
					}
				}

				ai1[k2] = l2;
			}
			abyte0[l1] = (byte)l2;
		}

		aByteArrayArray324[i] = abyte0;
		anIntArrayArray327[i] = ai2;
		anIntArrayArray328[i] = null;
	}

	public void method236(int i, int j, int k, int l, int i1) {
		int j1 = width2;
		int k1 = height2;
		if(anIntArray336 == null) {
			anIntArray336 = new int[512];
			for(int l1 = 0; l1 < 256; l1++) {
				anIntArray336[l1] = (int)(Math.sin((double)l1 * 0.02454369D) * 32768D);
				anIntArray336[l1 + 256] = (int)(Math.cos((double)l1 * 0.02454369D) * 32768D);
			}

		}
		int i2 = -anIntArray331[k] / 2;
		int j2 = -anIntArray332[k] / 2;
		if(aBooleanArray333[k]) {
			i2 += anIntArray329[k];
			j2 += anIntArray330[k];
		}
		int k2 = i2 + anIntArray325[k];
		int l2 = j2 + anIntArray326[k];
		int i3 = k2;
		int j3 = j2;
		int k3 = i2;
		int l3 = l2;
		l &= 0xff;
		int i4 = anIntArray336[l] * i1;
		int j4 = anIntArray336[l + 256] * i1;
		int k4 = i + (j2 * i4 + i2 * j4 >> 22);
		int l4 = j + (j2 * j4 - i2 * i4 >> 22);
		int i5 = i + (j3 * i4 + i3 * j4 >> 22);
		int j5 = j + (j3 * j4 - i3 * i4 >> 22);
		int k5 = i + (l2 * i4 + k2 * j4 >> 22);
		int l5 = j + (l2 * j4 - k2 * i4 >> 22);
		int i6 = i + (l3 * i4 + k3 * j4 >> 22);
		int j6 = j + (l3 * j4 - k3 * i4 >> 22);
		if(i1 == 192 && (l & 0x3f) == (anInt337 & 0x3f))
			anInt338++;
		else
		if(i1 == 128)
			anInt337 = l;
		else
			anInt339++;
		int k6 = l4;
		int l6 = l4;
		if(j5 < k6)
			k6 = j5;
		else
		if(j5 > l6)
			l6 = j5;
		if(l5 < k6)
			k6 = l5;
		else
		if(l5 > l6)
			l6 = l5;
		if(j6 < k6)
			k6 = j6;
		else
		if(j6 > l6)
			l6 = j6;
		if(k6 < boundsTopY)
			k6 = boundsTopY;
		if(l6 > boundsBottomY)
			l6 = boundsBottomY;
		if(anIntArray340 == null || anIntArray340.length != k1 + 1) {
			anIntArray340 = new int[k1 + 1];
			anIntArray341 = new int[k1 + 1];
			anIntArray342 = new int[k1 + 1];
			anIntArray343 = new int[k1 + 1];
			anIntArray344 = new int[k1 + 1];
			anIntArray345 = new int[k1 + 1];
		}
		for(int i7 = k6; i7 <= l6; i7++) {
			anIntArray340[i7] = 0x5f5e0ff;
			anIntArray341[i7] = 0xfa0a1f01;
		}

		int i8 = 0;
		int k8 = 0;
		int i9 = 0;
		int j9 = anIntArray325[k];
		int k9 = anIntArray326[k];
		i2 = 0;
		j2 = 0;
		i3 = j9 - 1;
		j3 = 0;
		k2 = j9 - 1;
		l2 = k9 - 1;
		k3 = 0;
		l3 = k9 - 1;
		if(j6 != l4) {
			i8 = (i6 - k4 << 8) / (j6 - l4);
			i9 = (l3 - j2 << 8) / (j6 - l4);
		}
		int j7;
		int k7;
		int l7;
		int l8;
		if(l4 > j6) {
			l7 = i6 << 8;
			l8 = l3 << 8;
			j7 = j6;
			k7 = l4;
		} else {
			l7 = k4 << 8;
			l8 = j2 << 8;
			j7 = l4;
			k7 = j6;
		}
		if(j7 < 0) {
			l7 -= i8 * j7;
			l8 -= i9 * j7;
			j7 = 0;
		}
		if(k7 > k1 - 1)
			k7 = k1 - 1;
		for(int l9 = j7; l9 <= k7; l9++) {
			anIntArray340[l9] = anIntArray341[l9] = l7;
			l7 += i8;
			anIntArray342[l9] = anIntArray343[l9] = 0;
			anIntArray344[l9] = anIntArray345[l9] = l8;
			l8 += i9;
		}

		if(j5 != l4) {
			i8 = (i5 - k4 << 8) / (j5 - l4);
			k8 = (i3 - i2 << 8) / (j5 - l4);
		}
		int j8;
		if(l4 > j5) {
			l7 = i5 << 8;
			j8 = i3 << 8;
			j7 = j5;
			k7 = l4;
		} else {
			l7 = k4 << 8;
			j8 = i2 << 8;
			j7 = l4;
			k7 = j5;
		}
		if(j7 < 0) {
			l7 -= i8 * j7;
			j8 -= k8 * j7;
			j7 = 0;
		}
		if(k7 > k1 - 1)
			k7 = k1 - 1;
		for(int i10 = j7; i10 <= k7; i10++) {
			if(l7 < anIntArray340[i10]) {
				anIntArray340[i10] = l7;
				anIntArray342[i10] = j8;
				anIntArray344[i10] = 0;
			}
			if(l7 > anIntArray341[i10]) {
				anIntArray341[i10] = l7;
				anIntArray343[i10] = j8;
				anIntArray345[i10] = 0;
			}
			l7 += i8;
			j8 += k8;
		}

		if(l5 != j5) {
			i8 = (k5 - i5 << 8) / (l5 - j5);
			i9 = (l2 - j3 << 8) / (l5 - j5);
		}
		if(j5 > l5) {
			l7 = k5 << 8;
			j8 = k2 << 8;
			l8 = l2 << 8;
			j7 = l5;
			k7 = j5;
		} else {
			l7 = i5 << 8;
			j8 = i3 << 8;
			l8 = j3 << 8;
			j7 = j5;
			k7 = l5;
		}
		if(j7 < 0) {
			l7 -= i8 * j7;
			l8 -= i9 * j7;
			j7 = 0;
		}
		if(k7 > k1 - 1)
			k7 = k1 - 1;
		for(int j10 = j7; j10 <= k7; j10++) {
			if(l7 < anIntArray340[j10]) {
				anIntArray340[j10] = l7;
				anIntArray342[j10] = j8;
				anIntArray344[j10] = l8;
			}
			if(l7 > anIntArray341[j10]) {
				anIntArray341[j10] = l7;
				anIntArray343[j10] = j8;
				anIntArray345[j10] = l8;
			}
			l7 += i8;
			l8 += i9;
		}

		if(j6 != l5) {
			i8 = (i6 - k5 << 8) / (j6 - l5);
			k8 = (k3 - k2 << 8) / (j6 - l5);
		}
		if(l5 > j6) {
			l7 = i6 << 8;
			j8 = k3 << 8;
			l8 = l3 << 8;
			j7 = j6;
			k7 = l5;
		} else {
			l7 = k5 << 8;
			j8 = k2 << 8;
			l8 = l2 << 8;
			j7 = l5;
			k7 = j6;
		}
		if(j7 < 0) {
			l7 -= i8 * j7;
			j8 -= k8 * j7;
			j7 = 0;
		}
		if(k7 > k1 - 1)
			k7 = k1 - 1;
		for(int k10 = j7; k10 <= k7; k10++) {
			if(l7 < anIntArray340[k10]) {
				anIntArray340[k10] = l7;
				anIntArray342[k10] = j8;
				anIntArray344[k10] = l8;
			}
			if(l7 > anIntArray341[k10]) {
				anIntArray341[k10] = l7;
				anIntArray343[k10] = j8;
				anIntArray345[k10] = l8;
			}
			l7 += i8;
			j8 += k8;
		}

		int l10 = k6 * j1;
		int[] ai = anIntArrayArray328[k];
		for(int i11 = k6; i11 < l6; i11++) {
			int j11 = anIntArray340[i11] >> 8;
			int k11 = anIntArray341[i11] >> 8;
			if(k11 - j11 <= 0) {
				l10 += j1;
			} else {
				int l11 = anIntArray342[i11] << 9;
				int i12 = ((anIntArray343[i11] << 9) - l11) / (k11 - j11);
				int j12 = anIntArray344[i11] << 9;
				int k12 = ((anIntArray345[i11] << 9) - j12) / (k11 - j11);
				if(j11 < boundsTopX) {
					l11 += (boundsTopX - j11) * i12;
					j12 += (boundsTopX - j11) * k12;
					j11 = boundsTopX;
				}
				if(k11 > boundsBottomX)
					k11 = boundsBottomX;
				if(!aBoolean321 || (i11 & 1) == 0)
					if(!aBooleanArray333[k])
						method255(pixels, ai, 0, l10 + j11, l11, j12, i12, k12, j11 - k11, j9);
					else
						method257(pixels, ai, 0, l10 + j11, l11, j12, i12, k12, j11 - k11, j9);
				l10 += j1;
			}
		}

	}

	public void method237(int i, int j, int k, int l, int i1) {
		anIntArray325[i] = l;
		anIntArray326[i] = i1;
		aBooleanArray333[i] = false;
		anIntArray329[i] = 0;
		anIntArray330[i] = 0;
		anIntArray331[i] = l;
		anIntArray332[i] = i1;
		int j1 = l * i1;
		int k1 = 0;
		anIntArrayArray328[i] = new int[j1];
		for(int l1 = j; l1 < j + l; l1++) {
			for(int i2 = k; i2 < k + i1; i2++)
				anIntArrayArray328[i][k1++] = pixels[l1 + i2 * width2];

		}

	}

	public int method238(int i) {
		if(i == 0)
			return 12;
		if(i == 1)
			return 14;
		if(i == 2)
			return 14;
		if(i == 3)
			return 15;
		if(i == 4)
			return 15;
		if(i == 5)
			return 19;
		if(i == 6)
			return 24;
		if(i == 7)
			return 29;
		else
			return method215(i);
	}

	public void method239(String s, int i, int j, int k, int l, int i1) {
		try {
			int j1 = 0;
			byte[] abyte0 = fonts[k];
			int k1 = 0;
			int l1 = 0;
			for(int i2 = 0; i2 < s.length(); i2++) {
				if(s.charAt(i2) == '@' && i2 + 4 < s.length() && s.charAt(i2 + 4) == '@')
					i2 += 4;
				else
				if(s.charAt(i2) == '~' && i2 + 4 < s.length() && s.charAt(i2 + 4) == '~')
					i2 += 4;
				else
					j1 += abyte0[inputFilterCharFontAddr[s.charAt(i2)] + 7];
				if(s.charAt(i2) == ' ')
					l1 = i2;
				if(s.charAt(i2) == '%') {
					l1 = i2;
					j1 = 1000;
				}
				if(j1 > i1) {
					if(l1 <= k1)
						l1 = i2;
					drawStringCenter(s.substring(k1, l1), i, j, k, l);
					j1 = 0;
					k1 = i2 = l1 + 1;
					j += method238(k);
				}
			}

			if(j1 > 0) {
				drawStringCenter(s.substring(k1), i, j, k, l);
            }
		}
		catch(Exception exception) {
			System.out.println("centrepara: " + exception);
			exception.printStackTrace();
		}
	}

	public static void method240(Font font, FontMetrics fontmetrics, char c, int i, GameShell gameshell, int j, boolean flag) {
		int k = fontmetrics.charWidth(c);
		int l = k;
		if(flag)
			try {
				if(c == '/')
					flag = false;
				if(c == 'f' || c == 't' || c == 'w' || c == 'v' || c == 'k' || c == 'x' || c == 'y' || c == 'A' || c == 'V' || c == 'W')
					k++;
			}
			catch(Exception _ex) { }
		int i1 = fontmetrics.getMaxAscent();
		int j1 = fontmetrics.getMaxAscent() + fontmetrics.getMaxDescent();
		int k1 = fontmetrics.getHeight();
		Image image = gameshell.createImage(k, j1);
		Graphics g = image.getGraphics();
		g.setColor(Color.black);
		g.fillRect(0, 0, k, j1);
		g.setColor(Color.white);
		g.setFont(font);
		g.drawString(String.valueOf(c), 0, i1);
		if(flag)
			g.drawString(String.valueOf(c), 1, i1);
		int[] ai = new int[k * j1];
		PixelGrabber pixelgrabber = new PixelGrabber(image, 0, 0, k, j1, ai, 0, k);
		try {
			pixelgrabber.grabPixels();
		}
		catch(InterruptedException _ex) {
			return;
		}
		image.flush();
		image = null;
		int l1 = 0;
		int i2 = 0;
		int j2 = k;
		int k2 = j1;
label0:
		for(int l2 = 0; l2 < j1; l2++) {
			for(int i3 = 0; i3 < k; i3++) {
				int k3 = ai[i3 + l2 * k];
				if((k3 & 0xffffff) == 0)
					continue;
				i2 = l2;
				break label0;
			}

		}

label1:
		for(int j3 = 0; j3 < k; j3++) {
			for(int l3 = 0; l3 < j1; l3++) {
				int j4 = ai[j3 + l3 * k];
				if((j4 & 0xffffff) == 0)
					continue;
				l1 = j3;
				break label1;
			}

		}

label2:
		for(int i4 = j1 - 1; i4 >= 0; i4--) {
			for(int k4 = 0; k4 < k; k4++) {
				int i5 = ai[k4 + i4 * k];
				if((i5 & 0xffffff) == 0)
					continue;
				k2 = i4 + 1;
				break label2;
			}

		}

label3:
		for(int l4 = k - 1; l4 >= 0; l4--) {
			for(int j5 = 0; j5 < j1; j5++) {
				int l5 = ai[l4 + j5 * k];
				if((l5 & 0xffffff) == 0)
					continue;
				j2 = l4 + 1;
				break label3;
			}

		}

		aByteArray346[i * 9] = (byte)(anInt347 / 16384);
		aByteArray346[i * 9 + 1] = (byte)(anInt347 / 128 & 0x7f);
		aByteArray346[i * 9 + 2] = (byte)(anInt347 & 0x7f);
		aByteArray346[i * 9 + 3] = (byte)(j2 - l1);
		aByteArray346[i * 9 + 4] = (byte)(k2 - i2);
		aByteArray346[i * 9 + 5] = (byte)l1;
		aByteArray346[i * 9 + 6] = (byte)(i1 - i2);
		aByteArray346[i * 9 + 7] = (byte)l;
		aByteArray346[i * 9 + 8] = (byte)k1;
		for(int k5 = i2; k5 < k2; k5++) {
			for(int i6 = l1; i6 < j2; i6++) {
				int j6 = ai[i6 + k5 * k] & 0xff;
				if(j6 > 30 && j6 < 230)
					fontAntiAliased[j] = true;
				aByteArray346[anInt347++] = (byte)j6;
			}

		}

	}



	public void drawSurface(Graphics g, int i, int j) {
		setComplete();
		g.drawImage(image, i, j, this);
	}

	private void method242(int[] ai, int[] ai1, int i, int j, int k, int l, int i1,
                           int j1, int k1, int l1, int i2, int j2, int k2, int l2) {
		int i3 = 256 - l2;
		try {
			int j3 = j;
			for(int k3 = -k1; k3 < 0; k3 += k2) {
				int l3 = (k >> 16) * j2;
				for(int i4 = -j1; i4 < 0; i4++) {
					i = ai1[(j >> 16) + l3];
					if(i != 0) {
						int j4 = ai[l];
						ai[l++] = ((i & 0xff00ff) * l2 + (j4 & 0xff00ff) * i3 & 0xff00ff00) + ((i & 0xff00) * l2 + (j4 & 0xff00) * i3 & 0xff0000) >> 8;
					} else {
						l++;
					}
					j += l1;
				}

				k += i2;
				j = j3;
				l += i1;
			}

        }
		catch(Exception _ex) {
			System.out.println("error in tran_scale");
		}
	}

	public void method243(String s, int i, int j, int k, int l) {
		drawString(s, i - textWidth(s, k), j, k, l);
	}

	public void method244() {
		int i = width2 * height2;
		if(!aBoolean321) {
            Arrays.fill(pixels, 0);
			return;
		}
		int k = 0;
		for(int l = -height2; l < 0; l += 2) {
			for(int i1 = -width2; i1 < 0; i1++)
				pixels[k++] = 0;

			k += width2;
		}

	}

	public void spriteClipping(int i, int j, int k, int l, int i1) {
		try {
			int j1 = anIntArray325[i1];
			int k1 = anIntArray326[i1];
			int l1 = 0;
			int i2 = 0;
			int j2 = (j1 << 16) / k;
			int k2 = (k1 << 16) / l;
			if(aBooleanArray333[i1]) {
				int l2 = anIntArray331[i1];
				int j3 = anIntArray332[i1];
				j2 = (l2 << 16) / k;
				k2 = (j3 << 16) / l;
				i += ((anIntArray329[i1] * k + l2) - 1) / l2;
				j += ((anIntArray330[i1] * l + j3) - 1) / j3;
				if((anIntArray329[i1] * k) % l2 != 0)
					l1 = (l2 - (anIntArray329[i1] * k) % l2 << 16) / k;
				if((anIntArray330[i1] * l) % j3 != 0)
					i2 = (j3 - (anIntArray330[i1] * l) % j3 << 16) / l;
				k = (k * (anIntArray325[i1] - (l1 >> 16))) / l2;
				l = (l * (anIntArray326[i1] - (i2 >> 16))) / j3;
			}
			int i3 = i + j * width2;
			int k3 = width2 - k;
			if(j < boundsTopY) {
				int l3 = boundsTopY - j;
				l -= l3;
				j = 0;
				i3 += l3 * width2;
				i2 += k2 * l3;
			}
			if(j + l >= boundsBottomY)
				l -= ((j + l) - boundsBottomY) + 1;
			if(i < boundsTopX) {
				int i4 = boundsTopX - i;
				k -= i4;
				i = 0;
				i3 += i4;
				l1 += j2 * i4;
				k3 += i4;
			}
			if(i + k >= boundsBottomX) {
				int j4 = ((i + k) - boundsBottomX) + 1;
				k -= j4;
				k3 += j4;
			}
			byte byte0 = 1;
			if(aBoolean321) {
				byte0 = 2;
				k3 += width2;
				k2 += k2;
				if((j & 1) != 0) {
					i3 += width2;
					l--;
				}
			}
			method232(pixels, anIntArrayArray328[i1], 0, l1, i2, i3, k3, k, l, j2, k2, j1, byte0);
        }
		catch(Exception _ex) {
			System.out.println("error in sprite clipping routine");
		}
	}

	public void drawSprite(int i, int j, int k) {
		if(aBooleanArray333[k]) {
			i += anIntArray329[k];
			j += anIntArray330[k];
		}
		int l = i + j * width2;
		int i1 = 0;
		int j1 = anIntArray326[k];
		int k1 = anIntArray325[k];
		int l1 = width2 - k1;
		int i2 = 0;
		if(j < boundsTopY) {
			int j2 = boundsTopY - j;
			j1 -= j2;
			j = boundsTopY;
			i1 += j2 * k1;
			l += j2 * width2;
		}
		if(j + j1 >= boundsBottomY)
			j1 -= ((j + j1) - boundsBottomY) + 1;
		if(i < boundsTopX) {
			int k2 = boundsTopX - i;
			k1 -= k2;
			i = boundsTopX;
			i1 += k2;
			l += k2;
			i2 += k2;
			l1 += k2;
		}
		if(i + k1 >= boundsBottomX) {
			int l2 = ((i + k1) - boundsBottomX) + 1;
			k1 -= l2;
			i2 += l2;
			l1 += l2;
		}
		if(k1 <= 0 || j1 <= 0)
			return;
		byte byte0 = 1;
		if(aBoolean321) {
			byte0 = 2;
			l1 += width2;
			i2 += anIntArray325[k];
			if((j & 1) != 0) {
				l += width2;
				j1--;
			}
		}
		if(anIntArrayArray328[k] == null) {
			method233(pixels, aByteArrayArray324[k], anIntArrayArray327[k], i1, l, k1, j1, l1, i2, byte0);
        } else {
			method219(pixels, anIntArrayArray328[k], 0, i1, l, k1, j1, l1, i2, byte0);
        }
	}

	public void method247(int i, int j, int k) {
		if(i < boundsTopX || j < boundsTopY || i >= boundsBottomX || j >= boundsBottomY) {
        } else {
			pixels[i + j * width2] = k;
        }
	}

	public void method248(int i, int j, int k, int l, int i1, int j1) {
		try {
			int k1 = anIntArray325[i1];
			int l1 = anIntArray326[i1];
			int i2 = 0;
			int j2 = 0;
			int k2 = (k1 << 16) / k;
			int l2 = (l1 << 16) / l;
			if(aBooleanArray333[i1]) {
				int i3 = anIntArray331[i1];
				int k3 = anIntArray332[i1];
				k2 = (i3 << 16) / k;
				l2 = (k3 << 16) / l;
				i += ((anIntArray329[i1] * k + i3) - 1) / i3;
				j += ((anIntArray330[i1] * l + k3) - 1) / k3;
				if((anIntArray329[i1] * k) % i3 != 0)
					i2 = (i3 - (anIntArray329[i1] * k) % i3 << 16) / k;
				if((anIntArray330[i1] * l) % k3 != 0)
					j2 = (k3 - (anIntArray330[i1] * l) % k3 << 16) / l;
				k = (k * (anIntArray325[i1] - (i2 >> 16))) / i3;
				l = (l * (anIntArray326[i1] - (j2 >> 16))) / k3;
			}
			int j3 = i + j * width2;
			int l3 = width2 - k;
			if(j < boundsTopY) {
				int i4 = boundsTopY - j;
				l -= i4;
				j = 0;
				j3 += i4 * width2;
				j2 += l2 * i4;
			}
			if(j + l >= boundsBottomY)
				l -= ((j + l) - boundsBottomY) + 1;
			if(i < boundsTopX) {
				int j4 = boundsTopX - i;
				k -= j4;
				i = 0;
				j3 += j4;
				i2 += k2 * j4;
				l3 += j4;
			}
			if(i + k >= boundsBottomX) {
				int k4 = ((i + k) - boundsBottomX) + 1;
				k -= k4;
				l3 += k4;
			}
			byte byte0 = 1;
			if(aBoolean321) {
				byte0 = 2;
				l3 += width2;
				l2 += l2;
				if((j & 1) != 0) {
					j3 += width2;
					l--;
				}
			}
			method230(pixels, anIntArrayArray328[i1], 0, i2, j2, j3, l3, k, l, k2, l2, k1, byte0, j1);
        }
		catch(Exception _ex) {
			System.out.println("error in sprite clipping routine");
		}
	}

	public void method249() {
		for(int i = 0; i < anIntArrayArray328.length; i++) {
			anIntArrayArray328[i] = null;
			anIntArray325[i] = 0;
			anIntArray326[i] = 0;
			aByteArrayArray324[i] = null;
			anIntArrayArray327[i] = null;
		}

	}

	public Surface(int width, int height, int k, Component component) {
		aBoolean321 = false;
		loggedIn = false;
		aComponent314 = component;
		boundsBottomY = height;
		boundsBottomX = width;
		anInt312 = width2 = width;
		anInt313 = height2 = height;
		anInt311 = width * height;
		pixels = new int[width * height];
		anIntArrayArray328 = new int[k][];
		aBooleanArray333 = new boolean[k];
		aByteArrayArray324 = new byte[k][];
		anIntArrayArray327 = new int[k][];
		anIntArray325 = new int[k];
		anIntArray326 = new int[k];
		anIntArray331 = new int[k];
		anIntArray332 = new int[k];
		anIntArray329 = new int[k];
		anIntArray330 = new int[k];
		if(width > 1 && height > 1 && component != null) {
			colorModel = new DirectColorModel(32, 0xff0000, 65280, 255);
			int l = width2 * height2;
			for(int i1 = 0; i1 < l; i1++)
				pixels[i1] = 0;

			image = component.createImage(this);
			setComplete();
			component.prepareImage(image, component);
			setComplete();
			component.prepareImage(image, component);
			setComplete();
			component.prepareImage(image, component);
		}
	}

	public synchronized void addConsumer(ImageConsumer imageconsumer) {
		imageConsumer = imageconsumer;
		imageconsumer.setDimensions(width2, height2);
		imageconsumer.setProperties(null);
		imageconsumer.setColorModel(colorModel);
		imageconsumer.setHints(14);
	}

	public boolean imageUpdate(Image image, int i, int j, int k, int l, int i1) {
		return true;
	}

	public synchronized boolean isConsumer(ImageConsumer imageconsumer) {
		return imageConsumer == imageconsumer;
	}

	public synchronized void removeConsumer(ImageConsumer imageconsumer) {
		if(imageConsumer == imageconsumer)
			imageConsumer = null;
	}

	public void requestTopDownLeftRightResend(ImageConsumer imageconsumer) {
		System.out.println("TDLR");
	}

	public void startProduction(ImageConsumer imageconsumer) {
		addConsumer(imageconsumer);
	}

	private void method250(int[] ai, byte[] abyte0, int i, int j, int k, int l, int i1,
                           int j1, int k1) {
		try {
			int l1 = -(l >> 2);
			l = -(l & 3);
			for(int i2 = -i1; i2 < 0; i2++) {
				for(int j2 = l1; j2 < 0; j2++) {
					if(abyte0[j++] != 0)
						ai[k++] = i;
					else
						k++;
					if(abyte0[j++] != 0)
						ai[k++] = i;
					else
						k++;
					if(abyte0[j++] != 0)
						ai[k++] = i;
					else
						k++;
					if(abyte0[j++] != 0)
						ai[k++] = i;
					else
						k++;
				}

				for(int k2 = l; k2 < 0; k2++)
					if(abyte0[j++] != 0)
						ai[k++] = i;
					else
						k++;

				k += j1;
				j += k1;
			}

        }
		catch(Exception exception) {
			System.out.println("plotletter: " + exception);
			exception.printStackTrace();
        }
	}

	public void drawHorizontalLine(int i, int j, int k, int l) {
		if(j < boundsTopY || j >= boundsBottomY)
			return;
		if(i < boundsTopX) {
			k -= boundsTopX - i;
			i = boundsTopX;
		}
		if(i + k > boundsBottomX)
			k = boundsBottomX - i;
		int i1 = i + j * width2;
		for(int j1 = 0; j1 < k; j1++)
			pixels[i1 + j1] = l;
	}


	public void method252(int i, int j, int k, int l, int i1) {
		anIntArray325[i] = l;
		anIntArray326[i] = i1;
		aBooleanArray333[i] = false;
		anIntArray329[i] = 0;
		anIntArray330[i] = 0;
		anIntArray331[i] = l;
		anIntArray332[i] = i1;
		int j1 = l * i1;
		int k1 = 0;
		anIntArrayArray328[i] = new int[j1];
		for(int l1 = k; l1 < k + i1; l1++) {
			for(int i2 = j; i2 < j + l; i2++)
				anIntArrayArray328[i][k1++] = pixels[i2 + l1 * width2];

		}

	}

	public void resize(int i, int j, int k, int l) {
		if(i < 0)
			i = 0;
		if(j < 0)
			j = 0;
		if(k > width2)
			k = width2;
		if(l > height2)
			l = height2;
		boundsTopX = i;
		boundsTopY = j;
		boundsBottomX = k;
		boundsBottomY = l;
	}

	public void drawString(String text, int x, int y, int font, int color) {
		try {
			byte[] abyte0 = fonts[font];
			for(int i1 = 0; i1 < text.length(); i1++)
				if(text.charAt(i1) == '@' && i1 + 4 < text.length() && text.charAt(i1 + 4) == '@') {
					if(text.substring(i1 + 1, i1 + 4).equalsIgnoreCase("red"))
						color = 0xff0000;
					else
					if(text.substring(i1 + 1, i1 + 4).equalsIgnoreCase("lre"))
						color = 0xff9040;
					else
					if(text.substring(i1 + 1, i1 + 4).equalsIgnoreCase("yel"))
						color = 0xffff00;
					else
					if(text.substring(i1 + 1, i1 + 4).equalsIgnoreCase("gre"))
						color = 65280;
					else
					if(text.substring(i1 + 1, i1 + 4).equalsIgnoreCase("blu"))
						color = 255;
					else
					if(text.substring(i1 + 1, i1 + 4).equalsIgnoreCase("cya"))
						color = 65535;
					else
					if(text.substring(i1 + 1, i1 + 4).equalsIgnoreCase("mag"))
						color = 0xff00ff;
					else
					if(text.substring(i1 + 1, i1 + 4).equalsIgnoreCase("whi"))
						color = 0xffffff;
					else
					if(text.substring(i1 + 1, i1 + 4).equalsIgnoreCase("bla"))
						color = 0;
					else
					if(text.substring(i1 + 1, i1 + 4).equalsIgnoreCase("dre"))
						color = 0xc00000;
					else
					if(text.substring(i1 + 1, i1 + 4).equalsIgnoreCase("ora"))
						color = 0xff9040;
					else
					if(text.substring(i1 + 1, i1 + 4).equalsIgnoreCase("ran"))
						color = (int)(Math.random() * 16777215D);
					else
					if(text.substring(i1 + 1, i1 + 4).equalsIgnoreCase("or1"))
						color = 0xffb000;
					else
					if(text.substring(i1 + 1, i1 + 4).equalsIgnoreCase("or2"))
						color = 0xff7000;
					else
					if(text.substring(i1 + 1, i1 + 4).equalsIgnoreCase("or3"))
						color = 0xff3000;
					else
					if(text.substring(i1 + 1, i1 + 4).equalsIgnoreCase("gr1"))
						color = 0xc0ff00;
					else
					if(text.substring(i1 + 1, i1 + 4).equalsIgnoreCase("gr2"))
						color = 0x80ff00;
					else
					if(text.substring(i1 + 1, i1 + 4).equalsIgnoreCase("gr3"))
						color = 0x40ff00;
					i1 += 4;
				} else if (text.charAt(i1) == '~' && i1 + 4 < text.length() && text.charAt(i1 + 4) == '~') {
					char c = text.charAt(i1 + 1);
					char c1 = text.charAt(i1 + 2);
					char c2 = text.charAt(i1 + 3);
					if(c >= '0' && c <= '9' && c1 >= '0' && c1 <= '9' && c2 >= '0' && c2 <= '9')
						x = Integer.parseInt(text.substring(i1 + 1, i1 + 4));
					i1 += 4;
				}else if (text.charAt(i1) == '~' && i1 + 5 < text.length() && text.charAt(i1 + 5) == '~') {
					char c = text.charAt(i1 + 1);
					char c1 = text.charAt(i1 + 2);
					char c2 = text.charAt(i1 + 3);
					char c3 = text.charAt(i1 + 4);
					if(c >= '0' && c <= '9' && c1 >= '0' && c1 <= '9' && c2 >= '0' && c2 <= '9' && c3 >= '0' && c3 <= '9')
						x = Integer.parseInt(text.substring(i1 + 1, i1 + 5));
					i1 += 5;
				} else {
					int addr = inputFilterCharFontAddr[text.charAt(i1)];
					if(loggedIn && !fontAntiAliased[font] && color != 0)
						drawCharacter(addr, x + 1, y, 0, abyte0, fontAntiAliased[font]);
					if(loggedIn && !fontAntiAliased[font] && color != 0)
						drawCharacter(addr, x, y + 1, 0, abyte0, fontAntiAliased[font]);
					drawCharacter(addr, x, y, color, abyte0, fontAntiAliased[font]);
					x += abyte0[addr + 7];
				}

        }
		catch(Exception exception) {
			System.out.println("drawstring: " + exception);
			exception.printStackTrace();
        }
	}

	private void method255(int[] ai, int[] ai1, int i, int j, int k, int l, int i1,
                           int j1, int k1, int l1) {
		for(i = k1; i < 0; i++) {
			pixels[j++] = ai1[(k >> 17) + (l >> 17) * l1];
			k += i1;
			l += j1;
		}

	}

	public synchronized void setComplete() {
		if(imageConsumer == null) {
        } else {
			imageConsumer.setPixels(0, 0, width2, height2, colorModel, pixels, 0, width2);
			imageConsumer.imageComplete(2);
        }
	}

	private void method257(int[] ai, int[] ai1, int i, int j, int k, int l, int i1,
                           int j1, int k1, int l1) {
		for(int i2 = k1; i2 < 0; i2++) {
			i = ai1[(k >> 17) + (l >> 17) * l1];
			if(i != 0)
				pixels[j++] = i;
			else
				j++;
			k += i1;
			l += j1;
		}

	}

	public void method258(int i, int j, int k, int l, int i1) {
		int j1 = 256 - i1;
		int k1 = (l >> 16 & 0xff) * i1;
		int l1 = (l >> 8 & 0xff) * i1;
		int i2 = (l & 0xff) * i1;
		int i3 = j - k;
		if(i3 < 0)
			i3 = 0;
		int j3 = j + k;
		if(j3 >= height2)
			j3 = height2 - 1;
		byte byte0 = 1;
		if(aBoolean321) {
			byte0 = 2;
			if((i3 & 1) != 0)
				i3++;
		}
		for(int k3 = i3; k3 <= j3; k3 += byte0) {
			int l3 = k3 - j;
			int i4 = (int)Math.sqrt(k * k - l3 * l3);
			int j4 = i - i4;
			if(j4 < 0)
				j4 = 0;
			int k4 = i + i4;
			if(k4 >= width2)
				k4 = width2 - 1;
			int l4 = j4 + k3 * width2;
			for(int i5 = j4; i5 <= k4; i5++) {
				int j2 = (pixels[l4] >> 16 & 0xff) * j1;
				int k2 = (pixels[l4] >> 8 & 0xff) * j1;
				int l2 = (pixels[l4] & 0xff) * j1;
				int j5 = ((k1 + j2 >> 8) << 16) + ((l1 + k2 >> 8) << 8) + (i2 + l2 >> 8);
				pixels[l4++] = j5;
			}

		}

	}

	public void method260(int i, int j, int k, int l) {
		if(aBooleanArray333[k]) {
			i += anIntArray329[k];
			j += anIntArray330[k];
		}
		int i1 = i + j * width2;
		int j1 = 0;
		int k1 = anIntArray326[k];
		int l1 = anIntArray325[k];
		int i2 = width2 - l1;
		int j2 = 0;
		if(j < boundsTopY) {
			int k2 = boundsTopY - j;
			k1 -= k2;
			j = boundsTopY;
			j1 += k2 * l1;
			i1 += k2 * width2;
		}
		if(j + k1 >= boundsBottomY)
			k1 -= ((j + k1) - boundsBottomY) + 1;
		if(i < boundsTopX) {
			int l2 = boundsTopX - i;
			l1 -= l2;
			i = boundsTopX;
			j1 += l2;
			i1 += l2;
			j2 += l2;
			i2 += l2;
		}
		if(i + l1 >= boundsBottomX) {
			int i3 = ((i + l1) - boundsBottomX) + 1;
			l1 -= i3;
			j2 += i3;
			i2 += i3;
		}
		if(l1 <= 0 || k1 <= 0)
			return;
		byte byte0 = 1;
		if(aBoolean321) {
			byte0 = 2;
			i2 += width2;
			j2 += anIntArray325[k];
			if((j & 1) != 0) {
				i1 += width2;
				k1--;
			}
		}
		if(anIntArrayArray328[k] == null) {
			method261(pixels, aByteArrayArray324[k], anIntArrayArray327[k], j1, i1, l1, k1, i2, j2, byte0, l);
        } else {
			method208(pixels, anIntArrayArray328[k], 0, j1, i1, l1, k1, i2, j2, byte0, l);
        }
	}

	private void method261(int[] ai, byte[] abyte0, int[] ai1, int i, int j, int k, int l,
                           int i1, int j1, int k1, int l1) {
		int i2 = 256 - l1;
		for(int j2 = -l; j2 < 0; j2 += k1) {
			for(int k2 = -k; k2 < 0; k2++) {
				int l2 = abyte0[i++];
				if(l2 != 0) {
					l2 = ai1[l2 & 0xff];
					int i3 = ai[j];
					ai[j++] = ((l2 & 0xff00ff) * l1 + (i3 & 0xff00ff) * i2 & 0xff00ff00) + ((l2 & 0xff00) * l1 + (i3 & 0xff00) * i2 & 0xff0000) >> 8;
				} else {
					j++;
				}
			}

			j += i1;
			i += j1;
		}

	}

	public void method262(int i, int j, int k, int l, int i1, int j1) {
		try {
			int k1 = anIntArray325[i1];
			int l1 = anIntArray326[i1];
			int i2 = 0;
			int j2 = 0;
			int k2 = (k1 << 16) / k;
			int l2 = (l1 << 16) / l;
			if(aBooleanArray333[i1]) {
				int i3 = anIntArray331[i1];
				int k3 = anIntArray332[i1];
				k2 = (i3 << 16) / k;
				l2 = (k3 << 16) / l;
				i += ((anIntArray329[i1] * k + i3) - 1) / i3;
				j += ((anIntArray330[i1] * l + k3) - 1) / k3;
				if((anIntArray329[i1] * k) % i3 != 0)
					i2 = (i3 - (anIntArray329[i1] * k) % i3 << 16) / k;
				if((anIntArray330[i1] * l) % k3 != 0)
					j2 = (k3 - (anIntArray330[i1] * l) % k3 << 16) / l;
				k = (k * (anIntArray325[i1] - (i2 >> 16))) / i3;
				l = (l * (anIntArray326[i1] - (j2 >> 16))) / k3;
			}
			int j3 = i + j * width2;
			int l3 = width2 - k;
			if(j < boundsTopY) {
				int i4 = boundsTopY - j;
				l -= i4;
				j = 0;
				j3 += i4 * width2;
				j2 += l2 * i4;
			}
			if(j + l >= boundsBottomY)
				l -= ((j + l) - boundsBottomY) + 1;
			if(i < boundsTopX) {
				int j4 = boundsTopX - i;
				k -= j4;
				i = 0;
				j3 += j4;
				i2 += k2 * j4;
				l3 += j4;
			}
			if(i + k >= boundsBottomX) {
				int k4 = ((i + k) - boundsBottomX) + 1;
				k -= k4;
				l3 += k4;
			}
			byte byte0 = 1;
			if(aBoolean321) {
				byte0 = 2;
				l3 += width2;
				l2 += l2;
				if((j & 1) != 0) {
					j3 += width2;
					l--;
				}
			}
			method242(pixels, anIntArrayArray328[i1], 0, i2, j2, j3, l3, k, l, k2, l2, k1, byte0, j1);
        }
		catch(Exception _ex) {
			System.out.println("error in sprite clipping routine");
		}
	}

	public int anInt311;
	public int anInt312;
	public int anInt313;
	private final Component aComponent314;
	public static int anInt315;
	private int boundsTopX;
	private int boundsTopY;
	private int boundsBottomX;
	private int boundsBottomY;
	public int width2;
	public boolean aBoolean321;
	public static int[] pixels;
	public int height2;
	public byte[][] aByteArrayArray324;
	public int[] anIntArray325;
	public int[] anIntArray326;
	public int[][] anIntArrayArray327;
	public int[][] anIntArrayArray328;
	public int[] anIntArray329;
	public int[] anIntArray330;
	public int[] anIntArray331;
	public int[] anIntArray332;
	public boolean[] aBooleanArray333;
	static byte[][] fonts = new byte[50][];
	static int[] inputFilterCharFontAddr;
	int[] anIntArray336;
	public static int anInt337;
	public static int anInt338;
	public static int anInt339;
	int[] anIntArray340;
	int[] anIntArray341;
	int[] anIntArray342;
	int[] anIntArray343;
	int[] anIntArray344;
	int[] anIntArray345;
	private static final byte[] aByteArray346 = new byte[0x186a0];
	private static int anInt347;
	private static final boolean[] fontAntiAliased = new boolean[12];
	public static Image image;
	ImageConsumer imageConsumer;
	ColorModel colorModel;
	public boolean loggedIn;

	static  {
		String s = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"\243$%^&*()-_=+[{]};:'@#~,<.>/?\\| ";
		inputFilterCharFontAddr = new int[256];
		for(int i = 0; i < 256; i++) {
			int j = s.indexOf(i);
			if(j == -1)
				j = 74;
			inputFilterCharFontAddr[i] = j * 9;
		}

	}
}
