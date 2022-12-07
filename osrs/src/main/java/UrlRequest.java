import java.net.URL;

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dm")
public class UrlRequest {
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      descriptor = "Lfz;"
   )
   static Clock clock;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -59160263
   )
   static int loginBoxCenter;
   @ObfuscatedName("h")
   final URL url;
   @ObfuscatedName("e")
   volatile boolean isDone0;
   @ObfuscatedName("v")
   volatile byte[] response0;

   UrlRequest(URL var1) {
      this.url = var1;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(I)Z",
      garbageValue = "-1999146756"
   )
   public boolean isDone() {
      return this.isDone0;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "(I)[B",
      garbageValue = "-1235886388"
   )
   public byte[] getResponse() {
      return this.response0;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "(I)Ljava/lang/String;",
      garbageValue = "65026205"
   )
   public String method2788() {
      return this.url.toString();
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(B)[Lrv;",
      garbageValue = "-97"
   )
   public static FillMode[] FillMode_values() {
      return new FillMode[]{FillMode.field4997, FillMode.SOLID, FillMode.field4998};
   }
}
