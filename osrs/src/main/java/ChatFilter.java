// Decompiled by Jad v1.5.8c. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb

public class ChatFilter {

	public static void method357(char ac[]) {
		int i = 0;
		int j = 0;
		int k = 0;
		int l = 0;
		while((i = method386(ac, j)) != -1)  {
			boolean flag = false;
			for(int i1 = j; i1 >= 0 && i1 < i && !flag; i1++)
				if(!method363(ac[i1]) && !method381(ac[i1]))
					flag = true;

			if(flag)
				k = 0;
			if(k == 0)
				l = i;
			j = method372(ac, i);
			int j1 = 0;
			for(int k1 = i; k1 < j; k1++)
				j1 = (j1 * 10 + ac[k1]) - 48;

			if(j1 > 255 || j - i > 8)
				k = 0;
			else
				k++;
			if(k == 4) {
				for(int l1 = l; l1 < j; l1++)
					ac[l1] = '*';

				k = 0;
			}
		}
	}

	public static int method358(char ac[], char ac1[], int i) {
		if(i + 1 == ac.length)
			return 2;
		for(int j = i + 1; j < ac.length; j++) {
			if(!method363(ac[j]))
				break;
			if(ac[j] == '\\' || ac[j] == '/')
				return 3;
		}

		int k = 0;
		for(int l = i + 1; l < ac.length; l++) {
			if(!method363(ac1[l]))
				break;
			if(ac1[l] == '*')
				k++;
		}

		if(k >= 5)
			return 4;
		return !method363(ac[i + 1]) ? 0 : 1;
	}

	public static void method359(char ac[]) {
		boolean flag = true;
		for(int i = 0; i < ac.length; i++) {
			char c = ac[i];
			if(method369(c)) {
				if(flag) {
					if(method362(c))
						flag = false;
				} else
				if(method365(c))
					ac[i] = (char)((c + 97) - 65);
			} else {
				flag = true;
			}
		}

	}

	public static int method360(char ac[], char ac1[], int i) {
		if(i == 0)
			return 2;
		for(int j = i - 1; j >= 0; j--) {
			if(!method363(ac[j]))
				break;
			if(ac[j] == ',' || ac[j] == '.')
				return 3;
		}

		int k = 0;
		for(int l = i - 1; l >= 0; l--) {
			if(!method363(ac1[l]))
				break;
			if(ac1[l] == '*')
				k++;
		}

		if(k >= 3)
			return 4;
		return !method363(ac[i - 1]) ? 0 : 1;
	}

	public static byte method361(char c) {
		if(c >= 'a' && c <= 'z')
			return (byte)((c - 97) + 1);
		if(c == '\'')
			return 28;
		if(c >= '0' && c <= '9')
			return (byte)((c - 48) + 29);
		else
			return 27;
	}

	public static boolean method362(char c) {
		return c >= 'a' && c <= 'z';
	}

	public static boolean method363(char c) {
		return !method369(c) && !method374(c);
	}

	public static boolean method364(char ac[]) {
		boolean flag = true;
		for(int i = 0; i < ac.length; i++)
			if(!method374(ac[i]) && ac[i] != 0)
				flag = false;

		if(flag)
			return true;
		int j = method385(ac);
		int k = 0;
		int l = anIntArray544.length - 1;
		if(j == anIntArray544[k] || j == anIntArray544[l])
			return true;
		do {
			int i1 = (k + l) / 2;
			if(j == anIntArray544[i1])
				return true;
			if(j < anIntArray544[i1])
				l = i1;
			else
				k = i1;
		} while(k != l && k + 1 != l);
		return false;
	}

	public static boolean method365(char c) {
		return c >= 'A' && c <= 'Z';
	}

	public static void method366(ByteBuffer bytebuffer, char ac[][], byte abyte0[][][]) {
		for(int i = 0; i < ac.length; i++) {
			char ac1[] = new char[bytebuffer.method313()];
			for(int j = 0; j < ac1.length; j++)
				ac1[j] = (char)bytebuffer.method313();

			ac[i] = ac1;
			byte abyte1[][] = new byte[bytebuffer.method316()][2];
			for(int k = 0; k < abyte1.length; k++) {
				abyte1[k][0] = (byte)bytebuffer.method313();
				abyte1[k][1] = (byte)bytebuffer.method313();
			}

			if(abyte1.length > 0)
				abyte0[i] = abyte1;
		}

	}

	public static void method367(ByteBuffer bytebuffer, ByteBuffer bytebuffer1, ByteBuffer bytebuffer2, ByteBuffer bytebuffer3) {
		method370(bytebuffer1);
		method387(bytebuffer2);
		method379(bytebuffer);
		method384(bytebuffer3);
	}

	public static void method368(char ac[]) {
		char ac1[] = (char[])ac.clone();
		char ac2[] = {
			'd', 'o', 't'
		};
		method377(ac1, ac2, null);
		char ac3[] = (char[])ac.clone();
		char ac4[] = {
			's', 'l', 'a', 's', 'h'
		};
		method377(ac3, ac4, null);
		for(int i = 0; i < aCharArrayArray545.length; i++)
			method376(ac, ac1, ac3, aCharArrayArray545[i], anIntArray546[i]);

	}

	public static boolean method369(char c) {
		return c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z';
	}

	public static void method370(ByteBuffer bytebuffer) {
		int i = bytebuffer.method316();
		aCharArrayArray547 = new char[i][];
		aByteArrayArrayArray548 = new byte[i][][];
		method366(bytebuffer, aCharArrayArray547, aByteArrayArrayArray548);
	}

	public static void method371(char ac[]) {
		for(int i = aCharArrayArray549.length - 1; i >= 0; i--)
			method377(ac, aCharArrayArray549[i], aByteArrayArrayArray550[i]);

	}

	public static int method372(char ac[], int i) {
		for(int j = i; j < ac.length && j >= 0; j++)
			if(ac[j] < '0' || ac[j] > '9')
				return j;

		return ac.length;
	}

	public static int method373(char c, char c1, char c2) {
		if(c == '*')
			return 0;
		if(c == c1)
			return 1;
		if(c >= 'a' && c <= 'z') {
			if(c == 'e')
				return c1 != '3' ? 0 : 1;
			if(c == 't')
				return c1 != '7' ? 0 : 1;
			if(c == 'a')
				return c1 != '4' && c1 != '@' ? 0 : 1;
			if(c == 'o') {
				if(c1 == '0' || c1 == '*')
					return 1;
				return c1 != '(' || c2 != ')' ? 0 : 2;
			}
			if(c == 'i')
				return c1 != 'y' && c1 != 'l' && c1 != 'j' && c1 != '1' && c1 != '!' && c1 != ':' && c1 != ';' ? 0 : 1;
			if(c == 'n')
				return 0;
			if(c == 's')
				return c1 != '5' && c1 != 'z' && c1 != '$' ? 0 : 1;
			if(c == 'r')
				return 0;
			if(c == 'h')
				return 0;
			if(c == 'l')
				return c1 != '1' ? 0 : 1;
			if(c == 'd')
				return 0;
			if(c == 'c')
				return c1 != '(' ? 0 : 1;
			if(c == 'u')
				return c1 != 'v' ? 0 : 1;
			if(c == 'm')
				return 0;
			if(c == 'f')
				return c1 != 'p' || c2 != 'h' ? 0 : 2;
			if(c == 'p')
				return 0;
			if(c == 'g')
				return c1 != '9' && c1 != '6' ? 0 : 1;
			if(c == 'w')
				return c1 != 'v' || c2 != 'v' ? 0 : 2;
			if(c == 'y')
				return 0;
			if(c == 'b')
				return c1 != '1' || c2 != '3' ? 0 : 2;
			if(c == 'v')
				return 0;
			if(c == 'k')
				return 0;
			if(c == 'x')
				return c1 != ')' || c2 != '(' ? 0 : 2;
			if(c == 'j')
				return 0;
			if(c == 'q')
				return 0;
			if(c == 'z')
				return 0;
		}
		if(c >= '0' && c <= '9') {
			if(c == '0') {
				if(c1 == 'o' || c1 == 'O')
					return 1;
				return c1 != '(' || c2 != ')' ? 0 : 2;
			}
			if(c == '1')
				return c1 != 'l' ? 0 : 1;
			if(c == '2')
				return 0;
			if(c == '3')
				return 0;
			if(c == '4')
				return 0;
			if(c == '5')
				return 0;
			if(c == '6')
				return 0;
			if(c == '7')
				return 0;
			if(c == '8')
				return 0;
			if(c == '9')
				return 0;
		}
		if(c == '-')
			return 0;
		if(c == ',')
			return c1 != '.' ? 0 : 1;
		if(c == '.')
			return c1 != ',' ? 0 : 1;
		if(c == '(')
			return 0;
		if(c == ')')
			return 0;
		if(c == '!')
			return c1 != 'i' ? 0 : 1;
		if(c == '\'')
			return 0;
		if(aBoolean551)
			System.out.println("Letter=" + c + " not matched");
		return 0;
	}

	public static boolean method374(char c) {
		return c >= '0' && c <= '9';
	}

	public static boolean method375(byte abyte0[][], byte byte0, byte byte1) {
		int i = 0;
		if(abyte0[i][0] == byte0 && abyte0[i][1] == byte1)
			return true;
		int j = abyte0.length - 1;
		if(abyte0[j][0] == byte0 && abyte0[j][1] == byte1)
			return true;
		do {
			int k = (i + j) / 2;
			if(abyte0[k][0] == byte0 && abyte0[k][1] == byte1)
				return true;
			if(byte0 < abyte0[k][0] || byte0 == abyte0[k][0] && byte1 < abyte0[k][1])
				j = k;
			else
				i = k;
		} while(i != j && i + 1 != j);
		return false;
	}

	public static void method376(char ac[], char ac1[], char ac2[], char ac3[], int i) {
		if(ac3.length > ac.length)
			return;
		for(int j = 0; j <= ac.length - ac3.length; j++) {
			int k = j;
			int l = 0;
			while(k < ac.length)  {
				int i1 = 0;
				char c = ac[k];
				char c1 = '\0';
				if(k + 1 < ac.length)
					c1 = ac[k + 1];
				if(l < ac3.length && (i1 = method382(ac3[l], c, c1)) > 0) {
					k += i1;
					l++;
					continue;
				}
				if(l == 0)
					break;
				if((i1 = method382(ac3[l - 1], c, c1)) > 0) {
					k += i1;
					continue;
				}
				if(l >= ac3.length || !method363(c))
					break;
				k++;
			}
			if(l >= ac3.length) {
				boolean flag = false;
				int j1 = method360(ac, ac1, j);
				int k1 = method358(ac, ac2, k - 1);
				if(aBoolean552)
					System.out.println("Potential tld: " + ac3 + " at char " + j + " (type=" + i + ", startmatch=" + j1 + ", endmatch=" + k1 + ")");
				if(i == 1 && j1 > 0 && k1 > 0)
					flag = true;
				if(i == 2 && (j1 > 2 && k1 > 0 || j1 > 0 && k1 > 2))
					flag = true;
				if(i == 3 && j1 > 0 && k1 > 2)
					flag = true;
				boolean _tmp = i == 3 && j1 > 2 && k1 > 0;
				if(flag) {
					if(aBoolean552)
						System.out.println("Filtered tld: " + ac3 + " at char " + j);
					int l1 = j;
					int i2 = k - 1;
					if(j1 > 2) {
						if(j1 == 4) {
							boolean flag1 = false;
							for(int k2 = l1 - 1; k2 >= 0; k2--)
								if(flag1) {
									if(ac1[k2] != '*')
										break;
									l1 = k2;
								} else
								if(ac1[k2] == '*') {
									l1 = k2;
									flag1 = true;
								}

						}
						boolean flag2 = false;
						for(int l2 = l1 - 1; l2 >= 0; l2--)
							if(flag2) {
								if(method363(ac[l2]))
									break;
								l1 = l2;
							} else
							if(!method363(ac[l2])) {
								flag2 = true;
								l1 = l2;
							}

					}
					if(k1 > 2) {
						if(k1 == 4) {
							boolean flag3 = false;
							for(int i3 = i2 + 1; i3 < ac.length; i3++)
								if(flag3) {
									if(ac2[i3] != '*')
										break;
									i2 = i3;
								} else
								if(ac2[i3] == '*') {
									i2 = i3;
									flag3 = true;
								}

						}
						boolean flag4 = false;
						for(int j3 = i2 + 1; j3 < ac.length; j3++)
							if(flag4) {
								if(method363(ac[j3]))
									break;
								i2 = j3;
							} else
							if(!method363(ac[j3])) {
								flag4 = true;
								i2 = j3;
							}

					}
					for(int j2 = l1; j2 <= i2; j2++)
						ac[j2] = '*';

				}
			}
		}

	}

	public static void method377(char ac[], char ac1[], byte abyte0[][]) {
		if(ac1.length > ac.length)
			return;
		for(int i = 0; i <= ac.length - ac1.length; i++) {
			int j = i;
			int k = 0;
			boolean flag = false;
			while(j < ac.length)  {
				int l = 0;
				char c = ac[j];
				char c2 = '\0';
				if(j + 1 < ac.length)
					c2 = ac[j + 1];
				if(k < ac1.length && (l = method373(ac1[k], c, c2)) > 0) {
					j += l;
					k++;
					continue;
				}
				if(k == 0)
					break;
				if((l = method373(ac1[k - 1], c, c2)) > 0) {
					j += l;
					continue;
				}
				if(k >= ac1.length || !method381(c))
					break;
				if(method363(c) && c != '\'')
					flag = true;
				j++;
			}
			if(k >= ac1.length) {
				boolean flag1 = true;
				if(aBoolean552)
					System.out.println("Potential word: " + ac1 + " at char " + i);
				if(!flag) {
					char c1 = ' ';
					if(i - 1 >= 0)
						c1 = ac[i - 1];
					char c3 = ' ';
					if(j < ac.length)
						c3 = ac[j];
					byte byte0 = method361(c1);
					byte byte1 = method361(c3);
					if(abyte0 != null && method375(abyte0, byte0, byte1))
						flag1 = false;
				} else {
					boolean flag2 = false;
					boolean flag3 = false;
					if(i - 1 < 0 || method363(ac[i - 1]) && ac[i - 1] != '\'')
						flag2 = true;
					if(j >= ac.length || method363(ac[j]) && ac[j] != '\'')
						flag3 = true;
					if(!flag2 || !flag3) {
						boolean flag4 = false;
						int j1 = i - 2;
						if(flag2)
							j1 = i;
						for(; !flag4 && j1 < j; j1++)
							if(j1 >= 0 && (!method363(ac[j1]) || ac[j1] == '\'')) {
								char ac2[] = new char[3];
								int k1;
								for(k1 = 0; k1 < 3; k1++) {
									if(j1 + k1 >= ac.length || method363(ac[j1 + k1]) && ac[j1 + k1] != '\'')
										break;
									ac2[k1] = ac[j1 + k1];
								}

								boolean flag5 = true;
								if(k1 == 0)
									flag5 = false;
								if(k1 < 3 && j1 - 1 >= 0 && (!method363(ac[j1 - 1]) || ac[j1 - 1] == '\''))
									flag5 = false;
								if(flag5 && !method364(ac2))
									flag4 = true;
							}

						if(!flag4)
							flag1 = false;
					}
				}
				if(flag1) {
					if(aBoolean551)
						System.out.println("Filtered word: " + ac1 + " at char " + i);
					for(int i1 = i; i1 < j; i1++)
						ac[i1] = '*';

				}
			}
		}

	}

	public static void method378(char ac[], char ac1[]) {
		for(int i = 0; i < ac.length; i++)
			if(ac1[i] != '*' && method365(ac[i]))
				ac1[i] = ac[i];

	}

	public static void method379(ByteBuffer bytebuffer) {
		anIntArray544 = new int[bytebuffer.method316()];
		for(int i = 0; i < anIntArray544.length; i++)
			anIntArray544[i] = bytebuffer.method315();

	}

	//This method crashes Meteor, and its a weird ass error, so all uses have been disabled
	public static String method380(String s) {
		char[] ac = s.toLowerCase().toCharArray();
		method368(ac);
		method383(ac);
		method371(ac);
		method357(ac);
		for(int i = 0; i < aStringArray553.length; i++) {
			for(int j = -1; (j = s.indexOf(aStringArray553[i], j + 1)) != -1;) {
				char ac1[] = aStringArray553[i].toCharArray();
				for(int k = 0; k < ac1.length; k++)
					ac[k + j] = ac1[k];

			}

		}

		if(aBoolean554) {
			method378(s.toCharArray(), ac);
			method359(ac);
		}
		return new String(ac);
	}

	public static boolean method381(char c) {
		if(c < 'a' || c > 'z')
			return true;
		return c == 'v' || c == 'x' || c == 'j' || c == 'q' || c == 'z';
	}

	public static int method382(char c, char c1, char c2) {
		if(c == c1)
			return 1;
		if(c == 'e' && c1 == '3')
			return 1;
		if(c == 't' && (c1 == '7' || c1 == '+'))
			return 1;
		if(c == 'a' && (c1 == '4' || c1 == '@'))
			return 1;
		if(c == 'o' && c1 == '0')
			return 1;
		if(c == 'i' && c1 == '1')
			return 1;
		if(c == 's' && c1 == '5')
			return 1;
		if(c == 'f' && c1 == 'p' && c2 == 'h')
			return 2;
		return c != 'g' || c1 != '9' ? 0 : 1;
	}

	public static void method383(char ac[]) {
		for(int i = 0; i < 2; i++) {
			for(int j = aCharArrayArray547.length - 1; j >= 0; j--)
				method377(ac, aCharArrayArray547[j], aByteArrayArrayArray548[j]);

		}

	}

	public static void method384(ByteBuffer bytebuffer) {
		int i = bytebuffer.method316();
		aCharArrayArray545 = new char[i][];
		anIntArray546 = new int[i];
		for(int j = 0; j < i; j++) {
			anIntArray546[j] = bytebuffer.method313();
			char ac[] = new char[bytebuffer.method313()];
			for(int k = 0; k < ac.length; k++)
				ac[k] = (char)bytebuffer.method313();

			aCharArrayArray545[j] = ac;
		}

	}

	public static int method385(char ac[]) {
		if(ac.length > 6)
			return 0;
		int i = 0;
		for(int j = 0; j < ac.length; j++) {
			char c = ac[ac.length - j - 1];
			if(c >= 'a' && c <= 'z')
				i = i * 38 + ((c - 97) + 1);
			else
			if(c == '\'')
				i = i * 38 + 27;
			else
			if(c >= '0' && c <= '9')
				i = i * 38 + ((c - 48) + 28);
			else
			if(c != 0) {
				if(aBoolean551)
					System.out.println("word2hash failed on " + new String(ac));
				return 0;
			}
		}

		return i;
	}

	public static int method386(char ac[], int i) {
		for(int j = i; j < ac.length && j >= 0; j++)
			if(ac[j] >= '0' && ac[j] <= '9')
				return j;

		return -1;
	}

	public static void method387(ByteBuffer bytebuffer) {
		int i = bytebuffer.method316();
		aCharArrayArray549 = new char[i][];
		aByteArrayArrayArray550 = new byte[i][][];
		method366(bytebuffer, aCharArrayArray549, aByteArrayArrayArray550);
	}

	static int anInt543 = 3;
	static int anIntArray544[];
	static char aCharArrayArray545[][];
	static int anIntArray546[];
	static char aCharArrayArray547[][];
	static byte aByteArrayArrayArray548[][][];
	static char aCharArrayArray549[][];
	static byte aByteArrayArrayArray550[][][];
	static boolean aBoolean551;
	static boolean aBoolean552;
	static String aStringArray553[] = {
		"cook", "cook's", "cooks", "seeks", "sheet"
	};
	static boolean aBoolean554 = true;

}
