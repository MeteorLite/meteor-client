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

    public static Point getHumanizedRandomPointIn(Rectangle rect)
    {
        int xDeviation = (int) Math.log(rect.getWidth() * Math.PI);
        int yDeviation = (int) Math.log(rect.getHeight() * Math.PI);
        return getHumanizedRandomPointIn(rect, xDeviation, yDeviation);
    }

    public static Point getHumanizedRandomPointIn(Rectangle rect, int xDeviation, int yDeviation)
    {
        double centerX = rect.getCenterX();
        double centerY = rect.getCenterY();

        double randX = Math.max(
                Math.min(centerX + xDeviation * ThreadLocalRandom.current().nextGaussian(), rect.getMaxX()),
                rect.getMinX());

        double randY = Math.max(
                Math.min(centerY + yDeviation * ThreadLocalRandom.current().nextGaussian(), rect.getMaxY()),
                rect.getMinY());

        return new Point((int) randX, (int) randY);
    }
}
