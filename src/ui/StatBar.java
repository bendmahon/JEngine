package ui;

import util.Collisions;

import java.awt.*;
import java.util.ArrayList;

import static core.Main.uiElementsTopLayer;

public abstract class StatBar extends Element{
    protected double fullness;
    protected Color currentColor;
    public StatBar(Point screenPosition, Point dimensions, ArrayList<String> text){
        super(screenPosition, dimensions, text);
        this.currentColor = new Color(0, 0, 0);
        this.mouseOverElement = null;
    }

    public void render(Graphics2D g){
        g.setPaint(currentColor);
        g.drawRect(screenPosition.x, screenPosition.y, dimensions.x, dimensions.y );
        g.fillRect(screenPosition.x, (int) (screenPosition.y + dimensions.y - fullness * dimensions.y+1), dimensions.x+1, (int) (fullness * dimensions.y));
        if(text.size() != 0){
            g.drawString(text.get(0), screenPosition.x, screenPosition.y - 25);
        }
        if(mouseOver && mouseOverElement != null) uiElementsTopLayer.add(mouseOverElement);
    }

    public abstract void tick();

    @Override
    public boolean mouseCollide(Point mousePos) {
        return Collisions.pointRectCollision(mousePos, new Rectangle(screenPosition.x, screenPosition.y, dimensions.x, dimensions.y));
    }
}
