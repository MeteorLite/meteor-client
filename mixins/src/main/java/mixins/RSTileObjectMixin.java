package mixins;

import dev.hoot.api.events.AutomatedMenu;
import dev.hoot.api.util.Randomizer;
import java.awt.Rectangle;
import java.awt.Shape;
import net.runelite.api.GameObject;
import net.runelite.api.MenuAction;
import net.runelite.api.Perspective;
import net.runelite.api.Point;
import net.runelite.api.TileObject;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import java.awt.Graphics2D;
import java.awt.Polygon;
import net.runelite.api.mixins.Inject;
import net.runelite.api.mixins.Mixin;
import net.runelite.api.mixins.Mixins;
import net.runelite.api.mixins.Shadow;
import net.runelite.rs.api.RSBoundaryObject;
import net.runelite.rs.api.RSClient;
import net.runelite.rs.api.RSFloorDecoration;
import net.runelite.rs.api.RSGameObject;
import net.runelite.rs.api.RSItemLayer;
import net.runelite.rs.api.RSWallDecoration;

@Mixins({
	@Mixin(RSWallDecoration.class),
	@Mixin(RSGameObject.class),
	@Mixin(RSFloorDecoration.class),
	@Mixin(RSItemLayer.class),
	@Mixin(RSBoundaryObject.class)
})
public abstract class RSTileObjectMixin implements TileObject
{
	@Shadow("client")
	private static RSClient client;

	@Override
	@Inject
	public int getId()
	{
		long hash = getHash();
		return (int) (hash >>> 17 & 4294967295L);
	}
	
	@Override
	@Inject
	public String getName()
	{
		return client.getObjectDefinition(getId()).getName();
	}

	@Override
	@Inject
	public String[] getRawActions()
	{
		return client.getObjectDefinition(getId()).getActions();
	}

	@Override
	@Inject
	public WorldPoint getWorldLocation()
	{
		if (this instanceof RSGameObject)
		{
			RSGameObject gameObject = (RSGameObject) this;
			int startX = gameObject.getStartX();
			int startY = gameObject.getStartY();
			int diffX = gameObject.getEndX() - startX;
			int diffY = gameObject.getEndY() - startY;
			return WorldPoint.fromScene(client, startX + diffX / 2, startY + diffY / 2, getPlane());
		}
		else
		{
			return WorldPoint.fromLocal(client, getX(), getY(), getPlane());
		}
	}

	@Override
	@Inject
	public LocalPoint getLocalLocation()
	{
		return new LocalPoint(getX(), getY());
	}

	@Override
	@Inject
	public Point getCanvasLocation()
	{
		return getCanvasLocation(0);
	}

	@Override
	@Inject
	public Point getCanvasLocation(int zOffset)
	{
		return Perspective.localToCanvas(client, getLocalLocation(), getPlane(), zOffset);
	}

	@Override
	@Inject
	public Polygon getCanvasTilePoly()
	{
		int sizeX = 1;
		int sizeY = 1;

		if (this instanceof RSGameObject)
		{
			sizeX = ((RSGameObject) this).sizeX();
			sizeY = ((RSGameObject) this).sizeY();
		}

		return Perspective.getCanvasTileAreaPoly(client, getLocalLocation(), sizeX, sizeY, getPlane(), 0);
	}

	@Override
	@Inject
	public Point getCanvasTextLocation(Graphics2D graphics, String text, int zOffset)
	{
		return Perspective.getCanvasTextLocation(client, graphics, getLocalLocation(), text, zOffset);
	}

	@Override
	@Inject
	public Point getMinimapLocation()
	{
		return Perspective.localToMinimap(client, getLocalLocation());
	}


	@Override
	@Inject
	public Point menuPoint()
	{
		if (this instanceof GameObject)
		{
			GameObject temp = (GameObject) this;
			return temp.getSceneMinLocation();
		}

		return new Point(getLocalLocation().getSceneX(), getLocalLocation().getSceneY());
	}

	@Override
	@Inject
	public int getActionOpcode(int action)
	{
		switch (action)
		{
			case 0:
				return MenuAction.GAME_OBJECT_FIRST_OPTION.getId();
			case 1:
				return MenuAction.GAME_OBJECT_SECOND_OPTION.getId();
			case 2:
				return MenuAction.GAME_OBJECT_THIRD_OPTION.getId();
			case 3:
				return MenuAction.GAME_OBJECT_FOURTH_OPTION.getId();
			case 4:
				return MenuAction.GAME_OBJECT_FIFTH_OPTION.getId();
			default:
				throw new IllegalArgumentException("action = " + action);
		}
	}

	@Override
	@Inject
	public void interact(int action)
	{
		interact(getId(), getActionOpcode(action));
	}

	@Inject
	@Override
	public void interact(int identifier, int opcode, int param0, int param1)
	{
		client.interact(getMenu(identifier, opcode, param0, param1));
	}

	@Inject
	public java.awt.Point getClickPoint()
	{
		java.awt.Point point = Randomizer.getRandomPointIn(getBounds());
		return new java.awt.Point(point.x, point.y);
	}

	@Inject
	private Rectangle getBounds()
	{
		Shape shape = getClickbox();
		if (shape != null)
		{
			return shape.getBounds();
		}
		else
		{
			Point screenCoords = Perspective.localToCanvas(client, getLocalLocation(), client.getPlane());
			if (screenCoords != null)
			{
				return new Rectangle(screenCoords.getX(), screenCoords.getY(), 0, 0);
			}
			return new Rectangle(-1, -1, 0, 0);
		}
	}

	@Inject
	@Override
	public void interact(int index, int opcode)
	{
		interact(getId(), opcode, menuPoint().getX(), menuPoint().getY());
	}

	@Inject
	@Override
	public long getTag()
	{
		return getHash();
	}

	@Inject
	public AutomatedMenu getMenu(int actionIndex)
	{
		return getMenu(getId(), getActionOpcode(actionIndex));
	}

	@Inject
	public AutomatedMenu getMenu(int actionIndex, int opcode)
	{
		return getMenu(getId(), opcode, menuPoint().getX(), menuPoint().getY());
	}
}
