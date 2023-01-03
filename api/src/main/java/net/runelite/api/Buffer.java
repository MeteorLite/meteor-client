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
int readUnsignedByte$api();
byte readByte$api();
int readUnsignedShort$api();
int readShort$api();
String readString();
int readShortSmart$api();
int readUShortSmart$api();
void writeByte$api(int i);
void writeInt$api(int i);
void writeIntLE(int i);
void writeIntIME(int i);
void writeIntME$api(int i);
int readInt$api();
int readIntLE();
int readIntIME();
int readIntME();
void writeShortLE(int i);
void writeShortAdd(int i);
void writeShortAddLE(int i);
int readUShortLE();
int readUShortAdd();
int readShortAddLE();
void writeLong$api(long l);
void writeLongMedium$api(long l);
void writeShort$api(int i);
void writeByteAdd(int i);
void writeByteSub(int i);
void writeByteNeg(int i);
void writeString(String s);
}