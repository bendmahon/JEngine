package ui;


import core.Clickable;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

import static core.Main.mouse;

public abstract class Element implements Clickable{
    protected Point screenPosition;
    protected Point dimensions;
//    public String label;
    public ArrayList<String> text = new ArrayList<>();
    public boolean mouseOver;
    public boolean pressed;
    public boolean clicked;
    protected MouseOverBox mouseOverElement;
    Element(Point screenPosition, Point dimensions, ArrayList<String> text){
        this.screenPosition = screenPosition;
        this.dimensions = dimensions;
        this.text = text;
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
        clicked = pressed && release && mouseCollide(mousePos);

        if(release){
            pressed = false;
        }

    }

    public abstract boolean mouseCollide(Point mousePos);
}
