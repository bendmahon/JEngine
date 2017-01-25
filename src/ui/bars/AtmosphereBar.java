package ui.bars;

import objects.Planet;

import java.awt.*;

/**
 * Created by bendm_000 on 1/25/2017.
 */
public class AtmosphereBar extends PlanetStatBar{

    public AtmosphereBar(Point screenPosition, Point dimensions, Planet planet, Color startColor, Color endColor){
        super(screenPosition, dimensions, planet, startColor, endColor);
    }

    @Override
    public void tick() {
        fullness = planet.atmosphere;
        currentColor = barColor(fullness);
    }
}
