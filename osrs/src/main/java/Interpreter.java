import java.util.ArrayList;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cy")
@Implements("Interpreter")
public class Interpreter {
    @ObfuscatedName("ac")
    static int[] Interpreter_intLocals;
    @ObfuscatedName("au")
    static String[] Interpreter_stringLocals;
    @ObfuscatedName("ab")
    static int[] Interpreter_arrayLengths = new int[5];
    @ObfuscatedName("aq")
    static int[][] Interpreter_arrays = new int[5][5000];
    @ObfuscatedName("al")
    static int[] Interpreter_intStack = new int[1000];
    @ObfuscatedName("at")
    static int Interpreter_intStackSize;
    @ObfuscatedName("aa")
    static String[] Interpreter_stringStack = new String[1000];
    @ObfuscatedName("ao")
    static int Interpreter_frameDepth = 0;
    @ObfuscatedName("ax")
    @ObfuscatedSignature(
            descriptor = "[Lck;"
    )
    static ScriptFrame[] Interpreter_frames = new ScriptFrame[50];
    @ObfuscatedName("am")
    static java.util.Calendar Interpreter_calendar = java.util.Calendar.getInstance();
    @ObfuscatedName("as")
    static final String[] Interpreter_MONTHS = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
   @ObfuscatedName("ak")
   static boolean field700 = false;
   @ObfuscatedName("az")
   static boolean field704 = false;
   @ObfuscatedName("ad")
   static ArrayList field690 = new ArrayList();
   @ObfuscatedName("ae")
   static int field703 = 0;
   @ObfuscatedName("bi")
   static final double field702 = Math.log(2.0D);

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      descriptor = "(Lnm;Lnm;ZB)V",
      garbageValue = "3"
   )
   public static void method427(AbstractArchive var0, AbstractArchive var1, boolean var2) {
      ObjectComposition.ObjectDefinition_archive = var0;
      class157.ObjectDefinition_modelsArchive = var1;
      ObjectComposition.ObjectDefinition_isLowDetail = var2;
   }

    @ObfuscatedName("al")
    @ObfuscatedSignature(
            descriptor = "(I)Lcl;",
            garbageValue = "1711407599"
    )
    static World getNextWorldListWorld() {
      return World.World_listCount < World.World_count ? class31.World_worlds[++World.World_listCount - 1] : null;
   }
}
