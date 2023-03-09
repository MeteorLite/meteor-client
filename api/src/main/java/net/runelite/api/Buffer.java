package net.runelite.api;

public interface Buffer extends Node
{
    byte[] getPayload();
    int getOffset();

    void writeMediumMiddle$api(int i);
    int readUnsignedByteAdd$api();
    int readUnsignedByteNeg$api();
    int _readUnsignedByteSub$api();
    byte readByteAdd();
    byte readByteNeg();
    byte readUnsignedByteSub$api();
	int readUnsignedByte$api();
	byte readByte$api();
	int readUnsignedShort$api();
	int readShort$api();
	String readString();
    int readSignedShortAddLE$api();
	int readShortSmart$api();
	int readUShortSmart$api();
	void writeByte$api(int i);
	void writeInt$api(int i);
	void writeIntLE$api(int i);
	void writeIntIME$api(int i);
	void writeIntME$api(int i);
	int readInt$api();
    int readIntLE$api();
    int readIntIME();
    int readIntME();
    void writeShortLE$api(int i);
    void writeShortAdd$api(int i);
    void writeShortAddLE$api(int i);
    int readUnsignedShortLE$api();
    int readUnsignedShortAdd$api();
    int readUnsignedShortAddLE$api();
	void writeLong$api(long l);
	void writeLongMedium$api(long l);
	void writeShort$api(int i);
    void writeByteAdd$api(int i);
    void writeByteSub$api(int i);
    void writeByteNeg$api(int i);
    void writeString(String s);
}