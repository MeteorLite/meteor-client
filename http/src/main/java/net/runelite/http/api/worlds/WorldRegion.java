package net.runelite.http.api.worlds;

public enum WorldRegion {
	UNITED_STATES_OF_AMERICA("US", "USA"),
	UNITED_KINGDOM("GB", "GBR"),
	AUSTRALIA("AU", "AUS"),
	GERMANY("DE", "DEU");

	private final String alpha2;
	private final String alpha3;

	public static WorldRegion valueOf(int locationId) {
		switch(locationId) {
		case 0:
			return UNITED_STATES_OF_AMERICA;
		case 1:
			return UNITED_KINGDOM;
		case 2:
		case 4:
		case 5:
		case 6:
		default:
			return null;
		case 3:
			return AUSTRALIA;
		case 7:
			return GERMANY;
		}
	}

	private WorldRegion(String alpha2, String alpha3) {
		this.alpha2 = alpha2;
		this.alpha3 = alpha3;
	}

	public String getAlpha2() {
		return this.alpha2;
	}

	public String getAlpha3() {
		return this.alpha3;
	}
}
