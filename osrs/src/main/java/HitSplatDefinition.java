import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hf")
@Implements("HitSplatDefinition")
public class HitSplatDefinition extends DualNode {
   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "Lne;"
   )
   public static AbstractArchive field1639;
   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "Lkt;"
   )
   @Export("HitSplatDefinition_cached")
   public static EvictingDualNodeHashTable HitSplatDefinition_cached = new EvictingDualNodeHashTable(64);
   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "Lkt;"
   )
   @Export("HitSplatDefinition_cachedSprites")
   public static EvictingDualNodeHashTable HitSplatDefinition_cachedSprites = new EvictingDualNodeHashTable(64);
   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      descriptor = "Lkt;"
   )
   @Export("HitSplatDefinition_cachedFonts")
   public static EvictingDualNodeHashTable HitSplatDefinition_cachedFonts = new EvictingDualNodeHashTable(20);
   @ObfuscatedName("ax")
   @Export("fontId")
   int fontId = -1;
   @ObfuscatedName("as")
   @Export("textColor")
   public int textColor = 16777215;
   @ObfuscatedName("ay")
   public int field1644 = 70;
   @ObfuscatedName("am")
   int field1645 = -1;
   @ObfuscatedName("az")
   int field1646 = -1;
   @ObfuscatedName("ae")
   int field1641 = -1;
   @ObfuscatedName("au")
   int field1648 = -1;
   @ObfuscatedName("ag")
   public int field1649 = 0;
   @ObfuscatedName("at")
   public int field1656 = 0;
   @ObfuscatedName("af")
   public int field1650 = -1;
   @ObfuscatedName("ai")
   String field1651 = "";
   @ObfuscatedName("aw")
   public int field1652 = -1;
   @ObfuscatedName("aa")
   public int field1643 = 0;
   @ObfuscatedName("ah")
   @Export("transforms")
   public int[] transforms;
   @ObfuscatedName("ad")
   @Export("transformVarbit")
   int transformVarbit = -1;
   @ObfuscatedName("bm")
   @Export("transformVarp")
   int transformVarp = -1;

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "(Lsy;S)V",
      garbageValue = "26153"
   )
   @Export("decode")
   void decode(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if (var2 == 0) {
            return;
         }

         this.decodeNext(var1, var2);
      }
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "(Lsy;IB)V",
      garbageValue = "-46"
   )
   @Export("decodeNext")
   void decodeNext(Buffer var1, int var2) {
      if (var2 == 1) {
         this.fontId = var1.method2423();
      } else if (var2 == 2) {
         this.textColor = var1.readMedium();
      } else if (var2 == 3) {
         this.field1645 = var1.method2423();
      } else if (var2 == 4) {
         this.field1641 = var1.method2423();
      } else if (var2 == 5) {
         this.field1646 = var1.method2423();
      } else if (var2 == 6) {
         this.field1648 = var1.method2423();
      } else if (var2 == 7) {
         this.field1649 = var1.readShort();
      } else if (var2 == 8) {
         this.field1651 = var1.readStringCp1252NullCircumfixed();
      } else if (var2 == 9) {
         this.field1644 = var1.readUnsignedShort();
      } else if (var2 == 10) {
         this.field1656 = var1.readShort();
      } else if (var2 == 11) {
         this.field1650 = 0;
      } else if (var2 == 12) {
         this.field1652 = var1.readUnsignedByte();
      } else if (var2 == 13) {
         this.field1643 = var1.readShort();
      } else if (var2 == 14) {
         this.field1650 = var1.readUnsignedShort();
      } else if (var2 == 17 || var2 == 18) {
         this.transformVarbit = var1.readUnsignedShort();
         if (this.transformVarbit == 65535) {
            this.transformVarbit = -1;
         }

         this.transformVarp = var1.readUnsignedShort();
         if (this.transformVarp == 65535) {
            this.transformVarp = -1;
         }

         int var3 = -1;
         if (var2 == 18) {
            var3 = var1.readUnsignedShort();
            if (var3 == 65535) {
               var3 = -1;
            }
         }

         int var4 = var1.readUnsignedByte();
         this.transforms = new int[var4 + 2];

         for(int var5 = 0; var5 <= var4; ++var5) {
            this.transforms[var5] = var1.readUnsignedShort();
            if (this.transforms[var5] == 65535) {
               this.transforms[var5] = -1;
            }
         }

         this.transforms[var4 + 1] = var3;
      }

   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "(I)Lhf;",
      garbageValue = "-1139535160"
   )
   @Export("transform")
   public final HitSplatDefinition transform() {
      int var1 = -1;
      if (this.transformVarbit != -1) {
         var1 = class17.getVarbit(this.transformVarbit);
      } else if (this.transformVarp != -1) {
         var1 = Varps.Varps_main[this.transformVarp];
      }

      int var2;
      if (var1 >= 0 && var1 < this.transforms.length - 1) {
         var2 = this.transforms[var1];
      } else {
         var2 = this.transforms[this.transforms.length - 1];
      }

      return var2 != -1 ? NewShit.method958(var2) : null;
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "(IB)Ljava/lang/String;",
      garbageValue = "87"
   )
   @Export("getString")
   public String getString(int var1) {
      String var2 = this.field1651;

      while(true) {
         int var3 = var2.indexOf("%1");
         if (var3 < 0) {
            return var2;
         }

         var2 = var2.substring(0, var3) + class393.intToString(var1, false) + var2.substring(var3 + 2);
      }
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      descriptor = "(I)Lsn;",
      garbageValue = "-522182464"
   )
   public SpritePixels method1018() {
      if (this.field1645 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)HitSplatDefinition_cachedSprites.get((long)this.field1645);
         if (var1 != null) {
            return var1;
         } else {
            var1 = WorldMapScaleHandler.SpriteBuffer_getSprite(field1639, this.field1645, 0);
            if (var1 != null) {
               HitSplatDefinition_cachedSprites.put(var1, (long)this.field1645);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      descriptor = "(I)Lsn;",
      garbageValue = "-1592628135"
   )
   public SpritePixels method1016() {
      if (this.field1646 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)HitSplatDefinition_cachedSprites.get((long)this.field1646);
         if (var1 != null) {
            return var1;
         } else {
            var1 = WorldMapScaleHandler.SpriteBuffer_getSprite(field1639, this.field1646, 0);
            if (var1 != null) {
               HitSplatDefinition_cachedSprites.put(var1, (long)this.field1646);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      descriptor = "(I)Lsn;",
      garbageValue = "146201023"
   )
   public SpritePixels method1012() {
      if (this.field1641 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)HitSplatDefinition_cachedSprites.get((long)this.field1641);
         if (var1 != null) {
            return var1;
         } else {
            var1 = WorldMapScaleHandler.SpriteBuffer_getSprite(field1639, this.field1641, 0);
            if (var1 != null) {
               HitSplatDefinition_cachedSprites.put(var1, (long)this.field1641);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      descriptor = "(B)Lsn;",
      garbageValue = "-30"
   )
   public SpritePixels method1013() {
      if (this.field1648 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)HitSplatDefinition_cachedSprites.get((long)this.field1648);
         if (var1 != null) {
            return var1;
         } else {
            var1 = WorldMapScaleHandler.SpriteBuffer_getSprite(field1639, this.field1648, 0);
            if (var1 != null) {
               HitSplatDefinition_cachedSprites.put(var1, (long)this.field1648);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      descriptor = "(I)Loe;",
      garbageValue = "2030805519"
   )
   @Export("getFont")
   public Font getFont() {
      if (this.fontId == -1) {
         return null;
      } else {
         Font var1 = (Font)HitSplatDefinition_cachedFonts.get((long)this.fontId);
         if (var1 != null) {
            return var1;
         } else {
            AbstractArchive var3 = field1639;
            AbstractArchive var4 = SecureRandomFuture.HitSplatDefinition_fontsArchive;
            int var5 = this.fontId;
            byte[] var7 = var3.takeFile(var5, 0);
            boolean var6;
            if (var7 == null) {
               var6 = false;
            } else {
               class212.SpriteBuffer_decode(var7);
               var6 = true;
            }

            Font var2;
            if (!var6) {
               var2 = null;
            } else {
               byte[] var8 = var4.takeFile(var5, 0);
               Font var10;
               if (var8 == null) {
                  var10 = null;
               } else {
                  Font var9 = new Font(var8, class492.SpriteBuffer_xOffsets, Canvas.SpriteBuffer_yOffsets, InterfaceParent.SpriteBuffer_spriteWidths, class144.SpriteBuffer_spriteHeights, class181.SpriteBuffer_spritePalette, class144.SpriteBuffer_pixels);
                  FriendsList.method2086();
                  var10 = var9;
               }

               var2 = var10;
            }

            if (var2 != null) {
               HitSplatDefinition_cachedFonts.put(var2, (long)this.fontId);
            }

            return var2;
         }
      }
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "(IIB)I",
      garbageValue = "-28"
   )
   public static int method1020(int var0, int var1) {
      return (int)(Math.atan2((double)var0, (double)var1) * 325.94932345220167D) & 2047;
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      descriptor = "(B)I",
      garbageValue = "36"
   )
   static final int method1019() {
      return ViewportMouse.ViewportMouse_x;
   }

   @ObfuscatedName("mi")
   @ObfuscatedSignature(
      descriptor = "(Lmy;IIII)V",
      garbageValue = "-626091022"
   )
   @Export("drawCompass")
   static final void drawCompass(Widget var0, int var1, int var2, int var3) {
      SpriteMask var4 = var0.getSpriteMask(false);
      if (var4 != null) {
         if (Client.minimapState < 3) {
            class149.compass.drawRotatedMaskedCenteredAround(var1, var2, var4.width, var4.height, 25, 25, Client.camAngleY, 256, var4.xStarts, var4.xWidths);
         } else {
            Rasterizer2D.Rasterizer2D_fillMaskedRectangle(var1, var2, 0, var4.xStarts, var4.xWidths);
         }

      }
   }
}
