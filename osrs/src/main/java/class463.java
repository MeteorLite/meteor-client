import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("qn")
public class class463 implements class349 {
    @ObfuscatedName("sy")
    @ObfuscatedSignature(
            descriptor = "Lon;"
    )
    static FriendsChat friendsChat;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "Lqn;"
   )
   public static final class463 field3979 = new class463(2, 0, Integer.class, new class460());
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      descriptor = "Lqn;"
   )
   public static final class463 field3980 = new class463(0, 1, Long.class, new class462());
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "Lqn;"
   )
   public static final class463 field3985 = new class463(1, 2, String.class, new class464());
    @ObfuscatedName("b")
    static int[] Tiles_hueMultiplier;
   @ObfuscatedName("s")
   public final int field3981;
   @ObfuscatedName("z")
   public final int field3978;
   @ObfuscatedName("j")
   public final Class field3983;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      descriptor = "Lqk;"
   )
   public final class459 field3982;

   @ObfuscatedSignature(
      descriptor = "(IILjava/lang/Class;Lqk;)V"
   )
   class463(int var1, int var2, Class var3, class459 var4) {
      this.field3981 = var1;
      this.field3978 = var2;
      this.field3983 = var3;
      this.field3982 = var4;
   }

    @ObfuscatedName("f")
    @ObfuscatedSignature(
            descriptor = "(B)I",
            garbageValue = "3"
    )
    public int rsOrdinal() {
      return this.field3978;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      descriptor = "(Lrd;I)Ljava/lang/Object;",
      garbageValue = "-648341479"
   )
   public Object method2339(Buffer var1) {
      return this.field3982.vmethod8273(var1);
   }

    @ObfuscatedName("f")
    @ObfuscatedSignature(
            descriptor = "(IS)Lgp;",
            garbageValue = "12707"
    )
    public static ObjectComposition getObjectDefinition(int var0) {
      ObjectComposition var1 = (ObjectComposition)ObjectComposition.ObjectDefinition_cached.get((long)var0);
      if (var1 != null) {
         return var1;
      } else {
         byte[] var2 = ObjectComposition.ObjectDefinition_archive.takeFile(6, var0);
         var1 = new ObjectComposition();
         var1.id = var0;
         if (var2 != null) {
            var1.decode(new Buffer(var2));
         }

         var1.postDecode();
         if (var1.isSolid) {
            var1.interactType = 0;
            var1.boolean1 = false;
         }

         ObjectComposition.ObjectDefinition_cached.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "(S)[Lqn;",
      garbageValue = "-13650"
   )
   public static class463[] method2337() {
      return new class463[]{field3985, field3979, field3980};
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/Class;B)Lqn;",
      garbageValue = "70"
   )
   public static class463 method2341(Class var0) {
      class463[] var1 = method2337();

      for(int var2 = 0; var2 < var1.length; ++var2) {
         class463 var3 = var1[var2];
         if (var3.field3983 == var0) {
            return var3;
         }
      }

      return null;
   }

   @ObfuscatedName("ka")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "1891218900"
   )
   static final int method2340() {
      float var0 = 200.0F * ((float)PacketWriter.clientPreferences.getBrightness() - 0.5F);
      return 100 - Math.round(var0);
   }
}
