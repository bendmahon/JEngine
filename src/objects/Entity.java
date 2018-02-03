package objects;

import core.Clickable;
import ui.MouseOverBox;

import java.awt.*;

import static core.Main.mouse;

public abstract class Entity implements Clickable{
    double x;
    double y;
    double vx;
    double vy;
    double ax;
    double ay;
    public boolean mouseOver;
    public boolean pressed;
    public boolean clicked;
    protected MouseOverBox mouseOverElement;
    Entity(double x, double y, double vx, double vy, double ax, double ay) {
        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;
        this.ax = ax;
        this.ay = ay;
        this.mouseOverElement = null;
        mouse.mouseObservers.add(this);
    }

    public abstract void tick();

    public abstract void render(Graphics2D g);
    public abstract boolean mouseCollide(Point mousePos);

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
}