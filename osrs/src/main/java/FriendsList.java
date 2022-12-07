import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ng")
public class FriendsList extends UserList {
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "Lqi;"
   )
   final LoginType loginType;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 906024881
   )
   int field4506 = 1;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      descriptor = "Lma;"
   )
   public LinkDeque field4504 = new LinkDeque();

   @ObfuscatedSignature(
      descriptor = "(Lqi;)V"
   )
   public FriendsList(LoginType var1) {
      super(400);
      this.loginType = var1;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(B)Lov;",
      garbageValue = "47"
   )
   User newInstance() {
      return new Friend();
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "(II)[Lov;",
      garbageValue = "1710517567"
   )
   User[] newTypedArray(int var1) {
      return new Friend[var1];
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "(Lrp;ZS)Z",
      garbageValue = "2000"
   )
   public boolean isFriended(Username var1, boolean var2) {
      Friend var3 = (Friend)this.getByUsername(var1);
      if (var3 == null) {
         return false;
      } else {
         return !var2 || var3.world != 0;
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      descriptor = "(Lqy;IB)V",
      garbageValue = "110"
   )
   public void read(Buffer var1, int var2) {
      while(true) {
         if (var1.offset < var2) {
            boolean var3 = var1.readUnsignedByte() == 1;
            Username var4 = new Username(var1.readStringCp1252NullTerminated(), this.loginType);
            Username var5 = new Username(var1.readStringCp1252NullTerminated(), this.loginType);
            int var6 = var1.readUnsignedShort();
            int var7 = var1.readUnsignedByte();
            int var8 = var1.readUnsignedByte();
            boolean var9 = (var8 & 2) != 0;
            boolean var10 = (var8 & 1) != 0;
            if (var6 > 0) {
               var1.readStringCp1252NullTerminated();
               var1.readUnsignedByte();
               var1.readInt();
            }

            var1.readStringCp1252NullTerminated();
            if (var4 != null && var4.hasCleanName()) {
               Friend var11 = (Friend)this.getByCurrentUsername(var4);
               if (var3) {
                  Friend var12 = (Friend)this.getByCurrentUsername(var5);
                  if (var12 != null && var11 != var12) {
                     if (var11 != null) {
                        this.remove(var12);
                     } else {
                        var11 = var12;
                     }
                  }
               }

               if (var11 != null) {
                  this.changeName(var11, var4, var5);
                  if (var6 != var11.world) {
                     boolean var14 = true;

                     for(class391 var13 = (class391)this.field4504.last(); var13 != null; var13 = (class391)this.field4504.previous()) {
                        if (var13.field4521.equals(var4)) {
                           if (var6 != 0 && var13.field4522 == 0) {
                              var13.remove();
                              var14 = false;
                           } else if (var6 == 0 && var13.field4522 != 0) {
                              var13.remove();
                              var14 = false;
                           }
                        }
                     }

                     if (var14) {
                        this.field4504.addFirst(new class391(var4, var6));
                     }
                  }
               } else {
                  if (this.getSize() >= 400) {
                     continue;
                  }

                  var11 = (Friend)this.addLast(var4, var5);
               }

               if (var6 != var11.world) {
                  var11.int2 = ++this.field4506 - 1;
                  if (var11.world == -1 && var6 == 0) {
                     var11.int2 = -(var11.int2 * -388257165) * 1595280059;
                  }

                  var11.world = var6;
               }

               var11.rank = var7;
               var11.field4519 = var9;
               var11.field4518 = var10;
               continue;
            }

            throw new IllegalStateException();
         }

         this.sort();
         return;
      }
   }
}
