import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

@ObfuscatedName("mi")
@Implements("Widget")
public class Widget extends Node {
	@ObfuscatedName("bd")
	@ObfuscatedSignature(
		descriptor = "Lle;"
	)
	@Export("Widget_cachedSprites")
	static EvictingDualNodeHashTable Widget_cachedSprites;
	@ObfuscatedName("by")
	@ObfuscatedSignature(
		descriptor = "Lle;"
	)
	@Export("Widget_cachedModels")
	static EvictingDualNodeHashTable Widget_cachedModels;
	@ObfuscatedName("bs")
	@ObfuscatedSignature(
		descriptor = "Lle;"
	)
	@Export("Widget_cachedFonts")
	static EvictingDualNodeHashTable Widget_cachedFonts;
	@ObfuscatedName("bm")
	@ObfuscatedSignature(
		descriptor = "Lle;"
	)
	@Export("Widget_cachedSpriteMasks")
	static EvictingDualNodeHashTable Widget_cachedSpriteMasks;
	@ObfuscatedName("bf")
	@ObfuscatedSignature(
		descriptor = "Lqv;"
	)
	static class423 field2950;
	@ObfuscatedName("bq")
	@ObfuscatedSignature(
		descriptor = "Lqv;"
	)
	static class423 field2951;
	@ObfuscatedName("ba")
	public static boolean field2945;
	@ObfuscatedName("bl")
	@Export("isIf3")
	public boolean isIf3;
	@ObfuscatedName("bp")
	@Export("id")
	public int id;
	@ObfuscatedName("bu")
	@Export("childIndex")
	public int childIndex;
	@ObfuscatedName("bo")
	@Export("type")
	public int type;
	@ObfuscatedName("bb")
	@Export("buttonType")
	public int buttonType;
	@ObfuscatedName("br")
	@Export("contentType")
	public int contentType;
	@ObfuscatedName("be")
	@Export("xAlignment")
	public int xAlignment;
	@ObfuscatedName("bi")
	@Export("yAlignment")
	public int yAlignment;
	@ObfuscatedName("bz")
	@Export("widthAlignment")
	public int widthAlignment;
	@ObfuscatedName("bx")
	@Export("heightAlignment")
	public int heightAlignment;
	@ObfuscatedName("bn")
	@Export("rawX")
	public int rawX;
	@ObfuscatedName("bw")
	@Export("rawY")
	public int rawY;
	@ObfuscatedName("bc")
	@Export("rawWidth")
	public int rawWidth;
	@ObfuscatedName("bg")
	@Export("rawHeight")
	public int rawHeight;
	@ObfuscatedName("cw")
	@Export("x")
	public int x;
	@ObfuscatedName("cf")
	@Export("y")
	public int y;
	@ObfuscatedName("cm")
	@Export("width")
	public int width;
	@ObfuscatedName("cn")
	@Export("height")
	public int height;
	@ObfuscatedName("cs")
	public int field3006;
	@ObfuscatedName("cx")
	public int field3011;
	@ObfuscatedName("cr")
	@Export("parentId")
	public int parentId;
	@ObfuscatedName("cd")
	@Export("isHidden")
	public boolean isHidden;
	@ObfuscatedName("ce")
	@Export("scrollX")
	public int scrollX;
	@ObfuscatedName("cq")
	@Export("scrollY")
	public int scrollY;
	@ObfuscatedName("cp")
	@Export("scrollWidth")
	public int scrollWidth;
	@ObfuscatedName("cv")
	@Export("scrollHeight")
	public int scrollHeight;
	@ObfuscatedName("co")
	@Export("color")
	public int color;
	@ObfuscatedName("cl")
	@Export("color2")
	public int color2;
	@ObfuscatedName("cu")
	@Export("mouseOverColor")
	public int mouseOverColor;
	@ObfuscatedName("ch")
	@Export("mouseOverColor2")
	public int mouseOverColor2;
	@ObfuscatedName("ci")
	@Export("fill")
	public boolean fill;
	@ObfuscatedName("ca")
	@ObfuscatedSignature(
		descriptor = "Lum;"
	)
	@Export("fillMode")
	public FillMode fillMode;
	@ObfuscatedName("cb")
	@Export("transparencyTop")
	public int transparencyTop;
	@ObfuscatedName("cg")
	@Export("transparencyBot")
	public int transparencyBot;
	@ObfuscatedName("cj")
	@Export("lineWid")
	public int lineWid;
	@ObfuscatedName("cz")
	public boolean field2962;
	@ObfuscatedName("ct")
	@Export("spriteId2")
	public int spriteId2;
	@ObfuscatedName("cy")
	@Export("spriteId")
	public int spriteId;
	@ObfuscatedName("ck")
	public String field3091;
	@ObfuscatedName("cc")
	@Export("spriteAngle")
	public int spriteAngle;
	@ObfuscatedName("dh")
	@Export("spriteTiling")
	public boolean spriteTiling;
	@ObfuscatedName("dj")
	@Export("outline")
	public int outline;
	@ObfuscatedName("di")
	@Export("spriteShadow")
	public int spriteShadow;
	@ObfuscatedName("du")
	@Export("spriteFlipV")
	public boolean spriteFlipV;
	@ObfuscatedName("dn")
	@Export("spriteFlipH")
	public boolean spriteFlipH;
	@ObfuscatedName("dg")
	@Export("modelType")
	public int modelType;
	@ObfuscatedName("dd")
	@Export("modelId")
	public int modelId;
	@ObfuscatedName("da")
	@Export("modelType2")
	int modelType2;
	@ObfuscatedName("ds")
	@Export("modelId2")
	int modelId2;
	@ObfuscatedName("dy")
	@Export("sequenceId")
	public int sequenceId;
	@ObfuscatedName("dt")
	@Export("sequenceId2")
	public int sequenceId2;
	@ObfuscatedName("dl")
	@Export("modelOffsetX")
	public int modelOffsetX;
	@ObfuscatedName("dk")
	@Export("modelOffsetY")
	public int modelOffsetY;
	@ObfuscatedName("df")
	@Export("modelAngleX")
	public int modelAngleX;
	@ObfuscatedName("dz")
	@Export("modelAngleY")
	public int modelAngleY;
	@ObfuscatedName("dw")
	@Export("modelAngleZ")
	public int modelAngleZ;
	@ObfuscatedName("dv")
	@Export("modelZoom")
	public int modelZoom;
	@ObfuscatedName("dr")
	@Export("modelRotation")
	public int modelRotation;
	@ObfuscatedName("do")
	@Export("rotationKey")
	public int rotationKey;
	@ObfuscatedName("db")
	@ObfuscatedSignature(
		descriptor = "Lmt;"
	)
	public PlayerComposition field3101;
	@ObfuscatedName("dp")
	@Export("modelOrthog")
	public boolean modelOrthog;
	@ObfuscatedName("dm")
	@Export("modelTransparency")
	public boolean modelTransparency;
	@ObfuscatedName("dx")
	@Export("itemQuantityMode")
	public int itemQuantityMode;
	@ObfuscatedName("dq")
	@Export("fontId")
	public int fontId;
	@ObfuscatedName("de")
	@Export("text")
	public String text;
	@ObfuscatedName("dc")
	@Export("text2")
	public String text2;
	@ObfuscatedName("ed")
	@Export("textLineHeight")
	public int textLineHeight;
	@ObfuscatedName("eh")
	@Export("textXAlignment")
	public int textXAlignment;
	@ObfuscatedName("ey")
	@Export("textYAlignment")
	public int textYAlignment;
	@ObfuscatedName("ee")
	@Export("textShadowed")
	public boolean textShadowed;
	@ObfuscatedName("eq")
	@ObfuscatedSignature(
		descriptor = "Lgf;"
	)
	class170 field2952;
	@ObfuscatedName("ej")
	int field2955;
	@ObfuscatedName("ea")
	HashMap field2956;
	@ObfuscatedName("er")
	HashMap field2957;
	@ObfuscatedName("ez")
	@ObfuscatedSignature(
		descriptor = "Lmp;"
	)
	class327 field2958;
	@ObfuscatedName("et")
	@Export("flags")
	public int flags;
	@ObfuscatedName("en")
	public boolean field2969;
	@ObfuscatedName("eb")
	public byte[][] field2977;
	@ObfuscatedName("ei")
	public byte[][] field2978;
	@ObfuscatedName("es")
	public int[] field3047;
	@ObfuscatedName("el")
	public int[] field3046;
	@ObfuscatedName("eu")
	@Export("dataText")
	public String dataText;
	@ObfuscatedName("eg")
	@Export("actions")
	public String[] actions;
	@ObfuscatedName("ex")
	@ObfuscatedSignature(
		descriptor = "Lmi;"
	)
	@Export("parent")
	public Widget parent;
	@ObfuscatedName("eo")
	@Export("dragZoneSize")
	public int dragZoneSize;
	@ObfuscatedName("ew")
	@Export("dragThreshold")
	public int dragThreshold;
	@ObfuscatedName("ep")
	@Export("isScrollBar")
	public boolean isScrollBar;
	@ObfuscatedName("fh")
	@Export("spellActionName")
	public String spellActionName;
	@ObfuscatedName("ft")
	@Export("hasListener")
	public boolean hasListener;
	@ObfuscatedName("fs")
	@Export("onLoad")
	public Object[] onLoad;
	@ObfuscatedName("fl")
	@Export("onClick")
	public Object[] onClick;
	@ObfuscatedName("fe")
	@Export("onClickRepeat")
	public Object[] onClickRepeat;
	@ObfuscatedName("fd")
	@Export("onRelease")
	public Object[] onRelease;
	@ObfuscatedName("fj")
	@Export("onHold")
	public Object[] onHold;
	@ObfuscatedName("fv")
	@Export("onMouseOver")
	public Object[] onMouseOver;
	@ObfuscatedName("fb")
	@Export("onMouseRepeat")
	public Object[] onMouseRepeat;
	@ObfuscatedName("fr")
	@Export("onMouseLeave")
	public Object[] onMouseLeave;
	@ObfuscatedName("fq")
	@Export("onDrag")
	public Object[] onDrag;
	@ObfuscatedName("fp")
	@Export("onDragComplete")
	public Object[] onDragComplete;
	@ObfuscatedName("fg")
	@Export("onTargetEnter")
	public Object[] onTargetEnter;
	@ObfuscatedName("fo")
	@Export("onTargetLeave")
	public Object[] onTargetLeave;
	@ObfuscatedName("fz")
	@Export("onVarTransmit")
	public Object[] onVarTransmit;
	@ObfuscatedName("fu")
	@Export("varTransmitTriggers")
	public int[] varTransmitTriggers;
	@ObfuscatedName("fn")
	@Export("onInvTransmit")
	public Object[] onInvTransmit;
	@ObfuscatedName("fx")
	@Export("invTransmitTriggers")
	public int[] invTransmitTriggers;
	@ObfuscatedName("ff")
	@Export("onStatTransmit")
	public Object[] onStatTransmit;
	@ObfuscatedName("fc")
	@Export("statTransmitTriggers")
	public int[] statTransmitTriggers;
	@ObfuscatedName("fk")
	@Export("onTimer")
	public Object[] onTimer;
	@ObfuscatedName("fm")
	@Export("onOp")
	public Object[] onOp;
	@ObfuscatedName("fy")
	public Object[] field3076;
	@ObfuscatedName("fw")
	@Export("onScroll")
	public Object[] onScroll;
	@ObfuscatedName("fi")
	@Export("onChatTransmit")
	public Object[] onChatTransmit;
	@ObfuscatedName("fa")
	@Export("onKey")
	public Object[] onKey;
	@ObfuscatedName("gu")
	public Object[] field3089;
	@ObfuscatedName("gc")
	public Object[] field3079;
	@ObfuscatedName("gd")
	@Export("onFriendTransmit")
	public Object[] onFriendTransmit;
	@ObfuscatedName("gm")
	@Export("onClanTransmit")
	public Object[] onClanTransmit;
	@ObfuscatedName("gg")
	public Object[] field3082;
	@ObfuscatedName("gw")
	public Object[] field3090;
	@ObfuscatedName("gi")
	@Export("onMiscTransmit")
	public Object[] onMiscTransmit;
	@ObfuscatedName("go")
	@Export("onDialogAbort")
	public Object[] onDialogAbort;
	@ObfuscatedName("gl")
	@Export("onSubChange")
	public Object[] onSubChange;
	@ObfuscatedName("gb")
	@Export("onResize")
	public Object[] onResize;
	@ObfuscatedName("gj")
	@Export("onStockTransmit")
	public Object[] onStockTransmit;
	@ObfuscatedName("ge")
	public Object[] field3081;
	@ObfuscatedName("gs")
	public Object[] field3088;
	@ObfuscatedName("gv")
	@Export("cs1Instructions")
	public int[][] cs1Instructions;
	@ObfuscatedName("gf")
	@Export("cs1Comparisons")
	public int[] cs1Comparisons;
	@ObfuscatedName("gh")
	@Export("cs1ComparisonValues")
	public int[] cs1ComparisonValues;
	@ObfuscatedName("gy")
	@Export("mouseOverRedirect")
	public int mouseOverRedirect;
	@ObfuscatedName("gp")
	public String field3097;
	@ObfuscatedName("gk")
	@Export("buttonText")
	public String buttonText;
	@ObfuscatedName("ga")
	@Export("itemIds")
	public int[] itemIds;
	@ObfuscatedName("gx")
	public int[] field3054;
	@ObfuscatedName("gq")
	@Export("itemId")
	public int itemId;
	@ObfuscatedName("gt")
	@Export("itemQuantity")
	public int itemQuantity;
	@ObfuscatedName("gr")
	@Export("modelFrame")
	public int modelFrame;
	@ObfuscatedName("gz")
	@Export("modelFrameCycle")
	public int modelFrameCycle;
	@ObfuscatedName("gn")
	@ObfuscatedSignature(
		descriptor = "[Lmi;"
	)
	@Export("children")
	public Widget[] children;
	@ObfuscatedName("ht")
	public boolean field2975;
	@ObfuscatedName("ho")
	public boolean field2974;
	@ObfuscatedName("hj")
	public int field3043;
	@ObfuscatedName("hh")
	public int field3041;
	@ObfuscatedName("hi")
	public int field3042;
	@ObfuscatedName("hd")
	public int field3040;
	@ObfuscatedName("hk")
	@Export("rootIndex")
	public int rootIndex;
	@ObfuscatedName("hz")
	@Export("cycle")
	public int cycle;
	@ObfuscatedName("hl")
	public int[] field3055;
	@ObfuscatedName("hg")
	@Export("noClickThrough")
	public boolean noClickThrough;
	@ObfuscatedName("hu")
	@Export("noScrollThrough")
	public boolean noScrollThrough;
	@ObfuscatedName("he")
	@Export("prioritizeMenuEntry")
	public boolean prioritizeMenuEntry;

	static {
		Widget_cachedSprites = new EvictingDualNodeHashTable(200);
		Widget_cachedModels = new EvictingDualNodeHashTable(50);
		Widget_cachedFonts = new EvictingDualNodeHashTable(20);
		Widget_cachedSpriteMasks = new EvictingDualNodeHashTable(8);
		field2950 = new class423(10, class421.field3766);
		field2951 = new class423(10, class421.field3766);
		field2945 = false;
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
		this.field3006 = 1;
		this.field3011 = 1;
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
		this.field2962 = false;
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
		this.field2955 = -1;
		this.flags = 0;
		this.field2969 = false;
		this.dataText = "";
		this.parent = null;
		this.dragZoneSize = 0;
		this.dragThreshold = 0;
		this.isScrollBar = false;
		this.spellActionName = "";
		this.hasListener = false;
		this.mouseOverRedirect = -1;
		this.field3097 = "";
		this.buttonText = "Ok";
		this.itemId = -1;
		this.itemQuantity = 0;
		this.modelFrame = 0;
		this.modelFrameCycle = 0;
		this.field2975 = false;
		this.field2974 = false;
		this.field3043 = -1;
		this.field3041 = 0;
		this.field3042 = 0;
		this.field3040 = 0;
		this.rootIndex = -1;
		this.cycle = -1;
		this.noClickThrough = false;
		this.noScrollThrough = false;
		this.prioritizeMenuEntry = false;
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(Ltm;B)V",
		garbageValue = "-122"
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
			this.field3097 = var1.readStringCp1252NullTerminated();
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

	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		descriptor = "(Ltm;I)V",
		garbageValue = "-1617832353"
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
			this.field2962 = var1.readUnsignedByte() == 1;
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

	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "(Ltm;I)[Ljava/lang/Object;",
		garbageValue = "-631733803"
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

	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		descriptor = "(Ltm;I)[I",
		garbageValue = "132481992"
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

	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "(ZLev;I)Lui;",
		garbageValue = "1752459087"
	)
	@Export("getSprite")
	public SpritePixels getSprite(boolean var1, UrlRequester var2) {
		field2945 = false;
		if (this.field3091 != null) {
			SpritePixels var3 = this.method1818(var2);
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
				var6 = Tiles.SpriteBuffer_getSprite(Language.Widget_spritesArchive, var7, 0);
				if (var6 == null) {
					field2945 = true;
					return null;
				} else {
					this.method1821(var6);
					Widget_cachedSprites.put(var6, var4);
					return var6;
				}
			}
		}
	}

	@ObfuscatedName("af")
	@ObfuscatedSignature(
		descriptor = "(Lev;B)Lui;",
		garbageValue = "24"
	)
	SpritePixels method1818(UrlRequester var1) {
		if (!this.method1820()) {
			return this.method1819(var1);
		} else {
			String var2 = this.field3091 + (this.spriteFlipV ? 1 : 0) + (this.spriteFlipH ? 1 : 0) + this.outline + this.spriteShadow;
			SpritePixels var3 = (SpritePixels)field2951.method2180(var2);
			if (var3 == null) {
				SpritePixels var4 = this.method1819(var1);
				if (var4 != null) {
					var3 = var4.method2657();
					this.method1821(var3);
					field2951.method2181(var2, var3);
				}
			}

			return var3;
		}
	}

	@ObfuscatedName("ad")
	@ObfuscatedSignature(
		descriptor = "(Lev;I)Lui;",
		garbageValue = "-853434695"
	)
	SpritePixels method1819(UrlRequester var1) {
		if (this.field3091 != null && var1 != null) {
			class326 var2 = (class326)field2950.method2180(this.field3091);
			if (var2 == null) {
				var2 = new class326(this.field3091, var1);
				field2950.method2181(this.field3091, var2);
			}

			return var2.method1715();
		} else {
			return null;
		}
	}

	@ObfuscatedName("aq")
	@ObfuscatedSignature(
		descriptor = "(B)Z",
		garbageValue = "-32"
	)
	boolean method1820() {
		return this.spriteFlipV || this.spriteFlipH || this.outline != 0 || this.spriteShadow != 0;
	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "(Lui;B)V",
		garbageValue = "-60"
	)
	void method1821(SpritePixels var1) {
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

	@ObfuscatedName("an")
	@ObfuscatedSignature(
		descriptor = "(I)Lpi;",
		garbageValue = "1973823248"
	)
	@Export("getFont")
	public Font getFont() {
		field2945 = false;
		if (this.fontId == -1) {
			return null;
		} else {
			Font var1 = (Font)Widget_cachedFonts.get((long)this.fontId);
			if (var1 != null) {
				return var1;
			} else {
				var1 = LoginPacket.method1613(Language.Widget_spritesArchive, class155.Widget_fontsArchive, this.fontId, 0);
				if (var1 != null) {
					Widget_cachedFonts.put(var1, (long)this.fontId);
				} else {
					field2945 = true;
				}

				return var1;
			}
		}
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(Lib;IZLmt;Lhw;Lhq;B)Ljr;",
		garbageValue = "-43"
	)
	@Export("getModel")
	public Model getModel(SequenceDefinition var1, int var2, boolean var3, PlayerComposition var4, NPCComposition var5, NewShit var6) {
		field2945 = false;
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
			if (var6 != null && var6.field1581 && var7 == 6) {
				var7 = 3;
			}

			long var9 = (long)(var8 + (var7 << 16));
			if (var6 != null) {
				var9 |= var6.field1582 << 20;
			}

			Model var11 = (Model)Widget_cachedModels.get(var9);
			if (var11 == null) {
				ModelData var12 = null;
				int var13 = 64;
				int var14 = 768;
				switch(var7) {
				case 1:
					var12 = ModelData.ModelData_get(class47.field226, var8, 0);
					break;
				case 2:
					var12 = class90.getNpcDefinition(var8).method986((NewShit)null);
					break;
				case 3:
					var12 = var4 != null ? var4.getModelData() : null;
					break;
				case 4:
					ItemComposition var15 = InvDefinition.ItemDefinition_get(var8);
					var12 = var15.getModelData(10);
					var13 += var15.field1812;
					var14 += var15.field1809;
				case 5:
				default:
					break;
				case 6:
					var12 = class90.getNpcDefinition(var8).method986(var6);
				}

				if (var12 == null) {
					field2945 = true;
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

	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "(ZI)Lme;",
		garbageValue = "1022020243"
	)
	@Export("getSpriteMask")
	public SpriteMask getSpriteMask(boolean var1) {
		if (this.spriteId == -1) {
			var1 = false;
		}

		int var2 = var1 ? this.spriteId * -329704335 * -243850095 : this.spriteId2 * 1694560891 * -1390207821;
		if (var2 == -1) {
			return null;
		} else {
			long var3 = ((long)this.spriteShadow << 40) + ((long)this.outline << 36) + (long)var2 + ((this.spriteFlipV ? 1L : 0L) << 38) + ((this.spriteFlipH ? 1L : 0L) << 39);
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

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "(ILjava/lang/String;I)V",
		garbageValue = "-1578890937"
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

	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "(B)Z",
		garbageValue = "10"
	)
	public boolean method1826() {
		return !this.isIf3 || this.type == 0 || this.type == 11 || this.hasListener || this.contentType == 1338 || this.type == 12;
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(S)Z",
		garbageValue = "13293"
	)
	public boolean method1827() {
		return this.type == 11 || this.type == 12;
	}

	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;Lev;J)V"
	)
	public void method1828(String var1, UrlRequester var2, long var3) {
		if (this.type == 11 && var3 != -1L) {
			var1 = var1.replaceAll("%userid%", Long.toString(var3));
			this.field2952 = new class170();
			if (!this.field2952.method881(var1, var2)) {
				this.field2952 = null;
			} else {
				if (this.field2956 == null || this.field2957 == null) {
					this.method1830();
				}

			}
		}
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;Lev;I)V",
		garbageValue = "1047552277"
	)
	public void method1829(String var1, UrlRequester var2) {
		if (this.type == 11 && var1 != null) {
			this.field2952 = new class170();
			this.field2952.method899(var1, var2);
		}
	}

	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		descriptor = "(S)V",
		garbageValue = "-11260"
	)
	void method1830() {
		this.field2956 = new HashMap();
		this.field2957 = new HashMap();
	}

	@ObfuscatedName("av")
	@ObfuscatedSignature(
		descriptor = "(III)V",
		garbageValue = "1873888023"
	)
	public void method1831(int var1, int var2) {
		if (this.type == 11) {
			if (this.field2956 == null) {
				this.method1830();
			}

			this.field2956.put(var1, var2);
		}
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;II)V",
		garbageValue = "1531233902"
	)
	public void method1832(String var1, int var2) {
		if (this.type == 11) {
			if (this.field2957 == null) {
				this.method1830();
			}

			this.field2957.put(var1, var2);
		}
	}

	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "(IIIII)Z",
		garbageValue = "182136505"
	)
	public boolean method1833(int var1, int var2, int var3, int var4) {
		if (this.type == 11 && this.field2952 != null && this.method1834()) {
			var1 -= var3;
			var2 -= var4;
			int var5 = (int)(this.field2952.method889()[0] * (float)this.width);
			int var6 = (int)(this.field2952.method889()[1] * (float)this.height);
			int var7 = var5 + (int)(this.field2952.method889()[2] * (float)this.width);
			int var8 = var6 + (int)(this.field2952.method889()[3] * (float)this.height);
			return var1 >= var5 && var2 >= var6 && var1 < var7 && var2 < var8;
		} else {
			return false;
		}
	}

	@ObfuscatedName("bh")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "-1140949643"
	)
	public boolean method1834() {
		return this.field2955 == 2;
	}

	@ObfuscatedName("bj")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;I)I",
		garbageValue = "-2121469782"
	)
	public int method1835(String var1) {
		return this.type == 11 && this.field2952 != null && this.method1834() ? this.field2952.method884(var1) : -1;
	}

	@ObfuscatedName("bk")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;I)Ljava/lang/String;",
		garbageValue = "-1095190564"
	)
	public String method1836(String var1) {
		return this.type == 11 && this.field2952 != null && this.method1834() ? this.field2952.method885(var1) : null;
	}

	@ObfuscatedName("bv")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "44"
	)
	public int method1837() {
		return this.field2957 != null && this.field2957.size() > 0 ? 1 : 0;
	}

	@ObfuscatedName("bt")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "47"
	)
	public int method1838() {
		if (this.type == 11 && this.field2952 != null && this.field2957 != null && !this.field2957.isEmpty()) {
			String var1 = this.field2952.method888();
			return var1 != null && this.field2957.containsKey(this.field2952.method888()) ? (Integer)this.field2957.get(var1) : -1;
		} else {
			return -1;
		}
	}

	@ObfuscatedName("bd")
	@ObfuscatedSignature(
		descriptor = "(S)Ljava/lang/String;",
		garbageValue = "11076"
	)
	public String method1839() {
		if (this.type == 11 && this.field2952 != null) {
			String var1 = this.field2952.method888();
			Iterator var2 = this.field2952.method890().iterator();

			while (var2.hasNext()) {
				class181 var3 = (class181)var2.next();
				String var4 = String.format("%%%S%%", var3.method925());
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

	@ObfuscatedName("by")
	@ObfuscatedSignature(
		descriptor = "(I)[I",
		garbageValue = "-2142205826"
	)
	public int[] method1840() {
		if (this.type == 11 && this.field2952 != null) {
			int[] var1 = new int[3];
			int var2 = 0;
			Iterator var3 = this.field2952.method890().iterator();

			while (var3.hasNext()) {
				class181 var4 = (class181)var3.next();
				if (!var4.method925().equals("user_id")) {
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

	@ObfuscatedName("bs")
	@ObfuscatedSignature(
		descriptor = "(Lev;B)Z",
		garbageValue = "84"
	)
	public boolean method1841(UrlRequester var1) {
		if (this.type == 11 && this.field2952 != null) {
			this.field2952.method882(var1);
			if (this.field2952.method883() != this.field2955) {
				this.field2955 = this.field2952.method883();
				if (this.field2955 >= 100) {
					return true;
				}

				if (this.field2955 == 2) {
					this.method1842();
					return true;
				}
			}

			return false;
		} else {
			return false;
		}
	}

	@ObfuscatedName("bm")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "757418391"
	)
	void method1842() {
		this.noClickThrough = true;
		ArrayList var1 = this.field2952.method886();
		ArrayList var2 = this.field2952.method887();
		int var3 = var1.size() + var2.size();
		this.children = new Widget[var3];
		int var4 = 0;

		Iterator var5;
		float[] var9;
		Widget var10;
		for (var5 = var1.iterator(); var5.hasNext(); this.children[var4++] = var10) {
			class176 var6 = (class176)var5.next();
			var9 = var6.field1470;
			var10 = new Widget();
			var10.type = 5;
			var10.parentId = this.id;
			var10.childIndex = var4;
			var10.isIf3 = true;
			var10.xAlignment = 0;
			var10.yAlignment = 0;
			var10.widthAlignment = 0;
			var10.heightAlignment = 0;
			var10.rawX = (int)(var9[0] * (float)this.width);
			var10.rawY = (int)(var9[1] * (float)this.height);
			var10.rawWidth = (int)(var9[2] * (float)this.width);
			var10.rawHeight = (int)((float)this.height * var9[3]);
			var10.field3091 = var6.field1469.method667();
			class326 var11 = new class326(var6.field1469);
			field2950.method2181(var10.field3091, var11);
		}

		for (var5 = var2.iterator(); var5.hasNext(); this.children[var4++] = var10) {
			class177 var12 = (class177)var5.next();
			var9 = var12.field1472;
			var10 = new Widget();
			var10.type = 4;
			var10.parentId = this.id;
			var10.childIndex = var4;
			var10.isIf3 = true;
			var10.xAlignment = 0;
			var10.yAlignment = 0;
			var10.widthAlignment = 0;
			var10.heightAlignment = 0;
			var10.rawX = (int)(var9[0] * (float)this.width);
			var10.rawY = (int)(var9[1] * (float)this.height);
			var10.rawWidth = (int)((float)this.width * var9[2]);
			var10.rawHeight = (int)(var9[3] * (float)this.height);
			var10.text = var12.field1476;
			var10.fontId = (Integer)this.field2956.get(var12.field1474);
			var10.textXAlignment = var12.field1473;
			var10.textYAlignment = var12.field1475;
		}

	}

	@ObfuscatedName("bf")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "-109"
	)
	public void method1843() {
		this.field2958 = new class327();

		for (int var1 = 1; var1 <= 12; ++var1) {
			this.field2958.field2896.method96(var1, 0);
		}

		for (char var2 = 0; var2 < ' '; ++var2) {
			this.field2958.field2896.method97(var2, 0);
		}

		this.field2958.field2896.method97('\u0080', 0);
		this.field2958.field2896.method96(82, 2);
		this.field2958.field2896.method96(81, 2);
		this.field2958.field2896.method96(86, 2);
	}

	@ObfuscatedName("bq")
	@ObfuscatedSignature(
		descriptor = "(B)Lmb;",
		garbageValue = "-14"
	)
	public class329 method1844() {
		return this.field2958 != null ? this.field2958.field2902 : null;
	}

	@ObfuscatedName("ba")
	@ObfuscatedSignature(
		descriptor = "(B)Lml;",
		garbageValue = "25"
	)
	public class324 method1845() {
		return this.field2958 != null ? this.field2958.field2897 : null;
	}

	@ObfuscatedName("bl")
	@ObfuscatedSignature(
		descriptor = "(I)Lbj;",
		garbageValue = "1077698230"
	)
	public class27 method1846() {
		return this.field2958 != null ? this.field2958.field2896 : null;
	}

	@ObfuscatedName("bp")
	@ObfuscatedSignature(
		descriptor = "(I)Lmp;",
		garbageValue = "-1932900136"
	)
	public class327 method1847() {
		return this.field2958;
	}

	@ObfuscatedName("bu")
	@ObfuscatedSignature(
		descriptor = "(Lmb;B)Z",
		garbageValue = "1"
	)
	boolean method1848(class329 var1) {
		boolean var2 = false;
		if (this.text != null && !this.text.isEmpty()) {
			var2 |= var1.method1733(class157.method832(this.text));
			this.text = "";
		}

		if (this.text2 != null && !this.text2.isEmpty()) {
			var2 |= var1.method1734(class157.method832(this.text2));
			this.text2 = "";
		}

		return var2;
	}

	@ObfuscatedName("bo")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "1006338343"
	)
	public boolean method1849() {
		class329 var1 = this.method1844();
		if (var1 == null) {
			return false;
		} else {
			boolean var2 = false;
			if (!var1.method1787() && this.fontId != -1) {
				int var3 = var1.method1788();
				int var4 = var1.method1789();
				int var5 = var1.method1786();
				int var6 = var1.method1785();
				Font var7 = this.getFont();
				if (var7 != null) {
					var2 |= var1.method1735(var7);
					var2 |= this.method1848(var1);
					var2 |= var1.method1740(var3, var4);
					var2 |= var1.method1755(var5, var6);
				}
			} else if (var1.method1787()) {
				var2 |= this.method1848(var1);
			}

			var1.method1730();
			return var2;
		}
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(IIII)I",
		garbageValue = "-1138526298"
	)
	public static int method1812(int var0, int var1, int var2) {
		int var3 = Projectile.method430(var2 - var1 + 1);
		var3 <<= var1;
		var0 |= var3;
		return var0;
	}
}