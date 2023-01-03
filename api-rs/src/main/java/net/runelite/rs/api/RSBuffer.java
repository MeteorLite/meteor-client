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

@Import("method2371")
@Override
int readUByteAdd();

@Import("method2396")
@Override
int readUByteNeg();

@Import("method2394")
@Override
int readUByteSub();

@Import("method2372")
@Override
byte readByteAdd();

@Import("method2401")
@Override
byte readByteNeg();

@Import("method2395")
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

@Import("method2381")
@Override
void writeIntLE(int i);

@Import("method2382")
@Override
void writeIntIME(int i);

@Import("method2383")
@Override
void writeIntME$api(int i);

@Import("method2386")
@Override
void writeShortLE(int i);

@Import("writeIntME")
@Override
void writeShortAdd(int i);

@Import("method2375")
@Override
void writeShortAddLE(int i);

@Import("method2333")
@Override
int readUShortLE();

@Import("method2376")
@Override
int readUShortAdd();

@Import("method2377")
@Override
int readShortAddLE();

@Import("readInt")
@Override
int readInt$api();

@Import("method2405")
@Override
int readIntLE();

@Import("method2373")
@Override
int readIntIME();

@Import("method2384")
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

@Import("method2368")
@Override
void writeByteAdd(int i);

@Import("method2370")
@Override
void writeByteSub(int i);

@Import("method2369")
@Override
void writeByteNeg(int i);

@Import("writeStringCp1252NullTerminated")
@Override
void writeString(String s);
}