import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hb")
@Implements("HitSplatDefinition")
public class HitSplatDefinition extends DualNode {
    @ObfuscatedName("af")
    @ObfuscatedSignature(
            descriptor = "Lnm;"
    )
    public static AbstractArchive HitSplatDefinition_archive;
   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "Lnm;"
   )
   public static AbstractArchive field1664;
    @ObfuscatedName("aw")
    @ObfuscatedSignature(
            descriptor = "Lnm;"
    )
    public static AbstractArchive HitSplatDefinition_fontsArchive;
    @ObfuscatedName("ac")
    @ObfuscatedSignature(
            descriptor = "Lkh;"
    )
    static EvictingDualNodeHashTable HitSplatDefinition_cached = new EvictingDualNodeHashTable(64);
    @ObfuscatedName("au")
    @ObfuscatedSignature(
            descriptor = "Lkh;"
    )
    static EvictingDualNodeHashTable HitSplatDefinition_cachedSprites = new EvictingDualNodeHashTable(64);
    @ObfuscatedName("ab")
    @ObfuscatedSignature(
            descriptor = "Lkh;"
    )
    static EvictingDualNodeHashTable HitSplatDefinition_cachedFonts = new EvictingDualNodeHashTable(20);
    @ObfuscatedName("ao")
    int fontId = -1;
    @ObfuscatedName("ax")
    public int textColor = 16777215;
   @ObfuscatedName("ai")
   public int field1672 = 70;
   @ObfuscatedName("ag")
   int field1684 = -1;
   @ObfuscatedName("ah")
   int field1673 = -1;
   @ObfuscatedName("av")
   int field1674 = -1;
   @ObfuscatedName("ar")
   int field1675 = -1;
   @ObfuscatedName("am")
   public int field1663 = 0;
   @ObfuscatedName("as")
   public int field1676 = 0;
   @ObfuscatedName("aj")
   public int field1683 = -1;
   @ObfuscatedName("ak")
   String field1679 = "";
   @ObfuscatedName("az")
   public int field1678 = -1;
   @ObfuscatedName("ad")
   public int field1680 = 0;
    @ObfuscatedName("ae")
    public int[] transforms;
    @ObfuscatedName("ap")
    int transformVarbit = -1;
    @ObfuscatedName("by")
    int transformVarp = -1;

    @ObfuscatedName("an")
    @ObfuscatedSignature(
            descriptor = "(Lsg;I)V",
            garbageValue = "1967654150"
    )
    void decode(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if (var2 == 0) {
            return;
         }

         this.decodeNext(var1, var2);
      }
   }

    @ObfuscatedName("aw")
    @ObfuscatedSignature(
            descriptor = "(Lsg;IB)V",
            garbageValue = "1"
    )
    void decodeNext(Buffer var1, int var2) {
      if (var2 == 1) {
         this.fontId = var1.method2516();
      } else if (var2 == 2) {
         this.textColor = var1.readMedium();
      } else if (var2 == 3) {
         this.field1684 = var1.method2516();
      } else if (var2 == 4) {
         this.field1674 = var1.method2516();
      } else if (var2 == 5) {
         this.field1673 = var1.method2516();
      } else if (var2 == 6) {
         this.field1675 = var1.method2516();
      } else if (var2 == 7) {
         this.field1663 = var1.readShort();
      } else if (var2 == 8) {
         this.field1679 = var1.readStringCp1252NullCircumfixed();
      } else if (var2 == 9) {
         this.field1672 = var1.readUnsignedShort();
      } else if (var2 == 10) {
         this.field1676 = var1.readShort();
      } else if (var2 == 11) {
         this.field1683 = 0;
      } else if (var2 == 12) {
         this.field1678 = var1.readUnsignedByte();
      } else if (var2 == 13) {
         this.field1680 = var1.readShort();
      } else if (var2 == 14) {
         this.field1683 = var1.readUnsignedShort();
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

    @ObfuscatedName("ac")
    @ObfuscatedSignature(
            descriptor = "(B)Lhb;",
            garbageValue = "-12"
    )
    public final HitSplatDefinition transform() {
      int var1 = -1;
      if (this.transformVarbit != -1) {
         var1 = class252.getVarbit(this.transformVarbit);
      } else if (this.transformVarp != -1) {
         var1 = Varps.Varps_main[this.transformVarp];
      }

      int var2;
      if (var1 >= 0 && var1 < this.transforms.length - 1) {
         var2 = this.transforms[var1];
      } else {
         var2 = this.transforms[this.transforms.length - 1];
      }

      return var2 != -1 ? class122.method738(var2) : null;
   }

    @ObfuscatedName("au")
    @ObfuscatedSignature(
            descriptor = "(II)Ljava/lang/String;",
            garbageValue = "-280765442"
    )
    public String getString(int var1) {
      String var2 = this.field1679;

      while(true) {
         int var3 = var2.indexOf("%1");
         if (var3 < 0) {
            return var2;
         }

         var2 = var2.substring(0, var3) + KitDefinition.intToString(var1, false) + var2.substring(var3 + 2);
      }
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "(I)Ltq;",
      garbageValue = "2059907674"
   )
   public SpritePixels method1076() {
      if (this.field1684 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)HitSplatDefinition_cachedSprites.get((long)this.field1684);
         if (var1 != null) {
            return var1;
         } else {
            var1 = class484.SpriteBuffer_getSprite(field1664, this.field1684, 0);
            if (var1 != null) {
               HitSplatDefinition_cachedSprites.put(var1, (long)this.field1684);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      descriptor = "(I)Ltq;",
      garbageValue = "-2117307389"
   )
   public SpritePixels method1077() {
      if (this.field1673 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)HitSplatDefinition_cachedSprites.get((long)this.field1673);
         if (var1 != null) {
            return var1;
         } else {
            var1 = class484.SpriteBuffer_getSprite(field1664, this.field1673, 0);
            if (var1 != null) {
               HitSplatDefinition_cachedSprites.put(var1, (long)this.field1673);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "(I)Ltq;",
      garbageValue = "1640774602"
   )
   public SpritePixels method1072() {
      if (this.field1674 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)HitSplatDefinition_cachedSprites.get((long)this.field1674);
         if (var1 != null) {
            return var1;
         } else {
            var1 = class484.SpriteBuffer_getSprite(field1664, this.field1674, 0);
            if (var1 != null) {
               HitSplatDefinition_cachedSprites.put(var1, (long)this.field1674);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      descriptor = "(B)Ltq;",
      garbageValue = "57"
   )
   public SpritePixels method1078() {
      if (this.field1675 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)HitSplatDefinition_cachedSprites.get((long)this.field1675);
         if (var1 != null) {
            return var1;
         } else {
            var1 = class484.SpriteBuffer_getSprite(field1664, this.field1675, 0);
            if (var1 != null) {
               HitSplatDefinition_cachedSprites.put(var1, (long)this.field1675);
            }

            return var1;
         }
      }
   }

    @ObfuscatedName("aa")
    @ObfuscatedSignature(
            descriptor = "(I)Lon;",
            garbageValue = "1644925127"
    )
    public Font getFont() {
      if (this.fontId == -1) {
         return null;
      } else {
         Font var1 = (Font)HitSplatDefinition_cachedFonts.get((long)this.fontId);
         if (var1 != null) {
            return var1;
         } else {
            AbstractArchive var3 = field1664;
            AbstractArchive var4 = HitSplatDefinition_fontsArchive;
            int var5 = this.fontId;
            byte[] var7 = var3.takeFile(var5, 0);
            boolean var6;
            if (var7 == null) {
               var6 = false;
            } else {
               class485.SpriteBuffer_decode(var7);
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
                  Font var9 = new Font(var8, class503.SpriteBuffer_xOffsets, class17.SpriteBuffer_yOffsets, class97.SpriteBuffer_spriteWidths, class138.SpriteBuffer_spriteHeights, class394.SpriteBuffer_spritePalette, VarbitComposition.SpriteBuffer_pixels);
                  class398.method2125();
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

   @ObfuscatedName("bb")
   @ObfuscatedSignature(
      descriptor = "(ILch;ZB)I",
      garbageValue = "1"
   )
   static int method1081(int var0, Script var1, boolean var2) {
      int var3;
      if (var0 == 3500) {
         var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
         Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Client.keyHandlerInstance.getKeyPressed(var3) ? 1 : 0;
         return 1;
      } else if (var0 == 3501) {
         var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
         Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Client.keyHandlerInstance.method1153(var3) ? 1 : 0;
         return 1;
      } else if (var0 == 3502) {
         var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
         Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Client.keyHandlerInstance.method1159(var3) ? 1 : 0;
         return 1;
      } else {
         return 2;
      }
   }
}
