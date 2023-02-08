import java.math.BigInteger;

import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("rd")
@Implements("Buffer")
public class Buffer extends Node {
    @ObfuscatedName("k")
    static int[] crc32Table = new int[256];
    @ObfuscatedName("r")
    static long[] crc64Table;
    @ObfuscatedName("n")
    public byte[] array;
    @ObfuscatedName("l")
    public int offset;

   static {
      int var2;
      for(int var1 = 0; var1 < 256; ++var1) {
         int var0 = var1;

         for(var2 = 0; var2 < 8; ++var2) {
            if ((var0 & 1) == 1) {
               var0 = var0 >>> 1 ^ -306674912;
            } else {
               var0 >>>= 1;
            }
         }

         crc32Table[var1] = var0;
      }

      crc64Table = new long[256];

      for(var2 = 0; var2 < 256; ++var2) {
         long var4 = (long)var2;

         for(int var3 = 0; var3 < 8; ++var3) {
            if (1L == (var4 & 1L)) {
               var4 = var4 >>> 1 ^ -3932672073523589310L;
            } else {
               var4 >>>= 1;
            }
         }

         crc64Table[var2] = var4;
      }

   }

   public Buffer(int var1, boolean var2) {
      this.array = ByteArrayPool.ByteArrayPool_getArrayBool(var1, var2);
   }

   public Buffer(int var1) {
      this.array = ClientPacket.ByteArrayPool_getArray(var1);
      this.offset = 0;
   }

   public Buffer(byte[] var1) {
      this.array = var1;
      this.offset = 0;
   }

    @ObfuscatedName("aq")
    @ObfuscatedSignature(
            descriptor = "(S)V",
            garbageValue = "-26313"
    )
    public void releaseArray() {
      if (this.array != null) {
         class277.ByteArrayPool_release(this.array);
      }

      this.array = null;
   }

    @ObfuscatedName("ak")
    @ObfuscatedSignature(
            descriptor = "(IS)V",
            garbageValue = "7663"
    )
    public void writeByte(int var1) {
      this.array[++this.offset - 1] = (byte)var1;
   }

    @ObfuscatedName("au")
    @ObfuscatedSignature(
            descriptor = "(IB)V",
            garbageValue = "88"
    )
    public void writeShort(int var1) {
      this.array[++this.offset - 1] = (byte)(var1 >> 8);
      this.array[++this.offset - 1] = (byte)var1;
   }

    @ObfuscatedName("ae")
    @ObfuscatedSignature(
            descriptor = "(IB)V",
            garbageValue = "0"
    )
    public void writeMedium(int var1) {
      this.array[++this.offset - 1] = (byte)(var1 >> 16);
      this.array[++this.offset - 1] = (byte)(var1 >> 8);
      this.array[++this.offset - 1] = (byte)var1;
   }

    @ObfuscatedName("ah")
    @ObfuscatedSignature(
            descriptor = "(II)V",
            garbageValue = "1859234108"
    )
    public void writeInt(int var1) {
      this.array[++this.offset - 1] = (byte)(var1 >> 24);
      this.array[++this.offset - 1] = (byte)(var1 >> 16);
      this.array[++this.offset - 1] = (byte)(var1 >> 8);
      this.array[++this.offset - 1] = (byte)var1;
   }

    @ObfuscatedName("ad")
    public void writeLongMedium(long var1) {
      this.array[++this.offset - 1] = (byte)((int)(var1 >> 40));
      this.array[++this.offset - 1] = (byte)((int)(var1 >> 32));
      this.array[++this.offset - 1] = (byte)((int)(var1 >> 24));
      this.array[++this.offset - 1] = (byte)((int)(var1 >> 16));
      this.array[++this.offset - 1] = (byte)((int)(var1 >> 8));
      this.array[++this.offset - 1] = (byte)((int)var1);
   }

    @ObfuscatedName("ab")
    public void writeLong(long var1) {
      this.array[++this.offset - 1] = (byte)((int)(var1 >> 56));
      this.array[++this.offset - 1] = (byte)((int)(var1 >> 48));
      this.array[++this.offset - 1] = (byte)((int)(var1 >> 40));
      this.array[++this.offset - 1] = (byte)((int)(var1 >> 32));
      this.array[++this.offset - 1] = (byte)((int)(var1 >> 24));
      this.array[++this.offset - 1] = (byte)((int)(var1 >> 16));
      this.array[++this.offset - 1] = (byte)((int)(var1 >> 8));
      this.array[++this.offset - 1] = (byte)((int)var1);
   }

    @ObfuscatedName("an")
    @ObfuscatedSignature(
            descriptor = "(ZB)V",
            garbageValue = "-72"
    )
    public void writeBoolean(boolean var1) {
      this.writeByte(var1 ? 1 : 0);
   }

    @ObfuscatedName("as")
    @ObfuscatedSignature(
            descriptor = "(Ljava/lang/String;B)V",
            garbageValue = "54"
    )
    public void writeStringCp1252NullTerminated(String var1) {
      int var2 = var1.indexOf(0);
      if (var2 >= 0) {
         throw new IllegalArgumentException("");
      } else {
         this.offset += class285.encodeStringCp1252(var1, 0, var1.length(), this.array, this.offset);
         this.array[++this.offset - 1] = 0;
      }
   }

    @ObfuscatedName("ao")
    @ObfuscatedSignature(
            descriptor = "(Ljava/lang/String;I)V",
            garbageValue = "821657052"
    )
    public void writeStringCp1252NullCircumfixed(String var1) {
      int var2 = var1.indexOf(0);
      if (var2 >= 0) {
         throw new IllegalArgumentException("");
      } else {
         this.array[++this.offset - 1] = 0;
         this.offset += class285.encodeStringCp1252(var1, 0, var1.length(), this.array, this.offset);
         this.array[++this.offset - 1] = 0;
      }
   }

    @ObfuscatedName("bj")
    @ObfuscatedSignature(
            descriptor = "(Ljava/lang/CharSequence;I)V",
            garbageValue = "1620729610"
    )
    public void writeCESU8(CharSequence var1) {
      int var2 = PcmPlayer.method216(var1);
      this.array[++this.offset - 1] = 0;
      this.writeVarInt(var2);
      int var3 = this.offset * 1441360663;
      byte[] var5 = this.array;
      int var6 = this.offset;
      int var7 = var1.length();
      int var8 = var6;

      for(int var9 = 0; var9 < var7; ++var9) {
         char var10 = var1.charAt(var9);
         if (var10 <= 127) {
            var5[var8++] = (byte)var10;
         } else if (var10 <= 2047) {
            var5[var8++] = (byte)(192 | var10 >> 6);
            var5[var8++] = (byte)(128 | var10 & 63);
         } else {
            var5[var8++] = (byte)(224 | var10 >> 12);
            var5[var8++] = (byte)(128 | var10 >> 6 & 63);
            var5[var8++] = (byte)(128 | var10 & 63);
         }
      }

      int var4 = var8 - var6;
      this.offset = (var3 + var4 * 1441360663) * -612074329;
   }

    @ObfuscatedName("bf")
    @ObfuscatedSignature(
            descriptor = "([BIII)V",
            garbageValue = "-872987792"
    )
    public void writeBytes(byte[] var1, int var2, int var3) {
      for(int var4 = var2; var4 < var3 + var2; ++var4) {
         this.array[++this.offset - 1] = var1[var4];
      }

   }

   @ObfuscatedName("bz")
   @ObfuscatedSignature(
      descriptor = "(Lrd;B)V",
      garbageValue = "33"
   )
   public void method2443(Buffer var1) {
      this.writeBytes(var1.array, 0, var1.offset);
   }

    @ObfuscatedName("br")
    @ObfuscatedSignature(
            descriptor = "(II)V",
            garbageValue = "-109691935"
    )
    public void writeLengthInt(int var1) {
      if (var1 < 0) {
         throw new IllegalArgumentException();
      } else {
         this.array[this.offset - var1 - 4] = (byte)(var1 >> 24);
         this.array[this.offset - var1 - 3] = (byte)(var1 >> 16);
         this.array[this.offset - var1 - 2] = (byte)(var1 >> 8);
         this.array[this.offset - var1 - 1] = (byte)var1;
      }
   }

    @ObfuscatedName("bm")
    @ObfuscatedSignature(
            descriptor = "(II)V",
            garbageValue = "-63060014"
    )
    public void writeLengthShort(int var1) {
      if (var1 >= 0 && var1 <= 65535) {
         this.array[this.offset - var1 - 2] = (byte)(var1 >> 8);
         this.array[this.offset - var1 - 1] = (byte)var1;
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("be")
   @ObfuscatedSignature(
      descriptor = "(II)V",
      garbageValue = "-2090557800"
   )
   public void method2434(int var1) {
      if (var1 >= 0 && var1 <= 255) {
         this.array[this.offset - var1 - 1] = (byte)var1;
      } else {
         throw new IllegalArgumentException();
      }
   }

    @ObfuscatedName("bo")
    @ObfuscatedSignature(
            descriptor = "(II)V",
            garbageValue = "1976958769"
    )
    public void writeSmartByteShort(int var1) {
      if (var1 >= 0 && var1 < 128) {
         this.writeByte(var1);
      } else if (var1 >= 0 && var1 < 32768) {
         this.writeShort(var1 + '耀');
      } else {
         throw new IllegalArgumentException();
      }
   }

    @ObfuscatedName("bl")
    @ObfuscatedSignature(
            descriptor = "(IB)V",
            garbageValue = "3"
    )
    public void writeVarInt(int var1) {
      if ((var1 & -128) != 0) {
         if ((var1 & -16384) != 0) {
            if ((var1 & -2097152) != 0) {
               if ((var1 & -268435456) != 0) {
                  this.writeByte(var1 >>> 28 | 128);
               }

               this.writeByte(var1 >>> 21 | 128);
            }

            this.writeByte(var1 >>> 14 | 128);
         }

         this.writeByte(var1 >>> 7 | 128);
      }

      this.writeByte(var1 & 127);
   }

    @ObfuscatedName("bq")
    @ObfuscatedSignature(
            descriptor = "(I)I",
            garbageValue = "953878016"
    )
    public int readUnsignedByte() {
      return this.array[++this.offset - 1] & 255;
   }

    @ObfuscatedName("bn")
    @ObfuscatedSignature(
            descriptor = "(I)B",
            garbageValue = "487276553"
    )
    public byte readByte() {
      return this.array[++this.offset - 1];
   }

    @ObfuscatedName("bi")
    @ObfuscatedSignature(
            descriptor = "(I)I",
            garbageValue = "618352324"
    )
    public int readUnsignedShort() {
      this.offset += 2;
      return (this.array[this.offset - 1] & 255) + ((this.array[this.offset - 2] & 255) << 8);
   }

    @ObfuscatedName("bw")
    @ObfuscatedSignature(
            descriptor = "(B)I",
            garbageValue = "80"
    )
    public int readShort() {
      this.offset += 2;
      int var1 = (this.array[this.offset - 1] & 255) + ((this.array[this.offset - 2] & 255) << 8);
      if (var1 > 32767) {
         var1 -= 65536;
      }

      return var1;
   }

    @ObfuscatedName("bt")
    @ObfuscatedSignature(
            descriptor = "(I)I",
            garbageValue = "1144305669"
    )
    public int readMedium() {
      this.offset += 3;
      return ((this.array[this.offset - 3] & 255) << 16) + (this.array[this.offset - 1] & 255) + ((this.array[this.offset - 2] & 255) << 8);
   }

    @ObfuscatedName("bd")
    @ObfuscatedSignature(
            descriptor = "(I)I",
            garbageValue = "-353043483"
    )
    public int readInt() {
      this.offset += 4;
      return ((this.array[this.offset - 3] & 255) << 16) + (this.array[this.offset - 1] & 255) + ((this.array[this.offset - 2] & 255) << 8) + ((this.array[this.offset - 4] & 255) << 24);
   }

    @ObfuscatedName("bg")
    @ObfuscatedSignature(
            descriptor = "(I)J",
            garbageValue = "792803189"
    )
    public long readLong() {
      long var1 = (long)this.readInt() & 4294967295L;
      long var3 = (long)this.readInt() & 4294967295L;
      return var3 + (var1 << 32);
   }

   @ObfuscatedName("bb")
   @ObfuscatedSignature(
      descriptor = "(I)F",
      garbageValue = "1171371205"
   )
   public float method2428() {
      return Float.intBitsToFloat(this.readInt());
   }

    @ObfuscatedName("bk")
    @ObfuscatedSignature(
            descriptor = "(I)Z",
            garbageValue = "-1415924106"
    )
    public boolean readBoolean() {
      return (this.readUnsignedByte() & 1) == 1;
   }

    @ObfuscatedName("bs")
    @ObfuscatedSignature(
            descriptor = "(B)Ljava/lang/String;",
            garbageValue = "1"
    )
    public String readStringCp1252NullTerminatedOrNull() {
      if (this.array[this.offset] == 0) {
         ++this.offset;
         return null;
      } else {
         return this.readStringCp1252NullTerminated();
      }
   }

    @ObfuscatedName("by")
    @ObfuscatedSignature(
            descriptor = "(I)Ljava/lang/String;",
            garbageValue = "1425951954"
    )
    public String readStringCp1252NullTerminated() {
      int var1 = this.offset;

      while(this.array[++this.offset - 1] != 0) {
         ;
      }

      int var2 = this.offset - var1 - 1;
      return var2 == 0 ? "" : class101.decodeStringCp1252(this.array, var1, var2);
   }

    @ObfuscatedName("bu")
    @ObfuscatedSignature(
            descriptor = "(I)Ljava/lang/String;",
            garbageValue = "27341435"
    )
    public String readStringCp1252NullCircumfixed() {
      byte var1 = this.array[++this.offset - 1];
      if (var1 != 0) {
         throw new IllegalStateException("");
      } else {
         int var2 = this.offset;

         while(this.array[++this.offset - 1] != 0) {
            ;
         }

         int var3 = this.offset - var2 - 1;
         return var3 == 0 ? "" : class101.decodeStringCp1252(this.array, var2, var3);
      }
   }

    @ObfuscatedName("bp")
    @ObfuscatedSignature(
            descriptor = "(S)Ljava/lang/String;",
            garbageValue = "-1367"
    )
    public String readCESU8() {
      byte var1 = this.array[++this.offset - 1];
      if (var1 != 0) {
         throw new IllegalStateException("");
      } else {
         int var2 = this.readVarInt();
         if (var2 + this.offset > this.array.length) {
            throw new IllegalStateException("");
         } else {
            String var3 = class285.method1547(this.array, this.offset, var2);
            this.offset += var2;
            return var3;
         }
      }
   }

    @ObfuscatedName("bc")
    @ObfuscatedSignature(
            descriptor = "([BIII)V",
            garbageValue = "-345920615"
    )
    public void readBytes(byte[] var1, int var2, int var3) {
      for(int var4 = var2; var4 < var3 + var2; ++var4) {
         var1[var4] = this.array[++this.offset - 1];
      }

   }

    @ObfuscatedName("ba")
    @ObfuscatedSignature(
            descriptor = "(I)I",
            garbageValue = "-1527077810"
    )
    public int readShortSmart() {
      int var1 = this.array[this.offset] & 255;
      return var1 < 128 ? this.readUnsignedByte() - 64 : this.readUnsignedShort() - '쀀';
   }

    @ObfuscatedName("bh")
    @ObfuscatedSignature(
            descriptor = "(I)I",
            garbageValue = "629721821"
    )
    public int readUShortSmart() {
      int var1 = this.array[this.offset] & 255;
      return var1 < 128 ? this.readUnsignedByte() : this.readUnsignedShort() - '耀';
   }

   @ObfuscatedName("bx")
   @ObfuscatedSignature(
      descriptor = "(S)I",
      garbageValue = "5397"
   )
   public int method2389() {
      int var1 = this.array[this.offset] & 255;
      return var1 < 128 ? this.readUnsignedByte() - 1 : this.readUnsignedShort() - '老';
   }

   @ObfuscatedName("bv")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "1585949147"
   )
   public int method2433() {
      int var1 = 0;

      int var2;
      for(var2 = this.readUShortSmart(); var2 == 32767; var2 = this.readUShortSmart()) {
         var1 += 32767;
      }

      var1 += var2;
      return var1;
   }

   @ObfuscatedName("cu")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "2005911830"
   )
   public int method2391() {
      return this.array[this.offset] < 0 ? this.readInt() & Integer.MAX_VALUE : this.readUnsignedShort();
   }

   @ObfuscatedName("cr")
   @ObfuscatedSignature(
      descriptor = "(B)I",
      garbageValue = "-16"
   )
   public int method2419() {
      if (this.array[this.offset] < 0) {
         return this.readInt() & Integer.MAX_VALUE;
      } else {
         int var1 = this.readUnsignedShort();
         return var1 == 32767 ? -1 : var1;
      }
   }

    @ObfuscatedName("cs")
    @ObfuscatedSignature(
            descriptor = "(I)I",
            garbageValue = "-1017425197"
    )
    public int readVarInt() {
      byte var1 = this.array[++this.offset - 1];

      int var2;
      for(var2 = 0; var1 < 0; var1 = this.array[++this.offset - 1]) {
         var2 = (var2 | var1 & 127) << 7;
      }

      return var2 | var1;
   }

   @ObfuscatedName("cp")
   @ObfuscatedSignature(
      descriptor = "(B)I",
      garbageValue = "-2"
   )
   public int method2394() {
      int var2 = 0;
      int var3 = 0;

      int var1;
      do {
         var1 = this.readUnsignedByte();
         var2 |= (var1 & 127) << var3;
         var3 += 7;
      } while(var1 > 127);

      return var2;
   }

    @ObfuscatedName("cq")
    @ObfuscatedSignature(
            descriptor = "([II)V",
            garbageValue = "-504157686"
    )
    public void xteaEncryptAll(int[] var1) {
      int var2 = this.offset / 8;
      this.offset = 0;

      for(int var3 = 0; var3 < var2; ++var3) {
         int var4 = this.readInt();
         int var5 = this.readInt();
         int var6 = 0;
         int var7 = -1640531527;

         for(int var8 = 32; var8-- > 0; var5 += var4 + (var4 << 4 ^ var4 >>> 5) ^ var1[var6 >>> 11 & 3] + var6) {
            var4 += var5 + (var5 << 4 ^ var5 >>> 5) ^ var6 + var1[var6 & 3];
            var6 += var7;
         }

         this.offset -= 8;
         this.writeInt(var4);
         this.writeInt(var5);
      }

   }

    @ObfuscatedName("cd")
    @ObfuscatedSignature(
            descriptor = "([IB)V",
            garbageValue = "-126"
    )
    public void xteaDecryptAll(int[] var1) {
      int var2 = this.offset / 8;
      this.offset = 0;

      for(int var3 = 0; var3 < var2; ++var3) {
         int var4 = this.readInt();
         int var5 = this.readInt();
         int var6 = -957401312;
         int var7 = -1640531527;

         for(int var8 = 32; var8-- > 0; var4 -= var5 + (var5 << 4 ^ var5 >>> 5) ^ var6 + var1[var6 & 3]) {
            var5 -= var4 + (var4 << 4 ^ var4 >>> 5) ^ var1[var6 >>> 11 & 3] + var6;
            var6 -= var7;
         }

         this.offset -= 8;
         this.writeInt(var4);
         this.writeInt(var5);
      }

   }

    @ObfuscatedName("cc")
    @ObfuscatedSignature(
            descriptor = "([IIII)V",
            garbageValue = "-905803903"
    )
    public void xteaEncrypt(int[] var1, int var2, int var3) {
      int var4 = this.offset;
      this.offset = var2;
      int var5 = (var3 - var2) / 8;

      for(int var6 = 0; var6 < var5; ++var6) {
         int var7 = this.readInt();
         int var8 = this.readInt();
         int var9 = 0;
         int var10 = -1640531527;

         for(int var11 = 32; var11-- > 0; var8 += var7 + (var7 << 4 ^ var7 >>> 5) ^ var1[var9 >>> 11 & 3] + var9) {
            var7 += var8 + (var8 << 4 ^ var8 >>> 5) ^ var9 + var1[var9 & 3];
            var9 += var10;
         }

         this.offset -= 8;
         this.writeInt(var7);
         this.writeInt(var8);
      }

      this.offset = var4;
   }

    @ObfuscatedName("ch")
    @ObfuscatedSignature(
            descriptor = "([IIII)V",
            garbageValue = "-432877119"
    )
    public void xteaDecrypt(int[] var1, int var2, int var3) {
      int var4 = this.offset;
      this.offset = var2;
      int var5 = (var3 - var2) / 8;

      for(int var6 = 0; var6 < var5; ++var6) {
         int var7 = this.readInt();
         int var8 = this.readInt();
         int var9 = -957401312;
         int var10 = -1640531527;

         for(int var11 = 32; var11-- > 0; var7 -= var8 + (var8 << 4 ^ var8 >>> 5) ^ var9 + var1[var9 & 3]) {
            var8 -= var7 + (var7 << 4 ^ var7 >>> 5) ^ var1[var9 >>> 11 & 3] + var9;
            var9 -= var10;
         }

         this.offset -= 8;
         this.writeInt(var7);
         this.writeInt(var8);
      }

      this.offset = var4;
   }

    @ObfuscatedName("ck")
    @ObfuscatedSignature(
            descriptor = "(Ljava/math/BigInteger;Ljava/math/BigInteger;B)V",
            garbageValue = "-57"
    )
    public void encryptRsa(BigInteger var1, BigInteger var2) {
      int var3 = this.offset;
      this.offset = 0;
      byte[] var4 = new byte[var3];
      this.readBytes(var4, 0, var3);
      BigInteger var5 = new BigInteger(var4);
      BigInteger var6 = var5.modPow(var1, var2);
      byte[] var7 = var6.toByteArray();
      this.offset = 0;
      this.writeShort(var7.length);
      this.writeBytes(var7, 0, var7.length);
   }

    @ObfuscatedName("cl")
    @ObfuscatedSignature(
            descriptor = "(IS)I",
            garbageValue = "23268"
    )
    public int writeCrc(int var1) {
      int var2 = IgnoreList.method2060(this.array, var1, this.offset);
      this.writeInt(var2);
      return var2;
   }

    @ObfuscatedName("cx")
    @ObfuscatedSignature(
            descriptor = "(B)Z",
            garbageValue = "71"
    )
    public boolean checkCrc() {
      this.offset -= 4;
      int var1 = IgnoreList.method2060(this.array, 0, this.offset);
      int var2 = this.readInt();
      return var1 == var2;
   }

   @ObfuscatedName("ct")
   @ObfuscatedSignature(
      descriptor = "(IB)V",
      garbageValue = "93"
   )
   public void method2399(int var1) {
      this.array[++this.offset - 1] = (byte)(var1 + 128);
   }

    @ObfuscatedName("cb")
    @ObfuscatedSignature(
            descriptor = "(II)V",
            garbageValue = "1152640181"
    )
    public void writeByteS(int var1) {
      this.array[++this.offset - 1] = (byte)(0 - var1);
   }

    @ObfuscatedName("cz")
    @ObfuscatedSignature(
            descriptor = "(IB)V",
            garbageValue = "-6"
    )
    public void writeByteA(int var1) {
      this.array[++this.offset - 1] = (byte)(128 - var1);
   }

   @ObfuscatedName("ca")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "1963653347"
   )
   public int method2401() {
      return this.array[++this.offset - 1] - 128 & 255;
   }

    @ObfuscatedName("cy")
    @ObfuscatedSignature(
            descriptor = "(B)I",
            garbageValue = "-86"
    )
    public int readUnsignedShortA() {
      return 0 - this.array[++this.offset - 1] & 255;
   }

    @ObfuscatedName("cv")
    @ObfuscatedSignature(
            descriptor = "(B)I",
            garbageValue = "6"
    )
    public int readUnsignedByteA() {
      return 128 - this.array[++this.offset - 1] & 255;
   }

   @ObfuscatedName("cf")
   @ObfuscatedSignature(
      descriptor = "(I)B",
      garbageValue = "183282951"
   )
   public byte method2404() {
      return (byte)(this.array[++this.offset - 1] - 128);
   }

   @ObfuscatedName("cm")
   @ObfuscatedSignature(
      descriptor = "(I)B",
      garbageValue = "-474371999"
   )
   public byte method2431() {
      return (byte)(0 - this.array[++this.offset - 1]);
   }

   @ObfuscatedName("ce")
   @ObfuscatedSignature(
      descriptor = "(I)B",
      garbageValue = "608108518"
   )
   public byte method2442() {
      return (byte)(128 - this.array[++this.offset - 1]);
   }

    @ObfuscatedName("co")
    @ObfuscatedSignature(
            descriptor = "(II)V",
            garbageValue = "-2032694822"
    )
    public void writeShortA(int var1) {
      this.array[++this.offset - 1] = (byte)var1;
      this.array[++this.offset - 1] = (byte)(var1 >> 8);
   }

    @ObfuscatedName("cg")
    @ObfuscatedSignature(
            descriptor = "(II)V",
            garbageValue = "-1610016705"
    )
    public void writeShortLE(int var1) {
      this.array[++this.offset - 1] = (byte)(var1 >> 8);
      this.array[++this.offset - 1] = (byte)(var1 + 128);
   }

    @ObfuscatedName("cj")
    @ObfuscatedSignature(
            descriptor = "(II)V",
            garbageValue = "974533362"
    )
    public void writeShortLEA(int var1) {
      this.array[++this.offset - 1] = (byte)(var1 + 128);
      this.array[++this.offset - 1] = (byte)(var1 >> 8);
   }

    @ObfuscatedName("ci")
    @ObfuscatedSignature(
            descriptor = "(I)I",
            garbageValue = "-927694440"
    )
    public int readUnsignedShortLEA() {
      this.offset += 2;
      return ((this.array[this.offset - 1] & 255) << 8) + (this.array[this.offset - 2] & 255);
   }

    @ObfuscatedName("cn")
    @ObfuscatedSignature(
            descriptor = "(B)I",
            garbageValue = "0"
    )
    public int readUnsignedByteS() {
      this.offset += 2;
      return (this.array[this.offset - 1] - 128 & 255) + ((this.array[this.offset - 2] & 255) << 8);
   }

    @ObfuscatedName("cw")
    @ObfuscatedSignature(
            descriptor = "(I)I",
            garbageValue = "-1354782353"
    )
    public int readUnsignedShortLE() {
      this.offset += 2;
      return ((this.array[this.offset - 1] & 255) << 8) + (this.array[this.offset - 2] - 128 & 255);
   }

   @ObfuscatedName("dw")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "285070066"
   )
   public int method2408() {
      this.offset += 2;
      int var1 = ((this.array[this.offset - 1] & 255) << 8) + (this.array[this.offset - 2] & 255);
      if (var1 > 32767) {
         var1 -= 65536;
      }

      return var1;
   }

   @ObfuscatedName("dz")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "1019917442"
   )
   public int method2409() {
      this.offset += 2;
      int var1 = ((this.array[this.offset - 1] & 255) << 8) + (this.array[this.offset - 2] - 128 & 255);
      if (var1 > 32767) {
         var1 -= 65536;
      }

      return var1;
   }

   @ObfuscatedName("db")
   @ObfuscatedSignature(
      descriptor = "(IB)V",
      garbageValue = "3"
   )
   public void writeMediumMiddle(int var1) {
      this.array[++this.offset - 1] = (byte)(var1 >> 8);
      this.array[++this.offset - 1] = (byte)(var1 >> 16);
      this.array[++this.offset - 1] = (byte)var1;
   }

   @ObfuscatedName("di")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "-2100252481"
   )
   public int method2439() {
      this.offset += 3;
      return (this.array[this.offset - 3] & 255) + ((this.array[this.offset - 2] & 255) << 8) + ((this.array[this.offset - 1] & 255) << 16);
   }

   @ObfuscatedName("dy")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "1742665826"
   )
   public int method2412() {
      this.offset += 3;
      return (this.array[this.offset - 1] & 255) + ((this.array[this.offset - 3] & 255) << 8) + ((this.array[this.offset - 2] & 255) << 16);
   }

   @ObfuscatedName("dg")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "1246652927"
   )
   public int method2420() {
      this.offset += 3;
      int var1 = (this.array[this.offset - 3] & 255) + ((this.array[this.offset - 2] & 255) << 8) + ((this.array[this.offset - 1] & 255) << 16);
      if (var1 > 8388607) {
         var1 -= 16777216;
      }

      return var1;
   }

   @ObfuscatedName("dm")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "1501574391"
   )
   public int method2413() {
      this.offset += 3;
      int var1 = ((this.array[this.offset - 1] & 255) << 8) + ((this.array[this.offset - 3] & 255) << 16) + (this.array[this.offset - 2] & 255);
      if (var1 > 8388607) {
         var1 -= 16777216;
      }

      return var1;
   }

   @ObfuscatedName("dn")
   @ObfuscatedSignature(
      descriptor = "(IS)V",
      garbageValue = "10363"
   )
   public void method2441(int var1) {
      this.array[++this.offset - 1] = (byte)var1;
      this.array[++this.offset - 1] = (byte)(var1 >> 8);
      this.array[++this.offset - 1] = (byte)(var1 >> 16);
      this.array[++this.offset - 1] = (byte)(var1 >> 24);
   }

   @ObfuscatedName("df")
   @ObfuscatedSignature(
      descriptor = "(IB)V",
      garbageValue = "41"
   )
   public void method2414(int var1) {
      this.array[++this.offset - 1] = (byte)(var1 >> 8);
      this.array[++this.offset - 1] = (byte)var1;
      this.array[++this.offset - 1] = (byte)(var1 >> 24);
      this.array[++this.offset - 1] = (byte)(var1 >> 16);
   }

   @ObfuscatedName("dv")
   @ObfuscatedSignature(
      descriptor = "(IB)V",
      garbageValue = "63"
   )
   public void method2382(int var1) {
      this.array[++this.offset - 1] = (byte)(var1 >> 16);
      this.array[++this.offset - 1] = (byte)(var1 >> 24);
      this.array[++this.offset - 1] = (byte)var1;
      this.array[++this.offset - 1] = (byte)(var1 >> 8);
   }

   @ObfuscatedName("dr")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "1253284220"
   )
   public int method2415() {
      this.offset += 4;
      return (this.array[this.offset - 4] & 255) + ((this.array[this.offset - 3] & 255) << 8) + ((this.array[this.offset - 2] & 255) << 16) + ((this.array[this.offset - 1] & 255) << 24);
   }

   @ObfuscatedName("do")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "-528886777"
   )
   public int method2416() {
      this.offset += 4;
      return ((this.array[this.offset - 2] & 255) << 24) + ((this.array[this.offset - 4] & 255) << 8) + (this.array[this.offset - 3] & 255) + ((this.array[this.offset - 1] & 255) << 16);
   }

   @ObfuscatedName("dt")
   @ObfuscatedSignature(
      descriptor = "(S)I",
      garbageValue = "255"
   )
   public int method2417() {
      this.offset += 4;
      return ((this.array[this.offset - 1] & 255) << 8) + ((this.array[this.offset - 4] & 255) << 16) + (this.array[this.offset - 2] & 255) + ((this.array[this.offset - 3] & 255) << 24);
   }

    @ObfuscatedName("dl")
    @ObfuscatedSignature(
            descriptor = "([BIII)V",
            garbageValue = "-1640541886"
    )
    public void readBytesAReverse(byte[] var1, int var2, int var3) {
      for(int var4 = var3 + var2 - 1; var4 >= var2; --var4) {
         var1[var4] = (byte)(this.array[++this.offset - 1] - 128);
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      descriptor = "(Lln;III)Z",
      garbageValue = "274517140"
   )
   public static boolean method2444(AbstractArchive var0, int var1, int var2) {
      byte[] var3 = var0.takeFile(var1, var2);
      if (var3 == null) {
         return false;
      } else {
         FriendLoginUpdate.SpriteBuffer_decode(var3);
         return true;
      }
   }
}
