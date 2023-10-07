// Decompiled by Jad v1.5.8c. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

import java.awt.*;
import java.io.IOException;
import java.math.BigInteger;

public class NetworkedGame extends GameShell {

	protected final void method21(long l) {
		packetStream.createPacket(167);
		packetStream.method332(l);
		packetStream.endPacket();
		for(int i = 0; i < anInt603; i++) {
			if(aLongArray602[i] != l)
				continue;
			anInt603--;
			for(int j = i; j < anInt603; j++) {
				aLongArray602[j] = aLongArray602[j + 1];
				anIntArray604[j] = anIntArray604[j + 1];
			}

			break;
		}

		method44("@pri@" + DataUtils.method351(l) + " has been removed from your friends list");
	}

	private final void method22() {
		boolean flag = true;
		while(flag)  {
			flag = false;
			for(int i = 0; i < anInt603 - 1; i++)
				if(anIntArray604[i] != 255 && anIntArray604[i + 1] == 255 || anIntArray604[i] == 0 && anIntArray604[i + 1] != 0) {
					int j = anIntArray604[i];
					anIntArray604[i] = anIntArray604[i + 1];
					anIntArray604[i + 1] = j;
					long l = aLongArray602[i];
					aLongArray602[i] = aLongArray602[i + 1];
					aLongArray602[i + 1] = l;
					flag = true;
				}

		}
	}

	protected final void method23(long l) {
		packetStream.createPacket(241);
		packetStream.method332(l);
		packetStream.endPacket();
		for(int i = 0; i < anInt606; i++)
			if(aLongArray605[i] == l) {
				anInt606--;
				for(int j = i; j < anInt606; j++)
					aLongArray605[j] = aLongArray605[j + 1];
				return;
			}
	}

	protected void method24() {
	}

	protected void method25() {
	}

	protected boolean method26() {
		return true;
	}

	protected final void method27(long l, byte[] abyte0, int i) {
		packetStream.createPacket(218);
		packetStream.method332(l);
		packetStream.method325(abyte0, 0, i);
		packetStream.endPacket();
	}

	protected final void checkConnection() {
		long l = System.currentTimeMillis();
		if(packetStream.method331())
			aLong607 = l;
		if(l - aLong607 > 5000L) {
			aLong607 = l;
			packetStream.createPacket(67);
			packetStream.endPacket();
		}
		try {
			packetStream.method328(20);
		}
		catch(IOException _ex) {
			lostConnection();
			return;
		}
		if(!method26())
			return;
		int i = packetStream.method336(aByteArray608);
		if(i > 0)
			method34(aByteArray608[0] & 0xff, i);
	}

	protected final void method29(String s) {
		packetStream.createPacket(195);
		packetStream.method332(DataUtils.method356(s));
		packetStream.endPacket();
		long l = DataUtils.method356(s);
		for(int i = 0; i < anInt603; i++)
			if(aLongArray602[i] == l)
				return;

		if(anInt603 >= 100) {
        } else {
			aLongArray602[anInt603] = l;
			anIntArray604[anInt603] = 0;
			anInt603++;
        }
	}

	protected final void method30(String s, String s1) {
		Graphics g = getGraphics();
		Font font = new Font("Helvetica", 1, 15);
		char c = '\u0200';
		char c1 = '\u0158';
		g.setColor(Color.black);
		g.fillRect(c / 2 - 140, c1 / 2 - 25, 280, 50);
		g.setColor(Color.white);
		g.drawRect(c / 2 - 140, c1 / 2 - 25, 280, 50);
		method8(g, s, font, c / 2, c1 / 2 - 10);
		method8(g, s1, font, c / 2, c1 / 2 + 10);
	}

	protected void method31() {
	}

	protected final void sendChatMessagePacket(byte[] abyte0, int i) {
		packetStream.createPacket(216);
		packetStream.method325(abyte0, 0, i);
		packetStream.endPacket();
	}

	protected final void method33(int i, int j, int k, int l) {
		packetStream.createPacket(64);
		packetStream.putByte(i);
		packetStream.putByte(j);
		packetStream.putByte(k);
		packetStream.putByte(l);
		packetStream.endPacket();
	}

	private final void method34(int i, int j) {
		i = packetStream.method322(i);
		if(i == 131) {
			String s = new String(aByteArray608, 1, j - 1);
			method44(s);
		}
		if(i == 4)
			closeConnection();
		if(i == 183) {
			method25();
			return;
		}
		if(i == 71) {
			anInt603 = DataUtils.method340(aByteArray608[1]);
			for(int k = 0; k < anInt603; k++) {
				aLongArray602[k] = DataUtils.method348(aByteArray608, 2 + k * 9);
				anIntArray604[k] = DataUtils.method340(aByteArray608[10 + k * 9]);
			}

			method22();
			return;
		}
		if(i == 149) {
			long l = DataUtils.method348(aByteArray608, 1);
			int j1 = aByteArray608[9] & 0xff;
			for(int i2 = 0; i2 < anInt603; i2++)
				if(aLongArray602[i2] == l) {
					if(anIntArray604[i2] == 0 && j1 != 0)
						method44("@pri@" + DataUtils.method351(l) + " has logged in");
					if(anIntArray604[i2] != 0 && j1 == 0)
						method44("@pri@" + DataUtils.method351(l) + " has logged out");
					anIntArray604[i2] = j1;
					j = 0;
					method22();
					return;
				}

			aLongArray602[anInt603] = l;
			anIntArray604[anInt603] = j1;
			anInt603++;
			method22();
			return;
		}
		if(i == 109) {
			anInt606 = DataUtils.method340(aByteArray608[1]);
			for(int i1 = 0; i1 < anInt606; i1++)
				aLongArray605[i1] = DataUtils.method348(aByteArray608, 2 + i1 * 8);

			return;
		}
		if(i == 51) {
			anInt609 = aByteArray608[1];
			anInt610 = aByteArray608[2];
			anInt611 = aByteArray608[3];
			anInt612 = aByteArray608[4];
			return;
		}
		if(i == 120) {
			long l1 = DataUtils.method348(aByteArray608, 1);
			int k1 = DataUtils.method343(aByteArray608, 9);
			for(int j2 = 0; j2 < 100; j2++)
				if(anIntArray613[j2] == k1)
					return;

			anIntArray613[anInt614] = k1;
			anInt614 = (anInt614 + 1) % 100;
			String s1 = ChatEncoding.method388(aByteArray608, 13, j - 13);
			method44("@pri@" + DataUtils.method351(l1) + ": tells you " + s1);
        } else {
			method43(i, j, aByteArray608);
        }
	}

	protected final void sendCommandString(String s) {
		packetStream.createPacket(38);
		packetStream.method329(s);
		packetStream.endPacket();
	}

	protected final void closeConnection() {
		if(packetStream != null)
			try {
				packetStream.createPacket(31);
				packetStream.method335();
			}
			catch(IOException _ex) { }
		aString615 = "";
		aString616 = "";
		method24();
	}

	protected void lostConnection() {
		System.out.println("Lost connection");
		anInt617 = 10;
		method39(aString615, aString616, true);
	}

	protected int method38() {
		return 0;
	}

	public NetworkedGame() {
		aString619 = "game.openrsc.com";
		anInt620 = 43596;
		aString615 = "";
		aString616 = "";
		aByteArray608 = new byte[5000];
		aLongArray602 = new long[200];
		anIntArray604 = new int[200];
		aLongArray605 = new long[100];
		anIntArray613 = new int[100];
	}

	protected final void method39(String s, String s1, boolean flag) {
		if(anInt618 > 0) {
			method41("Please wait...", "Connecting to server");
			try {
				Thread.sleep(2000L);
			}
			catch(Exception _ex) { }
			method41("Sorry! The server is currently full.", "Please try again later");
			return;
		}
		try {
			aString615 = s;
			s = DataUtils.method355(s, 20);
			aString616 = s1;
			s1 = DataUtils.method355(s1, 20);
			if(s.trim().length() == 0) {
				method41("You must enter both a username", "and a password - Please try again");
				return;
			}
			if(flag)
				method30("Connection lost! Please wait...", "Attempting to re-establish");
			else
				method41("Please wait...", "Connecting to server");
			packetStream = new ClientStream(method12(aString619, anInt620), this);
			packetStream.anInt538 = anInt621;
			long l = DataUtils.method356(s);
			packetStream.createPacket(32);
			packetStream.putByte((int)(l >> 16 & 31L));
			packetStream.method335();
			long l1 = packetStream.method326();
			System.out.println("Session ID: " + l1);
			sessionID = l1;
			if(l1 == 0L) {
				method41("Login server offline.", "Please try again in a few mins");
				return;
			}
			int i = 0;
			try {
				if(method14()) {
					String s2 = getParameter("limit30");
					if(s2.equals("1"))
						i = 1;
				}
			}
			catch(Exception _ex) { }
			int[] ai = new int[4];
			ai[0] = (int)(Math.random() * 99999999D);
			ai[1] = (int)(Math.random() * 99999999D);
			ai[2] = (int)(l1 >> 32);
			ai[3] = (int)l1;
			ByteBuffer bytebuffer = new ByteBuffer(new byte[500]);
			bytebuffer.anInt513 = 0;
			bytebuffer.method318(10);
			bytebuffer.method314(ai[0]);
			bytebuffer.method314(ai[1]);
			bytebuffer.method314(ai[2]);
			bytebuffer.method314(ai[3]);
			bytebuffer.method314(method38());
			bytebuffer.method320(s);
			bytebuffer.method320(s1);
			bytebuffer.method319(aBigInteger623, aBigInteger624);
			packetStream.createPacket(0);
			if(flag)
				packetStream.putByte(1);
			else
				packetStream.putByte(0);
			packetStream.putShort(anInt625);
			packetStream.putByte(i);
			packetStream.method325(bytebuffer.aByteArray512, 0, bytebuffer.anInt513);
			packetStream.method335();
			packetStream.method334(ai);
			int j = packetStream.method324();
			if(j == 25) {
				anInt626 = 1;
				anInt617 = 0;
				method31();
				return;
			}
			if(j == 0) {
				anInt626 = 0;
				anInt617 = 0;
				method31();
				return;
			}
			if(j == 1) {
				anInt617 = 0;
				method42();
				return;
			}
			if(flag) {
				s = "";
				s1 = "";
				method24();
				return;
			}
			if(j == -1) {
				method41("Error unable to login.", "Server timed out");
				return;
			}
			if(j == 3) {
				method41("Invalid username or password.", "Try again, or create a new account");
				return;
			}
			if(j == 4) {
				method41("That username is already logged in.", "Wait 60 seconds then retry");
				return;
			}
			if(j == 5) {
				method41("The client has been updated.", "Please reload this page");
				return;
			}
			if(j == 6) {
				method41("You may only use 1 character at once.", "Your ip-address is already in use");
				return;
			}
			if(j == 7) {
				method41("Login attempts exceeded!", "Please try again in 5 minutes");
				return;
			}
			if(j == 8) {
				method41("Error unable to login.", "Server rejected session");
				return;
			}
			if(j == 9) {
				method41("Error unable to login.", "Loginserver rejected session");
				return;
			}
			if(j == 10) {
				method41("That username is already in use.", "Wait 60 seconds then retry");
				return;
			}
			if(j == 11) {
				method41("Account temporarily disabled.", "Check your message inbox for details");
				return;
			}
			if(j == 12) {
				method41("Account permanently disabled.", "Check your message inbox for details");
				return;
			}
			if(j == 14) {
				method41("Sorry! This world is currently full.", "Please try a different world");
				anInt618 = 1500;
				return;
			}
			if(j == 15) {
				method41("You need a members account", "to login to this world");
				return;
			}
			if(j == 16) {
				method41("Error - no reply from loginserver.", "Please try again");
				return;
			}
			if(j == 17) {
				method41("Error - failed to decode profile.", "Contact customer support");
				return;
			}
			if(j == 18) {
				method41("Account suspected stolen.", "Press 'recover a locked account' on front page.");
				return;
			}
			if(j == 20) {
				method41("Error - loginserver mismatch", "Please try a different world");
				return;
			}
			if(j == 21) {
				method41("Unable to login.", "That is not an RS-Classic account");
				return;
			}
			if(j == 22) {
				method41("Password suspected stolen.", "Press 'change your password' on front page.");
				return;
			} else {
				method41("Error unable to login.", "Unrecognised response code");
				return;
			}
		}
		catch(Exception exception) {
			exception.printStackTrace();
		}
		if(anInt617 > 0) {
			try {
				Thread.sleep(5000L);
			}
			catch(Exception _ex) { }
			anInt617--;
			method39(aString615, aString616, flag);
		}
		if(flag) {
			aString615 = "";
			aString616 = "";
			method24();
		} else {
			method41("Sorry! Unable to connect.", "Check internet settings or try another world");
		}
	}

	protected final void method40(String s) {
		long l = DataUtils.method356(s);
		packetStream.createPacket(132);
		packetStream.method332(l);
		packetStream.endPacket();
		for(int i = 0; i < anInt606; i++)
			if(aLongArray605[i] == l)
				return;

		if(anInt606 >= 100) {
        } else {
			aLongArray605[anInt606++] = l;
        }
	}

	protected void method41(String s, String s1) {
	}

	protected void method42() {
	}

	protected void method43(int i, int j, byte[] abyte0) {
	}

	protected void method44(String s) {
	}

	private final int anInt600 = 100;
	public ClientStream packetStream;
	public long[] aLongArray602;
	public int anInt603;
	public int[] anIntArray604;
	public long[] aLongArray605;
	public int anInt606;
	long aLong607;
	byte[] aByteArray608;
	public int anInt609;
	public int anInt610;
	public int anInt611;
	public int anInt612;
	private final int[] anIntArray613;
	private int anInt614;
	String aString615;
	String aString616;
	int anInt617;
	public int anInt618;
	public String aString619;
	public int anInt620;
	public static int anInt621;
	public long sessionID;
	private static final BigInteger aBigInteger623 = new BigInteger("65537");
	private static final BigInteger aBigInteger624 = new BigInteger("7112866275597968156550007489163685737528267584779959617759901583041864787078477876689003422509099353805015177703670715380710894892460637136582066351659813");
	public static int anInt625 = 1;
	public int anInt626;

}
