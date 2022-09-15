package dev.hoot.api.game;

import dev.hoot.api.movement.pathfinder.GlobalCollisionMap;
import dev.hoot.api.movement.pathfinder.RegionManager;
import dev.hoot.api.movement.pathfinder.Walker;
import dev.hoot.api.widgets.Tab;
import dev.hoot.api.widgets.Tabs;
import dev.hoot.api.widgets.Widgets;
import meteor.Logger;
import meteor.Main;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.packets.ClientPacket;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetID;
import net.runelite.api.widgets.WidgetInfo;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.zip.GZIPInputStream;

public class Game
{
	private static final int MEMBER_DAYS_VARP = 1780;
	private static final int CUTSCENE_VARBIT = 542;
	private static final String LOGOUT_ACTION = "Logout";
	private static ClientPacket clientPacket = null;
	private static GlobalCollisionMap globalCollisionMap = null;

	public static Client getClient()
	{
		return Main.client;
	}

	public static ClientPacket getClientPacket()
	{
		if (clientPacket == null)
			clientPacket = Main.INSTANCE.getClient().createClientPacket(-1, -1);
		return clientPacket;
	}

	public static GlobalCollisionMap getGlobalCollisionMap()
	{
		if (globalCollisionMap == null) {
			try {
				return new GlobalCollisionMap(
						new GZIPInputStream(
								new ByteArrayInputStream(
										ClassLoader.getSystemClassLoader().getResourceAsStream("regions").readAllBytes()
								)
						).readAllBytes()
				);
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return globalCollisionMap;
	}

	public static boolean isLoggedIn()
	{
		return getState() == GameState.LOGGED_IN || getState() == GameState.LOADING;
	}

	public static boolean isOnLoginScreen()
	{
		return getState() == GameState.LOGIN_SCREEN
				|| getState() == GameState.LOGIN_SCREEN_AUTHENTICATOR;
	}

	public static GameState getState()
	{
		return getClient().getGameState();
	}

	public static int getWildyLevel()
	{
		Widget wildyLevelWidget = Widgets.get(WidgetInfo.PVP_WILDERNESS_LEVEL);
		if (!Widgets.isVisible(wildyLevelWidget))
		{
			return 0;
		}

		// Dmm
		if (wildyLevelWidget.getText().contains("Guarded")
				|| wildyLevelWidget.getText().contains("Protection"))
		{
			return 0;
		}

		if (wildyLevelWidget.getText().contains("Deadman"))
		{
			return Integer.MAX_VALUE;
		}
		String widgetText = wildyLevelWidget.getText();
		if (widgetText.indexOf('<') == -1)
			return 0;
		return Integer.parseInt(widgetText.substring(0, widgetText.indexOf('<')).replace("Level: ", ""));
	}

	public static int getMembershipDays()
	{
		return Vars.getVarp(MEMBER_DAYS_VARP);
	}

	public static boolean isInCutscene()
	{
		return Vars.getBit(CUTSCENE_VARBIT) > 0;
	}

	public static void logout()
	{
		Widget logOutHopper = Widgets.get(WidgetID.WORLD_SWITCHER_GROUP_ID, x -> x.hasAction(LOGOUT_ACTION));
		if (logOutHopper != null)
		{
			logOutHopper.interact(LOGOUT_ACTION);
			return;
		}

		Widget logOut = Widgets.get(WidgetID.LOGOUT_PANEL_ID, x -> x.hasAction(LOGOUT_ACTION));
		if (logOut != null)
		{
			logOut.interact(LOGOUT_ACTION);
			return;
		}

		if (!Tabs.isOpen(Tab.LOG_OUT))
		{
			Tabs.open(Tab.LOG_OUT);
		}
	}
}
