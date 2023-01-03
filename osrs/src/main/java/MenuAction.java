import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bs")
@Implements("MenuAction")
public class MenuAction {
   @ObfuscatedName("o")
   static int[] field720;
   @ObfuscatedName("h")
   @Export("param0")
   int param0;
   @ObfuscatedName("e")
   @Export("param1")
   int param1;
   @ObfuscatedName("v")
   @Export("opcode")
   int opcode;
   @ObfuscatedName("x")
   @Export("identifier")
   int identifier;
   @ObfuscatedName("m")
   @Export("itemId")
   int itemId;
   @ObfuscatedName("q")
   @Export("action")
   String action;
   @ObfuscatedName("f")
   @Export("target")
   String target;
}
