import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fm")
@Implements("WorldMapElement")
public class WorldMapElement extends DualNode {
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "Lly;"
   )
   public static AbstractArchive WorldMapElement_archive;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "[Lfm;"
   )
   public static WorldMapElement[] WorldMapElement_cached;
   @ObfuscatedName("v")
   public static int WorldMapElement_count;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      descriptor = "Ljv;"
   )
   public static EvictingDualNodeHashTable WorldMapElement_cachedSprites = new EvictingDualNodeHashTable(256);
   @ObfuscatedName("m")
   public final int objectId;
   @ObfuscatedName("q")
   public int sprite1 = -1;
   @ObfuscatedName("f")
   int sprite2 = -1;
   @ObfuscatedName("r")
   public String name;
   @ObfuscatedName("u")
   public int field1491;
   @ObfuscatedName("b")
   public int textSize = 0;
   @ObfuscatedName("g")
   public boolean field1481 = true;
   @ObfuscatedName("i")
   public boolean field1485 = false;
   @ObfuscatedName("o")
   public String[] menuActions = new String[5];
   @ObfuscatedName("n")
   public String menuTargetName;
   @ObfuscatedName("k")
   int[] field1478;
   @ObfuscatedName("a")
   int field1486 = Integer.MAX_VALUE;
   @ObfuscatedName("s")
   int field1487 = Integer.MAX_VALUE;
   @ObfuscatedName("l")
   int field1488 = Integer.MIN_VALUE;
   @ObfuscatedName("t")
   int field1482 = Integer.MIN_VALUE;
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      descriptor = "Lgj;"
   )
   public HorizontalAlignment horizontalAlignment;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      descriptor = "Lgl;"
   )
   public VerticalAlignment verticalAlignment;
   @ObfuscatedName("d")
   int[] field1475;
   @ObfuscatedName("y")
   byte[] field1492;
   @ObfuscatedName("z")
   public int category;

   public WorldMapElement(int var1) {
      this.horizontalAlignment = HorizontalAlignment.HorizontalAlignment_centered;
      this.verticalAlignment = VerticalAlignment.VerticalAlignment_centered;
      this.category = -1;
      this.objectId = var1;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "(Lqy;B)V",
      garbageValue = "2"
   )
   public void decode(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if (var2 == 0) {
            return;
         }

         this.decodeNext(var1, var2);
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "(Lqy;IB)V",
      garbageValue = "1"
   )
   void decodeNext(Buffer var1, int var2) {
      if (var2 == 1) {
         this.sprite1 = var1.method2362();
      } else if (var2 == 2) {
         this.sprite2 = var1.method2362();
      } else if (var2 == 3) {
         this.name = var1.readStringCp1252NullTerminated();
      } else if (var2 == 4) {
         this.field1491 = var1.readMedium();
      } else if (var2 == 5) {
         var1.readMedium();
      } else if (var2 == 6) {
         this.textSize = var1.readUnsignedByte();
      } else {
         int var3;
         if (var2 == 7) {
            var3 = var1.readUnsignedByte();
            if ((var3 & 1) == 0) {
               this.field1481 = false;
            }

            if ((var3 & 2) == 2) {
               this.field1485 = true;
            }
         } else if (var2 == 8) {
            var1.readUnsignedByte();
         } else if (var2 >= 10 && var2 <= 14) {
            this.menuActions[var2 - 10] = var1.readStringCp1252NullTerminated();
         } else if (var2 == 15) {
            var3 = var1.readUnsignedByte();
            this.field1478 = new int[var3 * 2];

            int var4;
            for(var4 = 0; var4 < var3 * 2; ++var4) {
               this.field1478[var4] = var1.readShort();
            }

            var1.readInt();
            var4 = var1.readUnsignedByte();
            this.field1475 = new int[var4];

            int var5;
            for(var5 = 0; var5 < this.field1475.length; ++var5) {
               this.field1475[var5] = var1.readInt();
            }

            this.field1492 = new byte[var3];

            for(var5 = 0; var5 < var3; ++var5) {
               this.field1492[var5] = var1.readByte();
            }
         } else if (var2 != 16) {
            if (var2 == 17) {
               this.menuTargetName = var1.readStringCp1252NullTerminated();
            } else if (var2 == 18) {
               var1.method2362();
            } else if (var2 == 19) {
               this.category = var1.readUnsignedShort();
            } else if (var2 == 21) {
               var1.readInt();
            } else if (var2 == 22) {
               var1.readInt();
            } else if (var2 == 23) {
               var1.readUnsignedByte();
               var1.readUnsignedByte();
               var1.readUnsignedByte();
            } else if (var2 == 24) {
               var1.readShort();
               var1.readShort();
            } else if (var2 == 25) {
               var1.method2362();
            } else if (var2 == 28) {
               var1.readUnsignedByte();
            } else if (var2 == 29) {
               HorizontalAlignment[] var6 = new HorizontalAlignment[]{HorizontalAlignment.field1540, HorizontalAlignment.HorizontalAlignment_centered, HorizontalAlignment.field1538};
               this.horizontalAlignment = (HorizontalAlignment)World.findEnumerated(var6, var1.readUnsignedByte());
            } else if (var2 == 30) {
               VerticalAlignment[] var7 = new VerticalAlignment[]{VerticalAlignment.field1598, VerticalAlignment.field1597, VerticalAlignment.VerticalAlignment_centered};
               this.verticalAlignment = (VerticalAlignment)World.findEnumerated(var7, var1.readUnsignedByte());
            }
         }
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "1089817679"
   )
   public void method914() {
      if (this.field1478 != null) {
         for(int var1 = 0; var1 < this.field1478.length; var1 += 2) {
            if (this.field1478[var1] < this.field1486) {
               this.field1486 = this.field1478[var1];
            } else if (this.field1478[var1] > this.field1488) {
               this.field1488 = this.field1478[var1];
            }

            if (this.field1478[var1 + 1] < this.field1487) {
               this.field1487 = this.field1478[var1 + 1];
            } else if (this.field1478[var1 + 1] > this.field1482) {
               this.field1482 = this.field1478[var1 + 1];
            }
         }
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      descriptor = "(ZI)Lrx;",
      garbageValue = "-36987014"
   )
   public SpritePixels getSpriteBool(boolean var1) {
      int var2 = this.sprite1 * -211487071 * 2084334945;
      return this.getSprite(var2);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      descriptor = "(II)Lrx;",
      garbageValue = "-2019258857"
   )
   SpritePixels getSprite(int var1) {
      if (var1 < 0) {
         return null;
      } else {
         SpritePixels var2 = (SpritePixels)WorldMapElement_cachedSprites.get((long)var1);
         if (var2 != null) {
            return var2;
         } else {
            var2 = class125.SpriteBuffer_getSprite(WorldMapElement_archive, var1, 0);
            if (var2 != null) {
               WorldMapElement_cachedSprites.put(var2, (long)var1);
            }

            return var2;
         }
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "(B)I",
      garbageValue = "-125"
   )
   public int getObjectId() {
      return this.objectId;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(Lcb;B)V",
      garbageValue = "31"
   )
   public static void runScriptEvent(ScriptEvent var0) {
      class125.runScript(var0, 500000, 475000);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/CharSequence;IB)I",
      garbageValue = "98"
   )
   public static int method920(CharSequence var0, int var1) {
      return class318.method1770(var0, var1, true);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      descriptor = "(I)Z",
      garbageValue = "1005315742"
   )
   static final boolean method919() {
      return ViewportMouse.ViewportMouse_isInViewport;
   }
}
