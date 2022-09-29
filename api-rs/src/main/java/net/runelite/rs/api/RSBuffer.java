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

	@Import("method7955")
	@Override
	int readUByteAdd();

	@Import("method7954")
	@Override
	int readUByteNeg();

	@Import("method8023")
	@Override
	int readUByteSub();

	@Import("method7975")
	@Override
	byte readByteAdd();

	@Import("method7970")
	@Override
	byte readByteNeg();

	@Import("method7960")
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

	@Import("method7916")
	@Override
	void writeIntLE(int i);

	@Import("method7971")
	@Override
	void writeIntIME(int i);

	@Import("method7972")
	@Override
	void writeIntME(int i);

	@Import("method7961")
	@Override
	void writeShortLE(int i);

	@Import("method7962")
	@Override
	void writeShortAdd(int i);

	@Import("writeIntME")
	@Override
	void writeShortAddLE(int i);

	@Import("method7964")
	@Override
	int readUShortLE();

	@Import("method7965")
	@Override
	int readUShortAdd();

	@Import("method8143")
	@Override
	int readShortAddLE();

	@Import("method7967")
	@Override
	int readShortLE();

	@Import("readInt")
	@Override
	int readInt();

	@Import("method7973")
	@Override
	int readIntLE();

	@Import("method7974")
	@Override
	int readIntIME();

	@Import("method8135")
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

	@Import("method7952")
	@Override
	void writeByteAdd(int i);

	@Import("method8004")
	@Override
	void writeByteSub(int i);

	@Import("method8136")
	@Override
	void writeByteNeg(int i);

	@Import("writeStringCp1252NullTerminated")
	@Override
	void writeString(String s);
}