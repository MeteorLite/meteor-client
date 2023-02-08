import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dh")
@Implements("UserComparator6")
public class UserComparator6 extends AbstractUserComparator {
    @ObfuscatedName("jd")
    @ObfuscatedSignature(
            descriptor = "[Lrs;"
    )
    static SpritePixels[] mapMarkerSprites;
    @ObfuscatedName("f")
    final boolean reversed;

   public UserComparator6(boolean var1) {
      this.reversed = var1;
   }

    @ObfuscatedName("f")
    @ObfuscatedSignature(
            descriptor = "(Loa;Loa;I)I",
            garbageValue = "138829352"
    )
    int compareBuddy(Buddy var1, Buddy var2) {
      if (var1.world != 0 && var2.world != 0) {
         return this.reversed ? var1.getUsername().compareToTyped(var2.getUsername()) : var2.getUsername().compareToTyped(var1.getUsername());
      } else {
         return this.compareUser(var1, var2);
      }
   }

    @ObfuscatedName("compare")
    public int compare(Object var1, Object var2) {
      return this.compareBuddy((Buddy)var1, (Buddy)var2);
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "-2095060599"
   )
   static final void method668() {
      Decimator.method306("You can't add yourself to your own friend list");
   }

    @ObfuscatedName("m")
    @ObfuscatedSignature(
            descriptor = "(ZI)V",
            garbageValue = "-681916005"
    )
    static void Login_promptCredentials(boolean var0) {
      if (!Decimator.client.method369() && !Decimator.client.method344() && !Decimator.client.method343()) {
         Login.Login_response1 = "";
         Login.Login_response2 = "Enter your username/email & password.";
         Login.Login_response3 = "";
         ReflectionCheck.method171(2);
         if (var0) {
            Login.Login_password = "";
         }

         FriendSystem.method405();
         class361.method1925();
      } else {
         ReflectionCheck.method171(10);
      }
   }
}
