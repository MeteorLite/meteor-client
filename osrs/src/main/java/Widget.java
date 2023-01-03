import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kd")
@Implements("Widget")
public class Widget extends Node {
   @ObfuscatedName("am")
   @ObfuscatedSignature(
      descriptor = "Lly;"
   )
   static AbstractArchive field2857;
   @ObfuscatedName("av")
   @ObfuscatedSignature(
      descriptor = "Lly;"
   )
   static AbstractArchive Widget_spritesArchive;
   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      descriptor = "Ljv;"
   )
   static EvictingDualNodeHashTable Widget_cachedSprites = new EvictingDualNodeHashTable(200);
   @ObfuscatedName("at")
   @ObfuscatedSignature(
      descriptor = "Ljv;"
   )
   static EvictingDualNodeHashTable Widget_cachedModels = new EvictingDualNodeHashTable(50);
   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      descriptor = "Ljv;"
   )
   static EvictingDualNodeHashTable Widget_cachedFonts = new EvictingDualNodeHashTable(20);
   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "Ljv;"
   )
   static EvictingDualNodeHashTable Widget_cachedSpriteMasks = new EvictingDualNodeHashTable(8);
   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "Lni;"
   )
   static class384 field2863;
   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "Lni;"
   )
   static class384 field2864;
   @ObfuscatedName("ag")
   public static boolean field2865;
   @ObfuscatedName("az")
   public boolean isIf3 = false;
   @ObfuscatedName("ak")
   public int id = -1;
   @ObfuscatedName("af")
   public int childIndex = -1;
   @ObfuscatedName("ai")
   public int type;
   @ObfuscatedName("ax")
   public int buttonType = 0;
   @ObfuscatedName("ah")
   public int contentType = 0;
   @ObfuscatedName("aw")
   public int xAlignment = 0;
   @ObfuscatedName("aj")
   public int yAlignment = 0;
   @ObfuscatedName("aq")
   public int widthAlignment = 0;
   @ObfuscatedName("ap")
   public int heightAlignment = 0;
   @ObfuscatedName("aa")
   public int rawX = 0;
   @ObfuscatedName("ae")
   public int rawY = 0;
   @ObfuscatedName("ac")
   public int rawWidth = 0;
   @ObfuscatedName("bh")
   public int rawHeight = 0;
   @ObfuscatedName("be")
   public int x = 0;
   @ObfuscatedName("bf")
   public int y = 0;
   @ObfuscatedName("bo")
   public int width = 0;
   @ObfuscatedName("by")
   public int height = 0;
   @ObfuscatedName("bw")
   public int field2983 = 1;
   @ObfuscatedName("bp")
   public int field2884 = 1;
   @ObfuscatedName("bc")
   public int parentId = -1;
   @ObfuscatedName("bl")
   public boolean isHidden = false;
   @ObfuscatedName("bv")
   public int scrollX = 0;
   @ObfuscatedName("bx")
   public int scrollY = 0;
   @ObfuscatedName("bg")
   public int scrollWidth = 0;
   @ObfuscatedName("bz")
   public int scrollHeight = 0;
   @ObfuscatedName("bi")
   public int color = 0;
   @ObfuscatedName("br")
   public int color2 = 0;
   @ObfuscatedName("bq")
   public int mouseOverColor = 0;
   @ObfuscatedName("bn")
   public int mouseOverColor2 = 0;
   @ObfuscatedName("ba")
   public boolean fill = false;
   @ObfuscatedName("bs")
   @ObfuscatedSignature(
      descriptor = "Lrv;"
   )
   public FillMode fillMode;
   @ObfuscatedName("bt")
   public int transparencyTop;
   @ObfuscatedName("bu")
   public int transparencyBot;
   @ObfuscatedName("bj")
   public int lineWid;
   @ObfuscatedName("bb")
   public boolean field2899;
   @ObfuscatedName("bm")
   public int spriteId2;
   @ObfuscatedName("bk")
   public int spriteId;
   @ObfuscatedName("bd")
   public String field2902;
   @ObfuscatedName("cf")
   public int spriteAngle;
   @ObfuscatedName("cl")
   public boolean spriteTiling;
   @ObfuscatedName("cq")
   public int outline;
   @ObfuscatedName("cc")
   public int spriteShadow;
   @ObfuscatedName("cw")
   public boolean spriteFlipV;
   @ObfuscatedName("cx")
   public boolean spriteFlipH;
   @ObfuscatedName("cb")
   public int modelType;
   @ObfuscatedName("cs")
   public int modelId;
   @ObfuscatedName("cy")
   int modelType2;
   @ObfuscatedName("cp")
   int modelId2;
   @ObfuscatedName("cj")
   public int sequenceId;
   @ObfuscatedName("cn")
   public int sequenceId2;
   @ObfuscatedName("cm")
   public int modelOffsetX;
   @ObfuscatedName("ct")
   public int modelOffsetY;
   @ObfuscatedName("cu")
   public int modelAngleX;
   @ObfuscatedName("co")
   public int modelAngleY;
   @ObfuscatedName("ch")
   public int modelAngleZ;
   @ObfuscatedName("ce")
   public int modelZoom;
   @ObfuscatedName("cg")
   public int modelRotation;
   @ObfuscatedName("ca")
   public int field2922;
   @ObfuscatedName("cv")
   public boolean modelOrthog;
   @ObfuscatedName("cz")
   public boolean modelTransparency;
   @ObfuscatedName("cr")
   public int itemQuantityMode;
   @ObfuscatedName("cd")
   public int fontId;
   @ObfuscatedName("ck")
   public String text;
   @ObfuscatedName("ci")
   public String text2;
   @ObfuscatedName("dh")
   public int textLineHeight;
   @ObfuscatedName("dn")
   public int textXAlignment;
   @ObfuscatedName("da")
   public int textYAlignment;
   @ObfuscatedName("de")
   public boolean textShadowed;
   @ObfuscatedName("dl")
   public int paddingX;
   @ObfuscatedName("dw")
   public int paddingY;
   @ObfuscatedName("dm")
   public int[] inventoryXOffsets;
   @ObfuscatedName("dv")
   public int[] inventoryYOffsets;
   @ObfuscatedName("ds")
   public int[] inventorySprites;
   @ObfuscatedName("dc")
   public String[] itemActions;
   @ObfuscatedName("dk")
   @ObfuscatedSignature(
      descriptor = "Lfk;"
   )
   class163 field2939;
   @ObfuscatedName("df")
   int field2921;
   @ObfuscatedName("dy")
   HashMap field2941;
   @ObfuscatedName("dx")
   HashMap field2942;
   @ObfuscatedName("dd")
   @ObfuscatedSignature(
      descriptor = "Lkt;"
   )
   class301 field2943;
   @ObfuscatedName("dg")
   public int flags;
   @ObfuscatedName("dq")
   public boolean field2945;
   @ObfuscatedName("db")
   public byte[][] field2946;
   @ObfuscatedName("dt")
   public byte[][] field2947;
   @ObfuscatedName("dp")
   public int[] field2954;
   @ObfuscatedName("du")
   public int[] field2949;
   @ObfuscatedName("ew")
   public String dataText;
   @ObfuscatedName("ey")
   public String[] actions;
   @ObfuscatedName("et")
   @ObfuscatedSignature(
      descriptor = "Lkd;"
   )
   public Widget parent;
   @ObfuscatedName("es")
   public int dragZoneSize;
   @ObfuscatedName("eo")
   public int dragThreshold;
   @ObfuscatedName("eh")
   public boolean isScrollBar;
   @ObfuscatedName("ev")
   public String spellActionName;
   @ObfuscatedName("eq")
   public boolean hasListener;
   @ObfuscatedName("ee")
   public Object[] onLoad;
   @ObfuscatedName("em")
   public Object[] onClick;
   @ObfuscatedName("ea")
   public Object[] onClickRepeat;
   @ObfuscatedName("ex")
   public Object[] onRelease;
   @ObfuscatedName("er")
   public Object[] onHold;
   @ObfuscatedName("ec")
   public Object[] onMouseOver;
   @ObfuscatedName("eb")
   public Object[] onMouseRepeat;
   @ObfuscatedName("ek")
   public Object[] onMouseLeave;
   @ObfuscatedName("ej")
   public Object[] onDrag;
   @ObfuscatedName("ep")
   public Object[] onDragComplete;
   @ObfuscatedName("en")
   public Object[] onTargetEnter;
   @ObfuscatedName("eg")
   public Object[] onTargetLeave;
   @ObfuscatedName("ez")
   public Object[] onVarTransmit;
   @ObfuscatedName("ef")
   public int[] varTransmitTriggers;
   @ObfuscatedName("ei")
   public Object[] onInvTransmit;
   @ObfuscatedName("ed")
   public int[] invTransmitTriggers;
   @ObfuscatedName("eu")
   public Object[] onStatTransmit;
   @ObfuscatedName("el")
   public int[] statTransmitTriggers;
   @ObfuscatedName("fn")
   public Object[] onTimer;
   @ObfuscatedName("fb")
   public Object[] onOp;
   @ObfuscatedName("fa")
   public Object[] field2976;
   @ObfuscatedName("fo")
   public Object[] onScroll;
   @ObfuscatedName("fc")
   public Object[] onChatTransmit;
   @ObfuscatedName("fd")
   public Object[] onKey;
   @ObfuscatedName("fr")
   public Object[] field2980;
   @ObfuscatedName("fk")
   public Object[] field2975;
   @ObfuscatedName("fp")
   public Object[] onFriendTransmit;
   @ObfuscatedName("fg")
   public Object[] onClanTransmit;
   @ObfuscatedName("ff")
   public Object[] field2878;
   @ObfuscatedName("ft")
   public Object[] field2985;
   @ObfuscatedName("fs")
   public Object[] onMiscTransmit;
   @ObfuscatedName("fh")
   public Object[] onDialogAbort;
   @ObfuscatedName("fu")
   public Object[] onSubChange;
   @ObfuscatedName("fy")
   public Object[] onResize;
   @ObfuscatedName("fl")
   public Object[] onStockTransmit;
   @ObfuscatedName("fv")
   public Object[] field2891;
   @ObfuscatedName("fz")
   public Object[] field2992;
   @ObfuscatedName("fx")
   public int[][] cs1Instructions;
   @ObfuscatedName("fq")
   public int[] cs1Comparisons;
   @ObfuscatedName("fi")
   public int[] cs1ComparisonValues;
   @ObfuscatedName("fm")
   public int mouseOverRedirect;
   @ObfuscatedName("fe")
   public String spellName;
   @ObfuscatedName("fj")
   public String buttonText;
   @ObfuscatedName("fw")
   public int[] itemIds;
   @ObfuscatedName("gf")
   public int[] itemQuantities;
   @ObfuscatedName("go")
   public int itemId;
   @ObfuscatedName("gj")
   public int itemQuantity;
   @ObfuscatedName("gp")
   public int modelFrame;
   @ObfuscatedName("gz")
   public int modelFrameCycle;
   @ObfuscatedName("gl")
   @ObfuscatedSignature(
      descriptor = "[Lkd;"
   )
   public Widget[] children;
   @ObfuscatedName("gq")
   public boolean containsMouse;
   @ObfuscatedName("gh")
   public boolean field2934;
   @ObfuscatedName("ge")
   public int field2896;
   @ObfuscatedName("gu")
   public int field2969;
   @ObfuscatedName("gv")
   public int field2990;
   @ObfuscatedName("gd")
   public int field2961;
   @ObfuscatedName("gm")
   public int rootIndex;
   @ObfuscatedName("gn")
   public int cycle;
   @ObfuscatedName("gr")
   public int[] field3013;
   @ObfuscatedName("gk")
   public boolean noClickThrough;
   @ObfuscatedName("ga")
   public boolean noScrollThrough;
   @ObfuscatedName("gb")
   public boolean prioritizeMenuEntry;

   static {
      field2863 = new class384(10, class382.field3657);
      field2864 = new class384(10, class382.field3657);
      field2865 = false;
   }

   public Widget() {
      this.fillMode = FillMode.SOLID;
      this.transparencyTop = 0;
      this.transparencyBot = 0;
      this.lineWid = 1;
      this.field2899 = false;
      this.spriteId2 = -1;
      this.spriteId = -1;
      this.spriteAngle = 0;
      this.spriteTiling = false;
      this.outline = 0;
      this.spriteShadow = 0;
      this.modelType = 1;
      this.modelId = -1;
      this.modelType2 = 1;
      this.modelId2 = -1;
      this.sequenceId = -1;
      this.sequenceId2 = -1;
      this.modelOffsetX = 0;
      this.modelOffsetY = 0;
      this.modelAngleX = 0;
      this.modelAngleY = 0;
      this.modelAngleZ = 0;
      this.modelZoom = 100;
      this.modelRotation = 0;
      this.field2922 = 0;
      this.modelOrthog = false;
      this.modelTransparency = false;
      this.itemQuantityMode = 2;
      this.fontId = -1;
      this.text = "";
      this.text2 = "";
      this.textLineHeight = 0;
      this.textXAlignment = 0;
      this.textYAlignment = 0;
      this.textShadowed = false;
      this.paddingX = 0;
      this.paddingY = 0;
      this.field2921 = -1;
      this.flags = 0;
      this.field2945 = false;
      this.dataText = "";
      this.parent = null;
      this.dragZoneSize = 0;
      this.dragThreshold = 0;
      this.isScrollBar = false;
      this.spellActionName = "";
      this.hasListener = false;
      this.mouseOverRedirect = -1;
      this.spellName = "";
      this.buttonText = "Ok";
      this.itemId = -1;
      this.itemQuantity = 0;
      this.modelFrame = 0;
      this.modelFrameCycle = 0;
      this.containsMouse = false;
      this.field2934 = false;
      this.field2896 = -1;
      this.field2969 = 0;
      this.field2990 = 0;
      this.field2961 = 0;
      this.rootIndex = -1;
      this.cycle = -1;
      this.noClickThrough = false;
      this.noScrollThrough = false;
      this.prioritizeMenuEntry = false;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      descriptor = "(Lqy;I)V",
      garbageValue = "1229740727"
   )
   void decodeLegacy(Buffer var1) {
      this.isIf3 = false;
      this.type = var1.readUnsignedByte();
      this.buttonType = var1.readUnsignedByte();
      this.contentType = var1.readUnsignedShort();
      this.rawX = var1.readShort();
      this.rawY = var1.readShort();
      this.rawWidth = var1.readUnsignedShort();
      this.rawHeight = var1.readUnsignedShort();
      this.transparencyTop = var1.readUnsignedByte();
      this.parentId = var1.readUnsignedShort();
      if (this.parentId == 65535) {
         this.parentId = -1;
      } else {
         this.parentId += this.id & -65536;
      }

      this.mouseOverRedirect = var1.readUnsignedShort();
      if (this.mouseOverRedirect == 65535) {
         this.mouseOverRedirect = -1;
      }

      int var2 = var1.readUnsignedByte();
      int var3;
      if (var2 > 0) {
         this.cs1Comparisons = new int[var2];
         this.cs1ComparisonValues = new int[var2];

         for(var3 = 0; var3 < var2; ++var3) {
            this.cs1Comparisons[var3] = var1.readUnsignedByte();
            this.cs1ComparisonValues[var3] = var1.readUnsignedShort();
         }
      }

      var3 = var1.readUnsignedByte();
      int var4;
      int var5;
      int var6;
      if (var3 > 0) {
         this.cs1Instructions = new int[var3][];

         for(var4 = 0; var4 < var3; ++var4) {
            var5 = var1.readUnsignedShort();
            this.cs1Instructions[var4] = new int[var5];

            for(var6 = 0; var6 < var5; ++var6) {
               this.cs1Instructions[var4][var6] = var1.readUnsignedShort();
               if (this.cs1Instructions[var4][var6] == 65535) {
                  this.cs1Instructions[var4][var6] = -1;
               }
            }
         }
      }

      if (this.type == 0) {
         this.scrollHeight = var1.readUnsignedShort();
         this.isHidden = var1.readUnsignedByte() == 1;
      }

      if (this.type == 1) {
         var1.readUnsignedShort();
         var1.readUnsignedByte();
      }

      if (this.type == 2) {
         this.itemIds = new int[this.rawHeight * this.rawWidth];
         this.itemQuantities = new int[this.rawWidth * this.rawHeight];
         var4 = var1.readUnsignedByte();
         if (var4 == 1) {
            this.flags |= 268435456;
         }

         var5 = var1.readUnsignedByte();
         if (var5 == 1) {
            this.flags |= 1073741824;
         }

         var6 = var1.readUnsignedByte();
         if (var6 == 1) {
            this.flags |= Integer.MIN_VALUE;
         }

         int var7 = var1.readUnsignedByte();
         if (var7 == 1) {
            this.flags |= 536870912;
         }

         this.paddingX = var1.readUnsignedByte();
         this.paddingY = var1.readUnsignedByte();
         this.inventoryXOffsets = new int[20];
         this.inventoryYOffsets = new int[20];
         this.inventorySprites = new int[20];

         int var8;
         for(var8 = 0; var8 < 20; ++var8) {
            int var9 = var1.readUnsignedByte();
            if (var9 == 1) {
               this.inventoryXOffsets[var8] = var1.readShort();
               this.inventoryYOffsets[var8] = var1.readShort();
               this.inventorySprites[var8] = var1.readInt();
            } else {
               this.inventorySprites[var8] = -1;
            }
         }

         this.itemActions = new String[5];

         for(var8 = 0; var8 < 5; ++var8) {
            String var10 = var1.readStringCp1252NullTerminated();
            if (var10.length() > 0) {
               this.itemActions[var8] = var10;
               this.flags |= 1 << var8 + 23;
            }
         }
      }

      if (this.type == 3) {
         this.fill = var1.readUnsignedByte() == 1;
      }

      if (this.type == 4 || this.type == 1) {
         this.textXAlignment = var1.readUnsignedByte();
         this.textYAlignment = var1.readUnsignedByte();
         this.textLineHeight = var1.readUnsignedByte();
         this.fontId = var1.readUnsignedShort();
         if (this.fontId == 65535) {
            this.fontId = -1;
         }

         this.textShadowed = var1.readUnsignedByte() == 1;
      }

      if (this.type == 4) {
         this.text = var1.readStringCp1252NullTerminated();
         this.text2 = var1.readStringCp1252NullTerminated();
      }

      if (this.type == 1 || this.type == 3 || this.type == 4) {
         this.color = var1.readInt();
      }

      if (this.type == 3 || this.type == 4) {
         this.color2 = var1.readInt();
         this.mouseOverColor = var1.readInt();
         this.mouseOverColor2 = var1.readInt();
      }

      if (this.type == 5) {
         this.spriteId2 = var1.readInt();
         this.spriteId = var1.readInt();
      }

      if (this.type == 6) {
         this.modelType = 1;
         this.modelId = var1.readUnsignedShort();
         if (this.modelId == 65535) {
            this.modelId = -1;
         }

         this.modelType2 = 1;
         this.modelId2 = var1.readUnsignedShort();
         if (this.modelId2 == 65535) {
            this.modelId2 = -1;
         }

         this.sequenceId = var1.readUnsignedShort();
         if (this.sequenceId == 65535) {
            this.sequenceId = -1;
         }

         this.sequenceId2 = var1.readUnsignedShort();
         if (this.sequenceId2 == 65535) {
            this.sequenceId2 = -1;
         }

         this.modelZoom = var1.readUnsignedShort();
         this.modelAngleX = var1.readUnsignedShort();
         this.modelAngleY = var1.readUnsignedShort();
      }

      if (this.type == 7) {
         this.itemIds = new int[this.rawWidth * this.rawHeight];
         this.itemQuantities = new int[this.rawWidth * this.rawHeight];
         this.textXAlignment = var1.readUnsignedByte();
         this.fontId = var1.readUnsignedShort();
         if (this.fontId == 65535) {
            this.fontId = -1;
         }

         this.textShadowed = var1.readUnsignedByte() == 1;
         this.color = var1.readInt();
         this.paddingX = var1.readShort();
         this.paddingY = var1.readShort();
         var4 = var1.readUnsignedByte();
         if (var4 == 1) {
            this.flags |= 1073741824;
         }

         this.itemActions = new String[5];

         for(var5 = 0; var5 < 5; ++var5) {
            String var11 = var1.readStringCp1252NullTerminated();
            if (var11.length() > 0) {
               this.itemActions[var5] = var11;
               this.flags |= 1 << var5 + 23;
            }
         }
      }

      if (this.type == 8) {
         this.text = var1.readStringCp1252NullTerminated();
      }

      if (this.buttonType == 2 || this.type == 2) {
         this.spellActionName = var1.readStringCp1252NullTerminated();
         this.spellName = var1.readStringCp1252NullTerminated();
         var4 = var1.readUnsignedShort() & 63;
         this.flags |= var4 << 11;
      }

      if (this.buttonType == 1 || this.buttonType == 4 || this.buttonType == 5 || this.buttonType == 6) {
         this.buttonText = var1.readStringCp1252NullTerminated();
         if (this.buttonText.length() == 0) {
            if (this.buttonType == 1) {
               this.buttonText = "Ok";
            }

            if (this.buttonType == 4) {
               this.buttonText = "Select";
            }

            if (this.buttonType == 5) {
               this.buttonText = "Select";
            }

            if (this.buttonType == 6) {
               this.buttonText = "Continue";
            }
         }
      }

      if (this.buttonType == 1 || this.buttonType == 4 || this.buttonType == 5) {
         this.flags |= 4194304;
      }

      if (this.buttonType == 6) {
         this.flags |= 1;
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "(Lqy;I)V",
      garbageValue = "1277260307"
   )
   void decode(Buffer var1) {
      var1.readUnsignedByte();
      this.isIf3 = true;
      this.type = var1.readUnsignedByte();
      this.contentType = var1.readUnsignedShort();
      this.rawX = var1.readShort();
      this.rawY = var1.readShort();
      this.rawWidth = var1.readUnsignedShort();
      if (this.type == 9) {
         this.rawHeight = var1.readShort();
      } else {
         this.rawHeight = var1.readUnsignedShort();
      }

      this.widthAlignment = var1.readByte();
      this.heightAlignment = var1.readByte();
      this.xAlignment = var1.readByte();
      this.yAlignment = var1.readByte();
      this.parentId = var1.readUnsignedShort();
      if (this.parentId == 65535) {
         this.parentId = -1;
      } else {
         this.parentId += this.id & -65536;
      }

      this.isHidden = var1.readUnsignedByte() == 1;
      if (this.type == 0) {
         this.scrollWidth = var1.readUnsignedShort();
         this.scrollHeight = var1.readUnsignedShort();
         this.noClickThrough = var1.readUnsignedByte() == 1;
      }

      if (this.type == 5) {
         this.spriteId2 = var1.readInt();
         this.spriteAngle = var1.readUnsignedShort();
         this.spriteTiling = var1.readUnsignedByte() == 1;
         this.transparencyTop = var1.readUnsignedByte();
         this.outline = var1.readUnsignedByte();
         this.spriteShadow = var1.readInt();
         this.spriteFlipV = var1.readUnsignedByte() == 1;
         this.spriteFlipH = var1.readUnsignedByte() == 1;
      }

      if (this.type == 6) {
         this.modelType = 1;
         this.modelId = var1.readUnsignedShort();
         if (this.modelId == 65535) {
            this.modelId = -1;
         }

         this.modelOffsetX = var1.readShort();
         this.modelOffsetY = var1.readShort();
         this.modelAngleX = var1.readUnsignedShort();
         this.modelAngleY = var1.readUnsignedShort();
         this.modelAngleZ = var1.readUnsignedShort();
         this.modelZoom = var1.readUnsignedShort();
         this.sequenceId = var1.readUnsignedShort();
         if (this.sequenceId == 65535) {
            this.sequenceId = -1;
         }

         this.modelOrthog = var1.readUnsignedByte() == 1;
         var1.readUnsignedShort();
         if (this.widthAlignment != 0) {
            this.modelRotation = var1.readUnsignedShort();
         }

         if (this.heightAlignment != 0) {
            var1.readUnsignedShort();
         }
      }

      if (this.type == 4) {
         this.fontId = var1.readUnsignedShort();
         if (this.fontId == 65535) {
            this.fontId = -1;
         }

         this.text = var1.readStringCp1252NullTerminated();
         this.textLineHeight = var1.readUnsignedByte();
         this.textXAlignment = var1.readUnsignedByte();
         this.textYAlignment = var1.readUnsignedByte();
         this.textShadowed = var1.readUnsignedByte() == 1;
         this.color = var1.readInt();
      }

      if (this.type == 3) {
         this.color = var1.readInt();
         this.fill = var1.readUnsignedByte() == 1;
         this.transparencyTop = var1.readUnsignedByte();
      }

      if (this.type == 9) {
         this.lineWid = var1.readUnsignedByte();
         this.color = var1.readInt();
         this.field2899 = var1.readUnsignedByte() == 1;
      }

      this.flags = var1.readMedium();
      this.dataText = var1.readStringCp1252NullTerminated();
      int var2 = var1.readUnsignedByte();
      if (var2 > 0) {
         this.actions = new String[var2];

         for(int var3 = 0; var3 < var2; ++var3) {
            this.actions[var3] = var1.readStringCp1252NullTerminated();
         }
      }

      this.dragZoneSize = var1.readUnsignedByte();
      this.dragThreshold = var1.readUnsignedByte();
      this.isScrollBar = var1.readUnsignedByte() == 1;
      this.spellActionName = var1.readStringCp1252NullTerminated();
      this.onLoad = this.readListener(var1);
      this.onMouseOver = this.readListener(var1);
      this.onMouseLeave = this.readListener(var1);
      this.onTargetLeave = this.readListener(var1);
      this.onTargetEnter = this.readListener(var1);
      this.onVarTransmit = this.readListener(var1);
      this.onInvTransmit = this.readListener(var1);
      this.onStatTransmit = this.readListener(var1);
      this.onTimer = this.readListener(var1);
      this.onOp = this.readListener(var1);
      this.onMouseRepeat = this.readListener(var1);
      this.onClick = this.readListener(var1);
      this.onClickRepeat = this.readListener(var1);
      this.onRelease = this.readListener(var1);
      this.onHold = this.readListener(var1);
      this.onDrag = this.readListener(var1);
      this.onDragComplete = this.readListener(var1);
      this.onScroll = this.readListener(var1);
      this.varTransmitTriggers = this.readListenerTriggers(var1);
      this.invTransmitTriggers = this.readListenerTriggers(var1);
      this.statTransmitTriggers = this.readListenerTriggers(var1);
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      descriptor = "(Lqy;I)[Ljava/lang/Object;",
      garbageValue = "818571215"
   )
   Object[] readListener(Buffer var1) {
      int var2 = var1.readUnsignedByte();
      if (var2 == 0) {
         return null;
      } else {
         Object[] var3 = new Object[var2];

         for(int var4 = 0; var4 < var2; ++var4) {
            int var5 = var1.readUnsignedByte();
            if (var5 == 0) {
               var3[var4] = new Integer(var1.readInt());
            } else if (var5 == 1) {
               var3[var4] = var1.readStringCp1252NullTerminated();
            }
         }

         this.hasListener = true;
         return var3;
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      descriptor = "(Lqy;I)[I",
      garbageValue = "-2028965752"
   )
   int[] readListenerTriggers(Buffer var1) {
      int var2 = var1.readUnsignedByte();
      if (var2 == 0) {
         return null;
      } else {
         int[] var3 = new int[var2];

         for(int var4 = 0; var4 < var2; ++var4) {
            var3[var4] = var1.readInt();
         }

         return var3;
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      descriptor = "(IIB)V",
      garbageValue = "-108"
   )
   public void swapItems(int var1, int var2) {
      int var3 = this.itemIds[var2];
      this.itemIds[var2] = this.itemIds[var1];
      this.itemIds[var1] = var3;
      var3 = this.itemQuantities[var2];
      this.itemQuantities[var2] = this.itemQuantities[var1];
      this.itemQuantities[var1] = var3;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      descriptor = "(ZLdl;I)Lrx;",
      garbageValue = "1816388084"
   )
   public SpritePixels getSprite(boolean var1, UrlRequester var2) {
      field2865 = false;
      if (this.field2902 != null) {
         SpritePixels var3 = this.method1718(var2);
         if (var3 != null) {
            return var3;
         }
      }

      int var7;
      if (var1) {
         var7 = this.spriteId;
      } else {
         var7 = this.spriteId2;
      }

      if (var7 == -1) {
         return null;
      } else {
         long var4 = ((long)this.outline << 36) + (long)var7 + ((this.spriteFlipV ? 1L : 0L) << 38) + ((this.spriteFlipH ? 1L : 0L) << 39) + ((long)this.spriteShadow << 40);
         SpritePixels var6 = (SpritePixels)Widget_cachedSprites.get(var4);
         if (var6 != null) {
            return var6;
         } else {
            var6 = class125.SpriteBuffer_getSprite(Widget_spritesArchive, var7, 0);
            if (var6 == null) {
               field2865 = true;
               return null;
            } else {
               this.method1715(var6);
               Widget_cachedSprites.put(var6, var4);
               return var6;
            }
         }
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      descriptor = "(Ldl;I)Lrx;",
      garbageValue = "-740634830"
   )
   SpritePixels method1718(UrlRequester var1) {
      if (!this.method1719()) {
         return this.method1736(var1);
      } else {
         String var2 = this.field2902 + (this.spriteFlipV ? 1 : 0) + (this.spriteFlipH ? 1 : 0) + this.outline + this.spriteShadow;
         SpritePixels var3 = (SpritePixels)field2864.method2016(var2);
         if (var3 == null) {
            SpritePixels var4 = this.method1736(var1);
            if (var4 != null) {
               var3 = var4.method2462();
               this.method1715(var3);
               field2864.method2014(var2, var3);
            }
         }

         return var3;
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      descriptor = "(Ldl;I)Lrx;",
      garbageValue = "-2105744514"
   )
   SpritePixels method1736(UrlRequester var1) {
      if (this.field2902 != null && var1 != null) {
         class300 var2 = (class300)field2863.method2016(this.field2902);
         if (var2 == null) {
            var2 = new class300(this.field2902, var1);
            field2863.method2014(this.field2902, var2);
         }

         return var2.method1615();
      } else {
         return null;
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      descriptor = "(I)Z",
      garbageValue = "1265431805"
   )
   boolean method1719() {
      return this.spriteFlipV || this.spriteFlipH || this.outline != 0 || this.spriteShadow != 0;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      descriptor = "(Lrx;I)V",
      garbageValue = "-1471654768"
   )
   void method1715(SpritePixels var1) {
      if (this.spriteFlipV) {
         var1.flipVertically();
      }

      if (this.spriteFlipH) {
         var1.flipHorizontally();
      }

      if (this.outline > 0) {
         var1.pad(this.outline);
      }

      if (this.outline >= 1) {
         var1.outline(1);
      }

      if (this.outline >= 2) {
         var1.outline(16777215);
      }

      if (this.spriteShadow != 0) {
         var1.shadow(this.spriteShadow);
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      descriptor = "(I)Lnv;",
      garbageValue = "1347355979"
   )
   public Font getFont() {
      field2865 = false;
      if (this.fontId == -1) {
         return null;
      } else {
         Font var1 = (Font)Widget_cachedFonts.get((long)this.fontId);
         if (var1 != null) {
            return var1;
         } else {
            var1 = Timer.method2007(Widget_spritesArchive, PacketBufferNode.Widget_fontsArchive, this.fontId, 0);
            if (var1 != null) {
               Widget_cachedFonts.put(var1, (long)this.fontId);
            } else {
               field2865 = true;
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      descriptor = "(II)Lrx;",
      garbageValue = "-1594333003"
   )
   public SpritePixels getInventorySprite(int var1) {
      field2865 = false;
      if (var1 >= 0 && var1 < this.inventorySprites.length) {
         int var2 = this.inventorySprites[var1];
         if (var2 == -1) {
            return null;
         } else {
            SpritePixels var3 = (SpritePixels)Widget_cachedSprites.get((long)var2);
            if (var3 != null) {
               return var3;
            } else {
               var3 = class125.SpriteBuffer_getSprite(Widget_spritesArchive, var2, 0);
               if (var3 != null) {
                  Widget_cachedSprites.put(var3, (long)var2);
               } else {
                  field2865 = true;
               }

               return var3;
            }
         }
      } else {
         return null;
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      descriptor = "(Lga;IZLko;Lgz;Lgp;I)Lhh;",
      garbageValue = "-1671121568"
   )
   public Model getModel(SequenceDefinition var1, int var2, boolean var3, PlayerComposition var4, NPCComposition var5, NewShit var6) {
      field2865 = false;
      int var7;
      int var8;
      if (var3) {
         var7 = this.modelType2;
         var8 = this.modelId2;
      } else {
         var7 = this.modelType;
         var8 = this.modelId;
      }

      if (var7 == 6) {
         if (var5 == null) {
            return null;
         }

         var8 = var5.id;
      }

      if (var7 == 0) {
         return null;
      } else if (var7 == 1 && var8 == -1) {
         return null;
      } else {
         long var9 = (long)(var8 + (var7 << 16));
         if (var6 != null) {
            var9 |= var6.field1546 << 20;
         }

         Model var11 = (Model)Widget_cachedModels.get(var9);
         if (var11 == null) {
            ModelData var12 = null;
            int var13 = 64;
            int var14 = 768;
            switch(var7) {
            case 1:
               var12 = ModelData.ModelData_get(field2857, var8, 0);
               break;
            case 2:
               var12 = class129.getNpcDefinition(var8).method953((NewShit)null);
               break;
            case 3:
               var12 = var4 != null ? var4.getModelData() : null;
               break;
            case 4:
               ItemComposition var15 = NPCComposition.ItemDefinition_get(var8);
               var12 = var15.getModelData(10);
               var13 += var15.field1722;
               var14 += var15.field1734;
            case 5:
            default:
               break;
            case 6:
               var12 = class129.getNpcDefinition(var8).method953(var6);
            }

            if (var12 == null) {
               field2865 = true;
               return null;
            }

            var11 = var12.toModel(var13, var14, -50, -10, -50);
            Widget_cachedModels.put(var11, var9);
         }

         if (var1 != null) {
            var11 = var1.transformWidgetModel(var11, var2);
         }

         return var11;
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      descriptor = "(ZI)Lkv;",
      garbageValue = "211480"
   )
   public SpriteMask getSpriteMask(boolean var1) {
      if (this.spriteId == -1) {
         var1 = false;
      }

      int var2 = var1 ? this.spriteId * -1847696179 * 1116219397 : this.spriteId2 * 659533181 * 1205072853;
      if (var2 == -1) {
         return null;
      } else {
         long var3 = ((this.spriteFlipH ? 1L : 0L) << 39) + ((this.spriteFlipV ? 1L : 0L) << 38) + ((long)this.outline << 36) + (long)var2 + ((long)this.spriteShadow << 40);
         SpriteMask var5 = (SpriteMask)Widget_cachedSpriteMasks.get(var3);
         if (var5 != null) {
            return var5;
         } else {
            SpritePixels var6 = this.getSprite(var1, (UrlRequester)null);
            if (var6 == null) {
               return null;
            } else {
               SpritePixels var7 = var6.copyNormalized();
               int[] var8 = new int[var7.subHeight];
               int[] var9 = new int[var7.subHeight];

               for(int var10 = 0; var10 < var7.subHeight; ++var10) {
                  int var11 = 0;
                  int var12 = var7.subWidth;

                  int var13;
                  for(var13 = 0; var13 < var7.subWidth; ++var13) {
                     if (var7.pixels[var13 + var10 * var7.subWidth] == 0) {
                        var11 = var13;
                        break;
                     }
                  }

                  for(var13 = var7.subWidth - 1; var13 >= var11; --var13) {
                     if (var7.pixels[var13 + var10 * var7.subWidth] == 0) {
                        var12 = var13 + 1;
                        break;
                     }
                  }

                  var8[var10] = var11;
                  var9[var10] = var12 - var11;
               }

               var5 = new SpriteMask(var7.subWidth, var7.subHeight, var9, var8, var2);
               Widget_cachedSpriteMasks.put(var5, var3);
               return var5;
            }
         }
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      descriptor = "(ILjava/lang/String;S)V",
      garbageValue = "-14056"
   )
   public void setAction(int var1, String var2) {
      if (this.actions == null || this.actions.length <= var1) {
         String[] var3 = new String[var1 + 1];
         if (this.actions != null) {
            for(int var4 = 0; var4 < this.actions.length; ++var4) {
               var3[var4] = this.actions[var4];
            }
         }

         this.actions = var3;
      }

      this.actions[var1] = var2;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      descriptor = "(B)Z",
      garbageValue = "-74"
   )
   public boolean method1749() {
      return !this.isIf3 || this.type == 0 || this.type == 11 || this.hasListener || this.contentType == 1338 || this.type == 12;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      descriptor = "(I)Z",
      garbageValue = "366635379"
   )
   public boolean method1740() {
      return this.type == 11 || this.type == 12;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;Ldl;J)V"
   )
   public void method1746(String var1, UrlRequester var2, long var3) {
      if (this.type == 11 && -1L != var3) {
         var1 = var1.replaceAll("%userid%", Long.toString(var3));
         this.field2939 = new class163();
         if (!this.field2939.method847(var1, var2)) {
            this.field2939 = null;
         } else {
            if (this.field2941 == null || this.field2942 == null) {
               this.method1739();
            }

         }
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "296640153"
   )
   void method1739() {
      this.field2941 = new HashMap();
      this.field2942 = new HashMap();
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      descriptor = "(III)V",
      garbageValue = "-839153934"
   )
   public void method1725(int var1, int var2) {
      if (this.type == 11) {
         if (this.field2941 == null) {
            this.method1739();
         }

         this.field2941.put(var1, var2);
      }
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;II)V",
      garbageValue = "-705655664"
   )
   public void method1720(String var1, int var2) {
      if (this.type == 11) {
         if (this.field2942 == null) {
            this.method1739();
         }

         this.field2942.put(var1, var2);
      }
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      descriptor = "(I)Z",
      garbageValue = "-688445848"
   )
   public boolean method1727() {
      return this.field2921 == 2;
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;B)I",
      garbageValue = "113"
   )
   public int method1728(String var1) {
      return this.type == 11 && this.field2939 != null && this.method1727() ? this.field2939.method850(var1) : -1;
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;B)Ljava/lang/String;",
      garbageValue = "89"
   )
   public String method1726(String var1) {
      return this.type == 11 && this.field2939 != null && this.method1727() ? this.field2939.method851(var1) : null;
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      descriptor = "(B)I",
      garbageValue = "-1"
   )
   public int method1729() {
      return this.field2942 != null && this.field2942.size() > 0 ? 1 : 0;
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      descriptor = "(B)I",
      garbageValue = "-116"
   )
   public int method1730() {
      if (this.type == 11 && this.field2939 != null && this.field2942 != null && !this.field2942.isEmpty()) {
         String var1 = this.field2939.method853();
         return var1 != null && this.field2942.containsKey(this.field2939.method853()) ? (Integer)this.field2942.get(var1) : -1;
      } else {
         return -1;
      }
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      descriptor = "(B)Ljava/lang/String;",
      garbageValue = "5"
   )
   public String method1731() {
      if (this.type == 11 && this.field2939 != null) {
         String var1 = this.field2939.method853();
         Iterator var2 = this.field2939.method854().iterator();

         while(var2.hasNext()) {
            class173 var3 = (class173)var2.next();
            String var4 = String.format("%%%S%%", var3.method893());
            if (var3.vmethod3379() == 0) {
               var1.replaceAll(var4, Integer.toString(var3.vmethod3378()));
            } else {
               var1.replaceAll(var4, var3.vmethod3380());
            }
         }

         return var1;
      } else {
         return null;
      }
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      descriptor = "(B)[I",
      garbageValue = "-14"
   )
   public int[] method1732() {
      if (this.type == 11 && this.field2939 != null) {
         int[] var1 = new int[3];
         int var2 = 0;
         Iterator var3 = this.field2939.method854().iterator();

         while(var3.hasNext()) {
            class173 var4 = (class173)var3.next();
            if (!var4.method893().equals("user_id")) {
               if (var4.vmethod3379() != 0) {
                  return null;
               }

               var1[var2++] = var4.vmethod3378();
               if (var2 > 3) {
                  return null;
               }
            }
         }

         return var1;
      } else {
         return null;
      }
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      descriptor = "(Ldl;B)Z",
      garbageValue = "71"
   )
   public boolean method1745(UrlRequester var1) {
      if (this.type == 11 && this.field2939 != null) {
         this.field2939.method848(var1);
         if (this.field2939.method849() != this.field2921) {
            this.field2921 = this.field2939.method849();
            if (this.field2921 >= 100) {
               return true;
            }

            if (this.field2921 == 2) {
               this.method1734();
               return true;
            }
         }

         return false;
      } else {
         return false;
      }
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "1620784087"
   )
   void method1734() {
      this.noClickThrough = true;
      ArrayList var1 = this.field2939.method858();
      ArrayList var2 = this.field2939.method852();
      int var3 = var1.size() + var2.size();
      this.children = new Widget[var3];
      int var4 = 0;

      Iterator var5;
      Widget var7;
      for(var5 = var1.iterator(); var5.hasNext(); this.children[var4++] = var7) {
         class168 var6 = (class168)var5.next();
         var7 = DynamicObject.method451(5, this, var4, 0, 0, 0, 0, var6.field1434);
         var7.field2902 = var6.field1433.method655();
         class300 var8 = new class300(var6.field1433);
         field2863.method2014(var7.field2902, var8);
      }

      for(var5 = var2.iterator(); var5.hasNext(); this.children[var4++] = var7) {
         class169 var9 = (class169)var5.next();
         var7 = DynamicObject.method451(4, this, var4, 0, 0, 0, 0, var9.field1436);
         var7.text = var9.field1435;
         var7.fontId = (Integer)this.field2941.get(var9.field1437);
         var7.textXAlignment = var9.field1438;
         var7.textYAlignment = var9.field1439;
      }

   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "849668334"
   )
   public void method1743() {
      this.field2943 = new class301();

      for(int var1 = 1; var1 <= 12; ++var1) {
         this.field2943.field2807.method107(var1, 0);
      }

      for(char var2 = 0; var2 < ' '; ++var2) {
         this.field2943.field2807.method104(var2, 0);
      }

      this.field2943.field2807.method104('\u0080', 0);
      this.field2943.field2807.method107(82, 2);
      this.field2943.field2807.method107(81, 2);
      this.field2943.field2807.method107(86, 2);
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      descriptor = "(I)Lki;",
      garbageValue = "1153387619"
   )
   public class303 method1724() {
      return this.field2943 != null ? this.field2943.field2810 : null;
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      descriptor = "(B)Lkb;",
      garbageValue = "65"
   )
   public class298 method1748() {
      return this.field2943 != null ? this.field2943.field2808 : null;
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      descriptor = "(I)Lao;",
      garbageValue = "406803698"
   )
   public class28 method1737() {
      return this.field2943 != null ? this.field2943.field2807 : null;
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      descriptor = "(I)Lkt;",
      garbageValue = "-1759903354"
   )
   public class301 method1735() {
      return this.field2943;
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      descriptor = "(Lki;I)Z",
      garbageValue = "381752900"
   )
   boolean method1747(class303 var1) {
      boolean var2 = false;
      if (this.text != null && !this.text.isEmpty()) {
         var2 |= var1.method1637(class109.method652(this.text));
         this.text = "";
      }

      if (this.text2 != null && !this.text2.isEmpty()) {
         var2 |= var1.method1711(class109.method652(this.text2));
         this.text2 = "";
      }

      return var2;
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      descriptor = "(I)Z",
      garbageValue = "1849924136"
   )
   public boolean method1742() {
      class303 var1 = this.method1724();
      if (var1 == null) {
         return false;
      } else {
         boolean var2 = false;
         if (!var1.method1706() && this.fontId != -1) {
            int var3 = var1.method1680();
            int var4 = var1.method1681();
            int var5 = var1.method1663();
            int var6 = var1.method1678();
            Font var7 = this.getFont();
            if (var7 != null) {
               var2 |= var1.method1638(var7);
               var2 |= this.method1747(var1);
               var2 |= var1.method1643(var3, var4);
               var2 |= var1.method1656(var5, var6);
            }
         } else if (var1.method1706()) {
            var2 |= this.method1747(var1);
         }

         var1.method1634();
         return var2;
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      descriptor = "(IIZB)Ljava/lang/String;",
      garbageValue = "32"
   )
   static String method1750(int var0, int var1, boolean var2) {
      if (var1 >= 2 && var1 <= 36) {
         if (var2 && var0 >= 0) {
            int var3 = 2;

            for(int var4 = var0 / var1; var4 != 0; ++var3) {
               var4 /= var1;
            }

            char[] var5 = new char[var3];
            var5[0] = '+';

            for(int var6 = var3 - 1; var6 > 0; --var6) {
               int var7 = var0;
               var0 /= var1;
               int var8 = var7 - var0 * var1;
               if (var8 >= 10) {
                  var5[var6] = (char)(var8 + 87);
               } else {
                  var5[var6] = (char)(var8 + 48);
               }
            }

            return new String(var5);
         } else {
            return Integer.toString(var0, var1);
         }
      } else {
         throw new IllegalArgumentException("" + var1);
      }
   }

   @ObfuscatedName("jc")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "-1630385377"
   )
   static void Widget_runOnTargetLeave() {
      if (Client.isSpellSelected) {
         Widget var0 = AttackOption.getWidgetChild(class358.selectedSpellWidget, Client.selectedSpellChildIndex);
         if (var0 != null && var0.onTargetLeave != null) {
            ScriptEvent var1 = new ScriptEvent();
            var1.widget = var0;
            var1.args = var0.onTargetLeave;
            WorldMapElement.runScriptEvent(var1);
         }

         Client.selectedSpellItemId = -1;
         Client.isSpellSelected = false;
         class69.invalidateWidget(var0);
      }
   }
}
