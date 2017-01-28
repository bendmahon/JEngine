package ui;

import java.awt.*;

public abstract class StatBar extends Element{
    protected double fullness;
    protected Color currentColor;
    public StatBar(Point screenPosition, Point dimensions, String label){
        super(screenPosition, dimensions, label);
        this.currentColor = new Color(0, 0, 0);
        this.mouseOverElement = new MouseOverBox(screenPosition, dimensions, "Statbar mouseoverbox");
    }

    public void render(Graphics2D g){
        g.setPaint(currentColor);
        g.drawRect(screenPosition.x, screenPosition.y, dimensions.x, dimensions.y );
        g.fillRect(screenPosition.x, (int) (screenPosition.y + dimensions.y - fullness * dimensions.y+1), dimensions.x+1, (int) (fullness * dimensions.y));
        if(label != null) g.drawString(label, screenPosition.x, screenPosition.y - 25);
        if(mouseOver) mouseOverElement.render(g);
    }

    public abstract void tick();
}
