package net.runelite.http.api.worlds;

import java.util.Iterator;
import java.util.List;

public class WorldResult {
	private List<World> worlds;

	public List<World> getWorlds() {
		return this.worlds;
	}

	public void setWorlds(List<World> worlds) {
		this.worlds = worlds;
	}

	public World findWorld(int worldNum) {
		Iterator<World> var2 = this.worlds.iterator();

		World world;
		do {
			if (!var2.hasNext()) {
				return null;
			}

			world = (World)var2.next();
		} while(world.getId() != worldNum);

		return world;
	}
}
