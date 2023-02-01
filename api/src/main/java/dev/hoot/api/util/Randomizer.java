package dev.hoot.api.util;

import java.awt.*;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Randomizer
{
    public static Point getRandomPointIn(Rectangle rect)
    {
        int x = new Random().nextInt(rect.width+1);
        int y = new Random().nextInt(rect.height+1);
        return new Point(rect.x + x, rect.y + y);
    }
}
