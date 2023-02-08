import java.util.Iterator;
import java.util.LinkedList;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ii")
@Implements("WorldMapArea")
public class WorldMapArea {
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "Leb;"
   )
   static ClanSettings field2264;
    @ObfuscatedName("f")
    int id = -1;
    @ObfuscatedName("w")
    String internalName;
    @ObfuscatedName("v")
    String externalName;
    @ObfuscatedName("s")
    int backGroundColor = -1;
    @ObfuscatedName("z")
    int zoom = -1;
    @ObfuscatedName("j")
    @ObfuscatedSignature(
            descriptor = "Lko;"
    )
    Coord origin = null;
    @ObfuscatedName("i")
    int regionLowX = Integer.MAX_VALUE;
    @ObfuscatedName("n")
    int regionHighX = 0;
    @ObfuscatedName("l")
    int regionLowY = Integer.MAX_VALUE;
    @ObfuscatedName("k")
    int regionHighY = 0;
    @ObfuscatedName("c")
    boolean isMain = false;
    @ObfuscatedName("r")
    LinkedList sections;

    @ObfuscatedName("f")
    @ObfuscatedSignature(
            descriptor = "(Lrd;IS)V",
            garbageValue = "-29423"
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

    @ObfuscatedName("w")
    @ObfuscatedSignature(
            descriptor = "(Lrd;B)Ljy;",
            garbageValue = "111"
    )
    WorldMapSection readWorldMapSection(Buffer var1) {
      int var2 = var1.readUnsignedByte();
      WorldMapSectionType[] var3 = new WorldMapSectionType[]{WorldMapSectionType.WORLDMAPSECTIONTYPE2, WorldMapSectionType.WORLDMAPSECTIONTYPE1, WorldMapSectionType.WORLDMAPSECTIONTYPE3, WorldMapSectionType.WORLDMAPSECTIONTYPE0};
      WorldMapSectionType var4 = (WorldMapSectionType)class4.findEnumerated(var3, var2);
      Object var5 = null;
      switch(var4.type) {
      case 0:
         var5 = new WorldMapSection2();
         break;
      case 1:
         var5 = new WorldMapSection0();
         break;
      case 2:
         var5 = new class245();
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
            descriptor = "(IIII)Z",
            garbageValue = "-2076115363"
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

    @ObfuscatedName("s")
    @ObfuscatedSignature(
            descriptor = "(IIB)Z",
            garbageValue = "19"
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

    @ObfuscatedName("z")
    @ObfuscatedSignature(
            descriptor = "(IIII)[I",
            garbageValue = "-351148323"
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

    @ObfuscatedName("j")
    @ObfuscatedSignature(
            descriptor = "(IIB)Lko;",
            garbageValue = "16"
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

    @ObfuscatedName("i")
    @ObfuscatedSignature(
            descriptor = "(B)V",
            garbageValue = "-34"
    )
    void setBounds() {
      Iterator var1 = this.sections.iterator();

      while(var1.hasNext()) {
         WorldMapSection var2 = (WorldMapSection)var1.next();
         var2.expandBounds(this);
      }

   }

    @ObfuscatedName("n")
    @ObfuscatedSignature(
            descriptor = "(I)I",
            garbageValue = "-1182436962"
    )
    public int getId() {
      return this.id;
   }

    @ObfuscatedName("l")
    @ObfuscatedSignature(
            descriptor = "(I)Z",
            garbageValue = "-896012274"
    )
    public boolean getIsMain() {
      return this.isMain;
   }

    @ObfuscatedName("k")
    @ObfuscatedSignature(
            descriptor = "(I)Ljava/lang/String;",
            garbageValue = "456569340"
    )
    public String getInternalName() {
      return this.internalName;
   }

    @ObfuscatedName("c")
    @ObfuscatedSignature(
            descriptor = "(I)Ljava/lang/String;",
            garbageValue = "736592963"
    )
    public String getExternalName() {
      return this.externalName;
   }

    @ObfuscatedName("r")
    @ObfuscatedSignature(
            descriptor = "(I)I",
            garbageValue = "-1985713734"
    )
    int getBackGroundColor() {
      return this.backGroundColor;
   }

    @ObfuscatedName("b")
    @ObfuscatedSignature(
            descriptor = "(B)I",
            garbageValue = "-46"
    )
    public int getZoom() {
      return this.zoom;
   }

    @ObfuscatedName("m")
    @ObfuscatedSignature(
            descriptor = "(I)I",
            garbageValue = "-312550919"
    )
    public int getRegionLowX() {
      return this.regionLowX;
   }

    @ObfuscatedName("t")
    @ObfuscatedSignature(
            descriptor = "(I)I",
            garbageValue = "-264794234"
    )
    public int getRegionHighX() {
      return this.regionHighX;
   }

    @ObfuscatedName("h")
    @ObfuscatedSignature(
            descriptor = "(B)I",
            garbageValue = "15"
    )
    public int getRegionLowY() {
      return this.regionLowY;
   }

    @ObfuscatedName("p")
    @ObfuscatedSignature(
            descriptor = "(B)I",
            garbageValue = "90"
    )
    public int getRegionHighY() {
      return this.regionHighY;
   }

    @ObfuscatedName("o")
    @ObfuscatedSignature(
            descriptor = "(I)I",
            garbageValue = "1455293567"
    )
    public int getOriginX() {
      return this.origin.x;
   }

    @ObfuscatedName("u")
    @ObfuscatedSignature(
            descriptor = "(B)I",
            garbageValue = "-72"
    )
    public int getOriginPlane() {
      return this.origin.plane;
   }

    @ObfuscatedName("x")
    @ObfuscatedSignature(
            descriptor = "(I)I",
            garbageValue = "1481012371"
    )
    public int getOriginY() {
      return this.origin.y;
   }

    @ObfuscatedName("a")
    @ObfuscatedSignature(
            descriptor = "(B)Lko;",
            garbageValue = "103"
    )
    public Coord getOrigin() {
      return new Coord(this.origin);
   }

    @ObfuscatedName("f")
    @ObfuscatedSignature(
            descriptor = "(II)Lfz;",
            garbageValue = "-211491344"
    )
    public static InvDefinition getInvDefinition(int var0) {
      InvDefinition var1 = (InvDefinition)InvDefinition.InvDefinition_cached.get((long)var0);
      if (var1 != null) {
         return var1;
      } else {
         byte[] var2 = InvDefinition.InvDefinition_archive.takeFile(5, var0);
         var1 = new InvDefinition();
         if (var2 != null) {
            var1.decode(new Buffer(var2));
         }

         InvDefinition.InvDefinition_cached.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "(B)[Lco;",
      garbageValue = "1"
   )
   static AttackOption[] method1355() {
      return new AttackOption[]{AttackOption.AttackOption_hidden, AttackOption.field1071, AttackOption.field1067, AttackOption.AttackOption_alwaysRightClick, AttackOption.AttackOption_dependsOnCombatLevels};
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "1771861923"
   )
   static void method1353() {
      ReflectionCheck.method171(24);
      class70.setLoginResponseString("", "You were disconnected from the server.", "");
   }
}
