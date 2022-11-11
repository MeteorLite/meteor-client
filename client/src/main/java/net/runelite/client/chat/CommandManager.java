/*
 * Copyright (c) 2018, Kamiel
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
package net.runelite.client.chat;

import eventbus.Events;
import eventbus.events.ScriptCallbackEvent;
import lombok.extern.slf4j.Slf4j;
import meteor.Logger;
import meteor.Main;
import meteor.events.ChatboxInput;
import meteor.plugins.EventSubscriber;
import meteor.rs.ClientThread;
import net.runelite.api.Client;
import net.runelite.api.ScriptID;
import net.runelite.api.VarClientStr;
import net.runelite.client.events.CommandExecuted;
import net.runelite.client.events.PrivateMessageInput;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CommandManager extends EventSubscriber
{
	private Logger log = new Logger("Slayer");

	public static final CommandManager INSTANCE = new CommandManager();
	private static final String RUNELITE_COMMAND = "runeliteCommand";
	private static final String CHATBOX_INPUT = "chatboxInput";
	private static final String PRIVATE_MESSAGE = "privateMessage";

	private final Client client = Main.INSTANCE.getClient();
	private final ClientThread clientThread = ClientThread.INSTANCE;
	private boolean sending;

	private final List<ChatboxInputListener> chatboxInputListenerList = new CopyOnWriteArrayList<>();

	private CommandManager()
	{
		subscribe();
	}

	public void register(ChatboxInputListener chatboxInputListener)
	{
		chatboxInputListenerList.add(chatboxInputListener);
	}

	public void unregister(ChatboxInputListener chatboxInputListener)
	{
		chatboxInputListenerList.remove(chatboxInputListener);
	}

	@Override
	public void onScriptCallbackEvent(ScriptCallbackEvent event)
	{
		if (sending)
		{
			return;
		}

		switch (event.getEventName())
		{
			case RUNELITE_COMMAND:
				runCommand();
				break;
			case CHATBOX_INPUT:
				handleInput(event);
				break;
			case PRIVATE_MESSAGE:
				handlePrivateMessage(event);
				break;
		}
	}

	private void runCommand()
	{
		String typedText = client.getVar(VarClientStr.CHATBOX_TYPED_TEXT).substring(2); // strip ::

		log.debug("Command: {}", typedText);

		String[] split = typedText.split(" ");

		// Fixes ArrayIndexOutOfBounds when typing ":: "
		if (split.length == 0)
		{
			return;
		}

		String command = split[0];
		String[] args = Arrays.copyOfRange(split, 1, split.length);

		CommandExecuted commandExecuted = new CommandExecuted(command, args);
		client.getCallbacks().post(Events.COMMAND_EXECUTED, commandExecuted);
	}

	private void handleInput(ScriptCallbackEvent event)
	{
		final String[] stringStack = client.getStringStack();
		final int[] intStack = client.getIntStack();
		int stringStackCount = client.getStringStackSize();
		int intStackCount = client.getIntStackSize();

		final String typedText = stringStack[stringStackCount - 1];
		final int chatType = intStack[intStackCount - 2];
		final int clanTarget = intStack[intStackCount - 1];

		ChatboxInput chatboxInput = new ChatboxInput(typedText, chatType)
		{
			private boolean resumed;

			@Override
			public void resume()
			{
				if (resumed)
				{
					return;
				}
				resumed = true;

				clientThread.invoke(() -> sendChatboxInput(typedText, chatType, clanTarget));
			}
		};
		boolean stop = false;
		for (ChatboxInputListener chatboxInputListener : chatboxInputListenerList)
		{
			stop |= chatboxInputListener.onChatboxInput(chatboxInput);
		}

		if (stop)
		{
			// input was blocked.
			stringStack[stringStackCount - 1] = ""; // prevent script from sending
		}
	}

	private void handlePrivateMessage(ScriptCallbackEvent event)
	{
		final String[] stringStack = client.getStringStack();
		final int[] intStack = client.getIntStack();
		int stringStackCount = client.getStringStackSize();
		int intStackCount = client.getIntStackSize();

		final String target = stringStack[stringStackCount - 2];
		final String message = stringStack[stringStackCount - 1];

		PrivateMessageInput privateMessageInput = new PrivateMessageInput(target, message)
		{
			private boolean resumed;

			@Override
			public void resume()
			{
				if (resumed)
				{
					return;
				}
				resumed = true;

				clientThread.invoke(() -> sendPrivmsg(target, message));
			}
		};

		boolean stop = false;
		for (ChatboxInputListener chatboxInputListener : chatboxInputListenerList)
		{
			stop |= chatboxInputListener.onPrivateMessageInput(privateMessageInput);
		}

		if (stop)
		{
			intStack[intStackCount - 1] = 1;
			client.setStringStackSize(stringStackCount - 2); // remove both target and message
		}
	}

	private void sendChatboxInput(String input, int chatType, int clanTarget)
	{
		sending = true;
		try
		{
			client.runScript(ScriptID.CHAT_SEND, input, chatType, clanTarget, 0, -1);
		}
		finally
		{
			sending = false;
		}
	}

	private void sendPrivmsg(String target, String message)
	{
		client.runScript(ScriptID.PRIVMSG, target, message);
	}
}
