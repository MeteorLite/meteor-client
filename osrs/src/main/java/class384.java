import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ni")
public final class class384 {
   @ObfuscatedName("h")
   final Comparator field3666;
   @ObfuscatedName("e")
   final Map field3660;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "Lnm;"
   )
   final class366 field3664;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      descriptor = "Lnm;"
   )
   final class366 field3662;
   @ObfuscatedName("m")
   final long field3663;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      descriptor = "Lns;"
   )
   final class382 field3661;
   @ObfuscatedName("f")
   final int field3665;

   @ObfuscatedSignature(
      descriptor = "(JILns;)V"
   )
   class384(long var1, int var3, class382 var4) {
      this.field3666 = new class383(this);
      this.field3663 = var1;
      this.field3665 = var3;
      this.field3661 = var4;
      if (this.field3665 == -1) {
         this.field3660 = new HashMap(64);
         this.field3664 = new class366(64, this.field3666);
         this.field3662 = null;
      } else {
         if (this.field3661 == null) {
            throw new IllegalArgumentException("");
         }

         this.field3660 = new HashMap(this.field3665);
         this.field3664 = new class366(this.field3665, this.field3666);
         this.field3662 = new class366(this.field3665);
      }

   }

   @ObfuscatedSignature(
      descriptor = "(ILns;)V"
   )
   public class384(int var1, class382 var2) {
      this(-1L, var1, var2);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(I)Z",
      garbageValue = "-1534234812"
   )
   boolean method2013() {
      return this.field3665 != -1;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/Object;I)Ljava/lang/Object;",
      garbageValue = "-646919436"
   )
   public Object method2016(Object var1) {
      synchronized(this) {
         if (this.field3663 != -1L) {
            this.method2018();
         }

         class385 var3 = (class385)this.field3660.get(var1);
         if (var3 == null) {
            return null;
         } else {
            this.method2015(var3, false);
            return var3.field3669;
         }
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/Object;Ljava/lang/Object;I)Ljava/lang/Object;",
      garbageValue = "-1936546868"
   )
   public Object method2014(Object var1, Object var2) {
      synchronized(this) {
         if (this.field3663 != -1L) {
            this.method2018();
         }

         class385 var4 = (class385)this.field3660.get(var1);
         if (var4 != null) {
            Object var8 = var4.field3669;
            var4.field3669 = var2;
            this.method2015(var4, false);
            return var8;
         } else {
            class385 var5;
            if (this.method2013() && this.field3660.size() == this.field3665) {
               var5 = (class385)this.field3662.remove();
               this.field3660.remove(var5.field3668);
               this.field3664.remove(var5);
            }

            var5 = new class385(var2, var1);
            this.field3660.put(var1, var5);
            this.method2015(var5, true);
            return null;
         }
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      descriptor = "(Lnz;ZI)V",
      garbageValue = "377209156"
   )
   void method2015(class385 var1, boolean var2) {
      if (!var2) {
         this.field3664.remove(var1);
         if (this.method2013() && !this.field3662.remove(var1)) {
            throw new IllegalStateException("");
         }
      }

      var1.field3667 = System.currentTimeMillis();
      if (this.method2013()) {
         switch(this.field3661.field3658) {
         case 0:
            var1.field3670 = var1.field3667;
            break;
         case 1:
            ++var1.field3670;
         }

         this.field3662.add(var1);
      }

      this.field3664.add(var1);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "219225117"
   )
   void method2018() {
      if (this.field3663 == -1L) {
         throw new IllegalStateException("");
      } else {
         long var1 = System.currentTimeMillis() - this.field3663;

         while(!this.field3664.isEmpty()) {
            class385 var3 = (class385)this.field3664.peek();
            if (var3.field3667 >= var1) {
               return;
            }

            this.field3660.remove(var3.field3668);
            this.field3664.remove(var3);
            if (this.method2013()) {
               this.field3662.remove(var3);
            }
         }

      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "549271999"
   )
   public void method2017() {
      synchronized(this) {
         this.field3660.clear();
         this.field3664.clear();
         if (this.method2013()) {
            this.field3662.clear();
         }

      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "-720383995"
   )
   static void method2012() {
      Tiles.Tiles_underlays = null;
      class490.Tiles_overlays = null;
      Tiles.Tiles_shapes = null;
      class358.field3562 = null;
      class159.field1401 = null;
      Canvas.field68 = null;
      Tiles.field819 = null;
      Tiles.Tiles_hue = null;
      PcmPlayer.Tiles_saturation = null;
      Tiles.Tiles_lightness = null;
      NPC.Tiles_hueMultiplier = null;
      MenuAction.field720 = null;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      descriptor = "(II)V",
      garbageValue = "-1932572710"
   )
   public static void method2011(int var0) {
      class286.musicPlayerStatus = 1;
      class304.musicTrackArchive = null;
      class109.musicTrackGroupId = -1;
      class286.musicTrackFileId = -1;
      class467.musicTrackVolume = 0;
      class145.musicTrackBoolean = false;
      class286.pcmSampleLength = var0;
   }
}
