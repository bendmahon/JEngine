package ui.bars;

import objects.Planet;
import ui.MouseOverBox;
import util.Collisions;

import java.awt.*;

import static core.Main.mouse;


public class TemperatureBar extends PlanetStatBar {
    public TemperatureBar(Point screenPosition, Point dimensions, Planet planet, Color startColor, Color endColor){
        super(screenPosition, dimensions, planet, startColor, endColor, "Temp");
        mouseOverElement = new MouseOverBox(new Point(screenPosition.x - dimensions.x, screenPosition.y),
                new Point(100, 50), "Temperature");
    }

    @Override
    public void tick() {
        if(Collisions.pointRectCollision(mouse.pos, new Rectangle(screenPosition.x, screenPosition.y, dimensions.x, dimensions.y))){
            mouseOver = true;
        }else{
            mouseOver = false;
        }
        fullness = planet.temperature;
        currentColor = barColor(fullness);
    }
}
