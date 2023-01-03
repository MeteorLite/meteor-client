import java.util.List;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ax")
@Implements("PcmPlayer")
public class PcmPlayer {
   @ObfuscatedName("vd")
   static List field205;
   @ObfuscatedName("m")
   public static int field198;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      descriptor = "Law;"
   )
   @Export("soundSystem")
   static SoundSystem soundSystem;
   @ObfuscatedName("j")
   @Export("Tiles_saturation")
   static int[] Tiles_saturation;
   @ObfuscatedName("o")
   @Export("samples")
   protected int[] samples;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      descriptor = "Laa;"
   )
   @Export("stream")
   PcmStream stream;
   @ObfuscatedName("k")
   int field190 = 32;
   @ObfuscatedName("a")
   @Export("timeMs")
   long timeMs = Message.method344();
   @ObfuscatedName("s")
   @Export("capacity")
   int capacity;
   @ObfuscatedName("l")
   int field193;
   @ObfuscatedName("t")
   int field186;
   @ObfuscatedName("c")
   long field195 = 0L;
   @ObfuscatedName("p")
   int field196 = 0;
   @ObfuscatedName("d")
   int field197 = 0;
   @ObfuscatedName("y")
   int field202 = 0;
   @ObfuscatedName("z")
   long field191 = 0L;
   @ObfuscatedName("w")
   boolean field200 = true;
   @ObfuscatedName("au")
   int field201 = 0;
   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      descriptor = "[Laa;"
   )
   PcmStream[] field194 = new PcmStream[8];
   @ObfuscatedName("at")
   @ObfuscatedSignature(
      descriptor = "[Laa;"
   )
   PcmStream[] field203 = new PcmStream[8];

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "-1022018312"
   )
   @Export("init")
   protected void init() throws Exception {
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "(IB)V",
      garbageValue = "-95"
   )
   @Export("open")
   protected void open(int var1) throws Exception {
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "(B)I",
      garbageValue = "116"
   )
   @Export("position")
   protected int position() throws Exception {
      return this.capacity;
   }

   @ObfuscatedName("x")
   @Export("write")
   protected void write() throws Exception {
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "-126"
   )
   @Export("close")
   protected void close() {
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "1458227244"
   )
   @Export("discard")
   protected void discard() throws Exception {
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      descriptor = "(Laa;I)V",
      garbageValue = "-2127499053"
   )
   @Export("setStream")
   public final synchronized void setStream(PcmStream var1) {
      this.stream = var1;
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "-431761037"
   )
   @Export("run")
   public final synchronized void run() {
      if (this.samples != null) {
         long var1 = Message.method344();

         try {
            if (0L != this.field195) {
               if (var1 < this.field195) {
                  return;
               }

               this.open(this.capacity);
               this.field195 = 0L;
               this.field200 = true;
            }

            int var3 = this.position();
            if (this.field202 - var3 > this.field196) {
               this.field196 = this.field202 - var3;
            }

            int var4 = this.field186 + this.field193;
            if (var4 + 256 > 16384) {
               var4 = 16128;
            }

            if (var4 + 256 > this.capacity) {
               this.capacity += 1024;
               if (this.capacity > 16384) {
                  this.capacity = 16384;
               }

               this.close();
               this.open(this.capacity);
               var3 = 0;
               this.field200 = true;
               if (var4 + 256 > this.capacity) {
                  var4 = this.capacity - 256;
                  this.field186 = var4 - this.field193;
               }
            }

            while(var3 < var4) {
               this.fill(this.samples, 256);
               this.write();
               var3 += 256;
            }

            if (var1 > this.field191) {
               if (!this.field200) {
                  if (this.field196 == 0 && this.field197 == 0) {
                     this.close();
                     this.field195 = 2000L + var1;
                     return;
                  }

                  this.field186 = Math.min(this.field197, this.field196);
                  this.field197 = this.field196;
               } else {
                  this.field200 = false;
               }

               this.field196 = 0;
               this.field191 = 2000L + var1;
            }

            this.field202 = var3;
         } catch (Exception var7) {
            this.close();
            this.field195 = var1 + 2000L;
         }

         try {
            if (var1 > 500000L + this.timeMs) {
               var1 = this.timeMs;
            }

            while(var1 > 5000L + this.timeMs) {
               this.skip(256);
               this.timeMs += (long)(256000 / field198);
            }
         } catch (Exception var6) {
            this.timeMs = var1;
         }

      }
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "-2068894886"
   )
   public final void method226() {
      this.field200 = true;
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "-54"
   )
   @Export("tryDiscard")
   public final synchronized void tryDiscard() {
      this.field200 = true;

      try {
         this.discard();
      } catch (Exception var2) {
         this.close();
         this.field195 = Message.method344() + 2000L;
      }

   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "1880345802"
   )
   @Export("shutdown")
   public final synchronized void shutdown() {
      if (soundSystem != null) {
         boolean var1 = true;

         for(int var2 = 0; var2 < 2; ++var2) {
            if (this == soundSystem.players[var2]) {
               soundSystem.players[var2] = null;
            }

            if (soundSystem.players[var2] != null) {
               var1 = false;
            }
         }

         if (var1) {
            class11.soundSystemExecutor.shutdownNow();
            class11.soundSystemExecutor = null;
            soundSystem = null;
         }
      }

      this.close();
      this.samples = null;
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      descriptor = "(II)V",
      garbageValue = "434161889"
   )
   @Export("skip")
   final void skip(int var1) {
      this.field201 -= var1;
      if (this.field201 < 0) {
         this.field201 = 0;
      }

      if (this.stream != null) {
         this.stream.skip(var1);
      }

   }

   @ObfuscatedName("an")
   @Export("fill")
   final void fill(int[] var1, int var2) {
      int var3 = var2;
      if (class286.PcmPlayer_stereo) {
         var3 = var2 << 1;
      }

      class373.clearIntArray(var1, 0, var3);
      this.field201 -= var2;
      if (this.stream != null && this.field201 <= 0) {
         this.field201 += field198 >> 4;
         GrandExchangeEvents.PcmStream_disable(this.stream);
         this.method220(this.stream, this.stream.vmethod1019());
         int var4 = 0;
         int var5 = 255;

         int var6;
         PcmStream var10;
         label105:
         for(var6 = 7; var5 != 0; --var6) {
            int var7;
            int var8;
            if (var6 < 0) {
               var7 = var6 & 3;
               var8 = -(var6 >> 2);
            } else {
               var7 = var6;
               var8 = 0;
            }

            for(int var9 = var5 >>> var7 & 286331153; var9 != 0; var9 >>>= 4) {
               if ((var9 & 1) != 0) {
                  var5 &= ~(1 << var7);
                  var10 = null;
                  PcmStream var11 = this.field194[var7];

                  label99:
                  while(true) {
                     while(true) {
                        if (var11 == null) {
                           break label99;
                        }

                        AbstractSound var12 = var11.sound;
                        if (var12 != null && var12.position > var8) {
                           var5 |= 1 << var7;
                           var10 = var11;
                           var11 = var11.after;
                        } else {
                           var11.active = true;
                           int var13 = var11.vmethod5648();
                           var4 += var13;
                           if (var12 != null) {
                              var12.position += var13;
                           }

                           if (var4 >= this.field190) {
                              break label105;
                           }

                           PcmStream var14 = var11.firstSubStream();
                           if (var14 != null) {
                              for(int var15 = var11.field249; var14 != null; var14 = var11.nextSubStream()) {
                                 this.method220(var14, var15 * var14.vmethod1019() >> 8);
                              }
                           }

                           PcmStream var16 = var11.after;
                           var11.after = null;
                           if (var10 == null) {
                              this.field194[var7] = var16;
                           } else {
                              var10.after = var16;
                           }

                           if (var16 == null) {
                              this.field203[var7] = var10;
                           }

                           var11 = var16;
                        }
                     }
                  }
               }

               var7 += 4;
               ++var8;
            }
         }

         for(var6 = 0; var6 < 8; ++var6) {
            PcmStream var17 = this.field194[var6];
            PcmStream[] var18 = this.field194;
            this.field203[var6] = null;

            for(var18[var6] = null; var17 != null; var17 = var10) {
               var10 = var17.after;
               var17.after = null;
            }
         }
      }

      if (this.field201 < 0) {
         this.field201 = 0;
      }

      if (this.stream != null) {
         this.stream.fill(var1, 0, var2);
      }

      this.timeMs = Message.method344();
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "(Laa;II)V",
      garbageValue = "-2144008402"
   )
   final void method220(PcmStream var1, int var2) {
      int var3 = var2 >> 5;
      PcmStream var4 = this.field203[var3];
      if (var4 == null) {
         this.field194[var3] = var1;
      } else {
         var4.after = var1;
      }

      this.field203[var3] = var1;
      var1.field249 = var2;
   }

   @ObfuscatedName("jo")
   @ObfuscatedSignature(
      descriptor = "(ILjava/lang/String;B)V",
      garbageValue = "125"
   )
   static void method229(int var0, String var1) {
      int var2 = Players.Players_count;
      int[] var3 = Players.Players_indices;
      boolean var4 = false;
      Username var5 = new Username(var1, SecureRandomFuture.loginType);

      for(int var6 = 0; var6 < var2; ++var6) {
         Player var7 = Client.players[var3[var6]];
         if (var7 != null && var7 != class155.localPlayer && var7.username != null && var7.username.equals(var5)) {
            PacketBufferNode var8;
            if (var0 == 1) {
               var8 = class136.getPacketBufferNode(ClientPacket.field2475, Client.packetWriter.isaacCipher);
               var8.packetBuffer.writeByte(0);
               var8.packetBuffer.writeShort(var3[var6]);
               Client.packetWriter.addNode(var8);
            } else if (var0 == 4) {
               var8 = class136.getPacketBufferNode(ClientPacket.field2431, Client.packetWriter.isaacCipher);
               var8.packetBuffer.writeShort(var3[var6]);
               var8.packetBuffer.method2370(0);
               Client.packetWriter.addNode(var8);
            } else if (var0 == 6) {
               var8 = class136.getPacketBufferNode(ClientPacket.field2450, Client.packetWriter.isaacCipher);
               var8.packetBuffer.method2370(0);
               var8.packetBuffer.writeShort(var3[var6]);
               Client.packetWriter.addNode(var8);
            } else if (var0 == 7) {
               var8 = class136.getPacketBufferNode(ClientPacket.field2489, Client.packetWriter.isaacCipher);
               var8.packetBuffer.method2375(var3[var6]);
               var8.packetBuffer.method2370(0);
               Client.packetWriter.addNode(var8);
            }

            var4 = true;
            break;
         }
      }

      if (!var4) {
         KitDefinition.addGameMessage(4, "", "Unable to find " + var1);
      }

   }
}
