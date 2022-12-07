import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ov")
public class User implements Comparable {
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "Lrp;"
   )
   Username username;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      descriptor = "Lrp;"
   )
   Username previousUsername;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "(Lov;I)I",
      garbageValue = "-1893146393"
   )
   public int compareTo_user(User var1) {
      return this.username.compareToTyped(var1.username);
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      descriptor = "(I)Lrp;",
      garbageValue = "-1902661490"
   )
   public Username getUsername() {
      return this.username;
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      descriptor = "(B)Ljava/lang/String;",
      garbageValue = "3"
   )
   public String getName() {
      return this.username == null ? "" : this.username.getName();
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      descriptor = "(B)Ljava/lang/String;",
      garbageValue = "-54"
   )
   public String getPreviousName() {
      return this.previousUsername == null ? "" : this.previousUsername.getName();
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      descriptor = "(Lrp;Lrp;I)V",
      garbageValue = "-1276649572"
   )
   void set(Username var1, Username var2) {
      if (var1 == null) {
         throw new NullPointerException();
      } else {
         this.username = var1;
         this.previousUsername = var2;
      }
   }

   @ObfuscatedName("compareTo")
   public int compareTo(Object var1) {
      return this.compareTo_user((User)var1);
   }
}
