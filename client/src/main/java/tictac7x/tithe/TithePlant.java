package tictac7x.tithe;

import tictac7x.Overlay;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import net.runelite.api.TileObject;
import net.runelite.api.GameObject;
import net.runelite.api.coords.WorldPoint;

public class TithePlant extends Overlay {
    // Tithe empty patch.
    protected static final int TITHE_EMPTY_PATCH = 27383;

    // Golovanova plants.
    protected static final int GOLOVANOVA_SEEDLING = 27384;
    protected static final int GOLOVANOVA_SEEDLING_WATERED = 27385;
    protected static final int GOLOVANOVA_SEEDLING_BLIGHTED = 27386;
    protected static final int GOLOVANOVA_PLANT_1 = 27387;
    protected static final int GOLOVANOVA_PLANT_1_WATERED = 27388;
    protected static final int GOLOVANOVA_PLANT_1_BLIGHTED = 27389;
    protected static final int GOLOVANOVA_PLANT_2 = 27390;
    protected static final int GOLOVANOVA_PLANT_2_WATERED = 27391;
    protected static final int GOLOVANOVA_PLANT_2_BLIGHTED = 27392;
    protected static final int GOLOVANOVA_GROWN = 27393;
    protected static final int GOLOVANOVA_GROWN_BLIGHTED = 27394;

    // Bologano plants.
    protected static final int BOLOGANO_SEEDLING = 27395;
    protected static final int BOLOGANO_SEEDLING_WATERED = 27396;
    protected static final int BOLOGANO_SEEDLING_BLIGHTED = 27397;
    protected static final int BOLOGANO_PLANT_1 = 27398;
    protected static final int BOLOGANO_PLANT_1_WATERED = 27399;
    protected static final int BOLOGANO_PLANT_1_BLIGHTED = 27400;
    protected static final int BOLOGANO_PLANT_2 = 27401;
    protected static final int BOLOGANO_PLANT_2_WATERED = 27402;
    protected static final int BOLOGANO_PLANT_2_BLIGHTED = 27403;
    protected static final int BOLOGANO_GROWN = 27404;
    protected static final int BOLOGANO_GROWN_BLIGHTED = 27405;

    // Logavano plants.
    protected static final int LOGAVANO_SEEDLING = 27406;
    protected static final int LOGAVANO_SEEDLING_WATERED = 27407;
    protected static final int LOGAVANO_SEEDLING_BLIGHTED = 27408;
    protected static final int LOGAVANO_PLANT_1 = 27409;
    protected static final int LOGAVANO_PLANT_1_WATERED = 27410;
    protected static final int LOGAVANO_PLANT_1_BLIGHTED = 27411;
    protected static final int LOGAVANO_PLANT_2 = 27412;
    protected static final int LOGAVANO_PLANT_2_WATERED = 27413;
    protected static final int LOGAVANO_PLANT_2_BLIGHTED = 27414;
    protected static final int LOGAVANO_GROWN = 27415;
    protected static final int LOGAVANO_GROWN_BLIGHTED = 27416;

    // One plant cycle duration in game ticks.
    private final double DURATION_CYCLE_GAME_TICKS = 100;

    public enum State {
        EMPTY,
        SEEDLING_DRY,
        SEEDLING_WATERED,
        PLANT_1_DRY,
        PLANT_1_WATERED,
        PLANT_2_DRY,
        PLANT_2_WATERED,
        GROWN,
        BLIGHTED
    }

    private final TitheConfig config;
    private GameObject cycle_patch;
    public State cycle_state;
    private int cycle_ticks;

    public TithePlant(final GameObject seedling, final TitheConfig config) {
        this.config = config;
        this.cycle_patch = seedling;

        // First state can't be anything else than dry seedling.
        this.cycle_state = State.SEEDLING_DRY;

        // -1, because the first cycle would be 99 ticks otherwise.
        this.cycle_ticks = -1;
    }

    public void setCyclePatch(final GameObject cycle_patch) {
        if (isPatch(cycle_patch)) this.cycle_patch = cycle_patch;

        if (isWatered(cycle_patch)) {
            if (cycle_state == State.SEEDLING_DRY) {
                cycle_state = State.SEEDLING_WATERED;
            } else if (cycle_state == State.PLANT_1_DRY) {
                cycle_state = State.PLANT_1_WATERED;
            } else if (cycle_state == State.PLANT_2_DRY) {
                cycle_state = State.PLANT_2_WATERED;
            }
        }
    }

    public void onGameTick() {
        cycle_ticks++;
    }

    @Override
    public Dimension render(final Graphics2D graphics) {
        updateState();

        final Color color = getCycleColor();
        if (color != null) renderPie(graphics, cycle_patch, getCycleColor(), (float) getCycleProgress());
        return null;
    }

    private void updateState() {
        if (cycle_state != State.EMPTY && cycle_ticks == DURATION_CYCLE_GAME_TICKS) {
            if (
                cycle_state == State.SEEDLING_DRY
                || cycle_state == State.PLANT_1_DRY
                || cycle_state == State.PLANT_2_DRY
                || cycle_state == State.GROWN
            ) {
                cycle_state = State.BLIGHTED;
            } else if (cycle_state == State.SEEDLING_WATERED) {
                cycle_state = State.PLANT_1_DRY;
            } else if (cycle_state == State.PLANT_1_WATERED) {
                cycle_state = State.PLANT_2_DRY;
            } else if (cycle_state == State.PLANT_2_WATERED) {
                cycle_state = State.GROWN;
            } else if (cycle_state == State.BLIGHTED) {
                cycle_state = State.EMPTY;
            }

            cycle_ticks = 0;
        }
    }

    private Color getCycleColor() {
        if (cycle_state == State.SEEDLING_DRY || cycle_state == State.PLANT_1_DRY || cycle_state == State.PLANT_2_DRY) {
            return config.getPlantsDryColor();
        } else if (cycle_state == State.GROWN) {
            return config.getPlantsGrownColor();
        } else if (cycle_state == State.SEEDLING_WATERED || cycle_state == State.PLANT_1_WATERED || cycle_state == State.PLANT_2_WATERED) {
            return config.getPlantsWateredColor();
        } else if (cycle_state == State.BLIGHTED) {
            return config.getPlantsBlightedColor();
        }

        return null;
    }

    private double getCycleProgress() {
        return -1 + (cycle_ticks / DURATION_CYCLE_GAME_TICKS);
    }

    public static boolean isSeedling(final TileObject patch) {
        final int id = patch.getId();
        return id == GOLOVANOVA_SEEDLING || id == BOLOGANO_SEEDLING || id == LOGAVANO_SEEDLING;
    }

    public static boolean isDry(final TileObject patch) {
        final int id = patch.getId();
        return (
            id == GOLOVANOVA_SEEDLING
            || id == GOLOVANOVA_PLANT_1
            || id == GOLOVANOVA_PLANT_2
            || id == BOLOGANO_SEEDLING
            || id == BOLOGANO_PLANT_1
            || id == BOLOGANO_PLANT_2
            || id == LOGAVANO_SEEDLING
            || id == LOGAVANO_PLANT_1
            || id == LOGAVANO_PLANT_2
        );
    }

    public static boolean isWatered(final TileObject patch) {
        final int id = patch.getId();
        return (
            id == GOLOVANOVA_SEEDLING_WATERED
            || id == GOLOVANOVA_PLANT_1_WATERED
            || id == GOLOVANOVA_PLANT_2_WATERED
            || id == BOLOGANO_SEEDLING_WATERED
            || id == BOLOGANO_PLANT_1_WATERED
            || id == BOLOGANO_PLANT_2_WATERED
            || id == LOGAVANO_SEEDLING_WATERED
            || id == LOGAVANO_PLANT_1_WATERED
            || id == LOGAVANO_PLANT_2_WATERED
        );
    }

    public static boolean isGrown(final TileObject patch) {
        final int id = patch.getId();
        return (
            id == GOLOVANOVA_GROWN
            || id == BOLOGANO_GROWN
            || id == LOGAVANO_GROWN
        );
    }

    public static boolean isBlighted(final TileObject patch) {
        final int id = patch.getId();
        return (
            id == GOLOVANOVA_SEEDLING_BLIGHTED
            || id == GOLOVANOVA_PLANT_1_BLIGHTED
            || id == GOLOVANOVA_PLANT_2_BLIGHTED
            || id == GOLOVANOVA_GROWN_BLIGHTED
            || id == BOLOGANO_SEEDLING_BLIGHTED
            || id == BOLOGANO_PLANT_1_BLIGHTED
            || id == BOLOGANO_PLANT_2_BLIGHTED
            || id == BOLOGANO_GROWN_BLIGHTED
            || id == LOGAVANO_SEEDLING_BLIGHTED
            || id == LOGAVANO_PLANT_1_BLIGHTED
            || id == LOGAVANO_PLANT_2_BLIGHTED
            || id == LOGAVANO_GROWN_BLIGHTED
        );
    }

    public static boolean isEmptyPatch(final TileObject patch) {
        return patch.getId() == TITHE_EMPTY_PATCH;
    }

    public static boolean isPatch(final TileObject patch) {
        return isDry(patch) || isWatered(patch) || isGrown(patch) || isBlighted(patch) || isEmptyPatch(patch);
    }

    public static boolean isPlayerNear(final GameObject plant, final WorldPoint location_player) {
        return (
            plant != null
            && location_player != null
            && location_player.getX() + 2 >= plant.getWorldLocation().getX()
            && location_player.getX() - 2 <= plant.getWorldLocation().getX()
            && location_player.getY() + 2 >= plant.getWorldLocation().getY()
            && location_player.getY() - 2 <= plant.getWorldLocation().getY()
        );
    }
}
