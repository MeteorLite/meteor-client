/*
 * Copyright (c) 2018, SomeoneWithAnInternetConnection
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package mixins;

import eventbus.Events;
import eventbus.events.AreaSoundEffectPlayed;
import eventbus.events.SoundEffectPlayed;
import eventbus.events.SoundEffectReceived;
import net.runelite.api.SoundEffectVolume;
import net.runelite.api.mixins.*;
import net.runelite.rs.api.RSActor;
import net.runelite.rs.api.RSClient;
import net.runelite.rs.api.RSPcmStream;
import net.runelite.rs.api.RSRawPcmStream;
import net.runelite.rs.api.RSRawSound;
import net.runelite.rs.api.RSSoundEffect;

@Mixin(RSClient.class)
public abstract class SoundEffectMixin implements RSClient
{
	@Shadow("client")
	private static RSClient client;

	@Inject
	private static int lastSoundEffectCount;

	@Inject
	private static RSActor lastSoundEffectSourceActor;

	@Copy("updateActorSequence")
	@Replace("updateActorSequence")
	@SuppressWarnings("InfiniteRecursion")
	public static void copy$updateActorSequence(RSActor actor, int size)
	{
		lastSoundEffectSourceActor = actor;

		copy$updateActorSequence(actor, size);

		lastSoundEffectSourceActor = null;
	}

	@FieldHook("soundEffectCount")
	@Inject
	public static void queuedSoundEffectCountChanged(int idx)
	{
		int soundCount = client.getQueuedSoundEffectCount();
		if (soundCount == lastSoundEffectCount + 1)
		{
			int soundIndex = soundCount - 1;
			int packedLocation = client.getSoundLocations()[soundIndex];
			boolean consumed;

			if (packedLocation == 0)
			{
				// Regular sound effect
				SoundEffectPlayed event = new SoundEffectPlayed(lastSoundEffectSourceActor,
						client.getQueuedSoundEffectIDs()[soundIndex],
						client.getQueuedSoundEffectDelays()[soundIndex]);
				client.getCallbacks().post(Events.SOUND_EFFECT_PLAYED, event);
				consumed = event.getConsumed();
			}
			else
			{
				// Area sound effect

				int x = (packedLocation >> 16) & 0xFF;
				int y = (packedLocation >> 8) & 0xFF;
				int range = (packedLocation) & 0xFF;

				AreaSoundEffectPlayed event = new AreaSoundEffectPlayed(lastSoundEffectSourceActor,
						client.getQueuedSoundEffectIDs()[soundIndex], x, y, range,
						client.getQueuedSoundEffectDelays()[soundIndex],
						client.getQueuedSoundEffectLoops()[soundIndex]);
				client.getCallbacks().post(Events.AREA_SOUND_EFFECT_PLAYED, event);
				consumed = event.getConsumed();
			}

			if (consumed)
			{
				soundCount--;
				client.setQueuedSoundEffectCount(soundCount);
			}
		}


		lastSoundEffectCount = soundCount;
	}

	@Inject
	@Override
	public void playSoundEffect(int id)
	{
		playSoundEffect(id, 0, 0, 0, 0);
	}

	@Inject
	@Override
	public void playSoundEffect(int id, int x, int y, int range)
	{
		playSoundEffect(id, x, y, range, 0);
	}

	@Inject
	@Override
	public void playSoundEffect(int id, int x, int y, int range, int delay)
	{
		assert this.isClientThread() : "playSoundEffect must be called on client thread!";
		int position = ((x & 255) << 16) + ((y & 255) << 8) + (range & 255);

		int[] queuedSoundEffectIDs = getQueuedSoundEffectIDs();
		int[] queuedSoundEffectLoops = getQueuedSoundEffectLoops();
		int[] queuedSoundEffectDelays = getQueuedSoundEffectDelays();
		RSSoundEffect[] audioEffects = getAudioEffects();
		int[] soundLocations = getSoundLocations();
		int queuedSoundEffectCount = getQueuedSoundEffectCount();

		queuedSoundEffectIDs[queuedSoundEffectCount] = id;
		queuedSoundEffectLoops[queuedSoundEffectCount] = 1;
		queuedSoundEffectDelays[queuedSoundEffectCount] = delay;
		audioEffects[queuedSoundEffectCount] = null;
		soundLocations[queuedSoundEffectCount] = position;

		setQueuedSoundEffectCount(queuedSoundEffectCount + 1);
		lastSoundEffectCount = queuedSoundEffectCount + 1;
	}

	@Inject
	@Override
	public void playSoundEffect(int id, int volume)
	{
		assert client.isClientThread() : "playSoundEffect must be called on client thread";
		RSSoundEffect soundEffect = getTrack(getIndexCache4(), id, 0);
		if (soundEffect == null)
		{
			return;
		}

		// If the current volume is not muted, use it instead
		final int soundEffectVolume = client.getPreferences().getSoundEffectVolume();
		if (soundEffectVolume != SoundEffectVolume.MUTED)
		{
			volume = soundEffectVolume;
		}

		RSRawSound rawAudioNode = soundEffect.toRawAudioNode().applyResampler(getSoundEffectResampler());
		RSRawPcmStream rawPcmStream = createRawPcmStream(rawAudioNode, 100, volume);
		rawPcmStream.setNumLoops$api(1);

		getSoundEffectAudioQueue().addSubStream((RSPcmStream) rawPcmStream);
	}

    @Inject
    @MethodHook("queueSoundEffect")
    public static void soundEffectReceived(int id, int numLoops, int delay) {
        SoundEffectReceived event = new SoundEffectReceived(id, numLoops, delay);
        client.getCallbacks().post(Events.SOUND_EFFECT_RECEIVED, event);
    }
}
