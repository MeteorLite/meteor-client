import java.util.ArrayList;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bg")
@Implements("Interpreter")
public class Interpreter {
    @ObfuscatedName("s")
    static int[] Interpreter_intLocals;
    @ObfuscatedName("j")
    static int[] Interpreter_arrayLengths = new int[5];
    @ObfuscatedName("i")
    static int[][] Interpreter_arrays = new int[5][5000];
    @ObfuscatedName("n")
    static int[] Interpreter_intStack = new int[1000];
    @ObfuscatedName("k")
    static String[] Interpreter_stringStack = new String[1000];
    @ObfuscatedName("r")
    static int Interpreter_frameDepth = 0;
    @ObfuscatedName("b")
    @ObfuscatedSignature(
            descriptor = "[Lbl;"
    )
    static ScriptFrame[] Interpreter_frames = new ScriptFrame[50];
    @ObfuscatedName("t")
    @ObfuscatedSignature(
            descriptor = "Lkz;"
    )
    static Widget scriptDotWidget;
    @ObfuscatedName("u")
    static java.util.Calendar Interpreter_calendar = java.util.Calendar.getInstance();
    @ObfuscatedName("x")
    static final String[] Interpreter_MONTHS = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
   @ObfuscatedName("q")
   static boolean field705 = false;
   @ObfuscatedName("d")
   static boolean field715 = false;
   @ObfuscatedName("e")
   static ArrayList field714 = new ArrayList();
   @ObfuscatedName("g")
   static int field712 = 0;
   @ObfuscatedName("ai")
   static final double field713 = Math.log(2.0D);
}
