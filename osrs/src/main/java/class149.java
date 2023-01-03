import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eg")
public class class149 extends class152 {
   @ObfuscatedName("h")
   int field1363;
   @ObfuscatedName("e")
   byte field1362;
   @ObfuscatedName("v")
   int field1364;
   @ObfuscatedName("x")
   String field1365;
   // $FF: synthetic field
   @ObfuscatedSignature(
      descriptor = "Led;"
   )
   final class153 this$0;

   @ObfuscatedSignature(
      descriptor = "(Led;)V"
   )
   class149(class153 var1) {
      this.this$0 = var1;
      this.field1363 = -1;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(Lqy;I)V",
      garbageValue = "468341515"
   )
   @Export("vmethod3238")
   void vmethod3238(Buffer var1) {
      var1.readUnsignedByte();
      this.field1363 = var1.readUnsignedShort();
      this.field1362 = var1.readByte();
      this.field1364 = var1.readUnsignedShort();
      var1.readLong();
      this.field1365 = var1.readStringCp1252NullTerminated();
      var1.readUnsignedByte();
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "(Lfn;I)V",
      garbageValue = "1227548281"
   )
   @Export("vmethod3239")
   void vmethod3239(ClanChannel var1) {
      ClanChannelMember var2 = (ClanChannelMember)var1.members.get(this.field1363);
      var2.rank = this.field1362;
      var2.world = this.field1364;
      var2.username = new Username(this.field1365);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(I)[Llq;",
      garbageValue = "-1628551002"
   )
   @Export("PlayerType_values")
   public static PlayerType[] PlayerType_values() {
      return new PlayerType[]{PlayerType.PlayerType_hardcoreIronman, PlayerType.field3416, PlayerType.PlayerType_ironman, PlayerType.field3410, PlayerType.field3422, PlayerType.PlayerType_jagexModerator, PlayerType.field3418, PlayerType.field3417, PlayerType.PlayerType_normal, PlayerType.field3414, PlayerType.field3406, PlayerType.field3415, PlayerType.PlayerType_playerModerator, PlayerType.PlayerType_ultimateIronman, PlayerType.field3419, PlayerType.field3420, PlayerType.field3421};
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "(II)Lgv;",
      garbageValue = "-640568434"
   )
   @Export("getParamDefinition")
   public static ParamComposition getParamDefinition(int var0) {
      ParamComposition var1 = (ParamComposition)ParamComposition.ParamDefinition_cached.get((long)var0);
      if (var1 != null) {
         return var1;
      } else {
         byte[] var2 = ParamComposition.ParamDefinition_archive.takeFile(11, var0);
         var1 = new ParamComposition();
         if (var2 != null) {
            var1.decode(new Buffer(var2));
         }

         var1.postDecode();
         ParamComposition.ParamDefinition_cached.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "2"
   )
   public static void method806() {
      SpotAnimationDefinition.SpotAnimationDefinition_cached.clear();
      SpotAnimationDefinition.SpotAnimationDefinition_cachedModels.clear();
   }
}
