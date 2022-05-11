/*
 * Copyright (c) 2017, Seth <Sethtroll3@gmail.com>
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
package net.runelite.client.plugins.loginscreen;

import com.google.common.base.Strings;
import eventbus.events.ConfigChanged;
import eventbus.events.GameStateChanged;
import lombok.extern.slf4j.Slf4j;
import meteor.input.KeyListener;
import meteor.input.KeyManager;
import meteor.plugins.Plugin;
import meteor.plugins.PluginDescriptor;
import meteor.rs.ClientThread;
import meteor.util.ImageUtil;
import meteor.util.OSType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.SpritePixels;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

@PluginDescriptor(
	name = "Login Screen",
	description = "Provides various enhancements for login screen"
)
@Slf4j
public class LoginScreenPlugin extends Plugin implements KeyListener
{
	private static final int MAX_USERNAME_LENGTH = 254;
	private static final int MAX_PIN_LENGTH = 6;
	private Client client;

	private ClientThread clientThread;

	private LoginScreenConfig config;

	private KeyManager keyManager;

	private String usernameCache;

	@Override
	public void onStart()
	{
		applyUsername();
		keyManager.registerKeyListener(this, LoginScreenPlugin.class);
		clientThread.invoke(this::overrideLoginScreen);
	}

	@Override
	public void onStop()
	{
		if (config.syncUsername())
		{
			client.getPreferences().setRememberedUsername(usernameCache);
		}

		keyManager.unregisterKeyListener(this);
		clientThread.invoke(() ->
		{
			restoreLoginScreen();
			client.setShouldRenderLoginScreenFire(true);
		});
	}

	@Override
	public void onConfigChanged(ConfigChanged event)
	{
		if (event.getGroup().equals("loginscreen"))
		{
			clientThread.invoke(this::overrideLoginScreen);
		}
	}

	@Override
	public void onGameStateChanged(GameStateChanged event)
	{
		if (!config.syncUsername())
		{
			return;
		}

		if (event.getGameState() == GameState.LOGIN_SCREEN)
		{
			applyUsername();
		}
		else if (event.getGameState() == GameState.LOGGED_IN)
		{
			String username = "";

			if (client.getPreferences().getRememberedUsername() != null)
			{
				username = client.getUsername();
			}

			if (config.username().equals(username))
			{
				return;
			}

			log.debug("Saving username: {}", username);
			config.username(username);
		}
	}

	private void applyUsername()
	{
		if (!config.syncUsername())
		{
			return;
		}

		GameState gameState = client.getGameState();
		if (gameState == GameState.LOGIN_SCREEN)
		{
			String username = config.username();

			if (Strings.isNullOrEmpty(username))
			{
				return;
			}

			// Save it only once
			if (usernameCache == null)
			{
				usernameCache = client.getPreferences().getRememberedUsername();
			}

			client.getPreferences().setRememberedUsername(username);
		}
	}

	@Override
	public boolean isEnabledOnLoginScreen()
	{
		return true;
	}

	@Override
	public void keyTyped(KeyEvent e)
	{
	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		if (!config.pasteEnabled() || (
			client.getGameState() != GameState.LOGIN_SCREEN &&
			client.getGameState() != GameState.LOGIN_SCREEN_AUTHENTICATOR))
		{
			return;
		}

		// enable pasting on macOS with the Command (meta) key
		boolean isModifierDown = OSType.getOSType() == OSType.MacOS ? e.isMetaDown() : e.isControlDown();

		if (e.getKeyCode() == KeyEvent.VK_V && isModifierDown)
		{
			try
			{
				final String data = Toolkit
					.getDefaultToolkit()
					.getSystemClipboard()
					.getData(DataFlavor.stringFlavor)
					.toString()
					.trim();

				switch (client.getLoginIndex())
				{
					// Username/password form
					case 2:
						if (client.getCurrentLoginField() == 0)
						{
							// Truncate data to maximum username length if necessary
							client.setUsername(data.substring(0, Math.min(data.length(), MAX_USERNAME_LENGTH)));
						}

						break;
					// Authenticator form
					case 4:
						// Truncate data to maximum OTP code length if necessary
						client.setOtp(data.substring(0, Math.min(data.length(), MAX_PIN_LENGTH)));
						break;
				}
			}
			catch (UnsupportedFlavorException | IOException ex)
			{
				log.warn("failed to fetch clipboard data", ex);
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e)
	{

	}

	private void overrideLoginScreen()
	{
		client.setShouldRenderLoginScreenFire(config.showLoginFire());

		if (config.loginScreen() == LoginScreenOverride.OFF)
		{
			restoreLoginScreen();
			return;
		}

		SpritePixels pixels;
		if (config.loginScreen() == LoginScreenOverride.RANDOM)
		{
			LoginScreenOverride[] filtered = Arrays.stream(LoginScreenOverride.values())
				.filter(screen -> screen.getFileName() != null)
				.toArray(LoginScreenOverride[]::new);
			LoginScreenOverride randomScreen = filtered[new Random().nextInt(filtered.length)];
			pixels = getFileSpritePixels(randomScreen.getFileName());
		}
		else
		{
			pixels = getFileSpritePixels(config.loginScreen().getFileName());
		}

		if (pixels != null)
		{
			client.setLoginScreen(pixels);
		}
	}

	private void restoreLoginScreen()
	{
		client.setLoginScreen(null);
	}

	private SpritePixels getFileSpritePixels(String file)
	{
		try
		{
			log.debug("Loading: {}", file);
			BufferedImage image = ImageUtil.INSTANCE.loadImageResource(this.getClass(), file);
			return ImageUtil.INSTANCE.getImageSpritePixels(image, client);
		}
		catch (RuntimeException ex)
		{
			log.debug("Unable to load image: ", ex);
		}

		return null;
	}
}