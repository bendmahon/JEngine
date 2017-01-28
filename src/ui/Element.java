package ui;


import java.awt.*;

public abstract class Element {
    public Point screenPosition;
    public Point dimensions;
    public String label;
    public MouseOverBox mouseOverElement;
    public boolean mouseOver;
    Element(Point screenPosition, Point dimensions, String label){
        this.screenPosition = screenPosition;
        this.dimensions = dimensions;
        this.label = label;
        this.mouseOverElement = null;
    }
    public abstract void tick();
    public abstract void render(Graphics2D g);
}
