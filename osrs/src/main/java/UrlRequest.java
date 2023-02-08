import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dg")
@Implements("UrlRequest")
public class UrlRequest {
    @ObfuscatedName("jz")
    @ObfuscatedSignature(
            descriptor = "[Lrs;"
    )
    static SpritePixels[] mapDotSprites;
    @ObfuscatedName("f")
    final URL url;
    @ObfuscatedName("w")
    volatile boolean isDone0;
    @ObfuscatedName("v")
    volatile byte[] response0;

   UrlRequest(URL var1) {
      this.url = var1;
   }

    @ObfuscatedName("f")
    @ObfuscatedSignature(
            descriptor = "(I)Z",
            garbageValue = "1746965864"
    )
    public boolean isDone() {
      return this.isDone0;
   }

    @ObfuscatedName("w")
    @ObfuscatedSignature(
            descriptor = "(B)[B",
            garbageValue = "104"
    )
    public byte[] getResponse() {
      return this.response0;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "(I)Ljava/lang/String;",
      garbageValue = "988797098"
   )
   public String method642() {
      return this.url.toString();
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "-122"
   )
   public static void method643() {
      StructComposition.StructDefinition_cached.clear();
   }

   @ObfuscatedName("ml")
   @ObfuscatedSignature(
      descriptor = "(II)V",
      garbageValue = "1784154993"
   )
   static void method645(int var0) {
      Client.oculusOrbState = var0;
   }
}
