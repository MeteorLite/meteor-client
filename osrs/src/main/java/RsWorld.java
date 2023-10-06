// Decompiled by Jad v1.5.8c. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

import java.io.IOException;

public class RsWorld {

	public void method390(int i, int j, int k) {
		if(i < 0 || j < 0 || i >= 95 || j >= 95)
			return;
		if(Definitions.anIntArray112[k] == 1 || Definitions.anIntArray112[k] == 2) {
			int l = method407(i, j);
			int i1;
			int j1;
			if(l == 0 || l == 4) {
				i1 = Definitions.anIntArray110[k];
				j1 = Definitions.anIntArray111[k];
			} else {
				j1 = Definitions.anIntArray110[k];
				i1 = Definitions.anIntArray111[k];
			}
			for(int k1 = i; k1 < i + i1; k1++) {
				for(int l1 = j; l1 < j + j1; l1++)
					if(Definitions.anIntArray112[k] == 1)
						anIntArrayArray573[k1][l1] &= 0xffbf;
					else
					if(l == 0) {
						anIntArrayArray573[k1][l1] &= 0xfffd;
						if(k1 > 0)
							method408(k1 - 1, l1, 8);
					} else
					if(l == 2) {
						anIntArrayArray573[k1][l1] &= 0xfffb;
						if(l1 < 95)
							method408(k1, l1 + 1, 1);
					} else
					if(l == 4) {
						anIntArrayArray573[k1][l1] &= 0xfff7;
						if(k1 < 95)
							method408(k1 + 1, l1, 2);
					} else
					if(l == 6) {
						anIntArrayArray573[k1][l1] &= 0xfffe;
						if(l1 > 0)
							method408(k1, l1 - 1, 4);
					}

			}

			method392(i, j, i1, j1);
		}
	}

	public void method391(int i, int j, int k, int l) {
		if(i < 0 || j < 0 || i >= 95 || j >= 95)
			return;
		if(Definitions.anIntArray122[l] == 1) {
			if(k == 0) {
				anIntArrayArray573[i][j] &= 0xfffe;
				if(j > 0)
					method408(i, j - 1, 4);
			} else
			if(k == 1) {
				anIntArrayArray573[i][j] &= 0xfffd;
				if(i > 0)
					method408(i - 1, j, 8);
			} else
			if(k == 2)
				anIntArrayArray573[i][j] &= 0xffef;
			else
			if(k == 3)
				anIntArrayArray573[i][j] &= 0xffdf;
			method392(i, j, 1, 1);
		}
	}

	public void method392(int i, int j, int k, int l) {
		if(i < 1 || j < 1 || i + k >= 96 || j + l >= 96)
			return;
		for(int i1 = i; i1 <= i + k; i1++) {
			for(int j1 = j; j1 <= j + l; j1++)
				if((method404(i1, j1) & 0x63) != 0 || (method404(i1 - 1, j1) & 0x59) != 0 || (method404(i1, j1 - 1) & 0x56) != 0 || (method404(i1 - 1, j1 - 1) & 0x6c) != 0)
					method403(i1, j1, 35);
				else
					method403(i1, j1, 0);

		}

	}

	public void method393(Model model, int i, int j, int k, int l, int i1) {
		method403(j, k, 40);
		method403(l, i1, 40);
		int j1 = Definitions.anIntArray119[i];
		int k1 = Definitions.anIntArray120[i];
		int l1 = Definitions.anIntArray121[i];
		int i2 = j * 128;
		int j2 = k * 128;
		int k2 = l * 128;
		int l2 = i1 * 128;
		int i3 = model.method198(i2, -anIntArrayArray574[j][k], j2);
		int j3 = model.method198(i2, -anIntArrayArray574[j][k] - j1, j2);
		int k3 = model.method198(k2, -anIntArrayArray574[l][i1] - j1, l2);
		int l3 = model.method198(k2, -anIntArrayArray574[l][i1], l2);
		int ai[] = {
			i3, j3, k3, l3
		};
		int i4 = model.method184(4, ai, k1, l1);
		if(Definitions.anIntArray123[i] == 5) {
			model.anIntArray265[i4] = 30000 + i;
			return;
		} else {
			model.anIntArray265[i4] = 0;
			return;
		}
	}

	public void method394(int i, int j, int k, int l, int i1) {
		int j1 = i * 3;
		int k1 = j * 3;
		int l1 = aScene575.method269(l);
		int i2 = aScene575.method269(i1);
		l1 = l1 >> 1 & 0x7f7f7f;
		i2 = i2 >> 1 & 0x7f7f7f;
		if(k == 0) {
			aSurface576.method251(j1, k1, 3, l1);
			aSurface576.method251(j1, k1 + 1, 2, l1);
			aSurface576.method251(j1, k1 + 2, 1, l1);
			aSurface576.method251(j1 + 2, k1 + 1, 1, i2);
			aSurface576.method251(j1 + 1, k1 + 2, 2, i2);
			return;
		}
		if(k == 1) {
			aSurface576.method251(j1, k1, 3, i2);
			aSurface576.method251(j1 + 1, k1 + 1, 2, i2);
			aSurface576.method251(j1 + 2, k1 + 2, 1, i2);
			aSurface576.method251(j1, k1 + 1, 1, l1);
			aSurface576.method251(j1, k1 + 2, 2, l1);
		}
	}

	public int method395(int i, int j) {
		if(i < 0 || i >= 96 || j < 0 || j >= 96)
			return 0;
		byte byte0 = 0;
		if(i >= 48 && j < 48) {
			byte0 = 1;
			i -= 48;
		} else
		if(i < 48 && j >= 48) {
			byte0 = 2;
			j -= 48;
		} else
		if(i >= 48 && j >= 48) {
			byte0 = 3;
			i -= 48;
			j -= 48;
		}
		return (aByteArrayArray577[byte0][i * 48 + j] & 0xff) * 3;
	}

	public void method396(int i, int j, int k, int l, int i1) {
		Model model = aModelArray578[i + j * 8];
		for(int j1 = 0; j1 < model.anInt236; j1++)
			if(model.anIntArray246[j1] == k * 128 && model.anIntArray248[j1] == l * 128) {
				model.method196(j1, i1);
				return;
			}

	}

	public void method397() {
		for(int i = 0; i < 96; i++) {
			for(int j = 0; j < 96; j++)
				if(method417(i, j, 0) == 250)
					if(i == 47 && method417(i + 1, j, 0) != 250 && method417(i + 1, j, 0) != 2)
						method411(i, j, 9);
					else
					if(j == 47 && method417(i, j + 1, 0) != 250 && method417(i, j + 1, 0) != 2)
						method411(i, j, 9);
					else
						method411(i, j, 2);

		}

	}

	public int method398(int i, int j, int k, int l, int i1, int j1, int ai[], 
			int ai1[], boolean flag) {
		for(int k1 = 0; k1 < 96; k1++) {
			for(int l1 = 0; l1 < 96; l1++)
				anIntArrayArray579[k1][l1] = 0;

		}

		int i2 = 0;
		int j2 = 0;
		int k2 = i;
		int l2 = j;
		anIntArrayArray579[i][j] = 99;
		ai[i2] = i;
		ai1[i2++] = j;
		int i3 = ai.length;
		boolean flag1 = false;
		while(j2 != i2)  {
			k2 = ai[j2];
			l2 = ai1[j2];
			j2 = (j2 + 1) % i3;
			if(k2 >= k && k2 <= i1 && l2 >= l && l2 <= j1) {
				flag1 = true;
				break;
			}
			if(flag) {
				if(k2 > 0 && k2 - 1 >= k && k2 - 1 <= i1 && l2 >= l && l2 <= j1 && (anIntArrayArray573[k2 - 1][l2] & 8) == 0) {
					flag1 = true;
					break;
				}
				if(k2 < 95 && k2 + 1 >= k && k2 + 1 <= i1 && l2 >= l && l2 <= j1 && (anIntArrayArray573[k2 + 1][l2] & 2) == 0) {
					flag1 = true;
					break;
				}
				if(l2 > 0 && k2 >= k && k2 <= i1 && l2 - 1 >= l && l2 - 1 <= j1 && (anIntArrayArray573[k2][l2 - 1] & 4) == 0) {
					flag1 = true;
					break;
				}
				if(l2 < 95 && k2 >= k && k2 <= i1 && l2 + 1 >= l && l2 + 1 <= j1 && (anIntArrayArray573[k2][l2 + 1] & 1) == 0) {
					flag1 = true;
					break;
				}
			}
			if(k2 > 0 && anIntArrayArray579[k2 - 1][l2] == 0 && (anIntArrayArray573[k2 - 1][l2] & 0x78) == 0) {
				ai[i2] = k2 - 1;
				ai1[i2] = l2;
				i2 = (i2 + 1) % i3;
				anIntArrayArray579[k2 - 1][l2] = 2;
			}
			if(k2 < 95 && anIntArrayArray579[k2 + 1][l2] == 0 && (anIntArrayArray573[k2 + 1][l2] & 0x72) == 0) {
				ai[i2] = k2 + 1;
				ai1[i2] = l2;
				i2 = (i2 + 1) % i3;
				anIntArrayArray579[k2 + 1][l2] = 8;
			}
			if(l2 > 0 && anIntArrayArray579[k2][l2 - 1] == 0 && (anIntArrayArray573[k2][l2 - 1] & 0x74) == 0) {
				ai[i2] = k2;
				ai1[i2] = l2 - 1;
				i2 = (i2 + 1) % i3;
				anIntArrayArray579[k2][l2 - 1] = 1;
			}
			if(l2 < 95 && anIntArrayArray579[k2][l2 + 1] == 0 && (anIntArrayArray573[k2][l2 + 1] & 0x71) == 0) {
				ai[i2] = k2;
				ai1[i2] = l2 + 1;
				i2 = (i2 + 1) % i3;
				anIntArrayArray579[k2][l2 + 1] = 4;
			}
			if(k2 > 0 && l2 > 0 && (anIntArrayArray573[k2][l2 - 1] & 0x74) == 0 && (anIntArrayArray573[k2 - 1][l2] & 0x78) == 0 && (anIntArrayArray573[k2 - 1][l2 - 1] & 0x7c) == 0 && anIntArrayArray579[k2 - 1][l2 - 1] == 0) {
				ai[i2] = k2 - 1;
				ai1[i2] = l2 - 1;
				i2 = (i2 + 1) % i3;
				anIntArrayArray579[k2 - 1][l2 - 1] = 3;
			}
			if(k2 < 95 && l2 > 0 && (anIntArrayArray573[k2][l2 - 1] & 0x74) == 0 && (anIntArrayArray573[k2 + 1][l2] & 0x72) == 0 && (anIntArrayArray573[k2 + 1][l2 - 1] & 0x76) == 0 && anIntArrayArray579[k2 + 1][l2 - 1] == 0) {
				ai[i2] = k2 + 1;
				ai1[i2] = l2 - 1;
				i2 = (i2 + 1) % i3;
				anIntArrayArray579[k2 + 1][l2 - 1] = 9;
			}
			if(k2 > 0 && l2 < 95 && (anIntArrayArray573[k2][l2 + 1] & 0x71) == 0 && (anIntArrayArray573[k2 - 1][l2] & 0x78) == 0 && (anIntArrayArray573[k2 - 1][l2 + 1] & 0x79) == 0 && anIntArrayArray579[k2 - 1][l2 + 1] == 0) {
				ai[i2] = k2 - 1;
				ai1[i2] = l2 + 1;
				i2 = (i2 + 1) % i3;
				anIntArrayArray579[k2 - 1][l2 + 1] = 6;
			}
			if(k2 < 95 && l2 < 95 && (anIntArrayArray573[k2][l2 + 1] & 0x71) == 0 && (anIntArrayArray573[k2 + 1][l2] & 0x72) == 0 && (anIntArrayArray573[k2 + 1][l2 + 1] & 0x73) == 0 && anIntArrayArray579[k2 + 1][l2 + 1] == 0) {
				ai[i2] = k2 + 1;
				ai1[i2] = l2 + 1;
				i2 = (i2 + 1) % i3;
				anIntArrayArray579[k2 + 1][l2 + 1] = 12;
			}
		}
		if(!flag1)
			return -1;
		j2 = 0;
		ai[j2] = k2;
		ai1[j2++] = l2;
		int k3;
		for(int j3 = k3 = anIntArrayArray579[k2][l2]; k2 != i || l2 != j; j3 = anIntArrayArray579[k2][l2]) {
			if(j3 != k3) {
				k3 = j3;
				ai[j2] = k2;
				ai1[j2++] = l2;
			}
			if((j3 & 2) != 0)
				k2++;
			else
			if((j3 & 8) != 0)
				k2--;
			if((j3 & 1) != 0)
				l2++;
			else
			if((j3 & 4) != 0)
				l2--;
		}

		return j2;
	}

	public void method399(int i, int j, int k) {
		method422();
		int l = (i + 24) / 48;
		int i1 = (j + 24) / 48;
		method418(i, j, k, true);
		if(k == 0) {
			method418(i, j, 1, false);
			method418(i, j, 2, false);
			method415(l - 1, i1 - 1, k, 0);
			method415(l, i1 - 1, k, 1);
			method415(l - 1, i1, k, 2);
			method415(l, i1, k, 3);
			method397();
		}
	}

	public void method400(int i, int j, int k) {
		if(i < 0 || j < 0 || i >= 95 || j >= 95)
			return;
		if(Definitions.anIntArray112[k] == 1 || Definitions.anIntArray112[k] == 2) {
			int l = method407(i, j);
			int i1;
			int j1;
			if(l == 0 || l == 4) {
				i1 = Definitions.anIntArray110[k];
				j1 = Definitions.anIntArray111[k];
			} else {
				j1 = Definitions.anIntArray110[k];
				i1 = Definitions.anIntArray111[k];
			}
			for(int k1 = i; k1 < i + i1; k1++) {
				for(int l1 = j; l1 < j + j1; l1++)
					if(Definitions.anIntArray112[k] == 1)
						anIntArrayArray573[k1][l1] |= 0x40;
					else
					if(l == 0) {
						anIntArrayArray573[k1][l1] |= 2;
						if(k1 > 0)
							method412(k1 - 1, l1, 8);
					} else
					if(l == 2) {
						anIntArrayArray573[k1][l1] |= 4;
						if(l1 < 95)
							method412(k1, l1 + 1, 1);
					} else
					if(l == 4) {
						anIntArrayArray573[k1][l1] |= 8;
						if(k1 < 95)
							method412(k1 + 1, l1, 2);
					} else
					if(l == 6) {
						anIntArrayArray573[k1][l1] |= 1;
						if(l1 > 0)
							method412(k1, l1 - 1, 4);
					}

			}

			method392(i, j, i1, j1);
		}
	}

	public void method401(int i, int j, int k, int l) {
		if(i < 0 || j < 0 || i >= 95 || j >= 95)
			return;
		if(Definitions.anIntArray122[l] == 1) {
			if(k == 0) {
				anIntArrayArray573[i][j] |= 1;
				if(j > 0)
					method412(i, j - 1, 4);
			} else
			if(k == 1) {
				anIntArrayArray573[i][j] |= 2;
				if(i > 0)
					method412(i - 1, j, 8);
			} else
			if(k == 2)
				anIntArrayArray573[i][j] |= 0x10;
			else
			if(k == 3)
				anIntArrayArray573[i][j] |= 0x20;
			method392(i, j, 1, 1);
		}
	}

	public void method402(Model amodel[]) {
		for(int i = 0; i < 94; i++) {
			for(int j = 0; j < 94; j++)
				if(method419(i, j) > 48000 && method419(i, j) < 60000) {
					int k = method419(i, j) - 48001;
					int l = method407(i, j);
					int i1;
					int j1;
					if(l == 0 || l == 4) {
						i1 = Definitions.anIntArray110[k];
						j1 = Definitions.anIntArray111[k];
					} else {
						j1 = Definitions.anIntArray110[k];
						i1 = Definitions.anIntArray111[k];
					}
					method400(i, j, k);
					Model model = amodel[Definitions.anIntArray109[k]].method192(false, true, false, false);
					int k1 = ((i + i + i1) * 128) / 2;
					int i2 = ((j + j + j1) * 128) / 2;
					model.method197(k1, -method410(k1, i2), i2);
					model.method203(0, method407(i, j) * 32, 0);
					aScene575.method305(model);
					model.method199(48, 48, -50, -10, -50);
					if(i1 > 1 || j1 > 1) {
						for(int k2 = i; k2 < i + i1; k2++) {
							for(int l2 = j; l2 < j + j1; l2++)
								if((k2 > i || l2 > j) && method419(k2, l2) - 48001 == k) {
									int l1 = k2;
									int j2 = l2;
									byte byte0 = 0;
									if(l1 >= 48 && j2 < 48) {
										byte0 = 1;
										l1 -= 48;
									} else
									if(l1 < 48 && j2 >= 48) {
										byte0 = 2;
										j2 -= 48;
									} else
									if(l1 >= 48 && j2 >= 48) {
										byte0 = 3;
										l1 -= 48;
										j2 -= 48;
									}
									anIntArrayArray580[byte0][l1 * 48 + j2] = 0;
								}

						}

					}
				}

		}

	}

	public void method403(int i, int j, int k) {
		int l = i / 12;
		int i1 = j / 12;
		int j1 = (i - 1) / 12;
		int k1 = (j - 1) / 12;
		method396(l, i1, i, j, k);
		if(l != j1)
			method396(j1, i1, i, j, k);
		if(i1 != k1)
			method396(l, k1, i, j, k);
		if(l != j1 && i1 != k1)
			method396(j1, k1, i, j, k);
	}

	public int method404(int i, int j) {
		if(i < 0 || j < 0 || i >= 96 || j >= 96)
			return 0;
		else
			return anIntArrayArray573[i][j];
	}

	public int method405(int i, int j) {
		if(i < 0 || i >= 96 || j < 0 || j >= 96)
			return 0;
		byte byte0 = 0;
		if(i >= 48 && j < 48) {
			byte0 = 1;
			i -= 48;
		} else
		if(i < 48 && j >= 48) {
			byte0 = 2;
			j -= 48;
		} else
		if(i >= 48 && j >= 48) {
			byte0 = 3;
			i -= 48;
			j -= 48;
		}
		return aByteArrayArray581[byte0][i * 48 + j] & 0xff;
	}

	public int method406(int i, int j) {
		if(i < 0 || i >= 96 || j < 0 || j >= 96)
			return 0;
		byte byte0 = 0;
		if(i >= 48 && j < 48) {
			byte0 = 1;
			i -= 48;
		} else
		if(i < 48 && j >= 48) {
			byte0 = 2;
			j -= 48;
		} else
		if(i >= 48 && j >= 48) {
			byte0 = 3;
			i -= 48;
			j -= 48;
		}
		return aByteArrayArray582[byte0][i * 48 + j] & 0xff;
	}

	public int method407(int i, int j) {
		if(i < 0 || i >= 96 || j < 0 || j >= 96)
			return 0;
		byte byte0 = 0;
		if(i >= 48 && j < 48) {
			byte0 = 1;
			i -= 48;
		} else
		if(i < 48 && j >= 48) {
			byte0 = 2;
			j -= 48;
		} else
		if(i >= 48 && j >= 48) {
			byte0 = 3;
			i -= 48;
			j -= 48;
		}
		return aByteArrayArray583[byte0][i * 48 + j];
	}

	public void method408(int i, int j, int k) {
		anIntArrayArray573[i][j] &= 65535 - k;
	}

	public int method409(int i, int j) {
		if(i < 0 || i >= 96 || j < 0 || j >= 96)
			return 0;
		byte byte0 = 0;
		if(i >= 48 && j < 48) {
			byte0 = 1;
			i -= 48;
		} else
		if(i < 48 && j >= 48) {
			byte0 = 2;
			j -= 48;
		} else
		if(i >= 48 && j >= 48) {
			byte0 = 3;
			i -= 48;
			j -= 48;
		}
		return aByteArrayArray584[byte0][i * 48 + j] & 0xff;
	}

	public int method410(int i, int j) {
		int k = i >> 7;
		int l = j >> 7;
		int i1 = i & 0x7f;
		int j1 = j & 0x7f;
		if(k < 0 || l < 0 || k >= 95 || l >= 95)
			return 0;
		int k1;
		int l1;
		int i2;
		if(i1 <= 128 - j1) {
			k1 = method395(k, l);
			l1 = method395(k + 1, l) - k1;
			i2 = method395(k, l + 1) - k1;
		} else {
			k1 = method395(k + 1, l + 1);
			l1 = method395(k, l + 1) - k1;
			i2 = method395(k + 1, l) - k1;
			i1 = 128 - i1;
			j1 = 128 - j1;
		}
		int j2 = k1 + (l1 * i1) / 128 + (i2 * j1) / 128;
		return j2;
	}

	public void method411(int i, int j, int k) {
		if(i < 0 || i >= 96 || j < 0 || j >= 96)
			return;
		byte byte0 = 0;
		if(i >= 48 && j < 48) {
			byte0 = 1;
			i -= 48;
		} else
		if(i < 48 && j >= 48) {
			byte0 = 2;
			j -= 48;
		} else
		if(i >= 48 && j >= 48) {
			byte0 = 3;
			i -= 48;
			j -= 48;
		}
		aByteArrayArray585[byte0][i * 48 + j] = (byte)k;
	}

	public void method412(int i, int j, int k) {
		anIntArrayArray573[i][j] |= k;
	}

	public int method413(int i, int j, int k, int l) {
		int i1 = method417(i, j, k);
		if(i1 == 0)
			return l;
		else
			return Definitions.anIntArray128[i1 - 1];
	}

	public void method414(int i, int j, int k, int l, int i1) {
		int j1 = Definitions.anIntArray119[i];
		if(anIntArrayArray574[j][k] < 0x13880)
			anIntArrayArray574[j][k] += 0x13880 + j1;
		if(anIntArrayArray574[l][i1] < 0x13880)
			anIntArrayArray574[l][i1] += 0x13880 + j1;
	}

	public void method415(int i, int j, int k, int l) {
		String s = "m" + k + i / 10 + i % 10 + j / 10 + j % 10;
		int i1;
		try {
			if(aByteArray586 != null) {
				byte abyte0[] = DataUtils.loadData(s + ".hei", 0, aByteArray586);
				if(abyte0 == null && aByteArray587 != null)
					abyte0 = DataUtils.loadData(s + ".hei", 0, aByteArray587);
				if(abyte0 != null && abyte0.length > 0) {
					int j1 = 0;
					int k2 = 0;
					for(int j3 = 0; j3 < 2304;) {
						int i4 = abyte0[j1++] & 0xff;
						if(i4 < 128) {
							aByteArrayArray577[l][j3++] = (byte)i4;
							k2 = i4;
						}
						if(i4 >= 128) {
							for(int i5 = 0; i5 < i4 - 128; i5++)
								aByteArrayArray577[l][j3++] = (byte)k2;

						}
					}

					k2 = 64;
					for(int j4 = 0; j4 < 48; j4++) {
						for(int j5 = 0; j5 < 48; j5++) {
							k2 = aByteArrayArray577[l][j5 * 48 + j4] + k2 & 0x7f;
							aByteArrayArray577[l][j5 * 48 + j4] = (byte)(k2 * 2);
						}

					}

					k2 = 0;
					for(int k5 = 0; k5 < 2304;) {
						int j6 = abyte0[j1++] & 0xff;
						if(j6 < 128) {
							aByteArrayArray581[l][k5++] = (byte)j6;
							k2 = j6;
						}
						if(j6 >= 128) {
							for(int k7 = 0; k7 < j6 - 128; k7++)
								aByteArrayArray581[l][k5++] = (byte)k2;

						}
					}

					k2 = 35;
					for(int k6 = 0; k6 < 48; k6++) {
						for(int l7 = 0; l7 < 48; l7++) {
							k2 = aByteArrayArray581[l][l7 * 48 + k6] + k2 & 0x7f;
							aByteArrayArray581[l][l7 * 48 + k6] = (byte)(k2 * 2);
						}

					}

				} else {
					for(int k1 = 0; k1 < 2304; k1++) {
						aByteArrayArray577[l][k1] = 0;
						aByteArrayArray581[l][k1] = 0;
					}

				}
				abyte0 = DataUtils.loadData(s + ".dat", 0, aByteArray588);
				if(abyte0 == null && aByteArray589 != null)
					abyte0 = DataUtils.loadData(s + ".dat", 0, aByteArray589);
				if(abyte0 == null || abyte0.length == 0)
					throw new IOException();
				int l1 = 0;
				for(int l2 = 0; l2 < 2304; l2++)
					aByteArrayArray582[l][l2] = abyte0[l1++];

				for(int k3 = 0; k3 < 2304; k3++)
					aByteArrayArray584[l][k3] = abyte0[l1++];

				for(int k4 = 0; k4 < 2304; k4++)
					anIntArrayArray580[l][k4] = abyte0[l1++] & 0xff;

				for(int l5 = 0; l5 < 2304; l5++) {
					int l6 = abyte0[l1++] & 0xff;
					if(l6 > 0)
						anIntArrayArray580[l][l5] = l6 + 12000;
				}

				for(int i7 = 0; i7 < 2304;) {
					int i8 = abyte0[l1++] & 0xff;
					if(i8 < 128) {
						aByteArrayArray590[l][i7++] = (byte)i8;
					} else {
						for(int l8 = 0; l8 < i8 - 128; l8++)
							aByteArrayArray590[l][i7++] = 0;

					}
				}

				int j8 = 0;
				for(int i9 = 0; i9 < 2304;) {
					int k9 = abyte0[l1++] & 0xff;
					if(k9 < 128) {
						aByteArrayArray585[l][i9++] = (byte)k9;
						j8 = k9;
					} else {
						for(int j10 = 0; j10 < k9 - 128; j10++)
							aByteArrayArray585[l][i9++] = (byte)j8;

					}
				}

				for(int l9 = 0; l9 < 2304;) {
					int k10 = abyte0[l1++] & 0xff;
					if(k10 < 128) {
						aByteArrayArray583[l][l9++] = (byte)k10;
					} else {
						for(int j11 = 0; j11 < k10 - 128; j11++)
							aByteArrayArray583[l][l9++] = 0;

					}
				}

				abyte0 = DataUtils.loadData(s + ".loc", 0, aByteArray588);
				if(abyte0 != null && abyte0.length > 0) {
					int i2 = 0;
					for(int l10 = 0; l10 < 2304;) {
						int k11 = abyte0[i2++] & 0xff;
						if(k11 < 128)
							anIntArrayArray580[l][l10++] = k11 + 48000;
						else
							l10 += k11 - 128;
					}

					return;
				}
			} else {
				byte abyte1[] = new byte[20736];
				DataUtils.method354("../gamedata/maps/" + s + ".jm", abyte1, 20736);
				int j2 = 0;
				int i3 = 0;
				for(int l3 = 0; l3 < 2304; l3++) {
					j2 = j2 + abyte1[i3++] & 0xff;
					aByteArrayArray577[l][l3] = (byte)j2;
				}

				j2 = 0;
				for(int l4 = 0; l4 < 2304; l4++) {
					j2 = j2 + abyte1[i3++] & 0xff;
					aByteArrayArray581[l][l4] = (byte)j2;
				}

				for(int i6 = 0; i6 < 2304; i6++)
					aByteArrayArray582[l][i6] = abyte1[i3++];

				for(int j7 = 0; j7 < 2304; j7++)
					aByteArrayArray584[l][j7] = abyte1[i3++];

				for(int k8 = 0; k8 < 2304; k8++) {
					anIntArrayArray580[l][k8] = (abyte1[i3] & 0xff) * 256 + (abyte1[i3 + 1] & 0xff);
					i3 += 2;
				}

				for(int j9 = 0; j9 < 2304; j9++)
					aByteArrayArray590[l][j9] = abyte1[i3++];

				for(int i10 = 0; i10 < 2304; i10++)
					aByteArrayArray585[l][i10] = abyte1[i3++];

				for(int i11 = 0; i11 < 2304; i11++)
					aByteArrayArray583[l][i11] = abyte1[i3++];

			}
			return;
		}
		catch(IOException _ex) {
			i1 = 0;
		}
		for(; i1 < 2304; i1++) {
			aByteArrayArray577[l][i1] = 0;
			aByteArrayArray581[l][i1] = 0;
			aByteArrayArray582[l][i1] = 0;
			aByteArrayArray584[l][i1] = 0;
			anIntArrayArray580[l][i1] = 0;
			aByteArrayArray590[l][i1] = 0;
			aByteArrayArray585[l][i1] = 0;
			if(k == 0)
				aByteArrayArray585[l][i1] = -6;
			if(k == 3)
				aByteArrayArray585[l][i1] = 8;
			aByteArrayArray583[l][i1] = 0;
		}

	}

	public boolean method416(int i, int j) {
		return method423(i, j) > 0 && method423(i - 1, j) > 0 && method423(i - 1, j - 1) > 0 && method423(i, j - 1) > 0;
	}

	public int method417(int i, int j, int k) {
		if(i < 0 || i >= 96 || j < 0 || j >= 96)
			return 0;
		byte byte0 = 0;
		if(i >= 48 && j < 48) {
			byte0 = 1;
			i -= 48;
		} else
		if(i < 48 && j >= 48) {
			byte0 = 2;
			j -= 48;
		} else
		if(i >= 48 && j >= 48) {
			byte0 = 3;
			i -= 48;
			j -= 48;
		}
		return aByteArrayArray585[byte0][i * 48 + j] & 0xff;
	}

	public RsWorld(Scene scene, Surface surface) {
		aBoolean599 = true;
		anIntArrayArray573 = new int[96][96];
		aByteArrayArray583 = new byte[4][2304];
		aModelArrayArray597 = new Model[4][64];
		anIntArray592 = new int[256];
		aByteArrayArray582 = new byte[4][2304];
		aByteArrayArray590 = new byte[4][2304];
		aByteArrayArray577 = new byte[4][2304];
		aModelArrayArray598 = new Model[4][64];
		aByteArrayArray581 = new byte[4][2304];
		anIntArray594 = new int[18432];
		aByteArrayArray585 = new byte[4][2304];
		anIntArrayArray579 = new int[96][96];
		anIntArrayArray580 = new int[4][2304];
		aByteArrayArray584 = new byte[4][2304];
		aBoolean595 = false;
		aBoolean572 = false;
		anIntArrayArray574 = new int[96][96];
		aModelArray578 = new Model[64];
		anIntArray593 = new int[18432];
		anInt596 = 750;
		aScene575 = scene;
		aSurface576 = surface;
		for(int i = 0; i < 64; i++)
			anIntArray592[i] = Scene.method275(255 - i * 4, 255 - (int)((double)i * 1.75D), 255 - i * 4);

		for(int j = 0; j < 64; j++)
			anIntArray592[j + 64] = Scene.method275(j * 3, 144, 0);

		for(int k = 0; k < 64; k++)
			anIntArray592[k + 128] = Scene.method275(192 - (int)((double)k * 1.5D), 144 - (int)((double)k * 1.5D), 0);

		for(int l = 0; l < 64; l++)
			anIntArray592[l + 192] = Scene.method275(96 - (int)((double)l * 1.5D), 48 + (int)((double)l * 1.5D), 0);

	}

	public void method418(int i, int j, int k, boolean flag) {
		int l = (i + 24) / 48;
		int i1 = (j + 24) / 48;
		method415(l - 1, i1 - 1, k, 0);
		method415(l, i1 - 1, k, 1);
		method415(l - 1, i1, k, 2);
		method415(l, i1, k, 3);
		method397();
		if(aModel591 == null)
			aModel591 = new Model(18688, 18688, true, true, false, false, true);
		if(flag) {
			aSurface576.method244();
			for(int j1 = 0; j1 < 96; j1++) {
				for(int l1 = 0; l1 < 96; l1++)
					anIntArrayArray573[j1][l1] = 0;

			}

			Model model = aModel591;
			model.method178();
			for(int j2 = 0; j2 < 96; j2++) {
				for(int i3 = 0; i3 < 96; i3++) {
					int i4 = -method395(j2, i3);
					if(method417(j2, i3, k) > 0 && Definitions.anIntArray129[method417(j2, i3, k) - 1] == 4)
						i4 = 0;
					if(method417(j2 - 1, i3, k) > 0 && Definitions.anIntArray129[method417(j2 - 1, i3, k) - 1] == 4)
						i4 = 0;
					if(method417(j2, i3 - 1, k) > 0 && Definitions.anIntArray129[method417(j2, i3 - 1, k) - 1] == 4)
						i4 = 0;
					if(method417(j2 - 1, i3 - 1, k) > 0 && Definitions.anIntArray129[method417(j2 - 1, i3 - 1, k) - 1] == 4)
						i4 = 0;
					int j5 = model.method198(j2 * 128, i4, i3 * 128);
					int j7 = (int)(Math.random() * 10D) - 5;
					model.method196(j5, j7);
				}

			}

			for(int j3 = 0; j3 < 95; j3++) {
				for(int j4 = 0; j4 < 95; j4++) {
					int k5 = method405(j3, j4);
					int k7 = anIntArray592[k5];
					int i10 = k7;
					int k12 = k7;
					int l14 = 0;
					if(k == 1 || k == 2) {
						k7 = 0xbc614e;
						i10 = 0xbc614e;
						k12 = 0xbc614e;
					}
					if(method417(j3, j4, k) > 0) {
						int l16 = method417(j3, j4, k);
						int l5 = Definitions.anIntArray129[l16 - 1];
						int i19 = method421(j3, j4, k);
						k7 = i10 = Definitions.anIntArray128[l16 - 1];
						if(l5 == 4) {
							k7 = 1;
							i10 = 1;
							if(l16 == 12) {
								k7 = 31;
								i10 = 31;
							}
						}
						if(l5 == 5) {
							if(method419(j3, j4) > 0 && method419(j3, j4) < 24000)
								if(method413(j3 - 1, j4, k, k12) != 0xbc614e && method413(j3, j4 - 1, k, k12) != 0xbc614e) {
									k7 = method413(j3 - 1, j4, k, k12);
									l14 = 0;
								} else
								if(method413(j3 + 1, j4, k, k12) != 0xbc614e && method413(j3, j4 + 1, k, k12) != 0xbc614e) {
									i10 = method413(j3 + 1, j4, k, k12);
									l14 = 0;
								} else
								if(method413(j3 + 1, j4, k, k12) != 0xbc614e && method413(j3, j4 - 1, k, k12) != 0xbc614e) {
									i10 = method413(j3 + 1, j4, k, k12);
									l14 = 1;
								} else
								if(method413(j3 - 1, j4, k, k12) != 0xbc614e && method413(j3, j4 + 1, k, k12) != 0xbc614e) {
									k7 = method413(j3 - 1, j4, k, k12);
									l14 = 1;
								}
						} else
						if(l5 != 2 || method419(j3, j4) > 0 && method419(j3, j4) < 24000)
							if(method421(j3 - 1, j4, k) != i19 && method421(j3, j4 - 1, k) != i19) {
								k7 = k12;
								l14 = 0;
							} else
							if(method421(j3 + 1, j4, k) != i19 && method421(j3, j4 + 1, k) != i19) {
								i10 = k12;
								l14 = 0;
							} else
							if(method421(j3 + 1, j4, k) != i19 && method421(j3, j4 - 1, k) != i19) {
								i10 = k12;
								l14 = 1;
							} else
							if(method421(j3 - 1, j4, k) != i19 && method421(j3, j4 + 1, k) != i19) {
								k7 = k12;
								l14 = 1;
							}
						if(Definitions.anIntArray130[l16 - 1] != 0)
							anIntArrayArray573[j3][j4] |= 0x40;
						if(Definitions.anIntArray129[l16 - 1] == 2)
							anIntArrayArray573[j3][j4] |= 0x80;
					}
					method394(j3, j4, l14, k7, i10);
					int i17 = ((method395(j3 + 1, j4 + 1) - method395(j3 + 1, j4)) + method395(j3, j4 + 1)) - method395(j3, j4);
					if(k7 != i10 || i17 != 0) {
						int ai[] = new int[3];
						int ai7[] = new int[3];
						if(l14 == 0) {
							if(k7 != 0xbc614e) {
								ai[0] = j4 + j3 * 96 + 96;
								ai[1] = j4 + j3 * 96;
								ai[2] = j4 + j3 * 96 + 1;
								int l21 = model.method184(3, ai, 0xbc614e, k7);
								anIntArray593[l21] = j3;
								anIntArray594[l21] = j4;
								model.anIntArray265[l21] = 0x30d40 + l21;
							}
							if(i10 != 0xbc614e) {
								ai7[0] = j4 + j3 * 96 + 1;
								ai7[1] = j4 + j3 * 96 + 96 + 1;
								ai7[2] = j4 + j3 * 96 + 96;
								int i22 = model.method184(3, ai7, 0xbc614e, i10);
								anIntArray593[i22] = j3;
								anIntArray594[i22] = j4;
								model.anIntArray265[i22] = 0x30d40 + i22;
							}
						} else {
							if(k7 != 0xbc614e) {
								ai[0] = j4 + j3 * 96 + 1;
								ai[1] = j4 + j3 * 96 + 96 + 1;
								ai[2] = j4 + j3 * 96;
								int j22 = model.method184(3, ai, 0xbc614e, k7);
								anIntArray593[j22] = j3;
								anIntArray594[j22] = j4;
								model.anIntArray265[j22] = 0x30d40 + j22;
							}
							if(i10 != 0xbc614e) {
								ai7[0] = j4 + j3 * 96 + 96;
								ai7[1] = j4 + j3 * 96;
								ai7[2] = j4 + j3 * 96 + 96 + 1;
								int k22 = model.method184(3, ai7, 0xbc614e, i10);
								anIntArray593[k22] = j3;
								anIntArray594[k22] = j4;
								model.anIntArray265[k22] = 0x30d40 + k22;
							}
						}
					} else
					if(k7 != 0xbc614e) {
						int ai1[] = new int[4];
						ai1[0] = j4 + j3 * 96 + 96;
						ai1[1] = j4 + j3 * 96;
						ai1[2] = j4 + j3 * 96 + 1;
						ai1[3] = j4 + j3 * 96 + 96 + 1;
						int l19 = model.method184(4, ai1, 0xbc614e, k7);
						anIntArray593[l19] = j3;
						anIntArray594[l19] = j4;
						model.anIntArray265[l19] = 0x30d40 + l19;
					}
				}

			}

			for(int k4 = 1; k4 < 95; k4++) {
				for(int i6 = 1; i6 < 95; i6++)
					if(method417(k4, i6, k) > 0 && Definitions.anIntArray129[method417(k4, i6, k) - 1] == 4) {
						int l7 = Definitions.anIntArray128[method417(k4, i6, k) - 1];
						int j10 = model.method198(k4 * 128, -method395(k4, i6), i6 * 128);
						int l12 = model.method198((k4 + 1) * 128, -method395(k4 + 1, i6), i6 * 128);
						int i15 = model.method198((k4 + 1) * 128, -method395(k4 + 1, i6 + 1), (i6 + 1) * 128);
						int j17 = model.method198(k4 * 128, -method395(k4, i6 + 1), (i6 + 1) * 128);
						int ai2[] = {
							j10, l12, i15, j17
						};
						int i20 = model.method184(4, ai2, l7, 0xbc614e);
						anIntArray593[i20] = k4;
						anIntArray594[i20] = i6;
						model.anIntArray265[i20] = 0x30d40 + i20;
						method394(k4, i6, 0, l7, l7);
					} else
					if(method417(k4, i6, k) == 0 || Definitions.anIntArray129[method417(k4, i6, k) - 1] != 3) {
						if(method417(k4, i6 + 1, k) > 0 && Definitions.anIntArray129[method417(k4, i6 + 1, k) - 1] == 4) {
							int i8 = Definitions.anIntArray128[method417(k4, i6 + 1, k) - 1];
							int k10 = model.method198(k4 * 128, -method395(k4, i6), i6 * 128);
							int i13 = model.method198((k4 + 1) * 128, -method395(k4 + 1, i6), i6 * 128);
							int j15 = model.method198((k4 + 1) * 128, -method395(k4 + 1, i6 + 1), (i6 + 1) * 128);
							int k17 = model.method198(k4 * 128, -method395(k4, i6 + 1), (i6 + 1) * 128);
							int ai3[] = {
								k10, i13, j15, k17
							};
							int j20 = model.method184(4, ai3, i8, 0xbc614e);
							anIntArray593[j20] = k4;
							anIntArray594[j20] = i6;
							model.anIntArray265[j20] = 0x30d40 + j20;
							method394(k4, i6, 0, i8, i8);
						}
						if(method417(k4, i6 - 1, k) > 0 && Definitions.anIntArray129[method417(k4, i6 - 1, k) - 1] == 4) {
							int j8 = Definitions.anIntArray128[method417(k4, i6 - 1, k) - 1];
							int l10 = model.method198(k4 * 128, -method395(k4, i6), i6 * 128);
							int j13 = model.method198((k4 + 1) * 128, -method395(k4 + 1, i6), i6 * 128);
							int k15 = model.method198((k4 + 1) * 128, -method395(k4 + 1, i6 + 1), (i6 + 1) * 128);
							int l17 = model.method198(k4 * 128, -method395(k4, i6 + 1), (i6 + 1) * 128);
							int ai4[] = {
								l10, j13, k15, l17
							};
							int k20 = model.method184(4, ai4, j8, 0xbc614e);
							anIntArray593[k20] = k4;
							anIntArray594[k20] = i6;
							model.anIntArray265[k20] = 0x30d40 + k20;
							method394(k4, i6, 0, j8, j8);
						}
						if(method417(k4 + 1, i6, k) > 0 && Definitions.anIntArray129[method417(k4 + 1, i6, k) - 1] == 4) {
							int k8 = Definitions.anIntArray128[method417(k4 + 1, i6, k) - 1];
							int i11 = model.method198(k4 * 128, -method395(k4, i6), i6 * 128);
							int k13 = model.method198((k4 + 1) * 128, -method395(k4 + 1, i6), i6 * 128);
							int l15 = model.method198((k4 + 1) * 128, -method395(k4 + 1, i6 + 1), (i6 + 1) * 128);
							int i18 = model.method198(k4 * 128, -method395(k4, i6 + 1), (i6 + 1) * 128);
							int ai5[] = {
								i11, k13, l15, i18
							};
							int l20 = model.method184(4, ai5, k8, 0xbc614e);
							anIntArray593[l20] = k4;
							anIntArray594[l20] = i6;
							model.anIntArray265[l20] = 0x30d40 + l20;
							method394(k4, i6, 0, k8, k8);
						}
						if(method417(k4 - 1, i6, k) > 0 && Definitions.anIntArray129[method417(k4 - 1, i6, k) - 1] == 4) {
							int l8 = Definitions.anIntArray128[method417(k4 - 1, i6, k) - 1];
							int j11 = model.method198(k4 * 128, -method395(k4, i6), i6 * 128);
							int l13 = model.method198((k4 + 1) * 128, -method395(k4 + 1, i6), i6 * 128);
							int i16 = model.method198((k4 + 1) * 128, -method395(k4 + 1, i6 + 1), (i6 + 1) * 128);
							int j18 = model.method198(k4 * 128, -method395(k4, i6 + 1), (i6 + 1) * 128);
							int ai6[] = {
								j11, l13, i16, j18
							};
							int i21 = model.method184(4, ai6, l8, 0xbc614e);
							anIntArray593[i21] = k4;
							anIntArray594[i21] = i6;
							model.anIntArray265[i21] = 0x30d40 + i21;
							method394(k4, i6, 0, l8, l8);
						}
					}

			}

			model.method205(true, 40, 48, -50, -10, -50);
			aModelArray578 = aModel591.method201(0, 0, 1536, 1536, 8, 64, 233, false);
			for(int j6 = 0; j6 < 64; j6++)
				aScene575.method305(aModelArray578[j6]);

			for(int i9 = 0; i9 < 96; i9++) {
				for(int k11 = 0; k11 < 96; k11++)
					anIntArrayArray574[i9][k11] = method395(i9, k11);

			}

		}
		aModel591.method178();
		int k1 = 0x606060;
		for(int i2 = 0; i2 < 95; i2++) {
			for(int k2 = 0; k2 < 95; k2++) {
				int k3 = method409(i2, k2);
				if(k3 > 0 && (Definitions.anIntArray123[k3 - 1] == 0 || aBoolean595)) {
					method393(aModel591, k3 - 1, i2, k2, i2 + 1, k2);
					if(flag && Definitions.anIntArray122[k3 - 1] != 0) {
						anIntArrayArray573[i2][k2] |= 1;
						if(k2 > 0)
							method412(i2, k2 - 1, 4);
					}
					if(flag)
						aSurface576.method251(i2 * 3, k2 * 3, 3, k1);
				}
				k3 = method406(i2, k2);
				if(k3 > 0 && (Definitions.anIntArray123[k3 - 1] == 0 || aBoolean595)) {
					method393(aModel591, k3 - 1, i2, k2, i2, k2 + 1);
					if(flag && Definitions.anIntArray122[k3 - 1] != 0) {
						anIntArrayArray573[i2][k2] |= 2;
						if(i2 > 0)
							method412(i2 - 1, k2, 8);
					}
					if(flag)
						aSurface576.method217(i2 * 3, k2 * 3, 3, k1);
				}
				k3 = method419(i2, k2);
				if(k3 > 0 && k3 < 12000 && (Definitions.anIntArray123[k3 - 1] == 0 || aBoolean595)) {
					method393(aModel591, k3 - 1, i2, k2, i2 + 1, k2 + 1);
					if(flag && Definitions.anIntArray122[k3 - 1] != 0)
						anIntArrayArray573[i2][k2] |= 0x20;
					if(flag) {
						aSurface576.method247(i2 * 3, k2 * 3, k1);
						aSurface576.method247(i2 * 3 + 1, k2 * 3 + 1, k1);
						aSurface576.method247(i2 * 3 + 2, k2 * 3 + 2, k1);
					}
				}
				if(k3 > 12000 && k3 < 24000 && (Definitions.anIntArray123[k3 - 12001] == 0 || aBoolean595)) {
					method393(aModel591, k3 - 12001, i2 + 1, k2, i2, k2 + 1);
					if(flag && Definitions.anIntArray122[k3 - 12001] != 0)
						anIntArrayArray573[i2][k2] |= 0x10;
					if(flag) {
						aSurface576.method247(i2 * 3 + 2, k2 * 3, k1);
						aSurface576.method247(i2 * 3 + 1, k2 * 3 + 1, k1);
						aSurface576.method247(i2 * 3, k2 * 3 + 2, k1);
					}
				}
			}

		}

		if(flag)
			aSurface576.method237(anInt596 - 1, 0, 0, 285, 285);
		aModel591.method205(false, 60, 24, -50, -10, -50);
		aModelArrayArray597[k] = aModel591.method201(0, 0, 1536, 1536, 8, 64, 338, true);
		for(int l2 = 0; l2 < 64; l2++)
			aScene575.method305(aModelArrayArray597[k][l2]);

		for(int l3 = 0; l3 < 95; l3++) {
			for(int l4 = 0; l4 < 95; l4++) {
				int k6 = method409(l3, l4);
				if(k6 > 0)
					method414(k6 - 1, l3, l4, l3 + 1, l4);
				k6 = method406(l3, l4);
				if(k6 > 0)
					method414(k6 - 1, l3, l4, l3, l4 + 1);
				k6 = method419(l3, l4);
				if(k6 > 0 && k6 < 12000)
					method414(k6 - 1, l3, l4, l3 + 1, l4 + 1);
				if(k6 > 12000 && k6 < 24000)
					method414(k6 - 12001, l3 + 1, l4, l3, l4 + 1);
			}

		}

		for(int i5 = 1; i5 < 95; i5++) {
			for(int l6 = 1; l6 < 95; l6++) {
				int j9 = method423(i5, l6);
				if(j9 > 0) {
					int l11 = i5;
					int i14 = l6;
					int j16 = i5 + 1;
					int k18 = l6;
					int j19 = i5 + 1;
					int j21 = l6 + 1;
					int l22 = i5;
					int j23 = l6 + 1;
					int l23 = 0;
					int j24 = anIntArrayArray574[l11][i14];
					int l24 = anIntArrayArray574[j16][k18];
					int j25 = anIntArrayArray574[j19][j21];
					int l25 = anIntArrayArray574[l22][j23];
					if(j24 > 0x13880)
						j24 -= 0x13880;
					if(l24 > 0x13880)
						l24 -= 0x13880;
					if(j25 > 0x13880)
						j25 -= 0x13880;
					if(l25 > 0x13880)
						l25 -= 0x13880;
					if(j24 > l23)
						l23 = j24;
					if(l24 > l23)
						l23 = l24;
					if(j25 > l23)
						l23 = j25;
					if(l25 > l23)
						l23 = l25;
					if(l23 >= 0x13880)
						l23 -= 0x13880;
					if(j24 < 0x13880)
						anIntArrayArray574[l11][i14] = l23;
					else
						anIntArrayArray574[l11][i14] -= 0x13880;
					if(l24 < 0x13880)
						anIntArrayArray574[j16][k18] = l23;
					else
						anIntArrayArray574[j16][k18] -= 0x13880;
					if(j25 < 0x13880)
						anIntArrayArray574[j19][j21] = l23;
					else
						anIntArrayArray574[j19][j21] -= 0x13880;
					if(l25 < 0x13880)
						anIntArrayArray574[l22][j23] = l23;
					else
						anIntArrayArray574[l22][j23] -= 0x13880;
				}
			}

		}

		aModel591.method178();
		for(int i7 = 1; i7 < 95; i7++) {
			for(int k9 = 1; k9 < 95; k9++) {
				int i12 = method423(i7, k9);
				if(i12 > 0) {
					int j14 = i7;
					int k16 = k9;
					int l18 = i7 + 1;
					int k19 = k9;
					int k21 = i7 + 1;
					int i23 = k9 + 1;
					int k23 = i7;
					int i24 = k9 + 1;
					int k24 = i7 * 128;
					int i25 = k9 * 128;
					int k25 = k24 + 128;
					int i26 = i25 + 128;
					int j26 = k24;
					int k26 = i25;
					int l26 = k25;
					int i27 = i26;
					int j27 = anIntArrayArray574[j14][k16];
					int k27 = anIntArrayArray574[l18][k19];
					int l27 = anIntArrayArray574[k21][i23];
					int i28 = anIntArrayArray574[k23][i24];
					int j28 = Definitions.anIntArray125[i12 - 1];
					if(method416(j14, k16) && j27 < 0x13880) {
						j27 += j28 + 0x13880;
						anIntArrayArray574[j14][k16] = j27;
					}
					if(method416(l18, k19) && k27 < 0x13880) {
						k27 += j28 + 0x13880;
						anIntArrayArray574[l18][k19] = k27;
					}
					if(method416(k21, i23) && l27 < 0x13880) {
						l27 += j28 + 0x13880;
						anIntArrayArray574[k21][i23] = l27;
					}
					if(method416(k23, i24) && i28 < 0x13880) {
						i28 += j28 + 0x13880;
						anIntArrayArray574[k23][i24] = i28;
					}
					if(j27 >= 0x13880)
						j27 -= 0x13880;
					if(k27 >= 0x13880)
						k27 -= 0x13880;
					if(l27 >= 0x13880)
						l27 -= 0x13880;
					if(i28 >= 0x13880)
						i28 -= 0x13880;
					byte byte0 = 16;
					if(!method420(j14 - 1, k16))
						k24 -= byte0;
					if(!method420(j14 + 1, k16))
						k24 += byte0;
					if(!method420(j14, k16 - 1))
						i25 -= byte0;
					if(!method420(j14, k16 + 1))
						i25 += byte0;
					if(!method420(l18 - 1, k19))
						k25 -= byte0;
					if(!method420(l18 + 1, k19))
						k25 += byte0;
					if(!method420(l18, k19 - 1))
						k26 -= byte0;
					if(!method420(l18, k19 + 1))
						k26 += byte0;
					if(!method420(k21 - 1, i23))
						l26 -= byte0;
					if(!method420(k21 + 1, i23))
						l26 += byte0;
					if(!method420(k21, i23 - 1))
						i26 -= byte0;
					if(!method420(k21, i23 + 1))
						i26 += byte0;
					if(!method420(k23 - 1, i24))
						j26 -= byte0;
					if(!method420(k23 + 1, i24))
						j26 += byte0;
					if(!method420(k23, i24 - 1))
						i27 -= byte0;
					if(!method420(k23, i24 + 1))
						i27 += byte0;
					i12 = Definitions.anIntArray126[i12 - 1];
					j27 = -j27;
					k27 = -k27;
					l27 = -l27;
					i28 = -i28;
					if(method419(i7, k9) > 12000 && method419(i7, k9) < 24000 && method423(i7 - 1, k9 - 1) == 0) {
						int ai8[] = new int[3];
						ai8[0] = aModel591.method198(l26, l27, i26);
						ai8[1] = aModel591.method198(j26, i28, i27);
						ai8[2] = aModel591.method198(k25, k27, k26);
						aModel591.method184(3, ai8, i12, 0xbc614e);
					} else
					if(method419(i7, k9) > 12000 && method419(i7, k9) < 24000 && method423(i7 + 1, k9 + 1) == 0) {
						int ai9[] = new int[3];
						ai9[0] = aModel591.method198(k24, j27, i25);
						ai9[1] = aModel591.method198(k25, k27, k26);
						ai9[2] = aModel591.method198(j26, i28, i27);
						aModel591.method184(3, ai9, i12, 0xbc614e);
					} else
					if(method419(i7, k9) > 0 && method419(i7, k9) < 12000 && method423(i7 + 1, k9 - 1) == 0) {
						int ai10[] = new int[3];
						ai10[0] = aModel591.method198(j26, i28, i27);
						ai10[1] = aModel591.method198(k24, j27, i25);
						ai10[2] = aModel591.method198(l26, l27, i26);
						aModel591.method184(3, ai10, i12, 0xbc614e);
					} else
					if(method419(i7, k9) > 0 && method419(i7, k9) < 12000 && method423(i7 - 1, k9 + 1) == 0) {
						int ai11[] = new int[3];
						ai11[0] = aModel591.method198(k25, k27, k26);
						ai11[1] = aModel591.method198(l26, l27, i26);
						ai11[2] = aModel591.method198(k24, j27, i25);
						aModel591.method184(3, ai11, i12, 0xbc614e);
					} else
					if(j27 == k27 && l27 == i28) {
						int ai12[] = new int[4];
						ai12[0] = aModel591.method198(k24, j27, i25);
						ai12[1] = aModel591.method198(k25, k27, k26);
						ai12[2] = aModel591.method198(l26, l27, i26);
						ai12[3] = aModel591.method198(j26, i28, i27);
						aModel591.method184(4, ai12, i12, 0xbc614e);
					} else
					if(j27 == i28 && k27 == l27) {
						int ai13[] = new int[4];
						ai13[0] = aModel591.method198(j26, i28, i27);
						ai13[1] = aModel591.method198(k24, j27, i25);
						ai13[2] = aModel591.method198(k25, k27, k26);
						ai13[3] = aModel591.method198(l26, l27, i26);
						aModel591.method184(4, ai13, i12, 0xbc614e);
					} else {
						boolean flag1 = true;
						if(method423(i7 - 1, k9 - 1) > 0)
							flag1 = false;
						if(method423(i7 + 1, k9 + 1) > 0)
							flag1 = false;
						if(!flag1) {
							int ai14[] = new int[3];
							ai14[0] = aModel591.method198(k25, k27, k26);
							ai14[1] = aModel591.method198(l26, l27, i26);
							ai14[2] = aModel591.method198(k24, j27, i25);
							aModel591.method184(3, ai14, i12, 0xbc614e);
							int ai16[] = new int[3];
							ai16[0] = aModel591.method198(j26, i28, i27);
							ai16[1] = aModel591.method198(k24, j27, i25);
							ai16[2] = aModel591.method198(l26, l27, i26);
							aModel591.method184(3, ai16, i12, 0xbc614e);
						} else {
							int ai15[] = new int[3];
							ai15[0] = aModel591.method198(k24, j27, i25);
							ai15[1] = aModel591.method198(k25, k27, k26);
							ai15[2] = aModel591.method198(j26, i28, i27);
							aModel591.method184(3, ai15, i12, 0xbc614e);
							int ai17[] = new int[3];
							ai17[0] = aModel591.method198(l26, l27, i26);
							ai17[1] = aModel591.method198(j26, i28, i27);
							ai17[2] = aModel591.method198(k25, k27, k26);
							aModel591.method184(3, ai17, i12, 0xbc614e);
						}
					}
				}
			}

		}

		aModel591.method205(true, 50, 50, -50, -10, -50);
		aModelArrayArray598[k] = aModel591.method201(0, 0, 1536, 1536, 8, 64, 169, true);
		for(int l9 = 0; l9 < 64; l9++)
			aScene575.method305(aModelArrayArray598[k][l9]);

		if(aModelArrayArray598[k][0] == null)
			throw new RuntimeException("null roof!");
		for(int j12 = 0; j12 < 96; j12++) {
			for(int k14 = 0; k14 < 96; k14++)
				if(anIntArrayArray574[j12][k14] >= 0x13880)
					anIntArrayArray574[j12][k14] -= 0x13880;

		}

	}

	public int method419(int i, int j) {
		if(i < 0 || i >= 96 || j < 0 || j >= 96)
			return 0;
		byte byte0 = 0;
		if(i >= 48 && j < 48) {
			byte0 = 1;
			i -= 48;
		} else
		if(i < 48 && j >= 48) {
			byte0 = 2;
			j -= 48;
		} else
		if(i >= 48 && j >= 48) {
			byte0 = 3;
			i -= 48;
			j -= 48;
		}
		return anIntArrayArray580[byte0][i * 48 + j];
	}

	public boolean method420(int i, int j) {
		return method423(i, j) > 0 || method423(i - 1, j) > 0 || method423(i - 1, j - 1) > 0 || method423(i, j - 1) > 0;
	}

	public int method421(int i, int j, int k) {
		int l = method417(i, j, k);
		if(l == 0)
			return -1;
		int i1 = Definitions.anIntArray129[l - 1];
		return i1 != 2 ? 0 : 1;
	}

	public void method422() {
		if(aBoolean599)
			aScene575.method306();
		for(int i = 0; i < 64; i++) {
			aModelArray578[i] = null;
			for(int j = 0; j < 4; j++)
				aModelArrayArray597[j][i] = null;

			for(int k = 0; k < 4; k++)
				aModelArrayArray598[k][i] = null;

		}

		System.gc();
	}

	public int method423(int i, int j) {
		if(i < 0 || i >= 96 || j < 0 || j >= 96)
			return 0;
		byte byte0 = 0;
		if(i >= 48 && j < 48) {
			byte0 = 1;
			i -= 48;
		} else
		if(i < 48 && j >= 48) {
			byte0 = 2;
			j -= 48;
		} else
		if(i >= 48 && j >= 48) {
			byte0 = 3;
			i -= 48;
			j -= 48;
		}
		return aByteArrayArray590[byte0][i * 48 + j];
	}

	final int anInt568 = 96;
	final int anInt569 = 96;
	final int anInt570 = 0xbc614e;
	final int anInt571 = 128;
	boolean aBoolean572;
	int anIntArrayArray573[][];
	int anIntArrayArray574[][];
	Scene aScene575;
	Surface aSurface576;
	byte aByteArrayArray577[][];
	Model aModelArray578[];
	int anIntArrayArray579[][];
	int anIntArrayArray580[][];
	byte aByteArrayArray581[][];
	byte aByteArrayArray582[][];
	byte aByteArrayArray583[][];
	byte aByteArrayArray584[][];
	byte aByteArrayArray585[][];
	byte aByteArray586[];
	byte aByteArray587[];
	byte aByteArray588[];
	byte aByteArray589[];
	byte aByteArrayArray590[][];
	Model aModel591;
	int anIntArray592[];
	int anIntArray593[];
	int anIntArray594[];
	boolean aBoolean595;
	int anInt596;
	Model aModelArrayArray597[][];
	Model aModelArrayArray598[][];
	boolean aBoolean599;
}
