package ui.bars;

import objects.Planet;
import ui.MouseOverBox;
import util.Collisions;

import java.awt.*;
import java.util.ArrayList;

import static core.Main.mouse;

public class AtmosphereBar extends PlanetStatBar{

    public AtmosphereBar(Point screenPosition, Point dimensions, Planet planet, Color startColor, Color endColor, ArrayList<String> text){
        super(screenPosition, dimensions, planet, startColor, endColor, text);
        mouseOverElement = new MouseOverBox(new Point(screenPosition.x - dimensions.x, screenPosition.y),
                new Point(100, 50), text);
    }

    @Override
    public void tick() {
        fullness = planet.atmosphere;
        if(mouseOverElement != null){
            mouseOverElement.text = new ArrayList<>();
            mouseOverElement.text.add(String.format("%.4s", planet.atmosphere));
        }
        currentColor = barColor(fullness);
    }
}
