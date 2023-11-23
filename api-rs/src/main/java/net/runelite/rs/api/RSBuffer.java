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


@Import("readStringCp1252NullTerminated")
String readString();


	@Import("writeByte")
	@Override
	void writeByte$api(int p0); 
	@Import("writeShort")
	@Override
	void writeShort$api(int p0); 
	@Import("writeMedium")
	@Override
	void writeMedium$api(int p0); 
	@Import("writeInt")
	@Override
	void writeInt$api(int p0); 
	@Import("writeLongMedium")
	@Override
	void writeLongMedium$api(long p0); 
	@Import("writeLong")
	@Override
	void writeLong$api(long p0); 
	@Import("writeBoolean")
	@Override
	void writeBoolean$api(boolean p0); 
	@Import("writeStringCp1252NullTerminated")
	@Override
	void writeStringCp1252NullTerminated$api(String p0); 
	@Import("writeStringCp1252NullCircumfixed")
	@Override
	void writeStringCp1252NullCircumfixed$api(String p0); 
	@Import("writeCESU8")
	@Override
	void writeCESU8$api(CharSequence p0); 
	@Import("writeBytes")
	@Override
	void writeBytes$api(byte[] p0, int p1, int p2); 
	@Import("writeBuffer")
	@Override
	void writeBuffer$api(Buffer p0); 
	@Import("writeLengthInt")
	@Override
	void writeLengthInt$api(int p0); 
	@Import("writeLengthShort")
	@Override
	void writeLengthShort$api(int p0); 
	@Import("writeLengthByte")
	@Override
	void writeLengthByte$api(int p0); 
	@Import("writeSmartByteShort")
	@Override
	void writeSmartByteShort$api(int p0); 
	@Import("writeVarInt")
	@Override
	void writeVarInt$api(int p0); 
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
	@Import("readMedium")
	@Override
	int readMedium$api();
	@Import("readInt")
	@Override
	int readInt$api();
	@Import("readLong")
	@Override
	long readLong$api();
	@Import("readBoolean")
	@Override
	boolean readBoolean$api();
	@Import("readStringCp1252NullTerminatedOrNull")
	@Override
	String readStringCp1252NullTerminatedOrNull$api();
	@Import("readStringCp1252NullCircumfixed")
	@Override
	String readStringCp1252NullCircumfixed$api();
	@Import("readCESUB")
	@Override
	String readCESUB$api();
	@Import("readBytes")
	@Override
	void readBytes$api(byte[] p0, int p1, int p2); 
	@Import("readShortSmart")
	@Override
	int readShortSmart$api();
	@Import("readUShortSmart")
	@Override
	int readUShortSmart$api();
	@Import("readShortSmartSub")
	@Override
	int readShortSmartSub$api();
	@Import("readIncrSmallSmart")
	@Override
	int readIncrSmallSmart$api();
	@Import("readLargeSmart")
	@Override
	int readLargeSmart$api();
	@Import("readNullableLargeSmart")
	@Override
	int readNullableLargeSmart$api();
	@Import("readVarInt")
	@Override
	int readVarInt$api();
	@Import("writeCrc")
	@Override
	int writeCrc$api(int p0); 
	@Import("writeByteAdd")
	@Override
	void writeByteAdd$api(int p0); 
	@Import("writeByteNeg")
	@Override
	void writeByteNeg$api(int p0); 
	@Import("writeByteSub")
	@Override
	void writeByteSub$api(int p0); 
	@Import("readUnsignedByteAdd")
	@Override
	int readUnsignedByteAdd$api();
	@Import("readUnsignedByteSub")
	@Override
	int readUnsignedByteSub$api();
	@Import("readUnsignedByteNeg")
	@Override
	int readUnsignedByteNeg$api();
	@Import("readByteAdd")
	@Override
	byte readByteAdd$api();
	@Import("readByteNeg")
	@Override
	byte readByteNeg$api();
	@Import("readByteSub")
	@Override
	byte readByteSub$api();
	@Import("writeShortAdd")
	@Override
	void writeShortAdd$api(int p0); 
	@Import("writeIntME")
	@Override
	void writeIntME$api(int p0); 
	@Import("writeShortLE")
	@Override
	void writeShortLE$api(int p0); 
	@Import("readUnsignedShortLE")
	@Override
	int readUnsignedShortLE$api();
	@Import("readUnsignedShortAdd")
	@Override
	int readUnsignedShortAdd$api();
	@Import("readUnsignedShortAddLE")
	@Override
	int readUnsignedShortAddLE$api();
	@Import("readShortLE")
	@Override
	int readShortLE$api();
	@Import("readShortAdd")
	@Override
	int readShortAdd$api();
	@Import("readShortAddLE")
	@Override
	int readShortAddLE$api();
	@Import("writeIntIME")
	@Override
	void writeIntIME$api(int p0); 
	@Import("writeIntLE")
	@Override
	void writeIntLE$api(int p0); 
	@Import("readIntME")
	@Override
	int readIntME$api();
	@Import("readUnsignedIntIME")
	@Override
	int readUnsignedIntIME$api();
	@Import("readUnsignedIntME")
	@Override
	int readUnsignedIntME$api();
}
