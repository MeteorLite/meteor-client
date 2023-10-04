// Decompiled by Jad v1.5.8c. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

import java.io.File;

import javax.sound.sampled.*;

public class SoundPlayer {

	public static void play(String soundName) {
		File sound = mudclient.soundCache.get(soundName + ".wav");
		if (sound == null) {
			System.out.println("Sound doesn't exist: " + soundName + ".wav");
			return;
		}
		try {
			final Clip clip = AudioSystem.getClip();
			clip.addLineListener(myLineEvent -> {
				if (myLineEvent.getType() == LineEvent.Type.STOP)
					clip.close();
			});
			clip.open(AudioSystem.getAudioInputStream(sound));
			clip.start();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
