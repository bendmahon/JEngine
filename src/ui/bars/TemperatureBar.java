package ui.bars;

import objects.Planet;

import java.awt.*;


public class TemperatureBar extends PlanetStatBar {
    public TemperatureBar(Point screenPosition, Point dimensions, Planet planet, Color startColor, Color endColor){
        super(screenPosition, dimensions, planet, startColor, endColor);
    }

    @Override
    public void tick() {
        fullness = planet.temperature;
        currentColor = barColor(fullness);
    }
}
