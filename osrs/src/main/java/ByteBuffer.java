// Decompiled by Jad v1.5.8c. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

import java.math.BigInteger;
import java.util.zip.CRC32;

public class ByteBuffer {

	public int method313() {
		return aByteArray512[anInt513++] & 0xff;
	}

	public void method314(int i) {
		aByteArray512[anInt513++] = (byte)(i >> 24);
		aByteArray512[anInt513++] = (byte)(i >> 16);
		aByteArray512[anInt513++] = (byte)(i >> 8);
		aByteArray512[anInt513++] = (byte)i;
	}

	public int method315() {
		anInt513 += 2;
		return ((aByteArray512[anInt513 - 2] & 0xff) << 8) + (aByteArray512[anInt513 - 1] & 0xff);
	}

	public int method316() {
		anInt513 += 4;
		return ((aByteArray512[anInt513 - 4] & 0xff) << 24) + ((aByteArray512[anInt513 - 3] & 0xff) << 16) + ((aByteArray512[anInt513 - 2] & 0xff) << 8) + (aByteArray512[anInt513 - 1] & 0xff);
	}

	public void method317(byte[] abyte0, int i, int j) {
		for(int k = i; k < i + j; k++)
			aByteArray512[anInt513++] = abyte0[k];

	}

	public void method318(int i) {
		aByteArray512[anInt513++] = (byte)i;
	}

	public void method319(BigInteger biginteger, BigInteger biginteger1) {
		int i = anInt513;
		anInt513 = 0;
		byte[] abyte0 = new byte[i];
		method321(abyte0, 0, i);
		BigInteger biginteger2 = new BigInteger(abyte0);
		BigInteger biginteger3 = biginteger2.modPow(biginteger, biginteger1);
		byte[] abyte1 = biginteger3.toByteArray();
		anInt513 = 0;
		method318(abyte1.length);
		method317(abyte1, 0, abyte1.length);
	}

	public void method320(String s) {
		s.getBytes(0, s.length(), aByteArray512, anInt513);
		anInt513 += s.length();
		aByteArray512[anInt513++] = 10;
	}

	public void method321(byte[] abyte0, int i, int j) {
		for(int k = i; k < i + j; k++)
			abyte0[k] = aByteArray512[anInt513++];

	}

	private ByteBuffer() {
	}

	public ByteBuffer(byte[] abyte0) {
		aByteArray512 = abyte0;
		anInt513 = 0;
	}

	static CRC32 aCRC32_510 = new CRC32();
	private static final int[] anIntArray511 = {
		0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 
		1023, 2047, 4095, 8191, 16383, 32767, 65535, 0x1ffff, 0x3ffff, 0x7ffff, 
		0xfffff, 0x1fffff, 0x3fffff, 0x7fffff, 0xffffff, 0x1ffffff, 0x3ffffff, 0x7ffffff, 0xfffffff, 0x1fffffff, 
		0x3fffffff, 0x7fffffff, -1
	};
	public byte[] aByteArray512;
	public int anInt513;

}
