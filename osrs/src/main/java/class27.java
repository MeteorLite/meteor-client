import java.util.Arrays;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bv")
public class class27 {
   @ObfuscatedName("av")
   int[] field82 = new int[112];
   @ObfuscatedName("aq")
   int[] field81 = new int[192];

   public class27() {
      Arrays.fill(this.field82, 3);
      Arrays.fill(this.field81, 3);
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "(III)V",
      garbageValue = "1963115442"
   )
   public void method109(int var1, int var2) {
      if (this.method117(var1) && this.method118(var2)) {
         this.field82[var1] = var2;
      }

   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "(CIB)V",
      garbageValue = "7"
   )
   public void method110(char var1, int var2) {
      if (this.method119(var1) && this.method118(var2)) {
         this.field81[var1] = var2;
      }

   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "(II)I",
      garbageValue = "314358708"
   )
   public int method111(int var1) {
      return this.method117(var1) ? this.field82[var1] : 0;
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "(CI)I",
      garbageValue = "1656635959"
   )
   public int method112(char var1) {
      return this.method119(var1) ? this.field81[var1] : 0;
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "(II)Z",
      garbageValue = "-1116456996"
   )
   public boolean method113(int var1) {
      return this.method117(var1) && (this.field82[var1] == 1 || this.field82[var1] == 3);
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      descriptor = "(CI)Z",
      garbageValue = "219089429"
   )
   public boolean method114(char var1) {
      return this.method119(var1) && (this.field81[var1] == 1 || this.field81[var1] == 3);
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      descriptor = "(II)Z",
      garbageValue = "-713108390"
   )
   public boolean method115(int var1) {
      return this.method117(var1) && (this.field82[var1] == 2 || this.field82[var1] == 3);
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      descriptor = "(CI)Z",
      garbageValue = "-1181390427"
   )
   public boolean method116(char var1) {
      return this.method119(var1) && (this.field81[var1] == 2 || this.field81[var1] == 3);
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      descriptor = "(IB)Z",
      garbageValue = "3"
   )
   boolean method117(int var1) {
      if (var1 >= 0 && var1 < 112) {
         return true;
      } else {
         System.out.println("Invalid keycode: " + var1);
         return false;
      }
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      descriptor = "(CB)Z",
      garbageValue = "35"
   )
   boolean method119(char var1) {
      if (var1 >= 0 && var1 < 192) {
         return true;
      } else {
         System.out.println("Invalid keychar: " + var1);
         return false;
      }
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      descriptor = "(IB)Z",
      garbageValue = "-97"
   )
   boolean method118(int var1) {
      if (var1 >= 0 && var1 < 4) {
         return true;
      } else {
         System.out.println("Invalid mode: " + var1);
         return false;
      }
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "1099055181"
   )
   public static void method120() {
      KitDefinition.KitDefinition_cached.clear();
   }

   @ObfuscatedName("jr")
   @ObfuscatedSignature(
      descriptor = "(Lda;I)V",
      garbageValue = "115499673"
   )
   static final void method108(PendingSpawn var0) {
      long var1 = 0L;
      int var3 = -1;
      int var4 = 0;
      int var5 = 0;
      if (var0.type == 0) {
         var1 = class1.scene.getBoundaryObjectTag(var0.plane, var0.x, var0.y);
      }

      if (var0.type == 1) {
         var1 = class1.scene.getWallDecorationTag(var0.plane, var0.x, var0.y);
      }

      if (var0.type == 2) {
         var1 = class1.scene.getGameObjectTag(var0.plane, var0.x, var0.y);
      }

      if (var0.type == 3) {
         var1 = class1.scene.getFloorDecorationTag(var0.plane, var0.x, var0.y);
      }

      if (0L != var1) {
         int var6 = class1.scene.getObjectFlags(var0.plane, var0.x, var0.y, var1);
         var3 = class279.Entity_unpackID(var1);
         var4 = var6 & 31;
         var5 = var6 >> 6 & 3;
      }

      var0.objectId = var3;
      var0.field919 = var4;
      var0.field917 = var5;
   }
}
