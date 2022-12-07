import java.util.Iterator;
import java.util.LinkedList;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("it")
public class WorldMapArea {
   @ObfuscatedName("vl")
   @ObfuscatedSignature(
      descriptor = "Loi;"
   )
   static ArchiveDisk masterDisk;
   @ObfuscatedName("fo")
   @ObfuscatedSignature(
      descriptor = "Lln;"
   )
   static Archive archive20;
   @ObfuscatedName("qq")
   @ObfuscatedSignature(
      descriptor = "Ldn;"
   )
   static Varcs varcs;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -865162849
   )
   int id = -1;
   @ObfuscatedName("e")
   String internalName;
   @ObfuscatedName("v")
   String externalName;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1725773199
   )
   int backGroundColor = -1;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1625801673
   )
   int zoom = -1;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      descriptor = "Lky;"
   )
   Coord origin = null;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 693076639
   )
   int regionLowX = Integer.MAX_VALUE;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1108302035
   )
   int regionHighX = 0;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1503701713
   )
   int regionLowY = Integer.MAX_VALUE;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -693504869
   )
   int regionHighY = 0;
   @ObfuscatedName("j")
   boolean isMain = false;
   @ObfuscatedName("g")
   LinkedList sections;

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(Lqy;IB)V",
      garbageValue = "21"
   )
   public void read(Buffer var1, int var2) {
      this.id = var2;
      this.internalName = var1.readStringCp1252NullTerminated();
      this.externalName = var1.readStringCp1252NullTerminated();
      this.origin = new Coord(var1.readInt());
      this.backGroundColor = var1.readInt();
      var1.readUnsignedByte();
      this.isMain = var1.readUnsignedByte() == 1;
      this.zoom = var1.readUnsignedByte();
      int var3 = var1.readUnsignedByte();
      this.sections = new LinkedList();

      for(int var4 = 0; var4 < var3; ++var4) {
         this.sections.add(this.readWorldMapSection(var1));
      }

      this.setBounds();
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "(Lqy;I)Liw;",
      garbageValue = "-1065259744"
   )
   WorldMapSection readWorldMapSection(Buffer var1) {
      int var2 = var1.readUnsignedByte();
      WorldMapSectionType[] var3 = new WorldMapSectionType[]{WorldMapSectionType.WORLDMAPSECTIONTYPE3, WorldMapSectionType.WORLDMAPSECTIONTYPE2, WorldMapSectionType.WORLDMAPSECTIONTYPE0, WorldMapSectionType.WORLDMAPSECTIONTYPE1};
      WorldMapSectionType var4 = (WorldMapSectionType)World.findEnumerated(var3, var2);
      Object var5 = null;
      switch(var4.type) {
      case 0:
         var5 = new WorldMapSection0();
         break;
      case 1:
         var5 = new class241();
         break;
      case 2:
         var5 = new WorldMapSection2();
         break;
      case 3:
         var5 = new WorldMapSection1();
         break;
      default:
         throw new IllegalStateException("");
      }

      ((WorldMapSection)var5).read(var1);
      return (WorldMapSection)var5;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "(IIIB)Z",
      garbageValue = "-11"
   )
   public boolean containsCoord(int var1, int var2, int var3) {
      Iterator var4 = this.sections.iterator();

      WorldMapSection var5;
      do {
         if (!var4.hasNext()) {
            return false;
         }

         var5 = (WorldMapSection)var4.next();
      } while(!var5.containsCoord(var1, var2, var3));

      return true;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      descriptor = "(III)Z",
      garbageValue = "-2133245025"
   )
   public boolean containsPosition(int var1, int var2) {
      int var3 = var1 / 64;
      int var4 = var2 / 64;
      if (var3 >= this.regionLowX && var3 <= this.regionHighX) {
         if (var4 >= this.regionLowY && var4 <= this.regionHighY) {
            Iterator var5 = this.sections.iterator();

            WorldMapSection var6;
            do {
               if (!var5.hasNext()) {
                  return false;
               }

               var6 = (WorldMapSection)var5.next();
            } while(!var6.containsPosition(var1, var2));

            return true;
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      descriptor = "(IIII)[I",
      garbageValue = "665654493"
   )
   public int[] position(int var1, int var2, int var3) {
      Iterator var4 = this.sections.iterator();

      WorldMapSection var5;
      do {
         if (!var4.hasNext()) {
            return null;
         }

         var5 = (WorldMapSection)var4.next();
      } while(!var5.containsCoord(var1, var2, var3));

      return var5.getBorderTileLengths(var1, var2, var3);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      descriptor = "(IIB)Lky;",
      garbageValue = "-62"
   )
   public Coord coord(int var1, int var2) {
      Iterator var3 = this.sections.iterator();

      WorldMapSection var4;
      do {
         if (!var3.hasNext()) {
            return null;
         }

         var4 = (WorldMapSection)var3.next();
      } while(!var4.containsPosition(var1, var2));

      return var4.coord(var1, var2);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "1766044231"
   )
   void setBounds() {
      Iterator var1 = this.sections.iterator();

      while(var1.hasNext()) {
         WorldMapSection var2 = (WorldMapSection)var1.next();
         var2.expandBounds(this);
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "-1762068654"
   )
   public int getId() {
      return this.id;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      descriptor = "(I)Z",
      garbageValue = "1931437723"
   )
   public boolean getIsMain() {
      return this.isMain;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      descriptor = "(I)Ljava/lang/String;",
      garbageValue = "1626339354"
   )
   public String getInternalName() {
      return this.internalName;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      descriptor = "(B)Ljava/lang/String;",
      garbageValue = "18"
   )
   public String getExternalName() {
      return this.externalName;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      descriptor = "(B)I",
      garbageValue = "-53"
   )
   int getBackGroundColor() {
      return this.backGroundColor;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "1068603162"
   )
   public int getZoom() {
      return this.zoom;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      descriptor = "(B)I",
      garbageValue = "74"
   )
   public int getRegionLowX() {
      return this.regionLowX;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      descriptor = "(B)I",
      garbageValue = "12"
   )
   public int getRegionHighX() {
      return this.regionHighX;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "-492908106"
   )
   public int getRegionLowY() {
      return this.regionLowY;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "-322384936"
   )
   public int getRegionHighY() {
      return this.regionHighY;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "469004825"
   )
   public int getOriginX() {
      return this.origin.x;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      descriptor = "(B)I",
      garbageValue = "-97"
   )
   public int getOriginPlane() {
      return this.origin.plane;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      descriptor = "(B)I",
      garbageValue = "105"
   )
   public int getOriginY() {
      return this.origin.y;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      descriptor = "(I)Lky;",
      garbageValue = "1494718405"
   )
   public Coord getOrigin() {
      return new Coord(this.origin);
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      descriptor = "(ILbm;ZI)I",
      garbageValue = "2001824816"
   )
   static int method4967(int var0, Script var1, boolean var2) {
      Widget var3 = var2 ? class190.scriptDotWidget : class360.scriptActiveWidget;
      if (var0 == 1800) {
         Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = PacketWriter.Widget_unpackTargetMask(Clock.getWidgetFlags(var3));
         return 1;
      } else if (var0 != 1801) {
         if (var0 == 1802) {
            if (var3.dataText == null) {
               Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
            } else {
               Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var3.dataText;
            }

            return 1;
         } else {
            return 2;
         }
      } else {
         int var4 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize];
         --var4;
         if (var3.actions != null && var4 < var3.actions.length && var3.actions[var4] != null) {
            Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var3.actions[var4];
         } else {
            Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
         }

         return 1;
      }
   }
}
