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

    @Import("method8581")
    @Override
    int readUByteAdd();

    @Import("method8702")
    @Override
    int readUByteNeg();

    @Import("method8699")
    @Override
    int readUByteSub();

    @Import("method8584")
    @Override
    byte readByteAdd();

    @Import("method8718")
    @Override
    byte readByteNeg();

    @Import("method8701")
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

    @Import("method8599")
    @Override
    void writeIntLE(int i);

    @Import("method8600")
    @Override
    void writeIntIME(int i);

    @Import("method8601")
    @Override
    void writeIntME(int i);

    @Import("method8607")
    @Override
    void writeShortLE(int i);

    @Import("writeIntME")
    @Override
    void writeShortAdd(int i);

    @Import("method8589")
    @Override
    void writeShortAddLE(int i);

    @Import("method8530")
    @Override
    int readUShortLE();

    @Import("method8591")
    @Override
    int readUShortAdd();

    @Import("method8592")
    @Override
    int readShortAddLE();

    @Import("null")
    @Override
    int readShortLE();

    @Import("readInt")
    @Override
    int readInt();

    @Import("method8760")
    @Override
    int readIntLE();

    @Import("method8585")
    @Override
    int readIntIME();

    @Import("method8604")
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

    @Import("method8578")
    @Override
    void writeByteAdd(int i);

    @Import("method8580")
    @Override
    void writeByteSub(int i);

    @Import("method8579")
    @Override
    void writeByteNeg(int i);

    @Import("writeStringCp1252NullTerminated")
    @Override
    void writeString(String s);
}