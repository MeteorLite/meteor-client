package net.runelite.rs.api;

import net.runelite.api.Buffer;
import net.runelite.mapping.Import;

public interface RSBuffer extends Buffer, RSNode
{
@Import("array")
byte[] getPayload();

@Import("offset")
int getOffset();

@Import("offset")
void setOffset(int offset);

@Import("readUnsignedShortA")
@Override
int readUByteAdd();

@Import("method2430")
@Override
int readUByteNeg();

@Import("method2405")
@Override
int readUByteSub();

@Import("method2432")
@Override
byte readByteAdd();

@Import("method2396")
@Override
byte readByteNeg();

@Import("method2433")
@Override
byte readByteSub();

@Import("readUnsignedByte")
@Override
int readUnsignedByte$api();

@Import("readByte")
@Override
byte readByte$api();

@Import("readUnsignedShort")
@Override
int readUnsignedShort$api();

@Import("readShort")
@Override
int readShort$api();

@Import("readStringCp1252NullTerminated")
@Override
String readString();

@Import("readShortSmart")
@Override
int readShortSmart$api();

@Import("readUShortSmart")
@Override
int readUShortSmart$api();

@Import("writeByte")
@Override
void writeByte$api(int i);

@Import("writeInt")
@Override
void writeInt$api(int i);

@Import("writeIntLE")
@Override
void writeIntLE$api(int i);

@Import("writeIntIME")
@Override
void writeIntIME$api(int i);

@Import("writeIntME")
@Override
void writeIntME$api(int i);

@Import("writeShortLE")
@Override
void writeShortLE$api(int i);

@Import("writeShortAdd")
@Override
void writeShortAdd$api(int i);

@Import("writeShortAddLE")
@Override
void writeShortAddLE$api(int i);

@Import("method2437")
@Override
int readUShortLE();

@Import("readUnsignedShortLEA")
@Override
int readUShortAdd();

@Import("readUnsignedShortLE")
@Override
int readShortAddLE();

@Import("method2440")
@Override
int readShortLE();

@Import("readInt")
@Override
int readInt$api();

@Import("method2455")
@Override
int readIntLE$api();

@Import("readUnsignedByteS")
@Override
int readIntIME();

@Import("method2447")
@Override
int readIntME();

@Import("writeLong")
@Override
void writeLong$api(long l);

@Import("writeLongMedium")
@Override
void writeLongMedium$api(long l);

@Import("writeShort")
@Override
void writeShort$api(int i);

@Import("writeByteAdd")
@Override
void writeByteAdd$api(int i);

@Import("writeByteSigned")
@Override
void writeByteSigned$api(int i);

@Import("writeByteNeg")
@Override
void writeByteNeg$api(int i);

@Import("writeStringCp1252NullTerminated")
@Override
void writeString(String s);
}