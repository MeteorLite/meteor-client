import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("rl")
public class UserComparator1 implements Comparator {
   @ObfuscatedName("h")
   final boolean reversed;

   public UserComparator1(boolean var1) {
      this.reversed = var1;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(Lov;Lov;I)I",
      garbageValue = "1696581137"
   )
   int compare_bridged(User var1, User var2) {
      return this.reversed ? var1.compareTo_user(var2) : var2.compareTo_user(var1);
   }

   @ObfuscatedName("compare")
   public int compare(Object var1, Object var2) {
      return this.compare_bridged((User)var1, (User)var2);
   }

   @ObfuscatedName("equals")
   public boolean equals(Object var1) {
      return super.equals(var1);
   }
}
