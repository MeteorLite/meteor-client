import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@Implements("JSONException")
@ObfuscatedName("org/json/JSONException")
public class JSONException extends Exception {
    @ObfuscatedName("cause")
   Throwable cause;

   public JSONException(Throwable var1) {
      super(var1.getMessage());
      this.cause = var1;
   }

   public JSONException(String var1) {
      super(var1);
   }

    @ObfuscatedName("getCause")
    public Throwable getCause() {
      return this.cause;
   }
}
