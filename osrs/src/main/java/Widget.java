import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kw")
@Implements("Widget")
public class Widget extends Node {
	@ObfuscatedName("r")
	@ObfuscatedSignature(
		descriptor = "Llv;"
	)
	@Export("Widget_spritesArchive")
	public static AbstractArchive Widget_spritesArchive;
	@ObfuscatedName("o")
	@ObfuscatedSignature(
		descriptor = "Lif;"
	)
	@Export("Widget_cachedSprites")
	static EvictingDualNodeHashTable Widget_cachedSprites;
	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "Lif;"
	)
	@Export("Widget_cachedModels")
	static EvictingDualNodeHashTable Widget_cachedModels;
	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "Lif;"
	)
	@Export("Widget_cachedFonts")
	static EvictingDualNodeHashTable Widget_cachedFonts;
	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "Lif;"
	)
	@Export("Widget_cachedSpriteMasks")
	static EvictingDualNodeHashTable Widget_cachedSpriteMasks;
	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "Lmk;"
	)
	static class363 field3390;
	@ObfuscatedName("aq")
	@ObfuscatedSignature(
		descriptor = "Lmk;"
	)
	static class363 field3391;
	@ObfuscatedName("ai")
	public static boolean field3392;
	@ObfuscatedName("an")
	@Export("isIf3")
	public boolean isIf3;
	@ObfuscatedName("aa")
	@ObfuscatedGetter(
		intValue = -872148407
	)
	@Export("id")
	public int id;
	@ObfuscatedName("ak")
	@ObfuscatedGetter(
		intValue = -1302105045
	)
	@Export("childIndex")
	public int childIndex;
	@ObfuscatedName("am")
	@ObfuscatedGetter(
		intValue = -1424425987
	)
	@Export("type")
	public int type;
	@ObfuscatedName("ap")
	@ObfuscatedGetter(
		intValue = -1079768261
	)
	@Export("buttonType")
	public int buttonType;
	@ObfuscatedName("ab")
	@ObfuscatedGetter(
		intValue = -385248607
	)
	@Export("contentType")
	public int contentType;
	@ObfuscatedName("az")
	@ObfuscatedGetter(
		intValue = 76832509
	)
	@Export("xAlignment")
	public int xAlignment;
	@ObfuscatedName("ad")
	@ObfuscatedGetter(
		intValue = -336749999
	)
	@Export("yAlignment")
	public int yAlignment;
	@ObfuscatedName("af")
	@ObfuscatedGetter(
		intValue = -6042807
	)
	@Export("widthAlignment")
	public int widthAlignment;
	@ObfuscatedName("aj")
	@ObfuscatedGetter(
		intValue = 748787069
	)
	@Export("heightAlignment")
	public int heightAlignment;
	@ObfuscatedName("ax")
	@ObfuscatedGetter(
		intValue = 1340832997
	)
	@Export("rawX")
	public int rawX;
	@ObfuscatedName("av")
	@ObfuscatedGetter(
		intValue = -224630227
	)
	@Export("rawY")
	public int rawY;
	@ObfuscatedName("ae")
	@ObfuscatedGetter(
		intValue = 1316945297
	)
	@Export("rawWidth")
	public int rawWidth;
	@ObfuscatedName("ay")
	@ObfuscatedGetter(
		intValue = -1864685279
	)
	@Export("rawHeight")
	public int rawHeight;
	@ObfuscatedName("ag")
	@ObfuscatedGetter(
		intValue = 1848689675
	)
	@Export("x")
	public int x;
	@ObfuscatedName("aw")
	@ObfuscatedGetter(
		intValue = -1870214605
	)
	@Export("y")
	public int y;
	@ObfuscatedName("ah")
	@ObfuscatedGetter(
		intValue = 1859270101
	)
	@Export("width")
	public int width;
	@ObfuscatedName("at")
	@ObfuscatedGetter(
		intValue = -1842398077
	)
	@Export("height")
	public int height;
	@ObfuscatedName("al")
	@ObfuscatedGetter(
		intValue = -1203830783
	)
	public int field3411;
	@ObfuscatedName("au")
	@ObfuscatedGetter(
		intValue = -335581981
	)
	public int field3412;
	@ObfuscatedName("bg")
	@ObfuscatedGetter(
		intValue = -907421573
	)
	@Export("parentId")
	public int parentId;
	@ObfuscatedName("bw")
	@Export("isHidden")
	public boolean isHidden;
	@ObfuscatedName("bc")
	@ObfuscatedGetter(
		intValue = 351052235
	)
	@Export("scrollX")
	public int scrollX;
	@ObfuscatedName("bv")
	@ObfuscatedGetter(
		intValue = -1379340147
	)
	@Export("scrollY")
	public int scrollY;
	@ObfuscatedName("bi")
	@ObfuscatedGetter(
		intValue = 1613861837
	)
	@Export("scrollWidth")
	public int scrollWidth;
	@ObfuscatedName("bj")
	@ObfuscatedGetter(
		intValue = 1133487529
	)
	@Export("scrollHeight")
	public int scrollHeight;
	@ObfuscatedName("by")
	@ObfuscatedGetter(
		intValue = -514145177
	)
	@Export("color")
	public int color;
	@ObfuscatedName("bz")
	@ObfuscatedGetter(
		intValue = 1152174539
	)
	@Export("color2")
	public int color2;
	@ObfuscatedName("bo")
	@ObfuscatedGetter(
		intValue = 1678515983
	)
	@Export("mouseOverColor")
	public int mouseOverColor;
	@ObfuscatedName("br")
	@ObfuscatedGetter(
		intValue = 1533963941
	)
	@Export("mouseOverColor2")
	public int mouseOverColor2;
	@ObfuscatedName("bp")
	@Export("fill")
	public boolean fill;
	@ObfuscatedName("bd")
	@ObfuscatedSignature(
		descriptor = "Lqt;"
	)
	@Export("fillMode")
	public FillMode fillMode;
	@ObfuscatedName("bl")
	@ObfuscatedGetter(
		intValue = 1888244299
	)
	@Export("transparencyTop")
	public int transparencyTop;
	@ObfuscatedName("bk")
	@ObfuscatedGetter(
		intValue = -120044031
	)
	@Export("transparencyBot")
	public int transparencyBot;
	@ObfuscatedName("bh")
	@ObfuscatedGetter(
		intValue = -774766751
	)
	@Export("lineWid")
	public int lineWid;
	@ObfuscatedName("bx")
	public boolean field3434;
	@ObfuscatedName("be")
	@ObfuscatedGetter(
		intValue = -549762913
	)
	@Export("spriteId2")
	public int spriteId2;
	@ObfuscatedName("bf")
	@ObfuscatedGetter(
		intValue = -593850039
	)
	@Export("spriteId")
	public int spriteId;
	@ObfuscatedName("ba")
	public String field3542;
	@ObfuscatedName("bt")
	@ObfuscatedGetter(
		intValue = 1360508359
	)
	@Export("spriteAngle")
	public int spriteAngle;
	@ObfuscatedName("bb")
	@Export("spriteTiling")
	public boolean spriteTiling;
	@ObfuscatedName("bn")
	@ObfuscatedGetter(
		intValue = -713045717
	)
	@Export("outline")
	public int outline;
	@ObfuscatedName("bm")
	@ObfuscatedGetter(
		intValue = 309573565
	)
	@Export("spriteShadow")
	public int spriteShadow;
	@ObfuscatedName("bq")
	@Export("spriteFlipV")
	public boolean spriteFlipV;
	@ObfuscatedName("bu")
	@Export("spriteFlipH")
	public boolean spriteFlipH;
	@ObfuscatedName("bs")
	@ObfuscatedGetter(
		intValue = -1625304481
	)
	@Export("modelType")
	public int modelType;
	@ObfuscatedName("cy")
	@ObfuscatedGetter(
		intValue = 1472154217
	)
	@Export("modelId")
	public int modelId;
	@ObfuscatedName("cv")
	@ObfuscatedGetter(
		intValue = -1266121497
	)
	@Export("modelType2")
	int modelType2;
	@ObfuscatedName("cf")
	@ObfuscatedGetter(
		intValue = -1660554345
	)
	@Export("modelId2")
	int modelId2;
	@ObfuscatedName("cn")
	@ObfuscatedGetter(
		intValue = 1441681381
	)
	@Export("sequenceId")
	public int sequenceId;
	@ObfuscatedName("ct")
	@ObfuscatedGetter(
		intValue = -1396837651
	)
	@Export("sequenceId2")
	public int sequenceId2;
	@ObfuscatedName("cj")
	@ObfuscatedGetter(
		intValue = 180404177
	)
	@Export("modelOffsetX")
	public int modelOffsetX;
	@ObfuscatedName("cl")
	@ObfuscatedGetter(
		intValue = -1481933279
	)
	@Export("modelOffsetY")
	public int modelOffsetY;
	@ObfuscatedName("cw")
	@ObfuscatedGetter(
		intValue = -273944037
	)
	@Export("modelAngleX")
	public int modelAngleX;
	@ObfuscatedName("ce")
	@ObfuscatedGetter(
		intValue = 1761894939
	)
	@Export("modelAngleY")
	public int modelAngleY;
	@ObfuscatedName("cg")
	@ObfuscatedGetter(
		intValue = -690957751
	)
	@Export("modelAngleZ")
	public int modelAngleZ;
	@ObfuscatedName("cu")
	@ObfuscatedGetter(
		intValue = -1283273139
	)
	@Export("modelZoom")
	public int modelZoom;
	@ObfuscatedName("cz")
	@ObfuscatedGetter(
		intValue = 960101041
	)
	public int field3446;
	@ObfuscatedName("cr")
	@ObfuscatedGetter(
		intValue = -188016529
	)
	public int field3451;
	@ObfuscatedName("co")
	@Export("modelOrthog")
	public boolean modelOrthog;
	@ObfuscatedName("ca")
	@Export("modelTransparency")
	public boolean modelTransparency;
	@ObfuscatedName("cx")
	@ObfuscatedGetter(
		intValue = 1142237273
	)
	@Export("itemQuantityMode")
	public int itemQuantityMode;
	@ObfuscatedName("cq")
	@ObfuscatedGetter(
		intValue = -1783725171
	)
	@Export("fontId")
	public int fontId;
	@ObfuscatedName("cp")
	@Export("text")
	public String text;
	@ObfuscatedName("ck")
	@Export("text2")
	public String text2;
	@ObfuscatedName("ci")
	@ObfuscatedGetter(
		intValue = -1637572651
	)
	@Export("textLineHeight")
	public int textLineHeight;
	@ObfuscatedName("cb")
	@ObfuscatedGetter(
		intValue = -1303153635
	)
	@Export("textXAlignment")
	public int textXAlignment;
	@ObfuscatedName("cd")
	@ObfuscatedGetter(
		intValue = 1821739889
	)
	@Export("textYAlignment")
	public int textYAlignment;
	@ObfuscatedName("cs")
	@Export("textShadowed")
	public boolean textShadowed;
	@ObfuscatedName("ch")
	@ObfuscatedGetter(
		intValue = 1609810309
	)
	@Export("paddingX")
	public int paddingX;
	@ObfuscatedName("cc")
	@ObfuscatedGetter(
		intValue = -929653633
	)
	@Export("paddingY")
	public int paddingY;
	@ObfuscatedName("cm")
	@Export("inventoryXOffsets")
	public int[] inventoryXOffsets;
	@ObfuscatedName("db")
	@Export("inventoryYOffsets")
	public int[] inventoryYOffsets;
	@ObfuscatedName("df")
	@Export("inventorySprites")
	public int[] inventorySprites;
	@ObfuscatedName("du")
	@Export("itemActions")
	public String[] itemActions;
	@ObfuscatedName("da")
	@ObfuscatedSignature(
		descriptor = "Lfc;"
	)
	class156 field3468;
	@ObfuscatedName("dp")
	@ObfuscatedGetter(
		intValue = -2000944087
	)
	int field3469;
	@ObfuscatedName("dr")
	HashMap field3474;
	@ObfuscatedName("dq")
	HashMap field3471;
	@ObfuscatedName("do")
	@ObfuscatedGetter(
		intValue = 1869794395
	)
	@Export("flags")
	public int flags;
	@ObfuscatedName("dg")
	public boolean field3395;
	@ObfuscatedName("dz")
	public byte[][] field3464;
	@ObfuscatedName("dx")
	public byte[][] field3475;
	@ObfuscatedName("dj")
	public int[] field3417;
	@ObfuscatedName("dk")
	public int[] field3477;
	@ObfuscatedName("dn")
	@Export("dataText")
	public String dataText;
	@ObfuscatedName("dy")
	@Export("actions")
	public String[] actions;
	@ObfuscatedName("dc")
	@ObfuscatedSignature(
		descriptor = "Lkw;"
	)
	@Export("parent")
	public Widget parent;
	@ObfuscatedName("dh")
	@ObfuscatedGetter(
		intValue = 1881898887
	)
	@Export("dragZoneSize")
	public int dragZoneSize;
	@ObfuscatedName("dm")
	@ObfuscatedGetter(
		intValue = 681403879
	)
	@Export("dragThreshold")
	public int dragThreshold;
	@ObfuscatedName("dd")
	@Export("isScrollBar")
	public boolean isScrollBar;
	@ObfuscatedName("de")
	@Export("spellActionName")
	public String spellActionName;
	@ObfuscatedName("ds")
	@Export("hasListener")
	public boolean hasListener;
	@ObfuscatedName("ee")
	@Export("onLoad")
	public Object[] onLoad;
	@ObfuscatedName("ea")
	@Export("onClick")
	public Object[] onClick;
	@ObfuscatedName("eo")
	@Export("onClickRepeat")
	public Object[] onClickRepeat;
	@ObfuscatedName("ei")
	@Export("onRelease")
	public Object[] onRelease;
	@ObfuscatedName("ek")
	@Export("onHold")
	public Object[] onHold;
	@ObfuscatedName("es")
	@Export("onMouseOver")
	public Object[] onMouseOver;
	@ObfuscatedName("ep")
	@Export("onMouseRepeat")
	public Object[] onMouseRepeat;
	@ObfuscatedName("ez")
	@Export("onMouseLeave")
	public Object[] onMouseLeave;
	@ObfuscatedName("ex")
	@Export("onDrag")
	public Object[] onDrag;
	@ObfuscatedName("eg")
	@Export("onDragComplete")
	public Object[] onDragComplete;
	@ObfuscatedName("ed")
	@Export("onTargetEnter")
	public Object[] onTargetEnter;
	@ObfuscatedName("ey")
	@Export("onTargetLeave")
	public Object[] onTargetLeave;
	@ObfuscatedName("eu")
	@Export("onVarTransmit")
	public Object[] onVarTransmit;
	@ObfuscatedName("eb")
	@Export("varTransmitTriggers")
	public int[] varTransmitTriggers;
	@ObfuscatedName("en")
	@Export("onInvTransmit")
	public Object[] onInvTransmit;
	@ObfuscatedName("ej")
	@Export("invTransmitTriggers")
	public int[] invTransmitTriggers;
	@ObfuscatedName("em")
	@Export("onStatTransmit")
	public Object[] onStatTransmit;
	@ObfuscatedName("ef")
	@Export("statTransmitTriggers")
	public int[] statTransmitTriggers;
	@ObfuscatedName("et")
	@Export("onTimer")
	public Object[] onTimer;
	@ObfuscatedName("er")
	@Export("onOp")
	public Object[] onOp;
	@ObfuscatedName("eq")
	public Object[] field3506;
	@ObfuscatedName("ec")
	@Export("onScroll")
	public Object[] onScroll;
	@ObfuscatedName("ew")
	@Export("onChatTransmit")
	public Object[] onChatTransmit;
	@ObfuscatedName("ev")
	@Export("onKey")
	public Object[] onKey;
	@ObfuscatedName("el")
	public Object[] field3528;
	@ObfuscatedName("eh")
	public Object[] field3511;
	@ObfuscatedName("fc")
	@Export("onFriendTransmit")
	public Object[] onFriendTransmit;
	@ObfuscatedName("fr")
	@Export("onClanTransmit")
	public Object[] onClanTransmit;
	@ObfuscatedName("fg")
	public Object[] field3526;
	@ObfuscatedName("fv")
	public Object[] field3431;
	@ObfuscatedName("fm")
	@Export("onMiscTransmit")
	public Object[] onMiscTransmit;
	@ObfuscatedName("fl")
	@Export("onDialogAbort")
	public Object[] onDialogAbort;
	@ObfuscatedName("fn")
	@Export("onSubChange")
	public Object[] onSubChange;
	@ObfuscatedName("fp")
	@Export("onResize")
	public Object[] onResize;
	@ObfuscatedName("fj")
	@Export("onStockTransmit")
	public Object[] onStockTransmit;
	@ObfuscatedName("fk")
	public Object[] field3452;
	@ObfuscatedName("ff")
	public Object[] field3522;
	@ObfuscatedName("fx")
	@Export("cs1Instructions")
	public int[][] cs1Instructions;
	@ObfuscatedName("fi")
	@Export("cs1Comparisons")
	public int[] cs1Comparisons;
	@ObfuscatedName("fq")
	@Export("cs1ComparisonValues")
	public int[] cs1ComparisonValues;
	@ObfuscatedName("fo")
	@ObfuscatedGetter(
		intValue = -520101461
	)
	@Export("mouseOverRedirect")
	public int mouseOverRedirect;
	@ObfuscatedName("fh")
	@Export("spellName")
	public String spellName;
	@ObfuscatedName("fb")
	@Export("buttonText")
	public String buttonText;
	@ObfuscatedName("fa")
	@Export("itemIds")
	public int[] itemIds;
	@ObfuscatedName("fd")
	@Export("itemQuantities")
	public int[] itemQuantities;
	@ObfuscatedName("fu")
	@ObfuscatedGetter(
		intValue = -1521175997
	)
	@Export("itemId")
	public int itemId;
	@ObfuscatedName("fe")
	@ObfuscatedGetter(
		intValue = -331325251
	)
	@Export("itemQuantity")
	public int itemQuantity;
	@ObfuscatedName("fy")
	@ObfuscatedGetter(
		intValue = -80689241
	)
	@Export("modelFrame")
	public int modelFrame;
	@ObfuscatedName("fs")
	@ObfuscatedGetter(
		intValue = -2013275675
	)
	@Export("modelFrameCycle")
	public int modelFrameCycle;
	@ObfuscatedName("fw")
	@ObfuscatedSignature(
		descriptor = "[Lkw;"
	)
	@Export("children")
	public Widget[] children;
	@ObfuscatedName("ft")
	@Export("containsMouse")
	public boolean containsMouse;
	@ObfuscatedName("fz")
	@Export("isClicked")
	public boolean isClicked;
	@ObfuscatedName("gq")
	@ObfuscatedGetter(
		intValue = 344012705
	)
	public int field3538;
	@ObfuscatedName("gv")
	@ObfuscatedGetter(
		intValue = -347947965
	)
	public int field3539;
	@ObfuscatedName("gr")
	@ObfuscatedGetter(
		intValue = 797537099
	)
	public int field3540;
	@ObfuscatedName("gl")
	@ObfuscatedGetter(
		intValue = 252070443
	)
	public int field3541;
	@ObfuscatedName("gx")
	@ObfuscatedGetter(
		intValue = -6211289
	)
	@Export("rootIndex")
	public int rootIndex;
	@ObfuscatedName("gz")
	@ObfuscatedGetter(
		intValue = 2017099089
	)
	@Export("cycle")
	public int cycle;
	@ObfuscatedName("gk")
	public int[] field3544;
	@ObfuscatedName("gw")
	@Export("noClickThrough")
	public boolean noClickThrough;
	@ObfuscatedName("gd")
	@Export("noScrollThrough")
	public boolean noScrollThrough;
	@ObfuscatedName("gj")
	@Export("prioritizeMenuEntry")
	public boolean prioritizeMenuEntry;

	static {
		Widget_cachedSprites = new EvictingDualNodeHashTable(200);
		Widget_cachedModels = new EvictingDualNodeHashTable(50);
		Widget_cachedFonts = new EvictingDualNodeHashTable(20);
		Widget_cachedSpriteMasks = new EvictingDualNodeHashTable(8);
		field3390 = new class363(10, class361.field4300);
		field3391 = new class363(10, class361.field4300);
		field3392 = false;
	}

	public Widget() {
		this.isIf3 = false;
		this.id = -1;
		this.childIndex = -1;
		this.buttonType = 0;
		this.contentType = 0;
		this.xAlignment = 0;
		this.yAlignment = 0;
		this.widthAlignment = 0;
		this.heightAlignment = 0;
		this.rawX = 0;
		this.rawY = 0;
		this.rawWidth = 0;
		this.rawHeight = 0;
		this.x = 0;
		this.y = 0;
		this.width = 0;
		this.height = 0;
		this.field3411 = 1;
		this.field3412 = 1;
		this.parentId = -1;
		this.isHidden = false;
		this.scrollX = 0;
		this.scrollY = 0;
		this.scrollWidth = 0;
		this.scrollHeight = 0;
		this.color = 0;
		this.color2 = 0;
		this.mouseOverColor = 0;
		this.mouseOverColor2 = 0;
		this.fill = false;
		this.fillMode = FillMode.SOLID;
		this.transparencyTop = 0;
		this.transparencyBot = 0;
		this.lineWid = 1;
		this.field3434 = false;
		this.spriteId2 = -1;
		this.spriteId = -1;
		this.spriteAngle = 0;
		this.spriteTiling = false;
		this.outline = 0;
		this.spriteShadow = 0;
		this.modelType = 1;
		this.modelId = -1;
		this.modelType2 = 1;
		this.modelId2 = -1;
		this.sequenceId = -1;
		this.sequenceId2 = -1;
		this.modelOffsetX = 0;
		this.modelOffsetY = 0;
		this.modelAngleX = 0;
		this.modelAngleY = 0;
		this.modelAngleZ = 0;
		this.modelZoom = 100;
		this.field3446 = 0;
		this.field3451 = 0;
		this.modelOrthog = false;
		this.modelTransparency = false;
		this.itemQuantityMode = 2;
		this.fontId = -1;
		this.text = "";
		this.text2 = "";
		this.textLineHeight = 0;
		this.textXAlignment = 0;
		this.textYAlignment = 0;
		this.textShadowed = false;
		this.paddingX = 0;
		this.paddingY = 0;
		this.field3469 = -1;
		this.flags = 0;
		this.field3395 = false;
		this.dataText = "";
		this.parent = null;
		this.dragZoneSize = 0;
		this.dragThreshold = 0;
		this.isScrollBar = false;
		this.spellActionName = "";
		this.hasListener = false;
		this.mouseOverRedirect = -1;
		this.spellName = "";
		this.buttonText = "Ok";
		this.itemId = -1;
		this.itemQuantity = 0;
		this.modelFrame = 0;
		this.modelFrameCycle = 0;
		this.containsMouse = false;
		this.isClicked = false;
		this.field3538 = -1;
		this.field3539 = 0;
		this.field3540 = 0;
		this.field3541 = 0;
		this.rootIndex = -1;
		this.cycle = -1;
		this.noClickThrough = false;
		this.noScrollThrough = false;
		this.prioritizeMenuEntry = false;
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		descriptor = "(Lqq;I)V",
		garbageValue = "-2096660554"
	)
	@Export("decodeLegacy")
	void decodeLegacy(Buffer var1) {
		this.isIf3 = false;
		this.type = var1.readUnsignedByte();
		this.buttonType = var1.readUnsignedByte();
		this.contentType = var1.readUnsignedShort();
		this.rawX = var1.readShort();
		this.rawY = var1.readShort();
		this.rawWidth = var1.readUnsignedShort();
		this.rawHeight = var1.readUnsignedShort();
		this.transparencyTop = var1.readUnsignedByte();
		this.parentId = var1.readUnsignedShort();
		if (this.parentId == 65535) {
			this.parentId = -1;
		} else {
			this.parentId += this.id & -65536;
		}

		this.mouseOverRedirect = var1.readUnsignedShort();
		if (this.mouseOverRedirect == 65535) {
			this.mouseOverRedirect = -1;
		}

		int var2 = var1.readUnsignedByte();
		int var3;
		if (var2 > 0) {
			this.cs1Comparisons = new int[var2];
			this.cs1ComparisonValues = new int[var2];

			for (var3 = 0; var3 < var2; ++var3) {
				this.cs1Comparisons[var3] = var1.readUnsignedByte();
				this.cs1ComparisonValues[var3] = var1.readUnsignedShort();
			}
		}

		var3 = var1.readUnsignedByte();
		int var4;
		int var5;
		int var6;
		if (var3 > 0) {
			this.cs1Instructions = new int[var3][];

			for (var4 = 0; var4 < var3; ++var4) {
				var5 = var1.readUnsignedShort();
				this.cs1Instructions[var4] = new int[var5];

				for (var6 = 0; var6 < var5; ++var6) {
					this.cs1Instructions[var4][var6] = var1.readUnsignedShort();
					if (this.cs1Instructions[var4][var6] == 65535) {
						this.cs1Instructions[var4][var6] = -1;
					}
				}
			}
		}

		if (this.type == 0) {
			this.scrollHeight = var1.readUnsignedShort();
			this.isHidden = var1.readUnsignedByte() == 1;
		}

		if (this.type == 1) {
			var1.readUnsignedShort();
			var1.readUnsignedByte();
		}

		if (this.type == 2) {
			this.itemIds = new int[this.rawHeight * this.rawWidth];
			this.itemQuantities = new int[this.rawWidth * this.rawHeight];
			var4 = var1.readUnsignedByte();
			if (var4 == 1) {
				this.flags |= 268435456;
			}

			var5 = var1.readUnsignedByte();
			if (var5 == 1) {
				this.flags |= 1073741824;
			}

			var6 = var1.readUnsignedByte();
			if (var6 == 1) {
				this.flags |= Integer.MIN_VALUE;
			}

			int var7 = var1.readUnsignedByte();
			if (var7 == 1) {
				this.flags |= 536870912;
			}

			this.paddingX = var1.readUnsignedByte();
			this.paddingY = var1.readUnsignedByte();
			this.inventoryXOffsets = new int[20];
			this.inventoryYOffsets = new int[20];
			this.inventorySprites = new int[20];

			int var8;
			for (var8 = 0; var8 < 20; ++var8) {
				int var11 = var1.readUnsignedByte();
				if (var11 == 1) {
					this.inventoryXOffsets[var8] = var1.readShort();
					this.inventoryYOffsets[var8] = var1.readShort();
					this.inventorySprites[var8] = var1.readInt();
				} else {
					this.inventorySprites[var8] = -1;
				}
			}

			this.itemActions = new String[5];

			for (var8 = 0; var8 < 5; ++var8) {
				String var9 = var1.readStringCp1252NullTerminated();
				if (var9.length() > 0) {
					this.itemActions[var8] = var9;
					this.flags |= 1 << var8 + 23;
				}
			}
		}

		if (this.type == 3) {
			this.fill = var1.readUnsignedByte() == 1;
		}

		if (this.type == 4 || this.type == 1) {
			this.textXAlignment = var1.readUnsignedByte();
			this.textYAlignment = var1.readUnsignedByte();
			this.textLineHeight = var1.readUnsignedByte();
			this.fontId = var1.readUnsignedShort();
			if (this.fontId == 65535) {
				this.fontId = -1;
			}

			this.textShadowed = var1.readUnsignedByte() == 1;
		}

		if (this.type == 4) {
			this.text = var1.readStringCp1252NullTerminated();
			this.text2 = var1.readStringCp1252NullTerminated();
		}

		if (this.type == 1 || this.type == 3 || this.type == 4) {
			this.color = var1.readInt();
		}

		if (this.type == 3 || this.type == 4) {
			this.color2 = var1.readInt();
			this.mouseOverColor = var1.readInt();
			this.mouseOverColor2 = var1.readInt();
		}

		if (this.type == 5) {
			this.spriteId2 = var1.readInt();
			this.spriteId = var1.readInt();
		}

		if (this.type == 6) {
			this.modelType = 1;
			this.modelId = var1.readUnsignedShort();
			if (this.modelId == 65535) {
				this.modelId = -1;
			}

			this.modelType2 = 1;
			this.modelId2 = var1.readUnsignedShort();
			if (this.modelId2 == 65535) {
				this.modelId2 = -1;
			}

			this.sequenceId = var1.readUnsignedShort();
			if (this.sequenceId == 65535) {
				this.sequenceId = -1;
			}

			this.sequenceId2 = var1.readUnsignedShort();
			if (this.sequenceId2 == 65535) {
				this.sequenceId2 = -1;
			}

			this.modelZoom = var1.readUnsignedShort();
			this.modelAngleX = var1.readUnsignedShort();
			this.modelAngleY = var1.readUnsignedShort();
		}

		if (this.type == 7) {
			this.itemIds = new int[this.rawHeight * this.rawWidth];
			this.itemQuantities = new int[this.rawWidth * this.rawHeight];
			this.textXAlignment = var1.readUnsignedByte();
			this.fontId = var1.readUnsignedShort();
			if (this.fontId == 65535) {
				this.fontId = -1;
			}

			this.textShadowed = var1.readUnsignedByte() == 1;
			this.color = var1.readInt();
			this.paddingX = var1.readShort();
			this.paddingY = var1.readShort();
			var4 = var1.readUnsignedByte();
			if (var4 == 1) {
				this.flags |= 1073741824;
			}

			this.itemActions = new String[5];

			for (var5 = 0; var5 < 5; ++var5) {
				String var10 = var1.readStringCp1252NullTerminated();
				if (var10.length() > 0) {
					this.itemActions[var5] = var10;
					this.flags |= 1 << var5 + 23;
				}
			}
		}

		if (this.type == 8) {
			this.text = var1.readStringCp1252NullTerminated();
		}

		if (this.buttonType == 2 || this.type == 2) {
			this.spellActionName = var1.readStringCp1252NullTerminated();
			this.spellName = var1.readStringCp1252NullTerminated();
			var4 = var1.readUnsignedShort() & 63;
			this.flags |= var4 << 11;
		}

		if (this.buttonType == 1 || this.buttonType == 4 || this.buttonType == 5 || this.buttonType == 6) {
			this.buttonText = var1.readStringCp1252NullTerminated();
			if (this.buttonText.length() == 0) {
				if (this.buttonType == 1) {
					this.buttonText = "Ok";
				}

				if (this.buttonType == 4) {
					this.buttonText = "Select";
				}

				if (this.buttonType == 5) {
					this.buttonText = "Select";
				}

				if (this.buttonType == 6) {
					this.buttonText = "Continue";
				}
			}
		}

		if (this.buttonType == 1 || this.buttonType == 4 || this.buttonType == 5) {
			this.flags |= 4194304;
		}

		if (this.buttonType == 6) {
			this.flags |= 1;
		}

	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		descriptor = "(Lqq;I)V",
		garbageValue = "1665961094"
	)
	@Export("decode")
	void decode(Buffer var1) {
		var1.readUnsignedByte();
		this.isIf3 = true;
		this.type = var1.readUnsignedByte();
		this.contentType = var1.readUnsignedShort();
		this.rawX = var1.readShort();
		this.rawY = var1.readShort();
		this.rawWidth = var1.readUnsignedShort();
		if (this.type == 9) {
			this.rawHeight = var1.readShort();
		} else {
			this.rawHeight = var1.readUnsignedShort();
		}

		this.widthAlignment = var1.readByte();
		this.heightAlignment = var1.readByte();
		this.xAlignment = var1.readByte();
		this.yAlignment = var1.readByte();
		this.parentId = var1.readUnsignedShort();
		if (this.parentId == 65535) {
			this.parentId = -1;
		} else {
			this.parentId += this.id & -65536;
		}

		this.isHidden = var1.readUnsignedByte() == 1;
		if (this.type == 0) {
			this.scrollWidth = var1.readUnsignedShort();
			this.scrollHeight = var1.readUnsignedShort();
			this.noClickThrough = var1.readUnsignedByte() == 1;
		}

		if (this.type == 5) {
			this.spriteId2 = var1.readInt();
			this.spriteAngle = var1.readUnsignedShort();
			this.spriteTiling = var1.readUnsignedByte() == 1;
			this.transparencyTop = var1.readUnsignedByte();
			this.outline = var1.readUnsignedByte();
			this.spriteShadow = var1.readInt();
			this.spriteFlipV = var1.readUnsignedByte() == 1;
			this.spriteFlipH = var1.readUnsignedByte() == 1;
		}

		if (this.type == 6) {
			this.modelType = 1;
			this.modelId = var1.readUnsignedShort();
			if (this.modelId == 65535) {
				this.modelId = -1;
			}

			this.modelOffsetX = var1.readShort();
			this.modelOffsetY = var1.readShort();
			this.modelAngleX = var1.readUnsignedShort();
			this.modelAngleY = var1.readUnsignedShort();
			this.modelAngleZ = var1.readUnsignedShort();
			this.modelZoom = var1.readUnsignedShort();
			this.sequenceId = var1.readUnsignedShort();
			if (this.sequenceId == 65535) {
				this.sequenceId = -1;
			}

			this.modelOrthog = var1.readUnsignedByte() == 1;
			var1.readUnsignedShort();
			if (this.widthAlignment != 0) {
				this.field3446 = var1.readUnsignedShort();
			}

			if (this.heightAlignment != 0) {
				var1.readUnsignedShort();
			}
		}

		if (this.type == 4) {
			this.fontId = var1.readUnsignedShort();
			if (this.fontId == 65535) {
				this.fontId = -1;
			}

			this.text = var1.readStringCp1252NullTerminated();
			this.textLineHeight = var1.readUnsignedByte();
			this.textXAlignment = var1.readUnsignedByte();
			this.textYAlignment = var1.readUnsignedByte();
			this.textShadowed = var1.readUnsignedByte() == 1;
			this.color = var1.readInt();
		}

		if (this.type == 3) {
			this.color = var1.readInt();
			this.fill = var1.readUnsignedByte() == 1;
			this.transparencyTop = var1.readUnsignedByte();
		}

		if (this.type == 9) {
			this.lineWid = var1.readUnsignedByte();
			this.color = var1.readInt();
			this.field3434 = var1.readUnsignedByte() == 1;
		}

		this.flags = var1.readMedium();
		this.dataText = var1.readStringCp1252NullTerminated();
		int var2 = var1.readUnsignedByte();
		if (var2 > 0) {
			this.actions = new String[var2];

			for (int var3 = 0; var3 < var2; ++var3) {
				this.actions[var3] = var1.readStringCp1252NullTerminated();
			}
		}

		this.dragZoneSize = var1.readUnsignedByte();
		this.dragThreshold = var1.readUnsignedByte();
		this.isScrollBar = var1.readUnsignedByte() == 1;
		this.spellActionName = var1.readStringCp1252NullTerminated();
		this.onLoad = this.readListener(var1);
		this.onMouseOver = this.readListener(var1);
		this.onMouseLeave = this.readListener(var1);
		this.onTargetLeave = this.readListener(var1);
		this.onTargetEnter = this.readListener(var1);
		this.onVarTransmit = this.readListener(var1);
		this.onInvTransmit = this.readListener(var1);
		this.onStatTransmit = this.readListener(var1);
		this.onTimer = this.readListener(var1);
		this.onOp = this.readListener(var1);
		this.onMouseRepeat = this.readListener(var1);
		this.onClick = this.readListener(var1);
		this.onClickRepeat = this.readListener(var1);
		this.onRelease = this.readListener(var1);
		this.onHold = this.readListener(var1);
		this.onDrag = this.readListener(var1);
		this.onDragComplete = this.readListener(var1);
		this.onScroll = this.readListener(var1);
		this.varTransmitTriggers = this.readListenerTriggers(var1);
		this.invTransmitTriggers = this.readListenerTriggers(var1);
		this.statTransmitTriggers = this.readListenerTriggers(var1);
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		descriptor = "(Lqq;B)[Ljava/lang/Object;",
		garbageValue = "-120"
	)
	@Export("readListener")
	Object[] readListener(Buffer var1) {
		int var2 = var1.readUnsignedByte();
		if (var2 == 0) {
			return null;
		} else {
			Object[] var3 = new Object[var2];

			for (int var4 = 0; var4 < var2; ++var4) {
				int var5 = var1.readUnsignedByte();
				if (var5 == 0) {
					var3[var4] = new Integer(var1.readInt());
				} else if (var5 == 1) {
					var3[var4] = var1.readStringCp1252NullTerminated();
				}
			}

			this.hasListener = true;
			return var3;
		}
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		descriptor = "(Lqq;B)[I",
		garbageValue = "8"
	)
	@Export("readListenerTriggers")
	int[] readListenerTriggers(Buffer var1) {
		int var2 = var1.readUnsignedByte();
		if (var2 == 0) {
			return null;
		} else {
			int[] var3 = new int[var2];

			for (int var4 = 0; var4 < var2; ++var4) {
				var3[var4] = var1.readInt();
			}

			return var3;
		}
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		descriptor = "(IIB)V",
		garbageValue = "78"
	)
	@Export("swapItems")
	public void swapItems(int var1, int var2) {
		int var3 = this.itemIds[var2];
		this.itemIds[var2] = this.itemIds[var1];
		this.itemIds[var1] = var3;
		var3 = this.itemQuantities[var2];
		this.itemQuantities[var2] = this.itemQuantities[var1];
		this.itemQuantities[var1] = var3;
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		descriptor = "(ZLch;I)Lqi;",
		garbageValue = "-1268256056"
	)
	@Export("getSprite")
	public SpritePixels getSprite(boolean var1, UrlRequester var2) {
		field3392 = false;
		if (this.field3542 != null) {
			SpritePixels var3 = this.method5776(var2);
			if (var3 != null) {
				return var3;
			}
		}

		int var7;
		if (var1) {
			var7 = this.spriteId;
		} else {
			var7 = this.spriteId2;
		}

		if (var7 == -1) {
			return null;
		} else {
			long var4 = ((this.spriteFlipH ? 1L : 0L) << 39) + ((this.spriteFlipV ? 1L : 0L) << 38) + (long)var7 + ((long)this.outline << 36) + ((long)this.spriteShadow << 40);
			SpritePixels var6 = (SpritePixels)Widget_cachedSprites.get(var4);
			if (var6 != null) {
				return var6;
			} else {
				var6 = class114.SpriteBuffer_getSprite(Widget_spritesArchive, var7, 0);
				if (var6 == null) {
					field3392 = true;
					return null;
				} else {
					this.method5779(var6);
					Widget_cachedSprites.put(var6, var4);
					return var6;
				}
			}
		}
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		descriptor = "(Lch;I)Lqi;",
		garbageValue = "1294494257"
	)
	SpritePixels method5776(UrlRequester var1) {
		if (!this.method5778()) {
			return this.method5804(var1);
		} else {
			String var2 = this.field3542 + (this.spriteFlipV ? 1 : 0) + (this.spriteFlipH ? 1 : 0) + this.outline + this.spriteShadow;
			SpritePixels var3 = (SpritePixels)field3391.method6758(var2);
			if (var3 == null) {
				SpritePixels var4 = this.method5804(var1);
				if (var4 != null) {
					var3 = var4.method8334();
					this.method5779(var3);
					field3391.method6750(var2, var3);
				}
			}

			return var3;
		}
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		descriptor = "(Lch;B)Lqi;",
		garbageValue = "-82"
	)
	SpritePixels method5804(UrlRequester var1) {
		if (this.field3542 != null && var1 != null) {
			class292 var2 = (class292)field3390.method6758(this.field3542);
			if (var2 == null) {
				var2 = new class292(this.field3542, var1);
				field3390.method6750(this.field3542, var2);
			}

			return var2.method5722();
		} else {
			return null;
		}
	}

	@ObfuscatedName("h")
	@ObfuscatedSignature(
		descriptor = "(B)Z",
		garbageValue = "42"
	)
	boolean method5778() {
		return this.spriteFlipV || this.spriteFlipH || this.outline != 0 || this.spriteShadow != 0;
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		descriptor = "(Lqi;I)V",
		garbageValue = "-49711267"
	)
	void method5779(SpritePixels var1) {
		if (this.spriteFlipV) {
			var1.flipVertically();
		}

		if (this.spriteFlipH) {
			var1.flipHorizontally();
		}

		if (this.outline > 0) {
			var1.pad(this.outline);
		}

		if (this.outline >= 1) {
			var1.outline(1);
		}

		if (this.outline >= 2) {
			var1.outline(16777215);
		}

		if (this.spriteShadow != 0) {
			var1.shadow(this.spriteShadow);
		}

	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		descriptor = "(I)Lmv;",
		garbageValue = "1537813946"
	)
	@Export("getFont")
	public Font getFont() {
		field3392 = false;
		if (this.fontId == -1) {
			return null;
		} else {
			Font var1 = (Font)Widget_cachedFonts.get((long)this.fontId);
			if (var1 != null) {
				return var1;
			} else {
				var1 = class448.method8182(Widget_spritesArchive, class161.Widget_fontsArchive, this.fontId, 0);
				if (var1 != null) {
					Widget_cachedFonts.put(var1, (long)this.fontId);
				} else {
					field3392 = true;
				}

				return var1;
			}
		}
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		descriptor = "(IS)Lqi;",
		garbageValue = "16843"
	)
	@Export("getInventorySprite")
	public SpritePixels getInventorySprite(int var1) {
		field3392 = false;
		if (var1 >= 0 && var1 < this.inventorySprites.length) {
			int var2 = this.inventorySprites[var1];
			if (var2 == -1) {
				return null;
			} else {
				SpritePixels var3 = (SpritePixels)Widget_cachedSprites.get((long)var2);
				if (var3 != null) {
					return var3;
				} else {
					var3 = class114.SpriteBuffer_getSprite(Widget_spritesArchive, var2, 0);
					if (var3 != null) {
						Widget_cachedSprites.put(var3, (long)var2);
					} else {
						field3392 = true;
					}

					return var3;
				}
			}
		} else {
			return null;
		}
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		descriptor = "(Lgd;IZLke;B)Lha;",
		garbageValue = "75"
	)
	@Export("getModel")
	public Model getModel(SequenceDefinition var1, int var2, boolean var3, PlayerComposition var4) {
		field3392 = false;
		int var5;
		int var6;
		if (var3) {
			var5 = this.modelType2;
			var6 = this.modelId2;
		} else {
			var5 = this.modelType;
			var6 = this.modelId;
		}

		if (var5 == 0) {
			return null;
		} else if (var5 == 1 && var6 == -1) {
			return null;
		} else {
			Model var7 = (Model)Widget_cachedModels.get((long)(var6 + (var5 << 16)));
			if (var7 == null) {
				ModelData var8;
				if (var5 == 1) {
					var8 = ModelData.ModelData_get(WorldMapSection2.Widget_modelsArchive, var6, 0);
					if (var8 == null) {
						field3392 = true;
						return null;
					}

					var7 = var8.toModel(64, 768, -50, -10, -50);
				}

				if (var5 == 2) {
					var8 = class193.getNpcDefinition(var6).getModelData();
					if (var8 == null) {
						field3392 = true;
						return null;
					}

					var7 = var8.toModel(64, 768, -50, -10, -50);
				}

				if (var5 == 3) {
					if (var4 == null) {
						return null;
					}

					var8 = var4.getModelData();
					if (var8 == null) {
						field3392 = true;
						return null;
					}

					var7 = var8.toModel(64, 768, -50, -10, -50);
				}

				if (var5 == 4) {
					ItemComposition var9 = UserComparator3.ItemDefinition_get(var6);
					var8 = var9.getModelData(10);
					if (var8 == null) {
						field3392 = true;
						return null;
					}

					var7 = var8.toModel(var9.ambient + 64, var9.contrast * 5 + 768, -50, -10, -50);
				}

				Widget_cachedModels.put(var7, (long)(var6 + (var5 << 16)));
			}

			if (var1 != null) {
				var7 = var1.transformWidgetModel(var7, var2);
			}

			return var7;
		}
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		descriptor = "(ZB)Lko;",
		garbageValue = "1"
	)
	@Export("getSpriteMask")
	public SpriteMask getSpriteMask(boolean var1) {
		if (this.spriteId == -1) {
			var1 = false;
		}

		int var2 = var1 ? this.spriteId : this.spriteId2;
		if (var2 == -1) {
			return null;
		} else {
			long var3 = ((long)this.spriteShadow << 40) + ((this.spriteFlipV ? 1L : 0L) << 38) + ((long)this.outline << 36) + (long)var2 + ((this.spriteFlipH ? 1L : 0L) << 39);
			SpriteMask var5 = (SpriteMask)Widget_cachedSpriteMasks.get(var3);
			if (var5 != null) {
				return var5;
			} else {
				SpritePixels var6 = this.getSprite(var1, (UrlRequester)null);
				if (var6 == null) {
					return null;
				} else {
					SpritePixels var7 = var6.copyNormalized();
					int[] var8 = new int[var7.subHeight];
					int[] var9 = new int[var7.subHeight];

					for (int var10 = 0; var10 < var7.subHeight; ++var10) {
						int var11 = 0;
						int var12 = var7.subWidth;

						int var13;
						for (var13 = 0; var13 < var7.subWidth; ++var13) {
							if (var7.pixels[var13 + var10 * var7.subWidth] == 0) {
								var11 = var13;
								break;
							}
						}

						for (var13 = var7.subWidth - 1; var13 >= var11; --var13) {
							if (var7.pixels[var13 + var10 * var7.subWidth] == 0) {
								var12 = var13 + 1;
								break;
							}
						}

						var8[var10] = var11;
						var9[var10] = var12 - var11;
					}

					var5 = new SpriteMask(var7.subWidth, var7.subHeight, var9, var8, var2);
					Widget_cachedSpriteMasks.put(var5, var3);
					return var5;
				}
			}
		}
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		descriptor = "(ILjava/lang/String;I)V",
		garbageValue = "1562946903"
	)
	@Export("setAction")
	public void setAction(int var1, String var2) {
		if (this.actions == null || this.actions.length <= var1) {
			String[] var3 = new String[var1 + 1];
			if (this.actions != null) {
				for (int var4 = 0; var4 < this.actions.length; ++var4) {
					var3[var4] = this.actions[var4];
				}
			}

			this.actions = var3;
		}

		this.actions[var1] = var2;
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "-735217152"
	)
	public boolean method5784() {
		return !this.isIf3 || this.type == 0 || this.type == 11 || this.hasListener || this.contentType == 1338;
	}

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;Lch;J)V"
	)
	public void method5821(String var1, UrlRequester var2, long var3) {
		if (this.type == 11 && var3 != -1L) {
			var1 = var1.replaceAll("%userid%", Long.toString(var3));
			this.field3468 = new class156();
			if (!this.field3468.method3374(var1, var2)) {
				this.field3468 = null;
			} else {
				if (this.field3474 == null || this.field3471 == null) {
					this.method5796();
				}

			}
		}
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "973241705"
	)
	void method5796() {
		this.field3474 = new HashMap();
		this.field3471 = new HashMap();
	}

	@ObfuscatedName("r")
	@ObfuscatedSignature(
		descriptor = "(III)V",
		garbageValue = "1326660346"
	)
	public void method5873(int var1, int var2) {
		if (this.type == 11) {
			if (this.field3474 == null) {
				this.method5796();
			}

			this.field3474.put(var1, var2);
		}
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;IB)V",
		garbageValue = "-85"
	)
	public void method5788(String var1, int var2) {
		if (this.type == 11) {
			if (this.field3471 == null) {
				this.method5796();
			}

			this.field3471.put(var1, var2);
		}
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		descriptor = "(IIIIB)Z",
		garbageValue = "-67"
	)
	public boolean method5789(int var1, int var2, int var3, int var4) {
		if (this.type == 11 && this.field3468 != null && this.method5790()) {
			var1 -= var3;
			var2 -= var4;
			int var5 = (int)(this.field3468.method3352()[0] * (float)this.width);
			int var6 = (int)(this.field3468.method3352()[1] * (float)this.height);
			int var7 = var5 + (int)(this.field3468.method3352()[2] * (float)this.width);
			int var8 = var6 + (int)(this.field3468.method3352()[3] * (float)this.height);
			return var1 >= var5 && var2 >= var6 && var1 < var7 && var2 < var8;
		} else {
			return false;
		}
	}

	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "469209429"
	)
	public boolean method5790() {
		return this.field3469 == 2;
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;B)I",
		garbageValue = "87"
	)
	public int method5866(String var1) {
		return this.type == 11 && this.field3468 != null && this.method5790() ? this.field3468.method3347(var1) : -1;
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;B)Ljava/lang/String;",
		garbageValue = "48"
	)
	public String method5792(String var1) {
		return this.type == 11 && this.field3468 != null && this.method5790() ? this.field3468.method3398(var1) : null;
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "-570234230"
	)
	public int method5817() {
		return this.field3471 != null && this.field3471.size() > 0 ? 1 : 0;
	}

	@ObfuscatedName("aq")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "1880183811"
	)
	public int method5839() {
		if (this.type == 11 && this.field3468 != null && this.field3471 != null && !this.field3471.isEmpty()) {
			String var1 = this.field3468.method3408();
			return var1 != null && this.field3471.containsKey(this.field3468.method3408()) ? (Integer)this.field3471.get(var1) : -1;
		} else {
			return -1;
		}
	}

	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		descriptor = "(I)Ljava/lang/String;",
		garbageValue = "-2146158160"
	)
	public String method5815() {
		if (this.type == 11 && this.field3468 != null) {
			String var1 = this.field3468.method3408();
			Iterator var2 = this.field3468.method3353().iterator();

			while (var2.hasNext()) {
				class166 var3 = (class166)var2.next();
				String var4 = String.format("%%%S%%", var3.method3493());
				if (var3.vmethod3480() == 0) {
					var1.replaceAll(var4, Integer.toString(var3.vmethod3482()));
				} else {
					var1.replaceAll(var4, var3.vmethod3481());
				}
			}

			return var1;
		} else {
			return null;
		}
	}

	@ObfuscatedName("an")
	@ObfuscatedSignature(
		descriptor = "(I)[I",
		garbageValue = "-363622433"
	)
	public int[] method5835() {
		if (this.type == 11 && this.field3468 != null) {
			int[] var1 = new int[3];
			int var2 = 0;
			Iterator var3 = this.field3468.method3353().iterator();

			while (var3.hasNext()) {
				class166 var4 = (class166)var3.next();
				if (!var4.method3493().equals("user_id")) {
					if (var4.vmethod3480() != 0) {
						return null;
					}

					var1[var2++] = var4.vmethod3482();
					if (var2 > 3) {
						return null;
					}
				}
			}

			return var1;
		} else {
			return null;
		}
	}

	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "(Lch;I)Z",
		garbageValue = "1643948657"
	)
	public boolean method5827(UrlRequester var1) {
		if (this.type == 11 && this.field3468 != null) {
			this.field3468.method3345(var1);
			if (this.field3468.method3346() != this.field3469) {
				this.field3469 = this.field3468.method3346();
				if (this.field3469 >= 100) {
					return true;
				}

				if (this.field3469 == 2) {
					this.method5798();
					return true;
				}
			}

			return false;
		} else {
			return false;
		}
	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "1552850127"
	)
	void method5798() {
		this.noClickThrough = true;
		ArrayList var1 = this.field3468.method3369();
		ArrayList var2 = this.field3468.method3350();
		int var3 = var1.size() + var2.size();
		this.children = new Widget[var3];
		int var4 = 0;

		Iterator var5;
		Widget var7;
		for (var5 = var1.iterator(); var5.hasNext(); this.children[var4++] = var7) {
			class161 var6 = (class161)var5.next();
			var7 = DirectByteArrayCopier.method5686(5, this, var4, 0, 0, 0, 0, var6.field1781);
			var7.field3542 = var6.field1786.method2714();
			class292 var8 = new class292(var6.field1786);
			field3390.method6750(var7.field3542, var8);
		}

		for (var5 = var2.iterator(); var5.hasNext(); this.children[var4++] = var7) {
			class162 var9 = (class162)var5.next();
			var7 = DirectByteArrayCopier.method5686(4, this, var4, 0, 0, 0, 0, var9.field1791);
			var7.text = var9.field1788;
			var7.fontId = (Integer)this.field3474.get(var9.field1794);
			var7.textXAlignment = var9.field1792;
			var7.textYAlignment = var9.field1793;
		}

	}

	@ObfuscatedName("iv")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "1977094126"
	)
	static final boolean method5882() {
		return Client.isMenuOpen;
	}
}
