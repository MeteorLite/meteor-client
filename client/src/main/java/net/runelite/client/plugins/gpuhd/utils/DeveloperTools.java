package net.runelite.client.plugins.gpuhd.utils;

import lombok.extern.slf4j.Slf4j;
import meteor.config.ConfigManager;
import meteor.config.legacy.Keybind;
import meteor.input.KeyListener;
import meteor.input.KeyManager;
import meteor.ui.overlay.OverlayManager;
import net.runelite.client.plugins.gpuhd.HdPluginConfig;
import net.runelite.client.plugins.gpuhd.overlays.TileInfoOverlay;

import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

@Slf4j
public class DeveloperTools implements KeyListener
{

	// This could be part of the config if we had developer mode config sections
	private static final Keybind KEY_TOGGLE_TILE_INFO = new Keybind(KeyEvent.VK_F3, InputEvent.CTRL_DOWN_MASK);


	private KeyManager keyManager = KeyManager.INSTANCE;

	private OverlayManager overlayManager = OverlayManager.INSTANCE;

	private TileInfoOverlay tileInfoOverlay = new TileInfoOverlay(ConfigManager.INSTANCE.getConfig(HdPluginConfig.class));

	private boolean tileInfoOverlayEnabled = false;

	public void activate() {
		keyManager.registerKeyListener(this, DeveloperTools.class);
		if (tileInfoOverlayEnabled)
		{
			overlayManager.add(tileInfoOverlay);
		}
	}

	public void deactivate() {
		keyManager.unregisterKeyListener(this);
		overlayManager.remove(tileInfoOverlay);
	}

	@Override
	public void keyPressed(KeyEvent event)
	{
		if (KEY_TOGGLE_TILE_INFO.matches(event))
		{
			event.consume();
			tileInfoOverlayEnabled = !tileInfoOverlayEnabled;
			if (tileInfoOverlayEnabled)
			{
				overlayManager.add(tileInfoOverlay);
			}
			else
			{
				overlayManager.remove(tileInfoOverlay);
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent event)
	{

	}

	@Override
	public void keyTyped(KeyEvent event)
	{

	}
}
