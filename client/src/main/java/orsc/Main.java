package orsc;


import meteor.Logger;
import meteor.plugins.PluginManager;
import meteor.plugins.meteor.MeteorConfig;
import meteor.ui.overlay.OverlayManager;
import meteor.ui.overlay.OverlayRenderer;
import net.runelite.api.Client;
import orsc.util.Utils;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class Main extends Applet {

	private static JFrame jframe;
	private static final long serialVersionUID = 1L;
	public static Client client;
	public static OverlayManager overlayManager = OverlayManager.INSTANCE;
	public static MeteorConfig meteorConfig  = null;
	public static Logger logger = new Logger("Main");
	public static OverlayRenderer overlayRenderer = new OverlayRenderer();

	public static void main(String[] args) {
		SwingUtilities.invokeLater(Main::createAndShowGUI);
	}

	public static void createAndShowGUI() {
		try {
			jframe = new JFrame(Config.getServerNameWelcome());
			final java.applet.Applet applet = new Main();
			//Here we add 12 because 12 was added back in 2009 for the skip tutorial line.
			applet.setPreferredSize(new Dimension(512, 334 + 12));
			jframe.getContentPane().setLayout(new BorderLayout());
			jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			jframe.setIconImage(Utils.getImage("icon.png").getImage());
			jframe.setTitle(Config.WINDOW_TITLE);
			jframe.getContentPane().add(applet);
			jframe.setResizable(false); // true or false based on server sent config
			jframe.setVisible(true);
			//jframe.setAlwaysOnTop(true);
			jframe.setBackground(Color.black);
			//Just like above, here we add 12 because 12 was added back in 2009 for the skip tutorial line.
			//We also add 32 for the custom login screen.
			jframe.setMinimumSize(new Dimension(512, 334 + 12 + 32));
			jframe.pack();
			jframe.setLocationRelativeTo(null);
			applet.init();
			applet.start();
			client = (Client) (Object) mudclient;
			client.setCallbacks(new Hooks());
			PluginManager.INSTANCE.start();
		} catch (HeadlessException e) {
			e.printStackTrace();
		}
	}

	public void setTitle(String title) {
		jframe.setTitle(title);
	}

	public void setIconImage(String serverName) {
		switch (serverName) {
			case "RSC Coleslaw":
				jframe.setIconImage(Utils.getImage("coleslaw.icon.png").getImage());
				break;
			case "RSC Uranium":
				jframe.setIconImage(Utils.getImage("uranium.icon.png").getImage());
				break;
			case "RSC Cabbage":
				jframe.setIconImage(Utils.getImage("cabbage.icon.png").getImage());
				break;
			case "OpenPK":
				jframe.setIconImage(Utils.getImage("openpk.icon.png").getImage());
				break;
			default:
				jframe.setIconImage(Utils.getImage("icon.png").getImage());
		}
	}

	public String getCacheLocation() {
		return Config.F_CACHE_DIR + File.separator;
	}

	@Override
	public void playSound(byte[] soundData, int offset, int dataLength) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public void stopSoundPlayer() {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	public boolean getResizable() {
		return Config.allowResize1();
	}
}
