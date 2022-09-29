package net.runelite.api;

public interface Buffer extends Node
{
	byte[] getPayload();
	int getOffset();

	int readUByteAdd();
	int readUByteNeg();
	int readUByteSub();
	byte readByteAdd();
	byte readByteNeg();
	byte readByteSub();
	int readUnsignedByte();
	byte readByte();
	int readUnsignedShort();
	int readShort();
	String readString();
	int readShortSmart();
	int readUShortSmart();
	void writeByte(int i);
	void writeInt(int i);
	void writeIntLE(int i);
	void writeIntIME(int i);
	void writeIntME(int i);
	int readInt();
	int readIntLE();
	int readIntIME();
	int readIntME();
	void writeShortLE(int i);
	void writeShortAdd(int i);
	void writeShortAddLE(int i);
	int readUShortLE();
	int readUShortAdd();
	int readShortAddLE();
	int readShortLE();
	void writeLong(long l);
	void writeLongMedium(long l);
	void writeShort(int i);
	void writeByteAdd(int i);
	void writeByteSub(int i);
	void writeByteNeg(int i);
	void writeString(String s);
}