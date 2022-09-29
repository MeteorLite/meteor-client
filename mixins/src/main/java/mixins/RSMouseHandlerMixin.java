package mixins;

import java.awt.Canvas;
import java.awt.event.MouseEvent;
import net.runelite.api.mixins.Copy;
import net.runelite.api.mixins.Inject;
import net.runelite.api.mixins.Mixin;
import net.runelite.api.mixins.Replace;
import net.runelite.api.mixins.Shadow;
import net.runelite.rs.api.RSClient;
import net.runelite.rs.api.RSMouseHandler;

@Mixin(RSMouseHandler.class)
public abstract class RSMouseHandlerMixin implements RSMouseHandler
{
	@Shadow("client")
	private static RSClient client;

	@Inject
	private int isInEvent;

	@Override
	@Copy("mousePressed")
	@Replace("mousePressed")
	public synchronized void mousePressed(MouseEvent mouseEvent)
	{
		if (isInEvent == 0)
		{
			mouseEvent = client.getCallbacks().mousePressed(mouseEvent);
		}
		if (!mouseEvent.isConsumed())
		{
			isInEvent++;
			try
			{
				mousePressed(mouseEvent);
			}
			finally
			{
				isInEvent--;
			}
		}
	}

	@Override
	@Copy("mouseReleased")
	@Replace("mouseReleased")
	public synchronized void mouseReleased(MouseEvent mouseEvent)
	{
		if (isInEvent == 0)
		{
			mouseEvent = client.getCallbacks().mouseReleased(mouseEvent);
		}
		if (!mouseEvent.isConsumed())
		{
			isInEvent++;
			try
			{
				mouseReleased(mouseEvent);
			}
			finally
			{
				isInEvent--;
			}
		}
	}

	@Override
	@Copy("mouseClicked")
	@Replace("mouseClicked")
	public void mouseClicked(MouseEvent event)
	{
		event = client.getCallbacks().mouseClicked(event);
		if (!event.isConsumed())
		{
			mouseClicked(event);
		}
	}

	@Override
	@Copy("mouseEntered")
	@Replace("mouseEntered")
	public synchronized void mouseEntered(MouseEvent mouseEvent)
	{
		if (isInEvent == 0)
		{
			mouseEvent = client.getCallbacks().mouseEntered(mouseEvent);
		}
		if (!mouseEvent.isConsumed())
		{
			isInEvent++;
			try
			{
				mouseEntered(mouseEvent);
			}
			finally
			{
				isInEvent--;
			}
		}
	}


	@Override
	@Copy("mouseExited")
	@Replace("mouseExited")
	public synchronized void mouseExited(MouseEvent mouseEvent)
	{
		if (isInEvent == 0)
		{
			mouseEvent = client.getCallbacks().mouseExited(mouseEvent);
		}
		if (!mouseEvent.isConsumed())
		{
			isInEvent++;
			try
			{
				mouseExited(mouseEvent);
			}
			finally
			{
				isInEvent--;
			}
		}
	}

	@Override
	@Copy("mouseDragged")
	@Replace("mouseDragged")
	public synchronized void mouseDragged(MouseEvent mouseEvent)
	{
		if (isInEvent == 0)
		{
			mouseEvent = client.getCallbacks().mouseDragged(mouseEvent);
		}
		if (!mouseEvent.isConsumed())
		{
			isInEvent++;
			try
			{
				mouseDragged(mouseEvent);
			}
			finally
			{
				isInEvent--;
			}
		}
	}

	@Override
	@Copy("mouseMoved")
	@Replace("mouseMoved")
	public synchronized void mouseMoved(MouseEvent mouseEvent)
	{
		if (isInEvent == 0)
		{
			mouseEvent = client.getCallbacks().mouseMoved(mouseEvent);
		}
		if (!mouseEvent.isConsumed())
		{
			isInEvent++;
			try
			{
				mouseMoved(mouseEvent);
			}
			finally
			{
				isInEvent--;
			}
		}
	}


	@Override
	@Inject
	public synchronized void sendClick(int x, int y, int button)
	{
		long time = System.currentTimeMillis();
		Canvas canvas = client.getCanvas();
		canvas.dispatchEvent(new MouseEvent(canvas, MouseEvent.MOUSE_PRESSED, time, 0, x, y, 1, false, button));
		canvas.dispatchEvent(new MouseEvent(canvas, MouseEvent.MOUSE_RELEASED, time, 0, x, y, 1, false, button));
	}

	@Override
	@Inject
	public synchronized void sendMovement(int x, int y)
	{
		long time = System.currentTimeMillis();
		Canvas canvas = client.getCanvas();
//		if (!canvas.contains(getCurrentX(), getCurrentY()) && canvas.contains(x, y))
//		{
//			canvas.dispatchEvent(new MouseEvent(canvas, MouseEvent.MOUSE_ENTERED, client.getCurrentTime(), 0, x, y, 0, false));
//		}

		canvas.dispatchEvent(new MouseEvent(canvas, MouseEvent.MOUSE_MOVED, time, 0, x, y, 0, false));

//		int currX = getCurrentX();
//		int currY = getCurrentY();
//		if (!canvas.contains(currX, currY))
//		{
//			canvas.dispatchEvent(new MouseEvent(canvas, MouseEvent.MOUSE_EXITED, client.getCurrentTime(), 0, currX, currY, 0, false));
//		}
	}
}
