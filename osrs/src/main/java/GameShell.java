// Decompiled by Jad v1.5.8c. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

import net.runelite.mapping.Implements;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.IndexColorModel;
import java.awt.image.MemoryImageSource;
import java.io.*;
import java.net.*;
import java.nio.file.Files;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

@Implements("RSGameShell")
public class GameShell extends Applet
	implements Runnable, MouseListener, MouseWheelListener, MouseMotionListener, KeyListener {

	protected final void method1(int i, String s) {
		try {
			int j = (appletWidth - 281) / 2;
			int k = (appletHeight - 148) / 2;
			j += 2;
			k += 90;
			anInt3 = i;
			loadingProgressText = s;
			int l = (277 * i) / 100;
			graphics.setColor(new Color(132, 132, 132));
			if(hasRefererLogoNotused)
				graphics.setColor(new Color(220, 0, 0));
			graphics.fillRect(j, k, l, 20);
			graphics.setColor(Color.black);
			graphics.fillRect(j + l, k, 277 - l, 20);
			graphics.setColor(new Color(198, 198, 198));
			if(hasRefererLogoNotused)
				graphics.setColor(new Color(255, 255, 255));
			method8(graphics, s, fontTimesRoman, j + 138, k + 10);
        }
		catch(Exception _ex) {
        }
	}

	protected void method2() {
	}

	protected synchronized void draw() {
	}

	protected void method4() {
	}

	private final void exitApplication() {
		stopTimeout = -2;
		System.out.println("Closing program");
		method2();
		try {
			Thread.sleep(1000L);
		}
		catch(Exception _ex) { }
		if(gameWindow != null)
			gameWindow.dispose();
		if(!aBoolean10)
			System.exit(0);
	}

	protected void method6(int i, int j, int k) {
	}

	private final void drawLoadingScreen(int i, String s) {
		try {
			int j = (appletWidth - 281) / 2;
			int k = (appletHeight - 148) / 2;
			graphics.setColor(Color.black);
			graphics.fillRect(0, 0, appletWidth, appletHeight + 12);
			if(!hasRefererLogoNotused)
				graphics.drawImage(logoImage, j, k, this);
			j += 2;
			k += 90;
			anInt3 = i;
			loadingProgressText = s;
			graphics.setColor(new Color(132, 132, 132));
			if(hasRefererLogoNotused)
				graphics.setColor(new Color(220, 0, 0));
			graphics.drawRect(j - 2, k - 2, 280, 23);
			graphics.fillRect(j, k, (277 * i) / 100, 20);
			graphics.setColor(new Color(198, 198, 198));
			if(hasRefererLogoNotused)
				graphics.setColor(new Color(255, 255, 255));
			method8(graphics, s, fontTimesRoman, j + 138, k + 10);
			if(!hasRefererLogoNotused) {
				method8(graphics, "Created by JAGeX - visit www.jagex.com", fontHelvetica13b, j + 138, k + 30);
				method8(graphics, "\2512001-2002 Andrew Gower and Jagex Ltd", fontHelvetica13b, j + 138, k + 44);
			} else {
				graphics.setColor(new Color(132, 132, 152));
				method8(graphics, "\2512001-2002 Andrew Gower and Jagex Ltd", fontHelvetica12, j + 138, appletHeight - 20);
			}
			if(aString14 != null) {
				graphics.setColor(Color.white);
				method8(graphics, aString14, fontHelvetica13b, j + 138, k - 120);
            }
		}
		catch(Exception _ex) { }
	}

	protected final void method8(Graphics g, String s, Font font, int i, int j) {
		Object obj;
		if(gameWindow == null)
			obj = this;
		else
			obj = gameWindow;
		FontMetrics fontmetrics = ((Component) (obj)).getFontMetrics(font);
		fontmetrics.stringWidth(s);
		g.setFont(font);
		g.drawString(s, i - fontmetrics.stringWidth(s) / 2, j + fontmetrics.getHeight() / 4);
	}

	protected synchronized void doCycle() {
	}

	private final void loadJagex() {
		while (getGraphics() == null) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
		graphics = getGraphics();
		graphics.setColor(Color.black);
		graphics.fillRect(0, 0, appletWidth, appletHeight);
		byte[] buffer = readDataFile("jagex.jag", "Jagex library", 0);
		if(buffer == null) {
        } else {
			byte[] abyte1 = DataUtils.loadData("logo.tga", 0, buffer);
			logoImage = createImage(abyte1);
			/* XXX modified
			Surface.method259("h11p", 0, this);
			Surface.method259("h12b", 1, this);
			Surface.method259("h12p", 2, this);
			Surface.method259("h13b", 3, this);
			Surface.method259("h14b", 4, this);
			Surface.method259("h16b", 5, this);
			Surface.method259("h20b", 6, this);
			Surface.method259("h24b", 7, this);
			*/
			// XXX: restore non-broken font rendering pre-2004
			Surface.fonts[0] = DataUtils.loadData("h11p.jf", 0, buffer);
			Surface.fonts[1] = DataUtils.loadData("h12b.jf", 0, buffer);
			Surface.fonts[2] = DataUtils.loadData("h12p.jf", 0, buffer);
			Surface.fonts[3] = DataUtils.loadData("h13b.jf", 0, buffer);
			Surface.fonts[4] = DataUtils.loadData("h14b.jf", 0, buffer);
			Surface.fonts[5] = DataUtils.loadData("h16b.jf", 0, buffer);
			Surface.fonts[6] = DataUtils.loadData("h20b.jf", 0, buffer);
			Surface.fonts[7] = DataUtils.loadData("h24b.jf", 0, buffer);
        }
	}

	private final Image createImage(byte[] abyte0) {
		int i = abyte0[13] * 256 + abyte0[12];
		int j = abyte0[15] * 256 + abyte0[14];
		byte[] abyte1 = new byte[256];
		byte[] abyte2 = new byte[256];
		byte[] abyte3 = new byte[256];
		for(int k = 0; k < 256; k++) {
			abyte1[k] = abyte0[20 + k * 3];
			abyte2[k] = abyte0[19 + k * 3];
			abyte3[k] = abyte0[18 + k * 3];
		}

		IndexColorModel indexcolormodel = new IndexColorModel(8, 256, abyte1, abyte2, abyte3);
		byte[] abyte4 = new byte[i * j];
		int l = 0;
		for(int i1 = j - 1; i1 >= 0; i1--) {
			for(int j1 = 0; j1 < i; j1++)
				abyte4[l++] = abyte0[786 + j1 + i1 * i];

		}

		MemoryImageSource memoryimagesource = new MemoryImageSource(i, j, indexcolormodel, abyte4, 0, i);
		Image image = createImage(memoryimagesource);
		return image;
	}

	protected Socket method12(String s, int i) throws IOException {
		Socket socket;
		if(method14())
			socket = new Socket(InetAddress.getByName("206.251.222.229"), 43596);
		else
			socket = new Socket(InetAddress.getByName("206.251.222.229"), 43596);
		socket.setSoTimeout(30000);
		socket.setTcpNoDelay(true);
		return socket;
	}

	protected final void method13() {
		for(int i = 0; i < 10; i++)
			timings[i] = 0L;

	}

	private static void unzipData() {
		File meteorDir = new File(System.getProperty("user.home"), "meteor-rsc/");
		File dataDir = new File(meteorDir, "data/");
		File dataZip = new File(meteorDir, "data.zip");

		// create output directory if it doesn't exist
		if(!dataDir.exists()) dataDir.mkdirs();
		FileInputStream fis;
		//buffer for read and write data to file
		byte[] buffer = new byte[1024];
		try {
			fis = new FileInputStream(dataZip);
			ZipInputStream zis = new ZipInputStream(fis);
			ZipEntry ze = zis.getNextEntry();
			while(ze != null){
				String fileName = ze.getName();
				File newFile = new File(dataDir + File.separator + fileName);
				System.out.println("Unzipping to "+newFile.getAbsolutePath());
				//create directories for sub directories in zip
				new File(newFile.getParent()).mkdirs();
				FileOutputStream fos = new FileOutputStream(newFile);
				int len;
				while ((len = zis.read(buffer)) > 0) {
					fos.write(buffer, 0, len);
				}
				fos.close();
				//close this ZipEntry
				zis.closeEntry();
				ze = zis.getNextEntry();
			}
			//close last ZipEntry
			zis.closeEntry();
			zis.close();
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static File meteorDir = new File(System.getProperty("user.home"), "meteor-rsc/");
	public static File dataDir = new File(meteorDir, "data/");
	File dataZipLocal = new File(meteorDir, "data.zip");

	public void initCache() {

		if (!meteorDir.exists())
			meteorDir.mkdir();
		if (!dataDir.exists()) {
			dataZipLocal.delete();
			try (InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("data.zip")) {
				Files.copy(is, dataZipLocal.toPath());
				unzipData();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public final void run() {

		if(loadingState == 1) {
			loadingState = 2;
			initCache();
			loadJagex();
			drawLoadingScreen(0, "Loading...");
			startGame();
			loadingState = 0;
		}
		int i = 0;
		int j = 256;
		int sleep = 1;
		int i1 = 0;
		for(int j1 = 0; j1 < 10; j1++)
			timings[j1] = System.currentTimeMillis();

		//Unused anyways so why create it
		//long l = System.currentTimeMillis();
		while(stopTimeout >= 0)  {
			if(stopTimeout > 0) {
				stopTimeout--;
				if(stopTimeout == 0) {
					exitApplication();
					clientThread = null;
					return;
				}
			}
			int k1 = j;
			int lastSleep = sleep;
			j = 300;
			sleep = 1;
			long time = System.currentTimeMillis();
			if(timings[i] == 0L) {
				j = k1;
				sleep = lastSleep;
			} else
			if(time > timings[i])
				j = (int)((long)(2560L * targetFPS) / (time - timings[i]));
			if(j < 25)
				j = 25;
			if(j > 256) {
				j = 256;
				sleep = (int)((long) targetFPS - (time - timings[i]) / 10L);
				if(sleep < threadSleep)
					sleep = threadSleep;
			}
			try {
				Thread.sleep(sleep);
			}
			catch(InterruptedException _ex) { }
			timings[i] = time;
			i = (i + 1) % 10;
			if(sleep > 1) {
				for(int j2 = 0; j2 < 10; j2++)
					if(timings[j2] != 0L)
						timings[j2] += sleep;

			}
			int k2 = 0;
			while(i1 < 256)  {
				doCycle();
				i1 += j;
				if(++k2 > maxDrawTime) {
					i1 = 0;
					interlaceTimer += 6;
					if(interlaceTimer > 25) {
						interlaceTimer = 0;
						interlace = true;
					}
					break;
				}
			}
			interlaceTimer--;
			i1 &= 0xff;
			draw();
		}
		if(stopTimeout == -1)
			exitApplication();
		clientThread = null;
	}

	public GameShell() {
		appletWidth = 512;
		appletHeight = 384;
		targetFPS = 20;
		maxDrawTime = 1000;
		timings = new long[10];
		loadingState = 1;
		hasRefererLogoNotused = false;
		loadingProgressText = "Loading";
		fontTimesRoman = new Font("TimesRoman", 0, 15);
		fontHelvetica13b = new Font("Helvetica", 1, 13);
		fontHelvetica12 = new Font("Helvetica", 0, 12);
		keyLsb = false;
		keyRsb = false;
		keyLeft = false;
		keyRight = false;
		keyUp = false;
		keyDown = false;
		keySpace = false;
		keyNm = false;
		threadSleep = 1;
		interlace = false;
		inputTextCurrent = "";
		inputTextFinal = "";
		inputPmCurrent = "";
		inputPmFinal = "";
	}

	public Image createImage(int i, int j) {
		if(gameWindow != null)
			return gameWindow.createImage(i, j);
		else
			return super.createImage(i, j);
	}

	public final void destroy() {
		stopTimeout = -1;
		try {
			Thread.sleep(5000L);
		}
		catch(Exception _ex) { }
		if(stopTimeout == -1) {
			System.out.println("5 seconds expired, forcing kill");
			exitApplication();
			if(clientThread != null) {
				clientThread.stop();
				clientThread = null;
			}
		}
	}

	public URL getCodeBase() {
		return super.getCodeBase();
	}

	public URL getDocumentBase() {
		try {
			return new File("./data/").toURL();
		} catch (MalformedURLException e) {
			throw new RuntimeException(e);
		}
	}

	public Graphics getGraphics() {
		if(gameWindow != null)
			return gameWindow.getGraphics();
		else
			return super.getGraphics();
	}

	public String getParameter(String s) {
		return super.getParameter(s);
	}

	public final void init() {
		aBoolean10 = true;
		System.out.println("Started applet");
		appletWidth = 512;
		appletHeight = 344;
		loadingState = 1;
		try {
			DataUtils.anURL542 = new File("data/").toURI().toURL();
		} catch (MalformedURLException e) {
			throw new RuntimeException(e);
		}
		method16(this);
	}

	public final synchronized boolean keyDown(Event event, int i) {
		method15(i);
		anInt23 = i;
		anInt24 = i;
		mouseIdleCycles = 0;
		if(i == 1006)
			keyLeft = true;
		if(i == 1007)
			keyRight = true;
		if(i == 1004)
			keyUp = true;
		if(i == 1005)
			keyDown = true;
		if((char)i == ' ')
			keySpace = true;
		if((char)i == 'n' || (char)i == 'm')
			keyNm = true;
		if((char)i == 'N' || (char)i == 'M')
			keyNm = true;
		if((char)i == '{')
			keyLsb = true;
		if((char)i == '}')
			keyRsb = true;
		if((char)i == '\u03F0')
			interlace = !interlace;
		boolean flag = false;
		for(int j = 0; j < aString34.length(); j++) {
			if(i != aString34.charAt(j))
				continue;
			flag = true;
			break;
		}

		if(flag && inputTextCurrent.length() < 20)
			inputTextCurrent += (char)i;
		if(flag && inputPmCurrent.length() < 80)
			inputPmCurrent += (char)i;
		if(i == 8 && inputTextCurrent.length() > 0)
			inputTextCurrent = inputTextCurrent.substring(0, inputTextCurrent.length() - 1);
		if(i == 8 && inputPmCurrent.length() > 0)
			inputPmCurrent = inputPmCurrent.substring(0, inputPmCurrent.length() - 1);
		if(i == 10 || i == 13) {
			inputTextFinal = inputTextCurrent;
			inputPmFinal = inputPmCurrent;
		}
		return true;
	}

	public final synchronized boolean keyUp(Event event, int i) {
		anInt23 = 0;
		if(i == 1006)
			keyLeft = false;
		if(i == 1007)
			keyRight = false;
		if(i == 1004)
			keyUp = false;
		if(i == 1005)
			keyDown = false;
		if((char)i == ' ')
			keySpace = false;
		if((char)i == 'n' || (char)i == 'm')
			keyNm = false;
		if((char)i == 'N' || (char)i == 'M')
			keyNm = false;
		if((char)i == '{')
			keyLsb = false;
		if((char)i == '}')
			keyRsb = false;
		return true;
	}

	public final synchronized boolean mouseDown(boolean metaDown, int i, int j) {
		mouseX = i;
		mouseY = j + anInt40;
		if(metaDown)
			mouseButtonDown = 2;
		else
			mouseButtonDown = 1;
		lastMouseButtonDown = mouseButtonDown;
		mouseIdleCycles = 0;
		method6(mouseButtonDown, i, j);
		return true;
	}

	public final synchronized boolean mouseDrag(boolean metaDown, int i, int j) {
		mouseX = i;
		mouseY = j + anInt40;
		if(metaDown)
			mouseButtonDown = 2;
		else
			mouseButtonDown = 1;
		return true;
	}

	public final synchronized boolean mouseMove(Event event, int i, int j) {
		mouseX = i;
		mouseY = j + anInt40;
		mouseButtonDown = 0;
		mouseIdleCycles = 0;
		return true;
	}

	public final synchronized boolean mouseUp(Event event, int i, int j) {
		mouseX = i;
		mouseY = j + anInt40;
		mouseButtonDown = 0;
		return true;
	}

	public final void paint(Graphics g) {
		if(loadingState == 2 && logoImage != null) {
			drawLoadingScreen(anInt3, loadingProgressText);
			return;
		}
		if(loadingState == 0)
			method4();
	}

	public final void start() {
		if(stopTimeout >= 0)
			stopTimeout = 0;
	}

	public final void stop() {
		if(stopTimeout >= 0)
			stopTimeout = 4000 / targetFPS;
	}

	public final void update(Graphics g) {
		paint(g);
	}

	protected final boolean method14() {
		return aBoolean10;
	}

	protected void method15(int i) {
	}

	protected void method16(Runnable runnable) {
		Thread thread = new Thread(runnable);
		thread.setDaemon(true);
		thread.start();
	}

	protected final void setupWindow(int i, int j, String s, boolean flag) {
		aBoolean10 = false;
		mudclient.gameWidth = i;
		mudclient.gameHeight = j;
		appletWidth = i;
		appletHeight = j;
		gameWindow = new GameWindow(this, i, j, s, flag, false);
		loadingState = 1;
		clientThread = new Thread(this);
		clientThread.start();
		clientThread.setPriority(1);
	}

	protected final void method18(int i) {
		targetFPS = 1000 / i;
	}

	protected byte[] readDataFile(String s, String s1, int i) {
		int j = 0;
		int k = 0;
		byte[] abyte0 = null;
		try {
			method1(i, "Loading " + s1 + " - 0%");
			java.io.InputStream inputstream = DataUtils.method353(s);
			DataInputStream datainputstream = new DataInputStream(inputstream);
			byte[] abyte2 = new byte[6];
			datainputstream.readFully(abyte2, 0, 6);
			j = ((abyte2[0] & 0xff) << 16) + ((abyte2[1] & 0xff) << 8) + (abyte2[2] & 0xff);
			k = ((abyte2[3] & 0xff) << 16) + ((abyte2[4] & 0xff) << 8) + (abyte2[5] & 0xff);
			method1(i, "Loading " + s1 + " - 5%");
			int l = 0;
			abyte0 = new byte[k];
			while(l < k)  {
				int i1 = k - l;
				if(i1 > 1000)
					i1 = 1000;
				datainputstream.readFully(abyte0, l, i1);
				l += i1;
				method1(i, "Loading " + s1 + " - " + (5 + (l * 95) / k) + "%");
			}
			datainputstream.close();
		}
		catch(IOException _ex) { _ex.printStackTrace(); }
		method1(i, "Unpacking " + s1);
		if(k != j) {
			byte[] abyte1 = new byte[j];
			BZip2Decompressor.method133(abyte1, j, abyte0, k, 0);
			return abyte1;
		} else {
			return abyte0;
		}
	}

	protected void startGame() {
	}

	public static int appletWidth;
	public static int appletHeight;
	private int anInt3;
	private String loadingProgressText;
	private Graphics graphics;
	private final boolean hasRefererLogoNotused;
	private final Font fontTimesRoman;
	private int stopTimeout;
	public static GameWindow gameWindow = null;
	private boolean aBoolean10;
	private Image logoImage;
	private final Font fontHelvetica13b;
	private final Font fontHelvetica12;
	public String aString14;
	private final long[] timings;
	public int loadingState;
	private Thread clientThread;
	private int targetFPS;
	public int threadSleep;
	private final int maxDrawTime;
	private int interlaceTimer;
	public boolean interlace;
	public int anInt23;
	public int anInt24;
	public int mouseIdleCycles;
	public boolean keyLeft;
	public boolean keyRight;
	public boolean keyUp;
	public boolean keyDown;
	public boolean keySpace;
	public boolean keyNm;
	public boolean keyLsb;
	public boolean keyRsb;
	private static final String aString34 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"\243$%^&*()-_=+[{]};:'@#~,<.>/?\\| ";
	public String inputTextCurrent;
	public String inputPmCurrent;
	public String inputTextFinal;
	public String inputPmFinal;
	public int mouseX;
	public int anInt40;
	public int mouseY;
	public int mouseButtonDown;
	public int lastMouseButtonDown;

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyChar();
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
			code = Event.LEFT;
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
			code = Event.RIGHT;
		if (e.getKeyCode() == KeyEvent.VK_UP)
			code = Event.UP;
		if (e.getKeyCode() == KeyEvent.VK_DOWN)
			code = Event.DOWN;
		keyDown(null, code);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int code = e.getKeyChar();
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
			code = Event.LEFT;
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
			code = Event.RIGHT;
		if (e.getKeyCode() == KeyEvent.VK_UP)
			code = Event.UP;
		if (e.getKeyCode() == KeyEvent.VK_DOWN)
			code = Event.DOWN;
		keyUp(null, code);
	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON2)
			return;
		boolean isMouse2 = e.getButton() == 3;
		mouseDown(isMouse2, e.getX(), e.getY());
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		mouseUp(null, e.getX(), e.getY());
	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		mouseDrag(e.isMetaDown(), e.getX(), e.getY());
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		mouseMove(null, e.getX(), e.getY());
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {

	}
}
