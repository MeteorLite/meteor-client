import java.awt.Desktop;
import java.awt.Desktop.Action;
import java.net.URI;
import java.util.HashSet;
import java.util.Set;

import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("mr")
@Implements("ModeWhere")
public enum ModeWhere implements class345 {
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "Lmr;"
   )
   field3545("", 0, new class344[]{class344.field3514}),
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "Lmr;"
   )
   field3528("", 1, new class344[]{class344.field3512, class344.field3514}),
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "Lmr;"
   )
   field3530("", 2, new class344[]{class344.field3512, class344.field3513, class344.field3514}),
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      descriptor = "Lmr;"
   )
   field3529("", 3, new class344[]{class344.field3512}),
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      descriptor = "Lmr;"
   )
   field3532("", 4),
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      descriptor = "Lmr;"
   )
   field3533("", 5, new class344[]{class344.field3512, class344.field3514}),
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "Lmr;"
   )
   field3542("", 6, new class344[]{class344.field3514}),
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      descriptor = "Lmr;"
   )
   field3535("", 8, new class344[]{class344.field3512, class344.field3514}),
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      descriptor = "Lmr;"
   )
   field3536("", 9, new class344[]{class344.field3512, class344.field3513}),
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      descriptor = "Lmr;"
   )
   field3537("", 10, new class344[]{class344.field3512}),
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      descriptor = "Lmr;"
   )
   field3538("", 11, new class344[]{class344.field3512}),
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      descriptor = "Lmr;"
   )
   field3544("", 12, new class344[]{class344.field3512, class344.field3514}),
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      descriptor = "Lmr;"
   )
   field3534("", 13, new class344[]{class344.field3512});

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      descriptor = "Lqy;"
   )
   public static Buffer NetCache_responseArchiveBuffer;
   @ObfuscatedName("bo")
   @ObfuscatedSignature(
      descriptor = "Llz;"
   )
   static GameBuild param7;
   @ObfuscatedName("ix")
   static int selectedItemWidget;
   @ObfuscatedName("o")
   final int id;
   @ObfuscatedName("n")
   final Set field3541 = new HashSet();

   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;I[Lmk;)V"
   )
   ModeWhere(String var3, int var4, class344[] var5) {
      this.id = var4;
      class344[] var6 = var5;

      for(int var7 = 0; var7 < var6.length; ++var7) {
         class344 var8 = var6[var7];
         this.field3541.add(var8);
      }

   }

   ModeWhere(String var3, int var4) {
      this.id = var4;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "(B)I",
      garbageValue = "96"
   )
   public int rsOrdinal() {
      return this.id;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;ZZB)V",
      garbageValue = "40"
   )
   public static void openURL(String var0, boolean var1, boolean var2) {
      if (var1) {
         if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Action.BROWSE)) {
            try {
               Desktop.getDesktop().browse(new URI(var0));
               return;
            } catch (Exception var4) {
               ;
            }
         }

         if (class32.field87.startsWith("win")) {
            class12.method41(var0, 0);
         } else if (class32.field87.startsWith("mac")) {
            HealthBarUpdate.method517(var0, 1, "openjs");
         } else {
            class12.method41(var0, 2);
         }
      } else {
         class12.method41(var0, 3);
      }

   }

   @ObfuscatedName("e")
   public static String base37DecodeLong(long var0) {
      if (var0 > 0L && var0 < 6582952005840035281L) {
         if (var0 % 37L == 0L) {
            return null;
         } else {
            int var2 = 0;

            for(long var3 = var0; var3 != 0L; var3 /= 37L) {
               ++var2;
            }

            StringBuilder var5;
            char var8;
            for(var5 = new StringBuilder(var2); var0 != 0L; var5.append(var8)) {
               long var6 = var0;
               var0 /= 37L;
               var8 = class362.base37Table[(int)(var6 - 37L * var0)];
               if (var8 == '_') {
                  int var9 = var5.length() - 1;
                  var5.setCharAt(var9, Character.toUpperCase(var5.charAt(var9)));
                  var8 = 160;
               }
            }

            var5.reverse();
            var5.setCharAt(0, Character.toUpperCase(var5.charAt(0)));
            return var5.toString();
         }
      } else {
         return null;
      }
   }

   @ObfuscatedName("gt")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "742396295"
   )
   static final void method1868() {
      class154.method821();
      FloorUnderlayDefinition.FloorUnderlayDefinition_cached.clear();
      ScriptFrame.method334();
      ObjectComposition.ObjectDefinition_cached.clear();
      ObjectComposition.ObjectDefinition_cachedModelData.clear();
      ObjectComposition.ObjectDefinition_cachedEntities.clear();
      ObjectComposition.ObjectDefinition_cachedModels.clear();
      class369.method1952();
      ItemComposition.ItemDefinition_cached.clear();
      ItemComposition.ItemDefinition_cachedModels.clear();
      ItemComposition.ItemDefinition_cachedSprites.clear();
      SequenceDefinition.SequenceDefinition_cached.clear();
      SequenceDefinition.SequenceDefinition_cachedFrames.clear();
      SequenceDefinition.SequenceDefinition_cachedModel.clear();
      class149.method806();
      VarbitComposition.VarbitDefinition_cached.clear();
      ScriptFrame.method335();
      class137.HitSplatDefinition_cachedSprites.method2287();
      class34.HitSplatDefinition_cached.method2287();
      HorizontalAlignment.method948();
      WallDecoration.method1295();
      class273.method1519();
      class143.method762();
      WorldMapElement.WorldMapElement_cachedSprites.clear();
      DbTableType.DBTableType_cache.clear();
      class420.method2168();
      Client.Widget_cachedModels.clear();
      Client.Widget_cachedFonts.clear();
      class34.method141();
      HorizontalAlignment.method946();
      ((TextureProvider)Rasterizer3D.Rasterizer3D_textureLoader).clear();
      Script.Script_cached.clear();
      Client.archive5.method2017();
      HealthBar.field1045.clearFiles();
      class9.archive7.clearFiles();
      FloorUnderlayDefinition.archive4.clearFiles();
      WorldMapSection0.field2342.clearFiles();
      class4.archive9.clearFiles();
      class162.archive6.clearFiles();
      class301.archive11.clearFiles();
      ClientPreferences.archive8.clearFiles();
      Frames.field2062.clearFiles();
      ClanChannelMember.archive10.clearFiles();
      class21.field63.clearFiles();
      class71.archive12.clearFiles();
      Ignored.field3698.clearFiles();
   }
}
