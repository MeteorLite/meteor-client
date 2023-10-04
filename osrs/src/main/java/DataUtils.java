// Decompiled by Jad v1.5.8c. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

import java.io.*;
import java.net.URL;

public class DataUtils {

	public static int method340(byte byte0) {
		return byte0 & 0xff;
	}

	public static int method341(byte abyte0[], int i) {
		if((abyte0[i] & 0xff) < 128)
			return abyte0[i];
		else
			return ((abyte0[i] & 0xff) - 128 << 24) + ((abyte0[i + 1] & 0xff) << 16) + ((abyte0[i + 2] & 0xff) << 8) + (abyte0[i + 3] & 0xff);
	}

	public static byte[] method342(String s, int i, byte abyte0[], byte abyte1[]) {
		int j = (abyte0[0] & 0xff) * 256 + (abyte0[1] & 0xff);
		int k = 0;
		s = s.toUpperCase();
		for(int l = 0; l < s.length(); l++)
			k = (k * 61 + s.charAt(l)) - 32;

		int i1 = 2 + j * 10;
		for(int j1 = 0; j1 < j; j1++) {
			int k1 = (abyte0[j1 * 10 + 2] & 0xff) * 0x1000000 + (abyte0[j1 * 10 + 3] & 0xff) * 0x10000 + (abyte0[j1 * 10 + 4] & 0xff) * 256 + (abyte0[j1 * 10 + 5] & 0xff);
			int l1 = (abyte0[j1 * 10 + 6] & 0xff) * 0x10000 + (abyte0[j1 * 10 + 7] & 0xff) * 256 + (abyte0[j1 * 10 + 8] & 0xff);
			int i2 = (abyte0[j1 * 10 + 9] & 0xff) * 0x10000 + (abyte0[j1 * 10 + 10] & 0xff) * 256 + (abyte0[j1 * 10 + 11] & 0xff);
			if(k1 == k) {
				if(abyte1 == null)
					abyte1 = new byte[l1 + i];
				if(l1 != i2) {
					BZip2Decompressor.method133(abyte1, l1, abyte0, i2, i1);
				} else {
					for(int j2 = 0; j2 < l1; j2++)
						abyte1[j2] = abyte0[i1 + j2];

				}
				return abyte1;
			}
			i1 += i2;
		}

		return null;
	}

	public static int method343(byte abyte0[], int i) {
		return ((abyte0[i] & 0xff) << 24) + ((abyte0[i + 1] & 0xff) << 16) + ((abyte0[i + 2] & 0xff) << 8) + (abyte0[i + 3] & 0xff);
	}

	public static int method344(byte abyte0[], int i) {
		return ((abyte0[i] & 0xff) << 8) + (abyte0[i + 1] & 0xff);
	}

	public static int method345(byte abyte0[], int i) {
		int j = method340(abyte0[i]) * 256 + method340(abyte0[i + 1]);
		if(j > 32767)
			j -= 0x10000;
		return j;
	}

	public static int method346(String s, byte abyte0[]) {
		int i = method344(abyte0, 0);
		int j = 0;
		s = s.toUpperCase();
		for(int k = 0; k < s.length(); k++)
			j = (j * 61 + s.charAt(k)) - 32;

		int l = 2 + i * 10;
		for(int i1 = 0; i1 < i; i1++) {
			int j1 = (abyte0[i1 * 10 + 2] & 0xff) * 0x1000000 + (abyte0[i1 * 10 + 3] & 0xff) * 0x10000 + (abyte0[i1 * 10 + 4] & 0xff) * 256 + (abyte0[i1 * 10 + 5] & 0xff);
			int k1 = (abyte0[i1 * 10 + 6] & 0xff) * 0x10000 + (abyte0[i1 * 10 + 7] & 0xff) * 256 + (abyte0[i1 * 10 + 8] & 0xff);
			int l1 = (abyte0[i1 * 10 + 9] & 0xff) * 0x10000 + (abyte0[i1 * 10 + 10] & 0xff) * 256 + (abyte0[i1 * 10 + 11] & 0xff);
			if(j1 == j)
				return k1;
			l += l1;
		}

		return 0;
	}

	public static int method347(String s, byte abyte0[]) {
		int i = method344(abyte0, 0);
		int j = 0;
		s = s.toUpperCase();
		for(int k = 0; k < s.length(); k++)
			j = (j * 61 + s.charAt(k)) - 32;

		int l = 2 + i * 10;
		for(int i1 = 0; i1 < i; i1++) {
			int j1 = (abyte0[i1 * 10 + 2] & 0xff) * 0x1000000 + (abyte0[i1 * 10 + 3] & 0xff) * 0x10000 + (abyte0[i1 * 10 + 4] & 0xff) * 256 + (abyte0[i1 * 10 + 5] & 0xff);
			int k1 = (abyte0[i1 * 10 + 9] & 0xff) * 0x10000 + (abyte0[i1 * 10 + 10] & 0xff) * 256 + (abyte0[i1 * 10 + 11] & 0xff);
			if(j1 == j)
				return l;
			l += k1;
		}

		return 0;
	}

	public static long method348(byte abyte0[], int i) {
		return (((long)method343(abyte0, i) & 0xffffffffL) << 32) + ((long)method343(abyte0, i + 4) & 0xffffffffL);
	}

	public static String method349(int i) {
		return (i >> 24 & 0xff) + "." + (i >> 16 & 0xff) + "." + (i >> 8 & 0xff) + "." + (i & 0xff);
	}

	public static int method350(byte abyte0[], int i, int j) {
		int k = i >> 3;
		int l = 8 - (i & 7);
		int i1 = 0;
		for(; j > l; l = 8) {
			i1 += (abyte0[k++] & anIntArray541[l]) << j - l;
			j -= l;
		}

		if(j == l)
			i1 += abyte0[k] & anIntArray541[l];
		else
			i1 += abyte0[k] >> l - j & anIntArray541[j];
		return i1;
	}

	public static String method351(long l) {
		if(l < 0L)
			return "invalid_name";
		String s = "";
		while(l != 0L)  {
			int i = (int)(l % 37L);
			l /= 37L;
			if(i == 0)
				s = " " + s;
			else
			if(i < 27) {
				if(l % 37L == 0L)
					s = (char)((i + 65) - 1) + s;
				else
					s = (char)((i + 97) - 1) + s;
			} else {
				s = (char)((i + 48) - 27) + s;
			}
		}
		return s;
	}

	public static byte[] method352(String s, int i, byte abyte0[]) {
		return method342(s, i, abyte0, null);
	}

	public static InputStream method353(String s) throws IOException {
		Object obj;
		if(anURL542 == null) {
			if (mudclient.injected)
				s = "./data/" + s;
			obj = new BufferedInputStream(new FileInputStream(s));
		} else {
			System.out.println(anURL542.getPath() + s);
			URL url = new URL(anURL542, s);
			obj = url.openStream();
		}
		return ((InputStream) (obj));
	}

	public static void method354(String s, byte abyte0[], int i) throws IOException {
		InputStream inputstream = method353(s);
		DataInputStream datainputstream = new DataInputStream(inputstream);
		try {
			datainputstream.readFully(abyte0, 0, i);
		}
		catch(EOFException _ex) { }
		datainputstream.close();
	}

	public static String method355(String s, int i) {
		String s1 = "";
		for(int j = 0; j < i; j++)
			if(j >= s.length()) {
				s1 = s1 + " ";
			} else {
				char c = s.charAt(j);
				if(c >= 'a' && c <= 'z')
					s1 = s1 + c;
				else
				if(c >= 'A' && c <= 'Z')
					s1 = s1 + c;
				else
				if(c >= '0' && c <= '9')
					s1 = s1 + c;
				else
					s1 = s1 + '_';
			}

		return s1;
	}

	public static long method356(String s) {
		String s1 = "";
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(c >= 'a' && c <= 'z')
				s1 = s1 + c;
			else
			if(c >= 'A' && c <= 'Z')
				s1 = s1 + (char)((c + 97) - 65);
			else
			if(c >= '0' && c <= '9')
				s1 = s1 + c;
			else
				s1 = s1 + ' ';
		}

		s1 = s1.trim();
		if(s1.length() > 12)
			s1 = s1.substring(0, 12);
		long l = 0L;
		for(int j = 0; j < s1.length(); j++) {
			char c1 = s1.charAt(j);
			l *= 37L;
			if(c1 >= 'a' && c1 <= 'z')
				l += (1 + c1) - 97;
			else
			if(c1 >= '0' && c1 <= '9')
				l += (27 + c1) - 48;
		}

		return l;
	}

	public static boolean aBoolean540;
	private static int anIntArray541[] = {
		0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 
		1023, 2047, 4095, 8191, 16383, 32767, 65535, 0x1ffff, 0x3ffff, 0x7ffff, 
		0xfffff, 0x1fffff, 0x3fffff, 0x7fffff, 0xffffff, 0x1ffffff, 0x3ffffff, 0x7ffffff, 0xfffffff, 0x1fffffff, 
		0x3fffffff, 0x7fffffff, -1
	};
	public static URL anURL542 = null;

}
