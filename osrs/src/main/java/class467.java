import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("qz")
public class class467 {
   @ObfuscatedName("u")
   public static int musicTrackVolume;
   @ObfuscatedName("h")
   int[] field3996 = new int[8];
   @ObfuscatedName("e")
   short[] field3995 = new short[8];

   @ObfuscatedSignature(
      descriptor = "(Lgz;)V"
   )
   public class467(NPCComposition var1) {
      int var2 = 0;
      if (var1.method958()) {
         var2 = var1.method961().length;
         System.arraycopy(var1.method961(), 0, this.field3996, 0, var2);
         System.arraycopy(var1.method964(), 0, this.field3995, 0, var2);
      }

      for(int var3 = var2; var3 < 8; ++var3) {
         this.field3996[var3] = -1;
         this.field3995[var3] = -1;
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(I)[I",
      garbageValue = "2005193688"
   )
   public int[] method2408() {
      return this.field3996;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "(I)[S",
      garbageValue = "1232945994"
   )
   public short[] method2409() {
      return this.field3995;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "(IISI)V",
      garbageValue = "727886744"
   )
   public void method2410(int var1, int var2, short var3) {
      this.field3996[var1] = var2;
      this.field3995[var1] = var3;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      descriptor = "([I[SI)V",
      garbageValue = "-371112886"
   )
   public void method2411(int[] var1, short[] var2) {
      this.field3996 = var1;
      this.field3995 = var2;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(ILjava/lang/String;Lmb;II)Ljx;",
      garbageValue = "79142033"
   )
   public static PacketBufferNode method2412(int var0, String var1, Language var2, int var3) {
      PacketBufferNode var4 = class136.getPacketBufferNode(ClientPacket.field2449, Client.packetWriter.isaacCipher);
      var4.packetBuffer.writeByte(0);
      int var5 = var4.packetBuffer.offset;
      var4.packetBuffer.writeByte(var0);
      String var6 = var1.toLowerCase();
      byte var7 = 0;
      if (var6.startsWith("yellow:")) {
         var7 = 0;
         var1 = var1.substring("yellow:".length());
      } else if (var6.startsWith("red:")) {
         var7 = 1;
         var1 = var1.substring("red:".length());
      } else if (var6.startsWith("green:")) {
         var7 = 2;
         var1 = var1.substring("green:".length());
      } else if (var6.startsWith("cyan:")) {
         var7 = 3;
         var1 = var1.substring("cyan:".length());
      } else if (var6.startsWith("purple:")) {
         var7 = 4;
         var1 = var1.substring("purple:".length());
      } else if (var6.startsWith("white:")) {
         var7 = 5;
         var1 = var1.substring("white:".length());
      } else if (var6.startsWith("flash1:")) {
         var7 = 6;
         var1 = var1.substring("flash1:".length());
      } else if (var6.startsWith("flash2:")) {
         var7 = 7;
         var1 = var1.substring("flash2:".length());
      } else if (var6.startsWith("flash3:")) {
         var7 = 8;
         var1 = var1.substring("flash3:".length());
      } else if (var6.startsWith("glow1:")) {
         var7 = 9;
         var1 = var1.substring("glow1:".length());
      } else if (var6.startsWith("glow2:")) {
         var7 = 10;
         var1 = var1.substring("glow2:".length());
      } else if (var6.startsWith("glow3:")) {
         var7 = 11;
         var1 = var1.substring("glow3:".length());
      } else if (var2 != Language.Language_EN) {
         if (var6.startsWith("yellow:")) {
            var7 = 0;
            var1 = var1.substring("yellow:".length());
         } else if (var6.startsWith("red:")) {
            var7 = 1;
            var1 = var1.substring("red:".length());
         } else if (var6.startsWith("green:")) {
            var7 = 2;
            var1 = var1.substring("green:".length());
         } else if (var6.startsWith("cyan:")) {
            var7 = 3;
            var1 = var1.substring("cyan:".length());
         } else if (var6.startsWith("purple:")) {
            var7 = 4;
            var1 = var1.substring("purple:".length());
         } else if (var6.startsWith("white:")) {
            var7 = 5;
            var1 = var1.substring("white:".length());
         } else if (var6.startsWith("flash1:")) {
            var7 = 6;
            var1 = var1.substring("flash1:".length());
         } else if (var6.startsWith("flash2:")) {
            var7 = 7;
            var1 = var1.substring("flash2:".length());
         } else if (var6.startsWith("flash3:")) {
            var7 = 8;
            var1 = var1.substring("flash3:".length());
         } else if (var6.startsWith("glow1:")) {
            var7 = 9;
            var1 = var1.substring("glow1:".length());
         } else if (var6.startsWith("glow2:")) {
            var7 = 10;
            var1 = var1.substring("glow2:".length());
         } else if (var6.startsWith("glow3:")) {
            var7 = 11;
            var1 = var1.substring("glow3:".length());
         }
      }

      var6 = var1.toLowerCase();
      byte var8 = 0;
      if (var6.startsWith("wave:")) {
         var8 = 1;
         var1 = var1.substring("wave:".length());
      } else if (var6.startsWith("wave2:")) {
         var8 = 2;
         var1 = var1.substring("wave2:".length());
      } else if (var6.startsWith("shake:")) {
         var8 = 3;
         var1 = var1.substring("shake:".length());
      } else if (var6.startsWith("scroll:")) {
         var8 = 4;
         var1 = var1.substring("scroll:".length());
      } else if (var6.startsWith("slide:")) {
         var8 = 5;
         var1 = var1.substring("slide:".length());
      } else if (var2 != Language.Language_EN) {
         if (var6.startsWith("wave:")) {
            var8 = 1;
            var1 = var1.substring("wave:".length());
         } else if (var6.startsWith("wave2:")) {
            var8 = 2;
            var1 = var1.substring("wave2:".length());
         } else if (var6.startsWith("shake:")) {
            var8 = 3;
            var1 = var1.substring("shake:".length());
         } else if (var6.startsWith("scroll:")) {
            var8 = 4;
            var1 = var1.substring("scroll:".length());
         } else if (var6.startsWith("slide:")) {
            var8 = 5;
            var1 = var1.substring("slide:".length());
         }
      }

      var4.packetBuffer.writeByte(var7);
      var4.packetBuffer.writeByte(var8);
      BufferedSource.method2105(var4.packetBuffer, var1);
      if (var0 == class313.field3030.rsOrdinal()) {
         var4.packetBuffer.writeByte(var3);
      }

      var4.packetBuffer.method2388(var4.packetBuffer.offset - var5);
      return var4;
   }
}
