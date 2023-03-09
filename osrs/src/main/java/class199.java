import java.util.concurrent.ThreadFactory;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hy")
final class class199 implements ThreadFactory {
   @ObfuscatedName("ab")
   public static int field1633;
   @ObfuscatedName("cd")
   static String field1632;

   @Export("newThread")
   @ObfuscatedName("newThread")
   public Thread newThread(Runnable var1) {
      return new Thread(var1, "OSRS Maya Anim Load");
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "(ILcv;ZI)I",
      garbageValue = "316630129"
   )
   static int method1001(int var0, Script var1, boolean var2) {
      int var3;
      int var4;
      if (var0 == 100) {
         Interpreter.Interpreter_intStackSize -= 3;
         var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
         var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
         int var5 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 2];
         if (var4 == 0) {
            throw new RuntimeException();
         } else {
            Widget var6 = WorldMapSection1.getWidget(var3);
            if (var6.children == null) {
               var6.children = new Widget[var5 + 1];
            }

            if (var6.children.length <= var5) {
               Widget[] var7 = new Widget[var5 + 1];

               for(int var8 = 0; var8 < var6.children.length; ++var8) {
                  var7[var8] = var6.children[var8];
               }

               var6.children = var7;
            }

            if (var5 > 0 && var6.children[var5 - 1] == null) {
               throw new RuntimeException("" + (var5 - 1));
            } else {
               Widget var12 = new Widget();
               var12.type = var4;
               var12.parentId = var12.id = var6.id;
               var12.childIndex = var5;
               var12.isIf3 = true;
               if (var4 == 12) {
                  var12.method1757();
                  var12.method1758().method1687(new class102(var12));
                  var12.method1758().method1678(new class103(var12));
               }

               var6.children[var5] = var12;
               if (var2) {
                  GameObject.scriptDotWidget = var12;
               } else {
                  SoundSystem.scriptActiveWidget = var12;
               }

               class69.invalidateWidget(var6);
               return 1;
            }
         }
      } else {
         Widget var9;
         if (var0 == 101) {
            var9 = var2 ? GameObject.scriptDotWidget : SoundSystem.scriptActiveWidget;
            Widget var10 = WorldMapSection1.getWidget(var9.id);
            var10.children[var9.childIndex] = null;
            class69.invalidateWidget(var10);
            return 1;
         } else if (var0 == 102) {
            var9 = WorldMapSection1.getWidget(Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
            var9.children = null;
            class69.invalidateWidget(var9);
            return 1;
         } else if (var0 != 200) {
            if (var0 == 201) {
               var9 = WorldMapSection1.getWidget(Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
               if (var9 != null) {
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 1;
                  if (var2) {
                     GameObject.scriptDotWidget = var9;
                  } else {
                     SoundSystem.scriptActiveWidget = var9;
                  }
               } else {
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
               }

               return 1;
            } else {
               return 2;
            }
         } else {
            Interpreter.Interpreter_intStackSize -= 2;
            var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
            var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
            Widget var11 = class36.getWidgetChild(var3, var4);
            if (var11 != null && var4 != -1) {
               Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 1;
               if (var2) {
                  GameObject.scriptDotWidget = var11;
               } else {
                  SoundSystem.scriptActiveWidget = var11;
               }
            } else {
               Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
            }

            return 1;
         }
      }
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "(CLnq;B)I",
      garbageValue = "122"
   )
   @Export("lowercaseChar")
   static int lowercaseChar(char var0, Language var1) {
      int var2 = var0 << 4;
      if (Character.isUpperCase(var0) || Character.isTitleCase(var0)) {
         var0 = Character.toLowerCase(var0);
         var2 = (var0 << 4) + 1;
      }

      if (var0 == 241 && var1 == Language.Language_ES) {
         var2 = 1762;
      }

      return var2;
   }

   @ObfuscatedName("mq")
   @ObfuscatedSignature(
      descriptor = "(III)V",
      garbageValue = "-629099983"
   )
   static final void method1003(int var0, int var1) {
      if (Client.currentClanChannels[var0] != null) {
         if (var1 >= 0 && var1 < Client.currentClanChannels[var0].method843()) {
            ClanChannelMember var2 = (ClanChannelMember)Client.currentClanChannels[var0].members.get(var1);
            if (var2.rank == -1) {
               PacketBufferNode var3 = UserComparator9.getPacketBufferNode(ClientPacket.field2508, Client.packetWriter.isaacCipher);
               var3.packetBuffer.writeByte(3 + WorldMapLabel.stringCp1252NullTerminatedByteSize(var2.username.getName()));
               var3.packetBuffer.writeByte(var0);
               var3.packetBuffer.writeShort(var1);
               var3.packetBuffer.writeStringCp1252NullTerminated(var2.username.getName());
               Client.packetWriter.addNode(var3);
            }
         }
      }
   }
}
