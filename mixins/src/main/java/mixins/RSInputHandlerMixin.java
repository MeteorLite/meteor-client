package mixins;

import net.runelite.api.mixins.*;
import net.runelite.rs.api.RSClient;
import net.runelite.rs.api.RSGameShell;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

@Mixin(RSGameShell.class)
public abstract class RSInputHandlerMixin implements RSGameShell
{
	@Shadow("mudClient")
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
	@Copy("keyPressed")
	@Replace("keyPressed")
	public final synchronized void keyPressed(KeyEvent keyEvent)
	{
		client.getCallbacks().keyPressed(keyEvent);
		if (!keyEvent.isConsumed())
		{
			keyPressed(keyEvent);
		}
	}

	@Override
	@Copy("keyReleased")
	@Replace("keyReleased")
	public final synchronized void keyReleased(KeyEvent keyEvent)
	{
		client.getCallbacks().keyReleased(keyEvent);
		if (!keyEvent.isConsumed())
		{
			keyReleased(keyEvent);
		}
	}

	@Override
	@Copy("keyTyped")
	@Replace("keyTyped")
	public final void keyTyped(KeyEvent keyEvent)
	{
		client.getCallbacks().keyTyped(keyEvent);
		if (!keyEvent.isConsumed())
		{
			keyTyped(keyEvent);
		}
	}
}
