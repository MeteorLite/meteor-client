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

@Import("method8435")
@Override
int readUByteAdd();

@Import("method8436")
@Override
int readUByteNeg();

@Import("method8623")
@Override
int readUByteSub();

@Import("method8617")
@Override
byte readByteAdd();

@Import("method8469")
@Override
byte readByteNeg();

@Import("method8440")
@Override
byte readByteSub();

@Import("readUnsignedByte")
@Override
int readUnsignedByte();

@Import("readByte")
@Override
byte readByte();

@Import("readUnsignedShort")
@Override
int readUnsignedShort();

@Import("readShort")
@Override
int readShort();

@Import("readStringCp1252NullTerminated")
@Override
String readString();

@Import("readShortSmart")
@Override
int readShortSmart();

@Import("readUShortSmart")
@Override
int readUShortSmart();

@Import("writeByte")
@Override
void writeByte(int i);

@Import("writeInt")
@Override
void writeInt(int i);

@Import("method8453")
@Override
void writeIntLE(int i);

@Import("method8635")
@Override
void writeIntIME(int i);

@Import("method8437")
@Override
void writeIntME(int i);

@Import("writeIntME")
@Override
void writeShortLE(int i);

@Import("method8619")
@Override
void writeShortAdd(int i);

@Import("method8443")
@Override
void writeShortAddLE(int i);

@Import("method8444")
@Override
int readUShortLE();

@Import("method8484")
@Override
int readUShortAdd();

@Import("method8446")
@Override
int readShortAddLE();

@Import("method8448")
@Override
int readShortLE();

@Import("readInt")
@Override
int readInt();

@Import("method8456")
@Override
int readIntLE();

@Import("method8457")
@Override
int readIntIME();

@Import("method8458")
@Override
int readIntME();

@Import("writeLong")
@Override
void writeLong(long l);

@Import("writeLongMedium")
@Override
void writeLongMedium(long l);

@Import("writeShort")
@Override
void writeShort(int i);

@Import("method8630")
@Override
void writeByteAdd(int i);

@Import("method8434")
@Override
void writeByteSub(int i);

@Import("method8546")
@Override
void writeByteNeg(int i);

@Import("writeStringCp1252NullTerminated")
@Override
void writeString(String s);
}