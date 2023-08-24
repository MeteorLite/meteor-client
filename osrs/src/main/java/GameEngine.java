import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.applet.Applet;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.StringSelection;
import java.awt.event.*;
import java.awt.image.ImageObserver;
import java.net.URL;

@ObfuscatedName("bm")
@Implements("GameEngine")
public abstract class GameEngine extends Applet implements Runnable, FocusListener, WindowListener {
	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "Lgh;"
	)
	@Export("taskHandler")
	protected static TaskHandler taskHandler;
	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "Lbm;"
	)
	@Export("gameEngine")
	static GameEngine gameEngine;
	@ObfuscatedName("ao")
	@Export("GameEngine_redundantStartThreadCount")
	static int GameEngine_redundantStartThreadCount;
	@ObfuscatedName("at")
	@Export("stopTimeMs")
	static long stopTimeMs;
	@ObfuscatedName("ac")
	@Export("isKilled")
	static boolean isKilled;
	@ObfuscatedName("az")
	@Export("gameCyclesToDo")
	static int gameCyclesToDo;
	@ObfuscatedName("ap")
	@Export("cycleDurationMillis")
	static int cycleDurationMillis;
	@ObfuscatedName("aa")
	@Export("fiveOrOne")
	static int fiveOrOne;
	@ObfuscatedName("af")
	@Export("fps")
	protected static int fps;
	@ObfuscatedName("al")
	@Export("graphicsTickTimes")
	static long[] graphicsTickTimes;
	@ObfuscatedName("ar")
	@Export("clientTickTimes")
	static long[] clientTickTimes;
	@ObfuscatedName("by")
	static Image field103;
	@ObfuscatedName("bs")
	static int field102;
	@ObfuscatedName("bb")
	@Export("volatileFocus")
	static volatile boolean volatileFocus;
	@ObfuscatedName("be")
	@ObfuscatedSignature(
		descriptor = "Lak;"
	)
	@Export("keyHandler")
	protected static KeyHandler keyHandler;
	@ObfuscatedName("bz")
	@Export("garbageCollectorLastCollectionTime")
	static long garbageCollectorLastCollectionTime;
	@ObfuscatedName("bx")
	@Export("garbageCollectorLastCheckTimeMs")
	static long garbageCollectorLastCheckTimeMs;
	@ObfuscatedName("ai")
	@Export("hasErrored")
	boolean hasErrored;
	@ObfuscatedName("ag")
	@Export("contentWidth")
	protected int contentWidth;
	@ObfuscatedName("am")
	@Export("contentHeight")
	protected int contentHeight;
	@ObfuscatedName("ax")
	@Export("canvasX")
	int canvasX;
	@ObfuscatedName("ah")
	@Export("canvasY")
	int canvasY;
	@ObfuscatedName("aj")
	int field114;
	@ObfuscatedName("av")
	int field116;
	@ObfuscatedName("aw")
	@Export("maxCanvasWidth")
	int maxCanvasWidth;
	@ObfuscatedName("ak")
	@Export("maxCanvasHeight")
	int maxCanvasHeight;
	@ObfuscatedName("bh")
	protected boolean field123;
	@ObfuscatedName("bv")
	@Export("frame")
	Frame frame;
	@ObfuscatedName("bt")
	@Export("canvas")
	java.awt.Canvas canvas;
	@ObfuscatedName("bd")
	@Export("fullRedraw")
	volatile boolean fullRedraw;
	@ObfuscatedName("bm")
	@Export("resizeCanvasNextFrame")
	boolean resizeCanvasNextFrame;
	@ObfuscatedName("bf")
	@Export("isCanvasInvalid")
	volatile boolean isCanvasInvalid;
	@ObfuscatedName("bq")
	volatile long field128;
	@ObfuscatedName("bp")
	@ObfuscatedSignature(
		descriptor = "Lay;"
	)
	@Export("mouseWheelHandler")
	MouseWheelHandler mouseWheelHandler;
	@ObfuscatedName("bu")
	@Export("clipboard")
	Clipboard clipboard;
	@ObfuscatedName("bo")
	@Export("eventQueue")
	final EventQueue eventQueue;

	static {
		gameEngine = null;
		GameEngine_redundantStartThreadCount = 0;
		stopTimeMs = 0L;
		isKilled = false;
		cycleDurationMillis = 20;
		fiveOrOne = 1;
		fps = 0;
		graphicsTickTimes = new long[32];
		clientTickTimes = new long[32];
		field102 = 500;
		volatileFocus = true;
		keyHandler = new KeyHandler();
		garbageCollectorLastCollectionTime = -1L;
		garbageCollectorLastCheckTimeMs = -1L;
	}

	protected GameEngine() {
		this.hasErrored = false;
		this.canvasX = 0;
		this.canvasY = 0;
		this.field123 = false;
		this.fullRedraw = true;
		this.resizeCanvasNextFrame = false;
		this.isCanvasInvalid = false;
		this.field128 = 0L;
		EventQueue var1 = null;

		try {
			var1 = Toolkit.getDefaultToolkit().getSystemEventQueue();
		} catch (Throwable var3) {
		}

		this.eventQueue = var1;
		DevicePcmPlayerProvider var2 = new DevicePcmPlayerProvider();
		FloorDecoration.pcmPlayerProvider = var2;
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(III)V",
		garbageValue = "1343076745"
	)
	@Export("setMaxCanvasSize")
	protected final void setMaxCanvasSize(int var1, int var2) {
		if (this.maxCanvasWidth != var1 || var2 != this.maxCanvasHeight) {
			this.method155();
		}

		this.maxCanvasWidth = var1;
		this.maxCanvasHeight = var2;
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/Object;I)V",
		garbageValue = "-272604069"
	)
	@Export("post")
	final void post(Object var1) {
		if (this.eventQueue != null) {
			for (int var2 = 0; var2 < 50 && this.eventQueue.peekEvent() != null; ++var2) {
				PendingSpawn.method505(1L);
			}

			if (var1 != null) {
				this.eventQueue.postEvent(new ActionEvent(var1, 1001, "dummy"));
			}

		}
	}

	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		descriptor = "(B)Lgk;",
		garbageValue = "24"
	)
	@Export("mouseWheel")
	protected class174 mouseWheel() {
		if (this.mouseWheelHandler == null) {
			this.mouseWheelHandler = new MouseWheelHandler();
			this.mouseWheelHandler.addTo(this.canvas);
		}

		return this.mouseWheelHandler;
	}

	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "-84"
	)
	@Export("setUpClipboard")
	protected void setUpClipboard() {
		this.clipboard = this.getToolkit().getSystemClipboard();
	}

	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;S)V",
		garbageValue = "255"
	)
	protected void method138(String var1) {
		this.clipboard.setContents(new StringSelection(var1), (ClipboardOwner)null);
	}

	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "(I)Ljava/awt/datatransfer/Clipboard;",
		garbageValue = "-1215097022"
	)
	@Export("getClipboard")
	protected Clipboard getClipboard() {
		return this.clipboard;
	}

	@ObfuscatedName("af")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "216188058"
	)
	@Export("setUpKeyboard")
	protected final void setUpKeyboard() {
		if (TaskHandler.javaVendor.toLowerCase().indexOf("microsoft") != -1) {
			class28.KeyHandler_keyCodes[186] = 57;
			class28.KeyHandler_keyCodes[187] = 27;
			class28.KeyHandler_keyCodes[188] = 71;
			class28.KeyHandler_keyCodes[189] = 26;
			class28.KeyHandler_keyCodes[190] = 72;
			class28.KeyHandler_keyCodes[191] = 73;
			class28.KeyHandler_keyCodes[192] = 58;
			class28.KeyHandler_keyCodes[219] = 42;
			class28.KeyHandler_keyCodes[220] = 74;
			class28.KeyHandler_keyCodes[221] = 43;
			class28.KeyHandler_keyCodes[222] = 59;
			class28.KeyHandler_keyCodes[223] = 28;
		} else {
			class28.KeyHandler_keyCodes[44] = 71;
			class28.KeyHandler_keyCodes[45] = 26;
			class28.KeyHandler_keyCodes[46] = 72;
			class28.KeyHandler_keyCodes[47] = 73;
			class28.KeyHandler_keyCodes[59] = 57;
			class28.KeyHandler_keyCodes[61] = 27;
			class28.KeyHandler_keyCodes[91] = 42;
			class28.KeyHandler_keyCodes[92] = 74;
			class28.KeyHandler_keyCodes[93] = 43;
			class28.KeyHandler_keyCodes[192] = 28;
			class28.KeyHandler_keyCodes[222] = 58;
			class28.KeyHandler_keyCodes[520] = 59;
		}

		keyHandler.method89(this.canvas);
	}

	@ObfuscatedName("ad")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "61"
	)
	protected final void method141() {
		keyHandler.method92();
	}

	@ObfuscatedName("aq")
	@ObfuscatedSignature(
		descriptor = "(Lbv;II)V",
		garbageValue = "178768313"
	)
	protected void method142(class29 var1, int var2) {
		keyHandler.method86(var1, var2);
	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-1089439044"
	)
	protected final void method143() {
		java.awt.Canvas var1 = this.canvas;
		var1.addMouseListener(MouseHandler.MouseHandler_instance);
		var1.addMouseMotionListener(MouseHandler.MouseHandler_instance);
		var1.addFocusListener(MouseHandler.MouseHandler_instance);
	}

	@ObfuscatedName("an")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "122"
	)
	@Export("resizeCanvas")
	final void resizeCanvas() {
		Container var1 = this.container();
		if (var1 != null) {
			Bounds var2 = this.getFrameContentBounds();
			this.contentWidth = Math.max(var2.highX, this.field114);
			this.contentHeight = Math.max(var2.highY, this.field116);
			if (this.contentWidth <= 0) {
				this.contentWidth = 1;
			}

			if (this.contentHeight <= 0) {
				this.contentHeight = 1;
			}

			class113.canvasWidth = Math.min(this.contentWidth, this.maxCanvasWidth);
			class177.canvasHeight = Math.min(this.contentHeight, this.maxCanvasHeight);
			this.canvasX = (this.contentWidth - class113.canvasWidth) / 2;
			this.canvasY = 0;
			this.canvas.setSize(class113.canvasWidth, class177.canvasHeight);
			AttackOption.rasterProvider = new RasterProvider(class113.canvasWidth, class177.canvasHeight, this.canvas, this.field123);
			if (var1 == this.frame) {
				Insets var3 = this.frame.getInsets();
				this.canvas.setLocation(var3.left + this.canvasX, var3.top + this.canvasY);
			} else {
				this.canvas.setLocation(this.canvasX, this.canvasY);
			}

			this.fullRedraw = true;
			this.resizeGame();
		}
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "59"
	)
	@Export("resizeGame")
	protected abstract void resizeGame();

	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-1724529603"
	)
	@Export("clearBackground")
	void clearBackground() {
		int var1 = this.canvasX;
		int var2 = this.canvasY;
		int var3 = this.contentWidth - class113.canvasWidth - var1;
		int var4 = this.contentHeight - class177.canvasHeight - var2;
		if (var1 > 0 || var3 > 0 || var2 > 0 || var4 > 0) {
			try {
				Container var5 = this.container();
				int var6 = 0;
				int var7 = 0;
				if (var5 == this.frame) {
					Insets var8 = this.frame.getInsets();
					var6 = var8.left;
					var7 = var8.top;
				}

				Graphics var10 = var5.getGraphics();
				var10.setColor(Color.black);
				if (var1 > 0) {
					var10.fillRect(var6, var7, var1, this.contentHeight);
				}

				if (var2 > 0) {
					var10.fillRect(var6, var7, this.contentWidth, var2);
				}

				if (var3 > 0) {
					var10.fillRect(var6 + this.contentWidth - var3, var7, var3, this.contentHeight);
				}

				if (var4 > 0) {
					var10.fillRect(var6, var7 + this.contentHeight - var4, this.contentWidth, var4);
				}
			} catch (Exception var9) {
			}
		}

	}

	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		descriptor = "(S)V",
		garbageValue = "239"
	)
	@Export("replaceCanvas")
	final void replaceCanvas() {
		keyHandler.method90(this.canvas);
		java.awt.Canvas var1 = this.canvas;
		var1.removeMouseListener(MouseHandler.MouseHandler_instance);
		var1.removeMouseMotionListener(MouseHandler.MouseHandler_instance);
		var1.removeFocusListener(MouseHandler.MouseHandler_instance);
		MouseHandler.MouseHandler_currentButtonVolatile = 0;
		if (this.mouseWheelHandler != null) {
			this.mouseWheelHandler.method71(this.canvas);
		}

		this.addCanvas();
		keyHandler.method89(this.canvas);
		java.awt.Canvas var2 = this.canvas;
		var2.addMouseListener(MouseHandler.MouseHandler_instance);
		var2.addMouseMotionListener(MouseHandler.MouseHandler_instance);
		var2.addFocusListener(MouseHandler.MouseHandler_instance);
		if (this.mouseWheelHandler != null) {
			this.mouseWheelHandler.addTo(this.canvas);
		}

		this.method155();
	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "(IIIII)V",
		garbageValue = "-1491001696"
	)
	@Export("startThread")
	protected final void startThread(int var1, int var2, int var3, int var4) {
		try {
			if (gameEngine != null) {
				++GameEngine_redundantStartThreadCount;
				if (GameEngine_redundantStartThreadCount >= 3) {
					this.error("alreadyloaded");
					return;
				}

				this.getAppletContext().showDocument(this.getDocumentBase(), "_self");
				return;
			}

			gameEngine = this;
			class113.canvasWidth = var1;
			class177.canvasHeight = var2;
			RunException.RunException_revision = var3;
			RunException.field4287 = var4;
			RunException.RunException_applet = this;
			if (taskHandler == null) {
				taskHandler = new TaskHandler();
			}

			taskHandler.newThreadTask(this, 1);
		} catch (Exception var6) {
			Messages.RunException_sendStackTrace((String)null, var6);
			this.error("crash");
		}

	}

	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "3"
	)
	@Export("addCanvas")
	final synchronized void addCanvas() {
		Container var1 = this.container();
		if (this.canvas != null) {
			this.canvas.removeFocusListener(this);
			var1.remove(this.canvas);
		}

		class113.canvasWidth = Math.max(var1.getWidth(), this.field114);
		class177.canvasHeight = Math.max(var1.getHeight(), this.field116);
		Insets var2;
		if (this.frame != null) {
			var2 = this.frame.getInsets();
			class113.canvasWidth -= var2.right + var2.left;
			class177.canvasHeight -= var2.bottom + var2.top;
		}

		this.canvas = new Canvas(this);
		var1.setBackground(Color.BLACK);
		var1.setLayout((LayoutManager)null);
		var1.add(this.canvas);
		this.canvas.setSize(class113.canvasWidth, class177.canvasHeight);
		this.canvas.setVisible(true);
		this.canvas.setBackground(Color.BLACK);
		if (var1 == this.frame) {
			var2 = this.frame.getInsets();
			this.canvas.setLocation(this.canvasX + var2.left, this.canvasY + var2.top);
		} else {
			this.canvas.setLocation(this.canvasX, this.canvasY);
		}

		this.canvas.addFocusListener(this);
		this.canvas.requestFocus();
		this.fullRedraw = true;
		if (AttackOption.rasterProvider != null && class113.canvasWidth == AttackOption.rasterProvider.width && class177.canvasHeight == AttackOption.rasterProvider.height) {
			((RasterProvider)AttackOption.rasterProvider).setComponent(this.canvas);
			AttackOption.rasterProvider.drawFull(0, 0);
		} else {
			AttackOption.rasterProvider = new RasterProvider(class113.canvasWidth, class177.canvasHeight, this.canvas, this.field123);
		}

		this.isCanvasInvalid = false;
		this.field128 = clockNow();
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(ZI)V",
		garbageValue = "366742"
	)
	protected void method149(boolean var1) {
		if (this.field123 != var1) {
			this.field123 = var1;
			AttackOption.rasterProvider.method2646(var1);
			AttackOption.rasterProvider.apply();
		}

	}

	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "805251619"
	)
	@Export("checkHost")
	protected final boolean checkHost() {
		String var1 = this.getDocumentBase().getHost().toLowerCase();
		if (!var1.equals("jagex.com") && !var1.endsWith(".jagex.com")) {
			if (!var1.equals("runescape.com") && !var1.endsWith(".runescape.com")) {
				if (var1.endsWith("127.0.0.1")) {
					return true;
				} else {
					while (var1.length() > 0 && var1.charAt(var1.length() - 1) >= '0' && var1.charAt(var1.length() - 1) <= '9') {
						var1 = var1.substring(0, var1.length() - 1);
					}

					if (var1.endsWith("192.168.1.")) {
						return true;
					} else {
						this.error("invalidhost");
						return false;
					}
				}
			} else {
				return true;
			}
		} else {
			return true;
		}
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-1721255354"
	)
	@Export("clientTick")
	void clientTick() {
		long var1 = clockNow();
		long var3 = clientTickTimes[PacketWriter.field1151];
		clientTickTimes[PacketWriter.field1151] = var1;
		PacketWriter.field1151 = PacketWriter.field1151 + 1 & 31;
		if (0L != var3 && var1 > var3) {
		}

		synchronized(this) {
			class370.hasFocus = volatileFocus;
		}

		this.doCycle();
	}

	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-1251903818"
	)
	protected final void method152() {
		this.fullRedraw = true;
	}

	@ObfuscatedName("av")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "543987991"
	)
	@Export("graphicsTick")
	void graphicsTick() {
		Container var1 = this.container();
		long var2 = clockNow();
		long var4 = graphicsTickTimes[ParamComposition.field1678];
		graphicsTickTimes[ParamComposition.field1678] = var2;
		ParamComposition.field1678 = ParamComposition.field1678 + 1 & 31;
		if (var4 != 0L && var2 > var4) {
			int var6 = (int)(var2 - var4);
			fps = ((var6 >> 1) + 32000) / var6;
		}

		if (++field102 - 1 > 50) {
			field102 -= 50;
			this.fullRedraw = true;
			this.canvas.setSize(class113.canvasWidth, class177.canvasHeight);
			this.canvas.setVisible(true);
			if (var1 == this.frame) {
				Insets var7 = this.frame.getInsets();
				this.canvas.setLocation(this.canvasX + var7.left, this.canvasY + var7.top);
			} else {
				this.canvas.setLocation(this.canvasX, this.canvasY);
			}
		}

		if (this.isCanvasInvalid) {
			this.replaceCanvas();
		}

		this.method154();
		this.draw(this.fullRedraw);
		if (this.fullRedraw) {
			this.clearBackground();
		}

		this.fullRedraw = false;
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-1664691529"
	)
	final void method154() {
		Bounds var1 = this.getFrameContentBounds();
		if (this.contentWidth != var1.highX || this.contentHeight != var1.highY || this.resizeCanvasNextFrame) {
			this.resizeCanvas();
			this.resizeCanvasNextFrame = false;
		}

	}

	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "0"
	)
	final void method155() {
		this.resizeCanvasNextFrame = true;
	}

	@ObfuscatedName("bh")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "0"
	)
	@Export("kill")
	final synchronized void kill() {
		if (!isKilled) {
			isKilled = true;

			try {
				this.canvas.removeFocusListener(this);
			} catch (Exception var5) {
			}

			try {
				this.kill0();
			} catch (Exception var4) {
			}

			if (this.frame != null) {
				try {
					System.exit(0);
				} catch (Throwable var3) {
				}
			}

			if (taskHandler != null) {
				try {
					taskHandler.close();
				} catch (Exception var2) {
				}
			}

			this.vmethod1485();
		}
	}

	@ObfuscatedName("by")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "208117174"
	)
	@Export("setUp")
	protected abstract void setUp();

	@ObfuscatedName("bs")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "1753601126"
	)
	@Export("doCycle")
	protected abstract void doCycle();

	@ObfuscatedName("bm")
	@ObfuscatedSignature(
		descriptor = "(ZI)V",
		garbageValue = "-1944984067"
	)
	@Export("draw")
	protected abstract void draw(boolean var1);

	@ObfuscatedName("bf")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-1298916795"
	)
	@Export("kill0")
	protected abstract void kill0();

	@ObfuscatedName("bq")
	@ObfuscatedSignature(
		descriptor = "(ILjava/lang/String;ZB)V",
		garbageValue = "-97"
	)
	@Export("drawInitial")
	protected final void drawInitial(int var1, String var2, boolean var3) {
		try {
			Graphics var4 = this.canvas.getGraphics();
			if (ObjectSound.fontHelvetica13 == null) {
				ObjectSound.fontHelvetica13 = new java.awt.Font("Helvetica", 1, 13);
				class85.loginScreenFontMetrics = this.canvas.getFontMetrics(ObjectSound.fontHelvetica13);
			}

			if (var3) {
				var4.setColor(Color.black);
				var4.fillRect(0, 0, class113.canvasWidth, class177.canvasHeight);
			}

			Color var5 = new Color(140, 17, 17);

			try {
				if (field103 == null) {
					field103 = this.canvas.createImage(304, 34);
				}

				Graphics var6 = field103.getGraphics();
				var6.setColor(var5);
				var6.drawRect(0, 0, 303, 33);
				var6.fillRect(2, 2, var1 * 3, 30);
				var6.setColor(Color.black);
				var6.drawRect(1, 1, 301, 31);
				var6.fillRect(var1 * 3 + 2, 2, 300 - var1 * 3, 30);
				var6.setFont(ObjectSound.fontHelvetica13);
				var6.setColor(Color.white);
				var6.drawString(var2, (304 - class85.loginScreenFontMetrics.stringWidth(var2)) / 2, 22);
				var4.drawImage(field103, class113.canvasWidth / 2 - 152, class177.canvasHeight / 2 - 18, (ImageObserver)null);
			} catch (Exception var9) {
				int var7 = class113.canvasWidth / 2 - 152;
				int var8 = class177.canvasHeight / 2 - 18;
				var4.setColor(var5);
				var4.drawRect(var7, var8, 303, 33);
				var4.fillRect(var7 + 2, var8 + 2, var1 * 3, 30);
				var4.setColor(Color.black);
				var4.drawRect(var7 + 1, var8 + 1, 301, 31);
				var4.fillRect(var1 * 3 + var7 + 2, var8 + 2, 300 - var1 * 3, 30);
				var4.setFont(ObjectSound.fontHelvetica13);
				var4.setColor(Color.white);
				var4.drawString(var2, var7 + (304 - class85.loginScreenFontMetrics.stringWidth(var2)) / 2, var8 + 22);
			}
		} catch (Exception var10) {
			this.canvas.repaint();
		}

	}

	@ObfuscatedName("ba")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-146638494"
	)
	protected final void method158() {
		field103 = null;
		ObjectSound.fontHelvetica13 = null;
		class85.loginScreenFontMetrics = null;
	}

	@ObfuscatedName("bl")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;I)V",
		garbageValue = "305949479"
	)
	@Export("error")
	protected void error(String var1) {
		if (!this.hasErrored) {
			this.hasErrored = true;
			System.out.println("error_game_" + var1);

			try {
				this.getAppletContext().showDocument(new URL(this.getCodeBase(), "error_game_" + var1 + ".ws"), "_self");
			} catch (Exception var3) {
			}

		}
	}

	@ObfuscatedName("bp")
	@ObfuscatedSignature(
		descriptor = "(I)Ljava/awt/Container;",
		garbageValue = "-1637240751"
	)
	@Export("container")
	Container container() {
		return (Container)(this.frame != null ? this.frame : this);
	}

	@ObfuscatedName("bu")
	@ObfuscatedSignature(
		descriptor = "(I)Lrb;",
		garbageValue = "790707673"
	)
	@Export("getFrameContentBounds")
	Bounds getFrameContentBounds() {
		Container var1 = this.container();
		int var2 = Math.max(var1.getWidth(), this.field114);
		int var3 = Math.max(var1.getHeight(), this.field116);
		if (this.frame != null) {
			Insets var4 = this.frame.getInsets();
			var2 -= var4.right + var4.left;
			var3 -= var4.top + var4.bottom;
		}

		return new Bounds(var2, var3);
	}

	@ObfuscatedName("bo")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "1032464717"
	)
	@Export("hasFrame")
	protected final boolean hasFrame() {
		return this.frame != null;
	}

	@ObfuscatedName("br")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "1929688897"
	)
	@Export("vmethod1485")
	protected abstract void vmethod1485();

	@Export("destroy")
	@ObfuscatedName("destroy")
	public final void destroy() {
		if (this == gameEngine && !isKilled) {
			stopTimeMs = clockNow();
			PendingSpawn.method505(5000L);
			this.kill();
		}
	}

	@Export("paint")
	@ObfuscatedName("paint")
	public final synchronized void paint(Graphics var1) {
		if (this == gameEngine && !isKilled) {
			this.fullRedraw = true;
			if (clockNow() - this.field128 > 1000L) {
				Rectangle var2 = var1.getClipBounds();
				if (var2 == null || var2.width >= class113.canvasWidth && var2.height >= class177.canvasHeight) {
					this.isCanvasInvalid = true;
				}
			}

		}
	}

	@Export("run")
	@ObfuscatedName("run")
	public void run() {
		try {
			if (TaskHandler.javaVendor != null) {
				String var1 = TaskHandler.javaVendor.toLowerCase();
				if (var1.indexOf("sun") != -1 || var1.indexOf("apple") != -1) {
					String var2 = class106.javaVersion;
					if (var2.equals("1.1") || var2.startsWith("1.1.") || var2.equals("1.2") || var2.startsWith("1.2.") || var2.equals("1.3") || var2.startsWith("1.3.") || var2.equals("1.4") || var2.startsWith("1.4.") || var2.equals("1.5") || var2.startsWith("1.5.") || var2.equals("1.6.0")) {
						this.error("wrongjava");
						return;
					}

					if (var2.startsWith("1.6.0_")) {
						int var3;
						for (var3 = 6; var3 < var2.length() && class330.isDigit(var2.charAt(var3)); ++var3) {
						}

						String var4 = var2.substring(6, var3);
						if (class218.isNumber(var4) && HealthBarUpdate.method524(var4) < 10) {
							this.error("wrongjava");
							return;
						}
					}

					fiveOrOne = 5;
				}
			}

			this.setFocusCycleRoot(true);
			this.addCanvas();
			this.setUp();

			Object var8;
			try {
				var8 = new NanoClock();
			} catch (Throwable var6) {
				var8 = new MilliClock();
			}

			class332.clock = (Clock)var8;

			while (0L == stopTimeMs || clockNow() < stopTimeMs) {
				gameCyclesToDo = class332.clock.wait(cycleDurationMillis, fiveOrOne);

				for (int var5 = 0; var5 < gameCyclesToDo; ++var5) {
					this.clientTick();
				}

				this.graphicsTick();
				this.post(this.canvas);
			}
		} catch (Exception var7) {
			Messages.RunException_sendStackTrace((String)null, var7);
			this.error("crash");
		}

		this.kill();
	}

	@Export("start")
	@ObfuscatedName("start")
	public final void start() {
		if (this == gameEngine && !isKilled) {
			stopTimeMs = 0L;
		}
	}

	@Export("stop")
	@ObfuscatedName("stop")
	public final void stop() {
		if (this == gameEngine && !isKilled) {
			stopTimeMs = clockNow() + 4000L;
		}
	}

	@Export("update")
	@ObfuscatedName("update")
	public final void update(Graphics var1) {
		this.paint(var1);
	}

	@Export("focusGained")
	@ObfuscatedName("focusGained")
	public final void focusGained(FocusEvent var1) {
		volatileFocus = true;
		this.fullRedraw = true;
	}

	public final void focusLost(FocusEvent var1) {
		volatileFocus = false;
	}

	public final void windowActivated(WindowEvent var1) {
	}

	public final void windowClosed(WindowEvent var1) {
	}

	@Export("windowClosing")
	@ObfuscatedName("windowClosing")
	public final void windowClosing(WindowEvent var1) {
		this.destroy();
	}

	public final void windowDeactivated(WindowEvent var1) {
	}

	public final void windowDeiconified(WindowEvent var1) {
	}

	public final void windowIconified(WindowEvent var1) {
	}

	public final void windowOpened(WindowEvent var1) {
	}

	@ObfuscatedName("init")
	public abstract void init();

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(I)J",
		garbageValue = "1742672473"
	)
	@Export("clockNow")
	public static final synchronized long clockNow() {
		long var0 = System.currentTimeMillis();
		if (var0 < class301.field2754) {
			Canvas.field61 += class301.field2754 - var0;
		}

		class301.field2754 = var0;
		return var0 + Canvas.field61;
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "([Lch;II[I[II)V",
		garbageValue = "1909898083"
	)
	@Export("sortWorlds")
	static void sortWorlds(World[] var0, int var1, int var2, int[] var3, int[] var4) {
		if (var1 < var2) {
			int var5 = var1 - 1;
			int var6 = var2 + 1;
			int var7 = (var2 + var1) / 2;
			World var8 = var0[var7];
			var0[var7] = var0[var1];
			var0[var1] = var8;

			while (var5 < var6) {
				boolean var9 = true;

				int var10;
				int var11;
				int var12;
				do {
					--var6;

					for (var10 = 0; var10 < 4; ++var10) {
						if (var3[var10] == 2) {
							var11 = var0[var6].index;
							var12 = var8.index;
						} else if (var3[var10] == 1) {
							var11 = var0[var6].population;
							var12 = var8.population;
							if (var11 == -1 && var4[var10] == 1) {
								var11 = 2001;
							}

							if (var12 == -1 && var4[var10] == 1) {
								var12 = 2001;
							}
						} else if (var3[var10] == 3) {
							var11 = var0[var6].isMembersOnly() ? 1 : 0;
							var12 = var8.isMembersOnly() ? 1 : 0;
						} else {
							var11 = var0[var6].id;
							var12 = var8.id;
						}

						if (var11 != var12) {
							if ((var4[var10] != 1 || var11 <= var12) && (var4[var10] != 0 || var11 >= var12)) {
								var9 = false;
							}
							break;
						}

						if (var10 == 3) {
							var9 = false;
						}
					}
				} while(var9);

				var9 = true;

				do {
					++var5;

					for (var10 = 0; var10 < 4; ++var10) {
						if (var3[var10] == 2) {
							var11 = var0[var5].index;
							var12 = var8.index;
						} else if (var3[var10] == 1) {
							var11 = var0[var5].population;
							var12 = var8.population;
							if (var11 == -1 && var4[var10] == 1) {
								var11 = 2001;
							}

							if (var12 == -1 && var4[var10] == 1) {
								var12 = 2001;
							}
						} else if (var3[var10] == 3) {
							var11 = var0[var5].isMembersOnly() ? 1 : 0;
							var12 = var8.isMembersOnly() ? 1 : 0;
						} else {
							var11 = var0[var5].id;
							var12 = var8.id;
						}

						if (var11 != var12) {
							if ((var4[var10] != 1 || var11 >= var12) && (var4[var10] != 0 || var11 <= var12)) {
								var9 = false;
							}
							break;
						}

						if (var10 == 3) {
							var9 = false;
						}
					}
				} while(var9);

				if (var5 < var6) {
					World var13 = var0[var5];
					var0[var5] = var0[var6];
					var0[var6] = var13;
				}
			}

			sortWorlds(var0, var1, var6, var3, var4);
			sortWorlds(var0, var6 + 1, var2, var3, var4);
		}

	}
}