import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Hashtable;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import org.bouncycastle.crypto.tls.DefaultTlsClient;
import org.bouncycastle.crypto.tls.TlsAuthentication;

@ObfuscatedName("ai")
class class13 extends DefaultTlsClient {
    @ObfuscatedName("dg")
    @ObfuscatedSignature(
            descriptor = "Ltc;"
    )
    static IndexedSprite worldSelectRightSprite;
   @ObfuscatedName("gk")
   static int field43;
   // $FF: synthetic field
   @ObfuscatedSignature(
      descriptor = "Lax;"
   )
   final class12 this$1;

   @ObfuscatedSignature(
      descriptor = "(Lax;)V"
   )
   class13(class12 var1) {
      this.this$1 = var1;
   }

    @ObfuscatedName("getClientExtensions")
    public Hashtable getClientExtensions() throws IOException {
      Hashtable var1 = super.getClientExtensions();
      if (var1 == null) {
         var1 = new Hashtable();
      }

      byte[] var2 = this.this$1.val$host.getBytes();
      ByteArrayOutputStream var3 = new ByteArrayOutputStream();
      DataOutputStream var4 = new DataOutputStream(var3);
      var4.writeShort(var2.length + 3);
      var4.writeByte(0);
      var4.writeShort(var2.length);
      var4.write(var2);
      var4.close();
      var1.put(0, var3.toByteArray());
      return var1;
   }

    @ObfuscatedName("getAuthentication")
    public TlsAuthentication getAuthentication() throws IOException {
      return new class11(this);
   }

    @ObfuscatedName("au")
    @ObfuscatedSignature(
            descriptor = "(IIIZIZI)V",
            garbageValue = "986853816"
    )
    static void doWorldSorting(int var0, int var1, int var2, boolean var3, int var4, boolean var5) {
      if (var0 < var1) {
         int var6 = (var0 + var1) / 2;
         int var7 = var0;
         World var8 = class31.World_worlds[var6];
         class31.World_worlds[var6] = class31.World_worlds[var1];
         class31.World_worlds[var1] = var8;

         for(int var9 = var0; var9 < var1; ++var9) {
            World var11 = class31.World_worlds[var9];
            int var12 = class297.compareWorlds(var11, var8, var2, var3);
            int var10;
            if (var12 != 0) {
               if (var3) {
                  var10 = -var12;
               } else {
                  var10 = var12;
               }
            } else if (var4 == -1) {
               var10 = 0;
            } else {
               int var13 = class297.compareWorlds(var11, var8, var4, var5);
               if (var5) {
                  var10 = -var13;
               } else {
                  var10 = var13;
               }
            }

            if (var10 <= 0) {
               World var14 = class31.World_worlds[var9];
               class31.World_worlds[var9] = class31.World_worlds[var7];
               class31.World_worlds[var7++] = var14;
            }
         }

         class31.World_worlds[var1] = class31.World_worlds[var7];
         class31.World_worlds[var7] = var8;
         doWorldSorting(var0, var7 - 1, var2, var3, var4, var5);
         doWorldSorting(var7 + 1, var1, var2, var3, var4, var5);
      }

   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      descriptor = "(ILch;ZS)I",
      garbageValue = "511"
   )
   static int method48(int var0, Script var1, boolean var2) {
      Widget var3;
      if (var0 != 1927 && var0 != 2927) {
         int var4;
         if (var0 == 1928) {
            var3 = var2 ? SoundSystem.scriptDotWidget : class1.scriptActiveWidget;
            var4 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
            if (var4 >= 1 && var4 <= 10) {
               class97 var5 = new class97(var4, var3.id, var3.childIndex, var3.itemId);
               Interpreter.field690.add(var5);
               return 1;
            } else {
               throw new RuntimeException();
            }
         } else if (var0 == 2928) {
            Interpreter.Interpreter_intStackSize -= 3;
            int var7 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
            var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
            int var8 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 2];
            if (var8 >= 1 && var8 <= 10) {
               class97 var6 = new class97(var8, var7, var4, class165.getWidget(var7).itemId);
               Interpreter.field690.add(var6);
               return 1;
            } else {
               throw new RuntimeException();
            }
         } else {
            return 2;
         }
      } else if (Interpreter.field703 >= 10) {
         throw new RuntimeException();
      } else {
         if (var0 >= 2000) {
            var3 = class165.getWidget(Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
         } else {
            var3 = var2 ? SoundSystem.scriptDotWidget : class1.scriptActiveWidget;
         }

         if (var3.onResize == null) {
            return 0;
         } else {
            ScriptEvent var9 = new ScriptEvent();
            var9.widget = var3;
            var9.args = var3.onResize;
            var9.field859 = Interpreter.field703 + 1;
            Client.scriptEvents.addFirst(var9);
            return 1;
         }
      }
   }

    @ObfuscatedName("ch")
    @ObfuscatedSignature(
            descriptor = "([BI)[B",
            garbageValue = "-1117233973"
    )
    static final byte[] decompressBytes(byte[] var0) {
      Buffer var1 = new Buffer(var0);
      int var2 = var1.readUnsignedByte();
      int var3 = var1.readInt();
      if (var3 >= 0 && (AbstractArchive.maximumContainerSize == 0 || var3 <= AbstractArchive.maximumContainerSize)) {
         if (var2 == 0) {
            byte[] var4 = new byte[var3];
            var1.readBytes(var4, 0, var3);
            return var4;
         } else {
            int var6 = var1.readInt();
            if (var6 < 0 || AbstractArchive.maximumContainerSize != 0 && var6 > AbstractArchive.maximumContainerSize) {
               throw new RuntimeException();
            } else {
               byte[] var5 = new byte[var6];
               if (var2 == 1) {
                  BZip2Decompressor.BZip2Decompressor_decompress(var5, var6, var0, var3, 9);
               } else {
                  AbstractArchive.gzipDecompressor.decompress(var1, var5);
               }

               return var5;
            }
         }
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("jj")
   @ObfuscatedSignature(
      descriptor = "(Ldv;I)Z",
      garbageValue = "2083304706"
   )
   static boolean method46(Player var0) {
      if (Client.drawPlayerNames == 0) {
         return false;
      } else {
         boolean var1;
         if (MusicPatchNode.localPlayer != var0) {
            var1 = (Client.drawPlayerNames & 4) != 0;
            boolean var2 = var1;
            boolean var3;
            if (!var1) {
               var3 = (Client.drawPlayerNames & 1) != 0;
               var2 = var3 && var0.isFriend();
            }

            var3 = var2;
            if (!var2) {
               boolean var4 = (Client.drawPlayerNames & 2) != 0;
               var3 = var4 && var0.isFriendsChatMember();
            }

            return var3;
         } else {
            var1 = (Client.drawPlayerNames & 8) != 0;
            return var1;
         }
      }
   }

    @ObfuscatedName("lk")
    @ObfuscatedSignature(
            descriptor = "(IIIIIIIIB)V",
            garbageValue = "-119"
    )
    static final void drawWidgets(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      if (SoundSystem.loadInterface(var0)) {
         WorldMapSection2.field2292 = null;
         class11.drawInterface(VerticalAlignment.Widget_interfaceComponents[var0], -1, var1, var2, var3, var4, var5, var6, var7);
         if (WorldMapSection2.field2292 != null) {
            class11.drawInterface(WorldMapSection2.field2292, -1412584499, var1, var2, var3, var4, class230.field2130, class101.field1082, var7);
            WorldMapSection2.field2292 = null;
         }

      } else {
         if (var7 != -1) {
            Client.field573[var7] = true;
         } else {
            for(int var8 = 0; var8 < 100; ++var8) {
               Client.field573[var8] = true;
            }
         }

      }
   }

    @ObfuscatedName("lr")
    @ObfuscatedSignature(
            descriptor = "(I)Z",
            garbageValue = "1764409785"
    )
    static boolean getTapToDrop() {
      return Client.tapToDrop;
   }
}
