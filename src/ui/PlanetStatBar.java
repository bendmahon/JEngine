package ui;

import objects.Planet;

import java.awt.*;

/**
 * Created by bendm_000 on 1/25/2017.
 */
public class PlanetStatBar extends StatBar{
    public Planet planet;
    private Color startColor;
    private Color endColor;
    public PlanetStatBar(Point screenPosition, Point dimensions, Planet planet, Color startColor, Color endColor){
        super(screenPosition, dimensions);
        this.planet = planet;
        this.startColor = startColor;
        this.endColor = endColor;
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics2D g) {
        super.render(g);
    }

    public Color barColor(double fullness) {
        int rdiff = endColor.getRed() - startColor.getRed();
        int gdiff = endColor.getGreen() - startColor.getGreen();
        int bdiff = endColor.getBlue() - startColor.getBlue();
        return new Color((int) (startColor.getRed() + rdiff * fullness),(int) (startColor.getGreen() + gdiff * fullness), (int) (startColor.getBlue() + bdiff * fullness));
    }
}
