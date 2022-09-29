package net.runelite.http.api.worlds;

import java.util.EnumSet;

public final class World {
	private final int id;
	private final EnumSet<WorldType> types;
	private final String address;
	private final String activity;
	private final int location;
	private final int players;

	public WorldRegion getRegion() {
		return WorldRegion.valueOf(this.location);
	}

	World(int id, EnumSet<WorldType> types, String address, String activity, int location, int players) {
		this.id = id;
		this.types = types;
		this.address = address;
		this.activity = activity;
		this.location = location;
		this.players = players;
	}

	public static World.WorldBuilder builder() {
		return new World.WorldBuilder();
	}

	public int getId() {
		return this.id;
	}

	public EnumSet<WorldType> getTypes() {
		return this.types;
	}

	public String getAddress() {
		return this.address;
	}

	public String getActivity() {
		return this.activity;
	}

	public int getLocation() {
		return this.location;
	}

	public int getPlayers() {
		return this.players;
	}

	public boolean equals(Object o) {
		if (o == this) {
			return true;
		} else if (!(o instanceof World other)) {
			return false;
		} else {
			if (this.getId() != other.getId()) {
				return false;
			} else if (this.getLocation() != other.getLocation()) {
				return false;
			} else if (this.getPlayers() != other.getPlayers()) {
				return false;
			} else {
				label52: {
					Object this$types = this.getTypes();
					Object other$types = other.getTypes();
					if (this$types == null) {
						if (other$types == null) {
							break label52;
						}
					} else if (this$types.equals(other$types)) {
						break label52;
					}

					return false;
				}

				Object this$address = this.getAddress();
				Object other$address = other.getAddress();
				if (this$address == null) {
					if (other$address != null) {
						return false;
					}
				} else if (!this$address.equals(other$address)) {
					return false;
				}

				Object this$activity = this.getActivity();
				Object other$activity = other.getActivity();
				if (this$activity == null) {
					if (other$activity != null) {
						return false;
					}
				} else if (!this$activity.equals(other$activity)) {
					return false;
				}

				return true;
			}
		}
	}

	public int hashCode() {
		boolean PRIME = true;
		int result = 1;
		result = result * 59 + this.getId();
		result = result * 59 + this.getLocation();
		result = result * 59 + this.getPlayers();
		Object $types = this.getTypes();
		result = result * 59 + ($types == null ? 43 : $types.hashCode());
		Object $address = this.getAddress();
		result = result * 59 + ($address == null ? 43 : $address.hashCode());
		Object $activity = this.getActivity();
		result = result * 59 + ($activity == null ? 43 : $activity.hashCode());
		return result;
	}

	public String toString() {
		int var10000 = this.getId();
		return "World(id=" + var10000 + ", types=" + this.getTypes() + ", address=" + this.getAddress() + ", activity=" + this.getActivity() + ", location=" + this.getLocation() + ", players=" + this.getPlayers() + ")";
	}

	public static class WorldBuilder {
		private int id;
		private EnumSet types;
		private String address;
		private String activity;
		private int location;
		private int players;

		WorldBuilder() {
		}

		public World.WorldBuilder id(int id) {
			this.id = id;
			return this;
		}

		public World.WorldBuilder types(EnumSet types) {
			this.types = types;
			return this;
		}

		public World.WorldBuilder address(String address) {
			this.address = address;
			return this;
		}

		public World.WorldBuilder activity(String activity) {
			this.activity = activity;
			return this;
		}

		public World.WorldBuilder location(int location) {
			this.location = location;
			return this;
		}

		public World.WorldBuilder players(int players) {
			this.players = players;
			return this;
		}

		public World build() {
			return new World(this.id, this.types, this.address, this.activity, this.location, this.players);
		}

		public String toString() {
			return "World.WorldBuilder(id=" + this.id + ", types=" + this.types + ", address=" + this.address + ", activity=" + this.activity + ", location=" + this.location + ", players=" + this.players + ")";
		}
	}
}
