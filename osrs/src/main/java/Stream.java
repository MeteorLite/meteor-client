// Decompiled by Jad v1.5.8c. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

import java.io.IOException;

public class Stream {

	public int method322(int i) {
		return i - isaacIn.method311() & 0xff;
	}

	public int method323() throws IOException {
		int i = method327();
		int j = method327();
		return i * 256 + j;
	}

	public void createPacket(int i) {
		if(anInt529 > (anInt530 * 4) / 5)
			try {
				method328(0);
			}
			catch(IOException ioexception) {
				aBoolean531 = true;
				aString532 = ioexception.getMessage();
			}
		if(buffer == null)
			buffer = new byte[anInt530];
		buffer[anInt529 + 2] = (byte)i;
		buffer[anInt529 + 3] = 0;
		ptr = anInt529 + 3;
		anInt533 = 8;
	}

	public void put4(int i) {
		buffer[ptr++] = (byte)(i >> 24);
		buffer[ptr++] = (byte)(i >> 16);
		buffer[ptr++] = (byte)(i >> 8);
		buffer[ptr++] = (byte)i;
	}

	public void put2(int i) {
		buffer[ptr++] = (byte)(i >> 8);
		buffer[ptr++] = (byte)i;
	}

	public void endPacket() {
		if(isaacOut != null) {
			int i = buffer[anInt529 + 2] & 0xff;
			buffer[anInt529 + 2] = (byte)(i + isaacOut.method311());
		}
		if(anInt533 != 8)
			ptr++;
		int j = ptr - anInt529 - 2;
		if(j >= 160) {
			buffer[anInt529] = (byte)(160 + j / 256);
			buffer[anInt529 + 1] = (byte)(j & 0xff);
		} else {
			buffer[anInt529] = (byte)j;
			ptr--;
			buffer[anInt529 + 1] = buffer[ptr];
		}
		if(anInt530 <= 10000) {
			int k = buffer[anInt529 + 2] & 0xff;
			anIntArray534[k]++;
			anIntArray535[k] += ptr - anInt529;
		}
		anInt529 = ptr;
	}

	public int method324() throws IOException {
		return 0;
	}

	public void method325(byte abyte0[], int i, int j) {
		for(int k = 0; k < j; k++)
			buffer[ptr++] = abyte0[i + k];

	}

	public long method326() throws IOException {
		long l = method323();
		long l1 = method323();
		long l2 = method323();
		long l3 = method323();
		return (l << 48) + (l1 << 32) + (l2 << 16) + l3;
	}

	public void put1(int i) {
		buffer[ptr++] = (byte)i;
	}

	public int method327() throws IOException {
		return method324();
	}

	public void method328(int i) throws IOException {
		if(aBoolean531) {
			anInt529 = 0;
			ptr = 3;
			aBoolean531 = false;
			throw new IOException(aString532);
		}
		anInt536++;
		if(anInt536 < i)
			return;
		if(anInt529 > 0) {
			anInt536 = 0;
			method338(buffer, 0, anInt529);
		}
		anInt529 = 0;
		ptr = 3;
	}

	public void method329(String s) {
		s.getBytes(0, s.length(), buffer, ptr);
		ptr += s.length();
	}

	public int method330() throws IOException {
		return 0;
	}

	public boolean method331() {
		return anInt529 > 0;
	}

	public void method332(long l) {
		put4((int)(l >> 32));
		put4((int)(l & -1L));
	}

	public void method333(int i, int j, byte abyte0[]) throws IOException {
	}

	public Stream() {
		ptr = 3;
		anInt533 = 8;
		anInt530 = 5000;
		aBoolean531 = false;
		aString532 = "";
		if(!DataUtils.aBoolean540);
	}

	public void method334(int ai[]) {
		isaacIn = new IsaacCipher(ai);
		isaacOut = new IsaacCipher(ai);
	}

	public void method335() throws IOException {
		endPacket();
		method328(0);
	}

	public int method336(byte abyte0[]) {
		try {
			anInt537++;
			if(anInt538 > 0 && anInt537 > anInt538) {
				aBoolean531 = true;
				aString532 = "time-out";
				anInt538 += anInt538;
				return 0;
			}
			if(anInt539 == 0 && method330() >= 2) {
				anInt539 = method324();
				if(anInt539 >= 160)
					anInt539 = (anInt539 - 160) * 256 + method324();
			}
			if(anInt539 > 0 && method330() >= anInt539) {
				if(anInt539 >= 160) {
					method337(anInt539, abyte0);
				} else {
					abyte0[anInt539 - 1] = (byte)method324();
					if(anInt539 > 1)
						method337(anInt539 - 1, abyte0);
				}
				int i = anInt539;
				anInt539 = 0;
				anInt537 = 0;
				return i;
			}
		}
		catch(IOException ioexception) {
			aBoolean531 = true;
			aString532 = ioexception.getMessage();
		}
		return 0;
	}

	public void method337(int i, byte abyte0[]) throws IOException {
		method333(i, 0, abyte0);
	}

	public void method338(byte abyte0[], int i, int j) throws IOException {
	}

	public void method339() {
	}

	private static int anIntArray514[] = {
		0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 
		1023, 2047, 4095, 8191, 16383, 32767, 65535, 0x1ffff, 0x3ffff, 0x7ffff, 
		0xfffff, 0x1fffff, 0x3fffff, 0x7fffff, 0xffffff, 0x1ffffff, 0x3ffffff, 0x7ffffff, 0xfffffff, 0x1fffffff, 
		0x3fffffff, 0x7fffffff, -1
	};
	final int anInt515 = 61;
	final int anInt516 = 59;
	final int anInt517 = 42;
	final int anInt518 = 43;
	final int anInt519 = 44;
	final int anInt520 = 45;
	final int anInt521 = 46;
	final int anInt522 = 47;
	final int anInt523 = 92;
	final int anInt524 = 32;
	final int anInt525 = 124;
	final int anInt526 = 34;
	static char aCharArray527[];
	public static int anInt528;
	public IsaacCipher isaacIn;
	public int anInt529;
	protected int anInt530;
	protected boolean aBoolean531;
	protected String aString532;
	public byte buffer[];
	private int ptr;
	private int anInt533;
	public IsaacCipher isaacOut;
	public static int anIntArray534[] = new int[256];
	public static int anIntArray535[] = new int[256];
	protected int anInt536;
	public int anInt537;
	public int anInt538;
	protected int anInt539;

	static  {
		aCharArray527 = new char[256];
		for(int i = 0; i < 256; i++)
			aCharArray527[i] = (char)i;

		aCharArray527[61] = '=';
		aCharArray527[59] = ';';
		aCharArray527[42] = '*';
		aCharArray527[43] = '+';
		aCharArray527[44] = ',';
		aCharArray527[45] = '-';
		aCharArray527[46] = '.';
		aCharArray527[47] = '/';
		aCharArray527[92] = '\\';
		aCharArray527[124] = '|';
		aCharArray527[33] = '!';
		aCharArray527[34] = '"';
	}
}
