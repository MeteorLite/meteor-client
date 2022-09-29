package net.runelite.client.plugins.oneclickagility;

import meteor.Main;
import net.runelite.api.Client;
import net.runelite.api.Player;
import net.runelite.api.TileObject;

import java.util.List;


public class Course
{
    private Client client = Main.INSTANCE.getClient();

    List<Integer> obstacleIDs;
    List<ObstacleArea> obstacleAreaList;

    Course(List<Integer> obstacleIDs, List<ObstacleArea> obstacleAreaList)
    {
        this.obstacleIDs = obstacleIDs;
        this.obstacleAreaList = obstacleAreaList;
    }

    ObstacleArea getCurrentObstacleArea(Player player)
    {
        if(player == null)
            return null;

        for(ObstacleArea area:obstacleAreaList)
        {
            if(area.containsObject(player))
            {
                return area;
            }
        }
        return null;
    }

    void addObstacle(TileObject obstacle)
    {
        for (ObstacleArea area:obstacleAreaList)
        {
            if (obstacle.getId() == area.getNextObstacleID())
            {
                area.setNextObstacle(obstacle);
                return;
            }
        }
    }

    void removeObstacle(TileObject obstacle)
    {
        for (ObstacleArea area:obstacleAreaList)
        {
            if (obstacle.getId() == area.getNextObstacleID())
            {
                area.setNextObstacle(null);
                return;
            }
        }
    }
}
