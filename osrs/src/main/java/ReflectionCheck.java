import java.lang.reflect.Field;
import java.lang.reflect.Method;

import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ap")
@Implements("ReflectionCheck")
public class ReflectionCheck extends Node {
   @ObfuscatedName("p")
   static int field172;
    @ObfuscatedName("f")
    int[] intReplaceValues;
    @ObfuscatedName("w")
    int id;
    @ObfuscatedName("v")
    int size;
    @ObfuscatedName("s")
    int[] operations;
    @ObfuscatedName("z")
    int[] creationErrors;
   @ObfuscatedName("j")
   Field[] fields;
    @ObfuscatedName("i")
    Method[] methods;
    @ObfuscatedName("n")
    byte[][][] arguments;

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "(IB)Lel;",
      garbageValue = "-10"
   )
   static class134 method170(int var0) {
      class134[] var1 = new class134[]{class134.field1282, class134.field1271, class134.field1272, class134.field1273, class134.field1274, class134.field1281, class134.field1276, class134.field1275, class134.field1278};
      class134 var2 = (class134)class4.findEnumerated(var1, var0);
      if (var2 == null) {
         var2 = class134.field1278;
      }

      return var2;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      descriptor = "(II)V",
      garbageValue = "-1054258097"
   )
   static void method171(int var0) {
      if (var0 != Login.loginIndex) {
         Login.loginIndex = var0;
      }
   }

    @ObfuscatedName("ft")
    @ObfuscatedSignature(
            descriptor = "(IZZZZI)Llm;",
            garbageValue = "1953973237"
    )
    static Archive newArchive(int var0, boolean var1, boolean var2, boolean var3, boolean var4) {
      ArchiveDisk var5 = null;
      if (JagexCache.JagexCache_dat2File != null) {
         var5 = new ArchiveDisk(var0, JagexCache.JagexCache_dat2File, class18.JagexCache_idxFiles[var0], 1000000);
      }

      return new Archive(var5, class12.masterDisk, var0, var1, var2, var3, var4);
   }

    @ObfuscatedName("kg")
    @ObfuscatedSignature(
            descriptor = "(IB)V",
            garbageValue = "17"
    )
    static final void changeGameOptions(int var0) {
      class123.process();

      for(ObjectSound var1 = (ObjectSound)ObjectSound.objectSounds.last(); var1 != null; var1 = (ObjectSound)ObjectSound.objectSounds.previous()) {
         if (var1.obj != null) {
            var1.set();
         }
      }

      int var3 = TaskHandler.VarpDefinition_get(var0).type;
      if (var3 != 0) {
         int var2 = Varps.Varps_main[var0];
         if (var3 == 1) {
            if (var2 == 1) {
               Rasterizer3D.Rasterizer3D_setBrightness(0.9D);
               ((TextureProvider)Rasterizer3D.Rasterizer3D_textureLoader).setBrightness(0.9D);
               ItemComposition.ItemDefinition_cachedSprites.clear();
               PacketWriter.clientPreferences.setBrightness(0.9D);
            }

            if (var2 == 2) {
               Rasterizer3D.Rasterizer3D_setBrightness(0.8D);
               ((TextureProvider)Rasterizer3D.Rasterizer3D_textureLoader).setBrightness(0.8D);
               ItemComposition.ItemDefinition_cachedSprites.clear();
               PacketWriter.clientPreferences.setBrightness(0.8D);
            }

            if (var2 == 3) {
               Rasterizer3D.Rasterizer3D_setBrightness(0.7D);
               ((TextureProvider)Rasterizer3D.Rasterizer3D_textureLoader).setBrightness(0.7D);
               ItemComposition.ItemDefinition_cachedSprites.clear();
               PacketWriter.clientPreferences.setBrightness(0.7D);
            }

            if (var2 == 4) {
               Actor.method505(0.6D);
            }
         }

         if (var3 == 3) {
            if (var2 == 0) {
               Player.method488(255);
            }

            if (var2 == 1) {
               Player.method488(192);
            }

            if (var2 == 2) {
               Player.method488(128);
            }

            if (var2 == 3) {
               Player.method488(64);
            }

            if (var2 == 4) {
               Player.method488(0);
            }
         }

         if (var3 == 4) {
            if (var2 == 0) {
               class203.method1073(127);
            }

            if (var2 == 1) {
               class203.method1073(96);
            }

            if (var2 == 2) {
               class203.method1073(64);
            }

            if (var2 == 3) {
               class203.method1073(32);
            }

            if (var2 == 4) {
               class203.method1073(0);
            }
         }

         if (var3 == 5) {
            Client.leftClickOpensMenu = var2 == 1;
         }

         if (var3 == 6) {
            Client.chatEffects = var2;
         }

         if (var3 == 9) {
            Client.field547 = var2;
         }

         if (var3 == 10) {
            if (var2 == 0) {
               NPC.method575(127);
            }

            if (var2 == 1) {
               NPC.method575(96);
            }

            if (var2 == 2) {
               NPC.method575(64);
            }

            if (var2 == 3) {
               NPC.method575(32);
            }

            if (var2 == 4) {
               NPC.method575(0);
            }
         }

         if (var3 == 17) {
            Client.followerIndex = var2 & '\uffff';
         }

         if (var3 == 18) {
            Client.playerAttackOption = (AttackOption)class4.findEnumerated(WorldMapArea.method1355(), var2);
            if (Client.playerAttackOption == null) {
               Client.playerAttackOption = AttackOption.AttackOption_dependsOnCombatLevels;
            }
         }

         if (var3 == 19) {
            if (var2 == -1) {
               Client.combatTargetPlayerIndex = -1;
            } else {
               Client.combatTargetPlayerIndex = var2 & 2047;
            }
         }

         if (var3 == 22) {
            Client.npcAttackOption = (AttackOption)class4.findEnumerated(WorldMapArea.method1355(), var2);
            if (Client.npcAttackOption == null) {
               Client.npcAttackOption = AttackOption.AttackOption_dependsOnCombatLevels;
            }
         }

      }
   }
}
