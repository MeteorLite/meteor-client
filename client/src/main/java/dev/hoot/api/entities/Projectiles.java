package dev.hoot.api.entities;

import dev.hoot.api.commons.Predicates;
import dev.hoot.api.game.Game;
import meteor.Main;
import net.runelite.api.Actor;
import net.runelite.api.Projectile;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class Projectiles
{
	private Projectiles()
	{
	}

	public static List<Projectile> getAll(Predicate<Projectile> filter)
	{
		List<Projectile> out = new ArrayList<>();
		Game.getClient().getProjectiles().forEach(p ->
		{
			if (filter.test(p))
			{
				out.add(p);
			}
		});

		return out;
	}

	public static List<Projectile> getAll(int... ids)
	{
		return getAll(Predicates.ids(ids));
	}

	public static Projectile getNearest(Predicate<Projectile> filter)
	{
		return getAll(filter).stream()
				.min(Comparator.comparingInt(p ->
						WorldPoint.fromLocal(Game.getClient(), (int) p.getX(), (int) p.getY(), Game.getClient().getPlane())
								.distanceTo(Main.client.getLocalPlayer().getWorldLocation()))
				)
				.orElse(null);
	}

	public static Projectile getNearest(int... ids)
	{
		return getNearest(Predicates.ids(ids));
	}

	public static Projectile getNearest(Actor target)
	{
		return getNearest(x -> x.getInteracting() != null && x.getInteracting().equals(target));
	}

	public static Projectile getNearest(WorldPoint startPoint)
	{
		LocalPoint localPoint = LocalPoint.fromWorld(Game.getClient(), startPoint);
		if (localPoint == null)
		{
			return null;
		}

		return getNearest(x -> x.getX1() == localPoint.getX() && x.getY1() == localPoint.getY());
	}
}
