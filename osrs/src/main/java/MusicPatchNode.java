import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kv")
@Implements("MusicPatchNode")
public class MusicPatchNode extends Node {
   @ObfuscatedName("ee")
   @ObfuscatedSignature(
      descriptor = "Llm;"
   )
   static Archive field2782;
   @ObfuscatedName("fz")
   static String field2783;
   @ObfuscatedName("f")
   int field2771;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      descriptor = "Lkq;"
   )
   MusicPatchNode2 field2764;
    @ObfuscatedName("v")
    @ObfuscatedSignature(
            descriptor = "Lkk;"
    )
    MusicPatch patch;
    @ObfuscatedName("s")
    @ObfuscatedSignature(
            descriptor = "Lav;"
    )
    RawSound rawSound;
   @ObfuscatedName("z")
   int field2765;
   @ObfuscatedName("j")
   int field2766;
   @ObfuscatedName("i")
   int field2767;
   @ObfuscatedName("n")
   int field2768;
   @ObfuscatedName("l")
   int field2769;
   @ObfuscatedName("k")
   int field2763;
   @ObfuscatedName("c")
   int field2774;
   @ObfuscatedName("r")
   int field2772;
   @ObfuscatedName("b")
   int field2773;
   @ObfuscatedName("m")
   int field2777;
   @ObfuscatedName("t")
   int field2775;
   @ObfuscatedName("h")
   int field2761;
   @ObfuscatedName("p")
   int field2776;
   @ObfuscatedName("o")
   int field2778;
    @ObfuscatedName("u")
    @ObfuscatedSignature(
            descriptor = "Lab;"
    )
    RawPcmStream stream;
   @ObfuscatedName("x")
   int field2780;
   @ObfuscatedName("q")
   int field2781;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "42680220"
   )
   void method1620() {
      this.patch = null;
      this.rawSound = null;
      this.field2764 = null;
      this.stream = null;
   }
}
