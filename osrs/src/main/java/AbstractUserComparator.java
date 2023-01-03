import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("os")
@Implements("AbstractUserComparator")
public abstract class AbstractUserComparator implements Comparator {
   @ObfuscatedName("e")
   Comparator nextComparator;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      descriptor = "(Ljava/util/Comparator;I)V",
      garbageValue = "651309965"
   )
   final void addComparator(Comparator var1) {
      if (this.nextComparator == null) {
         this.nextComparator = var1;
      } else if (this.nextComparator instanceof AbstractUserComparator) {
         ((AbstractUserComparator)this.nextComparator).addComparator(var1);
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      descriptor = "(Lov;Lov;I)I",
      garbageValue = "-1782434193"
   )
   protected final int compareUser(User var1, User var2) {
      return this.nextComparator == null ? 0 : this.nextComparator.compare(var1, var2);
   }

   @ObfuscatedName("equals")
   public boolean equals(Object var1) {
      return super.equals(var1);
   }
}
