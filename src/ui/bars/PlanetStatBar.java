package ui.bars;

import objects.Planet;
import ui.StatBar;

import java.awt.*;
import java.util.ArrayList;

class PlanetStatBar extends StatBar {
    Planet planet;
    private Color startColor;
    private Color endColor;
    PlanetStatBar(Point screenPosition, Point dimensions, Planet planet, Color startColor, Color endColor, ArrayList<String> text){
        super(screenPosition, dimensions, text);
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

    Color barColor(double fullness) {
        int rdiff = endColor.getRed() - startColor.getRed();
        int gdiff = endColor.getGreen() - startColor.getGreen();
        int bdiff = endColor.getBlue() - startColor.getBlue();
        return new Color((int) (startColor.getRed() + rdiff * fullness),(int) (startColor.getGreen() + gdiff * fullness), (int) (startColor.getBlue() + bdiff * fullness));
    }
}
