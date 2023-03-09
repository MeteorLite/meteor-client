import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("pq")
@Implements("IgnoreList")
public class IgnoreList extends UserList {
   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "Lrm;"
   )
   final LoginType field3653;

   @ObfuscatedSignature(
      descriptor = "(Lrm;)V"
   )
   public IgnoreList(LoginType var1) {
      super(400);
      this.field3653 = var1;
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "(I)Lpb;",
      garbageValue = "1708206647"
   )
   @Export("newInstance")
   User newInstance() {
      return new Ignored();
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "(IB)[Lpb;",
      garbageValue = "0"
   )
   @Export("newTypedArray")
   User[] newTypedArray(int var1) {
      return new Ignored[var1];
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "(Lsy;II)V",
      garbageValue = "-1601952909"
   )
   @Export("read")
   public void read(Buffer var1, int var2) {
      while(var1.offset < var2) {
         int var3 = var1.readUnsignedByte();
         if (var3 == 4) {
            Username var4 = new Username(var1.readStringCp1252NullTerminated(), this.field3653);
            if (!var4.hasCleanName()) {
               throw new IllegalStateException();
            }

            boolean var5 = false;
            class6.friendSystem.removeIgnore(var4.getName(), var5);
         } else {
            boolean var9 = (var3 & 1) != 0;
            Username var10 = new Username(var1.readStringCp1252NullTerminated(), this.field3653);
            Username var6 = new Username(var1.readStringCp1252NullTerminated(), this.field3653);
            var1.readStringCp1252NullTerminated();
            if (!var10.hasCleanName()) {
               throw new IllegalStateException();
            }

            Ignored var7 = (Ignored)this.getByCurrentUsername(var10);
            if (var9) {
               Ignored var8 = (Ignored)this.getByCurrentUsername(var6);
               if (var8 != null && var7 != var8) {
                  if (var7 != null) {
                     this.remove(var8);
                  } else {
                     var7 = var8;
                  }
               }
            }

            if (var7 != null) {
               this.changeName(var7, var10, var6);
            } else if (this.getSize() < 400) {
               int var11 = this.getSize();
               var7 = (Ignored)this.addLast(var10, var6);
               var7.id = var11;
            }
         }
      }

   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "(I)Z",
      garbageValue = "2089044337"
   )
   @Export("loadWorlds")
   static boolean loadWorlds() {
      try {
         if (class16.World_request == null) {
            class16.World_request = class345.urlRequester.request(new URL(class199.field1632));
         } else if (class16.World_request.isDone()) {
            byte[] var0 = class16.World_request.getResponse();
            Buffer var1 = new Buffer(var0);
            var1.readInt();
            World.World_count = var1.readUnsignedShort();
            class260.World_worlds = new World[World.World_count];

            World var3;
            for(int var2 = 0; var2 < World.World_count; var3.index = var2++) {
               var3 = class260.World_worlds[var2] = new World();
               var3.id = var1.readUnsignedShort();
               var3.properties = var1.readInt();
               var3.host = var1.readStringCp1252NullTerminated();
               var3.activity = var1.readStringCp1252NullTerminated();
               var3.location = var1.readUnsignedByte();
               var3.population = var1.readShort();
            }

            class16.sortWorlds(class260.World_worlds, 0, class260.World_worlds.length - 1, World.World_sortOption1, World.World_sortOption2);
            class16.World_request = null;
            return true;
         }
      } catch (Exception var4) {
         var4.printStackTrace();
         class16.World_request = null;
      }

      return false;
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "(CI)C",
      garbageValue = "-1387332345"
   )
   static char method2078(char var0) {
      if (var0 == 198) {
         return 'E';
      } else if (var0 == 230) {
         return 'e';
      } else if (var0 == 223) {
         return 's';
      } else if (var0 == 338) {
         return 'E';
      } else {
         return (char)(var0 == 339 ? 'e' : '\u0000');
      }
   }

   @ObfuscatedName("ik")
   @ObfuscatedSignature(
      descriptor = "(I)Z",
      garbageValue = "1863377427"
   )
   static boolean method2079() {
      return (Client.drawPlayerNames & 8) != 0;
   }
}
