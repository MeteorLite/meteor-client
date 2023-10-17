package orsc.multiclient;

import com.openrsc.client.model.Sprite;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import orsc.Config;

public interface ClientPort {

	boolean drawLoading(int i);

	void showLoadingProgress(int percentage, String status);

	void initListeners();

	void crashed();

	void drawLoadingError();

	void drawOutOfMemoryError();

	boolean isDisplayable();

	void drawTextBox(String line2, byte var2, String line1);

	void initGraphics();

	void draw();

	void close();

	String getCacheLocation();

	Sprite getBattery(int level);

	int getBatteryPercent();

	boolean getBatteryCharging();

	Sprite getConnectivity(int level);

	String getConnectivityText();

	void resized();

	Sprite getSpriteFromByteArray(ByteArrayInputStream byteArrayInputStream);

	void playSound(byte[] soundData, int offset, int dataLength);

	void stopSoundPlayer();

	void drawKeyboard();

	void closeKeyboard();

	void setTitle(String title);

	void setIconImage(String serverName);

}
