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

@Implements("RSGameShell")
public class GameShell extends Applet
	implements Runnable, MouseListener, MouseMotionListener, KeyListener {

	protected final void method1(int i, String s) {
		try {
			int j = (anInt1 - 281) / 2;
			int k = (anInt2 - 148) / 2;
			j += 2;
			k += 90;
			anInt3 = i;
			aString4 = s;
			int l = (277 * i) / 100;
			aGraphics5.setColor(new Color(132, 132, 132));
			if(aBoolean6)
				aGraphics5.setColor(new Color(220, 0, 0));
			aGraphics5.fillRect(j, k, l, 20);
			aGraphics5.setColor(Color.black);
			aGraphics5.fillRect(j + l, k, 277 - l, 20);
			aGraphics5.setColor(new Color(198, 198, 198));
			if(aBoolean6)
				aGraphics5.setColor(new Color(255, 255, 255));
			method8(aGraphics5, s, aFont7, j + 138, k + 10);
			return;
		}
		catch(Exception _ex) {
			return;
		}
	}

	protected void method2() {
	}

	protected synchronized void method3() {
	}

	protected void method4() {
	}

	private final void method5() {
		anInt8 = -2;
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

	private final void method7(int i, String s) {
		try {
			int j = (anInt1 - 281) / 2;
			int k = (anInt2 - 148) / 2;
			aGraphics5.setColor(Color.black);
			aGraphics5.fillRect(0, 0, anInt1, anInt2);
			if(!aBoolean6)
				aGraphics5.drawImage(gameImage, j, k, this);
			j += 2;
			k += 90;
			anInt3 = i;
			aString4 = s;
			aGraphics5.setColor(new Color(132, 132, 132));
			if(aBoolean6)
				aGraphics5.setColor(new Color(220, 0, 0));
			aGraphics5.drawRect(j - 2, k - 2, 280, 23);
			aGraphics5.fillRect(j, k, (277 * i) / 100, 20);
			aGraphics5.setColor(new Color(198, 198, 198));
			if(aBoolean6)
				aGraphics5.setColor(new Color(255, 255, 255));
			method8(aGraphics5, s, aFont7, j + 138, k + 10);
			if(!aBoolean6) {
				method8(aGraphics5, "Created by JAGeX - visit www.jagex.com", aFont12, j + 138, k + 30);
				method8(aGraphics5, "\2512001-2002 Andrew Gower and Jagex Ltd", aFont12, j + 138, k + 44);
			} else {
				aGraphics5.setColor(new Color(132, 132, 152));
				method8(aGraphics5, "\2512001-2002 Andrew Gower and Jagex Ltd", aFont13, j + 138, anInt2 - 20);
			}
			if(aString14 != null) {
				aGraphics5.setColor(Color.white);
				method8(aGraphics5, aString14, aFont12, j + 138, k - 120);
				return;
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

	protected synchronized void method9() {
	}

	private final void method10() {
		while (getGraphics() == null) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
		aGraphics5 = getGraphics();
		aGraphics5.setColor(Color.black);
		aGraphics5.fillRect(0, 0, anInt1, anInt2);
		byte abyte0[] = method19("jagex.jag", "Jagex library", 0);
		if(abyte0 == null) {
			System.out.println("Shouldnt happen");
			return;
		} else {
			byte abyte1[] = DataUtils.method352("logo.tga", 0, abyte0);
			gameImage = drawGameImage(abyte1);
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
			Surface.aByteArrayArray334[0] = DataUtils.method352("h11p.jf", 0, abyte0);
			Surface.aByteArrayArray334[1] = DataUtils.method352("h12b.jf", 0, abyte0);
			Surface.aByteArrayArray334[2] = DataUtils.method352("h12p.jf", 0, abyte0);
			Surface.aByteArrayArray334[3] = DataUtils.method352("h13b.jf", 0, abyte0);
			Surface.aByteArrayArray334[4] = DataUtils.method352("h14b.jf", 0, abyte0);
			Surface.aByteArrayArray334[5] = DataUtils.method352("h16b.jf", 0, abyte0);
			Surface.aByteArrayArray334[6] = DataUtils.method352("h20b.jf", 0, abyte0);
			Surface.aByteArrayArray334[7] = DataUtils.method352("h24b.jf", 0, abyte0);
			return;
		}
	}

	private final Image drawGameImage(byte abyte0[]) {
		int i = abyte0[13] * 256 + abyte0[12];
		int j = abyte0[15] * 256 + abyte0[14];
		byte abyte1[] = new byte[256];
		byte abyte2[] = new byte[256];
		byte abyte3[] = new byte[256];
		for(int k = 0; k < 256; k++) {
			abyte1[k] = abyte0[20 + k * 3];
			abyte2[k] = abyte0[19 + k * 3];
			abyte3[k] = abyte0[18 + k * 3];
		}

		IndexColorModel indexcolormodel = new IndexColorModel(8, 256, abyte1, abyte2, abyte3);
		byte abyte4[] = new byte[i * j];
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
			socket = new Socket(InetAddress.getByName("game.openrsc.com"), 43596);
		else
			socket = new Socket(InetAddress.getByName("game.openrsc.com"), 43596);
		socket.setSoTimeout(30000);
		socket.setTcpNoDelay(true);
		return socket;
	}

	protected final void method13() {
		for(int i = 0; i < 10; i++)
			aLongArray15[i] = 0L;

	}

	public final void run() {

		if(anInt16 == 1) {
			anInt16 = 2;
			method10();
			method7(0, "Loading...");
			method20();
			anInt16 = 0;
		}
		int i = 0;
		int j = 256;
		int k = 1;
		int i1 = 0;
		for(int j1 = 0; j1 < 10; j1++)
			aLongArray15[j1] = System.currentTimeMillis();

		long l = System.currentTimeMillis();
		while(anInt8 >= 0)  {
			if(anInt8 > 0) {
				anInt8--;
				if(anInt8 == 0) {
					method5();
					aThread17 = null;
					return;
				}
			}
			int k1 = j;
			int i2 = k;
			j = 300;
			k = 1;
			long l1 = System.currentTimeMillis();
			if(aLongArray15[i] == 0L) {
				j = k1;
				k = i2;
			} else
			if(l1 > aLongArray15[i])
				j = (int)((long)(2560 * anInt18) / (l1 - aLongArray15[i]));
			if(j < 25)
				j = 25;
			if(j > 256) {
				j = 256;
				k = (int)((long)anInt18 - (l1 - aLongArray15[i]) / 10L);
				if(k < anInt19)
					k = anInt19;
			}
			try {
				Thread.sleep(k);
			}
			catch(InterruptedException _ex) { }
			aLongArray15[i] = l1;
			i = (i + 1) % 10;
			if(k > 1) {
				for(int j2 = 0; j2 < 10; j2++)
					if(aLongArray15[j2] != 0L)
						aLongArray15[j2] += k;

			}
			int k2 = 0;
			while(i1 < 256)  {
				method9();
				i1 += j;
				if(++k2 > anInt20) {
					i1 = 0;
					anInt21 += 6;
					if(anInt21 > 25) {
						anInt21 = 0;
						aBoolean22 = true;
					}
					break;
				}
			}
			anInt21--;
			i1 &= 0xff;
			method3();
		}
		if(anInt8 == -1)
			method5();
		aThread17 = null;
	}

	public GameShell() {
		anInt1 = 512;
		anInt2 = 384;
		anInt18 = 20;
		anInt20 = 1000;
		aLongArray15 = new long[10];
		anInt16 = 1;
		aBoolean6 = false;
		aString4 = "Loading";
		aFont7 = new Font("TimesRoman", 0, 15);
		aFont12 = new Font("Helvetica", 1, 13);
		aFont13 = new Font("Helvetica", 0, 12);
		aBoolean32 = false;
		aBoolean33 = false;
		aBoolean26 = false;
		aBoolean27 = false;
		aBoolean28 = false;
		aBoolean29 = false;
		aBoolean30 = false;
		aBoolean31 = false;
		anInt19 = 1;
		aBoolean22 = false;
		aString35 = "";
		aString37 = "";
		aString36 = "";
		aString38 = "";
	}

	public Image createImage(int i, int j) {
		if(gameWindow != null)
			return gameWindow.createImage(i, j);
		else
			return super.createImage(i, j);
	}

	public final void destroy() {
		anInt8 = -1;
		try {
			Thread.sleep(5000L);
		}
		catch(Exception _ex) { }
		if(anInt8 == -1) {
			System.out.println("5 seconds expired, forcing kill");
			method5();
			if(aThread17 != null) {
				aThread17.stop();
				aThread17 = null;
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
		anInt1 = 512;
		anInt2 = 344;
		anInt16 = 1;
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
		anInt25 = 0;
		if(i == 1006)
			aBoolean26 = true;
		if(i == 1007)
			aBoolean27 = true;
		if(i == 1004)
			aBoolean28 = true;
		if(i == 1005)
			aBoolean29 = true;
		if((char)i == ' ')
			aBoolean30 = true;
		if((char)i == 'n' || (char)i == 'm')
			aBoolean31 = true;
		if((char)i == 'N' || (char)i == 'M')
			aBoolean31 = true;
		if((char)i == '{')
			aBoolean32 = true;
		if((char)i == '}')
			aBoolean33 = true;
		if((char)i == '\u03F0')
			aBoolean22 = !aBoolean22;
		boolean flag = false;
		for(int j = 0; j < aString34.length(); j++) {
			if(i != aString34.charAt(j))
				continue;
			flag = true;
			break;
		}

		if(flag && aString35.length() < 20)
			aString35 += (char)i;
		if(flag && aString36.length() < 80)
			aString36 += (char)i;
		if(i == 8 && aString35.length() > 0)
			aString35 = aString35.substring(0, aString35.length() - 1);
		if(i == 8 && aString36.length() > 0)
			aString36 = aString36.substring(0, aString36.length() - 1);
		if(i == 10 || i == 13) {
			aString37 = aString35;
			aString38 = aString36;
		}
		return true;
	}

	public final synchronized boolean keyUp(Event event, int i) {
		anInt23 = 0;
		if(i == 1006)
			aBoolean26 = false;
		if(i == 1007)
			aBoolean27 = false;
		if(i == 1004)
			aBoolean28 = false;
		if(i == 1005)
			aBoolean29 = false;
		if((char)i == ' ')
			aBoolean30 = false;
		if((char)i == 'n' || (char)i == 'm')
			aBoolean31 = false;
		if((char)i == 'N' || (char)i == 'M')
			aBoolean31 = false;
		if((char)i == '{')
			aBoolean32 = false;
		if((char)i == '}')
			aBoolean33 = false;
		return true;
	}

	public final synchronized boolean mouseDown(boolean metaDown, int i, int j) {
		anInt39 = i;
		anInt41 = j + anInt40;
		if(metaDown)
			anInt42 = 2;
		else
			anInt42 = 1;
		anInt43 = anInt42;
		anInt25 = 0;
		method6(anInt42, i, j);
		return true;
	}

	public final synchronized boolean mouseDrag(boolean metaDown, int i, int j) {
		anInt39 = i;
		anInt41 = j + anInt40;
		if(metaDown)
			anInt42 = 2;
		else
			anInt42 = 1;
		return true;
	}

	public final synchronized boolean mouseMove(Event event, int i, int j) {
		anInt39 = i;
		anInt41 = j + anInt40;
		anInt42 = 0;
		anInt25 = 0;
		return true;
	}

	public final synchronized boolean mouseUp(Event event, int i, int j) {
		anInt39 = i;
		anInt41 = j + anInt40;
		anInt42 = 0;
		return true;
	}

	public final void paint(Graphics g) {
		if(anInt16 == 2 && gameImage != null) {
			method7(anInt3, aString4);
			return;
		}
		if(anInt16 == 0)
			method4();
	}

	public final void start() {
		if(anInt8 >= 0)
			anInt8 = 0;
	}

	public final void stop() {
		if(anInt8 >= 0)
			anInt8 = 4000 / anInt18;
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

	protected final void method17(int i, int j, String s, boolean flag) {
		aBoolean10 = false;
		anInt1 = i;
		anInt2 = j;
		gameWindow = new GameWindow(this, i, j, s, flag, false);
		anInt16 = 1;
		aThread17 = new Thread(this);
		aThread17.start();
		aThread17.setPriority(1);
	}

	protected final void method18(int i) {
		anInt18 = 1000 / i;
	}

	protected byte[] method19(String s, String s1, int i) {
		int j = 0;
		int k = 0;
		byte abyte0[] = null;
		try {
			method1(i, "Loading " + s1 + " - 0%");
			java.io.InputStream inputstream = DataUtils.method353(s);
			DataInputStream datainputstream = new DataInputStream(inputstream);
			byte abyte2[] = new byte[6];
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
			byte abyte1[] = new byte[j];
			BZip2Decompressor.method133(abyte1, j, abyte0, k, 0);
			return abyte1;
		} else {
			return abyte0;
		}
	}

	protected void method20() {
	}

	private int anInt1;
	private int anInt2;
	private int anInt3;
	private String aString4;
	private Graphics aGraphics5;
	private boolean aBoolean6;
	private Font aFont7;
	private int anInt8;
	public static GameWindow gameWindow = null;
	private boolean aBoolean10;
	private Image gameImage;
	private Font aFont12;
	private Font aFont13;
	public String aString14;
	private long aLongArray15[];
	public int anInt16;
	private Thread aThread17;
	private int anInt18;
	public int anInt19;
	private int anInt20;
	private int anInt21;
	public boolean aBoolean22;
	public int anInt23;
	public int anInt24;
	public int anInt25;
	public boolean aBoolean26;
	public boolean aBoolean27;
	public boolean aBoolean28;
	public boolean aBoolean29;
	public boolean aBoolean30;
	public boolean aBoolean31;
	public boolean aBoolean32;
	public boolean aBoolean33;
	private static String aString34 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"\243$%^&*()-_=+[{]};:'@#~,<.>/?\\| ";
	public String aString35;
	public String aString36;
	public String aString37;
	public String aString38;
	public int anInt39;
	public int anInt40;
	public int anInt41;
	public int anInt42;
	public int anInt43;

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
}
