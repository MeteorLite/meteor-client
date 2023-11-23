import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

@ObfuscatedName("nn")
@Implements("Widget")
public class Widget extends Node {
	@ObfuscatedName("af")
	public static boolean field2976;
	@ObfuscatedName("be")
	@Export("isIf3")
	public boolean isIf3;
	@ObfuscatedName("bd")
	@Export("id")
	public int id;
	@ObfuscatedName("bl")
	@Export("childIndex")
	public int childIndex;
	@ObfuscatedName("bi")
	String field2981;
	@ObfuscatedName("bv")
	@Export("type")
	public int type;
	@ObfuscatedName("bf")
	@Export("buttonType")
	public int buttonType;
	@ObfuscatedName("bg")
	@Export("contentType")
	public int contentType;
	@ObfuscatedName("ba")
	@Export("xAlignment")
	public int xAlignment;
	@ObfuscatedName("bm")
	@Export("yAlignment")
	public int yAlignment;
	@ObfuscatedName("bp")
	@Export("widthAlignment")
	public int widthAlignment;
	@ObfuscatedName("bw")
	@Export("heightAlignment")
	public int heightAlignment;
	@ObfuscatedName("bj")
	@Export("rawX")
	public int rawX;
	@ObfuscatedName("bn")
	@Export("rawY")
	public int rawY;
	@ObfuscatedName("bo")
	@Export("rawWidth")
	public int rawWidth;
	@ObfuscatedName("bt")
	@Export("rawHeight")
	public int rawHeight;
	@ObfuscatedName("bu")
	@Export("x")
	public int x;
	@ObfuscatedName("by")
	@Export("y")
	public int y;
	@ObfuscatedName("bh")
	@Export("width")
	public int width;
	@ObfuscatedName("bz")
	@Export("height")
	public int height;
	@ObfuscatedName("bc")
	public int field3006;
	@ObfuscatedName("bs")
	public int field3020;
	@ObfuscatedName("bx")
	@Export("parentId")
	public int parentId;
	@ObfuscatedName("bb")
	@Export("isHidden")
	public boolean isHidden;
	@ObfuscatedName("bk")
	@Export("scrollX")
	public int scrollX;
	@ObfuscatedName("br")
	@Export("scrollY")
	public int scrollY;
	@ObfuscatedName("bq")
	@Export("scrollWidth")
	public int scrollWidth;
	@ObfuscatedName("cf")
	@Export("scrollHeight")
	public int scrollHeight;
	@ObfuscatedName("cg")
	@Export("color")
	public int color;
	@ObfuscatedName("cv")
	@Export("color2")
	public int color2;
	@ObfuscatedName("cx")
	@Export("mouseOverColor")
	public int mouseOverColor;
	@ObfuscatedName("cp")
	@Export("mouseOverColor2")
	public int mouseOverColor2;
	@ObfuscatedName("ce")
	@Export("fill")
	public boolean fill;
	@ObfuscatedName("ci")
	@ObfuscatedSignature(
		descriptor = "Luk;"
	)
	@Export("fillMode")
	public FillMode fillMode;
	@ObfuscatedName("ct")
	@Export("transparencyTop")
	public int transparencyTop;
	@ObfuscatedName("cw")
	@Export("transparencyBot")
	public int transparencyBot;
	@ObfuscatedName("cq")
	@Export("lineWid")
	public int lineWid;
	@ObfuscatedName("cl")
	public boolean field2989;
	@ObfuscatedName("cs")
	@Export("spriteId2")
	public int spriteId2;
	@ObfuscatedName("co")
	@Export("spriteId")
	public int spriteId;
	@ObfuscatedName("cm")
	public String field3117;
	@ObfuscatedName("cn")
	@Export("spriteAngle")
	public int spriteAngle;
	@ObfuscatedName("cr")
	@Export("spriteTiling")
	public boolean spriteTiling;
	@ObfuscatedName("cj")
	@Export("outline")
	public int outline;
	@ObfuscatedName("ca")
	@Export("spriteShadow")
	public int spriteShadow;
	@ObfuscatedName("cc")
	@Export("spriteFlipV")
	public boolean spriteFlipV;
	@ObfuscatedName("cu")
	@Export("spriteFlipH")
	public boolean spriteFlipH;
	@ObfuscatedName("ch")
	@Export("modelType")
	public int modelType;
	@ObfuscatedName("cb")
	@Export("modelId")
	public int modelId;
	@ObfuscatedName("cz")
	@Export("modelType2")
	int modelType2;
	@ObfuscatedName("cy")
	@Export("modelId2")
	int modelId2;
	@ObfuscatedName("ck")
	@Export("sequenceId")
	public int sequenceId;
	@ObfuscatedName("cd")
	@Export("sequenceId2")
	public int sequenceId2;
	@ObfuscatedName("dt")
	@Export("modelOffsetX")
	public int modelOffsetX;
	@ObfuscatedName("di")
	@Export("modelOffsetY")
	public int modelOffsetY;
	@ObfuscatedName("dk")
	@Export("modelAngleX")
	public int modelAngleX;
	@ObfuscatedName("dd")
	@Export("modelAngleY")
	public int modelAngleY;
	@ObfuscatedName("dx")
	@Export("modelAngleZ")
	public int modelAngleZ;
	@ObfuscatedName("dh")
	@Export("modelZoom")
	public int modelZoom;
	@ObfuscatedName("du")
	@Export("modelRotation")
	public int modelRotation;
	@ObfuscatedName("dg")
	@Export("rotationKey")
	public int rotationKey;
	@ObfuscatedName("dc")
	@ObfuscatedSignature(
		descriptor = "Lnb;"
	)
	public PlayerComposition field3125;
	@ObfuscatedName("do")
	@Export("modelOrthog")
	public boolean modelOrthog;
	@ObfuscatedName("db")
	@Export("modelTransparency")
	public boolean modelTransparency;
	@ObfuscatedName("dm")
	@Export("itemQuantityMode")
	public int itemQuantityMode;
	@ObfuscatedName("dr")
	@Export("fontId")
	public int fontId;
	@ObfuscatedName("ds")
	@Export("text")
	public String text;
	@ObfuscatedName("da")
	@Export("text2")
	public String text2;
	@ObfuscatedName("dw")
	@Export("textLineHeight")
	public int textLineHeight;
	@ObfuscatedName("dp")
	@Export("textXAlignment")
	public int textXAlignment;
	@ObfuscatedName("df")
	@Export("textYAlignment")
	public int textYAlignment;
	@ObfuscatedName("dv")
	@Export("textShadowed")
	public boolean textShadowed;
	@ObfuscatedName("dz")
	@ObfuscatedSignature(
		descriptor = "Lic;"
	)
	class208 field2977;
	@ObfuscatedName("dl")
	int field2980;
	@ObfuscatedName("de")
	HashMap field2982;
	@ObfuscatedName("dn")
	HashMap field2983;
	@ObfuscatedName("dj")
	@ObfuscatedSignature(
		descriptor = "Lnq;"
	)
	class339 field2984;
	@ObfuscatedName("dy")
	@Export("flags")
	public int flags;
	@ObfuscatedName("ec")
	public boolean field2995;
	@ObfuscatedName("ew")
	public byte[][] field3003;
	@ObfuscatedName("ex")
	public byte[][] field3004;
	@ObfuscatedName("ev")
	public int[] field3073;
	@ObfuscatedName("ek")
	public int[] field3072;
	@ObfuscatedName("es")
	@Export("dataText")
	public String dataText;
	@ObfuscatedName("ea")
	@Export("actions")
	public String[] actions;
	@ObfuscatedName("en")
	@ObfuscatedSignature(
		descriptor = "Lnn;"
	)
	@Export("parent")
	public Widget parent;
	@ObfuscatedName("eh")
	@Export("dragZoneSize")
	public int dragZoneSize;
	@ObfuscatedName("ei")
	@Export("dragThreshold")
	public int dragThreshold;
	@ObfuscatedName("et")
	@Export("isScrollBar")
	public boolean isScrollBar;
	@ObfuscatedName("er")
	@Export("spellActionName")
	public String spellActionName;
	@ObfuscatedName("ez")
	@Export("hasListener")
	public boolean hasListener;
	@ObfuscatedName("eu")
	@Export("onLoad")
	public Object[] onLoad;
	@ObfuscatedName("eg")
	@Export("onClick")
	public Object[] onClick;
	@ObfuscatedName("ey")
	@Export("onClickRepeat")
	public Object[] onClickRepeat;
	@ObfuscatedName("eb")
	@Export("onRelease")
	public Object[] onRelease;
	@ObfuscatedName("ed")
	@Export("onHold")
	public Object[] onHold;
	@ObfuscatedName("eq")
	@Export("onMouseOver")
	public Object[] onMouseOver;
	@ObfuscatedName("ee")
	@Export("onMouseRepeat")
	public Object[] onMouseRepeat;
	@ObfuscatedName("ej")
	@Export("onMouseLeave")
	public Object[] onMouseLeave;
	@ObfuscatedName("ep")
	@Export("onDrag")
	public Object[] onDrag;
	@ObfuscatedName("fd")
	@Export("onDragComplete")
	public Object[] onDragComplete;
	@ObfuscatedName("fm")
	@Export("onTargetEnter")
	public Object[] onTargetEnter;
	@ObfuscatedName("fa")
	@Export("onTargetLeave")
	public Object[] onTargetLeave;
	@ObfuscatedName("fq")
	@Export("onVarTransmit")
	public Object[] onVarTransmit;
	@ObfuscatedName("fe")
	@Export("varTransmitTriggers")
	public int[] varTransmitTriggers;
	@ObfuscatedName("ff")
	@Export("onInvTransmit")
	public Object[] onInvTransmit;
	@ObfuscatedName("fb")
	@Export("invTransmitTriggers")
	public int[] invTransmitTriggers;
	@ObfuscatedName("fr")
	@Export("onStatTransmit")
	public Object[] onStatTransmit;
	@ObfuscatedName("fi")
	@Export("statTransmitTriggers")
	public int[] statTransmitTriggers;
	@ObfuscatedName("fo")
	@Export("onTimer")
	public Object[] onTimer;
	@ObfuscatedName("fw")
	@Export("onOp")
	public Object[] onOp;
	@ObfuscatedName("fj")
	public Object[] field3098;
	@ObfuscatedName("fh")
	@Export("onScroll")
	public Object[] onScroll;
	@ObfuscatedName("fg")
	@Export("onChatTransmit")
	public Object[] onChatTransmit;
	@ObfuscatedName("fl")
	@Export("onKey")
	public Object[] onKey;
	@ObfuscatedName("fs")
	public Object[] field3107;
	@ObfuscatedName("ft")
	public Object[] field3108;
	@ObfuscatedName("fv")
	@Export("onFriendTransmit")
	public Object[] onFriendTransmit;
	@ObfuscatedName("fp")
	@Export("onClanTransmit")
	public Object[] onClanTransmit;
	@ObfuscatedName("fk")
	public Object[] field3099;
	@ObfuscatedName("fz")
	public Object[] field3114;
	@ObfuscatedName("fx")
	@Export("onMiscTransmit")
	public Object[] onMiscTransmit;
	@ObfuscatedName("fu")
	@Export("onDialogAbort")
	public Object[] onDialogAbort;
	@ObfuscatedName("fy")
	@Export("onSubChange")
	public Object[] onSubChange;
	@ObfuscatedName("fn")
	@Export("onResize")
	public Object[] onResize;
	@ObfuscatedName("fc")
	@Export("onStockTransmit")
	public Object[] onStockTransmit;
	@ObfuscatedName("gm")
	public Object[] field3115;
	@ObfuscatedName("gw")
	public Object[] field3116;
	@ObfuscatedName("gl")
	@Export("cs1Instructions")
	public int[][] cs1Instructions;
	@ObfuscatedName("ge")
	@Export("cs1Comparisons")
	public int[] cs1Comparisons;
	@ObfuscatedName("gs")
	@Export("cs1ComparisonValues")
	public int[] cs1ComparisonValues;
	@ObfuscatedName("gi")
	@Export("mouseOverRedirect")
	public int mouseOverRedirect;
	@ObfuscatedName("gp")
	public String field3122;
	@ObfuscatedName("gq")
	@Export("buttonText")
	public String buttonText;
	@ObfuscatedName("gn")
	@Export("itemIds")
	public int[] itemIds;
	@ObfuscatedName("gb")
	public int[] field3077;
	@ObfuscatedName("gu")
	@Export("itemId")
	public int itemId;
	@ObfuscatedName("ga")
	@Export("itemQuantity")
	public int itemQuantity;
	@ObfuscatedName("gf")
	@Export("modelFrame")
	public int modelFrame;
	@ObfuscatedName("gx")
	@Export("modelFrameCycle")
	public int modelFrameCycle;
	@ObfuscatedName("gz")
	@ObfuscatedSignature(
		descriptor = "[Lnn;"
	)
	@Export("children")
	public Widget[] children;
	@ObfuscatedName("gt")
	public boolean field3001;
	@ObfuscatedName("gg")
	public boolean field2999;
	@ObfuscatedName("gj")
	public int field3065;
	@ObfuscatedName("gy")
	public int field3071;
	@ObfuscatedName("gv")
	public int field3069;
	@ObfuscatedName("gc")
	public int field3062;
	@ObfuscatedName("gr")
	@Export("rootIndex")
	public int rootIndex;
	@ObfuscatedName("gk")
	@Export("cycle")
	public int cycle;
	@ObfuscatedName("go")
	public int[] field3080;
	@ObfuscatedName("gh")
	@Export("noClickThrough")
	public boolean noClickThrough;
	@ObfuscatedName("gd")
	@Export("noScrollThrough")
	public boolean noScrollThrough;
	@ObfuscatedName("hb")
	@Export("prioritizeMenuEntry")
	public boolean prioritizeMenuEntry;

	static {
		field2976 = false;
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
		this.field3020 = 1;
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
		this.field2989 = false;
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
		this.field2980 = -1;
		this.flags = 0;
		this.field2995 = false;
		this.dataText = "";
		this.parent = null;
		this.dragZoneSize = 0;
		this.dragThreshold = 0;
		this.isScrollBar = false;
		this.spellActionName = "";
		this.hasListener = false;
		this.mouseOverRedirect = -1;
		this.field3122 = "";
		this.buttonText = "Ok";
		this.itemId = -1;
		this.itemQuantity = 0;
		this.modelFrame = 0;
		this.modelFrameCycle = 0;
		this.field3001 = false;
		this.field2999 = false;
		this.field3065 = -1;
		this.field3071 = 0;
		this.field3069 = 0;
		this.field3062 = 0;
		this.rootIndex = -1;
		this.cycle = -1;
		this.noClickThrough = false;
		this.noScrollThrough = false;
		this.prioritizeMenuEntry = false;
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(Luj;I)V",
		garbageValue = "1076912273"
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
			this.field3122 = var1.readStringCp1252NullTerminated();
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

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(Luj;I)V",
		garbageValue = "167197032"
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
			this.field2989 = var1.readUnsignedByte() == 1;
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

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(Luj;I)V",
		garbageValue = "361710485"
	)
	void method1841(Buffer var1) {
		this.field2981 = var1.readStringCp1252NullTerminated();
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(Luj;I)[Ljava/lang/Object;",
		garbageValue = "-1864963770"
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

	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "(Luj;I)[I",
		garbageValue = "1916026116"
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

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(Lmr;ZLel;I)Luz;",
		garbageValue = "-1408001366"
	)
	@Export("getSprite")
	public SpritePixels getSprite(WidgetDefinition var1, boolean var2, UrlRequester var3) {
		field2976 = false;
		if (this.field3117 != null) {
			SpritePixels var4 = this.method1845(var1, var3);
			if (var4 != null) {
				return var4;
			}
		}

		int var8;
		if (var2) {
			var8 = this.spriteId;
		} else {
			var8 = this.spriteId2;
		}

		if (var8 == -1) {
			return null;
		} else {
			long var5 = ((long)this.spriteShadow << 40) + ((this.spriteFlipH ? 1L : 0L) << 39) + ((this.spriteFlipV ? 1L : 0L) << 38) + ((long)this.outline << 36) + (long)var8;
			SpritePixels var7 = (SpritePixels)var1.Widget_cachedSprites.get(var5);
			if (var7 != null) {
				return var7;
			} else {
				var7 = IgnoreList.SpriteBuffer_getSprite(var1.field2915, var8, 0);
				if (var7 == null) {
					field2976 = true;
					return null;
				} else {
					this.method1848(var7);
					var1.Widget_cachedSprites.put(var7, var5);
					return var7;
				}
			}
		}
	}

	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "(Lmr;Lel;I)Luz;",
		garbageValue = "243499919"
	)
	SpritePixels method1845(WidgetDefinition var1, UrlRequester var2) {
		if (!this.method1847()) {
			return this.method1846(var1, var2);
		} else {
			String var3 = this.field3117 + (this.spriteFlipV ? 1 : 0) + (this.spriteFlipH ? 1 : 0) + this.outline + this.spriteShadow;
			SpritePixels var4 = (SpritePixels)var1.field2918.method2196(var3);
			if (var4 == null) {
				SpritePixels var5 = this.method1846(var1, var2);
				if (var5 != null) {
					var4 = var5.method2674();
					this.method1848(var4);
					var1.field2918.method2197(var3, var4);
				}
			}

			return var4;
		}
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(Lmr;Lel;I)Luz;",
		garbageValue = "769156512"
	)
	SpritePixels method1846(WidgetDefinition var1, UrlRequester var2) {
		if (this.field3117 != null && var2 != null) {
			class338 var3 = (class338)var1.field2919.method2196(this.field3117);
			if (var3 == null) {
				var3 = new class338(this.field3117, var2);
				var1.field2919.method2197(this.field3117, var3);
			}

			return var3.method1742();
		} else {
			return null;
		}
	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "623493870"
	)
	boolean method1847() {
		return this.spriteFlipV || this.spriteFlipH || this.outline != 0 || this.spriteShadow != 0;
	}

	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "(Luz;I)V",
		garbageValue = "-891883391"
	)
	void method1848(SpritePixels var1) {
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

	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		descriptor = "(Lmr;I)Lpf;",
		garbageValue = "1649883355"
	)
	@Export("getFont")
	public Font getFont(WidgetDefinition var1) {
		field2976 = false;
		if (this.fontId == -1) {
			return null;
		} else {
			Font var2 = (Font)var1.Widget_cachedFonts.get((long)this.fontId);
			if (var2 != null) {
				return var2;
			} else {
				AbstractArchive var4 = var1.field2915;
				AbstractArchive var5 = var1.field2913;
				int var6 = this.fontId;
				byte[] var8 = var4.takeFile(var6, 0);
				boolean var7;
				if (var8 == null) {
					var7 = false;
				} else {
					class162.SpriteBuffer_decode(var8);
					var7 = true;
				}

				Font var3;
				if (!var7) {
					var3 = null;
				} else {
					var3 = WorldMapArea.method1229(var5.takeFile(var6, 0));
				}

				if (var3 != null) {
					var1.Widget_cachedFonts.put(var3, (long)this.fontId);
				} else {
					field2976 = true;
				}

				return var3;
			}
		}
	}

	@ObfuscatedName("av")
	@ObfuscatedSignature(
		descriptor = "(Lmr;Lhx;IZLnb;Lhw;Lhf;B)Lka;",
		garbageValue = "52"
	)
	@Export("getModel")
	public Model getModel(WidgetDefinition var1, SequenceDefinition var2, int var3, boolean var4, PlayerComposition var5, NPCComposition var6, NewShit var7) {
		field2976 = false;
		int var8;
		int var9;
		if (var4) {
			var8 = this.modelType2;
			var9 = this.modelId2;
		} else {
			var8 = this.modelType;
			var9 = this.modelId;
		}

		if (var8 == 6) {
			if (var6 == null) {
				return null;
			}

			var9 = var6.id;
		}

		if (var8 == 0) {
			return null;
		} else if (var8 == 1 && var9 == -1) {
			return null;
		} else {
			if (var7 != null && var7.field1530 && var8 == 6) {
				var8 = 3;
			}

			long var10 = (long)(var9 + (var8 << 16));
			if (var7 != null) {
				var10 |= var7.field1531 << 20;
			}

			Model var12 = (Model)var1.Widget_cachedModels.get(var10);
			if (var12 == null) {
				ModelData var13 = null;
				int var14 = 64;
				int var15 = 768;
				switch(var8) {
				case 1:
					var13 = ModelData.ModelData_get(var1.field2916, var9, 0);
					break;
				case 2:
					var13 = VerticalAlignment.getNpcDefinition(var9).method941((NewShit)null);
					break;
				case 3:
					var13 = var5 != null ? var5.getModelData() : null;
					break;
				case 4:
					ItemComposition var16 = class214.ItemDefinition_get(var9);
					var13 = var16.getModelData(10);
					var14 += var16.field1756;
					var15 += var16.field1759;
				case 5:
				default:
					break;
				case 6:
					var13 = VerticalAlignment.getNpcDefinition(var9).method941(var7);
				}

				if (var13 == null) {
					field2976 = true;
					return null;
				}

				var12 = var13.toModel(var14, var15, -50, -10, -50);
				var1.Widget_cachedModels.put(var12, var10);
			}

			if (var2 != null) {
				var12 = var2.transformWidgetModel(var12, var3);
			}

			return var12;
		}
	}

	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "(Lmr;ZB)Lme;",
		garbageValue = "4"
	)
	public SpriteMask method1851(WidgetDefinition var1, boolean var2) {
		if (this.spriteId == -1) {
			var2 = false;
		}

		int var3 = var2 ? this.spriteId : this.spriteId2;
		if (var3 == -1) {
			return null;
		} else {
			long var4 = ((this.spriteFlipH ? 1L : 0L) << 39) + ((this.spriteFlipV ? 1L : 0L) << 38) + (long)var3 + ((long)this.outline << 36) + ((long)this.spriteShadow << 40);
			SpriteMask var6 = (SpriteMask)var1.Widget_cachedSpriteMasks.get(var4);
			if (var6 != null) {
				return var6;
			} else {
				SpritePixels var7 = this.getSprite(var1, var2, (UrlRequester)null);
				if (var7 == null) {
					return null;
				} else {
					SpritePixels var8 = var7.copyNormalized();
					int[] var9 = new int[var8.subHeight];
					int[] var10 = new int[var8.subHeight];

					for (int var11 = 0; var11 < var8.subHeight; ++var11) {
						int var12 = 0;
						int var13 = var8.subWidth;

						int var14;
						for (var14 = 0; var14 < var8.subWidth; ++var14) {
							if (var8.pixels[var14 + var11 * var8.subWidth] == 0) {
								var12 = var14;
								break;
							}
						}

						for (var14 = var8.subWidth - 1; var14 >= var12; --var14) {
							if (var8.pixels[var14 + var11 * var8.subWidth] == 0) {
								var13 = var14 + 1;
								break;
							}
						}

						var9[var11] = var12;
						var10[var11] = var13 - var12;
					}

					var6 = new SpriteMask(var8.subWidth, var8.subHeight, var10, var9, var3);
					var1.Widget_cachedSpriteMasks.put(var6, var4);
					return var6;
				}
			}
		}
	}

	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "(ILjava/lang/String;B)V",
		garbageValue = "-73"
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

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "101495939"
	)
	public boolean method1853() {
		return !this.isIf3 || this.type == 0 || this.type == 11 || this.hasListener || this.contentType == 1338 || this.type == 12;
	}

	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "(B)Z",
		garbageValue = "54"
	)
	public boolean method1854() {
		return this.type == 11 || this.type == 12;
	}

	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;Lel;J)V"
	)
	public void method1855(String var1, UrlRequester var2, long var3) {
		if (this.type == 11 && -1L != var3) {
			var1 = var1.replaceAll("%userid%", Long.toString(var3));
			this.field2977 = new class208();
			if (!this.field2977.method1063(var1, var2)) {
				this.field2977 = null;
			} else {
				if (this.field2982 == null || this.field2983 == null) {
					this.method1857();
				}

			}
		}
	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;Lel;I)V",
		garbageValue = "-1255401092"
	)
	public void method1856(String var1, UrlRequester var2) {
		if (this.type == 11 && var1 != null) {
			this.field2977 = new class208();
			this.field2977.method1081(var1, var2);
		}
	}

	@ObfuscatedName("aq")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "1944060082"
	)
	void method1857() {
		this.field2982 = new HashMap();
		this.field2983 = new HashMap();
	}

	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		descriptor = "(IIB)V",
		garbageValue = "105"
	)
	public void method1858(int var1, int var2) {
		if (this.type == 11) {
			if (this.field2982 == null) {
				this.method1857();
			}

			this.field2982.put(var1, var2);
		}
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;IB)V",
		garbageValue = "40"
	)
	public void method1859(String var1, int var2) {
		if (this.type == 11) {
			if (this.field2983 == null) {
				this.method1857();
			}

			this.field2983.put(var1, var2);
		}
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(IIIII)Z",
		garbageValue = "-1885191377"
	)
	public boolean method1860(int var1, int var2, int var3, int var4) {
		if (this.type == 11 && this.field2977 != null && this.method1861()) {
			var1 -= var3;
			var2 -= var4;
			int var5 = (int)(this.field2977.method1071()[0] * (float)this.width);
			int var6 = (int)(this.field2977.method1071()[1] * (float)this.height);
			int var7 = var5 + (int)(this.field2977.method1071()[2] * (float)this.width);
			int var8 = var6 + (int)(this.field2977.method1071()[3] * (float)this.height);
			return var1 >= var5 && var2 >= var6 && var1 < var7 && var2 < var8;
		} else {
			return false;
		}
	}

	@ObfuscatedName("an")
	@ObfuscatedSignature(
		descriptor = "(B)Z",
		garbageValue = "29"
	)
	public boolean method1861() {
		return this.field2980 == 2;
	}

	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;I)I",
		garbageValue = "-720840753"
	)
	public int method1862(String var1) {
		return this.type == 11 && this.field2977 != null && this.method1861() ? this.field2977.method1066(var1) : -1;
	}

	@ObfuscatedName("ad")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;I)Ljava/lang/String;",
		garbageValue = "1149651075"
	)
	public String method1863(String var1) {
		return this.type == 11 && this.field2977 != null && this.method1861() ? this.field2977.method1067(var1) : null;
	}

	@ObfuscatedName("af")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "2095276271"
	)
	public int method1864() {
		return this.field2983 != null && this.field2983.size() > 0 ? 1 : 0;
	}

	@ObfuscatedName("be")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "1126201283"
	)
	public int method1865() {
		if (this.type == 11 && this.field2977 != null && this.field2983 != null && !this.field2983.isEmpty()) {
			String var1 = this.field2977.method1070();
			return var1 != null && this.field2983.containsKey(this.field2977.method1070()) ? (Integer)this.field2983.get(var1) : -1;
		} else {
			return -1;
		}
	}

	@ObfuscatedName("bd")
	@ObfuscatedSignature(
		descriptor = "(B)Ljava/lang/String;",
		garbageValue = "81"
	)
	public String method1866() {
		if (this.type == 11 && this.field2977 != null) {
			String var1 = this.field2977.method1070();
			Iterator var2 = this.field2977.method1072().iterator();

			while (var2.hasNext()) {
				class219 var3 = (class219)var2.next();
				String var4 = String.format("%%%S%%", var3.method1105());
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

	@ObfuscatedName("bl")
	@ObfuscatedSignature(
		descriptor = "(B)[I",
		garbageValue = "-61"
	)
	public int[] method1867() {
		if (this.type == 11 && this.field2977 != null) {
			int[] var1 = new int[3];
			int var2 = 0;
			Iterator var3 = this.field2977.method1072().iterator();

			while (var3.hasNext()) {
				class219 var4 = (class219)var3.next();
				if (!var4.method1105().equals("user_id")) {
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

	@ObfuscatedName("bi")
	@ObfuscatedSignature(
		descriptor = "(Lmr;Lel;I)Z",
		garbageValue = "1588534614"
	)
	public boolean method1868(WidgetDefinition var1, UrlRequester var2) {
		if (this.type == 11 && this.field2977 != null) {
			this.field2977.method1064(var2);
			if (this.field2977.method1065() != this.field2980) {
				this.field2980 = this.field2977.method1065();
				if (this.field2980 >= 100) {
					return true;
				}

				if (this.field2980 == 2) {
					this.method1869(var1);
					return true;
				}
			}

			return false;
		} else {
			return false;
		}
	}

	@ObfuscatedName("bf")
	@ObfuscatedSignature(
		descriptor = "(Lmr;I)V",
		garbageValue = "1425941595"
	)
	void method1869(WidgetDefinition var1) {
		this.noClickThrough = true;
		ArrayList var2 = this.field2977.method1068();
		ArrayList var3 = this.field2977.method1069();
		int var4 = var2.size() + var3.size();
		this.children = new Widget[var4];
		int var5 = 0;

		Iterator var6;
		Widget var8;
		for (var6 = var2.iterator(); var6.hasNext(); this.children[var5++] = var8) {
			class214 var7 = (class214)var6.next();
			var8 = class160.method839(5, this, var5, 0, 0, 0, 0, var7.field1853);
			var8.field3117 = var7.field1852.method659();
			class338 var9 = new class338(var7.field1852);
			var1.field2919.method2197(var8.field3117, var9);
		}

		for (var6 = var3.iterator(); var6.hasNext(); this.children[var5++] = var8) {
			class215 var10 = (class215)var6.next();
			var8 = class160.method839(4, this, var5, 0, 0, 0, 0, var10.field1855);
			var8.text = var10.field1859;
			var8.fontId = (Integer)this.field2982.get(var10.field1857);
			var8.textXAlignment = var10.field1858;
			var8.textYAlignment = var10.field1856;
		}

	}

	@ObfuscatedName("bg")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-1475013178"
	)
	public void method1870() {
		this.field2984 = new class339();

		for (int var1 = 1; var1 <= 12; ++var1) {
			this.field2984.field2928.method111(var1, 0);
		}

		for (char var2 = 0; var2 < ' '; ++var2) {
			this.field2984.field2928.method113(var2, 0);
		}

		this.field2984.field2928.method113('\u0080', 0);
		this.field2984.field2928.method111(82, 2);
		this.field2984.field2928.method111(81, 2);
		this.field2984.field2928.method111(86, 2);
	}

	@ObfuscatedName("ba")
	@ObfuscatedSignature(
		descriptor = "(I)Lni;",
		garbageValue = "-2105376256"
	)
	public class341 method1871() {
		return this.field2984 != null ? this.field2984.field2934 : null;
	}

	@ObfuscatedName("bm")
	@ObfuscatedSignature(
		descriptor = "(B)Lmp;",
		garbageValue = "-116"
	)
	public class336 method1872() {
		return this.field2984 != null ? this.field2984.field2929 : null;
	}

	@ObfuscatedName("bp")
	@ObfuscatedSignature(
		descriptor = "(I)Lbd;",
		garbageValue = "-35642997"
	)
	public class27 method1873() {
		return this.field2984 != null ? this.field2984.field2928 : null;
	}

	@ObfuscatedName("bw")
	@ObfuscatedSignature(
		descriptor = "(I)Lnq;",
		garbageValue = "1933652600"
	)
	public class339 method1874() {
		return this.field2984;
	}

	@ObfuscatedName("bj")
	@ObfuscatedSignature(
		descriptor = "(Lni;I)Z",
		garbageValue = "588474161"
	)
	boolean method1875(class341 var1) {
		boolean var2 = false;
		String var5;
		String var6;
		StringBuilder var7;
		int var8;
		int var9;
		int var10;
		char var11;
		String var12;
		if (this.text != null && !this.text.isEmpty()) {
			var6 = this.text;
			var7 = new StringBuilder(var6.length());
			var8 = 0;
			var9 = -1;

			for (var10 = 0; var10 < var6.length(); ++var10) {
				var11 = var6.charAt(var10);
				if (var11 == '<') {
					var7.append(var6.substring(var8, var10));
					var9 = var10;
				} else if (var11 == '>' && var9 != -1) {
					var12 = var6.substring(var9 + 1, var10);
					var9 = -1;
					if (var12.equals("lt")) {
						var7.append("<");
					} else if (var12.equals("gt")) {
						var7.append(">");
					} else if (var12.equals("br")) {
						var7.append("\n");
					}

					var8 = var10 + 1;
				}
			}

			if (var8 < var6.length()) {
				var7.append(var6.substring(var8, var6.length()));
			}

			var5 = var7.toString();
			var2 |= var1.method1761(var5);
			this.text = "";
		}

		if (this.text2 != null && !this.text2.isEmpty()) {
			var6 = this.text2;
			var7 = new StringBuilder(var6.length());
			var8 = 0;
			var9 = -1;

			for (var10 = 0; var10 < var6.length(); ++var10) {
				var11 = var6.charAt(var10);
				if (var11 == '<') {
					var7.append(var6.substring(var8, var10));
					var9 = var10;
				} else if (var11 == '>' && var9 != -1) {
					var12 = var6.substring(var9 + 1, var10);
					var9 = -1;
					if (var12.equals("lt")) {
						var7.append("<");
					} else if (var12.equals("gt")) {
						var7.append(">");
					} else if (var12.equals("br")) {
						var7.append("\n");
					}

					var8 = var10 + 1;
				}
			}

			if (var8 < var6.length()) {
				var7.append(var6.substring(var8, var6.length()));
			}

			var5 = var7.toString();
			var2 |= var1.method1762(var5);
			this.text2 = "";
		}

		return var2;
	}

	@ObfuscatedName("bn")
	@ObfuscatedSignature(
		descriptor = "(Lmr;B)Z",
		garbageValue = "16"
	)
	public boolean method1876(WidgetDefinition var1) {
		class341 var2 = this.method1871();
		if (var2 == null) {
			return false;
		} else {
			boolean var3 = false;
			if (!var2.method1815() && this.fontId != -1) {
				int var4 = var2.method1816();
				int var5 = var2.method1817();
				int var6 = var2.method1814();
				int var7 = var2.method1813();
				Font var8 = this.getFont(var1);
				if (var8 != null) {
					var3 |= var2.method1763(var8);
					var3 |= this.method1875(var2);
					var3 |= var2.method1768(var4, var5);
					var3 |= var2.method1783(var6, var7);
				}
			} else if (var2.method1815()) {
				var3 |= this.method1875(var2);
			}

			var2.method1758();
			return var3;
		}
	}
}