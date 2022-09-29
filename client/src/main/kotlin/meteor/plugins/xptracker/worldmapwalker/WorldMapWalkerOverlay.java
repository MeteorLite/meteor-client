package meteor.plugins.xptracker.worldmapwalker;

import dev.hoot.api.entities.Players;
import dev.hoot.api.game.Game;
import dev.hoot.api.movement.pathfinder.Walker;
import meteor.ui.overlay.Overlay;
import meteor.ui.overlay.OverlayLayer;
import meteor.ui.overlay.OverlayPosition;
import meteor.ui.overlay.OverlayPriority;
import net.runelite.api.Perspective;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.awt.*;
import java.awt.geom.GeneralPath;
import java.awt.geom.Path2D;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Singleton
public class WorldMapWalkerOverlay extends Overlay {
    static final Color TRANSPARENT_GREEN = new Color(0, 255, 0, 128);
    static final Color TRANSPARENT_RED = new Color(255, 0, 0, 128);
    WorldMapWalkerPlugin plugin;

    @Inject
    private WorldMapWalkerOverlay(WorldMapWalkerPlugin plugin) {
        this.plugin = plugin;

        setPosition(OverlayPosition.DYNAMIC);
        setLayer(OverlayLayer.ABOVE_SCENE);
        setPriority(OverlayPriority.HIGHEST);
    }


    private void renderPath(Graphics2D graphics, List<WorldPoint> path, int startIndex) {
        ArrayList<LocalPoint> pathToDraw = new ArrayList<>(path.size() - startIndex);
        for (int i = startIndex; i < path.size(); i++) {
            pathToDraw.add(LocalPoint.fromWorld(client, path.get(i)));
        }
        GeneralPath generalPath = new GeneralPath(Path2D.WIND_EVEN_ODD, pathToDraw.size());
        for (LocalPoint currentTile : pathToDraw) {
            if (currentTile != null) {
                var pathPoint = Perspective.localToCanvas(client, currentTile, client.getPlane());
                if (pathPoint == null) {
                    graphics.setColor(TRANSPARENT_GREEN);
                    graphics.draw(generalPath);
                    generalPath.reset();
                } else {
                    if (generalPath.getCurrentPoint() == null) {
                        generalPath.moveTo(pathPoint.getX(), pathPoint.getY());
                    } else {
                        generalPath.lineTo(pathPoint.getX(), pathPoint.getY());
                    }
                }
            } else if (generalPath.getCurrentPoint() != null) {
                graphics.setColor(TRANSPARENT_GREEN);
                graphics.draw(generalPath);
                generalPath.reset();
            }
        }
        if (generalPath.getCurrentPoint() != null) {
            graphics.setColor(TRANSPARENT_GREEN);
            graphics.draw(generalPath);
        }
    }

    @Override
    public Dimension render(Graphics2D graphics) {
        if (plugin.mapPoint == null || !plugin.config.showPaths()) {
            return null;
        }
        List<WorldPoint> path;
        try {
            path = Walker.PATH_CACHE.get(plugin.mapPoint);
        } catch (ExecutionException e) {
            path = Walker.buildPath(plugin.mapPoint, false);
        }
        if (path.isEmpty()) {
            return null;
        }
        var player = Players.getLocal();
        int minDist = path.get(0).distanceTo(player);
        int index = 0;
        for (int i = 1; i < path.size(); i++) {
            var dist = path.get(i).distanceTo(player);
            if (dist == 0) {
                index = i;
                minDist = 0;
                break;
            }
            if (dist < minDist) {
                index = i;
                minDist = dist;
            }
        }
        if (index > 0) {
            index--;
        }
//        for (int i = index; i < path.size() - 1; i++) {
//            path.get(i).outline(Game.getClient(),graphics, new Color(0,255,0,128),null);
//        }
        renderPath(graphics, path, index);
        plugin.mapPoint.outline(Game.getClient(), graphics, new Color(255, 0, 0, 128), "Destination");
        return null;
    }
}
