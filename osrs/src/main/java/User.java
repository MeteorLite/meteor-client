import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ow")
@Implements("User")
public class User implements Comparable {
    @ObfuscatedName("v")
    @ObfuscatedSignature(
            descriptor = "Lsi;"
    )
    Username username;
    @ObfuscatedName("s")
    @ObfuscatedSignature(
            descriptor = "Lsi;"
    )
    Username previousUsername;

    @ObfuscatedName("w")
    @ObfuscatedSignature(
            descriptor = "(Low;I)I",
            garbageValue = "1651786682"
    )
    public int compareTo_user(User var1) {
      return this.username.compareToTyped(var1.username);
   }

    @ObfuscatedName("al")
    @ObfuscatedSignature(
            descriptor = "(I)Lsi;",
            garbageValue = "-2138495450"
    )
    public Username getUsername() {
      return this.username;
   }

    @ObfuscatedName("at")
    @ObfuscatedSignature(
            descriptor = "(B)Ljava/lang/String;",
            garbageValue = "-118"
    )
    public String getName() {
      return this.username == null ? "" : this.username.getName();
   }

    @ObfuscatedName("aj")
    @ObfuscatedSignature(
            descriptor = "(I)Ljava/lang/String;",
            garbageValue = "1030682980"
    )
    public String getPreviousName() {
      return this.previousUsername == null ? "" : this.previousUsername.getName();
   }

    @ObfuscatedName("ax")
    @ObfuscatedSignature(
            descriptor = "(Lsi;Lsi;I)V",
            garbageValue = "-794165536"
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
