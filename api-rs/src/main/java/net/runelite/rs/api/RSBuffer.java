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

@Import("method2401")
@Override
int readUByteAdd();

@Import("readUnsignedShortA")
@Override
int readUByteNeg();

@Import("readUnsignedByteA")
@Override
int readUByteSub();

@Import("method2404")
@Override
byte readByteAdd();

@Import("method2431")
@Override
byte readByteNeg();

@Import("method2442")
@Override
byte readByteSub();

    @Import("writeMediumMiddle")
    @Override
    void writeMediumMiddle$api(int i);

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

@Import("method2441")
@Override
void writeIntLE$api(int i);

@Import("method2414")
@Override
void writeIntIME(int i);

@Import("method2382")
@Override
void writeIntME$api(int i);

@Import("writeShortA")
@Override
void writeShortLE$api(int i);

@Import("writeShortLE")
@Override
void writeShortAdd(int i);

@Import("writeShortLEA")
@Override
void writeShortAddLE(int i);

@Import("readUnsignedShortLEA")
@Override
int readUShortLE();

@Import("readUnsignedByteS")
@Override
int readUShortAdd();

@Import("readUnsignedShortLE")
@Override
int readShortAddLE();

@Import("method2409")
@Override
int readShortLE();

@Import("readInt")
@Override
int readInt$api();

@Import("method2415")
@Override
int readIntLE$api();

@Import("method2416")
@Override
int readIntIME();

@Import("method2417")
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

@Import("method2399")
@Override
void writeByteAdd(int i);

@Import("writeByteA")
@Override
void writeByteSub(int i);

@Import("writeByteS")
@Override
void writeByteNeg(int i);

@Import("writeStringCp1252NullTerminated")
@Override
void writeString(String s);
}