package ui.bars;

import objects.Planet;
import ui.MouseOverBox;
import util.Collisions;

import java.awt.*;

import static core.Main.mouse;

public class AtmosphereBar extends PlanetStatBar{

    public AtmosphereBar(Point screenPosition, Point dimensions, Planet planet, Color startColor, Color endColor){
        super(screenPosition, dimensions, planet, startColor, endColor, "Atmosphere");
        mouseOverElement = new MouseOverBox(new Point(screenPosition.x - dimensions.x, screenPosition.y),
                new Point(100, 50), null);
    }

    @Override
    public void tick() {
        fullness = planet.atmosphere;
        if(mouseOverElement != null) mouseOverElement.label = String.format("%.4s", planet.atmosphere);
        currentColor = barColor(fullness);
    }
}
