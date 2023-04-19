import java.awt.Desktop;
import java.awt.Desktop.Action;
import java.net.URI;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("pi")
@Implements("Ignored")
public class Ignored extends User {
    @ObfuscatedName("af")
    int id;

    @ObfuscatedName("af")
    @ObfuscatedSignature(
            descriptor = "(Lpi;B)I",
            garbageValue = "-21"
    )
    int compareTo_ignored(Ignored var1) {
      return this.id - var1.id;
   }

    @ObfuscatedName("an")
    @ObfuscatedSignature(
            descriptor = "(Lpw;I)I",
            garbageValue = "1093536041"
    )
    public int compareTo_user(User var1) {
      return this.compareTo_ignored((Ignored)var1);
   }

   @ObfuscatedName("compareTo")
   public int compareTo(Object var1) {
      return this.compareTo_ignored((Ignored)var1);
   }

    @ObfuscatedName("af")
    @ObfuscatedSignature(
            descriptor = "(Ljava/lang/String;ZZB)V",
            garbageValue = "-88"
    )
    public static void openURL(String var0, boolean var1, boolean var2) {
      if (var1) {
         if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Action.BROWSE)) {
            try {
               Desktop.getDesktop().browse(new URI(var0));
               return;
            } catch (Exception var4) {
               ;
            }
         }

         if (class31.field91.startsWith("win")) {
            GrandExchangeOfferOwnWorldComparator.method366(var0, 0);
         } else if (class31.field91.startsWith("mac")) {
            RouteStrategy.method1177(var0, 1, "openjs");
         } else {
            RouteStrategy.method1177(var0, 2, "openjs");
         }
      } else {
         RouteStrategy.method1177(var0, 3, "openjs");
      }

   }
}
