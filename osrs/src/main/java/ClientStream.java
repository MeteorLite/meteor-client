// Decompiled by Jad v1.5.8c. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

import java.io.*;
import java.net.Socket;

public class ClientStream extends Stream
	implements Runnable {

	public int method330() throws IOException {
		if(aBoolean628)
			return 0;
		else
			return anInputStream629.available();
	}

	public void method338(byte[] abyte0, int i, int j) throws IOException {
		if(aBoolean628)
			return;
		if(aByteArray630 == null)
			aByteArray630 = new byte[5000];
		synchronized(this) {
			for(int k = 0; k < j; k++) {
				aByteArray630[anInt631] = abyte0[k + i];
				anInt631 = (anInt631 + 1) % 5000;
				if(anInt631 == (anInt632 + 4900) % 5000)
					throw new IOException("buffer overflow");
			}

			notify();
		}
	}

	public void method339() {
		super.method339();
		aBoolean628 = true;
		try {
			if(anInputStream629 != null)
				anInputStream629.close();
			if(anOutputStream633 != null)
				anOutputStream633.close();
			if(aSocket634 != null)
				aSocket634.close();
		}
		catch(IOException _ex) {
			System.out.println("Error closing stream");
		}
		aBoolean635 = true;
		synchronized(this) {
			notify();
		}
		aByteArray630 = null;
	}

	public void method333(int i, int j, byte[] abyte0) throws IOException {
		if(aBoolean628)
			return;
		int k = 0;
		boolean flag = false;
		int l;
		for(; k < i; k += l)
			if((l = anInputStream629.read(abyte0, k + j, i - k)) <= 0)
				throw new IOException("EOF");

	}

	public int method324() throws IOException {
		if(aBoolean628)
			return 0;
		else
			return anInputStream629.read();
	}

	public ClientStream(Socket socket, GameShell gameshell) throws IOException {
		System.out.println(socket.getInetAddress() + ":" + socket.getPort());
		aBoolean628 = false;
		aBoolean635 = true;
		aSocket634 = socket;
		anInputStream629 = socket.getInputStream();
		anOutputStream633 = socket.getOutputStream();
		aBoolean635 = false;
		gameshell.method16(this);
	}

	public void run() {
		while(!aBoolean635)  {
			int i;
			int j;
			synchronized(this) {
				if(anInt631 == anInt632)
					try {
						wait();
					}
					catch(InterruptedException _ex) { }
				if(aBoolean635)
					return;
				j = anInt632;
				if(anInt631 >= anInt632)
					i = anInt631 - anInt632;
				else
					i = 5000 - anInt632;
			}
			if(i > 0) {
				try {
					anOutputStream633.write(aByteArray630, j, i);
				}
				catch(IOException ioexception) {
					super.aBoolean531 = true;
					super.aString532 = "Twriter:" + ioexception;
				}
				anInt632 = (anInt632 + i) % 5000;
				try {
					if(anInt631 == anInt632)
						anOutputStream633.flush();
				}
				catch(IOException ioexception1) {
					super.aBoolean531 = true;
					super.aString532 = "Twriter:" + ioexception1;
				}
			}
		}
	}

	private boolean aBoolean628;
	private final InputStream anInputStream629;
	private byte[] aByteArray630;
	private int anInt631;
	private int anInt632;
	private final OutputStream anOutputStream633;
	private final Socket aSocket634;
	private boolean aBoolean635;
}
