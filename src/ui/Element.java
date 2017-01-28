package ui;


import java.awt.*;

public abstract class Element {
    protected Point screenPosition;
    protected Point dimensions;
    public String label;
    protected MouseOverBox mouseOverElement;
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
