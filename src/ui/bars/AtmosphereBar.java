package ui.bars;

import objects.Planet;

import java.awt.*;

public class AtmosphereBar extends PlanetStatBar{

    public AtmosphereBar(Point screenPosition, Point dimensions, Planet planet, Color startColor, Color endColor){
        super(screenPosition, dimensions, planet, startColor, endColor, "Atmosphere");
    }

    @Override
    public void tick() {
        fullness = planet.atmosphere;
        currentColor = barColor(fullness);
    }
}
