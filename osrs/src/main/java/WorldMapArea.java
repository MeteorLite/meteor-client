import java.util.Iterator;
import java.util.LinkedList;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("js")
@Implements("WorldMapArea")
public class WorldMapArea {
    @ObfuscatedName("af")
    int id = -1;
    @ObfuscatedName("an")
    String internalName;
    @ObfuscatedName("aw")
    String externalName;
    @ObfuscatedName("ac")
    int backGroundColor = -1;
    @ObfuscatedName("au")
    int zoom = -1;
    @ObfuscatedName("ab")
    @ObfuscatedSignature(
            descriptor = "Llb;"
    )
    Coord origin = null;
    @ObfuscatedName("aq")
    int regionLowX = Integer.MAX_VALUE;
    @ObfuscatedName("al")
    int regionHighX = 0;
    @ObfuscatedName("at")
    int regionLowY = Integer.MAX_VALUE;
    @ObfuscatedName("aa")
    int regionHighY = 0;
    @ObfuscatedName("ay")
    boolean isMain = false;
    @ObfuscatedName("ao")
    LinkedList sections;

    @ObfuscatedName("af")
    @ObfuscatedSignature(
            descriptor = "(Lsg;IB)V",
            garbageValue = "-126"
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

    @ObfuscatedName("an")
    @ObfuscatedSignature(
            descriptor = "(Lsg;I)Lkw;",
            garbageValue = "427135973"
    )
    WorldMapSection readWorldMapSection(Buffer var1) {
      int var2 = var1.readUnsignedByte();
      WorldMapSectionType var3 = (WorldMapSectionType)StructComposition.findEnumerated(WorldMapSectionType.method1508(), var2);
      Object var4 = null;
      switch(var3.type) {
      case 0:
         var4 = new WorldMapSection1();
         break;
      case 1:
         var4 = new WorldMapSection2();
         break;
      case 2:
         var4 = new class252();
         break;
      case 3:
         var4 = new WorldMapSection0();
         break;
      default:
         throw new IllegalStateException("");
      }

      ((WorldMapSection)var4).read(var1);
      return (WorldMapSection)var4;
   }

    @ObfuscatedName("aw")
    @ObfuscatedSignature(
            descriptor = "(IIII)Z",
            garbageValue = "-1323143702"
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

    @ObfuscatedName("ac")
    @ObfuscatedSignature(
            descriptor = "(III)Z",
            garbageValue = "1764440845"
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

    @ObfuscatedName("au")
    @ObfuscatedSignature(
            descriptor = "(IIIB)[I",
            garbageValue = "6"
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

    @ObfuscatedName("ab")
    @ObfuscatedSignature(
            descriptor = "(III)Llb;",
            garbageValue = "2133508945"
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

    @ObfuscatedName("aq")
    @ObfuscatedSignature(
            descriptor = "(I)V",
            garbageValue = "1510562162"
    )
    void setBounds() {
      Iterator var1 = this.sections.iterator();

      while(var1.hasNext()) {
         WorldMapSection var2 = (WorldMapSection)var1.next();
         var2.expandBounds(this);
      }

   }

    @ObfuscatedName("al")
    @ObfuscatedSignature(
            descriptor = "(I)I",
            garbageValue = "-964267539"
    )
    public int getId() {
      return this.id;
   }

    @ObfuscatedName("at")
    @ObfuscatedSignature(
            descriptor = "(I)Z",
            garbageValue = "-926489840"
    )
    public boolean getIsMain() {
      return this.isMain;
   }

    @ObfuscatedName("aa")
    @ObfuscatedSignature(
            descriptor = "(I)Ljava/lang/String;",
            garbageValue = "1181486070"
    )
    public String getInternalName() {
      return this.internalName;
   }

    @ObfuscatedName("ay")
    @ObfuscatedSignature(
            descriptor = "(S)Ljava/lang/String;",
            garbageValue = "25057"
    )
    public String getExternalName() {
      return this.externalName;
   }

    @ObfuscatedName("ao")
    @ObfuscatedSignature(
            descriptor = "(I)I",
            garbageValue = "-2082932774"
    )
    int getBackGroundColor() {
      return this.backGroundColor;
   }

    @ObfuscatedName("ax")
    @ObfuscatedSignature(
            descriptor = "(I)I",
            garbageValue = "447952954"
    )
    public int getZoom() {
      return this.zoom;
   }

    @ObfuscatedName("ai")
    @ObfuscatedSignature(
            descriptor = "(I)I",
            garbageValue = "16748608"
    )
    public int getRegionLowX() {
      return this.regionLowX;
   }

    @ObfuscatedName("ag")
    @ObfuscatedSignature(
            descriptor = "(I)I",
            garbageValue = "-1231382819"
    )
    public int getRegionHighX() {
      return this.regionHighX;
   }

    @ObfuscatedName("ah")
    @ObfuscatedSignature(
            descriptor = "(I)I",
            garbageValue = "-599342073"
    )
    public int getRegionLowY() {
      return this.regionLowY;
   }

    @ObfuscatedName("av")
    @ObfuscatedSignature(
            descriptor = "(I)I",
            garbageValue = "1746970873"
    )
    public int getRegionHighY() {
      return this.regionHighY;
   }

    @ObfuscatedName("ar")
    @ObfuscatedSignature(
            descriptor = "(B)I",
            garbageValue = "126"
    )
    public int getOriginX() {
      return this.origin.x;
   }

    @ObfuscatedName("am")
    @ObfuscatedSignature(
            descriptor = "(I)I",
            garbageValue = "-2019541929"
    )
    public int getOriginPlane() {
      return this.origin.plane;
   }

    @ObfuscatedName("as")
    @ObfuscatedSignature(
            descriptor = "(I)I",
            garbageValue = "-151833963"
    )
    public int getOriginY() {
      return this.origin.y;
   }

    @ObfuscatedName("aj")
    @ObfuscatedSignature(
            descriptor = "(B)Llb;",
            garbageValue = "19"
    )
    public Coord getOrigin() {
      return new Coord(this.origin);
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "(Lsg;Ljava/lang/String;I)I",
      garbageValue = "-53610141"
   )
   public static int method1432(Buffer var0, String var1) {
      int var2 = var0.offset;
      byte[] var3 = RouteStrategy.method1176(var1);
      var0.writeSmartByteShort(var3.length);
      var0.offset += class319.huffman.compress(var3, 0, var3.length, var0.array, var0.offset);
      return var0.offset - var2;
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      descriptor = "(IIB)V",
      garbageValue = "32"
   )
   public static void method1433(int var0, int var1) {
      int var2 = Rasterizer3D.clips.Rasterizer3D_rowOffsets[0];
      int var3 = var2 / Rasterizer2D.Rasterizer2D_width;
      int var4 = var2 - var3 * Rasterizer2D.Rasterizer2D_width;
      Rasterizer3D.clips.method1359(var0, var4, var1, var3);
   }

   @ObfuscatedName("bu")
   @ObfuscatedSignature(
      descriptor = "(ILch;ZI)I",
      garbageValue = "1955008701"
   )
   static int method1431(int var0, Script var1, boolean var2) {
      if (var0 == 6500) {
         Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Players.loadWorlds() ? 1 : 0;
         return 1;
      } else {
         World var3;
         if (var0 == 6501) {
            var3 = FaceNormal.worldListStart();
            if (var3 != null) {
               Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.id;
               Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.properties;
               Interpreter.Interpreter_stringStack[++SecureRandomCallable.Interpreter_stringStackSize - 1] = var3.activity;
               Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.location;
               Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.population;
               Interpreter.Interpreter_stringStack[++SecureRandomCallable.Interpreter_stringStackSize - 1] = var3.host;
            } else {
               Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -1;
               Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
               Interpreter.Interpreter_stringStack[++SecureRandomCallable.Interpreter_stringStackSize - 1] = "";
               Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
               Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
               Interpreter.Interpreter_stringStack[++SecureRandomCallable.Interpreter_stringStackSize - 1] = "";
            }

            return 1;
         } else if (var0 == 6502) {
            var3 = Interpreter.getNextWorldListWorld();
            if (var3 != null) {
               Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.id;
               Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.properties;
               Interpreter.Interpreter_stringStack[++SecureRandomCallable.Interpreter_stringStackSize - 1] = var3.activity;
               Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.location;
               Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.population;
               Interpreter.Interpreter_stringStack[++SecureRandomCallable.Interpreter_stringStackSize - 1] = var3.host;
            } else {
               Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -1;
               Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
               Interpreter.Interpreter_stringStack[++SecureRandomCallable.Interpreter_stringStackSize - 1] = "";
               Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
               Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
               Interpreter.Interpreter_stringStack[++SecureRandomCallable.Interpreter_stringStackSize - 1] = "";
            }

            return 1;
         } else {
            World var4;
            int var5;
            int var7;
            if (var0 == 6506) {
               var7 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
               var4 = null;

               for(var5 = 0; var5 < World.World_count; ++var5) {
                  if (var7 == class31.World_worlds[var5].id) {
                     var4 = class31.World_worlds[var5];
                     break;
                  }
               }

               if (var4 != null) {
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var4.id;
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var4.properties;
                  Interpreter.Interpreter_stringStack[++SecureRandomCallable.Interpreter_stringStackSize - 1] = var4.activity;
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var4.location;
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var4.population;
                  Interpreter.Interpreter_stringStack[++SecureRandomCallable.Interpreter_stringStackSize - 1] = var4.host;
               } else {
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -1;
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
                  Interpreter.Interpreter_stringStack[++SecureRandomCallable.Interpreter_stringStackSize - 1] = "";
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
                  Interpreter.Interpreter_stringStack[++SecureRandomCallable.Interpreter_stringStackSize - 1] = "";
               }

               return 1;
            } else if (var0 == 6507) {
               Interpreter.Interpreter_intStackSize -= 4;
               var7 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
               boolean var10 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1] == 1;
               var5 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 2];
               boolean var6 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 3] == 1;
               class127.sortWorldList(var7, var10, var5, var6);
               return 1;
            } else if (var0 != 6511) {
               if (var0 == 6512) {
                  Client.followerOpsLowPriority = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
                  return 1;
               } else {
                  int var8;
                  ParamComposition var9;
                  if (var0 == 6513) {
                     Interpreter.Interpreter_intStackSize -= 2;
                     var7 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
                     var8 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
                     var9 = class33.getParamDefinition(var8);
                     if (var9.isString()) {
                        Interpreter.Interpreter_stringStack[++SecureRandomCallable.Interpreter_stringStackSize - 1] = AbstractArchive.getNpcDefinition(var7).getStringParam(var8, var9.defaultStr);
                     } else {
                        Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = AbstractArchive.getNpcDefinition(var7).getIntParam(var8, var9.defaultInt);
                     }

                     return 1;
                  } else if (var0 == 6514) {
                     Interpreter.Interpreter_intStackSize -= 2;
                     var7 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
                     var8 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
                     var9 = class33.getParamDefinition(var8);
                     if (var9.isString()) {
                        Interpreter.Interpreter_stringStack[++SecureRandomCallable.Interpreter_stringStackSize - 1] = class144.getObjectDefinition(var7).getStringParam(var8, var9.defaultStr);
                     } else {
                        Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class144.getObjectDefinition(var7).getIntParam(var8, var9.defaultInt);
                     }

                     return 1;
                  } else if (var0 == 6515) {
                     Interpreter.Interpreter_intStackSize -= 2;
                     var7 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
                     var8 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
                     var9 = class33.getParamDefinition(var8);
                     if (var9.isString()) {
                        Interpreter.Interpreter_stringStack[++SecureRandomCallable.Interpreter_stringStackSize - 1] = HealthBarUpdate.ItemDefinition_get(var7).getStringParam(var8, var9.defaultStr);
                     } else {
                        Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = HealthBarUpdate.ItemDefinition_get(var7).getIntParam(var8, var9.defaultInt);
                     }

                     return 1;
                  } else if (var0 == 6516) {
                     Interpreter.Interpreter_intStackSize -= 2;
                     var7 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
                     var8 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
                     var9 = class33.getParamDefinition(var8);
                     if (var9.isString()) {
                        Interpreter.Interpreter_stringStack[++SecureRandomCallable.Interpreter_stringStackSize - 1] = class195.StructDefinition_getStructDefinition(var7).getStringParam(var8, var9.defaultStr);
                     } else {
                        Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class195.StructDefinition_getStructDefinition(var7).getIntParam(var8, var9.defaultInt);
                     }

                     return 1;
                  } else if (var0 == 6518) {
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Client.onMobile ? 1 : 0;
                     return 1;
                  } else if (var0 == 6519) {
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Client.clientType;
                     return 1;
                  } else if (var0 == 6520) {
                     return 1;
                  } else if (var0 == 6521) {
                     return 1;
                  } else if (var0 == 6522) {
                     --SecureRandomCallable.Interpreter_stringStackSize;
                     --Interpreter.Interpreter_intStackSize;
                     return 1;
                  } else if (var0 == 6523) {
                     --SecureRandomCallable.Interpreter_stringStackSize;
                     --Interpreter.Interpreter_intStackSize;
                     return 1;
                  } else if (var0 == 6524) {
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -1;
                     return 1;
                  } else if (var0 == 6525) {
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 1;
                     return 1;
                  } else if (var0 == 6526) {
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 1;
                     return 1;
                  } else if (var0 == 6527) {
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Client.field363;
                     return 1;
                  } else {
                     return 2;
                  }
               }
            } else {
               var7 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
               if (var7 >= 0 && var7 < World.World_count) {
                  var4 = class31.World_worlds[var7];
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var4.id;
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var4.properties;
                  Interpreter.Interpreter_stringStack[++SecureRandomCallable.Interpreter_stringStackSize - 1] = var4.activity;
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var4.location;
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var4.population;
                  Interpreter.Interpreter_stringStack[++SecureRandomCallable.Interpreter_stringStackSize - 1] = var4.host;
               } else {
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -1;
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
                  Interpreter.Interpreter_stringStack[++SecureRandomCallable.Interpreter_stringStackSize - 1] = "";
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
                  Interpreter.Interpreter_stringStack[++SecureRandomCallable.Interpreter_stringStackSize - 1] = "";
               }

               return 1;
            }
         }
      }
   }
}
