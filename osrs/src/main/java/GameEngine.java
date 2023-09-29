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

@ObfuscatedName("bb")
@Implements("GameEngine")
public abstract class GameEngine extends Applet implements Runnable, FocusListener, WindowListener {
	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "Lgw;"
	)
	@Export("taskHandler")
	protected static TaskHandler taskHandler;
	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "Lbb;"
	)
	@Export("gameEngine")
	static GameEngine gameEngine;
	@ObfuscatedName("ak")
	@Export("GameEngine_redundantStartThreadCount")
	static int GameEngine_redundantStartThreadCount;
	@ObfuscatedName("ax")
	@Export("stopTimeMs")
	static long stopTimeMs;
	@ObfuscatedName("ao")
	@Export("isKilled")
	static boolean isKilled;
	@ObfuscatedName("ab")
	@Export("cycleDurationMillis")
	static int cycleDurationMillis;
	@ObfuscatedName("am")
	@Export("fiveOrOne")
	static int fiveOrOne;
	@ObfuscatedName("av")
	@Export("fps")
	protected static int fps;
	@ObfuscatedName("ap")
	@Export("graphicsTickTimes")
	static long[] graphicsTickTimes;
	@ObfuscatedName("ay")
	static int field100;
	@ObfuscatedName("as")
	@Export("clientTickTimes")
	static long[] clientTickTimes;
	@ObfuscatedName("bz")
	static int field101;
	@ObfuscatedName("bu")
	@Export("volatileFocus")
	static volatile boolean volatileFocus;
	@ObfuscatedName("bh")
	@ObfuscatedSignature(
		descriptor = "Lad;"
	)
	@Export("keyHandler")
	static KeyHandler keyHandler;
	@ObfuscatedName("bg")
	@Export("garbageCollectorLastCollectionTime")
	static long garbageCollectorLastCollectionTime;
	@ObfuscatedName("bj")
	@Export("garbageCollectorLastCheckTimeMs")
	static long garbageCollectorLastCheckTimeMs;
	@ObfuscatedName("ah")
	@Export("hasErrored")
	boolean hasErrored;
	@ObfuscatedName("an")
	@Export("contentWidth")
	protected int contentWidth;
	@ObfuscatedName("au")
	@Export("contentHeight")
	protected int contentHeight;
	@ObfuscatedName("ai")
	@Export("canvasX")
	int canvasX;
	@ObfuscatedName("ae")
	@Export("canvasY")
	int canvasY;
	@ObfuscatedName("az")
	int field116;
	@ObfuscatedName("at")
	int field115;
	@ObfuscatedName("af")
	@Export("maxCanvasWidth")
	int maxCanvasWidth;
	@ObfuscatedName("ad")
	@Export("maxCanvasHeight")
	int maxCanvasHeight;
	@ObfuscatedName("bn")
	protected boolean field121;
	@ObfuscatedName("bd")
	@Export("frame")
	Frame frame;
	@ObfuscatedName("be")
	@Export("canvas")
	java.awt.Canvas canvas;
	@ObfuscatedName("bv")
	@Export("fullRedraw")
	volatile boolean fullRedraw;
	@ObfuscatedName("bb")
	@Export("resizeCanvasNextFrame")
	boolean resizeCanvasNextFrame;
	@ObfuscatedName("bo")
	@Export("isCanvasInvalid")
	volatile boolean isCanvasInvalid;
	@ObfuscatedName("bp")
	volatile long field126;
	@ObfuscatedName("br")
	@ObfuscatedSignature(
		descriptor = "Laq;"
	)
	@Export("mouseWheelHandler")
	MouseWheelHandler mouseWheelHandler;
	@ObfuscatedName("bs")
	@Export("clipboard")
	Clipboard clipboard;
	@ObfuscatedName("bc")
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
		field101 = 500;
		volatileFocus = true;
		keyHandler = new KeyHandler();
		garbageCollectorLastCollectionTime = -1L;
		garbageCollectorLastCheckTimeMs = -1L;
	}

	protected GameEngine() {
		this.hasErrored = false;
		this.canvasX = 0;
		this.canvasY = 0;
		this.field121 = false;
		this.fullRedraw = true;
		this.resizeCanvasNextFrame = false;
		this.isCanvasInvalid = false;
		this.field126 = 0L;
		EventQueue var1 = null;

		try {
			var1 = Toolkit.getDefaultToolkit().getSystemEventQueue();
		} catch (Throwable var3) {
		}

		this.eventQueue = var1;
		class403.method2054(new DevicePcmPlayerProvider());
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(IIB)V",
		garbageValue = "119"
	)
	@Export("setMaxCanvasSize")
	protected final void setMaxCanvasSize(int var1, int var2) {
		if (this.maxCanvasWidth != var1 || var2 != this.maxCanvasHeight) {
			this.method158();
		}

		this.maxCanvasWidth = var1;
		this.maxCanvasHeight = var2;
	}

	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/Object;B)V",
		garbageValue = "-34"
	)
	@Export("post")
	final void post(Object var1) {
		if (this.eventQueue != null) {
			for (int var2 = 0; var2 < 50 && this.eventQueue.peekEvent() != null; ++var2) {
				Players.method623(1L);
			}

			if (var1 != null) {
				this.eventQueue.postEvent(new ActionEvent(var1, 1001, "dummy"));
			}

		}
	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "(I)Lgc;",
		garbageValue = "643109691"
	)
	@Export("mouseWheel")
	protected class176 mouseWheel() {
		if (this.mouseWheelHandler == null) {
			this.mouseWheelHandler = new MouseWheelHandler();
			this.mouseWheelHandler.addTo(this.canvas);
		}

		return this.mouseWheelHandler;
	}

	@ObfuscatedName("av")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-97772302"
	)
	@Export("setUpClipboard")
	protected void setUpClipboard() {
		this.clipboard = this.getToolkit().getSystemClipboard();
	}

	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;I)V",
		garbageValue = "-1746840557"
	)
	protected void method141(String var1) {
		this.clipboard.setContents(new StringSelection(var1), (ClipboardOwner)null);
	}

	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "(I)Ljava/awt/datatransfer/Clipboard;",
		garbageValue = "-375508984"
	)
	@Export("getClipboard")
	public Clipboard getClipboard() {
		return this.clipboard;
	}

	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "84"
	)
	@Export("setUpKeyboard")
	protected final void setUpKeyboard() {
		WorldMapSection2.method1451();
		keyHandler.method98(this.canvas);
	}

	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-1343543797"
	)
	protected final void method144() {
		keyHandler.method100();
	}

	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		descriptor = "(Lbd;IS)V",
		garbageValue = "-1458"
	)
	protected void method145(class29 var1, int var2) {
		keyHandler.method96(var1, var2);
	}

	@ObfuscatedName("an")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "1316323394"
	)
	protected final void method146() {
		Tiles.method455(this.canvas);
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-845812181"
	)
	@Export("resizeCanvas")
	final void resizeCanvas() {
		Container var1 = this.container();
		if (var1 != null) {
			Bounds var2 = this.getFrameContentBounds();
			this.contentWidth = Math.max(var2.highX, this.field116);
			this.contentHeight = Math.max(var2.highY, this.field115);
			if (this.contentWidth <= 0) {
				this.contentWidth = 1;
			}

			if (this.contentHeight <= 0) {
				this.contentHeight = 1;
			}

			class340.canvasWidth = Math.min(this.contentWidth, this.maxCanvasWidth);
			class491.canvasHeight = Math.min(this.contentHeight, this.maxCanvasHeight);
			this.canvasX = (this.contentWidth - class340.canvasWidth) / 2;
			this.canvasY = 0;
			this.canvas.setSize(class340.canvasWidth, class491.canvasHeight);
			class223.rasterProvider = new RasterProvider(class340.canvasWidth, class491.canvasHeight, this.canvas, this.field121);
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

	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-953371865"
	)
	@Export("resizeGame")
	protected abstract void resizeGame();

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "175147715"
	)
	@Export("clearBackground")
	void clearBackground() {
		int var1 = this.canvasX;
		int var2 = this.canvasY;
		int var3 = this.contentWidth - class340.canvasWidth - var1;
		int var4 = this.contentHeight - class491.canvasHeight - var2;
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

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-1884885221"
	)
	@Export("replaceCanvas")
	final void replaceCanvas() {
		keyHandler.method99(this.canvas);
		java.awt.Canvas var1 = this.canvas;
		var1.removeMouseListener(MouseHandler.MouseHandler_instance);
		var1.removeMouseMotionListener(MouseHandler.MouseHandler_instance);
		var1.removeFocusListener(MouseHandler.MouseHandler_instance);
		MouseHandler.MouseHandler_currentButtonVolatile = 0;
		if (this.mouseWheelHandler != null) {
			this.mouseWheelHandler.method79(this.canvas);
		}

		this.addCanvas();
		keyHandler.method98(this.canvas);
		Tiles.method455(this.canvas);
		if (this.mouseWheelHandler != null) {
			this.mouseWheelHandler.addTo(this.canvas);
		}

		this.method158();
	}

	@ObfuscatedName("aq")
	@ObfuscatedSignature(
		descriptor = "(IIIII)V",
		garbageValue = "-749120852"
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
			class340.canvasWidth = var1;
			class491.canvasHeight = var2;
			RunException.RunException_revision = var3;
			RunException.field4313 = var4;
			class462.RunException_applet = this;
			if (taskHandler == null) {
				taskHandler = new TaskHandler();
			}

			taskHandler.newThreadTask(this, 1);
		} catch (Exception var6) {
			class190.RunException_sendStackTrace((String)null, var6);
			this.error("crash");
		}

	}

	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-2110760887"
	)
	@Export("addCanvas")
	final synchronized void addCanvas() {
		Container var1 = this.container();
		if (this.canvas != null) {
			this.canvas.removeFocusListener(this);
			var1.remove(this.canvas);
		}

		class340.canvasWidth = Math.max(var1.getWidth(), this.field116);
		class491.canvasHeight = Math.max(var1.getHeight(), this.field115);
		Insets var2;
		if (this.frame != null) {
			var2 = this.frame.getInsets();
			class340.canvasWidth -= var2.right + var2.left;
			class491.canvasHeight -= var2.top + var2.bottom;
		}

		this.canvas = new Canvas(this);
		var1.setBackground(Color.BLACK);
		var1.setLayout((LayoutManager)null);
		var1.add(this.canvas);
		this.canvas.setSize(class340.canvasWidth, class491.canvasHeight);
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
		if (class223.rasterProvider != null && class340.canvasWidth == class223.rasterProvider.width && class491.canvasHeight == class223.rasterProvider.height) {
			((RasterProvider)class223.rasterProvider).setComponent(this.canvas);
			class223.rasterProvider.drawFull(0, 0);
		} else {
			class223.rasterProvider = new RasterProvider(class340.canvasWidth, class491.canvasHeight, this.canvas, this.field121);
		}

		this.isCanvasInvalid = false;
		this.field126 = GrandExchangeOfferTotalQuantityComparator.method1971();
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(ZI)V",
		garbageValue = "2016311208"
	)
	protected void method152(boolean var1) {
		if (this.field121 != var1) {
			this.field121 = var1;
			class223.rasterProvider.method2685(var1);
			class223.rasterProvider.apply();
		}

	}

	@ObfuscatedName("af")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "-1592501950"
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

	@ObfuscatedName("ad")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "-73"
	)
	@Export("clientTick")
	void clientTick() {
		long var1 = GrandExchangeOfferTotalQuantityComparator.method1971();
		long var3 = clientTickTimes[class178.field1457];
		clientTickTimes[class178.field1457] = var1;
		class178.field1457 = class178.field1457 + 1 & 31;
		if (var3 != 0L && var1 > var3) {
		}

		synchronized(this) {
			KeyHandler.hasFocus = volatileFocus;
		}

		this.doCycle();
	}

	@ObfuscatedName("by")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "68"
	)
	protected final void method155() {
		this.fullRedraw = true;
	}

	@ObfuscatedName("bd")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "1944967760"
	)
	@Export("graphicsTick")
	void graphicsTick() {
		Container var1 = this.container();
		long var2 = GrandExchangeOfferTotalQuantityComparator.method1971();
		long var4 = graphicsTickTimes[field100];
		graphicsTickTimes[field100] = var2;
		field100 = field100 + 1 & 31;
		if (var4 != 0L && var2 > var4) {
			int var6 = (int)(var2 - var4);
			fps = ((var6 >> 1) + 32000) / var6;
		}

		if (++field101 - 1 > 50) {
			field101 -= 50;
			this.fullRedraw = true;
			this.canvas.setSize(class340.canvasWidth, class491.canvasHeight);
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

		this.method157();
		this.draw(this.fullRedraw);
		if (this.fullRedraw) {
			this.clearBackground();
		}

		this.fullRedraw = false;
	}

	@ObfuscatedName("be")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "3"
	)
	final void method157() {
		Bounds var1 = this.getFrameContentBounds();
		if (var1.highX != this.contentWidth || var1.highY != this.contentHeight || this.resizeCanvasNextFrame) {
			this.resizeCanvas();
			this.resizeCanvasNextFrame = false;
		}

	}

	@ObfuscatedName("bv")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-351835050"
	)
	final void method158() {
		this.resizeCanvasNextFrame = true;
	}

	@ObfuscatedName("ba")
	@ObfuscatedSignature(
		descriptor = "(S)V",
		garbageValue = "17082"
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

	@ObfuscatedName("bb")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "-84"
	)
	@Export("setUp")
	protected abstract void setUp();

	@ObfuscatedName("bo")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-800201684"
	)
	@Export("doCycle")
	protected abstract void doCycle();

	@ObfuscatedName("bp")
	@ObfuscatedSignature(
		descriptor = "(ZB)V",
		garbageValue = "40"
	)
	@Export("draw")
	protected abstract void draw(boolean var1);

	@ObfuscatedName("bt")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "1875481219"
	)
	@Export("kill0")
	protected abstract void kill0();

	@ObfuscatedName("bm")
	@ObfuscatedSignature(
		descriptor = "(ILjava/lang/String;ZI)V",
		garbageValue = "234034519"
	)
	@Export("drawInitial")
	protected final void drawInitial(int var1, String var2, boolean var3) {
		try {
			Graphics var4 = this.canvas.getGraphics();
			if (class14.fontHelvetica13 == null) {
				class14.fontHelvetica13 = new java.awt.Font("Helvetica", 1, 13);
				class14.loginScreenFontMetrics = this.canvas.getFontMetrics(class14.fontHelvetica13);
			}

			if (var3) {
				var4.setColor(Color.black);
				var4.fillRect(0, 0, class340.canvasWidth, class491.canvasHeight);
			}

			Color var5 = new Color(140, 17, 17);

			try {
				if (class319.field2797 == null) {
					class319.field2797 = this.canvas.createImage(304, 34);
				}

				Graphics var6 = class319.field2797.getGraphics();
				var6.setColor(var5);
				var6.drawRect(0, 0, 303, 33);
				var6.fillRect(2, 2, var1 * 3, 30);
				var6.setColor(Color.black);
				var6.drawRect(1, 1, 301, 31);
				var6.fillRect(var1 * 3 + 2, 2, 300 - var1 * 3, 30);
				var6.setFont(class14.fontHelvetica13);
				var6.setColor(Color.white);
				var6.drawString(var2, (304 - class14.loginScreenFontMetrics.stringWidth(var2)) / 2, 22);
				var4.drawImage(class319.field2797, class340.canvasWidth / 2 - 152, class491.canvasHeight / 2 - 18, (ImageObserver)null);
			} catch (Exception var9) {
				int var7 = class340.canvasWidth / 2 - 152;
				int var8 = class491.canvasHeight / 2 - 18;
				var4.setColor(var5);
				var4.drawRect(var7, var8, 303, 33);
				var4.fillRect(var7 + 2, var8 + 2, var1 * 3, 30);
				var4.setColor(Color.black);
				var4.drawRect(var7 + 1, var8 + 1, 301, 31);
				var4.fillRect(var7 + var1 * 3 + 2, var8 + 2, 300 - var1 * 3, 30);
				var4.setFont(class14.fontHelvetica13);
				var4.setColor(Color.white);
				var4.drawString(var2, var7 + (304 - class14.loginScreenFontMetrics.stringWidth(var2)) / 2, var8 + 22);
			}
		} catch (Exception var10) {
			this.canvas.repaint();
		}

	}

	@ObfuscatedName("br")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "403874015"
	)
	protected final void method161() {
		class319.field2797 = null;
		class14.fontHelvetica13 = null;
		class14.loginScreenFontMetrics = null;
	}

	@ObfuscatedName("bs")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;I)V",
		garbageValue = "1574795554"
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

	@ObfuscatedName("bc")
	@ObfuscatedSignature(
		descriptor = "(B)Ljava/awt/Container;",
		garbageValue = "91"
	)
	@Export("container")
	Container container() {
		return (Container)(this.frame != null ? this.frame : this);
	}

	@ObfuscatedName("bu")
	@ObfuscatedSignature(
		descriptor = "(I)Lrx;",
		garbageValue = "-138440448"
	)
	@Export("getFrameContentBounds")
	Bounds getFrameContentBounds() {
		Container var1 = this.container();
		int var2 = Math.max(var1.getWidth(), this.field116);
		int var3 = Math.max(var1.getHeight(), this.field115);
		if (this.frame != null) {
			Insets var4 = this.frame.getInsets();
			var2 -= var4.right + var4.left;
			var3 -= var4.bottom + var4.top;
		}

		return new Bounds(var2, var3);
	}

	@ObfuscatedName("bf")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "1209134026"
	)
	@Export("hasFrame")
	protected final boolean hasFrame() {
		return this.frame != null;
	}

	@ObfuscatedName("bl")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "390692392"
	)
	@Export("vmethod1485")
	protected abstract void vmethod1485();

	@Export("destroy")
	@ObfuscatedName("destroy")
	public final void destroy() {
		if (this == gameEngine && !isKilled) {
			stopTimeMs = GrandExchangeOfferTotalQuantityComparator.method1971();
			Players.method623(5000L);
			this.kill();
		}
	}

	@Export("paint")
	@ObfuscatedName("paint")
	public final synchronized void paint(Graphics var1) {
		if (this == gameEngine && !isKilled) {
			this.fullRedraw = true;
			if (GrandExchangeOfferTotalQuantityComparator.method1971() - this.field126 > 1000L) {
				Rectangle var2 = var1.getClipBounds();
				if (var2 == null || var2.width >= class340.canvasWidth && var2.height >= class491.canvasHeight) {
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
					String var2 = TaskHandler.javaVersion;
					if (var2.equals("1.1") || var2.startsWith("1.1.") || var2.equals("1.2") || var2.startsWith("1.2.") || var2.equals("1.3") || var2.startsWith("1.3.") || var2.equals("1.4") || var2.startsWith("1.4.") || var2.equals("1.5") || var2.startsWith("1.5.") || var2.equals("1.6.0")) {
						this.error("wrongjava");
						return;
					}

					if (var2.startsWith("1.6.0_")) {
						int var3;
						for (var3 = 6; var3 < var2.length() && IsaacCipher.isDigit(var2.charAt(var3)); ++var3) {
						}

						String var4 = var2.substring(6, var3);
						if (AttackOption.isNumber(var4) && class36.method182(var4) < 10) {
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
			class314.clock = WorldMapScaleHandler.method1602();

			while (0L == stopTimeMs || GrandExchangeOfferTotalQuantityComparator.method1971() < stopTimeMs) {
				class160.gameCyclesToDo = class314.clock.wait(cycleDurationMillis, fiveOrOne);

				for (int var5 = 0; var5 < class160.gameCyclesToDo; ++var5) {
					this.clientTick();
				}

				this.graphicsTick();
				this.post(this.canvas);
			}
		} catch (Exception var6) {
			class190.RunException_sendStackTrace((String)null, var6);
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

	public final void stop() {
		if (this == gameEngine && !isKilled) {
			stopTimeMs = GrandExchangeOfferTotalQuantityComparator.method1971() + 4000L;
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

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "-1887479417"
	)
	static void method166(int var0) {
		if (var0 != Login.loginIndex) {
			Login.loginIndex = var0;
		}
	}
}