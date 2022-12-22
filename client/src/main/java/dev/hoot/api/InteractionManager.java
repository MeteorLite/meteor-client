package dev.hoot.api;

import dev.hoot.api.commons.Rand;
import dev.hoot.api.commons.Time;
import dev.hoot.api.events.AutomatedMenu;
import dev.hoot.api.game.GameThread;
import dev.hoot.api.movement.Movement;
import dev.hoot.api.widgets.DialogOption;
import dev.hoot.api.widgets.Widgets;
import eventbus.events.DialogProcessed;
import eventbus.events.MenuOptionClicked;
import meteor.Logger;
import meteor.Main;
import meteor.api.packets.ClientPackets;
import meteor.plugins.EventSubscriber;
import net.runelite.api.Client;
import net.runelite.api.Constants;
import net.runelite.api.MenuAction;
import net.runelite.api.packets.PacketBufferNode;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;

import java.awt.*;

public class InteractionManager extends EventSubscriber
{
	public InteractionManager() {
		subscribe();
	}
	private static final int MINIMAP_WIDTH = 250;
	private static final int MINIMAP_HEIGHT = 180;

	private Logger log = new Logger("InteractionManager");

	private InteractionConfig config = new InteractionConfig() {};

	private Client client = Main.INSTANCE.getClient();

	@Override
	public void onInvokeMenuAction(AutomatedMenu e)
	{
		String debug = "O=" + e.getOption()
				+ " | T=" + e.getTarget()
				+ " | ID=" + e.getIdentifier()
				+ " | OP=" + e.getOpcode()
				+ " | P0=" + e.getParam0()
				+ " | P1=" + e.getParam1()
				+ " | X=" + e.getClickX()
				+ " | Y=" + e.getClickY()
				+ " | TAG=" + e.getEntityTag();

		log.debug("[Automated] {}", debug);
		Point clickPoint = getClickPoint(e);
		MouseHandler mouseHandler = client.getMouseHandler();

		try
		{
			if (config.mouseBehavior() != MouseBehavior.DISABLED)
			{
				mouseHandler.sendMovement(clickPoint.x, clickPoint.y);
				ClientPackets.INSTANCE.queueClickPacket(clickPoint.x, clickPoint.y);
			}

			GameThread.invoke(() ->
			{
				try
				{
					PacketBufferNode packetBufferNode = ClientPackets.INSTANCE.createClientPacket(e);
					if (packetBufferNode != null)
						packetBufferNode.send();
					else
						System.out.println("No valid packet to write");
				}
				catch (InteractionException ex)
				{
					log.debug("{}, falling back to invoke", ex.getMessage());
					processAction(e, clickPoint.x, clickPoint.y);
				}
			});
		}
		catch (InteractionException ex)
		{
			log.error("Interaction failed: {}", ex.getMessage());
			client.setPendingAutomation(null);
		}
		finally
		{
			long duration = System.currentTimeMillis() - e.getTimestamp();
			Time.sleep(Constants.CLIENT_TICK_LENGTH + duration);
		}
	}

	@Override
	public void onMenuOptionClicked(MenuOptionClicked e)
	{
		if (e.getAutomated() && e.getMenuAction() == MenuAction.WALK
				&& config.interactMethod() == InteractMethod.MOUSE_EVENTS)
		{
			Movement.setDestination(e.getParam0(), e.getParam1());
			e.getMenuEntry().setType(MenuAction.CANCEL);
			e.getMenuEntry().setParam0(0);
			e.getMenuEntry().setParam1(0);
		}

		String action = "O=" + e.getMenuOption()
				+ " | T=" + e.getMenuTarget()
				+ " | ID=" + e.getId()
				+ " | OP=" + e.getMenuAction().getId()
				+ " | P0=" + e.getParam0()
				+ " | P1=" + e.getParam1()
				+ " | X=" + e.getCanvasX()
				+ " | Y=" + e.getCanvasY();
		log.debug("[Menu Action] {}", action);
	}

	@Override
	public void onDialogProcessed(DialogProcessed e)
	{
		DialogOption dialogOption = DialogOption.of(e.getOption().getWidgetUid(), e.getOption().getMenuIndex());
		if (dialogOption != null)
		{
			log.debug("Dialog processed {}", dialogOption);
		}
		else
		{
			log.debug("Unknown or unmapped dialog {}", e);
		}
	}

	private void processAction(AutomatedMenu entry, int x, int y)
	{
		GameThread.invoke(() -> client.invokeMenuAction(entry.getOption(), entry.getTarget(), entry.getIdentifier(),
				entry.getOpcode().getId(), entry.getParam0(), entry.getParam1(), x, y));
	}

	private Point getClickPoint(AutomatedMenu e)
	{
		if (config.mouseBehavior() == MouseBehavior.OFF_SCREEN)
		{
			return new Point(0, 0);
		}

		if (config.mouseBehavior() == MouseBehavior.MOUSE_POS)
		{
			return new Point(client.getMouseHandler().getCurrentX(), client.getMouseHandler().getCurrentY());
		}

		if (e.getClickX() != -1 && e.getClickY() != -1 && config.mouseBehavior() == MouseBehavior.CLICKBOXES)
		{
			Point clickPoint = new Point(e.getClickX(), e.getClickY());
			if (!clickInsideMinimap(clickPoint))
			{
				return clickPoint;
			}
		}

		Rectangle bounds = client.getCanvas().getBounds();
		Point randomPoint = new Point(Rand.nextInt(0, bounds.width), Rand.nextInt(0, bounds.height));
		if (clickInsideMinimap(randomPoint))
		{
			return getClickPoint(e);
		}

		return randomPoint;
	}

	private boolean clickInsideMinimap(Point point)
	{
		Rectangle minimap = getMinimap();
		if (minimap.contains(point))
		{
			log.debug("Click {} was inside minimap", point);
			return true;
		}

		return false;
	}

	private Rectangle getMinimap()
	{
		Widget minimap = Widgets.get(WidgetInfo.FIXED_VIEWPORT_MINIMAP_DRAW_AREA);
		if (Widgets.isVisible(minimap))
		{
			return minimap.getBounds();
		}

		Widget minimap1 = Widgets.get(WidgetInfo.RESIZABLE_MINIMAP_DRAW_AREA);
		if (Widgets.isVisible(minimap1))
		{
			return minimap1.getBounds();
		}

		Widget minimap2 = Widgets.get(WidgetInfo.RESIZABLE_MINIMAP_STONES_DRAW_AREA);
		if (Widgets.isVisible(minimap2))
		{
			return minimap2.getBounds();
		}

		Rectangle bounds = client.getCanvas().getBounds();
		return new Rectangle(bounds.width - MINIMAP_WIDTH, 0, MINIMAP_WIDTH, MINIMAP_HEIGHT);
	}

	private boolean interactReady()
	{
		return client.getPendingAutomation() == null;
	}
}
