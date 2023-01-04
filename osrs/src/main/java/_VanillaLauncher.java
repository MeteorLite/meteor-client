import javax.swing.*;
import java.applet.Applet;
import java.applet.AppletContext;
import java.applet.AppletStub;
import java.applet.AudioClip;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.InvalidParameterException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class _VanillaLauncher implements AppletStub, AppletContext {
    static _VanillaLauncher INSTANCE = new _VanillaLauncher();
    public static JFrame gameWindow = new JFrame("Old-School Runescape");
    public static BorderLayout borderLayout = new BorderLayout();
    public static JPanel game = new JPanel(borderLayout);

    static Map<String, String> properties = new HashMap<>();
    static Map<String, String> parameters = new HashMap<>();

    public static void main(String[] args) {
        INSTANCE.load();
    }

    public void load() {
        gameWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        RuneLiteMenuEntry.isVanilla = true;
        loadParamaters();
        gameWindow.setSize(1280, 720);
        game.setSize(1280, 720);
        Client client = new Client();
        game.add(client, null);
        client.setStub(this);
        gameWindow.add(game);
        gameWindow.setVisible(true);
        client.init();
        client.start();

    }

    public static void loadParamaters() {
        URL url = null;
        try {
            url = new URL("http://oldschool.runescape.com/jav_config.ws");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(), StandardCharsets.ISO_8859_1))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] split1 = line.split("=", 2);
                switch (split1[0]) {
                    case "param":
                        String[] split2 = split1[1].split("=", 2);
                        parameters.put(split2[0], split2[1]);
                        break;
                    case "msg":
                        // ignore
                        break;
                    default:
                        properties.put(split1[0], split1[1]);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override public URL getCodeBase() {
        try {
            return new URL(properties.get("codebase"));
        } catch (MalformedURLException e) {
            throw new InvalidParameterException();
        }
    }

    @Override public URL getDocumentBase() {
        return getCodeBase();
    }

    @Override public boolean isActive() {
        return true;
    }

    @Override public String getParameter(String name) {
        return parameters.get(name);
    }

    @Override public void showDocument(URL url) {
        try {
            Desktop.getDesktop().browse(url.toURI());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override public void showDocument(URL url, String target) {
        showDocument(url);
    }

    @Override public AppletContext getAppletContext() {
        return this;
    }

    @Override public void appletResize(int width, int height) {}

    @Override public AudioClip getAudioClip(URL url) {
        throw new UnsupportedOperationException();
    }

    @Override public Image getImage(URL url) {
        throw new UnsupportedOperationException();
    }

    @Override public Applet getApplet(String name) {
        throw new UnsupportedOperationException();
    }

    @Override public Enumeration<Applet> getApplets() {
        throw new UnsupportedOperationException();
    }

    @Override public void showStatus(String status) {
        throw new UnsupportedOperationException();
    }

    @Override public void setStream(String key, InputStream stream) {
        throw new UnsupportedOperationException();
    }

    @Override public InputStream getStream(String key) {
        throw new UnsupportedOperationException();
    }

    @Override public Iterator<String> getStreamKeys() {
        throw new UnsupportedOperationException();
    }
}
