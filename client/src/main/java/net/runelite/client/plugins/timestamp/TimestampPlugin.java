/*
 * Copyright (c) 2018, Magic fTail
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.timestamp;

import com.google.inject.Provides;
import eventbus.events.ConfigChanged;
import eventbus.events.ScriptCallbackEvent;
import lombok.Getter;
import meteor.Main;
import meteor.config.ConfigManager;
import meteor.plugins.Plugin;
import meteor.plugins.PluginDescriptor;
import meteor.rs.ClientThread;
import meteor.util.ColorUtil;
import net.runelite.api.Client;
import net.runelite.api.MessageNode;
import net.runelite.api.ScriptID;
import net.runelite.api.Varbits;

import javax.inject.Inject;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

@PluginDescriptor(
	name = "Chat Timestamps",
	description = "Add timestamps to chat messages",
	tags = {"timestamp"},
	enabledByDefault = false
)
public class TimestampPlugin extends Plugin
{
	private Client client = Main.client;
	private ClientThread clientThread = ClientThread.INSTANCE;
	private TimestampConfig config = configuration(TimestampConfig.class);

	@Getter
	private SimpleDateFormat formatter;

	@Override
	public void onStart()
	{
		updateFormatter();
	}

	@Override
	public void onStop()
	{
		formatter = null;
	}

	@Override
	public void onConfigChanged(ConfigChanged event)
	{
		if (event.getGroup().equals(TimestampConfig.GROUP))
		{
			switch (event.getKey())
			{
				case "format":
					updateFormatter();
					break;
				case "opaqueTimestamp":
				case "transparentTimestamp":
					clientThread.invokeLater(() -> client.runScript(ScriptID.SPLITPM_CHANGED));
					break;
			}
		}
	}

	@Override
	public void onScriptCallbackEvent(ScriptCallbackEvent event)
	{
		if (!"chatMessageBuilding".equals(event.getEventName()))
		{
			return;
		}

		int uid = client.getIntStack()[client.getIntStackSize() - 1];
		final MessageNode messageNode = client.getMessages().get(uid);
		assert messageNode != null : "chat message build for unknown message";

		String timestamp = generateTimestamp(messageNode.getTimestamp(), ZoneId.systemDefault());
		
		Color timestampColour = getTimestampColour();
		if (timestampColour != null)
		{
			timestamp = ColorUtil.wrapWithColorTag(timestamp, timestampColour);
		}

		client.getStringStack()[client.getStringStackSize() - 1] = timestamp;
	}

	private Color getTimestampColour()
	{
		boolean isChatboxTransparent = client.isResized() && client.getVarbitValue(Varbits.TRANSPARENT_CHATBOX) == 1;

		return isChatboxTransparent ? config.transparentTimestamp() : config.opaqueTimestamp();
	}

	String generateTimestamp(int timestamp, ZoneId zoneId)
	{
		final ZonedDateTime time = ZonedDateTime.ofInstant(
			Instant.ofEpochSecond(timestamp), zoneId);

		return formatter.format(Date.from(time.toInstant()));
	}

	private void updateFormatter()
	{
		try
		{
			formatter = new SimpleDateFormat(config.timestampFormat());
		}
		catch (IllegalArgumentException e)
		{
			formatter = new SimpleDateFormat("[HH:mm]");
		}
	}
}