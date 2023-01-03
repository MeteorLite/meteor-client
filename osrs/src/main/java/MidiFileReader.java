import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("km")
@Implements("MidiFileReader")
public class MidiFileReader {
   @ObfuscatedName("b")
   static final byte[] field2746 = new byte[]{2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 0, 1, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "Lqy;"
   )
   @Export("buffer")
   Buffer buffer = new Buffer((byte[])null);
   @ObfuscatedName("e")
   @Export("division")
   int division;
   @ObfuscatedName("v")
   @Export("trackStarts")
   int[] trackStarts;
   @ObfuscatedName("x")
   @Export("trackPositions")
   int[] trackPositions;
   @ObfuscatedName("m")
   @Export("trackLengths")
   int[] trackLengths;
   @ObfuscatedName("q")
   int[] field2748;
   @ObfuscatedName("f")
   int field2744;
   @ObfuscatedName("u")
   long field2749;

   MidiFileReader(byte[] var1) {
      this.parse(var1);
   }

   MidiFileReader() {
   }

   @ObfuscatedName("h")
   @Export("parse")
   void parse(byte[] var1) {
      this.buffer.array = var1;
      this.buffer.offset = 10;
      int var2 = this.buffer.readUnsignedShort();
      this.division = this.buffer.readUnsignedShort();
      this.field2744 = 500000;
      this.trackStarts = new int[var2];

      int var3;
      int var5;
      for(var3 = 0; var3 < var2; this.buffer.offset += var5) {
         int var4 = this.buffer.readInt();
         var5 = this.buffer.readInt();
         if (var4 == 1297379947) {
            this.trackStarts[var3] = this.buffer.offset;
            ++var3;
         }
      }

      this.field2749 = 0L;
      this.trackPositions = new int[var2];

      for(var3 = 0; var3 < var2; ++var3) {
         this.trackPositions[var3] = this.trackStarts[var3];
      }

      this.trackLengths = new int[var2];
      this.field2748 = new int[var2];
   }

   @ObfuscatedName("e")
   @Export("clear")
   void clear() {
      this.buffer.array = null;
      this.trackStarts = null;
      this.trackPositions = null;
      this.trackLengths = null;
      this.field2748 = null;
   }

   @ObfuscatedName("v")
   @Export("isReady")
   boolean isReady() {
      return this.buffer.array != null;
   }

   @ObfuscatedName("x")
   @Export("trackCount")
   int trackCount() {
      return this.trackPositions.length;
   }

   @ObfuscatedName("m")
   @Export("gotoTrack")
   void gotoTrack(int var1) {
      this.buffer.offset = this.trackPositions[var1];
   }

   @ObfuscatedName("q")
   @Export("markTrackPosition")
   void markTrackPosition(int var1) {
      this.trackPositions[var1] = this.buffer.offset;
   }

   @ObfuscatedName("f")
   @Export("setTrackDone")
   void setTrackDone() {
      this.buffer.offset = -1;
   }

   @ObfuscatedName("r")
   @Export("readTrackLength")
   void readTrackLength(int var1) {
      int var2 = this.buffer.readVarInt();
      this.trackLengths[var1] += var2;
   }

   @ObfuscatedName("u")
   @Export("readMessage")
   int readMessage(int var1) {
      int var2 = this.readMessage0(var1);
      return var2;
   }

   @ObfuscatedName("b")
   @Export("readMessage0")
   int readMessage0(int var1) {
      byte var2 = this.buffer.array[this.buffer.offset];
      int var5;
      if (var2 < 0) {
         var5 = var2 & 255;
         this.field2748[var1] = var5;
         ++this.buffer.offset;
      } else {
         var5 = this.field2748[var1];
      }

      if (var5 != 240 && var5 != 247) {
         return this.method1587(var1, var5);
      } else {
         int var3 = this.buffer.readVarInt();
         if (var5 == 247 && var3 > 0) {
            int var4 = this.buffer.array[this.buffer.offset] & 255;
            if (var4 >= 241 && var4 <= 243 || var4 == 246 || var4 == 248 || var4 >= 250 && var4 <= 252 || var4 == 254) {
               ++this.buffer.offset;
               this.field2748[var1] = var4;
               return this.method1587(var1, var4);
            }
         }

         this.buffer.offset += var3;
         return 0;
      }
   }

   @ObfuscatedName("j")
   int method1587(int var1, int var2) {
      int var4;
      if (var2 == 255) {
         int var7 = this.buffer.readUnsignedByte();
         var4 = this.buffer.readVarInt();
         if (var7 == 47) {
            this.buffer.offset += var4;
            return 1;
         } else if (var7 == 81) {
            int var5 = this.buffer.readMedium();
            var4 -= 3;
            int var6 = this.trackLengths[var1];
            this.field2749 += (long)var6 * (long)(this.field2744 - var5);
            this.field2744 = var5;
            this.buffer.offset += var4;
            return 2;
         } else {
            this.buffer.offset += var4;
            return 3;
         }
      } else {
         byte var3 = field2746[var2 - 128];
         var4 = var2;
         if (var3 >= 1) {
            var4 = var2 | this.buffer.readUnsignedByte() << 8;
         }

         if (var3 >= 2) {
            var4 |= this.buffer.readUnsignedByte() << 16;
         }

         return var4;
      }
   }

   @ObfuscatedName("g")
   long method1586(int var1) {
      return this.field2749 + (long)var1 * (long)this.field2744;
   }

   @ObfuscatedName("i")
   @Export("getPrioritizedTrack")
   int getPrioritizedTrack() {
      int var1 = this.trackPositions.length;
      int var2 = -1;
      int var3 = Integer.MAX_VALUE;

      for(int var4 = 0; var4 < var1; ++var4) {
         if (this.trackPositions[var4] >= 0 && this.trackLengths[var4] < var3) {
            var2 = var4;
            var3 = this.trackLengths[var4];
         }
      }

      return var2;
   }

   @ObfuscatedName("o")
   @Export("isDone")
   boolean isDone() {
      int var1 = this.trackPositions.length;

      for(int var2 = 0; var2 < var1; ++var2) {
         if (this.trackPositions[var2] >= 0) {
            return false;
         }
      }

      return true;
   }

   @ObfuscatedName("n")
   @Export("reset")
   void reset(long var1) {
      this.field2749 = var1;
      int var3 = this.trackPositions.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         this.trackLengths[var4] = 0;
         this.field2748[var4] = 0;
         this.buffer.offset = this.trackStarts[var4];
         this.readTrackLength(var4);
         this.trackPositions[var4] = this.buffer.offset;
      }

   }
}
