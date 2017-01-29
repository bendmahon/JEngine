package ui;


import core.Clickable;

import java.awt.*;

import static core.Main.mouse;

public abstract class Element implements Clickable{
    protected Point screenPosition;
    protected Point dimensions;
    public String label;
    public boolean mouseOver;
    public boolean pressed;
    public boolean clicked;
    protected MouseOverBox mouseOverElement;
    Element(Point screenPosition, Point dimensions, String label){
        this.screenPosition = screenPosition;
        this.dimensions = dimensions;
        this.label = label;
        this.mouseOverElement = null;
        mouse.mouseObservers.add(this);
    }
    public abstract void tick();
    public abstract void render(Graphics2D g);

    public void clickNotify(Point mousePos, boolean move, boolean press, boolean release) {
        if(move){
           mouseOver = mouseCollide(mousePos);
        }
        if(press){
            if(mouseCollide(mousePos)) pressed = true;
        }
        if(release && mouseCollide(mousePos)){
            clicked = true;
        }
        if(!release){
            pressed = false;
            clicked = false;
        }

    }

    public abstract boolean mouseCollide(Point mousePos);
}
