import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("mt")
@Implements("Widget")
public class Widget extends Node {
	@ObfuscatedName("bd")
	@Export("Widget_loadedInterfaces")
	public static boolean[] Widget_loadedInterfaces;
	@ObfuscatedName("bs")
	@ObfuscatedSignature(
		descriptor = "Lld;"
	)
	@Export("Widget_cachedSprites")
	static EvictingDualNodeHashTable Widget_cachedSprites;
	@ObfuscatedName("bp")
	@ObfuscatedSignature(
		descriptor = "Lld;"
	)
	@Export("Widget_cachedModels")
	static EvictingDualNodeHashTable Widget_cachedModels;
	@ObfuscatedName("bv")
	@ObfuscatedSignature(
		descriptor = "Lld;"
	)
	@Export("Widget_cachedFonts")
	static EvictingDualNodeHashTable Widget_cachedFonts;
	@ObfuscatedName("bq")
	@ObfuscatedSignature(
		descriptor = "Lld;"
	)
	@Export("Widget_cachedSpriteMasks")
	static EvictingDualNodeHashTable Widget_cachedSpriteMasks;
	@ObfuscatedName("bo")
	@ObfuscatedSignature(
		descriptor = "Lql;"
	)
	static class424 field2932;
	@ObfuscatedName("br")
	@ObfuscatedSignature(
		descriptor = "Lql;"
	)
	static class424 field2933;
	@ObfuscatedName("bw")
	public static boolean field2926;
	@ObfuscatedName("be")
	@Export("isIf3")
	public boolean isIf3;
	@ObfuscatedName("bc")
	@Export("id")
	public int id;
	@ObfuscatedName("bi")
	@Export("childIndex")
	public int childIndex;
	@ObfuscatedName("bu")
	@Export("type")
	public int type;
	@ObfuscatedName("bk")
	@Export("buttonType")
	public int buttonType;
	@ObfuscatedName("bz")
	@Export("contentType")
	public int contentType;
	@ObfuscatedName("bx")
	@Export("xAlignment")
	public int xAlignment;
	@ObfuscatedName("bh")
	@Export("yAlignment")
	public int yAlignment;
	@ObfuscatedName("bm")
	@Export("widthAlignment")
	public int widthAlignment;
	@ObfuscatedName("bl")
	@Export("heightAlignment")
	public int heightAlignment;
	@ObfuscatedName("bt")
	@Export("rawX")
	public int rawX;
	@ObfuscatedName("by")
	@Export("rawY")
	public int rawY;
	@ObfuscatedName("bg")
	@Export("rawWidth")
	public int rawWidth;
	@ObfuscatedName("bj")
	@Export("rawHeight")
	public int rawHeight;
	@ObfuscatedName("ct")
	@Export("x")
	public int x;
	@ObfuscatedName("cf")
	@Export("y")
	public int y;
	@ObfuscatedName("cz")
	@Export("width")
	public int width;
	@ObfuscatedName("cb")
	@Export("height")
	public int height;
	@ObfuscatedName("cs")
	public int field2990;
	@ObfuscatedName("cj")
	public int field2981;
	@ObfuscatedName("cn")
	@Export("parentId")
	public int parentId;
	@ObfuscatedName("cw")
	@Export("isHidden")
	public boolean isHidden;
	@ObfuscatedName("ce")
	@Export("scrollX")
	public int scrollX;
	@ObfuscatedName("cq")
	@Export("scrollY")
	public int scrollY;
	@ObfuscatedName("cm")
	@Export("scrollWidth")
	public int scrollWidth;
	@ObfuscatedName("ca")
	@Export("scrollHeight")
	public int scrollHeight;
	@ObfuscatedName("cx")
	@Export("color")
	public int color;
	@ObfuscatedName("co")
	@Export("color2")
	public int color2;
	@ObfuscatedName("cu")
	@Export("mouseOverColor")
	public int mouseOverColor;
	@ObfuscatedName("cr")
	@Export("mouseOverColor2")
	public int mouseOverColor2;
	@ObfuscatedName("cd")
	@Export("fill")
	public boolean fill;
	@ObfuscatedName("cy")
	@ObfuscatedSignature(
		descriptor = "Luc;"
	)
	@Export("fillMode")
	public class525 fillMode;
	@ObfuscatedName("ck")
	@Export("transparencyTop")
	public int transparencyTop;
	@ObfuscatedName("cl")
	@Export("transparencyBot")
	public int transparencyBot;
	@ObfuscatedName("cp")
	@Export("lineWid")
	public int lineWid;
	@ObfuscatedName("ch")
	public boolean field2943;
	@ObfuscatedName("cg")
	@Export("spriteId2")
	public int spriteId2;
	@ObfuscatedName("ci")
	@Export("spriteId")
	public int spriteId;
	@ObfuscatedName("cv")
	public String field3073;
	@ObfuscatedName("cc")
	@Export("spriteAngle")
	public int spriteAngle;
	@ObfuscatedName("dc")
	@Export("spriteTiling")
	public boolean spriteTiling;
	@ObfuscatedName("dq")
	@Export("outline")
	public int outline;
	@ObfuscatedName("dg")
	@Export("spriteShadow")
	public int spriteShadow;
	@ObfuscatedName("dj")
	@Export("spriteFlipV")
	public boolean spriteFlipV;
	@ObfuscatedName("dy")
	@Export("spriteFlipH")
	public boolean spriteFlipH;
	@ObfuscatedName("dr")
	@Export("modelType")
	public int modelType;
	@ObfuscatedName("do")
	@Export("modelId")
	public int modelId;
	@ObfuscatedName("dk")
	@Export("modelType2")
	int modelType2;
	@ObfuscatedName("dn")
	@Export("modelId2")
	int modelId2;
	@ObfuscatedName("di")
	@Export("sequenceId")
	public int sequenceId;
	@ObfuscatedName("de")
	@Export("sequenceId2")
	public int sequenceId2;
	@ObfuscatedName("dd")
	@Export("modelOffsetX")
	public int modelOffsetX;
	@ObfuscatedName("dt")
	@Export("modelOffsetY")
	public int modelOffsetY;
	@ObfuscatedName("df")
	@Export("modelAngleX")
	public int modelAngleX;
	@ObfuscatedName("dm")
	@Export("modelAngleY")
	public int modelAngleY;
	@ObfuscatedName("du")
	@Export("modelAngleZ")
	public int modelAngleZ;
	@ObfuscatedName("dz")
	@Export("modelZoom")
	public int modelZoom;
	@ObfuscatedName("dx")
	@Export("modelRotation")
	public int modelRotation;
	@ObfuscatedName("dp")
	@Export("rotationKey")
	public int rotationKey;
	@ObfuscatedName("ds")
	@ObfuscatedSignature(
		descriptor = "Lmb;"
	)
	public PlayerComposition field3081;
	@ObfuscatedName("da")
	@Export("modelOrthog")
	public boolean modelOrthog;
	@ObfuscatedName("dv")
	@Export("modelTransparency")
	public boolean modelTransparency;
	@ObfuscatedName("dh")
	@Export("itemQuantityMode")
	public int itemQuantityMode;
	@ObfuscatedName("dl")
	@Export("fontId")
	public int fontId;
	@ObfuscatedName("db")
	@Export("text")
	public String text;
	@ObfuscatedName("dw")
	@Export("text2")
	public String text2;
	@ObfuscatedName("et")
	@Export("textLineHeight")
	public int textLineHeight;
	@ObfuscatedName("em")
	@Export("textXAlignment")
	public int textXAlignment;
	@ObfuscatedName("ec")
	@Export("textYAlignment")
	public int textYAlignment;
	@ObfuscatedName("el")
	@Export("textShadowed")
	public boolean textShadowed;
	@ObfuscatedName("er")
	@ObfuscatedSignature(
		descriptor = "Lgq;"
	)
	class170 field2934;
	@ObfuscatedName("ew")
	int field2937;
	@ObfuscatedName("eo")
	HashMap field2939;
	@ObfuscatedName("eb")
	HashMap field2938;
	@ObfuscatedName("eh")
	@ObfuscatedSignature(
		descriptor = "Lmz;"
	)
	class328 field2940;
	@ObfuscatedName("ei")
	@Export("flags")
	public int flags;
	@ObfuscatedName("en")
	public boolean field2951;
	@ObfuscatedName("es")
	public byte[][] field2960;
	@ObfuscatedName("eq")
	public byte[][] field2959;
	@ObfuscatedName("ee")
	public int[] field3028;
	@ObfuscatedName("eg")
	public int[] field3029;
	@ObfuscatedName("ef")
	@Export("dataText")
	public String dataText;
	@ObfuscatedName("ev")
	@Export("actions")
	public String[] actions;
	@ObfuscatedName("ez")
	@ObfuscatedSignature(
		descriptor = "Lmt;"
	)
	@Export("parent")
	public Widget parent;
	@ObfuscatedName("ek")
	@Export("dragZoneSize")
	public int dragZoneSize;
	@ObfuscatedName("eu")
	@Export("dragThreshold")
	public int dragThreshold;
	@ObfuscatedName("ep")
	@Export("isScrollBar")
	public boolean isScrollBar;
	@ObfuscatedName("fm")
	@Export("spellActionName")
	public String spellActionName;
	@ObfuscatedName("fa")
	@Export("hasListener")
	public boolean hasListener;
	@ObfuscatedName("fg")
	@Export("onLoad")
	public Object[] onLoad;
	@ObfuscatedName("fq")
	@Export("onClick")
	public Object[] onClick;
	@ObfuscatedName("fy")
	@Export("onClickRepeat")
	public Object[] onClickRepeat;
	@ObfuscatedName("fw")
	@Export("onRelease")
	public Object[] onRelease;
	@ObfuscatedName("fp")
	@Export("onHold")
	public Object[] onHold;
	@ObfuscatedName("fz")
	@Export("onMouseOver")
	public Object[] onMouseOver;
	@ObfuscatedName("fj")
	@Export("onMouseRepeat")
	public Object[] onMouseRepeat;
	@ObfuscatedName("fb")
	@Export("onMouseLeave")
	public Object[] onMouseLeave;
	@ObfuscatedName("fl")
	@Export("onDrag")
	public Object[] onDrag;
	@ObfuscatedName("fd")
	@Export("onDragComplete")
	public Object[] onDragComplete;
	@ObfuscatedName("fh")
	@Export("onTargetEnter")
	public Object[] onTargetEnter;
	@ObfuscatedName("fc")
	@Export("onTargetLeave")
	public Object[] onTargetLeave;
	@ObfuscatedName("fu")
	@Export("onVarTransmit")
	public Object[] onVarTransmit;
	@ObfuscatedName("fv")
	@Export("varTransmitTriggers")
	public int[] varTransmitTriggers;
	@ObfuscatedName("fr")
	@Export("onInvTransmit")
	public Object[] onInvTransmit;
	@ObfuscatedName("fs")
	@Export("invTransmitTriggers")
	public int[] invTransmitTriggers;
	@ObfuscatedName("fn")
	@Export("onStatTransmit")
	public Object[] onStatTransmit;
	@ObfuscatedName("ff")
	@Export("statTransmitTriggers")
	public int[] statTransmitTriggers;
	@ObfuscatedName("fk")
	@Export("onTimer")
	public Object[] onTimer;
	@ObfuscatedName("ft")
	@Export("onOp")
	public Object[] onOp;
	@ObfuscatedName("fe")
	public Object[] field3042;
	@ObfuscatedName("fo")
	@Export("onScroll")
	public Object[] onScroll;
	@ObfuscatedName("fx")
	@Export("onChatTransmit")
	public Object[] onChatTransmit;
	@ObfuscatedName("fi")
	@Export("onKey")
	public Object[] onKey;
	@ObfuscatedName("gc")
	public Object[] field3061;
	@ObfuscatedName("gp")
	public Object[] field3068;
	@ObfuscatedName("ga")
	@Export("onFriendTransmit")
	public Object[] onFriendTransmit;
	@ObfuscatedName("gg")
	@Export("onClanTransmit")
	public Object[] onClanTransmit;
	@ObfuscatedName("gs")
	public Object[] field3070;
	@ObfuscatedName("ge")
	public Object[] field3062;
	@ObfuscatedName("go")
	@Export("onMiscTransmit")
	public Object[] onMiscTransmit;
	@ObfuscatedName("gh")
	@Export("onDialogAbort")
	public Object[] onDialogAbort;
	@ObfuscatedName("gj")
	@Export("onSubChange")
	public Object[] onSubChange;
	@ObfuscatedName("gm")
	@Export("onResize")
	public Object[] onResize;
	@ObfuscatedName("gx")
	@Export("onStockTransmit")
	public Object[] onStockTransmit;
	@ObfuscatedName("gr")
	public Object[] field3069;
	@ObfuscatedName("gy")
	public Object[] field3072;
	@ObfuscatedName("gt")
	@Export("cs1Instructions")
	public int[][] cs1Instructions;
	@ObfuscatedName("gq")
	@Export("cs1Comparisons")
	public int[] cs1Comparisons;
	@ObfuscatedName("gv")
	@Export("cs1ComparisonValues")
	public int[] cs1ComparisonValues;
	@ObfuscatedName("gl")
	@Export("mouseOverRedirect")
	public int mouseOverRedirect;
	@ObfuscatedName("gd")
	public String field3078;
	@ObfuscatedName("gf")
	@Export("buttonText")
	public String buttonText;
	@ObfuscatedName("gk")
	@Export("itemIds")
	public int[] itemIds;
	@ObfuscatedName("gz")
	public int[] field3036;
	@ObfuscatedName("gi")
	@Export("itemId")
	public int itemId;
	@ObfuscatedName("gb")
	@Export("itemQuantity")
	public int itemQuantity;
	@ObfuscatedName("gn")
	@Export("modelFrame")
	public int modelFrame;
	@ObfuscatedName("gu")
	@Export("modelFrameCycle")
	public int modelFrameCycle;
	@ObfuscatedName("gw")
	@ObfuscatedSignature(
		descriptor = "[Lmt;"
	)
	@Export("children")
	public Widget[] children;
	@ObfuscatedName("hf")
	public boolean field2954;
	@ObfuscatedName("hv")
	public boolean field2957;
	@ObfuscatedName("hp")
	public int field3026;
	@ObfuscatedName("hh")
	public int field3024;
	@ObfuscatedName("hg")
	public int field3023;
	@ObfuscatedName("ho")
	public int field3025;
	@ObfuscatedName("he")
	@Export("rootIndex")
	public int rootIndex;
	@ObfuscatedName("hx")
	@Export("cycle")
	public int cycle;
	@ObfuscatedName("ha")
	public int[] field3037;
	@ObfuscatedName("hr")
	@Export("noClickThrough")
	public boolean noClickThrough;
	@ObfuscatedName("hm")
	@Export("noScrollThrough")
	public boolean noScrollThrough;
	@ObfuscatedName("hz")
	@Export("prioritizeMenuEntry")
	public boolean prioritizeMenuEntry;

	static {
		Widget_cachedSprites = new EvictingDualNodeHashTable(200);
		Widget_cachedModels = new EvictingDualNodeHashTable(50);
		Widget_cachedFonts = new EvictingDualNodeHashTable(20);
		Widget_cachedSpriteMasks = new EvictingDualNodeHashTable(8);
		field2932 = new class424(10, class422.field3754);
		field2933 = new class424(10, class422.field3754);
		field2926 = false;
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
		this.field2990 = 1;
		this.field2981 = 1;
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
		this.fillMode = class525.SOLID;
		this.transparencyTop = 0;
		this.transparencyBot = 0;
		this.lineWid = 1;
		this.field2943 = false;
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
		this.modelRotation = 0;
		this.rotationKey = 0;
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
		this.field2937 = -1;
		this.flags = 0;
		this.field2951 = false;
		this.dataText = "";
		this.parent = null;
		this.dragZoneSize = 0;
		this.dragThreshold = 0;
		this.isScrollBar = false;
		this.spellActionName = "";
		this.hasListener = false;
		this.mouseOverRedirect = -1;
		this.field3078 = "";
		this.buttonText = "Ok";
		this.itemId = -1;
		this.itemQuantity = 0;
		this.modelFrame = 0;
		this.modelFrameCycle = 0;
		this.field2954 = false;
		this.field2957 = false;
		this.field3026 = -1;
		this.field3024 = 0;
		this.field3023 = 0;
		this.field3025 = 0;
		this.rootIndex = -1;
		this.cycle = -1;
		this.noClickThrough = false;
		this.noScrollThrough = false;
		this.prioritizeMenuEntry = false;
	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "(Lty;I)V",
		garbageValue = "765391590"
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
		if (var3 > 0) {
			this.cs1Instructions = new int[var3][];

			for (var4 = 0; var4 < var3; ++var4) {
				int var5 = var1.readUnsignedShort();
				this.cs1Instructions[var4] = new int[var5];

				for (int var6 = 0; var6 < var5; ++var6) {
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

		if (this.type == 8) {
			this.text = var1.readStringCp1252NullTerminated();
		}

		if (this.buttonType == 2) {
			this.spellActionName = var1.readStringCp1252NullTerminated();
			this.field3078 = var1.readStringCp1252NullTerminated();
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

	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "(Lty;I)V",
		garbageValue = "1963555900"
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
				this.modelRotation = var1.readUnsignedShort();
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
			this.field2943 = var1.readUnsignedByte() == 1;
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

	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		descriptor = "(Lty;B)[Ljava/lang/Object;",
		garbageValue = "122"
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

	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		descriptor = "(Lty;I)[I",
		garbageValue = "-2000592706"
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

	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "(ZLej;B)Lud;",
		garbageValue = "-22"
	)
	@Export("getSprite")
	public SpritePixels getSprite(boolean var1, UrlRequester var2) {
		field2926 = false;
		if (this.field3073 != null) {
			SpritePixels var3 = this.method1779(var2);
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
			long var4 = ((long)this.spriteShadow << 40) + ((this.spriteFlipV ? 1L : 0L) << 38) + ((long)this.outline << 36) + (long)var7 + ((this.spriteFlipH ? 1L : 0L) << 39);
			SpritePixels var6 = (SpritePixels)Widget_cachedSprites.get(var4);
			if (var6 != null) {
				return var6;
			} else {
				var6 = WorldMap.SpriteBuffer_getSprite(UserComparator10.Widget_spritesArchive, var7, 0);
				if (var6 == null) {
					field2926 = true;
					return null;
				} else {
					this.method1782(var6);
					Widget_cachedSprites.put(var6, var4);
					return var6;
				}
			}
		}
	}

	@ObfuscatedName("av")
	@ObfuscatedSignature(
		descriptor = "(Lej;I)Lud;",
		garbageValue = "871401764"
	)
	SpritePixels method1779(UrlRequester var1) {
		if (!this.method1781()) {
			return this.method1780(var1);
		} else {
			String var2 = this.field3073 + (this.spriteFlipV ? 1 : 0) + (this.spriteFlipH ? 1 : 0) + this.outline + this.spriteShadow;
			SpritePixels var3 = (SpritePixels)field2933.method2146(var2);
			if (var3 == null) {
				SpritePixels var4 = this.method1780(var1);
				if (var4 != null) {
					var3 = var4.method2638();
					this.method1782(var3);
					field2933.method2147(var2, var3);
				}
			}

			return var3;
		}
	}

	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		descriptor = "(Lej;I)Lud;",
		garbageValue = "1775853493"
	)
	SpritePixels method1780(UrlRequester var1) {
		if (this.field3073 != null && var1 != null) {
			class327 var2 = (class327)field2932.method2146(this.field3073);
			if (var2 == null) {
				var2 = new class327(this.field3073, var1);
				field2932.method2147(this.field3073, var2);
			}

			return var2.method1675();
		} else {
			return null;
		}
	}

	@ObfuscatedName("aq")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "-771382672"
	)
	boolean method1781() {
		return this.spriteFlipV || this.spriteFlipH || this.outline != 0 || this.spriteShadow != 0;
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(Lud;B)V",
		garbageValue = "1"
	)
	void method1782(SpritePixels var1) {
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

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(I)Lpc;",
		garbageValue = "-2062099082"
	)
	@Export("getFont")
	public Font getFont() {
		field2926 = false;
		if (this.fontId == -1) {
			return null;
		} else {
			Font var1 = (Font)Widget_cachedFonts.get((long)this.fontId);
			if (var1 != null) {
				return var1;
			} else {
				var1 = class408.method2106(UserComparator10.Widget_spritesArchive, WallDecoration.Widget_fontsArchive, this.fontId, 0);
				if (var1 != null) {
					Widget_cachedFonts.put(var1, (long)this.fontId);
				} else {
					field2926 = true;
				}

				return var1;
			}
		}
	}

	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "(Lig;IZLmb;Lhi;Lhs;I)Ljo;",
		garbageValue = "-1139082268"
	)
	@Export("getModel")
	public Model getModel(SequenceDefinition var1, int var2, boolean var3, PlayerComposition var4, NPCComposition var5, NewShit var6) {
		field2926 = false;
		int var7;
		int var8;
		if (var3) {
			var7 = this.modelType2;
			var8 = this.modelId2;
		} else {
			var7 = this.modelType;
			var8 = this.modelId;
		}

		if (var7 == 6) {
			if (var5 == null) {
				return null;
			}

			var8 = var5.id;
		}

		if (var7 == 0) {
			return null;
		} else if (var7 == 1 && var8 == -1) {
			return null;
		} else {
			if (var6 != null && var6.field1565 && var7 == 6) {
				var7 = 3;
			}

			long var9 = (long)(var8 + (var7 << 16));
			if (var6 != null) {
				var9 |= var6.field1566 << 20;
			}

			Model var11 = (Model)Widget_cachedModels.get(var9);
			if (var11 == null) {
				ModelData var12 = null;
				int var13 = 64;
				int var14 = 768;
				switch(var7) {
				case 1:
					var12 = ModelData.ModelData_get(BoundaryObject.field2256, var8, 0);
					break;
				case 2:
					var12 = Tile.getNpcDefinition(var8).method967((NewShit)null);
					break;
				case 3:
					var12 = var4 != null ? var4.getModelData() : null;
					break;
				case 4:
					ItemComposition var15 = class125.ItemDefinition_get(var8);
					var12 = var15.getModelData(10);
					var13 += var15.field1783;
					var14 += var15.field1784;
				case 5:
				default:
					break;
				case 6:
					var12 = Tile.getNpcDefinition(var8).method967(var6);
				}

				if (var12 == null) {
					field2926 = true;
					return null;
				}

				var11 = var12.toModel(var13, var14, -50, -10, -50);
				Widget_cachedModels.put(var11, var9);
			}

			if (var1 != null) {
				var11 = var1.transformWidgetModel(var11, var2);
			}

			return var11;
		}
	}

	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "(ZB)Lmi;",
		garbageValue = "-1"
	)
	@Export("getSpriteMask")
	public SpriteMask getSpriteMask(boolean var1) {
		if (this.spriteId == -1) {
			var1 = false;
		}

		int var2 = var1 ? this.spriteId * -1115295013 * -1697203885 : this.spriteId2 * 2109090755 * 701078763;
		if (var2 == -1) {
			return null;
		} else {
			long var3 = ((long)this.spriteShadow << 40) + (long)var2 + ((long)this.outline << 36) + ((this.spriteFlipV ? 1L : 0L) << 38) + ((this.spriteFlipH ? 1L : 0L) << 39);
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

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(ILjava/lang/String;I)V",
		garbageValue = "-1432445957"
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

	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "-727475162"
	)
	public boolean method1787() {
		return !this.isIf3 || this.type == 0 || this.type == 11 || this.hasListener || this.contentType == 1338 || this.type == 12;
	}

	@ObfuscatedName("ad")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "1196611780"
	)
	public boolean method1788() {
		return this.type == 11 || this.type == 12;
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;Lej;J)V"
	)
	public void method1789(String var1, UrlRequester var2, long var3) {
		if (this.type == 11 && var3 != -1L) {
			var1 = var1.replaceAll("%userid%", Long.toString(var3));
			this.field2934 = new class170();
			if (!this.field2934.method875(var1, var2)) {
				this.field2934 = null;
			} else {
				if (this.field2939 == null || this.field2938 == null) {
					this.method1791();
				}

			}
		}
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;Lej;I)V",
		garbageValue = "467943476"
	)
	public void method1790(String var1, UrlRequester var2) {
		if (this.type == 11 && var1 != null) {
			this.field2934 = new class170();
			this.field2934.method893(var1, var2);
		}
	}

	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "1842615926"
	)
	void method1791() {
		this.field2939 = new HashMap();
		this.field2938 = new HashMap();
	}

	@ObfuscatedName("an")
	@ObfuscatedSignature(
		descriptor = "(III)V",
		garbageValue = "1342267996"
	)
	public void method1792(int var1, int var2) {
		if (this.type == 11) {
			if (this.field2939 == null) {
				this.method1791();
			}

			this.field2939.put(var1, var2);
		}
	}

	@ObfuscatedName("af")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;II)V",
		garbageValue = "-1414965691"
	)
	public void method1793(String var1, int var2) {
		if (this.type == 11) {
			if (this.field2938 == null) {
				this.method1791();
			}

			this.field2938.put(var1, var2);
		}
	}

	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		descriptor = "(IIIII)Z",
		garbageValue = "-233873937"
	)
	public boolean method1794(int var1, int var2, int var3, int var4) {
		if (this.type == 11 && this.field2934 != null && this.method1795()) {
			var1 -= var3;
			var2 -= var4;
			int var5 = (int)(this.field2934.method883()[0] * (float)this.width);
			int var6 = (int)(this.field2934.method883()[1] * (float)this.height);
			int var7 = var5 + (int)(this.field2934.method883()[2] * (float)this.width);
			int var8 = var6 + (int)(this.field2934.method883()[3] * (float)this.height);
			return var1 >= var5 && var2 >= var6 && var1 < var7 && var2 < var8;
		} else {
			return false;
		}
	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "-1058749638"
	)
	public boolean method1795() {
		return this.field2937 == 2;
	}

	@ObfuscatedName("bd")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;I)I",
		garbageValue = "-2113017491"
	)
	public int method1796(String var1) {
		return this.type == 11 && this.field2934 != null && this.method1795() ? this.field2934.method878(var1) : -1;
	}

	@ObfuscatedName("bb")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;I)Ljava/lang/String;",
		garbageValue = "-425629947"
	)
	public String method1797(String var1) {
		return this.type == 11 && this.field2934 != null && this.method1795() ? this.field2934.method879(var1) : null;
	}

	@ObfuscatedName("bn")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "17038195"
	)
	public int method1798() {
		return this.field2938 != null && this.field2938.size() > 0 ? 1 : 0;
	}

	@ObfuscatedName("ba")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "-84"
	)
	public int method1799() {
		if (this.type == 11 && this.field2934 != null && this.field2938 != null && !this.field2938.isEmpty()) {
			String var1 = this.field2934.method882();
			return var1 != null && this.field2938.containsKey(this.field2934.method882()) ? (Integer)this.field2938.get(var1) : -1;
		} else {
			return -1;
		}
	}

	@ObfuscatedName("bf")
	@ObfuscatedSignature(
		descriptor = "(I)Ljava/lang/String;",
		garbageValue = "-887288049"
	)
	public String method1800() {
		if (this.type == 11 && this.field2934 != null) {
			String var1 = this.field2934.method882();
			Iterator var2 = this.field2934.method884().iterator();

			while (var2.hasNext()) {
				class181 var3 = (class181)var2.next();
				String var4 = String.format("%%%S%%", var3.method914());
				if (var3.vmethod3379() == 0) {
					var1.replaceAll(var4, Integer.toString(var3.vmethod3378()));
				} else {
					var1.replaceAll(var4, var3.vmethod3380());
				}
			}

			return var1;
		} else {
			return null;
		}
	}

	@ObfuscatedName("bs")
	@ObfuscatedSignature(
		descriptor = "(I)[I",
		garbageValue = "-282480263"
	)
	public int[] method1801() {
		if (this.type == 11 && this.field2934 != null) {
			int[] var1 = new int[3];
			int var2 = 0;
			Iterator var3 = this.field2934.method884().iterator();

			while (var3.hasNext()) {
				class181 var4 = (class181)var3.next();
				if (!var4.method914().equals("user_id")) {
					if (var4.vmethod3379() != 0) {
						return null;
					}

					var1[var2++] = var4.vmethod3378();
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

	@ObfuscatedName("bp")
	@ObfuscatedSignature(
		descriptor = "(Lej;I)Z",
		garbageValue = "-687125955"
	)
	public boolean method1802(UrlRequester var1) {
		if (this.type == 11 && this.field2934 != null) {
			this.field2934.method876(var1);
			if (this.field2934.method877() != this.field2937) {
				this.field2937 = this.field2934.method877();
				if (this.field2937 >= 100) {
					return true;
				}

				if (this.field2937 == 2) {
					this.method1803();
					return true;
				}
			}

			return false;
		} else {
			return false;
		}
	}

	@ObfuscatedName("bq")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-228644187"
	)
	void method1803() {
		this.noClickThrough = true;
		ArrayList var1 = this.field2934.method880();
		ArrayList var2 = this.field2934.method881();
		int var3 = var1.size() + var2.size();
		this.children = new Widget[var3];
		int var4 = 0;

		Iterator var5;
		Widget var7;
		for (var5 = var1.iterator(); var5.hasNext(); this.children[var4++] = var7) {
			class176 var6 = (class176)var5.next();
			var7 = class239.method1282(5, this, var4, 0, 0, 0, 0, var6.field1461);
			var7.field3073 = var6.field1460.method660();
			class327 var8 = new class327(var6.field1460);
			field2932.method2147(var7.field3073, var8);
		}

		for (var5 = var2.iterator(); var5.hasNext(); this.children[var4++] = var7) {
			class177 var9 = (class177)var5.next();
			var7 = class239.method1282(4, this, var4, 0, 0, 0, 0, var9.field1463);
			var7.text = var9.field1467;
			var7.fontId = (Integer)this.field2939.get(var9.field1466);
			var7.textXAlignment = var9.field1465;
			var7.textYAlignment = var9.field1464;
		}

	}

	@ObfuscatedName("bo")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "638323053"
	)
	public void method1804() {
		this.field2940 = new class328();

		for (int var1 = 1; var1 <= 12; ++var1) {
			this.field2940.field2880.method102(var1, 0);
		}

		for (char var2 = 0; var2 < ' '; ++var2) {
			this.field2940.field2880.method103(var2, 0);
		}

		this.field2940.field2880.method103('\u0080', 0);
		this.field2940.field2880.method102(82, 2);
		this.field2940.field2880.method102(81, 2);
		this.field2940.field2880.method102(86, 2);
	}

	@ObfuscatedName("br")
	@ObfuscatedSignature(
		descriptor = "(I)Lmo;",
		garbageValue = "1399447726"
	)
	public class330 method1805() {
		return this.field2940 != null ? this.field2940.field2886 : null;
	}

	@ObfuscatedName("bw")
	@ObfuscatedSignature(
		descriptor = "(I)Lmy;",
		garbageValue = "-1142943567"
	)
	public class325 method1806() {
		return this.field2940 != null ? this.field2940.field2881 : null;
	}

	@ObfuscatedName("be")
	@ObfuscatedSignature(
		descriptor = "(I)Lbb;",
		garbageValue = "1031459265"
	)
	public class27 method1807() {
		return this.field2940 != null ? this.field2940.field2880 : null;
	}

	@ObfuscatedName("bc")
	@ObfuscatedSignature(
		descriptor = "(I)Lmz;",
		garbageValue = "-1841939772"
	)
	public class328 method1808() {
		return this.field2940;
	}

	@ObfuscatedName("bi")
	@ObfuscatedSignature(
		descriptor = "(Lmo;I)Z",
		garbageValue = "1511239269"
	)
	boolean method1809(class330 var1) {
		boolean var2 = false;
		if (this.text != null && !this.text.isEmpty()) {
			var2 |= var1.method1696(class13.method45(this.text));
			this.text = "";
		}

		if (this.text2 != null && !this.text2.isEmpty()) {
			var2 |= var1.method1697(class13.method45(this.text2));
			this.text2 = "";
		}

		return var2;
	}

	@ObfuscatedName("bu")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "-2118705753"
	)
	public boolean method1810() {
		class330 var1 = this.method1805();
		if (var1 == null) {
			return false;
		} else {
			boolean var2 = false;
			if (!var1.method1750() && this.fontId != -1) {
				int var3 = var1.method1751();
				int var4 = var1.method1752();
				int var5 = var1.method1749();
				int var6 = var1.method1748();
				Font var7 = this.getFont();
				if (var7 != null) {
					var2 |= var1.method1698(var7);
					var2 |= this.method1809(var1);
					var2 |= var1.method1703(var3, var4);
					var2 |= var1.method1718(var5, var6);
				}
			} else if (var1.method1750()) {
				var2 |= this.method1809(var1);
			}

			var1.method1693();
			return var2;
		}
	}
}
