package ui;

import java.awt.*;

public abstract class StatBar extends Element{
    double fullness;
    Color currentColor;
    StatBar(Point screenPosition, Point dimensions){
        super(screenPosition, dimensions);
        this.currentColor = new Color(0, 0, 0);
    }

    public void render(Graphics2D g){
        g.setPaint(currentColor);
        g.drawRect(screenPosition.x, screenPosition.y, dimensions.x, dimensions.y );
        g.fillRect(screenPosition.x, (int) (screenPosition.y + dimensions.y - fullness * dimensions.y+1), dimensions.x+1, (int) (fullness * dimensions.y));
    }

    public abstract void tick();
}
